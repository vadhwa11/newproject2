
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveApplication"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.FamilyDetails"%>
<%@page import="jkt.hms.masters.business.LeaveRestrictionEntry"%>
<%@page import="jkt.hms.masters.business.EmpLeaveBalance"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveAccount"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<form name="leaveApplicationUpdate" method="post" action=""><script
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


}
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
    
    } 
</script> <script type="text/javascript" language="javascript">

function fillFamilyDetails(inc)
  {
    	
    	var selectFamily="selectFamily";
    	var selectFamilytemp="selectFamilytemp";
    	
    	var dob="dob";
    	var dobtemp="dobtemp";
    	
    	var age="age";
    	var agetemp="agetemp";
    	
    	var dependentPorNo = "dependentPorNo";
    	var dependentPorNotemp = "dependentPorNotemp";
    	
    	document.getElementById(selectFamily+inc).value=document.getElementById(selectFamilytemp+inc).value
    	document.getElementById(dob+inc).value=document.getElementById(dobtemp+inc).value
    	document.getElementById(age+inc).value=document.getElementById(agetemp+inc).value
    	document.getElementById(dependentPorNo+inc).value = document.getElementById(dependentPorNotemp+inc).value
  }

</script> <%

int hiddenValueCharge = 0;
String previousPage="no";
int sum = 0;
int abc = 0;
String leaveType1 = null;
int pageNo = 1;
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

if(map.get("hiddenValueCharge") != null)
{
	hiddenValueCharge=(Integer)map.get("hiddenValueCharge");
	
}

List<HrLeaveTypeMaster> leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
List<MasDistrict> cityList=new ArrayList<MasDistrict>();
List<MasState> stateList=new ArrayList<MasState>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
List<FamilyDetails> familyDetailsList = new ArrayList<FamilyDetails>();
List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
if(map.get("familyDetailsList") != null){
	familyDetailsList = (List<FamilyDetails>)map.get("familyDetailsList");
	}
if(map.get("leaveTypeList") != null){
	leaveTypeList = (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
	}
if(map.get("hrorderlyleaveaccountList") != null){
	hrorderlyleaveaccountList = (List<HrorderlyLeaveAccount>)map.get("hrorderlyleaveaccountList");
}
if(map.get("cityList") != null){
	cityList = (List<MasDistrict>)map.get("cityList");
	}
if(map.get("stateList") != null){
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("leaveRestrictionEntryList") != null){
	leaveRestrictionEntryList = (List<LeaveRestrictionEntry>)map.get("leaveRestrictionEntryList");
	}
if(map.get("empLeaveBalanceList") != null){
	empLeaveBalanceList = (List<EmpLeaveBalance>)map.get("empLeaveBalanceList");
	}
System.out.println("empLeaveBalanceList in jsp is "+empLeaveBalanceList.size());


if(map.get("masEmployeeList") != null){
	employeeList = (List<MasEmployee>)map.get("masEmployeeList");
	}
if(map.get("leaveApplicationList") != null){
	leaveApplicationList = (List<HrorderlyLeaveApplication>)map.get("leaveApplicationList");
	}
String entryDate="";
String toDate="";
String fromDate="";
String alFromDate="";
String alToDate="";
if(leaveApplicationList.get(0).getAddlLeaveToDate()!=null)
{
	alToDate=HMSUtil.convertDateToStringWithoutTime(leaveApplicationList.get(0).getAddlLeaveToDate());
}
else
	alToDate="";
if(leaveApplicationList.get(0).getAddlLeaveFromDate()!=null)
{
	alFromDate=HMSUtil.convertDateToStringWithoutTime(leaveApplicationList.get(0).getAddlLeaveFromDate());
}
else
	alFromDate="";
if(leaveApplicationList.get(0).getEntryDate()!=null)
{
	entryDate=HMSUtil.convertDateToStringWithoutTime(leaveApplicationList.get(0).getEntryDate());
}
else
	entryDate="";
if(leaveApplicationList.get(0).getDateOfReporting()!=null)
{
	toDate=HMSUtil.convertDateToStringWithoutTime(leaveApplicationList.get(0).getDateOfReporting());
}
else
	toDate="";
if(leaveApplicationList.get(0).getLeaveFromDate()!=null)
{
	fromDate=HMSUtil.convertDateToStringWithoutTime(leaveApplicationList.get(0).getLeaveFromDate());
}
else
	fromDate="";

String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
	}
int Id =  0;
if(map.get("Id")!= null){
	Id= (Integer)map.get("Id");
}

System.out.println("Id in jsp== "+Id);

String message="";
%> <script type="text/javascript">
    function calDays()
    {    
       var t1=document.getElementById("fromDate").value
       var t2=document.getElementById("toDate").value
       fromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
       toDate = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
       try
       {
          fromDate =  new Date(fromDate)
          toDate =  new Date(toDate)
        
          if(fromDate!=NaN&&toDate!=NaN)
          {
            var date = toDate.getTime() - fromDate.getTime(); 
            var time = Math.floor(date / (1000 * 60 * 60 * 24));
            document.getElementById("totalDays").value=time;
          }
       }
       catch(e) {}
       return false;
    }

 function calAddlDays()
    {    
       var t1=document.getElementById("addlFromDate").value
       var t2=document.getElementById("addlToDate").value
       addlFromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
       addlToDate = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
       try
       {
          addlFromDate =  new Date(addlFromDate)
          addlToDate =  new Date(addlToDate)
        
          if(addlFromDate!=NaN&&addlToDate!=NaN)
          {
            var date = addlToDate.getTime() - addlFromDate.getTime(); 
            var time = Math.floor(date / (1000 * 60 * 60 * 24));
            document.getElementById("addlTotalDays").value=time;
          }
       }
       catch(e) {}
       return false;
    }
<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : cityList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		var leaveArray =new Array();
    <%          
    			int counter2=0;
    			boolean flag1=true;
				if(leaveTypeList!=null){
    	        for(HrLeaveTypeMaster hrleavetypemaster :leaveTypeList){
    	        	if(hrorderlyleaveaccountList !=null){
    	        		for(HrorderlyLeaveAccount hrorderlyleaveaccount : hrorderlyleaveaccountList){
    	        			if(hrleavetypemaster.getId().equals(hrorderlyleaveaccount.getLeaveTypeId())){%>
    	        			leaveArray[<%=counter2%>]=new Array();
    	        			leaveArray[<%=counter2%>][0]= <%=hrleavetypemaster.getId()%>;
    	        			leaveArray[<%=counter2%>][1]=<%=hrorderlyleaveaccount.getOLeaveBalance()+hrorderlyleaveaccount.getEntitledLeave()-hrorderlyleaveaccount.getLeaveAvailed() %>;
    	        			<%
    	        			flag1=false;
    	        			}
    	        		}
    	        		if(flag1){%>
	        			leaveArray[<%=counter2%>]=new Array();
	        			leaveArray[<%=counter2%>][0]= <%=hrleavetypemaster.getId()%>;
	        			leaveArray[<%=counter2%>][1]=0;
	        			<%
    	        		}
    	        		
    	        	}else{%>
        			leaveArray[<%=counter2%>]=new Array();
        			leaveArray[<%=counter2%>][0]= <%=hrleavetypemaster.getId()%>;
        			leaveArray[<%=counter2%>][1]=0;
        			<%
    	        	}
    	        	counter2++;
    	        }
    	
    }
    
    %>	


</script> <script type="text/javascript">
<!--
function calculateAge(inputFieldId, outputFieldId){
 
var age;
 
var input = document.getElementsById(inputFieldId).value;
 
// Past date info
 
var pyear = parseInt(input.substring(6,10));
var pmonth = parseInt(input.substring(3,5)) - 1;
var pday = parseInt(input.substring(0,2));
 
// Today info
today = new Date();
year = today.getFullYear() ;
month = today.getMonth();
day = today.getDate();
 
if ( month < pmonth ){
age = year - pyear - 1;
}
else if ( month > pmonth ){
age = year - pyear;
}
else if ( month == pmonth ){
if ( day < pday ){
age = year - pyear - 1;
}
else if ( day > pday ){
age = year - pyear;
}
else if ( day == pday ){
age = year - pyear;
}
}
document.getElementById(outputFieldId).value = age;
 
}
//-->
</script>


<div class="Clear"></div>

<div id="contentHolder">
<%if(map.get("message") != null){
 	message = (String)map.get("message");
%> <br />
<h2 style="color: #AC1400; width: 300;"><%=message %></h2>
<div class="Clear"></div>
<%} %>

<h6>Leave Application Entry Update</h6>
<div class="Clear"></div>
<div class="blockTitle">Employee Credential</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<%if(employeeList.get(0).getServiceType()!=null){ %> <label>Service
Type:-</label> <label><%=employeeList.get(0).getServiceType().getServiceTypeName() %></label>
<%}%> <%if(employeeList.get(0).getServiceNo()!=null){ %> <label>Service
No:- <%=employeeList.get(0).getServiceNo() %></label> <%} %> <%if(employeeList.get(0).getRank()!=null){ %>
<label>Rank:- <%=employeeList.get(0).getRank().getRankName() %></label>
<%} %>
<div class="Clear"></div>

<label>Name Of Employee:-</label> <label>
<%if(employeeList.get(0).getFirstName()!=null){%> <%=employeeList.get(0).getFirstName() %>&nbsp
&nbsp <%}if(employeeList.get(0).getMiddleName()!=null){ %> <%=employeeList.get(0).getMiddleName() %>&nbsp
&nbsp <%}if(employeeList.get(0).getLastName()!=null){ %> <%=employeeList.get(0).getLastName() %>
<%} %> </label> <input type="hidden" name="employeeId" id="employeeId"
	value="<%=employeeList.get(0).getId()%>" /> <input type="hidden"
	name="rankCategoryId" id="rankCategoryId"
	value="<%=employeeList.get(0).getRank().getRankCategory().getId()%>" />
<div class="Clear"></div>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span>Entry No.</label> <%if(leaveApplicationList.get(0).getEntryNo() != null ) {%>
<input type=hidden name="<%=ENTRY_NO %>"
	value="<%=leaveApplicationList.get(0).getEntryNo() %>" /> <label
	class="value"><%=leaveApplicationList.get(0).getEntryNo() %></label> <%}else{ %>
<input type=hidden name="<%=ENTRY_NO %>"
	value="<%=leaveApplicationList.get(0).getEntryNo() %>" /> <label
	class="value">-</label> <%} %> <input type=hidden name="empId"
	value="<%=leaveApplicationList.get(0).getEmployee().getId() %>" /> <label><span>*</span>Entry
Date</label> <input type="text" id="entryDateId" name="<%=ENTRY_DATE %>"
	value="<%=entryDate%>" tabindex="1" /> <input type="hidden" name="Id"
	value="<%=Id %>"> <label><span>*</span>Leave Type</label> <select
	id="<%=LEAVE_TYPE %>" name="<%=LEAVE_TYPE%>"
	validate="Leave Type,string,yes" tabindex="1">
	<option value="">Select</option>
	<%if(leaveTypeList != null){
	for(HrLeaveTypeMaster hrLeaveTypeMaster : leaveTypeList){
		if(leaveApplicationList.get(0).getLeave() != null){
			if(leaveApplicationList.get(0).getLeave().getId() == hrLeaveTypeMaster.getId()){
		%>
	<option value="<%= hrLeaveTypeMaster.getId() %>" selected="selected"><%= hrLeaveTypeMaster.getLeaveType()%></option>
	<%}else{%>
	<option value="<%= hrLeaveTypeMaster.getId() %>"><%= hrLeaveTypeMaster.getLeaveType()%></option>
	<%}}else{%>
	<option value="<%= hrLeaveTypeMaster.getId() %>"><%= hrLeaveTypeMaster.getLeaveType()%></option>
	<%}}}%>

</select>

<div class="Clear"></div>

<label> <span>*</span>From Date</label> <input type="text"
	class="calDate" id="fromDate" name="<%=LEAVE_FROM_DATE %>"
	validate="From Date,Date,yes" value="<%=fromDate%>" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplicationUpdate.<%=LEAVE_FROM_DATE%>,event)" />

<label> <span>*</span>To Date</label> <input type="text" class="calDate"
	id="toDate" name="<%=LEAVE_TO_DATE %>" validate="To Date,Date,yes"
	value="<%=toDate%>" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplicationUpdate.<%=LEAVE_TO_DATE%>,event)" />

<label> <span>*</span>Total Days</label> <%if(leaveApplicationList.get(0).getLeaveTotalDays() != null){ %>
<input type="text" id="totalDays" onclick="calDays()"
	name="<%=LEAVE_DAYS %>" validate="Total Days,String,yes  value="
	<%=leaveApplicationList.get(0).getLeaveTotalDays() %>" tabindex="1" />
<%}else{ %> <input type="text" id="totalDays" onclick="calDays()"
	name="<%=LEAVE_DAYS %>" value="" tabindex="1" /> <%} %>

<div class="Clear"></div>

<label>Addl. leave From Date</label> <input type="text" class="calDate"
	id="addlFromDate" name="<%=ADDL_LEAVE_FROM_DATE %>"
	value="<%=alFromDate%>" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplicationUpdate.<%=ADDL_LEAVE_FROM_DATE%>,event)" />

<label>Addl. leave To Date</label> <input type="text" class="calDate"
	id="addlToDate" name="<%=ADDL_LEAVE_TO_DATE %>" value="<%=alToDate %>"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplicationUpdate.<%=ADDL_LEAVE_TO_DATE%>,event)" />

<label>Addl. Leave Total Days</label> <%if(leaveApplicationList.get(0).getAddlLeaveTotalDays() != null){ %>
<input type="text" id="addlTotalDays" onclick="calAddlDays()"
	name="<%=ADDL_LEAVE_DAYS %>"
	value="<%=leaveApplicationList.get(0).getAddlLeaveTotalDays()%>"
	tabindex="1" /> <%}else{ %> <input type="text" id="addlTotalDays"
	onclick="calAddlDays()" name="<%=ADDL_LEAVE_DAYS %>" value=""
	tabindex="1" /> <%} %>

<div class="Clear"></div>

<label>Application Type</label> <select id="<%=TYPE %>"
	name="<%=TYPE %>" validate="Type,string,no" tabindex="1">
	<option value="">Select</option>
	<%if(leaveApplicationList.get(0).getType()!=null && leaveApplicationList.get(0).getType().equals("")){%>
	<%if(leaveApplicationList.get(0).getType()=="f"){%>
	<option value="f" selected="selected">FRW</option>
	<option value="c">CV</option>
	<%}else if(leaveApplicationList.get(0).getType()=="o"){ %>

	<option value="f">FRW</option>
	<option value="c" selected="selected">CV</option>
	<%}else if(true) { %>
	<option value="f">FRW</option>
	<option value="c">CV</option>
	<%}}else{%>
	<option value="f">FRW</option>
	<option value="c">CV</option>
	<%} %>
</select> <label>Required From</label> <select id="<%=REQUIRED_FROM %>"
	name="<%=REQUIRED_FROM %>" validate="Required From,string,no"
	tabindex="1">
	<option value="">Select</option>
	<% 	    if(cityList!=null){
	    	for(MasDistrict masDistrict : cityList){
	 		if(leaveApplicationList.get(0).getRequiredFrom() != null){
		 	if(leaveApplicationList.get(0).getRequiredFrom().getId() == masDistrict.getId()){
		%>
	<option value="<%= masDistrict.getId() %>" selected="selected"><%= masDistrict.getDistrictName()%></option>
	<%}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}}%>
</select> <label>City To</label> <select id="<%=CITY_TO %>" name="<%=CITY_TO %>"
	validate="City To,string,no" tabindex="1">
	<option value="">Select</option>
	<%      if(cityList!=null){
	    	for(MasDistrict masDistrict : cityList){
	 		if(leaveApplicationList.get(0).getRequiredFrom() != null){
		 	if(leaveApplicationList.get(0).getCityTo().getId() == masDistrict.getId()){
		%>
	<option value="<%= masDistrict.getId() %>" selected="selected"><%= masDistrict.getDistrictName()%></option>
	<%}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}}%>
</select>

<div class="Clear"></div>

<label>Rajdhani/Sha.up to</label> <select id="<%=RAJDHANI_UPTO %>"
	name="<%=RAJDHANI_UPTO %>" tabindex="1">
	<option value="">Select</option>
	<%      if(cityList!=null){
	    	for(MasDistrict masDistrict : cityList){
	 		if(leaveApplicationList.get(0).getRequiredFrom() != null){
		 	if(leaveApplicationList.get(0).getRajdhaniUpto().getId() == masDistrict.getId()){
		%>
	<option value="<%= masDistrict.getId() %>" selected="selected"><%= masDistrict.getDistrictName()%></option>
	<%}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}}%>
</select> <label>Availing LTC </label> <select id="<%=AVAILING_LTC %>"
	name="<%=AVAILING_LTC %>" validate="Ltc,string,no" tabindex="1">
	<%if(leaveApplicationList.get(0).getAvailingLtc()!=null && !leaveApplicationList.get(0).getAvailingLtc().equals("")){
		if(leaveApplicationList.get(0).getAvailingLtc().equals("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">Yes</option>
	<%}else{ %>
	<option value="n">No</option>
	<option value="y" selected="selected">Yes</option>
	<%}}else{ %>
	<option value="n">No</option>
	<option value="y">Yes</option>
	<%}%>

</select> <label>Other Trains up to: </label> <%if(leaveApplicationList.get(0).getOtherTrainsUpto()!=null && !leaveApplicationList.get(0).getOtherTrainsUpto().equals("")){ %>
<textarea value="<%=leaveApplicationList.get(0).getOtherTrainsUpto() %>"
	name="<%=OTHER_TRAINS_UPTO %>" id="<%=OTHER_TRAINS_UPTO %>"
	maxlength="25" onkeyup="chkLength(this,25);"
	validate="Other trains Up to,string,no" tabindex="1"><%=leaveApplicationList.get(0).getOtherTrainsUpto() %></textarea>
<%}else{ %> <textarea value="" name="<%=OTHER_TRAINS_UPTO %>"
	id="<%=OTHER_TRAINS_UPTO %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Other trains Up to,string,no"
	tabindex="1"></textarea> <%} %>

<div class="Clear"></div>

<label>Transport Allowance</label> <select
	id="<%=DRAWING_TRANSPORT_ALLOWANCE %>"
	name="<%=DRAWING_TRANSPORT_ALLOWANCE %>"
	validate="Transport allowance,string,no" tabindex="1">
	<%if(leaveApplicationList.get(0).getDrawingTransportAllowance()!=null && !leaveApplicationList.get(0).getDrawingTransportAllowance().equals("")){
		if(leaveApplicationList.get(0).getDrawingTransportAllowance().equals("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">Yes</option>
	<%}else{ %>
	<option value="n">No</option>
	<option value="y" selected="selected">Yes</option>
	<%}}else{ %>
	<option value="n">No</option>
	<option value="y">Yes</option>
	<%}%>
</select></div>

<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('family-box1',expand_bca3);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca3 alt=Expand
	src="/hms/jsp/images/plus1.gif" ; align=left /> Employee Family Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=family-box1 style="display: none;">
<div class="blockframe">
<div style="float: left;"><input type="button" class="delbutton"
	value="" onclick="removeRowMedicalBoardUpdate(this,'amcDetailId')"
	align="right" /> <input type="button" class="addbutton" value=""
	onclick="generateRowMedicalBoardUpdate('amcDetailId');" align="right" />
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="amcDetailId">
	<tr>
		<th scope="col"><span>*</span>Select Family</th>
		<th scope="col">DOB</th>
		<th scope="col"><span>*</span>Age</th>
		<th scope="col"><span>*</span>Dependent POR No.</th>
	</tr>
	<tbody>
		<%
 String selectFamily="selectFamily";
 
 String agetemp="agetemp";
 
 String dobtemp="dobtemp";
 
 String dependentPorNo="dependentPorNo";
 
int inc=1;
String familylist[]={"","Self","Wife","C/A/12 Yrs","C/B/12 Yrs","Mother","Father","Brother","Sister"};
String familylistId[]={"","s","w","a","b","m","f","r","i"};
if(familyDetailsList !=null && familyDetailsList.size()>0){
	for(;inc<=familyDetailsList.size();inc++){
	selectFamily = selectFamily + inc;
	agetemp=agetemp + inc;
	dobtemp=dobtemp + inc;
	dependentPorNo=dependentPorNo + inc;%>
		<tr>
			<td width="10%" style="padding-left: 50px;"><input type="hidden"
				name="<%=FAMILY_ID%>"
				value="<%=familyDetailsList.get(inc-1).getId()%>"
				id="<%=FAMILY_ID%>" /> <select name="<%=FAMILY%>"
				value="<%=familyDetailsList.get(inc-1).getSelectFamily()%>"
				id="<%=selectFamily%>" onblur="fillValuesMedicalDetails(<%=inc%>);">
				<option value="">Select</option>
				<%	    if(familyDetailsList.get(inc-1).getSelectFamily()!=null && !familyDetailsList.get(inc-1).getSelectFamily().equals("")){
		for(int i=1;i<9;i++){
		    if(familyDetailsList.get(inc-1).getSelectFamily().equals(familylistId[i])){	
%>
				<option value="<%=familylistId[i] %>" selected="selected"><%=familylist[i] %></option>
				<%}else{ %>
				<option value="<%=familylistId[i] %>"><%=familylist[i] %></option>
				<%}}} %>
			</select></td>
			<td width="10%" style="padding-left: 50px;">
			<%if(familyDetailsList.get(inc-1).getDob()!=null){ %> <input
				type="text" name="<%=DATE_OF_BIRTH%>"
				value="<%=familyDetailsList.get(inc-1).getDob() %>" tabindex="2"
				id="<%=dobtemp%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);" /> <%}else{%> <input
				type="text" name="<%=DATE_OF_BIRTH%>" tabindex="2" id="<%=dobtemp%>"
				onBlur="fillValuesMedicalDetails(<%=inc%>);" /> <%} %>
			</td>
			<td width="10%" style="padding-left: 50px;">
			<%if(familyDetailsList.get(inc-1).getAge()!=null){ %> <input
				type="text" name="<%=AGE%>"
				value="<%=familyDetailsList.get(inc-1).getAge() %>" tabindex="2"
				id="<%=agetemp%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%}else{%>
			<input type="text" name="<%=AGE%>" tabindex="2" id="<%=agetemp%>"
				onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%} %>
			</td>
			<td width="10%" style="padding-left: 50px;">
			<%if(familyDetailsList.get(inc-1).getDependentPorNo()!=null){ %> <input
				type="text" name="<%=POR_NUMBER%>"
				value="<%=familyDetailsList.get(inc-1).getDependentPorNo() %>"
				tabindex="2" id="<%=dependentPorNo%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%}else{%>
			<input type="text" name="<%=POR_NUMBER%>" tabindex="2"
				id="<%=dependentPorNo%>" onkeyup="isNumber(this)"
				onBlur="fillValuesMedicalDetails(<%=inc%>);"
				onKeyDown="limitText(this,5);" onKeyUp="limitText(this,5);" /> <%} %>
			</td>

		</tr>
		<%}%>
		<input type="hidden" value="<%=inc-1%>" name="hiddenValue"
			id="hiddenValue" />
		<%}else{%>
		<tr>

			<td width="10%" style="padding-left: 50px;"><select
				name="<%=FAMILY%>" id="<%=FAMILY %>" validate="Family,string,yes">
				<option value="">Select</option>
				<option value="s">Self</option>
				<option value="w">Wife</option>
				<option value="a">C/A/12 Yrs</option>
				<option value="b">C/B/12 Yrs</option>
				<option value="m">Mother</option>
				<option value="f">Father</option>
				<option value="r">Brother</option>
				<option value="i">Sister</option>
			</select></td>

			<td width="10%" style="padding-left: 50px;"><input type="text"
				name="<%=DATE_OF_BIRTH %>" id="<%=DATE_OF_BIRTH%>"
				onKeyUp="mask(this.value,this,'2,5','/');"
				onchange="compareTimeAgendaPoints();" MAXLENGTH="10"
				validate="Date Of Birth,date,no"></td>


			<td width="10%" style="padding-left: 50px;"><input type="text"
				name="<%=AGE %>" id="<%=AGE%>" onKeyUp="isNumber(this);"
				validate="Age,string,yes"></td>


			<td width="10%" style="padding-left: 50px;"><input type="text"
				name="<%=POR_NUMBER %>" id="<%=POR_NUMBER %>"
				validate="Dependent POR No.,string,yes"></td>

		</tr>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		<%} %>
	</tbody>
</table>

</div>
</div>
<div class="Clear"></div>


<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('personal-box1',expand_bca4);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca4 alt=Expand
	src="/hms/jsp/images/minus1.gif" ; align=left /> Personal Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=personal-box1 style="display: block;">
<div class="blockFrame"><label><span>*</span>Full Name: </label> <%if(leaveApplicationList.get(0).getFullName()!=null && !leaveApplicationList.get(0).getFullName().equals("")){ %>
<input type="text"
	value="<%=leaveApplicationList.get(0).getFullName() %>"
	name="<%=FULL_NAME %>" id="<%=FULL_NAME %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Full Name,string,yes"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=FULL_NAME %>" id="<%=FULL_NAME %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Full Name,string,yes"
	tabindex="1" /> <%} %> <label><span>*</span>House Name: </label> <%if(leaveApplicationList.get(0).getHouseName()!=null && !leaveApplicationList.get(0).getHouseName().equals("")){ %>
<input type="text"
	value="<%=leaveApplicationList.get(0).getHouseName() %>"
	name="<%=HOUSE_NAME %>" id="<%=HOUSE_NAME %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="House Name,string,yes"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=HOUSE_NAME %>" id="<%=HOUSE_NAME %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="House Name,string,yes"
	tabindex="1" /> <%} %>

<div class="Clear"></div>

<label>Village: </label> <%if(leaveApplicationList.get(0).getVillage()!=null && !leaveApplicationList.get(0).getVillage().equals("")){ %>
<input type="text"
	value="<%=leaveApplicationList.get(0).getVillage() %>"
	name="<%=VILLAGE %>" id="<%=VILLAGE %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Village,string,no" tabindex="1" />
<%}else{ %> <input type="text" value="" name="<%=VILLAGE %>"
	id="<%=VILLAGE %>" maxlength="25" onkeyup="chkLength(this,25);"
	validate="Village,string,no" tabindex="1" /> <%} %> <label>PO: </label>
<%if(leaveApplicationList.get(0).getPo()!=null && !leaveApplicationList.get(0).getPo().equals("")){ %>
<input type="text" value="<%=leaveApplicationList.get(0).getPo() %>"
	name="<%=POST_OFFICE %>" id="<%=POST_OFFICE %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Post Office,string,no"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=POST_OFFICE %>" id="<%=POST_OFFICE %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Post Office,string,no"
	tabindex="1" /> <%} %>


<div class="Clear"></div>

<label>Telegraph Office: </label> <%if(leaveApplicationList.get(0).getTelegraphOffice()!=null && !leaveApplicationList.get(0).getTelegraphOffice().equals("")){ %>
<textarea value="<%=leaveApplicationList.get(0).getTelegraphOffice() %>"
	name="<%=TELEGRAPH_OFFICE %>" id="<%=TELEGRAPH_OFFICE %>"
	maxlength="25" onkeyup="chkLength(this,25);"
	validate="Telegraph office,string,no" tabindex="1"><%=leaveApplicationList.get(0).getTelegraphOffice() %></textarea>
<%}else{ %> <textarea value="" name="<%=TELEGRAPH_OFFICE %>"
	id="<%=TELEGRAPH_OFFICE %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Telegraph office,string,no"
	tabindex="1"></textarea> <%} %> <label>Police Station: </label> <%if(leaveApplicationList.get(0).getPoliceStation()!=null && !leaveApplicationList.get(0).getPoliceStation().equals("")){ %>
<textarea value="<%=leaveApplicationList.get(0).getPoliceStation() %>"
	name="<%=POLICE_STATION %>" id="<%=POLICE_STATION %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Post Office,string,no"
	tabindex="1"><%=leaveApplicationList.get(0).getTelegraphOffice() %></textarea>
<%}else{ %> <textarea value="" name="<%=POLICE_STATION %>"
	id="<%=POLICE_STATION %>" maxlength="25" onkeyup="chkLength(this,25);"
	validate="Post Office,string,no" tabindex="1"></textarea> <%} %>

<div class="Clear"></div>

<label><span>*</span>State:</label> <select id="<%=STATE %>"
	name="<%=STATE%>" tabindex="1"
	onChange="populateDistrict(this.value,'leaveApplicationUpdate')"
	validate="State,string,yes">
	<option value="">Select</option>
	<% 	    if(stateList!=null){
	    	for(MasState masState : stateList){
	 		if(leaveApplicationList.get(0).getState() != null ){
		 	if(leaveApplicationList.get(0).getState().getId() == masState.getId()){
		%>
	<option value="<%= masState.getId() %>" selected="selected"><%= masState.getStateName()%></option>
	<%}else{%>
	<option value="<%= masState.getId() %>"><%= masState.getStateName()%></option>
	<%}}else{%>
	<option value="<%= masState.getId() %>"><%= masState.getStateName()%></option>
	<%}}}%>
</select> <label><span>*</span>Distt:</label> <select id="<%=DISTRICT%>"
	name="<%=DISTRICT%>" tabindex="1" validate="District Name,string,yes">
	<option value="">Select</option>
	<% 	    if(cityList!=null){
	    	for(MasDistrict masDistrict : cityList){
	 		if(leaveApplicationList.get(0).getDistrictName() != null ){
		 	if(leaveApplicationList.get(0).getDistrictName().getId() == masDistrict.getId()){
		%>
	<option value="<%= masDistrict.getId() %>" selected="selected"><%= masDistrict.getDistrictName()%></option>
	<%}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}else{%>
	<option value="<%= masDistrict.getId() %>"><%= masDistrict.getDistrictName()%></option>
	<%}}}%>
</select> <label><span>*</span>PIN: </label> <%if(leaveApplicationList.get(0).getPin()!=null && !leaveApplicationList.get(0).getPin().equals("")){ %>
<textarea value="<%=leaveApplicationList.get(0).getPin() %>"
	name="<%=PINCODE %>" id="<%=PINCODE %>" maxlength="12"
	onkeyup="chkLength(this,12);" validate="Pincode,string,yes"
	tabindex="1"><%=leaveApplicationList.get(0).getPin() %></textarea> <%}else{ %>
<textarea value="" name="<%=PINCODE %>" id="<%=PINCODE %>"
	maxlength="12" onkeyup="chkLength(this,12);"
	validate="Pincode,string,yes" tabindex="1"></textarea> <%} %>

<div class="Clear"></div>

<label><span>*</span>Tele No: </label> <%if(leaveApplicationList.get(0).getPin()!=null && !leaveApplicationList.get(0).getPin().equals("")){ %>
<input type="text"
	value="<%=leaveApplicationList.get(0).getTelephoneNo() %>"
	name="<%=TELEPHONE_NO %>" id="<%=TELEPHONE_NO %>" maxlength="12"
	onkeyup="chkLength(this,12);" validate="Telephone No,phone,yes"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=TELEPHONE_NO %>" id="<%=TELEPHONE_NO %>" maxlength="12"
	onkeyup="chkLength(this,12);" validate="Telephone No,phone,yes"
	tabindex="1" /> <%} %> <label>Set Of CVs :</label> <%if(leaveApplicationList.get(0).getSetOfCv() != null){ %>
<input type="text"
	value="<%=leaveApplicationList.get(0).getSetOfCv() %>"
	name="<%=SET_OF_CVs %>" id="<%=SET_OF_CVs %>" maxlength="5"
	validate="CVs,string,no" tabindex="1" /> <%}else{ %> <input type="text"
	value="" name="<%=SET_OF_CVs %>" id="<%=SET_OF_CVs %>" maxlength="5"
	validate="CVs,string,no" tabindex="1" /> <%} %> <label>NRS :</label> <%if(leaveApplicationList.get(0).getNrs() != null) {%>
<input type="text" value="<%=leaveApplicationList.get(0).getNrs() %>"
	name="<%=NRS %>" id="<%=NRS %>" maxlength="5" validate="NRS,string,no"
	tabindex="1"> <%}else{ %> <input type="text" value=""
	name="<%=NRS %>" id="<%=NRS %>" maxlength="5" validate="NRS,string,no"
	tabindex="1"> <%} %>
</div>
</div>

<div class="clear"></div>

<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('ltc-box1',expand_bca1);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca1 alt=Expand
	src="/hms/jsp/images/plus1.gif" ; align=left /> Employee LTC Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=ltc-box1 style="display: none;">
<div class="blockFrame"><label>Year</label> <select
	id="<%=LTC_YEAR %>" name="<%=LTC_YEAR%>" validate="year,string,no"
	tabindex="1">
	<option value="">Select</option>
	<% for(int i=2009; i<=2029 ; i++){
			if(leaveApplicationList.get(0).getYear()!=null){
			if(leaveApplicationList.get(0).getYear()==i){
			%>
	<option value="<%=i%>" selected="selected"><%=i%></option>
	<%}else{ %>
	<option value="<%=i%>"><%=i %></option>
	<%}}else{ %>
	<option value="<%=i%>"><%=i %></option>
	<%}} %>
</select> <label>Previous Year LTC Details</label> <select
	id="<%=PREVIOUS_YEAR_LTC_DETAILS %>"
	name="<%=PREVIOUS_YEAR_LTC_DETAILS%>"
	validate="Previous Year LTC,string,no" tabindex="1">
	<option value="">Select</option>
	<% for(int i=2000; i<=2009 ; i++){
			if(leaveApplicationList.get(0).getPreviousYear()!=null){
			    if(leaveApplicationList.get(0).getPreviousYear()==i){
			%>
	<option value="<%=i%>" selected="selected"><%=i%></option>
	<%}else{ %>
	<option value="<%=i%>"><%=i %></option>
	<%}}else{ %>
	<option value="<%=i%>"><%=i %></option>
	<%}} %>
</select> <label>Under TR: </label> <%if(leaveApplicationList.get(0).getNrs() != null) {%>
<textarea value="<%=leaveApplicationList.get(0).getUnderTr()%>"
	name="<%=UNDER_TR %>" id="<%=UNDER_TR %>" maxlength="30"
	onkeyup="chkLength(this,30);" validate="Under TR,string,no"
	tabindex="1"><%=leaveApplicationList.get(0).getUnderTr()%></textarea> <%}else{ %>
<textarea value="" name="<%=UNDER_TR %>" id="<%=UNDER_TR %>"
	maxlength="30" onkeyup="chkLength(this,30);"
	validate="Under TR,string,no" tabindex="1"></textarea> <%} %>
</div>
</div>
<div class="Clear"></div>


<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('train-box1',expand_bca2);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca2 alt=Expand
	src="/hms/jsp/images/plus1.gif" ; align=left /> Employee's Train
Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=train-box1 style="display: none;">
<div class="blockFrame"><label>Class:</label> <%String classarray[]={"","1AC","2AC","3AC","FC","SL"}; %>
<select name="<%=TRAIN_CLASS %>" id="<%=TRAIN_CLASS %>" tabindex="1">
	<option value="">Select</option>
	<%for(int i=1;i<6;i++){
	if(leaveApplicationList.get(0).getTrainClass()!=null){
	if(leaveApplicationList.get(0).getTrainClass().equals(classarray[i])){
	%>
	<option value="<%=leaveApplicationList.get(0).getTrainClass() %>"
		selected="selected"><%=leaveApplicationList.get(0).getTrainClass()%></option>
	<%}else{ %>
	<option value="<%=classarray[i] %>"><%=classarray[i]%></option>
	<%}}else{ %>
	<option value="<%=classarray[i] %>"><%=classarray[i]%></option>
	<%}} %>
</select> <label>Ticket For Side:</label> <select name="<%=TICKET_FOR_SIDE %>"
	id="<%=TICKET_FOR_SIDE %>" tabindex="1">
	<option value="">Select</option>
	<%if(leaveApplicationList.get(0).getTicketForSide()!=null){
  	if(leaveApplicationList.get(0).getTicketForSide().equals("o")){%>
	<option value="o" selected="selected">One Way</option>
	<option value="b">Both Side</option>
	<%}else if(leaveApplicationList.get(0).getTicketForSide().equals("b")){ %>
	<option value="o">One Way</option>
	<option value="b" selected="selected">Both Side</option>
	<%}else if(true){ %>
	<option value="o">One Way</option>
	<option value="b">Both Side</option>
	<%}}else{ %>
	<option value="o">One Way</option>
	<option value="b">Both Side</option>
	<%} %>
</select> <label>Return Journey Valid Upto: </label> <%if(leaveApplicationList.get(0).getReturnJourneyValidUpto()!=null && !leaveApplicationList.get(0).getReturnJourneyValidUpto().equals("")){%>
<textarea
	value="<%=leaveApplicationList.get(0).getReturnJourneyValidUpto() %>"
	name="<%=RETURN_JOURNEY_VALID_UPTO %>"
	id="<%=RETURN_JOURNEY_VALID_UPTO %>" maxlength="30"
	onkeyup="chkLength(this,30);" validate="Return Journey Valid,string,no"
	tabindex="1"><%=leaveApplicationList.get(0).getReturnJourneyValidUpto() %></textarea>
<%}else{ %> <textarea value="" name="<%=RETURN_JOURNEY_VALID_UPTO %>"
	id="<%=RETURN_JOURNEY_VALID_UPTO %>" maxlength="30"
	onkeyup="chkLength(this,30);" validate="Return Journey Valid,string,no"
	tabindex="1"></textarea> <%} %>
</div>
</div>

<div class="Clear"></div>
<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('leave-box1',expand_bca5);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca5 alt=Expand
	src="/hms/jsp/images/plus1.gif" ; align=left /> Employee Leave Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=leave-box1 style="display: none;">
<div class="tableHolderAuto">
<div class="blockFrame">
<table width="60%" border="0" cellspacing="0" cellpadding="0"
	id="amcDetailId">
	<tr>
		<th scope="col">Leave Type</th>
		<th scope="col">Leave Balance Till Date</th>
		<th scope="col">Leave Availed Till Date</th>
	</tr>
	<tbody>
		<% int i=0;
		if(leaveTypeList.size()>0){
	   for(HrLeaveTypeMaster  hrleavetypemaster:leaveTypeList){
		  i++; 
       if(hrorderlyleaveaccountList.size()>0){
        boolean flag=true;	   
       for(HrorderlyLeaveAccount hrorderlyleaveaccount :hrorderlyleaveaccountList ){
	   if(!(hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type"))&& 
			   hrorderlyleaveaccount.getLeaveTypeId().equals(hrleavetypemaster.getId()) ){
%>
		<tr>
			<td width="10%"><label><%=hrleavetypemaster.getDetails() %></label>
			</td>

			<td width="10%">
			<%if(hrorderlyleaveaccount.getOLeaveBalance()!=null && hrorderlyleaveaccount.getEntitledLeave()!=null  ){ %>
			<input type="text" name="Carryleave<%=i %>" tabindex="1"
				id="Carryleave<%=i %>"
				value="<%=hrorderlyleaveaccount.getOLeaveBalance()+hrorderlyleaveaccount.getEntitledLeave()-hrorderlyleaveaccount.getLeaveAvailed() %>"
				readonly="readonly" onchange="compareTimeAgendaPoints();"
				MAXLENGTH="10"> <%}%>
			</td>

			<td width="10%">
			<%if(hrorderlyleaveaccount.getLeaveAvailed()!=null){ %> <input
				type="text" name="Availed<%=i %>" tabindex="1" id="Availed<%=i %>"
				value="<%=hrorderlyleaveaccount.getLeaveAvailed() %>" id=""
				readonly="readonly"> <%}%>
			</td>
		</tr>
		<% flag=false;
	}} if(flag && !hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type")){%>
		<tr width="10%">
			<td><label><%= hrleavetypemaster.getDetails()%></label></td>
			<td width="10%"><input type="text" name="Carryleave<%=i %>"
				tabindex="1" id="Carryleave<%=i %>" readonly="readonly"
				MAXLENGTH="10" /></td>
			<td width="10%"><input type="text" name="Availed<%=i %>"
				tabindex="1" id="Availed<%=i %>" readonly="readonly"/ ></td>

		</tr>

		<%}}else{
      if(!hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type")){
%>
		<tr width="10%">
			<td><label><%= hrleavetypemaster.getDetails()%></label></td>
			<td width="10%"><input type="text" name="Carryleave<%=i %>"
				tabindex="1" id="Carryleave<%=i %>" readonly="readonly"
				MAXLENGTH="10" /></td>
			<td width="10%"><input type="text" name="Availed<%=i %>"
				tabindex="1" id="Availed<%=i %>" readonly="readonly"/ ></td>

		</tr>
		<%}}}} %>
		<input type="hidden" name="hrleavetypemasterlist" tabindex="1"
			id="hrleavetypemasterlist" value="<%=leaveTypeList.size()%>" />

	</tbody>
</table>
</div>
</div>
</div>

<div class="division"></div>

<div class="bottom"><input type="button" class="cmnbutton"
	value="Update"
	onclick="if(checkToDate() && checkLeaveAvailed() && checkForLeaveRestriction()){submitForm('leaveApplicationUpdate','hrOrderly?method=editLeaveApplicationUpdate');}"
	align="right" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="cmnbutton" onclick="resetCheck();" accesskey="r" />
<input type="button" class="cmnbutton" value="Search"
	onclick="window.open('hrOrderly?method=showSearchLeaveApplicationJsp');"
	align="right" /> <input type="button" name="Print Leave Application"
	id="Print Leave Application" class="cmnbutton"
	value="Print Leave Application "
	onclick="submitForm('leaveApplicationUpdate','hrOrderly?method=generateLeaveApplicationReport');" />
<input class="cmnbutton" id=reset accessKey=r type=reset
	value="Print Application For CV Family"
	onclick="submitForm('leaveApplicationUpdate','hrOrderly?method=printApplicationForCV');">
<input class="cmnbutton" id=reset accessKey=r type=reset
	value="Print Issue of FRW For LTC"
	onclick="submitForm('leaveApplicationUpdate','hrOrderly?method=printIssueofFRW');">
<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
</div>

<script type="text/javascript">

function checkFromDate(){
	
	var date=document.getElementById("fromDate").value;
	
	var inputDate=new Date(date.substring(6),(date.substring(3,5) - 1) ,date.substring(0,2));
	var currentDate=new Date();
	if(inputDate < currentDate)
	{
		return false;
	}
	else
	{
	alert("From Date should be greater than current date!!");
	document.getElementById("fromDate").focus();
	return true;
	}
	
}

function checkToDate(){
   
    var strValue = document.getElementById("toDate").value;
    var strTodate = document.getElementById("fromDate").value;
    toDate= new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2)); 	
 	fromDate=new Date(strTodate.substring(6),(strTodate.substring(3,5) - 1) ,strTodate.substring(0,2));
 	
 	if(fromDate > toDate)
 	{
 	alert("From date can not be greater than To date");
		return false;
 	}
	else if(fromDate == toDate)
	 return true;
	 else 
	 return true;
}

function addlCheckToDate(){
   
    var strValue = document.getElementById("addlToDate").value;
    var strTodate = document.getElementById("addlFromDate").value;
    addlToDate= new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2)); 	
 	addlFromDate=new Date(strTodate.substring(6),(strTodate.substring(3,5) - 1) ,strTodate.substring(0,2));
 	
 	if(addlFromDate > addlToDate)
 	{
 	alert("Addl From Date can not be greater than addl To Date");
		return false;
 	}
 	else if(addlFromDate == addlToDate)
	 return true;
	else 
	 return true;
}

	function generateRowMedicalBoardUpdate(idName) {
		document.getElementById("noOfRecords").value = parseInt(document.getElementById("noOfRecords").value)+1	
		var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[0].value=d.length-2;
		var temp=d.length-1
		document.getElementById('hiddenValue').value=d.length-2
		//tblCtrl[1].name="unfit"+d.length-1;		
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
			
			
		}
  
   function removeRowMedicalBoardUpdate()
	{
	
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >=1){
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }else{
	  alert("There should be atleast one row")
	  }
	}
	
	function checkForLeaveRestriction()
		{ 
	
			if(leave_restriction_array.length>0)
			{ 
				for(i=0;i<leave_restriction_array.length;i++)
				{
				 var t1=document.getElementById("fromDate").value
				 fromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
			
				 var t2=leave_restriction_array[i][0]
				 frmD = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
			
				 var t3=leave_restriction_array[i][1]
				 tD = new Date(t3.substring(6),(t3.substring(3,5) - 1) ,t3.substring(0,2));
				    if( document.getElementById('leaveType').value == leave_restriction_array[i][2]){
					if((fromDate > frmD) && (fromDate < tD)  && (parseInt(document.getElementById('totalDays').value)  > parseInt(leave_restriction_array[i][3])))
					{
						alert("You can not take more than"+ parseInt(leave_restriction_array[i][3]) +"leaves");
						document.getElementById('fromDate').value = "";
						document.getElementById('fromDate').focus();
						return false;
					}
					}
					
				}
			}
			
			return true;
		}
		
            
 
leave_restriction_array = new Array();
<%int  counter=0;%>

<% if (leaveRestrictionEntryList != null && leaveRestrictionEntryList.size() > 0) {
%>
<% 	for(LeaveRestrictionEntry leaveRestrictionEntry : leaveRestrictionEntryList){
%>
leave_restriction_array[<%= counter%>] = new Array();
leave_restriction_array[<%= counter%>][0] = "<%=HMSUtil.convertDateToStringWithoutTime(leaveRestrictionEntry.getFromPeriod())%>"
leave_restriction_array[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(leaveRestrictionEntry.getToPeriod())%>"
leave_restriction_array[<%= counter%>][2] = "<%=leaveRestrictionEntry.getLeave()%>"
leave_restriction_array[<%= counter%>][3] = "<%=leaveRestrictionEntry.getMaxLeaveDays()%>"
<%
counter++;
}
}
%>


function checkLeaveAvailed()
{
 var leavetypeid=document.getElementById('leaveType').value
 for(i=0;i<leaveArray.length;i++){
/* alert("id"+leavetypeid+"leaveArray[i][0]"+leaveArray[i][0]+"totalDays"+document.getElementById('totalDays').value);*/
 if(leavetypeid==leaveArray[i][0]){
 	if(leaveArray[i][1]<parseInt(document.getElementById('totalDays').value)){
 	alert("Your Leave Account Less Then Applyed");
 	document.getElementById('fromDate').value="";
 	document.getElementById('toDate').value="";
 	document.getElementById('totalDays').value="";
 	document.getElementById('fromDate').focus();
 	return false;
 	  
 	}
 }
}
return true;
}

	
	
	
	</script></form>
