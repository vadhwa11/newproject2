<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>

<SCRIPT>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>
<%
Map<String, Object> utilMap = new HashMap<String, Object>();
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
	int loginEmpId=0;
	if(users!=null){
		if(users.getEmployee()!=null){
			loginEmpId=users.getEmployee().getId();
		}
	}
	
		Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
	
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("aircraftList") != null)	{
		aircraftList = (List<MasAircraftType>)map.get("aircraftList");
	}
%>
<script type="text/javascript">
var rankArray=new Array();

</script>
<%
int ii=0;
for (MasRank masRank : rankList) { %>
     		 <script>
     			rankArray[<%=ii%>]= new Array();
     			rankArray[<%=ii%>][0] = "<%=masRank.getId()%>";
     			rankArray[<%=ii%>][1] = "<%=masRank.getRankName()%>";
            </script> 
            <%}%>
<div class="clear"></div>
<div class="titleBg">	
<h2>MAJOR AIRCRAFT ACCIDENT</h2> </div>
<div class="clear"></div>
<form name="aircraftAccidentInvestigation" action="" method="post">

<div class="clear paddingTop15"></div>
<h4>Details of Accident</h4>
<div class="clear"></div>
<div class="Block">

<label> Date</label>
<input	tabindex="1" name="<%=DATE %>" class="date"	validate=" Date,date,no" maxlength="7" value="<%=currentDate %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE%>,event);" />

<label>Time  </label> 
<input type="text" value=""  name="<%=TIME%>"	tabindex="2" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"/>
<label>Place  </label> 
<input	type="text" value="" name="<%=PLACE%>"	tabindex="2" maxlength="30"/>
 
 <div class="clear"></div>
 
<label>Type of Aircraft  </label> 
<select name="<%=AIRCRAFT_TYPE %>"  id="<%=AIRCRAFT_TYPE %>">
<option value="0">Select</option>
	<%	for(MasAircraftType masAircraftType : aircraftList){%>
	<option value="<%=masAircraftType.getId() %>"><%=masAircraftType.getAircraftTypeName() %></option>
	<%		
		}%>
</select>

<label>Mark  </label> 
<input	type="text"  maxlength="30"  value="" name="<%=MARK %>"	tabindex="2" validate="Mark,metachar,no"/>

<label>Serial Number</label> 
<input	type="text"  value="" name="<%=SERIAL_NO %>"	tabindex="2" maxlength="10" />

<div class="clear"></div>

<label>Unit</label> 
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%
		for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>

<label>Purpose of Flight  </label> 
<input	type="text"  value="" name="purposeOfFlight"	tabindex="2" maxlength="30" />
</div>
<div class="clear"></div>

<div class="clear paddingTop15"></div>
<h4> Crew and Passengers<a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridCrewAndPassengers">
	<tr>
		<TH scope="col">Sl No.</TH>
		<TH scope="col">Service No.</TH>
		<TH scope="col">Rank</TH>
		<TH scope="col">Name</TH>
		<TH scope="col">Crew Station or Passenger Seating</TH>
		<TH scope="col">Result</TH>
		<TH scope="col">Encl used (ring)</TH>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
	</tr>
	<% int i=0; 
	i=i+1;%>
	<tr>
		<td>
			<input tabindex="1" type="text"	name="<%=SR_NO %>" value="<%=i %>" size="2" class="auto" readonly="readonly" id="<%=SR_NO %><%=i %>"/></td>	
		<td>
			<input tabindex="1" type="text"	name="<%=SERVICE_NO %>" maxlength="10" value="" class="small"
			id="serviceNo<%=i %>"/>	
		</td>
		<td>
		<select	id="<%=RANK_ID %><%=i %>" name="<%=RANK_ID %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>
		</td>
			<td>
			<input tabindex="1" type="text"	name="name" maxlength="10" value="" id="name<%=i %>"/>	
		</td>
		<td>
			<input tabindex="1" type="text"	name="crewStationSeating" maxlength="10" value="" id="crewStationSeating<%=i %>"/>	
		</td>
		<td>
			<select name="<%=RESULT %>" class="small" id=<%=RESULT %><%=i %>>
				<option value="Uninj">Uninj</option>
				<option value="Inj">Inj</option>
				<option value="Died">Died</option>
				<option value="Miss">Miss</option>
				
			</select>
		</td>
		<td>
			<select name="enclUsedRing" class="small" id="enclUsedRing<%=i %>" >
				<option value="A" >A</option>
				<option value="B">B</option>
				<option value="C">C</option>
				<option value="D">D</option>
				<option value="E">E</option>
				<option value="F">F</option>
			</select>
		</td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForCrewAndPassengers();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForCrewAndPassengers();" /></td>
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<input type="hidden" id="crewAndPassengersDataStatus" name="crewAndPassengersDataStatus" value="no"/>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4> Total Enclosurses <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="smallCmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridEnclosurses">
	<tr>
		<TH scope="col">Sl No.</TH>
		<TH scope="col">Enclosurses Details</TH>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
	</tr>
	<% int inc=0; 
	inc=inc+1;%>
	<tr>
		<td>
			<input type="text"	name="<%=SERIAL_NO%>" id="<%=SERIAL_NO %><%=inc%>" maxlength="30" value="<%=inc%>" class="small" tabindex="1"/>	
		</td>
		 <td>
			<input tabindex="1" type="text"	name="enclosursesDetails" maxlength="10" value="" id="enclosursesDetails"/>	
		</td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForEnclosurses();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForEnclosurses('gridEnclosurses','hiddenValue',this);" /></td>
	</tr>
</table>
<input type="hidden" id="enclosursesDataStatus" name="enclosursesDataStatus" value="no"/>
</div>
</div>

<div class="clear paddingTop15"></div>
<h4> No. of Photographs <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">

<label>Accident</label>
<input tabindex="1" type="text"	name="numberAccident" maxlength="10" value="" class="auto" size="23" />	

<label>Casualties</label>
<input tabindex="1" type="text"	name="numberCasualties" maxlength="10" value="" class="auto" size="23" />	

</div>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label> Other Enclosurses</label>
<input tabindex="1" type="text"	name="numberOtherEnclosurses" maxlength="10" value="" class="large"/>	

</div>
<div class="clear paddingTop15"></div>
<div class="Block">

<label>Escape in Flight</label>
		<select name="escapeInFlight" validate="Escape in Flight,metachar,no">
				<option value="all">All Escape In Flight</option>
				<option value="some">Some Escape In Flight</option>
				<option value="allpersonnel">All Personnel In Aircraft On Impact</option>
				
			</select>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">	
			
<label class="auto">Circumstances of Accident</label>
<select name="circumstanceAccident">
				<option value="Taxying">Taxying</option>
				<option value="TakeOff">Take Off</option>
				<option value="Catapult">Catapult take-off</option>
				<option value="normal">Landing normal</option>
				<option value="Emergency">Emergency</option>
				<option value="Ditching">Ditching</option>
				<option value="Barrier">Arrested Landing On (Carrier/Crash Barrier)</option>
				<option value="carriage">U-carriage up</option>
				<option value="Down">Down</option>
				<option value="Partially">Partially</option>
			</select>
				<select name="circumstanceAccidentOne">
				<option value="FlewIntoGround">Flew into Ground</option>
				<option value="sea">Sea</option>
				<option value="Obstruction">Obstruction</option>
				
			</select>
			<label>Enemy Action</label>
			<input tabindex="1" type="checkbox"	name="enemyAction"  value="y" maxlength="1" />	
			
			<div class="clear"></div>
			
			<h3>Emergency in Flight</h3>
			<label>MajorStructuralFailure</label>
			<select name="majorStructuralFailure">
				<option value="collision">Collision</option>
				<option value="fire">Fire</option>
				<option value="lackFuel">Lack of Fuel</option>
			</select>
			
			<label>Loss of Control</label>
			<select name="lossControl">
				<option value="m">In Manoenvrel</option>
				<option value="f">Level Flight</option>
				<option value="e">Explained</option>
				<option value="u">Unexplained</option>
			</select>
			<div class="clear"></div>
			<label>Loss of Power</label>
			<select name="lossPower">
				<option value="a">Actual</option>
				<option value="p">Practice Symmetrical</option>
				<option value="s">Asymmetrical</option>
			</select>
			
			<label>Loss of Service</label>
			<select name="lossService">
				<option value="a">Actual</option>
				<option value="m">Practice Mannual Control</option>
				<option value="m">Power Control</option>
			</select>
			<div class="clear"></div>
			<label>Instruments</label>
			<label class="auto" > Radio</label>
			<input tabindex="1" type="radio" name="instruments"  class="radioAuto" value="r" maxlength="1"/>	
			<label class="auto">Others(Specify)</label>
			<input tabindex="1" type="radio" name="instruments"  value="o" class="radioAuto" />	
				<div class="clear"></div>
				
			<label class="auto">Other Circumstances (Specify)</label>
			<input tabindex="1" type="text"	name="otherCircumstanceSpecify" maxlength="50" value="" class="large"/>	
</div>
<div class="clear paddingTop15"></div>

<div class="clear"></div>
<div class="Block">

<label>Operating Conditions</label>

<select name="operatingConditions" >
				<option value="s">Solo</option>
				<option value="d">Dual</option>
				<option value="a">Autopilot</option>
				<option value="u">Unknow</option>
	
			</select>
				<select name="operatingConditionsOne">
				<option value="l">Formation Leader</option>
				<option value="m">Fromation Member</option>
				<option value="c">Under Control of Leader</option>
				<option value="i">Independent Flying</option>
			</select>
<div class="clear"></div>
	<label class="auto">If Underground Control,Specify Type</label>
			<input tabindex="1" type="text"	name="undergroundControl" maxlength="50" value="" class="auto" size="79" />	
</div>

<div class="clear paddingTop15"></div>
<h4>Height</h4>
<div class="Block">

<label> Intendered for Sortie</label>
<input tabindex="1" type="text"	name="intenderedForSortie" maxlength="30" value="Not Known"
 validate="Intendered for Sortie,metachar,no"/>	
<label class="unit">ft</label>


<label> At Time of Emergency</label>
<input tabindex="1" type="text"	name="undergroundControl" maxlength="50" value="Not Known"
		 validate="At Time of Emergency,metachar,no"/>	
<label class="unit">ft</label>
</div>

<input tabindex="1"  type=button value="Submit" class=button  name="Submit11"
onclick="submitForm('aircraftAccidentInvestigation','/hms/hms/aviationMedicine?method=submitAviationAccidentEntry&flag=accident');" accesskey=r  />
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>
</div>
</form>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>

<script type="text/javascript">

function showTympanumExternalEars(){
	if(document.getElementById('tympanumExternalEars').value == 'Abnormal'){
	  	document.getElementById("tympanumExternalEarsDiv").style.display='inline';
	}else{
		document.getElementById("tympanumExternalEarsDiv").style.display='none';
	}
}

function addRowForEnclosurses(){
    
	  var tbl = document.getElementById('gridEnclosurses');
	  var lastRow = tbl.rows.length;
	  document.getElementById('enclosursesDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = '<%=SERIAL_NO%>';
	  e0.id = '<%=SERIAL_NO%>' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '20'
	  e0.value=hdb.value;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'enclosursesDetails';
	  e1.id = 'enclosursesDetails' + iteration;
	  e1.setAttribute('tabindex','1');
	  e1.size = '20'
	  cellRight1.appendChild(e1);

	 var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'button';
	  e2.className = 'buttonAdd';
	  e2.name='Button';
	  e2.setAttribute('onClick','addRowForEnclosurses();');
	  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonDel';
	  e3.name='delete';
	  e3.setAttribute('onClick','removeRowForEnclosurses();');
	  cellRight3.appendChild(e3);
	  
	}

function removeRowForEnclosurses()
	{
	  var tbl = document.getElementById('gridEnclosurses');
	  var lastRow = tbl.rows.length;
	  document.getElementById('enclosursesDataStatus').value="yes";
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('gridEnclosurses');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration
	  }
	}
function addRowForCrewAndPassengers(){
    
	  var tbl = document.getElementById('gridCrewAndPassengers');
	  var lastRow = tbl.rows.length;
	  document.getElementById('crewAndPassengersDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = '<%=SR_NO%>';
	  e0.id = '<%=SR_NO%>' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '3'
	  e0.value=hdb.value;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = '<%=SERVICE_NO%>';
	  e1.id = '<%=SERVICE_NO%>' + iteration;
	  e1.setAttribute('tabindex','1');
	  e1.size = '20'
	  cellRight1.appendChild(e1);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('Select');
	  e2.name = '<%=RANK_ID%>';
	  e2.id = 'rankId' + iteration;
	  e2.setAttribute('tabindex', 1); 
	  e2.options[0] = new Option('Select', '0');
	   for(var i = 0;i<rankArray.length;i++ ){
	     e2.options[i+1] = new Option(rankArray[i][1],rankArray[i][0]);
	  }
	  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = '<%=NAME%>' ;
	  e3.id = 'name' + iteration;
	  e3.setAttribute('tabindex','1');
	  //e3.size = '20'
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'crewStationSeating';
	  e4.id = 'crewStationSeating' + iteration;
	  e4.setAttribute('tabindex','1');
	  //e3.size = '20'
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('select');
	  e5.name = '<%=RESULT%>';
	  e5.id = 'result' + iteration;
	  e5.className = 'small';  
	  e5.options[0] = new Option('Uninj', 'Uninj');
	  e5.options[1] = new Option('Inj', 'Inj');
	  e5.options[2] = new Option('Died', 'Died');
	  e5.options[3] = new Option('Miss', 'Miss');
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('select');
	  e6.name = 'enclUsedRing';
	  e6.id = 'enclUsedRing' + iteration;
	  e6.className = 'small';
	  e6.options[0] = new Option('A', 'A');
	  e6.options[1] = new Option('B', 'B');
	  e6.options[2] = new Option('C', 'C');
	  e6.options[3] = new Option('D', 'D');
	  e6.options[4] = new Option('E', 'E');
	  e6.options[5] = new Option('F', 'F');
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);
	  
	 var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	  e7.name='Button';
	  e7.setAttribute('onClick','addRowForCrewAndPassengers();');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  e8.name='delete';
	  e8.setAttribute('onClick','removeRowForCrewAndPassengers();');
	  cellRight8.appendChild(e8);
	}

function removeRowForCrewAndPassengers()
	{
	  var tbl = document.getElementById('gridCrewAndPassengers');
	  var lastRow = tbl.rows.length;
	  document.getElementById('crewAndPassengersDataStatus').value="yes";
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('gridCrewAndPassengers');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }
	}


function showPositionOfCasualty(){
	if(document.getElementById('positionOfCasualty').value == 'Other'){
	  	document.getElementById("positionOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("positionOfCasualtyDiv").style.display='none';
	}
}

function showDisplacementOfCasualty(){
	if(document.getElementById('displacementOfCasualty').value == 'Other'){
	  	document.getElementById("displacementOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("displacementOfCasualtyDiv").style.display='none';
	}
}
function showType(){
	if(document.getElementById('type').value == 'Other'){
	  	document.getElementById("typeDiv").style.display='inline';
	}else{
		document.getElementById("typeDiv").style.display='none';
	}
}

function showOuterClothing(){
	if(document.getElementById('outerClothing').value == 'Damaged'){
	  	document.getElementById("outerClothingDiv").style.display='inline';
	}else{
		document.getElementById("outerClothingDiv").style.display='none';
	}
}

function showAircraftAccident(){
	if(document.getElementById('aircraftAccident').value == 'Yes'){
	  	document.getElementById("aircraftAccidentDiv").style.display='inline';
	}else{
		document.getElementById("aircraftAccidentDiv").style.display='none';
	}
}


function showFactors(){
	if(document.getElementById('factors').value == 'Other'){
	  	document.getElementById("factorsDiv").style.display='inline';
	}else{
		document.getElementById("factorsDiv").style.display='none';
	}
}
function showWillingness(){
	if(document.getElementById('willingness').value == 'Unwill'){
	  	document.getElementById("willingnessDiv").style.display='inline';
	}else{
		document.getElementById("willingnessDiv").style.display='none';
	}
}
function showConditionOfBodywasDiv(){
	if(document.getElementById('conditionOfBodywas').value == 'Other'){
	  	document.getElementById("conditionOfBodywasDiv").style.display='inline';
	}else{
		document.getElementById("conditionOfBodywasDiv").style.display='none';
	}
}
function showHeart(){
	if(document.getElementById('heart').value == 'Any'){
	  	document.getElementById("heartDiv").style.display='inline';
	}else{
		document.getElementById("heartDiv").style.display='none';
	}
}
function showCoronary(){
	if(document.getElementById('coronary').value == 'Short'){
	  	document.getElementById("coronaryDiv").style.display='inline';
	}else{
		document.getElementById("coronaryDiv").style.display='none';
	}
}

function showAorta(){
	if(document.getElementById('aorta').value == 'Any'){
	  	document.getElementById("aortaDiv").style.display='inline';
	}else{
		document.getElementById("aortaDiv").style.display='none';
	}

}
function showOtherGreatVessels(){
	if(document.getElementById('otherGreatVessels').value == 'Any'){
	  	document.getElementById("otherGreatVesselsDiv").style.display='inline';
	}else{
		document.getElementById("otherGreatVesselsDiv").style.display='none';
	}
}

function showDiaphragam(){
	if(document.getElementById('diaphragam').value == 'Herniation'){
	  	document.getElementById("diaphragamDiv").style.display='inline';
	}else{
		document.getElementById("diaphragamDiv").style.display='none';
	}
}
function showPeritoneum(){
	if(document.getElementById('peritoneum').value == 'Any'){
	  	document.getElementById("peritoneumDiv").style.display='inline';
	}else{
		document.getElementById("peritoneumDiv").style.display='none';
	}
}
function showOesophagus(){
	if(document.getElementById('oesophagus').value == 'Any'){
	  	document.getElementById("oesophagusDiv").style.display='inline';
	}else{
		document.getElementById("oesophagusDiv").style.display='none';
	}
}
function showStomach(){
	if(document.getElementById('stomach').value == 'Any'){
	  	document.getElementById("stomachDiv").style.display='inline';
	}else{
		document.getElementById("stomachDiv").style.display='none';
	}
}
function showIntestines(){
	if(document.getElementById('intestines').value == 'Any'){
	  	document.getElementById("intestinesDiv").style.display='inline';
	}else{
		document.getElementById("intestinesDiv").style.display='none';
	}
}
function showLiver(){
	if(document.getElementById('liver').value == 'Any'){
	  	document.getElementById("liverDiv").style.display='inline';
	}else{
		document.getElementById("liverDiv").style.display='none';
	}
}
function showPancreas(){
	if(document.getElementById('pancreas').value == 'Any'){
	  	document.getElementById("pancreasDiv").style.display='inline';
	}else{
		document.getElementById("pancreasDiv").style.display='none';
	}
}
function showPelvicOrgans(){
	if(document.getElementById('pelvicOrgans').value == 'Any'){
	  	document.getElementById("pelvicOrgansDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDiv").style.display='none';
	}

	if(document.getElementById('pelvicOrgans').value == 'Damaged'){
	  	document.getElementById("pelvicOrgansDamagedDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDamagedDiv").style.display='none';
	}
}
function showThyroid(){
	if(document.getElementById('thyroid').value == 'Any'){
	  	document.getElementById("thyroidDiv").style.display='inline';
	}else{
		document.getElementById("thyroidDiv").style.display='none';
	}
	if(document.getElementById('thyroid').value == 'AnyTraumaticChanges'){
	  	document.getElementById("thyroidTraumaticDiv").style.display='inline';
	}else{
		document.getElementById("thyroidTraumaticDiv").style.display='none';
	}
}

function showLymphGlands(){
	if(document.getElementById('lymphGlands').value == 'Any'){
	  	document.getElementById("lymphGlandsDiv").style.display='inline';
	}else{
		document.getElementById("lymphGlandsDiv").style.display='none';
	}
}
function showCarbon(){
	if(document.getElementById('carbon').value == 'AutopsyEvidence'){
	  	document.getElementById("carbonDiv").style.display='inline';
	}else{
		document.getElementById("carbonDiv").style.display='none';
	}
}

function showOtherPoisonings(){
	if(document.getElementById('otherPoisonings').value == 'AutopsyEvidence'){
	  	document.getElementById("otherPoisoningsDiv").style.display='inline';
	}else{
		document.getElementById("otherPoisoningsDiv").style.display='none';
	}
}

function showHypoxia(){
	if(document.getElementById('hypoxia').value == 'AutopsyEvidence'){
	  	document.getElementById("hypoxiaDiv").style.display='inline';
	}else{
		document.getElementById("hypoxiaDiv").style.display='none';
	}
}

</script>