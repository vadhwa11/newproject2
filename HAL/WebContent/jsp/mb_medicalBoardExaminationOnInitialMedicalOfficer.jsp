
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>


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
<%@page import="jkt.hms.masters.business.Disabilitygroup"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
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
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
 
   }
String accessjsp=null;
if (map.get("accessjsp") != null) {
	accessjsp = (String) map.get("accessjsp");
     
   }
String method=null;
if (map.get("method") != null) {
	method = (String) map.get("method");
      
   }
List<MasIcd> masIcdList = new ArrayList<MasIcd>();
if(map.get("masIcdList") != null){
	masIcdList=(List)map.get("masIcdList");

	}
List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
if(map.get("disabilitygroupList") != null){
	disabilitygroupList=(List)map.get("disabilitygroupList");

	}
//String ControllerUrl="/medicalBoard?method="+method+"&visitId="+visit.getId()+"&medExamType="+jspheading+"&accessjsp="+accessjsp+"&search="+search;
//System.out.println("ControllerUrl---"+ControllerUrl);
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


<!--main content placeholder starts here-->
<div class="titleBg">
<h2><%=jspheading %></h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="MedicalBoardInitialMedExamJsp" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){
	
	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>


<div class="Block">
<label>Name  </label> 

  <input	type="text"  readonly="readonly"  value="<%= visit.getHin().getSFirstName() %>"   name="<%=FULL_NAME%>"	tabindex="2" maxlength="20"/>
 
<label>Service Number </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />
 
<% }else{%>

 <input type="hidden"	value="Initial Medical Board AFMSF 15" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"  readonly="readonly" 	 name="<%=SERVICE_NO %>"   tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label> 
   <input type="text"  readonly="readonly"  value="<%= visit.getHin().getRank().getRankName() %>"   name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />
 
 
 <div class="clear"></div>
  <label>Unit </label> 
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text"  readonly="readonly"    maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text"  readonly="readonly"    maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 <label>Service</label> 
 <input	type="text"  readonly="readonly"  value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>"   name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <label>Branch/Trade  </label> 
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  readonly="readonly"   name="<%=TRADE%>"	  tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  readonly="readonly"   name="<%=TRADE%>"	tabindex="2" />
 
 <% }%>
 <div class="clear"></div>
 <label><span>*</span> Date Of Birth  </label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>"   class="date"  readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date"  readonly="readonly" value=""
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
	
	<% }%>
 <label>Age  </label> 
  <% if(visit.getHin().getAge()!=null){%>
<input	type="text"  readonly="readonly"    maxlength="20"  value="<%=visit.getHin().getAge() %>" name="apparentAge"	tabindex="2" />

 <% }else{%>
<input	type="text"  readonly="readonly"    maxlength="20"  value="" name="typeOfCommunication"	tabindex="2" />

 <% }%>
 <label>Sex</label> 
  <input	type="text"  readonly="readonly"    value="<%= visit.getHin().getSex().getAdministrativeSexName() %>" name="apparentAge"	tabindex="2" maxlength="20" />
  <div class="clear"></div>
  <label>Weight  </label> 
 <%if(medExamObj.getPatientweight()!=null)
 { %>
  <input	type="text"  readonly="readonly"  value="<%=medExamObj.getPatientweight()%>" name="patientweight"	tabindex="2" maxlength="20" />
 <% }else{%>
   <input	type="text"  readonly="readonly"   name="patientweight"	tabindex="2" maxlength="20" />
 <% }%>


<label>Height  </label> 
<%if(medExamObj.getPatientheight()!=null)
 { %>
  <input	type="text"  readonly="readonly"  value="<%=medExamObj.getPatientheight()%>" name="patientheight"	tabindex="2" maxlength="20" />
 <% }else{%>
   <input	type="text"  readonly="readonly"   name="patientheight"	tabindex="2" maxlength="20" />
 <% }%>

  

 <label>Address On Leave <br /><span class="sublabel">(If Any)</span></label> 
<%
if(medExamObj.getPermanentAddress()!=null)
 {
	%>
  <input	type="text"  readonly="readonly"  value="<%=medExamObj.getPermanentAddress()%>" name="<%=PERMANENT_ADDRESS%>"	tabindex="2" maxlength="20" />
 <% }else{%>
   <input	type="text"  readonly="readonly"   name="<%=PERMANENT_ADDRESS%>"	tabindex="2" maxlength="20" />
 <% }%>

 <div class="clear"></div>
 <label>Date Of<br /><span class="sublabel">(Commissioning Enrollment)</span></label> 
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>"   class="date"  readonly="readonly"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"  />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date"  readonly="readonly"   value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	 />
 <% }%>
  
 <label>Record Office</label> 
<%if(medExamObj.getRecordoffice()!=null)
 { %>
  <input	type="text"  readonly="readonly"  value="<%=medExamObj.getRecordoffice()%>" name="<%=RECORDOFFICE%>"	maxlength="20" tabindex="2" />
 <% }else{%>
   <input	type="text"  readonly="readonly"   name="<%=RECORDOFFICE%>"	maxlength="20" tabindex="2" />
 <% }%>

 
 <label>Ceased Duty Or Not Ceased</label> 
 
<%if(medExamObj.getCeaseduty()!=null && !(medExamObj.getCeaseduty().equals("")))
 { %>
  <input	type="text"  readonly="readonly"  value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getCeaseduty())%>" name="<%=CEASEDDUTY%>"	tabindex="2" maxlength="20" />
 <% }else{%>
   <input	type="text"  readonly="readonly"   name="<%=CEASEDDUTY%>"	tabindex="2" maxlength="20" />
 <% }%>
 <div class="clear"></div>
 <label>Past Medical History  </label> 
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea readonly="readonly"  tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);"><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea readonly="readonly" tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);"></textarea>
 <% }%>
<label>Present Med Categ <br /><span class="sublabel">(Prior To Present Medical Board)</span></label>
<select disabled="disabled"	name="<%= PAST_MEDICAL_CATEGORY %>"	validate="Signed By,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
	if(medExamObj.getPastMedicalCategory()!=null)
	{
			for (Category category : categoryList) {
				if(medExamObj.getPastMedicalCategory().getCategoryid().equals(category.getCategoryid()))
					{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%}}}else{
		for (Category category : categoryList) {
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}
				
				}	%>
</select> 


 

<label >Present Med Cat.Date</label> 
<% if(medExamObj.getOpiniondate()!=null){%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date"  readonly="readonly" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getOpiniondate())%>" /> 

<% }else{%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date"  readonly="readonly" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date%>" /> 
<% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" 
	 />


</div>

<div class="clear paddingTop15"></div>
<h4> DETAILS OF PRESENT AND PREVIOUS DISABILITY <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">S.No.</TH>
<TH scope="col">Disabilities(Principal/Others)</TH>
<TH scope="col" colspan="2">Date Of Origin</TH>
<TH scope="col" >Place Of Origin</TH>
<TH scope="col">Previous Medical Cat</TH>
<TH scope="col" colspan="2">Previous Medical Cat  Date</TH>
<TH scope="col" colspan="2">Next Cat due On</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc1123=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
	
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	if(setMedicalExam.getParticular().equalsIgnoreCase("detail")){
	inc1123=inc1123+1;
	
	%>

<TR>
<td width="10%"><input tabindex="1" size="2" type="text"  readonly="readonly" 	name="<%=SIRIAL_NO+inc1123 %>" maxlength="3" value="<%=setMedicalExam.getSerialno() %>"/></td>
<% if(setMedicalExam.getPrincipal()!=null){%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" value="<%=setMedicalExam.getPrincipal() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<% }%>
<td width="10%">
<% if(setMedicalExam.getOrigindate()!=null){%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="date"  readonly="readonly"  	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getOrigindate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<% }else{%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>
<% if(setMedicalExam.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PLACE+inc1123 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getAddressfrom()!=null){%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=FROM+inc1123 %>" maxlength="10" value="<%=setMedicalExam.getAddressfrom() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=FROM+inc1123 %>" maxlength="10" /></td>
<% }%>
<td width="10%">
<% if(setMedicalExam.getMedicalcatdate()!=null){%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getMedicalcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<% }else{%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>
<td width="10%">
<% if(setMedicalExam.getNextcatdate()!=null){%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getNextcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<% }else{%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>


<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc1123 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
	}}}else{
	inc1123=inc1123+1;
%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text"  readonly="readonly" 	name="<%=SIRIAL_NO+inc1123 %>" value="<%=inc1123 %>" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>

<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=FROM+inc1123 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>

<td width="10%">
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="date"  readonly="readonly" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
</td>


<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb" value="<%=inc1123%>" id="hdb" />
</table>
</div>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">

<h4>Specialist Opinion<a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<input name="Send" type="button"  class="button" value="Upload"  />
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getMedExamType().equalsIgnoreCase("Initial Medical Board AFMSF 15")){%>
<div class="clear paddingTop15"></div>
<h4>Case Summary <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">

<label > Disability Attributable <br /><span class="sublabel">(to service)</span></label> 
<select disabled="disabled"name=<%=DISABILITY%> size="0" tabindex="1" id="disability" class="small" onchange="changeRemark()">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisability()!= null){
%>
document.getElementById('disability').value='<%=medExamObj.getDisability()%>';

<%}%>
</script>


<% if(medExamObj.getDisabilityAttribute() != null && medExamObj.getDisability().equalsIgnoreCase("Yes")){ %>
<label > Remark</label> 
<input tabindex="1" type="text"  readonly="readonly"  id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  value="<%=medExamObj.getDisabilityAttribute()%>" size="100" maxlength="100" />
<%}%>
<div id="disattribute" style="display: none">
<label >Remark</label> 
<input tabindex="1" type="text"  readonly="readonly"  id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  size="100" maxlength="100" />
</div>
<label>Case Summary</label> 

	<% if(medExamObj.getCaseSheet() != null){ %>
 <textarea readonly="readonly" tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"><%=medExamObj.getCaseSheet()%></textarea>
<%}else{ %>
 <textarea readonly="readonly" tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"></textarea>
	
	<%} %>


<div class="clear"></div> 
<label > Aggravated <br /><span class="sublabel">by Service)</label> 
<select disabled="disabled"name=<%=AGGRAVATED_SERVICE_LABEL%> size="0" tabindex="1" id="aggravated" class="small" onchange="changeRemark1()">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getAggravatedService()!= null){
%>
document.getElementById('aggravated').value='<%=medExamObj.getAggravatedService()%>';

<%}%>
</script>



<% if(medExamObj.getAggravatedServiceDesc() != null && medExamObj.getAggravatedService().equalsIgnoreCase("Yes")){ %>
<label >Remark</label> 
<input tabindex="1" type="text"  readonly="readonly"  name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" value="<%=medExamObj.getAggravatedServiceDesc()%>" class="Auto" size="100" maxlength="100" />
<%}%>
<div id="aggravatedid" style="display: none">
<label >Remark</label>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" class="Auto" size="100" maxlength="100" />
</div>

</div>
</div>
</div>
<% }%>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"  readonly="readonly"    name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  readonly="readonly"   name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"  readonly="readonly"    name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  readonly="readonly"   name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Points</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  readonly="readonly"   name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  readonly="readonly"   name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="auto">Unsaveable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"  readonly="readonly"    name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  readonly="readonly"   name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  readonly="readonly"   name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  readonly="readonly"   name="<%=CONDITION_OF_GUMS %>"
	class="small" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" disabled="disabled" onclick="chkValue(this);" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  disabled="disabled" onclick="chkValue(this);" />
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
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12"  disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  disabled="disabled" onclick="chkValue(this);" />
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
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" disabled="disabled" onclick="chkValue(this);" />
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
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" disabled="disabled" onclick="chkValue(this);" />
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
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" disabled="disabled" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" disabled="disabled" onclick="chkValue(this);" />
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
<label class="medium"> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea readonly="readonly" rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,150);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea readonly="readonly" rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,150);"></textarea>
 <% }%>

	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>

<div class="clear paddingTop15"></div>


<h4> PHYSICAL CAPACITY <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"    id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"  value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"    id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" 
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"   id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"    id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"    id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" size="20" class="auto" />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto"  size="20" />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);"  /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>

<label	>Sports Man</label> 
<select disabled="disabled"name="<%=SPORTS %>"  id="<%=SPORTS %>" validate="Sports Man,stirng,no"  >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>
<label	>WHR</label> 
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="WHR" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>
 <div class="clear"></div>
 <label	>Hip</label> 
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="" name="Hips" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
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
 <input tabindex="1" type="text"  readonly="readonly"    	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"   	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"   name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"   name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"   name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"   	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>	
		
	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"   id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text"  readonly="readonly"   id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6"  onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text"  readonly="readonly"   id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text"  readonly="readonly"   id="hrfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text"  readonly="readonly"   id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="1" type="text"  readonly="readonly"   id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);"/>
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text"  readonly="readonly"   id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>	
	 <input tabindex="1" type="text"  readonly="readonly"    id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	  <%}else{ %>
	    <input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text"  readonly="readonly"   id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="1" type="text"  readonly="readonly"   id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%} %>
</div>
</div>

<div class="clear paddingTop15"></div>

<%	int count=1;
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
	%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
	
<%count++;}
    }
%>
<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>

<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select disabled="disabled"name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
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
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig"  />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	 />
</div>
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
	<td><input type="text"  readonly="readonly"  name="clinicalNotes1" tabindex="1" size="100" maxlength="45" /></td>
	
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
String Labresult="NotPresent";
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>
<%  }


if( medExamObj.getDateOfReporting()==null)
{%>	
 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
	validate="Reported Date,date,no" /> 
<% }else{%>
 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
	validate="Reported Date,date,no" /> 

<% }
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
		<td><input type="text"  readonly="readonly"  value="<%=key%>"  
			  tabindex="2" id="chargeCodeName<%=inc %>"
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
	<td><input type="text"  readonly="readonly"  value="<%=second.get(first.get(key))%>"  
			  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }else{%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>
	
<%}}else{%>
<td><input type="text"  readonly="readonly"  value=""  
			  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
<td><input name="Button" type="button" class="buttonAdd" value=""  /></td>
	<td><input type="button" name="delete" value="" class="buttonDel"  /></td>
	</tr>
	
	<% inc++;
		    }
		   
%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text"  readonly="readonly"  value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');,'parent'}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  readonly="readonly"   name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<td>
<input type="text"  readonly="readonly"  value=""   name="Result" id="Result" />
</td>
<td><input name="Button" type="button" class="buttonAdd" value=""  /></td>
	<td><input type="button" name="delete" value="" class="buttonDel"  /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	

<% }%>


</table>
</div>
</div>
<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10"  value="<%=medExamObj.getPulseRates() %>"/>
  <label class="small">/min</label>
 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10" /><label class="small">/min</label>
 <% }%>
 <label class="medium">BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%=BP1%>" class="auto" size="17" maxlength="10"  value="<%=medExamObj.getBp() %>"/>
 <label class="small">mm/Hg</label>
 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%=BP1%>" class="auto" size="17" maxlength="10" />
 <label class="small">mm/Hg</label>
 <% }%>
<label>Arterial Walls</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20" maxlength="10"  value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="17" 	name="<%= HEART_SIZE%>" class="auto" size="17" maxlength="10" value="<%=medExamObj.getHeartSize() %>"/>
 <label class="small">&nbsp;</label>
 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="17" 	name="<%= HEART_SIZE%>" class="auto" size="17" maxlength="10" />
  <label class="small">&nbsp;</label>
 <% }%>


 <label class="medium">Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%= SOUND%>" class="auto"	size="17" maxlength="10" value="<%=medExamObj.getSounds() %>"/> 
 <label class="small">&nbsp;</label>
 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%= SOUND%>" class="auto"	size="17" maxlength="10" /> 
  <label class="small">&nbsp;</label>
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%= RHYTHM%>" class="auto"	size="20" maxlength="10" value="<%=medExamObj.getRhythm() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"  maxlength="10"  name="<%= RHYTHM%>" class="auto"	size="20" maxlength="10" /> 
 <% }%>


<div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Liver Palpalable</label> 
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="liver" class="auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="liver" class="auto" size="120" maxlength="100" />
 <% }%>

<label> Spleen Palpalable</label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="spleen" class="auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="spleen" class="auto" size="120" maxlength="100" />
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
<label > Higher Mental Func</label> 
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" />
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=SPEECH %>"  maxlength="10" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=SPEECH %>"  maxlength="10" />
 <% }%>


<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=REFLEXES %>"  maxlength="10" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=REFLEXES %>"  maxlength="10" />
 <% }%>


<div class="clear"></div>
<label > Tremors</label> 
<select disabled="disabled"name="<%=TREMORS %>" size="0" tabindex="1" id="tremors">
<option value="0">select</option>
	<option value="Nil">Nil</option>
	<option value="Fine">Fine</option>
	<option value="Coarse">Coarse</option>
</select>
<script>
<%
if(medExamObj.getTremors()!= null){
%>
document.getElementById("tremors").value='<%=medExamObj.getTremors()%>';

<%}%>
</script>

<label > Self Balancing Test</label> 

<select disabled="disabled"name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest">
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
<label >Locomoter System</label> 
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="locomoterSystem" class="auto" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  name="locomoterSystem" class="auto" size="20" maxlength="10" />
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="spine" class="auto" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>

<input tabindex="1" type="text"  readonly="readonly"  name="spine" class="auto" size="20" maxlength="10" />
 <% }%>


<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"   name="<%=HERNIA_MUSCLE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>

<input tabindex="1" type="text"  readonly="readonly"  name="<%=HERNIA_MUSCLE %>" class="auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label> 
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=HYDROCELE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
   
<input tabindex="1" type="text"  readonly="readonly"  name="<%=HYDROCELE %>" class="auto" size="20" maxlength="10" />
 <% }%>


<label>Haemorrhoids</label> 
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=HEMONHOIDS %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=HEMONHOIDS %>" class="auto" size="20" maxlength="10" />
 <% }%>


<label>Breast</label> 
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=BREASTS %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=BREASTS %>" class="auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>

</div>
</div>


<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" />
 <% }%>
 

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"   	name="<%=LMP %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getLmp() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=LMP %>" class="auto" size="20" maxlength="3" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=NO_OF_PREGNANCY %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=NO_OF_PREGNANCY %>" class="auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
 
<div class="clear"></div>	
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="noofabo"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  id="noofabo"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=NO_OF_CHILDREN %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"   	name="<%=NO_OF_CHILDREN %>" class="auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>


<label >Date <br /><span class="sublabel">(last confinement)</span></label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"   class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"   class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	 />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="10" />
 <% }%>
 

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=PROLAPSE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  	name="<%=PROLAPSE %>" class="auto" size="20" maxlength="10" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=USG_ABORTION %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=USG_ABORTION %>" class="auto" size="20" maxlength="10" />
 <% }%>



</div>
</div>



<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label >Medical Categ. Now</label> 
 <select disabled="disabled"	name="<%= PRESENT_MEDICAL_CATEGORY %>"	validate="Signed By,string,no" tabindex=1>
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
</select> 
 
<label >Duration</label> 
<% if(medExamObj.getMonthlySerialNo() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name="MonthlySerialNo"  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getMonthlySerialNo() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name="MonthlySerialNo"  class="Auto" size="20" maxlength="20" />
	  <%} %>

<label >Place Of <br /> <span class="sublabel">(Next Categorization Board)</span></label> 
<% if(medExamObj.getCategoryplace() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=CATEGORIZATION_PLACE%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getCategoryplace() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=CATEGORIZATION_PLACE%>  class="Auto" size="20" maxlength="20" />
	  <%} %>

<div class="clear"></div>
<label >Date Of <br /> <span class="sublabel">(Next Categorization Board)</span></label> 
<% if(medExamObj.getCategorydate() != null){ %>
<input	tabindex="1" name="<%=CATEGORIZATION_DATE %>" 	validate="Entry Date,date,no" value="<%=date %>" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" value=<%=medExamObj.getCategorydate() %>/>
	  <%}else{ %>
<input	tabindex="1" name="<%=CATEGORIZATION_DATE %>" 	validate="Entry Date,date,no" value="<%=date %>" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />
	  <%} %>
  <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"  />

<label >Opinion Of Medical Board</label> 
<% if(medExamObj.getDocumentForwardTo() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=DOCUMENT_FORWARD_TO %>"  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getDocumentForwardTo() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name="<%=DOCUMENT_FORWARD_TO %>" class="Auto" size="20" maxlength="20" />
	  <%} %>

<label >Disssent Notes</label> 
<% if(medExamObj.getArmsCorps() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=ARMS_CROPS%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getArmsCorps() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=ARMS_CROPS%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
</div>
<div class="clear paddingTop15"></div>
<h4>PERCENTAGE OF DISABILITY(ONLY FOR PERMANENT LMC) <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="disabilitygrid">
	<tr>
<TH scope="col">S.No.</TH>
<TH scope="col">Disability%</TH>
<TH scope="col">ICD Code</TH>
<TH scope="col">Disability Group</TH>
<TH scope="col">Previous Disability%</TH>
<TH scope="col" >Present Disability%</TH>
<TH scope="col">Reason</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc11234=0;
String valuefound="false";
if(medExamObj.getMasmedicaldetail()!=null)
{
		
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if(setMedicalExam.getParticular() !=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		
		inc11234=inc11234+1;
		valuefound="true";
	%>

<TR>
<td width="10%"><input tabindex="1" size="2" type="text"  readonly="readonly"  id="<%=SIRIAL_NO1+inc11234 %>" 	name="<%=SIRIAL_NO1+inc11234 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>

<td width="10%">
<select disabled="disabled"name="<%=DISABILITYID+inc11234 %>" id="<%=DISABILITYID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
    
	 for(Disability masrank : disabilityList){
		 	if ((setMedicalExam.getDisability()!=null)&&(masrank.getDisabilityid()==(setMedicalExam.getDisability().getDisabilityid()))) {
		 	%>
		 <option value="<%=masrank.getDisabilityid ()%>" selected="selected"><%=masrank.getDisability()%>
		 </option>
		 <%}else{
		
		 %><option value="<%=masrank.getDisabilityid()%>"><%=masrank.getDisability()%>
		 	</option>
		 	<script>
		 	disabilityListArray[<%=j%>]= new Array();
		 	disabilityListArray[<%=j%>][0] = "<%=masrank.getDisabilityid()%>";
		 	disabilityListArray[<%=j%>][1] = "<%=masrank.getDisability()%>";
            </script>		 	
		 	<%	}
		 	j=j+1;
		 	}%>
    </select> 
    </td>
<td width="10%">
<select disabled="disabled"name="<%=ICDID+inc11234 %>" id="<%=ICDID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j1=0;
    
	 for(MasIcd masrank : masIcdList){
		 	if ((setMedicalExam.getMasIcd()!=null)&&(masrank.getId()==(setMedicalExam.getMasIcd().getId()))) {%>
		 <option value="<%=masrank.getId()%>" selected="selected"><%=masrank.getIcdName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId()%>"><%=masrank.getIcdName()%>
		 	</option>
		 	<script>
		 	masIcdListArray[<%=j1%>]= new Array();
		 	masIcdListArray[<%=j1%>][0] = "<%=masrank.getId()%>";
		 	masIcdListArray[<%=j1%>][1] = "<%=masrank.getIcdName()%>";
            </script>		 	
		 	<%	}
		 	j1=j1+1;
		 	}%>
    </select> 
    </td>
    <td width="10%">
<select disabled="disabled"name="<%=DISABILITYGROUPID+inc11234 %>" id="<%=DISABILITYGROUPID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j3=0;
    
	 for(Disabilitygroup masrank : disabilitygroupList){
		 	if ((setMedicalExam.getDisabilitygroup()!=null)&&(masrank.getGroupid()==(setMedicalExam.getDisabilitygroup().getGroupid()))) {%>
		 <option value="<%=masrank.getGroupid()%>" selected="selected"><%=masrank.getDiseaseGroups()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getGroupid()%>"><%=masrank.getDiseaseGroups()%>
		 	</option>
		 	<script>
		 	disabilitygroupListArray[<%=j3%>]= new Array();
		 	disabilitygroupListArray[<%=j3%>][0] = "<%=masrank.getGroupid()%>";
		 	disabilitygroupListArray[<%=j3%>][1] = "<%=masrank.getDiseaseGroups()%>";
            </script>		 	
		 	<%	}
		 	j3=j3+1;
		 	}%>
    </select> 
    </td>


<% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=ILLNESS+inc11234 %>" id="<%=ILLNESS+inc11234 %>" maxlength="10" value="<%=setMedicalExam.getIllness() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=ILLNESS+inc11234 %>"  id="<%=ILLNESS+inc11234 %>" maxlength="10" /></td>
<% }%>
<td width="10%">
<% if(setMedicalExam.getPlace1()!=null){%>
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text"  readonly="readonly"  value="<%=setMedicalExam.getPlace1()%>" 	 maxlength="10" id="<%=PLACE1+inc11234 %>" /> 
<% }else{%>
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text"  readonly="readonly"   	 maxlength="10" id="<%=PLACE1+inc11234 %>" /> 
<% }%>
</td>

<td width="10%">
<% if(setMedicalExam.getTreated()!=null){%>
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text"  readonly="readonly"  value="<%=setMedicalExam.getTreated()%>" 	 maxlength="10" id="<%=TREATED+inc11234 %>"/> 
<% }else{%>
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text"  readonly="readonly"   	 maxlength="10" id="<%=NEXT_CAT_DATE+inc11234 %>" /> 
<% }%>
</td>



<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11234 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
	}}}
if(valuefound.equalsIgnoreCase("false")){
	inc11234=inc11234+1;
	
	%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text"  readonly="readonly"  value="<%=inc11234 %>" id="<%=SIRIAL_NO1+inc11234 %>"	name="<%=SIRIAL_NO1+inc11234 %>" maxlength="3" /></td>
<td width="10%">
<select disabled="disabled"name="<%=DISABILITYID+inc11234 %>" id="<%=DISABILITYID+inc11234 %>"  validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
   
	 for(Disability masrank : disabilityList){
		 %><option value="<%=masrank.getDisabilityid()%>"><%=masrank.getDisability()%>
		 	</option>
		 	<script>
		 	disabilityListArray[<%=j%>]= new Array();
		 	disabilityListArray[<%=j%>][0] = "<%=masrank.getDisabilityid()%>";
		 	disabilityListArray[<%=j%>][1] = "<%=masrank.getDisability()%>";
            </script>		 	
		 	<%	
		 	j=j+1;
		 	}%>
    </select> 

</td>
<td width="10%">
<select disabled="disabled"name="<%=ICDID+inc11234 %>" id="<%=ICDID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j1=0;
    
	 for(MasIcd masrank : masIcdList){
	%><option value="<%=masrank.getId()%>"><%=masrank.getIcdName()%>
		 	</option>
		 	<script>
		 	masIcdListArray[<%=j1%>]= new Array();
		 	masIcdListArray[<%=j1%>][0] = "<%=masrank.getId()%>";
		 	masIcdListArray[<%=j1%>][1] = "<%=masrank.getIcdName()%>";
            </script>		 	
		 	<%	
		 	j1=j1+1;
		 	}%>
    </select> 

    </td>
    <td width="10%">
<select disabled="disabled"name="<%=DISABILITYGROUPID+inc11234 %>" id="<%=DISABILITYGROUPID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j3=0;
    
	 for(Disabilitygroup masrank : disabilitygroupList){
	%><option value="<%=masrank.getGroupid()%>"><%=masrank.getDiseaseGroups()%>
		 	</option>
		 	<script>
		 	disabilitygroupListArray[<%=j3%>]= new Array();
		 	disabilitygroupListArray[<%=j3%>][0] = "<%=masrank.getGroupid()%>";
		 	disabilitygroupListArray[<%=j3%>][1] = "<%=masrank.getDiseaseGroups()%>";
            </script>		 	
		 	<%	
		 	j3=j3+1;
		 	}%>
    </select> 
    </td>


<td width="10%"><input tabindex="1" type="text"  readonly="readonly" 	name="<%=ILLNESS+inc11234 %>" id="<%=ILLNESS+inc11234 %>"  maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text"  readonly="readonly"   	 maxlength="10" id="<%=PLACE1+inc11234 %>" /> 
</td>

<td width="10%">
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text"  readonly="readonly"   	 maxlength="10" id="<%=TREATED+inc11234 %>" /> 
</td>


<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11234%>" id="hdb1" />
</table>
</div>
</div>
<div class="clear paddingTop15"></div>

<div class="Block">

<label >Any Restriction <br /> <span class="sublabel">(Regarding Employment)</span></label> 
<% if(medExamObj.getRestrictionemployment() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=RESTRICTION_EMPLOYMENT%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getRestrictionemployment() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=RESTRICTION_EMPLOYMENT%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
<label >Instruction Given to <br /> <span class="sublabel">(Indvidual By the President of the Board)</span></label> 
<% if(medExamObj.getInstructionByPresident() != null){ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=INSTRUCTION_BY_PRESIDENT%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getInstructionByPresident() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text"  readonly="readonly"  name=<%=INSTRUCTION_BY_PRESIDENT%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
	 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" /> 


<div class="clear"></div>

<label >Board President</label>

<select disabled="disabled" id="<%=BOARD_PRESIDENT %>"	name="<%= BOARD_PRESIDENT %>" 	validate="Approved By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
		String mname=" ";
		
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					
						if ((medExamObj.getApprovedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getApprovedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname=masEmployeecode.getMiddleName();
					}
					
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{
		
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}}	%>
</select> 
  

<label >Board Member</label>

<select disabled="disabled"  id="<%=BOARD_MEMBER %>"	name="<%= BOARD_MEMBER %>" 	validate="Approved By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user1 = (Users)session.getAttribute("users");
		Integer userId1 =user.getEmployee().getId();
		String mname1=" ";
		
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					
						if ((medExamObj.getApprovedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getApprovedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname=masEmployeecode.getMiddleName();
					}
					
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{
		
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}}	%>
</select> 
 <label >Send To</label> 

<select disabled="disabled" name="<%=SEND_TO %>" size="0" tabindex="1" id="sendto">
	<option value="0">select</option>
	<option value="AFRO">AFRO</option>
	<option value="MO">MO</option>
	<option value="DPMO-COMMAND">DPMO-COMMAND</option>
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

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<% if(search !=null && search.equalsIgnoreCase("false")){%>

<input tabindex="1" name="Button"	type="button" class="button" value="Update"	onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=updateMedicalExamEntry&Labresult=<%=Labresult.trim() %>&SecialFlag=&directFlag=');" />
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=RESET name=Reset> 
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=rejectMedExam');" />
<input name="Send" type="button"  class="button" value="Case Sheet" onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=getCaseSheetDetails&requestedjsp=specialist&medExamId=<%=medExamId %>&method12=<%=method%>&visitId=<%=visit.getId()%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>');" />
 
  <% }%>
  </div>
<!-- <input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Appointment name=Reset> -->

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
<input type="hidden" value="MedicalBoard" name="medicalType" id="hiddenValue" />
</div>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>


<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){
	%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />

<%}%>
</form>
<!--Bottom labels starts--> <!--main content placeholder ends here--> 
<script type="text/javascript">
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
			
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
		  	
				submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
				}
	
	}
 function addRowForInvestigation(){
      
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

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
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'result1' + iteration;
	  e1.id = 'result1' + iteration;
	 // e1.size = '30';
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

	 var cellRight1 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForInvestigation();');
	  cellRight2.appendChild(e4);
	  
	   //fayaz removed
	  //var cellRight3 = row.insertCell(1);
	 // var e3 = document.createElement('input');
	 // e3.type = 'text';
	 // e3.name='clinicalNotes'+iteration;
	 // e3.id='clinicalNotes'+iteration;
	 // e3.setAttribute('tabindex','1');
	 // e3.size='60'
	 // cellRight3.appendChild(e3);

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
	    submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
		}
//		document.getElementById('prescriptionImportButton').style.display = 'none';
//		document.getElementById("investigationImportButton").style.display='none'
	 }
 function validateInvestigationAutoComplete( strValue,inc ) {

		var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    //alert("id----"+id)

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

 function addRow(){
	  
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);

	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'serialNo' + iteration;
	  e0.id = 'serialNo' + iteration;
	  e0.setAttribute('maxlength', 3); 
	  e0.value=hdb.value;
      e0.size = '2';
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'principal' + iteration;
	  e1.id = 'principal' + iteration;
	  e1.setAttribute('maxlength', 10); 
      e1.size = '20';
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);

     
     var cellRight2 = row.insertCell(2);
	 var e2 = document.createElement('input');
	 e2.type = 'text';
	 e2.name = 'origindate' + iteration;
	 e2.id = 'origindate' + iteration;
     e2.className = 'date';
     e2.value='<%=date %>';
     e2.setAttribute('maxlength', 10); 
	 e2.setAttribute('tabindex','1');
     cellRight2.appendChild(e2);

     var cellRight3 = row.insertCell(3);
	 var e3 = document.createElement('img');
     e3.src = '/hms/jsp/images/cal.gif';
    // e3.style.display ='none';
     e3.id = 'calId'+iteration;
     e3.onclick = function(event){
     setdate('',document.getElementById('origindate'+iteration),event) };
     cellRight3.appendChild(e3);

     var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'place' + iteration;
	  e4.id = 'place' + iteration;
     e4.size = '20';
     e4.setAttribute('maxlength', 10); 
	  e4.setAttribute('tabindex','1');
     cellRight4.appendChild(e4);
     
     var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'from' + iteration;
	  e5.id = 'from' + iteration;
	  e5.setAttribute('maxlength', 10); 
     e5.size = '20';
	  e5.setAttribute('tabindex','1');
     cellRight5.appendChild(e5);

     var cellRight6 = row.insertCell(6);
	 var e6 = document.createElement('input');
	 e6.type = 'text';
	 e6.name = 'medicalcatdate' + iteration;
	 e6.id = 'medicalcatdate' + iteration;
     e6.className = 'date';
     e6.value='<%=date %>';
     e6.setAttribute('maxlength', 10); 
	 e6.setAttribute('tabindex','1');
     cellRight6.appendChild(e6);

     var cellRight7 = row.insertCell(7);
     var e7 = document.createElement('img');
     e7.src = '/hms/jsp/images/cal.gif';
    // eImg.style.display ='none';
     e7.id = 'calId'+iteration;
     e7.onclick = function(event){
     setdate('',document.getElementById('medicalcatdate'+iteration),event) };
     cellRight7.appendChild(e7);
     
     var cellRight8 = row.insertCell(8);
	 var e8 = document.createElement('input');
	 e8.type = 'text';
	 e8.name = 'nextcatdate' + iteration;
	 e8.id = 'nextcatdate' + iteration;
	 e8.value='<%=date %>';
	 e8.className = 'date';
	 e8.setAttribute('maxlength', 10); 
	 e8.setAttribute('tabindex','1');
     cellRight8.appendChild(e8);

     var cellRight9 = row.insertCell(9);
	 var e9 = document.createElement('img');
	 e9.src = '/hms/jsp/images/cal.gif';
	 e9.class = 'calender';
    // eImg.style.display ='none';
     e9.id = 'calId'+iteration;
     e9.onclick = function(event){
     setdate('',document.getElementById('nextcatdate'+iteration),event) };
     cellRight9.appendChild(e9);

     
     
     var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonAdd';
	  e10.name='remarks'+iteration;
	  e10.setAttribute('onClick', 'addRow();'); 
	  e10.setAttribute('tabindex','1');
	  cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonDel';
	  e11.name='remarks'+iteration;
	  e11.setAttribute('onClick', 'removeRow();'); 
	  e11.setAttribute('tabindex','1');
	  cellRight11.appendChild(e11);
     
	}

	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
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

	function submitdata()
	{
		
		var charge=document.getElementById("chargeCodeName1").value;
        if(charge=="")
        {
         alert("Please Select Test Name");   
        }else{
        	submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=addMedicalBoardInit');
        }
		
		//{submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=addMedicalBoardInit')}
	}
	function changeRemark()
	{    
		var disval=document.getElementById("disability").value;
		  if(disval=="Yes")
        {
	    	 document.getElementById("disattribute").style.display= 'inline'
        	        }else{
        	document.getElementById("disattribute").style.display='none'
                }
			
	}
	function changeRemark1()
	{    
		var disval=document.getElementById("aggravated").value;
		  if(disval=="Yes")
        {
	    	 document.getElementById("aggravatedid").style.display= 'inline'
        	        }else{
        	document.getElementById("aggravatedid").style.display='none'
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
	

		
	
</script>
</body>