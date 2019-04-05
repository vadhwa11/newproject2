
<%@page import="jkt.hms.masters.business.MhReferral"%>

<%@ page import="static jkt.hms.util.RequestConstants.REFERRAL_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFER_TO"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERRED_FOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERRED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.NAME_OF_MH"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	List<OpdPatientDetails> referralList=new ArrayList<OpdPatientDetails>();
	if(map.get("referralList") != null){
		referralList= (List<OpdPatientDetails>)map.get("referralList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if(map.get("doctorList") != null){
		doctorList= (List<MasEmployee>)map.get("doctorList");
	}
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	String hin  = "";
		Patient patient = new Patient();
	if(referralList.size() > 0){
		opdPatientDetails = referralList.get(0);
		patient = opdPatientDetails.getVisit().getHin();
		hin = patient.getHinNo();
	}
%>
<label> Referred Date</label> 
<%
	String referraldate= "";
	if(opdPatientDetails.getOpdDate() != null){
		referraldate=HMSUtil.convertDateToStringWithoutTime(opdPatientDetails.getOpdDate());
	}
%>
<input type="hidden" name="referralId" value="<%=opdPatientDetails.getId() %>"/>
<input	type="text" name="<%=REFERRAL_DATE %>" value="<%= referraldate %>" MAXLENGTH="30" id="referralDate" validate="Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.mhReferral.referralDate,event)" /> 
<label>Service No.<span>*</span> </label>
<input type="text" name="<%=SERVICE_NO %>" readonly="readonly" validate="Service No,string,yes" value="<%= patient.getServiceNo()!=null? patient.getServiceNo():"" %>" onblur="if(this.value != ''){openPopUpForPatient(this.value)}" MAXLENGTH="30" />
<label>HIN <span>*</span> </label>
<input type="text" name="<%=HIN_NO %>" id="hinNo" value="<%= hin%>" readonly="readonly" validate="Hin No,string,no" MAXLENGTH="90"/> 
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="<%= patient.getId() %>" /> 
 
 <div class="Clear"></div>
 
 <label>Patient Name<span>*</span> </label> 
 <%
 String pName = "";
	pName =  opdPatientDetails.getVisit().getHin().getPFirstName();
	if(opdPatientDetails.getVisit().getHin().getPMiddleName()!= null)
		pName +=" "+opdPatientDetails.getVisit().getHin().getPMiddleName();
	if(opdPatientDetails.getVisit().getHin().getPLastName()!= null)
		pName +=" "+opdPatientDetails.getVisit().getHin().getPLastName();
 %>
<input type="text" name="<%=PATIENT_NAME %>" id="pNameId" readonly="readonly" value="<%= pName %>" validate="First Name,string,no" MAXLENGTH="90"/>

<label>Relation</label> 
<input	type="text" name="<%=RELATION_NAME%>" id="relationNameId" readonly="readonly" validate="Relation,string,no" value="<%= patient.getRelation().getRelationName() %>" MAXLENGTH="50"  />
<input	type="hidden" name="<%=RELATION_ID%>" id="relationId"  value="<%= patient.getRelation().getId() %>" MAXLENGTH="50"  />

<label>Rank</label> 
<input type="text" name="<%=RANK_NAME %>" id="rankNameId" value="<%= patient.getRank()!=null? patient.getRank().getRankName():"" %>" readonly="readonly" validate="Rank,string,no" MAXLENGTH="90"/> 
<input type="hidden" name="<%=RANK_ID %>" id="rankId" value="<%=  patient.getRank()!=null?patient.getRank().getId():"" %>" MAXLENGTH="90"/>
<div class="Clear"></div>

<label>Name</label> 
<%
String sName = "";
sName = opdPatientDetails.getVisit().getHin().getSFirstName()!null?opdPatientDetails.getVisit().getHin().getSFirstName():"";
if(opdPatientDetails.getVisit().getHin().getSMiddleName()!= null)
	sName +=" "+opdPatientDetails.getVisit().getHin().getSMiddleName();
if(opdPatientDetails.getVisit().getHin().getSLastName()!= null)
	sName +=" "+opdPatientDetails.getVisit().getHin().getSLastName();

%>
<input type="text" 	name="<%=SERVICE_PERSON_NAME %>" id="sNameId" readonly="readonly" value="<%=sName%>" validate="Middle Name,string,no" MAXLENGTH="50" /> 
 
<label>Gender</label> 
<%
if(patient.getSex() != null){
%>
<input	type="text" name="<%=SEX%>" id="sexNameId" validate="Sex,string,no" readonly="readonly" value="<%= patient.getSex().getAdministrativeSexName() %>" MAXLENGTH="50"  />
<input	type="hidden" name="<%=SEX_ID%>" id="sexId" value="<%= patient.getSex().getId() %>" MAXLENGTH="50"  />
<%}else{
	%>
	<input	type="text" name="<%=SEX%>" id="sexNameId" validate="Sex,string,no" readonly="readonly" value="" MAXLENGTH="50"  />
<input	type="hidden" name="<%=SEX_ID%>" id="sexId" value="" MAXLENGTH="50"  />
	
<%} %>
<label>  Age</label> 
<input	type="text" name="<%=AGE%>" id="ageId" validate="Age,string,no" readonly="readonly" value="<%= patient.getAge() %>" MAXLENGTH="50"  />
<div class="Clear"></div>
<label> Diagnosis </label> 
<%
	if(opdPatientDetails.getInitialDiagnosis()!=null){
%>
<input	type="text" name="<%=DIAGNOSIS%>" validate="Diagnosis,string,no" value="<%= opdPatientDetails.getInitialDiagnosis() %>" readonly="readonly" MAXLENGTH="70"  />

<%}else{ %>
<input	type="text" name="<%=DIAGNOSIS%>" validate="Diagnosis,string,no" value="" MAXLENGTH="70" readonly="readonly" />
<%} %>
<label>Referred To <span>*</span></label> 
<input	type="text" name="<%=REFER_TO%>" value="" validate="Refer To,string,yes"  MAXLENGTH="20" />

<label> Referred For <span>*</span> </label> 
<input	type="text" name="<%=REFERRED_FOR%>" value="" validate="Referred For,string,yes"  MAXLENGTH="100" />
<div class="Clear"></div>
<!--<label><span>*</span>   Hospital/Center</label> 
<input	type="text" name="<%=NAME_OF_MH%>" value="" validate="Hospital/Center,string,yes"  MAXLENGTH="200" />

-->
<label>   Referred By </label> 
<%
String doctor = "";
doctor =  opdPatientDetails.getEmployee().getFirstName();
if(opdPatientDetails.getEmployee().getMiddleName()!= null)
	doctor +=" "+opdPatientDetails.getEmployee().getMiddleName();
if(opdPatientDetails.getEmployee().getLastName()!= null)
	doctor +=" "+opdPatientDetails.getEmployee().getLastName();

%>
<label class="value"><%= doctor %></label>
<input	type="hidden" name="<%=REFERRED_BY%>" id="referredBy" value="<%= opdPatientDetails.getEmployee().getId() %>" MAXLENGTH="50"  />
<label> MH Run Date <span>*</span> </label> 
<input	type="text" name="runDate" value="" MAXLENGTH="30" id="runDate" validate="Run Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.mhReferral.runDate,event)" /> 
<%--
<select id="referredBy" name="<%= REFERRED_BY %>" validate="Referred By,string,yes" >
<option value="0">Select</option>
<%
int referredBy = 0;
if(referral.getReferredBy() != null){
	referredBy = referral.getReferredBy().getId();
}
%>
<%
	for(MasEmployee employee : doctorList){
%>
<option value="<%= employee.getId() %>"><%=employee.getFirstName()+" "+employee.getLastName() %></option>
<%} %>
</select>
<script type="text/javascript">
document.getElementById('referredBy').value='<%=referredBy%>';
</script> --%>
<input type="hidden" name="opdId" value="<%= opdPatientDetails.getId() %>"/>
<div class="Clear"></div>
<script>
//document.getElementById('addbutton').style.display = 'none';
//document.getElementById('updatebutton').style.display = 'block';
</script>
