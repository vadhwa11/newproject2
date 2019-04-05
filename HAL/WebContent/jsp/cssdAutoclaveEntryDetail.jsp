<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


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



<script language="javascript">

function GoPage() 
{	
	var pgno = parseInt(autoclaveEntryDetailForm.gopage.value);
	var totalPages = parseInt(autoclaveEntryDetailForm.totalPages.value);
	
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	  
	autoclaveEntryDetailForm.pageno.value = pgno;
	submitProtoAjax('autoclaveEntryDetailForm','/hms/hms/cssd?method=getAutoclaveRequestEntryGridDataForAutoclaveEntry'); 
}


function goNext()
{
 var pgno = parseInt(autoclaveEntryDetailForm.pageno.value)+1;
 
 if (pgno > autoclaveEntryDetailForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 autoclaveEntryDetailForm.pageno.value = pgno;
 submitProtoAjax('autoclaveEntryDetailForm','/hms/hms/cssd?method=getAutoclaveRequestEntryGridDataForAutoclaveEntry');
}


function goPrevious()
{
 var pgno = parseInt(autoclaveEntryDetailForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 autoclaveEntryDetailForm.pageno.value = pgno;
 submitProtoAjax('autoclaveEntryDetailForm','/hms/hms/cssd?method=getAutoclaveRequestEntryGridDataForAutoclaveEntry');
}

function submitEntryDetails()
{
var autoclaveBy = document.getElementById('autoclaveBy').value;
var flag = document.getElementById('flag').value;
var autoclaveTime = document.getElementById('autoclaveTime').value;

if (flag=="no")
{
alert('No Records to Submit!...');
return;
}

if (autoclaveTime == 0)
{
alert('Autoclave Time is mandatory !...');
return;
}

if (autoclaveBy==0)
{
alert('Autoclave By is mandatory !...');
return;
}

autoclaveEntryDetailForm.method="post"; 
submitForm('autoclaveEntryDetailForm','cssd?method=submitEntryDetails')
}


function deleteItems(request_t_id, request_m_id)
{
autoclaveEntryDetailForm.pageno.value = 1;
submitProtoAjax('autoclaveEntryDetailForm','/hms/hms/cssd?method=deleteCssdEntryGridItems&request_t_id='+request_t_id + '&request_m_id=' + request_m_id);
}

</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String lotNo = "-";
	String batchNo = "";
	
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("entryNo")!=null)
		entryNo = map.get("entryNo").toString();
	
	if (map.get("batchNo")!=null)
		batchNo = map.get("batchNo").toString();
	
	if (map.get("lotNo")!=null)
		lotNo = map.get("lotNo").toString();
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	ArrayList<MasEmployee> masEmployeeList = (ArrayList<MasEmployee>)map.get("masEmployeeList");
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = (ArrayList<CssdAutoclaveRequestT>)map.get("cssdAutoclaveRequestTList");
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	
	int pageno=0;
	int totalPages = 0;
	int totalRecords=0;
	int numOfRows=0;
	
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
	
	if (map.get("numOfRows")!=null)
	{
		numOfRows = Integer.parseInt(map.get("numOfRows").toString());
	}
	
	int i = (pageno - 1) * numOfRows;
%>

<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="autoclaveEntryDetailForm">

<h6>Autoclave Entry Detail</h6>
<div class="Clear"></div>
<!--Block One Starts-->
<div class="blockFrame"><label>Entry No.</label> <label
	class="value"><%=entryNo %></label> <input type="hidden" name="entryNo"
	value="<%=entryNo %>" /> <label class="common"><span>*</span>Autoclave
Date</label> <input type="text" class="calDate" id="autoclaveDate"
	name="autoclaveDate" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" /> <!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.autoclaveEntryDetailForm.autoclaveDate,event)"/>
 --> <label class="common"><span>*</span>Autoclave Time</label> <input
	type="text" id="autoclaveTime" name="autoclaveTime"
	value="<%=time.substring(0,5) %>" readonly="readonly" />

<div class="Clear"></div>
<label>Lot No.</label> <label class="value"><%=lotNo%></label> <input
	type="hidden" name="lot_no" value="<%=lotNo%>" /> <label
	class="common"><span>*</span>Status</label> <select name="entry_status"
	id="entry_status">
	<option value="Autoclave">Autoclave</option>
	<option value="Waiting">Waiting</option>
	<option value="InProcess">InProcess</option>
</select> <label class="common"><span>*</span>Sterilization Type</label> <select
	name="sterilization_type" id="sterilization_type">
	<option value="Steam">Steam</option>
	<option value="Dry Heat">Dry Heat</option>
	<option value="Ethylene Oxide">Ethylene Oxide</option>
</select>

<div class="Clear"></div>

<label class="common"><span>*</span>Chemical Indicator</label> <select
	name="chemical_indicator" id="chemical_indicator">
	<option value="Y">Yes</option>
	<option value="N">No</option>
</select> <label>Temperature</label> <input type="text" name="temperature"
	MAXLENGTH="10" /> <label>Pressure</label> <input type="text"
	name="pressure" MAXLENGTH="10" />

<div class="Clear"></div>


<label>Total Time</label> <input type="text" name="total_time"
	MAXLENGTH="10" /> <label>Batch No.</label> <input type="text"
	name="cycle_no" value="<%=batchNo%>" MAXLENGTH="10" /> <label
	class="common"><span>*</span>Autoclave By</label> <select
	name="autoclaveBy" id="autoclaveBy">
	<option value="0">Select Employee</option>
	<%
for(MasEmployee masEmployee : masEmployeeList)
{
	StringBuffer empName = new StringBuffer();
	empName.append(masEmployee.getFirstName()==null?"":masEmployee.getFirstName());
	empName.append(" ");
	empName.append(masEmployee.getMiddleName()==null?"":masEmployee.getMiddleName());
	empName.append(" ");
	empName.append(masEmployee.getLastName()==null?"":masEmployee.getLastName());
%>
	<option value="<%=masEmployee.getId()%>"><%=empName%></option>
	<%
}
%>
</select>

<div class="Clear"></div>
</div>
<!--Block one Ends--> <!--Block Two Starts-->
<div id="testDiv"><input type="hidden" name="pageno"
	value=<%=pageno%> /> <input type="hidden" name="totalPages"
	value=<%=totalPages%> /> <input type="hidden" name="totalRecords"
	value=<%=totalRecords%> /> <input type="hidden" name="numOfRows"
	value=5 /> <% for(CssdAutoclaveRequestM cssdAutoclaveRequestM : cssdAutoclaveRequestMList) { %>
<input type="hidden" name="requestId"
	value="<%=cssdAutoclaveRequestM.getId()%>" /> <% } %>

<div class="division"></div>
<div class="blockTitle">Autoclave Entry Details</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Material/Container Name</th>
		<th>Instrument Name</th>
		<th>Department Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
		<th>Delete</th>
	</tr>

	<% if (cssdAutoclaveRequestTList!=null && cssdAutoclaveRequestTList.size() > 0 )  { %>
	<input type="hidden" id="flag" value="yes" />
	<% } else { %>
	<input type="hidden" id="flag" value="no" />
	<% } %>

	<% for (CssdAutoclaveRequestT cssdAutoclaveRequestT : cssdAutoclaveRequestTList) { %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdAutoclaveRequestT.getMaterial().getMaterialName()%></td>
		<td><%=cssdAutoclaveRequestT.getInstrument().getInstrumentName()%></td>
		<td><%=cssdAutoclaveRequestT.getRequestM().getDepartment().getDepartmentName()%></td>
		<td><%=cssdAutoclaveRequestT.getQty()%></td>
		<td><%=cssdAutoclaveRequestT.getRemarks()%></td>
		<td><input type="button" name="Delete" class="button"
			value="Delete"
			onClick="deleteItems('<%=cssdAutoclaveRequestT.getId()%>','<%=cssdAutoclaveRequestT.getRequestM().getId()%>')" /></td>
	</tr>
	<% } %>

</table>
</div>
</div>
<div id="pagination">
<% if (totalPages > 0 ) { %> <label>Page <%=pageno %> of <%=totalPages %></label>
<label><a href="javascript:goPrevious()">Prev<<</a>&nbsp;&nbsp;</label>
<label><a href="javascript:goNext()">>>Next</a></label> <input
	type="text" name="gopage" size="3" /> <label><input
	type="button" name="Go Page" class="cmnButton" type="submit"
	value="Go Page" onclick="javascript:GoPage();"></label> <% } %>
</div>
</div>

<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="hidden" name="lastChgBy" value="<%=userName%>" /> <input
	type="hidden" name="lastChgDate" value="<%=currentDate%>" /> <input
	type="hidden" name="lastChgTime" value="<%=time%>" /> <input
	name="save" type="button" class="button" value="Submit"
	onClick="submitEntryDetails()" />
<div class="Clear"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time %></label></div>
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
</div>


