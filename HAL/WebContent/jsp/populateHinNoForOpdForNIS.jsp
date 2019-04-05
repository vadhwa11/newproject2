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
  	 	 if(flag.equals("visit")){
  	 		url = "opd?method=getPresVisitNoForNIS";
  	 	 }
  	 	 String investigationUrl = "";
  	 	if(flag.equals("investigation")){
  	 		investigationUrl = "opd?method=getInvestigationVisitNo";
  	 	 }
  	 	if(flag.equals("issueNo")){
  	 		url = "opd?method=getPresVisitNoForIssueNo";
  	 	 }
%>

<div id="hinDiv">
<label>Patient Name </label> <%
			if(flag.equals("billing")){
			%> <select name="hinId" id="<%=HIN_NO%>" validate="Hin,metachar,yes"
	onchange="if(validateMetaCharacters(this.value)){submitForm('search','<%=url %>')}">
	<%}else if(flag.equals("visit")){ %>
	<select name="hinId" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}">
		<%}else if(flag.equals("issueNo")){ %>
	<select name="hinId" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=url %>')}">
		<%}else{%>
		<select name="hinId" id="<%=HIN_NO%>" validate="Patient Name,metachar,yes"
		onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','<%=investigationUrl %>')}" >
		<%} %>
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
		<option value="<%=patient.getId()%>"><%=patientName%>
		</option>
		<% }
			}

	     	 %>
	</select>
	
	</div>
	