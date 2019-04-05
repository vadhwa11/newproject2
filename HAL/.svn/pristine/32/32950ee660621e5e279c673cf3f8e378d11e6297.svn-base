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
<%@page import="jkt.hms.util.HMSUtil"%>
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
<div id="contentspace">
<form name="search" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OtBooking>)patientMap.get("patientList");
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>

<!-- <div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Patient Search</font></div>
<div style="width: 15px; float: left; background: #FFF;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" height="21" /></div> -->

<div class="titleBg">
<h2>Patient Search</h2>
</div>

<div class="Block">
<label>Service No.</label> <input type="text"
	name="<%=SERVICE_NO %>" id="serviceNo" value="" MAXLENGTH="20" /> <label>Hin:</label> <input
	type="text" name="<%=HIN_NO %>" id="hinNo" value="" MAXLENGTH="50" /> <br />
<div class="Clear"></div>
<label>Patient First Name:</label> <input type="text" name="<%=P_FIRST_NAME %>" id="fName" value="" MAXLENGTH="15" />
<label>Patient Mid Name:</label>
<input type="text" name="<%=P_MIDDLE_NAME %>" id="mName" value="" MAXLENGTH="15" />
<label>Patient Last Name:</label><input type="text" name="<%=P_LAST_NAME%>" value="" id="lName"  MAXLENGTH="15" />

<div class="Clear"></div>
<label>ServiceFirst Name:</label> <input type="text" name="<%=S_FIRST_NAME %>" id="sfName" value="" MAXLENGTH="15" />
	<label>ServiceMid Name:</label> <input
	type="text" name="<%=S_MIDDLE_NAME %>" id="smName" value="" MAXLENGTH="15" />
	<label>ServiceLast Name:</label>
	<input type="text" name="<%=S_LAST_NAME%>" value="" id="slName" MAXLENGTH="15" /></div>
<script type="text/javascript">
   function checkBlank(){
     var hin=document.getElementById('hinNo').value;
     var serviceNo=document.getElementById('serviceNo').value;
     var fName=document.getElementById('fName').value;
     var mName=document.getElementById('mName').value;
     var lName=document.getElementById('lName').value;
     
     var sfName=document.getElementById('sfName').value;
     var smName=document.getElementById('smName').value;
     var slName=document.getElementById('slName').value;
     
       if(hin =="" & serviceNo=="" & fName=="" & mName=="" & lName=="" & sfName == "" & smName == "" & slName=="")
       {
          alert("Please Enter any Value For Search!!")
          return false;
       }else
         return true;
   }
 </script></form>
<br />
<div id="contentHolder"><input type="button" name="Submit"
	id="addbutton"
	onclick="if(checkBlank()){submitForm('search','/hms/hms/ot?method=searchPatientDetailsForDisposal');}"
	value="Search" class="cmnButton" accesskey="a" /></div>

<br />
<br />

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientSearchForDisposal" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"surgeryDate"] , [2,"servNo"], [3,"hin"], [4,"patName"], [5,"serviceType"], [6,"sPersonName"], [7,"rank"], [8,"unit"]];
	 statusTd = 8;
	</script>
</div>
</form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Surgery Date"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "surgeryDate"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"
	
	data_header[2] = new Array;
	data_header[2][0] = "Hin"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Service Type"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "serviceType"
	
	data_header[5] = new Array;
	data_header[5][0] = "Service Person Name"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	
	data_header[6] = new Array;
	data_header[6][0] = "Rank"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "rank";
	
	data_header[7] = new Array;
	data_header[7][0] = "Unit"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "unit"
	
	data_arr = new Array();
	<%
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(OtBooking inpatient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(inpatient.getSurgeryDate())%>"
			
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getServiceNo()%>"
			data_arr[<%= counter%>][3] = "<%=inpatient.getHin().getHinNo()%>"
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
			data_arr[<%= counter%>][4] = "<%=inpatient.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][5] = "<%=inpatient.getHin().getServiceType().getServiceTypeName()%> "
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
				data_arr[<%= counter%>][6] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(inpatient.getHin().getRank() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=inpatient.getHin().getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}
				if(inpatient.getHin().getUnit() != null){
				%>
				data_arr[<%= counter%>][8] = "<%=inpatient.getHin().getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][8] = ""
		<%
				}
				     counter++;
		    	}
			}
		%>
		
    formName = "patientSearchForDisposal"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
