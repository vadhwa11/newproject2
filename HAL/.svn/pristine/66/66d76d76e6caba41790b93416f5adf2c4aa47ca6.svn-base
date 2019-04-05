<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * enquiryUser.jsp  
 * Purpose of the JSP -  This is for Enquiry for User.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Users"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
    int i=0;
    int min=0;
    int max=4;
    String nextState="enable"; 
    String previousState="disable";
	String loginString="";
	  String statusStr="";
	  String status="";
	Map<String,Object> map = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null)
		map = (Map<String,Object>) request.getAttribute("map");
		
	List enquiryList = new ArrayList();
	if(map.get("enquiryList") != null){
		enquiryList = (List)map.get("enquiryList");}
	if(map.get("previousState")!=null)
		 previousState=(String)map.get("previousState");
	if(map.get("loginString")!=null)
		loginString=(String)map.get("loginString");
	
	 if(map.get("nextState")!=null)
		 nextState=(String)map.get("nextState");
	 if(map.get("min")!=null)
		 min=Integer.parseInt((String)map.get("min"));
	  
	 
	 if(map.get("max")!=null)
		 max=Integer.parseInt((String)map.get("max"));
	 
	 
	 session.setAttribute("min", min+"");
	 session.setAttribute("max", max+"");
	 session.setAttribute("enquiryList",enquiryList);
	 session.setAttribute("loginString",loginString);
    %>
<form name="enquiryUser" method="post" action="">
<div id=contentspace>
<h2 align="left" class="style1">User Master</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">
<legend class="bodytextB">UserHospital - Enquiry </legend> <br />

<br>




<table width="71%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="100%" border="0" align="center" cellpadding="1"
			cellspacing="1" class="tableBorder" height="46">
			<tr>

				<td width="23%" height="20" class="bg_yellow"><b>&nbsp;&nbsp;Login
				Name</b></td>
				<td width="20%" height="20" class="bg_yellow"><strong>&nbsp;&nbsp;&nbsp;User
				Name</strong></td>
				<td width="22%" class="bg_yellow"><strong>&nbsp;&nbsp;Employee
				Code </strong></td>
				<td width="10%" class="bg_yellow"><b><strong>&nbsp;</strong>Status</b></td>
			</tr>
			<tr>
				<% for(Iterator iter = enquiryList.iterator(); iter.hasNext();)
                	   {
           					Users userMaster = (Users) iter.next();
                         
           				 if((min<=i)&&(max>=i)){  
                  %>
				<td class="table_grid" bordercolor="#333333">&nbsp;<%=userMaster.getLoginName() %>
				</td>
				<td bordercolor="#333333" class="table_grid">&nbsp;<%=userMaster.getUserName() %></td>
				<td bordercolor="#333333" class="table_grid">&nbsp;<%=userMaster.getEmployee().getEmployeeCode() %></td>
				<%
                          
                          status=userMaster.getStatus();
                          if((userMaster.getStatus()).equals("y")){
                   			statusStr="Active";
                   		}else{
                   			statusStr="InActive";
                   		}
                          %>
				<td bordercolor="#333333" class="table_grid">&nbsp;<%=statusStr%></td>
			</tr>

			<% }i++;
                	   }
                  
                  %>

		</table>
		</td>
</table>

<br />
<label>&nbsp;</label> <input type="reset" name="next" value="Next"
	class="button"
	onclick="if(nextButtonState('enquiryUser','<%=nextState%>')){submitForm('enquiryUser','/security/security/user?method=next');}" />
<input type="button" name="previous" value="Previous" class="button"
	onclick="if(previousButtonState('enquiryUser','<%=previousState %>')){submitForm('enquiryUser','/security/security/user?method=previous');}" />
<input type="button" name="back22" value="Back" class="button"
	onclick="submitForm('enquiryUser','/security/security/user?method=showUserJsp')" />
</form>
</fieldset>
</div>