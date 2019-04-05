<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<%
	Map<String, Object> map=(Map)request.getAttribute("map");
	
    List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
    
    if(map.get("masEmployeeList")!=null){
    	masEmployeeList = (List)map.get("masEmployeeList");
    }
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
		<label><span>*</span> Approver</label>
		<select name="<%=APPROVED_BY_OTHER%>" id="<%=APPROVED_BY_OTHER%>" validate="Approver,string,yes" >
	 	 <option value="">Select</option>
	 		<%for(MasEmployee employee : masEmployeeList){%>
				<%-- <option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+employee.getLastName()%></option> --%>
				 <option value="<%=employee.getId()%>"><%=employee.getFirstName()%></option> 
			<%} %>
	 	</select>
