<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<%	Map<String,Object> map = new HashMap<String,Object>();
	String detailId ="";
	String opOrString ="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<Visit> visitList = new ArrayList<Visit>();
	List<Discharge> dischargeList = new ArrayList<Discharge>();
	List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
	List<Transfer> transferList = new ArrayList<Transfer>();
	List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
	List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	List<StoreIpIssueT> storeIssueTList = new ArrayList<StoreIpIssueT>();
	List<PatientPrescriptionDetails> patientPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
	if(map.get("visitList") != null)	{
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("dischargeList") != null)	{
		dischargeList = (List<Discharge>)map.get("dischargeList");
	}
	if(map.get("storeIssueTList") != null)	{
		storeIssueTList = (List<StoreIpIssueT>)map.get("storeIssueTList");
	}
	
	if(map.get("silDilStatusList") != null)	{
		silDilStatusList = (List<SilDilStatus>)map.get("silDilStatusList");
	}
	if(map.get("transferList") != null)	{
		transferList = (List<Transfer>)map.get("transferList");
	}
	if(map.get("mlcCaseList") != null)	{
		mlcCaseList = (List<MlcCase>)map.get("mlcCaseList");
	}
	if(map.get("dischargeIcdCodeList") != null)	{
		dischargeIcdCodeList = (List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	if(map.get("dgOrderhdList")!=null){
		dgOrderhdList = (List)map.get("dgOrderhdList");
	}
	if(map.get("patientPrescriptionList") != null)	{
		patientPrescriptionList = (List<PatientPrescriptionDetails>)map.get("patientPrescriptionList");
	}
	if(map.get("visitList") != null)	{
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("detailId") != null)	{
		detailId = ""+map.get("detailId");
	}
	if(map.get("opOrString") != null)	{
		opOrString = ""+map.get("opOrString");
	}
%>

<%//-------------Admission Type Details----------------------
	  if(opOrString.equals("IP")){
		//-------------For Discharge  Details----------------------
		if(detailId.equals("Discharge") ){
			%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<h2>Discharge Details</h2>
<div class="Clear"></div>
<%
		if(dischargeList.size() >0){
			Discharge discharge =dischargeList.get(0);
			String doctorName ="-";
			String disposal="-";
			String disposedTo="-";
			String careType="-";
			String injuryRptInitOn="-";
			String injuryRptInitat="-";
			String boardHeldOn="-";
			String followUpDate="-";
			String dischrgInMedicalCtgry="-";
			String dischargeStatus="-";
			String careSummary="-";
			String instructionsToPatient="-";
			String documentInitiated="-";
			String diagnosis="-";
			String dDate="-";
			String dTime="-";
			if(discharge.getDoctor() !=null){
				doctorName =discharge.getDoctor().getFirstName()+" "+discharge.getDoctor().getMiddleName()+" "+discharge.getDoctor().getLastName();
			}
			if(discharge.getDisposal() !=null){
				disposal =discharge.getDisposal().getDisposalName();
			}
			if(discharge.getDisposedTo() !=null){
				disposedTo =discharge.getDisposedTo().getDisposedToName();
			}
			if(discharge.getCareType() !=null){
				careType =discharge.getCareType().getCareTypeName();
			}
			if(discharge.getInjuryReportInitiatedOn() !=null){
				injuryRptInitOn =discharge.getInjuryReportInitiatedOn()+"";
			}
			if(discharge.getInjuryReportInitAt() !=null){
				injuryRptInitat =discharge.getInjuryReportInitAt()+"";
			}
			if(discharge.getBoardHeldOn() !=null){
				boardHeldOn =discharge.getBoardHeldOn()+"";
			}
			if(discharge.getFollowUpDate() !=null){
				followUpDate =discharge.getFollowUpDate()+"";
			}
			if(discharge.getDischargeInMedicalCategory() !=null){
				if(!discharge.getDischargeInMedicalCategory().equals(""))
				dischrgInMedicalCtgry =discharge.getDischargeInMedicalCategory()+"";
			}
			if(discharge.getDischargeStatus() !=null){
				dischargeStatus =discharge.getDischargeStatus().getDischargeStatusName()+"";
			}
			if(discharge.getCareSummary()!=null){
				if(!discharge.getCareSummary().equals(""))
				careSummary =discharge.getCareSummary()+"";
			}
			if(discharge.getInstructionsToPatient() !=null){
				instructionsToPatient =discharge.getInstructionsToPatient()+"";
			}
			if(discharge.getDocumentInitiated() !=null){
				documentInitiated =discharge.getDocumentInitiated()+"";
			}
			if(dischargeIcdCodeList.size() >0){
				 for(DischargeIcdCode dischargeIcdCode :dischargeIcdCodeList ){
					 
					  if(dischargeIcdCode.getZ09().equals("y")){
						  if(dischargeIcdCode.getIcd() !=null)
						  diagnosis = diagnosis+dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"]{OLD},";
					  }else{
						  if(dischargeIcdCode.getIcd() !=null)
						  diagnosis = diagnosis+dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"],";	  
					  }
					  
				  }
			}
			
			if(discharge.getDateOfDischarge() !=null){
				dDate =discharge.getDateOfDischarge()+"";
			}
			if(discharge.getTimeOfDischarge() !=null){
				dTime =discharge.getTimeOfDischarge()+"";
			}
			%>
<label>D Date :</label>
<label class="value"><%=dDate%></label>
<label>D Time :</label>
<label class="value"><%=dTime%></label>

<label>Doctor :</label>
<label class="value"><%=doctorName%></label>

<div class="Clear"></div>

<label>Disposal :</label>
<label class="value"><%=disposal%></label>

<label>Disposed To :</label>
<label class="value"><%=disposedTo%></label>

<label>Care Type :</label>
<label class="value"><%=careType%></label>

<div class="Clear"></div>

<label>Injury Rpt Init On:</label>
<label class="value"><%=injuryRptInitOn%></label>

<label>Injury Rpt Init at:</label>
<label class="value"><%=injuryRptInitat%></label>

<label>Board Held On:</label>
<label class="value"><%=boardHeldOn%></label>

<div class="Clear"></div>

<label>Follow Up Date:</label>
<label class="value"><%=followUpDate%></label>

<label class="large">Discharge In Medical Ctgry:</label>
<label class="valueNoWidth"><%=dischrgInMedicalCtgry%></label>

<div class="Clear"></div>

<label>D Status:</label>
<label class="valueNoWidth"><%=dischargeStatus%></label>

<div class="Clear"></div>

<label class="noWidth">Document Initiated:</label>
<label class="valueNoWidth"><%=documentInitiated%></label>

<div class="Clear"></div>

<label class="noWidth">Instructions To Patient:</label>
<label class="noHeightBig"><%=instructionsToPatient%></label>

<div class="Clear"></div>

<label>Care Summary:</label>
<label class="noHeightBig"><%=careSummary%></label>

<div class="Clear"></div>

<label>Diagnosis :</label>
<label class="noHeightBig"><%=diagnosis%></label>
<div class="Clear"></div>
<%
		}else{
			%>
<label class="noWidth"><span>No Discharge Records Found</span></label>
<%
		}
		%>
<%
	//-------------For IP MLC  Details----------------------
		}else if(detailId.equals("Mlc")){
		%>
<h2 align="center" class="style1">IP Mlc Deatils</h2>
<%
		if(mlcCaseList.size() >0){
		for(MlcCase mlcCase :mlcCaseList){
			String mlcNo ="-";
			String mlcDate ="-";
			String mlcTime ="-";
			String natureOfMlc ="-";
			
			String natureofInjur ="-";
			String typeOfInjury ="-";
			String severityofInjury ="-";
			String injuryDimen ="-";
			
			String injuryDetails ="-";
			String broughtBy ="-";
			String doctorAttnd ="-";
			String condition ="-";
			
			String bodyPartAff ="-";
			String weaponUsed ="-";
			String incidenceDate ="-";
			String incidenceTime ="-";
			
			String incidencePlace ="-";
			String typeNoOfVehicle ="-";
			String addressOfDriver ="-";
			String remarks ="-";
			
			String FIRNo ="-";
			String policeOfficerName ="-";
			String policeStation ="-";
			String statement ="-";
			
			if(mlcCase.getMlcNo() !=null )
			mlcNo=mlcCase.getMlcNo();
			if(mlcCase.getMlcDate() !=null )
			mlcDate=""+mlcCase.getMlcDate();
			if(mlcCase.getMlcTime() !=null )
			mlcTime =mlcCase.getMlcTime();
			if(mlcCase.getNatureOfMlc() !=null )
			natureOfMlc =""+mlcCase.getNatureOfMlc();
			
				if(mlcCase.getInjuryNature() !=null )
					if(!mlcCase.getInjuryNature().getInjuryNatureName().equals(""))
					natureofInjur=mlcCase.getInjuryNature().getInjuryNatureName();
				if(mlcCase.getInjuryType() !=null )
					if(!mlcCase.getInjuryType().equals(""))
					typeOfInjury=""+mlcCase.getInjuryType();
				if(mlcCase.getSeverityOfInjury() !=null )
					if(!mlcCase.getSeverityOfInjury().equals(""))
					severityofInjury =mlcCase.getSeverityOfInjury();
				if(mlcCase.getInjuryDimension() !=null )
						if(!mlcCase.getInjuryDimension().equals(""))
					injuryDimen =""+mlcCase.getInjuryDimension();
				
				if(mlcCase.getInjuryDetails() !=null )
						if(!mlcCase.getInjuryDetails().trim().equals(""))
					injuryDetails="";
				if(mlcCase.getBroughtBy() !=null )
					if(!mlcCase.getBroughtBy().equals(""))
					broughtBy=""+mlcCase.getBroughtBy();
				if(mlcCase.getDoctor().getFirstName() !=null )
					if(!mlcCase.getDoctor().getFirstName().equals(""))
					doctorAttnd =mlcCase.getDoctor().getFirstName();
				if(mlcCase.getPatientCondition() !=null )
						if(!mlcCase.getPatientCondition().equals(""))
					condition =""+mlcCase.getPatientCondition();
				
				if(mlcCase.getBodyPart() !=null )
					if(!mlcCase.getBodyPart().equals(""))
					bodyPartAff=mlcCase.getBodyPart().getBodyPartName();
				if(mlcCase.getWeaponUsed() !=null )
						if(!mlcCase.getWeaponUsed().equals(""))
					weaponUsed=""+mlcCase.getWeaponUsed();
				if(mlcCase.getIncidentDate() !=null )
						if(!mlcCase.getIncidentDate().equals(""))
					incidenceDate =""+mlcCase.getIncidentDate();
				if(mlcCase.getIncidentTime() !=null )
					if(!mlcCase.getIncidentTime().equals(""))
					incidenceTime =""+mlcCase.getIncidentTime();
				
				if(mlcCase.getIncidentPlace() !=null )
						if(!mlcCase.getIncidentPlace().equals(""))
					incidencePlace=mlcCase.getIncidentPlace();
				if(mlcCase.getTypeAndNoOfVehicle() !=null )
						if(!mlcCase.getTypeAndNoOfVehicle().equals(""))
					typeNoOfVehicle=""+mlcCase.getTypeAndNoOfVehicle();
				if(mlcCase.getNameAndAddressOfDriver() !=null )
					if(!mlcCase.getNameAndAddressOfDriver().trim().equals(""))
					addressOfDriver =""+mlcCase.getNameAndAddressOfDriver();
				if(mlcCase.getRemarks() !=null )
					if(!mlcCase.getRemarks().equals(""))
					remarks =""+mlcCase.getRemarks();
				
				if(mlcCase.getFirNo() !=null )
					if(!mlcCase.getFirNo().equals(""))
					FIRNo=mlcCase.getFirNo();
				if(mlcCase.getPoliceOfficer() !=null )
					if(!mlcCase.getPoliceOfficer().equals(""))
					policeOfficerName=""+mlcCase.getPoliceOfficer();
				if(mlcCase.getPoliceStation() !=null )
					if(!mlcCase.getPoliceStation().equals(""))
					policeStation =""+mlcCase.getPoliceStation();
				if(mlcCase.getStatement() !=null )
					if(!mlcCase.getStatement().equals(""))
					statement =""+mlcCase.getStatement();
		%>
<label>MLC No :</label>
<label class="value"><%=mlcNo%></label>
<label>MLC Date :</label>
<label class="value"><%=mlcDate%></label>
<label>MLC Time :</label>
<label class="value"><%=mlcTime%></label>
<label>Nature of MLC :</label>
<label class="value"><%=natureOfMlc%></label>


<label>Nature of Injur:</label>
<label class="value"><%=natureofInjur%></label>
<label>Type Of Injury:</label>
<label class="value"><%=typeOfInjury%></label>
<label>Severity of Injury :</label>
<label class="value"><%=severityofInjury%></label>
<label>Injury Dimen :</label>
<label class="value"><%=injuryDimen%></label>


<label>Injury Details :</label>
<label class="value"><%=injuryDetails%></label>
<label>Brought By :</label>
<label class="value"><%=broughtBy%></label>
<label>Doctor Attnd :</label>
<label class="value"><%=doctorAttnd%></label>
<label>Condition:</label>
<label class="value"><%=condition%></label>


<label>Body Part Aff :</label>
<label class="value"><%=bodyPartAff%></label>
<label>Weapon Used :</label>
<label class="value"><%=weaponUsed%></label>
<label>Incidence Date:</label>
<label class="value"><%=incidenceDate%></label>
<label>Incidence Time:</label>
<label class="value"><%=incidenceTime%></label>

<label>Incidence Place :</label>
<label class="value"><%=incidencePlace%></label>
<label>Type & No of Vehicle :</label>
<label class="value"><%=typeNoOfVehicle%></label>
<label>Address Of Driver:</label>
<label class="value"><%=addressOfDriver%></label>
<label>Remarks:</label>
<label class="value"><%=remarks%></label>

<label>FIR No:</label>
<label class="value"><%=FIRNo%></label>
<label>Police Officer Name:</label>
<label class="value"><%=policeOfficerName%></label>
<label>Police Station :</label>
<label class="value"><%=policeStation%></label>
<label>Statement:</label>
<label class="value"><%=statement%></label>
<%}}else{	%>
<div class="Clear"></div>
<label class="noWidth"><span>No Mlc Records Found</span></label>
<%
		}
		%>
<%
		//-------------For Sil/Dil Details----------------------
		}else if(detailId.equals("Sil/Dil")){
			%>
<h2 align="center" class="style1">SIL/DIL Deatils</h2>
<%int inc=1;
			if(silDilStatusList.size() >0){
			for(SilDilStatus silDilStatus : silDilStatusList){
				String silDilDate ="-";
				String silDilTime ="-";
				String icdName ="-";
				String treatment ="-";
				String remarks ="-";
				String conditionStatus ="-";
				String nok ="-";
				String placedBy ="-";
			if(silDilStatus.getIcd() !=null){
				icdName =""+silDilStatus.getIcd().getIcdName()+"["+silDilStatus.getIcd().getIcdCode()+"]";
			}
			if(silDilStatus.getTreatment() !=null){
				treatment =""+silDilStatus.getTreatment();
			}
			if(silDilStatus.getRemarks() !=null){
				remarks =""+silDilStatus.getRemarks();
			}
			if(silDilStatus.getConditionStatus() !=null){
				conditionStatus =""+silDilStatus.getConditionStatus();
			}
			if(silDilStatus.getNok() !=null){
				nok =""+silDilStatus.getNok();
			}
			if(silDilStatus.getLastChgDate() !=null){
				silDilDate =""+silDilStatus.getLastChgDate();
			}
			if(silDilStatus.getLastChgTime() !=null){
				silDilTime =""+silDilStatus.getLastChgTime();
			}
			if(silDilStatus.getPlacedBy() !=null){
				placedBy =""+silDilStatus.getPlacedBy().getFirstName()+" "+silDilStatus.getPlacedBy().getMiddleName()+" "+silDilStatus.getPlacedBy().getLastName();
			}
			%>
<div class="Clear"></div>
<label class="noWidth"><span><%=inc%>.)</span></label>

<div class="Clear"></div>

<label>Condition:</label>
<label class="value"><%=conditionStatus%></label>

<label>Date :</label>
<label class="value"><%=silDilDate%></label>

<label>Time :</label>
<label class="value"><%=silDilTime%></label>

<div class="Clear"></div>

<label>Placed By :</label>
<label class="value"><%=placedBy%></label>

<label>Treatment :</label>
<label class="value"><%=treatment%></label>

<label>Nok :</label>
<label class="value"><%=nok%></label>

<div class="Clear"></div>

<label>Remarks :</label>
<label class="noHeightBig"><%=remarks%></label>


<div class="Clear"></div>

<label>Diagnosis :</label>
<label class="noHeightBig"> <%=icdName%></label>

<div class="Clear"></div>


<%inc++;}}else{
				%>
<div class="Clear"></div>
<label class="noWidth"><span>No Sil/Dil Records Found</span></label>
<%}
			%>
<%//-------------For Transfer Details----------------------
			}else if(detailId.equals("Transfer")){
				%>
<h2 align="center" class="style1">Transfer Details</h2>
<div class="Clear"></div>
<%	int i =1;
				if(transferList.size() >0){
					for(Transfer transfer :transferList){
					String fromWard ="-";
					String toWard ="-";
					String date ="-";
					String time ="-";
					String doctor ="-";
					fromWard = transfer.getFromWard().getDepartmentName();
					toWard = transfer.getToWard().getDepartmentName();
					date =""+transfer.getDateOfTransfer();
					time =transfer.getTimeOfTransfer();
					if(transfer.getAuthorizedBy() !=null)
					doctor =transfer.getAuthorizedBy().getFirstName()+" "+transfer.getAuthorizedBy().getMiddleName()+" "+transfer.getAuthorizedBy().getLastName();
				%>
<div class="changebydt"><%=i %></div>
<label>T Date:</label>
<label class="value"><%=date%></label>
<label>T Time:</label>
<label class="value"><%=time%></label>
<label>From Ward :</label>
<label class="value"><%=fromWard%></label>
<label>To Ward :</label>
<label class="value"><%=toWard%></label>

<label>Auth By :</label>
<label class="value"><%=doctor%></label>

<%i++;}}else{
					%>
<label class="noWidth"><span>No Transfer Records Found</span></label>
<%
}				%>
<div class="Clear"></div>
<%} else if(detailId.equals("Prescription")){ %>
	<h2>Prescription Deatils</h2>
<div class="Clear"></div>
	<%if(storeIssueTList.size() >0){%>
		
<div class="tableHolderAuto">
<table width="70%" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No</th>
		<th scope="col">Batch No</th>
		<th scope="col">Quantity issued</th>
		<th scope="col">Expiry Date</th>

	</tr>
			<%int i=1;
			String pvmsNo="";
			String nomenclature="";
			int itemId=0;
				Iterator itr= storeIssueTList.iterator();
				while(itr.hasNext())
				{
  						 StoreIpIssueT storeIpIssueT=(StoreIpIssueT)itr.next();
  						 if(storeIpIssueT.getItem()!=null){
  			         	  itemId=storeIpIssueT.getItem().getId();
  			         	  pvmsNo=storeIpIssueT.getItem().getPvmsNo();
  			        	  nomenclature=storeIpIssueT.getItem().getNomenclature();
  						 }else{
  							 pvmsNo="-";nomenclature="";
  						 }
  			        	 String batchNo="";
  			        	 if(storeIpIssueT.getBatchNo()!=null){
  			        		batchNo=storeIpIssueT.getBatchNo();
  			        	 }else{
  			        		batchNo="-"; 
  			        	 }
  			        	BigDecimal issueQty=null;
  			        	 if(storeIpIssueT.getQtyIssued()!=null){
  			        		issueQty=storeIpIssueT.getQtyIssued();
  			        	 }
  			        	String expDate=null;
  			        	 if(storeIpIssueT.getExpiryDate() !=null){
  			        		expDate=HMSUtil.changeDateToddMMMyyyy(storeIpIssueT.getExpiryDate());
  			        	 }else{
  			        		 expDate="-";
  			        	 }
 			%>

	<tr>
		<td>
		<input type="text" name="nomenclature<%=i %>" tabindex="1"	size="30" readonly="readonly" value="<%=nomenclature %>"
			id="nomenclature<%=i %>" />
		
		<input type="hidden" name="itemId<%=i %>" value="<%=itemId %>" /></td>

		<td><input type="text" name="pvmsNo<%=i %>" size="10" tabindex="1" readonly="readonly" value="<%=pvmsNo %>" /></td>

		<td><input type="text" name="batchNo<%=i%>" size="6" tabindex="1"readonly="readonly" value="<%=batchNo %>" /></td>

		<td><input type="text" value="<%=issueQty %>" name="issueQty" size="10" readonly="readonly"/></td>

		<td>
		<input type="text" name="expDate<%=i %>" size="15"	tabindex="1" readonly="readonly" value="<%=expDate %>" />
		</td>

	</tr>
	<%i++;
  	   }
  	   %>
		</table>
</div>
	<%}else{ %>
<div class="Clear"></div>
<label class="noWidth"><span>No Prescription Records Found</span></label>
<%}} %>
<%//-------------Else of Admission Type Details----------------------%>
	<%}else if(opOrString.equals("OP")){ 
	//-------------For Discharge  Details----------------------
		if(detailId.equals("Visit") ){
			%>
<h2 align="center" class="style1">Visit Deatils</h2>
<div class="Clear"></div>
<%  if(visitList.size() > 0){
				Visit visit =visitList.get(0);
				String visitNo ="-";
				String visitDate ="-";
				String visitTime ="-";
				String hospitalStaff ="-";
				
				String complaint ="-";
				String department ="-";
				String consultingDoc ="-";
				String caseType ="-";
				
				String diagnosis ="-";
				String disposedAs ="-";
				String tokenNo ="-";
				
				visitNo =""+visit.getVisitNo();
				if(visit.getVisitDate() !=null){
					visitDate =""+visit.getVisitDate();
				}
				SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
				if(visit.getVisitDate() !=null){
					visitDate=HMSUtil.changeDateToddMMyyyy(formatterIn.parse(""+visit.getVisitDate()));
				//	visitDate =""+visit.getVisitDate();
					//visitDate=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
				}
				if(visit.getVisitTime() !=null){
					visitTime =""+visit.getVisitTime();
				}
				if(visit.getHospitalStaff() !=null){
					if(visit.getHospitalStaff().equalsIgnoreCase("n"))
					hospitalStaff ="No";
					else if(visit.getHospitalStaff().equalsIgnoreCase("y"))
						hospitalStaff ="Yes";
				}
				
				if(visit.getComplaintString() !=null && !visit.getComplaintString().equals("")){
					complaint =""+visit.getComplaintString();
				}
				if(visit.getDepartment() !=null){
					department =""+visit.getDepartment().getDepartmentName();
				}
				
				if(visit.getCaseType() !=null){
					caseType =""+visit.getCaseType().getCaseTypeName();
				}
				
				
				if(visit.getTokenNo() !=null){
					tokenNo =""+visit.getTokenNo();
				}
			%>
<label>Visit No :</label>
<label class="value"><%=visitNo%></label>
<label>Visit Date :</label>
<label class="value"><%=visitDate%></label>
<label>Visit Time :</label>
<label class="value"><%=visitTime%></label>

<div class="Clear"></div>

<label>Hospital Staff:</label>
<label class="value"><%=hospitalStaff%></label>


<label>Complaint :</label>
<label class="value"><%=complaint%></label>
<label>Department :</label>
<label class="value"><%=department%></label>

<div class="Clear"></div>

<label>Consulting Doc:</label>
<label class="value"><%=consultingDoc%></label>

<label>Case Type:</label>
<label class="value"><%=caseType%></label>

<div class="Clear"></div>

<label>Diagnosis :</label>
<label class="noHeightBig"><%=diagnosis%></label>

<div class="Clear"></div>

<label>Disposed As :</label>
<label class="value"><%=disposedAs%></label>
<label>Token No :</label>
<label class="value"><%=tokenNo%></label>


<%} %>
<%}else if(detailId.equals("OP-Mlc")){%>
<h2>OP Mlc Deatils</h2>
<div class="Clear"></div>
<%
		if(mlcCaseList.size() >0){
		for(MlcCase mlcCase :mlcCaseList){
			String mlcNo ="-";
			String mlcDate ="-";
			String mlcTime ="-";
			String natureOfMlc ="-";
			
			String natureofInjur ="-";
			String typeOfInjury ="-";
			String severityofInjury ="-";
			String injuryDimen ="-";
			
			String injuryDetails ="-";
			String broughtBy ="-";
			String doctorAttnd ="-";
			String condition ="-";
			
			String bodyPartAff ="-";
			String weaponUsed ="-";
			String incidenceDate ="-";
			String incidenceTime ="-";
			
			String incidencePlace ="-";
			String typeNoOfVehicle ="-";
			String addressOfDriver ="-";
			String remarks ="-";
			
			String FIRNo ="-";
			String policeOfficerName ="-";
			String policeStation ="-";
			String statement ="-";
			
			if(mlcCase.getMlcNo() !=null )
			mlcNo=mlcCase.getMlcNo();
			if(mlcCase.getMlcDate() !=null )
			mlcDate=""+mlcCase.getMlcDate();
			if(mlcCase.getMlcTime() !=null )
			mlcTime =mlcCase.getMlcTime();
			if(mlcCase.getNatureOfMlc() !=null )
			natureOfMlc =""+mlcCase.getNatureOfMlc();
			
				if(mlcCase.getInjuryNature() !=null )
					natureofInjur=mlcCase.getInjuryNature().getInjuryNatureName();
				if(mlcCase.getInjuryType() !=null )
					typeOfInjury=""+mlcCase.getInjuryType();
				if(mlcCase.getSeverityOfInjury() !=null )
					severityofInjury =mlcCase.getSeverityOfInjury();
				if(mlcCase.getInjuryDimension() !=null )
					injuryDimen =""+mlcCase.getInjuryDimension();
				
				if(mlcCase.getInjuryDetails() !=null )
					if(!mlcCase.getInjuryDetails().trim().equals(""))
					injuryDetails=mlcCase.getInjuryDetails();
				if(mlcCase.getBroughtBy() !=null )
					if(!mlcCase.getBroughtBy().trim().equals(""))
					broughtBy=""+mlcCase.getBroughtBy();
				if(mlcCase.getDoctor().getFirstName() !=null )
					doctorAttnd =mlcCase.getDoctor().getFirstName();
				if(mlcCase.getPatientCondition() !=null )
					if(!mlcCase.getPatientCondition().trim().equals(""))
					condition =""+mlcCase.getPatientCondition();
				
				if(mlcCase.getBodyPart() !=null )
					if(!mlcCase.getBodyPart().getBodyPartName().trim().equals(""))
					bodyPartAff=mlcCase.getBodyPart().getBodyPartName();
				if(mlcCase.getWeaponUsed() !=null )
					if(!mlcCase.getWeaponUsed().trim().equals(""))
					weaponUsed=""+mlcCase.getWeaponUsed();
				if(mlcCase.getIncidentDate() !=null )
					incidenceDate =""+mlcCase.getIncidentDate();
				if(mlcCase.getIncidentTime() !=null )
					if(!mlcCase.getIncidentTime().trim().equals(""))
					incidenceTime =""+mlcCase.getIncidentTime();
				
				if(mlcCase.getIncidentPlace() !=null )
					if(!mlcCase.getIncidentPlace().trim().equals(""))
					incidencePlace=mlcCase.getIncidentPlace();
				if(mlcCase.getTypeAndNoOfVehicle() !=null )
					if(!mlcCase.getTypeAndNoOfVehicle().trim().equals(""))
					typeNoOfVehicle=""+mlcCase.getTypeAndNoOfVehicle();
				if(mlcCase.getNameAndAddressOfDriver() !=null )
					if(!mlcCase.getNameAndAddressOfDriver().trim().equals(""))
					addressOfDriver =""+mlcCase.getNameAndAddressOfDriver();
				if(mlcCase.getRemarks() !=null )
					if(!mlcCase.getRemarks().trim().equals(""))
					remarks =""+mlcCase.getRemarks();
				
				if(mlcCase.getFirNo() !=null )
					if(!mlcCase.getFirNo().trim().equals(""))
					FIRNo=mlcCase.getFirNo();
				if(mlcCase.getPoliceOfficer() !=null )
					if(!mlcCase.getPoliceOfficer().trim().equals(""))
					policeOfficerName=""+mlcCase.getPoliceOfficer();
				if(mlcCase.getPoliceStation() !=null )
					if(!mlcCase.getPoliceStation().trim().equals(""))
					policeStation =""+mlcCase.getPoliceStation();
				if(mlcCase.getStatement() !=null )
					if(!mlcCase.getStatement().trim().equals(""))
					statement =""+mlcCase.getStatement();
		%>
<label>MLC No :</label>
<label class="value"><%=mlcNo%></label>
<label>MLC Date :</label>
<label class="value"><%=mlcDate%></label>
<label>MLC Time :</label>
<label class="value"><%=mlcTime%></label>

<div class="Clear"></div>

<label>Nature of MLC :</label>
<label class="value"><%=natureOfMlc%></label>

<label>Nature of Injur :</label>
<label class="value"><%=natureofInjur%></label>

<label>Type Of Injury :</label>
<label class="value"><%=typeOfInjury%></label>

<div class="Clear"></div>

<label>Severity of Injury :</label>
<label class="value"><%=severityofInjury%></label>

<label>Injury Dimen :</label>
<label class="value"><%=injuryDimen%></label>

<div class="Clear"></div>

<label>Injury Details :</label>
<label class="noHeightBig"><%=injuryDetails%></label>

<div class="Clear"></div>

<label>Brought By :</label>
<label class="value"><%=broughtBy%></label>

<label>Doctor Attnd :</label>
<label class="value"><%=doctorAttnd%></label>

<label>Condition:</label>
<label class="value"><%=condition%></label>

<div class="Clear"></div>

<label>Body Part Aff :</label>
<label class="value"><%=bodyPartAff%></label>

<label>Weapon Used :</label>
<label class="value"><%=weaponUsed%></label>

<label>Incidence Date :</label>
<label class="value"><%=incidenceDate%></label>

<div class="Clear"></div>

<label>Incidence Time :</label>
<label class="value"><%=incidenceTime%></label>

<label>Incidence Place :</label>
<label class="value"><%=incidencePlace%></label>

<label>Type & No of Vehicle :</label>
<label class="value"><%=typeNoOfVehicle%></label>

<div class="Clear"></div>

<label>Address Of Driver:</label>
<label class="noHeightBig"><%=addressOfDriver%></label>

<div class="Clear"></div>

<label>Remarks:</label>
<label class="noHeightBig"><%=remarks%></label>

<div class="Clear"></div>

<label>FIR No:</label>
<label class="value"><%=FIRNo%></label>

<label>Police Officer Name:</label>
<label class="value"><%=policeOfficerName%></label>

<label>Police Station :</label>
<label class="value"><%=policeStation%></label>

<div class="Clear"></div>

<label>Statement:</label>
<label class="noHeightBig"><%=statement%></label>
<div class="Clear"></div>
<%}}else{%>
<div class="Clear"></div>
<label class="noWidth"><span>No Mlc Records Found</span></label>
<div class="Clear"></div>
<%}}else if(detailId.equals("Prescription")){%>
	<h2>Prescription Deatils</h2>
<div class="Clear"></div>
	<%if(patientPrescriptionList.size() >0){
		%>
		
		<div class="tableHolderAuto">
<table width="70%" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No Of Days</th>
		<th scope="col">Intake</th>
		<th scope="col">Type</th>

	</tr>
			<%int i=1;
			String pvmsNo="";
			String nomenclature="";
			int itemId=0;
				Iterator itr= patientPrescriptionList.iterator();
				while(itr.hasNext())
				{
  						 PatientPrescriptionDetails patientPrescriptionDetails=(PatientPrescriptionDetails)itr.next();
  						 if(patientPrescriptionDetails.getItem()!=null){
  			         	  itemId=patientPrescriptionDetails.getItem().getId();
  			         	  pvmsNo=patientPrescriptionDetails.getItem().getPvmsNo();
  			        	  nomenclature=patientPrescriptionDetails.getItem().getNomenclature();
  						 }else{
  							 pvmsNo="-";nomenclature="";
  						 }
  			        	 String dosage="";
  			        	 if(patientPrescriptionDetails.getDosage()!=null){
  			        	dosage=patientPrescriptionDetails.getDosage();
  			        	 }else{
  			        		dosage="-"; 
  			        	 }
  			        	String frequency="";
  			        	 if(patientPrescriptionDetails.getFrequency()!=null){
  			        	  frequency=patientPrescriptionDetails.getFrequency().getFrequencyName();
  			        	 }else{
  			        		frequency="-"; 
  			        	 }
  			        	 int total=patientPrescriptionDetails.getTotal();
  			        	 int noOfDays=patientPrescriptionDetails.getNoOfDays();
  			        	 String typeLeftRight="";
  			        	 if(patientPrescriptionDetails.getType() !=null){
  			        	  typeLeftRight=patientPrescriptionDetails.getType();
  			        	 }else{
  			        	   typeLeftRight="-";
  			        	 }
  			        	 String instructionACPC = patientPrescriptionDetails.getInstruction();
 			%>

	<tr>
		<td>
		<input type="text" name="nomenclature<%=i %>" tabindex="1"	size="30" readonly="readonly" value="<%=nomenclature %>"
			id="nomenclature<%=i %>" />
		
		<input type="hidden" name="itemId<%=i %>" value="<%=itemId %>" /></td>

		<td><input type="text" name="pvmsNo<%=i %>" size="10" tabindex="1" readonly="readonly" value="<%=pvmsNo %>" /></td>

		<td><input type="text" name="dosage<%=i%>" size="6" tabindex="1"readonly="readonly" value="<%=dosage %>" /></td>

		<td><input type="text" value="<%=frequency %>" name="frquency" size="10" readonly="readonly"/></td>

		<td>
		<input type="text" name="noOfDays<%=i %>" size="5"	tabindex="1" readonly="readonly" value="<%=noOfDays %>" />
		<input type="hidden" name="total<%=i %>" tabindex="1"readonly="readonly" value="<%=total %>" />
		</td>
		<td><input type="text" value="<%=instructionACPC %>" name="instructionACPC" size="5" readonly="readonly"/></td>

		<td><input type="text" value="<%=typeLeftRight %>" name="typeLeftRight" size="5" readonly="readonly"/></td>

	</tr>
	<%i++;
  	   }%>
		</table>
</div>
	<%}else{%>
<div class="Clear"></div>
<label class="noWidth"><span>No Prescription Records Found</span></label>
<%}%>
	
<%}}%>
