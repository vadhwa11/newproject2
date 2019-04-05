<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="nominalRoll" action="" method="post"><script
	type="text/javascript" language="javascript">
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
Map<String, Object> detailsMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
String message="";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("detailsMap") !=null){
detailsMap=(Map<String, Object>)map.get("detailsMap");
}
if(map.get("message") !=null){
	message=(String)map.get("message");
}
List<MasRank> rankList = new ArrayList<MasRank>();
if(map.get("rankList") != null){
rankList = (List<MasRank>)map.get("rankList");
}
List<MasServiceType> serviceTypeList=  new ArrayList<MasServiceType>();
if(detailsMap.get("serviceTypeList") != null){
	serviceTypeList = (List<MasServiceType>)detailsMap.get("serviceTypeList");
	}
List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();

if(map.get("searchEmployeeList") != null){
	searchEmployeeList= (List<MasEmployee>)map.get("searchEmployeeList");
	}

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	departmentList = (List<MasDepartment>)map.get("departmentList");
	session.setAttribute("departmentList", departmentList);
}else if(session.getAttribute("departmentList") != null){
	departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
}
List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
if(map.get("empCategoryList") != null){
	empCategoryList = (List<MasEmpCategory>)map.get("empCategoryList");
	session.setAttribute("empCategoryList", empCategoryList);
}else if(session.getAttribute("empCategoryList") != null){
	empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
}
List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	session.setAttribute("unitList", unitList);
}else if(session.getAttribute("unitList") != null){
	unitList = (List<MasUnit>)session.getAttribute("unitList");
}
List<MasTrade> tradeList = new ArrayList<MasTrade>();
if(map.get("tradeList") != null){
	tradeList = (List<MasTrade>)map.get("tradeList");
	session.setAttribute("tradeList", tradeList);
}else if(session.getAttribute("tradeList") != null){
	tradeList = (List<MasTrade>)session.getAttribute("tradeList");
}
%>
<div id="contentHolder">
<h1 style="font-size: 15px; color: red;"><%=message %></h1>
<h6>Nominal Roll Reports </h6>
<div class="Clear"></div>
<div class="blockTitle">Filter</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Date Of Posting</label></label> 
<input type="text" name="date_of_posting" value="" MAXLENGTH="20" /> 
<label>Rank</label> 
<select id="rankId"
	name="<%=RANK_ID %>">
	<option value="0">Select</option>
	<%
					for(MasRank masRank : rankList){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}%>
</select>
<div class="Clear"></div>
<label>Trade</label> 
<select id="tradeId"
	name="<%=TRADE_ID %>">
	<option value="0">Select</option>
	<%
					for(MasTrade masTrade : tradeList){
				%>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%}%>
</select>
<label>Srevice Type Category</label> 
<select id="serviceTypeCategoryId"
	name="serviceTypeCategoryId">
	<option value="0">Select</option>
	<%
					for(MasServiceType masServiceTypeCategory : masServiceTypeCategoryList){
				%>
	<option value="<%=masServiceTypeCategory.getId() %>"><%=masServiceTypeCategory.getServiceTypeName() %></option>
	<%}%>
</select>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="search" id="search"
	onclick="submitForm('nominalRoll','/hms/hms/hrOrderly?method=showNominalRollReportForOfficer');"
	value="Search" class="cmnButton" accesskey="a" />

</div>
