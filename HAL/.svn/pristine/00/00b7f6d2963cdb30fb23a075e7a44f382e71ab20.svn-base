
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
	if (map.get("subLedgerList") != null) {
		subLedgerList = (List) map.get("subLedgerList");
	}
	int accountSubGroupId=0;
	if(map.get("accountSubGroupId")!=null){
		accountSubGroupId=(Integer)map.get("accountSubGroupId");
	}
	
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int subGroupIdForPayment = 0;
		subGroupIdForPayment = Integer.parseInt(properties.getProperty("subGroupIdForPayment"));
		if(subGroupIdForPayment==accountSubGroupId){
				%>
<div id="checkNoDiv" >
<%if(subLedgerList.size()>0){%>
	<label class="medium">Sub Ledger<span>*</span></label>
	<select id="subLedId"   name="subLedId" style="width:265px;" onchange="showCrBalanceInAjax('paymentVoucher');" validate="Sub Ledger,String,yes" tabindex="1" >
	<option value="0">Select</option>
<%
	for(FaMasSubLed faMasSubLed :subLedgerList){
	%>
<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSubLedDesc() %></option>
<%}%>
</select>
<%}%>

<label>Cheque No/D.D No/Pay-in Slip/Challan</label>
<input type="text" name="checkNo" validate="Check No.,string,no" id="checkNoId" value="" />

</div>
<%}%>