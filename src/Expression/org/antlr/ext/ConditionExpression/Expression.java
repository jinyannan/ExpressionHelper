package  org.antlr.ext.ConditionExpression;

import java.util.HashMap;

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

import ExpressionHelper.EntryHelper;

/** 
 
 
 @param funcName
 @param funcParams
 @param data
 @return 
*/
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

	public Expression()
	{
		_expressionString = "";
		_hasCompile = false;
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
			throw new Exception(e.getMessage());
		}

		
	}
	public final Object Calculate(Object data) throws Exception{
		return Calculate(data, null);
	}
	public final Object Calculate(Object data, Object local) throws Exception
	{
		if (!_hasCompile)
		{
			Compile();
		}
		HashMap<String, Object> hmlocal = (local == null ? null : (HashMap<String, Object>)local);
		RootExpression exp = new RootExpression(_tree);
		exp.setUserFunction(_getValueOperation);
		return exp.Evaluate(data, (hmlocal == null ? null : (Object)hmlocal));
	}

	public final Object Calculate(Object data, Object local,IGetValue func) throws Exception
	{
		this.setUserFunction(func);
		return this.Calculate(data, local);
	}
	
	public final Object ExecuteExpression(String exprCond, Object data) {
		return ExecuteExpression(exprCond, data, null);
	}

	public final Object ExecuteExpression(String exprCond, Object data, Object local) {
		String result = "";
		Object m = null;
		Expression expObj = new Expression(exprCond,
				(IGetValue) new EntryHelper());
		try {
			expObj.Compile();
			if (data == null) {
				//data = (Object) ExecRuleHelper.getTestData();
				result = "";
			}
			m = expObj.Calculate(data ,local);
			if (m == null) {
				result = "error";
			} else {
				result = m.toString();
			}
		} catch (Exception e) {
			result = "error";
		}
		return m;
	}
	
}