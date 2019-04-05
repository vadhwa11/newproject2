<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdInstructionTreatment.jsp  
 * Purpose of the JSP -  This is for All OpdInstructionTreatment Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdInstructionTreatmentList = (ArrayList)map.get("searchOpdInstructionTreatmentList");

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
		  <h4><span><%=message %></span></h4>
		 
		 <% }%>
<div class="titleBg">
<h2>Opd Instruction Treatment</h2>
</div>
<div class="clear"></div>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label class="auto">Instruction Treatment Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label  class="auto">Instruction Treatment Name</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Instruction TreatmentCode,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdInstructionTreatment')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','opdMaster?method=searchOpdInstructionTreatment','checkSearch')" tabindex=1 />
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
		if(searchOpdInstructionTreatmentList.size()>0)
		 {
			String strForCode = (String)map.get("opdInstructionTreatmentCode");
			String strForCodeDescription = (String)map.get("opdInstructionTreatmentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 

<h4><a href="opdMaster?method=showOpdInstructionTreatmentJsp">Show All
Records</a></h4> <%
			}
		 }
	 if(searchOpdInstructionTreatmentList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="opdMaster?method=showOpdInstructionTreatmentJsp">Show
All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
	<div class="clear"></div>
<form name="opdInstructionTreatment" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="OpdInstructionTreatment">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="OpdInstructionTreatmentName">
<input type="hidden" name="title" value="OpdInstructionTreatment">
<input	type="hidden" name="<%=JSP_NAME %>" value="opdInstructionTreatment">
<input type="hidden" name="pojoPropertyCode"	value="OpdInstructionTreatmentCode"> 

<div class="clear"></div>
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
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label  class="auto">Instruction Treatment Code <span>*</span></label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Instruction TreatmentCode,string,yes" MAXLENGTH="8"  tabindex=1 />
<label class="auto"> Instruction Treatment Name <span>*</span> </label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Instruction TreatmentName,string,yes" MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'opdMaster?method=addOpdInstructionTreatment')" />
</div>
<script>
document.opdInstructionTreatment.<%=CODE%>.focus();
</script> 

<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('opdInstructionTreatment','opdMaster?method=addOpdInstructionTreatment');" accesskey="a" tabindex=1 />
	<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('opdInstructionTreatment','opdMaster?method=editOpdInstructionTreatment')"	accesskey="u" tabindex=1 />
	<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('opdInstructionTreatment','opdMaster?method=deleteOpdInstructionTreatment&flag='+this.value)"	accesskey="d" tabindex=1 />
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
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
		<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
</div>


</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Instruction Treatment Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Instruction Treatment Name"
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
Iterator itr=searchOpdInstructionTreatmentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             OpdInstructionTreatment  opdInstructionTreatment = (OpdInstructionTreatment)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdInstructionTreatment.getId()%>
data_arr[<%= counter%>][1] = "<%=opdInstructionTreatment.getOpdInstructionTreatmentCode()%>"
data_arr[<%= counter%>][2] = "<%= opdInstructionTreatment.getOpdInstructionTreatmentName()%>"
data_arr[<%= counter%>][3] = "<%= opdInstructionTreatment.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(opdInstructionTreatment.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= opdInstructionTreatment.getLastChgTime() %>"
<% if(opdInstructionTreatment.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "opdInstructionTreatment"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
