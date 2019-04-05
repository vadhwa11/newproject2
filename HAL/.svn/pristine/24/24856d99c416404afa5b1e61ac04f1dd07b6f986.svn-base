<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferByServiceNo.jsp  
 * Purpose of the JSP -  This is for Transfer By Service Number.
 * @author  Ritu
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />

<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> patientMap = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
	}
	%>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="transferByServiceNo" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"<%= HIN_NO%>"], [2,"<%= FIRST_NAME %>"], [3,"<%= ADDRESS%>"]];
	 statusTd = 3;
	</script>
</div>
</form>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Hin"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "<%= HIN_NO%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "<%= FIRST_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Address"
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "<%= ADDRESS%>";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
	    for( Patient  patient : patientList)
	    {			
	    	Set<Inpatient> inpatientSet = patient.getInpatients();
			for(Inpatient inpatient : inpatientSet){
				if(inpatient.getAdStatus().equals("A")){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%= patient.getTitle().getTitleName()%> <%=patient.getPFirstName()%> <%=patient.getPLastName()%> "
			data_arr[<%= counter%>][3] = "<%= patient.getAddress()%>"
	<%			
				}
			}
			 counter++;
		}
	%>
	
    formName = "transferByServiceNo"
	nonEditable = ['<%=HIN_ID%>'];
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
