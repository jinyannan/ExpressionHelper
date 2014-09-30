package  org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.ExpressionException;
import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public abstract class BaseExpression
{
	//public RootVisit rootVisit;
	//public abstract object Evaluate(ITree tree);
	//public abstract object Evaluate();
	public abstract Object Evaluate(Object data) throws Exception;

	protected Tree _tree;
	private IGetValue _getValueOperation;
	public final IGetValue getUserFunction()
	{
		return _getValueOperation;
	}
	public final void setUserFunction(IGetValue value)
	{
		_getValueOperation = value;
	}

	public BaseExpression(Tree tree)
	{
		_tree = tree;
	}

	/** 
	 根据一个表达式基类创建子类,其中的_userFunction等内容与基类相同
	 
	 @param exp
	 @param tree
	*/
	public BaseExpression(BaseExpression exp, Tree tree)
	{
		_tree = tree;
		_getValueOperation = exp._getValueOperation;
	}


	protected final Object VisitSubTree(Tree tree, Object data) throws Exception
	{
		try
		{
			switch (tree.getType())
			{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region value
				case ExpressionLexer.TYPE_INTEGER:
				case ExpressionLexer.TYPE_STRING:
				case ExpressionLexer.TYPE_DOUBLE:
				case ExpressionLexer.TYPE_BOOLEAN:
				case ExpressionLexer.TYPE_DATETIME:
					return new ValueExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region basicCalc
				case ExpressionLexer.PLUS:
				case ExpressionLexer.MINUS:
				case ExpressionLexer.MUL:
				case ExpressionLexer.DIV:
				case ExpressionLexer.POW:
					return new BasicCalExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region LogicCalc
				case ExpressionLexer.AND:
				case ExpressionLexer.OR:
					return new LogicalExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region Unary
				case ExpressionLexer.UNARY:
					return new UnaryExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region Compare
				case ExpressionLexer.EQUALS:
				case ExpressionLexer.NOTEQUALS:
				case ExpressionLexer.GT:
				case ExpressionLexer.GTEQ:
				case ExpressionLexer.LT:
				case ExpressionLexer.LTEQ:
					return new CompareExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#region Function
				case ExpressionLexer.FUNCTION:
					return new FunctionExpression(this, tree).Evaluate(data);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
					///#endregion


				default:
					throw GetTreeException("无法识别的节点类型");
			}
		}
		catch (RuntimeException e)
		{
			throw GetTreeException("出现错误", e);
		}

	}

	protected final RuntimeException GetTreeException(String message)
	{
		String t = String.format("%1$s,位置:%2$s,详细信息：%3$s", message, _tree.getCharPositionInLine(), _tree.toStringTree());
		return new ExpressionException(t);
	}

	protected final RuntimeException GetTreeException(String message, RuntimeException e)
	{
		String t = String.format("%1$s,位置:%2$s", message, _tree.getCharPositionInLine());
		return new ExpressionException(t, e);
	}

}