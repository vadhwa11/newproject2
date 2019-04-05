
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="sampleScreening" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	BloodReactionEntry bloodReactionEntry= new BloodReactionEntry();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	int hinId= 0;
	String deptName="";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("reactionList") != null){
		reactionList=(List)map.get("reactionList");
	}
	if(reactionList != null) {
		bloodReactionEntry = (BloodReactionEntry) reactionList.get(0);
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if (map.get("investigationList") != null) {
		investigationList = (List<DgMasInvestigation>) map.get("investigationList");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Investigation of Transfusion Reacted Blood Result Entry</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="Clear"></div>
<div class="blockFrame"><label>Reaction No</label> <label
	class="value"><%=bloodReactionEntry.getEntryNo() %></label> 
<label>Reaction Date</label> 
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(bloodReactionEntry.getRactionDate()) %></label>
<div class="Clear"></div>
</div>
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Service Type</label> <%if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getServiceType() != null){
			%> <label class="value"><%= bloodReactionEntry.getHin().getServiceType().getServiceTypeName()%></label>
<%}}else{ %> <label class="value">-</label> <% }%> <label>Service No</label>
<%
		  if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getServiceNo() != null && !(bloodReactionEntry.getHin().getServiceNo().equals(""))){
			%> <label class="value"><%= bloodReactionEntry.getHin().getServiceNo()%></label>
<%}}else{ %> <label class="value">-</label> <%}%> <label>Service
Status</label> <%if(bloodReactionEntry.getHin()!=null )%> <%if(bloodReactionEntry.getHin()!=null){if(bloodReactionEntry.getHin().getServiceStatus() != null){
			%> <label class="value"><%= bloodReactionEntry.getHin().getServiceStatus().getServiceStatusName()%></label>
<%}}else{ %> <label class="value">-</label> <% }%>

<div class="Clear"></div>

<label>Relation</label> <%
			if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getRelation() != null){
			%> <label class="value"><%= bloodReactionEntry.getHin().getRelation().getRelationName()%></label>
<%}}else{ %> <label class="value">-</label> <% }%> <label>Ser. Per.
Name</label> <%if(bloodReactionEntry.getHin()!=null ){
				if(bloodReactionEntry.getHin().getSFirstName() != null  && !(bloodReactionEntry.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(bloodReactionEntry.getHin().getSMiddleName() != null){
						sMiddleName = bloodReactionEntry.getHin().getSMiddleName();
					}
					if(bloodReactionEntry.getHin().getSLastName() != null){
						sLastName = bloodReactionEntry.getHin().getSLastName();
					}
			 %> <label class="value"><%= bloodReactionEntry.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}}else{ %> <label class="value">-</label> <% }%> <label>Rank</label> <%
			if(bloodReactionEntry.getHin()!=null){
			if(bloodReactionEntry.getHin().getRank() != null){
			%> <label class="value"><%= bloodReactionEntry.getHin().getRank().getRankName()%></label>
<%} }else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>
<label>Unit</label> <%
			if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getUnit() != null){
			%> <label class="value"><%=bloodReactionEntry.getHin().getUnit().getUnitName() %></label>
<%}}else{ %> <label class="value">-</label> <% }%> <label>Trade</label> <%
			if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getTrade() != null){
			%> <label class="value"><%=bloodReactionEntry.getHin().getTrade().getTradeName() %></label>
<%}}else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>

</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label>HIN No.</label> <%if (bloodReactionEntry.getHin()!=null){%> <label
	class="value"><%=bloodReactionEntry.getHin().getHinNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <%
					String middleName = "";
					String lastName = "";
					if(bloodReactionEntry.getHin().getPMiddleName() != null){
						middleName = bloodReactionEntry.getHin().getPMiddleName();
					}
					if(bloodReactionEntry.getHin().getPLastName() != null){
						lastName = bloodReactionEntry.getHin().getPLastName();
					}
					
		%> <label class="value">-</label> <label>Patient Name</label> <%if (bloodReactionEntry.getHin()!=null){%>
<label class="value"><%= bloodReactionEntry.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>
<%}else{ %> <label class="value"><%= bloodReactionEntry.getDonorName()%></label>
<%} %> <label>Sex</label> <%if (bloodReactionEntry.getHin()!=null){%> <label
	class="valueNoWidth"><%=bloodReactionEntry.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%
		String age = "";
		String currentAge = "";
		if (bloodReactionEntry.getHin()!=null){
		age = bloodReactionEntry.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, bloodReactionEntry.getHin().getRegDate());
		}else{
			age="-";
		}
		%>
<div class="Clear"></div>
<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(bloodReactionEntry.getHin()!=null){
				if(bloodReactionEntry.getHin().getMaritalStatus() != null){
					maritalStatus = bloodReactionEntry.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}}else{ %> <label
	class="value">-</label> <% }%>

<div class="Clear"></div>

<div>
<%if( bloodReactionEntry.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%= bloodReactionEntry.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <%if(bloodReactionEntry.getHin()!=null){%>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=bloodReactionEntry.getHin().getId() %>" /> <%} %> <input
	type="hidden" name="<%=BLOOD_REACTION_ID %>"
	value="<%=bloodReactionEntry.getId()%>" /></div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<div class="blockFrame">
<%
		String testSeqNo="";
		if(map.get("testSeqNo") != null){
			testSeqNo = (String)map.get("testSeqNo");
		}
%> <label>Test No.</label> <input id="sampleTestId" type=hidden
	name="<%=TEST_NO %>" value="<%=testSeqNo %>" title="Test No" /> <label
	class="value"> <%=testSeqNo %> </label> <label><span>*</span>Test
Date</label> <input type="text" class="calDate" id="testDate"
	name="<%=TEST_DATE %>" value="<%=date %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" validate="Test Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.sampleScreening.<%=TEST_DATE%>,event)"
	tabindex="1" /> <label><span>*</span>Test By</label> <select
	id="testBy" name="<%=EMPLOYEE_ID %>" validate="Test By,string,yes">
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
	<%		} }%>
</select>
<div class="Clear"></div>
</div>
<!-- Block Three Starts -->
<div class="division"></div>
<div class="blockTitle">Sample Test Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<div class="Clear"></div>

<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends --> <input type="hidden" size="2" value=""
	name="noOfRecords" id="noOfRecords" />
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>SR No</th>
			<th>Test Name</th>
			<th>Result</th>
		</tr>
	</thead>
	<tbody>
		<%
 
 		int investigationId=0;
    	int temp=0;
    	int inc = 0;    	
    	for(inc=1;inc<=10;inc++){
    		
      	DgMasInvestigation masInvestigation = new DgMasInvestigation();
		if (investigationList.size() > 0  && inc-1 <investigationList.size()) {
		 masInvestigation = investigationList.get(inc-1);    
				investigationId=masInvestigation.getId();
 %>

		<tr>
			<td width="5%"><input type="hidden" size="2" value="<%=inc%>"
				name="counter" id="counter" /> <input type="text" size="2"
				value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" /> <input
				type="hidden" id="investigationId<%=inc %>"
				name="<%=INVESTIGATION_ID %>" value="<%=masInvestigation.getId() %>" />

			</td>
			<td><input type="text" id="investigationName<%=inc%>" name="<%=INVESTIGATION_NAME%>"
				value="<%=masInvestigation.getInvestigationName() %>[<%=masInvestigation.getId() %>]"readonly="readonly" />
			</td>

			<td>
			<%if(masInvestigation.getInvestigationName().equalsIgnoreCase("ABO & RH")){ %>
			<select id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="O Rh POSITIVE">O Rh POSITIVE</option>
				<option value="O Rh NEGATIVE">O Rh NEGATIVE</option>
				<option value="A Rh POSITIVE">A Rh POSITIVE</option>
				<option value="A Rh NEGATIVE">A Rh NEGATIVE</option>
				<option value="B Rh POSITIVE">B Rh POSITIVE</option>
				<option value="B Rh NEGATIVE">B Rh NEGATIVE</option>
				<option value="AB Rh POSITIVE">AB Rh POSITIVE</option>
				<option value="AB Rh NEGATIVE">AB Rh NEGATIVE</option>
			</select> <%}else{ %>
			
			 <select id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select> <%} %>
			</td>
		</tr>
		<% }
	 }
%>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div class="blockTitle">Cross Match Method</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<label class="large">Cross Match Method</label>
<input type="checkbox" class="radio" name="<%=MAJOR_RS_DC %>"	value="" />
<label class="value">Major - RS + DC</label> 
<input type="checkbox" class="radio" name="<%=MAJOR_DS_RC  %>" value="" />
<label class="value">Major - DS + RC</label>

<div class="Clear"></div>
<label class="large"><span>*</span>Cross Match By</label>
<select	class="large" id="collectedBy" name="<%=CROSS_MATCHED_BY %>" validate="Cross Match By,string,yes">
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
	<%		} }%>
</select> <label class="noWidth">Compatibility</label> <select class="small"
	id="result<%=inc%>" name="<%=COMPATIBILITY%>">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<div class="Clear"></div>
</div>
<div class="Height10"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow() && checkFilledTest())submitForm('sampleScreening','bloodBank?method=submitTransfussionReaction');"
	align="right" />
<input type="reset" class="button" name="Reset"	id="reset" value="Reset" onclick="resetClicked('sampleScreening');"accesskey="r" />
	
<div class="division"></div>
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
</form>
<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">

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
<script type="text/javascript">
function checkForInvestigationName(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var investigationId = val.substring(index1,index2);
			var indexForInvestigationName = indexForInvestigationName--;
			var investigationName = val.substring(0,indexForInvestigationName);
		
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('investigationName'+i).value==val)
		{
			alert("investigation Name already selected...!")
			document.getElementById('investigationName1'+inc).value=""
			var e=eval(document.getElementById('investigationName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteInvestigationName('sampleScreening','bloodBank?method=fillItemsForInvestigationName&investigationName=' +  investigationName , inc);
		
}
}
function fillSrNo(rowVal){

	if(document.getElementById('investigationName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('investigationName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function checkFilledRow(){
	for(var a=1;a<=10;a++){
	//alert(document.getElementById("investigationName"+a).value )
	if(document.getElementById("investigationName"+a).value!=""){
	if(document.getElementById("result"+a).value==""){
	alert("Please select result in row "+a);
	return false;
	}
	else
	return true;
	}
	}
	
	}
	
function checkFilledTest(){
	for(var a=1;a<=10;a++){
	if(document.getElementById("result"+a).value!=""){
	if(document.getElementById("investigationName"+a).value==""){
	alert("Please select Test in row "+a);
	return false;
	}
	else
	return true;
	}
	}
	
	}
</script>