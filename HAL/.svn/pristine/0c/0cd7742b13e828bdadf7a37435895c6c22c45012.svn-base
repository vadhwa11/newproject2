
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
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
	List<StoreIndentM> indentList= new ArrayList<StoreIndentM>();
	List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	String choice = "";

	if(request.getAttribute("map") != null)
	{
		map = (Map)request.getAttribute("map");
		if (map.get("choice")!=null)
			
			choice = map.get("choice").toString();
		
		if (choice.equalsIgnoreCase("P"))
		{
			indentList=(List)map.get("second_combo");
		}
		else if (choice.equalsIgnoreCase("A"))
		{
			indentList=(List)map.get("second_combo");
		}
		else if (choice.equalsIgnoreCase("L"))
		{
			poList=(List)map.get("second_combo");
		}
		
	}
%>

<div id=indentDiv>
<%
if (choice.equalsIgnoreCase("A")){
%> 
<label><span>*</span> Indent No</label> 

<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo"
	onchange="submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');" tabindex=1>
	<option value="0">Select</option>
	<% for (StoreIndentM indentList1 : indentList)  {   %>
	<option value="<%=indentList1.getId()%>"><%=indentList1.getIndentNo()%></option>
	<%}%>
</select>
 
<%}else if (choice.equalsIgnoreCase("L")){ %> 
<label><span>*</span> SO No.</label>
<select	name="<%=RequestConstants.INDENT_ID %>" id="indentCombo"
	onchange="submitProtoAjaxforATSODate('grnGrid','/hms/hms/stores?method=responseGridList');loanAdjustment(this.value);"" tabindex=1> 
	
	<option value="0">Select</option>
	<% for (StorePoHeader storePoHeader : poList)
		  	   {   %>
	<option value="<%=storePoHeader.getId()%>"><%=storePoHeader.getPoNumber()%></option>
	<% } %>
	</select> 
	<input type="hidden" name="item_id" id="item_id" value="" /> 
	<input type="hidden" name="temp" id="temp" value="" /> <input type="hidden"
	name="adloanIn" id="adloanIn" value="No" /> 
	<input type="hidden" name="loanInStatus" id="loanInStatus" value="" />
	
<div id="adjust" style="display: none;"><input type="button"
	name="loanInAd" id="loanInAd" align="right" class="button"
	onblur="jsGetGrid();" value="Adjust LoanIn.." onclick="adjustment();" />
</div>
<div id="soItem" style="display: none;">
<input type="button" name="details" id="details" align="right" class="buttonBig2" onblur="" value="Import Supplier Order" onclick="getsoitems();" /></div>
<% }
else if (choice.equalsIgnoreCase("P")){%>
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" id="indentCombo"> 

<%}else if (choice.equalsIgnoreCase("G")){%>
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" id="indentCombo"> 
<%}%>
</div>
