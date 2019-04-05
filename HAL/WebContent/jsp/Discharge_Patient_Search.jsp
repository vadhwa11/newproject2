<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : Discharge_Patient_Search.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, admissionNumberPopulate.jsp
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(serviceNo) {
		opener.jsSetPatientData(serviceNo);
		self.close();
	}
	
	function sub()
	{
	if (patientSearchForm.serviceNo.value=="" && patientSearchForm.serviceType.value=="" &&
	    patientSearchForm.rank.value=="" && patientSearchForm.adNo.value=="" &&
	    patientSearchForm.patientName.value=="" && patientSearchForm.servicePersonnelName.value=="")
	    {
	    alert("Pl. Check your Input..... ");
	    return;
	    }
	    else
		{
		submitForm('patientSearchForm','discharge?method=showPatientSearchJsp');
		}
	}
	
//-->
</SCRIPT>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	Box box = HMSUtil.getBox(request);

	List masServiceTypeList = null;
	List masRankList = null;
	List masUnitList = null;
	List patientList = null;
	MasServiceType masServiceType = null;
	MasRank masRank = null;
	MasUnit masUnit = null;
	Patient patient = null;
	
	if (map.get("masServiceTypeList")!=null)
	masServiceTypeList = (List)map.get("masServiceTypeList");
	
	if (map.get("masRankList")!=null)
	masRankList = (List)map.get("masRankList");
	
	if (map.get("masUnitList")!=null)
	masUnitList = (List)map.get("masUnitList");
	
	if (map.get("patientList")!=null)
	patientList = (List)map.get("patientList");

%>


<form name="patientSearchForm" action="" method="post">

<h4>Patient Search</h4>
<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label>Service No.</label> <input type="text" name="serviceNo"
	value="<%=box.get("serviceNo")%>" MAXLENGTH="30" /> <label>Service
Type</label> <select name="serviceType">
	<option value="">Select Ser Type</option>
	<% for(int i=0;i<masServiceTypeList.size();i++)
			{
				masServiceType = (MasServiceType)masServiceTypeList.get(i);
			%>
	<option value="<%=masServiceType.getServiceTypeCode()%>"
		<%=HMSUtil.isSelected(masServiceType.getServiceTypeCode(),box.get("serviceType"))%>><%=masServiceType.getServiceTypeName()%></option>
	<%
			}
			%>
</select>

<div class="Clear"></div>
<label>Rank </label> <select name="rank">
	<option value="">Select Rank</option>
	<% for(int i=0;i<masRankList.size();i++)
			{
				masRank = (MasRank)masRankList.get(i);
			%>
	<option value="<%=masRank.getRankCode()%>"
		<%=HMSUtil.isSelected(masRank.getRankCode(),box.get("rank"))%>><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select> <label>Ad No </label> <input type="text" name="adNo" value=""
	MAXLENGTH="30" />
<div class="Clear"></div>
<label>Ser.Per Name </label> <input type="text"
	name="servicePersonnelName"
	value="<%=box.get("servicePersonnelName")%>" MAXLENGTH="30" /> <label>Patient
Name </label> <input type="text" name="patientName"
	value="<%=box.get("patientName")%>" MAXLENGTH="30" />

<div class="Clear"></div>
</div>
<div class="Clear"></div>

<input type="button" name="Submit" id="addbutton" onClick="sub();"
	value="Search" class="button" accesskey="a" /> <input type="hidden"
	name="SearchFlag" value="true" />
<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellpadding="0" cellspacing="0">

	<thead>
		<tr>

			<th width="52" class="gridheaderlabel">Service No</th>
			<th width="87" class="gridheaderlabel">Service Type</th>
			<th width="116" class="gridheaderlabel">Service Person Name</th>
			<th width="158" class="gridheaderlabel">Rank</th>
			<th width="89" class="gridheaderlabel">Unit</th>
			<th width="135" class="gridheaderlabel">Patient Name</th>


		</tr>

	</thead>
	<tbody>

		<% 
		System.out.println("patientList.size()--"+patientList.size());
		if (patientList != null && patientList.size() > 0) { %>

		<% for(int i=0;i<patientList.size();i++)
	{
		patient = (Patient)patientList.get(i);
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:jsSelData('<%=patient.getServiceNo()%>');">
			<td height="12"><%=patient.getServiceNo()%></td>
			<td align="left"><%=patient.getServiceType().getServiceTypeName()%></td>
			<td align="left"><%=patient.getSFirstName() + " " + patient.getSMiddleName() + " " + patient.getSLastName()%></td>
			<td align="left"><%=patient.getRank().getRankName() %></td>
			<td align="left"><%=patient.getUnit().getUnitName() %></td>
			<td align="left"><%=patient.getPFirstName() + " " + patient.getPMiddleName() + " " + patient.getPLastName()%></td>
		</tr>
		<%
	}
	%>
		<% } 
	else
	{
	%>
		<tr>
			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>

</form>
