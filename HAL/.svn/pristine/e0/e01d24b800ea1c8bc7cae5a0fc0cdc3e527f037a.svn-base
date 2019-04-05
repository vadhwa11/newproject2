<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTrack.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
<form name="patientTrack" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> ptmap = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<MasServiceType> serviceTypeList = null;
		List<Object[]> unitList = null;
		List<Patient> patientList = null;
		List<MasTrade> masTradeList = null;
		List<MasStation> stationList = null;
		List<MasSection> sectionList = null;
		List<MasCommand> commandList = null;
		List<MasRelation> relationList = null;
		List<Object[]> ptTrackList = new ArrayList<Object[]>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("ptmap") != null){
			ptmap= (Map<String, Object>)map.get("ptmap");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("unitList") != null){
			unitList= (List<Object[]>)map.get("unitList");
		}
	
		if(map.get("masTradeList") != null){
			masTradeList= (List<MasTrade>)map.get("masTradeList");
		}
		if(map.get("stationList") != null){
			stationList= (List<MasStation>)map.get("stationList");
		}
		if(map.get("sectionList") != null){
			sectionList= (List<MasSection>)map.get("sectionList");
		}
		if(map.get("commandList") != null){
			commandList= (List<MasCommand>)map.get("commandList");
		}
		if(map.get("relationList") != null){
			relationList= (List<MasRelation>)map.get("relationList");
		}
		if(ptmap.get("ptTrackList") != null){
			ptTrackList= (List<Object[]>)ptmap.get("ptTrackList");
		}
	
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
	%> 
<div class="titleBg"><h2>Patient Track</h2></div>
<div class="Clear"></div>

<div class="Block">
<label>Date <span>*</span></label>
<input type="text" name="<%=DATE %>" value="<%= currentDate %>" MAXLENGTH="20" class="date"	id="date" validate='Date,string,yes' />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.patientTrack.<%=DATE %>,event)" /> 

<label>Service No.</label>
<input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="20"	id="serviceNo" validate="Service No,metachar,no"/>
<label>HIN</label>
<input type="text"	name="<%=HIN_NO %>" value="" MAXLENGTH="50" id="hinNo" validate="HIN,metachar,no"/>
<div class="Clear"></div>

<label> Patient Name</label> 
<input type="text"	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="<%=P_FIRST_NAME %>"  validate="Patient Name,name,no"/>
	
<label> Relation</label> 
 <select name="<%=RELATION_ID %>" id="rankId">
	<option value="0">Select</option>
	<% for(MasRelation masRelation : relationList)
			{
			%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%
			}
			%>
</select>
	

<label>Rank</label>
 <select name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>
<label> First Name</label> 
<input type="text"	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" id="fName" validate="First Name,name,no" />
	
<label> Mid Name</label> 
<input type="text" name="<%=S_MIDDLE_NAME %>" value=""	MAXLENGTH="15" id="mName" validate="Mid Name,name,no" />
<label> Last Name</label> 
<input	type="text" name="<%=S_LAST_NAME%>" value="" MAXLENGTH="15" id="lName" validate="Last Name,name,no" />
<div class="Clear"></div>

<label>Service Type</label> 
<select name="<%=SERVICE_TYPE_ID %>"	id="serviceTypeId">
	<option value="0">Select Service Type</option>
	<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%
			}
			%>
</select>
<label>Trade/Branch</label> 
<select name="tradeId" id="tradeId">
	<option value="0">Select</option>
		<% 
			for(MasTrade trade : masTradeList)
			{
			%>
	<option value="<%=trade.getId()%>"><%=trade.getTradeName()%></option>
	<%
			}
			%>
</select>
<label>Section</label> 
<select name="sectionId" id="sectionId">
	<option value="0">Select</option>
		<% 
			for(MasSection section : sectionList)
			{
			%>
	<option value="<%=section.getId()%>"><%=section.getSectionName()%></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>

<label>Unit</label> 
<select name="<%=UNIT_ID %>" id="unitId">
	<option value="0">Select</option>
	<%
				for(Object[] masUnit : unitList)
				{
				%>
	<option value="<%=(Integer)masUnit[0]%>"><%=(String)masUnit[1]%></option>
	<%
				}
				%>
</select>

<label>Station</label> 
<select name="stationId" id="stationId">
	<option value="">Select</option>
		<% 
			for(MasStation station : stationList)
			{
			%>
	<option value="<%=station.getStationName()%>"><%=station.getStationName()%></option>
	<%
			}
			%>
</select>

<label>Command</label> 
<select name="commandId" id="commandId">
	<option value="0">Select</option>
		<% 
			for(MasCommand command : commandList)
			{
			%>
	<option value="<%=command.getId()%>"><%=command.getCommandName()%></option>
	<%
			}
			%>
</select>
<div class="Clear"></div>
<label>AFNET No.</label> 
<input type="text" name="afnetNo" value="" validate="AFNET No,metachar,no"/>
<label>Mobile No.</label> 
<input type="text" name="mobileNo" value="" validate="Mobile No,metachar,no"/>
<div class="Clear"></div>
</div>


<div class="Clear"></div>

<input type="button" name="search" id="addbutton"	onclick="submitForm('patientTrack','/hms/hms/adt?method=searchPatientTrack')"	value="Search" class="button" accesskey="a" />
	<div class="Clear"></div>
	<h4>Track Details</h4>
	
	<%
		if(ptTrackList.size() > 0){
	%>
	
<div id="pageNavPosition"></div>
	<div class="Clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="">
	<tr>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Reception</th>
		<th scope="col">OPD/FWC</th>
		<th scope="col">Dispensary</th>
		<th scope="col">Lab</th>
		<th scope="col">Radiology</th>
		<th scope="col">Physio</th>
		<th scope="col">Treatment Room</th>
		<th scope="col">Dental</th>

	</tr>
		<tbody id="tableData">
	<%
		for(Object[] obj : ptTrackList){
	%>
	<tr>
	<td><%=obj[2] %></td>
	<td><%=obj[3] %></td>
	<td><%=obj[1] %></td>
	<%
		if(obj[4]!= null){
	%>
	<td><%=obj[4] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if(obj[5]!= null){
	%>
	<td><%=obj[5] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if(obj[6]!= null){
	%>
	<td><%=obj[6] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if(obj[7]!= null){
	%>
	<td><%=obj[7] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<%
		if(obj[8]!= null){
	%>
	<td><%=obj[8] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
<%-- 	<%
		if(obj[9]!= null){
	%>
	<td><%=obj[9] %></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>--%>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	
	<%} %>
	</tbody>
	</table>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	
	<%}else{%>
		<div class="Clear"></div>
	<span>No Record Found!</span>
	
	<%}%>
	<div class="Clear"></div>
	<input type="button" name="refresh" onclick="submitForm('patientTrack','/hms/hms/adt?method=showPatientTrackJsp');"	value="Refresh" class="button" accesskey="a" />
	
		<div class="paddingTop15"></div>
		
		</form>