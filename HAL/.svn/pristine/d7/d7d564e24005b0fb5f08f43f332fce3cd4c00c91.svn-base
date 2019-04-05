
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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


<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	//String currentDate = (String)utilMap.get("currentDate"); 
	
	Date currentDate = new Date();
	
	Calendar cal1 = Calendar.getInstance();
	cal1.setTime(currentDate);
	cal1.add(Calendar.MONTH ,  +3 );
	Date nextDate = cal1.getTime();
%>
<form name="drugForm" method="post" action="">
<div class="titleBg">
<h2>Drug Expiry Report</h2>
</div>
<div class="Block">
<label> As on Date<span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=HMSUtil.convertDateToStringWithoutTime(nextDate) %>" class="textbox_date" MAXLENGTH="30" validate="Pick a Expiry Date,date,yes" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.drugForm.<%=FROM_DATE%>,event)" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('drugForm','purchaseOrder?method=generateDrugExpiryReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('drugForm','purchaseOrder?method=generateDrugExpiryReport&flag=p');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>






