<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>


<form name="bloodEntry" method="post" action=""><script
	type="text/javascript">
		history.forward();
</script> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String monthD = String.valueOf((calendar.get(Calendar.MONTH)));
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
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
	
		if(map.get("componentList") != null){
			componentList=(List)map.get("componentList");
		}
		if(map.get("BloodhdId") != null){
			BloodhdId=(Integer)map.get("BloodhdId");
		}
%>
<div id="contentHolder">
<h6>Blood Request Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String orderSeqNo="";
		if(map.get("orderSeqNo") != null){
			orderSeqNo = (String)map.get("orderSeqNo");
		}
%> <% for (Patient patient:patientList) {%> <label>Order Number</label> <input
	id="orderNoId" type=hidden name="<%=ORDER_NO %>"
	value="<%=orderSeqNo %>" title="Order Number" /> <label class="value"><%=orderSeqNo %></label>
<input type="hidden" id="BloodhdId" name="BloodhdId"
	value="<%= BloodhdId%>" /> <label>Order Date</label> <label
	class="value"><%=currentDate %></label>

<div class=Clear></div>
<label>Service No.</label> <label class="value"><%=patient.getServiceNo()%></label>

<label>HIN No.</label> <label class="value"><%=patient.getHinNo()%></label>

<label>Rank </label> <label class="value"><%=patient.getRank().getRankName()%></label>
<div class=Clear></div>
</div>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame" id="testDiv"><label>Patient Name</label> <label
	class="valueNoWidth"><%=patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName() %></label>

<label>Age </label> <%if(patient.getAge() !=null){ %> <label class="value"><%=patient.getAge()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Blood
Group</label> <%if(patient.getBloodGroup() !=null){ %> <label class="valueNoWidth"><%=patient.getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="valueNoWidth"> - </label> <%} %> <%
			int inpatientId =0;
		
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = patient.getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
								
%>
<div class="Clear"></div>
<label>A&D No</label> <%if(inpatient.getAdNo() != null){ %> <label
	class="valueNoWidth"><%=inpatient.getAdNo()%></label> <%}%> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>" />

<label>Ward</label> <%if(inpatient.getDepartment() != null){ %> <label
	class="valueNoWidth"><%=inpatient.getDepartment().getDepartmentName()%></label>
<%}%> <label>Diagnosis &amp; Brief</label> <%if(inpatient.getDiagnosis() != null){ %>
<label class="valueNoWidth"><%=inpatient.getDiagnosis().getIcdName()%></label>
<%} %> <input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> 
<%}}%> <%//else{%> <!-- 	<label>A&D No</label>
		<label class="valueNoWidth">-</label>
		
		<label>Ward</label>
		<label class="valueNoWidth">-</label>
		
		<label>Diagnosis &amp; Brief</label>
		<label class="valueNoWidth">-</label>- --> <%%> 
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> 
<%} %>

<div class="Clear"></div>
<label>Request Type</label> <select name="<%=REQUEST_TYPE%>"
	onkeypress="return submitenter(this,event,'bloodBank?method=addBloodComponnet')"
	tabindex=1>
	<option value="n">Not Urgent</option>
	<option value="u">Urgent</option>
	<option value="most">Most Urgent</option>
</select></div>
<div class="division"></div>
<div class="blockFrame" id="testDiv"><label class="noWidth">Old Date
&amp; no. of bottles given</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodEntry.<%=DATE%>,event)"
	tabindex=1 /> <input id="bottles" type="text" name="<%= BOTTLES_NO%>"
	value="" validate=" No. of Bottles ,int,no" class="small" MAXLENGTH="3"
	tabindex=1 /> <label> Hb % </label> <input id="hbId" type="text"
	name="<%= HB%>" value="" validate="Hb,string,no" MAXLENGTH="10"
	tabindex=1 /><label class="unit">Gm%</label>

<div class="Clear"></div>
<div class="Height10"></div>

<h2>Presence</h2>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="small">1.</label> <input id="presence1Id" type="text"
	name="<%= PRESENCE1%>" value="" validate="1,string,no" size="60"
	class="Auto" MAXLENGTH="50" tabindex=1 /> <label class="small">2.</label>
<label class="noWidth"> Fever</label> <input id="feverId" type="text"
	name="<%= FEVER%>" value="" validate="Fever,string,no" MAXLENGTH="30"
	tabindex=1 /> <label class="noWidth">of Time</label> <input
	id="ofTimeId" type="text" name="<%= OF_TIME%>" value=""
	validate="Of Time,string,no" onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="5" tabindex=1 />

<div class="Clear"></div>

<label class="small">3.</label> <input id="presence2Id" type="text"
	name="<%= IF_ANY%>" value="" validate="if any,string,no" class="Auto"
	size="60" MAXLENGTH="50" tabindex=1 /><label class="unit">(if
any)</label>
<div class="Clear"></div>
<label class="small">4.</label> <label class="noWidth">History
of Pregnancies(if any)</label> <input id="pregnanciesId" type="text"
	name="<%= PREGNANCIES%>" value=""
	validate="History of Pregnancies,string,no" MAXLENGTH="50" tabindex=1
	class="Auto" size="60" />
<div class="Clear"></div>
<label class="small">5. </label> <label class="noWidth">With
specific reference and diagnostic disease of new born</label> <input
	id="diagnosticId" type="text" name="<%= SPECIFIC_REFERENCE%>" value=""
	validate="With specific reference and diagnostic disease of new born of Pregnancies,string,no"
	size="60" class="Auto" MAXLENGTH="50" tabindex=1 /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
</div>
<div class="Clear"></div>
<div class="division"></div>

<div class="tableHolderAuto">

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">SR No</th>
			<th width="10%">Component Name</th>
			<th width="7%">Qty(ml)</th>
			<th width="10%">Required on Date</th>
		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 0;    	
    	if(pageNo!=1){
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(inc=1;inc<=8;inc++){
    	    	  
    %>

		<tr>

			<td width="5%">
			<input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> 
			<input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>" id="bloodComponentId<%=inc %>" tabindex=1 />
			</td>
			<td>
			<input type="text" id="componentName<%=inc%>" name="<%=BLOOD_COMPONENT_NAME%>" onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" tabindex=1  />
			<div id="ac2update6" style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('componentName<%=inc %>','ac2update6','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=<%=BLOOD_COMPONENT_NAME%><%=inc %>'});
			</script>
			</td>
			<td>
			<input type="text" id="quantity<%=inc%>" name="<%=QUANTITY %>" value="" validate="Qty,int,no" MAXLENGTH="3" tabindex=1 />
			</td>
			<td>
			<input type="text" class="calDate" id="reqDateId<%=inc%>" name="<%=REQUIRED_DATE %>" value="" readonly="readonly" MAXLENGTH="30" onblur="if(this.value!=''){validateRequiredDate(<%=inc %>);};" tabindex=1 /> 
			<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('reqDateId<%=inc%>'),event)" tabindex=1 />
			</td>
		</tr>
		<%} %>
	</tbody>
</table>
<input type="hidden" name="rowCount" value="<%=inc %>"></div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="if(checkFilledRow()){submitForm('bloodEntry','bloodBank?method=submitBloodRequestEntry');}"
	align="right" tabindex=1 /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodEntry',<%=inc %>);" accesskey="r"
	tabindex=1 />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
</form>
<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function clearAllFields(inc){
	var componentCode = document.getElementById('componentCode'+inc).value
	var quantity = document.getElementById('quantity'+inc).value;
	var reqDate = document.getElementById('reqDateId'+inc).value;
	
}

function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		document.getElementById('bloodComponentId'+i).value= componentId ;
		
		ajaxFunctionForAutoCompleteComponentName('bloodEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
		}
}



function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one Component to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('quantity'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('reqDateId'+i).value == ""){
	  				msg += "Required Date can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
	 
	function validateRequiredDate(inc){
		var currentDate = new Date(<%=year%>,<%= monthD  %> ,<%= dateCal%>);
		obj1 = eval(document.getElementById("reqDateId"+inc))
		var validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
				if(validFromDate < currentDate)
				{
				alert("Required Date should not be Past date\n");
				document.getElementById("reqDateId"+inc).value=""
				return false;
				}
		
	
		return true;
	}
</script>


