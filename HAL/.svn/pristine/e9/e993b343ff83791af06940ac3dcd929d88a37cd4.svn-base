<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTransferSearch.jsp 
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
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("adNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pMName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("sFName").value;
	errorMsg=errorMsg+document.getElementById("sMName").value;
	errorMsg=errorMsg+document.getElementById("sLName").value;
		if(document.getElementById("serviceTypeId").value !=0)
	errorMsg=errorMsg+document.getElementById("serviceTypeId").value;
		if(document.getElementById("rankId").value !=0)
	errorMsg=errorMsg+document.getElementById("rankId").value;
		if(document.getElementById("unitId").value !=0)
	errorMsg=errorMsg+document.getElementById("unitId").value;
		if(document.getElementById("wardId").value !=0)
	errorMsg=errorMsg+document.getElementById("wardId").value;
	
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<title>Patient Transfer Search</title>
<div id="contentHolder"><br />
<form name="patientTransferSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
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
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
	%>

<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Admission No:</label> <input
	type="text" name="<%=AD_NO %>" value="" MAXLENGTH="30" id="adNo" /> <label>Hin:</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50"
	id="hinNo" /> <label>Ward:</label> <select name="<%=WARD_ID %>"
	id="wardId">
	<option value="0"><--Select Ward--></option>
	<%
				for(MasDepartment masDepartment : wardList)
				{
				%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
				}
				%>
</select>
<div class="Clear"></div>

<label>P First Name:</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="pFName" /> <label>P
Mid Name:</label> <input type="text" name="<%=P_MIDDLE_NAME %>" value=""
	MAXLENGTH="15" id="pMName" /> <label>P Last Name:</label> <input
	type="text" name="<%=P_LAST_NAME%>" value="" MAXLENGTH="15" id="pLName" />
<div class="Clear"></div>


<label>Ser. First Name:</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" id="sFName" /> <label>Ser.
Mid Name:</label> <input type="text" name="<%=S_MIDDLE_NAME %>" value=""
	MAXLENGTH="15" id="sMName" /> <label>Ser. Last Name:</label> <input
	type="text" name="<%=S_LAST_NAME%>" value="" MAXLENGTH="15" id="sLName" />
<div class="Clear"></div>

<label>Service No:</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" id="serviceNo" /> <label>Service Type:</label>
<select name="<%=SERVICE_TYPE_ID %>" id="serviceTypeId">
	<option value="0"><--Select Ser Type--></option>
	<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%
			}
			%>
</select> <label>Rank:</label> <select name="<%=RANK_ID %>" id="rankId">
	<option value="0"><--Select Rank--></option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>

<label>Unit:</label> <select name="<%=UNIT_ID %>" id="unitId">
	<option value="0"><--Select Unit--></option>
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

</div>

</form>
<br />

<input type="button" name="Search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('patientTransferSearch','/hms/hms/adt?method=searchPatientDetailsForTransfer');}"
	value="Search" class="button" accesskey="a" />


<div class="Clear"></div>

<%String msg ="";

for(Inpatient inpatient2:inpatientList){
	if(inpatient2.getAdStatus().equals("W")){
		msg=inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()+" ("+inpatient2.getHin().getRelation().getRelationName()+" of "+inpatient2.getHin().getRank().getRankName()+" "+inpatient2.getHin().getSFirstName()+" "+inpatient2.getHin().getSMiddleName()+" "+inpatient2.getHin().getSLastName()+") Admitted (But not Acknowledged)  ";
	%>
<div class="Clear"></div>

<h2><font id="error"><%=msg%></font></h2>
<div class="Clear"></div>

<%}} %>
<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientTransfer" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"],[2,"hin"], [3,"a&dNo"], [4,"patName"], [5,"serviceType"], [6,"sPersonName"], [7,"rank"], [8,"unit"], [9,"ward"]];
	 statusTd = 9;
	</script>
</div>
</form>
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
	data_header[1][0] = "A&D No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Hin"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "a&dNo";
	
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
	
	data_header[8] = new Array;
	data_header[8][0] = "Ward"
	data_header[8][1] = "data";
	data_header[8][2] = "30%";
	data_header[8][3] = "ward";
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (inpatientList != null && inpatientList.size() > 0) { %>
	
	<% 	for(Inpatient inpatient : inpatientList){
		if(inpatient.getAdStatus().equals("A")){
		Patient patient = inpatient.getHin();
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getAdNo()%>"
			data_arr[<%= counter%>][3] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%> "
			data_arr[<%= counter%>][5] = "<%=patient.getServiceType().getServiceTypeName()%> "
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
				data_arr[<%= counter%>][6] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(patient.getRank() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=patient.getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}
				if(patient.getUnit() != null){
				%>
				data_arr[<%= counter%>][8] = "<%=patient.getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][8] = ""
				<%}%>
		<%
			if(inpatient.getDepartment()!= null){
			%>
				data_arr[<%= counter%>][9] = "<%= inpatient.getDepartment().getDepartmentName()%>"
		<%	}else{%>
				data_arr[<%= counter%>][9] = ""
			<%
					}
				     counter++;
	}//for if	    	
	}
			}
		%>
		
	
    formName = "patientTransfer"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
