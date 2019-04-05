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
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.MasMedicalExamInvestResult"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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
List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}
List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=null;
if(map.get("masMedicalExamInvestResultList")!=null)
{
	masMedicalExamInvestResultList = (List<MasMedicalExamInvestResult>) map.get("masMedicalExamInvestResultList");

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
//	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
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
String signedBy="";
if(session.getAttribute("users")!=null){
Users user = (Users) session.getAttribute("users");
}
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");

}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		//loginEmpId=masEmployee.getId();
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
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>

<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-2A</h2></div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalExamPrimaryExtnMO" action="" method="post">
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
<input tabindex="1" type="text"   id="" readonly="readonly" ame="<%=AUTHORITY_OF_BOARD %>"maxlength="15" value="<%=medExamObj.getAuthority() %>"
	onKeyUp="limitText(this,15);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="15" value="IAP 4303 (4th Ed)"	onKeyUp="limitText(this,15);"  />

 <% }%>

<label>Service No. </label>
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
   <input type="text" value="<%= medExamObj.getFatherName() %>" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="30"/>
  <%}else{ %>
 <input	type="text" value="" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="30"/>
 <%} %>




 <label>DOB</label>
 <%
 if(visit.getHin().getDateOfBirth() != null){
 %>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<%}else{ %>
	<input tabindex="1" name="<%=DATE_OF_BIRTH %>"  value=""  maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<%} %>
	 <div class="clear"></div>

 <label>Age  </label>
 <input	type="text" value="<%= visit.getAge() %>" name="<%=AGE%>"	maxlength="20" tabindex="1" readonly="readonly"/>

  <label>Apparent Age  </label>
  <%
  if(medExamObj.getApparentAge() != null){
  %>
 <input	type="text" value="<%=medExamObj.getApparentAge() %>" name="apparentAge"	maxlength="20" tabindex="1" readonly="readonly"/>
 <%}else{ %>
 <input	type="text" value="" name="apparentAge"	maxlength="20" tabindex="1" readonly="readonly"/>

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
 <label>Total Service  </label>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears()+" "+ visit.getHin().getTotalServicePeriod()%>" name="<%=TOTAL_SERVICE%>"	tabindex="2" maxlength="20" />

   <div class="clear"></div>


  <label>Permanent Address  </label>
   <%
  	if(visit.getHin().getPermanentAddress() != null){
  %>
   <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"
   onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ><%=visit.getHin().getPermanentAddress() %></textarea>
  <%}else{ %>
 <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"
 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <%} %>

 <label>Past Medical History  </label>
 <%
  if(medExamObj.getPastmedicalhistory() != null){
  %>
 <input	type="text" value="<%= medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100" readonly="readonly"/>
 <%}else{ %>
  <input	type="text" value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="100" readonly="readonly"/>
 <%} %>
 <label>Relevant Family History </label>
 <%
 if(medExamObj.getRelevantFamilyHistory() != null){
 %>
  <input	type="text" readonly="readonly" value="<%=  medExamObj.getRelevantFamilyHistory() %>" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100"/>
 <%}else{ %>
 <input	type="text" value="" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100" readonly="readonly"/>
 <%} %>

   <div class="clear"></div>

<label >Identification Marks</label>
 <% if(visit.getHin().getSrIdentificationMark1()!=null){%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>" value="<%=visit.getHin().getSrIdentificationMark1() %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  />

 <% }else{%>
<label class="valueAuto">1.</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>"
	onKeyUp="limitText(this,50);" class="auto" size="72"  />

 <% }%>
<div class="clear"></div>
<input class="transparent" size="28">
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
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWthoutGlassesRDistant() %>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%" rowspan="2" >

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" />
 <% }%>
 </td>


	</tr>

</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Any evidence of trachoma and its complications or any other disease</label>
<% if(medExamObj.getEvidenceOfTrachoma() !=null){%>
 <input name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" maxlength="30"
	 value="<%=medExamObj.getEvidenceOfTrachoma() %>" />
 <% }else{%>
<input  name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" maxlength="30" />
 <% }%>
<div class="clear"></div>
<label class="large2">Binocular vision & Grade</label>
<% if(medExamObj.getBinocularVisionGrade()!=null){%>
<input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>" value="<%=medExamObj.getBinocularVisionGrade() %>"
	class="large" maxlength="30" />
 <% }else{%>
<input tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>" class="large" maxlength="30" /><% }%>
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
		<input tabindex="1" type="text" maxlength="20" class="auto"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" type="text" value="600" maxlength="20" class="auto" id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>
		cm
	</td>

	<td>
		<% if(medExamObj.getEarHearingLfw() != null){ %>
		<input tabindex="1" type="text" maxlength="20" class="auto"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" value="600"  type="text" maxlength="20" class="auto" id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>
		cm
	</td>

	<td>
		<% if(medExamObj.getEarHearingBothFw() != null){ %>
		<input tabindex="1" type="text" maxlength="20" class="auto" size="15"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
		<%}else{ %>
		<input tabindex="1" value="600"  type="text" maxlength="20" class="auto" size="15" id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

		<%} %>
		cm
	</td>

	</tr>
	</table>


<div class="Block">
<div class="clear"></div>
	<label class="auto">Any Evidence of Otitis Media</label>
	<% if(medExamObj.getFundAndMedia() != null){ %>
	<input tabindex="1" type="text"  class="auto" size="50" id="OtitisMedia"	name="OtitisMedia" value="<%=medExamObj.getFundAndMedia()%>"  maxlength="50"  />
	<%}else{ %>
	<input tabindex="1" type="text"  class="auto" id="OtitisMedia"	name="OtitisMedia"  maxlength="50"  />
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
 <input tabindex="1" type="text"  id="upperLimbs" name="upperLimbs"  value="<%=medExamObj.getUpperLimbs() %>"
	onKeyUp="limitText(this,50);" class="autoArial" size="29" maxlength="50" />

<%}else{ %>
 <input tabindex="1" type="text"  id="upperLimbs" name="upperLimbs"  value="NAD"
	onKeyUp="limitText(this,50);" class="autoArial" size="29" maxlength="50" />
<%} %>

<label class=""> Locomotion</label>
<% if(medExamObj.getLocomotion() != null){ %>
<input tabindex="1" type="text"  id="locomotion" name="locomotion" maxlength="50" value="<%=medExamObj.getLocomotion() %>"
	onKeyUp="limitText(this,50);" class="autoArial" size="29"  />
<%}else{ %>
<input tabindex="1" type="text"  id="locomotion" name="locomotion" maxlength="50" value="NAD"
	onKeyUp="limitText(this,50);" class="autoArial" size="29"  />
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
<input tabindex="1" type="text" id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>

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
<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>

<label> Chest Measurment</label>
<%if(medExamObj.getChestMeasurement() != null){ %>
<input type="text" name="chestMeasurment" class="auto" value="<%=medExamObj.getChestMeasurement() %>" />
<%}else{ %>
<input type="text" name="chestMeasurment" class="auto" value="" />
<%} %>
<label class="auto">cm</label>

<label> Full Expiration</label>
	<% if(medExamObj.getFullExpiration() != null){ %>
<input tabindex="1" type="text"  id="fullExpiration" name="fullExpiration" maxlength="20" value="<%=medExamObj.getFullExpiration() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  /><label class="auto">cm</label>
<%}else{ %>
<input tabindex="1" type="text"  id="fullExpiration" name="fullExpiration" maxlength="20"
	onKeyUp="limitText(this,20);" class="auto" size="20"  /><label class="auto">cm</label>

<%} %>
	<label >Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="15" /><label class="auto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5"
	onKeyUp="limitText(this,6);" class="auto" size="15"  /><label class="auto">cm</label>

 <% }%>
 <div class="clear"></div>

	<label> Abnormalities</label>
	<% if(medExamObj.getAbnormalities() != null){ %>
	<input tabindex="1" type="text"  id="abnormalities" name="abnormalities" maxlength="50" value="<%=medExamObj.getAbnormalities() %>"
	onKeyUp="limitText(this,50);" class="auto" size="20"  />

<%}else{ %>
<input tabindex="1" type="text"  id="abnormalities" name="abnormalities" maxlength="50"
	onKeyUp="limitText(this,50);" class="auto" size="20"  />
<%} %>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GENTIO URINARY SYSTEM<a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<h3 > Urine</h3>
<label > Albumen</label>
<% if(medExamObj.getAlbumin()!=null){%>
<input tabindex="1" type="text"  id="albumin" name="<%=ALBUMIN %>" maxlength="10" value="<%=medExamObj.getAlbumin() %>"
	onKeyUp="limitText(this,10);" class="" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="albumin" name="<%=ALBUMIN %>" maxlength="10" value="NP"
	onKeyUp="limitText(this,10);"  class="" size="20" />

 <% }%>

<label class=""> Sugar</label>
<% if(medExamObj.getSugar()!=null){%>
<input tabindex="1" type="text"  id="sugar" name="<%=SUGAR %>" maxlength="10" value="<%=medExamObj.getSugar() %>"
	onKeyUp="limitText(this,10);" class="" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="sugar" name="<%=SUGAR %>" maxlength="10" value="ND"	onKeyUp="limitText(this,10);"  class="" size="20" />

 <% }%>

<label class=""> Other Abnormalities</label>
<% if(medExamObj.getAnyOtheAbnormalities()!=null){%>
<input tabindex="1" type="text"  id="otherAbnormalities" name="otherAbnormalities" maxlength="30" value="<%=medExamObj.getAnyOtheAbnormalities() %>"
	onKeyUp="limitText(this,30);" class="" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="otherAbnormalities" name="otherAbnormalities" maxlength="30" value="Nil"	onKeyUp="limitText(this,30);"  class="" size="20" />

 <% }%>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="auto">Evidence of Skin/Veneral Disease(s)</label>
<% if(medExamObj.getAnyEvidenceOfSkin()!=null){%>
<input tabindex="1" type="text"  id="anyEvidenceOfSkin" name="anyEvidenceOfSkin" maxlength="30" value="<%=medExamObj.getAnyEvidenceOfSkin() %>"
	onKeyUp="limitText(this,30);" class="" size="67"  />

 <% }else{%>
<input tabindex="1" type="text"  id="anyEvidenceOfSkin" name="anyEvidenceOfSkin" maxlength="30"  value="Nil"	onKeyUp="limitText(this,30);"  class="" size="67" />

 <% }%>
</div>

<div class="clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" name="<%=PULSE_RATES%>" class="auto" size="22" maxlength="15"  value="<%=medExamObj.getPulseRates() %>"/><label class="unit">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=PULSE_RATES%>" class="auto" size="22" maxlength="15" value="Normal" /><label class="unit">/min</label>
 <% }%>



 <label>BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="22" maxlength="7"  value="<%=medExamObj.getBp() %>"/><label class="unit">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="22" maxlength="7" value="Normal" /><label class="unit">mm Hg</label>
 <% }%>

<div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label >Central Nervous System</label>
<% if(medExamObj.getCentralNervousSystem()!=null){%>
  <input tabindex="1" type="text" name="centralNervousSystem" class="" size="22" maxlength="50"  value="<%=medExamObj.getCentralNervousSystem() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="centralNervousSystem" class="" value="NAD" size="22" maxlength="50" />
 <% }%>
 </div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label> Abdomen</label>
<% if(medExamObj.getAbdomen()!=null){%>
  <input tabindex="1" type="text" name="<%=ABDOMEN %>" class="" size="22" maxlength="50"  value="<%=medExamObj.getAbdomen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=ABDOMEN %>" class="" size="22" maxlength="50" value="Soft,Non-Tender"/>
 <% }%>

<label > Liver</label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" name="liver" class="Auto" size="22" maxlength="50"  value="<%=medExamObj.getLiver() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="liver" class="Auto" size="22" maxlength="50" value="Not Palpable"/>
 <% }%>

<div class="clear"></div>
<label > Spleen</label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" name="spleen" class="" size="22" maxlength="50"  value="<%=medExamObj.getSpleen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="spleen" class="" size="22" maxlength="50" value="Not Palpable"/>
 <% }%>

<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text"	name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="50" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="50" value="NAD"/>
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
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label>Total Teeth</label>
<%if(medExamObj.getTotalTeeth() != null){ %>
<input type="text" name="totalTeeth" value="<%=medExamObj.getTotalTeeth() %>" onKeyUp="isNumber(this);" maxlength="2" />
<%}else{ %>
<input type="text" name="totalTeeth" value="" onKeyUp="isNumber(this);" maxlength="2" />
<%} %>

	<label class="">No. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	 <label class="">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="50" validate="Condition Of Gums,Alphabetic,Yes" />


 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="50" validate="Condition Of Gums,Alphabetic,Yes"/>

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
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />

<%count++;}
    }
%>
<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<h4>Investigations</h4>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Result</th>
		<th scope="col">Upload/View</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	<input type="hidden" name="Investigated" tabindex="2" value="yes" />
	<% }else{%>
	<input type="hidden" name="Investigated" tabindex="2" value="No" />
	<%  }

if(patientInvestigationHeader.getId()!=null)
{
%>
	<input type="hidden" value="<%=patientInvestigationHeader.getId() %>"
		name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
	<%
}else{%>
	<input type="hidden" name="patientInvestigationHeaderId"
		id="patientInvestigationHeaderId" />
	<% }
if(dgOrderhd!=null)
{
%>
	<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId"
		id="dgOrderhdId" />
	<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
	<%
}else{%>
	<input type="hidden" name="dgOrderhdId" id="dgOrderhdId" />
	<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
	<% }

String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0)
{
	HashMap second = new HashMap();
	   List<String> firstKeyList=new ArrayList<String>();
	   List<Integer> firstValueList=new ArrayList<Integer>();
	   List<Integer> secondKeyList=new ArrayList<Integer>();
	   List<String> secondValueList=new ArrayList<String>();
	   List<String> thirdKeyList=new ArrayList<String>();
	   List<Integer> thirdValueList=new ArrayList<Integer>();
	   List<String> referToMHList=new ArrayList<String>();
	   int inc21=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {   	int cnt=0;
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
		    		Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
			    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
					for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
						linkedHashSet.add(dgResultEntryDetail);
					}
					subSet1.addAll(linkedHashSet);
		    		
		    	int masInvestId=dgEH.getDgMasInvestigation().getId();
		       	if(patientInvestigation.getChargeCode().getId()==masInvestId)
		    	{
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
		    	if(investigationId!=0&&!second.containsKey(investigationId))
			    	second.put(investigationId,val);
			    	//++inc21;
		    }
		    int i=0;
	          
			 for(String firstKey:firstKeyList)
			 {
		%>
 <tr>
	<input type="hidden" value="<%=thirdValueList.get(i) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=firstKey%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="45" name="chargeCodeName<%=inc %>" />
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
	{
	%>
	<td>
	<% if(referToMHList.get(i).equalsIgnoreCase("y")){
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>
 </td>
	<td><input type="text" value="<%=secondValueList.get(i)%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<% }else{%>
<td>&nbsp;</td>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
	</td>
	
	  
	<%  }else{	%>
	<td> <% if(referToMHList.get(i).equalsIgnoreCase("y")){
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>	 </td>
		<td><input type="text" value="" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
	<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>
	<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
	<% 	    	}else
	            {
		%>
	            <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="n" disabled="disabled"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
	    <td><input type="text" value="" readonly="readonly"
				 tabindex="2" id="Result<%=inc %>" size="65"
				 name="Result<%=inc %>" />
	</td>
	<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
	            <%

	             }
		    	}else
	    	{ %> 
	    	
	  <td>  	<input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" /></td>
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65"  /></td>
			<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
		<%	}
	    }
	}}else{
	%> 
	
	<td><input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" /></td>
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65" /></td>
		<% }%>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
		<% }%>
		<%---		<td><input name="uploadReport<%=inc %>"
			id="uploadReport<%=inc %>" type="button" class="button"
			value="UPLOAD/VIEW		" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" /></td>--%>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation();" /></td>
	</tr>
	<% inc++;i++;
		    }

%>
	<input type="hidden" value="<%=inc-1 %>" name="hiddenValue"
		id="hiddenValue" />

	<%
}else{
	%>
           
	<tr>
		<td><input type="text" value="" tabindex="1" id="chargeCodeName1"
			size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
		<td><input tabindex="1" type="checkbox"
			name="investigationReferToMH1" value="n" id="investigationReferToMH1"
			onclick="checkForInvestigationMH(1);" /></td>
		<td><input type="text" value="" readonly="readonly"
			name="Result1" id="Result1" size="65" /></td>
		<td><input name="uploadReport1" id="uploadReport1" type="button"
			class="button" value="UPLOAD/VIEW" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(1);" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation(this);" /> </td>

	</tr>
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
  <input tabindex="1" type="text" name="<%=SPEECH %>" class="Auto" size="22" maxlength="50"  value="<%=medExamObj.getSpeech() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=SPEECH %>" class="Auto" size="22" maxlength="50" value="Normal"/>
 <% }%>

<h4>Evidence Suggesting</h4>


<label >Mental Retardation</label>
<% if(medExamObj.getMentalInstability()!=null){%>
  <input tabindex="1" type="text" name="mentalInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getMentalInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="mentalInstability" class="Auto" size="22" maxlength="20" value="Nil"/>
 <% }%>

<div class="clear"></div>

<label >Emotional Stability</label>
<% if(medExamObj.getEssentialInstability()!=null){%>
  <input tabindex="1" type="text" name="essentialInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getEssentialInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="essentialInstability" class="Auto" size="22" maxlength="20" value="Nil"/>
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
<select name="drinker" tabindex="1" id="drinker">
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

<select name="smoker" tabindex="1" id="smoker">
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

<!--<input tabindex="1" name="Button"	type="button" class="button" value="Allergies"	onClick="javascript:openPopupForAllergies();" />
-->
<div class="clear"></div>
<label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="60" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="60" id="allergies" size="92" />
<%} %>
<div class="clear"></div>
</div>
<div class="clear paddingTop15"></div>

<h4>FINAL OBSERVATION AND MEDICAL CATEGORY <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="Block">
<div class="clear"></div>
<label class="large">Slight Defects Not Sufficient to Cause Rejection</label>
<% if(medExamObj.getDefectNotToCauseRejection()!=null){%>
<textarea rows="" cols="35" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" onkeyup="chkLength(this,50);" tabindex="1" maxlength="50"
onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ><%=medExamObj.getDefectNotToCauseRejection() %></textarea>
   <% }else{%>
<textarea rows="" cols="35" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" onkeyup="chkLength(this,50);" tabindex="1" maxlength="50"
onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <% }%>

<div class="clear"></div>

<label class="large">Found Fit In Category</label>
<% if(medExamObj.getFoundFitInCategory()!=null){%>
<textarea rows="" cols="35" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" onkeyup="chkLength(this,50);" tabindex="1" maxlength="50"
onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ><%=medExamObj.getFoundFitInCategory() %></textarea>
   <% }else{%>
<textarea rows="" cols="35" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" onkeyup="chkLength(this,50);" tabindex="1" maxlength="50"
onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <% }%>

 <div class="clear"></div>


<label class="">Admission</label>
<%if(medExamObj.getAdmissionStatus()!=null)
{
if(medExamObj.getAdmissionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox"
	name="admissionStatus" value="y" class="radioAuto" id="admissionStatus" checked="checked" />
<%}else{ %>
<input tabindex="1" type="checkbox"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus"  />
<%}}else{ %>
<input tabindex="1" type="checkbox"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus"  />
	<%} %>
<label class="auto">Specialist opinion</label>
<%if(medExamObj.getSpecialistOpinnionStatus()!=null)
{
if(medExamObj.getSpecialistOpinnionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox"
	name="specialistOpinion" value="y" checked="checked" class="radioAuto" id="specialistOpinion"  />
<input name="Send" type="button"  class="button" value="UPLOAD/VIEW" onClick="javascript:fileUploadForSpecialistOpinion();" />

<%}else{ %>
<input tabindex="1" type="checkbox"
	name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion"  />
<%}}else{ %>
<input tabindex="1" type="checkbox"
	name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion"  />
<%} %>
<div class="clear"></div>
<label >Signed By</label>
<input tabindex="1" type="text" id="signidBy" name="<%=SIGNED_BY %>"  size="20" maxlength="100" value="<%=signedBy %>" readonly="readonly" validate="Signed By,string,no"/>
<label >Remarks</label>
<% if(medExamObj.getRemarks()!=null){%>
<input tabindex="1" type="text"  maxlength="50"  id="remarks"	name="<%=MEDICIN_REMARKS %>" class="Auto" size="20"  value="<%=medExamObj.getRemarks() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  maxlength="50" id="remarks"	name="<%=MEDICIN_REMARKS %>" class="Auto" size="20"  value=""/>
 <% }%>
 <div class="clear"></div>
 <label >Final Observation</label>
<select name="<%=FINAL_OBSERVATION %>" id="finalObserv">
<option value="">Select</option>
<%String finalObservation="";
	if(medExamObj.getFinalObservation() !=null){
		finalObservation=medExamObj.getFinalObservation();
	} %>
<%if(finalObservation.equalsIgnoreCase("Fit")){ %>
<option value="Fit" selected="selected">Fit</option>
<option value="UnFit">UnFit</option>
<%}else if(finalObservation.equalsIgnoreCase("UnFit")){ %>
<option value="UnFit" selected="selected">UnFit</option>
<option value="Fit">Fit</option>
<%}else{ %>
<option value="Fit">Fit</option>
<option value="UnFit">UnFit</option>
<%} %>
</select>
<label >Med Cat Rec</label>
<select name="<%= MED_CAT_REC  %>"	id="medCatRecId"validate="Signed By,string,no" tabindex="2" onchange="setMedCatId(this.value)">
<option value="0">Select</option>
<%
if( medExamObj.getPastMedicalCategory()!=null)
{
		for (Category category : categoryList) {
			if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
			{

			if( medExamObj.getMedCatRec().equals(category.getCategories()))
				{
			%>
<option value="<%=category.getCategories()%>"  selected="selected"><%=category.getCategories()%> </option>
<%}}}}else{
	for (Category category : categoryList)
	{
		if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
		{

%>
<option value="<%=category.getCategories()%>" ><%=category.getCategories()%> </option>
<%	}}}
		%>
</select> 
<input name="medCat" type="hidden" id="catId" tabindex="1" class="auto" value="" />
<script type="text/javascript">
	function setMedCatId(medCategory){
	 <%
	 String catName = "";
	 int catId = 0;
	 if(categoryList.size()>0){
	 for(Category cat :categoryList){
		 catName = cat.getCategories();
		 catId = cat.getCategoryid();
	 %>
	 if(medCategory == '<%=catName%>'){
	document.getElementById('catId').value = <%=catId%>	
	 }
	<%}
	 }%>
	}


</script>
<div class="clear"></div>
</div>
</div>
<%
  if(medExamObj.getApprovAuthRemarks()!=null){
  		%>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Rejection Remark</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getAprovAuthFinalObservation()!=null){%>
<input tabindex="1" type="text" name="aaFinalObservation" value="<%=medExamObj.getAprovAuthFinalObservation() %>"   readonly="readonly"  size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value=""  size="20" maxlength="100" />

  <% }%>
<label >Remarks</label>
<% if(medExamObj.getApprovAuthRemarks()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="aaRemarks" name="aaRemarks" value="<%=medExamObj.getApprovAuthRemarks()%>" size="20" maxlength="100" />
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="aaRemarks" name="aaRemarks"  size="20" maxlength="100" />
 <% }%>



<label >Signed By</label>
<% if(medExamObj.getApprovAuthSignedBy()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value="<%=medExamObj.getApprovAuthSignedBy() %>"  readonly="readonly"/>
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value=""  readonly="readonly"/>

  <% }%>
<%} %>
<div class="clear"></div>



<div class="division"></div>
<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="button" value="Update"	onClick="submitForm('medicalExamPrimaryExtnMO','medicalExam?method=updateMedicalExaminationBoardAnnual2A&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalExamPrimaryExtnMO','medicalExam?method=validateMedExam');" />
<input tabindex="2" name="Button"	type="button" class="buttonBig2" value="Initiate New Medical Exam"	onClick="submitForm('medicalExamPrimaryExtnMO','medicalExam?method=initiateNewMedicalExam');" />
<%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
<input tabindex="2" name="Button"	type="button" class="buttonBig" value="Print Investigations"	onClick="submitForInvestigationPrintOut();" />
<%} %>
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
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

 	var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=medExamObj.getHin().getId()%>&hinNo=<%=medExamObj.getHin().getHinNo() %>&invest_id="+invest_id+"&masExamId=<%=medExamObj.getId()%>";

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
function isAlpha(argvalue) {
argvalue = argvalue.toString();
var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (var n = 0; n < argvalue.length; n++) {
if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
return false;
}
return true;
}
function fileUploadForSpecialistOpinion()
{

	 var medicalExamId='<%=medExamId%>';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; first submit form then upload the file");
	 	 	return false;
	 	}else
	 	{

			var folderName='specialistOpinion';
				var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName+"&masExamId=<%=medExamId%>";;

				newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
		 	}
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

				submitProtoAjaxWithDivName('medicalExamPrimaryExtnMO','/hms/hms/opd?method=showGridForInvestigation','gridview');

				}

	}

  function checkTemplateId(templateId){

      if(templateId=="0"){
        return true;
      }else{
        return true;
      }
    }
  function checkForChargeCode(val,inc,chargeCodeTdDiv){

		if(val != ""){

			var index1 = val.lastIndexOf("[");
			var indexForChargeCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			var indexForChargeCode = indexForChargeCode--;
			var chargeCode = val.substring(0,indexForChargeCode);


			if(chargeId == "" ) {
		      	document.getElementById('chargeCodeName'+inc).value="";
		      	document.getElementById('chargeCode'+inc).value="";
		      	document.getElementById('clinicalNotes'+inc).value="";
		 	  	document.getElementById('qty'+inc).value="";
		      	return;
			}

			/*for(i=1;i<inc;i++){

				if(inc != 1){
					if(document.getElementById('chargeCodeName'+i).value==val) {
						alert("Test name already selected...!")
						document.getElementById('chargeCodeName'+inc).value=""
						var e=eval(document.getElementById('chargeCodeName'+inc));
						e.focus();
						return false;
					}
				}
			}*/

			var nameOfChargeCodeArray = chargeCode.split('&');
			var tempChargeCodeString = "";
			for(var m=0; m<nameOfChargeCodeArray.length;m++) {
				tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";
			}

			//ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  tempChargeCodeString , inc);
			//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

			}else{
				document.getElementById('chargeCodeName'+inc).value = "";
				document.getElementById('qty'+inc).value = "";
				document.getElementById('chargeCode'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
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
	  // alert("iteration row--"+iteration)

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
	  //alert("name--"+e0.name)
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
	  e30.value='UPLOAD REPORT';
	  e30.style.display='none';
	  e30.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
	  cellRight30.appendChild(e30);

	  var cellRight1 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForInvestigation();');
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
	    submitProtoAjaxWithDivName('medicalExamPrimaryExtnMO','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}

 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalExamPrimaryExtnMO','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}
	 }
 function submitdata()
	{

		var charge=document.getElementById("chargeCodeName1").value;
  if(charge=="")
  {
   alert("Please Select Test Name");
  }else{
  	submitForm('medicalExamPrimaryExtnMO','medicalExam?method=addMedicalExaminationBoardAnnual2A');
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
  function openPopupPatientPreviousVisit()
  {
  	var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
     	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function getPrevMedExamFromHIC()
  {
  	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function getPrevMedBoardFromHIC()
  {
  	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }
  function showPatientPreVisitHospitality()
  {
  	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
     	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
  }

  function submitForInvestigationPrintOut()
  {
  	var orderNo=document.getElementById('dgOrderhdId').value;
  	var flag="MO";
  	var hinId= document.getElementById('hinId').value;
  	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
  		submitFormForButton('medicalExamPrimaryExtnMO','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
  		}
  }
  function openTemplateScreen(index){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
	    //submitForm('medicalBoardMAForm16','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
	     var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
	    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	 }
</script></form>
</body>