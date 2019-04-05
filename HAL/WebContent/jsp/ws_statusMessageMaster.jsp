<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * statusMessageMaster.jsp  
 * Purpose of the JSP -  This is for Status Message.
 * @author  Vineet Kumar
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By: 

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MajorWorkStatus"%>
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
	ArrayList<MasWorkType> searchWorkTypeList = (ArrayList<MasWorkType>)map.get("searchWorkTypeList");
	ArrayList<MajorWorkStatus> searchStatusMesssageList = (ArrayList<MajorWorkStatus>)map.get("searchStatusMesssageList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message ="";
	
%>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<div id="contentHolder">
<h6>Status Message</h6>
<div class="Clear"></div>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= DESC1%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<div class="Clear"></div>
<div class="blockTitle">Status Message</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<form name="statusMessageMaster" method="post" action="">
<div class="blockFrame"><label><span>*</span> Status
Message Code </label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Status Message Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Status Message</label> <input type="text"
	name="<%= SEARCH_NAME %>" value="" validate="Status Message,string,yes"
	MAXLENGTH="30" tabindex=1 /> <script>
document.statusMessageMaster.<%=CODE%>.focus();
</script> <label><span>*</span> Message Description </label> <input type="text"
	name="<%= DESC1 %>" value="" validate="Status Message,string,yes"
	MAXLENGTH="30" tabindex=1 />

<div class="Clear"></div>

</div>


<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="hidden" name="add" value="" /> <input
	type="button" name="edit" id="editbutton" value="Update" class="button"
	onClick="submitForm('statusMessageMaster','majorWorkDetail?method=editStatusMessage')"
	accesskey="u" tabindex=1 /> <input type="button" name="back" id="back"
	value="Back" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="hidden" name="Delete"
	value="" /> <input type="reset" name="Reset" id="reset" value="Reset"
	class="button" onclick="resetCheck();" accesskey="r" tabindex="1" /> <script>
 			var addButton = document.getElementById("addbutton").style.display = "none";
  			var deleteButton = document.getElementById("deletebutton").style.display="none";
			  </script>

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
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Status Message Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Status Message Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Category"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= DESC1 %>";


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();


<%
Iterator itr=searchStatusMesssageList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MajorWorkStatus majorWorkStatus =(MajorWorkStatus) itr.next();
        	  %>
        	  data_arr[<%= counter%>] = new Array();
        	  data_arr[<%= counter%>][0] = "<%=majorWorkStatus.getId() %>"
        	  data_arr[<%= counter%>][1] = "<%=majorWorkStatus.getId() %>"
        	  data_arr[<%= counter%>][2] = "<%=majorWorkStatus.getMajorWorkStatusMessage() %>"
        	    data_arr[<%= counter%>][3] = "<%=majorWorkStatus.getMajorWorkStatusDescription() %>"
        	      data_arr[<%= counter%>][4] = "<%=majorWorkStatus.getLastChgBy() %>"
        	        data_arr[<%= counter%>][5] = "<%=majorWorkStatus.getLastChgDate() %>"
        	    data_arr[<%= counter%>][6] = "<%=majorWorkStatus.getLastChgTime() %>"
        	  
<% if(majorWorkStatus.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "statusMessageMaster"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>



