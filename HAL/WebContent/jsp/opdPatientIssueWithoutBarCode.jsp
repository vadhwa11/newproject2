<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	 var nameArray=new Array();
	 var codeArray=new Array();
	</script>
<script type="text/javascript"	language="javascript">

	<%
		Map map = new HashMap();
		int pageNo=1;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
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
		if(prescriptionList.size() > 0){
			patient = prescriptionList.get(0).getHin();
		}
		int prescriptionId = 0;
		if(map.get("prescriptionId") != null){
			prescriptionId = (Integer)map.get("prescriptionId");
			//System.out.println("prescriptionId-"+prescriptionId);
		}
		String message="";
		if(map.get("message")!=null)
		{
			message=(String)map.get("message");
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>';

		<%
		    //System.out.println("checkNextRecord  ---"+checkNextRecord);
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
<!--<div class="Clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>

<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchForm" method="post" >
<label >Issue. No: </label>
<select name="<%=ISSUE_NO%>">
<option value="">Select Issue No</option>
	<%
for(int i=0;i<opPatientIssueList.size();i++)
{%>
	<option value="<%=opPatientIssueList.get(i).getId()%>"><%=opPatientIssueList.get(i).getIssueNo()%></option>
			<% } %>
		</select></td>
<input type="image" name="Submit" id="addbutton" value=" "	class="button" onClick="jsDisplay();" />
	
</form>
</div>
</div>
<div class="Clear"></div>
<form name="opdPatientIssue" method="post" action="">
<div class="Clear"></div>
<h4>Patient Issue</h4>
-->
<form name="opdPatientIssueWithBarCode" method="post" action="">
<div class="Clear"></div>
<div class="Block">
<%if(hinId != 0){ 
%>
<label> HIN</label>
<input type="text" name="<%=HIN_NO%>" value="<%=hinNo %>" tabindex="1"	 MAXLENGTH="30" readonly />
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" />
<%}else if(patient.getHinNo() != null){
	
%>
<label>HIN</label>
<input type="text" name="<%=HIN_NO%>" value="<%=patient.getHinNo()  %>" tabindex="1"	 MAXLENGTH="30" readonly />
<input type="hidden" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />
<%}else{ 
	
%>

<div id="hinDiv">
<label> HIN</label>
<input	type="text" name="<%=HIN_ID%>" id="hinNo" value="" tabindex="1"	 MAXLENGTH="30"	onblur="if(checkHinNo()){submitProtoAjax('opdPatientIssueWithBarCode','stores?method=showOPDPatientIssueGridWithoutBarCode');}" />
</div>
<%} %>
<%if(patient.getPFirstName() !=null && patient.getPLastName()!= null){ %>
<label> Patient Name</label>
<input	type="text" id="pName" name="pName" value="<%=patient.getPFirstName()+" "+patient.getPLastName()%>"  tabindex="1" readonly"/>
<%}else{ %>
<label> Patient Name</label>
<input	type="text" id="pName" name="pName" value="<%=patient.getPFirstName() %>"  tabindex="1" readonly"/>
<%} %>
<label>Relation</label>
<input	type="text" id="relation" name="relation" value="<%=patient.getRelation().getRelationName()%>"  tabindex="1" readonly"/>
<%if(hinId != 0){ %>
<label >Service No</label>
<input	type="text" id="serviceNo" name="serviceNo" value=""  tabindex="1" readonly"/>
<%}else if(patient.getServiceNo() != null){%>
<label >Service No</label>
<input	type="text" id="serviceNo" name="serviceNo" value="<%=patient.getServiceNo() %>"  tabindex="1" readonly"/>
<%}else{ %>

<label >Service No</label>
<input type="text"	id="serviceNo" name="serviceNo" value=""  tabindex="1" MAXLENGTH="30" validate="Service No,string,yes"	onblur="getHinNo('opdPatientIssueWithBarCode','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssueWithBarCode','stores?method=showOPDPatientIssueGridWithoutBarCode');"	onFocus="opdPatientIssueWithBarCode.reset();" />
<%} %>

<label>Rank</label>
<input	type="text" id="relation" name="relation" value="<%=patient.getRank().getRankName()%>"  tabindex="1" readonly"/>

<%
 if(patient.getServiceType() != null){%>
<!-- <label >Service Type</label>
<input	type="text" id="serviceType" name="serviceType" value="<%=patient.getServiceType().getServiceTypeName() %>"  tabindex="1" readonly"/>-->
<%}
  %>
  <div class="Clear"></div>
  <%if(patient.getSFirstName() != null && patient.getSLastName() !=null){ %>
  <label>Service Per Name</label>
<input	type="text" id="serPerName" name="serPerName" value="<%=patient.getSFirstName()+" "+patient.getSLastName()%>"  tabindex="1" readonly"/>
<%}else{ %>
<label>Service Per Name</label>
<input	type="text" id="serPerName" name="serPerName" value="<%=patient.getSFirstName()%>"  tabindex="1" readonly"/>
<%} %>
<label>Age</label>
<input	type="text" id="age" name="age" value="<%=patient.getAge()%>"  tabindex="1" readonly"/>
<label>Gender</label>
<input	type="text" id="gender" name="gender" value="<%=patient.getSex().getAdministrativeSexName()%>"  tabindex="1" readonly"/>

 <input type="hidden" name="pageNo" value="<%=pageNo %>" />
<input type="hidden" name="buttonFlag" value="<%=buttonFlag %>" />
<input type="hidden" name="issueNo" value="<%=issueNo %>" />
<input type="hidden" name="prescription" value="<%=prescription %>" />
<input type="hidden" name="consultantId" value="<%=consultantId %>" />

<!--<div class="Clear"></div>
<label class="noWidth">Date</label>
<input type="text" name="date"	value="<%=currDate %>" readonly />
<label class="noWidth">Time</label>
<input type="text" name="time"	value="<%=timeInHHmm %>" readonly />
--></div>

<div class="Clear"></div>

<input type="hidden" name="add"	id="addbutton" value="Print" class="button"	onClick="submitForm('opdPatientIssueWithBarCode','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" />

</form>

<div id="testDiv">
</div>
<script>
		<% if (hinId !=0) { %>
		   
			submitProtoAjax('opdPatientIssueWithBarCode','/hms/hms/stores?method=showOPDPatientIssueGridWithoutBarCode');
			
		<% 
		//System.out.println("(hinId !=0) ");
		}else if(patient.getId()!=null){ %>
		var prescriptionId ='<%=prescriptionId%>';
				submitProtoAjax('opdPatientIssueWithBarCode','/hms/hms/stores?method=showOPDPatientIssueGridWithoutBarCode&prescriptionId='+prescriptionId);
				
		<%
		//System.out.println("if(patient.getId()!=null) ");
		
		}%>
</script>

<script type="text/javascript"><!--

	function fillItemsInGrid(itemId,rowVal,deptId){
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;

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
			alert("nameArray[i][6]=="+nameArray[i][6])
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
		//alert("ddf")
		 newwindow=window.open(url,'name',"height=500,width=1010,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
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
	   var c=eval(document.opdPatientIssueWithBarCode.serviceNo);
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
       // alert("1 ");
        if(val != "")
		{
			// alert("2")
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
		//ajaxFunctionForAutoCompleteOPDPatient('opdPatient','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
		ajaxFunctionForAutoCompleteOPDPatientInfo('opdPatient','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
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
       //alert("itemId "+itemId);
       //alert("deptId "+deptId);
       //alert("rowVal "+rowVal);
      // alert("open popup rowVal "+rowVal) 
    	var patientPrescriptionId =0 ;
    	var serviceNo = document.getElementById('serviceNo').value;
    	var LoanOut="";
    	//alert("qtyPrescription "+document.getElementById('qtyPrescription'+rowVal).value);
    	var qtyPrescription = document.getElementById('qtyPrescription'+rowVal).value;
    	var nomenclature = document.getElementById('nomenclature'+rowVal).value;
    	if(document.getElementById('lo'+rowVal).checked==true)
        {
        	LoanOut="y";
        }
        else{
            LoanOut="n";
        }
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
	   		var url="/hms/hms/stores?method=showOPDStockDetailsJsp&itemId="+itemId+"&deptId="+deptId+"&rowVal="+rowVal+"&serviceNo="+serviceNo+"&nomenclature="+encodeURIComponent(nomenclature)+"&patientPrescriptionId="+patientPrescriptionId+"&qtyPrescription="+qtyPrescription+"&LoanOut="+LoanOut;
        	popwindow(url);
		}
     }

      function validateConsultant(formName,rowVal) {
          	alert(formName.name);
			formname=formName.name
			alert("formname "+formname);
			alert("rowVal "+rowVal);
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
		opdPatientIssueWithBarCode.method="post";
		//var url="/hms/hms/stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo="+OPDIssueNo;
		submitForm('searchForm','stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo='+OPDIssueNo+'&search=y');
    }


	function generateRowPrescription() {
		  var tbl = document.getElementById('stockDetails');
		  var lastRow = tbl.rows.length;
		  var deptId = document.getElementById('deptId').value;
		var listSize=document.getElementById('listsize').value;
		listSize=(parseInt(listSize))+1;
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
		  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
			
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
		  e3.name = 'strength' + iteration;
		  e3.id = 'strength' + iteration;
		  e3.size = '10';
		  e3.readOnly=true;
		  cellRight3.appendChild(e3);
		  
		  var cellRight31 = row.insertCell(4);
		  var e31 = document.createElement('input');
		  e31.type = 'text';
		  e31.name = 'frequencyName' + iteration;
		  e31.id = 'frequencyName' + iteration;
		  e31.size = '10';
		  cellRight31.appendChild(e31);
		  
		  var cellRight32 = row.insertCell(5);
		  var e32 = document.createElement('input');
		  e32.type = 'text';
		  e32.name = 'noOfDays' + iteration;
		  e32.id = 'noOfDays' + iteration;
		  e32.size = '10';
		  cellRight32.appendChild(e32);

		  var cellRight33 = row.insertCell(6);
          var e33 = document.createElement('input');
		  e33.type = 'text';
		  e33.name = 'intake' + iteration;
		  e33.id = 'intake' + iteration;
		  e33.size = '10';
		  cellRight33.appendChild(e33);

		  var cellRight34 = row.insertCell(7);
		  var e34 = document.createElement('input');
		  e34.type = 'text';
		  e34.name = 'qtyPrescription' + iteration;
		  e34.id = 'qtyPrescription' + iteration;
		  e34.size = '10';
		  e34.value='0'
		  cellRight34.appendChild(e34);
		  
		  
		  var cellRight35 = row.insertCell(8);
		  var e35 = document.createElement('input');
		  e35.type = 'text';
		  e35.name = 'qtyIssued' + iteration;
		  e35.id = 'qtyIssued' + iteration;
		  e35.size = '10';
		  cellRight35.appendChild(e35);
		 
		  var cellRight6 = row.insertCell(9);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'stockAvailable' + iteration;
		  e6.id = 'stockAvailable' + iteration;
		  e6.size = '10';
		  e6.readOnly=true;
		  cellRight6.appendChild(e6);

		  var cellRight7 = row.insertCell(10);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.name = 'issue';
		  e7.id = 'issue'+ iteration;
		  e7.value='Issue'
		  e7.className = 'button';
		  e7.onclick = function(){fillItemsInGrid();openPopup(document.getElementById('itemId'+iteration).value,deptId,iteration)};
		  cellRight7.appendChild(e7);
          
		  var cellRight71 = row.insertCell(11);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name = 'lp' + iteration;
		  e71.id = 'lp' + iteration;
		  e71.size = '10';
		  e71.onblur=function(){changeCheckBoxValue(iteration)};
		  cellRight71.appendChild(e71);
		  
		  var cellRight5 = row.insertCell(12);
		  var e5 = document.createElement('input');
		  e5.type = 'hidden';
		  e5.name = 'qtyPending' + iteration;
		  e5.id = 'qtyPending' + iteration;
		  e5.size = '10';
		  cellRight5.appendChild(e5);
		  
		  
		  var cellRight8 = row.insertCell(13);
		  var e8 = document.createElement('input');
		  e8.type = 'hidden';
		  e8.name = 'qtyPrescribed' + iteration;
		  e8.id = 'qtyPrescribed' + iteration;
		  e8.size = '10';
		  e8.value='0';
		  e8.onblur=function(){calculatePendingQty(this.value,iteration)};
		  cellRight8.appendChild(e8);	  

		  var cellRight9 = row.insertCell(14);
		  var e9 = document.createElement('input');
		  e9.type = 'hidden';
		  e9.name = 'lpId' + iteration;
		  e9.id = 'lpId' + iteration;
		  e9.size = '10';
		  e9.value='n';
		  cellRight9.appendChild(e9);
		  document.getElementById('listsize').value=listSize;


		  

		  
	}
	function removeRowPrescription()
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
		  e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};

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

	function removeRow()
	{
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
	}

	
	function submitProtoAjaxForBarcodeData(formName,action,rowVal)
	  {
		  alert("submitProtoAjax");
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
		      	if(items.childNodes.length!=0){
		      	for (loop = 0; loop < items.childNodes.length; loop++) {/*
			   	    var item = items.childNodes[loop];
			        var id  = item.getElementsByTagName("id")[0];
			        var pvms  = item.getElementsByTagName("pvms")[0];
			        var au  = item.getElementsByTagName("au")[0];
			        var name  = item.getElementsByTagName("name")[0];
			       var batchNo=item.getElementsByTagName("batchNo")[0];
			       var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
			       var availableStock=item.getElementsByTagName("availableStock")[0];
			       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		        	if(document.getElementById("codeItem"+rowVal).value!=""){

		        	if(pvms.childNodes[0].nodeValue==document.getElementById('codeItem'+rowVal).value){
		        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
		        	document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
		        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;

		        	document.getElementById("qtyIssued"+rowVal).readOnly=false;
		        	document.getElementById("qtyIssued"+rowVal).focus();
		        	}
		        	else{
		        	alert("The Barcode you entered is not For this item..");
		        	document.getElementById("barCodeNo"+rowVal).value="";
		        	}
		        	}
		        	else{
		        	document.getElementById("codeItem"+rowVal).value=pvms.childNodes[0].nodeValue;
		        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
		        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
		        	document.getElementById("nameItem"+rowVal).value=name.childNodes[0].nodeValue;
		        	document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
		        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
		        	}

		      	*/}
		      	}
		      	else{
		      	alert("There are No items for this Barcode ");
		      document.getElementById("barCodeNo"+rowVal).value="";
		      	}
		      }
		    }
		    var url=action+"&"+getNameAndData(formName)

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
	-->
</script>
<script type="text/javascript">
	// Main vBulletin Javascript Initialization
	vBulletin_init();
</script>
