<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
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
	
					 if(validateFrequency() && validateDays() &&  validateNip()){
							
						 return true;
					}
				}else{
					return false;
				} 
				
				return false;
		}	

	
	function validateDays(){
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

	<% 
		String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForLiquidForm").trim().split(",");
	for(int i=0;i<ItemClassCodeForLiquid.length;i++)
	{
	%>
	<script>

	itemClassCodeArray[<%=i%>]= new Array();
	itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

     			
            </script>
<%	}%>
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
/* 	 if(map.get("patientDetailList") != null){
		 booking=(OtBooking)map.get("booking");
		} */
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
	
	int hinId =0;
	String hinNo =null;
	int preAnethesiaHdId = 0;
	if(patientDetailList!=null && patientDetailList.size()>0){
		 OtBooking otBooking=(OtBooking)patientDetailList.get(0);
		
	    String patientName="";
	     hinId = otBooking.getHin().getId();
	     hinNo = otBooking.getHin().getHinNo();
	    int surgeryHeaderId = 0;
	    OpdSurgeryHeader opdSurgeryHeader= null;
	    if(otBooking.getOtBookingDt()!=null)
	    {
	   	 
	   	 Set<OtBookingDt> opdSuregryDetailsSet = new HashSet<OtBookingDt>();
	   	 opdSuregryDetailsSet = otBooking.getOtBookingDt();
	   	 
	   	 for(OtBookingDt pacDetail:opdSuregryDetailsSet)
	   	 {
	   		surgeryHeaderId = pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery().getId();
	   		opdSurgeryHeader = pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery();
	   		preAnethesiaHdId = pacDetail.getOtPreAnesthesiaDetail().getAnesthesiaHd().getId();
	   		 break;
	   	 }
	   	
	    }
	     
	     
		if(otBooking.getHin().getPFirstName()!= null){
			patientName=otBooking.getHin().getPFirstName();
		}
		if(otBooking.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPMiddleName();
		}
		if(otBooking.getHin().getPLastName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPLastName();
		}
		
		Inpatient inpatient=null;
		Visit visit=null;
		Patient patient=null;
		if(otBooking!=null)
		{
			if(otBooking.getVisit()!=null)
				visit =otBooking.getVisit();
			
			if(otBooking.getInpatient()!=null){
			inpatient=otBooking.getInpatient();
			patient = inpatient.getHin();
			
			}else if(otBooking.getVisit()!=null){
				patient = otBooking.getVisit().getHin();
			}
			
			
		}
		
		Set<OtBookingDt> OtBookingDtSet = new HashSet<OtBookingDt>();
		OtBookingDtSet = otBooking.getOtBookingDt();
		int count =1;
		String procedure = "";
		for(OtBookingDt otDt :OtBookingDtSet){
				if(otDt.getStatus() !=null && !otDt.getStatus().equalsIgnoreCase("y") && !otDt.getStatus().equalsIgnoreCase("c"))
				{
					if(count++ >1)
					procedure += " | ";
					procedure += otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName();
		 
				}
		}

String icd="";
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
	
	String anesthesiaDetails ="";
	if(map.get("anesthesiaDetails")!=null)
	{
		anesthesiaDetails = (String)map.get("anesthesiaDetails");
	}
	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
    List <MasOpInstruction> preInstructionList =new ArrayList<MasOpInstruction>();
    if(map.get("preInstructionList") != null){
    	preInstructionList = (List<MasOpInstruction>) map.get("preInstructionList");
    			}
    
%>

<!--main content placeholder starts here-->
<title>Pre-Anesthesia Notes</title>
<form name="otBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Pre-Anesthesia Procedure Note</h2>
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
          <input type="text" readonly="readonly" value="<%=otBooking.getOrderNo() %>" />
		<label>Surgery Requisition Date</label> <input type="text"
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

<input type="hidden" name="<%=RequestConstants.HIN_ID %>"  value="<%=otBooking.getHin()!=null?otBooking.getHin().getId():"0" %>"/>
<input type="hidden" id="visitId" name="<%=RequestConstants.VISIT_ID %>" value="<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():"0" %>" />
<input type="hidden" name="<%=RequestConstants.INPATIENT_ID %>"  value="<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():"0" %>"  />
<input
	name="opdSurgeryHeaderId" type="hidden"
	value="<%=surgeryHeaderId %>"/> 
	
<label>Anesthesia</label> 
<input type="text" readonly="readonly" value="<%=anesthesiaDetails!=null?anesthesiaDetails:""%>" />
 <div class="clear"></div>
		<label>Provisional Diagnosis </label>
<textarea class="large" readonly="readonly"><%=icd%></textarea>
<div class="clear"></div>

<input type="hidden" name="bookingId" id="bookingId" value="<%=otBooking!=null?otBooking.getId():"" %>" />

<label>Procedure</label> 
   <label class="value" style="width: 472px;"><%=procedure%></label>


<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<%if(opdSurgeryHeader!=null && opdSurgeryHeader.getHin() !=null && opdSurgeryHeader.getInpatient()!=null)  {%>
<div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopup('<%=opdSurgeryHeader.getHin().getId()%>','y','OT');">Current Medication</a>
				<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<%
				 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
					hinNo = hinNo.substring(1, hinNo.length()); %>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>



					
			</div>
<%-- <input type="button" class="button" tabindex="3" name=""
value="+" onclick="OPDHistoryPopup('<%=opdSurgeryHeader.getHin().getId()%>', '<%=opdSurgeryHeader.getInpatient().getId()%>', '<%=opdSurgeryHeader.getId()%>');" /> 
<div class="popupTextDiv">Current OPD/IPD/OT History</div>--%>

<input type="button" class="button" tabindex="3" name=""
value="+" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=opdSurgeryHeader.getHin().getId()%>&visitId=<%=opdSurgeryHeader.getVisit().getId() %>&preAnethesiaHdId=<%=preAnethesiaHdId%>')" />
<div class="popupTextDiv">PAC Details</div>

<%} %><div class="clear"></div>
<div class="paddingTop15"></div>

<%-- <td><input name="selectCheckBox" id="selectCheckBox" type="button" value="<%=otBooking.getId() %>" onClick="javascript:openPopupWindow(this.value);" /></td> --%>
<input type="hidden" id="requestId" value="<%=otBooking.getHin().getId() %>"/>
<!-- <input type="button" name="Submit" class="button" value="Allergy"
	onclick="javascript:openPopupWindow();" /> -->
</div>


<div class="clear"></div>
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

<h4>Pre OP Instructions (One Day Before Surgery)</h4>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input readonly="readonly" type="hidden" size="2" name="totalPrevOPInstruction" value="<%=preInstructionList.size()%>"/>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="preOpInstruction">
	<tr>
		<th scope="col">SI No.</th>
		<th scope="col">Pre OP Instruction</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%int inc=1;
	int temp = 0;
	int j = 0;
	String instruction =null;
	for(MasOpInstruction opInstruction :preInstructionList){ 
	     String[] spaceArray =  opInstruction.getInstruction().split("\\...");
	      instruction = opInstruction.getInstruction();
	     if(spaceArray.length >1)
	        System.out.println("length "+spaceArray.length +" ff"+spaceArray[0]);
	%>
	   <tr>
	      <td>
	       <input type="hidden" name="actualValue<%=inc%>" value="<%=opInstruction.getInstruction()%>">
	      <input readonly="readonly" type="text" size="2" value="<%=inc%>"/></td>
	      <td>
    <%if(spaceArray.length >1){ 
    	j = 0;
	         for(String a:spaceArray){ 
	      
	   	   if(temp==spaceArray.length-1){
	       %>
	        <input type="text" name="<%=opInstruction.getId()%>blank<%=j++ %>" value="<%=a%>"  style="float: none;" readonly="readonly"/>
	        <%
	        if(instruction.lastIndexOf("...")==instruction.length()-3) {%>
	         <input type="text" name="<%=opInstruction.getId()%>blank<%=j++ %>" id="" style="float: none;" maxlength="20"> 
	       <% } 
	        
	    	}else{ %>
	    	 <input type="text" name="<%=opInstruction.getId()%>blank<%=j++ %>" value="<%=a%>"  style="float: none;"readonly="readonly" />
	    	<input type="text" name="<%=opInstruction.getId()%>blank<%=j++ %>" style="float: none;" maxlength="20">  
	   		<% }
	       	temp++;
	     	}
	         %>
	         
	         <input type="hidden" name="totalBlank<%=inc%>" value="<%=j%>">
	         <%
	      }
    else
    {
    	%>
    	<input type="text" name="" id="" value="<%=opInstruction.getInstruction()%>" size="150">
    	<%
    }
	       %>	      
	      </td>
	      <td><input type="checkbox" name="OpNotesId<%=inc %>" value="<%=opInstruction.getId()%>"/></td>
	      <td></td>
	   </tr>
	<%inc++;} %>
	<tr>
		<td><input readonly="readonly" type="text" size="2" value="<%=inc%>" /></td>
		<td>
		 <input type="text" value="" tabindex="1"
			id="opInstruction<%=inc%>" size="43" name="opInstruction<%=inc%>" maxlength="70"
			 <%-- onblur="fillMemberDetails(this.value,<%=inc%>)" --%>/>
		</td>
		<td>
		  	<input type="button"
			class="button" alt="Add" value="Add" onclick="addRowOpInstruction();"
			align="right" />
		</td>
		
		<td>
			<input type="button" class="button" alt="Delete" value="Delete"
			onclick="removeRow('preOpInstruction','opHiddenValue',this);" align="right" /> 
		</td>
	</tr>
		<input type="hidden" value="<%=inc%>" name="opHiddenValue" id="opHiddenValue" />
</table>

<div class="clear"></div>
<h4>Premedication</h4><div class="clear"></div>
<%-- 
<div class="Block">
<div class="clear"></div>
<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>Nomenclature1/Material Code</th>
	    <th colspan="1">Other Drug</th>
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
	<!-- 		<th scope="col">Unit</th> -->
		<th scope="col">Class</th>
		<th scope="col">AU</th>
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
		<!--
		<th id="sosQtyLbl">Qty</th>
		--><!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
		<th scope="col">Remarks</th>
		<!-- <th scope="col">CT</th> -->
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="checkForAlreadyIssuedPrescription(this.value,'1', document.getElementById('visitId').value);populatePVMS(this.value,'1');checkItem(1);disableOtherMedicine(this.value,'1');displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');"  />
	     <input type="hidden" name="itemId1" id="itemId1"	value="" />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td>
		<td><select name="itemClass1" id="itemClass1">
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
		
		</td>
 		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
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
		<input type="hidden" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1" id="highValueMedicine1" name="highValueMedicine1" validate="AU,string,no" value=""/>
	    <input type="hidden" tabindex="1" id="itemClassCode1" name="itemClassCode1" validate="itemClassCode,string,no" value="" />  
		</td>
		<td>
		<select name="dispensingUnit1" id="dispensingUnit1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		</td>
	<td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>
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
		<td><input type="text" name="total1" tabindex="1" id="total1" size="3"/></td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
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
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="button" value="Add" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="Delete" class="button" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>

</div>

 --%>

<div class="Block">
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
						<th scope="col">Dispensing Unit</th>
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
						<td><input type="text" tabindex="1"
							id="nomenclature1" size="30" name="nomenclature1"
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
						<td><select name="dispensingUnit1" id="dispensingUnit1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select>
						
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
							id="noOfDays1" onblur="fillValue('1')" size="3" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total1" tabindex="1" id="total1"
							size="3" validate="total,num,no" /></td>
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
						<th scope="col">Dispensing Unit</th>
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
							id="noOfDays<%=nipInc%>" onblur="fillValue('<%=nipInc%>')" size="3" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total<%=nipInc%>" tabindex="1" id="total<%=nipInc%>"
							size="3" validate="total,num,no" /></td>
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

<div class="Block">
<div class="clear"></div>
<div class="clear"></div>
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

		
		<% inc=1;
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
<div class="paddingTop10"></div>

<div class="clear"></div><label>Pre Operative Advice</label>
 <textarea name="preOperativeAdvice" cols="0" rows="0" class="medium" id="preOperativeAdvice" oninput="return checkMaxLengthMoz(this)"
onpaste="return checkOnPaste(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="45"></textarea>

<label>Remarks</label> 
<textarea name="remarks"  id="remarks" cols="0" rows="0" class="medium" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="45"></textarea>
<div class="clear"></div>
<input name="hinId" id="hinId"type="hidden" value="<%=otBooking.getHin().getId() %>" />
</div>

 <input name="patientStatus" type="hidden"  value="<%=opdSurgeryHeader!=null?opdSurgeryHeader.getPatientStatus():"" %>"/> 
<%--  <input name="orderNo" type="hidden" value="<%=otBooking.getOrderNo() %>" /> --%>

<%}%>  
<input name="hospitalId" type="hidden"	value="" /> <input name="changedBy" type="hidden" value="<%=userName %>" /> 
<input name="currentDate" type="hidden"	value="<%=date %>" /> <input name="currentTime" type="hidden" value="<%=time %>" />

<input type="button" name="Submit" class="button" value="Submit"
	onclick="if(checkSubmitNomenclature()){submitForm ('otBooking','ot?method=submitPreAneaesthesiaProcNotesEntryJsp');}" />
	
<input name="back" type="button" class="button"	value="Back" onclick="submitForm ('otBooking','ot?method=showPreAnesthesiaWaitingList&otProcedure=no')" />

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
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
	}


	function removeTreatmentRow(idName,countId,obj)
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
 
 function addRowOpInstruction(){

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
		  e0.setAttribute('maxlength', 70); 
	 
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
  
	 }

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
		 
		 function OPDHistoryPopup(hinId,inpatientId,opdsurgeryid)
		 {
		 //var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
		 	 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId+"&opdSurgeryId="+opdsurgeryid;;
		  //popwindow(url);
		  window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");
		 } 
</script>