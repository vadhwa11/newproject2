<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String,Object> map = new HashMap<String,Object>();	
    if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
    String pvmsNo="";
    pvmsNo=(String)map.get("pvmsNo");
	String auNo="";
	auNo=(String)map.get("auNo");
	List<StoreItemBatchStock> serialNoList= new ArrayList<StoreItemBatchStock>();
	if(map.get("serialNoList")!=null)
		serialNoList = (List) map.get("serialNoList");
	String serialNo="";
	serialNo=(String)map.get("serialNo");
	System.out.println("serial NO>>>>>in search jsp"+serialNo);
%>



<div id="pvmsDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="left"><label class="bodytextBNoWidth">Serial
		No :</label></td>
		<td align="left"><select
			name="<%=RequestConstants.SERIAL_NUMBER%>" class="bigselect"
			onchange="submitProtoAjaxDynamic('amcRepair','neStores?method=getSerialNoAmcRepairDetail',crvDiv)">
			<option value="">Select</option>
			<%
			  	for (StoreItemBatchStock storeItemBatchStock:serialNoList ){
			  	
		  	 %>
			<option value="<%=storeItemBatchStock.getBatchNo()%>"><%=storeItemBatchStock.getBatchNo()%></option>
			<% } %>
		</select> <%
                   if (serialNo !="") {
                %> <script>
                 	   document.amcRepair.<%=RequestConstants.SERIAL_NUMBER %>.value =<%=serialNo%>
    			</script> <%
                 }
                 %>
		</td>
		<td width="25%" align="left">&nbsp;</td>
		<td width="26%" align="left">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" align="left" height="10"></td>
	</tr>
	<tr>
		<td width="26%" align="left"><label class="bodytextBNoWidth">PVMS/NIV
		:</label></td>
		<td width="23%" align="left"><input type="text"
			name=<%=RequestConstants.PVMS_NO%> class="textbox_size20"
			value="<%=pvmsNo%>" readonly style="width: 200px" /></td>
		<td align="left"><label class="bodytextBNoWidth">A/U No.
		:</label></td>
		<td align="left"><input type="text"
			name="<%=RequestConstants.AU%>" value="<%=auNo%>"
			class="textbox_size20" readonly="readonly" style="width: 200px;" /></td>
	</tr>
	<tr>
		<td height="10"></td>
		<td align="left"></td>
		<td align="left"></td>
		<td align="left"></td>
	</tr>
</table>

<div class="Clear"></div>
</div>
