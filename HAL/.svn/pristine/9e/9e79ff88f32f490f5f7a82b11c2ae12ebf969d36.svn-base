
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PatientImmunizationDetails"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.util.Box"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
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
	List<AllergyDetail> allergyDetailsList = new ArrayList<AllergyDetail>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("allergyDetailsList") != null){
		allergyDetailsList = (List<AllergyDetail>)map.get("allergyDetailsList");
	}
	Box box= HMSUtil.getBox(request);
	String message= "";
	if(map.get("message")!=null){
		message = (String)map.get("message");
	}
	String flag="";
	if(map.get("flag") != null)
	{
		flag = (String)map.get("flag");
	}
	int hinId=0;
	if(map.get("hinId") != null)
	{
		hinId = (Integer)map.get("hinId");
	}
	
	%>
<form name="allergyDetails" action="" method="post">
	<h4><%=message %></h4>

<div class="Clear"></div>
<div class="titleBg"><h2>Allergy Details</h2></div>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="allergyGrid">

	<tr>
		<th scope="col"></th>
		<th scope="col">Allergy Type</th>
		<th scope="col">Description</th>
		<th scope="col">Severity</th>
		<th scope="col">Since</th>
		<th scope="col">Remarks</th>
		<th>Status</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int i = 0;
	if(allergyDetailsList.size()>0){
		for(AllergyDetail allergyDetail : allergyDetailsList){
		i++;
	%>
<tr>
	<td><input type="checkbox" value="<%=allergyDetail.getId() %>" tabindex="1" id="checkAllergyId<%=i %>" size="3"  name="checkAllergyId<%=i %>"   /></td>
	<td>
		<input type="hidden" id="allergyDetailsId<%=i %>" name="allergyDetailsId<%=i %>" value="<%=allergyDetail.getId() %>"/>
		
		<input type="text" value="<%=allergyDetail.getAllergyName()!= null?allergyDetail.getAllergyName():"" %>" tabindex="1" id="allergyName<%=i %>" size="30"  name="allergyName<%=i %>"   />
		<input type="hidden" name="allergyId<%=i %>" id="allergyId<%=i %>"	value="<%=allergyDetail.getId() %>" />
	<%--  <div id="ac2update1" style="display:none;"  class="autocomplete"></div>--%>
	</td>
		
	<td><input type="text" name="description<%=i %>" tabindex="1" value="<%=allergyDetail.getDescription()!=null?allergyDetail.getDescription():"" %>" id="descriptionId<%=i %>"	size="12" maxlength="5" /></td>
	
	<td><select name="severity<%=i %>" id="severityId<%=i %>" tabindex="1"  >
			<option value="0">None</option>
			<option value="Minimal">Minimal</option>
			<option value="Slight">Slight</option>
			<option value="Moderate">Moderate</option>
			<option value="Severe">Severe</option>
			
		</select>
		</td>
		<script>
			document.getElementById('severityId<%=i %>').value='<%=allergyDetail.getSeverity()!=null?allergyDetail.getSeverity():""%>'
		</script>
	<td><input type="text" name="since<%=i %>" tabindex="1" id="sinceId<%=i %>" value="<%=allergyDetail.getSince()!=null?allergyDetail.getSince():"" %>" size="4"	maxlength="4"  /></td>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" value="<%=allergyDetail.getRemarks()!=null?allergyDetail.getRemarks():"" %>" id="remarks<%=i %>" size="28" maxlength="40"/>
			</td>
			<%
				if(allergyDetail.getStatus().equals("y")){
			%>
			<td>Active</td>
			<%}else{ %>
			<td>Inactive</td>
			<%} %>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			&nbsp;
			</td>
		
	</tr>

<% }
	}else{i++; %>
<tr>
	<td>&nbsp;</td>
	
	
	<td>
		<input type="hidden" name="allergyDetailsId<%=i %>" id="allergyDetailsId<%=i %>" value=""/>
	    <input type="text" value="" tabindex="1" id="allergyName<%=i %>" size="30"  name="allergyName<%=i %>"  />
	    
	   
	     <%-- <div id="ac2update1" style="display:none;"  class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('allergyTypeId<%=i %>','ac2update1','opd?method=getAllergyTypeListForAutoComplete',{parameters:'requiredField=allergyTypeId<%=i %>'});
			</script>
			<div id="allergyTypeDiv<%=i%>">
			<input type="hidden" name="allergyId<%=i %>" id="allergyId<%=i %>"	value="" /> </div>--%>
		</td>
		
	<td><input type="text" name="description<%=i %>" tabindex="1" id="descriptionId<%=i %>"	size="12" maxlength="5" /></td>
	
	<td><select name="severity<%=i %>" id="severityId<%=i %>" tabindex="1"  >
			<option value="0">None</option>
			<option value="Minimal">Minimal</option>
			<option value="Slight">Slight</option>
			<option value="Moderate">Moderate</option>
			<option value="Severe">Severe</option>
			
		</select>
		</td>
	<td><input type="text" name="since<%=i %>" tabindex="1" id="sinceId<%=i %>"  size="4"	maxlength="4"  /></td>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" id="remarks<%=i %>" size="28" maxlength="40"/>
			</td>
			<td>&nbsp;</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>

<%} %>	
</table>
	<input type="hidden" name="allergyCount" value="<%=i %>" id="allergyCount" />
	<input type="hidden" name="hinId" value="<%=box.getInt("hinId") %>" id="hinId" />
	<div class="clear"></div>
	<input type="hidden" id="deleteVal" name="deleteVal" value="" id="deleteId" />
	<% if(flag.equalsIgnoreCase("medicalExam"))
	 {
	 %>
	<input type="button" name="Ok" value="Ok" class="button" onclick="submitForm('allergyDetails','registration?method=saveAllergiesDetails');" tabindex="1" />
	<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
	
	<%}else{ %>
	<input type="button" name="Ok" value="Ok" class="button" onclick="setValuesInParent();" tabindex="1" />
	<%} %>
	<input type="button" name="inactive" value="Inactivate" class="button" onclick="submitForm('allergyDetails','/hms/hms/registration?method=inactivatePatientAllergies&flag=registration');" tabindex="1" />
	<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />		
</form>

<script>
function getAllergyTypeId(val,inc){
	
	if(val != ""){
			var index1 = val.lastIndexOf("[");
			var indexForAllergyCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var allergyId = val.substring(index1,index2);
			var indexForAllergyCode = indexForAllergyCode--;
			var allergyCode = val.substring(0,indexForAllergyCode);
			 
			if(allergyId == "" ) {
		      	document.getElementById('allergyTypeId'+inc).value="";
		      	//document.getElementById('pvmsNo'+inc).value="";
		     // 	document.getElementById('clinicalNotes'+inc).value="";
		 	 // 	document.getElementById('qty'+inc).value="";
		      	return;
			}
		if(allergyId!=""){
			submitProtoAjaxWithDivName('allergyDetails','/hms/hms/opd?method=getAllergyId&counter='+inc+'&allergyTypeCode='+allergyId,'allergyTypeDiv'+inc);
		}
	}
		
	}

function addRow(){
		
		  var tbl = document.getElementById('allergyGrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('allergyCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  var cell0 = row.insertCell(0);
		  cell0.innerHTML='&nbsp;'
		//  var e0 = document.createElement('input');
		//  e0.type = 'text';
		//  e0.name='sNo'+iteration;
		//  e0.id='sNo'+iteration
		//  e0.value=(iteration);
		//  e0.size = '2'
		//  cell0.appendChild(e0);
		  
		  var cell1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '30';
		  e1.name='allergyName'+iteration;
		  e1.id='allergyName'+iteration
		 // e1.onblur=function() {getAllergyTypeId(this.value,iteration);}
		  cell1.appendChild(e1);
		 
		 // new Ajax.Autocompleter('allergyTypeId'+iteration,'ac2update1','opd?method=getAllergyTypeListForAutoComplete',{parameters:'requiredField=allergyTypeId'+iteration});

		
		  
		  //var e11 = document.createElement('input');
		  //var ediv = document.createElement('div');
		  //ediv.id='allergyTypeDiv'+(iteration);
		  //e11.type = 'hidden';
		  //e11.name='allergyId'+iteration;
		  //e11.id='allergyId'+iteration
		  //ediv.appendChild(e11);
		  //cell1.appendChild(ediv);

		  var e12 = document.createElement('input');
	  	  e12.type = 'hidden';
		  e12.size = '30';
		  e12.name='allergyDetailsId'+iteration;
		  e12.id='allergyDetailsId'+iteration
		  e12.value="";
		  cell0.appendChild(e12);
			
		
		  
		  var cell2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='description'+iteration;
		  e2.id='descriptionId'+iteration
		  e2.size = '12'
		  cell2.appendChild(e2);

		  var cell13 = row.insertCell(3);
		  var e3 = document.createElement('Select');
		  e3.name='severity'+iteration;
		  e3.id='severityId'+iteration;
		  e3.classname='smalllabel';
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('None', 'None');
		  e3.options[1] = new Option('Minimal', 'Minimal');
		  e3.options[2] = new Option('Slight', 'Slight');
		  e3.options[3] = new Option('Moderate', 'Moderate');
		  e3.options[4] = new Option('Severe', 'Severe');
		   cell13.appendChild(e3);

		  var cell14 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='since'+iteration;
		  e4.id='sinceId'+iteration;
		  e4.size='4';
		  e4.setAttribute('maxlength', 4); 
		  e4.setAttribute('tabindex','1');
		 // e4.setAttribute('validate','noOfDays,int,yes');
		  cell14.appendChild(e4);
		  
		  var cell5 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='remarks'+iteration;
		  e5.id='remarks'+iteration
		  e5.size = '28';
		  e5.setAttribute('tabindex','1');
		  cell5.appendChild(e5);

		  var cell6 = row.insertCell(6);
		  cell6.innerHTML='&nbsp;'
		  var cell7 = row.insertCell(7);
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.className = 'buttonAdd';
		  e6.name='Button'+iteration;
		  e6.setAttribute('onClick', 'addRow();'); 
		  e6.setAttribute('tabindex','1');
		  cell7.appendChild(e6);

		  var cell8 = row.insertCell(8);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonDel';
		  e7.name='delete'+iteration;
		  e7.setAttribute('onClick', 'removeRow();'); 
		  e7.setAttribute('tabindex','1');
		  cell8.appendChild(e7);
}


function removeRow()
{
  var tbl = document.getElementById('allergyGrid');
  var lastRow = tbl.rows.length;
  
  if (lastRow > 2)
  {
	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('allergyCount');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}

function setValuesInParent(){
	var count = document.getElementById('allergyCount').value;
	  var tbl = window.opener.document.getElementById('allergyGrid');
	  var flag = '';
	  for(var i=1;i<=count;i++){
		  if(document.getElementById('allergyName'+i).value!=''){
			  flag = 'filled';
			  break;
		  }else{
			flag='';
		  }
	  }
	  if(flag == ''){
		alert("Please fill data.");
		return false;
	  }
	for(var i=1;i<=count;i++){
	 var allergyCount = window.opener.document.getElementById('allergyCount').value
		var lastRow = tbl.rows.length;
		var row = tbl.insertRow(lastRow);

		var iteration = parseInt(allergyCount);
		var cell0 = row.insertCell(0);
		var e0 = window.opener.document.createElement('input');
	    e0.type = 'text';
	    e0.name='allergyName'+(iteration+1);
	    e0.id='allergyName'+(iteration+1);
	    e0.value = document.getElementById('allergyName'+i).value;
	    var e11 = document.createElement('input');
	  	e11.type = 'hidden';
		e11.size = '30';
		e11.name='allergyDetailsId'+(iteration+1);
		e11.id='allergyDetailsId'+(iteration+1);
		e11.value = document.getElementById('allergyDetailsId'+i).value; 
		cell0.appendChild(e11);
	    cell0.appendChild(e0);

		var e1 = window.opener.document.createElement('input');
	    e1.type = 'text';
	    e1.name='description'+(iteration+1);
	    e1.id='descriptionId'+(iteration+1);
	    e1.value = document.getElementById('descriptionId'+i).value;
	    cell0.appendChild(e1);

	    var e2 = window.opener.document.createElement('input');
	    e2.type = 'text';
	    e2.name='severity'+(iteration+1);
	    e2.id='severityId'+(iteration+1);
	    e2.value = document.getElementById('severityId'+i).value;
	    cell0.appendChild(e2);

	    var e3 = window.opener.document.createElement('input');
	    e3.type = 'text';
	    e3.name='since'+(iteration+1);
	    e3.id='sinceId'+(iteration+1);
	    e3.value = document.getElementById('sinceId'+i).value;
	    cell0.appendChild(e3);


	    var e4 = window.opener.document.createElement('input');
	    e4.type = 'text';
	    e4.name='remarks'+(iteration+1);
	    e4.id='remarks'+(iteration+1);
	    e4.value = document.getElementById('remarks'+i).value;
	    cell0.appendChild(e4);

	    window.opener.document.getElementById('allergyCount').value = (iteration+1);
	}
	window.close();
}

</script>