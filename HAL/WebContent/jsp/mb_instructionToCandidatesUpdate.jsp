<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name : instructionToCandidatesUpdate.jsp 
	 * Tables Used    : 
	 * Description    : 
	 * @author  Create Date: 04.06.2009    Name: Vineet Kumar
	 * Revision Date: Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>


<%@ page import="java.text.SimpleDateFormat"%>


<%@page import="jkt.hms.masters.business.MbInstructionToCandidateMaster"%>
<%@page
	import="jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl"%>
<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>
<script language=javascript type="text/javascript">

function checknum()
var cost;

if(document.getElementById('cost'))
	cost = document.getElementById('cost');
	
	else if(hinNo.checked){
		if(!validateNumeric(trimAll(searchValue)))
		{
			alert("Hin No is not valid.");
			document.getElementById('searchField').value = "";
			return false;
		}
</script>

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
serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>


<%	String 	userName="";
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
int Id=0;
if(map.get("Id")!=null)
{
	Id=(Integer)map.get("Id");
}

List<MbInstructionToCandidateMaster> mbInstructionToCandidateMasterList = new ArrayList<MbInstructionToCandidateMaster>();

if (map.get("mbInstructionToCandidateMaster") != null) {
	mbInstructionToCandidateMasterList = (List) map.get("mbInstructionToCandidateMaster");
}

List<MbInstructionToCandidateUnfitExpl> mbInstructionToCandidateUnfitExplList = new ArrayList<MbInstructionToCandidateUnfitExpl>();
if (map.get("mbInstructionToCandidateUnfitExpl") != null) {
	mbInstructionToCandidateUnfitExplList = (List) map.get("mbInstructionToCandidateUnfitExpl");
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
<DIV class="Clear"></DIV>

<div class="Clear"></div>
<div id="contentHolder">
<h6>Instruction To Candidate Update</h6>
<div class="Clear"></div>


<%!int temp = 0;%>

<form name="instructionToCandidatesUpdate" action="" method=post>
<input type="hidden" name="<%=POJO_NAME%>" value=""> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Instruction To Candidate"> <input
	type="hidden" name="<%=JSP_NAME %>" value=instructionToCandidatesUpdate">

<div class="blockFrame">
<div class="Clear"></div>
<label>Entry No.</label> <label class="value"><%=mbInstructionToCandidateMasterList.get(0).getEntryNo()%></label>
<input type="hidden"
	value="<%=mbInstructionToCandidateMasterList.get(0).getEntryNo()%>"
	name="<%=ENTRY_NO%>" tabindex="2" /> <label>Entry Date <span>*</span>
</label> <%if(mbInstructionToCandidateMasterList.get(0).getEntryDate() !=null ) {
    	 String date4MySQL1 ="";
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			 try{
			 date4MySQL1=formatterOut.format(formatterIn.parse(""+mbInstructionToCandidateMasterList.get(0).getEntryDate()));
			 }catch(Exception e1){
				 e1.printStackTrace();
			 }
 
     %> <input validate="Entry Date,date,yes" tabindex="1"
	name="<%=ENTRY_DATE %>" type="text" value="<%=date4MySQL1%>"
	class="calDate" readonly="true" maxlength="10" /> <img height="16"
	border="0" width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.instructionToCandidatesUpdate.<%= ENTRY_DATE%>,event);"
	class="calender" /> <%} %> <input type="hidden" name="Id"
	value="<%=Id %>"> <label>Batch No. <span>*</span> </label> <input
	validate="Batch No,string,yes" type="text"
	value="<%=mbInstructionToCandidateMasterList.get(0).getBatchNo()%>"
	maxlength="25" name="<%=BATCH_NO%>" tabindex="1" />

<div class="Clear"></div>

<label>Chest No. <span>*</span> </label> <input
	validate="Chest No,string,yes" type="text"
	value="<%=mbInstructionToCandidateMasterList.get(0).getChestNo()%>"
	maxlength="25" name="<%=CHEST_NO%>" tabindex="1" /> <label>Name
<span>*</span> </label> <input validate="Name,string,yes" type="text"
	value="<%=mbInstructionToCandidateMasterList.get(0).getName()%>"
	maxlength="30" name="<%=NAME%>" tabindex="1" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockTitle">You have been found unfit due to</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<input type="button" name="service" class="cmnButton" value="Add"
	onclick="generateRowMedicalBoard('amcDetailId');" tabindex="1" /> <input
	type="button" name="service" class="cmnButton" value="Remove"
	onclick="removeRow()" tabindex="1" /> <input type="hidden" size="2"
	value="" name="noOfRecords" id="noOfRecords" />
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
		<%
  
 
  	int inc=1;
  	for ( ;inc <= mbInstructionToCandidateUnfitExplList.size(); inc++) {
  	
  		
  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=INSTRUCTION_TO_CANDIDATE_DETAILS_SRNO%>"
				readonly="readonly" tabindex="1" /> <input type="hidden"
				name="<%=INSTRUCTION_TO_CANDIDATES_UPDATE_ID%>"
				value="<%=mbInstructionToCandidateUnfitExplList.get(inc-1).getId()%>"
				tabindex="1" /></td>

			<td width="10%"><input type="text" size="30"
				value="<%=mbInstructionToCandidateUnfitExplList.get(inc-1).getUnfitExplanation()%>"
				name="unfitExp" onBlur="fillValuesMedicalDetails(<%=inc%>);"
				validate="Disabilities,String,yes" tabindex="1" maxlength="30" /></td>
		</tr>
		<%
   	}
   %>
	</tbody>

</table>
<input type="hidden" name="rows" id="rr" value="1" /></div>

<div class="Clear"></div>

<!--Block Two Starts--> <!--table-->
<div class="division"></div>
<div class="bottom"><input name="Button" type="button"
	class="button" value="Update"
	onClick="submitForm('instructionToCandidatesUpdate','instructionToCandidatesUpdate?method=editInstructionToCandidatesUpdate');"
	tabindex="1" /> <input name="Button" type="button" class="button"
	value="Reset" onclick=resetCheck(); tabindex="1" /> <input
	name="Button" type="button" class="button2"
	onClick="submitForm('instructionToCandidatesUpdate','instructionToCandidatesUpdate?method=printMedicalBoard');"
	value="Print Medical Board Proceedings" tabindex="1" />
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



