<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.ShoBreakDown"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
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
	
	<form name="shoAccommodation" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
   		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
   		List<MasUnit> unitList = new ArrayList<MasUnit>();
   		
   		if(map.get("unitList")!= null )
   		{
   			unitList= (List)map.get("unitList"); 
   		}
   			
   		  		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		%>
	
<div class="titleBg"><h2>Accommodation</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label>Current Date</label>
<input type="text"	id="currentDate" name="currentDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.shoAccommodation.currentDate,event)" />

<label>Unit<span>*</span></label>

<select name="unitId" validate="Unit Name, String, yes">
<option value="0">Select</option>
<%if(unitList!=null && unitList.size() >0){
	 for(MasUnit unit : unitList){
	%>
	<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	
<%}}%>
</select>

</div>

<h4>General Features</h4>

<table	id="Grid" class="cmntable">
	<tr>
	    <th>Category</th>
		<th colspan="2">Single</th>
		<th colspan="2">Married</th>
	</tr>
	
	<tr>
		<th></th>
		
		<th>E</th>
		<th>D</th>
		
		<th>E</th>
		<th>D</th>
	</tr>
	
	<tr>
		<th>Officers</th>
		
		<td><input type="text" MAXLENGTH="50" name="officersSingleE" id="officersSingleE" onblur="" validate="Officers Single E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="officersSingleD" id="officersSingleD" onblur="" validate="Officers Single D,int,no" onchange="" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="officersMarriedE" id="officersMarriedE" onblur="" validate="Officers Married E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="officersMarriedD" id="officersMarriedD" onblur="" validate="Officers Married D,int,no" onchange="" /></td>
		
	</tr>
	
	<tr>
		<th>Airmen</th>
		
		<td><input type="text" MAXLENGTH="50" name="airmenSingleE" id="airmenSingleE" onblur="" validate="Airmen Single E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="airmenSingleD" id="airmenSingleD" onblur="" validate="Airmen Single D,int,no" onchange="" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="airmenMarriedE" id="airmenMarriedE" onblur="" validate="Airmen Married E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="airmenMarriedD" id="airmenMarriedD" onblur="" validate="Airmen Married D,int,no" onchange="" /></td>
	</tr>
	
	<tr>
		<th>NCs(E)</th>
		
		<td><input type="text" MAXLENGTH="50" name="ncsSingleE" id="ncsSingleE" onblur="" validate="ncs Single E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="ncsSingleD" id="ncsSingleD" onblur="" validate="ncs Single D,int,no" onchange="" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="ncsMarriedE" id="ncsMarriedE" onblur="" validate="ncs Married E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="ncsMarriedD" id="ncsMarriedD" onblur="" validate="ncs Married D,int,no" onchange="" /></td>

	</tr>
	
	<tr>
		<th>DSC</th>
		
		<td><input type="text" MAXLENGTH="50" name="dscSingleE" id="dscSingleE" onblur="" validate="dsc Single E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="dscSingleD" id="dscSingleE" onblur="" validate="dsc Single D,int,no" onchange="" /></td> 
		
		<td><input type="text" MAXLENGTH="50" name="dscMarriedE" id="dscSingleE" onblur="" validate="dsc Married E,int,no" onchange="" /></td>
		
		<td><input type="text" MAXLENGTH="50" name="dscMarriedD" id="dscSingleE" onblur="" validate="dsc Married D,int,no" onchange="" /></td>

	</tr>

</table>

<div class="Block">

<label class="large">Lighting Arrangement</label>
<input type="text" name="lightingArrangement" class="auto" size="100" MAXLENGTH="100"/>

<div class="clear"></div>

<label class="large">Ventilation</label>
<input type="text" name="ventilation" class="auto" size="100" MAXLENGTH="100" />

<div class="clear"></div>

<label class="large">Cooling Arrangement</label>
<input type="text" name="coolingArrangement" class="auto" size="100" MAXLENGTH="100" />

<div class="clear"></div>

<label class="large">Heating Arrangement</label>
<input type="text" name="heatingArrangement" class="auto" size="100" MAXLENGTH="100" />

<label class="large">Remarks</label>
<input type="text" name="remarks" class="auto" size="100" MAXLENGTH="200" />

</div>


 <div class="clear paddingTop15"></div>

<input type="button" name="Submit" value="Submit"  onClick= "submitForm('shoAccommodation','/hms/hms/mis?method=submitShoAccommodationJSP');" class="button" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('shoAccommodation','/hms/hms/mis?method=showShoAccommodation');" accesskey="r" />



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