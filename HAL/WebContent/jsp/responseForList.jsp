<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
 var flag;
 </script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<MasStoreSupplier> supplierListForPurchase = new ArrayList<MasStoreSupplier>();
	List<MasStoreAirForceDepot> unitListForAfmsd = new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreAirForceDepot> unitList= new ArrayList<MasStoreAirForceDepot>();
	List<MasUnit> masUnitList= new ArrayList<MasUnit>();
	
	
	String choice="";
	if(map.get("choice") != null)
	{
	choice=(String)map.get("choice");		
	}
	if (choice.equalsIgnoreCase("p1"))
	{
		supplierList=(List)map.get("first_combo");
		indentList = (List)map.get("second_combo");
	}else if (choice.equalsIgnoreCase("a")||choice.equalsIgnoreCase("i"))
	{
		unitList  = (List) map.get("first_combo");	
	}
	else if (choice.equalsIgnoreCase("p"))
	{
		masUnitList  = (List) map.get("first_combo");
	}
	else 
	{
		supplierList=(List)map.get("first_combo");
	}
%>
<div id=suppDiv>
<%
	if (choice.equalsIgnoreCase("P")){%>
	<label >Unit Name</label>
	<select name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo" validate="Unit Name, String ,yes" onchange="submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridForList');"  tabindex=1>
			<option value="">Select</option>
			<% for (MasUnit unit : masUnitList){%>
			<option value="<%=unit.getId ()%>"><%=unit.getUnitName()%></option>
		   <%}%>
	</select>
	<!--<script>
			submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseIndentList');
	</script> 
	-->
	<%}else if (choice.equalsIgnoreCase("L"))
	{%>
		<label>Vendor Name</label>
		<select	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"	validate="Vendor Name, String ,yes" onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseIndentList');" tabindex=1>
		<option value="">Select</option>
		<%for (MasStoreSupplier masStoreSupplier1 : supplierList)
	  	   {%>
		<option value="<%=masStoreSupplier1.getId ()%>"><%=masStoreSupplier1.getSupplierName()%></option>
		<%}%>
		</select> 
<% 
}else if (choice.equalsIgnoreCase("A")) 
{
	System.out.println("A");
	%>
<label >Depot Name</label>
<select name="<%=RequestConstants.SUPPLIER_ID %>"	id="supplierCombo" validate="Unit Name, String ,yes"
	onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseIndentList');"
	tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {   %>
	<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
	<% } %>
</select> 
<% } else if (choice.equalsIgnoreCase("G")) { %>
<label >Other Gov. Source</label>
<input type="text" name="Other_unit" onclick="submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseIndentList');submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridForList');"/ >
<% } 
else {%>
<label >Unit Name</label>
<select	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo" 	validate="Unit Name, String ,yes"  onchange="submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');" tabindex=1>
		<option value="">Select</option>
		<% for (MasStoreAirForceDepot unit : unitList)
		  	   {   %>
		<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
		<% } %>
</select> <% } %>

<!-- -



// else if (choice.equalsIgnoreCase("W")) { %> <label >Vendor
Name</label> <select name="<%=RequestConstants.SUPPLIER_ID %>"
	id="supplierCombo" validate="Vendor Name, String ,yes" onchange=""
	tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier1 : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier1.getId ()%>"><%=masStoreSupplier1.getSupplierName()%></option>
	<% } %>
</select> 
<% //} else if (choice.equalsIgnoreCase("I")) { %> <label >Unit
Name</label> <select name="<%=RequestConstants.SUPPLIER_ID %>"
	id="supplierCombo" validate="Unit Name, String ,yes" onchange=""
	tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {   %>
	<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
	<% } %>
</select> <%// } else if (choice.equalsIgnoreCase("O")) {%>
<table width="30%">
	<tr>
		<td><label >Unit Name</label> <select
			name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
			onClick="civgrid(this.value);" validate="Unit Name, String ,yes"
			tabindex=1>
			<option value="">Select</option>
			<% for (MasUnit unit : masUnitList)
	  	   {   %>
			<option value="<%=unit.getId ()%>"><%=unit.getUnitName()%></option>
			<% } %>
		</select>
		</td>
		<td><IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26"
			HEIGHT="26" style="cursor: pointer;"
			onClick="javascript:openPopupWindowForUnit();"
			title="Click here to Search Unit"></td>
	</tr>
</table>
 -->
</div>

