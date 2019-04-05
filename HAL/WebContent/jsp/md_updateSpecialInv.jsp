<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@page import="jkt.hms.masters.business.MdSpecialInvestigationHd"%>
<%@page import="jkt.hms.masters.business.MdSpecialInvestigationDt"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="specialInvestigation" method="post" action="">
<script	type="text/javascript">
		history.forward();
</script> 
<script>
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
// function checkedfunctions(){
          // if(document.getElementById('testType1').checked){
         //   selectedTestType = document.getElementById('testType1').value;
        //   }else{
          //   selectedTestType = document.getElementById('testType2').value;
          // }
           //   alert("selectedTestType::"+selectedTestType);
             
          //}
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
	int specInvHdId=0;
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
		List<MasReference> hospitalList = new ArrayList<MasReference>();
		if(map.get("hospitalList") != null){
			hospitalList = (ArrayList)map.get("hospitalList");
		}
		if(map.get("specInvHdId") != null){
			specInvHdId=(Integer)map.get("specInvHdId");
		}
		List<MdSpecialInvestigationHd> specialInvestigationList= new ArrayList<MdSpecialInvestigationHd>();
		if(map.get("specialInvestigationList") != null){
			specialInvestigationList=(List)map.get("specialInvestigationList");
		}
		MdSpecialInvestigationHd specialInvestigationHd = new MdSpecialInvestigationHd();
		if(specialInvestigationList != null && specialInvestigationList.size()>0){
		specialInvestigationHd=specialInvestigationList.get(0);
%>
<div class="titlebg">
<h2>Update Special Investigation Entry</h2>
</div>
<div class="Block">

<input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String yearlySeqNo="";
		if(map.get("yearlySeqNo") != null){
			yearlySeqNo = (String)map.get("yearlySeqNo");
		}
%> 

<label>Yearly Sr No.</label> 
<input id="orderNoId" type=hidden	name="<%=YEARLY_SR_NO %>"	value="<%=specialInvestigationHd.getYearlyNo() %>" title="yearly Sr No" />

<label class="value"><%=specialInvestigationHd.getYearlyNo() %></label>
<input type="hidden" id="specInvHdId" name="specInvHdId"
	value="<%= specialInvestigationHd.getId()%>" /> 
	
<label>Date</label> 
<input type="text" class="calDate" id="fromDateId" name="<%=DATE %>" value="<%=currentDate %>"
	 readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.specialInvestigation.<%=DATE%>,event)" />


<label>Service No.</label> <%if(specialInvestigationHd.getHin() !=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<div class="Clear"></div>

<label>Age </label> <%if(specialInvestigationHd.getHin()!=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getAge()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<label>Sex </label> <%if(specialInvestigationHd.getHin()!=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getSex().getAdministrativeSexName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>
<%

String patName="";
if(specialInvestigationHd.getHin() !=null){
patName=specialInvestigationHd.getHin().getPFirstName();
if(specialInvestigationHd.getHin().getPMiddleName() !=null){
	patName=patName+" "+specialInvestigationHd.getHin().getPMiddleName();
}
if(specialInvestigationHd.getHin().getPLastName() !=null) {
	patName=patName+" "+specialInvestigationHd.getHin().getPLastName();
}
}
%>


<label>Patient Name</label> 
<label class="value"><%=patName %></label>

<div class="Clear"></div>

<label>Relation</label>
<%if(specialInvestigationHd.getHin().getRelation() !=null){ %> <label
	class="value"><%=specialInvestigationHd.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<label>Rank </label> <%if(specialInvestigationHd.getHin() !=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getRank().getRankName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<%String sName="";
if(specialInvestigationHd.getHin() !=null){
	sName=specialInvestigationHd.getHin().getSFirstName();
if(specialInvestigationHd.getHin().getSMiddleName() !=null){
	sName=sName+" "+specialInvestigationHd.getHin().getSMiddleName();
}
if(specialInvestigationHd.getHin().getSLastName() !=null) {
	sName=sName+" "+specialInvestigationHd.getHin().getSLastName();
}
}
%>


<label>Name</label> 
<label class="value"><%=sName %></label>

<div class=Clear></div>

<label>Trade </label> <%if(specialInvestigationHd.getHin().getTrade() !=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getTrade().getTradeName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> 

<label>Unit </label> <%if(specialInvestigationHd.getHin().getUnit() !=null){ %>
<label class="value"><%=specialInvestigationHd.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <%
			int inpatientId =0;
		
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = specialInvestigationHd.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				
%> <%	if(specialInvestigationHd.getInpatient()!=null){%> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=specialInvestigationHd.getInpatient().getId()%>" /> <%if(specialInvestigationHd.getInpatient().getDepartment()!=null){ %>
<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=specialInvestigationHd.getInpatient().getDepartment().getId() %>" />
<%}} %> <%}} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=specialInvestigationHd.getHin().getId() %>" />


<label>Referred To <span>*</span> </label> 
<%if(specialInvestigationHd.getSuggestTo() !=null){ %>
<input type="text"
	 align="right" name="refferedTo"
	id="refferedTo" validate="Reffered To,string,yes" tabindex="1" value="<%=specialInvestigationHd.getSuggestTo() %>" /><%}else{ %>
	<input type="text"
	 align="right" name="refferedTo"
	id="refferedTo" validate="Reffered To,string,yes" tabindex="1" /><%} %>
	
<div class=Clear></div>

<%---
<select
	name="<%= REFERRED_TO %>" validate="Referred To,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
				         		if(hospitalList != null){ 	
				         			for (Iterator iter = hospitalList.iterator(); iter.hasNext();) {
				         				MasReference masHospital = (MasReference) iter.next();
				         %>
	<%if(specialInvestigationHd.getReferredTo().getId() .equals(masHospital.getId())){ %>
	<option value="<%=specialInvestigationHd.getReferredTo().getId()%>"
		selected="selected"><%=specialInvestigationHd.getReferredTo().getReferenceName() %></option>
	<%}else{ %>
	<option value="<%=masHospital.getId() %>"><%=masHospital.getReferenceName()%></option>
	<%		}} } %>
</select>  --%>

<label> Working Diagnosis <span>*</span> </label> <%if(specialInvestigationHd.getWorkingDiagnosis()!= null){%>
<input type="text" name="<%=DIAGNOSIS_ID%>" class=""
	value="<%=specialInvestigationHd.getWorkingDiagnosis()%>"
	id="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,yes" tabindex="1" />
<%}else{ %> <input type="text" name="<%=DIAGNOSIS_ID%>" class="large"
	value="" id="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,yes"
	tabindex="1" /> <%} %>


<label>Appointment Date</label> <%if (specialInvestigationHd.getAppointmentDate() != null){ %>
<input type="text" class="calDate" id="lastDateId"
	name="<%=APPOINTMENT_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(specialInvestigationHd.getAppointmentDate()) %>"
	validate="Appointment Date,date,no" MAXLENGTH="10" /> <%}else{%> <input
	type="text" class="calDate" id="lastDateId"
	name="<%=APPOINTMENT_DATE %>" value=""
	validate="Appointment Date,date,no" MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.specialInvestigation.<%=APPOINTMENT_DATE%>,event)" />


<label> Appointment Time</label> <%if (specialInvestigationHd.getAppointmnetTime() != null){ %>
<input id="appointmentTime" name="<%=APPOINTMENT_TIME %>"
	value="<%=specialInvestigationHd.getAppointmnetTime() %>" type="text"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTime(this.value,this.id);" maxlength="5" /> <%}else{ %> <input
	id="appointmentTime" name="<%=APPOINTMENT_TIME %>" value="" type="text"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTime(this.value,this.id);" maxlength="5" /> <%} %> <%} %> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
</div>

<div class="Clear paddingTop15"></div>
<div class="Block">
<label>Investigation Required</label> <input
	type="button" name="add" value="" class="buttonAdd" onclick="addRow();"
	tabindex="1" /> <input type="button" name="delete" value=""
	class="buttonDel" onclick="removeRow();" /> 
</div>	
<div class="clear paddingTop15"></div>
<%--	
<label>Select Test Type </label>


<label>ALL Test</label> <input
	type="radio" name="testType" id="testType1" value="ALL"
	onclick="checkedfunctions();" style="width: 5px;" /> 
	
<label>GeneralClaims Specific Test </label> 
<input type="radio" name="testType" id="testType2"
	value="MEDCLAIMS" checked="checked" style="width: 5px;"
	onclick="checkedfunctions();" />
 --%>
 
<div class="cmntable">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Test Name</th>
		</tr>
	</thead>
	<tbody>

		<%
		int inc = 0;
	List<MdSpecialInvestigationDt>specialInvestigationDtList=new ArrayList<MdSpecialInvestigationDt>();
	if(map.get("specialInvestigationDtList")!=null){
		specialInvestigationDtList=(List<MdSpecialInvestigationDt>)	map.get("specialInvestigationDtList");
	}
     if(specialInvestigationDtList!= null && specialInvestigationDtList.size()>0){
    	 for(MdSpecialInvestigationDt specialInvestigationDt:specialInvestigationDtList){
		 inc++; 
	%>

		<tr>
			<td><input type="checkbox" value="<%=inc%>"
				name="selectedChrage" class="radioCheck" /></td>
			<td>
			<%if(specialInvestigationDt.getCharge()!= null){ %> <input type="text"
				tabindex="1" align="right" name="<%=CHARGE_NAME%>" size="80"
				id="chargeName<%=inc%>" readonly="readonly"
				value="<%=specialInvestigationDt.getCharge().getChargeCodeName()+"["+specialInvestigationDt.getCharge().getId()+"]" %>" />
			<input type="hidden"
				value="<%=specialInvestigationDt.getCharge().getId()%>"
				name="chargeId<%=inc %>" id="chargeCodeId<%=inc %>" />
			 <%}else{ %> <input type="text" tabindex="1" name="<%=CHARGE_NAME%>"
				size="80" id="chargeName<%=inc%>"
				onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" />
			<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				
			 new Ajax.Autocompleter('chargeName<%=inc%>','ac2update<%=inc %>','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName<%=inc%>'});
			 
    </script> <input type="hidden" value="" name="chargeId<%=inc %>" id="chargeCodeId<%=inc %>" /> <%} %>
			</td>
		</tr>
		<%}%>
	</tbody>
	<%}%>
</table>


<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"	id="hiddenValueCharge" /></div>


<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->


<div class="division"></div>
<input type="button" class="button" value="Update"
onclick="if(checkFilledRow())submitForm('specialInvestigation','mediClaim?method=updateSpecialInvestigation');"
align="right" /> 
	
<input type="reset" class="button" name="Reset"	id="reset" value="Reset"
onclick="resetClicked('specialInvestigation',);" accesskey="r" />
<div class="division"></div>


<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
<input type="hidden" name="counter" value=""></div>

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
	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = 'autocomplete';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeName'+ (iteration),'ac2update'+iteration,'mediClaim?method=getChargeName',{parameters:'requiredField=chargeName'+ (iteration)});

	cell1.id='itm'+iteration;
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='chargeId'+iteration;
	  e2.id='chargeCodeId'+iteration
	  e2.size = '10'
	  e2.maxLength="5"
	  cell1.appendChild(e2);
	  
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
		} }  }
			
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
