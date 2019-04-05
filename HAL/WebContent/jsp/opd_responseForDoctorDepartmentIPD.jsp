
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasEmployee>list= new ArrayList<MasEmployee>();
if(map.get("doctorList") != null){
	list = (List)map.get("doctorList");
}
String loginDoctor= null;
if(map.get("loginDoctor") != null){
	loginDoctor = (String)map.get("loginDoctor");
}

%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
	
	int empId=0;	
	if (session.getAttribute("userId") != null) {
		empId = (Integer)session.getAttribute("empId");
	}
		for (MasEmployee doctorList :list) {
			
			if(loginDoctor!=null && loginDoctor.equalsIgnoreCase("y"))
				System.out.println();
			else if(empId == doctorList.getId())
				continue;
			
			String name=doctorList.getFirstName();
			if(doctorList.getMiddleName()!=null && !doctorList.getMiddleName().equals(""))
				name=name+" "+doctorList.getMiddleName();
			if(doctorList.getLastName()!=null && !doctorList.getLastName().equals(""))
				name=name+" "+doctorList.getLastName();	
				
%>				
<option value=<%=doctorList.getId()%>><%=name%></option>
<%} }%>

