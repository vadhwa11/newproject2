
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasApplication"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<form name="defaultMenu"  action="" method="post">
<div id="main">
<div id="menuIcon" >
<%
        Map mainMap=(Map)request.getAttribute("map");
	Set<MasApplication> applicationSet = null;
    if(session.getAttribute("applicationSet") != null){
    	applicationSet = (Set<MasApplication>)session.getAttribute("applicationSet");
    }
    String csrfToken = (String) session.getAttribute("csrfToken");
   // System.out.println("in jsp new de csrfToken>>>>>"+csrfToken);
 	boolean flag1 =false;
 	boolean flag2 =false;
 	boolean flag3 =false;
 	boolean flag4 =false;
 	boolean flag5 =false;
 	boolean flag6 =false;
 	boolean flag7 =false;
 	boolean flag8 =false;
 	boolean flag9 =false;
 	boolean flag10 =false;
 	boolean flag11 =false;
 	boolean flag12 =false;
 	boolean flag13 =false;
 	boolean flag14 =false;
	boolean flag15 =false;
	boolean flag16 =false;
	boolean flag17 =false;
	boolean flag18 =false;
	boolean flag19 =false;
	boolean flag20 =false;
	boolean flag21 =false;
	boolean flag22 =false;
	
 	for(MasApplication appMaster : applicationSet){
 	
 		if(appMaster.getParentId().equals("0")){
 			for(MasApplication appMaster1 : applicationSet){
				if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A3")) 	//Reception			
				{
					flag1 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A332")) 	//OPD			
				{
					flag2 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A366")) 		//Dispensary		
				{
					flag3 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A89")) 	//Stores			
				{
					flag4 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A2")) 	//Masters		
				{
					flag5 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A328")) 		//Lab		
				{
					flag6 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A541")) 	// OT			
				{
					flag7 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1562")) 		//Medical Exam		
				{
					flag8 = true;
	 				break;
	 			} 
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A112")) 	//Statistics			
				{
					flag9 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A105")) 	//Ward			
				{
					flag10 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1682")) 		//Referaal		
				{
					flag11 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1110")) 	//Aviation Medicine			
				{
					flag12 = true;
	 				break;
	 			}
	 					else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1109")) 	//	Dental		
				{
					flag13 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A989"))		// Family Welfare Center	
				{
					flag14 = true;
	 				break;
	 			} 
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A985")) 	 // Health Education				
				{
					flag15 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A324")) 	 //Admin			
				{
					flag16 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1157")) 	 // Radiology
	 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1178")) 	 // Radiology  For IEW
	 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1161")) 	 // Radiology		For DIT	
				{
					flag17 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1")) 	//Billing
	 		//	else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1179"))   // ECG      For IEW
	 		//	else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1160")) 	 // ECG			for DIT
				{
					flag18 = true;
	 				break;
	 			}
				else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1587")) 	 // Ward Pharmacy			
		 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1180"))
					{
						flag19 = true;
		 				break;
		 			}
				else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1913")) 	 // Accounts			
		 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1180"))
					{
						flag20 = true;
		 				break;
		 			}
				else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1914")) 	 // Payroll
		 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1180"))
					{
						flag21 = true;
		 				break;
		 			}
 			}
 			}
 		} 	
 	
 	
	System.out.print("flag20="+flag20);
 	
 	if(flag1){
%>

<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showReceptionDefaultJsp&csrfToken=<%=csrfToken%>')" class="menuIconBg" > 
<!-- <a href="#" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true"  htmlEscape="true" onclick="submitForm('default','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Reception&appId=A3')" >-->
<img src="/hms/jsp/images/menuIcons/reception.png" height="80" class="fade" />
<br />Reception
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/receptionDisb.png" height="80"/>
<br />Reception
</a>
<%}
 	if(flag2){
 	%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showOPDDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/opd.png" height="80" class="fade" />
<br />OPD
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/opdDisb.png" height="80" />
<br />OPD
</a>
<%}
if(flag3){
 			%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showDispensaryDefaultJsp','checkDeptDisp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/dispensary.png" height="80" class="fade" />
<br />Dispensary
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.png" height="80" />
<br />Dispensary
</a>
<%}
if(flag4){
			%>
<a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showStoresDefaultJsp','checkDeptStores')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"/>
<img src="/hms/jsp/images/menuIcons/med-store.png" height="80" class="fade" />
<br />Stores
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/med-storeDisb.png" height="80" />
<br />Stores
</a>
<%} %>

<% if(flag6){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showLabDefaultJsp&csrfToken=<%=csrfToken%>','checkDeptLab');" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"/>
<img src="/hms/jsp/images/menuIcons/laboratory.png" height="80" class="fade" />
<br />Laboratory
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/laboratoryDisb.png" height="80" />
<br />Laboratory
</a>
<%} %>
<br />
<div class="Clear"></div>
<%
if(flag17){
%>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showRadioDefaultJsp','checkDeptRadio')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/radiology.png" height="80" class="fade" />
<br />Radiology
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/radiologyDisb.png" height="80" />
<br />Radiology
</a>
<%}
%>

<% if(flag10){ %>
<a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showWardDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">



<img src="/hms/jsp/images/menuIcons/ward.png" height="80" />
<br />Ward
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/wardDisb.png" height="80" />
<br />Ward
</a>
<%} %>

<% if(flag7){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showOTDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/ot.png" height="80" class="fade" />
<br />OT
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/otDisb.png" height="80" />
<br />OT
</a>
<%} %>

<% if(flag8){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showLaborDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/labor-room.png" height="80" class="fade" />
<br />Labor Room
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/labor-roomDisb.png" height="80" />
<br />Labor Room
</a>
<%} %>
<% if(flag9){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showStatsDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/ficility-mgmt.png" height="80" class="fade" />
<br />Facility Mgmt
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/ficility-mgmtDisb.png" height="80" />
<br />Facility Mgmt
</a>
<%} %>
<div class="Clear"></div>
<br />
<% if(flag11){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showReferralDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/referral.png" height="80" class="fade" />
<br />Referral
</a> 
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/referralDisb.png" height="80" />
<br />Referral
</a>
<%} %>


<% if(flag18){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showBillingDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/billing.png" height="80" class="fade" />
<br />Billing
</a> 
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/billingDisb.png" height="80" />
<br />Billing
</a>
<%} %>

<%
if(flag5){
%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showMastersDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/masters.png" height="80" class="fade"/>
<br />Masters
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/mastersDisb.png" height="80" />
<br />Masters
</a>
<%}
%>

<%
if(flag16){
%>
 <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showAdminDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"> 
<img src="/hms/jsp/images/menuIcons/admin.png" height="80" />
<br />Admin
</a> 
<%}else{ %>
 <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/adminDisb.png" height="80" />
<br />Admin
</a> 
<%}
%>

<% if(flag12){ %>
<!-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showAviationDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/aviation_medicine.png" height="80" />
<br />Aviation Medicine
</a> -->
<%}else{%>
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/aviation_medicineDisb.png" height="80" />
<br />Aviation Medicine
</a> -->
<%} %>

<% if(flag13){ %>
<!-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showDentalDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/dental.png" height="80" />
<br />Dental
</a> -->
<%}else{%>
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dentalDisb.png" height="80" />
<br />Dental
</a> -->
<%} %>

<% if(flag15){ %>
<!-- <a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showSHODefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/educations.png" height="80" />
<br />SHO
</a> -->
<%}else{%>
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/educationsDisb.png" height="80" />
<br />SHO
</a> -->
<%} %>

<% if(flag14){ %>
<%-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showFWCDefaultJsp&csrfToken=<%=csrfToken%>')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/family.png" height="80" />
<br />Family Welfare Centre
</a> --%>
<%}else{%>
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/familyDisb.png" height="80" />
<br />Family Welfare Centre
</a> -->
<%} %>

<%-- <%
if(flag17){
%>

<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showRadioDefaultJsp','checkDeptRadio')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/radiology.gif" height="80"   />
<br />Radiology
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/radiologyDisb.gif" height="80" />
<br />Radiology
</a>
<%}
%> --%>
<%
if(flag18){
%>
<!-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showECGDefaultJsp','checkDeptECG')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/ecg-room.png" height="80"   />
<br />ECG Room
</a> -->
<%}else{ %>
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/ecg-roomDisb.png" height="80" />
<br />ECG Room
</a> -->
<%}
%>
<%
if(flag19){
%>

 <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showWardPharmacyDefaultJsp','checkDeptWard')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/dispensary.png" height="80"   />
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.png" height="80" /> -->
<br />Ward Pharmacy
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.png" height="80" />
<br />Ward Pharmacy
</a> 
<%}
%><%
if(flag20){
%>

 <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showAccountsDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/accounts.png" height="80"   />
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.png" height="80" /> -->
<br />Accounts
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/accountsDisb.png" height="80" />
<br />Accounts
</a> 
<%}
%>
<%
if(flag21){
%>

 <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showPayrollDefaultJsp')" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/payroll.png" height="80"   />
<!-- <a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.png" height="80" /> -->
<br />Payroll
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/payrollDisb.png" height="80" />
<br />Payroll
</a> 
<%}
%>
<!-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Non Expendable&appId=A218')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/noe-exp.png" height="80" />
<br />Non Expendable
</a> -->

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
</form>
<script>
function checkDeptLab(){
		var loginDeptType='<%=session.getAttribute("deptType")%>';
		if(loginDeptType == 'DIAG'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptRadio(){
		var loginDeptType='<%=session.getAttribute("deptType")%>';
	if(loginDeptType == 'RADIO'){		
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptDisp(){
	var loginDeptCode='<%=session.getAttribute("deptCode")%>';
if(loginDeptCode == 'Disp'){		
	return true;
}else{
	alert("Unauthorized user department. Please change the department.");
	return false;
}
}


function checkDeptWard(){
	var loginDeptCode='<%=session.getAttribute("deptCode")%>';
if(loginDeptCode == 'wp'){		
	return true;
}else{
	alert("Unauthorized user department. Please change the department.");
	return false;
}
}

function checkDeptStores(){
	var loginDeptCode='<%=session.getAttribute("deptCode")%>';
if(loginDeptCode == 'ExpStr'){		
	return true;
}else{
	alert("Unauthorized user department. Please change the department.");
	return false;
}
}

function checkDeptECG(){
	var loginDeptType='<%=session.getAttribute("deptType")%>';
	if(loginDeptType == 'ECG'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptAccounts(){
	var loginDeptType='<%=session.getAttribute("deptType")%>';
	if(loginDeptType == 'Accounts'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptPayroll(){
	var loginDeptType='<%=session.getAttribute("deptType")%>';
	if(loginDeptType == 'Payroll'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

</script>