
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function cancelButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showVendorTurnoverEnquiryReportJsp";
  obj.submit();
  }
</script>
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
var SDate = document.vendorTurnoverEnquiry.<%= FROM_DATE%>.value;
var EDate = document.vendorTurnoverEnquiry.<%= TO_DATE %>.value;


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
	List<MasStoreSupplier> searchMasStoreSupplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("searchMasStoreSupplierList")!=null)
		searchMasStoreSupplierList = (List) map.get("searchMasStoreSupplierList");


%>
<form name="vendorTurnoverEnquiry" method="post" action="">
<div class="titleBg">
<h2>Vendor Turnover Enquiry Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.vendorTurnoverEnquiry.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date  </label> 
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.vendorTurnoverEnquiry.<%=TO_DATE%>,event)" />


<div class="clear"></div>
<label><span>*</span> Supplier Name </label> 
<select name="<%=SUPPLIER_ID%>" validate="Supplier Name,String,yes">
<option value=0>Select</option>
	<%
				for (MasStoreSupplier masStoreSupplier :searchMasStoreSupplierList ) {
				
				%>
<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%>
</option>
	<%	
					}
				
					
				%>
</select> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('vendorTurnoverEnquiry','stores?method=generateVendorTurnoverEnquiryReport','check()');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="cancel" id="cancelbutton" value="Clear" class="button" onClick="cancelButton('vendorTurnoverEnquiry');" accesskey="a"
	tabindex=1 />
</center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>






