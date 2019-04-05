<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * subCharge.jsp  
 * Purpose of the JSP -  This is for Sub Charge.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Fe0b,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	
	mainChargeCodeList = (ArrayList)map.get("mainChargeCodeList");
	ArrayList searchSubChargeList = (ArrayList)map.get("searchSubChargeList");
	ArrayList gridMainChargeList = (ArrayList)map.get("gridMainChargeList");
	ArrayList<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	ArrayList gridDepartmentList = (ArrayList) map.get("gridDepartmentList");
	departmentList=(ArrayList)map.get("departmentList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><span><%=message%></span></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Sub Type</h2>
</div>
<div class="Clear"></div>

<div id="searcharea">
<div class="search">
<form name="search" method="post" action="">
<div class="Block">
<label>SubType Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label class="noWidth">SubType
Description</label> <input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="SubCharge Code,string,no"	MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchSubCharge')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchSubCharge','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_subcharge"></form>
</div>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchSubChargeList.size()>0 && mainChargeCodeList.size() > 0)
		 {
			String strForCode = (String)map.get("subChargecodeCode");
			String strForCodeDescription = (String)map.get("subChargecodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="hospital?method=showSubChargeJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchSubChargeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showSubChargeJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">
	
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= MAIN_CHARGECODE_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=DEPARTMENT_ID%>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>

<form name="subCharge" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasSubChargecode">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="SubChargecodeName"> <input type="hidden" name="title"
	value="SubCharge"> <input type="hidden" name="<%=JSP_NAME %>"
	value="subCharge"> <input type="hidden" name="pojoPropertyCode"
	value="SubChargecodeCode"> 

<div class="Clear"></div>
<div class="Block">
<label> SubType Code <span>*</span> </label> <input type="text" name="<%= CODE%>"
	value="" validate="SubCharge Code,string,yes" 
	MAXLENGTH="8" tabindex=1> <label> SubType Name <span>*</span> </label>
	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="SubCharge Description,string,yes" 
	MAXLENGTH="75" tabindex=1> <label>
	 Main Type <span>*</span> </label> <select name="<%= MAIN_CHARGECODE_ID %>"
	validate="Main Charge,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=addSubCharge')">
	<option value="">Select</option>
	<% 
				for (MasMainChargecode  masMainChargecode : mainChargeCodeList){
				%>
	<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>

	<%}%>
</select> 
<div class="Clear"></div>
<label>Department Name <span>*</span> </label> <select id="depName" name="<%=DEPARTMENT_ID %>"
	validate="Department Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasDepartment department : departmentList){
				%>

	<option value="<%=department.getId ()%>"><%=department.getDepartmentName()%></option>

	<%}%>


</select> <script type="text/javascript">
				document.getElementById('depName').value='<%=deptId%>';
			</script> 


</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('subCharge','hospital?method=addSubCharge');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('subCharge','hospital?method=editSubCharge')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('subCharge','hospital?method=deleteSubCharge&flag='+this.value)"
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
</div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "SubType Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "SubType Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Main Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MAIN_CHARGECODE_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Department"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=DEPARTMENT_ID %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSubChargeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSubChargecode  masSubChargecode = (MasSubChargecode)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSubChargecode.getId()%>
data_arr[<%= counter%>][1] = "<%=masSubChargecode.getSubChargecodeCode()%>"
data_arr[<%= counter%>][2] = "<%= masSubChargecode.getSubChargecodeName()%>"

<%
		Iterator itrGridMainChargeList=gridMainChargeList.iterator();
		 while(itrGridMainChargeList.hasNext())
            {
             MasMainChargecode  mainChargeGrid = (MasMainChargecode)itrGridMainChargeList.next(); 
			 if(masSubChargecode.getMainChargecode().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=mainChargeGrid.getMainChargecodeName()%>"
			<%}else if(masSubChargecode.getMainChargecode().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=mainChargeGrid.getMainChargecodeName()%>";
				
			<%}
}%>
data_arr[<%= counter%>][4] = "<%= masSubChargecode.getLastChgBy() %>"
<%if(masSubChargecode.getLastChgDate()!=null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masSubChargecode.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][6] = "<%= masSubChargecode.getLastChgTime() %>"

<%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {
			 try
			 {
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(masSubChargecode.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y"))
			 {
			 %>
				
				data_arr[<%= counter%>][7] = "<%=departmentGrid.getDepartmentName()%>"
				
			<%
			}
			 else if(masSubChargecode.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n"))
			{
			%>
			
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
				
			<%
			}
           }
			catch(Exception e)
			{
				System.out.println("ssssssss "+e);
			} }%>
			
<% if(masSubChargecode.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "subCharge"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
