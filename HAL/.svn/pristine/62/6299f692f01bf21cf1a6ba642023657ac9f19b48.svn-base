<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_Bed_Selection.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.03.2009    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasBed"%><head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<SCRIPT LANGUAGE="JavaScript">

	function setBedId(bedId,bedNo) {
		window.opener.jsSetBedId(bedId);
		window.opener.document.getElementById("bedNo").value=bedNo;
		if(window.opener.document.getElementById("bedNoTemp"))
			window.opener.document.getElementById("bedNoTemp").value=bedNo;
		/* if(window.opener.document.getElementById("roomTypeId"))
			window.opener.document.getElementById("roomTypeId").value=document.getElementById("roomTypeId").value; */
		self.close();
	}
	   
 

</SCRIPT>

<title>Bed Status</title>
<form name="BedForm" action="">

<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasBed> masBedList = new ArrayList<MasBed>();
	MasBed masBed= new MasBed();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masBedList")!=null)
			masBedList = (List)map.get("masBedList");
	}
	
%>




<div class="tableAuto">
<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Available Bed No.</th>
		<th scope="col">Status</th>
	</tr>


	<%
String icdNameString ="";
if (masBedList != null && masBedList.size() > 0) { %>

	<% for(int i=0;i<masBedList.size();i++)
	{
		masBed = (MasBed)masBedList.get(i);
		if(masBed.getStatus().equalsIgnoreCase("y")){
	%>
	<tr>
		<td>
		<%-- <input type="hidden" id="roomTypeId"
			name="<%=ROOM_TYPE_ID %>"
			value="<%=masBed.getRoom().getRoomType().getId() %>" /> --%>
			 <input	type="button" name="Submit11" id="" tabindex="1"
			value="<%=masBed.getBedNo()%>"
			onselect="javascript:setBedId('<%=masBed.getId()%>','<%=masBed.getBedNo()%>');"
			onclick="javascript:setBedId('<%=masBed.getId()%>','<%=masBed.getBedNo()%>');" /></td>
		<td><%=masBed.getBedStatus().getBedStatusName()%></td>
	</tr>
	<%}
	}
	%>
	<% } 
	else
	{
	%>
	<tr>
		<td>No Data Found</td>
	</tr>
	<% } %>
</table>
</div>
</form>

