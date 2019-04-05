<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : aircraftEmergency.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 01.03.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasStation"%>

<%@page import="jkt.hms.masters.business.MasLocation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasRank"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
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
	<script type="text/javascript">
	var rankArray=new Array();

</script>
<form name="aircraftEmergency" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("aircraftTypeList") != null){
			aircraftTypeList= (List<MasAircraftType>)map.get("aircraftTypeList");
		}
		if(map.get("stationList") != null){
			stationList= (List<MasStation>)map.get("stationList");
		}
		if(map.get("unitList") != null){
			unitList= (List<Object[]>)map.get("unitList");
		}
		if(map.get("doctorList") != null){
			doctorList= (List<MasEmployee>)map.get("doctorList");
		}
		List<MasRank> rankList = new ArrayList<MasRank>();
		if(map.get("rankList") != null)	{
			rankList = (List<MasRank>)map.get("rankList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>Aircraft Emergency</h2></div>
<div class="Clear"></div>
<div class="Block">
<label>Call Date <span>*</span></label> 
<input	type="text" name="<%=CALL_RCD_DATE %>" value="<%= currentDate %>" MAXLENGTH="30" id="callRcdDate" readonly="readonly" validate="Call Rec.Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.aircraftEmergency.callRcdDate,event)" /> 

<label>Call Time <span>*</span></label>
<input type="text" name="<%=CALL_RCD_TIME %>" id="callRecTime" validate="Call Rec.Time,string,yes" value="<%= time %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="5" />

<label>Call From <span>*</span></label>
<input type="text" name="<%=SOURCE_FROM %>" value="" validate="From,metachar,yes" MAXLENGTH="90"/> 
 
 <div class="Clear"></div>
 

<label> Reported By <span>*</span></label> 
<input	type="text" name="<%=REPORTED_BY%>" validate="Reported By,metachar,no" value="" MAXLENGTH="50"  />

<label> Site <span>*</span></label> 
<input type="text" name="<%= LOCATION %>" value="" validate="Location,metachar,yes">


<label> Type of Aircraft <span>*</span></label> 
<select name="<%=AIRCRAFT_TYPE_ID %>" validate="Type Of Aircraft,metachar,yes">
	<option value="0">Select</option>
	<%
				for(MasAircraftType aircraftType : aircraftTypeList)
				{
				%>
	<option value="<%=aircraftType.getId()%>"><%=aircraftType.getAircraftTypeName()%></option>
	<%
				}
				%>
</select>

<div class="Clear"></div>
<label> Type of Emergency</label> 
<input type="text" 	name="<%=EMERGENCY_TYPE %>" value="" validate="Type Of Emergency,metachar,no" MAXLENGTH="50" /> 

<label> Unit/Squadron</label> 
<select name="<%=UNIT_ID %>" validate="Unit/Squadron,metachar,no">
	<option value="0">Select</option>
	<% 
			for(Object[] unit : unitList)
			{
			%>
	<option value="<%=unit[0]%>"><%=(String)unit[1]%></option>
	<%
			}
			%>
</select> 
<!--<label>Station</label> 
<select name="<%=STATION_ID %>" validate="Station,string,no">
	<option value="0">Select</option>
	<% 
			for(MasStation station : stationList)
			{
			%>
	<option value="<%=station.getId()%>"><%=station.getStationName()%></option>
	<%
			}
			%>
</select> 
-->

<label> Attended Time <span>*</span></label> 
<input	type="text" name="<%=ATTENDED_TIME%>" value="<%= time %>" validate="Attended Time,string,yes" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);"  MAXLENGTH="5" id="pLName" />
<div class="Clear"></div>

<label> Medical Officer</label> 
<select name="<%=MEDICAL_OFFICER_ID %>" validate="Medical Officer,metachar,no">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
			%>
	<option value="<%=employee.getId()%>"><%=employee.getRank().getRankName()+" "+ employee.getFirstName()+" "+employee.getLastName() %></option>
	<%
			}
			%>
</select> 
<div class="Clear"></div>
<label> Action Taken</label> 
<textarea name="<%=ACTION_TAKEN %>" rows="" cols=""  validate="Action Taken,metachar,no" maxlength="200" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Remarks</label> 
<textarea name="<%=REMARKS %>" rows="" cols="" maxlength="90" validate="Remarks,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" ></textarea>
<div class="Clear"></div>
</div>

<div class="clear paddingTop15"></div>

<table class="cmntable" id="grid">

<tr>
<th>Sl No.</th>
<th>Service No.</th>
<th>Rank</th>
<th>Name</th>
<th>Age</th>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc=0;inc=inc+1;%>
<tr>
<td>
<input type="text" name="<%=SIRIAL_NO%>" value="<%=inc %>" tabindex="1" size="1" class="auto"  readonly="readonly"/></td>

<td><input type="text" tabindex="1" name="serviceNo<%=inc %>" id="serviceNo<%=inc %>" validate="Service No.,metachar,no" onblur="if(this.value!=''){ajaxFunctionPilotRegService(aircraftEmergency,<%=inc %>,this.value);check(this.value,<%=inc%>);}"/></td>
<td>
<select	id="<%=RANK_ID %><%=inc %>" name="<%=RANK_ID %><%=inc %>"	validate="Rank,string,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>

	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	} %>
</select>
<%
int i1=0;
for (MasRank masRank : rankList) {
     			 %> <script>

     			rankArray[<%=i1%>]= new Array();
     			rankArray[<%=i1%>][0] = "<%=masRank.getId()%>";
     			rankArray[<%=i1%>][1] = "<%=masRank.getRankName()%>";
            </script> <%
++i1;
}%></td>

<td><input type="text" name="sName<%=inc %>" id="sName<%=inc %>" value="" validate="Name,metachar,no" />
<input type="hidden" name="hinId<%=inc %>" id="hinId<%=inc %>" value="0"/>
<input type="hidden" name="pilotId<%=inc %>" id="pilotId<%=inc %>" value="0"/></td>

<td><input type="text" name="age<%=inc %>" id="age<%=inc %>" value="" validate="Age,metachar,no" /></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>
</tr>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
</table>
<div class="division"></div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('aircraftEmergency','/hms/hms/registration?method=saveAirCraftEmergencyDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="button" name="register" id="addbutton"
	onclick="submitFormForButton('aircraftEmergency','/hms/hms/registration?method=showAircraftEmergencyRegisterJsp');"
	value="Register" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<input type="button" name="avicasulity" id="addbutton"
	onclick="submitFormForButton('aircraftEmergency','/hms/hms/aviationMedicine?method=showCasualtyAirEvacuationJsp');"
	value="CASUALTY AIR EVACUATION" class="buttonBig2" accesskey="a" />

<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>
<script type="text/javascript">
function check(serviceNo,inc)
{
	
	for(i=0;i<inc;i++){

		if(inc != 1){
			if(document.getElementById('serviceNo'+i) && document.getElementById('serviceNo'+i).value==serviceNo) {
				alert("service No already selected...!")
				document.getElementById('serviceNo'+inc).value=""
					document.getElementById('rankId'+inc).value=0;
					document.getElementById('sName'+inc).value="";
					document.getElementById('hinId'+inc).value="";
					document.getElementById('age'+inc).value="";
					document.getElementById('medCatId'+inc).value = 0;
					document.getElementById('dateOfLastME'+inc).value="";
				var e=eval(document.getElementById('serviceNo'+inc));
				e.focus();
				return false;
			}
		}
	}
	
}
	
function addRow(){

	  var tbl = document.getElementById('grid');

	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);

	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'serialNo' + iteration;
	  e0.id = 'serialNo' + iteration;
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
      e0.size = '1';
      e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'serviceNo'+iteration ;
	  e1.id = 'serviceNo' + iteration;
	  e1.onblur=function(){
		  ajaxFunctionPilotRegService(aircraftEmergency,iteration,this.value);check(this.value,iteration);
		  };
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);



 	var cellRight2 = row.insertCell(2);
 	var e2 = document.createElement('Select');
 	e2.name='<%=RANK_ID%>'+iteration
 	e2.id='<%=RANK_ID%>'+iteration
 	e2.setAttribute('tabindex','1');
 	e2.options[0] = new Option('Select', '0');
 	for(var i= 0;i<rankArray.length;i++ ){
 	   e2.options[i+1] = new Option(rankArray[i][1],rankArray[i][0]);
 	   }
 	cellRight2.appendChild(e2);
 	
    
    var e22 = document.createElement('input');
	  e22.type = 'hidden';
	  e22.name = 'rankId'+ iteration ;
	  e22.id = 'rankId' + iteration;
	  e22.setAttribute('tabindex','1');
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(e22);
  	  
    var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'sName'+ iteration;
	  e3.id = 'sName' + iteration;
   	  e3.setAttribute('maxlength', 30);
	  e3.setAttribute('tabindex','1');

	  var e33 = document.createElement('input');
	  e33.type = 'hidden';
	  e33.name = 'hinId'+ iteration;
	  e33.id = 'hinId' + iteration;
   	  e33.size = '20';
   	 e33.value = '0';
   	  e33.setAttribute('maxlength', 30);
   	 cellRight3.appendChild(e3);

   	 var e43 = document.createElement('input');
   	 e43.type = 'hidden';
	  e43.name = 'pilotId'+ iteration;
	  e43.id = 'pilotId' + iteration;
  	  e43.size = '20';
  	e43.value = '0';
  	  e43.setAttribute('maxlength', 30);
  	 cellRight3.appendChild(e43);
   	 
   	cellRight3.appendChild(e33);



    var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'age'+ iteration;
	  e4.id = 'age' + iteration;
 	  e4.setAttribute('maxlength', 30);
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);


	
  
    var cellRight7 = row.insertCell(5);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	   e7.onclick = function(){addRow();};
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(6);
	  var e8= document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  //  e5.setAttribute('onClick', 'removeRow('grid','hdb',this);');
	  e8.onclick =function(){removeRow('grid','hdb',this);};
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);

	}


	function removeRow1()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}
	function removeRow(idName,countId,obj)
	{
		var tbl = document.getElementById(idName);
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  //	tbl.deleteRow(lastRow - 1);
		    var i=obj.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
		  }
	}

</script>