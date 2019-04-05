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

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
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
	function jsSelData(itemId,pvms,nomenclature) {
	  var count = document.getElementById('count').value
		opener.jsSetUnitData(itemId,pvms,nomenclature,count);
		self.close();
	}
	
	function sub()
	{
	if (itemSearchForm.nomenclature.value == "" && itemSearchForm.pvmsNo.value == "" 
	                             && itemSearchForm.commonName.value == "")
    {
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
		submitForm('itemSearchForm','opd?method=showItemSearchJsp');
	}
	}
	
//-->
</SCRIPT>


<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasStoreItem> masItemList = new ArrayList<MasStoreItem>();
	MasStoreItem masItem = new MasStoreItem();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masItemList")!=null)
			masItemList = (List)map.get("masItemList");
	}
	
%>


	<form name="itemSearchForm" action="" method="post">
		<h4>Item Search</h4>
		   <div class="Block">
		<label>Generic Name</label> 
		<input type="text" class="auto" size="50"  name="nomenclature" value="<%=box.get("nomenclature")%>" />
		<label>Brand Name</label> 
		<input type="text" class="auto" size="50" name="commonName" value="<%=box.get("commonName")%>" />
		<div class="Clear"></div>
		<label>PVMS No.</label> 
		<input type="text" name="pvmsNo" class="auto" size="50" value="<%=box.get("pvmsNo")%>" />
		<!--  <label>&nbsp;</label> -->
		<input type="button" name="Submit" id="addbutton" onClick="sub();" value="Search" class="button" accesskey="a" />
		<input type="hidden" name="SearchFlag" value="true"/>
		<input type="hidden" name="count" id="count" value="<%=box.get("count") %>"/>
		</div>

<div class="Clear paddingTop15"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
 
   <thead>
    <tr>
      
      <th width="52" class="">PVMS No.</th>
      <th width="87" class="">Generic Name</th>
    </tr>
    
  </thead>
  <tbody>
    
<%
String icdNameString ="";
if (masItemList != null && masItemList.size() > 0) { %>
	
	<% for(int i=0;i<masItemList.size();i++)
	{
		masItem = (MasStoreItem)masItemList.get(i);
	%>
	      <tr id="linetblhdr" onmouseover="this.id='sel'" onmouseout="this.id='linetblhdr'" onclick="javascript:jsSelData('<%=masItem.getId()%>','<%=masItem.getPvmsNo()%>','<%=masItem.getNomenclature()%>');">
	         <td height="12"><%=masItem.getPvmsNo()%></td>
			 <td align="left" title="<%=masItem.getCommonName() == null?"No Common Name": masItem.getCommonName()%>" ><%=masItem.getNomenclature()%></td>
			
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
  <div class="Clear"></div>
  
</form>
