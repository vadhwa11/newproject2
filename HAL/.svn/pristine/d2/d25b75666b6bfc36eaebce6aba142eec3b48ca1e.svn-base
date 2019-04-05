
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
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.Disability"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
var bankArray=new Array();
var disabilityListArray=new Array();
var disabilityrankListArray=new Array();
var disabilityunitListArray=new Array();

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

if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");

}

List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList1")!=null)
{
	masRankList1 = (List) map.get("masRankList1");

}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");

}
List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");
	System.out.println("visitlist jsp---"+visitlist.size());

	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
 System.out.println("getAge jsp---"+visit.getAge());
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
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
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
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
      System.out.println("jsp search"+search);
   }
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
System.out.println("jsp resultList----"+resultList.size());
	}
String accessjsp=null;
if (map.get("accessjsp") != null) {
	accessjsp = (String) map.get("accessjsp");
      System.out.println("jsp accessjsp"+accessjsp);
   }
String method=null;
if (map.get("method") != null) {
	method = (String) map.get("method");
      System.out.println("jsp method"+method);
   }
String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
}
List<Disability> disabilityList= new ArrayList<Disability>();
if(map.get("disabilityList") != null){
	disabilityList=(List)map.get("disabilityList");
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
      System.out.println("messssssss"+message);
   }
if(!message.equalsIgnoreCase("")){
	 System.out.println("messssssss bbbbbllllll"+message);
%>
<h4><%=message %></h4>
<%} %>

<div>
<input	name="investigationTemplate" type="button"	value="Previous Visit" tabindex="1" class="buttonBig" onClick="submitForm('medicalBoardExaminationReleaseDischarge','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exam" tabindex="1" class="buttonBig" onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Board" tabindex="1" class="buttonBig" onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalization" tabindex="1" class="buttonBig" onClick="submitForm('medicalBoardExaminationReleaseDischarge','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');"" />
</div>
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>Medical Board Rel/Invalidment AFMSF 16</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalBoardExaminationReleaseDischarge" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){
	
	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>

<div class="Block">

<label>Authority Of Board</label> 
 <% if(medExamObj.getAuthority()!=null){%>
 <input	type="text"  name="<%=AUTHORITY_OF_BOARD%>"	tabindex="2" maxlength="20" value="<%=medExamObj.getAuthority() %>"/>
  <% }else{%>
<input	type="text"  name="<%=AUTHORITY_OF_BOARD%>"	tabindex="2" maxlength="20" />
 <% }%>

 <label>Place  </label> 
  <% if(medExamObj.getPlace()!=null){%>
 <input	type="text"  name="<%=PLACE%>"	tabindex="2"  value="<%=medExamObj.getPlace() %>" maxlength="20" />
  <% }else{%>
<input	type="text"  name="<%=PLACE%>"	tabindex="2" maxlength="20" />
 <% }%>
 
  <label><span>*</span> Date  </label>
  <input	tabindex="1" name="<%=DATE_DISCHARGE %>" class="date"  value="<%=date %>" readonly="readonly"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DATE_DISCHARGE%>,event);" />
<div class="clear"></div>
  <label><span>*</span> Date of Release  </label>
   <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" class="date"  value="<%=date %>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DATE_OF_RELEASE%>,event);" />
<label>Name  </label> 
  <input	type="text" value="<%= visit.getHin().getSFirstName() %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" maxlength="20" />
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" maxlength="20" />
<% }else{%>
 <input type="hidden"	value="Medical Board Rel/Invalidment AFMSF 16" name="medicalExamType" tabindex="2" maxlength="20" />
<% }%>

 <label>Service Number </label>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>" maxlength="20" />
 <div class="clear"></div>
 <label>Rank  </label> 
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	maxlength="20" tabindex="2" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	maxlength="20" tabindex="2" />
 
  <label><span>*</span> Date of Birth  </label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date"  value="<%=date %>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	
	<% }%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DOB%>,event);" />

 
 
 
 <label>Unit/Ship  </label> 
  <input	type="text" value="<%= visit.getHin().getUnit().getUnitName() %>" readonly="readonly" name="<%=UNIT%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" maxlength="20" />
 <div class="clear"></div>
 <label>Service IAF  </label> 
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <label>Branch/Trade  </label> 
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" readonly="readonly" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />


 <label >Total Service  </label> 
 <input	type="text" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>" readonly="readonly"	tabindex="2" maxlength="20" />
 <div class="clear"></div> 

<div class="clear"></div> 

<label> Marital Status</label> 
<select name="<%=MARITAL_STATUS_ID%>" id="srmrstatus"  validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
		 	if ((medExamObj.getMaritalStatus()!=null)&&(masMaritalStatus.getId()==(medExamObj.getMaritalStatus().getId()))) {%>
		 <option value="<%=masMaritalStatus.getId ()%>" selected="selected"><%=masMaritalStatus.getMaritalStatusName()%>
		 </option>
		 <%}else{%><option value="<%=masMaritalStatus.getId ()%>"><%=masMaritalStatus.getMaritalStatusName()%>
		 	</option>
		 	<%	}}%>
    </select> 
<label >Permanent Address</label> 
 <%
 if(medExamObj.getParmanentAddress()!=null){
 %>
 <textarea rows="" cols=""  class="medium" 	name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getParmanentAddress() %></textarea>
 <% }else{%>
<textarea rows="" cols=""  class="medium" 	name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,100);" ></textarea>

 <% }%>
 

 <label >Past Medical History</label> 
 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 <input	type="text"  name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2"  value="<%=medExamObj.getPastmedicalhistory() %>" maxlength="20" />
  <% }else{%>
<input	type="text"  name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" maxlength="20" />
 <% }%>
 
 <div class="clear"></div>
 <label >Identification Marks</label> 
 <% if(medExamObj.getIdentificationMarks1()!=null){%>
<label class="valueAuto">1.)</label>
<input tabindex="1" type="text" maxlength="20"  size="72" id="" name="<%=IDENTIFICATION_MARKS1 %>" value="<%=medExamObj.getIdentificationMarks1() %>"
	onKeyUp="limitText(this,20);"  />

 <% }else{%>
<label class="valueAuto">1.)</label><input tabindex="1" type="text" class="auto" size="72" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS1 %>" 
	onKeyUp="limitText(this,20);"  />

 <% }%>
 
<div class="clear"></div>
 <label>&nbsp;</label>
<% if(medExamObj.getIdentificationMarks2()!=null){%>
 
<label class="valueAuto">2.)</label><input tabindex="1" type="text" class="auto" size="72" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS2 %>" value="<%=medExamObj.getIdentificationMarks2() %>"
	onKeyUp="limitText(this,20);"  />

 <% }else{%>
 
<label class="valueAuto">2.)</label><input tabindex="1" type="text" class="auto" size="72" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS2 %>"  
	onKeyUp="limitText(this,20);"  />

 <% }%>
 </div>

<div class="clear"></div>
<div class="clear"></div>

<h4> PERSONAL STATMENT SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">SI NO</TH>
<TH scope="col">FROM</TH>
<TH scope="col">TO</TH>
<TH scope="col">PLACE</TH>
<TH>P/F</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc1=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if(setMedicalExam.getParticular().equalsIgnoreCase("detail")){
    inc1=inc1+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=SIRIAL_NO+inc1 %>" maxlength="3" value="<%=setMedicalExam.getSerialno() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=SIRIAL_NO+inc1 %>" value="<%=inc1 %>" maxlength="3" /></td>
 <% }%>
<% if(setMedicalExam.getAddressfrom()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1 %>" maxlength="10" value="<%=setMedicalExam.getAddressfrom() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1 %>" maxlength="10" /></td>
 <% }%>
<% if(setMedicalExam.getAddressto()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=TO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getAddressto() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=TO+inc1 %>" maxlength="10" /></td>
 <% }%>
<% if(setMedicalExam.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" /></td>
 <% }%>
<% if(setMedicalExam.getPno()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPno() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10" /></td>
 <% }%>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=setMedicalExam.getServiceid()%>" id="hdb" />

<%
}}}else{
inc1=inc1+1;%>

<TR>


<td width="10%"><input tabindex="1" size="2" type="text"	name="<%=SIRIAL_NO+inc1 %>" value="<%=inc1 %>" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=TO+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10" /></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb" value="<%=inc1%>" id="hdb" />
</table>
</div>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4> PERSONAL STATMENT SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<TH scope="col">SI NO</TH>
<TH scope="col">Illness/wound</TH>
<TH scope="col" colspan="2">Date</TH>
<TH scope="col">PLACE/Ship</TH>
<TH>Rank Of Individual</TH>
<TH>Where Treated</TH>
<TH colspan="2">Aapproximate Date and Periods Treated</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc11=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if(setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		inc11=inc11+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialNo1()!=null){%>
<td width="z%"><input tabindex="1" size="5" type="text"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="5" type="text"	name="<%=SIRIAL_NO1+inc11 %>"  value="<%=inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" value="<%=setMedicalExam.getIllness() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=date %>"	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <% }%>
 </td><td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
 
 <% if(setMedicalExam.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=setMedicalExam.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>
 <% }%>

<td width="10%">
<select name="<%=RANK_INDIVIDUAL_ID+inc11%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
      System.out.println("masR ansh 1---"+masRankList1.size());
	 for(MasRank masrank : masRankList1){
		 	if ((setMedicalExam.getRankIndividual()!=null)&&(masrank.getId()==(setMedicalExam.getRankIndividual().getId()))) {%>
		 <option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getRankName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	bankArray[<%=j%>]= new Array();
            bankArray[<%=j%>][0] = "<%=masrank.getId()%>";
            bankArray[<%=j%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	}
		 	j=j+1;
		 	}%>
    </select> 
    </td>
 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>
    
<td width="10%">
 <% if(setMedicalExam.getApproximatedate()!=null){%>
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getApproximatedate())%>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" class="date" value="<%=date %>"	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <% }%>
 </td><td>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" 
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=APPROXIMATE_DATE+inc11%>,event);" />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow1();" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=setMedicalExam.getServiceid()%>" id="hdb" />

<%
}}}else{
inc11=inc11+1;%>
<TR>


<td width="10%"><input tabindex="1" type="text" size="2"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date"  value="<%=date %>"	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	</td>
	<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>
<td width="10%">
<select name="<%=RANK_INDIVIDUAL_ID+inc11%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
      System.out.println("masR2 ansh---"+masRankList1.size());
	 for(MasRank masrank : masRankList1){
		 	
		 %><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	bankArray[<%=j%>]= new Array();
            bankArray[<%=j%>][0] = "<%=masrank.getId()%>";
            bankArray[<%=j%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	
		 	j=j+1;
		 	}%>
    </select> 
    </td>
<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" class="date"  value="<%=date %>"	validate="DOB,date,no" maxlength="10" id="particulardate"	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=APPROXIMATE_DATE+inc11%>,event);" />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow1();" tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Disability Pension</label> 
<select name="<%=DISABILITY %>" size="0" tabindex="1" id="disabilitypension">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisability()!= null){
%>
document.getElementById('disabilitypension').value='<%=medExamObj.getDisability()%>';

<%}%>
</script>


 <label >Case Details</label> 
<%
if(medExamObj.getCaseDetail()!= null){
%>

 <input	type="text"  name="<%=CASE_DETAIL%>" value="<%=medExamObj.getCaseDetail()%>"	tabindex="2" maxlength="100" />
<% }else{%>
<input	type="text"  name="<%=CASE_DETAIL%>" tabindex="2" maxlength="100" />
<% }%>



<!--Block Four Ends-->
<label> Disability Attributable <br /> <span class="sublabel">(to service)</span></label>
<select name=<%=DISABILITY%> size="0" tabindex="1" id="disability">
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
<div class="clear"></div>
<label >If yes Remark</label> 

<% if(medExamObj.getDisabilityAttribute() != null){ %>
<input tabindex="1" type="text" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  value="<%=medExamObj.getDisabilityAttribute()%>" size="100" maxlength="100" />
<%}else{ %>
<input tabindex="1" type="text" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  size="100" maxlength="100" />
	
	<%} %>

<label>Case Summary</label> 

	<% if(medExamObj.getCaseSheet() != null){ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"><%=medExamObj.getCaseSheet()%></textarea>
<%}else{ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"></textarea>
	
	<%} %>



<label> Aggravated <br /> <span class="sublabel">by Service</span></label> 
<select name=<%=AGGRAVATED_SERVICE_LABEL%> size="0" tabindex="1" id="aggravated">
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

<div class="clear"></div>
<label >If yes Remark</label> 
<% if(medExamObj.getAggravatedServiceDesc() != null){ %>
<input tabindex="1" type="text" name=<%=AGGRAVATED_SERVICE_DESC%> value="<%=medExamObj.getAggravatedServiceDesc()%>" class="Auto" size="100" maxlength="100" />
<%}else{ %>
<input tabindex="1" type="text" name=<%=AGGRAVATED_SERVICE_DESC%> class="Auto" size="100" maxlength="100" />
	
<%} %>

</div>

</div>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Points</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="auto">Unsaveable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="small" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="MUR_8" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="MUR_7" value="" class="radioAuto" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="MUR_6" value="" class="radioAuto" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="MUR_5" value="" class="radioAuto" id="d4" onclick="chkValue(this);" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="MUR_4" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="MUR_3" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="MUR_2" value="" class="radioAuto" id="d7" onclick="chkValue(this);" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="MUR_1" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="MUL_8" value="" class="radioAuto" id="d9" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="MUL_7" value="" class="radioAuto" id="d10" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="MUL_6" value="" class="radioAuto" id="d11" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="MUL_5" value="" class="radioAuto" id="d12" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="MUL_4" value="" class="radioAuto" id="d13" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="MUL_3" value="" class="radioAuto" id="d14" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="MUL_2" value="" class="radioAuto" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="MUL_1" value="" class="radioAuto" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="MLR_8" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="MLR_7" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="MLR_6" value="" class="radioAuto" id="d19" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="MLR_5" value="" class="radioAuto" id="d20" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="MLR_4" value="" class="radioAuto" id="d21" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="MLR_3" value="" class="radioAuto" id="d22" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="MLR_2" value="" class="radioAuto" id="d23" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="MLR_1" value="" class="radioAuto" id="d24" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="MLL_8" value="" class="radioAuto" id="d25" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="MLL_7" value="" class="radioAuto" id="d26" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="MLL_6" value="" class="radioAuto" id="d27" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="MLL_5" value="" class="radioAuto" id="d28" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="MLL_4" value="" class="radioAuto" id="d29" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="MLL_3" value="" class="radioAuto" id="d30" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="MLL_2" value="" class="radioAuto" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="MLL_1" value="" class="radioAuto" id="d32" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="UUR_8" value="" class="radioAuto" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="UUR_7" value="" class="radioAuto" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="UUR_6" value="" class="radioAuto" id="d35" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="UUR_5" value="" class="radioAuto" id="d36" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="UUR_4" value="" class="radioAuto" id="d37" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="UUR_3" value="" class="radioAuto" id="d38" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="UUR_2" value="" class="radioAuto" id="d39" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="UUR_1" value="" class="radioAuto" id="d40" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="UUL_8" value="" class="radioAuto" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="UUL_7" value="" class="radioAuto" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="UUL_6" value="" class="radioAuto" id="d43" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="UUL_5" value="" class="radioAuto" id="d44" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="UUL_4" value="" class="radioAuto" id="d45" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="UUL_3" value="" class="radioAuto" id="d46" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="UUL_2" value="" class="radioAuto" id="d47" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="UUL_1" value="" class="radioAuto" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="ULR_8" value="" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="ULR_7" value="" class="radioAuto" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="ULR_6" value="" class="radioAuto" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="ULR_5" value="" class="radioAuto" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="ULR_4" value="" class="radioAuto" id="d53" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="ULR_3" value="" class="radioAuto" id="d54" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="ULR_2" value="" class="radioAuto" id="d55" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="ULR_1" value="" class="radioAuto" id="d56" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="ULL_8" value="" class="radioAuto" id="d57" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="ULL_7" value="" class="radioAuto" id="d58" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="ULL_6" value="" class="radioAuto" id="d59" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="ULL_5" value="" class="radioAuto" id="d60" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="ULL_4" value="" class="radioAuto" id="d61" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="ULL_3" value="" class="radioAuto" id="d62" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="ULL_2" value="" class="radioAuto" id="d63" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="ULL_1" value="" class="radioAuto" id="d64" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label class="medium"> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,150);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,150);"></textarea>
 <% }%>

	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>
<%	int count=1;
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
	System.out.println("dgOrderdt.getId()---"+dgOrderdt.getId());%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
	
<%count++;}
    }%>
<div class="clear paddingTop15"></div>
<% if(medExamObj.getVisit() !=null){%>
<INPUT type=hidden value="<%=medExamObj.getVisit().getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
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
	<td><input type="text" name="clinicalNotes1" tabindex="1" size="100" maxlength="45" /></td>
	
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


if(medExamObj.getDateOfReporting()==null)
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
	   int inc12=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());    
		    	third.put(investigationName,patientInvestigation.getId());
		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		    	
		    	if(resultList.size()>0 && inc12<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc12-1);
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
		    	++inc12;
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

<div class="clear"></div>
<div class="clear paddingTop15"></div>

<h4> PHYSICAL DEVELOPMENT <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"   id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"   id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"   id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>

<label	>Sports Man</label> 
  <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text"   id="<%=SPORTS %>" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text"  id="<%=SPORTS %>" name="<%=SPORTS %>"  maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>

<label	>WHR</label> 
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="" name="WHR" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>
 <div class="clear"></div>
 <label	>Hip</label> 
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="" name="Hips" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>

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
  <input tabindex="1" type="text" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getPulseRates() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20" />
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getBp() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20" />
 <% }%>
<label>Arterial Walls</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getSounds() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" /> 
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getRhythm() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" /> 
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
<label class="auto"> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" />
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
<input tabindex="1" type="text" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="20" />
 <% }%>

<label class="auto"> Spleen Palpalable</label> 
<select name="spleen" size="0" tabindex="1" id="spleenpalpalable">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getSpleen()!= null){
%>
document.getElementById('spleenpalpalable').value='<%=medExamObj.getSpleen()%>';

<%}%>
</script>

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
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label > Tremors</label> 
<% if(medExamObj.getTremors()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getTremors() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="Auto" size="20" maxlength="20" />
 <% }%>



<label > Self Balancing Test</label> 

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest">
<option value="0">select</option>
	<option value="Fairly Steady">Fairly Steady</option>
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
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
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
<input tabindex="1" type="text"   id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label>
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text"  id="hrfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label>
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="1" type="text"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text"   id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>	
	 <input tabindex="1" type="text"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	  <%}else{ %>
	    <input tabindex="1" type="text"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label>
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="1" type="text"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%} %>
</div>
</div>
<!-- fayaz added -->

<div class="clear paddingTop15"></div>

<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" />
 <% }%>
 

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  	name="<%=LMP %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getLmp() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=LMP %>" class="Auto" size="20" maxlength="3" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
 
<div class="clear"></div>	
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>


<label >Date <br /><span class="sublabel">(last confinement)</span></label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="10" />
 <% }%>
 

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="10" />
 <% }%>

	
</div>
</div>

<h4>STATEMENT OF CASE<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid2">
	<tr>

<TH scope="col">Disability</TH>
<TH scope="col" colspan="2">Date of Origin</TH>
<TH>Rank Of Indl</TH>
<TH>Place</TH>
<TH >Unit</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc111=0;
String valuefound="false";
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if( setMedicalExam.getParticular() !=null && setMedicalExam.getParticular().equalsIgnoreCase("disability")){
		inc111=inc111+1;
		valuefound="true";
	%>

<TR>
<td width="10%">
<select name="<%=DISABILITY_ID+inc111 %>" id="<%=DISABILITY_ID+inc111 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
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
 <% if(setMedicalExam.getDisabilitydate()!=null){%>
<input	tabindex="1" name="<%=DISABILITY_DATE+inc111 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getDisabilitydate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=DISABILITY_DATE+inc111 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <% }%>
 </td><td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DISABILITY_DATE+inc111%>,event);" />

</td>
 
<td width="10%">
<select name="<%=DISABILITY_RANK_ID+inc111%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j1=0;
      System.out.println("masR ansh 1---"+masRankList1.size());
	 for(MasRank masrank : masRankList1){
		 	if ((setMedicalExam.getRankDisability()!=null)&&(masrank.getId()==(setMedicalExam.getRankDisability().getId()))) {%>
		 <option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getRankName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	disabilityrankListArray[<%=j1%>]= new Array();
		 	disabilityrankListArray[<%=j1%>][0] = "<%=masrank.getId()%>";
		 	disabilityrankListArray[<%=j1%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	}
		 	j1=j1+1;
		 	}%>
    </select> 
    </td>
 <% if(setMedicalExam.getPlaceDisability()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=DISABILITY_PLACE+inc111 %>" maxlength="10" value="<%=setMedicalExam.getPlaceDisability() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=DISABILITY_PLACE+inc111 %>" maxlength="10" /></td>
 <% }%>
   <td width="10%">
<select name="<%=DISABILITY_UNIT+inc111%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j2=0;
      System.out.println("masR ansh 1---"+masRankList1.size());
	 for(MasUnit masrank : masUnitList){
		 	if ((setMedicalExam.getUnitDisability()!=null)&&(masrank.getId()==(setMedicalExam.getUnitDisability().getId()))) {%>
		 <option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getUnitName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId ()%>"><%=masrank.getUnitName()%>
		 	</option>
		 	<script>
		 	disabilityunitListArray[<%=j2%>]= new Array();
		 	disabilityunitListArray[<%=j2%>][0] = "<%=masrank.getId()%>";
		 	disabilityunitListArray[<%=j2%>][1] = "<%=masrank.getUnitName()%>";
            </script>		 	
		 	<%	}
		 	j2=j2+1;
		 	}%>
    </select> 
    </td> 

<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow2();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow2();" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc111 %>" value="<%=setMedicalExam.getServiceid()%>" id="hdb" />

<%
}}}
if(valuefound.equalsIgnoreCase("false")){
inc111=inc111+1;%>
<TR>
<td width="10%">
<select name="<%=DISABILITY_ID+inc111 %>" id="<%=DISABILITYID+inc111 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j4=0;
    
	 for(Disability masrank : disabilityList){
		 
		 %><option value="<%=masrank.getDisabilityid()%>"><%=masrank.getDisability()%>
		 	</option>
		 	<script>
		 	disabilityListArray[<%=j4%>]= new Array();
		 	disabilityListArray[<%=j4%>][0] = "<%=masrank.getDisabilityid()%>";
		 	disabilityListArray[<%=j4%>][1] = "<%=masrank.getDisability()%>";
            </script>		 	
		 	<%	
		 	j4=j4+1;
		 	}%>
    </select> 
    </td>
<td width="10%">
 
<input	tabindex="1" name="<%=DISABILITY_DATE+inc111 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 
 </td>
 <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.<%=DISABILITY_DATE+inc111%>,event);" />

</td>
 
<td width="10%">
<select name="<%=DISABILITY_RANK_ID+inc111%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j5=0;
      
	 for(MasRank masrank : masRankList1){
		 %><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	disabilityrankListArray[<%=j5%>]= new Array();
		 	disabilityrankListArray[<%=j5%>][0] = "<%=masrank.getId()%>";
		 	disabilityrankListArray[<%=j5%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	
		 	j5=j5+1;
		 	}%>
    </select> 
    </td>
 
    <td width="10%"><input tabindex="1" type="text"	name="<%=DISABILITY_PLACE+inc111 %>" maxlength="10" /></td>

   <td width="10%">
<select name="<%=DISABILITY_UNIT+inc111%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j6=0;
     
	 for(MasUnit masrank : masUnitList){
		%><option value="<%=masrank.getId ()%>"><%=masrank.getUnitName()%>
		 	</option>
		 	<script>
		 	disabilityunitListArray[<%=j6%>]= new Array();
		 	disabilityunitListArray[<%=j6%>][0] = "<%=masrank.getId()%>";
		 	disabilityunitListArray[<%=j6%>][1] = "<%=masrank.getUnitName()%>";
            </script>		 	
		 	<%	
		 	j6=j6+1;
		 	}%>
    </select> 
    </td> 

<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow2();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow2();" tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb2" value="<%=inc111%>" id="hdb2" />
</table>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CLINICAL DETAILS<a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label class="max">(a) Personal ans relevent family history</label>

<% if(medExamObj.getPersonalans()!=null){%>
<input tabindex="1" type="text" 	name="Personalans" class="auto" size="60" maxlength="300" value="<%=medExamObj.getPersonalans() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="Personalans" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
 <label class="max">(b) Specialist Report</label>

<% if(medExamObj.getSpecialistReport()!=null){%>
<input tabindex="1" type="text" 	name="SpecialistReport" class="auto" size="60" maxlength="300" value="<%=medExamObj.getSpecialistReport() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="SpecialistReport" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
 <label class="max">(c) Treatment</label>

<% if(medExamObj.getTreatment()!=null){%>
<input tabindex="1" type="text" 	name="Treatment" class="auto" size="60" maxlength="300" value="<%=medExamObj.getTreatment() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="Treatment" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
 <label class="max">(d) Present Condition in details</label>

<% if(medExamObj.getPresentConditionin()!=null){%>
<input tabindex="1" type="text" 	name="PresentConditionin" class="auto" size="60" maxlength="300" value="<%=medExamObj.getPresentConditionin() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="PresentConditionin" class="auto" size="60" maxlength="300" />
 <% }%>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% if(search !=null && search.equalsIgnoreCase("false")){%>

<input tabindex="1" name="Button"	type="button" class="button" value="Update"	onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalBoard?method=updateMedicalExamEntry&Labresult=<%=Labresult.trim() %>');" />
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=RESET name=Reset> 
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalExam?method=rejectMedExam');" />
<input name="Send" type="button"  class="button" value="File upload" onClick="javascript:FileUploadWindow();" />
<input name="Send" type="button"  class="button" value="Case Sheet" onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalBoard?method=getCaseSheetDetails&requestedjsp=specialist&medExamId=<%=medExamId %>&method12=<%=method%>&visitId=<%=visit.getId()%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>');" />
<input name="Send" type="buttonBig"  class="button" value="Opinion" onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalBoard?method=getCommandingOfficerDetails&requestedjsp=Opinion&medExamId=<%=medExamId %>&method12=<%=method%>&visitId=<%=visit.getId()%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>');" />
<input name="Send" type="buttonBig2"  class="button" value="Commanding Officer" onClick="submitForm('medicalBoardExaminationReleaseDischarge','medicalBoard?method=getCommandingOfficerDetails&requestedjsp=CommandingOfficer&medExamId=<%=medExamId %>&method12=<%=method%>&visitId=<%=visit.getId()%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>');" />

  
  <% }%>
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
	System.out.println("visit.getDepartment().getId()----"+visit.getDepartment().getId());%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	System.out.println("visit.getHin().getId()----"+visit.getHin().getId());%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	System.out.println("visit.getHin().getId()----"+visit.getHin().getId());%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<%}%>
<input type="hidden" value="MedicalBoard" name="medicalType" id="hiddenValue" />
<input type="text"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="text"  name="UnserTeeth" id="UnserTeeth" value=""/>

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
			
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
		  	
				submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischarge','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
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
	    submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischarge','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischarge','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationReleaseDischarge','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
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
      e0.size = '20';
	  e0.setAttribute('tabindex','1');
	  e0.value=hdb.value;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'from' + iteration;
	  e1.id = 'from' + iteration;
	  e1.setAttribute('maxlength', 10); 
      e1.size = '20';
	  e1.setAttribute('tabindex','1');
      cellRight1.appendChild(e1);

      
      var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'to' + iteration;
	  e2.id = 'to' + iteration;
      e2.size = '20';
      e2.setAttribute('maxlength', 10); 
	  e2.setAttribute('tabindex','1');
      cellRight2.appendChild(e2);

      var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'place' + iteration;
	  e3.id = 'place' + iteration;
      e3.size = '20';
      e3.setAttribute('maxlength', 10); 
	  e3.setAttribute('tabindex','1');
      cellRight3.appendChild(e3);
      
      var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'pNo' + iteration;
	  e4.id = 'pNo' + iteration;
	  e4.setAttribute('maxlength', 10); 
      e4.size = '20';
	  e4.setAttribute('tabindex','1');
      cellRight4.appendChild(e4);

      var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick', 'addRow();'); 
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='remarks'+iteration;
	  e6.setAttribute('onClick', 'removeRow();'); 
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);
      
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
	function addRow1(){
		  
		  var tbl = document.getElementById('grid1');
		 
		  var lastRow = tbl.rows.length;
		//alert("tbl length---"+lastRow);
		  // if there's no header row in the table, then iteration = lastRow + 1
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb1');
		  hdb.value=iteration

		  var cellRight0 = row.insertCell(0);

		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.name = 'serialNo1' + iteration;
		  e0.id = 'serialNo1' + iteration;
		  e0.setAttribute('maxlength', 3); 
	      e0.size = '3';
	      e0.value=hdb.value;
		  e0.setAttribute('tabindex','1');
		  cellRight0.appendChild(e0);

		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name = 'illness' + iteration;
		  e1.id = 'illness' + iteration;
		  e1.setAttribute('maxlength', 10); 
	      e1.size = '20';
		  e1.setAttribute('tabindex','1');
	      cellRight1.appendChild(e1);
      
      

      var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('input');
      e2.type = 'text';
      e2.readOnly = true;
      e2.name='particulardate'+ iteration;
      e2.id='particulardate'+iteration;

     //var eImg = document.createElement('img');
     // eImg.src = '/hms/jsp/images/cal.gif';
    //  eImg.class = 'calender';
     // eImg.style.display ='none';
     // eImg.id = 'calId'+iteration;
     // eImg.onclick = function(event){
      //setdate('',document.getElementById('particulardate'+iteration),event) };
      cellRight2.appendChild(e2);
     // cellRight2.appendChild(eImg);

      var cellRight3 = row.insertCell(3);
      var e3 = document.createElement('img');
      e3.src = '/hms/jsp/images/cal.gif';
     // eImg.style.display ='none';
      e3.id = 'calId'+iteration;
      e3.onclick = function(event){
      setdate('',document.getElementById('particulardate'+iteration),event) };
      cellRight3.appendChild(e3);

	      
	      var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name = 'place1' + iteration;
		  e4.id = 'place1' + iteration;
	      e4.size = '20';
	      e4.setAttribute('maxlength', 10); 
		  e4.setAttribute('tabindex','1');
	      cellRight4.appendChild(e4);

	      var cellRight5 = row.insertCell(5);
	      var e5 = document.createElement('select');
	      e5.options[0] = new Option('Select', '');
	      e5.name = 'rankindividualid'+ iteration;
	      e5.id = 'rankindividualid' + iteration;
	      e5.tabIndex="1";
	      for(var i = 0;i<bankArray.length;i++ ){
	    	  e5.options[bankArray[i][0]] = new Option(bankArray[i][1],bankArray[i][0]);
	    	  }
	    	cellRight5.appendChild(e5);
		 /*		 	var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name = 'rankindividualid' + iteration;
		  e4.id = 'rankindividualid' + iteration;
		  e4.setAttribute('maxlength', 20); 
	      e4.size = '20';
		  e4.setAttribute('tabindex','1');
	      cellRight4.appendChild(e4);
*/
	      var cellRight6 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'treated' + iteration;
		  e6.id = 'treated' + iteration;
	      e6.size = '20';
	      e6.setAttribute('maxlength', 10); 
		  e6.setAttribute('tabindex','1');
	      cellRight6.appendChild(e6);


	     
      var cellRight7 = row.insertCell(7);
      var e7 = document.createElement('input');
      e7.type = 'text';
      e7.readOnly = true;
      e7.name='approximatedate'+ iteration;
      e7.id='approximatedate'+iteration;

      //var eImg1 = document.createElement('img');
      //eImg1.src = '/hms/jsp/images/cal.gif';
      //eImg1.class = 'calender';
     // eImg.style.display ='none';
      //eImg1.id = 'calId'+iteration;
     // eImg1.onclick = function(event){
     // setdate('',document.getElementById('approximatedate'+iteration),event) };
      cellRight7.appendChild(e7);
     // cellRight6.appendChild(eImg1);
	      
      var cellRight8 = row.insertCell(8);
      var e8 = document.createElement('img');
      e8.src = '/hms/jsp/images/cal.gif';
     // eImg.style.display ='none';
      e8.id = 'calId'+iteration;
      e8.onclick = function(event){
      setdate('',document.getElementById('approximatedate'+iteration),event) };
      cellRight8.appendChild(e8);



	      var cellRight9 = row.insertCell(9);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonAdd';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'addRow1();'); 
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);

		  var cellRight10 = row.insertCell(10);
		  var e10 = document.createElement('input');
		  e10.type = 'button';
		  e10.className = 'buttonDel';
		  e10.name='remarks'+iteration;
		  e10.setAttribute('onClick', 'removeRow1();'); 
		  e10.setAttribute('tabindex','1');
		  cellRight10.appendChild(e10);
	      
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
		function addRow2(){
			  
			  var tbl = document.getElementById('grid2');
			 
			  var lastRow = tbl.rows.length;
			//alert("tbl length---"+lastRow);
			  // if there's no header row in the table, then iteration = lastRow + 1
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			  var hdb = document.getElementById('hdb2');
			  hdb.value=iteration
			  
			  var cellRight0 = row.insertCell(0);

			
		      var e0 = document.createElement('select');
		      e0.options[0] = new Option('Select', '');
		      e0.name = 'disabilityId'+ iteration;
		      e0.id = 'disabilityId' + iteration;
		      e0.tabIndex="1";
		      for(var i = 0;i<disabilityListArray.length;i++ ){
		    	  e0.options[disabilityListArray[i][0]] = new Option(disabilityListArray[i][1],disabilityListArray[i][0]);
		    	  }
		    	cellRight0.appendChild(e0);

			  
	      var cellRight1 = row.insertCell(1);
	      var e1 = document.createElement('input');
	      e1.type = 'text';
	      e1.readOnly = true;
	      e1.name='disabilitydate'+ iteration;
	      e1.id='disabilitydate'+iteration;
          cellRight1.appendChild(e1);
	    

	      var cellRight2 = row.insertCell(2);
	      var e2 = document.createElement('img');
	      e2.src = '/hms/jsp/images/cal.gif';
	     // eImg.style.display ='none';
	      e2.id = 'calId'+iteration;
	      e2.onclick = function(event){
	      setdate('',document.getElementById('disabilitydate'+iteration),event) };
	      cellRight2.appendChild(e2);

		      
		     

		      var cellRight3 = row.insertCell(3);
		      var e3 = document.createElement('select');
		      e3.options[0] = new Option('Select', '');
		      e3.name = 'disabilityrank'+ iteration;
		      e3.id = 'disabilityrank' + iteration;
		      e3.tabIndex="1";
		      for(var i = 0;i<disabilityrankListArray.length;i++ ){
		    	  e3.options[disabilityrankListArray[i][0]] = new Option(disabilityrankListArray[i][1],disabilityrankListArray[i][0]);
		    	  }
		    	cellRight3.appendChild(e3);
			
		      var cellRight4 = row.insertCell(4);
			  var e4 = document.createElement('input');
			  e4.type = 'text';
			  e4.name = 'disabilityplace' + iteration;
			  e4.id = 'disabilityplace' + iteration;
		      e4.size = '20';
		      e4.setAttribute('maxlength', 10); 
			  e4.setAttribute('tabindex','1');
		      cellRight4.appendChild(e4);


		     
		      var cellRight5 = row.insertCell(5);
		      var e5 = document.createElement('select');
		      e5.options[0] = new Option('Select', '');
		      e5.name = 'disabilityrank'+ iteration;
		      e5.id = 'disabilityrank' + iteration;
		      e5.tabIndex="1";
		      for(var i = 0;i<disabilityunitListArray.length;i++ ){
		    	  e5.options[disabilityunitListArray[i][0]] = new Option(disabilityunitListArray[i][1],disabilityunitListArray[i][0]);
		    	  }
		    	cellRight5.appendChild(e5);

		      var cellRight6 = row.insertCell(6);
			  var e6 = document.createElement('input');
			  e6.type = 'button';
			  e6.className = 'buttonAdd';
			  e6.name='remarks'+iteration;
			  e6.setAttribute('onClick', 'addRow2();'); 
			  e6.setAttribute('tabindex','1');
			  cellRight6.appendChild(e6);

			  var cellRight7 = row.insertCell(7);
			  var e7 = document.createElement('input');
			  e7.type = 'button';
			  e7.className = 'buttonDel';
			  e7.name='remarks'+iteration;
			  e7.setAttribute('onClick', 'removeRow2();'); 
			  e7.setAttribute('tabindex','1');
			  cellRight7.appendChild(e7);
		      
			}

			function removeRow2()
			{
			  var tbl = document.getElementById('grid2');
			  var lastRow = tbl.rows.length;
			  if (lastRow > 2){
			  	tbl.deleteRow(lastRow - 1);
			  	var tbl = document.getElementById('grid2');
			  	var lastRow = tbl.rows.length;
				  // if there's no header row in the table, then iteration = lastRow + 1
			 	var iteration = lastRow - 1;
			  	var hdb = document.getElementById('hdb2');
			  	hdb.value=iteration
			  }
			}
		function submitdata()
		{  
			
			var charge=document.getElementById("chargeCodeName1").value;
		    var srmrstatus=document.getElementById("srmrstatus").value;
		    if(srmrstatus==0)
		    {
			    alert("Please Select Marital Status");
			    return false;
		    }
		    
	        if(charge=="")
	        {
	         alert("Please Enter Test Name");
	         return false;   
	        }else{
	        	submitForm('medicalBoardExaminationReleaseDischarge','medicalBoard?method=addMedicalBoardInit');
	        }
			
			//{submitForm('medicalBoardExaminationAnnual','medicalBoard?method=addMedicalBoardInit')}
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
		function FileUploadWindow()
		{
			<%if(medExamObj.getVisit()!=null){%>
			var url="/hms/hms/medicalBoard?method=displayFileUpload&visitId=<%=medExamObj.getVisit().getId()%>&hinNo=<%=medExamObj.getVisit().getHin().getHinNo()%>&hinId=<%=medExamObj.getVisit().getHin().getId()%>";
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	        <%}%>
		}
</script></form>
</body>