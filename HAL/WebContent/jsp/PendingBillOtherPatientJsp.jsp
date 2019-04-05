<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="billServicingOpSearch" method="post" onload="form.reset();">

	<%
Map<String,Object> map = new HashMap<String,Object>();
List<Patient> patientList=new ArrayList<Patient>();



if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTimeWithoutSc");
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
	
	}
List<OpdPatientDetails> patientDetailList = new ArrayList<OpdPatientDetails>();
if(map.get("patientDetailList") != null){
	patientDetailList= (List<OpdPatientDetails>)map.get("patientDetailList");
}
if(map.get("patientList") != null){
	patientList= (List<Patient>)map.get("patientList");
}

%>
	<%
	if(map.get("inpatientList") != null){
%>
	<script type="text/javascript">
	displayAlert("Patient is admitted.");
</script>
	<%		
	}
%>
	<h4><%=message %></h4>
	<div class="titleBg">
		<h2>Billing of other patients</h2>
	</div>
	<div class="clear"></div>
	<div class="Block" style="display:none">
		<div id="searcharea">
			<div id="searchbar">
				
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>

	<div class="Block" style="display:none">
	
		<label>Reg. NO</label> <input type="text" id="searchField"
			name="<%=HIN_NO %>" value="" validate="UHID,alphanumeric,no"
			onblur="" maxlength="30" tabindex=1 /> <label>Patient Name</label> <input
			type="text" id="pName" name="pName" value=""
			validate="Patient Name,alphanumeric,no" onblur="" maxlength="30"
			tabindex=1 /> <label>Mobile Number</label> <input type="text"
			id="mobile" name="mobile" value="" validate="Mobile Number,number,no"
			onblur="" maxlength="30" tabindex=1 />

		<div class="clear"></div>

		<div class="clear"></div>

		<div class="division"></div>
		<div class="clear"></div>
		<input type="button" class="button" name="save" value="Search"
			onclick="submitForm('billServicingOpSearch','billing?method=showPendingBillServicingJsp','checkHinValue');"
			align="right" /> <input type="reset" class="button" value="Reset" />
		<div class="clear"></div>
	</div>
	<div class="division"></div>

	<div class="clear"></div>

	<%
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
%>

	<h4><%=msg %></h4>
	<script type="text/javascript">
	function checkHinValue(){
		if(document.getElementById('searchField').value == "" && document.getElementById('pName').value == ""  && document.getElementById('mobile').value == ""){
				alert("Please enter either UHID or Patient Name or Mobile Number");
			return false;
		}else{
			return true
		}
	
	}

document.getElementById('searchField').focus();

</script>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
</form>


<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="OtherPatientBillStatus" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<div id="searchresults" tabindex=2>
		<div id="searchtable" tabindex=2></div>
		<script type="text/javascript">
	/* formFields = [
			[0, "hinId", "id"],[1,"hinNo"],[2,"hinNo"], [3,"patientName"], [4,"referBy"], [5,"hospitalName"],[6,"dgOrderHdId"]]; */
			formFields = [
			  			[0, "hinId", "id"], [1, "regDate"],[2,"hinNo"],[3,"patientName"], [4,"referBy"], [5,"age"], [6,"gender"],[7,"contactNo"]];
	 statusTd = 2;
	</script>
	</div>
	<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Registration Date"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "regDate";
	
	data_header[1] = new Array;
	data_header[1][0] = "Reg. No."
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hinNo";	
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patientName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Referred By"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "referBy";
		
	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "age";

	data_header[5] = new Array;
	data_header[5][0] = "Gender"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "gender";
	
	data_header[6] = new Array;
	data_header[6][0] = "Contact No"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "contactNo";

	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { 
	 	for(Patient patient : patientList){
	 		//if(patientDetails.getReferredDoctor() !=null){
	 			String approvedBy= "";
	 			String regDate= "";
	 			String mRefBy="";	
	 			String lRefBy="";
	 			String age="";
	 			String gender="";
	 			
				String patientName="";
				String mPatName="";	
				String lPatName="";
				
				String refTo=""; String 
				lrefTo="";
				age=patient.getAge()!=null?patient.getAge():"";
				gender=patient.getAge()!=null?patient.getSex().getAdministrativeSexName():"";
				patientName=patient.getPFirstName();
				if(patient.getPMiddleName() !=null){
					mPatName=patient.getPMiddleName();}
				if(patient.getPLastName() !=null){
					lPatName=patient.getPLastName();}
				patientName=patientName+" "+mPatName+" "+lPatName;
				
				if(patient.getApprovedBy()!=null)
				{
					approvedBy=patient.getApprovedBy().getFirstName();
				if(patient.getApprovedBy().getMiddleName() !=null){
					mRefBy=patient.getApprovedBy().getMiddleName();}
				if(patient.getApprovedBy().getLastName() !=null){
				lRefBy=patient.getApprovedBy().getLastName();}
				approvedBy=approvedBy+" "+mRefBy+" "+lRefBy;
				}
				/* System.out.println("registration Date------->"+HMSUtil.convertDateToStringWithoutTime(patient.getRegDate())); */
					%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] =<%= patient.getId()%> 
			data_arr[<%= counter%>][1] ='<%=patient.getRegDate()!=null?HMSUtil.convertDateToStringWithoutTime(patient.getRegDate()):""%>' 
		
			data_arr[<%= counter%>][2] = '<%=patient.getHinNo()!=null?patient.getHinNo():""%>'
			data_arr[<%= counter%>][3] = '<%=patientName%>'
			data_arr[<%= counter%>][4] = '<%=approvedBy%>'
			data_arr[<%= counter%>][5] = '<%=age%>'
			data_arr[<%= counter%>][6] = '<%=gender%>'
			data_arr[<%= counter%>][7] = '<%=patient.getMobileNumber()!=null?patient.getMobileNumber():""%>'
	
<%
			counter++;
			//}
	 	}
		}
		%>
	formName = "OtherPatientBillStatus"

	start = 0
	if (data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start, end);
	//makeTable(start,end);
	intializeHover('searchresulttable', 'TR', ' tableover');
</script>