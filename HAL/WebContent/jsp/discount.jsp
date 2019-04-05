<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * discount.jsp  
 * Purpose of the JSP -  This is for Discount.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@ page
	import="java.util.Map,java.lang.String,java.util.Iterator,java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.HashMap"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasBillType"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>


<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<div id=contentspace><br>
<h2 align="left" class="style1">Discount Master</h2>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
		
%>

	serverdate = '<%=date+"/"+month+"/"+year%>'
</script> <%
	  	Map<String,Object> map = new HashMap<String, Object>();
	  	Map<String,Object> mapToTakeValuesToJsp = new HashMap<String, Object>();
	  	List listOfHospital = new ArrayList(); 
		List listOfPatientCategory = new ArrayList(); 
		List listOfPatientType = new ArrayList();
		List listOfCompany = new ArrayList();
		List listOfProject = new ArrayList();
		List listOfBillType = new ArrayList();
		List listOfRoomType = new ArrayList();
		List listOfMainCharge = new ArrayList();
		List listOfSubCharge = new ArrayList();
		List listOfChargeCode = new ArrayList();
		List listOfAccountCode = new ArrayList();
		List listOfInsurance = new ArrayList();
		List listOfReferenceType = new ArrayList();
	  	
	  	if(request.getAttribute("map") != null){
	  		map = (Map)request.getAttribute("map");
	  	}
	  	if(map.get("listOfHospital") != null){
	  		listOfHospital = (List)map.get("listOfHospital");
	  	}
	  	
	  	if(map.get("listOfPatientCategory") != null){
	  		listOfPatientCategory = (List)map.get("listOfPatientCategory");
	  	}
	  	if(map.get("listOfPatientType") != null){
	  		listOfPatientType = (List)map.get("listOfPatientType");
	  	}
	  	if(map.get("listOfCompany") != null){
	  		listOfCompany = (List)map.get("listOfCompany");
	  	}
	  	if(map.get("listOfProject") != null){
	  		listOfProject = (List)map.get("listOfProject");
	  	}
	  	if(map.get("listOfBillType") != null){
	  		listOfBillType = (List)map.get("listOfBillType");
	  	}
	  	if(map.get("listOfRoomType") != null){
	  		listOfRoomType = (List)map.get("listOfRoomType");
	  	}
	  	if(map.get("listOfMainCharge") != null){
	  		listOfMainCharge = (List)map.get("listOfMainCharge");
	  	}	  	
	  	if(map.get("listOfSubCharge") != null){
	  		listOfSubCharge = (List)map.get("listOfSubCharge");
	  	}
	  	if(map.get("listOfChargeCode") != null){
			listOfChargeCode = (List)map.get("listOfChargeCode");
	  	}
	  	if(map.get("listOfAccountCode") != null){
	  		listOfAccountCode = (List)map.get("listOfAccountCode");
	  	}
	  	if(map.get("listOfInsurance") != null){
	  		listOfInsurance = (List)map.get("listOfInsurance");
	  	}
	  	if(map.get("listOfReferenceType") != null){
	  		listOfReferenceType = (List)map.get("listOfReferenceType");
	  	}
	  		  	
	  	//List listOfEmployeeDependent =  (List)mapToTakeValuesToJsp.get("listOfEmployeeDependent");
	  	//List listOfRetiredStaff = (List)mapToTakeValuesToJsp.get("listOfRetiredStaff");
	  	//List listOfInActiveStaff = (List)mapToTakeValuesToJsp.get("listOfInActiveStaff");
	  	//List listOfAccountCode = (List)mapToTakeValuesToJsp.get("listOfAccountCode");
	Map utilMap = new HashMap();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	  %>
<form name="discountMaster" method="post" action=""><label><font
	id="error"></font>Hospital :</label> <select
	name="<%= RequestConstants.HOSPITAL %>" validate="hospital,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfHospital.iterator(); iter.hasNext();) {
					MasHospital obj = (MasHospital) iter.next();
			%>
	<option value="<%=obj.getId()%>"><%=obj.getHospitalName()%></option>
	<%
			 }
			 %>

</select> <label><font id="error"></font>Patient Type :</label> <input
	type="radio" name="<%=RequestConstants.PATIENT_TYPE%>"
	value="In Patient" class="checkbox" checked="checked" /> <font
	class="bodytextB_blue">In Patient</font> <input type="radio"
	name="<%=RequestConstants.PATIENT_TYPE%>" value="Out Patient"
	class="checkbox" /> <font class="bodytextB_blue">Out Patient</font> <input
	type="radio" name="<%=RequestConstants.PATIENT_TYPE%>" value="Both"
	class="checkbox" /> <font class="bodytextB_blue">Both</font> <br />

<label><font id="error"></font>Patient Category :</label> <select
	name="<%= RequestConstants.PATIENT_CATEGORY %>"
	validate="Patient Category,string,no"
	onchange="showComboAccordingToPatientType()">
	<option value="">Select</option>
	<%
			 for (Iterator iter1 = listOfPatientType.iterator(); iter1.hasNext();) {
					MasPatientType ptObj = (MasPatientType) iter1.next();
					String patientTypeCode = ptObj.getPatientTypeCode();
			%>
	<option value="<%=ptObj.getId()%>"><%=ptObj.getPatientTypeName()%></option>
	<%} %>
</select> <br />

<div id="Company" style="display: none;"><label><font
	id="error">*</font> Company :</label> <select
	name="<%= RequestConstants.COMPANY%>" validate="Company,string,no">
	<option value="">Select</option>
	<%
				for (Iterator iter2 = listOfCompany.iterator(); iter2.hasNext();) {
					MasCompany cmObj = (MasCompany) iter2.next();
					String companyTypeCode = cmObj.getCompanyCode();
					if(companyTypeCode.equals("COM")){
			%>
	<option value="<%=cmObj.getId()%>"><%=cmObj.getCompanyName()%></option>
	<%}} %>
</select></div>

<div id="InsuranceHMO" style="display: none;"><label><font
	id="error">*</font> Insurance :</label> <select
	name="<%= RequestConstants.INSURANCE%>"
	validate="InsuranceHmo,string,no">
	<option value="">Select</option>
	<%
				for (Iterator iter2 = listOfCompany.iterator(); iter2.hasNext();) {
					MasCompany cmObj = (MasCompany) iter2.next();
					String companyTypeCode = cmObj.getCompanyCode();
					if(companyTypeCode.equals("INS")){
			%>
	<option value="<%=cmObj.getId()%>"><%=cmObj.getCompanyName()%></option>
	<%}} %>
</select></div>

<div id="Project" style="display: none;"><label><font
	id="error">*</font> Project :</label> <select
	name="<%= RequestConstants.PROJECT%>" validate="Project,string,no">
	<option value="">Select</option>
	<%
				for (Iterator iter2 = listOfCompany.iterator(); iter2.hasNext();) {
					MasCompany cmObj = (MasCompany) iter2.next();
					String companyTypeCode = cmObj.getCompanyCode();
					if(companyTypeCode.equals("PRJ")){
			%>
	<option value="<%=cmObj.getId()%>"><%=cmObj.getCompanyName()%></option>
	<%} }%>
</select></div>

<br />
<br />
<label><font id="error"></font>Bill Type :</label> <select
	name="<%= RequestConstants.BILL_TYPE %>" validate="Bill Type,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfBillType.iterator(); iter.hasNext();) {
					MasBillType obj = (MasBillType) iter.next();
			%>
	<option value="<%=obj.getBillTypeCode()%>"><%=obj.getBillTypeName()%></option>
	<%
			 }
			 %>
</select> <label><font id="error"></font>Main Charge :</label> <select
	name="<%= RequestConstants.MAIN_CHARGE %>"
	validate="Main Charge,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfMainCharge.iterator(); iter.hasNext();) {
					MasMainChargecode obj = (MasMainChargecode) iter.next();
			%>
	<option value="<%=obj.getId()%>"><%=obj.getMainChargecodeName()%></option>
	<%
			 }
			 %>
</select> <br />

<label><font id="error"></font>Sub Charge :</label> <select
	name="<%= RequestConstants.SUB_CHARGE %>"
	validate="Sub Charge,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfSubCharge.iterator(); iter.hasNext();) {
				 MasSubChargecode obj = (MasSubChargecode) iter.next();
			%>
	<option value="<%=obj.getId()%>"><%=obj.getSubChargecodeName()%></option>
	<%
			 }
			 %>
</select> <label><font id="error"></font>Charge Code :</label> <select
	name="<%= RequestConstants.CHARGE_CODE%>"
	validate="Charge Code,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfChargeCode.iterator(); iter.hasNext();) {
					MasChargeCode obj = (MasChargeCode) iter.next();
			%>
	<option value="<%=obj.getId()%>"><%=obj.getChargeCodeName()%></option>
	<%
			 }
			 %>
</select> <br>

<label><font id="error"></font>Room Type :</label> <select
	name="<%= RequestConstants.ROOM_TYPE %>" validate="Room Type,string,no">
	<option value="">Select</option>
	<%
			 for (Iterator iter = listOfRoomType.iterator(); iter.hasNext();) {
					MasRoomType obj = (MasRoomType) iter.next();
			%>
	<option value="<%=obj.getId()%>"><%=obj.getRoomTypeName()%></option>
	<%
			 }
			 %>
</select> <label><font id="error"></font>Account Code :</label> <select
	name="<%= RequestConstants.ACCOUNT_CODE%>"
	validate="Account Code,string,no">
	<option value="">Select</option>
</select> <br />
<br />

<label><font id="error">*</font>From Date:</label> <a
	href="javascript:setdate('<%=currentDate%>',document.discountMaster.<%=RequestConstants.EFFECTIVE_DATE_FROM%>)">
</a> <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" readonly="readonly" /> <input
	name=<%=RequestConstants.EFFECTIVE_DATE_FROM%> value="<%=currentDate%>"
	type="text" readonly class="textbox_size20" /> <br>
<label><font id="error">*</font>To Date:</label> <a
	href="javascript:setdate('',document.discountMaster.<%=RequestConstants.EFFECTIVE_DATE_TO%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <input
	name=<%=RequestConstants.EFFECTIVE_DATE_TO%> value="" type="text"
	readonly class="textbox_size20" /> <br />
<br />

<label><font id="error">*</font>Discount :</label> <input type="text"
	name="<%= RequestConstants.DISCOUNT%>" value=""
	validate="Discount Amount,num,yes" MAXLENGTH="8" class="textbox_size20" />
<br />
<label></label> <input type="radio"
	name="<%=RequestConstants.SELECT_DISCOUNT_TYPE%>" value="%"
	class="checkbox" checked="checked" /> <font class="bodytextB_blue">%</font>
<input type="radio" name="<%=RequestConstants.SELECT_DISCOUNT_TYPE%>"
	value="Fixed" class="checkbox" /> <font class="bodytextB_blue">Fixed</font>
<input type="radio" name="<%=RequestConstants.SELECT_DISCOUNT_TYPE%>"
	value="Value" class="checkbox" /> <font class="bodytextB_blue">Value</font>
<br>
<label><font id="error"></font>Mark Up :</label> <input type="radio"
	name="<%=RequestConstants.MARK_UP%>" value="+" class="checkbox" /> <font
	class="bodytextB_blue">+</font> <br />
<label></label> <input type="radio" name="<%=RequestConstants.MARK_UP%>"
	value="-" class="checkbox" /> <font class="bodytextB_blue">-</font> <br />
<input name="<%=RequestConstants.CHANGED_BY%>" type="hidden"
	class="textbox_size20_disb" value="<%=userName %>"> <input
	name="<%=RequestConstants.CHANGED_TIME%>" type="hidden"
	class="textbox_size20_disb" value="<%= currentTime%>"> <br />

<label>&nbsp;</label> <input type="button" name="Submit" value="Submit"
	class="button"
	onClick="submitForm('discountMaster','/hms/hms/hospitalRelated?method=saveDiscount','chkDate')"
	accesskey="a" /> <input type="reset" name="Reset" value="Reset"
	class="button" accesskey="r" onclick="clearRecords(this)" /></form>
</div>
<script type="text/javascript">


// first combo box


// third combo box

	data_1_1_1 = new Option("111", "*");
	
// fourth combo box


// other parameters

    displaywhenempty=""
    valuewhenempty=-1

    displaywhennotempty="-select-"
    valuewhennotempty=0


function change(currentbox) {
	numb = currentbox.id.split("_");
	currentbox = numb[1];

    i=parseInt(currentbox)+1

// I empty all combo boxes following the current one

    while ((eval("typeof(document.getElementById(\"combo_"+i+"\"))!='undefined'")) &&
           (document.getElementById("combo_"+i)!=null)) {
         son = document.getElementById("combo_"+i);
	     // I empty all options except the first one (it isn't allowed)
	     for (m=son.options.length-1;m>0;m--) son.options[m]=null;
	     // I reset the first option
	     son.options[0]=new Option(displaywhenempty,valuewhenempty)
	     i=i+1
    }


// now I create the string with the "base" name ("stringa"), ie. "data_1_0"
// to which I'll add _0,_1,_2,_3 etc to obtain the name of the combo box to fill

    stringa='data'
    i=0
    while ((eval("typeof(document.getElementById(\"combo_"+i+"\"))!='undefined'")) &&
           (document.getElementById("combo_"+i)!=null)) {
           eval("stringa=stringa+'_'+document.getElementById(\"combo_"+i+"\").selectedIndex")
           if (i==currentbox) break;
           i=i+1
    }


// filling the "son" combo (if exists)

    following=parseInt(currentbox)+1

    if ((eval("typeof(document.getElementById(\"combo_"+following+"\"))!='undefined'")) &&
       (document.getElementById("combo_"+following)!=null)) {
       son = document.getElementById("combo_"+following);
       stringa=stringa+"_"
       i=0
       while ((eval("typeof("+stringa+i+")!='undefined'")) || (i==0)) {

       // if there are no options, I empty the first option of the "son" combo
	   // otherwise I put "-select-" in it

	   	  if ((i==0) && eval("typeof("+stringa+"0)=='undefined'"))
	   	      if (eval("typeof("+stringa+"1)=='undefined'"))
	   	         eval("son.options[0]=new Option(displaywhenempty,valuewhenempty)")
	   	      else
	             eval("son.options[0]=new Option(displaywhennotempty,valuewhennotempty)")
	      else
              eval("son.options["+i+"]=new Option("+stringa+i+".text,"+stringa+i+".value)")
	      i=i+1
	   }
       //son.focus()
       i=1
       combostatus=''
       cstatus=stringa.split("_")
       while (cstatus[i]!=null) {
          combostatus=combostatus+cstatus[i]
          i=i+1
          }
       return combostatus;
    }
}

function showComboAccordingToPatientType(){
	
 var patientTypeInitial=document.discountMaster.<%= RequestConstants.PATIENT_CATEGORY%>.options[document.discountMaster.<%= RequestConstants.PATIENT_CATEGORY%>.selectedIndex].text;
	
	var patientType=patientTypeInitial;
	
	document.discountMaster.<%= RequestConstants.COMPANY%>.setAttribute('validate','Company,string,no');
	document.discountMaster.<%= RequestConstants.INSURANCE%>.setAttribute('validate','Insurance,string,no');
	document.discountMaster.<%= RequestConstants.PROJECT%>.setAttribute('validate','Project,string,no');

	if(patientType=='Company'){
		document.getElementById('Company').style.display='block';
		document.discountMaster.<%= RequestConstants.COMPANY%>.setAttribute('validate','Company,string,yes');
	}
	else{
		document.getElementById('Company').style.display='none';
	}
		
	if(patientType=='Insurance'){
		document.getElementById('InsuranceHMO').style.display='block';
		document.discountMaster.<%= RequestConstants.INSURANCE%>.setAttribute('validate','Insurance,string,yes');
	}
	else{
		document.getElementById('InsuranceHMO').style.display='none';
	}
			
	if(patientType=='Project'){
		document.getElementById('Project').style.display='block';
		document.discountMaster.<%= RequestConstants.PROJECT%>.setAttribute('validate','Project,string,yes');
	}
	else{
		document.getElementById('Project').style.display='none';
	}
}
function chkDate(){
		var err = "";
		var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
		obj1 = document.discountMaster.effectiveDateFrom.value;
		obj2 = document.discountMaster.effectiveDateTo.value;
		fromDate=new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
		toDate=new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
		if(obj1==""){
			err+="From Date Cannot be blank.\n"
		}
		else{
			if(fromDate>currentDate)
				err += "From Date should be less than or equal to current date.\n"
		}
		if(obj2==""){
			err+="To Date Cannot be blank.\n"
		}
		else{
			if(toDate<currentDate)
				err += "To Date should be greater than or equal to current date.\n"	
		
		}
		if(obj1!="" && obj2 !=""){

			if(fromDate>toDate)	
				err += "From date should be less than or equal to To Date.\n"				
		}
		if(err!="")
			alert(err)
		else 
			return true;
	}
	</script>

