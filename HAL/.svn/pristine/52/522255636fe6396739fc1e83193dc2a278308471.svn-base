
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
	if(map1.get("backUrl") != null){
		backUrl = (String)map1.get("backUrl");
	}
	if(map1.get("flagForVisitSearch") != null){
		flagForVisitSearch = (Boolean)map1.get("flagForVisitSearch");
	}
	List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
	if (map1.get("userRightsList") != null) {
		userRightsList = (List<UserButtonRights>)map1.get("userRightsList") ;
	}
	if(map1.get("visitList")!= null){
		visitList = (List<Visit>)map1.get("visitList");
	}
	
	if(map1.get("visit_id")!= null){
		visit_id = (Integer)map1.get("visit_id");
	}
	

	if(map1.get("serviceNo") != null){
		serviceNo = (String)map1.get("serviceNo");
	}

	%>
<script type="text/javascript">
	function checkvisit(){
	var visit_No =  '<%=visit_id%>'
	
	if(visit_No == 0 ){
	alert("Visit not created. please create the visit!");
	return false; 
	}
	return true;
	}
	</script>
<form name="messageAdt" method="post">
<div class='Block'><div style="float: left; width:850px;"><%=message %></div></div>
<div class="Clear"></div>


<%
		if(map1.get("hinNo") != null){
			hinNo = (String)map1.get("hinNo");
		}
int hinId=0;
if(map1.get("hinId") != null){
	hinId = (Integer)map1.get("hinId");
}


	%>

<div class="clear"></div>

<input type="hidden" name="<%=VISIT_NUMBER%>" id="<%=VISIT_NUMBER%>"	value="<%= visit_id%>" />
<input type='button' name='yes' value='Print Token Card' class='button'	onclick="openWindow('/hms/hms/registration?method=printTokenCard&visit_id=<%=visit_id%>&priscriptionSlip=o')"/>

	<input type="button" name="createVisit" value="Next Referral"	class="buttonBig"
	onclick="submitForm('messageAdt','/hms/hms/registration?method=showPatientVisitReferralJsp','checkTargetForNo');" />



	

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