<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
var SDate = document.poRegister.<%= FROM_DATE%>.value;
var EDate = document.poRegister.<%= TO_DATE %>.value;

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
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("supplierList") != null){
		supplierList =(List<MasStoreSupplier>) map.get("supplierList");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
<form name="poRegister" method="post" action="">

<div class="titleBg">
<h2>SO Register Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date </label>
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" validate="From Date,date,yes" MAXLENGTH="30" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
onClick="setdate('<%=currentDate%>',document.poRegister.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label>
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" validate="To Date,date,yes" MAXLENGTH="30" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.poRegister.<%=TO_DATE%>,event)" />
<div class="clear"></div> 
<!--
	<label>Vendor Name  </label> 
	<select name="<%= VENDOR_NAME%>" validate="Vendor Name,String,no">
	<option value="0">Select</option>
		<%
		for (MasStoreSupplier masStoreSupplier : supplierList) {
		%>
	<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName() %></option>
		<%
		}
		%>
	</select>
 -->
</div>
<div class="clear"></div>
<div class="division"></div> 
<div class="clear"></div>  
<input type="button" name="add" id="addbutton" value="Print" class="buttonBig" onClick="submitForm('poRegister','purchaseOrder?method=generatePORegisterReport','check()');"accesskey="a" tabindex=1 />
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button"
							onClick="clearButton('poRegister');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div> 
<div class="clear"></div>  
</form>
<script type="text/javascript" language="javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showPORegisterReportJsp";
  obj.submit();
  }
</script>