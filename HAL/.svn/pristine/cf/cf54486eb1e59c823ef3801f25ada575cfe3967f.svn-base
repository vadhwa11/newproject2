
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

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
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>


<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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


</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
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
List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");
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

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}

List<MasServiceType> serviceTypeList =null;
List<MasState> stateList = null;
List<MasMaritalStatus> maritalStatusList = null;
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
if(map.get("stateList") != null)	{
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
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
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
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

List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
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
<h2>AFMSF-18</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalBoardExaminationReleaseDischargePAAFRO" action="" method="post">
<!--Block One Starts-->
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>

<div class="clear"></div>
<div class="Block">
<label>Authority for Board</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text"   readonly="readonly" name="<%=AUTHORITY_OF_BOARD %>" value="<%=medExamObj.getAuthority() %>" />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=AUTHORITY_OF_BOARD %>"  />
 <% }%>

 <label>Place  </label>
 <% if(medExamObj.getPlace()!=null){%>
<input tabindex="1" type="text" class="auto" size="27" maxlength="20" readonly="readonly" name="<%=PLACE %>" value="<%=medExamObj.getPlace() %>" />
 <% }else{%>
<input tabindex="1" type="text" class="auto" size="27" maxlength="20" readonly="readonly" name="<%=PLACE %>" />
 <% }%>

  <label>Date </label>
  <% if(medExamObj.getDateDischarge()!=null){%>
<input	tabindex="1" name="<%=DATE_DISCHARGE %>" readonly="readonly"   value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateDischarge())%>"
	 />
 <% }else{%>
<input	tabindex="1" name="<%=DATE_DISCHARGE %>" value="<%=date %>"  readonly="readonly" />
 <% }%>
 <div class="clear"></div></div><div class="clear"></div>
 <div class="Block">
  <label>Date of Release  </label>
  <% if(medExamObj.getDateRelease()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" readonly="readonly"   value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateRelease())%>"
		 />
 <% }else{%>
  <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" readonly="readonly"   value="<%=date %>" />
 <% }%>

<label>Name  </label>
  <input	type="text" value="<%= visit.getHin().getSFirstName() %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" maxlength="100" readonly="readonly"/>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" maxlength="100" />
<% }else{%>
 <input type="hidden"	value="Med. Exam On Release/Discharge(AFMSF-18)"  name="medicalExamType" tabindex="2" maxlength="100" />
<% }%>
<%
int medExamId = 0;
if(medExamObj.getId()!= null){

	medExamId = medExamObj.getId();
}
%>
 <label>Service No.</label>
 <input type="text"	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=visit.getHin().getServiceNo()%>" readonly="readonly"/>
 <div class="clear"></div>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>" readonly="readonly"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="100" />

  <label>DOB </label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	 />

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>"   value="<%=date %>" />
	<% }%>
 <label>Unit/Ship  </label>
  <input	type="text" readonly="readonly" value="<%= visit.getHin().getUnit().getUnitName() %>" name="<%=UNIT%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" maxlength="20" />
 <div class="clear"></div>
 <label>Service   </label>
 <input	type="text" readonly="readonly" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <label>Branch/Trade  </label>
 <% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>" readonly="readonly"	tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />
 <% }else{%>
 <input	type="text"  name="<%=TRADE%>" readonly="readonly"	tabindex="2"  maxlength="20" />
 <% }%>

 <label>Total Service  </label>
 <% if(medExamObj.getTotalService()!=null){%>
 <input	type="text" maxlength="20" readonly="readonly"  value="<%=visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	tabindex="2" />
 <% }else{%>
<input	type="text" maxlength="20" readonly="readonly" value="" name="<%=TOTAL_SERVICE%>"	tabindex="2" />

 <% }%>
 <div class="clear"></div>
<label>Marital Status</label>
 <% if(visit.getHin().getMaritalStatus()!=null){%>
 <input	type="text" maxlength="20" readonly="readonly" value="<%=visit.getHin().getMaritalStatus().getMaritalStatusName() %>" name="mariralStatus"	tabindex="2" />

 <% }else{%>
<input	type="text" maxlength="20" readonly="readonly" value="" name="mariralStatus"	tabindex="2" />
 <% }%>
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
 <label >Past Medical History</label>
 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 <input	type="text"  name="<%=PAST_MEDICAL_HISTORY%>" readonly="readonly"	tabindex="2"  value="<%=medExamObj.getPastmedicalhistory() %>" maxlength="20"/>
  <% }else{%>
<input	type="text"  name="<%=PAST_MEDICAL_HISTORY%>" readonly="readonly"	tabindex="2" maxlength="20" />
 <% }%>

 <div class="clear"></div>
 <label >Identification Marks</label>
 <% if(visit.getHin().getSrIdentificationMark1()!=null){%>
<label class="valueAuto">1</label><input tabindex="1" type="text" maxlength="50"  name="<%=IDENTIFICATION_MARKS1 %>" value="<%=visit.getHin().getSrIdentificationMark1() %>"
	 class="auto" size="72"  readonly="readonly"/>

 <% }else{%>
<label class="valueAuto">1</label><input tabindex="1" type="text" maxlength="50"  name="<%=IDENTIFICATION_MARKS1 %>"
	 class="auto" size="72"  readonly="readonly"/>

 <% }%>
<div class="clear"></div>
<input class="transparent" size="28">
<% if(visit.getHin().getSrIdentificationMark2()!=null){%>
<label class="valueAuto">2</label><input tabindex="1" type="text" maxlength="50"  name="<%=IDENTIFICATION_MARKS2 %>" value="<%=visit.getHin().getSrIdentificationMark2() %>"
	 class="auto" size="72" />

 <% }else{%>
<label class="valueAuto">2</label><input tabindex="1" type="text" maxlength="50"  name="<%=IDENTIFICATION_MARKS2 %>"
	 class="auto" size="72"  />

 <% }%>
</div>
<div class="clear paddingTop15"></div>
<h4> SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col">From</TH>
<TH scope="col">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
</tr>
<% int inc1=0;

if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail"))
	{
		inc1=inc1+1;
	%>

<tr>
<% if(setMedicalExam.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO+inc1 %>"  value="<%=inc1 %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO+inc1 %>"  /></td>
<% }%>
<% if(setMedicalExam.getAddressfrom()!=null){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>"  value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressfrom()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>"  />
<% }%>
</td>
<% if(setMedicalExam.getAddressto()!=null ){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>"  value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>"  />
</td>
<% }%>
<% if(setMedicalExam.getPlace()!=null && ! setMedicalExam.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=PLACE+inc1 %>"  value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=PLACE+inc1 %>"  /></td>
<% }%>
<% if(setMedicalExam.getPno()!=null && ! setMedicalExam.getPno().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=P_NO+inc1 %>"  value="<%=setMedicalExam.getPno() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=P_NO+inc1 %>"  /></td>
<% }%>

</tr>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=setMedicalExam.getServiceid()%>" id="serviceId" />
<%
	}
}}else{
inc1=1;%>
<tr>
<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" value=<%=inc1%>  /></td>
<td width="10%">
<input tabindex="1" type="text" readonly="readonly"	name="<%=FROM+inc1 %>"  />
</td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=TO+inc1 %>"  />
</td>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=PLACE+inc1 %>"  /></td>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=P_NO+inc1 %>"  /></td>
</tr>
<% }%>
<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" />

</table>
<div class="clear"></div>
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>
<h4> PREVIOUS SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
 <label class="auto">Particulars of Previous Service </label>

  <% if(medExamObj.getParticularOfPreviousService()!=null){%>

<textarea rows="" cols="50" class="auto" disabled="disabled"  	name="particularOfPreviousService" class="large" 
onkeyup="chkLength(this,150);"    onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"><%=medExamObj.getParticularOfPreviousService() %></textarea>
 <% }else{%>
<textarea rows="" cols="50" class="auto"  disabled="disabled"	name="particularOfPreviousService" class="large" 
onkeyup="chkLength(this,150);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>
 <% }%>
<label class="auto">Disability Pension Received</label>
<select name="<%=DISABILITY %>" size="0" tabindex="1" disabled="disabled" id="disabilityPension">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisabilitybefore()!= null){
%>
document.getElementById('disabilityPension').value='<%=medExamObj.getDisability()%>';

<%}%>
</script>
</div>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4> PERSONAL STATEMENT SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>

<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col">Illness/wound</TH>
<TH scope="col" >First Started on</TH>
<TH scope="col">First Started at</TH>
<TH>Where Treated</TH>
<th colspan="2">Approximate Dates and Periods Treated</th>
</tr>
<% int inc11=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

	if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		if(setMedicalExam.getBeforeDisability()!=null && !setMedicalExam.getBeforeDisability().equals("") && setMedicalExam.getBeforeDisability().equalsIgnoreCase("n")){
		inc11=inc11+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=ILLNESS+inc11 %>"  value="<%=setMedicalExam.getIllness() %>"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=ILLNESS+inc11 %>"  /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" readonly="readonly"   value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	 id="particulardate"
	 />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>"   readonly="readonly"	 id="particulardate" value="<%=date %>"
	 />
 <% }%>
 </td>

 <% if(setMedicalExam.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" readonly="readonly"  value="<%=setMedicalExam.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" readonly="readonly"  /></td>
 <% }%>

 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" readonly="readonly"  value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" readonly="readonly"  /></td>
 <% }%>

<td width="20%">
 <% if(setMedicalExam.getApproximatedate1()!=null){  %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>"  readonly="readonly" id="approximatedate" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getApproximatedate1())%>"	 maxlength="30"
	 />
  <% }else{%>
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" readonly="readonly" id="approximatedate" size="11"	 maxlength="30" />
 <% }%>
  </td>
 <td width="20%">
 <% if(setMedicalExam.getApproximatedate2()!=null){  %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" readonly="readonly" id="<%=APPROXIMATE_DATE2+inc11 %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getApproximatedate2())%>"	 maxlength="30"	 />
<%}else{ %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" readonly="readonly" id="<%=APPROXIMATE_DATE2+inc11 %>" size="11" value=""	 maxlength="30"	 />

<%} %>
  </td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
}}}}else{
inc11=1;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>"/></td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=ILLNESS+inc11 %>"  /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>"   readonly="readonly" id="particulardate" value="<%=date %>"
	 />

</td>

<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" readonly="readonly"  /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" readonly="readonly"  /></td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" readonly="readonly" id="approximatedate" size="40"	 maxlength="30" value=""
	/>
</td>
</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>
<%
String displayStyle="";
String displayValue="";
if(medExamObj.getDisabilitybefore()!=null){
	displayValue=medExamObj.getDisabilitybefore();
	if(displayValue.equalsIgnoreCase("yes")){
		displayStyle="inline";
	}else{
		displayStyle="none";
	}
}else{
	displayStyle="none";
}
%>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
  <label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
 <!--changes made by anshu-->
 <select name="<%=DISABILITY_BEFORE%>" tabindex="1" disabled="disabled" id="<%=DISABILITY_BEFORE%>" onchange="displayAfterDisabilityGrid(this.value);">
 <option value="">Select</option>
  <option value="No">No</option>
 <option value="Yes">Yes</option>
  </select>
  <script type="text/javascript">
document.getElementById('disabilitybefore').value ='<%=displayValue%>';
</script>
 </div>
 <div class="clear"></div>
<div style="display: <%=displayStyle%>;" id="beforeDisabilityDiv" class="cmntable">
<table cellspacing="0" cellpadding="0" border="0" align="center" id="gridIllness">
	<tbody><tr>
<th rowspan="" scope="col">Sl No.</th>
<th scope="col" rowspan="">Illness/Wound/Injury Details</th>
<th scope="col" rowspan="" colspan="2">First Started on</th>
<th scope="col" >First Started at</th>
<th>Where Treated</th>
</tr>


<%int j = 0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	String icdName = "";


	//if(principal!=""){
		//principal=principal+"["+icdId+"]";
	//}

	if(setMedicalExam.getBeforeDisability()!=null && !setMedicalExam.getBeforeDisability().equals("") && setMedicalExam.getBeforeDisability().equalsIgnoreCase("y")){
		j=j+1;
		if(setMedicalExam.getSystemDiagnosis()!=null){
			icdName = setMedicalExam.getSystemDiagnosis().getSystemDiagnosisName()	+ "["
			+ setMedicalExam.getSystemDiagnosis().getId()
			+ "]";
		}
%>

<tr>
<% if(setMedicalExam.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SR_NO+j %>" maxlength="2" value="<%=setMedicalExam.getSerialno() %>"/></td>
<%}else{ %>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SR_NO+j %>" maxlength="2" value="<%=j %>"/></td>

<%} %>
<td width="10%"><input type="text" tabindex="1"	value="<%=icdName %>" readonly="readonly" id="<%=ICD_ID+j%>"  name="<%=ICD_ID+j%>"	class="auto"  size="30"
<%-- onblur="checkDisability(this.value,<%= inc11%>);--%>/>
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		 new Ajax.Autocompleter('<%=ICD_ID+j%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=ICD_ID+j%>'});
		 </script>
</td>
<%if(setMedicalExam.getParticulardate() != null){ %>
<td width="10%">
<input name="pDate<%=j %>" onkeyup="mask(this.value,this,'2,5','/');" readonly="readonly" value="<%=HMSUtil.convertDateToStringTypeDateOnly(setMedicalExam.getParticulardate()) %>" id="pDate<%=j %>"  validate="First Started on,date,no" size="15"  tabindex="1">
</td>
<%}else{ %>
<td width="10%">
<input name="pDate<%=j %>" onkeyup="mask(this.value,this,'2,5','/');" readonly="readonly" value="" id="pDate<%=j %>"  validate="First Started on,date,no" size="11"  tabindex="1">
</td>
<%} %>
<td>
  <img width="16" border="0" height="16" onclick="setdate('',medicalBoardExaminationReleaseDischarge.pDate<%=j %>,event);" class="calender" validate="Pick a date" src="/hms/jsp/images/cal.gif">
</td>
<%if(setMedicalExam.getPlace() != null){ %>
<td width="10%"><input type="text"  readonly="readonly" value="<%=setMedicalExam.getPlace() %>" name="particularPlace<%=j %>" tabindex="1"></td>
<%}else{ %>
<td width="10%"><input type="text"  readonly="readonly" value="" name="particularPlace<%=j %>" tabindex="1"></td>
<%} %>
<%
String beforeDisability="";
if(setMedicalExam.getBeforeDisability()!=null){
	beforeDisability=setMedicalExam.getBeforeDisability();
}else{
	beforeDisability="y";
}
%>
<%if(setMedicalExam.getTreated()!= null){ %>
<td width="10%"><input type="text"  readonly="readonly" value="<%=setMedicalExam.getTreated() %>" name="whereTreated<%=j %>" tabindex="1"></td>
<%}else{ %>
<td width="10%"><input type="text"  readonly="readonly" name="whereTreated<%=j %>" tabindex="1"></td>
<%} %>
<input type="hidden"  id="beforeDisability11<%=j %>" name="beforeDisability11<%=j %>"  value="y" />
<input type=hidden name="<%=SERVICEID+j%>" value="<%=setMedicalExam.getServiceid()%>"  />

</tr>
<%}}}
if(j<=0){
	j=1;

	%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SR_NO+j %>" maxlength="2" value="<%=j %>" /></td>
<td width="10%"><input type="text" tabindex="1"	value="" id="<%=ICD_ID+j%>"  name="<%=ICD_ID+j%>"	class="auto"  size="30"
<%-- onblur="checkDisability(this.value,<%= inc11%>);--%> />
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		 new Ajax.Autocompleter('<%=ICD_ID+j%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=ICD_ID+j%>'});
		 </script>
		 </td>
<td width="10%">
<input name="pDate<%=j %>" onkeyup="mask(this.value,this,'2,5','/');" readonly="readonly" value="" id="pDate<%=j %>"  validate="First Started on,date,no" size="15"  tabindex="1">
</td>
<td>
  <img width="16" border="0"  height="16"  onclick="setdate('',medicalBoardExaminationReleaseDischarge.pDate<%=j %>,event);" class="calender" validate="Pick a date" src="/hms/jsp/images/cal.gif">
</td>
<td width="10%"><input type="text"  readonly="readonly" name="particularPlace<%=j %>" tabindex="1" /></td>

<td width="10%"><input type="text"  readonly="readonly" name="whereTreated<%=j %>" tabindex="1">

<input type="hidden"  id="beforeDisability11<%=j %>" name="beforeDisability11<%=j %>"  value="y" />
</td>
<%} %>
</tr>

</tbody></table>
<input type="hidden" id="hdbBefore" value="<%=j %>" name="hdbBefore" />
</div>

<div class="clear"></div>
<div class="Block">
<label class="large">Whether Disability claimed due to service</label>
<select name="<%=CLAMING_DISABILITY %>" disabled="disabled" size="0" tabindex="1" id="clamingdisability">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getClamingdisability()!= null){
%>
document.getElementById('clamingdisability').value='<%=medExamObj.getClamingdisability()%>';

<%}%>
</script>
 <div class="clear"></div>
<label class="large">Other Health Information</label>

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" class="auto" cols="85"   name="<%=OTHER_INFORMATION %>" readonly="readonly"  onkeyup="chkLength(this,50);" 
  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" class="auto" cols="85"  name="<%=OTHER_INFORMATION %>" readonly="readonly"  onkeyup="chkLength(this,50);"
   onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>
 <% }%>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>Dental <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" readonly="readonly" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" readonly="readonly" id="dentalValueId" value=""/>
<%} %>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>

 <input tabindex="1"	type="text" readonly="readonly"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	 maxlength="2" />

 <% }else{%>
<input tabindex="1"	type="text" readonly="readonly" name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	 maxlength="2" />

 <% }%>


<label class="medium3">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text" readonly="readonly"  name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	 maxlength="2" />


 <% }else{%>
<input tabindex="1"	type="text" readonly="readonly" name="<%=DEFECTIVE_TEETH %>" class="small"  maxlength="2" />

 <% }%>
	<label class="medium3">Total no. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text" class="small" name="<%=DENTSL_POINT %>" readonly="readonly" value="<%=medExamObj.getDenstlPoint() %>"
	maxlength="2" />


 <% }else{%>
	<input	tabindex="1" type="text" readonly="readonly" name="<%=DENTSL_POINT %>"
	maxlength="2" />


 <% }%>

	<div class="clear"></div>

<label >Missing </label>
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" readonly="readonly" class="small" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" readonly="readonly" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="medium3">Unsaveable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text" readonly="readonly"  name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>" readonly="readonly"
	class="small" maxlength="2" />

 <% }%>
 <label class="medium3">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="small"  readonly="readonly" id="txtAlpha" maxlength="2"  />


 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" class="small"  readonly="readonly" id="txtAlpha" maxlength="2" />

 <% }%>
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" disabled="disabled" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" disabled="disabled" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" disabled="disabled" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" disabled="disabled" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6" disabled="disabled"  onclick="chkValue(this);" />
<label class="smallAuto">3</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">2</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" disabled="disabled" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" disabled="disabled" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17" disabled="disabled"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18" disabled="disabled"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" disabled="disabled" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" disabled="disabled" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" disabled="disabled" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" disabled="disabled" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" disabled="disabled" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" disabled="disabled" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" disabled="disabled" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" disabled="disabled" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" disabled="disabled" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" disabled="disabled" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54"  disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
<div class="clear"></div>
<label> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="60"	name="<%=DENTAL_REMARKS %>" class="auto" disabled="disabled" onkeyup="chkLength(this,299);"
	   onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60"	name="<%=DENTAL_REMARKS %>" disabled="disabled" class="auto" onkeyup="chkLength(this,299);"
 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>
 <% }%>
 <label class=""> Refer to MH</label>
<%	if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){ %>

	<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" checked="checked" class="radioAuto" disabled="disabled" id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%}else
		{%>
		<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH" disabled="disabled" onclick="checkForDentalMH();"/>
	<%} %>
	<div class="clear"></div>
	</div>

</div>
<div class="clear"></div>
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

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
<tr>
	<th scope="col">Investigation</th>
	<th scope="col">Refer to MH</th>
	<th scope="col">Result</th>
	<th scope="col">File Upload</th>
	<%---
	<th scope="col">Add</th>
    <th scope="col">Delete</th> --%>
</tr>

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
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
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
	   
	   int in1=1;
	   
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
		      	if(resultList.size()>0 && in1<=resultList.size())
		    	{
		    	 DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(in1-1);
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Dipali 
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
		    	++in1;
		    	//
		    }

			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
		    %>
	<tr>

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
<td><input type="text" value="<%=key%>" readonly="readonly"	tabindex="2" id="chargeCodeName<%=inc %>"
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
		
<td> <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y"  
	id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
</td><%}else{ %>
<td> <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
onclick="checkForInvestigationMH(<%=inc %>);" />
<%} %>
<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly" tabindex="2" id="Result<%=inc %>"
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
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="VIEW REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
<%--<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
	 --%>
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
<%---
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
 --%>

	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>

<div class="clear paddingTop15"></div>


<h4> PHYSICAL CAPACITY<a href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<label>Height</label> <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="auto" size="10"
	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" readonly="readonly"
	value="<%=medExamObj.getHeight() %>" maxlength="5"
	onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label
	class="unit">cm</label> <% }else{%> <input tabindex="1" type="text"
	id="height" class="auto" size="10" name="<%=HEIGHT_WITHOUT_SHOOSE %>"
	onkeyup="isNumber1(this)" maxlength="5" readonly="readonly"
	onblur="calculateIdealWeight();checkForWiegth(this.value,id);calculateBMI();" /><label
	class="unit">cm</label> <% }%> <label>Weight</label> <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text" id="weight" class="auto" size="10"
	name="<%=ACTUAL_WEIGHT %>" maxlength="5" readonly="readonly"
	value="<%=medExamObj.getActualweight() %>" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label
	class="unit">kg</label> <% }else{%> <input tabindex="1" type="text"
	id="weight" class="auto" size="10" name="<%=ACTUAL_WEIGHT %>"
	maxlength="5" onKeyUp="limitText(this,6);" readonly="readonly"
	onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label
	class="unit">kg</label> <% }%> <label>Ideal Weight</label> <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" id="idealWeightId" readonly="readonly"
	name="<%=IDEAL_WEIGHT %>" class="auto" size="10" maxlength="5" readonly="readonly"
	value="<%=medExamObj.getIdealweight() %>" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label
	class="unit">kg</label> <% }else{%> <input tabindex="1" type="text" readonly="readonly"
	id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"
	maxlength="5" onKeyUp="limitText(this,6);"
	onblur="checkForWiegth(this.value,id);calculateOverWeight();" readonly="readonly"/><label
	class="unit">kg</label> <% }%>

<div class="clear"></div>
<label	>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" size="10" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto"	maxlength="3" value="<%=medExamObj.getOverweight() %>"
	readonly="readonly" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" size="10" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto"	maxlength="3"
	readonly="readonly" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>
 <label	>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" size="10"  name="<%=BHI %>" maxlength="5" value="<%=medExamObj.getBhi() %>"
readonly="readonly" class="auto" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="5"
	readonly="readonly" size="10"  class="auto"  /><label class="unit">Kg/m<sup>2</sup></label>

 <% }%>


<label	>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  id="" name="<%=BODY_FAT %>"maxlength="10" value="<%=medExamObj.getBodyfat() %>"
	readonly="readonly" class="auto" size="10"  /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=BODY_FAT %>" maxlength="10"
	readonly="readonly"  class="auto" size="10" /><input class="transparent" size="6">

 <% }%>
<div class="clear"></div>


<label	>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="4" value="<%=medExamObj.getWaist() %>"
	readonly="readonly" onblur="calculateWHR();" class="auto" size="10"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="4"
	readonly="readonly" onblur="calculateWHR();" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>

<label	>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="4" value="<%=medExamObj.getHips() %>"
	readonly="readonly" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="4"
	readonly="readonly" onblur="calculateWHR();" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>

<label	>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="4"  id="WHR" name="WHR"  value="<%=medExamObj.getWhr() %>"
	readonly="readonly" class="auto" size="10" /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" maxlength="4"  id="WHR" name="WHR" readonly="readonly" class="auto" size="10"  /><input class="transparent" size="6">

 <% }%>
 <div class="clear"></div>


<label	>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  id="" name="<%=THICKNESS %>" maxlength="5" value="<%=medExamObj.getSignfoldthickness() %>" readonly="readonly" class="auto" size="10"  /><input class="transparent" size="6">

 <% }else{%>

<input tabindex="1" type="text" id="" name="<%=THICKNESS %>" maxlength="5" readonly="readonly"  class="auto" size="10" />
<input class="transparent" size="6">

 <% }%>

<label	>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	readonly="readonly" class="auto" size="10"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6"
	readonly="readonly" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5" value="<%=medExamObj.getRangeofexpansion() %>" readonly="readonly" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="5"
	readonly="readonly" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>



<div class="clear"></div>
<label>Sportsman</label>
 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" class="smaller" validate="Sports Man,stirng,no" readonly="readonly">
<option value="">Select</option>
<%String sportsman="";
if(medExamObj.getSportman() !=null){
	sportsman=medExamObj.getSportman();
}
%>
<%if(sportsman.equalsIgnoreCase("Yes")){ %>
<option value="Yes" selected="selected">Yes</option>
<option value="No">No</option>
<%}else if(sportsman.equalsIgnoreCase("No")){ %>
<option value="Yes">Yes</option>
<option value="No" selected="selected">No</option>
<%}else{ %>
<option value="Yes">Yes</option>
<option value="No">No</option>
<%} %>
</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>

</div>
</div>


<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%=PULSE_RATES%>" class="auto" size="18"   value="<%=medExamObj.getPulseRates() %>"/><label class="unit">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%=PULSE_RATES%>" class="auto" size="18"  value="Normal" /><label class="unit">/min</label>
 <% }%>
 <label>BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="18" readonly="readonly"  name="<%=BP1%>" class="auto" size="18"   value="<%=medExamObj.getBp() %>"/><label class="unit">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%=BP1%>" class="auto" size="18"  value="Normal" /><label class="unit">mm Hg</label>
 <% }%>
<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="18" readonly="readonly"	name="<%= ARTERIAL_WALLS%>" class="auto" size="18"   value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly"	name="<%= ARTERIAL_WALLS%>" class="auto" size="18"  value="Normal" />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="18" readonly="readonly"	name="<%= HEART_SIZE%>" class="auto" size="27"  value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" maxlength="18" readonly="readonly"	name="<%= HEART_SIZE%>" class="auto" size="27" value="Normal" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%= SOUND%>" class="auto"	size="28"  value="<%=medExamObj.getSounds() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%= SOUND%>" class="auto"	size="28" value="Normal"  />
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="18" readonly="readonly" name="<%= RHYTHM%>" class="auto"	size="18"  value="<%=medExamObj.getRhythm() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="18"  name="<%= RHYTHM%>" class="auto"	size="18"  value="Regular"  />
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<label > Liver </label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" maxlength="120" readonly="readonly"	name="liver" class="auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="liver" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>
<div class="clear"></div>
<label > Spleen </label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" maxlength="120" readonly="readonly"	name="spleen" class="auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="120" readonly="readonly"	name="spleen" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>


<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label>
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly" 	name="<%=HIGHER_MENTAL_FUNCTION %>" maxlength="20" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=HIGHER_MENTAL_FUNCTION %>" maxlength="20" value="Normal"/>
 <% }%>

<label > Speech</label>
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=SPEECH %>"  maxlength="20" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=SPEECH %>"  maxlength="20" value="Normal"/>
 <% }%>


<label > Reflexes</label>
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=REFLEXES %>"  maxlength="20" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=REFLEXES %>" maxlength="20" value="Normal"/>
 <% }%>


<div class="clear"></div>
<label > Tremors</label>
<% if(medExamObj.getTremors()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=TREMORS %>" maxlength="20" value="<%=medExamObj.getTremors() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=TREMORS %>" size="20" maxlength="20" />
 <% }%>



<label > Self Balancing Test</label>

<select name="<%=SELF_BALANCING_TEST %>" disabled="disabled" size="0" tabindex="1" id="selfbalancingtest">
<option value="0">select</option>
	<option value="Fairly">Fairly Steady</option>
	<option value="Unsteady">Unsteady</option>
</select>
<script>
<%
if(medExamObj.getSelfBalancingTest()!= null){
%>
document.getElementById("selfbalancingtest").value='<%=medExamObj.getSelfBalancingTest()%>';

<%}%>
</script>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label >Locomotor System</label>
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text"	name="locomoterSystem" readonly="readonly"   value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="locomoterSystem"   value="NAD"/>
 <% }%>
<label>Spine</label>
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="spine"   value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="spine"   value="NAD"/>
 <% }%>


<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HERNIA_MUSCLE %>"   value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HERNIA_MUSCLE %>"  value="NIL"/>
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label>
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HYDROCELE %>"   value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HYDROCELE %>"   value="NIL"/>
 <% }%>


<label>Haemorrhoids</label>
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HEMONHOIDS %>"   value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=HEMONHOIDS %>"   value="NIL"/>
 <% }%>


<label>Breast</label>
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="<%=BREASTS %>"   value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=BREASTS %>"   value="NAD"/>
 <% }%>



<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide13')"></a></h4>
<div class="clear"></div>
<div id="slide13">
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
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_DISTANT_R %>"  value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_DISTANT_R %>"  />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_DISTANT_L %>"  value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_DISTANT_L %>"  />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_NEAR_R %>"  value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_R %>"  />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_NEAR_L %>"  value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_NEAR_L %>"  />
 <% }%>
 </td>

 	<td width="10%" rowspan="2" >

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_CP %>"  value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITHOUT_GLASSES_NEAR_CP %>"  />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_DISTANT_R %>"  value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_DISTANT_R %>"  />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_DISTANT_L %>"  value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_DISTANT_L %>"  />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_NEAR_R %>"  value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_NEAR_R %>"  />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_NEAR_L %>"  value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_NEAR_L %>"  />
 <% }%>
 </td>
	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide14')"></a></h4>
<div class="clear"></div>
<div id="slide14">


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
				<input tabindex="1" type="text" maxlength="20" readonly="readonly"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
					<%}else{ %>
					<input tabindex="1" type="text" value="600"  maxlength="20" readonly="readonly"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

					<%} %>
					cm

			</td>

			<td>
				<% if(medExamObj.getEarHearingLfw() != null){ %>
				<input tabindex="1" type="text" maxlength="20" readonly="readonly"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
					<%}else{ %>
					<input tabindex="1" type="text" value="600" maxlength="20" readonly="readonly" id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />

					<%} %>
					cm


			</td>

			<td>
					<% if(medExamObj.getEarHearingBothFw() != null){ %>
					<input tabindex="1" type="text" maxlength="20" readonly="readonly" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
				<%}else{ %>
						<input tabindex="1" value="600" type="text" maxlength="20" readonly="readonly" id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

					<%} %>
					cm
			</td>

	</tr>


	<tr>

			<th>CV</th>

			<td>
				<% if(medExamObj.getHearingRcv() != null){ %>
				 <input tabindex="1" type="text" maxlength="20" readonly="readonly" id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
				<%}else{ %>
					 <input tabindex="1" value="600" type="text" maxlength="20" readonly="readonly" id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
					<%} %>
					cm
			</td>

			<td>
				 <% if(medExamObj.getHearingLcv() != null){ %>
					  <input tabindex="1" type="text" maxlength="20" readonly="readonly" id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
					  <%}else{ %>
					    <input tabindex="1" value="600" type="text" maxlength="20" readonly="readonly" id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
					  <%} %>
					  cm
			</td>

			<td>
					  	 <% if(medExamObj.getHearingBothCv() != null){ %>
					  <input tabindex="1" type="text" maxlength="20" readonly="readonly" id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
				<%}else{ %>
				 <input value="600" tabindex="1" type="text" maxlength="20" readonly="readonly" id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
				<%} %>
				cm
			</td>

	</tr>

	<tr>

			<th>TM</th>

			<td>
					<select name="<%=TYMPANIC_L %>" class="smaller" disabled="disabled" size="0" tabindex="1" id="tympanic_l">
					<%if(medExamObj.getTympanicL().equalsIgnoreCase("Intact")){ %>
						<option value="Intact" selected="selected">Intact</option>
						<option value="NO">Not Intact</option>
						<%}else if(medExamObj.getTympanicL().equalsIgnoreCase("NO")){ %>
						<option value="Intact">Intact</option>
						<option value="NO" selected="selected">Not Intact</option>
						<%}else{ %>
						<option value="Intact">Intact</option>
						<option value="NO">Not Intact</option>
						<%} %>

		</select>

				<%-- 	<script>
					<%
					if(medExamObj.getTympanicL()!= null){
					%>
					document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

					<%}%>
					</script>--%>

			</td>

			<td>
					<select name="<%=TYMPANIC_R %>" class="smaller" size="0" disabled="disabled" tabindex="1" id="tympanic_r">
					<%if(medExamObj.getTympanicR().equalsIgnoreCase("Intact")){ %>
			<option value="Intact" selected="selected">Intact</option>
			<option value="NO">Not Intact</option>
			<%}else if(medExamObj.getTympanicR().equalsIgnoreCase("NO")){ %>
			<option value="Intact">Intact</option>
			<option value="NO" selected="selected">Not Intact</option>
			<%}else{ %>
			<option value="Intact">Intact</option>
			<option value="NO">Not Intact</option>
			<%} %>

		</select>
				<%-- 	<script>
					<%
					if(medExamObj.getTympanicR()!= null){
					%>
					document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

					<%}%>
					</script>--%>
			</td>

			<td></td>

	</tr>

	<tr>

			<th>Mobility</th>

			<td>
	 <% if(medExamObj.getMobilityL() != null){ %>
<input tabindex="1"  type="text" class="auto" size="26" readonly="readonly" name="<%=MOBILITYL %>" maxlength="100"  value="<%= medExamObj.getMobilityL()  %>"  />
<%}else{ %>
<input tabindex="1" value="Normal" type="text" class="auto" size="26" readonly="readonly" name="<%=MOBILITYL %>"  maxlength="100"  />
<%} %>



			</td>

			<td>
					  	 <% if(medExamObj.getMobilityR() != null){ %>
					  <input tabindex="1" type="text" class="auto" size="26" readonly="readonly" name="<%=MOBILITYR %>" maxlength="100"  value="<%= medExamObj.getMobilityR()  %>"  />


				<%}else{ %>
				 <input tabindex="1" value="Normal" type="text" class="auto" size="26" readonly="readonly" name="<%=MOBILITYR %>"  maxlength="100"  />


				<%} %>
			</td>

			<td></td>

	</tr>

</table>

<div class="Block">
<div class="clear"></div>


		<label>Nose, Throat &amp; Sinuses</label>
			  	 <% if(medExamObj.getNosethroat() != null){ %>
			  <input tabindex="1" type="text" maxlength="100" readonly="readonly" id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
		<%}else{ %>
		 <input tabindex="1" type="text"   id="bothcv" readonly="readonly" name="<%=NOSE_THROAT %>"  maxlength="100"  />
		<%} %>


		<label>Audiometry Record</label>
			  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
			  <input tabindex="1" type="text"  readonly="readonly" id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
		<%}else{ %>
		 <input tabindex="1" type="text"   id="bothcv" readonly="readonly" name="<%=AUDIOMETRY_RECORD %>"    />
		<%} %>
		<input name="Send" type="button"  class="button" readonly="readonly" value="View" onClick="javascript:jsViewFileUploadWindow();" />

</div>
</div>



<div class="clear paddingTop15"></div>
<% if(visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female")){%>
<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly"	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" />
 <% }%>

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"   readonly="readonly "	name="<%=LMP %>"  size="20" maxlength="3"  value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp()) %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly "	name="<%=LMP %>"   size="20" maxlength="3" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=NO_OF_PREGNANCY %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfPregnancies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=NO_OF_PREGNANCY %>" class="auto" size="20" maxlength="6" />
 <% }%>

<div class="clear"></div>
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfAbortions() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" />
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="6" value="<%=medExamObj.getNoOfChildren() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="6" />
 <% }%>


<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text" maxlength="20" readonly="readonly" class="auto" size="20" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>"   validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="1" type="text" maxlength="20"  readonly="readonly" class="auto" size="20" readonly="readonly"	name="<%=DATE_OF_LASTCONFINEMENT %>"   validate="Dental Date,date,no" />
 <% }%>


<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" />
 <% }%>


<label	>Prolapse</label>
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="6" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=PROLAPSE %>" class="" size="20" maxlength="6" />
 <% }%>


<label >USG Abdomen</label>
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=USG_ABORTION %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=USG_ABORTION %>" class="auto" size="20" maxlength="6" />
 <% }%>
 <input class="transparent" size="154">
<input name="Send" type="button" readonly="readonly" class="button" value="View" onClick="javascript:jsViewFileUploadWindowGynaecology();" />

<div class="clear"></div>
</div>
</div>
<%} %>

<%--
<div class="clear paddingTop15"></div>

<h4> Certificate For Commutation Of Pension<a	href="javascript:animatedcollapse.toggle('slide14')"></a></h4><div class="clear"></div>
<div id="slide4">
<div class="Block">
  <label class="auto">Remarks</label>

  <% if(medExamObj.getCommandRemarks()!=null){%>

<textarea rows="" cols="91" class="auto"  disabled="disabled"  	name="commutationOfPensionRemarks" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getCommandRemarks() %></textarea>
 <% }else{%>
<textarea rows="" cols="91" class="auto"  disabled="disabled"	name="commutationOfPensionRemarks" class="large" onkeyup="chkLength(this,100);" ></textarea>
 <% }%>

 </div></div>
  --%>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION AND MEDICAL CATEGORY BY MO</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getFinalObservation()!=null){%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" value="<%=medExamObj.getFinalObservation() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" />
 <% }%>
<label >Med Cat Rec</label>
<select 	name="<%= PRESENT_MEDICAL_CATEGORY %>" disabled="disabled"	validate="Signed By,string,no" tabindex=1>
<option value="0">Select</option>
<%
if( medExamObj.getPresentMedicalCategory()!=null)
{
		for (Category category : categoryList) {
			if( medExamObj.getPresentMedicalCategory().getCategoryid().equals(category.getCategoryid()))
				{
			%>
<option value="<%=category.getCategoryid()%>"  selected="selected"><%=category.getCategories()%> </option>
<%}}}else{
	for (Category category : categoryList) {
%>
<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
<%	}}
		%>
</select><div style="display: none">
<label >Admission</label>
<%if(medExamObj.getAdmissionStatus()!=null)
{
if(medExamObj.getAdmissionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox"
disabled="disabled"	name="admissionStatus" value="" class="radioAuto" id="admissionStatus" checked="checked" />
<%}else{ %>
<input tabindex="1" type="checkbox"
	name="admissionStatus" disabled="disabled" value="" class="radioAuto" id="admissionStatus"  />
<%}}else{ %>
<input tabindex="1" type="checkbox"
	name="admissionStatus" disabled="disabled" value="" class="radioAuto" id="admissionStatus"  />
	<%} %>
<label class="auto">Specialist Opinion</label>
<%if(medExamObj.getSpecialistOpinnionStatus()!=null)
{
if(medExamObj.getSpecialistOpinnionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="" checked="checked" class="radioAuto" id="specialistOpinion"  />
<input name="Send" type="button"  class="button" value="VIEW" onClick="javascript:fileViewForSpecialistOpinion();" />

<%}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="" class="radioAuto" id="specialistOpinion"  />
<%}}else{ %>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="specialistOpinion" value="" class="radioAuto" id="specialistOpinion"  />
<%} %>
<div class="clear"></div>
<label >Signed By</label>
<% if(medExamObj.getSignedBy()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="signidBy" name="<%= SIGNED_BY %>"  size="20" maxlength="100" value="<%=medExamObj.getSignedBy() %>" readonly="readonly" validate="Signed By,string,no"/>
  <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="signidBy" name="<%= SIGNED_BY %>"  size="20" maxlength="100" value="" readonly="readonly" />
 <% }%></div>
<%--
<label >Send To</label>
<% if(medExamObj.getSendTo()!=null){%>
<input tabindex="1" type="text" id="sendTo" name="<%= SEND_TO %>"  size="20" maxlength="100" value="<%=medExamObj.getSendTo() %>" readonly="readonly" />
  <% }else{%>
<input tabindex="1" type="text" id="sendTo" name="<%= SEND_TO %>"  size="20" maxlength="100" value="" readonly="readonly" />
 <% }%>
--%><label >Remarks</label>
<% if(medExamObj.getRemarks()!=null){%>
<input tabindex="1" type="text"   id="remarks" readonly="readonly"	onkeyup="chkLength(this,100);"  name="<%=MEDICIN_REMARKS %>" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getRemarks() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  id="remarks" readonly="readonly"	onkeyup="chkLength(this,100);"  name="<%=MEDICIN_REMARKS %>" class="Auto" size="20" maxlength="100" value=""/>
 <% }%>

  </div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>REMARKS OF OC UNIT</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getAprovAuthFinalObservation()!=null  ){%>
<input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value="<%=medExamObj.getAprovAuthFinalObservation() %>"  size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value=""  size="20" maxlength="100" />

  <% }%>
  <label >Remarks</label>
  <% if(medExamObj.getApprovAuthRemarks()!=null){%>
<input tabindex="1" type="text" readonly="readonly" onkeyup="chkLength(this,100);"  id="aaRemarks" name="aaRemarks" value="<%=medExamObj.getApprovAuthRemarks() %>" size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" onkeyup="chkLength(this,100);"  id="aaRemarks" name="aaRemarks" value="" size="20" maxlength="100" />

  <% }%>

<label >Signed By</label>
<% if(medExamObj.getApprovAuthSignedBy()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value="<%=medExamObj.getApprovAuthSignedBy() %>"  readonly="readonly"/>
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value=""  readonly="readonly"/>

  <% }%>
<%--
<label >Send To</label>
<% if(medExamObj.getApproAuthSendTo()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="aaSendTo" value="<%=medExamObj.getApproAuthSendTo() %>" size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="aaSendTo" value="" size="20" maxlength="100" />
 <% }%>--%>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION BY PERUSING AUTHORITY(Command)</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getPerFinalObservation()!=null){%>
<input tabindex="1" type="text" name="paFinalObservation" readonly="readonly" size="20" maxlength="100" value="<%=medExamObj.getPerFinalObservation() %>" />
<% }else{%>
<input tabindex="1" type="text" name="paFinalObservation" readonly="readonly" size="20" maxlength="100" />
 <% }%>
<label >Remarks</label>
<% if(medExamObj.getPerAuthRemarks()!=null){%>
<input tabindex="1" type="text" id="paRemarks" name="paRemarks" readonly="readonly" value="<%=medExamObj.getPerAuthRemarks() %>" size="20" maxlength="100" />
<% }else{%>
<input tabindex="1" type="text" id="paRemarks" readonly="readonly" name="paRemarks" size="20" maxlength="100" />
 <% }%>
<label >Signed By</label>
<% if(medExamObj.getPerApprovAuthSignedBy()!=null){%>
<input tabindex="1" type="text" name="paSignedBy"  size="20" maxlength="100" readonly="readonly" value="<%=medExamObj.getPerApprovAuthSignedBy() %>"/>
 <% }else{%>
<input tabindex="1" type="text" name="paSignedBy"  size="20" maxlength="100" readonly="readonly" />
 <% }%>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION BY PERUSING AUTHORITY(AIR HQ/AFRO)</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getPaAFROFinalObservation()!=null){%>
<input tabindex="1" type="text" name="paAFROFinalObservation" value="<%=medExamObj.getPaAFROFinalObservation() %>" size="20" maxlength="100" />
<% }else{%>
<input tabindex="1" type="text" name="paAFROFinalObservation"  size="20" maxlength="100" />
<% }%>
<label >Remarks</label>
<% if(medExamObj.getPaAFRORemarks()!=null){%>
<input tabindex="1" type="text" id="paAFRORemarks" name="paAFRORemarks" value="<%=medExamObj.getPaAFRORemarks() %>" size="20" maxlength="100" />
<% }else{%>
<input tabindex="1" type="text" id="paAFRORemarks" name="paAFRORemarks" size="20" maxlength="100" />
<% }%>

<label >Signed By</label>
<input tabindex="1" type="text" name="paAFROSignedBy" value="<%=signedByAA %>" size="20" maxlength="100" readonly="readonly" />
</div>

<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Send" type="button" class="button" value="View" onClick="javascript:jsViewFileUploadWindowForMiscllaneousDoc();" />
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalBoardExaminationReleaseDischargePAAFRO','medicalExam?method=validateMedExamPersusingAuthorityAFRO');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="if(checkRemarksPA()){submitForm('medicalBoardExaminationReleaseDischargePAAFRO','medicalExam?method=rejectMedExamPAAFRO');}" />
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
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){
%><input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){	%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<%}%>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>
</form>
</body>
<script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {

        limitField.value = limitField.value.substring(0, limitNum);

    }
}
function fileViewForSpecialistOpinion()
{
 	
	  var url="/hms/hms/medicalExam?method=viewUploadDocumentsDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&masExam_Id=<%=medExamObj.getId()%>&folderName=specialistOpinion";

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
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

function jsViewDocument(rowVal)
{
		var val=document.getElementById('chargeCodeName'+rowVal).value;
	  	var index1 = val.lastIndexOf("[");
	  	var index2 = val.lastIndexOf("]");
	  	index1++;
	  	var invest_id = val.substring(index1,index2);
	  	 
        var url='/hms/hms/medicalExam?method=viewUploadDocumentsInvestigationDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&invest_id='+invest_id+'&masExam_Id=<%=medExamObj.getId()%>';
   
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");


}
function jsViewFileUploadWindow()
{
	 var url="/hms/hms/medicalExam?method=viewUploadDocumentsDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&masExam_Id=<%=medExamObj.getId()%>&folderName=hearing&flagForm=perExam";
	 	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 }
function jsViewFileUploadWindowGynaecology()
{

	  var url="/hms/hms/medicalExam?method=viewUploadDocumentsDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&masExam_Id=<%=medExamObj.getId()%>&folderName=gynaecology&flagForm=perExam";
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
}
function jsViewFileUploadWindowForMiscllaneousDoc()
{

	var url="/hms/hms/medicalExam?method=viewUploadDocumentsDetails&hinId=<%=medExamObj.getHin().getId()%>&visitId=<%=medExamObj.getVisit().getId()%>&masExam_Id=<%=medExamObj.getId()%>&folderName=miscllaneousDoc&flagForm=perExam";
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 }
function checkRemarksAA()
{
		var remarks=document.getElementById('aaRemarks').value;
		if(remarks=='')
		{
		  alert("Please Enter the OC Unit Remarks");
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

		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';

				submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischargeOCUnit','/hms/hms/opd?method=showGridForInvestigation','gridview');

				}

	}
 function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
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
 function openPopupForPatientInvestigation(visitNo,hinId){

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
	    submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischargeOCUnit','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischargeOCUnit','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischargeOCUnit','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
		}
//		document.getElementById('prescriptionImportButton').style.display = 'none';
//		document.getElementById("investigationImportButton").style.display='none'
	 }
 function validateInvestigationAutoComplete( strValue,inc ) {

		var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    if(id =="")
	    {
	    		document.getElementById('chargeCodeName'+inc).value="";
				document.getElementById('chargeCode'+inc).value="";
				return ;
		}
		document.getElementById('qty'+inc).value="1";
		return true;
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

			for(i=1;i<inc;i++){

				if(inc != 1){
					if(document.getElementById('chargeCodeName'+i).value==val) {
						alert("Test name already selected...!")
						document.getElementById('chargeCodeName'+inc).value=""
						var e=eval(document.getElementById('chargeCodeName'+inc));
						e.focus();
						return false;
					}
				}
			}

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
	function FileUploadWindow()
	{
		   var folderName='hearing';
			var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName;

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	function fileUploadWindowInvestigation(rowVal)
	{
		var val=document.getElementById('chargeCodeName'+rowVal).value;
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var invest_id = val.substring(index1,index2);
			var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo=<%=visit.getHin().getHinNo() %>&invest_id="+invest_id+"&masExamId=<%=medExamId%>";
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	function FileUploadWindowGynaecology()
	{
		var folderName='gynaecology';
			var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName;

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}

		function removeRow1()
		{
		  var tbl = document.getElementById('grid1');
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  	tbl.deleteRow(lastRow - 1);
		  	var tbl = document.getElementById('grid1');
		  	var lastRow = tbl.rows.length;
			  // if there's no header row in the table, then iteration = lastRow + 1
		 	var iteration = lastRow - 1;
		  	var hdb = document.getElementById('hdb1');
		  	hdb.value=iteration
		  }
		}

	function submitdata()
	{

		var charge=document.getElementById("chargeCodeName1").value;
        if(charge=="")
        {
         alert("Please Select Test Name");
         return false;
        }else{
        	submitForm('medicalBoardExaminationReleaseDischargeOCUnit','medicalExam?method=addMedicalExaminationBoardAnnual');
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
 function getPrevMedBoardFromHIC()
 {
 	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&serviceNo=<%=visit.getHin().getServiceNo() %>";
    	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
 }
 function getPrevMedExamFromHIC()
 {
	//var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
 	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>";
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
</script>
