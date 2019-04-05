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
String screenName="Accommodation Entry";
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
<form name="waterSampleForAnalysis" method="post">
<div class="Clear"></div>

<div id="Block">

<label>Station/Unit</label>
<input type="text" id="sampleWaterFrom" name="<%=SAMPLE_WATER_FROM%>" onblur="getClockTime();"	title="Sample of water collection from" value="" MAXLENGTH="50"	tabindex="1"/>

<div class="Clear"></div>
<h4>Accommodation Authorised</h4>

<div class="Clear"></div>
<h4>Accommodation Available</h4>
	
<label class="large"> Action Taken to make up the deficiency with PDC where work is in progress</label> 
<input type="text" id="natureOfExaimReqd" name="<%=NATURE_OF_EXAIM_REQRD%>" validate="Exact nature of examination required,string,no" value="" title="Exact nature of examination required"	MAXLENGTH="50" tabindex="2"/>
</div>
<div class="Clear"></div>


 <label class="large">General Hygiene and sanitation<span>*</span></label> 
 <input type="text" name="<%=NATURE_AND_DISTANCE%>" id="natureAndDistance" value=""  title="Nature and distance of any source from which an inflow of pollution appears probable"
	validate=" Nature and distance of any source from which an inflow of pollution appears probable,string,no" tabindex="5" maxlength="50"/>
<div class="Clear"></div>

<label class="large">Arrangement of Disposal<span>*</span></label>
<input type="text"	name="<%=GEOLOGICAL_STRATA %>" id="geologicalStrata" value="" MAXLENGTH="50" title="Geological strata likely to affect the water constituents"	validate="Geological strata likely to affect the water constituents,String,Yes" tabindex="6"/>
<div class="Clear"></div>

 
<label class="large">Action Taken</label>
<input type="text" id="natureOfExaimReqd" name="<%=NATURE_OF_EXAIM_REQRD%>" validate="Exact nature of examination required,string,no" value="" title="Exact nature of examination required"	MAXLENGTH="50" tabindex="2"/>
<div class="Clear"></div>


<div class="Clear"></div>

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly" MAXLENGTH="8" />
	<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly"/> 
	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly"/> 

</form>
</div>

<div class="division"></div>

<input type="button" name="edit" value="Submit" class="button"	onClick="submitForm('waterSampleForAnalysis','sHO?method=saveWaterSampleForAnalysis');" tabindex="20"/>
<input type="button" name="Reset" onclick="submitForm('confirmedCasesH1N1','sHO?method=showConfirmedCasesH1N1');" value="Reset" class="button" tabindex="21"/>
<div class="Clear"></div>



<script>
    //document.getElementById('nxtspace').style.display = 'inline';
 </script>


