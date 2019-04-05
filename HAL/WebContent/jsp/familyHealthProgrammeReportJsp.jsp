<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/hms.js"></script>
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
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
}
%>
<h6>Family Health Programme Report</h6>
<div class="Clear"></div>

<form name="familyHealthProgram" target="_blank" method="post" action="">
<div class="Block">

<%
int currYear = Calendar.getInstance().get(Calendar.YEAR);
%>

<label class="">Year</label>
<!--<input type="text" value="<%=currYear%>" />-->
<select name="year" class="">
<option>Select</option>
<%
int currentYear = 0;
for(currentYear=currYear; currentYear<=(currYear+5); currentYear++ ){ %>
<option value="<%=currentYear%>"><%=currentYear%></option>
<%} %>
</select>
<select name="halfYear">
<option>Select</option>
<option value="January - June">January - June</option>
<option value="July - December">July - December</option>
</select>


<label>Unit</label>
<select name="unitname">
<option value="0">Select</option>
<%if(unitList!=null && unitList.size() >0){
	 for(MasUnit unit : unitList){
	%>
	<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	
<%}}%>
</select>

<div class="clear"></div>

<label>Age Group</label>
<select name="ageGroup">
<option>select</option>
<option>20 - 30</option>
<option>30 - 40</option>
<option>40 - 50</option>
<option>50 - 60</option>
<option> > 60 </option>
</select>

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="Print" class="button"
onClick="submitForm('familyHealthProgram','mis?method=generateFamilyHealthProgrammeReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
onclick="location.reload();" accesskey="r" />
</form>

</div> 