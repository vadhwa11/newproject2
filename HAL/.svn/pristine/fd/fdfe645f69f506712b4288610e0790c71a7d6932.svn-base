<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
	List<MasDivision> divisionList = new ArrayList<MasDivision>();
	departmentTypeList = (ArrayList)map.get("departmentTypeList");
	costCenterList = (ArrayList)map.get("costCenterList");
	ArrayList searchDepartmentList = (ArrayList)map.get("searchDepartmentList");
	ArrayList gridCostCenterList = (ArrayList)map.get("gridCostCenterList");
	ArrayList gridDepartmentTypeList = (ArrayList)map.get("gridDepartmentTypeList");
	
	divisionList = (ArrayList)map.get("divisionList");
	ArrayList gridDivisionList = (ArrayList)map.get("gridDivisionList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>

<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Department Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Department Code</label>
 
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" /> 
<label>Department Name</label>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Department Code,string,no" MAXLENGTH="50" tabindex=1 />

<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="3" /> 
<label> Division  </label> 
<select name="divisionIdSearch"	id="divisionIdSearch"	 validate="Division,string,no" tabindex=1>
	<option value="0">Select</option>
	<% 
				
				for (MasDivision  masDivision : divisionList){
				%>
	<option value="<%=masDivision.getId ()%>"><%=masDivision.getDivisionName()%></option>

	<%}%>
</select>

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','systemRelatedMaster?method=searchDepartment')"	tabindex=1 /> <%--- Report Button   --%> 
	<input type="button" name="Report" value="Generate Report" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForDepartment');" accesskey="g" tabindex=1 />

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_department"></div></form>

</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchDepartmentList.size()>0 )
		 {
			String strForCode = (String)map.get("departmentCode");
			String strForCodeDescription = (String)map.get("departmentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="systemRelatedMaster?method=showDepartmentJsp">Show All
Records</a></h4> <%
			}
		 }
	if(searchDepartmentList.size()==0 && map.get("search") != null)
	  {
    %> <h4><a href="systemRelatedMaster?method=showDepartmentJsp">Show
All Records</a></h4> <%
           }
         %> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DEPARTMENT_TYPE_ID %>"],[4,"deptNo"], [5,"divisionId"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script></div>

<form name="department" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDepartment"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DepartmentName">
<input type="hidden" name="title" value="Department"> <input
	type="hidden" name="<%=JSP_NAME %>" value="department"> <input
	type="hidden" name="pojoPropertyCode" value="DepartmentCode"> 

<div class="Clear"></div>
<div class="Block">
<label> Department Code <span>*</span></label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Department Code,string,yes"
	 MAXLENGTH="8" / tabindex=1> <label> Department<span>*</span></label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Department,string,yes"  MAXLENGTH="200"
	/ tabindex=1> <script>
				document.department.<%=CODE%>.focus();
			</script> 
			
			<label>Department Type <span>*</span></label> <select name="<%= DEPARTMENT_TYPE_ID %>"
	validate="Department Type,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasDepartmentType  masDepartmentType : departmentTypeList){
				%>

	<option value="<%=masDepartmentType.getId ()%>"><%=masDepartmentType.getDepartmentTypeName()%></option>

	<%}%>
</select> 
<div class="Clear"></div>
<%-- <label> Cost
Center<span>*</span> </label> <select name="<%= COST_CENTER_ID %>"
	validate="Cost Center,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasCostCenter  masCostCenter : costCenterList){
				%>
	<option value="<%=masCostCenter.getId ()%>"><%=masCostCenter.getCostCenterName()%></option>

	<%}%>
</select>  --%>
<input type="hidden" name="<%=COST_CENTER_ID %>" value="0" />


<label>Department No.<span>*</span>		</label> 

		<input type="text" id="deptNo" name="deptNo" value=""	validate="Department No.,alphanumeric,yes" MAXLENGTH="50" /> 
<label> Division  </label> 
<select name="divisionId"	id="divisionId"	 validate="Division,string,no" tabindex=1>
	<option value="0">Select</option>
	<% 
				
				for (MasDivision  masDivision : divisionList){
				%>
	<option value="<%=masDivision.getId ()%>"><%=masDivision.getDivisionName()%></option>

	<%}%>
</select>

</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=addDepartment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=editDepartment')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=deleteDepartment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />  			
</div>
</form>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Department Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Department"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "DepartmentType"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=DEPARTMENT_TYPE_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Department No."
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "deptNo";




	data_header[4] = new Array;
	data_header[4][0] = "Division"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "divisionId";
	
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";




data_arr = new Array();

<%
Iterator itr=searchDepartmentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDepartment  masDepartment = (MasDepartment)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDepartment.getId()%>
data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentCode()%>"
data_arr[<%= counter%>][2] = "<%= masDepartment.getDepartmentName()%>"

<%
		Iterator itrGridDepartmentTypeList=gridDepartmentTypeList.iterator();
		 while(itrGridDepartmentTypeList.hasNext())
            {try{
             MasDepartmentType  departmentTypeGrid = (MasDepartmentType)itrGridDepartmentTypeList.next(); 
			 if(masDepartment.getDepartmentType().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=departmentTypeGrid.getDepartmentTypeName()%>"
			<%}else if(masDepartment.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getDepartmentTypeName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            data_arr[<%= counter%>][4] = "<%=masDepartment.getDepartmentNo()!=null?masDepartment.getDepartmentNo():"" %>"
            
<%--             <%
		Iterator itrGridCostCenterList=gridCostCenterList.iterator();
		 while(itrGridCostCenterList.hasNext())
            {try{
             MasCostCenter  costCenterGrid = (MasCostCenter)itrGridCostCenterList.next(); 
			 if(masDepartment.getCostCenter().getId().equals(costCenterGrid.getId()) && costCenterGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=costCenterGrid.getCostCenterName()%>"
			<%}else if(masDepartment.getId().equals(costCenterGrid.getId()) && costCenterGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=costCenterGrid.getCostCenterName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%> --%>
  
   
   <%
	Iterator itrGridDivisionList=gridDivisionList.iterator();
	 while(itrGridDivisionList.hasNext())
       {try{
        MasDivision  masDivisionGrid = (MasDivision)itrGridDivisionList.next(); 
		 if(masDepartment.getDivision().getId().equals(masDivisionGrid.getId()) && masDivisionGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][5] = "<%=masDivisionGrid.getDivisionName()%>"
		<%}else if(masDepartment.getDivision().getId().equals(masDivisionGrid.getId()) && masDivisionGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=masDivisionGrid.getDivisionName()%>";
			<%}
       }catch(Exception e){e.printStackTrace();}}%>
data_arr[<%= counter%>][6] = "<%= masDepartment.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masDepartment.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masDepartment.getLastChgTime() %>"
<% if(masDepartment.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "department"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
