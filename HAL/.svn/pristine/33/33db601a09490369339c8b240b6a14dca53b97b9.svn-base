
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page
	import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="sun.font.Script"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>template one</title>

<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page
	import="jkt.hms.masters.business.MasMedicalBoardExaminationDetail"%>



<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script language=javascript src="/hms/jsp/js/common.js"></script>

<SCRIPT>
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>


<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide6', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide7', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide8', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide9', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide10', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide11', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide12', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide13', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()


</script>
<SCRIPT>
	<%

		Calendar calendar1=Calendar.getInstance();
		String month1=String.valueOf((calendar1.get(Calendar.MONTH))+1);
		String dateCal1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar1.YEAR);
		if(month.length()<2){
			month1="0"+month1;
		}
		if(dateCal1.length()<2){
			dateCal1="0"+dateCal1;
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasUnit> masUnitList1 = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
int Id=0;
List<MasMedicalBoardExaminationDetail>medicalBoardExaminationDetailList1=new ArrayList<MasMedicalBoardExaminationDetail>();
List<MasMedicalExaminationReportOnEntry>medicalExaminationBoardList1=new ArrayList<MasMedicalExaminationReportOnEntry>();	
if(map.get("medicalBoardExaminationDetailList")!=null)
{
	medicalBoardExaminationDetailList1 = (List) map.get("medicalBoardExaminationDetailList");
	
	
}
if(map.get("medicalExaminationBoardList")!=null)
{
	medicalExaminationBoardList1 = (List) map.get("medicalExaminationBoardList");
System.out.println("medicalExaminationBoardList1-ur8"+medicalExaminationBoardList1.get(0).getUR8());
}


if(map.get("Id")!=null)
{
	Id=(Integer)map.get("Id");
}




if(map.get("medicalEntryNo")!=null)
{
	entryno = (String) map.get("medicalEntryNo");

}
if(map.get("medicalEntryNo1")!=null)
{
	entryno1 = (String) map.get("medicalEntryNo1");

}

if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");

}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");

}
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");

}


if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}

String f = "";
%>
</script>
<script type="text/javascript">
<%
String entrydate="";
String dateOfBirth="";
String dateOfReporting="";
String documentForwardDate="";
String dateOfCompletion="";
String eyeDate="";
String dateOfLastConfinement="";
String surgeryDate="";
String medicinDate="";
String teethDate="";
String earDate="";

if(medicalExaminationBoardList1.get(0).getEarDate()!=null)
{
	earDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getEarDate());
}
else
{
	earDate="";
}
if(medicalExaminationBoardList1.get(0).getMediceExamDate()!=null)
{
	medicinDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getMediceExamDate());
}
else
{
	medicinDate="";
}


if(medicalExaminationBoardList1.get(0).getSurgeryDate()!=null)
{
	surgeryDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getSurgeryDate());
}
else
{
	surgeryDate="";
}


if(medicalExaminationBoardList1.get(0).getDocumentForwardDate()!=null)
{
documentForwardDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDocumentForwardDate());
}
else
{
	documentForwardDate="";
}
if(medicalExaminationBoardList1.get(0).getDateOfCompletion()!=null)
{
dateOfCompletion=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateOfCompletion());
}
else
{
	dateOfCompletion="";
}
if(medicalExaminationBoardList1.get(0).getDateOfReporting()!=null)
{
dateOfReporting=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateOfReporting());
}
else
{
	dateOfReporting="";
}
if(medicalExaminationBoardList1.get(0).getEntryDate()!=null)
{
entrydate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getEntryDate());
}
else
{
	entrydate="";	
}
if(medicalExaminationBoardList1.get(0).getDateOfBirth()!=null)
{
dateOfBirth=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateOfBirth());
}
else
{
	dateOfBirth="";
}
if(medicalExaminationBoardList1.get(0).getDateSpecialExam()!=null)
{
eyeDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateSpecialExam());
}
else
{
	eyeDate="";
}
if(medicalExaminationBoardList1.get(0).getLastConfinementDate()!=null)
{
dateOfLastConfinement=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getLastConfinementDate());
}
else
{
dateOfLastConfinement="";
}

if(medicalExaminationBoardList1.get(0).getDateTeath()!=null)
{
	teethDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateTeath());	
}
else
{
	teethDate="";
}

%>
</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Medical Examination Report On Entry (AFMSF-2)</h6>
<div class="Clear"></div>
<form name="medicalBoardExaminationUpdateReport" action="" method="post">
<!--Block One Starts-->
<div class="blockFrame"><input type="hidden" name="Id"
	value="<%=Id %>"> <label>Yearly Serial No. <span>*</span>
</label> <%if(medicalExaminationBoardList1.get(0).getYearlySerialNo()!=null) { %>
<label class="value"><%=medicalExaminationBoardList1.get(0).getYearlySerialNo() %></label>
<% }else{%> <label class="value"></label> <%} %> <label>Monthly
Serial No. <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getMonthlySerialNo()!=null) { %>
<label class="value"><%=medicalExaminationBoardList1.get(0).getMonthlySerialNo() %></label>
<%}else{ %> <label class="value"></label> <%} %> <label>Entry Date <span>*</span>
</label> <%if(medicalExaminationBoardList1.get(0).getEntryDate()!=null){ %> <input
	tabindex="1" name="<%=ENTRY_OF_DATE %>" option value="<%=entrydate%>"
	validate="Entry Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=ENTRY_OF_DATE%>,event)" ; />
<div class="Clear"></div>
<%}else{ %> <input tabindex="1" name="<%=ENTRY_OF_DATE %>"
	readonly="readonly" validate="Entry Date,String,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=ENTRY_OF_DATE%>,event)" ; />
<div class="Clear"></div>
<%} %> <label>Type of Entry <span>*</span> </label> <select
	name="<%= TYPE_OF_ENTRY %>" tabindex=1
	validate="Type Of Entry,String,yes">
	<option value=""></option>
	<%
		for (MbTypeOfEntryMaster mbTypeOfEntryMaster : typeOfEntryMasterList) {
	
	
if(medicalExaminationBoardList1.get(0).getTypeOfEntry().getId().equals(mbTypeOfEntryMaster.getId())){
%>
	<option value="<%=mbTypeOfEntryMaster.getId()%>" selected="selected">
	<%=mbTypeOfEntryMaster.getTypeName()%></option>
	<%}else{ %>
	<option value="<%=mbTypeOfEntryMaster.getId()%>"><%=mbTypeOfEntryMaster.getTypeName()%></option>

	<%
		}
	%>
	<%} %>
</select> <label>Batch No. <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getBatchNo()!=null){ %>
<input tabindex="1" name="<%=BATCH1_NO %>" type="text"
	value="<%=medicalExaminationBoardList1.get(0).getBatchNo()%>"
	validate="Batch No,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%}else{ %> <input tabindex="1"
	name="<%=BATCH1_NO %>" type="text" validate="Batch No,String,yes"
	onKeyDown="limitText(this,25);" onKeyUp="limitText(this,25);" /> <%} %> <label>Chest
No. <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getChestNo()!=null){ %>
<input tabindex="1" name="<%=CHEST_NO %>" option
	value="<%=medicalExaminationBoardList1.get(0).getChestNo()%>"
	type="text" validate="Chest No,String,yes"
	onKeyDown="limitText(this,25);" onKeyUp="limitText(this,25);" />
<div class="Clear"></div>
<%}else{ %> <input tabindex="1" name="<%=CHEST_NO %>" type="text"
	validate="Chest No,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" />
<div class="Clear"></div>
<%} %> <label>Roll No. <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getRollNo()!=null){ %>
<input tabindex="1" name="<%=ROLL_NO %>" type="text" option
	value="<%= medicalExaminationBoardList1.get(0).getRollNo()%>"
	onkeyup="isNumber(this)" onKeyDown="limitText(this,10);"
	onKeyUp="limitText(this,10);" validate="Roll No,String,yes" /> <%}else{ %>
<input tabindex="1" name="<%=ROLL_NO %>" type="text"
	onkeyup="isNumber(this)" onKeyDown="limitText(this,10);"
	onKeyUp="limitText(this,10);" validate="Roll No,String,yes" /> <%} %> <label>Medical
exam held <span>*</span> </label> <select name="<%= MEDICAL_EXAM_HELD_AT %>"
	tabindex=1 validate="Medical Exam Held At,String,yes">
	<option value=""></option>
	<%
		for (MasUnit masUnit1 : masUnitList) {
			if(medicalExaminationBoardList1.get(0).getMedicalExamHeldAt()!=null){
				if(true){
			if(medicalExaminationBoardList1.get(0).getMedicalExamHeldAt().getId() == masUnit1.getId()){		

	%>

	<option value="<%=masUnit1.getId()%>" selected="selected"><%=masUnit1.getUnitName()%></option>

	<%}else %>
	<option value="<%=masUnit1.getId()%>"><%=masUnit1.getUnitName()%></option>

	<%
}}}

	%>

</select> <label>Medical Status <span>*</span> </label> <select
	name="<%= MEDICAL_STATUS %>" option value=index=1
	validate="Medical Status,String,yes">
	<option value=""></option>

	<%
		for (MasMedicalExaminationReportOnEntry masMedical : medicalExaminationBoardList1) {
%>
	<%if(medicalExaminationBoardList1.get(0).getMedicalStatus()!=null){ %>
	<%if(medicalExaminationBoardList1.get(0).getMedicalStatus()== masMedical.getMedicalStatus() ){%>
	<option value="f" selected="selected">fit</option>
	<option value="u">unfit</option>
	<%}else{ %>
	<option value="">select</option>
	<option value="f">Fit</option>
	<option value="u" selected="selected">Unfit</option>
	<%} %>

	<%} %>
	<%}%>
</select>
<div class="Clear"></div>

<label>Name in full <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getNameInFull()!=null){%>
<input tabindex="1" name="<%=FULL_NAME %>" type="text" option
	value="<%=medicalExaminationBoardList1.get(0).getNameInFull() %>"
	validate="Full Name,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%}else{ %> <input tabindex="1"
	name="<%=FULL_NAME %>" type="text" validate="Full Name,String,yes"
	onKeyDown="limitText(this,25);" onKeyUp="limitText(this,25);" /> <%} %> <label
	class="calDate">Date of Birth <span>*</span> </label> <input
	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="calDate" option
	value="<%=dateOfBirth%>" validate="Date Of Birth,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DATE_OF_BIRTH%>,event)" ; />

<label>Martial Status <span>*</span> </label> <select
	name="<%= MARITIAL_STATUS %>" tabindex=1
	validate="Maritial Status,String,yes">
	<option value="">Select</option>
	<%
	
	for (MasMaritalStatus masMaritalStatus : masMaritalStatusList) {
		if(medicalExaminationBoardList1.get(0).getMaritalStatus()!=null){	
			if(true){
		if(medicalExaminationBoardList1.get(0).getMaritalStatus().getId()==masMaritalStatus.getId()){
	%>

	<option value="<%=masMaritalStatus.getId()%>" selected="selected">
	<%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}else{ %>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%
		}}}}
	%>
</select>
<div class="Clear"></div>

<label>Service <span>*</span> </label> <select name="<%=SERVICE %>"
	validate="Service,String,yes">
	<% for(MasMedicalExaminationReportOnEntry masmedical:medicalExaminationBoardList1){
	if(masmedical.getService().equalsIgnoreCase("w"))
	{%>
	<option value="A">ARMY</option>
	<%}
	else if(masmedical.getService().equalsIgnoreCase("n"))
	{%>
	<option value="N">NAVY</option>
	<%}
	else if(masmedical.getService().equalsIgnoreCase("f"))
	{%>
	<option value="F">AIR FORCE</option>
	<% }
}
	%>

	<option value="A">ARMY</option>
	<option value="N">NAVY</option>
	<option value="F">AIR FORCE</option>
</select> <label>P. No.(Only for Ser)</label> <%if(medicalExaminationBoardList1.get(0).getPNo()!=null){ %>
<input tabindex="1" name="<%=P_NO %>" type="text" option
	value="<%=medicalExaminationBoardList1.get(0).getPNo() %>"
	onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" /> <%}else{ %>
<input tabindex="1" name="<%=P_NO %>" type="text"
	onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" /> <%} %> <label>Rank(Only
for Ser.)</label> <%if(medicalExaminationBoardList1.get(0).getRank()!=null){ %> <input
	tabindex="1" type="text" name=<%=RANK%> option
	value="<%=medicalExaminationBoardList1.get(0).getRank() %>"
	onKeyDown="limitText(this,25);" onKeyUp="limitText(this,25);" /> <%}else{ %>
<input tabindex="1" type="text" name=<%=RANK%>
	onKeyDown="limitText(this,25);" onKeyUp="limitText(this,25);" /> <%} %>
<div class="Clear"></div>

<label>Hours of flown</label> <%if(medicalExaminationBoardList1.get(0).getHoursOfFlown()!=null){%>
<input tabindex="1" name="<%=HOURS_OF_FLOWN %>" type="text" option
	value="<%=medicalExaminationBoardList1.get(0).getHoursOfFlown()%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" name="<%=HOURS_OF_FLOWN %>" type="text"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %> <label>Permanent
Address</label> <%if(medicalExaminationBoardList1.get(0).getParmanentAddress()!=null){ %>
<textarea name="<%=PERMANENT_ADDRESS %>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"><%=medicalExaminationBoardList1.get(0).getParmanentAddress()%></textarea>
<%}else{ %> <textarea name="<%=PERMANENT_ADDRESS %>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"></textarea>
<%} %>
<div class="Clear"></div>
<div class="division"></div>

<label class="large">Identification Marks 1 <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getIdentificationMarks1()!=null) {%>
<input tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text"
	option
	value="<%=medicalExaminationBoardList1.get(0).getIdentificationMarks1() %>"
	validate="Identification1,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%}else{ %> <input tabindex="1"
	name="<%=IDENTIFICATION_MARKS1 %>" type="text"
	validate="Identification1,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%} %> <label class="large">Arms
Corps/Branch/Trade <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getArmsCorps()!=null) {%>
<input tabindex="1" name="<%=ARMS_CROPS %>" type="text" option
	value="<%= medicalExaminationBoardList1.get(0).getArmsCorps()%>"
	validate="Arms Crops,String,yes" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	name="<%=ARMS_CROPS %>" type="text" validate="Arms Crops,String,yes"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>
<div class="Clear"></div>

<label class="large">Identification Marks 2 <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getIdentificationMarks2()!=null) {%>
<input tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text"
	option
	value="<%=medicalExaminationBoardList1.get(0).getIdentificationMarks2() %>"
	validate="Identification2,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%}else{ %> <input tabindex="1"
	name="<%=IDENTIFICATION_MARKS2 %>" type="text"
	validate="Identification2,String,yes" onKeyDown="limitText(this,25);"
	onKeyUp="limitText(this,25);" /> <%} %> <label class="large">Date
of reporting <span>*</span> </label> <input tabindex="1"
	name="<%=DATE_OF_REPORTING %>" class="calDate" option
	value="<%=dateOfReporting %>" validate="Date Of reporting,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DATE_OF_REPORTING%>,event)" ; />

<div class="Clear"></div>

<label class="large">Date of Completion <span>*</span> </label> <input
	tabindex="1" name="<%=DATE_OF_COMPLETION %>" class="calDate" option
	value="<%=dateOfCompletion%>" validate="Date Of Completion,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DATE_OF_COMPLETION%>,event)" ; />


<label class="large">Document Forwarded Date</label> <input tabindex="1"
	name="<%=DOCUMENT_FORWARD_DATE %>" class="calDate" option
	value="<%=documentForwardDate %>"
	validate="Document forward Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DOCUMENT_FORWARD_DATE%>,event)" ; />

<div class="Clear"></div>

<label class="large">Document Forwarded To</label> <%if(medicalExaminationBoardList1.get(0).getDocumentForwardTo()!=null){ %>
<input tabindex="1" name="<%=DOCUMENT_FORWARD_TO %>" type="text" option
	value="<%=medicalExaminationBoardList1.get(0).getDocumentForwardTo() %>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%}else{ %>
<input tabindex="1" name="<%=DOCUMENT_FORWARD_TO %>" type="text"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %> <label
	class="large">From where he report <span>*</span> </label> <%if(medicalExaminationBoardList1.get(0).getFromWhereHeReport()!=null){ %>
<input tabindex="1" name="<%=FROM_WHERE_HE_REPORT %>" type="text" option
	value=<%= medicalExaminationBoardList1.get(0).getFromWhereHeReport()%>
	onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"
	validate="From where he report,String,yes" /> <%}else{ %> <input
	tabindex="1" name="<%=FROM_WHERE_HE_REPORT %>" type="text" option
	value=<%= medicalExaminationBoardList1.get(0).getFromWhereHeReport()%>
	validate="From where he report,String,yes"
	onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"
	validate="From where he report,String,yes" /> <%} %>
<div class="Clear"></div>

</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Personal Statement <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide1"><input tabindex="1" type="button" name="service"
	class="cmnButton" value="Add"
	onclick="generateRowMdicalBoardUpdate('amcDetailId');" /> <input
	tabindex="1" type="button" name="service" class="cmnButton"
	value="Remove"
	onclick="removeRowMedicalBoardUpdate(this,'amcDetailId')" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<tr>
		<th rowspan="2" scope="col">Sr. No.</th>
		<th rowspan="2" scope="col">Relation <span>*</span></th>
		<th colspan="2" scope="col">If Alive</th>
		<th colspan="2" scope="col">If Expired</th>
	</tr>
	<tr>
		<th height="23" scope="col">Age (years)</th>
		<th scope="col">Health</th>
		<th scope="col">Cause of Death</th>
		<th scope="col">died (years)</th>
	</tr>


	<tbody>
		<%
 String relationtemp="relationtemp";
 String  relationtemp2="relationtemp2";
 String agetemp="agetemp";
 String agetemp2="agetemp2";
 String helthtemp="helthtemp";
 String helthtemp2="helthtemp2";
 String causeOfDeathtemp="causeOfDeathtemp";
 String causeOfDeathtemp2="causeOfDeathtemp2";
 String deadtemp="deadtemp";
 String deadtemp2="deadtemp2";
int inc=1;


for(;inc<=medicalBoardExaminationDetailList1.size();inc++){
	relationtemp = relationtemp2 + ("" + inc);
	agetemp=agetemp2+ ("" + inc);
	helthtemp=helthtemp2+ ("" + inc);
	causeOfDeathtemp=causeOfDeathtemp2+(""+inc);
	deadtemp=deadtemp2+(""+inc);
	
%>


		<tr>
			<td width="5%"><input tabindex="1" type="text" size="2"
				value="<%=inc%>" name="<%=SIRIAL_NO%>" /> <input type="hidden"
				name="<%=MEDICAL_BOARD_DETAILS_ID%>"
				value="<%=medicalBoardExaminationDetailList1.get(inc-1).getId()%>"
				id="<%=MEDICAL_BOARD_DETAILS_ID%>" /></td>

			<td width="10%"><select name="<%=RELATION%>"
				value="<%=medicalBoardExaminationDetailList1.get(inc-1).getRelation()%>"
				id="<%=relationtemp%>" onblur="fillValuesMedicalDetails(<%=inc%>);"
				validate="Relation,String,yes">
				<option value="">Select</option>
				<%if(medicalBoardExaminationDetailList1.get(inc-1).getRelation().equals("Father")){ %>
				<option value="Father" selected="selected">FATHER</option>
				<option value="Mother">MOTHER</option>
				<option value="Brother">BROTHER</option>
				<option value="Sister">SISTER</option>
				<%} %>
				<%if(medicalBoardExaminationDetailList1.get(inc-1).getRelation().equals("Mother")){ %>
				<option value="Father">FATHER</option>
				<option value="Mother" selected="selected">MOTHER</option>
				<option value="Brother">BROTHER</option>
				<option value="Sister">SISTER</option>
				<%} %>

				<%if(medicalBoardExaminationDetailList1.get(inc-1).getRelation().equals("Brother")){ %>
				<option value="Father">FATHER</option>
				<option value="Mother">MOTHER</option>
				<option value="Brother" selected="selected">BROTHER</option>
				<option value="Sister">SISTER</option>
				<%} %>
				<%if(medicalBoardExaminationDetailList1.get(inc-1).getRelation().equals("Sister")){ %>
				<option value="Father">FATHER</option>
				<option value="Mother">MOTHER</option>
				<option value="Brother">BROTHER</option>
				<option value="Sister" selected="selected">SISTER</option>
				<%} %>


			</select></td>
			<td width="10%">
			<%if(medicalBoardExaminationDetailList1.get(inc-1).getAge()!=null){ %>
			<input tabindex="1" type="text" name="<%=AGE%>"
				value="<%=medicalBoardExaminationDetailList1.get(inc-1).getAge() %>"
				tabindex="2" id="<%=agetemp%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%}else{%>
			<input tabindex="1" type="text" name="<%=AGE%>" tabindex="2"
				id="<%=agetemp%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%} %>
			</td>

			<td width="10%">
			<%if(medicalBoardExaminationDetailList1.get(inc-1).getHealth()!=null){ %>
			<input tabindex="1" type="text" name="<%=HEALTH%>" option
				value="<%=medicalBoardExaminationDetailList1.get(inc-1).getHealth() %>"
				onblur="fillValuesMedicalDetails(<%=inc%>);" name=""
				id="<%=helthtemp %>" onKeyDown="limitText(this,25);"
				onKeyUp="limitText(this,25);" /> <%}else{ %> <input tabindex="1"
				type="text" name="<%=HEALTH%>"
				onblur="fillValuesMedicalDetails(<%=inc%>);" name=""
				id="<%=helthtemp %>" onKeyDown="limitText(this,25);"
				onKeyUp="limitText(this,25);" /> <%} %>
			</td>
			<td width="10%">
			<%if(medicalBoardExaminationDetailList1.get(inc-1).getCauseOfDeath()!=null){ %>
			<input tabindex="1" type="text"
				onblur="fillValuesMedicalDetails(<%=inc%>);"
				name="<%=CAUSE_OF_DEATH%>"
				value="<%=medicalBoardExaminationDetailList1.get(inc-1).getCauseOfDeath() %>"
				id="<%=causeOfDeathtemp%>" onKeyDown="limitText(this,25);"
				onKeyUp="limitText(this,25);" /> <%}else{ %> input tabindex="1"
			type="text" onblur="fillValuesMedicalDetails(<%=inc%>);" name="<%=CAUSE_OF_DEATH%>"
			id="<%=causeOfDeathtemp%>" onKeyDown="limitText(this,25);"
			onKeyUp="limitText(this,25);"/> <%} %>
			</td>

			<td width="10%">
			<%if(medicalBoardExaminationDetailList1.get(inc-1).getDied()!=null){ %>
			<input tabindex="1" type="text" name="<%=DIED%>" option
				value="<%= medicalBoardExaminationDetailList1.get(inc-1).getDied()%>"
				tabindex="2" id="<%=deadtemp%>"
				onblur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%}else{ %>
			<input tabindex="1" type="text" name="<%=DIED%>" tabindex="2"
				id="<%=deadtemp%>" onblur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%} %>
			</td>
		</tr>

		<%} %>


	</tbody>



</table>
</div>

<div class="Clear"></div>
<div class="blockFrame">
<h5>Any Family History of</h5>
<div class="Clear"></div>
<label class="noHeight">Hypertension</label> <%if(medicalExaminationBoardList1.get(0).getHypertension()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getHypertension().equals("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HYPERTENSION%>" value="Y"
	CHECKED class="radio2" onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HYPERTENSION%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HYPERTENSION%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noHeight">Heart Diseases</label> <%if(medicalExaminationBoardList1.get(0).getHeartDiabetes()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getHeartDiabetes().equals("Y")){%>

<input tabindex="1" type="checkbox" name="<%=HEAR_DISEASE%>" value="Y"
	CHECKED class="radio2" onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HEAR_DISEASE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HEAR_DISEASE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noHeight">Diabetes</label> <%if(medicalExaminationBoardList1.get(0).getDiabetes()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getDiabetes().equals("Y")){%> <input
	tabindex="1" type="checkbox" name="<%=DIABETES%>" value="Y" CHECKED
	class="radio2" onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=DIABETES%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=DIABETES%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noHeight">Bleeding Disorder</label> <%if(medicalExaminationBoardList1.get(0).getBleedingDisorder()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getBleedingDisorder().equals("Y")){%>
<input tabindex="1" type="checkbox" name="<%=BLEEDING_DIORDER%>"
	value="Y" CHECKED class="radio2" /> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=BLEEDING_DIORDER%>" value="Y" class="radio2"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=BLEEDING_DIORDER%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <label class="noHeight">Mental
Diseases</label> <%if(medicalExaminationBoardList1.get(0).getMentalDisease()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getMentalDisease().equals("Y")){%>
<input tabindex="1" type="checkbox" name="<%=MENTAL_DISEASE%>" value="Y"
	CHECKED class="radio2" /> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=MENTAL_DISEASE%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=MENTAL_DISEASE%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <label class="noHeight">Night
Blindness</label> <%if(medicalExaminationBoardList1.get(0).getNightBlindness()!=null) {%>
<%if(medicalExaminationBoardList1.get(0).getNightBlindness().equals("Y")){%>
<input tabindex="1" type="checkbox" name="<%=NIGHT_BLINDNESS%>"
	value="Y" CHECKED class="radio2" onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=NIGHT_BLINDNESS%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=NIGHT_BLINDNESS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<div class="Height10"></div>
</div>


<div class="Clear"></div>
<!--Block Four Ends-->

<div class="blockFrame">
<h5>Personal History- Have you ever suffered from any of the
following?</h5>
<div class="Clear"></div>

<label class="large">Chronic Bronchitis/Asthma</label> <%if(medicalExaminationBoardList1.get(0).getChronicBronchitis().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ASTHAMA %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=ASTHAMA %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=ASTHAMA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=ASTHAMA %>" value="N" CHECKED /> <%} %>

<label class="large">Discharge from ears</label> <%if(medicalExaminationBoardList1.get(0).getDischargeFromEars().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=DISCHARGE_FROM %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_FROM %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_FROM %>" value="Y" /> <label class="small">No</label>
<input tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_FROM %>" value="N" CHECKED /> <%} %>
<div class="Clear"></div>

<label class="large">Pleuisy/Tuberculosis</label> <%if(medicalExaminationBoardList1.get(0).getPleurisy().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=PLEURISY %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=PLEURISY %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=PLEURISY %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=PLEURISY %>" value="N" CHECKED />
<%} %> <label class="large">Any other ear disease</label> <%if(medicalExaminationBoardList1.get(0).getAnyOtherEarDisease().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=EAR_DISEASE %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=EAR_DISEASE %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=EAR_DISEASE %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=EAR_DISEASE %>" value="N" CHECKED />
<%} %>
<div class="Clear"></div>

<label class="large">Rheumatism/Frequent sore throats</label> <%if(medicalExaminationBoardList1.get(0).getRheumatismFrequentSorethroats().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=RHEUMATISM %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=RHEUMATISM %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=RHEUMATISM %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=RHEUMATISM %>" value="N" CHECKED />
<%} %> <label class="large">Frequent COUGH & Cold Sinusitis</label> <%if(medicalExaminationBoardList1.get(0).getFrequentCoughColdSinusitis().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=FREQUENT_CAUGH %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=FREQUENT_CAUGH %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=FREQUENT_CAUGH %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=FREQUENT_CAUGH %>" value="N" CHECKED /> <%} %>
<div class="Clear"></div>

<label class="large">Chronic Indigestion</label> <%if(medicalExaminationBoardList1.get(0).getChronicIndigestion().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=CHRONIC_INDIGESTION %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=CHRONIC_INDIGESTION %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=CHRONIC_INDIGESTION %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=CHRONIC_INDIGESTION %>" value="N" CHECKED /> <%} %> <label
	class="large">Nervous Breakdown/Mental Illness</label> <%if(medicalExaminationBoardList1.get(0).getNervousBreakdownMentalIllness().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=NERVOUS_BRAKDOWN %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=NERVOUS_BRAKDOWN %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=NERVOUS_BRAKDOWN %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=NERVOUS_BRAKDOWN %>" value="N" CHECKED /> <%} %>
<div class="Clear"></div>

<label class="large">Kidney/Bladder trouble</label> <%if(medicalExaminationBoardList1.get(0).getKidneyBladderTrouble().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=KIDENY_BLADDER %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=KIDENY_BLADDER %>" value="N" /> <%}else {%> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=KIDENY_BLADDER %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=KIDENY_BLADDER %>" value="N" CHECKED /> <%} %> <label
	class="large">Fits/Fainting Attacks</label> <%if(medicalExaminationBoardList1.get(0).getFitsFaintingAttack().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=FITS_FAINTING_ATTACKS %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=FITS_FAINTING_ATTACKS %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=FITS_FAINTING_ATTACKS %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=FITS_FAINTING_ATTACKS %>" value="N" CHECKED /> <%} %>
<div class="Clear"></div>
<label class="large">STD</label> <%if(medicalExaminationBoardList1.get(0).getStd().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=STD %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=STD %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=STD %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=STD %>" value="N" CHECKED /> <%} %> <label
	class="large">Severe Head Injury</label> <%if(medicalExaminationBoardList1.get(0).getSevereHeadInjury().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=SEVERE_HEAD_INJURY %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=SEVERE_HEAD_INJURY %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=SEVERE_HEAD_INJURY %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=SEVERE_HEAD_INJURY %>" value="N" CHECKED /> <%} %>

<div class="Clear"></div>

<label class="large">Jaundice</label> <%if(medicalExaminationBoardList1.get(0).getJaundice().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=JOUNDICE %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=JOUNDICE %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=JOUNDICE %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=JOUNDICE %>" value="N" CHECKED /> <%} %>

<label class="large">Air,Sea,Car,Train Sickness</label> <%if(medicalExaminationBoardList1.get(0).getAirSeaCarTrainSickness().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=SICKNESS %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=SICKNESS %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=SICKNESS %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=SICKNESS %>" value="N" CHECKED /> <%} %>

<div class="Clear"></div>

<label class="large">Trachoma</label> <%if(medicalExaminationBoardList1.get(0).getTrachoma().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=TRACHOMA %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=TRACHOMA %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=TRACHOMA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=TRACHOMA %>" value="N" CHECKED /> <%} %>

<label class="large">Night Blindness</label> <%if(medicalExaminationBoardList1.get(0).getNightBindness().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=NIGHT_BINDNESS %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=NIGHT_BINDNESS %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=NIGHT_BINDNESS %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=NIGHT_BINDNESS %>" value="N" CHECKED /> <%} %>

<div class="Clear"></div>

<label class="large">Laser Treatment/Surgery for eye</label> <%if(medicalExaminationBoardList1.get(0).getLaserTreatementSurgeryForEye().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=LASER_TREATEMENT %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=LASER_TREATEMENT %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=LASER_TREATEMENT %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=LASER_TREATEMENT %>" value="N" CHECKED /> <%} %> <label
	class="large">Any other eye disease</label> <%if(medicalExaminationBoardList1.get(0).getAnyOtherEyeDisease().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=EYE_DISEASE %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=EYE_DISEASE %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=EYE_DISEASE %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=EYE_DISEASE %>" value="N" CHECKED />
<%} %>

<div class="Clear"></div>

<label class="valueNoWidth">(For Female Candidates Only)</label>
<div class="Clear"></div>

<label class="large">Breast disease/Discharge</label> <%if(medicalExaminationBoardList1.get(0).getBreastDiseaseDischarge().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=BREAST_DISEASE %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=BREAST_DISEASE %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=BREAST_DISEASE %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=BREAST_DISEASE %>" value="N" CHECKED /> <%} %> <label
	class="large">Amenonhoea/Dysmenonhoea</label> <%if(medicalExaminationBoardList1.get(0).getAmenorrhoeaDysmenonhoea().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=AMENORRHOEA %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=AMENORRHOEA %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=AMENORRHOEA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=AMENORRHOEA %>" value="N" CHECKED />
<%} %>

<div class="Clear"></div>

<label class="large">Menorrhagia</label> <%if(medicalExaminationBoardList1.get(0).getMenonhagia().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=MENORRHAGIA %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=MENORRHAGIA %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=MENORRHAGIA %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=MENORRHAGIA %>" value="N" CHECKED />
<%} %> <label class="large">Pregnancy</label> <%if(medicalExaminationBoardList1.get(0).getPregnancy().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=PREGNANCY %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=PREGNANCY %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=PREGNANCY %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=PREGNANCY %>" value="N" CHECKED />
<%} %>

<div class="Clear"></div>

<label class="large">Abortion</label> <%if(medicalExaminationBoardList1.get(0).getAbortion().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ABORTION %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=ABORTION %>" value="N" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" type="radio" class="radio" name="<%=ABORTION %>"
	value="Y" /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio" name="<%=ABORTION %>" value="N" CHECKED /> <%} %>

<div class="Clear"></div>
<div class="division"></div>

<label class="large3">Have you ever been rejected as medically
unfit for any branch of the Armed forces?</label> <%if(medicalExaminationBoardList1.get(0).getBeenrejectedAsMedicallyUnfitForAnyBranch().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=REJECTED_AS_UNFIT %>" value="Y" CHECKED /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=REJECTED_AS_UNFIT %>" value="N" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=REJECTED_AS_UNFIT %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=REJECTED_AS_UNFIT %>" value="N" CHECKED /> <%} %> <label
	class="large3">Have you ever been Discharge as medically unfit
for any branch of the Armed forces?</label> <%if(medicalExaminationBoardList1.get(0).getDischargeAsMedicallyUnfitForAnyBranch().equalsIgnoreCase("Y")){%>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="Y" CHECKED />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="N" /> <%}else{ %>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="Y" /> <label
	class="small">No</label> <input tabindex="1" type="radio" class="radio"
	name="<%=DISCHARGE_MEDICALLY_UNFIT %>" value="N" CHECKED /> <%} %>
<div class="Clear"></div>
<label class="large3">Have you ever been Admitted in hospital
for any illness, operation or injury ? if also</label> <%if(medicalExaminationBoardList1.get(0).getAdmittedInHospitalForAnyIllnessOperationOrInjury().equalsIgnoreCase("Y")){%>

<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="Y"
	CHECKED /> <label class="small">No</label> <input tabindex="1"
	type="radio" class="radio"
	name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="N" /> <%}else{ %>
<label class="small">Yes</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="Y" />
<label class="small">No</label> <input tabindex="1" type="radio"
	class="radio" name="<%=ADIMMITED_IN_HOSPITAL_FOR_ILLNESS %>" value="N"
	CHECKED /> <%} %>

<div class="Clear"></div>
<label class="large3">State the nature of the disease and
duration of stay in hospital</label> <%if(medicalExaminationBoardList1.get(0).getStateTheNatureOfDiseaseDuration()!=null){%>
<input tabindex="1" type="text" name="<%=STATE_NATURE_OF_THE_DISEASE %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getStateTheNatureOfDiseaseDuration() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else {%> <input tabindex="1"
	type="text" name="<%=STATE_NATURE_OF_THE_DISEASE %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>
<div class="Clear"></div>
<label class="large3"> Any other information which you can give
about your health</label> <%if(medicalExaminationBoardList1.get(0).getAnyOtherInformationAboutYourHealth()!=null){%>

<input tabindex="1" type="text" name="<%=OTHER_INFORMATION %>" option
	value="<%=medicalExaminationBoardList1.get(0).getAnyOtherInformationAboutYourHealth() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=OTHER_INFORMATION %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>


</div>
<div class="Clear"></div>

</div>
<div class="Clear"></div>



<div class="division"></div>
<!--Block Four Ends-->


<div class="blockTitleFixed">Medicine <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame"><label class="large">Height
Without Shoes(cms)</label> <%if(medicalExaminationBoardList1.get(0).getHeight()!=null){%>

<input tabindex="1" type="text" name="<%=HEIGHT_WITHOUT_SHOOSE %>"
	id="height" option
	value="<%=medicalExaminationBoardList1.get(0).getHeight()%>"
	class="medium" onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text"
	name="<%=HEIGHT_WITHOUT_SHOOSE %>" id="height" class="medium"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%} %> <label class="large">Weight(Actual)Kg</label> <%if(medicalExaminationBoardList1.get(0).getWeight()!=null){%>

<input tabindex="1" type="text" name="<%=ACTUAL_WEIGHT %>"
	id="actualWeigth" option
	value="<%=medicalExaminationBoardList1.get(0).getWeight() %>"
	onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);"
	class="medium" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=ACTUAL_WEIGHT %>" id="actualWeigth" class="medium"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" onKeyUp="limitText(this,6);" />
<%} %>
<div class="Clear"></div>
<label class="large">(Acceptable)kg</label> <%if(medicalExaminationBoardList1.get(0).getAcceptable()!=null){%>
<input tabindex="1" type="text" name="<%=ACCEPTABLE_KG %>"
	id="acceptablekg" option
	value="<%= medicalExaminationBoardList1.get(0).getAcceptable()%>"
	class="medium" onkeyup="isNumber1(this)"
	onblur="checkForWiegth(this.value,id);" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=ACCEPTABLE_KG %>" id="acceptablekg" class="medium"
	onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);" /> <%} %> <label
	class="large">Leg Length(for pilots only)</label> <%if(medicalExaminationBoardList1.get(0).getLegLength()!=null){%>

<input tabindex="1" type="text" id="leglength" name="<%= LEG_LENGTH%>"
	option value="<%=medicalExaminationBoardList1.get(0).getLegLength() %>"
	class="medium" onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="leglength"
	name="<%= LEG_LENGTH%>" class="medium" onkeyup="isNumber(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %>
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Urine Examination <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide3">
<div class="blockFrame"><label class="medium">Appearance</label> <%if(medicalExaminationBoardList1.get(0).getAppearance()!=null){%>

<input tabindex="1" type="text" name="<%= APPEREANCE%>" option
	value="<%=medicalExaminationBoardList1.get(0).getAppearance() %>"
	class="medium" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= APPEREANCE%>" class="medium"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %> <label
	class="medium">Albumun</label> <%if(medicalExaminationBoardList1.get(0).getAlbumin()!=null){%>

<input tabindex="1" type="text" name="<%= ALBUMIN%>" option
	value="<%=medicalExaminationBoardList1.get(0).getAlbumin() %>"
	class="medium" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= ALBUMIN%>" class="medium"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %> <label
	class="medium">Sugar</label> <%if(medicalExaminationBoardList1.get(0).getSugar()!=null){%>

<input tabindex="1" type="text" name="<%= SUGAR%>" option
	value="<%=medicalExaminationBoardList1.get(0).getSugar() %>"
	class="medium" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= SUGAR%>" class="medium"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="Clear"></div>

<label class="medium">Sp Gravity</label> <%if(medicalExaminationBoardList1.get(0).getSpGravity()!=null){%>
<input tabindex="1" type="text" name="<%= SP_GRAVITY%>" option
	value="<%= medicalExaminationBoardList1.get(0).getSpGravity()%>"
	class="medium" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= SP_GRAVITY%>" class="medium"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Blood Examination <a
	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide4">
<div class="blockFrame"><label class="medium">Hb%</label> <%if(medicalExaminationBoardList1.get(0).getHbPercentage()!=null){%>
<input tabindex="1" type="text" name="<%=HB_PERCENTAGE%>" option
	value="<%=medicalExaminationBoardList1.get(0).getHbPercentage() %>"
	class="small" onKeyDown="limitText(this,12);"
	onKeyUp="limitText(this,12);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=HB_PERCENTAGE%>" class="small"
	onKeyDown="limitText(this,12);" onKeyUp="limitText(this,12);" /> <%} %> <label
	class="large">Any other inv carried out</label> <%if(medicalExaminationBoardList1.get(0).getAnyOtherInvCarriedOut()!=null){%>

<input tabindex="1" type="text" name="<%= ANYOTHER_INV_CARRIED_OUT%>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getAnyOtherInvCarriedOut() %>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%= ANYOTHER_INV_CARRIED_OUT%>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %> <label
	class="medium">Physique</label> <%if(medicalExaminationBoardList1.get(0).getPhysique()!=null){%>
<input tabindex="1" type="text" name="<%=PHYSIQUE %>" option
	value="<%=medicalExaminationBoardList1.get(0).getPhysique() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=PHYSIQUE %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Skin</label> <%if(medicalExaminationBoardList1.get(0).getSkin()!=null){%>

<input tabindex="1" type="text" name="<%=SKIN %>" option
	value="<%=medicalExaminationBoardList1.get(0).getSkin() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=SKIN %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %> <label
	class="large">Abdomen(Liver & Spleen)</label> <%if(medicalExaminationBoardList1.get(0).getAbdomen()!=null){%>

<input tabindex="1" type="text" name="<%=ABDOMEN%>" option
	value="<%=medicalExaminationBoardList1.get(0).getAbdomen() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=ABDOMEN%>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Cardio Vascular System <a
	href="javascript:animatedcollapse.toggle('slide5')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide5">
<div class="blockFrame">
<div class="Clear"></div>
<label>Heart Size</label> <%if(medicalExaminationBoardList1.get(0).getHeartSize()!=null){%>

<input tabindex="1" type="text" name="<%= HEART_SIZE%>" option
	value="<%= medicalExaminationBoardList1.get(0).getHeartSize()%>"
	class="Auto" size="22" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= HEART_SIZE%>" class="Auto" size="22"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %> <label>Sounds</label>
<%if(medicalExaminationBoardList1.get(0).getSounds()!=null){%> <input
	tabindex="1" type="text" name="<%= SOUND%>" option
	value="<%=medicalExaminationBoardList1.get(0).getSounds() %>"
	class="Auto" size="22" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= SOUND%>" class="Auto" size="22"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %> <label>Rhythm</label>
<%if(medicalExaminationBoardList1.get(0).getRhythm()!=null){%> <input
	tabindex="1" type="text" name="<%= RHYTHM%>" option
	value="<%=medicalExaminationBoardList1.get(0).getRhythm() %>"
	class="Auto" size="22" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= RHYTHM%>" class="Auto" size="22"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>

<div class="clear"></div>

<label>Arterial Walls</label> <%if(medicalExaminationBoardList1.get(0).getArterialWalls()!=null){%>
<input tabindex="1" type="text" name="<%= ARTERIAL_WALLS%>" option
	value="<%=medicalExaminationBoardList1.get(0).getArterialWalls() %>"
	class="Auto" size="22" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%= ARTERIAL_WALLS%>" class="Auto" size="22"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}%> <label>Pulse
Rate</label> <%if(medicalExaminationBoardList1.get(0).getPulseRates()!=null){%> <input
	tabindex="1" type="text" class="Auto" size="22" name="<%=PULSE_RATES%>"
	optin value="<%=medicalExaminationBoardList1.get(0).getPulseRates() %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}else{ %>
<input tabindex="1" type="text" class="Auto" size="22"
	name="<%=PULSE_RATES%>" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%} %> <label>BP</label> <%if(medicalExaminationBoardList1.get(0).getBp()!=null){%>

<input tabindex="1" type="text" class="Auto" size="22" name="<%= BP1%>"
	option value="<%=medicalExaminationBoardList1.get(0).getBp()%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}else{ %>
<input tabindex="1" type="text" class="Auto" size="22" name="<%= BP1%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitle">Respiratory System(Including X-Ray
Examination When applicable) <a
	href="javascript:animatedcollapse.toggle('slide6')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide6">
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium"> &nbsp;</label> <%if(medicalExaminationBoardList1.get(0).getRespiratorySystem()!=null){%>
<input tabindex="1" type="text" name="<%=RESPIRATORY_SYSTEM %>" option
	value="<%=medicalExaminationBoardList1.get(0).getRespiratorySystem() %>"
	class="Auto" size="120" onKeyDown="limitText(this,100);"
	onKeyUp="limitText(this,100);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);" /> <%} %>
<div class="clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>


<div class="blockTitleFixed">Chest Measurement <a
	href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide7">
<div class="blockFrame"><label class="large">Full
expansion(cms)</label> <%if(medicalExaminationBoardList1.get(0).getChestMeasurement()!=null){%>

<input tabindex="1" type="text" name="<%= FULL_EXPENSION%>" option
	value="<%= medicalExaminationBoardList1.get(0).getChestMeasurement()%>"
	onKeyDown="limitText(this,40);" onKeyUp="limitText(this,40);">
<%}else{ %> <input tabindex="1" type="text" name="<%= FULL_EXPENSION%>"
	onKeyDown="limitText(this,40);" onKeyUp="limitText(this,40);">
<%} %> <label class="large">Range of Expansion(cms)</label> <%if(medicalExaminationBoardList1.get(0).getRangeOfExpension()!=null){%>

<input tabindex="1" type="text" name="<%=RANGE_OF_EXPENSION%>" option
	value="<%=medicalExaminationBoardList1.get(0).getRangeOfExpension() %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%=RANGE_OF_EXPENSION%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="clear"></div>

</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitle">Control Nervous System (Reflexes, Tremors)
<a href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide8">
<div class="blockFrame"><label>Self Balancing R</label> <%if(medicalExaminationBoardList1.get(0).getSelfBalancingR()!=null){%>

<input tabindex="1" type="text" name="<%= SELF_BALANCINF_R%>" option
	value="<%= medicalExaminationBoardList1.get(0).getSelfBalancingR()%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%= SELF_BALANCINF_R%>" on
	KeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %> <label>Self
Balancing l</label> <%if(medicalExaminationBoardList1.get(0).getSelfBalancingL()!=null){%>

<input tabindex="1" type="text" name="<%= SELF_BALANCING_L%>" option
	value="<%= medicalExaminationBoardList1.get(0).getSelfBalancingL()%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%= SELF_BALANCING_L%>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Speech Mental Mental Capacity & Emotional
stability</label> <%if(medicalExaminationBoardList1.get(0).getSpeechMentalCapacity()!=null){%>

<input tabindex="1" type="text" name="<%=SPEECH_MENTAL_CAPACITY %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getSpeechMentalCapacity() %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=SPEECH_MENTAL_CAPACITY %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Endocnine Condition</label> <%if(medicalExaminationBoardList1.get(0).getEndocrineCondition()!=null){%>

<input tabindex="1" type="text" name="<%=ENDOCRINE_CONDITION %>" option
	value="<%=medicalExaminationBoardList1.get(0).getEndocrineCondition() %>"
	class="large" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=ENDOCRINE_CONDITION %>" class="large"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Any other abnormalities or condition
affecting capacity not already noted</label> <%if(medicalExaminationBoardList1.get(0).getAnyOtheAbnormalities()!=null){%>

<input tabindex="1" type="text" name="<%=OTHER_ABNORMALITIES %>" option
	value="<%=medicalExaminationBoardList1.get(0).getAnyOtheAbnormalities() %>"
	class="large" onKeyDown="limitText(this,20);"
	onKeyUp="limitText(this,20);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=OTHER_ABNORMALITIES %>" class="large"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> <%} %>
<div class="Clear"></div>
<div class="division"></div>

<label class="large2">Remarks</label> <%if(medicalExaminationBoardList1.get(0).getRemarks()!=null){%>

<textarea name="<%=MEDICIN_REMARKS %>" onKeyDown="limitText(this,50);"
	class="large" onKeyUp="limitText(this,50);"><%=medicalExaminationBoardList1.get(0).getRemarks() %></textarea>
<%}else{ %> <textarea name="<%=MEDICIN_REMARKS %>"
	onKeyDown="limitText(this,50);" class="large"
	onKeyUp="limitText(this,50);"></textarea> <%} %> <label class="large2">Medicine
Exam Date <span>*</span> </label> <input tabindex="1" type="text"
	name="<%=MEDICIN_EXAM_DATE%>" class="calDate" value="<%=medicinDate %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"
	validate="Medicin Exam Date,date,no"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=MEDICIN_EXAM_DATE%>,event)" ; />
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Surgery <a
	href="javascript:animatedcollapse.toggle('slide9')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide9">
<div class="blockFrame">
<h5>Upper Limbs</h5>
<div class="Clear"></div>

<div class="clear"></div>
<label class="noheight">Fingers</label> <%if(medicalExaminationBoardList1.get(0).getFingers()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getFingers().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=FINGER%>" value="Y" CHECKED
	class="radio2" onclick="chkValue(this);" /> <%}else {%> <input
	tabindex="1" type="checkbox" name="<%=FINGER%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=FINGER%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Hand</label> <%if(medicalExaminationBoardList1.get(0).getHand()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getHand().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HAND%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HAND%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=HAND%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <label class="noheight">Wrist</label>
<%if(medicalExaminationBoardList1.get(0).getWrists()!=null){%> <%if(medicalExaminationBoardList1.get(0).getWrists().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=WRIST%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=WRIST%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=WRIST%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <label class="noheight">Elbows</label>
<%if(medicalExaminationBoardList1.get(0).getElbows()!=null){%> <%if(medicalExaminationBoardList1.get(0).getElbows().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=ELBOWS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=ELBOWS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=ELBOWS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Shoulder Girdles</label> <%if(medicalExaminationBoardList1.get(0).getShoulderGirdles()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getShoulderGirdles().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=SHOULDER_GIRDLES%>"
	value="Y" class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=SHOULDER_GIRDLES%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else {%> <input
	tabindex="1" type="checkbox" name="<%=SHOULDER_GIRDLES%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Cervical</label> <%if(medicalExaminationBoardList1.get(0).getCervical()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getCervical().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=CERCIVAL%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=CERCIVAL%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=CERCIVAL%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Dorsal vertebrate</label> <%if(medicalExaminationBoardList1.get(0).getDorsalVertebrate()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getDorsalVertebrate().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=DORSAL_VERTEBRATE%>"
	value="Y" class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=DORSAL_VERTEBRATE%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=DORSAL_VERTEBRATE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%}%>
<div class="Clear"></div>
<h5>Lower Limbs</h5>
<div class="Clear"></div>
<label class="noheight">Hullux</label> <%if(medicalExaminationBoardList1.get(0).getHullux()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getHullux().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HULLUX%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HULLUX%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HULLUX%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Valgus</label> <%if(medicalExaminationBoardList1.get(0).getValgus()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getValgus().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=VALGUS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=VALGUS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=VALGUS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Rigigus</label> <%if(medicalExaminationBoardList1.get(0).getRigigus()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getRigigus().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=RIGGUS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=RIGGUS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=RIGGUS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">FlatFeet</label> <%if(medicalExaminationBoardList1.get(0).getFlatFeet()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getFlatFeet().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=FLAT_FEET%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=FLAT_FEET%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=FLAT_FEET%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Joints</label> <%if(medicalExaminationBoardList1.get(0).getJoints()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getJoints().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=JOINTS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=JOINTS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=JOINTS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Pelvis</label> <%if(medicalExaminationBoardList1.get(0).getPelvis()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getPelvis().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=PELVIS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=PELVIS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=PELVIS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Gail</label> <%if(medicalExaminationBoardList1.get(0).getGail()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getGail().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=GAIL%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=GAIL%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <input tabindex="1"
	type="checkbox" name="<%=GAIL%>" value="N" class="radio2"
	onclick="chkValue(this);" /> <%} %> <label class="noheight">Lumber
and Sacral vertabrac</label> <%if(medicalExaminationBoardList1.get(0).getLumber()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLumber().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=LUMBER_SCALER_VERTABRAC%>"
	value="Y" class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=LUMBER_SCALER_VERTABRAC%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=LUMBER_SCALER_VERTABRAC%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Roccyx and Varicose veins</label> <%if(medicalExaminationBoardList1.get(0).getRoccyxVarocose()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getRoccyxVarocose().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=ROCCYX_VARICOSE_VENIS%>"
	value="Y" class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=ROCCYX_VARICOSE_VENIS%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=ROCCYX_VARICOSE_VENIS%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<h5>Genito-Urinary and Perineum</h5>
<div class="Clear"></div>
<label class="noheight">Hydrocele</label> <%if(medicalExaminationBoardList1.get(0).getHydrocele()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getHydrocele().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HYDROCELE%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HYDROCELE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HYDROCELE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Varicocele</label> <%if(medicalExaminationBoardList1.get(0).getVaricocele()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getVaricocele().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=VARICOCELE%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=VARICOCELE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=VARICOCELE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Underscended testes</label> <%if(medicalExaminationBoardList1.get(0).getUnderscendedTest()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUnderscendedTest().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=UNDER_SCENDED_TESTES%>"
	value="Y" class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %>
<input tabindex="1" type="checkbox" name="<%=UNDER_SCENDED_TESTES%>"
	value="N" class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=UNDER_SCENDED_TESTES%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Hemorrhoids</label> <%if(medicalExaminationBoardList1.get(0).getHemorrhoids()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getHemorrhoids().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HEMONHOIDS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HEMONHOIDS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HEMONHOIDS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Hernia & Musicle</label> <%if(medicalExaminationBoardList1.get(0).getHerniaMusic()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getHerniaMusic().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=HERNIA_MUSCLE%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HERNIA_MUSCLE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=HERNIA_MUSCLE%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <label
	class="noheight">Breasts</label> <%if(medicalExaminationBoardList1.get(0).getBreasts()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getBreasts().equalsIgnoreCase("Y")){%>
<input tabindex="1" type="checkbox" name="<%=BREASTS%>" value="Y"
	class="radio2" CHECKED onclick="chkValue(this);" /> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=BREASTS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %> <%}else{ %> <input
	tabindex="1" type="checkbox" name="<%=BREASTS%>" value="N"
	class="radio2" onclick="chkValue(this);" /> <%} %>

<div class="Clear"></div>
<div class="division"></div>
<label>Remarks</label> <%if(medicalExaminationBoardList1.get(0).getRemarksLowerlimbs()!=null){%>
<textarea name="<%=SURGERY_REMARKS %>" rows="" cols="" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"><%=medicalExaminationBoardList1.get(0).getRemarksLowerlimbs() %></textarea>
<%}else{ %> <textarea name="<%=SURGERY_REMARKS %>" rows="" class="large"
	cols="" onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"></textarea>
<%} %> <label>Surgery Date <span>*</span> </label> <input tabindex="1"
	type="text" name="<%=SURGERY_DATE%>" class="calDate"
	value="<%=surgeryDate %>" onKeyDown="limitText(this,10);"
	onKeyUp="limitText(this,10);" validate="Surgery Date,date,yes">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=SURGERY_DATE%>,event)" ; />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">EYES <a
	href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide10">
<div class="blockFrame">
<div class="Clear"></div>
<div class="Height10"></div>


<div class="tableHolderAuto">

<div class="Clear"></div>
<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Distant Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Near Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">CP</th>
	</tr>
	<tr>
		<td>Without Glasses</td>
		<%if(medicalExaminationBoardList1.get(0).getWthoutGlassesRDistant()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_R %>" option
			value="<%= medicalExaminationBoardList1.get(0).getWthoutGlassesRDistant()%>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_R %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%} %>
		<%if(medicalExaminationBoardList1.get(0).getWithoutGlassesLDistant()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_L %>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithoutGlassesLDistant() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_DISTANT_L %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%} %>
		<td>Without Glasses</td>
		<%if(medicalExaminationBoardList1.get(0).getWithoutGlassesRNearvision()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_R %>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithoutGlassesRNearvision() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_R %>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>
		<%} %>
		<%if(medicalExaminationBoardList1.get(0).getWithoutGlassesLNearvision()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_L%>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithoutGlassesLNearvision() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_L%>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>
		<%} %>
		<%if(medicalExaminationBoardList1.get(0).getNearVisionWithoutGlassCp()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_CP %>" option
			value="<%= medicalExaminationBoardList1.get(0).getNearVisionWithoutGlassCp()%>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITHOUT_GLASSES_NEAR_CP %>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
	</tr>
	<tr>
		<td>With Glasses</td>
		<%if(medicalExaminationBoardList1.get(0).getWithGlassesRDistant()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%= WITH_GLASSES_DISTANT_R%>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithGlassesRDistant() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%= WITH_GLASSES_DISTANT_R%>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
		<% if(medicalExaminationBoardList1.get(0).getWithGlassesLDistant()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_DISTANT_L %>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithGlassesLDistant() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_DISTANT_L %>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
		<td>With Glasses</td>
		<% if(medicalExaminationBoardList1.get(0).getWithGlassesRNearvision()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_R%>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithGlassesRNearvision() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_R%>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
		<% if(medicalExaminationBoardList1.get(0).getWithGlassesLNearvision()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_L %>" option
			value="<%=medicalExaminationBoardList1.get(0).getWithGlassesLNearvision() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_L %>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
		<% if(medicalExaminationBoardList1.get(0).getNearVisionWithGlassCp()!=null){%>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_CP %>" option
			value="<%=medicalExaminationBoardList1.get(0).getNearVisionWithGlassCp() %>"
			onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /></td>
		<%}else{ %>
		<td width="10%"><input tabindex="1" type="text"
			name="<%=WITH_GLASSES_NEAR_CP %>" onKeyDown="limitText(this,10);"
			onKeyUp="limitText(this,10);" /></td>

		<%} %>
	</tr>

</table>

<div class="Clear"></div>
</div>
<label class="large2">Any evidence of Trachoma/its complications
or any other disease</label> <% if(medicalExaminationBoardList1.get(0).getEvidenceOfTrachoma()!=null){%>

<textarea rows="" cols="" name="<%=ANY_EVIDENCE_OF_TRACHOMA %>"
	class="large" onKeyDown="limitText(this,30);"
	onKeyUp="limitText(this,30);"><%=medicalExaminationBoardList1.get(0).getEvidenceOfTrachoma() %></textarea>
<%}else{ %> <textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large"
	onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);">
<%} %>
<div class="Clear"></div>
<label class="large2">Binocular vision & Grade</label>
    <% if(medicalExaminationBoardList1.get(0).getBinocularVisionGrade()!=null){%>

<input tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>"
	class="large" option
	value="<%=medicalExaminationBoardList1.get(0).getBinocularVisionGrade() %>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" />

<%} %>
<div class="Clear"></div>
<h5>Special Examination When Applicable</h5>
<div class="Clear"></div>
<label class="large">Manifest Hypermetropia, Myopia R & L</label>
 <% if(medicalExaminationBoardList1.get(0).getManifestHypermetropia()!=null){%>
<input tabindex="1" type="text" name="<%=MANIFEST_HYPERMETROPIA %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getManifestHypermetropia() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=MANIFEST_HYPERMETROPIA %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%} %>
<label>Cover Test</label>
 <% if(medicalExaminationBoardList1.get(0).getCoverTest()!=null){%>
<input tabindex="1" type="text" name="<%=COVER_TEST %>" option
	value="<%=medicalExaminationBoardList1.get(0).getCoverTest() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=COVER_TEST %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%} %>
<div class="Clear"></div>

		
<label class="large">Diaphragm Test(PD M ddox Wing Test)</label>
 <%if(medicalExaminationBoardList1.get(0).getDiaphragmTest()!=null){%>

<input tabindex="1" type="text" name="<%=DIAPHRAGM_TEST %>" option
	value="<%=medicalExaminationBoardList1.get(0).getDiaphragmTest() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=DIAPHRAGM_TEST %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%} %>
<label>Fund & Media</label>
 <%if(medicalExaminationBoardList1.get(0).getFundAndMedia()!=null){%>
<input tabindex="1" type="text" name="<%=FUND_MEDIA %>" option
	value="<%=medicalExaminationBoardList1.get(0).getFundAndMedia() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=FUND_MEDIA %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%} %>
<div class="Clear"></div>

<label class="large">Fields</label>
<%if(medicalExaminationBoardList1.get(0).getFields()!=null){%>
<input tabindex="1" type="text" name="<%=FIELDS %>" option
	value="<%=medicalExaminationBoardList1.get(0).getFields() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=FIELDS %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />

<%} %>

<label>Night Visual Capacity</label>
<%if(medicalExaminationBoardList1.get(0).getNightVisualCapacity()!=null){%>
<input tabindex="1" type="text" name="<%=NIGHT_VISUAL_CAPACITY %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getNightVisualCapacity() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=NIGHT_VISUAL_CAPACITY %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> 
<%} %>
<div class="Clear"></div>

<label class="large">Convergence C(cms)</label>
<%if(medicalExaminationBoardList1.get(0).getConvergenceC()!=null){%>
<input tabindex="1" type="text" id="convergence"
	name="<%=CONVERGENCE_C%>" option
	value="<%=medicalExaminationBoardList1.get(0).getConvergenceC()%>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /> 
<%}else{ %>
<input tabindex="1" type="text" id="convergence"
	name="<%=CONVERGENCE_C%>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> 

<%} %>

<label>Convergence SC(cms)</label>
<%if(medicalExaminationBoardList1.get(0).getConvergenceSc()!=null){%>
<input tabindex="1" type="text" id="convergencesc"
	name="<%=CONVERGENCE_SC %>" option
	value="<%=medicalExaminationBoardList1.get(0).getConvergenceSc() %>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /> 
<%}else{ %>
<input tabindex="1" type="text" id="convergencesc"
	name="<%=CONVERGENCE_SC %>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> 
<%} %>
<div class="Clear"></div>
<label class="large">Accommodation R</label>
<%if(medicalExaminationBoardList1.get(0).getAccommodationR()!=null){%>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_R %>" option
	value="<%=medicalExaminationBoardList1.get(0).getAccommodationR() %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_R %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> 
<%} %>
<label>Accommodation L</label>
<%if(medicalExaminationBoardList1.get(0).getAccommodationL()!=null){%>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_L %>" option
	value="<%=medicalExaminationBoardList1.get(0).getAccommodationL() %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_L %>"
	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);" /> 

<%} %>
<div class="Clear"></div>
<div class="division"></div>
<label class="large">Remarks</label>
<%if(medicalExaminationBoardList1.get(0).getRemarksSpecialExam()!=null){%>
<input tabindex="1" type="text" name="<%=EYE_REMARKS %>" option
	value="<%=medicalExaminationBoardList1.get(0).getRemarksSpecialExam() %>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=EYE_REMARKS %>"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> 

<%} %>
<label>Date</label>

<input tabindex="1" type="text" name="<%=EYE_DATE %>" option
	class="calDate" value="<%=eyeDate%>" validate="eye Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=EYE_DATE%>,event)" ; /> 
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Ear & Nose & Throat <a
	href="javascript:animatedcollapse.toggle('slide11')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide11">
<div class="blockFrame">
<div class="Clear"></div>
<h5>14.a) Ear</h5>
<div class="Clear"></div>

<label>Hearing RFW(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getEarHearingRfw()!=null){%>
<input tabindex="1" type="text" id="hearingrfw"
	name="<%=HEARING_R_F_W %>" option
	value="<%=medicalExaminationBoardList1.get(0).getEarHearingRfw()%>"
	onkeyup="isNumber(this)" onKeyDown="limitText(this,5);"
	onKeyUp="limitText(this,5);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="hearingrfw"
	name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,5);"
	onblur="checkForWiegth(this.value,id);" /> <%} %> <label>Hearing
LFW(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getEarHearingLfw()!=null){%>
<input tabindex="1" type="text" id="hearinglfw"
	name="<%=HEARING_L_F_W%>" option
	value="<%=medicalExaminationBoardList1.get(0).getEarHearingLfw() %>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="hearinglfw"
	name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %> <label>Hearing
both FW(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getEarHearingBothFw()!=null){%>
<input tabindex="1" type="text" id="hearingboth"
	name="<%=HEARING_BOTH_FW %>" option
	value="<%=medicalExaminationBoardList1.get(0).getEarHearingBothFw() %>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="hearingboth"
	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %>
<div class="Clear"></div>
<label>Hearing RCV(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getHearingRcv()!=null){%>
<input tabindex="1" type="text" id="rcv" name="<%=HEARING_R_C_V %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getHearingRcv() %>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="rcv"
	name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %> <label>Hearing
LFW(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getHearingLcv()!=null){%>
<input tabindex="1" type="text" id="lfw" name="<%=HEARING_L_C_V %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getHearingLcv() %>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="lfw"
	name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %> <label>Hearing
both CV(Cms)</label> <%if(medicalExaminationBoardList1.get(0).getHearingBothCv()!=null){%>
<input tabindex="1" type="text" id="bothcv" name="<%=HEARING_BOTH_CV %>"
	option
	value="<%=medicalExaminationBoardList1.get(0).getHearingBothCv()%>"
	onkeyup="isNumber1(this)" onKeyDown="limitText(this,6);"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" />
<%}else{ %> <input tabindex="1" type="text" id="bothcv"
	name="<%=HEARING_BOTH_CV %>" onkeyUp="isNumber1(this)"
	onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);" /> <%} %>
<div class="Clear"></div>
<label>External Ear (Wax)R</label> <%if(medicalExaminationBoardList1.get(0).getExternalEarR()!=null){%>
<input tabindex="1" type="text" name="<%=EXTERNAL_EAR_R %>" option
	value="<%= medicalExaminationBoardList1.get(0).getExternalEarR()%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else { %>
<input tabindex="1" type="text" name="<%=EXTERNAL_EAR_R %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %> <label>External
Ear(Wax)L</label> <%if(medicalExaminationBoardList1.get(0).getExternalEarL()!=null){%>
<input tabindex="1" type="text" name="<%=EXTERNAL_EAR_L %>" option
	value="<%= medicalExaminationBoardList1.get(0).getExternalEarL()%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%=EXTERNAL_EAR_L %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %>
<div class="Clear"></div>
<div class="division"></div>
<label class="large2">Middle Ear(Tympanic Membrance &Eustachain
Tube)-R</label> <%if(medicalExaminationBoardList1.get(0).getMiddleEarR()!=null){%>
<input tabindex="1" type="text" name="<%= MIDDLE_EAR_R%>" optio
	value="<%=medicalExaminationBoardList1.get(0).getMiddleEarR() %>"
	nonKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%= MIDDLE_EAR_R%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" />
<div class="Clear"></div>
<%} %> <label class="large2">Middle Ear(Tympanic Membrance
&Eustachain Tube)-L</label> <%if(medicalExaminationBoardList1.get(0).getMiddleEar()!=null){%>
<input tabindex="1" type="text" name="<%=MIDDLE_EAR_L %>" optio
	value="<%=medicalExaminationBoardList1.get(0).getMiddleEar() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else {%>
<input tabindex="1" type="text" name="<%= MIDDLE_EAR_L%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Inner Ear(Cochlea & Vestibular
Apparatus)-R</label> <%if(medicalExaminationBoardList1.get(0).getInnerEarR()!=null){%>
<input tabindex="1" type="text" name="<%=INNER_EAR_R %>" option
	value="<%=medicalExaminationBoardList1.get(0).getInnerEarR() %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%=INNER_EAR_R %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Inner Ear(Cochlea & Vestibular
Apparatus)-L</label> <%if(medicalExaminationBoardList1.get(0).getInnerEarL()!=null){%>
<input tabindex="1" type="text" name="<%=INNER_EAR_L %>" option
	value="<%=medicalExaminationBoardList1.get(0).getInnerEarL()%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%=INNER_EAR_L %>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%} %>
<div class="Clear"></div>
<label class="large2">Audiometry Record(Special exam when
applicable</label> <%if(medicalExaminationBoardList1.get(0).getAudiometryRecord()!=null){%>
<input tabindex="1" type="text" name="<%=AUDIOMETRY_RECORD %>"
	class="large" option
	value="<%=medicalExaminationBoardList1.get(0).getAudiometryRecord()%>"
	onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);" /> <%}else{ %>
<input tabindex="1" type="text" name="<%=AUDIOMETRY_RECORD %>"
	class="large" onKeyDown="limitText(this,10);"
	onKeyUp="limitText(this,10);" /> <%} %>
<div class="Clear"></div>
<div class="division"></div>

<h5>b.) Nose</h5>
<div class="Clear"></div>
<label class="noWidth">&nbsp; </label> <%if(medicalExaminationBoardList1.get(0).getNose()!=null){%>
<textarea rows="" cols="" name="<%=NOSE %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"><%=medicalExaminationBoardList1.get(0).getNose() %></textarea>
<%}else{ %> <textarea rows="" cols="" name="<%=NOSE %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"></textarea>

<%} %>
<div class="Clear"></div>
<div class="division"></div>

<h5>c.) Throat</h5>
<div class="Clear"></div>
<label class="noWidth">&nbsp;</label> <%if(medicalExaminationBoardList1.get(0).getThroat()!=null){%>
<textarea rows="" cols="" name="<%=THROAT_EAR %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"><%=medicalExaminationBoardList1.get(0).getThroat() %></textarea>
<%}else{ %> <textarea rows="" cols="" name="<%=THROAT_EAR %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);"></textarea> <%} %>
<div class="Clear"></div>
<div class="division"></div>

<label class="medium">Remarks</label> <%if(medicalExaminationBoardList1.get(0).getRemarksEar()!=null){%>
<textarea rows="" cols="" name="<%=EAR_REMARKS %>" class="large"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"><%=medicalExaminationBoardList1.get(0).getRemarksEar()%></textarea>
<%}else{ %> <textarea rows="" cols="" name="<%=EAR_REMARKS %>"
	class="large" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);"></textarea> <%} %> <label> Date </label> <input
	tabindex="1" type="text" name="<%=EAR_DATE%>" class="calDate" option
	value="<%=earDate %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Surgery Date,date,no"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReport.<%=EAR_DATE%>,event)" ; />

</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">Dental <a
	href="javascript:animatedcollapse.toggle('slide12')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide12">
<div class="blockFrame">
<div class="Clear"></div>
<label class="large">Total no. of Teeth</label> <%if(medicalExaminationBoardList1.get(0).getTotalTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=TOTAL_NO_OF_TEETH %>"
	class="small" option
	value="<%=medicalExaminationBoardList1.get(0).getTotalTeeth() %>"
	onkeyup="isNumber(this)" onKeyDown="limitText(this,2);"
	onKeyUp="limitText(this,2);" /> <%}else{ %> <input tabindex="1"
	type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onkeyUp="isNumber(this)" onKeyDown="limitText(this,2);"
	onKeyUp="limitText(this,2);" /> <%} %> <label class="large">Missing/
Unserviceable Teeth</label> <%if(medicalExaminationBoardList1.get(0).getMissingTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small"
	option
	value="<%=medicalExaminationBoardList1.get(0).getMissingTeeth() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> <%}else{ %> <input
	tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small"
	onKeyUp="isNumber(this);" maxlength="2" /> <%} %> <label
	class="valueNoWidth">/</label> <%if(medicalExaminationBoardList1.get(0).getUnservisableTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" option
	value="<%=medicalExaminationBoardList1.get(0).getUnservisableTeeth() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> <%}else { %> <input
	tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" /> <%} %>
<div class="Clear"></div>
<label class="large">Total no. of Dental Point</label> <%if(medicalExaminationBoardList1.get(0).getDenstlPoint()!=null){%>
<input tabindex="1" type="text" name="<%=DENTSL_POINT %>" option
	value="<%=medicalExaminationBoardList1.get(0).getDenstlPoint() %>"
	onkeyup="isNumber(this)" onKeyDown="limitText(this,2);"
	onKeyUp="limitText(this,2);"> <%}else{ %> <input tabindex="1"
	type="text" name="<%=DENTSL_POINT %>" onkeyup="isNumber(this)"
	onKeyDown="limitText(this,2);" onKeyUp="limitText(this,2);"> <%} %>
<div class="Clear"></div>
<div class="division"></div>

<h5>Total No. of Defective Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>

<%if(medicalExaminationBoardList1.get(0).getUR8()!=null){
	System.out.println("medicalExaminationBoardList1.get(0).getUR8()"+medicalExaminationBoardList1.get(0).getUR8());
%> <%if(medicalExaminationBoardList1.get(0).getUR8().charAt(0)=='Y'){%> <label
	class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_8%>" id="<%=DUR_8%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=DUR_8%>" id="<%=DUR_8%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_8%>" id="<%=DUR_8%>" value="" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR7().charAt(0)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_7%>" id="<%=DUR_7%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=DUR_7%>" id="<%=DUR_7%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_7%>" id="<%=DUR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR6().charAt(0)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_6%>" id="<%=DUR_6%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DUR_6%>" id="<%=DUR_6%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_6%>" id="<%=DUR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR5().charAt(0)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_5%>" id="<%=DUR_5%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=DUR_5%>" id="<%=DUR_5%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_5%>" id="<%=DUR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR4().charAt(0)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_4%>" id="<%=DUR_4%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=DUR_4%>" id="<%=DUR_4%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_4%>" id="<%=DUR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR3().charAt(0)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_3%>" id="<%=DUR_3%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DUR_3%>" id="<%=DUR_3%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_3%>" id="<%=DUR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR2().charAt(0)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_2%>" id="<%=DUR_2%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=DUR_2%>" id="<%=DUR_2%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_2%>" id="<%=DUR_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR1().charAt(0)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_1%>" id="<%=DUR_1%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=DUR_1%>" id="<%=DUR_1%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DUR_1%>" id="<%=DUR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %>

<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getUL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getUL8().charAt(0)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_8%>" id="<%=DUL_8%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=DUL_8%>" id="<%=DUL_8%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else {%> <label
	class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_8%>" id="<%=DUL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL7().charAt(0)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_7%>" id="<%=DUL_7%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=DUL_7%>" id="<%=DUL_7%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_7%>" id="<%=DUL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL6().charAt(0)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_6%>" id="<%=DUL_6%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DUL_6%>" id="<%=DUL_6%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_6%>" id="<%=DUL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL5().charAt(0)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_5%>" id="<%=DUL_5%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=DUL_5%>" id="<%=DUL_5%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_5%>" id="<%=DUL_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL4().charAt(0)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_4%>" id="<%=DUL_4%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=DUL_4%>" id="<%=DUL_4%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_4%>" id="<%=DUL_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL3().charAt(0)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_3%>" id="<%=DUL_3%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DUL_3%>" id="<%=DUL_3%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_3%>" id="<%=DUL_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL2().charAt(0)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_2%>" id="<%=DUL_2%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=DUL_2%>" id="<%=DUL_2%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_2%>" id="<%=DUL_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL1().charAt(0)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_1%>" id="<%=DUL_1%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=DUL_1%>" id="<%=DUL_1%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DUL_1%>" id="<%=DUL_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %>

<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLR8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLR8().charAt(0)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_8%>" id="<%=DLR_8%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=DLR_8%>" id="<%=DLR_8%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_8%>" id="<%=DLR_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR7().charAt(0)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_7%>" id="<%=DLR_7%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else {%> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=DLR_7%>" id="<%=DLR_7%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else {%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_7%>" id="<%=DLR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR6().charAt(0)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_6%>" id="<%=DLR_6%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else {%> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DLR_6%>" id="<%=DLR_6%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else {%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_6%>" id="<%=DLR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR5().charAt(0)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_5%>" id="<%=DLR_5%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=DLR_5%>" id="<%=DLR_5%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_5%>" id="<%=DLR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR4().charAt(0)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_4%>" id="<%=DLR_4%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=DLR_4%>" id="<%=DLR_4%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_4%>" id="<%=DLR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR3().charAt(0)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_3%>" id="<%=DLR_3%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DLR_3%>" id="<%=DLR_3%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_3%>" id="<%=DLR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR2().charAt(0)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_2%>" id="<%=DLR_2%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=DLR_2%>" id="<%=DLR_2%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_2%>" id="<%=DLR_2%>" value="" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR1().charAt(0)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_1%>" id="<%=DLR_1%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKEd /> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=DLR_1%>" id="<%=DLR_1%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DLR_1%>" id="<%=DLR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLL8().charAt(0)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_8%>" id="<%=DLL_8%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=DLL_8%>" id="<%=DLL_8%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_8%>" id="<%=DLL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL7().charAt(0)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_7%>" id="<%=DLL_7%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=DLL_7%>" id="<%=DLL_7%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_7%>" id="<%=DLL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL6().charAt(0)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_6%>" id="<%=DLL_6%>" value="Y" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=DLL_6%>" id="<%=DLL_6%>"
	value="N" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_6%>" id="<%=DLL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL5().charAt(0)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_5%>" value="Y" id="<%=DLL_5%>" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=DLL_5%>" value="N"
	id="<%=DLL_5%>" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %>
<label class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_5%>" value="N" id="<%=DLL_5%>" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL4().charAt(0)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_4%>" value="Y" id="<%=DLL_4%>" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else {%> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=DLL_4%>" value="N"
	id="<%=DLL_4%>" class="radio" onclick="chkValue(this);" /> <%} %> <%}else {%>
<label class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_4%>" value="Y" id="<%=DLL_4%>" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL3().charAt(0)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_3%>" value="N" id="<%=DLL_3%>" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=DLL_3%>" value="N"
	id="<%=DLL_3%>" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %>
<label class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_3%>" value="N" id="<%=DLL_3%>" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL2().charAt(0)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_2%>" value="Y" id="<%=DLL_2%>" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=DLL_2%>" value="N"
	id="<%=DLL_2%>" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %>
<label class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_2%>" value="N" id="<%=DLL_2%>" class="radio"
	onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL1().charAt(0)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_1%>" value="Y" id="<%=DLL_1%>" class="radio"
	onclick="chkValue(this);" CHECKED /> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=DLL_1%>" value="N"
	id="<%=DLL_1%>" class="radio" onclick="chkValue(this);" /> <%} %> <%}else{ %>
<label class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=DLL_1%>" value="N" id="<%=DLL_1%>" class="radio"
	onclick="chkValue(this);" /> <%} %>

<div class="division"></div>
<div class="Clear"></div>

<h5>Missing Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>

<%if(medicalExaminationBoardList1.get(0).getUR8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getUR8().charAt(1)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=MUR_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR7().charAt(1)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=MUR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=MUR_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR6().charAt(1)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=MUR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=MUR_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR5().charAt(1)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=MUR_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR4().charAt(1)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=MUR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=MUR_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR3().charAt(1)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=MUR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=MUR_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR2().charAt(1)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=MUR_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=MUR_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR1().charAt(1)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED> <%}else{ %> <label class="small">1</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=MUR_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getUL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getUL8().charAt(1)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=MUL_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL7().charAt(1)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=MUL_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL6().charAt(1)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=MUL_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL5().charAt(1)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=MUL_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL4().charAt(1)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=MUL_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL3().charAt(1)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=MUL_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL2().charAt(1)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="N" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=MUL_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL1().charAt(1)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=MUL_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=MUL_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLR8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLR8().charAt(1)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=MLR_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR7().charAt(1)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=MLR_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR6().charAt(1)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=MLR_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR5().charAt(1)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=MLR_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR4().charAt(1)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=MLR_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR3().charAt(1)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=MLR_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR2().charAt(1)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=MLR_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR1().charAt(1)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=MLR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=MLR_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLL8().charAt(1)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=MLL_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL7().charAt(1)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=MLL_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL6().charAt(1)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=MLL_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL5().charAt(1)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED />
<div class="clear"></div>
<%}else {%> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=MLL_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL4().charAt(1)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else {%> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else {%> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=MLL_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL3().charAt(1)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=MLL_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL2().charAt(1)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=MLL_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL1().charAt(1)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=MLL_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=MLL_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>

<div class="division"></div>

<h5>Unserviceable Teeth</h5>
<div class="Clear"></div>
<label class="medium">Upper Right</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getUR8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getUR8().charAt(2)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=UUR_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR7().charAt(2)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=UUR_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR6().charAt(2)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=UUR_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR5().charAt(2)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=UUR_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR4().charAt(2)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=UUR_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR3().charAt(2)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKEd /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=UUR_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR2().charAt(2)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_2%>" value="Y" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=UUR_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUR1().charAt(2)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=UUR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=UUR_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Upper Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getUL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getUL8().charAt(2)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=UUL_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL7().charAt(2)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=UUL_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL6().charAt(2)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=UUL_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL5().charAt(2)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=UUL_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL4().charAt(2)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=UUL_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL3().charAt(2)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=UUL_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL2().charAt(2)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=UUL_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getUL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getUL1().charAt(2)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="Y" class="radio" onclick="chkValue(this);" />
<%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=UUL_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=UUL_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>

<div class="Clear"></div>
<label class="medium">Lower Right</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLR8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLR8().charAt(2)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=ULR_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR7().charAt(2)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=ULR_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR6().charAt(2)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=ULR_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR5().charAt(2)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=ULR_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR4().charAt(2)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=ULR_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR3().charAt(2)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=ULR_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR2().charAt(2)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=ULR_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLR1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLR1().charAt(2)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=ULR_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=ULR_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="Clear"></div>
<label class="medium">Lower Left</label>
<div class="Clear"></div>
<%if(medicalExaminationBoardList1.get(0).getLL8()!=null){%> <%if(medicalExaminationBoardList1.get(0).getLL8().charAt(2)=='Y'){%>
<label class="small">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">8</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_8%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">8</label>
<input tabindex="1" type="checkbox" name="<%=ULL_8%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL7()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL7().charAt(2)=='Y'){%> <label
	class="small">7</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">7</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_7%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">7</label>
<input tabindex="1" type="checkbox" name="<%=ULL_7%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL6()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL6().charAt(2)=='Y'){%> <label
	class="small">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">6</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_6%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">6</label>
<input tabindex="1" type="checkbox" name="<%=ULL_6%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL5()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL5().charAt(2)=='Y'){%> <label
	class="small">5</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">5</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_5%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">5</label>
<input tabindex="1" type="checkbox" name="<%=ULL_5%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL4()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL4().charAt(2)=='Y'){%> <label
	class="small">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">4</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_4%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">4</label>
<input tabindex="1" type="checkbox" name="<%=ULL_4%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL3()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL3().charAt(2)=='Y'){%> <label
	class="small">3</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">3</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_3%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">3</label>
<input tabindex="1" type="checkbox" name="<%=ULL_3%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL2()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL2().charAt(2)=='Y'){%> <label
	class="small">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="Y" class="radio" onclick="chkValue(this);"
	CHECKED /> <%}else{ %> <label class="small">2</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_2%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">2</label>
<input tabindex="1" type="checkbox" name="<%=ULL_2%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %> <%if(medicalExaminationBoardList1.get(0).getLL1()!=null){%>
<%if(medicalExaminationBoardList1.get(0).getLL1().charAt(2)=='Y'){%> <label
	class="small">1</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="Y" class="radio" onclick="chkValue(this);" CHECKED//>
<%}else{ %> <label class="small">1</label> <input tabindex="1"
	type="checkbox" name="<%=ULL_1%>" value="N" class="radio"
	onclick="chkValue(this);" /> <%} %> <%}else{ %> <label class="small">1</label>
<input tabindex="1" type="checkbox" name="<%=ULL_1%>" value="N"
	class="radio" onclick="chkValue(this);" /> <%} %>
<div class="division"></div>
<div class="Clear"></div>
<label class="medium"> Remarks</label> <%if(medicalExaminationBoardList1.get(0).getRemarksTeath()!=null){%>
<textarea rows="" cols="" name="<%=DENTAL_REMARKS %>" class="large"><%=medicalExaminationBoardList1.get(0).getRemarksTeath() %></textarea>
<%}else{ %> <textarea rows="" cols="" name="<%=DENTAL_REMARKS %>"
	class="large"></textarea> <%} %> <label class="medium">Date</label> <input
	tabindex="1" type="text" class="calDate" name="<%=DENTAL_DATE %>"
	option value="<%=teethDate %>" validate="Teeth Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DENTAL_DATE%>,event)" ; />
</div>
</div>

<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitleFixed">GYNAECOLOGY <a
	href="javascript:animatedcollapse.toggle('slide13')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide13">
<div class="blockFrame">
<div class="Clear"></div
<div class="Height10"></div>

<label class="large">Menstrual History</label>
<%if(medicalExaminationBoardList1.get(0).getMenstrualHistory()!=null){%>
<input tabindex="1"  type="text" name="<%=MENSTRUAL_HISTORY %>"option value="<%=medicalExaminationBoardList1.get(0).getMenstrualHistory() %>"onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"/>
<%}else{ %>
<input tabindex="1"  type="text" name="<%=MENSTRUAL_HISTORY %>"onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"/>
<%} %>
<label class="large">LMP</label>
<%if(medicalExaminationBoardList1.get(0).getLmp()!=null){%>
<input tabindex="1"  type="text" name="<%=LMP %>" option value="<%=medicalExaminationBoardList1.get(0).getLmp() %>"vonKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%}else{ %>
<input tabindex="1"  type="text" name="<%=LMP %>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%} %>
<div class="Clear"></div>
<label class="large">No. of pregnancies</label>
<%if(medicalExaminationBoardList1.get(0).getNoOfPregnancies()!=null){%>
<input tabindex="1"  type="text" name="<%=NO_OF_PREGNANCY %>" option value="<%=medicalExaminationBoardList1.get(0).getNoOfPregnancies() %>"onkeyup="isNumber(this)" onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" />
<%}else{ %>
<input tabindex="1"  type="text" name="<%=NO_OF_PREGNANCY %>"onKeyDown="limitText(this,1);" onkeyup="isNumber(this)" onKeyUp="limitText(this,1);" />
<%} %>
<label class="large">No of Abortions</label>
<%if(medicalExaminationBoardList1.get(0).getNoOfAbortions()!=null){%>
<input tabindex="1"  type="text" name="<%= NO_OF_ABORTION%>" option value="<%=medicalExaminationBoardList1.get(0).getNoOfAbortions() %>"onkeyup="isNumber(this)" onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" />
<%}else{ %>
<input tabindex="1"  type="text" name="<%= NO_OF_ABORTION%>"onkeyup="isNumber(this)" onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" />
<%} %>
<div class="Clear"></div>
<label class="large">No of Children</label>
<%if(medicalExaminationBoardList1.get(0).getNoOfChildren()!=null){%>
<input tabindex="1"  type="text" name="<%= NO_OF_CHILDREN%>" option value="<%=medicalExaminationBoardList1.get(0).getNoOfChildren() %>"onkeyup="isNumber(this)" onKeyDown="limitText(this,1);" onKeyUp="limitText(this,1);" />
<%}else{ %>
<input tabindex="1"  type="text" name="<%= NO_OF_CHILDREN%>"onKeyDown="limitText(this,1);" onkeyup="isNumber(this)" onKeyUp="limitText(this,1);" />
<%} %>
<label class="large">Date of last confinement</label>

<input tabindex="1"  type="text" readonly="readonly" class="calDate" name="<%=DATE_OF_LASTCONFINEMENT %>" option value="<%=dateOfLastConfinement %>"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',medicalBoardExaminationUpdateReport.<%=DATE_OF_LASTCONFINEMENT%>,event)"; /> 
<div class="Clear"></div>

<label class="large">Vaginal Discharge</label>
<%if(medicalExaminationBoardList1.get(0).getVaginalDischarge()!=null){%>
<input tabindex="1"  type="text" name="<%=VAGINAL_DISCHARGE %>"option value="<%=medicalExaminationBoardList1.get(0).getVaginalDischarge() %>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%}else{ %>
<input tabindex="1"  type="text" name="<%=VAGINAL_DISCHARGE %>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%} %>
<label class="large">Prolapse</label>
<%if(medicalExaminationBoardList1.get(0).getProlapse()!=null){%>
<input tabindex="1"  type="text" name="<%= PROLAPSE%>" option value="<%= medicalExaminationBoardList1.get(0).getProlapse()%>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%}else{ %>
<input tabindex="1"  type="text" name="<%= PROLAPSE%>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%} %>
<div class="Clear"></div>

<label class="large">USG Abdomen</label>
<%if(medicalExaminationBoardList1.get(0).getUsgAbdomen()!=null){%>
<input tabindex="1"  type="text" name="<%=USG_ABORTION %>" opton value="<%=medicalExaminationBoardList1.get(0).getUsgAbdomen() %>"ionKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%}else{ %>
<input tabindex="1"  type="text" name="<%=USG_ABORTION %>"onKeyDown="limitText(this,10);" onKeyUp="limitText(this,10);"/>
<%} %>
<div class="Clear"></div>
<label class="large">Remarks</label>
<%if(medicalExaminationBoardList1.get(0).getRemarksGynaecology()!=null){%>
<textarea rows="" cols="" name="<%=GYANAECOLOGY_RAMARKS %>" class="large" onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"><%=medicalExaminationBoardList1.get(0).getRemarksGynaecology() %></textarea>
<%}else{ %>
<textarea rows="" cols="" name="<%=GYANAECOLOGY_RAMARKS %>" class="large" onKeyDown="limitText(this,30);" onKeyUp="limitText(this,30);"></textarea>
<%} %>
<script type="text/javascript">
<%
String gyanaecologyDate="";
String medicalExamDate=""; 
String subSequentMedicalDate="";
if(medicalExaminationBoardList1.get(0).getGynaecologyDate()!=null)
{
	gyanaecologyDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getGynaecologyDate());
}
else
{
	gyanaecologyDate="";
}


if(medicalExaminationBoardList1.get(0).getDateMedicalBoardExam()!=null)
{
	medicalExamDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateMedicalBoardExam());
}
else
{
	medicalExamDate="";
}
if(medicalExaminationBoardList1.get(0).getDateMedicalBoardSubsequent()!=null)
{
subSequentMedicalDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateMedicalBoardSubsequent());
}
else
{
subSequentMedicalDate="";
}
%>
</script>
<label class="medium">Date</label>
<input tabindex="1"  type="text"name="<%=GYANAECOLOGY_DATE%>" class="calDate" option value="<%=gyanaecologyDate%>" validate="GyanaecologyDate Date,date,no"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',medicalBoardExaminationUpdateReport.<%=GYANAECOLOGY_DATE%>,event)"; /> 

</div>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label class="large">FINDING OF
MEDICAL BOARD/EXAMINATION</label> <%if(medicalExaminationBoardList1.get(0).getMedicalBoardFindings()!=null){%>
<textarea rows="" cols="" name="<%=MEDICAL_BOARD_EXAMINATION%>"
	class="large" onKeyDown="limitText(this,100);"
	onKeyUp="limitText(this,100);"><%=medicalExaminationBoardList1.get(0).getMedicalBoardFindings() %></textarea>
<%}else{ %> <textarea rows="" cols=""
	name="<%=MEDICAL_BOARD_EXAMINATION%>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"></textarea>
<%} %>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=MEDICAL_BOARD_EXAMINATION_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit1 : masUnitList) {
			if(medicalExaminationBoardList1.get(0).getPlaceMedicalBoardExam()!=null){
				if(true){
			if(medicalExaminationBoardList1.get(0).getPlaceMedicalBoardExam().getId() == masUnit1.getId()){		

	%>

	<option value="<%=masUnit1.getId()%>" selected="selected"><%=masUnit1.getUnitName()%></option>
	<%}} %>
	<%}else %>
	<option value="<%=masUnit1.getId()%>"><%=masUnit1.getUnitName()%></option>

	<%
}

	%>

</select> <label>Date</label> <input tabindex="1" type="text"
	name="<%=MEDICAL_BOARD_EXAMINATION_DATE %>" class="calDate" option
	value="<%=medicalExamDate %>" validate="MedicalExamDate,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=MEDICAL_BOARD_EXAMINATION_DATE%>,event)" ; />
<div class="Clear"></div>
<label class="large">FINDING OF THE SUBSEQUENT MEDICAL
BOARD/EXAMINATION</label> <%if(medicalExaminationBoardList1.get(0).getMedicalBoardSubsequentFind()!=null){%>
<textarea rows="" cols=""
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION %>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"><%=medicalExaminationBoardList1.get(0).getMedicalBoardSubsequentFind() %></textarea>
<%}else{ %> <textarea rows="" cols=""
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION %>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"></textarea>
<%} %>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit2 : masUnitList) {
			if(medicalExaminationBoardList1.get(0).getPlaceMedicalBoardSubsequent()!=null){
				if(true){
			if(medicalExaminationBoardList1.get(0).getPlaceMedicalBoardSubsequent().getId() == masUnit2.getId()){		

	%>

	<option value="<%=masUnit2.getId()%>" selected="selected"><%=masUnit2.getUnitName()%></option>
	<%}} %>
	<%}else %>
	<option value="<%=masUnit2.getId()%>"><%=masUnit2.getUnitName()%></option>

	<%
}

	%>

</select> <label>Date</label> <input tabindex="1" type="text"
	name="<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE %>" class="calDate"
	option value="<%=subSequentMedicalDate %>"
	validate="subsequentMedical Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE%>,event)" ; />

<div class="Clear"></div>
<label class="large">APPROVING AUTHORITY</label> <%if(medicalExaminationBoardList1.get(0).getApprovingAuthority()!=null){%>
<textarea rows="" cols="" name="<%=APPROVING_AUTHORITY %>" class="large"
	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"><%=medicalExaminationBoardList1.get(0).getApprovingAuthority() %></textarea>
<%}else{ %> <textarea rows="" cols="" name="<%=APPROVING_AUTHORITY %>"
	class="large" onKeyDown="limitText(this,100);"
	onKeyUp="limitText(this,100);"></textarea> <%} %>
<div class="Clear"></div>
<label class="large">Place</label> <select
	name="<%=APPROVING_AUTHORITY_PLACE %>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit3 : masUnitList) {
			if(medicalExaminationBoardList1.get(0).getPlaceApprovingAuthority()!=null){
				if(true){
			if(medicalExaminationBoardList1.get(0).getPlaceApprovingAuthority().getId() == masUnit3.getId()){		

	%>

	<option value="<%=masUnit3.getId()%>" selected="selected"><%=masUnit3.getUnitName()%></option>
	<%}} %>
	<%}else %>
	<option value="<%=masUnit3.getId()%>"><%=masUnit3.getUnitName()%></option>

	<%
}

	%>

</select> <script type="text/javascript">
	<%
	String appovingAuthorityDate="";
	if(medicalExaminationBoardList1.get(0).getDateApprovingAuthority()!=null)
	{
		appovingAuthorityDate=HMSUtil.convertDateToStringWithoutTime(medicalExaminationBoardList1.get(0).getDateApprovingAuthority());
	}
	else
	{
		appovingAuthorityDate="";	
	}
	%>
	</script> <label>Date</label> <input tabindex="1" type="text"
	name="<%=APPROVING_AUTHORITY_DATE %>" class="calDate" option
	value="<%=appovingAuthorityDate %>"
	validate="subsequentMedical Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationUpdateReport.<%=APPROVING_AUTHORITY_DATE%>,event)" ; />
</div>
<!-- Block 8 Ends --> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="bottom">
<div class="division"></div>
<input tabindex="1" name="Button" type="button" class="button"
	value="Update"
	onClick="submitForm('medicalBoardExaminationUpdateReport','medicalExaminationBoard?method=medicalExaminationBoardUpdateToDatabase');" />
<INPUT class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <input tabindex="1"
	name="Button" type="button" class="button2"
	onClick="submitForm('medicalBoardExaminationUpdateReport','medicalExaminationBoard?method=printMedicalBoard');"
	value="Print Medical Board Proceedings" />

<div class="division"></div>
<input type="hidden" value="<%=inc-1%>" name="hiddenValue"
	id="hiddenValue" /> <label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="Clear"></div>

<input type="hidden" name="<%=CHANGED_BY%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" /></div>
<!--Bottom labels starts--></form>
</div>

<!--main content placeholder ends here-->

<script type="text/javascript">
	function generateRowMdicalBoardUpdate(idName) {
		  document.getElementById("noOfRecords").value = parseInt(document.getElementById("noOfRecords").value)+1	
		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[0].value=d.length-2;
		var temp=d.length-1
		document.getElementById('hiddenValue').value=d.length-2
		//tblCtrl[1].name="unfit"+d.length-1;		
		for(var i=1;i<tblCtrl.length;i++)
			tblCtrl[i].value="";		
			
		}
  
   function removeRowMedicalBoardUpdate()
	{
	
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >1){
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	 else
	 {
	 alert("There should be atleast one row")
	 }
	}
	</script>
<script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        alert("you can't Enter more data");  
        limitField.value = limitField.value.substring(0, limitNum);
      
    } 
}


function chkValue(field)
{

	if(!field.checked)
	{
	field.value="N";
	}
	else{
	field.value="Y";
	}
	
}




</script>
<script language="JavaScript" type="text/JavaScript"> 
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
    } 
    
     function isNumber1(field) { 
       var i=3;
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
       
        } 
     var aa=field.value[1];
    if(field.value.indexOf(".")<4)
    {
 return true;
 }
 else
 {
     alert('please enter less than three digit before decimal point'+aa); 
		 field.value=''; 
 
	}




}
function checkForWiegth(val,id){
var index=val.indexOf(".");
if(index!=-1){
	var arr= val.split(".");
	if(arr[1].length>3){
	alert("pls check the decimal fractions");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
	
	}
	else{
	
	if(val.length>3){
	alert("pls give the decimal point after three digit");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
 
 }
 
 }
</script>


