<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
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
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
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
		if(map.get("mainChargeCodeList") != null){
			mainChargeCodeList = (List<MasMainChargecode>)map.get("mainChargeCodeList");
		}
		if(map.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
		}
		if(map.get("collectionCenterList") !=null){
			collectionCenterList = (List<DgCollectionCenter>)map.get("collectionCenterList");
		}
	%>

<h6>Packing List</h6>
<form name="packingList" target="_blank" action="" method="post">
<div class="blockFrame"><label><span>*</span>From Date</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate %>',document.packingList.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" /> </a> <label><span>*</span>To Date</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>"
	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate %>',document.packingList.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label>Main Group</label>
<select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubCharge(this.value,'packingList');">
	<option value="0">Select</option>
	<%
			for(MasMainChargecode mainChargecode : mainChargeCodeList){
		  %>
	<option value="<%=mainChargecode.getId() %>"
		<%=HMSUtil.isSelected(mainChargecode.getId(),Integer.valueOf(box.getInt(MAIN_CHARGECODE_ID)))%>><%=mainChargecode.getMainChargecodeName() %></option>
	<%}%>
</select>
<div class="Clear"></div>
<label>Sub Group</label> <select id="subChargeCodeId"
	name="subChargeCode_id">
	<option value="0">Select</option>
	<%
		for(MasSubChargecode subChargecode : subChargeCodeList){
		%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
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
</script> <label>Collection Center</label> <select id="departmentId"
	name="<%=COLLECTION_CENTER_ID %>">
	<option value="0">Select</option>
	<%
							for (DgCollectionCenter dgCollectionCenter : collectionCenterList) {
						%>
	<option value="<%=dgCollectionCenter.getId() %>"><%=dgCollectionCenter.getCollectionCenterName()%></option>
	<%
						}
					%>
</select> <label>Patient Type:</label> <label class="valueNoWidth">OP</label> <input
	name="<%=PATIENT_TYPE %>" value="1" type="radio" class="radio" /> <label
	class="valueNoWidth">IP</label> <input name="<%=PATIENT_TYPE %>"
	value="2" type="radio" class="radio" /></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('packingList','lab?method=generatePackingList','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>

<script type="text/javascript">
	function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.packingList.fromDate)
	obj2 = eval(document.packingList.toDate)
		
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
    </script>
