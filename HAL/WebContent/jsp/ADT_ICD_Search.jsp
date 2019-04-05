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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>

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


<form name="ICDSearchForm" action="" method="post">
<input	type="hidden" name="search" id="search" value="<%=search%>">
<div class="titleBg"><h2>ICD Search</h2></div>
<div class="Block">
<label>ICD Name</label>
<input type="text"	name="icd_name" value="<%=box.get("icd_name")%>"  maxlength="10"/>
<input type="button" name="Submit"	id="addbutton" onClick="sub();" value="Search" class="button"	accesskey="a" /> <input type="hidden" name="SearchFlag" value="true" />
</div>
<div class="clear paddingTop15"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0">

		<tr>

			<th width="52" class="gridheaderlabel">ICD Code</th>
			<th width="87" class="gridheaderlabel">ICD Name</th>
		</tr>

	


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

</table>


</form>

