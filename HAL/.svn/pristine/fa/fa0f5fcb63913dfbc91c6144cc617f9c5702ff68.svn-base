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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
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
			submitForm('diagnosticRegisterDoctorWise','lab?method=generatePatientDiagnosticRegister','validateFromToDate');
		<% }else{ %>
			submitForm('diagnosticRegisterDoctorWise','lab?method=generatePatientDiagnosticRegisterLab','validateFromToDate');
		<% } %>		
	}
	
</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
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
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList =null;
		List<MasServiceStatus> serviceStatusList =null;
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasTrade> tradeList = null;
		List<Object[]> unitList = null;
		List<MasSection> sectionList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasEmployee> doctorList = null;
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		if(map.get("rankList")!=null){
			rankList = (List<MasRank>)map.get("rankList");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("serviceStatusList") != null){
			serviceStatusList= (List<MasServiceStatus>)map.get("serviceStatusList");
		}
		if(map.get("rankCategoryList")!=null){
			rankCategoryList = (List<MasRankCategory>)map.get("rankCategoryList");
		}
		if(map.get("tradeList") != null){
			tradeList = (List<MasTrade>)map.get("tradeList");
		}
		if(map.get("unitList") != null){
			unitList= (List<Object[]>)map.get("unitList");
		}
		if(map.get("sectionList") != null){
			sectionList = (List<MasSection>)map.get("sectionList");
		}
		if(map.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
		}
		if(map.get("employeeList") != null){
			doctorList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("chargeCodeList")!= null){
			chargeCodeList = (List<Object[]>)map.get("chargeCodeList");
		}
	%>

<h6>Diagnostic Register</h6>
<form name="diagnosticRegisterDoctorWise" target="_blank" action=""
	method="post">
<div class="Block">
<label>Date:</label>

<label class="medium"> From <span>*</span> </label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>" c
	value="<%=currentDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.diagnosticRegisterDoctorWise.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.diagnosticRegisterDoctorWise.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<label>Rank:</label>
<label class="medium">From </label> 
	<select	id="fromrankId" name="fromRankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
	
	<label>To </label> 
	<select	id="torankId" name="toRankId"tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 	
<div class="Clear"></div>
<label>Age:</label>
<label class="medium"> From </label>

<select id="fromageId"	name="fromAge" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toageId"	name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>
<label>Total Service:</label>
<label class="medium"> From </label>

<select id="fromServId"	name="fromServ" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromServUnitId" name="fromServUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toServId"	name="toServ"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toServUnitId" name="toServUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>	
<label>Service Type </label> 
<input type="text" class="transparent" size="14">
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceType masServiceType : serviceTypeList){
		%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%
				}%>
</select>

<label>Service Status </label> 
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
		%>
	<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>
	<%
				}%>
</select>


<div class="Clear"></div>
<label>Rank Category</label> 
<input type="text" class="transparent" size="14">
	<select	id="rankCatId" name="<%=RANK_CATEGORY_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRankCategory masRankCat : rankCategoryList) 
				{
			 		%>
	<option value="<%=masRankCat.getId()%>"><%=masRankCat.getRankCategoryName()%></option>
	<%
			 		}%>
</select> 

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<div class="Clear"></div>
<label>Unit </label> 
<input type="text" class="transparent" size="14">
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select>
<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>

</select>
<div class="Clear"></div>
<label> Service No.</label>
<input type="text" class="transparent" size="14">
<input type="text" name="<%=SERVICE_NO %>" value=""MAXLENGTH="30"  validate="Service No,alphanumeric,yes "/>
<label>Gender </label>
<select name="<%=SEX_ID %>" id="srSexId" validate="" tabindex="1">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
				
		   	 	} %>
</select> 

<div class="Clear"></div>

<label> Marital Status</label>
<input type="text" class="transparent" size="14">
<select name="<%=MARITAL_STATUS_ID %>"	id="mrstatus"  tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> 
<label>Medical Officer</label> 
<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	tabindex="1">
	<option value="0">Select</option>
	<%

for(MasEmployee masEmployee : doctorList){
	
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				
} %>
</select> 
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
<label>Modality</label> 
<select id="subChargeId" name="<%= SUB_CHARGECODE_ID %>" onchange="populateTest(this.value);"
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
<label>Investigation</label> 
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
<label>Result Type</label> 
<select id="resultType" name="resultType">
	<%if(deptType.equalsIgnoreCase("DIAG")){ %>
	<option value="s">Single</option>
	<option value="m">Multiple</option>
	<option value="t">Template</option>
	<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
	<option value="t" selected="selected">Template</option>
	<%} else if(deptType.equalsIgnoreCase("ECG")){ %>
	<option value="t" selected="selected">Template</option>
	<%} %>
</select>
<div class="Clear"></div>
<!--<label>ICD No</label>
<input type="text" class="transparent" size="14">
<input type="text" name="icdNo" value="" id="icdNo" validate="icdNo,alphanumeric,yes "/>
<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="60" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
--><div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK"
	class="button" onClick="generateDiagnosticRegister();" />
<input type="button" name="OK" value="PRINT"
	class="button" onClick="submitForm('diagnosticRegisterDoctorWise','lab?method=printDiagnosticRegister','validateFromToDate');" />
	 <input
	type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" />
</form>
<script type="text/javascript" language="javascript">		
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.diagnosticRegisterDoctorWise.fromDate)
	obj2 = eval(document.diagnosticRegisterDoctorWise.toDate)
		
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