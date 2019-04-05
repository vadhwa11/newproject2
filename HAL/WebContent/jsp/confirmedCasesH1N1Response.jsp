<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>

<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<script type="text/javascript">
	function checkAfmsfReceipt(){

	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="First Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("presentUnit").value==0){
			errMsg=errMsg+"Select posted from Unit \n"
		}
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("medicalCategory").value == 0){
		   errMsg=errMsg+"Select medicalCategory \n"
		}
		/*
		if(document.getElementById("Authority").value == ""){
		   errMsg=errMsg+"Authority of posting In should not be Blank \n"
		}
		
		if(document.getElementById("suffix").value == ""){
		  errMsg=errMsg+"Select suffix \n"
		}
		*/
		
		if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank\n"
		}
		/*
		if(document.getElementById("receiptLatterNo").value == "")
		{
		document.getElementById("docStatus").value = 'd';  
		}else{
		 document.getElementById("docStatus").value = 'e';
		}
		
		
		if(document.getElementById("afmsType").value == "OUT"){
		   errMsg=errMsg+"service person cleared this place you can't update the data \n"
		}
		*/
		if(errMsg == ""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
 	</script> <script type="text/javascript" language="javascript">
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
		
		
	</script>



<%
	String userName = "";
	String remarks = "";
	String jspFlag = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	Box box = HMSUtil.getBox(request);

	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	String hinNo = null;
	String serviceNo = null;

	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<Patient> patientList = new ArrayList<Patient>();

	List<MasRank> rankList = null;
	List<MasUnit> unitList = null;
	List<MasAdministrativeSex> masAdministrativeSexList = null;
	List<MasMedicalCategory> masMedicalList = null;
	List<MasRelation> relationList = null;
	if (map.get("relationList") != null) {
		relationList = (List<MasRelation>) map.get("relationList");
	}
	if (map.get("rankList") != null) {
		rankList = (List<MasRank>) map.get("rankList");
	}
	if (map.get("unitList") != null) {
		unitList = (List<MasUnit>) map.get("unitList");
	}
	if (map.get("serviceNo") != null) {
		serviceNo = (String) map.get("serviceNo");
	}
	if (map.get("masAdministrativeSexList") != null) {
		masAdministrativeSexList = (List<MasAdministrativeSex>) map
				.get("masAdministrativeSexList");

	}
	if (map.get("masMedicalList") != null) {
		masMedicalList = (List<MasMedicalCategory>) map
				.get("masMedicalList");

	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
	}
	String patientName = "";
	String servicePersonName = "";
	int relationId = 0;
	int rankId = 0;
	int unitId = 0;
	String age="";
	int sexId=0;
	if (patientList.size() > 0) {
		for (Patient patient : patientList) {

			patientName = patient.getPFirstName();
			if (patient.getPMiddleName() != null) {
				patientName +=" "+ patient.getPMiddleName();
			}
			if (patient.getPLastName() != null) {
				patientName +=" "+ patient.getPLastName();
			}
			servicePersonName=patient.getSFirstName();
			if (patient.getPMiddleName() != null) {
				servicePersonName +=" "+ patient.getSMiddleName();
			}
			if (patient.getSLastName() != null) {
				servicePersonName += " "+patient.getSLastName();
			}
			
			if (patient.getRelation() != null) {
				relationId = patient.getRelation().getId();
			}
			if (patient.getRank() != null) {
				rankId = patient.getRank().getId();
			}
			if (patient.getUnit() != null) {
				unitId = patient.getUnit().getId();
			}
			age=patient.getAge();
			if (patient.getSex() != null) {
				sexId = patient.getSex().getId();
			}
			
		}
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
%> 
					<div class="Clear"></div>	
					<label class="noWidth"> <span> <%=message%> </span> </label>
					<div class="Clear"></div>	
					 <%
						 	}
						 %>
<div id="deficientId">
 <label><span>*</span> Patient Name:</label> <input type="text"
	name="<%=P_FIRST_NAME%>" id="pFirstName" value="<%=patientName%>" MAXLENGTH="30"
	validate="Patient Name,String,Yes" tabindex="3"/> 
	
	<label><span>*</span> Relation With Service Person:</label> <select
	name="<%=RELATION_ID%>" id="relationId" tabindex="4">
	<option value="0">Select</option>
	<%
		for (MasRelation masRelation : relationList) {
			if (relationId == masRelation.getId()) {
	%>
									<option value="<%=masRelation.getId()%>" selected="selected"><%=masRelation.getRelationName()%></option>
									<%
										} else {
									%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%
		}
		}
	%>
</select>
 
<div class="Clear"></div> 
 <label><span>*</span> Rank:</label> <select
	name="<%=RANK_ID%>" id="rankId" tabindex="5">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {

			if (rankId == masRank.getId()) {
	%>
	<option value="<%=masRank.getId()%>" selected="selected"><%=masRank.getRankName()%></option>
	<%
		} else {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
		}
	%>
</select>
<label><span>*</span> Service Person Name:</label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME%>" id="name" value="<%=servicePersonName%>" MAXLENGTH="30"
	validate="Service Person Name,String,Yes" tabindex="6"/> 
	
<div class="Clear"></div>

	<label><span>*</span> Unit:</label> <select
	name="<%=PRESENT_UNIT%>" id="presentUnit" tabindex="7">
	<%
		for (MasUnit masUnit : unitList) {
			if(unitId==masUnit.getId()){
				%>
				<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
				<%
			}else{
				%>
				<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
				<%			
			}
	
		}
	%>
</select>
<label><span>*</span> Age:</label> <input type="text"
	name="<%=AGE%>" id="age" value="<%=age %>" tabindex="8" maxlength="3"/>
<div class="Clear"></div>
<label><span>*</span> Sex:</label> 
<select name="<%=SEX%>" id="sex" tabindex="9">
	<option value="0">Select</option>
	<%
		for (MasAdministrativeSex administrativeSex : masAdministrativeSexList) {
			if(sexId==administrativeSex.getId()){
				%>
				<option value="<%=administrativeSex.getId()%>" selected="selected"><%=administrativeSex.getAdministrativeSexName()%></option>
				<%
			}else{
				%>
				<option value="<%=administrativeSex.getId()%>"><%=administrativeSex.getAdministrativeSexName()%></option>
				<%			
			}
	
		}
	%>
</select> 



<div class="Clear"></div>
 </div>
