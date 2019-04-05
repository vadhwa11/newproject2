
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

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasDesignation"%>
<%@page import="jkt.hms.masters.business.GroupMaster"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


<div id="contentHolder">
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
		ArrayList<MasDesignation> searchDesignationList= new ArrayList<MasDesignation>(); 
		List<GroupMaster> groupMasterList= new ArrayList<GroupMaster>();
		
		if(searchDesignationList!= null)
			searchDesignationList = (ArrayList)map.get("searchDesignationList");
		
		if(groupMasterList!= null)
			groupMasterList = (ArrayList)map.get("groupMasterList");
		
		System.out.println("groupMasterList eee   "+groupMasterList.size());
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>
<h6>Designation Master</h6>
<div class="header">
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action=""><label>Designation
Code</label> <input type="radio" class="radio" name="<%=SELECTED_RADIO  %>"
	value="1" checked="checked" /> <label>Designation</label> <input
	type="radio" class="radio" name="<%=SELECTED_RADIO %>" value="2" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Designation Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','systemRelatedMaster?method=searchDesignation','checkSearch')"
	tabindex=1 /> <%--- <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=');" accesskey="g" tabindex=1/> 
	                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_department">
	                    --%></form>
</div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
			if(searchDesignationList.size()>0 )
			 {
				String strForCode = (String)map.get("designationCode");
				String strForCodeDescription = (String)map.get("designation");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%> <br />
<a href="systemRelatedMaster?method=showDesignationMasterJsp">Show
All Records</a> <%
				}
			 }
		if(searchDesignationList.size()==0 && map.get("search") != null)
		  {
	    %> <a href="systemRelatedMaster?method=showDesignationMasterJsp">Show
All Records</a> <%
	           }
	         %> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"groupMaster"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"type"],[8,"<%=STATUS%>"] ];
		 statusTd = 8;
		</script></div>

<form name="designation" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDesignation"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DesignationName">
<input type="hidden" name="title" value="Designation"> <input
	type="hidden" name="<%=JSP_NAME %>" value="designation"> <input
	type="hidden" name="pojoPropertyCode" value="DesignationCode">
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Designation
Code</label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Designation Code,name,yes" class="textbox_size20"
	MAXLENGTH="10" tabindex=1 /> <label><span>*</span> Designation</label>
<input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Designation,name,yes" class="textbox_size20" MAXLENGTH="20"
	tabindex=1 /> <script>
					document.department.<%=CODE%>.focus();
				</script> <label><span>*</span> Group Type</label> <select name="groupMaster"
	tabindex=1 validate="Group Type,string,yes">
	<option value="">Select</option>
	<%
				  for(GroupMaster groupMaster:groupMasterList){
					  
				  
				%>
	<option value="<%=groupMaster.getId()%>"><%=groupMaster.getGroupName()%></option>
	<%
				}
				%>
</select>
<div class="Clear"></div>
<label><span>*</span> Type</label> <select name="type" tabindex=1
	validate="Type,string,yes">
	<option value="">Select</option>
	<option value="Industrial">Industrial</option>
	<option value="Non-Industrial">Non-Industrial</option>
</select></div>
<div class="Clear"></div>

<div class="bottom">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('designation','systemRelatedMaster?method=addDesignation');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('designation','systemRelatedMaster?method=editDesignation')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('designation','systemRelatedMaster?method=deleteDesignation&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>


</div>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Designation Code"
	data_header[0][1] = "data";
	data_header[0][2] = "20%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Designation"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Group Type"
	data_header[2][1] = "data";
	data_header[2][2] = "25%";
	data_header[2][3] = "groupMaster"
	
	
	
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
	data_header[5][2] = "15%";
	data_header[5][3] = "<%=CHANGED_TIME %>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Type"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "type";
	
	data_header[7] = new Array;
	data_header[7][0] = "Status"
	data_header[7][1] = "data";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	<%
	    if(searchDesignationList!= null){
		Iterator itr=searchDesignationList.iterator();
		
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            MasDesignation  masDesignation = (MasDesignation)itr.next(); 
	         
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masDesignation.getId()%>
	data_arr[<%= counter%>][1] = "<%=masDesignation.getDesignationCode()%>"
	data_arr[<%= counter%>][2] = "<%= masDesignation.getDesignationName()%>"
	<% 
	
	System.out.println("groupMasterList in jsp   "+groupMasterList.size());
	Iterator itrr=groupMasterList.iterator();
	 while(itrr.hasNext()){
		GroupMaster groupMaster =(GroupMaster)itrr.next();
		if(masDesignation.getGroup() != null){
		 if(masDesignation.getGroup().getId().equals(groupMaster.getId()) && groupMaster.getStatus().equals("y")){
	%>
	data_arr[<%= counter%>][3] = "<%= groupMaster.getGroupName()%>"
	<%}else if(masDesignation.getGroup().getId().equals(groupMaster.getId()) && groupMaster.getStatus().equals("n")){%>
	data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=groupMaster.getGroupName()%>";
	<%}}}%>
	
	data_arr[<%= counter%>][4] = "<%= masDesignation.getLastChgBy() %>"
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masDesignation.getLastChgDate()) %>"
	data_arr[<%= counter%>][6] = "<%= masDesignation.getLastChgTime() %>"
	data_arr[<%= counter%>][7] = "<%= masDesignation.getType() %>"
	
	<% if(masDesignation.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][8] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][8] = "InActive"
	<%}%>
	<%
			     counter++;
	}}
	%>
	 
	formName = "designation"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
