<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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

<div id="contentHolder">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		 }
	%>

<h6>Rank Wise Establishment strength return</h6>
<div class="Clear"></div>
<form name="rankWiseReport" target="_blank" method="post" action="">
<div id="divId" class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Rank</label> <select name="<%=RANK_ID%>"
	id="rankId">
	<option value="0">Select Rank</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select></div>

<input type="button" name="OK" value="OK" class="cmnButton"
	onClick="if(rankWiseReport.rankId.value!=0){submitForm('rankWiseReport','hrRelated?method=generateRankWiseReport');}else{alert('Select Rank');}" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	onclick="location.reload();" accesskey="r" /></form>
</div>




