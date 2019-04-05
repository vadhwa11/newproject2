
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasDepartment>list= new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	list = (List)map.get("departmentList");
}
%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
	Integer dept=0;	
		if(session.getAttribute("deptId")!=null){
				dept=(Integer)session.getAttribute("deptId");
		}
		for (MasDepartment msd :list) {
	  	//MasDepartment masDepartment=msd.getDepartment();
%>	

<option value="<%=msd.getId()%>" ><%=msd.getDepartmentName()%></option>
<%-- 	<%if(dept.equals(msd.getId())){%>		
	    <option value="<%=msd.getId()%>" selected="selected"><%=msd.getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=msd.getId()%>" ><%=msd.getDepartmentName()%></option>
	<%}%> --%>
<%} }%>


