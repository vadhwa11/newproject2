<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigInteger"%>
<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<!--Main div starts-->
<div  id="contentHolder">
<form name="internalDemand" method="post" action="">

<script>
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

function calculateDays(){
	var fromDate = document.getElementById('fromDateId').value;
	var toDate = document.getElementById('toDateId').value;
		
	var one_day=1000*60*60*24; 
    var fromdt=fromDate.split("/");
    var todt= toDate.split("/");
    var date1 = new Date(fromdt[2],(fromdt[1]-1),(fromdt[0]-1))
    var date2=new Date(todt[2],(todt[1]-1),todt[0])
    
 
    diff=Math.floor((date2.getTime()-date1.getTime())/(one_day)); 
    
    var count = document.getElementById('counter').value;
    for(var i=0;i<count;i++){
    	document.getElementById('noOfDays'+i).innerHTML = diff;
    	var countVeg = document.getElementById('countId'+i).value;
    	document.getElementById('strgthV'+i).innerHTML = countVeg*diff;
    }
}

function calculateDateDaysForRationType(rationType){

	var todate;
	var days;
	if(rationType == 'dry'){
		days = 7;
	<%
	Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +6);
		String todate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
	%>
	todate = '<%=todate%>';
	}else if(rationType == 'fresh'){
		days=2;
	<%
	Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, +1);
		String todate1 = HMSUtil.convertDateToStringWithoutTime(cal1.getTime());
	%>
		todate = '<%=todate1%>';
	}
	
	
	document.getElementById('toDateId').value = todate;
	var count = document.getElementById('counter').value;
    for(var i=0;i<count;i++){
    	document.getElementById('noOfDays'+i).innerHTML = days;
    	var countVeg = document.getElementById('countId'+i).value;
    	document.getElementById('strgthV'+i).innerHTML = countVeg*days;
    }
}


</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasDietCombination> dietList = new ArrayList<MasDietCombination>();
	List<Object[]> dietDetailsList = new ArrayList<Object[]>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}

	if(map.get("dietList") != null){
		dietList = (List<MasDietCombination>)map.get("dietList");
	}
	if(map.get("dietDetailsList") != null){
		dietDetailsList = (List<Object[]>)map.get("dietDetailsList");
	}
	
	String demandSrNo = "";
	if(map.get("demandSrNo")!= null){
		demandSrNo = (String)map.get("demandSrNo");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	
	String time = (String)utilMap.get("currentTime");	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>

<div class="Clear"></div>

<h6>Internal Demand &amp; Issue Voucher For Ration</h6>
<div class="blockFrame">
<label>Ration Type:</label>
<select name="<%=RATION_TYPE %>" onchange="calculateAverageStrength(this.value);calculateDateDaysForRationType(this.value);submitProtoAjaxWithDivName('internalDemand','diet?method=getItemsForGrid','itemTableId')">
<option value="0">Select</option>
<option value="dry">Dry</option>
<option value="fresh">Fresh</option>
</select>

<label class="noWidth">Demand Serial No.:</label>
<input type="text" name="<%=DEMAND_SERIAL_NO %>" value="<%=demandSrNo %>"/>

<label>Date:</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>"/>

<div class="Clear"></div>

<label>Name Of Mess:</label>
<label class="value">Patient Mess</label>
<label>Unit:</label>
<label class="value">CHAFB</label>

<div class="Clear"></div>
<label class="noWidth">Date(s) For which supplies required From:</label>
<input id="fromDateId" type="text" name="<%=FROM_DATE %>" value="<%=currentDate %>" class="textbox_date" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.internalDemand.<%=FROM_DATE%>,event)"/> 
<label>To:</label>
<input id="toDateId" type="text" name="<%=TO_DATE %>" value="" class="textbox_date" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.internalDemand.<%=TO_DATE%>,event);"/> 

</div>

<div class="division"></div>

<label class="noWidth">Ration Strength Details:</label>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>Diet</th>
    <th>Strength</th>
    <th>No.Of Days</th>
    <th>Total Strength</th>
    </tr>
    <%
    	Integer[] countVegArr = new Integer[dietList.size()];
    
    	int i= 0;
    	int count = 0;
    	for(i=0;i<dietList.size();i++){
    		MasDietCombination diet = dietList.get(i);
      %>
   <tr>
    <td> <%=diet.getDietCombinationName() %>
    <input type="hidden" id="dietCombiId<%=i %>" name="<%=DIET_COMBINATION_ID %>" value="<%=diet.getId() %>">
    </td>
     <td ><input type="text" id="countId<%=count %>" name="<%=STRENGTH%>"  value="" maxlength="6"/></td>
      <td id="noOfDays<%=count %>">&nbsp; </td>
       <td id="strgthV<%=count %>">&nbsp;</td>
 </tr>
 <%
 	count++;
 }%>
</table>

 <input type="hidden" id="counter" name="counter" value="<%=count %>">
</div>
<div class="Clear"></div>
<div id="itemTableId"></div>
<div class="Clear"></div>
<input type="button" class="button" name="Submit" value="Save" onclick="submitForm('internalDemand','diet?method=saveInternalDemandRationDetails','checkFromAndToDate');"/>
<input type="reset" class="button" name="reset" value="Reset" /> 
<div class="Clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date </label>
<label class="value"><%=currentDate %></label>

<label>Changed time </label>
<label class="value"><%=time %></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate %>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time %>" />

</div>

<script type="text/javascript">
function calculateAverageStrength(rationType){

<%
int k = 0;
for(int j=0;j<dietList.size();j++){
	countVegArr[j] = 0;
	for(Object[] objects : dietDetailsList){
		BigInteger patientCount = (BigInteger)objects[0];
		String dietCombination = (String)objects[1];
		if(dietList.get(j).getDietCombinationName().equals(dietCombination)){
		%>
			if(rationType == 'dry'){
		<%	
				countVegArr[j] = Integer.parseInt(patientCount.toString())/7;
		%>
			}else if(rationType == 'fresh'){
			<%	
				countVegArr[j] = Integer.parseInt(patientCount.toString())/2;
			%>
			}
		<%}
		%>
		document.getElementById('countId<%=k%>').value = <%=countVegArr[j]%>
	<%}
	k++;
}
%>
}
</script>
<div class="Height10"></div>
<!--main div ends-->
</form>
</div>
