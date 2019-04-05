<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>


<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->


function fillId(id){
document.getElementById("userIdNew").value=id
}
</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	
	
	List users = new ArrayList();
	String search = "";
	
	if(map.get("users")!= null)
	{
		users=(List)map.get("users");
	}
	
	if(map.get("search")!= null)
	{
		search=(String)map.get("search");
	}

	
%>
<div class="Clear"></div>
<div class="titleBg">
<h2>Module Management</h2>
</div>
<div class="Clear"></div>
<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4><%=message %> </h4> <%
		}
    %>
<div class="Clear"></div>
<form name="searchBlock" method="post" action="">
<div class="Block">
<label>User Name</label> 
<input type="text"	name="userSearch" id="userSearch" value="" /> 
<label>Login Name</label> 
<input type="text" name="loginSearch" id="loginSearch" value="" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('searchBlock','superAdmin?method=showRecordsForModuleManagement');" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</form>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="Clear"></div>
<form name="moduleManagement" method="post" action="">
<div class="leftMenu">
Security Module
<input name="userIdNew" id="userIdNew" type="hidden"> <!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<input type="button" value="Create SMC" class="button" onClick="submitForm('moduleManagement','user?method=showHospitalJsp');" />
<input type="button" value="Application Group" class="button"	onClick="submitForm('moduleManagement','user?method=showUserGroupsJsp');" />
<%--
<input type="button" value="Employee Group"	class="button"	onClick="submitForm('moduleManagement','user?method=showGroupsJsp');" />
 --%>
<input type="button" value="User Creation"	class="button"	onClick="submitForm('moduleManagement','user?method=showUserJsp');" />
<input type="button" value="Add Forms / Reports"	class="button" onClick="submitForm('moduleManagement','user?method=showApplicationJsp');" />
<input type="button" value="User Management"	class="button"	onClick="submitForm('moduleManagement','superAdmin?method=showUserManagementJsp','validateRadioForSecurity');" />
<input type="button" value="User Group Hospital"	class="button"	onClick="submitForm('moduleManagement','user?method=showUsergroupHospitalJsp');" />
<input type="button" value="User Hospital Maintenance" class="button"	onClick="submitForm('moduleManagement','user?method=showUserHospitalMaintenanceJsp');" />
<input type="button" value="User Department"	class="button"	onClick="submitForm('moduleManagement','user?method=showUserDepartmentJsp');" />
<%--
<input type="button" value="Button Details"	class="button"	onClick="submitForm('moduleManagement','user?method=showButtonMasterJsp');" />
<input type="button" value="Remove Button Rights"		class="button"	onClick="submitForm('moduleManagement','superAdmin?method=showRemoveButtonRights','validateRadioForSecurity');" />
<input type="button" value="View/Remove User Rights"	class="button"	onClick="submitForm('moduleManagement','superAdmin?method=viewUserRightsJsp','validateRadioForSecurity');" />
<input type="button" value="Change Order" class="button"	onClick="submitForm('moduleManagement','superAdmin?method=showOrderApplicationJsp');" /><br />
<a href="/hms/photo/Firefox Setup 9.0.1.exe" target="_blank" class="mozilla">
FireFox</a>
 --%>

</div>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="small"></div>

<% try{
		  if(map.get("search")!=null && map.get("search").equals("YES"))
		  {
			 %> <h4><a href="superAdmin?method=showModuleManagementJsp">Show All
Records</a></h4> <%
		     }
	   }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
    %> <script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.USER_ID%>", "id"],[1, "<%= RequestConstants.USER_NAME%>"], [2,"<%= RequestConstants.LOGIN_NAME%>"], [3,"<%= RequestConstants.EMP_STATUS_CODE %>"] ];
	 statusTd =3;

</script></div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>
<div class="Clear"></div>
</form>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.USER_ID%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "User Name"
		data_header[1][1] = "data";
		data_header[1][2] = "10%";
		data_header[1][3] = "<%= RequestConstants.USER_NAME%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Login Name"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.LOGIN_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Employee Code"
		data_header[3][1] = "data";
		data_header[3][2] = "10%";
		data_header[3][3] = "<%= RequestConstants.EMP_STATUS_CODE %>";
		
		data_arr = new Array();
		
		<%
			
			Iterator iterator=users.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {   
		        	  
		        	  Users userObj= (Users) iterator.next();
		        	  if(userObj.getStatus().equalsIgnoreCase("y") )
		        	  {
		        	  	String userName=userObj.getUserName();
		        	  	String loginName=userObj.getLoginName();
		        	  	MasEmployee empObj=(MasEmployee)userObj.getEmployee();
		        	  	String empCode=empObj.getEmployeeCode();
		        	  
		        //	  	System.out.println("userObj.getid()--- "+userObj.getId());
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=userObj.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="userId" value="<%= userObj.getId()%>" id="parent" onclick="fillId(this.value)" />'
			
			<%
				if(userName != null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=userName%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(loginName != null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=loginName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(empCode != null)
			   {
			%>
			data_arr[<%= i%>][4] = "<%=empCode%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
		<%}%>
		
		
		 
		<% 	
			i++;
			}
		  }
		%>
		 
		formName = "moduleManagement"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="hidden" name="counter" id="counter" value="<%=i %>" />

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>



