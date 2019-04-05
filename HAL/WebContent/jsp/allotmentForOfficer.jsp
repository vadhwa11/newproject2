<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.AccomRegistration"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.MasCarGarage"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>


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
List<AccomRegistration> officerRegList=new ArrayList<AccomRegistration>();
if (map.get("officerRegList") != null) {
	officerRegList = (List<AccomRegistration>) map.get("officerRegList");
	
}
List<MasSmq> smqList = new ArrayList<MasSmq>();
if (map.get("smqList") != null) 
{
	smqList = (List<MasSmq>) map.get("smqList");
}
List<MasCarGarage> garageList = new ArrayList<MasCarGarage>();
if(map.get("garageList") != null){
	garageList = (List<MasCarGarage>)map.get("garageList");
	}
List<MasCarGarage> garageNoList = new ArrayList<MasCarGarage>();
if(map.get("garageNoList") != null){
	garageNoList = (List<MasCarGarage>)map.get("garageNoList");
	}
String allotmentNo="";
if(map.get("allotmentNo") != null){
	allotmentNo = (String)map.get("allotmentNo");	
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
document.getElementById('remarks'+i).value = "";
for(var i=1;i<document.getElementById('counter').value;i++)
{
document.getElementById('smqName'+i).value="";
document.getElementById('typeOfAllotment'+i).value="";

}
return false;
}
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
var j;
   for(j=1;j<=document.getElementById('counter').value ;j++){
   
    if(document.getElementById('smqName'+j).value == ""){
   alert('Please Select SMQ no to submit record');
   return false;
   }
   else
   	return true;
   
   	}
   }


</script>
<div id="contentHolder">
<h6>Allotment Married Accommodation</h6>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Pool Code</label> <select
	id="<%=POOL_ID %>" name="<%=POOL_ID %>" validate="Pool Code,string,yes"
	tabindex="1"
	onblur="submitForm('allotAirmen','accom?method=getRecordsForOfficerAllotment');"
	onchange="submitForm('allotAirmen','accom?method=getRecordsForOfficerAllotment');">
	<option value="0">Select</option>
	<% 
				for(MasPool masPool : poolList){
					if(masPool.getId()== box.getInt(POOL_ID )){
					
			%>
	<option value="<%=masPool.getId() %>" selected="selected"><%=masPool.getPoolName()%></option>
	<%}else{%>
	<option value="<%=masPool.getId() %>"><%=masPool.getPoolName()%></option>
	<%}
					}%>
</select> <label><span>*</span> Allotment Order File No</label> <input
	type="text" value="<%=allotmentNo %>" name="<%=ALLOTMENT_NO %>"
	id="<%=ALLOTMENT_NO %>" readonly="readonly" /> <label><span>*</span>Allotment
Order File Date</label> <input type="text" value="<%=date %>"
	name="<%=ALLOTMENT_ORDER_DATE %>" id="<%=ALLOTMENT_ORDER_DATE %>"
	readonly="readonly" /></div>
<% 

int poolId =0;
String poolName = "";
if(box.getInt(POOL_ID )== 0){
	poolId=0;
}else{
	poolId = box.getInt(POOL_ID );
}

if(officerRegList != null){%>
<div class="Clear"></div>
<label class="common">Selected Pool Code</label> <input type="hidden"
	name="<%=NAME %>" id="<%=NAME %>" value="<%=poolId %>" /> <%
  Iterator<MasPool> ite=poolList.iterator();
    	 while ( ite.hasNext() ) {
     		MasPool msPool=(MasPool)ite.next();
     		if(msPool.getId()==poolId)
     		{
     			
     			
     %> <script type="text/javascript">poolSelected=true;</script> <label
	class="value"> <%=msPool.getPoolName()%></label> <%	poolName = msPool.getPoolName();	
    }
    	 }
     }
    %>

<div class="Clear"></div>
<div class="height10"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sr.No.</th>
		<th scope="col">Registration No.</th>
		<th scope="col">Register Date</th>
		<th scope="col">Service No</th>
		<th scope="col">Name</th>
		<th scope="col">Rank</th>
		<th scope="col">SMQ no</th>
		<th scope="col">Type Of Allotment</th>
		<th scope="col">Type Of Garage</th>
		<th scope="col">Garage No</th>
		<th scope="col">Allotment Date</th>
		<th scope="col">Ho/To Date</th>
	</tr>
	<%
	    int inc = 0; 
	    String regDate="";
	    Date registrationDate ;
	    if (officerRegList!=null && officerRegList.size()>0)
	     {
	    	Iterator<AccomRegistration> ite=officerRegList.iterator();
	   			 while ( ite.hasNext() ) {
		    		AccomRegistration accomReg=(AccomRegistration)ite.next();
		    		registrationDate = accomReg.getRegistrationDate();
		    		regDate = HMSUtil.convertDateToStringWithoutTime(registrationDate);
		    		inc++;
    	%>
	<tr>
		<td><label id="<%=SR_NO %>" name="<%=SR_NO%>"><%=inc%></label> <input
			type="hidden" name="<%=ACCOM_ID %>" id="<%=ACCOM_ID %><%=inc %>"
			value="<%=accomReg.getId() %>" /> <input type="hidden"
			name="<%=REGISTRATION_STATUS %>"
			id="<%=REGISTRATION_STATUS %><%=inc %>"
			value="<%=accomReg.getRegStatus() %>" /> <input type="hidden"
			name="<%=DEPARTMENT_ID %>" id="<%=DEPARTMENT_ID %><%=inc %>"
			value="<%=deptId %>" /> <input type="hidden" name="<%=HOSPITAL_ID %>"
			id="<%=HOSPITAL_ID %><%=inc %>" value="<%=hospitalId%>" /> <input
			type="hidden" name="<%=POOL_NAME %>" id="<%=POOL_NAME %>"
			value="<%=poolId %>" /> <input type="hidden" name="<%=CHANGED_BY%>"
			value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
			name="<%=CHANGED_TIME %>" value="<%=time%>" /></td>

		<td>
		<%if(accomReg.getRegistrationNo()!=null && accomReg.getRegistrationNo()!=""){ %>
		<label id="<%=REGISTRATION_NO%><%=inc%>" size=8
			name="<%=REGISTRATION_NO%>"><%=accomReg.getRegistrationNo()%></label>
		<%}else{ %> <label id="<%=REGISTRATION_NO%><%=inc%>" size=8
			name="<%=REGISTRATION_NO%>">-</label> <%}%>
		</td>

		<td>
		<%if(accomReg.getRegistrationDate()!=null){ %> <label
			id="<%=REGISTRATION_DATE%><%=inc%>" size=8
			name="<%=REGISTRATION_DATE%>"><%=regDate%></label> <%}else{ %> <label
			id="<%=REGISTRATION_DATE%><%=inc%>" size=8
			name="<%=REGISTRATION_DATE%>">-</label> <%}%>
		</td>

		<td>
		<%if(accomReg.getServiceNo()!=null && accomReg.getServiceNo()!=""){ %> <label
			id="<%=SERVICE_NO%><%=inc%>" size=8 name="<%=SERVICE_NO%>"><%=accomReg.getServiceNo()%></label>
		<%}else{ %> <label id="<%=SERVICE_NO%><%=inc%>" size=8
			name="<%=SERVICE_NO %>">-</label> <%}%>
		</td>

		<td>
		<%if(accomReg.getServicePersonName()!=null && accomReg.getServicePersonName()!=""){ %>
		<label id="<%=SERVICE_PERSON_NAME%><%=inc%>" size=8
			name="<%=SERVICE_PERSON_NAME%>"><%=accomReg.getServicePersonName()%></label>
		<%}else{ %> <label id="<%=SERVICE_PERSON_NAME%><%=inc%>" size=8
			name="<%=SERVICE_PERSON_NAME %>">-</label> <%}%>
		</td>

		<td>
		<%if(accomReg.getRank()!=null ){ %> <label id="<%=RANK_NAME%><%=inc%>"
			size=8 name="<%=RANK_NAME%>"><%=accomReg.getRank().getRankName()%></label>
		<input type="hidden" id="<%=RANK_ID%><%=inc%>" name="<%=RANK_ID%>"
			value="<%=accomReg.getRank().getId() %>" /> <%}else{ %> <label
			id="<%=RANK_NAME%><%=inc%>" size=8 name="<%=RANK_NAME %>">-</label> <input
			type="hidden" id="<%=RANK_ID%><%=inc%>" name="<%=RANK_ID %>" value="" />
		<%}%>
		</td>

		<td><select name="<%=SMQ_NAME %>" id="<%=SMQ_NAME %><%=inc%>"
			onchange="generateAllotmentNo(this,'<%=inc %>');">
			<option value="">Select SMQ</option>
			<% 	if(smqList!= null)
	 	{
	  		for(MasSmq masSmq : smqList)
	  		{
	  			if(masSmq.getId() != null)
	  			{ 
	  				 %>
			<option value="<%=masSmq.getId()%>"><%=masSmq.getSmqName()%></option>

			<%
	  			}
	  		}
	  	}
	  %>
		</select></td>

		<td><select class="large" name="<%=TYPE_OF_ALLOTMENT %>"
			id="<%=TYPE_OF_ALLOTMENT %><%=inc%>" />
			<option value="">Select</option>
			<option value="1">Permanent</option>
			<option value="2">Temporary</option>
			<option value="3">Reimbursed</option>
			<option value="4">MEO</option>
		</select></td>

		<td><select name="<%=GARAGE_ID%><%=inc %>"
			id="<%=GARAGE_ID%><%=inc%>"
			onchange="fillGarageNo(this.value,<%=inc%>);" />
			<option value="">Select Garage</option>
			<% 	
	  if(garageList!= null)
	 	{
	  		for(MasCarGarage masCarGarage : garageList)
	  		{
	  			if(masCarGarage.getId() != null)
	  			{  
	  				 %>
			<option value="<%=masCarGarage.getId()%>"><%=masCarGarage.getCarGarageName() %></option>

			<%
	  			}
	  			 
	  		}
	  	}
	  %>
		</select></td>
		<% 
 			int garage=0;
 			String garageName = ""; 
 		 	%>


		<script type="text/javascript">
				function fillGarageNo(obj,inc){
		<%		
		if(garageList !=  null){		
				for (MasCarGarage masCarGarage : garageList) 
								{
										%>
										var invObj =<%= masCarGarage.getId()%>
										if(invObj == obj){
 							
 							document.getElementById('garageName'+inc).value = "<%=masCarGarage.getCarGarageCode()%>"
 							document.getElementById('garage'+inc).value = "<%=masCarGarage.getId()%>"
 					
								}
			<%}	}  %>	
 			}		
 			</script>


		<td><input type="text" name="<%=GARAGE_NAME%>"
			value="<%=garageName %>" id="<%=GARAGE_NAME%><%=inc%>"
			validate="Garage Code,string,no" readonly="readonly" tabindex=1 /> <input
			type="hidden" name="garage" value="<%=garage %>" id="garage<%=inc %>"/></td>

		<td><label><%=date %></label> <input
			id="<%=ALLOTMENT_TIME %><%=inc %>" name="<%=ALLOTMENT_TIME %>"
			value="<%=time %>" type="hidden" /> <input
			id="<%=ALLOTMENT_DATE %><%=inc %>" name="<%=ALLOTMENT_DATE %>"
			value="<%=date %>" type="hidden" /></td>
		<td><label><%=date %></label> <input
			id="<%=HO_TO_DATE %><%=inc %>" name="<%=HO_TO_DATE %>"
			value="<%=date %>" type="hidden" /></td>
	</tr>


	<%}
   	 } else{%>
	<tr>
		<td colspan=14 align="center">No Records Found.</td>
	</tr>
	<%} %>

</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label>Remarks</label> <textarea value=""
	name="<%=REMARKS %>" class="large" id="<%=REMARKS %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Remarks,string,no" tabindex="1"></textarea>
</div>
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkSubmit() && check()){submitForm('allotAirmen','accom?method=submitAllotmentForOfficer');}"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetValueForAllotment();" tabindex="1" />

<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="o" />
</div>
<div class="Clear"></div>
</div>
</form>