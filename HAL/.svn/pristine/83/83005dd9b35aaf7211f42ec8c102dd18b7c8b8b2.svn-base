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
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamInvestResult"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
	<!-- -
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
 -->
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
	</script>
<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}

List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");

	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);

}
List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=null;
if(map.get("masMedicalExamInvestResultList")!=null)
{
	masMedicalExamInvestResultList = (List<MasMedicalExamInvestResult>) map.get("masMedicalExamInvestResultList");

}
String signedByAA="";
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");

}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		signedByAA=masEmployee.getFirstName();
		if(masEmployee.getMiddleName()!=null){
			signedByAA=signedByAA+" "+masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null){
			signedByAA=signedByAA+" "+masEmployee.getLastName();
		}
	}
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
//Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){

	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	//patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}
List<PatientInvestigationDetails> patientInvestigationdetails=null;
if(map.get("patientInvestigationDetailsList")!=null)
{
	patientInvestigationdetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetailsList");
}
DgOrderhd dgOrderhd=null;
//Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){

	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	//getDgOrderdts=dgOrderhd.getDgOrderdts();
}
List<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderdtList")!=null)
{
	getDgOrderdts=(List<DgOrderdt>)map.get("dgOrderdtList");
}
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}

%>
</script>
<%
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
   }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%}
%>

<div>
<!--<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtnPA','opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtnPA','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtnPA','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtnPA','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
-->
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" 
onclick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>

<!--main content placeholder starts here-->
<div class="titleBg"><h2>Primary Medical Examination Report(AFMSF-2A)</h2></div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalExamPrimaryExtnPA" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){

	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<div class="Block">
<label>Authority</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="<%=medExamObj.getAuthority() %>"
	onKeyUp="limitText(this,100);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="IAP 4303 (4th Ed)"	onKeyUp="limitText(this,100);"  />

 <% }%>

<label>Service Number </label>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" />
 <input type="text"	value="<%= visit.getHin().getServiceNo() %>" name="<%=SERVICE_NO %>" tabindex="1" readonly="readonly"/>
 <input type="hidden"	value="<%= visit.getId() %>" name="<%=VISIT_ID %>" />
 <input type="hidden"	value="<%= visit.getHin().getId() %>" name="<%=HIN_ID %>" id="hinId"/>


  <label>Rank  </label>
  <input type="text" readonly="readonly" value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>"	tabindex="1" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	maxlength="20" />

   <div class="clear"></div>

  <label>Name  </label>
  <%
  	String name = "";
  if(visit.getHin().getSFirstName() != null){
	  name = visit.getHin().getSFirstName();
  }
  if(visit.getHin().getSMiddleName() != null){
	  name += " "+visit.getHin().getSMiddleName();
  }
  if(visit.getHin().getSLastName() != null){
	  name += " "+visit.getHin().getSLastName();
  }
  %>
 <input	type="text" readonly="readonly" value="<%= name %>" name="<%=FULL_NAME%>"	tabindex="1" maxlength="20" />

  <label>Father's Name  </label>
  <%
  	if(medExamObj.getFatherName() != null){
  %>
   <input type="text" readonly="readonly" value="<%= medExamObj.getFatherName() %>" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="50"/>
  <%}else{ %>
 <input	type="text" readonly="readonly" value="" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="50"/>
 <%} %>
 <label>DOB</label>
 <%
 if(visit.getHin().getDateOfBirth() != null){
 %>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<%}else{ %>
	<input tabindex="1" name="<%=DATE_OF_BIRTH %>"  value=""  maxlength="10" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<%} %>

	 <div class="clear"></div>

 <label>Age  </label>
 <input	type="text" value="<%= visit.getAge() %>" name="<%=AGE%>"	maxlength="20" tabindex="1" readonly="readonly"/>


  <label>Apparent Age  </label>
  <%
  if(medExamObj.getApparentAge() != null){
  %>
 <input	type="text" readonly="readonly" value="<%=medExamObj.getApparentAge() %>" name="apparentAge"	maxlength="20" tabindex="1" />
 <%}else{ %>
 <input	type="text" readonly="readonly" value="" name="apparentAge"	maxlength="20" tabindex="1" />

 <%} %>


 <label>Service </label>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="1" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID  %>"	maxlength="20" />

 <div class="clear"></div>

 <label>Present Unit</label>
 <%
 String unitName = "";
 int unitId = 0;
 	if( visit.getHin().getUnit() != null){
 		unitName =  visit.getHin().getUnit().getUnitName();
 		unitId = visit.getHin().getUnit().getId();
 	}
 %>
 <input	type="text" readonly="readonly" value="<%=unitName %>" name="<%=UNIT%>"	tabindex="1" maxlength="20" />
  <input type="hidden" value="<%= unitId %>" name="<%=UNIT_ID%>" maxlength="20"/>

 <label>Branch/Trade  </label>
 <%
 String tradeName = "";
 int tradeId = 0;
 	if( visit.getHin().getTrade() != null){
 		tradeName =  visit.getHin().getTrade().getTradeName();
 		tradeId = visit.getHin().getTrade().getId() ;
 	}
 %>
 <input	type="text" readonly="readonly" value="<%= tradeName %>" name="<%=TRADE%>"	tabindex="1" maxlength="20" />
 <input	type="hidden" value="<%=tradeId %>" name="<%=TRADE_ID%>" maxlength="20" />

<%
float serviceYear = 0.0f;
String servicePeriod = "";
if(visit.getHin().getServiceYears()!= null)
 {
	serviceYear = visit.getHin().getServiceYears();
 }
if(visit.getHin().getTotalServicePeriod()!= null)
  {
	servicePeriod = visit.getHin().getTotalServicePeriod();
  }

%>
 <label>Total Service  </label>
 <input	type="text" readonly="readonly" value="<%= serviceYear+" "+ servicePeriod%>" name="<%=TOTAL_SERVICE%>"	tabindex="2" maxlength="20" />

  <div class="clear"></div>


  <label>Permanent Address  </label>
   <%
  	if(visit.getHin().getPermanentAddress() != null){
  %>
   <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ><%=visit.getHin().getPermanentAddress() %></textarea>
  <%}else{ %>
 <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <%} %>
 <label>Past Medical History  </label>
 <%
  if(medExamObj.getPastmedicalhistory() != null){
  %>
 <input	type="text" readonly="readonly" value="<%= medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100"/>
 <%}else{ %>
  <input	type="text" readonly="readonly" value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100"/>
 <%} %>
 <label>Relevant Family History </label>
 <%
 if(medExamObj.getRelevantFamilyHistory() != null){
 %>
  <input type="text" readonly="readonly" value="<%=  medExamObj.getRelevantFamilyHistory() %>" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100"/>
 <%}else{ %>
 <input	type="text" value="" readonly="readonly" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100"/>
 <%} %>
   <div class="clear"></div>
<label>Identification Marks</label>
 <% if(visit.getHin().getSrIdentificationMark1()!=null){%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>" value="<%=visit.getHin().getSrIdentificationMark1() %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  />

 <% }else{%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  />

 <% }%>
<div class="clear"></div>
<input class="transparent" size="27">
<% if(visit.getHin().getSrIdentificationMark2()!=null){%>
<label class="valueAuto">2.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS2 %>" value="<%=visit.getHin().getSrIdentificationMark2() %>"
	onKeyUp="limitText(this,50);" class="auto" size="72" />

 <% }else{%>
<label class="valueAuto">2.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS2 %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  />

 <% }%>
 <div class="clear"></div>
</div>

<div class="clear paddingTop15"></div>


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
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
		<td width="10%">

  <% if(medExamObj.getWthoutGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWthoutGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>


	</tr>

</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Any evidence of trachoma and its complications or any other disease</label>
<% if(medExamObj.getEvidenceOfTrachoma()!=null){%>
 <textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" disabled="disabled" class="large" onkeyup="chkLength(this,30);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ><%=medExamObj.getEvidenceOfTrachoma() %></textarea>
 <% }else{%>
<textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" disabled="disabled"
	onkeyup="chkLength(this,30);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <% }%>
<div class="clear"></div>
<label class="large2">Binocular vision & Grade</label>
<% if(medExamObj.getBinocularVisionGrade()!=null){%>
<input
	tabindex="1" readonly="readonly" type="text" name="<%=BINOCULAR_VISION_GRADE %>" value="<%=medExamObj.getBinocularVisionGrade() %>"
	class="large" maxlength="50" />
 <% }else{%>
<input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>" readonly="readonly"
	class="large" maxlength="50" />
 <% }%>
 	</div>
</div>
<div class="clear paddingTop15"></div>



<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">

<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Both</th>
	</tr>

	<tr>

	<th>FW</th>
	<td>
		<% if(medExamObj.getEarHearingRfw() != null){ %>
		<input tabindex="1" type="text" readonly="readonly" maxlength="20" class="auto"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" type="text" readonly="readonly" maxlength="20" class="auto" id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%} %>
		cm
	</td>

	<td>
		<% if(medExamObj.getEarHearingLfw() != null){ %>
		<input tabindex="1" readonly="readonly" type="text" maxlength="20" class="auto"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" readonly="readonly" type="text" maxlength="20" class="auto" id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%} %>
		cm
	</td>

	<td>
		<% if(medExamObj.getEarHearingBothFw() != null){ %>
		<input tabindex="1" readonly="readonly" type="text" maxlength="20" class="auto" size="15" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" readonly="readonly" type="text" maxlength="20" class="auto" size="15" id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%} %>
		cm
	</td>

	</tr>

</table>



<div class="Block">
<div class="clear"></div>


	<label class="auto">Any Evidence of Otitis Media</label>
	<% if(medExamObj.getFundAndMedia() != null){ %>
	<input tabindex="1" type="text" readonly="readonly" class="auto"  id="OtitisMedia"	name="OtitisMedia" value="<%=medExamObj.getFundAndMedia()%>"  maxlength="50"  />
	<%}else{ %>
	<input tabindex="1" type="text" readonly="readonly" class="auto" id="OtitisMedia"	name="OtitisMedia"  maxlength="50"  />

	<%} %>

</div>
</div>

<div class="clear paddingTop15"></div>
<h4>UPPER LIMBS AND LOCOMOTER SYSTEM <a	href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
<div class="clear"></div>
<label >Upper Limbs</label>
 <% if(medExamObj.getUpperLimbs() != null){ %>
 <input tabindex="1" type="text" readonly="readonly"  id="upperLimbs" name="upperLimbs" maxlength="20" value="<%=medExamObj.getUpperLimbs() %>"
	onKeyUp="limitText(this,20);" class="autoArial" size="29"  />

<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" id="upperLimbs" name="upperLimbs" maxlength="20" value="NAD"
	onKeyUp="limitText(this,20);" class="autoArial" size="29"  />
<%} %>



<label class=""> Locomotion</label>
<% if(medExamObj.getLocomotion() != null){ %>
<input tabindex="1" type="text" readonly="readonly" id="locomotion" name="locomotion" maxlength="20" value="<%=medExamObj.getLocomotion() %>"
	onKeyUp="limitText(this,20);" class="autoArial" size="29"  />
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" id="locomotion" name="locomotion" maxlength="20" value="NAD"
	onKeyUp="limitText(this,20);" class="autoArial" size="29"  />
<%} %>
<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>PHYSICAL DEVELOPMENT <a	href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Height</label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="date" readonly="readonly"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="height" readonly="readonly"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>

 <% }%>


<label	>Weight</label>
  <% if(medExamObj.getWeight()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getWeight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);"/><label class="unit">kg</label>

 <% }%>


</div>
</div>
<div class="clear paddingTop15"></div>
<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>

<label class=""> Chest Measurment</label>
<%if(medExamObj.getChestMeasurement() != null){ %>
<input type="text" name="chestMeasurment" class="auto" readonly="readonly" value="<%=medExamObj.getChestMeasurement() %>" />
<%}else{ %>
<input type="text" name="chestMeasurment" class="auto" value="" readonly="readonly" />
<%} %>


<label class=""> Full Expiration</label>
	<% if(medExamObj.getFullExpiration() != null){ %>
<input tabindex="1" type="text" readonly="readonly" id="fullExpiration" name="fullExpiration" maxlength="20" value="<%=medExamObj.getFullExpiration() %>"
	onKeyUp="limitText(this,20);" class="auto" size="15"  /><label class="unit">cm</label>
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" id="fullExpiration" name="fullExpiration" maxlength="20"
	onKeyUp="limitText(this,20);" class="auto" size="15"  /><label class="unit">cm</label>

<%} %>
	<label class="">Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="15" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5"
	onKeyUp="limitText(this,6);" class="auto" size="15"  /><label class="unit">cm</label>

 <% }%>
 <div class="clear"></div>
	<label class=""> Abnormalities</label>
	<% if(medExamObj.getAbnormalities() != null){ %>
	
	<input tabindex="1" type="text" readonly="readonly" id="abnormalities" name="abnormalities" maxlength="20" value="<%=medExamObj.getAbnormalities() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" id="abnormalities" name="abnormalities" maxlength="20"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
<%} %>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GENTIO URINARY SYSTEM<a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<h3> Urine</h3>



<label class=""> Albumen</label>
<% if(medExamObj.getAlbumin()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="albumin" name="<%=ALBUMIN %>" maxlength="20" value="<%=medExamObj.getAlbumin() %>"
	onKeyUp="limitText(this,6);" class="" size="15"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="albumin" name="<%=ALBUMIN %>" maxlength="20" value="NP"
	onKeyUp="limitText(this,6);"  class="" size="15" />

 <% }%>

<label class="auo"> Sugar</label>
<% if(medExamObj.getSugar()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="sugar" name="<%=SUGAR %>" maxlength="20" value="<%=medExamObj.getSugar() %>"
	onKeyUp="limitText(this,20);" class="" size="15"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="sugar" name="<%=SUGAR %>" maxlength="20" value="ND"	onKeyUp="limitText(this,20);"  class="" size="15" />

 <% }%>

<div class="clear"></div>

<label class=""> Other Abnormalities</label>
<% if(medExamObj.getAnyOtheAbnormalities()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="otherAbnormalities" name="otherAbnormalities" maxlength="20" value="<%=medExamObj.getAnyOtheAbnormalities() %>"
	onKeyUp="limitText(this,20);" class="" size="15"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="otherAbnormalities" name="otherAbnormalities" maxlength="20" value="Nil"	onKeyUp="limitText(this,20);"  class="" size="15" />

 <% }%>


<label class="auto"> Evidence of Skin/Veneral Disease(s)</label>
<% if(medExamObj.getAnyEvidenceOfSkin()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="anyEvidenceOfSkin" name="anyEvidenceOfSkin" maxlength="100" value="<%=medExamObj.getAnyEvidenceOfSkin() %>"
	onKeyUp="limitText(this,100);" class="autoArial" size="70"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  id="anyEvidenceOfSkin" name="anyEvidenceOfSkin" maxlength="100"  value="Nil"	onKeyUp="limitText(this,100);"  class="autoArial" size="70" />

 <% }%>

</div>
</div>

<div class="clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getPulseRates() %>"/><label class="unit">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="Normal" />
 <label class="unit">/min</label>
 <% }%>


 <label>BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getBp() %>"/><label class="unit">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="Normal" />
 <label class="unit">mm Hg</label>
 <% }%>

<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>
<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label >Central Nervous System</label>
<% if(medExamObj.getCentralNervousSystem()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="centralNervousSystem" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getCentralNervousSystem() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="centralNervousSystem" class="Auto" value="NAD" size="22" maxlength="20" />
 <% }%>
<label > Abdomen</label>
<% if(medExamObj.getAbdomen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="<%=ABDOMEN %>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getAbdomen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=ABDOMEN %>" class="Auto" size="22" maxlength="20" value="Soft,Non-Tender"/>
 <% }%>

<label > Liver</label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="liver" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getLiver() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="liver" class="Auto" size="22" maxlength="20" value="Not Palpable"/>
 <% }%>

<div class="clear"></div>
<label > Spleen</label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="spleen" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getSpleen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="spleen" class="Auto" size="22" maxlength="20" value="Not Palpable"/>
 <% }%>

<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="10" value="NAD"/>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" readonly="readonly" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" readonly="readonly" id="dentalValueId" value=""/>
<%} %>


<label>Total No. of Teeth</label>
<input type="text" name="totalTeeth" />

	<label class="auto">No. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text" readonly="readonly" name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text" readonly="readonly" name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />


 <% }else{%>
<input	tabindex="1" type="text" readonly="readonly" name="<%=CONDITION_OF_GUMS %>" value="Healthy"
	class="" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%>
<div class="clear"></div>
	</div>

</div>

<div class="clear paddingTop15"></div>
<%	int count=1;
String Labresult="NotPresent";
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" readonly="readonly" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />

<%count++;}
    }
%>
<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" readonly="readonly" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<h4>Investigations</h4>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Result</th>
		<th scope="col">View File</th>
		<!--<th scope="col">Add</th>
        <th scope="col">Delete</th>
		--></tr>

<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>
<%  }
if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<%
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% }
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<%
}else{%>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<% }
String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	List<String> firstKeyList=new ArrayList<String>();
	   List<Integer> firstValueList=new ArrayList<Integer>();
	   List<Integer> secondKeyList=new ArrayList<Integer>();
	   List<String> secondValueList=new ArrayList<String>();
	   List<String> thirdKeyList=new ArrayList<String>();
	   List<Integer> thirdValueList=new ArrayList<Integer>();
	   List<String> referToMHList=new ArrayList<String>();
		
	   int inc21=1;
	    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
	    {
	    	int cnt=0;
			String investigationName="";
	    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
	    	//first.put(investigationName,patientInvestigation.getChargeCode().getId());
	    	//third.put(investigationName,patientInvestigation.getId());
	    	firstKeyList.add(investigationName);
	    	firstValueList.add(patientInvestigation.getChargeCode().getId());
	    	thirdKeyList.add(investigationName);
	    	thirdValueList.add(patientInvestigation.getId());
	    	referToMHList.add(patientInvestigation.getReferToMh());
			   
	    	String val="";
	    	String val1="";
	    	String val2="";
	    	int investigationId=0;

	    	if(resultList.size()>0 && inc21<=resultList.size())
	    	{
	    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc21-1);
	    	int masInvestId=dgEH.getDgMasInvestigation().getId();
	    	//System.out.println("dgEH ===>"+masInvestId+" inc21===>"+(inc21-1));
	    	//System.out.println("patientInvestigation.getChargeCode().getId() ===>"+patientInvestigation.getChargeCode().getId()+" inc21===>"+(inc21-1));
			   
	    	if(patientInvestigation.getChargeCode().getId()==masInvestId)
	    	{	
	    
	    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
	    	{   
	    		if(dgre.getSubInvestigation()!=null)
	    		val1=dgre.getSubInvestigation().getSubInvestigationName();
	    	if(!dgre.getResultType().equalsIgnoreCase("t"))
    		{
	      	    ++cnt;
	    		if(dgre.getResult()!=null)
	    			val2=dgre.getResult();
	    
	    		if(cnt==1){
	    	    	val=" "+val1+":"+val2;
	    	    }else{
	    	    	val=" "+val+","+val1+":"+val2;
	    	    }
	    		 

    		}
	    	    investigationId=dgre.getInvestigation().getId();
	    		if(dgre.getResultType().equalsIgnoreCase("s"))
	    		{
	    		    	val=val.substring(2);
	    				resultid=0;
		
	    		}
	    		if(dgre.getResultType().equalsIgnoreCase("m"))
	    		{
	    			val=val.substring(1);
	    			resultid=0;
    	
	    		}
	    		if(dgre.getResultType().equalsIgnoreCase("t"))
	    		{

	    			resultid=dgre.getResultEntry().getId();
	    			template="template"+"/"+resultid;
	    			val=template;

	    		}
	    	}
	    	++inc21;
	    	}else
	    	{
	    		val=" ";
	    		investigationId=patientInvestigation.getChargeCode().getId();
	    	}
	    	}else{
	    		++inc21;
	    	}
	    	
	    	if(investigationId!=0)
	    	{	
	    		
	    		secondKeyList.add(investigationId);
	    		secondValueList.add(val);
	    	    
	    	}
	    	//if(investigationId!=0&&!second.containsKey(investigationId))
	    	//	second.put(investigationId,val);
	    	//++inc21;
	    	//
	    }
	    int i=0;
        
		 for(String firstKey:firstKeyList)
		 { 
		    %>
	<tr>
					<input type="hidden" value="<%=thirdValueList.get(i) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
						<td><input type="text" value="<%=firstKey%>" readonly="readonly"
							readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
							size="100" name="chargeCodeName<%=inc %>" />
				</td>
<%

if(secondValueList.size()>0)
	{
	  if(i<secondValueList.size())
	  {	  
		  Labresult="present";
	//String st=(String)second.get(first.get(key));
	String st=secondValueList.get(i);

	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{%>
	<td> <% 
	if(referToMHList.get(i)!=null){
	if(referToMHList.get(i).equalsIgnoreCase("y")){
		//System.out.println("referToMHList.get(i).equalsIgnoreCase(y) i ===>"+i);
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	 //  System.out.println("referToMHList.get(i).equalsIgnoreCase(n) i====>"+i);
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%}}else{ %>
 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>


<%} %> </td>
	<td><input type="text" value="<%=secondValueList.get(i)%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }else{

%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>

<%}}else
{  %>
	<td> <% if(referToMHList.get(i).equalsIgnoreCase("y")){
		//System.out.println("referToMHList.get(i).equalsIgnoreCase(y) i ===>"+i);
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	//   System.out.println("referToMHList.get(i).equalsIgnoreCase(n) i====>"+i);
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>		 </td>
		<td><input type="text" value="" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" />
	</td>
<%
}
	  }else{

	String investigationVal=firstKey;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>
		<td>
	<%
	if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts)
	{
	    int finalVal=Integer.parseInt(finalInvestVal);
	    if(dgOrderdt.getInvestigation().getId()==finalVal)
	    {
	    	if(dgOrderdt.getInvestigationToMH()!=null)
	    	{
	    	if(dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
	    	{

	    		%><input tabindex="1" type="checkbox"
	    			name="investigationReferToMH<%=inc %>" value="y" disabled="disabled" checked="checked" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>" readonly="readonly"
			 name="Result<%=inc %>" />
</td>
<% 	    	}else
            { %>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n" disabled="disabled"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
            <%

             }
	    	}else
	    	{%>
	    		<input tabindex="1" type="checkbox"
	    			name="investigationReferToMH<%=inc %>" value="n" disabled="disabled" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
        </td>
	    <%	}
	    }
	}}else{
	%>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n" disabled="disabled" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
</td>


<%  }%>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="VIEW REPORT" style="display: none;"  onClick="javascript:jsViewDocument(<%=inc %>);" />
</td>

<!--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
	-->
	</tr>

	<% inc++;i++;
		    }

%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text" value="" tabindex="1" readonly="readonly"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');,'parent'}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td><td>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" />
</td>
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<!--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>


	--></tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />


<% }%>


</table>

<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="clear paddingTop15"></div>
<h4>MENTAL CAPACITY AND EMOTIONAL STABILITY <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Speech</label>
<% if(medExamObj.getSpeech()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="<%=SPEECH %>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getSpeech() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=SPEECH %>" class="Auto" size="22" maxlength="20" value="Normal"/>
 <% }%>
<h4 >Evidence Suggesting</h4>

<label >Mental Retardation</label>
<% if(medExamObj.getMentalInstability()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="mentalInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getMentalInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="mentalInstability" class="Auto" size="22" maxlength="20" value="Nil"/>
 <% }%>

<div class="clear"></div>

<label >Emotional Stability</label>
<% if(medExamObj.getEssentialInstability()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" name="essentialInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getEssentialInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="essentialInstability" class="Auto" size="22" maxlength="20" value="Nil"/>
 <% }%>

<div class="clear"></div>
</div>
<div class="Clear paddingTop15"></div>
<h4>IMMUNIZATION STATUS <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="Block">

<input tabindex="1" name="Button"	type="button" class="button" value="Immunization"	onClick="javascript:openPopupForImmunization();" />
</div>
<div class="Clear paddingTop15"></div>
<h4>LIFE STYLE FACTORS <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="Block">
<div class="clear"></div>
<label>Alcohol</label>
<select name="drinker" tabindex="1" id="drinker" disabled="disabled">
<option value="Non-Drinker" selected="selected">Non-Drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select>
<script>
<%
if(medExamObj.getDrinker()!= null){
%>
document.getElementById("drinker").value='<%=medExamObj.getDrinker()%>';

<%}%>
</script>
<label >Smoker</label>
<%if(visit.getHin().getSmokerLess10().equalsIgnoreCase("y") && visit.getHin().getSmokerLess10()!= null){ %>
<label class="auto"><10</label><input type="checkbox" name="smokerLess10" class="radioAuto2"  checked="checked"/>
<%}else{ %>
<label class="auto"><10</label><input type="checkbox" name="smokerLess10" class="radioAuto2" />

<%} %>
<input class="transparent" size="2" />
<%if(visit.getHin().getSmokerMore10().equalsIgnoreCase("y") && visit.getHin().getSmokerMore10()!= null){ %>
<label class="auto">>10</label><input type="checkbox" name="smokerMore10" class="radioAuto2"  checked="checked"/>
<%}else{ %>
<label class="auto">>10</label><input type="checkbox" name="smokerMore10" class="radioAuto2"  />
<%} %>

<%--


<select name="smoker" tabindex="1" id="smoker" disabled="disabled">
<option value="Non-Smoker" selected="selected">Non-Smoker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select>

 --%>

<script>
<%
if(medExamObj.getSmoker()!= null){
%>
document.getElementById("smoker").value='<%=medExamObj.getSmoker()%>';

<%}%>
</script>
<div class="clear"></div>

<label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="60" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="60" id="allergies" size="92" />
<%} %>
</div>
<div class="clear paddingTop15"></div>

<h4>FINAL OBSERVATION AND MEDICAL CATEGORY <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="Block">
<div class="clear"></div>
<label class="large">Slight Defects Not Sufficient to Cause Rejection</label>
<% if(medExamObj.getDefectNotToCauseRejection()!=null){%>
<textarea rows="" cols="35" disabled="disabled" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" 
onkeyup="chkLength(this,200);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" 
		 tabindex="1"><%=medExamObj.getDefectNotToCauseRejection() %></textarea>
   <% }else{%>
<textarea rows="" cols="35" disabled="disabled" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" 
onkeyup="chkLength(this,200);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" 
		 tabindex="1"></textarea>
 <% }%>

<div class="clear"></div>

<label class="large">Found Fit In Category</label>
<% if(medExamObj.getFoundFitInCategory()!=null){%>
<textarea rows="" cols="35" disabled="disabled" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" 
onkeyup="chkLength(this,200);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" 
		 tabindex="1"><%=medExamObj.getFoundFitInCategory() %></textarea>
   <% }else{%>
<textarea rows="" cols="35" disabled="disabled" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" 
onkeyup="chkLength(this,200);"	onpaste="return checkOnPaste(this)"	
	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" 
		 tabindex="1"></textarea>
 <% }%>


 <div class="clear"></div>

<label class="">Admission</label>
<%if(medExamObj.getAdmissionStatus()!=null)
{
if(medExamObj.getAdmissionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="admissionStatus" value="y" class="radioAuto" id="admissionStatus" checked="checked" />
<%}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus"  />
<%}}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus"  />
	<%} %>
<label class="auto">Specialist opinion</label>
<%if(medExamObj.getSpecialistOpinnionStatus()!=null)
{
if(medExamObj.getSpecialistOpinnionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="y" checked="checked" class="radioAuto" id="specialistOpinion"  />
<input name="Send" type="button"  class="button" value="VIEW" onClick="javascript:fileViewForSpecialistOpinion();" />

<%}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion"  />
<%}}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion"  />
<%} %>



<div class="clear"></div>
<%
String signedBy = "";
if(medExamObj.getSignedBy()!= null)
 {
	signedBy = medExamObj.getSignedBy();
 }
%>

<label >Signed By</label>
<input tabindex="1" type="text" disabled="disabled" id="signidBy" name="<%= SIGNED_BY %>"  size="20" maxlength="100" value="<%=signedBy %>" readonly="readonly" validate="Signed By,string,no"/>
<label >Remarks</label>
<% if(medExamObj.getRemarks()!=null){%>
<input tabindex="1" type="text"  maxlength="50" readonly="readonly" id="remarks"	name="<%=MEDICIN_REMARKS %>" class="Auto" size="20"  value="<%=medExamObj.getRemarks() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  maxlength="50" id="remarks" readonly="readonly"	name="<%=MEDICIN_REMARKS %>" class="Auto" size="20"  value=""/>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION BY APPROVING AUTHORITY</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getAprovAuthFinalObservation()!=null){%>
<input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value="<%=medExamObj.getAprovAuthFinalObservation() %>"  size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value=""  size="20" maxlength="100" />

  <% }%>
  <label >Remarks</label>
  <% if(medExamObj.getApprovAuthRemarks()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="aaRemarks" name="aaRemarks" value="<%=medExamObj.getApprovAuthRemarks() %>" size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" id="aaRemarks" name="aaRemarks" value="" size="20" maxlength="100" />

  <% }%>


<label >Signed By</label>
<% if(medExamObj.getApprovAuthSignedBy()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value="<%=medExamObj.getApprovAuthSignedBy() %>"  readonly="readonly"/>
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value=""  readonly="readonly"/>

  <% }%> </div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION BY PERUSING AUTHORITY</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<input tabindex="1" type="text" name="paFinalObservation"  size="20" maxlength="100" />
<label >Remarks</label>
 <% if(medExamObj.getPerAuthRemarks()!=null){%>
<input tabindex="1" type="text" id="paRemarks" name="paRemarks" value="<%=medExamObj.getPerAuthRemarks() %>" size="20" maxlength="100" />
<% }else{%>
<input tabindex="1" type="text" id="paRemarks" name="paRemarks" value="" size="20" maxlength="100" />

  <% }%>

<label >Signed By</label>
<input tabindex="1" type="text" name="paSignedBy" readonly="readonly" size="20" maxlength="100" value="<%=signedByAA %>"/>

</div>

<div class="clear"></div>
<div class="division"></div>

<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalExamPrimaryExtnPA','medicalExam?method=validateMedExamPersusingAuthority');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="if(checkRemarksPA()){submitForm('medicalExamPrimaryExtnPA','medicalExam?method=rejectMedExamPA');}" />
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=RESET name=Reset>

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
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>
<%if(medExamObj.getDateOfReporting()!=null)
{%>
	 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" />

<% }else{%>
	 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<% }%>

<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
	function generateRowMdicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");

		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		tblCtrl[0].value=d.length-2;
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";


		}
	function openPopupForImmunization(){
		 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','windowRef','width=1000,height=400,scrollbars = yes');
	}

	function openPopupForAllergies(){
		 newwindow = window.open('/hms/hms/registration?method=openPopupForAllergies&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','allergy','width=1000,height=400,scrollbars = yes');
	}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >1){

	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	}
    	</script> <script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {

        limitField.value = limitField.value.substring(0, limitNum);

    }
}
function fileUploadWindowInvestigation(rowVal)
{
	var medicalExamId='<%=medExamId%>';
 	if(medicalExamId=='0')
 	{
 	 	alert("file can not be uploaded; refferred to MH");
 	 	return false;
 	}else{
 		var val=document.getElementById('chargeCodeName'+rowVal).value;
 	 	var index1 = val.lastIndexOf("[");
 	 	var index2 = val.lastIndexOf("]");
 	 	index1++;

 	var invest_id = val.substring(index1,index2);
 		var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo=<%=visit.getHin().getHinNo() %>&invest_id="+invest_id+"&masExamId=<%=medExamId%>";
 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
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
function fileViewForSpecialistOpinion()
{
 	
	  var url="/hms/hms/medicalExam?method=viewUploadDocumentsDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&masExam_Id=<%=medExamObj.getId()%>&folderName=specialistOpinion";

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
}
function checkRemarksPA()
{
		var remarks=document.getElementById('paRemarks').value;
		if(remarks=='')
		{
		  alert("Please Enter the Perusing Authority Remarks");
		   return false;
		}
		return true;
}

function isAlpha(argvalue) {
argvalue = argvalue.toString();
var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (var n = 0; n < argvalue.length; n++) {
if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
return false;
}
return true;
}

function CheckAlpha()
{

    var txt=document.getElementById('txtAlpha');
    var filter=/^[a-zA-Z]+$/;
    var test_bool = filter.test(txt.value);
    if (test_bool==false)
    {
        alert('Please Enter Only Alphabets');
        txt.focus();
        return false;
    }
}


</script> <script language="JavaScript" type="text/JavaScript">
function isNumber(field) {
        var re = /^[0-9-'.'-',']*$/;
        if (!re.test(field.value)) {
            alert('please enter only numeric data');
            field.value = field.value.replace(/[^0-9-'.'-',']/g,"");
        }

    }


</script> <script language="JavaScript" type="text/javascript">

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
  function jsViewDocument(rowVal)
  {

  		var val=document.getElementById('chargeCodeName'+rowVal).value;
  	  	//alert("val====>"+val)
  	  	var index1 = val.lastIndexOf("[");
  	  	var index2 = val.lastIndexOf("]");
  	  	index1++;
  	  	var invest_id = val.substring(index1,index2);
  	   var url='/hms/hms/medicalExam?method=viewUploadDocumentsInvestigationDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&invest_id='+invest_id+'&masExam_Id=<%=medExamObj.getId()%>';
  	   	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
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
  function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
  function showHideInvestigationTemplateCombo(valueOfTemplate){

		if(checkTemplateId(valueOfTemplate)){

		 // 	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';

				submitProtoAjaxWithDivName('medicalExamPrimaryExtnPA','/hms/hms/opd?method=showGridForInvestigation','gridview');

				}

	}

  function checkTemplateId(templateId){

      if(templateId=="0"){
        return true;
      }else{
        return true;
      }
    }


function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
	}

 function openPopupForPatientInvestigation(visitNo,hinId){
	  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
}
 function showCreateInvestigationTemplate(){

     document.getElementById("investigationImportButton1").style.display='inline'
   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");

}
 function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('medicalExamPrimaryExtnPA','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}

 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalExamPrimaryExtnPA','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}
	 }
 function submitdata()
	{

		var charge=document.getElementById("chargeCodeName1").value;
  if(charge=="")
  {
   alert("Please Select Test Name");
  }else{
  	submitForm('medicalExamPrimaryExtnPA','medicalExam?method=addMedicalExaminationBoardAnnual2A');
  }
	}
 function checkForInvestigationMH(inc)
 {
    if(document.getElementById('investigationReferToMH'+inc).checked==true)
    {
        document.getElementById('investigationReferToMH'+inc).value='y';
        document.getElementById('Result'+inc).readOnly=false;
        document.getElementById("uploadReport"+inc).style.display='inline';

    } else
    {
    	document.getElementById('investigationReferToMH'+inc).value='n';
    	 document.getElementById('Result'+inc).readOnly=true;
         document.getElementById("uploadReport"+inc).style.display='none';
    }
 }
 function chkValue(Obj)
 	{
 		var newdentalValue="";
 		var duplicate = new Boolean(false)
 		var dstr=document.getElementById('dentalValueId').value;
 		 var mySplitResult = dstr.split(",");
 		 for(i=1;i<mySplitResult.length;i++)
 		 {
 			 if(mySplitResult[i]==Obj.id)
 			 {
 				 duplicate=true;
 			 }else{
 				 newdentalValue=newdentalValue+","+mySplitResult[i];
 			 }
 		 }
 		 if(duplicate==false)
 		 {
 		dstr=dstr+","+Obj.id;
 		document.getElementById('dentalValueId').value = dstr;
 		 }else{
 				document.getElementById('dentalValueId').value = newdentalValue;
 		 }

 	}
 function checkRemarksAA()
 {
 		var remarks=document.getElementById('aaRemarks').value;
 		if(remarks=='')
 		{
 		  alert("Please Enter the Approving Authority Remarks");
 		   return false;
 		}
 		return true;
 }
  function coolDental()
 	{
 	 var dentalValue=document.getElementById('dentalValueId').value;

 	 var mySplitResult = dentalValue.split(",");
 	 for(i=1;i<mySplitResult.length;i++)
 	 {
 		 document.getElementById(mySplitResult[i]).checked="checked";
 		messingTeeth(mySplitResult[i]);
 	 }

 	}


  function messingTeeth(mm)
  {
  	//alert("hi--");
  	var name=document.getElementById(mm).name;
  	//alert("hi--"+name[0]);
  	var mval=document.getElementById('MissTeeth').value;
  	var uval=document.getElementById('UnserTeeth').value;
  	if(name[0]=='m')
  	{
  		//alert("val m--"+mval);
  		//alert("val-length m-"+name.length);
  		//alert("val-sub111 m-"+name.substring(1,name.length));
  		mval=mval+" "+name.substring(1,name.length).toUpperCase();
  		//alert("val m--"+mval);
  		document.getElementById('MissTeeth').value=mval;
  	}
  	if(name[0]=='u')
  	{
  		//alert("val u--"+uval);
  		//alert("val-length u-"+name.length);
  		//alert("val-sub111 u-"+name.substring(1,name.length));
  		uval=uval+" "+name.substring(1,name.length).toUpperCase();
  		//alert("val u--"+uval);
  		document.getElementById('UnserTeeth').value=uval;
  	}
  }
  function openPopupPatientPreviousVisit()
  {
  	var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
     	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function getPrevMedBoardFromHIC()
  {
  	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function getPrevMedExamFromHIC()
  {
  	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function showPatientPreVisitHospitality()
  {
  	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function openTemplateScreen(index){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
	    //submitForm('medicalBoardMAForm16','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
	     var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
	    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	 }
</script></form>
</body>