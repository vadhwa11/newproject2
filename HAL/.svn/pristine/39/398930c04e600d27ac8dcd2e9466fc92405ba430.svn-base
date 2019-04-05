<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdTemplate.jsp  
 * Purpose of the JSP -  This is for All OpdTemplate Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdTemplateList = (ArrayList)map.get("searchOpdTemplateList");
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
departmentList = (List<MasDepartment>)map.get("departmentList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
int hospitalId = 0;
if (session.getAttribute("hospitalId") != null) {
	Integer temp =  (Integer)session.getAttribute("hospitalId");
	hospitalId = temp.intValue();
}

int deptId = 0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}

%> 
<%
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><%=message %></h4>
		 
		 <% }%>
<div class="titleBg">
<h2>Standard Template Group</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label>Template Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Template Name</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Template Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdTemplate')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','opdMaster?method=searchOpdTemplate','checkSearch')"	tabindex=1 />
</div>
</form>
<div class="clear"></div>

</div>

</div>


<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchOpdTemplateList.size()>0)
		 {
			String strForCode = (String)map.get("templateCode");
			String strForCodeDescription = (String)map.get("templateName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 

<h4><a href="opdMaster?method=showOpdTemplateJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchOpdTemplateList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="opdMaster?method=showOpdTemplateJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= TEMPLATE_TYPE %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>

<form name="opdTemplate" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="OpdTemplate"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName">
<input type="hidden" name="title" value="OpdTemplate"> <input
	type="hidden" name="<%=JSP_NAME %>" value="opdTemplate"> <input
	type="hidden" name="pojoPropertyCode" value="TemplateCode"> 

<div class="clear"></div>

<div class="Block">
<label> Template Code <span>*</span> </label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Template Code,string,yes"	 MAXLENGTH="8"  tabindex=1 />
	 <label	> Template Name<span>*</span> </label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Template Name,string,yes" 
	MAXLENGTH="30" tabindex=1 />
	<script>
				document.opdTemplate.<%=CODE%>.focus();
				</script> 

<label>Department Name <span>*</span> </label> <select id="deptId" name="<%= DEPARTMENT_ID %>"
	validate="Department Name,string,yes" tabindex=1>
	
	<option value="0">Select</option>
	<%
							  	for (MasDepartment masDepartment : departmentList) {
				  %>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%
				  		  				  	}
				  		  				  %>

</select> <script type="text/javascript">
	
		document.getElementById('deptId').value = '<%=deptId%>';
		
		</script>
		<div class="clear"></div>
		
		<label> Type <span>*</span></label>
		<select name="<%=TEMPLATE_TYPE%>" validate="Type,string,yes"
	onkeypress="return submitenter(this,event,'opdMaster?method=addOpdTemplate')">
	<option value="0">Select</option>
	<option value="P">Pharmacy</option>
	<option value="I">Investigation</option>
</select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('opdTemplate','opdMaster?method=addOpdTemplate');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" style="display:none;" value="Update" class="button" onClick="submitForm('opdTemplate','opdMaster?method=editOpdTemplate')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" style="display:none;" value="Activate" class="button" onClick="submitForm('opdTemplate','opdMaster?method=deleteOpdTemplate&flag='+this.value)"accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date</label>
<label class="value"><%=date%></label>

<label>Changed Time</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
 <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
 	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
</div>
</form>
<div class="clear"></div>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Template Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Template Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Department Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= DEPARTMENT_ID%>"

data_header[3] = new Array;
data_header[3][0] = "Type"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= TEMPLATE_TYPE %>";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdTemplateList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             OpdTemplate  opdTemplate = (OpdTemplate)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdTemplate.getId()%>
data_arr[<%= counter%>][1] = "<%=opdTemplate.getTemplateCode()%>"
data_arr[<%= counter%>][2] = "<%= opdTemplate.getTemplateName()%>"

	
<% if(opdTemplate.getDepartment() != null){%>
<%	Iterator itrGridDepartmentList = departmentList.iterator();
	 while(itrGridDepartmentList.hasNext())
           {
            MasDepartment masDepartment = (MasDepartment)itrGridDepartmentList.next(); 
		 if(opdTemplate.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("y")){
		 %>
			data_arr[<%= counter%>][3] = "<%=masDepartment.getDepartmentName()%>"
		<%}else if(opdTemplate.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
		<%}
}	%>
<%}%>

<% if(opdTemplate.getTemplateType().equals("P"))
	{%>
		data_arr[<%= counter%>][4] = "Pharmacy"
	<%}
else if(opdTemplate.getTemplateType().equals("I"))
	{%>
		data_arr[<%= counter%>][4] = "Investigation"
<%}else{%>
	data_arr[<%= counter%>][4] = ""
<%	
}%>

data_arr[<%= counter%>][5] = "<%= opdTemplate.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(opdTemplate.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= opdTemplate.getLastChgTime() %>"
<% if(opdTemplate.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "opdTemplate"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
