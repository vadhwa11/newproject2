<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasZonal"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>



<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 /* var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}'; */
</script>
<!-- <script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script> -->

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<title>FAC Recall </title>


<%Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String currentTime = (String) utilMap.get("currentTime");
String userName = "";
String otherTreatment="";
String employeeName="";

String DivisionName="";
String employeeNo="";
int divisionId=0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
				Map<String, Object> map = new HashMap<String, Object>();
// 				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
		
				String message = "";
				int hinId=0;
				int visitId=0;
				int inpatientId=0;
				String hinNo ="";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
			
				
				
			/* 	List<OpdPatientDetails> opdPDetailsListForEyeDeptFollowUp = new ArrayList<OpdPatientDetails>();
				if (map.get("opdPDetailsListForEyeDeptFollowUp") != null) {
					opdPDetailsListForEyeDeptFollowUp = (List<OpdPatientDetails>) map.get("opdPDetailsListForEyeDeptFollowUp");
				} */
				
				List<DgOrderhd> patientInvestigationHeaderListForFollowUp = new ArrayList<DgOrderhd>();
				if(map.get("patientInvestigationHeaderListForFollowUp") != null){
					patientInvestigationHeaderListForFollowUp=(List<DgOrderhd>)map.get("patientInvestigationHeaderListForFollowUp");
				}
				
				List<PatientPrescriptionHeader> pphList = new ArrayList<PatientPrescriptionHeader>();
				if(map.get("pphList") != null){
					pphList=(List<PatientPrescriptionHeader>)map.get("pphList");
				}
				Patient patient = null;
				if(map.get("patient") != null){
					patient=(Patient)map.get("patient");
				}
				if(patient!=null){
					hinId=patient.getId();
					if(pphList.size()>0){
					visitId = pphList.get(0).getVisit().getId();
					divisionId =pphList.get(0).getHin().getEmployee().getDivision().getId(); }
					else if(patientInvestigationHeaderListForFollowUp.size()>0){
						visitId = patientInvestigationHeaderListForFollowUp.get(0).getVisit().getId();
						divisionId = 	patientInvestigationHeaderListForFollowUp.get(0).getHin().getEmployee().getDivision().getId();
					}
					hinNo =patient.getHinNo();
					 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
						hinNo =hinNo.substring(1, hinNo.length());
					 
				}
				
				PatientPrescriptionHeader patientPrescriptionHeader = null;
				if(pphList.size()>0){
					patientPrescriptionHeader = pphList.get(0);
				}	
				
				
			
				System.out.println("patient="+patient);
				List<InjAppointmentDetails>injAppDetails= new ArrayList<InjAppointmentDetails>();
				List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
			    if(map.get("masItemClassList") != null){
			    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
			    			}
			    
				List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
				if(map.get("itemConversionList") != null){
					itemConversionList=(List)map.get("itemConversionList");
					}

				List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
				if(map.get("frequencyList") != null){
				frequencyList=(List)map.get("frequencyList");
				}
				
				String otherInvestigation ="";
				DgOrderhd patientInvestigationHeader = null;
				int dgOrderHdId=0;
				Set<DgOrderdt> patientInvestigationdetails = new HashSet<DgOrderdt>();
				if(patientInvestigationHeaderListForFollowUp.size()>0){
					patientInvestigationHeader = patientInvestigationHeaderListForFollowUp.get(0);
					otherInvestigation = patientInvestigationHeader.getOtherInvestigation()!=null?patientInvestigationHeader.getOtherInvestigation() :"";
					dgOrderHdId = patientInvestigationHeader.getId();
					patientInvestigationdetails = patientInvestigationHeader.getDgOrderdts();
				}
				
				List<MasZonal> masZonalList = new ArrayList<MasZonal>();
				if(map.get("masZonalList") != null){
					masZonalList=(List<MasZonal>)map.get("masZonalList");
						}
				
				int zonalId=0;
				if(pphList.size()>0 && pphList.get(0).getZonal()!=null){
					zonalId =pphList.get(0).getZonal().getId();
				}
		%>



<script>



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
<%} %>
<%
int pHeaderId =0;
	//if (pphList.size()>0 && pphList.get(0).getPatientPrescriptionDetails().size()!=0) {
		
	System.out.println("kjksfs"+patient!=null);	
		if(patient!=null){
		int inc1 = 1;
	
		
%>
<form name="facDetails" method="post" action="">

	<div class="Block">
<div class="clear paddingTop5"></div>

<%

      String Relation="";
				if (patient!= null) {
					
					
					employeeName= patient.getPFirstName();
					employeeNo=patient.getServiceNo();
					hinId=patient.getId();
					//DivisionName=patientPrescriptionHeader.getDivision() !=null?patientPrescriptionHeader.getDivision().getDivisionName():"";
					Relation = patient.getRelation() !=null?patient.getRelation().getRelationName():"";
				}
					
					
					%>

<label>Employee No:</label>
<input type="text" value="<%out.print(employeeNo); %>" name="emp"/>
<label>Employee Name:</label>
<input type="text" value="<%out.print(employeeName); %>" name="emp1"/>
 <input name="hinId" id="hinId" type="hidden" value="<%=hinId%>" />
 
 <label>Relation</label>
<input type="text" value="<%out.print(Relation); %>" name="emp2"/>
 <div class="clear"></div>	
<label>Division</label>
<input type="text" value="<%out.print(DivisionName); %>" name="emp2"/>

<label>Zonal Name </label>
<select id="zonalId" name="zonalId">

<option value="0">Select</option>
<%

for(MasZonal list: masZonalList)
{
	%>
  <option value="<%=list.getId()%>" <% if(zonalId==list.getId()){%>selected<%}%>><%=list.getZonalName()%></option>
	<%
}
%>
</select>
<h4>Treatment</h4>
<div id="templateDivToShowHide" class="floatLeft">

  <div class="floatRight">
			  <%--   <a href="#" onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y');">Current Medication</a> --%>
				<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>
			</div> 
<div id="testDiv">
<div class="cmntable">
<div class="Clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		 <th>Nomenclature/Material Code</th>
	   <!--  <th colspan="1">Other Drug</th> -->
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
	<!-- 		<th scope="col">Unit</th> -->
	<!-- 	<th scope="col">Class</th>
		<th scope="col">AU</th> -->
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
		<!--
		<th id="sosQtyLbl">Qty</th>
		--><!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
	<!-- 	<th scope="col">Route</th> -->
		<!--<th scope="col">Type</th>-->
		<th scope="col">Instruction</th>
		<!-- <th scope="col">CT</th> -->
		<th scope="col">Stock</th>
		 <th>Add</th>
		<th>Delete</th>
		
	</tr>


	<%
	if (pphList.size()>0) {
		pHeaderId= pphList.get(0).getId();
	 
				if (patientPrescriptionHeader.getPatientPrescriptionDetails() != null) {
					
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
						System.out.println(patientPrescriptionHeader.getStatus() +" 1");
					//	TreatmentAdvise = patientPrescriptionHeader.getOtherTreatment() !=null?patientPrescriptionHeader.getOtherTreatment():"";
						
					
					}
					employeeName= patientPrescriptionHeader.getHin().getPFirstName();
					employeeNo=patientPrescriptionHeader.getHin().getServiceNo();
					DivisionName=patientPrescriptionHeader.getDivision() !=null?patientPrescriptionHeader.getDivision().getDivisionName():"";
					pHeaderId = patientPrescriptionHeader.getId();
					otherTreatment = patientPrescriptionHeader.getOtherTreatment() !=null?patientPrescriptionHeader.getOtherTreatment():"";
					boolean prescriptionIssued = false;
					boolean injectionIssued = false;
					System.out.println("");
					if(patientPrescriptionHeader.getStatus().equalsIgnoreCase("I"))
					prescriptionIssued = true;
					String readonly ="";
					if(prescriptionIssued)
						readonly ="readonly='readonly'";
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
						
					if(!prescriptionIssued){
							readonly = "";
							injectionIssued = false;
						for(InjAppointmentDetails injDt: injAppDetails){
							if(patientPrescriptionDetails.getId() == injDt.getPatientPrescriptionDetails().getId() && injDt.getStatus()!=null && injDt.getStatus().equalsIgnoreCase("y") )
							{
								injectionIssued = true;
								readonly ="readonly='readonly'";
								break;
							}
						  }
						
						if(!injectionIssued  && patientPrescriptionDetails.getInjectionStatus()!=null && !patientPrescriptionDetails.getInjectionStatus().equalsIgnoreCase("n"))
						{
							readonly ="readonly='readonly'";
							injectionIssued = true;
						}
						
						}
						
						else if(!patientPrescriptionDetails.getInjectionStatus().equalsIgnoreCase("n"))
						{
							readonly ="readonly='readonly'";
							injectionIssued = true;
						} 
	%>
	<tr>
		<td>
		<%
			MasStoreItem
			item = patientPrescriptionDetails
									.getItem();
							String itemName1 = item.getNomenclature() + "("+ item.getId() + ")" + "["+ item.getPvmsNo() + "]";
							String pvmsNo = "";
							pvmsNo = item.getPvmsNo();

							String dosage = patientPrescriptionDetails
									.getDosage();
							int noOfDays = patientPrescriptionDetails
									.getNoOfDays();
							int total = patientPrescriptionDetails.getTotal();
							String type = patientPrescriptionDetails.getType();
							int frequencyId = patientPrescriptionDetails
									.getFrequency().getId();
							String instruction = patientPrescriptionDetails
									.getInstruction();
							String remark = patientPrescriptionDetails
									.getRemarks();
							String au = patientPrescriptionDetails.getItem().getItemConversion().getItemUnitName();
							String route = patientPrescriptionDetails.getRoute();
							System.out.println("au "+au);
		%> 
	        <input type="hidden" tabindex="1"	id="prescriptionId<%=inc1%>" name="prescriptionId<%=inc1%>" size = "30" readonly="readonly" value="<%=patientPrescriptionDetails.getId()%>"/>
	       
	        <input type="hidden" tabindex="1"	id="injFlag<%=inc1%>" name="injFlag<%=inc1%>" size = "30" readonly="readonly" value="<%=patientPrescriptionDetails.getInjectionStatus()%>"/>
			<input type="text" tabindex="1"	id="nomenclature<%=inc1 %>" size = "53"   value="<%=itemName1%> "
			size="50" name="nomenclature<%=inc1%>"  onblur="checkForAlreadyIssuedPrescription(this.value,'<%=inc1%>');populatePVMS(this.value,'<%=inc1%>');checkItem(<%=inc1%>);displayAu(this.value,<%=inc1%>,'<%=hinId%>');checkForPurchase(this.value,'<%=inc1%>');"/>
			 <input type="hidden" name="itemId<%=inc1%>" id="itemId<%=inc1%>"	value="<%=patientPrescriptionDetails.getItem().getId()%>" />
			 <input type="hidden" name="itemIdClassificationId<%=inc1%>" id="itemIdClassificationId<%=inc1%>"/>
			<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script>
			</td>
	<%-- <td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"  size="20" readonly readOnlyNomenclature(this.value,'<%=inc1%>');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td> --%>
		<%-- <td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"   size="20"	 validate="Other Medicine,string,no" onblur="showSimilarMedicineNames(this.value);"/></td> --%>
<%-- <td><input type="checkbox" name="injCategory" class="radio" id="injCategory" value="false"   /></td>--%>
<%-- 	<td><select name="itemClass<%=inc1%>" id="itemClass<%=inc1%>" disabled="disabled">
		<option value="0">Select</option>
		<%for(MasItemClass mc : masItemClassList) {
		  if(mc.getId() == patientPrescriptionDetails.getItem().getItemClass().getId())
		       {		 	
		    %>	   <option value="<%=mc.getId()%>" selected="selected"><%=mc.getItemClassName()%></option>
		      <% }else{
          %>
			<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
			<%} }%> 
			
		</select>
		
				<%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%>
		
		</td> --%>
		<%--  		<td><select name="itemConversionId<%=inc1%>" id="itemConversionId<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
		 	<%

		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       if(masStoreItemConversion.getId() == patientPrescriptionDetails.getItem().getItemConversion().getId())
		       {		 	
		    %>	   <option value="<%=masStoreItemConversion.getId() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
		      <% }else{
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} }%> 
		</select>
 		<%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> 
		<!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
		 
		</td> --%>
<%-- <%if(au != null){ %>
		<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=au %>" id="au<%=inc1%>" readonly="readonly" size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%}else{ %>
			<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  readonly="readonly"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%} %> --%>
			
					<td>
		<select name="dispensingUnit<%=inc1%>" id="dispensingUnit<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
		    	     if(patientPrescriptionDetails.getItem().getDispUnit()!=null&& masStoreItemConversion.getItemUnitName()!=null && masStoreItemConversion.getItemUnitName().equalsIgnoreCase(patientPrescriptionDetails.getItem().getDispUnit()))
				       {		 	
				    %>	   <option value="<%=masStoreItemConversion.getItemUnitName() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
				      <% }else{
		          %>
					<option value="<%=masStoreItemConversion.getItemUnitName() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
					<%} }%> 
		</select>
		<input type="hidden" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>"  size="6"  validate="AU,string,no" value="<%=patientPrescriptionDetails.getItem().getADispQty()%>"/>
		 <input type="hidden" tabindex="1"  id="itemClassCode<%=inc1%>" name="itemClassCode<%=inc1%>"  validate="itemClassCode,string,no" value="<%=patientPrescriptionDetails.getItem().getItemClass()%>" />
		<input type="hidden" tabindex="1" id="highValueMedicine<%=inc1%>" name="highValueMedicine<%=inc1%>" validate="AU,string,no" value=""/> 
		</td>
			
			<td>
			<input type="hidden" name="pvmsNo<%=inc1%>" id="pvmsNo<%=inc1%>" value="<%=pvmsNo%>" size="10" readonly="readonly" /><input type="text" name="dosage<%=inc1%>" 
			id="dosage<%=inc1%>" value="<%=dosage%>" size="5" tabindex="1" onblur="checkDosageValidation(this.value,'<%=inc1%>');fillValue('<%=inc1%>')"/></td>
			
			<td><select name="frequency<%=inc1%>" id="frequency<%=inc1%>"  class="medium"  
			tabindex="1" onchange="getFrequencyValue(this.value,'<%=inc1%>');fillValueFromFrequency(this.value,'<%=inc1%>');displaySOSQty(this.value,'<%=inc1%>');fillValue('<%=inc1%>')">
			<option value="0">Select</option>
			<%
				for (MasFrequency masFrequency : frequencyList) {
									int id = masFrequency.getId();
									String name = masFrequency.getFrequencyName();
			%>

			<option value="<%=id%>" <%=HMSUtil.isSelected(id, frequencyId)%>><%=name%></option>
			<%
				}
			%>
		</select> <%
 	MasFrequency masFrequency = new MasFrequency();

 					for (int i = 0; i < frequencyList.size(); i++) {
 						masFrequency = (MasFrequency) frequencyList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <%
 	}
 %>
		 <input type="hidden" name="frequencyValue<%=inc1%>" id="frequencyValue<%=inc1%>" value="<%=patientPrescriptionDetails.getFrequency().getFeq()%>"></td>
		  <input type="text" name="sosQty<%=inc1%>" tabindex="1" id="sosQty<%=inc1%>" style="display: none;"   size="3" onblur="fillValue('<%=inc1%>')"	maxlength="3" validate="Sos Qty,num,no" />
		
		
        <%
        	if (patientPrescriptionDetails.getNoOfDays() != null) {
        %>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>"  value="<%=noOfDays%>"
			  onblur="fillValue('<%=inc1%>')" validate="days,num,no"/></td>
		<%
			} else {
		%>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>"  onblur="fillValue('<%=inc1%>')"
			 <%=readonly%>/></td>
		<%
			}
		%>
				<%
				
				if(patientPrescriptionDetails.getItem().getItemClassification()!=null && patientPrescriptionDetails.getItem().getItemClassification().getId() ==2)
				{
					readonly ="";
				}
				else
				{
					readonly ="readonly='readonly'";
				}
				
				if(total != 0){ %>
		<td>
			<input type="text" name="total<%=inc1%>"  value="<%=total %>" tabindex="1" id="total<%=inc1%>" validate="total,num,no" size="3"/></td>
			<%}else{ %>
			<td>	<input type="text" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>"  validate="total,num,no" size="3"/></td>
			
			<%} %>
		<%-- <td>
		<%if(route != null && !route.equals("")){ %>
		<input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="<%=route %>"  size="5" maxlength="20"	<%=readonly%>  validate="Route,string,no" />
			<%}else{ %>
	<input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
			<%} %>
			</td> --%>
		<%-- <%
		 	if (patientPrescriptionDetails.getInstruction() != null) {
		 %>
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value="<%=instruction%>"><%=instruction%></option>
		</select></td>
		<%
			} else {
		%>
		
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value=""></option>
		</select></td>
		<%
			}
		%> --%>
		 		 <%
		 		 	if (patientPrescriptionDetails.getRemarks() != null) {
		 		 %>
		<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>" size = "10"
			value="<%=remark%>" class="small" maxlength="15" placeholder="1-1-1"/></td>
			<%
				} else {
			%>
			<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>"  size = "10"
			value="" class="small"  maxlength="15" placeholder="1-1-1"/></td>
			<%
				}
			%>
		<%-- 	<td><input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td> --%>
		<td><input type="text" name="closingStock<%=inc1%>" disabled="disabled" tabindex="1" value="" id="closingStock<%=inc1%>"  size="3"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addNomenclatureRow();" tabindex="1" /> 
			</td>
			<td>
			<%	if(true){ %>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			<%} else if(injectionIssued){%>
			Injection cannot be modified
			<%} else{%>
			Issued
			<%} %>
			</td>
			
	</tr>
	<%
		inc1++;
					}
				}
		}else{
	%>
		<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="checkForAlreadyIssuedPrescription(this.value,'1');populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');"  />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	      <input type="hidden" name="itemId1" id="itemId1"	value="" />
	        <input type="hidden" name="itemIdClassificationId" id="itemIdClassificationId"	value="" />
	      
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<!-- <td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td> -->
	<%-- 	<td><select name="itemClass1" id="itemClass1">
		<option value="0">Select</option>
		<%for(MasItemClass mc : masItemClassList) {%>
		<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
		<%} %>
		</select>
		
				<%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%>
		
		</td> --%>
<%--  		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getItemUnitName() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
 		<%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> 
		<!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
		  
		</td> --%>
		<td>
		<select name="dispensingUnit1" id="dispensingUnit1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<input type="hidden" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1"  id="itemClassCode1" name="itemClassCode1"  validate="itemClassCode,string,no" value="" />
                           
		<input type="hidden" tabindex="1" id="highValueMedicine1" name="highValueMedicine1" validate="AU,string,no" value=""/>
		</td>
	<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')" >
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
		</td>
		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue('1')"  size="3"	maxlength="3" validate="No of Days,num,no" />
		
			
		</td>
		<td><input type="text" name="total1" tabindex="1" id="total1" size="3" validate="total,num,no" validate="total,num,no"/></td>
		<!-- <td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" /> -->
		</td>
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
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="15" placeholder="1-1-1"/>
			</td>
			<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addNomenclatureRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);" tabindex="1" />
			</td>
	</tr>
	<%} %>
	<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" />


</table>


<div class="Clear"></div>

<div class="clear"></div>

 
</div>


</div>
</div>

	</div>
	

		<label> Treatment Advice:</label>
	<textarea name="otherTreatment" cols="50" rows="0" maxlength="500"
			tabindex="1" class="auto"><%out.print(otherTreatment); %></textarea>
<div class="clear"></div>

<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="4" >
	      	<div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div>
			 </td>
	</tr>
	<tr>
		<th scope="col">Investigation </th>
		<!-- <th scope="col">Refer to MH</th> -->
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

		
	<%int inc=1;
			String investigationName = "";
			
		if(patientInvestigationHeaderListForFollowUp.size() >0){
			
			for (DgOrderhd dgorderhd : patientInvestigationHeaderListForFollowUp){
				patientInvestigationdetails = dgorderhd.getDgOrderdts();
		for (DgOrderdt patientInvestigation : patientInvestigationdetails) {
			investigationName = patientInvestigation
					.getChargeCode().getChargeCodeName()
					+ "["
					+ patientInvestigation.getChargeCode().getId()
					+ "]";
			boolean sampleCollected = false;
			 
			if(!patientInvestigation.getOrderStatus().equalsIgnoreCase("p"))
			{
				sampleCollected = true;
			}
		
		%> 
		<tr>
		<td>	<input type="hidden" tabindex="1" id="dgOrderDtId<%=inc %>" name="dgOrderDtId<%=inc %>" value="<%=patientInvestigation.getId()%>"
			size="10" readonly /> 
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:2,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName<%=inc %>'});
				  
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" />  <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 
			
			<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %> --%>
		<%-- <td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc %>',document.getElementById('visitId').value);" id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=(HMSUtil.convertDateToStringTypeDateOnly(dgorderhd.getOrderDate())).trim()%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td> --%>
			<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td>
		<%if(!sampleCollected) {%>
		  <input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" />
			<%}
		else{%>
			Sample Collected
		<%}%>
	    </td>


	</tr>
	<%inc++;}
		}
		%>
			<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
		<%}else{ %>
	
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%>
				
			   <script type="text/javascript"	language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> 
				
				
				<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>


</table>
</div>
<label>Other Investigation</label>
<textarea name="otherInvestigation" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"><%=otherInvestigation%></textarea>
<div class="clear paddingTop15"></div>
</div>


	 <input id="pHeaderId" name="pHeaderId" type="hidden" value="<%=pHeaderId%>" />
	 <input id="visitId" name="visitId" type="hidden" value="<%=visitId%>" />   
	<input name="dgOrderHdId" type="hidden" value="<%=dgOrderHdId%>" />	
				 <input name="consultationDate" id="consultationDate" type="hidden" value="<%=currentDate%>" />
	     <input name="consultationTime" type="hidden" value="<%=currentTime%>" />
	     <input name="divisionId" type="hidden" value="<%=divisionId%>" /> 
	     
<input name="Submit11" type="button" tabindex="1" align="right"
		class="button" value="Update"onclick="submitForm('facDetails','opd?method=submitFAC');"/> <input
		name="Reset" type="button" tabindex="1" align="right" class="button"
		value="Back" onclick="window.history.go(-1);"/> 
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currentDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>

       </form>

<%} %>


<script>
/* function addRow(){
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
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
	      						checkItem(iteration);checkForAlreadyIssuedPrescription(this.value,iteration,'0');displayAu(this.value,iteration,'0');checkForPurchase(this.value, iteration);
						   }
	  					  };
	  
	  					var newdiv = document.createElement('div');
	  		     	    newdiv.id='ac2update'+iteration;
	  		     	    newdiv.className='autocomplete';
	  		       	newdiv.style.display = 'none';
	  		          e0.size = '60';
	  			        e0.setAttribute('tabindex','1');

	  				var e01 = document.createElement('input');
	  			  e01.type = 'hidden';
	  			  e01.name = 'itemId' + iteration;
	  			  e01.id = 'itemId' + iteration;
	  			  e0.focus();
	  			  cellRight0.appendChild(e0);
	  			  cellRight0.appendChild(e01);
	  			  cellRight0.appendChild(newdiv);
	  
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nomenclature'+iteration});
	 
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.readOnly=true;
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11);
//

	  var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemClass'+iteration;
	  e12.id='itemClass'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');

	  cellRight2.appendChild(e12); 


	  
	   var cellRight14 = row.insertCell(3);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');

	  cellRight14.appendChild(e12); 
	  
	  //
	  
	  
	  var cellRight3 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  //added by Babita
	  
	  
	  
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight3.appendChild(e15);
	  
	  var e016 = document.createElement('input');
	  e016.type = 'hidden';
	  e016.name='itemClassCode'+iteration;
	  e016.id='itemClassCode'+iteration
	  e016.size='6';
	  e016.setAttribute('tabindex','1');
	  cellRight3.appendChild(e016);
	  
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dispensingUnit'+iteration;
	  e13.id='dispensingUnit'+iteration
	  e13.readOnly=true;
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);

	 
	  cellRight3.appendChild(e1);
	  
	  var cellRight4 = row.insertCell(5);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(6);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	    for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      } 
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(7);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);


	  var cellRight7 = row.insertCell(8);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.setAttribute('validate','total,num,no');
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight7.appendChild(e5);
	  
		var cellRight8 = row.insertCell(9);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6);

	  var cellRight9 = row.insertCell(10);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

	  var cellRight11 = row.insertCell(11);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(12);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(13);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);
} */
	
	
function addNomenclatureRow(){
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.size="53";
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
	      						checkItem(iteration);checkForAlreadyIssuedPrescription(this.value,iteration,'0');displayAu(this.value,iteration,'0');checkForPurchase(this.value, iteration);
						   }
	  					  };
	  
	  					var newdiv = document.createElement('div');
	  		     	    newdiv.id='ac2update'+iteration;
	  		     	    newdiv.className='autocomplete';
	  		       	newdiv.style.display = 'none';
	  			        e0.setAttribute('tabindex','1');

	  				var e01 = document.createElement('input');
	  			  e01.type = 'hidden';
	  			  e01.name = 'itemId' + iteration;
	  			  e01.id = 'itemId' + iteration;
	  			  e0.focus();
	  			  cellRight0.appendChild(e0);
	  			  cellRight0.appendChild(e01);
	  			  cellRight0.appendChild(newdiv);
	  
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'purchaseOrder?method=getItemListForPurchaseOrderForFAC',{parameters:'requiredField=nomenclature'+iteration});
	 
/* 	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.readOnly=true;
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11); */


/* 	  var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemClass'+iteration;
	  e12.id='itemClass'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	  cellRight2.appendChild(e12);  */


	  
/* 	   var cellRight14 = row.insertCell(3);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');

	  cellRight14.appendChild(e12);  */
	  
	  //
	  
	  
	  var cellRight3 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  //added by Babita
	  
	  
	  
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight3.appendChild(e15);
	  
	  var e016 = document.createElement('input');
	  e016.type = 'hidden';
	  e016.name='itemClassCode'+iteration;
	  e016.id='itemClassCode'+iteration
	  e016.size='6';
	  e016.setAttribute('tabindex','1');
	  cellRight3.appendChild(e016);
	  
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dispensingUnit'+iteration;
	  e13.id='dispensingUnit'+iteration
	  e13.readOnly=true;
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);

	 
	  cellRight3.appendChild(e1);
	  
	  var cellRight4 = row.insertCell(2);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(3);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	    for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      } 
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);


	  var cellRight7 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.setAttribute('validate','total,num,no');
	  e5.size='3';
	  e5.setAttribute('tabindex','1');
	  cellRight7.appendChild(e5);
	  
		/* var cellRight8 = row.insertCell(9);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6); */

	  var cellRight9 = row.insertCell(6);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('placeholder','1-1-1');
	  e7.setAttribute('maxlength', 15); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

	  
	  
	  var cellRight11 = row.insertCell(7);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addNomenclatureRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);
}
		function removeRow(idName,countId,obj)
		{
		  var tbl = document.getElementById(idName);
		  var lastRow = tbl.rows.length;
		  if (lastRow >=1){
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
		

		function addRowForInvestigation(){

			  var tbl = document.getElementById('investigationGrid');
			  var lastRow = tbl.rows.length;

			  // if there's no header row in the table, then iteration = lastRow + 1
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			  var hdb = document.getElementById('hiddenValue');
			  var iteration = parseInt(hdb.value)+1;
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
			  newdiv1.id='ac2update'+iteration;
			  newdiv1.className='autocomplete';
			  newdiv1.style.display = 'none';
			  					
			  e0.name = 'chargeCodeName' + iteration;
			  e0.id = 'chargeCodeName' + iteration;
			  e0.setAttribute('tabindex','1');
			  //alert("name--"+e0.name)
			  e0.size = '100'
			  cellRight0.appendChild(newdiv1);
			  
			  cellRight0.appendChild(e0);
			  e0.focus();
			
			  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{callback: function(element, entry) { return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;},parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
			  																																								
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
			
			 var cellRight2 = row.insertCell(1);
			  var e4 = document.createElement('input');
			  e4.type = 'button';
			  e4.className = 'buttonAdd';
			  e4.value = "";
			  e4.name='Button';
			  e4.setAttribute('tabindex','1');
			  //e4.setAttribute('onClick','addRowForInvestigation();');
			  e4.onclick = function(){addRowForInvestigation();}; 
			  cellRight2.appendChild(e4);

			  var cellRight3 = row.insertCell(2);
			  var e5 = document.createElement('input');
			  e5.type = 'button';
			  e5.className = 'buttonDel';
			  e5.value = ""
			  e5.name='delete';
			  e5.setAttribute('tabindex','1');
			  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
			  cellRight3.appendChild(e5);
			  
			  
			}
		</script>