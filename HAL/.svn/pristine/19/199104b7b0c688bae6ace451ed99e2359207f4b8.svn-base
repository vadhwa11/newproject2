<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * userHospMaintenence.jsp  
 * Purpose of the JSP -  This is for User Hospital Maintenence.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>


<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<div id="contentspace">
<h2 align="left" class="style1">User Hospital Maintenence</h2>
<SCRIPT language=javascript src="calendar.js" type=text/javascript></SCRIPT>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> <script type="text/javascript"
	language="javascript" src="/hms/jsp/js/hms.js"></script> <script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>



<div
	style="POSITION: relative margin-left :   2px; margin-top: -15px; margin-left: 650px; margin-bottom: -5px;"><a
	href="/hms/jsp/images/mainPage.jsp" class="bodytextB_blue style2">Home
Page</a></div>
<%

	int hospitalId;
	
	Map map = new HashMap();
	
	List<Users> userList = new ArrayList<Users>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	if(request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");
				
		if(map.get("userList") != null){
			userList = (List<Users>)map.get("userList");
			}
		if(map.get("hospitalList") != null){
			hospitalList = (List<MasHospital>) map.get("hospitalList");
			}
	List tempList=new ArrayList();	
	tempList.add("vivek");
	tempList.add("nanda");
	tempList.add("Reddy");
	
	%>

<fieldset style="width: 100%" class="tableBorder"><legend
	class="bodytextB"> UserHospMaintenance - Main </legend>
<form name="userHospMaintenenceForm" method="post" action=""><br>
<br>


<br />
<label class="bodytextB_blue"><font id="error">*</font>Login
Name:</label> <select name=<%= RequestConstants.LOGIN_NAME%>
	validate='Login Name,string,yes'>
	<option value="0">--Select--</option>
	<%  Users usersObj=new Users();
           if(userList.size() != 0 && userList != null)  
         	  
           	  for (int i =0;i< userList.size(); i++)
 			  {
           		usersObj = (Users)userList.get(i);

					if(userList.size() != 0 && userList != null){ %>
	<option value="<%=usersObj.getId()%>"><%=usersObj.getLoginName()%></option>
	<%}} %>
</select> <br />
<label class="bodytextB_blue"><font id="error">*</font>Hospital
Name:</label> <select name=<%=RequestConstants.HOSPITAL_NAME%> id="hospId">

	<option value="0">--Select--</option>
	<%  MasHospital hospitalObj=new MasHospital();
           if(hospitalList.size() != 0 && hospitalList != null)  
         	  
           	  for (int i =0;i< hospitalList.size(); i++)
 			  {
           		hospitalObj = (MasHospital)hospitalList.get(i);

					if(hospitalList.size() != 0 && hospitalList != null){ %>
	<option value="<%=hospitalObj.getId()%>"><%=hospitalObj.getHospitalName()%></option>
	<%}} %>
</select> <br />

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
					
                %> <%
			StringBuffer orderDateOnly = new StringBuffer();
	  		GregorianCalendar gregorianCalendar1=new GregorianCalendar();
	  	
	  				int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
						   if(dateOfMonth<10)
						   {
			   					orderDateOnly.append("0");
						   		orderDateOnly.append(dateOfMonth);
						   }
						   else
						   {
			   					orderDateOnly.append(dateOfMonth);
			   			   }
			   
					  	   orderDateOnly.append("/");
			   
						   int month = gregorianCalendar1.get(Calendar.MONTH)+1;
						   if(month<10)
						   {
			   					orderDateOnly.append("0");
						   		orderDateOnly.append(month);
						   }
				   		   else
				   			{
						   		orderDateOnly.append(month);
						    }	
			   
						   orderDateOnly.append("/");
						   int year = gregorianCalendar1.get(Calendar.YEAR);
						   orderDateOnly.append(year);
			String currentDate = new String(orderDateOnly);	
			
			%> <label class="bodytextB_blue"><font id="error">*</font>Group
ID:</label> <select name=<%=RequestConstants.GROUP_NAME %>
	validate='Group ID,string,yes'>
	<option value="1">Admin</option>
</select> <label class="bodytextB_blue"></label> <br />
<label class="bodytextB_blue">Valid - Up to Date: </label> <input
	type="text" id="dobId" name="<%=RequestConstants.VALID_DATE %>"
	value="" class="textbox_size20" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.userHospMaintenenceForm.<%= RequestConstants.VALID_DATE%>,true);"
	class="calender" /> <br />
<label>&nbsp;</label><EM>(dd -mm -yyyy)</EM> <label
	class="bodytextB_blue"></label> <br />


<label class="bodytextB_blue">Status :</label> <input
	name=<%=RequestConstants.STATUS  %> type="radio" class="checkbox"
	value="y" checked="checked" /> <font class="bodytextB_blue">Active</font>
<input type="radio" name="<%=RequestConstants.STATUS %>" value="n"
	class="checkbox" /> <font class="bodytextB_blue">Inactive</font> <br />
<br />
<label></label> <label class="bodytextB_blue">Changed By :</label> <label
	class="bodytextB_blue">Changed Date:</label> <label
	class="bodytextB_blue">Changed Time:</label> <br />
<label></label> <label class="changelabel"> Admin </label> <label
	class="changelabel"> <%=lastChgDate%></label> <label
	class="changelabel"> <%=lastChgTime%></label> <br>
<br>

<br />
<br />
<label>&nbsp;</label> <input type="hidden"
	name=<%=RequestConstants.CHANGED_BY %> value="Admin"> <input
	type="hidden" name=<%=RequestConstants.CHANGED_DATE%>
	value="<%=lastChgDate%>"> <input type="hidden"
	name=<%=RequestConstants.CHANGED_TIME %> value="<%=lastChgTime%>"><br />

<input type="button" name="add" value="Add" class="button" tabindex="1"
	onClick="submitForm('userHospMaintenenceForm','/hms/hms/user?method=addUserHospMaintenance','checkBlankForAddUserMaintenence') " />

<input type="button" name="update" value="Update" class="button"
	tabindex="1"
	onClick="submitForm('userHospMaintenenceForm','/hms/hms/user?method=showUpdateUserHospMaintenance','checkBlankForAddUserMaintenence')" />

<input type="button" name="delete" value="Delete" class="button"
	tabindex="1"
	onClick="submitForm('userHospMaintenenceForm','/hms/hms/user?method=showDeleteUserHospMaintenance')" />

<input type="button" name="enquiry" value="Enquiry" class="button"
	tabindex="1"
	onClick="submitForm('userHospMaintenenceForm','/hms/hms/user?method=showEnquiryUserHospMaintenance')" />

<br />
<br />
</form>
</fieldset>
</div>
