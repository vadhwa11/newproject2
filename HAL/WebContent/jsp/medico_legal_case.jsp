<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * medico_legal_case.jsp  
 * Purpose of the JSP -  This is for Medico Legal Case.
 * @author  Deepti Tevatia
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>


<%@page import="jkt.hms.masters.business.MasInjuryNature"%>
<%@page import="jkt.hms.masters.business.MasBodyPart"%>

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
<%

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	String adNo = "";
	String message = "";
	String mlcNo = "";
	String flag = "";
	String condition = "";
	int visitNo = 0;
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasInjuryNature> injuryNatureList = new ArrayList<MasInjuryNature>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasBodyPart> bodyPartList = new ArrayList<MasBodyPart>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(map.get("adNo") != null){
		adNo = (String)map.get("adNo");
	}
	if(map.get("mlcNo") != null){
		mlcNo = (String)map.get("mlcNo");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	if(map.get("visitNo") != null){
		visitNo = (Integer)map.get("visitNo");
	}
	if(map.get("condition") != null){
		condition = (String)map.get("condition");
	}
	
	
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
		session.setAttribute("patientList", patientList);
	}else if(session.getAttribute("patientList") != null){
		patientList = (List<Patient>)session.getAttribute("patientList");
	}
	
	if(patientList.size() > 0){
		Patient patient = patientList.get(0);
		
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("injuryNatureList") != null){
			injuryNatureList = (List<MasInjuryNature>)detailsMap.get("injuryNatureList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(detailsMap.get("bodyPartList") != null){
			bodyPartList = (List<MasBodyPart>)detailsMap.get("bodyPartList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		String age = patient.getAge();
		String currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
		System.out.println("currentAge of the patient--11--->"+currentAge);
%>


<form name="mlcForm" method="post">
<div class="titleBg">
<h2>Medico Legal Case</h2>
</div>
<%
	 if(!message.equals("")){
	 %>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<%} %>

<h4>Medico Legal Case Details</h4>
<div class="clear"></div>
<div class="Block">
<label>HIN No.</label> 
<label class="value"><%=patient.getHinNo() %></label> <%
		if(flag.equals("ipMlc")){
	%> 
<label>AD No. </label> 
<label class="value"><%=adNo %></label> <%}else if(flag.equals("opMlc")){ %>
<label>Visit No </label> <label class="value"><%=visitNo %></label> <%} %>

<label>Service No. </label> <%
	if(patient.getServiceNo() != null &&  !(patient.getServiceNo().equals(""))){
	%> 
<label class="value"><%= patient.getServiceNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %>
<div class="clear"></div>

<label>Service Type </label> <label class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

<label>Relation </label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %> 
<label class="value">-</label> <%} %> <label>ServMan Name </label> 
<%
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			String sMiddleName = "";
			String sLastName = "";
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
			
				
%> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> <% }%> <%
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		
		%>
<div class="clear"></div>

<label>Patient Name </label> 
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex </label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<label>MLC No. </label> <label class="value"><%=mlcNo%></label>
<div class="clear"></div>

<label><span>*</span> MLC Date  </label> 
<input type="text" id="mlcDateId" name="<%=MLC_DATE%>" class="date" value="<%=currentDate %>" readonly="readonly" validate="MLC Date,dateOfAdmission,yes" MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.mlcForm.<%=MLC_DATE%>,event)" /> 
<label><span>*</span> MLC Time  </label> 
<input type="text" id="mlcTimeId" name="<%=MLC_TIME %>" onKeyUp="mask(this.value,this,'2,5',':');"  value="<%=currentTime %>" validate="MLC Time,String,yes" onchange="IsValidTime(this.value,this.id);" />

<div class="clear"></div>

</div>

<h4>Injury Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Nature of MLC </label> 
<select name="<%= NATURE_OF_MLC %>" validate="Nature of MLC,String,no">
<option value="">Select</option>
<option value="Major">Major</option>
<option value="Minor">Minor</option>
</select> 
<label>Nature of Injury</label> 
<select name="<%= INJURY_NATURE_ID %>" validate="Nature of Injury,String,no">
<option value="0">Select</option>
	<% 
		for (MasInjuryNature obj : injuryNatureList){
	%>
<option value="<%=obj.getId ()%>"><%=obj.getInjuryNatureName()%></option>
	<% }%>
</select> 
<label>Type Of Injury </label> 
<select name="<%= INJURY_TYPE %>" validate="Type Of Injury,String,no">
<option value="">Select</option>
<option value="RTA">RTA</option>
<option value="Poisoning">Poisoning</option>
<option value="Burning">Burning</option>
</select>
<div class="Clear"></div>

<label>Severity of Injury</label> 
<select name="<%= SEVERITY_OF_INJURY %>" validate="Severity Of Injury,String,no">
<option value="">Select</option>
<option value="Minor">Minor</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select> 
<label>Injury Dimen</label> <input type="text" name="<%= INJURY_DIMENSION %>" value="" validate="Injury Dimension,alphanumeric,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="20" /> 
<label>Injury Details </label> 
<textarea name="<%=INJURY_DETAILS %>" validate="Injury Details ,alphanumeric,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="60" />
</textarea>

<div class="clear"></div>


</div>


<h4>Other Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Brought By </label> 
<input type="text" name="<%= BROUGHT_BY %>" value="" validate="Brought By,fullName,no" maxlength="40"> 
<label><span>*</span> Doctor Attnd </label> 
<select name="<%=CONSULTING_DOCTOR %>" validate="Doctor Attended,String,yes">
<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			  if(obj.getEmpCategory().getEmpCategoryCode().equals("01")){
				  
				  String name="";
				  if(obj.getFirstName()!=null)
				  {
					  name=name+obj.getFirstName();
				  }
				  if(obj.getMiddleName()!=null)
				  {
					  name=name+" "+obj.getMiddleName();
				  }
				  if(obj.getLastName()!=null)
				  {
					  name=name+" "+obj.getLastName();
				  }
	%>
<option value="<%=obj.getId ()%>"><%=name%></option>
	<% }}}%>
</select> 
<script type="text/javascript">
		<%
			int i = 0;
			for (MasDepartment masDepartment : departmentList) 
			{
				for (MasEmployee masEmployee : employeeList) 
				{
					if(masEmployee.getDepartment() != null){
						if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
		%>
							doctorArr[<%=i%>] = new Array();
							doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
							doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;									
							doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName()%>";
		<%
							i++;
						}
					}
				}
			}
		%>
</script> <label><span>*</span> Condition </label> 
<select name="<%=CONDITION %>" validate="Condition,String,yes"> 
<%if(condition != ""){
	System.out.println("condition of the patient--11--->"+condition);
	  if(condition.equals("SIL") || condition.equals("DIL")){
	          condition = "Critical";
 	 %>
<option value="<%=condition%>" selected="selected"><%=condition%></option>
	<%}else{%>
<option value="<%=condition%>" selected="selected"><%=condition%></option>
	<% }
	  }else{ 
	%>
<option value="0">Select</option>
<option value="Normal">Normal</option>
<option value="Critical">Critical</option>
<option value="Walking">Walking</option>
<option value="Lying">Lying</option>
<option value="Dead">Dead</option>
	<%}%>
</select>
<div class="clear"></div>

<label>Body Part Aff.</label> 
<select name="<%=BODY_PART_ID %>" validate="Body Part Affected,String,no">
<option value="0">Select</option>
	<% 
		for (MasBodyPart obj : bodyPartList){
	%>
<option value="<%=obj.getId ()%>"><%=obj.getBodyPartName()%></option>
	<% }%>
</select> 
<label>Weapon Used </label> 
<input type="text" name="<%= WEAPON_USED %>" value="" maxlength="50" validate="Weapon Used,alphanumeric,no"> 
<label><span>*</span> Incidence Date  </label> 
<input type="text" id="incidenceDateId" name="<%=INCIDENCE_DATE%>" value="<%=currentDate %>" readonly="readonly" validate="Incidence Date,dateOfAdmission,yes" MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.mlcForm.<%=INCIDENCE_DATE%>,event)" />
<div class="clear"></div>

<label><span>*</span> Incidence Time  </label> 
<input type="text" id="<%=INCIDENCE_TIME %>" name="<%=INCIDENCE_TIME %>" onKeyUp="mask(this.value,this,'2,5',':');" value="<%=currentTime %>" validate="Incidence Time,String,yes" onchange="IsValidTime(this.value,this.id);" /> 
<label><span>*</span> Incidence Place </label> 
<input type="text" name="<%= INCIDENCE_PLACE %>" value="" maxlength="50" validate="Incidence Place,alphaspace,yes">

<label>Type & No of Vehicle </label> 
<input type="text" name="<%= TYPE_AND_NO_OF_VEHICLE %>" value="" validate="Type & No of Vehicle ,no" maxlength="50">
<div class="clear"></div>

<label>Name & Address Of Driver </label> 
<textarea name="<%=NAME_AND_ADDR_OF_DRIVER %>" validate="Name & Address Of Driver,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="59" />
</textarea> 
<label>Remarks </label> 
<textarea name="<%=REMARKS %>" validate="Remarks,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="59" />
</textarea> 
<label>Brought By Address </label> 
<textarea name="<%=BROUGHT_BY_ADDRESS %>" validate="Brought By Address,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="59" />
</textarea>
<div class="clear"></div>

<label>Patient Address </label> 
<textarea name="<%=PATIENT_ADDRESS %>" class="txtarea" cols="20" rows="3" validate="Brought By Address,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="59" />
</textarea>

<div class="clear"></div>


</div>


<!--<div style="width: 15px; height: 20px;  BORDER-bottom: #3c8ad7 1px solid; float:left;"></div>
	<div  style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid;  BORDER-LEFT: #3c8ad7 1px solid;   width: 187px; height: 20px; float:left;">
	<font class="boxtitle">Police Details</font>
	</div>
	<div style="width: 15px; float:left;"><img src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
	-->

<h4>Police Details</h4>
<div class="clear"></div>
<div class="Block">
<label>FIR No </label> 
<input type="text" name="<%= FIR_NO %>" value="" validate="FIR No,alphanumeric,no" maxlength="15"> 
<label>Police Officer Name </label> 
<input type="text" name="<%= POLICE_OFFICER %>" value="" validate="Police Officer Name,fullName,no" maxlength="45"> 
<label>Police Station </label> 
<input type="text" name="<%= POLICE_STATION %>" value="" validate="Police Station,alphanumeric,no" maxlength="30">
<div class="clear"></div>

<label>Statement </label> 
<textarea name="<%=STATEMENT %>" validate="Statement,remarks,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="250" />
</textarea>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit11" value="Save" class="button" onClick="submitForm('mlcForm','/hms/hms/adt?method=submitMLCDetails');" />
<input type="reset" name="Reset" value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="bottom"><label>Changed By</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date</label> 
<label class="value"><%=currentDate%></label> 
<label>Changed Time</label> 
<label class="value"><%=currentTime%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo %>" /> 
<input type="hidden" name="<%=MLC_NO %>" value="<%=mlcNo %>" /> 
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visitNo %>" /> 
<input type="hidden" id="idForAge" name="<%= AGE%>" value="<%=currentAge %>" />

<input type="hidden" name="flag" value="<%=flag %>" />
<div id="edited"></div>
<div class="clear"></div>


<% }%>
<div id="statusMessage" class="messagelabel">
</div>
</form>
