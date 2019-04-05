<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is ajax response jsp for Service person name.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RANK_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TRADE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SECTION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEX_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.S_LAST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PREFIX"%>
<%@ page import="static jkt.hms.util.RequestConstants.SUFFIX"%>
<%@ page import="static jkt.hms.util.RequestConstants.TRADE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_YEARS"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOTAL_SERVICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOTAL_SERVICE_PERIOD"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.UNIT_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATION"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMMAND"%>
<%@ page import="static jkt.hms.util.RequestConstants.RECORD_OFFICE_ADDRESS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_SEX"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_DOB"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELIGION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TELEPHONE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.PERMANENT_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.NEXT_OF_KIN_PHONE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_BLOOD_GROUP_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_PHONE_NO"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> list = new ArrayList<Patient>();
	List<Object[]> tradeList = new ArrayList<Object[]>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<Object[]> rankList = new ArrayList<Object[]>();
	List<Object[]> unitList = new ArrayList<Object[]>();
	List<Object[]> sectionList = new ArrayList<Object[]>();
	List<Object[]> bloodGroupList = new ArrayList<Object[]>();
	List<Object[]> sexList = new ArrayList<Object[]>();
	List<Object[]> stationList = new ArrayList<Object[]>();
	List<Object[]> doctorList = new ArrayList<Object[]>();
	List<Object[]> commandList = new ArrayList<Object[]>();
	List<Object[]> maritalStatusList = new ArrayList<Object[]>();
	List<Object[]> religionList = new ArrayList<Object[]>();
	List<Object[]> serviceTypeList = null;
	List<Object[]> relationList = null;
	List<Object[]> districtList = null;
	List<Object[]> serviceStatusList = null;
	List<Object[]> stateList = null;
	List<Object[]> othersCategoryList = null;
	List<Object[]> familyHistoryList = null;
	List<Object[]> categoryList = new ArrayList<Object[]>();
	List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
	List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
	int serviceTypeId = 0;
	String patientTypeNameForOther="";
	Properties propadt = new Properties();
	URL resourcePathadt = Thread.currentThread().getContextClassLoader()
	.getResource("adt.properties");

	try {
		propadt.load(resourcePathadt.openStream());			 
		patientTypeNameForOther=propadt.getProperty("patientTypeNameForOther");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("listLDAPDataTemp") != null) {
		listLDAPDataTemp = (List<Map<String, Object>>) map.get("listLDAPDataTemp");
	}
	if (map.get("list") != null) {
		list = (List<Patient>) map.get("list");
	}
	if (map.get("srEmployeeList") != null) {
		srEmployeeList = (List<MasEmployee>) map.get("srEmployeeList");
	}
	
	if (map.get("rankList") != null) {
		rankList = (List<Object[]>) map.get("rankList");
	}
	if (map.get("unitList") != null) {
		unitList = (List<Object[]>) map.get("unitList");
	}
	if (map.get("tradeList") != null) {
		tradeList = (List<Object[]>) map.get("tradeList");
	}
	if (map.get("recordOfficeAddressList") != null) {
		recordOfficeAddressList = (List<MasRecordOfficeAddress>) map
				.get("recordOfficeAddressList");
	}
	if (map.get("sectionList") != null) {
		sectionList = (List<Object[]>) map.get("sectionList");
	}
	if (map.get("bloodGroupList") != null) {
		bloodGroupList = (List<Object[]>) map.get("bloodGroupList");
	}

	if (map.get("sexList") != null) {
		sexList = (List<Object[]>) map.get("sexList");
	}
	if (map.get("serviceTypeId") != null) {
		serviceTypeId = (Integer) map.get("serviceTypeId");
	}
	if (map.get("stationList") != null) {
		stationList = (List<Object[]>) map.get("stationList");
	}
	if (map.get("employeeList") != null) {
		doctorList = (List<Object[]>) map.get("employeeList");
	}
	if (map.get("commandList") != null) {
		commandList = (List<Object[]>) map.get("commandList");
	}
	if(map.get("othersCategoryList") != null){
		othersCategoryList = (List<Object[]>)map.get("othersCategoryList");
	}
	if (map.get("maritalStatusList") != null) {
		maritalStatusList = (List<Object[]>) map
				.get("maritalStatusList");
	}
	if (map.get("religionList") != null) {
		religionList = (List<Object[]>) map.get("religionList");
	}
	if (map.get("serviceTypeList") != null) {
		serviceTypeList = (List<Object[]>) map.get("serviceTypeList");
	}
	if (map.get("relationList") != null) {
		relationList = (List<Object[]>) map.get("relationList");
	}
	if (map.get("districtList") != null) {
		districtList = (List<Object[]>) map.get("districtList");
	}
	if (map.get("serviceStatusList") != null) {
		serviceStatusList = (List<Object[]>) map
				.get("serviceStatusList");
	}
	if (map.get("stateList") != null) {
		stateList = (List<Object[]>) map.get("stateList");
	}
	if (map.get("familyHistoryList") != null) {
		familyHistoryList = (List<Object[]>) map
				.get("familyHistoryList");
	}

	if (map.get("categoryList") != null) {
		categoryList = (List<Object[]>) map.get("categoryList");
	}

	String serviceNo = "";
	if (map.get("serviceNo") != null) {
		serviceNo = (String) map.get("serviceNo");
	}
	int serviceStatusId = 0;
	if (map.get("serviceStatusId") != null) {
		serviceStatusId = (Integer) map.get("serviceStatusId");
	}
	
	String echs = "";
	if (map.get("echs") != null) {
		echs = (String) map.get("echs");
	}
	String prefix = "";
	if (map.get("prefix") != null) {
		prefix = (String) map.get("prefix");
	}
	String suffix = "";
	if (map.get("suffix") != null) {
		suffix = (String) map.get("suffix");
	}
	String servPersonFName = "";
	String servPersonMName = "";
	String servPersonLName = "";

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String administrativeSexMaleCode = properties
			.getProperty("administrativeSexMaleCode");
	String empCategoryCodeForDoctor = properties
			.getProperty("empCategoryCodeForDoctor");
	int regHinId = 0;
	String selfHinNo = "";
	int lastVisitNo = 0;
	String patientStatus = "";
	List<Patient> servPersList = new ArrayList<Patient>();
	if (map.get("servPersList") != null) {
		servPersList = (List<Patient>) map.get("servPersList");
	}
	String srNoLdap = "";
	String rankLdap = "";
	String fNameLdap = "";
	String lNameLdap = "";
	String tradeLdap = "";
	String dobLdap = "";
	/**
	 * Getting details from LDAP
	 */
	String ldapData = "";
	if (listLDAPDataTemp.size() > 0) {
		for (int i = 0; i < listLDAPDataTemp.size(); i++) {
			Map<String, Object> mapLDAPDataTemp = new HashMap<String, Object>();

			mapLDAPDataTemp = (HashMap<String, Object>) listLDAPDataTemp
					.get(i);
			/*
			 * Key Nme for respective value
			 * Service No   =cn,sAMAccountName,name
			 * Rank         =rank
			 * F Name       =givenName
			 * L Name       =sn
			 * Trade/Branch =branch
			 * DOB			=dob
			 * E-mail       =mail
			 * 
			 */
			String ldapSrNo = "";
			for (Map.Entry<String, Object> entry : mapLDAPDataTemp
					.entrySet()) {
				if (entry.getKey().equalsIgnoreCase("cn")) {
					ldapSrNo = entry.getValue().toString();
					break;
				}
			}
			if (serviceNo.equals(ldapSrNo)) {
				for (Map.Entry<String, Object> entry : mapLDAPDataTemp.entrySet()) {
					ldapData = "yes";
					if (entry.getKey().equalsIgnoreCase("cn")) {
						serviceNo = entry.getValue().toString();
					} else if (entry.getKey().equalsIgnoreCase("rank")) {
						System.out.println("Key = " + entry.getKey()+ ", Value = " + entry.getValue());
						rankLdap = entry.getValue().toString();
					} else if (entry.getKey().equalsIgnoreCase("givenName")) {
						System.out.println("Key = " + entry.getKey()+ ", Value = " + entry.getValue());
						fNameLdap = entry.getValue().toString();
					} else if (entry.getKey().equalsIgnoreCase("sn")) {
						System.out.println("Key = " + entry.getKey()+ ", Value = " + entry.getValue());
						lNameLdap = entry.getValue().toString();
					} else if (entry.getKey().equalsIgnoreCase("branch")) {
						System.out.println("Key = " + entry.getKey()+", Value = " + entry.getValue());
						tradeLdap = entry.getValue().toString();
					}
					/*else if (entry.getKey().equalsIgnoreCase("dob")) {
						//System.out.println("Key = " + entry.getKey()+ ", Value = " + entry.getValue());
						dobLdap = entry.getValue().toString();
					}*/

				}
			}
		}
	}
	/**
	 * End of LDAP
	 */

	if (list.size() > 0 || servPersList.size() > 0) {
		Patient patient = new Patient();

		Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
		if (servPersList.size() > 0) {
			patient = servPersList.get(0);
			regHinId = patient.getId();
			selfHinNo = patient.getHinNo();
			patientStatus = patient.getPatientStatus();
			if (patient.getCurrentVisitNo() != null) {
				lastVisitNo = patient.getCurrentVisitNo();
			}
			if (patient.getMasMedicalExamFamilyHis() != null) {
				familyHisSet = patient.getMasMedicalExamFamilyHis();
			}
		} else if (list.size() > 0) {
			for (Iterator iterator = list.iterator(); iterator
					.hasNext();) {
				patient = (Patient) iterator.next();
				regHinId = patient.getId();
				patientStatus = patient.getPatientStatus();
			/* 	if (patient.getRelation().getId() == 8) {
					regHinId = patient.getId();
					selfHinNo = patient.getHinNo();
					patientStatus = patient.getPatientStatus();
					if (patient.getCurrentVisitNo() != null) {
						lastVisitNo = patient.getCurrentVisitNo();
					}
					if (patient.getMasMedicalExamFamilyHis() != null) {
						familyHisSet = patient
								.getMasMedicalExamFamilyHis();
					}
				} */
			}
		}

		servPersonFName = patient.getSFirstName();
		if (patient.getSMiddleName() != null)
			servPersonMName = patient.getSMiddleName();
		if (patient.getSLastName() != null)
			servPersonLName = patient.getSLastName();

		Box box = HMSUtil.getBox(request);
		int hinId = 0;
		if (box.getInt("hinId") != 0) {
			hinId = box.getInt("hinId");
		} else if (regHinId != 0) {
			hinId = regHinId;
		}
		int age = 0;
		if(patient.getAge()!=null)
		{
			 age = Integer.parseInt(patient.getAge().split(" ")[0]);
		    
		}
		
%>		
<div class="Block">
<!--<label>HIN</label>
--><!--<label id="defaulthinno" class="value" style="display: none;">&nbsp;</label>
--><label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO%>" value=""  validate="HIN,metachar,no"/>
<div class="clear"></div>
<div id="srNoDiv" style="display: block;">
<label>Reg. No<span></span></label>

<%-- <input 	id="prefix" name="<%=PREFIX%>" maxlength="3" class="auto" size="1" value="<%=patient.getPrefix() != null ? patient.getPrefix()
						: ""%>"	tabindex="1" validate="Prefix,metachar,no" />  --%>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO%>" value="<%=serviceNo%>" title="Enter Service No" tabindex="1" validate="Service No.,metachar,no" maxlength="20"
	onblur="if(validateMetaCharacters(this.value)){validateServiceNoHAL(this.value,'registration');}">
	<input type="hidden" value=""  id="serviceTypeId" name="serviceTypeId"/> 
	<input type="hidden" value="<%=regHinId%>"  id="regHinId" name="regHinId"/>  
	<input type="hidden" value="<%=patientTypeNameForOther%>"  id="patientTypeName" name="patientTypeName"/> 

<div class="clear"></div>
<label>First Name</label> 
<%
 	if (!fNameLdap.equals("")) {
 			servPersonFName = fNameLdap;
 		}
 %>

<input id="sFNameId" type="text" name="<%=S_FIRST_NAME%>" value="<%=servPersonFName%>" tabindex="1"	title="First Name"	validate="First Name,string,yes" MAXLENGTH="150"	onblur="" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value="<%=servPersonMName%>"	tabindex="1" validate="Middle Name,string,no"	MAXLENGTH="30" onchange="" />

<label>Last Name</label> 
<%
 	if (!lNameLdap.equals("")) {
 			servPersonLName = lNameLdap;
 		}
 %>
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME%>" value="<%=servPersonLName%>" tabindex="1"	validate="Last Name,string,no" MAXLENGTH="30"	onchange="" />
<script>
document.getElementById('pFirstNameId').value = '<%=servPersonFName%>'
document.getElementById('pMiddleNameId').value = '<%=servPersonMName%>'
document.getElementById('pLastNameId').value = '<%=servPersonLName%>'
</script>
<div id="srPrDtDiv">
<div class="clear"></div>

<%
	if (patient.getSrSex() != null) {
%>
<label >Gender</label>
<!--<label class="value"><%=patient.getSrSex().getAdministrativeSexName()%></label>
<input 	type="hidden" name="<%=SR_SEX%>"	value="<%=patient.getSrSex().getId()%>">
-->
<select name="<%=SR_SEX%>" id="srSexId" validate="" tabindex="1" onchange="">
    <%
    	for (Object[] masAdministrativeSex : sexList) {
    				if (masAdministrativeSex[0]
    						.equals(patient.getSrSex().getId())) {
    %>
<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1]%></option>
<%
	} else {
%>
<option value="<%=masAdministrativeSex[0]%>"><%=masAdministrativeSex[1]%></option>
<%
	}
			}
%>
</select>
<script>
document.getElementById('gender').value='<%=patient.getSrSex().getId()%>';
</script>
<%
	} else {
%>
<label > Gender <span>*</span></label>
<select name="<%=SR_SEX%>" id="srSexId" validate="" tabindex="1" onchange="">
    <%
    	for (Object[] masAdministrativeSex : sexList) {
    				if (masAdministrativeSex[2]
    						.equals(administrativeSexMaleCode)) {
    %>
<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1]%></option>
<%
	} else {
%>
<option value="<%=masAdministrativeSex[0]%>"><%=masAdministrativeSex[1]%></option>
<%
	}
			}
%>
</select>

<%
	}
%>

<label>DOB<span>*</span></label> 
<%
 	String charat2 = "";
 		if (!dobLdap.equals("")) {
 			charat2 = dobLdap.substring(2, 3);
 		}

 		if (!dobLdap.equals("") && charat2.equals("/")) {
 %>
 <input type="text" id="srdobId" name="<%=SR_DOB%>" tabindex="1" value="<%=dobLdap%>"  validate="Date of Birth,date,yes"  MAXLENGTH="10" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(validateExpDateHAL(this,'srdobId')){if(setAge(this.value, 'srAgeId')){setAge(this.value, 'ageId');}}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<%
	} else 
		
		if (patient.getSrDob() != null
				&& !patient.getSrDob().equals("")) {
%>
 <input type="text" id="srdobId" name="<%=SR_DOB%>" tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(patient
							.getSrDob())%>"  validate="Date of Birth,date,yes"  MAXLENGTH="10" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(validateExpDateHAL(this,'srdobId')){setAge(this.value, 'srAgeId'); setAge(this.value, 'ageId');}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<script>
document.getElementById('dobId').value='<%=HMSUtil.convertDateToStringWithoutTime(patient.getSrDob())%>';
</script>
<%
	} else {
%>
<input type="text" id="srdobId" name="<%=SR_DOB%>" tabindex="1" value=""  validate="Date of Birth,date,yes"  MAXLENGTH="10" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(validateExpDateHAL(this,'srdobId')){setAge(this.value, 'srAgeId'); setAge(this.value, 'ageId');}"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<%
	}
%>

		
<label>Age</label>
<div id="srAgeDiv" style="display: block;"> 

<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Patient,metachar,no" tabindex="1" class="small" onchange="">
          <option value="">Select</option>
          <%
          	for (int age1 = 1; age1 <= 100; age1++) {
          		if(age==age1)
          		{
          		  %>
                  <option selected="selected" value="<%=age1%>"><%=age1%></option>
                  <%
          		}
          		else
          		{
          		  %>
                  <option value="<%=age1%>"><%=age1%></option>
                  <%
          		}
       
          	}
          %>
</select>
  
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
<input type="hidden" id="idForSrAge" value=""  validate="Age,metachar,no">  
</div>
<%  String srage = "";
	if (patient.getSrAge() != null) {
		
		String currentAge = "";
		srage = patient.getSrAge().split(" ")[0];
	}
	%>
	<script>	
<%-- document.getElementById('srAgeId').value='<%=srage%>';
document.getElementById('srdobId').value='<%=srage%>'; --%>
alert("hi");
document.getElementById('srdobId').blur();

</script>
<div class="clear"></div>

<label>Category	</label> 
<select name="categoryId" id="categoryId"	validate="Marital Status of service Person,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(Object[] othersCategory : othersCategoryList){
	%>
	<option value="<%=othersCategory[0]%>"><%=othersCategory[1]%></option>
	<%}%>
</select> 
 <script>
   <%if (patient.getOthersCategory() != null) {%>
document.getElementById('categoryId').value='<%=patient.getOthersCategory().getId()%>';
   <%}%>
   </script>

<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,string,no" tabindex="1" onchange="">
	<option value="0">Select</option>
	<%
		for (Object[] masMaritalStatus : maritalStatusList) {
	%>
	<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
	<%
		}
	%>
</select> 
 <script>
   <%if (patient.getSrMaritalStatus() != null) {%>
document.getElementById('srmrstatus').value='<%=patient.getSrMaritalStatus().getId()%>';
   <%}%>
   </script>
  


<label>Marriage Date</label> 
<input type="text" id="srMarriageDateId"	name="srMarriageDate" tabindex="1" value="<%=patient.getSrMarriageDate() != null ? HMSUtil
						.convertDateToStringWithoutTime(patient
								.getSrMarriageDate()) : ""%>"	onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srMarriageDateId'); " validate="Marriage Date,date,no" MAXLENGTH="10" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.srMarriageDate,event)" />
<div class="clear"></div>
 
<label > Religion</label>

<select id="religionId" name="<%=RELIGION_ID%>" validate="Religion,string,no"  tabindex="1">
<option value="0">Select</option>
<%
	for (Object[] masReligion : religionList) {
%>
<option value="<%=masReligion[0]%>"><%=masReligion[1]%></option>
<%
	}
%>
</select>
<%
	if (patient.getReligion() != null) {
		%>
		<script>
		document.getElementById("religionId").value = <%=patient.getReligion().getId()%>
		</script>
		
		<%
	}
%>



<div id="afDiv">
<%-- <label>AFNET No.</label> 
<%
 	if (patient.getAfnetNo() != null) {
 %>
<input id="afnetNo" name="afnetNo" type="text" value="<%=patient.getAfnetNo()%>" tabindex="1" maxlength="15" />
<%
	} else {
%>
<input id="afnetNo" name="afnetNo" type="text" tabindex="1" maxlength="15" />
<%
	}
%> --%>
</div>


<label>Telephone No.(Off.)</label> 
<%
 	if (patient.getPhoneNumber() != null) {
 %>
<input id="phoneNo" name="<%=TELEPHONE_NO%>" type="text" value="<%=patient.getPhoneNumber()%>" tabindex="1" maxlength="11" validate="Telephone No.(Off.),phone,no"/>
<%
	} else {
%>
<input id="phoneNo" name="<%=TELEPHONE_NO%>" type="text" value="" tabindex="1" maxlength="11" validate="Telephone No.(Off.),phone,no"/>
<%
	}
%>

<label>Mobile No.</label> 
<%
 	if (patient.getMobileNumber() != null) {
 %>
<input name="<%=MOBILE_NO%>" id="mobileNo"  type="text" value="<%=patient.getMobileNumber()%>" tabindex="1" maxlength="11" validate="Mobile No.,phone,no"/>
<%
	} else {
%>
<input name="<%=MOBILE_NO%>" id="mobileNo"  type="text" value="" tabindex="1" maxlength="11" validate="Mobile No.,phone,no"/>
<%
	}
%>
<div class="clear"></div>
<label>Telephone No.(Res.)</label> 
<%
 	if (patient.getTelephoneResi() != null
 				&& !(patient.getTelephoneResi().equals("null"))) {
 %>
<input id="phoneNoRes" name="phoneNoRes" type="text" value="<%=patient.getTelephoneResi()%>" tabindex="1" maxlength="11" validate="Telephone No.(Res.),phone,no"/>
<%
	} else {
%>
<input id="phoneNoRes" name="phoneNoRes" type="text" tabindex="1" maxlength="11" validate="Telephone No.(Res.),phone,no"/> 
<%
 	}
 %>

<label>Other Contact No.</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="60" name="otherContactNo" validate="Other Contact No.,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getOtherContactNo() != null ? patient
						.getOtherContactNo() : ""%></textarea>
<div class="clear"></div>
<label>Local Address</label> 
<%
 	String add = "";
 		if (patient.getAddress() != null) {
 			add = patient.getAddress().toString();

 		}
 %>
<textarea name="<%=ADDRESS%>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no" maxlength="500"
	onblur=""><%=add%>
</textarea>

<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','srcityId')"  onblur=""> 
	<option value="0">Select</option>
	<%
		for (Object[] masState : stateList) {
	%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>
<label>City</label> 
<select name="<%=DISTRICT%>" 	validate="City,string,no" id="srcityId" tabindex="1" onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for (Object[] masDistrict : districtList) {
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select> 

<script>
<%if (patient.getDistrict() != null) {%>
document.getElementById('srcityId').value='<%=patient.getDistrict().getId()%>';
document.getElementById('cityId').value='<%=patient.getDistrict().getId()%>';
<%}%>
</script>


<div class="clear"></div>
<script>
<%if (patient.getState() != null) {%>
document.getElementById('srstateId').value='<%=patient.getState().getId()%>';
document.getElementById('stateId').value='<%=patient.getState().getId()%>';
<%}%>
</script>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS%>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no" maxlength="500"><%=patient.getPermanentAddress() != null ? patient.getPermanentAddress() : ""%>
</textarea>

	
	<label>State</label> 
<select id="permStateId" name="permStateId"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','perCityId')">
	<option value="0">Select</option>
	<%
		for (Object[] masState : stateList) {
	%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>
<label>City</label>
<select name="permCityId" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value,'permStateId');">
	<option value="0">Select</option>
	<%
		for (Object[] masDistrict : districtList) {
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select>
<script>
<%if (patient.getPermanentCity() != null) {%>
document.getElementById('perCityId').value='<%=patient.getPermanentCity().getId()%>';
<%}%>
</script>

<script>
<%if (patient.getPermanentState() != null) {%>
document.getElementById('permStateId').value='<%=patient.getPermanentState().getId()%>';
<%}%>
</script>
<div class="clear"></div>

<label>Telephone No.</label> 
<input id="telephoneNoPerm" name="telephoneNoPerm" type="text" tabindex="1" maxlength="11" validate="Telephone No.,phone,no" value="<%=patient.getTelephoneNoPerm() != null ? patient
						.getTelephoneNoPerm() : ""%>"/>
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15" value="<%=patient.getPoliceStation() != null ? patient.getPoliceStation() : ""%>" validate="Police Station,metachar,no" /> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8"  validate="Pin Code,int,no" value="<%=patient.getPinCode() != null ? patient.getPinCode()
						: ""%>"/>   
<div class="clear"></div>
<label>Identification Mark 1</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" validate="Identification Mark 1,metachar,no" name="identificationMark1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getSrIdentificationMark1() != null ? patient
						.getSrIdentificationMark1() : ""%></textarea>

<label>Identification Mark 2</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" validate="Identification Mark 2,metachar,no"  name="identificationMark2" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=patient.getSrIdentificationMark2() != null ? patient
						.getSrIdentificationMark2() : ""%></textarea>

<div class="clear"></div>
</div><!-- End Block 2-->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=SR_NEXT_OF_KIN_NAME%>" value="<%=((patient.getNextOfKinName() != null) ? patient
						.getNextOfKinName() : "")%>" tabindex="1"	validate="NOK1 Name,string,no" id="srnokNameId" maxlength="30" onblur="copyAddress(this.value,this.id);"/>
	
<label>  Relation</label> 
<select	name="<%=SR_NEXT_OF_KIN_RELATION_ID%>" validate="NOK1 Relation,String,no"	tabindex="1" id="srrelId">
	<option value="0">Select</option>

	<%
		for (Object[] obj : relationList) {
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>
<script>
<%if (patient.getNextOfKinRelation() != null) {%>
document.getElementById('srrelId').value='<%=patient.getNextOfKinRelation().getId()%>';
<%}%>
</script>
<label> Contact No.</label> 
<input	type="text" name="<%=SR_NEXT_OF_KIN_PHONE_NO%>" id="srnok1Phone" tabindex="1" value="<%=((patient.getNextOfKinPhoneNumber() != null) ? patient
								.getNextOfKinPhoneNumber()
								: "")%>"	validate="NOK1 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=SR_NEXT_OF_KIN_ADDRESS%>" id="srnextOfKinAdd" tabindex="1"	cols="20" rows="2"  validate="Nok1 Address,string,no" maxlength="500"
	><%=((patient.getNextOfKinAddress() != null) ? patient
						.getNextOfKinAddress() : "")%></textarea>
<label>Police Station</label> 
<input id="srnok1PoliceStation" name="srnok1PoliceStation" type="text" tabindex="1"  validate="Police Station,metachar,no"  value="<%=((patient.getNok1PoliceStation() != null) ? patient
						.getNok1PoliceStation() : "")%>" maxlength="15"/> 
<label>Pin Code</label> 
<input id="srnok1PinCode" name="srnok1PinCode" type="text" tabindex="1"  validate="Pin Code,int,no" maxlength="8" value="<%=((patient.getNok1PinCode() != null) ? patient
						.getNok1PinCode() : "")%>" /> 
<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>

<input type="text" name="srnok2Name" value="<%=((patient.getNok2Name() != null) ? patient
						.getNok2Name() : "")%>" tabindex="1"	validate="NOK2 Name,string,no" id="srnok2NameId" maxlength="30" onblur="copyAddress(this.value,this.id);fillNok2Details();"/>
	
<label>  Relation</label> 
<select	name="srnok2RelationId" validate="NOK2 Relation,String,no" tabindex="1"	id="srnok2RelId">
	<option value="0">Select</option>

	<%
		for (Object[] obj : relationList) {
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>
<script>
<%if (patient.getNok2Relation() != null) {%>
document.getElementById('srnok2RelId').value='<%=patient.getNok2Relation().getId()%>';
<%}%>
</script>
<label> Contact No.</label> 
<input	type="text" name="srnok2ContactNo" id="srnok2Contact" tabindex="1" value="<%=(patient.getNok2ContactNo() != null ? patient
						.getNok2ContactNo() : "")%>"	validate="NOK2 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="srnok2Address" id="srnok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no" maxlength="500"
		><%=(patient.getNok2Address() != null ? patient
						.getNok2Address() : "")%>	</textarea>
<label>Police Station</label> 
<input id="srnok2PoliceStation" name="srnok2PoliceStation" type="text" tabindex="1"  validate="Police Station,metachar,no"  value="<%=(patient.getNok2PoliceStation() != null ? patient
						.getNok2PoliceStation() : "")%>" maxlength="15" /> 
<label>Pin Code</label> 
<input id="srnok2PinCode" name="srnok2PinCode" type="text" value="<%=(patient.getNok2PinCode() != null ? patient
						.getNok2PinCode() : "")%>" tabindex="1" maxlength="8"  validate="Pin Code,int,no"/>
<input type="hidden" name="patientStaus" id="patientStatus" value="<%=patientStatus%>"  validate="Patient Status,metachar,no"/>
<div class="clear"></div>

</div><!-- End Block 3-->
<%--<div class="clear"></div>
<h4>Medical Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Blood Group</label> 
<select name="<%=SR_BLOOD_GROUP_ID%>"	id="srBldGrp" validate="Blood Group,string,no" tabindex="1">	
<option value="0">Select</option>
	<%
		for (Object[] masBloodGroup : bloodGroupList) {
	%>
	<option value="<%=masBloodGroup[0]%>"><%=masBloodGroup[1]%></option>
	<%
		}
	%>
</select>
<label>Family History</label> 
<select name="srfamilyHistory" id="srfamilyHistory" tabindex="1" multiple="multiple" class="list" onclick="openOtherField(this.value,this.id);">
 <option value="0">Select</option>
<%
	if (familyHistoryList.size() > 0) {
			for (Object[] familyHistory : familyHistoryList) {
%>
		<option value="<%=familyHistory[0]%>"><%=familyHistory[1]%></option>
	<%
		}
			}
	%>
</select>
<div id="otherSrFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" name="otherSrFamilyHistory" id="otherSrFamilyHistory" value=""  maxlength="50"  validate="Other,metachar,no"   onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</div>
<label> Allergy</label> 
<textarea name="srAllergies" id="srAllergies" value=""	validate="Allergy,string,no" maxlength="100"  validate="Allergy,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</textarea>

<div class="clear"></div>
<div id="medCatDiv">
<label>Present Med Cat  </label> 
 <select 	name="presentMedCat" id="presentMedCat" validate="Present Med Cat,string,no" tabindex=1>
 <option value="0">Select</option>
 <%
 	for (Object[] category : categoryList) {
 %>
	<option value="<%=category[0]%>" ><%=category[1]%> </option>
	<%
		}
	%>
 </select>
 <label>Period  </label> 
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="20"  class="small"  validate="Period,metachar,no" />
  <select name="medCatDuration" id="medCatDuration" class="small"  validate="Period,metachar,no">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
  <label>Date  </label> 
 <input type="text" name="medCatDate" id="medCatDate" value="" maxlength="10"  class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'medCatDate'); "/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.registration.medCatDate,event)" /> 
	</div>
	<div class="clear"></div>
	
<label>Smoker</label>
<label class="auto"><10</label>
<input type="checkbox" name="srsmokerLess10" id="srsmokerLess10" class="radioAuto2" tabindex="1"/>
<label class="auto">>10</label>
<input type="checkbox" name="srsmokerMore10" id="srsmokerMore10" class="radioAuto2" tabindex="1"/>
<label>Alcohol</label>
<select name="sralcohol" id="sralcohol" tabindex="1">
<option value="">Select</option>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
</select> 
<div class="clear"></div>
</div>--%>
<script>
<%if (regHinId != 0) {%>	
document.getElementById('hinNoDivId').innerHTML='';
	document.getElementById('hinNoId').value="";
<%}

				if (patient.getPrefix() != null) {%>

document.getElementById("prefix").value='<%=patient.getPrefix()%>';
<%}%>
document.getElementById("suffixId").value='<%=patient.getSuffix()%>';
<%--for display patient history --%>
<%if (familyHisSet.size() > 0) {%>		
	var obj = document.getElementById('srfamilyHistory');
	if(obj.length > 0){
		for(var i=0;i<obj.length;i++){
			bar = new Array();
			
<%int i = 0;
					for (MasMedicalExamFamilyHis meExamFamilyHis : familyHisSet) {%>
			bar[<%=i%>] = <%=meExamFamilyHis.getPatientFamilyHistory()
								.getId()%>;
<%i++;
					}%>
			for(var m=0; m<bar.length;m++)
			{
				if (obj[i].value == bar[m])
				{ 
					obj[i].selected = true;
					break;
				}
			}


		}

	}
<%}%>
<%--end for display patient history --%>

<%if (patient.getRelation().getId() == 8
						&& patient.getBloodGroup() != null) {%>
document.getElementById('srBldGrp').value='<%=patient.getBloodGroup().getId()%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getSmokerLess10() != null
						&& patient.getSmokerLess10().equalsIgnoreCase("y")) {%>
//document.getElementById('srsmokerLess10').checked=true;
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getSmokerMore10() != null
						&& patient.getSmokerMore10().equalsIgnoreCase("y")) {%>
//document.getElementById('srsmokerMore10').checked=true;
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getAlcohol() != null) {%>
//document.getElementById('sralcohol').value='<%=patient.getAlcohol()%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getCategory() != null) {%>
document.getElementById('presentMedCat').value='<%=patient.getCategory().getCategoryid()%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getMedCatDate() != null) {%>
document.getElementById('medCatDate').value='<%=HMSUtil.convertDateToStringWithoutTime(patient
							.getMedCatDate())%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getMedCatPeriod() != null) {
	String medCatPeriod=patient.getMedCatPeriod().substring(0,patient.getMedCatPeriod().indexOf(" "));
	String medCatDuration = patient.getMedCatPeriod().substring(patient.getMedCatPeriod().indexOf(" ")+1);					
						%>
document.getElementById('medCatPeriod').value='<%=medCatPeriod%>'
	
document.getElementById('medCatDuration').value='<%=medCatDuration%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getOtherFamilyHistory() != null) {%>
document.getElementById('otherSrFamilyHistoryDiv').style.display = 'block';
document.getElementById('otherSrFamilyHistory').value='<%=patient.getOtherFamilyHistory()%>'
<%}%>
<%if (patient.getRelation().getId() == 8
						&& patient.getDrugAllergies() != null) {
					String str = patient.getDrugAllergies()
							.replace("\r\n", " ").replace("\n", " ");%>
document.getElementById('srAllergies').value='<%=str%>'
<%}%>

<%-- <%if (hinId == 0) {%>
getHin();
<%}%> --%>
submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto&photoHinId=<%=regHinId%>','srPhoto');


</script>
<%
	}else if (srEmployeeList.size() > 0) {
		MasEmployee srEmployee = new MasEmployee();

		srEmployee = srEmployeeList.get(0);
		
		servPersonFName = srEmployee.getFirstName();
		
		if (srEmployee.getLastName() != null)
			servPersonLName = srEmployee.getLastName();
		int rankEmp = srEmployee.getRank().getId();
		Box box = HMSUtil.getBox(request);
	
%>		
<div class="Block">
<label id="hinNoDivId" class="value" style="display:none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO%>" value=""  validate="HIN,metachar,no"/>
<div class="clear"></div>
<div id="srNoDiv" style="display: block;">
<label>Reg. No<span></span></label>

<%-- <input 	id="prefix" name="<%=PREFIX%>" maxlength="3" class="auto" size="1" value="<%=srEmployee.getPrefix() != null ? srEmployee.getPrefix()
						: ""%>"	tabindex="1" validate="Prefix,metachar,no" />  --%>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO%>" value="<%=serviceNo%>" title="Enter Service No" tabindex="1" validate="Service No.,metachar,no" maxlength="20"
	onblur="if(validateMetaCharacters(this.value)){validateServiceNoHAL(this.value,'registration');}">
	<input type="hidden" value=""  id="serviceTypeId" name="serviceTypeId"/> 
 <!-- End Of rankDivId-->
<div class="clear"></div>
<label>First Name</label> 
<%
 	if (!fNameLdap.equals("")) {
 			servPersonFName = fNameLdap;
 		}
 %>

<input id="sFNameId" type="text" name="<%=S_FIRST_NAME%>" value="<%=servPersonFName%>" tabindex="1"	title="First Name"	validate="First Name,string,yes" MAXLENGTH="150"	onblur="" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value="<%=servPersonMName%>"	tabindex="1" validate="Middle Name,string,no"	MAXLENGTH="30" onchange="" />

<label>Last Name</label> 
<%
 	if (!lNameLdap.equals("")) {
 			servPersonLName = lNameLdap;
 		}
 %>
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME%>" value="<%=servPersonLName%>" tabindex="1"	validate="Last Name,string,no" MAXLENGTH="30"	onchange="" />
<script>
document.getElementById('pFirstNameId').value = '<%=servPersonFName%>'
document.getElementById('pMiddleNameId').value = '<%=servPersonMName%>'
document.getElementById('pLastNameId').value = '<%=servPersonLName%>'
</script>
<!-- End srPrDtDiv-->
<div class="clear"></div>
</div><!-- End Block 1-->


<%
	if (srEmployee.getGender() != null) {
%>
<label >Gender</label>

<select name="<%=SR_SEX%>" id="srSexId" validate="" tabindex="1" onchange="">
    <%
    	for (Object[] masAdministrativeSex : sexList) {
    				if (masAdministrativeSex[0]
    						.equals(srEmployee.getGender().getId())) {
    %>
<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1]%></option>
<%
	} else {
%>
<option value="<%=masAdministrativeSex[0]%>"><%=masAdministrativeSex[1]%></option>
<%
	}
			}
%>
</select>
<script>
document.getElementById('gender').value='<%=(srEmployee.getGender()!=null?srEmployee.getGender().getId():0)%>';
</script>
<%
	} else {
%>
<label > Gender <span>*</span></label>
<select name="<%=SR_SEX%>" id="srSexId" validate="" tabindex="1" onchange="">
    <%
    	for (Object[] masAdministrativeSex : sexList) {
    				if (masAdministrativeSex[2]
    						.equals(administrativeSexMaleCode)) {
    %>
<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1]%></option>
<%
	} else {
%>
<option value="<%=masAdministrativeSex[0]%>"><%=masAdministrativeSex[1]%></option>
<%
	}
			}
%>
</select>

<%
	}
%>

<label>DOB<span>*</span></label> 
<%
 	String charat2 = "";
 		if (!dobLdap.equals("")) {
 			charat2 = dobLdap.substring(2, 3);
 		}

 		if (!dobLdap.equals("") && charat2.equals("/")) {
 %>
 <input type="text" id="srdobId" name="<%=SR_DOB%>" tabindex="1" value="<%=dobLdap%>"  validate="Date of Birth,date,yes"  MAXLENGTH="10" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(this.value!=''){validateExpDate(this,'srdobId');calculateSRAgeInAjax()};"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<%
	} else {
%>
<input type="text" id="srdobId" name="<%=SR_DOB%>" tabindex="1" value=""  validate="Date of Birth,date,yes"  MAXLENGTH="10" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(this.value!=''){validateExpDate(this,'srdobId');calculateSRAgeInAjax()};"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />

<%
	}
%>
<%
	if (srEmployee.getAge() != null) {
			String age = srEmployee.getAge().substring(0,
					srEmployee.getAge().indexOf(" "));
			String ageunit = srEmployee.getAge().substring(
					srEmployee.getAge().indexOf(" ") + 1);
%>
<label>Age</label>
<label	class="value"><%=srEmployee.getAge()%></label>
<input	id="srAgeId" type="hidden" name="<%=SR_AGE%>"	value="<%=age%>"  validate="Age,metachar,no">
<input	id="srAgeUnitId" type="hidden" name="<%=SR_AGE_UNIT%>"	value="<%=ageunit%>"  validate="Age,metachar,no">
<script>

document.getElementById('ageId').value='<%=age%>';
document.getElementById('ageUnitId').value='<%=ageunit%>';
</script>
<%
	} else {
%>
<label>Age</label>
<div id="srAgeDiv" style="display: block;"> 

<select id="srAgeId" name="<%=SR_AGE%>" validate="Age of Patient,metachar,no" tabindex="1" class="small" onchange="">
          <option value="">Select</option>
          <%
          	for (int age1 = 16; age1 <= 65; age1++) {
          %>
          <option value="<%=age1%>"><%=age1%></option>
          <%
          	}
          %>
</select>
  <script>
  
  document.getElementById('srdobId').blur();

  </script>
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
<input type="hidden" id="idForSrAge" value=""  validate="Age,metachar,no">  
</div>


<%
	}
%>

<div class="clear"></div>
<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,string,no" tabindex="1" onchange="">
	<option value="0">Select</option>
	<%
		for (Object[] masMaritalStatus : maritalStatusList) {
	%>
	<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
	<%
		}
	%>
</select> 
 

<label>Marriage Date</label> 
<input type="text" id="srMarriageDateId"	name="srMarriageDate" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srMarriageDateId'); " validate="Marriage Date,date,no" MAXLENGTH="10" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.srMarriageDate,event)" />

 
<label > Religion</label>

<select id="religionId" name="<%=RELIGION_ID%>" validate="Religion,string,no"  tabindex="1">
<option value="0">Select</option>
<%
	for (Object[] masReligion : religionList) {
%>
<option value="<%=masReligion[0]%>"><%=masReligion[1]%></option>
<%
	}
%>
</select>


<div class="clear"></div>
<div id="afDiv">
<!-- <label>AFNET No.</label> 

<input id="afnetNo" name="afnetNo" type="text" tabindex="1" maxlength="15" validate="AFNET No.,metachar,no" /> -->

</div>


<label>Telephone No.(Off.)</label> 
<%
 	if (srEmployee.getTelNoOffice() != null) {
 %>
<input id="phoneNo" name="<%=TELEPHONE_NO%>" type="text" value="<%=srEmployee.getTelNoOffice()%>" tabindex="1" maxlength="11" validate="Telephone No.(Off.),phone,no"/>
<%
	} else {
%>
<input id="phoneNo" name="<%=TELEPHONE_NO%>" type="text" value="" tabindex="1" maxlength="11" validate="Telephone No.(Off.),phone,no"/>
<%
	}
%>

<label>Mobile No.</label> 
<%
 	if (srEmployee.getCellNoEmergency() != null) {
 %>
<input name="<%=MOBILE_NO%>" id="mobileNo"  type="text" value="<%=srEmployee.getCellNoEmergency()%>" tabindex="1" maxlength="11" validate="Mobile No.,phone,no"/>
<%
	} else {
%>
<input name="<%=MOBILE_NO%>" id="mobileNo"  type="text" value="" tabindex="1" maxlength="11" validate="Mobile No.,phone,no"/>
<%
	}
%>
<div class="clear"></div>
<label>Telephone No.(Res.)</label> 

<input id="phoneNoRes" name="phoneNoRes" type="text" tabindex="1" maxlength="11" validate="Telephone No.(Res.),phone,no"/> 

<label>Other Contact No.</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="60" name="otherContactNo" validate="Other Contact No.,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="clear"></div>
<label>Local Address</label> 

<textarea name="<%=ADDRESS%>" id="sraddr"	cols="20" rows="2" tabindex="1" validate="Address,metachar,no" maxlength="500"
	onblur="">
</textarea>

<label>City</label> 
<select name="<%=DISTRICT%>" 	validate="City,string,no" id="srcityId" tabindex="1" onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for (Object[] masDistrict : districtList) {
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select> 


<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','srcityId')"  onblur=""> 
	<option value="0">Select</option>
	<%
		for (Object[] masState : stateList) {
	%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS%>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no" maxlength="500"
	></textarea>

	
<label>City</label>
<select name="permCityId" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value,'permStateId');">
	<option value="0">Select</option>
	<%
		for (Object[] masDistrict : districtList) {
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select>

<label>State</label> 
<select id="permStateId" name="permStateId"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','perCityId')">
	<option value="0">Select</option>
	<%
		for (Object[] masState : stateList) {
	%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>

<label>Telephone No.</label> 
<input id="telephoneNoPerm" name="telephoneNoPerm" type="text" tabindex="1" maxlength="11" validate="Telephone No.,phone,no" value=""/>
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15" value="" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8"  validate="Pin Code,int,no" value=""/>   
<div class="clear"></div>
<label>Identification Mark 1</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="identificationMark1" validate="Identification Mark 1,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label>Identification Mark 2</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="identificationMark2" validate="Identification Mark 2,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="clear"></div>
</div><!-- End Block 2-->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=SR_NEXT_OF_KIN_NAME%>" value="" tabindex="1"	validate="NOK1 Name,string,no" id="srnokNameId" maxlength="30" onblur="copyAddress(this.value,this.id);"/>
	
<label>  Relation</label> 
<select	name="<%=SR_NEXT_OF_KIN_RELATION_ID%>" validate="NOK1 Relation,String,no"	tabindex="1" id="srrelId">
	<option value="0">Select</option>

	<%
		for (Object[] obj : relationList) {
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>

<label> Contact No.</label> 
<input	type="text" name="<%=SR_NEXT_OF_KIN_PHONE_NO%>" id="srnok1Phone" tabindex="1" value=""	validate="NOK1 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=SR_NEXT_OF_KIN_ADDRESS%>" id="srnextOfKinAdd" tabindex="1"	cols="20" rows="2"  validate="Nok1 Address,string,no" maxlength="500"
	></textarea>
<label>Police Station</label> 
<input id="srnok1PoliceStation" name="srnok1PoliceStation" type="text" tabindex="1" value="" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="srnok1PinCode" name="srnok1PinCode" type="text" tabindex="1"  validate="Pin Code,int,no" maxlength="8" value="" /> 
<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>

<input type="text" name="srnok2Name" value="" tabindex="1"	validate="NOK2 Name,string,no" id="srnok2NameId" maxlength="30" onblur="copyAddress(this.value,this.id);fillNok2Details();"/>
	
<label>  Relation</label> 
<select	name="srnok2RelationId" validate="NOK2 Relation,String,no" tabindex="1"	id="srnok2RelId">
	<option value="0">Select</option>

	<%
		for (Object[] obj : relationList) {
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>

<label> Contact No.</label> 
<input	type="text" name="srnok2ContactNo" id="srnok2Contact" tabindex="1" value=""	validate="NOK2 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="srnok2Address" id="srnok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,metachar,no" maxlength="500"
	></textarea>
<label>Police Station</label> 
<input id="srnok2PoliceStation" name="srnok2PoliceStation" type="text" tabindex="1" value="" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="srnok2PinCode" name="srnok2PinCode" type="text" value="" tabindex="1" maxlength="8"  validate="Pin Code,int,no"/>
<input type="hidden" name="patientStaus" id="patientStatus" value="<%=patientStatus%>"  validate="Patient Status,metachar,no"/>
<div class="clear"></div>

</div><!-- End Block 3-->
<script>
<%if (regHinId != 0) {%>	
document.getElementById('hinNoDivId').innerHTML='';
	document.getElementById('hinNoId').value="";
<%}
%>


/* getHin(); */

</script>
<%
	}  else { 
%>
<div class="Block">
<!--<label>HIN</label>
--><!--<label id="defaulthinno" class="value"  style="display: none;">&nbsp;</label>
--><label id="hinNoDivId" class="value" style="display: none;"></label>
<input id="hinNoId" type="hidden" name="<%=HIN_NO%>" value=""  validate="HIN,metachar,no"/>
<input type="hidden" value="<%=patientTypeNameForOther%>"  id="patientTypeName" name="patientTypeName"/> 
<h3 style="text-align: center;color:red;">No Record Found</h3>
<div class="clear"></div>
<div id="srNoDiv"  style="display: block;">
<label>Reg. No<span></span></label>

<%-- <input 	id="prefix" name="<%=PREFIX%>" maxlength="3" class="auto" value="<%=prefix%>" size="1"	tabindex="1" validate="Prefix,metachar,no"/> --%> 
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO%>" value="<%=serviceNo%>" title="Enter Service No" tabindex="1" validate="Service No.,metachar,no" maxlength="20"
	onblur="if(validateMetaCharacters(this.value)){validateServiceNoHAL(this.value,'registration');}">
	<input type="hidden" value=""  id="serviceTypeId" name="serviceTypeId"/> 
<div class="clear"></div>
<label>First Name <span>*</span></label> 
<input id="sFNameId" type="text" name="<%=S_FIRST_NAME%>" value="<%=fNameLdap%>" tabindex="1"	title="First Name"	validate="First Name,string,yes" MAXLENGTH="150"	onblur="" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>" value=""	tabindex="1" validate="Middle Name,string,no"	MAXLENGTH="30" onchange="" />

<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=S_LAST_NAME%>" value="<%=lNameLdap%>" tabindex="1"	validate="Last Name,string,no" MAXLENGTH="30"	onchange="" />

<label>Gender <span>*</span></label>
<select name="<%=SR_SEX%>" id="srSexId" validate="" tabindex="1"	onchange="">
	<%
		for (Object[] masAdministrativeSex : sexList) {
				if (masAdministrativeSex[2]
						.equals(administrativeSexMaleCode)) {
	%>
<option value="<%=masAdministrativeSex[0]%>" selected="selected"><%=masAdministrativeSex[1]%></option>
<%
	} else {
%>
<option value="<%=masAdministrativeSex[0]%>"><%=masAdministrativeSex[1]%></option>	<%
		}
			}
	%>
</select> 
<%
 	String charat2 = "";
 		if (!dobLdap.equals("")) {
 			charat2 = dobLdap.substring(2, 3);
 		}
 		String dob = "";
 		if (!dobLdap.equals("") && charat2.equals("/")) {
 			dob = dobLdap;
 		}
 %>
<label>DOB<span>*</span></label> 
<input type="text" id="srdobId" name="<%=SR_DOB%>"	tabindex="1" value="<%=dob%>" validate="Date of Birth,date,yes" MAXLENGTH="30" class="calDate"	onkeyup="mask(this.value,this,'2,5','/');"		onblur="if(validateExpDateHAL(this,'srdobId')){if(setAge(this.value, 'srAgeId')){setAge(this.value, 'ageId');}}" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.<%=SR_DOB%>,event)" />


<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Patient,metachar,no"	tabindex="1" class="small"	onchange="">
	<option value="">Select</option>
	<%
		for (int age1 = 1; age1 <= 100; age1++) {
	%>
	<option value="<%=age1%>"><%=age1%></option>
	<%
		}
	%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly">
</div>
<input type="hidden" id="idForSrAge" value=""  validate="Age,metachar,no">
<script>

document.getElementById('srdobId').blur();

</script>
<div class="clear"></div>
<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,string,no" tabindex="1" onchange="">
	<option value="0">Select</option>
		<%
			for (Object[] masMaritalStatus : maritalStatusList) {
		%>
	<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
	<%
		}
	%>
</select> 


<label>Marriage Date</label> 
<input type="text" id="srMarriageDateId"	name="srMarriageDate" tabindex="1" value=""	onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srMarriageDateId');checkSrMarriageDateForReg() ;" validate="Marriage Date,date,no" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.registration.srMarriageDate,event)" />

 
<label > Religion</label>
<select id="religionId" name="<%=RELIGION_ID%>" validate="Religion,string,no"  tabindex="1">
<option value="0">Select</option>
<%
	for (Object[] masReligion : religionList) {
%>
<option value="<%=masReligion[0]%>"><%=masReligion[1]%></option>
<%
	}
%>
</select>
<div class="clear"></div>
<div id="afDiv">

</div>

<label>Telephone No.(Off.)</label> 
<input id="phoneNo" name="<%=TELEPHONE_NO%>" type="text" tabindex="1" maxlength="11" validate="Telephone No.(Off.),phone,no"/> 
<label>Mobile No.</label> 
<input id="mobileNo" name="<%=MOBILE_NO%>" type="text" tabindex="1"	maxlength="11" validate="Mobile No.,phone,no"/>


<label>Telephone No.(Res.)</label> 
<input id="phoneNoRes" name="phoneNoRes" type="text" tabindex="1" maxlength="11" validate="Telephone No.(Res.),phone,no"/> 
<div class="clear"></div>
<label>Other Contact No.</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="60" name="otherContactNo"  validate="Other Contact No.,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="clear"></div>
<label>Local Address</label> 
<textarea name="<%=ADDRESS%>" id="sraddr" tabindex="1"	cols="20" rows="2" tabindex="1" validate="Address,string,no" maxlength="500"
	 onblur="" ></textarea>
	
	<label>State</label> 
<select id="srstateId" name="<%=STATE%>"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','srcityId')" onblur="">
	<option value="0">Select</option>
<%
	for (Object[] masState : stateList) {
%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>
<label>City</label> 
<select name="<%=DISTRICT%>" 	validate="City,string,no" id="srcityId" tabindex="1"  onblur="populateStateForCity(this.value,'srstateId');">
	<option value="0">Select</option>
	<%
		for (Object[] masDistrict : districtList) {
	%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select> 

<div class="clear"></div>

<label>Permanent Address</label> 
<textarea name="<%=PERMANENT_ADDRESS%>" id="peraddr"	cols="20" rows="2" tabindex="1" validate="Address,string,no" maxlength="500"
	></textarea>

	
	<label>State</label> 
<select id="permStateId" name="permStateId"	validate="State,string,no" tabindex="1"	onChange="populateDistrict(this.value,'registration','perCityId')">
	<option value="0">Select</option>
	<%
		for (Object[] masState : stateList) {
	%>
	
	<option value="<%=masState[0]%>"><%=masState[1]%></option>
	<%
		}
	%>
</select>
<label>City</label> 
<select name="permCityId" validate="City,string,no" id="perCityId" tabindex="1" onchange="populateStateForCity(this.value,'permStateId');">
	<option value="0">Select</option>
<%
	for (Object[] masDistrict : districtList) {
%>
	<option value="<%=masDistrict[0]%>"><%=masDistrict[1]%></option>
	<%
		}
	%>
</select> 


<div class="clear"></div>
<label>Telephone No.</label> 
<input id="telephoneNoPerm" name="telephoneNoPerm" type="text" tabindex="1" maxlength="11" validate="Telephone No.,phone,no"/> 
<label>Police Station</label> 
<input id="policeStation" name="policeStation" type="text" tabindex="1" maxlength="15"  validate="Police Station,metachar,no" /> 
<label>Pin Code</label> 
<input id="pinCode" name="pinCode" type="text" tabindex="1" maxlength="8"  validate="Pin Code,int,no"/> 

<div class="clear"></div>
<label>Identification Mark 1</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="identificationMark1" validate="Identification Mark 1,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label>Identification Mark 2</label> 
<textarea cols="20" rows="2" tabindex="1" maxlength="50" name="identificationMark2" validate="Identification Mark 2,metachar,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<div class="clear"></div>
</div><!-- End Block 2-->
<div class="clear"></div>
<h4>NOK Details</h4>
<div class="clear"></div>
<div class="Block">
<label> NOK1</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="<%=SR_NEXT_OF_KIN_NAME%>" value="" tabindex="1"	validate="NOK1 Name,string,no" id="srnokNameId" maxlength="30" onblur="copyAddress(this.value,this.id);"/>
	
<label>  Relation</label> 
<select	name="<%=SR_NEXT_OF_KIN_RELATION_ID%>" tabindex="1" validate="NOK1 Relation,String,no"	id="srrelId">
	<option value="0">Select</option>

	<%
		for (Object[] obj : relationList) {
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>
<label> Contact No.</label> 
<input	type="text" name="<%=SR_NEXT_OF_KIN_PHONE_NO%>" value="" tabindex="1"  id="srnok1Phone"	validate="NOK1 Contact No,phone,no" maxlength="11" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="<%=SR_NEXT_OF_KIN_ADDRESS%>" id="srnextOfKinAdd" 	cols="20" rows="2" tabindex="1" validate="Nok1 Address,string,no" maxlength="500"
	></textarea>
<label>Police Station</label> 
<input id="srnok1PoliceStation" name="srnok1PoliceStation" type="text" tabindex="1" maxlength="15"  validate="Police Station,metachar,no" /> 
<label>Pin Code</label> 
<input id="srnok1PinCode" name="srnok1PinCode" type="text" tabindex="1" maxlength="8"   validate="Pin Code,int,no"/> 
<div class="clear"></div>
	
<label> NOK2</label>
<div class="clear"></div>
<label>  Name</label>
<input type="text" name="srnok2Name" value=""	validate="NOK2 Name,string,no" id="srnok2NameId" tabindex="1" maxlength="30" onblur="copyAddress(this.value,this.id);;fillNok2Details();"/>
	
<label>  Relation</label> 
<select	name="srnok2RelationId" validate="NOK2 Relation,String,no" tabindex="1"	id="srnok2RelId">
	<option value="0">Select</option>
<%
	for (Object[] obj : relationList) {
%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<%
		}
	%>
</select>
<label> Contact No.</label> 
<input	type="text" name="srnok2ContactNo" value="" tabindex="1"  id="srnok2Contact"	validate="NOK2 Contact No,phone,no" maxlength="16" />
<div class="clear"></div>
<label> Address</label> 
<textarea name="srnok2Address" id="srnok2Add"	cols="20" rows="2" tabindex="1" validate="Nok2 Address,string,no" maxlength="500"
	></textarea>
	<label>Police Station</label> 
<input id="srnok2PoliceStation" name="srnok2PoliceStation" type="text" tabindex="1" maxlength="15" validate="Police Station,metachar,no"/> 
<label>Pin Code</label> 
<input id="srnok2PinCode" name="srnok2PinCode" type="text" tabindex="1" maxlength="8"  validate="Pin Code,int,no"/> 
<input type="hidden" name="patientStaus" id="patientStatus" value=""  validate="Patient Status,metachar,no"/>
<div class="clear"></div>
</div><!-- End Block 3-->


<%
	}
%>
<input type="hidden" name="ldapData" value="<%=ldapData%>" />
<script>
document.getElementById("visitNo").value='<%=lastVisitNo + 1%>';
document.getElementById('relationId').value = '0'
</script>