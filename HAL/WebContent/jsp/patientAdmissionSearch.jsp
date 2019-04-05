<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%> 
<%@ page import="static jkt.hms.util.RequestConstants.RANK_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DEPARTMENT_ID"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.ArrayList"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("srHinNo").value;
	errorMsg=errorMsg+document.getElementById("fName").value;
	errorMsg=errorMsg+document.getElementById("mName").value;
	errorMsg=errorMsg+document.getElementById("lName").value;
	errorMsg=errorMsg+document.getElementById("servNo").value;

	if(document.getElementById("servTypeId").value !=0)
		errorMsg=errorMsg+document.getElementById("servTypeId").value;
	if(document.getElementById("rankId").value !=0)
		errorMsg=errorMsg+document.getElementById("rankId").value;
	if(document.getElementById("unitId").value !=0)
		errorMsg=errorMsg+document.getElementById("unitId").value;
	if(document.getElementById("tradeId").value !=0)
		errorMsg=errorMsg+document.getElementById("tradeId").value;
	if(document.getElementById("sectionId").value !=0)
		errorMsg=errorMsg+document.getElementById("sectionId").value;
	if(document.getElementById("stationId").value !=0)
		errorMsg=errorMsg+document.getElementById("stationId").value;
	if(document.getElementById("commandId").value !=0)
		errorMsg=errorMsg+document.getElementById("commandId").value;
	if(document.getElementById("admissionNo").value !=0)
		errorMsg=errorMsg+document.getElementById("admissionNo").value;			
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<form name="patientAdmissionSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<MasServiceType> serviceTypeList = null;
		List<Object[]> unitList = null;
		List<Patient> patientList = null;
		List<MasTrade> masTradeList = null;
		List<MasStation> stationList = null;
		List<MasSection> sectionList = null;
		List<MasCommand> commandList = null;
		List<Object[]> departmentList = new ArrayList<Object[]>();
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
			unitList= (List<Object[]>)map.get("unitList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		if(map.get("masTradeList") != null){
			masTradeList= (List<MasTrade>)map.get("masTradeList");
		}
		if(map.get("stationList") != null){
			stationList= (List<MasStation>)map.get("stationList");
		}
		if(map.get("sectionList") != null){
			sectionList= (List<MasSection>)map.get("sectionList");
		}
		if(map.get("commandList") != null){
			commandList= (List<MasCommand>)map.get("commandList");
		}
		if(map.get("departmentList") != null){
			departmentList = (List<Object[]>)map.get("departmentList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		String serviceNoOrHinNo ="";
		if(map.get("serviceNoOrHinNo") != null){
			serviceNoOrHinNo= (String)map.get("serviceNoOrHinNo");
		}
		Box box = HMSUtil.getBox(request);
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script> 

<div class="titleBg"><h2>Patient Search</h2></div>
<div class="Clear"></div>

<div class="Block">
<label>Service No.</label>
<input type="text" name="servNo" value="<%=box.getString("servNo") %>" MAXLENGTH="20"	id="servNo" />
<label>HIN</label>
<input type="text"	name="srHinNo" value="<%=box.getString("srHinNo") %>" MAXLENGTH="50" id="srHinNo" />
<label>Rank</label>
 <select name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('rankId').value='<%=box.getInt("rankId")%>'
</script>
<div class="Clear"></div>
<label> First Name</label> 
<input type="text"	name="<%=S_FIRST_NAME %>" value="<%=box.getString(S_FIRST_NAME ) %>" MAXLENGTH="15" id="fName" />
	
<label> Mid Name</label> 
<input type="text" name="<%=S_MIDDLE_NAME %>" value="<%=box.getString(S_MIDDLE_NAME) %>"	MAXLENGTH="15" id="mName" />
<label> Last Name</label> 
<input	type="text" name="<%=S_LAST_NAME%>" value="<%=box.getString(S_LAST_NAME) %>" MAXLENGTH="15" id="lName" />
<div class="Clear"></div>

<label>Service Type</label> 
<select name="servTypeId"	id="servTypeId">
	<option value="0">Select Service Type</option>
	<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('servTypeId').value='<%=box.getInt("servTypeId")%>'
</script>
<label>Trade/Branch</label> 
<select name="tradeId" id="tradeId">
	<option value="0">Select</option>
		<% 
			for(MasTrade trade : masTradeList)
			{
			%>
	<option value="<%=trade.getId()%>"><%=trade.getTradeName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('tradeId').value='<%=box.getInt("tradeId")%>'
</script>
<label>Section</label> 
<select name="sectionId" id="sectionId">
	<option value="0">Select</option>
		<% 
			for(MasSection section : sectionList)
			{
			%>
	<option value="<%=section.getId()%>"><%=section.getSectionName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('sectionId').value='<%=box.getInt("sectionId")%>'
</script>
<div class="Clear"></div>

<label>Unit</label> 
<select name="<%=UNIT_ID %>" id="unitId">
	<option value="0">Select</option>
	<%
				for(Object[] masUnit : unitList)
				{
				%>
	<option value="<%=(Integer)masUnit[0]%>"><%=(String)masUnit[1]%></option>
	<%
				}
				%>
</select>
<script>
document.getElementById('unitId').value='<%=box.getInt("unitId")%>'
</script>
<label>Station</label> 
<select name="stationId" id="stationId">
	<option value="0">Select</option>
		<% 
			for(MasStation station : stationList)
			{
			%>
	<option value="<%=station.getStationName()%>"><%=station.getStationName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('stationId').value='<%=box.getInt("stationId")%>'
</script>
<label>Command</label> 
<select name="commandId" id="commandId">
	<option value="0">Select</option>
		<% 
			for(MasCommand command : commandList)
			{
			%>
	<option value="<%=command.getId()%>"><%=command.getCommandName()%></option>
	<%
			}
			%>
</select>
<script>
document.getElementById('commandId').value='<%=box.getInt("commandId")%>'
</script>
<div class="Clear"></div>
<label>AFNET No.</label> 
<input type="text" name="afnetNo" value="<%=box.getString("afnetNo") %>"/>
<label>Mobile No.</label> 
<input type="text" name="mobileNo" value="<%=box.getString("mobileNo") %>"/>

<label>A&D No.</label> 
<input type="text" name="admissionNo" id="admissionNo" value="<%=box.getString("admissionNo") %>"/>
<div class="Clear"></div>
<label>Patient Type</label>
<select name="patientType" id="patientType" onchange="displayDepartment(this.value)">
<option value="">Select</option>
<option value="Out Patient" selected="selected">OP</option>
<option value="In Patient">IP</option>
</select>
<script>
<%
if(!box.getString("patientType").equals("")){
%>
document.getElementById('patientType').value='<%=box.getString("patientType")%>'
<%}%>
</script>
<%
if(box.getInt("departmentId")==0){
%>
<div id="wardDiv" style="display: none;">
<%}else if(box.getInt("departmentId")!=0){ %>
<div id="wardDiv" >
<%} %>
<label> Ward </label> 

<select name="departmentId" validate="Ward,String,no" tabindex="1" id="wardId">
	<option value="0">Select</option>
	<% 
		
				for(Object[] obj : departmentList){
		%>
	<option value="<%=obj[0]%>"><%=(String)obj[1]%></option>
	<%}%>
</select>
<script>
document.getElementById('wardId').value='<%=box.getInt("departmentId")%>'
</script>
</div>
<div class="Clear"></div>
</div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"	onclick="if(checkBlankSearch('patientAdmissionSearch')){submitForm('patientAdmissionSearch','/hms/hms/adt?method=searchPatientDetailsForAdmission');}"	value="Search" class="button" accesskey="a" />
	<div class="Clear"></div>
	<%String msg ="";
		
		if (patientList != null && serviceNoOrHinNo.equalsIgnoreCase("yes")) {
		for(Patient patient2 : patientList){
			if(patient2.getPatientStatus().equals("In Patient")){
				String patientName = "";
				patientName = patient2.getPFirstName();
				if(patient2.getPMiddleName() != null){
					patientName = patientName + " "+ patient2.getPMiddleName();
				}
				if(patient2.getPLastName() != null){
					patientName = patientName + " "+ patient2.getPLastName();
				}
				String sName = "";
				sName = patient2.getSFirstName();
				if(patient2.getSMiddleName() != null){
					sName = patientName + " "+ patient2.getSMiddleName();
				}
				if(patient2.getSLastName() != null){
					sName = patientName + " "+ patient2.getSLastName();
				}
				msg=patientName+" ("+patient2.getRelation().getRelationName()+" of "+patient2.getRank().getRankName()+" "+sName+") already admitted.  \n ";
				if(!msg.equals("")){
			%> <span><%//=msg %></span> <%}msg="";}}}%>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientAdmission" method="post" action="">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"radio"], [2,"servNo"], [3,"hin"], [4,"patName"], [5,"relation"], [6,"rank"], [7,"sPersonName"], [8,"serviceType"], [9,"unit"], [10,"age"],[11,"sex"]];
	 statusTd = 8;
	</script>
	<%
		if(patientList != null && patientList.size() > 0){
	%>	
<input type="hidden" id="hinId" name="hinId" value="0"/>	
<input type="hidden" id="serviceNo" name="serviceNo" value=""/>
<input type="hidden" id="serviceTypeId" name="serviceTypeId" value="0"/>
<input type="hidden"	name="hinNo" value="" MAXLENGTH="50" id="hinNo" />
<input type="hidden" id="adNo" name="adNo" value=""/>
<input type="hidden" id="departmentId" name="<%=DEPARTMENT_ID %>" value=""/>
	<div class="Clear"></div>
		<div class="paddingTop15"></div>
<%
	if(box.getString("patientType").equalsIgnoreCase("Out Patient")){
%>
<input type="button" name="registration" value="Registration" class="button" onclick="submitFormForButton('patientAdmission','/hms/hms/registration?method=showRegistrationJsp','validateRadio');"/>		
<input type="button" name="admission" value="Admission" class="button" onclick="submitFormForButton('patientAdmission','/hms/hms/adt?method=searchPatientDetailsForAdmission','validateRadio');"/>	
<input type="button" name="dma" value="DMA" class="button" onclick="submitFormForButton('patientAdmission','/hms/hms/registration?method=showDMARegister','validateRadio');"/>			
<input type="button" name="track" value="Tracking" class="button" onclick="submitFormForButton('patientAdmission','/hms/hms/adt?method=showPatientTrackJsp','validateRadio');"/>			
<%}else if(box.getString("patientType").equalsIgnoreCase("In Patient")){ %>
<input type="button" class="buttonBig" value="Kit Issue" onclick="submitForm('patientAdmission','/hms/hms/ipd?method=printIssuedKitListReport','validatePatient');" />
<input type="button" class="buttonBig" value="Diet List"  onClick="submitForm('patientAdmission','/hms/hms/ipd?method=printPatientDietReport')" />
<input type="button" class="buttonBig" value="Case Sheet" onclick="submitForm('patientAdmission','/hms/hms/ipd?method=showPatientMedicalCaseSheetReportForWard','validatePatientForCaseSheet');" />
<input type="button" class="buttonBig" value="Nursing Care Register" onClick="submitForm('patientAdmission','/hms/hms/ipd?method=showNursingCareReport','validatePatient');"	/>
<input type="button" class="buttonBig" value="Clinical Chart" onClick="submitForm('patientAdmission','/hms/hms/discharge?method=showClinicalSheetReport','validatePatient');"	/>
<input type="button" class="buttonBig" value="Intake Output Register" onClick="submitForm('patientAdmission','/hms/hms/ipd?method=showIntakeOutputChartReport&reportType=summary','validatePatient');"	/>
<input type="button" class="buttonBig" value="SIL/DIL " onClick="submitForm('patientAdmission','/hms/hms/ipd?method=showSilDilReport','validatePatient');" />
<input type="button" class="buttonBig" value="MLC"  onClick="submitForm('patientAdmission','/hms/hms/adt?method=showMedicoLegalReportJsp','validatePatient');" />

<input type="button" class="buttonBig" value="Patient Wise Drug Issue" onClick="submitForm('patientAdmission','/hms/hms/ipd?method=printDateWisePatientWiseDrugIssuedReport','validatePatient');" />
<input type="button" class="buttonBig" value="Prescription Details" onClick="submitForm('patientAdmission','/hms/hms/ipd?method=printIPPrescriptionInvestReport&flag=prescription','validatePatient');" />
<input type="button" class="buttonBig" value="Invetigation Details"  onClick="submitForm('patientAdmission','/hms/hms/ipd?method=printIPPrescriptionInvestReport&flag=investigation','validatePatient');" />

<input type="button" class="buttonBig" value="Discharge Slip" onClick="if(checkPatientForDischarge()){submitForm('patientAdmission','discharge?method=showDischargeSummaryReport');}"	/>
<!--<input type="button" class="buttonBig" value="Death Certificate" onClick="submitForm('patientAdmission','ipd?method=showWardList');"	/>  


		--><%}
		}
	%>
		<div class="Clear"></div>
		<div class="paddingTop15"></div>
</form>
</div>
<div class="Clear"></div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "radio";
	data_header[0][2] = "5%";
	data_header[0][3] = "radio"
	
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No."
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"
	
	data_header[2] = new Array;
	data_header[2][0] = "HIN"
	data_header[2][1] = "hide";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Relation"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "relation"

	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "rank";	
	
	data_header[6] = new Array;
	data_header[6][0] = "Name"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "sPersonName";
	
	data_header[7] = new Array;
	data_header[7][0] = "Service Type"
	data_header[7][1] = "hide";
	data_header[7][2] = "10%";
	data_header[7][3] = "serviceType";
	
	data_header[8] = new Array;
	data_header[8][0] = "Unit"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "unit"
	
	data_header[9] = new Array;
	data_header[9][0] = "Age"
	data_header[9][1] = "data";
	data_header[9][2] = "30%";
	data_header[9][3] = "age";

	
	data_header[10] = new Array;
	data_header[10][0] = "Gender"
	data_header[10][1] = "data";
	data_header[10][2] = "30%";
	data_header[10][3] = "sex";
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Patient patient : patientList){
		String adNo = "";
		int departmentId=0;
		if(patient.getPatientStatus().equalsIgnoreCase("In Patient")){
			if(patient.getInpatients()!=null){
				for(Inpatient inpatient : patient.getInpatients()){
					if(!inpatient.getAdStatus().equalsIgnoreCase("D")){
						adNo = inpatient.getAdNo();
						departmentId=inpatient.getDepartment().getId();
						break;
					}
				}
			}
		}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="hinId" value="<%= patient.getId()%>" id="hinId<%=counter%>" onclick="setHinId(<%=counter %>,<%= patient.getServiceNo()!=null? patient.getServiceNo():""%>,<%= patient.getServiceType()!=null?patient.getServiceType().getId():"0"%>,\'<%=patient.getHinNo()!=null?patient.getHinNo():""%>\',\'<%=adNo%>\',<%=departmentId%>)"/>'
				
			data_arr[<%= counter%>][2] = "<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>"
			data_arr[<%= counter%>][3] = "<%=patient.getHinNo()!=null?patient.getHinNo():""%>"
<%
	String pName = "";
	pName = patient.getPFirstName()!=null?patient.getPFirstName():"";
	if(patient.getPMiddleName() != null){
		pName = pName.concat(" ").concat(patient.getPMiddleName());
	}
	if(patient.getPLastName() != null){
		pName = pName.concat(" ").concat(patient.getPLastName());
	}

%>
				
			data_arr[<%= counter%>][4] = " <%=pName%> "
			data_arr[<%= counter%>][5] = "<%=patient.getRelation()!=null?patient.getRelation().getRelationName():""%> "
				<%
			if(patient.getRank() != null){
			%>
			data_arr[<%= counter%>][6] = "<%=patient.getRank().getRankName()%> "
			<%}else{%>
		data_arr[<%= counter%>][6] = ""
			<%}%>
			
			<%try{
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
				data_arr[<%= counter%>][7] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
					<%}%>
				data_arr[<%= counter%>][8] = "<%=patient.getServiceType()!=null?patient.getServiceType().getServiceTypeName():""%> "
				<%
				if(patient.getUnit() != null){
					if(patient.getUnit().getUnitName() != null){
				%>
				data_arr[<%= counter%>][9] = "<%=patient.getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][9] = ""
					<%}
				}else{%>
				data_arr[<%= counter%>][9] = ""
				<%}%>
				<% if(patient.getAge()!=null){
				%>
				data_arr[<%= counter%>][10] = "<%=patient.getAge()%>"
			<%	
			}else{%>
			data_arr[<%= counter%>][10] = ""
				<%} if(patient.getSex()!=null){ 
					%>
					data_arr[<%= counter%>][11] = "<%=patient.getSex().getAdministrativeSexName()%>"
				<%	
				}else{%>
				data_arr[<%= counter%>][11] = ""	
		<%
				}
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
		    	}
			}
		%>
		
		
	
    formName = "patientAdmission"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	

	function validateRadio(){
		
		 for(var i = 0; i < document.getElementsByName('hinId').length; i++){
		  if(document.getElementsByName('hinId')[i].checked == true)
	     {
			return true;
		  }		
		}
		alert("Please select one record.")
	return false;

	}	

	function setHinId(cnt,srNo,srType,hinNo,adNo,deptId){
		document.getElementById('hinId').value = document.getElementById('hinId'+cnt).value;
		document.getElementById('serviceTypeId').value =srType ;
		document.getElementById('serviceNo').value = srNo;
		document.getElementById('adNo').value = adNo;
		document.getElementById('hinNo').value = hinNo;
		document.getElementById('departmentId').value = deptId;
	}

	function displayDepartment(val){
		if(val=='In Patient'){
			document.getElementById('wardDiv').style.display='block';
		}else{
			document.getElementById('wardDiv').style.display='none';
		}
	}



	function checkBlankSearch(formName){
		var inputs = eval('document.'+formName+'.elements');
		var flag ='';
		for(i=0;i<inputs.length;i++){
			if(inputs[i].name!='patientType'){
				if(trimAll(inputs[i].value)!='' && inputs[i].value!='0' ){
					flag = 'true';
					break;
				}
			}
		}
		if(flag=='true'){
			return true;
		}else{
			alert("Please enter value to search.")
			return false;
		}

	}
		</script>