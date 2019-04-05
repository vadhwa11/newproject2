<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.ShoSchoolHealth"%>
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
<form name="schoolHealth" method="post" action="">

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
 	
 	List<MasUnit> unitList = new ArrayList<MasUnit>();
		
		if(map.get("unitList")!= null )
		{
			unitList= (List)map.get("unitList"); 
		}
		
	List<ShoSchoolHealth> shoSchoolHealthList = new ArrayList<ShoSchoolHealth>();
	
	if(map.get("shoSchoolHealthList")!= null )
	{
		shoSchoolHealthList= (List)map.get("shoSchoolHealthList"); 
	}
		
 %>
<%System.out.println("In JSP"); %> 
<div class="titleBg">
<h2>School Health Details</h2>
</div>

<h4>Details of School Children Medically Examined</h4>

<div class="Block">

<label>School Inspection Date<span>*</span></label>
<input type="text"	id="schoolInspectionDate" name="schoolInspectionDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="School Inspection Date,date,yes" MAXLENGTH="30"	class="date" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.schoolHealth.schoolInspectionDate,event)" />

<label>Last Updated Date</label>

<% 
Date lastDate =new Date();
if(shoSchoolHealthList != null && shoSchoolHealthList.size()>0){
for(ShoSchoolHealth shoSchoolHealth : shoSchoolHealthList)
{	
	if(shoSchoolHealth.getSchoolInspectionDate() != null){


   	  lastDate = (Date)shoSchoolHealth.getSchoolInspectionDate();
    	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	  String updatedDate = sdf.format(lastDate);
     
  	%>
  	
<input type="text"	id="lastUpdatedDate" name="lastUpdatedDate" tabindex="1" value="<%=updatedDate %>"	readonly="readonly"  MAXLENGTH="20"	class=""  /> 

<%} else{%>
<label class="value">-</label>
<%}}} else{%>
<label class="value">-</label>
<%}%>


<label>Unit<span>*</span></label>	
<select name="unitId" validate="Unit Name, String, yes">
<option value="0">Select</option>
<%if(unitList!=null && unitList.size() >0){
	 for(MasUnit unit : unitList){
	%>
	<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	
<%}}%>
</select>

<div class="clear"></div>

<label>No. of Children Examined</label>
<input type="text" name="noOfChildren" validate="No of Children,int,no" MAXLENGTH="50"/>

<label>Defect Noticed with No. of Children</label>
<input type="text" name="defectOfChildren" validate="Defect Noticed with of Children,int,no" MAXLENGTH="50" />

<label>Dental Carries</label>
<input type="text" name="dentalCaries" validate="Dental Carries,int,no" MAXLENGTH="50" />

<div class="clear"></div>

<label>Refractive Error</label>
<input type="text" name="refractiveError" validate="Refractive Error,int,no" MAXLENGTH="50" />

<label>Anaemia</label>
<input type="text" name="anaemia" validate="Anaemia,int,no" MAXLENGTH="50" />

<label>Wax B/L Ear</label>
<input type="text" name="waxEar" validate="Wax B/L Ear,int,no" MAXLENGTH="50" />

<div class="clear"></div>

<label>Action taken to Rectify the Defect</label>
<input type="text" name="actionTaken" validate="" MAXLENGTH="100" />

</div>


<h4>IMMUNIZATION</h4>

<table class="cmntable">

<tr>
<th>Immunisation Name</th>
<th>No. of Children</th>
</tr>

<tr>
<th>BCG</th>
<td><input type="text" name="bcgChildren" validate="BCG,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>OPV</th>
<td><input type="text" name="opvChildren" validate="OPV,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>DPT</th>
<td><input type="text" name="dptChildren" validate="DPT,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Measles</th>
<td><input type="text" name="measlesChildren" validate="Measles,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>DT</th>
<td><input type="text" name="dtChildren" validate="DT,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>TA</th>
<td><input type="text" name="taChildren" validate="TA,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>TT</th>
<td><input type="text" name="ttChildren" validate="TT,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Hepatitis B</th>
<td><input type="text" name="hepatitisChildren" validate="Hepatitis B,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Pulse Polio</th>
<td><input type="text" name="pulsePolioChildren" validate="Pulse Polio,int,no" maxlength="50" /></td>
</tr>

</table>


<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" name="Submit" value="Submit" class="button" accesskey="a" onclick="submitForm('schoolHealth','/hms/hms/mis?method=submitSchoolHealthJsp');" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('schoolHealth','/hms/hms/mis?method=showSchoolHealth');" accesskey="r" />


<script>


function openPopupForImmunization(){

	 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&flag=sho','windowRef','width=1000,height=400,scrollbars = yes');
	 //newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','windowRef','width=1000,height=400,scrollbars = yes');

}

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

