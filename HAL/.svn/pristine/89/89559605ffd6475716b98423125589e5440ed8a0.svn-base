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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	List<Object[]> patientPresriptionDetailList = new ArrayList<Object[]>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("patientPresriptionDetailList") != null){
		patientPresriptionDetailList = (List)map.get("patientPresriptionDetailList");	
	}

	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	
	Visit visit = new Visit();
	Patient patient = new Patient();
	if(patientList.size() > 0){
		patient = patientList.get(0);
		
	}
	String remarks = "";
	if(patientPresriptionDetailList.size()>0){
		for(Object[] obj :patientPresriptionDetailList){
			remarks = (String)obj[12];
			break;
		}
	}
%>

	

	<%--		<label>Service No</label>
		  <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%>
			<label class="value"><%= patient.getServiceNo()%></label>
			<%}else{ %>
			<label class="value">-</label>
			<%}%>
		<label>HIN</label>
		<input type="text" value="<%=patient.getHinNo() %>">
				
				
		<div class="clear"></div> --%>

		<input type="hidden" value="<%=patient.getId() %>" name="hinId">
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
		<label>Remarks</label>
		<textarea cols="20" rows="2" tabindex="1" maxlength="45" name="remarks" validate="Remarks,string,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
		<table width="90%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th></th>
			<th>Nomenclature</th>
			<th>Medical Officer</th>
			<th>Dosage</th>
			<th>Frequency</th>
			<th>No. of Days</th>
			<th>Quantity</th>
			
		</tr>
	</thead>


	<%
	int i=1;
	int doctorId = 0;
	if(patientPresriptionDetailList.size()>0){
		for(Object[] obj :patientPresriptionDetailList){
			
			String dMName = "";
			String dLastName = "";
			if(obj[3] != null){
				dMName = (String)obj[3];
			}
			if(obj[4] != null){
				dLastName = (String)obj[4];
			}
			doctorId = (Integer)obj[8];
	%>
	<tr>
		<td><input type="checkbox" name="ctCheck<%=i%>" class="radioCheck" id="ctCheck<%=i%>" value="y" /></td>
		<td><%=obj[1] %>
		<input type="hidden" name="itemId<%=i%>" tabindex="1" id="itemId<%=i%>" value="<%=obj[9] %>" /></td>
		<td><%=obj[11]+" "+obj[2]+" "+dMName+" "+dLastName %>
		</td>
		<td><%=obj[5] %>
		<input type="hidden" name="dosage<%=i%>" tabindex="1" id="dosage<%=i%>" value="<%=obj[5] %>" /></td>
		<td><%=obj[7] %>
		<input type="hidden" name="frequencyId<%=i%>" tabindex="1" id="frequencyId<%=i%>" value="<%=obj[13] %>" /></td>
		<td><%=obj[6] %>
		<input type="hidden" name="noofDays<%=i%>" tabindex="1" id="noofDays<%=i%>" value="<%=obj[6] %>" /></td>
		<td><input type="text" name="quantity<%=i%>" tabindex="1" id="quantity<%=i%>" size="10" maxlength="40" validate="Quantity,int,no"/></td>
	</tr>

<%
i++;
		}} %>
</table>
<input type="hidden" name="doctorId" tabindex="1" id="doctorId" value="<%=doctorId %>" />
<input type="hidden" name="ctCount" value="<%=i-1 %>"
	id="cTCount" />
	<div class="clear"></div>
