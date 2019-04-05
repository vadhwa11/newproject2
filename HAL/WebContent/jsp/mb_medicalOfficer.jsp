]<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
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
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamReportDt"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
		Users users =null;
		if(session.getAttribute("users")!=null){
			users=(Users)session.getAttribute("users");
		}
		int loginEmpId=0;
		if(users!=null){
			if(users.getEmployee()!=null){
				loginEmpId=users.getEmployee().getId();
			}
		}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		//String time = (String) utilMap.get("currentTime");
		String time = (String) utilMap.get("currentTimeWithoutSc");
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>

<script type="text/javascript">
var categoryMedArray=new Array();

</script>
<script type="text/javascript">
<%

String Labresult="NotPresent";
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}



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

/*
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");
}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");
}
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");
}
List<MasRank> masRankList1 = new ArrayList<MasRank>();
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
*/
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
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
List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
}
	Visit visit=null;
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	 visit=(Visit)medExamObj.getVisit();

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
/*
List<MasIcd> masIcdList = new ArrayList<MasIcd>();
if(map.get("masIcdList") != null){
	masIcdList=(List)map.get("masIcdList");

	}
List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
if(map.get("disabilitygroupList") != null){
	disabilitygroupList=(List)map.get("disabilitygroupList");
	}
*/
List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
if(map.get("masHospitalList") != null){
	masHospitalList=(List)map.get("masHospitalList");
}
if(map.get("masDepartmentList") != null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
%>
function checkTemplateId(templateId){

    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
function checkFamilyHistory()
{
  var selObj = document.getElementById('FamilyHistory');
  var i;
  for (i=0; i<selObj.options.length; i++)
  {
    if (selObj.options[i].selected)
    {
      if(selObj.options[i].value==8)
      {
    	  document.getElementById("familyHistoryOther").style.display='inline';
       }
     }

   }
}

function checkForInvestReferToMH()
{
	var inc=document.getElementById('hiddenValue').value;
	var i;
	for(i=1;i<=inc;i++)
	{
		if(document.getElementById('investigationReferToMH'+i) && document.getElementById('investigationReferToMH'+i).checked==true)
		{
			document.getElementById('uploadReport'+i).style.display='inline';
		}
	}
}
function getImmunizationId(immu,rowval){
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }

	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];

		        var immunizationId  = item.getElementsByTagName("immunizationId")[0];
		        document.getElementById('immunizationId'+rowval).value = immunizationId.childNodes[0].nodeValue;

	      	}
	      }
	    }

	    var index1 = immu.lastIndexOf("[");
	    var index2 = immu.lastIndexOf("]");
	    index1++;
	    var immunization = immu.substring(index1,index2);

	   var url="/hms/hms/registration?method=getImmunizationId&immunizationCode="+immunization+"&rowval="+rowval;

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
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
<%}
int token=0;
if(visit.getTokenNo()!=null){
	token=visit.getTokenNo();
}
%><%--- 
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onclick="submitForm('MedicalBoardInitialMedExamJsp','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=token%>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onclick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onclick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onclick="submitForm('MedicalBoardInitialMedExamJsp','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
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
<h2>AFMSF-15</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="MedicalBoardInitialMedExamJsp" action="" method="post">
<%
int medExamId = 0;
int visitId=0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();

}
int hinId=0;
if(medExamObj.getVisit()!=null){
	visitId=medExamObj.getVisit().getId();
	hinId=medExamObj.getHin().getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<input type="hidden" name="visitId" value="<%=visitId %>" validate="visitId,int,no"/>
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
<input tabindex="1" type="text" maxlength="99" class="autoArial" size="50" id="<%=PLACE %>" name="<%=PLACE %>"  value="<%=place%>"
	onKeyUp="limitText(this,99);" />
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Name  </label>

  <input type="text" value="<%= visit.getHin().getSFirstName()+" "+(visit.getHin().getSMiddleName()!=null?visit.getHin().getSMiddleName():"")+" "+(visit.getHin().getSLastName()!=null?visit.getHin().getSLastName():"") %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" maxlength="20"/>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />

<% }else{%>

 <input type="hidden"	value="Initial Medical Board AFMSF 15" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />


 <div class="clear"></div>
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
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" />

 <% }%>
 <div class="clear"></div>
 <label> DOB </label>
 <%
 if(visit.getHin().getDateOfBirth()!=null && !(visit.getHin().getDateOfBirth().equals(""))){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>

	<% }else if(medExamObj.getDateOfBirth()!=null && !(medExamObj.getDateOfBirth().equals(""))){%>
	  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"
			validate="DOB,date,yes" maxlength="10"
			onKeyUp="mask(this.value,this,'2,5','/');" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>

			<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value=""
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);" />

	<% }%>
 <label>Age  </label>
  <% if(visit.getHin().getAge()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=visit.getHin().getAge() %>" name="apparentAge"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	tabindex="2" />

 <% }%>
 <label>Gender</label>
  <input	type="text" readonly="readonly" value="<%= visit.getHin().getSex().getAdministrativeSexName() %>" name="sex"	tabindex="2" maxlength="20" />
  <%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%} %>
  <div class="clear"></div>
  <%--
  <label>Weight  </label>
 <%if(medExamObj.getPatientweight()!=null)
 { %>
  <input	class="autoArial" tabindex="1" type="text" value="<%=medExamObj.getPatientweight()%>" name="patientweight"	tabindex="3" maxlength="20" size="15"/>
 <% }else{%>
   <input	class="autoArial" tabindex="1" type="text"  name="patientweight"	tabindex="3" maxlength="20" size="15"/>
 <% }%>
 <label class="unit2">Kg</label>
<label>Height</label>
<%if(medExamObj.getPatientheight()!=null)
 { %>
  <input	class="auto" tabindex="1" type="text" value="<%=medExamObj.getPatientheight()%>" name="patientheight"	tabindex="3" maxlength="20" size="17"/>
 <% }else{%>
   <input	class="auto" tabindex="1" type="text"  name="patientheight"	tabindex="2" maxlength="20" size="17"/>
 <% }%>
 <label class="unit2">cm</label>
--%>
 <label>Address on Leave</label>
<%
String addressOnLeave="";

if(medExamObj.getParmanentAddress()!=null)
 {
	addressOnLeave=medExamObj.getParmanentAddress();
 }
%>
  <input	type="text" value="<%=addressOnLeave%>"  name="<%=PERMANENT_ADDRESS%>"	tabindex="2" maxlength="99" validate="Address on Leave,metachar,no" />
 

 
 <label>DOE/DOC</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" readonly="readonly" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_COMMENCEMENT%>,event);" />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date"   value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_COMMENCEMENT%>,event);" />
 <% }%>
<%
String recordOffice="";
if(medExamObj.getRecordoffice()!=null){
	recordOffice=medExamObj.getRecordoffice();
}
if(recordOffice.equalsIgnoreCase("")){
	if(visit.getHin()!=null){
		if(visit.getHin().getRecordOfficeAddress()!=null){
			recordOffice=visit.getHin().getRecordOfficeAddress().getAddress();
		}
	}	
}
%>
 <label>Record Office</label>
  <input	type="text" value="<%=recordOffice%>" name="<%=RECORDOFFICE%>"	maxlength="20" tabindex="1" readonly="readonly"/>
<div class="clear"></div>
 <label>Ceased Duty on</label>
<%if(medExamObj.getCeaseduty()!=null)
 { %>
  <input class="date" type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getCeaseduty())%>" name="<%=CEASEDDUTY%>"	tabindex="1" maxlength="20" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=CEASEDDUTY %>,event);" />

 <% }else{%>
   <input	type="text" id="ceasedDuty"  name="<%=CEASEDDUTY%>"	tabindex="2" maxlength="20" class="date" onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'ceasedDuty');" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=CEASEDDUTY %>,event);" />
 <% }%>
 <label>Past Medical History  </label>
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);" validate="Past Medical History,metachar,no"><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);" validate="Past Medical History,metachar,no"></textarea>
 <% }%>
 <div class="clear"></div>
<label>Present Med Cat </label>
<select 	name="<%=PRESENT_MEDICAL_CATEGORY %>"	validate="Med Category,string,no" tabindex=1>
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
</select>

<%
int ii=0;
for (Category category : categoryList) {
     			 %>
<script>
				categoryMedArray[<%=ii%>]= new Array();
				categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
</script>
<%
++ii;
}%>
<label>Period  </label>
<% if(medExamObj.getPresentMedPeriod() !=null && medExamObj.getPresentMedPeriod()!=""){
 String medCatPeriod=medExamObj.getPresentMedPeriod().substring(0,medExamObj.getPresentMedPeriod().indexOf(" "));
 String medCatDuration = medExamObj.getPresentMedPeriod().substring(medExamObj.getPresentMedPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="<%=medCatPeriod %>" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
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
 <%}else  if(visit.getHin().getMedCatPeriod() !=null && visit.getHin().getMedCatPeriod() !=""){
 String medCatPeriod=visit.getHin().getMedCatPeriod().substring(0,visit.getHin().getMedCatPeriod().indexOf(" "));
 String medCatDuration = visit.getHin().getMedCatPeriod().substring(visit.getHin().getMedCatPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="<%=medCatPeriod %>" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
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
 <%}else{%>
  <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %>
 </select>
 <%}else{%><input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="5" class="small"onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%if(medExamObj.getShapFactor() !=null){ %>
 <input type="text" name="shapeFactor" id="shapeFactor" value="<%=medExamObj.getShapFactor() %>" maxlength="19" tabindex="1" validate="Shape Factor,metachar,no"/>
 <%}else{ %>
  <input type="text" name="shapeFactor" id="shapeFactor" value="" maxlength="19" tabindex="1" validate="Shape Factor,metachar,no"/>
 <%} %> 
<div class="clear"></div>
<div>
<label>Signature of Individual</label>
<input type="text" disabled="disabled" />

<label >Date</label>
<% if(medExamObj.getOpiniondate()!=null){%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getOpiniondate())%>" />

<% }else{%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date%>" />
<% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=OPINION_DATE%>,event);" />
</div>

</div>

<div class="clear paddingTop15"></div>
<h4> DETAILS OF PRESENT AND PREVIOUS DISABILITIES <a href="javascript:animatedcollapse.toggle('slide5')"></a>
<div class="floatRight"><input type="button" value="Upload Injury Report" class="buttonBig" onClick="javascript:fileUploadViewWindow('INJ');" /></div>
</h4>

<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col">Disabilities</TH>
<TH scope="col" colspan="2">Category For Disability</TH>
<%---
<TH scope="col" colspan="2">Date of Origin</TH>
<TH scope="col" >Place of Origin</TH>
<TH scope="col">Prev Med Cat</TH>
<TH scope="col" colspan="2">Prev Med Cat Date</TH>
<TH scope="col" colspan="2">Next Med Cat due on</TH> --%>
<TH scope="col" >Attributability/Aggravation </TH>
<th scope="col">Previous Disablement %</th>
<th scope="col">Present Disablement %</th>
<th scope="col">Reason for Variation</th>
<TH scope="col" colspan="2">Composite</TH>

<%--
<TH scope="col"> Remarks</TH> --%>
<th></th>
<th></th>
<!--<th>Add</th>
<th>Delete</th>
-->
</tr>

<%
int ii1=0;
for (Category category : categoryList) {
     			 %> <script>

     			categoryMedArray[<%=ii1%>]= new Array();
     			categoryMedArray[<%=ii1%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii1%>][1] = "<%=category.getCategories()%>";
            </script> <%
++ii1;
}%>
<%int inc1123=0;
/*
if(medExamObj.getMasmedicaldetail()!=null && medExamObj.getMasmedicaldetail().size()>0)
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
<td width="10%">
<input tabindex="1" size="3" type="hidden"	name="serviceid<%=inc1123 %>" maxlength="3" value="<%=masMedicalExamDetails.getServiceid() %>"/>
<input tabindex="1" size="2" type="text"	name="<%=SIRIAL_NO+inc1123 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialno() %>"/></td>
<%--
<% if(masMedicalExamDetails.getPrincipal()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPrincipal() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<% }%>
 --%>
<%
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
		principal=principal+"["+icdCode+"]"+"["+icdId+"]";
	}
  %>
<td width="10%"> 
 <input type="text" tabindex="1"	value="<%=principal%>" id="<%=PRINCIPAL+inc1123%>"  name="<%=PRINCIPAL+inc1123%>"	class="auto"  size="22" />
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		<%--  new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'}); --%>
		  new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'});
		   //document.getElementById('slide0').style.display="hide"
</script>
</td>

<%---
<td width="10%">
<% if(masMedicalExamDetails.getOrigindate()!=null){%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" size="11"  	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getOrigindate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=ORIGIN_DATE+inc1123%>,event);" />
</td>
<% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<% }%>
<td width="10%">

<select 	class="medium" name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>" id="presentMedCategory<%=inc1123 %>"validate="Medical Category,string,no" tabindex=1>
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
</td>
<script>

document.getElementById('presentMedCategory<%=inc1123 %>').value='<%=categoryId%>'
</script>

<% if(masMedicalExamDetails.getAddressfrom()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getAddressfrom() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1123 %>" maxlength="10" /></td>
<% }%> 
<td width="10%">
<% if(masMedicalExamDetails.getMedicalcatdate()!=null){%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getMedicalcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=MEDICAL_CAT_DATE+inc1123%>,event);" />
</td>
<td width="10%">
<% if(masMedicalExamDetails.getNextcatdate()!=null){%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getNextcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=NEXT_CAT_DATE+inc1123%>,event);" />
</td> --%>
<td>
<select class="medium"	name="categoryForDisable<%=inc1123%>" id="categoryForDisable<%=inc1123 %>"	validate="Category Disablity,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
	int categoryDisId=0;
	if(masMedicalExamDetails.getCategoryDisability()!=null)
	{
		categoryDisId=masMedicalExamDetails.getCategoryDisability().getCategoryid();
	}
			for (Category category : categoryList) {
		/*	String selected="";
				if(masMedicalExamDetails.getCategoryDisability()!=null){


				if(masMedicalExamDetails.getCategoryDisability().getCategoryid().equals(categoryDisId))
					{
					selected="selected";
					}
				}*/
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select>
<script type="text/javascript">
document.MedicalBoardInitialMedExamJsp.categoryForDisable<%=inc1123%>.value='<%=categoryDisId%>';
</script>
</td>
<td width="10%">
<%if(masMedicalExamDetails.getCateDisPeriod() !=null){
String getCateDisPeriod=masMedicalExamDetails.getCateDisPeriod().substring(0,masMedicalExamDetails.getCateDisPeriod().indexOf(" "));
String getCateDisDuration =masMedicalExamDetails.getCateDisPeriod().substring(masMedicalExamDetails.getCateDisPeriod().indexOf(" ")+1);%>

<input type="text" name="medCatPeriod<%=inc1123 %>" id="medCatPeriod<%=inc1123 %>" value="<%=getCateDisPeriod %>" maxlength="5" class="auto" size="4"/>
 <select name="medCatDuration<%=inc1123 %>" id="medCatDuration<%=inc1123 %>" class="medium">
<%if(getCateDisDuration.equalsIgnoreCase("Months")){ %>
 <option value="Months" selected="selected">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(getCateDisDuration.equalsIgnoreCase("Weeks")){ %>
 <option value="Months">Months</option>
 <option value="Weeks" selected="selected">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(getCateDisDuration.equalsIgnoreCase("Days")){ %>
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days" selected="selected">Days</option>
 <%}else{ %> <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{ %>
 <input type="text" name="medCatPeriod<%=inc1123 %>" id="medCatPeriod<%=inc1123 %>" value="" maxlength="5" size="4"/>
 <select name="medCatDuration<%=inc1123 %>" id="medCatDuration<%=inc1123 %>" class="medium">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
 <%} %></td>
<td>
<%
String aggravation="";
if(masMedicalExamDetails.getDisabilityAggravation()!=null){
	aggravation=masMedicalExamDetails.getDisabilityAggravation();
}
%>
<select name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
<script type="text/javascript">

document.MedicalBoardInitialMedExamJsp.aggravation<%=inc1123%>.value='<%=aggravation%>'
</script>
</td>
<!-- New Lines
name="prevDisabilities" id="prevDisabilities"
 name="pastDisabilities" id="pastDisabilities"
 name="variationReason" id="variationReason"-->
<% if(masMedicalExamDetails.getPreDisability()!=null){%>
<td width="10%"><input tabindex="1" type="text"	size="3" name="prevDisabilities<%=inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPreDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	size="3" name="prevDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<% if(masMedicalExamDetails.getPastDisability()!=null){%>
<td width="10%"><input tabindex="1" size="3" type="text"	name="pastDisabilities<%=inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPastDisability() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" size="3" type="text"	name="pastDisabilities<%=inc1123 %>" maxlength="10" /></td>
<% }%>

<% if(masMedicalExamDetails.getReasonVariation()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="variationReason<%=inc1123 %>" maxlength="30" value="<%=masMedicalExamDetails.getReasonVariation() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="variationReason<%=inc1123 %>" maxlength="30" /></td>
<% }%>

<!--End of  New Lines --><%---
<%
String remarks="";
if(masMedicalExamDetails.getDisabilityRemarks()!=null){
	remarks=masMedicalExamDetails.getDisabilityRemarks();
}
%>
<td>
<input tabindex="1" type="text" value="<%=remarks%>" maxlength="50"  name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> --%>

<td>
<select class="medium"	name="compositeCategory<%=inc1123%>" id="compositeCategory<%=inc1123 %>"	validate="Category Disablity,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
	int categoryCompId=0;
	if(masMedicalExamDetails.getCompositeCate()!=null)
	{
		categoryCompId=masMedicalExamDetails.getCompositeCate().getCategoryid();
	}
			for (Category category : categoryList) {
			/*	String selected="";
				if(masMedicalExamDetails.getCompositeCate()!=null){


				if(masMedicalExamDetails.getCompositeCate().getCategoryid().equals(categoryCompId))
					{
					selected="selected";
					}
				}*/
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select>
<script type="text/javascript">
document.MedicalBoardInitialMedExamJsp.compositeCategory<%=inc1123%>.value='<%=categoryCompId%>';
</script>
</td>
<td width="10%">
<%if(masMedicalExamDetails.getCompCatePeriod() !=null){
String getCompCatePeriod=masMedicalExamDetails.getCompCatePeriod().substring(0,masMedicalExamDetails.getCompCatePeriod().indexOf(" "));
String getCompCateDuration =masMedicalExamDetails.getCompCatePeriod().substring(masMedicalExamDetails.getCompCatePeriod().indexOf(" ")+1);%>

<input type="text" name="medCatPeriodComp<%=inc1123 %>" id="medCatPeriodComp<%=inc1123 %>" value="<%=getCompCatePeriod %>" maxlength="5" class="auto" size="4"/>
 <select name="medCatDurationComp<%=inc1123 %>" id="medCatDurationComp<%=inc1123 %>" class="medium">
<%if(getCompCateDuration.equalsIgnoreCase("Months")){ %>
 <option value="Months" selected="selected">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(getCompCateDuration.equalsIgnoreCase("Weeks")){ %>
 <option value="Months">Months</option>
 <option value="Weeks" selected="selected">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(getCompCateDuration.equalsIgnoreCase("Days")){ %>
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days" selected="selected">Days</option>
 <%}else{ %> <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{ %>
 <input type="text" name="medCatPeriodComp<%=inc1123 %>" id="medCatPeriodComp<%=inc1123 %>" value="" maxlength="5" class="auto" size="4"/>
 <select name="medCatDurationComp<%=inc1123 %>" id="medCatDurationComp<%=inc1123 %>" class="medium">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
 <%} %></td>
 
 
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>

</TR>


<%
}}}if(inc1123<=0){
	inc1123=inc1123+1;%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text"	name="<%=SIRIAL_NO+inc1123 %>" value="<%=inc1123 %>" maxlength="3" /></td>
<%--
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
 --%>
<%
 String principal="";
 %>
<td width="10%"> 
 <input type="text" tabindex="1"	value="<%=principal%>" id="<%=PRINCIPAL+inc1123%>"  name="<%=PRINCIPAL+inc1123%>"	class="auto"  size="22" />
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'});
		   //document.getElementById('slide0').style.display="hide"
</script>
</td><%---
<td width="10%">
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" class="date" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=ORIGIN_DATE+inc1123%>,event);" />
</td>

<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" maxlength="10" /></td>
<td width="10%">
<select 	name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>"	validate="Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
			for (Category category : categoryList) {
				String selected="";
				%>
	<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%> </option>
	<%}%>
</select>

</td>
<td width="10%">
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" class="date" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=MEDICAL_CAT_DATE+inc1123%>,event);" />
</td>

<td width="10%">
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" class="date" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=NEXT_CAT_DATE+inc1123%>,event);" />
</td> --%>

<td>
<select class="medium"	name="categoryForDisable<%=inc1123%>" id="categoryForDisable<%=inc1123 %>"	validate="Category Disablity,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
			for (Category category : categoryList) {
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select>

</td>
<td width="10%">
 <input type="text" name="medCatPeriod<%=inc1123 %>" id="medCatPeriod<%=inc1123 %>" value="" maxlength="5" class="auto" size="4" />
 <select name="medCatDuration<%=inc1123 %>" id="medCatDuration<%=inc1123 %>" class="medium">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
</td>
<td>
<select name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
</td>

<td width="10%"><input tabindex="1" type="text"	name="prevDisabilities<%=inc1123 %>" validate="Pre Disabilities,num,no" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	name="pastDisabilities<%=inc1123 %>" validate="Past Disabilities,num,no" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	name="variationReason<%=inc1123 %>" validate="Reason for Variation,string,no" maxlength="49" /></td>
<%---<td>
<%
String remarks="";
%>
<input tabindex="1" type="text" value="<%=remarks%>" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> --%>
<td>
<select class="medium"	name="compositeCategory<%=inc1123%>" id="compositeCategory<%=inc1123 %>"	validate="Composite,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
			for (Category category : categoryList) {
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select>

</td>
<td width="10%">
 <input type="text" name="medCatPeriodComp<%=inc1123 %>" id="medCatPeriodComp<%=inc1123 %>" value="" maxlength="5" class="auto" size="4" />
 <select name="medCatDurationComp<%=inc1123 %>" id="medCatDurationComp<%=inc1123 %>" class="medium">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb" value="<%=inc1123%>" id="hdb" />
</table>
</div>
<script type="text/javascript">
var categoryArray=new Array();
var categoryCompArray=new Array();
</script>
<%
	int iii=0;
	for (Category category : categoryList) {
	     			 %>
	<script>
		categoryArray[<%=iii%>]= new Array();
		categoryArray[<%=iii%>][0] = "<%=category.getCategoryid()%>";
		categoryArray[<%=iii%>][1] = "<%=category.getCategories()%>";
	</script>
<%
	++iii;
	}
	int compCate=0;
	for (Category category : categoryList) {
	     			 %>
	<script>
		categoryCompArray[<%=compCate%>]= new Array();
		categoryCompArray[<%=compCate%>][0] = "<%=category.getCategoryid()%>";
		categoryCompArray[<%=compCate%>][1] = "<%=category.getCategories()%>";
	</script>
	<%
	++compCate;
} %>

</div>
<div class="clear paddingp15"></div>
<%--<div class="Block">

<h4>Specialist Opinion<a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<input type="hidden" name="flag1" value="" id="flag1" />
<input name="view" type="button" class ="button" value="ViewDocuments" onClick="javascript:ViewDocumentWindow();"/>
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getMedExamType().equalsIgnoreCase("Initial Medical Board AFMSF 15")){%>
<div class="clear paddingTop15"></div>
<h4>Case Summary <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">

<label > Disability Attributable <br /><span class="sublabel">(to service)</span></label>
<select name=<%=DISABILITY%> size="0" tabindex="1" id="disability" class="small" onchange="changeRemark()">
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
<label> Remarks</label>
<input  type="text" id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  value="<%=medExamObj.getDisabilityAttribute()%>"  class="Auto" size="25" maxlength="100" />
<%}%>
<div id="disattribute" style="display: none">
<label>Remarks</label>
<input  type="text" id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%> class="Auto"  size="25" maxlength="100" />
</div>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<label>Case Summary</label>

	<% if(medExamObj.getCaseSheet() != null){ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"><%=medExamObj.getCaseSheet()%></textarea>
<%}else{ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"></textarea>

	<%} %>
<div class="clear"></div>
<label > Aggravated <br /><span class="sublabel">by Service)</label>
<select name=<%=AGGRAVATED_SERVICE_LABEL%> size="0" tabindex="1" id="aggravated" class="small" onchange="changeRemark1()">
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
<label>Remarks</label>
<input  type="text" name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" value="<%=medExamObj.getAggravatedServiceDesc()%>" class="Auto" size="25" maxlength="100" />
<%}%>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<input type="hidden" name="flag"	value="Upload" id="flag">
<div id="aggravatedid" style="display: none">
<label >Remark</label>
<input tabindex="1" type="text" name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" class="Auto" size="100" maxlength="100" />
</div>
</div>
<% }%>
--%>

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
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>

 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }%>


<label >Total Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }%>
	<label class="">Total No. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" class=""  value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" class=""
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>

<label >Missing </label>
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	 value="<%=medExamObj.getMissingTeeth() %>"	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>

<label >Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%>
 <label>Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"	 onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="30"  size="6" validate="Condition Of Gums,Alphabetic,Yes" />
 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="Healthy" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="30" validate="Condition Of Gums,Alphabetic,Yes"  size="6" />

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
	<label>Dental Officer </label> 

 <input type="text" 	value="<% if(medExamObj.getDentalOfficer()!=null) {out.print(medExamObj.getDentalOfficer());} %>"	name="DentalOfficer" maxlength="200" tabindex="2"  validate="DentalOfficer,string,yes" />
 
	<label>Dental Checkup Date</label> <%if(medExamObj.getDentalCheckupDate()==null)
{%> <input tabindex="1" type="text" name="<%=DENTAL_CHECKUP_DATE %>"
	class="calDate" maxlength="10" class="auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
	validate="Dental Checkup Date,date,no" /> <% }else{%> <input tabindex="1"
	type="text" name="<%=DENTAL_CHECKUP_DATE %>" class="calDate" maxlength="10"
	disabled="disabled" onKeyUp="mask(this.value,this,'2,5','/');"
	value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDentalCheckupDate()) %>"
	validate="Dental Checkup Date,date,no" /> <% }%> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DENTAL_CHECKUP_DATE%>,event);" />
<div class="clear"></div>
<label> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="62" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,250);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="62"	name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,250);"></textarea>
 <% }%>
<%
if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){
%>
<input tabindex="1" type="checkbox"	name="refferToMh" value="" class="radioAuto" id="dentalReferId" checked="checked" 
onclick="checkDentalReferToMH();"/>
<%}else{ %>
<input tabindex="1" type="checkbox"	name="refferToMh" value="" class="radioAuto" id="dentalReferId" 
onclick="checkDentalReferToMH();" />
<%} %>
<label class="medium">Refer to MH</label>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('DEN');" 
style="display: none" id="dentalDivId"/>
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>

<div class="clear paddingTop15"></div>


<h4> PHYSICAL CAPACITY <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<label>Height</label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text"   id="height" class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"  value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"   id="height"	class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"
	maxlength="6" onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }%>

<label>Weight</label>
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"  id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" size="10"/><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" size="10" /><label class="unit">kg</label>

 <% }%>


<label>SD</label>
	<%
	if(medExamObj.getSD()!=null){
	%>
<input type="text" value="<%=medExamObj.getSD() %>" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>
<%}else{ %>
<input type="text" value="" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>

<%} %>
<input type="hidden" value="" name="sdVal" id="sdVal"/>

<div class="clear"></div>

<label>Ideal Weight</label>
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"   id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>

<label>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto" size="10"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto" size="10"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>
<label>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }%>
  <div class="clear"></div>
 <label>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>" maxlength="6"
	onKeyUp="limitText(this,6);"  />

 <% }%>
 <input type="text" class="transparent" size="6">
<label>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto"  size="10" />
  <label class="unit">cm</label>
 <% }%>
 <label>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto" size="10"  />
	<label class="unit">cm</label>

 <% }%>
 <div class="clear"></div>
<label>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />

 <% }%>
  <input type="text" class="transparent" size="6">

<label>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10"  />
<label class="unit">cm</label>
 <% }%>
<label>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	 maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<div class="clear"></div>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
   <label class="unit">cm</label>
 <% }%>

<label>Sportsman</label>
<select name="<%=SPORTS %>"  id="<%=SPORTS %>" validate="Sports Man,stirng,no" class="smaller"  >
<option value="No">No</option>
<option value="Yes">Yes</option>

</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
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
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="9" value="<%=medExamObj.getWthoutGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="9" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="9" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="9" />
 <% }%>
 </td>
 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
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
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<%-- <td width="10%">

  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>

 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>

<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>--%>

	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
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
			<input tabindex="1" size="10" type="text"   id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" size="10" type="text"  id="hrfw" name="<%=HEARING_R_F_W %>" value="600" onkeyup="isNumber1(this)"	maxlength="6"  onblur="checkForWiegth(this.value,id);" />
			<%} %>
			cm
		</td>

		<td>
			<% if(medExamObj.getEarHearingLfw() != null){ %>
			<input tabindex="1" size="10" type="text"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" size="10" type="text"  id="hrfw" name="<%=HEARING_L_F_W %>" value="600" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%} %>
			cm
		</td>

		<td>
			<% if(medExamObj.getEarHearingBothFw() != null){ %>
			<input tabindex="1"  size="10" type="text" size="" maxlength="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1"  size="10" type="text"  id="bothfw" size="" maxlength="10"	value="600" name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);"/>
			<%} %>
			cm

		</td>
		</tr>


	<tr>
		<th>CV</th>
		<td>

<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" size="10" type="text"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%}else{ %>
	 <input tabindex="1" size="10" type="text"   id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  />

	<%} %>
	cm
</td>

		<td>
			<% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" size="10" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

	  <%}else{ %>
	    <input tabindex="1" size="10" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

	  <%} %>
	  cm


		</td>

		<td>

	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" size="10" type="text"  maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%}else{ %>
 <input tabindex="1" size="10" type="text"  maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%} %>
cm
		</td>
		</tr>

	<tr>
	<th>TM</th>
<%
String tmr="";
String tml="";
String mobility_r="Normal";
String mobility_l="Normal";
String noseThroatSinuses="NAD";
String audiometryRecord="Not Done";
if(medExamObj.getTympanicR() != null){
	tmr=medExamObj.getTympanicR();
}
if(medExamObj.getTympanicL() != null){
	tml=medExamObj.getTympanicL();
}
if(medExamObj.getMobilityR()!=null){
	mobility_r=medExamObj.getMobilityR();
}
if(medExamObj.getMobilityL()!=null){
	mobility_l=medExamObj.getMobilityL();
}
if(medExamObj.getNoseThroatSinuses() !=null){
	noseThroatSinuses=medExamObj.getNoseThroatSinuses();
}
if(medExamObj.getAudiometryRecord()!=null){
	audiometryRecord=medExamObj.getAudiometryRecord();
}
%>
<td>
<select name="<%=TYMPANIC_R %>" id="<%=TYMPANIC_R%>" tabindex="1" class="small2"  size="0" >
<option value="Intact">Intact</option>
	<option value="Not Intact">Not Intact</option>
	</select>
<script type="text/javascript">
<%
if(!tmr.equals("")){
%>
document.getElementById('<%=TYMPANIC_R%>').value = '<%=tmr%>'
<%}%>
</script>
</td>
<td>
<select name="<%=TYMPANIC_L %>" id="<%=TYMPANIC_L %>" class="small2" size="0" tabindex="1" >
<option value="Intact">Intact</option>
	<option value="Not Intact">Not Intact</option>
	</select>
<script type="text/javascript">
<%
if(!tml.equals("")){
%>
document.getElementById('<%=TYMPANIC_L%>').value = '<%=tml%>'
<%}%>
</script>
	</td>
	<td></td>
</tr>

<tr>
<th>Mobility</th>
<td>
<input tabindex="1" type="text" size="10" name="<%=MOBILITYR %>" id="<%=MOBILITYR %>" maxlength="99" value="<%=mobility_r%>"/>
</td>
<td >
<input tabindex="1" type="text" size="10"  name="<%=MOBILITYL %>" id="<%=MOBILITYL %>" maxlength="99"  value="<%=mobility_l%>"/>
</td>
<td></td>
</tr>

	</table>





<div class="Block">
<div class="clear"></div>
<%--
<label>FWR</label>
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" class="small" type="text"  class="auto" id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<label class="unit">cm</label>
	<%}else{ %>
	<input tabindex="1" class="small" type="text"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6"  onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>

	<%} %>
	--%>
	<%--<label>FWL</label>
<% if(medExamObj.getEarHearingLfw() != null){ %>
<input tabindex="1" class="small" type="text"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<label class="unit">cm</label>
	<%}else{ %>
	<input tabindex="1" class="small" type="text"  id="hrfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>
	<%} %>--%>
<%--
	<label>FW BOTH</label>
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1"  class="small" type="text" size="10" maxlength="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>
<%}else{ %>
		<input tabindex="1"  class="small" type="text"  id="bothfw" size="10" maxlength="10"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);"/>
	<label class="unit">cm</label>
	<%} %>--%>

<div class="clear"></div>
<%--
<label>CVR</label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" class="small" type="text"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
 <label class="unit">cm</label>
<%}else{ %>
	 <input tabindex="1" class="small" type="text"   id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  />
	 <label class="unit">cm</label>
	<%} %>
	 <label >CVL</label>

	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" class="small" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <label class="unit">cm</label>
	  <%}else{ %>
	    <input tabindex="1" class="small" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	    <label class="unit">cm</label>
	  <%} %>
	  <label>CV BOTH </label>
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" class="small" type="text" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <label class="unit">cm</label>
<%}else{ %>
 <input tabindex="1" class="small" type="text" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
 <label class="unit">cm</label>
<%} %>

--%>
<div class="clear"></div>
<%--
<label >TMR</label>
<%
String tmr="";
String tml="";
String mobility_r="";
String mobility_l="";
String noseThroatSinuses="";
String audiometryRecord="";
if(medExamObj.getTympanicR() != null){
	tmr=medExamObj.getTympanicR();
}
if(medExamObj.getTympanicL() != null){
	tml=medExamObj.getTympanicL();
}
if(medExamObj.getMobilityR()!=null){
	mobility_r=medExamObj.getMobilityR();
}
if(medExamObj.getMobilityL()!=null){
	mobility_l=medExamObj.getMobilityL();
}
if(medExamObj.getNoseThroatSinuses()!=null){
	noseThroatSinuses=medExamObj.getNoseThroatSinuses();
}
if(medExamObj.getAudiometryRecord()!=null){
	audiometryRecord=medExamObj.getAudiometryRecord();
}
%>

<select name="<%=TYMPANIC_R %>" id="<%=TYMPANIC_R%>" tabindex="1" class="small2"  size="0" maxlength="20">
<option value="0">Intact</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	</select>
<script type="text/javascript">
document.getElementById('<%=TYMPANIC_R%>').value = '<%=tmr%>'
</script>

<label >TML</label>
<select name="<%=TYMPANIC_L %>" id="<%=TYMPANIC_L %>" class="small2" size="0" maxlength="20" tabindex="1" >
<option value="0">Intact</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	</select>
<script type="text/javascript">
document.getElementById('<%=TYMPANIC_L%>').value = '<%=tml%>'
</script>
--%>

<div class="clear"></div>
<label >Nose,Throat &amp; Sinuses</label>
<input tabindex="1" type="text" name="<%=NOSE_THROAT_SINUSES%>" id="<%=NOSE_THROAT_SINUSES%>" size="15" class="" 
value="<%=noseThroatSinuses%>" maxlength="49"validate="Nose,Throat,Sinuses,metachar,no" />

<label >Audiometry Record</label>
<input tabindex="1" type="text" name="<%=AUDIOMETRY_RECORD%>" id="<%=AUDIOMETRY_RECORD%>" class="" value="<%=audiometryRecord%>" size="16" maxlength="49"
validate="Audiometry Record,metachar,no"/>
<%--
<label>Nose,Throat &amp; Sinuses</label>
<input tabindex="1" type="text"  size="15" class="auto">


<label >Audiometry Record</label>
<input tabindex="1" type="text" class="auto"  size="16" value="Not Done" maxlength="10">

<input name="Send" type="button"  class="button" value="Upload" onclick="javascript:FileUploadWindow();" />
New --%>
<input name="Send" type="button"  class="buttonBig" value="View/ Upload" onclick="javascript:fileUploadViewWindow('HEA');" />
</div>
</div>

<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>

<!--  End Of Hearing -->
<!--  Start Of Investigations -->
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


<input name="Prevoius" type="button" tabindex="2" value="Prev Investigations"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
<%if(dgOrderhd !=null && dgOrderhd.getClinicalNote() !=null){
%>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="<%=dgOrderhd.getClinicalNote() %>" size="100" maxlength="45" validate="Clinical Notes,metachar,no"/></td>
<%}else{ %>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="For Medical Board" size="100" maxlength="45"validate="Clinical Notes,metachar,no" /></td>
<%} %>
</tr>
</table>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
<tr>
	<th scope="col">Investigation</th>
	<th scope="col">Refer to MH</th>
	<th scope="col">Result</th>
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
	   
	   int inc1=1;
	   
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
		      	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	 DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Ritu 
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
		    	++inc1;
		    	//
		    }

			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();



		    %>
	<tr>

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
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
		
		<td> <%---<input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
	 </td> --%><%}else{ %>
	 <td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" />
	 <%} %>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
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
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
	    	{%>
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

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
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

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>


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
<!--  End Of Investigations -->
<%--
<div class="clear paddingTop15"></div>

<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide6">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
	<option value="0">Select</option>

</select>
</div>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>

<input name="Prevoius" type="button" tabindex="2" value="Prev Investigation"	class="buttonBig"	onclick="openPopupForPatientInvestigation()" />

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
		<th scope="col">Refer to MH</th>
		<th scope="col">Test Result</th>
		<th scope="col">File Upload</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>

<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
	<tr>
		<td>
		 <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
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
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" />
</td>
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onclick="javascript:fileUploadWindowInvestigation(1);" /></td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
</table>
</div>
</div>
<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>

<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>
--%>
<!--  Start Of GYNAECOLOGY EXAM -->
<%
	if(!visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){
%>
<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="29" value="<%=medExamObj.getMenstrualHistory() %>" validate="Menstrual History,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="29"  validate="Menstrual History,metachar,no"/>
 <% }%>
<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  name="<%=LMP %>" class="date" size="20" maxlength="10" 
value="<%=HMSUtil.changeDateToddMMyyyy(medExamObj.getLmp()) %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=LMP %>" class="date" size="20" maxlength="10" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=LMP%>,event);" />
<label >No. of Pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<div class="clear"></div>
<label >No. of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" id="noofabo" name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" id="noofabo" name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text"	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  class="date" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="1" type="text"  class="date" readonly="readonly"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="49" value="<%=medExamObj.getVaginalDischarge() %>" validate="Vaginal Discharge,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="49" validate="Vaginal Discharge,metachar,no"/>
 <% }%>
<label	>Prolapse</label>
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="9" value="<%=medExamObj.getProlapse() %>" validate="Prolapse,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="9" validate="Prolapse,metachar,no"/>
 <% }%>

<label >USG Abdomen</label>
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="" size="20" maxlength="30" value="<%=medExamObj.getUsgAbdomen() %>" validate="USG Abdomen,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="" size="20" maxlength="30" validate="USG Abdomen,metachar,no" />
 <% }%>
 <div class="clear"></div>
<%--
<input name="Send" type="button"  class="button" value="Upload" onclick="javascript:FileUploadWindowGynaecology();" />
<input name="Send" type="button"  class="button" value="Upload/View"
			onclick="javascript:fileUploadViewWindow('GYN');" />
 --%>
<input name="Send" type="button"  class="button" value="Upload/View" onclick="javascript:fileUploadViewWindow('GYN');" />

</div>
</div><%}%>

<div class="clear"></div>
<!--  End Of GYNAECOLOGY EXAM -->

<div class="clear"></div>
<div class="Clear paddingTop15"></div>
<h4>CLINICAL SUMMARY</h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">

<%
String presentConditions="";
String medication="";
BigDecimal temperature=new BigDecimal(0);
String pulseRates="";
String bp1="";
String rr="";
String generalPhysicalExam="NAD";
String cardiovascularSystem="NAD";
if(medExamObj.getPresentCondition()!=null){
	presentConditions=medExamObj.getPresentCondition();
}

if(medExamObj.getMedication()!=null){
	medication=medExamObj.getMedication();
}
if(medExamObj.getGeneralPhysicalExam()!=null){
	generalPhysicalExam=medExamObj.getGeneralPhysicalExam();
}

if(medExamObj.getGastroIntestinalSystem()!=null){
}
if(medExamObj.getCardiovascularSystem()!=null){
	cardiovascularSystem=medExamObj.getCardiovascularSystem();

}
%>
<%
String diagnosis1="";
String diagnosis2="";
String onsetDiag1="";
String onsetDiag2="";
String placeLastBoard="";
String dateLastBoard="";
if(medExamObj.getDiagnosis1Clini()!=null){
	diagnosis1=medExamObj.getDiagnosis1Clini();
}
if(medExamObj.getDiagnosis2Clini()!=null){
	diagnosis2=medExamObj.getDiagnosis2Clini();
}
if(medExamObj.getOnsetDiag1()!=null){
	onsetDiag1=medExamObj.getOnsetDiag1();
}
if(medExamObj.getOnsetDiag2()!=null){
	onsetDiag2=medExamObj.getOnsetDiag2();
}
if(medExamObj.getPlaceLastCatBoard()!=null){
	placeLastBoard=medExamObj.getPlaceLastCatBoard();
}
if(medExamObj.getLastBoardDate()!=null){
	dateLastBoard=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getLastBoardDate());
}

%>
<label>Diagnosis</label>
 <input size="1" class="transparent">
 <label class="unit">1.</label>
<input type="text" name="diagnosis1" id="diagnosis1" value="<%=diagnosis1%>" class="auto" size="45" maxlength="499" validate="Diagnosis,metachar,no"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag1" id="onsetDiag1" value="<%=onsetDiag1%>" class="auto" size="50" maxlength="29" validate="Onset,metachar,no"/>
<div class="clear"></div>
<input size="33" class="transparent">
 <label class="unit">2.</label>
<input type="text" name="diagnosis2" id="diagnosis2" value="<%=diagnosis2%>" class="auto" size="45" maxlength="499"/ validate="Diagnosis,metachar,no">
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag2" id="onsetDiag2" value="<%=onsetDiag2%>" class="auto" size="50" maxlength="29"  validate="Onset,metachar,no"/>
<div class="clear"></div>
<label>Last Medical Board</label>
 <input size="1" class="transparent">
 <label class="unit">Place</label>
<input type="text" name="lastMedBoardPlace" id="lastMedBoardPlace" value="<%=placeLastBoard%>" class="auto" size="45" maxlength="49" validate="Place,metachar,no"/>
<label class="unit">Date</label>
<input type="text" name="dateLastBoard" id="dateLastBoard" value="<%=dateLastBoard%>" class="auto" size="45" readonly="readonly" maxlength="10"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.dateLastBoard,event);" />
 <div class="clear"></div>
<label>Present Condition</label>
<textarea rows="" cols="125" class="auto"name="presentConditions" id="presentConditions" 
validate="Present Conditions,string,no" onkeyup="chkLength(this,2000);"  validate="Present Condition,metachar,no"><%=presentConditions%></textarea>
<div class="clear"></div>
<label>Medication</label>
<input type="text" name="medication" id="medication" value="<%=medication%>" size="125" class="auto" maxlength="999" validate="Medication,metachar,no"/>
<div class="clear"></div>
<h4>Examination</h4>
<div class="clear"></div>
<label>Temperature</label>
 <% if(medExamObj.getTemprature()!=null){%>
  <input tabindex="1" type="text" name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="5"  value="<%=medExamObj.getTemprature() %>" validate="num,float,no"/>
  <label class="auto"><sup>o</sup>F</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="5" validate="Temp,num,no"/><label class="unit">/min</label>
 <% }%>
<input size="2" class="transparent">
<label class="auto">Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text"name="<%=PULSE_RATES%>" class="auto" size="3" maxlength="19"  value="<%=medExamObj.getPulseRates() %>" validate="Pulse,string,no"/>
  <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text"name="<%=PULSE_RATES%>" class="auto" size="3" maxlength="19" validate="Pulse,string,no"/><label class="unit">/min</label>
 <% }%>
 <input size="2" class="transparent">
 <label class="auto">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="5" maxlength="19"  value="<%=medExamObj.getBp() %>" validate="BP,string,no"/>
 <label class="auto">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="5" maxlength="19" validate="BP,string,no"/>
 <label class="auto">mm Hg</label>
 <% }%>
 <input size="2" class="transparent">
<label class="auto">RR</label>
<% if(medExamObj.getRrClinical()!=null){%>
  <input tabindex="1" type="text"name="<%=RR%>" class="auto" size="3" maxlength="49"  value="<%=medExamObj.getRrClinical() %>" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text"name="<%=RR%>" class="auto" size="3" maxlength="49" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }%>
 <div class="clear"></div>
<label>General Physical Exam</label>
<input type="text" name="generalPhysicalExam" id="generalPhysicalExam" value="<%=generalPhysicalExam%>" size="100" class="auto"
   maxlength="999" validate="General Physical Exam,metachar,no"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" name="cardiovascularSystem" id="cardiovascularSystem" value="<%=cardiovascularSystem%>" size="100" class="auto"
	maxlength="999" validate="Cardiovascular System,metachar,no"/>
<div class="clear"></div>

<label>Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="999"  name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" value="<%=medExamObj.getRespiratorySystem() %>" validate="Respiratory System,metachar,no"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="999" value="NAD" name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" validate="Respiratory System,metachar,no"/>

 <% }%>
<div class="clear"></div>
			<%

			String gastroIntestinalSystem="NAD";
			String breakDown="";
			String centralNervousSystem="NAD";

			String localExamination="";
			String remarksClinical="";
			String referredToMhClinical="";
			int opdDeptClinical=0;
			if(medExamObj.getGastroIntestinalSystem()!=null){
				gastroIntestinalSystem=medExamObj.getGastroIntestinalSystem();
			}
			if(medExamObj.getCentralNervousSystem()!=null){
				centralNervousSystem=medExamObj.getCentralNervousSystem();
			}
			if(medExamObj.getLocalExamination()!=null){
				localExamination=medExamObj.getLocalExamination();
			}
			if(medExamObj.getRemarksClinical()!=null){
				remarksClinical=medExamObj.getRemarksClinical();
			}

			if(medExamObj.getClinicalReferMh()!=null){
				referredToMhClinical=medExamObj.getClinicalReferMh();
			}
			if(medExamObj.getClinicalOpdDept()!=null){
				opdDeptClinical=medExamObj.getClinicalOpdDept().getId();
			}
			%>

<label>Gastro Intestinal System</label>

<input type="text" name="gastroIntestinalSystem" id="gastroIntestinalSystem" value="<%=gastroIntestinalSystem%>" size="100" class="auto"
 maxlength="999" validate="Gastro Intestinal System,metachar,no"/>
<div class="clear"></div>


<label>Central Nervous System </label><%-- 
<% if(medExamObj.getCentralNervousSystemMMHG()!=null){%>
  <input tabindex="1" type="text" maxlength="1"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100"  value="<%=medExamObj.getCentralNervousSystemMMHG()%>" validate="Central Nervous System unit,string,no"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="1" value="Normal" name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100" validate="Central Nervous System,string,no"/>

 <% }%>--%>
 <input type="text" name="centralNervousSystem" id="centralNervousSystem" value="<%=centralNervousSystem%>" size="100" class="auto"
 maxlength="999" validate="Central Nervous System,metachar,no"/>
<div class="clear"></div>


<label>Local Examination</label>
<input type="text" name="localExamination" id="localExamination" value="<%=localExamination%>" size="100" class="auto"
 maxlength="999" validate="Local Examination,metachar,no"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarksClinical" id="remarksClinical" value="<%=remarksClinical%>" size="100" class="auto" maxlength="999" validate="Clinical Remarks,metachar,no"/>
<div class="clear"></div>
<label>Referred to MH</label>
<input name="referredToMhClinical" id="referredToMhClinical" value="<%=referredToMhClinical%>" maxlength="99"/>
<%---
<select id="referredToMhClinical" name="referredToMhClinical" validate="Referred to MH,string,no">

<option value="0">Select</option>
<%if(masHospitalList.size()>0){
	for(MasHospital masHospital:masHospitalList){
		String selected="";
		if(referredToMhClinical==masHospital.getId()){
			selected="selected";
		}
 %>
<option value="<%=masHospital.getId()%>" <%=selected%>><%=masHospital.getHospitalName()%></option>
<%}
	}%></select> --%>

<label>Referred to OPD/Dept</label>
<select id="opdDeptClinical" name="opdDeptClinical" validate="OPD/Dept,string,no">
<option value="0">Select</option>
<%if(masDepartmentList.size()>0){
	for(MasDepartment masDepartment:masDepartmentList){
		String selected="";
		if(opdDeptClinical==masDepartment.getId()){
			selected="selected";
		}
 %>
<option value="<%=masDepartment.getId()%>" <%=selected%>><%=masDepartment.getDepartmentName()%></option>
<%}
	}%>
</select>
<div class="clear"></div>
</div>
</div>
<%
String medicalBoardStatus="";
boolean medicalBoardFlag=false;
if(medExamObj.getStatus()!=null){
	medicalBoardStatus=medExamObj.getStatus();
}
if(!medicalBoardStatus.equalsIgnoreCase("f")){
	medicalBoardFlag=true;
}
if(medicalBoardFlag){
%>
<div class="Clear paddingTop15"></div>
<div id="specialistOpinionForward" style="display: inline;"> 
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('MedicalBoardInitialMedExamJsp','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"
	onclick="openPopupForSpecialistOpinionForward('<%=visitId%>','<%=medExamId %>');" id="forwardSpecial"/>
<%---
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Enter Specialist Opinion"	onclick="openPopupForSpecialistOpinion('<%=visitId%>','<%=medExamId %>');" /> --%>
<label>Refer Specialist</label>
<input type="checkBox" name="referSpecial" id="referSpecial" onclick="onclickSpecial();"/>
<input type="hidden" value="" name="specialValue" id="specialValue"/><div class="clear"></div>
<input type="button" value="Upload Specialist Report" class="buttonBig2" onClick="javascript:fileUploadViewWindow('SPE');" id="buttonSpecial"/></div>
<% }else if(medExamObj.getSpecialistRefer() !=null && medExamObj.getSpecialistRefer().equalsIgnoreCase("y")){  %>
<div class="Clear paddingTop15"></div>
<div id="specialistOpinionForward" style="display: inline;"> 
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('MedicalBoardInitialMedExamJsp','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"
	onclick="openPopupForSpecialistOpinionForward('<%=visitId%>','<%=medExamId %>');" id="forwardSpecial"
	disabled="disabled"/>
<%---
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Enter Specialist Opinion"	onclick="openPopupForSpecialistOpinion('<%=visitId%>','<%=medExamId %>');" /> --%>
<label>Refer Specialist</label>
<input type="checkBox" name="referSpecial" id="referSpecial" onclick="onclickSpecial();" checked="checked"/>
<input type="hidden" value="y" name="specialValue" id="specialValue" /><div class="clear"></div>
<input type="button" value="Upload Specialist Report" class="buttonBig2" onClick="javascript:fileUploadViewWindow('SPE');" id="buttonSpecial"/></div>
<%} %>
<%--
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Clinical Summary"	onclick="openPopupForClinicalSummary();" />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Medical Board Details" onclick="openPopupForMedicalBoard()" />
 --%>
<div class="Clear paddingTop15"></div>
<%
if(!medicalBoardFlag){

 	String medCatNowRecommend="";
	String placeNextCat="";
	String dateNextBoard="";
	String opinionMedicalBoard="";
	String dissentNotes="";
	String medComposite="";
	String empRestrictions="";
	String instructions="";
	BigDecimal medboardDuration=new BigDecimal(0);
	if(medExamObj.getMedboardDuration()!=null){
		medboardDuration=medExamObj.getMedboardDuration();
	}
	if(medExamObj.getMedCatRec()!=null){
		medCatNowRecommend=medExamObj.getMedCatRec();
	}
	if(medExamObj.getPlaceNextCatBoard()!=null){
		placeNextCat=medExamObj.getPlaceNextCatBoard();
	}
	if(medExamObj.getNextBoardDate()!=null){
		dateNextBoard=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getNextBoardDate());
	}
	if(medExamObj.getOpinion()!=null){
		opinionMedicalBoard=medExamObj.getOpinion();
	}
	if(medExamObj.getMedInstructions()!=null){
		instructions=medExamObj.getMedInstructions();
	}
	if(medExamObj.getMedComposite()!=null){
		medComposite=""+medExamObj.getMedComposite();
	}
	if(medExamObj.getDissentNote()!=null){
		dissentNotes=medExamObj.getDissentNote();
	}
	if(medExamObj.getEmpabiltyRestric()!=null){
		empRestrictions=medExamObj.getEmpabiltyRestric();
	}
 %>
<div class="clear"></div>
<h4>Medical Board Details</h4>
<div class="clear"></div>
<%--
<input name="printSpecialistOpenion" type="button" value="Print Specialist Opinion" class="buttonBig2"/>
 --%><%---
<input type="button" value="Print Specialist Opinion" class="buttonBig2"
	onclick="submitForm('MedicalBoardInitialMedExamJsp','/hms/hms/medicalBoard?method=printSpecialistOpinionReport&medExamId=<%=medExamId %>&visitId=<%=visitId %>')"> --%>
<%if(medExamObj.getSpecialistRefer()!=null && medExamObj.getSpecialistRefer().equals("") && medExamObj.getSpecialistRefer().equals("n")){ %>	
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="View Specialist Opinion"	onClick="openPopupForSpecialistOpinionView();" />
<%} %> 
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<label >Med Cat Rec</label>
<select id="medCatNowRecommend"	name="medCatNowRecommend"	validate="Med Cat Rec,string,no" tabindex=1
onblur="setMedCatRec();">
	<option value="0">Select</option>
	<%
	int medicalCategoryRecomendedId=0;
	if(medExamObj.getMedicalCategoryRecomended()!=null)
	{
		medicalCategoryRecomendedId=medExamObj.getMedicalCategoryRecomended().getCategoryid();
	}
			for (Category category : categoryList) {
				String selected="";
				if(category.getCategoryid().equals(medicalCategoryRecomendedId))
					{
					selected="selected";
					}else{
						selected="";
					}
				%>
	<option value="<%=category.getCategoryid()%>" <%=selected%> ><%=category.getCategories()%> </option>
	<%}%>
</select>
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
 <input type="text" name="medCatPeriodRec" id="medCatPeriodRec" value="<%=medCatPeriod %>" maxlength="5" class="small"/>
 <select name="medCatDurationRec" id="medCatDurationRec" class="small">
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
 <%}else{%><input type="text" name="medCatPeriodRec" id="medCatPeriodRec" value="" maxlength="5" class="small"/>
 <select name="medCatDurationRec" id="medCatDurationRec" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%if(medExamObj.getShapeFactorRec() !=null){ %>
 <input type="text" name="shapeFactorRec" id="shapeFactorRec" value="<%=medExamObj.getShapeFactorRec() %>" maxlength="19" tabindex="1"validate="Shape Factor,metachar,no"/>
 <%}else{ %>
  <input type="text" name="shapeFactorRec" id="shapeFactorRec" value="" maxlength="19" tabindex="1" validate="Shape Factor,metachar,no"/>
 <%} %> 
<%-- 
<label>Duration</label>
<input tabindex="1" type="text" id="medboardDuration" name="medboardDuration"  class="autoArial" size="1" value="<%=medboardDuration%>" onkeyup="isNumber1(this)" validate="Duration,num,no" maxlength="1"/>
<label class="unit">Weeks</label>--%>
<%-- By Anshu..to do --%>
<%--<input tabindex="1" type="text" id="" name=""  class="auto" size="5" value="" />
<label class="unit">Months</label>
<input tabindex="1" type="text" id="" name=""  class="auto" size="5" value="" />
 --%>
<div class="clear"></div>
<label >Next Board</label> <label class="auto">Place</label>
<input type="text" name="placeNextCat" id="placeNextCat" maxlength="49" class="auto" size="50" value="<%=placeNextCat%>" validate="Place of Next Categorization Board,metachar,no"/>
<label class="unit">Date</label>
<input tabindex="1" type="text"	name="dateNextBoard" id="dateNextBoard" maxlength="10" value="<%=dateNextBoard %>"  class="auto" size="16"
	onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.dateNextBoard,event);" />
<div class="clear"></div>

<label >Opinion of Medical Board</label>
<input type="text" id="opinionMedicalBoard" name="opinionMedicalBoard" value="<%=opinionMedicalBoard%>" maxlength="999" tabindex="1" class="auto" size="100" validate="Opinion of Medical Board,metachar,no"/>
<div class="clear"></div>
<label >Dissent Notes</label>
<input type="text" id="dissentNotes" name="dissentNotes"  maxlength="999" value="<%=dissentNotes%>" tabindex="1" class="auto" size="100" validate="Dissent Notes,metachar,no"/>

<div class="clear"></div>
 
<label>Composite%</label>
<input type="text" name="medComposite" id="medComposite" value="<%=medComposite%>" class="autoArial" size="3" validate="Composite,string,no" maxlength="4"/><%--onkeyup="isNumber1(this)" validate="Composite,num,no"/> --%>
<label>Employability Restrictions</label>
<input type="text" name="empRestrictions" id="empRestrictions" value="<%=empRestrictions%>" maxlength="999" validate="Employability Restrictions,metachar,no" class="autoArial" size="55"  />
<div class="clear"></div>
<label>Instructions</label>
<input type="text" name="instructions" id="instructions" value="<%=instructions%>" class="autoArial" size="98" maxlength="99" validate="Instructions,metachar,no"/>

<div class="clear"></div>
<label>Signature  of Individual</label>
<input tabindex="1" type="text" name="digitalIndividuals" id="digitalIndividuals" maxlength="30" disabled="disabled"/>

<label>Date</label>
<input tabindex="1" type="text"	name="medDate" id="medDate" maxlength="10"  class="calDate" value="<%=date%>"
	onKeyUp="mask(this.value,this,'2,5','/');" validate="Date,date,no" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.medDate,event);" />
<div class="clear"></div>
<label>Member 1</label>
<select name="member1" id="member1"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medMember1=0;
	String medMemberStr1="";
	//if(medExamObj.getMedDetailMember1()!=null){
	//	medMember1=medExamObj.getMedDetailMember1().getId();
	//}
			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
			
					//if(medMember1==masEmployee.getId()){
					//	medMemberStr1="selected";
					//}
					if(medExamObj.getMedDetailMember1()!=null){
					if((medExamObj.getMedDetailMember1().getId()).equals(masEmployee.getId())){	
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+ employeeName%></option>
	<%				
			}else { %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+ employeeName%></option>
	<%} }else{ %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+ employeeName%></option>
	<%}
		   }
	      }
		%>

</select>


<label>Member2</label>
<select name="member2" id="member2"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medMember2=0;
	if(medExamObj.getMedDetailMember2()!=null){
		medMember2=medExamObj.getMedDetailMember2().getId();
	}
			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
					String medMemberStr2="";
					if(medMember2==masEmployee.getId()){
						medMemberStr2="selected";
					}
			%>
	<option value="<%=masEmployee.getId()%>" <%=medMemberStr2 %>><%=masEmployee.getRank().getRankName()+" "+employeeName%></option>
	<%
		   }
	      }

		%>

</select>
<label>President</label>
<select name="president" id="president"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medPresedent=0;
	if(medExamObj.getMedDetailPresident()!=null){
		medPresedent=medExamObj.getMedDetailPresident().getId();
	}

			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
					String selectedPres="";
					if(medPresedent==masEmployee.getId()){
						selectedPres="selected";
					}
			%>
	<option value="<%=masEmployee.getId()%>" <%=selectedPres%> ><%=masEmployee.getRank().getRankName()+" "+employeeName%></option>
	<%
		   }
	      }	%>

</select>
<div class="clear"></div>
<label>Remarks</label>
<% if(medExamObj.getMedRemarks()!=null){%>
  <input tabindex="1" type="text" name="medRemarks" class="autoArial" size="98" maxlength="999"  value="<%=medExamObj.getMedRemarks() %>" id="medRemark"/>
 <% }else{%>
 <input tabindex="1" type="text" name="medRemarks" class="autoArial" size="98" maxlength="999" id="medRemark" />
 <% }%>
 <input size="157" class="transparent" />


</div>
</div>
<%
}
%>
<div class="clear"></div>
<div class="division"></div>
<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="button" value="UPDATE"	onclick="submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=updateMedicalExamEntry&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<%-- <input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">--%>
<% }%>
<%--<input tabindex="1" name="Button" type="button" class="button" value="Update"	onclick="" />
<input tabindex="1" name="Button" type="button" class="button" value="VALIDATE"	onclick="" />--%>
<%
if(!medicalBoardFlag || medicalBoardStatus.equalsIgnoreCase("v") ){
%>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onclick="checkPresidentValidate();" />
<%} %>
<input tabindex="1" name="Button" type="button" class="button" value="REJECT" onClick="if(checkRemarks()){submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=rejectMedicalBoardEntry&rejectStatus=fr');}" />
<input tabindex="1" name=Reset type=hidden value=Reset class="button" id=reset accessKey=r onclick="resetCheck();" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('MedicalBoardInitialMedExamJsp','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input name="Send" type="button"  class="button" value="Upload" onclick="javascript:fileUploadViewWindow('ALL');" />
<input tabindex="1" name="Button"	type="button" class="buttonBig2" value="Proceed to Form 2A"	 id="form2AId"
onClick="initiateVisistFor2A();" />
<%-- <input type="button" name="report" class="button" id="report"	onclick="submitFormForMBProceedingInitialAFMSFReport();" value="Print AFMSF -15"	accesskey="a" />--%>
<%--
<input tabindex="1" name="Button" type="button" class="button" value="Upload/View"	onclick="fileUploadViewWindow('ALL');" />
 --%>
<!--  <input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Appointment name=Reset>-->
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
<input type="hidden"  name="MissTeeth" id="MissTeeth123" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth123" value=""/>
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
<!--Bottom labels starts--> <!--main content placeholder ends here--> 
<script	type="text/javascript">

function checkRemarks()
{
		var remarks=document.getElementById('medRemark').value;
		if(remarks=='')
		{
		  alert("Please Enter the Remarks");
		   return false;
		}
		return true;
}
function checkReject()
	{
		var medRemarks=document.getElementById('medRemark').value;
		
		if(medRemarks!=""){
			submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=rejectMedicalBoardEntry&rejectStatus=fr');
		}else{
			alert("Please Enter Medical Board Details Remark.");
			return false;
			}
	}
	function checkPresidentValidate()
	{
		var president=document.getElementById("president").value;
		if(president==<%=loginEmpId%>){
			submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=validateMedExam');
		}else{
			alert("President can login and validate only.");
			return false;
			}
	}
	function checkPresident()
	{
		var president=document.getElementById("president").value;
		if(president==<%=loginEmpId%>){
			submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=validateMedExam');
		}else{
			alert("President can login and validate only.");
			return false;
			}
	}
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
function FileUploadWindow()
{
  var folderName='hearing';
	var url="/hms/hms/medicalExam?method=displayFileUpload";
	newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");

}
function openPopupForImmunization(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','windowRef','width=1000,height=400,scrollbars = yes');
}

function openPopupForAllergies(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForAllergies&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','allergy','width=1000,height=400,scrollbars = yes');
}
/*
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
*/
function FileUploadWindowGynaecology()
{
	var folderName='gynaecology';
		var url="/hms/hms/medicalExam?method=displayFileUpload";

		newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");

}
function fileUploadViewWindow(flag)
{
	//flag=HEA Means-->Hearing
	//flag=GYN Means-->GYNAECOLOGY EXAM
	//flag=ALL Means-->ALL Type
//	<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>
		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;

		newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");

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

				submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=showGridForInvestigation&flag=Board','gridview');

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
	
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});

	  
	  var cellRight11 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'checkbox';
	  e11.name = 'investigationReferToMH' + iteration;
	  e11.id = 'investigationReferToMH' + iteration;
	  e11.value='n';
	  e11.className = 'radioAuto';
	  e11.setAttribute('tabindex','1');
	  e11.onclick = function(){checkForInvestigationMH(iteration)};
	  cellRight11.appendChild(e11);

	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '65';
	  e1.name = 'Result' + iteration;
	  e1.id = 'Result' + iteration;
	  e1.setAttribute('readonly','readonly');
	  e1.setAttribute('maxlength', 20);
	  e1.setAttribute('tabindex','1');
      cellRight1.appendChild(e1);

      var sel = document.createElement('input');
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
	 // e30.style.display='inline';
	  e30.onclick = function(){fileUploadWindowInvestigation(iteration);};
	  cellRight30.appendChild(e30);

	  var cellRight1 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.onclick = function(){addRowForInvestigation();};
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.onclick = function(){removeRowForInvestigation(this);};
	  cellRight2.appendChild(e4);


	}
 function addRowForImmunization()
 {

	  var tbl = document.getElementById('immunizationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenImmunizationValue');
	  hdb.value=iteration

	 var cellRight00 = row.insertCell(0);
	 var e00 = document.createElement('input');
 	 e00.type = 'text';
 	 e00.name = 'vaccine' + iteration;
 	 e00.id = 'vaccine' + iteration;
 	 e00.size = '40';
 	 e00.setAttribute('maxlength', 35);
 	 e00.setAttribute('tabindex','1');
     cellRight00.appendChild(e00);
     new Ajax.Autocompleter('vaccine'+iteration,'ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=vaccine'+iteration});

      var cellRight01 = row.insertCell(1);
	  var e01 = document.createElement('input');
 	  e01.type = 'text';
 	  e01.size = '5';
	  e01.name = 'dose' + iteration;
	  e01.id = 'dose' + iteration;

      e01.setAttribute('maxlength', 10);
	  e01.setAttribute('tabindex','1');
      cellRight01.appendChild(e01);

      var cellRight02 = row.insertCell(2);
	  var e02 = document.createElement('input');
 	  e02.type = 'text';
	  e02.name = 'route' + iteration;
	  e02.id = 'route' + iteration;
      e02.setAttribute('maxlength', 10);
	  e02.setAttribute('tabindex','1');
      cellRight02.appendChild(e02);

     var cellRight1 = row.insertCell(3);
	 var e1 = document.createElement('input');
	 e1.type = 'text';
	 e1.size = '12';
	 e1.name = 'giveon' + iteration;
	 e1.id = 'giveon' + iteration;
     e1.className = 'date';
     e1.setAttribute('maxlength', 10);
	 e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);

      var cellRight2 = row.insertCell(4);
	  var e2 = document.createElement('img');
	  e2.src = '/hms/jsp/images/cal.gif';
	  // e3.style.display ='none';
	  e2.id = 'calId'+iteration;
	  e2.onclick = function(event){
	  setdate('',document.getElementById('giveon'+iteration),event) };
	  cellRight2.appendChild(e2);

      var cellRight3 = row.insertCell(5);
	  var e3 = document.createElement('input');
 	  e3.type = 'text';
	  e3.name = 'batchNo' + iteration;
	  e3.id = 'batchNo' + iteration;
      e3.size = '20';
      e3.setAttribute('maxlength', 10);
	  e3.setAttribute('tabindex','1');
      cellRight3.appendChild(e3);

      var cellRight4 = row.insertCell(6);
 	  var e4 = document.createElement('input');
 	  e4.type = 'text';
 	  e4.size = '12';
 	  e4.name = 'dom' + iteration;
 	  e4.id = 'dom' + iteration;
      e4.className = 'date';
      e4.setAttribute('maxlength', 10);
 	  e4.setAttribute('tabindex','1');
      cellRight4.appendChild(e4);

      var cellRight5 = row.insertCell(7);
 	  var e41 = document.createElement('img');
 	  e41.src = '/hms/jsp/images/cal.gif';
 	  // e3.style.display ='none';
 	  e41.id = 'calId'+iteration;
 	  e41.onclick = function(event){
 	  setdate('',document.getElementById('dom'+iteration),event) };
 	  cellRight5.appendChild(e41);


	  var cellRight6 = row.insertCell(8);
		 var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'entryDate' + iteration;
		  e6.id = 'entryDate' + iteration;
	      //e6.className = 'date';
	      e6.size = '12';
	     e6.setAttribute('maxlength', 10);
		  e6.setAttribute('tabindex','1');
	     cellRight6.appendChild(e6);

	    var cellRight06 = row.insertCell(9);
		  var e61 = document.createElement('img');
		  e61.src = '/hms/jsp/images/cal.gif';
		  // e3.style.display ='none';
		  e61.id = 'calId'+iteration;
		  e61.onclick = function(event){
		  setdate('',document.getElementById('entryDate'+iteration),event) };
		  cellRight06.appendChild(e61);

		var cellRight7 = row.insertCell(10);
		var e7 = document.createElement('input');
		e7.type = 'button';
		e7.className = 'buttonAdd';
		e7.name='Button';
		e7.onclick=function(){addRowForImmunization();};
		cellRight7.appendChild(e7);

	    var cellRight8 = row.insertCell(11);
		var e8 = document.createElement('input');
		e8.type = 'button';
		e8.className = 'buttonDel';
		e8.name='delete';
		e8.onclick=function(){removeRowForImmunization();};
		cellRight8.appendChild(e8);


	}
 function removeRowForImmunization()
	{
	  var tbl = document.getElementById('immunizationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('immunizationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenImmunizationValue');
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
 function removeRowForInvestigation(obj)
	{
	  var tbl = document.getElementById('investigationGrid');
	  document.getElementById('investigationDataStatus').value="yes";
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
		  var i=obj.parentNode.parentNode.rowIndex;
		  tbl.deleteRow(i);
	  	//tbl.deleteRow(lastRow - 1);
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

	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
	newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");
   }else{
     alert("This is Patient's First Visit. ")
   }
}

 function showCreateInvestigationTemplate(){

     //document.getElementById("investigationImportButton1").style.display='inline'
   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
    newwindow=window.open(url,'investigation',"height=800,width=1002,status=1,top=0,left=0");


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
 function checkForChargeCode(val,inc,chargeCodeTdDiv,source){

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
						if(source=="child")
						{

							newwindow.close();
						}
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
	//var dstr="";
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
alert(dentalValue);
	 var mySplitResult = dentalValue.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 document.getElementById(mySplitResult[i]).checked=true;
		 messingTeeth(mySplitResult[i]);
	 }

	}

 function openTemplateScreen(index){
 		var resultId = document.getElementById('resultIdTemplate'+index).value;
 	//	submitForm('MedicalBoardInitialMedExamJsp','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
       	var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
	    newwindow=window.open(url,'ar',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");

 }
 function messingTeeth(mm)
 {

 	var name=document.getElementById(mm).name;

 	var mval=document.getElementById('MissTeeth123').value;
 	var uval=document.getElementById('UnserTeeth123').value;
 	if(name[0]=='m')
 	{
 		mval=mval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('MissTeeth123').value=mval;
 	}
 	if(name[0]=='u')
 	{
 		uval=uval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('UnserTeeth123').value=uval;
 	}
 }
 function openPopupForClinicalSummary(){
	var url="/hms/hms/medicalBoard?method=showClinicalSummaryJsp";
   newwindow=window.open(url,'clinicalSummary','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
 
 function openPopupForSpecialistOpinionForward(visitId,medExamId){
		document.getElementById('specialistOpinionForward').style.display='none';
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
	      	    var item = items.childNodes[loop];
		        var msg  = item.getElementsByTagName("msg")[0];
				//if(msg.childNodes[0]!='undefined'){
					alert(msg.childNodes[0].nodeValue);
			//	}

	      	}
	      }
	    }
	    var url="/hms/hms/medicalBoard?method=forwardMedExamSpecialOpinion&visitId="+visitId+"&flagForward=s&medExamId="+medExamId;
	    document.getElementById('referSpecial').disabled = true;
	    document.getElementById('buttonSpecial').disabled = true;   
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	//   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
 function openPopupForSpecialistOpinion(visitId,medExamId){
		var url="/hms/hms/medicalBoard?method=showSpecialistOpinionJsp&visitId="+visitId+"&SecialFlag=y&medExamId="+medExamId;
	   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}

 function openPopupForSpecialistOpinionView()
 {
 	var url="/hms/hms/medicalBoard?method=showViewSpecialistOpinionJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
 	newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
 }
 function openPopupForMedicalBoard(){
		var url="/hms/hms/medicalBoard?method=showMedicalBoardJsp";
	   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
 function submitFormForMBProceedingInitialAFMSFReport(){
	 var url='/hms/hms/medicalBoard?method=generateProceedingInitialAFMSFReport&visit_id=<%=visit.getId()%>';
	 newwindow=window.open(url,'ar',"left=2,top=100,height=800,width=1002,status=1,scrollbars=1,resizable=1");

	}
 function addRow(){
	  //name="prevDisabilities" id="prevDisabilities"
 //name="pastDisabilities" id="pastDisabilities"
 //name="variationReason" id="variationReason"
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
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
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='serviceid'+iteration;
	  sel.id='serviceid'+iteration
	  sel.size = '2';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);
	  cellRight0.appendChild(e0);
/*
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'principal' + iteration;
	  e1.id = 'principal' + iteration;
	  e1.setAttribute('maxlength', 10);
    e1.size = '20';
	  e1.setAttribute('tabindex','1');
    cellRight1.appendChild(e1);
*/

    var cellRight1 = row.insertCell(1);
   var e1 = document.createElement('input');
   e1.type = 'text';
   e1.name = 'principal' + iteration;
   e1.id = 'principal' + iteration;
   e1.setAttribute('maxlength', 22);
   e1.size = '22';
   e1.setAttribute('tabindex','1');
   cellRight1.appendChild(e1);

   var newdiv1 = document.createElement('div');
   newdiv1.setAttribute('id', 'ac2updatex2'+iteration);
   newdiv1.setAttribute('class', 'autocomplete');
   newdiv1.style.display = 'none';
   cellRight1.appendChild(newdiv1);
   cellRight1.appendChild(e1);
//   new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=principal'+iteration});
  new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=principal'+iteration});
	  
/*   var cellRight5 = row.insertCell(2);
	 var e5 = document.createElement('input');
	 e5.type = 'text';
	 e5.name = 'origindate' + iteration;
	 e5.id = 'origindate' + iteration;
    e5.size = '11';
    e5.setAttribute('maxlength', 10);
	 e5.setAttribute('tabindex','1');
    cellRight5.appendChild(e5);

    var cellRight6 = row.insertCell(3);
	 var e6 = document.createElement('img');
    e6.src = '/hms/jsp/images/cal.gif';
    e6.id = 'calId'+iteration;
    e6.onclick = function(event){
    setdate('',document.getElementById('origindate'+iteration),event) };
    cellRight6.appendChild(e6);

var cellRight7 = row.insertCell(4);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name = 'place' + iteration;
	  e7.id = 'place' + iteration;
    e7.size = '20';
    e7.setAttribute('maxlength', 10);
	  e7.setAttribute('tabindex','1');
    cellRight7.appendChild(e7);

    var cellRight8 = row.insertCell(5);
	  var e8 = document.createElement('Select');
      e8.name='presentMedicalCategory'+iteration;
	  e8.id='presentMedicalCategory'+iteration;
	  e8.setAttribute('tabindex','1');
	  e8.className = 'medium';
	  e8.options[0] = new Option('Select', '0');
	   for(var i = 0;i<categoryMedArray.length;i++ ){
	      e8.options[i+1] = new Option(categoryMedArray[i][1],categoryMedArray[i][0]);
	      }
	  cellRight8.appendChild(e8);

   var cellRight9 = row.insertCell(6);
	var e9 = document.createElement('input');
	e9.type = 'text';
	e9.name = 'medicalcatdate' + iteration;
	e9.id = 'medicalcatdate' + iteration;
    e9.size = '11';
    e9.setAttribute('maxlength', 10);
	e9.setAttribute('tabindex','1');
    cellRight9.appendChild(e9);

    var cellRight10 = row.insertCell(7);
    var e10 = document.createElement('img');
    e10.src = '/hms/jsp/images/cal.gif';
    e10.id = 'calId'+iteration;
    e10.onclick = function(event){
    setdate('',document.getElementById('medicalcatdate'+iteration),event) };
    cellRight10.appendChild(e10);

    var cellRight11 = row.insertCell(8);
	 var e11 = document.createElement('input');
	 e11.type = 'text';
	 e11.name = 'nextcatdate' + iteration;
	 e11.id = 'nextcatdate' + iteration;
	 e11.size = '11';
	 e11.setAttribute('maxlength', 10);
	 e11.setAttribute('tabindex','1');
    cellRight11.appendChild(e11);*/
/* var cellRight12 = row.insertCell(9);
	 var e12 = document.createElement('img');
	 e12.src = '/hms/jsp/images/cal.gif';
	 e12.className = 'calender';
    e12.id = 'calId'+iteration;
    e12.onclick = function(event){
    setdate('',document.getElementById('nextcatdate'+iteration),event) };
    cellRight12.appendChild(e12); */

  var cellRight2 = row.insertCell(2);
  var e2 = document.createElement('Select');

  e2.name='categoryForDisable'+iteration;
  e2.id='categoryForDisable'+iteration;
  e2.setAttribute('tabindex','1');
  e2.className='medium';
  e2.options[0] = new Option('Select', '0');
	for(var i = 0;i<categoryArray.length;i++ ){
		 e2.options[i+1] = new Option(categoryArray[i][1],categoryArray[i][0]);
  }
 e2.value='';
  cellRight2.appendChild(e2);

  var cellRight3 = row.insertCell(3);
  var e3 = document.createElement('input');
  e3.type = 'text';
  e3.name = 'medCatPeriod' + iteration;
  e3.id = 'medCatPeriod' + iteration;
  e3.size = '5';
  e3.setAttribute('maxlength', 5);
  e3.setAttribute('tabindex','1');
  
  var e66 = document.createElement('Select');
  e66.name = 'medCatDuration' + iteration;
  e66.id = 'medCatDuration' + iteration;
  e66.className='small';
  e66.setAttribute('tabindex','1');
  e66.options[0] = new Option('Months', 'Months');
  e66.options[1] = new Option('Weeks', 'Weeks');
  e66.options[2] = new Option('Days', 'Days');
  cellRight3.appendChild(e3);
  cellRight3.appendChild(e66);
  
    var cellRight4 = row.insertCell(4);
    var e4 = document.createElement('select');
 //   e13.type = 'select';
    e4.name='aggravation'+iteration;
    e4.options[0] = new Option('select', '');
    e4.options[1] = new Option('Attributability', 'Attributability');
    e4.options[2] = new Option('Aggravation', 'Aggravation');
    e4.options[3] = new Option('Nil', 'Nil');
    cellRight4.appendChild(e4);

       var cellRight5 = row.insertCell(5);
		var e5 = document.createElement('input');
		e5.type = 'text';
		e5.name = 'prevDisabilities' + iteration;
		e5.id = 'prevDisabilities' + iteration;
		e5.setAttribute('maxlength', 3);
		//e5.size = '3';
		e5.setAttribute('tabindex','1');
		cellRight5.appendChild(e5);

	  	 var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'pastDisabilities' + iteration;
	  e6.id = 'pastDisabilities' + iteration;
	  e6.setAttribute('maxlength', 3);
	  //e6.size = '3';
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name = 'variationReason' + iteration;
	  e7.id = 'variationReason' + iteration;
	  e7.setAttribute('maxlength', 49);
	  //e4.size = '30';
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	 /* var cellRight14 = row.insertCell(14);
      var e14 = document.createElement('input');
      e14.type = 'text';
      e14.name = 'remarks'+iteration;
      e14.setAttribute('maxlength','50');
      e14.setAttribute('tabindex','1');
      cellRight14.appendChild(e14);*/

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('Select');
	  e8.name='compositeCategory'+iteration;
	  e8.id='compositeCategory'+iteration;
	  e8.setAttribute('tabindex','1');
	  e8.className='medium';
	  e8.options[0] = new Option('Select', '0');
		for(var i = 0;i<categoryCompArray.length;i++ ){
		 e8.options[i+1] = new Option(categoryCompArray[i][1],categoryCompArray[i][0]);
	  }
		e8.value='';
	  cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name = 'medCatPeriodComp' + iteration;
	  e9.id = 'medCatPeriodComp' + iteration;
	  e9.size = '4';
	  e9.setAttribute('maxlength', 5);
	  e9.setAttribute('tabindex','1');
	  
	  var e661 = document.createElement('Select');
	  e661.name = 'medCatDurationComp' + iteration;
	  e661.id = 'medCatDurationComp' + iteration;
	  e661.className='small';
	  e661.setAttribute('tabindex','1');
	  e661.options[0] = new Option('Months', 'Months');
	  e661.options[1] = new Option('Weeks', 'Weeks');
	  e661.options[2] = new Option('Days', 'Days');
	  cellRight9.appendChild(e9);
	  cellRight9.appendChild(e661);

      
      var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonAdd';
	  e10.name='remarks'+iteration;
	  e10.onclick = function(){addRow();};
	  e10.setAttribute('tabindex','1');
	  cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonDel';
	  e11.name='remarks'+iteration;
	  e11.onclick= function(){removeRowIndividual("grid","hdb",this);};
	  e11.setAttribute('tabindex','1');
	  cellRight11.appendChild(e11);

	}
 function addRowDisability(){

	  var tbl = document.getElementById('gridDisability');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb2');
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'slNo' + iteration;
	  e0.id = 'slNo' + iteration;
	  e0.setAttribute('maxlength', 3);
	  e0.value=hdb.value;
      e0.size = '2';
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'medBoardDisabilitiy' + iteration;
	  e1.id = 'medBoardDisabilitiy' + iteration;
	  e1.setAttribute('maxlength', 30);
  	  e1.size = '20';
	  e1.setAttribute('tabindex','1');
   	  cellRight1.appendChild(e1);


   var cellRight2 = row.insertCell(2);
	 var e2 = document.createElement('input');
	 e2.type = 'text';
	 e2.name = 'prevDisabilities' + iteration;
	 e2.id = 'prevDisabilities' + iteration;
   e2.className = 'auto';
   e2.size = '15';
   e2.setAttribute('maxlength', 10);
	 e2.setAttribute('tabindex','1');
   cellRight2.appendChild(e2);

   var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'pastDisabilities' + iteration;
	  e3.id = 'pastDisabilities' + iteration;
	  e3.className = 'auto';
	  e3.size = '15';
	  e3.setAttribute('maxlength', 10);
	  e3.setAttribute('tabindex','1');
   		cellRight3.appendChild(e3);

   var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'variationReason' + iteration;
	  e4.id = 'variationReason' + iteration;
	  e4.className = 'auto';
	  e4.setAttribute('maxlength', 50);
	  e4.size = '15';
	  e4.setAttribute('tabindex','1');
   	  cellRight4.appendChild(e4);

   	 var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='Button'+iteration;
	  e5.onclick = function(){addRowDisability();};
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='delete'+iteration;
	  e6.onclick = function(){removeRowIndividual("gridDisability","hdb2",this);};
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);

	}
 function removeRowIndividual(idName,countId,obj)
 {
   var tbl = document.getElementById(idName);
   var lastRow = tbl.rows.length;
   if (lastRow > 2){
   //	tbl.deleteRow(lastRow - 1);
     var i=obj.parentNode.parentNode.rowIndex;
     tbl.deleteRow(i);
   }
 }
 function fileUploadWindowInvestigation(rowVal)
 {
	 var hinNo='<%=visit.getHin().getHinNo()%>';
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
  	if(validateMetaCharacters(hinNo)){
  		var url="/hms/hms/medicalBoard?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo="+hinNo+"&invest_id="+invest_id+"&masExamId=<%=medExamId%>";
  	}	
  		newwindow=window.open(url,'name',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");
  	}
 }
 function submitForInvestigationPrintOut()
 {
 	var orderNo=document.getElementById('dgOrderhdId').value;
 	var flag="MO";
 	var hinId= document.getElementById('hinId').value;
 	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
 		submitFormForButton('MedicalBoardInitialMedExamJsp','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
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
 function setMedCatRec()
 {
	 var obj=document.getElementById('medCatNowRecommend');
 	if(obj !=null && obj !=""){
 		var title=obj.options[obj.selectedIndex].text;
 		document.getElementById('medcatrec').value=title;
 	}
 }
 
 function onclickSpecial(){
	 if(document.getElementById('referSpecial').checked==true){
		 document.getElementById('forwardSpecial').disabled = true;
		 document.getElementById('specialValue').value='y';
		 
	 }else{
		 document.getElementById('forwardSpecial').disabled = false;
		 document.getElementById('specialValue').value='n';
	 }
 }

 function initiateVisistFor2A(){
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
	      	    var item = items.childNodes[loop];
		        var msg  = item.getElementsByTagName("msg")[0];
				//if(msg.childNodes[0]!='undefined'){
					alert(msg.childNodes[0].nodeValue);
			//	}

	      	}
	      }
	    }
	    var url="/hms/hms/medicalBoard?method=initiateVisistFor2A&medExamId=<%=medExamId%>";
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	//   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	    
	    document.getElementById('form2AId').disabled = true;
	}
 function validateDuration(val, fieldId){
		if(val != "" || val == '0'){
			if(!validateInteger(val)){
				alert("Period should be an integer value.");
				document.getElementById(fieldId).value = "";
				document.getElementById(fieldId).focus();
				return false;
			}
		}else if(val == "" ){
			alert("Period  should be geater than 0.");
			document.getElementById(fieldId).value = "";
			document.getElementById(fieldId).focus();
			return false;
		}
		return true;
	}

 function checkDentalReferToMH()
 {
 		if(document.getElementById("dentalReferId").checked==true)
 		{
 			document.getElementById('dentalDivId').style.display='inline';
 		}else{
 			document.getElementById('dentalDivId').style.display='none';
 		}
 }
</script></form>
</body>
<script type="text/javascript">

coolDental();
</script>