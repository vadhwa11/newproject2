<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdFrequency.jsp  
 * Purpose of the JSP -  This is for All OpdFrequency Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasOpdFrequency"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdFrequencyList = (ArrayList)map.get("searchOpdFrequencyList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

%> 
<%
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><span><%=message %></span></h4>
		 
		 <% }%>
<div class="titleBg">
<h2>Opd Frequency</h2>
<div class="clear"></div>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Frequency Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Frequency Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />




<input type="hidden" name="colCode" value="frequency_code">
<input type="hidden" name="colName" value="frequency_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="FrequencyCode,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdFrequency')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','opdMaster?method=searchOpdFrequency','checkSearch')"	tabindex=1 />
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
		if(searchOpdFrequencyList.size()>0)
		 {
			String strForCode = (String)map.get("opdFrequencyCode");
			String strForCodeDescription = (String)map.get("opdFrequencyName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 

<h4><a href="opdMaster?method=showOpdFrequencyJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchOpdFrequencyList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="opdMaster?method=showOpdFrequencyJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="opdFrequency" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasOpdFrequency">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="FrequencyName">
<input type="hidden" name="title"	value="Frequency">
<input type="hidden" name="<%=JSP_NAME %>"	value="opdFrequency">
<input type="hidden" name="pojoPropertyCode" value="FrequencyCode"> 
<div class="clear"></div>

<div class="Block">
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<label><span>*</span>  Frequency Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="FrequencyCode,string,yes"  MAXLENGTH="8" tabindex=1 />
<label><span>*</span>  Frequency Name </label>
<input type="text"	name="<%= SEARCH_NAME %>" value="" validate="FrequencyName,string,yes"	 MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=addOpdFrequency')" />
</div>
<script>
document.opdFrequency.<%=CODE%>.focus();
</script> 
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('opdFrequency','opdMaster?method=addOpdFrequency');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('opdFrequency','opdMaster?method=editOpdFrequency')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('opdFrequency','opdMaster?method=deleteOpdFrequency&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Frequency Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Frequency Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";


data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdFrequencyList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasOpdFrequency  opdFrequency = (MasOpdFrequency)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdFrequency.getId()%>
data_arr[<%= counter%>][1] = "<%=opdFrequency.getFrequencyCode()%>"
data_arr[<%= counter%>][2] = "<%= opdFrequency.getFrequencyName()%>"
data_arr[<%= counter%>][3] = "<%= opdFrequency.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(opdFrequency.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= opdFrequency.getLastChgTime() %>"
<% if(opdFrequency.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "opdFrequency"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
