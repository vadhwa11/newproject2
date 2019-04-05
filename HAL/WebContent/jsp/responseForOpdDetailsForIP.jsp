
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>


<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<title></title>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList") != null)
	{
		opdDetailsList=(List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	if(opdDetailsList.size() > 0){
		opdPatientDetails = opdDetailsList.get(0);
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	List<PatientPrescriptionDetails> opdPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
	List<PatientInvestigationDetails> opdInvestigationList = new ArrayList<PatientInvestigationDetails>();
	List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
	List<ProcedureDetails> opdProcedureList = new ArrayList<ProcedureDetails>();
	List<PhysioRequisitionDetail> opdPhysiotherapyList = new ArrayList<PhysioRequisitionDetail>();
	List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<MasMedicalExamFamilyHis> familyHistoryList = new ArrayList<MasMedicalExamFamilyHis>();
	List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
	
	if(map.get("opdPrescriptionList") != null){
		opdPrescriptionList=(List<PatientPrescriptionDetails>)map.get("opdPrescriptionList");
	}
	if(map.get("opdInvestigationList") != null){
		opdInvestigationList=(List<PatientInvestigationDetails>)map.get("opdInvestigationList");
	}
	if(map.get("icdList") != null){
		icdList=(List<DischargeIcdCode>)map.get("icdList");
	}
	if(map.get("opdProcedureList") != null){
		opdProcedureList=(List<ProcedureDetails>)map.get("opdProcedureList");
	}
	if(map.get("opdPhysiotherapyList") != null){
		opdPhysiotherapyList=(List<PhysioRequisitionDetail>)map.get("opdPhysiotherapyList");
	}
	if(map.get("opdHistoryDetailsListForFollowUp") != null){
		opdHistoryDetailsListForFollowUp=(List)map.get("opdHistoryDetailsListForFollowUp");
	}
	if(map.get("familyHistoryList") != null){
		familyHistoryList=(List<MasMedicalExamFamilyHis>)map.get("familyHistoryList");
	}
	if(map.get("ipdPatientDietList") != null){
		ipdPatientDietList=(List<IpdPatientDiet>)map.get("ipdPatientDietList");
	}
	OpdPatientHistory opdPatientHistory = null;
	
	if(opdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = opdHistoryDetailsListForFollowUp.get(0);
	}
	Map<String,Object> orderDetailMap = new HashMap<String,Object>();
	List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
	List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
	List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
	List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
	List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
	List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
	List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();
	List<DgResultEntryHeader> dgResultEntryHeaderTemplateList = new ArrayList<DgResultEntryHeader>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<String> scdRadioInvestigationList = new ArrayList<String>();
	
	if (map.get("orderDetailMap") != null){
		orderDetailMap =(Map)map.get("orderDetailMap");
	}
	if (orderDetailMap.get("dgOrderdtList") != null){
		orderdtList =(List)orderDetailMap.get("dgOrderdtList");
	}
	if (orderDetailMap.get("dgMasInvestigationList") != null){
		dgMasInvestigationList = (List)orderDetailMap.get("dgMasInvestigationList");
	}
	if (orderDetailMap.get("dgSampleCollectionDetailsList") != null){
		dgSampleCollectionDetailsList = (List)orderDetailMap.get("dgSampleCollectionDetailsList");
	}
	if (orderDetailMap.get("scdRadioInvestigationList") != null){
		scdRadioInvestigationList = (List)orderDetailMap.get("scdRadioInvestigationList");
	}
	
	if (orderDetailMap.get("dgResultEntryDetailList") != null){
		dgResultEntryDetailList = (List)orderDetailMap.get("dgResultEntryDetailList");
	}
	if (orderDetailMap.get("dgSampleCollectionDetailsLabList") != null){
		dgSampleCollectionDetailsLabList = (List)orderDetailMap.get("dgSampleCollectionDetailsLabList");
	}
	if (orderDetailMap.get("dgResultEntryDetailLabList") != null){
		dgResultEntryDetailLabList = (List)orderDetailMap.get("dgResultEntryDetailLabList");
	}
	if (orderDetailMap.get("dgResultEntryHeaderLabList") != null){
		dgResultEntryHeaderLabList = (List)orderDetailMap.get("dgResultEntryHeaderLabList");
	}
	if (orderDetailMap.get("dgResultEntryHeaderSensitiveLabList") != null){
		dgResultEntryHeaderSensitiveLabList = (List)orderDetailMap.get("dgResultEntryHeaderSensitiveLabList");
	}
	if (orderDetailMap.get("dgResultEntryHeaderTemplateList") != null){
		dgResultEntryHeaderTemplateList = (List)orderDetailMap.get("dgResultEntryHeaderTemplateList");
	}
	DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
	DgOrderdt dgOrderdt = new DgOrderdt();

	%>


<%@page import="jkt.hms.masters.business.IpdPatientDiet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>

<%

if((opdPatientHistory.getPresentComplain()!=null && !opdPatientHistory.getPresentComplain().equals(""))
|| 	(opdPatientHistory.getPastMedicalHistory()!=null && !opdPatientHistory.getPastMedicalHistory().equals(""))
|| (opdPatientHistory.getRiskFactor()!=null && !opdPatientHistory.getRiskFactor().equals(""))){
%>

<div class="Block">
<label>Complaints</label>
<%
if(opdPatientHistory.getPresentComplain()!=null){
%>
<label class="valueAuto"><%=opdPatientHistory.getPresentComplain()!=null?opdPatientHistory.getPresentComplain():"&nbsp;" %> </label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>

<label >Past Medical History</label> 
<%
if(opdPatientHistory.getPastMedicalHistory()!=null){
%>
<label class="valueAuto"><%=opdPatientHistory.getPastMedicalHistory()!=null?opdPatientHistory.getPastMedicalHistory():"" %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
<%
if(familyHistoryList.size() > 0){
%>
<label>Family History</label>
<%String familyHistory = "";

	for(MasMedicalExamFamilyHis familyHis : familyHistoryList){
		if(!familyHistory.equals("")){
			familyHistory += ",";
		}
		familyHistory += familyHis.getPatientFamilyHistory().getPatientHistoryName();
	}
	if(!familyHistory.equals("")){
%> 
<label class="valueAuto"><%=familyHistory %></label>
<%}else{
	
	%>
<label class="value">&nbsp;</label>
<%
}
	} %>

<label >Risk Factors</label>
<%
if(opdPatientHistory.getRiskFactor()!=null){
%>
<label class="valueAuto"><%=opdPatientHistory.getRiskFactor()!=null?opdPatientHistory.getRiskFactor():"&nbsp;" %></label>
<%}else{ %>
<label class="value">&nbsp;</label>

<%} %>
<div class="clear"></div>
</div>
<%} %>

<div class="clear"></div>
<%
	if(opdPatientDetails !=null && ( opdPatientDetails.getVweight()!=null || opdPatientDetails.getHeight()!=null || opdPatientDetails.getBmi()!=null || opdPatientDetails.getIdealWeight()!=null
			|| opdPatientDetails.getTemperature()!=null || opdPatientDetails.getPulse()!=null || opdPatientDetails.getBp()!=null || opdPatientDetails.getRr()!=null ||  opdPatientDetails.getOnExamination()!=null)){
%>
<h4>Vitals</h4>
<div class="Block">
<label class="">Weight</label>
<input name="" tabindex="1" type="text" id="" readonly="readonly" value="<%=opdPatientDetails !=null && opdPatientDetails.getVweight()!=null?opdPatientDetails.getVweight():"" %>"  onblur="calculateIdealWeight();calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
<label class="unit">kg</label> 

<label  class="">Height</label> 
<input name="" tabindex="1" type="text" id="" readonly="readonly" value="<%=opdPatientDetails !=null && opdPatientDetails.getHeight()!=null?opdPatientDetails.getHeight():"" %>" class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5" validate="height,int,no"  maxlength="3" />
<label class="unit">cm</label>

 <label	class="">BMI</label> 
<input tabindex="1" type="text" id="" name=""  readonly="readonly" maxlength="6" value="<%=opdPatientDetails != null && opdPatientDetails.getBmi()!=null?opdPatientDetails.getBmi():"" %>" onKeyUp="limitText(this,6);" class="auto" size="5" />
<label class="unit">kg/m<sup>2</sup></label> 
  <div class="clear"></div>
<label	class="">Ideal Weight</label>
 <input name="" type="text" id="" readonly="readonly" tabindex="1" class="auto" size="5" value="<%=opdPatientDetails!= null && opdPatientDetails.getIdealWeight()!=null ?opdPatientDetails.getIdealWeight():"" %>" tabindex="1" validate="Ideal Weight,string,no" maxlength="3" />
 <label class="unit">kg</label> 
 <label class="">Temperature</label>
 <input name="" id="" type="text" tabindex="1" readonly="readonly" value="<%=opdPatientDetails!= null && opdPatientDetails.getTemperature()!=null?opdPatientDetails.getTemperature():"" %>" class="auto" size="5" maxlength="5" />
 <label class="unit">&deg;F</label>
 <label	class="">Pulse</label>
 <input name="" type="text" tabindex="1" readonly="readonly" value="<%=opdPatientDetails != null && opdPatientDetails.getPulse()!=null?opdPatientDetails.getPulse():"" %>" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 <label class="unit">/min</label> 
   
   <div class="clear"></div>
   
 <label class="">BP</label>
 <input	name="" id="" type="text" tabindex="1" readonly="readonly" value="<%=opdPatientDetails != null && opdPatientDetails.getBp()!=null?opdPatientDetails.getBp():"" %>" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
 <label class="unit">mm/Hg</label>
 <label class="">RR</label>
 <input	name="" id="" type="text" tabindex="1" readonly="readonly" value="<%=opdPatientDetails != null && opdPatientDetails.getRr()!=null?opdPatientDetails.getRr():"" %>" class="auto" size="5" maxlength="3" />
 <label class="unit">/min</label>

<div class="clear"></div>
 
 <label>On Examination</label>	
<textarea name="" cols="120" rows="0" readonly="readonly" maxlength="300" class="auto" tabindex="1"  onkeyup="return ismaxlength(this)"><%=opdPatientDetails != null && opdPatientDetails.getOnExamination()!=null?opdPatientDetails.getOnExamination():"" %></textarea>
  <div class="clear"></div>
<div class="clear"></div>
</div>
<%} %>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Case Notes</th>

	</tr>
	<tr>
	<td><input type="text" name="" tabindex="1" value="<%=opdPatientDetails.getCaseNotes()!=null?opdPatientDetails.getCaseNotes():"" %>" size="190" maxlength="45" /></td>
	</tr>
</table>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">


<!-- 	<label >On Examination</label>  -->
<input	type="hidden" id="" class="large" name=""	maxlength="200" />
<label>Working Diagnosis</label>
<label class="value"><%=opdPatientDetails.getInitialDiagnosis()!=null?opdPatientDetails.getInitialDiagnosis():"" %></label>

<label>System Diagnosis</label>
<label class="value"><%=opdPatientDetails.getSystemDiagnosis()!=null?opdPatientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>
<div class="clear"></div>

<label>ICD Diagnosis</label>
<%String diagnosis = "";
if(icdList.size() > 0){
	for(DischargeIcdCode dischargeIcdCode : icdList){
		if(!diagnosis.equals("")){
			diagnosis += ",";
		}
		diagnosis += dischargeIcdCode.getIcd().getIcdName();
	}
}
%> 
<%
	if(!diagnosis.equals("")){
%>
<label class="valueAuto"><%=diagnosis %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
</div>
<%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %> <script>

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
            </script> <% }%>
<div class="clear"></div>
<div class="clear paddingTop15"></div>

<h4>Treatment</h4>

	<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdgrid">
	<tr>
		 <th scope="col">Nomenclature</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
	
		
	</tr>
	<%System.out.println("opdPrescriptionList--- "+opdPrescriptionList.size());
	int l =1;
		if(opdPrescriptionList.size() > 0){
			for(PatientPrescriptionDetails prescriptionDetails : opdPrescriptionList){
	%>
	<tr>
		<td>
	    <input type="text" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" id="" size="80"  name="" onblur="populatePVMS(this.value,'<%=l %>'),checkItem();"  />
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
	    </td>
	   
		<td><input type="hidden" name="" tabindex="1" id="" value="<%=prescriptionDetails.getItem().getPvmsNo() %>"	size="10" readonly="readonly" />
		<input type="text" name="" tabindex="1" value="<%=prescriptionDetails.getDosage() %>" id=""	size="10" maxlength="5" /></td>
		<td><%=prescriptionDetails.getFrequency().getFrequencyName()%>
		</td>

		<td><input type="text" name="" tabindex="1" id="" value="<%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>" onblur="fillValue(this.value,'<%=l %>')"  size="10"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="" tabindex="1" id=""  size="10" maxlength="20" value="<%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>"	 validate="Route,string,no" />
			<input type="hidden" name="" tabindex="1" id="" value="<%=prescriptionDetails.getTotal()!=null?prescriptionDetails.getTotal():"" %>"/>
		</td>
		<td><input type="text" name="" tabindex="1" id="" size="20" maxlength="40" value="<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %>"/>
			</td>
		
		
	</tr>
	
	<%
			l++;}}else{ %>
	<tr>
		<td  colspan="6">
	 &nbsp;</td>
		
	</tr>
<%} %>
</table>
<div class="clear"></div>

	<div class="clear paddingTop15"></div>
<h4>Investigation</h4>
<%
int inc = 1;
%>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Result</th>
		<th scope="col">Normal Value</th>
		
	</tr>
<%-- 	<%
		if(opdInvestigationList.size() > 0){
			for(PatientInvestigationDetails investigationDetails : opdInvestigationList){
				
	%>
	<tr>
		<td>
		<input type="text" value="<%=investigationDetails.getChargeCode().getChargeCodeName() %>" tabindex="1"  id="" size="100" name=""
		 	/>
		
		
		<input type="hidden" id="" tabindex="1" name=""	value="<%=investigationDetails.getQuantity() %>"	size="10" maxlength="6" validate="" /> 
		<input	type="hidden" tabindex="1" id="" value="<%=investigationDetails.getChargeCode().getChargeCodeCode() %>" name=""	size="10" readonly /> 
		</td>
	
		<td>
	&nbsp;
		</td>
	<td>
	&nbsp;
		</td>


	</tr>
<%inc++;}
		}else{ %>
<tr>
		<td  colspan="3">
		 &nbsp;
		</td>



	</tr>

<%} %>--%>
	<%
			boolean orderDtEmpty = true;
 			boolean dgSampleCollectionDtEmpty = true;
 			boolean dgResultDtEmpty = true;
 			boolean dgResultDtEmptyLab = true;
 			boolean dgSampleCollectionDtLabEmpty = true;
		if (orderdtList != null && orderdtList.size() > 0 
				&& dgMasInvestigationList!=null && dgMasInvestigationList.size()>0)
		{ %>

		<%
  			orderDtEmpty = false;
		Iterator<DgOrderdt> dgOrderdtIt = orderdtList.iterator();
		Iterator<DgMasInvestigation> dgMasInvestigationIt = dgMasInvestigationList.iterator();
		while(dgMasInvestigationIt.hasNext() && dgOrderdtIt.hasNext()){
			dgMasInvestigation = dgMasInvestigationIt.next();
			dgOrderdt = dgOrderdtIt.next();

			%>
			<tr>
			<td><%= dgMasInvestigation.getInvestigationName()%></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
	
		</tr>

		<%} %>

		<%} %>
		<!-- Loop for Printing DgSampleCollectionDetails For Lab -->
		<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsLabList){
			dgSampleCollectionDtLabEmpty = false;
			%>
	
		<tr>
				<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			<%} %>
			<!-- Loop for Printing DgResultEntryDetail For Lab -->
			<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailLabList){
			dgResultDtEmptyLab = false;
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
		
			<tr>
					<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>

					<% try{
    	if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		if(dgResultEntryDetail.getResult() != null 
    				&& !dgResultEntryDetail.getResult().equals("")){

    			Float result1   = Float.parseFloat(dgResultEntryDetail.getResult());
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %>
					<td><%=result%></td>
					<% }else{ %>
					<td style="color: red; font-weight: bold;"><%=result %></td>
					<% }
    		}else{%>
					<td>No Result Entered</td>
					<%}
	       }else{ %>
					<td><%=dgResultEntryDetail.getResult()%></td>
					<% } 
    }catch(Exception exception){ %>
					<td><%=dgResultEntryDetail.getResult()%></td>
					<% } %>

				
					<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
     		Float minValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
					<td><%=minValue%> - <%=maxValue %></td>
					<% }else{ %>
					<td>-</td>
					<% } %>

				</tr>

				<%} %>

				<!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
				<%for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next(); 
				String confidential = "";
				if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
				}else{
					confidential = "n";
				}
			%>
			
				<tr>
						<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
						<td>
						<!--  <span style="color: highlightred;">Click here toget Result/Report-->
						<input  id="Result" type="button" tabindex="1" name="Result"  value="Result" class="button" onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');" />
	
						</td>
						<td>&nbsp;</td>
						
					</tr>

					<%} %>

					<!-- Loop for Printing DgResultEntryHeader For Lab Only For Sensitive -->
					<%
		for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderSensitiveLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next(); 
				String confidential = "";
				System.out.println("Confi :"+dgResultEntryDetailSen.getInvestigation().getConfidential());
				if(dgResultEntryDetailSen.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
				}else{
					confidential = "n";
				}
			%>
					<tr>
						<td><%= dgResultEntryDetailSen.getInvestigation().getInvestigationName()%></td>
						<td>
						<!--  <span style="color: highlightred;">Click here to get Result/Report</span>-->
						</td>
						<td>&nbsp;</td>
					</tr>

					<%} %>

					<!-- Loop for Printing DgSampleCollectionDetails For Radiology -->
					<%int index = 0; %>
					<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
			dgSampleCollectionDtEmpty = false;
			String investigationName = scdRadioInvestigationList.get(index);
			%>
			
							<tr>
							<td><%= investigationName%></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							
						</tr>
						<%index++; %>
						<%} %>
						<!-- Loop for Printing DgResultDetails For Radiology-->
						<%index = 0; %>
						<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailList){
			dgResultDtEmpty = false;
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
					
				
							<tr>
						
								<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
								<td><input  id="Result" type="button" tabindex="1" name="Result"  value="Result" class="button" onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');"" />
								</td>
								<td>&nbsp;</td>
								
							</tr>

							<%} %>

</table>
	<div class="Clear"></div>
	<div class="clear paddingTop15"></div>
<h4>Procedure </h4>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdproceduregrid">
	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		
	</tr>
	<%
	int i=0;
	if(opdProcedureList.size() > 0){
		for(ProcedureDetails procedureDetails : opdProcedureList){
	%>
	<tr>
		<td>
		<input type="text" name="" id="" value="<%=procedureDetails.getNursingCare().getNursingName() %>" size="95" onblur="if(this.value!=''){getProcedureId(this.value,<%=i %>);}"/>
			
		<input type="hidden" name="" id=""	value="<%=procedureDetails.getNursingCare().getId() %>" /> 
		</td>
		<td>	
			<input	type="text" name="" value="<%=procedureDetails.getRemarks()!=null?procedureDetails.getRemarks():"" %>" id="remarks<%=i %>" size="90" />
			</td>
	
	</tr>
	<%i++;}
	}else{ %>
	<tr>
		<td  colspan="2">
		 &nbsp;
			</td>
	
	</tr>
	<%} %>
	</table>
	<div class="clear paddingTop15"></div>
<h4>Physiotherapy </h4>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdtherapygrid">
<tr>
		<th scope="col">Therapy Name</th>
		<th scope="col">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Remarks</th>
	
	</tr>
	<%
	int j = 1;
	if(opdPhysiotherapyList.size() > 0){
		for(PhysioRequisitionDetail physioRequisitionDetail : opdPhysiotherapyList){
	%>
<tr>
	<td>
	    <input type="text" value="<%=physioRequisitionDetail.getTharaphy().getTherapyTypeName() %>" tabindex="1" id="" size="70"  name="" />
	    
	   
	    
			
			<input type="hidden" name="" id=""	value="<%=physioRequisitionDetail.getTharaphy().getId() %>" />
		</td>
		
	<td><input type="text" name="" tabindex="1" id="" value="<%=physioRequisitionDetail.getDuration()!=null?physioRequisitionDetail.getDuration():"" %>"	size="12" maxlength="5" /></td>
	
	<td><%=physioRequisitionDetail.getFrequency().getFrequencyName()%></td>
		
	<td><input type="text" name="" tabindex="1" id=""  size="8" value="<%=physioRequisitionDetail.getNoOfDays()!=null?physioRequisitionDetail.getNoOfDays():"" %>"	maxlength="3" validate="No Of Days,num,no" /></td>
	<td><input type="text" name="" tabindex="1" id="" value="<%=physioRequisitionDetail.getRemark()!=null?physioRequisitionDetail.getRemark():"" %>" size="70" maxlength="40"/>
			</td>
				
	</tr>

<%j++;}
	}else{ %>
<tr>
	<td colspan="5">
	  &nbsp;</td>
	
		
	</tr>
<%} %>	
</table>
<div class="Clear"></div>
<div class="clear paddingTop15"></div>
<%
	if(opdPatientDetails.getInpatient()!=null){
%>
<h4>Diet Setup</h4>
<div class="Clear"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="dietgrid">
<tr>
		<th scope="col">Type of Diet</th>
		<th scope="col">Spl. Instructions</th>
	
	</tr>
	<%
		if(ipdPatientDietList.size()>0){
		for(IpdPatientDiet patientDiet : ipdPatientDietList){
			
	%>
	<tr>
	<td><%=patientDiet.getDiet().getDietName() %>
	
	</td>
	<td><%=patientDiet.getSplInstructions()!=null?patientDiet.getSplInstructions():"" %></td>
	</tr>
	
	<%} 
	}%>
</table>
<%} %>
<div class="Clear"></div>
<div class="paddingTop15"> </div>
