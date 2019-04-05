<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


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


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List<MasFrequency>)map.get("frequencyList");
	}
	
	//if(map.get("patientList") != null){
		//patientList = (List<OpdPatientDetails>)map.get("patientList");
	//}
	List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("therapyTypeList") != null){
		therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	Map<String, Object> visitMap = new HashMap<String, Object>();
	if(map.get("visitMap")!=null){
		visitMap = (Map<String, Object>)map.get("visitMap");
	}
	List<PhysioRequisitionDetail> physiotherapyDetailList= new ArrayList<PhysioRequisitionDetail>();
	if(map.get("phyVisitList") != null){
		physiotherapyDetailList = (List<PhysioRequisitionDetail>)map.get("phyVisitList");
	}
	List<Visit> physioWaitingList = new ArrayList<Visit>();
	if(visitMap.get("physioWaitingList") != null){
		physioWaitingList = (List<Visit>)visitMap.get("physioWaitingList");
	}
	//OpdPatientDetails opdPatientDetails = patientList.get(0);
	//Visit visit = opdPatientDetails.getVisit();
	//Patient patient = visit.getHin();
	Visit visit = new Visit();
	Patient patient = new Patient();
	int physioRequisitionHeaderId = 0;
	PhysioRequisitionDetail physiotherapyDetails = new PhysioRequisitionDetail();
	if(physiotherapyDetailList.size() > 0){
		physiotherapyDetails = physiotherapyDetailList.get(0);
		 visit = physiotherapyDetails.getPhysioRequisitionHeader().getVisit();
		 patient = physiotherapyDetails.getPhysioRequisitionHeader().getHin();
		 physioRequisitionHeaderId = physiotherapyDetails.getPhysioRequisitionHeader().getId();
	}
%>



<form name="physiotherapyVisitEntryDirect" method="post">
<div class="titleBg">
</div>
<div class="clear"></div>
<%
if(physioWaitingList.size() > 0){
%>
<h4>Requisition from Reception</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Service No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age</th>
	</tr>
<%
	for(Visit visitObj : physioWaitingList){
%>
<tr onclick="submitProtoAjax('physiotherapyVisitEntryDirect','/hms/hms/physiotherapy?method=getPatientData&hinId=<%=visitObj.getHin().getId() %>&flag=visitWaiting&visitId=<%=visitObj.getId() %>')">
	<td><%=HMSUtil.convertDateToStringWithoutTime(visitObj.getVisitDate()) %></td>
	<td><%=visitObj.getHin().getServiceNo()!=null?visitObj.getHin().getServiceNo():"" %></td>
	<%
		String pName = visitObj.getHin().getPFirstName();
		if(visitObj.getHin().getPMiddleName()!=null)
			pName += visitObj.getHin().getPMiddleName();
		
		if(visitObj.getHin().getPLastName()!=null)
			pName += visitObj.getHin().getPLastName();
		
		
	%>
	<td><%=pName%></td>
	<td><%=visitObj.getHin().getRelation().getRelationName() %></td>
	<td><%=visitObj.getHin().getRank()!=null?visitObj.getHin().getRank().getRankName():"" %></td>
	<%
		String sName = visitObj.getHin().getSFirstName()!=null?visitObj.getHin().getSFirstName():"";
		if(visitObj.getHin().getSMiddleName()!=null)
			sName += visitObj.getHin().getSMiddleName();
		
		if(visitObj.getHin().getSLastName()!=null)
			sName += visitObj.getHin().getSLastName();
		
		
	%>
	<td><%=sName %></td>
	<td><%=visitObj.getAge() %></td>
</tr>

<%} %>
</table>
</div>
<%} %>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div id="testDiv">
<div class="Block"><label>Service No. <span>*</span></label> <input
	type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""
	validate="Service No.,metachar,yes"
	onblur="submitProtoAjaxWithDivName('physiotherapyVisitEntryDirect','/hms/hms/physiotherapy?method=getPatientDetailsFordirectVisitEntry','hinDiv');" />
<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId"	value="" />
</div>
</div>
</div>
<div class="clear"></div>
<h4>Physiotherapy Details</h4>
<div class="clear"></div>

<input id="hinId" type="hidden" name="<%=HIN_ID %>"
	value="<%=patient.getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId()%>"> <input
	type="hidden" name="physioRequisitionHeaderId"
	value="<%=physioRequisitionHeaderId%>"> <script
	type="text/javascript">var frequencyArray=new Array();</script>

<div class="clear"></div>
<!--  <div id="testDiv">-->
<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0"
	id="tharapyGrid">
	<thead>
		<tr>
			<th></th>
			<th>Therapy name</th>
			<th colspan="2">Duration</th>
			<th>Frequency</th>
			<th>No. of Days</th>
			<th>Time Begun</th>
			<th>Time Completed</th>
			<th>Sitting Time</th>
			<%-- <th>Next App. Date</th>
			<th>Next App. Time</th>--%>
			<th>Remarks</th>
			<th>Add</th>
			<th>Delete</th>
		</tr>
	</thead>


	<%
	int i=1;
	
	%>
	<tr>
		<td><input type="radio" class="radiogrid"
			name="physioRequisitionHeaderId" value=""
			id="physioRequisitionHeaderId" /></td>

		<td><input type="text" value="" tabindex="1" id="therapyTypeId"
			size="20" name="therapyType"
			onblur="if(this.value!=''){getTheraphyId(this.value,<%=i %>);}" />
		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('therapyTypeId','ac2update1','physiotherapy?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'});
			</script>
		<div id="therapyDiv<%=i %>"><input type="hidden"
			name="therapyId<%=i %>" id="therapyId<%=i %>" value="" /></div>
		</td>
		<td><input type="text" name="duration<%=i %>" tabindex="1"
			id="durationId<%=i %>" value="" size="3" maxlength="5" /></td>
			<td width="8%">Min.</td>
		<td><select name="frequency<%=i %>" id="frequency<%=i %>" 
			tabindex="1">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       
          %>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName()%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int j = 0; j < frequencyList.size(); j++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(j);
     			 %> <script>

     			frequencyArray[<%=j%>]= new Array();
     			frequencyArray[<%=j%>][0] = "<%=masFrequency.getId()%>";
     			frequencyArray[<%=j%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
		</td>
		
		<td><input type="text" name="noOfDays<%=i %>" value=""
			tabindex="1" id="noOfDays<%=i %>" size="8" maxlength="3" /></td>

		<td><input type="text" name="timeBegin<%=i %>" value=""
			tabindex="1" id="timeBegin<%=i %>" size="10"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
			onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" name="timeComplete<%=i %>" value=""
			tabindex="1" id="timeComplete<%=i %>" size="10"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
			onBlur="IsValidTimeWithBlankCheck(this.value,this.id);calculateTime(<%=i %>);"
			maxlength="5" /></td>
		<td><input type="text" name="sittingTime<%=i %>" value=""
			tabindex="1" id="sittingTime<%=i %>" size="10"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
			onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5" /></td>
		<%-- <td><input type="text" name="nextAppointmentDate<%=i %>" value=""
			tabindex="1" id="nextAppointmentDate<%=i %>" size="8" maxlength="3" />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" class="calender"
			onClick="setdate('nextAppointmentDate<%=i %>',document.physiotherapyVisitEntryDirect.nextAppointmentDate<%=i %>,event)" /></td>
		<td><input type="text" name="nextAppointmentTime<%=i %>" value=""
			tabindex="1" id="nextAppointmentTime<%=i %>" size="3"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
			onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5" /></td>--%>
			
		<td><input type="text" name="remarks<%=i %>" tabindex="1"
			value="" id="remarks<%=i %>" size="5" maxlength="50" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
		<td></td>
	</tr>



</table>
<input type="hidden" name="tharapyCount" value="<%=i %>"
	id="tharapyCount" />
<div class="clear"></div>
<div class="division"></div>
<label class="auto">Physiotherapy Completed</label> <input
	type="checkbox" name="phyCompleted" value="y">
	<!--  </div>-->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>



<div id="edited"></div>
<input type="button" name="submitForDisable" id="submitForDisable" value="Submit" class="button"
	onClick="if(validatePhyFields()){submitForm('physiotherapyVisitEntryDirect','/hms/hms/physiotherapy?method=savePhysiotherapyDetails')};" />
	<!--  <input type="button" name="submitForDisable" id="submitForDisable" value="Appointment" class="button"
	onClick="if(validatePhyFields()){submitForm('physiotherapyVisitEntryDirect','/hms/hms/physiotherapy?method=savePhysiotherapyDetails&buttonName=Appointment')};" />-->
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> 
	<input type="button" class="button" value="Back" align="right" onClick="history.back();" />
	

<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>" value="<%=time%>" />

</div>

<div id="statusMessage" class="messagelabel">
<div class="clear"></div>
</div>
</form>
<script>
function getTheraphyId(val,inc){
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var indexForTheraphyCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var therapyId = val.substring(index1,index2);
			var indexForTheraphyCode = indexForTheraphyCode--;
			var theraphyCode = val.substring(0,indexForTheraphyCode);

			 
			if(therapyId == "" ) {
		      	document.getElementById('therapyTypeId'+inc).value="";
		      	//document.getElementById('pvmsNo'+inc).value="";
		     // 	document.getElementById('clinicalNotes'+inc).value="";
		 	 // 	document.getElementById('qty'+inc).value="";
		      	return;
			}
			
		if(therapyId!=""){
			submitProtoAjaxWithDivName('physiotherapyVisitEntryDirect','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
		}
	}
		
	}

function addRow(){
	
	  var tbl = document.getElementById('tharapyGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('tharapyCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'radio';
	  e0.name='parent'+iteration;
	  e0.id='parent'+iteration
	  e0.value=(iteration);
	  e0.size = '2'
	  cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '20';
	  e1.name='therapyType'+iteration;
	  e1.id='therapyTypeId'+iteration
	  e1.onblur=function() {getTheraphyId(this.value,iteration);}
	  cell1.appendChild(e1);
	  new Ajax.Autocompleter('therapyTypeId'+iteration,'ac2update1','physiotherapy?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'+iteration});

	  var e11 = document.createElement('input');
	  var ediv = document.createElement('div');
	  ediv.id='therapyDiv'+(iteration);
	  e11.type = 'hidden';
	  e11.name='therapyId'+iteration;
	  e11.id='therapyId'+iteration
	  e11.value='0'
	  cell1.appendChild(ediv);
	  ediv.appendChild(e11);
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='duration'+iteration;
	  e2.id='durationId'+iteration
	  e2.size = '3'
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(3);
	  cell3.innerHTML='Min.'

	  var cell4 = row.insertCell(4);
	  var e3 = document.createElement('Select');
	  e3.name='frequency'+iteration;
	  e3.id='frequency'+iteration;
	  e3.setAttribute('tabindex','1');
	  e3.options[0] = new Option('Select', '0');
	   for(var k = 0;k<frequencyArray.length;k++ ){
	      e3.options[k+1] = new Option(frequencyArray[k][1],frequencyArray[k][0]);
	      }
	   cell4.appendChild(e3);

	  var cell5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='8';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  cell5.appendChild(e4);
	  
	  var cell6 = row.insertCell(6);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='timeBegin'+iteration;
	  e5.id='timeBegin'+iteration
	  e5.maxLength = '5';
	  e5.size = '10';
	  e5.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e5.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e5.setAttribute('tabindex','1');
	  cell6.appendChild(e5);

	  
	  var cell7 = row.insertCell(7);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='timeComplete'+iteration;
	  e6.id='timeComplete'+iteration
	  e6.size = '10';
	  e6.maxLength = '5';
	  e6.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);calculateTime(iteration);}
	  e6.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e6.setAttribute('tabindex','1');
	  cell7.appendChild(e6);

	  var cell8= row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='sittingTime'+iteration;
	  e8.id='sittingTime'+iteration
	  e8.size = '10';
	  e8.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e8.onkeyup = function(){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);

	  /*var cell8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='nextAppointmentDate'+iteration;
	  e8.id='nextAppointmentDate'+iteration
	  e8.size = '8';
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);

	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
      eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('nextAppointmentDate'+iteration),event) };
	   cell8.appendChild(e8);
	  cell8.appendChild(eImg);

	  var cell9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='nextAppointmentTime'+iteration;
	  e9.id='nextAppointmentTime'+iteration
	  e9.size = '3';
	  e9.onblur = function(){IsValidTimeWithBlankCheck(this.value,this.id);}
	  e9.onkeyup = function(event){maskWithBackspaceCheck(this.value,this,'2',':',event);}
	  e9.setAttribute('tabindex','1');
	  cell9.appendChild(e9);*/

	 // var cell9 = row.insertCell(9);
	 // cell9.innerHTML='--'

	  var cell9 = row.insertCell(9);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.name='remarks'+iteration;
	  e10.id='remarks'+iteration
	  e10.size = '5';
	  e10.setAttribute('tabindex','1');
	  cell9.appendChild(e10);


	  var cell10 = row.insertCell(10);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonAdd';
	  e11.name='Button'+iteration;
	  e11.onclick= function(){addRow();};
	  e11.setAttribute('tabindex','1');
	  cell10.appendChild(e11);

	  var cell11 = row.insertCell(11);
	  var e12 = document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonDel';
	  e12.name='delete'+iteration;
	 // e12.setAttribute('onClick', 'removeRow();'); 
	  e12.onclick= function(){removeRow();};
	  e12.setAttribute('tabindex','1');
	  cell11.appendChild(e12);
}

function validatePhyFields(){
	var count = document.getElementById('tharapyCount').value;
	var flag ='';
	 for(var i = 1; i <= count; i++){
		 if(document.getElementById('therapyId'+i)){
		var theraphyId = document.getElementById('therapyId'+i).value;
		if(theraphyId!=='0')
	      	 {
	          flag = 'filled';
	          break;
			}
		 }
		}

	 var msg = "";
	 for(var j = 1;j <= count;j++){
		 if(document.getElementById('therapyId'+j)){
				var therapyId = document.getElementById('therapyId'+j).value;
				if( therapyId != '0'){
				if(document.getElementById('durationId'+j).value == 0 )
	            {
					msg += "Please select the Duration in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('frequency'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the Frequency in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('noOfDays'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the no of days in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeBegin'+j).value == 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Begin in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeComplete'+j).value == 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Complete in row "+(j)+".\n";
					
				 }
				if(document.getElementById('sittingTime'+j).value == 0  && document.getElementById('timeComplete'+j).value != 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Sitting Time in row "+(j)+".\n";
					
				 }	
				}
		 	}
		}
	 if(flag==''){
		 msg += "Please select Therapy Type.\n";;
					
		}
		if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	
	 }
	


function HMStoSec1(T) { // h:m:s

	  var A = T.split(/\D+/) ;
	
	  return (A[0]*60 + +A[1])*60
	}
function calculateTime(inc){

	var time1 = HMStoSec1(document.getElementById('timeBegin'+inc).value);
	var time2 = HMStoSec1(document.getElementById('timeComplete'+inc).value);
	 var totalTime ;
	var diff = time2 - time1;
	if(document.getElementById('timeBegin'+inc).value == "00:00" && document.getElementById('timeComplete'+inc).value == "00:00"){
		alert("Time cannot be 00:00");
		document.getElementById('totalHours').value = "00:00";
		return false;
	}
	else if(document.getElementById('timeComplete'+inc).value >= document.getElementById('timeBegin'+inc).value){
		totalTime = (convertSecondsToHHMM(diff));
		document.getElementById('sittingTime'+inc).value = totalTime;
	return true;
	}else{
	alert("Time Begin should be less than Time Completed");
	return false;
	}

}

function validateRadio(){
	 for(var i = 1; i <= document.getElementsByName('physioRequisitionHeaderId').length; i++){
	//alert("i-- "+i)
	//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
	  if(document.getElementsByName('physioRequisitionHeaderId')[i].checked == true)
    {
		
		return true;
	  }		
	}
	alert("Please select one record.")
	return false;
}
function removeRow()
{
  var tbl = document.getElementById('tharapyGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('tharapyGrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}

function convertSecondsToHHMM(intSecondsToConvert) {

	var hours = convertHours(intSecondsToConvert);
	hours = (hours<10)?"0"+hours : hours
	var minutes = getRemainingMinutes(intSecondsToConvert);
	minutes = (minutes == 60) ? "00" : minutes;
	minutes = (minutes<10)?"0"+minutes : minutes
//	var seconds = getRemainingSeconds(intSecondsToConvert);
	
 	var time = hours+":"+minutes;
	return time;

}

</script>
<script> //calculateTime();</script>