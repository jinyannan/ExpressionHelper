package org.antlr.ext.ConditionExpression.Utility;

import java.util.Date;

public class DataType {
	/**
	 * 判断一个object是否是浮点类型
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isFloatingPoint(Object value) {
		if (value instanceof Double || value instanceof Float
				|| value instanceof java.math.BigDecimal) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个object是否是数字类型
	 * 
	 * @param value
	 * @return FIXME 该方法有问题，需要修正
	 */
	public static boolean IsNumber(Object value) {

		if (value instanceof Integer || value instanceof Double
				|| value instanceof Byte || value instanceof Short
				|| value instanceof Short || value instanceof Byte
				|| value instanceof Integer || value instanceof Long
				|| value instanceof Long || value instanceof Float
				|| value instanceof java.math.BigDecimal) {
			return true;
		}
		return false;
	}

	/**
	 * 从一个对象得到Datetime，如果成功，返回成功的datetime，否则返回DateTime.MinValue
	 * 
	 * @param value
	 * @return
	 */
	public static java.util.Date GetDateTime(Object value) {
		if (value instanceof java.util.Date) {
			return (java.util.Date) value;
		} else {
			java.util.Date t = new java.util.Date(0);
			// RefObject<java.util.Date> tempRef_t = new
			// RefObject<java.util.Date>(t);
			// java.util.Date.TryParse(value.toString(), tempRef_t);
			// //尝试解析DateTime如果不成功返回DateTime.MinValue
			// t = tempRef_t.argvalue;
			boolean tempVar = false;
			try {
				t = new java.util.Date(value.toString());

			} catch (Exception e) {
				// TODO: handle exception
			}
			return t;
		}
	}

	/**
	 * 将数据转化为double类型
	 * 
	 * @param value
	 * @return
	 */
	public static double ConvertToDouble(Object value) {
		java.util.Date t = new java.util.Date(0);
		/**
		 * 如果value为null或者“”返回0
		 */
		if (value == null || value.toString().equals(""))
			return 0;

		if (IsNumber(value)) {
			return (double) new Double(value.toString());
		}
		/**
		 * Aardwolf.K
		 * */
		else if (value instanceof Date
				|| DateHelper.isValidDate(value.toString())) {
			Date date = null;
			try {
				date = (Date) value;
			} catch (Exception e) {
				date = DateHelper.convertToDate(value.toString());
			}
			return DateHelper.toOADate(date);
		}
		/**
		 * java 对日期的加减重新设计 by MZHY
		 */
		// else if (value instanceof java.util.Date)
		// {
		// return value.ToOADate();
		// }
		// else
		// {
		// //RefObject<java.util.Date> tempRef_t = new
		// RefObject<java.util.Date>(t) MZHY;
		// // boolean tempVar = java.util.Date.TryParse(value.toString(),
		// tempRef_t);
		// // t = tempRef_t.argvalue;
		// // if (tempVar)
		// // {
		// // return t.ToOADate();
		// // }
		// // else
		// // {
		// // return Double.parseDouble(value.toString());
		// // }
		// boolean tempVar=false;
		// try {
		// t = new java.util.Date(value.toString());
		// tempVar= true;
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// if (tempVar)
		// {
		// return t.ToOADate();
		// }
		// else
		// {
		// return Double.parseDouble(value.toString());
		// }
		// }
		else {
			return Double.parseDouble(value.toString());
		}
	}

	/**
	 * 将double类型取整
	 * 
	 * @param value
	 * @return
	 */
	public static long ConvertDoubleToLong(Double value) {
		return (long) Math.floor(value);
	}

}