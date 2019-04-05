<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List employeeList= new ArrayList();
if(map.get("employeeList") != null){
	employeeList = (List)map.get("employeeList");
}
%>
<%@page import="java.util.Iterator"%>
<ul>
	<%	if(employeeList.size() !=0){
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
			Object[] pair = (Object[]) iterator.next();
		    String empName=(String)pair[0];
		    String empNo=pair[1].toString();
%>
	<li><%=empName%>[<%=empNo%>]</li>
	<%}
		}else{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>