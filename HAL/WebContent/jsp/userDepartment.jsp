<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>


<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
function empchange()
{
	/* editRecord(document.getElementById(id),'usergroupHospital'); */
	/* alert(id); */
	if(document.getElementById("userId")!=null)
		{
		document.getElementById("userIdHidden").value=document.getElementById("userId").value;
		return true;
		}
	return false;
	
	
	}
</script> <%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee>  searchUsersList = new ArrayList<MasEmployee>();
	searchUsersList= (ArrayList)map.get("searchUsersList");
	List<MasEmployee> userList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployeeDepartment> searchUserDepartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasDivision> divisionList = new ArrayList<MasDivision>();

	userList = (ArrayList)map.get("userList");
	departmentList = (ArrayList)map.get("departmentList");
	
	divisionList = (ArrayList)map.get("divisionList");
		searchUserDepartmentList = (ArrayList)map.get("searchUserDepartmentList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	

	
	
	
 %> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4><span><%=message %> </span></h4> <%
		}
    %>
<div class="titleBg">
<h2>Employee Department</h2>
</div>
<div class="Clear"></div>
<form name="search" method="post" action="">
<div class="Block">
<label>Employee No.</label> 
<input type="text"	name="userSearch" id="userSearch" value="" /> 

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchUserDepartment');" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchUsersList.size()>0)
   {
   String strForUserName = (String)map.get("userName");
   if(strForUserName!= null && strForUserName!= "" )
   {
 %>
<div class="Clear"></div>
<h4><a href="user?method=showUserDepartmentJsp">Show All Records</a></h4>
<%
		
		  }
	   }
	 if(searchUsersList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showUserDepartmentJsp">Show All Records</a></h4>
<%}%> 
<script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= USER_ID%>"], [2,"<%= DEPARTMENT_ID %>"],[3,"<%=DEPARTMENT_NAME%>"],[4,"<%=STATUS%>"],[5,"divisionId"]];
  statusTd =4;
 </script></div>
<div class="Clear paddingTop15"></div>
<form name="usergroupHospital" method="post" action=""><input
	type="hidden" name="<%=JSP_NAME %>" value="userGroupHospital">
<div class="Block" >
<input type="hidden" id="userIdHidden" name="userIdHidden"/>
<label><span>*</span>  Employee No.</label>
	<select name="<%=USER_ID %>" id="<%=USER_ID %>" validate="Employee no,string,no" onChange="javascript:empchange()" tabindex=1>
		  	<option value="">Select</option>
         <%
          		if(userList != null){ 	
          			for (Iterator iter = userList.iterator(); iter.hasNext();) {
          				MasEmployee users = (MasEmployee) iter.next();
          %>
			<option value="<%=users.getId() %>"><%=users.getServiceNo() %></option>           
         <%		
         			}
         		 } 
         %>
           </select>
           
           <label>Division<span>*</span></label> 
		<select id="divisionId" 	name="divisionId" validate="Division,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('usergroupHospital','/hms/hms/personnel?method=getDepartmentMultiList','departmentDiv');">
			<option value="0">Select</option>

			<%
				         		if(divisionList != null){ 	
				         			for (Iterator iter = divisionList.iterator(); iter.hasNext();) {
				         				MasDivision division = (MasDivision) iter.next();
				         %>
			<option value="<%=division.getId() %>"><%=division.getDivisionName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		
		<div class="Clear"></div>
		
		
		
		<div id="departmentDiv">
		 <label>Department<span>*</span></label>
		
		<select name="<%=DEPARTMENT_ID %>" class="list" multiple size="10"  style= "height: 300px;width:400px;" validate="Department Name,string,yes" tabindex=1>
         <%
          		if(departmentList != null){ 	
          			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
          				MasDepartment masDepartment = (MasDepartment) iter.next();
          %>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>           
         <%		
         		}
         	    } 
         %>
           </select>
		
         <%--   <label> Division  </label> 
<select name="divisionId"	id="divisionId"	 validate="Division,string,no" tabindex=1>
	<option value="0">Select</option>
	<% 
				
				for (MasDivision  masDivision : divisionList){
				%>
	<option value="<%=masDivision.getId ()%>"><%=masDivision.getDivisionName()%></option>

	<%}%>
</select>
           
	<label><span>*</span> Department Name  </label>
	<select name="<%=DEPARTMENT_ID %>" class="list" multiple size="10" validate="Department Name,string,yes" tabindex=1>
         <%
          		if(departmentList != null){ 	
          			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
          				MasDepartment masDepartment = (MasDepartment) iter.next();
          %>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>           
         <%		
         		}
         	    } 
         %>
           </select> --%>
	<div class="Clear"></div></div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('usergroupHospital','user?method=addUserDepartment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('usergroupHospital','user?method=editUserDepartment', 'empchange')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('usergroupHospital','user?method=deleteUserDepartment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="submitFormForButton('usergroupHospital','user?method=showUserDepartmentJsp');" accesskey="r" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('usergroupHospital','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label>
 <label>Changed Time:</label> 
 <label	class="value"><%=time%></label> 
 <input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
 </div>
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee No."
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%= USER_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Department Ids"
data_header[1][1] = "hide";
data_header[1][2] = "0%";
data_header[1][3] = "<%= DEPARTMENT_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Department Name(s)"
data_header[2][1] = "data";
data_header[2][2] = "50%";
data_header[2][3] = "<%=DEPARTMENT_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%=STATUS %>";


data_header[4] = new Array;
data_header[4][0] = "Division"
data_header[4][1] = "hide";
data_header[4][2] = "5%";
data_header[4][3] = "divisionId";



data_arr = new Array();
<%
Iterator itr=searchUsersList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasEmployee  users = (MasEmployee)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= users.getId()%>
data_arr[<%= counter%>][1] = "<%=users.getServiceNo()%>"

<%
 		  StringBuffer dept_ids = new StringBuffer();
		  StringBuffer dept_names = new StringBuffer();
		  String status = "";
		  int temp =0;
    	  for (Iterator iterator = searchUserDepartmentList.iterator(); iterator.hasNext();)
    	  {
    		  MasEmployeeDepartment userDepartment = (MasEmployeeDepartment)iterator.next();
    		  if (users.getId() == userDepartment.getEmployee().getId())
        	  {
    			  status = userDepartment.getStatus();
        		  if (dept_ids.toString().length() > 0)
        		  {
        			  dept_ids.append(",");
        			  dept_ids.append(userDepartment.getDepartment().getId());
        		  }
        		  else
        		  {
        			  dept_ids.append(userDepartment.getDepartment().getId());
        		  }
        		  
        		  if (dept_names.toString().length() > 0)
        		  {
        			  dept_names.append(",");
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(userDepartment.getDepartment().getDepartmentName());
        			  }else{
        			  dept_names.append(userDepartment.getDepartment().getDepartmentName());
        			  }
        		  }
        		  else
        		  {
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(userDepartment.getDepartment().getDepartmentName());
        			  }else{
        			  dept_names.append(userDepartment.getDepartment().getDepartmentName());
        			  }
        		  }

        		  temp++;
        	  }
    		 
	      }
    	  
    %>
data_arr[<%= counter%>][2] = "<%=dept_ids.toString()%>"
<% if(status.equals("y")){ %>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "InActive"
<%}%>

data_arr[<%= counter%>][3] = "<%=dept_names.toString()%>"


<%
	for (Iterator iterator = searchUserDepartmentList.iterator(); iterator.hasNext();)
	  {
		  MasEmployeeDepartment userDepartment = (MasEmployeeDepartment)iterator.next();
		  if (users.getId() == userDepartment.getEmployee().getId())
    	  
  	  {%>
	data_arr[<%= counter%>][5] = "<%=userDepartment.getDivision()!=null?userDepartment.getDivision().getId():""%>"
<%}}%>

<%
		     counter++;
}
%>
 
formName = "usergroupHospital"
	nonEditable = ['<%= USER_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>