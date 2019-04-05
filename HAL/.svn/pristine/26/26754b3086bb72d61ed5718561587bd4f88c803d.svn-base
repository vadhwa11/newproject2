<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.AvAuthorisedItem"%>

<%@page import="jkt.hms.masters.business.Users"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
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
	String userName="";
	if(session.getAttribute("userName")!=null)
 	userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<AvAuthorisedItem> authorisedList = new ArrayList<AvAuthorisedItem>();
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("aircraftList") != null)	{
		aircraftList = (List<MasAircraftType>)map.get("aircraftList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("authorisedList") != null)	{
		authorisedList = (List<AvAuthorisedItem>)map.get("authorisedList");
	}
%>
<form name="aircrewRation" method="post" action="">
<div class="titleBg">
<h2>Aircrew Ration</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input type="text" name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" class="auto" size="8" type="text"
onblur="submitProtoAjaxWithDivName('aircrewRation','/hms/hms/aviationMedicine?method=getSerNoDetailForRation&serviceNo='+this.value,'patientDiv');"/>
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" />

<div id="patientDiv">
<input type="hidden" value="" name="hinId">
<input type="hidden" value="" name="avAccidentId">

<input class="transparent" size="8" />

<label>Date</label>
<input type="text" name=<%=DATE %> value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="Appointment Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.aircrewRation.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" name="time" value="<%=time %>" />

<div class="clear"></div>
<label>Rank</label>
<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>

<label>Name<span>*</span></label>
<input type="text" name="fullName" />

<label>Age</label>
<div id="srAgeDiv" style="display: block;">
<select id="srAgeId" name="<%=SR_AGE%>" validate="Age,string,yes"	tabindex="1" class="small">
	<option value="">Select</option>
	<%	for(int age1 = 16;age1<=100;age1++){%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="ageUnit" name="<%=SR_AGE_UNIT %>" value="Years" readonly="readonly"/>
</div>
<%--<input class="transparent" size="8" />
<input type="text" readonly="readonly" value="Years" name="srAgeUnit" id="srAgeUnitId" class="readOnlySmall">--%> 

<div class="clear"></div>

<label>Gender</label>
<select name="<%=SEX_ID %>" id="sexId" validate="Gender,metachar,no" tabindex="1">
	<%
		 for(MasAdministrativeSex masAdministrativeSex : sexList){	%>
	<option value="<%=masAdministrativeSex.getId()%>" selected="selected"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
	<%	 	} %>
</select> 

<label>Unit</label>
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%
		for(MasUnit masUnit : unitList){	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>

</div></div>

<table class="cnmtable">
<tr>

<th>Item</th>
<th>Qty Authorized</th>
<th>Qty Supplied</th>
</tr>
<% 
System.out.println("authorisedList--->"+authorisedList.size());
if(authorisedList.size() >0){
	for(AvAuthorisedItem authorisedItem:authorisedList){ 	%>
<tr>
<td>
<input type="text" value="<%=authorisedItem.getItemName() %>" name="authItemName" id="authItemName" size="15" class="auto"/>
<input type="hidden" value="<%=authorisedItem.getId()%>" name="authItemId" id="authItemId"/></td>
<td>
<input type="text" value="<%=authorisedItem.getAuthorisedQty() %>" name="authItemQty" id="authItemQty"/></td>
<td>
<input type="text" value="" name="suppliedItemQty" id="suppliedItemQty" /></td>
</tr>
<%} } %>

</table>

<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="button" class="button" name="Submit11" value="SUBMIT" 
onclick="submitForm('aircrewRation','/hms/hms/aviationMedicine?method=submitAircrewRation&flag=ration');" />
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
</form>
