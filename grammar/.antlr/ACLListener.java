// Generated from c:/Users/santi/Desktop/dev_preak-acl/grammar/ACL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ACLParser}.
 */
public interface ACLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ACLmessage}
	 * labeled alternative in {@link ACLParser#message}.
	 * @param ctx the parse tree
	 */
	void enterACLmessage(ACLParser.ACLmessageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ACLmessage}
	 * labeled alternative in {@link ACLParser#message}.
	 * @param ctx the parse tree
	 */
	void exitACLmessage(ACLParser.ACLmessageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ACLperformative}
	 * labeled alternative in {@link ACLParser#performative}.
	 * @param ctx the parse tree
	 */
	void enterACLperformative(ACLParser.ACLperformativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ACLperformative}
	 * labeled alternative in {@link ACLParser#performative}.
	 * @param ctx the parse tree
	 */
	void exitACLperformative(ACLParser.ACLperformativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ACLparam}
	 * labeled alternative in {@link ACLParser#param}.
	 * @param ctx the parse tree
	 */
	void enterACLparam(ACLParser.ACLparamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ACLparam}
	 * labeled alternative in {@link ACLParser#param}.
	 * @param ctx the parse tree
	 */
	void exitACLparam(ACLParser.ACLparamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ACLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ACLParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(ACLParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(ACLParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedMessage}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNestedMessage(ACLParser.NestedMessageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedMessage}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNestedMessage(ACLParser.NestedMessageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterListValue(ACLParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link ACLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitListValue(ACLParser.ListValueContext ctx);
}