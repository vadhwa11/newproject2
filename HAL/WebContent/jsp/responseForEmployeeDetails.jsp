<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  shailesh
* Create Date: 13 march 2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>

<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script>
 var flag;
 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	if(map.get("masEmployeeDepartmentList")!=null){
		masEmployeeDepartmentList=(List<MasEmployeeDepartment>)map.get("masEmployeeDepartmentList");
	}
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	if(map.get("masDepartmentList")!=null){
		masDepartmentList=(List<MasDepartment>)map.get("masDepartmentList");
	}
	int employeeId=0;
	if(map.get("employeeId")!=null){
		employeeId=(Integer)map.get("employeeId");
	}
	
	%>
<div id="departmentDiv">


	
<label >Department  </label> 
 <select id="departmentId" 	name="departmentId" validate="Department ,string,yes" multiple="multiple" class="list" size="5">
 
 <% if(masDepartmentList.size()==0 && masEmployeeDepartmentList.size()>0){
	 		for (MasEmployeeDepartment  masEmployeeDepartment : masEmployeeDepartmentList){
	 			if(masEmployeeDepartment.getDepartment()!=null){
	 				
			%>
	<option value="<%=masEmployeeDepartment.getDepartment().getId()%>" selected="selected"><%=masEmployeeDepartment.getDepartment().getDepartmentName()%></option>
	<%}}}else if(masDepartmentList.size()>0 && masEmployeeDepartmentList.size()>0){
		
		for (MasDepartment  masDepartment : masDepartmentList){
			String seleString = "";
		for (MasEmployeeDepartment  masEmployeeDepartment : masEmployeeDepartmentList){
			
			
 			if(masEmployeeDepartment.getDepartment()!=null){
 			
 				
 					if(masDepartment.getId() == masEmployeeDepartment.getDepartment().getId()){
 						seleString = "selected";
 						break;
 					}
 				}
		}
		%>
<option value="<%=masDepartment.getId()%>" <%=seleString %>><%=masDepartment.getDepartmentName()%></option>
<%	}
	} %>

				       
		</select> </div>
