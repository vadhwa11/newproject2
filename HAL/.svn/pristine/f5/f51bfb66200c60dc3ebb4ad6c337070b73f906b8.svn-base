

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<script type="text/javascript" language="javascript">
function addMonths()
{
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
      v.setMonth(v.getMonth() + 9);
       v.setDate(v.getDate() + 7);
      var curr_date = v.getDate();
      
      var curr_month = v.getMonth();
      
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = curr_month+1;
       			mth = "0"+mth;
           			
       		}
       		else
       		{
       			mth = curr_month+1;
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
	else
	{
	  document.getElementById('eddId').value="";
	}
}
function setFocusLmp()
{
	  document.gravidagramGestationalDiabitiesOne.<%=LMP%>.focus();
}
function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP")
	  return false;
	}
	else
	{
	return true;
	}
}	

</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<OpdPatientDetails> fwcPatientDataList = new ArrayList<OpdPatientDetails>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>(); 
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();	
	if(map.get("fwcPatientDataList") != null){
		fwcPatientDataList=(List)map.get("fwcPatientDataList");
	}
	if(map.get("fwcOpdDetailHistoryList") != null){
		fwcOpdDetailHistoryList=(List)map.get("fwcOpdDetailHistoryList");
	}
	System.out.println("fwcOpdDetailList---jsp->"+fwcPatientDataList.size());
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
	}
	if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
	}
	if(map.get("disposalList") != null){
		disposalList=(List)map.get("disposalList");
	}
	if(map.get("patientFamilyHistoryList") != null){
		patientFamilyHistoryList=(List)map.get("patientFamilyHistoryList");
	}
	

	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String patientName="";
	Patient patient = new Patient();
	String servicePersionName="";
	OpdPatientDetails opd = new OpdPatientDetails();
	if(fwcPatientDataList.size()>0){
		opd=(OpdPatientDetails)fwcPatientDataList.get(0);
	 patient = (Patient)opd.getVisit().getHin();
	if(patient.getPFirstName()!= null){
	patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
	patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
	patientName=patientName+" "+patient.getPLastName();
	}
	if(patient.getSFirstName()!= null){
	 servicePersionName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSLastName();
	}



%>
<!--main content placeholder starts here-->
<form name="antenatalCard" action="" method="post">
<script type="text/javascript">
	   var icdArray=new Array();

	</script>
<div class="titleBg">
<h2>ANTENATAL CARD</h2>
</div>

<div class="clear"></div>

<h4>PATIENT DETAILS</h4>
<div class="clear"></div>
<div class="Block">

<label>Service No.</label>
 
<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>
 
<label>Patient Name</label> 
 <label class="value"><%=patientName %></label>
<label>Relation</label>
 
<label class="value"><%=patient.getRelation()!=null ?patient.getRelation().getRelationName(): ""  %></label>
 

<div class="clear"></div>
<label>Rank</label>

<label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>


<label>Name</label> 
 <label class="value"><%=servicePersionName %></label>


<label>Trade/Branch</label>
 
<label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<div class="clear"></div>
<label>Unit</label>
 
<label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>


<label>Age</label> 

<label class="value"><%=patient.getAge()!= null?patient.getAge():"" %></label> 


<input type="hidden" value="37 Years" id="ageId" name="ageId">

 <label>Gender</label>
 
<label class="value"><%=patient.getSex()!= null?patient.getSex().getAdministrativeSexName():"" %></label>
<input type="hidden" value="2" id="genderId" name="genderId">


<div class="clear"></div>

<label>Marital Status</label> 

<label class="value"><%=patient.getMaritalStatus()!= null?patient.getMaritalStatus().getMaritalStatusName():"" %></label> 
 

<label>Blood Group</label>

<label class="value"><%=patient.getBloodGroup()!= null?patient.getBloodGroup().getBloodGroupName():"" %></label> 

<label>Blood Group(Spouse)</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

 <label>Allergy</label>
<%if(opd.getVisit().getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=opd.getVisit().getHin().getDrugAllergies() %>" maxlength="91" id="allergies" size="92"  />
<%}else{ %>
<label class="value">&nbsp;</label><%} %>



<label>Risk Factors</label>
<%
	OpdPatientHistory oph1=new OpdPatientHistory();
	if(fwcOpdDetailHistoryList.size()>0)
	{
		oph1=(OpdPatientHistory)fwcOpdDetailHistoryList.get(0);
	


if(oph1.getRiskFactor()!=null){ %>

<label class="value"><%=oph1.getRiskFactor()%></label>
<%
}} %> 

<div class="clear"></div>
<input type="hidden" name="visitId" value="<%=opd.getVisit().getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
<input name="departmentId"	type="hidden" value="<%=oph1.getDepartment().getId()%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=opd.getVisit().getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="hidden" value="<%=opd.getVisit().getHin().getServiceNo()%>" />
<input name="deptId" type="hidden" value="<%=oph1.getDepartment().getId()%>" />
<input name="<%=HIN_NO%>" type="hidden"	value="<%=opd.getVisit().getHin().getHinNo()%>" />
<input name="<%=SERVICE_TYPE_NAME%>" type="hidden"	value="<%=opd.getVisit().getHin().getServiceType().getServiceTypeName()%>" />

 
<div class="clear"></div>
</div>

<div class="Block">


<label>LMP</label> 

<%if(opd.getLmpDate()!=null){ %>
<label class="value"><%=opd.getLmpDate() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<label>EDD</label>
<%if(opd.getEddDate()!=null){ %>
<label class="value"><%=opd.getEddDate() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %> 
<label>POG</label>
<%if(opd.getPog()!=null){ %>
<label class="value"><%=opd.getPog() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %> 
<div class="Clear"></div>


</div>

<div class="clear"></div>
<div class="Block">


<label>Complaints<span>*</span></label>
<%
	OpdPatientHistory oph=new OpdPatientHistory();
	if(fwcOpdDetailHistoryList.size()>0)
	{
		oph=(OpdPatientHistory)fwcOpdDetailHistoryList.get(0);
	


if(oph.getPresentComplain()!=null){ %>

<label class="value"><%=oph.getPresentComplain()%></label>
<%
}} %>
</div>
<div class="clear"></div>
<h4>HISTORY</h4>
<div class="Block">

<label >Date of Marriage </label>
<%if(patient.getSrMarriageDate()!=null){ %> 
<input	tabindex="1" name="dateofMarriage" maxlength="10" readonly="readonly" value="<%=patient.getSrMarriageDate()!= null?HMSUtil.convertDateToStringWithoutTime(patient.getSrMarriageDate()):"" %>" />
 <%}else{ %>
 <input	tabindex="1" name="dateofMarriage" maxlength="10" readonly="readonly" value="" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',antenatalCard.dateofMarriage,event);" />
<%} %>

<div class="clear"></div>
<label >No. of Days</label>

<%if(opd.getMNoOfDays()!=null){ %>
<label class="valueAuto"><%=opd.getMNoOfDays() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %> 
<label >Duration of Cycle</label>
<%if(opd.getDurationOfCycle()!=null){ %>
<label class="valueAuto"><%=opd.getDurationOfCycle() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %> 
<label>Flow</label>
<%if(opd.getMFlow()!=null){ %>
<label class="value"><%=opd.getMFlow() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %> 
<div class="clear"></div>
<label>Pain</label>
<%if(opd.getMPain()!=null){ %>
<label class="value"><%=opd.getMPain() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<label>Regularity</label>
<%if(opd.getMRegularity()!=null){ %>
<label class="value"><%=opd.getMRegularity() %></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<div class="clear"></div>


<label>Relevant Family History</label><!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<%if(patient.getFamilyHistory()!=null){ %>
<label class="value"><%=patient.getFamilyHistory()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<div id="otherFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<%if(patient.getOtherFamilyHistory()!=null){ %>
<label class="value"><%=patient.getOtherFamilyHistory()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</div>
<label>Medical/Surgical History</label>
<%if(opd.getMedicalSurgicalHistory()!=null){ %>
<label class="value"><%=opd.getMedicalSurgicalHistory()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>


<div class="clear"></div>
<label>Obstetrics History</label>
<label class="auto">G</label>
<%if(opd.getGr()!=null){ %>
<label class="valueSmall"><%=opd.getGr()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<label class="auto">P</label>
<%if(opd.getPARA()!=null){ %>
<label class="valueSmall"><%=opd.getPARA()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>

<label class="auto">A</label>
<%if(opd.getAb()!=null){ %>
<label class="valueSmall"><%=opd.getAb()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>

<label class="auto">L</label>
<%if(opd.getPARA()!=null){ %>
<label class="valueSmall"><%=opd.getPARA()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<label class="auto">S</label>
<%if(opd.getPARA()!=null){ %>
<label class="valueSmall"><%=opd.getPARA()%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
<div class="clear"></div>

<!-- <label>Special Investigation</label><input type="text" name="specialInvestigation" /> -->
<div class="clear"></div>


</div>

<div class="clear"></div>
	
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col" rowspan="2">No. of Pregnancy</TH>
<TH scope="col" rowspan="2">Year</TH>
<TH scope="col" rowspan="2">Antenatal &amp; Period</TH>
<TH scope="col" rowspan="2">Labour &amp; Delivery</TH>
<TH scope="col" colspan="2">Baby</TH>
<TH scope="col" rowspan="2">Puerperium/Remarks</TH>

</tr>

<tr>
<TH scope="col" >Gender</TH>
<TH scope="col" >Weight</TH>
</tr>

<tr>

<td>

<%if(opd.getAChildNoOfPrag()!=null){ %>
<label class="value"><%=opd.getAChildNoOfPrag()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getAChildYear()!=null){ %>
<label class="value"><%=opd.getAChildYear()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<!-- <td><input type="text" name="fromPeriodDate1" id="fromPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('fromPeriodDate1',document.antenatalCard.fromPeriodDate1,event)" /></td>
<td><input type="text" name="toPeriodDate1" id="toPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('toPeriodDate1',document.antenatalCard.toPeriodDate1,event)" /></td>
 -->
 <td>
 <%if(opd.getAChildAntenatal()!=null){ %>
<label class="value"><%=opd.getAChildAntenatal()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
 </td>
<td>
<%if(opd.getAChildLabourAndDelivery()!=null){ %>
<label class="value"><%=opd.getAChildLabourAndDelivery()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getAChildGender()!=null){ %>
<label class="value"><%=opd.getAChildGender()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getAChildWeight()!=null){ %>
<label class="value"><%=opd.getAChildWeight()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
kg</td>
<td>
<%if(opd.getAChildRemark()!=null){ %>
<label class="value"><%=opd.getAChildRemark()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>

</tr>
<tr>

<td>

<%if(opd.getBChildNoOfPrag()!=null){ %>
<label class="value"><%=opd.getBChildNoOfPrag()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getBChildYear()!=null){ %>
<label class="value"><%=opd.getBChildYear()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<!-- <td><input type="text" name="fromPeriodDate1" id="fromPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('fromPeriodDate1',document.antenatalCard.fromPeriodDate1,event)" /></td>
<td><input type="text" name="toPeriodDate1" id="toPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('toPeriodDate1',document.antenatalCard.toPeriodDate1,event)" /></td>
 -->
 <td>
 <%if(opd.getBChildAntenatal()!=null){ %>
<label class="value"><%=opd.getBChildAntenatal()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
 </td>
<td>
<%if(opd.getBChildLabourAndDelivery()!=null){ %>
<label class="value"><%=opd.getBChildLabourAndDelivery()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getBChildGender()!=null){ %>
<label class="value"><%=opd.getBChildGender()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getBChildWeight()!=null){ %>
<label class="value"><%=opd.getBChildWeight()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
kg</td>
<td>
<%if(opd.getBChildRemark()!=null){ %>
<label class="value"><%=opd.getBChildRemark()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>


</tr>


<tr>

<td>

<%if(opd.getCChildNoOfPrag()!=null){ %>
<label class="value"><%=opd.getCChildNoOfPrag()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getCChildYear()!=null){ %>
<label class="value"><%=opd.getCChildYear()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<!-- <td><input type="text" name="fromPeriodDate1" id="fromPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('fromPeriodDate1',document.antenatalCard.fromPeriodDate1,event)" /></td>
<td><input type="text" name="toPeriodDate1" id="toPeriodDate1" value="" size="13" readonly="readonly"/></td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
	class="calender" onClick="setdate('toPeriodDate1',document.antenatalCard.toPeriodDate1,event)" /></td>
 -->
 <td>
 <%if(opd.getCChildAntenatal()!=null){ %>
<label class="value"><%=opd.getCChildAntenatal()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
 </td>
<td>
<%if(opd.getCChildLabourAndDelivery()!=null){ %>
<label class="value"><%=opd.getCChildLabourAndDelivery()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getCChildGender()!=null){ %>
<label class="value"><%=opd.getCChildGender()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getCChildWeight()!=null){ %>
<label class="value"><%=opd.getCChildWeight()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
kg</td>
<td>
<%if(opd.getCChildRemark()!=null){ %>
<label class="value"><%=opd.getCChildRemark()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>

</tr>
</table>
<div class="clear"></div>
<!-- 
<div class="Block">

<label class="auto">Blood Group</label>
<label class="auto">Wife</label>
<select class="smallest">
<option>A+</option>
</select>

<label class="auto">Husband</label>
<select class="smallest">
<option>A+</option>
</select>

</div>
 -->

<%}else{ %>
<h2>No Record Found</h2>
<%} %>
<script type="text/javascript">
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

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

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
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
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
	  
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'checkbox';
	  e3.name='referToMh'+iteration;
	  e3.id='referToMhId'+iteration
	  e3.size='10';
	  e3.className='radio';
	  e3.value='y';
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	 var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation("grid","hdb",this);}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  //e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	  

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
	//  alert("1---");
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
	e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);disableOtherMedicine(this.value,iteration);displayAu(this.value,iteration);
						   }
	  					  };
	  
	var newdiv = document.createElement('div');
    	newdiv.setAttribute('id', 'ac2update'+iteration);
    	newdiv.setAttribute('class', 'autocomplete');
     	newdiv.style.display = 'none';
e0.size = '30';
	//  alert("3-1--");
	  e0.setAttribute('tabindex','1');
	//  alert("3-2--");
	  cellRight0.appendChild(newdiv);
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
//alert("4---");
	   <%--  var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26';
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);--%>
	//  alert("5---");
	
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name='au'+iteration;
	  e12.id='au'+iteration
	  e12.size='6';
	  e12.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight2.appendChild(e12);

	 
	  cellRight2.appendChild(e1);
	  

	 /* var cellRight3 = row.insertCell(3);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight3 = row.insertCell(3);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dosage'+iteration;
	  e13.id='dosage'+iteration
	  e13.size='5';
	  e13.setAttribute('maxlength', 5); 
	  e13.setAttribute('tabindex','1');
	  e13.onblur = function(){checkDosageValidation(this.value,iteration)};
	  cellRight3.appendChild(e13);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight4 = row.insertCell(4);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){fillValueFromFrequency(this.value,iteration);getFrequencyValue(this.value,iteration)};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight4.appendChild(e2);

	  	var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(this.value,iteration)};
		cellRight4.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight4.appendChild(e21);
	  	  
	  var cellRight5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur=function(){fillValue(this.value,iteration)};
	  cellRight5.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  /*
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');

	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.classname='smalllabel';
	  e6.setAttribute('tabindex','1');
	  e6.options[0] = new Option('Select', '');
	  e6.options[1] = new Option('AC', 'AC');
	  e6.options[2] = new Option('PC', 'PC',true);
	  cellRight6.appendChild(e6);


	  var cellRight7 = row.insertCell(7);
	   var e7 = document.createElement('Select');

	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.classname='smalllabel';
	  e7.setAttribute('tabindex','1');
	   e7.options[0] = new Option('Select', '');
	   e7.options[1] = new Option('Left', 'left');
	   e7.options[2] = new Option('Right', 'right');
	   cellRight7.appendChild(e7);
*/


		var cellRight6 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value='PO'
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight8.appendChild(e71);

	  var cellRight9 = row.insertCell(9);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='6';
	  e72.setAttribute('tabindex','1');
	  cellRight9.appendChild(e72);

	  var cellRight10 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();');
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);}; 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	}
function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency freq :frequencyList){
%>
 if(feqValue == '<%=freq.getId()%>'){
	 feqQty = '<%=freq.getFeq()%>'
  }
<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

function  fillValue(value,inc){
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*value*dosage;
	  var finalQty;
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != 0){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			// alert("==in else==");
			  document.getElementById('total'+inc).value=freq*value*dosage
		  }
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = ((freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != 0){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				// alert("==in else==");
				  document.getElementById('total'+inc).value=freq*value*dosage
			  }

	  }
	  
	 }

	 function  fillValueFromFrequency(value,inc){
 	  var dosage = document.getElementById('dosage'+inc).value
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != 0){
			  finalQty = Math.ceil(totalQty);
		  }
		 /*var arr = new Array();
		  arr = totalQty.split(".");
		  var qtyA;var qtyB;var finalQty;
		  if(arr[0] != "" && arr[0] != null){
			  qtyA = parseFloat(arr[0]);
		  }else{
			  qtyA = 0;
		  }
		  if(arr[1] != "" && arr[1] != null){
			  qtyB = parseFloat(arr[1]);
		  }else{
			  qtyB = 0;
		  }
		  if(qtyA == 0){
			  finalQty = 1;
		  }else if(qtyB ==0){
			 finalQty = qtyA;
			  
		  }else if(qtyB >0){
			  finalQty = qtyA+1;
		  }*/
		  document.getElementById('total'+inc).value=finalQty;
	
	 }else{
		  document.getElementById('total'+inc).value=noOfDays*freq*dosage
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
function openPopupProcedureAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showProcedureListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fwc";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
}
function openPopupDetentionAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showDetentionListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fwc";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
function openPopupPhysiotheraphyAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showPhysiotherapyListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fwc";
 newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Physiotheraphy Advice ....");
}
function openPopupForImmunization(hinId,flag){
	var url = "/hms/hms/registration?method=openPopupForImmunization&hinId="+hinId+"&flag="+flag;
	 newwindow = window.open(url,'windowRef','width=1000,height=400,scrollbars = yes');
}

function fwcFileUploadViewWindow(visitId,hinId,flag)
{
		//var url="/hms/hms/fwc?method=showFwcUploadViewDocumentJsp&visitId="+visitId+"&hinId="+hinId;
		var url="/hms/hms/fwc?method=showFwcUploadViewDocumentJsp&visitId="+visitId+"&hinId="+hinId+"&flag="+flag;
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

}
function readOnlyNomenclature(val,inc){
	if(val != ""){
		//alert("Please confirm PVMS/NIV is not available");
		 document.getElementById('nomenclature'+inc).readOnly = true;
		 document.getElementById('au'+inc).readOnly = true;				
	     document.getElementById('nomenclature'+inc).value ="";
	     if(document.getElementById('itemId'+inc)){
	    	 document.getElementById('pvmsNo'+inc).value = "";
	     }
	  }else{
		document.getElementById('nomenclature'+inc).readOnly = false;
		 document.getElementById('au'+inc).readOnly = false;			

	  }
   }

function populatePVMS(val,inc){
	//alert("in method--")
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);
	   //  alert("pvms no--"+pvmsNo)

  if(pvmsNo == "")
  {
   // alert("pvms no1111--"+pvmsNo)
   	document.getElementById('nomenclature'+inc).value="";
    document.getElementById('pvmsNo'+inc).value="";
   return;
   }
   else
      document.getElementById('pvmsNo'+inc).value=pvmsNo


 }
}
function disableOtherMedicine(val,inc){
	//alert("sdfsdfsd"+val+"inc==="+inc);
  if(val != "")
	{
   document.getElementById('otherMedicine'+inc).readOnly = true;		
   document.getElementById('otherMedicine'+inc).value ="";
  // document.getElementById('itemConversionId'+inc).disabled = true;
  // document.getElementById('itemConversionId'+inc).value = "";
   //document.getElementById('injCategory'+inc).disabled = true;	
   
	}else{
		document.getElementById('otherMedicine'+inc).readOnly = false;
		//document.getElementById('itemConversionId'+inc).disabled = false;
		//document.getElementById('injCategory'+inc).disabled = false;	

	}
}

function openOtherField(familyHistoryId,fieldId){
	
	if(familyHistoryId == '8'){
		if(fieldId=='srfamilyHistory'){
			document.getElementById('otherSrFamilyHistoryDiv').style.display = 'block';
		}else if(fieldId=='familyHistory'){
			document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
		}
	}
	
}

function showHideInvestigationTemplateCombo(){
	var invId="";
	var sel = document.getElementById("investigationTemplateId");
	var listLength = sel.options.length;
	//alert("listLength--->"+listLength);
	
	for(var i=0;i<listLength;i++){
	   if(sel.options[i].selected){
			if(invId!=""){
				invId=invId+","+sel.options[i].value;
				}else{
					invId=sel.options[i].value;
			}
			
	   }
	}
		//alert("invId==="+invId);
	//if(checkTemplateId(valueOfTemplate)){
	  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';//'+invId
submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
			
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


function getListForTreatment(val){
if(val=='investigationDiv'){
alert("fdgdfgdf==="+val);	
	submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
}
//document.getElementById('prescriptionImportButton').style.display = 'none';
//document.getElementById("investigationImportButton").style.display='none'
}
function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';
		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}

</script>
</form>