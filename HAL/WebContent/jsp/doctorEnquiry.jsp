<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * doctorEnquiry.jsp  
 * Purpose of the JSP -  This is for doctor Enquiry.
 * @author  Ritu  
 * Create Date: 12th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">


<div class="blockTitle">Doctor Enquiry</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<form name="doctorEnquirySearch" method="post" action="">
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<Object> doctorList = new ArrayList<Object>();
	List<MasDepartment> wardList = new ArrayList<MasDepartment>();
	
	if(map.get("doctorList") != null){
		doctorList = (List<Object>)map.get("doctorList");
	}
	if(map.get("wardList") != null){
		wardList = (List<MasDepartment>)map.get("wardList");
	}
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	
	%>
<div class="blockFrame"><label class="bodytextB_blue">Department:</label>
<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" class="select_adt">
	<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : wardList){
				%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
			} %>
</select> <label class="bodytextB_blue">Doctor Name:</label> <input type="text"
	name="<%=DOCTOR_NAME%>" value="" MAXLENGTH="30" tabindex=1
	class="textbox_size20" /><label></label>

<div class="Clear"></div>
</div>
<input type="button" name="Search" value="Search" class="button"
	onclick="submitForm('doctorEnquirySearch','/hms/hms/enquiry?method=searchDoctorForEnquiry');"
	tabindex=1 /></form>

<%
		if(doctorList.size() > 0){
	%> <jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="doctorEnuiry" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= EMPLOYEE_ID%>", "id"], [1,"<%= EMPLOYEE_CODE%>"], [2,"<%= DOCTOR_NAME%>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= SERVICE_NO%>"], [5,"<%= RANK_ID%>"]];
	 statusTd = 5;
	</script>
</div>


<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Employee Code"
	data_header[0][1] = "data";
	data_header[0][2] = "2%";
	data_header[0][3] = "<%= EMPLOYEE_CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Doctor Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "<%= DOCTOR_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Department"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "<%= DEPARTMENT_ID%>";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service No."
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "<%= SERVICE_NO%>"
	
	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "<%= RANK_ID %>";
	
		
	data_arr = new Array();
	<%
		
	    int  counter=0;
		for (Iterator iterator = doctorList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			MasEmployee employee = (MasEmployee)object[0];
			MasDepartment masDepartment = (MasDepartment)object[1];
			if(employee.getEmpCategory() != null){
			if(employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= employee.getId()%>
		<%
			if(employee.getEmployeeCode() != null){
		%>
			data_arr[<%= counter%>][1] = "<%=employee.getEmployeeCode()%>"
		<%}%>
		<%
			if(employee.getFirstName() != null){
		%>
			data_arr[<%= counter%>][2] = "<%=employee.getFirstName()%> <%=employee.getLastName()%>"
			<%}%>
		<%
			if(employee.getDepartment() != null){
		%>	
			data_arr[<%= counter%>][3] = "<%=masDepartment.getDepartmentName()%> "
		<%}%>
		<%
			if(employee.getServiceNo() != null){
		%>
			data_arr[<%= counter%>][4] = "<%= employee.getServiceNo()%>"
		<%}%>
		<%
			if(employee.getRank() != null){
		%>
			data_arr[<%= counter%>][5] = "<%= employee.getRank().getRankName()%>"
		<%	}
			counter++;
	    	}
		 }
	    }
	%>
	
    formName = "doctorEnuiry"
	nonEditable = ['<%=EMPLOYEE_ID%>'];
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
	
	</script> <%}
	%>
</form>
</div>