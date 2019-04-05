<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<%@page import="java.util.Calendar"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<link href="css/style.css" rel="stylesheet" type="text/css" />

<form name="loanInItemsReport" method="post">
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<div class="titleBg">
<h2>Loan In Report</h2>
</div>
<div class="clear"></div>
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
List<MasStoreSupplier> vendorList = new ArrayList<MasStoreSupplier>();

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("vendorList")!= null){
	vendorList = (List<MasStoreSupplier>)map.get("vendorList");
}
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
%>
<div class="Block">

<label>From Date </label>
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>" class="date" validate="From Date,dateOfAdmission,no"  MAXLENGTH="30" />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
onClick="setdate('<%=currentDate%>',document.loanInItemsReport.<%=FROM_DATE%>,event)" />

<label>To Date </label>
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate%>" class="date" validate="To Date,dateOfAdmission,no"  MAXLENGTH="30" />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
onClick="setdate('<%=currentDate%>',document.loanInItemsReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label> Vendor Name  </label>
<select id="vendorId" name="<%=VENDOR_ID%>">
<option value="0">Select</option>
	<%
		for (MasStoreSupplier supplier :vendorList ) {
	%>
	<option value=<%=supplier.getId()%>><%=supplier.getSupplierName()%></option>
	<%
		}
	%>
</select>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Button2" type="button" class="button" value="Print" onclick="submitForm('loanInItemsReport','/hms/hms/stores?method=printLoanInItemsReports')"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>