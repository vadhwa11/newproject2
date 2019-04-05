<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>

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
	function jsSelData(hinNo) {
	var search = document.getElementById('search').value;
	 if(search == "n"){
		opener.jsSetIcdData(hinNo);
		self.close();
	  }
		
	}
	
	function sub()
	{
	var search = document.getElementById('search').value;
	if (ICDSearchForm.icd_name.value=="")
    {
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
	    if(search == "n"){
		submitForm('ICDSearchForm','adt?method=showICDSearchJsp');
		}else{
		submitForm('ICDSearchForm','adt?method=showICDSearchJsp&search=y');
		}
	}
	}
	
//-->
</SCRIPT>

<title>ICD Search</title>

<style type="text/css">
<!--
BODY {
	MARGIN-TOP: 0px;
	MARGIN-BOTTOM: 0px;
	MARGIN-LEFT: 0px;
	MARGIN-RIGHT: 0px;
}

.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasIcd> masIcdList = new ArrayList<MasIcd>();
	MasIcd masIcd = new MasIcd();
	String search = "";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masIcdList")!=null){
			masIcdList = (List)map.get("masIcdList");
		}
		
		if (map.get("search")!=null){
			search = (String)map.get("search");
		}
		
	}
	
%>


<div id="contentspace"><br />
<form name="ICDSearchForm" action="" method="post"><input
	type="hidden" name="search" id="search" value="<%=search%>">

<div style="padding-left: 15px;">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">ICD Search</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 760px; height: 85px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />


<label class="bodytextB">ICD Name</label> <input type="text"
	name="icd_name" value="<%=box.get("icd_name")%>" class="textbox_size20"
	style="width: 300px" /> <input type="button" name="Submit"
	id="addbutton" onClick="sub();" value="Search" class="button"
	accesskey="a" /> <input type="hidden" name="SearchFlag" value="true" />
<br />
</div>
</div>

<br />


<br />
<br />




<div style="overflow: scroll; width: 780px; height: 500px;">
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">

	<thead>
		<tr>

			<td width="52" class="gridheaderlabel">ICD Code</td>
			<td width="87" class="gridheaderlabel">ICD Name</td>
		</tr>

	</thead>
	<tbody>

		<%
String icdNameString ="";
if (masIcdList != null && masIcdList.size() > 0) { %>

		<% for(int i=0;i<masIcdList.size();i++)
	{
		masIcd = (MasIcd)masIcdList.get(i);
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:jsSelData('<%=masIcd.getIcdCode()%>');">
			<td height="12"><%=masIcd.getIcdCode()%></td>
			<%if(masIcd.getIcdSubCategory() !=null){
	        	 icdNameString= masIcd.getIcdSubCategory().getIcdSubCategoryName()+":"+masIcd.getIcdName();
	        	 %>
			<td align="left" title="<%=icdNameString.toUpperCase()%>"><%=icdNameString.toUpperCase()%></td>
			<%}else{ %>
			<td align="left" title="<%=icdNameString.toUpperCase()%>"><%=masIcd.getIcdName().toUpperCase()%></td>
			<%} %>
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
</div>
</form>
</div>
