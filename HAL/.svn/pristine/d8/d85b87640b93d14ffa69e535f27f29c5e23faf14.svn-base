
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

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

<script type="text/javascript">
function check(){
var SDate = document.mon_AncVisitCH.<%= FROM_DATE%>.value;
var EDate = document.mon_AncVisitCH.<%= TO_DATE %>.value;
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int cmdId=0;
	if(map.get("cmdId") != null && !map.get("cmdId").equals("0")){
		cmdId=(Integer)map.get("cmdId");

		}
	String command="";
	if(map.get("command")!= null && !map.get("command").equals("")){
		command=(String)map.get("command");

		}
	else{
		command=(String)map.get("commandName");
			
	}

	int hospitalId=0;
	if(map.get("hospitalId") != null && !map.get("hospitalId").equals("0")){
		hospitalId=(Integer)map.get("hospitalId");

		}
	String hospital="";
	if(map.get("hospital") != null && !map.get("hospital").equals("")){
		hospital=(String)map.get("hospital");

	}
	else{
		hospital=(String)map.get("hospitalName");
			
	}
	String f="";
	if(map.get("f") != null){
		f=(String)map.get("f");

		}
	String t="";
	if(map.get("t") != null){
		t=(String)map.get("t");

		}
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	if(map.get("hospitalList") != null){
		hospitalList= (List<MasHospital>)map.get("hospitalList");
	}
	
	List<MasServiceType> serviceTypeList = null;
	List<MasServiceStatus> serviceStatusList = null;
	List<MasRankCategory> rankCategoryList = null;
	List<MasTrade> tradeList = null;
	List<MasAdministrativeSex> sexList = null;

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




%>
<form name="mon_AncVisitCH" method="post" action="" >

<div class="titleBg">
<h2>ANC Visit</h2>
</div>
<div class="Block">

<label>From Date <span>*</span>  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=f %>" class="auto" size="20" MAXLENGTH="30" validate="From date,date,yes" readonly="readonly" id="fromDate"/>
<a	href="javascript:setdate('<%=f%>',document.mon_AncVisitCH.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a>
 
<label > To Date <span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=t %>" class="auto" size="20" MAXLENGTH="30"	validate="To date,date,yes" readonly="readonly" id="toDate" /> 
<a href="javascript:setdate('<%=t%>',document.mon_AncVisitCH.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> </a> 

<div class="clear"></div>

<label>Service Type</label>

<select id="serviceTypeId" tabindex="1" name="serviceTypeId">
<option value="0">Select</option>
<% 	for (MasServiceType masServiceType : serviceTypeList){%>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
<%}%>
</select>

<label>Service Status</label>
<select id="serviceStatusId" tabindex="1" name="serviceStatusId">
<option value="0">Select</option>
<% 	for (MasServiceStatus masServiceStatus : serviceStatusList){%>
	<option value="<%=masServiceStatus.getId()%>"><%=masServiceStatus.getServiceStatusName()%></option>
<%}%>
</select>


<div class="clear"></div>

<label>Rank Category</label>

<select id="rankCatId" tabindex="1" name="rankCategoryId">
<option value="0">Select</option>
<% for (MasRankCategory masRankCat : rankCategoryList){%>
	<option value="<%=masRankCat.getId()%>"><%=masRankCat.getRankCategoryName()%></option>
<% }%>
</select>

<label>Trade/ Branch</label>
<select id="tradeId" tabindex="1" validate="Trade,string,no" name="tradeId">
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
<select name="hospitalId" id="hospitalId">
<option value="0">Select</option>
	<option value="<%=hospitalId %>" selected="selected" ><%=hospital %></option>

</select>

<div class="clear"></div>

<label>Service No.</label>

<input type="text" size="13" validate="Service No,metachar,no" maxlength="30" value="" name="serviceNo" />

<label>Gender</label>
<select id="srSexId" tabindex="1" validate="" name="sexId">
<option value="0">Select</option>
	<%for(MasAdministrativeSex masAdministrativeSex :sexList){ %>
	<option value=<%=masAdministrativeSex.getId()%>><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%} %>
</select>





<div class="Clear"></div>
</div>


<div class="Clear"></div>
 
<input type="button" name="OK" value="Ok" class="button" onClick="submitForm('mon_AncVisitCH','/hms/hms/registration?method=showOPDRegisterFwcReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
</form>



