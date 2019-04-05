<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Naresh
 * Create Date: 5 March,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



<%
	Map<String, Object> map = new HashMap<String, Object>();
	String[] orderStatusMsg = null;
	
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	String voucherType = "";
	String voucherNo = "";
	if(map.get("voucherNo")!= null){
		voucherNo = map.get("voucherNo").toString();
	}
	
	int accountId=0;
	if(map.get("accountId")!= null){
		accountId = (Integer)map.get("accountId");
	}
	
	if(map.get("voucherType1")!= null){
		voucherType = (String)map.get("voucherType1");
	}
	String url  = "";
	if(map.get("url") != null){
		url = (String)map.get("url");
	}
	int f_year_id = 0;
	if(map.get("fyear")!= null){
		f_year_id = (Integer)map.get("fyear");
	}
	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	String voucherDate = "";
	if(map.get("voucherDate") != null){
		voucherDate = (String)map.get("voucherDate");
	}
	int vhId=0;
	if(map.get("vhId") != null){
		vhId = (Integer)map.get("vhId");
	}
	
	%>



<%@page import="java.util.Date"%><form name="msgForVoucher" method="post" action="">
 <label class="value"
	style="FONT-WEIGHT: bold; FONT-SIZE: 11px; COLOR: #F71818; width:98%; text-align: center; float: right; font-family: Verdana, Arial, Helvetica, sans-serif;">
<%=message%> </label> 
 <input id="f_year_id" type="hidden"  name="f_year_id" value="<%=f_year_id %>"   />
 <input id="voucherNoId" type="hidden"  name="voucherNo" value="<%=voucherNo %>"   />
 <input id="accountId" type="hidden"  name="accountId" value="<%=accountId %>"   />
 <input id="vhId" type="hidden"  name="vhId" value="<%=vhId %>"   />

 <input id="voucherTypeId" type="hidden"  name="voucherType" value="<%=voucherType %>"   />
 <input id="voucherDate" type="hidden"  name="voucherDate" value="<%=voucherDate %>"   />

<%if(!(message.equalsIgnoreCase("Try Again!")) && voucherType.equalsIgnoreCase("OP")){%>
<input type="button" name="Print" id="addbutton" value="Yes" class="button" onClick="submitForm('msgForVoucher','account?method=printVoucherReport');" accesskey="a" tabindex=1 />
<input type="button" name="Back" id="addbutton" value="No" class="button" onClick="submitForm('msgForVoucher','<%=url %>');" accesskey="a" tabindex=1 />
<% }%>

</form>
