<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveApplication"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.LeaveRestrictionEntry"%>
<%@page import="jkt.hms.masters.business.EmpLeaveBalance"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveAccount"%>
<%@page import="jkt.hms.masters.business.TrainClassGroup"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<form name="leaveApplication" method="post" action=""><script
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
function compareTimeAgendaPoints()
{


var dateOfBirth =document.getElementById('<%=DATE_OF_BIRTH%>').value;
var currentDate = document.getElementById('entryDateId').value;

var current =new Date(currentDate.substring(6),(currentDate.substring(3,5) - 1) ,currentDate.substring(0,2))
var DateOfBir =new Date(dateOfBirth.substring(6),(dateOfBirth.substring(3,5) - 1) ,dateOfBirth.substring(0,2))

 if(DateOfBir > current)
{
alert("Date Of Birth Should be less than CurrentDate");
document.getElementById('<%=DATE_OF_BIRTH%>').value="";
document.getElementById('<%=DATE_OF_BIRTH%>').focus();
return false;
}   
return true;
}


</script> <%

int hiddenValueCharge = 0;
int sum = 0;
int abc = 0;
String leaveType1 = null;
String previousPage="no";
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
System.out.println("hidden value charge"+hiddenValueCharge);
List<HrLeaveTypeMaster> leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
List<MasDistrict> cityList=new ArrayList<MasDistrict>();
List<MasState> stateList=new ArrayList<MasState>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
List<HrorderlyLeaveApplication> leaveApplicationRecordList = new ArrayList<HrorderlyLeaveApplication>();
List<LeaveRestrictionEntry> leaveRestrictionEntryList = new ArrayList<LeaveRestrictionEntry>();
List<EmpLeaveBalance> empLeaveBalanceList = new ArrayList<EmpLeaveBalance>();
List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
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

if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
System.out.println("employeeList-------- "+employeeList.size());
if(map.get("leaveApplicationList") != null){
	leaveApplicationList = (List<HrorderlyLeaveApplication>)map.get("leaveApplicationList");
	}
if(map.get("leaveApplicationRecordList") != null){
	leaveApplicationRecordList = (List<HrorderlyLeaveApplication>)map.get("leaveApplicationRecordList");
	}
if(map.get("leaveRestrictionEntryList") != null){
	leaveRestrictionEntryList = (List<LeaveRestrictionEntry>)map.get("leaveRestrictionEntryList");
	}
if(map.get("empLeaveBalanceList") != null){
	empLeaveBalanceList = (List<EmpLeaveBalance>)map.get("empLeaveBalanceList");
	}
if(map.get("trainclassgroupList") != null){
	trainclassgroupList = (List<TrainClassGroup>)map.get("trainclassgroupList");
	}
System.out.println("leaveRestrictionEntryList in jsp is "+leaveRestrictionEntryList.size());


String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
	}
int id =  0;
if(map.get("Id")!= null){
	id= (Integer)map.get("Id");
	System.out.println("id in jsp is "+id);
	
}
int leaveAppId =  0;
if(map.get("leaveAppId")!= null){
	leaveAppId= (Integer)map.get("leaveAppId");
	System.out.println("leaveid in jsp is "+leaveAppId);
}
System.out.println("leaveAppId   "+leaveAppId);
String message="";
%> <script type="text/javascript">
	function generateRowMedicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
					
			
}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >=1){
	
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	  else
	  alert("There should be atleast one row")
	  
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
    function calDays()
    {    
       var t1=document.getElementById("fromDate").value
       var t2=document.getElementById("toDate").value
       if(t1!='' && t2!=''){
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
            document.getElementById("totalDays").value=time+1;
          }
       }
       catch(e) {}
       }else{
       document.getElementById("totalDays").value='';
       }
       return false;
    }

 function calAddlDays()
    {    
       var t1=document.getElementById("addlFromDate").value
       var t2=document.getElementById("addlToDate").value
       if(t1!='' && t2!=''){
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
            document.getElementById("addlTotalDays").value=time+1;
          }
       }
       catch(e) {}
       }else{
       document.getElementById("addlTotalDays").value='';
       }
       return false;
    }



</script>




<div id="contentHolder">
<%if(map.get("message") != null){
 	message = (String)map.get("message");
 	%> <br />
<h2 style="color: #AC1400; width: 300;"><%=message %></h2>
<div class="clear"></div>

<%} %>
<h6>Leave Application Entry</h6>
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
<%} %> </label>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Entry No.</label> <label
	class="value"><%=entryNo %></label> <input type=hidden
	name="<%=ENTRY_NO %>" value="<%=entryNo %>" /> <%if(employeeList.get(0).getDisciplinePending()!=null){ %>
<input type=hidden name="dcp" id="dcp"
	value="<%=employeeList.get(0).getDisciplinePending() %>" /> <%}else{ %>
<input type=hidden name="dcp" id="dcp" value="n" /> <%}%> <label><span>*</span>Application
Date</label> <input type="text" id="entryDateId" name="<%=ENTRY_DATE %>"
	value="<%=date %>" readonly="readonly" tabindex="1" /> <input
	type="hidden" name="id" value="<%=id %>"> <input type="hidden"
	name="leaveAppId" value="<%=leaveAppId %>"> <label><span>*</span>
Leave Type</label> <select id="leaveType" name="<%=LEAVE_TYPE%>"
	validate="Leave Type,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%if(leaveTypeList.size()>0){
			for(HrLeaveTypeMaster hrLeaveType : leaveTypeList){
				if(!(hrLeaveType.getLeaveType().equalsIgnoreCase("All Type"))){
			%>
	<option value="<%=hrLeaveType.getId() %>"><%=hrLeaveType.getLeaveType()%></option>
	<%}
				}
			}%>
</select>

<div class="Clear"></div>

<label> <span>*</span> From Date</label> <input type="text"
	class="calDate" id="fromDate" name="<%=LEAVE_FROM_DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" tabindex="1"
	validate="From Date ,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplication.<%=LEAVE_FROM_DATE%>,event)" />

<label> <span>*</span> To Date</label> <input type="text"
	class="calDate" id="toDate" name="<%=LEAVE_TO_DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" tabindex="1"
	validate="To Date ,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplication.<%=LEAVE_TO_DATE%>,event)" />

<label> <span>*</span> Total Days</label> <input type="text"
	id="totalDays" name="<%=LEAVE_DAYS %>"
	onfocus="calDays(); checkForLeaveRestriction();" value=""
	readonly="readonly" tabindex="1" validate="Total Days ,int,yes"
	onblur="checkLeaveAvailed()" />

<div class="Clear"></div>

<label> Addl Leave From Date</label> <input type="text" class="calDate"
	id="addlFromDate" name="<%=ADDL_LEAVE_FROM_DATE %>" value=""
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplication.<%=ADDL_LEAVE_FROM_DATE%>,event)" />

<label>Addl Leave To Date</label> <input type="text" class="calDate"
	id="addlToDate" name="<%=ADDL_LEAVE_TO_DATE %>" value="" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.leaveApplication.<%=ADDL_LEAVE_TO_DATE%>,event)" />

<label>Addl Leave Total Days</label> <input type="text"
	id="addlTotalDays" value="" onfocus="calAddlDays();"
	name="<%=ADDL_LEAVE_DAYS %>" readonly="readonly" tabindex="1" />

<div class="Clear"></div>

<label>Application Type</label> <select id="<%=TYPE %>"
	name="<%=TYPE %>" validate="Type,string,no" tabindex="1">
	<option value="">Select</option>
	<option value="f">FRW</option>
	<option value="c">CV</option>
</select> <label>Required From</label> <select id="<%=REQUIRED_FROM %>"
	name="<%=REQUIRED_FROM %>" validate="Required From,string,no"
	tabindex="1">
	<option value="0">Select</option>
	<%if(cityList.size()>0){
			for(MasDistrict masDistrict : cityList){
			%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
	<%}
			}%>
</select> <label>City To</label> <select id="<%=CITY_TO %>" name="<%=CITY_TO %>"
	validate="City To,string,no" tabindex="1">
	<option value="0">Select</option>
	<%if(cityList.size()>0){
			for(MasDistrict masDistrict : cityList){
			%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
	<%}
			}%>
</select>

<div class="Clear"></div>

<label>Rajdhani/Sha.up to</label> <select id="<%=RAJDHANI_UPTO %>"
	name="<%=RAJDHANI_UPTO %>" tabindex="1">
	<option value="0">Select</option>
	<%if(cityList.size()>0){
			for(MasDistrict masDistrict : cityList){
			%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
	<%}
			}%>
</select> <label>Availing LTC </label> <select id="<%=AVAILING_LTC %>"
	name="<%=AVAILING_LTC %>" validate="Ltc,string,no" tabindex="1">
	<option value="n">No</option>
	<option value="y">Yes</option>
</select> <label>Other Trains up to: </label> <textarea value=""
	name="<%=OTHER_TRAINS_UPTO %>" id="<%=OTHER_TRAINS_UPTO %>"
	maxlength="25" onkeyup="chkLength(this,25);"
	validate="Other trains Up to,string,no" tabindex="1"></textarea>

<div class="Clear"></div>

<label>Transport Allowance</label> <select
	id="<%=DRAWING_TRANSPORT_ALLOWANCE %>"
	name="<%=DRAWING_TRANSPORT_ALLOWANCE %>"
	validate="Transport allowance,string,no" tabindex="1">
	<option value="n">No</option>
	<option value="y">Yes</option>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>


<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('Family-box1',expand_bca3);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca3 alt=Expand
	src="/hms/jsp/images/minus1.gif" ; align=left /> Employee Family
Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=Family-box1 style="display: block;">
<div class="blockFrame">
<div style="float: left;"><input type="button" class="delbutton"
	value="" onclick="removeRowMedicalBoard1(this,'amcDetailId')"
	align="right" /> <input type="button" class="addbutton" value=""
	onclick="generateRowMedicalBoard1('amcDetailId');" align="right" /> <input
	type="hidden" size="1" value="0" name="noOfRecords" id="noOfRecords" />
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="amcDetailId">
	<tr>
		<th scope="col"><span>*</span>Select Family</th>
		<th scope="col">DOB</th>
		<th scope="col"><span>*</span>Age</th>
		<th scope="col"><span>*</span>Dependent POR No.</th>
	</tr>
	<tbody>

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
	src="/hms/jsp/images/minus1.gif" ; align=left /> Employee Contact
Detail During Leave</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=personal-box1 style="display: block;">
<div class="blockFrame"><label><span>*</span>Full Name: </label> <input
	type="text" value="" name="<%=FULL_NAME %>" id="<%=FULL_NAME %>"
	maxlength="50" onkeyup="chkLength(this,50);"
	validate="Full Name,string,yes" tabindex="1" /> <label><span>*</span>House
Name: </label> <input type="text" value="" name="<%=HOUSE_NAME %>"
	id="<%=HOUSE_NAME %>" maxlength="50" onkeyup="chkLength(this,50);"
	validate="House Name,string,yes" tabindex="1" />

<div class="Clear"></div>

<label>Village: </label> <input type="text" value=""
	name="<%=VILLAGE %>" id="<%=VILLAGE %>" maxlength="25"
	onkeyup="chkLength(this,25);" validate="Village,string,no" tabindex="1" />
<label>PO: </label> <input type="text" value="" name="<%=POST_OFFICE %>"
	id="<%=POST_OFFICE %>" maxlength="25" onkeyup="chkLength(this,25);"
	validate="Post Office,string,no" tabindex="1" />
<div class="Clear"></div>

<label>Telegraph Office: </label> <textarea value=""
	name="<%=TELEGRAPH_OFFICE %>" id="<%=TELEGRAPH_OFFICE %>"
	maxlength="25" onkeyup="chkLength(this,25);"
	validate="Telegraph office,string,no" tabindex="1"></textarea> <label>Police
Station: </label> <textarea value="" name="<%=POLICE_STATION %>"
	id="<%=POLICE_STATION %>" maxlength="25" onkeyup="chkLength(this,25);"
	validate="Post Office,string,no" tabindex="1"></textarea>

<div class="Clear"></div>

<label><span>*</span>State:</label> <select id="<%=STATE %>"
	name="<%=STATE%>" tabindex="1" validate="State,string,yes"
	onChange="populateDistrict(this.value,'leaveApplication')">
	<option value="0">Select</option>
	<%if(stateList.size()>0){
			for(MasState masState : stateList){
			%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName()%></option>
	<%}
			}%>
</select> <label><span>*</span>Distt:</label> <select id="<%=DISTRICT %>"
	name="<%=DISTRICT %>" tabindex="1" validate="District Name,string,yes">
	<option value="0">Select</option>
	<%if(cityList.size()>0){
			for(MasDistrict masDistrict : cityList){
			%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
	<%}
			}%>
</select> <label><span>*</span>PIN: </label> <input type="text" value=""
	name="<%=PINCODE %>" id="<%=PINCODE %>" onKeyUp="isNumber(this);"
	maxlength="12" onkeyup="chkLength(this,12);"
	validate="Pincode,string,yes" tabindex="1" />

<div class="Clear"></div>

<label><span>*</span>Tele No: </label> <input type="text" value=""
	name="<%=TELEPHONE_NO %>" id="<%=TELEPHONE_NO %>"
	onKeyUp="isNumber(this);" maxlength="12" onkeyup="chkLength(this,12);"
	validate="Telephone No,phone,yes" tabindex="1" /> <label>Set
Of CVs :</label> <input type="text" name="<%=SET_OF_CVs %>"
	id="<%=SET_OF_CVs %>" maxlength="5" validate="CVs,string,no"
	tabindex="1" /> <label>NRS :</label> <input type="text"
	name="<%=NRS %>" id="<%=NRS %>" maxlength="5" validate="NRS,string,no"
	tabindex="1"></div>
</div>
<div class="Clear"></div>
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
	<%
				for(int i=2009; i<=2029 ; i++){
			%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
</select> <label>Previous Year LTC Details</label> <select
	id="<%=PREVIOUS_YEAR_LTC_DETAILS %>"
	name="<%=PREVIOUS_YEAR_LTC_DETAILS%>"
	validate="Previous Year LTC,string,no" tabindex="1">
	<option value="">Select</option>
	<%
				for(int i=2000; i<=2009 ; i++){
			%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> <label>Under TR: </label> <textarea value="" name="<%=UNDER_TR %>"
	id="<%=UNDER_TR %>" maxlength="30" onkeyup="chkLength(this,30);"
	validate="Under TR,string,no" tabindex="1"></textarea></div>
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
<div class="blockFrame"><label>Class:</label> <select
	name="<%=TRAIN_CLASS %>" id="<%=TRAIN_CLASS %>" tabindex="1">
	<option value="">Select</option>
	<%if(trainclassgroupList!=null &&trainclassgroupList.size()>0){
	for(TrainClassGroup trainclassgroup:trainclassgroupList){
	%>
	<option value="<%=trainclassgroup.getTrainClasses() %>"><%=trainclassgroup.getTrainClasses() %></option>
	<%}}else{ %>
	<option value="1AC">1AC</option>
	<option value="2AC">2AC</option>
	<option value="3AC">3AC</option>
	<option value="FC">FC</option>
	<option value="SL">SL</option>
	<%} %>
</select> <label>Ticket For Side:</label> <select name="<%=TICKET_FOR_SIDE %>"
	id="<%=TICKET_FOR_SIDE %>" tabindex="1">
	<option value="">Select</option>
	<option value="o">One Way</option>
	<option value="b">Both Side</option>
</select> <label>Return Journey Valid Upto: </label> <textarea value=""
	name="<%=RETURN_JOURNEY_VALID_UPTO %>"
	id="<%=RETURN_JOURNEY_VALID_UPTO %>" maxlength="30"
	onkeyup="chkLength(this,30);" validate="Return Journey Valid,string,no"
	tabindex="1"></textarea></div>
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

<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkDiscipline() && checkLeaveAvailed() && checkForLeaveRestriction() && checkForPreviousLeaveRecord()){submitForm('leaveApplication','hrOrderly?method=addLeaveApplication', 'checkFromDate','checkToDate','checkForLeaveRestriction')};"
	align="right" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" class="button" value="Search"
	onclick="window.open('hrOrderly?method=showSearchLeaveApplicationJsp');"
	align="right" /> <%if (entryNo==""){ %> <input type="button"
	class="button" value="Back"
	onclick="submitLeaveApplication('leaveApplication');" align="right" />
<%} %>
<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<script type="text/javascript">

function checkFromDate(){
	
	var date=document.getElementById("fromDate").value;
	
	var inputDate=new Date(date.substring(6),(date.substring(3,5) - 1) ,date.substring(0,2));
	var currentDate=new Date();
	if(inputDate < currentDate)
	{
	alert("From Date should be greater than current date!!");
		return false;
	}
	else
	{
	
	document.getElementById("fromDate").focus();
	return true;
	}
	
}

function submitLeaveApplication(formName){
    obj = eval('document.'+formName)
    var url;
	  url = "/hms/hms/hrOrderly?method=searchLeaveApplication&appId=A578";
    obj.action = url;
    obj.submit();
	
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

function checkDiscipline()
{
if(document.getElementById('dcp').value=='y')
{alert("Your Discipline is pending");
return false;
}else{
return true;
}
}


   
		function checkForLeaveRestriction()
		{ 
	
			if(leave_restriction_array.length>0)
			{ 
			   	 var t1=document.getElementById("fromDate").value
				 fromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
				 
				 var t4 = document.getElementById("toDate").value
				 toD=new Date(t4.substring(6),(t4.substring(3,5)-1),t4.substring(0,2));
				
				for(i=0;i<leave_restriction_array.length;i++)
				{
				 
			
				 var t2=leave_restriction_array[i][0]
				 frmD = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
			
				 var t3=leave_restriction_array[i][1]
				 tD = new Date(t3.substring(6),(t3.substring(3,5) - 1) ,t3.substring(0,2));
				 
				 
				    if( document.getElementById('leaveType').value == leave_restriction_array[i][2]){
					if(( ((fromDate > frmD)&&(fromDate < tD)) || ((toD>frmD) &&(toD<tD)) )  && (parseInt(document.getElementById('totalDays').value)  > parseInt(leave_restriction_array[i][3])))
					{
						alert("Your leave Application is in restricted period "+t2+" ::to:: "+t3+"You can not take more than " + parseInt(leave_restriction_array[i][3]) + " days leaves");
						document.getElementById('fromDate').value = "";
						document.getElementById('toDate').value = "";
						document.getElementById('totalDays').value = "";
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
 	for(LeaveRestrictionEntry leaveRestrictionEntry : leaveRestrictionEntryList){
%>
leave_restriction_array[<%= counter%>] = new Array();
leave_restriction_array[<%= counter%>][0] = "<%=HMSUtil.convertDateToStringWithoutTime(leaveRestrictionEntry.getFromPeriod())%>"
leave_restriction_array[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(leaveRestrictionEntry.getToPeriod())%>"
leave_restriction_array[<%= counter%>][2] = "<%=leaveRestrictionEntry.getLeave().getId()%>"
leave_restriction_array[<%= counter%>][3] = "<%=leaveRestrictionEntry.getMaxLeaveDays()%>"
<%
counter++;
}
}
%>

function checkForPreviousLeaveRecord()
		{ 
	
			if(previous_leave_application.length>0)
			{  
			   	 var t1=document.getElementById("fromDate").value
				 fromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
				 
				 var t4 = document.getElementById("toDate").value
				 toD=new Date(t4.substring(6),(t4.substring(3,5)-1),t4.substring(0,2));
				
				for(i=0;i<previous_leave_application.length;i++)
				{
				 
			
				 var t2=previous_leave_application[i][1]
				 frmD = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
			
				 var t3=previous_leave_application[i][2]
				 tD = new Date(t3.substring(6),(t3.substring(3,5) - 1) ,t3.substring(0,2));
				 
				 
				   
					if( ((fromDate > frmD)&&(fromDate < tD)) || ((toD>frmD) &&(toD<tD)) ) 
					{
						alert("Your leave Application is in between previous leave from period "+t2+" ::to:: "+t3+"You can not apply leave in between your previous leave  ");
						document.getElementById('fromDate').value = "";
						document.getElementById('toDate').value = "";
						document.getElementById('totalDays').value = "";
						document.getElementById('fromDate').focus();
						return false;
					}
					
					
				}
			}
			
			return true;
		}
previous_leave_application = new Array();
<% int counter11=0; 
if(leaveApplicationRecordList!=null && leaveApplicationRecordList.size()!=0){
	for(HrorderlyLeaveApplication leaveApplicationRecord :leaveApplicationRecordList){
%>
previous_leave_application[<%=counter11%>]= new Array();
previous_leave_application[<%=counter11%>][0]="<%=leaveApplicationRecord.getLeave().getId()%>"
previous_leave_application[<%=counter11%>][1]="<%=HMSUtil.convertDateToStringWithoutTime(leaveApplicationRecord.getLeaveFromDate())%>"
previous_leave_application[<%=counter11%>][2]="<%=HMSUtil.convertDateToStringWithoutTime(leaveApplicationRecord.getDateOfReporting())%>"
<%	counter11++ ;
}}%>   

<%if (leaveApplicationList != null && leaveApplicationList.size() > 0) {
    System.out.println("in leaveApplicationList");
	for(HrorderlyLeaveApplication masLeave : leaveApplicationList){

if(masLeave.getStatus().trim().equalsIgnoreCase("y") && masLeave.getEmployee().getId()== id && masLeave.getLeave().getLeaveType().equals("AL"))
{
	
	sum = sum + Integer.parseInt(masLeave.getLeaveTotalDays());
	leaveType1 = leaveType1 + (masLeave.getLeave().getLeaveType());
	System.out.println("sum= "+sum);
	System.out.println("leaveType1= "+leaveType1);
}
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
