
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>


<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript"	language="javascript">
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
</script> <script type="text/javascript">
function check()
	{
		var r = document.getElementById('mainChargeCodeId').value;
		if(r=="0")
		{
			alert("Please select Main Group")
			return false;
		}
		else
		{
			return true;
		}
	}

</script> 
<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		
		if(map.get("unitList")!= null){
			unitList = (List<Object[]>)map.get("unitList");
		}
		
		List<MasAdministrativeSex> sexList = null;
		if(map.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)map.get("sexList");
		}
		
		List<MasRank> rankList = new ArrayList<MasRank>();	
		if(map.get("rankList")!=null){
			rankList = (List<MasRank>)map.get("rankList");
		}
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		if(map.get("relationList")!=null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
	%>
<div class="titleBg">
<h2>Blood Donor Panel</h2>
</div>
<form name="bloodDonorPanel" target="_blank" action=""
	method="post">
<div class="Block">

<label>Blood Group <span>*</span></label> 
<select name="<%=BLOOD_GROUP_ID %>"	id="bldGrp" validate="Blood Group,string,yes" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
</select>


<label>Unit <span>*</span></label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,yes" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	<option value="other">Other</option>
</select>

<div class="Clear"></div>



<label>Gender </label>
<select name="<%=SEX_ID %>" id="<%=SEX_ID %>"  validate="" tabindex="1">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
				
		   	 	} %>
</select> 


<label>Rank</label>
<select	id="<%=RANK_ID %>" 	name="<%=RANK_ID %>"  tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 

<div class="Clear"></div>

<label>Age</label>
<label class="auto"> From&nbsp </label>

<select id="fromageId"	name="fromAge" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="smallest">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label class="auto"> To&nbsp </label>

<select id="toageId"	name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="smallest">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<div class="Clear"></div>
<label class="auto">Personnel</label>
<input type="radio" name="relationType" id="relationType" class="radioAuto" value="self" checked="checked" onclick="displayHideRelation(this.value);">
<label class="auto">Family</label>
<input type="radio" name="relationType" id="relationType" class="radioAuto" value="family" onclick="displayHideRelation(this.value);">
<div id="rel" style="display: none;">
<label>  Relation</label> 
<select	name="<%=RELATION_ID %>" validate="Relation,String,no"	id="relId">
	<option value="0">Select</option>

	<% 
	for (MasRelation relation : relationList){
	%>
	<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
	<% 				
	}%>
</select>
</div>
</div>

<input type="button" name="OK" value="OK"
	class="button" onClick="submitForm('bloodDonorPanel','/hms/hms/lab?method=generateBloodDonorPanelReport')" />
</form>
<script>
function displayHideRelation(val){
if(val=='self')
	document.getElementById('rel').style.display='none';
else
	document.getElementById('rel').style.display='block';
	
}
</script>