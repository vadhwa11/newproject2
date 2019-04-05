<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasVendor"%>
<%@page import="jkt.hms.masters.business.MlSupplyorderDetail"%>
<%@page import="jkt.hms.masters.business.MlSupplyorderHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="smqSearch" action="" method="post"><script
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
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

ArrayList<MasVendor> vendorList = (ArrayList<MasVendor>)map.get("vendorList");
Map<String, Object> patientMap = new HashMap<String, Object>();
List<MlSupplyorderHeader> searchSupplyOrderHeaderListbyEntryNo = new ArrayList<MlSupplyorderHeader>();



if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}


if (patientMap.get("searchSupplyOrderList") != null) {
	searchSupplyOrderHeaderListbyEntryNo = (List)patientMap.get("searchSupplyOrderList");

}
%>
<h6>Supply Order Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Supply Order No</label> <input type="text"
	name="<%=SUPPLY_ORDER_NO %>" value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyOrderEntry');" />
<label class="common">Vendor Name</label> 
<select	name="<%=VENDOR_ID %>" id="<%=VENDOR_ID %>" tabindex=1 validate="Vendor Name,string,no" onkeypress="return submitenter(this,event,'lib?method=searchSupplyOrderEntry');"  />
	<option value="0">Select</option>
	<% 
    			for (MasVendor  masVendor : vendorList){
    		%>
	<option value="<%=masVendor.getId ()%>"><%=masVendor.getVendorName()%></option>

	<%}%>
</select> <label>Quotation No</label></label> <input type="text"
	name="<%=QUOTATION_NO %>" value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyOrderEntry');" />
<div class="Clear"></div>
<label>Book Name</label> <input type="text" name="<%=BOOK_NAME %>"
	value="" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyOrderEntry');" />

<label>Acc No</label> <input type="text" name="<%=BOOK_ACC_NO %>"
	value="" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyOrderEntry');" />


<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('smqSearch','/hms/hms/lib?method=searchSupplyOrderEntry');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="supplyOrder" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "supplyId", "id"],[1,"<%=SUPPLY_ORDER_NO%>"],[2,"<%=DATE%>"],[3,"<%=VENDOR_ID%>"],[4,"<%=QUOTATION_NO%>"]];
statusTd = 4;
</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Supply Order No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "<%=SUPPLY_ORDER_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=DATE%>";

data_header[2] = new Array;
data_header[2][0] = "Vendor"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=VENDOR_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Quotation"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=QUOTATION_NO%>";



data_arr = new Array();
<%
int  counter=0;%>

<% 

System.out.println("Size ----------"+searchSupplyOrderHeaderListbyEntryNo.size());
	for(MlSupplyorderHeader miSupplyorderHeader : searchSupplyOrderHeaderListbyEntryNo){
		if(miSupplyorderHeader.getSupplyOrderNo() != null 
				&& miSupplyorderHeader.getStatus().equalsIgnoreCase("y")){ 
			MlSupplyorderDetail libDt = miSupplyorderHeader.getMlSupplyorderDetails().iterator().next();
			
 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=libDt.getSupplyHeader().getId()%>"
data_arr[<%= counter%>][1] = "<%=libDt.getSupplyHeader().getSupplyOrderNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(libDt.getSupplyHeader().getDate())%>"
<%if(libDt.getSupplyHeader().getVendor() != null){%>
data_arr[<%= counter%>][3] = "<%=libDt.getSupplyHeader().getVendor().getVendorName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
<%if(libDt.getSupplyHeader() != null){%>
data_arr[<%= counter%>][4] = "<%=libDt.getSupplyHeader().getQuotationNo()%>"
<%}else{%>
data_arr[<%= counter%>][4] ="-"
<%}%>

<%
counter++;
}
}

%>

formName = "supplyOrder"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script></div>