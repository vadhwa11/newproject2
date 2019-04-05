
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
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
	List<Visit> visitList = new ArrayList<Visit>();
	if(map.get("visitList")!= null){
	visitList = (List)map.get("visitList");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	String patientName="";
	Patient patient = new Patient();
	String servicePersionName="";
	Visit visit = new Visit();
	if(visitList.size()>0){
	 visit=(Visit)visitList.get(0);
	 patient = (Patient)visit.getHin();
	if(patient.getPFirstName()!= null){
	patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
	patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
	patientName=patientName+" "+patient.getPLastName();
	}
	if(patient.getSFirstName()!= null){
	 servicePersionName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSLastName();
	}
}
%>
<!--main content placeholder starts here-->
<form name="immunization" action="" method="post">

<div class="titleBg">
<h2>Immunization</h2>
</div>
<div class="Block">

<label>Service No.</label>
 
<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>
 
<label>Patient Name</label> 
 <label class="value"><%=patientName %></label>
<label>Relation</label>
 
<label class="value"><%=patient.getRelation()!=null ?patient.getRelation().getRelationName(): ""  %></label>
 

<div class="clear"></div>
<label>Rank</label>

<label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>


<label>Name</label> 
 <label class="value"><%=servicePersionName %></label>


<label>Trade/Branch</label>
 
<label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<div class="clear"></div>
<label>Unit</label>
 
<label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>


<label>Age</label> 

<label class="value"><%=patient.getAge()!= null?patient.getAge():"" %></label> 


<input type="hidden" value="37 Years" id="ageId" name="ageId">

 <label>Gender</label>
 
<label class="value"><%=patient.getSex()!= null?patient.getSex().getAdministrativeSexName():"" %></label>
<input type="hidden" value="2" id="genderId" name="genderId">


<div class="clear"></div>

<label>Marital Status</label> 

<label class="value"><%=patient.getMaritalStatus()!= null?patient.getMaritalStatus().getMaritalStatusName():"" %></label> 
 

<label>Blood Group</label>

<label class="value"><%=patient.getBloodGroup()!= null?patient.getBloodGroup().getBloodGroupName():"" %></label>
<label>Medical Disability</label>
<input type="hidden" name="medicalDisability"></input>
<input type="hidden" name="visitId" value="<%=visit.getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
<%-- <input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />--%>
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="text" value="<%=patient.getServiceNo()%>" />
<%-- <input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />--%>
<input name="<%=HIN_NO%>" type="hidden"	value="<%=patient.getHinNo()%>" />


</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<label>Immunization For</label>
<select name="immunizationType"  onchange="changeImmunizationType(this.value)">
<option value="Infant">Infant</option>
<option value="ANC">ANC</option>
</select>
</div>
<script type="text/javascript">
	function changeImmunizationType(val){
	if(val == 'Infant'){
		document.getElementById('infantGrid').style.display = 'inline'
		document.getElementById('ancGrid').style.display = 'none'
	}else if(val == 'ANC'){
		document.getElementById('ancGrid').style.display = 'inline'
	    document.getElementById('infantGrid').style.display = 'none'

	}
  }


</script>
<div class="clear"></div>
<div id="infantGrid">
<%-- <h4>Infant</h4>--%>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0"  cellspacing="0"  id="infantImmunizationgrid">

<tr>
<th>Vaccine</th>
<th>Dose</th>
<th>Route</th>
<th>Given On</th>
<th>Due On</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int i=1;


%>
<tr>
		<td>
		<%-- <input type="hidden" name="immunId<%=i %>" id="immunId<%=i %>" value="0" />--%>
		
		<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="" size="40"  maxlength="80"/>
		<%--<input type="hidden" name="immunizationDetailsId<%=i %>" id="immunizationDetailsId<%=i %>" value="0" />--%>
		<%--<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=i %>" value="" size="40" onblur="if(this.value!=''){getImmunizationId(this.value,1);}"/>
		<input type="hidden" name="immunizationId<%=i %>" id="immunizationId<%=i %>" value=""/>--%>
		     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		//	  new Ajax.Autocompleter('immunizationName<%=i %>','ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName<%=i %>'});
			</script>
		</td>
		<td><input	type="text" name="dose<%=i %>" value="" id="dose<%=i %>" size="5" maxlength="5"/></td>
		<td><input	type="text" name="route<%=i %>" value="" id="route<%=i %>" size="10" maxlength="20"/></td>
		<td>	
			<input	type="text" name="immuDate<%=i %>" value="" id="immuDate<%=i %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunization.immuDate<%=i %>,event)" /> 
			
			</td>
		<td>	
			<input	type="text" name="dueDate<%=i %>" value="" id="dueDate<%=i %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunization.dueDate<%=i %>,event)" /> 
			</td>
			
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInfant();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this,<%=i %>,infantImmunizationgrid);" tabindex="1" />
			</td>
	</tr>
</table>
<input type="hidden" name="count" value="<%=i %>" id="count" />
</div>
</div>

<div id="ancGrid" style="display: none">
<%-- <h4>Infant</h4>--%>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0"  cellspacing="0"  id="ancImmunizationgrid">

<tr>
<th>Vaccine</th>
<th>Dose</th>
<th>Route</th>
<th>Given On</th>
<th>Due On</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int k=1;


%>
<tr>
		<td>
		<%-- <input type="hidden" name="immunIdAnc<%=k %>" id="immunIdAnc<%=k %>" value="0" />--%>
		
		<input type="text" name="immunizationNameAnc<%=k %>" id="immunizationNameAnc<%=k%>" value="" size="40"  maxlength="80"/>
		<%--<input type="hidden" name="immunizationDetailsId<%=i %>" id="immunizationDetailsId<%=i %>" value="0" />--%>
		<%--<input type="text" name="immunizationName<%=i %>" id="immunizationName<%=k %>" value="" size="40" onblur="if(this.value!=''){getImmunizationId(this.value,1);}"/>
		<input type="hidden" name="immunizationIdAnc<%=i %>" id="immunizationIdAnc<%=k %>" value=""/>--%>
		     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		//	  new Ajax.Autocompleter('immunizationName<%=i %>','ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName<%=k %>'});
			</script>
		</td>
		<td><input	type="text" name="doseAnc<%=k %>" value="" id="doseAnc<%=i %>" size="5" maxlength="5"/></td>
		<td><input	type="text" name="routeAnc<%=k %>" value="" id="routeAnc<%=i %>" size="10" maxlength="20"/></td>
		<td>	
			<input	type="text" name="immuDateAnc<%=k %>" value="" id="immuDateAnc<%=k %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunization.immuDateAnc<%=k %>,event)" /> 
			
			</td>
		<td>	
			<input	type="text" name="dueDateAnc<%=k %>" value="" id="dueDateAnc<%=k %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.immunization.dueDateAnc<%=k %>,event)" /> 
			</td>
			
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForAnc();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this,<%=k %>,ancImmunizationgrid);" tabindex="1" />
			</td>
	</tr>
</table>
<input type="hidden" name="cnt" value="<%=k %>" id="cnt" />
</div>
</div>
<div class="clear paddingTop15"></div>
<input type="button" value="Submit"  class="button" name="Button" onclick="submitForm('immunization','fwc?method=submitFwcImmunizationDetail&flag=immunization');" />


<script type="text/javascript">
function removeRow(obj,countId,idName)
{
  var tbl =idName;
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}
function addRowForInfant(){
	
	  var tbl = document.getElementById('infantImmunizationgrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('count');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '40';
	  e1.maxlength = '80';
	  e1.name='immunizationName'+iteration;
	  e1.id='immunizationName'+iteration
	//  e1.onblur=function() {if(this.value!=""){getImmunizationId(this.value,iteration);}}
	  cell1.appendChild(e1);
	 // new Ajax.Autocompleter('immunizationName'+iteration,'ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName'+iteration});
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='immunizationId'+iteration;
	  e11.id='immunizationId'+iteration
	  cell1.appendChild(e11);

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='immunId'+(iteration);
	  e12.id='immunId'+(iteration);
	  e12.value='0';
	  cell1.appendChild(e12);

	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='dose'+iteration;
	  e2.id='dose'+iteration
	  e2.size = '5';
	  e2.maxLength = '5';
	  e2.tabindex='1';
	  cell2.appendChild(e2);


	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='route'+iteration;
	  e3.id='route'+iteration
	  e3.maxLength = '5';
	  e3.size = '10';
	  e3.tabindex='1';
	  cell3.appendChild(e3);
	  
	  var cell4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='immuDate'+iteration;
	  e4.id='immuDate'+iteration
	  e4.size = '10';
	  e4.tabindex='1';
	  var e4Img = document.createElement('img');
	  e4Img.src = '/hms/jsp/images/cal.gif';
	  e4Img.className = 'calender';
	  e4Img.id = 'calender'+iteration;
	  e4Img.onclick = function(event){
					setdate('',document.getElementById('immuDate'+iteration),event) };
	  cell4.appendChild(e4);
	  cell4.appendChild(e4Img);
	  
	  
	  var cell5 = row.insertCell(4);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='dueDate'+iteration;
	  e6.id='dueDate'+iteration
	  e6.size = '10';
	  e6.setAttribute('tabindex','1');
	  var e6Img = document.createElement('img');
	  e6Img.src = '/hms/jsp/images/cal.gif';
	  e6Img.className = 'calender';
	  e6Img.id = 'calender'+iteration;
	  e6Img.onclick = function(event){
					setdate('',document.getElementById('dueDate'+iteration),event) };
	  cell5.appendChild(e6);
	  cell5.appendChild(e6Img);

	  
	  var cell6 = row.insertCell(5);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='Button'+iteration;
	  e8.onclick = function(){addRowForInfant();}; 
	  e8.tabindex='1';
	  cell6.appendChild(e8);

	  var cell7 = row.insertCell(6);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='delete'+iteration;
	  e9.onclick = function(){removeRow(this,iteration,infantImmunizationgrid);}; 
	  e9.tabindex='1';
	  cell7.appendChild(e9);
}

function addRowForAnc(){
	  var tbl = document.getElementById('ancImmunizationgrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('cnt');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '40';
	  e1.maxlength = '80';
	  e1.name='immunizationName'+iteration;
	  e1.id='immunizationName'+iteration
	//  e1.onblur=function() {if(this.value!=""){getImmunizationId(this.value,iteration);}}
	  cell1.appendChild(e1);
	 // new Ajax.Autocompleter('immunizationName'+iteration,'ac2update1','registration?method=getImmunizationForAutoComplete',{parameters:'requiredField=immunizationName'+iteration});
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='immunizationId'+iteration;
	  e11.id='immunizationId'+iteration
	  cell1.appendChild(e11);

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='immunId'+(iteration);
	  e12.id='immunId'+(iteration);
	  e12.value='0';
	  cell1.appendChild(e12);
	  
	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.name='flag'+(iteration);
	  e13.id='flag'+(iteration);
	  e13.value='ANC';
	  cell1.appendChild(e13);

	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='dose'+iteration;
	  e2.id='dose'+iteration
	  e2.size = '5';
	  e2.maxLength = '5';
	  e2.tabindex='1';
	  cell2.appendChild(e2);


	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='route'+iteration;
	  e3.id='route'+iteration
	  e3.maxLength = '5';
	  e3.size = '10';
	  e3.tabindex='1';
	  cell3.appendChild(e3);
	  
	  var cell4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='date'+iteration;
	  e4.id='date'+iteration
	  e4.size = '10';
	  e4.tabindex='1';
	  var e4Img = document.createElement('img');
	  e4Img.src = '/hms/jsp/images/cal.gif';
	  e4Img.className = 'calender';
	  e4Img.id = 'calender'+iteration;
	  e4Img.onclick = function(event){
					setdate('',document.getElementById('date'+iteration),event) };
	  cell4.appendChild(e4);
	  cell4.appendChild(e4Img);
	  
	  
	  var cell5 = row.insertCell(4);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='dom'+iteration;
	  e6.id='dom'+iteration
	  e6.size = '10';
	  e6.setAttribute('tabindex','1');
	  var e6Img = document.createElement('img');
	  e6Img.src = '/hms/jsp/images/cal.gif';
	  e6Img.className = 'calender';
	  e6Img.id = 'calender'+iteration;
	  e6Img.onclick = function(event){
					setdate('',document.getElementById('dom'+iteration),event) };
	  cell5.appendChild(e6);
	  cell5.appendChild(e6Img);

	  
	  var cell6 = row.insertCell(5);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='Button'+iteration;
	  e8.onclick = function(){addRowForAnc();}; 
	  e8.tabindex='1';
	  cell6.appendChild(e8);

	  var cell7 = row.insertCell(6);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='delete'+iteration;
	  e9.onclick = function(){removeRow(this,iteration,ancImmunizationgrid);}; 
	  e9.tabindex='1';
	  cell7.appendChild(e9);
}






</script>
</form>