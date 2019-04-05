<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.Users"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<%
int deptId = 0;
String errorMsg = "";
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
if(deptId == 49){
	errorMsg = " Radio Id ";
}else{
	errorMsg = " Diag No ";
}
%>
<form name="sampleAcceptance" method="post" action=""><script
	type="text/javascript">
	function CheckAll(checkall)
	{
		var c = document.getElementById('counter').value;
	
		if(checkall.checked ){
			for (var i=1;i < c;i++) {
	  			if(document.getElementById('acceptedCheck'+i).disabled == false){
	  				document.getElementById('acceptedCheck'+i).checked =true;
	  				document.getElementById('rejected'+i).checked=false;
	  				document.getElementById("reason"+i).value="";
	 				document.getElementById("reason"+i).type="hidden";
	 				document.getElementById("modifyOrderDivId"+i).style.display='none';
	 				document.getElementById("rejectAllButton").checked=false;
	  			}
	 			//document.getElementById("reason"+i).style.display='none';
	 		}
		}else{
			checkall.checked == false ;
		 	var i=1;
		 	for (;i < c;i++) {
	  			document.getElementById("acceptedCheck"+i).checked =false;
	 	 	}
	 	}
	}

	function checkAllReject(checkAllRejected)
	{

		var c = document.getElementById('counter').value;
		if(checkAllRejected.checked ){
			for (var i=1;i < c;i++) {
	  			if(document.getElementById('acceptedCheck'+i).disabled == false){
	  				document.getElementById('rejected'+i).checked =true;
	  				document.getElementById('acceptedCheck'+i).checked=false;
	  				document.getElementById("reason"+i).value="";
	 				document.getElementById("reason"+i).type="text";
	 				document.getElementById("modifyOrderDivId"+i).style.display='block';
	 				document.getElementById("addbutton").checked=false;
	 				//var rejectedTextField = document.getElementById("reason"+i);
					//rejectedTextField.setAttribute('validate','Reason,string,yes');
	  			}
	 			//document.getElementById("reason"+i).style.display='none';
	 		}
		}else{
			checkAllRejected.checked == false ;
		 	var i=1;
		 	for (;i < c;i++) {
		 		if(document.getElementById('acceptedCheck'+i).disabled == false){
		  			document.getElementById("rejected"+i).checked =false;
		  			document.getElementById("reason"+i).value="";
		 			document.getElementById("reason"+i).type="hidden";
		 			document.getElementById("modifyOrderDivId"+i).style.display='none';
		 			//var rejectedTextField = document.getElementById("reason"+i);
					//rejectedTextField.setAttribute('validate','Reason,string,no');
				}
	 	 	}
	 	}
	}

	function fillSameDiagNoInAll()
	{
		var valueToCopy = document.getElementById('diagForAll').value; 
		if(valueToCopy == ''){
			alert('Fill Some Value To Copy.');
			return false;
		}
		var c = document.getElementById('counter').value;
		for (var i=1;i < c;i++) {
	  		if(document.getElementById('acceptedCheck'+i).disabled == false){
	  			document.getElementById('diag'+i).value = valueToCopy;
	  		}
	 	}
	 	return true;
	}
	
	function fillRejectedReasonInAll()
	{
		var valueToCopy = document.getElementById('rejectedReasonForAll').value; 
		if(valueToCopy == ''){
			alert('Fill Some Value To Copy.');
			return false;
		}
		var c = document.getElementById('counter').value;
		var rejectedFlag = false;

		for (var i=1;i < c;i++) {
	  		if(document.getElementById('rejected'+i).checked == true 
	  				&& document.getElementById('rejected'+i).disabled == false){
	  			document.getElementById('reason'+i).value = valueToCopy;
	  			rejectedFlag = true;
	  		}
	 	}
	 	if(rejectedFlag == false){
	 		alert('No Sample is Rejected to fill Reason.');
	 		return false;
	 	}
	 	return true;
	}

function  accepted(chkObj, inc)
{
	 if(chkObj.checked){
	 if(chkObj.id == "acceptedCheck"+inc){
	 	document.getElementById("reason"+inc).value="";
	 	document.getElementById("reason"+inc).readOnly=true;
	 	document.getElementById("reason"+inc).type="hidden";
	 	document.getElementById("reason"+inc).style.display='none';
	 	document.getElementById('rejected'+inc).checked=false;
	 	document.getElementById("modifyOrderDivId"+inc).style.display='none';
	 }
	 }	
}
	function  rejected(chkObj, inc)
	{
		if(chkObj.checked){
			document.getElementById("addbutton").checked=false;
		  	if(chkObj.id == "rejected"+inc){
		 		document.getElementById("reason"+inc).type="text";
		 		document.getElementById("reason"+inc).readOnly=false;
		 		document.getElementById("modifyOrderDivId"+inc).style.display='block';
		 		//document.getElementById("reason"+inc).style.display='block';
		    	document.getElementById('acceptedCheck'+inc).checked=false;
				//var rejectedTextField = document.getElementById("reason"+inc);
				//rejectedTextField.setAttribute('validate','Reason,string,yes');
	  		}
	 	}
	 	if(!chkObj.checked){
	 		if(chkObj.id == "rejected"+inc){
	 			document.getElementById("reason"+inc).value="";
		 		document.getElementById("reason"+inc).type="hidden";
		 		document.getElementById("reason"+inc).readOnly=true;
		 		document.getElementById("modifyOrderDivId"+inc).style.display='none';
		 		//var rejectedTextField = document.getElementById("reason"+inc);
				//rejectedTextField.setAttribute('validate','Reason,string,no');
		 		
		 		//document.getElementById("reason"+inc).style.display='none';
		  		//document.getElementById('acceptedCheck'+inc).checked=;
	  		}
	 	}
 	}
 //function  rejected(chkObj, inc)
	//{
		 //if(chkObj.checked){
		// document.getElementById("addbutton").checked=false;
		 // if(chkObj.id == "rejected"+inc){
		  
		// 	document.getElementById("reason"+inc).type="text";
		// 	document.getElementById("reason"+inc).readOnly=false;
		//    document.getElementById('acceptedCheck'+inc).checked=false;
		    //document.getElementById("reason"+inc).style.display='block';
	  //}
	// }
	// if(!chkObj.checked){
	// if(chkObj.id == "rejected"+inc){
	//	 	document.getElementById("reason"+inc).value="";
	//	 	document.getElementById("reason"+inc).type="hidden";
	//	 	document.getElementById("reason"+inc).readOnly=true;
		 	//document.getElementById("reason"+inc).style.display='none';
		  //  document.getElementById('acceptedCheck'+inc).checked=;
	//  }
	// }
// }
function validateSampleValidation(){
flag = true;
counter = document.getElementById('counter1').value;
		for(var i = 1; i < counter; i++){
			  if(document.getElementById('rejected'+i).checked || document.getElementById('acceptedCheck'+i).checked) 
              { 
              	flag = false;
     		  }
     		  
  		}
  		if(flag == false)
  		{	
			return true;
		}
		else{
			<% if(deptId == 49 ){ %>
				alert("Accept atleat one Report !!!!");
			<% }else{ %>
				alert("Accept atleat one Sample !!!!");
			<% } %>	
			
			return false;
		}
	}
	
	
	function checkRadioIdForExisting(radioNoObj, rowCount) 
	{
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
      		var items =xmlHttp.responseXML.getElementsByTagName('radioIdFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		<% if(deptId == 49){ %>
	    	    			alert('Radio Id '+ radioNoObj.value + ' already exist.');
	    	    		<% }else{ %>
	    	    			alert('Diag No '+ radioNoObj.value + ' already exist.');
	    	    		<% } %>
	    	    		
	    	    		document.getElementById('diag'+rowCount).focus();
	    	    		document.getElementById('radioIdValueCheckOnSubmit'+rowCount).value='duplicateRadioId';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('radioIdValueCheckOnSubmit'+rowCount).value='correctRadioId';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		radioNo = radioNoObj.value;
  		// alert(radioNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var sampleCollectionIdToCheck = document.getElementById('sampleCollectionDetailId'+rowCount).value;
  		var url="/hms/hms/lab?method=checkForExistingRadioId&radioIdToCheck="+radioNo+"&sampleCollectionIdToCheck="+sampleCollectionIdToCheck;
    	xmlHttp.open("GET",url,true);
    	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(null);
  		
	}
 function goBack(){
 	window.location.href='/hms/hms/lab?method=showPendingSampleValidationLabJsp';
 }  
	
function checkRadioId(){

	var dupFlag = false;
	var dupFlagAtClietSide = false;
	var counter = document.getElementById('counter1').value;
		for(var checkBlank = 1;checkBlank < counter; checkBlank++){
			var isBlank = document.getElementById('diag'+checkBlank).value;
			var acceptFlag = document.getElementById('acceptedCheck'+checkBlank).checked;
			
			if(isBlank == undefined || isBlank == ''){
				if(acceptFlag == true){
						<% if(deptId == 49){ %>
							alert('Radio Id can not be blank.');
	    	    		<% }else{ %>
							alert('Diag No. can not be blank.');
	    	    		<% } %>
					
					
					return false;
				}
			}
		}
		//for(var j = 1;j < counter; j++){
     	//	  var radioValueToCheckDuplicate = document.getElementById('radioIdValueCheckOnSubmit'+j).value;
     		  
     	//	  if(radioValueToCheckDuplicate == 'duplicateRadioId' ){
		//		   if(j==1){
		//		   		alert(j+'st'+' row' +'<%=errorMsg%>' + 'already exist.');
		//		   }else if(j==2){
		//		   		alert(j+'nd'+' row' + '<%=errorMsg%>' +'already exist.');
		//		   }else if(j == 3){
		//		   		alert(j+'rd'+' row' + '<%=errorMsg%>' +'already exist.');
		//		   }else{
		//		   		alert(j+'th' + ' row'+ '<%=errorMsg%>' +'already exist.');
		//		   }
		//		   dupFlag = true;
		//		   break; 		  	
		//		}
		//}
		//	if(dupFlag == true){
		//		return false;
		//	}else{
			
		//		for(var outer = 1;outer < counter ; outer++){
		//			var outerRadioValueToCheckDuplicate = document.getElementById('diag'+outer).value;
		//			for(var inner = outer+1 ;inner < counter ; inner++){
		//				var innerRadioValueToCheckDuplicate = document.getElementById('diag'+inner).value;
		//				if(innerRadioValueToCheckDuplicate != ''){
		//					if(outerRadioValueToCheckDuplicate == innerRadioValueToCheckDuplicate){
		//						dupFlagAtClietSide = true;
		//						break;
		//					}
		//				}
		//			}
		//			if(dupFlagAtClietSide == true){
		//				break;
		//			}
		//		}
		//		if(dupFlagAtClietSide == true){
		//			alert( '<%=errorMsg%>' + 'can not be duplicate.');
		//			return false;
		//		}else{
		//			return true;
		//		}
		//}
		
			//return false;
			
		var c = document.getElementById('counter').value;
		var rejectedFlag = false;

		for (var i=1;i < c;i++) {
	  		if(document.getElementById('rejected'+i).checked == true 
	  				&& document.getElementById('reason'+i).value == ''){
	  			alert('Reason can not be blank for rejected sample.');
	  			return false;
	  		}
	 	}
		
		return true;
}

function submitForAddingNewTest(inc){
	var rejectedTextField = document.getElementById("reason"+inc);
	rejectedTextField.setAttribute('validate','Reason,string,yes');
	var empIdForInvestigation = document.getElementById('empIdForInvestigation');
	empIdForInvestigation.setAttribute('validate','Reason,string,no');
	
	var sampleCollDtId = document.getElementById('sampleCollectionDetailId'+inc).value;
	var rejReason = document.getElementById('reason'+inc).value;
	var patientType = document.getElementById('sampleCollectionHeaderPatientType').value;

	if(patientType == 'IP'){
		if(confirm("Are you sure.\nYou want to reject the test.")){
			submitForm('sampleAcceptance','lab?method=submitSampleAcceptanceAddNewOrder&sampleCollDtId='+sampleCollDtId+'&flagForUpdate=upatedOrderBooking&rejReason='+rejReason);	
		}else{
			return false;
		}	

		
	}else{
		if(confirm("Are you sure.\nYou want to reject the test.")){
			submitForm('sampleAcceptance','lab?method=addNewOrderForOPD&sampleCollDtId='+sampleCollDtId+'&flagForUpdate=upatedOrderBooking&rejReason='+rejReason);
		}else{
			return false;
		}
	}
	
	
}

	
</script> <script type="text/javascript">
 <%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<DgSampleCollectionDetails> sampleCollectionDtList = new ArrayList<DgSampleCollectionDetails>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	String date1 = (String)utilMap.get("dateTime");

	String userName = "";
	String deptType = "";
	String combinedIds = "";

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	DgSampleCollectionHeader dgSampleCollectionHeader= new DgSampleCollectionHeader();
	int hinId= 0;
	try{
		if(map.get("sampleCollectionDtList") != null){
			sampleCollectionDtList = (List)map.get("sampleCollectionDtList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.println("sampleCollectionDtList :"+sampleCollectionDtList.size());
	if(sampleCollectionDtList != null) {
			dgSampleCollectionHeader = (DgSampleCollectionHeader) sampleCollectionDtList.get(0).getSampleCollectionHeader();
			hinId =dgSampleCollectionHeader.getHin().getId();
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("combinedIds") != null){
		   combinedIds = (String)map.get("combinedIds");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		 properties.load(resourcePath.openStream());
	    } catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
	
	List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
	employeeCodeList = (ArrayList) map.get("employeeCodeList");
	System.out.println("emplo Code List :"+employeeCodeList.size());
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	
	
%> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<div class="titleBg"><h2>Sample validation</h2></div>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<div class="titleBg"><h2>Acceptance for Radiological Investigations</h2></div>
<%} %> <!--main content placeholder starts here-->
<div class="Clear"></div>
<div class="Block">
<label>Order Date</label>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgSampleCollectionHeader.getOrder().getOrderDate())%></label>
<label class="medium">Order Time</label> <label class="valueMedium"><%=dgSampleCollectionHeader.getOrder().getOrderTime()%></label>
<label class="medium">Order No.</label> <label class="valueMedium"><%=dgSampleCollectionHeader.getOrder().getOrderNo()%></label>
<label class="medium">Department</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName()%></label>
</div>
<div class="Clear"></div>

<!--Block One Starts-->
<h4>Employee Details</h4>
<div class="Block">

 <label>Employee
No</label> <%
				if(dgSampleCollectionHeader.getHin().getServiceNo() != null && !(dgSampleCollectionHeader.getHin().getServiceNo().equals(""))){
			  %> <label class="value"><%= dgSampleCollectionHeader.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> 


<label>Employee Name</label> <%
				if(dgSampleCollectionHeader.getHin().getSFirstName() != null  && !(dgSampleCollectionHeader.getHin().getSFirstName().equals(""))){
					String sMiddleName = "";
					String sLastName = "";
					if(dgSampleCollectionHeader.getHin().getSMiddleName() != null){
						sMiddleName = dgSampleCollectionHeader.getHin().getSMiddleName();
					}
					if(dgSampleCollectionHeader.getHin().getSLastName() != null){
						sLastName = dgSampleCollectionHeader.getHin().getSLastName();
					}
			 %> <label class="value"><%= dgSampleCollectionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value">-</label> <% }%> 
<label>Designation</label>
<%
			if(dgSampleCollectionHeader.getHin().getRank() != null){
			%> <label class="value"><%= dgSampleCollectionHeader.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>


</div>
<!--Block one Ends--> <!--  <div class="division"></div> --> <!--Block Two Starts-->
<div class="Clear"></div>
 <h4>Patient Deails </h4>
<div class="Block">
<label>Reg No.</label>
<label class="value"><%=dgSampleCollectionHeader.getHin().getHinNo() %></label>

<%
					String middleName = "";
					String lastName = "";
					if(dgSampleCollectionHeader.getHin().getPMiddleName() != null){
						middleName = dgSampleCollectionHeader.getHin().getPMiddleName();
					}
					if(dgSampleCollectionHeader.getHin().getPLastName() != null){
						lastName = dgSampleCollectionHeader.getHin().getPLastName();
					}
					
					%> <label class="NoWidth">Patient Name</label> <label
	class="value"><%= dgSampleCollectionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <%if(dgSampleCollectionHeader.getHin().getSex() != null){ %>
<label class="value"><%=dgSampleCollectionHeader.getHin().getSex().getAdministrativeSexName() %></label>
<%} %> <%-- <%
			String age = "";
			String currentAge = "";
			age = dgSampleCollectionHeader.getHin().getAge();
			System.out.println("age" +age);
		    currentAge = HMSUtil.calculateAgeForADT(age, dgSampleCollectionHeader.getHin().getRegDate());
		%> <label>Age</label> <%if (currentAge != null) {%> <label
	class="value"><%=currentAge%></label> <%}else{ %> <label class="value">-</label>
<%} %>  --%><!-- 	<label class="NoWidth">Marital Status</label> --> <%
					String maritalStatus = "";
				    if(dgSampleCollectionHeader.getHin().getMaritalStatus() != null){
					maritalStatus = dgSampleCollectionHeader.getHin().getMaritalStatus().getMaritalStatusName();
				%> <!--  <label class="value"><%=maritalStatus%></label> --> <%}else{ %>
<!--  <label class="value">-</label> --> <% }%>
<div class="Clear"></div>
<label>Relation</label>
<%
				if(dgSampleCollectionHeader.getHin().getRelation() != null){
			%> <label class="value"><%= dgSampleCollectionHeader.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>

</div>

<div class="Clear"></div>
<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgSampleCollectionHeader.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=dgSampleCollectionHeader.getHin().getId() %>" /> <%
	if(dgSampleCollectionHeader.getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgSampleCollectionHeader.getInpatient().getId() %>" /> <%  }else if(dgSampleCollectionHeader.getVisit() != null){ %>
<input type="hidden" name="<%=VISIT_ID %>"
	value="<%=dgSampleCollectionHeader.getVisit().getId() %>" /> <%  } %> <input
	type="hidden" name="<%=HIN_NO %>"
	value="<%=dgSampleCollectionHeader.getHin().getHinNo() %>" /> <input
	type="hidden" name="<%=ORDER_BOOKING_ID %>"
	value="<%=dgSampleCollectionHeader.getOrder().getId()%>" /> <input
	type="hidden" name="sampleCollectionHeaderId"
	value="<%=dgSampleCollectionHeader.getId()%>" /> <input type="hidden"
	name="sampleCollectionHeaderPatientType"
	id="sampleCollectionHeaderPatientType"
	value="<%=dgSampleCollectionHeader.getPatientType()%>" /> <!--Block Two Ends-->
<!--  <div class="division"></div> --> <!-- Block Three Starts --> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<h4>Sample Details</h4>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<h4>Report Details</h4>
<%} %>
<div class="Block">
<% if(deptType.equalsIgnoreCase("DIAG")){ %> <label>Date</label>
<label class="value"><%=date%></label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label>Patient Report date</label> <label class="value"><%=date%></label> <%} %> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<label>Time</label> <label class="value"><%=time%></label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label>Patient Report Time</label> <label
	class="value"><%=time%></label> <%} %> <input type="hidden"
	name="<%=SAMPLE_VALIDATION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_VALIDATION_TIME %>" value="<%=time%>" />

<label><span>*</span> Collected By</label>
<input type="text" name="collectedBy" id="collectedBy" value="<%=dgSampleCollectionHeader.getValidatedBy().getFirstName()%>"/>
<% 
		Users user = (Users)session.getAttribute("users");
%>
<input type="hidden" name="empIdForInvestigation" id="empIdForInvestigation" value="<%=user.getEmployee().getId()%>"/>


<div class="Clear"></div>
<label>Brief Clinical Notes</label> <%if (dgSampleCollectionHeader.getOrder().getClinicalNote() != null){%>
<label class="value"><%=dgSampleCollectionHeader.getOrder().getClinicalNote()%></label>
<%}else{%> <label class="value">-</label> <%}%>



</div>
<%-- <div class="clear"></div>
<% if(deptType.equals("DIAG")){ %>
<label>Diag No.</label>
<input id="diagForAll" type="text" name="diagForAll" value="" size="20"	onchange="" MAXLENGTH="45" tabindex=1 />
<input type="button" class="button" value="Copy"	onclick="fillSameDiagNoInAll();" align="right" />

<label>Rejected Reason</label>
<input	id="rejectedReasonForAll" type="text" name="rejectedReasonForAll"	value="" size="20" onchange="" MAXLENGTH="45" tabindex=1 />

<input type="button" class="button" value="Copy" onclick="fillRejectedReasonInAll();"  />


<%} %> --%>
<div class="clear paddingTop15"></div>
<div class="cmntable">
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sr No.</th>
		<% if(deptType.equals("DIAG")){ %>
		<th scope="col"><span>*</span>Diag No.</th>
		<%}else{ %>
		<th scope="col"><span>*</span>Radio Id.</th>
		<%} %>

		<th scope="col">Test Code</th>
		<th scope="col">Test Name</th>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Sample</th>
		<%} %>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Quantity</th>
		<%} %>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Empanelled Lab</th>
		<%} %>
		<th scope="col">Date&Time</th>
		<th scope="col"><input type="checkbox" name="checkall"	class="radioCheck"  value="Collected All" 	id="addbutton" onclick="CheckAll(this);" align="right" /> Accepted </th>
		<th scope="col"> <input type="checkbox"		name="checkAllRejected" class="radioCheck" value="Rejected All"	id="rejectAllButton" onclick="checkAllReject(this);" align="right" /> Rejected		</th>

		<th scope="col">Reason</th>
		<th scope="col"></th>

		<th scope="col">Additional Remarks</th>
	</tr>

	<%
	int detailCounter=8; 
	int temp=0;
	int inc = 1; 
	int enabledCount =1;
	if(pageNo!=1)
	{
	temp=detailCounter*(pageNo-1);
	} 
%>

	<%
				
				for(DgSampleCollectionDetails dgSampleCollectionDetails : sampleCollectionDtList){
					if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){
						if((dgSampleCollectionDetails.getRejected() != null 
									&& dgSampleCollectionDetails.getRejected().equalsIgnoreCase("n"))){ %>
	<tr>
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td>
		
		<%if(dgSampleCollectionDetails.getDiagNo() !=null){ %> <input
			id="diag<%=inc%>" type="text" name="<%=DIAGNOSIS_NO%>" value="<%=dgSampleCollectionDetails.getDiagNo() %>"
			onchange="" size="20" MAXLENGTH="45" tabindex=1 /> <%}else{ %> <input
			id="diag<%=inc%>" type="text" name="<%=DIAGNOSIS_NO%>" value=""
			size="20" onchange="" MAXLENGTH="45" tabindex=1 /></td>
		<%} %>
		<td>
		<%if(dgSampleCollectionDetails.getChargeCode() !=null){ 
							              System.out.println("dgSampleCollectionDetails.getChargeCode() :"+dgSampleCollectionDetails.getChargeCode().getChargeCodeCode());
							              %> <input name="chargeCode" type="text" size="5"
			style="width: 70px;"
			value="<%=dgSampleCollectionDetails.getChargeCode().getChargeCodeCode() %>"
			readonly /> <%}else { %> <input name="chargeCode" type="text" size="2"
			value="" readonly /> <%} %>
		</td>
		<td>
		<%if(dgSampleCollectionDetails.getChargeCode() !=null){ %> <input
			name="chargename" type="text" size="15"
			value="<%=dgSampleCollectionDetails.getChargeCode().getChargeCodeName() %>"
			readonly /> <%}else { %> <input name="chargename" type="text" sizeh="2"
			value="" readonly /> <%} %>
		</td>
		<%if(dgSampleCollectionDetails.getChargeCode() != null){ %>
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getChargeCode().getId() %>" />
		<%}else{ %>
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>" value="" />
		<%} %>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgSampleCollectionDetails.getSample() !=null){%> <input
			name="<%= SAMPLE_NAME %>" type="text" size="5"
			value="<%=dgSampleCollectionDetails.getSample().getSampleDescription() %>"
			readonly="readonly" /> <%}else { %> <input name="<%= SAMPLE_NAME %>"
			type="text" size="2" value="" readonly="readonly" /></td>
		<%} }%>
		
		
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgSampleCollectionDetails.getQuantity() != null){%> <input
			name="<%= QUANTITY %>" type="text" size="5"
			value="<%=dgSampleCollectionDetails.getQuantity() %>"
			readonly="readonly" /> <%}else { %> <input name="<%= QUANTITY %>"
			type="text" size="2" value="" readonly="readonly" /></td>
		<%} }%>
		
		
		
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgSampleCollectionDetails.getEmpanelledStatus() != null){%> <input
			name="<%= Empanelled %>" type="text" size="5"
			value="<%=dgSampleCollectionDetails.getEmpanelledStatus() %>"
			readonly="readonly" /> <%}else { %> <input name="<%= Empanelled %>"
			type="text" size="2" value="" readonly="readonly" /></td>
		<%} }%>
		
		
			
	 
		
		<% if(dgSampleCollectionDetails.getSample() != null){ %>
		<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getSample().getId() %>" />
		<%}else {%>
		<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc %>"
			value="" />
		<%} %>
		<% if(dgSampleCollectionDetails != null){ %>
		<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
			id="sampleCollectionDetailId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getId() %>" />
		<%}else {%>
		<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
			id="sampleId<%=inc %>" value="" />
		<%} %>


		<td>
		<%if(dgSampleCollectionDetails.getSampleCollDatetime() !=null){%> <input
			type="text" name="<%=DATE%>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionDetails.getSampleCollDatetime())%>"
			size="20" MAXLENGTH="45" tabindex=1 readonly="readonly" /></td>
		<%}else{ %>
		<input type="text" name="<%=DATE%>" value="" size="20" MAXLENGTH="45"
			tabindex=1 readonly="readonly" />
		</td>
		<%} %>



		<td><input type="checkbox" id="acceptedCheck<%=inc %>"
			style="width: 70px;" checked="checked" name="check<%=inc %>" value="y"
			onclick="accepted(this,<%=inc%>);" /></td>
			
			
			
			
		<td><input type="checkbox" id="rejected<%=inc %>"
			name="rejectedCheckBox<%=inc %>" value="y" style="width: 70px;"
			onclick="rejected(this,<%=inc%>);" /></td>

		<td><input id="reason<%=inc%>" type="hidden" name="<%=REASON%>"
			value="" size="20" MAXLENGTH="45" tabindex=1 /></td>
	<td>
		 <div id="modifyOrderDivId<%=inc%>" style="display: none;"><input
			type="button" class="cmnButton" value="Add New Test"
			onclick="submitForAddingNewTest(<%=inc%>);" align="right" /></div>

		</td> 
		<td>
		<% if(dgSampleCollectionDetails.getRemarks() !=null){%> <input
			type="text" name="<%=REMARKS%>"
			value="<%=dgSampleCollectionDetails.getRemarks()%>" MAXLENGTH="50"
			tabindex=1 size="20" /> <%}else { %> <input name="<%= REMARKS %>"
			type="text" value="" MAXLENGTH="50" tabindex=1 size="20" /> <%} %> <input
			type="hidden" name="radioIdValueCheckOnSubmit"
			id="radioIdValueCheckOnSubmit<%=inc%>" value="correctRadioId" /></td>

	</tr>

	<%enabledCount++;	}else{ %>
	<tr>
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
			name="<%=SR_NO%>" disabled="disabled" readonly="readonly" /></td>
		<td>
		<%if(dgSampleCollectionDetails.getDiagNo() !=null){ %> <input
			id="diag<%=inc%>" type="text" name="<%=DIAGNOSIS_NO%>" value=""
			disabled="disabled" onchange="" size="20" MAXLENGTH="45" tabindex=1 />
		<input id="diag<%=inc%>" type="hidden" name="<%=DIAGNOSIS_NO%>"
			value="" onchange="" size="20" MAXLENGTH="45" tabindex=1 /> <%}else{ %>
		<input id="diag<%=inc%>" type="text" name="<%=DIAGNOSIS_NO%>" value=""
			disabled="disabled" size="20" onchange="" MAXLENGTH="45" tabindex=1 /></td>
		<input id="diag<%=inc%>" type="hidden" name="<%=DIAGNOSIS_NO%>"
			value="" onchange="" size="20" MAXLENGTH="45" tabindex=1 />

		<%} %>
		<td>
		<%if(dgSampleCollectionDetails.getChargeCode() !=null){ 
						              System.out.println("dgSampleCollectionDetails.getChargeCode() :"+dgSampleCollectionDetails.getChargeCode().getChargeCodeCode());
						              %> <input name="chargeCode" type="text" size="5"
			style="width: 70px;" disabled="disabled"
			value="<%=dgSampleCollectionDetails.getChargeCode().getChargeCodeCode() %>"
			readonly /> <%}else { %> <input name="chargeCode" type="text" size="2"
			value="" disabled="disabled" readonly /> <%} %>
		</td>
		<td>
		<%if(dgSampleCollectionDetails.getChargeCode() !=null){ %> <input
			name="chargename" type="text" size="15" disabled="disabled"
			value="<%=dgSampleCollectionDetails.getChargeCode().getChargeCodeName() %>"
			readonly /> <%}else { %> <input name="chargename" type="text" sizeh="2"
			value="" disabled="disabled" readonly /> <%} %>
		</td>
		<%if(dgSampleCollectionDetails.getChargeCode() != null){ %>
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getChargeCode().getId() %>" />
		<%}else{ %>
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>" value="" />
		<%} %>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgSampleCollectionDetails.getSample() !=null){%> <input
			name="<%= SAMPLE_NAME %>" type="text" size="5" disabled="disabled"
			value="<%=dgSampleCollectionDetails.getSample().getSampleDescription() %>"
			readonly="readonly" /> <input name="<%= SAMPLE_NAME %>" type="hidden"
			size="5"
			value="<%=dgSampleCollectionDetails.getSample().getSampleDescription() %>"
			readonly="readonly" /> <%}else { %> <input name="<%= SAMPLE_NAME %>"
			type="text" size="2" disabled="disabled" value="" readonly="readonly" />
		<input name="<%= SAMPLE_NAME %>" type="hidden" size="5" value=""
			readonly="readonly" /></td>
		<%} }%>
		<% if(deptType.equalsIgnoreCase("DIAG")){ %>
		<td>
		<%if(dgSampleCollectionDetails.getQuantity() != null){%> <input
			name="<%= QUANTITY %>" type="text" size="5" disabled="disabled"
			value="<%=dgSampleCollectionDetails.getQuantity() %>"
			readonly="readonly" /> <input name="<%= QUANTITY %>" type="hidden"
			size="5" value="<%=dgSampleCollectionDetails.getQuantity() %>"
			readonly="readonly" /> <%}else { %> <input name="<%= QUANTITY %>"
			type="text" size="2" disabled="disabled" value="" readonly="readonly" />
		<input name="<%= QUANTITY %>" type="hidden" size="5" value=""
			readonly="readonly" /></td>
		<%}  }%>

		<% if(dgSampleCollectionDetails.getSample() != null){ %>
		<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getSample().getId() %>" />
		<%}else {%>
		<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc %>"
			value="" />
		<%} %>
		<% if(dgSampleCollectionDetails != null){ %>
		<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
			id="sampleCollectionDetailId<%=inc %>"
			value="<%=dgSampleCollectionDetails.getId() %>" />
		<%}else {%>
		<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
			id="sampleId<%=inc %>" value="" />
		<%} %>


		<td>
		<%if(dgSampleCollectionDetails.getSampleCollDatetime() !=null){%> <input
			type="text" name="<%=DATE%>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionDetails.getSampleCollDatetime())%>"
			disabled="disabled" size="20" MAXLENGTH="45" tabindex=1
			readonly="readonly" /></td>
		<input type="hidden" name="<%=DATE%>"
			value="<%=dgSampleCollectionDetails.getSampleCollDatetime()%>"
			disabled="disabled" size="20" MAXLENGTH="45" tabindex=1
			readonly="readonly" />
		</td>
		<%}else{ %>
		<input type="text" name="<%=DATE%>" value="" size="20" MAXLENGTH="45"
			disabled="disabled" tabindex=1 readonly="readonly" />
		</td>
		<input type="hidden" name="<%=DATE%>" value="" size="20"
			MAXLENGTH="45" tabindex=1 readonly="readonly" />
		</td>
		<%} %>



		<td><input type="checkbox" id="acceptedCheck<%=inc %>"
			style="width: 70px;" disabled="disabled" name="check<%=inc %>"
			value="y" onclick="accepted(this,<%=inc%>);"/></td>
		<td><input type="checkbox" id="rejected<%=inc %>"
			name="rejectedCheckBox<%=inc %>" checked="checked"
			disabled="disabled" value="y" 
			onclick="rejected(this,<%=inc%>);" /></td>

		<td><input id="reason<%=inc%>" type="text" name="<%=REASON%>"
			disabled="disabled"
			value="<%=dgSampleCollectionDetails.getReason()%>" size="20"
			MAXLENGTH="45" tabindex=1 /> <input id="reason<%=inc%>"
			type="hidden" name="<%=REASON%>"
			value="<%=dgSampleCollectionDetails.getReason()%>" size="20"
			MAXLENGTH="45" tabindex=1 /></td>
		<td>
		<div id="modifyOrderDivId<%=inc%>" style="display: none;"><input
			type="button" class="button" value="Add New Test"
			onclick="submitForAddingNewTest(<%=inc%>);" align="right" /></div>
		</td>
		<td>
		<% if(dgSampleCollectionDetails.getRemarks() !=null){%>
		<input	type="text" name="<%=REMARKS%>"	value="<%=dgSampleCollectionDetails.getRemarks()%>"	disabled="disabled" MAXLENGTH="50" tabindex=1 size="20" />
		<input	name="<%= REMARKS %>" type="hidden"	value="<%=dgSampleCollectionDetails.getRemarks()%>" MAXLENGTH="50"	tabindex=1 size="20" /> <%}else { %> <input name="<%= REMARKS %>" type="text" value="" MAXLENGTH="50" disabled="disabled" tabindex=1	size="20" />
		<input name="<%= REMARKS %>" type="hidden" value=""	MAXLENGTH="50" tabindex=1 size="20" /> <%} %>
		<input type="hidden"	name="radioIdValueCheckOnSubmit"	id="radioIdValueCheckOnSubmit<%=inc%>" value="correctRadioId" />
		</td>

	</tr>

	<%		}
			%>

	<% inc++;
				} }%>
	<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
</table>
</div>

<!-- Table Ends --> <!--Bottom labels starts-->

<div class="Clear"></div>
<div class="division"></div>
<input type="hidden" name="counter1" id="counter1" value="<%=inc %>" />
<input type="hidden" name="combinedIds" id="combinedIds"
	value="<%=combinedIds%>" /> <input type="hidden" name="counter2"
	id="counter2" value="<%=inc %>" />
	
<input type="button"	name="submitForDisable" id="submitForDisable" class="button"	value="Submit"	onclick="submitFormToDisableSubmit('sampleAcceptance','lab?method=submitSampleAcceptanceLab','validateSampleValidation','checkRadioId');"	align="right" />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="back" id="back" value="Back"	class="button" onclick="goBack();" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed Buy</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
</div>
<div class="Clear paddingTop40"></div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
<script>
document.getElementById("submitForDisable").focus();
</script>
</form>

