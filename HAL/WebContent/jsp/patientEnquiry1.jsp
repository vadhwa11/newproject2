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
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
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
<form name="patientEnquirySearch1" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("unitList") != null){
			unitList= (List<MasUnit>)map.get("unitList");
		}
		if(map.get("stateList") != null)	{
			stateList = (List<MasState>)map.get("stateList");
		}
		if(map.get("districtList") != null){
			districtList =(List<MasDistrict>)map.get("districtList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		
	%>


<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Service No:</label> <input
	type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="30" /> <label>Hin
No:</label> <input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="30" /> <label>A&D
No:</label> <input type="text" name="<%=AD_NO%>" value="" MAXLENGTH="30" />

<div class="Clear"></div>

<label>Ser.First Name: </label> <input type="text"
	name="<%=SERVICE_PERSON_NAME %>" value="" MAXLENGTH="30" /> <label>Ser.Mid
Name: </label> <input type="text" name="<%=S_MIDDLE_NAME %>" value=""
	MAXLENGTH="30" /> <label>Ser.Last Name: </label> <input type="text"
	name="<%=S_LAST_NAME %>" value="" MAXLENGTH="30" />
<div class="Clear"></div>
<label>Service Type:</label> <select name="<%=SERVICE_TYPE_ID %>">
	<option value="0">Select Ser Type</option>
	<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%
			}
			%>
</select> <label>Rank:</label> <select name="<%=RANK_ID %>">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select> <label>Unit:</label> <select name="<%=UNIT_ID %>">
	<option value="0">Select Unit</option>
	<%
				for(MasUnit masUnit : unitList)
				{
				%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
				}
				%>
</select>


<div class="Clear"></div>
<label>Patient First Name:</label> <input type="text"
	name="<%=PATIENT_NAME %>" value="" MAXLENGTH="30" /> <label>Patient
Mid Name:</label> <input type="text" name="<%=P_MIDDLE_NAME %>" value=""
	MAXLENGTH="30" /> <label>Patient Last Name:</label> <input
	type="text" name="<%=P_LAST_NAME %>" value="" MAXLENGTH="30" />

<div class="Clear"></div>
<label>Address:</label> <input type="text" name="<%=ADDRESS %>"
	value="" MAXLENGTH="30" /> <label>District/City: </label> <select
	name="<%=DISTRICT_ID %>">
	<option value="0">Select District</option>
	<% for(MasDistrict masDistrict : districtList)
			{
			%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%
			}
			%>
</select> <label>State:</label> <select name="<%=STATE_ID %>">
	<option value="0">Select State</option>
	<%
				for(MasState masState : stateList)
				{
				%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%
				}
				%>
</select>
<div class="Clear"></div>
<label>Patient Status:</label> <select name="<%=PATIENT_STATUS %>">
	<option value="">All</option>
	<option value="Out Patient">Out Patient</option>
	<option value="In Patient">In Patient</option>
	<option value="Expired">Expired</option>
</select></div>

</form>
<input type="button" name="Search"
	onclick="submitForm('patientEnquirySearch1','/hms/hms/enquiry?method=searchPatientForEnquiry1');"
	value="Search" class="button" accesskey="a" />


<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientEnquiry1" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"unit"], [8,"rela"]];
	 statusTd = 8;
	</script></form>
</div>


<div class="Clear"></div>
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
	
	data_header[7] = new Array;
	data_header[7][0] = "Relation"
	data_header[7][1] = "data";
	data_header[7][2] = "30%";
	data_header[7][3] = "rela";
	
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Patient patient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patient.getPFirstName()%> <%=patient.getPMiddleName()%> <%=patient.getPLastName()%> "
			data_arr[<%= counter%>][4] = "<%=patient.getServiceType().getServiceTypeName()%> "
			<%
			if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(patient.getSMiddleName() != null){
					sMiddleName = patient.getSMiddleName();
				}
				if(patient.getSLastName() != null){
					sLastName = patient.getSLastName();
				}
				String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
				
				%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}
				if(patient.getRank() != null){
				%>
				data_arr[<%= counter%>][6] = "<%=patient.getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(patient.getUnit() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=patient.getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}%>
				<%
		if(patient.getAddress()!= null){
		%>
			data_arr[<%= counter%>][8] = "<%=patient.getRelation().getRelationName()%> "
	<%	}else{%>
			data_arr[<%= counter%>][8] = ""
		<%
				}
				     counter++;
		    	}
			}
		%>
		
    formName = "patientEnquiry1"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>
