<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	
		Map map = new HashMap();
		List<Object> groupList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List<UserDepartment> userDepartmentList = new ArrayList<UserDepartment>();
		if (map.get("userDepartmentList") != null){
			userDepartmentList =(List<UserDepartment>)map.get("userDepartmentList");
		}
		List<Users> userList=new ArrayList<Users>();
		if (map.get("userList") != null){
			userList =(List<Users>)map.get("userList");
			
			if(userList.size()>0 && userList.size()== 1){
			if(userDepartmentList.size() > 0){
			
		
		
%>
<!-- <form name="ajaxGroupHospitalList" method="post" action="#">-->
<label>Employee Name :</label>
<%
		  String empName="";
		  int userId=0;
		  Users user=(Users)userList.get(0);
		  if(user.getEmployee()!= null){
			  userId=user.getId();
			  if(user.getEmployee().getFirstName()!= null)
				  empName=user.getEmployee().getFirstName();
			  if(user.getEmployee().getMiddleName()!= null)
				  empName=empName+" "+user.getEmployee().getMiddleName();
			  if(user.getEmployee().getLastName()!=  null)
				  empName=empName+" "+user.getEmployee().getLastName();
		  }
		%>
<label class="value"><%=empName %></label>
<input type="hidden" name="userId" value="<%=userId %>" />
<div class="Clear"></div>
<label>Old Password:</label>
<input type="password" value="" id="oldPwd" name="oldPwd" />

<label>New Password:</label>
<input type="password" value="" id="newPwd" name="newPwd" />


<label>Confirm Password:</label>
<input type="password" value="" id="conPwd" name="conPwd" />
</div>
</div>
<div class="Clear"></div><!--

<input type="button" name="change"
	onClick="if(displayData()){submitForm('changePassword','superAdmin?method=showChangePassword&action=update');}"
	value="Submit" class="button">
<%if(userName.equals("admin")){%>
<input type="button" name="change"
	onClick="if(resetpassword()){submitForm('changePassword','superAdmin?method=showChangePassword&action=reset');}"
	value="Password Reset" class="buttonbig">
<%}%>


--><%}
			else if(userDepartmentList.size() == 0){
				%>
				<label class="auto"><span>User is inactive.</span></label>
			<%}
			}
			else if(userList.size()>1){ %>


<label class="auto"><span>Multiple Records are found
with this Login Name</span></label>

<%}else{%>
<label class="auto"><span>No Records are found with
this Login Name</span></label>
<% }
			
			}%>




