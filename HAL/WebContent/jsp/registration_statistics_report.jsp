<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasDisposal"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript"	language="javascript">

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
	</script> <%
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasServiceType> serviceTypeList =null;
			List<MasServiceStatus> serviceStatusList =null;
			List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			List<MasTrade> tradeList = null;
			List<Object[]> unitList = null;
			List<MasSection> sectionList = null;
			List<MasAdministrativeSex> sexList = null;
			List<MasMaritalStatus> maritalStatusList = null;
			List<MasEmployee> doctorList = null;
			List<MasDisposal> disposalList = null;
			
			if(map.get("rankList")!=null){
				rankList = (List<MasRank>)map.get("rankList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
			}
			if(map.get("serviceStatusList") != null){
				serviceStatusList= (List<MasServiceStatus>)map.get("serviceStatusList");
			}
			if(map.get("rankCategoryList")!=null){
				rankCategoryList = (List<MasRankCategory>)map.get("rankCategoryList");
			}
			if(map.get("tradeList") != null){
				tradeList = (List<MasTrade>)map.get("tradeList");
			}
			if(map.get("unitList") != null){
				unitList= (List<Object[]>)map.get("unitList");
			}
			if(map.get("sectionList") != null){
				sectionList = (List<MasSection>)map.get("sectionList");
			}
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			if(map.get("maritalStatusList") != null){
				maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
			}
			if(map.get("employeeList") != null){
				doctorList = (List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("disposalList") != null){
				disposalList = (List<MasDisposal>)map.get("disposalList");
			}
	%>

<div class="titleBg">
<h2>Registration Statistics</h2>
</div>
<div class="Clear"></div>
<form name="registrationRegister" method="post" action="">
<div class="Block">
<label>Date:</label>

<label class="medium"> From <span>*</span> </label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>" c
	value="<%=currenDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate %>',document.registrationRegister.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.registrationRegister.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<label>Rank:</label>
<label class="medium">From </label> 
	<select	id="fromrankId" name="fromRankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
	
	<label>To </label> 
	<select	id="torankId" name="toRankId"tabindex="1">
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
<label>Age:</label>
<label class="medium"> From </label>

<select id="fromageId"	name="fromAge" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toageId"	name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>
<label>Total Service:</label>
<label class="medium"> From </label>

<select id="fromServId"	name="fromServ" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromServUnitId" name="fromServUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toServId"	name="toServ"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toServUnitId" name="toServUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>	
<label>Service Type </label> 
<input type="text" class="transparent" size="14">
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceType masServiceType : serviceTypeList){
		%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%
				}%>
</select>

<label>Service Status </label> 
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
		%>
	<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>
	<%
				}%>
</select>


<div class="Clear"></div>
<label>Rank Category</label> 
<input type="text" class="transparent" size="14">
	<select	id="rankCatId" name="<%=RANK_CATEGORY_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRankCategory masRankCat : rankCategoryList) 
				{
			 		%>
	<option value="<%=masRankCat.getId()%>"><%=masRankCat.getRankCategoryName()%></option>
	<%
			 		}%>
</select> 

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<div class="Clear"></div>
<label>Unit </label> 
<input type="text" class="transparent" size="14">
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select>
<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>

</select>
<div class="Clear"></div>
<label> Service No.</label>
<input type="text" class="transparent" size="14">
<input type="text" name="<%=SERVICE_NO %>" value=""MAXLENGTH="30" />
<label>Gender </label>
<select name="<%=SEX_ID %>" id="srSexId" validate="" tabindex="1">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
				
		   	 	} %>
</select> 

<div class="Clear"></div>

<label> Marital Status</label>
<input type="text" class="transparent" size="14">
<select name="<%=MARITAL_STATUS_ID %>"	id="mrstatus"  tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> 
<label>Medical Officer</label> 
<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	tabindex="1">
	<option value="0">Select</option>
	<%

for(MasEmployee masEmployee : doctorList){
	
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				
} %>
</select> 
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('registrationRegister','registration?method=showRegistrationStatisticsOnScreen');" />
<input type="reset" name="Reset" value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<input type="button" name="print" value="Print" class="button" onClick="submitForm('registrationRegister','registration?method=printRegistrationRegisterReport');" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />

</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<script>
function openGraph(){
	var url = "registration?method=showRegistrationStatisticsGraph&"+getNameAndData('registrationRegister');
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>



