
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>


<div id="contentHolder">
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
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
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
			patientDetailList= (List<BloodDonationEntryDetail>)patientMap.get("patientDetailList");
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
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String deptType ="";
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
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

<h6>Donor Blood Pending For Sample Screening</h6>
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

<label>Donor Name</label> <input type="text" name="<%=DONOR_NAME %>"
	value="" MAXLENGTH="15" />
<div class="Clear"></div>
<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>HIN No.</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="20" /> <label>Doantion
No.</label> <input type="text" name="<%=DONATION_NO %>" value="" MAXLENGTH="15" />


</div>
</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchDonorForBloodSampleScreening','check()');"
	value="Search" class="CmnButton" accesskey="a" /> <jsp:include
	page="searchResultBlock.jsp" />
<div class="division"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="donorPendingBloodSampleScreening" method="post" action="">
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<script type="text/javascript">
	  formFields = [
			[0, "donationId", "id"],[1,"donationNo"],[2,"servNo"],[3,"patName"], [4,"serviceType"], [5,"rank"]];
	  statusTd = 5;
	</script></div>
</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Donation No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "donationNo"

data_header[1] = new Array;
data_header[1][0] = "Service No"
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "servNo";

data_header[2] = new Array;
data_header[2][0] = "Name"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "patName";

data_header[3] = new Array;
data_header[3][0] = "Service Type"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "serviceType";

data_header[4] = new Array;
data_header[4][0] = "Rank"
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "rank";

data_arr = new Array();
	<%
	    int  counter=0;
		if (patientDetailList != null && patientDetailList.size() > 0){ %>
	<% 	
		for(BloodDonationEntryDetail bloodDonationEntryDetail: patientDetailList){
			BloodDonationEntryHeader donationEntryHeader = bloodDonationEntryDetail.getDonation();
			Patient patient = bloodDonationEntryDetail.getDonation().getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= donationEntryHeader.getId()%>
					data_arr[<%= counter%>][1] = "<%= bloodDonationEntryDetail.getDonation().getDonationNo()%>"
					<%if(donationEntryHeader.getHin()!= null){%>
					data_arr[<%= counter%>][2] = "<%= bloodDonationEntryDetail.getDonation().getHin().getServiceNo()%>"
					<%}else{%>
					data_arr[<%= counter%>][2] = "-"
					<%}%>
					 <% if(bloodDonationEntryDetail.getDonation().getHin() != null){  
					if(bloodDonationEntryDetail.getDonation().getHin().getPFirstName() != null  && !(bloodDonationEntryDetail.getDonation().getHin().getPFirstName().equals(""))){
						
						String sMiddleName = "";
						String sLastName = "";
						if(patient.getSMiddleName() != null){
							sMiddleName = patient.getPMiddleName();
						}
						if(patient.getSLastName() != null){
							sLastName = patient.getPLastName();
						}
						String sName = patient.getPFirstName()+" "+sMiddleName+" "+sLastName;
						
						%>
						data_arr[<%= counter%>][3] = "<%=sName%>"
						<%}}else{%>
						data_arr[<%= counter%>][3] = "<%=bloodDonationEntryDetail.getDonation().getDonerName()%>"
						<%}%>
						<%if(bloodDonationEntryDetail.getDonation().getHin()!= null){%>
					data_arr[<%= counter%>][4] = "<%=bloodDonationEntryDetail.getDonation().getHin().getServiceType().getServiceTypeName()%> "
					<%}else{%>
					data_arr[<%= counter%>][4] = "<%=bloodDonationEntryDetail.getDonation().getDonerType()%>"
					<%}%>
					<%if(bloodDonationEntryDetail.getDonation().getRank()!= null){ %>
					data_arr[<%= counter%>][5] = "<%=bloodDonationEntryDetail.getDonation().getRank().getRankName()%>"
					<%}else{%>
					data_arr[<%= counter%>][5] = "-"
						<%}%>
					<%
				     counter++;
					}
		}
%>
    formName = "donorPendingBloodSampleScreening"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
		
	</script>
