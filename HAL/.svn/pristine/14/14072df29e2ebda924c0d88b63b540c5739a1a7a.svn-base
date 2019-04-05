<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.PoolRank"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<form name="regOfficer" method="post" action=""><script
	type="text/javascript">

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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <script>
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValue(){
document.getElementById('unit').value='0';
document.getElementById('serviceNo').value="";
document.getElementById('servicePersonName').value="";
document.getElementById('rankId').value='0';
document.getElementById('tradeId').value='0';
document.getElementById('sfx').value="";
document.getElementById('unitId').value='0';
document.getElementById('poolId').value='0';
document.getElementById('remarks').value="";

}

function getRecordsForOfficerReg(){
var unit;
unit=document.getElementById('unit').value;
var serviceNo;
serviceNo = document.getElementById('serviceNo').value;
if(unit == '31'){
if(serviceNo != null && serviceNo != ""){
regOfficer.method="post";
submitFormForButton('regOfficer','accom?method=getRecordsForOfficerReg&serviceNo='+document.getElementById('serviceNo').value+'&unitId='+document.getElementById('unit').value+'&registrationNo='+document.getElementById('registrationNo').value);
}
}else{
return true;
}
}


function checkUnit(){
var unit ;
var prevUnit;
unit= document.getElementById('unit').value;
prevUnit = document.getElementById('unitId').value;
if(unit == prevUnit){
alert("Unit and Previous Unit cannot be same.")
}else{
return true;
}
}
 function openPopupWindowForUnit()
 {
  var url="/hms/hms/accom?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }
 
 function jsSetUnitData(unitId,unitAddress)
{
 for(var i=0;i<document.getElementById("unitId").length;i++)
 {
	 if (document.getElementById("unitId").options[i].value==unitId)
	 {
	 	document.getElementById("unitId").selectedIndex = i;
	 }
	 if(unitAddress != "" && unitAddress != null){
	 	//document.getElementById('unitAddressId').value =unitAddress
	 }
 }
 var check = document.getElementById("unitId").value;
     if(check != "Other"){
     // document.getElementById('addUnitDiv').style.display = 'none';
     // document.getElementById('unitAddId').style.display = 'inline';
     }
} 
</script> <%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}
List<MasServiceType>  serviceTypeList=new ArrayList<MasServiceType>();
List<MasRank>  rankList=new ArrayList<MasRank>();
List<MasTrade>  tradeList=new ArrayList<MasTrade>();
List<MasUnit>  unitList=new ArrayList<MasUnit>();
List<MasUnit>  previousUnitList=new ArrayList<MasUnit>();
List<PoolRank>  poolRankList=new ArrayList<PoolRank>();
List<MasPool> poolList = new ArrayList<MasPool>();

if(map.get("serviceTypeList") != null){
	serviceTypeList = (List<MasServiceType>)map.get("serviceTypeList");
	}
if(map.get("rankList") != null){
	rankList = (List<MasRank>)map.get("rankList");
	}
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	}
if(map.get("previousUnitList") != null){
	previousUnitList = (List<MasUnit>)map.get("previousUnitList");
	}
if(map.get("tradeList") != null){
	tradeList = (List<MasTrade>)map.get("tradeList");
	}
if(map.get("poolRankList") != null){
	poolRankList = (List<PoolRank>)map.get("poolRankList");
	}

if(map.get("poolList") != null){
	poolList = (List<MasPool>)map.get("poolList");
	}
List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
String registrationNo ="";
if(map.get("registrationNo") != null){
	registrationNo = (String)map.get("registrationNo");
	}
%> <% 
String message ="";
if (map.get("message") != null) {
	message = (String) map.get("message");
 }
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>


<div class="Clear"></div>

<div id="contentHolder">
<h6>Married Accommodation Registration for officers</h6>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Registration
No.</label> <label class="value"><%=registrationNo %></label> <input
	type=hidden name="<%=REGISTRATION_NO %>" id="<%=REGISTRATION_NO %>"
	value="<%=registrationNo %>" /> <label><span>*</span>
Registration Date</label> <input type="text" id="regDateId"
	onblur="compareDateForMariageAccomodation('regDateId','regDateId');"
	name="<%=REGISTRATION_DATE %>" value="<%=date %>" readonly="readonly"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.regOfficer.<%=REGISTRATION_DATE%>,event)" />


<label><span>*</span> Registration Time</label> <input type="text"
	value="<%=time %>" name="<%=TIME %>" id="<%=TIME %>"
	readonly="readonly" tabindex="1" />

<div class="Clear"></div>

<label><span>*</span>Unit</label> <select id="<%=UNIT %>"
	name="<%=UNIT %>" validate="Unit,string,yes" tabindex="1" />
	<option value="0">Select</option>
	<%
			for(MasUnit masUnit : unitList){
			%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}%>
</select> <label><span>*</span> Service No.</label> <input typ="text"
	name="<%=SERVICE_NO %>" id="<%=SERVICE_NO %>"
	validate="ServiceNo,string,yes" maxlength="15" tabindex="1"
	onkeypress="return submitenter(this,event,'accom?method=getRecordsForOfficerReg')"
	onblur="getRecordsForOfficerReg();" /> <script>
		document.regOfficer.<%=SERVICE_NO%>.focus();
	</script> <label><span>*</span> Service Person Name</label> <input typ="text"
	value="" name="<%=SERVICE_PERSON_NAME %>"
	id="<%=SERVICE_PERSON_NAME %>"
	validate="Service Person Name,string,yes" maxlength="30" tabindex="1" />




<div class="Clear"></div>

<label><span>*</span> Rank</label> <select id="<%=RANK_ID %>"
	name="<%=RANK_ID %>" validate="Rank,string,yes"
	onblur="populatePoolCode(this.value,'regOfficer')"
	onChange="populatePoolCode(this.value,'regOfficer')" tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasRank masRank : rankList){
			%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}%>
</select> <script type="text/javascript">
	   			poolArray1 = new Array();
				<%
				int count3 = 0;
				for (Iterator<MasRank> iter = rankList.iterator(); iter.hasNext();) 
				{
					MasRank masRank = (MasRank) iter.next();
					for (Iterator<PoolRank> iterPool = poolRankList.iterator(); iterPool.hasNext();) 
					{
						PoolRank pool = (PoolRank) iterPool.next();
						if(masRank.getId().equals(pool.getRank().getId())){
									%>
										poolArray1[<%=count3%>] = new Array();
										poolArray1[<%=count3%>][0] = <%=masRank.getId()%>;
										poolArray1[<%=count3%>][1] = <%=pool.getPool().getId()%>;									
										poolArray1[<%=count3%>][2] = "<%=pool.getPool().getPoolName()%>";
	
									<%
									count3++;
							}
						}
					}
				
			%>
			</script> <script type="text/javascript">
	   			garageArray1 = new Array();
				<%
				int count1 = 0;
				for (Iterator<MasRank> iter = rankList.iterator(); iter.hasNext();) 
				{
					MasRank masRank = (MasRank) iter.next();
					for (Iterator<PoolRank> iterPool = poolRankList.iterator(); iterPool.hasNext();) 
					{
						PoolRank pool = (PoolRank) iterPool.next();
						if(masRank.getId().equals(pool.getRank().getId())){
									%>
										garageArray1[<%=count1%>] = new Array();
										garageArray1[<%=count1%>][0] = <%=masRank.getId()%>;
										garageArray1[<%=count1%>][1] = <%=pool.getPool().getId()%>;									
										garageArray1[<%=count1%>][2] = "<%=pool.getPool().getPoolName()%>";
	
									<%
									count1++;
							}
						}
					}
				
			%>
			</script> <label>Trade</label> <select id="<%=TRADE_ID %>"
	name="<%=TRADE_ID %>" validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasTrade masTrade  : tradeList){
			%>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName()%></option>
	<%}%>
</select> <label><span>*</span> Suffix</label> <select id="<%=SFX %>"
	name="<%=SFX %>" validate="Suffix,string,yes" tabindex="1">
	<option value="">Select</option>
	<%
				for(char i='A'; i<='Z'; i++){
			%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> </select>



<div class="Clear"></div>

<label><span>*</span>Previous Unit</label> <select id="<%=UNIT_ID %>"
	name="<%=UNIT_ID %>" validate="Unit,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasUnit masUnit  : previousUnitList){
			%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}%>
</select> <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit"> <label><span>*</span>Posting
Date</label> <input type="text" class="calDate" id="postingDateId"
	name="<%=POSTING_DATE %>" value="<%=date %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.regOfficer.<%=POSTING_DATE%>,event)" />

<label><span>*</span>Ante Date</label> <input type="text"
	class="calDate" id="anteDateId" name="<%=ANTE_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.regOfficer.<%=ANTE_DATE%>,event)" />

<div class="Clear"></div>

<label><span>*</span> Type of Receive</label> <select
	name="<%=TYPE_OF_RECEIVE%>" validate="Type Of Receive,string,yes">
	<option value="">Select</option>
	<option value="a">Active</option>
	<option value="r">Relegated</option>
	<option value="d">Dormant</option>

</select> <label><span>*</span> Posted Date</label> <input type="text"
	class="calDate" id="postedDateId" name="<%=POSTED_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.regOfficer.<%=POSTED_DATE%>,event)" />

<div class="Clear"></div>



<label><span>*</span> Previous SMQ</label> <input type="radio"
	class="radio" name="<%=PREVIOUS_SMQ %>" value="r" /> <label
	class="valueNoWidth">Retaining</label> <input type="radio"
	class="radio" name="<%=PREVIOUS_SMQ %>" value="n" checked="checked" />
<label class="valueNoWidth">Non Retaining</label>

<div class="Clear"></div>
<label><span>*</span> Pool Code</label> <select id="<%=POOL_ID %>"
	name="<%=POOL_ID %>" validate="Pool Code,string,yes" tabindex="1">
	<option value="0">Select</option>
	<% 
				for(MasPool masPool : poolList){
					
			%>
	<option value="<%=masPool.getId() %>"><%=masPool.getPoolName()%></option>
	<%}
					
				%>
</select> <label>Remarks</label> <textarea class="large" value=""
	name="<%=REMARKS %>" id="<%=REMARKS %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Remarks,string,no" tabindex="1"></textarea>

<div class="Clear"></div>
<label>Anti Date Seniority</label> <input type="text" class="calDate"
	id="antiDateId" name="<%=ANTI_DATE_SENIORITY %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.regOfficer.<%=ANTI_DATE_SENIORITY%>,event)" />

<label class="common">Anti-Date Remarks</label> <textarea value=""
	class="large" name="<%=ANTI_DATE_REMARKS %>"
	id="<%=ANTI_DATE_REMARKS %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Anti Date Remarks,string,no"
	tabindex="1"></textarea>
<div class="Clear"></div>
<label>Effective Date Of Registration</label> <input type="text"
	class="calDate" id="effectiveDateOfRegistration"
	name="<%=EFFECTIVE_DATE_OF_REGISTRATION %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" />

<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkAntiSeniorityDate() && checkUnit()){submitForm('regOfficer','accom?method=submitRegForOfficer');}"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetValue();" tabindex="1" />

<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="<%=REG_TYPE %>" value="o" /></div>
<div class="Clear"></div>
</div>
</form>
<script type="text/javascript">

function compareDateForMariageAccomodation(enteredDate,toBeCompareDate ){
   
   var fromDateForm=document.getElementById(enteredDate).value;
   var toDateForm=document.getElementById(toBeCompareDate).value;
   var fromDate=new Date(fromDateForm.substring(6),(fromDateForm.substring(3,5) - 1) ,fromDateForm.substring(0,2));
   var toDate=new Date(toDateForm.substring(6),(toDateForm.substring(3,5) - 1) ,toDateForm.substring(0,2));
   var currentDate=new Date();
   if(fromDate>currentDate)
   {
      alert("Registration Date can not be a future date!!");
      document.getElementById(enteredDate).value="";
      return false;
   }  
   return true;
}

function setEffectiveDateOfRegistration(registrationDate,antiDate ){
   
   var fromDateForm=document.getElementById(registrationDate).value;
   var toDateForm=document.getElementById(antiDate).value;
   var fromDate=new Date(fromDateForm.substring(6),(fromDateForm.substring(3,5) - 1) ,fromDateForm.substring(0,2));
   var toDate=new Date(toDateForm.substring(6),(toDateForm.substring(3,5) - 1) ,toDateForm.substring(0,2));
   var currentDate=new Date();
   if(fromDate>toDate)
   {
      alert("Effective date of registration has been setted to Anti Date Seniority!!");
      document.getElementById('effectiveDateOfRegistration').value=toDate.getDate()+'/'+toDate.getMonth()+'/'+toDate.getFullYear();
      return true;
   }
   else
   {
   alert("Effective date of registration has been setted to Registration date!!");
      document.getElementById('effectiveDateOfRegistration').value=fromDate.getDate()+'/'+(fromDate.getMonth()+1)+'/'+fromDate.getFullYear();
      return true;
   }  
   return true;
}

function est(registrationDate,ameDate)
{
var edStartDate = document.getElementById(registrationDate).value
var edDate = new Date(edStartDate.substring(6),(edStartDate.substring(3,5) - 1) ,edStartDate.substring(0,2))
var pdc = 5;
var calculatedDate=edDate;
if(calculatedDate.getDate().toString().length == 1)
{
var part1="0"+calculatedDate.getDate()-1;
}else
var part1=calculatedDate.getDate()-1;

if((calculatedDate.getMonth()+1).toString().length == 1)
{
var part2="0"+(calculatedDate.getMonth()+1);
}else
{
var part2=calculatedDate.getMonth()+1;
}
var part3=calculatedDate.getFullYear()+5;
document.getElementById(ameDate).value = part1+"/"+part2+"/"+part3;
}
</script>
