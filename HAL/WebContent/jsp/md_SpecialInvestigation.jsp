<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<form name="specialInvestigation" method="post" action=""><script
	type="text/javascript">
		history.forward();
</script> <script>
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

	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	var selectedTestType="MEDCLAIMS";
        function checkedfunctions(){
                  if(document.getElementById('testType1').checked){
                   selectedTestType = document.getElementById('testType1').value;
                  }else{
                    selectedTestType = document.getElementById('testType2').value;
                  }
                   
                    
                 }
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int specialhdId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		//List<MasReference> masReffenceList = new ArrayList<MasReference>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		/*if(map.get("masReffenceList") != null){
			masReffenceList = (ArrayList)map.get("masReffenceList");
		}*/
		if(map.get("chargeList") != null){
			chargeList=(List)map.get("chargeList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("specialhdId") != null){
			specialhdId=(Integer)map.get("specialhdId");
		}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>

<%} %>
<div class="titlebg">
<h6>Request for Special Investigation Entry</h6>
</div>

<div class="Clear"></div>

<div class="Block">

<input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String yearlySeqNo="";
		if(map.get("yearlySeqNo") != null){
			yearlySeqNo = (String)map.get("yearlySeqNo");
		}
%> <label>Yearly Sl. No.</label> 
<input id="orderNoId" type="hidden"	name="<%=YEARLY_SR_NO %>" value="<%=yearlySeqNo %>"
	title="yearly Sr No" tabindex="1" /> 
<label class="value"><%=yearlySeqNo %></label>
<input type="hidden" id="specialhdId" name="specialhdId" value="<%= specialhdId%>" tabindex="1" />
<label>Date<span>*</span></label>
<input type="text" class="calDate" id="specialDate" name="<%=DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	tabindex="1" validate="Date,date,yes" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.specialInvestigation.<%=DATE%>,event)"
	tabindex="1" /> <% for (Patient patient:patientList) {%>

<label>Service No.</label> <label class="value"><%=patient.getServiceNo()%></label>
<div class="Clear"></div>
<%
String patName="";
String sName="";
patName=patient.getPFirstName();
if(patient.getPMiddleName() !=null){
	patName=patName+" "+patient.getPMiddleName();
}
if(patient.getPLastName()!=null){
	patName=patName+" "+patient.getPLastName();
}
sName=patient.getSFirstName();
if(patient.getSMiddleName() !=null){
	sName=sName+" "+patient.getSMiddleName();
}
if(patient.getSLastName()!=null){
	sName=sName+" "+patient.getSLastName();
} %>
<label>Patient Name</label> <label class="value"><%=patName %></label>
<label>Relation</label> <%if(patient.getRelation() !=null){ %> <label
	class="value"><%=patient.getRelation().getRelationName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %>

 <label>Rank </label> <%if(patient.getRank() !=null){ %>
<label class="value"><%=patient.getRank().getRankName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %>
<div class="clear"></div>
<label> Name</label> <label class="value"><%=sName%></label>

<label>Age </label> <%if(patient.getAge() !=null){ %> <label class="value"><%=patient.getAge()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<label>Gender </label> <%if(patient.getSex() !=null){ %>
<label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="Clear"></div>
<label>Trade </label> <%if(patient.getTrade() !=null){ %> <label
	class="value"><%=patient.getTrade().getTradeName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> 

<label>Unit </label> <%if(patient.getUnit() !=null){ %>
<label class="value"><%=patient.getUnit().getUnitName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> <%
			int inpatientId =0;
		
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = patient.getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				
%> <input type="hidden" class="calDate" id="admDate"
	name="<%=AD_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()) %>"
	readonly="readonly" MAXLENGTH="30" />

<label>A &amp;D No</label> <%if(inpatient.getAdNo() != null){ %> <label
	class="value"><%=inpatient.getAdNo()%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <%}}%> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <%} %>

<label> Referred To <span>*</span></label> 
<input type="text"
	 align="right" name="refferedTo"
	id="refferedTo" validate="Reffered To,string,yes" tabindex="1" />
<!-- Hide drop-down as discussed with grijesh sir -->

<%--<select
	name="<%= REFERRED_TO %>" validate="Referred To,string,yes" tabindex=1>
	
	<option value="">Select</option>
	<% 
			  if(masReffenceList != null){ 	
				for (MasReference  masReferecne : masReffenceList){
				%>
	<option value="<%=masReferecne.getId ()%>"><%=masReferecne.getReferenceName()%></option>

	<%} }%> --%>
	<div class=Clear></div>
<label>Working Diagnosis<span>*</span></label> <input type="text"
	 align="right" name="<%=DIAGNOSIS_ID %>"
	id="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,yes" tabindex="1" />


<label>App Date</label> <input type="text" class="calDate"
	id="lastDateId" name="<%=APPOINTMENT_DATE %>" value=""
	validate="Appointment Date,date,no" MAXLENGTH="10" tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.specialInvestigation.<%=APPOINTMENT_DATE%>,event)"
	tabindex="1" /> 
	
	
	<label> App Time</label> <input
	id="appointmentTime" name="<%=APPOINTMENT_TIME %>" type="text"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5" tabindex="1" />

<div class="Clear"></div>

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />

<div class="Clear"></div>
<div class="division"></div>
<h4>Investigation Required</h4>
<%---
	
<label>Select Test Type</label>
	
<label class="auto">ALL Test</label> 
<input type="radio" class="radioAuto" name="testType" id="testType1" value="ALL" 	onclick="checkedfunctions();" checked="checked"/> 

<label class="auto">GeneralClaims Specific Test </label> 
<input type="radio" name="testType" class="radioAuto" id="testType2" value="MEDCLAIMS"   onclick="checkedfunctions();" />
 --%>
</div>


<div class="cmntable">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Investigation</th>
			<th>Add</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>

		<%
		int inc = 1;
	%>

		<tr>
			<input type="hidden" value="<%=specialhdId %>" name="specialhdId" id="specialhdId" />
			<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" tabindex="1" /> 
				<input type="hidden" value="<%=inc%>" name="selectedChrage1" />
			</td>
			<td>
				<input type="text" tabindex="1" align="right" name="<%=CHARGE_NAME%><%=inc%>" size="80" id="chargeName<%=inc%>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" tabindex="1" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		//function eventCallback(element, entry){
					//return entry + "&testType="+selectedTestType; 
				//}
		  new Ajax.Autocompleter('chargeName<%=inc%>','ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName<%=inc%>'});
		</script>
		<input type="hidden" value="" name="<%=CHARGE_CODE_ID %><%=inc %>" id="chargeCodeId<%=inc %>" /></td>
				
				
				<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();"	tabindex="1" /> </td>
	
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" /> </td>
				
		</tr>
	</tbody>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" tabindex="1" /></div>

<!--Bottom labels starts-->




<div class="clear paddingTop15"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow())submitForm('specialInvestigation','mediClaim?method=submitSpecialinvestigation','validateFromToDate');"
	align="right" tabindex="1" /> 
	
	
	
	<input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('specialInvestigation',<%=inc %>);" accesskey="r"
	tabindex="1" />



<div class="bottom">
<div class="clear paddingTop15"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
</form>

<script type="text/javascript">
	function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var e7 = document.createElement('input');
	e7.type='hidden';
	e7.name='selectedChrage1';
	e7.value=(iteration);
	cell0.appendChild(e7);
	
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size = '80';
	e1.onblur=function(){
				if(fillSrNo){fillChargeId(this.value,iteration);}
			  };
	e1.name = 'chargeName'+ (iteration);
	e1.id = 'chargeName' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeName'+ (iteration),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName'+ (iteration)});

	cell1.id='itm'+iteration;
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='chargeCodeId'+iteration;
	  e2.id='chargeCodeId'+iteration
	  e2.size = '10'
	  e2.maxLength="5"
	  cell1.appendChild(e2);

	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'button';
	  e2.className = 'buttonAdd';
	  e2.name='Button';
	  e2.onclick = function(){addRow();};
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonDel';
	  e3.name='delete';
	  e3.onclick = function(){removeRow();};
	  cell3.appendChild(e3);
	  
}
function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
     var err = "";
		if (document.getElementsByName('selectedChrage')[counter].checked == true) 
		{
		  	tbl.deleteRow(counter+1);
		  	totalCost();
		}else{
			err += "Please select atleast one row for delete";
		
		}
	}
	
	if(err != ""){
		alert(err);
		return false;
	}
}

function fillChargeId(val,inc){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			if(chargeId=='')
			{
			document.getElementById('chargeName'+inc).value=""
			var e=eval(document.getElementById('chargeName'+inc)); 
			e.focus();
			return false;
			}
			var indexForChargeName = indexForChargeName--;
			var ChargeName = val.substring(0,indexForChargeName);
		document.getElementById('chargeCodeId'+inc).value = chargeId;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		
		if(document.getElementById('chargeName'+i).value==val)
		{
			alert("Charge Name already selected...!")
			document.getElementById('chargeName'+inc).value=""
			var e=eval(document.getElementById('chargeName'+inc)); 
			e.focus();
			return false;
		}
		
		 }  }
			
}
}
function fillSrNo(rowVal){

	if(document.getElementById('chargeName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function fillDiagnosisId(val){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForDiagnosisName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			
			var diagnosisId = val.substring(index1,index2);
			
			var indexForDiagnosisName = indexForDiagnosisName--;
			var DiagnosisName = val.substring(0,indexForDiagnosisName);
		document.getElementById('diagnosisId').value = diagnosisId;
			
}
}

function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeName'+i) != null){
	  	 		if(document.getElementById('chargeName'+i).value == ""){
	  				alert("Please fill atleast one Test to submit.");
	  				return false;
	  		}
	  		
	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	}
	}
</script>
