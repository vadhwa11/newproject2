
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
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>


<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
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
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMAForm16','opd?method=showPatientPreviousVisitForViewScreen" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMAForm16','medicalExam?method=getPrevMedExamFromHIC" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMAForm16','medicalExam?method=getPrevMedBoardFromHIC" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMAForm16','opd?method=showPatientPreviousVisitForHospitality" />
</div>

<!--main content placeholder starts here-->
<div class="titleBg">
<h2>Medical Board AFMSF 16 (MA)</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalBoardMAForm16" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){
	
	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<div class="clear"></div>
<div class="Block">
<label>Authority for Board</label>
<input tabindex="1" type="text"  id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value=""	onKeyUp="limitText(this,100);"  />
 <label>Place  </label> 
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=PLACE %>" 
	onKeyUp="limitText(this,20);"  />
 
  <label> Date </label>
<input	tabindex="1" name="<%=DATE_DISCHARGE %>" class="date" 
	validate="DOB,date,no" maxlength="10" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=DATE_DISCHARGE%>,event);" />
<div class="clear"></div>
  <label> Date of Release  </label>
  <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" class="date" value="<%=date %>"
	validate="DOB,date,no" maxlength="10"  onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onclick="setdate('',medicalBoardMAForm16.<%=DATE_OF_RELEASE%>,event);" />
<label>Name  </label> 
<%String sPersonName="";
sPersonName=visit.getHin().getSFirstName();
if(visit.getHin().getSMiddleName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSMiddleName();
}
if(visit.getHin().getSLastName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSLastName();
}
%>
 <input type="text" value="<%=sPersonName %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2"/>
 
<label>Service Number </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />
 
<% }else{%>

 <input type="hidden" value="Initial Medical Board AFMSF 15" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label> 
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />
 
  <label>Unit </label> 
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 <label>Service</label> 
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <div class="clear"></div>
 <label>Branch/Trade  </label> 
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>
 
 <% }%>
 
 
 <label>Total Service  </label> 
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }%>
 
 <label> Date of Birth </label>
 <%
 if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>--%>

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="" value=""
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<%--<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);" />--%>
	
	<% }%> 
 

 <div class="clear"></div> 
<label>Total Flying Hours</label> 
<input	type="text" maxlength="5" value="" name="totalFlyingHrs" onKeyUp="mask(this.value,this,'2',':');"
 onBlur="checkTime('medicalBoardMAForm16','totalFlyingHrs');"	tabindex="2" />

 <label >Date of Commission</label> 
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="2" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	 validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 
 <% }%>
 
 <label >Permanent Address</label> 
<textarea rows="" cols=""  class="medium" name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,50);" ></textarea>
 
 <div class="clear"></div>
 <div class="floatLeft">
 <label >Identification Marks</label> 
<label class="valueAuto">1</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6" 
	onKeyUp="limitText(this,20);" class="auto" size="50"  />
<div class="clear"></div>
<input class="transparent" size="28">
<label class="valueAuto">2</label><input tabindex="1" type="text" maxlength="50"  id="" name="<%=IDENTIFICATION_MARKS2 %>"  
	onKeyUp="limitText(this,20);" class="auto" size="50"  />
</div>

<div class="smallest floatRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<th scope="col">Disability</th>
<th>Add</th>
<th>Delete</th>
</tr>
<tr>
<td><input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="" tabindex="1" />
</td>
</tr>
</table>
</div>

</div>
<div class="clear paddingTop15"></div>
<h4>SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<TH scope="col">Sr.No.</TH>
<TH scope="col" colspan="2">From</TH>
<TH scope="col" colspan="2">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
<th>Add</th>
<th>Delete</th>
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
<td><input type="text" name="<%=SIRIAL_NO+inc1 %>" value="<%=setMedicalExam.getSerialno() %>" tabindex="1" size="2" class="auto" readonly="readonly"/></td>
<% }else{%>
<td><input type="text" name="<%=SIRIAL_NO+inc1 %>" tabindex="1" size="2" class="auto" readonly="readonly"/></td>

<% }%>
<% if(setMedicalExam.getAddressfrom()!=null){ %>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressfrom()) %>"/></td>
<% }else{ %>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1 %>" maxlength="10" />
<% }%>
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=FROM+inc1%>,event);" />
</td>
<% if(setMedicalExam.getAddressto()!=null ){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=TO+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<% }%>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=TO+inc1%>,event);" />
</td>
<% if(setMedicalExam.getPlace()!=null && ! setMedicalExam.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getPno()!=null && ! setMedicalExam.getPno().equalsIgnoreCase("null")){%>
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

</tr>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=setMedicalExam.getServiceid()%>" id="serviceId" />
<%
	}
}}else{
	//medicalBoardMAForm16.out.println("this is else jsp");
inc1=1;%>
<tr>


<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" value=<%=inc1%> maxlength="10" /></td>
<td width="10%">
<input tabindex="1" type="text" readonly="readonly"	name="<%=FROM+inc1 %>" maxlength="10" />
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=FROM+inc1%>,event);" />
</td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=TO+inc1 %>,event);" />
</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc1 %>" maxlength="10" /></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>

</tr>

<% }%>
<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" />

</table>
</div>
</div>
<div class="clear"></div>

	
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Disease,Wound or Injuries Details<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<th scope="col" rowspan="2">S.No.</th>
<th rowspan="2" scope="col">Illness/Wound/Injury</th>
<th colspan="2" rowspan="2" scope="col">First Started on</th>
<th rowspan="2" scope="col">First Started at</th>
<th rowspan="2">Where Treated</th>
<th colspan="4" >Approximate Dates and Periods Treated</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
	<tr>
<TH colspan="2">From</TH>
<th colspan="2">To</th>
</tr>
<% int inc11=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		inc11=inc11+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" value="<%=setMedicalExam.getIllness() %>"/></td>
  <% }else{%>
  
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" size="11" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <% }%>
 </td>
 <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
 
 <% if(setMedicalExam.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=setMedicalExam.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>
 <% }%>

 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>
    
<td width="20%">
 <% if(setMedicalExam.getApproximatedate()!=null){  %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11" value="<%=setMedicalExam.getApproximatedate()%>"	validate="DOB,String,no" maxlength="30"
	 /> 
  <% }else{%>
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="DOB,String,no" maxlength="30" /> 
 <% }%>
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
 
 <td width="20%">
 <input type="text"	tabindex="1" name="" id="approximatedate" size="11" value=""	validate="DOB,String,no" maxlength="30"	 /> 
 
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
 
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow1();" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
}}}else{
inc11=1;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>"/></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" size="11" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="DOB,String,no" maxlength="30" value=""	/> 
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
<td width="20%">
 <input type="text"	tabindex="1" name="" id="approximatedate" size="11" value=""	validate="DOB,String,no" maxlength="30"	 /> 
 
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow1();" tabindex="1" />
</td>

</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
<label class="auto">Yes</label>
<input type="checkbox" class="radioAuto"/>
<label class="auto">No</label>
<input type="checkbox" class="radioAuto"/>
</div>
<div class="clear"></div>

<!--If yes then below details and dates option will appear (By Anshu)-->

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<th scope="col" rowspan="">S.No.</th>
<th rowspan="" scope="col">Illness/Wound/Injury Details</th>
<th colspan="" rowspan="" scope="col">First Started on</th>
<th rowspan="" scope="col">First Started at</th>
<th rowspan="">Where Treated</th>

<th >Add</th>
<th >Delete</th>
</tr>



<TR>
 
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="" maxlength="3" value=""/></td>

<td width="10%"><input tabindex="1" type="text"	name="" maxlength="10" size="35" value=""/></td>
  
<td width="10%">
 <input	tabindex="1" name="" size="11" value=""	validate="DOB,date,no" maxlength="10" id="particulardate"	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 </td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"
onclick="setdate('',medicalBoardMAForm16.<%=PARTICULAR_DATE+inc11%>,event);" />
</td>
 
 
<td width="10%"><input tabindex="1" type="text"	name="" maxlength="10" value=""  /></td>



    <td width="10%"><input tabindex="1" type="text"	name="" maxlength="10" value=""/></td>



    


 

 
 
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow1();" tabindex="1" />
</td>

</TR>
</table>
</div>







<div class="Block">

<label class="large2">Details of any incidents during your service which you think caused/made your disability worse</label> 
<textarea rows="" cols="" class="large"></textarea>
<script>
<%
if(medExamObj.getClamingdisability()!= null){
%>
document.getElementById('clamingdisability').value='<%=medExamObj.getClamingdisability()%>';

<%}%>
</script>
<div class="clear"></div>
<label class="large2">In case of wound/injury, state how they happened</label>
<textarea rows="" cols="" name="<%=REASON_WOUND_INJURY%>" class="large"></textarea>
<div class="clear"></div>
<label class="large2">Med Board/ Court of inquiry was held</label>
<select name="MED_BOARD_HELD" class="small"><option value="y">Yes</option>
<option value="n">No</option></select>
<input class="transparent" size="1" /><label>Injury Report</label>

<select name="INJURY_REPORT">
<option value="sub">Submitted</option>
<option value="noSub">Not Submitted</option></select>
<div class="clear"></div>
<label class="large2">Any other health information</label> 

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" cols="71" class="large"   	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,50);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" cols="71" class="large"  	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,50);" ></textarea>
 <% }%>
 
 <div class="clear"></div>
 
</div>

<div class="clear paddingTop15"></div> 
<h4>Witness Details</h4>
<div class="Block">
<label>Signature of Witness</label>
 <input type="text" value="" name="<%=SIGN%>" id="<%=SIGN%>"/>
 
 <label>Service No.</label>
 <input type="text" value="" name="<%=SIGN%>" id="<%=SIGN%>"/>
 
  <label>Rank</label>
 <input type="text" value="" name="<%=SIGN%>" id="<%=SIGN%>"/>
 
 <label>Date</label>
 <input type="text" name="<%=SIGN_DATE%>" tabindex="2" maxlength="20" class="" size="20" /> 
 
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
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="medium3">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="medium3">Total No. of Dental Points</label> 
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
<label class="medium3">Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="medium3">Condition of Gums</label>

<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label > Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="60"	name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,150);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60"	name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,150);"></textarea>
 <% }%>
<label class=""> Refer to MH</label>
<%	if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){ %>
  
	<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" checked="checked" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%}else
		{%>
		<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%} %>
	<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadViewWindow();" />
	<div class="clear"></div>
	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>


</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<%	int count=1;
String Labresult="NotPresent";
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
	//System.out.println("dgOrderdt.getId()---"+dgOrderdt.getId());%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
	
<%count++;}
    }
%>
<% //if(visit.getHin() !=null){%>
<input type=hidden value="" name="hinNoForreport" id="hinNoForreport"/>
<% //}%>


<div class="clear paddingTop15"></div>

<h4> PHYSICAL CAPACITY<a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text"  size="18" id="height" class="auto"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" size="18"  id="height"	class="auto"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();"  /><label class="unit">cm</label>
 <% }%>

<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"  id="weight" class="auto" size="18" name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  id="weight" class="auto" size="18"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">kg</label>
 <% }%>

<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" size="18" id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="auto"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" size="18" id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="auto"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" size="18" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" size="18" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>
 <label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" size="18"  name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);" size="18"  class="auto"  /><label class="unit">Kg/m<sup>2</sup></label>

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="18" /><input class="transparent" size="6">

 <% }%>
<div class="clear"></div>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>
 
<label	>Hip</label> 
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>
 
<label	>WHR</label> 
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18" /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="6">

 <% }%>
 <div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="5">

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="18" />
	<input class="transparent" size="5">
 <% }%>

<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="18" /><label class="unit">cm</label>

 <% }%>
<label>Range of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>
<div class="clear"></div>
<label>Sportsman</label>
 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" class="smaller" validate="Sports Man,stirng,no">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>
 
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
		<th scope="col"></th>
	</tr>
	<tr>
		<td>Without Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 <td>Without Glasses</td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	<td>With Glasses</td>
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

<label>FWR</label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	<label>FWL</label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text" maxlength="20"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" maxlength="20"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	
	<label>FW Both</label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="1" type="text" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	
	<%} %>
	
<div class="clear"></div>

<label>CVR</label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>	
	 <input tabindex="1" type="text" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<%} %>
	 <label>CVL</label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	  <%}else{ %>
	    <input tabindex="1" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  <label>CV Both</label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="1" type="text" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%} %>
<div class="clear"></div>
<label >TM L</label> 
<select name="<%=TYMPANIC_L %>" class="smaller" size="0" tabindex="1" id="tympanic_l">
<option value="Intact">Intact</option>
	
	<option value="NO">Not Intact</option>
	
</select><input class="transparent" size="6" />
<script>
<%
if(medExamObj.getTympanicL()!= null){
%>
document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

<%}%>
</script>
<input class="transparent" size="2" > 
<label >TM R</label> 
<select name="<%=TYMPANIC_R %>" class="smaller" size="0" tabindex="1" id="tympanic_r">
<option value="Intact">Intact</option>
	<option value="NO">Not Intact</option>
	
</select><input class="transparent" size="6" />
<script>
<%
if(medExamObj.getTympanicR()!= null){
%>
document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

<%}%>
</script>
<div class="clear"></div>
 <label>Mobility L</label> 
	  	 <% if(medExamObj.getMobilityL() != null){ %>
	  <input tabindex="1" type="text" class="auto" size="27" name="<%=MOBILITYL %>" maxlength="100"  value="<%= medExamObj.getMobilityL()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" class="auto" size="27" name="<%=MOBILITYL %>"  maxlength="100"  />
<%} %> 


<label>Mobility R</label> 
	  	 <% if(medExamObj.getMobilityR() != null){ %>
	  <input tabindex="1" type="text" class="auto" size="27" name="<%=MOBILITYR %>" maxlength="100"  value="<%= medExamObj.getMobilityR()  %>"  />
	  
<input class="transparent" size="6" />
<%}else{ %>
 <input tabindex="1" type="text" class="auto" size="27" name="<%=MOBILITYR %>"  maxlength="100"  />


<%} %> 
<div class="clear"></div>
<label>Nose, Throat &amp; Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" maxlength="100"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="100"  />
<%} %>
<label>Audiometry Record </label>
<% if(medExamObj.getAudiometryRecord() != null){ %>
<input tabindex="1" type="text" maxlength="10"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  value="Not Done" maxlength="10"  />
<%} %>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />

</div>
</div>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div id="slide8">
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
<input type="hidden" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print"	class="button" accesskey="a" />
<input name="Prevoius" type="button" tabindex="2" value="Prev Investigation"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')"  />

</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
	<td><input type="text" name="clinicalNotes1" tabindex="1" value="Medical Board Exam" size="100" maxlength="45" /></td>
	
	</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Test Result</th>
		<th scope="col">File Upload</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
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
		    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();

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
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{%>
	<td> <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
 </td>
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
	
<%}}else{
	
	String investigationVal=key;
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
	    			name="investigationReferToMH<%=inc %>" value="y" checked="checked" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% 	    	}else
            { %>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
            <%
	
             }
	    	}else
	    	{%>
	    		<input tabindex="1" type="checkbox"
	    			name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
        </td>
	    <%	}
	    }
	}}else{
	%>	
<input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"  name="Result<%=inc %>" />
</td><% }%>
</td><%  }%>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>

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

		</td><td>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" />
</td>
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>
<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input name="<%=PULSE_RATES%>" class="auto" size="18" value="<%=medExamObj.getPulseRates() %>" tabindex="1" type="text" maxlength="18"/>
  <label class="unit">/min</label>
 <% }else{%>
 <input name="<%=PULSE_RATES%>" class="auto" size="18" tabindex="1" type="text" maxlength="18" /><label class="unit">/min</label>
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="18"  name="<%=BP1%>" class="auto" size="18"   value="<%=medExamObj.getBp() %>"/><label class="unit">mm/Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="18"  name="<%=BP1%>" class="auto" size="18"  /><label class="unit">mm/Hg</label>
 <% }%>
<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="18" 	name="<%= ARTERIAL_WALLS%>"    value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="18" name="<%= ARTERIAL_WALLS%>"   />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="18" 	name="<%= HEART_SIZE%>" class="auto" size="27"  value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" maxlength="18" 	name="<%= HEART_SIZE%>" class="auto" size="27" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="18"  name="<%= SOUND%>" class="auto"	size="28"  value="<%=medExamObj.getSounds() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="18"  name="<%= SOUND%>" class="auto"	size="28"  /> 
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="18"  name="<%= RHYTHM%>" class="auto"	size="27"  value="<%=medExamObj.getRhythm() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="18"  name="<%= RHYTHM%>" class="auto"	size="27"  /> 
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" />
 <% }%>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>

<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Liver </label> 
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" maxlength="120" 	name="liver" class="auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="liver" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>
<div class="clear"></div>
<label > Spleen </label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" maxlength="120" 	name="spleen" class="auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="120" 	name="spleen" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label> 
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="" size="20" maxlength="20" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="" size="20" maxlength="20" value="Normal"/>
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="" size="20" maxlength="20" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="" size="20" maxlength="20" value="Normal"/>
 <% }%>

<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="" size="20" maxlength="20" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="" size="20" maxlength="20" value="Normal"/>
 <% }%>

<div class="clear"></div>
<label > Tremors</label> 
<% if(medExamObj.getTremors()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="" size="20" maxlength="20" value="<%=medExamObj.getTremors() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="" size="20" maxlength="20" />
 <% }%>

<label > Self Balancing Test</label> 

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest">
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
<input tabindex="1" type="text"	name="locomoterSystem" class="" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="locomoterSystem" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" name="spine" class="" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="spine" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>

<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="10" value="NIL"/>
 <% }%>

<div class="clear"></div>
<label>Hydrocele</label> 
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="" size="20" maxlength="10" value="NIL"/>
 <% }%>

<label>Haemorrhoids</label> 
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="" size="20" maxlength="10" value="NIL"/>
 <% }%>

<label>Breast</label> 
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>
<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female")){ %>
<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide13')"></a></h4>
<div class="clear"></div>
<div id="slide13">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" />
 <% }%>
 
<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input type="text"	name="<%=LMP %>"  size="20" maxlength="3" onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp()) %>"   class="calDate" readonly="readonly" tabindex="1"/>
   <% }else{%>
<input type="text" class="calDate" readonly="readonly"	name="<%=LMP %>" onKeyUp="mask(this.value,this,'2,5','/');"  size="20" maxlength="3" tabindex="1"/>
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',medicalBoardMAForm16.<%=LMP%>,event);" />

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input type="text" name="<%=NO_OF_PREGNANCY %>"  maxlength="6" value="<%=medExamObj.getNoOfPregnancies() %>" tabindex="1"/>
   <% }else{%>
<input type="text" name="<%=NO_OF_PREGNANCY %>"  maxlength="6" tabindex="1"/>
 <% }%>
 
<div class="clear"></div>	
<label >No. of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfAbortions() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" />
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input type="text" name="<%=NO_OF_CHILDREN %>" value="<%=medExamObj.getNoOfChildren() %>"class="" size="20" maxlength="6" tabindex="1"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="6" />
 <% }%>


<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" value=""/> 
 <% }%>

<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',medicalBoardMAForm16.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text"  	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" />
 <% }%>
 
<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" name="<%=PROLAPSE %>" class="" size="20" maxlength="6" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=PROLAPSE %>" class="" size="20" maxlength="6" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text"  name="<%=USG_ABORTION %>"  maxlength="6" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" value="Not Done" maxlength="6" />
 <% }%>
 <input class="transparent" size="148">
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindowGynaecology();" />

<div class="clear"></div>
</div>
</div>
<%} %>

<div class="clear"></div>

<%if(medExamObj.getId()!=null){%>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Update"	onClick="submitForm('medicalBoardMAForm16','medicalExam?method=updateMedicalExamEntry&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="buttonBig" name="Button" tabindex="1" />
<% }%>
<input class="buttonBig" id=reset onclick=resetCheck(); type=reset value=Reset name=Reset  accessKey=r />
<input name="Button" type="button" class="buttonBig" value="Forward To MO" onClick="submitForm('medicalBoardMAForm16','medicalExam?method=updateMedicalExamEntry&data=farwarded&Labresult=<%=Labresult.trim() %>');" tabindex="1"/>
<input name="Send" type="button"  class="buttonBig" value="Upload" onClick="javascript:FileUploadViewWindow();" />
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
<input type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>" />
<input type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>" />
<input type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>" />

</div>
<%----
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="" />
<%}%>
<%if(visit.getDepartment() != null){
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>

<%if(visit.getHin() != null){%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<%}%> --%>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>

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
		  	
				submitProtoAjaxWithDivName('medicalBoardMAForm16','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
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
	  e0.size = '100'
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
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
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
	    submitProtoAjaxWithDivName('medicalBoardMAForm16','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalBoardMAForm16','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('medicalBoardMAForm16','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
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
	  e0.setAttribute('maxlength', 20); 
	  e0.setAttribute('readonly','readonly');
      e0.size = '2';
      e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly');
	  e1.name = 'from' + iteration;
	  e1.id = 'from' + iteration;
	  e1.setAttribute('tabindex','1');
      cellRight1.appendChild(e1);

      var cellRight11 = row.insertCell(2);
      var e11 = document.createElement('img');
      e11.src = '/hms/jsp/images/cal.gif';
     // e3.style.display ='none';
      e11.id = 'calId'+iteration;
      e11.onclick = function(event){
      setdate('',document.getElementById('from'+iteration),event) };
      cellRight11.appendChild(e11);  
      
      var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.className = 'date';
	  e2.name = 'to' + iteration;
	  e2.id = 'to' + iteration;
      e2.setAttribute('tabindex','1');
      e2.setAttribute('readonly','readonly');
      cellRight2.appendChild(e2);
      var cellRight21 = row.insertCell(4);
      var e21 = document.createElement('img');
      e21.src = '/hms/jsp/images/cal.gif';
     // e3.style.display ='none';
      e21.id = 'calId'+iteration;
      e21.onclick = function(event){
      setdate('',document.getElementById('to'+iteration),event) };
      cellRight21.appendChild(e21); 
       
      var cellRight3 = row.insertCell(5);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'place' + iteration;
	  e3.id = 'place' + iteration;
      e3.size = '20';
      e3.setAttribute('maxlength', 20); 
	  e3.setAttribute('tabindex','1');
      cellRight3.appendChild(e3);
      
      var cellRight4 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'pNo' + iteration;
	  e4.id = 'pNo' + iteration;
	  e4.setAttribute('maxlength', 20); 
      e4.size = '20';
	  e4.setAttribute('tabindex','1');
      cellRight4.appendChild(e4);

      var cellRight5 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick', 'addRow();'); 
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(8);
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
		  e0.value=iteration;
		  e0.setAttribute('maxlength', 20); 
		  e0.setAttribute('readonly','readonly');
	      e0.size = '2';
		  e0.setAttribute('tabindex','1');
		  cellRight0.appendChild(e0);

		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name = 'illness' + iteration;
		  e1.id = 'illness' + iteration;
		  e1.setAttribute('maxlength', 20); 
	      e1.size = '20';
		  e1.setAttribute('tabindex','1');
	      cellRight1.appendChild(e1);
        
        

        var cellRight2 = row.insertCell(2);
        var e2 = document.createElement('input');
        e2.type = 'text';
        e2.className = 'date';
       // e2.readOnly = true;
        e2.setAttribute('readonly','readonly');
        e2.name='particulardate'+ iteration;
        e2.id='particulardate'+iteration;
        cellRight2.appendChild(e2);

        var cellRight3 = row.insertCell(3);
        var e3 = document.createElement('img');
        e3.src = '/hms/jsp/images/cal.gif';
       // e3.style.display ='none';
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
		  e4.setAttribute('maxlength', 20); 
		  e4.setAttribute('tabindex','1');
	      cellRight4.appendChild(e4);

	    /*  var cellRight5 = row.insertCell(5);
	      var e5 = document.createElement('select');
	      e5.options[0] = new Option('Select', '');
	      e5.name = 'rankindividualid'+ iteration;
	      e5.id = 'rankindividualid' + iteration;
	      e5.tabIndex="1";
	      for(var i = 0;i<bankArray.length;i++ ){
	    	  e5.options[bankArray[i][0]] = new Option(bankArray[i][1],bankArray[i][0]);
	    	  }
	    	cellRight5.appendChild(e5);
		*/
	      var cellRight6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'treated' + iteration;
		  e6.id = 'treated' + iteration;
		  e6.size = '20';
		  e6.setAttribute('maxlength', 20); 
		  e6.setAttribute('tabindex','1');
	      cellRight6.appendChild(e6);

	     
        var cellRight7 = row.insertCell(6);
        var e7 = document.createElement('input');
        e7.type = 'text';
        e7.name='approximatedate'+ iteration;
        e7.id='approximatedate'+iteration;
        e7.size='40';
        e7.setAttribute('maxlength', 30); 
		e7.setAttribute('tabindex','1');
	    cellRight7.appendChild(e7);

         
	      var cellRight9 = row.insertCell(7);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonAdd';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'addRow1();'); 
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);

		  var cellRight10 = row.insertCell(8);
		  var e10 = document.createElement('input');
		  e10.type = 'button';
		  e10.className = 'buttonDel';
		  e10.name='remarks'+iteration;
		  e10.setAttribute('onClick', 'removeRow1();'); 
		  e10.setAttribute('tabindex','1');
		  cellRight10.appendChild(e10);
	      
		}
	function FileUploadWindow()
	{
		   var folderName='hearing';
			var url="/hms/hms/medicalExam?method=displayFileUpload";
			
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	      
	}
	function fileUploadWindowInvestigation(rowVal)
	{
		var medicalExamId='';
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
			var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation";
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 	} 
			      
	}
	function FileUploadWindowGynaecology()
	{
		var folderName='gynaecology';
			var url="/hms/hms/medicalExam?method=displayFileUpload";
			
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
        	submitForm('medicalBoardMAForm16','medicalExam?method=addMedicalExaminationBoardAnnual');
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
 function FileUploadViewWindow()
 {
 		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp";
 		
 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
       
 }
</script></form>
</body>
