
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
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
	</script>

<%
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<BloodRequestEntryHeader>)patientMap.get("patientDetailList");
		}
		System.out.println("patientDetailList "+patientDetailList.size());
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>
<script type="text/javascript">
	function check(){
		var FDate = document.patientSearch.<%= FROM_DATE%>.value;
		var TDate = document.patientSearch.<%= TO_DATE %>.value;
		
		if (FDate == '' || TDate == '') {
		alert("Please enter both Date....");
		return false;
	   }

		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>

<form name="patientSearch" method="post">
<div id="contentHolder">
<h6>Pending for Sample Receipt Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label> <span>*</span> From Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label> <span>*</span> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<label> P Type</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="Out Patient">Out Patient</option>
	<option value="In Patient">In Patient</option>
</select>

<div class="Clear"></div>
<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>HIN No.</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="15" /> <label>A&D No</label> <input
	type="text" name="<%=AD_NO %>" value="" MAXLENGTH="20" />
<div class="Clear"></div>
<label>Order By</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : departmentList){
				%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> <label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" /> <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="30" />

<div class="Clear"></div>
<input type="submit" name="submit"
	onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForSampleCollection');"
	value="Search" class="cmnButton" accesskey="a" /></div>
</form>

<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="pendingBloodSampleCollection" method="post" action="">
<script type="text/javascript">
	  formFields = [
			[0, "requestId", "id"],[1,"orderNo"],[2,"orderDate"],[3,"orderTime"],[4,"patName"], [5,"hin"], [6,"servNo"], [7,"serviceType"], [8,"sPersonName"], [9,"age"], [10,"sex"], [11,"pType"]];
	  statusTd = 11;
	</script></form>
</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Order No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "orderNo"

data_header[1] = new Array;
data_header[1][0] = "Order Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "orderDate"

data_header[2] = new Array;
data_header[2][0] = "Order Time"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "orderTime";

data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "patName";

data_header[4] = new Array;
data_header[4][0] = "Hin"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "hin";

data_header[5] = new Array;
data_header[5][0] = "Service No"
data_header[5][1] = "data";
data_header[5][2] = "20%";
data_header[5][3] = "servNo";

data_header[6] = new Array;
data_header[6][0] = "Service Type"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "serviceType"

data_header[7] = new Array;
data_header[7][0] = "ServicePerson Name"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "sPersonName";

data_header[8] = new Array;
data_header[8][0] = "Age"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "age";

data_header[9] = new Array;
data_header[9][0] = "Sex"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "sex"

data_header[10] = new Array;
data_header[10][0] = "P Type"
data_header[10][1] = "data";
data_header[10][2] = "10%";
data_header[10][3] = "pType"
data_arr = new Array();
	<%
	    int  counter=0;
		if (patientDetailList != null && patientDetailList.size() > 0)
		{ %>
	<% 	
		for(BloodRequestEntryHeader bloodRequestEntryHeader: patientDetailList){
			Patient patient = bloodRequestEntryHeader.getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= bloodRequestEntryHeader.getId()%>
					data_arr[<%= counter%>][1] = "<%= bloodRequestEntryHeader.getOrderNo()%>"
					data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(bloodRequestEntryHeader.getOrderDate())%>"
					data_arr[<%= counter%>][3] = "<%= bloodRequestEntryHeader.getOrderTime()%>"
					<%if(patient != null){%>
					data_arr[<%= counter%>][4] = "<%=bloodRequestEntryHeader.getHin().getPFirstName()%> <%=bloodRequestEntryHeader.getHin().getPLastName()%>"
					<%}else{%>
					data_arr[<%= counter%>][4] = "-"
					<%}%>
					<%if(patient != null){%>
					data_arr[<%= counter%>][5] = "<%=bloodRequestEntryHeader.getHin().getHinNo()%>"
					<%}else{%>
					data_arr[<%= counter%>][5] = "-"
					<%}%>
					<%if(patient != null){%>
					data_arr[<%= counter%>][6] = "<%=bloodRequestEntryHeader.getHin().getServiceNo()%>"
					<%}else{%>
					data_arr[<%= counter%>][6] = "-"
					<%}%>
					<%if(patient != null){%>
					data_arr[<%= counter%>][7] = "<%=bloodRequestEntryHeader.getHin().getServiceType().getServiceTypeName()%> "
					<%}else{%>
					data_arr[<%= counter%>][7] = "-"
					<%}%>
			 <%   try{
					if(bloodRequestEntryHeader.getHin().getSFirstName() != null  && !(bloodRequestEntryHeader.getHin().getSFirstName().equals(""))){
						
						String sMiddleName = "";
						String sLastName = "";
						if(bloodRequestEntryHeader.getHin().getSMiddleName() != null){
							sMiddleName = patient.getSMiddleName();
						}
						if(bloodRequestEntryHeader.getHin().getSLastName() != null){
							sLastName = patient.getSLastName();
						}
						String sName = bloodRequestEntryHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
						
						%>
						data_arr[<%= counter%>][8] = "<%=sName%>"
						<%}else{%>
						data_arr[<%= counter%>][8] = "-"
						<%}%>
						<%if(patient != null){%>
						data_arr[<%= counter%>][9] = "<%=bloodRequestEntryHeader.getHin().getAge()%> "
						<%}else{%>
						data_arr[<%= counter%>][9] = "-"
						<%}%>
							<%if(patient != null){%>
						data_arr[<%= counter%>][10] = "<%=bloodRequestEntryHeader.getHin().getSex().getAdministrativeSexName() %> "
						<%}else{%>
						data_arr[<%= counter%>][10] = "-"
						<%}%>
						data_arr[<%= counter%>][11] = "<%=bloodRequestEntryHeader.getHin().getPatientStatus()%> "
						
					<%
				
					}catch(Exception e){
						e.printStackTrace();
					}
						     counter++;
					}
		}
%>
    formName = "pendingBloodSampleCollection"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
		
	</script>
