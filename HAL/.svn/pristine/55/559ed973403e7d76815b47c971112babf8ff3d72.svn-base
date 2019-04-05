<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>

<%@page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>

<%
	Map map = new HashMap();
	BigDecimal chargeAmountAfterDis = new BigDecimal("0");
	boolean flag = false;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
	if (map.get("subLedgerList") != null) {
		subLedgerList = (List) map.get("subLedgerList");
	}
	
	String rowVal = "";
	if (map.get("rowVal") != null) {
		rowVal = (String) map.get("rowVal");
	}
	int accountId = 0;
	if (map.get("accountId") != null) {
		accountId = (Integer) map.get("accountId");
	}
	int groupId = 0;
	int subGroupId = 0;
	if (map.get("groupId") != null) {
		groupId = (Integer) map.get("groupId");
	}
	if (map.get("subGroupId") != null) {
		subGroupId = (Integer) map.get("subGroupId");
	}
	BigDecimal closingBalance = new BigDecimal(0.0);
	if (map.get("closingBalance") != null) {
		closingBalance = (BigDecimal) map.get("closingBalance");
	}
	

%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%
BigDecimal amt = new BigDecimal(0.00);
if(subLedgerList.size()>0){
%>
<select id="resrate<%=rowVal %>"   name="<%=SUB_LEDGER_CODE%><%=rowVal%>" style="width:300px;"  tabindex="1" >
<option value="0">Select</option>
<%
	for(FaMasSubLed faMasSubLed :subLedgerList){
	%>
<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSubLedDesc() %></option>
<%}%>
</select>
<%}else{ %>
 <input  type="text"  name="<%=SUB_LEDGER_CODE%><%=rowVal%>" value="" readonly="readonly" size="40"  />
<%} %>

<input id="accountId<%=rowVal%>" type="hidden"   name="accountId<%=rowVal%>" value="<%=accountId %>"  />
<input id="groupId<%=rowVal%>" type="hidden"   name="groupId<%=rowVal%>" value="<%=groupId %>"  />
<input id="subGroupId<%=rowVal%>" type="hidden"   name="subGroupId<%=rowVal%>" value="<%=subGroupId %>"  />

<script language="text/javascript">
document.getElementById('accountNameId<%=rowVal%>').setAttribute('title','<%=closingBalance%>');
</script>


