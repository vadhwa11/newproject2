<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
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
<script type="text/javascript" language="javascript">
	<%
	
	

		Map map = new HashMap();
		int pageNo=1;
		

		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		List<StoreOpPatientIssueM> opPatientIssueList = new ArrayList<StoreOpPatientIssueM>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<Patient> patientList=new ArrayList<Patient>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		String consultationDate = (String)utilMap.get("currentDate");
		String consultationTime = (String)utilMap.get("currentTime");
		int deptId=0;
		int hospitalId=0;
		String timeInHHmm="";
		String [] temp = null;
		temp = currentTime.split(":");
		for (int i = 0 ; i < temp.length-1 ; i++) {

			
			
			
			timeInHHmm=timeInHHmm+(String)temp[i];
	    	 if(i==0)
	    	 {
	    		 timeInHHmm=timeInHHmm+":";
	    	 }
	   }
		Calendar calendar=Calendar.getInstance();
		String max="";
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
		
		if(map.get("max") != null)
		{
			max=(String)map.get("max");
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
		
		
		if(map.get("frequencyList") != null)
		{
			frequencyList=(List)map.get("frequencyList");
		}
		if(map.get("deptId")!=null){
			deptId=(Integer)map.get("deptId");
		}
		if(map.get("hospitalId")!=null){
			hospitalId=(Integer)map.get("hospitalId");			
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
		

		List opdIssueNo=(List)map.get("opdIssueNo");
		StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)opdIssueNo.get(0);
		String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	
		
		

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
<script type="text/javascript">
function disableOtherMedicine(val,inc){
		//alert("sdfsdfsd"+val+"inc==="+inc);
	  if(val != "")
		{
	   document.getElementById('otherMedicine'+inc).readOnly = true;		
	   document.getElementById('otherMedicine'+inc).value ="";
	   //document.getElementById('injCategory'+inc).disabled = true;	
	   
		}else{
			document.getElementById('otherMedicine'+inc).readOnly = false;
			//document.getElementById('injCategory'+inc).disabled = false;	

		}
	}
</script>
<div class="titleBg">
<h2>Medicine Return</h2>
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

<form name="opdPatient" method="post" action="">
<div class="Clear">
</div>
<div class="Block">

<!-- <label> HIN</label> --> 
<input type="hidden" name="<%=HIN_NO%>" value="" tabindex="1" MAXLENGTH="30" readonly /> 
<!-- <label> HIN</label>-->
	<input type="hidden"
	name="<%=HIN_ID%>" id="hinNo" value="" tabindex="1" MAXLENGTH="30"
	onblur="if(checkHinNo()){submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');}" />


<input type="hidden" name="deptId" id="deptId" value="<%=deptId%>"> 
<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId%>"> 
<input	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"	value="<%=consultationTime%>" />
<input type="hidden" id="opdIssueno" name="opdIssueno" value="<%= opdIssuenoIncremented%>" />	
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>"  />
<input
	type="hidden" name="consultant" id="consultant" value="0"> <label>Service No.</label> <input type="text" id="serviceNo" name="serviceNo" value=""
	onblur="getHin(this.value);" tabindex="1" />
	
<div id="hinDiv">
<%--<label>HIN</label>
<select name="hinId" id="hinId">
	<option value="0">Select</option>
</select> --%>
</div>
<div id="patientDiv"><label>Patient Name</label> 
<input type="text" id="p_name" name="patientName" value="" tabindex="1" readonly"/>

<label>Relation</label> <input type="text" id="relation"
	name="relation" value="" tabindex="1" MAXLENGTH="30"
	validate="Relation,string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"
	onFocus="opdPatientIssue.reset();" /> <div class="Clear"></div>  
	
	
	<label>Rank</label> <input
	type="text" id="rank" name="rank" value="" tabindex="1" MAXLENGTH="30"
	validate="Rank, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"
	onFocus="opdPatientIssue.reset();" /> <label>Name</label> <input
	type="text" id="S_name" name="S_name" value="" tabindex="1" readonly"/>

<label>Unit</label>
<input type="text" id="unit" name="unit" value="" tabindex="1" MAXLENGTH="30" validate="Rank, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"
	onFocus="opdPatientIssue.reset();" /> 
	
	<div class="Clear"></div>
	
	<label>Age</label> <input
	type="text" id="age" name="age" value="" tabindex="1" MAXLENGTH="30"
	validate="Age, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"
	onFocus="opdPatientIssue.reset();" /> <label>Gender</label> <input
	type="text" id="sex" name="sex" value="" tabindex="1" MAXLENGTH="30"
	validate="Gender, string,yes"
	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"
	onFocus="opdPatientIssue.reset();" />

<label>MO</label>
 <input type="text" id="mo" name="mo" value=""
	tabindex="1" readonly"/></div>
	
	<%--
	<label>Diagnosis</label>
 <input type="text" id="DIAGNOSIS" name="DIAGNOSIS" value=""/> --%>
	
</div>
<input type="hidden" name="add" id="addbutton" value="Print"
	class="button"
	onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');"
	accesskey="g" /> <%


%>

<div class="clear paddingTop15" ></div>


<div class="Block">

<label>Medicine Return No.</label>
<input type="text" name="returnNo"  value="<%=max%>"/>
<label>Medicine Return Date</label>
<input type="text" name="returnDate" value="<%=currentDate %>"  id="returnDate" class="" />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.opdPatient.<%="returnDate"%>,event)" />


<div class="clear" ></div>




</div>

<div class="clear paddingTop15" ></div>

<div class="Clear paddingTop15"></div>

<div class="cmntable">
<table width="200px" colspan="7" id="grnDetails"
	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="8%">PVMS/NIV No.</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand</th>
			<th width="9%">Manufacturer</th>
			
			<th width="9%">Batch No.</th>
		    <th width="5%" colspan="2" >DOM</th>
			<th width="5%" colspan="2" >DOE</th>
			<th width="9%">Qty</th>
			<th width="5%">Remarks</th>
			<th width="8%">Add Row</th>
			<th scope="col">Delete Row</th>
			<%--<th width="9%">Source Of Supply</th>
			<th width="9%">Disposal</th>
			<th width="5%" colspan="2" >Date Of Disposal</th>
 --%>
			<!-- -For Smc
			<td width="15%"><label>Authy</label></td>

			<td width="9%"><label>Remarks</label></td> -->
		</tr>

	</thead>
	<tbody>


		<%
    	int detailCounter=10;
    	
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameBrand="nameBrand";
    	String idBrand="idBrand";
    	String idManufacturer="idManufacturer";
    	String idAu="idAu";
    	String batchNo="batchNo";
    	String batchNoTemp="batchNoTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	String amtVar="amtVar";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String amtVarTemp="amtVarTemp";
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String quantityInVar="quantityInVar";
      	String quantityInVarTemp="quantityInVarTemp";
      	String freeQty="freeQty";
    	String freeItem="freeItem";
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String nameManufacturer="nameManufacturer";
    	String remarks ="remarks";
    	String disposal ="disposal";
    	String remarksTemp="remarksTemp";
    	String authyDecTemp="authyDecTemp";
    	String authyDec="authyDec";
    	String disposalTemp ="disposalTemp";
    	String expiryDateTemp="expiryDateTemp";
    	String brandId="brandId";
    	String batchId="batchId";
    	String manufacturerIdTemp="manufacturerIdTemp";

    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameBrand2="nameBrand";
    	String idBrand2="idBrand";
    	String idAu2="idAu";
    	String freeItem2="freeItem";
    	String manufacturingDate2="manufacturingDate";
    	String expiryDate2="expiryDate";
    	String batchNo2="batchNo";
    	String batchNoTemp2="batchNoTemp";
    	String lotNoTemp2="lotNoTemp";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String discountVar2="discountVar";
    	String amtVar2="amtVar";
    	String quantityInVar2="quantityInVar";
    	String freeQty2="freeQty";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String amtVarTemp2="amtVarTemp";
    	String quantityInVarTemp2="quantityInVarTemp";
    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String manufacturerId2="manufacturerId";
    	String lotNo2="lotNo";
    	String shelfLife2 ="shelfLife";
    	String expiry2="expiry";
    	String remarks2 ="remarks";
    	String disposal2="disposal";
    	String remarksTemp2="remarksTemp";
    	String authyDecTemp2="authyDecTemp";
    	String authyDec2="authyDec";
    	String disposalTemp2="disposalTemp";
    	String idManufacturer2="idManufacturer";
    	String expiryDateTemp2="expiryDateTemp";
    	String manufacturingDateTemp2="manufacturingDateTemp";
    	String brandId2="brandId";
    	String batchId2="batchId";
    	String disposalDate="disposalDate";
    	String manufacturerIdTemp2="manufacturerIdTemp";

    	String nameManufacturer2="nameManufacturer";
    	if(pageNo!=1)
    	{
    		
    	}
     	 for(int inc=1;inc<=1;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameBrand=nameBrand2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		amtVar=amtVar2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		batchNoTemp=batchNoTemp2+(""+inc);
     		lotNo=lotNo2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		authyDecTemp=authyDecTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		amtVarTemp=amtVarTemp2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		idManufacturer=idManufacturer2+(""+inc);
     		batchId = batchId2+(""+inc);

     		incVar=incVar2+(""+inc);
     		freeQty=freeQty2+(""+inc);
     		freeItem=freeItem2+(""+inc);
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		expiry = expiry2+(""+inc);
     		remarks = remarks2+(""+inc);
     		remarksTemp =remarksTemp2+(""+inc);
     		nameManufacturer=nameManufacturer2+(""+inc);
     		disposal = disposal2+(""+inc);
     		disposalTemp = disposalTemp2+(""+inc);
     		authyDec = authyDec2+(""+inc);
     		expiryDateTemp =expiryDateTemp2+(""+inc);
     		manufacturingDate =manufacturingDateTemp2+(""+inc);
     		brandId = brandId2+(""+inc);
     		batchId=batchId2+(""+inc);
     		disposalDate=disposalDate+(""+inc);
     		manufacturerIdTemp = manufacturerIdTemp2+(""+inc);

    	  %>
		<tr>
			<input type="hidden" name="hdb" id="hdb" value="1" />
			<td width="5%"><input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="10" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" />
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			</td>
			<td width="10%">
			<input type="text" value="" id="<%=nameItem%>"  tabindex="1"
			onblur="checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');"
				name="<%=nameItem%>" size="50"/>
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script>
		</td>
			<td width="10%">
			<input type="text"  value="" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" size="7" tabindex="1" />
			<input type="hidden" value="0"  name="<%=EXPIRY%>" id="<%=expiry%>" /></td>
			
			
			<td width="10%">

			<input type="text" value="" id="bg<%=inc%>" size="2"  tabindex="1" name="bg"/>
			
			</td>
			
			
				<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId%>" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);"
				tabindex="1"><option value="0">Select</option>
						</select></td>
						
						
			<td width="10%"><input type="text" id="<%=manufacturerId %>" value="" tabindex="1" name="<%=MANUFACTURER_NAME %>"/>
			 <input	type="hidden" name="<%=MANUFACTURER_ID %>" value="0" id="<%=manufacturerIdTemp %>" tabindex="1" />
			</td>


		

				<td width="10%">
			    <input type="text" name="<%=BATCH_ID%>" id="<%=batchId%>" size="5"	tabindex="1">
				
			</td>


			<td width="10%">

			<input type="text" value="" id="manufacturingDate<%=inc%>"  size="10" name="<%=MANUFACTURING_DATE%>"  tabindex="1" />
			
			</td>
				<td>
				<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('manufacturingDate<%=inc%>'),event);" />
				<input type="hidden" value="<%=date%>" 	name="<%=DISPOSAL_DATE_D %>" id="<%=disposalDate %>" />
				</td>

			<td width="10%">

				<input type="text"
				 id="<%=expiryDate%>"  name="<%=EXPIRY_DATE%>"  size="10" tabindex="1" />

				
				

				</td>
				
				<td>
				<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate %>'),event);" />
				<input type="hidden" value="<%=date%>" 	name="<%=DISPOSAL_DATE_D %>" id="<%=disposalDate %>" />
				</td>

			<td width="10%"><input type="text" value="" size="4"
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRecTemp%>"
				 tabindex="1" /> 
			</td>
			
			
				<td><input type="text" size="20" value=" " name="remarks"
				id="remarks<%=inc%>" /></td>
			
			<td width="8%"><input name="Button" type="button"
				class="buttonAdd" value=""
				onclick="generateRowPrescription(<%=inc %>);" /></td>

			<td><input type="button" name="delete" value=""
				class="buttonDel" onclick="removeRow11();" tabindex="1" /></td>

<%--
		<td width="10%">
				<input type="text" value=" " name="<%=DISPOSAL%>" tabindex="1" id="<%=disposal%>" />
				</td>


				<td>
				<input type="text" size="15"	name="<%=DISPOSAL_DATE_D%>" value=" "	id="<%=disposalDate%>" readonly onblur=""	tabindex=1 />
				</td>
				<td>
				<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=disposalDate %>'),event);" />
				<input type="hidden" value="<%=date%>" 	name="<%=DISPOSAL_DATE_D %>" id="<%=disposalDate %>" />
				</td>
				<!--
				<td width="10%"><input type="text" value=""
				name="" id="<%=authyDecTemp%>" tabindex="1" maxlength="15"
				onblur="fillAuthyForDefectiveDrug(<%=inc%>)" /> <input type="hidden"
				value="0"  name="<%=AUTHY_UNDER_DECLARED %>"
				tabindex="1" id="<%=authyDec%>" /></td>






			<td width="10%"><input type="text" value=""
				name="" id="<%=remarksTemp%>" tabindex="1" maxlength="15"
				onblur="fillValuesInDefectiveDrug(<%=inc%>);" /> <input
				type="hidden" value="emptyString2"
				name="<%=REMARKS %>" tabindex="1" id="<%=remarks%>" /></td>  --%>
		</tr>
		<%
     	 }   %>

<input type="hidden" name="counter" id="listsize" value="1"/>
	</tbody>
</table>
</div>

<align ="right" />
</div>

<div class="clear paddingTop15"></div>

<input type="button" name="save" value="Save" class="button"
	onclick="submitForm('opdPatient','stores?method=submitMedicineReturn');" />

<input type="button" name="next" class="buttonBig" value="Next Prescription" /> 

<input type="button" name="add" id="addbutton"
	value="Print Previous Prescription" class="buttonBig"
	onClick="submitForm('opdPatient','stores?method=printPatientIssue','checkTargetForYes');"
	accesskey="g" />

</form>





<script type="text/javascript">


function getManufacturerNameByAjax(brandId,rowVal){
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
		        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
		        var mId  = item.getElementsByTagName("mId")[0];
	        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
	        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue

	      	}
	      }
	    }
	     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	 }


function checkForDefectiveDrugs(val,a,inc)
{

		
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);


		ajaxFunctionForAutoCompleteInDefectiveDrugs('opdPatient','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);

}

//defect Drugs
function ajaxFunctionForAutoCompleteInDefectiveDrugs(formName,action,rowVal) {

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
     
     	var brandId="brandId"+rowVal;
     	
		obj1 =document.getElementById(brandId); 
		
		
		obj1.length =1;
			
     	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];
	         var batchLength  = item.getElementsByTagName("batchs")[0];

	         var bg  = item.getElementsByTagName("BG")[0];
	     
       	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
       	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
       	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
       	
       	
       	
       
      
       	 for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
       		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	
	        	obj1.length++;
				obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;
	        	
       	}

        for(innerLoop = 0;innerLoop <bg.childNodes.length;innerLoop++){
       		var brandGeneric = bg.childNodes[innerLoop];
	        	var bgId  = brandGeneric.getElementsByTagName("brandGId")[0];
	        	var bgName  = brandGeneric.getElementsByTagName("brandGName")[0];
	        	
	        	
	        	document.getElementById('bg'+rowVal).value=bgName.childNodes[0].nodeValue;
				
	        	
       	}
       		
     	} 
     }
   }
   var url=action+"&"+getNameAndData(formName)
    
   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);
   
   
 }

function removeRow11()
{

    
	 var tbl = document.getElementById('grnDetails');
        var rowCount = tbl.rows.length;
        var gridSize=document.getElementById('hdb').value;

    	for(var i=rowCount-1; i>0; i++) 
        {
        	var row = tbl.rows[i];
            if(i>1)
            {
            	tbl.deleteRow(i);
              	document.getElementById('hdb').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;
          

        }
      
      
}
function generateRowPrescription(rowVal)
{
	var icdArray=new Array(); 
	icdArray[0]="Saab";       
	icdArray[1]="Volvo";
	icdArray[2]="BMW";
	  var tbl = document.getElementById('grnDetails');
	  var lastRow = tbl.rows.length;
	  //var deptId = document.getElementById('deptId').value;
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
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='10';
	  //e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;

	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='<%=ITEM_ID%>';
	  e11.id = 'idItem'+iteration;
	  //e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);


	  
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '50';
	  e2.setAttribute('tabindex', '4');
	  
	  
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2update'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=nomenclature'+iteration});
	  e2.onblur = function(){checkForDefectiveDrugs(this.value, 'nameItem'+iteration,iteration)};
		
	  cellRight2.appendChild(e2);





	 
	  	  var e11 = document.createElement('input');
	  	  e11.type = 'hidden';
	  	  e11.name='<%=EXPIRY%>';
	  	  e11.id='expiry'+iteration
	  	  e11.size='20';
	  	 
	  var cellRight21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = '<%=AV%>' 
	  e21.id = 'idAu' + iteration;
	  e21.size = '7';
	  e21.readOnly=true;
	  cellRight21.appendChild(e11);
	  cellRight21.appendChild(e21);


	  var cellRight55 = row.insertCell(4);
	  var e55 = document.createElement('input');
	  e55.type = 'text';
	  e55.name = 'bg';
	  e55.id = 'bg' + iteration;
	  e55.size = '2';
	 
	  cellRight55.appendChild(e55);
	  

	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('Select');
	  e23.name = '<%=BRAND_ID%>';
	  e23.id = 'brandId' + iteration;
	  e23.options[0] = new Option('Select Brand', 'value0');
	  for(var i = 0;i<2;i++ )
	  {
	      e23.options[i+1] = new Option(icdArray[i],icdArray[i]);
	   }
	  e23.onchange=function(){getManufacturerNameByAjax(this.value,iteration);};
	  cellRight23.appendChild(e23);


	  
	  var e222 = document.createElement('input');
	  e222.type = 'hidden';
	  e222.name = '<%=MANUFACTURER_ID %>';
	  e222.id = 'manufacturerIdTemp' + iteration;
	  

	  var cellRight22 = row.insertCell(6);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = '<%=MANUFACTURER_NAME %>';
	  e22.id = 'manufacturerId' + iteration;
	  //e22.size = '8';
	  cellRight22.appendChild(e222);
	  cellRight22.appendChild(e22);
	  			 
	
	  var cellRight24 = row.insertCell(7);
	  var e24 = document.createElement('input');
	  e24.type = 'text';
	  e24.name = '<%=BATCH_ID%>' 
	  e24.id = 'batchId' + iteration;
	  e24.size = '5';
	  //e24.readOnly=true;
	  cellRight24.appendChild(e24);
	 
	 
	  	  
	  var cellRight9 = row.insertCell(8);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='<%=MANUFACTURING_DATE%>';
	  e9.id = 'manufacturingDate'+iteration;
	   e9.size='10'
	  cellRight9.appendChild(e9);


     var cellRight99 = row.insertCell(9);
     var eImg = document.createElement('img');
   	eImg.src = '/hms/jsp/images/cal.gif';
   eImg.name = '' ;
   eImg.id = '';
   eImg.WIDTH = '16';
   eImg.HEIGHT = '16';
   //eImg.id = 'billDateId'+iteration;
   eImg.onclick = function(event){
		  setdate('',document.getElementById('<%="manufacturingDate"%>'+iteration),event) };
   cellRight99.appendChild(eImg);

	  var cellRight110 = row.insertCell(10);
	  var e110 = document.createElement('input');
	  e110.type = 'text';
	  e110.name='<%=EXPIRY_DATE%>';
	  e110.id = 'expiryDate'+iteration;
	  e110.size='10'
	  cellRight110.appendChild(e110);
 
	  var cellRight999 = row.insertCell(11);
      var eImg1 = document.createElement('img');
   	  eImg1.src = '/hms/jsp/images/cal.gif';
      eImg1.name = '' ;
      eImg1.id = '';
      eImg1.WIDTH = '16';
      eImg1.HEIGHT = '16';
      //eImg.id = 'billDateId'+iteration;
      eImg1.onclick = function(event){
      setdate('',document.getElementById('<%="expiryDate"%>'+iteration),event) };
      cellRight999.appendChild(eImg1);


   	 
	  
	  var cellRight34 = row.insertCell(12);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = '<%=QUANTITY_RECEIVED%>' ;
	  e34.id = 'quanRecTemp' + iteration;
	  e34.size = '4';
	 
	  cellRight34.appendChild(e34);
	  
	
	  
	  var cellRight35 = row.insertCell(13);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'remarks';
	  e35.id = 'remarks' + iteration;
	  e35.size = '20';
	  cellRight35.appendChild(e35);


	  var cellRight41 = row.insertCell(14);
	  var e41 = document.createElement('input');
	  e41.type = 'button';
	  e41.name="b1"
	  e41.className = 'buttonAdd';
	  e41.setAttribute('tabindex', 1); 
	  e41.onclick = function(){generateRowPrescription(iteration)};
	  cellRight41.appendChild(e41);

	  var cellRight42 = row.insertCell(15);
	  var e42 = document.createElement('input');
	  e42.type = 'button';
	  e42.name='delete'+iteration;
	  e42.setAttribute('tabindex', 1); 
	  e42.className = 'buttonDel';
	  e42.onclick= function(){removeRow11()};
	  cellRight42.appendChild(e42);

	 document.getElementById('listsize').value=listSize;
}




function getHin(val)
{
	submitProtoAjaxforHinDetails('opdPatient','stores?method=getHinNoForDirectPriscription&serviceNo=' +val);
}
function getPatientDetails(val)
{
	submitProtoAjaxforPatientDetails('opdPatient','stores?method=getPatientDetailsForPatientDirectPriscription&hinId=' +val);
}

function submitProtoAjaxforHinDetails(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('hinDiv',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}


function submitProtoAjaxforPatientDetails(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('patientDiv',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}

function fillItemsInGrid(itemId,rowVal,deptId)
{
			//document.getElementById('empId').value=document.getElementById('consultant').value;
			//document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
			//document.getElementById('serviceNoNo').value=document.getElementById('serviceNo').value;;
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
			//document.getElementById('empId').value=document.getElementById('mo').value;
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

function ajaxFunctionForAutoCompleteOPDPatientInfo1(formName,action,rowVal) {
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
 			var batchNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(batchNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var pvmsNo  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var itemId  = item.getElementsByTagName("itemId")[0];
		       
		        var strength = item.getElementsByTagName("strength")[0];
				var totalQty = item.getElementsByTagName("totalQty")[0];
				var totalStockQty=item.getElementsByTagName("totalStockQty")[0];
				document.getElementById('pvmsNo'+rowVal).value = pvmsNo.childNodes[0].nodeValue
				document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
				
				if(strength.childNodes[0].nodeValue!="null")
				{
	        	document.getElementById('strength'+rowVal).value=strength.childNodes[0].nodeValue
				}
				else
				{
					document.getElementById('strength'+rowVal).value="";
				}
	        	document.getElementById('stockAvailable'+rowVal).value=totalQty.childNodes[0].nodeValue
	        	document.getElementById('qtyStock'+rowVal).value=totalStockQty.childNodes[0].nodeValue
	        	
	        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
	        	
				
				var batchs  = item.getElementsByTagName("batchs")[0];
	        	
	        	for(innerLoop = 0;innerLoop <batchs.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchs.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchNumber  = batch.getElementsByTagName("batchNumber")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchNumber.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchNumber.childNodes[0].nodeValue;
		        	
	        	}



				
				
	      	} 
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
}
	   

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
       // alert("1 ");
        if(val != "")
		{
	

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
		ajaxFunctionForAutoCompleteOPDPatientInfo1('opdPatient','stores?method=fillItemsInGridForOPDDir&itemId='+itemId , inc);
		//document.getElementById('empId').value=document.getElementById('consultant').value;
		//document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		//document.getElementById('itemId'+inc).value = itemId;
        //alert("3"); 
		//if(flag  != "prescription")
			//openPopup(itemId,deptId,inc);
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
			//alert("formname "+formname);
			//alert("rowVal "+rowVal);
			  // consultantName=eval('document.'+formname+'.consultingDoctor.value')
			 //  prescription=eval('document.'+formname+'.prescriptionNo.value')
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


	function generateRowPrescription11(rowVal)
	 {
		var icdArray=new Array(); 
		icdArray[0]="Saab";       
		icdArray[1]="Volvo";
		icdArray[2]="BMW";
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
		  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature'+iteration});
		  e2.onblur = function(){if(validateConsultant('opdPatient',iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}disableOtherMedicine(this.value,iteration);};
			
		  cellRight2.appendChild(e2);





		  var cellRight2 = row.insertCell(3);
		  	  var e11 = document.createElement('input');
		  	  e11.type = 'text';
		  	  e11.name='otherMedicine'+iteration;
		  	  e11.id='otherMedicine'+iteration
		  	  e11.size='20';
		  	  e11.setAttribute('tabindex','1');
		  	  e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
		  	  cellRight2.appendChild(e11);



		  

		  

		  var cellRight21 = row.insertCell(4);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name = 'au' + iteration;
		  e21.id = 'au' + iteration;
		  e21.size = '7';
		  e21.readOnly=true;
		  cellRight21.appendChild(e21);


		  var cellRight22 = row.insertCell(5);
		  var e22 = document.createElement('input');
		  e22.type = 'text';
		  e22.name = 'barCodeNo' + iteration;
		  e22.id = 'barCodeNo' + iteration;
		  e22.size = '8';
		  e22.onblur = function(){getDataForBarcode(this.value,iteration);};
		  e22.onchange=function(){getDataForBarcode(this.value,iteration);};
		  cellRight22.appendChild(e22);
		  			 
		

		  var cellRight23 = row.insertCell(6);
		  var e23 = document.createElement('Select');
		  e23.name = 'batchNo' + iteration;
		  e23.id = 'batchNo' + iteration;
		  e23.options[0] = new Option('Select Batch', 'value0');
		  for(var i = 0;i<2;i++ )
		  {
		      e23.options[i+1] = new Option(icdArray[i],icdArray[i]);
		   }
		  e23.onchange=function(){getDataForBarcode(this.value,iteration);};
		  cellRight23.appendChild(e23);
		  
		  
		  var e24 = document.createElement('input');
		  e24.type = 'hidden';
		  e24.name = 'brandId' + iteration;
		  e24.id = 'brandId' + iteration;
		  e24.size = '10';
		
		  cellRight23.appendChild(e24);
		  	  
		  var cellRight25 = row.insertCell(7);
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
		  
		  
		  var cellRight3 = row.insertCell(8);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name = 'strength' + iteration;
		  e3.id = 'strength' + iteration;
		  e3.size = '5';
		  //e3.value=document.getElementById('strength'+rowVal).value;
		 
		  cellRight3.appendChild(e3);
		  
		  
		 

		  var cellRight31 = row.insertCell(9);
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
		  			choice.value ='<%=masFrequency.getId()%>';
		  			choice.appendChild(document.createTextNode('<%=masFrequency.getFrequencyName()%>'));
					e31.appendChild(choice);
					
			<%}%>
			
        
			cellRight31.appendChild(e31);
		  
		  var cellRight32 = row.insertCell(10);
		  var e32 = document.createElement('input');
		  e32.type = 'text';
		  e32.name = 'noOfDays' + iteration;
		  e32.id = 'noOfDays' + iteration;
		  e32.size = '5';
		  e32.onblur = function(){setTotal(iteration);};
		  //e32.value=document.getElementById('noOfDays'+rowVal).value;
		  cellRight32.appendChild(e32);

		  var cellRight33 = row.insertCell(11);
          var e33 = document.createElement('input');
		  e33.type = 'text';
		  e33.name = 'intake' + iteration;
		  e33.id = 'intake' + iteration;
		  e33.size = '5';
		  e33.value=document.getElementById('intake'+rowVal).value;
		  cellRight33.appendChild(e33);

		  var cellRight34 = row.insertCell(12);
		  var e34 = document.createElement('input');
		  e34.type = 'text';
		  e34.name = 'qtyPrescription' + iteration;
		  e34.id = 'qtyPrescription' + iteration;
		  e34.size = '10';
		 
		 	   
		   cellRight34.appendChild(e34);
		  
		  var cellRight6 = row.insertCell(13);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'stockAvailable' + iteration;
		  e6.id = 'stockAvailable' + iteration;
		  e6.size = '10';
		  e6.readOnly=true;
		  cellRight6.appendChild(e6);
		  
		  var cellRight35 = row.insertCell(14);
		  var e35 = document.createElement('input');
		  e35.type = 'text';
		  e35.name = 'qtyIssued' + iteration;
		  e35.id = 'qtyIssued' + iteration;
		  e35.size = '10';
		  e21.onblur = function(){checkQty(iteration)};
		  cellRight35.appendChild(e35);

		  var cellRight36 = row.insertCell(15);
		  var e36 = document.createElement('input');
		  e36.type = 'text';
		  e36.name = 'qtyStock' + iteration;
		  e36.id = 'qtyStock' + iteration;
		  e36.size = '10';
		  e36.onblur = function(){checkQty(iteration)};
		  cellRight36.appendChild(e36);

		

     
		  var cellRight71 = row.insertCell(16);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name = 'lotOut' + iteration;
		  e71.id = 'lo' + iteration;
		  e71.value='lo';
		  cellRight71.appendChild(e71);

		
		  var cellRight37 = row.insertCell(17);
		  var e37 = document.createElement('input');
		  e37.type = 'text';
		  e37.name = 'lotQty' + iteration;
		  e37.id = 'lotQty' + iteration;
		  e37.size = '10';
		  cellRight37.appendChild(e37);


		  var cellRight38 = row.insertCell(18);
		  var e38 = document.createElement('input');
		  e38.type = 'checkbox';
		  e38.name = 'lp' + iteration;
		  e38.id = 'lp' + iteration;
		  e38.value='lp';
		  e36.onclick = function(){changeCheckBoxValue(iteration)};
		  cellRight38.appendChild(e38);

		  var cellRight39 = row.insertCell(19);
		  var e39 = document.createElement('input');
		  e39.type = 'text';
		  e39.name = 'lpQty' + iteration;
		  e39.id = 'lpQty' + iteration;
		  e39.size = '10';
		  cellRight39.appendChild(e39);


		  var cellRight40 = row.insertCell(20);
		  var e40 = document.createElement('input');
		  e40.type = 'text';
		  e40.name = 'remark' + iteration;
		  e40.id = 'remark' + iteration;
		  e40.size = '10';
		  cellRight40.appendChild(e40);

		  var cellRight41 = row.insertCell(21);
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.name="b1"
		  e41.className = 'buttonAdd';
		  e41.setAttribute('tabindex', 1); 
		  e41.onclick = function(){generateRowPrescription(iteration)};
		  cellRight41.appendChild(e41);

		  var cellRight42 = row.insertCell(22);
		  var e42 = document.createElement('input');
		  e42.type = 'button';
		  e42.name='delete'+iteration;
		  e42.setAttribute('tabindex', 1); 
		  e42.className = 'buttonDel';
		  e42.onclick= function(){removeRow('stockDetails')};
		  cellRight42.appendChild(e42);

		 document.getElementById('listsize').value=listSize;
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
		        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
		        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
		        	document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
		        	document.getElementById("qtyIssued"+rowVal).focus();
		        	
		      	 }
		      	}
		      	else{
		      		 document.getElementById("barCodeNo"+rowVal).value="";
		      	alert("Invalid Barcode ");
		     
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
	function getDataForBarcode(val,rowVal)
	{
		//alert("BarCode --"+val);

        var itemId=document.getElementById('itemId'+rowVal).value;

        //alert("itemId --"+itemId); 
		//alert("rowVal --"+rowVal);
		submitProtoAjaxForBarcodeData('opdPatient','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
	}	
		
	function checkQty(rowVal)
	{
			if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyPrescription'+rowVal).value))
			{
				alert("Issued Quantity Can't be greater than Quantity Prescribed.");
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
	function disableOtherMedicine(val,inc){
		//alert("sdfsdfsd"+val+"inc==="+inc);
	  if(val != "")
		{
	   document.getElementById('otherMedicine'+inc).readOnly = true;		
	   document.getElementById('otherMedicine'+inc).value ="";
	   //document.getElementById('injCategory'+inc).disabled = true;	
	   
		}
		else{
			document.getElementById('otherMedicine'+inc).readOnly = false;
			//document.getElementById('injCategory'+inc).disabled = false;	
		}
	}
</script>
<script type="text/javascript">
function setTotal(inc){
	
	var totalQty=0;
	var noOfDays=parseFloat(document.getElementById('noOfDays'+inc).value);
	var frequencyName=parseFloat(document.getElementById('frequencyName'+inc).value);
	var strength=parseFloat(document.getElementById('strength'+inc).value);
	
	if(!isNaN(noOfDays) && !isNaN(frequencyName)){	
		totalQty=noOfDays*frequencyName*strength;
	   }
	document.getElementById('qtyPrescription'+inc).value=totalQty;
	   	
}
</script>
<script type="text/javascript">
	// Main vBulletin Javascript Initialization
	vBulletin_init();
</script>
