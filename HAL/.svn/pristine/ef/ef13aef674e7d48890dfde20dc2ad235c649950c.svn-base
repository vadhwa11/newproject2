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
<script type="text/javascript">

animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}


	List<Patient> patientList = new ArrayList<Patient>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}

	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}

	String departmentTypeCodeForCR = properties.getProperty("departmentTypeCodeForCR");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	if(patientList.size() > 0)
	{
		Patient patient = patientList.get(0);
		if(!patient.getPatientStatus().equals("Expired")){
			String age = "";
			String currentAge = "";
			age = patient.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());


		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}

		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(detailsMap.get("complaintList") != null){
			complaintList = (List<MasComplaint>)detailsMap.get("complaintList");
		}
		if(detailsMap.get("caseTypeList") != null){
			caseTypeList = (List<MasCaseType>)detailsMap.get("caseTypeList");
		}
		if(detailsMap.get("diagnosisList") != null){
			diagnosisList = (List<MasDiagnosisConclusion>)detailsMap.get("diagnosisList");
		}
		if(detailsMap.get("disposalList") != null){
			disposalList = (List<MasDisposal>)detailsMap.get("disposalList");
		}

%>



<form name="visitByHin" method="post">

	<div class="titleBg">
	<h2>Patient Visit </h2></div>
	<div class="clear"></div>

	<h4>Service Personnel Details</h4>
<div class="clear"></div>
<div class="Block">
			<label>Service Type</label>
			<label class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

			<label>Service No</label>
		  <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%>

			<label class="value"><%= patient.getServiceNo()%></label>
			<%}else{ %>
			<label class="value">-</label>
			<%}%>

			<label class="auto">Service Status</label>
			
			<%if(patient.getServiceStatus() != null){
			%>
			<label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
			<%}else{ %>
			<label class="value">-</label>
			<% }%>
		<div class="clear"></div>

			<label>Relation</label>
			<%
				if(patient.getRelation() != null){
			%>
				<label class="value"><%= patient.getRelation().getRelationName()%></label>
				<%}else{ %>
			<label class="value">-</label>
				<% }%>

			<label>Name</label>
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
			 %>
			<label class="value" style="width:auto"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
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

		 <%	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))&&patient.getServiceCardStatus()!=null){
					if(patient.getServiceCardStatus().equals("y")){
			%>

			<div class="clear"></div>
			<label>I-Card Verified</label>
			<label class="value">Yes</label>
			<%		}else{%>
			<div class="clear"></div>
			<label>I-Card Verified</label>
			<label class="value">No</label>
			<%		}
				}%>

			
			<div class="clear"></div>

  </div>

<!-- <a href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a> -->
<h4>Patient Details </h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<div id="slide0">
		<label>HIN No.</label>
		<label class="value"><%=patient.getHinNo() %></label>
				<input name="hinNo" value="<%=patient.getHinNo() %>" type="hidden">
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
				<label class="value" style="width:auto"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>


				<label >Sex</label>
				<label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>

				<div class="clear"></div>

				<label>Marital Status</label>
				<%
					String maritalStatus = "";
				if(patient.getMaritalStatus() != null){
					maritalStatus = patient.getMaritalStatus().getMaritalStatusName();

				%>
				<label class="value"><%=maritalStatus%></label>
				<%}else{ %>
				<label class="value">-</label>
				<% }%>


				<label>Age</label>
				<label class="value"><%=currentAge%></label>
				<%
				String religion = "";
				if(patient.getReligion() != null){
					religion = patient.getReligion().getReligionName();
				%>

				<label class="auto">Religion</label>
				<label class="value"><%= religion%></label>
				<%} %>


	</div>
  </div>


<h4>Visit Details</h4>
<div class="clear"></div>
<div class="Block">

	<label>Visit No.</label>
	<%
	int visitNo = 0;
	int lastVisitNo = 0;
	if(patient.getCurrentVisitNo() != null){
		lastVisitNo = patient.getCurrentVisitNo();
	}
	visitNo = lastVisitNo + 1;
	%>
	<label class="value"><%=visitNo%></label>

	<label><span>*</span> Visit Date</label>
	<input type="text" id="visitDateId" name="<%=VISIT_DATE %>" value="<%=currentDate %>" class="calDate" readonly="readonly" validate="Visit Date,date,yes"  MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.getElementById('visitDateId'),event)"/>

	<label><span>*</span> Visit Time</label>
	<input type="text" name="<%=VISIT_TIME %>" value="<%=time %>" validate="Visit Time,String,yes" maxlength="10"/>

	<div class="clear"></div>

	<label><span>*</span> Department</label>
	<select id="deptId" name="<%=PATIENT_DEPARTMENT %>"  validate="Department,string,yes" onchange="populateDoctor(this.value,'visitByHin')">
		<option value="0">Select</option>
			<%
				String tokenNo = "";
				for(MasDepartment masDepartment : departmentList){
					//if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForCR)){

						if(masDepartment.getId() == deptId){
							if(map.get("tokenNo") != null){
								tokenNo = ((Integer)map.get("tokenNo")).toString();
							}
						}

				%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
		<%
				//}

			}
			%>
	</select>
		<script type="text/javascript">

		document.getElementById('deptId').value = '<%=deptId%>';

		</script>

		<label><span>*</span> Token No.</label>

		<div id="testDiv">
		<input id="tokenNoId" type="text" name="<%=TOKEN_NO %>" value="<%=tokenNo %>" validate="Token no.,string,yes" maxlength="3" readonly="readonly">
		</div>

		<label>Consulting Doc.</label>

		<select name="<%=CONSULTING_DOCTOR %>" validate="Consulting Doctor,string,no" onchange="submitProtoAjax('visitByHin','registration?method=getTokenNoForDepartment')" >//onchange="submitProtoAjaxWithDivName('visitByHin','registration?method=getConsulationRoom','crId');"
		<option value="0">Select</option>
		<%
			for(MasEmployee emp : employeeList){
				if(emp.getDepartment()!=null){
				if(emp.getDepartment().getId() == deptId){

		%>
		<option value="<%=emp.getId() %>"><%=emp.getFirstName().concat(" ").concat(emp.getLastName()) %></option>

		<%}
				}}%>
		</select>

		<script type="text/javascript">
			<%
				int i = 0;
					for(MasDepartment masDepartment : departmentList){
						for (MasEmployee masEmployee : employeeList)
						{
							if(masEmployee.getDepartment() != null){
								if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
									if(masEmployee.getEmpCategory()!=null){
									if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
								%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

								<%
								i++;
									}
								}
							  }
							}
						}
					}
				%>


			</script>

	<div class="clear"></div>


	<label>Weight</label>
	<input type="text" name="<%=WEIGHT %>" value="" validate="Weight,int,no" maxlength="3" >


	<label>Complaint</label>
	<input type="text" name="<%=COMPLAINT_ID%>" value="" validate="Complaint,string,no" maxlength="100">

	<!-- 		<select name="<%=COMPLAINT_ID%>" validate="Complaint,string,no"  >
	 		<option value="0">Select</option>
			 <%
			 	//for(MasComplaint masComplaint : complaintList){
			 %>

			<%//} %>  -->
	</select>

	

		<label>Case Type</label>
		<select name="<%=CASE_TYPE_ID %>" validate="Case Type,string,no" >
			<option value="0">Select</option>
			<%
		 			for(MasCaseType masCaseType : caseTypeList){
		 		%>
		 		<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
		 		<%} %>
	  </select>

<div class="clear"></div>
		<label>Working Diagnosis</label>
		<input type="text" name="<%=DIAGNOSIS_ID%>" style="width: 280px" value="" validate="Diagnosis,string,no" maxlength="100">

<!-- 		<select name="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,no" >
			<option value="0">Select</option>
		<%
	 			//for(MasDiagnosisConclusion masDiagnosisConclusion : diagnosisList){
	 		%>

	 		<%//} %>
	  </select> -->

		<!-- 	<label> Disposed As</label> -->
		<!-- <select name="<%=DISPOSAL_ID %>" validate="Disposal,string,no" >
			<option value="0">Select</option>
		<%
	 	//		for(MasDisposal masDisposal : disposalList){
	 		%>

	 		<%//} %>
	  </select> -->

		<div class="clear"></div>

		<input type="hidden" name="<%=HOSPITAL_STAFF %>" value=""  />

		<input id="hinId" type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
		<input type="hidden" name="<%=AGE %>" value="<%=currentAge %>">
		<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visitNo%>">


    </div>
    <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
    <div id="edited"></div>
			<input type="button" name="submitForDisable" id="submitForDisable"
			 value="Save" class="button" onClick="checkPatientVisit();" />
			<input type="reset" name ="Reset" value ="Reset" class="button" accesskey="r" />
			<input type="button" class="button"  value="Back" align="right" onClick="history.back();" />
			
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">

		<label>Changed By</label>
		<label class="value"><%=userName%></label>

		<label>Changed Date</label>
		<label class="value"><%=currentDate%></label>

		<label>Changed Time</label>
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />

		</div>
<% }
	}else{
%>

 <div class="clear"></div>
<label class="common">No Record Found!!</label>

<%
}%>
		<div id="statusMessage" class="messagelabel">
			<div class="clear"></div>
			</div>
</form>
</div>