<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%--For AutoComplete Through Ajax--%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>



<script>
<%

 Calendar calendar=Calendar.getInstance();
 String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
 String date=String.valueOf(calendar.get(Calendar.DATE));
 int year1=calendar.get(calendar.YEAR);
 if(month1.length()<2){
  month1="0"+month1;
 }
 if(date.length()<2){
  date="0"+date;
 }
 Map<String, Object> map = new HashMap<String, Object>();
 Map<String, Object> utilMap = new HashMap<String, Object>();
 List<MasHospital> hospitalList = new ArrayList<MasHospital>();
 utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
 String currentDate = (String)utilMap.get("currentDate");  
 String currentTime = (String)utilMap.get("currentTime");
 if(request.getAttribute("map") != null){
  map = (Map<String, Object>)request.getAttribute("map");
 }
 
 if(map.get("hospitalList")!=null){
	hospitalList = (List)map.get("hospitalList") ;
 }
 
 int locationId = 0;
	if (session.getAttribute("locationId") != null) {
		locationId =  (Integer)session.getAttribute("locationId");
	}
 String UnitType= "";
	if(session.getAttribute("unitType") != null) {
		UnitType =  (String)session.getAttribute("unitType");
	}
%>
 </script>

<form name="emdRegRpt" method="post" action="">
<h4 id='divResult' class='success'></h4>
<div class="titleBg">
<h2>BG/Emd Register</h2>
</div>
<div class="Block">
<label> From Date <span >*</span></label>
<input type="text"  name="<%=FROM_DATE %>" id="<%=FROM_DATE %>" tabindex="1" value="" class="calDate" size="7" validate="From Date From,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'<%=FROM_DATE %>');" />

<label>To Date <span>*</span></label>
<input type="text"  name="<%=TO_DATE %>" id="<%=TO_DATE %>" tabindex="1" value="" class="calDate" size="7" validate="To Date From,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'<%=TO_DATE %>');" />

<label>Type<span>*</span></label>
<select name="voucherType" id="voucherType" validate="Type,string,yes">
<option value="">Select</option>
<option value="BG">BG</option>
<option value="EMD">EMD</option>
<option value="SD">SD</option>
</select>
<div class="clear"></div>

<%  if(UnitType.equalsIgnoreCase("HO"))
	{
		%>
<label>Centre</label> 
<select name="locationId"  id="locationId" validate=" Centre ,String,no"  tabindex=1>
	<option value="0">All</option>
	<%
	for (MasHospital h : hospitalList) {
	%>
	<option value="<%=h.getId()%>"><%=h.getHospitalName() %></option>
	<%
	}
	}else{
		%><input type="hidden" name="locationId" id="locationId" value="<%=locationId %>" />
	<%}
%>
</select>
	
<div class="clear"></div>

<%-- <input type="hidden" name="reportName" value="<%=PRINT_REQUISITION_TO_STORE %>"> --%>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('emdRegRpt','account?method=generateEmdRegRpt');" /></div>
</form>

