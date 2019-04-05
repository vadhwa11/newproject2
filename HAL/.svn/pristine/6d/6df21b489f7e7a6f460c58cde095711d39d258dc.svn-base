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
<%@page import="jkt.hms.masters.business.MasCaLicence"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
 	List<MasCaLicence> caLicenceList=null;
 	List<MasTitle> titleList=null;
 	List<MasOccupation> occupationList = null;
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
 	if(map.get("titleList") != null){
		titleList = (List<MasTitle>)map.get("titleList");
	}
 	if(map.get("occupationList") != null){
		occupationList = (List<MasOccupation>)map.get("occupationList");
	}
 	if(map.get("caLicenceList") != null){
		caLicenceList = (List<MasCaLicence>)map.get("caLicenceList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
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

<div class="titleBg">
<h2>Renewal Application</h2>
</div>
<form name="renewableApp" method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>  Licence No.<span>*</span></label> <%-- 
<input	type="text" name="<%=LICENCE_NO%>" value=""	validate="Licence No,string,no" maxlength="16" />--%>
<input	type="text" name="<%=LICENCE_NO%>" value=""	validate="Licence No,metachar,yes" maxlength="15" 
onblur="submitProtoAjaxWithDivName('renewableApp','/hms/hms/aviationMedicine?method=getDetailBasedLicenceNo','detailDiv');"/>
<div class="clear"></div>
<div id="detailDiv">
<input name="avCA34" value="" type="hidden"/>
<label> Title</label>
<select	id="title" name="<%=TITLE_ID %>" validate="Title,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(titleList!=null && titleList.size() >0){
	 for(MasTitle masTitle : titleList){
	
	%>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%}
	}%>
</select>
<input type="hidden" value="" name="hinId" id="hinId"/>
<input type="hidden" value="" name="visitId" id="visitId"/>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1" title="First Name"	validate="First Name,name,yes" MAXLENGTH="32" />

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>" value="" validate="Last Name,name,no" MAXLENGTH="32"	tabindex="1" /> 

<div class="clear"></div>

<label> Nationality</label> 
<input type="text"	id="nationality" name="<%=NATIONALITY %>" tabindex="1" value=""	  MAXLENGTH="30"	/> 

<label> Place of Birth</label> 
<input type="text"	id="placeOfBirth" name="<%=PLACE_OF_BIRTH %>" tabindex="1" value=""	validate="Place of Birth,metachar,no" MAXLENGTH="50"	/> 

<label>DOB</label> 
<input type="text" id="srdobId" name="<%=SR_DOB %>"	tabindex="1" value="" validate="Date of Birth,date,no" MAXLENGTH="7" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"onblur="calculateAVAgeInAjax();" /> 
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',renewableApp.<%=SR_DOB%>,event);" />

<div class="clear"></div>
<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes" tabindex="1" class="smaller">
<option value="">Select</option>
<%
			for(int age1 = 16;age1<=100;age1++){
			%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<label class="unit" >Years</label>
<input type="hidden" id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly" size="4"
class="auto"/>

</div>
<input class="transparent" size="4">
<input type="hidden" id="idForSrAge" value=""/>
<label>Gender</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="Gender,metachar,yes" tabindex="1">
<option value="0">Select</option>
<%
	for(MasAdministrativeSex masAdministrativeSex : sexList){
		if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode)){%>
	<option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%		}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%	}
		   	 	} %>
</select> 
<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(occupationList!=null && occupationList.size() >0){
	 for(MasOccupation masOccupation : occupationList){
	
	%>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%}
	}%>
</select>

<div class="clear"></div>
<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Local Address,string,no" maxlength="100"
 onkeyup="chkLength(this,100);" ></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>" validate="City,metachar,no" id="srcityId" tabindex="1" onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,metachar,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','srcityId')">
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
<input id="<%=TELEPHONE_NO %>" name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="12" /> 

<label>Mobile No.</label> 
<input id="<%=MOBILE_NO %>" name="<%=MOBILE_NO %>" type="text" tabindex="1"	maxlength="12" />

<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Permanent Address,string,no" maxlength="100" onkeyup="return ismaxlength(this)" ></textarea>
	
<label>City</label> 
<select name="<%=PERMANENT_CITY_ID %>" validate="City,metachar,no" id="perCityId" tabindex="1" onblur="populateStateCity(this.value,'permStateId');">
	<option value="0">Select</option>
	<%
		for(MasDistrict pmasDistrict : districtList){
	%>
	<option value="<%=pmasDistrict.getId()%>"><%=pmasDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="permStateId" name="<%=PERMANENT_STATE_ID %>" 	validate="State,metachar,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','perCityId')">
	<option value="0">Select</option>
	<%
		for(MasState pmasState : stateList){
	%>
	<option value="<%=pmasState.getId() %>"><%=pmasState.getStateName() %></option>
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

<label>  Type of Licence applied</label> 
<select	name="<%=TYPE_OF_LICENCE %>" validate="Type of Licence applied,metachar,no"	id="<%=TYPE_OF_LICENCE %>" >
	<option value="0">Select</option>
	<%
		for(MasCaLicence masCaLicence : caLicenceList){
	%>
	<option value="<%=masCaLicence.getId()%>"><%=masCaLicence.getCaLicenceName() %></option>
	<%		
		}%>
</select> 
<label>  Licence Held</label> 
<select	name="<%=LICENCE_HELD %>" validate="Licence Held,metachar,no"		id="<%=LICENCE_HELD %>">
	<option value="0">Select</option>
	<%
		for(MasCaLicence licenceHeld : caLicenceList){
	%>
	<option value="<%=licenceHeld.getId()%>"><%=licenceHeld.getCaLicenceName() %></option>
	<%		
		}%>
</select> 
</div>
<label>Renewal Due Date<span>*</span></label> 
<input type="text" id="renewalDateId" name="<%=RENEWAL_DATE %>" tabindex="1" value=""	
onkeyup="mask(this.value,this,'2,5','/');" validate="Renewal Due Date,date,yes" maxlength="10" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	 class="calender" onClick="setdate('<%=currentDate%>',document.renewableApp.renewalDateId,event)" />

</div>
<div class="clear"></div>
<div class="division"></div>
<input	type="button" name="Submit" value="Submit" onClick="if(validateRenewalDate())submitForm('renewableApp','aviationMedicine?method=submitRenewableApplication');" tabindex="1"	class="buttonbig"  />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1"  accesskey="r" />
<div class="clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
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
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}
	function validateRenewalDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.renewableApp.renewalDate);
		obj2 = eval(document.renewableApp.<%=CHANGED_DATE %>);
			
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			if(validFromDate < validToDate)
			
				{
				alert("Renewal Due Date should not be less than Current date\n");
				return false;
				}
		
		}
		return true;
	}
</script>

</form>