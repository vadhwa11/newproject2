<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.masters.business.MasInjuryNature"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	List<MasInjuryNature> injuryNatureList = new ArrayList<MasInjuryNature>();
	if(map.get("injuryNatureList") != null){
		injuryNatureList = (List<MasInjuryNature>)map.get("injuryNatureList");
	}
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
	}
	Patient patient = null;
	if(patientList.size() > 0){
		patient = patientList.get(0);
	}
	
	String adNo = "";
	if(map.get("adNo")!=null){
		adNo = (String)map.get("adNo");
	}
	int inpatientId = 0;
	if(map.get("inpatientId")!=null){
		inpatientId = (Integer)map.get("inpatientId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTimeWithoutSc");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String mlcNo = "";
	if(map.get("mlcNo")!=null){
		mlcNo = (String)map.get("mlcNo");
	}
	String backFlag = "";

	if(map.get("backFlag") != null){
		backFlag = (String)map.get("backFlag");
	}
%>



<%@page import="jkt.hms.util.HMSUtil"%>
<form name="mlcCase" method="post">
<div class="titleBg"><h2>MLC Details</h2></div>
<div class="clear"></div>

<div class="Block">
<%
	if(!adNo.equals("")){
%>
<label>A&D No. </label>
<input type="text" name="<%=AD_NO %>" tabindex="1" id="adNo" value="<%=adNo %>" validate="A&D No.,alphanumericSlash,yes" /> 
<input type="hidden" name="<%=INPATIENT_ID %>" id="inpatientId" value="<%=inpatientId %>" tabindex="1" /> 
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="<%=(patient!=null?patient.getId():"0") %>" tabindex="1" /> 

<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>" tabindex="1" id="serviceNo" value="<%=(patient!=null && patient.getServiceNo()!=null?patient.getServiceNo():"") %>" validate="Service No.,metachar,yes" /> 
<script>document.getElementById('adNo').focus();</script>
<%}else{ %>

<label>Service No. <span>*</span></label>
<input type="text" name="<%=SERVICE_NO %>" tabindex="1" id="serviceNo" value="<%=(patient!=null && patient.getServiceNo()!=null?patient.getServiceNo():"") %>" validate="Service No.,metachar,yes" onblur="if(this.value!=''){submitProtoAjaxWithDivName('mlcCase','/hms/hms/adt?method=getHinNoForMlc','hinDiv');}"/> 
<div id="hinDiv">
<label>HIN <span>*</span></label>
<input type="text" name="<%=HIN_NO %>" id="hinNo" value="<%=(patient!=null?patient.getHinNo():"") %>" tabindex="1" /> 
<input type="hidden" name="<%=HIN_ID %>" id="hinId" value="<%=(patient!=null?patient.getId():"0") %>" tabindex="1" /> 
</div>

<%
	if(patient!=null ){
		
	}else{
	%>
	<script>
	document.getElementById('serviceNo').focus();</script>
<%}%> 
<%} %>
<label>MLC No. <span>*</span></label>
<input type="text" name="<%=MLC_NO %>" id="mlcNo" value="<%= mlcNo %>" tabindex="1"  validate="MLC No.,alphanumericSlash,yes" /> 

<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="Block">
<div id="testDiv">
<label>Patient Name</label> 
<%
	if(patient!=null){
%>
<label	class="value"><%=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"") %></label>
<%}else{ %>
<label	class="value">&nbsp;</label>
<%} %> 
<label>Relation</label>
<%
	if(patient!=null){
%>
<label class="value"><%=(patient.getRelation()!=null?patient.getRelation().getRelationName():"") %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>

<label>Rank</label>
<%
	if(patient!=null){
%>
<label class="value"><%=(patient.getRank()!=null?patient.getRank().getRankName():"") %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>

<label>Name</label> 
<%
	if(patient!=null){
%>
<label class="value"><%=(patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"") %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Unit</label> 
<%
	if(patient!=null){
%>
<label class="value"><%=patient.getUnit()!=null?patient.getUnit().getUnitName() :""%></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
<label>Trade/Branch</label> 
<%
	if(patient!=null){
%>
<label class="value"><%=(patient.getTrade()!=null?patient.getTrade().getTradeName():"")%></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Age</label> 
<%
	if(patient!=null){
		if(patient.getAge()!=null){
		String age = patient.getAge();
		String currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
%>
<label class="value"><%=currentAge%></label>
<%}
	}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<label>Gender</label> 
<%
	if(patient!=null){
%>
<label class="value"><%=(patient.getSex()!=null?patient.getSex().getAdministrativeSexName():"")%></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
</div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>MLC Details</h4>
<div class="Block">
<label>Arrival Date</label>
<input type="text" id="arrivalDate" class="date" name="arrivalDate" value="" tabindex="1" validate="Arrival Date,string,no" MAXLENGTH="10"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'arrivalDate');checkDateLessThanEqualToCurrent(this.value,this);"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.mlcCase.arrivalDate,event)" />

<label>Arrival Time</label>
<input type="text" id=arrivalTime" name="arrivalTime" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" value="" validate="Arrival Time,String,no" onblur="IsValidTime(this.value,this.id);" maxlength="5"/> 

<label>Brought By </label> 
<input type="text" name="<%= BROUGHT_BY %>" tabindex="1"  value="" validate="Brought By,fullName,no" maxlength="100"> 
<div class="clear"></div>
<label>Nature of MLC </label> 
<select name="<%= NATURE_OF_MLC %>" validate="Nature of MLC,String,no" tabindex="1" >
<option value="">Select</option>
<option value="Major">Major</option>
<option value="Minor">Minor</option>
</select> 


<label>Nature of Injury</label> 
<select name="<%= INJURY_NATURE_ID %>" tabindex="1" validate="Nature of Injury,String,no">
<option value="0">Select</option>
	<% 
		for (MasInjuryNature obj : injuryNatureList){
	%>
<option value="<%=obj.getId ()%>"><%=obj.getInjuryNatureName()%></option>
	<% }%>
</select> 

<label>Type of Injury </label> 
<select name="<%= INJURY_TYPE %>" tabindex="1" validate="Type Of Injury,String,no">
<option value="">Select</option>
<option value="Burning">Burning</option>
<option value="Poisoning">Poisoning</option>
<option value="RTA">RTA</option>
</select>

<div class="clear"></div>
<label>Police/Docket No.</label>
<input type="text" id="policeDocketNo" name="policeDocketNo" tabindex="1" value="" validate="Police/Docket No.,String,no" maxlength="30"/> 
<label>Constable Name</label>
<input type="text" id="constableName" name="constableName"  tabindex="1" value="" validate="Constable Name,String,no"  maxlength="30"/> 

<label>Constable No.</label>
<input type="text" id="constableNo" name="constableNo"  tabindex="1" value="" validate="Constable No.,int,no"  maxlength="5"/> 

<div class="clear"></div>
<label>Identification Mark1</label>
<textarea id="idMark1" name="idMark1" value="" tabindex="1" validate="Identification Mark1,String,no"  maxlength="50"  onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea> 

<label>Identification Mark2</label>
<textarea id="idMark2" name="idMark2" value="" tabindex="1"  validate="Identification Mark2,String,no"   maxlength="50"  onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea> 

<label>Item Deposited With</label>
<input type="text" id="itemDeposited" name="itemDeposited"  tabindex="1" value="" validate="Item Deposited,String,no"  maxlength="50"/> 
<div class="clear"></div>

<label>Item Details</label>
<textarea rows="" cols="" name="itemDetails"  tabindex="1" maxlength="50" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<label>Kit Details</label>
<textarea rows="" cols="" name="kitDeposited" tabindex="1"  maxlength="50" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Medical Details</h4>
<div class="Block">

<label>History</label>
<textarea rows="" cols="" name="injuryPoisonHistory"  tabindex="1" maxlength="1000" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<label>Examination</label>
<textarea rows="" cols="" name="injuryNomenclature"  tabindex="1" maxlength="1000" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<label>Weapon Used Suspected</label>
<textarea rows="" cols="" name="weaponUsed"  tabindex="1" maxlength="200" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>
<div class="clear"></div>
<label>Diagnosis</label>
<textarea rows="" cols="" name="caseSummary"  tabindex="1" maxlength="1000"  onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<label>Treatment Given</label>
<textarea rows="" cols="" name="injuryDescription" tabindex="1"  maxlength="1000"  onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>

<label>Disposal</label>
<input type="text" id="disposal" name="disposal"  tabindex="1" value="" validate="disposal,String,no"  maxlength="50"/> 
<div class="clear"></div>
<label>Agency Informed</label> 
<textarea name="agencyInformed" validate="Agency Informed,remarks,no" tabindex="1" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="500" />
</textarea>

<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Police Report</h4>
<div class="Block">

<label>Police Station</label>
<input type="text" id="<%=POLICE_STATION %>" name="<%=POLICE_STATION %>" value="" tabindex="1" validate="Police Station,String,no"  maxlength="30" onblur="displayDateTime(this.value);"/> 

<label>Sent Date</label>
<input type="text" id="sentDate" name="sentDate" value="" class="date" tabindex="1"  readonly="readonly" validate="Sent Date,string,no" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'sentDate');checkDateLessThanEqualToCurrent(this.value,this);"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" tabindex="1" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.mlcCase.sentDate,event)" />

<label>Sent Time</label>
<input type="text" id="sentTime" name="sentTime" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" value="" validate="Sent Time,String,no" onblur="IsValidTime(this.value,this.id);"  maxlength="5"/> 
<input name="backFlag" type="hidden" value="<%=backFlag %>"/>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit11" value="Submit" class="button" tabindex="1" onClick="submitForm('mlcCase','/hms/hms/adt?method=submitMLCDetails');" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onclick="location.reload();" accesskey="r" />
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
<script type="text/javascript">
function displayDateTime(val){
	if(val!=''){
		document.getElementById('sentDate').value = '<%=currentDate%>'
		document.getElementById('sentTime').value = '<%=currentTime%>'
	}else{
		document.getElementById('sentDate').value = ''
		document.getElementById('sentTime').value = ''
	}
}

</script>
</form>
