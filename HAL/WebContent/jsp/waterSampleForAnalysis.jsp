<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
				String userName = "";
				if (session.getAttribute("userName") != null) {
					userName = (String) session.getAttribute("userName");
				}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div class="Clear"></div>
<label class="noWidth"> <span> <%=message %> </span> </label>
<div class="Clear"></div>
<% } %>
<%
String screenName="Water Supply (Bacteriology/Chemical)";
%>

<script type="text/javascript" language="JavaScript">
function getClockTime()
{
	var currentTime = new Date()
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	var currentDate="";
	currentDate=day + "/" + month + "/" + year ;

	   var now    = new Date();
   var hour   = now.getHours();
   var minute = now.getMinutes();
   var second = now.getSeconds();
   var ap = "AM";
   if (hour   > 11) { ap = "PM";             }
   if (hour   > 12) { hour = hour - 12;      }
   if (hour   == 0) { hour = 12;             }
   if (hour   < 10) { hour   = "0" + hour;   }
   if (minute < 10) { minute = "0" + minute; }
   if (second < 10) { second = "0" + second; }
   var timeString = currentDate+' :: '+hour +
                    ':' +
                    minute +
                    ':' +
                    second +
                    " " +
                    ap;
//   return timeString;
	document.getElementById("dateHourOfSampling").value=timeString;
}
</script>
<div class="titleBg">
<h2><%=screenName%></h2>
</div>
<div class="Block">
<div class="Clear"></div>
<div class="Clear"></div>
<form name="waterSampleForAnalysis" method="post">
<div class="Clear"></div>

<div id="Block"><label style="width: 310px">Sample of water collection from</label> 
<input type="text" id="sampleWaterFrom"
	name="<%=SAMPLE_WATER_FROM%>" Validate="name ,string ,no "
	onblur="getClockTime();" title="Sample of water collection from"
	value="" MAXLENGTH="50" tabindex="1" /> 
	<label style="width: 310px">Exact nature of examination required</label> 
	<input type="text"	id="natureOfExaimReqd" name="<%=NATURE_OF_EXAIM_REQRD%>"
	validate="Exact nature of examination required,string,no" value=""
	title="Exact nature of examination required" MAXLENGTH="50"
	tabindex="2" /></div>
<div class="Clear"></div>
<label style="width: 310px"><span>*</span> Date and hour of sampling</label> 
<input type="text" name="<%=DATE_HOUR_OF_SAMPLING %>"
	id="dateHourOfSampling" value=""
	validate="Date and hour of sampling,,no" tabindex="3" maxlength="30" />

<label style="width: 310px"><span>*</span> Nature and location of source of water</label>
<input type="text"	name="<%=NATURE_AND_SOURCE_OF_WATER %>" id="natureAndSourceOfWater"
	value="" validate=" Nature and location of source of water,string,no"
	tabindex="4" />

<div class="Clear"></div>
<label style="width: 500px"><span>*</span> Nature and distance of any source from which an in flow of pollution appears probable</label> 
<input	type="text" name="<%=NATURE_AND_DISTANCE%>" id="natureAndDistance"
	value=""
	title="Nature and distance of any source from which an inflow of pollution appears probable"
	validate=" Nature and distance of any source from which an inflow of pollution appears probable,string,no"
	tabindex="5" maxlength="50" />

<div class="Clear"></div>
<label style="width: 500px"><span>*</span> Geological strata likely to affect the water constituents</label> 
<input type="text"	name="<%=GEOLOGICAL_STRATA %>" id="geologicalStrata" value=""
	MAXLENGTH="50"
	title="Geological strata likely to affect the water constituents"
	validate="Geological strata likely to affect the water constituents,String,Yes"
	tabindex="6" />
<div class="Clear"></div>

<div class="titleBg">
<h4>If the source be a well</h4>
</div>
<label style="width: 310px"> Depth of water surface</label> <input
	type="text" name="<%=DEPTH_OF_SURFACE %>" id="depthOfSurface" value=""
	MAXLENGTH="15" title="Depth of water surface"
	validate="Depth of water surface,String,no" tabindex="7" /> <label
	style="width: 310px"><span>*</span> Depth of water</label> <input
	type="text" name="<%=DEPTH_OF_WATER%>" id="depthOfWater" value=""
	tabindex="8" maxlength="15" title=" Depth of water"
	validate="Depth of water,String,no" />


<div class="Clear"></div>
<label style="width: 310px"><span>*</span> Staining</label>
 <input	type="text" name="<%=STAINING%>" id="staining" value="" tabindex="9"
	maxlength="15" title=" Staining" validate="Staining,String,no" /> 
	<label	style="width: 310px"><span>*</span> Coping</label> 
	<input type="text"	name="<%=COPING%>" id="coping" value="" tabindex="10" maxlength="15"
	title=" Coping" validate="Coping,String,no" />

<div class="Clear"></div>
<label style="width: 310px"><span>*</span> Strata penetrated </label> 
<input	type="text" name="<%=STRATA_PENETRATED%>" id="strataPenetrated"
	value="" tabindex="11" maxlength="15" title=" Strata penetrated"
	validate="Strata penetrated,String,no" /> <label style="width: 310px"><span>*</span>
Covering</label> <input type="text" name="<%=COVERING%>" id="covering" value=""
	tabindex="12" maxlength="15" title=" Covering"
	validate="Covering,String,no" />
<div class="Clear"></div>


<label style="width: 500px"><span>*</span> Method of raising
water</label> <input type="text" name="<%=RAISING_WATER%>" id="raisingWater"
	value="" tabindex="13" maxlength="15" title=" Method of raising water"
	validate="Method of raising water,String,no" />
<div class="Clear"></div>
<label style="width: 500px"><span>*</span>If stored surface
water, nature of collection and condition of storage</label> <input
	id="storedsurfacewater" type="text" name="<%=STORED_SURFACE_WATER%>"
	value=""
	validate="If stored surface water  nature of collection and condition of storage,string,no"
	maxlength="15" tabindex="14" /> 
	<label style="width: 500px"><span>*</span>PRESENT Meteorological conditions, heavy rainfall or draught</label> 
<input	id="presentMeteorological" type="text"
	name="<%=PRESENT_METEOROLOGICAL%>" value=""
	validate="Meteorological conditions  heavy rainfall or draught,string,no"
	maxlength="15" tabindex="15" />
<div class="Clear"></div>
<div class="titleBg">
<h4>Any treatment the water has received</h4>
</div>

<div class="Clear"></div>
<label style="width: 310px"><span>*</span>Clarification</label>
 <select name="<%=CLARIFICATION%>" id="Clarification" tabindex="16"
	validate="Clarification,string,no">
	<option value="YES">YES</option>
	<option value="NO">NO</option>
</select> <label style="width: 310px"><span>*</span>Softening</label> 
<select	name="<%=SOFTENING %>" id="softening" tabindex="17"
	validate="Softening,string,no">
	<option value="YES">YES</option>
	<option value="NO">NO</option>
</select>
<div class="Clear"></div>
<label style="width: 310px"><span>*</span>Boiling</label> <select
	name="<%=BOILING %>" id="boiling" tabindex="18"
	validate="Boiling,string,no">
	<option value="YES">YES</option>
	<option value="NO">NO</option>
</select> <label style="width: 310px"><span>*</span>Chlorination carried
out by CPWD</label> <input id="chlorinationCarriedOutCPWD" type="text"
	name="<%=CHLORINATION_CARRIED_OUT_CPWD%>" value=""
	validate="Chlorination carried out by CPWD,string,no" maxlength="15"
	tabindex="19" />
<div class="Clear"></div>

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	readonly="readonly" MAXLENGTH="8" /> <input type="hidden"
	name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	readonly="readonly" />
	 <input type="button" name="edit" value="Submit"
	class="button"
	onClick="submitForm('waterSampleForAnalysis','/hms/hms/sHO?method=saveWaterSampleForAnalysis');"  /> 
	
	<!--<input type="button" name="Reset"
	onclick="submitForm('confirmedCasesH1N1','sHO?method=showConfirmedCasesH1N1');"
	value="Reset" class="button" tabindex="21" />
	 <input type="button"
	name="edit" value="Print" class="button" />
	 <input type="button"
	name="edit" value="Back" class="button" />
-->
<div class="Clear"></div>

<div id="edited"></div>
</form>
</div>


<script>
    //document.getElementById('nxtspace').style.display = 'inline';
 </script>


