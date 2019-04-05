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
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	date = (String) utilMap.get("currentDate");
	String userName = "";
	String message = "";
	String header = " (OPD Prescription)";
	Date toDate  = null;
	Date fromDate = null;

	if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}
	%>
	
<form name="searchPrescription" action="" method="post">
<div class="clear"></div>
	<div class="titleBg">
	<h2>PENDING PRESCRIPTIONS For Ward</h2>
	</div>
	<div class="Block">
	<div class="clear"></div>
	<label> Employee No</label> 
	<input type="text" name="employeeNo" id="employeeNo" value="" />
	</div>
	<label> From Date<span>*</span></label> 
<input	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=FROM_DATE%>,event)" />
<label> To Date<span>*</span></label> 
<input type="text" class="calDate"	id="toDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"	readonly="readonly" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Department</label>
<select name="<%=DEPARTMENT_ID %>" >
<option value="0">Select</option>
<%
	for(MasDepartment department : departmentList){
		%>
		<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%}
%>
</select>
<label>Doctor</label>
<select name="<%=MEDICAL_OFFICER%>" >
<option value="0">Select</option>
<%
	for(MasEmployee employee : employeeList)
	{    String mname="";
	     if(employee.getMiddleName()!=null)
	      mname=employee.getMiddleName(); 	 
		String name=employee.getFirstName()+" "+mname+" "+employee.getLastName();
		%>
		<option value="<%=employee.getId() %>"><%=name %></option>
	<%}}
%>
</select>

</div>
</form>