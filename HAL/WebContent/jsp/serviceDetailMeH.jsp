<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<div id="contentHolder">

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

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}


int cmdId=0;
if(map.get("cmdId") != null && !map.get("cmdId").equals("0")){
	cmdId=(Integer)map.get("cmdId");

	}
String command="";
if(map.get("command") != null && !map.get("command").equals("")){
	command=(String)map.get("command");

	}



int hospId=0;
if(map.get("hospId") != null && !map.get("hospId").equals("0")){
	hospId=(Integer)map.get("hospId");

	}
String hosp="";
if(map.get("hosp") != null && !map.get("hosp").equals("")){
	hosp=(String)map.get("hosp");

	}




String f="";
if(map.get("f") != null){
	f=(String)map.get("f");

	}
String t="";
if(map.get("t") != null){
	t=(String)map.get("t");

	}
%>


<%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

%>


<%
List<MasServiceType> serviceTypeList = null;
List<MasServiceStatus> serviceStatusList = null;
List<MasRankCategory> rankCategoryList = null;
List<MasTrade> tradeList = null;
List<MasAdministrativeSex> sexList = null;
List<Category> CategoryList = null;
List<MasRank> rankList = null;
List<MasHospital> hospitalList = new ArrayList<MasHospital>();

if(map.get("serviceTypeList")!=null){
	serviceTypeList = (List<MasServiceType>)map.get("serviceTypeList");
}

if(map.get("serviceStatusList")!=null){
	serviceStatusList = (List<MasServiceStatus>)map.get("serviceStatusList");
}

if(map.get("rankCategoryList")!=null){
	rankCategoryList = (List<MasRankCategory>)map.get("rankCategoryList");
}

if(map.get("tradeList")!=null){
	tradeList = (List<MasTrade>)map.get("tradeList");
}

if(map.get("sexList")!=null){
	sexList = (List<MasAdministrativeSex>)map.get("sexList");
}

if(map.get("hospitalList")!=null){
	hospitalList = (List<MasHospital>)map.get("hospitalList");
}


if(map.get("CategoryList")!=null){
	CategoryList = (List<Category>)map.get("CategoryList");
}

if(map.get("rankList")!=null){
	rankList = (List<MasRank>)map.get("rankList");
}


%>


<div class="Clear"></div>

<form name="malariaCase"  method="post" action="">
<div class="Block">


<label>From Date<span>*</span> </label> 
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=f %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currenDate %>',document.malariaCase.<%=FROM_DATE%>,event)" />


<label>To Date<span>*</span> </label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=t %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currenDate %>',document.malariaCase.<%=TO_DATE%>,event)" />

<div class="clear"></div>

<label>Service Type</label>
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	tabindex="1">
<option value="0">Select</option>
<% 	for (MasServiceType masServiceType : serviceTypeList){%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
<%}%>
</select>

<label>Service Status</label>
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"	tabindex="1">
<option value="0">Select</option>
<% 	for (MasServiceStatus masServiceStatus : serviceStatusList){%>
	<option value="<%=masServiceStatus.getId()%>"><%=masServiceStatus.getServiceStatusName()%></option>
<%}%>
</select>

<div class="clear"></div>

<label>Rank Category</label>
	<select	id="rankCatId" name="<%=RANK_CATEGORY_ID%>" tabindex="1">
<option value="0">Select</option>
<% for (MasRankCategory masRankCat : rankCategoryList){%>
	<option value="<%=masRankCat.getId()%>"><%=masRankCat.getRankCategoryName()%></option>
<% }%>
</select>

<label>Trade/ Branch</label>
 <select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
</select>


<div class="clear"></div>

<label>Command</label>

<select name="cmdId"  id="cmdId">
<option value="<%=cmdId%>" selected="selected"><%=command %></option>
</select>

<label>SMC</label>
<select name="hospitalId">
	<option value=<%=hospId%>><%=hosp %></option>
</select>

<div class="clear"></div>




 <label>Category(% or LMC)</label> 
 <select id="disabilityid"
	name="CategoryId" tabindex="1" validate="Unit,string,no">
	
	<option value="">Select</option>
	<%
			if(CategoryList != null &&    CategoryList.size() > 0 ){
				for(Category Category : CategoryList){
		%>
	<option value="<%=Category.getCategories() %>"><%=Category.getCategories() %></option>
	<%
				}
				} %>
</select>



<label>Service No.</label>
<input type="text" size="13"  name="<%=SERVICE_NO %>" />
<div class="clear"></div>

<label>Gender</label>
<select name="<%=GENDER %>" size="0" tabindex="1" id="GenderId">
<option value="0">Select</option>
	<%for(MasAdministrativeSex masAdministrativeSex :sexList){ %>
	<option value=<%=masAdministrativeSex.getId()%>><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%} %>
</select>
<div class="clear"></div>
<label>Rank </label>
<label  class="auto">From </label>
 <select id="searchField2" name="fromrankId" id ="fromrankId" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
	%>
</select>
<label class="auto">To </label> 
	<select	id="torankId" name="toRankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
<div class="clear"></div>




</div>


<div class="Clear"></div>
 
<input type="button" name="OK" value="Ok" class="button" onClick="submitForm('malariaCase','medicalExam?method=showMeStaticsReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
</form>

</div> 