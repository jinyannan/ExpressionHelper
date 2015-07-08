package  org.antlr.ext.ConditionExpression.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.KeysExpression;
import org.antlr.ext.ConditionExpression.Visitor.RootExpression;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;
import org.antlr.grammar.v3.ANTLRParser.finallyClause_return;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.Token;

public class GetTypeUtility
{
	public String cutExpression(String exp)
	{
		CharStream input = new ANTLRStringStream(exp);
		ExpressionLexer lexer = new ExpressionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		
		//System.out.println(tokens.getNumberOfOnChannelTokens());
		return this.cutExpression(tokens);
	}
	
	private String cutExpression(CommonTokenStream tokens)
	{
		String cutted="";
		int lparen=0;
		int rparen=0;
		boolean stop=false;
		
		CommonTokenStream ts=null;
		//System.out.println("1");
		
		List list=tokens.getTokens();
		//int k=tokens.LA(0);
		//System.out.println("size=" + list.size());
		
		for(int i=list.size()-1;i>=0; i--)
		{
	
			Token token=(Token) tokens.get(i);
			
			if(token.getType()==ExpressionParser.EOF || ((org.antlr.runtime.Token) token).getChannel()==org.antlr.runtime.Token.HIDDEN_CHANNEL) continue;
			
			switch(token.getType())
			{
			case ExpressionParser.LPAREN:
				if(lparen==rparen){
					stop=true; 
				}
				else{
					lparen++;
				}
				break;
			case ExpressionParser.RPAREN:
				rparen++;
				break;
			//logic
			case ExpressionParser.AND:
			case ExpressionParser.OR:
			//compare
			case ExpressionParser.NOT:
			case ExpressionParser.EQUALS:
			case ExpressionParser.NOTEQUALS:
			case ExpressionParser.GT:
			case ExpressionParser.LT:
			case ExpressionParser.GTEQ:
			case ExpressionParser.LTEQ:
			//match
			case ExpressionParser.PLUS:
			case ExpressionParser.MINUS:
			case ExpressionParser.MUL:
			case ExpressionParser.DIV:
			//basic type
			case ExpressionParser.TYPE_INTEGER:
			case ExpressionParser.TYPE_STRING:
			case ExpressionParser.TYPE_DOUBLE:
			case ExpressionParser.TYPE_BOOLEAN:
			case ExpressionParser.TYPE_DATETIME:
			//comma
			case ExpressionParser.COMMA:
				if(lparen==rparen) stop=true;
				break;
			case ExpressionParser.DOT:
			case ExpressionParser.FUNCTION:
			case ExpressionParser.DATA:
			case ExpressionParser.IDENTIFIER:
				break;
			//left
			}
			
			if(stop) break;
			
			cutted=token.getText()+cutted;
		}
		
		return cutted;
	}
}