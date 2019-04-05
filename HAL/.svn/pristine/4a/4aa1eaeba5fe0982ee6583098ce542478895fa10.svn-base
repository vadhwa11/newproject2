
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.util.Box"%><script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
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
<form name="investigationRequisition" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	
	
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		
			
	%>
	<h4><%=message %></h4>
<div class="titleBg"><h2>Investigation Requisition</h2></div>

<% 
	Box box = HMSUtil.getBox(request);


	Patient patient = new Patient();
	patient = patientList.get(0);
	String age = "";
	String currentAge = "";
		if(patient.getAge()!= null){
			age = patient.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
		}
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		int dgOrderhdId = box.getInt("dgOrderhdId");
		int patientInvId =  box.getInt("patientInvId");
		
		%>
<div class="clear"></div>
<input type="text" name="dgOrderhdId" value="<%=dgOrderhdId %>">
<input type="text" name="patientInvId" value="<%=patientInvId %>">
<h4>Patient Details</h4>
<div class="Block">
<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>" readonly="readonly" id="serviceNo" value="<%= patient.getServiceNo()!=null?patient.getServiceNo():""%>" validate="" onblur="submitProtoAjaxWithDivName('admissionByHin','/hms/hms/adt?method=getHinNoForAdm','hinDiv');" /> 
<label>HIN </label>
<div id="hinDiv">
<input type="text" name="<%=HIN_NO %>" readonly="readonly" id="hinId" value="<%=patient.getHinNo() %>" /> 
</div>

<label>Patient Name</label> 
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>
<div class="clear"></div>
<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<input type="hidden" name="relationId" id="relationId"
	value="<%=patient.getRelation()%>"> <%} else{ %> <label
	class="value">-</label> <% }%> 


<%
		if(patient.getServiceType().getId()!=7){
	%>
	<label>Rank</label>
	<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>

<label>Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> <label class="value"><%= (patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> <% }%>


	 <%} %>
<div class="clear"></div>

<label>Age</label> 
<label class="value"><%=currentAge%></label> 
<input type="hidden" name="age" value="<%=currentAge %>"/>
<input type="hidden" name="currentVisitNo" value="<%=patient.getCurrentVisitNo() %>"/>
<label>Gender</label> 
<%
	if(patient.getSex() != null){
	%> 
	<label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%} %> 
<label> Blood Group</label> 
<label class="value"><%=patient.getBloodGroup()!=null?patient.getBloodGroup().getBloodGroupName():"" %></label>
<div class="clear"></div>
<input type="hidden" name="hinId" value="<%=patient.getId() %>">  
<input type="hidden" name="visitId" value="<%=box.getInt("visitId") %>"> 
		
</div>
<div class="clear"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	<% int inc=1; %>
	<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> 
			<input type="hidden" id="qty<%=inc %>" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly />

		</td>
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1" 
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hidden',this);" tabindex="1" /></td>


	</tr>
	
</table>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitForm('investigationRequisition','/hms/hms/lab?method=submitInvestigationRequisition');" />
<input name="Reset" type="reset" tabindex="1" align="right"	class="button" value="Reset"  />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>

</form>

<script>
document.getElementById('chargeCodeName1').focus();

function addRowForInvestigation(){
    
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
   
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.tabindex='1';
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  cellRight0.appendChild(e2);
	  
	  var cellRight2 = row.insertCell(1);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.tabindex='1';
	  e4.name='Button';
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(2);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.tabindex='1';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute("onClick","removeRow('investigationGrid','hidden',this);");
	  cellRight3.appendChild(e5);


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