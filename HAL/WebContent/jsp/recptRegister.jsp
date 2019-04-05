
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showReceiptRegisterReportJsp";
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

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
<form name="receiptRegister" method="post" action="">
<div class="titleBg">
<h2>Receipt Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.receiptRegister.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.receiptRegister.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label ><span>*</span>  Source of
Supply</label> <select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
	validate="Source of Supply,String,yes">
	<option value="0">Select</option>
	<option value="p">PVMS by DGRC</option>
	<option value="a">AFMSD</option>
	<option value="l">Local Purchase</option>
	</select>
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('receiptRegister','stores?method=generateReceiptRegisterReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('receiptRegister','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />  
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('receiptRegister');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>







