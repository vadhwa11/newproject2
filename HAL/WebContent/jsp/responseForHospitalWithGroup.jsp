<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForHospital.jsp  
 * Purpose of the JSP   This is for Response for Hospital.
 * @author  Ritu
 * Create Date: 29th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasApplicationgroup>applicationgroupList= new ArrayList();
	applicationgroupList = (List)map.get("applicationgroupList");
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<UserDepartment> deptList = new ArrayList<UserDepartment>();
	if(map.get("error") != null){
		String error = (String)map.get("error");
%>
<%=error%>
<%		
	}else if(map.get("hospitalList") != null){
		deptList=(List)map.get("deptList");
%>





<%@page import="jkt.hms.masters.business.MasApplicationgroup"%>
<label>SMC <span>*</span></label>
<select id="hospital" tabindex="1" name="<%=HOSPITAL %>">
			<option value="0">Select</option>
			<%    
	Set<MasHospital> hospitalSet = new HashSet<MasHospital>();
   			hospitalList = (List<MasHospital>)map.get("hospitalList");
			MasHospital hospitalObj = new MasHospital();
			
   			for(Iterator iterator = hospitalList.iterator(); iterator.hasNext();) {
   				hospitalObj = (MasHospital)iterator.next();
   				hospitalSet.add(hospitalObj);
   			} 			
   			for(MasHospital hospital : hospitalSet){
   				
   %>
			<option value="<%=hospital.getId()%>"><%=hospital.getHospitalName()%></option>
			<%	
}
%>
		</select>
	<div class="clear"></div>	
<label>Department <span>*</span></label> 
<select id="department" tabindex="1"	name="<%=DEPARTMENT_ID %>" id="<%=DEPARTMENT_ID %>" validate='Department,string,yes'>
<option value="0">Select</option>
			<%    
			deptList = (List<UserDepartment>)map.get("deptList");
			UserDepartment deptObj = new UserDepartment();
   			for(Iterator iterator = deptList.iterator(); iterator.hasNext();) {
   				deptObj = (UserDepartment)iterator.next();
   				if(deptList.size() == 1){ %>
			<option value="<%=deptObj.getDepartment().getId()%>"><%=deptObj.getDepartment().getDepartmentName()%></option>
			<% }else{ %>
			<option value="<%=deptObj.getDepartment().getId()%>"><%=deptObj.getDepartment().getDepartmentName()%></option>
			<% } %>
			<%	
	}
	%>
		</select>
		<div class="clear"></div>
<label>Group <span>*</span></label>

<select id="group" tabindex="1" name="group" validate='Group,string,no'>
			<option value="0">Select</option>
			<%    
			Set<MasApplicationgroup> appSet = new HashSet<MasApplicationgroup>();
			applicationgroupList = (List<MasApplicationgroup>)map.get("applicationgroupList");
			MasApplicationgroup appObj = new MasApplicationgroup();
			
   			for(Iterator iterator = applicationgroupList.iterator(); iterator.hasNext();) {
   				appObj = (MasApplicationgroup)iterator.next();
   				appSet.add(appObj);
   			} 			
   			for(MasApplicationgroup app : appSet){
   				
   %>
			<option value="<%=app.getId()%>"><%=app.getApplicationgroupName()%></option>
			<%	
}
%>



		</select>

		<%
		} %>


<script>
    	document.loginForm.<%=DEPARTMENT_ID %>.focus();
</script>