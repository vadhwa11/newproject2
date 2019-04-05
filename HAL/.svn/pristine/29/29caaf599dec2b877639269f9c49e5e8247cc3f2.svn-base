<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasServiceType"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasComplaint"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.Category"%>

<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<form name="renewableApp" method="post" action="">


<%
	Properties properties = new Properties();
	URL resourcePathHIC = Thread.currentThread()
			.getContextClassLoader().getResource(
					"hicDetails.properties");
	try {
		properties.load(resourcePathHIC.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String urlForImportFromHIC = properties
			.getProperty("urlForImportFromHIC");
%> <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<MasAdministrativeSex> sexList = null;
 	List<MasDistrict> districtList = null;
 	List<MasState> stateList = null;

 	String administrativeSexMaleCode = properties
 			.getProperty("administrativeSexMaleCode");

 	if (map.get("sexList") != null) {
 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
 	}
 	if (map.get("districtList") != null) {
 		districtList = (List<MasDistrict>) map.get("districtList");
 	}
 	if (map.get("stateList") != null) {
 		stateList = (List<MasState>) map.get("stateList");
 	}
 %>
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
</script> 

<div class="titleBg"><h2>Medical Exam Application</h2></div>

<div class="Block">

<label>First Name <span>*</span></label> 
<input	id="sFNameId" type="text" name="<%=S_FIRST_NAME%>" value=""	tabindex="1" title="First Name of Service Person"	validate="First Name of Service Person,alphaspace,yes" MAXLENGTH="15"	onblur="fillPatientName(this);" /> 


<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name of Service Person,alphaspace,no"	MAXLENGTH="15" onchange="fillPatientName(this);" /> 


<label>Last Name</label>
 <input id="sLNameId" type="text" name="<%=S_LAST_NAME%>" value=""	tabindex="1" validate="Last Name of Service Person,alphaspace,no"	MAXLENGTH="15" onchange="fillPatientName(this);" />
 
 
<div class="clear"></div>

<label> Gender<span>*</span></label> 

<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,string,yes" tabindex="1">
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
		   	 			if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode)){
			%>
	<option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%		}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
					}
		   	 	} %>
</select> 

<label>DOB</label> 
<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH%>" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"	onblur="validateExpDate(this,'dobId'); calculateAgeInAjax();"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.renewableApp.<%=DATE_OF_BIRTH%>,event)" />

<label> Age<span>*</span></label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest">
	<option value="">Select</option>
	<%
		for (int age1 = 1; age1 <= 100; age1++) {
	%>
	<option value="<%=age1%>"><%=age1%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>

<label>Local Address</label> 
<textarea name="<%=ADDRESS%>" id="addr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	onblur=""></textarea> 
	
<label>City</label>
<select name="<%=DISTRICT%>"	validate="City,string,no" id="cityId" tabindex="1"	onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<label>State</label>
<select id="srstateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'renewableApp','cityId')">
	<option value="0">Select</option>
	<%

		for(MasState masState : stateList){
	
	%>
	
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%		
		}%>
</select>

<div class="clear"></div>

<label>Telephone No.</label>
<input id="phoneNo"	name="<%=TELEPHONE_NO%>" type="text" tabindex="1" maxlength="11" /> 

<label>Mobile No.</label>
<input id="mobileNo" name="<%=MOBILE_NO%>" type="text" tabindex="1"	maxlength="11" />

<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<label>City</label> 
<select name="<%=PERMANENT_CITY_ID %>" validate="City,string,no" id="perCityId" tabindex="1" onblur="populateStateCity(this.value,'permStateId');">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="permStateId" name="<%=PERMANENT_STATE_ID %>" 	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','perCityId')">
	<option value="0">Select</option>
	<%

		for(MasState masState : stateList){
	
	%>
	
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%		
		}%>
</select>

<script>
<%
int i = 0;
for (MasState masState : stateList)
{
	for (MasDistrict masDistrict : districtList) 
	{
		if(masDistrict.getState() != null){
			if(masState.getId().equals(masDistrict.getState().getId() )){
					%>
						districtArray[<%=i%>] = new Array();
						districtArray[<%=i%>][0]=<%=masState.getId()%>;
						districtArray[<%=i%>][1] = <%=masDistrict.getId()%>;									
						districtArray[<%=i%>][2] = "<%=masDistrict.getDistrictName()%>";

					<%
					i++;
			}
		}
	}
}

%>
</script>

<div class="clear"></div>
<label>Licence Applied For<span>*</span></label>
<select id="licenceId"	name="licenceId" validate="Licence,string,no" tabindex="1">
	<option value="0">Select</option>
</select>

<div class="clear"></div>

<label>Licence Held Type<span>*</span></label>
<input id="licenceHeldId" type="text"	name="licenceHeldId" value="" tabindex="1" title="Licence Held Type"	validate="Licence Held Type,alphaspace,yes" MAXLENGTH="50" /> 

<label>LicenceNo.<span>*</span></label>
<input id="licenceNo" type="text" name="licenceNo" value=""	tabindex="1" title="Licence No" validate="Licence No,alphaspace,yes"	MAXLENGTH="50" />

<label>Renewal Due Date<span>*</span></label> 
<input type="text" id="renewalDateId"	name="renewalDateId" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"	onblur="validateExpDate(this,'dobId'); calculateAgeInAjax();"	validate="Renewal Due Date,date,no" MAXLENGTH="30" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.renewableApp.renewalDateId,event)" />

</div>

</div>

<div class="clear"></div>
<div class="division"></div>

<input type="button" name="Submit11" value="Submit" tabindex="1" class="button"	 />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1" onClick="{clearHin();}" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
</form>
<script type="text/javascript">

function populateStateForCity(city,stateFieldId){
	var state = 0;
	for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1] == city){
			state = districtArray[i][0];
			break;		
			}
		}
	document.getElementById(stateFieldId).value = state;
	if(stateFieldId == 'srstateId'){
		document.getElementById('srstateId').value = state;
	}
	
}
function populateStateCity(city,stateFieldId){
	var state = 0;
	for(i=0;i<districtArray.length;i++){
		if(districtArray[i][1] == city){
			state = districtArray[i][0];
			break;		
			}
		}
	document.getElementById(stateFieldId).value = state;
	if(stateFieldId == 'permStateId'){
		document.getElementById('permStateId').value = state;
	}
	
}

</script>

