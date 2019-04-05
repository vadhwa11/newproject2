
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * department.jsp  
	 * Purpose of the JSP -  This is for Department details 
	 * @author  Dipali
	 * @author  Vishal
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
		ArrayList<GroupMaster> searchGroupList= new ArrayList<GroupMaster>(); 
		
		if(searchGroupList!= null)
			searchGroupList = (ArrayList)map.get("searchGroupList");
		
		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>
<h6>Group Master</h6>
<div class="header">
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action=""><label>Group
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <label>Group Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" class="radio" value="2" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Group Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','systemRelatedMaster?method=searchGroupMaster','checkSearch')"
	tabindex=1 /> <%--- <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=');" accesskey="g" tabindex=1/> 
	                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_department">
	                    --%></form>
</div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
			if(searchGroupList.size()>0 )
			 {
				String strForCode = (String)map.get("groupCode");
				String strForCodeDescription = (String)map.get("groupName");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%> <br />
<a href="systemRelatedMaster?method=showGroupMasterJsp">Show All
Records</a> <%
				}
			 }
		if(searchGroupList.size()==0 && map.get("search") != null)
		  {
	    %> <a href="systemRelatedMaster?method=showGroupMasterJsp">Show
All Records</a> <%
	           }
	         %> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"retirementAge"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
		 statusTd = 7;
		</script></div>

<form name="group" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="GroupMaster"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="GroupName">
<input type="hidden" name="title" value="Designation"> <input
	type="hidden" name="<%=JSP_NAME %>" value="groupMaster"> <input
	type="hidden" name="pojoPropertyCode" value="GroupCode">

<div class="Clear"></div>

<div class="blockFrame"><label><span>*</span> Group Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Group Code,name,yes" class="textbox_size20" MAXLENGTH="10"
	tabindex=1 /> <label><span>*</span> Group Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Group Name,string,yes" class="large" MAXLENGTH="50"
	tabindex=1 /> <label><span>*</span>Retirement Age</label> <input
	id="retirementAge" type="text" name="retirementAge" value=""
	validate="Retirement Age,num,yes" class="textbox_size20" MAXLENGTH="2"
	tabindex=1 /> <script>
					document.department.<%=CODE%>.focus();
				</script></div>
<div class="Clear"></div>

<div class="bottom">

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('group','systemRelatedMaster?method=addGroupMaster');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('group','systemRelatedMaster?method=editGroupMaster')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('group','systemRelatedMaster?method=deleteGroupMaster&flag='+this.value)"
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
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Group Code"
	data_header[0][1] = "data";
	data_header[0][2] = "20%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Group Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Retirement Age"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "retirementAge"
	
	
	
	data_header[3] = new Array;
	data_header[3][0] = ""
	data_header[3][1] = "hide";
	data_header[3][2] = "15%";
	data_header[3][3] = "<%=CHANGED_BY %>"
	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "<%=CHANGED_DATE %>";
	
	data_header[5] = new Array;
	data_header[5][0] = ""
	data_header[5][1] = "hide";
	data_header[5][2] = "15%";
	data_header[5][3] = "<%=CHANGED_TIME %>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%=STATUS %>"
	
	data_arr = new Array();
	
	<%
	    if(searchGroupList!= null){
		Iterator itr=searchGroupList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            
	             GroupMaster  groupMaster = (GroupMaster)itr.next(); 
	
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= groupMaster.getId()%>
	data_arr[<%= counter%>][1] = "<%=groupMaster.getGroupCode()%>"
	data_arr[<%= counter%>][2] = "<%= groupMaster.getGroupName()%>"
	data_arr[<%= counter%>][3] = "<%= groupMaster.getRetirementAge() %>"
	
	
	
	data_arr[<%= counter%>][4] = "<%= groupMaster.getLastChgBy() %>"
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(groupMaster.getLastChgDate()) %>"
	data_arr[<%= counter%>][6] = "<%= groupMaster.getLastChgTime() %>"
	
	<% if(groupMaster.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][7] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][7] = "InActive"
	<%}%>
	<%
			     counter++;
	}}
	%>
	 
	formName = "group"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
