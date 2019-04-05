<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mapUserGroupToHosputal.jsp  
 * Purpose of the JSP -  This is for Map User Group to Hospital.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 23rd Oct,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.UserGroups"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<HTML>
<HEAD>
<TITLE>Map User Group</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link href="/hms/jsp/css/hms_basic_style.css" rel="stylesheet"
	type="text/css">
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
	function mapUserGroupToHospital(){
		userGroup = document.mapUserGroupToHospital.userGroupName.value;
		if(userGroup == 0){
			alert("Please select User Group");
			return false;
		}
       	return true;
	}
</script>


<%
		List userGroupList = new ArrayList();
		Iterator itrUserGroup = null;
		UserGroups userGroup = new UserGroups();
		Map map = new HashMap();
		if(request.getAttribute("map") != null)
			map = (Map) request.getAttribute("map");
		if(map.get("userGroupList") != null){
			userGroupList = (List) map.get("userGroupList");
			itrUserGroup = userGroupList.iterator();
		}
%>
<%
		if(userGroupList != null && userGroupList.size() > 0){
%>

<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
<form name="mapUserGroupToHospital" method="post">
<table
	style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
	bordercolor="#9f9f9f" height="212" cellspacing="0"
	bordercolordark="#217339" cellpadding="0" width="802" align="center"
	bgcolor="#f0f0f0" bordercolorlight="#217339" border="0">
	<tbody>
		<tr>
			<td height="19" colspan="4" valign="center" bgcolor="#85C2E5">
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
					<TD height="19" COLSPAN=5 valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="98%" height="24"
								background="/hms/jsp/images/top_header_10.gif">
							<div align="right"><span class="smalltextB">Welcome
							User Name</span>, <INPUT class=logout type=button value=Logout
								name=logout></div>
							</td>
							<td width="2%" background="/hms/jsp/images/top_header_10.gif">&nbsp;</td>
						</tr>
					</table>
					</TD>
				</TR>
			</TABLE>
			</td>
		</tr>

		<tr>
			<td width="203" height="369" rowspan="2" valign="center"
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
			<td width="0" rowspan="2" valign="center"
				background="/hms/jsp/images/bar.gif" class="bg_color">&nbsp;</td>
			<td width="33" height="19" valign="center" bgcolor="#FFFFFF">&nbsp;</td>
			<td width="560" valign="center" bgcolor="#FFFFFF"><span
				class="buy_option_title"><strong>YOU ARE HERE</strong> :
			Home&gt;Login&gt;Map User Group</span></td>
		</tr>
		<tr>
			<td colspan="2" valign="center" bgcolor="#FFFFFF">
			<table width="402" height="348" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td width="402" height="348" valign="top"
						background="/hms/jsp/images/airforce_medicare.gif"><br>

					<span class="bodytextB_blue"><br>
					</span>
					<fieldset style="width: 100%"><legend class="bodytextB"><span
						class="bodytextB">Map User Group </span></legend>
					<div id="editusergroup"><br>
					<table width="342" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td class="bodytextB_blue">&nbsp;</td>
							<td class="bodytextB_blue">&nbsp;</td>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td width="23" class="bodytextB_blue">&nbsp;</td>
							<td width="77" class="bodytextB_blue">User Group</td>
							<td colspan="2"><select
								name=<%=RequestConstants.USER_GROUP %> class="select_small">
								<option value="">Select</option>
								<%
											while(itrUserGroup.hasNext()){
												userGroup = (UserGroups) itrUserGroup.next();
%>
								<option value="<%=userGroup.getId()%>"><%=userGroup.getGroupName()%>
								</option>
								<%
											}
%>
							</select></td>
						</tr>
						<tr>
							<td height="7" colspan="4" align="center"></td>
						</tr>
						<tr>
							<td align="center">&nbsp;</td>
							<td align="center">
							<div align="right"></div>
							</td>
							<td width="150" align="center"><input type="button"
								name="mapGroupToHospital" value="Map Group To Hospital"
								onClick="return submitForm('mapUserGroupToHospital','/hms/hms/login?method=mapUserGroupToHospital','mapUserGroupToHospital')"
								class="buttonbig" /></td>
							<td width="92" align="center"><input type="button"
								name="cancel" value="Cancel" onClick="javascript:history.back()"
								class="button" /></td>
						</tr>
					</table>
					<%
			}else{
%>

					<p align="center" class="bodytextB_blue">All User Groups are
					already mapped to the hospital</p>

					<%
			}
%> <br>
					</div>
					</fieldset>

					<br>
					<p><label class="biglabel"></label> <br>
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