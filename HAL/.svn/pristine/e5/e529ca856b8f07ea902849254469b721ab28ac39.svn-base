
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
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A712")) 	// Medical Board			
				{
					flag7 = true;
	 				break;
	 			}
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A927")) 		//Medical Exam		
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
	 			else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A959")) 		//Physiotherapy		
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
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1155")) 	 //Emergency Room			
	 		//	else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1142")) 	 //Emergency Room
				{
					flag16 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1157")) 	 // Radiology
	 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1161")) 	 // Radiology			
				{
					flag17 = true;
	 				break;
	 			}else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1169")) 	
	 			//else if(appMaster.getId().equals(appMaster1.getId()) && appMaster.getId().equals("A1160")) 	 // ECG			
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
				
 			}
 			}
 		}

 	System.out.print("flag19="+flag19);
 	
 	if(flag1){
%>

<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Reception&appId=A3')"  class="menuIconBg" > 
<!-- <a href="#" class="menuIconBg" onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true"  htmlEscape="true" onclick="submitForm('default','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Reception&appId=A3')" >-->
<img src="/hms/jsp/images/menuIcons/reception.png" height="79"   />
<br />Reception
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/receptionDisb.png" height="79"   />
<br />Reception
</a>
<%}
 	if(flag2){
 	%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=OPD&appId=A332')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/opd.png" height="79"   />
<br />OPD
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/opdDisb.png" height="79"   />
<br />OPD
</a>
<%}
if(flag3){
 			%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Dispensary&appId=A366')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/dispensary.png" height="79"   />
<br />Dispensary
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dispensaryDisb.jpg" height="79"   />
<br />Dispensary
</a>
<%}
if(flag4){
			%>
<a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Stores&appId=A89')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"/>
<img src="/hms/jsp/images/menuIcons/med-store.png" height="79"   />
<br />Med Stores
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/med-storeDisb.png" height="79"   />
<br />Med Stores
</a>
<%} %>

<% if(flag6){ %>
<a href="#" onclick="newSubmit('/hms/hms/login?method=showModuleDefaultJsp','Lab','A328');"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"/>
<img src="/hms/jsp/images/menuIcons/laboratory.png" height="79"   />
<br />Laboratory
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/laboratoryDisb.png" height="79"   />
<br />Laboratory
</a>
<%} %>
<% if(flag7){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=MedicalBoard&appId=A712')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/medica-board.png" height="79"   />
<br />Medical Board
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/medica-boardDisb.png" height="79"   />
<br />Medical Board
</a>
<%} %>

<% if(flag8){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=MedicalExam&appId=A927')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/medical_exam.png" height="79"   />
<br />Medical Exam
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/medical_examDisb.png" height="79"   />
<br />Medical Exam
</a>
<%} %>
<% if(flag9){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Statistics&appId=A112')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/records.png" height="79"   />
<br />Stn Health Statistics
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/recordsDisb.png" height="79"   />
<br />Stn Health Statistics
</a>
<%} %>

<% if(flag10){ %>
<a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Ward&appId=A105')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">

<!--<a href="/hms/hms/ipd?method=showPatientListJsp&moduleName=Ward&appId=A105"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true">
--><img src="/hms/jsp/images/menuIcons/ward.png" height="79"   />
<br />Ward
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/wardDisb.png" height="79"   />
<br />Ward
</a>
<%} %>

<% if(flag11){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Physiotherapy&appId=A959')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/physiotherapy.png" height="79"   />
<br />Physiotherapy
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/physiotherapyDisb.png" height="79"   />
<br />Physiotherapy
</a>
<%} %>

<% if(flag12){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=AviationMedicine&appId=A1110')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/aviation_medicine.png" height="79"   />
<br />Aviation Medicine
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/aviation_medicineDisb.png" height="79"   />
<br />Aviation Medicine
</a>
<%} %>

<% if(flag13){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Dental&appId=A1109')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/dental.png" height="79"   />
<br />Dental
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/dentalDisb.png" height="79"   />
<br />Dental
</a>
<%} %>

<% if(flag15){ %>
<a href="#" onClick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=SHO&appId=A985')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/educations.png" height="79"   />
<br />SHO
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/educationDisb.png" height="79"   />
<br />SHO
</a>
<%} %>

<% if(flag14){ %>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=FamilyWelfareCenter&appId=A989')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/family.png" height="79"   />
<br />Family Welfare Centre
</a>
<%}else{%>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/familyDisb.png" height="79"   />
<br />Family Welfare Centre
</a>
<%} %>

<%
if(flag5){
%>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Masters&appId=A2')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/masters.png" height="79"   />
<br />Masters
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/mastersDisb.png" height="79"   />
<br />Masters
</a>
<%}
%>

<%
if(flag16){
%>
<!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=EmergencyRoom&appId=A1142')" class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/emergency.gif" height="79"   />
<br />Emergency Room/DMA
</a>-->
<!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName='+encodeURIComponent('EmergencyRoom')+'&appId='+encodeURIComponent('A1155'))"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true"> -->
<a href="#" onclick="newSubmit('/hms/hms/login?method=showModuleDefaultJsp','EmergencyRoom','A1155')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">

<img src="/hms/jsp/images/menuIcons/emergency.png" height="79"   />
<br />Emergency Room/DMA
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/emergencyDisb.png" height="79"   />
<br />Emergency Room/DMA
</a>
<%}
%>

<%
if(flag17){
%>
<!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Radiology&appId=A1161','checkDeptRadio')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/radiology.gif" height="79"   />
<br />Radiology
</a>-->

<a href="#" onclick="newSubmit('/hms/hms/login?method=showModuleDefaultJsp','Radiology','A1157')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/radiology.gif" height="79"   />
<br />Radiology
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/radiologyDisb.gif" height="79"   />
<br />Radiology
</a>
<%}
%>
<%
if(flag18){
%>
<!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=ECGRoom&appId=A1160','checkDeptECG')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/ecg.jpg" height="79"   />
<br />ECG Room
</a>-->

<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=ECGRoom&appId=A1169','checkDeptECG')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/ecg-room.png" height="79"   />
<br />ECG Room
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/ecg-roomDisb.png height="79"   />
<br />ECG Room
</a>
<%}
%>
<%
if(flag19){
%>

<!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Monitoring&appId=A1180')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/monitor.jpg" height="79"   />
<br />Monitoring
</a>-->
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Ward Pharmacy&appId=A1587')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<img src="/hms/jsp/images/menuIcons/monitoring.png" height="79"   />
<br />Ward Pharmacy
</a>
<%}else{ %>
<a href="#" class="menuIconBgDisable">
<img src="/hms/jsp/images/menuIcons/monitoringDisb.png" height="79"   />
<br />Ward Pharmacy
</a>
<%}
%>
 <!--<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName=Masters&appId=A218')"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">

<br />Non Expendable
</a>-->
<!--
<a href="/hms/hms/login?method=showModuleDefaultJsp&moduleName=Masters&appId=A218"  class="menuIconBg"   onMouseover="JavaScript:window.status='Status Bar Message goes here'; return true" onMouseout="JavaScript:window.status=''; return true" htmlEscape="true">
<br />Exit
</a> 
-->
</div>
<div class="clear"></div>
</div>
</form>
<script>
function checkDeptLab(){
	var loginDept='<%=session.getAttribute("deptName")%>';
	if(loginDept == 'Laboratory'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptRadio(){
	var loginDept='<%=session.getAttribute("deptName")%>';
	if(loginDept == 'Radiodiagnosis'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}

function checkDeptECG(){
	var loginDept='<%=session.getAttribute("deptName")%>';
	if(loginDept == 'ECG ROOM'){
		return true;
	}else{
		alert("Unauthorized user department. Please change the department.");
		return false;
	}
}


function newSubmit(url,module,appid){

	var flag='';
	if(!validateButton(module)){
		flag = 'metachar';
	}
	if(!validateButton(appid)){
		flag = 'metachar';
	}
	if(flag==''){
		mo = encodeURIComponent(module);
		apid = encodeURIComponent(appid);
		submitForm('defaultMenu',url+'&moduleName='+mo+'&appId='+apid);
	}
}


</script>