<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>

<script type="text/javascript">

var icdArray=new Array();
var unitArray = new Array();
var itemClassArray = new Array();
var itemClassCodeArray = new Array();
	function checkSubmitNomenclature() {
 	if(confirm("Do You want to submit the Record!?")){
	
					 if(validateFrequencyForPre() && validateDaysForPre() && validateFrequency('nomenclaturehdb')){
						 
						 return true;
					}
				}else{
					return false;
				} 
				
				return false;
		}	
	

	function validateFrequencyForPre(){
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
				
		/* 		var dosage = document.getElementById('dosage'+i).value;
			    var stock = document.getElementById('closingStock'+i).value;
			    alert(dosage+" "+stock);
				if(dosage>stock){
					alert('Issued dosage cannot greater than available stock');
					document.getElementById('closingStock'+i).focus();
					return false;
				 } */
				
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
	
	function validateDaysForPre(){
		//alert(document.getElementById('disposal').value);
	 var msg = "";
	 if(document.getElementById('disposal')){
	 var disposal = document.getElementById('disposal').value;
	 if(document.getElementById('disposal')){
		// alert(disposal)
	 if(disposal == 'Light duties' || disposal =='Sick in Quarters' || disposal =='Sick Leave' || disposal =='Excused Duty'  )
	 {
		 document.getElementById('daysDiv').style.display = 'block';
		 if(document.getElementById('days').value == "")
			msg += "Please select the days.\n";
			
		 }else{
		 document.getElementById('daysDiv').style.display = 'none';
	 }
	 }
	}
	 if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	
		
	}
</script>

<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%	String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
for(int i=0;i<ItemClassCodeForLiquid.length;i++)
{
%>
<script>

itemClassCodeArray[<%=i%>]= new Array();
itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

 			
        </script>
<%}%>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	String userName = "";
	int prescribedDepartmentId=0;
	int hospitalId=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String yearlySerialNo="";
	String monthlySerialNo="";
	 List<OtPreAnaesthesiaProNotesSub> otDetailList = new ArrayList<OtPreAnaesthesiaProNotesSub>();
	 
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 List otList = new ArrayList();
	 OtBooking booking=null;
	 List <OtBookSurgeon>surgeonList = new ArrayList<OtBookSurgeon>();
		if(map.get("surgeonList") != null){
			surgeonList=(List)map.get("surgeonList");
		}
	 if(map.get("patientDetailList") != null){
		 booking=(OtBooking)map.get("booking");
		}
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
	}
    if(map.get("otList") != null){
		otList=(List)map.get("otList");
	}
	if(map.get("otDetailList") != null){
		otDetailList=(List)map.get("otDetailList");
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("monthSerialNo")!=null){
		monthlySerialNo=(String)map.get("monthSerialNo");
	}
	if(map.get("yearlySerialNo")!=null){
		yearlySerialNo=(String)map.get("yearlySerialNo");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	String treatmentAdviceCode = HMSUtil.getProperties("adt.properties", "templateCodeForTreatmentAdvice");
	
	int hinId =0;
	String hinNo =null;

	if(patientDetailList!=null && patientDetailList.size()>0){
		 OtBooking otBooking=(OtBooking)patientDetailList.get(0);
		
		 
		    int surgeryHeaderId = 0;
		    int preAnethesiaHdId=0;
		    OpdSurgeryHeader opdSurgeryheader =null;
		    if(otBooking.getOtBookingDt()!=null)
		    {
		   	 
		   	 Set<OtBookingDt> opdSuregryDetailsSet = new HashSet<OtBookingDt>();
		   	 opdSuregryDetailsSet = otBooking.getOtBookingDt();
		   	 
		   	 for(OtBookingDt pacDetail:opdSuregryDetailsSet)
		   	 {
		   		surgeryHeaderId = pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery().getId();
		   		opdSurgeryheader =  pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery();
		   		preAnethesiaHdId = pacDetail.getOtPreAnesthesiaDetail().getAnesthesiaHd().getId();
		   		 break;
		   	 }
		   	
		    }
		 
		 
	    String patientName="";
	     hinId = otBooking.getHin().getId();
	     hinNo = otBooking.getHin().getHinNo();
		if(otBooking.getHin().getPFirstName()!= null){
			patientName=otBooking.getHin().getPFirstName();
		}
		if(otBooking.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPMiddleName();
		}
		if(otBooking.getHin().getPLastName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPLastName();
		}
		String procedure = "";
		if(otBooking!=null)
		{
			if(otBooking.getInpatient()!=null){
			inpatient=otBooking.getInpatient();
			visit = otBooking.getVisit();
			patient = inpatient.getHin();
			}else if(otBooking.getVisit()!=null){
				patient = otBooking.getVisit().getHin();
				visit = otBooking.getVisit();
			}
			
			
			Inpatient inpatient=null;
			Patient patient=null;
		
			Set<OtBookingDt> OtBookingDtSet = new HashSet<OtBookingDt>();
			OtBookingDtSet = otBooking.getOtBookingDt();
			int count =1;
			for(OtBookingDt otDt :OtBookingDtSet){
					if(otDt.getStatus() !=null && !otDt.getStatus().equalsIgnoreCase("y") && !otDt.getStatus().equalsIgnoreCase("c"))
					{
						if(count++ >1)
						procedure += " | ";
						procedure += otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName();
			 
					}
			}
			
		}
		
		String anesthesiaDetails ="";
		if(map.get("anesthesiaDetails")!=null)
		{
			anesthesiaDetails = (String)map.get("anesthesiaDetails");
		}
		
		

String icd="";
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
		
	
%>

<!--main content placeholder starts here-->
<title>Surgery Operative Notes</title>
<form name="otBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Surgery Post Operative Notes</h2>
</div>
<div class="clear"></div>
<%-- <div class="Block">
<label>Yearly Serial No. </label> 
<input type="text" readonly="readonly" value="<%=yearlySerialNo %>" />
<input type="hidden"	id="yearlySqNo" name="yearlySqNo" value="<%=yearlySerialNo %>" /> 
<label>Monthly Serial No. </label> 
<input type="text" readonly="readonly" value="<%=monthlySerialNo%>" />
<input type="hidden" id="monthlySqNo" name="monthlySqNo" value="<%=monthlySerialNo %>" />
<div class="clear"></div>
</div> --%>
<!--Block One Starts-->
	<div class="clear"></div>
	<div class="Block">
		<div class="paddingTop5"></div>
		<div class="clear"></div>
		<%-- <label>Requisition No.</label> 
          <input type="text" readonly="readonly" value="<%=otBooking.getOrderNo() %>" /> --%>
		<%-- <label>Surgery Requisition Date</label> <input type="text"
			readonly="readonly"  value="<%=otBooking.getOpdSurseryHeader().getRequisitionDate()!=null?HMSUtil.convertDateToStringWithoutTime(otBooking.getOpdSurseryHeader().getRequisitionDate()):"" %>"/>
		 --%><label>Surgery Date</label> 
        <input type="text" readonly="readonly" value="<%=otBooking.getSurgeryDate()!=null?HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()):"" %>" />

		<div class="clear"></div>
		<div class="paddingTop5"></div>
	</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%if(inpatient!=null) {%>
<%@include file="PatientDetails.jsp" %>
<%} %>

<input type="hidden" name="<%=RequestConstants.HIN_ID %>"  id="<%=RequestConstants.HIN_ID %>" value="<%=otBooking.getHin()!=null?otBooking.getHin().getId():"0" %>"/>
<input type="hidden" name="<%=RequestConstants.VISIT_ID %>" value="<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():"0" %>" />
<input type="hidden" name="<%=RequestConstants.INPATIENT_ID %>"  value="<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():"0" %>"  />
<input type="hidden" name="<%=RequestConstants.VISIT_ID %>" id="<%=RequestConstants.VISIT_ID %>"  value="<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():"0" %>"  />
<input
	name="opdSurgeryHeaderId" type="hidden"
	value="<%=surgeryHeaderId %>"/> 
<%-- <label>Surgery Date</label> 
<input type="text" readonly="readonly" value="<%=otBooking.getOpdSurseryHeader()!=null?HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()):"" %>" />
<label>Requisition No.</label> 
<input type="text" readonly="readonly" value="<%=otBooking.getOrderNo() %>" /> 
 --%><div class="clear"></div>
<label>Anesthesia</label> 
<input type="text" readonly="readonly" value="<%=anesthesiaDetails%>" />
		<label>Provisional Diagnosis </label>
<textarea class="large" readonly="readonly"><%=icd%></textarea>
 
<label>Procedure</label> 
   <label class="value" style="width: 472px;"><%=procedure%></label>
<input type="hidden" name="bookingId" id="bookingId"	value="<%=otBooking!=null?otBooking.getId():"" %>" />
<div class="clear"></div>
<div class="clear"></div>
<%-- <td><input name="selectCheckBox" id="selectCheckBox" type="button" value="<%=otBooking.getId() %>" onClick="javascript:openPopupWindow(this.value);" /></td> --%>
 <input type="hidden" id="requestId" value="<%=otBooking.getHin().getId() %>"/>
<!-- <input type="button" name="Submit" class="button" value="Allergy"
	onclick="javascript:openPopupWindow();" /> -->
</div>
<div class="clear"></div>
<div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OT');">Current Medication</a>
                <a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<%
				 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
					hinNo = hinNo.substring(1, hinNo.length()); %>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>



					
			</div>
<%if(opdSurgeryheader!=null && opdSurgeryheader.getHin()!=null && opdSurgeryheader.getInpatient()!=null)  {%>
<%-- <input type="button" class="button" tabindex="3" name=""
value="+" onclick="OPDHistoryPopup('<%=opdSurgeryheader.getHin().getId()%>', '<%=opdSurgeryheader.getInpatient().getId()%>', '<%=opdSurgeryheader.getId()%>');" />
<div class="popupTextDiv">Current OPD/IPD/OT History</div> --%>

<input type="button" class="button" tabindex="3" name=""
value="+" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=opdSurgeryheader.getHin().getId()%>&visitId=<%=opdSurgeryheader.getVisit().getId() %>&preAnethesiaHdId=<%=preAnethesiaHdId%>')" />
<div class="popupTextDiv">PAC Details</div>


<input type="button" class="button" tabindex="3" name=""
value="+" onclick="openWindow('/hms/hms/ot?method=viewPreAnesthesiaDeials&bookingId=<%=otBooking.getId()%>&visitId=<%=opdSurgeryheader.getVisit().getId() %>&inpatientId=<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():"0"%>')" />
<div class="popupTextDiv">Pre Anesthesia Details</div>
<%} %>

<!-- <h4>Patient Advice</h4>
<div class="clear"></div>
<div class="Block">
<label>Patient Advise</label>
 <textarea name="patientAdvise" class="textareaMediua" validate="patientAdvise,string,no" id="patientAdvise" cols="0"	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"></textarea>
<input type="button" class="buttonAuto-buttn"  value="+" onclick=""  />	
	
<label>Doctor's Notes</label> 
<textarea name="referralNote" class="textareaMediua" validate="referralNote,string,no" id="referralNote" cols="0"	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"></textarea>
<input type="button" class="buttonAuto-buttn"  value="+" onclick=""  />
<div class="clear"></div>
<label>Multiple Drug</label>
<textarea class="large" name="multipleDrug">
</textarea>
</div> -->
<%	
int inc=1; 
if(surgeonList!=null && surgeonList.size() >0){  %>
<h4>Resource Details</h4>
<div class="clear"></div>
<div class="paddingTop5"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="surgeonGrid">
	<tr>
	<!-- 	<th scope="col">SI No.</th> -->
		<th scope="col">Resource Name</th>
		<th scope="col">Designation</th>
		<th scope="col">Role</th>
		<!-- <th scope="col">Add</th>
		<th scope="col">Delete</th> -->
	</tr>
	
	<%
 
		 
		for(OtBookSurgeon surgeon :surgeonList)
		{
		%>
		<tr>
	<%-- 	<td><input readonly="readonly" type="text" size="2" value="<%=inc%>" /></td> --%>
		<td>
		<input type="text" value="<%=surgeon.getEmployee().getFirstName()%>[<%=surgeon.getEmployee().getId()%>]" tabindex="1"
			id="surgeonName<%=inc%>" size="43" name="surgeonName<%=inc%>" readonly="readonly"/>
	    </td>
				<td><input type="text" size="43" value="<%=surgeon.getEmployee().getRank().getRankName()%>" name="designation<%=inc-1%>" readonly="readonly" id="designation<%=inc%>"></input></td>
				<td>
				<select name="role<%=inc%>" id="role<%=inc%>"> 
				<option <%=surgeonList.get(inc-1).getRole()%>><%=surgeonList.get(inc-1).getRole()%></option>
				</select></td>
				<!-- <td><input type="button" class="button" alt="Add" value="Add" onclick="addRowForSurgeon();"align="right" /></td>
				<td><input type="button" class="button" alt="Delete" value="Delete" onclick="removeSurgeonRow('surgeonGrid','surgeonHiddenValue',this);" align="right" /> </td> -->
	
	</tr>
		<%	 
		inc++;	
		 
		}

	%>
<input type="hidden" value="<%=inc%>" name="surgeonHiddenValue" id="surgeonHiddenValue" />
</table>
<%}	
	%>
<div class="clear"></div>
<h4>Premedication</h4><div class="clear"></div>
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
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="displayAuForLabour(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');"  />
	     <input type="hidden" name="itemId1" id="itemId1"	value=""/>
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
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow(document.getElementById('grid'), 'hdb');" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeTreatmentRow(document.getElementById('grid'),'hdb',this);" tabindex="1" />
			</td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Treatment</h4><div class="clear"></div>
<div id="testDiv1">
	<div class="cmntable" style="min-height: 85px">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="nomenclatureGrid">
	<tr>
		 <th>Nomenclature/Material Code</th>
	   <!--  <th colspan="1">Other Drug</th> -->
	  <!--   <th scope="col">Class</th>
		<th scope="col">AU</th> -->
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
<!-- 		<th scope="col">Route</th> -->
		<th scope="col">Instruction</th>
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
		<td>
		 <input type="hidden" name="itemId500" id="itemId500" value="" />
	    <input type="text" value="" tabindex="1" id="nomenclature500" size="53"  name="nomenclature500" onblur="checkForAlreadyIssuedPrescription(this.value,'500','0');populatePVMS(this.value,'500');checkItem(500);displayAu(this.value,'500','5');checkForPurchase(this.value, '500');"  />
	     <div id="ac2update2" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" tabindex="1" charset="utf-8">
//			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			   new Ajax.Autocompleter('nomenclature500','ac2update2','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature500'});
			</script>
		</td>
		<!-- <td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20"  validate="other Medicine,string,no" readonly="readonly"/></td> -->
		<!-- 	<td><select name="itemClass1" id="itemClass1">
								<option value="0">Select</option></select></td> -->
	<!-- 	<td><select name="itemConversionId1" id="itemConversionId1"
							tabindex="1" class="medium">
								<option value="0">Select</option></select></td>	 -->	
								
												
		<!-- <td><input type="text" name="dispensingUnit500" tabindex="1" id="dispensingUnit500"  size="6"  validate="AU,string,no"  readonly="readonly"/>
		<input type="hidden" name="au500" tabindex="1" value="" id="au500"
							size="6" validate="AU,string,no" /> <input type="hidden"
							name="actualDispensingQty500" tabindex="1"
							id="actualDispensingQty500" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode500" name="itemClassCode500"
							validate="itemClassCode,string,no" value="" />
		<input type="hidden" tabindex="1" id="highValueMedicine500" name="highValueMedicine500" validate="AU,string,no" value=""/></td> -->
		
				<td>
		<select name="dispensingUnit500" id="dispensingUnit500" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<input type="hidden" name="au500" tabindex="1" value="" id="au500"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty500" tabindex="1" id="actualDispensingQty500" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1"  id="itemClassCode500" name="itemClassCode500"  validate="itemClassCode,string,no" value="" />
                           
		<input type="hidden" tabindex="1" id="highValueMedicine500" name="highValueMedicine500" validate="AU,string,no" value=""/>
		</td>  
		<td><input type="hidden" name="pvmsNo500" tabindex="1" id="pvmsNo500"	size="10" readonly="readonly" />
		<input type="text" name="dosage500" tabindex="1" value="" id="dosage500"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'500');fillValue('500')" /></td>
		<td><select name="frequency500" id="frequency500" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'500');fillValueFromFrequency(this.value,'500');displaySOSQty(this.value,'500');fillValue('500')" >
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
            <input type="hidden" name="frequencyValue500" id="frequencyValue500" value="">
            <input type="text" name="sosQty500" tabindex="1" id="sosQty500" style="display: none;"   size="3" onblur="fillValue('500')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td><input type="text" name="noOfDays500" tabindex="1" id="noOfDays500" onblur="fillValue('500')"  size="3"	maxlength="3" validate="No of Days,num,no" /></td>
			<td>	<input type="text" name="total500" tabindex="1" id="total500" validate="total,num,no" size="3"/></td>
	<!-- 	<td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
		
		</td> -->
	
		<td><input type="text" name="remarks500" tabindex="1" id="remarks500" size="10" maxlength="15" placeholder="1-1-1"/></td>
		<td><input type="text" name="closingStock500" tabindex="500" value="" id="closingStock500"  size="3"  validate="closingStock,string,no" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addNomenclatureRow()" tabindex="1" /> </td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);" tabindex="1" /></td>
	</tr>
	<input type="hidden" name="nomenclaturehdb" value="500" id="nomenclaturehdb" />
</table>
<div class="clear"></div>

</div>
</div>

<div class="clear"></div>
   <div class="Block">
		<label>Treatment Advice</label>
		<textarea name="otherTreatment" cols="50" rows="0" maxlength="500"
			tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
			<input type="button" class="button" tabindex="3" name="" value="+" onclick="getPresentTemplate('<%=treatmentAdviceCode%>','otherTreatment');" />
	</div> 

<div class="clear"></div>
<h4>Investigation</h4><div class="clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="3" >
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
		
		<%  inc=1;
			String investigationName = "";
%>
	
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
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
	
		<td><input name="Button" type="button" class="button" value="Add" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="Delete" class="button" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Surgery Notes</label> 
<textarea name="additional_notes"  id="remarks" cols="0" rows="0" class="large"
		maxlength="1000"></textarea>
<div class="clear"></div>
<input name="hinId" type="hidden" value="<%=otBooking.getHin().getId() %>" />
</div>
 <input name="patientStatus" type="hidden"  value="<%=opdSurgeryheader!=null?opdSurgeryheader.getPatientStatus():"" %>"/> 
<%--  <input name="orderNo" type="hidden" value="<%=otBooking.getOrderNo() %>" /> --%>

<%}%>  
<input name="hospitalId" type="hidden"	value="" /> <input name="changedBy" type="hidden" value="<%=userName %>" /> 
<input name="currentDate" type="hidden"	value="<%=date %>" /> <input name="currentTime" type="hidden" value="<%=time %>" />

<input type="button" name="Submit" class="button" value="Submit"
	onclick="if(checkSubmitNomenclature()){submitForm ('otBooking','ot?method=submitPreOperativeCheckList');}" />
	
<input name="back" type="button" class="button"	value="Back" onclick="submitForm ('otBooking','ot?method=showPreOperativeCheckList&otProcedure=no')" />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName %></label>
<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed Time</label> <label class="value"><%=time %></label>
<div class="clear"></div>
</div>
</form>

<script type="text/javascript">

function openPopupWindow(){
   var requestId=document.getElementById("requestId").value.trim();
	
 window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}
function validateItemForAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    
		    if(id =="")
		    {
		    		document.getElementById('itemName'+inc).value="";
	   				document.getElementById('nomenclature'+inc).value="";
 					return ;
 			}
 			return true;
		}	
  
/* 	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	} */
	
	function removeRow(idName,countId,obj)
	{
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 3){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
	}

	function removeSurgeonRow(idName,countId,obj)
	{
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
	}
	
 function addRowForSurgery(){
		
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2';
	  sel.type='text';
	  sel.setAttribute("readonly","readonly");
	  cellRightSel.appendChild(sel);
	  
	  var cellRightSel = row.insertCell(1);
	  cellRightSel.id='nomenclaturetd'+iteration;
	  
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='nomenclature'+iteration;
	  sel.id='nomenclature'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
	 
	  var cellRight1 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
		if(validateItemForAutoComplete(this.value,iteration)){submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal='+iteration,'nomenclaturetd'+iteration);}
		
	  };
	  e0.name = 'itemName' + iteration;
	  e0.id = 'itemName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	    var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update2');
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);
    
	   new Ajax.Autocompleter('itemName'+iteration,'ac2update2','ot?method=getStoreItemForAutoComplete',{parameters:'requiredField=itemName'+iteration});
	  
	  var cellRightSel = row.insertCell(3);
	  cellRightSel.id='tdDose'+iteration;
	  
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='dose';
	  sel.id='dose'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  var cellRightSel = row.insertCell(4);
	  cellRightSel.id='tdRoute'+iteration;
	  
	  var sel = document.createElement('select');
 	 sel.name = 'route';
  		sel.options[0] = new Option('1/V', '1/V');
  		sel.options[1] = new Option('1/M', '1/M');
  		sel.options[2] = new Option('Oral', 'Oral');
  		sel.options[3] = new Option('S.C.', 'S.C.');
  		cellRightSel.appendChild(sel);
	}
 
/*  function addRowOpInstruction(){

	  var tbl = document.getElementById('preOpInstruction');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('opHiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)

	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2';
	  sel.type = 'text';
	  sel.setAttribute("readonly","readonly");
	  cellRightSel.appendChild(sel);


	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'opInstruction' + iteration;
	  e0.id = 'opInstruction' + iteration;
	  e0.size = '43'
	 
		  cellRight1.appendChild(e0);	  
		
	  var cellRight2 = row.insertCell(2);
		var e4 = document.createElement('input');
		e4.type = 'button';
		e4.className = 'button';
		e4.value='Add';
		e4.name = 'Button';
		e4.setAttribute('tabindex', '1');
		e4.onclick = function() {
			addRowOpInstruction();
		};
		cellRight2.appendChild(e4);

		var cellRight3 = row.insertCell(3);
		var e5 = document.createElement('input');
		e5.type = 'button';
		e5.className = 'button';
		e5.value='Delete';
		e5.name = 'deldddete';
		e5.setAttribute('tabindex', '1');
		e5.onclick = function() {
			removeTreatmentRow("preOpInstruction", "hdb", this);
		};
		//e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
		cellRight3.appendChild(e5)
	  
	 } */

 function addRowForInvestigation() {

		var tbl = document.getElementById('investigationGrid');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValue');
		var iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration
		// alert("iteration row--"+iteration)

		var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'text';
		// e0.innerHTML = iteration+':'
		e0.onblur = function() {

			if (validateInvestigationAutoComplete(this.value, iteration)) {
				checkForChargeCode(this.value, iteration, 'chargeCodeVal'
						+ iteration);
			}

		};
		var newdiv1 = document.createElement('div');
		newdiv1.id = 'ac2update' + iteration;
		newdiv1.className = 'autocomplete';
		newdiv1.style.display = 'none';

		e0.name = 'chargeCodeName' + iteration;
		e0.id = 'chargeCodeName' + iteration;
		e0.setAttribute('tabindex', '1');
		//alert("name--"+e0.name)
		e0.size = '100'
		cellRight0.appendChild(newdiv1);

		cellRight0.appendChild(e0);
		e0.focus();

		new Ajax.Autocompleter(
				'chargeCodeName' + iteration,
				'ac2update' + iteration,
				'opd?method=getInvestigationListForAutoComplete',
				{
					callback : function(element, entry) {
						return entry
								+ '&labradiologyCheck='
								+ document
										.getElementById('investigationCategory').value;
					},
					parameters : 'requiredField=chargeCodeName' + iteration
				});
		var sel = document.createElement('input');

		sel.type = 'hidden';
		sel.name = 'chargeCode' + iteration;
		sel.id = 'chargeCode' + iteration
		sel.size = '10';
		sel.setAttribute('tabindex', '1');
		cellRight0.appendChild(sel);

		var e2 = document.createElement('input');
		e2.type = 'hidden';
		e2.name = 'qty' + iteration;
		e2.id = 'qty' + iteration
		e2.size = '10';
		e2.setAttribute('tabindex', '1');
		cellRight0.appendChild(e2);

		/* 	  var cellRight1 = row.insertCell(1);
		 var e3 = document.createElement('input');
		 e3.type = 'checkbox';
		 e3.name='referToMh'+iteration;
		 e3.id='referToMhId'+iteration
		 e3.size='10';
		 e3.className='radio';
		 e3.value='y';
		 e3.setAttribute('tabindex','1');
		 cellRight1.appendChild(e3); */

		var cellRight2 = row.insertCell(1);
		var e4 = document.createElement('input');
		e4.type = 'button';
		e4.className = 'button';
		e4.value='Add';
		e4.name = 'Button';
		e4.setAttribute('tabindex', '1');
		//e4.setAttribute('onClick','addRowForInvestigation();');
		e4.onclick = function() {
			addRowForInvestigation();
		};
		cellRight2.appendChild(e4);

		var cellRight3 = row.insertCell(2);
		var e5 = document.createElement('input');
		e5.type = 'button';
		e5.className = 'button';
		e5.value='Delete';
		e5.name = 'deldddete';
		e5.setAttribute('tabindex', '1');
		e5.onclick = function() {
			removeRow("investigationGrid", "hdb", this);
		};
		//e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
		cellRight3.appendChild(e5);

		//fayaz removed
		//var cellRight3 = row.insertCell(1);
		// var e3 = document.createElement('input');
		// e3.type = 'text';
		// e3.name='clinicalNotes'+iteration;
		// e3.id='clinicalNotes'+iteration;
		// e3.setAttribute('tabindex','1');
		// e3.size='60'
		// cellRight3.appendChild(e3);

	}
 
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
			   								document.getElementById('itemId'+iteration).value="";
								            return;
								    }
								    else
			      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
			      						displayAuForLabour(this.value,iteration,'<%= hinId%>');checkForPurchase(this.value,iteration);
								   }
			                       else
			                    	   {
			                    	   document.getElementById('itemId'+iteration).value="";
			                    	   }
			  					  };
			  
			var newdiv = document.createElement('div');
		     	    newdiv.id='ac2update'+iteration;
		     	    newdiv.className='autocomplete';
		       	newdiv.style.display = 'none';
		          e0.size = '30';
			  e0.setAttribute('tabindex','1');
			  var e01 = document.createElement('input');
			  e01.type = 'hidden';
			  e01.name = 'itemId' + iteration;
			  e01.id = 'itemId' + iteration;
			  e0.focus();
			  
			  cellRight0.appendChild(e0);
			  cellRight0.appendChild(e01);
			  cellRight0.appendChild(newdiv);
			  
			  
			
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
//		     e9.id = 'a'
//		     e9.type = 'checkbox';
//		    cellRight9.appendChild(e9);

			} 
	 
<%-- 	function addRow(){
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
		      						checkItem(iteration);disableOtherMedicine(this.value,iteration);checkForAlreadyIssuedPrescribtion(this.value,iteration);displayAu(this.value,iteration,'<%= hinId%>');
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
		    var cellRight1 = row.insertCell(1);
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
		  cellRight1.appendChild(eImg);
		//  alert("5---");
		
		 var cellRight1 = row.insertCell(1);
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='otherMedicine'+iteration;
		  e11.id='otherMedicine'+iteration
		  e11.size='20';
		  e11.setAttribute('tabindex','1');
		  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
		  cellRight1.appendChild(e11);

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

		  var cellRight3 = row.insertCell(2);
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
		  //end
		  var e13 = document.createElement('input');
		  e13.type = 'text';
		  e13.name='au'+iteration;
		  e13.readOnly = "readonly";
		  e13.id='au'+iteration
		  e13.size='6';
		  e13.setAttribute('tabindex','1');
		  //e12.onblur=function(){displayAU(this.value,iteration)};
		  cellRight3.appendChild(e13);		 
		  cellRight3.appendChild(e1);	  
		  
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

		  var cellRight4 = row.insertCell(3);
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
		 
		  var cellRight5 = row.insertCell(4);
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
		  	  
		  var cellRight6 = row.insertCell(5);
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

		  var e5 = document.createElement('input');
		  e5.type = 'hidden';
		  e5.name='total'+iteration;
		  e5.id='total'+iteration;
		  e5.size='5';
		  e5.setAttribute('tabindex','1');
		  cellRight6.appendChild(e5);

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

			var cellRight8 = row.insertCell(6);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='route'+iteration;
			e6.id='route'+iteration
			e6.size='5';
			e6.value=''
			e6.setAttribute('maxlength', 20); 
			e6.setAttribute('tabindex','1');
			cellRight8.appendChild(e6);

		  var cellRight9 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='remarks'+iteration;
		  e7.id='remarks'+iteration
		  e7.size='10';
		  e7.setAttribute('maxlength', 40); 
		  e7.setAttribute('tabindex','1');
		  cellRight9.appendChild(e7);

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

		  var cellRight11 = row.insertCell(8);
		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name='closingStock'+iteration;
		  e72.readOnly = "readonly";
		  e72.id='closingStock'+iteration
		  e72.size='3';
		  e72.setAttribute('tabindex','1');
		  cellRight11.appendChild(e72);

		  var cellRight12 = row.insertCell(9);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'button';
		  e8.value = 'Add';
		  e8.name='remarks'+iteration;
		 // e8.setAttribute('onClick', 'addRow();'); 
		  e8.onclick = function(){addRow();}; 
		  e8.setAttribute('tabindex','1');
		  cellRight12.appendChild(e8);

		  var cellRight13 = row.insertCell(10);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'button';
		  e9.value = 'Delete';
		  e9.name='remarks'+iteration;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e9.onclick = function(){removeTreatmentRow("grid","hdb",this);};  
		  e9.setAttribute('tabindex','1');
		  cellRight13.appendChild(e9);		 
		  
		   //added - fayaz
		//  var cellRight9 = row.insertCell(9);
	   //   var e9 = document.createElement('input');
	 //     e9.id = 'a'
	 //     e9.type = 'checkbox';
	  //    cellRight9.appendChild(e9);

		} 
 --%>
	function populatePVMS(val,inc){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)

	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo'+inc).value=pvmsNo

	 }
	}
	

	function disableOtherMedicine(val,inc){
	  if(val != "")
		{
	   document.getElementById('otherMedicine'+inc).disabled = true;		
	   document.getElementById('otherMedicine'+inc).value ="";
	 //  document.getElementById('itemConversionId'+inc).disabled = true;
	  // document.getElementById('itemConversionId'+inc).value = "";
	   //document.getElementById('injCategory'+inc).disabled = true;	
	   
		}else{
			document.getElementById('otherMedicine'+inc).disabled = false;
			//document.getElementById('itemConversionId'+inc).disabled = false;
			//document.getElementById('injCategory'+inc).disabled = false;	
		}
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
	
	 function fillValue(inc){
	      var noOfDays = document.getElementById('noOfDays'+inc).value 
		  var dosage = document.getElementById('dosage'+inc).value
		  var freq=document.getElementById('frequencyValue'+inc).value
		  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
		  var sosQty = document.getElementById('sosQty'+inc).value;
		  var total = freq*noOfDays*dosage;
		  var finalQty;
		  if(document.getElementById('frequency'+inc).value != 13 ){
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				  document.getElementById('total'+inc).value=freq*noOfDays*dosage
			  }

		  }else{
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('total'+inc).value=finalQty;
				 }else{
					  document.getElementById('total'+inc).value=freq*sosQty*dosage
				  }
		  }		  
		  
		 }
	 
		function displaySOSQty(val,inc){
			
			if(val == '13'){
				document.getElementById('sosQty'+inc).style.display = 'block';
				document.getElementById('noOfDays'+inc).disabled = true;
			 }else{
			
			 document.getElementById('sosQty'+inc).style.display  = 'none';
			  document.getElementById('noOfDays'+inc).disabled = false;
			 }
			}
		 function  fillValueFromFrequency(value,inc){
		   	  var dosage = document.getElementById('dosage'+inc).value
			  var noOfDays=document.getElementById('noOfDays'+inc).value
			  var freq=document.getElementById('frequencyValue'+inc).value
			  document.getElementById('total'+inc).value=noOfDays*freq*dosage
			  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
		   	  var sosQty = document.getElementById('sosQty'+inc).value;
			  var total = freq*noOfDays*dosage;
			  var finalQty;
			  if(document.getElementById('frequency'+inc).value != 13 ){
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('total'+inc).value=finalQty;
			
				 }else{
					 
					  document.getElementById('total'+inc).value=noOfDays*freq*dosage
				  }
			 // document.getElementById('noOfDays'+inc).readOnly = false;
			 // document.getElementById('sosQty'+inc).readOnly = true;
			  }else{
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
					  if(totalQty != '0.00'){
						  finalQty = Math.ceil(totalQty);
					  }
					  document.getElementById('total'+inc).value=finalQty;
				
					 }else{
						  document.getElementById('total'+inc).value=sosQty*freq*dosage
					  }
				//  alert(document.getElementById('noOfDays'+inc).readOnly);
				 // document.getElementById('noOfDays'+inc).readOnly = true;
				 // document.getElementById('sosQty'+inc).readOnly = false;
			  }
			 }
		 
			function addRowForSurgeon(){

				  var tbl = document.getElementById('surgeonGrid');
				  var lastRow = tbl.rows.length;

				  // if there's no header row in the table, then iteration = lastRow + 1
				  var iteration = lastRow;
				  var row = tbl.insertRow(lastRow);
				  var hdb = document.getElementById('surgeonHiddenValue');
				  hdb.value=iteration

		/* 		  var cellRightSel = row.insertCell(0);
				  var sel = document.createElement('input');
				  sel.value=hdb.value;
				  sel.size='2';
				  sel.type = 'hidden';
				  sel.setAttribute("readonly","readonly");
				  cellRightSel.appendChild(sel); */


				  var cellRight1 = row.insertCell(0);
				  var e0 = document.createElement('input');
				  e0.type = 'text';
				  e0.name = 'surgeonName' + iteration;
				  e0.id = 'surgeonName' + iteration;
				  e0.size = '43'
				 
					  e0.onclick = function(){
					  fillMemberDetails(this.value,this,'2,5',':');
							  }
					e0.onblur = function(){
						fillMemberDetails(this.value,iteration);
						}
				 
				var newdiv = document.createElement('div');
			   	newdiv.setAttribute('id', 'ac2update2');
			   	newdiv.style.display = 'none';
			   	newdiv.className = "autocomplete";
			    cellRight1.appendChild(newdiv);

				  cellRight1.appendChild(e0);
				new Ajax.Autocompleter('surgeonName'+iteration,'ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName'+iteration});
			   
				/*  */
				 var cellRight2 = row.insertCell(1);
				  var d = document.createElement('input');
				  d.type = 'text';
				  d.name = 'designation' + iteration;
				  d.id = 'designation' + iteration;
				  d.size = '43'
				   d.readonly='readonly'
					  cellRight2.appendChild(d);
				  
				  
				  
				  var cellRight3 = row.insertCell(2);
				  var d2 = document.createElement('Select');
				  d2.name = 'role' + iteration;
				  d2.id = 'role' + iteration;
				  
				  
				  d2.options[0] = new Option('Select', '');
				  d2.options[1] = new Option('Surgeon', 'Surgeon');
				  d2.options[2] = new Option('First Assistance', 'First Assistance');
				  d2.options[3] = new Option('Second Assistance', 'Second Assistance');
				  d2.options[4] = new Option('Third Assistance', 'Third Assistance');
				  d2.options[5] = new Option('Fourth Assistance', 'Fourth Assistance');
				  d2.options[6] = new Option('Floor Nurse', 'Floor Nurse');
				  d2.options[7] = new Option('Main Nurse', 'Main Nurse');
					d2.options[8] = new Option('Count Nurse', 'Count Nurse');
					d2.options[9] = new Option('Anesthetist one', 'Anesthetist one');
					d2.options[10] = new Option('Anesthetist two', 'Anesthetist two');
					d2.options[11] = new Option('Anesthetist three', 'Anesthetist three');
				   cellRight3.appendChild(d2);
				   
					  var cellRight4 = row.insertCell(3);
					  var e3 = document.createElement('input');
					  e3.type = 'button';
					  e3.className = 'button';
					  e3.name='Button';
					  e3.value='Add';
					  e3.setAttribute('tabindex','1');
					  //e4.setAttribute('onClick','addRowForInvestigation();');
					  e3.onclick = function(){addRowForSurgeon();}; 
					  cellRight4.appendChild(e3);
					  

					  var cellRight5 = row.insertCell(4);
					  var e4 = document.createElement('input');
					  e4.type = 'button';
					  e4.className = 'button';
					  e4.value='Delete';
					  e4.name='remarks'+iteration;
					  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
					  e4.onclick = function(){removeRow("surgeonGrid","hdb",this);};  
					  e4.setAttribute('tabindex','1');
					  cellRight5.appendChild(e4);
					  
				 }

			function fillMemberDetails(val,inc)
			{
				  if(val!=''){
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
			              
			                  obj = document.getElementById('designation'+inc);
			                obj.length = 1;
			                  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
			                  for (loop = 0; loop < items.childNodes.length; loop++) {
			                       var item = items.childNodes[loop];
			                      var idMember = item.getElementsByTagName("idMember")[0];    
			                       var nameMember  = item.getElementsByTagName("nameMember")[0];
			                      // alert("dfsf"+item.getElementsByTagName("designation")[0]);
			                    var designation  = item.getElementsByTagName("designation")[0];
			                    if(designation.childNodes[0]!=undefined){
			                          for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
			                        {
			                            var dr = designation.childNodes[innerLoop];
			                            //var dId  = dr.getElementsByTagName("dId")[0];
			                            var dName  = dr.getElementsByTagName("dName")[0];
			                              // document.getElementById('emp_id'+inc).value = idMember.childNodes[0].nodeValue
			                          obj.length++;
			                            //obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
			                            document.getElementById('designation'+inc).value=dName.childNodes[0].nodeValue;
			                            
			                        }
			                        }
			              }
			        if(items.childNodes.length ==0)
			        	{
			        	document.getElementById('surgeonName'+inc).value ="";
			        	document.getElementById('designation'+inc).value ="";
			        	}
			        
			              }
			            }
			            var url='/hms/hms/ot?method=fillMemberForName&nameMember='+val;
			    	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			             
			            xmlHttp.open("GET",url,true);
			            xmlHttp.setRequestHeader("Content-Type", "text/xml");
			            xmlHttp.send(null);
			        }else{
			        	//alert(document.getElementById('surgeonName2').value+inc);
			            document.getElementById('surgeonName'+inc).value='';
			        }
			   
			}
			
			function OPDHistoryPopup(hinId,inpatientId,opdsurgeryid)
			{
			//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
				 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId+"&opdSurgeryId="+opdsurgeryid;;
			 //popwindow(url);
			 window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");			 
			} 
			
			function removeTreatmentRow(idName,countId,obj)
			{
			  var tbl = idName;
			  var lastRow = tbl.rows.length;
			  if (lastRow > 2){
			  //	tbl.deleteRow(lastRow - 1);
			    var i=obj.parentNode.parentNode.rowIndex;
			    tbl.deleteRow(i);
			  }
			}


</script>