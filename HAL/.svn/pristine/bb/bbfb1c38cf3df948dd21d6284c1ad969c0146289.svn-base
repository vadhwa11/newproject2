<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%

Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasDivision> divisionList = new ArrayList<MasDivision>();
if(map.get("divisionList") != null){
	divisionList = (List<MasDivision>)map.get("divisionList");
}
List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
if(map.get("dependentList") != null){
	dependentList = (List<MasEmployeeDependent>)map.get("dependentList");
}

%>

<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Employee Dependent Report</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	 />


<label>Division</label> 
		<select id="divisionId" 	name="divisionId" validate="Division,string,no" >
		<!-- onchange="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/personnel?method=getDepartmentList','departmentDiv');" >-->
		
			<option value="0">Select</option>

			<%
				         		if(divisionList != null){ 	
				         			for (Iterator iter = divisionList.iterator(); iter.hasNext();) {
				         				MasDivision division = (MasDivision) iter.next();
				         %>
			<option value="<%=division.getId() %>"><%=division.getDivisionName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		
		
		<label>Dependent </label> <select id="dependentId"		name="dependentId"  >
			<option value="0">Select</option>

			<%
			           		if(dependentList != null){ 	
			           			for (Iterator iter = dependentList.iterator(); iter.hasNext();) {
			           				MasEmployeeDependent masEmployeeDependent = (MasEmployeeDependent) iter.next();
			           %>
			<option value="<%=masEmployeeDependent.getId() %>"><%=masEmployeeDependent.getEmployeeDependentFName() %></option>
			<%		
			          			}
			          		 } 
			          %>
		</select> 
		
	<!-- 	<div id="departmentDiv">
		 <label>Department</label>
		
		 <select id="departmentId" 	name="departmentId" validate="Department,string,no" multiple="multiple" class="list" size="5">
			
				        
				      
		</select>  
		
		</div> -->
</div>



<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Print" class="button" onClick="submitForm('search','personnel?method=printEmployeeDependentReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





