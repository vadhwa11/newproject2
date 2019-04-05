
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
	Map<String, Object> map1 = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	String adNo = "";
	String backUrl = "";
	String hin_no = "";
	String serviceNo = "";
	int visit_id = 0;
	boolean flagForVisitSearch = false;
	List<Visit> visitList = new ArrayList<Visit>();
	if(request.getAttribute("map") != null){
		map1 = (Map<String, Object>)request.getAttribute("map");
	}
	if(map1.get("message") != null){
		message = (String)map1.get("message");
	}
	if(map1.get("formName") != null){
		formName = (String)map1.get("formName");
	}
	String url = "";
	if(map1.get("url") != null){
		url = (String)map1.get("url");
	}
	String referral_patient_header_id="";
	if(map1.get("referral_patient_header_id") != null){
		referral_patient_header_id = map1.get("referral_patient_header_id").toString();
	}
	String consolidatedNo="";
	if(map1.get("consolidatedNo") != null){
		consolidatedNo = map1.get("consolidatedNo").toString();
	}
	String flag="";
	if(map1.get("flag") != null){
		flag = (String)map1.get("flag").toString();
	}
	
	int referralClarrificationHeaderId=0;
	if(map1.get("referralClarrificationHeaderId") != null){
		referralClarrificationHeaderId = Integer.parseInt(map1.get("referralClarrificationHeaderId").toString());
	}
	
	

	%>

<form name="messageAdt" method="post">
<h4><%=message %></h4>
<div class="Clear"></div>

<input id="hinNo" value="<%=hinNo %>" name="hinNo" type="hidden"/>
<input id="serviceNo" value="<%=serviceNo %>" name="serviceNo" type="hidden"/>

<div class="clear"></div>

<%-- <input type="button" name="yes" value="Print Referral Note"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=printReferralNote&referralPatientDetailsId=<%=visit_id %>&priscriptionSlip=o');" /> --%>
<input type="button" name="yes" value="Next" class="button"	onclick="submitForm('messageAdt','<%=url%>');" />

<%if(flag.equals("Dispatch_letter")) 
{%>
 <input type="button" name="yes" value="Generate Dispatch Letter"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=showReferralReport&flag=Dispatch_letter&consolidatedNo=<%=consolidatedNo%>');" />
<%}
else if(flag.equals("Note_sheet_letter")) 
{%>
 <input type="button" name="yes" value="Generate Note Sheet"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=showReferralReport&flag=Note_sheet_letter&consolidatedNo=<%=consolidatedNo%>');" />
<%}else if(flag.equals("Divisional_approval_letter")) 
{%>
 <input type="button" name="yes" value="Generate Divisional Approval Letter"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=showReferralReport&flag=Divisional_approval_letter&consolidatedNo=<%=consolidatedNo%>');" />
<%} else if(!referral_patient_header_id.equals("")) 
{%>
<input type="button" name="yes" value="Print Covering Letter"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=showReferralReport&flag=covering_letter&referral_patient_header_id=<%=referral_patient_header_id%>');" />
<%} %>
<%if(referralClarrificationHeaderId!=0) 
{%>
 <input type="button" name="yes" value="Print Clarification Letter"	class="button"	onclick="submitForm('messageAdt','/hms/hms/referral?method=generateClarrificationReport&clarrificationHeaderId=<%=referralClarrificationHeaderId%>');" />
<%}%>


<input type="hidden" name="<%=VISIT_NUMBER%>" id="<%=VISIT_NUMBER%>"	value="<%= visit_id%>" />

<input name="Send" type="button" style="display:none" class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" />

<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
</form>


<script type="text/javascript">
function openPopupWindow()
{
	var hinNo = document.getElementById('hinNo').value;
	var serviceNo = document.getElementById('serviceNo').value;
	var url="/hms/hms/registration?method=displayRegisPhoto&hinNo=<%=hinNo%>&serviceNo="+serviceNo;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

</script>
<%@ include file="footer.jsp"%>