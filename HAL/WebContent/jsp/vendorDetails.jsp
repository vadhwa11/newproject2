<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : VendorDetails.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 29.05.2009    Name: Kalyan Chakravarthy.L   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(supplierId) {
		opener.jsSetSupplierData(supplierId);
		self.close();
	}
	
	function sub()
	{
	if (supplierSearchForm.supplier_name.value=="")
    {
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
		submitForm('supplierSearchForm','stores?method=getvendorDetails');
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
	List<MasStoreSupplier> masSupplierList = new ArrayList<MasStoreSupplier>();
	MasStoreSupplier masSupplier = new MasStoreSupplier();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masSupplerList")!=null)
			masSupplierList = (List)map.get("masSupplerList");
	}
	
%>
<form name="supplierSearchForm" action="" method="post">
<div class="titleBg"><h2>Vendor</h2>
<div class="clear"></div>
<div class="Block">
<label>Vendor Name</label>
<input type="text"	name="supplier_name" value="<%=box.get("unit_name")%>"/>
<input type="button" name="Submit" id="addbutton" onClick="sub();" value="Search"	class="button" accesskey="a" /> <input type="hidden" name="SearchFlag"	value="true" /> 
</div>
<table width="100%" border="0" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th width="52" >Vendor Name</th>
			<th width="87">Vendor Address</th>
		</tr>

	</thead>
	<tbody>

		<%
if (masSupplierList != null && masSupplierList.size() > 0) { %>

		<% for(int i=0;i<masSupplierList.size();i++)
	{
		masSupplier = (MasStoreSupplier)masSupplierList.get(i);
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"	onmouseout="this.id='linetblhdr'"	onclick="javascript:jsSelData('<%=masSupplier.getId()%>');">
			<td height="12"><%=masSupplier.getSupplierName()%></td>
			<%if (masSupplier.getAddress1() != null && ! masSupplier.getAddress1().equals("") && masSupplier.getAddress2() != null && ! masSupplier.getAddress2().equals("")){ %>
			<td><%=masSupplier.getAddress1()  +" "+masSupplier.getAddress2()%></td>
			<%}else{ %>
			<td>-</td>
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
</form>

