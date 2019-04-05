package jkt.hms.util;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportDataSource implements JRDataSource {

	private Iterator iterator;
	private Object currentValue;
	private String[] fields;
	private int size;

	public ReportDataSource(String fields[], List list) {
		this.fields = fields;
		size = list.size();
		iterator = list.iterator();
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		int index = getFieldIndex(field.getName());
		if (index > -1) {
			return getField(field.getName());
		}
		return value;
	}

	private Object getField(final String field) {
		String methodName = mangleMethodNameFromField(field);
		try {
			Method m = currentValue.getClass().getMethod(methodName,
					(Class[]) null);
			Object obj = m.invoke(currentValue, (Object[]) null);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean next() throws JRException {
		currentValue = iterator.hasNext() ? iterator.next() : null;
		return (currentValue != null);
	}

	private String mangleMethodNameFromField(String field) {
		String newField = field.substring(0, 1).toUpperCase()
				+ field.substring(1);
		return "get" + newField.replaceAll(" ", "");
	}

	private int getFieldIndex(String field) {
		int index = -1;

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals(field)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int getSize() {
		return size;
	}
}
