﻿package  org.antlr.ext.ConditionExpression;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser;
import org.antlr.ext.ConditionExpression.Visitor.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.RootExpression;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

/** 
 
 
 @param funcName
 @param funcParams
 @param data
 @return 
*/
//C# TO JAVA CONVERTER TODO TASK: Delegates are not available in Java:
//public delegate object GetValue(string funcName, object[] funcParams, object data);

public class Expression
{
	private String _expressionString;
	private boolean _hasCompile;
	private CommonTree _tree;
	private  IGetValue _getValueOperation;

	public final IGetValue getUserFunction()
	{
		return _getValueOperation;
	}
	public final void setUserFunction(IGetValue value)
	{
		_getValueOperation = value;
	}

	public Expression(String expressionString)
	{
		_expressionString = expressionString;
		_hasCompile = false;
	}

	public Expression(String expressionString, IGetValue userFunc)
	{
		_expressionString = expressionString;
		_getValueOperation = userFunc;
		_hasCompile = false;
	}

	/** 
	 解析表达式
	 * @throws Exception 
	 * @throws RecognitionException 
	 
	*/
	public final void Compile() throws Exception 
	{
		CharStream input = new ANTLRStringStream(_expressionString);
		ExpressionLexer lex = new ExpressionLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lex);
		ExpressionParser parser = new ExpressionParser(tokens);
		ParserRuleReturnScope r;
		try {
			r = parser.expression();
			if (lex.HasError())
			{
				throw new ExpressionException(lex.GetErrorMessage());
			}
			if (parser.HasError())
			{
				throw new ExpressionException(parser.GetErrorMessage());
			}

			_tree = (CommonTree) r.getTree();
			_hasCompile = true;
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}

		
	}

	public final Object Calculate(Object data) throws Exception
	{
		if (!_hasCompile)
		{
			Compile();
		}

		RootExpression exp = new RootExpression(_tree);
		exp.setUserFunction(_getValueOperation);
		return exp.Evaluate(data);
	}

	public final Object Calculate(Object data, IGetValue func) throws Exception
	{
		this.setUserFunction(func);
		return this.Calculate(data);
	}

}