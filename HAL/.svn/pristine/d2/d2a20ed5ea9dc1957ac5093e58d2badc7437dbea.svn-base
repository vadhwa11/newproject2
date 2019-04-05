
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * @author  Priyanka Garg
	 * Create Date: 
	 * Revision Date:      
	 * Revision By:  
	 * @version 1.7
	--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.GregorianCalendar"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	String time1=String.valueOf(calendar.getTime());
	int year=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
		
	%>
	serverdate = '<%=date1+"/"+month1+"/"+year%>'
	</script>

<script type="text/javascript">
	
	
	function add()
	{
			if(checkForQuarter())
			{
				var url="/hms/hms/hrRelated?method=showRangeFiringDutyAddJsp&quarter=" + rangeFiringDuty.quarter.value + "&year=" + rangeFiringDuty.year.value;
				newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1,scrollbars=yes');
			}
	}
	//this function will be called by the Bean (not from JSP)
	function GoPage() {	
		var pgno = parseInt(rangeFiringDuty.gopage.value);
		var totalPages = parseInt(rangeFiringDuty.totalPages.value);
		if (pgno < 1 || pgno > totalPages)
		{
		alert('Invalid Page No!.....');
		return;
		}  
		rangeFiringDuty.pageno.value = pgno; 
		rangeFiringDuty.method="post";
		submitForm('rangeFiringDuty','hrRelated?method=getGridDataForRangeFiringEmployee');
	}
	
	function goNext()
	{
	 var pgno = parseInt(rangeFiringDuty.pageno.value)+1;
	 if (pgno > rangeFiringDuty.totalPages.value)
	 {
	 alert('End of the File Reached!... ');
	 return;
	 }
	 
	 rangeFiringDuty.pageno.value = pgno;
	 rangeFiringDuty.method="post";
	 submitForm('rangeFiringDuty','hrRelated?method=getGridDataForRangeFiringEmployee');
	}
	
	
	function goPrevious()
	{
	 var pgno = parseInt(rangeFiringDuty.pageno.value)-1;
	 
	 if (pgno < 1)
	 {
	 alert('Beginning of the File Reached!... ');
	 return;
	 }
	 
	 rangeFiringDuty.pageno.value = pgno;
	 rangeFiringDuty.method="post";
	 submitForm('rangeFiringDuty','hrRelated?method=getGridDataForRangeFiringEmployee');
	}
	
	function jsUpdate()
	{
			if (validateButton())
			{
			rangeFiringDuty.method="post";
			submitForm('rangeFiringDuty','hrRelated?method=updateRangeFiringDutyEntry');
			}
			else
			alert('Pl. select Employee to Delete!......'); 
	}
	
	function validateButton()
	{
		if (rangeFiringDuty.dutyToBeUpdated.length)
		{
				 for(var i = 0; i < rangeFiringDuty.dutyToBeUpdated.length; i++)
				 {
				  if (rangeFiringDuty.dutyToBeUpdated[i].checked == true)
	             		return true;
				 }
		}
		else
		{
			if (rangeFiringDuty.dutyToBeUpdated.checked == true)
				return true;
		}
		return false;
	}
	
	function checkForQuarter()
	{
		if(document.getElementById("quarter").value=="0" && document.getElementById("year").value=="0")
		{
			alert("Select Quarter and Year!!");
			return false;
		}
		if(document.getElementById("quarter").value=="0")
		{
			alert("Select Quarter!!");
			document.getElementById("year").value="0";
			return false;
		}
		if(document.getElementById("year").value=="0")
		{
			alert("Select Year!!");
			//document.getElementById("quarter").value="0";
			return false;
		}
		return true;
	}	
	</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	Date fromDate=new Date();
	Date toDate=new Date();
		
	List<HrRangeFiringDutyEntry> dutyEntryList = new ArrayList<HrRangeFiringDutyEntry>();
	List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map)request.getAttribute("map");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("dutyEntryList")!=null)
	{
		dutyEntryList = (List)map.get("dutyEntryList");
	}
	if(map.get("fromDate")!=null)
	{
		fromDate = (Date)map.get("fromDate");
	}
	if(map.get("toDate")!=null)
	{
		toDate = (Date)map.get("toDate");
	}
	if(map.get("box")!=null)
	{
		box = (Box)map.get("box");
	}
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}
	if (map.get("dutyMasterList")!=null)
	{
		dutyMasterList = (List)map.get("dutyMasterList");
	}
			
	String message ="";
	%>


<div class="Clear"></div>
<div id="contentHolder">
<% 
	if (map.get("message") != null) {
			 message = (String) map.get("message");
			
		}
	if(!message.equalsIgnoreCase("")){
	%>

<h2><%=message %></h2>
<%} %>
<form name="rangeFiringDuty" action="" method="post">
<h6>Range Firing Duty Entry</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Quarter</label> <select
	name="quarter" id="quarter">
	<option value="0">Select</option>
	<%if(box.get("quarter")!=null  && !box.get("quarter").equals("")){ 
		if(box.get("quarter").equals("Jan-Mar")){
	%>
	<option value="Jan-Mar" selected="selected">Jan-Mar</option>
	<%	}else{ %>
	<option value="Jan-Mar">Jan-Mar</option>
	<%	}if(box.get("quarter").equals("Apr-Jun")){ %>
	<option value="Apr-Jun" selected="selected">Apr-Jun</option>
	<%	}else{ %>
	<option value="Apr-Jun">Apr-Jun</option>
	<%	}if(box.get("quarter").equals("July-Sep")){ %>
	<option value="July-Sep" selected="selected">July-Sep</option>
	<%	}else{ %>
	<option value="July-Sep">July-Sep</option>
	<%	}if(box.get("quarter").equals("Oct-Dec")){ %>
	<option value="Oct-Dec" selected="selected">Oct-Dec</option>
	<%	}else{ %>
	<option value="Oct-Dec">Oct-Dec</option>
	<%	}
	  }else{
	%>
	<option value="Jan-Mar">Jan-Mar</option>
	<option value="Apr-Jun">Apr-Jun</option>
	<option value="July-Sep">July-Sep</option>
	<option value="Oct-Dec">Oct-Dec</option>
	<%	} %>
</select> <%
	String flag= "false";
	Date tempDate=new Date();
	int currentYear=1900+tempDate.getYear();
	int pastYear=1900+tempDate.getYear()-1;
	int futureYear=1900+tempDate.getYear()+1;
	%> <label>Year</label> <select name="year" id="year"
	onblur="submitForm('rangeFiringDuty','hrRelated?method=showRangeFiringDutyRecords','checkForQuarter')"
	onchange="submitForm('rangeFiringDuty','hrRelated?method=showRangeFiringDutyRecords','checkForQuarter')">
	<option value="0">Select</option>
	<%
			if(box.get("year")!=null && !box.get("year").equals("")){
				if(Integer.parseInt(box.get("year"))==pastYear){
		%>
	<option value="<%=pastYear%>" selected="selected"><%=pastYear%></option>
	<%		}else{ %>
	<option value="<%=pastYear%>"><%=pastYear%></option>
	<%		}if(Integer.parseInt(box.get("year"))==currentYear){ %>
	<option value="<%=currentYear%>" selected="selected"><%=currentYear%></option>
	<%		}else{ %>
	<option value="<%=currentYear%>"><%=currentYear%></option>
	<%		}if(Integer.parseInt(box.get("year"))==futureYear){ %>
	<option value="<%=futureYear%>" selected="selected"><%=futureYear%></option>
	<%		}else{ %>
	<option value="<%=futureYear%>"><%=futureYear%></option>
	<%		}
			}else{
		%>
	<option value="<%=pastYear%>"><%=pastYear%></option>
	<option value="<%=currentYear%>"><%=currentYear%></option>
	<option value="<%=futureYear%>"><%=futureYear%></option>
	<%	} %>
</select></div>

<div class="Clear"></div>
<input type="button" name="Add" type="submit" value="Add"
	onClick="add();" class="cmnButton"> <input type="hidden"
	name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="hospitalId" value="<%=hospitalId%>" /> <input type="hidden"
	name="pageno" value=<%=pageno%> /> <input type="hidden"
	name="totalPages" value=<%=totalPages%> /> <input type="hidden"
	name="totalRecords" value=<%=totalRecords%> /> <input type="hidden"
	name="numOfRows" value="10" />
<div class="Clear"></div>

<% if (dutyEntryList != null && dutyEntryList.size()==0) { %>
<div class="blockTitle">Range Firing Duty Entry</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="mmfDepartmentDetails" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Service No.</th>
			<th width="10%">Rank</th>
			<th width="10%">Name</th>
			<th width="13%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>

<% } else if(dutyEntryList != null && dutyEntryList.size()>0){ %>
<div class="blockTitle">Range Firing Duty Entry</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" border="0" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Service No.</th>
			<th width="40%">Rank</th>
			<th width="12%">Name</th>
			<th width="40%">Delete</th>
		</tr>
	</thead>
	<tbody>

		<%
		 int counter=0;
			if(pageno==1)
			{
				counter=1;
			}
			if(pageno>1)
			{
				counter=(10*(pageno-1))+1;
			}
			int iFirstRow=0;
		for(HrRangeFiringDutyEntry hrRangeFiringDutyEntry:dutyEntryList)
		{ 
			iFirstRow++;
	%>
		<%	String msg="";
				if(hrRangeFiringDutyEntry.getEmployee().getFirstName()!=null && !hrRangeFiringDutyEntry.getEmployee().getFirstName().equals(""))
				msg +=hrRangeFiringDutyEntry.getEmployee().getFirstName()+" ";
				if(hrRangeFiringDutyEntry.getEmployee().getMiddleName()!=null && !hrRangeFiringDutyEntry.getEmployee().getMiddleName().equals(""))
					msg +=hrRangeFiringDutyEntry.getEmployee().getMiddleName()+" ";
				if(hrRangeFiringDutyEntry.getEmployee().getLastName()!=null && !hrRangeFiringDutyEntry.getEmployee().getLastName().equals(""))
					msg +=hrRangeFiringDutyEntry.getEmployee().getLastName()+" ";
				%>
		<tr>
			<td><%=counter++%></td>
			<td width="13%"><%=hrRangeFiringDutyEntry.getEmployee().getServiceNo()%></td>
			<td width="40%"><%=hrRangeFiringDutyEntry.getEmployee().getRank().getRankName()%></td>
			<td width="12%"><%=msg%></td>
			<td><input type="checkbox" class="radio" name="dutyToBeUpdated"
				class="smcaption" value="<%=hrRangeFiringDutyEntry.getId()%>">
			</td>
			<input type="hidden" value="<%=hrRangeFiringDutyEntry.getId()%>"
				name="dutyId" />
		</tr>
		<% } %>
	</tbody>
</table>
<% } %>
</div>

<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Previous</a> <a
	href="javascript:goNext()">Next</a> <input type="button" name="Go Page"
	type="submit" value="Go Page" class="button"
	onclick="javascript:GoPage();"> <input type="text"
	name="gopage" size="3" /> <% } %>
</div>
<div class="Clear"></div>

<% if (dutyEntryList!=null && dutyEntryList.size()>0) { %>
<div class="division"></div>
<div class="bottom"><input type="button" name="update"
	onClick="jsUpdate()" value="Delete" class="button" />
<div class="division"></div>
</div>
<%} %>
</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />



