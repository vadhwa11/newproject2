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


<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<%@page import="jkt.hms.masters.business.GroupApplication"%>
<%@page import="jkt.hms.masters.business.UserUsergroupApplication"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.EmpGroups"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
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



<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%
	
		Map map = new HashMap();
		List<Object> groupList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String groupName="";
		if (map.get("groupName") != null){
			groupName =(String)map.get("groupName");
		}
		int empGroupId=0;
		if (map.get("empGroupId") != null){
			empGroupId =(Integer)map.get("empGroupId");
		}
	   List userUGAppList= new ArrayList();
		
		if (map.get("userUGAppList") != null){
			userUGAppList =(List)map.get("userUGAppList");
		}
		List usersList= new ArrayList();
		if (map.get("usersList") != null){
			usersList =(List)map.get("usersList");
		}
		int hospitalId=0;
		if (map.get("hospitalId") != null){
			hospitalId =(Integer)map.get("hospitalId");
		} 
		List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
		String value="";
		if (map.get("value") != null)
			value =(String)map.get("value");
		if(value.equals("true")){
		if (map.get("userEmpGroupList") != null)
			userEmpGroupList =(List<UserEmpGroup>)map.get("userEmpGroupList");
		}			
%>


<!-- <form name="groupList" method="post" action="#"> -->

<div class="Clear"></div>

<div class="tableHholderCmnLarge2">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Login Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAll();" /> Select Users</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
			  
			   int k=0;
				if(userEmpGroupList!= null && userEmpGroupList.size()>0){
					for(Iterator iterr=usersList.iterator();iterr.hasNext();){
						UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)iterr.next();
						for(Iterator iteratorr=userEmpGroupList.iterator();iteratorr.hasNext();){
							UserEmpGroup userEmpGroup=(UserEmpGroup)iteratorr.next();
						//	System.out.println("login name in user emp group list and userusergroup list====="+userEmpGroup.getUser().getLoginName()+"----userUsergroupHospital---"+userUsergroupHospital.getUser().getLoginName());
						
							String boolVal="false";
							if(userEmpGroup.getUser().getId()==userUsergroupHospital.getUser().getId()){
								k++;
								Inner:	for(Iterator ite=userUGAppList.iterator();ite.hasNext();){
									UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)ite.next();
									if(userUsergroupApplication.getUser().getId()==userUsergroupHospital.getUser().getId()){
									//	System.out.println("userid in application list jsp -------"+userUsergroupApplication.getUser().getLoginName()+"---user id---"+userUsergroupApplication.getUser().getId());
										boolVal="true";
										break Inner;
									}
								}
				if(boolVal.equals("true")){
					//System.out.println("value of boolVal is true");			
			%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userUsergroupHospital.getUser().getId()%>"
				class='checkbox' checked /></td>
		</tr>
		<%}else{
			//	System.out.println("value of boolVal is false");
			%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userUsergroupHospital.getUser().getId()%>"
				class='checkbox' /></td>
		</tr>

		<%}
				break;}
				}}}else if(map.get("value").equals("false")){
			
           		Iterator itr =usersList.iterator();
           		UserUsergroupHospital userUsergroupHospital = null;
           		
   				while (itr.hasNext()) 
   				{
   					k++;
   					String bool="false";
   					userUsergroupHospital = (UserUsergroupHospital) itr.next();
					for(Iterator it=userUGAppList.iterator();it.hasNext();){
						UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)it.next();
						if(userUsergroupApplication.getUser().getId()==userUsergroupHospital.getUser().getId()){
							bool="true";
							break;
						}
					}
					if(bool.equals("true")){
						
	         %>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userUsergroupHospital.getUser().getId()%>"
				class='checkbox' checked /></td>
		</tr>
		<%}else{ %>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userUsergroupHospital.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userUsergroupHospital.getUser().getId()%>"
				class='checkbox' /></td>
		</tr>

		<%}}} %>




	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="hidden" name="empGroupId" value="<%=empGroupId %>" />
<input type="hidden" id="countVal" value="<%=k%>" />
<input type="hidden" id="chkStatus" value="no" />
<label class="small">&nbsp;</label>
<input type="button" name="assignApplication" value="Assign Application"
	class="buttonbig"
	onClick="submitForm('assignApplicationForm','superAdmin?method=addUserWiseApplication')" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('assignApplicationForm','superAdmin?method=showAssignApplicationToUsers')"
	tabindex=1 />
<div class="Clear"></div>
<!-- </form> -->





