<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * enquiryUserHospMaintenence.jsp  
 * Purpose of the JSP -  This is for Enquiry for User Hospital Maintenance.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.UserUsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


<%
    int p=0;
    int min=0;
    int max=5;
    String nextState="enable"; 
    String previousState="disable";
	String loginString="";
	Map<String,Object> map = new HashMap<String,Object>();
	List userUsergroupHospitalList=new ArrayList();
	List userList=new ArrayList();
	List hospitalList=new ArrayList();
	List userGroupList=new ArrayList();
	int loginIdTemp=0;
	try{
		if(request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");
	if(map.get("userUsergroupHospitalList")!=null)
		userUsergroupHospitalList=(List)map.get("userUsergroupHospitalList");
	if(map.get("userList")!=null)
		userList=(List)map.get("userList");
	if(map.get("hospitalList")!=null)
		hospitalList=(List)map.get("hospitalList");
	if(map.get("userGroupList")!=null)
		userGroupList=(List)map.get("userGroupList");
	}catch(Exception ee)
		{
		System.out.println("111111111111111111111111"+ee.getClass());
		
		}
	
	try{
	if(map.get("previousState")!=null)
		 previousState=(String)map.get("previousState");
	if(map.get("nextState")!=null)
		 nextState=(String)map.get("nextState");
	if(map.get("min")!=null)
		 min=Integer.parseInt((String)map.get("min"));
	 if(map.get("max")!=null)
		 max=Integer.parseInt((String)map.get("max"));
	if(map.get("loginIdTemp")!=null)
		loginIdTemp=Integer.parseInt((String)map.get("loginIdTemp"));
	}catch(Exception e){
		 System.out.println("asdsadasdasdasd"+e.getClass());
	}
	 session.setAttribute("min", min+"");
	 session.setAttribute("max", max+"");
	 session.setAttribute("loginIdTemp", loginIdTemp+"");

	
    %>

<form name="enquiryUserHospMaintenence" action="" method="post">


<div id=contentspace>
<h2 align="left" class="style1">User Hospital Maintenence</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">
<legend class="bodytextB">UserHospital Maintenence- Enquiry </legend> <br />


<table width="71%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="100%" border="0" align="center" cellpadding="1"
			cellspacing="1" class="tableBorder" height="46">
			<tr>
				<td width="23%" height="20" class="bg_yellow"><b>&nbsp;&nbsp;Login
				Name</b></td>
				<td width="20%" height="20" class="bg_yellow"><strong>&nbsp;&nbsp;&nbsp;Hospital
				Name</strong></td>
				<td width="20%" height="20" class="bg_yellow"><strong>&nbsp;&nbsp;&nbsp;Group
				Name</strong></td>
				<td width="22%" class="bg_yellow"><strong>&nbsp;&nbsp;Valid
				upto </strong></td>
				<td width="10%" class="bg_yellow"><b><strong>&nbsp;</strong>Status</b></td>
			</tr>
			<br />

			<% 
                    
                    String loginName="";
                    int loginId=0;
                    String groupName="";
                    String hospName="";
                    String status="";
                    String lastChgBy=null;
            		String statusStr="";
            		Date validDate =null;
            		try{
                    UserUsergroupHospital userUsergroupHospital=new UserUsergroupHospital();
                    Users usersObj=new Users();
                    if(userUsergroupHospitalList.size() != 0 && userUsergroupHospitalList != null)  
                   	  
                     	  for (Iterator iter2=userUsergroupHospitalList.iterator();iter2.hasNext();)
           			  {
                     		 userUsergroupHospital = (UserUsergroupHospital)iter2.next();
                     		
                     		loginId=userUsergroupHospital.getFkUserId();
                     		if(userList.size() != 0 && userList != null)
                     		for (Iterator iter3 = userList.iterator(); iter3.hasNext();)
                  			 {
                     			usersObj = (Users) iter3.next();
                     			if(usersObj.getId()==loginId){
                     				loginName=usersObj.getLoginName();
                     			}
                     			
                  			 }
                  			
                     		
                     		groupName=userUsergroupHospital.getFkGroupHospital().getFkGroup().getGroupName();
                     		hospName=userUsergroupHospital.getFkGroupHospital().getFkHospital().getHospitalName();
                     		status=userUsergroupHospital.getStatus();
                     		if(status.equals("y")){
                     			statusStr="Active";
                     		}else{
                     			statusStr="InActive";
                     		}
                     		validDate=userUsergroupHospital.getValidUpto();
                     		
                     		 if((min<=p)&&(max>=p)){
                    %>
			<tr>
				<td width="17%" class="table_grid" bordercolor="#333333"><%=loginName %></td>
				<td width="25%" class="table_grid" bordercolor="#333333"><%=hospName %>
				</td>
				<td width="21%" bordercolor="#333333" class="table_grid"><%=groupName %></td>
				<td width="18%" bordercolor="#333333" class="table_grid"><%=validDate %></td>
				<td width="17%" bordercolor="#333333" class="table_grid"><%=statusStr %></td>
			</tr>
			<%}p++;
                  
                   } }catch(Exception e){
                	   System.out.println("wronng in Jsp");
                   }
                   
                   %>

		</table>
</table>

<br />
<label>&nbsp;</label> <input type="reset" name="next" value="Next"
	class="button"
	onclick="if(nextButtonState('enquiryUserHospMaintenence','<%=nextState%>')){submitForm('enquiryUserHospMaintenence','/hms/hms/user?method=nextForUserHosp');}" />
<input type="button" name="previous" value="Previous" class="button"
	onclick="if(previousButtonState('enquiryUserHospMaintenence','<%=previousState%>')){submitForm('enquiryUserHospMaintenence','/hms/hms/user?method=previousForUserHosp');}" />

<input type="button" name="back22" value="Back" class="button"
	onclick="submitForm('enquiryUserHospMaintenence','/hms/hms/user?method=showUserHospMaintenanceJsp');" />
</form>
</fieldset>
</div>