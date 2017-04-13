// Generated from /Users/SDX/NetBeansProjects/GSP/src/parser/gspGrammar.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gspGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, NEGATION=11, TOKEN=12, EQUALS=13, WS=14, COMMENT=15;
	public static final String[] tokenNames = {
		"<INVALID>", "'ACTIONS'", "'Precond:'", "'('", "')'", "':'", "','", "'PREDICATES'", 
		"'-'", "'Effects:'", "'^'", "'!'", "TOKEN", "'='", "WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_predicates = 1, RULE_singular_predicate = 2, RULE_name = 3, 
		RULE_action_name = 4, RULE_params = 5, RULE_action_params = 6, RULE_actions = 7, 
		RULE_singular_action = 8, RULE_precond = 9, RULE_conjunction = 10, RULE_negation = 11, 
		RULE_effects = 12;
	public static final String[] ruleNames = {
		"program", "predicates", "singular_predicate", "name", "action_name", 
		"params", "action_params", "actions", "singular_action", "precond", "conjunction", 
		"negation", "effects"
	};

	@Override
	public String getGrammarFileName() { return "gspGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gspGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public PredicatesContext predicates() {
			return getRuleContext(PredicatesContext.class,0);
		}
		public ActionsContext actions() {
			return getRuleContext(ActionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); predicates();
			setState(27); actions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatesContext extends ParserRuleContext {
		public Singular_predicateContext singular_predicate(int i) {
			return getRuleContext(Singular_predicateContext.class,i);
		}
		public List<Singular_predicateContext> singular_predicate() {
			return getRuleContexts(Singular_predicateContext.class);
		}
		public PredicatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicates; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitPredicates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatesContext predicates() throws RecognitionException {
		PredicatesContext _localctx = new PredicatesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_predicates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(T__3);
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30); singular_predicate();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Singular_predicateContext extends ParserRuleContext {
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Singular_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singular_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitSingular_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Singular_predicateContext singular_predicate() throws RecognitionException {
		Singular_predicateContext _localctx = new Singular_predicateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singular_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(T__2);
			setState(36); name();
			setState(37); match(T__7);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(38); params();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode TOKEN(int i) {
			return getToken(gspGrammarParser.TOKEN, i);
		}
		public List<TerminalNode> TOKEN() { return getTokens(gspGrammarParser.TOKEN); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46); match(TOKEN);
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Action_nameContext extends ParserRuleContext {
		public TerminalNode TOKEN(int i) {
			return getToken(gspGrammarParser.TOKEN, i);
		}
		public List<TerminalNode> TOKEN() { return getTokens(gspGrammarParser.TOKEN); }
		public Action_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitAction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_nameContext action_name() throws RecognitionException {
		Action_nameContext _localctx = new Action_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51); match(TOKEN);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public TerminalNode TOKEN() { return getToken(gspGrammarParser.TOKEN, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(TOKEN);
			setState(58);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(57); match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Action_paramsContext extends ParserRuleContext {
		public TerminalNode TOKEN() { return getToken(gspGrammarParser.TOKEN, 0); }
		public Action_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitAction_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_paramsContext action_params() throws RecognitionException {
		Action_paramsContext _localctx = new Action_paramsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_action_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(TOKEN);
			setState(62);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(61); match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionsContext extends ParserRuleContext {
		public List<Singular_actionContext> singular_action() {
			return getRuleContexts(Singular_actionContext.class);
		}
		public Singular_actionContext singular_action(int i) {
			return getRuleContext(Singular_actionContext.class,i);
		}
		public ActionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitActions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionsContext actions() throws RecognitionException {
		ActionsContext _localctx = new ActionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_actions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(T__9);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65); singular_action();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Singular_actionContext extends ParserRuleContext {
		public EffectsContext effects() {
			return getRuleContext(EffectsContext.class,0);
		}
		public PrecondContext precond() {
			return getRuleContext(PrecondContext.class,0);
		}
		public Action_paramsContext action_params(int i) {
			return getRuleContext(Action_paramsContext.class,i);
		}
		public Action_nameContext action_name() {
			return getRuleContext(Action_nameContext.class,0);
		}
		public List<Action_paramsContext> action_params() {
			return getRuleContexts(Action_paramsContext.class);
		}
		public Singular_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singular_action; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitSingular_action(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Singular_actionContext singular_action() throws RecognitionException {
		Singular_actionContext _localctx = new Singular_actionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_singular_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(T__2);
			setState(71); action_name();
			setState(72); match(T__7);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(73); action_params();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79); match(T__6);
			setState(80); match(T__5);
			setState(81); precond();
			setState(82); effects();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrecondContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public PrecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitPrecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecondContext precond() throws RecognitionException {
		PrecondContext _localctx = new PrecondContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_precond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(T__8);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85); conjunction();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEGATION || _la==TOKEN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public Action_paramsContext action_params(int i) {
			return getRuleContext(Action_paramsContext.class,i);
		}
		public Action_nameContext action_name() {
			return getRuleContext(Action_nameContext.class,0);
		}
		public List<Action_paramsContext> action_params() {
			return getRuleContexts(Action_paramsContext.class);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(91);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(90); negation();
				}
			}

			setState(93); action_name();
			setState(94); match(T__7);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(95); action_params();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(T__6);
			}
			setState(104);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(103); match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegationContext extends ParserRuleContext {
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(NEGATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EffectsContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public EffectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effects; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gspGrammarVisitor ) return ((gspGrammarVisitor<? extends T>)visitor).visitEffects(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectsContext effects() throws RecognitionException {
		EffectsContext _localctx = new EffectsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_effects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(T__1);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109); conjunction();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEGATION || _la==TOKEN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\6\3\"\n\3\r\3\16\3#\3\4\3"+
		"\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\6\5\62\n\5\r\5\16\5\63"+
		"\3\6\6\6\67\n\6\r\6\16\68\3\7\3\7\5\7=\n\7\3\b\3\b\5\bA\n\b\3\t\3\t\6"+
		"\tE\n\t\r\t\16\tF\3\n\3\n\3\n\3\n\7\nM\n\n\f\n\16\nP\13\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\6\13Y\n\13\r\13\16\13Z\3\f\5\f^\n\f\3\f\3\f\3\f\7\f"+
		"c\n\f\f\f\16\ff\13\f\3\f\3\f\3\f\5\fk\n\f\3\r\3\r\3\16\3\16\6\16q\n\16"+
		"\r\16\16\16r\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2t\2\34\3"+
		"\2\2\2\4\37\3\2\2\2\6%\3\2\2\2\b\61\3\2\2\2\n\66\3\2\2\2\f:\3\2\2\2\16"+
		">\3\2\2\2\20B\3\2\2\2\22H\3\2\2\2\24V\3\2\2\2\26]\3\2\2\2\30l\3\2\2\2"+
		"\32n\3\2\2\2\34\35\5\4\3\2\35\36\5\20\t\2\36\3\3\2\2\2\37!\7\t\2\2 \""+
		"\5\6\4\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\7\n\2\2"+
		"&\'\5\b\5\2\'+\7\5\2\2(*\5\f\7\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2"+
		"\2,.\3\2\2\2-+\3\2\2\2./\7\6\2\2/\7\3\2\2\2\60\62\7\16\2\2\61\60\3\2\2"+
		"\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\t\3\2\2\2\65\67\7\16\2"+
		"\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\13\3\2\2\2:<\7\16"+
		"\2\2;=\7\b\2\2<;\3\2\2\2<=\3\2\2\2=\r\3\2\2\2>@\7\16\2\2?A\7\b\2\2@?\3"+
		"\2\2\2@A\3\2\2\2A\17\3\2\2\2BD\7\3\2\2CE\5\22\n\2DC\3\2\2\2EF\3\2\2\2"+
		"FD\3\2\2\2FG\3\2\2\2G\21\3\2\2\2HI\7\n\2\2IJ\5\n\6\2JN\7\5\2\2KM\5\16"+
		"\b\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\6"+
		"\2\2RS\7\7\2\2ST\5\24\13\2TU\5\32\16\2U\23\3\2\2\2VX\7\4\2\2WY\5\26\f"+
		"\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\25\3\2\2\2\\^\5\30\r\2]\\"+
		"\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\5\n\6\2`d\7\5\2\2ac\5\16\b\2ba\3\2\2\2"+
		"cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\6\2\2hj\3\2\2\2"+
		"ik\7\f\2\2ji\3\2\2\2jk\3\2\2\2k\27\3\2\2\2lm\7\r\2\2m\31\3\2\2\2np\7\13"+
		"\2\2oq\5\26\f\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\33\3\2\2\2\17"+
		"#+\638<@FNZ]djr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}