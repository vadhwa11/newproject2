<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript"
src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder">


<script type="text/javascript" language="javascript">
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
Map<String, Object> utilMap = new HashMap<String, Object>();

utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList")!= null)
{
unitList= (List<MasUnit>)(map.get("unitList"));
System.out.println("unit list size in JSp-->"+unitList.size());
}

%>
<h6>Monthly Work Load</h6>
<div class="Clear"></div>

<form name="workLoadMonthly" target="_blank" method="post" action="">
<div class="Block">


<label>Month</label>
<select name="monthReport" tabindex="1">
<option value="">Select</option>
<option value="January">January</option>
<option value="February">February</option>
<option value="March">March</option>
<option value="April">April</option>
<option value="May">May</option>
<option value="June">June</option>
<option value="July">July</option>
<option value="August">August</option>
<option value="September">September</option>
<option value="October">October</option>
<option value="November">November</option>
<option value="December">December</option>
</select>

<label>Unit</label>
<select id="unitId" name="unitId" tabindex="1"  >

<option value="0">select</option>
<% for(MasUnit masUnit : unitList){ %>
System.out.println("unit list size in JSp-->"+unitList.size());
<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

<%} %>
</select>

<div class="Clear"></div>
</div>
<div class="Clear"></div>

<input type="button" name="print" value="Print" class="button"
onClick="submitForm('workLoadMonthly','mis?method=printMonthlyWorkLoadReport');" />

<input type="reset" name="Reset" value="Cancel" class="button"
onclick="location.reload();" accesskey="r" />
</form>

</div> 