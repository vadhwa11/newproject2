
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
<%-- <%@ include file="header_camera.jsp"%> --%>

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
	String controllerFlag = "";
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
	
/* 	for(Visit visit : visitList){
		hin_no = visit.getHin().getHinNo();
		visit_id = visit.getId();
	} */
	if(map1.get("serviceNo") != null){
		serviceNo = (String)map1.get("serviceNo");
	}
	List<Patient> existingHinNoList = new ArrayList<Patient>();
	if (map1.get("existingHinNoList") != null) {
		existingHinNoList = (List<Patient>) map1.get("existingHinNoList");
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
<h4><%=message %></h4>
<div class="Clear"></div>

<!--<label>Prescription Slip</label> 
<input type="radio" id="opdPrint" name="<%=PRESCRIPTION_SLIP %>" checked="checked" value="p" tabindex="1" class="radio" />
<div class="Clear"></div>
--><!--<label>Medical Case Sheet</label> 
<input type="radio"	id="opdPrint" name="<%=PRESCRIPTION_SLIP %>" value="m" tabindex="1"	class="radio" />
<div class="Clear"></div>
-->

<!--<label>Consent Form</label> 
<input type="radio" id="opdPrint"	name="<%=PRESCRIPTION_SLIP%>" value="c" tabindex="1" class="radio" />
<div class="Clear"></div>
-->
<%
		if(map1.get("hinNo") != null){
			hinNo = (String)map1.get("hinNo");
		}
int hinId=0;
if(map1.get("hinId") != null){
	hinId = (Integer)map1.get("hinId");
}
if(map1.get("controllerFlag") != null){
	controllerFlag = (String)map1.get("controllerFlag");
}

	%>
<input id="hinNo" value="<%=hinNo %>" name="hinNo" type="hidden"/>
<input id="serviceNo" value="<%=serviceNo %>" name="serviceNo" type="hidden"/>
<%
	//if(map1.get("regHinId") == null && existingHinNoList.size()==0){
%>
<!--<div class="Block">
<label>Registration Card</label> 
<input type="radio" id="opdPrint"	name="<%=PRESCRIPTION_SLIP%>" value="o" tabindex="1" class="radio" checked="checked"/>
<div class="Clear"></div>
</div>
--><div class="clear"></div>
<%if(controllerFlag.equals("visit"))
	{%>

<%-- <input type="button"  name="yes" value="Print Reg Card"	class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>&priscriptionSlip=o');" /> --%>
<input type="button" name="yes" value="Print Token Card"	class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=printTokenCard&visit_id=<%=visit_id %>&priscriptionSlip=o');" />
<%} %>
<%//} %>
<input type="hidden" name="<%=VISIT_NUMBER%>" id="<%=VISIT_NUMBER%>"	value="<%= visit_id%>" />
<!--<input type="hidden" name="hinNo"	value="<%=hinNo%>" /> 
--><!--<input type="button" name="no"	value="Registration" class="buttonBig"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />
--><!--<input type="button" name="no" value="Admission" class="button" onclick="submitForm('messageAdt','/hms/hms/adt?method=searchPatientDetailsForAdmission&hinNo=<%=hinNo %>');" />	-->
 <!--<input type="button" name="no" value="Order Booking"	class="buttonBig" onclick="submitForm('messageAdt','/hms/hms/lab?method=getPatientDetails&hinNo=<%=hinNo %>','checkTargetForNo');" />

--><!--<input type="button" name="no" value="Surgery Requisition"	class="buttonBig2"
	onclick="submitForm('messageAdt','/hms/hms/opd?method=showSurgeryRequisitionJspFromPatientList&hinNo=<%=hinNo %>','checkTargetForNo');" />



--><%
		if(flagForVisitSearch  && map1.get("regHinId") == null){
		
	%><!-- <input type="button" name="createVisit" value="Create Visit"	class="buttonBig"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showPatientVisitJsp','checkTargetForNo');" />

--><% for(UserButtonRights  userButtonRights : userRightsList){
			String buttonName=userButtonRights.getButton().getButtonName();
			if(userButtonRights.getButton().getFormName().equals("Registration/Visit Message Form")){
				String formulaUsed=userButtonRights.getButton().getFormulaUsed();	
			
    %> <!--<input type="button" name="no"	value="admission" class="buttonBig"
	onclick="submitForm('messageAdt','<%=userButtonRights.getButton().getUrl()%>','<%=formulaUsed%>');" />
--><%}}}else{ //if(map1.get("regHinId") == null){%> <!--<input type="button" name="createVisit" value="Create Visit"	class="button"
	onclick="submitForm('messageAdt','/hms/hms/registration?method=showVisitDetails&hinNo=<%=hinNo %>','checkTargetForNo');" />
--><%//}else{
%>	
	<input type="button" name="createVisit" value="Next Visit"	class="buttonBig"
	onclick="submitForm('messageAdt','/hms/hms/registration?method=showOnlineVisitJsp','checkTargetForNo');" />
<%//}
for(UserButtonRights  userButtonRights : userRightsList){

		String buttonName=userButtonRights.getButton().getButtonName();
		if(userButtonRights.getButton().getFormName().equals("Registration/Visit Message Form")){
			String formulaUsed=userButtonRights.getButton().getFormulaUsed();	
		
	%> 
<!--<input type="button" name="no"	value="admission" class="button"	onclick="submitForm('messageAdt','<%=userButtonRights.getButton().getUrl()%>','<%=formulaUsed%>');" />
--><%} }}%> 
   <!--<input type="button" name="no" value="Priscription Requisition"	class="buttonBig2" onclick="if(checkvisit()){submitForm('messageAdt','/hms/hms/opd?method=showOPDMainJspChange&visitId=<%= visit_id%>','checkTargetForNo');}" />

-->
<%
	
//	if(map1.get("regFlag") != null && map1.get("img1")== null && map1.get("regHinId") == null){
//	if(map1.get("img1")== null ){
		
%>
<input name="Send" type="button" style="display:none" class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" />
<%
	//} %>
<%
	
	if(map1.get("adNo") != null){
		adNo = (String)map1.get("adNo");
	%>
	 <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageAdt','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo');" />
<%} %>
<%
	if(formName != "" ){
	%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
<%
//if(map1.get("regFlag") != null && map1.get("img1")== null && map1.get("regHinId") == null){
	//if(map1.get("img1")== null ){
%>
<!--<input type="button" name="Registration" value="Next"	class="buttonBig"
	onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />
--><div class="division"></div>
<div class="clear"></div>
<%-- <jsp:include page="testImageUpload.jsp"> 
<jsp:param value="<%=hinNo%>" name="hinNo"/>
</jsp:include>--%>
<div class="clear"></div>
<div class="division"></div>
<%//} %>
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