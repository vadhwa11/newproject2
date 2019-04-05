
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
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
var SDate = document.caForm34A.<%= FROM_DATE%>.value;
var EDate = document.caForm34A.<%= TO_DATE %>.value;


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
	//List<MasCaLicence> caLicenceList=null;

	//if(map.get("caLicenceList") != null){
	//	caLicenceList = (List<MasCaLicence>)map.get("caLicenceList");
	//}
	
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
%>
<form name="caForm34A" method="post" action=""><br />

<div class="titleBg"><h2>CA Form 34A (Revised)</h2>
</div>
<div class="Block">
<label> From Date <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30" validate="From Date,frdate,yes" readonly="readonly" />
<a	href="javascript:setdate('<%=currentDate%>',document.caForm34A.<%=FROM_DATE%>,true)">

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a> 

<label> To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"	validate="To Date,frdate,yes" readonly="readonly" /> 
<a	href="javascript:setdate('<%=currentDate%>',document.caForm34A.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a> <br>


<div class="clear"></div>
<label>Licence	No.</label>
<input name="<%=LICENCE_NO %>" type="text" tabindex="1" maxlength="15" validate="Licence No,metachar,no"/>

<label>First Name</label>
<input name="<%=FIRST_NAME %>" type="text" tabindex="1" maxlength="30" validate="First Name,metachar,no" />

<label>Last Name</label>
<input name="<%=LAST_AME %>" type="text" tabindex="1" maxlength="30"  validate="Last Name,metachar,no"/>


</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button"	onClick="submitForm('caForm34A','aviationMedicine?method=generateCAForm34AReport','check()');"	accesskey="a" tabindex=1 /> 
<input type="reset" name="reset" id="clearbutton" value="Cancel" class="button"	onClick="resetCheck();" accesskey="a" tabindex=1 /></center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>






