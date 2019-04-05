<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.ShoOfficerDetails"%>
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
		
		List<ShoOfficerDetails> shoOfficerDetailsList = new ArrayList<ShoOfficerDetails>();
	
	if(map.get("shoOfficerDetailsList")!= null )
	{
		shoOfficerDetailsList= (List)map.get("shoOfficerDetailsList"); 
	}
		
 %>


<form name="officerOperationDetails" method="post" action="">

<div class="titleBg">
<h2>Operation Details</h2>
</div>


<div class="Block">

<label>Current Date<span>*</span></label>
<input type="text"	id="currentDate" name="currentDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="School Inspection Date,date,yes" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.officerOperationDetails.currentDate,event)" />

<label>Last Updated Date</label>

<% 
Date lastDate =new Date();
if(shoOfficerDetailsList != null && shoOfficerDetailsList.size()>0){
for(ShoOfficerDetails shoOfficerDetails :shoOfficerDetailsList)
{	
	if(shoOfficerDetails.getCurrentDate() != null){


   	  lastDate = (Date)shoOfficerDetails.getCurrentDate();
   	 
    	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	  String updatedDate = sdf.format(lastDate);
    	      
  	%>
  	
<input type="text"	id="lastUpdatedDate" name="lastUpdatedDate" tabindex="1" value="<%=updatedDate %>"	readonly="readonly"  MAXLENGTH="20"	class=""  /> 

<%} else{%>
<label class="value">-</label>
<%}}}%>


<label>Unit</label>	
<select name="unitId">
<option value="0">Select</option>
<%if(unitList!=null && unitList.size() >0){
	 for(MasUnit unit : unitList){
	%>
	<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	
<%}}%>
</select>

<div class="clear"></div>
</div>

<h4>No. of Operation Performed in Service Hospital During the Year</h4>

<table class="cmntable">

<tr>
<th>Category</th>
<th>Cataract</th>
<th>Glaucoma</th>
</tr>

<tr>
<th>Officers</th>
<td><input type="text" name="officerCataract" validate="Officer Cataract,int,no" maxlength="50" /></td>
<td><input type="text" name="officerGlaucoma" validate="Officer Glaucoma,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Airmen</th>
<td><input type="text" name="airmenCataract" validate="Airmen Cataract,int,no" maxlength="50" /></td>
<td><input type="text" name="airmenGlaucoma" validate="Airmen Glaucoma,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Family of Service Personnel</th>
<td><input type="text" name="familyCataract" validate="Family Cataract,int,no" maxlength="50" /></td>
<td><input type="text" name="familyGlaucoma" validate="Family Glaucoma,int,no" maxlength="50" /></td>
</tr>

<tr>
<th>Ex Servicemen and Family</th>
<td><input type="text" name="servicemenCataract" validate="Servicemen Cataract,int,no" maxlength="50" /></td>
<td><input type="text" name="servicemenGlaucoma" validate="Servicemen Glaucoma,int,no" maxlength="50" /></td>
</tr>

</table>
<div class="clear paddingTop15"></div>

<h4>Additional Information about Disease</h4>

<table>
<tr>
<th colspan="2">Hospital Admission for Leprosy</th>
<th colspan="2">Hospital Admission for Viral Hepatitis</th>
</tr>

<tr>
<th>No. of Cases of Multi Bacillary Leprosy</th>
<th>No. of Cases of Pauci-Baciilary Leprosy</th>
<th>No. of Cases of Viral Hepatitis</th>
<th>No. of All Other of Viral</th>
</tr>

<tr>
<td><input type="text" name="multiBacillary" validate="No. of Cases of Multi Bacillary Leprosy,int,no"/></td>
<td><input type="text" name="pauciBacillary" validate="No. of Cases of Pauci-Baciilary Leprosy,int,no"/></td>
<td><input type="text" name="hepatitisViral" validate="No. of Cases of Viral Hepatitis,int,no"/></td>
<td><input type="text" name="otherViral" validate="No. of All Other of Viral,int,no"/></td>
</tr>
</table>

<div class="clear paddingTop15"></div>

<h4>Rabies</h4>

<table>
<tr>
<th>No. of Cases of Dog Bite Treated with Anti Rabid Vaccine in SMC/ MH</th>
<th>Total Vaccine</th>
</tr>
<tr>
<td><input type="text" name="noOfDogBite" validate="No. of cases of Dog Bite, int, no" /></td>
<td><input type="text" name="totalDoses" validate="Total Doses o Vaccine, int, no" /></td>
</tr>
</table>

<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" name="Submit" value="Submit" class="button" accesskey="a"  onclick="submitForm('officerOperationDetails','/hms/hms/mis?method=submitLadyOfficerJsp');" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('officerOperationDetails','/hms/hms/mis?method=showOfficerDetails');" accesskey="r" />

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

