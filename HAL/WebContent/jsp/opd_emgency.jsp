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
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>

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

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js?n=1"></script>
<script>jQuery.noConflict();

</script>
<title>Anesthesia Record Document</title>
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
				int patientAge =0;
				String sPatientAge="-";

				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
	
				List<Patient> patientList = new ArrayList<Patient>();
				if(map.get("patientList")!= null){
					patientList = (	List<Patient> )map.get("patientList");
				}
				
				if(patientList.size()>0){
					
					patientName = patientList.get(0).getPFirstName()+" "+patientList.get(0).getPMiddleName()+" "+patientList.get(0).getPLastName();
					/* gender = patientList.get(0).getSex().getId(); */
					//dob = HMSUtil.getDateFormat(patientList.get(0).getDateOfBirth(), "dd/MM/yyyy");
					serviceNo = patientList.get(0).getServiceNo();
					//age = HMSUtil.calculateAge(patientList.get(0).getDateOfBirth());
					//employeeId = patientList.get(0).getId();
					      if(patientList.get(0).getDateOfBirth() != null)
            {
                Date date_of_birth= patientList.get(0).getDateOfBirth();        
                patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
                if(patientAge == 1 )
                    sPatientAge = patientAge +" Year";
                else if(patientAge == 0 )
                {
                	sPatientAge= HMSUtil.getAgeFromDOB(date_of_birth);
                }
                else
                    sPatientAge = patientAge +" Years";

            }
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
				if(patientList.get(0).getId()!=null){
					hinId=patientList.get(0).getId();
					hinNo =patientList.get(0).getHinNo();
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
			    
				List<MasDepartment> wardDepartmentList = new   ArrayList<MasDepartment>();
				if(map.get("wardDepartment") != null)
				{
					wardDepartmentList=(List<MasDepartment>)map.get("wardDepartment");
				}
				
				int totalVisit =0;
				
				if(map.get("totalVisit") != null){
					totalVisit=(Integer)map.get("totalVisit");
				}
				List templateList= new ArrayList();
				if(map.get("templateList") != null){
				templateList=(List)map.get("templateList");
				}
				
				List<MasDepartment> deptList= new ArrayList<MasDepartment>();
				if(map.get("deptList") != null){
				deptList=(List)map.get("deptList");
				}
				
				List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
			  	if(map.get("masImpanneledHospitalList") != null)
				{
			  		masImpanneledHospitalList=(List<MasImpanneledHospital>)map.get("masImpanneledHospitalList");
				}
			  	
		%>

<%-- <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();
	   var itemClassArray = new Array();
	   var itemClassCodeArray = new Array();

	</script>
<%
String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
for(int i=0;i<ItemClassCodeForLiquid.length;i++)
{
%>
<script>

itemClassCodeArray[<%=i%>]= new Array();
itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

			
    </script>
<%	}%> --%>
<%-- <%@page import="jkt.hms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hms.masters.business.TempTickattach"%> --%>


<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

  <div class="Block">
<div class="clear"></div>
<%-- <label>Employee No. </label>
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value="<%=serviceNo!=null?serviceNo:"" %>"	 MAXLENGTH="30"	onblur="if(this.value!='' ){document.getElementById('facPriscription').setAttribute('action', 'opd?method=showPatientDirectPrescription');document.getElementById('facPriscription').submit();}" />
 --%>
 <input name="hinId" id="hinId" type="hidden" value="<%=hinId%>" />
<input name="visitId" id="visitId" type="hidden" value="0" /> 
<input type="hidden" name="totalVisit" value="<%=totalVisit%>" />
<input type="hidden" name="consultationDate" id="consultationDate" value="<%=currentDate%>" />

			<%-- <input name="currentDate" id="currentDate" type="hidden" value="<%cu %>" /> --%> 
		
		
  <label>First Name<span>*</span></label> 
<input id="<%=P_FIRST_NAME %>" type="text" name="<%=P_FIRST_NAME %>" value="<%=patientList.size()>0?patientList.get(0).getPFirstName()!=null?patientList.get(0).getPFirstName():"":""%>" tabindex="1"	validate="Patient First Name,string,yes" MAXLENGTH="15" readonly="readonly"/> 

<label>Middle Name</label> 
<input	id="<%=P_MIDDLE_NAME%>" type="text" name="<%=P_MIDDLE_NAME%>" value="<%=patientList.size()>0?patientList.get(0).getPMiddleName()!=null?patientList.get(0).getPMiddleName():"":""%>"	tabindex="1" validate="Patient Middle Name,string,no"	MAXLENGTH="15" readonly="readonly" />

<label>Last Name</label> 
<input id="<%=P_LAST_NAME %>" type="text"	name="<%=P_LAST_NAME %>" value="<%=patientList.size()>0?patientList.get(0).getPLastName()!=null?patientList.get(0).getPLastName():"":""%>" tabindex="1"	validate="Patient Last Name,string,no" MAXLENGTH="15" readonly="readonly"/>

 <input type="hidden" name="<%=GENDER %>" value="<%=patientList.size()>0?patientList.get(0).getSex()!=null?patientList.get(0).getSex().getId():"":""%>" validate="Gender,num,yes"/> 

<label> Relation </label>
<label class="value"><input type="hidden" name="<%=RELATION%>" value="<%=patientList.size()>0?patientList.get(0).getRelation()!=null?patientList.get(0).getRelation().getNewRelationName():"":""%>" validate="dob,string,yes"/> <%=patientList.size()>0?patientList.get(0).getRelation()!=null?patientList.get(0).getRelation().getNewRelationName():"":""%></label>

<label> DOB </label>
<label class="value"><input type="hidden" name="<%=DOB %>" value="<%=patientList.size()>0?patientList.get(0).getDateOfBirth()!=null?HMSUtil.convertDateToStringTypeDateOnly(patientList.get(0).getDateOfBirth()):"":""%>" validate="dob,string,yes"/> <%=patientList.size()>0?patientList.get(0).getDateOfBirth()!=null?HMSUtil.convertDateToStringTypeDateOnly(patientList.get(0).getDateOfBirth()):"":""%> </label>

<label> Age </label>
<label class="value"> <%=sPatientAge%> </label>

<label> Blood Group </label>
<label class="value"> <%=patientList.size()>0?patientList.get(0).getBloodGroup()!=null?patientList.get(0).getBloodGroup().getBloodGroupName():"":""%> </label>
<div class="clear"></div>
<label> allergy </label>
<input type="text" name="allergies" maxlength="500" value="<%=patientList.size()>0?patientList.get(0).getDrugAllergies()!=null?patientList.get(0).getDrugAllergies():"":""%>" style="width: 802px;"> 

</div>

<h4>Diagnosis</h4>
<div class="clear"></div>

<div class="Block">

<div class="leftDivblock">
<div class="clear"></div>
<label>Present Complaint <span>*</span></label>
<div class="clear"></div>
<div class="clear"></div>
<textarea class="auto" style="width:360px; height:103px;" name="presentComplain" id="presentComplain" tabindex="1" validate="Present Complaint,string,yes" cols="0" rows="0" maxlength="300"></textarea>
<input class="button" tabindex="3" name="" value="+" onclick="getPresentTemplate('CH');" type="button">
</div>

<div class="leftDivblock" style="margin-left:50px;">
<input id="systamicExam" class="large" name="systamicExam" maxlength="200" type="hidden">
<label>Working Diagnosis</label>
	<input type="text" class="auto" id="initialDiagnosis" tabindex="1" value="" size="53" name="initialDiagnosis" maxlength="500"/>
				 
<div class="clear"></div>
<label>ICD Diagnosis<span>*</span></label>
<div class="clear"></div>
<input tabindex="1" value="" id="icd" name="icd" class="auto" size="53" onblur="fillDiagnosisCombo(this.value);" autocomplete="off" type="text"> <input type="checkbox" onclick="addNAIcd('<%=HMSUtil.getProperties("adt.properties", "ICDCodeForNotAvailble")%>',this)" name="NAIcd" id="NAIcd" value="<%=HMSUtil.getProperties("adt.properties", "ICDCodeForNotAvailble")%>" style="margin-top: 0px; margin-right: 5px;"> Not available
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="diagnosisId" multiple="4" size="5" tabindex="1" id="diagnosisId" class="listBig" validate="ICD Daignosis,string,yes">
	<option value="0">Select</option>
</select>
<input class="buttonDel" value="" onclick="deleteDgItems(this,'diagnosisId');" type="button" align="right">

</div>
<label>Clinical Notes</label>
<textarea name="clinicalNotes" cols="103" rows="0" maxlength="5000" class="auto" tabindex="1"></textarea>
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

<div class="Block">

			<label>Template</label>
			<div id="treatmentDiv">
				<select name="templateId" id="templateId" tabindex="1" onchange="toggleAdmission2();">
				
					<option value="0">Select</option>
					<%
	   Iterator itr=templateList.iterator();
	   while(itr.hasNext())
	   {
		   OpdTemplate opdTemplate=(OpdTemplate)itr.next();
		   String templateType=opdTemplate.getTemplateType();
		   if(templateType.equalsIgnoreCase("p"))
		   {
	%>
					<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
					<%
		   }}%>
				</select>
			</div>

			<%-- <div id="prevButtonDivToShowHide">
<input name="Prevoius2"	tabindex="1" type="button" value="Previous" class="button"	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getDepartment().getId()%>','<%=visit.getId()%>')" />
</div> --%>
			<div id="createPresDivToShowHide">
				<input name="createPrescriptionTemplate" tabindex="1" type="button"
					value="Create Template" class="buttonBig"
					onclick="showCreatePrescriptionTempate();" />
			</div>
			
			<div>
				<input name="createPrescriptionTemplate" tabindex="1" type="button"
					value="Update Template" class="buttonBig"
					onclick="showUpdateOpdTempate('P');" />
			</div>
			<div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
				<input name="copyPrevPrescriptionTemplate" tabindex="1"
					type="button" value="Copy Previous" class="buttonBig"
					onclick="copyPrevPrescriptionTempate('0','<%=hinId%>');" />
			</div>

			<div id="prescriptionImportButton" class="floatLeft">
				<input name="prescriptionImportButton1" tabindex="1" type="button"
					value="Import New" class="button"
					onclick="getListForTreatment('treatmentDiv','visitEmployee');" />

			</div>
	   <div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OPD');">Current Medication</a>
			</div>
		</div>

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
	<!-- fayaz added -->
	<h4>Investigation</h4>
	<div class="Block">
		<label>Template</label>
		<div id="investigationDiv">
			<select name="investigationTemplateId" id="investigationTemplateId" onchange="toggleAdmission1();"
				tabindex="1" 
				>
				<%-- <select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">--%>
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
				<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
				<%
		   }
	      }

		%>

			</select>
		</div>
		<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" /> --%>
		<div id="createInvestigationDivToShowHide">
			<input name="investigationTemplate" type="button"
				value="Create Template" tabindex="1" class="buttonBig"
				onclick="showCreateInvestigationTemplate();" />
		</div>
		<div >
				<input name="createupdateTemplate" tabindex="1" type="button"
					value="Update Template" class="buttonBig"
					onclick="showUpdateOpdTempate('I');" />
			</div>
		<div id="copyPrevInvestigationTemplateDiv" style="display: none">
			<input name="copyPrevInvestigationTemplate" tabindex="1"
				type="button" value="Copy Previous" class="buttonBig"
				onclick="copyPrevInvestigationTempate('0','0');" />
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv','visitEmployee');" />
		</div>
		<label>Urgent</label> <input type="checkbox" name="urgent"
			tabindex="1" class="radioAuto" value="1" />
	</div>

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
					<th>Date</th>
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
					<td><input name="Button" type="button" class="buttonAdd"
						value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>

				<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

				


			</table>
			
			<%if(otherPatient!=null && otherPatient.equalsIgnoreCase("y")){ %>
<input type="hidden" value="<%=otherPatient%>" name="otherPatient" id="otherPatient"/>
<%}else{
%>
<input type="hidden" value="<%=relationId%>" name="relationId" id="relationId"/>
<input type="hidden" value="<%=employeeId%>" name="employeeId" id="employeeId"/>

	<%} %>
		
		
				<div id="admissionDiv">
				<div class="clear"></div>
				<%-- 		<label class="autoSpace">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label> --%>
				<label>Admission Advised <%--   <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="checkbox" class="radioCheckCol2" id="admissionAdvised"	name="admissionAdvised" />
							<%} %> --%> <input type="checkbox" class="radioCheckCol2"
					id="admissionAdvised" name="admissionAdvised" onclick="toggleAdmission(this);"
					style="margin: 1px 5px 0px 0px;" />
				</label>

				<div id="admDiv" style="display: none;">
					<label>Admission Date</label> <input type="text"
						name="admissionDate" id="admissionDate" style="text-align: left;"
						class="dateTextSmall" value="<%=currentDate%>" readonly="readonly"
						onblur="checkAdmte()" /> <img src="/hms/jsp/images/cal.gif"
						width="16" height="16" border="0" validate="Pick a date"
						onclick="setdate('<%=currentDate%>',document.visitEmployee.admissionDate,event);" />
					<!-- 	<label class="autoSpace">Payward

							<input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2" value="Y"
							 />	
							</label> -->
					<label>Ward</label> <select name="admissionWard"
						id="admissionWard" onclick="getBedStatus1(this.value);">
						<option value="0">Select</option>
						<%for(MasDepartment ward:wardDepartmentList){ %>
						<option value="<%=ward.getId()%>"><%=ward.getDepartmentName() %></option>
						<%} %>
					</select>
						<div class="clear"></div>
					<label>Admission  Notes</label>
				<textarea name="admissionNote" validate="referralNote,string,no"
					id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
					 style="width: 477px;"></textarea>
					<div id="bedDiv"></div>
				</div>
				
				<div class="clear"></div>
	
	<h4>Referral</h4>

	<div class="Block">

		<%  String relationName=""; %>

		<div id="referalDiv">

			<label>Referral </label> <select id="referral" name="referral"
				class="midium">
				<option value="0" selected="selected">No</option>
				<option value="1">Yes</option>
			</select>

			<div id="referDiv" class="col collaps">
				<label>Refer To</label>
				<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
				<%-- 			<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="autoSpace"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%> --%>

				<label class="autoSpace"><input type="radio"
					class="radioCheckCol2" name="referTo" id="referInternal"
					value="Internal" checked onclick="checkReferTO('referInternal');"
					style="margin: 1px 5px 0px 0px;" />Internal</label>
					   
<%-- <% if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL) && visit.getHin().getEmployee()!=null && !visit.getHin().getEmployee().getEmployeeType().getEmployeeTypeCode().equalsIgnoreCase(empTypeCodeForContract))
{ %> --%>

				<label	class="autoSpace"><input type="radio"
					class="radioCheckCol2" name="referTo" id="referExternal"
					value="Empanel" onclick="checkReferTO('referExternal');"
					style="margin: 1px 5px 0px 0px;" />Empanel</label>
					
					<label class="autoSpace"><input type="radio" class="radioCheckCol2" name="referTo" id="referBoth" 
				value="Both" onclick="checkReferTO('Both');" style="margin:1px 5px 0px 0px;" />Both</label>
<%-- <%} %> --%>
				<div class="clear"></div>
				<label>Refer Date:</label> 
				 <input type="text" name="referVisitDate" id="referVisitDate" class="calDate"  placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');"  value="<%=currentDate%>" />
			
			
				<!-- onblur="checkAdmte()" -->
				<label id="priorityLabelId">Current Proirity No.</label> <select
					id="priorityId" name="priorityName" tabindex="1">
					<option value="3">3</option>
					<option value="2">2</option>
					<option value="1">1</option>
				</select>
				
			<div id="referDepartmentDiv">
				<div class="clear"></div>
				<table  id="referGrid">
				<tr><th>Department</th><th>Doctor</th>	<th scope="col">Add</th>
		<th scope="col">Delete</th>
				<tr>
				
				<td>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
					<select id="deptId1" name="refereddept1"
						onchange="fnGetAvailableDoctor(this.value,'refereddoctor1');">
						<option value="0">Select</option>
						<%
				int deptId=(Integer)session.getAttribute("deptId");
				if(deptList!= null){int i=0;
				for (MasDepartment masDepartment : deptList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
  <script>
    departmentArray[<%=i%>]= new Array();
    departmentArray[<%=i%>][0] = "<%=masDepartment.getId()%>";
    departmentArray[<%=i%>][1]= "<%=masDepartment.getDepartmentName()%>";

                 
            </script> 
						<%i++;}
				}
			%>
					</select> 
					</td>
					<td>
				<select id="refereddoctor1"
						name="refereddoctor1">
						<option value="0">Select</option>
					</select>
					</td>
					<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForRefer();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('referGrid','hiddenValue',this);" /></td>
					</tr>
				  </table>
				  	<input type="hidden" value="1" name="hiddenValueRefer" id="hiddenValueRefer" />
				</div>
				<label id="referhospitalLabel" style="display: none;">Hospital
					<span>*</span>
				</label> <select id="referhospital" name="referhospital"
					onchange="fnGetHospitalDepartment(this.value);"
					style="display: none;">
					<option value="0">Select</option>
					<%for(MasImpanneledHospital msih:masImpanneledHospitalList){%>
					<option value="<%=msih.getId()%>"><%=msih.getImpanneledHospitalName()%></option>
					<%}%>
				</select> <label id=referdayslLabel style="display: none;">No. of
					Days</label> <input id="referdays" name="referdays" type="text"
					maxlength="2" style="display: none;" />

				<div class="clear"></div>

			<%-- 	<label id="referdepartmentLabel">Department <span>*</span></label>
				<select id="referdepartment" name="referdepartment"
					onchange="fnGetAvailableDoctor(this.value,'refereddoctor');">
					<option value="0">Select</option>
					<%for(MasDepartment dep:deptList){
										%>
					<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
							<%if(deptId==dep.getId()) {%>
										<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
										<%}else{ %>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
										<%} %>
					<%}%>
				</select> <label id="refereddoctorlabel">Doctor <span>*</span></label> <select
					id="refereddoctor" name="refereddoctor">
					<option value="0">Select</option>
				</select> --%>


				<div class="clear"></div>
				<label style="display: none">Patient Advise</label>
				<textarea name="patientAdvise" validate="patientAdvise,string,no"
					id="patientAdvise" cols="0" rows="0" maxlength="500" tabindex="5"
					onkeyup="return checkLength(this)" style="display: none"></textarea>
				<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
				<label id="referral_treatment_type_label" style="display: none">Treatment Type <span>*</span></label>
				<select id="referral_treatment_type" name="referral_treatment_type" style="display: none">
					<option value="1" selected="true">OPD</option>
					<option value="2">Admission</option>
				</select> <label id="referredForLabel"  style="display: none">Referred For<span>*</span></label> <input
					id="referredFor" name="referredFor" type="text" maxlength="300"
					validate="" style="display: none" /> 
					<div class="clear"></div><label>Referral Notes</label>
				<textarea name="referralNote" validate="referralNote,string,no"
					id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
					onkeyup="return checkLength(this)" style="width: 477px;"></textarea>
				<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
			</div>
			<input type="hidden" name="userName" value="<%=userName %>" />
			<%-- 		<%
									if(visit.getHin().getRelation() != null){
							    	 relationName=visit.getHin().getRelation().getRelationName();
								if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
								%>
								<label>No. of Days</label> <input name="days" type="text"
									maxlength="1" />
								<%}} %> --%>
		</div>

		<div class="clear"></div>
	</div>
	


			</div>
<div class="division"></div>
	<input type="button" name="Submit" value="Submit" class="button" onClick="if(submitOPDMainForm()){submitForm('visitEmployee','opd?method=submitEmergencyOPD');}" />
	<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</div>


<script>


 $j(document).ready(function()
		
		{
	
	$j("#referDiv").hide();
			
	
		});
		
		
$j('#referral').click(function () {
	var selVal= $j("#referral").val();
	 if(selVal==0){
		 $j("#referDiv").hide();
	 }else if(selVal==1){
		 $j("#referDiv").show();
	 }
});
</script>