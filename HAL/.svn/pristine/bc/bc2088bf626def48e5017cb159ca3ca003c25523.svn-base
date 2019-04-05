
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.MasCaLicence"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/aviationMedicine?method=showCaForm35ReportJsp";
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
var SDate = document.caForm35.<%= FROM_DATE%>.value;
var EDate = document.caForm35.<%= TO_DATE %>.value;


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
	

	List<MasCaLicence> caLicenceList=null;

	if(map.get("caLicenceList") != null){
		caLicenceList = (List<MasCaLicence>)map.get("caLicenceList");
	}
	
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
<form name="caForm35" method="post" action=""><br />

<div class="titleBg"><h2>CA Form 35 (Revised)</h2>
</div>
<div class="Block">
<label>From Date <span>*</span>  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a	href="javascript:setdate('<%=currentDate%>',document.caForm35.<%=FROM_DATE%>,true)">

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a> 

<label> To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"	validate="Pick a to date,date,yes" readonly="readonly" /> 
<a	href="javascript:setdate('<%=currentDate%>',document.caForm35.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a> <br>

<div class="clear"></div>

<div class="clear"></div>
<label>First Name</label>
<input name="<%=FIRST_NAME %>" type="text" tabindex="1" maxlength="10"  />

<label>Last Name</label>
<input name="<%=LAST_AME %>" type="text" tabindex="1" maxlength="10"  />

<div class="clear"></div>

<label>Type of Licence </label>
<select	name="<%=TYPE_OF_LICENCE %>" validate="Type of Licence applied,metachar,no"	id="<%=TYPE_OF_LICENCE %>" >


	<option value="0">Select</option>
	<%
		for(MasCaLicence masCaLicence : caLicenceList){
	%>
	<option value="<%=masCaLicence.getId()%>"><%=masCaLicence.getCaLicenceName() %></option>
	<%		
		}%>
</select> 

<label>Licence	No.</label>
<input name="<%=LICENCE_NO %>" type="text" tabindex="1" maxlength="10"  />

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onClick="submitForm('caForm35','aviationMedicine?method=generateCAForm35Report','check()');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button"
	onClick="clearButton('caForm35');" accesskey="a" tabindex=1 /></center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>






