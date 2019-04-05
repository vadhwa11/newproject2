<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateUser.jsp  
 * Purpose of the JSP -  This is for Updating User.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" language="javascript"
	src="/security/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/hms.js"></script>
<%
	Map map = new HashMap();
	String loginNameString = null;
	List updateList = new ArrayList();
	List employeeList = new ArrayList();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		if (map.get("updateList") != null)
			updateList = (List) map.get("updateList");

	}
	if (map.get("employeeList") != null)
		employeeList = (List) map.get("employeeList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
<div id=contentspace>
<h2 align="left" class="style1">User Master</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">

<legend class="bodytextB">User Master - Update </legend> <br>


<form name="updateUser" method="post"
	action="/security/security/login?method=insertData"><label
	class="bodytextB_blue"><font id="error">*</font>Login Name</label> <select
	name=<%=RequestConstants.LOGIN_NAME%>
	id=<%=RequestConstants.LOGIN_NAME%> class="combo-item"
	validate='Login Name,alphaspace,yes'
	onChange="fetchUserValue(this,'updateUser')">

	<option value="0">--Select--</option>
	<%
		int id = 0;
		String loginNameTemp = null;
		String userNameTemp = null;
		String empCodeTemp = null;
		String pwdTemp = null;
		String statusTemp;
		String changeBy = null;
		Date changeDate;
		String changeTime = null;
		Users usersObj = new Users();
		if (updateList.size() != 0 && updateList != null)

			for (int i = 0; i < updateList.size(); i++) {
				usersObj = (Users) updateList.get(i);

				if (updateList.size() != 0 && updateList != null) {
			id = usersObj.getId();
			loginNameTemp = usersObj.getLoginName();

			userNameTemp = usersObj.getUserName();
			empCodeTemp = usersObj.getEmployee().getEmployeeCode();
			pwdTemp = usersObj.getPassword();
			statusTemp = usersObj.getStatus();
			changeBy = usersObj.getLastChgBy();
			changeDate = usersObj.getLastChgDate();
			changeTime = usersObj.getLastChgTime();
	%>
	<script>
								userArray[<%=i%>]= new Array();
								userArray[<%=i%>][0] = "<%=loginNameTemp%>";
								userArray[<%=i%>][1] = "<%=userNameTemp%>";
								userArray[<%=i%>][2] = "<%=empCodeTemp%>";
								userArray[<%=i%>][3] = "<%=pwdTemp%>";
								userArray[<%=i%>][4] = "<%=statusTemp%>";
								userArray[<%=i%>][5] = "<%=changeBy%>";
								userArray[<%=i%>][6] = "<%=changeDate%>";
								userArray[<%=i%>][7] = "<%=changeTime%>";
								userArray[<%=i%>][8] = "<%=id%>";
								</script>
	<option value="<%=usersObj.getLoginName()%>"><%=usersObj.getLoginName()%></option>

	<%
			}
			}
	%>

</select> <input name="userId" type="hidden"> <br />
<br />
<label class="bodytextB_blue"> <font id="error">*</font>User
Name</label> <input name=<%=RequestConstants.USER_NAME %> type="text"
	class="textbox_size20" maxlength="30" /> <br />
<br />
<label class="bodytextB_blue"><font id="error">*</font>Employee
Code</label> <select name=<%=RequestConstants.EMPLOYEE_CODE %>>
	<option value="0">--Select--</option>
	<%
				for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
					MasEmployee employeeMasterObj = (MasEmployee) iter.next();

				if (employeeList.size() != 0 && employeeList != null) {
					String employeeCode = (String) employeeMasterObj
					.getEmployeeCode();
		%>
	<option value="<%=employeeCode%>"><%=employeeCode%></option>
	<%
			}
			}
		%>
</select> <br />
<br />
<label class="bodytextB_blue"><font id="error">*</font>User
Password</label> <input name=<%=RequestConstants.PASSWORD %> type="password"
	class="textbox_size20_disb" readonly="readonly"> <br />
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
		HMSUtil hMSUtil = new HMSUtil();
		Map dateMap = new HashMap();
		dateMap = (Map) hMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) dateMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
		lastChgDate = formatterOut.format(formatterIn.parse(lastChgDate));

		String lastChgTime = (String) dateMap.get("currentTime");
		lastChgTime = lastChgTime.substring(0, 5);
	%> <label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= RequestConstants.CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />

<label id=biglabel class="bodytextB_blue"> Changed Date:</label> <input
	type="text" name="<%=RequestConstants.CHANGED_DATE %>"
	value="<%=lastChgDate%>" class="textbox_size20" readonly="readonly"
	tabindex=3 /> <label class="bodytextB_blue">Changed Time:</label> <input
	type="text" name="<%=RequestConstants.CHANGED_TIME %>"
	value="<%=lastChgTime%>" class="textbox_size20" readonly="readonly"
	tabindex=3 /> <br />


<input name="changed_date_hidden" type="hidden"
	value="<%=lastChgDate %>" /> <input name="changed_time_hidden"
	type="hidden" value="<%= lastChgTime%>" /> <input
	name=<%=RequestConstants.CHANGED_BY%> type="hidden"
	class="textbox_size20_disb" readonly="readonly" value="admin" /> <input
	name=<%=RequestConstants.CHANGED_DATE%> type="hidden"
	class="textbox_size20_disb" readonly="readonly"
	value="<%=lastChgDate%>" /> <input
	name=<%=RequestConstants.CHANGED_TIME%> type="hidden"
	class="textbox_size20_disb" readonly="readonly"
	value="<%=lastChgTime%>" /> <br />
<br />

<label>&nbsp;</label> <input type="reset" name="reset2" value="Update"
	class="button"
	onClick="submitForm('updateUser','/security/security/user?method=updateUser')" />


<input type="button" name="back2" value="Back" class="button"
	onclick="javascript:history.back()" /> <br />
<br />
</form>
</fieldset>
</div>

