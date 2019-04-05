<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
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
</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
	%>

<h6> Identification For Service Personnel </h6>
<form name="indentServicePersonnel" target="_blank" action="" method="post">
<div class="blockFrame">
<label>From Date</label> 
	<input 	type="text" class="calDate" id="fromDate" name="<%=FROM_DATE %>" value="" validate="From Date,date,no" MAXLENGTH="10" tabindex="1" readonly="readonly"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.indentServicePersonnel.<%=FROM_DATE%>,event)" />
	
	 <label>To Date</label>
	 <input type="text" class="calDate" id="toDate" name="<%=TO_DATE %>" value="" validate="To Date,date,no" MAXLENGTH="10" tabindex="1" readonly="readonly"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.indentServicePersonnel.<%=TO_DATE%>,event)" />

	<label> Service No</label>
	<input type="text" id="serviceNo" name="serviceNo" value=""/>

</div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK" class="button"
	onClick="if(testFromToDate())if(checkBlankSearch())submitForm('indentServicePersonnel','/hms/hms/mediClaim?method=printIdentificationServiceReport','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>

<script type="text/javascript">
	function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.indentServicePersonnel.fromDate)
	obj2 = eval(document.indentServicePersonnel.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}
			
		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}
	
	}
	return true;
}
    </script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("fromDate").value;
	errorMsg=errorMsg+document.getElementById("toDate").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}

  function testFromToDate(){

	if(document.getElementById("fromDate").value !=""){
	if(document.getElementById("toDate").value=="")
	{
	alert("Please select To Date");
	return false;
	}
	}
	return true;
}
    </script>