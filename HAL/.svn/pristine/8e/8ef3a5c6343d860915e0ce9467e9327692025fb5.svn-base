<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * typeOfEntryMaster.jsp  
 * Purpose of the JSP -  This is for Type Of Entry Master.
 * @author  Vineet Kumar
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>





<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchTypeOfEntryMasterList = (ArrayList)map.get("searchTypeOfEntryMasterList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>

<%
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
	if (!message.equalsIgnoreCase("")) {
%>
<h2><%=message%></h2>
<%
	}
%>
<div class="Clear"></div>
<div id="contentHolder">
<h6>Type of Entry Master</h6>

<div class="Clear"></div>
<div class="header">
<form name="search" method="post" action=""><label class="medium"></label>
<input type="text" id="searchField1" name="<%= SEARCH_FIELD%>" value=""
	MAXLENGTH="8" tabindex=1 /> <input type="button" name="search"
	value="Search" class="cmnButton"
	onclick="submitForm('search','typeOfEntryMaster?method=searchTypeOfEntryMaster','checkSearchForSingleWorkService')"
	tabindex=1 /></form>


</div>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<%       
    if(searchTypeOfEntryMasterList!= null &&  searchTypeOfEntryMasterList.size()==0)
     {
    %>
<div class="Clear"></div>
<h5><a href="typeOfEntryMaster?method=showTypeOfEntryMasterJsp">Show
All Records</a></h5>
<div class="Clear"></div>

<%
     }
   %> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= TYPE_NAME%>"], [2,"<%= STATUS_DISPLAY%>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"], [5,"<%= CHANGED_TIME %>"], [6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<div class="blockTitle">Type Of Entry</div>
<div class="blockTitleCurve"></div>
<div class=Clear></div>

<form name="typeOfEntryMaster" method="post" action="">
<div class="blockFrame">
<div class=Clear></div>

<input type="hidden" name="<%= POJO_NAME %>" value="MbTypeOfEntryMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TypeName">
<input type="hidden" name="title" value="TypeOfEntryMaster"> <input
	type="hidden" name="<%=JSP_NAME %>" value="typeOfEntryMaster">

<label>Type Name <span>*</span> </label> <input id="typeId" type="text"
	name="<%=TYPE_NAME%>" value="" validate="Type Name,string,yes"
	class="textbox_size20" MAXLENGTH="8" tabindex=1 /> <label>Status
<span>*</span></label> <select id="statusDisplay" name="<%=STATUS_DISPLAY %>"
	validate="Status,string,yes" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<option value="y">Active</option>
	<option value="n">InActive</option>
</select></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Submit" class="button"
	onClick="submitForm('typeOfEntryMaster','typeOfEntryMaster?method=addTypeOfEntryMaster');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('typeOfEntryMaster','typeOfEntryMaster?method=editTypeOfEntryMaster')"
	accesskey="u" tabindex=1 /> <input type="button" name="back" id="back"
	value="Back" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('typeOfEntryMaster','typeOfEntryMaster?method=deleteTypeOfEntryMaster&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex="1" />
<div class="division"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
<div class=Clear></div>

</div>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Type Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= TYPE_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Status"
data_header[1][1] = "hide";
data_header[1][2] = "15%";
data_header[1][3] = "<%=STATUS_DISPLAY %>";
data_arr = new Array();

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";
data_arr = new Array();

<%
Iterator itr=searchTypeOfEntryMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MbTypeOfEntryMaster  masTypeOfEntryMaster = (MbTypeOfEntryMaster)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masTypeOfEntryMaster.getId()%>"
data_arr[<%= counter%>][1] = "<%= masTypeOfEntryMaster.getTypeName()%>"
data_arr[<%= counter%>][2] = "<%= masTypeOfEntryMaster.getStatus()%>"
data_arr[<%= counter%>][3] = "<%= masTypeOfEntryMaster.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masTypeOfEntryMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masTypeOfEntryMaster.getLastChgTime() %>"
<% if(masTypeOfEntryMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "typeOfEntryMaster"

nonEditable = ['<%= TYPE_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
