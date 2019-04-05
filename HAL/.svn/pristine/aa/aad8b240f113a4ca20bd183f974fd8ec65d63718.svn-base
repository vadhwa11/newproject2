<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}

	
	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	Box box = HMSUtil.getBox(request);
	Visit visit = new Visit();
	Patient patient = new Patient();
	if(patientList.size() > 0){
		patient = patientList.get(0);
		
	}
	
%>

	
<div class="Block">
<label>Service No. <span>*</span></label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="<%= patient.getServiceNo()%>" validate="Service No.,metachar,yes" onblur="submitProtoAjaxWithDivName('fwcVisitEntryDirect','/hms/hms/fwc?method=getPatientData','hinDiv');" tabindex="1" />
<%-- 
<label>HIN <span>*</span></label>--%> 
<div id="hinDiv">
<input type="hidden" name="<%=HIN_NO %>" id="hinId" value="<%=patient.getHinNo() %>" tabindex="1" /> 
</div>
		
		<div class="clear"></div>

<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}

					%>
		<label>Patient Name</label>
		<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

		<label>Relation</label>
		<%
			if(patient.getRelation() != null){
		%>
		<label class="value"><%= patient.getRelation().getRelationName()%></label>
			<%}else{ %>
		<label class="value">-</label>
			<% }%>

		
		<label> Rank </label>
		<%
		    if(patient.getRank() != null){
		%>

		<label class="value"><%= patient.getRank().getRankName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="clear"></div>

		<%
					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}

					%>
		<label>Name</label>
		<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
		
	
		<label >Gender</label>
		<label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>

	
		<%
		String currentAge = "";
		String age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());

		%>
		<label>Age</label>
		<label class="value"><%=currentAge%></label>
			<div class="clear"></div>	
		<label>Unit</label>
		 <%
		if(patient.getUnit() != null){
		%> 
		<label class="value"><%= patient.getUnit().getUnitName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>

		<label>Section</label>
		<%
			if(patient.getSection() != null){
		%>
		<label	class="value"><%= patient.getSection().getSectionName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		
		
		<label>Trade/Branch</label>
		<%
			if(patient.getTrade() != null){
		%> 
		<label class="value"><%= patient.getTrade().getTradeName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		<div class="clear"></div>
		<label >Mobile No.</label>
		<%
			if(patient.getMobileNumber() != null){
		%>
		<label class="value"><%=patient.getMobileNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		
		<label >Telephone No.</label>
		<%
			if(patient.getPhoneNumber() != null){
		%>
		<label class="value"><%=patient.getPhoneNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		<%-- <label>Medical Officer</label>
	<%
		String doctorName = "";
		doctorName = visit.getDoctor().getFirstName();
		if(visit.getDoctor().getMiddleName()!=null){
			doctorName += " "+visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor().getLastName()!=null){
			doctorName += " "+visit.getDoctor().getLastName();
		}
	%>
	<label class="value"><%=doctorName %></label>
	<input type="hidden" name="<%=MEDICAL_OFFICER_ID %>" value="<%= visit.getDoctor().getId() %>">--%>
	<%--<div class="clear"></div>
 	<label>Visit/A&D No.</label>
	<label class="value"></label>
	<label> Diagnosis</label>
		<%
			String diagnosis = "";
			if(visit.getDiagnosis() != null){
				//diagnosis= visit.getDiagnosis() .getInitialDiagnosis();
				  diagnosis = visit.getDiagnosis().getDiagnosisConclusionName();	
				%>
		<label class="value"><%=diagnosis %></label>
			<%}else{
				%>
				<label class="value">&nbsp;</label>
			<%}
		%>
		<input type="hidden" name="<%=DIAGNOSIS%>" style="width: 190px" value="<%= diagnosis %>" validate="Diagnosis,string,yes" maxlength="100">
	--%>
	<div class="clear"></div>
	<input type="hidden" name="visitId" value="<%=box.getInt("visitId") %>">
	<input type="hidden" name="hinId" value="<%=patient.getId() %>">
	<input type="hidden" name="deptId" id="deptId" value="24"/>
</div>