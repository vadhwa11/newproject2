<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registeredPatients.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<!--main content placeholder starts here-->
<script type="text/javascript">
<% 	int rowCount=0; %>
	function returnParent(rowCount)
	{ 
		for(var i = 0; i < document.getElementsByName('parent').length; i++)
		{
			  if(document.getElementsByName('parent')[i].checked == true && document.getElementsByName('parent')[i].value!=null)
			  {
					if( document.getElementById("servicePersonName"+i)!=null)
					{		window.opener.document.getElementById("servicePerson"+rowCount).value = document.getElementById("servicePersonName"+i).value;
							window.opener.document.getElementById("servicePerson"+rowCount).readOnly=true;
					}
					if( document.getElementById("rank"+i)!=null)
					{		window.opener.document.getElementById("rank"+rowCount).value = document.getElementById("rank"+i).value;
							window.opener.document.getElementById("rank"+rowCount).readOnly=true;
					}
					if( document.getElementById("hinNo"+i)!=null)
					{
							window.opener.document.getElementById("hinNo"+rowCount).value = document.getElementById("hinNo"+i).value;
							window.opener.document.getElementById("hinNo"+rowCount).readOnly=true;
					}
					if( document.getElementById("hinId"+i)!=null)
					{		window.opener.document.getElementById("hinId"+rowCount).value = document.getElementById("hinId"+i).value;
							window.opener.document.getElementById("hinId"+rowCount).readOnly=true;
					}
					if( document.getElementById("patientName"+i)!=null)
					{		window.opener.document.getElementById("patientName"+rowCount).value = document.getElementById("patientName"+i).value;
							window.opener.document.getElementById("patientName"+rowCount).readOnly=true;
					}
					if( document.getElementById("mobileNo"+i)!=null)
					{		window.opener.document.getElementById("mobileNo"+rowCount).value = document.getElementById("mobileNo"+i).value;
							window.opener.document.getElementById("mobileNo"+rowCount).readOnly=true;
					}
					if( document.getElementById("sex"+i)!=null)
					{
							window.opener.document.getElementById("sex"+rowCount).value = document.getElementById("sex"+i).value;
							window.opener.document.getElementById("sex"+rowCount).readOnly=true;
					}
					if( document.getElementById("relationId"+i)!=null)
					{
							window.opener.document.getElementById("relationId"+rowCount).value = document.getElementById("relationId"+i).value;
							window.opener.document.getElementById("relationId"+rowCount).readOnly=true;
					}
					if( document.getElementById("age"+i)!=null)
					{
							window.opener.document.getElementById("age"+rowCount).value = document.getElementById("age"+i).value;
							window.opener.document.getElementById("age"+rowCount).readOnly=true;
							window.opener.document.getElementById("ageUnit"+rowCount).disabled=true;
					}
					rowSelected=true;
					break;	
				}
				else
					rowSelected=false;
			}
			if(rowSelected==false)
			{
				alert("Select a Record!!");
				return false;
			}	
			else
			{
				self.close();
				return true;
			}
	}
	function newPatient(rowCount)
	{
		if( document.getElementById("servicePersonName"+0)!=null)
		{
			window.opener.document.getElementById("servicePerson"+rowCount).disabled=false;
			window.opener.document.getElementById("servicePerson"+rowCount).value = document.getElementById("servicePersonName"+0).value;
			window.opener.document.getElementById("servicePerson"+rowCount).readOnly=true;
			window.opener.document.getElementById("patientName"+rowCount).readOnly=false;
			window.opener.document.getElementById("mobileNo"+rowCount).readOnly=false;
			window.opener.document.getElementById("sex"+rowCount).readOnly=false;
			window.opener.document.getElementById("age"+rowCount).readOnly=false;
			window.opener.document.getElementById("ageUnit"+rowCount).disabled=false;
			window.opener.document.getElementById("ageUnit"+rowCount).readOnly=false;
			window.opener.document.getElementById("employeeId"+rowCount).readOnly=false;
			window.opener.document.getElementById("hinNo"+rowCount).disabled = true;
			
			window.opener.document.getElementById("patientName"+rowCount).value="";
			window.opener.document.getElementById("mobileNo"+rowCount).value="";
			window.opener.document.getElementById("sex"+rowCount).value="";
			window.opener.document.getElementById("age"+rowCount).value="";
			window.opener.document.getElementById("ageUnit"+rowCount).value="0";
			window.opener.document.getElementById("employeeId"+rowCount).value="0";
			window.opener.document.getElementById("hinNo"+rowCount).value="";
		}
		else
		{
			window.opener.document.getElementById("servicePerson"+rowCount).readOnly=false;
			window.opener.document.getElementById("servicePerson"+rowCount).disabled=false;
			window.opener.document.getElementById("patientName"+rowCount).readOnly=false;
			window.opener.document.getElementById("mobileNo"+rowCount).readOnly=false;
			window.opener.document.getElementById("sex"+rowCount).readOnly=false;
			window.opener.document.getElementById("age"+rowCount).readOnly=false;
			window.opener.document.getElementById("employeeId"+rowCount).readOnly=false;
			window.opener.document.getElementById("hinNo"+rowCount).disabled = true;
			window.opener.document.getElementById("ageUnit"+rowCount).readOnly=false;
			window.opener.document.getElementById("ageUnit"+rowCount).disabled=false;
		}
		self.close();
	}
</script>
<div id="contentHolder">
<form name="registeredPatients" method="post" action="">

<h6>OPD Patient Appointment</h6>
<div class="Clear"></div>

<%
			 	Box box=HMSUtil.getBox(request);
			 	
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	int counter=0;
			 
			 	
				if (map.get("registeredPatientList") != null) {
					registeredPatientList = (List<Patient>) map.get("registeredPatientList");
			 		
			 	}
				if (map.get("rowCount") != null) {
					rowCount = (Integer)map.get("rowCount");
			 		
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					noRecordFound=true;
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }		 	
			 %>




<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">


<div class="tableHholderCmnLarge">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Service No.</th>
		<th scope="col">Service Person <br />
		Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<!--  <th scope="col">Trade </th> -->
		<th scope="col">Patient Type</th>
		<th scope="col">Hin No.</th>
		<th scope="col">Patient <br />
		Name</th>
		<th scope="col">Mobile <br />
		No.</th>
		<th scope="col">Sex</th>
		<th scope="col">Age</th>
	</tr>

	<%
        
     	int inc = 0;  
     	if(registeredPatientList!=null)
     	{
     		Iterator ite=registeredPatientList.iterator();
     		while(ite.hasNext())
     		{
     			Patient patient=(Patient)ite.next();	
     		
     	
    	%>

	<tr>
		<% if(patient.getPatientStatus()!=null 
    			&& patient.getPatientStatus().equalsIgnoreCase("In Patient")){ %>
		<td style="background: lightgreen;"><input type="radio"
			id="parent" name="parent" value="<%=patient.getId()%>" id="parent" /></td>
		<td style="background: lightgreen;"><%=patient.getServiceNo()%></td>

		<td><input type="text" id="servicePersonName<%=inc%>" size="18"
			style="background: lightgreen;"
			value="<%=patient.getSFirstName()+" "%><%=patient.getSLastName()%>"
			readonly="readonly" disabled="disabled" /></td>

		<td><input type="hidden" id="relationId<%=inc%>"
			value="<%=patient.getRelation().getId()%>" /> <input type="text"
			id="relation<%=inc%>" size="8" style="background: lightgreen;"
			value="<%=patient.getRelation().getRelationName()%>"
			readonly="readonly" disabled="disabled" /></td>
		<td><input type="text" id="rank<%=inc%>" size="5"
			style="background: lightgreen;"
			value="<%=patient.getRank().getRankName()%>" readonly="readonly"
			disabled="disabled" /></td>
		<td><input type="text" size="8" id="patientType<%=inc%>"
			value="<%=patient.getPatientStatus()%>"
			style="background: lightgreen;" readonly="readonly"
			disabled="disabled" /></td>
		<td><input type="text" id="hinNo<%=inc%>" size="10"
			style="background: lightgreen;" value="<%=patient.getHinNo()%>"
			readonly="readonly" disabled="disabled" /></td>
		<input type="hidden" id="hinId<%=inc%>" value="<%=patient.getId()%>" />
		<td><input type="text" size="18" id="patientName<%=inc%>"
			style="background: lightgreen;"
			value="<%=patient.getPFirstName()%><%=patient.getPLastName()%>"
			readonly="readonly" disabled="disabled" /></td>

		<%if(patient.getMobileNumber()!=null){ %>
		<td><input type="text" size="10" id="mobileNo<%=inc%>"
			style="background: lightgreen;"
			value="<%=patient.getMobileNumber()%>" readonly="readonly"
			disabled="disabled" /></td>
		<%}else{ %>
		<td><input type="text" size="10" id="mobileNo<%=inc%>"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /></td>
		<%} %>

		<%if(patient.getSex()!=null){ %>
		<td><input type="text" size="1" id="sex<%=inc%>"
			style="background: lightgreen;"
			value="<%=patient.getSex().getAdministrativeSexCode()%>"
			readonly="readonly" disabled="disabled" /></td>
		<%}else{ %>
		<td><input type="text" size="1" id="sex<%=inc%>"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /></td>
		<%} %>
		<td><input type="text" id="age<%=inc%>" size="1"
			style="background: lightgreen;" value="<%=patient.getAge()%>"
			readonly="readonly" disabled="disabled" /></td>

		<% }else { %>
		<td><input type="radio" id="parent" name="parent"
			value="<%=patient.getId()%>" id="parent" /></td>
		<td><%=patient.getServiceNo()%></td>

		<td><input type="text" id="servicePersonName<%=inc%>" size="18"
			value="<%=patient.getSFirstName()+" "%><%=patient.getSLastName()%>"
			readonly="readonly" disabled="disabled" /></td>

		<td><input type="hidden" id="relationId<%=inc%>"
			value="<%=patient.getRelation().getId()%>" /> <input type="text"
			id="relation<%=inc%>" size="8"
			value="<%=patient.getRelation().getRelationName()%>"
			readonly="readonly" disabled="disabled" /></td>
		<td><input type="text" id="rank<%=inc%>" size="5"
			value="<%=patient.getRank().getRankName()%>" readonly="readonly"
			disabled="disabled" /></td>
		<td><input type="text" size="8" id="patientType<%=inc%>"
			value="<%=patient.getPatientStatus()%>" readonly="readonly"
			disabled="disabled" /></td>
		<td><input type="text" id="hinNo<%=inc%>" size="10"
			value="<%=patient.getHinNo()%>" readonly="readonly"
			disabled="disabled" /></td>
		<input type="hidden" id="hinId<%=inc%>" value="<%=patient.getId()%>" />
		<td><input type="text" size="18" id="patientName<%=inc%>"
			value="<%=patient.getPFirstName()%><%=patient.getPLastName()%>"
			readonly="readonly" disabled="disabled" /></td>

		<%if(patient.getMobileNumber()!=null){ %>
		<td><input type="text" size="10" id="mobileNo<%=inc%>"
			value="<%=patient.getMobileNumber()%>" readonly="readonly"
			disabled="disabled" /></td>
		<%}else{ %>
		<td><input type="text" size="10" id="mobileNo<%=inc%>" value=""
			readonly="readonly" disabled="disabled" /></td>
		<%} %>

		<%if(patient.getSex()!=null){ %>
		<td><input type="text" size="1" id="sex<%=inc%>"
			value="<%=patient.getSex().getAdministrativeSexCode()%>"
			readonly="readonly" disabled="disabled" /></td>
		<%}else{ %>
		<td><input type="text" size="1" id="sex<%=inc%>" value=""
			readonly="readonly" disabled="disabled" /></td>
		<%} %>
		<td><input type="text" id="age<%=inc%>" size="1"
			value="<%=patient.getAge()%>" readonly="readonly" disabled="disabled" /></td>

		<% } %>


	</tr>

	<%
		inc++;
     		}
     %>

	<%
    	}
	%>
</table>
</div>

</div>



<!--Bottom labels starts-->
<div class="bottom">
<div class="Clear"></div>
<%if(noRecordFound==false){ %> <input name="" type="button" class="button"
	value="Submit" onclick="returnParent(<%=rowCount%>);" /> <%} %> <input
	name="" type="button" class="button" value="Back"
	onclick="newPatient(<%=rowCount%>);" /></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->