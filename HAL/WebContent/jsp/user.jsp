
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * users.jsp  
	 * Purpose of the JSP -  This is for All Userss.
	 * @author  Mansi
	 * Create Date: 6 June,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5
	--%>

<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.EmpGroups"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchUserList = (ArrayList)map.get("searchUserList");
	List<UserUsergroupHospital> userGroupHospList = new ArrayList<UserUsergroupHospital>();
 //   List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
	List<Object[]> groupList = new ArrayList<Object[]>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
	employeeList = (ArrayList)map.get("employeeList");
	//System.out.println("this is employee list of smc"+employeeList.size());
	}
	if(map.get("groupList") != null){
	groupList=(List<Object[]>)map.get("groupList");
	}
	
	if(map.get("useruserGroupHospList") != null){
	userGroupHospList=(ArrayList)map.get("useruserGroupHospList");
	}
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	if(map.get("masTemplateList")!=null){
		masTemplateList =(List) map.get("masTemplateList");
	}
	
	List<Users> userList = new ArrayList<Users>();
	if(map.get("userList") != null){
	userList = (ArrayList)map.get("userList");
	}
	List empGroupList= new ArrayList();
	if(map.get("empGroupList") != null){
		empGroupList = (ArrayList)map.get("empGroupList");
		}
	List userEmpGroupList= new ArrayList();
	if(map.get("userEmpGroupList") != null){
		userEmpGroupList = (ArrayList)map.get("userEmpGroupList");
		}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	%> <%
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		    	   %> <h4><span><%=message %></span></h4> <% 
		  }

	%> <script type="text/javascript">
	 function openPopupWindowForappGroup()
  {
    var url="/hms/hms/user?method=AppGroupDetails";
    newwindow=window.open(url,'name',"left=100,top=100,height=250,width=400,status=1,scrollbars=1,resizable=0");
  }
	</script>

<div class="titleBg">
<h2>User</h2>
</div>
<div class="clear"></div>
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Login Name </label> 
<input type="text" id="searchField" name="<%= LOGIN_NAME%>" value="" validate="Login Name,string,no" MAXLENGTH="20" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchUser')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','user?method=searchUser','checkSearch')"
	tabindex=1 />
	</div>
</form>
<div class="Clear"></div>
</div>
</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
			if(searchUserList.size()>0)
			 {
				String strForCode = (String)map.get("loginName");
				
				if(strForCode!= null && strForCode!= "" )
				{
		%>


<h4><a href="user?method=showUserJsp">Show All Records</a></h4>
<%
				}
			 }
		 if(searchUserList.size()==0 && map.get("search") != null)
		  {
		 %>
<h4><a href="user?method=showUserJsp">Show All Records</a></h4>

<%
	     }
		%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= LOGIN_NAME%>"], [2,"<%= SEARCH_NAME %>"], [3,"serviceNo"], [4,"<%= PASSWORD %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%= EMPLOYEE_ID%>"],[9,"employeeName"],[10,"lastName"],[11,"<%=STATUS%>"] ];
		 statusTd = 11;
		</script></div>
<div class="clear"></div>
<form name="users" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="Users"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="UserName"> 
<input type="hidden" name="title" value="Users"> 
<input type="hidden" name="<%=JSP_NAME %>" value="user"> 
<input type="hidden" name="pojoPropertyCode" value="LoginName">


<div class="Block">

<label>Employee No. <span>*</span></label> 
<input type="text" name="serviceNo" id="serviceNo" validate="Employee No.,string,yes" MAXLENGTH="30" tabindex=1 onblur="populateEmpName(this.value)" />
 
<label> First Name <span>*</span></label> 
<input type="text" name="employeeName" id="employeeName" validate="First name,string,yes" readonly  readonly/> 
<input type="hidden" name="employeeId" id="employeeId" readonly /> 

	<label>Last Name </label> 
<input type="text" name="lastName"  id="lastName" validate="Last name,string,no" readonly /> 

	
				 
<div class="clear"></div>

<label> User Name<span>*</span> </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" 	id="codeId" validate="User name,string,yes" MAXLENGTH="30" tabindex=1 readonly /> 


<%-- <label> Login Name <span>*</span> </label> 
<input id="codeId" type="text" name="<%= LOGIN_NAME%>" value=""	validate="Login Name,string,yes" MAXLENGTH="12" tabindex=1 /> 
	 --%>
	<script>
					document.users.serviceNo.focus();
	</script>
					
<label> Password  <span>*</span></label> 
<input id="pwd" name=<%=PASSWORD%>  type="password" maxlength="15" tabindex="1" validate="Password,string,yes" /> 


<h4>
Profiles
</h4>
<div id="testDiv">

<%
	int counterMenu=0;
		if(masTemplateList.size()>0){
		for(MasTemplate masTemplate :masTemplateList){
			++counterMenu;
	%>
	<label class=""><%=masTemplate.getTemplateName()%>
	</label>
	<input type="checkbox" class="radioAuto" name="templetId<%=counterMenu%>" id="templetId<%=counterMenu%>" value="<%=masTemplate.getId()%>" />
	<%
	if(counterMenu%5==0){
		%>
		<div class="clear" style="padding-top:8px"></div>
		<%
	}
	}
	}
	
	%> 
	<input type="hidden" name="counterMenu" id="counterMenu" value="<%=counterMenu%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
	<div class="clear"></div>
</div>
<div class="clear"></div>
</div>

<div id="edited"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('users','user?method=addUser');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('users','user?method=editUser')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button"	onClick="submitForm('users','user?method=deleteUser&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('users','user?method=showUserJsp')" accesskey="r" />
<input type="button" name="Back" value="Back" class="button"	accesskey="b"	onclick="submitFormForButton('users','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <!-- <input type="reset" name ="Encryptpassword" id="" value ="Encryptpassword" class="button" onclick="submitForm('users','user?method=encryptAllUserPassword')" accesskey="r" /> -->
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label class="value"><%=time%></label> 
	 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			 
			 
</div>
<div class="clear"></div>

</form>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Login Name"
	data_header[0][1] = "hide";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= LOGIN_NAME%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "User Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Employee No."
	data_header[2][1] = "data";
	data_header[2][2] = "25%";
	data_header[2][3] = "serviceNo"
	
	data_header[3] = new Array;
	data_header[3][0] = "Password"
	data_header[3][1] = "hide";
	data_header[3][2] = "40%";
	data_header[3][3] = "<%= PASSWORD %>";
	
	

	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%= CHANGED_BY%>"
	
	data_header[5] = new Array;
	data_header[5][0] = ""
	data_header[5][1] = "hide";
	data_header[5][2] = 0;
	data_header[5][3] = "<%= CHANGED_DATE%>"
	
	data_header[6] = new Array;
	data_header[6][0] = ""
	data_header[6][1] = "hide";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%=CHANGED_TIME %>";
	

	
	
	
	data_header[7] = new Array;
	data_header[7][0] = "Employee Id"
	data_header[7][1] = "hide";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%=EMPLOYEE_ID%>";
	
	data_header[8] = new Array;
	data_header[8][0] = "Employee Name"
	data_header[8][1] = "data";
	data_header[8][2] = "15%";
	data_header[8][3] = "employeeName";
	
	
	data_header[9] = new Array;
	data_header[9][0] = "Last Name"
	data_header[9][1] = "hide";
	data_header[9][2] = "15%";
	data_header[9][3] = "lastName";
	
	
	data_header[10] = new Array;
	data_header[10][0] = "Status"
	data_header[10][1] = "data";
	data_header[10][2] = "15%";
	data_header[10][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	<%
	Iterator itr=searchUserList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	        	  Users  users = (Users)itr.next(); 
	
		%>
		
		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= users.getId()%>
		data_arr[<%= counter%>][1] = "<%=users.getLoginName()%>"
		data_arr[<%= counter%>][2] = "<%= users.getUserName()%>"
		data_arr[<%= counter%>][3] = "<%= users.getEmployee().getServiceNo()%>"
		
		<%-- <%
		
	Iterator itrEmployeeList=employeeList.iterator();
	while(itrEmployeeList.hasNext())
	      {
	       MasEmployee  masEmployeeGrid = (MasEmployee)itrEmployeeList.next(); 
		 if(users.getEmployee().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masEmployeeGrid.getServiceNo()%>"
		<%}else if(users.getEmployee().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masEmployeeGrid.getServiceNo()%>";
		<%}
	}%> --%>
	data_arr[<%= counter%>][4] = "<%= users.getPassword()%>"
	
	
	data_arr[<%= counter%>][5] = "<%= users.getLastChgBy() %>"
	data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(users.getLastChgDate()) %>"
	data_arr[<%= counter%>][7] = "<%= users.getLastChgTime() %>"
	<% if(users.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][11] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][11] = "InActive"
	<%}%>
	
	data_arr[<%= counter%>][8] = "<%= users.getEmployee().getId() %>"
	<%
	  String empName="";
	  if(users.getFirstName()!= null)
		  empName=users.getFirstName();
	%>
	data_arr[<%= counter%>][9] = "<%= empName %>"
	
	<%
		  String lastName="";
	  if(users.getLastName()!=null)
		  lastName=users.getLastName();
	%>
	data_arr[<%= counter%>][10] = "<%= lastName %>"
	<%
	  counter++;
	}
	%>
	formName = "users"
	
	//nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
