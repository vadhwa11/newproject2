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


<%@page import="jkt.hms.masters.business.ShoConservancy"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
	
	List<ShoConservancy> shoConservancyList = new ArrayList<ShoConservancy>();
	
	if(map.get("shoConservancyList")!= null )
		{
		shoConservancyList= (List<ShoConservancy>)map.get("shoConservancyList");
		}
	
	
	
	%>
	
   <% 
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		
		
		%>
		
<form name="shoConservancy" method="post">
		
	
<div class="titleBg"><h2>Conservancy</h2>
</div>
<div class="Block">

<label>Date of Conservancy</label>
<input type="text"	id="dateOfConservancy" name="dateOfConservancy" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="date" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.shoConservancy.dateOfConservancy,event)" />

<label>Last Updated Date</label>
<%
Date lastDate = new Date();
if(shoConservancyList != null && shoConservancyList.size() > 0){
	for(ShoConservancy shoConservancy : shoConservancyList){
		if(shoConservancy.getDateOfConservancy() != null){
     	  lastDate = (Date)shoConservancy.getDateOfConservancy();
     	  
      	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      	  String updatedDate = sdf.format(lastDate);
      	  
       
    	%>

<input type="text" name="lastUpdatedDate" id="lastUpdatedDate" value="<%=updatedDate %>" />


<%} else{%>
<label class="value">-</label>
<%}}} else{%>
<label class="value">-</label>
<%}%>

<label>Disposal</label>
<select name="disposal" id="disposal">
<option value="">Select</option>
<option value="Night Soil">Night Soil</option>
<option value="Storm Water">Storm Water</option>
</select>

<div class="clear"></div>

<label>Method of Disposal</label>
<input type="text" name="methodOfDisposal" id="methodOfDisposal" MAXLENGTH="100"/>

<label>Functioning Adequately</label>
<select name="functioningAdequately" id="functioningAdequately" onclick="showReasonAction();">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select> 

<div id="functioningAdequatelyId" style="display: none">

<label>Reason</label>
<input type="text" name="reason" id="reason" MAXLENGTH="100"/>

<div class="clear"></div>

<label>Action taken to Rectify</label>
<input type="text" name="actionTaken" id="actionTaken" MAXLENGTH="100"/>

</div>

<label>Disposal of Garbage and other dry refuse</label>
<input type="text" name="disposalOfGarbage" id="disposalOfGarbage" MAXLENGTH="100" />

</div>

<div class="clear paddingTop15"></div>
 
<input type="button" name="save" value="Submit"  onclick="submitForm('shoConservancy','/hms/hms/mis?method=submitShoConservancyJSP');" class="button" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('shoConservancy','/hms/hms/mis?method=showShoConservancy');" accesskey="r" />



<div class="clear"></div>

</form>
<script>
function showReasonAction(){
	if(document.getElementById('functioningAdequately').value == 'No'){
	  	document.getElementById("functioningAdequatelyId").style.display='inline';
	}else if(document.getElementById('functioningAdequately').value == 'Yes'){
		document.getElementById("functioningAdequatelyId").style.display='none';
	}
}
</script>