<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<script type="text/javascript">

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
</script>
<script>
function resetResult(){
document.getElementById('<%=SERVICE_NO %>').value="";
document.getElementById('<%=SERVICE_PERSON_NAME %>').value="";

}
</script>
<%
Box box=HMSUtil.getBox(request);

Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null)
	{
	map = (Map<String, Object>)request.getAttribute("map");
	}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}

String allotmentNo="";
if(map.get("allotmentNo") != null){
	allotmentNo = (String)map.get("allotmentNo");	
}

List<MasPool> poolList = new ArrayList<MasPool>();
if (map.get("poolList") != null) 
{
	poolList = (List<MasPool>) map.get("poolList");
}
List<MasSmq> smqList = new ArrayList<MasSmq>();
if (map.get("smqList") != null) 
{
	smqList = (List<MasSmq>) map.get("smqList");
}

int smqId=0;
if(map.get("smqId") != null){
	smqId =(Integer) map.get("smqId");
}
int registrationId=0;
if(map.get("registrationId") != null){
	registrationId =(Integer) map.get("registrationId");
}
int allotmentId=0;
if(map.get("allotmentId") != null){
	allotmentId =(Integer) map.get("allotmentId");
}
int poolId=0;
if(map.get("poolId") != null){
	poolId =(Integer) map.get("poolId");
}
String poolName="";
if(map.get("poolName") != null){
	poolName = (String)map.get("poolName");	
}
String vacationNo="";
if(map.get("vacationNo") != null){
	vacationNo = (String)map.get("vacationNo");	
}
Date vacationDate= new Date();
if(map.get("vacationDate") != null){
	vacationDate = (Date)map.get("vacationDate");	
}
List<MasEmployee>  employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
%>
<%
String smqName="";
int smq=0;
if(smqList != null){
	for (MasSmq masSmq : smqList) 
	{
		smq=masSmq.getId();
		if(smqId == smq){
		
			smqName=masSmq.getSmqName();
	
}}}	%>

<form name="allotAirmen1" method="post" action="">
<div id="contentHolder">
<h6>ALLOTMENT/VACATION OF SMQs for Airmen</h6>
<div class="Clear"></div>
<div class="header"><label>SMQ Name</label><label class="value"><%=smqName %></label>
<input type="hidden" name="<%=SMQ_ID %>" id="<%=SMQ_ID %>"
	value="<%=smqId %>" /> <input type="hidden" name="<%=DEPARTMENT_ID %>"
	id="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <input type="hidden"
	name="<%=HOSPITAL_ID %>" id="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<label>Vacation No</label><label class="value"><%=vacationNo %></label>
<label>Vacation Date</label><label class="value"><%=HMSUtil.convertDateToStringWithoutTime(vacationDate) %></label>
<div class="Clear"></div>
</div>


<div class="Clear"></div>

<div class="blockFrame"><label class="large">Allotment
order File No.</label> <input type="hidden" name="<%=REGISTRATION_ID %>"
	id="<%= REGISTRATION_ID%>" value="<%=registrationId %>" /> <label
	class="value"><%=allotmentNo %></label> <input type="hidden"
	name="<%=ALLOTMENT_NO %>" value="<%=allotmentNo %>" /> <input
	type=hidden name="<%=ALLOTMENT_TIME %>" value="<%=time %>" /> <label
	class="large"> Allotment Order File Date </label> <label class="value"><%=date %></label>
<input type="hidden" id="regDateId" name="<%=ALLOTMENT_ORDER_DATE %>"
	value="<%=date %>" />

<div class="Clear"></div>
<div class="division"></div>

<label><span>*</span> Service No.</label> <input typ="text"
	name="serviceNo" id="serviceNo" value=""
	validate="ServiceNo,string,yes" maxlength="15" tabindex="1"
	onblur="ajaxFunctionForMA(allotAirmen1);" /> <label>Service
Person</label> <input typ="text" value="" name="servicePersonName"
	id="servicePersonName" validate="Service Person Name,string,no"
	maxlength="30" tabindex="1" />

<div class="Clear"></div>

<label>Pool Code</label> <input type="text" name="<%=POOL_NAME %>"
	id="<%=POOL_NAME %>" tabindex="1" value="<%=poolName %>"
	readonly="readonly" /> <input type="hidden" name="<%=POOL_ID %>"
	id="<%=POOL_ID %>" tabindex="1" value="<%=poolId %>"
	readonly="readonly" /> <label><span>*</span> Allotment Date </label> <input
	type="text" class="calDate" id="allotDateId"
	name="<%=ALLOTMENT_DATE %>" value="<%=date %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.allotAirmen1.<%=ALLOTMENT_DATE%>,event)" />


<label><span>*</span>Ho/To date</label> <input type="text"
	class="calDate" id="hoToDateId" name="<%=HO_TO_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.allotAirmen1.<%=HO_TO_DATE%>,event)" />
</div>

<div class="Clear"></div>
<div class="bottom">

<div class="division"></div>
<input type="button" class="button" value="Save"
	onclick="submitForm('allotAirmen1','accom?method=submitAllotmentDetailsAirmen');"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetResult();" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
</div>
</form>