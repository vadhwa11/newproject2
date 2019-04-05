
<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleValidationLab.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 11.08.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  combinedIds
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script> -->
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<form name="patientSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%   
	    Box box = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";

		String message = "";
		String deptType = "";

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDeatilList") != null){
			patientDeatilList= (List<Object[]>)patientMap.get("patientDeatilList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
		
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
		}
		//if(session.getAttribute("boxForSampleValidation") != null){
		//	box = (Box)session.getAttribute("boxForSampleValidation");
		//}
		
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	
	Map<String,Object> utilMap1 = new HashMap<String,Object>();


	utilMap1 = (Map)HMSUtil.getCurrentDateAndTime();
	String newdate = (String)utilMap1.get("currentDate"); 
	%>
	</script> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<div class="titleBg"><h2>Pending for Sample Validation</h2></div>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<div class="titleBg"><h2>Acceptance for Radiological Investigations</h2></div>
<%} %>
<div class="Clear"></div>
<h4>Patient Search</h4>

<div class="Block">
<label>Bar Code Search</label>
<input type="text" name="barCodeOrderNo"	id="barCodeOrderNo" value="" MAXLENGTH="20" onkeypress="return searchKeyPress(event);" /> 


	
<%if(box != null) {} else
{%> <%-- <label> From Date</label> 
<input  type="text" class="calDate"  id="fromDate" name="fromDate" placeholder="DD/MM/YYYY" validate="From Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>

<label>To Date </label> 
<input type="text" id="ToDateId"	name="<%=TO_DATE %>" value="" class="calDate"	placeholder="DD/MM/YYYY" validate="to Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px" /> 



<label>Modality</label> <select id="subChargeCodeId"
	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> --%>

<div class="Clear"></div>
<label> Employee No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> 
 <%-- <label>Employee Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" /> <label>Patient
Name</label> <input type="text" name="<%=P_FIRST_NAME %>" value=""
	MAXLENGTH="15" />  --%>
	

<div class="Clear"></div>

<% } %>
</div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="check();"
	value="Search" class="button" accesskey="a" />
	<!-- <input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/lab?method=showPendingSampleValidationLabJsp');"
	value="Show All" class="button" accesskey="a" /> -->

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingSampleValidationLab" method="post" action="">
</form>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"diagDate"],[2,"orderNo"],[3,"serNo"], [4,"rank"], [5,"sPerson"], [6,"serviceType"], [7,"hin"], [8,"patName"], [9,"relation"], [10,"orderBy"], [10,"subDepartment"], [11,"doctor"] ];
	 statusTd = 11;
	</script></div>
</form>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Sample Date/Time"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "diagDate"

data_header[1] = new Array;
data_header[1][0] = "Order No"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "orderNo"

data_header[2] = new Array;
data_header[2][0] = "Employee No."
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "servNo";

data_header[3] = new Array;
data_header[3][0] = "Rank"
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "rank"

data_header[4] = new Array;
data_header[4][0] = "Employee Name"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "sPerson"

data_header[5] = new Array;
data_header[5][0] = "Service Type"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "serviceType";

data_header[6] = new Array;
data_header[6][0] = "Hin No"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "hin";

data_header[7] = new Array;
data_header[7][0] = "Patient Name"
data_header[7][1] = "data";
data_header[7][2] = "20%";
data_header[7][3] = "patName";

data_header[8] = new Array;
data_header[8][0] = "Relation"
data_header[8][1] = "hide";
data_header[8][2] = "20%";
data_header[8][3] = "relation";

data_header[9] = new Array;
data_header[9][0] = "Department Name"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "orderBy";

data_header[10] = new Array;
data_header[10][0] = "Modality"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "subDepartment";

data_header[11] = new Array;
data_header[11][0] = "Doctor Name"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "doctor";

data_arr = new Array();
</script>
<%  
	List<String> combinedListAll = new ArrayList<String>();
	int counter = 0;	
	for(int ilop=0; ilop < patientDeatilList.size(); ilop++) {
			combinedListAll.add(((DgSampleCollectionHeader)patientDeatilList.get(ilop)[0]).getId()+","
				+((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId());
		%>
<jsp:include page="pendingSampleValidationLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=counter%>" />
</jsp:include>
<%	
 	counter++;
	} %>

<%
	if(session.getAttribute("combinedListSampleValidationAll") != null){
		session.removeAttribute("combinedListSampleValidationAll");
		session.setAttribute("combinedListSampleValidationAll",combinedListAll);
	}else{
		session.setAttribute("combinedListSampleValidationAll",combinedListAll);
	}
	%>

<script type="text/javascript" language="javascript">   
    formName = "pendingSampleValidationLab";
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		 if (e.keyCode == 13) { 
			 
			 submitForm('patientSearch','/hms/hms/lab?method=searchPatientForSampleValidationLab');
			
			return false;
		 } 
		return true;
	}

	document.getElementById("barCodeOrderNo").focus();
		
	</script>
	

<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>


<script type="text/javascript">
	function check(){
		
		if(document.patientSearch.serviceNo.value =="" && document.patientSearch.barCodeOrderNo.value=="" )
		{
			alert("Please enter Employee No or Barcode No");
			return false;
		}
	else
		{
			submitForm('patientSearch','/hms/hms/lab?method=searchPatientForSampleValidationLab');	
		}
	}
</script>
