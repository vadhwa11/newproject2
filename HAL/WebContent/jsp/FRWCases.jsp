<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>

<%@page import="jkt.hms.masters.business.MasUnit"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
		
	</script> <script type="text/javascript" language="javascript">
	var showListArray=new Array();
	var misFrwArray=new Array();
	
	
	function checkFrwCases()
		{
			var dateFrom = document.getElementById('inputDate').value;
 			fromDateFormat = new Date(dateFrom.substring(6),(dateFrom.substring(3,5) - 1) ,dateFrom.substring(0,2));
 			var calcYear=fromDateFormat.getFullYear();
 			var calcMonth=1+fromDateFormat.getMonth();
 			if(calcMonth<10)
 				calcMonth="0"+calcMonth;
 			var calcDate=fromDateFormat.getDate();
 			if(calcDate<10)
 				calcDate="0"+calcDate;
			var finalFromDate=calcYear+"-"+calcMonth+"-"+calcDate;
			if(misFrwArray.length>0)
			for(i=0;i<misFrwArray.length;i++)
			{  		
					if(misFrwArray[i][1]==finalFromDate && misFrwArray[i][0]==document.frwCases.serviceNo.value)
					{	
						alert("Duplicate record!!!!")
						document.getElementById("hinId").value ="";
						document.getElementById("rankName").value = "";
						document.getElementById("patientName").value="";
						document.getElementById("tradeName").value="";	  			         
						document.getElementById("unitName").value="";		     	         			        		          
						document.getEl("sex").value="";
						document.getElementById("fromDateId").focus();
						return false;
					
					}
			}
			return true;
		}
		
					
		function showFrwCases()
		{
			
			for(i=0;i<showListArray.length;i++)
			{
					if( showListArray[i][6]==document.frwCases.serviceNo.value)
					{
						document.getElementById("hinId").value = showListArray[i][0];
						document.getElementById("rankName").value = showListArray[i][1];
						document.getElementById("patientName").value=showListArray[i][2];
						document.getElementById("tradeName").value=showListArray[i][3];	  			         
						document.getElementById("unitName").value=showListArray[i][4];		     	         			        		          
						document.getElementById("sex").value=showListArray[i][5];
						document.getElementById("hinId").value=showListArray[i][7];
						document.getElementById("sex").value="SBC";
						
					}
			}
			document.getElementById("to").focus();
			
		}
		
		function displayHospital(){
				var disposalId = document.getElementById('disposalId').value;

				if(disposalId != 5){
				      document.getElementById('unitDiv').style.display = 'none';
				}else if(disposalId == 5){
					  document.getElementById('unitDiv').style.display = 'inline';
				}
				if(disposalId != 12){
				      document.getElementById('hospitalDiv').style.display = 'none';
				}else if(disposalId == 12){
					  document.getElementById('hospitalDiv').style.display = 'inline';
				}
				if(disposalId != 13){
				      document.getElementById('leaveDiv').style.display = 'none';
				}else if(disposalId == 13 ){
				      document.getElementById('leaveDiv').style.display = 'inline';
				}
			}
	</script>
<h2>Requisition for issue of FRW on Discharge/Transfer/Sick Leave</h2>
<div class="Clear"></div>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 
			 	String currentDate = (String) utilMap.get("currentDate");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<MasDisposedTo> disposalToList=null;
				if (request.getAttribute("map") != null) {
					map = (Map)request.getAttribute("map");
				}
				if (map.get("disposalToList") != null) {
					disposalToList = (List<MasDisposedTo>)map.get("disposalToList");
				}
				List<MasUnit> masUnitList=null;
				if (map.get("masUnitList") != null) {
					masUnitList = (List<MasUnit>)map.get("masUnitList");
				}
				%>

<form name="frwCases" method="post">
<div class="Block"><label> Entry Date</label> <input type="text"
	id="inputDate" name="<%=FROM_DATE %>" value="<%=currenDate %>"
	class="calDate" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.frwCases.<%=FROM_DATE%>,event)" />
<div class="Clear"></div>
</div>

<div class="Clear"></div>

<h4>Details</h4>
<div class="Block">
	<label>Service No.</label> 
	<input type="text" size="2" title="Enter Service No. of patient" id="serviceNo" name="<%=SERVICE_NO%>" onblur="populateHinNo(this.value);" /> 
	<label>Hin No.</label> 
	<select	id="hinNoId" name="<%=HIN_ID %>" validate="Hin No,string,yes" onchange="submitProtoAjax('frwCases','mis?method=getAdNo1');getFRWDetails(this.value);" />
	<option value="0">select</option>
	</select> 
	
	<div id="testDiv"><label class="bodytextB">Admission No.</label>
<input type="text" name="<%=AD_NO %>" id="<%=AD_NO %>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Admission No,String,yes" /></div>
<div class="Clear"></div>
	<label>Rank</label> <input type="text" value="" id="rankName"
	name="<%=RANK_NAME %>" readonly="readonly" />

<label>Name</label> <input type="text" id="patientName"
	name="<%=PATIENT_NAME%>" readonly="readonly" /> <label>Trade
Name</label> <input type="text" id="tradeName" name="<%=TRADE_NAME%>"
	readonly="readonly" />
	
<div class="Clear"></div>
	 <label>Sex</label> <input type="text"
	id="sex" name="<%=SEX%>" readonly="readonly" />


<label>From Unit</label> <input type="text" id="unitName"
	name="<%=UNIT_NAME%>" readonly="readonly"></label> <input type="hidden"
	id="hinId" name="<%=HIN_ID%>" readonly="readonly"></label> <label>From</label>
<input type="text" id="from" size="2" value="SBC" id="from"
	name="<%=FROM%>" readonly="readonly" />
<div class="Clear"></div>	
	 <label>To</label> <input
	type="text" id="to" size="2" value="" id="to" name="<%=TO%>" />

<label>Class</label> <select name="<%=CLASS%>" id="toClass">
	<option value="">select</option>
	<option value="Sleeper">Sleeper</option>
	<option value="AC-III">AC-III</option>
	<option value="AC-II">AC-II</option>
	<option value="AC-I">AC-I</option>
</select> <!-- <input type="text"   id="toClass" size="2" value="" name="<%=CLASS%>" /> -->
<label><span>*</span>Disposal</label> <select id="disposalId"
	name="<%=DISPOSAL_ID %>" validate="Disposal,string,yes"
	onchange="displayHospital();">
	<option value="0">select</option>
	<option value="5">Unit</option>
	<option value="12">TRANSFER TO OTH HOSPITAL</option>
	<option value="13">SICK LEAVE</option>
</select>
<div class="Clear"></div>
<div id="unitDiv" style="display: none;"><label>To Unit</label>
<select name="toUnit" id="toUnit">
	<option value="">select</option>
	<%for(MasUnit masUnit:masUnitList){%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName() %></option>
	<% }%>
	</select>
</div>

<div id="hospitalDiv" style="display: none;"><label>
Hospital Name</label> <input id="newUnitId" type="text"
	name="<%=HOSPITAL_NAME%>" value="" validate="Unit Address,string,no"
	maxlength="30" tabindex="1" /></div>


<div id="leaveDiv" style="display: none;"><label> Period
of sick leave</label> <input id="sickLeave" type="text" name="<%=SICK_LEAVE%>"
	value="" validate="Unit Address,string,no" maxlength="30" tabindex="1" />
<label> Review at</label> <input id="reviewat" type="text"
	name="<%=REVIEW_AT%>" value="" validate="Unit Address,string,no"
	maxlength="30" tabindex="1" />
<label>From Date</label> <input type="text" id="fromdate"
	class="calDate" name="<%=SICK_FROM_DATE%>" value="" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.frwCases.<%=SICK_FROM_DATE%>,event)" />
<div class="Clear"></div>
<label>To Date</label> <input type="text" class="calDate"
	id="fromdate" name="<%=TO_DATE%>" value="" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.frwCases.<%=TO_DATE%>,event)" />
	
<label class="auto">Address During Leave</label> 
<textarea name="<%=LEAVE_ADDRESS%>" class="auto" row="2" cols="50" id="leave_address"	validate="Address ,String,no" tabindex=1 maxlength="50" ></textarea>
<div class="Clear"></div>	
</div>

<label>Frw Sr No</label> <input type="text" id="frwSrNo"
	validate="Frw SrNo,String,no" size="2" value="" tabindex="1"
	name="<%=FRW_SR_NO%>" /> <label>POR</label> <input type="text"
	id="por" size="2" value="" tabindex="1" name="<%=POR%>" />
	</div>
	<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit" align="right"
	onClick="if(checkFrwCases()){submitForm('frwCases','mis?method=submitFrwCases','checkDateNotGreaterThanCurrentDate');}" />
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
<div class="Clear"></div>

</form>

	     	 <script>
function chekFRWDone(ADNumber)
	{
	 
	 var xmlHttp;
	 if(trimAll(ADNumber) != ""){
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	     var condition  = item.getElementsByTagName("condition")[0];
	      
	       if(condition.childNodes[0].nodeValue=='false'){	 
	       alert("FRW For this AD Number is already Done ");     
	       document.getElementById("<%=AD_NO%>").selectedIndex=0;
	       }
	     } 
      }
    }
   
   var url="/hms/hms/mis?method=checkFRWDone&ADNumber="+ADNumber
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    }
	}
	     	 </script>





