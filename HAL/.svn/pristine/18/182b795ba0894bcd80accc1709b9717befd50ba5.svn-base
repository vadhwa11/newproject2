<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
		List<Object> hinNoList = new ArrayList<Object>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}

		if (map.get("hinNoList") != null)
			hinNoList =(List)map.get("hinNoList");

  	    String flag = "";

  	 	 if (map.get("flag") != null)
			flag =(String)map.get("flag");

  	 	 String url = "";
  	 	 if(flag.equals("opd")){
  	 		url = "opd?method=getPresVisitNoForOPD";
  	 	 }
  	 	 if(flag.equals("pres")){
   	 		url = "opd?method=getPresVisitNo";
   	 	 }
  	 	 if(flag.equals("visit")){
  	 		 
    	 		url = "opd?method=getInvegReqVisitNo";
    	 	 }
  		 if(flag.equals("previousOpd")){
  	 		 
 	 		url = "opd?method=showPatientPreviousVisitForViewScreen";
 	 	 }
  		 if(flag.equals("previousSurgery")){
  	 		 
  	 		url = "opd?method=viewAllPrevoiusSurgery";
  	 	 }
  		
  	 	 String investigationUrl = "";
  	 	if(flag.equals("investigation")){
  	 		investigationUrl = "opd?method=getInvestigationVisitNo";
  	 	 }
  	 
  	 	if(flag.equals("currentMedication")){
  	 		url = "opd?method=getTodayOtherPrescription";
  	 	 }
  	 	
%>

<div id="hinDiv">
<label>Patient Name </label> <%
			if(flag.equals("billing")){
			%> <select name="<%=HIN_NO%>" id="<%=HIN_NO%>" validate="Hin,metachar,yes"
	onchange="if(validateMetaCharacters(this.value)){submitForm('search','<%=url %>')}">
	<%}else if(flag.equals("opd")){ %>
	<select name="<%=HIN_NO%>" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}">
		
		<%}else if(flag.equals("pres")){ %>
	<select name="<%=HIN_NO%>" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}">
		
		<%}else if(flag.equals("visit")){ %>
	<select name="<%=HIN_NO%>" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}">
			<%}else if(flag.equals("investigation")){ %>
		<select name="<%=HIN_NO%>" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=investigationUrl %>')}" >
		<%} else if(flag.equals("previousOpd") || flag.equals("previousSurgery")){ %>
		<select name="<%=HIN_ID%>" id="<%=HIN_ID%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}" >
		<%} else if(flag.equals("currentMedication")){ %>
		<select name="<%=HIN_ID%>" id="<%=HIN_ID%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}" >
		<%} %>
		
		
		
		currentMedication
		<option value="">Select</option>
		<%

	     	if (hinNoList!=null && hinNoList.size() > 0 )
	     	{
	     		for (Iterator iterator = hinNoList.iterator(); iterator.hasNext();) {
	    				Patient patient = (Patient)iterator.next();
	    				String patientName="";
	    				patientName=patient.getPFirstName();
						if(patient.getPMiddleName()!=null){
							patientName+=" "+patient.getPMiddleName();
	    				}
	    				if(patient.getPLastName()!=null){
	    					patientName+=" "+patient.getPLastName();
	    				}
	    				patientName+=" [ "+patient.getHinNo()+" ]";
				%>
				
				<%if(flag.equals("previousOpd") || flag.equals("previousSurgery")|| flag.equals("currentMedication")){ %>
				<option value="<%=patient.getId()%>"><%=patientName%>
				<%}else{ %>
		<option value="<%=patient.getHinNo()%>"><%=patientName%>
		<%} %>
		</option>
		<% }
			}

	     	 %>
	</select>
	
	</div>
	