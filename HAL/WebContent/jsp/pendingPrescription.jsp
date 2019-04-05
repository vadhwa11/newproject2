<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script>
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
for(var i = 0; i < document.getElementsByName('<%=SELECT%>').length; i++){
var msg="";

	if(document.getElementsByName('<%=SELECT%>')[i].checked == false){
	  	msg =" Please select The items ";
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

List<PatientPrescriptionDetails> presList = new ArrayList<PatientPrescriptionDetails>();
PatientPrescriptionDetails details = new PatientPrescriptionDetails();


try{
	if(map.get("presList") != null){
		presList=(List<PatientPrescriptionDetails>)map.get("presList");
	}
if(presList != null){
	details = (PatientPrescriptionDetails)presList.get(0);
}
}catch(Exception e){
	e.printStackTrace();
}
	System.out.println("presList---- "+presList.size());
 %>
<%
 String message ="";
 if (map.get("message") != null) {
 	message = (String) map.get("message");
  }
 if(!message.equalsIgnoreCase("")){
 %>
<%=message %>
<%} %>

<script>
function CheckAll(chk)
{
for (var i=0;i < document.relegationProcess.elements.length;i++)
	{
		var e = document.relegationProcess.elements[i];

		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
}

function reset(rowVal){
for (var i=0;i < document.relegationProcess.elements.length;i++)
{
document.getElementById('checkId'+i).value = ""
}
}
</script>
<div id="contentHolder">
<h6>Pending Prescriptions</h6>
<form name="relegationProcess" method="post" action="">
<div class="Clear"></div>
<div class="blockTitle">Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Hin No.</label><%=details.getPrescription().getHin().getHinNo() %>
<div class="Clear"></div>


</div>

<div class="blockTitle">Prescription Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label> Date</label> <label class="valueNoWidth"><%=date%></label>

<label> Time</label> <label class="valueNoWidth"><%=time%></label>

</div>
<div class="Clear"></div>
<div class="height10"></div>

<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Item</th>
		<th scope="col">Dosage</th>
		<th scope="col">No Of Days</th>
		<th scope="col">Frequency</th>
		<th scope="col">Total</th>
		<th scope ="col">Select</br>
		<input type="checkbox" class="check" name="checkall" value="Select All" id="addbutton" onclick="CheckAll(this);"/></th>
	</tr>
	<%
   		 int inc = 0;
	if( presList.size() > 0){
  		 for(PatientPrescriptionDetails patientDetails: presList){
  			 inc++;
   %>
	<tr>

		<td> <%=patientDetails.getItem().getNomenclature() %>
		<input type ="hidden" name="patientDetailId" id ="patientDetailId<%=inc %>" value ="<%=patientDetails.getId() %>">
		<input type ="hidden" name="patientHeaderId" id ="patientHeaderId<%=inc %>" value ="<%=patientDetails.getPrescription().getId() %>">
		<input type ="hidden" name="itemId" id ="itemId<%=inc %>" value ="<%=patientDetails.getItem().getId() %>">
		<input type ="hidden" name="hospitalId" id ="hospitalId<%=inc %>" value ="<%=hospitalId%>">
		<input type ="hidden" name="deptId" id ="deptId<%=inc %>" value ="<%=deptId%>">
		<input type ="hidden" name="<%=CHANGED_BY%>" id="<%=CHANGED_BY %><%=inc %>" value="<%=userName%>" />
		<input type ="hidden" name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %><%=inc %>" value="<%=date%>" />
		<input type ="hidden" name="<%=CHANGED_TIME %>" id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" />


		</td>
		<td><%=patientDetails.getDosage() %></td>
		<td><%=patientDetails.getNoOfDays() %></td>
		<td><%=patientDetails.getFrequency().getFrequencyName() %></td>
		<td><%=patientDetails.getTotal() %></td>
		<td><input id="checkId<%=inc %>" name="<%=SELECT %>" type="checkbox" class="check" /></td>
		<%}}else{ %>
		No Records Found
		<%} %>
	</tr>
</table>
</div>

<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom">
<input type="button" class="button" value="Submit" onclick="if(checkSubmit()){submitForm('relegationProcess','opd?method=submitPendingPrescriptionDetails');}"
	align="right" tabindex="1" />
<input name="Button" type="button" class="button" value="Reset" onclick="reset(this);"	tabindex="1" />
<input name="Button" type="button" class="button" value="Back" onclick="submitFormForButton('relegationProcess','opd?method=showPendingPrescriptionJsp')"
	tabindex="1" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label><label class="value"><%=time%></label>
<input type="hidden"name="<%=CHANGED_BY%>" id="<%=CHANGED_BY %><%=inc %>"value="<%=userName%>" />
<input type="hidden"name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %><%=inc %>"value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" />
<div class="Clear"></div>
</div>
</form>
</div>