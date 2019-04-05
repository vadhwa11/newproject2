<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * editUserGroup.jsp  
 * Purpose of the JSP -  This is for edit User Group.
 * @author  Deepti
 * @author  Ritu  
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="java.util.*,jkt.hms.masters.business.UserGroups"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<HTML>
<HEAD>
<TITLE>Edit User Group</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(/hms/jsp/images/bg_bar.gif);
}
-->
</style>
</HEAD>

<STYLE type=text/css>
TABLE.test TD {
	BORDER-RIGHT: #000000 1px solid;
	BORDER-TOP: #000000 1px solid;
	BORDER-LEFT: #000000 1px solid;
	BORDER-BOTTOM: #000000 1px solid
}
</STYLE>

<script>
function submitForm(formName,action){

        obj = eval('document.'+formName)
    	if(obj){
        	obj.action = action;
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
}
</script>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
<form name="editUserGroup" method="post">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	Boolean exists = false;
	if(map.get("exists") != null){
		exists = (Boolean) map.get("exists");
	}
	
	String groupExistMessage = "";
	if(map.get("groupExistMessage") != null){
		groupExistMessage = (String) map.get("groupExistMessage");
	}
%>
<table
	style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
	bordercolor="#9f9f9f" height="212" cellspacing="0"
	bordercolordark="#217339" cellpadding="0" width="802" align="center"
	bgcolor="#f0f0f0" bordercolorlight="#217339" border="0">
	<tbody>
		<tr>
			<td height="19" colspan="4" valign="center" bgcolor="#000000">
			<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
				<TR>
					<TD ROWSPAN=2><IMG SRC="/hms/jsp/images/top_header_01.gif"
						WIDTH=33 HEIGHT=103 ALT="Hospital Management System - HMS"></TD>
					<TD ROWSPAN=2><IMG SRC="/hms/jsp/images/top_header_02.gif"
						WIDTH=122 HEIGHT=103 ALT="Hospital Management System - HMS"></TD>
					<TD ROWSPAN=2><IMG SRC="/hms/jsp/images/top_header_03.gif"
						WIDTH=126 HEIGHT=103 ALT="Hospital Management System - HMS"></TD>
					<TD><IMG SRC="/hms/jsp/images/top_header_04.gif" WIDTH=150
						HEIGHT=79 ALT="Hospital Management System - HMS"></TD>
					<TD><IMG SRC="/hms/jsp/images/top_header_05.gif" WIDTH=116
						HEIGHT=79 ALT="Hospital Management System - HMS"></TD>
					<TD><IMG SRC="/hms/jsp/images/top_header_06.gif" WIDTH=100
						HEIGHT=79 ALT="Hospital Management System - HMS"></TD>
					<TD><IMG SRC="/hms/jsp/images/top_header_07.gif" WIDTH=99
						HEIGHT=79 ALT="Hospital Management System - HMS"></TD>
					<TD><IMG SRC="/hms/jsp/images/top_header_08.gif" WIDTH=53
						HEIGHT=79 ALT="Hospital Management System - HMS"></TD>
					<TD ROWSPAN=2><IMG SRC="/hms/jsp/images/top_header_09.gif"
						WIDTH=1 HEIGHT=103 ALT="Hospital Management System - HMS"></TD>
				</TR>
				<TR>
					<TD COLSPAN=5><IMG SRC="/hms/jsp/images/top_header_10.gif"
						WIDTH=518 HEIGHT=24 ALT="Hospital Management System - HMS"></TD>
				</TR>
			</TABLE>
			</td>
		</tr>

		<tr>
			<td width="228" height="369" rowspan="2" valign="center"
				bgcolor="#FFFFFF" class="bg_color">
			<table
				style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
				bordercolor="#106899" height="27" cellspacing="0"
				bordercolordark="#217339" cellpadding="0" width="181" align="center"
				bgcolor="#106899" bordercolorlight="#217339" border="0">
				<tbody>
					<tr>
						<td width="179" height="25" colspan="2" valign="center"
							bgcolor="106899">
						<table width="179" height="289" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr>
								<td width="179" height="226"
									background="/hms/jsp/images/leftpane_flow.gif">
								<table width="173" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td><img src="/hms/jsp/images/curve_01.gif" width="173"
											height="39" alt="Hospital Management System" /></td>
									</tr>
									<tr>
										<td height="2" align="right"
											background="/hms/jsp/images/curve_02.gif">
										<table width="158" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="2" background="/hms/jsp/images/seperator.gif"></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td height="24" background="/hms/jsp/images/curve_02.gif"
											class="bodytextB">
										<div align="center">
										<table width="145" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td width="20"><img src="/hms/jsp/images/customer.gif"
													alt="HMS Customer" width="16" height="17"></td>
												<td width="8" class="bodytextB">
												<div align="center"></div>
												</td>
												<td width="117" class="bodytextB">Customer</td>
											</tr>
										</table>
										</div>
										</td>
									</tr>
									<tr>
										<td height="2" align="right"
											background="/hms/jsp/images/curve_02.gif">
										<table width="158" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="2" background="/hms/jsp/images/seperator.gif"></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td height="23" background="/hms/jsp/images/curve_02.gif"
											class="bodytextB">
										<div align="center">
										<table width="145" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td width="20"><img
													src="/hms/jsp/images/dispensary.gif" alt="HMS Customer"
													width="16" height="17"></td>
												<td width="8" class="bodytextB">
												<div align="center"></div>
												</td>
												<td width="117" class="bodytextB">Dispensary</td>
											</tr>
										</table>
										</div>
										</td>
									</tr>
									<tr>
										<td height="5" align="right"
											background="/hms/jsp/images/curve_02.gif">
										<table width="158" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="2" background="/hms/jsp/images/seperator.gif"></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td height="19" background="/hms/jsp/images/curve_02.gif"
											class="bodytextB">
										<div align="center">
										<table width="145" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td width="20"><img src="/hms/jsp/images/pharmacy.gif"
													alt="HMS Customer" width="16" height="17"></td>
												<td width="8" class="bodytextB">
												<div align="center"></div>
												</td>
												<td width="117" class="bodytextB">Pharmacy</td>
											</tr>
										</table>
										</div>
										</td>
									</tr>
									<tr>
										<td height="5" align="right"
											background="/hms/jsp/images/curve_02.gif">
										<table width="158" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="2" background="/hms/jsp/images/seperator.gif"></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td height="19" background="/hms/jsp/images/curve_02.gif"
											class="bodytextB">
										<div align="center"></div>
										</td>
									</tr>

									<tr>
										<td height="19" align="right"
											background="/hms/jsp/images/curve_02.gif">&nbsp;</td>
									</tr>
									<tr>
										<td><img src="/hms/jsp/images/curve_04.gif" width="173"
											height="43" alt="Hospital Management System" /></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
			<td width="4" rowspan="2" valign="center"
				background="/hms/jsp/images/bar.gif" class="bg_color">&nbsp;</td>
			<td width="8" height="19" valign="center" bgcolor="#FFFFFF">&nbsp;</td>
			<td width="560" valign="center" bgcolor="#FFFFFF"><span
				class="buy_option_title"><strong>YOU ARE HERE</strong> :
			Home&gt;Login&gt;Edit User Group</span></td>
		</tr>
		<tr>
			<td colspan="2" valign="center" bgcolor="#FFFFFF">
			<table width="402" height="348" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td width="402" height="348" valign="top"
						background="/hms/jsp/images/airforce_medicare.gif"><br>

					<br>
					<p><br>
					<table width=339 border=0 cellpadding=0 cellspacing=0
						align="center">
						<tr>
							<td width="25"><img src="/hms/jsp/images/tab_bar_01.gif"
								width=25 height=28 alt="HMS"></td>
							<td width="157" class="titlebar_bg"><span class="bodytextB">
							&nbsp;&nbsp; Edit User Group </span></td>
							<td width="195"><img src="/hms/jsp/images/tab_bar_04.gif"
								width=35 height=28 alt="HMS"></td>
							<td width="9">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">
							<table
								style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
								bordercolor="#000000" height="27" cellspacing="0"
								bordercolordark="#217339" cellpadding="0" width="368"
								align="center" bordercolorlight="#217339" border="0">
								<tbody>
									<tr>
										<td width="85" height="25" colspan="2" valign="center">
										<%
	UserGroups userGroup = new UserGroups();

	List userGroupByIdList = new ArrayList();
	if (map.get("userGroupByIdList") != null) {
		userGroupByIdList = (List) map.get("userGroupByIdList");
		userGroup = (UserGroups) userGroupByIdList.get(0);
	}
%>

										<table width="312" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td colspan="3" class="bodytextB_blue">&nbsp;</td>
											</tr>
											<tr>
												<td width="12" class="bodytextB_blue" height="16">&nbsp;</td>
												<td colspan="2" class="bodytextB_blue" height="16">
												<div id="existMessage">
												<p align="center" style="color: red;" class="errormsg"><%=groupExistMessage%></p>
												</div>
												</td>
											</tr>
											<tr>
												<td width="12" class="bodytextB_blue">&nbsp;</td>
												<td width="93" class="bodytextB_blue">User Group</td>
												<td width="173"><input
													name=<%=RequestConstants.USERGROUP_NAME %> type="text"
													class="textfield6" maxlength="6"
													value="<%=userGroup.getGroupName()%>"
													validate="User Group,userGroup,yes"></td>
											</tr>
											<tr>
												<td class="bodytextB_blue">&nbsp;</td>
												<td class="bodytextB_blue">Status</td>
												<td><input name=<%=RequestConstants.USERGROUP_STATUS %>
													type="radio" value="y" checked> <span
													class="bodytextB">Active</span> <input
													name=<%=RequestConstants.USERGROUP_STATUS %> type="radio"
													value="n"> <span class="bodytextB">Inactive</span>
												</td>
												<td width="34">&nbsp;</td>
											</tr>
											<tr>
												<td colspan="2" class="bodytextB_blue">&nbsp;</td>
												<td><input type="hidden"
													name=<%=RequestConstants.USER_GROUP %>
													value="<%=userGroup.getId()%>"></td>
												<td><input type="hidden"
													name=<%=RequestConstants.ACTUAL_USERGROUP %>
													value="<%=userGroup.getGroupName()%>"></td>
											</tr>
											<tr>
												<td height="7" colspan="4" class="bodytextB_blue"></td>
											</tr>
											<tr>
												<td colspan="2" class="bodytextB_blue">&nbsp;</td>
												<td colspan="2"><input type="button" class="button"
													name="updateGroup" value="Update Group"
													onclick="return submitForm('editUserGroup','/hms/hms/login?method=updateUserGroup')" />
												<input type="button" class="button" name="cancel"
													value="Cancel" onClick="javascript:history.back()" /></td>
											</tr>
											<tr>
												<td colspan="2" class="bodytextB_blue">&nbsp;</td>
												<td colspan="2">&nbsp;</td>
											</tr>
										</table>



										</td>
									</tr>
								</tbody>
							</table>
							</td>
						</tr>
					</table>
					<p><br>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td height="54" colspan="4" valign="center" bgcolor="#000000"
				class="bg_color">
			<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
				<TR>
					<TD width="649" valign="top"
						background="/hms/jsp/images/footer_02.gif">
					<table width="649" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="23" colspan="2" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="156">&nbsp;</td>
							<td width="493" class="footerText">Privacy Policy | Terms of
							Use Copyright 2004, <strong>Hospital Management System.</strong>
							All rights reserved.</td>
						</tr>
					</table>
					</TD>
					<TD width="106"><a href="http://www.jktech.com"><IMG
						SRC="/hms/jsp/images/footer_03.gif"
						ALT="Hospital managment System- HMS" WIDTH=106 HEIGHT=54
						border="0"></a></TD>
					<TD width="45"><a href="http://www.jktech.com"><IMG
						SRC="/hms/jsp/images/footer_04.gif"
						ALT="Hospital managment System- HMS" WIDTH=44 HEIGHT=54 border="0"></a></TD>
				</TR>
			</TABLE>
			</td>
		</tr>
	</tbody>
</table>
</BODY>
</HTML>