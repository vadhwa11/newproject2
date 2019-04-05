<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}
%>
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
</script> <script type="text/javascript">
function check()
	{
		var r = document.getElementById('mainChargeCodeId').value;
		if(r=="0")
		{
			alert("Please select Main Group")
			return false;
		}
		else
		{
			return true;
		}
	}
	function generateDiagnosticRegister(){
		<% if(loginDeptId == 49){ %>
			submitForm('diagnosticRegisterSummary','lab?method=generatePatientDiagnosticRegister','validateFromToDate');
		<% }else{ %>
			submitForm('diagnosticRegisterSummary','lab?method=generatePatientDiagnosticRegisterLab','validateFromToDate');
		<% } %>		
	}
	
</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String deptType = "";
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
		}
		if(map.get("departmentList")!= null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		if(map.get("chargeCodeList")!= null){
			chargeCodeList = (List<Object[]>)map.get("chargeCodeList");
		}
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		
	%>
<div class="titleBg">
<h2>Diagnostic Register Summary</h2>
</div>
<form name="diagnosticRegisterSummary" target="_blank" action=""
	method="post">
<div class="Block">
<label>Date:</label>

<label class="medium"> From <span>*</span> </label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>" 
	value="<%=currentDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.diagnosticRegisterSummary.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.diagnosticRegisterSummary.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<div class="Clear"></div>

<label>Department</label> 
<input type="text" class="transparent" size="14">
<select name="<%= DEPARTMENT_ID%>" tabindex=1 onchange="populateSubCharge(this.value);">
	<option value="0">Select</option>
	<% 
				for (MasDepartment  masDepartment : departmentList){
					if(session.getAttribute("deptId").equals(masDepartment.getId())){
					%>
					<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
					<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}
	}%>
</select>
<script>
var subchargeArray = new Array();
<%

int counter1 = 0;
for (MasDepartment dept : departmentList)
{
	for (MasSubChargecode subCharge : subChargeCodeList) 
	{
			if(dept.getId().equals(subCharge.getMainChargecode().getDepartment().getId() )){
					%>
						subchargeArray[<%=counter1%>] = new Array();
						subchargeArray[<%=counter1%>][0]=<%=dept.getId()%>;
						subchargeArray[<%=counter1%>][1] = <%=subCharge.getId()%>;									
						subchargeArray[<%=counter1%>][2] = "<%=subCharge.getSubChargecodeName()%>";

					<%
					counter1++;
			}
	}
}

%>

</script>
<label>Modality</label> <select id="subChargeId" name="<%= SUB_CHARGECODE_ID %>" onchange="populateTest(this.value);"
	tabindex=1>
	<option value="0">Select</option>
	<% 
				for (MasSubChargecode  masSubChargecode : subChargeCodeList){
					if(masSubChargecode.getMainChargecode().getDepartment().getId().equals(session.getAttribute("deptId"))){
					%>
	<option value="<%=masSubChargecode.getId ()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}
	}%>
</select>
<script>
var chargeArray = new Array();
<%

int counter = 0;
for (MasSubChargecode subCharge : subChargeCodeList) 
{
		for (Object[] charge: chargeCodeList)
	{
			if(subCharge.getId().equals(charge[3] )){
					%>
					chargeArray[<%=counter%>] = new Array();
					chargeArray[<%=counter%>][0]=<%=subCharge.getId()%>;
					chargeArray[<%=counter%>][1] = <%=charge[0]%>;									
					chargeArray[<%=counter%>][2] = "<%=charge[1]%>";

					<%
					counter++;
			}
	}
}

%>

</script>
<div class="Clear"></div>
<label>Test Name</label> 
<input type="text" class="transparent" size="14">
<select name="<%= INVESTIGATION_ID %>" id="testId"	tabindex=1>
	<option value="0">Select</option>
	<% 
				for (Object[]  obj : chargeCodeList){
					if(obj[2].equals(session.getAttribute("deptId"))){
					%>
	<option value="<%=obj[0]%>"><%=(String)obj[1]%></option>
	<%}
	}%>
</select>
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK"
	class="button" onClick="submitForm('diagnosticRegisterSummary','/hms/hms/lab?method=generateDiagnosticSummary')" />
	
	<input type="button" name="OK" value="PRINT"
	class="button" onClick="submitForm('diagnosticRegisterSummary','/hms/hms/lab?method=printDiagnosticRegisterSummary')" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />
</form>
<script>
function openGraph(){
	var url = "lab?method=showDiagnosticRegisterGraph&"+getNameAndData('diagnosticRegisterSummary');
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>

<script type="text/javascript" language="javascript">		
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.diagnosticRegisterSummary.fromDate)
	obj2 = eval(document.diagnosticRegisterSummary.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}
			
		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}
	
	}
	return true;
}

function populateSubCharge(val){
	obj = document.getElementById('subChargeId');
	obj.length = 1;
	for(i=0;i<subchargeArray.length;i++){
		if(subchargeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=subchargeArray[i][1];
			obj.options[obj.length-1].text=subchargeArray[i][2];			
		}
	}
}

function populateTest(val){
	obj = document.getElementById('testId');
	obj.length = 1;
	for(i=0;i<chargeArray.length;i++){
		if(chargeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=chargeArray[i][1];
			obj.options[obj.length-1].text=chargeArray[i][2];			
		}
	}
}
</script>