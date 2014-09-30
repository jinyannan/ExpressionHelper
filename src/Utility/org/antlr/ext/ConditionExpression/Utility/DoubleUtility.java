package  org.antlr.ext.ConditionExpression.Utility;

public class DoubleUtility
{
	// Fields 浮点型的误差
	private static final double DOUBLE_DELTA = 1E-06;

	public static boolean AreEqual(double value1, double value2)
	{
		return (value1==value2) || Math.abs(value1 - value2) < DOUBLE_DELTA;
	}

	public static boolean AreNotEqual(double value1, double value2)
	{
		return !AreEqual(value1, value2);
	}

	public static boolean IsGreaterThan(double value1, double value2)
	{
		if (AreEqual(value1, value2))
		{
			return false;
		}
		return (value1 > value2);
	}

	public static boolean IsGreaterOrEqual(double value1, double value2)
	{
		return (value1 > value2) || AreEqual(value1, value2);
	}

	public static boolean IsLessThan(double value1, double value2)
	{
		return !IsGreaterOrEqual(value1, value2);
	}

	public static boolean IsLessOrEqual(double value1, double value2)
	{
		return !IsGreaterThan(value1, value2);
	}

}