
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * messageForADT.jsp  
	 * Purpose of the JSP -  This is for ADT Message.
	 * @author  Ritu
	 * Create Date: 14th Jan,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.4
	--%>

<div class="clear"></div>

<div class="clear"></div>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	int referralPatientDetailsId = 0;
	
	boolean flagForVisitSearch = false;
	List<Visit> visitList = new ArrayList<Visit>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("referralPatientDetailsId") != null){
		referralPatientDetailsId = (Integer)map.get("referralPatientDetailsId");
	}
	String flag = "";
	String referralTreatmentType = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	if(map.get("referralTreatmentType") != null){
		referralTreatmentType = map.get("referralTreatmentType").toString();
	}
	
	 
	
	

	%>

<form name="messageAdt" method="post">
<h4><%=message %></h4>
<div class="Clear"></div>



<div class="clear"></div>

<input type="button" name="yes" value="Print Referral Note"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId %>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" />
<input type="button" name="yes" value="Next Extension" class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=extensionWaitingList');" />



<input name="Send" type="button" style="display:none" class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" />

<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
</form>


<script type="text/javascript">
<%-- function openPopupWindow()
{
	var hinNo = document.getElementById('hinNo').value;
	var serviceNo = document.getElementById('serviceNo').value;
	var url="/hms/hms/registration?method=displayRegisPhoto&hinNo=<%=hinNo%>&serviceNo="+serviceNo;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
} --%>

</script>
<%@ include file="footer.jsp"%>