// Generated from /Users/SDX/NetBeansProjects/GSP/src/parser/gspGrammar.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gspGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, NEGATION=13, TOKEN=14, EQUALS=15, WS=16, COMMENT=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "LETTER", "NEGATION", "TOKEN", "EQUALS", "WS", 
		"COMMENT"
	};


	public gspGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gspGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\6\22q\n\22\r\22\16\22r\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\7\23{\n\23\f\23\16\23~\13\23\3\23\5\23\u0081\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\7\23\u0088\n\23\f\23\16\23\u008b\13\23\3"+
		"\23\3\23\5\23\u008f\n\23\3\23\3\23\3\u0089\2\24\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35\17\37\20!\21#\22%\23\3\2\5"+
		"\4\2C\\c|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0095\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5\60\3"+
		"\2\2\2\7\66\3\2\2\2\t8\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17K\3\2\2\2\21T"+
		"\3\2\2\2\23V\3\2\2\2\25X\3\2\2\2\27Z\3\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35"+
		"i\3\2\2\2\37k\3\2\2\2!m\3\2\2\2#p\3\2\2\2%\u008e\3\2\2\2\'(\7K\2\2()\7"+
		"P\2\2)*\7K\2\2*+\7V\2\2+,\7K\2\2,-\7C\2\2-.\7N\2\2./\7<\2\2/\4\3\2\2\2"+
		"\60\61\7I\2\2\61\62\7Q\2\2\62\63\7C\2\2\63\64\7N\2\2\64\65\7<\2\2\65\6"+
		"\3\2\2\2\66\67\7<\2\2\67\b\3\2\2\289\7G\2\29:\7h\2\2:;\7h\2\2;<\7g\2\2"+
		"<=\7e\2\2=>\7v\2\2>?\7u\2\2?@\7<\2\2@\n\3\2\2\2AB\7`\2\2B\f\3\2\2\2CD"+
		"\7C\2\2DE\7E\2\2EF\7V\2\2FG\7K\2\2GH\7Q\2\2HI\7P\2\2IJ\7U\2\2J\16\3\2"+
		"\2\2KL\7R\2\2LM\7t\2\2MN\7g\2\2NO\7e\2\2OP\7q\2\2PQ\7p\2\2QR\7f\2\2RS"+
		"\7<\2\2S\20\3\2\2\2TU\7*\2\2U\22\3\2\2\2VW\7+\2\2W\24\3\2\2\2XY\7.\2\2"+
		"Y\26\3\2\2\2Z[\7R\2\2[\\\7T\2\2\\]\7G\2\2]^\7F\2\2^_\7K\2\2_`\7E\2\2`"+
		"a\7C\2\2ab\7V\2\2bc\7G\2\2cd\7U\2\2d\30\3\2\2\2ef\7/\2\2f\32\3\2\2\2g"+
		"h\t\2\2\2h\34\3\2\2\2ij\7#\2\2j\36\3\2\2\2kl\5\33\16\2l \3\2\2\2mn\7?"+
		"\2\2n\"\3\2\2\2oq\t\3\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3"+
		"\2\2\2tu\b\22\2\2u$\3\2\2\2vw\7\61\2\2wx\7\61\2\2x|\3\2\2\2y{\n\4\2\2"+
		"zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177"+
		"\u0081\7\17\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u008f\7\f\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7,\2\2\u0085"+
		"\u0089\3\2\2\2\u0086\u0088\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\7,\2\2\u008d\u008f\7\61\2\2\u008ev\3\2\2\2"+
		"\u008e\u0083\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\23\2\2\u0091&\3"+
		"\2\2\2\b\2r|\u0080\u0089\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}