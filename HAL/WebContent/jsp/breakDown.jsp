<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ShoBreakDown"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"
	language="javascript">
	<%  String  fLastDate="";
	
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
	
	<form name="breakDown" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
   		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
   		List<ShoBreakDown> shoBreakDownList = new ArrayList<ShoBreakDown>();
   		
   		if(map.get("shoBreakDownList")!= null )
   		{
   			shoBreakDownList= (List)map.get("shoBreakDownList"); 
   		}
   			
   		  		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		%>
	
<div class="titleBg"><h2>Break Down of Station Population</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label>Current Date</label>
<input type="text"	id="currentDate" name="currentDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.breakDown.currentDate,event)" />

<label>Last Updated Date</label>

<% 
Date lastDate =new Date();
if(shoBreakDownList != null && shoBreakDownList.size()>0){
for(ShoBreakDown shoBreakDown :shoBreakDownList)
{	
	if(shoBreakDown.getCurrentDate() != null){

   	  lastDate = (Date)shoBreakDown.getCurrentDate();
    	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	  String updatedDate = sdf.format(lastDate);
     
  	%>

<input type="text" name="lastUpdatedDate" id="lastUpdatedDate" value="<%=updatedDate %>" />


<%} else{%>
<label class="value">-</label>
<%}}} else{%>
<label class="value">-</label>
<%}%>


<table	id="Grid" class="cmntable">
	<tr>
	    <th>Category</th>
		<th>Officers</th>
		<th>Airmen</th>
		<th>NCs(E)</th>
		<th>Army/ DSC</th>
		<th>Civilians</th>
		<th>Total</th>
		
	</tr>
	
	<tr>
		<th>Personnel</th>
		
		<td><input type="text" MAXLENGTH="50" name="personnelOfficer" id="personnelOfficer" onblur="totalOfficers(this.value);" validate="Personnel Officers,int,no" onchange="personnelTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="personnelAirmen" id="personnelAirmen" onblur="totalAirmens(this.value);" validate="Personnel Airmen,int,no" onchange="personnelTotals(this.value);" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="personnelNcs" id="personnelNcs" onblur="totalNcse(this.value);" validate="Personnel Ncs(E),int,no" onchange="personnelTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="personnelArmy" id="personnelArmy" onblur="totalArmys(this.value);" validate="Personnel Army,int,no" onchange="personnelTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="personnelCivilian" id="personnelCivilian" onblur="totalCivilians(this.value);" validate="Personnel Civilian,int,no" onchange="personnelTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="personnelTotal" id="personnelTotal" onblur="totalTotals(this.value);" readonly="readonly" /></td>

	</tr>
	
	<tr>
		<th>Wives</th>
		
		<td><input type="text" MAXLENGTH="50" name="wivesOfficer" id="wivesOfficer" onblur="totalOfficers(this.value);" validate="Wives Officers,int,no" onchange="wivesTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="wivesAirmen" id="wivesAirmen" onblur="totalAirmens(this.value);" validate="Wives Airmen,int,no" onchange="wivesTotals(this.value);" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="wivesNcs" id="wivesNcs" onblur="totalNcse(this.value);" validate="Wives Ncs,int,no" onchange="wivesTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="wivesArmy" id="wivesArmy" onblur="totalArmys(this.value);" validate="Wives Army,int,no" onchange="wivesTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="wivesCivilian" id="wivesCivilian" onblur="totalCivilians(this.value);" validate="Wives Civilian,int,no" onchange="wivesTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="wivesTotal" id="wivesTotal" onblur="totalTotals(this.value);" readonly="readonly" /></td>

	</tr>
	
	<tr>
		<th>Children</th>
		
		<td><input type="text" MAXLENGTH="50" name="childrenOfficer" id="childrenOfficer" onblur="totalOfficers(this.value);" validate="Children Officers,int,no" onchange="childrenTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="childrenAirmen" id="childrenAirmen" onblur="totalAirmens(this.value);"  validate="Children Airmen,int,no" onchange="childrenTotals(this.value);" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="childrenNcs" id="childrenNcs" onblur="totalNcse(this.value);" validate="Children Ncs,int,no" onchange="childrenTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="childrenArmy" id="childrenArmy" onblur="totalArmys(this.value);" validate="Children Army,int,no" onchange="childrenTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="childrenCivilian" id="childrenCivilian" onblur="totalCivilians(this.value);" validate="Children Civilian,int,no" onchange="childrenTotals(this.value);" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="childrenTotal" id="childrenTotal" onblur="totalTotals(this.value);" readonly="readonly"/></td>

	</tr>
	
	<tr>
		<th>Total</th>
		
		<td><input type="text" MAXLENGTH="50" name="totalOfficer" id="totalOfficer" onblur="totalOfficers(this.value);" readonly="readonly" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="totalAirmen" id="totalAirmen" onblur="totalAirmens(this.value);" readonly="readonly" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="totalNcs" id="totalNcs" onblur="totalNcse(this.value);" readonly="readonly" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="totalArmy" id="totalArmy" onblur="totalArmys(this.value);" readonly="readonly" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="totalCivilian" id="totalCivilian" onblur="totalCivilians(this.value);"  readonly="readonly" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="totalTotal" id="totalTotal" onblur="totalTotals(this.value);"  readonly="readonly" /></td>

	</tr>

</table>


 <div class="clear paddingTop15"></div>

 
<input type="button" name="Submit" value="Submit"  onClick= "submitForm('breakDown','/hms/hms/mis?method=submitBreakDownJSP');" class="button" />

<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('breakDown','/hms/hms/mis?method=showBreakDown');" accesskey="r" />


<div class="clear"></div>

	<script type="text/javascript">

	function totalOfficers(val){
		
		var totalOfficer=0;

		if(document.getElementById('personnelOfficer').value != null && document.getElementById('personnelOfficer').value != 0)
		{
			totalOfficer = Number(totalOfficer) + Number(document.getElementById('personnelOfficer').value);
		}

		if(document.getElementById('wivesOfficer').value != null && document.getElementById('wivesOfficer').value != 0)
		{
			totalOfficer = Number(totalOfficer) + Number(document.getElementById('wivesOfficer').value);
		}

		if(document.getElementById('childrenOfficer').value != null && document.getElementById('childrenOfficer').value != 0)
		{
			totalOfficer = Number(totalOfficer) + Number(document.getElementById('childrenOfficer').value);
		}

		document.getElementById('totalOfficer').value = totalOfficer;
	}

function totalAirmens(val){
		
		var totalAirmen=0;

		if(document.getElementById('personnelAirmen').value != null && document.getElementById('personnelAirmen').value != 0)
		{
			totalAirmen = Number(totalAirmen) + Number(document.getElementById('personnelAirmen').value);
		}

		if(document.getElementById('wivesAirmen').value != null && document.getElementById('wivesAirmen').value != 0)
		{
			totalAirmen = Number(totalAirmen) + Number(document.getElementById('wivesAirmen').value);
		}

		if(document.getElementById('childrenAirmen').value != null && document.getElementById('childrenAirmen').value != 0)
		{
			totalAirmen = Number(totalAirmen) + Number(document.getElementById('childrenAirmen').value);
		}

		document.getElementById('totalAirmen').value = totalAirmen;
	}

function totalNcse(val){
	
	var totalNcs=0;

	if(document.getElementById('personnelNcs').value != null && document.getElementById('personnelNcs').value != 0)
	{
		totalNcs = Number(totalNcs) + Number(document.getElementById('personnelNcs').value);
	}

	if(document.getElementById('wivesNcs').value != null && document.getElementById('wivesNcs').value != 0)
	{
		totalNcs = Number(totalNcs) + Number(document.getElementById('wivesNcs').value);
	}

	if(document.getElementById('childrenNcs').value != null && document.getElementById('childrenNcs').value != 0)
	{
		totalNcs = Number(totalNcs) + Number(document.getElementById('childrenNcs').value);
	}

	document.getElementById('totalNcs').value = totalNcs;
}

function totalArmys(val){
	
	var totalArmy=0;

	if(document.getElementById('personnelArmy').value != null && document.getElementById('personnelArmy').value != 0)
	{
		totalArmy = Number(totalArmy) + Number(document.getElementById('personnelArmy').value);
	}

	if(document.getElementById('wivesArmy').value != null && document.getElementById('wivesArmy').value != 0)
	{
		totalArmy = Number(totalArmy) + Number(document.getElementById('wivesArmy').value);
	}

	if(document.getElementById('childrenArmy').value != null && document.getElementById('childrenArmy').value != 0)
	{
		totalArmy = Number(totalArmy) + Number(document.getElementById('childrenArmy').value);
	}

	document.getElementById('totalArmy').value = totalArmy;
}

function totalCivilians(val){
	
	var totalCivilian=0;

	if(document.getElementById('personnelCivilian').value != null && document.getElementById('personnelCivilian').value != 0)
	{
		totalCivilian = Number(totalCivilian) + Number(document.getElementById('personnelCivilian').value);
	}

	if(document.getElementById('wivesCivilian').value != null && document.getElementById('wivesCivilian').value != 0)
	{
		totalCivilian = Number(totalCivilian) + Number(document.getElementById('wivesCivilian').value);
	}

	if(document.getElementById('childrenCivilian').value != null && document.getElementById('childrenCivilian').value != 0)
	{
		totalCivilian = Number(totalCivilian) + Number(document.getElementById('childrenCivilian').value);
	}

	document.getElementById('totalCivilian').value = totalCivilian;
}

function personnelTotals(val){
	
	var personnelTotal=0;

	if(document.getElementById('personnelOfficer').value != null && document.getElementById('personnelOfficer').value != 0)
	{
		personnelTotal = Number(personnelTotal) + Number(document.getElementById('personnelOfficer').value);
	}

	if(document.getElementById('personnelAirmen').value != null && document.getElementById('personnelAirmen').value != 0)
	{
		personnelTotal = Number(personnelTotal) + Number(document.getElementById('personnelAirmen').value);
	}

	if(document.getElementById('personnelNcs').value != null && document.getElementById('personnelNcs').value != 0)
	{
		personnelTotal = Number(personnelTotal) + Number(document.getElementById('personnelNcs').value);
	}

	if(document.getElementById('personnelArmy').value != null && document.getElementById('personnelArmy').value != 0)
	{
		personnelTotal = Number(personnelTotal) + Number(document.getElementById('personnelArmy').value);
	}

	if(document.getElementById('personnelCivilian').value != null && document.getElementById('personnelCivilian').value != 0)
	{
		personnelTotal = Number(personnelTotal) + Number(document.getElementById('personnelCivilian').value);
	}	

	document.getElementById('personnelTotal').value = personnelTotal;
}

function wivesTotals(val){
	
	var wivesTotal=0;

	if(document.getElementById('wivesOfficer').value != null && document.getElementById('wivesOfficer').value != 0)
	{
		wivesTotal = Number(wivesTotal) + Number(document.getElementById('wivesOfficer').value);
	}

	if(document.getElementById('wivesAirmen').value != null && document.getElementById('wivesAirmen').value != 0)
	{
		wivesTotal = Number(wivesTotal) + Number(document.getElementById('wivesAirmen').value);
	}

	if(document.getElementById('wivesNcs').value != null && document.getElementById('wivesNcs').value != 0)
	{
		wivesTotal = Number(wivesTotal) + Number(document.getElementById('wivesNcs').value);
	}

	if(document.getElementById('wivesArmy').value != null && document.getElementById('wivesArmy').value != 0)
	{
		wivesTotal = Number(wivesTotal) + Number(document.getElementById('wivesArmy').value);
	}

	if(document.getElementById('wivesCivilian').value != null && document.getElementById('wivesCivilian').value != 0)
	{
		wivesTotal = Number(wivesTotal) + Number(document.getElementById('wivesCivilian').value);
	}	

	document.getElementById('wivesTotal').value = wivesTotal;
}

function childrenTotals(val){
	
	var childrenTotal=0;

	if(document.getElementById('childrenOfficer').value != null && document.getElementById('childrenOfficer').value != 0)
	{
		childrenTotal = Number(childrenTotal) + Number(document.getElementById('childrenOfficer').value);
	}

	if(document.getElementById('childrenAirmen').value != null && document.getElementById('childrenAirmen').value != 0)
	{
		childrenTotal = Number(childrenTotal) + Number(document.getElementById('childrenAirmen').value);
	}

	if(document.getElementById('childrenNcs').value != null && document.getElementById('childrenNcs').value != 0)
	{
		childrenTotal = Number(childrenTotal) + Number(document.getElementById('childrenNcs').value);
	}

	if(document.getElementById('childrenArmy').value != null && document.getElementById('childrenArmy').value != 0)
	{
		childrenTotal = Number(childrenTotal) + Number(document.getElementById('childrenArmy').value);
	}

	if(document.getElementById('childrenCivilian').value != null && document.getElementById('childrenCivilian').value != 0)
	{
		childrenTotal = Number(childrenTotal) + Number(document.getElementById('childrenCivilian').value);
	}	

	document.getElementById('childrenTotal').value = childrenTotal;
}

function totalTotals(val){
	
	var totalTotal=0;

	if(document.getElementById('totalOfficer').value != null && document.getElementById('totalOfficer').value != 0)
	{
		totalTotal = Number(totalTotal) + Number(document.getElementById('totalOfficer').value);
	}

	if(document.getElementById('totalAirmen').value != null && document.getElementById('totalAirmen').value != 0)
	{
		totalTotal = Number(totalTotal) + Number(document.getElementById('totalAirmen').value);
	}

	if(document.getElementById('totalNcs').value != null && document.getElementById('totalNcs').value != 0)
	{
		totalTotal = Number(totalTotal) + Number(document.getElementById('totalNcs').value);
	}

	if(document.getElementById('totalArmy').value != null && document.getElementById('totalArmy').value != 0)
	{
		totalTotal = Number(totalTotal) + Number(document.getElementById('totalArmy').value);
	}

	if(document.getElementById('totalCivilian').value != null && document.getElementById('totalCivilian').value != 0)
	{
		totalTotal = Number(totalTotal) + Number(document.getElementById('totalCivilian').value);
	}	

	document.getElementById('totalTotal').value = totalTotal;
}

	</script>
	
</form>