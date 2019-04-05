<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>
<div id="contentHolder">
<form name="orderBooking" method="post" action="">
<%

	int pageNo=1;
	String buttonFlag="";
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	List inPatientDetailList = new ArrayList();
	List chargeList = new ArrayList();
	Box box = HMSUtil.getBox(request);
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	int dgOrderhdId = 0;
	int deptId=0;
	String deptName="";
	String userName = "";
	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}
	if(map.get("buttonFlag") != null){
	    buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	if(map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("dgOrderhdId") != null){
		dgOrderhdId=(Integer)map.get("dgOrderhdId");
	}
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	if(map.get("inPatientDetailList") != null){
	inPatientDetailList = (List<Patient>)map.get("inPatientDetailList");
	}
	if(detailsMap.get("mainChargeCodeList") != null){
	mainChargeCodeList = (List<MasMainChargecode>)detailsMap.get("mainChargeCodeList");
	}
	if(detailsMap.get("subChargeCodeList") != null){
	subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
	}
	if(detailsMap.get("chargeList") != null){
	chargeList = (List)detailsMap.get("chargeList");
	}
	if(map.get("icdList") != null){
		icdList = (List<DischargeIcdCode>)map.get("icdList");
	}
	int inpatientId = 0;
	String adNo ="";
	String admissionNumber = "";
	int hinId = 0;
	Inpatient inpatient = null;
	Patient patient =new Patient();
	MasDepartment masDepartment=new MasDepartment();
	if(inPatientDetailList != null )
	{
	Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	hinId=inPatientDetail.getHin().getId();
	try
	{
	inpatient = (Inpatient) inPatientDetailList.get(0);
	patient = (Patient) inpatient.getHin();
	masDepartment=(MasDepartment)inpatient.getDepartment();
	admissionNumber=inPatientDetail.getAdNo();
	session.setAttribute("admissionNumber",admissionNumber);
	
	try{
	if(patient.getInpatients() != null)
	{
		Set<Inpatient> inpatientSet = patient.getInpatients();	    
				if(!inpatient.getAdStatus().equals("D")){
				inpatientId = inpatient.getId();
				adNo = inpatient.getAdNo();
	}}} 
	catch (Exception e) 
	{
		admissionNumber = "";
	}}
	catch(Exception e)
	{
	e.printStackTrace();
	}}
%> <script>
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


<h4><%=deptName%></h4>
<h6>Order Booking</h6>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String orderSeqNo="";
		if(map.get("orderSeqNo") != null){
			orderSeqNo = (String)map.get("orderSeqNo");
			System.out.println("orderSeqNo----in jsp---"+orderSeqNo);
		}
%> <label>Order Number</label> <input id="fatherId" type=hidden
	name="<%=ORDER_NO %>" value="<%=orderSeqNo %>" title="Order Number" />
<label class="value"> <%=orderSeqNo %> </label> <input type="hidden"
	id="dgOrderhdId" name="dgOrderhdId" value="<%= dgOrderhdId%>" /> <input
	type="hidden" id="hinId" value="<%= hinId%>" /> <input type="hidden"
	id="admissionNumber" value="<%= admissionNumber%>" /> <label>Order
Date</label> <label class="value"> <%= date%> </label> <label>Order Time</label>
<label class="value"> <%= time%> </label> <%
				if(inpatient.getAdNo() != null && !(inpatient.getAdNo().equals(""))){
	 %>
<div class="Clear"></div>
<label>Admission No</label> <label class="value"><%=inpatient.getAdNo().toString()%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%}%> <label>Service
No</label> <%
		if(inpatient.getHin().getServiceNo() != null && !(inpatient.getHin().getServiceNo().equals(""))){
	 %> <label class="value"><%=inpatient.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <%
				if(inpatient.getHin().getRelation() != null && !(inpatient.getHin().getRelation().equals(""))){
	  %> <label>Relation</label> <label class="value"><%=inpatient.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <%}%>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <%
				if(inpatient.getHin().getSFirstName() != null  && !(inpatient.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(inpatient.getHin().getSMiddleName() != null){
						sMiddleName = inpatient.getHin().getSMiddleName();
					}
					if(inpatient.getHin().getSLastName() != null){
						sLastName = inpatient.getHin().getSLastName();
					}
				 %> <label class="value"><%= inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Patient
Name</label> <label class="value"><%=inpatient.getHin().getPFirstName() + " " + inpatient.getHin().getPMiddleName() + " " 
		+ inpatient.getHin().getPLastName()%></label> <%
				if(inpatient.getAge() != null && !(inpatient.getAge().equals(""))){
	  %> <label>Age/Sex</label> <label class="value"><%=inpatient.getAge()%>/<%=inpatient.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%}%> <%
			if(inpatient.getDepartment()!= null && !(inpatient.getDepartment().equals(""))){
		%>
<div class="Clear"></div>
<label>Ward</label> <label class="value"><%= inpatient.getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%}%> <label>Test
Type</label> <select name="<%=TEST_TYPE%>">
	<option value="Regular">Regular</option>
	<option value="Urgent">Urgent</option>
</select></div>


<div class="division"></div>
<label class="common">Clinical Notes</label> <input id="clinicalNote"
	type="text" class="large2" name="<%= CLINICAL_NOTE%>" value=""
	validate="Clinical Notes,string,yes" MAXLENGTH="100" tabindex=1 />
<div class="Clear"></div>
<label class="common"><span>*</span>Prescribed By</label> <select
	id="placedBy" name="<%=EMPLOYEE_ID %>" tabindex="1"
	validate="Prescribed By,String,yes">
	<option value=0>Select</option>

	<% 
		for (MasEmployee  obj : employeeList){
		if(obj.getEmpCategory() != null){
		if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
		
		String doctorMiddleName = "";
		String doctorLastName = "";
		
		doctorMiddleName = obj.getMiddleName();
		doctorLastName = obj.getLastName();
	
	%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  } }
	}%>

</select> <input type="hidden" name="hin" value="<%=patient.getHinNo() %>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" /> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=CREATED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <label class="common">Lab</label>

<select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubCharge(this.value,'orderBooking');">
	<option value="0">Select</option>
	<%
			for(MasMainChargecode mainChargecode : mainChargeCodeList){
		%>
	<option value="<%=mainChargecode.getId() %>"
		<%=HMSUtil.isSelected(mainChargecode.getId(),Integer.valueOf(box.getInt(MAIN_CHARGECODE_ID)))%>><%=mainChargecode.getMainChargecodeName() %></option>
	<%}%>
</select> <label class="common">Lab Group</label> <select id="subChargeCodeId"
	name="subChargeCode_id">
	<option value="0">Select</option>
	<%
	for(MasSubChargecode subChargecode : subChargeCodeList){
	%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> <script type="text/javascript">

<%

	int counter1 = 0;
	
	for (MasMainChargecode mainChargecode : mainChargeCodeList)
	{
	for (MasSubChargecode subChargecode : subChargeCodeList) 
	{
	if(subChargecode.getMainChargecode() != null){
	if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
%>
	subChargeArray[<%=counter1%>] = new Array();
	subChargeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
	subChargeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;									
	subChargeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
	<%
	counter1++;
	} } } }

%>
</script> <script type="text/javascript">
var amtArray = new Array();
<%
int  counter=0;
	if(chargeList!=null){
	Iterator ite = chargeList.iterator();
	while ( ite.hasNext() ) {
	Object[] pair = (Object[]) ite.next();
	MasChargeCode masChargeCode = (MasChargeCode) pair[0];

%>
	amtArray[<%=counter%>] = new Array();
	amtArray[<%=counter%>][0]=<%=masChargeCode.getId()%>;
	amtArray[<%=counter%>][1] = <%=masChargeCode.getChargeCodeCode()%>;									

<%
counter++;
}}
%>
</script> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">SR No</th>
			<th width="7%">Test Code</th>
			<th width="10%">Test Name</th>
			<th width="7%">Quantity</th>
		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=10; 
    	int temp=0;
    	int inc = 0;    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(inc=1;inc<=10;inc++){
    	%>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" align="right"
				name="<%=CHARGE_CODE%>" id="chargeCode<%=inc%>"
				onblur="if(fillSrNo('<%=inc %>')){checkForChargeCode(this.value, '<%=inc %>');}" />
			<div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter(document.getElementById('chargeCode<%=inc%>'),'ac2update','lab?method=getChargeCode',{parameters:'requiredField=chargeCode', callback: eventCallback});
			  
    </script></td>
			<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
				id="chargeCodeId<%=inc %>" />

			<td><input type="text" id="chargeName<%=inc%>"
				name="<%=CHARGE_NAME%>" value="" readonly="readonly" /></td>
			</td>
			<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>"
				value="" validate="Qty,int,no" MAXLENGTH="3" /></td>
			<input type="hidden" name="<%=CREATED_BY%>" value="<%=userName%>" />
		</tr>
		<input type="hidden" value="" name="mainCharge"
			id="mainChargeId<%=inc %>" />
		<input type="hidden" value="" name="subCharge"
			id="subChargeId<%=inc %>" />
		<%} %>
		<tr>
	</tbody>
	<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
		id="dgOrderhdId" />
</table>

</div>
<div class="division"></div>

<label class="common">Provisional Diagnosis</label> <%
			if(inpatient.getInitDiagnosis()!= null && !(inpatient.getInitDiagnosis().equals(""))){
		%> <label class="valueNoWidth"><%=inpatient.getInitDiagnosis() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="division"></div>
<div class="Clear"></div>

<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkFilledRow()){submitForm('orderBooking','lab?method=submitOrderBooking');}"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('orderBooking');"
	accesskey="r" /> <input type="button" class="button" value="Back"
	align="right" onClick="history.back();" /> <input type="hidden"
	name="rows" id="rr" value="1" /></div>


<script type="text/javascript">
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

function checkForChargeCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForChargeCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			var indexForChargeCode = indexForChargeCode--;
			var chargeCode = val.substring(0,indexForChargeCode);
		
		if(chargeId =="")
		{
	     document.getElementById('chargeName'+inc).value="";
	  	 document.getElementById('qty'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('chargeCode'+i).value==val)
		{
			alert("Charge Code already selected...!")
			document.getElementById('chargeCode'+inc).value=""
			var e=eval(document.getElementById('chargeCode'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  chargeCode , inc);
		
		}else{
			document.getElementById('chargeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
		}
}
function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.");
	  	return false;
	  }else{
	  	var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('chargeName'+i).value == ""){
	  				msg += "Charge Name can not be blank.\n";
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

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('chargeName'+i).value == ""){
	  				msg += "ChargeName can not be blank.\n";
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
function clearAllFields(inc){
	var chargeName = document.getElementById('chargeName'+inc).value
	var qty = document.getElementById('qty'+inc).value;
	
}
</script></form>
</div>
