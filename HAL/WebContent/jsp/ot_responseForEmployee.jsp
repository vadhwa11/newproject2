
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

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
			
			//Object[] pair = (Object[]) iterator.next();
			MasEmployee masEmployee=(MasEmployee)iterator.next();
			
		    
			String employeeName=masEmployee.getFirstName();
		    if(masEmployee.getMiddleName() != null ){
		    	employeeName = employeeName + " " + masEmployee.getMiddleName();
		    }
		    if(masEmployee.getLastName() != null ){
		    	employeeName = employeeName + " " + masEmployee.getLastName();
		    }
		    int employeeId=masEmployee.getId();
	
		
%>
	<li style="width: auto;"><%=employeeName%>[<%=employeeId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



