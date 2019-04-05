<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * prescriptionEntryDetailsView.jsp
 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 20th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>


<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="java.math.BigDecimal"%><script type="text/javascript" language="javascript"  src="/hms/jsp/js/IPDGrid.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script> -->
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";



	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	int hinId=0;
	if(map.get("patId") != null){
		hinId=(Integer)map.get("patId");
	}
	int deptId=0;
	if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
	}
	String caretime=(String)map.get("caretime");
	Set patientSet = new HashSet();
	//session.setAttribute("careId",careId);
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	List<PatientPrescriptionDetails>patientPresriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
	List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
	List<StoreIpIssueT> ipIssueDetailList = new ArrayList<StoreIpIssueT>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String currentTime = (String) utilMap.get("currentTimeWithoutSc");
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("frequencyList") != null) {
		frequencyList = (List<MasFrequency>) map.get("frequencyList");
	}
	if (map.get("inPatientDetailList") != null) {
		inPatientDetailList = (List<Inpatient>) map.get("inPatientDetailList");

	}
	if (map.get("itemBatchStockList") != null) {
		itemBatchStockList = (List<StoreItemBatchStock>) map.get("itemBatchStockList");

	}
	if (map.get("ipIssueDetailList") != null) {
		ipIssueDetailList = (List<StoreIpIssueT>) map.get("ipIssueDetailList");

	}
	if (map.get("patientPresriptionDetailList") != null) {
		patientPresriptionDetailList = (List<PatientPrescriptionDetails>) map.get("patientPresriptionDetailList");

	}
	if (map.get("patientPrescriptionHeaderList") != null) {
		patientPrescriptionHeaderList = (List<PatientPrescriptionHeader>) map.get("patientPrescriptionHeaderList");

	}
	Properties properties = new Properties();
	URL resourcePath =

Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor =properties.getProperty("empCategoryCodeForDoctor");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String initDiagnosis ="";
	 String currentAge = "";
	 String consultantName = "";
	 String currentDate = "";
		String time = "";
		int hospitalId = 0;
		int inpatientId = 0;
		String admissionNumber = "";
		String patientName = "";
		String serviceno = "";
		String rank = "";
		String unit = "";
		String doa = "";
		String dod = "";
		String relation = "";
		String age = "";
		String sex = "";
		int departmentId =0;
		Inpatient inpatient = null;
		Patient patient = null;
		String category_name = "";
		String servicetype = "";
		String hinNo ="";
	try
	{
		inpatient = (Inpatient) inPatientDetailList.get(0);
		patient = (Patient) inpatient.getHin();
		MasRank masRank = (MasRank) patient.getRank();
		MasRelation masRelation = (MasRelation) patient.getRelation();
		
				
				try
				{
					servicetype = patient.getServiceType().getServiceTypeName();
				}
				catch(Exception e)
				{
					servicetype="";
				}
				if(inpatient.getInitDiagnosis()!= null)
				{
					initDiagnosis = inpatient.getInitDiagnosis();
				}
				
				try 
				{
					patientName = inpatient.getHin().getPFirstName() ;
					  
					   if(inpatient.getHin().getPMiddleName()!= null){
						   patientName=patientName+" "+inpatient.getHin().getPMiddleName();
					   }
					   if(inpatient.getHin().getPLastName()!= null){
						   patientName=patientName+" "+inpatient.getHin().getPLastName();
					   }
				} 
				catch (Exception e) 
				{
					patientName = "";
				}
				    if(patient.getAge()!=null)
						age = patient.getAge();
					
				try{
					if(!age.equals(""))
					currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
				try 
				{
					consultantName=inpatient.getDoctor().getRank().getRankName();
					consultantName +=" "+ inpatient.getDoctor().getFirstName();
					if(inpatient.getDoctor().getMiddleName() != null){
						consultantName += " "+inpatient.getDoctor().getMiddleName();
					}
					if(inpatient.getDoctor().getLastName() != null){
						consultantName += " "+inpatient.getDoctor().getLastName();
					}
				} 
				catch (Exception e){ 

					consultantName = "";
				}
				
				try 
				{
					admissionNumber = inpatient.getAdNo();
				} 
				catch (Exception e) 
				{
					admissionNumber = "";
				}

				try 
				{
					serviceno = inpatient.getHin().getServiceNo();
				} 
				catch (Exception e) 
				{
					serviceno = "";
				}
				
				try 
				{
					rank = masRank.getRankName();
				} 
				catch (Exception e) 
				{
					rank = "";
				}
				
				try 
				{
					unit = patient.getUnit().getUnitName();
				} 
				catch (Exception e) 
				{
					unit = "";
				}
				
				try 
				{
					age = inpatient.getAge();
				} 
				catch (Exception e) 
				{
					age = "";
				}

				try 
				{
					sex = inpatient.getHin().getSex().getAdministrativeSexName();
				} 
				catch (Exception e) 
				{
					sex = "";
				}

				if(inpatient.getDateOfAddmission() != null) 
				{
					doa = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
				} 
				
				if(inpatient.getDischargeDate() != null) 
				{
					dod = HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate());
				} 
				
				try 
				{
					hinId = inpatient.getHin().getId().intValue();
				} 
				catch (Exception e) 
				{
					hinId = 0;
				}
				try 
				{
					hinNo = inpatient.getHin().getHinNo();
				} 
				catch (Exception e) 
				{
					hinNo = "";
				}
				try 
				{
					departmentId = inpatient.getDepartment().getId().intValue();
				} 
				catch (Exception e) 
				{
					departmentId = 0;
				}
				try 
				{
					inpatientId = inpatient.getId().intValue();
				} 
				catch (Exception e) 
				{
					inpatientId = 0;
				}
				
				try 
				{
					relation = masRelation.getRelationName();
				} 
				catch (Exception e) 
				{
					relation = "";
				}
				
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	Box box = HMSUtil.getBox(request);
%>
<%	
String message = "";		
if(map.get("message") != null){
		    message = (String)map.get("message");
		
		  }
    %>
  
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
<h4><%=message %></h4>
<div class="Clear"></div>
<form name="medicineIssue" method="post">
    <div class="titleBg"><h2>Medicine Issue</h2></div>
    <input type="hidden" value="<%=hinId %>" name="hinId" id="hinId"/>
    <input type="hidden" value="<%=box.getInt("deptId") %>" name="deptId" id="deptId"/>
    <input type="hidden" value="<%=inpatientId %>" name="inPatientId" id="inPatientId"/>
  <%
		List ipIssueNo=(List)map.get("ipIssueNo");
  StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
  	if(ipIssueNo.size()>0){
  		
	 storeFyDocumentNo= (StoreFyDocumentNo)ipIssueNo.get(0);
  	}
		
		int issueNoOfPatient=(Integer)map.get("issueNoOfPatient");
		System.out.println("issueNoOfPatient=="+issueNoOfPatient);
	%> 

<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>" />
<input	type="hidden" id="issueNo" name="issueNo" value="<%=issueNoOfPatient%>" />
<div class="Clear"></div>
<h4>Patient Details</h4>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Service No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Rank</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>

<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>


<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>
<div class="Clear"></div>
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>

<div class="Clear"></div>

<label>Admitting MO</label>
<label class="value"><%=consultantName %></label>


<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %>
<div class="Clear"></div>

<label> Diagnosis</label> 
<%
List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%> 

<div class="Clear"></div>
</div>

<%-- 
 <label>Date Prescribed </label> 
<select id="prescriptionHeaderId" name="prescriptionHeaderId"  tabindex="1" onchange="submitProtoAjax('medicineIssue','/hms/hms/ipd?method=getMedicineDetailList')" validate="Date Prescribed,String,yes" >
	<option value="0">Select</option>
<%if(patientPrescriptionHeaderList.size()>0){
	 for(PatientPrescriptionHeader patientPrescriptionHeader :patientPrescriptionHeaderList){
	%>
	<option value="<%=patientPrescriptionHeader.getId() %>"><%=HMSUtil.convertDateToStringWithoutTime(patientPrescriptionHeader.getPrescriptionDate())+" "+ patientPrescriptionHeader.getPrescriptionTime() %></option>
	<%}} %>
	</select>--%>
	<%--
<div class="Block">

<label>Issue Date </label>
<input	type="text" name="issueDate" id="issueDate" validate="Issue Date,string,yes" value="<%=date %>" MAXLENGTH="8" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender" onClick="setdate('<%=date %>',document.medicineIssue.issueDate,event)" />
	</select>
<label>Issue Time <span>*</span></label> 
 <input	type="text" name="issueTime" id="issueTime" validate="Issue Time,string,yes" value="<%=currentTime %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
</div>
 --%>
 <input	type="hidden" name="issueDate" id="issueDate" validate="Issue Date,string,yes" value="<%=date %>" MAXLENGTH="8" class="date" readonly="readonly"/>
 <input	type="hidden" name="issueTime" id="issueTime" validate="Issue Time,string,yes" value="<%=currentTime %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
 
<div class="Clear paddingTop15"></div>
<div class="Clear"></div>
<input type="button" name="Submit" id="addbutton" value="View Issued Medicine" class="buttonBig" onClick="openPopupForView();"
accesskey="a" />
<div id="testDiv"></div>
<div class="Clear paddingTop15"></div>
<h4>Patient Issue Details</h4>
<div class="Clear"></div>
<div class="cmntable">
<table>
<tr>
			<th>Nomenclature</th>
			<th>Barcode</th>
			<th>Batch No.</th>
			<th>Dosage</th>
			<th>Frequency</th>
			<th>No. of Days</th>
			<th>Route</th>
			<th>Stock</th>
			<th>Issue</th>
			<th>Stop</th>

</tr>
<%
int i=1;
if(patientPresriptionDetailList.size()>0){
		for(PatientPrescriptionDetails patientPrescriptionDetails :patientPresriptionDetailList){
	
			
%>

<tr>
	<%if(patientPrescriptionDetails.getItem() != null){ %>
		<td> <input type="text" value="<%=patientPrescriptionDetails.getItem().getNomenclature() %>" tabindex="1" id="nomenclature<%=i%>" size="30"  name="nomenclature<%=i%>"  />
		 <input type="hidden" value="<%=patientPrescriptionDetails.getItem().getId() %>" name="item<%=i%>" id="item<%=i%>"/>
		 <input type="hidden" value="<%=patientPrescriptionDetails.getId() %>" name="prescriptionDetailId<%=i%>" id="prescriptionDetailId<%=i%>"/></td>
	<%} %>
	<td><input type="text" name="barcode<%=i %>" value="" id="barcode<%=i %>" size="10" onchange="getItemStock(this.value,<%=i %>,'barcode')"/></td>
	<td><select name="batchId<%=i%>" id="batchId<%=i%>" tabindex="1" >
			<option value="0">Select</option>
		<%
			boolean stockAvailable = false;
		BigDecimal stock = new BigDecimal(0);
		if(itemBatchStockList.size()>0){
			for(StoreItemBatchStock itemBatchStock :itemBatchStockList){
				if(patientPrescriptionDetails.getItem().getId().equals(itemBatchStock.getItem().getId())){
				//expiryDate = itemBatchStock.getExpiryDate();
				stockAvailable = true;
				if(stock.compareTo(new BigDecimal(0)) == 0){
					stock = itemBatchStock.getClosingStock();
				}else{
					BigDecimal clStock = new BigDecimal(0);
					clStock = itemBatchStock.getClosingStock();
					stock = stock.add(clStock);
		
				}
			%>
			<option value="<%=itemBatchStock.getId() %>" ><%=itemBatchStock.getBatchNo()%></option>
			
			<%}
			}}
		
		%>
		</select> 
		<%if(itemBatchStockList.size()>0){
			for(StoreItemBatchStock itemBatchStock :itemBatchStockList){
				if(patientPrescriptionDetails.getItem().getId().equals(itemBatchStock.getItem().getId())){
				//expiryDate = itemBatchStock.getExpiryDate();
			%>
		<input type="hidden" value="<%=(itemBatchStock.getExpiryDate()!=null && !itemBatchStock.getExpiryDate().equals(""))?HMSUtil.convertDateToStringWithoutTime(itemBatchStock.getExpiryDate()):""%>" name="expiryDate<%=i%>" id="expiryDate<%=i%>"/>
		<%}
			}} %>
		</td>
	<% 
		if(patientPrescriptionDetails.getDosage() != null){
	%>
		<td><input type="text" name="dosage<%=i%>" tabindex="1" id="dosage<%=i%>" value="<%=patientPrescriptionDetails.getDosage() %>"	size="5" maxlength="5" />
				</td>
		<%}else{ %>
		<td><input type="text" name="dosage<%=i%>" tabindex="1" id="dosage<%=i%>" value=""	size="5" maxlength="5" />
		</td>
		<%} %>

<td><select name="frequency<%=i%>" id="frequency<%=i%>" tabindex="1" >
			<option value="0">Select</option>
		<%if(frequencyList.size()>0){
			for(MasFrequency frequency :frequencyList){
				if(patientPrescriptionDetails.getFrequency()!= null){
					if(patientPrescriptionDetails.getFrequency().getId().equals(frequency.getId())){
				
			%>
			<option value="<%=frequency.getId() %>" selected="selected"><%=frequency.getFrequencyName()%></option>
			<%}else{%>
			<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName()%></option>
			<%}}}} %>
		</select> 
		</td>
		<%if(patientPrescriptionDetails.getNoOfDays()!= null){ %>
		<td><input type="text" name="noOfDays<%=i%>" tabindex="1" id="noOfDays<%=i%>"  value="<%=patientPrescriptionDetails.getNoOfDays() %>"  size="3"	maxlength="3" validate="No Of Days,num,no" /></td>
		<%}else{ %>
		<td><input type="text" name="noOfDays<%=i%>" tabindex="1" id="noOfDays<%=i%>"   size="3"	maxlength="3" validate="No Of Days,num,no" /></td>
		<%} %>
	<%if(patientPrescriptionDetails.getRoute()!= null){ %>
		<td><input type="text" name="route<%=i%>" tabindex="1" id="route<%=i%>" value="<%=patientPrescriptionDetails.getRoute() %>" size="5" maxlength="20" validate="Route,string,no" /></td>
	<%}else{ %>
	  <td><input type="text" name="route<%=i%>" tabindex="1" id="route<%=i%>"  size="5" maxlength="20"	 validate="Route,string,no" /></td>
	  <%} %>
		<td><input type="text" name="stock<%=i %>" id="stock<%=i %>" value="<%=stock %>" readonly="readonly" /></td>
		<td>
		<%if(stockAvailable){
		%>
		<input type="checkbox" name="issued<%=i%>" class="radio" id="issued<%=i%>" value="y" />
		<%}else{ %>
		<input type="checkbox" name="issued<%=i%>" class="radio" id="issued<%=i%>" value="y" disabled="disabled"/>
		<%} %>
		</td>
		<td><input type="checkbox" name="stop<%=i%>" class="radio" disabled="disabled" id="stop<%=i%>" value="y" /></td>



</tr>
<%
i++;}} %>

</table>
</div>
<input type="hidden" name="count" value="<%=i%>" id="count" />

<input type="button" name="Submit" id="addbutton" value="Submit" class="button"
	onClick="submitForm('medicineIssue','ipd?method=submitMedicineIssueDetails');"
	accesskey="a" />
	<input type="reset" name="Back" value="Back"
	class="button" onclick="submitForm('medicineIssue','ipd?method=showPatientListJsp');" accesskey="r" /> <input
	type="hidden" name="isRecordAlreadyExists"
	value="" />
	
	<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=date%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=currentTime%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=currentTime%>" />
<div class="Clear"></div>

</div>
<script type="text/javascript">


function openPopupForView(){
	 newwindow = window.open('/hms/hms/ipd?method=displayMedicineDetailList&inPatientId=<%=inpatientId%>','windowRef','width=1000,height=400,scrollbars = yes');
}

function getItemStock(val,cnt,flag){

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
		   	    var stock = item.getElementsByTagName("stock")[0];
		   	 	var batchId = item.getElementsByTagName("batchId")[0];
		   	//    document.getElementById('stock'+cnt).value = stock.childNodes[0].nodeValue
		   	 	document.getElementById('batchId'+cnt).value = batchId.childNodes[0].nodeValue
	      	} 
	      }
	      }

		
	     var itemId = document.getElementById('item'+cnt).value;
	    xmlHttp.open("GET",'/hms/hms/ipd?method=getItemStock&barcode='+val+'&itemId='+itemId,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	  
}

</script>
	</form>
	