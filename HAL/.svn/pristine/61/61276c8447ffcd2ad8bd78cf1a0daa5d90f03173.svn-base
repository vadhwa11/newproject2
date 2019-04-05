<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.AviCa34"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasCaLicence"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasDistrict> districtList =new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasCaLicence> caLicenceList=new ArrayList<MasCaLicence>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("medExamWaitingList") != null){
			medExamWaitingList = (List<AviCa34>)map.get("medExamWaitingList");
		}
		if(map.get("titleList") != null){
			titleList = (List<MasTitle>)map.get("titleList");
		}
		if(map.get("occupationList") != null){
			occupationList = (List<MasOccupation>)map.get("occupationList");
		}
		if(map.get("districtList") != null){
			districtList = (List<MasDistrict>)map.get("districtList");
		}
		if(map.get("stateList") != null){
			stateList = (List<MasState>)map.get("stateList");
		}
		if(map.get("countryList") != null){
			countryList = (List<MasCountry>)map.get("countryList");
		}
		if(map.get("caLicenceList") != null){
			caLicenceList = (List<MasCaLicence>)map.get("caLicenceList");
		}
		if (map.get("sexList") != null) {
	 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	 	}
		AviCa34 aviCa34=new AviCa34();
		if(medExamWaitingList.size() > 0){
			aviCa34 = medExamWaitingList.get(0);
		}
%>
<div id="detailDiv">
<%
	String firstName="";
	String lastName="";
	String birthPlace="";
	String dob="";
	String localAddress="";
	String telphoneNo="";
	String mobileNo="";
	String permanentAdd="";
	String nationality="";
	int occupationId=0;
	int titleId=0;
	int avCA34Id=0;
	if( aviCa34.getId() !=null ){
		avCA34Id=aviCa34.getId();
	}
	if(aviCa34.getFirstName() !=null){
	firstName=aviCa34.getFirstName();
	}
	if(aviCa34.getLastName() !=null){
		lastName=aviCa34.getLastName();
	}
	if(aviCa34.getPlaceOfBirth() !=null){
		birthPlace=aviCa34.getPlaceOfBirth();
	}
	if(aviCa34.getDob() !=null){
		dob=HMSUtil.changeDateToddMMyyyy(aviCa34.getDob());
	}
	
	if(aviCa34.getLocalAddress() !=null){
	localAddress=aviCa34.getLocalAddress() ;
	}
	if(aviCa34.getPermanentAddress() !=null){
		permanentAdd=aviCa34.getPermanentAddress() ;
		}
	
	if(aviCa34.getTitle() !=null){
		if(aviCa34.getTitle().getId()!=null){
	titleId=aviCa34.getTitle().getId();
	}
	}
	if(aviCa34.getOccupation() !=null){
		if(aviCa34.getOccupation().getId()!=null){
			occupationId=aviCa34.getOccupation().getId();
	}
	}
	if(aviCa34.getTelephoneNo() !=null ){
		telphoneNo=aviCa34.getTelephoneNo();
	}
	if(aviCa34.getMobileNo() !=null){
		mobileNo=aviCa34.getMobileNo();
	}
	if(aviCa34.getNationality() !=null){
	nationality=aviCa34.getNationality();
	}
%>
<input name="avCA34" value="<%=avCA34Id %>" type="hidden"/>
<label> Title</label> 

<select	id="title" name="<%=TITLE_ID %>" validate="Title,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(titleList!=null && titleList.size() >0){
	 for(MasTitle masTitle : titleList){
		 if(aviCa34.getTitle() !=null){
	if((aviCa34.getTitle().getId()).equals(masTitle.getId())){
	%>
	<option value="<%=masTitle.getId()%>" selected="selected"><%=masTitle.getTitleName()%></option>
	<%}else{ %>
	 <option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<% } }else{%>
	 <option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%}}}%> 
</select>
<%if(aviCa34.getHin() !=null){ %>
<input type="hidden" value="<%=aviCa34.getHin().getId() %>" name="hinId" id="hinId"/><%}else{ %>
<input type="hidden" value="" name="hinId" id="hinId"/><%} %>
<%if(aviCa34.getVisit() !=null){ %>
<input type="hidden" value="<%=aviCa34.getVisit().getId() %>" name="hinId" id="hinId"/><%}else{ %>
<input type="hidden" value="" name="visitId" id="visitId"/><%} %>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=firstName %>" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="32" />

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>" value="<%=lastName%>" validate="Patient Last Name,name,no" MAXLENGTH="32"	tabindex="1" /> 

<div class="clear"></div>

<label> Nationality</label> 
<input type="text"	id="nationality" name="<%=NATIONALITY %>" tabindex="1" value="<%=nationality %>" MAXLENGTH="22"	
 validate="Nationality,metachar,no"/> 

<label> Place of Birth</label> 
<input type="text"	id="placeOfBirth" name="<%=PLACE_OF_BIRTH %>" tabindex="1" value="<%=birthPlace %>"	
		validate="Place of Birth,alphaspace,no" MAXLENGTH="50"	/> 
<label>DOB</label> 
<input type="text" id="srdobId" name="<%=SR_DOB %>"	tabindex="1" value="<%=dob %>" MAXLENGTH="30" 
   validate="Date of Birth,date,no" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	
	onblur="calculateAVAgeInAjax();" />
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',document.getElementById('srdobId'),event);" />
<div class="clear"></div>
<label>Age <span>*</span></label> 
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes" tabindex="1" class="smaller">
<option value="">Select</option>
<% 
String ageYears="";
String age="";
if(aviCa34.getAge()!=null){
	ageYears=aviCa34.getAge();
	age = ageYears.substring(0,2);
}
	for(int age1 = 16;age1<=100;age1++){ %>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<script>
document.getElementById('srAgeId').value='<%=age%>';
</script>
<label class="unit">Years</label>
<input type="hidden" id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value=""/>
<input class="transparent" size="4">
<label>Gender</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,metachar,yes" tabindex="1">
<option value="0">Select</option>
<%if(sexList!=null && sexList.size() >0){
	 for(MasAdministrativeSex masGender : sexList){
		
	%>
	 <option value="<%=masGender.getId()%>"><%=masGender.getAdministrativeSexName()%></option>
	<%}}%> </select>
	
<script>
<%
if(aviCa34.getSex() !=null){
%>
document.getElementById('srSexId').value = '<%=aviCa34.getSex().getId()%>';
<%}%>
</script>

<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,string,no" tabindex="1">
	<option value="0">Select</option>
	<%if(occupationList!=null && occupationList.size() >0){
	 for(MasOccupation masOccupation : occupationList){
	 if(aviCa34.getOccupation() !=null){
	if((aviCa34.getOccupation().getId()).equals(masOccupation.getId())){
	%>
	<option value="<%=masOccupation.getId()%>" selected="selected"><%=masOccupation.getOccupationName()%></option>
	<%}else{ %>
	<option value="<%=masOccupation.getId()%>" ><%=masOccupation.getOccupationName()%></option>
	<%}}else{ %>
	<option value="<%=masOccupation.getId()%>" ><%=masOccupation.getOccupationName()%></option>
	<%}
	} 
	} %>
</select>

<div class="clear"></div>
<label>Local Address</label> 
<textarea name="<%=ADDRESS %>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Local Address,string,no" maxlength="100" 
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	
	onKeyDown="return checkMaxLength(this)" onkeyup="chkLength(this,100);" ><%=localAddress %></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>" validate="City,metachar,no" id="srcityId" tabindex="1" onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
			if(aviCa34.getLocalDistrict() !=null){
			if(aviCa34.getLocalDistrict().getId().equals(masDistrict.getId())){	
	%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName() %></option>
	<%}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%} }else{ %>
		<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%} } %>
	</select> 

<label>State</label> 
<select id="srstateId" name="<%=STATE%>" validate="State,metachar,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','srcityId')">
	<option value="0">Select</option>
	<%
		for(MasState masState : stateList){
			if(aviCa34.getLocalState() !=null){
				if(aviCa34.getLocalState().getId().equals(masState.getId())){	
	%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
	<%}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%}}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%		}
		}%>
</select>
<div class="clear"></div>


<label>Telephone No.</label>

<input id="<%=TELEPHONE_NO %>" name="<%=TELEPHONE_NO %>" value="<%=telphoneNo %>" type="text" tabindex="1" maxlength="11" validate="Telephone,phone,no"/> 

<label>Mobile No.</label> 
<input id="<%=MOBILE_NO %>" name="<%=MOBILE_NO %>" value="<%=mobileNo %>" type="text" tabindex="1"	maxlength="11" validate="Mobile No.,phone,no"/>

<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Permanent Address,string,no" maxlength="100" 
onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	
	onKeyDown="return checkMaxLength(this)" onkeyup="chkLength(this,100);" ><%=permanentAdd %></textarea>
	
<label>City</label> 
<select name="<%=PERMANENT_CITY_ID %>" validate="City,metachar,no" id="perCityId" tabindex="1" onblur="populateStateCity(this.value,'permStateId');">
	<option value="0">Select</option>
	<%	for(MasDistrict pmasDistrict : districtList){
		if(aviCa34.getPermanentDistrict() !=null){
		if(aviCa34.getPermanentDistrict().getId().equals(pmasDistrict.getId())){	
	%>
	<option value="<%=pmasDistrict.getId()%>" selected="selected"><%=pmasDistrict.getDistrictName() %></option>
	<%}else{ %>
	<option value="<%=pmasDistrict.getId()%>"><%=pmasDistrict.getDistrictName() %></option>
	<%}}else{ %>
	<option value="<%=pmasDistrict.getId()%>"><%=pmasDistrict.getDistrictName() %></option>
	<%		}
		}%>
</select> 

<label>State</label> 
<select id="permStateId" name="<%=PERMANENT_STATE_ID %>" 	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','perCityId')">
	<option value="0">Select</option>
	<%	for(MasState pmasState : stateList){
		if(aviCa34.getPermanentState() !=null){
			if(aviCa34.getPermanentState().getId().equals(pmasState.getId())){
	%>
	<option value="<%=pmasState.getId() %>" selected="selected"><%=pmasState.getStateName() %></option>
	<%}else{ %>
	<option value="<%=pmasState.getId() %>"><%=pmasState.getStateName() %></option>
	<%}}else{ %>
	<option value="<%=pmasState.getId() %>"><%=pmasState.getStateName() %></option>
	<%	}
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
} %>
</script>
<div class="clear"></div>
<label>  Type of Licence applied</label> 
<select	name="<%=TYPE_OF_LICENCE %>" validate="Type of Licence applied,metachar,no"	id="<%=TYPE_OF_LICENCE %>" >
	<option value="0">Select</option>
	<%
		for(MasCaLicence masCaLicence : caLicenceList){
			if(aviCa34.getTypeOfLicenceApplied() !=null){
				if(aviCa34.getTypeOfLicenceApplied().getId().equals(masCaLicence.getId())){
	%>
	<option value="<%=masCaLicence.getId()%>" selected="selected"><%=masCaLicence.getCaLicenceName() %></option>
	<%}else{ %>
	<option value="<%=masCaLicence.getId()%>"><%=masCaLicence.getCaLicenceName() %></option>
	<%}}else{ %>
	<option value="<%=masCaLicence.getId()%>"><%=masCaLicence.getCaLicenceName() %></option>
	<%	}	
		}%>
</select> 
<label>  Licence Held</label> 
<select	name="<%=LICENCE_HELD %>" validate="Licence Held,metachar,no"		id="<%=LICENCE_HELD %>">
	
	<option value="0">Select</option>
	<%
		for(MasCaLicence licenceHeld : caLicenceList){
			if(aviCa34.getLicenceHeld() !=null){
				if(aviCa34.getLicenceHeld().getId().equals(licenceHeld.getId())){
	%>
	<option value="<%=licenceHeld.getId()%>"selected="selected"><%=licenceHeld.getCaLicenceName() %></option>
	<%}else{ %>
	<option value="<%=licenceHeld.getId()%>"><%=licenceHeld.getCaLicenceName() %></option>
	<%}}else{ %>
	<option value="<%=licenceHeld.getId()%>"><%=licenceHeld.getCaLicenceName() %></option>
	<%		}
		}%>
</select> 
</div>

<script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}

</script>