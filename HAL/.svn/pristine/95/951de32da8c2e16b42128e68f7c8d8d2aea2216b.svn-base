<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : physiotherapyAdviceList.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 22.09.2011    Name: Anamika Verma
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasAllergyType"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
		List<Visit> patientDataList = new ArrayList<Visit>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		int hospitalId = 0;
		if(map.get("hospitalId") != null){
		 hospitalId = (Integer)map.get("hospitalId");	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
		List<AllergyDetail> allergyDetailsList = new ArrayList<AllergyDetail>();
		if(map.get("allergyDetailsList") != null){
			allergyDetailsList = (List<AllergyDetail>)map.get("allergyDetailsList");
		}
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("patientDataList")!=null){
			patientDataList = (List<Visit>)map.get("patientDataList");
		}
		String message= "";
		if(map.get("message")!=null){
			message = (String)map.get("message");
		}
		%>
		<h4><%=message %></h4>

		<div class="Clear"></div>	
		
		<%
		Visit visit=(Visit)patientDataList.get(0);
		int hinId=visit.getHin().getId();
		Patient patient = null;
		patient = (Patient) visit.getHin();
		List<MasTherapyType> therapyTypeList  = new ArrayList<MasTherapyType>();
		if(map.get("therapyTypeList")!=null){
			therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
		}
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		if(map.get("frequencyList")!=null){
			frequencyList = (List<MasFrequency>)map.get("frequencyList");
		}
		List<MasAllergyType> allergyTypeList = new ArrayList<MasAllergyType>();
		if(map.get("allergyTypeList")!=null){
			allergyTypeList = (List<MasAllergyType>)map.get("allergyTypeList");
		}
		
		int visitId =0;
		
		Box box= HMSUtil.getBox(request);
		String flag="";
		flag=box.getString("flag");
		String patientName="";
		if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
		}
		String servicePersonName="";
		if(visit.getHin().getSFirstName()!= null){
			servicePersonName=visit.getHin().getSFirstName();
			}
			if(visit.getHin().getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+visit.getHin().getSMiddleName();
			}
			if(visit.getHin().getSLastName()!= null){
				servicePersonName=servicePersonName+" "+visit.getHin().getSLastName();
			}
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		String doctorName="";
		if(visit.getDoctor().getFirstName()!= null){
			doctorName=visit.getDoctor().getFirstName();
			}
			if(visit.getDoctor().getMiddleName()!= null){
				doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
			}
			if(visit.getDoctor().getLastName()!= null){
				doctorName=doctorName+" "+visit.getDoctor().getLastName();
			}
	%>

<form name="allergyDetails" action="" method="post">

<div class="titleBg"><h2>Allergy Details</h2></div>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<input type="hidden" name="visitId" value="<%=visit.getId() %>" />
 <label>Service No.</label>
  <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label> 
<%}else{ %>
<label class="value">-</label> <%} %> 
<label> Patient Name</label>
<%if(patientName!=null){ %>
<input	name="patientName" type="text"	value="<%=patientName%>"	readonly="readonly" /> 
<%}else{%> 
<input name="patientName" type="text"	value="" readonly="readonly" /> <%}%>


<label>Relation</label> <%if(visit.getHin().getRelation() != null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> 
<div class="Clear"></div>
<label>Rank</label> 
<%if(visit.getHin().getRank()!= null){ %>
 <label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> 
<label>Name. </label>
 <%if(servicePersonName!= null){ %>
  <label class="value"><%=servicePersonName %>
</label>
 <%}else{ %> 
 <label class="value">- </label>
<%} %>


<label>Unit</label> <%if(visit.getHin().getUnit()!= null){ %> <label
	class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %>
 <label class="value">-</label>
 <%} %>
<label>Age</label>
<%if(visit.getHin().getAge()!= null){ %> 
<input name="age" type="text" size="8"	value="<%=visit.getAge() %>"	readonly="readonly" />
<%}else{%> <input name="age" type="text" size="8"	value="" readonly="readonly" />
<%} %>
	<label>Gender</label>
	 <%if(visit.getHin().getSex()!= null){ %>
	 <input name="sex" type="text"	value="<%=visit.getHin().getSex().getAdministrativeSexName() %>"	readonly="readonly" /> <%}else { %>
<input name="sex" type="text"	value="" readonly="readonly" />
<%} %>
<label>Medical Officer</label>
<label class="value"><%=doctorName %></label>
<div class="Clear"></div>



<!--Main div starts--> 
<input type="hidden" name="doctorId" id="doctorId" value="<%=visit.getDoctor().getId()%>" />
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" /> 
	<input id="hinId" name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" readonly="readonly" />
	 <input type="hidden" name="date" size="5" value="<%=date%>" />
	  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />

<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />

<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />
<div class="Clear"></div>
</div>

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
	<%--    <%
	    String alleryName = "";
	   	for(MasAllergyType allergyType : allergyTypeList){
	   		if(allergyType.getId().equals(allergyDetail.getAllergyType().getId())){
	   			alleryName = allergyType.getAllergyTypeName();
	   			break;
	   		}
	   	}
	   %>--%>
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
	<td><input type="text" name="since<%=i %>" tabindex="1" id="sinceId<%=i %>" value="<%=allergyDetail.getSince()!=null?allergyDetail.getSince():"" %>" size="10"	maxlength="3"  /></td>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" value="<%=allergyDetail.getRemarks()!=null?allergyDetail.getRemarks():"" %>" id="remarks<%=i %>" size="28" maxlength="40"/>
			</td>
			<%
			System.out.println(allergyDetail.getStatus());
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
	
	
	<td><input type="hidden" name="allergyDetailsId<%=i %>" id="allergyDetailsId<%=i %>" value=""/>
	    <input type="text" value="" tabindex="1" id="allergyName<%=i %>" size="30"  name="allergyName<%=i %>" onblur="if(this.value!=''){getAllergyTypeId(this.value,<%=i %>);}"  />
	    
	   
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
	<td><input type="text" name="since<%=i %>" tabindex="1" id="sinceId<%=i %>"  size="3"	maxlength="10" validate="No Of Days,num,no" /></td>
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
	
	
<div class="Clear"></div>

<div class="division"></div>
<input type="button" name="Submit11" id="addbutton" onclick="submitForm('allergyDetails','/hms/hms/opd?method=saveAllergyDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="button" name="inactive" value="Inactivate" class="button" onclick="submitForm('allergyDetails','/hms/hms/registration?method=inactivatePatientAllergies&flag=opd');" tabindex="1" />
	
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<input type="button" name="back" value="Back" class="button" onclick="submitForm('allergyDetails','/hms/hms/opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo() %>');" tabindex="1" />

<div class="Clear"></div>
<div class="division"></div>
<%--
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
</div>
--%> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

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
			  
		/*  var cell0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.name='duration'+iteration;
		  e0.id='durationId'+iteration
		  e0.value=(iteration);
		  e0.size = '2'
		  cell0.appendChild(e0);*/
		  
		  var cell1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '30';
		  e1.name='allergyName'+iteration;
		  e1.id='allergyName'+iteration
		  //e1.onblur=function() {getAllergyTypeId(this.value,iteration);}
		  cell1.appendChild(e1);
		//  new Ajax.Autocompleter('allergyTypeId'+iteration,'ac2update1','opd?method=getAllergyTypeListForAutoComplete',{parameters:'requiredField=allergyTypeId'+iteration});

		  //var e11 = document.createElement('input');
		  //var ediv = document.createElement('div');
		  //ediv.id='allergyTypeDiv'+(iteration);
		 // e11.type = 'hidden';
		 // e11.name='allergyId'+iteration;
		 // e11.id='allergyId'+iteration
		 // cell1.appendChild(ediv);
		 // ediv.appendChild(e11);
		 
		   var e12 = document.createElement('input');
	  	  e12.type = 'hidden';
		  e12.size = '30';
		  e12.name='allergyDetailsId'+iteration;
		  e12.id='allergyDetailsId'+iteration
		  e12.value="";
		  cell1.appendChild(e12);
		  
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
		  e4.size='10';
		  e4.setAttribute('maxlength', 3); 
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


function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
}
function removeRow()
{
  var tbl = document.getElementById('allergyGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('allergyCount');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}
</script>