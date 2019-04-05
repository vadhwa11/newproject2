<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
		
	
	</script>
	<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
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
	List<MasTherapyType> therapyList = null;
	
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
	if(map.get("therapyList") != null){
		therapyList = (List<MasTherapyType>)map.get("therapyList");
	}
	
	%>

<form name="phyTreatmentRegister" target="_blank" method="post" action="">
<div class="titleBg"><h2>Physiotherapy Statistics</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label>Date:</label>
<label class="medium">From </label> 

<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="date" readonly="readonly"MAXLENGTH="30"  validate="Date,frdate,yes"
	onClick="setdate('<%=currentDate%>',document.phyTreatmentRegister.<%=FROM_DATE%>,event)" /> 
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.phyTreatmentRegister.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"	readonly="readonly" MAXLENGTH="30"  validate="Date,frdate,yes"
 validate="Pick a date" 	onClick="setdate('<%=currentDate%>',document.phyTreatmentRegister.<%=TO_DATE%>,event)" /> 
	  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.phyTreatmentRegister.<%=TO_DATE%>,event)" />
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

<select id="fromageUnitId" name="fromAgeUnit" tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toageId" name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
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
	<option value="Years">Years</option>
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
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>	
<label>Service Type </label> 
<label class="medium">&nbsp;</label>
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
<label class="medium">&nbsp;</label>
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
<label class="medium">&nbsp;</label>
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
<label class="medium">&nbsp;</label>
<input type="text" name="<%=SERVICE_NO %>" value=""MAXLENGTH="30" validate="Service No.,metachar,no"/>
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
<label class="medium">&nbsp;</label>
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
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				
} %>
</select> 
<div class="Clear"></div>
<div class="Clear"></div>

<label>Therapy Name</label>
<input type="text" class="transparent" size="13">
<select name="therapyId">
<option value="">Select</option>
<%
	if(therapyList.size() > 0){
		for(MasTherapyType masTherapyType: therapyList){
%>
<option value="<%=masTherapyType.getId() %>"><%=masTherapyType.getTherapyTypeName() %></option>
<%} 
}%>
</select>
<!--<label>ICD No.</label>
<input type="text" name="icdNo" value="" id="icdNo">
<div class="Clear"></div>
<label>ICD Diagnosis</label>
<input type="text" class="transparent" size="13">
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="60" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
--><div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="if(datevalidation()){submitForm('phyTreatmentRegister','/hms/hms/physiotherapy?method=printPhyTreatmentRegisterReport');}" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />
<div class="Clear"></div>
<script>
function openGraph(){
	var url = "physiotherapy?method=showPhysioTherapyTreatmentRegiterGraph&"+getNameAndData('phyTreatmentRegister');
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>
</form>
