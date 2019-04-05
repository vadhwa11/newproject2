<!--  jsp for update opd details by shailesh -->

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript"	language="javascript">
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
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}

	%> <%if(!message.equals("")){ %> <br>
<h4><%=message%></h4>
<%} %>
<div class="titleBg">
<h2>Update OPD Details</h2>
</div>
<input type="hidden" name="deptName" id="deptName"	value="<%=deptName %>" />
<div class="Clear"></div>
<form name="search" method="post" action="">
<div class="Block">
<label>Service No.</label>
<input type="text"	id="serviceNo." name="<%=SERVICE_NO%>" value="" tabindex="1"	validate="" MAXLENGTH="30"	onchange="submitProtoAjaxWithDivName('search','opd?method=getPatientNameForUpadteOpdDetails','patientNameDiv')"	tabindex=1 />
<div id="patientNameDiv">
<label>Patient Name</label>
<input	type="text" id="patientName" name="<%=PATIENT_NAME%>" value=""	MAXLENGTH="30"	onchange="submitProtoAjax('search','opd?method=getVisitNo');"	validate="Patient Name ,String,yes" tabindex=1 />
</div>
<label>Visit No. </label>
<div id="testDiv">
<input type="text" id="visitId"	name="<%=VISIT_NUMBER %>" value=""	ochange="submitForm('search','opd?method=getPatientOpdDetails');"	validate="Visit No ,String,yes" readonly="readonly" tabindex=1 />
</div>
</div>
</form>
<div class="clear"></div>

<%
			String includedJsp ="";
			if (request.getAttribute("map") != null) {
				map = (Map<String,Object>) request.getAttribute("map");
			}
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%> <jsp:include page="<%=includedJsp%>" flush="true" /> <%} %>

