<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@ page import="jkt.hms.masters.business.MasMajorWorkDetail"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


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

<%	



String 	userName="";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int Id=0;
	if(map.get("Id")!=null){
		Id=(Integer)map.get("Id");
		System.out.println("IDDDDDDDD"+Id);
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");
	
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
    if (map.get("departmentTypeList") != null) {
       masDepartmentList = (List) map.get("departmentTypeList");
    }
	
	List<MasMajorWorkDetail> masMajorWorkDetailList = new ArrayList<MasMajorWorkDetail>();
		
	if(map.get("majorWorkDetailList")!=null)
	{
		masMajorWorkDetailList = (List) map.get("majorWorkDetailList");
	}
	List<MasEmployee> pendingScrutinyAtList = new ArrayList<MasEmployee>();
	   if(map.get("pendingScrutinyAtList")!=null)
	   {
		   pendingScrutinyAtList = (List) map.get("pendingScrutinyAtList");
	   }
	List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
	if(map.get("workTypeList")!=null)
	{
	worktypeList = (List) map.get("workTypeList");
	}
	String deptName="";
    if(session.getAttribute("deptName")!=null){
       deptName=(String)session.getAttribute("deptName");
       }
	List<MasEmployee>employee1List=new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null)
	{
		employee1List=(List)map.get("employeeList");
	}
	String statusMessage="";
	if(map.get("status")!=null)
	{
		statusMessage=(String)map.get("status");
	}
	
	String boodate="";
	String HRODATE="";
	String TOBECOMPLETE="";
	String  COMPLETEON="";	
	String BPSSENTFOR="";
	String AESRECEIVEDON="";
	String ADMINAPPROVALDATE="";
	String ADMINAPPROVALFWDDATE="";
	String FUNDRELEASEDON="";
	String UPDATEPDC="";
	String REVISEDPD="";
	String TENDERISSUEDON="";
	String TENDERCOMPLETED="";
	String WORKCOMMENCEDON="";
	String WORKCOMPLETEDON="";
	String MAJORWORKDATE="";
	String PENDINGSCRUTINYDATE="";
	String RECIVEDDATE="";
	
	if(masMajorWorkDetailList.get(0)!=null)
	{
		
	if(masMajorWorkDetailList.get(0).getMajorWorkBooAssembledOn()!=null)
	{
	boodate=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkBooAssembledOn());
	}
	else
	{
		boodate="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkHroDate()!=null)
	{
	HRODATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkHroDate());
	}
	else
	{
		HRODATE="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkToBeComplete()!=null)
	{
	TOBECOMPLETE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkToBeComplete());
	}
	else
	{
		TOBECOMPLETE="";
	}
	
	if(masMajorWorkDetailList.get(0).getMajorWorkCompletedOn()!=null)
	{
	COMPLETEON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkCompletedOn());
	}
	else
	{
		COMPLETEON="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkBpsSentfor()!=null)
	{
	BPSSENTFOR=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkBpsSentfor());
	}
	else
	{
		BPSSENTFOR="";	
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkAesReceiveOn()!=null)
	{
	AESRECEIVEDON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkAesReceiveOn());
	}
	else
	{
		AESRECEIVEDON="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalDate()!=null)
	{
	ADMINAPPROVALDATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalDate());
	}
	else
	{
		ADMINAPPROVALDATE="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalFwdDate()!=null)
	{
	ADMINAPPROVALFWDDATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalFwdDate());
	} 
	else
	{
		ADMINAPPROVALFWDDATE="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkFundRealesedOn()!=null)
	{
	FUNDRELEASEDON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkFundRealesedOn());
	}
	else
	{
		FUNDRELEASEDON="";	
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkPdc()!=null)
	{
	UPDATEPDC=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkPdc());
	}
	else
	{
		UPDATEPDC="";
	}
	
	if(masMajorWorkDetailList.get(0).getMajorWorkRevisedPd()!=null)
	{
	REVISEDPD=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkRevisedPd());
	}
	else
	{
		REVISEDPD="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkTenderIssuedOn()!=null)
	{
	TENDERISSUEDON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkTenderIssuedOn());
	}
	else
	{
		TENDERISSUEDON="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkTenderCompletedDate()!=null)
	{
	TENDERCOMPLETED=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkTenderCompletedDate());
	}
	else
	{
		TENDERCOMPLETED="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkCommencedOn()!=null)
	{
		
	
	WORKCOMMENCEDON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkCommencedOn());
	}
	else
	{
		WORKCOMMENCEDON="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkCompletedOn()!=null)
	{
	WORKCOMPLETEDON=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkCompletedOn());
	}
	else
	{
		WORKCOMPLETEDON="";
	}
	if(masMajorWorkDetailList.get(0).getMajorWorkDetailDate()!=null)
	{
	MAJORWORKDATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getMajorWorkDetailDate());
	
	}
	else
	{
		MAJORWORKDATE="";
	}
	}
	
	if(masMajorWorkDetailList.get(0).getPendingScrutanyDate()!=null)
	   {
		PENDINGSCRUTINYDATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getPendingScrutanyDate());
	   }
	   else
	   {
		   PENDINGSCRUTINYDATE="";
	   }
	if(masMajorWorkDetailList.get(0).getReceivedDate()!=null)
    {
    RECIVEDDATE=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetailList.get(0).getReceivedDate());
    }
    else
    {
    	RECIVEDDATE="";
    }
			
	String message ="";
	
%>

<script language="JavaScript" type="text/javascript">
serverdate = '<%=dateCal+"/"+month+"/"+year%>';
function est()
{
var edStartDate = document.getElementById("fundReleasedOn").value
var edDate = new Date(edStartDate.substring(6),(edStartDate.substring(3,5) - 1) ,edStartDate.substring(0,2))
var pdc = document.getElementById("week").value;
var calculatedDate=new Date(edDate.getTime()+pdc*24*60*60*1000*7);
if(calculatedDate.getDate().toString().length == 1)
{
var part1="0"+calculatedDate.getDate();
}else
var part1=calculatedDate.getDate();

if((calculatedDate.getMonth()+1).toString().length == 1)
{
var part2="0"+(calculatedDate.getMonth()+1);
}else
{
var part2=calculatedDate.getMonth()+1;
}
var part3=calculatedDate.getFullYear();
document.getElementById("pdc").value = part1+"/"+part2+"/"+part3;
}
function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
function checkHroNo()
{
var hroNo = document.getElementById("hroNo").value
var hroDate = document.getElementById("hroDate1").value
if(hroNo=="")
{
alert("Please enter HRO No first");
document.getElementById("hroDate1").value="";
return false;
}
else
{
return true;
}
}
</script>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>
<DIV id="contentHolder">
<FORM name="Major_workdetail" action="" method=post>

<h6>Major Work Details Update</h6>
<div class="Clear"></div>
<div class="blockFrame"><LABEL>Major Work No.</LABEL> <%if(masMajorWorkDetailList.get(0).getMajorWorkDetailNo()!=null){ %>
<label class="value"><%=masMajorWorkDetailList.get(0).getMajorWorkDetailNo()%></label>

<%}else{ %> <label class="value"></label> <%} %> <LABEL>Major Work
Date</LABEL> <label class="value"><%=MAJORWORKDATE%></label> <input
	type="hidden" value="<%=MAJORWORKDATE%>" id="majorWorkDate"
	name="majorWorkDate"> <input type="hidden"
	value="<%=boodate%>" id="currentValueBoo" name=""currentValue"" >
<input type="hidden" value="<%=TOBECOMPLETE%>" id="currentValueToBeC">
<input type="hidden" value="<%=COMPLETEON%>"
	id="currentValueCompletedOn"> <input type="hidden"
	value="<%=BPSSENTFOR%>" id="currentValueBPSSent"> <input
	type="hidden" value="<%=AESRECEIVEDON%>" id="currentValueAeRec">
<input type="hidden" value="<%=ADMINAPPROVALDATE%>"
	id="currentValueAdmin"> <input type="hidden"
	value="<%=ADMINAPPROVALFWDDATE%>" id="currentValueAdminFwd"> <input
	type="hidden" value="<%=FUNDRELEASEDON%>" id="currentValueFundR">
<input type="hidden" value="<%=UPDATEPDC%>" id="currentValuePDC">
<input type="hidden" value="<%=REVISEDPD%>" id="currentValueRevised">
<input type="hidden" value="<%=TENDERISSUEDON%>"
	id="currentValueTenderI"> <input type="hidden"
	value="<%=TENDERCOMPLETED%>" id="currentValueTenderC"> <input
	type="hidden" value="<%=WORKCOMMENCEDON%>" id="currentValueWorkC">
<input type="hidden" value="<%=WORKCOMPLETEDON%>"
	id="currentValueWorkCompletedOn"> <input type="hidden"
	value="<%=PENDINGSCRUTINYDATE%>" id="currentPendingScrutinyDate">
<input type="hidden" value="<%=RECEIVED_DATE%>" id="currentReceivedDate">

<INPUT type=hidden
	value="<%=masMajorWorkDetailList.get(0).getLastChangedBy()%>"
	name="<%=LAST_CHANGED_BY%>"> <INPUT type=hidden
	value="<%=masMajorWorkDetailList.get(0).getLastChangedDate()%>"
	name="<%=LAST_CHANGED_DATE%>"> <INPUT type=hidden
	value="<%=masMajorWorkDetailList.get(0).getLastChangedTime()%>"
	name="<%=LAST_CHANGED_TIME%>">

<div class="Clear"></div>

<label>Proposed By</label> <select id="searchField5"
	name="<%= MAJOR_WORK_CATEGORY_ID %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<%
      for (MasDepartment masWorkType  :masDepartmentList) {
         if(masWorkType.getStatus().equalsIgnoreCase("y"))
            {
     %>
	<option value="<%=masWorkType.getDepartmentName()%>"><%=masWorkType.getDepartmentName()%></option>
	<%
      }
      }
   %>
</select> <label>Work Type</label> <select name="<%= MAJOR_WORK_TYPE_ID %>"
	tabindex="1">
	<option
		value="<%=masMajorWorkDetailList.get(0).getWorkType().getId() %>"><%=masMajorWorkDetailList.get(0).getWorkType().getWorkTypeName() %></option>

	<option value="">Select</option>
	<%
for (MasWorkType masWorkType :worktypeList) {
	if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Major Works")){
%>

	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>

	<%
}
}
%>
</select></div>

<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label style="font-size: 20">Status:</label> <label class="large"
	style="font-size: 20; color: red" tabindex="1"><%=statusMessage %></label>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockTitle">Work Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Details of
Work</Label> <%if(masMajorWorkDetailList.get(0).getMajorWorkDetail()!=null){ %> <textarea
	tabindex="1" class="large" onkeyup="chkLength(this,500);"
	name="<%= MAJOR_WORK_DETAIL %>" validate="Details of work,string,yes"> <%=masMajorWorkDetailList.get(0).getMajorWorkDetail()%></textarea>
<%}else{ %> <textarea tabindex="1" class="large"
	onkeyup="chkLength(this,500);" name="<%= MAJOR_WORK_DETAIL %>"></textarea>
<%} %>
<div class="Clear"></div>

<label> HRO No.</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkHroNo()!=null){ %>
<input tabindex="1" id="hroNO"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkHroNo()%>"
	name="<%=HRO_NO %>" maxlength="15"> <%}else{ %> <input
	tabindex="1" id="hroNo" name="<%=HRO_NO %>" maxlength="15" value="">
<%} %> <label> HRO Date</label> <input tabindex="1" id="hroDate1"
	value="<%=HRODATE%>" id="hroDate"
	onblur="compareDateForMajorWork(majorWorkDate,this,currentValueBoo,majorWorkDate,'Major Work');checkHroNo();"
	name="<%=HRO_DATE%>" class="calDate" MAXLENGTH="12"
	validate="HRO Date,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.Major_workdetail.<%=HRO_DATE%>,event)" />



<div class="Clear"></div>
<input type="hidden" name="Id" value="<%=Id %>"> <label>BOO
Assembled On</label> <input tabindex="1" name="<%=BOO_DATE%>"
	value="<%=boodate%>" id="BOODate" class="calDate" MAXLENGTH="12"
	validate="Boo Assembled On Date,date,no"
	onblur="compareDateForMajorWork(hroDate1,this,currentValueBoo,hroDate1,'HRO');"
	onchange="compareDateForMajorWork(hroDate1,this,currentValueBoo,hroDate1,'HRO');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=BOO_DATE%>,event)" ; />


<label>To be Complete</label> <input tabindex="1"
	onchange="compareDateForMajorWork(BOODate,this,currentValueToBeC,BOODate,'Boo');"
	onblur="compareDateForMajorWork(BOODate,this,currentValueToBeC,BOODate,'Boo');"
	name="<%=TO_BE_COMPLETE%>" value="<%=TOBECOMPLETE%>" class="calDate"
	MAXLENGTH="12" validate="To be completed Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=TO_BE_COMPLETE%>,event)" ; />


<div class="Clear"></div>
<label>Presiding Officer</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkPresidingOffice()!=null){ %>
<input tabindex="1" onchange="compareDateForMajorWork(this);"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkPresidingOffice()%>"
	name="<%=PRESNIDING_OFFICER %>" maxlength="15"> <%}else{ %> <input
	tabindex="1" name="<%=PRESNIDING_OFFICER %>" value="" maxlength="15"
	onchange="compareDateForMajorWork(this);"> <%} %> <label>Completed
On</label> <input tabindex="1" id="completedOn"
	onblur="compareDateForMajorWork(BOODate,this,currentValueCompletedOn,BOODate,'BOO Assembled On');"
	onchange="compareDateForMajorWork(BOODate,this,currentValueCompletedOn,BOODate,'BOO Assembled On');"
	name="<%=COMPLETED_ON%>" value="<%=COMPLETEON%>" class="calDate"
	MAXLENGTH="12" validate="Completed on Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=COMPLETED_ON%>,event)" ; />


<div class="Clear"></div>


<label>BPs Sent For AEs Letter</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkBpsSentforAesLetter()!=null){ %>
<input tabindex="1" maxlength="15"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkBpsSentforAesLetter()%>"
	name="<%=BPS_SENT_FOR_AES_LETTER %>"> <%}else{ %> <input
	tabindex="1" name="<%=BPS_SENT_FOR_AES_LETTER %>" value=""
	maxlength="15"> <%} %> <label>BPs Sent For</label> <input
	tabindex="1" id="bpSentFor"
	onblur="compareDateForMajorWork(completedOn,this,currentValueBPSSent,completedOn,'Completed On');"
	onchange="compareDateForMajorWork(completedOn,this,currentValueBPSSent,completedOn,'Completed On');"
	name="<%=BPS_SENT_FOR%>" value="<%=BPSSENTFOR%>" class="calDate"
	MAXLENGTH="12" validate="BPS sent for Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=BPS_SENT_FOR%>,event)" ; />


<div class="Clear"></div>
<label>AEs Received On</label> <input tabindex="1" id="aeReceived"
	onblur="compareDateForMajorWork(bpSentFor,this,currentValueAeRec,bpSentFor,'BPs Sent For');"
	onchange="compareDateForMajorWork(bpSentFor,this,currentValueAeRec,bpSentFor,'BPs Sent For');"
	name="<%=AES_RECEIVED_ON%>" value="<%=AESRECEIVEDON%>" class="calDate"
	MAXLENGTH="12" validate="AEs recived on Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=AES_RECEIVED_ON%>,event)" ; />



<label>Estimated Cost</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkEstimatedCost()!=null){ %>
<input tabindex="1" maxlength="7"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkEstimatedCost()%>"
	name="<%=ESTIMATED_COST %>"> <%}else{ %> <input tabindex="1"
	name="<%=ESTIMATED_COST %>" value="" maxlength="7"> <%} %>

<div class="Clear"></div>
<LABEL>Pending Scrutiny At</LABEL> <select
	name="<%= PENDING_SCRUTINY_AT %>" tabindex="1">
	<option
		value="<%=masMajorWorkDetailList.get(0).getWorkCategoryName()%>"><%=masMajorWorkDetailList.get(0).getWorkCategoryName()%></option>
	<%
for (MasEmployee masEmployee : pendingScrutinyAtList) {
   if(masEmployee.getStatus().equalsIgnoreCase("y")){
%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>
	<%
}
}%>
</select> <label>Pending Scrutiny Date</label> <input tabindex="1"
	onchange="compareDateForMajorWork(aeReceived,this,currentPendingScrutinyDate,aeReceived,'AEs Received On');"
	name="<%=PENDING_SCRUTINY_DATE%>" value="<%=PENDINGSCRUTINYDATE%>"
	class="calDate" MAXLENGTH="12" validate="AEs recived on Date,date,no" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=PENDING_SCRUTINY_DATE%>,event)" ; />

<label>Received Date</label> <input tabindex="1" id="receivedDate"
	onblur="compareDateForMajorWork(aeReceived,this,currentReceivedDate,aeReceived,'AEs Received On');"
	onchange="compareDateForMajorWork(aeReceived,this,currentReceivedDate,aeReceived,'AEs Received On');"
	name="<%=RECEIVED_DATE%>" value="<%=RECIVEDDATE%>" class="calDate"
	MAXLENGTH="12" validate="AEs recived on Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=RECEIVED_DATE%>,event)" ; />

<div class="Clear"></div>
<label>Admin Approval No.</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalNo()!=null){ %>
<input tabindex="1" maxlength="15"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalNo()%>"
	name="<%=ADMIN_APPROVAL_NO %>"> <%}else{ %> <input tabindex="1"
	name="<%=ADMIN_APPROVAL_NO %>" value="" maxlength="15"> <%} %> <label>Admin
Approval Date</label> <input tabindex="1"
	onblur="compareDateForMajorWork(receivedDate,this,currentValueAdmin,receivedDate,'Received');"
	onchange="compareDateForMajorWork(receivedDate,this,currentValueAdmin,receivedDate,'Received');"
	name="<%=ADMIN_APPROVAL_DATE%>" value="<%=ADMINAPPROVALDATE%>"
	class="calDate" validate="Admin Approval Date,date,no" MAXLENGTH="12" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=ADMIN_APPROVAL_DATE%>,event)" ; />

<div class="Clear"></div>


<label>Admin Approval Fwd Letter</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalFwdLetter()!=null){ %>
<input tabindex="1" maxlength="15"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkAdminApprovalFwdLetter()%>"
	name="<%=ADMIN_APPROVAL_FWD_LETTER %>"> <%}else{ %> <input
	tabindex="1" name="<%=ADMIN_APPROVAL_FWD_LETTER %>" value=""
	maxlength="15"> <%} %> <label>Admin Approval Fwd Date</label> <input
	tabindex="1" id="fwdDate"
	onblur="compareDateForMajorWork(receivedDate,this,currentValueAdminFwd,receivedDate,'Received');"
	onchange="compareDateForMajorWork(receivedDate,this,currentValueAdminFwd,receivedDate,'Received');"
	name="<%= ADMIN_APPROVAL_FWD_DATE%>" value="<%=ADMINAPPROVALFWDDATE%>"
	class="calDate" readonly="readonly" MAXLENGTH="10" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%= ADMIN_APPROVAL_FWD_DATE%>,event)" ; />

<div class="Clear"></div>
<label>Fund Released Authority</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkFundRealeseAuth()!=null){ %>
<input tabindex="1" maxlength="15"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkFundRealeseAuth() %>"
	name="<%=FUND_RELEASED_AUTHRITY %>"> <%}else{ %> <input
	tabindex="1" name="<%=FUND_RELEASED_AUTHRITY %>" maxlength="15">
<%} %> <label>Fund Released On</label> <input tabindex="1"
	id="fundReleasedOn"
	onblur="compareDateForMajorWork(fwdDate,this,currentValueFundR,fwdDate,'Admin Approval Fwd');"
	onchange="compareDateForMajorWork(fwdDate,this,currentValueFundR,fwdDate,'Admin Approval Fwd');"
	name="<%=FUND_RELEASED_ON%>" value="<%=FUNDRELEASEDON%>"
	class="calDate" MAXLENGTH="12" validate="Fund Released On,date,no" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=FUND_RELEASED_ON%>,event)" ; />

<label>Week</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkWeek()!=null){ %>
<input tabindex="1" maxlength="3" id="week" validate="Week,int,no"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkWeek()%>"
	name="<%=MAJOR_WORK_DETAIL_UPDATE_WEEK %>" onchange="est();"> <%}else{ %>
<input id="week" tabindex="1" name="<%=MAJOR_WORK_DETAIL_UPDATE_WEEK %>"
	maxlength="3" validate="Week,int,no" onchange="est();"> <%} %>
<div class="Clear"></div>
<label>PDC</label> <input tabindex="1"
	name="<%=MAJOR_WORK_DETAIL_UPDATE_PDC%>" id="pdc"
	value="<%=UPDATEPDC%>" class="calDate" MAXLENGTH="12"
	readonly="readonly" validate="PDC,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=MAJOR_WORK_DETAIL_UPDATE_PDC%>,event)" ; />



<label>Revised PD</label> <input tabindex="1"
	onblur="compareDateForMajorWork(fundReleasedOn,this,currentValueRevised,fundReleasedOn,'Fund Released On');"
	onchange="compareDateForMajorWork(fundReleasedOn,this,currentValueRevised,fundReleasedOn,'Fund Released On');"
	name="<%=MAJOR_WORK_DETAIL_UPDATE_REVISED_PD%>" value="<%=REVISEDPD%>"
	class="calDate" validate="Revised PD,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=MAJOR_WORK_DETAIL_UPDATE_REVISED_PD%>,event)" ; />

<div class="Clear"></div>
<label>Tender Action in Hand</label> <label class="unit">Yes</label> <input
	tabindex="1" type="radio" name="<%=TENDER_ACTION_IN_HAND  %>" value="y"
	class="radio" /> <label class="unit">No</label> <input tabindex="2"
	type="radio" name="<%=TENDER_ACTION_IN_HAND %>" value="n" class="radio" />


<label>Tender Issued On</label> <input tabindex="1" id="tenderIssued"
	onblur="compareDateForMajorWork(fundReleasedOn,this,currentValueTenderI,fundReleasedOn,'Fund Released On');"
	onchange="compareDateForMajorWork(fundReleasedOn,this,currentValueTenderI,fundReleasedOn,'Fund Released On');"
	name="<%=TENDER_ISSUED_ON%>" value="<%=TENDERISSUEDON%>"
	class="calDate" validate="Tender Issued On,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=TENDER_ISSUED_ON%>,event)" ; />



<label>Tender Completed</label> <input tabindex="1" id="tenderCompleted"
	onblur="compareDateForMajorWork(tenderIssued,this,currentValueTenderC,tenderIssued,'Tender Issued On');"
	onchange="compareDateForMajorWork(tenderIssued,this,currentValueTenderC,tenderIssued,'Tender Issued On');"
	type="text" name="<%=TENDER_COMPLETED%>" value="<%= TENDERCOMPLETED%>"
	class="calDate" validate="Tender Completed On,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=TENDER_COMPLETED%>,event)" ; />
<div class="Clear"></div>
<label>Project Officer</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkProjectOfficer()!=null){ %>
<input maxlength="30" tabindex="1"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkProjectOfficer()%>"
	name="<%=PROJECT_OFFICER %>"> <%}else{ %> <input
	name="<%=PROJECT_OFFICER %>" tabindex="1" maxlength="30" value="">
<%} %> <label>Progress Percentage</label> <%if(masMajorWorkDetailList.get(0).getMajorWorkProgressPercentage()!=null){ %>
<input maxlength="7" tabindex="1"
	value="<%=masMajorWorkDetailList.get(0).getMajorWorkProgressPercentage()%>"
	name="<%=PROGRESS_PERCENTAGE %>"> <%}else{ %> <input
	name="<%=PROGRESS_PERCENTAGE %>" tabindex="1" maxlength="7" value="">
<%} %>


<div class="Clear"></div>

<label>Progress Remarks</Label> <%if(masMajorWorkDetailList.get(0).getMajorWorkProgressRemarks()!=null){ %>
<textarea class="large" onkeyup="chkLength(this,50);" tabindex="1"	name="<%= PROGRESS_REMARKS %>">	<%=masMajorWorkDetailList.get(0).getMajorWorkProgressRemarks()%></textarea>
<%}else{ %> <textarea class="large" tabindex="1"
	name="<%= PROGRESS_REMARKS %>" onkeyup="chkLength(this,50);"></textarea>
<%} %>

<div class="Clear"></div>


<label>Work Commenced on</label> <input id="workCommenced"
	onblur="compareDateForMajorWork(tenderCompleted,this,currentValueWorkC,tenderCompleted,'Tender Completed On');"
	onchange="compareDateForMajorWork(tenderCompleted,this,currentValueWorkC,tenderCompleted,'Tender Completed On');"
	tabindex="1" type="text" name="<%=WORK_COMMENCED_ON%>"
	value="<%=WORKCOMMENCEDON%>" class="calDate"
	validate="Work Commenced On,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=WORK_COMMENCED_ON%>,event)" ; />

<label>Work Completed on</label> <input
	onblur="compareDateForMajorWork(workCommenced,this,currentValueWorkCompletedOn,workCommenced,'Work Commenced On');"
	onchange="compareDateForMajorWork(workCommenced,this,currentValueWorkCompletedOn,workCommenced,'Work Commenced On');"
	tabindex="1" type="text" name="<%=WORK_COMPLETED_ON%>"
	value="<%=WORKCOMPLETEDON%>" class="calDate"
	validate="Work Completed On,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.Major_workdetail.<%=WORK_COMPLETED_ON%>,event)" ; />


<div class="Clear"></div>

</div>
<div class="division"></div>
<div class="bottom"><INPUT class=button id=updatebutton
	accessKey=u
	onClick="submitForm('Major_workdetail','majorWorkDetailUpdate?method=majorWorkDetailUpdateToDatabase');"
	tabIndex="1" value="Update" type="button" name="update" /> <INPUT
	class=button id=reset accessKey=r onclick=resetCheck(); type=reset
	value=Reset name=Reset tabindex="1" /> <INPUT class=button id=back
	accessKey=b onClick="javascript:history.back()" type=button value=Back
	name=back tabindex="1" /> <INPUT type=hidden name="<%=STATUS %>">
<INPUT type=hidden name="<%= COMMON_ID%>">
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class=value><%=time%></label> <INPUT type=hidden
	value="<%=userName%>" name="<%=CHANGED_BY%>"> <INPUT
	type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>"> <INPUT
	type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>"> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%=COMMON_ID%>" value="" /></div>
</form>
</DIV>


