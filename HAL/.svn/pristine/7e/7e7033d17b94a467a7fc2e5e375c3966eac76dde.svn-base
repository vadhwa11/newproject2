
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


<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
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
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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

       %>
<%	

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTime");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			
			List<MasCountry> countryList = null;
			List<MasState> stateList = null;
			List<MasDistrict> districtList = null;
			List<MasOccupation> occupationList = null;
			
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
			
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
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
<h2>CA form 34 A(Re-revised)</h2>
</div>


<div class="clear paddingTop15"></div>
<h4>PILOT DETAILS</h4>
<div class="Block">
<div class="clear"></div>

<div class="clear"></div>
<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,alphaspace,yes" MAXLENGTH="15" />

<label>Middle Name</label> 
<input type="text" id="pMiddleNameId"	name="<%=P_MIDDLE_NAME%>" value="" tabindex="1"	validate="Patient Middle Name,name,no" MAXLENGTH="15" /> 

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 


<div class="clear"></div>

<label> Nationality</label> 
<input type="text"	id="nationality" name="<%=NATIONALITY %>" tabindex="1" value=""	readonly="readonly" validate="Nationality,alphaspace,no" MAXLENGTH="30"	/> 

<label> Place of Birth</label> 
<input type="text"	id="placeOfBirth" name="<%=PLACE_OF_BIRTH %>" tabindex="1" value=""	readonly="readonly" validate="Place of Birth,alphaspace,no" MAXLENGTH="30"	/> 


<label>DOB</label> 
<input type="text" id="srdobId" name="<%=DOB %>"	tabindex="1" value="" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate"	onblur="calculateSRAgeInAjax();fillPatientName(this);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.caForm34A.<%=DOB%>,event)" />

<div class="clear"></div>

<label> Occupation</label> 
<select	id="occupation" name="<%=OCCUPATION_ID %>"	validate="Occupation,string,no" tabindex="1">
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
<textarea name="<%=ADDRESS %>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" onblur="fillPatientName(this)" ></textarea>
	
<label>City</label> 
<select name="<%=DISTRICT%>" validate="City,string,no" id="srcityId" tabindex="1" onblur="fillPatientName(this)">
	<option value="0">Select</option>
	<%
		for(MasDistrict masDistrict : districtList){
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%		
		}%>
</select> 

<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'caForm34A','srcityId')">
	<option value="0">Select</option>
	<%

		for(MasState masState : stateList){
	
	%>
	
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%		
		}%>
</select>
<div class="clear"></div>


<label>Telephone No</label>

<input id="phoneNo" name="<%=TELEPHONE_NO %>" type="text" tabindex="1" maxlength="11" /> 

<label>Mobile No.</label> 
<input id="mobileNo" name="<%=MOBILE_NO %>" type="text" tabindex="1"	maxlength="11" />

<div class="clear"></div>


<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS %>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
<label>City</label> 
<select name="<%=PERMANENT_CITY_ID %>" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value);">
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

<label>  Type of Licence applied</label> 
<select	name="<%=TYPE_OF_LICENCE %>" validate="Type of Licence applied,String,no"	id="relId">
	<option value="0">Select</option>

</select>

<label>  Licence Held</label> 
<select	name="<%=LICENCE_HELD %>" validate="Licence Held,String,no"	id="relId">
	<option value="0">Select</option>

</select>

<label>  Licence No</label> 
<input	type="text" name="<%=LICENCE_NO%>" value=""	validate="Licence No,string,no" maxlength="16" />

<div class="clear"></div>
<label> Aircraft Presently Flown</label> 
<input	type="text" name="<%=AIRCRAFT_PRESENT_FLOWN %>" value=""	validate="Aircraft Presently Flown,string,no" maxlength="16" />


<label> Flying Experience</label> 
<input	type="text" name="<%=FLYING_EXPERIENCE %>" value=""	validate="Flying Experience,string,no" maxlength="16" class="small"/>
<label class="unit">hrs.</label>

<label>Since Last examination </label> 
<input	type="text" name="<%=SINCE_LAST_EXAMINATION %>" value=""	validate="Since Last examination,string,no" maxlength="16" class="small"/>
<label class="unit">hrs.</label>

</div>


<div class="clear"></div>

<div class="clear paddingTop15"></div>


<h4>PREVIOUS EXAMINATION DETAILS</h4>
<div class="Block">	
<div class="clear"></div>
<label>  Place</label>
<input type="text" name="<%=PLACE %>" value=""	validate="Place,string,no" id="place" maxlength="30"/>
	

<label>Date</label> 
<input type="text" id="dateId"	name="<%=DATE %>" tabindex="1" value=""	readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.caForm34A.<%=DATE%>,event)" />

<div class="clear"></div>
<label>Final Obsezvation</label> 

<select id="finalObsezvation" name="<%=FINAL_OBSEZVATION %>" onchange="showFinalObsezvation();"	validate="finalObsezvationId,string,no" tabindex="1">
	<option value="">Select</option>
	<option value="f">FIT</option>
	<option value="u">UNFFT</option>
</select> 



<div id="finalObsezvationDiv" style="display: none" >
<label>Cause</label>
 <input type="text" name="cause" value=""	validate="cause,string,no" id="cause" maxlength="30"/>
	
</div>

<div class="clear"></div>
<label>Director General of Civil Aviation's Office Ref. No.</label>
 <input type="text" name="<%=GENERAL %>" value=""	validate="Director General of Civil Aviation's Office Ref. No.,string,no" id="cause" maxlength="30"/>


<label>Date</label> 
<input type="text" id="dateId"	name="<%=DATE_OTHER%>" tabindex="1" value=""	readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.caForm34A.<%=DATE_OTHER%>,event)" />


</div>
<div class="clear"></div>


<div class="clear paddingTop15"></div>
<div class="Block">	

<div class="clear"></div>
<label class="auto">Since your last medical examination have you lost any time from work, or have you consulted a doctor because of any illness or injury? </label> 

<select id="illness" name="<%=ILLNESS %>" onchange="showIllness();"	 tabindex="1" >
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 
<div class="clear"></div>
<div id="illnessDiv" style="display: none" >
<label>Details</label>
 <input type="text" name="details" value=""	validate="details,string,no" id="deatils" maxlength="30"/>
	
</div>

<div class="clear"></div>
<label class="auto">Are you in good physical and mental health as far as you know and believe?</label>
<input type="text" name="<%=PHYSICAL %>" value=""	validate="physical,string,no" id="physical" maxlength="30"/>
	

<div class="clear"></div>
<label class="auto">Do you at present take any drug or medicine (injections,tablets,capsules,mixtures,eye drops,etc.)?</label>
<select id="drug" name="<%=DRUG %>" onchange="showDrug();"	 tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 
<div class="clear"></div>
<div id="drugDiv" style="display: none" >
<label>Details</label>
 <input type="text" name="detail" value=""	validate="detail,string,no" id="deatil" maxlength="30"/>
	
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<div id="saveAdmission" style="display: none;">
<input	type="button" name="Submit" value="Save & Admission" tabindex="1"	class="buttonbig"  />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1"  accesskey="r" />
</div>

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
		document.getElementById('stateId').value = state;
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
</script>