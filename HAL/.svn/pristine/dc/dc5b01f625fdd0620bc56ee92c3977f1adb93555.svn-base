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
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
var disabilityListArray=new Array();
var masIcdListArray=new Array();
var disabilitygroupListArray=new Array();
</script>
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
<%
String Labresult="NotPresent";
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
String signedBy="";
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");
}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		if(masEmployee.getRank()!=null){
			signedBy=masEmployee.getRank().getRankName();
		}
		signedBy=signedBy+" "+masEmployee.getFirstName();
		if(masEmployee.getMiddleName()!=null){
			signedBy=signedBy+" "+masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null){
			signedBy=signedBy+" "+masEmployee.getLastName();
		}
	}
}
/*
if(session.getAttribute("users")!=null){
Users user = (Users) session.getAttribute("users");
if(user.getEmployee()!=null){
	signedBy=user.getEmployee().getFirstName();
	if(user.getEmployee().getMiddleName()!=null){
		signedBy=signedBy+" "+user.getEmployee().getMiddleName();
	}
	if(user.getEmployee().getLastName()!=null){
		signedBy=signedBy+" "+user.getEmployee().getLastName();
	}
}
}
*/
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
/*
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);

}
*/
List<Disability> disabilityList= new ArrayList<Disability>();
if(map.get("disabilityList") != null){
	disabilityList=(List)map.get("disabilityList");
}
List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}
String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");

}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
	Visit visit=null;
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	 visit=(Visit)medExamObj.getVisit();
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
}
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){

	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");

	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){

	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	getDgOrderdts=dgOrderhd.getDgOrderdts();

}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");

	}
List<MasIcd> masIcdList = new ArrayList<MasIcd>();
if(map.get("masIcdList") != null){
	masIcdList=(List)map.get("masIcdList");

	}
List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
if(map.get("disabilitygroupList") != null){
	disabilitygroupList=(List)map.get("disabilitygroupList");

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

<%--- <div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('mbApproveAuthForm16','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('mbApproveAuthForm16','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('mbApproveAuthForm16','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('mbApproveAuthForm16','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');"" />
</div>
--%>
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
<div class="clear"></div>

<div class="titleBg">
<h2>AFMSF-15 </h2>
<h2 class="floatRight">INITIAL</h2>
</div>

<div class="clear"></div>
<body onLoad="">
<form name="mbApproveAuthForm16" action="" method="post">
<div class="clear"></div>
<%
int medExamId = 0;
int visitId=0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();

}
int hinId=0;
String hin_no="";
if(medExamObj.getVisit()!=null){
	visitId=medExamObj.getVisit().getId();
	hinId=medExamObj.getHin().getId();
	hin_no=medExamObj.getHin().getHinNo();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<input type="hidden" name="visitId" value="<%=visitId %>"/>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" id="hinId"/>
<div class="Block">
<label>Authority for Board</label>
<%
String authority="IAP4303(4TH Ed)";
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	if(medExamObj.getAuthority()!=null){
		authority=medExamObj.getAuthority();
	}

} %>
<input type="text" name="authorityforBoard" id="AuthorityforBoard" value="<%=authority %>" readonly="readonly" />
<%
 
	 String place="";
if(medExamObj.getPlace()!=null){
		 place= medExamObj.getPlace();
	 }else{
	 if(session.getAttribute("hospitalName")!=null){
		 place=((String)session.getAttribute("hospitalName"));
	 }
	 }
	 %>
<label>Place </label>
<input tabindex="1" type="text" maxlength="99" class="auto" size="50" readonly="readonly" id="<%=PLACE %>" name="<%=PLACE %>"  value="<%=place%>"
	onKeyUp="limitText(this,99);" />
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Name  </label>

<input type="text" value="<%=visit.getHin().getSFirstName()+" "+(visit.getHin().getSMiddleName()!=null?visit.getHin().getSMiddleName():"")+" "+(visit.getHin().getSLastName()!=null?visit.getHin().getSLastName():"") %>" readonly="readonly" name="<%=FULL_NAME%>"	 maxlength="20"/>

<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType"  />

<% }else{%>

 <input type="hidden"value="Initial Medical Board AFMSF 15" name="medicalExamType"  />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly"  value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"  maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	 maxlength="20" />


 <div class="clear"></div>
  <label>Unit </label>
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>"  value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	 />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>"  />
 <% }%>
 <label>Service</label>
 <input	type="text" readonly="readonly" value="<%=visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	 maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	 maxlength="20" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly"  value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	 value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	 readonly="readonly"/>

 <% }%>
 <div class="clear"></div>
 <label> DOB</label>
 <%
 if(visit.getHin().getDateOfBirth()!=null && !(visit.getHin().getDateOfBirth().equals(""))){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" value="<%= HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />

	<% }else if(medExamObj.getDateOfBirth()!=null && !(medExamObj.getDateOfBirth().equals(""))){%>
	  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"
			validate="DOB,date,yes" maxlength="10"
			onKeyUp="mask(this.value,this,'2,5','/');" />
		
			<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" value="" validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" readonly="readonly"/>
	<% }%>
 <label>Age  </label>
  <% if(visit.getHin().getAge()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=visit.getHin().getAge() %>" name="apparentAge"	 />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	 />

 <% }%>
 <label>Gender</label>
  <input	type="text" readonly="readonly" value="<%= visit.getHin().getSex().getAdministrativeSexName() %>" name="apparentAge"	 maxlength="20" />
  <div class="clear"></div>

<%-- 
  <label>Weight  </label>
 <%if(medExamObj.getPatientweight()!=null)
 { %>
  <input class="auto" type="text" readonly="readonly" maxlength="3" value="<%=medExamObj.getPatientweight()%>" name="patientweight"	tabindex="1" size="17"/>
 <% }else{%>
   <input class="auto" type="text"  readonly="readonly" name="patientweight" 	tabindex="1"  size="17" maxlength="3"/>
 <% }%>
 <label class="unit">Kg</label>

<label>Height</label>
<%if(medExamObj.getPatientheight()!=null)
 { %>
  <input value="<%=medExamObj.getPatientheight()%>" name="patientheight" readonly="readonly" maxlength="3" class="auto" type="text" size="18"/>
 <% }else{%>
   <input class="auto" type="text"  name="patientheight"  readonly="readonly" size="18" maxlength="3"/>
 <% }%>
 <label class="unit">cm</label>
--%>

 <label>Address on Leave </label>
<%
if(medExamObj.getParmanentAddress()!=null)
 {
	%>
  <input type="text" readonly="readonly" maxlength="100" value="<%=medExamObj.getParmanentAddress()%>" name="<%=PERMANENT_ADDRESS%>" />
 <% }else{%>
   <input type="text" readonly="readonly" name="<%=PERMANENT_ADDRESS%>"  maxlength="100" />
 <% }%>

 
 <label>DOE/DOC</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	name="<%=DATE_COMMENCEMENT %>" readonly="readonly"  value="<%= HMSUtil.changeDateToddMMyyyy(visit.getHin().getCommissionDate()) %>"
 	validate="Entry Date,date,no" maxlength="10" />
 <% }else{%>
 <input	name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	validate="Entry Date,date,no"
 		maxlength="10"	 tabindex="1"/>
 <% }%>

 <label>Record Office</label>
<%if(medExamObj.getRecordoffice()!=null)
 { %>
  <input type="text" readonly="readonly" value="<%=medExamObj.getRecordoffice()%>" name="<%=RECORDOFFICE%>"	maxlength="100"  />
 <% }else{%>
   <input type="text"  readonly="readonly" name="<%=RECORDOFFICE%>"	maxlength="100" />
 <% }%>
<div class="clear"></div>

 <label>Ceased Duty on</label>

<%if(medExamObj.getCeaseduty()!=null && !(medExamObj.getCeaseduty().equals("")))
 { %>
  <input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getCeaseduty())%>" name="<%=CEASEDDUTY%>"	 maxlength="10"/>
 <% }else{%>
   <input type="text" readonly="readonly" name="<%=CEASEDDUTY%>"	maxlength="10" />
 <% }%>
 <label>Past Medical History  </label>
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea readonly="readonly" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,200);" ><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,200);" readonly="readonly"></textarea>
 <% }%>
 <div class="clear"></div>
<label>Present Med Cat </label>
<%if(medExamObj.getPresentMedicalCategory()  !=null){ %>
<input type="text" name="<%= PAST_MEDICAL_CATEGORY %>" value="<%=medExamObj.getPresentMedicalCategory().getCategories() %>" readonly="readonly"/>
<%}else{ %>
<input type="text" name="<%= PAST_MEDICAL_CATEGORY %>" value="" readonly="readonly"/>
<%} %>

<label>Period  </label>
<% if(medExamObj.getPresentMedPeriod() !=null && medExamObj.getPresentMedPeriod()!=""){
 String medCatPeriod=medExamObj.getPresentMedPeriod().substring(0,medExamObj.getPresentMedPeriod().indexOf(" "));
 String medCatDuration = medExamObj.getPresentMedPeriod().substring(medExamObj.getPresentMedPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="<%=medCatPeriod %>" maxlength="5" class="small" readonly="readonly"/>
 <select name="medCatDuration" id="medCatDuration" class="small" disabled="disabled">
<%if(medCatDuration.equalsIgnoreCase("Months")){ %>
 <option value="Months" selected="selected">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Weeks")){ %>
 <option value="Months">Months</option>
 <option value="Weeks" selected="selected">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Days")){ %>
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days" selected="selected">Days</option>
 <%}else{ %>
  <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{%><input type="text" name="medCatPeriod" id="medCatPeriod" value="" readonly="readonly" class="small"/>
 <select name="medCatDuration" id="medCatDuration" class="small" disabled="disabled">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%
 String shapeFactor="";
 if(medExamObj.getShapFactor() !=null){ 
	 shapeFactor=medExamObj.getShapFactor();
 }%>
<input type="text" name="shapeFactor" id="shapeFactor" value="<%=shapeFactor%>" readonly="readonly" tabindex="1"/>
<%---
<select name="<%= PAST_MEDICAL_CATEGORY %>"	validate="Prev Med Category,string,no" tabindex=1 readonly="readonly" >
	<option value="0">Select</option>
	<%
	int presentMedicalCategory=0;
	
	if(medExamObj.getPresentMedicalCategory()!=null)
	{
		presentMedicalCategory=medExamObj.getPresentMedicalCategory().getCategoryid();
	}	
if(presentMedicalCategory==0){
	if(visit.getHin().getCategory()!=null){
		presentMedicalCategory=visit.getHin().getCategory().getCategoryid();
	}
}
if(categoryList.size()>0){		
	for (Category category : categoryList) {
				if(presentMedicalCategory==category.getCategoryid())
					{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%}else{
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}

				}}	%>
</select> --%>
<div class="clear"></div>
<div>
<label>Signature of Individual</label>
<input type="text" readonly="readonly" disabled="disabled" />

<label >Date</label>
<% if(medExamObj.getOpiniondate()!=null){%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" 	validate="Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.changeDateToddMMyyyy(medExamObj.getOpiniondate())%>" />

<% }else{%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate"  	validate="Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date%>" />
<% }%>
</div>
</div>

<div class="clear paddingTop15"></div>
<h4> DETAILS OF PRESENT AND PREVIOUS DISABILITIES <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>


<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col">Disabilities</TH>
<TH scope="col" colspan="2">Category For Disability</TH>
<%---
<TH scope="col" >Date of Origin</TH>
<TH scope="col" >Place of Origin</TH>
<TH scope="col">Prev Med Cat</TH>
<TH scope="col" >Date</TH>
<TH scope="col" >Next due on</TH> --%>
<TH scope="col" >Attributability/Aggravation </TH><%---
<TH scope="col"> Remarks</TH> --%>
<TH scope="col">Previous Disablement %</TH>
<TH scope="col" >Present Disablement %</TH>
<TH scope="col">Reasons for Variation if any</TH>
<TH scope="col" colspan="2">Composite</TH>
</tr>
<% int inc1123=0;
	
/*if(medExamObj.getMasmedicaldetail()!=null && medExamObj.getMasmedicaldetail().size()>0)
	{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
		*/
		if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
		{
		for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
		
	if(masMedicalExamDetails.getParticular() !=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail")){
	inc1123=inc1123+1;

	%>
<TR>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO+inc1123 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialno() %>"/></td>
<% if(masMedicalExamDetails.getPrincipal()!=null){


 String principal="";
  if(masMedicalExamDetails.getPrincipal()!=null){
	  principal=masMedicalExamDetails.getPrincipal();
  }
  int icdId=0;
  String icdCode="";
	if(masMedicalExamDetails.getMasIcd()!=null){
		icdId=masMedicalExamDetails.getMasIcd().getId();
	}if(masMedicalExamDetails.getMasIcd()!=null){
		icdCode=masMedicalExamDetails.getMasIcd().getIcdCode();
	}
	if(principal!=""){
		principal=principal+"["+icdCode+"]";
	}%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="50" value="<%=principal%>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="50" /></td>
<% }%>
<%----
<td width="10%">
<% if(masMedicalExamDetails.getOrigindate()!=null){%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="autoArial" size="10" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
value="<%=HMSUtil.changeDateToddMMyyyy(masMedicalExamDetails.getOrigindate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

<% }%>
</td>

<% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1123 %>" maxlength="50" value="<%=masMedicalExamDetails.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1123 %>" maxlength="50" /></td>
<% }%>

<td width="10%">

<select 	class="medium" name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>" id="presentMedCategory<%=inc1123 %>"	validate="Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
<%
int categoryId=0;
if(masMedicalExamDetails.getCategory()!=null)
{
	categoryId=masMedicalExamDetails.getCategory().getCategoryid();
}
if(categoryId==0){
	if(visit.getHin().getCategory()!=null){
		categoryId=visit.getHin().getCategory().getCategoryid();
	}
}
			for (Category category : categoryList) {
			/*	String selected="";
				if(masMedicalExamDetails.getCategory()!=null){


				if(masMedicalExamDetails.getCategory().getCategoryid().equals(categoryId))
					{
					selected="selected";
					}
				}*/
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
	</select>
	<script>

document.getElementById('presentMedCategory<%=inc1123 %>').value='<%=categoryId%>'
</script>
</td>
<td width="10%">
<% if(masMedicalExamDetails.getMedicalcatdate()!=null){%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="autoArial" size="10" value="<%=HMSUtil.changeDateToddMMyyyy(masMedicalExamDetails.getMedicalcatdate()) %>" 	validate="DOB,date,no" maxlength="5" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="5" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>

<td width="10%">
<% if(masMedicalExamDetails.getNextcatdate()!=null){%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="autoArial" size="10" value="<%=HMSUtil.changeDateToddMMyyyy(masMedicalExamDetails.getNextcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>
 --%>

<%
String categoryDisable="";
String categoryDisPeriod="";
if(masMedicalExamDetails.getCategoryDisability() !=null){
	categoryDisable=masMedicalExamDetails.getCategoryDisability().getCategories();
}
if(masMedicalExamDetails.getCateDisPeriod() !=null){
	categoryDisPeriod=masMedicalExamDetails.getCateDisPeriod();
}
%>
<td><input value="<%=categoryDisable%>" readonly="readonly" class="auto" size="6"/></td>
<td><input value="<%=categoryDisPeriod%>" readonly="readonly" class="auto" size="8"/></td>
<td>
<%
String aggravation="";
if(masMedicalExamDetails.getDisabilityAggravation()!=null){
	aggravation=masMedicalExamDetails.getDisabilityAggravation();
}
%>
<select name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no" disabled="disabled">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
<script type="text/javascript">
document.mbApproveAuthForm16.aggravation<%=inc1123%>.value='<%=aggravation%>'
</script>
</td><%--
<td>
<%
String remarks="";
if(masMedicalExamDetails.getDisabilityRemarks()!=null){
	remarks=masMedicalExamDetails.getDisabilityRemarks();
}
%>
<input tabindex="1" type="text" readonly="readonly" value="<%=remarks%>" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> --%>
<% if(masMedicalExamDetails.getPreDisability()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="prevDisabilities<%=inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPreDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="prevDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<% if(masMedicalExamDetails.getPastDisability()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="pastDisabilities<%=inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPastDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="pastDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<% if(masMedicalExamDetails.getReasonVariation()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="variationReason<%=inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getReasonVariation() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="variationReason<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<%
String categoryComp="";
String categoryCompPeriod="";
if(masMedicalExamDetails.getCompositeCate() !=null){
	categoryComp=masMedicalExamDetails.getCompositeCate().getCategories();
}
if(masMedicalExamDetails.getCompCatePeriod() !=null){
	categoryCompPeriod=masMedicalExamDetails.getCompCatePeriod();
}
%>
<td><input value="<%=categoryComp%>" readonly="readonly" class="auto" size="6"/></td>
<td><input value="<%=categoryCompPeriod%>" readonly="readonly" class="auto" size="8"/></td>
<%--
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<%--
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>
 --%>

</TR>
<input type=hidden name="<%=SERVICEID+inc1123 %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />

<%}}}if(inc1123<=0){
	inc1123=inc1123+1;%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO+inc1123 %>" value="<%=inc1123 %>" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<%----<td width="10%">
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="autoArial" size="8" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>


<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=FROM+inc1123 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="autoArial" size="8" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>

<td width="10%">
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="autoArial" size="8" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td> --%>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="categoryForDisable"/></td>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" l/></td>
<td>
<select name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no" disabled="disabled">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
</td>
<%---
<td>
<%
String remarks="";
%>
<input tabindex="1" type="text" readonly="readonly" value="<%=remarks%>" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> --%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="prevDisabilities<%=inc1123 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="pastDisabilities<%=inc1123 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="variationReason<%=inc1123 %>" maxlength="10" /></td>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="compositeCategory"/></td>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="medCatPeriodComp"/></td>
<%--
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<%--
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td> --%>
</TR><% }%>
</table>
<input type=hidden name="hdb" value="<%=inc1123%>" id="hdb" />
</div>
<div class="clear paddingTop15"></div>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="View Clinical Summary"	onClick="openPopupForClinicalSummary(<%=medExamId %>);" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="View Specialist Opinion"	onClick="openPopupForSpecialistOpinion();" /> 

<div class="clear paddingTop15"></div>

<h4>MEDICAL BOARD DETAILS</h4>
<div class="clear"></div>

<div class="Block">
<label>Med Cat Rec</label>
<%if(medExamObj.getMedicalCategoryRecomended() !=null) {%>
<input name="medCateRecommed" readonly="readonly" value="<%=medExamObj.getMedicalCategoryRecomended().getCategories()%>"/>
<%}else{ %><input name="medCateRecommed" value="" readonly="readonly"/>
<%} %>
<%---
<select id="medCateRecommed"	name="medCateRecommed" 	validate="Med Cat Rec,string,no" tabindex=1 disabled="disabled">
	<option value="0">Select</option>
	<%
	int medicalCategoryRecomendedId=0;
	if(medExamObj.getMedicalCategoryRecomended()!=null)
	{
		medicalCategoryRecomendedId=medExamObj.getMedicalCategoryRecomended().getCategoryid();
	}
			for (Category category : categoryList) {
			/*	String selected="";
				if(category.getCategoryid().equals(medicalCategoryRecomendedId))
					{
					selected="selected";
					}else{
						selected="";
					}*/
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select> 
<script>

document.getElementById('medCateRecommed').value='<%=medicalCategoryRecomendedId%>'
</script>--%>
<%--
<%if(medExamObj.getMedCatRec() !=null){ %>
<input type="text" name="medCateRecommed" value="<%=medExamObj.getMedCatRec() %>" ></input>
<%}else{ %>
<input type="text" name="medCateRecommed" value="" ></input>
<%} %> --%>
<%---commented by dipali
<label>Duration</label>
<%if(medExamObj.getMedboardDuration() !=null){ %>
<input type="text" readonly="readonly" class="autoArial" size="5" name="duration" maxlength="3" value="<%=medExamObj.getMedboardDuration() %>" ></input>
<%}else{ %>
<input type="text" readonly="readonly" class="autoArial" size="5" name="duration" maxlength="3" ></input>
<%} %>
<label class="unit2">Weeks</label> --%>

<%---Added By dipali --%>
<%
String medcatrec="";
if(medExamObj.getMedCatRec() !=null){ 
medcatrec= medExamObj.getMedCatRec();
}%>
<input type="hidden" name="medcatrec" id="medcatrec" value="<%=medcatrec %>"/>
<label>Period  </label>
<% if(medExamObj.getRecMedPeriod() !=null && medExamObj.getRecMedPeriod()!=""){
 String medCatPeriod=medExamObj.getRecMedPeriod().substring(0,medExamObj.getRecMedPeriod().indexOf(" "));
 String medCatDuration = medExamObj.getRecMedPeriod().substring(medExamObj.getRecMedPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriodRec" id="medCatPeriodRec" value="<%=medCatPeriod %>" readonly="readonly" class="small"/>
 <select name="medCatDurationRec" id="medCatDurationRec" class="small" disabled="disabled">
<%if(medCatDuration.equalsIgnoreCase("Months")){ %>
 <option value="Months" selected="selected">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Weeks")){ %>
 <option value="Months">Months</option>
 <option value="Weeks" selected="selected">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Days")){ %>
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days" selected="selected">Days</option>
 <%}else{ %>
  <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{%>
 <input type="text" name="medCatPeriodRec" id="medCatPeriodRec" value="" readonly="readonly" class="small"/>
 <select name="medCatDurationRec" id="medCatDurationRec" class="small" disabled="disabled">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%
 String shapeFactorRec="";
	 if(medExamObj.getShapeFactorRec() !=null){ 
		 shapeFactorRec=medExamObj.getShapeFactorRec();
	 }
 %>
 <input type="text" name="shapeFactorRec" value="<%=shapeFactorRec %>" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label >Next Board</label> <label class="auto">Place</label>
<%if(medExamObj.getPlaceNextCatBoard() !=null){ %>
<input type="text" readonly="readonly" name="nextCategorization" maxlength="50" value="<%= medExamObj.getPlaceNextCatBoard()%>" class="auto" size="40"></input>
<%}else{ %>
<input type="text" readonly="readonly" name="nextCategorization" maxlength="50" class="auto" size="40"></input><%} %>
<label class="unit">Date</label>
<%if(medExamObj.getNextBoardDate() !=null){ %>
<input tabindex="1" type="text" readonly="readonly" name="nextBoardDate" class="autoArial"  size="18" maxlength="10"
			value="<%=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getNextBoardDate())%>" />
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" name="nextBoardDate" class="autoArial"  size="18" maxlength="10" value="" /><%} %>
<%---
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" class="calender" onclick="" /> --%>

<div class="clear"></div>

<label>Opinion of Medical Board</label>
<!-- <input type="text" name="Opinion" class="auto" size="100" maxlength="200"></input> -->
<%
String medBoardOpinion="";
if(medExamObj.getOpinion() !=null){
	medBoardOpinion=medExamObj.getOpinion();
	} %>
<textarea rows="2" cols="" name="opinionMedicalBoard" class="large" readonly="readonly"><%=medBoardOpinion %></textarea>
<div class="clear"></div>
<div class="clear"></div>

<label>Dissent Note</label>
<%if(medExamObj.getDissentNote() !=null){ %>
<textarea rows="2" cols="" name="dissentNote" class="large" readonly="readonly" >
<%=medExamObj.getDissentNote() %></textarea><%}else{ %>
<textarea rows="2" cols="" name="dissentNote" class="large"  readonly="readonly" >
</textarea><%} %>
<!-- <input type="text" name="dissentNote" class="auto" size="1000" maxlength="200"></input> -->

<%--
<div class="clear"></div>
<div class="clear"></div>
<h4>Percentage of Disability (Only for permanent LMC)</h4>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col">S.No.</TH>
<TH scope="col">Disabilities(With ICD Code)</TH>
<TH scope="col">Previous Disablement %</TH>
<TH scope="col" >Present Disablement %</TH>
<TH scope="col">Reasons for Variation if any</TH>
</tr>

<tr>
<td width="10%"><input tabindex="1" type="text" name="sirialNo" maxlength="3" value="" class="auto" size="2"/></td>

<td width="10%"><input tabindex="1" type="text" name="Disabilities" maxlength="30" value="" /></td>

<td width="10%"><input tabindex="1" type="text" name="previousDisablement" maxlength="3" value="" /></td>

<td width="10%"><input tabindex="1" type="text" name="presentDisablement" maxlength="3" value="" /></td>

<td width="10%"><input tabindex="1" type="text" name="reasonsForVariation" maxlength="50" value="" /></td>
</tr>

</table>
</div>

 --%>
<div class="clear"></div>

<label>Composite %</label>
<%if(medExamObj.getMedComposite() !=null){ %>
<input type="text" readonly="readonly" name="Composite"  value="<%=medExamObj.getMedComposite()%>" maxlength="3" class="autoArial" size="5"/>
<%}else{ %>
<input type="text" readonly="readonly" name="Composite" maxlength="3" class="autoArial" size="5" /><%} %>
<label>Employability Restrictions</label>
<%if(medExamObj.getEmpabiltyRestric() !=null){ %>
<input type="text" size="38" class="autoArial" name="employabilityRestrictions"  value="<%= medExamObj.getEmpabiltyRestric()%>" readonly="readonly"/>

<%}else{ %>
<input type="text" size="38" class="autoArial" name="employabilityRestrictions" readonly="readonly" />
<%} %>
<!-- <input type="text" name="Employability" class="auto" size="100" maxlength="50"/> -->

<div class="clear"></div>

<label>Instructions</label>
<%if(medExamObj.getMedInstructions() !=null){ %>
<textarea rows="2" cols="" name="Instructions" class="large" readonly="readonly">
<%=medExamObj.getMedInstructions() %></textarea>
<%}else{ %>
<textarea rows="2" cols="" name="Instructions" class="large" readonly="readonly"></textarea><%} %>
<!-- <input type="text" name="Instructions" class="auto" size="100" maxlength="20"/> -->

<div class="clear"></div>

<label>Signature of Individual</label>
<%if(medExamObj.getIndividualDigitalSign() !=null){ %>
<input type="text" readonly="readonly" name="digitalSign" value="<%=medExamObj.getIndividualDigitalSign() %>" maxlength="30"/>
<%}else{ %>
<input type="text" readonly="readonly" name="digitalSign" maxlength="30"/>
<%} %>

<label>Date</label>
<%if(medExamObj.getMedDetailDate() !=null){ %>
<input type="text" readonly="readonly" name="Date"   value="<%=HMSUtil.changeDateToddMMyyyy(medExamObj.getMedDetailDate()) %>"
		 maxlength="10"/>
<%}else{ %>
<input type="text" readonly="readonly" name="Date"   value="" maxlength="10"/>
<%} %>
<%---
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" class="calender" onclick="" /> --%>

<div class="clear"></div>

<label>Member 1</label>
<%
	String member1="";
	if(medExamObj.getMedDetailMember1() !=null){
	member1=medExamObj.getMedDetailMember1().getFirstName();
	if(medExamObj.getMedDetailMember1().getLastName() !=null){
		member1=member1+" "+medExamObj.getMedDetailMember1().getLastName();
	}
	}%>
<input type="text" readonly="readonly" name="member1" maxlength="32" value="<%=member1%>" maxlength="32"/>
<label>Member 2</label>
<%String member2="";
	if(medExamObj.getMedDetailMember2() !=null){
	member2=medExamObj.getMedDetailMember2().getFirstName();
	if(medExamObj.getMedDetailMember2().getLastName() !=null){
		member2=member2+" "+medExamObj.getMedDetailMember2().getLastName();
	}
}
	%>
<input type="text" readonly="readonly" name="member2"  value="<%=member2 %>" maxlength="32" />


<label>President</label>
<%	String president="";
	if(medExamObj.getMedDetailPresident()!=null){
	if(medExamObj.getMedDetailPresident().getRank()!=null){	
		president=medExamObj.getMedDetailPresident().getRank().getRankName();
	}
	}
	if(medExamObj.getMedDetailPresident() !=null){
	president=president+" "+ medExamObj.getMedDetailPresident().getFirstName();
	if(medExamObj.getMedDetailPresident().getLastName() !=null){
		president=president+" "+medExamObj.getMedDetailPresident().getLastName();
	}
	} %>
<input type="text" readonly="readonly" name="president" value="<%=president %>"maxlength="32"/>

<div class="clear"></div>

<label>Remarks</label>
<%if(medExamObj.getMedRemarks() !=null){ %>
<input type="text" readonly="readonly" name="Remarks" class="auto" size="92" maxlength="100" value="<%=medExamObj.getMedRemarks() %>"
/><%}else{ %>
<input type="text" readonly="readonly" name="Remarks" class="auto" size="92" maxlength="100" /><%} %>
</div>

<div class="clear"></div>
<h4>APPROVING AUTHORITY</h4>
<div class="clear"></div>
<div class="Block">
<label>Final Observation</label>
<input type="text"  name="<%=FINAL_OBSERVATION %>" maxlength="99" id="finalObservation" tabindex="1" validate="Final Observation,metachar,no"/>

<label>Remarks</label>
<input type="text"  name="<%=AUTH_REMARKS %>" id="authRemarks" maxlength="99" tabindex="1" validate="Remarks,metachar,no"/>

<label>Signed By</label>
<input type="text"  name="<%=SIGNED_BY %>" value="<%=signedBy%>" id="signedBy" maxlength="32" tabindex="1" validate="Signed By,metachar,no" readonly="readonly"/>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="b1" value="VALDATE" class="button" onclick="submitForm('mbApproveAuthForm16','medicalBoard?method=saveInitialMedicalBoardAppAuthJsp');"></input>
<input type="button" name="b2" value="REJECT" class="button"  onClick="checkReject();"></input>
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="b4" value="View Attachments" class="buttonBig" onClick="javascript:fileUploadViewWindow('VIEW');"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--
/*
         * Code By Mukesh
         * Status
         *  m		MA Waiting List  (Direct from visit/reception)
         *  f		MO Waiting List  (forwarded from MA)
         *  v		Approving Authority Waiting List  (validate from from Mo)
         *  a		Perusing Authority Waiting List  (validate from from Approving Authority)
         *  p		Perusing Authority validated
         *  fr		Rejected By Mo (Display In MA Waiting List)
         *  vr		Rejected By Approving Authority(Display In MO Waiting List)
         *  ar		Rejected Perusing Authority (Display In Approving Authority Waiting List)
         */
 -->
<script>
function checkReject()
{
	var authRemarks=document.getElementById("authRemarks").value;
	if(authRemarks!=""){
		submitForm('mbApproveAuthForm16','medicalBoard?method=rejectMedicalBoardEntry&rejectStatus=vr');
	}else{
		alert("Please Enter Remark.");
		return false;
		}
}
function openPopupForClinicalSummary(medExamId)
{
	var url="/hms/hms/medicalBoard?method=showViewClinicalSummaryJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
   	newwindow=window.open(url,'clinicalSummary','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}

function openPopupForSpecialistOpinion()
{
	var url="/hms/hms/medicalBoard?method=showViewSpecialistOpinionJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
	newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function fileUploadViewWindow(flag)
{
	//flag=HEA Means-->Hearing
	//flag=GYN Means-->GYNAECOLOGY EXAM
	//flag=ALL Means-->ALL Type
	//flag=VIEW Means-->Only for View
		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;
		newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");

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
</script>
</form>
</body>