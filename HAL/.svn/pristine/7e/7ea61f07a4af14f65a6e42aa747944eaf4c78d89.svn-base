<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="billServicingOpSearch" method="post" onload="form.reset();">

<%
Map<String,Object> map = new HashMap<String,Object>();
List<DgOrderhd> dgOrderhdList=new ArrayList<DgOrderhd>();



if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
	
	}
List<OpdPatientDetails> patientDetailList = new ArrayList<OpdPatientDetails>();
if(map.get("patientDetailList") != null){
	patientDetailList= (List<OpdPatientDetails>)map.get("patientDetailList");
}
if(map.get("dgOrderhdList") != null){
	dgOrderhdList= (List<DgOrderhd>)map.get("dgOrderhdList");
}

%> <%
	if(map.get("inpatientList") != null){
%> <script type="text/javascript">
	displayAlert("Patient is admitted.");
</script> <%		
	}
%>
<h4><%=message %></h4>
<div class="titleBg">
<h2>Bill Servicing</h2>
</div>
<div class="clear"></div>
 <div class="Block">
<div id="searcharea">
<div id="searchbar"><!-- <label>Registered</label>
<input type="radio"	name="" value="1" checked="checked" class="radioCheck"/>
<label>Un-Registered</label>
<input type="radio" name="" value="2" class="radioCheck"
onclick="submitForm('billServicingOpSearch','billing?method=getPatientDetailsForOpBilling&registered=no');"/>  -->
<div class="clear"></div></div>
</div>
<div class="clear"></div>
</div>

<div class="Block">
<%-- <label>HIN</label> <input type="text"
	id="searchField" name="<%=HIN_NO %>" value="" validate="HIN,string,no"
	onblur="if(this.value != ''){submitProtoAjax('billServicingOpSearch','opBilling?method=getOrderNoTempBillNoForBilling&registered=yes');}"
	maxlength="30" tabindex=1 />
 <div id="testDiv"><label>Order No.</label>
<input type="text" id="orderNoId" name="<%=ORDER_NO %>" value=""
	validate="Order no,string,no" maxlength="30" tabindex=1 onblur="disableFields(this)" /> 
<label>Temporary Bill No.</label> 
<input type="text" id="tempBillNoId" name="tempBillNo" value=""
	validate="Temporary Bill No,string,no" maxlength="30" tabindex=1
	onblur="disableFields(this);submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');" />

</div>  --%>
<label>Reg. No</label> <input type="text"
	id="searchField" name="<%=HIN_NO %>" value="" validate="UHID,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
<label>Patient Name</label> <input type="text"
	id="pName" name="pName" value="" validate="Patient Name,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
	
	<!-- <label>Mobile Number</label> <input type="text"
	id="mobile" name="mobile" value="" validate="Mobile Number,number,no"
	onblur=""
	maxlength="30" tabindex=1 /> -->
	
<div class="clear"></div>

<div class="clear"></div>
	
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="save" value="Search" onclick="submitForm('billServicingOpSearch','billing?method=showPendingBillServicingJsp','checkHinValue');" align="right" />
<input type="reset" class="button"  value="Reset"/>
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
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%-- <jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="opdPatientBillStatus" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
	<script type="text/javascript">
	formFields = [
			[0, "hinId", "id"],[1,"hinNo"], [2,"patientName"], [3,"referBy"], [4,"ReferTo"],[5,"RefByDept"],[6,"refToDept"]];
	 statusTd = 6;
	</script>
	</div>
	
	</form>
	<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "HIN"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hinNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "patientName";
	
	data_header[2] = new Array;
	data_header[2][0] = "Referred By"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "referBy";
		
	data_header[3] = new Array;
	data_header[3][0] = "Referred To"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "ReferTo";

	data_header[4] = new Array;
	data_header[4][0] = "Referred By Dept"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "RefByDept";

	data_header[5] = new Array;
	data_header[5][0] = "Referred To Dept"
	data_header[5][1] = "hide";
	data_header[5][2] = "30%";
	data_header[5][3] = "RefToDept";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientDetailList != null && patientDetailList.size() > 0) { 
	 	for(OpdPatientDetails patientDetails : patientDetailList){
	 		//if(patientDetails.getReferredDoctor() !=null){
	 			String referBy="";String mRefBy="";	String lRefBy="";
				String patientName="";String mPatName="";	String lPatName="";
				String refTo=""; String lrefTo="";
				patientName=patientDetails.getVisit().getHin().getPFirstName();
				if(patientDetails.getVisit().getHin().getPMiddleName() !=null){
					mPatName=patientDetails.getVisit().getHin().getPMiddleName();}
				if(patientDetails.getVisit().getHin().getPLastName() !=null){
					lPatName=patientDetails.getVisit().getHin().getPLastName();}
				patientName=patientName+" "+mPatName+" "+lPatName;
				
				referBy=patientDetails.getVisit().getDoctor().getFirstName();
				if(patientDetails.getVisit().getDoctor().getMiddleName() !=null){
					mRefBy=patientDetails.getVisit().getDoctor().getMiddleName();}
				if(patientDetails.getVisit().getDoctor().getLastName() !=null){
				lRefBy=patientDetails.getVisit().getDoctor().getLastName();}
				referBy=referBy+" "+mRefBy+" "+lRefBy;
				
			if(patientDetails.getReferredDoctor() !=null){
			refTo=patientDetails.getReferredDoctor().getFirstName();
			if(patientDetails.getReferredDoctor().getLastName() !=null){
				lrefTo=patientDetails.getReferredDoctor().getLastName();}
		    	refTo=refTo+" "+lrefTo;
		    	}else{
		    		refTo="-";
		    	}
			%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patientDetails.getVisit().getHin().getId()%>
			data_arr[<%= counter%>][1] = "<%=patientDetails.getVisit().getHin().getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%=patientName%> "
			data_arr[<%= counter%>][3] = "<%=referBy%>"
			data_arr[<%= counter%>][4] = "<%=refTo%>"
				<%if(patientDetails.getVisit().getDepartment() !=null){%>
			data_arr[<%= counter%>][5] = "<%=patientDetails.getVisit().getDepartment().getDepartmentName()%>"
				<%}%>
				<%if(patientDetails.getReferredDept() !=null){%>
			data_arr[<%= counter%>][6] = "<%=patientDetails.getReferredDept()%> "<%}%>
			<%
			counter++;
			//}
	 	}
		}
		%>
		formName = "opdPatientBillStatus"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
		makeGridForPatient(start,end);
		//makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');  
</script> --%>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="opdPatientBillStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2></div>
	<script type="text/javascript">
	formFields = [
			[0, "hinId", "id"],[1,"TokenNo"],[2,"hinNo"], [3,"patientName"], [4,"referBy"], [5,"hospitalName"],[6,"dgOrderHdId"]];
	 statusTd = 6;
	</script>
	</div>
	
	</form>
	<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Token No.<b>&nbsp;/&nbsp;</b>Queue No."
	data_header[0][1] = "hide";
	data_header[0][2] = "15%";
	data_header[0][3] = "TokenNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "HIN No."
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hinNo";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "patientName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Referred By"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "referBy";
		
	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "age";

	data_header[5] = new Array;
	data_header[5][0] = "Order ID"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "dgOrderHdId";

	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) { 
	 	for(DgOrderhd dgOrderhd : dgOrderhdList){
	 		//if(patientDetails.getReferredDoctor() !=null){
	 			String referBy="";
	 			String mRefBy="";	
	 			String lRefBy="";
	 			String age="";
	 			String gender="";
	 			
				String patientName="";
				String mPatName="";	
				String lPatName="";
				
				String refTo=""; String 
				lrefTo="";
				age=dgOrderhd.getVisit().getHin().getAge();
				gender=dgOrderhd.getVisit().getHin().getSex().getAdministrativeSexName();
				patientName=dgOrderhd.getVisit().getHin().getPFirstName();
				if(dgOrderhd.getVisit().getHin().getPMiddleName() !=null){
					mPatName=dgOrderhd.getVisit().getHin().getPMiddleName();}
				if(dgOrderhd.getVisit().getHin().getPLastName() !=null){
					lPatName=dgOrderhd.getVisit().getHin().getPLastName();}
				patientName=patientName+" "+mPatName+" "+lPatName;
				
				if(dgOrderhd.getVisit().getDoctor()!=null)
				{
				referBy=dgOrderhd.getVisit().getDoctor().getFirstName();
				if(dgOrderhd.getVisit().getDoctor().getMiddleName() !=null){
					mRefBy=dgOrderhd.getVisit().getDoctor().getMiddleName();}
				if(dgOrderhd.getVisit().getDoctor().getLastName() !=null){
				lRefBy=dgOrderhd.getVisit().getDoctor().getLastName();}
				referBy=referBy+" "+mRefBy+" "+lRefBy;
				}
				
					%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] =<%= dgOrderhd.getVisit().getHin().getId()%> 
			<%
			if(dgOrderhd.getVisit().getTokenNo()!=null)
			{
			%>
			data_arr[<%= counter%>][1] = "<%-- <%=dgOrderhd.getVisit().getTokenNo()%> --%> " 
			<%
			}else{
			%>
			data_arr[<%= counter%>][1] = ""
			
			<%}%>
			data_arr[<%= counter%>][2] = "<%=dgOrderhd.getVisit().getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%> "
			data_arr[<%= counter%>][4] = "<%=referBy%>"
			data_arr[<%= counter%>][5] = "<%=age%>"
			data_arr[<%= counter%>][6] = "<%=dgOrderhd.getId()%>"
				
			<%
			counter++;
			//}
	 	}
		}
		%>
		formName = "opdPatientBillStatus"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
		makeTable(start,end);
		//makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');  
</script>