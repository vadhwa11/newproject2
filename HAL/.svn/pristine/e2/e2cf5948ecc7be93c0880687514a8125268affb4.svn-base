
<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleValidation.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 11.08.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>

<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<title>Patient Search</title>
<form name="patientSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
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
	</script> <%   
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String deptName="";
		String message = "";
		String deptType = "";
		int deptId = 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<DgOrderhd>)patientMap.get("patientDetailList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
		}
		if (map.get("deptName") != null) {
		deptName= (String) map.get("deptName");
		}
		if (map.get("deptId") != null) {
			deptId= (Integer) map.get("deptId");
			}
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	</script> 
<div class="titleBg"><h2>Pending Investigations</h2></div>
<div class="Clear"></div>
<h4>Patient Search</h4>
<div class="Block">
<div class="Clear"></div>
<label>From Date <span>*</span></label> <input type="text"
	class="date" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label>To Date <span>*</span></label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<!--<label>HIN</label> <input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />

<label><span>*</span> P Type</label> <select
	name="<%=PATIENT_TYPE%>" validate="P Type,string,yes">
	<option value="OP">OPD</option>
	<option value="IP">WARD</option>
</select>
-->
<div class="Clear"></div>
<input type="hidden" name="deptType1" id="deptType1" value="<%=deptType%>" >

<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="20" />



<label>Department</label> 
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
<option value="">Select</option>
<option value="FamilyWC">FWC</option>
<option value="MedBoard">Med Board</option>
<option value="MedExam">Med Exam</option>
<option value="OPD">OPD</option>
<option value="Reception">Reception</option>
<option value="Ward">Ward</option>
	<%--<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : departmentList){
				%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%> --%>
</select> 
<div class="Clear"></div>
<label>Name</label> 
<input type="text" name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" />
<label>Patient Name</label> 
<input type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" />
<label>Modality</label>
<select name="<%=SUB_CHARGECODE_ID %>" >
<option value="0">Select</option>
<%
	for(MasSubChargecode subChargecode : subChargeCodeList){
%>
<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>

<%} %>
</select> 
<div class="Clear"></div>
</div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatient&&flag=RADIO');"
	value="Search" class="CmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
</div>
<form name="pendingSampleValidation" method="post" action="">


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	formFields = [
	  			[0, "orderId", "id"],[1,"orderNo"],[2,"orderDate"],[3,"servNo"],[4,"patName"], [5,"relation"], [6,"rank"], [7,"sPersonName"], [8,"age"], [9,"sex"], [10,"unit"], [11,"pType"],[12,"priority"]];
	  	  statusTd = 11;
	</script>
</form>

<script type="text/javascript" language="javascript">
	

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Req. No"
data_header[0][1] = "hide";
data_header[0][2] = "7%";
data_header[0][3] = "orderNo"

data_header[1] = new Array;
data_header[1][0] = "Req. Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "orderDate"

data_header[2] = new Array;
data_header[2][0] = "Service No."
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "servNo";

data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "patName";

data_header[4] = new Array;
data_header[4][0] = "Relation"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "hin";

data_header[5] = new Array;
data_header[5][0] = "Rank"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "hin";


data_header[6] = new Array;
data_header[6][0] = "Name"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "sPersonName";

data_header[7] = new Array;
data_header[7][0] = "Age"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "age";

data_header[8] = new Array;
data_header[8][0] = "Gender"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "sex"

data_header[9] = new Array;
data_header[9][0] = "Unit"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "unit"

data_header[10] = new Array;
data_header[10][0] = "Department"
data_header[10][1] = "data";
data_header[10][2] = "10%";
data_header[10][3] = "pType"


data_header[11] = new Array;
data_header[11][0] = "priority"
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "priority"

data_arr = new Array();
	<%
	    int  counter=0;
		if (patientDetailList != null && patientDetailList.size() > 0)
		{ 
		%>
	
	<% 
		boolean flagForInvToMh = false;
		for(DgOrderhd dgOrderhd: patientDetailList){
			Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
			orderDtSet = dgOrderhd.getDgOrderdts();
			for(DgOrderdt orderdt : orderDtSet){
				if(orderdt.getInvestigationToMH()!=null && orderdt.getInvestigationToMH().equalsIgnoreCase("n")){
					flagForInvToMh = true;
					break;
				}
			}
			String flag = "";
			String status="";
			if(flagForInvToMh){
			Set<DgOrderdt> set = new HashSet<DgOrderdt>();
			set = dgOrderhd.getDgOrderdts();
			//if(deptType.equalsIgnoreCase("DIAG")){ 
			for(DgOrderdt orderDt : set){
				if(orderDt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase(deptType)
						&& orderDt.getMainChargecode().getDepartment().getId().equals(session.getAttribute("deptId"))){
					
					flag = orderDt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode();
					status=orderDt.getOrderStatus();
				}
			}
			if(flag.equalsIgnoreCase(deptType) && status.equalsIgnoreCase("p")){
				
			     	Patient patient = dgOrderhd.getHin();
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= dgOrderhd.getId()%>
					data_arr[<%= counter%>][1] = "<%= dgOrderhd.getOrderNo()%>"
					data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>"
					data_arr[<%= counter%>][3] = "<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>"
                  	data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%> <%=(patient.getPMiddleName()!=null?patient.getPMiddleName():"")%> <%=(patient.getPLastName()!=null?patient.getPLastName():"")%>"
					data_arr[<%= counter%>][5] = "<%=patient.getRelation().getRelationName()%>"
					data_arr[<%= counter%>][6] = "<%=patient.getRank().getRankName()%>"
			 <%   try{
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
						data_arr[<%= counter%>][8] = "<%=patient.getAge()%> "
						data_arr[<%= counter%>][9] = "<%=patient.getSex().getAdministrativeSexName() %> "
						data_arr[<%= counter%>][10] = "<%=patient.getUnit().getUnitName() %> "
						<%
							if(dgOrderhd.getVisit()!=null){
								if(dgOrderhd.getVisit().getReportingFor().equalsIgnoreCase("OPD") || dgOrderhd.getVisit().getReportingFor().equalsIgnoreCase("FollowUp")){
						%>
						data_arr[<%= counter%>][11] = "OPD"
						<%}else if(dgOrderhd.getVisit().getReportingFor().equalsIgnoreCase("Lab") || dgOrderhd.getVisit().getReportingFor().equalsIgnoreCase("Radiology")){%>
						data_arr[<%= counter%>][11] = "Reception"
							<%
						}else{%>
						data_arr[<%= counter%>][11] = "<%=dgOrderhd.getVisit().getReportingFor()%>"
							
						<%}
								}else{%>
							data_arr[<%= counter%>][11] = "Ward";
							<%}%>
					<%
						if(dgOrderhd.getVisit()!=null && dgOrderhd.getVisit().getPriority()!=null){
							
							%>
								data_arr[<%= counter%>][12] ="<%=dgOrderhd.getVisit().getPriority()%>"
									<%
							}else{
									%>
									data_arr[<%= counter%>][12] ="0"
							<%
						}
				
					}catch(Exception e){
						e.printStackTrace();
					}
						     counter++;
					}
		    	//}	
			} 
		}
		}
%>
		<%session.setAttribute("patientDetailList",patientDetailList);%>
    formName = "pendingSampleValidation"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>

<input type="text" class="signPriority1" readonly="readonly">
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly">
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly">
<label class="valueAutoPriority">Priority-3</label>