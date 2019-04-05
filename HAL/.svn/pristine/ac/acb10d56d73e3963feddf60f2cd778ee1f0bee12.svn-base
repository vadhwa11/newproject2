<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>


<title>Patient Search</title>
<div id="contentspace"><br />
<form name="search" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<Inpatient>)patientMap.get("patientList");
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>

<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Patient Search</font></div>
<div style="width: 15px; float: left; background: #FFF;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" height="21" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 140px; background-color: #f4f9fe;">

<br />

<label class="bodytextB">Service No.</label> <input type="text"
	name="<%=SERVICE_NO %>" value="" class="textbox_size20" MAXLENGTH="20" />
<label class="bodytextB">Hin:</label> <input type="text"
	name="<%=HIN_NO %>" value="" class="textbox_size20" MAXLENGTH="50" />
<br />
<br />
<label class="bodytextB">Ser.First Name:</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" /> <label class="bodytextB">Ser.Mid Name:</label> <input
	type="text" name="<%=S_MIDDLE_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" /> <label class="bodytextB">Ser.Last Name:</label> <input
	type="text" name="<%=S_LAST_NAME%>" value="" class="textbox_size20"
	style="width: 110px;" MAXLENGTH="15" /> <br />
<br />
<label class="bodytextB">Patient First Name:</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" /> <label class="bodytextB">Patient Mid Name:</label> <input
	type="text" name="<%=P_MIDDLE_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" /> <label class="bodytextB">Patient Last Name:</label>
<input type="text" name="<%=P_LAST_NAME%>" value=""
	class="textbox_size20" style="width: 110px;" MAXLENGTH="15" /></div>

</form>
<br />
<div id="contentHolder"><input type="button" name="Submit"
	id="addbutton"
	onclick="submitForm('search','/hms/hms/opd?method=showPatientDetails');"
	value="Search" class="cmnButton" accesskey="a" /></div>


<br />
<br />

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientSearch" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"unit"]];
	 statusTd = 7;
	</script>
</div>
</form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Hin"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service Type"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "serviceType"
	
	data_header[4] = new Array;
	data_header[4][0] = "Service Person Name"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";
	
	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit"
	
	
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Inpatient inpatient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getHin().getId()%>
			data_arr[<%= counter%>][1] = "<%=inpatient.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(inpatient.getHin().getPMiddleName() != null){
						middleName = inpatient.getHin().getPMiddleName();
					}
					if(inpatient.getHin().getPLastName() != null){
						lastName = inpatient.getHin().getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][3] = "<%=inpatient.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = "<%=inpatient.getHin().getServiceType().getServiceTypeName()%> "
			<%
			if(inpatient.getHin().getSFirstName() != null  && !(inpatient.getHin().getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(inpatient.getHin().getSMiddleName() != null){
					sMiddleName = inpatient.getHin().getSMiddleName();
				}
				if(inpatient.getHin().getSLastName() != null){
					sLastName = inpatient.getHin().getSLastName();
				}
				String sName = inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
			%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}
				if(inpatient.getHin().getRank() != null){
				%>
				data_arr[<%= counter%>][6] = "<%=inpatient.getHin().getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(inpatient.getHin().getUnit() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=inpatient.getHin().getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				
		
		<%
				}
				     counter++;
		    	}
			}
		%>
		
    formName = "patientSearch"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
