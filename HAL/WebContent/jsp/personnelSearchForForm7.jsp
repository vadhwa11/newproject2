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
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasPersonnelDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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


<div id="contentHolder">


<form name="personnelSearch" action="" method="post">
<h6>Personnel Search For Form 7 Entry</h6>
<div class="Clear"></div>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		List<MasPersonnelDetails> personnelDetailList=new ArrayList<MasPersonnelDetails>();
		if(map.get("personnelDetailList")!= null){
			personnelDetailList=(List<MasPersonnelDetails>)map.get("personnelDetailList");
		}
		List<MasUnit> unitList=new ArrayList<MasUnit>();
		if(map.get("unitList")!= null){
			unitList=(List<MasUnit>)map.get("unitList");
		}
		
		List<MasDesignation> designationList=new ArrayList<MasDesignation>();
		if(map.get("designationList")!= null){
			designationList=(List<MasDesignation>)map.get("designationList");
		}
		String message ="";
		if(map.get("message") != null){
			    message = (String)map.get("message");
			  }
		
	%> <%if(!message.equalsIgnoreCase("")){%>
<h2><%=message %></h2>
<%} %>
<div class="blockTitle">Personnel Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Personnel Name</label> <input
	type="text" name="personnelName" value="" MAXLENGTH="30" /> <label>Pass
No. </label> <input type="text" name="passNo" value="" MAXLENGTH="30" />

<div class="Clear"></div>

<label>Unit</label> <select name="unitId">
	<option value="0">Select one</option>
	<%for(MasUnit masUnit:unitList){
		    	 int id=masUnit.getId();
		    	 String unitName=masUnit.getUnitName();
		     
		     %>
	<option value="<%=id %>"><%=unitName %></option>
	<%} %>
</select> <label>Designation</label> <select name="designationId">
	<option value="0">Select one</option>
	<%
			   for(MasDesignation masDesignation:designationList){
				   int designationId=masDesignation.getId();
				   String designation=masDesignation.getDesignationName();
			   
				   
			%>
	<option value="<%=designationId %>"><%=designation %></option>
	<%} %>
</select></div>

</form>
<div class="Clear"></div>
<input type="button" name="Search"
	onclick="submitForm('personnelSearch','/hms/hms/pension?method=personnelSearchJsp&jspName=form7');"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="personnelsearchForForm7" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"personnelName"], [2,"passNo"], [3,"FathHusName"], [4,"Unit"], [5,"designation"], [6,"sex"], [7,"dob"], [8,"appointmentDate"]];
	 statusTd = 8;
	</script>
</div>
</form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Personnel Name"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "personnelName"
	
	data_header[1] = new Array;
	data_header[1][0] = "Pass No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "passNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Father/Husband Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "FathHusName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Unit"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "Unit"
	
	data_header[4] = new Array;
	data_header[4][0] = "Designation"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "designation";
	
	data_header[5] = new Array;
	data_header[5][0] = "Sex"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "sex";
	
	data_header[6] = new Array;
	data_header[6][0] = "Date Of Birth"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "dob"
	
	data_header[7] = new Array;
	data_header[7][0] = "Appointment Date"
	data_header[7][1] = "data";
	data_header[7][2] = "30%";
	data_header[7][3] = "appointmentDate";
	
	
	data_arr = new Array();
	   <%
		
	    int  counter=0;
		if (personnelDetailList != null && personnelDetailList.size() > 0) { %>
	
	    <% 	for(MasPersonnelDetails masPersonnelDetails : personnelDetailList){
	    %>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masPersonnelDetails.getId()%>
			data_arr[<%= counter%>][1] = "<%=masPersonnelDetails.getPersonnelName()%>"
			data_arr[<%= counter%>][2] = "<%=masPersonnelDetails.getPassNo()%>"
			data_arr[<%= counter%>][3] = "<%=masPersonnelDetails.getFatherHusbandName()%>"
	    <%
	       if(masPersonnelDetails.getUnit()!= null){
	    %>		
		     data_arr[<%= counter%>][4] = "<%=masPersonnelDetails.getUnit().getUnitName()%> "
	    <%
	      }else{
	     %>	
		    data_arr[<%= counter%>][4] = "- "
	    <%}%>
				data_arr[<%= counter%>][5] = "<%=masPersonnelDetails.getDesignation().getDesignationName()%>"
				
				data_arr[<%= counter%>][6] = "<%=masPersonnelDetails.getAdministrativeSex().getAdministrativeSexName()%> "
				
				<%
				if(masPersonnelDetails.getDateOfBirth() != null){
				%>
				data_arr[<%= counter%>][7] = "<%= HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getDateOfBirth())%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}%>
				<%
				if(masPersonnelDetails.getAppointmentDate()!= null){
				%>
					data_arr[<%= counter%>][8] = "<%= HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getAppointmentDate())%>"
				<%}else{%>
					data_arr[<%= counter%>][8] = ""
				<%
					}
				     counter++;
		    	}
			}
		%>
		
    formName = "personnelsearchForForm7"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>

