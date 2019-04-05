<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
var bankArray=new Array();
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

function checkForInvestReferToMH()
 {
 	var inc=document.getElementById('hiddenValue').value;
 	var i;
 	for(i=1;i<=inc;i++)
 	{
 		if(document.getElementById('investigationReferToMH'+i).checked==true)
 		{
 			document.getElementById('uploadReport'+i).style.display='inline';
 		}
 	}
 }
function checkForDentalMH()
{
   if(document.getElementById('dentalReferToMH').checked==true)
   {
   	document.getElementById('dentalReferToMH').value='yes';
   } else
   {
   	document.getElementById('dentalReferToMH').value='no';
   }
}
</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

List visitlist = new ArrayList();
if(map.get("visit") != null){
	visitlist=(List)map.get("visit");
}
Visit visit=null;
String url="";
if(visitlist!=null &&visitlist.size()>0)
{
 	visit=(Visit)visitlist.get(0);
}
if(map.get("url") != null){
	url = (String)map.get("url");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){

	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	getDgOrderdts=dgOrderhd.getDgOrderdts();
}
String service_no="";
if(visit.getHin()!=null){
	service_no=visit.getHin().getServiceNo();
}
String rank="";
if(visit.getHin().getRank()!=null){
	rank=visit.getHin().getRank().getRankName();
}
String signedBy="";
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");

}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		signedBy=masEmployee.getFirstName();
		if(masEmployee.getMiddleName()!=null){
			signedBy=signedBy+" "+masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null){
			signedBy=signedBy+" "+masEmployee.getLastName();
		}
	}
}
%>
function checkTemplateId(templateId){

    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
</script>
<%
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
   }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>
<%---
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('mbConfirmAuthForm16','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('mbConfirmAuthForm16','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('mbConfirmAuthForm16','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('mbConfirmAuthForm16','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');"" />
</div> --%>
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" 
	onclick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" 
	class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF 16 </h2>
</div>
<div class="clear"></div>
<form name="mbConfirmAuthForm16" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
int visitId=0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();
}
int hinId=0;
if(medExamObj.getVisit()!=null){
	visitId=medExamObj.getVisit().getId();
	hinId=medExamObj.getHin().getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>" id="medExamId" readonly="readonly">
<input type="hidden" name="visitId" value="<%=visitId %>"/>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" id="hinId"/>
<div class="clear"></div>
<div class="Block">
<label>Authority for Board</label>
 <%
 String authority="";
 if(medExamObj.getAuthority()!=null){
 authority=medExamObj.getAuthority();
 }%>
<input tabindex="1" type="text"  name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="<%=authority %>"  readonly="readonly"
	onKeyUp="limitText(this,100);"  />

 <%if(session.getAttribute("hospitalName")!=null){ %>
<label>Place </label>
<input tabindex="1" type="text" class="auto" size="50" maxlength="20"  id="" name="<%=PLACE %>"  value="<%=((String)session.getAttribute("hospitalName")) %>"
	onKeyUp="limitText(this,20);" readonly="readonly" />
<%}%><div class="clear"/></div>
<label>Date Of Discharge</label>
<%if(medExamObj.getDateOfDischarge() !=null){ %>
<input tabindex="1" type="text"	name="dateOfDischarge" class="" maxlength="10"  class="auto"
 value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfDischarge()) %>" readonly="readonly" />
<%}else{ %>
 <input tabindex="1" type="text"	name="dateOfDischarge" class="" maxlength="10"  class="auto"
 value="<%=date %>" validate="Discharge Date,date,no" readonly="readonly"/>
<%} %>
	<label>Date</label>
<%if(medExamObj.getId()==null)
{%>
 <input tabindex="1" type="text"   readonly="readonly"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>" validate="Reported Date,date,no" />
<% }else if(medExamObj.getDateOfReporting() !=null){%>
 <input tabindex="1" type="text"	 readonly="readonly"  name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
	validate="Reported Date,date,no" />

<% }else{%>
 <input tabindex="1" type="text" name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"   readonly="readonly"
onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"	validate="Reported Date,date,no" />
<%} %>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('',medicalBoardMOForm16.<%=REPORTED_DATE%>,event);" />
<div class="clear"></div>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<label> Date of Release  </label>
<input name="<%=DATE_OF_RELEASE %>" class="date" value="<%=date %>" tabindex="1" maxlength="10"
	validate="Date of Release,date,no" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
 class="calender" onclick="setdate('',medicalBoardMOForm16.<%=DATE_OF_RELEASE%>,event);" />
<label>Name  </label>
<%String sPersonName="";
sPersonName=visit.getHin().getSFirstName();
if(visit.getHin().getSMiddleName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSMiddleName();
}
if(visit.getHin().getSLastName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSLastName();
}if(dgOrderhd!=null){ %>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<%}else{ %>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<% }%>
 <input type="text" value="<%=sPersonName %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2"/>

<label>Service No. </label>
<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />
<% }else{%>
 <input type="hidden" value="Medical Board AFMSF 16" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />

  <label>Unit </label>
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 <label>Service</label>
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <div class="clear"></div>
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength= />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />
<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>
 <% }%>
<label>Total Service  </label>
 <%if(visit.getHin().getServiceYears()!=null)
{ %>
<input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
<% }else{%>
<input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" readonly="readonly"/>
<% }%>
 <label> DOB </label>
 <%
 if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="12"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="" value="30/09/1982"
	validate="DOB,date,yes" maxlength="12"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<% }%>

 <div class="clear"></div>
<label>Total Flying Hours</label> 
 <!-- Code By Dipali -->
 <%if(medExamObj.getHoursOfFlown()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%=medExamObj.getHoursOfFlown() %>" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }else{%>
 <input	type="text" value="" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }%>

 <label >DOC/DOE</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="2" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	readonly="readonly"/>
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	readonly="readonly"/>
 <% }%>
  <label >Permanent Address</label>
 <%String permaAddress="";
if(medExamObj.getParmanentAddress() !=null){
	permaAddress=medExamObj.getParmanentAddress();}%>
<textarea rows="" cols=""  class="medium" name="<%=PERMANENT_ADDRESS %>" class="large"readonly="readonly" >
<%=permaAddress %></textarea>

 <div class="clear"></div>
 <div class="floatLeft">
 <label >Identification Marks</label>
 <%
 String identification1="";
 String identification2="";
 if(medExamObj.getIdentificationMarks1()!=null){
	 identification1=medExamObj.getIdentificationMarks1();
 }
 if(medExamObj.getIdentificationMarks2()!=null){
	 identification2=medExamObj.getIdentificationMarks2();
 }
 %>
<label class="valueAuto">1</label><input tabindex="1" type="text"  readonly="readonly"  id="<%=IDENTIFICATION_MARKS1 %>" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6"
	 value="<%=identification1%>"	class="auto" size="50"  />
<div class="clear"></div>
<input class="transparent" size="28">
<label class="valueAuto">2</label><input tabindex="1" type="text" id="<%=IDENTIFICATION_MARKS2 %>" name="<%=IDENTIFICATION_MARKS2 %>"
 value="<%=identification2%>"	readonly="readonly" class="auto" size="50"  />
</div>

<div class="smallest floatRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDisability">
	<tr>
<th scope="col">Disability</th>
</tr>
<% int incDisability=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail"))
	{
			incDisability=incDisability+1;
			int icdId=0;
			String icdCd="";
			if(setMedicalExam.getMasIcd()!=null){
				icdId=setMedicalExam.getMasIcd().getId();
				icdCd=setMedicalExam.getMasIcd().getIcdCode();
			}
			String disabilityStr="";
			disabilityStr=setMedicalExam.getPrincipal()+"["+icdCd+"]";
	%>
	<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value="<%=disabilityStr %>"	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly"/>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability%>" id="hdbDisability" />
</tr>
	<%
	}
}
%>
<%
}
if(incDisability <=0){
	//medicalBoardMAForm16.out.println("this is else jsp");
incDisability=1;%>
<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value=""	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly" readonly="readonly"/>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability %>" id="hdbDisability" />
</tr>
<%} %>
</table>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide2">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">Sl. No.</TH>
<TH scope="col">From</TH>
<TH scope="col">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
</tr>
<% int inc1=0;

if(medExamObj.getMasmedicaldetail()!=null)
{

	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail1"))
	{

		inc1=inc1+1;
	%>

<tr>
<% if(setMedicalExam.getSerialno()!=null){%>
<td><input type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getSerialno() %>" tabindex="1" size="2"/></td>
<% }else{%>
<td><input type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" maxlength="10" tabindex="1" size="2"/></td>

<% }%>
<% if(setMedicalExam.getAddressfrom()!=null)
{
%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressfrom()) %>"/></td>
<% }else{
%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>" maxlength="10" />
<% }%>
</td>
<% if(setMedicalExam.getAddressto()!=null ){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<% }%>
<% if(setMedicalExam.getPlace()!=null && ! setMedicalExam.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"  readonly="readonly" /></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10"  readonly="readonly" /></td>
<% }%>
<% if(setMedicalExam.getPno()!=null && ! setMedicalExam.getPno().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPno() %>"   readonly="readonly"  /></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10"  readonly="readonly" /></td>
<% }%>

</tr>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=setMedicalExam.getServiceid()%>" id="serviceId" />
<%
	}
}}if(inc1<=0){
	++inc1;%>
<tr>
<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" value=<%=inc1%> maxlength="10" /></td>
<td width="10%">
<input tabindex="1" type="text" readonly="readonly"	name="<%=FROM+inc1 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10"  readonly="readonly" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10"  readonly="readonly" /></td>
</tr>
<% }%>
<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" />
</table>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Disease,Wound or Injures Details<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<TH scope="col">Sl. No.</TH>
<TH scope="col">Illness/wound</TH>
<TH scope="col" >First Started on</TH>
<TH scope="col">First Started at</TH>
<TH>Where Treated</TH>
<TH >Approximate Date and Periods Treated</TH>
</tr>
<% int inc11=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

	if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")
		&& setMedicalExam.getBeforeDisability() !=null	&& setMedicalExam.getBeforeDisability().equalsIgnoreCase("n")){
		inc11=inc11+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){
 
 int icdId=0;
			String icdCd="";
			if(setMedicalExam.getMasIcd()!=null){
				icdId=setMedicalExam.getMasIcd().getId();
				icdCd=setMedicalExam.getMasIcd().getIcdCode();
			}
			String disabilityStr="";
			disabilityStr=setMedicalExam.getIllness()+"["+icdCd+"]";%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" value="<%=disabilityStr%>"   readonly="readonly" /></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10"  readonly="readonly" /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 </td>

 <% if(setMedicalExam.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=setMedicalExam.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10"  readonly="readonly" /></td>
 <% }%>

 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>


 <% if(setMedicalExam.getApproximatedate()!=null){  %>
<td width="20%"><input type="text"	 readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="40" value="<%=setMedicalExam.getApproximatedate()%>"	validate="DOB,String,no" maxlength="30"
	 /> </td>
  <% }else{%>
<td width="20%"><input  type="text"  readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="40"	validate="DOB,String,no" maxlength="30" />
 <% }%>
  </td>
</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=setMedicalExam.getServiceid()%>"  />
<%
}}}if(inc11<0){
++inc11;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>"/></td>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=PLACE1+inc11 %>" maxlength="10" /></td>

<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" /></td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="40"	validate="DOB,String,no" maxlength="30" value=""
	/>

</td>

</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<%
String displayStyle="";
String displayValue="";
if(medExamObj.getDisabilitybefore()!=null){
	
	displayValue=medExamObj.getDisabilitybefore();
	if(displayValue.equalsIgnoreCase("y")){
		displayStyle="inline";
	}else{
		displayStyle="none";
	}
}else{
	displayStyle="inline";
}
%>
<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
<%--<label class="auto">Yes</label>
<input type="checkbox" class="radioAuto" disabled="disabled"/>
<label class="auto">No</label>
<input type="checkbox" class="radioAuto" disabled="disabled"/>--%>
<select name="<%=DISABILITY_BEFORE%>" disabled="disabled" tabindex="1" id="<%=DISABILITY_BEFORE%>" onchange="showHideDisabilityBefore();" class="small">
	<option value="y">Yes</option>
	<option value="n">No</option>
	</select>
	<script type="text/javascript">
document.getElementById('disabilitybefore').value ='<%=displayValue%>';
</script>

</div>
<div class="clear"></div>

<!--If yes then below details and dates option will appear (By Anshu)-->

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIllness">
	<tr>
<th scope="col" rowspan="">Sl. No.</th>
<th rowspan="" scope="col">Illness/Wound/Injury Details</th>
<th colspan="" rowspan="" scope="col">First Started on</th>
<th colspan="2" scope="col">First Started at</th>
<th rowspan="">Where Treated</th>
</tr>

<% int incBefore=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

	if(setMedicalExam.getBeforeDisability()!=null && setMedicalExam.getBeforeDisability().equalsIgnoreCase("y")){
		incBefore=incBefore+1;
	%>
<TR>

 <% if(setMedicalExam.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=setMedicalExam.getSerialno() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){
  int icdId=0;
			String icdCd="";
			if(setMedicalExam.getMasIcd()!=null){
				icdId=setMedicalExam.getMasIcd().getId();
				icdCd=setMedicalExam.getMasIcd().getIcdCode();
			}
			String disabilityStr="";
			disabilityStr=setMedicalExam.getIllness()+"["+icdCd+"]";%>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" value="<%=disabilityStr%>"
class="auto" size="50"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 </td>
 <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE%>1<%=incBefore%>,event);" />

</td>

 <% if(setMedicalExam.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" value="<%=setMedicalExam.getPlace()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" /></td>
 <% }%>

 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED%>1<%=incBefore %>" maxlength="10" value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED%>1<%=incBefore %>" maxlength="10" /></td>
 <% }%>


</TR>
<input type=hidden name="<%=SERVICEID%>1<%=incBefore %>" value="<%=setMedicalExam.getServiceid()%>"  />
<%
String beforeDisability="";
if(setMedicalExam.getBeforeDisability()!=null){
	beforeDisability=setMedicalExam.getBeforeDisability();
}else{
	beforeDisability="y";
}
%>
<input type=hidden name="beforeDisability<%=incBefore %>" id="beforeDisability<%=incBefore %>" value="<%=beforeDisability%>"  />

<%
}}}

if(incBefore<=0){
	incBefore=1;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=incBefore %>"/></td>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE%>1<%=incBefore%>,event);" />

</td>
<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" /></td>

<td width="10%"><input tabindex="1" type="text"	 readonly="readonly"  name="<%=TREATED%>1<%=incBefore%>" maxlength="10" /></td>
<input type=hidden name="beforeDisability1<%=incBefore %>" id="beforeDisability1<%=incBefore %>" value="y"/>
</TR>

<% }%>
<input type="hidden" name="hdbBefore" value="<%=incBefore%>" id="hdbBefore" />
</table>
</div><div class="Block">
<script>
<%
	String incidentsDuringYourService="";
	if(medExamObj.getIncidentsDuringYourService()!= null){
		incidentsDuringYourService=medExamObj.getIncidentsDuringYourService();
	}
	String reasonWoundInjury="";
	if(medExamObj.getReasonWoundInjury()!= null){
		reasonWoundInjury=medExamObj.getReasonWoundInjury();
	}
	String medBoardHeld="";
	if(medExamObj.getMedBoardHeld()!= null){
		medBoardHeld=medExamObj.getMedBoardHeld();
	}
	String injuryReport="";
	if(medExamObj.getInjuryReport()!= null){
		injuryReport=medExamObj.getInjuryReport();
	}
%>
</script>
<label class="large2">Details of any incidents during your service which you think caused/made your disability worse</label>
<textarea name="incidents_during_your_service" id="incidents_during_your_service" rows="" cols="" class="large"><%=incidentsDuringYourService%></textarea>

<div class="clear"></div>
<label class="large2">In case of wound/injury, state how they happened</label>
<textarea rows="" cols="" name="<%=REASON_WOUND_INJURY%>" id="<%=REASON_WOUND_INJURY%>"   class="large"><%=reasonWoundInjury%></textarea>
<div class="clear"></div>
<label class="large2">Med Board/ Court of inquiry was held</label>
<select name="MED_BOARD_HELD" id="MED_BOARD_HELD" class="small" disabled="disabled">
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.MED_BOARD_HELD.value='<%=medBoardHeld%>';
</script>
<input class="transparent" size="1" />
<label>Injury Report</label>
<select name="INJURY_REPORT" id="INJURY_REPORT" disabled="disabled" >
<option value="Submitted">Submitted</option>
<option value="Not Submitted">Not Submitted</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.INJURY_REPORT.value='<%=injuryReport%>';
</script>
<div class="clear"></div>
<label class="large2">Any other health information</label>

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" cols="71" class="large"   	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" cols="71" class="large"  	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ></textarea>
 <% }%>

 <div class="clear"></div></div>
<div class="clear paddingTop15"></div>
<h4>Individual Details</h4>
<div class="Block">
<%
String individualSign="";
if(medExamObj.getIndividualDigitalSign() !=null){
individualSign=medExamObj.getIndividualDigitalSign();}%>
<label>Signature of Individual</label>
 <input type="text" name="<%=SIGN%>" id="<%=SIGN%>" maxlength="30" value="<%=individualSign %>"disabled="disabled"  />

 <label>Service No.</label>
 <input type="text" value="<%=service_no%>"  readonly="readonly"  name="<%=SIGN%>" id="<%=SIGN%>"/>

  <label>Rank</label>
 <input type="text" value="<%=rank %>" name="<%=SIGN%>" id="<%=SIGN%>"   readonly="readonly"  />

 <label>Date</label>
 <input type="text" name="<%=SIGN_DATE%>" value="<%=date%>" tabindex="2" maxlength="20" size="11" readonly="readonly" />

</div>
<div class="clear paddingTop15"></div>

<input type="hidden" name="viewMedExamDetails" value="View Med Exam Details" class="buttonBig2" onClick="openPopupForMedExamDetail(<%=medExamId %>,<%=visitId %>);"/>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Clinical Summary"	onClick="openPopupForClinicalSummary(<%=medExamId %>,<%=visitId %>);" />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Commanding Officer" onClick="openPopupForCommandingOfficer()" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Medical Board Opinion" onClick="openPopupForMedicalBoard(<%=medExamId %>,<%=visitId %>)" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="View Specialist Opinion"	onClick="openPopupForSpecialistOpinion();" />

<div class="clear paddingTop15"></div>
<h4>Approving Authority </h4>
<div class="Block">

<label>Remarks</label>
<% String authRemarks="";
	String approveSignby="";
	if(medExamObj.getApprovAuthRemarks() !=null){
	authRemarks=medExamObj.getApprovAuthRemarks(); }
	if(medExamObj.getApprovAuthSignedBy() !=null){
	approveSignby=medExamObj.getApprovAuthSignedBy();
	}%>
<input type="text" name="<%=AUTH_REMARKS %>" value="<%=authRemarks %>" readonly="readonly"/>

<label>Signed By</label>
<input type="text" name="approveSignby" value="<%=approveSignby %>" readonly="readonly"/>

</div>
<div class="clear paddingTop15"></div>
<h4>Comfirming Authority </h4>

<div class="Block">
<label>Remarks</label>
<%String confRemarks="";
if(medExamObj.getConfirmRemarks() !=null){
	confRemarks=medExamObj.getConfirmRemarks(); }
	String confirmSignby="";
	if(medExamObj.getConfirmSignedBy() !=null){
		confirmSignby=medExamObj.getConfirmSignedBy();
	}%>
<input type="text" name="<%=CONF_REMARKS %>" value="<%=confRemarks %>" validate="Remarks,metachar,no" maxlength="99"
id="confirmRemark" />

<label>Signed By</label>
<input type="text" name="<%=SIGNED_BY %>" value="<%=signedBy %>" readonly="readonly" validate="Signed By,metachar,no"/>

</div>
<div class="clear"></div>

<div class="division"></div>

<input tabindex="1" name="Button" type="button" class="button" value="Validate" onClick="submitForm('mbConfirmAuthForm16','medicalBoard?method=validateConfAuthForm16Jsp&data=validate');"/>
<input tabindex="1" name="Button" type="button" class="button" value="REJECT" onClick="checkReject();" />
<input tabindex="1" class=button id=reset onclick="resetCheck();" type=reset value=Reset name=Reset  accessKey=r/>
<input type="button" name="viewCaseSheet" value="Medical Case Sheet" class="buttonBig2" onclick="submitForm('mbConfirmAuthForm16','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equals("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input type="hidden" name="viewAttachment" value="View Attachment" class="buttonBig2"/>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">

</div>
</form>
<script type="text/javascript">
function openPopupForMedExamDetail(medExamId,visitId)
{
	var url='/hms/hms/medicalBoard?method=showPopUpViewMedExamDetail&medExamId='+medExamId+'&visitId='+visitId ;
   	newwindow=window.open(url,'medExamDetail','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}

function openPopupForClinicalSummary(medExamId,visitId)
{
	var url='/hms/hms/medicalBoard?method=showViewClinicalSummaryJsp&medExamId='+medExamId+'&visitId='+visitId ;
   	newwindow=window.open(url,'clinicalSummary','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function openPopupForMedicalBoard(medExamId,visitId){
	var url='/hms/hms/medicalBoard?method=showMedicalBoard16Jsp&medExamId='+medExamId+'&visitId='+visitId ;
   newwindow=window.open(url,'medicalBoardOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function openPopupForCommandingOfficer(){
	var url="/hms/hms/medicalBoard?method=showCommandOfficerJsp&medExamId="+document.getElementById("medExamId").value;
   newwindow=window.open(url,'mbSpecialistOpinion','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}
function checkReject(){
	var authRemarks=document.getElementById("confirmRemark").value;
	if(authRemarks!=""){
		submitForm('mbConfirmAuthForm16','medicalBoard?method=rejectMBForm16Entry&rejectStatus=ar');
	}else{
		alert("Please Enter Remark.");
	return false;
		}
}
function openPopupForSpecialistOpinion()
{
	var url="/hms/hms/medicalBoard?method=showViewSpecialistOpinionJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
	newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function submitForInvestigationPrintOut()
{
	var orderNo=document.getElementById('dgOrderhdId').value;
	var flag="MO";
	var hinId= document.getElementById('hinId').value;
	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
		submitFormForButton('mbConfirmAuthForm16','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
		}
}

function openPopupPatientPreviousVisit()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
   	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedBoardFromHIC()
{
	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&serviceNo=<%=visit.getHin().getServiceNo() %>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedExamFromHIC()
{
//	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function showPatientPreVisitHospitality()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
   	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
</script>