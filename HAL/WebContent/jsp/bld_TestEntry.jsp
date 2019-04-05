<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<form name="testEntry" method="post" action="">
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	
	String userName="";
    int pageNo=1;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if (map.get("investigationList") != null) {
		investigationList = (List<DgMasInvestigation>) map.get("investigationList");
	}
	if(map.get("rankList") != null){
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	if(map.get("unitList") != null){
		unitList = (List<MasUnit>)map.get("unitList");
	}
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	String serviceNo="";
	if(map.get("serviceNo") != null){
		serviceNo = (String)map.get("serviceNo");
	}
%>
<div id="contentHolder">
<h6>Blood Test Entry</h6>
<div class="Clear"></div>
<%
		String serialSeqNo="";
		if(map.get("serialSeqNo") != null){
			serialSeqNo = (String)map.get("serialSeqNo");
		}
%>
<div class="blockFrame"><input id="currentDateId" type=hidden
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" />
<label>Serial No.</label> <input id="serialNoId" type=hidden
	name="<%=SERIAL_NO%>" value="<%=serialSeqNo %>" title="Serial Number" />
<label class="value"> <%=serialSeqNo %> </label> <label>Test
Date</label> <input type="text" class="calDate" id="testDate"
	name="<%=TEST_DATE %>" value="<%=date %>" validate="Test Date,date,yes"
	MAXLENGTH="10" onblur="validateRequiredDate();" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.testEntry.<%=TEST_DATE%>,event)"
	onblur="validateRequiredDate();" /> 
	<label>Service No.</label>
	<input type="text" id="serviceNo" name="<%= SERVICE_NO%>" validate="Service No,string,no" tabindex=1
	maxlength="20" onblur="ajaxFunctionForTestPatient(testEntry);" /> 
	<input	id="hinId" type=hidden name="<%=HIN_ID%>" value="" />
<div class="Clear"></div>


<label><span>*</span> Name</label> <input type="text" id="name"
	name="<%= NAME%>" value="" validate="Name,string,yes"
	class="textbox_size20" tabindex=1 maxlength="30" /> <label>Rank</label>
<select id="rankId" name=<%=RANK_ID %> validate="Rank,string,no">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%		} } %>
</select> <label>Relation</label> <select id="relationId" name=<%=RELATION_ID %>
	validate="Relation,string,no">
	<option value="0">Select</option>

	<%
				         		if(relationList != null){ 	
				         			for (Iterator iter = relationList.iterator(); iter.hasNext();) {
				         				MasRelation masRelation = (MasRelation) iter.next();
				         %>
	<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName()%></option>
	<%		} } %>
</select>

<div class="Clear"></div>

<label>Patient Type</label> <select id="pType" name=<%=PATIENT_TYPE %>
	validate="Type,string,no">
	<option value="0">Select</option>
	<option value="ip">IP</option>
	<option value="op">OP</option>
</select> <label><span>*</span> Unit</label> <select id="unitId"
	name=<%=UNIT_ID %> validate="Unit,string,yes">
	<option value="0">Select</option>

	<%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitAddress()%></option>
	<%		} } %>
</select> <label><span>*</span> Sex</label> <select id="sexId" name=<%=SEX_ID %>
	validate="Sex,string,yes">
	<option value="0">Select</option>

	<%
				         		if(sexList != null){ 	
				         			for (Iterator iter = sexList.iterator(); iter.hasNext();) {
				         				MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
				         %>
	<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName()%></option>
	<%		} } %>
</select>
<div class="Clear"></div>

<label><span>*</span> Age</label> <input type="text" id="age"
	name="<%= AGE%>" value="" validate="Age,string,yes"
	class="textbox_size20" maxlength="20" tabindex=1 />
<label><span>*</span>Contact No.</label>
<input type="text" id="teleNo" name="<%= CONTACT_NUMBER%>"	value="" validate="Contact No.,phone,yes" maxlength="12" tabindex=1 />
	
<label><span>*</span> Received By </label>
<select id="employeeId" name=<%=EMPLOYEE_ID %>	validate="Received By,string,yes">
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
</select></div>
<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> 
<!-- Block Three Ends -->
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" /> 
<input type="hidden" name="pageNo" id="pageNo"	value="<%=pageNo%>" />
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>SR No</th>
			<th>Test Name</th>
			<th><span>*</span>Result</th>
		</tr>
	</thead>
	<tbody>
		<%
 
    	int temp=0;
    	int inc = 0;    	
    	for(inc=1;inc<=10;inc++){
%>
<tr>
	<td>
	  <input type="text" size="2" value="<%=temp+inc%>"	name="<%=SR_NO%>" readonly="readonly" />
		 <input type="hidden" id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %><%=inc %>" value="" />
	</td>
	<td>
	  <input type="text" id="investigationName<%=inc%>"	name="<%=INVESTIGATION_NAME %><%=inc %>"
		onblur="if(fillSrNo('<%=inc %>')){checkForInvestigationName(this.value, '<%=inc %>');}" />
	<div id="ac2update6"style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
	<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('investigationName<%=inc %>','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName<%=inc %>'});
	</script></td>
	<td>
	 <input type="text" id="result<%=inc%>" value="" name="<%=RESULT %><%=inc %>" maxlength="100" size="100" tabindex="1" />
	</td>
	<%}%>
	<input type="hidden" name="<%=CREATED_BY%>" value="<%=userName%>" />
		</tr>
	</tbody>
</table>
</div>
<input type="hidden" name="rowCount" value="<%=inc %>">
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow())submitForm('testEntry','bloodBank?method=submitBloodTestEntry');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('testEntry');"
	accesskey="r" />
<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>




</div>
</div>
</form>


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
			document.getElementById('investigationName'+inc).value=""
			var e=eval(document.getElementById('investigationName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteInvestigationName('testEntry','bloodBank?method=fillItemsForInvestigationName&investigationName=' +  investigationName , inc);
		
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
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('investigationName'+i).value != ""){
	  			if(document.getElementById('result'+i).value == ""){
	  				msg += "Result can not be blank.\n";
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
function validateRequiredDate(){
	var nowDate=new Date();
		
		obj1 = eval(document.testEntry.testDate)
			
		if(obj1.value != "" )
		{
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
			
			if(nowDate<validFromDate)
				{
				alert("Future Test Date should not be allowed.!!");
				document.getElementById("testDate").value=""
				return false;
				}
		}
		return true;
	}
</script>