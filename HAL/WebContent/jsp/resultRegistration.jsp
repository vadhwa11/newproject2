<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * resultRegistration.jsp  
 * Purpose of the JSP -  This is for Result Registration.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 19th Dec,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.11
--%>


<%@ page import="java.util.*"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasCaste"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	List<MasCaste> casteList = new ArrayList<MasCaste>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<MasReference> referenceList = new ArrayList<MasReference>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
	
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String, Object>)map.get("patientMap");
	}
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String, Object>)map.get("detailsMap");
	}
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
	}
	if(detailsMap.get("casteList") != null){
		casteList = (List<MasCaste>)detailsMap.get("casteList");
	}
	if(detailsMap.get("religionList") != null){
		religionList = (List<MasReligion>)detailsMap.get("religionList");
	}
	if(detailsMap.get("occupationList") != null){
		occupationList = (List<MasOccupation>)detailsMap.get("occupationList");
	}
	if(detailsMap.get("referenceList") != null){
		referenceList = (List<MasReference>)detailsMap.get("referenceList");
	}
	if(detailsMap.get("countryList") != null){
		countryList = (List<MasCountry>)detailsMap.get("countryList");
	}
	if(detailsMap.get("stateList") != null){
		stateList = (List<MasState>)detailsMap.get("stateList");
	}
	if(detailsMap.get("districtList") != null){
		districtList = (List<MasDistrict>)detailsMap.get("districtList");
	}
	if(detailsMap.get("blockList") != null){
		blockList = (List<MasBlock>)detailsMap.get("blockList");
	}
	if(detailsMap.get("postCodeList") != null){
		postCodeList = (List<MasPostCode>)detailsMap.get("postCodeList");
	}
	if(patientList != null && patientList.size() > 0){

	    for(Patient patient : patientList){ 
	    	String dob = HMSUtil.convertDateToStringWithoutTime(patient.getDateOfBirth());
%>

<script type="text/javascript">

	<%
			int counter1 = 0;
			for (MasState masState : stateList) 
			{
				for (MasDistrict masDistrict : districtList) 
				{
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
		%>
			<%
			int count = 0;
			for (MasDistrict masDistrict : districtList) 
			{
				for (MasBlock masBlock  : blockList) 
				{
					if(masDistrict.getId().equals(masBlock.getDistrict().getId())){
								%>
									blockArray[<%=count%>] = new Array();
									blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
									blockArray[<%=count%>][1] = <%=masBlock.getId()%>;									
									blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

								<%
								count++;
						}
					}
				}
		%>
		<%
			int count1 = 0;
			
			for (MasBlock masBlock : blockList) 
			{
				for (MasPostCode masPostCode : postCodeList) 
				{
					if(masBlock.getId().equals(masPostCode.getBlock().getId())){
				%>
									pincodeArray[<%=count1%>] = new Array();
									pincodeArray[<%=count1%>][0] = <%=masBlock.getId()%>;
									pincodeArray[<%=count1%>][1] = <%=masPostCode.getId()%>;									
									pincodeArray[<%=count1%>][2] = "<%=masPostCode.getPostCodeName()%>";

								<%
								count1++;
						}
					}
				}
			%>
			
		</script>

<form name="resultRegistration" method="post" action=""><label><font
	id="error">*</font> First Name:</label> <input type="text"
	name="<%=FIRST_NAME %>" value="<%= patient.getFirstName()%>"
	class="textbox_size20" validate="First Name,name,yes" MAXLENGTH="20" />

<label>Middle Name:</label> <input type="text" name="<%=MIDDLE_NAME%>"
	value="<%= patient.getMiddleName() %>" class="textbox_size20"
	validate="Middle Name,name,no" MAXLENGTH="30" /> <label><font
	id="error">*</font> Last Name:</label> <input type="text"
	name="<%=LAST_NAME %>" value="<%=patient.getLastName()  %>"
	class="textbox_size20" validate="Last Name,name,yes" MAXLENGTH="30" />
<br />

<div id="dateOfBirth"><label> <font id="error">*</font>Date
of Birth:</label> <input type="text" id="dobId" name="<%=DATE_OF_BIRTH %>"
	value="<%=dob %>" class="textbox_date" readonly="readonly"
	validate="DOB,date,yes" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.resultRegistration.<%=DATE_OF_BIRTH%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label
	class="bodytextB_blue"><font id="error">*</font> Gender:</label> <select
	name="<%=GENDER %>" validate="Gender,string,no" onchange="disableDOB()"
	style="width: 75px;">
	<%if(patient.getSex()=="Male"){ %>
	<option selected value="Male" selected="selected">Male</option>
	<option value="Female">Female</option>
	<%} else {%>
	<option selected value="Male">Male</option>
	<option value="Female" selected="selected">Female</option>
	<%} %>
</select> <br />
<label> Religion:</label> <select name="<%=RELIGION %>"
	validate="Religion,string,no">
	<%
			 for(MasReligion masReligion : religionList){
				if(patient.getReligion() != null){
					if(patient.getReligion().getId() == masReligion.getId()){
			%>
	<option value="<%=masReligion.getId()%>" selected="selected"><%=masReligion.getReligionName()%></option>
	<%		} else{%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%		}
				}else{%>
	<option value="0">Select</option>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%		}
				}%>
</select> <label> Caste:</label> <select name="<%=CASTE %>"
	validate="Caste,string,no">

	<%
				for(MasCaste masCaste : casteList){
					if(patient.getCaste() != null){
						if(patient.getCaste().getId() == masCaste.getId()){
			%>
	<option value="<%=masCaste.getId()%>" selected="selected"><%=masCaste.getCasteName()%></option>
	<%		} else{%>
	<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
	<%		}
					}else{%>
	<option value="0">Select</option>
	<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
	<%		}
				}%>
</select> <label> Occupation:</label> <select name="<%=OCCUPATION %>"
	validate="Occupation,string,no">

	<%
			 for(MasOccupation masOccupation : occupationList){
				 if(patient.getOccupation() != null){
				 	if(patient.getOccupation().getId() == masOccupation.getId()){
			 %>
	<option value="<%=masOccupation.getId()%>" selected="selected"><%=masOccupation.getOccupationName()%></option>
	<%		}else{ %>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%		}
				 }else{%>
	<option value="0">Select</option>
	<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
	<%		}
				}%>
</select> <br />

<label><font id="error">*</font>Address:</label> <textarea
	name="<%=ADDRESS%>" cols="50" rows="3" validate="Address,string,yes"
	MAXLENGTH="30"><%=patient.getAddress() %></textarea> <br />
<label><font id="error">*</font> Country:</label> <select
	name="<%= NATIONALITY %>" validate="Nationality,string,yes"
	onchange="populateState(this.value,'resultRegistration')">
	<%
			 	for(MasCountry cntMaster : countryList)
			 	{
				 	if(patient.getCountry() != null){
				 		if(patient.getCountry().getId() == cntMaster.getId()){
			 %>
	<option value="<%=cntMaster.getId()%>" selected="selected"><%=cntMaster.getCountryName()%></option>
	<%			}else{ %>
	<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
	<%			}
				 	}else{%>
	<option value="0">Select</option>
	<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
	<%		}
				}%>
</select> <label><font id="error">*</font> State:</label> <select
	name="<%=STATE%>" validate="State,string,yes"
	onchange="populateDistrict(this.value,'resultRegistration')">
	<option value="0">Select</option>

</select> <script type="text/javascript">
			
			<%
			int counter=0;
			for (MasCountry masCountry : countryList) 
			{
				for (MasState masState : stateList) 
				{
					if(masCountry.getId().equals(masState.getCountry().getId())){
								%>
									stateArr[<%=counter%>] = new Array();
									stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
									stateArr[<%=counter%>][1] = <%=masState.getId()%>;									
									stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
									
	
								<%
								counter++;
						}
					
					}
				}
			
		%>
		countryVal = document.resultRegistration.nationality.value;
		stateVal = '<%=patient.getState().getStateName()%>';
		stateObj = document.resultRegistration.state;
		stateObj.length = 1;
		for(i=0;i<stateArr.length;i++){
			if(stateArr[i][0]==countryVal){
				stateObj.length++;
				if(stateVal == stateArr[i][2]){
					stateObj.options[stateObj.length-1].value=stateArr[i][1];
					stateObj.options[stateObj.length-1].text=stateArr[i][2];	
					stateObj.options[stateObj.length-1].selected=true;
				}
				stateObj.options[stateObj.length-1].text=stateArr[i][2];			
				
			}
		}
			</script> <label> City:</label> <% if(patient.getCity() != null){ %> <input
	type="text" name="<%=CITY %>" value="<%=patient.getCity() %>"
	class="textbox_size20" validate="City,city,no" MAXLENGTH="30" /> <%}else{ %>
<input type="text" name="<%=CITY %>" value="" class="textbox_size20"
	validate="City,city,no" MAXLENGTH="30" /> <%} %> <br />

<label>District:</label> <select name="<%=DISTRICT%>"
	validate="District,string,no"
	onchange="populateBlock(this.value,'resultRegistration')">
	<option value="0">Select</option>
</select> <script type="text/javascript">
		<% 
			if(patient.getDistrict() != null)
			{ 
		%>
			stateVal1 = document.resultRegistration.state.value;
			districtVal = '<%=patient.getDistrict().getDistrictName()%>';
			districtObj = document.resultRegistration.district;
			districtObj.length = 1;
			for(i=0;i<districtArray.length;i++){
				if(districtArray[i][0]==stateVal1){
					districtObj.length++;
					if(districtVal == districtArray[i][2]){
						districtObj.options[districtObj.length-1].value=districtArray[i][1];
						districtObj.options[districtObj.length-1].text=districtArray[i][2];	
						districtObj.options[districtObj.length-1].selected=true;
					}
					districtObj.options[districtObj.length-1].text=districtArray[i][2];			
				}
			}
			<%}%>
			</script> <label>Block:</label> <select name="<%=BLOCK%>"
	validate="Block,string,no"
	onchange="populatePincode(this.value,'resultRegistration')" />
	<option value="0">Select</option>
</select> <script type="text/javascript">
		<% 
			if(patient.getBlock() != null)
			{
		%>
			districtVal1 = document.resultRegistration.district.value;
			blockVal = '<%=patient.getBlock().getBlockName()%>';
			blockObj = document.resultRegistration.block;
			blockObj.length = 1;
			for(i=0;i<blockArray.length;i++){
				if(blockArray[i][0] == districtVal1){
					blockObj.length++;
					if(blockVal == blockArray[i][2]){
						blockObj.options[blockObj.length-1].value=blockArray[i][1];
						blockObj.options[blockObj.length-1].text=blockArray[i][2];	
						blockObj.options[blockObj.length-1].selected=true;
					}
					blockObj.options[blockObj.length-1].text=blockArray[i][2];			
				}
			}
			
			<%}%>
			
			</script> <label>Pincode:</label> <select name="<%=PINCODE%>"
	validate="Pincode,string,no"">
	<option value="0">Select</option>
</select> <script type="text/javascript">
		<%
			if(patient.getPostCode() != null)
			{
		%>
			blockVal1 = document.resultRegistration.block.value;
			postCodeVal = '<%=patient.getPostCode().getPostCodeName()%>';
			pinCodeObj = document.resultRegistration.pincode;
			pinCodeObj.length = 1;
			for(i=0;i<pincodeArray.length;i++){
				if(pincodeArray[i][0] == blockVal1){
					pinCodeObj.length++;
					if(postCodeVal == pincodeArray[i][2]){
						pinCodeObj.options[pinCodeObj.length-1].value=pincodeArray[i][1];
						pinCodeObj.options[pinCodeObj.length-1].text=pincodeArray[i][2];	
						pinCodeObj.options[pinCodeObj.length-1].selected=true;
					}
					pinCodeObj.options[pinCodeObj.length-1].text=pincodeArray[i][2];			
				}
			}
		<%}%>
			</script> <br />

<label> Village:</label> <% if(patient.getVillage() != null){ %> <input
	type="text" name="<%=VILLAGE %>" value="<%=patient.getVillage() %>"
	class="textbox_size20" validate="Village,city,no" MAXLENGTH="30" /> <%  }else{ %>
<input type="text" name="<%=VILLAGE %>" value="" class="textbox_size20"
	validate="Village,city,no" MAXLENGTH="30" /> <%  } %> <label>
Post Office:</label> <% if(patient.getPostOffice() != null){ %> <input type="text"
	name="<%=POST_OFFICE %>" value="<%=patient.getPostOffice() %>"
	class="textbox_size20" validate="Post Office,string,no" MAXLENGTH="30" />
<%}else{ %> <input type="text" name="<%=POST_OFFICE %>" value=""
	class="textbox_size20" validate="Post Office,string,no" MAXLENGTH="30" />
<%} %> <label> Police Station:</label> <% if(patient.getPoliceStation() != null){ %>
<input type="text" name="<%=POLICE_STATION %>"
	value="<%=patient.getPoliceStation() %>" class="textbox_size20"
	validate="Police Station,string,no" MAXLENGTH="30" /> <%}else{ %> <input
	type="text" name="<%=POLICE_STATION %>" value="" class="textbox_size20"
	validate="Police Station,string,no" MAXLENGTH="30" /> <%} %> <br />
<label><font id="error">*</font> Phone:</label> <input type="text"
	name="<%=PHONE %>" value="<%=patient.getPhoneNumber() %>"
	class="textbox_size20" validate="Phone,int,yes" MAXLENGTH="30" /> <label>Mobile:</label>
<% if(patient.getMobileNumber() != null){ %> <input type="text"
	name="<%=MOBILE %>" value="<%=patient.getMobileNumber() %>"
	class="textbox_size20" validate="Mobile Number,int,no" MAXLENGTH="30" />
<%}else{ %> <input type="text" name="<%=MOBILE %>" value=""
	class="textbox_size20" validate="Mobile Number,int,no" MAXLENGTH="30" />
<%} %> <label>Email Id:</label> <% if(patient.getEmailId() != null){ %> <input
	type="text" name="<%=EMAIL_ID %>" value="<%=patient.getEmailId() %>"
	class="textbox_size20" validate="Email Id,email,no" MAXLENGTH="30" />
<%}else{ %> <input type="text" name="<%=EMAIL_ID %>" value=""
	class="textbox_size20" validate="Email Id,email,no" MAXLENGTH="30" />
<%} %> <br />

<label>Reference:</label> <select name="<%=REFERENCE%>"
	validate="Reference,string,no">
	<%
			 for(MasReference masReference : referenceList){
				 if(patient.getReference() != null){
					if(patient.getReference().getId() == masReference.getId()){
			%>
	<option value="<%=masReference.getId()%>" selected="selected"><%=masReference.getReferenceName()%></option>
	<%		} else{%>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
	<%		}
				 }else{%>
	<option value="0">Select</option>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
	<%		}
				}%>
</select> <input type="hidden" name=<%=HIN_ID%> value="<%=patient.getId() %>">
<div id="edited"></div>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<input type="button" name="Update" value="Update" class="button"
	onClick="submitForm('resultRegistration','/hms/hms/registration?method=updateRegistrationInformation');" />
<input type="button" name="Cancel" value="Cancel" class="button"
	onclick="javascript:history.back()" /> <br />
<%		} 
	    	}else{ 
	    	%> No Record Found! <%} %>

<div id="statusMessage" class="messagelabel"><br />
</div>
</form>
