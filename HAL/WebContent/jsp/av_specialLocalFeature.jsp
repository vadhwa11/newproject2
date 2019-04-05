
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.AvSpecialLocalFeature"%>
<script type="text/javascript" language="javascript">
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}
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
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
		Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		List<AvSpecialLocalFeature>localFeatureList = new ArrayList<AvSpecialLocalFeature>();
		if(map.get("localFeatureList") != null){
			localFeatureList =(List<AvSpecialLocalFeature>)map.get("localFeatureList");
		}
		%>
<form name="specialLocalFeature" method="post" action="">
<div class="titleBg">
<h2>Special Local Feature</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Special Local Feature<span>*</span></label>
<%if(localFeatureList.size() >0){ 
for(AvSpecialLocalFeature specialLocalFeature:localFeatureList){%>
<input type="hidden" name="avAccidentId" id="avAccidentId" value="<%=specialLocalFeature.getId() %>"/>
<textarea class="auto" rows="" cols="60" name="specialLocalFeature" id="specialLocalFeature"
	validate="Local Feature,string,yes" onkeyup="chkLength(this,1000);"><%= specialLocalFeature.getSpecialLocalFeature()%></textarea>
	<%}}else{ %>
	<input type="hidden" name="avAccidentId" id="avAccidentId" value=""/>
<textarea class="auto" rows="" cols="60" name="specialLocalFeature"  id="specialLocalFeature"
	validate="Local Feature,string,yes" onkeyup="chkLength(this,1000);" ></textarea>
	<%} %>
</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="button" class="button" name="Submit11" value="SUBMIT" 
onclick="submitForm('specialLocalFeature','/hms/hms/aviationMedicine?method=submitSpecialLocalFeature&flag=special');" />
<input type="reset" name="Reset" value="Reset" class="button" onclick="resetSpecail();" accesskey="r" />

<script>
function resetSpecail(){
	document.getElementById('specialLocalFeature').value='';
}
    </script> 
</form>