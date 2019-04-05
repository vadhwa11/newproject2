
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
	<!-- -
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
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
		String time = (String) utilMap.get("currentTimeWithoutSc");
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
	String Labresult="NotPresent";

	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}

	List<Visit> meVisitList = new ArrayList<Visit>();

	if(map.get("meVisitList") != null){
		meVisitList=(List)map.get("meVisitList");

		}
	Visit visit=null;
	if(meVisitList!=null && meVisitList.size()>0)
	{
	 visit=(Visit)meVisitList.get(0);
	}
	List<MasMedicalExaminationReportOnEntry> existingMedExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if(map.get("existingMedExamList") != null){
		existingMedExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("existingMedExamList");
	}
	MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

	if(existingMedExamList.size() > 0){
		medExamObj = existingMedExamList.get(0);
	}

	String url="";
	if(map.get("url") != null){
		url = (String)map.get("url");
	}
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
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
List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
if(map.get("opdDentalDetailsList") != null){
	opdDentalDetailsList=(List<OpdPatientDetails>)map.get("opdDentalDetailsList");
}
OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
if(opdDentalDetailsList.size() > 0){
	opdPatientDetails = opdDentalDetailsList.get(0);
}
List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
if(map.get("doctorList")!=null)
{
	doctorList=(List<MasEmployee>)map.get("doctorList");
}
%>

<div>
<%--
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtn','opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('medicalExamPrimaryExtn','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
 --%>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" 
onclick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>

<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-2A</h2></div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalExamPrimaryExtn" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){

	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>" id="medExamId" validate="medExamId,metachar,no" />
<div class="Block">
<label>Authority</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text"  id="" name="<%=AUTHORITY_OF_BOARD %>"  value="<%=medExamObj.getAuthority() %>"
	onKeyUp="limitText(this,100);"  maxlength="15" validate="Authority of board,metacharSpacBrac,no" />
 <% }else{%>
<input tabindex="1" type="text"  id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="15" value="IAP 4303 (4th Ed)"	onKeyUp="limitText(this,100);" validate="Authority of board,metacharSpacBrac,no" />
 <% }%>

<label>Service No. </label>
<%
if(visit.getMedExamType() !=null){ %>
 <input type="hidden"	value="<%=visit.getMedExamType() %>" name="medicalExamType" validate="medicalExamType,examType,no"/>
 <%} %>
 <%if(visit.getReportingFor() !=null){ %>
<input type="hidden" name="ReportingForExamBoard" value="<%=visit.getReportingFor()%>" readonly="readonly" validate="ReportingForExamBoard,metacharSpac,no"/><%} %>
 <input type="text"	value="<%= visit.getHin().getServiceNo() %>" name="<%=SERVICE_NO %>" id="serviceNo" tabindex="1" readonly="readonly" validate="serviceNo,metachar,no" />
 <input type="hidden"	value="<%= visit.getId() %>" name="<%=VISIT_ID %>" id="visitId"  validate="visitId,metachar,no"   />
 <input type="hidden"	value="<%= visit.getHin().getId() %>" name="<%=HIN_ID %>" id="hinId"  validate="HIN_ID,metachar,no"  />
 <input name="token" type="hidden" id="token" value="<%=visit.getTokenNo()%>" validate="token,metachar,no" />
  <label>Rank  </label>
  <input type="text" readonly="readonly" value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>"	tabindex="1" maxlength="20" validate="Rank,metacharSpacBrac,no" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	maxlength="20" validate="Rank_id,metachar,no"  />

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
 <input	type="text" readonly="readonly" value="<%= name %>" name="<%=FULL_NAME%>"	tabindex="1" maxlength="20"  validate="Name,metacharSpac,no"/>
  <label>Father's Name  </label>
  <%
  	if(medExamObj.getFatherName() != null){
  %>
   <input type="text" value="<%= medExamObj.getFatherName() %>" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="30" validate="Father's Name ,metacharSpac,no"/>
  <%}else{ %>
 <input	type="text" value="" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="30" validate="Father's Name ,metacharSpac,no"/>
 <%} %>
 <label>DOB</label>
 <%
 if(visit.getHin().getDateOfBirth() != null){
 %>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" validate="DOB,date,no"/>

	<%}else{ %>
<input tabindex="1" name="<%=DATE_OF_BIRTH %>"  value=""  maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="DOB,date,no"/>

	<%} %>
	  <div class="clear"></div>
 <label>Age  </label>
 <input	type="text" value="<%= visit.getAge() %>" name="<%=AGE%>"	maxlength="20" tabindex="1" readonly="readonly"  validate="Age,metacharSpac,no" />
  <label>Apparent Age  </label>
  <%
  if(medExamObj.getApparentAge() != null){
  %>
 <input	type="text" value="<%=medExamObj.getApparentAge() %>" name="apparentAge"	maxlength="9" tabindex="1" validate="apparentAge,metacharSpac,no" />
 <%}else{ %>
 <input	type="text" value="" name="apparentAge"	maxlength="9" tabindex="1" />

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
  <input type="hidden" value="<%= unitId %>" name="<%=UNIT_ID%>" maxlength="20" validate="UNIT_ID,metachar,no"/>

 <label>Branch/Trade  </label>
 <%
 String tradeName = "";
float serviceYear = 0f;
String servicePeriod ="";
 int tradeId = 0;
 	if( visit.getHin().getTrade() != null){
 		tradeName =  visit.getHin().getTrade().getTradeName();
 		tradeId = visit.getHin().getTrade().getId() ;
 	}
 	if(visit.getHin().getServiceYears()!= null )
 	  {
 		serviceYear = visit.getHin().getServiceYears();
 	  }
 	if(visit.getHin().getTotalServicePeriod()!= null)
 	  {
 		servicePeriod = visit.getHin().getTotalServicePeriod();
 	  }
 	
 %>
 <input	type="text" readonly="readonly" value="<%= tradeName %>" name="<%=TRADE%>"	tabindex="1" maxlength="20" />
 <input	type="hidden" value="<%=tradeId %>" name="<%=TRADE_ID%>" maxlength="20" />
 <label>Total Service  </label>
 <input	type="text" readonly="readonly" value="<%= serviceYear+" "+servicePeriod%>" name="<%=TOTAL_SERVICE%>"	tabindex="2" maxlength="20" />
   <div class="clear"></div>

  <label>Permanent Address  </label>
   <%
  	if(visit.getHin().getPermanentAddress() != null){
  %>
   <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"
   onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" validate="PERMANENT_ADDRESS,matacharSpac,no" ><%=visit.getHin().getPermanentAddress() %></textarea>
  <%}else{ %>
 <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"
 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" validate="PERMANENT_ADDRESS,matacharSpac,no" ></textarea>
 <%} %>

 <label>Past Medical History  </label>
 <%
  if(medExamObj.getPastmedicalhistory() != null){
  %>
 <input	type="text" value="<%= medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100" readonly="readonly" validate="Past Medical History,metachar,no" />
 <%}else{ %>
  <input	type="text" value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100" readonly="readonly" validate="Past Medical History,metachar,no" />
 <%} %>
 <label>Relevant Family History </label>
 <%
 if(medExamObj.getRelevantFamilyHistory() != null){
 %>
  <input	type="text" value="<%=  medExamObj.getRelevantFamilyHistory() %>" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100" validate="Relevant Family History,metachar,no"/>
 <%}else{ %>
 <input	type="text" value="" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100" validate="Relevant Family History,metachar,no" />
 <%} %>

   <div class="clear"></div>

<label >Identification Marks</label>
 <% if(visit.getHin().getSrIdentificationMark1()!=null){%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>" value="<%=visit.getHin().getSrIdentificationMark1() %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  validate="Identification Marks1,metacharSpac,no" />

 <% }else{%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>"
	onKeyUp="limitText(this,50);" class="auto" size="72" validate="Identification Marks1,metacharSpac,no" />

 <% }%>
<div class="clear"></div>
<input class="transparent" size="28">
<% if(visit.getHin().getSrIdentificationMark2()!=null){%>
<label class="valueAuto">2.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS2 %>" value="<%=visit.getHin().getSrIdentificationMark2() %>"
	onKeyUp="limitText(this,50);" class="auto" size="72" validate="Identification Marks2,metacharSpac,no"/>

 <% }else{%>
<label class="valueAuto">2.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS2 %>"
	onKeyUp="limitText(this,50);" class="auto" size="72" validate="Identification Marks2,metacharSpac,no" />

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
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWthoutGlassesRDistant()%>" validate="DistantVision_Without Glasses_R,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" validate="DistantVision_Without Glasses_R,alphanumericSlash,no"/>
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLDistant()%>" validate="DistantVision_Without Glasses_L,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text"	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" validate="DistantVision_Without Glasses_L,alphanumericSlash,no" />
 <% }%>
 </td>

<td>Without Glasses</td>
	<td width="10%">
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesRNearvision()%>" validate="NearVision_Without Glasses_R,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" validate="NearVision_Without Glasses_R,alphanumericSlash,no"/>
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLNearvision()%>" validate="NearVision_Without Glasses_L,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" validate="NearVision_Without Glasses_L,alphanumericSlash,no"/>
 <% }%>
 </td>
 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>" validate="NearVision_Without Glasses_CP,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" validate="NearVision_Without Glasses_CP,alphanumericSlash,no"/>
 <% }%>
 </td>
	</tr>
	<tr>
	<td>With Glasses</td>
	<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRDistant()%>" validate="DistanVision_With_Glasses_R,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" validate="DistanVision_With_Glasses_R,alphanumericSlash,no"/>
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLDistant()%>" validate="DistanVision_With_Glasses_L,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" validate="DistanVision_With_Glasses_L,alphanumericSlash,no"/>
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRNearvision()%>" validate="NearVision_With_Glasses_R,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" validate="NearVision_With_Glasses_R,alphanumericSlash,no"/>
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLNearvision()%>" validate="NearVision_With_Glasses_L,alphanumericSlash,no"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" validate="NearVision_With_Glasses_L,alphanumericSlash,no"/>
 <% }%>
 </td>

	</tr>
</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Any evidence of trachoma and its complications or any other disease</label>
<% if(medExamObj.getEvidenceOfTrachoma()!=null){%>
	<input tabindex="1" type="text" name="<%=ANY_EVIDENCE_OF_TRACHOMA %>"
	 value="<%=medExamObj.getEvidenceOfTrachoma() %>"class="large" maxlength="30" Validate="evidence of trachoma,metacharSpac,no"/>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" value=""class="large" maxlength="30" Validate="evidence of trachoma,metacharSpac,no"/>
 <% }%>
<div class="clear"></div>
<label class="large2">Binocular vision & Grade</label>
<% if(medExamObj.getBinocularVisionGrade()!=null){%>
<input tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>"
	 value="<%=medExamObj.getBinocularVisionGrade() %>"class="large" maxlength="30" Validate="Binocular vision & Grade,metacharSpac,no"/> <% }else{%>
<input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>"	class="large" maxlength="30" Validate="Binocular vision & Grade,metacharSpac,no" />
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
		<input tabindex="1" type="text" id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" class="auto" size="10"/>
		<%}else{ %>
		<input tabindex="1" type="text" value="600"  class="auto" size="10" id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>cm
	</td>


	<td>
		<% if(medExamObj.getEarHearingLfw() != null){ %>
		<input tabindex="1"value="<%=medExamObj.getEarHearingLfw()  %>" type="text" class="auto" size="10"  id="hlfw" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" value="600" type="text" class="auto" size="10" id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>	cm
	</td>

	<td>
		<% if(medExamObj.getEarHearingBothFw() != null){ %>
		<input tabindex="1" value="<%=medExamObj.getEarHearingBothFw()  %>" type="text" maxlength="20" class="auto" size="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" value="600" type="text" maxlength="20" class="auto" size="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>	cm
	</td>
	</tr>


	</table>


<div class="Block">
<div class="clear"></div>


	<label class="auto">Any Evidence of Otitis Media</label>
	<% if(medExamObj.getFundAndMedia() != null){ %>
	<input tabindex="1" type="text"  class=""  id="OtitisMedia"	name="OtitisMedia" value="<%=medExamObj.getFundAndMedia()%>"  maxlength="30" Validate="Any Evidence of Otitis Media,metacharSpac,no" />
<%}else{ %>
		<input tabindex="1" type="text"  class="" id="OtitisMedia"	name="OtitisMedia"  maxlength="30"  Validate="Any Evidence of Otitis Media,metacharSpac,no" />
	<%} %>

</div>
</div>

<div class="clear paddingTop15"></div>

<h4>PHYSICAL DEVELOPMENT <a	href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Height </label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>
 <% }%>

<label	>Weight<br/></label>
  <% if(medExamObj.getWeight()!=null){%>
<input tabindex="1" type="text"   id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getWeight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);"/><label class="unit">kg</label>
 <% }%>
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<%--
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>

	<label class="auto">No of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />
 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />
 <% }%>

	 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="10" validate="Condition Of Gums,Alphabetic,Yes" />
 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="small" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="10" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%>
<div class="clear"></div>
	</div>--%>
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%> <input type="hidden"
	name="dentalValue" id="dentalValueId"
	value="<%=medExamObj.getDentalValue()%>" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getDentalValue()!=null){%>
 <input type="hidden"
	name="dentalValue" id="dentalValueId"
		value="<%=opdPatientDetails.getDentalValue()%>" validate="dentalValue,metachar,no" /> 
<% }else{%> 
<input	type="hidden" name="dentalValue" id="dentalValueId" value=""  validate="dentalValue,metachar,no"/>
 <%} %> 
	
<label>Total No. of Teeth</label> 
<% if(medExamObj.getTotalTeeth()!=null){%> 
<input
	tabindex="1" type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	value="<%=medExamObj.getTotalTeeth() %>" onKeyUp="isNumber(this)"
	maxlength="2" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfTeeth()!=null){
	 %>
	 <input	tabindex="1" type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small" readonly="readonly"
	 	value="<%=opdPatientDetails.getNoOfTeeth() %>" onKeyUp="isNumber(this)"
	 	maxlength="2" /> 
	 <%}else{%> <input tabindex="1" type="text"
	name="<%=TOTAL_NO_OF_TEETH %>" class="small" onKeyUp="isNumber(this)"
	maxlength="2" /> 
<% }%> 

<label class="medium3">Total No. of Defective Teeth</label> 
<% if(medExamObj.getTotalDefectiveTeeth()!=null){%> 
<input
	tabindex="1" type="text" name="<%=DEFECTIVE_TEETH %>" class="small"
	value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfDefectiveTeeth()!=null){%> 
<input	tabindex="1" type="text" name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly"
	value="<%=opdPatientDetails.getNoOfDefectiveTeeth()%>"
	onKeyUp="isNumber(this)" maxlength="2" /> 
<% }else{%> 
<input	tabindex="1" type="text" name="<%=DEFECTIVE_TEETH %>" class="small" 
	onKeyUp="isNumber(this)" maxlength="2" />
 <% }%> 
 
<label class="medium3">Total No. of Dental Points</label> 
<% if(medExamObj.getDenstlPoint()!=null){%> 
<input	tabindex="1" type="text" name="<%=DENTSL_POINT %>"
	value="<%=medExamObj.getDenstlPoint() %>" onKeyUp="isNumber(this);" 
	maxlength="2" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfDentalPoints()!=null){%> 
<input	tabindex="1" type="text" name="<%=DENTSL_POINT %>"
	value="<%=opdPatientDetails.getNoOfDentalPoints() %>" onKeyUp="isNumber(this);" readonly="readonly"
	maxlength="2" /> 
<% }else{%> 
<input tabindex="1" type="text"
	name="<%=DENTSL_POINT %>" onKeyUp="isNumber(this);" maxlength="2"  />
 <% }%>

<div class="clear"></div>

<label>Missing </label> <% if(medExamObj.getMissingTeeth()!=null){%> <input
	tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small"
	onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getMissingTeeth()!=null){%> 
<input	tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this);" value="<%=opdPatientDetails.getMissingTeeth() %>"
	maxlength="2" />
<% }else{%> <input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" /> 
<% }%> 
<label class="medium3">Unsaveable</label> 
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	value="<%=medExamObj.getUnservisableTeeth() %>" class="small" 
	onKeyUp="isNumber(this);" maxlength="2" /> 
<% }else  if(opdPatientDetails!=null && opdPatientDetails.getUnSaveableTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	value="<%=opdPatientDetails.getUnSaveableTeeth() %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" /> 
<% }else{%> <input
	tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />
 <% }%>
 
 <label class="medium3">Condition of Gums</label> 
 <% if(medExamObj.getConditionOfGums()!=null){%>
<input tabindex="1" type="text" name="<%=CONDITION_OF_GUMS %>"
	value="<%=medExamObj.getConditionOfGums() %>"
	onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100" 
	validate="Condition Of Gums,Alphabetic,Yes" /> 
<% }else if(opdPatientDetails!=null && opdPatientDetails.getConditionOfGums()!=null){%>
<input tabindex="1" type="text" name="<%=CONDITION_OF_GUMS %>"
	value="<%=opdPatientDetails.getConditionOfGums() %>"
	onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100" readonly="readonly"
	validate="Condition Of Gums,Alphabetic,Yes" /> 
<% }else{%> 
<input	tabindex="1" type="text" name="<%=CONDITION_OF_GUMS %>"
	onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100" 
	validate="Condition Of Gums,Alphabetic,Yes" value="Healthy" /> 
<% }%>
<div class="clear"></div>
<h4>Missing Teeth</h4>
<div class="clear"></div>
<label>UR</label> <input tabindex="1" type="checkbox" name="<%=MUR_8%>"
	value="" class="radioAuto" id="d1" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_6%>" value=""
	class="radioAuto" id="d3" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_4%>" value=""
	class="radioAuto" id="d5" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_2%>" value=""
	class="radioAuto" id="d7" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>UL</label> <input tabindex="1" type="checkbox" name="<%=MUL_8%>"
	value="" class="radioAuto" id="d9" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_6%>" value=""
	class="radioAuto" id="d11" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_4%>" value=""
	class="radioAuto" id="d13" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_2%>" value=""
	class="radioAuto" id="d15" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LR</label> <input tabindex="1" type="checkbox" name="<%=MLR_8%>"
	value="" class="radioAuto" id="d17" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_6%>" value=""
	class="radioAuto" id="d19" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_4%>" value=""
	class="radioAuto" id="d21" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_2%>" value=""
	class="radioAuto" id="d23" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label class=>LL</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25"
	onclick="chkValue(this);" /> <label class="smallAuto">8</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_7%>" value=""
	class="radioAuto" id="d26" onclick="chkValue(this);" /> <label
	class="smallAuto">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27"
	onclick="chkValue(this);" /> <label class="smallAuto">6</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_5%>" value=""
	class="radioAuto" id="d28" onclick="chkValue(this);" /> <label
	class="smallAuto">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29"
	onclick="chkValue(this);" /> <label class="smallAuto">4</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_3%>" value=""
	class="radioAuto" id="d30" onclick="chkValue(this);" /> <label
	class="smallAuto">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31"
	onclick="chkValue(this);" /> <label class="smallAuto">2</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_1%>" value=""
	class="radioAuto" id="d32" onclick="chkValue(this);" /> <label
	class="smallAuto">1</label>
<div class="clear"></div>

<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label>UR</label> <input tabindex="1" type="checkbox" name="<%=UUR_8%>"
	value="" class="radioAuto" id="d33" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_6%>" value=""
	class="radioAuto" id="d35" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_4%>" value=""
	class="radioAuto" id="d37" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_2%>" value=""
	class="radioAuto" id="d39" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>
<div class="clear"></div>

<div class="clear"></div>
<label>UL</label> <input tabindex="1" type="checkbox" name="<%=UUL_8%>"
	value="" class="radioAuto" id="d41" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_6%>" value=""
	class="radioAuto" id="d43" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_4%>" value=""
	class="radioAuto" id="d45" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_2%>" value=""
	class="radioAuto" id="d47" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LR</label> <input tabindex="1" type="checkbox" name="<%=ULR_8%>"
	value="" class="radioAuto" id="d49" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_6%>" value=""
	class="radioAuto" id="d51" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_4%>" value=""
	class="radioAuto" id="d53" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_2%>" value=""
	class="radioAuto" id="d55" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LL</label> <input tabindex="1" type="checkbox" name="<%=ULL_8%>"
	value="" class="radioAuto" id="d57" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_6%>" value=""
	class="radioAuto" id="d59" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_4%>" value=""
	class="radioAuto" id="d61" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_2%>" value=""
	class="radioAuto" id="d63" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>
<div class="clear"></div>
<label> Remarks</label> 
<% 
if(medExamObj.getRemarksTeath()!=null){%> 
<textarea rows="" cols="60"
	name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,299);"
		onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" 
	value="<%=medExamObj.getRemarksTeath() %>" ><%=medExamObj.getRemarksTeath() %></textarea>

<% }else if(opdPatientDetails!=null && opdPatientDetails.getMissingTeethRemark()!=null){%> 
<textarea rows="" cols="60" maxlength="299"	name="<%=DENTAL_REMARKS %>" class="auto"  readonly="readonly"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"
	onkeyup="chkLength(this,299);" 	value="<%=medExamObj.getRemarksTeath() %>"><%=opdPatientDetails.getMissingTeethRemark()  %></textarea>
<% }else{%>
 
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,299);"
 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea> <% }%> 
<label class="auto"> Refer to MH</label>
<%	if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){%>

	<input tabindex="1" type="checkbox"
	name="dentalReferToMH2" value="no" checked="checked" class="radioAuto"   onclick="checkForDentalMH();"/>
	<input tabindex="1" type="hidden" name="dentalReferToMH" value="yes"  id="dentalReferToMH" />
	<%}else	{ %>
		<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%} %>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>
<%	int count=1;
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
	%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>"  validate="dgOrderdtId,metachar,no" />
<%count++;}
    }
%>
<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport" validate="hinNoForreport,metachar,no"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);" validate="Template,metachar,no">
	<option value="0">Select</option>
	<%
			   Iterator itr1=templateList.iterator();
			   while(itr1.hasNext())
			   {
				   OpdTemplate opdTemplate=(OpdTemplate)itr1.next();
				   String templateType=opdTemplate.getTemplateType();
				   if(templateType.equalsIgnoreCase("I"))
				   {
			%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>
<input type="hidden" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print"	class="button" accesskey="a" />
<input name="Prevoius" type="button" tabindex="2" value="Prev Investigation"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>
</tr>
<tr>
<%if(dgOrderhd !=null && dgOrderhd.getClinicalNote() !=null){
%>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="<%=dgOrderhd.getClinicalNote() %>" size="100" maxlength="45" validate="Clinical Notes,metacharSpac,no"/></td>
<%}else{ %>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="For Medical Exam" size="100" maxlength="45" validate="Clinical Notes,metacharSpac,no" /></td>
<%} %>
</tr>
</table>
	<div class="clear paddingTop15"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
<tr>
	<th scope="col">Investigation</th>
	<th scope="col">Refer to MH</th>
	<th scope="col">Result</th>
	<th scope="col">File Upload</th>
	<th scope="col">Add</th>
    <th scope="col">Delete</th>
</tr>

<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes" validate="Investigated,metachar,no"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No" validate="Investigated,metachar,no"/>
<%  }


if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" validate="patientInvestigationHeaderId,metachar,no"/>
<%
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" validate="patientInvestigationHeaderId,metachar,no"/>
<% }%>
<% if(dgOrderhd!=null){
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" validate="dgOrderhdId,metachar,no"/>
<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<%
}else{ %>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<% }
String template="";
int resultid=0;

if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   
	   int inc1=1;
	   
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {
		    	int cnt=0;
		    	String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());
		    	third.put(investigationName,patientInvestigation.getId());

		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		      	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	 DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Ritu 
		    	*/
		    	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
		    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
				for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
					linkedHashSet.add(dgResultEntryDetail);
				}
				subSet1.addAll(linkedHashSet);
		    	
		    //	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	for(DgResultEntryDetail dgre:subSet1)
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

		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
		    	second.put(investigationId,val);
		    	++inc1;
		    	//
		    }

			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();



		    %>
	<tr>

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			 name="chargeCodeName<%=inc %>" size="45" />
</td>
<%

if(second.get(first.get(key))!=null)
	{
	Labresult="present";
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{if(resultList!=null && resultList.size()>0){
		%>
		
		<td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
	 </td><%}else{ %>
	 <td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" />
	 <%} %>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>

<% }else{

%>
<td>&nbsp;</td>
	<td>
	<input name="resultIdTemplate<%=inc %>"	id="resultIdTemplate<%=inc %>" type="hidden"	value="<%=mySplitResult[1]%>"/>
	<input	type="Button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  />
	</td>

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
	</td>
	<%}else{

	String investigationVal=key;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>

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

	    		%>
	    	 <td>
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y" checked="checked"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/></td>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"
	onclick="checkForInvestigationMH(<%=inc %>);"/>
   </td>
    <td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
            <%
             }
	    	}else
	    	{ %>
 <td>
	<input tabindex="1" type="checkbox"	name="investigationReferToMH<%=inc %>" value="y"  
	id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
        <td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
	    <%	}
	    }
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%--<input type="text" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
	 --%>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
	<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%
	}
	}else{
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
<%--
<input type="hidden" value="0" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
 --%>
<input type="hidden" value="0" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	 <td>
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="n"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/></td>
<td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% }%>



<% }%>
<!-- style="display: none;" -->

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
	</tr>

	<% inc++;
		    }

%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
<%--<input type="hidden" value="0" name="dgOrderdtId1" id="dgOrderdtId1" /> --%>
		</td>
	<td>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" size="65" />
</td>
<!-- style="display: none;"  -->
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>
<script>
checkForInvestReferToMH();
</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no" validate="investigationDataStatus,metachar,no"/>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label>Medical Officer</label>
<select	id="moId" name="medicalOfficer"	validate="Medical Officer,metachar,no"  onchange="setDepartmentValue(this.value);" tabindex="1">
	<option value="0">Select</option>
	<%if(doctorList.size()>0){
		 for(MasEmployee emp :doctorList){
			%>
	<option value="<%=emp.getId() %>" ><%=emp.getRank().getRankName()+" "+ emp.getFirstName()+" "+(emp.getMiddleName()!=null?emp.getMiddleName():"")+" "+(emp.getLastName()!=null?emp.getLastName():"") %></option>
		
	<%}} %>
</select> 
<%if(visit.getDepartment() != null){ %>
<input type="hidden" name="<%=DEPARTMENT_ID %>"  id="deptId" value="<%=visit.getDepartment().getId() %> " validate="deptId,metachar,no"/>
<%}else{ %>
<input type="hidden" name="<%=DEPARTMENT_ID %>"  id="deptId" value="0" validate="deptId,metachar,no"/>
<%} %>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="button" value="Update"	onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=updateMedicalExaminationBoardAnnual2A&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<input tabindex="1" name="Button"	type="button" class="button" value="Forward"	onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=updateMedicalExaminationBoardAnnual2A&data=farwarded&Labresult=<%=Labresult.trim() %>','validateMO');" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" id="visitNumberForReport" validate="visitNumberForReport,metachar,no"/>
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
<input type="hidden"  name="MissTeeth" id="MissTeeth" value="" validate="MissTeeth,metachar,no" />
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value="" validate="UnserTeeth,metachar,no"/>
<%if(medExamObj.getDateOfReporting()!=null)
{%>
<input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
validate="Reported Date,date,no" />

<% }else{%>
 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>" validate="Reported Date,date,no" />
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
	var hinId1= document.getElementById('hinId');
	if(validateMetaCharacters(medicalExamId)){
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
  	if(validateMetaCharacters(hinNo) && validateMetaCharacters(medicalExamId) && validateMetaCharacters(hinId1)  && validateMetaCharacters(invest_id)){
 	<%-- var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo=<%=visit.getHin().getHinNo()  %>&invest_id="+invest_id+"&masExamId=<%=medExamId%>"; --%>
 	var url="/hms/hms/medicalBoard?method=displayFileUploadInvestigation&hinId="+hinId1+"&hinNo="+hinNo+"&invest_id="+invest_id+"&masExamId="+medicalExamId;
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	}
 	}
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

--</script> <script language="JavaScript" type="text/JavaScript">
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
	  var medExamFlag = 'Exam';
		if(checkTemplateId(valueOfTemplate)){
 // 	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
     if( validateMetaCharacters(medExamFlag)){
		submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=showGridForInvestigationMedicalExam&flag='+medExamFlag,'gridview');
       }

		}
	}

  function checkTemplateId(templateId){

      if(templateId=="0"){
        return true;
      }else{
        return true;
      }
    }
  
function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration,'parent');}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';

	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);

	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');

	  var cellRight11 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'checkbox';
	  e11.name = 'investigationReferToMH' + iteration;
	  e11.id = 'investigationReferToMH' + iteration;
	  // e1.size = '30';
	  e11.value='n';
	  e11.className = 'radioAuto';
	  e11.setAttribute('tabindex','1');
	  e11.onclick = function(){checkForInvestigationMH(iteration)};
	  cellRight11.appendChild(e11);

	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'Result' + iteration;
	  e1.id = 'Result' + iteration;
	  e1.size = '65';
	  e1.setAttribute('readonly','readonly');
	  e1.setAttribute('maxlength', 20);
	  e1.setAttribute('tabindex','1');
      cellRight1.appendChild(e1);

	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	  var cellRight30 = row.insertCell(3);
	  var e30 = document.createElement('input');
	  e30.type = 'button';
	  e30.className = 'button';
	  e30.name='uploadReport'+iteration;;
	  e30.id='uploadReport'+iteration;
	  e30.value='UPLOAD/VIEW';
	  e30.style.display='none';
	 // e30.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
	  e30.onclick = function(){fileUploadWindowInvestigation(iteration);}; 
	  cellRight30.appendChild(e30);

	  var cellRight1 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.onclick = function(){addRowForInvestigation();};
	 // e3.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.onclick = function(){removeRowForInvestigation();};
	  //e4.setAttribute('onClick','removeRowForInvestigation();');
	  cellRight2.appendChild(e4);
	}

function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
	}
function removeRowForInvestigation()
{
  var tbl = document.getElementById('investigationGrid');
  document.getElementById('investigationDataStatus').value="yes";
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('investigationGrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hiddenValue');
  	hdb.value=iteration

  }

  var pid = document.getElementById('patientInvestigationdetailsId'+lastRow ).value;
  var dv=document.getElementById('deleatedValue').value;
  var val;
  if(dv=="")
  {
	  val=pid+",";
  document.getElementById('deleatedValue').value = val;
  }else{
	  val=dv+pid+","
	  document.getElementById('deleatedValue').value = val;
  }

  var pid1 = document.getElementById('dgOrderdtId'+lastRow ).value;
  var dv1=document.getElementById('deleatedorderid').value;
  var val1;

  if(dv1=="")
  {
	  val1=pid1+",";
  document.getElementById('deleatedorderid').value = val1;
  }else{
	  val1=dv1+pid1+","
	  document.getElementById('deleatedorderid').value = val1;
  }
  }
 function openPopupForPatientInvestigation(visitNo,hinId){
	 if(validateMetaCharacters(visitNo) && validateMetaCharacters(hinId) ){
	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
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
	    submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}

 function getListForTreatment(val){
	 if(validateMetaCharacters(val)){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}
	 }
	 }
 function submitdata()
	{
		var charge=document.getElementById("chargeCodeName1").value;
  if(charge=="")
  {
   alert("Please Select Test Name");
  }else{
  	submitForm('medicalExamPrimaryExtn','medicalExam?method=addMedicalExaminationBoardAnnual2A');
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
	<%
	if(opdDentalDetailsList.size() == 0){
	%>
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
	<%}else{%>
		alert("You are trying to change the value.");
		if(Obj.checked){
			document.getElementById(Obj.id).checked = false;
		}else{
			document.getElementById(Obj.id).checked = true;
		}
	<%}%>
 	}
  function coolDental()
 	{
 	 var dentalValue=document.getElementById('dentalValueId').value;
 	if( validateMetaCharacters(dentalValue)){
 	 var mySplitResult = dentalValue.split(",");
 	 for(i=1;i<mySplitResult.length;i++)
 	 {
 		 document.getElementById(mySplitResult[i]).checked="checked";
 		messingTeeth(mySplitResult[i]);
 	 }
 	}
 	}
	
  function setDepartmentValue(doctorId){
		var dcId;
		var deptId = 0;
		<%
			for(MasEmployee emp : doctorList){
		%>			
			dcId = '<%=emp.getId()%>';
			if(doctorId == dcId){
				<%
					if(emp.getDepartment()!= null){
				%>
				deptId = '<%=(Integer)emp.getDepartment().getId()%>';
				<%}%>
			}	
		<%}%>
		
		document.getElementById('deptId').value=deptId;
	}


		function validateMO(){
			if(document.getElementById('moId').value=='0'){
				alert("Please select Medical Officer.");
				return false;
			}else{
			return true;
			}
		  }

		

  function messingTeeth(mm)
  {
  	var name=document.getElementById(mm).name;
  	var mval=document.getElementById('MissTeeth').value;
  	var uval=document.getElementById('UnserTeeth').value;
  	if(name[0]=='m')
  	{
  		mval=mval+" "+name.substring(1,name.length).toUpperCase();
  		document.getElementById('MissTeeth').value=mval;
  	}
  	if(name[0]=='u')
  	{
  		uval=uval+" "+name.substring(1,name.length).toUpperCase();
  		document.getElementById('UnserTeeth').value=uval;
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
  function openPopupPatientPreviousVisit()
  {
	  var visId = document.getElementById('visitId').value;
		 var visNo= document.getElementById('visitNumberForReport').value;
		 var hinId1 = document.getElementById('hinId').value;
		 if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1)){
	 		<%--var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";--%>
	 		var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId="+visId+"&visitNo="+visNo+"&hinId="+hinId1;
	 		newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
		 }
  }
  function getPrevMedBoardFromHIC()
  {
	 	 var visId = document.getElementById('visitId').value;
		var visNo= document.getElementById('visitNumberForReport').value;
		var hinId1 = document.getElementById('hinId').value;
		var tokenNo =  document.getElementById('token').value;
		if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1) && validateMetaCharacters(tokenNo)){
			<%--	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";--%>
			var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId"+visId+"&visitNo="+visNo+"&hinId="+hinId1+"&token="+tokenNo;
			newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
		}

     
  }
  function getPrevMedExamFromHIC()
  {
		 var visId = document.getElementById('visitId').value;
			var visNo= document.getElementById('visitNumberForReport').value;
			var hinId1 = document.getElementById('hinId').value;
			var tokenNo =  document.getElementById('token').value;
	  
			if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1) && validateMetaCharacters(tokenNo)){
  				<%-- var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";--%>
  				var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId="+visId+"&visitNo="+visNo+"&hinId="+hinId1+"&token="+tokenNo;
     			newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
			}
  }
  function showPatientPreVisitHospitality()
  {
	  var visId = document.getElementById('visitId').value;
		var visNo= document.getElementById('visitNumberForReport').value;
		var hinId1 = document.getElementById('hinId').value;
		var tokenNo =  document.getElementById('token').value;

		if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1) && validateMetaCharacters(tokenNo)){
  			<%-- var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";--%>
  			var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId="+visId+"&visitNo="+visNo+"&hinId="+hinId1+"&token="+tokenNo;
     		newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
		}
  }
  function openTemplateScreen(index){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
	    //submitForm('medicalBoardMAForm16','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
	    if( validateMetaCharacters(resultId)){
	     var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
	    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	    }
	 }
</script></form>
</body>