<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>


<script type="text/javascript">
    function removeRow()
	{
	  var tbl = document.getElementById('amcDetailId');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("Unfit Explanation should have at least one row");
	  
	}
	
	  
	</script

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
	<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>


<!--main content placeholder starts here-->

<%
	String userName = "";

	String previousPage = "no";
	int pageNo = 1;

	Map<String, Object> map = new HashMap<String, Object>();
	List<MasUnit> masUnitList = new ArrayList();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("masUnitList") != null) {
		masUnitList = (List) map.get("masUnitList");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String entryNo = "";
	if (map.get("entryNo") != null) {
		entryNo = (String) map.get("entryNo");
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
<h6>Certificate By The Candidate Entry</h6>
<div class="Clear"></div>


<%!int temp = 0;%>

<form name="certificateByTheCandidate" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value=""> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Certificate By The Candidate">
<input type="hidden" name="<%=JSP_NAME %>"
	value=certificateByTheCandidate">

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Entry No.</label> <label class="value"><%=entryNo%></label>
<input type="hidden" value="<%=entryNo %>" name="<%=ENTRY_NO%>"
	tabindex="2" maxlength="5" validate="Entry No,int,yes" /> <label
	class="medium">Entry Date <span>*</span></label> <input tabindex="1"
	validate="Entry Date,date,yes" name="<%=ENTRY_DATE %>" type="text"
	value="<%=date%>" class="calDate" readonly="true" maxlength="12" /> <img
	height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.certificateByTheCandidate.<%= ENTRY_DATE%>,event);"
	class="calender" /> <label class="medium">Batch No. <span>*</span></label>
<input validate="Batch No,string,yes" type="text" value=""
	name="<%=BATCH_NO%>" tabindex="1" maxlength="25" />

<div class="Clear"></div>

<label class="medium">Chest No. <span>*</span></label> <input
	validate="Chest No,string,yes" type="text" value=""
	name="<%=CHEST_NO%>" tabindex="1" maxlength="25" /> <label
	class="medium">Name <span>*</span></label> <input
	validate="Name,string,yes" type="text" value="" name="<%=NAME%>"
	tabindex="1" maxlength="30" /> <label class="medium">Place <span>*</span></label>
<input validate="Place,string,yes" type="text" value=""
	name="<%=PLACE%>" tabindex="1" maxlength="30" /></div>
<div class="Clear"></div>

<div class="blockTitle">Found Medically Unfit Due To</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="Height10"></div>

<input tabindex="1" type="button" name="service" class="cmnButton"
	value="Add" onclick="generateRowMedicalBoard('amcDetailId');" /> <input
	tabindex="1" type="button" name="service" class="cmnButton" id="Remove"
	value="Remove" onclick="removeRow()" /> <input type="hidden" size="2"
	value="1" name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Unfit Explanation</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="5%"><input tabindex="1" type="text" size="2"
				value="1" id="<%=CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO%>"
				name="<%=CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO%>"
				readonly="readonly" /></td>

			<td width="10%"><input tabindex="1" type="text" size="30"
				value="" name="unfit"
				id="<%=CERTIFICATE_BY_CANDIDATE_DETAILS_UNFIT_EXPL%>"
				validate="Unfit Explanation,String,yes" maxlength="30"></td>
		</tr>
	</tbody>
</table>

<input type="hidden" name="rows" id="rr" value="1" /></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="large">Opt to Report
for Appeal Examination<span>*</span></label> <select id="OptToReport"
	name="<%=OPT_TO_REPORT %>"
	validate="Opt To Report For appeal Examination,string,yes" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<% 
			for(MasUnit masUnit : masUnitList){
		%>
	<option value="<%=masUnit.getUnitName() %>"><%=masUnit.getUnitName() %></option>
	<%} %>
</select></div>
<!--Block Two Starts--> <!--table-->
<div class="division"></div>
<div class="bottom"><input tabindex="1" name="Button"
	type="button" class="button" value="Submit"
	onClick="submitForm('certificateByTheCandidate','certificateByTheCandidate?method=addCertificateByTheCandidate');" />
<input tabindex="1" name="Button" type="button" class="button"
	value="Reset" onclick=resetCheck(); /> <input tabindex="1"
	name="Button" type="button" class="button" value="Search"
	onClick="submitForMedicalBoard('certificateByTheCandidate');" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>


</div>
</form>
</div>
