<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<script>
 var flag;
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasStoreAirForceDepot> unitForAfmsdList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreAirForceDepot> unitList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
	List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StoreIndentM> indentList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	List<StoreIndentM> indentMList= new ArrayList<StoreIndentM>();
	String choice="";
	if(map.get("choice") != null)
	{
	choice=(String)map.get("choice");		
	}	

	if (choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("c"))
	{
		supplierList=(List)map.get("first_combo");
	}
	else if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d"))
	{
		unitList  = (List) map.get("first_combo");	
	}
	
	else if(choice.equalsIgnoreCase("m"))
	{
		supplierList=(List)map.get("first_combo");
	}
	
	
	if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d"))
	{
		indentMList=(List)map.get("indentMList");
	}
%>

<div id=suppDiv>
<%
	//if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d"))
	if (choice.equalsIgnoreCase("a"))
	{ %> <label>Unit Name</label>
 <select name="UnitName" id="supplierCombo"
	validate="Unit Name, String ,yes"
	onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/neStores?method=responseIndentList');">
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {   %>
	<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
	<% } %>
</select>

<div id=indentDiv>
<label>Indent No</label>
<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo">
<option value="0">Select</option>
</select>
</div>

<%} %>

<% // add by javed khan
	if ( choice.equalsIgnoreCase("d"))
	{ %> <label>Other Sources</label>
 <input type="text"name="Other" id="Other"
		 MAXLENGTH="15" tabindex=1 /> 
<%} %>
<%  if(choice.equalsIgnoreCase("b"))
	{ %>
<label>Vendor Name<span>*</span></label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
	validate="Vendor Name, String ,yes" onchange="getSupplierNo(this.value);">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<% } %>
</select> 
<div id=suppNoDiv>
<label>SO No.</label>
<select name="supplierName" id="supplierId">
<option value="0">Select</option>
</select>
</div>


<%} %>


<%  if(choice.equalsIgnoreCase("c"))
	{ %>
<label>Vendor Name<span>*</span></label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
	validate="Vendor Name, String ,yes" onchange="getSOItemsForDGAFMS()">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<% } %>
</select> 
<div id=suppNoDiv>
<label>AT/SO No.</label>
<input type="text"name="SO_No" id="SO_No"
		 MAXLENGTH="15" tabindex=1 />
		
</div>
	
		
	
<%} %>


<% if (choice.equalsIgnoreCase("m") )
	{ %>
<label>Vendor Name</label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
	validate="Vendor Name, String ,yes">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<% } %>
</select> 



<%} %>


<%--
<%if(choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")) {%>
<label>Vendor Name</label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="indentCombo" tabindex=1 onchange="getgridItemForIndent(this.value);" disabled="disabled">
	<option value="0">Select</option>
	
</select>
<label>Indent No</label> <select
	name="<%=RequestConstants.INDENT_ID %>" id="indentCombo" tabindex=1 onchange="getgridItemForIndent(this.value);">
	<option value="0">Select</option>
	<%for(StoreIndentM storeIndentM:indentMList){ %>
	<option value="<%=storeIndentM.getId()%>" ><%=storeIndentM.getIndentNo()%></option>
<%} %>
</select>

<%} %>
 --%>
</div>
