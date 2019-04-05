<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.ShoBreakDown"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.ShoAntiFilaria"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"
	language="javascript">
	<%  String  fLastDate="";
	
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
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	List<ShoAntiFilaria> shoAntiFilariaList = new ArrayList<ShoAntiFilaria>();
	
	if(map.get("shoAntiFilariaList")!= null )
		{
		shoAntiFilariaList= (List<ShoAntiFilaria>)map.get("shoAntiFilariaList");
		}
	
	
	
	%>
	
   <% 
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		
		
		%>
		
<form name="antiFilaria" action="" method="post">
		
	
<div class="titleBg"><h2>Anti Failria</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label class="large2">Fly Proofing of Kitchen and Dining Hall</label>
<select name="flyProofing" id="flyProofing">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div class="clear"></div>

<label class="large2">Disposal of Refuse and Measures</label>
<input type="text" name="disposalOfRefuse" id="disposalOfRefuse" MAXLENGTH="100" />

<div class="clear"></div>

<label class="large2">Frequency of Insecticides Spray of Cook House & Lavatories</label>
<input type="text" name="frequencyOfInsecticide" id="frequencyOfInsecticide" MAXLENGTH="100" />

<div class="clear"></div>

<label class="large2">Current Date</label>
<input type="text"	id="currentDate" name="currentDate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.antiFilaria.currentDate,event)" />

<div class="clear"></div>

<label class="large2">Last Updated Date</label>

<%
Date lastDate = new Date();
if(shoAntiFilariaList != null && shoAntiFilariaList.size() > 0){
	for(ShoAntiFilaria shoAntiFilaria : shoAntiFilariaList){
		if(shoAntiFilaria.getCurrentDate() != null){
        lastDate = (Date)shoAntiFilaria.getCurrentDate();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String updatedDate = sdf.format(lastDate);
       
    	%>

<input type="text" name="lastUpdatedDate" id="lastUpdatedDate" value="<%=updatedDate %>" />

<%} else{%>
<label class="value">-</label>
<%}}} else{%>
<label class="value">-</label>
<%}%>

</div>

<div class="clear paddingTop15"></div>
 
<input type="button" name="Submit" value="Submit"  onClick= "submitForm('antiFilaria','/hms/hms/mis?method=submitShoAntiFilariaJSP');" class="button" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('antiFilaria','/hms/hms/mis?method=showShoAntiFilaria');" accesskey="r" />



<div class="clear"></div>

</form>