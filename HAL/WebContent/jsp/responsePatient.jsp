<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script>
var alt1 ="Already Registered Information with Service No :"
var alt='';
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<Patient> patientListForInfo = new ArrayList<Patient>();
	Patient patientList2 = new Patient();
	String alertMsg ="Already Registered Information with Service No :";
	String srNo= "";
	try{
	if(map.get("patientListForInfo") != null){
		patientListForInfo = (List<Patient>)map.get("patientListForInfo");
		if(patientListForInfo.size() >0){
			for(Patient patient3 :patientListForInfo ){
				srNo=patient3.getServiceNo()!=null?patient3.getServiceNo():"";
				String pMidName = "";
				String pLastName = "";
				if(patient3.getPMiddleName()!= null){
					pMidName = patient3.getPMiddleName();
				}
				if(patient3.getPLastName()!= null){
					pLastName = patient3.getPLastName();
				}
				alertMsg = patient3.getPFirstName()+" "+pMidName+" "+pLastName+" ("+patient3.getRelation().getRelationName()+") ";
				%>
				alt =alt+'<%=alertMsg%>'+'\n'
				<%
			}
			
		}
	}
	}catch(Exception ee){
		ee.printStackTrace();		
	}
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
		if(patientList.size() > 0){
			
%>
		alert("Patient is already registered..\n")
		
		document.getElementById('titleId').value = '0';
		document.getElementById('pFirstNameId').value = '';
		document.getElementById('pMiddleNameId').value = '';
		document.getElementById('pLastNameId').value = '';
		document.getElementById('patientStatus').value = '';
		document.getElementById('dobId').value = '';
		document.getElementById('relationId').value = '0';
		document.getElementById('ageId').value = '';
		document.getElementById('occupation').value = '0';
		document.getElementById('mrstatus').value = '0';
		document.getElementById('bldGrp').value = '0';
		document.getElementById('hinNoDivId').innerHTML = "";
			<%}else{
			%>

			document.getElementById('titleId').value = '0';
			document.getElementById('pFirstNameId').value = '';
			document.getElementById('pMiddleNameId').value = '';
			document.getElementById('pLastNameId').value = '';
			document.getElementById('patientStatus').value = '';
			document.getElementById('dobId').value = '';
		//	document.getElementById('relationId').value = '0';
			document.getElementById('ageId').value = '';
			document.getElementById('occupation').value = '0';
		//	document.getElementById('mrstatus').value = '0';
			document.getElementById('bldGrp').value = '0';
			getHin();
			<%
				}
			}
			if(!srNo.equals("")){
			%>
			alert(alt1+'<%=srNo%>'+'\n'+alt)
			<%}%>
</script>