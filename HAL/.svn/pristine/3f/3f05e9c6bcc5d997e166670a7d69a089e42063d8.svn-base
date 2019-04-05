<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasMedicalBoardProceedings"%>
<%@page import="jkt.hms.masters.business.MasMedicalBoardDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>


<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<script language="javascript" type="text/javascript">
var districtArray= new Array();
function imposeMaxLength(Object, MaxLen)
{
  return (Object.value.length <= MaxLen);
}

</script>
<script type="text/javascript" language="javascript">

var itemsArray1=new Array();
  function fillItemsMmf(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idAu=idAu+rowVal;
    	document.getElementById('noOfRecords').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		}
		}
	
  }
  function removeRow()
   {
     var tbl = document.getElementById('amcDetailId');
     document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
     var lastRow = tbl.rows.length;
     if (lastRow > 2) tbl.deleteRow(lastRow - 1);
     else 
     alert("Unfit Explanation should have at least one row");
     
   }
	

</script>

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
<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>

<%

String 	userName="";
String previousPage="no";
int pageNo = 1;
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	String entryNo="";
		
	
	int Id=0;
	int proceedingsID=0;
	if(map.get("Id")!=null){
		Id=(Integer)map.get("Id");
	}
	if(map.get("proceedingsID")!=null){
		proceedingsID=(Integer)map.get("proceedingsID");
	}
	List<MasMedicalBoardProceedings> medicalBoardProceedingsList = new ArrayList<MasMedicalBoardProceedings>();
	List<MasEmployee>masEmployeeList=new ArrayList<MasEmployee>();
	List<MasEmployee> macthingEmployeeList=new ArrayList<MasEmployee>();
	List<MasEmployee>macthingEmployeeList1=new ArrayList<MasEmployee>();
	List<MasEmployee>macthingEmployeeList2=new ArrayList<MasEmployee>();
	if(map.get("masEmployeeList")!=null)
	{
		masEmployeeList=(List)map.get("masEmployeeList");
		macthingEmployeeList = masEmployeeList;

	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();

    if (map.get("unitList") != null) {
       unitList = (List) map.get("unitList");
    }
	
List<MasMedicalBoardDetails>medicalBoardDetailList=new ArrayList<MasMedicalBoardDetails>();
	if (map.get("medicalBoardProceedingsList") != null) {
		medicalBoardProceedingsList =(List) map.get("medicalBoardProceedingsList");
	}
	List<MasDistrict> citylist = new ArrayList<MasDistrict>();

	if (map.get("citylist") != null) {
		citylist = (List) map.get("citylist");
	}
	
	List<MasState> stateList = new ArrayList<MasState>();

	if (map.get("stateList") != null) {
		stateList = (List) map.get("stateList");
	}
	
	List<MasMedicalBoardProceedings> medicalBoardProceedingsList1 = new ArrayList<MasMedicalBoardProceedings>();
	if (map.get("medicalBoardProceedingsList1") != null) {
		medicalBoardProceedingsList1 =(List) map.get("medicalBoardProceedingsList1");
	}
	
	List<MasMedicalCategory>medicalCategoryList=new ArrayList<MasMedicalCategory>();
	List<MasMedicalCategory>machingmedicalCategoryList=new ArrayList<MasMedicalCategory>();
	List<MasMedicalCategory>machingmedicalCategoryList1=new ArrayList<MasMedicalCategory>();
	if (map.get("medicalCategoryList") != null) {
		medicalCategoryList =(List) map.get("medicalCategoryList");
	}	
	
	if(map.get("medicalBoardDetailList")!=null)
	{
		medicalBoardDetailList=(List)map.get("medicalBoardDetailList");
	}
	String message="";
	String DATEOFORIGEN="";
	String DATEOFCOMMISNING="";
	String DATEOFRECTORIZATION="";
	if(medicalBoardProceedingsList.get(0)!=null)
	{
		if(medicalBoardProceedingsList.get(0).getDateOfCommissioning()!=null)
		{
			DATEOFCOMMISNING=HMSUtil.convertDateToStringWithoutTime(medicalBoardProceedingsList.get(0).getDateOfCommissioning());
		}
			if(medicalBoardProceedingsList.get(0).getDateOfRecategorization()!=null)
		{
				DATEOFRECTORIZATION=HMSUtil.convertDateToStringWithoutTime(medicalBoardProceedingsList.get(0).getDateOfRecategorization());
		}
	}

	
	

if (map.get("message") != null) {
   message = (String) map.get("message");
  
 }
if(!message.equalsIgnoreCase("")){
%>

<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Medical Board Proceeding Entry (AFMSF 15) Update</h6>
<div class="Clear"></div>

<form name="medicalBoardProceeding" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value="MasMedicalBoardProceedings">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="MedicalBoardProceeding"> <input type="hidden"
	name="title" value="Medical Board Proceeding"> <input
	type="hidden" name="<%=JSP_NAME %>" value=medicalBoardProceeding">


<div class="blockFrame">
<div class="Clear"></div>

<label>Entry No.</label> <label class="value"><%=medicalBoardProceedingsList.get(0).getEntryNo()%></label>


<label>Entry Date</label> <input tabindex="1" name="<%=ENTRY_DATE %>"
	type="text"
	value="<%=HMSUtil.convertDateToStringWithoutTime(medicalBoardProceedingsList.get(0).getEntryDate())%>"
	maxlength="12" class="calDate" validate="Entry Date,date,yes" /> <img
	height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= ENTRY_DATE%>,event);"
	class="calender" /> <label>Hin No.</label> <%if(medicalBoardProceedingsList.size()>0 && medicalBoardProceedingsList.get(0).getHinNo()!=null){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getHinNo() %></label>
<input type="hidden"
	value="<%=medicalBoardProceedingsList.get(0).getHinNo() %>"
	name="<%=HIN_NO%>" tabindex="1" /> <%}else {%> <label class="value">
-</label> <%} %>

<div class="Clear"></div>

<!--  

--> <label>Name</label> <%if(medicalBoardProceedingsList.get(0)!=null) {%>
<%if(medicalBoardProceedingsList.get(0).getFirstName()!=null){%> <label
	class="value"><%=medicalBoardProceedingsList.get(0).getFirstName()%>
<%=medicalBoardProceedingsList.get(0).getLastName()%></label> <%}else {%> <label
	class="value"> -</label> <%   }  %> <label>Service No.</label> <%if(medicalBoardProceedingsList.get(0).getServiceNo()!=null){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getServiceNo() %></label>
<%}else {%> <label class="value"> -</label> <%} %> <label>Rank</label> <%if(medicalBoardProceedingsList.get(0).getRankName()!=null ){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getRankName() %></label>
<%}else {%> <label class="value"> -</label> <%} %>

<div class="Clear"></div>
<label>Unit/Ship</label> <%if(medicalBoardProceedingsList.get(0).getUnitName()!=null ){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getUnitName()%></label>
<%}else {%> <label class="value">--</label> <%} %> <label>Service
Type</label> <%
	    if(medicalBoardProceedingsList.get(0).getMedicalType()!= null){
	    %> <label class="value"> <%=medicalBoardProceedingsList.get(0).getMedicalType() %></label>
<%
		   }else{
		%> <label class="value"> -</label> <%} %> <label class="noWidth">Army/
Corps/ Branch/ Trade</label> <%if(medicalBoardProceedingsList.get(0).getTradeName() != null ){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getTradeName() %></label>
<%}else{ %> <label class="value"> -</label> <%} %>

<div class="Clear"></div>

<label>Age</label> <%if(medicalBoardProceedingsList.get(0).getAge() !=null ){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getAge() %></label>
<%}else{ %> <label class="value"> -</label> <%} %> <label>Sex</label> <%if(medicalBoardProceedingsList.get(0).getSex()!=null ){%>
<label class="value"><%=medicalBoardProceedingsList.get(0).getSex() %></label>
<%}else{ %> <label class="value"> -</label> <%} %> <%}else{ %> <%} %> <label>Ceased
Duty on</label> <% if(medicalBoardProceedingsList.get(0).getCeasedDutyOn()!= null){%>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(medicalBoardProceedingsList.get(0).getCeasedDutyOn()) %></label>
<%}else{ %> <label class="value"></label> <%} %>
<div class="Clear"></div>
<label class="large">Weight (Kg.) <span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getWeight()!=null){ %>
<input tabindex="1" name=<%=WEIGHT %> option
	value="<%=medicalBoardProceedingsList.get(0).getWeight()%>" type="text"
	onKeyDown="limitText(this,8);" onKeyUp="limitText(this,8);"
	validate="Weight,String,yes" /> <%}else{ %> <input tabindex="1"
	name=<%=WEIGHT %> type="text" onKeyDown="limitText(this,8);"
	onKeyUp="limitText(this,8);" validate="Weight,String,yes" /> <%} %> <label>Height
(Cm.) <span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getHeight()!=null){ %>
<input tabindex="1" name=<%=HEIGHT %> option
	value="<%=medicalBoardProceedingsList.get(0).getHeight()%>" type="text"
	onKeyDown="limitText(this,8);" onKeyUp="limitText(this,8);"
	validate="Height,String,yes" /> <%}else{ %> <input tabindex="1"
	name=<%=HEIGHT %> type="text" onKeyDown="limitText(this,8);"
	onKeyUp="limitText(this,8);" validate="Height,String,yes" /> <%} %>

<div class="Clear"></div>
<label class="large">Date of Commisioning/Enrollment <span>*</span></label>


<input tabindex="1" name="<%=DATE_OF_COMMISSIONING %>"
	value="<%=DATEOFCOMMISNING %>" type="text" class="calDate"
	validate="Date of Commisioning,date,yes" /> <img height="16"
	border="0" width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= DATE_OF_COMMISSIONING%>,event);"
	class="calender" /> <label class="large">Record Office with
Address <span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getAddress()!=null){  %>
<input tabindex="1" name=<%=RECORD_ADDRESS %> option
	value="<%=medicalBoardProceedingsList.get(0).getAddress()%>"
	type="text" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);"
	validate="Record Office Address,String,yes" /> <%}else{ %> <input
	tabindex="1" name=<%=RECORD_ADDRESS %> type="text"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);"
	validate="Record Office Address,String,yes" /> <%} %>
<div class="Clear"></div>

<label class="large">Address On Leave (If Applicable)</label> <textarea
	class="large" name="<%=LOCAL_ADDRESS%>" tabindex="1"
	onkeyup="chkLength(this,500);"><%=medicalBoardProceedingsList.get(0).getAddressOnLeave() %></textarea>
<label>State</label> <select id="stateId" name=<%=STATE %> tabindex="1"
	onChange="populateDistrict(this.value,'medicalBoardProceeding');">
	<option value="0">Select</option>
	<%if(stateList != null){ 	
	         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
	         				MasState masState = (MasState) iter.next();
		            		if(medicalBoardProceedingsList.get(0).getState()!=null){ 
		              		 if(medicalBoardProceedingsList.get(0).getState().getId().equals(masState.getId())){
		            %>
	<option value=<%=masState.getId()%> selected="selected"><%=masState.getStateName() %></option>
	<%}else{ %>
	<option value=<%=masState.getId()%>><%=masState.getStateName() %></option>
	<%}}else{%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%}}}%>
</select> <label>City</label> <select id="<%=DISTRICT%>" name="<%=DISTRICT %>"
	tabindex="1">
	<option value="0">Select</option>
	<%System.out.println("citylist::"+citylist.size());
				         		if(citylist != null){ 	
				         			for (Iterator iter = citylist.iterator(); iter.hasNext();) {
				         				MasDistrict masDistrict = (MasDistrict) iter.next();
				         				if(medicalBoardProceedingsList.get(0).getCity()!=null){
				         					if(medicalBoardProceedingsList.get(0).getCity().getId().equals(masDistrict.getId())){
				         				
				         %>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%}else{%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}}} %>
</select>

<div class="Clear"></div>


<label class="large">Past Medical History</label> <%if(medicalBoardProceedingsList.get(0).getPastMedicalHistory()!=null){  %>
<input tabindex="1" name=<%=PAST_MEDICAL_HISTORY %> option
	value="<%=medicalBoardProceedingsList.get(0).getPastMedicalHistory()%>"
	type="text" onKeyDown="limitText(this,50);"
	onKeyUp="limitText(this,50);" /> <%}else{ %> <input tabindex="1"
	name=<%=PAST_MEDICAL_HISTORY %> type="text"
	onKeyDown="limitText(this,50);" onKeyUp="limitText(this,50);" /> <%} %> <label
	class="large">Medical category prior to present medical board <span>*</span></label>

<input tabindex="1" maxlength="40" name="<%=MEDICAL_CATEGORY_NAME %>"
	value="<%=medicalBoardProceedingsList.get(0).getMedicalCategory() %>"
	type="text" />




<div class="Clear"></div>



<label>Type</label> <label class="unit">Categorisation</label> <%if(medicalBoardProceedingsList.get(0).getMedicalType().equalsIgnoreCase("categorisation")){ %>

<input tabindex="1" type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="categorisation" checked="checked" /> <%}else{ %> <input
	tabindex="1" type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="categorisation" /> <%} %> <label class="unit">Recategorisation</label>
<%if(medicalBoardProceedingsList.get(0).getMedicalType().equalsIgnoreCase("recategorisation")){ %>

<input tabindex="1" type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="recategorisation" checked="checked" /> <%}else{ %> <input
	tabindex="1" type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="recategorisation" /> <%} %> <label class="unit">Sick Leave</label>
<%if(medicalBoardProceedingsList.get(0).getMedicalType().equalsIgnoreCase("sickLeave")){ %>

<input tabindex="1" type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="sickLeave" checked="checked" /> <%}else{ %> <input tabindex="1"
	type="radio" class="radio" name=<%=MEDICAL_TYPE %> value="sickLeave" />

<%} %> <input tabindex="1" type="hidden" name="Id" value="<%=Id %>">
<input type="hidden" name="proceedingsID" value="<%=proceedingsID %>">
<div class="Clear"></div>

</div>

<div class="blockTitle">Board President and Members <a
	href="javascript:animatedcollapse.toggle('slide1')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide1">
<div class="blockFrame"><label class="large">Board
President <span>*</span> </label> <select tabindex="1" id="employeeCategoryId"
	name=<%=BOARD_PRESIDENT %> validate="Board President,String,yes">
	<option value="0">Select</option>
	<%for (MasEmployee masworkdetail : macthingEmployeeList) { 
    	 if(medicalBoardProceedingsList.get(0).getBoardPresident()!=null){
    	 if(masworkdetail.getId().equals(medicalBoardProceedingsList.get(0).getBoardPresident().getId())){
    	 %>
	<option value="<%=masworkdetail.getId()%>" selected="selected"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}%>

</select> <label>Member 1 Name <span>*</span> </label> <select tabindex="1"
	id="employeeCategoryId" name=<%=MEMBER_1_NAME %>
	validate="Board President,String,yes">
	<option value="0">Select</option>
	<%for (MasEmployee masworkdetail : macthingEmployeeList) { 
    	 if(medicalBoardProceedingsList.get(0).getMember1Name()!=null){
    	 if(masworkdetail.getId().equals(medicalBoardProceedingsList.get(0).getMember1Name().getId())){
    	 %>
	<option value="<%=masworkdetail.getId()%>" selected="selected"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}%>
</select> <label> Member 2 Name</label> <select tabindex="1"
	id="employeeCategoryId" name=<%=MEMBER_2_NAME %>>
	<option value="0">Select</option>
	<%for (MasEmployee masworkdetail : macthingEmployeeList) { 
    	 if(medicalBoardProceedingsList.get(0).getMember2Name()!=null){
    	 if(masworkdetail.getId().equals(medicalBoardProceedingsList.get(0).getMember2Name().getId())){
    	 %>
	<option value="<%=masworkdetail.getId()%>" selected="selected"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}else{ %>
	<option value="<%=masworkdetail.getId()%>"><%=masworkdetail.getFirstName()+" "+masworkdetail.getLastName()%></option>
	<%}}%>
</select>
<div class="Clear"></div>
</div>
</div>


<div class="division"></div>
<div class="blockTitle">Details of Present &amp; Previous
Disabilities<a href="javascript:animatedcollapse.toggle('slide2')">Click
Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="Height10"></div>
<input tabindex="1" type="button" name="service" class="cmnButton"
	value="Add" onclick="generateRowMedicalBoard('amcDetailId');" /> <input
	tabindex="1" type="button" name="service" class="cmnButton"
	value="Remove" onclick="removeRow();" /> <input tabindex="1"
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Disabilities (Principles/ Others)</th>
			<th scope="col">Date of Onset</th>
			<th scope="col">Place of Onset</th>
			<th scope="col">Previous Medical Categorisation</th>
			<th scope="col">Previous Medical Categorisation Date</th>
			<th scope="col">Next Medical Categorisation Due Date</th>
		</tr>
	</thead>
	<tbody>
		<%
  
   String unfitExplanationtemp = "unfitExplanationtemp";
 

   String unfitExplanationtemp2 = "unfitExplanationtemp";
   int inc=1;
   for ( ;inc <= medicalBoardDetailList.size(); inc++) {
   
      unfitExplanationtemp = unfitExplanationtemp2 + ("" + inc);
  %>

		<tr>


			<td width="5%"><input tabindex="1" type="text" size="2"
				value="<%=inc%>" name="<%=MEDICAL_BOARD_DETAILS_SRNO%>"
				readonly="readonly" /> <input tabindex="1" type="hidden"
				name="<%=MEDICAL_BOARD_DETAILS_ID%>"
				value="<%=medicalBoardDetailList.get(inc-1).getId()%>" /></td>

			<td width="30%">
			<%if(medicalBoardDetailList.get(inc-1).getDisabilities()!=null){ %> <input
				tabindex="1" maxlength="149" type="text"
				onKeyDown="limitText(this,149);" onKeyUp="limitText(this,50);"
				value="<%=medicalBoardDetailList.get(inc-1).getDisabilities()%>"
				name="<%=MEDICAL_BOARD_DISABILITIES %>"
				validate="Disabilities,String,yes"> <%}else{ %> <input
				tabindex="1" maxlength="149" type="text"
				onKeyDown="limitText(this,149);" onKeyUp="limitText(this,50);"
				value="<%=MEDICAL_BOARD_DISABILITIES %>" name=""
				validate="Disabilities,String,yes"> <%} %>
			</td>


			<td style="width: 15%">
			<%if(medicalBoardDetailList.get(inc-1).getDateOfOrigin()!=null){ %> <input
				type="text" size="10"
				style="width: 75%; float: left; vertical-align: center;"
				value="<%=HMSUtil.convertDateToStringWithoutTime(medicalBoardDetailList.get(inc-1).getDateOfOrigin()) %>"
				name="<%=DATE_OF_ORIGIN %>" tabindex="1"
				validate="Date of Origin,date,yes" /> <img height="16" border="0"
				width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= DATE_OF_ORIGIN%>,event);" />

			<% }else{%> <input
				style="width: 75%; float: left; vertical-align: center;" type="text"
				value="" name="<%=DATE_OF_ORIGIN %>" tabindex="1"
				validate="Date of Origin,date,yes" /> <img height="16" border="0"
				width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= DATE_OF_ORIGIN%>,event);"
				class="calender" /> <%} %>
			</td>


			<td width="10%">
			<%if(medicalBoardDetailList.get(inc-1).getPlaceOfOrigin()!=null){ %> <input
				type="text" onKeyDown="limitText(this,30);"
				onKeyUp="limitText(this,30);"
				value="<%=medicalBoardDetailList.get(inc-1).getPlaceOfOrigin()%>"
				name="<%=PLACE_OF_ORIGIN %>" tabindex="1"
				validate="Place of Origin,String,yes" /> <%} else { %> <input
				type="text" onKeyDown="limitText(this,30);"
				onKeyUp="limitText(this,30);" value="" name="<%=PLACE_OF_ORIGIN %>"
				tabindex="1" validate="Place of Origin,String,yes" /> <%} %>
			</td>

			<td width="10%"><select tabindex="1"
				name="<%=PREVIOUS_MEDICAL_CATEGORISATION %>"
				validate="Previous Medical Categorisation,String,yes" />

				<option
					value="<%=medicalBoardDetailList.get(0).getPreviousMedicalCategorisatrion()%>"><%=medicalBoardDetailList.get(0).getPreviousMedicalCategorisatrion()%></option>

				<%
					for (MasMedicalCategory masmedicalCategory : medicalCategoryList ) {
				%>

				<option value="<%=masmedicalCategory.getMedicalCategoryName()%>"><%=masmedicalCategory.getMedicalCategoryName()%></option>

				<%
					}
				%>
			</select></td>


			<td>
			<%if(medicalBoardDetailList.get(inc-1).getPreviousMedicalCategorisationDate()!=null){ %>

			<input tabindex="1" type="text"
				style="width: 75%; float: left; vertical-align: center;"
				value="<%=HMSUtil.convertDateToStringWithoutTime(medicalBoardDetailList.get(inc-1).getPreviousMedicalCategorisationDate())%>"
				name="<%=PREVIOUS_MEDICAL_CATEGORISATION_DATE %>" /> <img
				height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= PREVIOUS_MEDICAL_CATEGORISATION_DATE%>,event);"
				class="calender" /> <% }else{ %> <input tabindex="1" type="text"
				style="width: 75%; float: left; vertical-align: center;" value=""
				name="<%=PREVIOUS_MEDICAL_CATEGORISATION_DATE %>" /> <img
				height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= PREVIOUS_MEDICAL_CATEGORISATION_DATE%>,event);"
				class="calender" /> <%} %>
			</td>
			<td>
			<%if(medicalBoardDetailList.get(inc-1).getNextMedicalCategorisationDue()!=null){ %>
			<input type="text"
				style="width: 75%; float: left; vertical-align: center;"
				value="<%= HMSUtil.convertDateToStringWithoutTime(medicalBoardDetailList.get(inc-1).getNextMedicalCategorisationDue())%>"
				name="<%=NEXT_MEDICAL_CATEGORISATION_DUE %>" tabindex="1" /> <img
				height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= NEXT_MEDICAL_CATEGORISATION_DUE%>,event);"
				class="calender" /> <%} else { %> <input type="text"
				style="width: 75%; float: left; vertical-align: center;" value=""
				name="<%=NEXT_MEDICAL_CATEGORISATION_DUE %>" tabindex="1" /> <img
				height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= NEXT_MEDICAL_CATEGORISATION_DUE%>,event);"
				class="calender" /> <%} %>
			</td>

		</tr>

		<%} %>


	</tbody>
	<input type="hidden" name="rows" id="rr" value="1" />

</table>


</div>
</div>


<div class="Clear"></div>

<!--Block Two Starts-->

<div class="division"></div>
<div class="blockTitle">Clinical Summary<a
	href="javascript:animatedcollapse.toggle('slide3')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<label class="large">Clinical Summary <span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getClinicalSummary()!=null){%>
<textarea tabindex="1" class="large" name="<%=CLINICAL_SUMMARY %>"
	onKeyDown="limitText(this,500);" onKeyUp="limitText(this,100);"
	validate="Clinical Summary,String,yes"><%=medicalBoardProceedingsList.get(0).getClinicalSummary()%></textarea>
<%}else{ %> <textarea tabindex="1" class="large"
	name="<%=CLINICAL_SUMMARY %>" onKeyDown="limitText(this,500);"
	onKeyUp="limitText(this,100);" validate="Clinical Summary,String,yes"></textarea>
<%} %>
<div class="Clear"></div>

<label class="large2">Is the disability attributable in service
<span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getDisabilityAttributableStatus().equals("Yes")){ %>
<label class="small">Yes</label> <input tabindex="1"
	name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>" type="radio" class="radio"
	value="Yes" onclick="makeChoice(this);" checked="checked" /> <label
	class="small">No</label> <input tabindex="1"
	name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>" type="radio" class="radio"
	value="No" onclick="makeChoice(this);" /> <%}else{ %> <label
	class="small">Yes</label> <input tabindex="1"
	name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>" type="radio" class="radio"
	value="Yes" onclick="makeChoice(this);" /> <label class="small">No</label>
<input tabindex="1" name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>"
	type="radio" class="radio" value="No" onclick="makeChoice(this);"
	checked="checked" /> <%} %>
<div class="Clear"></div>
<label>Explain</label> <%if(medicalBoardProceedingsList.get(0).getDisabilityAttributableStatus().equals("Yes")){ %>
<textarea tabindex="1" class="large" maxlength="200"
	name="<%=DISABILITY_ATTRIBUTABLE_DESC %>"
	onkeyup="chkLength(this,200);"><%=medicalBoardProceedingsList.get(0).getDisabilityAttributableDesc()%></textarea>
<%}else{ %> <textarea tabindex="1" class="large" maxlength="200"
	name="<%=DISABILITY_ATTRIBUTABLE_DESC %>" style="display: none"
	onkeyup="chkLength(this,200);"></textarea> <%} %>
<div class="Clear"></div>

<label class="large2">If not directly attributable to service,
was it aggravated by service<span>*</span></label> <%if(medicalBoardProceedingsList.get(0).getAggravatedServiceStatus().equals("Yes")){ %>
<label class="small">Yes</label> <input tabindex="1"
	name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio" class="radio"
	value="Yes" checked="checked" onclick="choose(this);" /> <label
	class="small">No</label> <input tabindex="1"
	name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio" class="radio"
	value="No" onclick="choose(this);" /> <%}else{ %> <label class="small">Yes</label>
<input tabindex="1" name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio"
	class="radio" value="Yes" onclick="choose(this);" /> <label
	class="small">No</label> <input tabindex="1"
	name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio" class="radio"
	value="No" checked="checked" onclick="choose(this);" /> <%} %>
<div class="Clear"></div>
<label>Explain</label> <%if(medicalBoardProceedingsList.get(0).getAggravatedServiceStatus().equals("Yes")){ %>
<textarea tabindex="1" class="large" maxlength="200"
	name="<%=AGGRAVATED_SERVICE_DESC %>" onkeyup="chkLength(this,200);"><%=medicalBoardProceedingsList.get(0).getAggravatedServiceDesc()%></textarea>

<%}else{ %> <textarea tabindex="1" class="large" maxlength="200"
	name="<%=AGGRAVATED_SERVICE_DESC %>" style="display: none"
	onkeyup="chkLength(this,200);"></textarea> <%} %>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="large2">Medical category recommended with duration
<span>*</span></label> <input tabindex="1" maxlength="40"
	name="<%=MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION %>"
	value="<%=medicalBoardProceedingsList.get(0).getMedicalCategoryWithDuration()%>"
	type="text" /> <%if(medicalBoardProceedingsList.get(0).getMedicalCategoryDuration()!=null){%>
<input tabindex="1" name=<%=MEDICAL_CATEGORY_DURATION %> option
	value="<%=medicalBoardProceedingsList.get(0).getMedicalCategoryDuration()%>"
	type="text" /> <%}else{ %> <input tabindex="1"
	name=<%= MEDICAL_CATEGORY_DURATION%> type="text" /> <%} %>
<div class="Clear"></div>

<label class="large2">Date &amp; Place of next recategorisation
Board</label> <%if(medicalBoardProceedingsList.get(0).getDateOfRecategorization()!=null){%>
<input tabindex="1" name="<%=DATE_OF_RECATEGORIZATION %>"
	validate="Date Of Recategorization,date,no"
	value="<%= HMSUtil.convertDateToStringWithoutTime(medicalBoardProceedingsList.get(0).getDateOfRecategorization())%>"
	type="text" /> <%}else{ %> <input tabindex="1"
	name="<%=DATE_OF_RECATEGORIZATION %>" type="text"
	validate="Date Of Recategorization,date,no" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.medicalBoardProceeding.<%=DATE_OF_RECATEGORIZATION%>,event);" />

<input tabindex="1" name="<%=PLACE_OF_RECATEGORIZATION %>"
	value="<%=medicalBoardProceedingsList.get(0).getPlaceOfRecategorization()%>"
	type="text" maxlength="30" />

<div class="Clear"></div>
<div class="Height10"></div>

<h5>Percentage of disability (Only for permanent LMC)</h5>
<div class="Clear"></div>
<label class="large">Previous Disablement</label> <%if(medicalBoardProceedingsList.get(0).getPreviousDisablement()!=null){%>
<input tabindex="1" name="<%=PREVIOUS_DISABLEMENT %>" option
	value="<%=medicalBoardProceedingsList.get(0).getPreviousDisablement()%>"
	type="text" onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);" />
<%}else{ %> <input tabindex="1" name="<%=PREVIOUS_DISABLEMENT %>"
	type="text" onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);" />
<%} %> <label class="large">Present Disablement %</label> <%if(medicalBoardProceedingsList.get(0).getPresentDisablement()!=null){%>
<input tabindex="1" name="<%=PRESENT_DISABLEMENT %>" option
	value="<%=medicalBoardProceedingsList.get(0).getPresentDisablement()%>"
	type="text" onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);" />

<%}else{ %> <input tabindex="1" name="<%=PRESENT_DISABLEMENT %>"
	type="text" onKeyDown="limitText(this,6);" onKeyUp="limitText(this,6);" />
<%} %>

<div class="Clear"></div>

<label class="large">Reasons for variation if any</label> <%if(medicalBoardProceedingsList.get(0).getReasonsForVariation()!=null){ %>
<textarea tabindex="1" class="large" name="<%=REASON_FOR_VARIATION %>"
	onkeyup="chkLength(this,500);"><%=medicalBoardProceedingsList.get(0).getReasonsForVariation()%></textarea>
<%}else{ %> <textarea tabindex="1" class="large"
	name="<%=REASON_FOR_VARIATION %>" onkeyup="chkLength(this,500);"></textarea>
<%} %>

<div class="Clear"></div>
<label class="large2">Any specified restriction regarding
employment</label> <%if(medicalBoardProceedingsList.get(0).getRestrictionRegardingEmployment()!=null){ %>
<textarea tabindex="1" class="large"
	name="<%=RESTRICTION_REGARDING_EMPLOYEMENT %>"
	onKeyDown="limitText(this,500);" onKeyUp="limitText(this,500);"><%=medicalBoardProceedingsList.get(0).getRestrictionRegardingEmployment() %></textarea>
<%}else{ %> <textarea tabindex="1" class="large"
	name="<%=RESTRICTION_REGARDING_EMPLOYEMENT %>"
	onKeyDown="limitText(this,500);" onKeyUp="limitText(this,500);"></textarea>
<%} %>
<div class="Clear"></div>
<label class="large2">Instruction given to the individual by the
president of the medical board</label> <%if(medicalBoardProceedingsList.get(0).getRestrictionRegardingEmployment()!=null){ %>
<textarea tabindex="1" class="large"
	name="<%=INSTRUCTION_BY_PRESIDENT %>" onKeyDown="limitText(this,500);"
	onKeyUp="limitText(this,100);"><%= medicalBoardProceedingsList.get(0).getRestrictionRegardingEmployment()%></textarea>
<%}else{ %> <textarea tabindex="1" class="large"
	name="<%=INSTRUCTION_BY_PRESIDENT %>" onKeyDown="limitText(this,500);"
	onKeyUp="limitText(this,100);"></textarea> <%} %>
</div>
</div>

<div class="Clear"></div>
<!--table-->
<div class="division"></div>
<div class="bottom"><INPUT class=button id=updatebutton
	accessKey=u
	onClick="submitForm('medicalBoardProceeding','medicalboardUpdate?method=medicalBoardUpdateToDatabase');"
	tabIndex=1 type=button value=Update name=update> <INPUT
	class=button id=reset tabindex="1" accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <input name="Button"
	tabindex="1" type="button" class="button2"
	onClick="submitForm('medicalBoardProceeding','medicalboardUpdate?method=printMedicalBoard');"
	value="Print Medical Board Proceedings" /> <input type="button"
	name="back" id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex=1 />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>


</div>
</form>
</div>


<!--main content placeholder ends here-->

<script type="text/javascript"> 
	
	function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('disabilities'+i).value == ""){
	  				msg += "Disabilities can not be blank.\n";
	  			}
	  			if(document.getElementById('date'+i).value == ""){
	  				msg += "Date can not be blank.\n";
	  			}
	  			if(document.getElementById('place'+i).value == ""){
	  				msg += "Place can not be blank.\n";
	  			}
	  			if(document.getElementById('previous'+i).value == "")
	  			{
	  			msg += "Previous Medical Categorisation cnn not be blank";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	  }
	  
	  function fillSrNo(rowVal){

	if(document.getElementById('chargeCode'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeCode'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
	</script>

<script>
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    } 
}
</script>





<script type="text/javascript">
	
function makeChoice(radiobutton)

{
var text = radiobutton.value; 

if( text=="Yes")
{
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.style.display="";
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.focus();
}
else
{
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.style.display="none";
}
}
function choose(radiobutton)

{
 var text = radiobutton.value; 
if( text=="Yes")
{
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.style.display="";
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.focus();
}
else
{
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.style.display="none";

}
}
<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : citylist) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
	
	</script>