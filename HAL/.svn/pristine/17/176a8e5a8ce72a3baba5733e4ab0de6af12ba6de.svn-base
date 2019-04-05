
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.OpdVaccinMst"%>
<%@page import="jkt.hms.masters.business.MasVaccineItem"%>
<%-- <%@page import="jkt.hms.masters.business.PhMemberSurvey"%> --%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.concurrent.TimeUnit" %>
<%@page import="jkt.hms.util.ImmunizationUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
 <script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
	<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>';
	</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	int pHeaderId = 0;
	Box box = HMSUtil.getBox(request);
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	List<OpdVaccinMst> vaccineList = new ArrayList<OpdVaccinMst>();
	List<OpdVaccinationPlan>vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
	List<Integer> prescribedVaccinList = new ArrayList<Integer>();
	List<RouteOfAdministration> routeOfAdministrationList = null;  /* added by amit das on 19-10-2016 */
	// List<MasFrequency> frequencyList = null;  /* added by amit das on 19-10-2016 */
	/* if(map.get("immunizationList") != null){
		immunizationList = (List<PhMemberSurvey>)map.get("immunizationList");
	} */
	
	List<ImmunizationUtil> immunizationList=new ArrayList<ImmunizationUtil>();//added by govind 6-12-2016
	
	if(map.get("vaccineList") != null){
		vaccineList = (List<OpdVaccinMst>)map.get("vaccineList");
	}
	if(map.get("vaccinationPlanList") != null){
		vaccinationPlanList = (List<OpdVaccinationPlan>)map.get("vaccinationPlanList");
	}
	List<Patient>patientList=new ArrayList<Patient>();
	if(map.get("patientList")!=null){
		patientList=(List<Patient>)map.get("patientList");
	}
	/* added by amit das on 19-10-2016 */
	if(map.get("routeOfAdministrationList")!=null){
		routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
	}
	
	if(map.get("immunizationList") != null){
		immunizationList = (List<ImmunizationUtil>)map.get("immunizationList");
	}
	/* added by amit das on 19-10-2016 */
	/* if(map.get("frequencyList")!=null){
		frequencyList=(List<MasFrequency>)map.get("frequencyList");
	} */
	
	/* Patient patient=new Patient();
	if(map.get("patient") != null){
		patient = (Patient)map.get("patient");
	} */
	
	if(map.get("pHeaderId")!=null){
		pHeaderId=(Integer)map.get("pHeaderId");
	}
	

	if(map.get("prescribedVaccinList")!=null){
		prescribedVaccinList=(List<Integer>)map.get("prescribedVaccinList");
	}
	
	
	String uhid="";
	String name="";
	int hinId=0;
	Date dob=new Date();
	for(Patient patient:patientList){
	if(patient!=null){
		uhid=patient.getHinNo();
		hinId=patient.getId();
		name=patient.getPFirstName();
		if(patient.getPMiddleName()!=null && !patient.getPMiddleName().equals(""))
			name=name+" "+patient.getPMiddleName();
		if(patient.getPMiddleName()!=null && !patient.getPMiddleName().equals(""))
			name=name+" "+patient.getPLastName();
		if(name.equals(""))
			name=patient.getFileName();
		if(patient.getDateOfBirth()!=null)
			dob=patient.getDateOfBirth();
	}
	}
	int visitId = box.getInt("visitId");
	int inpatientId=0;
	if(box.getInt("inpatientId")!=0){
		inpatientId=box.getInt("inpatientId");
	}

if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %>
<div class="titleBg">
<h2>Vaccine</h2>
</div>
<div class="clear"></div>
<form name="vaccineDetail" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label class="autoSize autoSpace">UHID</label>
<input type="hidden" name="hinId" value="<%=hinId%>"/>
<input type="hidden" name="visitId" value="<%=visitId%>"/>
 <input type="text" tabindex="1" name="aadharNo" value="<%=uhid %>" maxlength="16" readonly="readonly" /> 
<label class="autoSize autoSpace"> Name</label>
 <input type="text" id="pFirstNameId"  name="patientName" value="<%=name != null?name:"" %>" readonly="readonly"/>
<label class="autoSize autoSpace"> Date of Birth</label>
 <input type="text" id="dobId"  name="dob" value="<%=dob != null?HMSUtil.convertDateToStringWithoutTime(dob):"" %>" readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<!-- <div class="tableForTab" style="width:auto; height:  425px; overflow: scroll;"> -->
<div class="cmntable">
<table>
	<tr>
	<th>Prescribe</th>
	<th>Name Of Vaccine</th>
	<!-- <th>Dose No.</th> -->
	<!-- <th>Duration</th>  -->
<!-- 	<th>Schedule Date</th> -->
<!-- 	<th>To Date</th> -->
   <!--  <th>Scheduled due date as per DOB</th> -->
   <!--  <th>To date as per DOB</th> -->
	<th>Vaccination  Date</th>
	<th>OP Remarks</th>
<!-- 	<th>Vaccination Date</th>
	<th>Status</th> -->
	</tr>
<%
int i= 1;
int min=0,max=0,doseCount=0,vaccinCode=0;//govind code
int calDay=1,nulCount=1,mstCount=0;
long diff;
Date toDate=new Date(),tempComplDate=new Date(),tempVacDate=new Date();
String tempDate = null,vaccinName="",oldVaccinName="";//end code
System.out.println("vaccineList---"+vaccineList.size());
if(vaccineList.size()>0 && vaccineList != null){ 
	int noOfDays = 0; 
	int days=0;
	int toDays=0;
	for(OpdVaccinMst opdVaccinMst :vaccineList){
		mstCount++;
		if(opdVaccinMst.getDose()==null){
			continue;
		}
		if(opdVaccinMst.getVaccinDuration() != null){
		noOfDays = (Integer)opdVaccinMst.getVaccinDuration();
		min=noOfDays;
		}
		if(opdVaccinMst.getVaccinToDays() != null){
			toDays = (Integer)opdVaccinMst.getVaccinToDays();
			max=toDays;
			}
		if(opdVaccinMst.getDose()!=null){
			doseCount=opdVaccinMst.getDose();
		}
		
		if(opdVaccinMst.getVaccinName()!=null){
			oldVaccinName=opdVaccinMst.getVaccinName();
		}
		
// 		Calendar cal = new GregorianCalendar();
// 		Calendar cal2 = new GregorianCalendar();
// 		cal.setTime(dob);
// 		if(days>0){
// 			cal.add(Calendar.DAY_OF_MONTH, noOfDays+days);
// 			cal2.add(Calendar.DAY_OF_MONTH, toDays+days);
// 			days=0;
// 		}else{
// 			cal.add(Calendar.DAY_OF_MONTH, noOfDays);
// 			cal2.add(Calendar.DAY_OF_MONTH, toDays);
// 		}
		
// 		String vaccineDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
		
// 		String vaccineToDate = HMSUtil.convertDateToStringWithoutTime(cal2.getTime());
//govind code
		Calendar cal = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		cal.setTime(dob);
		cal2.setTime(dob);
		
		/*if(tempDate!=null){
				if(vaccinName.equals(opdVaccinMst.getVaccinName())){
					if(doseCount>1){
				System.out.println("checkComplDate "+tempDate+" vaccinName "+vaccinName);
				diff = tempComplDate.getTime()-tempVacDate.getTime();
				diff=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				calDay=Integer.parseInt(Long.toString(diff));
				System.out.println("calculation Day "+calDay);
				min=min+calDay;
				max=max+calDay;
				System.out.println("vacdate not null dose 2"+" min "+min+" max "+max);				
					cal.add(Calendar.DAY_OF_MONTH, min);
					cal2.add(Calendar.DAY_OF_MONTH, max);
				}
		
			}
			if(doseCount==1){
				System.out.println("vacdate not null dose 1"+" min "+min+" max "+max);
				cal.add(Calendar.DAY_OF_MONTH, min);
				cal2.add(Calendar.DAY_OF_MONTH, max);
			}
			
		}else{
			if(doseCount==1){
				System.out.println("dose 1"+" min "+min+" max "+max);
				cal.add(Calendar.DAY_OF_MONTH, min);
				cal2.add(Calendar.DAY_OF_MONTH, max);
			}
			if(doseCount>1){
				System.out.println("dose 2"+" min "+min+" max "+max);
				cal.add(Calendar.DAY_OF_MONTH, min);
				cal2.add(Calendar.DAY_OF_MONTH, max);
			}
		}*/
		
		String vaccineDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
		String vaccineToDate = HMSUtil.convertDateToStringWithoutTime(cal2.getTime());
		tempComplDate=cal2.getTime();
	%>
		<%
		//String vaccDate = "";
		String completionDate = "";
		String remarks = "";
		String status = "";
		String appointDate = "";
		//System.out.println("mstCount "+mstCount);
		if(vaccinationPlanList.size()>0){ 
		for(OpdVaccinationPlan vaccinationPlan : vaccinationPlanList){			
			if(vaccinationPlan.getVaccin().getId().equals(opdVaccinMst.getId())){
				//System.out.println("nulCount "+nulCount);	
				/* if(vaccinationPlan.getVaccinDate()!=null){
					vaccDate = HMSUtil.convertDateToStringWithoutTime(vaccinationPlan.getVaccinDate());
				} */
				if(vaccinationPlan.getVaccinCompleteDate()!=null){
					//System.out.println("nulCount "+nulCount);	
					completionDate = HMSUtil.convertDateToStringWithoutTime(vaccinationPlan.getVaccinCompleteDate());
					/*tempDate=completionDate;
					tempComplDate=vaccinationPlan.getVaccinCompleteDate();
					tempVacDate=vaccinationPlan.getVaccinDate();
					 //days=HMSUtil.getNoOfDays(cal.getTime(), vaccinationPlan.getVaccinCompleteDate());
					//govind code
					vaccinName=opdVaccinMst.getVaccinName();
					if(vaccinName.equals(opdVaccinMst.getVaccinName())){
					//	System.out.println(" vaccinName "+vaccinName);
				    }*/
					//end code
					//System.out.println("number of days "+days);
				}else{
					tempDate=null;
				}
				
				
				if(vaccinationPlan.getInjAppointDt()!=null)
					appointDate = vaccinationPlan.getInjAppointDt().getInjAppointmentDate()!=null ?HMSUtil.convertDateToStringWithoutTime(vaccinationPlan.getInjAppointDt().getInjAppointmentDate()):"";
				if(vaccinationPlan.getRemarks() != null){
	      		remarks = (String)vaccinationPlan.getRemarks();
				}
				if(vaccinationPlan.getStatus() != null){
		      		status = vaccinationPlan.getStatus().equalsIgnoreCase("y")?"Completed":"Not Completed";
					}
				
				System.out.println(appointDate+"SAfs "+appointDate +" dgssd"+vaccinationPlan.getInjAppointDt() +"ddf "+vaccinationPlan.getInjAppointDt().getInjAppointmentDate());
		break;
		}	
			}
		if(vaccinName.equals(oldVaccinName)){
			//System.out.println("oldVaccinName "+oldVaccinName+" vaccinName "+vaccinName);
		}
		}
		
		
		//added by govind 6-12-2016
		if(immunizationList.size()>0){ 
		for(ImmunizationUtil imm : immunizationList){			
			if(imm.getId().equals(opdVaccinMst.getId())){
				vaccineDate=imm.getScheDate();
				vaccineToDate=imm.getVaccinToDate();
				break;
			}
		}
		}
		//added by govind 6-12-2016 end
		
		
		%>
		<tr>
		
		<!-- added by amit das on 18-10-2016 -->
		<% if(prescribedVaccinList!=null && prescribedVaccinList.size()>0 && prescribedVaccinList.contains(opdVaccinMst.getId())) { 
			if(appointDate!=null && !appointDate.trim().equals("")){
		%>
		<td><input type="checkbox" onclick="toogleVaccinDetails('<%=i%>',this,'${_csrf.parameterName}','${_csrf.token}')" checked="checked" id="vaccineItemPvmsNo<%=i %>" disabled="disabled" name="vaccineItemPvmsNo<%=i %>"  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" />
		<%-- <input type="hidden" id="checkItem<%=i%>" name="checkItem<%=i%>" value="Y" />  --%>
		</td> <!-- added by amit das on 19-09-2016 -->
		<%} else{ %>
		<td><input type="checkbox" onclick="toogleVaccinDetails('<%=i%>',this,'${_csrf.parameterName}','${_csrf.token}')"   checked="checked" id="vaccineItemPvmsNo<%=i %>"  name="vaccineItemPvmsNo<%=i %>"  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" />
		<input type="hidden" id="checkItem<%=i%>" name="checkItem<%=i%>" value="Y" /> 
		</td> <!-- added by amit das on 19-09-2016 -->
			
		<% }
		} else { 
			if(appointDate!=null && !appointDate.trim().equals("")){
		%>
		<td><input type="checkbox" disabled="disabled"  id="vaccineItemPvmsNo<%=i %>"  name="vaccineItemPvmsNo<%=i %>"  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" />
		<input type="hidden" id="checkItem<%=i%>" name="checkItem<%=i%>" value="N" /> 
		</td> <!-- added by amit das on 15-09-2016 -->
		<% } else { %>
		<td><input type="checkbox"  onclick="toogleVaccinDetails('<%=i%>',this,'${_csrf.parameterName}','${_csrf.token}')"  id="vaccineItemPvmsNo<%=i %>"  name="vaccineItemPvmsNo<%=i %>"  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" />
		<input type="hidden" id="checkItem<%=i%>" name="checkItem<%=i%>" value="N" /> 
		</td> <!-- added by amit das on 15-09-2016 -->
		
		<% } 
		}%>
		<!-- ended by amit das on 18-10-2016 -->
		
		<td><%=opdVaccinMst.getVaccinName() != null ? opdVaccinMst.getVaccinName():"" %>
		<input type="hidden" name = "vaccineId<%=i %>"  value="<%=opdVaccinMst.getId() != null ? opdVaccinMst.getId():"" %>" />
		<input type="hidden" name = "vaccineItemId<%=i %>"  value="<%=opdVaccinMst.getMasStoreItem() != null ? opdVaccinMst.getMasStoreItem().getId():"" %>" />
		</td>
		<td>
		<%=opdVaccinMst.getDose() != null ? opdVaccinMst.getDose():"" %>
		</td>
		<%-- <td><%=opdVaccinMst.getVaccinDuration() != 0 ? opdVaccinMst.getVaccinDuration():"" %>
		<input type="hidden" name = "noOfDays<%=i %>" id="noOfdays<%=i %>"  value="<%=opdVaccinMst.getVaccinDuration() != 0 ? opdVaccinMst.getVaccinDuration():"" %>"  /></td>
	 --%>
	<%-- 	<td>
		<input type="text" size="20" value="<%=vaccineDate %>" name="vaccineDate<%=i %>" id="vaccineDateId<%=i %>" class="date" validate="Vaccine date,string,no" readonly="readonly"/>
		</td> --%>
<%-- <td>
<input type="text" size="20" value="<%=vaccineToDate %>" name="vaccineToDate<%=i %>" id="vaccineToDateId<%=i %>" class="date" validate="Vaccine date,string,no" readonly="readonly"/>
</td> --%>		
	<!-- <td><input type="text" size="20" value="<%=completionDate %>" name="completionDate<%=i %>" id="completionDateId<%=i %>" class="date" validate="completion Date,string,no"  onblur="checkCompilationDate(<%=i %>)"/> -->	
	<td><input type="text" size="20"  name="completionDate<%=i %>" id="completionDateId<%=i %>" class="date" validate="completion Date,string,no" readonly="readonly" value="<%=appointDate%>"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.vaccineDetail.completionDate<%=i %>,event)" /></td>
	<td><input type="text" name = "remarks<%=i %>"  value="<%=remarks %>" size="50"/></td>
	<%-- <td><input type="text"  value="<%=completionDate%>" readonly="readonly" /></td>
	 
	<td><input type="text"  value="<%=status%>" readonly="readonly"/> </td> --%>
	
	
		</tr>
	<%-- 	<tr id="vaccinDetails<%=i%>" style="display: none;">
		<td><input type="hidden" name="pvsmNo<%=i%>" id="pvsmNo<%=i%>" value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" > </td>
		<td>
		<!-- <label>Route</label> -->
		</br>
		 <select name="route<%=i%>" id="route<%=i%>" style="width: 90px; background: #FFFF99" >
												<!-- <option value="0">Select Route</option> -->
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
							   	  				if(routeOfAdministration.getRouteName().equalsIgnoreCase("oral")){
							   	  				%>
							   	  				<option selected="selected" value="<%=routeOfAdministration.getId() %>"><%=routeOfAdministration.getRouteName()%></option>
							   	  				<%} else { %>
												<option  value="<%=routeOfAdministration.getId()%>"><%=routeOfAdministration.getRouteName()%></option>
												<% } } %>
										</select> 
		</td>
		<td>
		<label>Dosage</label>
		</br>
		<input class="textYellow opdTextBoxTSmall" readonly placeholder="Dosage"  type="text" name="dosage<%=i%>" id="dosage<%=i%>" value="" size="10" maxlength="45" >
		</td>
		
		<td>
		<label>Unit</label>
		</br>
		<input type="text"  placeholder="Unit" name="unit<%=i%>" value="" class="textYellow opdTextBoxTSmall" id="unit<%=i%>" readonly="readonly" size="5" onblur="fillValue(this.value,0);">
		</td>
		
		</tr> --%>
		
		<%i++;
		
	}} %>
	<input type="hidden" id="totalVaccinNo" value="<%=i%>">	
</table>
</div>

 <input	type="hidden" name="count" id="count"	value="<%=i %>" />
 <input	type="hidden" name="pHeaderId" id="pHeaderId"	value="<%=pHeaderId%>" />
<div class="clear"></div>

<%-- <input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('vaccineDetail','pubHealth?method=submitVaccineDetail&flag=opd&visitId=<%=visitId %>&inpatientId=<%=inpatientId %>','validateGridData');" /> --%>
<input name="button"  type="button"	value="Submit" class="button"	onClick="callOtherDiagnosis();" />
<script type="text/javascript">

function validateGridData() {
	var count = document.getElementById("count").value;
	var flag = false;
	for (var inc = 1; inc < count; inc++) {
		var completionDate = document.getElementById("completionDateId" + inc).value
		if (completionDate != "" ) {
			flag = true;
			break;
		}
	}
	if(!flag){
		alert("Please Select completion Date ");
		return false;

	}
	return true;
}


function toogleVaccinDetails(i,j,csrfTokenName,csrfTokenValue){
	if(j.checked){
		document.getElementById("vaccinDetails"+i).style.display = '';
		document.getElementById("dosage"+i).value = '1';
		displayAu(i,csrfTokenName,csrfTokenValue);
		document.getElementById("checkItem"+i).value = 'Y';
	}else{
		document.getElementById("vaccinDetails"+i).style.display = 'none';
		document.getElementById("checkItem"+i).value = 'N';
	} 
}


function checkCompilationDate(inc){ 
	var vDate=document.getElementById("vaccineDateId" + inc).value;
	var cDate=document.getElementById("completionDateId" + inc).value;
	var vToDate=document.getElementById("vaccineToDateId" + inc).value;
	var regExp = /(\d{1,2})\/(\d{1,2})\/(\d{2,4})/;
	//alert(parseInt(cDate.replace(regExp, "$3$2$1")));
	//alert(parseInt(vDate.replace(regExp, "$3$2$1")));
	//alert(parseInt(vToDate.replace(regExp, "$3$2$1")));
	if(parseInt(cDate.replace(regExp, "$3$2$1")) >= parseInt(vDate.replace(regExp, "$3$2$1")) && parseInt(cDate.replace(regExp, "$3$2$1"))<=parseInt(vToDate.replace(regExp, "$3$2$1"))){
		//alert("in if 1");
	return true;
	}else{
		//
		document.getElementById("completionDateId" + inc).value="";
		//alert("Vaccination date should be in between sceduled dates!!");
		return false;
	}
	
	
}


// added by amit das on 15-09-2016
window.onbeforeunload = closingCode;

//added by amit das on 15-09-2016
function closingCode(){
		var checkBoxName  = 'vaccineItemPvmsNo';
		var totalVaccinNo =	 document.getElemenyById('totalVaccinNo').value;
		var pvms = '';
		for(var i=0;i<totalVaccinNo;i++){
			if(document.getElemenyById('totalVaccinNo'+i).checked){
				pvms = pvms+document.getElemenyById('totalVaccinNo').value+',';
			}
		}
		
	 	var elementId = 'vaccinPvms';
	 	var elementValue = 	pvms;
		window.opener.setVaccinPvms(elementId,elementValue);
}


function displayAu(inc,csrfTokenName,csrfTokenValue) {
		var pvmsNo = document.getElementById('pvsmNo'+inc).value;
		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];

					var au = item.getElementsByTagName("au")[0];
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQty")[0];
					var stock = item.getElementsByTagName("stock")[0];

					/* if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					} */
					
				/* 	if (document.getElementById('actualDispensingQty' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQty' + inc).value = 0;

						}
					} */
					document.getElementById('unit'+inc).value = au.childNodes[0].nodeValue;
					
				}
			}
		}
		var url = "/hms/hms/opd?method=displayAU&pvmsNo=" + pvmsNo + "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	
}

function callOtherDiagnosis(){
// 	/*var formName ="vaccineDetail";
// 	// var url = "/hms/hms/pubHealth?method=submitVaccineDetail";
<%-- 	 var data = "&flag=opd&visitId="+<%=visitId %>+"&inpatientId="+<%=inpatientId %>+"&"+getNameAndData(formName); --%>
// submitForm("vaccineDetail","pubHealth?method=submitVaccineDetail"+data);*/

var count=0;
var j=0;
if(document.getElementById("count"))
	count=document.getElementById("count").value;
	
	for(var i=1;i<=count;i++)
		{

		  if( document.getElementById("checkItem"+i)!=null && document.getElementById("checkItem"+i).value=="Y" )
			  {
			  j++;
			     if( document.getElementById("completionDateId"+i)!=null &&document.getElementById("completionDateId"+i).value=="")
			    	 {
			    	 alert("Please select vaccination date");
			    	 return false;
			    	 }
			  }
		}
	 if(j==0)
	  { alert("select atleast one row to submit");
   	   return false;}
	var formName ="vaccineDetail";
	 var url = "/hms/hms/opd?method=submitVaccineDetail";
	 var data = "&flag=opd&visitId="+<%=visitId %>+"&inpatientId="+<%=inpatientId %>+"&"+getNameAndData(formName);
	jQuery(function ($) {
		  
    	$.ajax({
			type:"POST",
			url: url,	
			data: data,	
			cache: false,
			success: function(msg)
			{									 
				
				alert("Records Saved Sucessfully");
				
			},
			error: function(msg)
			{					
				
				alert("An error has occurred while contacting the server");
				}
		});
    });   
	//window.opener.location = window.opener.location;
	window.opener.document.getElementById("OtherDiagnosis").value="Vaccination";
	window.close();
}



</script>

</form>


