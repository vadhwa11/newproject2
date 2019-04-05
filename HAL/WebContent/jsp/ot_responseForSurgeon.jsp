
<%@page import="java.util.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List empList= new ArrayList();
if(map.get("empList") != null){
	empList = (List)map.get("empList");
}
System.out.println("empList --------- "+empList.size());
%>


<%@page import="java.util.Iterator"%>


<%@page import="jkt.hms.masters.business.MasEmployee"%>
<ul>
	<%	if(empList.size() !=0){
	
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			
			MasEmployee masEmployee=(MasEmployee)iterator.next();
			 String empName=masEmployee.getFirstName();
			 
			 if(masEmployee.getMiddleName() != null){
				 empName = empName + " " + masEmployee.getMiddleName();
			 }
			 if(masEmployee.getLastName() != null){
				 empName = empName + " " + masEmployee.getLastName();
			 }

			 int empId=masEmployee.getId();
		
%>
	<li style="width: auto;"><%=empName%>[<%=empId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



