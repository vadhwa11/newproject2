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

<%@page import="jkt.hms.masters.business.HrLeaveMaintenance"%>
<%@page import="jkt.hms.util.HMSUtil"%><link rel="stylesheet"
	type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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
<h6>Leave Application Pending For Recommenation Employee List</h6>
<div class="Clear"></div>
<form name="leavePendingSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication>employeeList=new ArrayList<HrorderlyLeaveApplication>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("employeeMap") != null){
			employeeMap= (Map<String, Object>)map.get("employeeMap");
		}
		if(employeeMap.get("employeeList") != null){
			employeeList= (List<HrorderlyLeaveApplication>)employeeMap.get("employeeList");
			System.out.println("employeeList---"+employeeList.size());
		}
	
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		 }
	%>
</form>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="leavePending" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>"], [1,"applicationDate"],[2,"servNo"], [3,"firstName"], [4,"rank"]];
	 statusTd = 4;
	</script></form>
</div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	

	data_header[0] = new Array;
	data_header[0][0] = "Application Date"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "applicationDate"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"
	
	data_header[2] = new Array;
	data_header[2][0] = "Employee"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "firstName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Rank"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "rank";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (employeeList != null && employeeList.size() > 0) { %>
	
	<% 	for(HrorderlyLeaveApplication hrLeaveMaintenance : employeeList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%= hrLeaveMaintenance.getId()%>"
			<%if(hrLeaveMaintenance.getApplicationDate()!=null){%>
			data_arr[<%= counter%>][1] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLeaveMaintenance.getApplicationDate())%>"
			<%}else{%>
			data_arr[<%= counter%>][1] = "NF"
			<%}%>
			data_arr[<%= counter%>][2] = "<%=hrLeaveMaintenance.getEmployee().getServiceNo()%>"
			data_arr[<%= counter%>][3] = "<%=hrLeaveMaintenance.getEmployee().getFirstName()%>"
			data_arr[<%= counter%>][4] = "<%=hrLeaveMaintenance.getEmployee().getRank().getRankName()%> "
		<%
				     counter++;
		    	}
			}
		%>
		
    formName = "leavePending"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>



