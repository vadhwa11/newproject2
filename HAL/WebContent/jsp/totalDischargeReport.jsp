
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
		
		function fillServiceType(){
			var obj = document.getElementById("serviceTypeId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					serviceName = obj.options[i].text
					break;
				}
			}
			if(serviceName !="Select"){
				document.getElementById("serviceTypeName").value =serviceName
			}else{
				document.getElementById("serviceTypeName").value =""
			}
			}
			
			
    	function checkTheOptions(){
    	    var obj = document.getElementById("OutType").value;
			if(obj == "Excel"){
			submitForm('totalAdmission','mis?method=totalDischargeExcelSoftCopy','checkFromNTodata');
			}else{
			submitForm('totalAdmission','mis?method=searchTotalDischarge','checkFromNTodata');
			//submitForm('totalAdmission','mis?method=searchTotalAdmission','checkFromNTodata');
			}	
		}
		function setradioValue(type){
		document.getElementById("OutType").value=type;
		}
	</script>

<h6>Total Discharge in CHAF Bangalore (AFMSF-42)</h6>
<div class="Clear"></div>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			 	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	if (map.get("serviceTypeList") != null) {
			 		serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			 	}
			 	if (map.get("disposalList") != null) {
			 		disposalList = (List<MasDisposal>) map.get("disposalList");
			 	}
			 %>

<form name="totalAdmission" target="_blank" method="post" action="">
<div class="blockFrame"><input type="hidden" name="OutType"
	id="OutType" value="Pdf" /> <label><span>*</span> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.totalAdmission.<%=FROM_DATE%>,event)" />


<label><span>*</span> To Date:</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.totalAdmission.<%=TO_DATE%>,event)" />


<label>Service Type:</label> <select id="serviceTypeId"
	name="<%=SERVICE_TYPE_ID %>" style="width: 110px;"
	onchange="fillServiceType();">
	<option value="0">Select</option>
	>
	<%
							for (MasServiceType masServiceType : serviceTypeList) {
						%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName()%></option>
	<%
						}
					%>
</select> <input type="hidden" name="<%=SERVICE_TYPE_NAME %>"
	id="serviceTypeName" />
<div class="Clear"></div>

<label><span>*</span> Output To :</label> <label class="small">PDF</label>
<input type="radio" name="outputType" class="radio" value="Pdf"
	checked="checked" onClick="setradioValue(this.value)" /> <label
	class="small">Excel</label> <input type="radio" name="outputType"
	class="radio" value="Excel" onClick="setradioValue(this.value)" /></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="checkTheOptions();" /> <input type="reset" name="Reset"
	value="Cancel" class="button" onclick="location.reload();"
	accesskey="r" />
<div class="Clear"></div>

</form>
</div>





