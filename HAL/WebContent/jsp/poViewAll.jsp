<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poViewAll.jsp  
 * Purpose of the JSP -  This is for PO View All the Details .
 * @author  Deepti
 * Create Date: 22nd Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.6
--%>


<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSupplier"%>
<%@page import="jkt.hms.masters.business.PoDetail"%>
<%@page import="jkt.hms.masters.business.PoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">




<%
Map map = new HashMap();
String includedJsp="";
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	
}


List<MasSupplier> supplierList= new ArrayList<MasSupplier>();
List<PoDetail> poDetailList = new ArrayList<PoDetail>();
List<PoHeader> poHeaderList = new ArrayList<PoHeader>();


try{
	supplierList = (List)map.get("supplierList");
	poDetailList = (List)map.get("poDetailList");
	poHeaderList = (List)map.get("poHeaderList");
	
	
}catch(Exception exp){
	out.println("-------------------------------------------"+exp);
	exp.printStackTrace();
	}
System.out.println("poDetailList in jsp-----------    "+poDetailList.size());
System.out.println("supplierList in jsp --------   "+supplierList.size());
System.out.println("poHeaderList in jsp --------   "+poHeaderList.size());


String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

%>
<div id="contentspace"><br />


<div id="searcharea">
<form name="viewPo" method="post" action=""><label
	class="bodytextB_blue">Search PO By:</label> <select
	name=<%=RequestConstants.ACCESS_RIGHTS%> id="hospId">
	<option value="0">--Select--</option>
	<option value="0">--By Date:--</option>
	<option value="0">--By P.O No:--</option>
	<option value="0">--By Store Wise:--</option>
	<option value="0">--By Manufacturer:--</option>
</select> <br />
<label class="bodytextB_blue">From Date :</label> <input type="text"
	name="<%= RequestConstants.TO_DATE %>" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1 /> <label class="bodytextB_blue">To
Date :</label> <input type="text" name="<%= RequestConstants.TO_DATE %>"
	class="textbox_size20" MAXLENGTH="30" / tabindex=1 /> <label
	class="bodytextB_blue">Store Code Wise :</label> <input type="text"
	name="<%= RequestConstants.STORE_CODE_WISE %>" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1 /> <br />
<label class="bodytextB_blue">P.O.No:</label> <select
	name="<%=RequestConstants.PO_NO%>">
	<option value="0">Select</option>
	<%  for (PoDetail poDetail : poDetailList){
				%>

	<option value=<%=poDetail.getPoNumber()%>><%=poDetail.getPoNumber()%></option>

	<%}%>
</select> <label class="bodytextB_blue">Supplier Name:</label> <select
	name=<%=RequestConstants.SUPPLIER_ID%> id="supplierId">
	<option value="0">--Select--</option>
	<%  for (MasSupplier masSupplier : supplierList){
				%>

	<option value=<%=masSupplier.getId()%>><%=masSupplier.getSupplierName()%></option>

	<%}%>
</select> <input type="button" name="search" id=" " value="Submit" class="button"
	onClick="submitProtoAjax('viewPo','purchaseOrder?method=searchPO');"
	accesskey="a" tabindex=1 /></form>

</div>

<br />
<jsp:include page="searchResultPO.jsp" />


<div></div>

<label>&nbsp;</label> <label>&nbsp;</label><label>&nbsp;</label> <label>&nbsp;</label>
<label>&nbsp;</label> <label class="bodytextB_blue">Net Amount :</label>
<input type="text" name="<%= RequestConstants.TO_DATE %>"
	class="textbox_size20" MAXLENGTH="30" / tabindex=1 />



<div id="statusMessage"></div>


</form>
</div>
