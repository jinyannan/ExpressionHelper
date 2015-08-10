package org.antlr.ext.ConditionExpression.Utility;

public class PersistenceSwitchHelper {
	public enum PersistenceType {
		Herbernate, JDBC;
	}

	private PersistenceType _persistenceType = PersistenceType.Herbernate;

	public PersistenceSwitchHelper() {
		super();
		this._persistenceType = PersistenceType.Herbernate;
	}

	public PersistenceSwitchHelper(PersistenceType _persistenceType) {
		super();
		this._persistenceType = _persistenceType;
	}

	public Object getFieldValue(Object data, String propsname) {
		Object result = null;
		switch (_persistenceType) {
		case Herbernate:
			result =  getFieldValueByHB(data, propsname);
			break;
		default:
			break;
		}
		return result;
	}

	private Object getFieldValueByHB(Object data, String propsname) {
		Object result;

		String fieldToMethod = "get" + colToMethodName(propsname);

		try {
			try {
				result = ReflectionHelper.invokeMethod(data, fieldToMethod, null, null);
			} catch (Exception e) {
				Object obj = ReflectionHelper.invokeMethod(data, "getId", null,
						null);
				result = ReflectionHelper.invokeMethod(obj, fieldToMethod, null, null);
			}

		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	private String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	private String colToMethodName(String s) {
		String[] strs = s.toLowerCase().split("_");
		String result = "";
		for (int i = 0; i < strs.length; i++) {
			result += toUpperCaseFirstOne(strs[i]);
		}
		return result;
	}

}
