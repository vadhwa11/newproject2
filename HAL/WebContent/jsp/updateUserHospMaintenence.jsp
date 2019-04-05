<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateUserHospMaintenence.jsp  
 * Purpose of the JSP -  This is for Updating User Hospital Maintenence.
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
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<div id="contentspace">
<h2 align="left" class="style1">UserHospMaintenance-Update</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> <script type="text/javascript"
	language="javascript" src="/hms/jsp/js/hms.js"></script> <script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>



<div
	style="POSITION: relative margin-left :   2px; margin-top: -15px; margin-left: 650px; margin-bottom: -5px;"><a
	href="/hms/jsp/images/mainPage.jsp" class="bodytextB_blue style2">Home
Page</a></div>



<br>

<%		String loginName="";
		       String hospitalName="";
 		   	  	Map map=new HashMap();
 		   	  	List userList=new ArrayList();
 		   		List userGroupHospList=new ArrayList();
 		   		List userUserGroupHospList=new ArrayList();
 		   		List hospList=new ArrayList();
 		   		
 		   	if(request.getAttribute("map") != null)
 		   		map = (Map) request.getAttribute("map");
 		   	
 		   	if(map.get("userList") != null)
 		   		userList = (List) map.get("userList");
 	
 		   	if(map.get("userUserGroupHospList") != null)
 		   		userUserGroupHospList = (List) map.get("userUserGroupHospList");
 		   
 		   	
 		 
 		 
 		   %> <br>
<form name="updateUserHospMaintenenceForm" method="post">
<%
            				int id=0;
                      		int loginId=0;
                      		int hospitalId=0;
                      		int groupId=0;
                      		int groupHospitalId=0;
                      		String status="";
                      		String msgToUser="";
                      		String lastChgBy2=null;
                      		String lastChgTime2 = null;
                      		Date lastChgDate2 ;
                      		String  validDate =null;
                      		try{
                      		UserUsergroupHospital  userUsergroupHospital=new UserUsergroupHospital();
                              if(userUserGroupHospList.size() != 0 && userUserGroupHospList != null)  
                            	  
                              	  for (int i =0;i< userUserGroupHospList.size(); i++)
                    	  {
                              		  userUsergroupHospital = (UserUsergroupHospital)userUserGroupHospList.get(i);

                   			if(userUserGroupHospList.size() != 0 && userUserGroupHospList != null)
                   			{
                   				id=userUsergroupHospital.getId();
                   				
                   				loginId=userUsergroupHospital.getUser().getId();
                   				hospitalName=userUsergroupHospital.getGroupHospital().getHospital().getHospitalName();
                   				status=userUsergroupHospital.getStatus();
                   				validDate=""+userUsergroupHospital.getValidUpto();
                   				lastChgBy2=userUsergroupHospital.getLastChgBy();
                   				lastChgTime2=userUsergroupHospital.getLastChgTime();
                   				lastChgDate2=userUsergroupHospital.getLastChgDate();
                   			}}
                      		}catch(Exception e){
                      			System.out.println("e  "+e);
                      		}
                  %> <%
                   SimpleDateFormat formatterIn1 = new SimpleDateFormat("yyyy-MM-dd");
   				 SimpleDateFormat formatterOut1 = new  SimpleDateFormat("dd/MM/yyyy");
   				validDate=formatterOut1.format(formatterIn1.parse((validDate)));
   				                            	  
   				                     			
   				                     %> <input name="groupHospitalIdField"
	type="hidden" value=<%=id %>> <br />
<label class="bodytextB_blue">Login Name :</label> <%  Users usersObj=new Users();
      			 if(userList.size() != 0 && userList != null)  
     	  
       	 		 for (int i =0;i< userList.size(); i++)
			 	 {
		       		usersObj = (Users)userList.get(i);
		       		if(usersObj.getId()==loginId)
					loginName=usersObj.getLoginName();
				}
				%> <input type="text" name="textfield" class="textbox_size20_disb"
	readonly="readonly" value=<%=loginName %>> <br />
<label class="bodytextB_blue">Hospital Name:</label> <input type="text"
	name="textfield" class="textbox_size20_disb" readonly="readonly"
	value=<%=hospitalName %>> <br />
<label class="bodytextB_blue">Group ID:</label> <input type="text"
	name="textfield" class="textbox_size20_disb" readonly="readonly"
	value="Admin" /> <label class="bodytextB_blue"></label> <br />
<%
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
			
			%><label class="bodytextB_blue"></label> <label
	class="bodytextB_blue">Valid - Up to Date: </label> <input type="text"
	id="dobId" name="<%=RequestConstants.VALID_DATE %>"
	value=<%=validDate %> class="textbox_size20" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.updateUserHospMaintenenceForm.<%= RequestConstants.VALID_DATE%>,true);"
	class="calender" /> <br />
<label>&nbsp;</label><EM>(dd -mm -yyyy)</EM> <label
	class="bodytextB_blue"></label> <br />
<label class="bodytextB_blue">Status :</label> <% if(status.equals("y")){ %>

<input type="radio" name=<%=RequestConstants.STATUS%> class="checkbox"
	value="y" checked="checked"> <font class="bodytextB_blue">Active</font>
<input type="radio" name=<%=RequestConstants.STATUS%> class="checkbox"
	value="n"> <font class="bodytextB_blue">Inactive</font> <%}else{ %>

<input type="radio" name=<%=RequestConstants.STATUS%> class="checkbox"
	value="y"> <font class="bodytextB_blue">Active</font> <input
	type="radio" name=<%=RequestConstants.STATUS%> class="checkbox"
	value="n" checked="checked"> <font class="bodytextB_blue">Inactive</font>
<%} %> <br />



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
   				                     %> <label></label> <label
	class="bodytextB_blue">Changed By :</label> <label
	class="bodytextB_blue">Changed Date:</label> <label
	class="bodytextB_blue">Changed Time:</label> <br />
<label></label> <label class="changelabel"> Admin </label> <label
	class="changelabel"> <%=lastChgDate%></label> <label
	class="changelabel"> <%=lastChgTime%></label> <br />
<br />

<input type="hidden" name=<%=RequestConstants.CHANGED_BY %>
	value="Admin"> <input type="hidden"
	name=<%=RequestConstants.CHANGED_DATE%> value="<%=lastChgDate%>">
<input type="hidden" name=<%=RequestConstants.CHANGED_TIME %>
	value="<%=lastChgTime%>"><br />
<label>&nbsp;</label> <input type="button" name="update" value="Update"
	class="button"
	onClick="submitForm('updateUserHospMaintenenceForm','/security/security/user?method=updateUserHospMaintenance')" />

<input type="button" name="back" value="Back" class="button"
	onclick="javascript:history.back()" /></form>
<br />
<br />
</fieldset>