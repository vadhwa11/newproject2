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
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee;"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<h6>Update Arrival Search</h6>
<div class="Clear"></div>
<form name="updateArrivalSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmployee>employeeList=new ArrayList<MasEmployee>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("employeeMap") != null){
			employeeMap= (Map<String, Object>)map.get("employeeMap");
		}
		if(employeeMap.get("rankList") != null){
			rankList= (List<MasRank>)employeeMap.get("rankList");
		}
		else if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(employeeMap.get("employeeList") != null){
			employeeList= (List<MasEmployee>)employeeMap.get("employeeList");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		 }
	%>


<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame"><label class="common">Service No.</label>
<input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="30" /> <label
	class="noWidth">Rank</label> <select name="<%=RANK_ID %>">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select> <label class="noWidth">First Name</label> <input type="text"
	name="<%=FIRST_NAME %>" id="firstName" validate="First Name,string,no"
	value="" MAXLENGTH=8 tabindex=1 /> <label class="noWidth">Last
Name</label> <input type="text" name="<%=LAST_NAME %>" id="lastName"
	validate="Last Name,string,no" value="" MAXLENGTH=8 tabIndex=1 /></div>
<div class="Clear"></div>

</form>
<input type="button" name="Search"
	onclick="submitForm('updateArrivalSearch','hrRelated?method=searchEmployeeForUpdateArrival');"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="updateArrival" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"empId"], [3,"firstName"], [4,"rank"]];
	 statusTd = 4;
	</script></form>
</div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Employee ID"
	data_header[1][1] = "hide";
	data_header[1][2] = "15%";
	data_header[1][3] = "empId";
	
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
	
	<% 	for(MasEmployee masEmployee : employeeList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masEmployee.getId()%>
			data_arr[<%= counter%>][1] = "<%=masEmployee.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=masEmployee.getId()%>"
			data_arr[<%= counter%>][3] = "<%=masEmployee.getFirstName()%>"
			data_arr[<%= counter%>][4] = "<%=masEmployee.getRank().getRankName()%> "
		<%
				     counter++;
		    	}
			}
		%>
		
    formName = "updateArrival"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>
