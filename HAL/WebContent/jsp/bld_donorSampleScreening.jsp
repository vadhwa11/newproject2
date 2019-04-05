
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="sampleScreening" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodDonationEntryDetail> doantionDetailList = new ArrayList<BloodDonationEntryDetail>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	
	BloodDonationEntryDetail donationEntryDetail= new BloodDonationEntryDetail();
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
	if(map.get("doantionDetailList") != null){
		doantionDetailList=(List)map.get("doantionDetailList");
	}
	Patient patient = new Patient();
	MasRank masRank = new MasRank();
	if(doantionDetailList != null && doantionDetailList.size()>0)
	{
		donationEntryDetail=(BloodDonationEntryDetail) doantionDetailList.get(0);
		if(donationEntryDetail.getDonation().getHin() != null){
			patient = (Patient) donationEntryDetail.getDonation().getHin();
			hinId=patient.getId();
			masRank = (MasRank) patient.getRank();
		}
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
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	int scrneeinghdId = 0;
	if(map.get("scrneeinghdId") != null){
		scrneeinghdId=(Integer)map.get("scrneeinghdId");
	}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Donor Sample Screening Test Result Entry</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<input type="hidden" id="scrneeinghdId" name="scrneeinghdId"
	value="<%= scrneeinghdId%>" /> 
<label>Service Type</label> <%
				if(donationEntryDetail.getDonation().getHin() != null){
			%> <label class="value"><%= donationEntryDetail.getDonation().getHin().getServiceType().getServiceTypeName()%></label>
<%}else if(donationEntryDetail.getDonation()!=null){ %> <label
	class="value"><%=donationEntryDetail.getDonation().getDonerType() %></label>
<% }else{%> <label>-</label> <%} %> <label>Service No.</label> <%
				if(donationEntryDetail.getDonation().getHin() != null ){
			%> <label class="value"><%= donationEntryDetail.getDonation().getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Service
Status</label> <%if(donationEntryDetail.getDonation().getHin()!= null){
			%> <label class="value"><%= donationEntryDetail.getDonation().getHin().getServiceStatus().getServiceStatusName()%></label>
<%}else if(donationEntryDetail.getDonation().getDonerType()!=null){ %> <label
	class="value"><%= donationEntryDetail.getDonation().getDonerType()%></label>
<% }else{%> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Relation</label> <%
				if(donationEntryDetail.getDonation().getHin()!= null){
			%> <label class="value"><%= donationEntryDetail.getDonation().getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Ser. Per.
Name</label> <%
				if(donationEntryDetail.getDonation().getHin() != null ){
				
					String sMiddleName = "";
					String sLastName = "";
					if(donationEntryDetail.getDonation().getHin().getSMiddleName() != null){
						sMiddleName = donationEntryDetail.getDonation().getHin().getSMiddleName();
					}
					if(donationEntryDetail.getDonation().getHin().getSLastName() != null){
						sLastName = donationEntryDetail.getDonation().getHin().getSLastName();
					}
			 %> <label class="value"><%= donationEntryDetail.getDonation().getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value"><%=donationEntryDetail.getDonation().getDonerName() %></label>
<% }%> <label>Rank</label> <%
			if(donationEntryDetail.getDonation().getHin() != null){
			%> <label class="value"><%= donationEntryDetail.getDonation().getHin().getRank().getRankName()%></label>
<%} else if(donationEntryDetail.getDonation().getRank() != null){ %> <label
	class="value"><%=donationEntryDetail.getDonation().getRank().getRankName() %></label>
<% }else{%> <label class="value">-</label> <%}%>
<div class="Clear"></div>

<div class="Clear"></div>

</div>
<div class="division"></div>
<div class="blockFrame"><label>Blood Bag No.</label> <label
	class="value"><%=donationEntryDetail.getBloodBagNo()%></label> <label>Donation
No.</label> <label class="value"><%=donationEntryDetail.getDonation().getDonationNo()%></label>
<div class="Clear"></div>

<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" />
<%if(donationEntryDetail.getDonation().getHin() != null){ %> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=donationEntryDetail.getDonation().getHin().getId() %>" /> <%} %>
<input type="hidden" name="<%=BLOOD_DONATION_ENTRY_DETAIL_ID %>"
	value="<%=donationEntryDetail.getId() %>" />
<div class="Clear"></div>
<%
		String testSeqNo="";
		if(map.get("testSeqNo") != null){
			testSeqNo = (String)map.get("testSeqNo");
		}
%> <label>Sample Tested No.</label> <input id="sampleTestId" type=hidden
	name="<%=SAMPLE_TEST_NO %>" value="<%=testSeqNo %>"
	title="Sample Test No" /> <label class="value"><%=testSeqNo %></label>

<label>Sample Tested Date</label> <label class="value"> <%= date%>
</label> <label> <span>*</span> Sample Tested By</label>
<select id="collectedBy" name="<%=EMPLOYEE_ID %>" validate="Sample Test By,string,yes">
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
</select></div>

<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="division"></div>
<div class="blockTitle">Sample Tested Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

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
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %>"
				value="<%=masInvestigation.getId() %>" /></td>
			<td><input type="text" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME%><%=inc %>"
				value="<%=masInvestigation.getInvestigationName() %>[<%=masInvestigation.getId() %>]"
				readonly="readonly" /></td>

			<td>
			<%if(masInvestigation.getInvestigationName().equalsIgnoreCase("ABO & RH")){ %> <select id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="O Rh POSITIVE">O Rh POSITIVE</option>
				<option value="O Rh NEGATIVE">O Rh NEGATIVE</option>
				<option value="A Rh POSITIVE">A Rh POSITIVE</option>
				<option value="A Rh NEGATIVE">A Rh NEGATIVE</option>
				<option value="B Rh POSITIVE">B Rh POSITIVE</option>
				<option value="B Rh NEGATIVE">B Rh NEGATIVE</option>
				<option value="AB Rh POSITIVE">AB Rh POSITIVE</option>
				<option value="AB Rh NEGATIVE">AB Rh NEGATIVE</option>
			</select> <%}else{ %> <select id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select> <%} %>
			</td>
		</tr>
		<% }else{
		 %>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %>" value="" />

			</td>
			<td><input type="text" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME %><%=inc%>"
				onblur="if(fillSrNo('<%=inc %>')){checkForInvestigationName(this.value, '<%=inc %>');}" />
			<div id="ac2update6"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		
			  new Ajax.Autocompleter('investigationName<%=inc %>','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName<%=inc %>'});
			</script></td>

			<td><select id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select></td>
		</tr>
		<%} }%>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div class="Height10"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="if(checkFilledRow())submitForm('sampleScreening','bloodBank?method=submitDonorBloodSampleScreeningTest');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('sampleScreening',<%=inc %>);" accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
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
			var indexForInvestigationName = indexForInvestigationName;
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
	if(document.getElementById("investigationName"+a).value!=""){
	if(document.getElementById("result"+a).value==""){
	alert("Please select result in row "+a);
	return false;
	}
	}
	}
	return true;
	}

</script>