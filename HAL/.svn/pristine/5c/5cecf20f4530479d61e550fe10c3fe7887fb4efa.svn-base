package jkt.hms.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.bind.ServletRequestBindingException;

public class JKTRequestUtils extends RequestUtils {

	public static Object getParameterOrAttribute(HttpServletRequest request,String name, String type) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getStringParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return Integer.parseInt((String) request.getAttribute(name));
			} else {
				try {
					return getIntParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getFloatParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getLongParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		return null;
	}

	public static Object getParameterOrAttribute(HttpServletRequest request,
			String name, String type, String defaultValue) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getStringParameter(request, name, defaultValue);
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return Integer.parseInt((String) request.getAttribute(name));
			} else {
				return getIntParameter(request, name, Integer
						.parseInt(defaultValue));
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getFloatParameter(request, name, Float
						.parseFloat(defaultValue));
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getLongParameter(request, name, Long
						.parseLong(defaultValue));
			}
		}
		return null;
	}

}