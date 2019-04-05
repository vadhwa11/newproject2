
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.MasUnit"%><script type="text/javascript" language="javascript">
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
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<MasUnit> unitList=null;
if(map.get("unitList") != null){
	unitList =(List<MasUnit>)map.get("unitList");
}

Map<String, Object> utilMap = new HashMap<String, Object>();
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		%>
<form name="pilotRegistrationRpt" method="post" action="">
<div class="titleBg">
<h2>Pilot Registration Report</h2>
</div>
<div class="clear"></div>
<div class="Block">


<div class="clear"></div>
<label>Unit<span>*</span></label>
<select name="<%=UNIT %>"  id="<%=UNIT %>" tabindex="1" validate="Unit,metachar,yes">
<option value="0">Select</option>
	<%for(MasUnit masUnit : unitList){%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>

</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" accesskey="a" tabindex=1
onClick="submitForm('pilotRegistrationRpt','aviationMedicine?method=generatePilotRegistrationRpt');" /> 
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
</form>