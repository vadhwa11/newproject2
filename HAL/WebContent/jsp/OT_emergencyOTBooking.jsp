<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">


ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})



</script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
			
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	
	String deptName=null;
	if(map.get("deptName") != null){
		deptName=(String)map.get("deptName");
	}
	int orderNo=0;
	if(map.get("orderNo") != null){
		orderNo=(Integer)map.get("orderNo");
	}
	int deptId=0;
	if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
	}
	 List otList= new ArrayList();
	 List empList= new ArrayList();
	 List patientList= new ArrayList();
	
	if(map.get("otList") != null){
		otList=(List)map.get("otList");
	}
	if(map.get("empList") != null){
		empList=(List)map.get("empList");
	}
	
	if(map.get("patientList") != null){
		patientList=(List)map.get("patientList");
	}
	Patient patient=(Patient)patientList.get(0);
	
	String patientName="";
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
	}
	String servicePersonName="";
	if(patient.getSFirstName()!= null){
		servicePersonName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSLastName();
	}
	 
	
	%>

<script type="text/javascript">
		 function checkSurgeryValueForAutoComplete(strValue) {
 			
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    //alert("id----"+id)
		    
		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName').value="";
	   				document.getElementById('chargeCode').value="";
 					return ;
 			}else{
 				document.getElementById('chargeCode').value=id;
 				
 			}
 			
		}	
		
		function checkEmergencyOTBookingForm() {
 			
		    if(document.getElementById('chargeCodeName').value ==""){
		       alert("Please Enter The Surgery Of the patient.")
		       return false;
		    }
		    if(document.getElementById('surgeonName1').value ==""){
		      alert("Please Enter the surgeon Name")
		      return false;
		    }		
		    if(document.getElementById('grade').value ==""){
		      alert("Please Enter the Anesthetic Technique Planned.")
		    }
		    return true;
		}
</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="emergencyOTBooking" method="post" action="">
<h6>OT-Booking Form</h6>
<div class="Clear"></div>
<div class="header"><label>Order Number</label> <label
	class="value"><%=orderNo %></label> <label>Department</label> <label
	class="value"><%=deptName %></label> <input type="hidden"
	name="<%=DEPT_ID%>" value="<%=deptId %>" /> <label>Date</label> <label
	class="value"><%=currentDate %></label></div>
<div class="Clear"></div>
<!--Block One Starts-->
<div class="blockTitle">Serving Personal Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(patient.getServiceType()!= null){ %>
<label class="valuemedium"><%=patient.getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(patient.getServiceNo()!= null){ %>
<label class="valuemedium"><%=patient.getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">
Serv. Status </label> <%if(patient.getServiceStatus()!= null){ %> <label
	class="valuemedium"><%=patient.getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium"><%=servicePersonName %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(patient.getRelation() != null){ %>
<label class="valuemedium"><%=patient.getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(patient.getRank()!= null){ %> <label
	class="valuemedium"><%=patient.getRank().getRankName() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Unit</label>
<%if(patient.getUnit()!= null){ %> <label class="valuemedium"><%=patient.getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(patient.getUnit()!= null){%> <label
	class="valuemedium"><%=patient.getUnit().getUnitAddress() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Telephone No</label> <% if(patient.getMobileNumber()!= null && !patient.getMobileNumber().equals("")){%>
<label class="valuemedium"><%=patient.getMobileNumber() %></label> <%}else{ %>
<label class="valuemedium">---</label> <%} %>

<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(patient.getHinNo()!= null){ %>
<label class="valuemedium"><%=patient.getHinNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name </label> <%if(patientName!= null){ %> <label class="valuemedium"><%=patientName %>
</label> <%}else{ %> <label class="valuemedium">- </label> <%} %> <label
	class="medium">Age</label> <%if(patient.getAge()!= null){ %> <label
	class="valuemedium"><%=patient.getAge() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">REQ.
Date </label> <label class="valuemedium">-</label>

<div class="Clear"></div>




<label class="medium">ECHS No. </label> <%if(patient.getEchsNo()!= null){ %>
<label class="valuemedium"><%=patient.getEchsNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockTitle">OT Booking</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="noWidth">&nbsp;&nbsp;Surgery
Name<span>*</span></label> <input type="text" value="" tabindex="1"
	id="chargeCodeName" size="43" name="chargeCodeName"
	onblur="checkSurgeryValueForAutoComplete(this.value)"
	validate="Surgery Name,string,yes" />
<div id="ac2update2"
	style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('chargeCodeName','ac2update2','opd?method=getChargeCodeListForAutoComplete&deptId=<%=deptId%>',{parameters:'requiredField=chargeCodeName'});
			</script> <input type="hidden" value="" name="chargeCode" id="chargeCode" /> <label
	class="medium">Surgery Date</label> <input type="text" id="surgeryDate"
	name="surgeryDate" value="" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0"
	onclick="setdate('<%=currentDate %>',document.emergencyOTBooking.surgeryDate,event);"
	validate="Pick a date" class="calender" /> <label class="medium">Surgery
Time</label> <input type="text" name="surgeryTime" id="surgeryTime"
	maxlength="5" />
<div class="Clear"></div>
<label class="medium">OT Name<span>*</span></label> <select name="otId"
	id="otId" validate="OT Name,string,yes" class="listSm">
	<option value="0">Select</option>
	<%
					  Iterator itr1= otList.iterator();
					  while(itr1.hasNext())
					  {
						  MasOt ot=(MasOt)itr1.next();
						int otId=ot.getId();

						String otName=ot.getOtName();
					%>
	<option value="<%=otId %>"><%=otName %></option>
	<%
	 			 }
				%>
</select> <label class="medium">Booked By<span>*</span></label> <select
	name="empId" id="empId" validate="Booked By,string,yes" class="listSm">
	<option value="0">Select</option>
	<%
					  Iterator itr2= empList.iterator();
					  while(itr2.hasNext())
					  {
						  MasEmployee masEmployee=(MasEmployee)itr2.next();
						int empId=masEmployee.getId();
						String empName="";
						if(masEmployee.getFirstName()!= null)
						    empName=masEmployee.getFirstName();
						if(masEmployee.getMiddleName()!= null)
							empName=empName + masEmployee.getMiddleName();
						if(masEmployee.getLastName()!= null)
							empName=empName + masEmployee.getLastName();
					%>
	<option value="<%=empId %>"><%=empName %></option>
	<%
	 			 }
				%>
</select>
<div class="Clear"></div>

<label class="noWidth">&nbsp;&nbsp;Anesthetic Technique Planned<span>*</span></label>
<select name="grade" id="grade"
	validate="Anesthetic Technique Planned,string,yes">
	<option value="">Select</option>
	<option value="GA">GA</option>
	<option value="SA">SA</option>
	<option value="EA">EA</option>
	<option value="LA">LA</option>
	<option value="RA">RA</option>
	<option value="DA">DA</option>
</select> <label class="medium">ASA GRADE</label> <select name="asa" id="asa">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="III">III</option>
	<option value="IV">IV</option>
	<option value="V">V</option>
</select></div>

<div class="floatLeft">
<div class="title">Surgeon's List</div>
<div class="Clear"></div>

<input type="button" class="ButtonDel" alt="Delete" value=" "
	onclick="removeRow();" align="right" /> <input type="button"
	class="ButtonAdd" alt="Add" value=" " onclick="addSurgeonList();"
	align="right" />
<div class="Clear"></div>
<div class="floatLeft">
<div class="tableHholder">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="surgeonGrid">
	<tr>
		<th scope="col">S.No</th>
		<th scope="col">Surgeon Name</th>
	</tr>
	<tr>
		<td><input type="text" size="2" value="1" /></td>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="surgeonName1" size="43" name="surgeonName1" />
		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('surgeonName1','ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName1'});
				</script></td>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	</tr>
</table>
<div class="Clear"></div>

</div>
</div>

</div>



<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('emergencyOTBooking','ot?method=submitEmergencyOTBookingDetails');" />
<input name="hinId" type="hidden" value="<%=patient.getId() %>" /> <input
	name="patientStatus" type="hidden" value="" /> <input name="orderNo"
	type="hidden" value="<%=orderNo %>" /> <input name="hospitalId"
	type="hidden" value="<%=hospitalId %>" /> <input name="changedBy"
	type="hidden" value="<%=userName %>" /> <input name="changedDate"
	type="hidden" value="<%=currentDate %>" /> <input name="changedTime"
	type="hidden" value="<%=currentTime %>" /> <input name="back"
	type="button" class="button" value="Back"
	onclick="showBack('emergencyOTBooking')" /></div>


</div>
</form>
</div>

</div>
<script type="text/javascript">

	

	
    function removeRow()
	{
	  var tbl = document.getElementById('surgeonGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
 
 	function addSurgeonList(){
		
	  var tbl = document.getElementById('surgeonGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
	 
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2'
	  cellRightSel.appendChild(sel);
	 
	 
	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  
	  e0.name = 'surgeonName' + iteration;
	  e0.id = 'surgeonName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('surgeonName'+iteration,'ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName'+iteration});
	 
	}
</script>
<script type="text/javascript">
	
	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showEmergencyOTBookingPatientSearch";
	  obj.submit();
	}
	</script>
