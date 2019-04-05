<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.AviFlyingClothingInspection"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>
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
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTimeWithoutSc");
List<MasUnit> unitList = null;
List<MasRank> rankList = null;
List<MasTrade> tradeList = null;
List<MasAdministrativeSex> sexList = null;

if(map.get("unitList") != null){
	unitList =(List<MasUnit>)map.get("unitList");
}
if(map.get("rankList") != null)	{
	rankList = (List<MasRank>)map.get("rankList");
}
if(map.get("tradeList") != null){
	tradeList =(List<MasTrade>)map.get("tradeList");
}

List<Patient> patientList = new ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}
if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
List<AviFlyingClothingInspection> aviFlyingClothingInspectionList = new ArrayList<AviFlyingClothingInspection>();
if(map.get("aviFlyingClothingInspectionList") != null){
	aviFlyingClothingInspectionList = (List<AviFlyingClothingInspection>)map.get("aviFlyingClothingInspectionList");
}
List<MasEmployee> doctorList = null;
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
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
if(aviFlyingClothingInspectionList.size() > 0){
	for(AviFlyingClothingInspection aviFlyingClothingInspection : aviFlyingClothingInspectionList){ %>
	

<div id="reg">
<div class="clear paddingTop15"></div>
<div class="Block">
<%if(aviFlyingClothingInspection.getHin() !=null)
  { %>
       	<input type="hidden" value="<%=aviFlyingClothingInspection.getHin().getId() %>" name="hinId"><%}else{ %>
		<input type="hidden" value="0" name="hinId">
<%} %>
<%if(aviFlyingClothingInspection.getId() !=null)
 { %>
		<input type="hidden" name="avAccidentId" value="<%=aviFlyingClothingInspection.getId() %>"><%}else{ %>
		<input type="hidden" value="" name="avAccidentId">
<%} %>
		<label>Date <span>*</span></label>
<%if(aviFlyingClothingInspection.getFlyingDate() !=null)
{ %>  
 	<input type="text" id="<%=DATE %>" name="<%=DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(aviFlyingClothingInspection.getFlyingDate())%>"	tabindex="1" value="" readonly="readonly"	validate="Date,date,yes" MAXLENGTH="30" class="calDate"	 />
<%}
else{ %>
   <input type="text" id="<%=DATE %>" name="<%=DATE %>" value="<%=currentDate%>"	tabindex="1" value="" readonly="readonly"	validate="Date,date,yes" MAXLENGTH="30" class="calDate"	 />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=DATE%>,event)" />
<label> Rank </label> 
  <select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
       <option value="0">Select</option>
          <%for(MasRank masRank : rankList)
          {
	         if(aviFlyingClothingInspection.getRank() !=null)
	         {
               if(aviFlyingClothingInspection.getRank().getId().equals(masRank.getId()))
               { %>	
                    <option value="<%=aviFlyingClothingInspection.getRank().getId()%>" selected="selected"><%=aviFlyingClothingInspection.getRank().getRankName()%></option>
             <%}else{ %>	
                    <option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
               <%}}else{ %>	
					<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
					<%}
				}%>
	</select>
<div class="clear"></div>
<label> First Name <span>*</span></label>
<%if(aviFlyingClothingInspection.getFirstName()!=null)
{ %> 
      <input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=aviFlyingClothingInspection.getFirstName() %>" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="15" />
<%}
else
{ %>
     <input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name"	validate="Patient First Name,name,yes" MAXLENGTH="15" />
<%} %>
<label>Last Name</label> 
<%if(aviFlyingClothingInspection.getLastName()!=null)
 { %> 
       <input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="<%=aviFlyingClothingInspection.getLastName() %>" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" />
<%}
else
{ %> 
		<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 
<%} %>
<label>Age <span>*</span></label>
	<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes" tabindex="1" class="small">
	<option value="">Select</option>
	<%
		String ageYears = "";
		String age = "";
		if(aviFlyingClothingInspection.getAge()!=null)
		{
			ageYears=aviFlyingClothingInspection.getAge();
			age = ageYears.substring(0,2);
		}
			for(int age1 = 16;age1<=100;age1++)
			{
			%>
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
<div class="clear"></div>
<label>Gender</label>
<select name="<%=SEX_ID %>" id="srSexId" validate="Gender,metachar,yes" tabindex="1" >
<%
	for(MasAdministrativeSex masAdministrativeSex : sexList){
	if(aviFlyingClothingInspection.getSex() !=null){
if(aviFlyingClothingInspection.getSex().getId().equals(masAdministrativeSex.getId())){ %>
<option value="<%=aviFlyingClothingInspection.getSex().getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
<%}else{ %>
<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
<%}}else{ %>
<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>

	<%	}
		   	 	} %>
</select> 


<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">

<option value="0">Select</option>

<%for(MasUnit masUnit : unitList){
if(aviFlyingClothingInspection.getUnit() !=null){
if(aviFlyingClothingInspection.getUnit().getId().equals(masUnit.getId())){ %>	
<option value="<%=aviFlyingClothingInspection.getUnit().getId()%>" selected="selected"><%=aviFlyingClothingInspection.getUnit().getUnitName()%></option>
<%}else{ %>	
<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
<%}}else{ %>	
<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

<%}
}%>
				
</select>

<label>Branch</label> 

<select	id="<%=TRADE_ID %>" name="<%=TRADE_ID %>"	validate="Branch,metachar,no" tabindex="1">


<%for(MasTrade masTrade : tradeList){
if(aviFlyingClothingInspection.getTrade() !=null){
if(aviFlyingClothingInspection.getTrade().getId().equals(masTrade.getId())){ %>	
<option value="<%=aviFlyingClothingInspection.getTrade().getId()%>" selected="selected"><%=aviFlyingClothingInspection.getTrade().getTradeName()%></option>
<%}else{%>
<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

<%}}else{ %>	
<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

<%}
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
		<TH scope="col">Date</TH>
		<TH scope="col">Remarks</TH>
	</tr>
	<tr>
		<td><label>MASK</label></td>
		<td>
<%if(aviFlyingClothingInspection.getMaskStatus().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="<%=MASK_STATUS %>" class="" checked="checked" />
<%}else{ %>
<input type="checkbox" name="<%=MASK_STATUS %>" class=""  />
<%} %>
</td><td>
<%if(aviFlyingClothingInspection.getMaskDate() !=null){ %>
<input type="text" id="<%=MASK_DATE %>" name="<%=MASK_DATE %>"	tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(aviFlyingClothingInspection.getMaskDate()) %>" readonly="readonly" maxlength="7" class="calDate"	 /> 
<%}else{ %>
<input type="text" id="<%=MASK_DATE %>" name="<%=MASK_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
 onClick="setdate('',document.flyingClothingInspection.<%=MASK_DATE%>,event)" /></td>
<td>
<%if(aviFlyingClothingInspection.getMaskRemarks()!=null){ %> 
<input type="text" maxlength="50" name="maskRemarks" tabindex="1" size="50" value="<%=aviFlyingClothingInspection.getMaskRemarks() %>"/>
<%}else{ %>
<input type="text" maxlength="50" name="maskRemarks" tabindex="1" size="50" value=""/>
<%} %>
	</td>
	
</tr>

	<tr>
	<td><label>HELMET</label></td>
<td>
<%if(aviFlyingClothingInspection.getHelmetStatus().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="<%=HELMET_STATUS %>" class="" checked="checked" />
<%}else{ %>
<input type="checkbox" name="<%=HELMET_STATUS %>" class=""  />
<%} %>
</td>
<td>
<%if(aviFlyingClothingInspection.getHelmetDate() !=null){ %>
<input type="text" id="<%=HELMET_DATE %>" name="<%=HELMET_DATE %>"	tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(aviFlyingClothingInspection.getHelmetDate()) %>" readonly="readonly" maxlength="7" class="calDate"	 /> 
<%}else{ %>
<input type="text" id="<%=HELMET_DATE %>" name="<%=HELMET_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
 onClick="setdate('',document.flyingClothingInspection.<%=HELMET_DATE%>,event)" /></td>
<td>
<%if(aviFlyingClothingInspection.getHelmetRemarks()!=null){ %> 
<input type="text" name="helmetRemarks" maxlength="50" tabindex="1" size="50" value="<%=aviFlyingClothingInspection.getHelmetRemarks() %>"/>
<%}else{ %>
<input type="text" name="helmetRemarks" maxlength="50" tabindex="1" size="50" value=""/>
<%} %>
	</td>
	
</tr>
	<tr>
	<td><label>ANTI G SUIT</label></td>
<td>
<%if(aviFlyingClothingInspection.getAntiGSuitStatus().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="<%=ANTI_G_SUIT_STATUS %>" class="" checked="checked" />
<%}else{ %>
<input type="checkbox" name="<%=ANTI_G_SUIT_STATUS %>" class=""  />
<%} %>
</td>
<td>
<%if(aviFlyingClothingInspection.getAntiGSuitDate() !=null){ %>
<input type="text" id="<%=ANTI_G_SUIT_DATE %>" name="<%=ANTI_G_SUIT_DATE %>"	tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(aviFlyingClothingInspection.getAntiGSuitDate()) %>" readonly="readonly" maxlength="7" class="calDate"	 /> 
<%}else{ %>
<input type="text" id="<%=ANTI_G_SUIT_DATE %>" name="<%=ANTI_G_SUIT_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
 onClick="setdate('',document.flyingClothingInspection.<%=ANTI_G_SUIT_DATE%>,event)" /></td>
<td>

<%if(aviFlyingClothingInspection.getAntiGSuitRemarks()!=null){ %> 
<input type="text" name="antiGSuitRemarks" maxlength="50" tabindex="1" size="50" value="<%=aviFlyingClothingInspection.getAntiGSuitRemarks() %>"/>
<%}else{ %>
<input type="text" name="antiGSuitRemarks" maxlength="50" tabindex="1" size="50" value=""/>
<%} %>
	</td>
	
</tr>
<tr>
<td><label>OTHERS</label></td>
<td>
<%if(aviFlyingClothingInspection.getOtherStatus().equalsIgnoreCase("y")){ %>
<input type="checkbox" name="<%=OTHERS_STATUS %>" class="" checked="checked" />
<%}else{ %>
<input type="checkbox" name="<%=OTHERS_STATUS %>" class=""  />
<%} %>
</td>
<td>
<%if(aviFlyingClothingInspection.getOtherDate() !=null){ %>
<input type="text" id="<%=OTHER_DATE %>" name="<%=OTHER_DATE %>"	tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(aviFlyingClothingInspection.getOtherDate()) %>" readonly="readonly" maxlength="7" class="calDate"	 /> 
<%}else{ %>
<input type="text" id="<%=OTHER_DATE %>" name="<%=OTHER_DATE %>"	tabindex="1" value="" readonly="readonly" maxlength="7" class="calDate"	 />
<%} %>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
 onClick="setdate('',document.flyingClothingInspection.<%=OTHER_DATE%>,event)" /></td>
<td>
<%if(aviFlyingClothingInspection.getOtherRemarks()!=null){ %> 
<input type="text" name="otherRemarks" tabindex="1" size="50"  value="<%=aviFlyingClothingInspection.getOtherRemarks() %>" maxlength="50"/>
<%}else{ %>
<input type="text" name="otherRemarks" tabindex="1" size="50" maxlength="50"/>
<%} %>
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

if(aviFlyingClothingInspection.getInspectedBy() !=null){
if(aviFlyingClothingInspection.getInspectedBy().getId().equals(masEmployee.getId() )){ %>
<option value="<%=aviFlyingClothingInspection.getInspectedBy().getId() %>" selected="selected">
<%=aviFlyingClothingInspection.getInspectedBy().getRank().getRankName()+" "+aviFlyingClothingInspection.getInspectedBy().getFirstName()+" "+aviFlyingClothingInspection.getInspectedBy().getLastName() %></option>
<%}else{ %>
<option value="<%=masEmployee.getId() %>">
<%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}}else 
		if(user.getEmployee().getId() == doctorId){
%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%}}}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%		} }%>
</select>
<input type="hidden" name="<%=COMMON_ID %>" tabindex="1" size="50" value="<%=aviFlyingClothingInspection.getId() %>"/>
</div>
</div>

	
<%}}else if(aviFlyingClothingInspectionList.size()==0 && patientList.size() > 0){
//for(Patient patient : patientList){
	Patient patient=patientList.get(0);
%>
<div class="clear paddingTop15"></div>
<h4>Patient Details</h4>
<div class="Block">
<input type="hidden" value="<%=patient.getId()%>" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<label>Date <span>*</span></label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date,date,yes" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=DATE%>,event)" />


<label> Rank </label> 
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
<option value="0">Select</option>

<%for(MasRank masRank : rankList){
if(patient.getRank().getId().equals(masRank.getId())){ %>	
<option value="<%=patient.getRank().getId()%>" selected="selected"><%=patient.getRank().getRankName()%></option>
<%}else{ %>	
<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>

<%}
}
	%>
</select>


<div class="clear"></div>


<label> First Name <span>*</span></label>
<%if(patient.getSFirstName()!=null){ %> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="<%=patient.getSFirstName() %>" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="15" />
<%}else{ %>
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="15" />
<%} %>
<label>Last Name</label> 
<%if(patient.getSLastName()!=null){ %> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="<%=patient.getSLastName() %>" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" />
<%}else{ %> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 
<%} %>
<label>Age <span>*</span></label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age,string,yes" tabindex="1" class="small">
<option value="">Select</option>
<% 
String ageYears="";
String age="";
if(patient.getAge()!=null){
	ageYears=patient.getAge();
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
<label class="unit">Years</label>
<input type="hidden" id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
</div>
<input type="hidden" id="idForSrAge" value=""/>
<div class="clear"></div>
<label>Gender<span>*</span></label>
<select name="<%=SEX_ID %>" id="srSexId" validate="Gender,metachar,yes" tabindex="1">
<%
	for(MasAdministrativeSex masAdministrativeSex : sexList){
		if(patient.getSex() !=null){
		if(patient.getSex().getId().equals(masAdministrativeSex.getId())){
	%>
	<option value="<%=masAdministrativeSex.getId() %>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%}else{ %>
		<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%}}else{ %>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%	}
		   	 	} %>
</select> 

<label>Unit</label> 
<select	id="<%=UNIT_ID %>" name="<%=UNIT_ID %>"	validate="Unit,metachar,no" tabindex="1">
<option value="0">Select</option>

<%for(MasUnit masUnit : unitList){
if(patient.getUnit().getId().equals(masUnit.getId())){ %>	
<option value="<%=patient.getUnit().getId()%>" selected="selected"><%=patient.getUnit().getUnitName()%></option>
<%}else{ %>	
<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>

<%}
}%>
				
</select>

<label>Branch</label> 


<select	id="<%=TRADE_ID %>" name="<%=TRADE_ID %>"	validate="Branch,metachar,no" tabindex="1">
<%for(MasTrade masTrade : tradeList){
if(patient.getTrade() !=null){
if(patient.getTrade().getId().equals(masTrade.getId())){ %>	
<option value="<%=patient.getTrade().getId()%>" selected="selected"><%=patient.getTrade().getTradeName()%></option>
<%}else{%>
<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

<%}}else{ %>	
<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>

<%}
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
<TH scope="col">Date</TH>
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=HELMET_DATE%>,event)" />
</td>
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=OTHER_DATE%>,event)" />
</td>
<td><input type="text" name="otherRemarks" tabindex="1" size="50" maxlength="50"/>
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
<%//}
}else{
%>
<div id="reg">
<div class="clear paddingTop15"></div>
<div class="Block">
<input type="hidden" value="0" name="hinId">
<input type="hidden" value="" name="avAccidentId">
<label>Date <span>*</span></label>  
<input type="text" id="<%=DATE %>" name="<%=DATE %>"	tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date of Birth,date,yes" MAXLENGTH="30" class="calDate"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=DATE%>,event)" />
<label> Rank</label> 
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
<option value="0">Select</option>
<%if(rankList!=null && rankList.size() >0){
for(MasRank masRank : rankList){

%>
<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
<%}
}%>
</select>
<div class="clear"></div>

<label> First Name <span>*</span></label> 
<input type="text"	id="pFirstNameId" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	title="First Name of the Patient"	validate="Patient First Name,name,yes" MAXLENGTH="15" />

<label>Last Name</label> 
<input type="text" id="pLastNameId" name="<%=P_LAST_NAME %>"	value="" validate="Patient Last Name,name,no" MAXLENGTH="15"	tabindex="1" /> 

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
<select name="<%=SEX_ID %>" id="srSexId" validate="Gender,metachar,yes" tabindex="1">
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
	<%for(MasUnit masUnit : unitList){%>

<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
<%		
}%>
</select>

<label>Branch</label> 
<select name="<%=TRADE_ID %>"  id="<%=TRADE_ID %>">
<option value="0">Select</option>
	<%for(MasTrade masTrade : tradeList){	%>

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
<TH scope="col">Date</TH>
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=HELMET_DATE%>,event)" />
</td>
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
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.flyingClothingInspection.<%=OTHER_DATE%>,event)" />
</td>
<td><input type="text" name="otherRemarks" tabindex="1" size="50" maxlength="50"/>
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
<div class="clear"></div>
</div>
<%}%>