<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<form name="allotAirmen" method="post" action=""><script
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
function checkSubmit(){

if(document.getElementById('counter').value==0 || document.getElementById('counter').value ==""){

	  	alert(" There should be atleast one row to submit records ");
	  	return false;
	  	}else
	  	{
	  
	  	return true;
	  	}
	  	
}
function check(){
 for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please vacate The Result.")
		return false;
		}

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
List<MasPool> poolList = new ArrayList<MasPool>();
if(map.get("poolList") != null){
	poolList = (List<MasPool>)map.get("poolList");
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
document.getElementById('<%=VALIDATED%>'+i).checked = false;
}
}


</script>

<div id="contentHolder">
<h6>SMQ Vacation For Officer</h6>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="clear"></div>
<label><span>*</span> Pool Code</label> <select id="<%=POOL_ID %>"
	name="<%=POOL_ID %>" validate="Pool Code,string,yes" tabindex="1"
	onblur="submitForm('allotAirmen','accom?method=getRecordsForOfficerVacation');"
	onchange="submitForm('allotAirmen','accom?method=getRecordsForOfficerVacation');">
	<option value="0">Select</option>
	<% 
				for(MasPool masPool : poolList){
					if(masPool.getId()== box.getInt(POOL_ID )){
					
			%>
	<option value="<%=masPool.getId() %>" selected="selected"><%=masPool.getPoolName()%></option>
	<%}else{%>
	<option value="<%=masPool.getId() %>"><%=masPool.getPoolName()%></option>
	<%}}%>
</select> <label><span>*</span> Vacation No</label> <input type="text"
	value="<%=vacationNo %>" readonly="readonly" /> <label><span>*</span>Vacation
Date</label> <input type="text" value="<%=date %>" readonly="readonly" /></div>
<% 

int poolId =0;
String poolName="";
if(box.getInt(POOL_ID )== 0){
	poolId=0;
}else{
	poolId = box.getInt(POOL_ID );
}

if(smqVacList != null){%>
<div class="clear"></div>
<label class="common">Selected PoolCode</label> <input type="hidden"
	name="<%=NAME %>" id="<%=NAME %>" value="<%=poolId %>" /> <%
  Iterator<MasPool> ite=poolList.iterator();
    	 while ( ite.hasNext() ) {
     		MasPool msPool=(MasPool)ite.next();
     		if(msPool.getId()==poolId)
     		{
     			
     			
     %> <script type="text/javascript">poolSelected=true;</script> <label
	class="value"> <%=msPool.getPoolName()%></label> <%		
    	poolName = msPool.getPoolName();
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
		<th scope="col">Allotment Date</th>
		<th scope="col">HO/TO Date</th>
		<th scope="col">V</th>
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
			type="hidden" name="<%=POOL_NAME %>" id="<%=POOL_NAME %>"
			value="<%=poolId %>" /> <input type="hidden" name="<%=CHANGED_BY%>"
			value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
			name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
			name="<%=REGISTRATION_ID %>" id="<%=REGISTRATION_ID %><%=inc %>"
			value="<%=accomAllot.getAccom().getId() %>" /> <input type="hidden"
			value="<%=date %>" name="<%=VACATION_DATE %>"
			id="<%=VACATION_DATE %><%=inc %>" /> <input type="hidden"
			value="<%=time %>" name="<%=VACATION_TIME %>"
			id="<%=VACATION_TIME %><%=inc %>" /> <input type="hidden"
			value="<%=vacationNo %>" name="<%=VACATION_NO %>"
			id="<%=VACATION_NO %><%=inc %>" /></td>

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
		<%if(accomAllot.getSmq()!=null){ %> <label id="<%=SMQ_NAME%><%=inc%>"
			size=8 name="<%=SMQ_NAME%>"><%=accomAllot.getSmq().getSmqName()%></label>
		<input type="hidden" value="<%=accomAllot.getSmq().getId() %>"
			name="<%=SMQ_ID %>" id="<%=SMQ_ID %><%=inc %>" /> <%}else{ %> <label
			id="<%=SMQ_NAME%><%=inc%>" size=8 name="<%=SMQ_NAME %>">-</label> <input
			type="hidden" value="" name="<%=SMQ_ID %>" id="<%=SMQ_ID %><%=inc %>" />
		<%}%>
		</td>

		<td>
		<%if(accomAllot.getPool()!=null ){ %> <label id="<%=POOL_ID%><%=inc%>"
			size=8 name="<%=POOL_ID%>"><%=accomAllot.getPool().getPoolName()%></label>
		<%}else{ %> <label id="<%=POOL_ID%><%=inc%>" size=8 name="<%=POOL_ID %>">-</label>
		<%}%>
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

		<td>
		<%if(accomAllot.getAllotmentDate()!=null ){ %> <label
			id="<%=ALLOTMENT_DATE%><%=inc%>" size=8 name="<%=ALLOTMENT_DATE%>"><%= HMSUtil.convertDateToStringWithoutTime(accomAllot.getAllotmentDate())%></label>
		<%}else{ %> <label id="<%=ALLOTMENT_DATE%><%=inc%>" size=8
			name="<%=ALLOTMENT_DATE %>">-</label> <%}%>
		</td>


		<td>
		<%if(accomAllot.getHoToDate()!=null ){ %> <label
			id="<%=HO_TO_DATE%><%=inc%>" size=8 name="<%=HO_TO_DATE%>"><%= HMSUtil.convertDateToStringWithoutTime(accomAllot.getHoToDate())%></label>
		<%}else{ %> <label id="<%=HO_TO_DATE%><%=inc%>" size=8
			name="<%=HO_TO_DATE %>">-</label> <%}%>
		</td>

		<td><input type="checkbox" class="radio" name="<%=VALIDATED%>"
			id="<%=VALIDATED%><%=inc %>" value="1" /></td>


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
<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkSubmit()&& check()){submitForm('allotAirmen','accom?method=updateSmqVacationOfficer');}"
	align="right" tabindex="1" /> <input name="Button" type="button"
	class="button" value="Reset" onclick="resetValueForAllotment();"
	tabindex="1" />
<div class="division"></div>




<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="a" />
</div>
<div class="Clear"></div>
</div>
</form>