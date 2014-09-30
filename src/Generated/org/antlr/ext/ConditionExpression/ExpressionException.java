package org.antlr.ext.ConditionExpression;

public class ExpressionException extends RuntimeException
{
	public ExpressionException()
	{
		super();
	}
	public ExpressionException(String message)
	{
		super(message);
	}

	public ExpressionException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}