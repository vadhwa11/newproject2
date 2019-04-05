<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.BloodOpeningStockMain"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

	animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
	animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
	
	animatedcollapse.init()

</script>

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
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<BloodOpeningStockMain> openingStockList = new ArrayList<BloodOpeningStockMain>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	
	String userName="";
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("componentList") != null){
		componentList = (List<BloodMasComponent>)map.get("componentList");
	}
	if(map.get("rankList") != null){
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("openingStockList") != null){
		openingStockList = (List<BloodOpeningStockMain>)map.get("openingStockList");
	}
	BloodOpeningStockMain bloodOpeningStockMain = new BloodOpeningStockMain();
	if(openingStockList.size() > 0){
		bloodOpeningStockMain=(BloodOpeningStockMain) openingStockList.get(0);
	}
	
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	}
	
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	String message ="";

	if (map.get("message") != null) {
             message = (String) map.get("message");
      }
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>

<%} %>
<div id="contentHolder">
<form name="openingBalance" method="post" action="">
<h6>Blood Stock Opening Balance Entry</h6>
<div class="Clear"></div>
<%
		String stockSeqNo="";
		if(map.get("stockSeqNo") != null){
			stockSeqNo = (String)map.get("stockSeqNo");
		}
		
%>
<div class="blockFrame"><input id="currentDateId" type=hidden
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" />

<label>Opening No.</label> <label class="value"><%=1 %></label> <input
	id="openingId" type=hidden name="<%=STOCK_NO %>" value="<%=1%>"
	title="Opening No" /> <label>Date</label> <input type="text"
	class="calDate" id="dateId" name="<%=DATE %>" value="<%=date %>"
	validate="Date,date,yes" MAXLENGTH="10" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.openingBalance.<%=DATE%>,event)" />


<label> <span>*</span> Approved By </label> <select id="employeeId"
	name=<%=EMPLOYEE_ID %> validate="Approved By,string,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				String empName= "" ;
				         				empName = masEmployee.getFirstName();
				         				if(masEmployee.getMiddleName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getMiddleName());
				         				if(masEmployee.getLastName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getLastName());
				         %>
	<option value="<%=masEmployee.getId() %>"><%=empName%></option>
	<%		} } %>
</select>
<div class="Clear"></div>

<label>Remarks</label> <input type="text" name="<%= REMARKS%>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="50" tabindex=1 />
</div>
<div class="Clear"></div>

<div class="blockTitle">Blood Donor Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<!--Block Two Starts-->

<div class="blockFrame"><label class="large"><span>*</span>Blood
Bag No.</label> <input type="text" id="bloodBagNo" name="<%= BLOOD_BAG_NO%>"
	value="" validate="Blood Bag No.,int,yes" class="textbox_size20"
	tabindex=1 /> <label> <span>*</span> Date of Collection</label> <input
	type="text" class="calDate" id="collDateId"
	name="<%=COLLECTION_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date%>',document.getElementById('collDateId'),event)" />

<div class="Clear"></div>

<label class="large"> <span>*</span> Blood Component Name</label> <select
	id="bloodComponentId" name=<%=BLOOD_COMPONENT_ID %>
	validate="Blood Component Name,string,yes"
	onblur="fillComponentDetail(this.value);">
	<option value="0">Select</option>

	<%
				         		if(componentList != null){ 	
				         			for (Iterator iter = componentList.iterator(); iter.hasNext();) {
				         				BloodMasComponent masComponent = (BloodMasComponent) iter.next();
				         %>
	<option value="<%=masComponent.getId() %>"><%=masComponent.getComponentName()%></option>
	<%} } %>
</select> <script type="text/javascript">
			function fillComponentDetail(obj){	
		<%		
		if(componentList != null && componentList.size() > 0){
				for (BloodMasComponent component : componentList) {%>
								var invObj =<%=component.getId()%>
								if(invObj == obj){
	 							document.getElementById('qty').value="<%=component.getQtyUnit()%>"
 							}
 							
 					<%} } %>
 					}
 			</script>
  <label>Quantity</label>
 <input type="text" id="qty"name="<%= QUANTITY%>" value="" validate="Qty,int,yes" class="small"
	maxlength="3" tabindex=1 readonly="readonly" /> <label class="unit">ml</label>

<div class="Clear"></div>


<label class="large">Service No.</label> <input type="text"
	id="serviceNo" name="<%= SERVICE_NO%>" value=""
	validate="Service No,string,no" tabindex=1 maxlength="20"
	onblur="ajaxFunctionForPatient(openingBalance);" /> <input
	type="hidden" id="hinId" name="<%= HIN_ID%>" value="" /> <label><span>*</span>Name</label>
<input type="text" align="right" name="<%=DONER_NAME%>" id="donerName"
	value="" maxlength="30" /> <label>Rank</label> <select id="rankId"
	name=<%=RANK_ID %> validate="Rank,string,no">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%		} } %>
</select>
<div class="Clear"></div>

<label class="large">Unit/Address</label> <textarea value=""
	name="<%=UNIT_ADDRESS%>" id="unitAddress" onkeyup="chkLength(this,30);"></textarea>

<label> <span>*</span> Date of Expiry</label> <input type="text"
	class="calDate" id="expiryDateId" name="<%=EXPIRY_DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" validate="Date of Expiry,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" onchange="validateExpiryDate();"
	onClick="setdate('<%=date %>',document.openingBalance.<%=EXPIRY_DATE%>,event)" />

<label> <span>*</span>Blood Group</label> <select id="bloodGroupId"
	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>

	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		} } %>
</select>

<div class="Clear"></div>
</div>
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(validateCollExpDate())submitForm('openingBalance','bloodBank?method=submitStockOpeningBalance');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('openingBalance');"
	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>

</div>
</div>
</div>
</form>

<script type="text/javascript" language="javascript">				
				
	function validateExpiryDate(){
	expiryDate = new Date(expiryDateId.substring(6),(expiryDateId.substring(3,5) - 1) ,expiryDateId.substring(0,2));
			 	currentDate = new Date();
				var month = currentDate.getMonth() + 1
				var day = currentDate.getDate()
				var year = currentDate.getFullYear()
				var seperator = "/"
				currentDate = new Date(month + seperator + day + seperator + year);
				if(expiryDate < currentDate)
				{	
					alert("Expiry Date should be greater than Today's date!!");
					document.getElementById('expiryDateId').value="";
					return false;
				}
				else
				{
					return true;
				}
		}
		
	function validateCollectionDate(){
			collDate = new Date(collectionDate.substring(6),(collectionDate.substring(3,5) - 1) ,collectionDate.substring(0,2));
			 	currentDate = new Date();
				var month = currentDate.getMonth() + 1
				var day = currentDate.getDate()
				var year = currentDate.getFullYear()
				var seperator = "/"
				currentDate = new Date(month + seperator + day + seperator + year);
				if(collDate >currentDate)
				{	
					alert("Date Of Collection should be smaller than Today's date!!");
					document.getElementById('collectionDate').value="";
					return false;
				}
				else
				{
					return true;
				}
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
	</script>
	
	
	<script type="text/javascript" language="javascript">
	
	function validateCollExpDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.bloodDonationEntry.<%=EXPIRY_DATE %>)
		obj2 = eval(document.bloodDonationEntry.<%=COLLECTION_DATE %>)
		
		if(obj1.value != "" && obj2.value != "")
		{
		
		 validExpDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validCollDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			if(validExpDate < validCollDate)
				{
							alert("Expiry Date should be Greater than Collection Date\n");
							return false;
				}
		
		}
		return true;
	}
</script>