
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreSupplier> searchMasStoreSupplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("searchMasStoreSupplierList")!=null)
		searchMasStoreSupplierList = (List) map.get("searchMasStoreSupplierList");
		
%>
<form name="vendor" method="post" action=""><br />
<div class="titleBg">
<h2>Vendor List </h2>
</div>
<div class="Block">
<label>Vendor List </label> 
<select
	name="<%=VENDOR_NAME%>" validate="Vendor,String,no">
	<option value=0>All Vendors</option>
	<%
				for (MasStoreSupplier masStoreSupplier :searchMasStoreSupplierList ) {
				
				%>
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%>
	</option>
	<%	}				%>
</select>  
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" 
		onClick="submitForm('vendor','stores?method=generateVendorReport');" accesskey="a" tabindex=1 />
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button"
	onClick="submitForm('vendor','stores?method=showVendorReportJsp');"
	accesskey="a" tabindex=1 />
	
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>