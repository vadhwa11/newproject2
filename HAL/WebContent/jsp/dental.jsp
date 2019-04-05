<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.MasTherapyType"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>

<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<%
Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");

}
List patientDataList = new ArrayList();
if(map.get("patientDataList") != null){
	patientDataList=(List)map.get("patientDataList");
}


%>
<form name="dentalTreatment" action="" method="post">
<div class="titleBg">
<h2>Dental Treatment</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
 <label class="value"></label>

<label>Patient Name</label>
 <label class="value"></label>

<label>Relation</label>
 <label class="value"></label>

 <label>Rank</label>
 <label class="value"></label>

<label>Name</label>
 <label class="value"></label>

<label>Gender</label>
 <label class="value"></label>
 <label>Age</label>
 <label class="value"></label>

<label>Trade/Branch</label>
 <label class="value"></label>

<label>Unit</label>
 <label class="value"></label>
</div>


<div class="clear"></div>
<div class="arrowlistmenu">

<ul class="categoryitems">

	
	
	<li><a href="opd?method=showPatientPreviousVisitForViewScreen&visitId=visit.getId()&visitNo==visit.getVisitNo()&deptId==visit.getDepartment().getId()&=HIN_ID==visit.getHin().getId()&token==visit.getTokenNo()">
	Previous Visits </a></li>
	
	

	<li><a href="medicalExam?method=getPrevMedExamFromHIC&serviceNo==visit.getHin().getServiceNo() ">
	Previous Medical Exams </a></li>
	<li><a href="medicalExam?method=getPrevMedBoardFromHIC&visitId==visit.getId()&visitNo==visit.getVisitNo()&deptId==visit.getDepartment().getId()&=HIN_ID==visit.getHin().getId()&serviceNo==visit.getHin().getServiceNo() ">
	Previous Medical Boards</a></li>
	<li><a href="opd?method=showPatientPreviousVisitForHospitality&visitId==visit.getId()&visitNo==visit.getVisitNo()&deptId==visit.getDepartment().getId()&=HIN_ID==visit.getHin().getId()">
    Previous Hospitalizations</a></li>
	

	 <li><a href="javascript:openPopupPrescriptions(=visit.getId(),=visit.getVisitNo(),=visit.getDepartment().getId(),=visit.getHin().getId())">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="javascript:openPopupInvestigation(=visit.getId(),=visit.getVisitNo(),=visit.getDepartment().getId(),=visit.getHin().getId())">
		Previous Investigations</a></li>
		<li><a href="opd?method=showAllergyDetailsJsp&visitId==visit.getId() &hinId==visit.getHin().getId() ">Allergies</a></li>
		
	<li><a href="opd?method=showUploadingDocumentsJsp&visitId==visit.getId() ">Upload Documents </a></li>


</ul>



<script type="text/javascript">


</script>
</div>




























<div class="opdArea">

<h4>Patient Complaints</h4>
<div class="clear"></div>
<div class="Block">
<label>Main Complaint</label>
<select id="mainCompId" name="mainCompId" validate="Main Complaint,string,no" tabindex="1">
	<option value="0">Select</option>

</select>

<label >Since</label>
<input tabindex="1"	type="text"   name="SINCE" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
	<select id="sinceId" name="sinceId" class="small"	validate="Since,string,no" tabindex="1">
	<option value="0">Select</option>
    <option value="1">Days</option>
    <option value="2">Weeks</option>
    <option value="3">Months</option>
    <option value="4">Year</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>

<label>Associated Complaint</label>
<select id="associatedCompId" name="associatedCompId" 	validate="Associated Complaint,string,no" tabindex="1">
	<option value="0">Select</option>

</select>


<div class="clear"></div>
<label >Since</label>
<input tabindex="1"	type="text"   name="SINCE" class="small" value=""	onKeyUp="isNumber(this)" maxlength="2" />
	<select id="sinceId" name="sinceId"	validate="Since,string,no" tabindex="1" class="small">
	<option value="0">Select</option>
    <option value="1">Days</option>
    <option value="2">Weeks</option>
    <option value="3">Months</option>
    <option value="4">Year</option>
</select>
<label>Remarks</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
<div class="clear"></div>
<label>Complaint Descriptions</label>
<textarea name="complaintDescriptions"
	id="complaintDescriptions" cols="20" rows="2" tabindex="1"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

</div>

<div class="clear"></div>



<div class="clear"></div>

<h4>Oral Health Condition And Findings</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label >Total no. of Teeth</label>


 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />




<label class="medium3">Total No. of Defective Teeth</label>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />



	<label class="medium3">Total no. of Dental Points</label>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />


<div class="clear"></div>

	

<label >Missing </label>

<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
	
<label class="medium3">Unsaveable</label>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />


 <label class="medium3">Condition of Gums</label>


<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />

</div>
<div class="clear"></div>
</div>

<h4>Missing Teeth</h4>

<div class="Block">
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

</div>
<div class="clear"></div>































<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block">


<div class="floatLeft">
<!-- 	<label >On Examination</label>  -->
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>

<input name="" value=""	id="systemDiagnosis" tabindex="1" class="auto" size="117" />



 

<div class="clear"></div>

<label>System Diagnosis</label>
<input name="" value=""	id="systemDiagnosis" tabindex="1" class="auto" size="117" />

<div class="clear"></div>
<%--
<label>ICD Code</label>
<input name="" value=""	id="icdCode" tabindex="1" class="auto" size="117" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer; margin:0px;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />
 --%>
<input type="hidden" name="ageName" value="=visit.getHin().getAge() " id="ageId" /> 

<div class="clear"></div>
<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="=DIAGNOSIS_ID" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
</div><!-- floatLeft ends -->
<div class="floatRight">

</div><!-- floatRight ends -->

</div>
<div class="clear"></div>

<h4>Dental Procedure</h4>
<div class="clear"></div>
<div class="Block">




<label>Treatment</label>
<select id="sinceId" name="sinceId"	validate="Since,string,no" tabindex="1"  >
	<option value="0">Select</option>
    <option value="1">PI</option>
    <option value="2">PII</option>
    <option value="3">PIII</option>
    
</select>
<label>DTC</label>
<select id="sinceId" name="sinceId"	validate="Since,string,no" tabindex="1" >
	<option value="0">Select</option>
    <option value="1">PI</option>
    <option value="2">PII</option>
    <option value="3">PIII</option>
    
</select>

<label>Remarks</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>

<label>Anaesthic Local</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>


<label>Anaesthic General</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>


<label>Remarks</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>


<label>Teeth Extracted</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>


<label>Teth Conserves(With RT)</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>



<label>Without RT</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>

<div class="clear"></div>
<h4>Dentures Fitted</h4>
<div class="clear"></div>


<label>New</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>

<label>Remodels</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>


<label>Repairs</label>
<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th   scope="col">Dental Procedure</th>
		<th scope="col">Remarks</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

	
		
		
	
	
		<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'')){checkForChargeCode(this.value,'','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'')){checkForChargeCode(this.value,'','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	
	</table>

<label >Specialised Treatment</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>

</div>
</div>
<div class="clear"></div>






























<h4>Investigation</h4>

<div class="Block">

<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th   scope="col">Test Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

	
		
		
	
	
		<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'')){checkForChargeCode(this.value,'','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	


	


</table>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Clinical Notes</th>

	</tr>
	<tr>
	
		
		
			<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="" size="200" maxlength="45" /></td>
		

	</tr>
</table>
</div>
</div>


<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="Clear"></div>
<div id="testDivDrug">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th colspan="col">Nomenclature</th>
		
		
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Routs</th>
		<!-- <th scope="col">Type</th> -->
		<th scope="col">Remarks</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>

	</tr>


	
	<tr>
		<td>
		
	    
			<input type="text" tabindex="1"	id="nomenclature1" readonly="readonly" value=""
			size="50" name="nomenclature"  onblur="disableOtherMedicine();"/></td>
	
	
			<td><input type="text" name="dosage" readonly="readonly"
			id="dosage" value="" size="10" tabindex="1" /></td>
			
			<td><select name="frequency" id="frequency" disabled="disabled"
			tabindex="1">
			<option value="0">Select</option>
			

			<option value="" ></option>
			
		</select>  
 
		</td>
		
		
		
        
		<td><input type="text" name="noOfDays" size="8"
			tabindex="1" id="noOfDays" value=""
			readonly="readonly" /></td>
		
		



		 
		
		
		
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value=""></option>
		</select></td>
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks" 
			value="" readonly="readonly" /></td>
			
			<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>
	
	


</table>
<div class="Clear"></div>
<label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>

</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>







</div>
<div class="clear"></div>



























<div class="division"></div>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<div class="clear"></div>
<div class="division"></div>
</form>

