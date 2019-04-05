<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<form name="allotAirmen" method="post" action=""><script>

function get_valueForCheckBox(rowVal)
{
if(document.getElementById('<%=VALIDATED%>'+rowVal).checked == true){
var smqId=0;
var vacationNo="";
var vacationDate="";
var registrationId=0;
var allotmentId=0;
var poolId=0;
var poolName ="";
var serviceNo = "";
var servicePName= "";

smqId= document.getElementById('smqId'+rowVal).value;
vacationNo = document.getElementById('vacationNo'+rowVal).value;
vacationDate = document.getElementById('vacationDate'+rowVal).value;
registrationId = document.getElementById('registrationId'+rowVal).value;
allotmentId = document.getElementById('allotmentId'+rowVal).value;
poolId = document.getElementById('poolId'+rowVal).value;
poolName = document.getElementById('poolName'+rowVal).value;


 var url="/hms/hms/accom?method=showAllotmentDetailsAirmen&smqId="+document.getElementById('smqId'+rowVal).value+'&vacationNo='+document.getElementById('vacationNo'+rowVal).value+'&vacationDate='+document.getElementById('vacationDate'+rowVal).value+'&registrationId='+document.getElementById('registrationId'+rowVal).value+'&allotmentId='+document.getElementById('allotmentId'+rowVal).value+'&poolId='+document.getElementById('poolId'+rowVal).value+'&poolName='+document.getElementById('poolName'+rowVal).value;
   popwindow(url);
 }  
 }

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=600,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}


</script> <script type="text/javascript">

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
</script> <%
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

List<AccomAllotment> smqVacList = new ArrayList<AccomAllotment>();
if (map.get("smqVacList") != null) {
	smqVacList = (List<AccomAllotment>) map.get("smqVacList");
	
}
List<MasSmq> smqList = new ArrayList<MasSmq>();
if (map.get("smqList") != null) 
{
	smqList = (List<MasSmq>) map.get("smqList");
}
String vacationNo="";
if(map.get("vacationNo") != null){
	vacationNo = (String)map.get("vacationNo");	
}

%> <% 
String message ="";
if (map.get("message") != null) {
	message = (String) map.get("message");
 }
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %> <script>
function retentionAllotment(inc){
var typeOfAllotment;
typeOfAllotment = document.getElementById('typeOfAllotment'+inc).value;
	if(typeOfAllotment == "r")
{
	document.getElementById('retentionTill'+inc).style.visibility = 'visible';
	document.getElementById('retentionDate'+inc).style.visibility = 'visible';
	
}else{
	document.getElementById('retentionTill'+inc).style.visibility  = 'hidden';
	document.getElementById('retentionDate'+inc).style.visibility  = 'hidden';
}
}
</script> <script>
function generateAllotmentNo(obj,inc){
	for(i=1;i<=document.getElementById('counter').value;i++)
	{
		if(document.getElementById('<%=SMQ_NAME %>'+i).value != ""){
			if(i != inc){
				if(document.getElementById('<%=SMQ_NAME %>'+i).value == obj.value){
				alert("This Smq already selected.")
				document.getElementById('<%=SMQ_NAME %>'+inc).value = "";
				return false;	
				}
			}else{
				submitProtoAjaxWithDivName('allotAirmen','accom?method=generateAllotmentNumber&inc='+inc,'sampleDiv'+inc);
			}
		}
	}
}
</script> <script>
var poolSelected=false;
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValueForAllotment(){
document.getElementById('poolId').value='0';
for(var i=1;i<document.getElementById('counter').value;i++)
{
document.getElementById('smqName'+i).value="";
document.getElementById('typeOfAllotment'+i).value="";
document.getElementById('remarks'+i).value = "";
}
}



</script>

<div id="contentHolder">
<h6>ALLOTMENT/VACATION OF SMQs for Airmen</h6>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="clear"></div>
<label><span>*</span> SMQs</label> <select id="<%=SMQ_ID %>"
	name="<%=SMQ_ID %>" validate="SMQ,string,yes" tabindex="1"
	onblur="submitFormForButton('allotAirmen','accom?method=getRecordsAllotVacatAirmen');"
	onchange="submitFormForButton('allotAirmen','accom?method=getRecordsAllotVacatAirmen');">
	<option value="0">Select</option>
	<% 
				for(MasSmq masSmq : smqList){
					if(masSmq.getId()== box.getInt(SMQ_ID )){
					
			%>
	<option value="<%=masSmq.getId() %>" selected="selected"><%=masSmq.getSmqName()%></option>
	<%}else{%>
	<option value="<%=masSmq.getId() %>"><%=masSmq.getSmqName()%></option>
	<%}}%>
</select> <label><span>*</span> Vacation No</label> <label class="value"><%=vacationNo %></label>
<label><span>*</span> Vacation Date</label> <label class="value"><%=date %></label>
</div>
<% 

int smqId =0;
String smqName="";
if(box.getInt(SMQ_ID )== 0){
	smqId=0;
}else{
	smqId = box.getInt(SMQ_ID );
}

if(smqVacList != null){%>
<div class="clear"></div>
<label class="common">Selected PoolCode</label> <input type="hidden"
	name="<%=NAME %>" id="<%=NAME %>" value="<%=smqId %>" /> <%
  Iterator<MasSmq> ite=smqList.iterator();
    	 while ( ite.hasNext() ) {
     		MasSmq msSmq=(MasSmq)ite.next();
     		if(msSmq.getId()==smqId)
     		{
     			
     			
     %> <script type="text/javascript">poolSelected=true;</script> <label
	class="value"> <%=msSmq.getSmqName()%></label> <%		
    smqName = msSmq.getSmqName();
    }
    	 }
     }
    %>

<div class="Clear"></div>
<div class="height10"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sr.No</th>
		<th scope="col">Allot.Order File No.</th>
		<th scope="col">Allot.Order File Date</th>
		<th scope="col">SMQ no</th>
		<th scope="col">Pool Code</th>
		<th scope="col">Service No</th>
		<th scope="col">Name</th>
		<th scope="col">Rank</th>
		<th scope="col">Vacation</th>
	</tr>
	<%
	    int inc = 0; 
	    String allotDate="";
	    Date allotmentDate ;
	    if (smqVacList!=null && smqVacList.size()>0)
	     {
	    	Iterator<AccomAllotment> ite=smqVacList.iterator();
	   			 while ( ite.hasNext() ) {
	   				AccomAllotment accomAllot=(AccomAllotment)ite.next();
		    		allotmentDate = accomAllot.getAllotmentDate();
		    		allotDate = HMSUtil.convertDateToStringWithoutTime(allotmentDate);
		    		inc++;
    	%>
	<tr>
		<td><label id="<%=SR_NO %>" name="<%=SR_NO%>"><%=inc%></label> <input
			type="hidden" name="<%=ALLOTMENT_ID %>"
			id="<%=ALLOTMENT_ID %><%=inc %>" value="<%=accomAllot.getId() %>" />
		<input type="hidden" name="<%=REGISTRATION_STATUS %>"
			id="<%=REGISTRATION_STATUS %><%=inc %>"
			value="<%=accomAllot.getAccom().getRegStatus() %>" /> <input
			type="hidden" name="<%=DEPARTMENT_ID %>"
			id="<%=DEPARTMENT_ID %><%=inc %>" value="<%=deptId %>" /> <input
			type="hidden" name="<%=HOSPITAL_ID %>"
			id="<%=HOSPITAL_ID %><%=inc %>" value="<%=hospitalId%>" /> <input
			type="hidden" name="<%=SMQ_ID %>" id="<%=SMQ_ID%><%=inc %>"
			value="<%=smqId %>" /> <input type="hidden" name="<%=CHANGED_BY%>"
			id="<%=CHANGED_BY%><%=inc %>" value="<%=userName%>" /> <input
			type="hidden" name="<%=CHANGED_DATE %>"
			id="<%=CHANGED_DATE %><%=inc %>" value="<%=date%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>"
			id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" /> <input
			type="hidden" name="<%=REGISTRATION_ID %>"
			id="<%=REGISTRATION_ID %><%=inc %>"
			value="<%=accomAllot.getAccom().getId() %>" /> <input type="hidden"
			value="<%=vacationNo %>" name="<%=VACATION_NO %>"
			id="<%=VACATION_NO %><%=inc %>" /> <input type="hidden"
			value="<%=date %>" name="<%=VACATION_DATE %>"
			id="<%=VACATION_DATE %><%=inc %>" /> <input type="hidden"
			name="<%=POOL_NAME%>" id="<%=POOL_NAME%><%=inc%>"
			value="<%=accomAllot.getPool().getPoolName()%>" /> <input
			type="hidden" name="<%=SERVICE_NO%>" id="<%=SERVICE_NO%><%=inc%>"
			value="<%=accomAllot.getAccom().getServiceNo()%>" /> <input
			type="hidden" name="<%=SERVICE_PERSON_NAME%>"
			id="<%=SERVICE_PERSON_NAME%><%=inc%>"
			value="<%=accomAllot.getAccom().getServicePersonName()%>" /></td>

		<td>
		<%if(accomAllot.getAllotmentNo()!=null && accomAllot.getAllotmentNo()!=""){ %>
		<label id="<%=ALLOTMENT_NO%><%=inc%>" size=8 name="<%=ALLOTMENT_NO%>"><%=accomAllot.getAllotmentNo()%></label>
		<%}else{ %> <label id="<%=ALLOTMENT_NO%><%=inc%>" size=8
			name="<%=ALLOTMENT_NO%>">-</label> <%}%>
		</td>

		<td>
		<%if(accomAllot.getAllotmentDate()!=null){ %> <label
			id="<%=ALLOTMENT_DATE%><%=inc%>" size=8 name="<%=ALLOTMENT_DATE%>"><%=allotDate%></label>
		<%}else{ %> <label id="<%=ALLOTMENT_DATE%><%=inc%>" size=8
			name="<%=ALLOTMENT_DATE%>">-</label> <%}%>
		</td>

		<td>
		<%if(accomAllot.getSmq()!=null){ %> <label id="<%=SMQ_ID%><%=inc%>"
			size=8 name="<%=SMQ_ID%>"><%=accomAllot.getSmq().getSmqName()%></label>
		<%}else{ %> <label id="<%=SMQ_ID%><%=inc%>" size=8 name="<%=SMQ_ID %>">-</label>
		<%}%>
		</td>

		<td>
		<%if(accomAllot.getPool()!=null ){ %> <label id="<%=POOL_NAME%><%=inc%>"
			size=8 name="<%=POOL_NAME%><%=inc %>"><%=accomAllot.getPool().getPoolName()%></label>
		<input type="hidden" name="<%=POOL_ID%>" id="<%=POOL_ID%><%=inc%>"
			value="<%=accomAllot.getPool().getId()%>" /> <%}else{ %> <label
			id="<%=POOL_NAME%><%=inc%>" size=8 name="<%=POOL_NAME %><%=inc %>">-</label>
		<input type="hidden" name="<%=POOL_ID%>" id="<%=POOL_ID%><%=inc%>"
			value="" /> <%}%>
		</td>

		<td>
		<%if(accomAllot.getAccom()!=null ){ %> <label
			id="<%=SERVICE_NO%><%=inc%>" size=8 name="<%=SERVICE_NO%>"><%=accomAllot.getAccom().getServiceNo()%></label>
		<%}else{ %> <label id="<%=SERVICE_NO%><%=inc%>" size=8
			name="<%=SERVICE_NO %>">-</label> <%}%>
		</td>

		<td>
		<%if(accomAllot.getAccom()!=null ){ %> <label
			id="<%=SERVICE_PERSON_NAME%><%=inc%>" size=8
			name="<%=SERVICE_PERSON_NAME%>"><%=accomAllot.getAccom().getServicePersonName()%></label>
		<%}else{ %> <label id="<%=SERVICE_PERSON_NAME%><%=inc%>" size=8
			name="<%=SERVICE_PERSON_NAME %>">-</label> <%}%>
		</td>

		<td>
		<%if(accomAllot.getRank()!=null ){ %> <label id="<%=RANK_ID%><%=inc%>"
			size=8 name="<%=RANK_ID%>"><%=accomAllot.getRank().getRankName()%></label>
		<%}else{ %> <label id="<%=RANK_ID%><%=inc%>" size=8 name="<%=RANK_ID %>">-</label>
		<%}%>
		</td>


		<td><input type="checkbox" class="radio" name="<%=VALIDATED%>"
			id="<%=VALIDATED%><%=inc %>" value="1"
			onclick="get_valueForCheckBox(<%=inc %>);" /></td>


	</tr>


	<%}
   	 }else{ %>
	<tr>
		<td colspan=14 align="center">No Records Found.</td>
	</tr>
	<%} %>

</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="Clear"></div>




<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	value="a" /></div>
<div class="Clear"></div>
</div>
</form>