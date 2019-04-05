
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
<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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
var categoryMedArray=new Array();
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

List<Category> categoryList = new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList = (List<Category>)map.get("categoryList");
}

List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
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
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList") != null){
	employeeMoList=(List)map.get("employeeMoList");
	}

List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
}
Integer empId=0;
	String signedBy="";
	String signedByRank="";
	String signedByUnit="";
	String commandUnit="";
	String commandRank="";
	if(employeeMoList.size()>0){
		for(MasEmployee masEmployee:employeeMoList){
			if(masEmployee.getUnit()!=null){
				signedByUnit=masEmployee.getUnit().getUnitName();
			}
			if(masEmployee.getRank()!=null){
				signedByRank=masEmployee.getRank().getRankName();
			}
			signedBy=masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null){
				signedBy=signedBy+" "+masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null){
				signedBy=signedBy+" "+masEmployee.getLastName();
			}
		}
	}
	
if(session.getAttribute("userName")!=null)
	 userName=(String)session.getAttribute("userName");
/*
	if(session.getAttribute("users")!=null){
	Users user = (Users) session.getAttribute("users");
	if(user.getEmployee()!=null){
    empId =user.getEmployee().getId();
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
	String service_no="";
	if(visit.getHin()!=null){
		service_no=visit.getHin().getServiceNo();
	}
	String rank="";
	if(visit.getHin().getRank()!=null){
		rank=visit.getHin().getRank().getRankName();
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
<%---
<div>
<input	name="investigationTemplate" type="hidden"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('commandOfficerForm16','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');" />
<input	name="investigationTemplate" type="hidden"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('commandOfficerForm16','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="hidden"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('commandOfficerForm16','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="hidden"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('commandOfficerForm16','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
</div> --%>
<%-- 
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" 
	onclick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" 
	class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>--%>
<!--main content placeholder starts here-->
<div class="titleBg">
	<h2>AFMSF 16</h2>
</div>
<div class="clear"></div>
<form name="commandOfficerForm16" action="" method="post">
<!--Block One Starts-->
<div class="Block">
	<label>Authority for Board</label>
 <%
 String authority="";
 if(medExamObj.getAuthority()!=null){
 authority=medExamObj.getAuthority();
 }%>
<input type="text" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="<%=authority %>" 
		onKeyUp="limitText(this,100);" tabindex="1"  readonly="readonly"/>

 <%if(session.getAttribute("hospitalName")!=null){ %>
<label>Place </label>
<input tabindex="1" type="text"  id="" name="<%=PLACE %>"  value="<%=((String)session.getAttribute("hospitalName")) %>"
	onKeyUp="limitText(this,20);" readonly="readonly" class="auto" size="50" maxlength="20" />
<%}%>
<div class="clear"></div>
<label>Date Of Discharge</label>
<%if(medExamObj.getDateOfDischarge() !=null){ %>
<input tabindex="1" type="text"	name="dateOfDischarge" class="calDate" maxlength="10"  class="auto"
 value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfDischarge()) %>" readonly="readonly" />
<%}else{ %>
 <input tabindex="1" type="text"	name="dateOfDischarge" class="calDate" maxlength="10"  class="auto"
 value="<%=date %>" validate="Discharge Date,date,no" readonly="readonly"/>
<%} %>

<div class="clear"></div></div>
<div class="clear paddingTop15"></div>
<div class="Block">
	<label>Date</label>
<%if(medExamObj.getId()==null)
{%>
	 <input tabindex="1" type="text"  readonly="readonly"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<% }else if(medExamObj.getDateOfReporting() !=null){%>
	 <input tabindex="1" type="text"	readonly="readonly"  name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" />

<% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<%} %>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('',medicalBoardMOForm16.<%=REPORTED_DATE%>,event);" />
  </div>

<div class="clear paddingTop15"></div>
<%
int medExamId = 0;
if(medExamObj.getId()!= null){

	medExamId = medExamObj.getId();
}
%>
<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<div class="Block">
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" maxlength="100" readonly="readonly"/>
<% }else{%>
 <input type="hidden"	value="Medical Board AFMSF 16" name="medicalExamType" tabindex="2" maxlength="100"/>
<% }%>
 <input type="text"	 readonly="readonly"  name="<%=SERVICE_NO %>" tabindex="2" value="<%=visit.getHin().getServiceNo()%>" />
 <label>Rank  </label>
   <input type="text" readonly="readonly"  value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="100" />

 <%
	 String name =visit.getHin().getSFirstName();
	 if(visit.getHin().getSMiddleName() != null){
		 name += " "+visit.getHin().getSMiddleName();
	 }
	 if(visit.getHin().getSLastName() != null){
		 name += " "+visit.getHin().getSLastName();
	 }
 %>
 <label>Name  </label>
  <input	readonly="readonly" type="text" value="<%= name %>" name="<%=FULL_NAME%>"	tabindex="2" maxlength="100" />

 <div class="clear"></div>

 <label>Unit/Ship  </label>
  <input	readonly="readonly" type="text" value="<%= visit.getHin().getUnit().getUnitName() %>" name="<%=UNIT%>"	tabindex="2" maxlength="100"/>
  <input type="hidden" value="<%= visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" maxlength="100"/>

 <label>Service  </label>
 <input	type="text" readonly="readonly" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="100" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text" readonly="readonly" name="<%=TRADE%>"	tabindex="2" maxlength="10" value="<%= visit.getHin().getTrade().getTradeName() %>"/>
  <input	type="hidden"  name="<%=TRADE_ID%>"	maxlength="10" tabindex="2" value="<%= visit.getHin().getTrade().getId() %>"/>

<% }else{%>
<input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>
 <% }%>
 <div class="clear"></div>

 <label>DOB</label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	 maxlength="10" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value="" readonly="readonly" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMAForm16.<%=DOB%>,event);" />
	<% }%>

<label>Age/Gender  </label>
<input type="text" readonly="readonly"  value="<%= visit.getAge()+"/"+visit.getHin().getSex().getAdministrativeSexName() %>" name="apparentAge"	maxlength="50" tabindex="2" readonly="readonly"/>

<%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%} %>

 <label>Type of Commission </label>
 <% if(medExamObj.getTypeofcommision()!= null){%>
 <input	type="text" value="<%=medExamObj.getTypeofcommision()%>" name="typeOfCommunication"	maxlength="50"  id="typeOfCommunication" readonly="readonly" />
<%}else{%>
 <select name="typeOfCommunication"	 tabindex=1 disabled="disabled">
	<option value="PC" selected="selected" >PC </option>
	<option value="SSC">SSC</option>
</select>

 <% }%>
 <div class="clear"></div>
 <label>Total Service  </label>
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" readonly="readonly"/>
 <% }%>
<%---
<label>Total Flying Hours</label>
<input	type="text" maxlength="5" value="" name="totalFlyingHrs" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('commandOfficerForm16','totalFlyingHrs');"	tabindex="2" />
 --%>
<label>Permanent Address</label>
 <%
String addressOnLeave="";

if(visit.getHin().getPermanentAddress()!=null)
 {
	addressOnLeave=visit.getHin().getPermanentAddress();
 }
%>
<textarea cols="20" rows="2"  readonly="readonly"  class="medium" name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,50);" ><%=addressOnLeave%></textarea>

<label>DOC/DOE  </label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	 validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date" value="<%=date %>"	readonly="readonly"/>
 <% }%>

<div class="clear"></div>

<div class="floatLeft">
 <label >Identification Marks</label>
 <%
 String identification1="";
 String identification2="";
 if(medExamObj.getIdentificationMarks1()!=null){
	 identification1=medExamObj.getIdentificationMarks1();
 }
 if(medExamObj.getIdentificationMarks2()!=null){
	 identification2=medExamObj.getIdentificationMarks2();
 }
 %>
<label class="valueAuto">1</label><input tabindex="1"  readonly="readonly" type="text" validate="Identification Marks1,string,no" maxlength="50"  id="<%=IDENTIFICATION_MARKS1 %>" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6"
	 value="<%=identification1%>"	onKeyUp="limitText(this,50);" class="auto" size="50"  />
<div class="clear"></div>
<input class="transparent" size="28">
<label class="valueAuto">2</label>
<input tabindex="1" readonly="readonly" type="text" validate="Identification Marks2,string,no" maxlength="50"  id="<%=IDENTIFICATION_MARKS2 %>" name="<%=IDENTIFICATION_MARKS2 %>"
 value="<%=identification2%>"	onKeyUp="limitText(this,50);" class="auto" size="50"  />
</div>
<div class="smallest floatRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDisability">
	<tr>
<th scope="col">Disability</th>
</tr>

<% int incDisability=0;

if(medExamObj.getMasmedicaldetail()!=null)
{

	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail"))
	{

			incDisability=incDisability+1;
			int icdId=0;
			String icdCd="";
			if(setMedicalExam.getMasIcd()!=null){
				icdId=setMedicalExam.getMasIcd().getId();
				icdCd=setMedicalExam.getMasIcd().getIcdCode();
			}
			String disabilityStr="";
			disabilityStr=setMedicalExam.getPrincipal()+"["+icdCd+"]";
	%>
	<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value="<%=disabilityStr %>"	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis1','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis1'});
		</script>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability%>" id="hdbDisability" />
</tr>
	<%
	}
}
%>
<%
}

if(incDisability <=0){
	//medicalBoardMAForm16.out.println("this is else jsp");
incDisability=1;%>
<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value=""	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis<%=incDisability%>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis1'});
		</script>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability %>" id="hdbDisability" />
</tr>
<%} %>
</table>
</div></div>

<div class="clear paddingTop15"></div>
<h4>SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<TH scope="col">Sl. No.</TH>
<TH scope="col" >From</TH>
<TH scope="col">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
</tr>
<% int inc12=0;

if(medExamObj.getMasmedicaldetail()!=null)
{

	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail1"))
	{

			inc12=inc12+1;
	%>

<tr>
<% if(setMedicalExam.getSerialno()!=null){%>
<td><input type="text" name="<%=SIRIAL_NO+inc12 %>" value="<%=setMedicalExam.getSerialno() %>" tabindex="1" size="2" class="auto" readonly="readonly"/></td>
<% }else{%>
<td><input type="text" name="<%=SIRIAL_NO+inc12 %>" tabindex="1" size="2" class="auto" readonly="readonly"/></td>

<% }%>
<% if(setMedicalExam.getAddressfrom()!=null){ %>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=FROM+inc12 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressfrom()) %>"/></td>
<% }else{ %>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=FROM+inc12 %>" maxlength="10" />
<% }%>
</td>
<% if(setMedicalExam.getAddressto()!=null ){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=TO+inc12 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=TO+inc12 %>" maxlength="10" />
</td>
<% }%>
<% if(setMedicalExam.getPlace()!=null && ! setMedicalExam.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc12 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc12 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getPno()!=null && ! setMedicalExam.getPno().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=P_NO+inc12 %>" maxlength="10" value="<%=setMedicalExam.getPno() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=P_NO+inc12 %>" maxlength="10" /></td>
<% }%>

</tr>
<input type=hidden name="<%=SERVICEID+inc12 %>" value="<%=setMedicalExam.getServiceid()%>" id="serviceId" />
<%
	}
}}

if(inc12<=0){
	//medicalBoardMAForm16.out.println("this is else jsp");
inc12=1;%>
<tr>


<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc12 %>" value=<%=inc12%> maxlength="10" /></td>
<td width="10%">
<input tabindex="1" type="text" readonly="readonly"	name="<%=FROM+inc12 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=TO+inc12 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc12 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=P_NO+inc12 %>" maxlength="10" /></td>

</tr>

<% }%>
<input type="hidden" name="hdb" value="<%=inc12%>" id="hdb" />

</table>
</div>
</div>

<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Disease,Wound or Injuries Details<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<th scope="col" rowspan="2">Sl No.</th>
<th rowspan="2" scope="col">Illness/Wound/Injury</th>
<th colspan="1" rowspan="2" scope="col">First Started on</th>
<th rowspan="2" scope="col">First Started at</th>
<th rowspan="2">Where Treated</th>
<th colspan="2" >Approximate Dates and Periods Treated</th>
</tr>
	<tr>
<TH>From</TH>
<th>To</th>
</tr>
<% int inc11=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	
	//if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("particular")){
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("particular") && masMedicalExamDetails.getBeforeDisability().equalsIgnoreCase("n")){
		inc11=inc11+1;
	
	%>

<TR>

 <% if(masMedicalExamDetails.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(masMedicalExamDetails.getIllness()!=null){
		int icdId=0;
		String icdCd="";
		if(masMedicalExamDetails.getMasIcd()!=null){
			icdId=masMedicalExamDetails.getMasIcd().getId();
			icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
		}String illnessStr="";
		illnessStr=masMedicalExamDetails.getIllness()+"["+icdCd+"]";
 %>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" size="35" value="<%=illnessStr %>"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" size="35"/></td>
 <% }%>
<td width="10%">
 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 </td>

 <% if(masMedicalExamDetails.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" readonly="readonly"  /></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" value="<%=masMedicalExamDetails.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>

<td width="20%">
 <% if(masMedicalExamDetails.getApproximatedate1()!=null){  %>
<input type="text"	readonly="readonly" tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getApproximatedate1())%>"	validate="DOB,String,no" maxlength="30"
	 />
  <% }else{%>
<input  type="text"	readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates From,String,no" maxlength="30" />
 <% }%>
  </td>
<td width="20%">
 <% if(masMedicalExamDetails.getApproximatedate2()!=null){  %>
<input type="text"	readonly="readonly" tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getApproximatedate2())%>"	validate="DOB,String,no" maxlength="30"
	 />
  <% }else{%>
<input  type="text"	readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates To,String,no" maxlength="30" />
 <% }%>
  </td>
</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />

<%
}}}if(inc11<=0){
++inc11;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>"/></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" readonly="readonly"  size="35"/></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="Particular Date,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" readonly="readonly" /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" readonly="readonly"  /></td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates From,String,no" maxlength="30" value=""/>

</td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates To,String,no" maxlength="30" value=""/>

</td>
</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<%
String displayStyle="";
String displayValue="";
if(medExamObj.getDisabilitybefore()!=null){
	
	displayValue=medExamObj.getDisabilitybefore();
	if(displayValue.equalsIgnoreCase("y")){
		displayStyle="inline";
	}else{
		displayStyle="none";
	}
}else{
	displayStyle="inline";
}
%>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
<select name="<%=DISABILITY_BEFORE%>" tabindex="1" id="<%=DISABILITY_BEFORE%>" onchange="showHideDisabilityBefore();" class="small">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<script type="text/javascript">
document.getElementById('disabilitybefore').value ='<%=displayValue%>';
</script>

</div>
<div class="clear"></div>

<!--If yes then below details and dates option will appear (By Anshu)-->

<div class="cmntable" id="beforeDisabilityDiv" style="display: <%=displayStyle%>;">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIllness">
	<tr>
<th scope="col" rowspan="">S.No.</th>
<th scope="col">Illness/Wound/Injury Details</th>
<th scope="col">First Started on</th>
<th scope="col">First Started at</th>
<th scope="col">Where Treated</th>
</tr>

<% int incBefore=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	
	if(masMedicalExamDetails.getBeforeDisability()!=null && masMedicalExamDetails.getBeforeDisability().equalsIgnoreCase("y")){
		incBefore=incBefore+1;
	%>

<TR>

 <% if(masMedicalExamDetails.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialno() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" /></td>
 <% }%>
 <% if(masMedicalExamDetails.getIllness()!=null){
	 int icdId=0;
		String icdCd="";
		if(masMedicalExamDetails.getMasIcd()!=null){
			icdId=masMedicalExamDetails.getMasIcd().getId();
			icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
		}String illnessStrBefore="";
		illnessStrBefore=masMedicalExamDetails.getIllness()+"["+icdCd+"]";
 %>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" size="35" value="<%=illnessStrBefore %>" readonly="readonly"/></td>
  <% }else{%>
  
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" size="35" readonly="readonly"/></td>
 <% }%>
<td width="10%">
 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>"
	onKeyUp="mask(this.value,this,'2,5','/');"  readonly="readonly"/>
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" readonly="readonly"/> 
 <% }%>
 </td>
 
 
 <% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace()%>" readonly="readonly"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10"  readonly="readonly"/></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="10" value="<%=masMedicalExamDetails.getTreated() %>" readonly="readonly"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="10"  readonly="readonly"/></td>
 <% }%>
</TR>
<input type=hidden name="<%=SERVICEID%>1<%=incBefore %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />
<%
String beforeDisability="";
if(masMedicalExamDetails.getBeforeDisability()!=null){
	beforeDisability=masMedicalExamDetails.getBeforeDisability();
}else{
	beforeDisability="y";
}
%>
<input type=hidden name="beforeDisability<%=incBefore %>" id="beforeDisability<%=incBefore %>" value="<%=beforeDisability%>"  />

<%
}}}

if(incBefore<=0){
	incBefore=1;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=incBefore %>"/></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" readonly="readonly"	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" readonly="readonly"/></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore%>" maxlength="10" readonly="readonly"/></td>
<input type=hidden name="beforeDisability1<%=incBefore %>" id="beforeDisability1<%=incBefore %>" value="y"/>
</TR>
<% }%>
<input type="hidden" name="hdbBefore" value="<%=incBefore%>" id="hdbBefore" />
</table>
</div>
<div class="Block">

<script>
<%
	String incidentsDuringYourService="";
	if(medExamObj.getIncidentsDuringYourService()!= null){
		incidentsDuringYourService=medExamObj.getIncidentsDuringYourService();
	}
	String reasonWoundInjury="";
	if(medExamObj.getReasonWoundInjury()!= null){
		reasonWoundInjury=medExamObj.getReasonWoundInjury();
	}
	String medBoardHeld="";
	if(medExamObj.getMedBoardHeld()!= null){
		medBoardHeld=medExamObj.getMedBoardHeld();
	}
	String injuryReport="";
	if(medExamObj.getInjuryReport()!= null){
		injuryReport=medExamObj.getInjuryReport();
	}
%>
</script>
<label class="large2">Details of any incidents during your service which you think caused/made your disability worse</label>
<textarea name="incidents_during_your_service" readonly="readonly"  id="incidents_during_your_service" rows="" cols="" class="large"><%=incidentsDuringYourService%></textarea>

<div class="clear"></div>
<label class="large2">In case of wound/injury, state how they happened</label>
<textarea rows="" cols=""  readonly="readonly"  name="<%=REASON_WOUND_INJURY%>" id="<%=REASON_WOUND_INJURY%>"   class="large"><%=reasonWoundInjury%></textarea>
<div class="clear"></div>
<label class="large2">Med Board/ Court of inquiry was held</label>
<select name="MED_BOARD_HELD" id="MED_BOARD_HELD" class="small" disabled="disabled">
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.MED_BOARD_HELD.value='<%=medBoardHeld%>';
</script>
<input class="transparent" size="1" />
<label>Injury Report</label>
<select name="INJURY_REPORT" id="INJURY_REPORT" disabled="disabled">
<option value="Submitted">Submitted</option>
<option value="Not Submitted">Not Submitted</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.INJURY_REPORT.value='<%=injuryReport%>';
</script>
<div class="clear"></div>
<label class="large2">Any other health information</label>

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" cols="71" class="large"   readonly="readonly"	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" readonly="readonly" cols="71" class="large"  	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ></textarea>
 <% }%>

 <div class="clear"></div>

</div>
<div class="clear paddingTop15"></div>
<h4>Individual Details</h4>
<div class="Block">
<%
String individualSign="";
if(medExamObj.getIndividualDigitalSign() !=null){
individualSign=medExamObj.getIndividualDigitalSign();}%>
<label>Signature of Individual</label>
 <input type="text" readonly="readonly"  value="" name="<%=SIGN%>" id="<%=SIGN%>" maxlength="30" value="<%=individualSign %>"/>

 <label>Service No.</label>
 <input type="text" value="<%=service_no%>" name="<%=SIGN%>" id="<%=SIGN%>"  readonly="readonly"  />

  <label>Rank</label>
 <input type="text" value="<%=rank %>" name="<%=SIGN%>" id="<%=SIGN%>" readonly="readonly"  />

 <label>Date</label>
 <input type="text" name="<%=SIGN_DATE%>" value="<%=date%>" tabindex="2" maxlength="20" size="11" readonly="readonly" />
</div>
<input tabindex="1" name="Button" type="hidden" class="buttonBig" value="Clinical Summary"	onClick="openPopupForClinicalSummary(<%=medExamId %>);" />
<div class="clear paddingTop15"></div>
<h4>Statement of Commanding Officer</h4>
<div id="slide4">
<div class="Block">
<div class="clear"></div>

<label class="large">Date the individual joined your Unit/Ship</label>
<input type="text" name="<%=UNIT_DATE%>" tabindex="2" maxlength="20" class="auto" size="21" onKeyUp="mask(this.value,this,'2,5','/');"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=UNIT_DATE%>,event);" />


<label>Was he in Low Med Cat</label>
<select name="<%=LOW_MED_CAT %>" tabindex="1" id="lowMedCat" onchange="showHideLowMedCat();">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>
<div id="lowMedCatDiv" style="display: none" >
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid4">
	<tr>
		<th scope="col">Disability Details</th>
		<th scope="col">Med Cat (Last Cat Med Board)</th>
		<th scope="col">Since</th>
		<th scope="col" colspan="2">How Long (in LMC)</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<% int inc112=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	
	if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("DisabilityDetails")){
		inc112=inc112+1;
		 int icdId=0;
			String icdCd="";
			if(masMedicalExamDetails.getMasIcd()!=null){
				icdId=masMedicalExamDetails.getMasIcd().getId();
				icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
			}
			String disabilityIll="";
			disabilityIll=masMedicalExamDetails.getIllness()+"["+icdCd+"]"+"["+icdId+"]";
	%>

<TR>
<input 	name="disabilityCommand<%=inc112 %>" value="<%=disabilityIll %>" id="disabilityCommand<%=inc112 %>" tabindex="1" class="auto" size="50" onblur="" maxlength="99" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('disabilityCommand<%=inc112 %>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=disabilityCommand<%=inc112 %>'});
		</script>

		<%-- 	<input name="disabilityCommand" id="disabilityCommand" type="text"  value="" tabindex="1" class="auto" size="40"/>
		--%>
		</td>
		<td>
			<select tabindex="1"  name="<%=LOW_MED_CAT %><%=inc112 %>" tabindex="1" id="lowMedCat<%=inc112 %>">

			<% for(Category category:categoryList)
			   {
			%>
				<option value="<%=category.getCategoryid() %>"><%=category.getCategories() %></option>

			<%} %>
			<%-- value will come from database --%>

</select>
<%
int ii=0;
for (Category category : categoryList) {
     			 %> <script>

     			categoryMedArray[<%=ii%>]= new Array();
     			categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
            </script> <%
++ii;
}%>
</td>

<td>
<input type="text" name="<%=SINCE_DATE%><%=inc112 %>" value="<%=HMSUtil.changeDateToddMMyyyy(masMedicalExamDetails.getDisabilitydate()) %>" tabindex="2" maxlength="20" class="auto" size="21" onKeyUp="mask(this.value,this,'2,5','/');"/>
<%String sinceDate="sinceDate"+inc112;
%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=sinceDate%>,event);" />
</td>
<td>
<input type="text"  name="<%=SINCE_YEAR %><%=inc112 %>" value="<%=masMedicalExamDetails.getLMCYears() %>" tabindex="1" class="auto" size="5"  maxlength="4"/> year(s)
</td>
<td>
<input type="text" name="<%=SINCE_MONTH %><%=inc112 %>" value="<%=masMedicalExamDetails.getLMCMonth() %>" tabindex="1" class="auto" size="5"  maxlength="4"/>month(s)
<input type="hidden" name="disabilityStatus" value="y" id="disabilityStatus" />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid4','hdb3',this);" tabindex="1" />
	</td>
	</TR>
	
	<% }}}if(inc112<=0){
	++inc112;%>
	
	<tr>
		<td>
		<input 	name="disabilityCommand<%=inc112 %>" value=""	id="disabilityCommand<%=inc112 %>" tabindex="1" class="auto" size="50" onblur="" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('disabilityCommand<%=inc112 %>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=disabilityCommand<%=inc112 %>'});
		</script>

		<%-- 	<input name="disabilityCommand" id="disabilityCommand" type="text"  value="" tabindex="1" class="auto" size="40"/>
		--%>
		</td>
		<td>
			<select tabindex="1"  name="<%=LOW_MED_CAT %><%=inc112 %>" tabindex="1" id="lowMedCat<%=inc112 %>">

			<% for(Category category:categoryList)
			   {
			%>
				<option value="<%=category.getCategoryid() %>"><%=category.getCategories() %></option>

			<%} %>
			<%-- value will come from database --%>


</select>
<%
int ii=0;
for (Category category : categoryList) {
     			 %> <script>

     			categoryMedArray[<%=ii%>]= new Array();
     			categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
            </script> <%
++ii;
}%>
</td>

<td>
			<input type="text" name="<%=SINCE_DATE%><%=inc112 %>" tabindex="2" maxlength="20" class="auto" size="21" onKeyUp="mask(this.value,this,'2,5','/');"/>
			<%String sinceDate="sinceDate"+inc112;
			%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=sinceDate%>,event);" />
</td>
<td>
<input type="text"  name="<%=SINCE_YEAR %><%=inc112 %>" value="" tabindex="1" class="auto" size="5"  maxlength="4"/> year(s)
</td>
<td>
<input type="text" name="<%=SINCE_MONTH %><%=inc112 %>" value="" tabindex="1" class="auto" size="5" maxlength="4" />month(s)
<input type="hidden" name="disabilityStatus" value="y" id="disabilityStatus" />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid4','hdb3',this);" tabindex="1" />
	</td>
</tr>
<%} %>
 <input type="hidden" name="hdb3" value="<%=inc112 %>" id="hdb3" />
</table>

<div class="clear"></div>
</div>

<div class="clear"></div>
<label class="large">Any Duty Excused</label>
<select name="<%=DUTY_EXCUSED %>" id="dutyExcused" >
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>
<label class="large">Nature of Duties in the Unit</label>
<input type="text" name="<%=NATURE_DUTIES %>" id="natureDuties" value="" tabindex="1" maxlength="49" />

<div class="clear"></div>
<label class="large">Did the duties involve severe/exceptional stress &amp; strain</label>
<select name="<%=SEVERE_EXCEPTIONAL %>" id="severeExceptional" onchange="showHideSevereExceptional();" tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>


<div id="severeExceptionalDiv"  style="display: none">

<label class="">Since When</label>
<input type="text" name="<%=SINCE_WHEN%>" tabindex="2" maxlength="20" class="auto" size="11"  onKeyUp="mask(this.value,this,'2,5','/');"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
class="calender" onclick="setdate('',commandOfficerForm16.<%=SINCE_WHEN%>,event);" />

<label class="auto">On </label>
<select name="sinceOn" id="sinceOn"  tabindex="1">
	<option value="">Select</option>
	<option value="Special Days">Special Days</option>
	<option value="Occasions">Occasions</option>
</select>

</div>

<div class="clear"></div>
<label class="large">Was he living with his family </label>
<select name="<%=WITH_FAMILY %>"  tabindex="1"id="withFamily" onchange="showHideWithFamily();">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div id="withFamilyDiv"  style="display: none">

<label class=""> Since When</label>
<input type="text" name="<%=SINCE_FAMILY%>" tabindex="2" maxlength="20" class="auto" size="11" onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=SINCE_FAMILY%>,event);" />

<label class="auto"> In</label>
<select name="<%=SINCE_IN %>" tabindex="1" id="govAccomodate" >
	<option value="">Select</option>
	<option value="govt">Govt. Accomodation</option>
	<option value="nonGovt">Own Arrangement</option>
</select>
</div>

<div class="clear"></div>

<label class="large" >Living in Unit lines</label>
<select name="<%=UNIT_LINES %>" id="unitLines">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>

<label class="large">Last Leave on</label>
<input type="text" name="<%=LEAVE_DATE%>" tabindex="2" maxlength="20" class="auto" size="21"  onKeyUp="mask(this.value,this,'2,5','/');"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=LEAVE_DATE%>,event);" />


<label class="">Spent</label>
<%--
<input type="text" name="<%=SPENT%>" id="spent" value=""   /> --%>
<select name="<%=SPENT %>" id="spent"  tabindex="1">
	<option value="">Select</option>
	<option value="village">Village</option>
	<option value="town">Town</option>
	<option value="state">State</option>
</select>
<div class="clear"></div>

<label class="large">If disablity is due to infection</label>
<select name="<%=DISABILTY_INFECTION %>" id="disabiltyInfection" onchange="showHideDisabiltyInfection();"	 tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>

<div id="disabiltyInfectionDiv"  style="display: none">

<label class="large">Any other case in the unit</label>
<%---
<input type="text" name="<%=OTHER_CASE_UNIT%>" tabindex="2" maxlength="50"  /> --%>
<select name="<%=OTHER_CASE_UNIT %>"  tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>

<label class="large">Is the disease endemic in the town in surrounding areas</label>
<input type="text" name="<%=SURROUNDING_AREAS%>" tabindex="2" maxlength="49"    />

<div class="clear"></div>

<label class="large">Preventive measures taken</label>
<select name="<%=PREVENT_MEASURES %>"  tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

</div>

<div class="clear"></div>

<label class="large">Is this a case of sexually transmitted diseases</label>
<select name="<%=TRANMITTED_DISEASE %>" id="diseasesId"  tabindex="1" onchange="showHideTransmittedDiseases();">
	<option value="">Select</option>
	<option value="y">Yes</option><!-- if yes then following details will appear -->
	<option value="n">No</option>
</select>
<div class="clear"></div>
<div id="transmittedDiv"  style="display: none">
<label class="large">When was it contacted</label>
<input type="text" name="<%=CONTACTED_DATE%>" tabindex="2" maxlength="20" class="date"  onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="setdate('',commandOfficerForm16.<%=CONTACTED_DATE%>,event);" />

<label>Where was it contacted</label>
<input type="text" name="<%=CONTACTED_PLACE%>" tabindex="2" maxlength="49"   />

<div class="clear"></div>

<label class="large">Name of Hospital/STD Centre where treated</label>
<input type="text" name="<%=HOSPITAL_STD%>" tabindex="2" maxlength="49"  />

<div class="clear"></div>

<label class="large">Was surveillance and follow up treatment completed</label>
<select name="<%=TREATMENT_COMPLETED %>" onchange="showHideTreatmentCompleted();"   id="treatmentCompleted" tabindex="1">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
 <div id="ftcDateDiv"  style="display: inline;">
<label>Date of FTC</label>
<input type="text" name="<%=FTC_DATE%>" tabindex="2" maxlength="20" class="auto" size="20" id="ftcDate"  onKeyUp="mask(this.value,this,'2,5','/');"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',commandOfficerForm16.<%=FTC_DATE%>,event);" />
 </div>
<div class="clear"></div>

<div id="treatmentCompletedDiv"  style="display: none">

<label class="large">State responsible service factors</label>
<input type="text" name="<%=RESPONSIBLE_FACTORS%>" tabindex="2" maxlength="49"   />

</div>
</div>
<div class="clear"></div>

<label class="auto">Injury Report/ IHD Case /any other / 14 days charter of duties any other document.</label>

<input class="transparent" size="2">
<input type="button" name="upload" class="buttonBig" value="Upload Certificate" onClick="javascript:fileUploadViewWindow('IHD');" />

</div>
</div>

<div class="clear paddingTop15"></div>

<h4> Commanding Officer Details<a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>

<div class="clear"></div>
<div id="slide5">
<div class="Block">

<label >Rank</label>
<input tabindex="1" type="text" name="<%=COMMAND_RANK%>" value="<%=signedByRank%>" id="commandRank"  readonly="readonly"/>

<label >Name</label>
<input tabindex="1" type="text" name="<%=COMMAND_NAME%>" value="<%=signedBy %>" id="commandName"  readonly="readonly" />

<label >Unit</label>
<input tabindex="1" type="text" name="<%=COMMAND_UNIT%>" value="<%=signedByUnit%>" id="commandUnit" readonly="readonly"/>

<label >Date</label>
<input tabindex="1" type="text" name="<%=COMMAND_DATE%>" value="<%=date %>" id="commandDate" readonly="readonly"/>

<label >Signed By</label>
<input type="text" name="<%=SIGNED_BY %>" value="<%=signedBy%>" id="signedBy" readonly="readonly"/>
<div class="clear"></div>

</div>
</div>

<div class="clear"></div>

<input tabindex="1" name="Button" type="button" class="button" value="Validate"	onClick="submitForm('commandOfficerForm16','medicalBoard?method=validateMBCommandingOfficer&data=validate');" />
<input tabindex="1" class=button id=reset onclick=resetCheck(); type=reset value=Reset name=Reset  accessKey=r/>

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
<%----
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="" />
<%}%>
<%if(visit.getDepartment() != null){
	%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
--%>
<%if(visit.getHin() != null){%>
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<%}%> 
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

				submitProtoAjaxWithDivName('commandOfficerForm16','/hms/hms/opd?method=showGridForInvestigation','gridview');

				}

	}

 function addRowForDisability()
 {

	 var tbl = document.getElementById('grid4');

		  var lastRow = tbl.rows.length;
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb3');
		  hdb.value=iteration

		  document.getElementById('disabilityStatus').value="yes";
	     var cellRight0 = row.insertCell(0);
	     var e0 = document.createElement('input');
	     e0.type = 'text';
	     var newdiv1 = document.createElement('div');
	     newdiv1.setAttribute('id', 'ac2update'+iteration);
	     newdiv1.setAttribute('class', 'autocomplete');
	     newdiv1.style.display = 'none';

	  e0.name = 'disabilityCommand' + iteration;
	  e0.id = 'disabilityCommand' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '50';
	  cellRight0.appendChild(newdiv1);

	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('disabilityCommand'+iteration,'ac2update'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=disabilityCommand'+iteration});


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('Select');
	  e1.name = 'lowMedCat' + iteration;
	  e1.id = 'lowMedCat' + iteration;
	  e1.setAttribute('tabindex','1');
	  e1.options[0] = new Option('Select', '0');
	   for(var i = 0;i<categoryMedArray.length;i++ ){
	      e1.options[i+1] = new Option(categoryMedArray[i][1],categoryMedArray[i][0]);
	      }

      cellRight1.appendChild(e1);


      var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.className = 'date';
	  e2.name = 'sinceDate' + iteration;
	  e2.id = 'sinceDate' + iteration;
      e2.setAttribute('tabindex','1');
      e2.setAttribute('readonly','readonly');
      cellRight2.appendChild(e2);
      //var cellRight21 = row.insertCell(2);
      var e21 = document.createElement('img');
      e21.src = '/hms/jsp/images/cal.gif';
     // e3.style.display ='none';
      e21.id = 'calId'+iteration;
      e21.onclick = function(event){
      setdate('',document.getElementById('sinceDate'+iteration),event) };
      cellRight2.appendChild(e21);

      var cellRight3 = row.insertCell(3);
	  var e31 = document.createElement('input');
	  e31.type = 'text';
	  e31.name = 'sinceYear' + iteration;
	  e31.id = 'sinceYear' + iteration;
	  e31.size = '5';
	  e31.setAttribute('maxlength', 5);
	  e31.setAttribute('tabindex','1');
      cellRight3.appendChild(e31);

      var cellRight4 = row.insertCell(4);
	  var e41 = document.createElement('input');
	  e41.type = 'text';
	  e41.name = 'sinceMonth' + iteration;
	  e41.id = 'sinceMonth' + iteration;
	  e41.size = '5';
	  e41.setAttribute('maxlength', 4);
	  e41.setAttribute('tabindex','1');
	  cellRight4.appendChild(e41);

	 var cellRight12 = row.insertCell(5);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForDisability();');
	  cellRight12.appendChild(e3);

	  var cellRight22 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForDisability();');
	  cellRight22.appendChild(e4);



	}

 function removeRowForDisability()
	{
	  var tbl = document.getElementById('grid4');
	  var lastRow = tbl.rows.length;
	  document.getElementById('disabilityStatus').value="yes";
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid4');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb3');
	  	hdb.value=iteration

	  }
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
	    submitProtoAjaxWithDivName('commandOfficerForm16','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('commandOfficerForm16','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('commandOfficerForm16','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
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

	function submitdata()
	{

		var charge=document.getElementById("chargeCodeName1").value;
        if(charge=="")
        {
         alert("Please Select Test Name");
         return false;
        }else{
        	submitForm('commandOfficerForm16','medicalExam?method=addMedicalExaminationBoardAnnual');
        }


	}
 function showHideLowMedCat(){
		if(document.getElementById('lowMedCat').value == 'y'){
		  	document.getElementById("lowMedCatDiv").style.display='inline';
		}else{
			document.getElementById("lowMedCatDiv").style.display='none';
		}
	}
	function showHideWithFamily(){
		if(document.getElementById('withFamily').value == 'y'){
		  	document.getElementById("withFamilyDiv").style.display='inline';
		}else{
			document.getElementById("withFamilyDiv").style.display='none';
		}
	}
	function showHideSevereExceptional(){
		if(document.getElementById('severeExceptional').value == 'y'){
		  	document.getElementById("severeExceptionalDiv").style.display='inline';
		}else{
			document.getElementById("severeExceptionalDiv").style.display='none';
		}
	}
	function showHideDisabiltyInfection(){
		if(document.getElementById('disabiltyInfection').value == 'y'){
		  	document.getElementById("disabiltyInfectionDiv").style.display='inline';
		}else{
			document.getElementById("disabiltyInfectionDiv").style.display='none';
		}
	}
	function showHideTreatmentCompleted(){
		if(document.getElementById('treatmentCompleted').value == 'n'){
		  	document.getElementById("treatmentCompletedDiv").style.display='inline';
			document.getElementById("ftcDateDiv").style.display='none';
		}else{
			document.getElementById("treatmentCompletedDiv").style.display='none';
			document.getElementById("ftcDateDiv").style.display='inline';
		}
	}
	function showHideTransmittedDiseases(){
		if(document.getElementById("diseasesId").value == 'y'){
		  	document.getElementById("transmittedDiv").style.display='inline';

		}else{
			document.getElementById("transmittedDiv").style.display='none';
		}
	}
	function fileUploadViewWindow(flag)
	{
		//flag=HEA Means-->Hearing
		//flag=GYN Means-->GYNAECOLOGY EXAM
		//flag=ALL Means-->ALL Type
//		<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>
		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	function openPopupForClinicalSummary(medExamId)
	{
		var url="/hms/hms/medicalBoard?method=showViewClinicalSummaryJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
	   	newwindow=window.open(url,'clinicalSummary','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
	function showHideDisabilityBefore(){
		if(document.getElementById('disabilitybefore').value == 'y'){
		  	document.getElementById("beforeDisabilityDiv").style.display='inline';
		}else{
			document.getElementById("beforeDisabilityDiv").style.display='none';
		}
	}
	function removeRow(idName,countId,obj)
	{
		var tbl = document.getElementById(idName);
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  //	tbl.deleteRow(lastRow - 1);
		    var i=obj.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
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
	//	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
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
