
<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasCaLicence"%>

<%@page import="jkt.hms.masters.business.AviCa34"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
<!-- Script for tab content -->

/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
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
<form name="caForm34A" method="post" action="">
       <%
       Properties properties = new Properties();
       URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
       try {
       	properties.load(resourcePathHIC.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       String urlForImportFromHIC = properties.getProperty("urlForImportFromHIC");

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTimeWithoutSc");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
			List<MasAdministrativeSex> sexList = null;
			List<MasCountry> countryList = null;
			List<MasState> stateList = null;
			List<MasDistrict> districtList = null;
			List<MasOccupation> occupationList = null;
			List<MasBankMaster> bankList=null;
			List<MasTitle> titleList=null;
			List<MasCaLicence> caLicenceList=null;
			if(map.get("medExamWaitingList") != null){
				medExamWaitingList = (List<AviCa34>)map.get("medExamWaitingList");
			}
			if(map.get("countryList") != null){
				countryList =(List<MasCountry>)map.get("countryList");
			}
			if(map.get("stateList") != null)	{
				stateList = (List<MasState>)map.get("stateList");
			}
			if(map.get("districtList") != null){
				districtList =(List<MasDistrict>)map.get("districtList");
			}
			
			if(map.get("occupationList") != null){
				occupationList = (List<MasOccupation>)map.get("occupationList");
			}
			if(map.get("bankList") != null){
				bankList = (List<MasBankMaster>)map.get("bankList");
			}
			
			if(map.get("titleList") != null){
				titleList = (List<MasTitle>)map.get("titleList");
			}
			if(map.get("caLicenceList") != null){
				caLicenceList = (List<MasCaLicence>)map.get("caLicenceList");
			}
			String administrativeSexMaleCode = properties
 			.getProperty("administrativeSexMaleCode");

		 	if (map.get("sexList") != null) {
		 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
		 	}
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			AviCa34 aviCa34=new AviCa34();
			if(medExamWaitingList.size() > 0){
				aviCa34 = medExamWaitingList.get(0);
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
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }
%>
<div class="titleBg">
<h2>CA form 34 A(Re-revised)</h2>
</div>
<div class="clear paddingTop15"></div>
<h4>PILOT DETAILS</h4>
<div class="Block">
<div class="clear"></div>
<label> Licence No.<span>*</span></label> 
<%
if(aviCa34.getLicenceNo() !=null){ %>
<input	type="text" name="<%=LICENCE_NO%>" value="<%=aviCa34.getLicenceNo()%>"	validate="Licence No,metachar,yes" maxlength="16"readonly="readonly"/>
<%}else{ %>
<input	type="text" name="<%=LICENCE_NO%>" value=""	validate="Licence No,metachar,yes" maxlength="16" 
onblur="submitProtoAjaxWithDivName('caForm34A','/hms/hms/aviationMedicine?method=getDetailBasedLicenceNo','detailDiv');"/>
<%} %>
<div class="clear"></div>
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
	int occupationId=0;
	int titleId=0;
	String nationality="";
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
<input name="avCA34" value="<%=avCA34Id %>"type="hidden"/>
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
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=firstName %>" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,metachar,yes" MAXLENGTH="32" />

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>" value="<%=lastName%>" validate="Patient Last Name,name,no" MAXLENGTH="32"	tabindex="1" /> 

<div class="clear"></div>

<label> Nationality</label> 
<input type="text"	id="nationality" name="<%=NATIONALITY %>" tabindex="1" value="<%=nationality %>"	  MAXLENGTH="22"	/> 

<label> Place of Birth</label> 
<input type="text"	id="placeOfBirth" name="<%=PLACE_OF_BIRTH %>" tabindex="1" value="<%=birthPlace %>"	validate="Place of Birth,metachar,no" MAXLENGTH="49"	/> 

<label>DOB</label> 
<input type="text" id="srdobId" name="<%=SR_DOB %>"	tabindex="1" value="<%=dob %>" 
validate="Date of Birth,frdate,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srdobId');calculate34AgeInAjax();" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.caForm34A.<%=SR_DOB%>,event)" />

<label>Age <span>*</span></label> 
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes"	tabindex="1" class="small">
	<option value="">Select</option>
<% 
String ageYears="";
String age="";
if(aviCa34.getAge()!=null){
	ageYears=aviCa34.getAge();
	age = ageYears.substring(0,2);
}
	for(int age1 = 16;age1<=100;age1++){
%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<script>
document.getElementById('srAgeId').value='<%=age%>';
</script>
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value=""/>
 
<label>Gender</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,metachar,yes" tabindex="1"	onchange="fillPatientName(this);">
	<option value="0">Select</option>
	<%if(sexList!=null && sexList.size() >0){
		for(MasAdministrativeSex masAdministrativeSex : sexList){
	 if(aviCa34.getSex() !=null){
	if((aviCa34.getSex().getId()).equals(masAdministrativeSex.getId())){
	%>
	<option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%}}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%}
	} 
	} %>
</select> 
<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,metachar,no" tabindex="1">
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
<textarea name="<%=ADDRESS %>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Local Address,string,no" maxlength="100" onkeyup="return ismaxlength(this)" >
<%=localAddress %></textarea>
	
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

<input id="<%=TELEPHONE_NO %>" name="<%=TELEPHONE_NO %>" value="<%=telphoneNo %>" type="text" tabindex="1" maxlength="11" /> 

<label>Mobile No.</label> 
<input id="<%=MOBILE_NO %>" name="<%=MOBILE_NO %>" value="<%=mobileNo %>" type="text" tabindex="1"	maxlength="11" />

<div class="clear"></div>


<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Permanent Address,string,no" maxlength="100" onkeyup="return ismaxlength(this)" >
<%=permanentAdd %></textarea>
	
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
<select id="permStateId" name="<%=PERMANENT_STATE_ID %>" 	validate="State,metachar,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','perCityId')">
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
}

%>
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
<div class="clear"></div>
<label> Aircraft Presently Flown</label> 
<input	type="text" name="<%=AIRCRAFT_PRESENT_FLOWN %>" value=""	validate="Aircraft Presently Flown,metachar,no" maxlength="49" />


<label> Flying Experience</label> 
<input	type="text" name="<%=FLYING_EXPERIENCE %>" value="0"	validate="Flying Experience,int,no" maxlength="8" class="small"/>
<label class="unit">hrs.</label>
<input class="transparent" size="7">
<label>Since Last examination </label> 
<input	type="text" name="<%=SINCE_LAST_EXAMINATION %>" value="0"	validate="Since Last examination,int,no" maxlength="8" class="small"/>
<label class="unit">hrs.</label>

</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>PREVIOUS EXAMINATION DETAILS</h4>
<div class="Block">	
<div class="clear"></div>
<label>  Place</label>
<input type="text" name="<%=PLACE %>" value=""	validate="Place,metachar,no" id="place" maxlength="50" tabindex="1"/>
	

<label>Date</label> 
<input type="text" id="dateId"	name="<%=DATE %>" tabindex="1" value=""	validate="Date,frdate,no" MAXLENGTH="12" class="calDate" onkeyup="mask(this.value,this,'2,5','/');" tabindex="1"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.caForm34A.<%=DATE%>,event)" />

<div class="clear"></div>
<label>Final Observation</label> 
<select id="finalObsezvation" name="<%=FINAL_OBSEZVATION %>" onchange="showFinalObsezvation();"	validate="final Obsezvation,metachar,no" tabindex="1">
	<option value="">Select</option>
	<option value="f">FIT</option>
	<option value="u">UNFIT</option>
</select> 

<div id="finalObsezvationDiv" style="display: none" >
<label>Cause</label>

<input type="text" name="cause" value="" class="large"	validate="cause,metachar,no" id="cause" maxlength="100" tabindex="1"/>
	
</div>

<div class="clear"></div>
<label>DGCA's Office Ref. No.</label>
 <input type="text" name="<%=GENERAL %>" value=""	validate="Director General of Civil Aviation's Office Ref. No.,metachar,no" id="cause" maxlength="29" tabindex="1"/>

<label>Date</label> 
<input type="text" id="dateId"	name="<%=DATE_ONE%>" tabindex="1" value=""validate="Date,frdate,no" MAXLENGTH="12" class="calDate" onkeyup="mask(this.value,this,'2,5','/');" tabindex="1"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.caForm34A.<%=DATE_ONE%>,event)" />

</div>
<div class="clear"></div>


<div class="clear paddingTop15"></div>
<div class="Block">	

<div class="clear"></div>
<label class="large2">Since your last medical examination have you lost any time from work, or have you consulted a doctor because of any illness or injury? </label> 

<select id="illness" name="<%=ILLNESS %>" onchange="showIllness();"	 tabindex="1" tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 
<div class="clear"></div>
<div id="illnessDiv" style="display: none" >
<label>Details</label>

<textarea name="detailsIllness" id="detailsIllness"	cols="20" rows="2" tabindex="1" validate="Deatil,metachar,no" maxlength="100" onkeyup="return ismaxlength(this)" tabindex="1"></textarea>
</div>

<div class="clear"></div>
<label class="large2">Are you in good physical and mental health as far as you know and believe?</label>
<select id="<%=PHYSICAL %>" name="<%=PHYSICAL %>"	 tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 

<div class="clear"></div>
<label class="large2">Do you at present take any drug or medicine (injections,tablets,capsules,mixtures,eye drops,etc.)?</label>
<select id="drug" name="<%=DRUG %>" onchange="showDrug();"	 tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 
<div class="clear"></div>
<div id="drugDiv" style="display: none" >
<label>Details</label>
<textarea name="detailDrug" id="detailDrug"	cols="20" rows="2" tabindex="1" validate="Deatil,metachar,no" maxlength="100" onkeyup="return ismaxlength(this)" ></textarea>
	
</div>
</div>

<div class="clear"></div>

<div class="clear paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr>
		<th scope="col">Payment Mode</th>
		<th scope="col">Amount</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>
	</tr>
	<%
		int ii = 1;
	%>
	<tr>
		
		<td><select name="<%=PAYMENT_MODE %>"
			id="paymentModeId"
			onchange="checkPaymentMode(this.value);" tabindex="1">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %>"
			id="amt" value="" validate="Amount,float,no"
			maxlength="9" tabindex="1" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%>"
			id="cqeId" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value );" tabindex="1"  validate="Cheque/Credit Card No,metachar,no"/></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %>" id="chqDate" readonly="readonly"
			onblur="validateChequeAndCreditCardDate();" tabindex="1"/> 
			<img id="calId" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" style="display: none;" class="calender"
			onclick="setdate('<%=date %>',document.getElementById('chqDate'),event);" tabindex="1"/>
		</td>
		<td><select name="<%=BANK_NAME %>" id="bankId"
			disabled="disabled" tabindex="1">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (MasBankMaster bankMaster : bankList) {
			%>
			<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
			bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>

	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment" id="hiddenValuePayment" />
<%---
<h4>PAYMENT DETAILS</h4>
<div class="Block">	
<label>DD No.</label>
<input type="text" name="<%=DD_NO %>" value=""  validate="detail,string,no" id="ddNo" maxlength="32"/>

<label>Date</label> 
<input type="text" id="dateId"	name="<%=DATE_TWO%>" tabindex="1" value=""	validate="Date,date,no" MAXLENGTH="12" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.caForm34A.<%=DATE_TWO%>,event)" />

<label>Amount </label> 
<input	type="text" name="<%=AMOUNT %>" value="0"	validate="Amount,int,no" maxlength="8" class="small"/>
<label class="unit">Rs.</label>

<div class="clear"></div>
<label>Bank </label>
<select  name="<%=BANK_ID %>" id="bankId">
<option value="0">Select</option>
	<%
		for(MasBankMaster masBankMaster : bankList){
	%>
	<option value="<%=masBankMaster.getId()%>"><%=masBankMaster.getBankName() %></option>
	<%	}%>
</select> 

<label>Remarks</label>
<textarea name="<%=REMARKS %>" id="<%=REMARKS %>"	cols="20" rows="2" tabindex="1" validate="Remarks,string,no" maxlength="100" onkeyup="return ismaxlength(this)" ></textarea>
</div>
 --%>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

<input	type="button" name="Submit" value="Submit" onClick="submitForm('caForm34A','aviationMedicine?method=submitCAForm34A');" tabindex="1"	class="buttonbig"  />
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

function showFinalObsezvation(){
	if(document.getElementById('finalObsezvation').value == 'u'){
	  	document.getElementById("finalObsezvationDiv").style.display='inline';
	}else{
		document.getElementById("finalObsezvationDiv").style.display='none';
	}
}
function showIllness(){
	if(document.getElementById('illness').value == 'y'){
	  	document.getElementById("illnessDiv").style.display='inline';
	}else{
		document.getElementById("illnessDiv").style.display='none';
	}
}
function showDrug(){
	if(document.getElementById('drug').value == 'y'){
	  	document.getElementById("drugDiv").style.display='inline';
	}else{
		document.getElementById("drugDiv").style.display='none';
	}
}
function checkPaymentMode(val){
	if(val == "C"){
		document.getElementById("cqeId").value = "";
		document.getElementById("chqDate").value = "";
		document.getElementById("bankId").value = "0";
		document.getElementById("amt").readOnly = false;
		document.getElementById("cqeId").readOnly = true;
		
		document.getElementById("bankId").disabled = true;
		document.getElementById("calId").style.display = 'none';
	}

	else if(val == "Q" || val == "R"){
		document.getElementById("amt").readOnly = false;
		document.getElementById("cqeId").readOnly = false;

		document.getElementById("bankId").disabled = false;
		document.getElementById("calId").style.display = 'inline';
	}else{
		document.getElementById("amt").value = "";
		document.getElementById("cqeId").value = "";
		document.getElementById("chqDate").value = "";
		document.getElementById("bankId").value = "0";
		
		document.getElementById("amt").readOnly = true;
		document.getElementById("cqeId").readOnly = true;
		document.getElementById("chqDate").readOnly = true;
		document.getElementById("bankId").disabled = true;
		document.getElementById("calId").style.display = 'none';
	}
	}

function validateCheque(val){
	if(val != ""){
		if(!validateInteger(val)){
			alert("Please enter valid Cheque/Credit Card No.");
			document.getElementById('cqeId').value="";
			return false;
		}
	}

	return true;
}
function validateChequeAndCreditCardDate(){

	var currentDate = new Date();

	var year = 0;
	var month = 0;
	var day = 0;

	year = currentDate.getFullYear();

	month=(currentDate.getMonth()+1)-6;
	if(month<=0){
		month = month+12
		year--;
	}
	month = (month<10)? "0"+month : month

	day = (currentDate.getDate())
	if(day<0){
		day = day+30
		month--;
	}
	day = (day<10)? "0"+day : day

	if(year <= 0)
		year = currentDate.getFullYear()+year;
	if(month <= 0)
		month = (((currentDate.getMonth()+1)+month)<10)? "0"+((currentDate.getMonth()+1)+month) : ((currentDate.getMonth()+1)+month);
	if(day == 0)
		day = (currentDate.getDate()<10)? "0"+currentDate.getDate() : currentDate.getDate();

	prevDate = new Date(month + "/" + day + "/" + year);

var msg  = "";

	var cnt = document.getElementById('hiddenValuePayment').value;
	//for(var i=1;i<=cnt;i++){
		if(document.getElementById('paymentModeId')){
			if(document.getElementById('paymentModeId').value == "Q"){
				var dateStr = document.getElementById('chqDate').value;
				if(dateStr != ""){
					chqDate = new Date(dateStr.substring(6),(dateStr.substring(3,5) - 1) ,dateStr.substring(0,2));
					if(chqDate < prevDate){
						msg += "Cheque Date is not valid.\n";
						document.getElementById('chqDate').value = "";
					}
				}
			}else if(document.getElementById('paymentModeId').value == "R"){
				var dateStr = document.getElementById('chqDate').value;
				if(dateStr != ""){
					var curmonth = currentDate.getMonth() + 1;
					var curday = currentDate.getDate();
					var curyear = currentDate.getFullYear();
					var seperator = "/";
					currentDate = new Date(curmonth + seperator + curday + seperator + curyear);
					crDate = new Date(dateStr.substring(6),(dateStr.substring(3,5) - 1) ,dateStr.substring(0,2));
					if(currentDate > crDate){
						msg += "Credit card Date is not valid.\n";
						document.getElementById('chqDate').value = "";
					}
				//}
			}
		}
	}

		if(msg != ""){
			alert(msg);
			return false;
		}

	return true;




}
</script>