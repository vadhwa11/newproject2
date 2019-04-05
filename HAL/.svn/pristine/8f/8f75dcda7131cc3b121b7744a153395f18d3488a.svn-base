
<%@ page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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

<form name="flyingClothingInspection" method="post" action="">
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
			List<MasUnit> unitList = null;
			List<MasRank> rankList = null;
			List<MasTrade> tradeList = null;
			List<Patient> patientList = null;
			List<MasEmployee> doctorList = null;
			List<MasAdministrativeSex> sexList = null;
			if(map.get("unitList") != null){
				unitList =(List<MasUnit>)map.get("unitList");
			}
			if(map.get("rankList") != null)	{
				rankList = (List<MasRank>)map.get("rankList");
			}
			if(map.get("patientList") != null)	{
				patientList = (List<Patient>)map.get("patientList");
			}
			
			if(map.get("tradeList") != null){
				tradeList =(List<MasTrade>)map.get("tradeList");
			}
			if (map.get("sexList") != null) {
		 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
		 	}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
			if(map.get("doctorList") != null){
				doctorList=(List)map.get("doctorList");
				}
			
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			%>  

<div class="titleBg">
<h2>Flying Clothing Inspection</h2>
</div>
<div class="clear paddingTop15"></div>
<h4>AIRCREW DETAILS</h4>
<div class="Block">
<div class="clear"></div>
<label>Service No.<span>*</span></label>

<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" 
maxlength="20"	onblur="submitProtoAjaxWithDivName('flyingClothingInspection','/hms/hms/aviationMedicine?method=getServiceNoDetailsForReg&serviceNo='+this.value,'patientDiv');"/>

<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" /> 
</div>
<div id="patientDiv">
<input type="hidden" value="" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<div class="clear paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<label>Date <span>*</span></label>  
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date of Birth,date,yes" maxlength="7" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.flyingClothingInspection.<%=DATE%>,event)" />

<label> Rank</label> 
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}	}%>
</select>
<div class="clear"></div>

<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" maxlength="30" />

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" maxlength="30"	tabindex="1" /> 


<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes" tabindex="1" class="small">
<option value="">Select</option>
<%
			for(int age1 = 16;age1<=100;age1++){
			%>
<option value="<%=age1%>"><%= age1%></option>
<%}%>
</select> 
<label class="unit">Years</label>
<input type="hidden" id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value=""/>
<div class="clear"></div>
<label>Gender</label>
<select name="<%=SR_SEX %>" id="srSexId" validate="Service Person Gender,metachar,yes" tabindex="1">
<option value="0">Select</option>
<%
	for(MasAdministrativeSex masAdministrativeSex : sexList){
	%>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%	
		   	 	} %>
</select> 
<label>Unit</label> 
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%	for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		}%>
</select>

<label>Branch</label> 
<select name="<%=TRADE_ID %>"  id="<%=TRADE_ID %>">
<option value="0">Select</option>
	<%	for(MasTrade masTrade : tradeList){	%>
	
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%		
		}%>
</select>
</div>
<div class="clear"></div>

<div class="clear paddingTop15"></div>
<h4>INSPECTION DETAILS</h4>
<div class="clear"></div>
<div class="auto">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<TH scope="col">Item Name</TH>
<TH scope="col">Checked</TH>
<TH scope="col" colspan="2">Date</TH>
<TH scope="col">Remarks</TH>
</tr>
<tr>
<td><label>MASK</label></td>
<td>
<input type="checkbox" name="<%=MASK_STATUS %>" class="" />
<%--
<select name="<%=MASK_STATUS %>" id="<%=MASK_STATUS %>">
<option value="Checked">Checked</option>
<option value="Not Checked">Not Checked</option>
</select> --%>
</td>
<td>
<input type="text" id="<%=MASK_DATE %>" name="<%=MASK_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 /> 
</td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
 onClick="setdate('',document.flyingClothingInspection.<%=MASK_DATE%>,event)" />
</td>
<td>
<input type="text" name="maskRemarks" tabindex="1" size="50" maxlength="50"/>
</td>
</tr>
<tr>
<td><label>HELMET</label></td>
<td><input type="checkbox" name="<%=HELMET_STATUS %>" class="" /><%---
<select name="<%=HELMET_STATUS %>" id="<%=HELMET_STATUS %>">
<option value="Checked">Checked</option>
<option value="Not Checked">Not Checked</option>
</select> --%>
</td>
<td>
<input type="text" id="<%=HELMET_DATE %>" name="<%=HELMET_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 /> 
</td>
<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=HELMET_DATE%>,event)" /></td>
<td>
<input type="text" name="helmetRemarks" tabindex="1" size="50" maxlength="50"/>
</td>
</tr>
<tr>
<td><label>ANTI G SUIT</label></td>
<td><input type="checkbox" name="<%=ANTI_G_SUIT_STATUS %>" class="" />
<%--<select name="<%=ANTI_G_SUIT_STATUS %>" id="<%=ANTI_G_SUIT_STATUS %>">
<option value="Checked">Checked</option>
<option value="Not Checked">Not Checked</option>
</select> --%>
</td>
<td>
<input type="text" id="<%=ANTI_G_SUIT_DATE %>" name="<%=ANTI_G_SUIT_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 /> 
</td>
<td>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=ANTI_G_SUIT_DATE%>,event)" />
</td>
<td>
<input type="text" name="antiGSuitRemarks" tabindex="1" size="50" maxlength="50"/>
</td>
</tr>
<tr>
<td><label>OTHERS</label></td>
<td><input type="checkbox" name="<%=OTHERS_STATUS %>" class="" /><%---
<select name="<%=OTHERS_STATUS %>" id="<%=OTHERS_STATUS %>">
<option value="Checked">Checked</option>
<option value="Not Checked">Not Checked</option>
</select> --%>
</td>
<td>
<input type="text" id="<%=OTHER_DATE %>" name="<%=OTHER_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 /> 
</td>
<td>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=OTHER_DATE%>,event)" />
</td>
<td>
<input type="text" name="otherRemarks" tabindex="1" size="50" maxlength="50"/>
</td>
</tr>
</table>
</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label>Inspected by</label>
<select name="<%=MO_NAME %>"  id="<%=MO_NAME %>" tabindex="1">
<option value="0">Select</option>
	<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();	
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			if(user.getEmployee().getId() == doctorId){
%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%		} } } }%>
</select>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input	type="button" name="Submit" value="Submit" tabindex="1"	class="buttonbig" 
onClick="submitForm('flyingClothingInspection','aviationMedicine?method=submitFlyingClothingInspectionJsp');" />
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
