<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/proto.js?n=1" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	 var nameArray=new Array();
	 var codeArray=new Array();
</script>
<script type="text/javascript" language="javascript">
	<%
		Map map = new HashMap();
		int pageNo=1;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
		String  empStatusCodeForContract = HMSUtil.getProperties("adt.properties", "empStatusCodeForContract");
		List<StoreOpPatientIssueM> opPatientIssueList = new ArrayList<StoreOpPatientIssueM>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<Patient> patientList=new ArrayList<Patient>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String timeInHHmm="";
		String [] temp = null;
		temp = time.split(":");
		for (int i = 0 ; i < temp.length-1 ; i++) {

			
			
			
			timeInHHmm=timeInHHmm+(String)temp[i];
	    	 if(i==0)
	    	 {
	    		 timeInHHmm=timeInHHmm+":";
	    	 }
	   }
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		String buttonFlag="";
		if(map.get("buttonFlag") != null)
		{
			buttonFlag=(String)map.get("buttonFlag");
		}
		if(map.get("pageNo") != null)
		{
			pageNo=(Integer)map.get("pageNo");
		}
		int hinId=0;
		String hinNo="";
		if(map.get("hinId") != null)
		{
			hinId=(Integer)map.get("hinId");
			hinNo=(String)map.get("hinNo");
		}
		String issueNo="";
		if(map.get("issueNo") != null)
		{
			issueNo=(String)map.get("issueNo");
		}
		String prescription="";
		int consultantId=0;
		if(map.get("prescription") != null)
		{
			prescription=(String)map.get("prescription");
		}
		if(map.get("consultantId") != null)
		{
			consultantId=(Integer)map.get("consultantId");
		}

		if(map.get("opPatientIssueList") != null)
		{
			opPatientIssueList=(List)map.get("opPatientIssueList");
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if(map.get("patientMap") != null)
		{
			patientMap=(Map<String,Object>)map.get("patientMap");
		}
		
		List<PatientPrescriptionHeader> prescriptionList = new ArrayList<PatientPrescriptionHeader>();
		if(patientMap.get("prescriptionList") != null){
			prescriptionList = (List<PatientPrescriptionHeader>)patientMap.get("prescriptionList");
		}
		String checkNextRecord="no";
		if(patientMap.get("checkNextRecord") != null){
			checkNextRecord = (String)patientMap.get("checkNextRecord");
		}
		//System.out.println("checkNextRecord "+checkNextRecord);
		Patient patient = new Patient();
		int visitId = 0;
		if(prescriptionList.size() > 0){
			patient = prescriptionList.get(0).getHin();
			visitId = prescriptionList.get(0).getVisit().getId();
		}
		int prescriptionId = 0;
		if(map.get("prescriptionId") != null){
			prescriptionId = (Integer)map.get("prescriptionId");
			//System.out.println("prescriptionId-"+prescriptionId);
		}
		String flag="";
		if(map.get("flag") != null)
		{
			flag=(String)map.get("flag");
		}
		String message="";
		if(map.get("message")!=null)
		{
			message=(String)map.get("message");
		}
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null)
		{
			frequencyList=(List)map.get("frequencyList");
		}
		String otherTreatment = "";
		String visitNo = "";
		int prescription_No=0;
		String doctorName=" ";
		String pre_date="";
		String pre_time="";
		String facStatus="n";
		int prescriptionHeaderId=0;
		int empId=0;
		System.out.println("prescriptionList=="+prescriptionList.size());
		PatientPrescriptionHeader prescriptionHeader=null;
		if(prescriptionList.size()>0){
			if(prescriptionList.get(0).getOtherTreatment()!=null){
				otherTreatment=prescriptionList.get(0).getOtherTreatment();
			}
			
			prescriptionHeader=prescriptionList.get(0);  
			if(prescriptionList.get(0).getFacStatus()!=null)
				facStatus= prescriptionList.get(0).getFacStatus();
		    prescriptionHeaderId=prescriptionHeader.getId();
		     if(prescriptionHeader.getVisit()!=null && prescriptionHeader.getVisit().getDoctor()!=null)
			 visitNo =""+ prescriptionHeader.getVisit().getVisitNo();
				if(prescriptionHeader.getVisit()!=null && prescriptionHeader.getVisit().getDoctor()!=null)
					consultantId = prescriptionHeader.getVisit().getDoctor().getId();
				if(prescriptionHeader.getPrescriptionNo()!=null)
				prescription_No=prescriptionHeader.getPrescriptionNo();
				if(prescriptionHeader.getVisit()!=null && prescriptionHeader.getVisit().getDoctor()!=null)
				doctorName=prescriptionHeader.getVisit().getDoctor().getFirstName()+" "+prescriptionHeader.getVisit().getDoctor().getLastName();
				if(prescriptionHeader.getPrescriptionDate()!=null)
				pre_date=""+prescriptionHeader.getPrescriptionDate();
				if(prescriptionHeader.getPrescriptionTime()!=null)
				pre_time=prescriptionHeader.getPrescriptionTime();	
		}

		String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	
	 List opdIssueNo=(List)map.get("opdIssueNo");
	 StoreFyDocumentNo storeFyDocumentNo=new StoreFyDocumentNo();
	 int storeFyDocumentNoId =0 ;
	 if(opdIssueNo !=null && opdIssueNo.size() >0){
	  storeFyDocumentNo= (StoreFyDocumentNo)opdIssueNo.get(0);
	  storeFyDocumentNoId = storeFyDocumentNo!=null ? storeFyDocumentNo.getId():0;
	 }
%>
		serverdate = '<%=date+"/"+month+"/"+year%>';

		<%
		  if(checkNextRecord.equalsIgnoreCase("yes"))
		  {
		 %>
		     alert("Next Prescription Not Found.");
		  
		 <%
		 }%>  

		</script>
<div class="titleBg">
<h2>Patient Issue</h2>
</div>

<form name="opdPatientIssue" method="post" action="">
<div class="Clear"></div>
<input type="hidden" id="patientPrescriptionId" name="patientPrescriptionId" value="<%= prescriptionHeaderId%>" />
<input type="hidden" id="visitId" name="visitId" value="<%= visitId%>" />
<div class="Block">
<%if(hinId != 0){ %>  <input type="hidden"
	name="<%=HIN_NO%>" value="<%=hinNo %>" tabindex="1" MAXLENGTH="30"
	readonly /> <input type="hidden" name="<%=HIN_ID%>"
	value="<%=hinId %>" /> <%}else if(patient.getHinNo() != null){%> <!-- <label>HIN</label> -->
<input type="hidden" name="<%=HIN_NO%>"
	value="<%=patient.getHinNo()  %>" tabindex="1" MAXLENGTH="30" readonly />
<input type="hidden" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />
<%}else{ %>

<div id="hinDiv"><input type="hidden"
	name="<%=HIN_ID%>" id="hinNo" value="" tabindex="1" MAXLENGTH="30"
	onblur="if(checkHinNo()){submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');}" />
</div>
<%} %> <%if(hinId != 0){ %> <label>Employee No.</label> <input type="text"
	id="serviceNo" name="serviceNo" value="" tabindex="1" readonly"/> <%}else if(patient.getServiceNo() != null){%>
<label>Employee No.</label> <input type="text" id="serviceNo"
	name="serviceNo" value="<%=patient.getServiceNo() %>" tabindex="1" readonly"/>
<%}else{ %> <label>Employee No.</label> <input type="text" id="serviceNo"
	name="serviceNo" value="" tabindex="1" MAXLENGTH="30"
	validate="Service No,string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%} %> <%
String p_name=patient.getPFirstName();
if(patient.getPLastName() != null){
	p_name=p_name+" "+patient.getPLastName();
}%> <label>Patient Name</label> <input type="text" id="p_name"
	name="p_name" value="<%=p_name %>" tabindex="1" readonly"/>
	<input type = "hidden" name="empStatus" id="empStatus" value = '<%=patient.getEmployee()!=null?patient.getEmployee().getEmployeeStatus().getEmpStatusCode():""%>'/>
	 <%if(patient.getRelation() != null){%>
<label>Relation</label> <input type="text" id="relation"
	name="relation" value="<%=patient.getRelation()!=null ? patient.getRelation().getRelationName():"" %>"
	tabindex="1" readonly"/> <%}else{ %> <label>Relation</label> <input
	type="text" id="relation" name="relation" value="" tabindex="1"
	MAXLENGTH="30" validate="Relation,string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%} %>
<div class="clear"></div>
<%-- <%if(patient.getRank() != null){%> <label>Rank</label> <input
	type="text" id="rank" name="rank"
	value="<%=patient.getRank().getRankName() %>" tabindex="1" readonly"/>
<%}else{%> <label>Rank</label> <input type="text" id="rank" name="rank"
	value="" tabindex="1" MAXLENGTH="30" validate="Rank, string,no"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%}%> --%> <%
String S_name=patient.getSFirstName();
if(patient.getSLastName() != null){
	S_name=S_name+" "+patient.getSLastName();
}%> <label>Name</label> <input type="text" id="S_name" name="S_name"
	value="<%=S_name %>" tabindex="1" readonly"/> <%-- <%if(patient.getUnit()!= null){%>
<label>Unit</label> <input type="text" id="unit" name="unit"
	value="<%=patient.getUnit().getUnitName() %>" tabindex="1" readonly"/>
<%}else{ %> <label>Unit</label> <input type="text" id="unit" name="unit"
	value="" tabindex="1" MAXLENGTH="30" validate="Rank, string,no"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%} %>--%> <%if(patient.getAge() != null){%>
<label>Age</label> <input type="text" id="age" name="age"
	value="<%=patient.getAge() %>" tabindex="1" readonly"/> <%}else{ %>  <label>Age</label>
<input type="text" id="age" name="age" value="" tabindex="1"
	MAXLENGTH="30" validate="Age, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%} %> <%if(patient.getSex() != null){%>
<label>Gender</label> <input type="text" id="sex" name="sex"
	value="<%=patient.getSex().getAdministrativeSexName() %>" tabindex="1" readonly"/>
<%}else{ %> <label>Gender</label> <input type="text" id="sex" name="sex"
	value="" tabindex="1" MAXLENGTH="30" validate="Gender, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGridFAC');"
	onFocus="opdPatientIssue.reset();" /> <%} %> 
	<%
	
String doc_name="";
if(prescriptionList.size()>0){	
if(prescriptionList.get(0).getEmp() != null ){
	doc_name=prescriptionList.get(0).getEmp().getFirstName()+" "+(prescriptionList.get(0).getEmp().getLastName()!=null?prescriptionList.get(0).getEmp().getLastName():"");
}
}
%>
 <label>Doctor</label> <input type="text" id="mo" name="mo"	value="<%=doc_name %>" tabindex="1" readonly"/> 
 <% if(patient.getServiceType() != null){%> <!-- <label >Service Type</label> -->
<input type="hidden" id="serviceType" name="serviceType"
	value="<%=patient.getServiceType().getServiceTypeName() %>"
	tabindex="1" readonly"/> <%}
  %> 
  <input type="hidden" name="doctor_name"	id="doctor_name" tabindex="1" value="<%=doctorName%>"	MAXLENGTH="5" readonly />
<input type="hidden" name="<%=CONSULTING_DOCTOR%>"	id="consultant" tabindex="1" value="<%=consultantId%>"	MAXLENGTH="5" readonly />

<label>Prescription Date</label>
<% String str_date=pre_date;

   String final_date="";
   if(!str_date.equals(""))
	   final_date = str_date.substring(8)+"/"+str_date.substring(5,7)+"/"+str_date.substring(0,4);
%>

<input type="text" name="<%=DATE%>"id="pre_date" tabindex="1" value="<%=final_date%>"	readonly />
<!-- <label> Time</label>
<input type="text" name="<%=TIME%>"	id="pre_time" tabindex="1" value="<%=pre_time%>"	MAXLENGTH="5" readonly />
<label> Visit No.</label>-->
<input type="hidden" name="<%=VISIT_NUMBER%>" id="visitNo" tabindex="1" value="<%=visitNo%>"	readonly /> 
<label> Prescription No.</label>
<input type="text" name="<%=PRESCRIPTION_NO%>"	id="prescriptionNo" tabindex="1" value="<%=prescription_No%>" MAXLENGTH="5" readonly />
<%-- <label>Specialty<span>*</span></label>
<input type="text" name="specialty" value="AMA" id="prescribBy" validate="Prescribed By,string,no"/>
<label>Issue No. </label>
<label class="value"><%= opdIssuenoIncremented%></label> --%>
<div class="clear"></div>
<label>Issue Date </label>
<label class="value"><%= currDate%></label>

<%--  <label> Other Treatment</label>
  <textarea name="otherTreatment" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" ><%=otherTreatment %></textarea>
 --%>
  <div class="Clear"></div>
<input type="hidden" id="opdIssueno" name="opdIssueno" value="<%= opdIssuenoIncremented%>" />	
<input type="hidden" id="issueNo" name="issueNo" value="<%= opdIssuenoIncremented%>" />
 <input type="hidden" name="pageNo" value="<%=pageNo %>" />
 <input	type="hidden" name="buttonFlag" value="<%=buttonFlag %>" />
 <input	type="hidden" name="issueNo" value="<%=issueNo %>" />
 <input	type="hidden" name="prescription" value="<%=prescription %>" /> 
 <input	type="hidden" name="consultantId" value="<%=consultantId %>" /> 
 <%
 System.out.println("storeFyDocumentNo--"+storeFyDocumentNo.getId());
 %>
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%=storeFyDocumentNoId%>"  />
	
	<!--<div class="Clear"></div>
<label class="noWidth">Date</label>
<input type="text" name="date"	value="<%=currDate %>" readonly />
<label class="noWidth">Time</label>
<input type="text" name="time"	value="<%=timeInHHmm %>" readonly />
--></div>

<input type="hidden" name="add" id="addbutton" value="Print"
	class="button"
	onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');"
	accesskey="g" />
  <div class="clear"></div>
<div id="testDiv"></div>
</form>
<script>
<%if(flag.equals("loanout")){%>
<% if (hinId !=0) { %>

submitProtoAjax('opdPatientIssue','/hms/hms/stores?method=showOPDPatientLoanOutIssueGrid');

<% 
//System.out.println("(hinId !=0) ");
}else if(patient.getId()!=null){ %>
var prescriptionId ='<%=prescriptionId%>';
	submitProtoAjax('opdPatientIssue','/hms/hms/stores?method=showOPDPatientLoanOutIssueGrid&prescriptionId='+prescriptionId);
	
<%
//System.out.println("if(patient.getId()!=null) ");

}%>
<%}else{%>
		<% if (hinId !=0) { %>
		   
			submitProtoAjax('opdPatientIssue','/hms/hms/stores?method=showOPDPatientIssueGridFAC');
			
		<% 
		//System.out.println("(hinId !=0) ");
		}else if(patient.getId()!=null){ %>
		var prescriptionId ='<%=prescriptionId%>';
				submitProtoAjax('opdPatientIssue','/hms/hms/stores?method=showOPDPatientIssueGridFAC&prescriptionId='+prescriptionId);
				
		<%
		}%>
		<%}%>
</script>

<script type="text/javascript">
<!--
function fillItemsInGrid(itemId,rowVal,deptId)
{
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
			document.getElementById('serviceNoNo').value=document.getElementById('serviceNo').value;;
		//	var lotNo=document.getElementById('lotNo'+rowVal)
		//	lotNo.disabled = true
		//	var combo=document.getElementById('nomenclature'+rowVal);
		//		combo.disabled=true
	}

function fillItemsInGridForLotNo(lotNo,rowVal,deptId,formName){
		//alert("Brand id=="+brandId)
		var bool="false";
		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][4]==lotNo){
		bool="true";
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			//document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;

		//	formname=formName.name
		//	var obj3 = eval('document.'+formname+'.lotNo'+rowVal);
		//	obj3.disabled = true

			var obj3=document.getElementById('lotNo'+rowVal);
			obj3.disabled = true

			var combo=document.getElementById('nomenclature'+rowVal);
				combo.disabled=true
			}
		}
		if(bool == "false")
		{
		  alert("Lot Number not matched")
		  return false
		}
		openPopupForLotNo(lotNo,rowVal,deptId);
		return true
}

	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=500,width=1010,status=1,left=0, top=0, scrollbars=1,resizable=0");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.Please Select the Nomenclature/LotNo to Enter ")
	  	return false;
	  }else{
	  return true;
	  }

	  }

/*  function checkServiceNo(){

	  if(document.getElementById('serviceNo').value =="")
	  {
	  	alert("Please Enter the service Number ")
	  	document.opdPatientIssue.serviceNo.focus();
	  // var c=eval(document.opdPatientIssue.serviceNo);
	  // alert(c)
	  //	c.focus();
	  	return false;
	  }
	  return true;
	  }
*/



 function checkHinNo(){
	  if(document.getElementById('hinNo').value =="")
	  {
	  	alert("Please Enter the HIN Number ")
	   var c=eval(document.opdPatientIssue.serviceNo);
	   alert(c)
	  	c.focus();
	  	return false;
	  }
	  return true;
	  }

	function openPopupForDelete(OPDIssueNo){
		//alert("opdIssueNo:---"+OPDIssueNo)
		var url="/hms/hms/stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo="+OPDIssueNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");

		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=980,');

    }
    function checkForNomenclature(val,inc,deptId,flag)
    {
        if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var itemId = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var nomenclature=val.substring(0,indexForBrandName);
	     if(itemId =="")
	    {

	     return;
	    }
	    for(i=1;i<inc;i++){

	      if(inc != 1){
	        if(document.getElementById('nomenclature'+i).value==val)
	        {
	    		alert("Item already selected...!")
	    		document.getElementById('nomenclature'+inc).value=""

	    	  return false;
	        }
	      }
	   }
		//ajaxFunctionForAutoCompleteOPDPatient('opdPatientIssue','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
		//ajaxFunctionForAutoCompleteOPDPatientInfo('opdPatientIssue','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
		ajaxFunctionForAutoCompleteOPDPatientInfo2('opdPatientIssue','stores?method=fillItemsInGridForOPDDir&itemId='+itemId , inc);
		document.getElementById('empId').value=document.getElementById('consultant').value;
		document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		document.getElementById('itemId'+inc).value = itemId;
        //alert("3"); 
		if(flag  != "prescription")
			openPopup(itemId,deptId,inc);
		//var nomenclature=document.getElementById('nomenclature'+inc)
		//	nomenclature.disabled = true
		//var lotNo=document.getElementById('lotNo'+inc)
			//lotNo.disabled = true

	  }
	}
    function openPopup(itemId,deptId,rowVal)
    {
    	var patientPrescriptionId =0 ;
    	var serviceNo = document.getElementById('serviceNo').value;
    	//alert("qtyPrescription "+document.getElementById('qtyPrescription'+rowVal).value);
    	var qtyPrescription = document.getElementById('qtyPrescription'+rowVal).value;
    	var nomenclature = document.getElementById('nomenclature'+rowVal).value;
		if(document.getElementById('patientPrescriptionDtId'+rowVal)){
    	 patientPrescriptionId =  document.getElementById('patientPrescriptionDtId'+rowVal).value;
		}
		var err = "";
		if(document.getElementById('prescriptionNo')){
			if(document.getElementById('prescriptionNo').value == ""){
			err +="Please Enter Prescription No.\n";
			}
		}
	  ///	    if(document.getElementById('consultant').value == "0"){
		//	err +="Please select Doctor Name.\n";
		//}
		if(err != ""){
			alert(err);
			return false;
		}else{
	   		var url="/hms/hms/stores?method=showOPDStockDetailsJsp&itemId="+itemId+"&deptId="+deptId+"&rowVal="+rowVal+"&serviceNo="+serviceNo+"&nomenclature="+encodeURIComponent(nomenclature)+"&patientPrescriptionId="+patientPrescriptionId+"&qtyPrescription="+qtyPrescription;
        	popwindow(url);
		}
     }

      function validateConsultant(formName,rowVal) {
          
			formname=formName.name
			
			   consultantName=eval('document.'+formname+'.consultingDoctor.value')
			   prescription=eval('document.'+formname+'.prescriptionNo.value')
		   // fillSrNo(rowVal)
		return true
		}

 function jsDisplay()
     {
		if (document.searchForm.<%= ISSUE_NO%>.value=="")
		{
		alert('Pl. select Prescription No....');
		return;
		}
		var OPDIssueNo = document.searchForm.<%= ISSUE_NO%>.value
		opdPatientIssue.method="post";
		//var url="/hms/hms/stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo="+OPDIssueNo;
		submitForm('searchForm','stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo='+OPDIssueNo+'&search=y');
    } 

	function generateRowPrescription(rowVal)
	 {
	/* 	var issueQty = document.getElementById("qtyIssued"+rowVal).value;
		var flag = false;
		if(issueQty==null || issueQty==''){
			   alert("Empty Issue Quantity!");
			   return flag;
		}else{
			var qty = parseInt(issueQty);
			var prescribeQty = parseInt(document.getElementById("qtyPrescription"+rowVal).value);
			if(qty==0){
				alert("You Have Issue Zero Quantity!");
				return flag;
			}else if(qty==prescribeQty){
				alert("No Remainig Quantity!");
				return flag;
			}
			flag = true;
		}
		 */
		 
		var issueQty = 0;
		var presQty = 0;
		var prescribeQty = 0;
		var previousAddedRow = 0;
		var listSize=document.getElementById('listsize').value;
		var flag = false;
		for(var z=1; z<=listSize; z++)
			{
			if(document.getElementById('itemId'+z)!=null && document.getElementById('itemId'+z).value == document.getElementById('itemId'+rowVal).value)
			{
				if(document.getElementById("qtyIssued"+rowVal)!=null && document.getElementById("qtyIssued"+rowVal).value.trim() != "")
				{
					
					previousAddedRow = z;
					issueQty = document.getElementById("qtyIssued"+z).value;
					prescribeQty = document.getElementById("qtyPrescription"+z).value;
				}
				
			}
			
			}
		
		 if(issueQty==''){ 
			
			   alert("Empty Issue Quantity!");
			   return flag;
		}else{
			var qty = parseInt(issueQty);
			 prescribeQty = parseInt(prescribeQty);
			if(qty==0){
				alert("You Have Issue Zero Quantity!");
				return flag;
			}else if(qty==prescribeQty){
				alert("No Remainig Quantity!");
				return flag;
			}
			flag = true;
		}
		 document.getElementById("qtyIssued"+previousAddedRow).readOnly="true";
		
		 
		var icdArray=new Array(); 
		icdArray[0]="Saab";       
		icdArray[1]="Volvo";
		icdArray[2]="BMW";
		  var tbl = document.getElementById('stockDetails');
		  var lastRow = tbl.rows.length;
		  var deptId = document.getElementById('deptId').value;
		  var listSize=document.getElementById('listsize').value;
		  listSize=(parseInt(listSize))+1;
		  var iteration = listSize;
		
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  hdb.value=iteration


		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.size = '2';
		  e0.name='<%=SR_NO%>';
		  e0.readOnly=true;
		  e0.value=iteration;
		  cellRight0.appendChild(e0);


		  var e01 = document.createElement('input');
		  e01.type = 'hidden';
		  e01.name='patientPrescriptionDtId'+iteration;
		  e01.id = 'patientPrescriptionDtId'+iteration;
		  e01.size='10';
		  e01.value=document.getElementById('patientPrescriptionDtId'+rowVal).value;
		  e01.readOnly=true;		  
		  cellRight0.appendChild(e01);
		  
		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name='pvmsNo'+iteration;
		  e1.id = 'pvmsNo'+iteration;
		  e1.size='10';
		  e1.value=document.getElementById('pvmsNo'+rowVal).value;
		  e1.readOnly=true;
		 
		  cellRight1.appendChild(e1);
 
		  
		  var e111 = document.createElement('input');
		  e111.type = 'hidden';
		  e111.name='batchNoValue'+iteration;
		  e111.id = 'batchNoValue'+iteration;
		  e111.value="";	  
		  cellRight1.appendChild(e111);
		  

		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name = 'nomenclature' + iteration;
		  e2.id = 'nomenclature' + iteration;
		  e2.size = '30';
		  
		  e2.value=document.getElementById('nomenclature'+rowVal).value;
		  e2.readOnly=true;
			 
		 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
		  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
			
		  cellRight2.appendChild(e2);
		  
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='itemId'+iteration;
		  e21.id = 'itemId'+iteration;
		  e21.value=document.getElementById('itemId'+rowVal).value;
		  cellRight2.appendChild(e21);

		   /* var cellRight21 = row.insertCell(3);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name = 'barCodeNo' + iteration;
		  e21.id = 'barCodeNo' + iteration;
		  e21.size = '8';
		  e21.onblur = function(){getDataForBarcode(this.value,iteration);};
		  e21.onchange=function(){getDataForBarcode(this.value,iteration);};
		  cellRight21.appendChild(e21); */
		  			 
		  var cellRight22 = row.insertCell(3);
		  var e22 = document.createElement('input');
		  e22.type = 'text';
		  e22.name = 'au' + iteration;
		  e22.id = 'au' + iteration;
		  e22.size = '7';
		  e22.value=document.getElementById('au'+rowVal).value;
		  e22.readOnly=true;
		  cellRight22.appendChild(e22);

		 /*  var cellRight23 = row.insertCell(4);
		  var e23 = document.createElement('Select');
		  e23.name = 'batchNo' + iteration;
		  e23.id = 'batchNo' + iteration;
		  //e23.setAttribute('validate', 'Batch No,string,yes');
		  e23.className='small3';
		  e23.onclick=function(){fillItem(this.value,iteration)}
		  e23.onchange=function(){getDataForBarcode(this.value,iteration); checkDublicateBatch(iteration);}
		  e23.options[0] = new Option('Select Batch', '0');
		  cellRight23.appendChild(e23); */
		  
		  

		  var cellRight23 = row.insertCell(4);
		  var e23 = document.createElement('Select');
		  e23.name = 'batchNo' + iteration;
		  e23.id = 'batchNo' + iteration;
		  //e23.setAttribute('validate', 'Batch No,string,yes');
		  e23.className='small3';
		  e23.onclick=function(){fillBatchforStockId(this.value,iteration)}
		  e23.onchange=function(){if(cheackForBatch(iteration)){getDataForBarBatchStockId(this.value,iteration)}}
		  e23.options[0] = new Option('Select Batch', '0');
		  cellRight23.appendChild(e23);
		  
		  
		  var e24 = document.createElement('input');
		  e24.type = 'hidden';
		  e24.name = 'brandId' + iteration;
		  e24.id = 'brandId' + iteration;
		  e24.size = '10';
		
		  cellRight23.appendChild(e24);
		  	  
		  var cellRight25 = row.insertCell(5);
		  var e25 = document.createElement('input');
		  e25.type = 'text';
		  e25.name = 'expiryDate' + iteration;
		  e25.id = 'expiryDate' + iteration;
		  e25.size = '10';
		  e25.readOnly=true;
		  var e26 = document.createElement('input');
		  e26.type = 'hidden';
		  e26.name = 'costPrice' + iteration;
		  e26.id = 'costPrice' + iteration;
		  e26.size = '10';
		  cellRight25.appendChild(e25);
		  cellRight25.appendChild(e26);
		  
		  var cellRight34 = row.insertCell(6);
		  var e34 = document.createElement('input');
		  e34.type = 'text';
		  e34.name = 'qtyPrescription' + iteration;
		  e34.id = 'qtyPrescription' + iteration;
		  e34.size = '6';
		 /*  if(document.getElementById('qtyIssued'+rowVal).value=="")
		  {	  
		   e34.value=parseInt(document.getElementById('qtyPrescription'+rowVal).value);
		  }else
		   e34.value=parseInt(document.getElementById('qtyPrescription'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
		    */
		    
		    e34.value = prescribeQty-parseInt(issueQty);
		   cellRight34.appendChild(e34);
		  
		  var cellRight35 = row.insertCell(7);
		  var e35 = document.createElement('input');
		  e35.type = 'text';
		  e35.name = 'qtyIssued' + iteration;
		  e35.id = 'qtyIssued' + iteration;
		  e35.setAttribute("readOnly","readOnly");
		  e35.size = '6';
		  e35.onblur = function(){checkQty(iteration)};
		  cellRight35.appendChild(e35);
		  
		  
		  var cellRight3 = row.insertCell(8);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name = 'strength' + iteration;
		  e3.id = 'strength' + iteration;
		  e3.size = '5';
		  e3.value=document.getElementById('strength'+rowVal).value;
		  e3.readOnly=true;
		  cellRight3.appendChild(e3);
		  
		  
		  var cellRight31 = row.insertCell(9);
		  var e31 = document.createElement('input');
		  e31.type = 'text';
		  e31.name = 'frequencyName' + iteration;
		  e31.id = 'frequencyName' + iteration;
		  e31.size = '10';
		  e31.value=document.getElementById('frequencyName'+rowVal).value;
		  cellRight31.appendChild(e31);
		  
		  var cellRight32 = row.insertCell(10);
		  var e32 = document.createElement('input');
		  e32.type = 'text';
		  e32.name = 'noOfDays' + iteration;
		  e32.id = 'noOfDays' + iteration;
		  e32.size = '5';
		  e32.value=document.getElementById('noOfDays'+rowVal).value;
		  cellRight32.appendChild(e32);

		 /*  var cellRight33 = row.insertCell(9);
          var e33 = document.createElement('input');
		  e33.type = 'text';
		  e33.name = 'intake' + iteration;
		  e33.id = 'intake' + iteration;
		  e33.size = '5';
		  e33.value=document.getElementById('intake'+rowVal).value;
		  cellRight33.appendChild(e33); */

		 
		  var cellRight6 = row.insertCell(11);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'stockAvailable' + iteration;
		  e6.id = 'stockAvailable' + iteration;
		  e6.size = '6';
		  e6.readOnly=true;
		  cellRight6.appendChild(e6);
		  
		  var cellRight6 = row.insertCell(12);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'totalDispensary' + iteration;
		  e6.id = 'totalDispensary' + iteration;
		  e6.size = '6';
		  e6.readOnly=true;
		  e6.value=document.getElementById('totalDispensary'+rowVal).value;
		  cellRight6.appendChild(e6);

     
		  var cellRight36 = row.insertCell(13);
		  var e36 = document.createElement('input');
		  e36.type = 'text';
		  e36.name = 'qtyStock' + iteration;
		  e36.id = 'qtyStock' + iteration;
		  e36.size = '6';
		  e36.setAttribute("readOnly", "readOnly");
		  e36.value=document.getElementById('qtyStock'+rowVal).value;
		  cellRight36.appendChild(e36);

		 /*  var cellRight71 = row.insertCell(15);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name = 'lotOut' + iteration;
		  e71.id = 'lo' + iteration;
		  e71.value='lo';
		  e71.onblur = function(){checkForIssue(iteration)};
		  cellRight71.appendChild(e71);

		
		  var cellRight37 = row.insertCell(16);
		  var e37 = document.createElement('input');
		  e37.type = 'text';
		  e37.name = 'lotQty' + iteration;
		  e37.id = 'lotQty' + iteration;
		  e37.size = '6';
		  cellRight37.appendChild(e37);


		  var cellRight38 = row.insertCell(17);
		  var e38 = document.createElement('input');
		  e38.type = 'checkbox';
		  e38.name = 'lp' + iteration;
		  e38.id = 'lp' + iteration;
		  e38.value='lp';
		  e38.onclick = function(){changeCheckBoxValue(iteration);checkForIssue(iteration);};
		  cellRight38.appendChild(e38);

		  var cellRight39 = row.insertCell(18);
		  var e39 = document.createElement('input');
		  e39.type = 'text';
		  e39.name = 'lpQty' + iteration;
		  e39.id = 'lpQty' + iteration;
		  e39.size = '6';
		 // e39.setAttribute("validate","lpQty,string,yes")
		  cellRight39.appendChild(e39); */


		  var cellRight40 = row.insertCell(14);
		  var e40 = document.createElement('input');
		  e40.type = 'text';
		  e40.name = 'remark' + iteration;
		  e40.id = 'remark' + iteration;
		  e40.size = '10';
		  cellRight40.appendChild(e40);

		  var cellRight41 = row.insertCell(15);
		  /* var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.name="b1"
		  e41.className = 'buttonAdd';
		  e41.setAttribute('tabindex', 1); 
		  e41.onclick = function(){addRowForDirectPrescription()};
		  cellRight41.appendChild(e41); */
		  
		  
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.name="b1"		
		  e41.className = 'buttonDel';
		  e41.setAttribute('tabindex', 1); 
		  e41.onclick = function(){removeRowPrescription(this, iteration)};
		  cellRight41.appendChild(e41);
		  
		 document.getElementById('listsize').value=listSize;
		 return flag;
	}
	
/* 	function removeRowPrescription()
	{
		var dcre=document.getElementById('listsize').value;
		dcre=(parseInt(dcre))-1;
		document.getElementById('listsize').value=dcre;
	  var tbl = document.getElementById('stockDetails');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('stockDetails');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	} */
	
	
	function removeRowPrescription(element, rowNum)
	{
		
		 var tbl = document.getElementById('stockDetails');
		 var listsize = document.getElementById('listsize').value;
		 var itemId = document.getElementById('itemId'+rowNum).value;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(element.parentNode.parentNode.rowIndex);
	  	
	  	for(var i=listsize; i>=1; i--)
	  		{
	  		if(document.getElementById('qtyIssued'+i) != null && document.getElementById('itemId'+i).value == itemId)
	  			{
	  			document.getElementById('qtyIssued'+i).readOnly="false";
	  			break;
	  			}
	  		}
	  	
	
	  }
	}
	
	
	function checkDublicateBatch(rowVal)
	{		
		if(document.getElementById('stockDetails')!=null)
		{
		var trlength = document.getElementById('listsize').value;
		
		for(var i=1; i<=trlength; i++)
		{
			if(rowVal != i)
				{
				
				if(document.getElementById('batchNo'+i)!=null && document.getElementById('batchNo'+rowVal).value==document.getElementById('batchNo'+i).value && document.getElementById('itemId'+rowVal).value==document.getElementById('itemId'+i).value)
				{
				alert("Batch already selected");
				document.getElementById('batchNo'+rowVal).value = 0;
				document.getElementById('stockAvailable'+rowVal).value = "";
				break;
				}
				
				}
	
			
		}
		}
	}
	
	function generateRow() {
		  var tbl = document.getElementById('issueGrid');
		  var lastRow = tbl.rows.length;
		  var deptId = document.getElementById('deptId').value;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  hdb.value=iteration


		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.size = '2';
		  e0.name='<%=SR_NO%>';
		  e0.readOnly=true;
		  e0.value=iteration;
		  cellRight0.appendChild(e0);


		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name='pvmsNo'+iteration;
		  e1.id = 'pvmsNo'+iteration;
		  e1.size='10';
		  e1.readOnly=true;
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='itemId'+iteration;
		  e11.id = 'itemId'+iteration;
		  cellRight1.appendChild(e1);
		  cellRight1.appendChild(e11);

		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name = 'nomenclature' + iteration;
		  e2.id = 'nomenclature' + iteration;
		  e2.size = '50';
		  e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};

		  var newdiv = document.createElement('div');
	   	  newdiv.setAttribute('id', 'ac2update'+iteration);
	   	  newdiv.style.display = 'none';
	   	  newdiv.className = "autocomplete";
		  cellRight2.appendChild(e2);
		  cellRight2.appendChild(newdiv);

		  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature'+iteration});



		  var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name = 'qtyIssued' + iteration;
		  e3.id = 'qtyIssued' + iteration;
		  e3.size = '10';
		  cellRight3.appendChild(e3);

	}

	function removeRow(idName,obj)
	{
		 var tbl = document.getElementById(idName);
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		    var i=obj.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
		  }
	
	}
	
	function submitProtoAjaxForBarcodeData(formName,action,rowVal)
	  {
		  //alert("submitProtoAjax");
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
		      if(xmlHttp.readyState==4)
			  {

		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	if(items.childNodes.length!=0)
			    {
		      	for (loop = 0; loop < items.childNodes.length; loop++)
			    {
			   	    var item = items.childNodes[loop];
			      //  var id  = item.getElementsByTagName("id")[0];
			        var pvms  = item.getElementsByTagName("pvms")[0];
			        var au  = item.getElementsByTagName("au")[0];
			        //var name  = item.getElementsByTagName("name")[0];
			       var batchNo=item.getElementsByTagName("batchNo")[0];
			       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
			       var availableStock=item.getElementsByTagName("availableStock")[0];
			       var expiryDate=item.getElementsByTagName("expiryDate")[0];
			       var brandId=item.getElementsByTagName("brandId")[0];
			       var costPrice=item.getElementsByTagName("costPrice")[0];
		        	
		        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
		        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
		        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
		        	document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
		        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
		        	document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
		        	document.getElementById("qtyIssued"+rowVal).focus();
		        	
		      	 }
		      	}
		      	else{
		      	/* 	 document.getElementById("barCodeNo"+rowVal).value="";
		      	alert("Invalid Barcode "); */
		     
		      	}
		      }
		    }
		    //var url=action+"&"+getNameAndData(formName)
			var url=action;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);

		  }
		 
	function calculatePendingQty(presQty,inc){
		if(presQty != ""){
			if(document.getElementById('qtyIssued'+inc).value != "" && document.getElementById('qtyIssued'+inc).value != "0"){{
				if(parseInt(document.getElementById('qtyIssued'+inc).value) <= parseInt(presQty)){
					document.getElementById('qtyPending'+inc).value =  parseInt(presQty) - parseInt(document.getElementById('qtyIssued'+inc).value);
				}else if(parseInt(document.getElementById('qtyIssued'+inc).value) > parseInt(presQty)){
					alert("Quantity Prescribed should be equal or greater than Quantity Issued.");
					document.getElementById('qtyPrescribed'+inc).value = parseInt(document.getElementById('qtyPrescribedHide'+inc).value);
					document.getElementById('qtyPending'+inc).value = parseInt(document.getElementById('qtyPrescribed'+inc).value)-parseInt(document.getElementById('qtyIssued'+inc).value);
					}
			}
			}else{
				document.getElementById('qtyPending'+inc).value =  parseInt(presQty)
			}
		}
	}
	function changeCheckBoxValue(rowValue)
	{ 
				
		if(document.getElementById('lp'+rowValue).checked==true)
		{	
			var  qtyPre=document.getElementById('qtyPrescription'+rowValue).value;
			var stockAva=document.getElementById('stockAvailable'+rowValue).value;
            var qtyIssued=document.getElementById('qtyIssued'+rowValue).value;
            if(parseInt(qtyPre) < parseInt(stockAva))
            { 
                if(parseInt(qtyIssued)<parseInt(qtyPre))
                {
                	 document.getElementById('lp'+rowValue).checked=false;
                	 document.getElementById('lpId'+rowValue).value="n";	
                    alert("Please Issue the Quantity");
                }
            }else                
            document.getElementById('lpId'+rowValue).value="y";	
                  
		    
		}	//alert("Hi doc "+document.getElementById('lp'+rowValue).value);
	}

	function checkSendForLP()
	{	var status=false;
		var listSize=document.getElementById('listsize').value;
		listSize=parseInt(listSize);
		
		for(var i=1;i<=listSize;i++)
		{
			var checkValue=document.getElementById('lpId'+i).value;
			//alert(checkValue);
		if(checkValue=="n")
		{
			status=false;
		}
		else
		{
			status=true;
			return status;
		}
		
		}
		//alert("status--"+status);
		if(status==false)
		{
		alert("please check atleast one send for LP");
		}
		return status;
	}
	function getDataForBarcode(val,rowVal)
	{
		
		if(val==0)
		{
		document.getElementById("qtyIssued"+rowVal).value = "";
		document.getElementById("qtyIssued"+rowVal).readOnly = "readOnly";
		
		}
	else
		{
		document.getElementById("qtyIssued"+rowVal).readOnly = "";
		  var itemId=document.getElementById('itemId'+rowVal).value;
	        document.getElementById("qtyIssued"+rowVal).readOnly=false;
			/* submitProtoAjaxForBarcodeData('opdPatientIssue','stores?method=getDataForBarcodeDispensary&barCode='+val+'&itemId='+itemId,rowVal); */
	        submitProtoAjaxForBarcodeData('opdPatientIssue','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
		}
		
      
	}	
		
	function checkQty(rowVal)
	{
			if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyPrescription'+rowVal).value))
			{
				alert("Issued Quantity Can't be greater than Quantity Prescribed.");
				document.getElementById('qtyIssued'+rowVal).value="";
				document.getElementById("qtyIssued"+rowVal).focus();
			}
			if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('stockAvailable'+rowVal).value))
			{
				alert("Issued Quantity Can't be greater than Available Quantity.");
				document.getElementById('qtyIssued'+rowVal).value="";
				document.getElementById("qtyIssued"+rowVal).focus();
			}
	}	
	function checkQtyValue()
	{
		var size=parseInt(document.getElementById('listsize').value);
		for(var i=1;i<=size;i++)
		{
			if(document.getElementById('qtyIssued'+i).value=="")
			{		
				alert("Issued Quantity Can't be Blank.");
                return false;
			}
			
		}
		return true;
	}
-->
</script>
<script type="text/javascript">
	// Main vBulletin Javascript Initialization
	vBulletin_init();
</script>


<script type="text/javascript">
// This Method for Check NIS and get confirmation of Issue.
<%-- function fillPrescribeBy() 
{
	var itemArray = new Array();
	var trlength = 0;
	var addflag = true;
	if(document.getElementById('stockDetails')!=null)
		{
		trlength = document.getElementById('listsize').value;
		}
	for(i=1;i<=trlength;i++){
		addflag = true;
		if(document.getElementById('itemId'+i)!=null){
			for(var j=0; j<itemArray.length; j++)
				{
				if(document.getElementById('itemId'+i).value==itemArray[j])
					{
					addflag=false;
					}
				}
			if(addflag)
				{
				itemArray[itemArray.length]=document.getElementById('itemId'+i).value;
				}
		}
		}

	var issueQty =0;
	var prescribeQty = 0;
	var stockDispensary = 0;
	var presFlag = true;
	var msg = '';
	var flag = true;
	var nomenclature = ""; 
	var stockFlag = true;
	
	if(<%=empStatusCodeForContract%> != document.getElementById("empStatus").value)
	{
	
	 if(true)
		{
	for(j=0;j<itemArray.length;j++){
		
		issueQty =0;
		prescribeQty = 0;
		presFlag = true;
		stockDispensary=0;
		
		
		for(i=1;i<=trlength;i++){
			
		if(document.getElementById('itemId'+i)!=null && document.getElementById('itemId'+i).value == itemArray[j]){

			nomenclature = document.getElementById('nomenclature'+i).value;
			if(document.getElementById('qtyIssued'+i).value.trim()!="")
				{
				issueQty += parseInt(document.getElementById('qtyIssued'+i).value);
				}
			 
			  if(presFlag)
				  {
			  prescribeQty = parseInt(document.getElementById('qtyPrescription'+i).value);
			  stockDispensary = parseInt(document.getElementById('stockDispensary'+i).value);
			  presFlag = false;
				  }
			  
		}
		}
		
			if(issueQty==null || issueQty==''){
				if(prescribeQty!=issueQty) {
				if(stockDispensary<prescribeQty)
				{
				if(flag){msg = 'Do You Want to Generat NIS of:\n---------------------------------------------\n'}
				flag = false;
				var temp = msg.search(nomenclature);
					if(temp ==-1)
						msg += nomenclature+'\n';
					}
				else
					{
					stockFlag=false;
					alert("Enough Stock Available for "+nomenclature+" in Dispensary");
					
					}
			}
			}else{
				if(prescribeQty!=issueQty) {
				if(prescribeQty!=issueQty && stockDispensary<prescribeQty)
				{
				/* var prescribeQty = parseInt(document.getElementById('qtyPrescription'+i).value); */
				var iQty = parseInt(issueQty);
				if(prescribeQty>iQty){
					if(flag){msg = 'Do You Want to Generat NIS of:\n---------------------------------------------\n'}
					flag = false;
					
					var temp = msg.search(nomenclature);
					if(temp ==-1)
						msg += nomenclature+'\n';
				}
			}
			else
				{
				stockFlag=false;
				alert("Enough Stock Available for "+nomenclature+" in Dispensary");
				}
				
			}
			}
		
		}
}
	if(stockFlag)
		{
		if(msg=='')
			msg += 'Do You Want To Save?';
		var saveFlag = confirm(msg);
		if(saveFlag){
			fillItemsInGrid();submitForm('opdPatientIssue','stores?method=submitOPDPatientStockDetailsByHin&facFlag=FAC');
		}
}
} --%>

function fillPrescribeBy() 
{
	var itemArray = new Array();
	var trlength = 0;
	var addflag = true;
	if(document.getElementById('stockDetails')!=null)
		{
		trlength = document.getElementById('listsize').value;
		}
	for(i=1;i<=trlength;i++){
		addflag = true;
		if(document.getElementById('itemId'+i)!=null){
			for(var j=0; j<itemArray.length; j++)
				{
				if(document.getElementById('itemId'+i).value==itemArray[j])
					{
					addflag=false;
					}
				}
			if(addflag && document.getElementById('itemType'+i).value != 'nip')
				{
				itemArray[itemArray.length]=document.getElementById('itemId'+i).value;
				}
		}
		}
	var issueQty =0;
	var prescribeQty = 0;
	var stockDispensary = 0;
	var presFlag = true;
	var msg = '';
	var flag = true;
	var nomenclature = "";
	var stockFlag = true;
	
	<%-- if(<%=empStatusCodeForContract%> != document.getElementById("empStatus").value)
	{ --%>
	if(true)
	{
	for(j=0;j<itemArray.length;j++){
		
		issueQty =0;
		prescribeQty = 0;
		presFlag = true;
		stockDispensary=0;
		
		
		
		for(i=1;i<=trlength;i++){
			
		if(document.getElementById('itemId'+i)!=null && document.getElementById('itemId'+i).value == itemArray[j]){

			nomenclature = document.getElementById('nomenclature'+i).value;
			if(document.getElementById('qtyIssued'+i).value.trim()!="")
				{
				issueQty += parseInt(document.getElementById('qtyIssued'+i).value);
				}
			 
			  if(presFlag)
				  {
			  prescribeQty = parseInt(document.getElementById('qtyPrescription'+i).value);
			  stockDispensary = parseInt(document.getElementById('stockDispensary'+i).value);
			  presFlag = false;
				  }
			  
		}
		}
		
			if(issueQty==null || issueQty==''){
				if(prescribeQty!=issueQty) {
					if(stockDispensary<prescribeQty)
					{
				if(flag){
					msg = 'Do You Want to Generat NIS of:\n---------------------------------------------\n'
					}
				flag = false;
				var temp = msg.search(nomenclature);
					if(temp ==-1)
						msg += nomenclature+'\n';
					}
					else
						{
						stockFlag=false;
						alert("Enough Stock Available for "+nomenclature+" in Dispensary");
						
						}
				}
			}else{
				if(prescribeQty!=issueQty) {
					if(prescribeQty!=issueQty && stockDispensary<prescribeQty)
					{
				/* var prescribeQty = parseInt(document.getElementById('qtyPrescription'+i).value); */
				var iQty = parseInt(issueQty);
				if(prescribeQty>iQty){
					if(flag){
						msg = 'Do You Want to Generat NIS of:\n---------------------------------------------\n'
						}
					flag = false;
					
					var temp = msg.search(nomenclature);
					if(temp ==-1)
						msg += nomenclature+'\n';
				}
			}
			else
				{
				stockFlag=false;
				alert("Enough Stock Available for "+nomenclature+" in Dispensary");
				}
				
			}
			}
		
		}
}
	if(stockFlag)
	{
		if(msg=='')
			msg += 'Do You Want To Save?';
		var saveFlag = confirm(msg);
		if(saveFlag){
			fillItemsInGrid();submitForm('opdPatientIssue','stores?method=submitOPDPatientStockDetailsByHin&facFlag=FAC');
		}
	}
}
function fillPrescribeByNext()
{
	if(document.getElementById('prescribBy').value=='')
	{
		alert("Please fill prescribed by");
		return false;
	}else
		{
		submitForm('opdPatientIssue','stores?method=showNextOPDPatientIssue');
		}
}
</script>

<script type="text/javascript">

function fillItem(val,inc)
{

	var val=document.getElementById('itemId'+inc).value;
    ajaxFunctionForAutoCompleteBatchToItem('opdPatientIssue','stores?method=fillBatchForIssueToPatient&pvmsNo=' +  val , inc);
}

function ajaxFunctionForAutoCompleteBatchToItem(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var batchLength  = item.getElementsByTagName("batches")[0];
		     
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }




function enableQtyField(obj,txtFieldId){
	if(obj.checked){
		document.getElementById(txtFieldId).readOnly=false;
	}else{
		document.getElementById(txtFieldId).value="";
		document.getElementById(txtFieldId).readOnly=true;
	}
	
}

function addRowForDirectPrescription()
{
	
	  var tbl = document.getElementById('stockDetails');
	  var lastRow = tbl.rows.length;
	  var deptId = document.getElementById('deptId').value;
	  var listSize=document.getElementById('listsize').value;
	  listSize=(parseInt(listSize))+1;
/*	  var iteration = lastRow;
	
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration*/


	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
		  


	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo'+iteration;
	  e1.id = 'pvmsNo'+iteration;
	  e1.size='10';
	  //e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;

	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	  //e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);


	  
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.setAttribute('tabindex', '4');
	  
	  
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2update'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature'+iteration});
	  e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
		
	  cellRight2.appendChild(e2);

	  var cellRight21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'au' + iteration;
	  e21.id = 'au' + iteration;
	  e21.size = '7';
	  e21.readOnly=true;
	  cellRight21.appendChild(e21);


	  var cellRight22 = row.insertCell(4);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'barCodeNo' + iteration;
	  e22.id = 'barCodeNo' + iteration;
	  e22.size = '8';
	  e22.onblur = function(){getDataForBarcode(this.value,iteration); checkDublicateBatch(iteration);};
	  e22.onchange=function(){getDataForBarcode(this.value,iteration); checkDublicateBatch(iteration);};
	  cellRight22.appendChild(e22);

	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('Select');
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  //e23.setAttribute('validate', 'Batch No,string,yes');
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.className="small3"
	  e23.onchange=function(){getDataForBarcode(this.value,iteration); checkDublicateBatch(iteration);};
	  cellRight23.appendChild(e23);
	  
	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	
	  cellRight23.appendChild(e24);
	  	  
	  var cellRight25 = row.insertCell(6);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;
	  var e26 = document.createElement('input');
	  e26.type = 'hidden';
	  e26.name = 'costPrice' + iteration;
	  e26.id = 'costPrice' + iteration;
	  e26.size = '10';
	  cellRight25.appendChild(e25);
	  cellRight25.appendChild(e26);
	  
	  
	  var cellRight3 = row.insertCell(7);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'strength' + iteration;
	  e3.id = 'strength' + iteration;
	  e3.size = '5';
	  //e3.value=document.getElementById('strength'+rowVal).value;
	 
	  cellRight3.appendChild(e3);
	 

	  var cellRight31 = row.insertCell(8);
     var e31 = document.createElement("select");
    
     //element5.type = "text";
     e31.name="frequencyName"+iteration;
     e31.id="frequencyName"+iteration;
     e31.setAttribute('tabindex', '1');
     e31.options[0] = new Option('Select Frequency', '0');
      <%
      
       for(MasFrequency masFrequency :frequencyList)
       { %>
     	  var choice = document.createElement('option');
	  			choice.value ='<%=masFrequency.getFeq()%>';
	  			choice.appendChild(document.createTextNode('<%=masFrequency.getFrequencyName()%>'));
				e31.appendChild(choice);
				
		<%}%>
		
		e31.onblur=function(){getFrequencyValue(this.value,iteration);};
		cellRight31.appendChild(e31);

		var e32 = document.createElement('input');
		  e32.type = 'hidden';
		  e32.name='frequencyValue'+iteration;
		  e32.id='frequencyValue'+iteration;
		  e32.size='5';
		  e32.setAttribute('tabindex','1');
		  cellRight31.appendChild(e32);
		  
	  var cellRight32 = row.insertCell(9);
	  var e32 = document.createElement('input');
	  e32.type = 'text';
	  e32.name = 'noOfDays' + iteration;
	  e32.id = 'noOfDays' + iteration;
	  e32.size = '5';
	  e32.onblur = function(){setTotal(iteration);};
	  cellRight32.appendChild(e32);

	  var cellRight33 = row.insertCell(10);
     var e33 = document.createElement('input');
	  e33.type = 'text';
	  e33.name = 'intake' + iteration;
	  e33.id = 'intake' + iteration;
	  e33.size = '6';
	  e33.value="";
	  cellRight33.appendChild(e33);

	  var cellRight34 = row.insertCell(11);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'qtyPrescription' + iteration;
	  e34.id = 'qtyPrescription' + iteration;
	  e34.readOnly=true;
	  e34.size = '6';
	 
	 	   
	   cellRight34.appendChild(e34);
	  
	  var cellRight6 = row.insertCell(12);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.size = '6';
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);
	  
	  var cellRight35 = row.insertCell(13);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '6';
	  e35.onblur = function(){checkQty(iteration);checkForIssue(iteration);};
	  cellRight35.appendChild(e35);

	  var cellRight36 = row.insertCell(14);
	  var e36 = document.createElement('input');
	  e36.type = 'text';
	  e36.name = 'qtyStock' + iteration;
	  e36.id = 'qtyStock' + iteration;
	  e36.size = '6';
	  e36.onblur = function(){checkQty(iteration)};
	  cellRight36.appendChild(e36);

	  var cellRight71 = row.insertCell(15);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name = 'lotOut' + iteration;
	  e71.id = 'lo' + iteration;
	  e71.value='lo';
	  e71.onblur = function(){checkForIssue(iteration)};
	  cellRight71.appendChild(e71);

	
	  var cellRight37 = row.insertCell(16);
	  var e37 = document.createElement('input');
	  e37.type = 'text';
	  e37.name = 'lotQty' + iteration;
	  e37.id = 'lotQty' + iteration;
	  e37.size = '6';
	  cellRight37.appendChild(e37);


	  var cellRight38 = row.insertCell(17);
	  var e38 = document.createElement('input');
	  e38.type = 'checkbox';
	  e38.name = 'lp' + iteration;
	  e38.id = 'lp' + iteration;
	  e38.value='lp';
	  e38.onclick = function(){changeCheckBoxValue(iteration);checkForIssue(iteration);};
	  cellRight38.appendChild(e38);

	  var cellRight39 = row.insertCell(18);
	  var e39 = document.createElement('input');
	  e39.type = 'text';
	  e39.name = 'lpQty' + iteration;
	  e39.id = 'lpQty' + iteration;
	  e39.size = '6';
	  cellRight39.appendChild(e39);


	  var cellRight40 = row.insertCell(19);
	  var e40 = document.createElement('input');
	  e40.type = 'text';
	  e40.name = 'remark' + iteration;
	  e40.id = 'remark' + iteration;
	  e40.size = '10';
	  cellRight40.appendChild(e40);

	  var cellRight41 = row.insertCell(20);
	  var e41 = document.createElement('input');
	  e41.type = 'button';
	  e41.name="b1"
	  e41.className = 'buttonAdd';
	  e41.setAttribute('tabindex', 1); 
	  e41.onclick = function(){addRowForDirectPrescription()};
	  cellRight41.appendChild(e41);

	  var cellRight42 = row.insertCell(21);
	  var e42 = document.createElement('input');
	  e42.type = 'button';
	  e42.name='delete'+iteration;
	  e42.setAttribute('tabindex', 1); 
	  e42.className = 'buttonDel';
	  e42.onclick= function(){removeRow('stockDetails',this);};
	  cellRight42.appendChild(e42);

	 document.getElementById('listsize').value=listSize;
}

function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency masFrequency :frequencyList){
%>
 if(feqValue == '<%=masFrequency.getId()%>'){
	 feqQty = '<%=masFrequency.getFeq()%>'
	
  }

<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}
function setTotal(inc){
	
	var totalQty=0;
	var noOfDays=parseFloat(document.getElementById('noOfDays'+inc).value);
	
	var frequencyName=parseFloat(document.getElementById('frequencyValue'+inc).value);
	
	var strength=parseFloat(document.getElementById('strength'+inc).value);
	if(!isNaN(strength)){
	if(!isNaN(noOfDays) && !isNaN(frequencyName)){	
		totalQty=(noOfDays*frequencyName*strength).toFixed(2);
	   }
	}else{
		   totalQty=(noOfDays*frequencyName*1).toFixed(2);
	   }
	
	document.getElementById('qtyPrescription'+inc).value=Math.ceil(totalQty); 	
}

function getDataForBarBatchStockId(val,rowVal)
{
	   var itemId=document.getElementById('itemId'+rowVal).value;
    // javed khan on 07-08-2013
    if(validateMetaCharacters(val)){
    	submitProtoAjaxForBarBatchStockId('issueDispensaryForm','stores?method=getDataForBarBatchStockId&stockId='+val+'&itemId='+itemId,rowVal);
	}else{
	    return false;
	}
	
}

function fillBatchforStockId(val,inc)
{

	var val=document.getElementById('itemId'+inc).value;
    ajaxFunctionForAutoCompleteBatchStockId('depCiv','stores?method=fillBatchforStockId&pvmsNo=' +  val , inc);
}


 

function ajaxFunctionForAutoCompleteBatchStockId(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var batchLength  = item.getElementsByTagName("batches")[0];
		     
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var decodedString = atob(batch.getElementsByTagName("batchName")[0].childNodes[0].nodeValue);
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=decodedString;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }


<%--function submitProtoAjaxForBarBatchStockId(formName,action,rowVal)
{
	 
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
	      if(xmlHttp.readyState==4)
		  {

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	//alert(batchId.childNodes[0].nodeValue);
	        	/* document.getElementById("batchNoValue"+rowVal).value=batchNo.childNodes[0].nodeValue; */
	        	/* document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue */;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	/* document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue; */
	        	
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	if(availableStock.childNodes[0].nodeValue>0){
	        		document.getElementById("qtyIssued"+rowVal).readOnly= false;
		        	document.getElementById("qtyIssued"+rowVal).focus();
	        	}
	        	
	        
	        	if(source.childNodes[0].nodeValue == "a"){
	        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        		document.getElementById("source"+rowVal).value="AFMSD";
	        	}
	        	if(source.childNodes[0].nodeValue == "L"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="LP";
		        	}
	        	if(source.childNodes[0].nodeValue =="-"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		/* document.getElementById("source"+rowVal).value="Open Bal."; */
		        	}
	        	/* document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue */;
	        	
	      	 }
	      	}
	      	else{
	      		 /* document.getElementById("barCodeNo"+rowVal).value=""; */
	      	alert("Stock Is not Available ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
--%>
function cheackForBatch(rowVal){
	
	   var flag = true;
	   if( document.getElementById('batchNo'+rowVal).value=='0')
		{
		document.getElementById('qtyIssued'+rowVal).value = "";
		document.getElementById('stockAvailable'+rowVal).value = "";
		document.getElementById("qtyIssued"+rowVal).readOnly = "readOnly";
		flag =false;
		}
	   else	if(rowVal>1){
		for(i=1;i<rowVal;i++){
			//alert(i+" --i- "+document.getElementById("batchNo"+i).value)
		/* 	if(document.getElementById("batchNo"+rowVal).value==document.getElementById("batchNo"+i).value)
			{
				alert("Please select another Batch !!!");
				document.getElementById("batchNo"+rowVal).value="0";
				return false;
			
			} */
			if(rowVal != i)
			{
			
			
			 if(document.getElementById('batchNo'+i)!=null && document.getElementById('batchNo'+rowVal).value==document.getElementById('batchNo'+i).value && document.getElementById('itemId'+rowVal).value==document.getElementById('itemId'+i).value)
			{
			alert("Batch already selected");
			document.getElementById('qtyIssued'+rowVal).value = "";
			document.getElementById('stockAvailable'+rowVal).value = "";
			flag =false;
			
			
			}
			 else
				 {
				 document.getElementById("qtyIssued"+rowVal).readOnly=false;
				 }
		}
		}
		
			
	}
		return flag;
}
	
function getDataForBarBatchStockId(val,rowVal)
{
	   var itemId=document.getElementById('itemId'+rowVal).value;
    // javed khan on 07-08-2013
    if(validateMetaCharacters(val)){
    	submitProtoAjaxForBarBatchStockId('issueDispensaryForm','stores?method=getDataForBarBatchStockId&stockId='+val+'&itemId='+itemId,rowVal);
	}else{
	    return false;
	}
	
}

<%--function fillBatchforStockId(val,inc)
{

	var val=document.getElementById('itemId'+inc).value;
    ajaxFunctionForAutoCompleteBatchStockId('depCiv','stores?method=fillBatchforStockId&pvmsNo=' +  val , inc);
}


 

function ajaxFunctionForAutoCompleteBatchStockId(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var batchLength  = item.getElementsByTagName("batches")[0];
		     
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	decodedString
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=decodedString;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  } --%>


function submitProtoAjaxForBarBatchStockId(formName,action,rowVal)
{
	 
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
	      if(xmlHttp.readyState==4)
		  {

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	//alert(batchId.childNodes[0].nodeValue);
	        	/* document.getElementById("batchNoValue"+rowVal).value=batchNo.childNodes[0].nodeValue; */
	        	/* document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue */;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	/* document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue; */
	        	
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	if(availableStock.childNodes[0].nodeValue>0){
	        		document.getElementById("qtyIssued"+rowVal).readOnly= false;
		        	document.getElementById("qtyIssued"+rowVal).focus();
	        	}
	        	
	        
	        	if(source.childNodes[0].nodeValue == "a"){
	        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        		document.getElementById("source"+rowVal).value="AFMSD";
	        	}
	        	if(source.childNodes[0].nodeValue == "L"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="LP";
		        	}
	        	if(source.childNodes[0].nodeValue =="-"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		/* document.getElementById("source"+rowVal).value="Open Bal."; */
		        	}
	        	/* document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue */;
	        	
	      	 }
	      	}
	      	else{
	      		 /* document.getElementById("barCodeNo"+rowVal).value=""; */
	      	alert("Stock Is not Available ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }

</script>
