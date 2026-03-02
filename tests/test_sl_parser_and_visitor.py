import pytest

from peak_acl.sl import sl0, sl_parser, sl_visitor


def test_sl_parser_known_limitations_and_dumps_fallback():
    with pytest.raises(AttributeError, match="msg"):
        sl_parser.parse('(foo "bar")')

    class T:
        def getText(self):
            return "(x)"

    assert sl_parser.dumps(T()) == "(x)"
    assert sl_parser.dumps(object()).startswith("<object object")


class _Ctx:
    def __init__(self, text="ctx"):
        self._text = text

    def getText(self):
        return self._text


class _SlotCtx:
    class _Name:
        @staticmethod
        def getText():
            return "name"

    @staticmethod
    def NAME():
        return _SlotCtx._Name()

    @staticmethod
    def term():
        return _Ctx("inner")


def test_debug_visitor_and_ast_builder_basic(monkeypatch, capsys):
    dbg = sl_parser._DebugVisitor()
    with pytest.raises(AttributeError, match="visitEveryRule"):
        dbg.visitEveryRule(_Ctx("hello"))
    assert "hello" in capsys.readouterr().out

    builder = sl_visitor.ASTBuilder()
    monkeypatch.setattr(
        builder, "visit", lambda term: sl_visitor.SLString(term.getText())
    )
    slot = builder.visitSlot(_SlotCtx())
    assert slot[0] == "name"
    assert isinstance(slot[1], sl_visitor.SLString)


def test_ast_builder_term_and_fallbacks():
    builder = sl_visitor.ASTBuilder()

    class TermCtx:
        def stringLiteral(self):
            return None

        def numberLiteral(self):
            return None

        def variable(self):
            return None

        def functionExpr(self):
            return None

        def actionExpr(self):
            return None

    with pytest.raises(ValueError):
        builder.visitTerm(TermCtx())

    assert builder.defaultResult() is None
    assert builder.aggregateResult("a", None) == "a"
    assert builder.aggregateResult("a", "b") == "b"


def test_sl0_roundtrip_and_error_paths():
    me = sl0.AgentIdentifier("me", ["http://me/acc"])
    df = sl0.AgentIdentifier("df", ["http://df/acc"])
    content = sl0.build_register_content(me, [("echo", "tool")], df=df)
    parsed = sl0.loads(content)

    assert isinstance(parsed, sl0.Action)
    assert isinstance(parsed.act, sl0.Register)
    assert sl0.is_done(sl0.Done("x"))
    assert sl0.is_failure(sl0.Failure("x"))
    assert sl0.is_result(sl0.Result("w", "v"))

    with pytest.raises(ValueError):
        sl0.loads("(")
    with pytest.raises(ValueError):
        sl0.loads(")")


@pytest.mark.parametrize(
    "expr, expected",
    [
        ("(search (df-agent-description) 5)", 5),
        ("(search (df-agent-description) bad)", None),
    ],
)
def test_sl0_search_max_results(expr, expected):
    parsed = sl0.loads(expr)
    assert isinstance(parsed, sl0.Search)
    assert parsed.max_results == expected
