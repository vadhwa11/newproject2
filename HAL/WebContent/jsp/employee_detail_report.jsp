<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasDivision> divisionList = new ArrayList<MasDivision>();
if(map.get("divisionList") != null){
	divisionList = (List<MasDivision>)map.get("divisionList");
}
List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
if(map.get("empStatusList") != null){
	empStatusList = (List<MasEmpStatus>)map.get("empStatusList");
}

%>
<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Employee Detail Report</h2>
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
		
		
		<label>Status </label> 
		<select id="empStatusId"		name=<%=EMP_STATUS_ID %>  onclick="checkStatusVal();"  >
			<option value="0">Select</option>

			<%
			           		if(empStatusList != null){ 	
			           			for (Iterator iter = empStatusList.iterator(); iter.hasNext();) {
			           				MasEmpStatus masEmpStatus = (MasEmpStatus) iter.next();
			           %>
			<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>
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
<input type="button" name="OK" value="Print" class="button" onClick="submitForm('search','personnel?method=printEmployeeDetailReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





