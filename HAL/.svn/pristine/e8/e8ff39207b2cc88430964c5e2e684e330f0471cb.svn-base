<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.ComparatorForId"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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
	  			document.getElementById("rejected"+i).checked =false;
	  			document.getElementById("reason"+i).value="";
	 			document.getElementById("reason"+i).type="hidden";
	 			document.getElementById("modifyOrderDivId"+i).style.display='none';
	 			//var rejectedTextField = document.getElementById("reason"+i);
				//rejectedTextField.setAttribute('validate','Reason,string,no');
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
	  		if(document.getElementById('rejected'+i).checked == true){
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
	 	//document.getElementById("reason"+inc).style.display='none';
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
	  		}
	 	}
	 	if(!chkObj.checked){
	 		if(chkObj.id == "rejected"+inc){
	 			document.getElementById("reason"+inc).value="";
		 		document.getElementById("reason"+inc).type="hidden";
		 		document.getElementById("reason"+inc).readOnly=true;
		 		document.getElementById("modifyOrderDivId"+inc).style.display='none';
		 		
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
	
	List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	String date1 = (String)utilMap.get("dateTime");

	String userName = "";
	String deptType = "";
	String deptName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	DgSampleCollectionHeader dgSampleCollectionHeader= new DgSampleCollectionHeader();
	int hinId= 0;
	try{
		if(map.get("samplehdList") != null){
			samplehdList=(List)map.get("samplehdList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	if(samplehdList != null)
	   {
		dgSampleCollectionHeader = (DgSampleCollectionHeader) samplehdList.get(0);
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
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	
	
	Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = new HashSet<DgSampleCollectionDetails>();
	dgSampleCollectionDetailsSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
%> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<h6>Sample validation</h6>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<h6>Acceptance for Radiological Investigations</h6>
<%} %> <!--main content placeholder starts here-->
<div id="contentHolder">

<div class="Clear"></div>
<div class="header" style="margin: 0px 0px 3px 0px;">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgSampleCollectionHeader.getOrder().getOrderDate())%></label>
<label class="NoWidth">Order Time</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getOrderTime()%></label>
<label class="NoWidth">Order No.</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getOrderNo()%></label>
<label class="NoWidth">Order By</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName()%></label>
</div>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame" style="margin: 0px 0px 3px 0px;">
<div class="Clear"></div>
<label class="NoWidth"
	style="padding-left: 10px; width: 118px; float: left; text-align: left;">Service
Type</label> <%
				if(dgSampleCollectionHeader.getHin().getServiceType() != null){
			   %> <label class="value" style="width: 140px;"><%= dgSampleCollectionHeader.getHin().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label class="NoWidth">Service
No</label> <%
				if(dgSampleCollectionHeader.getHin().getServiceNo() != null && !(dgSampleCollectionHeader.getHin().getServiceNo().equals(""))){
			  %> <label class="value"><%= dgSampleCollectionHeader.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label class="NoWidth">Service
Status</label> <%if(dgSampleCollectionHeader.getHin().getServiceStatus() != null){
			%> <label class="value"><%= dgSampleCollectionHeader.getHin().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label class="NoWidth">Relation</label>
<%
				if(dgSampleCollectionHeader.getHin().getRelation() != null){
			%> <label class="value"><%= dgSampleCollectionHeader.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>
<label class="NoWidth" style="padding-left: 10px;">ServicePerson
Name</label> <%
				if(dgSampleCollectionHeader.getHin().getSFirstName() != null  && !(dgSampleCollectionHeader.getHin().getSFirstName().equals(""))){
					String sMiddleName = "";
					String sLastName = "";
					if(dgSampleCollectionHeader.getHin().getSMiddleName() != null){
						sMiddleName = dgSampleCollectionHeader.getHin().getSMiddleName();
					}
					if(dgSampleCollectionHeader.getHin().getSLastName() != null){
						sLastName = dgSampleCollectionHeader.getHin().getSLastName();
					}
			 %> <label class="value" style="width: 139px;"><%= dgSampleCollectionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label class="NoWidth"
	style="padding-left: 0px; text-align: left; float: left; width: 60px;">Rank</label>
<%
			if(dgSampleCollectionHeader.getHin().getRank() != null){
			%> <label class="value"><%= dgSampleCollectionHeader.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%> <label class="NoWidth"
	style="width: 85px; float: left; text-align: left;">Unit</label> <%
				if(dgSampleCollectionHeader.getHin().getUnit() != null){
			%> <label class="value" style="width: auto;"><%=dgSampleCollectionHeader.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <% }%>
</div>
<!--Block one Ends--> <!--  <div class="division"></div> --> <!--Block Two Starts-->
<div class="Clear"></div>
<div
	style="width: 0px; height: 20px; float: left; padding-left: 0px; margin: : 0px 0px 0px 0px;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left; padding-left: 0px; margin: : 0px 0px 0px 0px;">
<div onClick="togPlus('visit-details-box1',expand_bca1);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca1
	alt=Expand src="/hms/jsp/images/plus1.gif" ;  align=left
	style="padding-left: 0px;" /> <font class="boxtitle">Patient
Details </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>

<div class="Clear"></div>
<div class=box-content id=visit-details-box1 style="display: none;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 30px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;"><label class="NoWidth"
	style="padding-left: 10px;">HIN No.</label> <label class="value"><%=dgSampleCollectionHeader.getHin().getHinNo() %></label>

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

<label class="NoWidth">Sex</label> <%if(dgSampleCollectionHeader.getHin().getSex() != null){ %>
<label class="value"><%=dgSampleCollectionHeader.getHin().getSex().getAdministrativeSexName() %></label>
<%} %> <%
			String age = "";
			String currentAge = "";
			age = dgSampleCollectionHeader.getHin().getAge();
		    currentAge = HMSUtil.calculateAgeForADT(age, dgSampleCollectionHeader.getHin().getRegDate());
		%> <label class="NoWidth">Age</label> <%if (currentAge != null) {%> <label
	class="value"><%=currentAge%></label> <%}else{ %> <label class="value">-</label>
<%} %> <!-- 	<label class="NoWidth">Marital Status</label> --> <%
					String maritalStatus = "";
				    if(dgSampleCollectionHeader.getHin().getMaritalStatus() != null){
					maritalStatus = dgSampleCollectionHeader.getHin().getMaritalStatus().getMaritalStatusName();
				%> <!--  <label class="value"><%=maritalStatus%></label> --> <%}else{ %>
<!--  <label class="value">-</label> --> <% }%>
</div>
</div>
</div>
</div>
<div class="Clear"></div>
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
<div class="blockTitle">Sample Details</div>
<div class="blockTitleCurve"></div>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<div class="blockTitle">Report Details</div>
<div class="blockTitleCurve"></div>
<%} %>
<div class="Clear"></div>
<div class="blockFrame" style="margin: 0px 0px 3px 0px;">
<div class="Clear"></div>
<% if(deptType.equalsIgnoreCase("DIAG")){ %> <label class="noWidth"
	style="padding-left: 4px;">&nbsp;&nbsp;SampleValidation Date</label> <label
	class="valueNoWidth"><%=date%></label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label class="noWidth">&nbsp;&nbsp;Patient Report date</label> <label
	class="valueNoWidth"><%=date%></label> <%} %> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth" style="width: 188px;">SampleValidation
Time</label> <label class="valueNoWidth"><%=time%></label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label class="noWidth">&nbsp;&nbsp;Patient Report Time</label> <label
	class="valueNoWidth"><%=time%></label> <%} %> <input type="hidden"
	name="<%=SAMPLE_VALIDATION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_VALIDATION_TIME %>" value="<%=time%>" />

<label class="noWidth"><span>*</span>Investigation Accepted By</label>
<select name="<%= EMPLOYEE_ID %>" id="empIdForInvestigation"
	class="large" style="margin: 0px 0px 0px 0px;"
	validate="Investigation Accepted By,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
		Users user = (Users)session.getAttribute("users");
		//Integer empId =user.getEmployee().getId();
		for (MasEmployee  obj : employeeCodeList){
			
		//if(obj.getEmpCategory() != null){
		//	if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) ){
					String doctorMiddleName = "";
					String doctorLastName = "";
					if(obj.getMiddleName()!=null){
						doctorMiddleName = obj.getMiddleName();	
					}
					if(obj.getLastName()!=null){
						doctorLastName = obj.getLastName();						
					}
					System.out.println("ID :"+obj.getId());
	//   			if(empId.equals(obj.getId())){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%	 }%>
</select> <script type="text/javascript">
		document.getElementById('empIdForInvestigation').value='<%=user.getEmployee().getId()%>';
	</script>
<div class="Clear"></div>
<label class="noWidth"
	style="padding-left: 10px; margin-left: 0px; text-align: left;">Brief
Clinical Notes</label> <%if (dgSampleCollectionHeader.getOrder().getClinicalNote() != null){%>
<label class="valueNoWidth"><%=dgSampleCollectionHeader.getOrder().getClinicalNote()%></label>
<%}else{%> <label class="valueNoWidth">-</label> <%}%>
</div>
<% if(deptType.equals("DIAG")){ %> <label
	style="padding-left: 12px; margin-left: 0px; float: left; text-align: left; width: 50px;">Diag
No</label> <input
	style="padding-left: 0px; margin-left: 0px; float: left; text-align: left;"
	id="diagForAll" type="text" name="diagForAll" value="" size="20"
	onchange="" MAXLENGTH="45" tabindex=1 />
</td>
<input type="button" class="cmnButton" value="Copy"
	onclick="fillSameDiagNoInAll();" align="right" />

<div style="float: right;"><label
	style="padding-left: 12px; margin-left: 0px; text-align: left; width: auto;">Rejected
Reason</label> <input
	style="padding-left: 0px; margin-left: 0px; text-align: left;"
	id="rejectedReasonForAll" type="text" name="rejectedReasonForAll"
	value="" size="20" onchange="" MAXLENGTH="45" tabindex=1 />
</td>
<input type="button" class="cmnButton" value="Copy"
	onclick="fillRejectedReasonInAll();" align="right" /></div>

<%} %>
<div class="tableHholderCmnLarge"
	style="height: 150px; margin: 0px 0px 0px 0px; width: 100%;">
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
		<th scope="col">Date&Time</th>
		<th scope="col">Accepted <input type="checkbox" name="checkall"
			class="check" style="margin: 0px 0px 0px 0px;" value="Collected All"
			id="addbutton" onclick="CheckAll(this);" align="right" /></th>
		<th scope="col">Rejected <input type="checkbox"
			name="checkAllRejected" class="check"
			style="margin: 0px 0px 0px 0px;" value="Rejected All"
			id="rejectAllButton" onclick="checkAllReject(this);" align="right" />
		</th>

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
				Set<DgSampleCollectionDetails>  orderedSet = ComparatorForId.getApplicationTreeSet(); 
				orderedSet.addAll(dgSampleCollectionDetailsSet);
				
				for(DgSampleCollectionDetails dgSampleCollectionDetails : orderedSet){
					if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){
						if((dgSampleCollectionDetails.getRejected() != null 
									&& dgSampleCollectionDetails.getRejected().equalsIgnoreCase("n"))){ %>
	<tr>
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td>
		<%if(dgSampleCollectionDetails.getDiagNo() !=null){ %> <input
			id="diag<%=inc%>" type="text" name="<%=DIAGNOSIS_NO%>" value=""
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
			value="<%=dgSampleCollectionDetails.getSampleCollDatetime()%>"
			size="20" MAXLENGTH="45" tabindex=1 readonly="readonly" /></td>
		<%}else{ %>
		<input type="text" name="<%=DATE%>" value="" size="20" MAXLENGTH="45"
			tabindex=1 readonly="readonly" />
		</td>
		<%} %>



		<td><input type="checkbox" id="acceptedCheck<%=inc %>"
			style="width: 70px;" name="check<%=inc %>" value="y"
			onclick="accepted(this,<%=inc%>);" /></td>
		<td><input type="checkbox" id="rejected<%=inc %>"
			name="check1<%=inc %>" value="y" style="width: 70px;"
			onclick="rejected(this,<%=inc%>);" /></td>

		<td><input id="reason<%=inc%>" type="hidden" name="<%=REASON%>"
			value="" size="40" MAXLENGTH="45" tabindex=1 /></td>
		<td>
		<div id="modifyOrderDivId<%=inc%>" style="display: none;"><input
			type="button" class="cmnButton" value="Add New Test"
			onclick="submitForAddingNewTest(<%=inc%>);" align="right" /></div>

		</td>
		<td>
		<% if(dgSampleCollectionDetails.getRemarks() !=null){%> <input
			type="text" name="<%=REMARKS%>"
			value="<%=dgSampleCollectionDetails.getRemarks()%>" MAXLENGTH="50"
			tabindex=1 size="40" /> <%}else { %> <input name="<%= REMARKS %>"
			type="text" value="" MAXLENGTH="50" tabindex=1 size="40" /> <%} %> <input
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
			value="<%=dgSampleCollectionDetails.getSampleCollDatetime()%>"
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
			value="y" onclick="accepted(this,<%=inc%>);" /></td>
		<td><input type="checkbox" id="rejected<%=inc %>"
			name="check1<%=inc %>" checked="checked" disabled="disabled"
			value="y" style="width: 70px;" onclick="rejected(this,<%=inc%>);" /></td>

		<td><input id="reason<%=inc%>" type="text" name="<%=REASON%>"
			disabled="disabled"
			value="<%=dgSampleCollectionDetails.getReason()%>" size="40"
			MAXLENGTH="45" tabindex=1 /> <input id="reason<%=inc%>"
			type="hidden" name="<%=REASON%>"
			value="<%=dgSampleCollectionDetails.getReason()%>" size="40"
			MAXLENGTH="45" tabindex=1 /></td>
		<td>
		<div id="modifyOrderDivId<%=inc%>" style="display: none;"><input
			type="button" class="cmnButton" value="Add New Test"
			onclick="submitForAddingNewTest(<%=inc%>);" align="right" /></div>
		</td>
		<td>
		<% if(dgSampleCollectionDetails.getRemarks() !=null){%> <input
			type="text" name="<%=REMARKS%>"
			value="<%=dgSampleCollectionDetails.getRemarks()%>"
			disabled="disabled" MAXLENGTH="50" tabindex=1 size="40" /> <input
			name="<%= REMARKS %>" type="hidden"
			value="<%=dgSampleCollectionDetails.getRemarks()%>" MAXLENGTH="50"
			tabindex=1 size="40" /> <%}else { %> <input name="<%= REMARKS %>"
			type="text" value="" MAXLENGTH="50" disabled="disabled" tabindex=1
			size="40" /> <input name="<%= REMARKS %>" type="hidden" value=""
			MAXLENGTH="50" tabindex=1 size="40" /> <%} %> <input type="hidden"
			name="radioIdValueCheckOnSubmit"
			id="radioIdValueCheckOnSubmit<%=inc%>" value="correctRadioId" /></td>

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
<input type="hidden" name="counter1" id="counter1" value="<%=inc %>" />
<input type="hidden" name="counter2" id="counter2" value="<%=inc %>" />
<input type="button" class="cmnButton" value="Submit"
	onclick="submitForm('sampleAcceptance','lab?method=submitSampleAcceptance','validateSampleValidation','checkRadioId');"
	align="right" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="cmnButton" onclick="resetCheck();" accesskey="r" />
<input type="button" name="back" id="back" value="Back"
	class="cmnButton" onclick="history.back();" accesskey="r" />
<div class="Clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
</form>

