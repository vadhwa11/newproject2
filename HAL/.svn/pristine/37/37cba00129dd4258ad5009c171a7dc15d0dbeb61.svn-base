<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name : certificateByTheCandidateUpdate.jsp 
	 * Tables Used    : 
	 * Description    : 
	 * @author  Create Date: 09.06.2009    Name: Vineet Kumar
	 * Revision Date: Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>


<%@ page import="java.text.SimpleDateFormat"%>


<%@page import="jkt.hms.masters.business.MbCertificateByCandidateMaster"%>
<%@page
	import="jkt.hms.masters.business.MbCertificateByCandidateUnfitExpl"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
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
List<MbCertificateByCandidateMaster> mbCertificateByTheCandidateMasterList = new ArrayList<MbCertificateByCandidateMaster>();
if(map.get("Id")!=null)
{
	Id=(Integer)map.get("Id");
}
if (map.get("mbCertificateByTheCandidateMaster") != null) {
	mbCertificateByTheCandidateMasterList = (List) map.get("mbCertificateByTheCandidateMaster");
}

List<MbCertificateByCandidateUnfitExpl> mbCertificateByTheCandidateUnfitExpl = new ArrayList<MbCertificateByCandidateUnfitExpl>();
if (map.get("mbCertificateByTheCandidateUnfitExpl") != null) {
	mbCertificateByTheCandidateUnfitExpl = (List) map.get("mbCertificateByTheCandidateUnfitExpl");
}

List<MasUnit> masUnitList = new ArrayList();
if (map.get("masUnitList") != null) {
	masUnitList = (List) map.get("masUnitList");
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
<h6>Certificate By The Candidate Update</h6>
<div class="Clear"></div>


<%!int temp = 0;%>

<form name="certificateByTheCandidatesUpdate" action="" method=post>
<input type="hidden" name="<%=POJO_NAME%>" value=""> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Certificate By The Candidate">
<input type="hidden" name="<%=JSP_NAME %>"
	value=certificateByTheCandidatesUpdate">

<div class="blockFrame">
<div class="Clear"></div>
<label>Entry No.</label> <label class="value"><%=mbCertificateByTheCandidateMasterList.get(0).getEntryNo()%></label>
<input type="hidden"
	value="<%=mbCertificateByTheCandidateMasterList.get(0).getEntryNo()%>"
	name="<%=ENTRY_NO%>" tabindex="2" /> <label>Entry Date <span>*</span></label>
<%if(mbCertificateByTheCandidateMasterList.get(0).getEntryDate() !=null ) {
    	 String date4MySQL1 ="";
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			 try{
			 date4MySQL1=formatterOut.format(formatterIn.parse(""+mbCertificateByTheCandidateMasterList.get(0).getEntryDate()));
			 }catch(Exception e1){
				 e1.printStackTrace();
			 }
 
     %> <input validate="Entry Date,date,yes" name="<%=ENTRY_DATE %>"
	tabindex="1" type="text" value="<%=date4MySQL1%>" class="calDate"
	maxlength="10" /> <img height="16" border="0" width="16"
	src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.certificateByTheCandidatesUpdate.<%= ENTRY_DATE%>,event);"
	class="calender" /> <%} %> <label>Batch No. <span>*</span></label> <input
	validate="Batch No,string,yes" type="text" maxlength="25"
	value="<%=mbCertificateByTheCandidateMasterList.get(0).getBatchNo()%>"
	name="<%=BATCH_NO%>" tabindex="1" />
<div class="Clear"></div>
<label>Chest No. <span>*</span></label> <input
	validate="Chest No,string,yes" type="text" maxlength="25"
	value="<%=mbCertificateByTheCandidateMasterList.get(0).getChestNo()%>"
	name="<%=CHEST_NO%>" tabindex="1" /> <label>Name <span>*</span></label>
<input validate="Name,string,yes" type="text" maxlength="30"
	value="<%=mbCertificateByTheCandidateMasterList.get(0).getName()%>"
	name="<%=NAME%>" tabindex="1" /> <label>Place <span>*</span></label> <input
	validate="Place,string,yes" type="text"
	value="<%=mbCertificateByTheCandidateMasterList.get(0).getPlace() %>"
	name="<%=PLACE%>" tabindex="1" maxlength="30" />
<div class="Clear"></div>

</div>


<div class="division"></div>
<div class="blockTitle">Found Medically Unfit Due To</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<input type="button" tabindex="1" name="service" class="cmnButton"
	value="Add" onclick="generateRowMedicalBoard('amcDetailId');" /> <input
	type="button" tabindex="1" name="service" class="cmnButton"
	value="Remove" onclick="removeRow()" /> <input type="hidden" size="2"
	value="" name="noOfRecords" id="noOfRecords" /> <input type="hidden"
	name="Id" value="<%=Id %>">
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
  
  
  	String unfitExplanationtemp = "unfitExplanationtemp";  	

  	String unfitExplanationtemp2 = "unfitExplanationtemp";
  	int inc=1;
  	for ( ;inc <= mbCertificateByTheCandidateUnfitExpl.size(); inc++) {  		
  		unfitExplanationtemp = unfitExplanationtemp2 + ("" + inc);
  %>
		<tr>
			<td width="5%"><input tabindex="1" type="text" size="2"
				value="<%=inc%>" name="<%=CERTIFICATE_BY_CANDIDATE_DETAILS_SRNO%>"
				readonly="true" /> <input tabindex="1" type="hidden"
				name="<%=CERTIFICATE_BY_CANDIDATES_UPDATE_ID%>"
				value="<%=mbCertificateByTheCandidateUnfitExpl.get(inc-1).getId()%>" />
			</td>

			<td width="10%"><input tabindex="1" maxlength="30" type="text"
				size="30"
				value="<%=mbCertificateByTheCandidateUnfitExpl.get(inc-1).getUnfitExplanation()%>"
				name="unfitExp" id="<%=unfitExplanationtemp%>"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				validate="Unfit Explanation,String,yes"></td>
		</tr>
		<%
   	}
   %>
	</tbody>

</table>
<input type="hidden" name="rows" id="rr" value="1" /></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="large2">Opt to
Report for Appeal Examination <span>*</span></label> <select id="OptToReport"
	name="<%=OPT_TO_REPORT %>"
	validate="Opt To Report For appeal Examination,string,yes" tabindex="1"
	class="select_adt">
	<option
		value="<%=mbCertificateByTheCandidateMasterList.get(0).getOptReportAppealExamination()%>"><%=mbCertificateByTheCandidateMasterList.get(0).getOptReportAppealExamination()%></option>
	<% 
			for(MasUnit masUnit : masUnitList){
		%>
	<option value="<%=masUnit.getUnitName()%>"><%=masUnit.getUnitName() %></option>
	<%} %>
</select>
<div class="Clear"></div>
</div>

<!--Block Two Starts-->

<div class="Clear"></div>
<!--table-->
<div class="division"></div>
<div class="bottom"><input tabindex="1" name="Button"
	type="button" class="button" value="Update"
	onClick="submitForm('certificateByTheCandidatesUpdate','certificateByTheCandidatesUpdate?method=editCertificateByTheCandidatesUpdate');" />
<input tabindex="1" name="Button" type="button" class="button"
	value="Reset" onclick=resetCheck(); /> <input tabindex="1"
	name="Button" type="button" class="button2"
	onClick="submitForm('certificateByTheCandidatesUpdate','certificateByTheCandidatesUpdate?method=printMedicalBoard');"
	value="Print Medical Board Proceedings" />
<div class="division"></div>
<label>Changed B</label> <label class="value"><%=userName%></label> <label>Changed
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



