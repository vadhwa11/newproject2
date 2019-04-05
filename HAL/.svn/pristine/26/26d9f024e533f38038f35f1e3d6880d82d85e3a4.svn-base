<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.ShoIndustrialDisease"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>

<%
	Properties properties = new Properties();
	URL resourcePathHIC = Thread.currentThread()
			.getContextClassLoader().getResource(
					"hicDetails.properties");
	try {
		properties.load(resourcePathHIC.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String urlForImportFromHIC = properties
			.getProperty("urlForImportFromHIC");
%> <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	
		
		List<ShoIndustrialDisease> shoIndustrialDiseaseList = new ArrayList<ShoIndustrialDisease>();
	
	if(map.get("shoIndustrialDiseaseList")!= null )
	{
		shoIndustrialDiseaseList= (List)map.get("shoIndustrialDiseaseList"); 
	}
		
 %>


<form name="industrialDisease" method="post" >

<div class="titleBg">
<h2>Industrial Disease</h2>
</div>


<div class="Block">

<label>Current Date<span>*</span></label>
<input type="text"	id="currentDate" name="currentDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="School Inspection Date,date,yes" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.industrialDisease.currentDate,event)" />

<label>Last Updated Date</label>

<%
Date lastDate= new Date();
if(shoIndustrialDiseaseList != null && shoIndustrialDiseaseList.size()>0){
	for(ShoIndustrialDisease shoIndustrialDisease  : shoIndustrialDiseaseList){
		if(shoIndustrialDisease.getLastUpdatedDate()!=null){
	lastDate=(Date)shoIndustrialDisease.getCurrentDate();
	 DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String updatedDate = sdf.format(lastDate);
%>


<input type="text"	id="lastUpdatedDate" name="lastUpdatedDate" tabindex="1" value="<%=updatedDate %>"	readonly="readonly"  MAXLENGTH="20"	class=""  /> 

<%}else{%>
<label class="value">-</label>
<%}}}else{%>
<label class="value">-</label>
<%}%>


<label>Particular</label>	
<select name="particuler">
<option value="">Select</option>
<option value="Missile Handlers">Missile Handlers</option>
<option value="Battery Charging">Battery Charging</option>
<option value="Painting">Painting</option>

</select>

<div class="clear"></div>


<label>No. of Cases/ Accident</label>
<input type="text" name="noOfCases" maxlength="50" validate="Number of Cases or Accident,int,no" />

<label>Action taken for the Prevention</label>
<input type="text" name="action" maxlength="200" />

<label>Recreational Facilities</label>
<input type="text" name="recreation" maxlength="200" />

<div class="clear"></div>

<label>Morale of the Personnel</label>
<input type="text" name="moral" maxlength="200" />

</div>

<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<!--<input type="button" name="Submit" value="Submit" class="button" accesskey="a" onclick="submitForm('IndustrialDisease','/hms/hms/mis?method=submitShoIndustrialDisease');" />-->
<!--<input type="button" name="Submit" value="Submit"  onclick= "submitForm('IndustrialDisease','/hms/hms/mis?method=submitShoIndustrialDisease');" class="button" />

-->

<input type="button" name="save" value="Submit"  onclick="submitForm('industrialDisease','/hms/hms/mis?method=submitShoIndustrialDisease');" class="button" />



<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('industrialDisease','/hms/hms/mis?method=showIndustrialDisease');" accesskey="r" />

<script>


function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}
</script>

</form>

