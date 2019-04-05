<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.AviCa34"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script	type="text/javascript" language="javascript">
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
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	String message = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
	if (map.get("aviCa34List") != null) {
		aviCa34List = (List) map.get("aviCa34List");
	}
	
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	if (!message.equalsIgnoreCase("")) {
%>
<h4></h4>
<%
	}
%>
<div class="Clear"></div>
<form name="patientSearch" action="" method="post">
<h4>Search</h4>
<div class="Block">
<label> Appointment Date <span>*</span></label> 
<input type="text"	class="calDate" id="appointmentDate" name="<%=APPOINTMENT_DATE %>"	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="7" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=APPOINTMENT_DATE%>,event)" />
<label> Name </label>
 <input type="text" name="<%=NAME %>" value="" MAXLENGTH="32" id="name"/>
<label> Licence No. </label> 
<input type="text" name="<%=LICENCE_NO %>" value="" MAXLENGTH="15" id="licenceNo"/>

<div class="Clear"></div>
</div>
</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton" value="Search" class="button" accesskey="a"
	onclick="submitForm('patientSearch','/hms/hms/aviationMedicine?method=searchForAviationMA');" />
	<div class="clear"></div>
	<jsp:include	page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<div class="clear"></div>
<form name="waitingListForAviationMA" method="post" 	action="">

<script type="text/javascript">
	formFields = [ [0,"avica34Id","id"],[1,"visitId"],[2,"appointmentDate"], [3,"name"], [4,"<%=LICENCE_NO%>"], [5,"<%= RequestConstants.TYPE_OF_LICENCE %>"],[6,"licenceHeld"]];
	 statusTd = 1;
	</script>
   </form></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "";
data_header[0][1] = "hide";
data_header[0][2] = "10%";
data_header[0][3] = "visitId";

data_header[1] = new Array;
data_header[1][0] = "Appointment Date"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "appointmentDate";

data_header[2] = new Array;
data_header[2][0] = "Name "
data_header[2][1] = "data";
data_header[2][2] = "5%";
data_header[2][3] = "name";

data_header[3] = new Array;
data_header[3][0] = "Licence No.";
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%=RequestConstants.LICENCE_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Licence Type"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=RequestConstants.TYPE_OF_LICENCE %>";


data_header[5] = new Array;
data_header[5][0] = "Exam Due Date"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "licenceHeld";


<%
int  counter=0;
if (aviCa34List != null && aviCa34List.size() > 0) { 
for(AviCa34 aviCa34 : aviCa34List){
%>
  	   data_arr[<%= counter%>] = new Array();   
       data_arr[<%= counter%>][0] = '<%= aviCa34.getId()%>'
   	   data_arr[<%= counter%>][1] = '<%=aviCa34.getVisit().getId()%>'
 		<%if(aviCa34.getAppointmentDate() !=null){%>
       data_arr[<%= counter%>][2] = '<%=HMSUtil.changeDateToddMMyyyy(aviCa34.getAppointmentDate())%>'; 
	 <%}else{%>data_arr[<%= counter%>][2] ="";
	 <%}%>
	 <%String name="";
		 name=aviCa34.getFirstName();
		 if(aviCa34.getLastName() !=null){
	 	 name=name+" "+aviCa34.getLastName(); 
	  }
		 String licenceType="";
		 String licenceHeld="";
		 String licenceNo="";
		 if(aviCa34.getLicenceNo() !=null){
			 licenceNo=aviCa34.getLicenceNo();}
		 if(aviCa34.getTypeOfLicenceApplied() !=null){
		   licenceType=aviCa34.getTypeOfLicenceApplied().getCaLicenceName();}
		 if(aviCa34.getLicenceHeld() !=null){
			 licenceHeld=aviCa34.getLicenceHeld().getCaLicenceName();}
		 String examDueDate="";
		 if(aviCa34.getRenewalDueDate() !=null){
		 examDueDate=HMSUtil.changeDateToddMMyyyy(aviCa34.getRenewalDueDate());
		 }
		 
	 %>
       data_arr[<%= counter%>][3] = '<%=name%>';
       data_arr[<%= counter%>][4] = '<%=licenceNo%>';
       data_arr[<%= counter%>][5] ='<%=licenceType%>';
       data_arr[<%= counter%>][6] = '<%=examDueDate%>';
      
<%
counter++;
}
}
%>
formName = "waitingListForAviationMA"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="clear"></div>
<div class="floatRight">
<label class="auto">Total Waiting Patient : </label>
<label	class="valueAuto"><%=counter%></label>
</div>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("appointmentDate").value;
	errorMsg=errorMsg+document.getElementById("name").value;
	errorMsg=errorMsg+document.getElementById("licenceNo").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>