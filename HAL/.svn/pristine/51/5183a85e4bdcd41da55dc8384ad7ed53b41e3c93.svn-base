<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 22.04.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasRelation"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
		List<Patient>listBasedonHinNo=new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		int inc=0;
		String url ;
		boolean hinNoExist=false;
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if(map.get("inc")!=null)
		{
			inc=(Integer)map.get("inc");
		}
		
		if(map.get("listBasedonHinNo")!=null){
			listBasedonHinNo=(List<Patient>)map.get("listBasedonHinNo");
		}
		if(map.get("relationList")!=null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
		if(map.get("hinNoExist")!=null )
			hinNoExist=(Boolean)map.get("hinNoExist");
		
		
		
%>

<%if(map.get("hinNoExist")!=null && listBasedonHinNo!=null && hinNoExist==true)
			 	{	
			 			if (listBasedonHinNo!=null && listBasedonHinNo.size() > 0 ) 
	     				{ 
	     					for (Iterator iterator = listBasedonHinNo.iterator(); iterator.hasNext();) {
	    					Patient patient=(Patient)iterator.next();
	    		%>
<input type="hidden" id="hinId<%=inc%>" name="<%=HIN_ID %>"
	value="<%=patient.getId()%>" />

<input type="hidden" value="<%=patient.getServiceNo()%>" size=8
	name="<%=SERVICE_NO%>" id="serviceNo<%=inc %>" MAXLENGTH="20" />
<input type="hidden" size=16 id="servicePerson<%=inc %>"
	name="servicePerson"
	value="<%=patient.getSFirstName()+" "%><%=patient.getSLastName()%>" />

<select id="relationId<%=inc%>" name="<%=RELATION_ID%>" />
	<option value="0">Select</option>
	<%for(MasRelation relation : relationList){ 
									if(patient.getRelation() != null 
											&& (patient.getRelation().getId()==relation.getId())){ %>
	<option value="<%=relation.getId()%>" selected="selected"><%=relation.getRelationName()%></option>
	<%} else {%>
	<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
	<%	} 
								}%>
</select>

<input type="text" size=16 id="patientName<%=inc%>"
	name="<%=PATIENT_NAME%>" readonly="readonly"
	value="<%=patient.getPFirstName() %>" MAXLENGTH="30"
	validate="Patient Name,fullName,no" />

<%if(patient.getMobileNumber()!=null){ %>
<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>"
	readonly="readonly" MAXLENGTH="10"
	value="<%=patient.getMobileNumber()%>" validate="Mobile No.,int,no" />
<%}else{ %>
<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>"
	readonly="readonly" MAXLENGTH="10" value=""
	validate="Mobile No.,int,no" />
<%} %>
<%if(patient.getSex().getAdministrativeSexCode().equals("M")){ %>
<select id="sex<%=inc%>" name="<%=SEX%>" />
	<option value="M" selected="selected">M</option>
	<option value="F">F</option>
</select>
<%}else if(patient.getSex().getAdministrativeSexCode().equals("F")){ %>
<select id="sex<%=inc%>" name="<%=SEX%>" />
	<option value="M">M</option>
	<option value="F" selected="selected">F</option>
</select>
<%} %>
<input type="text" size=1 id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
	readonly="readonly" value="<%=patient.getAge()%>" />
<input type="hidden" size=1 id="patientType<%=inc%>"
	name="<%=PATIENT_TYPE%>" MAXLENGTH="18"
	value="<%=patient.getPatientStatus()%>" />

<select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" disabled="disabled">
	<option value="0">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
</select>
<%		}
			 		}				 						
			 			
			 	}
			 	
			 %>

