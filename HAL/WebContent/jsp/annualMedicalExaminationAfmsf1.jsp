<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.util.Box" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>

<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
	<script type="text/javascript">
	function checkAfmsfReceipt(){

	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("lastUnit").value==0){
			errMsg=errMsg+"Select Last Unit \n"
		}
		
		if(errMsg==""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
	</script>
	<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
		
	</script>
	<script type="text/javascript">


function closeExistingRecord(){
     annualMedicalExamination.method="post";
     if(confirm("Are you Sure, you want to close the details ?"))
     submitForm('annualMedicalExamination','mis?method=closeExistingRecord');
     else
     return false;
}

function getOldDetails(){
  var exitCom = document.getElementById('exitComb').value
  
  if(exitCom == 0){
   alert("please select the data");
  }else{
   var url="/hms/hms/mis?method=getExistingDetails&exitDetail="+exitCom;
   newwindow=window.open(url,'name',"left=100,top=100,height=400,width=970,status=1,scrollbars=1,resizable=0");
  }
  
}
	</script>
	<div class="titlebg">
	<h2>Annual Medical Examination</h2>
	</div>
	 <%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box = HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	String serviceNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> employeeList = null;
			 	List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
			 	List<MasRank>rankList=null;
				List<MasUnit>unitList=null;
				List<EmpAfmsfDet> showAfmsfList = new ArrayList<EmpAfmsfDet>();
			 	
			 	if (map.get("employeeList") != null) {
			 		employeeList = (List<Object>) map.get("employeeList");
			 	}
			 	if (map.get("empAfmsfDetList") != null) {
			 		empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
			 	}
			 	System.out.println("EmpAfmsfDet in jsp --"+empAfmsfDetList.size());
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 	}
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 	}
			 	if (map.get("serviceNo") != null) {
			 		serviceNo = (String) map.get("serviceNo");
			 	}
			 	if (map.get("showAfmsfList") != null) {
			 		showAfmsfList = (List) map.get("showAfmsfList");
			 	}
			 	System.out.println("showAfmsfList  in jsp"+showAfmsfList.size());
			 	List<MasMedicalCategory> masMedicalCategoryList = new ArrayList<MasMedicalCategory>();
			 	if (map.get("masMedicalCategoryList") != null) {
			 		masMedicalCategoryList = (List<MasMedicalCategory>) map.get("masMedicalCategoryList");
			 	}
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
					<div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
					 <div class="mesg" style="width: 100%; height: 23px;">
					   <%=message %>
					   </div>
					  </div>
					<% } %>
		  <form name="annualMedicalExamination" method="post" >
		  <div class="Clear"></div>
		  <div class="Clear"></div><!--
		  <div class="header">
		<label class="bodytextB">Service No.</label>
		
		<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" title="Fill Service No. first." value="" class="textbox_date" MAXLENGTH="30" onblur="submitProtoAjaxWithDivName('annualMedicalExamination','/hms/hms/mis?method=getResponceForAME&serviceNo='+this.value,'deficientId');" />
		<div class="Clear"></div>
		</div>
	
		--><div class="Clear"></div>
		
		  <div class="Block">
		  <h4>DETAILS</h4>
		  
		  
		 
      <div class="Clear"></div>
      
	  <label>Rank</label>
	  <input type="text"  name="<%=RANK %>" id="name" value="" class="" MAXLENGTH="30" validate="Name,String,Yes" />
	  <label>Name</label>
	  <input type="text"  name="<%=NAME %>" id="name" value="" class="" MAXLENGTH="30" validate="Name,String,Yes" />
       <label>Trade</label>
	  <input type="text"  name="<%=TRADE_ID%>" id="name" value="" class="" MAXLENGTH="30" validate="Name,String,Yes" />
     <div class="Clear"></div>
      <label>Parent Unit</label>
	  <input type="text"  name="<%=UNIT_ID%>" id="name" value="" class="" MAXLENGTH="30" validate="Name,String,Yes" />
				
		<label>Medical Category<span>*</span></label>
	 	<select>
	 	<option value="0">Select</option>
	 	</select>
	 	<label>Period</label>
	 	<select>
	 		<option value="">Select</option>
		 	<option value="P">Permanent</option>
		 	<option value="T">Temporary</option>
	 	</select>
	 	  <div class="Clear"></div>
	    <label>Duration</label>
	    <input type="text" name="duration" id="duration" value="" >
		
		<label>Last AME/Board<span>*</span></label>
	    <input type="text"  name="<%=LAST_BOARD%>" id="name" value="" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
	    <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=LAST_BOARD%>,event)" />
	
		<label>Next Review<span>*</span></label>
	    <input type="text"  name="<%=NEXT_REVIEW%>" id="name" value="" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
	    <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=NEXT_REVIEW%>,event)" />
	  
	  </div>
	  
	  
	  

	    <div class="Clear"></div>
 		<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"/ tabindex=3 />
		<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"  class="textbox_size20" readonly="readonly" tabindex=3 />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />
		<div id="edited"></div>
		<label>&nbsp;</label>
		<div class="Clear"></div>
		<div class="Clear"></div>
		</form>

	
	
		<script type="text/javascript">
	function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
 	
 	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='disabilityName'+iteration;
	  e0.id='disabilityName'+iteration
	  e0.size = '30';
	  e0.setAttribute('tabindex','1');	  
	  cellRight0.appendChild(e0);
	  
	  var cellRight1= row.insertCell(1);
	  var sel = document.createElement('Select');
	  sel.name='dcategory'+iteration;
	  sel.id='dcategory'+iteration;
	  sel.setAttribute('tabindex','1');
	  sel.options[0] = new Option('--Select--', '');
	  sel.options[1] = new Option('A4G1', '1');
	  sel.options[2] = new Option('A4G2', '2');
	  sel.options[3] = new Option('A4G3', '3');
	  sel.options[4] = new Option('A4G4', '4');
	  sel.options[5] = new Option('AtGt', '5');
	  sel.options[6] = new Option('ApGp', '6');
	  sel.options[7] = new Option('A4G2(P)', '7');
	  	  
	  cellRight1.appendChild(sel);
	  	  
	  var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='dduration'+iteration;
	  e1.id='dduration'+iteration;
	  e1.size = '10';
	  e1.setAttribute('tabindex','1');	  
	  cellRight2.appendChild(e1);
	  
	   var cellRight3 = row.insertCell(3);
	   var e2 = document.createElement('Select');
	   e2.name='permtemp'+iteration;
	   e2.id='permtemp'+iteration;
	 //e6.classname='smalllabel';
	   e2.setAttribute('tabindex','1');	 	  
	   e2.options[0] = new Option('--Select--', '');
	   e2.options[1] = new Option('Permanent', 'P');
	   e2.options[2] = new Option('Temporary', 'T');
	   cellRight3.appendChild(e2); 
	   
	  var cellRight4 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dNextReview'+iteration;
	  e3.id='dNextReview'+iteration;
	  e3.class='calDate';
	  e3.size = '15';
	  e3.setAttribute('tabindex','1');
	  cellRight4.appendChild(e3);
	  
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.class = 'calender';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(event){
	  setdate('',document.getElementById('<%="dNextReview"%>'+iteration),event) };
	  cellRight4.appendChild(eImg);
	   
	  var cellRight5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='EmpRestriction'+iteration;
	  e4.id='EmpRestriction'+iteration;
	  e4.size='25';
	  e4.setAttribute('tabindex','1');	 	  
	 // e7.setAttribute('validate','Remarks,String,no');	  
	  cellRight5.appendChild(e4);
	}
	
	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var org = document.getElementById('org').value;
	  if (lastRow-1 > org){ 
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
		var hdb = document.getElementById('hdb');
	 	hdb.value=iteration
	  }else{
	   if(confirm("Are you Sure, you want to delete ?")){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
		var hdb = document.getElementById('hdb');
	 	hdb.value=iteration
	 	}
	  }
	}
	function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("newUnitId").length;i++)
	 {
		 if (document.getElementById("newUnitId").options[i].value==unitId)
		 {
		 	document.getElementById("newUnitId").selectedIndex = i;
		 }
	 }
	}
		</script>
	
	
		  		 <script type="text/javascript">
function validateAME() {
	medCatId = document.getElementById("medCatId").value
	
	var count = document.getElementById("hdb").value;
	var errMsg=""
	if(medCatId ==0)
	 errMsg="Please select Medical category \n"
		boardDate = document.getElementById("boardDate").value
		nextReview = document.getElementById("nextReview").value
	   	boardDate = new Date(boardDate.substring(6),(boardDate.substring(3,5) - 1) ,boardDate.substring(0,2));
	 	nextReview = new Date(nextReview.substring(6),(nextReview.substring(3,5) - 1) ,nextReview.substring(0,2));
		if(boardDate > nextReview)
	 	{
	 	errMsg =errMsg+"Next Review date must be greater than Last AME/Board "
			
	 	}
		
		 if(errMsg !=""){
		 alert(errMsg)
		 return false;
		 }else{
		  if(confirm("Are you Sure, you want to save ?")){
		  return true;
		  }else{
		  return false;
		  }
		 }
		 // return true;
}
</script>