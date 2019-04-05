<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : resultOfAppealMedicalboardSearch.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 08.06.2009    Name: Vineet Kumar
    * Revision Date:      Revision By: 
    * @version 1.0  
    
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MbInstructionToCandidateMaster"%>
<%@page
	import="jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<% String   userName="";
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
   map = (Map) request.getAttribute("map");
}
if(session.getAttribute("userName")!=null){
   userName=(String)session.getAttribute("userName");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

List<MbResultOfAppealMedicalboardMaster> mbResultOfAppealMedicalboardMasterList = new ArrayList<MbResultOfAppealMedicalboardMaster>();

if (map.get("mbResultOfAppealMedicalboardMasterList") != null) {
	mbResultOfAppealMedicalboardMasterList = (List) map.get("mbResultOfAppealMedicalboardMasterList");
}
else if (map.get("searchResultOfAppealMedicalboardSearchList") != null) {
	mbResultOfAppealMedicalboardMasterList = (List) map.get("searchResultOfAppealMedicalboardSearchList");
}
   String message ="";
   Calendar calendar = Calendar.getInstance();
	String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
	String dateCal = String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if (month.length() < 2) {
		month = "0" + month;
	}
	if (dateCal.length() < 2) {
		dateCal = "0" + dateCal;
	}
  
   %>

<script type="text/javascript">
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
   </script>

<% 
if (map.get("message") != null) {
       message = (String) map.get("message");
      
   }
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<div id="contentHolder">
<h6>Result Of Appeal Medical Board Entry Search</h6>
<div class="Clear"></div>

<div class="blockFrame">
<form name="resultOfAppealMedicalboardSearch1" action="" method="post">

<label>Entry No</label> <input id="searchField1" type="text"
	name="<%= ENTRY_NO %>" value="" tabindex=1 maxlength="5"
	validate="Entry No,int,no" /> <label>Entry Date</label> <input
	type="text" name="<%= ENTRY_DATE %>" id="searchField2" MAXLENGTH="10"
	tabindex=1 class="calDate" validate="Entry Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.resultOfAppealMedicalboardSearch1.<%=ENTRY_DATE%>,event)" ; />


<label>Batch No</label> <input id="searchField3" type="text"
	maxlength="25" name="<%= BATCH_NO%>" value="" tabindex=1 />

<div class="Clear"></div>
<label> Chest No </label> <input id="searchField4" type="text"
	name="<%= CHEST_NO%>" value="" tabindex=1 maxlength="25" /> <label>Name</label>
<input id="searchField5" type="text" name="<%= NAME%>" value=""
	tabindex=1 maxlength="30" />
</div>
<div class="division"></div>
<input tabindex="1" type="button" name="Search"
	onclick="submitForm('resultOfAppealMedicalboardSearch1','resultOfAppealMedicalboardSearch?method=searchResultOfAppealMedicalboardSearch');"
	value="Search" class="cmnButton" accesskey="a" />
</form>
<div class="division"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%       
    if(mbResultOfAppealMedicalboardMasterList!= null &&  mbResultOfAppealMedicalboardMasterList.size()==0)
     {
    %>
<div class="Clear"></div>
<h5><a
	href="resultOfAppealMedicalboardSearch?method=showResultOfAppealMedicalboardSearchJsp">Show
All Records</a></h5>
<div class="Clear"></div>

<%
     }
   %>
<form name="resultOfAppealMedicalboardSearch" method="post" action="">
<script type="text/javascript">
formFields = [ [0,"<%= COMMON_ID%>"],[1,"<%= ENTRY_NO%>"], [2,"<%= ENTRY_DATE%>"],[3,"<%= BATCH_NO %>"],[4,"<%= CHEST_NO %>"],[5,"<%= NAME%>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%=STATUS%>"] ];
statusTd = 8;
</script>
<div class="Clear"></div>
</form>
</div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</div>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Entry No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= ENTRY_NO %>";

data_header[1] = new Array;
data_header[1][0] = "Entry Date";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= ENTRY_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Batch No";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= BATCH_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Chest No";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= CHEST_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Name";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= NAME %>";

data_header[5] = new Array;
data_header[5][0] = "";
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = "";
data_header[6][1] = "hide";
data_header[6][2] = "0%";
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "hide";
data_header[7][2] = "0%";
data_header[7][3] = "<%=STATUS %>";
<%
Iterator itr=mbResultOfAppealMedicalboardMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
           MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster = (MbResultOfAppealMedicalboardMaster)itr.next(); 
           
%>

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0] = "<%= mbResultOfAppealMedicalboardMaster.getId()%>";
data_arr[<%= counter%>][1] = "<%= mbResultOfAppealMedicalboardMaster.getEntryNo()%>";
<%
if(mbResultOfAppealMedicalboardMaster.getEntryDate() != null && !mbResultOfAppealMedicalboardMaster.getEntryDate().equals(""))
{%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(mbResultOfAppealMedicalboardMaster.getEntryDate())%>"
<%
}
else
{ %>
data_arr[<%= counter%>][2]="";
<%}%>
data_arr[<%= counter%>][3] = "<%= mbResultOfAppealMedicalboardMaster.getBatchNo()%>";
data_arr[<%= counter%>][4] = "<%= mbResultOfAppealMedicalboardMaster.getChestNo()%>";
data_arr[<%= counter%>][5] = "<%= mbResultOfAppealMedicalboardMaster.getName()%>";
data_arr[<%= counter%>][6] = "<%= mbResultOfAppealMedicalboardMaster.getLastChgBy() %>";
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(mbResultOfAppealMedicalboardMaster.getLastChgDate()) %>";

<%if(mbResultOfAppealMedicalboardMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}
counter++;
}
%>
formName = "resultOfAppealMedicalboardSearch"
start = 0
if(data_arr.length < rowsPerPage)
   end = data_arr.length;
else
   end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');    
</script>
