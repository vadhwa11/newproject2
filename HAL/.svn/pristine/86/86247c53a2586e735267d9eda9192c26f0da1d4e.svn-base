<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script>
function inputValue(){
		for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please Validate The Result.")
		return false;
	}
</script>
<script>
function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValue(){
for(i=1;i<=document.getElementById('counter').value;i++)
{
document.getElementById('<%=VALIDATED%>'+i).checked = false;

}
document.getElementById('remarks').value=""
}
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
function checkSubmit(){
var inc=0;
for(var i = 0; i < document.getElementsByName('<%=VALIDATED%>').length; i++){
var msg="";

	if(document.getElementsByName('<%=VALIDATED%>')[i].checked == false){
	  	msg ="Please Cancel Atleast One Record";
	  	}else{
	  		break;
	  	}
} 	
	
 if(msg !=""){
	 alert(msg)
	 return false;
 }else{
	 return true;
	}
}

</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName="";
if(session.getAttribute("userName") != null){
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

List<AccomAllotment> cancelDetailList = new ArrayList<AccomAllotment>();
AccomAllotment accomAllotment = new AccomAllotment();
try{
	if(map.get("cancelDetailList") != null){
		cancelDetailList=(List<AccomAllotment>)map.get("cancelDetailList");
	}
	
}catch(Exception e){
	e.printStackTrace();
}
int allotmentId=0;
 if(cancelDetailList != null){
	 accomAllotment = (AccomAllotment)cancelDetailList.get(0);
 }
 allotmentId = accomAllotment.getId();
 String cancelNo="";
 if(map.get("cancelNo")!= null){
	 cancelNo= (String)map.get("cancelNo");
 }
 %>
<% 
 String message ="";
 if (map.get("message") != null) {
 	message = (String) map.get("message");
  }
 if(!message.equalsIgnoreCase("")){
 %>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Cancellation of Allotment Order for Airmen</h6>
<form name="relegationProcess" method="post" action="">
<div class="Clear"></div>


<div class="blockTitle">Cancellation</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Cancellation No.</label> <label class="valueNoWidth"><%=cancelNo %></label>

<label>Cancellation Date</label> <label class="valueNoWidth"><%=date%></label>




<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="height10"></div>

<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sr.No</th>
		<th scope="col">Register No</th>
		<th scope="col">Register Date</th>
		<th scope="col">Allotment Order No</th>
		<th scope="col">Allotment Order Date</th>
		<th scope="col">Service No</th>
		<th scope="col">Name</th>
		<th scope="col">Rank</th>
		<th scope="col">Smq No</th>
		<th scope="col">Type Of Allotment</th>
		<th scope="col">Allotment Date</th>
		<th scope="col">Ho To date</th>
		<th scope="col">Cancel</th>

	</tr>
	<%
   int inc = 0;
  		 for(AccomAllotment cancel:cancelDetailList){
  			 inc++;
   %>
	<tr>

		<td><label id="<%=SR_NO %><%=inc%>" name="<%=SR_NO%>"><%=inc%></label>
		<input type="hidden" name="<%=SR_NO %>" id="<%=SR_NO %><%=inc %>"
			value="<%=inc %>"> <input type="hidden"
			name="<%=CHANGED_BY%>" id="<%=CHANGED_BY %><%=inc %>"
			value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %><%=inc %>"
			value="<%=date%>" /> <input type="hidden" name="<%=CHANGED_TIME %>"
			id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" /> <input
			type="hidden" name="<%=CANCEL_NO %>" id="<%=CANCEL_NO %><%=inc %>"
			value="<%=cancelNo%>" /> <input type="hidden"
			name="<%=CANCEL_DATE %>" id="<%=CANCEL_DATE %><%=inc %>"
			value="<%=date%>" /> <input type="hidden" name="<%=DEPARTMENT_ID %>"
			id="<%=DEPARTMENT_ID %><%=inc %>" value="<%=deptId%>" /> <input
			type="hidden" name="<%=HOSPITAL_ID %>"
			id="<%=HOSPITAL_ID %><%=inc %>" value="<%=hospitalId%>" /> <input
			type="hidden" name="<%=SMQ_ID %>" id="<%=SMQ_ID %><%=inc %>"
			value="<%=cancel.getSmq().getId()%>" /></td>

		<td><input type="hidden" name="<%=REGISTRATION_ID %>"
			id="<%=REGISTRATION_ID %>" value="<%= cancel.getAccom().getId() %>" />
		<label name="<%=REGISTRATION_NO %>" id="<%=REGISTRATION_NO %>"><%= cancel.getAccom().getRegistrationNo() %></label>
		</td>

		<td><label name="<%=REGISTRATION_DATE %>"
			id="<%=REGISTRATION_DATE %>"><%=HMSUtil.convertDateToStringWithoutTime(cancel.getAccom().getRegistrationDate()) %></label>
		</td>

		<td><label name="<%=ALLOTMENT_NO %>" id="<%=ALLOTMENT_NO %>"><%= cancel.getAllotmentNo() %></label>
		</td>

		<td><label name="<%=ALLOTMENT_DATE %>" id="<%=ALLOTMENT_DATE %>"><%=HMSUtil.convertDateToStringWithoutTime(cancel.getAllotmentDate())%></label>
		</td>

		<td><label name="<%=SERVICE_NO %>" id="<%=SERVICE_NO %>"><%= cancel.getAccom().getServiceNo() %></label>
		</td>

		<td><label name="<%=SERVICE_PERSON_NAME %>"
			id="<%=SERVICE_PERSON_NAME %>"><%= cancel.getAccom().getServicePersonName() %></label>
		</td>

		<td><label name="<%=RANK_ID %>" id="<%=RANK_ID %>"><%= cancel.getRank().getRankName() %></label>
		</td>

		<td><label name="<%=SMQ_ID %>" id="<%=SMQ_ID %>"><%= cancel.getSmq().getSmqName() %></label>
		</td>

		<td>
		<%if(cancel.getAllotmentType().equalsIgnoreCase("t")){ %> <label
			name="<%=TYPE_OF_ALLOTMENT %>" id="<%=TYPE_OF_ALLOTMENT %>">TMQ/Non
		Status</label> <%}else if(cancel.getAllotmentType().equalsIgnoreCase("s")){ %> <label
			name="<%=TYPE_OF_ALLOTMENT %>" id="<%=TYPE_OF_ALLOTMENT %>">Status</label>
		<%}else if(cancel.getAllotmentType().equalsIgnoreCase("m")){ %> <label
			name="<%=TYPE_OF_ALLOTMENT %>" id="<%=TYPE_OF_ALLOTMENT %>">Medical
		Grounds</label> <%}else if(cancel.getAllotmentType().equalsIgnoreCase("a")){ %>
		<label name="<%=TYPE_OF_ALLOTMENT %>" id="<%=TYPE_OF_ALLOTMENT %>">Admin
		Grounds</label> <%}else if(cancel.getAllotmentType().equalsIgnoreCase("r")){ %>
		<label name="<%=TYPE_OF_ALLOTMENT %>" id="<%=TYPE_OF_ALLOTMENT %>">Retention</label>
		<%}else{ %> <label name="<%=TYPE_OF_ALLOTMENT %>"
			id="<%=TYPE_OF_ALLOTMENT %>">-</label> <%} %>
		</td>

		<td><label name="<%=ALLOTMENT_DATE %>" id="<%=ALLOTMENT_DATE %>"><%=HMSUtil.convertDateToStringWithoutTime(cancel.getAllotmentDate())%></label>
		</td>

		<td><label name="<%=HO_TO_DATE %>" id="<%=HO_TO_DATE %>"><%=HMSUtil.convertDateToStringWithoutTime(cancel.getHoToDate())%></label>
		</td>

		<td><input type="checkbox" class="radio" name="<%=VALIDATED%>"
			id="<%=VALIDATED%><%=inc %>" value="1" /></td>

		<%} %>
	</tr>
</table>
</div>
<div class="division"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="blockFrame"><label class="medium">Remarks</label> <textarea
	value="" class="large" name="<%=REMARKS %>" id="<%=REMARKS %>"
	maxlength="50" onkeyup="chkLength(this,50);"
	validate="Remarks,string,no" tabindex="1"></textarea></div>
<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkSubmit()){submitForm('relegationProcess','accom?method=submitCancellationForAirmen');}"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetValue();" tabindex="1" /> <input
	name="Button" type="button" class="button" value="Back"
	onclick="submitFormForButton('relegationProcess','accom?method=cancelForAirmen')"
	tabindex="1" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>


<div class="Clear"></div>


</div>
</form>
</div>