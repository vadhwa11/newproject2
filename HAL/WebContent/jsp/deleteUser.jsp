<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * deleteUser.jsp  
 * Purpose of the JSP -  This is for Deleting User.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.Users"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<%
		Map map = new HashMap();
		
		List deleteList=new ArrayList();
		if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
		if(map.get("deleteList")!=null)
		
			deleteList=(List)map.get("deleteList");
		
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	%>
<div id=contentspace>
<h2 align="left" class="style1">User Master</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">

<legend class="bodytextB">User Master - Delete </legend> <br>


<form name="deleteUser" method="post"
	action="/security/security/login?method=insertData"><label
	class="bodytextB_blue"><font id="error">*</font>Login Name</label> <select
	name=<%=RequestConstants.LOGIN_NAME%>
	id=<%=RequestConstants.LOGIN_NAME%> class="combo-item"
	onChange="fetchUserValue2(this,'deleteUser')"
	validate='Login Name,alphaspace,yes'>

	<option value="0">--Select--</option>
	<% int id=0;
                      String loginNameTemp=null;
                      String userNameTemp=null;
                      String empCodeTemp=null;
                      String pwdTemp=null;
                      String statusTemp;
                      String changeBy = null;
      	           	  Date changeDate ;
      	              String  changeTime =null;
        	            Users usersObj=new Users();
      	              if(deleteList.size() != 0 && deleteList != null)  
                    	  
      	            	  for (int i =0;i< deleteList.size(); i++)
      	  			  {
      	            		usersObj = (Users)deleteList.get(i);
        
          					if(deleteList.size() != 0 && deleteList != null){
          						   loginNameTemp=usersObj.getLoginName();
          						 	id=usersObj.getId();
          	                       userNameTemp=usersObj.getUserName();
          	                       empCodeTemp=usersObj.getEmployeeCode();
          	                       pwdTemp=usersObj.getPassword();
          	                       statusTemp=usersObj.getStatus();
          	                       changeBy = usersObj.getLastChgBy();
          	      	           	   changeDate=usersObj.getLastChgDate() ;
          	      	               changeTime =usersObj.getLastChgTime();
          				
          							%>
	<script>
								userArray2[<%=i%>]= new Array();
								userArray2[<%=i%>][0] = "<%=loginNameTemp%>";
								userArray2[<%=i%>][1] = "<%=userNameTemp%>";
								userArray2[<%=i%>][2] = "<%=empCodeTemp%>";
								userArray2[<%=i%>][3] = "<%=pwdTemp%>";
								userArray2[<%=i%>][4] = "<%=statusTemp%>";
								userArray2[<%=i%>][5] = "<%=changeBy%>";
								userArray2[<%=i%>][6] = "<%=changeDate%>";
								userArray2[<%=i%>][7] = "<%=changeTime%>";
								userArray2[<%=i%>][8] = "<%=id%>";
				
								</script>
	<option value="<%=usersObj.getLoginName()%>"><%=usersObj.getLoginName()%></option>
	<%}} %>

</select> <br />
<br />
<label class="bodytextB_blue"><font id="error">*</font>User Name</label>
<input name=<%=RequestConstants.USER_NAME %> type="text"
	class="textbox_size20_disb" readonly="readonly" /> <br />
<br />
<label class="bodytextB_blue"><font id="error">*</font>Employee
Code</label> <input name=<%=RequestConstants.EMPLOYEE_CODE %> type="text"
	class="textbox_size20_disb" readonly="readonly" /> <br />
<br />
<label class="bodytextB_blue"><font id="error">*</font>User
Password</label> <input name=<%=RequestConstants.PASSWORD %> type="password"
	class="textbox_size20_disb" readonly="readonly" /> <br />
<br />
<label class="bodytextB_blue">Status :</label> <input
	name=<%=RequestConstants.STATUS%> type="radio" class="radiobutton"
	value="y" checked="checked" tabindex="1" /> <font
	class="bodytextB_blue">Active</font> <input
	name=<%=RequestConstants.STATUS%> type="radio" class="radiobutton"
	value="n" tabindex="1" /> <font class="bodytextB_blue">Inactive</font>

<br />
<br />

<% 
                	HMSUtil hMSUtil=new HMSUtil();
                	Map dateMap=new HashMap();
                	 dateMap=(Map)hMSUtil.getCurrentDateAndTime();
                	 String  lastChgDate=(String)dateMap.get("currentDate");
                	 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy/MM/dd");
        			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
        			lastChgDate=formatterOut.format(formatterIn.parse(lastChgDate));
					String lastChgTime=(String)dateMap.get("currentTime");
					lastChgTime=lastChgTime.substring(0,5);
                %> <input name="changed_date_hidden" type="hidden"
	value="<%=lastChgDate %>" /> <input name="changed_time_hidden"
	type="hidden" value="<%= lastChgTime%>" /> <input name="userId"
	type="hidden" /> <label class="bodytextB_blue">Changed By:</label> <input
	type="text" name="<%= RequestConstants.CHANGED_BY%>"
	value="<%=userName%>" class="textbox_size20" readonly="readonly"
	MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue"> Changed Date:</label> <input type="text"
	name="<%=RequestConstants.CHANGED_DATE %>" value="<%=lastChgDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <label
	class="bodytextB_blue">Changed Time:</label> <input type="text"
	name="<%=RequestConstants.CHANGED_TIME %>" value="<%=lastChgTime%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <br />


<input name=<%=RequestConstants.CHANGED_BY%> type="hidden"
	class="textbox_size20_disb" readonly="readonly" value="<%=userName %>" />
<input name=<%=RequestConstants.CHANGED_DATE%> type="hidden"
	class="textbox_size20_disb" readonly="readonly"
	value="<%=lastChgDate%>" /> <input
	name=<%=RequestConstants.CHANGED_TIME%> type="hidden"
	class="textbox_size20_disb" readonly="readonly"
	value="<%=lastChgTime%>" /> <br />
<br />
<label>&nbsp;</label> <input type="reset" name="delete" value="Delete"
	class="button"
	onclick="if(checkDelete()){submitForm('deleteUser','/security/security/user?method=deleteUser')}" />


<input type="button" name="back2" value="Back" class="button"
	onclick="javascript:history.back()" /> <br />
<br />
</form>
</fieldset>
</div>
