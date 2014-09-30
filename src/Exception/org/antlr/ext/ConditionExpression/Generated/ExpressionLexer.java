// $ANTLR 3.5.2 Expression.g 2014-09-01 15:44:06
package org.antlr.ext.ConditionExpression.Generated;

import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExpressionLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__40=40;
	public static final int AND=4;
	public static final int COMMA=5;
	public static final int DATA=6;
	public static final int DIV=7;
	public static final int Digit=8;
	public static final int EQUALS=9;
	public static final int EXPRESSION=10;
	public static final int FIELD=11;
	public static final int FUNCTION=12;
	public static final int GT=13;
	public static final int GTEQ=14;
	public static final int IDENTIFIER=15;
	public static final int INDEX=16;
	public static final int LBRACKET=17;
	public static final int LETTER=18;
	public static final int LPAREN=19;
	public static final int LT=20;
	public static final int LTEQ=21;
	public static final int MEMBERACCESS=22;
	public static final int MINUS=23;
	public static final int MUL=24;
	public static final int NOT=25;
	public static final int NOTEQUALS=26;
	public static final int OR=27;
	public static final int PLUS=28;
	public static final int POW=29;
	public static final int RBRACKET=30;
	public static final int RPAREN=31;
	public static final int TYPE_BOOLEAN=32;
	public static final int TYPE_DATETIME=33;
	public static final int TYPE_DOUBLE=34;
	public static final int TYPE_INTEGER=35;
	public static final int TYPE_STRING=36;
	public static final int UNARY=37;
	public static final int WS=38;
	public static final int ZERO=39;

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
	@Override public String getGrammarFileName() { return "Expression.g"; }

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expression.g:9:7: ( '.' )
			// Expression.g:9:9: '.'
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
	// $ANTLR end "T__40"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expression.g:126:2: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) | '&&' )
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
					// Expression.g:126:4: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
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
					// Expression.g:126:36: '&&'
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
			// Expression.g:130:2: ( ( 'o' | 'O' ) ( 'r' | 'R' ) | '||' )
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
					// Expression.g:130:5: ( 'o' | 'O' ) ( 'r' | 'R' )
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
					// Expression.g:130:26: '||'
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
			// Expression.g:134:2: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' ) | '!' )
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
					// Expression.g:134:5: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' )
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
					// Expression.g:134:35: '!'
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
			// Expression.g:138:2: ( ',' )
			// Expression.g:138:5: ','
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

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Expression.g:142:2: ( '+' )
			// Expression.g:142:5: '+'
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
			// Expression.g:146:2: ( '-' )
			// Expression.g:146:5: '-'
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
			// Expression.g:150:2: ( '*' )
			// Expression.g:150:5: '*'
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
			// Expression.g:154:2: ( '/' )
			// Expression.g:154:5: '/'
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
			// Expression.g:158:2: ( '^' )
			// Expression.g:158:4: '^'
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
			// Expression.g:165:8: ( '=' | '==' )
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
					// Expression.g:165:10: '='
					{
					match('='); 
					}
					break;
				case 2 :
					// Expression.g:165:16: '=='
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
			// Expression.g:168:2: ( '!=' | '<>' )
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
					// Expression.g:168:4: '!='
					{
					match("!="); 

					}
					break;
				case 2 :
					// Expression.g:168:11: '<>'
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
			// Expression.g:170:4: ( '<' )
			// Expression.g:170:6: '<'
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
			// Expression.g:172:2: ( '<=' )
			// Expression.g:172:4: '<='
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
			// Expression.g:174:4: ( '>' )
			// Expression.g:174:6: '>'
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
			// Expression.g:176:2: ( '>=' )
			// Expression.g:176:4: '>='
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
			// Expression.g:180:2: ( '(' )
			// Expression.g:180:4: '('
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
			// Expression.g:183:8: ( ')' )
			// Expression.g:183:10: ')'
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
			// Expression.g:187:2: ( '[' )
			// Expression.g:187:4: '['
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
			// Expression.g:191:2: ( ']' )
			// Expression.g:191:4: ']'
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
			// Expression.g:195:2: ( '#' (~ '#' )+ '#' )
			// Expression.g:195:5: '#' (~ '#' )+ '#'
			{
			match('#'); 
			// Expression.g:195:9: (~ '#' )+
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
					// Expression.g:
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
			// Expression.g:199:2: ( '\"' (~ '\"' )* '\"' )
			// Expression.g:199:4: '\"' (~ '\"' )* '\"'
			{
			match('\"'); 
			// Expression.g:199:8: (~ '\"' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Expression.g:
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
			// Expression.g:203:2: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' ) | ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'e' | 'E' ) )
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
					// Expression.g:203:7: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' )
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
					// Expression.g:204:7: ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'e' | 'E' )
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
			// Expression.g:207:2: ( '$' IDENTIFIER )
			// Expression.g:207:4: '$' IDENTIFIER
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
			// Expression.g:211:2: ( LETTER ( LETTER | Digit )* )
			// Expression.g:211:4: LETTER ( LETTER | Digit )*
			{
			mLETTER(); 

			// Expression.g:211:11: ( LETTER | Digit )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Expression.g:
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
			// Expression.g:215:2: ( ( Digit )+ '.' ( Digit )* | '.' ( Digit )+ )
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
					// Expression.g:215:6: ( Digit )+ '.' ( Digit )*
					{
					// Expression.g:215:6: ( Digit )+
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
							// Expression.g:
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
					// Expression.g:215:17: ( Digit )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Expression.g:
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
					// Expression.g:216:6: '.' ( Digit )+
					{
					match('.'); 
					// Expression.g:216:10: ( Digit )+
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
							// Expression.g:
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
			// Expression.g:220:2: ( ( Digit )+ )
			// Expression.g:220:5: ( Digit )+
			{
			// Expression.g:220:5: ( Digit )+
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
					// Expression.g:
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
			// Expression.g:226:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
			// Expression.g:
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
			// Expression.g:231:2: ( '0' .. '9' )
			// Expression.g:
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
			// Expression.g:235:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+ )
			// Expression.g:235:5: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+
			{
			// Expression.g:235:5: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )+
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
					// Expression.g:
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
		// Expression.g:1:8: ( T__40 | AND | OR | NOT | COMMA | PLUS | MINUS | MUL | DIV | POW | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | LPAREN | RPAREN | LBRACKET | RBRACKET | TYPE_DATETIME | TYPE_STRING | TYPE_BOOLEAN | DATA | IDENTIFIER | TYPE_DOUBLE | TYPE_INTEGER | WS )
		int alt16=28;
		alt16 = dfa16.predict(input);
		switch (alt16) {
			case 1 :
				// Expression.g:1:10: T__40
				{
				mT__40(); 

				}
				break;
			case 2 :
				// Expression.g:1:16: AND
				{
				mAND(); 

				}
				break;
			case 3 :
				// Expression.g:1:20: OR
				{
				mOR(); 

				}
				break;
			case 4 :
				// Expression.g:1:23: NOT
				{
				mNOT(); 

				}
				break;
			case 5 :
				// Expression.g:1:27: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 6 :
				// Expression.g:1:33: PLUS
				{
				mPLUS(); 

				}
				break;
			case 7 :
				// Expression.g:1:38: MINUS
				{
				mMINUS(); 

				}
				break;
			case 8 :
				// Expression.g:1:44: MUL
				{
				mMUL(); 

				}
				break;
			case 9 :
				// Expression.g:1:48: DIV
				{
				mDIV(); 

				}
				break;
			case 10 :
				// Expression.g:1:52: POW
				{
				mPOW(); 

				}
				break;
			case 11 :
				// Expression.g:1:56: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 12 :
				// Expression.g:1:63: NOTEQUALS
				{
				mNOTEQUALS(); 

				}
				break;
			case 13 :
				// Expression.g:1:73: LT
				{
				mLT(); 

				}
				break;
			case 14 :
				// Expression.g:1:76: LTEQ
				{
				mLTEQ(); 

				}
				break;
			case 15 :
				// Expression.g:1:81: GT
				{
				mGT(); 

				}
				break;
			case 16 :
				// Expression.g:1:84: GTEQ
				{
				mGTEQ(); 

				}
				break;
			case 17 :
				// Expression.g:1:89: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 18 :
				// Expression.g:1:96: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 19 :
				// Expression.g:1:103: LBRACKET
				{
				mLBRACKET(); 

				}
				break;
			case 20 :
				// Expression.g:1:112: RBRACKET
				{
				mRBRACKET(); 

				}
				break;
			case 21 :
				// Expression.g:1:121: TYPE_DATETIME
				{
				mTYPE_DATETIME(); 

				}
				break;
			case 22 :
				// Expression.g:1:135: TYPE_STRING
				{
				mTYPE_STRING(); 

				}
				break;
			case 23 :
				// Expression.g:1:147: TYPE_BOOLEAN
				{
				mTYPE_BOOLEAN(); 

				}
				break;
			case 24 :
				// Expression.g:1:160: DATA
				{
				mDATA(); 

				}
				break;
			case 25 :
				// Expression.g:1:165: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 26 :
				// Expression.g:1:176: TYPE_DOUBLE
				{
				mTYPE_DOUBLE(); 

				}
				break;
			case 27 :
				// Expression.g:1:188: TYPE_INTEGER
				{
				mTYPE_INTEGER(); 

				}
				break;
			case 28 :
				// Expression.g:1:201: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA16 dfa16 = new DFA16(this);
	static final String DFA16_eotS =
		"\1\uffff\1\35\1\32\1\uffff\1\32\1\uffff\1\32\1\43\7\uffff\1\45\1\47\6"+
		"\uffff\2\32\2\uffff\1\52\3\uffff\1\32\1\5\1\32\6\uffff\2\32\1\uffff\1"+
		"\3\1\43\2\32\1\61\1\32\1\uffff\1\61";
	static final String DFA16_eofS =
		"\63\uffff";
	static final String DFA16_minS =
		"\1\11\1\60\1\116\1\uffff\1\122\1\uffff\1\117\1\75\7\uffff\2\75\6\uffff"+
		"\1\122\1\101\2\uffff\1\56\3\uffff\1\104\1\60\1\124\6\uffff\1\125\1\114"+
		"\1\uffff\2\60\1\105\1\123\1\60\1\105\1\uffff\1\60";
	static final String DFA16_maxS =
		"\1\174\1\71\1\156\1\uffff\1\162\1\uffff\1\157\1\75\7\uffff\1\76\1\75\6"+
		"\uffff\1\162\1\141\2\uffff\1\71\3\uffff\1\144\1\172\1\164\6\uffff\1\165"+
		"\1\154\1\uffff\2\172\1\145\1\163\1\172\1\145\1\uffff\1\172";
	static final String DFA16_acceptS =
		"\3\uffff\1\2\1\uffff\1\3\2\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2\uffff"+
		"\1\21\1\22\1\23\1\24\1\25\1\26\2\uffff\1\30\1\31\1\uffff\1\34\1\1\1\32"+
		"\3\uffff\1\14\1\4\1\16\1\15\1\20\1\17\2\uffff\1\33\6\uffff\1\27\1\uffff";
	static final String DFA16_specialS =
		"\63\uffff}>";
	static final String[] DFA16_transitionS = {
			"\2\34\1\uffff\2\34\22\uffff\1\34\1\7\1\26\1\25\1\31\1\uffff\1\3\1\uffff"+
			"\1\21\1\22\1\13\1\11\1\10\1\12\1\1\1\14\12\33\2\uffff\1\17\1\16\1\20"+
			"\2\uffff\1\2\4\32\1\30\7\32\1\6\1\4\4\32\1\27\6\32\1\23\1\uffff\1\24"+
			"\1\15\1\32\1\uffff\1\2\4\32\1\30\7\32\1\6\1\4\4\32\1\27\6\32\1\uffff"+
			"\1\5",
			"\12\36",
			"\1\37\37\uffff\1\37",
			"",
			"\1\40\37\uffff\1\40",
			"",
			"\1\41\37\uffff\1\41",
			"\1\42",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\44\1\42",
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
			"\1\36\1\uffff\12\33",
			"",
			"",
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
			return "1:1: Tokens : ( T__40 | AND | OR | NOT | COMMA | PLUS | MINUS | MUL | DIV | POW | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | LPAREN | RPAREN | LBRACKET | RBRACKET | TYPE_DATETIME | TYPE_STRING | TYPE_BOOLEAN | DATA | IDENTIFIER | TYPE_DOUBLE | TYPE_INTEGER | WS );";
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
