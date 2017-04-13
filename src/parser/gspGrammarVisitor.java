// Generated from /Users/SDX/NetBeansProjects/GSP/src/parser/gspGrammar.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gspGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gspGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#init_goals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_goals(@NotNull gspGrammarParser.Init_goalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(@NotNull gspGrammarParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#init_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_states(@NotNull gspGrammarParser.Init_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#multiple_action_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_action_params(@NotNull gspGrammarParser.Multiple_action_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#initial_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_state(@NotNull gspGrammarParser.Initial_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#precond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond(@NotNull gspGrammarParser.PrecondContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull gspGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(@NotNull gspGrammarParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#action_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_params(@NotNull gspGrammarParser.Action_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#predicates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicates(@NotNull gspGrammarParser.PredicatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#effects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffects(@NotNull gspGrammarParser.EffectsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#singular_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingular_predicate(@NotNull gspGrammarParser.Singular_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(@NotNull gspGrammarParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#action_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_name(@NotNull gspGrammarParser.Action_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#goal_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal_state(@NotNull gspGrammarParser.Goal_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull gspGrammarParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#multiple_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_params(@NotNull gspGrammarParser.Multiple_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#init_goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_goal(@NotNull gspGrammarParser.Init_goalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActions(@NotNull gspGrammarParser.ActionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#singular_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingular_action(@NotNull gspGrammarParser.Singular_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gspGrammarParser#init_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_state(@NotNull gspGrammarParser.Init_stateContext ctx);
}