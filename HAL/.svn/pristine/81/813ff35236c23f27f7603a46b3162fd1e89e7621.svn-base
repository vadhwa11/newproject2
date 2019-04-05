
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForBilling.jsp  
 * Purpose of the JSP -  This is for Billing Message.
 * @author  Ritu
 * Create Date: 4th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Users"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String printUrl = "";
String url = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
int tokenNo=0;
if(map.get("tokenNo") != null){
	tokenNo = (Integer)map.get("tokenNo");
}
int deptId=0;
if(session.getAttribute("deptId")!=null){
	deptId=(Integer)session.getAttribute("deptId");
}
String hinNo="";
if(map.get("hinNo")!=null){
	hinNo=(String)map.get("hinNo");
}
int finalBillId=0;
if(map.get("finalBillId")!=null){
	finalBillId=(Integer)map.get("finalBillId");
}
int receiptHeaderId=0;
if(map.get("receiptHeaderId")!=null){
	receiptHeaderId=(Integer)map.get("receiptHeaderId");
}

%>
<form name="messageBilling" method="post">
<div class="clear"></div>
<%if(deptId==81){ %>
<h4><span><%=message+" and Token No. Generated is:"+tokenNo %></span></h4>
<%}else { %>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>
<%
	if(map.get("printUrl") != null){
		printUrl = (String)map.get("printUrl");
		if(map.get("url") != null){
			url = (String)map.get("url");
		}
		String billType = "";
		if(map.get("billtype") != null){
			billType = (String)map.get("billtype");
		}
		String billNo = "";
		if(map.get("billNo") != null){
			billNo = (String)map.get("billNo");
		}
		String loginName = "";
		Users user = new Users();
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			loginName = user.getLoginName();
		}
%>
<%
	if(billType.equals("servicing") || billType.equals("dispensing") || billType.equals("receipt") ||
		billType.equals("finalBill") || billType.equals("finalBillSettlement") || billType.equals("refunds")
		|| billType.equals("chargeSlip") || billType.equals("detail") || billType.equals("patientDetail"))
	{
%>
		<input type="hidden" name="billNo" id="billNo" value="<%=billNo%>" validate="billNo,metachar,no"/>
		<input type="hidden" name="<%=PRESCRIPTION_SLIP %>" id="prescriptionId" value="p" validate="priscriptionSlip,metachar,no"/>
		<input type="hidden" name="finalBillId" id="finalBillId" value="<%=finalBillId%>" />
		<input type="hidden" name="receiptHeaderId" id="receiptHeaderId" value="<%=receiptHeaderId %>" readonly="readonly" />
		<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('messageBilling','generalMaster?method=generateReportsForBilling');" accesskey="g" tabindex=1 /> -->
	    
	    <!-- <input type="button" name="Report" value="Excel Report" class="buttonBig" 
	    onClick="submitForm('messageBilling','generalMaster?method=generateReportsForBillingExcel');" accesskey="e" tabindex=1 /> --> <!-- commented by Amit Das on 14-03-2016 -->

<%if(deptId==81){ %>
<input type="button" name="yes" value="Yes" class="button"	onclick="printPrescription('<%=hinNo.trim() %>');" />
<%} %>								
		<!--
		<SCRIPT LANGUAGE="JavaScript">
    	var _info = navigator.userAgent; 
    	var _ns = false; 
    	var _ns6 = false;
    	var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
		//</SCRIPT> <COMMENT> <SCRIPT LANGUAGE="JavaScript1.1">
        var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
        var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
		//</SCRIPT> </COMMENT> <SCRIPT LANGUAGE="JavaScript">
    	if (_ie == true) document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH = "300" HEIGHT = "40"  codebase="../applets/jinstall-112-win32.cab#Version=1,1,2,0"><NOEMBED><XMP>');
    	else if (_ns == true && _ns6 == false) document.writeln('<EMBED type="application/x-java-applet;version=1.1.2" CODE = "PrinterApplet.class" CODEBASE = "../applets" ARCHIVE = "jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40" REPORT_URL = "../servlets/jasperprint" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"><NOEMBED><XMP>');
		//</SCRIPT> <APPLET id="appletId" name="appl" CODE="PrinterApplet.class"
		CODEBASE="../applets"
		ARCHIVE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar"
		WIDTH="257" HEIGHT="40"></XMP>
		<PARAM NAME=CODE VALUE="PrinterApplet.class">
		<PARAM NAME=CODEBASE VALUE="../applets">
		<PARAM NAME=ARCHIVE
		VALUE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar">
		<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
		<PARAM NAME="scriptable" VALUE="true">
-->
<%
   		if( billType.equals("finalBill") ||  billType.equals("finalBillSettlement") 
   				|| billType.equals("detail")|| billType.equals("patientDetail") )
   		{
	   		int inpatientId = 0;
	   		if(map.get("inpatientId") != null)
	   		{
		   		inpatientId = (Integer)map.get("inpatientId");
	   		}
%>
			<input type="hidden" name="inpatientId" value="<%=inpatientId %>" validate="inpatientId,int,no">
			<input type="hidden" name="billtype" value="<%=billType %>" validate="billtype,metachar,no">
						
			<!--<PARAM NAME="REPORT_URL"
			VALUE="../servlets/jasperprint?inpatientId=<%=inpatientId %>&billtype=<%=billType %>">
-->
<%
		}
   		else
   		{
%>
			<input type="hidden" name="billNo" value="<%=billNo%>" validate="billNo,metachar,no">
			<input type="hidden" name="billtype" value="<%=billType%>" validate="billtype,metachar,no">
			<input type="hidden" name="loginName" value="<%=loginName%>" validate="loginName,metachar,no">
						
	<!--<PARAM NAME="REPORT_URL"
	<%-- VALUE="../servlets/jasperprint?billNo=<%=billNo %>&loginName=<%=loginName %>&billtype=<%=billType %>"> --%>
-->
<%
		}
%>
		<!--</APPLET> </NOEMBED> </EMBED> </OBJECT>
-->
<%
		}
		else
		{
%>
			 <input type="button" class="button" value="Yes" onclick="<%=printUrl %>" />
			  <%-- <!--  <input type="button" class="button" value="No" onclick="<%=url %>"/>--> --%>
<%
		}
	}
%>

<script>
	function openPopUp()
	{
		var billNo = "";
		billNo = document.getElementById('billNo').value;
		window.open('opBilling?method=showPopUpForReportApplet&billNo='+billNo,'mywindow','target="_blank", width=300,height=10');
	}

	function printPrescription(hinNo1)
	{
		var pr=document.getElementById('prescriptionId').value;
		//alert(hinNo1+"pr--->"+pr);
		submitForm('messageBilling','/hms/hms/registration?method=printRegistrationCard&hinNo='+hinNo1+'&priscriptionSlip='+pr);
	}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>