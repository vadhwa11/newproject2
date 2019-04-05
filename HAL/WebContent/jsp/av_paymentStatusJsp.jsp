
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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
var SDate = document.paymentStatus.<%= FROM_DATE%>.value;
var EDate = document.paymentStatus.<%= TO_DATE %>.value;


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
	List<MasBankMaster> bankList=null;

	if(map.get("bankList") != null){
		bankList = (List<MasBankMaster>)map.get("bankList");
	}
	

%>
<form name="paymentStatus" method="post" >

<div class="titleBg"><h2>Payment Status</h2>
</div>
<div class="Block">
<label> From Date <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30" validate="From date,frdate,yes" readonly="readonly" />
<a	href="javascript:setdate('<%=currentDate%>',document.paymentStatus.<%=FROM_DATE%>,true)">

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	 class="calender" /> </a> 

<label> To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"	validate="To date,frdate,yes" readonly="readonly" /> 
<a	href="javascript:setdate('<%=currentDate%>',document.paymentStatus.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender" /> </a> <br>


<div class="clear"></div>

<label>Bank Name</label>
<select	name="<%=BANK_ID%>" validate="Bank,metachar,no"	id="<%=BANK_ID%>" validate="Bank Name,metachar,no">
<option value="0">Select</option>
	<%
		for(MasBankMaster masBank : bankList){
	%>
	<option value="<%=masBank.getId()%>"><%=masBank.getBankName() %></option>
	<%		
		}%>
</select> 

<label>Licence No.</label>
<input name="<%=LICENCE_NO %>" type="text" tabindex="1" maxlength="10"  validate="Licence No,metachar,no"/>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button"	onClick="submitForm('paymentStatus','aviationMedicine?method=generatePaymentStatusReport','check()');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="reset" id="reset" value="Cancel" class="button"
	onClick="resetCheck();" accesskey="a" tabindex=1 /></center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>






