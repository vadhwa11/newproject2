
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<div class="titleBg"><h2>Patient List</h2></div>
<div class="Clear"></div>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientList") != null){
			patientList= (List<Inpatient>)map.get("patientList");
		}
		%>

<table align="center" width="100%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">HIN No.</th>
			<th width="30%">Patient Name</th>
			<th width="10%">Sex</th>
			<th width="10%">Age</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
			<% int i=1;
				if(patientList.size() > 0){
					for(Inpatient inpatient : patientList){
						String pMiddleName = "";
						String pLastName = "";
						
							if(inpatient.getHin().getPMiddleName() != null){
								pMiddleName = inpatient.getHin().getPMiddleName();
							}
							if(inpatient.getHin().getPLastName() != null){
								pLastName = inpatient.getHin().getPLastName();
							}
							String sMiddleName = "";
							String sLastName = "";
							if(inpatient.getHin().getSMiddleName() != null){
								sMiddleName = inpatient.getHin().getSMiddleName();
							}
							if(inpatient.getHin().getSLastName() != null){
								sLastName = inpatient.getHin().getSLastName();
							}
			%>
		<tr>
			<td><%=i %></td>
			<td><input type="text" name="<%=HIN_NO %>" value="<%=inpatient.getHinNo() %>" id="hinNo<%=i %>"></td>
			<td><input type="text" name="<%=PATIENT_NAME %>"  value="<%=inpatient.getHin().getPFirstName()+" "+pMiddleName+" "+pLastName%>" id="patientName<%=i %>"></td>
			<td><%=inpatient.getHin().getSex().getAdministrativeSexName() %>
			<input type="hidden" name="sexId" id="sexId<%=i %>" value="<%= inpatient.getHin().getSex().getId()%>">
			<input type="hidden" name="sexNameId" id="sexNameId<%=i %>" value="<%= inpatient.getHin().getSex().getAdministrativeSexName()%>">
			</td>
			<td><input type="text" id="ageId<%=i %>" name="<%=AGE %>" value="<%=inpatient.getAge() %>" /></td>
			<td><input type="radio" name="<%=HIN_ID %>" value="<%=inpatient.getHin().getId() %>" id="hinId<%=i %>"/>
			<input type="hidden" id="pNameId<%=i %>" value="<%=inpatient.getHin().getPFirstName()+" "+pMiddleName+" "+pLastName %>" />
			<input type="hidden" id="sNameId<%=i %>" value="<%=inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %>" />
			<input type="hidden" id="rankId<%=i %>" value="<%=inpatient.getHin().getRank().getId() %>" />
			<input type="hidden" id="rankNameId<%=i %>" value="<%=inpatient.getHin().getRank().getRankName() %>" />
			<input type="hidden" id="relationId<%=i %>" value="<%=inpatient.getHin().getRelation().getId() %>" />
			<input type="hidden" id="relationNameId<%=i %>" value="<%=inpatient.getHin().getRelation().getRelationName() %>" />
			<!--
			<%String bldGrpName = "";
			int bldGrpId = 0;
				if(inpatient.getHin().getBloodGroup()!= null){
					bldGrpName = inpatient.getHin().getBloodGroup().getBloodGroupName();
					bldGrpId =inpatient.getHin().getBloodGroup().getId();
				}
			%>
			
			<input type="hidden" id="bldGrpId<%=i%>" value="<%=bldGrpId%>" />
			<input type="hidden" id="bldGrpNameId<%=i%>" value="<%=bldGrpName %>" />
			--></td>
		</tr>
		
		<%i++;} 
		}%>
	</tbody>
</table>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Ok" value="Ok" class="button" onclick="validateRadioForPatient();">
<input type="hidden" name="counter" value="<%=i %>" id="counter"/>
<div class="clear"></div>
<div class="division"></div>
<script>

function setValuesInParent(){
	var cnt = document.getElementById('counter').value
	for(var i=1;i<cnt;i++){
		window.opener.document.getElementById('hinId').value = document.getElementById('hinId'+i).value;
		window.opener.document.getElementById('hinNo').value = document.getElementById('hinNo'+i).value;
		window.opener.document.getElementById('pNameId').value = document.getElementById('pNameId'+i).value;
		window.opener.document.getElementById('sNameId').value = document.getElementById('sNameId'+i).value;
	//	window.opener.document.getElementById('plNameId').value = document.getElementById('pLNameId'+i).value;
		window.opener.document.getElementById('sexId').value = document.getElementById('sexId'+i).value;
		window.opener.document.getElementById('ageId').value = document.getElementById('ageId'+i).value;
		window.opener.document.getElementById('rankId').value = document.getElementById('rankId'+i).value;
		window.opener.document.getElementById('relationId').value = document.getElementById('relationId'+i).value;
	//	window.opener.document.getElementById('bldGrpId').value = document.getElementById('bldGrpId'+i).value;

		window.opener.document.getElementById('sexNameId').value = document.getElementById('sexNameId'+i).value;
		window.opener.document.getElementById('rankNameId').value = document.getElementById('rankNameId'+i).value;
		window.opener.document.getElementById('relationNameId').value = document.getElementById('relationNameId'+i).value;
//		window.opener.document.getElementById('bldGrpNameId').value = document.getElementById('bldGrpNameId'+i).value;
	}
	window.close();
}

function validateRadioForPatient(){
	
	 for(var i = 0; i < document.getElementsByName('hinId').length; i++){
	  if(document.getElementsByName('hinId')[i].checked == true)
     {
		  setValuesInParent();
		return true;
	  }		
	}
	alert("Please select the patient")
return false;

}
</script>