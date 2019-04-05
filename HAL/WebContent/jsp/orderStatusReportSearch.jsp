<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%@page import="java.net.URL"%>
<div id="contentHolder"></script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		int deptId= 0;
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
		if(map.get("mainChargeCodeList") != null){
			mainChargeCodeList = (List<MasMainChargecode>)map.get("mainChargeCodeList");
		}
		if(map.get("chargeCodeList") != null){
			chargeCodeList = (List<DgMasInvestigation>)map.get("chargeCodeList");
		}
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if (map.get("deptId") != null) {
			deptId= (Integer) map.get("deptId");
			}
	%>

<h6>Total Order Booked Report</h6>
<form name="totalOrderBooked" target="_blank" action="" method="post">
<div class="blockFrame">
<div class="Clear"></div>
<label class="common"><span>*</span>Department</label> <select
	disabled="disabled" id="mainChargeCodeToShow"
	name="mainChargeCodeToShow" validate="Department,string,yes"
	onchange="populateSubCharge(this.value,'totalOrderBooked');">
	<option value="0">Select</option>
	<%for(MasMainChargecode masMainChargecode : mainChargeCodeList){ 
				if(masMainChargecode.getDepartment().getId() == deptId){ %>
	<option selected="selected" value="<%=masMainChargecode.getId()%>"
		<%=HMSUtil.isSelected(masMainChargecode.getId(),Integer.valueOf(box.getInt(INVESTIGATION_ID)))%>><%=masMainChargecode.getMainChargecodeName() %></option>
	<% }else{ %>
	<option value="<%=masMainChargecode.getId()%>"
		<%=HMSUtil.isSelected(masMainChargecode.getId(),Integer.valueOf(box.getInt(INVESTIGATION_ID)))%>><%=masMainChargecode.getMainChargecodeName() %></option>
	<% } %>
	<%}%>
</select> <%for(MasMainChargecode masMainChargecode : mainChargeCodeList){ 
				if(masMainChargecode.getDepartment().getId() == deptId){ %> <input
	type="hidden" name="<%=MAIN_CHARGECODE_ID%>"
	id="<%=MAIN_CHARGECODE_ID%>" value="<%=masMainChargecode.getId()%>" />
<%} %> <%}%> <label>Sub Group:</label> <select
	name="<%= SUB_CHARGECODE_ID%>"
	onchange="populateInvestigationName(this.value,'totalOrderBooked');"
	tabindex="1">
	<option value="0">Select</option>
	<% 
				for (MasSubChargecode  masSubChargecode : subChargeCodeList){
					%>
	<option value="<%=masSubChargecode.getId ()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}%>
</select> <script type="text/javascript">

<%

	int counter1 = 0;
	
	for (MasMainChargecode mainChargecode : mainChargeCodeList)
	{
	for (MasSubChargecode subChargecode : subChargeCodeList) 
	{
	if(subChargecode.getMainChargecode() != null){
	if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
%>
	subChargeArray[<%=counter1%>] = new Array();
	subChargeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
	subChargeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;									
	subChargeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
	<%
	counter1++;
	} } } }

%>
</script>

<div class="Clear"></div>

</div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('totalOrderBooked','lab?method=showOrderStatusBookedReport');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>

<script type="text/javascript" language="javascript">
	
	function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.totalOrderBooked.fromDate)
		obj2 = eval(document.totalOrderBooked.toDate)
			
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
	populateSubCharge(document.getElementById('<%=MAIN_CHARGECODE_ID%>').value,'totalOrderBooked');
</script>