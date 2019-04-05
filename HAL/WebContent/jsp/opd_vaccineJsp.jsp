<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION" %>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID" %>
<%@ page import="static jkt.hms.util.RequestConstants.DOB" %>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION" %>
<%@ page import="static jkt.hms.util.RequestConstants.GENDER" %>
<%@ page import="static jkt.hms.util.RequestConstants.P_MIDDLE_NAME" %>
<%@ page import="static jkt.hms.util.RequestConstants.P_FIRST_NAME" %>
<%@ page import="static jkt.hms.util.RequestConstants.P_LAST_NAME" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasVaccineItem"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<!-- <script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script> -->

<script
	type="text/javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<!-- <script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script> -->

<script>jQuery.noConflict();</script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<title>OPD Vaccination</title>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
 	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
				Map<String, Object> map = new HashMap<String, Object>();
				String message =null;
				String patientName = null;
				String gender = null;
				String dob = null;
				String serviceNo = null;
				String age = null;
				int visitId = 0;

				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
	
				Patient patientDetails = null;
				if(map.get("patientDetails")!= null){
					patientDetails = (Patient)map.get("patientDetails");
				}
				if(map.get("visitId")!= null){
					visitId = (Integer)map.get("visitId");
				}
				if(patientDetails!=null){
					
					patientName = patientDetails.getPFirstName()+" "+patientDetails.getPMiddleName()+" "+patientDetails.getPLastName();
					/* gender = patientDetails.getSex().getId(); */
					//dob = HMSUtil.getDateFormat(patientDetails.getDateOfBirth(), "dd/MM/yyyy");
					serviceNo = patientDetails.getServiceNo();
					//age = HMSUtil.calculateAge(patientDetails.getDateOfBirth());
					//employeeId = patientDetails.getId();
				}
				
				List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
				if(map.get("frequencyList") != null){
				frequencyList=(List)map.get("frequencyList");
				}
				
				String  otherPatient =null;
				if (map.get("otherPatient") != null) {
					otherPatient = (String) map.get("otherPatient");
				}
				
				int  relationId =0;
				if (map.get("relationId") != null) {
					relationId = (Integer) map.get("relationId");
				}
				
				int  employeeId =0;
				if (map.get("employeeId") != null) {
					employeeId = (Integer) map.get("employeeId");
				}
				
				int hinId=0;
				String hinNo ="";
				if(patientDetails.getId()!=null){
					hinId=patientDetails.getId();
					hinNo =patientDetails.getHinNo();
					 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
						hinNo = hinNo.substring(1, hinNo.length());
				}
				
		
				List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
				if(map.get("itemConversionList") != null){
					itemConversionList=(List)map.get("itemConversionList");
					}
				List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
			    if(map.get("masItemClassList") != null){
			    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
			    			}
			    
				List<MasVaccineItem> vaccineList = new ArrayList<MasVaccineItem>();
				List<OpdVaccinationPlan>vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
				List<Integer> prescribedVaccinList = new ArrayList<Integer>();
			
				
	
				
				if(map.get("vaccineList") != null){
					vaccineList = (List<MasVaccineItem>)map.get("vaccineList");
				}
				if(map.get("vaccinationPlanList") != null){
					vaccinationPlanList = (List<OpdVaccinationPlan>)map.get("vaccinationPlanList");
				}
				
				int totalVisit =0;
				
				if(map.get("totalVisit") != null){
					totalVisit=(Integer)map.get("totalVisit");
				}
		%>

	<script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();
	   var itemClassArray = new Array();
	   var itemClassCodeArray = new Array();
	   var departmentArray = new Array();
	   var ItemClassIdUOMNotRequired = new Array();
	</script>


<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<form name="opdVaccineMain" action="" method="post">
  <div class="Block">
<div class="clear"></div>
<%-- <label>Employee No. </label>
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value="<%=serviceNo!=null?serviceNo:"" %>"	 MAXLENGTH="30"	onblur="if(this.value!='' ){document.getElementById('facPriscription').setAttribute('action', 'opd?method=showPatientDirectPrescription');document.getElementById('facPriscription').submit();}" />
 --%>
 <input name="hinId" id="hinId" type="hidden" value="<%=hinId%>" />
<input name="visitId" id="visitId" type="hidden" value="<%=visitId %>" /> 
<input type="hidden" name="totalVisit" value="<%=totalVisit%>" />
<input type="hidden" id="precriptionCount" name="precriptionCount" value="0" />
			<%-- <input name="currentDate" id="currentDate" type="hidden" value="<%cu %>" /> --%> 
		
		
  <label>First Name</label> 
<input id="<%=P_FIRST_NAME %>" type="text" name="<%=P_FIRST_NAME %>" value="<%=patientDetails!=null?patientDetails.getPFirstName()!=null?patientDetails.getPFirstName():"":""%>" tabindex="1"	validate="Patient First Name,string,yes" MAXLENGTH="15" readonly="readonly"/> 

<label>Middle Name</label> 
<input	id="<%=P_MIDDLE_NAME%>" type="text" name="<%=P_MIDDLE_NAME%>" value="<%=patientDetails!=null?patientDetails.getPMiddleName()!=null?patientDetails.getPMiddleName():"":""%>"	tabindex="1" validate="Patient Middle Name,string,no"	MAXLENGTH="15" readonly="readonly" />

<label>Last Name</label> 
<input id="<%=P_LAST_NAME %>" type="text"	name="<%=P_LAST_NAME %>" value="<%=patientDetails!=null?patientDetails.getPLastName()!=null?patientDetails.getPLastName():"":""%>" tabindex="1"	validate="Patient Last Name,string,no" MAXLENGTH="15" readonly="readonly"/>

 <input type="hidden" name="<%=GENDER %>" value="<%=patientDetails!=null?patientDetails.getSex()!=null?patientDetails.getSex().getId():"":""%>" validate="Gender,num,yes"/> 

<label> Relation </label>
<label class="value"><input type="hidden" name="<%=RELATION%>" value="<%=patientDetails!=null?patientDetails.getRelation()!=null?patientDetails.getRelation().getNewRelationName():"":""%>" validate="dob,string,yes"/> <%=patientDetails!=null?patientDetails.getRelation()!=null?patientDetails.getRelation().getNewRelationName():"":""%></label>

<label> DOB </label>
<label class="value"><input type="hidden" name="<%=DOB %>" value="<%=patientDetails!=null?patientDetails.getDateOfBirth()!=null?HMSUtil.convertDateToStringTypeDateOnly(patientDetails.getDateOfBirth()):"":""%>" validate="dob,string,yes"/> <%=patientDetails!=null?patientDetails.getDateOfBirth()!=null?HMSUtil.convertDateToStringTypeDateOnly(patientDetails.getDateOfBirth()):"":""%> </label>

<label> Age </label>
<label class="value"> <%=patientDetails!=null?patientDetails.getAge()!=null?patientDetails.getAge():"":""%> </label>

<label> Blood Group </label>
<label class="value"> <%=patientDetails!=null?patientDetails.getBloodGroup()!=null?patientDetails.getBloodGroup().getBloodGroupName():"":""%> </label>
<label>Employee No.</label>
<label class="value"><%=patientDetails!=null?patientDetails.getServiceNo():""%></label><div class="clear"></div>	
<label> <span>Allergy</span></label>
<input type="text" name="allergies" maxlength="500" value="<%=patientDetails!=null?patientDetails.getDrugAllergies()!=null?patientDetails.getDrugAllergies():"":""%>" style="width: 802px;"> 

</div>

<h4>Vaccine details</h4>
<div class="cmntable">
<table>
	<tr>
	<th>Prescribe</th>
	<th>Order No.</th>
	<th>Name Of Vaccine</th>
	<th>Source</th>
	<!-- <th>Dose No.</th> -->
	<!-- <th>Duration</th>  -->
<!-- 	<th>Schedule Date</th> -->
<!-- 	<th>To Date</th> -->
   <!--  <th>Scheduled due date as per DOB</th> -->
   <!--  <th>To date as per DOB</th> -->
	<th>Vaccination  Date</th>
	<th>Doctor Remarks</th>
<!-- 	<th>Vaccination Date</th>
	<th>Status</th> -->
	</tr>
<%
int j= 1;
boolean match = false;
String vaccineDate=null;
String remarks = null;
String source = null;
if(vaccineList.size()>0 && vaccineList != null){
	for(MasVaccineItem masVaccine :vaccineList){
		match = false;
		vaccineDate=null;
		remarks = null;
		source = null;
		for(OpdVaccinationPlan vaccinationPlan : vaccinationPlanList){
			%>
			<%if(vaccinationPlan.getVaccin().getId()==masVaccine.getId()){
				match = true;
				vaccineDate = HMSUtil.convertDateToStringTypeDateOnly(vaccinationPlan.getVaccinDate());
				remarks = vaccinationPlan.getRemarks(); 
				source = vaccinationPlan.getVaccineSource();
				break;
			}
	     }
		
		if(match==true){
		%><tr><td><input type="checkbox" onclick="toogleVaccinDetails('<%=j%>',this,'${_csrf.parameterName}','${_csrf.token}')" checked="checked" id="vaccineItemPvmsNo<%=j%>" disabled="disabled" name="vaccineItemPvmsNo<%=j%>"  <%-- value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" --%> />
		   </td>
				<%
			}else{
				%>
					<td><input type="checkbox" onclick="toogleVaccinDetails('<%=j%>',this,'${_csrf.parameterName}','${_csrf.token}')"   id="vaccineItemPvmsNo<%=j%>"  name="vaccineItemPvmsNo<%=j%>" <%--  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" --%> />
		<input type="hidden" id="checkItem<%=j%>" name="checkItem<%=j%>" value="N" /> </td>
			<%}%>
				<td><%=masVaccine.getOrderNo() != null ? masVaccine.getOrderNo():"" %></td>
		<td><%=masVaccine.getVaccineName() != null ? masVaccine.getVaccineName():"" %>
		<input type="hidden" name = "vaccineId<%=j%>"  value="<%=!match? masVaccine.getId():"" %>" />
		</td>
		<td><select name="vaccine_source<%=j%>" class="auto"><option>HAL</option><option <%=source!=null?source.equalsIgnoreCase("Outside")?"selected":"":""%>>Outside</option></select></td>
		<td>
		<%-- <input type="text" size="20"  name="completionDate<%=j%>" id="completionDateId<%=j%>" class="date" validate="completion Date,string,no" readonly="readonly" value="<%=vaccineDate!=null?vaccineDate:""%>"/>
 			<%if(!match){ %><img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.vaccineDetail.completionDate<%=j%>,event)" /><%} %> --%>
 			
 			<input  type="text" class="calDate"  id="completionDate<%=j%>" name="completionDate<%=j%>" placeholder="DD/MM/YYYY" validate="Vaccine Date,string,no" value="<%=vaccineDate!=null?vaccineDate:""%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'completionDate<%=j%>');" maxlength="10" style="width: 120px"/>
 			
 			</td>
		<td><input type="text" name = "vaccineRemarks<%=j%>"  value="<%=remarks!=null?remarks:""%>" <%=match?"readonly":"" %> size="50"/></td>
		
			</tr>
	<%j++;}
} %>
	<input type="hidden" id="totalVaccinNo" value="<%=j%>">	
</table>
 <input	type="hidden" name="count" id="count"	value="<%=j %>" />
 <input	type="hidden" name="currentDate" id="currentDate"	value="<%=currentDate%>" />
 <input	type="hidden" name="consultationDate" id="consultationDate"	value="<%=currentDate%>" />
 <input	type="hidden" name="consultationTime" id="consultationTime"	value="<%=currentTime%>" />
 
</div>




<div class="clear"></div>

<div class="clear"></div>

 <div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OPD');">Current Medication</a>
				<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>
				
				
					
					
			</div>
<div class="Block">
<h4>Treatment</h4>
	<div class="cmntable">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="nomenclatureGrid">

					<tr>
						<th>Nomenclature/Material Code</th>
	<!-- 					<th colspan="1">New NIP</th> -->
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
					<!-- 	<th scope="col">Class</th>
						<th scope="col">AU</th> -->
						<th scope="col">Disp. Unit</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
			<!-- 			<th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature1" size="77" name="nomenclature1"
							onblur="checkForAlreadyIssuedPrescription(this.value,'1',document.getElementById('hinId').value);populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');" />
							<input type="hidden" name="itemId1" id="itemId1" value="" />
							<input type="hidden" name="itemIdClassificationId1" id="itemIdClassificationId1" value="" />
							<div id="ac2update1" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script></td>
				<!-- 		<td><input type="text" name="otherMedicine1" tabindex="1"
							id="otherMedicine1" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td> -->
	<%-- 					<td><select name="itemClass1" id="itemClass1">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td> --%>
					<%-- 	<td><select name="itemConversionId1" id="itemConversionId1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au1" tabindex="1" value="" id="au1"
							size="6" validate="AU,string,no" /> </td> --%>
						<td>
						<input type="text" name="dispensingUnit1" tabindex="1" id="dispensingUnit1"  size="6"  validate="Dispensing Unit,string,no"  readonly="readonly"/>
						<%-- <select name="dispensingUnit1" id="dispensingUnit1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> --%>
						
						<input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode1" name="itemClassCode1"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine1" name="highValueMedicine1"
							validate="highValue,string,no" value="" />
						</td>
						<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
						<td><input type="hidden" name="pvmsNo1" tabindex="1"
							id="pvmsNo1" size="10" readonly="readonly" /> <input type="text"
							name="dosage1" tabindex="1" value="" id="dosage1" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
						<td><select name="frequency1" id="frequency1" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')">
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
            </script> <% }%> <input type="hidden" name="frequencyValue1"
							id="frequencyValue1" value=""> <input type="text"
							name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"
							size="3" onblur="fillValue('1')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays1" tabindex="1"
							id="noOfDays1" onblur="fillValue('1')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total1" tabindex="1" id="total1"
							size="5" validate="total,num,no" /></td>
						<!-- <td><input type="text" name="route1" tabindex="1" id="route1"
							value="" size="5" maxlength="20" validate="Route,string,no" /></td> -->
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

						<td><input type="text" name="remarks1" tabindex="1"
							id="remarks1" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock1" tabindex="1"
							value="" id="closingStock1" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addNomenclatureRow();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				<input type="hidden" name="nomenclaturehdb" value="1" id="nomenclaturehdb" />
				<div class="clear"></div>
			</div>
			
					<h4>NIP</h4>
		<%int nipInc=500; %>
			<div class="cmntable">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">

					<tr>
						<th>NIP</th>
						<th colspan="1">New NIP</th>
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
						<th scope="col">Class</th>
						<th scope="col">AU</th>
						<th scope="col">Disp. Unit</th>
							<th scope="col">UOM Qty</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
						<!-- <th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature<%=nipInc%>" size="30" name="nomenclature<%=nipInc%>"
							onblur="checkForAlreadyIssuedPrescription(this.value,'<%=nipInc%>',document.getElementById('hinId').value);populatePVMS(this.value,'<%=nipInc%>');checkItem(<%=nipInc%>);disableOtherMedicine(this.value,'<%=nipInc%>');displayAu(this.value,'<%=nipInc%>','<%=hinId%>');checkForPurchase(this.value,'<%=nipInc%>');" />
							<input type="hidden" name="itemId<%=nipInc%>" id="itemId<%=nipInc%>" value="" />
							<input type="hidden" name="itemIdClassificationId<%=nipInc%>" id="itemIdClassificationId<%=nipInc%>" value="" />
							<div id="ac2update2" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=nipInc%>','ac2update2','opd?method=getNipItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=nipInc%>'});
			</script></td>
						<td><input type="text" name="otherMedicine<%=nipInc%>" tabindex="1"
							id="otherMedicine<%=nipInc%>" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'<%=nipInc%>');readOnlyNomenclature(this.value,'<%=nipInc%>');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td>
						<td><select name="itemClass<%=nipInc%>" id="itemClass<%=nipInc%>">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td>
						<td><select name="itemConversionId<%=nipInc%>" id="itemConversionId<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
						MasStoreItemConversion masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au<%=nipInc%>" tabindex="1" value="" id="au<%=nipInc%>"
							size="6" validate="AU,string,no" /> <input type="hidden"
							name="actualDispensingQty<%=nipInc%>" tabindex="1"
							id="actualDispensingQty<%=nipInc%>" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode<%=nipInc%>" name="itemClassCode<%=nipInc%>"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine<%=nipInc%>" name="highValueMedicine<%=nipInc%>"
							validate="highValue,string,no" value="" /></td>
						<td><select name="dispensingUnit<%=nipInc%>" id="dispensingUnit<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select></td>
			<%-- 			<td><input type="checkbox" name="injCategory<%=nipInc%>" class="radio" id="injCategory<%=nipInc%>" value="y" />
		</td> --%>
		<td><input type="text" name="uomQty<%=nipInc%>" tabindex="1" id="uomQty<%=nipInc%>" maxlength="5" size="5" validate="UOM Qty,float,no"/></td>
						<td><input type="hidden" name="pvmsNo<%=nipInc%>" tabindex="1"
							id="pvmsNo<%=nipInc%>" size="10" readonly="readonly" /> <input type="text"
							name="dosage<%=nipInc%>" tabindex="1" value="" id="dosage<%=nipInc%>" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')" /></td>
						<td><select name="frequency<%=nipInc%>" id="frequency<%=nipInc%>" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'<%=nipInc%>');fillValueFromFrequency(this.value,'<%=nipInc%>');displaySOSQty(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')">
								<option value="0">Select</option>
								<%

		      for(MasFrequency masFrequency1 : frequencyList){
		       int id = masFrequency1.getId();
		       String name = masFrequency1.getFrequencyName();
          %>
								<option value="<%=id %>"><%=name%></option>
								<%} %>
						</select> <%
	    		  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <input type="hidden" name="frequencyValue<%=nipInc%>"
							id="frequencyValue<%=nipInc%>" value=""> <input type="text"
							name="sosQty<%=nipInc%>" tabindex="1" id="sosQty<%=nipInc%>" style="display: none;"
							size="3" onblur="fillValue('<%=nipInc%>')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays<%=nipInc%>" tabindex="1"
							id="noOfDays<%=nipInc%>" onblur="fillValue('<%=nipInc%>')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total<%=nipInc%>" tabindex="1" id="total<%=nipInc%>"
							size="5" validate="total,num,no" /></td>
					<%-- 	<td>
						<input type="text" name="route<%=nipInc%>" tabindex="1" id="route<%=nipInc%>"
							value="" size="5" maxlength="20" validate="Route,string,no" />
							</td> --%>
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

						<td><input type="text" name="remarks<%=nipInc%>" tabindex="1"
							id="remarks<%=nipInc%>" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock<%=nipInc%>" tabindex="1"
							value="" id="closingStock<%=nipInc%>" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addRowForNIP();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('grid','hdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				<input type="hidden" name="hdb" value="<%=nipInc%>" id="hdb" />
				<div class="clear"></div>
			</div>
</div>

	<div class="clear"></div>
   <div class="Block">
		<label>Treatment Advice</label>
		<textarea name="otherTreatment" id="otherTreatment" cols="50" rows="0" maxlength="500"
			tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
			<input type="button" class="button" tabindex="3" name="" value="+" onclick="getPresentTemplate('<%=HMSUtil.getProperties("adt.properties", "templateCodeForTreatmentAdvice")%>','otherTreatment');" />
	</div> 
<div class="Block">
	<div id="gridview">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="investigationGrid">
				<tr>
					<td colspan="4">
						<div class="floatleft">
							<input type="radio" value="Lab" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck"
								checked="checked" onchange="" />
							<div class="labRadiologyDivfixed">LAB</div>
							<input type="radio" value="Radio" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck" onchange="" />
							<div class="labRadiologyDivfixed">Radiology</div>
							<input type="hidden" name="investigationCategory"
								id="investigationCategory" />
							<div class="clear"></div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="col">Investigation</th>
					<!-- <th scope="col">Refer to MH</th> -->
					<th scope="col">Investigation Date</th>
					<th scope="col">Add</th>
					<th scope="col">Delete</th>
				</tr>


				<%int inc=1;
			String investigationName = "";
%>

				<tr>
					<td><input type="text" value="<%=investigationName %>"
						tabindex="1" id="chargeCodeName<%=inc %>" size="100"
						name="chargeCodeName<%=inc %>"
						onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
						<div id="ac2update2" style="display: none;" class="autocomplete"></div>
						<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%> <script type="text/javascript" language="javascript"
							charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" /> <input
						type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
						size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

					</td>

					<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
                    <td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc%>',document.getElementById('hinId').value);"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td>
					<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>

				<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

				


			</table>
		</div>
		</div>
			<%if(otherPatient!=null && otherPatient.equalsIgnoreCase("y")){ %>
<input type="hidden" value="<%=otherPatient%>" name="otherPatient" id="otherPatient"/>
<%}else{
%>
<input type="hidden" value="<%=relationId%>" name="relationId" id="relationId"/>
<input type="hidden" value="<%=employeeId%>" name="employeeId" id="employeeId"/>

	<%} %>
		
		
</form>
		
<div class="division"></div>
	<input type="button" name="Submit" value="Submit" class="button" onClick="submitOPDVaccineForm();" />
	<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</div>


<script>
function submitOPDVaccineForm(){

	if(confirm("Do You want to submit the Record!?")){

	 
		 if(validateNip() &&  validateFrequency()){
				
			 
			 var count=0;
			 var j=0;
			 if(document.getElementById("count"))
			 	count=document.getElementById("count").value;
			 	
			 	for(var i=1;i<=count;i++)
			 		{

			 		  if( document.getElementById("checkItem"+i)!=null && document.getElementById("checkItem"+i).value=="Y" )
			 			  {
			 			  j++;
			 			     if( document.getElementById("completionDateId"+i)!=null &&document.getElementById("completionDateId"+i).value=="")
			 			    	 {
			 			    	 alert("Please select vaccination date");
			 			    	 return false;
			 			    	 }
			 			  }
			 		}
			 	 if(j==0)
			 	  { alert("select atleast one row to submit");
			    	   return false;}
			 	 else
			 		 submitForm('opdVaccineMain','opd?method=submitOPDVaccineDetail&referedToMH=n&flag=opd');
		}
	
		return true;
	}else{
		return false;
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

function getFrequencyValue(feqValue,inc){
	feqValue =  document.getElementById('frequency'+inc).value;
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency masFrequency1 :frequencyList){
%>
 if(feqValue == '<%=masFrequency1.getId()%>'){
	 feqQty = '<%=masFrequency1.getFeq()%>'
	
  }

<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>