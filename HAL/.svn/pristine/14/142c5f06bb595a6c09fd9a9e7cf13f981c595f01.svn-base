<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>



<%@page import="jkt.hms.masters.business.AviCa34"%><form name="patientSearch" action="" method="post">
<script
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
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<AviCa34> appointmentList = new ArrayList<AviCa34>();
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
		if(map.get("appointmentList") != null){
			appointmentList= (List<AviCa34>)map.get("appointmentList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
		<%}	%>
</script> <script type="text/javascript">
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

<div class="titleBg"><h2>Appointment Waiting List</h2></div>
<div class="clear"></div>
<h4>Search</h4>
<div class="Block">
<label> From Date <span>*</span></label> 
<input type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label>To Date <span>*</span></label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
<div class="clear"></div>

<div class="clear"></div>
</div>
</form>
<div class="clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/aviationMedicine?method=searchAppointmentList','check()');"
	value="Search" class="button" accesskey="a" />
	<div class="clear"></div>
	<jsp:include	page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingAvAppointment" method="post" action=""></form>
<script	type="text/javascript">
	  formFields = [
			[0, "avCA34Id", "id"],[1,"licenceNo"],[2,"appointmentDate"],[3,"patName"], [4,"age"], [5,"licenceHeld"]];
	  statusTd = 5;
	</script>
	</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Licence No."
data_header[0][1] = "hide";
data_header[0][2] = "7%";
data_header[0][3] = "licenceNo"

data_header[1] = new Array;
data_header[1][0] = "Appointment Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "appointmentDate"

data_header[2] = new Array;
data_header[2][0] = "Name"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "patName";

data_header[3] = new Array;
data_header[3][0] = "Age"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "age";

data_header[4] = new Array;
data_header[4][0] = "Licence Held"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "licenceHeld";

data_arr = new Array();
	<%
	    int  counter=0;
		if (appointmentList != null && appointmentList.size() > 0)
		{ 
		for(AviCa34 aviCa34: appointmentList){
			try{
			%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= aviCa34.getId()%>
			data_arr[<%= counter%>][1] = "<%= aviCa34.getLicenceNo()%>"
			data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(aviCa34.getAppointmentDate())%>"
           data_arr[<%= counter%>][3] = "<%=aviCa34.getFirstName()%> <%=(aviCa34.getLastName()!=null?aviCa34.getLastName():"")%>"
			data_arr[<%= counter%>][4] = "<%=aviCa34.getAge()%> "
				<%if(aviCa34.getLicenceHeld() !=null){%>
		  data_arr[<%= counter%>][5] = "<%=aviCa34.getLicenceHeld().getCaLicenceName() %> "
		  <%}%>
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
		}
		}
%>
    formName = "pendingAvAppointment"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
		
	</script>
