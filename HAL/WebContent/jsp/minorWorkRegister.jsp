<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@ page import="jkt.hms.masters.business.MasWorkType"%>



<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
			
	%>
<SCRIPT>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</SCRIPT>
<%	String 	userName="";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	//String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");
	String currentDate = (String)utilMap.get("currentDate");  

	String sessionPeriod="";
	if(map.get("session")!=null)
	{
		sessionPeriod=(String) map.get("session");
	}
	
	List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
	if(map.get("minorWorkDetailList")!=null)
	{
		minorWorkDetailList = (List) map.get("minorWorkDetailList");
	}
	
	List<MasWorkType> masWorkTypeList = new ArrayList<MasWorkType>();
	if(map.get("masWorkTypeList")!=null)
	{
		masWorkTypeList = (List) map.get("masWorkTypeList");
	}
		
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  
		  }
	
	%>

<script type="text/javascript">
function checkd()
{
var SDate = document.minorWorkRegister.<%= FROM_DATE%>.value;
var EDate = document.minorWorkRegister.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}

function workType(){
			var obj = document.getElementById("stringvariable");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					workName = obj.options[i].text
					alert(workName);
					break;
				}
			}
			if(workName !="Select"){
				document.getElementById("work").value =""
			}else{
				document.getElementById("work").value =workName
			}
			}

</script>
<DIV id=contentHolder>
<FORM name="minorWorkRegister" action="" method=post>
<h6>Minor Work Register</h6>
<div class="Clear"></div>

<DIV class="blockFrame"><label><span>*</span> Minor Work
From Date</Label> <input type="text" class="calDate" name="<%=FROM_DATE%>"
	value="" readonly="readonly" MAXLENGTH="30"
	validate="Pick a from date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onClick="setdate('<%=currentDate%>',document.minorWorkRegister.<%= FROM_DATE%>,event);"
	class="calender" /> <LABEL><span>*</span> Minor Work To Date</LABEL> <input
	type="text" name="<%=TO_DATE%>" value="" class="calDate"
	readonly="readonly" validate="Pick a to date,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onClick="setdate('<%=currentDate%>',document.minorWorkRegister.<%= TO_DATE%>,event);"
	class="calender" /> <label><span>*</span>Work Type</label> <select
	name="work" tabindex=1 validate="Please enter Work Type,String,yes">
	<option value="">Select</option>
	<%
		for (MasWorkType masWorkType : masWorkTypeList) {%>
	System.out.println("list of work"+ worktypeList.size());

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>
	<%
		}
		%>
</select>

<div class="Clear"></div>

<label><span>*</span> Status </label> <label class="unit">Pending</label>
<input type="radio" class="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" /> <label class="unit">Approval</label> <input
	type="radio" class="radio" name="<%=SELECTED_RADIO  %>" value="2" /> <label
	class="unit">Completion</label> <input type="radio" class="radio"
	name="<%=SELECTED_RADIO  %>" value="3" /> <label class="unit">Cancel</label>
<input type="radio" class="radio" name="<%=SELECTED_RADIO  %>" value="4" />
<div class="Clear"></div>

</DIV>
<div class="division"></div>
<div class="bottom"><input type="button" class=button value="Ok"
	name="print"
	onclick="submitForm('minorWorkRegister','/hms/hms/workServiceReport?method=printMinorWorkRegister','checkd()');" />
<INPUT class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset>
<div class="division"></div>
</div>
</div>