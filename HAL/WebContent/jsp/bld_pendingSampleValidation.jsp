
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String deptName="";
		String message = "";
		int deptId=0;
		
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
			patientDetailList= (List<BloodSampleCollection>)patientMap.get("patientDetailList");
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
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String deptType ="";
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
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
<div id="contentHolder">
<form name="patientSearch" action="" method="post">

<h6>Pending Sample Validation</h6>
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

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<label> P Type</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="Out Patient">OP</option>
	<option value="In Patient">IP</option>
</select>

<div class="Clear"></div>
<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>HIN No.</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="15" /> <label>A&D No.</label>
<input type="text" name="<%=AD_NO %>" value="" MAXLENGTH="15" /> <label>Order
By</label> <select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : departmentList){
				%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> <label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="15" /></div>
</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForSampleValidation','check()');"
	value="Search" class="CmnButton" accesskey="a" /> <jsp:include
	page="searchResultBlock.jsp" />
<div class="division"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingBloodSampleValidation" method="post" action="">
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	  formFields = [
			[0, "sampleId", "id"],[1,"orderNo"],[2,"orderDate"],[3,"orderTime"],[4,"patName"], [5,"hin"], [6,"servNo"], [7,"serviceType"], [8,"sPersonName"], [9,"age"], [10,"sex"], [11,"pType"]];
	  statusTd = 11;
	</script></form>
</div>
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
		for(BloodSampleCollection sampleCollection: patientDetailList){
			Patient patient = sampleCollection.getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= sampleCollection.getId()%>
					data_arr[<%= counter%>][1] = "<%= sampleCollection.getRequest().getOrderNo()%>"
					data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(sampleCollection.getRequest().getOrderDate())%>"
					data_arr[<%= counter%>][3] = "<%= sampleCollection.getRequest().getOrderTime()%>"
					data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%>"
					data_arr[<%= counter%>][5] = "<%=patient.getHinNo()%>"
					data_arr[<%= counter%>][6] = "<%=patient.getServiceNo()%>"
					data_arr[<%= counter%>][7] = "<%=patient.getServiceType().getServiceTypeName()%> "
			 <%   try{
					if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
						
						String sMiddleName = "";
						String sLastName = "";
						if(patient.getSMiddleName() != null){
							sMiddleName = patient.getSMiddleName();
						}
						if(patient.getSLastName() != null){
							sLastName = patient.getSLastName();
						}
						String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
						
						%>
						data_arr[<%= counter%>][8] = "<%=sName%>"
						<%}else{%>
						data_arr[<%= counter%>][8] = ""
						<%}%>
						data_arr[<%= counter%>][9] = "<%=patient.getAge()%> "
						data_arr[<%= counter%>][10] = "<%=patient.getSex().getAdministrativeSexName() %> "
						data_arr[<%= counter%>][11] = "<%=patient.getPatientStatus()%> "
						
					<%
				
					}catch(Exception e){
						e.printStackTrace();
					}
						     counter++;
					}
		}
%>
    formName = "pendingBloodSampleValidation"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
		
	</script>
