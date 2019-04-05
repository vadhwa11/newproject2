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
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
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


<title>Patient Search For Pre Anaesthesia Procedure Notes Entry</title>
<div id="contentspace"><br />
<form name="search" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		String otProcedure="";
		String url="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OtBooking>)patientMap.get("patientList");
		}
		if(patientMap.get("otProcedure") != null){
			otProcedure= (String)patientMap.get("otProcedure");
		}
		if(otProcedure.equals("yes"))
		{
			
		}
		else if(otProcedure.equals("no"))
		{
			
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

<label class="medium">Hin:</label> <input type="text"
	name="<%=HIN_NO %>" id="hinNo" value="" class="textbox_size20"
	MAXLENGTH="50" /> <label class="medium">Service No.</label> <input
	type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""
	class="textbox_size20" MAXLENGTH="20" /> <br />
<br />
<label class="medium">Patient First Name:</label> <input type="text"
	name="<%=P_FIRST_NAME %>" id="fName" value="" class="textbox_size20"
	MAXLENGTH="15" /> <label class="medium">Patient Mid Name:</label> <input
	type="text" name="<%=P_MIDDLE_NAME %>" id="mName" value=""
	class="textbox_size20" MAXLENGTH="15" /> <label class="medium">Patient
Last Name:</label> <input type="text" name="<%=P_LAST_NAME%>" value=""
	id="lName" class="textbox_size20" style="width: 110px;" MAXLENGTH="15" />


</div>
<script type="text/javascript">
   function checkBlank(){
     var hin=document.getElementById('hinNo').value;
     var serviceNo=document.getElementById('serviceNo').value;
     var fName=document.getElementById('fName').value;
     var mName=document.getElementById('mName').value;
     var lName=document.getElementById('lName').value;
       if(hin =="" & serviceNo=="" & fName=="" & mName=="" & lName=="")
       {
          alert("Please Enter any Value For Search!!")
          return false;
       }else
         return true;
   }
 </script></form>
<br />

<input type="button" name="Submit" id="addbutton"
	onclick="if(checkBlank()){submitForm('search','/hms/hms/ot?method=showOtPatientDetails');}"
	value="Search" class="button" accesskey="a" /> <br />
<br />

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%if(otProcedure.equals("no")){ %>
<form name="preAnaesthesiaPatientSearch" method="post" action="">
<%}else if(otProcedure.equals("yes")){ %>
<form name="otProcedureNotesEntry" method="post" action="">
<%} %> <script type="text/javascript">
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
	
	<% 	for(OtBooking otBooking : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= otBooking.getHin().getId()%>
			data_arr[<%= counter%>][1] = "<%=otBooking.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=otBooking.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(otBooking.getHin().getPMiddleName() != null){
						middleName = otBooking.getHin().getPMiddleName();
					}
					if(otBooking.getHin().getPLastName() != null){
						lastName = otBooking.getHin().getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][3] = "<%=otBooking.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = "<%=otBooking.getHin().getServiceType().getServiceTypeName()%> "
			<%
			if(otBooking.getHin().getSFirstName() != null  && !(otBooking.getHin().getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(otBooking.getHin().getSMiddleName() != null){
					sMiddleName = otBooking.getHin().getSMiddleName();
				}
				if(otBooking.getHin().getSLastName() != null){
					sLastName = otBooking.getHin().getSLastName();
				}
				String sName = otBooking.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
			%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}
				if(otBooking.getHin().getRank() != null){
				%>
				data_arr[<%= counter%>][6] = "<%=otBooking.getHin().getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(otBooking.getHin().getUnit() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=otBooking.getHin().getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				
		
		<%
				}
				     counter++;
		    	}
			}
		%>
	<%if(otProcedure.equals("no")){ %>	
    	formName = "preAnaesthesiaPatientSearch"
	<%}else if(otProcedure.equals("yes")){ %>
		formName = "otProcedureNotesEntry"
	<%} %>
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
