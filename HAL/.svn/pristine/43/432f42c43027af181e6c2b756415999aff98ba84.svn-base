
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
	 var masRelationArray=new Array();
	<%
	Date d=new Date();
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}
	
	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	List<MasPersonnelDetails> masPersonnelDetailsList= new ArrayList<MasPersonnelDetails>();
	if(map.get("masPersonnelDetailsList") != null){
		masPersonnelDetailsList=(List)map.get("masPersonnelDetailsList");
	}
	MasPersonnelDetails masPersonnelDetails=masPersonnelDetailsList.get(0);
	
	
	
	if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>


<div id="contentHolder">
<form name="calculationSheet" method="post">
<h6>Calculation Sheet</h6>
<div class="Clear"></div>
<div class="blockTitle">1</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">a.)</label><label
	class="large"> Name </label> <label class="value"><%=masPersonnelDetails.getPersonnelName() %></label>

<label class="small">b.)</label><label class="large">Appointment
Held</label> <label class="value"><%=masPersonnelDetails.getUnit().getUnitName() %>
</label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">c.)</label><label class="large">Office From
Which Retired </label> <input name="acNo" type="text" maxlength="25" /> <label
	class="small">d.)</label><label class="large">Date of Birth</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getDateOfBirth()) %>
</label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">e.)</label><label class="large">Date of
Appointment</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getAppointmentDate()) %>
</label> <label class="small">f.)</label><label class="large">Date of
Retirement</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getRetirementDate()) %>
</label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">g.)</label><label class="large"><span>*</span>Class
of Pension</label> <select name="pensionClass"
	validate="Pension Class,string,yes">
	<option value="0">Select</option>
	<option value="Superannutation">Superannutation</option>
	<option value="VRS">VRS</option>
	<option value="Death">Death</option>
	<option value="Medically Boarded Out">Medically Boarded Out</option>


</select> <label class="small">h.)</label><label class="large"><span>*</span>Pension
Rules By Which Governed</label> <input name="pensionRules" type="text"
	maxlength="50" validate="Pension Rules,string,yes" />
<div class="Clear"></div>



</div>
<div class="Clear"></div>
<div class="blockTitle">2</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">a.)</label>
<h5>Regular/Permanent Services</h5>
<label class="medium">From </label> <input type="text" class="calDate"
	id="postingInDate" name="postingInDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getPostingIn()) %>"
	readonly="readonly" /> <!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.calculationSheet.postingInDate,event)"/> -->

<label class="medium">To Date</label> <input type="text" class="calDate"
	id="postingOutDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getRetirementDate())%>"
	name="postingOutDate" readonly="readonly" /> <!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onClick="setdate('',document.calculationSheet.postingOutDate,event)"/> -->

<div class="Clear"></div>
<div class="division"></div>
<h5>Total Service Without EOL</h5>
<label class="medium">Years</label> <label class="valueMedium"><%=masPersonnelDetails.getTotalServiceWithoutEolYears() %>
</label> <label class="medium">Months</label> <label class="valueMedium"><%=masPersonnelDetails.getTotalServiceWithoutEolMonths() %>
</label> <label class="medium">Days</label> <label class="valueMedium"><%=masPersonnelDetails.getTotalServiceWithoutEolDays() %>
</label> <input type="hidden" name="totalServiceWithoutEolInYears"
	id="totalServiceWithoutEolInYears"
	value="<%=masPersonnelDetails.getTotalServiceWithoutEolYears() %>" /> <input
	type="hidden" name="totalServiceWithoutEolInMonths"
	id="totalServiceWithoutEolInMonths"
	value="<%=masPersonnelDetails.getTotalServiceWithoutEolMonths() %>" />
<input type="hidden" name="totalServiceWithoutEolInDays"
	id="totalServiceWithoutEolInDays"
	value="<%=masPersonnelDetails.getTotalServiceWithoutEolDays() %>" />

<div class="Clear"></div>
<div class="division"></div>
<label class="small">b.)</label>
<h5>Other Services</h5>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" class="cmnButton" value="Add"
	onclick="addRowForOtherServices();" /> <input type="button"
	class="cmnButton" value="Remove" onclick="removeRowForOtherServices();" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="gridForOtherServices">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col" colspan="2">From Date</th>
		<th scope="col" colspan="2">To Date</th>
		<th scope="col">Other Service In year,month,Days</th>

	</tr>
	<tr>
		<td><input type="text" name="srNo" size="2" value="1" readonly /></td>

		<td><input type="text" name="fromDate1" id="fromDate1" size="12" 
			readonly /></td>
		<td><img src="/hms/jsp/images/cal.gif" id="calId1" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.fromDate1,event)" /></td>
		<td>
		  <input type="text" name="toDDate1" size="12" id="toDDate1"onblur="calculateDaysForOtherServicesNew();" readonly />
		<!--<input type="text" name="toDDate1" size="12" id="toDDate1"onblur="dateDiffernce1()" readonly />-->
		
		</td>
			
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.toDDate1,event)" /></td>
		<td><input type="text" size="5" name="otherServiceInYears1"
			id="otherServiceInYears1" readonly /> Year <input type="text"
			size="5" name="otherServiceInMonths1" id="otherServiceInMonths1"
			readonly /> Month <input type="text" size="5"
			name="otherServiceInDays1" id="otherServiceInDays1" readonly /> Days
		</td>

	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />

</table>
</div>
<div class="Clear"></div>
</div>
<div class="blockFrame">
<h5>Total Qualifying Service</h5>
<label class="medium"> Years</label> <input
	id="totalQualifyingServiceYears" class="calDate" type="text" readonly />
<label class="medium">Months</label> <input
	id="totalQualifyingServiceMonths" class="calDate" type="text" readonly />
<label class="medium">Days</label> <input
	id="totalQualifyingServiceDays" class="calDate" type="text" readonly />
	
	
</div>

<script type="text/javascript">
	
	function addRowForOtherServices(){
	
	  var tbl = document.getElementById('gridForOtherServices');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
 
 	 var cellRight = row.insertCell(0);
	  var e = document.createElement('input');
	  e.type = 'text';
	  e.readOnly = true;
	  e.size='2'
	  e.name = 'srNo' + iteration;
	  e.id = 'srNo' + iteration;
	 
	  e.value = iteration;
	  cellRight.appendChild(e);	
 
	 
	  
	 
  
	  var cellRight2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '12';
	  e2.name='fromDate'+iteration;
	  e2.id='fromDate'+iteration;
	  e2.readOnly = true;
	  
	  cellRight2.appendChild(e2); 
	   // eImg.style.display ='none';
	
	 
	  var cellRight3 = row.insertCell(2);
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
	  setdate('',document.getElementById('fromDate'+iteration),event) };
	  
	  cellRight3.appendChild(eImg);
	  
	  
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '12';
	  e3.name='toDDate'+iteration;
	  e3.id='toDDate'+iteration;
	  e3.readOnly = true;
	  e3.onblur= function(){
	  //dateDiffernce1();}
	 // calculateDaysForOtherServices();
	  calculateDaysForOtherServicesNew();}
	  
	  cellRight4.appendChild(e3);
	  
	  
	  
	  var cellRight5 = row.insertCell(4);
	  var eImg1 = document.createElement('img');
	  eImg1.src = '/hms/jsp/images/cal.gif';
	  eImg1.id = 'callId'+iteration;
	  eImg1.onclick = function(event){
	  setdate('',document.getElementById('toDDate'+iteration),event) };
	 
	  cellRight5.appendChild(eImg1);
	  
	  

	  var cellRight6 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='otherServiceInYears'+iteration;
	  e4.id='otherServiceInYears'+iteration;
	  e4.size='5'
	  e4.readOnly = true;
	  cellRight6.appendChild(e4); 
	  
	  var ey = document.createTextNode(' Year ');
	  cellRight6.appendChild(ey); 
	  
	  // var cellRight4 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='otherServiceInMonths'+iteration;
	  e5.id='otherServiceInMonths'+iteration;
	  e5.size='5'
	  e5.readOnly = true;
	  cellRight6.appendChild(e5);
	  
	  var em = document.createTextNode('   Months   ');
	  cellRight6.appendChild(em); 
	  
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='otherServiceInDays'+iteration;
	  e6.id='otherServiceInDays'+iteration;
	  e6.size='5'
	  e6.readOnly = true;
	  cellRight6.appendChild(e6);  
	  
	  var ed = document.createTextNode('   Days   ');
	  cellRight6.appendChild(ed); 
	   
	}
	
	function removeRowForOtherServices()
	{
	  var tbl = document.getElementById('gridForOtherServices');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	
	</script>
<div class="Clear"></div>
<div class="blockFrame"><label>EOL Data Form</label> <input
	type="button" class="cmnButton" value="Add" onclick="addRowForEol();" />
<input type="button" class="cmnButton" value="Remove"
	onclick="removeRowForEol();" />
<div class="Clear"></div>
<div class="tableHolderAuto"
	style="border-bottom: none; margin-bottom: 0px;">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="gridForEol">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col" colspan="2">From Date</th>
		<th scope="col" colspan="2">To Date</th>
		<th scope="col">EOL in Years,Months,Days</th>
	</tr>
	<tr>
		<td><input type="text" name="srNo" size="2" value="1" readonly /></td>

		<td><input name="fromDateForEol1" size="12" id="fromDateForEol1"
			type="text" /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.fromDateForEol1,event)" />
		<!-- <img id="calId1 %>" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"  validate="Pick a date"
			class="calender" onclick="setdate('',document.getElementById('dateOfBirth1'),event)" />
	 --></td>
		<td><input type="text" size="12" name="toDateForEOL1" tabindex="1"
			onblur="calculateDaysForEOLNew();dateDiffernceEOL();" id="toDateForEOL1" readonly /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.toDateForEOL1,event)" />
		</td>
		<td><input type="text" name="eolYears1" value="" size="5"
			id="eolYears1" readonly /> Year <input type="text" name="eolMonths1"
			value="" size="5" id="eolMonths1" readonly /> Months <input
			type="text" name="eolDays1" value="" size="5" id="eolDays1" readonly />
		Days</td>

	</tr>
	

</table>

</div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="gridForEol">
	<tr>
		<td scope="col" class="" />
		<td scope="col" class="" />
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		<td scope="col"></td>
		
		<td class="highlight" scope="col">Total EOL</td>
		<td scope="col"><input id="totalEOLYears" type="text" size="5"
			value="" readonly /> Year <input id="totalEOLMonths" type="text"
			size="5" value="" readonly /> Months <input id="totalEOLDays"
			type="text" size="5" value="" readonly /> Days</td>
	</tr>

</table>
<input type="hidden" id="eolValue" name="eolValue" value="1" />
</div>
<div class="Clear"></div>

</div>
<script type="text/javascript">
	
	function addRowForEol(){
	
	  var tbl = document.getElementById('gridForEol');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var vForEol = document.getElementById('eolValue');
	  vForEol.value=iteration
 		
 		
 	 var cellRight = row.insertCell(0);
	  var e = document.createElement('input');
	  e.type = 'text';
	  e.readOnly = true;
	  e.size='2'
	  e.name = 'srNo' + iteration;
	  e.id = 'srNo' + iteration;
	 
	  e.value = iteration;
	  cellRight.appendChild(e);	
  
	  var cellRight2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '12'
	  e2.name='fromDateForEol'+iteration;
	  e2.id='fromDateForEol'+iteration;
	  e2.readOnly = true;
	  
	  cellRight2.appendChild(e2); 
	  
	  
	  var cellRight3 = row.insertCell(2);
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
	  setdate('',document.getElementById('fromDateForEol'+iteration),event) };
	  cellRight3.appendChild(eImg);
	  //<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  onClick="setdate('document.personnelEntry.dateOfBirth'"+iteration+",'event')"/>
	  
	  
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '12'
	  e3.name='toDateForEOL'+iteration;
	  e3.id='toDateForEOL'+iteration;
	  e3.readOnly = true;
	  e3.onblur= function(){
					calculateDaysForEOLNew();dateDiffernceEOL();}
	  cellRight4.appendChild(e3);
	   
	   
	   var cellRight5 = row.insertCell(4);
	   var eImg1 = document.createElement('img');
	   eImg1.src = '/hms/jsp/images/cal.gif';
	   eImg1.id = 'callId'+iteration;
	  eImg1.onclick = function(event){
	  setdate('',document.getElementById('toDateForEOL'+iteration),event) };
	  
	  cellRight5.appendChild(eImg1);
	  
	  var cellRight6 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.readOnly = true;
	  e4.size='5'
	  e4.name = 'eolYears' + iteration;
	  e4.id = 'eolYears' + iteration;
	  cellRight6.appendChild(e4);
	  
	  var ey = document.createTextNode(' Year ')
	  cellRight6.appendChild(ey);
	  
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.readOnly = true;
	  e5.size= '5'
	  e5.name = 'eolMonths' + iteration;
	  e5.id = 'eolMonths' + iteration;
	  cellRight6.appendChild(e5);
	  
	  var em = document.createTextNode(' Months ')
	  cellRight6.appendChild(em);
	  
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.readOnly = true;
	  e6.size = '5'
	  e6.name = 'eolDays' + iteration;
	  e6.id = 'eolDays' + iteration;
	  cellRight6.appendChild(e6);	
	  
	  var ed = document.createTextNode(' Days ')
	  cellRight6.appendChild(ed);
	   
	}
	
	function removeRowForEol()
	{
	  var tbl = document.getElementById('gridForEol');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	
	</script>
<div class="Clear"></div>
<div class="blockFrame">
<h5>Net Qualifying Service</h5>
<label class="medium">Years</label> 
<input class="calDate" id="netQualifyingServiceInYears" name="netQualifyingServiceInYears" type="text" readonly /> 
<label class="medium">Months</label> 
<input id="netQualifyingServiceInMonths" class="calDate" name="netQualifyingServiceInMonths" type="text" readonly /> 
<label class="medium">Days</label> 
<input id="netQualifyingServiceInDays" class="calDate" name="netQualifyingServiceInDays" type="text" readonly />
</div>
<div class="Clear"></div>
<div class="blockFrame">

<div class="Clear"></div>
<h5>Emoluments For Pension</h5>
<div class="Clear"></div>
<input type="button" class="cmnButton" value="Add"
	onclick="addRowForEmol();" /> <input type="button" class="cmnButton"
	value="Remove" onclick="removeRowForEmol();" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="gridForEmol">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col" colspan="2">From Date</th>
		<th scope="col" colspan="2">To Date</th>
		<th scope="col">Basic Pay</th>
		<th scope="col">Grade pay</th>
		<th scope="col">Stagn</th>
		<th scope="col">Rank Pay</th>
		<th scope="col">DP</th>
		<th scope="col">NPA</th>
		<th scope="col">Others</th>
		<th scope="col">DA</th>
		<th scope="col">No Of Months</th>
		<th scope="col">Total Emol</th>
	</tr>
	<tr>
		<td><input type="text" name="srNo" size="2" value="1" readonly /></td>

		<td><input name="fromDateForEmolu1" size="12"
			id="fromDateForEmolu1" tabindex="1" type="text" /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.fromDateForEmolu1,event)" />
		<!-- <img id="calId1 %>" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"  validate="Pick a date"
			class="calender" onclick="setdate('',document.getElementById('dateOfBirth1'),event)" />
	 --></td>
		<td><input type="text" name="toDateForEmolu1" tabindex="1"
			tabindex="1" size="12" id="toDateForEmolu1" readonly /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.calculationSheet.toDateForEmolu1,event)" />
		</td>
		<td><input type="text" size="8" tabindex="1" name="basicPay1"
			 value="" id="basicPay1" onblur="calculateTotalEmol('1');"
			maxlength="7" /></td>
			
		<td><input type="text" size="8" tabindex="1" name="gradePay1"
			value="" id="gradePay1" maxlength="7" onblur="calculateTotalEmol('1');" /></td>
		<td><input type="text" size="5" tabindex="1" name="stagn1"
			value="" id="stagn1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
		<td><input type="text" size="5" tabindex="1" name="rankPay1"
			value="" id="rankPay1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
				
			
		<td><input type="text" size="5" tabindex="1" name="dp1" value=""
			id="dp1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
		<td><input type="text" size="5" tabindex="1" name="npa1" value=""
			id="npa1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
		<td><input type="text" size="5" tabindex="1" name="others1"
			value="" id="others1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
		<td><input type="text" size="5" tabindex="1" name="da1" value=""
			id="da1" maxlength="7" onblur="calculateTotalEmol('1');"/></td>
		<td><input type="text" size="5" tabindex="1" name="noOfMonths1" onclick="calculateTotalEmol('1')" onblur="calculateTotalEmol('1');"		
			value="0" id="noOfMonths1" maxlength="4" /></td>
		<td><input type="text" size="9" tabindex="1" name="totalEmol1"
			onclick="calculateTotalEmol('1')" value="" id="totalEmol1" maxlength="7" /></td>
		<input type="hidden" name="emol" value="1" id="emol" />
	</tr>


</table>
</div>
<div class="Clear"></div>

</div>
<div class="division"></div>
<div class="bottom"><input id="serviceInDays" name="serviceInDays"
	type="hidden" value="" /> <input type="hidden" name="personnelId"
	value="<%=masPersonnelDetails.getId()%>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input name="Submit"
	type="button" class="button" value="Save"
	onclick="submitForm('calculationSheet','pension?method=submitCalculationSheetDetails')" />
<input name="Button" type="button" class="button" value="Reset" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>
</form>
</div>

<script type="text/javascript">
	function addRowForEmol(){
	
	  var tbl = document.getElementById('gridForEmol');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var emol = document.getElementById('emol');
	  emol.value=iteration
 
 	 var cellRight = row.insertCell(0);
	  var e = document.createElement('input');
	  e.type = 'text';
	  e.readOnly = true;
	  e.size='2'
	  e.name = 'srNo' + iteration;
	  e.id = 'srNo' + iteration;
	 
	  e.value = iteration;
	  cellRight.appendChild(e);	
   
	  var cellRight2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '12'
	  e2.name='fromDateForEmolu'+iteration;
	  e2.id='fromDateForEmolu'+iteration;
	  e2.readOnly = true;
	  cellRight2.appendChild(e2); 
	  
	  
	  var cellRight3 = row.insertCell(2);
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
	  setdate('',document.getElementById('fromDateForEmolu'+iteration),event) };
	  
	  cellRight3.appendChild(eImg);
	  //<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  onClick="setdate('document.personnelEntry.dateOfBirth'"+iteration+",'event')"/>
	  
	  
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '12'
	  e3.name='toDateForEmolu'+iteration;
	  e3.id='toDateForEmolu'+iteration;
	  e3.readOnly = true;
	  
	  cellRight4.appendChild(e3);
	   
	   
	   var cellRight5 = row.insertCell(4);
	   var eImg1 = document.createElement('img');
	   eImg1.src = '/hms/jsp/images/cal.gif';
 	   eImg1.id = 'callId'+iteration;
	   eImg1.onclick = function(event){
	   setdate('',document.getElementById('toDateForEmolu'+iteration),event) };
	  
	  cellRight5.appendChild(eImg1);
	  
	  
	  var cellRight6 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  
	  e4.size = '8'
	  e4.maxLength="7"
	  e4.name = 'basicPay' + iteration;
	  e4.id = 'basicPay' + iteration;
	  e4.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight6.appendChild(e4);
	  
	  //pankaj
	  var cellRight7 = row.insertCell(6);
	  var e44 = document.createElement('input');
	  e44.type = 'text';
	  e44.maxLength="7"
	  e44.size = '8'
	  e44.name = 'gradePay' + iteration;
	  e44.id = 'gradePay' + iteration;
	  e44.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight7.appendChild(e44);
	  
	  //pankaj
	  
	  var cellRight8 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.maxLength="7"
	  e5.size = '5'
	  e5.name = 'stagn' + iteration;
	  e5.id = 'stagn' + iteration;
	  e5.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight8.appendChild(e5);	
	  
	  
	  var cellRight9 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.maxLength="7"
	  e6.size = '5'
	  e6.name = 'rankPay' + iteration;
	  e6.id = 'rankPay' + iteration;
	  e6.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight9.appendChild(e6);
	  
	   var cellRight10 = row.insertCell(9);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.maxLength="7"
	  e7.size = '5'
	  e7.name = 'dp' + iteration;
	  e7.id = 'dp' + iteration;
	  e7.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight10.appendChild(e7);
	  
	   var cellRight11 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.maxLength="7"
	  e8.size = '5'
	  e8.name = 'npa' + iteration;
	  e8.id = 'npa' + iteration;
	  e8.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight11.appendChild(e8);		
	  
	   var cellRight12 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.maxLength="7"
	  e9.size = '5'
	  e9.name = 'others' + iteration;
	  e9.id = 'others' + iteration;
	  e9.onblur = function(){calculateTotalEmol(iteration);}
	  cellRight12.appendChild(e9);
	  
	   var cellRight13 = row.insertCell(12);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.maxLength="7"
	  e10.size = '5'
	  e10.name = 'da' + iteration;
	  e10.id = 'da' + iteration;
	  e10.onblur = function(){ calculateTotalEmol(iteration);}
	  cellRight13.appendChild(e10);
	  
	   var cellRight14 = row.insertCell(13);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.maxLength="4"
	  e11.size = '5'
	  e11.value='0' 
	  e11.name = 'noOfMonths' + iteration;
	  e11.id = 'noOfMonths' + iteration;
	  e11.onclick=function(){ calculateTotalEmol(iteration);}
	  e11.onblur=function(){ calculateTotalEmol(iteration);}
	  cellRight14.appendChild(e11);
	  
	   var cellRight15 = row.insertCell(14);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.maxLength="7"
	  e12.size = '8'
	  e12.name = 'totalEmol' + iteration;
	  e12.id = 'totalEmol' + iteration;
	  e12.onclick=function(){ calculateTotalEmol(iteration);}
	  cellRight15.appendChild(e12);
	  
	   
	}
	
	function removeRowForEmol()
	{
	  var tbl = document.getElementById('gridForEmol');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	function calculateDaysForOtherServicesNew(){
	  
		var day1, day2;
		var month1, month2;
		var year1, year2;
		
		
		document.getElementById('totalQualifyingServiceYears').value="";
		document.getElementById('totalQualifyingServiceDays').value="";
		document.getElementById('totalQualifyingServiceMonths').value="";
		for(var i=1;i<=document.getElementById('hdb').value;i++)
		{
		var totalDays,totalMonths,totalYears;
		value1 = document.getElementById('fromDate'+i).value;
		value2 =document.getElementById('toDDate'+i).value;
		
		//var yearMonthDays=calculateYearMonthDays(value1,value2);
		var yearMonthDays=dateDiffernce1(value1,value2);
		
		
		years = yearMonthDays.substring (0, yearMonthDays.indexOf (","));
		months = yearMonthDays.substring (yearMonthDays.indexOf (",")+1, yearMonthDays.lastIndexOf (","));
		days = yearMonthDays.substring (yearMonthDays.lastIndexOf (",")+1, yearMonthDays.length);
		//days = parseInt(days)-1;
		document.getElementById('otherServiceInDays'+i).value =days;
		document.getElementById('otherServiceInMonths'+i).value =months;
		document.getElementById('otherServiceInYears'+i).value =years;
   
			var totalServiceInYears=parseInt(document.getElementById('totalQualifyingServiceYears').value);
			var totalServiceWithoutEolInYears=parseInt(document.getElementById('totalServiceWithoutEolInYears').value);
			
			var totalServiceInMonths=parseInt(document.getElementById('totalQualifyingServiceMonths').value);
			var totalServiceWithoutEolInMonths=parseInt(document.getElementById('totalServiceWithoutEolInMonths').value);
			
			var totalServiceInDays=parseInt(document.getElementById('totalQualifyingServiceDays').value);
			var totalServiceWithoutEolInDays=parseInt(document.getElementById('totalServiceWithoutEolInDays').value);
			
				
			//alert("totalServiceInMonths==="+totalServiceInMonths)
		if(isNaN(totalServiceInYears)){
		  totalYears=totalServiceWithoutEolInYears+parseInt(years);
		  document.getElementById('totalQualifyingServiceYears').value=totalYears;
		// alert("in if totalQualifyingServiceYears===="+document.getElementById('totalQualifyingServiceYears').value)
		  }else{
		  var tService=totalServiceInYears + parseInt(years);
		  document.getElementById('totalQualifyingServiceYears').value=tService;
		  }
		if(isNaN(totalServiceInMonths)){
		  totalMonths=totalServiceWithoutEolInMonths+parseInt(months);
		  if(totalMonths>=12){
		    totalMonths=totalMonths-12;
		    var totalYearsChanged=parseInt(document.getElementById('totalQualifyingServiceYears').value)
		    document.getElementById('totalQualifyingServiceYears').value=totalYearsChanged+1;
		  }
		  document.getElementById('totalQualifyingServiceMonths').value=totalMonths;
		//alert("in if totalQualifyingServiceMonths===="+document.getElementById('totalQualifyingServiceMonths').value)
		  }else{
		  var tService=totalServiceInMonths + parseInt(months);
		  if(tService>=12){
		  	tService=tService-12;
		  	var totalYearsChanged=parseInt(document.getElementById('totalQualifyingServiceYears').value)
		  	document.getElementById('totalQualifyingServiceYears').value=totalYearsChanged+1;
		  	
		  }
		  document.getElementById('totalQualifyingServiceMonths').value=tService;
		  } 
		if(isNaN(totalServiceInDays)){
		  totalDays=totalServiceWithoutEolInDays+parseInt(days);
		  if(totalDays>30){
		    totalDays=totalDays-30;
		     var totalMonthsChanged=parseInt(document.getElementById('totalQualifyingServiceMonths').value)
		   //  alert("totalMonthsChanged==="+totalMonthsChanged);
		     document.getElementById('totalQualifyingServiceMonths').value=totalMonthsChanged+1;
		  }
		  document.getElementById('totalQualifyingServiceDays').value=totalDays;
		//alert("in if totalQualifyingServiceDays===="+document.getElementById('totalQualifyingServiceDays').value)
		  }else{
		  var tServiceInDays=totalServiceInDays + parseInt(days);
		  if(tServiceInDays>30){
		  	 tServiceInDays=tServiceInDays-30;
		     var totalMonthsChanged=parseInt(document.getElementById('totalQualifyingServiceMonths').value)
		    // alert("totalMonthsChanged==="+totalMonthsChanged);
		     document.getElementById('totalQualifyingServiceMonths').value=totalMonthsChanged+1;
		  }
		  //alert("in else tService===="+tService)
		  document.getElementById('totalQualifyingServiceDays').value=tServiceInDays;
		  }
		 		 
		}
		}
/*	
function dateDiffernce1(value1,value2){
	       var day1 ;
		  var month1;
		  var year1 ;
		  var day2 ;
		 var month2;
		  var year2 ;
		var DaysDiff;
		var MonthDiff;
		var YearDiff;
		
			//obj1 = document.getElementById('toDDate1').value;
			day2 = value1.substring (0, value1.indexOf ("/"));
			month2 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
			year22 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
			year2 = parseInt(value1.substring (value1.lastIndexOf ("/")+1, value1.length));

			//obj2 = document.getElementById('fromDate1').value;
			day1 = value2.substring (0, value2.indexOf ("/"));
			month1 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
			year11 = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
			year1 = parseInt(value2.substring (value2.lastIndexOf ("/")+1, value2.length));
	
	
			if (day1==day2) {
				if (month1==month2) {
					if (year1==year2) {
						DaysDiff=1;
						MonthDiff=0;
						YearDiff=0;						
					}else {
						if (year1>year2) {
							DaysDiff=1;
							MonthDiff=0;
							YearDiff=parseInt(year1)-parseInt(year2);							
						}
						else {
							  alert("To Date should be greater then From Date.")
							   return false;
						}
					}
					
				} else {
					if (month1>month2) {
						if (year1==year2) {
							
							DaysDiff=1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);
						}else {
							if (year1>year2) {
								DaysDiff=1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  alert("To Date should be greater then From Date.")
								   return false;
							}
							
						}
						
					}else {
                           if (year1==year2) {
							
                        	   alert("To Date should be greater then From Date.")
							   return false;
						}else {
							if (year1>year2) {
								DaysDiff=1;
								month1=parseInt(month1)+12;
								year1=parseInt(year1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  alert("To Date should be greater then From Date.")
								   return false;
							}
							
						}
						
					}
					
				}
				
			}
			else {
				if (day1>day2) {
					if (month1==month2) {
						if (year1==year2) {	
							
							DaysDiff=(parseInt(day1)-parseInt(day2))+1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);	
						}else {
							if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
															
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("To Date should be greater then From Date.")
								   return false;
							}
						}
					}else {
						if (month1>month2) {
							if (year1==year2) {	
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("To Date should be greater then From Date.")
								   return false;
							}
								
							}
							
						}else {
							if (year1==year2) {	
								alert("To Date should be greater then From Date.")
								   return false;
							}else {
								if (year1>year2) {
									
									month1=parseInt(month1)+12;
									year1=parseInt(year1)-1;
									DaysDiff=(parseInt(day1)-parseInt(day2))+1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
							}
						}
					}
				}else {
					if (month1==month2) {
						if (year1==year2) {	
							alert("To Date should be greater then From Date.")
							return false;
						}else {
							if (year1>year2) {
								day2=31-parseInt(day2);												
								
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)+12;
								MonthDiff=parseInt(month1)-parseInt(month2);
								MonthDiff=parseInt(MonthDiff)-1;
								year1=parseInt(year1)-1;
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								alert("To Date should be greater then From Date.")
								return false;
							}
						}
					}else {
					 
						if (month1>month2) {
							if (year1==year2) {	
							 
								day2=31-parseInt(day2);
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff = parseInt(day1) +parseInt(day2);
									month1=parseInt(month1)-1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
							}
							
						}else {
							if (year1==year2) {	
								alert("To Date should be greater then From Date.")
								return false;
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff= parseInt(day2)+parseInt(day1);
									month1=parseInt(month1)+12;
								
									MonthDiff=parseInt(month1)-parseInt(month2);
									
									MonthDiff=parseInt(MonthDiff)-1;
									year1=parseInt(year1)-1;
									YearDiff=parseInt(year1)-parseInt(year2);
									
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
								
							}
						}
					}
				}
				
			}



             //  document.getElementById('otherServiceInDays1').value=DaysDiff;
	     //  document.getElementById('otherServiceInMonths1').value=MonthDiff;
	      // document.getElementById('otherServiceInYears1').value=YearDiff;


return YearDiff+","+MonthDiff+","+DaysDiff;
}*/

//===========Vishal Change function==========

function dateDiffernce1(value1,value2){
	       var day1 ;
		   var month1;
		   var year1 ;
		   var day2 ;
		   var month2;
		   var year2 ;
		   var DaysDiff;
		   var MonthDiff;
		   var YearDiff;
		 
			//obj1 = document.getElementById('toDDate1').value;
			day2 = value1.substring (0, value1.indexOf ("/"));
			month2 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
			year22 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
			year2 = parseInt(value1.substring (value1.lastIndexOf ("/")+1, value1.length));

			//obj2 = document.getElementById('fromDate1').value;
			day1   = value2.substring (0, value2.indexOf ("/"));
			month1 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
			year11 = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
			year1  = parseInt(value2.substring (value2.lastIndexOf ("/")+1, value2.length));
	
	
	
	
			
			
			
			
			if (day1==day2) {
				if (month1==month2) {
					if (year1==year2) {
						DaysDiff=1;
						MonthDiff=0;
						YearDiff=0;						
					}else {
						if (year1>year2) {
							DaysDiff=1;
							MonthDiff=0;
							YearDiff=parseInt(year1)-parseInt(year2);							
						}
						else {
							  alert("To Date should be greater then From Date.")
							   return false;
						}
					}
					
				} else {
					if (month1>month2) {
						if (year1==year2) {
							
							DaysDiff=1;
							MonthDiff= month1-month2;
							YearDiff=parseInt(year1)-parseInt(year2);
							
						}else {
							if (year1>year2) {
								DaysDiff=1;
								MonthDiff= month1- month2;
								YearDiff=parseInt(year1)-parseInt(year2);
							}
							else {
								  alert("To Date should be greater then From Date.")
								   return false;
							}
							
						}
						
					}else {
                           if (year1==year2) {
							
                        	   alert("To Date should be greater then From Date.")
							   return false;
						}else {
							if (year1>year2) {
								DaysDiff=1;
								month1=month1+12;
								year1=parseInt(year1)-1;
								MonthDiff= month1-month2 ;
								YearDiff=parseInt(year1)-parseInt(year2);
														
							}
							else {
								  alert("To Date should be greater then From Date.")
								   return false;
							}
							
						}
						
					}
					
				}
				
			}
			else {
				if (day1>day2) {
				//alert("if (day1>day2)");
						if (month1==month2) {
						if (year1==year2) {	
							
							DaysDiff=(parseInt(day1)-parseInt(day2))+1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							//monthChk = (parseInt(month1)-parseInt(month2)) + 1;
							YearDiff= parseInt(year1)-parseInt(year2);
							//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
									
									
								 if(month1==4 || month1==6 || month1==9 || month1==11  ){
									if(DaysDiff >=30 ){
								       DaysDiff = 0;
									   MonthDiff = MonthDiff+1;
									   if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									   }  
									} 
							    }	
							 
						      }			
							}			
						}else {
							if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
								else{ if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
							}else {
								alert("To Date should be greater then From Date.")
								   return false;
							}
						}
					}else {
						if (month1>month2) {
						  alert("if month1>month2");
							if (year1==year2) {	
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff = month1-month2;
								YearDiff=parseInt(year1)-parseInt(year2);	
								alert("month1-pp== "+month1);
								alert("month2-- == "+month2);
								alert("MonthDiff--kk "+MonthDiff);
								
								
							//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
									
									
									
									
									 
							}else {if (year1>year2) {
							
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=month1-month2;
								YearDiff=parseInt(year1)-parseInt(year2);
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								
																
							}else {
								alert("To Date should be greater then From Date.")
								   return false;
							}
								
							}
							
						}else {
							if (year1==year2) {	
								alert("To Date should be greater then From Date.")
								   return false;
							}else {
								if (year1>year2) {
									
									month1=parseInt(month1)+12;
									year1=parseInt(year1)-1;
									DaysDiff=(parseInt(day1)-parseInt(day2))+1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									
										//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
									
									
									 
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
							}
						}
					}
				}else {
			
				    
					if (month1==month2) {
					   	if (year1==year2) {	
							alert("To Date should be greater then From Date.")
							return false;
						}else {
							if (year1>year2) {
								day2=31-parseInt(day2);												
								
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)+12;
								MonthDiff=parseInt(month1)-parseInt(month2);
								MonthDiff=parseInt(MonthDiff)-1;
								year1=parseInt(year1)-1;
								YearDiff=parseInt(year1)-parseInt(year2);
								
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								 
							}else {
								alert("To Date should be greater then From Date.")
								return false;
							}
						}
					}else {
							if (month1>month2) {
							if (year1==year2) {	
								day2=31-parseInt(day2);
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
								
								
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								
								
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									DaysDiff = parseInt(day1) +parseInt(day2);
									month1=parseInt(month1)-1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									
									//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								     
								     
								     
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
							}
							
						}else {
							if (year1==year2) {	
								alert("To Date should be greater then From Date.")
								return false;
							}else {
								if (year1>year2) {	
							
								
									day2=31-parseInt(day2);
									DaysDiff= parseInt(day2)+parseInt(day1);
									month1=parseInt(month1)+12;
								    MonthDiff=parseInt(month1)-parseInt(month2);
									MonthDiff=parseInt(MonthDiff)-1;
									year1=parseInt(year1)-1;
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								     
								      									
									
								}else {
									alert("To Date should be greater then From Date.")
									return false;
								}
								
							}
						}
					}
				}
				
			}

			

         //  document.getElementById('serviceDays').value=DaysDiff;
	     //  document.getElementById('serviceMonths').value=MonthDiff;
	     //  document.getElementById('serviceYears').value=YearDiff;
	       return YearDiff+","+MonthDiff+","+DaysDiff;
}



//===============================================
	
	function calculateTotalEmol(iteration){
	  
		var day1, day2;
		var month1, month2;
		var year1, year2;
		
		//alert("in calculateTotalEmol iteration-----"+iteration)
		
		
		
		value1 = document.getElementById('fromDateForEmolu'+iteration).value;
		value2 =document.getElementById('toDateForEmolu'+iteration).value;
		if(value1 != "" && value2 != ""){
		//alert("value1=="+value1+"=====value2===="+value2)
		
		
		day1 = value1.substring (0, value1.indexOf ("/"));
		month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
		
		day2 = value2.substring (0, value2.indexOf ("/"));
		month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
		
		date1 = year1+"/"+month1+"/"+day1;
		date2 = year2+"/"+month2+"/"+day2;
		
		firstDate = Date.parse(date1)
		secondDate= Date.parse(date2)
		
		msPerDay = 24 * 60 * 60 * 1000
	    	dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
			
			 differenceOfDate=dbd.valueOf();
	 		
		var basicPay=parseInt(document.getElementById('basicPay'+iteration).value);		
		var gradePay=parseInt(document.getElementById('gradePay'+iteration).value);
			if(isNaN(gradePay)){				
			   gradePay=0;
			  }
		var stagn=parseInt(document.getElementById('stagn'+iteration).value);
		   if(isNaN(stagn)){
			 stagn=0;
			 }
		var rankPay=parseInt(document.getElementById('rankPay'+iteration).value);
		if(isNaN(rankPay)){
			rankPay=0;
			}
		var dp=parseInt(document.getElementById('dp'+iteration).value);
		if(isNaN(dp)){
			dp=0;
			}
		var npa=parseInt(document.getElementById('npa'+iteration).value);
		if(isNaN(npa)){
			npa=0;
			}
		var others=parseInt(document.getElementById('others'+iteration).value);
		if(isNaN(others)){
			others=0;
			}
		
		var da=parseInt(document.getElementById('da'+iteration).value);
		if(isNaN(da)){
			da=0;
			}
		//var noOfMonths=Math.ceil(differenceOfDate/30);
		var noOfMonths = document.getElementById('noOfMonths'+iteration).value ;
		//alert("no of months===="+noOfMonths)
			if(!isNaN(basicPay)){
			   
			  document.getElementById('totalEmol'+iteration).value=(basicPay+gradePay+stagn+rankPay+dp+npa+others+da)*noOfMonths;
			  // document.getElementById('noOfMonths'+iteration).value=noOfMonths
			  }
			else{
			  alert("Please Enter Basic pay in Numeric")
			  document.getElementById('totalEmol'+iteration).focus;
			}
		 
	   }else{
		    alert("Please Enter From Date And To Date For Emoluments")
		    document.getElementById('basicPay'+iteration).value="";
		}
  }
	
function calculateDaysForOtherServices11(){
  if(document.getElementById('toDDate1').value != "")
{
calculateDaysForOtherServices();
}
}	
	
	function totalQualifyingServiceDays(){
	  
		var day1, day2;
		var month1, month2;
		var year1, year2;
		
		//alert("iteration-----"+iteration)
		document.getElementById('totalQualifyingServiceYears').value="";
		document.getElementById('totalQualifyingServiceDays').value="";
		document.getElementById('totalQualifyingServiceMonths').value="";
		for(var i=1;i<=document.getElementById('hdb').value;i++)
		{
		var totalDays,totalMonths,totalYears;
		value1 = document.getElementById('fromDate'+i).value;
		value2 =document.getElementById('toDDate'+i).value;
		
		//var yearMonthDays=calculateYearMonthDays(value1,value2);
		var yearMonthDays=dateDiffernce1(value1,value2);
		
		
		years = yearMonthDays.substring (0, yearMonthDays.indexOf (","));
		months = yearMonthDays.substring (yearMonthDays.indexOf (",")+1, yearMonthDays.lastIndexOf (","));
		days = yearMonthDays.substring (yearMonthDays.lastIndexOf (",")+1, yearMonthDays.length);
		
		document.getElementById('otherServiceInDays'+i).value =days;
		document.getElementById('otherServiceInMonths'+i).value =months;
		document.getElementById('otherServiceInYears'+i).value =years;
		
			var totalServiceInYears=parseInt(document.getElementById('totalQualifyingServiceYears').value);
			var totalServiceWithoutEolInYears=parseInt(document.getElementById('totalServiceWithoutEolInYears').value);
			var totalServiceInMonths=parseInt(document.getElementById('totalQualifyingServiceMonths').value);
			var totalServiceWithoutEolInMonths=parseInt(document.getElementById('totalServiceWithoutEolInMonths').value);
			var totalServiceInDays=parseInt(document.getElementById('totalQualifyingServiceDays').value);
			var totalServiceWithoutEolInDays=parseInt(document.getElementById('totalServiceWithoutEolInDays').value);
		
		
		
		
		
		
		
		
		
			//alert("totalServiceInMonths==="+totalServiceInMonths)
		if(isNaN(totalServiceInYears)){
		  totalYears=totalServiceWithoutEolInYears+parseInt(years);
		  document.getElementById('totalQualifyingServiceYears').value=totalYears;
		 //alert("in if totalQualifyingServiceYears===="+document.getElementById('totalQualifyingServiceYears').value)
		  }else{
		  var tService=totalServiceInYears + parseInt(years);
		  document.getElementById('totalQualifyingServiceYears').value=tService;
		  }
		if(isNaN(totalServiceInMonths)){
		  totalMonths=totalServiceWithoutEolInMonths+parseInt(months);
		  if(totalMonths>=12){
		    totalMonths=totalMonths-12;
		    var totalYearsChanged=parseInt(document.getElementById('totalQualifyingServiceYears').value)
		    document.getElementById('totalQualifyingServiceYears').value=totalYearsChanged+1;
		  }
		  document.getElementById('totalQualifyingServiceMonths').value=totalMonths;
		// alert("in if totalQualifyingServiceMonths===="+document.getElementById('totalQualifyingServiceMonths').value)
		  }else{
		  var tService=totalServiceInMonths + parseInt(months);
		  if(tService>=12){
		  	tService=tService-12;
		  	var totalYearsChanged=parseInt(document.getElementById('totalQualifyingServiceYears').value)
		  	document.getElementById('totalQualifyingServiceYears').value=totalYearsChanged+1;
		  }
		  document.getElementById('totalQualifyingServiceMonths').value=tService;
		  } 
		if(isNaN(totalServiceInDays)){
		  totalDays=totalServiceWithoutEolInDays+parseInt(days);
		  if(totalDays>30){
		    totalDays=totalDays-31;
		     var totalMonthsChanged=parseInt(document.getElementById('totalQualifyingServiceMonths').value)
		     //alert("totalMonthsChanged==="+totalMonthsChanged);
		     document.getElementById('totalQualifyingServiceMonths').value=totalMonthsChanged+1;
		  }
		  document.getElementById('totalQualifyingServiceDays').value=totalDays;
		// alert("in if totalQualifyingServiceDays===="+document.getElementById('totalQualifyingServiceDays').value)
		  }else{
		  var tServiceInDays=totalServiceInDays + parseInt(days);
		  if(tServiceInDays>30){
		  	 tServiceInDays=tServiceInDays-31;
		     var totalMonthsChanged=parseInt(document.getElementById('totalQualifyingServiceMonths').value)
		    // alert("totalMonthsChanged==="+totalMonthsChanged);
		     document.getElementById('totalQualifyingServiceMonths').value=totalMonthsChanged+1;
		  }
		  //alert("in else tService===="+tService)
		  document.getElementById('totalQualifyingServiceDays').value=tServiceInDays;
		  }
		 
		 
		}
		calculateNetQualifyingService();
  }

  function calculateYearMonthDays(value1,value2){
		var ToMonth,FromMonth,MonthDiff; 
		var ToDays,FromDays,DaysDiff;
		
		var TotalService;
			
		FromDays = value1.substring (0, value1.indexOf ("/"));
		FromMonth = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		FromYear = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
		
		ToDays = value2.substring (0, value2.indexOf ("/"));
		ToMonth = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		ToYear = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
		
		var YearDiff = ToYear.valueOf() - FromYear.valueOf();
		var fromMonth= parseInt(FromMonth);

		
		//if(ToMonth.valueOf() < fromMonth){
		   // YearDiff = YearDiff - 1
		   // var ToMonth = 12 + parseInt(ToMonth);
		//}
		
		MonthDiff = ToMonth.valueOf() - FromMonth.valueOf()
		var fromDays=parseInt(FromDays);
		//pankaj
		var fromYear=parseInt(FromYear);
		if(ToYear.valueOf() <= fromYear){
		
		       if(ToMonth.valueOf() <= fromMonth){
		           
		            if(ToDays.valueOf() < fromDays){
		             alert("To Date should be greater then From Date.")
					   return  false;				   
					
		              }
		       }
		}
	
		 if(ToDays.valueOf() <= fromDays){
				
		       if(ToMonth.valueOf() <= fromMonth){
		           
		           if(ToYear.valueOf() < fromYear){
		             alert("To Date should be greater then From Date.")
					   return false;
		            
		
		          }
		       }
		}
		
		if(ToYear.valueOf() <= fromYear){
				
		       if(ToMonth.valueOf() < fromMonth){
		           
		                alert("To Date should be greater then From Date.")
					   return false;
		            
		
		          
		       }
		}
		
		
		
		
		 if(ToYear.valueOf() <= fromYear){
		  
	                   if(ToDays.valueOf() <= fromDays){	
		    		
		              if(ToMonth.valueOf() < fromMonth){
		                alert("To Date should be greater then From Date.")
					   return false;
		            
		
		          }
		       }
		}
		
		
		//pankaj	    
		//if(ToDays.valueOf() < fromDays){
		  //if(MonthDiff>0){
		  //  MonthDiff = MonthDiff - 1
		  //  ToDays =  30+ parseInt(ToDays);
		    // alert("To Date should be greater then From Date11111111111.")
					 //  return false;
		     //alert(+ToDays)
		   // }else{
		   // alert("To Date should be greater then From Date122222222111.")
				//	   return false;
		   // YearDiff=YearDiff-1;
		   // MonthDiff=MonthDiff+11;
		  //  ToDays =  30+ parseInt(ToDays);
		    
		    //alert("--------"+ToDays)
		   // }
		    
		  
		//}
		
		//pankaj
		if(ToYear.valueOf() == fromYear){
		       if(ToMonth.valueOf() > fromMonth){
		      if(ToDays.valueOf() < fromDays){
		       }
		}}
		
		//pankaj
		
		DaysDiff = 1 + (ToDays.valueOf()  - FromDays.valueOf() )
		
		return YearDiff+","+MonthDiff+","+DaysDiff;
	}
	//pankaj
	function calculateDaysForEOLNew(){
	  
		var days;
		var months;
		var years;
		
		
		document.getElementById('totalEOLYears').value="";
		document.getElementById('totalEOLMonths').value="";
		document.getElementById('totalEOLDays').value="";
		for(var i=1;i<=document.getElementById('eolValue').value; i++)
		{
		
		value1 = document.getElementById('fromDateForEol'+i).value;
		value2 =document.getElementById('toDateForEOL'+i).value;
		//var yearMonthDays=calculateYearMonthDays(value1,value2);
		var yearMonthDays=dateDiffernce1(value1,value2);


		years = yearMonthDays.substring (0, yearMonthDays.indexOf (","));
		months = yearMonthDays.substring (yearMonthDays.indexOf (",")+1, yearMonthDays.lastIndexOf (","));
		days = yearMonthDays.substring (yearMonthDays.lastIndexOf (",")+1, yearMonthDays.length);
		
		document.getElementById('eolYears'+i).value=years
		document.getElementById('eolMonths'+i).value=months
		document.getElementById('eolDays'+i).value=days
		
		var totalEOLYears=parseInt(document.getElementById('totalEOLYears').value);
		var totalEOLMonths=parseInt(document.getElementById('totalEOLMonths').value);
		var totalEOLDays=parseInt(document.getElementById('totalEOLDays').value);
		
		if(isNaN(totalEOLYears)){
		  totalEOLYears=parseInt(years);
		  document.getElementById('totalEOLYears').value=totalEOLYears;
		// alert("in if totalEOLYears===="+document.getElementById('totalEOLYears').value)
		  }else{
		  var tService=totalEOLYears + parseInt(years);
		  document.getElementById('totalEOLYears').value=tService;
		  }	
		  
		if(isNaN(totalEOLMonths)){
		  totalMonths=parseInt(months);
		  if(totalMonths>=12){
		    totalMonths=parseInt(totalMonths)-12;
		    var totalYearsChanged=parseInt(document.getElementById('totalEOLYears').value)
		    document.getElementById('totalEOLYears').value=parseInt(totalYearsChanged)+1;
		      //alert("document.getElementById('totalEOLYears').value in if============="+document.getElementById('totalEOLYears').value)
		  }
		  document.getElementById('totalEOLMonths').value=totalMonths;
		// alert("in if totalEOLMonths===="+document.getElementById('totalEOLMonths').value)
		  }else{
		  var tService=totalEOLMonths + parseInt(months);
		  if(tService>=12){
		  	tService=tService-12;
		  	var totalYearsChanged=parseInt(document.getElementById('totalEOLYears').value)
		  	document.getElementById('totalEOLYears').value=parseInt(totalYearsChanged)+1;
		  }
		  document.getElementById('totalEOLMonths').value=tService;
		//  alert("in else totalEOLMonths===="+document.getElementById('totalEOLMonths').value)
		  }
		  
		  if(isNaN(totalEOLDays)){
		  totalDays=parseInt(days);
		  if(totalDays>30){
		    totalDays=totalDays-31;
		     var totalMonthsChanged=parseInt(document.getElementById('totalEOLMonths').value)
		     document.getElementById('totalEOLMonths').value=totalMonthsChanged+1;
		      // alert("totalMonthsChanged==="+document.getElementById('totalEOLMonths').value);
		  }
		  document.getElementById('totalEOLDays').value=totalDays;
		// alert("in if totalEOLDays===="+document.getElementById('totalEOLDays').value)
		  }else{
		  var tServiceInDays=totalEOLDays + parseInt(days);
		  if(tServiceInDays>30){
		  	 tServiceInDays=tServiceInDays-30;
		     var totalMonthsChanged=parseInt(document.getElementById('totalEOLMonths').value)
		     document.getElementById('totalEOLMonths').value=totalMonthsChanged+1;
		        //alert("in months changed document.getElementById('totalEOLMonths').value==="+ document.getElementById('totalEOLMonths').value);
		  }
		  //alert("in else tService===="+tService)
		  document.getElementById('totalEOLDays').value=tServiceInDays;
		  }
		  
		   
		  
		}
		
  }
	//pankaj
	
	
  function calculateDaysForEOL(){
	  
		var days;
		var months;
		var years;
		
		
		document.getElementById('totalEOLYears').value="";
		document.getElementById('totalEOLMonths').value="";
		document.getElementById('totalEOLDays').value="";
		for(var i=1;i<=document.getElementById('eolValue').value; i++)
		{
		
		value1 = document.getElementById('fromDateForEol'+i).value;
		value2 =document.getElementById('toDateForEOL'+i).value;
		//var yearMonthDays=calculateYearMonthDays(value1,value2);
		var yearMonthDays=dateDiffernce1(value1,value2);
		years = yearMonthDays.substring (0, yearMonthDays.indexOf (","));
		months = yearMonthDays.substring (yearMonthDays.indexOf (",")+1, yearMonthDays.lastIndexOf (","));
		days = yearMonthDays.substring (yearMonthDays.lastIndexOf (",")+1, yearMonthDays.length);
		
		document.getElementById('eolYears'+i).value=years
		document.getElementById('eolMonths'+i).value=months
		document.getElementById('eolDays'+i).value=days
		
		var totalEOLYears=parseInt(document.getElementById('totalEOLYears').value);
		var totalEOLMonths=parseInt(document.getElementById('totalEOLMonths').value);
		var totalEOLDays=parseInt(document.getElementById('totalEOLDays').value);
		
		if(isNaN(totalEOLYears)){
		  totalEOLYears=parseInt(years);
		  document.getElementById('totalEOLYears').value=totalEOLYears;
		// alert("in if totalEOLYears===="+document.getElementById('totalEOLYears').value)
		  }else{
		  var tService=totalEOLYears + parseInt(years);
		  document.getElementById('totalEOLYears').value=tService;
		  }	
		  
		if(isNaN(totalEOLMonths)){
		  totalMonths=parseInt(months);
		  if(totalMonths>=12){
		    totalMonths=totalMonths-12;
		    var totalYearsChanged=parseInt(document.getElementById('totalEOLYears').value)
		    document.getElementById('totalEOLYears').value=totalYearsChanged+1;
		      //alert("document.getElementById('totalEOLYears').value in if============="+document.getElementById('totalEOLYears').value)
		  }
		  document.getElementById('totalEOLMonths').value=totalMonths;
		// alert("in if totalEOLMonths===="+document.getElementById('totalEOLMonths').value)
		  }else{
		  var tService=totalEOLMonths + parseInt(months);
		  if(tService>=12){
		  	tService=tService-12;
		  	var totalYearsChanged=parseInt(document.getElementById('totalEOLYears').value)
		  	document.getElementById('totalEOLYears').value=totalYearsChanged+1;
		  }
		  document.getElementById('totalEOLMonths').value=tService;
		//  alert("in else totalEOLMonths===="+document.getElementById('totalEOLMonths').value)
		  }
		  
		  if(isNaN(totalEOLDays)){
		  totalDays=parseInt(days);
		  if(totalDays>30){
		    totalDays=totalDays-30;
		     var totalMonthsChanged=parseInt(document.getElementById('totalEOLMonths').value)
		     document.getElementById('totalEOLMonths').value=totalMonthsChanged+1;
		      // alert("totalMonthsChanged==="+document.getElementById('totalEOLMonths').value);
		  }
		  document.getElementById('totalEOLDays').value=totalDays;
		// alert("in if totalEOLDays===="+document.getElementById('totalEOLDays').value)
		  }else{
		  var tServiceInDays=totalEOLDays + parseInt(days);
		  if(tServiceInDays>30){
		  	 tServiceInDays=tServiceInDays-30;
		     var totalMonthsChanged=parseInt(document.getElementById('totalEOLMonths').value)
		     document.getElementById('totalEOLMonths').value=totalMonthsChanged+1;
		        //alert("in months changed document.getElementById('totalEOLMonths').value==="+ document.getElementById('totalEOLMonths').value);
		  }
		  //alert("in else tService===="+tService)
		  document.getElementById('totalEOLDays').value=tServiceInDays;
		  }
		  
		   
		  
		}
		calculateNetQualifyingService();
  }
  
  
  function calculateNetQualifyingService(){
        var netQualifyingServiceInYears=0;
        var netQualifyingServiceInMonths=0;
        var netQualifyingServiceInDays=0;
        document.getElementById('netQualifyingServiceInYears').value="";
        document.getElementById('netQualifyingServiceInMonths').value="";
        document.getElementById('netQualifyingServiceInDays').value="";
        var totalServiceWithoutEolInYears=parseInt(document.getElementById('totalServiceWithoutEolInYears').value);
        var totalServiceWithoutEolInMonths=parseInt(document.getElementById('totalServiceWithoutEolInMonths').value);
  		var totalServiceWithoutEolInDays=parseInt(document.getElementById('totalServiceWithoutEolInDays').value);
        var totalEOLYears = parseInt(document.getElementById('totalEOLYears').value)
        var totalEOLMonths = parseInt(document.getElementById('totalEOLMonths').value)
        var totalEOLDays = parseInt(document.getElementById('totalEOLDays').value)
        var totalQualifyingServiceYears = parseInt(document.getElementById('totalQualifyingServiceYears').value)
        var totalQualifyingServiceMonths = parseInt(document.getElementById('totalQualifyingServiceMonths').value)
        var totalQualifyingServiceDays = parseInt(document.getElementById('totalQualifyingServiceDays').value)
        
        
     if(!isNaN(totalEOLDays) && !isNaN(totalQualifyingServiceDays)){
      	  netQualifyingServiceInYears=totalQualifyingServiceYears-totalEOLYears
      	   document.getElementById('netQualifyingServiceInYears').value=netQualifyingServiceInYears;
      	  if(totalQualifyingServiceMonths<totalEOLMonths){
      	  	totalQualifyingServiceMonths=totalQualifyingServiceMonths+12;
      	  	var netQualifyingYearChanged=parseInt(document.getElementById('netQualifyingServiceInYears').value);
      	  	document.getElementById('netQualifyingServiceInYears').value=netQualifyingYearChanged-1;
      	  	netQualifyingServiceInMonths= totalQualifyingServiceMonths-totalEOLMonths
      	  }else{
      	  netQualifyingServiceInMonths= totalQualifyingServiceMonths-totalEOLMonths
      	  }
      	    document.getElementById('netQualifyingServiceInMonths').value=netQualifyingServiceInMonths
      	   
      	  if(totalQualifyingServiceDays<totalEOLDays){
      	     totalQualifyingServiceDays=totalQualifyingServiceDays+30;
      	     var netQualifyingMonthChanged=parseInt(document.getElementById('netQualifyingServiceInMonths').value);
      	     document.getElementById('netQualifyingServiceInMonths').value=netQualifyingMonthChanged-1;
      	     netQualifyingServiceInDays= totalQualifyingServiceDays-totalEOLDays
      	  }else{
          netQualifyingServiceInDays= totalQualifyingServiceDays-totalEOLDays
          }
          document.getElementById('netQualifyingServiceInDays').value=netQualifyingServiceInDays
     
     }
     else if(!isNaN(totalEOLDays) && !isNaN(totalServiceWithoutEolInDays)){
     	
     	netQualifyingServiceInYears=totalServiceWithoutEolInYears-totalEOLYears
      	   document.getElementById('netQualifyingServiceInYears').value=netQualifyingServiceInYears;
      	  if(totalServiceWithoutEolInMonths<totalEOLMonths){
      	  	totalServiceWithoutEolInMonths=totalServiceWithoutEolInMonths+12;
      	  	var netQualifyingYearChanged=parseInt(document.getElementById('netQualifyingServiceInYears').value);
      	  	document.getElementById('netQualifyingServiceInYears').value=netQualifyingYearChanged-1;
      	  	netQualifyingServiceInMonths= totalServiceWithoutEolInMonths-totalEOLMonths
      	  }else{
      	  netQualifyingServiceInMonths= totalServiceWithoutEolInMonths-totalEOLMonths
      	  }
      	    document.getElementById('netQualifyingServiceInMonths').value=netQualifyingServiceInMonths
      	  
      	  if(totalServiceWithoutEolInDays<totalEOLDays){
      	     totalServiceWithoutEolInDays=totalServiceWithoutEolInDays+30;
      	     var netQualifyingMonthChanged=parseInt(document.getElementById('netQualifyingServiceInMonths').value);
      	     document.getElementById('netQualifyingServiceInMonths').value=netQualifyingMonthChanged-1;
      	     netQualifyingServiceInDays= totalServiceWithoutEolInDays-totalEOLDays
      	  }else{
          netQualifyingServiceInDays= totalServiceWithoutEolInDays-totalEOLDays
          }
          document.getElementById('netQualifyingServiceInDays').value=netQualifyingServiceInDays
     	
     }else if(!isNaN(totalQualifyingServiceDays)){
     
     	   
      	   document.getElementById('netQualifyingServiceInYears').value=totalQualifyingServiceYears;
      	    document.getElementById('netQualifyingServiceInMonths').value=totalQualifyingServiceMonths;
           document.getElementById('netQualifyingServiceInDays').value=totalQualifyingServiceDays;
     		calculateNetQualifyingService11(); //pankaj
     }
  		
  }
function   calculateNetQualifyingService11()
{
           var day1 ;
		  var day1;
		  var year1 ;
		  var day2 ;
		  var month2;
		  var year2 ;
		  var DaysDiff;
		  var MonthDiff;
		  var YearDiff;
		  
		var year2 = parseInt(document.getElementById('totalEOLYears').value)
        var month2 = parseInt(document.getElementById('totalEOLMonths').value)
        var day2 = parseInt(document.getElementById('totalEOLDays').value)
        var year1 = parseInt(document.getElementById('totalQualifyingServiceYears').value)
        var month1 = parseInt(document.getElementById('totalQualifyingServiceMonths').value)
        var day1 = parseInt(document.getElementById('totalQualifyingServiceDays').value)
        
        alert(+year2);
           alert(+month2);
              alert(+day2);
                 alert(+year1);
                    alert(+month1);
                       alert(+day1);
        
		
			//obj1 = document.getElementById('retirementDate').value;
			//day1 = obj1.substring (0, obj1.indexOf ("/"));
			//month1 = obj1.substring (obj1.indexOf ("/")+1, obj1.lastIndexOf ("/"));
			//year11 = obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length);
			//year1 = parseInt(obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length));

			//obj2 = document.getElementById('appointmentDate').value;
			//day2 = obj2.substring (0, obj2.indexOf ("/"));
			//month2 = obj2.substring (obj2.indexOf ("/")+1, obj2.lastIndexOf ("/"));
			//year22 = obj2.substring (obj2.lastIndexOf ("/")+1, obj2.length);
			//year2 = parseInt(obj2.substring (obj2.lastIndexOf ("/")+1, obj2.length));
	
	
			if (day1==day2) {
				if (month1==month2) {
					if (year1==year2) {
						DaysDiff=1;
						MonthDiff=0;
						YearDiff=0;						
					}else {
						if (year1>year2) {
							DaysDiff=1;
							MonthDiff=0;
							YearDiff=parseInt(year1)-parseInt(year2);							
						}
						else {
							  alert(" Date should be greater.")
							   return false;
						}
					}
					
				} else {
					if (month1>month2) {
						if (year1==year2) {
							
							DaysDiff=1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);
						}else {
							if (year1>year2) {
								DaysDiff=1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  alert("Date should be greater.")
								   return false;
							}
							
						}
						
					}else {
                           if (year1==year2) {
							
                        	   alert("Date should be greater.")
							   return false;
						}else {
							if (year1>year2) {
								DaysDiff=1;
								month1=parseInt(month1)+12;
								year1=parseInt(year1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  alert("Date should be greater.")
								   return false;
							}
							
						}
						
					}
					
				}
				
			}
			else {
				if (day1>day2) {
					if (month1==month2) {
						if (year1==year2) {	
							
							DaysDiff=(parseInt(day1)-parseInt(day2))+1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);	
						}else {
							if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
															
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("Date should be greater.")
								   return false;
							}
						}
					}else {
						if (month1>month2) {
							if (year1==year2) {	
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("Date should be greater.")
								   return false;
							}
								
							}
							
						}else {
							if (year1==year2) {	
								alert("Date should be greater.")
								   return false;
							}else {
								if (year1>year2) {
									
									month1=parseInt(month1)+12;
									year1=parseInt(year1)-1;
									DaysDiff=(parseInt(day1)-parseInt(day2))+1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									alert("Date should be greater.")
									return false;
								}
							}
						}
					}
				}else {
					if (month1==month2) {
						if (year1==year2) {	
							alert("Date should be greater.")
							return false;
						}else {
							if (year1>year2) {
								day2=31-parseInt(day2);												
								
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)+12;
								MonthDiff=parseInt(month1)-parseInt(month2);
								MonthDiff=parseInt(MonthDiff)-1;
								year1=parseInt(year1)-1;
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								alert("Date should be greater.")
								return false;
							}
						}
					}else {
					 
						if (month1>month2) {
							if (year1==year2) {	
							 
								day2=31-parseInt(day2);
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff = parseInt(day1) +parseInt(day2);
									month1=parseInt(month1)-1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									alert("Date should be greater.")
									return false;
								}
							}
							
						}else {
							if (year1==year2) {	
								alert("Date should be greater.")
								return false;
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff= parseInt(day2)+parseInt(day1);
									month1=parseInt(month1)+12;
								
									MonthDiff=parseInt(month1)-parseInt(month2);
									
									MonthDiff=parseInt(MonthDiff)-1;
									year1=parseInt(year1)-1;
									YearDiff=parseInt(year1)-parseInt(year2);
									
								}else {
									alert("Date should be greater")
									return false;
								}
								
							}
						}
					}
				}
				
			}



              // document.getElementById('serviceDays').value=DaysDiff;
	       //document.getElementById('serviceMonths').value=MonthDiff;
	      // document.getElementById('serviceYears').value=YearDiff;
	       document.getElementById('netQualifyingServiceInYears').value=YearDiff;
      	    document.getElementById('netQualifyingServiceInMonths').value=MonthDiff;
           document.getElementById('netQualifyingServiceInDays').value=DaysDiff;
        
}
  
  function validateFieldsForOtherServices(){
			
			 for(var i = 1; i <= document.getElementById('emol').value; i++){
			
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementById('fromDateForEmolu'+i).value != "")
              {
                if(document.getElementById('toDateForEmolu'+i).value != 0){
				     //alert("value of relation==="+document.getElementById('relation'+i).value)
				     if(document.getElementById('basicPay'+i).value != ""){
				        
				     }else{
				       alert("Please select the Date Of Birth.")
					   return false;
				     }
				}else{
				    alert("Please select the Relation")
					return false;
				}
				  
				
			  }	
  		   }
  		
		return true;
		
	}
	
	
function dateDiffernceEOL(){
	       var day1 ;
		  var month1;
		  var year1 ;
		  var day2 ;
		 var month2;
		  var year2 ;
		var DaysDiff;
		var MonthDiff;
		var YearDiff;
		
			//obj1 = document.getElementById('toDDate1').value;
			day2 = parseInt(document.getElementById('totalEOLDays').value);
			month2 = parseInt(document.getElementById('totalEOLMonths').value);
			year2 = parseInt(document.getElementById('totalEOLYears').value);

			//obj2 = document.getElementById('fromDate1').value;
			day1 = parseInt(document.getElementById('totalQualifyingServiceDays').value);
			month1 =parseInt(document.getElementById('totalQualifyingServiceMonths').value);
			year1 = parseInt(document.getElementById('totalQualifyingServiceYears').value);
	
	
			if (day1==day2) {
				if (month1==month2) {
					if (year1==year2) {
						DaysDiff=0;
						MonthDiff=0;
						YearDiff=0;						
					}else {
						if (year1>year2) {
							DaysDiff=0;
							MonthDiff=0;
							YearDiff=parseInt(year1)-parseInt(year2);							
						}
						else {
							  alert(" Date should be greater .")
							   return false;
						}
					}
					
				} else {
					if (month1>month2) {
						if (year1==year2) {
							
							DaysDiff=0;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);
						}else {
							if (year1>year2) {
								DaysDiff=0;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  
							}
							
						}
						
					}else {
                           if (year1==year2) {
							
                        	   
						}else {
							if (year1>year2) {
								DaysDiff=0;
								month1=parseInt(month1)+12;
								year1=parseInt(year1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);							
							}
							else {
								  alert("Date should be greater.")
								   return false;
							}
							
						}
						
					}
					
				}
				
			}
			else {
				if (day1>day2) {
					if (month1==month2) {
						if (year1==year2) {	
							
							DaysDiff=parseInt(day1)-parseInt(day2);
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);	
						}else {
							if (year1>year2) {
								DaysDiff=parseInt(day1)-parseInt(day2);
								MonthDiff=parseInt(month1)-parseInt(month2);
															
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("Date should be greater.")
								   return false;
							}
						}
					}else {
						if (month1>month2) {
							if (year1==year2) {	
								DaysDiff=parseInt(day1)-parseInt(day2);
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {if (year1>year2) {
								DaysDiff=parseInt(day1)-parseInt(day2);
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
							}else {
								alert("Date should be greater.")
								   return false;
							}
								
							}
							
						}else {
							if (year1==year2) {	
								
							}else {
								if (year1>year2) {
									
									month1=parseInt(month1)+12;
									year1=parseInt(year1)-1;
									DaysDiff=parseInt(day1)-parseInt(day2);
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									
								}
							}
						}
					}
				}else {
					if (month1==month2) {
						if (year1==year2) {	
							
						}else {
							if (year1>year2) {
								day2=31-parseInt(day2);												
								
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)+12;
								MonthDiff=parseInt(month1)-parseInt(month2);
								MonthDiff=parseInt(MonthDiff)-1;
								year1=parseInt(year1)-1;
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								
							}
						}
					}else {
					 
						if (month1>month2) {
							if (year1==year2) {	
							 
								day2=31-parseInt(day2);
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff = parseInt(day1) +parseInt(day2);
									month1=parseInt(month1)-1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
								}else {
									alert("Date should be greater.")
									return false;
								}
							}
							
						}else {
							if (year1==year2) {	
								
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									
									DaysDiff= parseInt(day2)+parseInt(day1);
									month1=parseInt(month1)+12;
								
									MonthDiff=parseInt(month1)-parseInt(month2);
									
									MonthDiff=parseInt(MonthDiff)-1;
									year1=parseInt(year1)-1;
									YearDiff=parseInt(year1)-parseInt(year2);
									
								}else {
									
								}
								
							}
						}
					}
				}
				
			}



               document.getElementById('netQualifyingServiceInDays').value=DaysDiff;
	       document.getElementById('netQualifyingServiceInMonths').value=MonthDiff;
	       document.getElementById('netQualifyingServiceInYears').value=YearDiff;


//return YearDiff+","+MonthDiff+","+DaysDiff;
}
	
</script>

