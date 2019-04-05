<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasAircraftType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
		
	
	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	
	if(map.get("unitList") != null){
		unitList= (List<Object[]>)map.get("unitList");
	}

	int hospitalId = 0;
	if(map.get("hospitalId")!=null){
		hospitalId = (Integer)map.get("hospitalId");
	}
	%>
<form name="regForIUD" method="post" action="">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>">
<div class="titleBg"><h2>Register For IUD and Other Report</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label> From <span>*</span></label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="calDate" readonly="readonly" MAXLENGTH="10" validate="From Date,string,yes"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.regForIUD.<%=FROM_DATE%>,event)" />

<label>To <span>*</span></label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="10" validate="To Date,string,yes"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.regForIUD.<%=TO_DATE%>,event)" />

<div class="Clear"></div>

<label> Unit</label> 
<select name="<%=UNIT_ID %>" validate="Unit/Squadron,metachar,no">
	<option value="0">Select</option>
	<% 
			for(Object[] unit : unitList)
			{
			%>
	<option value="<%=unit[0]%>"><%=(String)unit[1]%></option>
	<%
			}
			%>
</select> 
<div class="Clear"></div>
</div>

<input type="button" name="OK" value="PRINT" class="button"	onClick="if(datevalidation()){submitForm('regForIUD','fwc?method=printRegisterForIUDReportJsp');}" />

<div class="Clear"></div>
</form>
