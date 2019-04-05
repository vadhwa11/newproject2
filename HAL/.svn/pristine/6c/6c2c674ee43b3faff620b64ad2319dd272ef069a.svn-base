<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> orderNoDetailMap = new HashMap<String, Object>();
		
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		
		String userName = "";
		
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		int deptId=0;
		if(map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		if(session.getAttribute("userName") != null){
			 userName = (String)session.getAttribute("userName");
		}
		if(map.get("orderNoDetailMap") != null){
			orderNoDetailMap = (Map<String, Object>)map.get("orderNoDetailMap");
		}
		if (orderNoDetailMap.get("dgOrderhdList") != null){
			orderNoList =(List)orderNoDetailMap.get("dgOrderhdList");
		}
		String deptType ="";
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}

	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	%> <script type="text/javascript">
	function check(){
		var FDate = document.search.<%= FROM_DATE%>.value;
		var TDate = document.search.<%= TO_DATE %>.value;
		
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

<h6>Cancel Order Booking</h6>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<form name="search" method="post" action="">
<div class="blockTitle">Order No Search</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label><font id="error">*</font>From Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.search.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.search.<%=TO_DATE%>,event)" />

<label><font id="error">*</font>P Type</label> <select
	name="<%=PATIENT_TYPE%>" validate="P Type,string,yes">
	<option value="OP">OP</option>
	<option value="IP">IP</option>
</select>

<div class="Clear"></div>
<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Hin No:</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="50" /> <label>A&D No</label> <input
	type="text" name="<%=AD_NO %>" value="" class="textbox_size20"
	MAXLENGTH="50" /> <label>Ser. Per.Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" /> <label>Patient
Name</label> <input type="text" name="<%=P_FIRST_NAME %>" value=""
	MAXLENGTH="15" /> <!-- 	<label>Service No.</label>
			<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" tabindex="1" validate="" MAXLENGTH="30" onchange="submitProtoAjaxWithDivName('search','lab?method=getPatientNameForUpdateOrderBooking&flag=lab','patientNameDiv')"  tabindex=1/>
			
			<div id="patientNameDiv">
			<label>Patient Name</label>
			<input type="text" id="patientName" name="<%=PATIENT_NAME%>"   value="" MAXLENGTH="30" onchange="submitProtoAjax('search','lab?method=getOrderNoForUpdateOrderBooking&flag=lab');" validate="Patient Name ,String,yes"  tabindex=1/>
			</div>
			<label>Order No</label>
			<div id="testDiv">
			<input type="text" id="visitId" name="<%=VISIT_NUMBER %>"   value="" onchange="submitForm('search','lab?method=getPatientDetails');" validate="Visit No ,String,yes" readonly="readonly"  tabindex=1/>
			</div> --></div>
</form>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('search','/hms/hms/lab?method=getOrderNoForCancelOrderBooking','check()');"
	value="Search" class="CmnButton" accesskey="a" /> <jsp:include
	page="searchResultBlock.jsp" />
<div class="division"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="orderNoList" method="post" action=""><script
	type="text/javascript">
	  formFields = [
			[0, "orderId", "id"],[1,"orderNo"],[2,"orderDate"],[3,"orderTime"],[4,"patName"], [5,"hin"], [6,"servNo"], [7,"serviceType"], [8,"sPersonName"], [9,"age"], [10,"sex"], [11,"pType"]];
	  statusTd = 11;
	</script>
</div>
</form>
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
		if (orderNoList != null && orderNoList.size() > 0)
		{ %>
	
	<% 	
		for(DgOrderhd dgOrderhd: orderNoList){
			String flag = "";
			Set<DgOrderdt> set = new HashSet<DgOrderdt>();
			set = dgOrderhd.getDgOrderdts();
			     	Patient patient = dgOrderhd.getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= dgOrderhd.getId()%>
					data_arr[<%= counter%>][1] = "<%= dgOrderhd.getOrderNo()%>"
					data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>"
					data_arr[<%= counter%>][3] = "<%= dgOrderhd.getOrderTime()%>"
					<% if(patient.getPLastName()!=null){%>
						data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%>"
					<% }else {%>
						data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%>"
					<%}%>	
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
						data_arr[<%= counter%>][11] = "<%=dgOrderhd.getPatientType()%> "
						
					<%
				
					}catch(Exception e){
						e.printStackTrace();
					}
						     counter++;
					}
		    	}	
%>

    formName = "orderNoList"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
</script>
