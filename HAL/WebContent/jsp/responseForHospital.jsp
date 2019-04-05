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
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
	if(map.get("error") != null){
		String error = (String)map.get("error");
%>
<h4>
<%=error%></h4>
<%		
	}else if(map.get("hospitalList") != null){
		deptList=(List)map.get("deptList");
		
		
		hospitalList = (List<MasHospital>)map.get("hospitalList");
%>



<div class="clear"></div>
<label>Hospital<span>*</span> </label>
<select id="hospital" tabindex="1" name="<%=HOSPITAL %>">
			<!-- <option value="0">Select</option> -->
		<%    
	Set<MasHospital> hospitalSet = new HashSet<MasHospital>();
   			
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
	
<label>Department<span>*</span> </label> 
		<select id="department" tabindex="1"
			name="<%=DEPARTMENT_ID %>" id="<%=DEPARTMENT_ID %>" 
			validate='Department,string,yes'>
			
			<%    
			deptList = (List<MasEmployeeDepartment>)map.get("deptList");
			MasEmployeeDepartment deptObj = new MasEmployeeDepartment();
   			for(Iterator iterator = deptList.iterator(); iterator.hasNext();) {
   				deptObj = (MasEmployeeDepartment)iterator.next();
   				if(deptList.size() == 1){ %>
   				<!-- <option value="0">Select</option> -->
			<option selected="selected"
				value="<%=deptObj.getDepartment().getId()%>"><%=deptObj.getDepartment().getDepartmentName()%></option>
			<% }else{ %>
			<option value="<%=deptObj.getDepartment().getId()%>"><%=deptObj.getDepartment().getDepartmentName()%></option>
			<% } %>
			<%	
	}
	%>
		</select>

		<%
		}%>

	<script>
    	//document.loginForm.<%=DEPARTMENT_ID %>.focus();
</script>