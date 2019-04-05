
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
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
	List<OpdPatientDetails> fwcPatientDataList = new ArrayList<OpdPatientDetails>();
	
	List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();	
	if(map.get("fwcPatientDataList") != null){
		fwcPatientDataList=(List)map.get("fwcPatientDataList");
	}
	if(map.get("fwcOpdDetailHistoryList") != null){
		fwcOpdDetailHistoryList=(List)map.get("fwcOpdDetailHistoryList");
	}
	
	Box box = HMSUtil.getBox(request);

	

%>
<!--main content placeholder starts here-->
<form name="fwcVisitEntryDirect" action="" method="post">

<div class="titleBg">
<h2>Delivery Details</h2>
</div>

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div id="testDiv">
<div class="Block"><label>Service No. <span>*</span></label>
<input	type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""	validate="Service No.,metachar,yes"
	onblur="submitProtoAjaxWithDivName('fwcVisitEntryDirect','/hms/hms/fwc?method=getPatientDetailsFordirectVisitEntry','hinDiv');" />
<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId"	value="" />
</div>
</div>
</div>

<div class="clear"></div>


<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0"  id="grid">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Time</th>
<th>Type</th>
<th>Place</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%int inc=1;%>
<tr>

<td><input type="text" name="slNo<%=inc %>" id="slNo<%=inc %>"  class="auto" size="11" value="<%=inc %>"/></td>

<td><input type="text" name="givenOn<%=inc %>" readonly="readonly" id="givenOn<%=inc %>" class="date" class="auto" size="11" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('givenOn<%=inc %>',document.fwcVisitEntryDirect.givenOn<%=inc %>, event)"	validate="Pick a date"  />

</td>

<td><input  type="text" name="time<%=inc %>" id="time<%=inc %>" class="auto" size="11" validate="Time,string,yes" maxlength="5" onkeyup="mask(this.value,this,'2',':');"/></td>

<td>
<select name="typeDelivery<%=inc %>"  id="typeDelivery<%=inc %>"  validate="Type,metachar,yes" >
<option value="Normal">Normal</option>
<option value="Cesarion">Cesarion</option>
<option value="Abortion">Abortion</option>
</select>
</td>

<td>
<select name="place<%=inc %>" id="place<%=inc %>" validate="Place,metachar,yes" >
<option value="Institutional">Institutional</option>
<option value="Domestic">Domestic</option>
</select></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hiddenValue',this);" tabindex="1" /></td>
</tr>

</table>

	<input type="hidden" value="<%=inc%>" name="hiddenValue" id="hiddenValue" />
</div>
<div class="clear paddingTop15"></div>


		<div class="Block">
		
<label>Doctor's Name</label>
<input type="text" name="drName" maxlength="20" validate="Doctor's Name,metachar,no"/>

<label>Hospital Name</label>
<input type="text" name="hospName" maxlength="20" validate="Hospital Name,metachar,no"/>

<div class="clear"></div>

<label>If Domestic</label>
<select name="domestic">
<option value="LHV / ANM">LHV / ANM</option>
<option value="Trained Birth AH">Trained Birth AH</option>
<option value="Untrained">Untrained</option>
</select>

<div class="clear"></div>


</div>

<div class="clear"></div>
<h4>Children Details</h4>
<div class="clear"></div>

<div class="Block">

<label>Gender</label>
<select name="gender">
<option value="">Select</option>
<option value="Male">Male</option>
<option value="Female">Female</option>
</select>

<label>Weight</label>
<input type="text" name="weight" class="auto" size="16" maxlength="3" validate="Weight,float,no"/>

<label>Head Circumference</label>
<input type="text" name="headCirum" class="auto" size="16" maxlength="3" validate="Head Circumference,float,no"/>
<label class="unit">cm</label>

<div class="clear"></div>

<label>Chest</label>
<input type="text" name="chest" class="autoArial" size="15" maxlength="3" validate="Chest,float,no"/>
<label class="unit2">cm</label>

<label>Cry</label>
<input type="text" name="cry" maxlength="3" validate="Cry,metachar,no"/>

<label>Reflexes</label>
<input type="text" name="reflexes" maxlength="3" validate="Reflexes,metachar,no"/>

<div class="clear"></div>

<label>Obscure</label>
<input type="text" name="obscure" maxlength="3" validate="Obscure,metachar,no"/>

<label>Skin Colour</label>
<input type="text" name="skinColor" class="" value="" size="" maxlength="10" validate="Skin Colour,metachar,no"/>

<label>Urine</label>
<select name="urine">
<option value="P">Passed</option>
<option value="N">Not Passed</option>

</select>

<div class="clear"></div>
<label>Respiratory Rate</label>
<input type="text" name="respiratory" class="autoArial" size="15" maxlength="10" validate="Respiratory Rate,metachar,no"/>
<label class="unit2">/min</label>

<label>Heart Rate</label>
<input type="text" name="heartRate" class="autoArial" size="15" maxlength="3" validate="Heart Rate,metachar,no"/>
<label class="unit2">/min</label>


<label>Pulses</label>
<input type="text" name="pulses" class="" value="" size="" maxlength="4" validate="Pulses,int,no"/>
<div class="clear"></div>

<label>Liver</label>
<input type="text" name="liver" class="" value="" size="17" maxlength="10" validate="Liver,metachar,no"/>


<label>Spleen</label>
<input type="text" name="spleen" class="" value="" size="17" maxlength="10" validate="Spleen,metachar,no"/>


<label>Nervous System</label>
<input type="text" name="nervousSystem" class="" value="" size="17" maxlength="10" validate="Nervous System,metachar,no"/>



<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="remarks" class="" value="" size="17" maxlength="10" validate="Remarks,metachar,no"/>

<label>Status</label>
<select name="status">
<option value="">Select</option>
<option value="Alive">Alive</option>
<option value="Stillborn">Stillborn</option>
</select>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--<input type="button" name="Button" value="Upload" class="button" />
--><input type="button" name="Button" value="Submit" class="button" onclick="submitForm('fwcVisitEntryDirect','/hms/hms/fwc?method=submitDeliveryDetails')"/>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
function addRow(){
    
		var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
	   	var iteration = lastRow;
	  	var row = tbl.insertRow(lastRow);
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration;
	
 	  	var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
	  	e0.type = 'text';
	  	e0.name='slNo'+iteration;
	  	e0.id='slNo'+iteration
		e0.size='10';
		e0.value=iteration;
	  	e0.setAttribute('tabindex','1');
	  	cellRight0.appendChild(e0);

	  	var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.className = 'date';
		e1.name='givenOn'+ iteration;
		e1.id='givenOn'+iteration;
		e1.size='11';
		e1.readOnly='readonly';
		e1.setAttribute('tabindex','1');
		cellRight1.appendChild(e1);

		var e11 = document.createElement('img');
		e11.src = '/hms/jsp/images/cal.gif';
		e11.id = 'givenOn'+iteration;
		e11.onclick = function(event){
		setdate('',document.getElementById('givenOn'+iteration),event) };
		cellRight1.appendChild(e11);

	   	var cellRight2 = row.insertCell(2);
 	  	var e2 = document.createElement('input');
	  	e2.type = 'text';
	  	e2.name='time'+iteration;
	  	e2.id='time'+iteration
	  	e2.size=10;
	  	e2.maxlength=5;
	  	e2.onkeyup=function(){mask(this.value,this,'2',':')};
	  	e2.setAttribute('tabindex','2');
		cellRight2.appendChild(e2);

	  	var cellRight3 = row.insertCell(3);
		var e3 = document.createElement('Select');
	  	e3.name='typeDelivery'+iteration;
	  	e3.id='typeDelivery'+iteration;
	  	e3.classname='smalllabel';
	  	e3.setAttribute('tabindex','1');
	  	e3.options[0] = new Option('Select', '');
	  	e3.options[1] = new Option('Normal', 'Normal');
	   	e3.options[2] = new Option('Cesarion', 'Cesarion');
	   	e3.options[3] = new Option('Abortion', 'Abortion');
	   	cellRight3.appendChild(e3);

		var cellRight4 = row.insertCell(4);
		var e4 = document.createElement('Select');
		e4.name='place'+iteration;
		e4.id='place'+iteration;
		e4.classname='smalllabel';
		e4.setAttribute('tabindex','1');
		e4.options[0] = new Option('Select', '');
		e4.options[1] = new Option('Institutional', 'Institutional');
		e4.options[2] = new Option('Domestic', 'Domestic');
		cellRight4.appendChild(e4);

		var cellRight5 = row.insertCell(5);
	  	var e5 = document.createElement('input');
	  	e5.type = 'button';
		e5.className = 'buttonAdd';
	  	e5.name='Button';
	  	e5.setAttribute('tabindex','1');
	  	e5.onclick = function(){addRow("grid",hdb,this);}; 
	  	cellRight5.appendChild(e5);

		var cellRight6 = row.insertCell(6);
	  	var e6 = document.createElement('input');
	  	e6.type = 'button';
	  	e6.className = 'buttonDel';
	  	e6.name='delete';
	  	e6.setAttribute('tabindex','1');
	  	e6.onclick = function(){removeRow("grid",hdb,this);}; 
	  	cellRight6.appendChild(e6);
}

function removeRow(idName,countId,obj)
{
var tbl = document.getElementById(idName);
var lastRow = tbl.rows.length;
if (lastRow > 2){
  var i=obj.parentNode.parentNode.rowIndex;
  tbl.deleteRow(i);
}
}
	</script>