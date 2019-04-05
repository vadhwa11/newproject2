<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ambulanceRunRegister.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 17.03.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
	</script>
<form name="ambulanceRunRegister" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList =null;
		List<MasAdministrativeSex> sexList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<Object[]> unitList = null;
		List<MasRelation> relationList = null;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("serviceStatusList") != null){
			serviceStatusList = (List<MasServiceStatus>)map.get("serviceStatusList");
		}
		if(map.get("unitList") != null){
			unitList= (List<Object[]>)map.get("unitList");
		}
		if(map.get("relationList") != null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>

	
<h4><%=message %></h4>
<div class="titleBg"><h2>Ambulance Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<label> Date <span>*</span></label> 
<input	type="text" name="<%=AMBULANCE_RUN_DATE %>" value="<%= currentDate %>" MAXLENGTH="30"  tabindex="1" id="ambulanceRunDate" validate="Ambulance Run Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"  tabindex="1" 
class="calender"	onClick="setdate('<%=currentDate %>',document.ambulanceRunRegister.<%=AMBULANCE_RUN_DATE %>,event)" /> 


<label> Time <span>*</span></label> 
<input type="text" id="runTime" name="<%= AMBULANCE_RUN_TIME %>" value="<%= time %>" tabindex="1"   maxlength="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 validate="Ambulance Run Time,string,yes" >

<label> From <span>*</span></label>
<input type="text" id="from" name="<%= FROM_SMC %>" value="" tabindex="1"  maxlength="100" validate="From,string,yes">

<div class="Clear"></div>

<label> To <span>*</span></label>
<input type="text" id="to" name="<%= DESTINATION %>" value="" tabindex="1"  maxlength="100" validate="To,string,yes">

<label> Service No.</label> 
<input type="text" name="<%= SERVICE_NO %>" value="" tabindex="1"  validate="Service No,stirng,no"  onblur="if(this.value!=''){submitProtoAjax('ambulanceRunRegister','/hms/hms/registration?method=getOpIpHinNo&flag=ambulance')};" maxlength="20">

<label> HIN </label> 
<div id="testDiv">
<input type="text" name="<%= HIN_NO %>" value="" tabindex="1"  validate="HIN No,stirng,no"  maxlength="20">
</div>
<div class="Clear"></div>
<label> Patient Name<span>*</span></label> 
<input type="text" id="patientName" name="<%= PATIENT_NAME %>" value="" tabindex="1"  maxlength="15" validate="Patient Name,string,yes">

<label>  Relation</label>
<select id="relationId" name="<%=RELATION_ID %>" tabindex="1"  validate="Relation to Service Personnel,string,no" tabindex="1" onchange="if(checkForFirstRow()){checkPatientRegistration(); setUnit();}">
<option value="0">Select</option>

<%
	for(MasRelation relation : relationList){
	
%>

<option value="<%=relation.getId() %>"><%=relation.getRelationName() %></option>
<%
		}%>

</select>  

<!--<div class="Clear"></div>

<label> Service Type</label>
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>" validate="Service Type,string,no"  tabindex="1" onchange="populateRank('ambulanceRunRegister');">
		<option value="0">Select</option>
		
		<% 
			for(MasServiceType masServiceType : serviceTypeList){
		%>
		<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
		<%} %>
</select>

<label> Service Status</label>
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>" validate="Service Status,string,no" tabindex="1"  onchange="populateRank('ambulanceRunRegister');">
<option value="0">Select</option>
		<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
		%>
<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>
		<%} %>
</select>
-->

 
<label> Rank</label> 
<select id="rankId" name="<%=RANK_ID%>"  validate="Rank,string,no" tabindex="1" >
<option value="0">Select</option>
<%
	for(MasRank rank : rankList){
%>
<option value="<%=rank.getId() %>"><%= rank.getRankName() %></option>
<%} %>
</select>
<div class="Clear"></div>

<label> Name</label> 
<input type="text" id="serPersName" name="<%= SERVICE_PERSON_NAME %>" value="" tabindex="1"  maxlength="15" validate="First Name,string,no"><!--


<label>Middle Name</label> 
<input type="text" id="mName" name="<%= MIDDLE_NAME %>" value=""  maxlength="15">

<label>Last Name</label> 
<input type="text" id="lName" name="<%= LAST_NAME %>" value=""  maxlength="15">

-->


<label > Unit</label>
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1" validate="Unit,string,no"  >
<option value="0">Select</option>
			 <%
					 for(Object[] masUnit : unitList){
					//	 if(masUnit.getStatus() != null){
					//	 if(masUnit.getStatus().equals("y")){
					 %>
						<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
					 
					<%//}
						// }
					 }%>	
</select>

<label>Diagnosis</label> 
<input	type="text" name="<%=DIAGNOSIS%>" validate="Diagnosis,string,no" value="" MAXLENGTH="70"  tabindex="1" />
<div class="Clear"></div>


<label> Age</label>
<input type="text" id="age"	name="<%=AGE%>" validate="Age,string,no" tabindex="1"	/>
<%--<select id="age"	name="<%=AGE%>" validate="Age,string,no" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,no" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>  --%>

<label> Gender</label> 
<select name="<%=SEX %>" id="sex" validate="Sex,string,no" tabindex="1">
<option value="0">Select</option>
    <%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
		 %>
      <option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
      <%
					
		   	 	} %>
</select>

<label>Attendants (If Any)</label> 
<input type="text" name="attendants" value="" maxlength="50" tabindex="1" />

<div class="Clear"></div>
<label>Charges (For NE) (In Rs)</label> 
<input type="text" name="charge" value="" maxlength="10"tabindex="1"  validate="Charges(For NE),int,no"/>
<!--<label>Remarks</label> 
<textarea name="<%=REMARKS %>" rows="" cols="" tabindex="1"  maxlength="90" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" ></textarea>

--></div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton" tabindex="1" 
	onclick="submitForm('ambulanceRunRegister','/hms/hms/registration?method=saveAmbulanceRunRegisterDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />

<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>
