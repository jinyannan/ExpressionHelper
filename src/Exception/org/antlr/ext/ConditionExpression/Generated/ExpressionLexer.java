// $ANTLR 3.5.1 D:\\antlr\\Expression.g 2015-03-17 16:34:23
package org.antlr.ext.ConditionExpression.Generated;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExpressionLexer extends Lexer {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int COMMA=5;
	public static final int DATA=6;
	public static final int DIV=7;
	public static final int DOT=8;
	public static final int Digit=9;
	public static final int EQUALS=10;
	public static final int EXPRESSION=11;
	public static final int FIELD=12;
	public static final int FUNCTION=13;
	public static final int GT=14;
	public static final int GTEQ=15;
	public static final int IDENTIFIER=16;
	public static final int INDEX=17;
	public static final int LBRACKET=18;
	public static final int LETTER=19;
	public static final int LPAREN=20;
	public static final int LT=21;
	public static final int LTEQ=22;
	public static final int MEMBERACCESS=23;
	public static final int MINUS=24;
	public static final int MUL=25;
	public static final int NOT=26;
	public static final int NOTEQUALS=27;
	public static final int OR=28;
	public static final int PLUS=29;
	public static final int POW=30;
	public static final int RBRACKET=31;
	public static final int RPAREN=32;
	public static final int TYPE_BOOLEAN=33;
	public static final int TYPE_DATETIME=34;
	public static final int TYPE_DOUBLE=35;
	public static final int TYPE_INTEGER=36;
	public static final int TYPE_STRING=37;
	public static final int UNARY=38;
	public static final int WS=39;
	public static final int ZERO=40;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExpressionLexer() {} 
	public ExpressionLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExpressionLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\antlr\\Expression.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:139:3: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) | '&&' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='A'||LA1_0=='a') ) {
				alt1=1;
			}
			else if ( (LA1_0=='&') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// D:\\antlr\\Expression.g:139:5: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
					{
					if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:139:37: '&&'
					{
					match("&&"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:143:3: ( ( 'o' | 'O' ) ( 'r' | 'R' ) | '||' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='O'||LA2_0=='o') ) {
				alt2=1;
			}
			else if ( (LA2_0=='|') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// D:\\antlr\\Expression.g:143:7: ( 'o' | 'O' ) ( 'r' | 'R' )
					{
					if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:143:28: '||'
					{
					match("||"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:147:3: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' ) | '!' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='N'||LA3_0=='n') ) {
				alt3=1;
			}
			else if ( (LA3_0=='!') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// D:\\antlr\\Expression.g:147:7: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' )
					{
					if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:147:37: '!'
					{
					match('!'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:151:3: ( ',' )
			// D:\\antlr\\Expression.g:151:7: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:155:3: ( '.' )
			// D:\\antlr\\Expression.g:155:5: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:159:3: ( '+' )
			// D:\\antlr\\Expression.g:159:7: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:163:3: ( '-' )
			// D:\\antlr\\Expression.g:163:7: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:167:3: ( '*' )
			// D:\\antlr\\Expression.g:167:7: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:171:3: ( '/' )
			// D:\\antlr\\Expression.g:171:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:175:3: ( '^' )
			// D:\\antlr\\Expression.g:175:5: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POW"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:182:9: ( '=' | '==' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='=') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1=='=') ) {
					alt4=2;
				}

				else {
					alt4=1;
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// D:\\antlr\\Expression.g:182:11: '='
					{
					match('='); 
					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:182:17: '=='
					{
					match("=="); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "NOTEQUALS"
	public final void mNOTEQUALS() throws RecognitionException {
		try {
			int _type = NOTEQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:185:3: ( '!=' | '<>' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='!') ) {
				alt5=1;
			}
			else if ( (LA5_0=='<') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// D:\\antlr\\Expression.g:185:5: '!='
					{
					match("!="); 

					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:185:12: '<>'
					{
					match("<>"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQUALS"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:187:5: ( '<' )
			// D:\\antlr\\Expression.g:187:7: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTEQ"
	public final void mLTEQ() throws RecognitionException {
		try {
			int _type = LTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:189:3: ( '<=' )
			// D:\\antlr\\Expression.g:189:5: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTEQ"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:191:5: ( '>' )
			// D:\\antlr\\Expression.g:191:7: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTEQ"
	public final void mGTEQ() throws RecognitionException {
		try {
			int _type = GTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:193:3: ( '>=' )
			// D:\\antlr\\Expression.g:193:5: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTEQ"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:197:3: ( '(' )
			// D:\\antlr\\Expression.g:197:5: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:200:9: ( ')' )
			// D:\\antlr\\Expression.g:200:11: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACKET"
	public final void mLBRACKET() throws RecognitionException {
		try {
			int _type = LBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:204:3: ( '[' )
			// D:\\antlr\\Expression.g:204:5: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACKET"

	// $ANTLR start "RBRACKET"
	public final void mRBRACKET() throws RecognitionException {
		try {
			int _type = RBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:208:3: ( ']' )
			// D:\\antlr\\Expression.g:208:5: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACKET"

	// $ANTLR start "TYPE_DATETIME"
	public final void mTYPE_DATETIME() throws RecognitionException {
		try {
			int _type = TYPE_DATETIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:212:3: ( '#' (~ '#' )+ '#' )
			// D:\\antlr\\Expression.g:212:7: '#' (~ '#' )+ '#'
			{
			match('#'); 
			// D:\\antlr\\Expression.g:212:11: (~ '#' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\"')||(LA6_0 >= '$' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// D:\\antlr\\Expression.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\"')||(input.LA(1) >= '$' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_DATETIME"

	// $ANTLR start "TYPE_STRING"
	public final void mTYPE_STRING() throws RecognitionException {
		try {
			int _type = TYPE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:216:3: ( '\"' (~ '\"' )* '\"' )
			// D:\\antlr\\Expression.g:216:5: '\"' (~ '\"' )* '\"'
			{
			match('\"'); 
			// D:\\antlr\\Expression.g:216:9: (~ '\"' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// D:\\antlr\\Expression.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_STRING"

	// $ANTLR start "TYPE_BOOLEAN"
	public final void mTYPE_BOOLEAN() throws RecognitionException {
		try {
			int _type = TYPE_BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:220:3: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' ) | ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'e' | 'E' ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='T'||LA8_0=='t') ) {
				alt8=1;
			}
			else if ( (LA8_0=='F'||LA8_0=='f') ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// D:\\antlr\\Expression.g:220:8: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' )
					{
					if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:221:8: ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'e' | 'E' )
					{
					if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_BOOLEAN"

	// $ANTLR start "DATA"
	public final void mDATA() throws RecognitionException {
		try {
			int _type = DATA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:224:3: ( '$' IDENTIFIER )
			// D:\\antlr\\Expression.g:224:5: '$' IDENTIFIER
			{
			match('$'); 
			mIDENTIFIER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATA"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:228:3: ( LETTER ( LETTER | Digit )* )
			// D:\\antlr\\Expression.g:228:5: LETTER ( LETTER | Digit )*
			{
			mLETTER(); 

			// D:\\antlr\\Expression.g:228:12: ( LETTER | Digit )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// D:\\antlr\\Expression.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "TYPE_DOUBLE"
	public final void mTYPE_DOUBLE() throws RecognitionException {
		try {
			int _type = TYPE_DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:232:3: ( ( Digit )+ '.' ( Digit )* | '.' ( Digit )+ )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
				alt13=1;
			}
			else if ( (LA13_0=='.') ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// D:\\antlr\\Expression.g:232:7: ( Digit )+ '.' ( Digit )*
					{
					// D:\\antlr\\Expression.g:232:7: ( Digit )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// D:\\antlr\\Expression.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					match('.'); 
					// D:\\antlr\\Expression.g:232:18: ( Digit )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// D:\\antlr\\Expression.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;
				case 2 :
					// D:\\antlr\\Expression.g:233:7: '.' ( Digit )+
					{
					match('.'); 
					// D:\\antlr\\Expression.g:233:11: ( Digit )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// D:\\antlr\\Expression.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_DOUBLE"

	// $ANTLR start "TYPE_INTEGER"
	public final void mTYPE_INTEGER() throws RecognitionException {
		try {
			int _type = TYPE_INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:237:3: ( ( Digit )+ )
			// D:\\antlr\\Expression.g:237:7: ( Digit )+
			{
			// D:\\antlr\\Expression.g:237:7: ( Digit )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// D:\\antlr\\Expression.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_INTEGER"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// D:\\antlr\\Expression.g:243:3: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
			// D:\\antlr\\Expression.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "Digit"
	public final void mDigit() throws RecognitionException {
		try {
			// D:\\antlr\\Expression.g:248:3: ( '0' .. '9' )
			// D:\\antlr\\Expression.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Digit"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\antlr\\Expression.g:252:3: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+ )
			// D:\\antlr\\Expression.g:252:6: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+
			{
			// D:\\antlr\\Expression.g:252:6: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '\t' && LA15_0 <= '\n')||(LA15_0 >= '\f' && LA15_0 <= '\r')||LA15_0==' ') ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// D:\\antlr\\Expression.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\antlr\\Expression.g:1:8: ( AND | OR | NOT | COMMA | DOT | PLUS | MINUS | MUL | DIV | POW | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | LPAREN | RPAREN | LBRACKET | RBRACKET | TYPE_DATETIME | TYPE_STRING | TYPE_BOOLEAN | DATA | IDENTIFIER | TYPE_DOUBLE | TYPE_INTEGER | WS )
		int alt16=28;
		alt16 = dfa16.predict(input);
		switch (alt16) {
			case 1 :
				// D:\\antlr\\Expression.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// D:\\antlr\\Expression.g:1:14: OR
				{
				mOR(); 

				}
				break;
			case 3 :
				// D:\\antlr\\Expression.g:1:17: NOT
				{
				mNOT(); 

				}
				break;
			case 4 :
				// D:\\antlr\\Expression.g:1:21: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 5 :
				// D:\\antlr\\Expression.g:1:27: DOT
				{
				mDOT(); 

				}
				break;
			case 6 :
				// D:\\antlr\\Expression.g:1:31: PLUS
				{
				mPLUS(); 

				}
				break;
			case 7 :
				// D:\\antlr\\Expression.g:1:36: MINUS
				{
				mMINUS(); 

				}
				break;
			case 8 :
				// D:\\antlr\\Expression.g:1:42: MUL
				{
				mMUL(); 

				}
				break;
			case 9 :
				// D:\\antlr\\Expression.g:1:46: DIV
				{
				mDIV(); 

				}
				break;
			case 10 :
				// D:\\antlr\\Expression.g:1:50: POW
				{
				mPOW(); 

				}
				break;
			case 11 :
				// D:\\antlr\\Expression.g:1:54: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 12 :
				// D:\\antlr\\Expression.g:1:61: NOTEQUALS
				{
				mNOTEQUALS(); 

				}
				break;
			case 13 :
				// D:\\antlr\\Expression.g:1:71: LT
				{
				mLT(); 

				}
				break;
			case 14 :
				// D:\\antlr\\Expression.g:1:74: LTEQ
				{
				mLTEQ(); 

				}
				break;
			case 15 :
				// D:\\antlr\\Expression.g:1:79: GT
				{
				mGT(); 

				}
				break;
			case 16 :
				// D:\\antlr\\Expression.g:1:82: GTEQ
				{
				mGTEQ(); 

				}
				break;
			case 17 :
				// D:\\antlr\\Expression.g:1:87: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 18 :
				// D:\\antlr\\Expression.g:1:94: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 19 :
				// D:\\antlr\\Expression.g:1:101: LBRACKET
				{
				mLBRACKET(); 

				}
				break;
			case 20 :
				// D:\\antlr\\Expression.g:1:110: RBRACKET
				{
				mRBRACKET(); 

				}
				break;
			case 21 :
				// D:\\antlr\\Expression.g:1:119: TYPE_DATETIME
				{
				mTYPE_DATETIME(); 

				}
				break;
			case 22 :
				// D:\\antlr\\Expression.g:1:133: TYPE_STRING
				{
				mTYPE_STRING(); 

				}
				break;
			case 23 :
				// D:\\antlr\\Expression.g:1:145: TYPE_BOOLEAN
				{
				mTYPE_BOOLEAN(); 

				}
				break;
			case 24 :
				// D:\\antlr\\Expression.g:1:158: DATA
				{
				mDATA(); 

				}
				break;
			case 25 :
				// D:\\antlr\\Expression.g:1:163: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 26 :
				// D:\\antlr\\Expression.g:1:174: TYPE_DOUBLE
				{
				mTYPE_DOUBLE(); 

				}
				break;
			case 27 :
				// D:\\antlr\\Expression.g:1:186: TYPE_INTEGER
				{
				mTYPE_INTEGER(); 

				}
				break;
			case 28 :
				// D:\\antlr\\Expression.g:1:199: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA16 dfa16 = new DFA16(this);
	static final String DFA16_eotS =
		"\1\uffff\1\32\1\uffff\1\32\1\uffff\1\32\1\41\1\uffff\1\42\6\uffff\1\45"+
		"\1\47\6\uffff\2\32\2\uffff\1\52\1\uffff\1\32\1\4\1\32\10\uffff\2\32\1"+
		"\uffff\1\2\1\41\2\32\1\61\1\32\1\uffff\1\61";
	static final String DFA16_eofS =
		"\63\uffff";
	static final String DFA16_minS =
		"\1\11\1\116\1\uffff\1\122\1\uffff\1\117\1\75\1\uffff\1\60\6\uffff\2\75"+
		"\6\uffff\1\122\1\101\2\uffff\1\56\1\uffff\1\104\1\60\1\124\10\uffff\1"+
		"\125\1\114\1\uffff\2\60\1\105\1\123\1\60\1\105\1\uffff\1\60";
	static final String DFA16_maxS =
		"\1\174\1\156\1\uffff\1\162\1\uffff\1\157\1\75\1\uffff\1\71\6\uffff\1\76"+
		"\1\75\6\uffff\1\162\1\141\2\uffff\1\71\1\uffff\1\144\1\172\1\164\10\uffff"+
		"\1\165\1\154\1\uffff\2\172\1\145\1\163\1\172\1\145\1\uffff\1\172";
	static final String DFA16_acceptS =
		"\2\uffff\1\1\1\uffff\1\2\2\uffff\1\4\1\uffff\1\6\1\7\1\10\1\11\1\12\1"+
		"\13\2\uffff\1\21\1\22\1\23\1\24\1\25\1\26\2\uffff\1\30\1\31\1\uffff\1"+
		"\34\3\uffff\1\14\1\3\1\5\1\32\1\16\1\15\1\20\1\17\2\uffff\1\33\6\uffff"+
		"\1\27\1\uffff";
	static final String DFA16_specialS =
		"\63\uffff}>";
	static final String[] DFA16_transitionS = {
			"\2\34\1\uffff\2\34\22\uffff\1\34\1\6\1\26\1\25\1\31\1\uffff\1\2\1\uffff"+
			"\1\21\1\22\1\13\1\11\1\7\1\12\1\10\1\14\12\33\2\uffff\1\17\1\16\1\20"+
			"\2\uffff\1\1\4\32\1\30\7\32\1\5\1\3\4\32\1\27\6\32\1\23\1\uffff\1\24"+
			"\1\15\1\32\1\uffff\1\1\4\32\1\30\7\32\1\5\1\3\4\32\1\27\6\32\1\uffff"+
			"\1\4",
			"\1\35\37\uffff\1\35",
			"",
			"\1\36\37\uffff\1\36",
			"",
			"\1\37\37\uffff\1\37",
			"\1\40",
			"",
			"\12\43",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\44\1\40",
			"\1\46",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\50\37\uffff\1\50",
			"\1\51\37\uffff\1\51",
			"",
			"",
			"\1\43\1\uffff\12\33",
			"",
			"\1\53\37\uffff\1\53",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\54\37\uffff\1\54",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\55\37\uffff\1\55",
			"\1\56\37\uffff\1\56",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\57\37\uffff\1\57",
			"\1\60\37\uffff\1\60",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\62\37\uffff\1\62",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32"
	};

	static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
	static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
	static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
	static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
	static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
	static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
	static final short[][] DFA16_transition;

	static {
		int numStates = DFA16_transitionS.length;
		DFA16_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
		}
	}

	protected class DFA16 extends DFA {

		public DFA16(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 16;
			this.eot = DFA16_eot;
			this.eof = DFA16_eof;
			this.min = DFA16_min;
			this.max = DFA16_max;
			this.accept = DFA16_accept;
			this.special = DFA16_special;
			this.transition = DFA16_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | OR | NOT | COMMA | DOT | PLUS | MINUS | MUL | DIV | POW | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | LPAREN | RPAREN | LBRACKET | RBRACKET | TYPE_DATETIME | TYPE_STRING | TYPE_BOOLEAN | DATA | IDENTIFIER | TYPE_DOUBLE | TYPE_INTEGER | WS );";
		}
	}

	 ArrayList exceptions = new ArrayList();

   public Override  ReportError(RecognitionException e)
   {
       exceptions.add(e);
		 return null;
   }

   public Override  DisplayRecognitionError(String[] tokenNames, RecognitionException e)
   {
       return DisplayRecognitionError(tokenNames, e);
   }


   public Boolean HasError()
   {
       return exceptions.size() > 0; 
   }

   public String GetErrorMessage()
   {

           StringBuilder sb = new StringBuilder();
           for (Object m : exceptions)
           {
               RecognitionException t = (RecognitionException) m;
               sb.append(String.format("Œª÷√:{0}£¨¥ÌŒÛ:{1}\r\n", 
                   this.getErrorHeader(t), 
                   this.getErrorMessage(t, this.getTokenNames())));
           }
           return sb.toString(); 
   }
	
   
   
}
