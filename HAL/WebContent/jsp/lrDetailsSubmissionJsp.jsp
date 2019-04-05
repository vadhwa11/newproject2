<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="jkt.hms.masters.business.MasDeliveryType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%-- <%@page import="jkt.hms.masters.business.DeliveryDetails"%> --%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<title>Patient Details</title>
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
<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object>  utilMap = new HashMap<String,Object>();

	Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

	/* List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>(); */
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}

	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	
	if(map.get("inPatientList") != null){
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	}
	if(map.get("deliveryTypeList") != null){
		deliveryTypeList = (List<MasDeliveryType>)map.get("deliveryTypeList");
	}
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}

	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
%>

<div class="clear"></div>
<div class="titleBg">
<h2>Patient Details</h2>
</div>
<div class="clear"></div>
<%
	Inpatient inpatient = new Inpatient();
	Patient patient = new Patient();
   int hinId = 0;
	if(inPatientList != null && inPatientList.size() > 0){
		inpatient = inPatientList.get(0);
		patient = inpatient.getHin();
		hinId = patient.getId();
	%>

<div class="Block">
<form name="motherBabyDetails" method="post">
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<label>Employee No</label>
<%-- <input type="text" id="hiNumber" name="hiNumber" tabindex="1" value="<%=patient.getHinNo()%>" class="readOnly"	MAXLENGTH="30" onblur="if(validateHinNo(this.value)){submitProtoAjaxWithDivName('motherBabyDetails','/hms/hms/ipd?method=fillPatinetDetailsAjax&hinNo=<%=patient.getHinNo()%>','patientDetails');}" /> --%>
<label class="value"><%=patient.getServiceNo()%></label>
<%-- <input type="text" id="hiNumber" name="hiNumber" tabindex="1" value="<%=patient.getServiceNo()%>" class="readOnly" readonly="readonly"	MAXLENGTH="30" /> --%>
<input type="hidden" id="hinIdMother" name="hinIdMother" class="readOnly" tabindex="1" value="<%=patient.getId()%>" MAXLENGTH="30" />
<div id="patientDetails">
<label>Name</label>
<label class="value"><%=patient.getPFirstName()%> <%=patient.getPMiddleName()%> <%=patient.getPLastName()%></label>
<label>IPD No</label>
<label class="value"><%=inpatient.getAdNo()%></label>
<input type="hidden" id="<%=INPATIENT_ID%>" name="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" />
<input type="hidden"id="<%=HIN_ID%>" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />

<div class="clear"></div>
<label>Ward</label>
<label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>

<label>Age</label>
<% if(patient.getAge()!=null){%>
<label class="value"><%=patient.getAge()%></label>

<%}else{ %>
<label class="value"></label>
<%} %>
<label>Bed No.</label>
<%if(patient.getPatientType()!=null){ %>
<label class="value"><%=inpatient.getBed().getBedNo()%></label>
<%}else{ %>
<label class="value"></label>
<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<%-- <h4><span><%=message%></span></h4>
<h4><span><%=errorMessage%></span></h4> --%>
<h4>Delivery Notes</h4>

<label>Induction</label>
<select name="induction" id="induction">
<option value="">Select</option>
 <option>Cerviprime</option>
 <option>Misoprosior</option>
 <option>Syntocinon</option>
 <option>Stripping</option>
</select>
<label>Augmentation</label>
<select name="augment" id="augment">
<option value="">Select</option>
 <option>Syntocinon</option>
 <option>Epidosin</option>
 <option>Drotin</option>

</select>

<%-- <%if(patient.getBplStatus()!=null){ %>
<input type="hidden" id="bplStatus" name="bplStatus" class="readOnly" tabindex="1" value="<%=patient.getBplStatus()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="hidden" id="bplStatus" name="bplStatus" class="readOnly" tabindex="1" value="" MAXLENGTH="30" />
<%} %>
<%if(patient.getNotionalDobStatus()!=null){ %>
<input type="hidden" id="nationalDobStatus" name="nationalDobStatus" class="readOnly" tabindex="1" value="<%=patient.getNotionalDobStatus()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="hidden" id="nationalDobStatus" name="nationalDobStatus" class="readOnly" tabindex="1" value="" MAXLENGTH="30" />
<%} %> --%>
<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Delivery Details</h4>
<label>Term of Gestation</label>
<select name="termOfGestation" id="termOfGestation" validate="Term of Gestation,string,no">
<option value="">Select</option>
<option value="Term">Term</option>
<option value="Pre Term">Pre Term</option>
</select>

<!-- <label>Duration Of Delivery</label>
<select name="durationOfDelivery" id="durationOfDelivery" validate="Duration Of Delivery,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Prolonged">Prolonged</option>
<option value="Precipitated">Precipitated</option>
</select> -->

<!-- <label>Stage III</label>
<select name="stageThree" id="stageThree" validate="Stage III,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Prolonged">Prolonged</option>
</select> -->
<div class="clear"></div>
<label>Episiotomy</label>
<select name="episiotomy" id="episiotomy" validate="Episiotomy,string,no">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<label>Delivery Type</label>
<select name="deliveryType" id="deliveryType" validate="Episiotomy,string,no">
<option value="">Select</option>
<option>Spontaneous</option>
<option>Instrumental</option>
</select>

<label>Delivery Sub Type</label>
<select name="deliverySubType" id="deliverySubType" validate="Episiotomy,string,no">
<option value="">Select</option>
<option>Vaccum</option>
<option>Forceps</option>
</select>

<label>Anaesthesia</label>
<select name="anaesthesia" id="anaesthesia" validate="Anaesthesia,string,no">
<option value="">Select</option>
<option value="LA">LA</option>
<option value="Epidural">Epidural</option>
<option value="Spinal">Spinal</option>
<option value="General">General</option>
<option value="Nil">Nil</option>
</select>
<!-- <label><span>*</span> Perineal Tears</label>
<input type="text" id="perinealTears" name="perinealTears"	validate="Perineal Tears,string,no" tabindex="1" MAXLENGTH="250" />
<div class="clear"></div> -->
<label>Placenta & Membrane</label>
<select name="placentaAndMembranes" id="placentaAndMembranes" validate="Placenta,string,no">
<option value="">Select</option>
<option>Spontaneous</option>
<option>Expected</option>
<option>MRP</option>
<option>Adhere</option>
</select>

<!-- <label>Bleeding</label>
<select name="bleeding" id="bleeding" validate="Bleeding,string,no">
<option value="">Select</option>
<option value="Within normal limits">Within normal limits</option>
<option value="Excessive">Excessive</option>
<option value="Massive">Massive</option>
</select>

<label>Blood Transfusion</label>
<select name="bloodTransfusion" id="bloodTransfusion" validate="Bleeding,string,no">
<option value="">Select</option>
<option value="Not Required">Not Required</option>
<option value="Given">Given</option>
</select>

<div class="clear"></div>

<label>Suture Material</label>
<input type="text" id="sutureMaterial" name="sutureMaterial"	validate="Suture Material,string,no" tabindex="1" MAXLENGTH="250" />

<label>State Of Uterus</label>
<select name="stateOfUterus" id="stateOfUterus" validate="State Of Uterus,string,no">
<option value="">Select</option>
<option value="Convoluted">Convoluted</option>
<option value="Atonic">Atonic</option>
</select>


<label>Lactation</label>
<select name="lactation" id="lactation" validate="Lactation,string,no">
<option value="">Select</option>
<option value="Not Required">Initiated Immediately</option>
<option value="Initiated within 1 Hr">Initiated within 1 Hr</option>
<option value="Not Initiated">Not Initiated</option>
</select>

<div class="clear"></div>

<label> Stage Complications</label>
<input type="text" id="stageComplications" name="satgeComplications"	validate="Complications,string,no" tabindex="1" MAXLENGTH="250" />
 -->
<label>Other Details</label>
<select name="otherdetails" id="otherdetails" validate="otherdetails,string,no">
<option value="">Select</option>
<option>Cephalic</option>
<option>Assisted Breech</option>
</select>
 
<label>Other Remarks</label>
<input type="text" id="otherRemarks" name="otherRemarks"  tabindex="1" MAXLENGTH="250" />

<label>No. Of Baby<span>*</span></label>
<input type="text" id="noOfBaby" name="noOfBaby" value=""	 onblur="displayMessageForOT(this.value);displayBabyDetails(this.value)"  tabindex="1" MAXLENGTH="1" />

<label class="auto" ><span  id="OtMsg"></span></label>
<div class="clear"></div>
<h4>Medication</h4><div class="clear"></div>
<div class="Block"><div class="clear"></div>
<div class="clear"></div>
<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th>Nomenclature/Material Code</th>
	    <!-- <th colspan="1">Other Drug</th> -->
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
	<!-- 		<th scope="col">Unit</th> -->
<!-- 		<th scope="col">AU</th> -->
		<th scope="col">Dosage<span>*</span></th>
	<!-- 	<th scope="col">Frequency<span>*</span></th> -->
	<!-- 	<th scope="col">Days<span>*</span></th> --><!--
		<th id="sosQtyLbl">Qty</th>
		--><!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
<!-- 		<th scope="col">Route</th> -->
		<!--<th scope="col">Type</th>-->
	<!-- 	<th scope="col">Remarks</th> -->
		<!-- <th scope="col">CT</th> -->
		<th scope="col">Stock<span>*</span></th>
		<th scope="col">Batch<span>*</span></th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="displayAuForLabor(this.value,'1','<%=hinId%>');"  />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<!-- <td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td> -->
<%-- 		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%>
		</td> --%>
	<!-- 	<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" readonly="readonly"/>
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1" id="highValueMedicine1" name="highValueMedicine1" validate="AU,string,no" value=""/>  
		</td>	 -->
		
	<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	    <input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidationMotherNBaby(this.value,this.id);" /></td>
<%-- 		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue('1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td> --%>
	<!-- 	<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue('1')"  size="3"	maxlength="3" validate="No of Days,num,no" />
				
		</td> -->
	<!-- 	<td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td> -->
		<!--<td><select name="instructionACPC1" id="instructionACPC1" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC" selected="selected">PC</option>
		</select>	</td>

		<td><select name="typeLeftRight1" id="typeLeftRight1"
			tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>-->
		
		<!-- <td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td> -->
			<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" readonly="readonly"/></td>
		<td><select name="batch1" id="batch1"><option value="">Select</option></select></td>
			<td>
			<input name="Button" type="button" class="button" value="Add" onclick="addRow(document.getElementById('grid'), 'hdb');" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="Delete" class="button" onclick="removeTreatmentRow('grid','hdb',this);" tabindex="1" />
			</td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>


<div id="babyDetailsDiv">


</div>

<script type="text/javascript">
var sexArray=new Array();
var deliveryTypeArray=new Array();

<%
MasAdministrativeSex sex = new MasAdministrativeSex();

for (int i = 0; i < sexList.size(); i++) {
	sex = (MasAdministrativeSex) sexList.get(i);
if(!sex.getAdministrativeSexName().equals("")){
%>


sexArray[<%=i%>]= new Array();
sexArray[<%=i%>][0] = "<%=sex.getId()%>";


sexArray[<%=i%>][1] = "<%=sex.getAdministrativeSexName()%>";
 <% }}%>
 
 
 <%
 MasDeliveryType deliveryType = new MasDeliveryType();

 for (int i = 0; i < deliveryTypeList.size(); i++) {
	 deliveryType = (MasDeliveryType) deliveryTypeList.get(i);
 %>
 deliveryTypeArray[<%=i%>]= new Array();
 deliveryTypeArray[<%=i%>][0] = "<%=deliveryType.getId()%>";
 deliveryTypeArray[<%=i%>][1] = "<%=deliveryType.getDeliveryTypeDescription()%>";
  <% }%>


  function displayMessageForOT(babyiteration){
	  //alert(babyiteration);
	  if(babyiteration ==0 && babyiteration!="")
		  {
		  OtMsg.innerHTML ="Your have marked patient for Surgery.";
		  return false;
		  }
	  else
		  {
		  OtMsg.innerHTML ="";
		  return true;
		  }
	  
	  
	  
  }
  
  
	function displayBabyDetails(babyiteration){
		 babyDetailsDiv.innerHTML ="";
		 for(var j=1;j<=babyiteration;j++)
   	  {
			
		var e0 = document.createElement('h4');
		e0.innerHTML ='Baby Detail '+j;
		babyDetailsDiv.appendChild(e0);
		
		var clearDiv = document.createElement('div');
		clearDiv.className = 'clear';
		babyDetailsDiv.appendChild(clearDiv); 
			 
		 var e1 = document.createElement('label');
		e1.innerHTML ='Baby No.';
		babyDetailsDiv.appendChild(e1);
		
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='babyNo'+j;
		  e11.id='babyNo';
		  e11.value = j;
		  babyDetailsDiv.appendChild(e11);
		  
			var e2 = document.createElement('label');
			e2.innerHTML ='Sex Of Baby <span>*</span>';
			babyDetailsDiv.appendChild(e2);
			 
		
		   var e21 = document.createElement('Select');
		  e21.name='sexOfBaby'+j;
		  e21.id='sexOfBaby'+j;
		 e21.options[0] = new Option('Select', '0');
		for(var i = 0;i<sexArray.length;i++ ){
			e21.options[i+1] = new Option(sexArray[i][1],sexArray[i][0]);
		} 
		babyDetailsDiv.appendChild(e21); 
		
		// var e22 = document.createElement("br");
	      //babyDetailsDiv.appendChild(e22);
		
		var e3 = document.createElement('label');
		e3.innerHTML ='Live/Still Born <span>*</span>';
		babyDetailsDiv.appendChild(e3);
		
		var e31 = document.createElement('select');
		e31.options[0] = new Option('Select', '0');
		e31.options[1] = new Option('Live', 'Live');
		e31.options[2] = new Option('Masserated Still Birth', 'Masserated Still Birth');
		e31.options[3] = new Option('Fresh Still Birth', 'Fresh Still Birth');
		e31.options[4] = new Option('Live cyanosed', 'Live cyanosed');
		e31.name = 'live'+ j;
		e31.id = 'live'+ j;
		e31.validate='Live,string,yes';
		e31.tabIndex="1";
	 	//e31.onclick = function(){displayValue(this.value)};
		babyDetailsDiv.appendChild(e31);
		
		var e4 = document.createElement('label');
		e4.innerHTML ='Birth Weight';
		babyDetailsDiv.appendChild(e4);
		
		var e41 = document.createElement('input');
		  e41.type = 'text';
		  e41.name='birthWeight'+j;
		  e41.id='birthWeight';
		  e41.value='';
		  e41.maxLength ='10';
		  babyDetailsDiv.appendChild(e41);
	  
	  	var e5 = document.createElement('label');
		e5.innerHTML ='Delivery Time';
		babyDetailsDiv.appendChild(e5);
		
		var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.name='timeOfDelivery'+j;
	  e51.id='timeOfDelivery';
	  e51.value = '';
	  e51.maxLength ='5';
	  e51.onkeyup = function(){mask(this.value,this,'2',':')};
	  babyDetailsDiv.appendChild(e51);
	  
	  var e6 = document.createElement('label');
		e6.innerHTML ='Date';
		babyDetailsDiv.appendChild(e6);
		
		var e61 = document.createElement('input');
	  e61.type = 'text';
	  e61.name='birthDate'+j;
	  e61.id='bDate';
	 /*  e61.id='birthDate'+j; */
	  e61.className='date';
	  e61.value = '<%=currentDate%>';
	  babyDetailsDiv.appendChild(e61);
	  
	  var img1 = document.createElement('img');
	  img1.src = '/hms/jsp/images/cal.gif';
	  img1.onclick=function(event)
      {	
		  var obj1=document.getElementById('bDate');
		  setdate('<%=currentDate%>',obj1,event);
      };
      babyDetailsDiv.appendChild(img1);
     
      var clearDiv = document.createElement('div');
		clearDiv.className = 'clear';
		babyDetailsDiv.appendChild(clearDiv); 
      

		var e9 = document.createElement('label');
		e9.innerHTML ='Baby Cry';
		babyDetailsDiv.appendChild(e9);
		
		var e91 = document.createElement('select');
		e91.options[0] = new Option('Select', '');
		e91.options[1] = new Option('Cried immediately', 'Cried immediately');
		e91.options[2] = new Option('Cry delayed', 'Cry delayed');
		e91.name = 'babyCry'+ j;
		e91.id = 'babyCry';
		e91.tabIndex="1";
		babyDetailsDiv.appendChild(e91);
		
		var e10 = document.createElement('label');
		e10.innerHTML ='APGAR AT 1';
		babyDetailsDiv.appendChild(e10);
		
		var e12 = document.createElement('select');
		e12.options[0] = new Option('Select', '');
		 for(var i=0;i<=10;i++)
	   	  {
			 e12.options[i] = new Option(i, i); 
	   	  }
		e12.name = 'apgarAtone'+ j;
		e12.id = 'apgarAtone';
		e12.tabIndex="1";
		babyDetailsDiv.appendChild(e12);
		
		var e13 = document.createElement('label');
		e13.innerHTML ='APGAR AT 5';
		babyDetailsDiv.appendChild(e13);
		
		var e14 = document.createElement('select');
		e14.options[0] = new Option('Select', '');
		 for(var i=0;i<=10;i++)
	   	  {
			 e14.options[i] = new Option(i, i); 
	   	  }
		e14.name = 'apgarAtFive'+ j;
		e14.id = 'apgarAtFive';
		e14.tabIndex="1";
		babyDetailsDiv.appendChild(e14);
		
		
		var e15 = document.createElement('label');
		e15.innerHTML ='Complications';
		babyDetailsDiv.appendChild(e15);
		
		var e16 = document.createElement('input');
	  e16.type = 'text';
	  e16.name='complications'+j;
	  e16.id='complications';
	  e16.maxLength ='25';
	  e16.value = '';
	  babyDetailsDiv.appendChild(e16);
	  
	  
	  var e17 = document.createElement('label');
		e17.innerHTML ='Anomalies';
		babyDetailsDiv.appendChild(e17);
		
		var e18 = document.createElement('input');
	  e18.type = 'text';
	  e18.name='anomalies'+j;
	  e18.id='anomalies';
	  e18.maxLength ='25';
	  e18.value = '';
	  babyDetailsDiv.appendChild(e18);
	  
	  var e19 = document.createElement('label');
		e19.innerHTML ='Baby Feeding';
		babyDetailsDiv.appendChild(e19);
		
		var e20 = document.createElement('select');
		e20.options[0] = new Option('Select', '');
		e20.options[1] = new Option('Feeding well', 'Feeding well');
		e20.options[2] = new Option('Not feeding well', 'Not feeding well');
		e20.name = 'babyFeeding'+ j;
		e20.id = 'babyFeeding';
		e20.value = '';
		e20.tabIndex="1";
		babyDetailsDiv.appendChild(e20); 
		
		
		var e21 = document.createElement('input');
		var hbdValue='hdb'+j;
		e21.type = 'hidden';
		e21.name=hbdValue;
		e21.id=hbdValue;
		e21.value = '1';
		babyDetailsDiv.appendChild(e21);
		
		
		

		var iteration = 1;
	    var tableId = "medicineGrid"+j;
		var table = document.createElement('table')
	    
	    table.id=tableId;
	    var row = table.insertRow(0);

	 
	    var header = table.createTHead();
	    var cell = row.insertCell(0);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Nomenclature";
	    
	    cell = row.insertCell(1);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Dosage <span>*</span>";
	    
	    cell = row.insertCell(2);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Stock <span>*</span>";
	    
	    cell = row.insertCell(3);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Batch <span>*</span>";
	    
	    cell = row.insertCell(4);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Add";
	    
	    cell = row.insertCell(5);
	    cell.className="dynamicTableTh";
	    cell.innerHTML = "Delete";
	    
	    row = table.insertRow(1);
	    
	    var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
			var nomenclatureName = 'baby' + j +'nomenclature'+ iteration;
		  e0.name = nomenclatureName;
		  e0.id = nomenclatureName;
		 // alert(iteration +" "+ e0.id);
		 // alert(j);
		 
		  e0.onblur=function(){
			 //alert("fff" +e0.value +"it "+iteration +'nomenclature' + iteration +'baby'+ 1 +"nomenclature1baby1")
			//alert(this.id);
			// alert(this.value);
	                          
			
			
		                       var val=this.value;
		                       var idVal= this.id;
		                       //console.log("val="+idVal + " ")
		                      var babyNo = idVal.match(/\d+/)[0] ;
		                       
		                       
		                       //console.log("val="+val + " ")
		                       
		                       
		                       if(val != "")
								{
							    var index1 = val.lastIndexOf("[");
							    var indexForPvms=index1;
							    var index2 = val.lastIndexOf("]");
							    index1++;
							    var pvmsNo = val.substring(index1,index2);
							    var indexForPvms=indexForPvms--;
							    var nomenclature=val.substring(0,indexForPvms);

							   // var a= 'nomenclature'+iteration+'baby'+ j;
						   		//alert("dd "+a);
							    
							   	if(pvmsNo =="")
							    {
							    		 document.getElementById(this.id).value="";
		   								/* document.getElementById('pvmsNo'+iteration+'baby'+ j).value=""; */ 
		   								this.value="";
							     return;
							    }
							 /*    else
		      						document.getElementById('pvmsNo' + iteration +'nomenclature'+ j).value=pvmsNo; */
							   	   // displayAuFoBaby(this.value,iteration,'<%= hinId%>');
							   	 displayAuFoBaby(this.value,iteration,babyNo,'<%= hinId%>');
							   }
		  					  };
		  
		var newdiv = document.createElement('div');
	      	//newdiv.setAttribute('id', 'ac2update'+iteration);
	      	//newdiv.setAttribute('class', 'autocomplete');
	     	// newdiv.id='ac2update'+iteration;
	     	newdiv.id='ac2update2';
	     	    newdiv.className='autocomplete';
	       	newdiv.style.display = 'none';
	          e0.size = '30';
		//  alert("3-1--");
		  e0.setAttribute('tabindex','1');
		//  alert("3-2--");
		  cellRight0.appendChild(newdiv);
		  
		  var sel = document.createElement('input');
		  sel.type = 'hidden';
		  sel.name='pvmsNo'+iteration +'baby'+ j;
		  sel.id='pvmsNo'+iteration +"baby"+ j;
		  sel.size = '10';
		  sel.setAttribute('tabindex','1');
		  cellRight0.appendChild(sel);
		  
		  cellRight0.appendChild(e0);
		  e0.focus();
		
		//  alert("3--3-"+iteration);
		// new Ajax.Autocompleter(name,'ac2update'+iteration ,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField='+name});
	
		
			
		 //new Ajax.Autocompleter('nomenclature'+iteration +'baby'+ j,'ac2update'+iteration +'baby'+ j,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration+'baby'+ j});
		   //alert("name--"+e0.name)
		  
	    var cellRight4 = row.insertCell(1);
		  var e14 = document.createElement('input');
		  e14.type = 'text';
		  e14.name='baby' + j +'dosage'+ iteration;
		  e14.id='baby' + j +'dosage'+ iteration;
		  e14.size='5';
		  e14.setAttribute('maxlength', 5); 
		  e14.setAttribute('tabindex','1');
		  e14.onblur = function(){checkDosageValidationMotherNBaby(this.value,this.id);/* fillValue(iteration)*/};
		  cellRight4.appendChild(e14);
		
		  var cellRight11 = row.insertCell(2);
		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name=  'baby' + j +'closingStock'+ iteration;
		  e72.id=  'baby' + j +'closingStock'+ iteration;
		  e72.size='3';
		  e72.setAttribute('tabindex','1');
		  cellRight11.appendChild(e72);

		  
		  var cellRight7 = row.insertCell(3);
		   var e73 = document.createElement('Select');
		  e73.name='baby' + j +'batch'+ iteration;
		  e73.id='baby' + j +'batch'+ iteration;;
		  e73.classname='smalllabel';
		  e73.setAttribute('tabindex','1');
		   e73.options[0] = new Option('Select', '');
		   cellRight7.appendChild(e73);
		  
		  
		  var cellRight12 = row.insertCell(4);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'button';
		  e8.value='Add';
		  e8.name='remarks'+iteration;
		 // e8.setAttribute('onClick', 'addRow();'); 
		   var tableName = "";
			  var hdbName ="";
			  var babyNo ="";
		  e8.id =tableId +"@"+hbdValue+"@"+j;
		  e8.onclick = function(){ 
			  
			  var mergeArray = (this.id).split("@");
			  tableName = mergeArray[0];
				  hdbName = mergeArray[1]; 
				  babyNo =mergeArray[2];
				
			   addRowForBaby(document.getElementById(tableName), hdbName, babyNo); }; 
		  e8.setAttribute('tabindex','1');
		  cellRight12.appendChild(e8);

		  var cellRight13 = row.insertCell(5);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'button';
		  e9.value='Delete';
		  e9.name='remarks'+iteration;
		   //e8.id =tableId;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e9.onclick = function(){removeRow(document.getElementById(tableName), hdbName);};  
		  e9.setAttribute('tabindex','1');
		  cellRight13.appendChild(e9);
	    
	       babyDetailsDiv.appendChild( table); 
		
		  var clearDiv = document.createElement('div');
			clearDiv.className = 'clear';
			babyDetailsDiv.appendChild(clearDiv); 	
		
			  
   	  }	
		 
		 
		 
		 for(var i=1;i<=2;i++)
			 {
				var nomenclatureName = 'baby' + i +'nomenclature'+ 1;
				new Ajax.Autocompleter(nomenclatureName,'ac2update'+2,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField='+nomenclatureName});
			 }
		
	}
	
	/* function displayValue(val){
	
	if(val="Masserated Still Birth"){
		document.getElementById('live').style.dislpaly = 'none';	
	}else if(val = "Fresh Still Birth"){
		
		
	}
		
		
		
		
		
	}
 */





</script>

<%-- <label>Blood Loss</label>
<input type="radio" name="<%=BLOOD_LOSS %>"	value="1" class="radioCheck" />
<label class="auto">More than 500 ml</label>
<input	type="radio" name="<%=BLOOD_LOSS %>" value="2" class="radioCheck" />
<label class="auto">Less than 500 ml</label>
<div class="clear"></div>
<label>Placenta</label>
<input type="radio" name="<%=PLACENTA %>" value="1" class="radioCheck" />
<label class="auto">Complete</label>
<input	type="radio" name="<%=PLACENTA %>" value="2" class="radioCheck" />
<label class="auto">InComplete</label>
<div class="clear"></div>
<input type="hidden" id="<%=INPATIENT_ID%>" name="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" />
<input type="hidden"id="<%=HIN_ID%>" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />
<label><span>*</span> Treatment</label>
<input type="text" id="Treatment" name="<%=TREATMENT%>"	validate="Treatment,string,yes" tabindex="1" MAXLENGTH="12" />
<label>Date of Labor Onset</label>
<input type="text" id="DateOnSet" name="<%=DATE_ON_SET %>" value="<%=currentDate %>" class="readOnly" readonly="readonly" tabindex="1" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.motherBabyDetails.<%=DATE_ON_SET%>,event)" />
<label>Time of Labor Onset</label>
<input type="text" id="TimeOnSet" name="<%=TIME_ON_SET %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label>Puerperium</label>
<input type="text" id="Puerperium"	name="<%=PUERPERIUM %>" tabindex="1" MAXLENGTH="30" />
<label>Mother Condition</label>
<input type="radio" name="<%=MOTHER_CONDITION %>" value="1"	class="radioCheck" />
<label class="auto">Alive</label>
<input type="radio"	name="<%=MOTHER_CONDITION %>" value="2" class="radioCheck" />
<label class="auto">Dead</label>
<div class="clear"></div>
<label>Pulse</label>
<input type="text" id="Pulse" name="<%=PULSE %>" tabindex="1" MAXLENGTH="30" />
<label>Perineum</label>
<input	type="text" id="Perineum" name="<%=PERINEUM%>" tabindex="1"	MAXLENGTH="30" />
<div class="clear"></div>
<label>BP</label>
<input type="text" id="Bp" placeholder="Systolic" 	name="bp" tabindex="1" MAXLENGTH="30" />
<input type="text" id="Bp" placeholder="Diastolic" 	name="bp2" tabindex="1" MAXLENGTH="30" />


<div class="clear"></div>
<label>Additional Notes</label>
<input type="text" id="AdditionalNotes"	name="<%=ADDITIONAL_NOTES %>" tabindex="1" MAXLENGTH="30" />
 <label>Complications</label>
<input type="text" id="Complications" name="<%=COMPLICATIONS%>"	tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label><span>*</span> Conducted By </label>
 <select id="ConductedBy"	name="<%=CONDUCTED_BY%>" validate="Conducted By,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	</option>
	<%} %>
</select>
<label><span>*</span>AssistedBy </label>
 <select id="AssistedBy"	name="<%=ASSISTED_BY%>" validate="Assisted By,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	</option>
	<%} %>
</select> --%>

<div class="clear"></div>
</form>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick=" submitOPDMainForm();"accesskey="a" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="button"	onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time:</label> <label
	class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>

 <div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<%} %>


<script type="text/javascript">
function addRow(tbl, hdb1){
	//  var tbl = document.getElementById('grid');
	
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById(hdb1);
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 

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
	      						displayAuForLabor(this.value,iteration,'<%= hinId%>');
						   }
	  					  };
	  
	var newdiv = document.createElement('div');
      	//newdiv.setAttribute('id', 'ac2update'+iteration);
      	//newdiv.setAttribute('class', 'autocomplete');
     	    newdiv.id='ac2update'+iteration;
     	    newdiv.className='autocomplete';
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
	
/* 	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11); */

	  /* var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<unitArray.length;i++ ){
	      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
	      }
	  cellRight2.appendChild(e12); */

/* 	  var cellRight3 = row.insertCell(2);
	
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='au'+iteration;
	  e13.readOnly = "readonly";
	  e13.id='au'+iteration
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);		 */ 
	 // cellRight3.appendChild(e1);	  
	  
	 /* var cellRight3 = row.insertCell(4);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight4 = row.insertCell(1);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidationMotherNBaby(this.value,this.id);};
	  cellRight4.appendChild(e14);  
	  
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);		
	 
	//  var cellRightSel = row.insertCell(2);

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

	//	var cellRight7 = row.insertCell(7);			

/* 	  var cellRight10 = row.insertCell(9);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight10.appendChild(e71); */

	  var cellRight11 = row.insertCell(2);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.readOnly = "readonly";
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);
	  
	  var cellRight7 = row.insertCell(3);
	   var e73 = document.createElement('Select');
	  e73.name='batch'+iteration;
	  e73.id='batch'+iteration;
	  e73.classname='smalllabel';
	  e73.setAttribute('tabindex','1');
	   e73.options[0] = new Option('Select', '');
	   cellRight7.appendChild(e73);
	  

	  var cellRight12 = row.insertCell(4);
	  var e8 = document.createElement('input');
	  e8.type = 'button';  
	  e8.className = 'button';
	  e8.value = 'Add';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow(tbl, hdb1);}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(5);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'button';
	  e9.value = 'Delete';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeTreatmentRow(tbl, hdb,this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);		 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
 //   var e9 = document.createElement('input');
//     e9.id = 'a'
//     e9.type = 'checkbox';
//    cellRight9.appendChild(e9);

	} 

/* function removeTreatmentRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
} */
function removeTreatmentRow(tbl,countId,obj)
{
 // var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}




function addRowForBaby(tbl, hdb1, babyno){
	//  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById(hdb1);
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  
	  var nomenclatureName = 'baby' + babyno+ 'nomenclature' + iteration;
	  var dosage = 'baby' + babyno+ 'dosage' + iteration;
	  var closingStock = 'baby' + babyno+ 'closingStock' + iteration;
	  var batch = 'baby' + babyno+ 'batch' + iteration;
	  
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 

	  e0.name = nomenclatureName;
	  e0.id = nomenclatureName;
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
						    		document.getElementById(this.id).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						            return;
						    }
						   /*  else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo */
	      						displayAuFoBaby(this.value,iteration,babyno,'<%= hinId%>');
						   }
	  					  };
	  
	var newdiv = document.createElement('div');
      	//newdiv.setAttribute('id', 'ac2update'+iteration);
      	//newdiv.setAttribute('class', 'autocomplete');
     	    newdiv.id='ac2update'+iteration;
     	    newdiv.className='autocomplete';
       	newdiv.style.display = 'none';
          e0.size = '30';
	//  alert("3-1--");
	  e0.setAttribute('tabindex','1');
	//  alert("3-2--");
	  cellRight0.appendChild(newdiv);
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter(nomenclatureName,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField='+nomenclatureName});
	 
	 
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
	
/* 	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11); */

	  /* var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<unitArray.length;i++ ){
	      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
	      }
	  cellRight2.appendChild(e12); */

/* 	  var cellRight3 = row.insertCell(2);
	
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='au'+iteration;
	  e13.readOnly = "readonly";
	  e13.id='au'+iteration
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);		 */ 
	 // cellRight3.appendChild(e1);	  
	  
	 /* var cellRight3 = row.insertCell(4);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight4 = row.insertCell(1);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name=dosage;
	  e14.id=dosage
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidationMotherNBaby(this.value,this.id);};
	  cellRight4.appendChild(e14);  
	  
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);		
	 
	//  var cellRightSel = row.insertCell(2);

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

	//	var cellRight7 = row.insertCell(7);			

/* 	  var cellRight10 = row.insertCell(9);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight10.appendChild(e71); */

	  var cellRight11 = row.insertCell(2);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name=closingStock;
	  e72.readOnly = "readonly";
	  e72.id=closingStock
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);
	  
	  var cellRight7 = row.insertCell(3);
	   var e73 = document.createElement('Select');
	  e73.name=batch
	  e73.id=batch;
	  e73.classname='smalllabel';
	  e73.setAttribute('tabindex','1');
	   e73.options[0] = new Option('Select', '');
	   cellRight7.appendChild(e73);
	  

	  var cellRight12 = row.insertCell(4);
	  var e8 = document.createElement('input');
	  e8.type = 'button';  
	  e8.className = 'button';
	  e8.value = 'Add';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRowForBaby(tbl, hdb1, babyno);}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(5);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'button';
	  e9.value = 'Delete';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeTreatmentRow(tbl, hdb,this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);		 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
 //   var e9 = document.createElement('input');
//     e9.id = 'a'
//     e9.type = 'checkbox';
//    cellRight9.appendChild(e9);

	} 

function validateNoOfBaby(babycount){
	
	if(trimAll(babycount) == ""){
		alert("No. of baby cannot be blank.\n");
		return false;
	}

		if(!validateInteger(trimAll(babycount)))
			{
			alert("No. of baby should be a number(without spaces).\n");						
			return false;
			}
			
	return true;
}
function validateFrequency(){
	var count = document.getElementById('hdb').value;
	for(var i = 1; i <= count;i++){
		//var nomenclature = document.getElementById('nomenclature'+i).value;
		if(document.getElementById('nomenclature'+i)){
		if(document.getElementById('nomenclature'+i).value != ''){

             if(document.getElementById('dosage'+i)){
			if(document.getElementById('dosage'+i).value == ''){
				alert('Please Enter dosage.');
				document.getElementById('dosage'+i).focus();
				return false;
			 }
			}
		
             if(document.getElementById('batch'+i)){
     			if(document.getElementById('batch'+i).value == ''){
     				alert('Please select batch');
     				return false;
     			 }
     			}
	
		}
	
		
	 }
	}
	return true;
}

function validateBabyMedication(babycount){
	//alert("d"+babycount);
	
	
	for(var j = 1; j <= babycount;j++)
		{
		var count = document.getElementById('hdb'+j).value;
	for(var i = 1; i <= count;i++){
		//var nomenclature = document.getElementById('nomenclature'+i).value;
		if(document.getElementById('baby' + j +'nomenclature'+ i)){
		if(document.getElementById('baby' + j +'nomenclature'+ i).value != ''){

             if(document.getElementById('baby' + j +'dosage'+ i)){
			if(document.getElementById('baby' + j +'dosage'+ i).value == ''){
				alert('Please Enter dosage.');
				document.getElementById('baby' + j +'dosage'+ i).focus();
				return false;
			 }
			}
		
             if(document.getElementById('baby' + j +'batch'+ i)){
     			if(document.getElementById('baby' + j +'batch'+ i).value == ''){
     				alert('Please select batch');
     				return false;
     			 }
     			}
		}
	 }
	}//inner loop
		}//outer loop
	return true;
}


function validateBabyGender(babycount){
	for(var j = 1; j <= babycount;j++)
		{
			if(document.getElementById('sexOfBaby' + j)){
			if(document.getElementById('sexOfBaby' + j).value != ''){
	
	             if(document.getElementById('sexOfBaby' + j)){
				if(document.getElementById('sexOfBaby' + j).value == '0'){
					alert('Select Gender of Baby '+j);
					document.getElementById('sexOfBaby' + j).focus();
					return false;
					 }
					}
				}
			 }
	
		}//loop end
	return true;
}

function validateBabyCondition(babycount){
	for(var j = 1; j <= babycount;j++)
		{
			if(document.getElementById('live' + j)){
			if(document.getElementById('live' + j).value != ''){
	
	             if(document.getElementById('live' + j)){
				if(document.getElementById('live' + j).value == '0'){
					alert('Select Baby '+j+' condition live/death');
					document.getElementById('live' + j).focus();
					return false;
					 }
					}
				}
			 }
	
		}//loop end
	return true;
}

function submitOPDMainForm(){
	
	if(confirm("Do You want to submit the Record!?")){
		var babycount = document.getElementById("noOfBaby").value;
		if(validateNoOfBaby(babycount)&& validateFrequency() &&  validateBabyGender(babycount) && validateBabyCondition(babycount) && validateBabyMedication(babycount)){
			submitForm('motherBabyDetails','/hms/hms/lr?method=addMotherBabyDetails');
			
		}
	
	}
	
}


/* function checkTentativeDate(babycount){
	
	currentDate = new Date();
	 var month = currentDate.getMonth() + 1
	 var day = currentDate.getDate()
	 var year = currentDate.getFullYear()
	 var seperator = "/"
	 currentDate = new Date(month + seperator + day + seperator + year);
	 alert(babycount);
		for(var j = 1; j <= babycount;j++)
		{
			alert(document.getElementById('birthDate' + j));
			if(document.getElementById('birthDate' + j)){
				alert("2 "+document.getElementById('birthDate' + j));
			if(document.getElementById('birthDate' + j).value != ''){
				var tentativeDateString = document.getElementById('birthDate'+ j).value;
				var  tentativeDate = new Date(tentativeDateString.substring(6),(tentativeDateString.substring(3,5) - 1) ,tentativeDateString.substring(0,2))
				alert(tentativeDate > currentDate);
				alert(tentativeDate < currentDate);
				
				if(tentativeDate > currentDate){
					alert("Tentative Should be Past Date or Current Date of Baby "+j);
					document.getElementById('birthDate' + j).value ="";
					return false;
				}
					
				}
			 }
	
		}

	return true;
} */
</script>


<style>
.dynamicTableTh{
background: #c1c1c1 none repeat scroll 0 0;
    border-bottom: 1px solid #c0c0c0;
    border-right: 1px solid #c0c0c0;
    color: #000000;
    font: bold 12px arial;
    height: 14px;
    padding-left: 5px;
    text-align: left;
    width: auto;
}

</style>