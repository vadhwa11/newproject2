
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
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<!-- -<script type="text/javascript"
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
if(map.get("medExamList") != null){
	existingMedExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(existingMedExamList.size() > 0){
	medExamObj = existingMedExamList.get(0);
	visit=medExamObj.getVisit();
}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");

	}
int visitId=0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
      System.out.println("jsp search"+search);
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
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	System.out.println(" patientInvestigationHeader is not null");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){
	
	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	System.out.println(" dgOrderhd is not null");
	getDgOrderdts=dgOrderhd.getDgOrderdts();
	
}

%>


<!--main content placeholder starts here-->
<div class="titleBg"><h2>Primary Medical Examination Report(AFMSF-2A)</h2></div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalExamPrimaryExtn" action="" method="post">
<!--Block One Starts-->
<div class="Block">
<input type="hidden" name="medicalExamType" value="<%=medExamObj.getMedicalExamType() %>"/>
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<label>Service Number </label>
 <% if(medExamObj.getServiceNo()!=null){%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=medExamObj.getServiceNo() %>" readonly="readonly" />
 <% }else{%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=SERVICE_NO %>" tabindex="2" />
 <% }%>
 <label>Rank  </label>
  <% if(medExamObj.getRank()!=null){%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=RANK %>" tabindex="2" value="<%=medExamObj.getRank().getRankName() %>" readonly="readonly"/>
 <input type="hidden" value="<%=medExamObj.getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=RANK %>" tabindex="2" />
 <% }%>
  

 
 <label>Name  </label> 
  <% if(medExamObj.getNameInFull()!=null){%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=FULL_NAME %>" tabindex="2" value="<%=medExamObj.getNameInFull() %>" readonly="readonly"/>
 <% }else{%>
 <input type="text" readonly="readonly" readonly="readonly"	 name="<%=FULL_NAME %>" tabindex="2" />
 <% }%>
 
 <div class="clear"></div>
  <label>Father's Name  </label> 
  <%
  	if(medExamObj.getFatherName() != null){
  %>
   <input type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getFatherName() %>" name="<%=FATHER_NAME%>" readonly="readonly"	tabindex="1" maxlength="50"/>
  <%}else{ %>
 <input	type="text" readonly="readonly" readonly="readonly" value="" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="50"/>
 <%} %>
 
  <label>Date Of Birth <span>*</span> </label>
 <%
 if(medExamObj.getDateOfBirth() != null){
 %>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
	<%}else{ %>
	<input tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value=""	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
	<%} %>
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalExamPrimaryExtn.<%=DOB%>,event);" />
 <label>Age  </label> 
 <%
 	if(medExamObj.getVisit() != null){
 %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getVisit().getAge() %>" name="<%=AGE%>" readonly="readonly"	tabindex="1" />
 <%}else{ %>
  <input	type="text" readonly="readonly" readonly="readonly" value="" name="<%=AGE%>"	tabindex="1" />
 
 <%} %>
  <div class="clear"></div>
  <label>Apparent Age  </label> 
 <input	type="text" readonly="readonly" readonly="readonly" value="" name="apparentAge"	tabindex="1" maxlength ="10" />
 <label>Service </label> 
 <%
 	if(medExamObj.getVisit() != null){
 %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="1" maxlength ="20" />
  <input type="hidden" value="<%= medExamObj.getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID  %>"	 />
  <%}else{ %>
 <input	type="text" readonly="readonly" readonly="readonly"  name="serviceiaf"	tabindex="1" maxlength ="20" />
   <%} %>
 <label>Present Unit</label> 
 <%
 String unitName = "";
 int unitId = 0;
 	if( medExamObj.getUnit() != null){
 		unitName = medExamObj.getUnit().getUnitName();
 		unitId = medExamObj.getUnit().getId();
 	}
 %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%=unitName %>" name="<%=UNIT%>"	tabindex="1" />
  <input type="hidden" value="<%= unitId %>" name="<%=UNIT_ID%>"	/>
 <div class="clear"></div>
 <label>Branch/Trade  </label> 
 <%
 String tradeName = "";
 int tradeId = 0;
 	if( medExamObj.getTrade() != null){
 		tradeName = medExamObj.getTrade().getTradeName();
 		tradeId =medExamObj.getTrade().getId() ;
 	
 %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%= tradeName %>" name="<%=TRADE%>"	tabindex="1" />
 <input	type="hidden" value="<%=tradeId %>" name="<%=TRADE_ID%>" />
 <%}else{ %>
  <input	type="text" readonly="readonly" readonly="readonly" value="" name="<%=TRADE%>"	tabindex="1" />
 <input	type="hidden" value="" name="<%=TRADE_ID%>" />
 <%} %>
 <label>Total Service  </label> 
 <%
 	if(medExamObj.getVisit() != null){
 %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getTotalService()%>" name="<%=TOTAL_SERVICE%>"	tabindex="2" />
  <%}else{ %>
 <input	type="text" readonly="readonly" readonly="readonly"  name="<%=TOTAL_SERVICE%>"	tabindex="2" />
 
 <%} %>
 
 
  <label>Permanent Address  </label> 
   <%
  	if(medExamObj.getParmanentAddress() != null){
  %>
   <textarea readonly="readonly" tabindex="1" name="<%=PERMANENT_ADDRESS %>" onkeyup="chkLength(this,100);"><%=medExamObj.getParmanentAddress() %></textarea>
  <%}else{ %>
 <textarea readonly="readonly" tabindex="1" name="<%=PERMANENT_ADDRESS %>" onkeyup="chkLength(this,100);"></textarea>
 <%} %>
   <div class="clear"></div>
  
  <label><span>*</span> ID Mark 1  </label> 
   <%
  	if(medExamObj.getIdentificationMarks1() != null){
  %>
   <input tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getIdentificationMarks1() %>"
	validate="Identification1,String,yes" maxlength="25" /> 
  <%}else{ %>
  <input tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text" readonly="readonly" readonly="readonly"
	validate="Identification1,String,yes" maxlength="25" /> 
	<%} %>
	<label><span>*</span>  ID Mark 2 </label> 
	<%
  	if(medExamObj.getIdentificationMarks2() != null){
  %>
	<input tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getIdentificationMarks2() %> "
	validate="Identification2,String,yes" maxlength="20" /> 
	<%}else{ %>
  <input tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text" readonly="readonly" readonly="readonly"
	validate="Identification2,String,yes" maxlength="20" /> 
	<%} %>
 <label>Past Medical History  </label> 
 <%
  	if(medExamObj.getPastmedicalhistory() != null){
  %>
 <input	type="text" readonly="readonly" readonly="readonly" value="<%= medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="20"/>
 <%}else{ %>
  <input	type="text" readonly="readonly" readonly="readonly" value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="1" maxlength="20"/>
 <%} %>
 <div class="clear"></div>
 
 <label>Relevant Family Hx  </label> 
 <%
 	if(medExamObj.getRelevantFamilyHistory() != null){
 %>
<input	type="text" readonly="readonly" readonly="readonly" value="<%=  medExamObj.getRelevantFamilyHistory() %>" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100"/>
 <%}else{ %>
 <input	type="text" readonly="readonly" readonly="readonly" value="" name="<%=RELEVANT_FAMILY_HISTORY%>" tabindex="1" maxlength="100"/>
 <%} %>
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
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>	
		
	</tr>

</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Any evidence of Trachoma <br /> <span class="sublabel">(its complications
or any other disease)</span></label> 
<% if(medExamObj.getAnyOtherEyeDisease()!=null){%>
 <textarea readonly="readonly" rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" value="<%=medExamObj.getAnyOtherEyeDisease() %>"
	onkeyup="chkLength(this,30);"></textarea>
 <% }else{%>
<textarea readonly="readonly" rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large"
	onkeyup="chkLength(this,30);"></textarea>
 <% }%>
<div class="clear"></div>
<label class="large2">Binocular <br /> <span class="sublabel">vision & Grade</label>
<% if(medExamObj.getBinocularVisionGrade()!=null){%>
<input
	tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=BINOCULAR_VISION_GRADE %>" value="<%=medExamObj.getBinocularVisionGrade() %>"
	class="large" maxlength="50" />
 <% }else{%>
<input
	tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=BINOCULAR_VISION_GRADE %>"
	class="large" maxlength="50" />
 <% }%>
 	</div>
</div>	
<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="Block">
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>	
	 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	  <%}else{ %>
	    <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%} %>
<div class="clear"></div>
<label > Tympanic Membrance intact<br /><span class="sublabel">(Left)</span></label> 
<select name="<%=TYMPANIC_L %>" size="0" tabindex="1" id="tympanic_l" disabled="disabled" >
<option value="0">select</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	
</select>
<script>
<%
if(medExamObj.getTympanicL()!= null){
%>
document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

<%}%>
</script>
<label >Tympanic Membrance intact<br /><span class="sublabel">(Right)</span></label> 
<select name="<%=TYMPANIC_R %>" size="0" tabindex="1" id="tympanic_r" disabled="disabled">
<option value="0">select</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	
</select>
<script>
<%
if(medExamObj.getTympanicR()!= null){
%>
document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

<%}%>
</script>
 <label>Mobility <br /><span class="sublabel">(Valsalva)</span></label> 
	  	 <% if(medExamObj.getMobilityV() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" readonly="readonly"  name="<%=MOBILITYV %>" maxlength="100"  value="<%= medExamObj.getMobilityV()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly"  name="<%=MOBILITYV %>"  maxlength="100"  />
<%} %> 
<div class="clear"></div>
<label>Nose, Throat and Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="100"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="100"  />
<%} %>
<label>Audiometry Record <br /> <span class="sublabel">(If indicated)</span></label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="10"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="10"  />
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
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="upperLimbs" maxlength="20" value="<%=medExamObj.getUpperLimbs() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="upperLimbs" maxlength="20" 
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
<%} %>

<label class="auto"> Locomotion</label> 
<% if(medExamObj.getLocomotion() != null){ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="locomotion" maxlength="20" value="<%=medExamObj.getLocomotion() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="locomotion" maxlength="20" value="<%=medExamObj.getLocomotion() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
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
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>

<label	>Sports Man</label> 
  <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"   id="<%=SPORTS %>" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="<%=SPORTS %>" name="<%=SPORTS %>"  maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


</div>
</div>
<div class="clear paddingTop15"></div>
<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>

<label class="auto"> Chest Measurment</label>
<% if(medExamObj.getChestMeasurement() != null){ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="chestMeasurement" maxlength="20" value="<%=medExamObj.getChestMeasurement() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />


<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="chestMeasurement" maxlength="20" 
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

<%} %>
 
	<label class="auto"> Full Expiration</label> 
	<% if(medExamObj.getFullExpiration() != null){ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="fullExpiration" maxlength="20" value="<%=medExamObj.getFullExpiration() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="fullExpiration" maxlength="20" 
	onKeyUp="limitText(this,20);" class="auto" size="20"  />
 
<%} %>
	
	<label class="auto"> Abnormalities</label>
	<% if(medExamObj.getAbnormalities() != null){ %>
	<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="abnormalities" maxlength="20" value="<%=medExamObj.getAbnormalities() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="abnormalities" maxlength="20" 
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
<label > Albumen</label> 
<% if(medExamObj.getAlbumin()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=ALBUMIN %>" maxlength="20" value="<%=medExamObj.getAlbumin() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=ALBUMIN %>" maxlength="20" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>

<label class="auto"> Sugar</label> 
<% if(medExamObj.getSugar()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=SUGAR %>" maxlength="20" value="<%=medExamObj.getSugar() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="<%=SUGAR %>" maxlength="20" 	onKeyUp="limitText(this,20);"  class="auto" size="20" />

 <% }%>

<label class="auto"> Other Abnormalities</label> 
<% if(medExamObj.getAnyOtheAbnormalities()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="otherAbnormalities" maxlength="20" value="<%=medExamObj.getAnyOtheAbnormalities() %>"
	onKeyUp="limitText(this,20);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="otherAbnormalities" maxlength="20" 	onKeyUp="limitText(this,20);"  class="auto" size="20" />

 <% }%>

<div class="clear"></div>
<label >Any Evidence Of Skin</label> 
<% if(medExamObj.getAnyEvidenceOfSkin()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="anyEvidenceOfSkin" maxlength="100" value="<%=medExamObj.getAnyEvidenceOfSkin() %>"
	onKeyUp="limitText(this,100);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  id="bmi" name="anyEvidenceOfSkin" maxlength="100" 	onKeyUp="limitText(this,100);"  class="auto" size="20" />

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
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getPulseRates() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20" />
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getBp() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=BP1%>" class="Auto" size="22" maxlength="20" />
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
<label > CNS <br /><span class="sublabel">Central Nervous System</span></label> 
<% if(medExamObj.getCentralNervousSystem()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="centralNervousSystem" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getCentralNervousSystem() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="centralNervousSystem" class="Auto" size="22" maxlength="20" />
 <% }%>
<label > Abdomen</label> 
<% if(medExamObj.getAbdomen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=ABDOMEN %>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getAbdomen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=ABDOMEN %>" class="Auto" size="22" maxlength="20" />
 <% }%>

<label > Liver</label> 
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="liver" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getLiver() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="liver" class="Auto" size="22" maxlength="20" />
 <% }%>

<div class="clear"></div>
<label > Spleen</label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="spleen" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getSpleen() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="spleen" class="Auto" size="22" maxlength="20" />
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
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" readonly="readonly" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Points</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>" readonly="readonly"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" readonly="readonly"
	maxlength="2" />
 <% }%>
<label class="auto">Unsaveable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>" readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>" readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" readonly="readonly" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" readonly="readonly"
	class="small" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);" disabled="disabled"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label class="medium"> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" readonly="readonly" class="large" onkeyup="chkLength(this,150);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" readonly="readonly" class="large" onkeyup="chkLength(this,150);"></textarea>
 <% }%>

	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>
<div class="clear paddingTop15"></div>
<h4>MENTAL CAPACITY AND EMOTIONAL STABILITY <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=SPEECH %>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getSpeech() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="<%=SPEECH %>" class="Auto" size="22" maxlength="20" />
 <% }%>

<label >Mental Instability</label> 
<% if(medExamObj.getMentalInstability()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="mentalInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getMentalInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="mentalInstability" class="Auto" size="22" maxlength="20" />
 <% }%>

<label >Essential Instability</label> 
<% if(medExamObj.getEssentialInstability()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="essentialInstability" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getEssentialInstability() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" readonly="readonly" name="essentialInstability" class="Auto" size="22" maxlength="20" />
 <% }%>

<div class="clear"></div>
</div>

<div class="Clear paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<label >Smoker</label> 
<select name="smoker" tabindex="1" id="smoker" disabled="disabled">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<script>
<%
if(medExamObj.getSmoker()!= null){
%>
document.getElementById("smoker").value='<%=medExamObj.getSmoker()%>';

<%}%>
</script>
<label>Drinker</label> 
<select name="drinker" tabindex="1" id="drinker" disabled="disabled">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<script>
<%
if(medExamObj.getDrinker()!= null){
%>
document.getElementById("drinker").value='<%=medExamObj.getDrinker()%>';

<%}%>
</script>
<label>Allergies</label> 
<% if(medExamObj.getAllergies()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="allergies" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getAllergies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="allergies" class="Auto" size="20" maxlength="100" />
 <% }%>
<div class="clear"></div>
<label >Locomoter System</label> 
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="locomoterSystem" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="locomoterSystem" class="Auto" size="20" maxlength="10" />
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="spine" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="spine" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="100" />
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label> 
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Haemorrhoids</label> 
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Breast</label> 
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>
<label >Tympanic Membrance Intact</label> 
<% if(medExamObj.getTympanicMembranceIntact()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="tympanicMembranceIntact" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getTympanicMembranceIntact() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="tympanicMembranceIntact" class="Auto" size="20" maxlength="10" />
 <% }%>
<label>Mobility</label> 
<% if(medExamObj.getMobility()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="mobility" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getMobility() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="mobility" class="Auto" size="20" maxlength="10" />
 <% }%>
<label>Nose/Throat/Sinuses</label> 
<% if(medExamObj.getNoseThroatSinuses()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="noseThroatSinuses" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getNoseThroatSinuses() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly" maxlength="20" 	name="noseThroatSinuses" class="Auto" size="20" maxlength="10" />
 <% }%>
<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>Other <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div id="slide12">
<div class="Block">
<label class="auto">Slight Defects Not To Cause Rejection</label>
<% if(medExamObj.getDefectNotToCauseRejection()!=null){%>
<textarea readonly="readonly" rows="" cols="35" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" onkeyup="chkLength(this,200);" tabindex="1"><%=medExamObj.getDefectNotToCauseRejection() %></textarea>
   <% }else{%>
<textarea readonly="readonly" rows="" cols="35" class="auto" name="<%=DEFECTS_NOT_TO_CAUSE_REJECTION %>" onkeyup="chkLength(this,200);" tabindex="1"></textarea>
 <% }%>


<label class="auto">Found Fit In Category</label>
<% if(medExamObj.getFoundFitInCategory()!=null){%>
<textarea readonly="readonly" rows="" cols="35" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" onkeyup="chkLength(this,200);" tabindex="1"><%=medExamObj.getFoundFitInCategory() %></textarea>
   <% }else{%>
<textarea readonly="readonly" rows="" cols="35" class="auto" name="<%=FOUND_FIT_IN_CATEGORY %>" onkeyup="chkLength(this,200);" tabindex="1"></textarea>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<%	int count=1;
String Labresult="NotPresent";
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
	System.out.println("dgOrderdt.getId()---"+dgOrderdt.getId());%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
	
<%count++;}
    }
%>
<% if(medExamObj.getVisit() !=null){%>
<INPUT type=hidden value="<%=medExamObj.getVisit().getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">

<input type="button" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print"	class="button" accesskey="a" />
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
	<td><input type="text" name="clinicalNotes1" tabindex="1" size="100" maxlength="45" readonly="readonly" /></td>
	
	</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Test Result</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

<%int inc=1;
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
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc1=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
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
		    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	{   if(dgre.getSubInvestigation()!=null)
		    		val1=dgre.getSubInvestigation().getSubInvestigationName();
		    	if(!dgre.getResultType().equalsIgnoreCase("t"))
	    		{
		    		if(dgre.getResult()!=null)
		    			val2=dgre.getResult();
		    	    val=val+","+val1+":"+val2;
	    		}
		    	    investigationId=dgre.getInvestigation().getId();
		    		System.out.println("dgre---id---"+dgre.getInvestigation().getId());
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
		   // System.out.println("first---"+first);
		  // System.out.println("second---"+second);
		    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
         //   System.out.printf("key: %s, value: %s\n", key, first.get(key));
            
		    

		    %>
	<tr>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="100" name="chargeCodeName<%=inc %>" />
</td>
<%

if(second.get(first.get(key))!=null)
	{ 
	Labresult="present";
//	System.out.println("template---"+template);
//	System.out.println("value---"+second.get(first.get(key)));
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{%>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }else{%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>
	
<%}}else{%>
<td><input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
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

		</td>
<td>
<input type="text" value="" readonly="readonly" name="Result" id="Result" />
</td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	

<% }%>


</table>
</div>
</div>



<div class="Block">
<label >Final Observation</label> 
<% if(medExamObj.getFinalObservation()!=null){%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" value="<%=medExamObj.getFinalObservation() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" readonly="readonly"  	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" />
 <% }%>
<label >Med.Cat.Rec.</label> 

<select name="<%=MED_CAT_REC %>" size="0" tabindex="1" id="medcatrec" disabled="disabled">
<option value="0">select</option>
	<option value="A1 G1">A1 G1</option>
	<option value="A1 G2">A1 G2</option>
	<option value="A1 G2">A1 G3</option>
	<option value="A1 G2">A1 G4</option>
</select>
<script>
<%
if(medExamObj.getMedCatRec()!= null){
%>
document.getElementById("medcatrec").value='<%=medExamObj.getMedCatRec()%>';

<%}%>
</script>

<label >Signed By</label> 

<select id="signidBy" value="<%=medExamObj.getSignedBy() %>" disabled="disabled"	name="<%= SIGNED_BY %>"	validate="Signed By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user1 = (Users)session.getAttribute("users");
		Integer userId1 =user1.getEmployee().getId();
		String mname1=" ";
		System.out.println("employeeListjsp--"+employeeList.size());
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					//if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
					
			//	if ((medExamObj.getSignedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getSignedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname1=masEmployeecode.getMiddleName();
					}
				%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{%><option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}
				//}	
					//}
				}	%>
</select> 

<div class="clear"></div>
<label >Approved By</label>

<select id="<%=APPROVED_BY %>"	name="<%= APPROVED_BY %>" 	validate="Approved By,string,no" tabindex=1 disabled="disabled">
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
		String mname=" ";
		System.out.println("employeeListjsp--"+employeeList.size());
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
		//			if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
						System.out.println("userId1---"+userId1);	
						System.out.println("masEmployeecode.getId()---"+masEmployeecode.getId());	
						System.out.println("medExamObj.getApprovedBy()---"+medExamObj.getApprovedBy());	
		//				if ((medExamObj.getApprovedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getApprovedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname=masEmployeecode.getMiddleName();
					}
					System.out.println("hi");
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{
		System.out.println("hi1");
		%>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}
		//}
		//}
		}	%>
</select> 
  

<label >Send To anuj</label> 

<select name="<%=SEND_TO %>" size="0" tabindex="1" id="sendto" disabled="disabled">
	<option value="0">select</option>
	<option value="AFRO">AFRO</option>
	<option value="MO">MO</option>
	<option value="DPMO">DPMO</option>
	<option value="CO/ST CDR">CO/ST CDR</option>
	<option value="No">No</option>
</select>
<script>

<% if(medExamObj.getRank()!=null){
	  String rankName=medExamObj.getRank().getRankName();
	  if(rankName.equalsIgnoreCase("SGT")||rankName.equalsIgnoreCase("CPL")||rankName.equalsIgnoreCase("AC")||rankName.equalsIgnoreCase("LAC")){
%>  
	  document.getElementById('sendto').value='AFRO';
		<%}else if(rankName.equalsIgnoreCase("JWO")||rankName.equalsIgnoreCase("WO")||rankName.equalsIgnoreCase("MWO")){%>
		
		 document.getElementById('sendto').value='DPMO';
	  <% }else {%>
		
		 document.getElementById('sendto').value='DPMO';
	  <% }}%>

</script>


  </div>



<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" /></form>

<div class="clear"></div>
<div class="division"></div>
<% if(search.equalsIgnoreCase("false")){%>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('medicalExamPrimaryExtn','medicalExam?method=rejectMedExam');" />
   <% }%>
  <input	type="hidden"  name="visitId"	tabindex="2" value="<%=visitId %>"/>

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
		  	
				submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
				}
	
	}

  function checkTemplateId(templateId){
		
      if(templateId=="0"){
        return true;
      }else{
        return true;
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
	    submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}

 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalExamPrimaryExtn','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}
	 }
 function submitdata()
	{
		
		var charge=document.getElementById("chargeCodeName1").value;
  if(charge=="")
  {
   alert("Please Select Test Name");   
  }else{
  	submitForm('medicalExamPrimaryExtn','medicalExam?method=addMedicalExaminationBoardAnnual');
  }
	}
 function coolDental()
	{
	 var dentalValue=document.getElementById('dentalValueId').value;
	 
	 var mySplitResult = dentalValue.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 document.getElementById(mySplitResult[i]).checked="checked";
		
	 }
	
	}
</script></form>
</body>