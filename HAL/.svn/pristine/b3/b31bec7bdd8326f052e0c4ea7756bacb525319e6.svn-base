<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			}
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%>
<div class="titleBg">
<h2>IP Discharge Register</h2>
</div>
<div class="Clear"></div>
<form name="ipDischargeRegister" target="_blank" method="post" action="">
<div class="Block">
<div id="divId"><label> From Date</label> <input type="text"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"
	class="calDate" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.ipDischargeRegister.<%=FROM_DATE%>,event)" />
<label> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.ipDischargeRegister.<%=TO_DATE%>,event)" />
</div>
<div class="clear"></div>
<label>Service Type</label> <select id="serviceType"
	name="<%=SERVICE_TYPE_ID %>">
	<option value="0">Select</option>
	<%
							for (MasServiceType masServiceType : serviceTypeList) {
						%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName()%></option>
	<%
						}
					%>
</select> <label>Department</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
							}
					%>
</select>
<div class="Clear"></div>
</div>
<input type="hidden" id="ToDateId" name="currDate"
	value="<%=currenDate %>" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('ipDischargeRegister','adt?method=showIpDischargeRegisterReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>



<script type="text/javascript">
	
    </script>