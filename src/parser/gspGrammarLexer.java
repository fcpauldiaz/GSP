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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, NEGATION=11, TOKEN=12, EQUALS=13, WS=14, COMMENT=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "LETTER", "NEGATION", "TOKEN", "EQUALS", "WS", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\6\20^\n\20\r\20\16\20_\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\7\21h\n\21\f\21\16\21k\13\21\3\21\5\21n\n\21\3\21\3\21\3\21\3\21\3"+
		"\21\7\21u\n\21\f\21\16\21x\13\21\3\21\3\21\5\21|\n\21\3\21\3\21\3v\2\22"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r\33\16\35\17\37"+
		"\20!\21\3\2\5\4\2C\\c|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0082\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5+\3\2\2\2\7\64\3"+
		"\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21G\3\2\2\2\23"+
		"I\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2"+
		"\37]\3\2\2\2!{\3\2\2\2#$\7C\2\2$%\7E\2\2%&\7V\2\2&\'\7K\2\2\'(\7Q\2\2"+
		"()\7P\2\2)*\7U\2\2*\4\3\2\2\2+,\7R\2\2,-\7t\2\2-.\7g\2\2./\7e\2\2/\60"+
		"\7q\2\2\60\61\7p\2\2\61\62\7f\2\2\62\63\7<\2\2\63\6\3\2\2\2\64\65\7*\2"+
		"\2\65\b\3\2\2\2\66\67\7+\2\2\67\n\3\2\2\289\7<\2\29\f\3\2\2\2:;\7.\2\2"+
		";\16\3\2\2\2<=\7R\2\2=>\7T\2\2>?\7G\2\2?@\7F\2\2@A\7K\2\2AB\7E\2\2BC\7"+
		"C\2\2CD\7V\2\2DE\7G\2\2EF\7U\2\2F\20\3\2\2\2GH\7/\2\2H\22\3\2\2\2IJ\7"+
		"G\2\2JK\7h\2\2KL\7h\2\2LM\7g\2\2MN\7e\2\2NO\7v\2\2OP\7u\2\2PQ\7<\2\2Q"+
		"\24\3\2\2\2RS\7`\2\2S\26\3\2\2\2TU\t\2\2\2U\30\3\2\2\2VW\7#\2\2W\32\3"+
		"\2\2\2XY\5\27\f\2Y\34\3\2\2\2Z[\7?\2\2[\36\3\2\2\2\\^\t\3\2\2]\\\3\2\2"+
		"\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\b\20\2\2b \3\2\2\2cd\7\61"+
		"\2\2de\7\61\2\2ei\3\2\2\2fh\n\4\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2jm\3\2\2\2ki\3\2\2\2ln\7\17\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2o|"+
		"\7\f\2\2pq\7\61\2\2qr\7,\2\2rv\3\2\2\2su\13\2\2\2ts\3\2\2\2ux\3\2\2\2"+
		"vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7,\2\2z|\7\61\2\2{c\3\2\2\2"+
		"{p\3\2\2\2|}\3\2\2\2}~\b\21\2\2~\"\3\2\2\2\b\2_imv{\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}