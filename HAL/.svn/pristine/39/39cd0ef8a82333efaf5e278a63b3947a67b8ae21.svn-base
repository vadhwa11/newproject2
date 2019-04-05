<%-- <%@page import="jkt.hms.util.RequestConstants"%> --%>
<%@page import="static jkt.hms.util.RequestConstants.TO_WARD"%>
<%@page import="static jkt.hms.util.RequestConstants.TO_DOCTOR"%>
<%@page import="static jkt.hms.util.RequestConstants.VISIT_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.INPATIENT_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.TRANSFER_NO"%>
<%@page import="static jkt.hms.util.RequestConstants.AD_NO"%>
<%@page import="static jkt.hms.util.RequestConstants.AD_STATUS"%>
<%@page import="static jkt.hms.util.RequestConstants.FROM_WARD"%>
<%@page import="static jkt.hms.util.RequestConstants.FROM_DOCTOR"%>
<%@page import="static jkt.hms.util.RequestConstants.FROM_BED"%>
<%@page import="static jkt.hms.util.RequestConstants.BED_ID"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">

var icdArray=new Array();
var unitArray = new Array();


	function checkSubmitNomenclature() {
 	if(confirm("Do You want to submit the Record!?")){
	
					 if(validateFrequency() && validateDays()){
							
						 return true;
					}
				}else{
					return false;
				} 
				
				return false;
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
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	String userName = "";

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
	 List patientDetailList = new ArrayList();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

	 OtBooking booking=null;
	 
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<Transfer> transferNoList = new ArrayList<Transfer>();
		//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		
		int transferNo = 0;
		int hinId =0;
		String hinNo =null;
		String adNo = "";
		int inpatientId = 0;
		String admissionDate = "";
		String admissionTime = "";
		Inpatient inpatient=null;
		Patient patient=null;
		Visit visit=null;
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("transferNoList") != null){
		transferNoList = (List<Transfer>)map.get("transferNoList");
	}
	
	if(patientDetailList!=null && patientDetailList.size()>0){
		 OtBooking otBooking=(OtBooking)patientDetailList.get(0);
			int currentBedId = otBooking.getInpatient().getBed().getId();
			String currentBedNo = otBooking.getInpatient().getBed().getBedNo();
		    OpdSurgeryHeader opdSurgeryHeader = null;
		    if(otBooking.getOtBookingDt()!=null)
		    {
		   	 
		   	 Set<OtBookingDt> opdSuregryDetailsSet = new HashSet<OtBookingDt>();
		   	 opdSuregryDetailsSet = otBooking.getOtBookingDt();
		   	 
		   	 for(OtBookingDt pacDetail:opdSuregryDetailsSet)
		   	 {
		   		opdSurgeryHeader = pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery();
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
		
		
		if(otBooking!=null)
		{
			if(otBooking.getInpatient()!=null){
			inpatient=otBooking.getInpatient();
			patient = inpatient.getHin();
			}else if(otBooking.getVisit()!=null){
				patient = otBooking.getVisit().getHin();
			}
			
			if(otBooking.getVisit()!=null)
				visit =otBooking.getVisit();
				
		}
	
		if(map.get("bedList") != null){
			bedList = (List<MasBed>)map.get("bedList");
		}
		
		if(transferNoList.size() > 0){
			for(Transfer transfer : transferNoList){
				transferNo = transfer.getTransferNo()+1;
			}
		}else{
			transferNo = 1;	
		}
		
		inpatientId = inpatient.getId();
		adNo = inpatient.getAdNo();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();
		
		

String icd="";
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
%>

<!--main content placeholder starts here-->
<title>OT Transfer To ward</title>
<form name="transferByHin" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Transfer to ward</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%if(inpatient!=null) {%>
<%@include file="PatientDetails.jsp" %>
<%} %>

<input type="hidden" name="<%=HIN_ID %>"  value="<%=otBooking.getHin()!=null?otBooking.getHin().getId():"" %>"/>
<%-- <input type="hidden" name="<%=VISIT_ID %>" value="<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():"" %>" /> --%>
<input type="hidden" name="<%=INPATIENT_ID %>"  value="<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():"" %>"  />
<input
	name="otBookingId" type="hidden"
	value="<%=otBooking.getId() %>" /> 
<label>Surgery Date</label> 
<input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>" />
<%-- <label>Requisition No.</label> 
<input type="text" readonly="readonly" value="<%=otBooking.getOrderNo() %>" /> --%>

 
<div class="clear"></div>
<div class="clear"></div>
		<label>Provisional Diagnosis </label>
<textarea class="large" readonly="readonly"><%=icd%></textarea>
<input type="hidden" name="bookingId" id="bookingId"	value="<%=booking!=null?booking.getId():"" %>" />
<div class="clear"></div>

<%-- <td><input name="selectCheckBox" id="selectCheckBox" type="button" value="<%=otBooking.getId() %>" onClick="javascript:openPopupWindow(this.value);" /></td> --%>
 <%-- <input type="hidden" id="requestId" value="<%=otBooking.getHin().getId() %>"/> --%>
<!-- <input type="button" name="Submit" class="button" value="Allergy"
	onclick="javascript:openPopupWindow();" /> -->
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>

<%if(opdSurgeryHeader!=null && opdSurgeryHeader.getHin()!=null && opdSurgeryHeader.getInpatient()!=null)  {%>
<%-- <input type="button" class="button" tabindex="3" name=""
	value="+" onclick="OPDHistoryPopup('<%=opdSurgeryHeader.getHin().getId()%>', '<%=opdSurgeryHeader.getInpatient().getId()%>', '<%=opdSurgeryHeader.getId()%>');" />
<div class="popupTextDiv">Current OPD/IPD/OT History</div>	 --%>		
			<div class="floatRight">
				<a href="#"onclick="getTodayAllPrescriptionPopup('<%=opdSurgeryHeader.getHin().getId()%>','y','OT');">Current Medication</a>
				<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<%
				 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
					hinNo = hinNo.substring(1, hinNo.length()); %>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>



				
			</div>
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">

<%-- <input type="hidden" name="otDepartmentId" value="<%=otDepartmentId%>"  id="otDepartmentId"> --%>
<%-- <input type="hidden" name="motherinpatientid" value="<%=inpatientid%>"> --%>

<div class="Block">
<label>Transfer Patient <span>*</span></label>
<select name="<%=TO_WARD %>" validate='Patient Transfer,string,yes' onchange="submitProtoAjaxWithDivName('transferByHin','/hms/hms/appointment?method=getDoctorList','doctorList');checkBedTransferFromOT(this.value, <%=otBooking.getInpatient().getDepartment().getId()%>, 'TransferDiv','bedNo','<%=BED_ID %>','<%=currentBedNo%>','<%=currentBedId%>','BedDiv', 'wardId', 'doctorList');" id="wardId">
<option value="0">Select</option>
<%for(MasDepartment department : departmentList){ 
     if(otBooking.getInpatient().getDepartment().getId()==department.getId())
     {
%>
          <option value="<%=department.getId()%>" selected>Back To ward</option>
       <%}else{ %>   
<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>

<%}} %>
</select>
<input type="hidden" name="<%=BED_ID %>" value="<%=currentBedId%>" id="<%=BED_ID %>">

<span id="BedDiv">
<label> To Bed No. <span>*</span></label>
<input type="text" id="bedNo" readonly="readonly" validate='Bed No,string,yes' value="<%=currentBedNo%>" />
</span>
<div class="Clear"></div>
<div id="TransferDiv" style="display: none;">
 <label> To Doctor <span>*</span></label> 
 <div id ="doctorList">
	<select name="<%=TO_DOCTOR%>"	id="<%=TO_DOCTOR %>">
		<option value="0">Select</option>
	</select> 
 </div>
 <label> Transfer reason <span>*</span></label>
 <textarea  id="transferReason" name="transferReason" validate='Reason,string,no' value="" maxlength="5000"></textarea>
</div>

	<div class="Clear"></div>
<div class="paddingTop5"></div>
<input type="button" name="Submit10" value="Save" class="button"
	onClick="checkTransfer()" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> <input type="button" class="button" value="Back"
	align="right" onclick="showBack('transferByHin')"  />

</div>

 <input name="patientStatus" type="hidden" value="In Patient" /> 
 <input name="orderNo" type="hidden" value="<%=otBooking.getOrderNo() %>" />


<%	 } %>  
<input name="hospitalId" type="hidden"	value="" /> <input name="changedBy" type="hidden" value="<%=userName %>" /> 
<input name="currentDate" type="hidden"	value="<%=date %>" /> <input name="currentTime" type="hidden" value="<%=time %>" />

	<%-- 	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
		<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId %>" id=inpatientId> --%>


<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName %></label>
<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed Time</label> <label class="value"><%=time %></label>
<div class="clear"></div>
</div>

<script type="text/javascript">
function jsSetBedId(bedId,bedIdFieldId)
{
   document.getElementById(bedIdFieldId).value=bedId;
   //alert("fgg "+bedIdFieldId +bedId);
   // alert( document.getElementById("bedId");
   
   
}
	
	function OPDHistoryPopup(hinId,inpatientId,opdsurgeryid)
	{
	//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
		 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId+"&opdSurgeryId="+opdsurgeryid;;
	 //popwindow(url);	 
	 window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");
	} 


	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showTransferToWardWaitingList";
	  obj.submit();
	}

	function checkTransfer()
	{
		
		if( document.getElementById("doctorId")!=null && document.getElementById("doctorId").value!="0" && document.getElementById("transferReason").value=="")
			{
			  alert("Please enter transfer reason");
			  return false;
			}
		submitForm('transferByHin','/hms/hms/ot?method=submitTransferInformation');
	}

	
	
</script>
</form>

