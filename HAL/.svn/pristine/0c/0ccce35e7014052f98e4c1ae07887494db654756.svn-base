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
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>

<%@page import="jkt.hms.masters.business.DgOrderdt"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
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

		/*
		String signedBy="";
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
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>
<script type="text/javascript">
function checkTemplateId(templateId){

    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	//String Labresult="NotPresent";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
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
			signedBy=signedBy+" "+ masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null){
				signedBy=signedBy+" "+masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null){
				signedBy=signedBy+" "+masEmployee.getLastName();
			}
		}
	}

/*
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);

}
*/	
	String url="";
	if(map.get("url") != null){
		url = (String)map.get("url");
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
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");

   }
if(!message.equalsIgnoreCase("")){

%>
<h4><%=message %></h4><%} %>
<%--- 
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="" />
</div>--%>

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
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-15 </h2><h2 class="floatRight">INITIAL</h2>
</div>
<div class="clear"></div>
<form name="medicalBoardPerusingAuth" action="" method="post">
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
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>"/>
<div class="Block">
<label>Authority for Board</label>
<%
String authority="IAP4303(4TH Ed)";
if(medExamObj.getAuthority()!=null){
	authority=medExamObj.getAuthority();
}
%>
<input type="text" name="authorityforBoard" id="AuthorityforBoard" value="<%=authority %>"  />
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
<input tabindex="1" type="text" maxlength="99"  id="<%=PLACE %>" name="<%=PLACE %>"  value="<%=place%>"
	onKeyUp="limitText(this,99);" class="auto" size="50" readonly="readonly"/>
</div>
<div class="Block">
<label>Name  </label>
<%if(visit.getHin().getSFirstName() !=null){ %>
<input type="text" value="<%=visit.getHin().getSFirstName() %>" readonly="readonly" name="<%=FULL_NAME%>"	 maxlength="20"/>
<%}else{ %>
<input type="text" value="" readonly="readonly" name="<%=FULL_NAME%>"	 maxlength="20"/>
<%} %>

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
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	 maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	 maxlength="20" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly"  value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	 value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	 readonly="readonly"/>

 <% }%>
 <div class="clear"></div>
 <label>DOB</label>
 <%
 if(visit.getHin().getDateOfBirth()!=null && !visit.getHin().getDateOfBirth().equals("")){%>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" />

	<% }else if(medExamObj.getDateOfBirth()!=null && !(medExamObj.getDateOfBirth().equals(""))){%>
	  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"/>
	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" value="" readonly="readonly"/>
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
  <input class="auto" readonly="readonly" ype="text" value="<%=medExamObj.getPatientweight()%>" name="patientweight"	tabindex="1" size="17" maxlength="3" />
 <% }else{%>
   <input class="auto" type="text"  name="patientweight" readonly="readonly"	tabindex="1"  size="17" maxlength="3"/>
 <% }%>
 <label class="unit">Kg</label>

<label>Height</label>
<%if(medExamObj.getPatientheight()!=null)
 { %>
  <input value="<%=medExamObj.getPatientheight()%>" name="patientheight"  class="auto" type="text" size="18" readonly="readonly" maxlength="3"/>
 <% }else{%>
   <input class="auto" type="text" readonly="readonly" name="patientheight" maxlength="3" size="18"/>
 <% }%>
 <label class="unit">cm</label>
--%>
 <label>Address on Leave </label>
<%if(medExamObj.getParmanentAddress()!=null) {
	%>
  <input type="text" readonly="readonly" value="<%=medExamObj.getParmanentAddress()%>" name="<%=PERMANENT_ADDRESS%>" maxlength="100" />
 <% }else{%>
   <input type="text"  readonly="readonly" name="<%=PERMANENT_ADDRESS%>"  maxlength="100" />
 <% }%>
 
 <label>DOE/DOC</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	name="<%=DATE_COMMENCEMENT %>"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"
 	readonly="readonly" />
 <% }else{%>
 <input	name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	readonly="readonly"/>
 <% }%>

<label>Record Office</label>
<%if(medExamObj.getRecordoffice()!=null)
 { %>
  <input type="text" readonly="readonly" value="<%=medExamObj.getRecordoffice()%>" name="<%=RECORDOFFICE%>"	maxlength="100"  />
 <% }else{%>
   <input type="text"  readonly="readonly" name="<%=RECORDOFFICE%>"	maxlength="100"  />
 <% }%>

<div class="clear"></div>
 <label>Ceased Duty on</label>
<%if(medExamObj.getCeaseduty()!=null && !(medExamObj.getCeaseduty().equals("")) )
 { %>
  <input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getCeaseduty())%>" name="<%=CEASEDDUTY%>"	 maxlength="10" />
 <% }else{%>
   <input type="text"  readonly="readonly" name="<%=CEASEDDUTY%>"	maxlength="10" />
 <% }%>

 <label>Past Medical History  </label>
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea name="<%=PAST_MEDICAL_HISTORY %>" readonly="readonly"><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea name="<%=PAST_MEDICAL_HISTORY %>" readonly="readonly"></textarea>
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
	<%	}}}	%>
</select> --%>
<div class="clear"></div>
<div>
<label>Signature of Individual</label>
<input type="text" readonly="readonly" />

<label >Date</label>
<% if(medExamObj.getOpiniondate()!=null){%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate"  	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getOpiniondate())%>" />

<% }else{%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate"  	validate="DOB,date,no" maxlength="10"
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
<TH scope="col" colspan="">Date of Origin</TH>
<TH scope="col">Place of Origin</TH>
<TH scope="col">Prev Med Cat</TH>
<TH scope="col" colspan="">Date</TH>
<TH scope="col" colspan="">Next due on</TH> --%>
<TH scope="col">Attributability/Aggravation </TH><%--
<TH scope="col">Remarks</TH> --%>
<TH scope="col">Previous Disablement %</TH>
<TH scope="col" >Present Disablement %</TH>
<TH scope="col">Reasons for Variation if any</TH>
<TH scope="col" colspan="2">Composite</TH>
</tr>
<% int inc1123=0;
	if(medExamObj.getMasmedicaldetail()!=null && medExamObj.getMasmedicaldetail().size()>0)
	{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	if(setMedicalExam.getParticular() !=null && setMedicalExam.getParticular().equalsIgnoreCase("detail")){
	inc1123=inc1123+1;
%>
<TR>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO+inc1123 %>" maxlength="3" value="<%=setMedicalExam.getSerialno() %>"/></td>
<% if(setMedicalExam.getPrincipal()!=null){
	String principal="";
	  if(setMedicalExam.getPrincipal()!=null){
		  principal=setMedicalExam.getPrincipal();
	  }
  int icdId=0;
  String icdCode="";
	if(setMedicalExam.getMasIcd()!=null){
		icdId=setMedicalExam.getMasIcd().getId();
	}if(setMedicalExam.getMasIcd()!=null){
		icdCode=setMedicalExam.getMasIcd().getIcdCode();
	}
	if(principal!=""){
		principal=principal+"["+icdCode+"]";
	}%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="50" value="<%=principal %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="50" /></td>
<% }%><%---
<td width="10%">
<% if(setMedicalExam.getOrigindate()!=null){%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" type="text" class="autoArial" size="10" validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getOrigindate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

<% }%>
</td>

<% if(setMedicalExam.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1123 %>" maxlength="50" value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1123 %>" maxlength="50" /></td>
<% }%>
<td width="10%">

<select 	class="medium" name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>" id="presentMedCategory<%=inc1123 %>"	validate="Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
<%
int categoryId=0;
if(setMedicalExam.getCategory()!=null)
{
	categoryId=setMedicalExam.getCategory().getCategoryid();
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
<% if(setMedicalExam.getMedicalcatdate()!=null){%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getMedicalcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>

<td width="10%">
<% if(setMedicalExam.getNextcatdate()!=null){%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getNextcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>
 --%>
 <%
String categoryDisable="";
String categoryDisPeriod="";
if(setMedicalExam.getCategoryDisability() !=null){
	categoryDisable=setMedicalExam.getCategoryDisability().getCategories();
}
if(setMedicalExam.getCateDisPeriod() !=null){
	categoryDisPeriod=setMedicalExam.getCateDisPeriod();
}
%>
<td><input value="<%=categoryDisable%>" readonly="readonly" class="auto" size="6" name="categoryForDisable" id="categoryForDisable"  /></td>
<td><input value="<%=categoryDisPeriod%>" readonly="readonly" class="auto" size="8" name="medCatPeriod" id="medCatPeriod"/></td>
<td>
<%
String aggravation="";
if(setMedicalExam.getDisabilityAggravation()!=null){
	aggravation=setMedicalExam.getDisabilityAggravation();
}
%>
<select name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no" disabled="disabled">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
<script type="text/javascript">
document.medicalBoardPerusingAuth.aggravation<%=inc1123%>.value='<%=aggravation%>'
</script>
</td>
<%---
<td>
<%
String remarks="";
if(setMedicalExam.getDisabilityRemarks()!=null){
	remarks=setMedicalExam.getDisabilityRemarks();
}
%>
<input tabindex="1" type="text" readonly="readonly" value="<%=remarks%>" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> --%>
<% if(setMedicalExam.getPreDisability()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="prevDisabilities<%=inc1123 %>" maxlength="10" value="<%=setMedicalExam.getPreDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="prevDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getPastDisability()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"name="pastDisabilities<%=inc1123 %>" maxlength="10" value="<%=setMedicalExam.getPastDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="pastDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<% if(setMedicalExam.getReasonVariation()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="variationReason<%=inc1123 %>" maxlength="10" value="<%=setMedicalExam.getReasonVariation() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="variationReason<%=inc1123 %>" maxlength="10" /></td>
<% }%>
<%
String categoryComp="";
String categoryCompPeriod="";
if(setMedicalExam.getCompositeCate() !=null){
	categoryComp=setMedicalExam.getCompositeCate().getCategories();
}
if(setMedicalExam.getCompCatePeriod() !=null){
	categoryCompPeriod=setMedicalExam.getCompCatePeriod();
}
%>
<td><input value="<%=categoryComp%>" readonly="readonly" class="auto" size="6" name="compositeCategory" id="compositeCategory"/></td>
<td><input value="<%=categoryCompPeriod%>" readonly="readonly" class="auto" size="8" name="medCatPeriodComp" id="medCatPeriodComp"/></td>
<%--
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>
 --%>
</TR>
<input type=hidden name="<%=SERVICEID+inc1123 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%}}}if(inc1123<=0){
	inc1123=inc1123+1;%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO+inc1123 %>" value="<%=inc1123 %>" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<%----<td width="10%">
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" type="text" class="autoArial" size="10" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>

<td width="10%"><input tabindex="1" type="text"	readonly="readonly"name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=FROM+inc1123 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="8" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td width="10%">
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" type="text" class="autoArial" size="8" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td> --%>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="categoryForDisable" id="categoryForDisable"/></td>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="medCatPeriod" id="medCatPeriod"/></td>
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
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="compositeCategory" id="compositeCategory" /></td>
<td><input type="text" value="" class="auto" size="6" readonly="readonly" name="medCatPeriodComp" id="medCatPeriodComp"/></td>
<%--
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>
 --%>
</TR>

<% }%>
<input type=hidden name="hdb" value="<%=inc1123%>" id="hdb" />
</table>
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
<input name="medCateRecommed" readonly="readonly" value="<%=medExamObj.getMedicalCategoryRecomended().getCategories() %>"/>
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
<%} %>
 --%>
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
 }%>
 <input type="text" name="shapeFactorRec" value="<%=shapeFactorRec %>" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label >Next Board</label> <label class="auto">Place</label>
<%if(medExamObj.getPlaceNextCatBoard() !=null){ %>
<input type="text" readonly="readonly" name="nextCategorization" maxlength="50" class="auto" size="40" value="<%= medExamObj.getPlaceNextCatBoard()%>"></input>
<%}else{ %>
<input type="text" readonly="readonly" name="nextCategorization" maxlength="50" class="auto" size="40"></input><%} %>
<label class="unit">Date</label>
<%if(medExamObj.getNextBoardDate() !=null){ %>
<input tabindex="1" type="text" readonly="readonly" name="nextBoardDate" class="autoArial"  size="18"  maxlength="10"
			value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getNextBoardDate()) %>" />
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" name="nextBoardDate" class="autoArial"  size="18" readonly="readonly" value="" /><%} %>
<%---
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" class="calender" onclick="" /> --%>

<div class="clear"></div>

<label>Opinion of Medical Board</label>
<!-- <input type="text" name="Opinion" class="auto" size="100" maxlength="200"></input> -->
<%
String medBoardOpinion="";
if(medExamObj.getOpinion() !=null){
	medBoardOpinion=medExamObj.getOpinion();
	}%>

<textarea rows="2" cols="" name="opinionMedicalBoard" class="large" readonly="readonly"><%=medBoardOpinion %></textarea>
<div class="clear"></div>

<label>Dissent Note</label>
<%if(medExamObj.getDissentNote() !=null){ %>
<textarea rows="2" cols="" name="dissentNote" class="large" readonly="readonly">
<%=medExamObj.getDissentNote() %></textarea><%}else{ %>
<textarea rows="2" cols="" name="dissentNote" class="large"  readonly="readonly">
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
<input type="text" readonly="readonly" name="Composite" class="autoArial" size="5" value="<%=medExamObj.getMedComposite()%>" maxlength="3"/>
<%}else{ %>
<input type="text" readonly="readonly" name="Composite" class="autoArial" size="5" maxlength="3"/><%} %>
<label>Employability  Restrictions</label>
<%if(medExamObj.getEmpabiltyRestric() !=null){ %>
<input type="text" size="38" class="autoArial" name="employabilityRestrictions"  value="<%= medExamObj.getEmpabiltyRestric()%>" readonly="readonly" />

<%}else{ %>
<input type="text" size="38" class="autoArial" name="employabilityRestrictions" readonly="readonly" />
<%} %>
<!-- <input type="text" name="Employability" class="auto" size="100" maxlength="50"/> -->

<div class="clear"></div>

<label>Instructions</label>
<%if(medExamObj.getMedInstructions() !=null){ %>
<textarea rows="2" cols="" name="Instructions" class="large" readonly="readonly" >
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
<%if(medExamObj.getOpiniondate() !=null){ %>
<input type="text" readonly="readonly" name="Date"   value="<%=HMSUtil.changeDateToddMMyyyy(medExamObj.getOpiniondate()) %>" maxlength="10"/>
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
<input type="text" readonly="readonly" name="member1" readonly="readonly" value="<%=member1%>" maxlength="32"/>
<label>Member 2</label>
<%String member2="";
	if(medExamObj.getMedDetailMember2() !=null){
	member2=medExamObj.getMedDetailMember2().getFirstName();
	if(medExamObj.getMedDetailMember2().getLastName() !=null){
		member2=member2+" "+medExamObj.getMedDetailMember2().getLastName();
	}
}
	%>
<input type="text" readonly="readonly" name="member2" readonly="readonly" value="<%=member2 %>" maxlength="32"/>


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
<input type="text" name="president" value="<%=president %>" readonly="readonly" maxlength="32"/>

<div class="clear"></div>

<label>Remarks</label>
<%if(medExamObj.getMedRemarks() !=null){ %>
<input type="text" readonly="readonly" name="Remarks" class="auto" size="92" maxlength="100" value="<%=medExamObj.getMedRemarks() %>"
readonly="readonly"/><%}else{ %>
<input type="text" readonly="readonly" name="Remarks" class="auto" size="92" maxlength="100" readonly="readonly"/><%} %>
</div>

<div class="clear"></div>
<h4>APPROVING AUTHORITY</h4>
<div class="clear"></div>
<div class="Block">

<label>Final Observation</label>
<%if(medExamObj.getAprovAuthFinalObservation() !=null){

	%>
<input type="text" readonly="readonly" name="finalObservation" value="<%=medExamObj.getAprovAuthFinalObservation() %>"
			 id="finalObservation" tabindex="1" maxlength="99"/>
<%}else{ %>
<input type="text" readonly="readonly" name="finalObservation"  id="finalObservation" tabindex="1" maxlength="99"/>
<%} %>
<label>Remarks</label>
<%if(medExamObj.getApprovAuthRemarks() !=null){
%>
<input type="text" readonly="readonly" name="authRemarks" value="<%=medExamObj.getApprovAuthRemarks() %>"  id="authRemarks"  tabindex="1" maxlength="99"/>
<%}else{ %>
<input type="text" readonly="readonly" name="authRemarks" value="" id="authRemarks"  readonly="readonly" tabindex="1" maxlength="99"/>
<%} %>

<label>Signed By</label>
<%if(medExamObj.getApprovAuthSignedBy() !=null){
%>
<input type="text" readonly="readonly" name="signedBy" id="signedBy" maxlength="45" value="<%=medExamObj.getApprovAuthSignedBy() %>" tabindex="1" readonly="readonly"/>
<%}else{ %>
<input type="text" readonly="readonly" name="signedBy" id="signedBy" maxlength="45" tabindex="1"/><%} %>
<div class="clear"></div>
</div>


<div class="clear"></div>
<h4>PERUSING AUTHORITY</h4>

<div class="clear"></div>

<div class="Block">

<label>Final Observation</label>
<input type="text" name="perusingFinalObserv"  maxlength="99" value=""  validate="Final Observation,metachar,no"/>

<label>Remarks</label>
<input type="text" name="perusingRemarks" id="perusingRemarks" maxlength="99" value="" validate="Remarks,metachar,no"/>

<label>Signed By</label>
<input type="text" name="perusingSignedBy" maxlength="45" value="<%=signedBy %>" readonly="readonly" validate="Signed By,metachar,no"/>

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="b1" value="VALIDATE" class="button"  onclick="submitForm('medicalBoardPerusingAuth','medicalBoard?method=saveInitialMedicalBoardPerusingAuthJsp');"></input>
<input type="button" name="b2" value="REJECT" class="button" onClick="checkReject();"></input>
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
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="b4" value="View Attachments" class="buttonBig"  onClick="javascript:fileUploadViewWindow('VIEW');"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
function checkReject()
{
	var perusingRemarks=document.getElementById("perusingRemarks").value;
	if(perusingRemarks!=""){
		//alert("Please Enter Medical Board Details Remark. true");
		//submitForm('medicalBoardPerusingAuth','medicalBoard?method=saveInitialMedicalBoardPerusingAuthJsp&rejectStatus=ar');
		submitForm('medicalBoardPerusingAuth','medicalBoard?method=rejectMedicalBoardEntry&rejectStatus=ar');
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
