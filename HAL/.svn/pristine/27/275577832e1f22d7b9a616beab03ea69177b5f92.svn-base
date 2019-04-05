<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>




<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>


<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
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
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
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
<h6>Instruction To Candidate Found Unfit by Special Medical Board</h6>
<div class="Clear"></div>


<%!int temp = 0;%>

<form name="instructionToCandidate" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value=""> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Instruction To Candidate"> <input
	type="hidden" name="<%=JSP_NAME %>" value=instructionToCandidate">

<div class="blockFrame">
<div class="Clear"></div>

<label class="medium">Entry No.</label> <label class="value"><%=entryNo%></label>
<input type="hidden" value="<%=entryNo %>" name="<%=ENTRY_NO%>"
	tabindex="2" /> <label class="medium">Entry Date<span>*</span></label>
<input tabindex="1" name="<%=ENTRY_DATE %>" type="text"
	value="<%=date%>" class="calDate" readonly="true" maxlength="10"
	validate="Entry Date,date,yes" /> <img height="16" border="0"
	width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.instructionToCandidate.<%= ENTRY_DATE%>,event);"
	class="calender" /> <label class="medium">Batch No.<span>*</span></label>
<input type="text" value="" class="calDate" name="<%=BATCH_NO%>"
	tabindex="1" maxlength="25" validate="Batch No,string,yes" />

<div class="Clear"></div>

<label class="medium">Chest No.<span>*</span></label> <input type="text"
	value="" name="<%=CHEST_NO%>" tabindex="1" maxlength="25"
	validate="Chest No,string,yes" /> <label class="medium">Name<span>*</span></label>
<input type="text" value="" name="<%=NAME%>" tabindex="1" maxlength="30"
	validate="Name,string,yes" /></div>
<div class="Clear"></div>
<div class="blockTitle">You Have Been Found Unfit Due To</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="Height10"></div>
<input type="button" tabindex="1" name="service" class="cmnButton"
	value="Add" onclick="generateRowMedicalBoard('amcDetailId');" /> <input
	type="button" tabindex="1" name="service" class="cmnButton" id="Remove"
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
				value="1" id="<%=INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO%>"
				name="<%=INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO%>"
				readonly="readonly" /></td>

			<td width="10%"><input tabindex="1" type="text" size="30"
				value="" name="unfit"
				id="<%=INSTRUCTION_TO_CANDIDATE_DETAILS_UNFIT_EXPL%>"
				validate="Unfit Explanation,String,yes" maxlength="30" /></td>
		</tr>
	</tbody>
</table>

<input type="hidden" name="rows" id="rr" value="1" /></div>

<div class="Clear"></div>

<!--Block Two Starts--> <!--table-->
<div class="division"></div>
<div class="bottom"><input name="Button" type="button"
	class="button" value="Submit" tabindex="1"
	onClick="submitForm('instructionToCandidate','instructionToCandidate?method=addInstructionToCandidate');" />
<input name="Button" type="button" class="button" value="Reset"
	tabindex="1" onclick=resetCheck(); /> <input name="Button"
	type="button" class="button" value="Search" tabindex="1"
	onClick="submitForMedicalBoard('instructionToCandidate');" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>
