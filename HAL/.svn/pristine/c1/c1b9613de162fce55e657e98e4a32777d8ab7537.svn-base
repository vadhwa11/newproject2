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

<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.MasTrade"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(tradeId) {
		opener.jsSetTradeData(tradeId);
		self.close();
	}
	
	function sub()
	{
	if (unitSearchForm.trade_name.value=="")
    {
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
		submitForm('unitSearchForm','adt?method=showTradeSearchJsp');
	}
	}
	
//-->
</SCRIPT>

<title> Unit Name Search </title>

<style type="text/css">
<!--
	BODY
	{
	    MARGIN-TOP:0px;
	    MARGIN-BOTTOM:0px;
	    MARGIN-LEFT:0px;
	    MARGIN-RIGHT:0px;
	}
	.schInput
	{
	    BACKGROUND-COLOR: #ffffff;
	    BORDER-BOTTOM: #bfbfbf 1px solid;
	    BORDER-LEFT: #bfbfbf 1px solid;
	    BORDER-RIGHT: #bfbfbf 1px solid;
	    BORDER-TOP: #bfbfbf 1px solid;
	    COLOR: #4a4a4a;
	    FONT-FAMILY: Arial;
	    FONT-SIZE: 11px;
		height:15px;
	}
	#linetblhdr
	{
	    BACKGROUND-COLOR: #EBE7E7;
	    BORDER-BOTTOM: #d1bfe8 1px solid;
	    BORDER-LEFT: #d1bfe8 1px solid;
	    BORDER-RIGHT: #d1bfe8 1px solid;
	    BORDER-TOP: #d1bfe8 1px solid;
	    COLOR: #000000;
	    FONT-FAMILY: Verdana,Arial, Helvetica, sans-serif;
	    FONT-SIZE: 8pt;
		font-weight:400;
	    MARGIN: 1px;
		vertical-align:middle;
		cursor:hand
	}
	#sel
	{
	    BACKGROUND-COLOR: #CAE7EF;
	    FONT-FAMILY: Verdana,Arial, Helvetica, sans-serif;
	    FONT-SIZE: 8pt;
		cursor:hand
	}
-->
</style>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasTrade> masTradeList = new ArrayList<MasTrade>();
	MasTrade masTrade = new MasTrade();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masTradeList")!=null)
			masTradeList = (List)map.get("masTradeList");
	}
	
%>


<div id="contentHolder">
	<form name="unitSearchForm" action="" method="post">
		<div class="blockTitle">Trade Name Search</div><div class="blockTitleCurve"></div>
		<div class="Clear"></div>
		   <div class="blockFrameSm">
		<label>Trade Name</label> 
		<input type="text" name="trade_name" value="<%=box.get("trade_name")%>" />
		<input type="button" name="Submit" id="addbutton" onClick="sub();" value="Search" class="button" accesskey="a" />
		<input type="hidden" name="SearchFlag" value="true"/>
		</div>

<div class="Clear"></div>
<div style="height:500px;" class="tableHolderPopup">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
 
   <thead>
    <tr>
      
      <th width="52" class="">Trade Name</th>
    </tr>
    
  </thead>
  <tbody>
    
<%
String icdNameString ="";
if (masTradeList != null && masTradeList.size() > 0) { %>
	
	<% for(int i=0;i<masTradeList.size();i++)
	{
		masTrade = (MasTrade)masTradeList.get(i);
	%>
	      <tr id="linetblhdr" onmouseover="this.id='sel'" onmouseout="this.id='linetblhdr'" onclick="javascript:jsSelData('<%=masTrade.getId()%>');">
	         <td height="12"><%=masTrade.getTradeName()%></td>
			
	      </tr>
	<%
	}
	%>
<% } 
	else
	{
	%>
	      <tr>
	      <td height="16" colspan=6 align="center"> No Data Found </td>
	      </tr>
 <% } %>
 </tbody>
 </table>
  
  
</div>
</form>
</div>
