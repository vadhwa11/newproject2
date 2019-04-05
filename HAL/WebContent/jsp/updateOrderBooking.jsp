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

	int deptId=0;
	int orderHdId = 0;
	int sampleCollectionHeaderId = 0;
	int sampleCollDtId = 0;
	String deptName="";
	String rejReason = "";
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

	if(map.get("orderHdId") != null) {
		orderHdId = (Integer) map.get("orderHdId");
	}

	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("orderHdId") != null){
		orderHdId=(Integer)map.get("orderHdId");
	}
	if(map.get("sampleCollectionHeaderId") != null){
		sampleCollectionHeaderId = (Integer)map.get("sampleCollectionHeaderId");
	}
	if(map.get("rejReason") != null){
		rejReason = (String)map.get("rejReason");
	}

	if(map.get("sampleCollDtId") != null){
		sampleCollDtId = (Integer)map.get("sampleCollDtId");
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
	
	String fullName = "";
	String patientfullName = "";
	Inpatient inpatient = null;
	Patient patient =new Patient();
	MasDepartment masDepartment=new MasDepartment();
	if(inPatientDetailList != null )
	{
		Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
		System.out.println("Id :"+inPatientDetail.getId());

		hinId=inPatientDetail.getHin().getId();
		try
		{
		inpatient = (Inpatient) inPatientDetailList.get(0);
		System.out.println("Patient Id :"+inPatientDetail.getHin().getId());
		patient = (Patient) inpatient.getHin();
		masDepartment=(MasDepartment)inpatient.getDepartment();
		admissionNumber=inPatientDetail.getAdNo();
	
	
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
	int doctorId = 0;
	
	if(inpatient.getDoctor()!=null){
		doctorId = inpatient.getDoctor().getId();		
	}
	int departmentId = (Integer)session.getAttribute("deptId");
%>


<h6>Order Booking</h6>
<label style="padding-top: 30px; padding-left: 300px;">(<%=deptName%>)</label>
<!--  <input type="hidden" name="deptName" id="deptName"  value="<%=deptName %>" /> -->
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
	id="dgOrderhdId" name="dgOrderhdId" value="<%= orderHdId%>" /> <input
	type="hidden" id="sampleCollectionHeaderId"
	name="sampleCollectionHeaderId" value="<%=sampleCollectionHeaderId%>" />
<input type="hidden" id="sampleCollDtId" name="sampleCollDtId"
	value="<%=sampleCollDtId%>" /> <input type="hidden" id="rejReason"
	name="rejReason" value="<%=rejReason%>" /> <input type="hidden"
	id="hinId" value="<%= hinId%>" /> <input type="hidden"
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
					fullName = inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
	
				 %> <label class="value"><%= inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>

<%}else{ %> <label class="value">-</label> <% }%> <label>Patient
Name</label> <%
				if(inpatient.getHin().getPFirstName() != null  && !(inpatient.getHin().getPFirstName().equals(""))){
				
					String pMiddleName = "";
					String pLastName = "";
					if(inpatient.getHin().getSMiddleName() != null){
						pMiddleName = inpatient.getHin().getPMiddleName();
					}
					if(inpatient.getHin().getSLastName() != null){
						pLastName = inpatient.getHin().getPLastName();
					}
					patientfullName = inpatient.getHin().getPFirstName()+" "+pMiddleName+" "+pLastName;
	
				 %> <label class="value"><%=inpatient.getHin().getPFirstName() + " " + pMiddleName + " "+ pLastName%></label>

<%}else{ %> <label class="value">-</label> <% }%> <%
				if(inpatient.getAge() != null && !(inpatient.getAge().equals(""))){
	  %> <label>Age/Sex</label> <label class="value"><%=inpatient.getAge()%>/<%=inpatient.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%}%> <%
			if(inpatient.getDepartment()!= null && !(inpatient.getDepartment().equals(""))){
		%>
<div class="Clear"></div>
<%if(fullName.length()>15 || patientfullName.length()>15){ %> <br>
<%}%> <label>Ward</label> <label class="value"><%= inpatient.getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%}%> <label>Test
Type</label> <select name="<%=TEST_TYPE%>">
	<option value="Regular">Regular</option>
	<option value="Urgent">Urgent</option>
</select></div>


<!-- 	<div class="division"></div> --> <label class="common"><span>*</span>Clinical
Notes</label> <%
		if(inpatient.getInitDiagnosis()!= null && !(inpatient.getInitDiagnosis().equals(""))){
	%> <input id="clinicalNote" type="text" class="large2"
	name="<%= CLINICAL_NOTE%>" value="<%=inpatient.getInitDiagnosis() %>"
	validate="Clinical Notes,string,yes" MAXLENGTH="100" tabindex=1 /> <%}else{ %>
<input id="clinicalNote" type="text" class="large2"
	name="<%= CLINICAL_NOTE%>" value=""
	validate="Clinical Notes,string,yes" MAXLENGTH="100" tabindex=1 /> <%} %>

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
		if(obj.getMiddleName()!=null){
			doctorMiddleName = obj.getMiddleName();			
		}
		if(obj.getLastName()!=null){
			doctorLastName = obj.getLastName();			
		}
		//System.out.println("doc Id :"+doctorId);
		if(doctorId == obj.getId()){
	%>
	<option value="<%=obj.getId()%>" selected="selected"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  }else{%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%	}} }
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
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <label class="common">Department</label>

<select id="mainChargeCodeId" disabled="disabled"
	name="<%=MAIN_CHARGECODE_ID %>" tabindex="1"
	onchange="populateSubCharge(this.value,'orderBooking');">
	<option value="0">Select</option>
	<%
			for(MasMainChargecode mainChargecode : mainChargeCodeList){
				if(mainChargecode.getDepartment().getId() == departmentId){ %>
	<option value="<%=mainChargecode.getId() %>" selected="selected"
		<%=HMSUtil.isSelected(mainChargecode.getId(),Integer.valueOf(box.getInt(MAIN_CHARGECODE_ID)))%>><%=mainChargecode.getMainChargecodeName() %></option>

	<%	}else{ %>
	<option value="<%=mainChargecode.getId() %>"
		<%=HMSUtil.isSelected(mainChargecode.getId(),Integer.valueOf(box.getInt(MAIN_CHARGECODE_ID)))%>><%=mainChargecode.getMainChargecodeName() %></option>
	<% } %>
	<%}%>
</select> <label class="common">Modality</label> <select id="subChargeCodeId"
	name="subChargeCode_id" tabindex="1">
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
		var tempMainChargeCode = document.getElementById('mainChargeCodeId').value;

	 	populateSubCharge(tempMainChargeCode,'orderBooking');
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
	id="noOfRecords" /> <input type="hidden" value="<%=orderHdId%>"
	name="orderdIdToUpdate" id="orderdIdToUpdate" /> <script
	type="text/javascript">
		document.getElementById('noOfRecords').value='';
	</script> <!-- 	<div class="division"></div> -->
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr style="width: 100%">
			<th width="5%">SR No</th>
			<th width="95%">Test Name</th>
			<!--  <th width="10%">Test Name</th> -->
			<!-- <th width="7%">Quantity</th> -->
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
			<td width="95%"><input type="text" align="right"
				name="<%=CHARGE_CODE%>" tabindex="1" id="chargeCode<%=inc%>"
				style="width: 100%"
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
			<td><input type="hidden" id="chargeName<%=inc%>"
				style="width: 80%" name="<%=CHARGE_NAME%>" value=""
				readonly="readonly" /></td>
			</td>
			<td><input type="hidden" id="qty<%=inc%>" name="<%=QUANTITY %>"
				value="" validate="Qty,int,no" MAXLENGTH="3" /></td>

			<input type="hidden" name="<%=CREATED_BY%>" value="<%=userName%>" />
		</tr>
		<input type="hidden" value="" name="mainCharge"
			id="mainChargeId<%=inc %>" />
		<input type="hidden" value="" name="subCharge"
			id="subChargeId<%=inc %>" />
		<script type="text/javascript">
		document.getElementById('chargeCodeId'+<%=inc%>).value='';
		document.getElementById('chargeName'+<%=inc%>).value='';
		document.getElementById('qty'+<%=inc%>).value='';
		document.getElementById('mainChargeId'+<%=inc%>).value='';
		document.getElementById('subChargeId'+<%=inc%>).value='';		
	</script>

		<%} %>
		<tr>
	</tbody>

</table>

</div>
<div class="division"></div>

<label class="common">Provisional Diagnosis</label> <%
			if(inpatient.getInitDiagnosis()!= null && !(inpatient.getInitDiagnosis().equals(""))){
		%> <label class="valueNoWidth"><%=inpatient.getInitDiagnosis() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" /> <input
	type="hidden" name="ajaxFlag" id="ajaxFlag" value="ajaxComplete" />
<div class="division"></div>
<div class="Clear"></div>

<div class="bottom"><input type="button" id="submitButton"
	class="button" value="Submit"
	onclick="if(checkFilledRow()){submitForm('orderBooking','lab?method=updateOrderBookingForIPD');}"
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
			//document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
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
		
		if(chargeId == "" )
	    {
	    	//alert('Test name '+ chargeCode + ' is incorrect.');
	      document.getElementById('chargeName'+inc).value="";
	 	  document.getElementById('qty'+inc).value="";
	 	  //document.getElementById('chargeCodeId'+inc).value = "";
	 	  //document.getElementById('chargeCode'+inc).value = "";
	      return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('chargeCode'+i).value==val)
		{
			alert("Test name already selected...!")
			document.getElementById('chargeCode'+inc).value=""
			var e=eval(document.getElementById('chargeCode'+inc)); 
			e.focus();
			return false;
		} }  }
		document.getElementById('ajaxFlag').value="ajaxStart";
		var nameOfChargeCodeArray = chargeCode.split('&');
		var tempChargeCodeString = "";
		for(var m=0; m<nameOfChargeCodeArray.length;m++)
		{
			//alert(nameOfChargeCodeArray[m]);
			//alert(tempChargeCodeString);
				//alert(tempChargeCodeString.length);
			//if(tempChargeCodeString.length == 0){
				//alert(tempChargeCodeString.length);
				tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";			
			//}else{
			   	//tempChargeCodeString = + tempChargeCodeString + nameOfChargeCodeArray[m];
			//}
		}
		//alert(tempChargeCodeString);
		
		ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  tempChargeCodeString , inc);
		document.getElementById('ajaxFlag').value="ajaxComplete";
		
		}else{
			document.getElementById('chargeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCodeId'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
}
function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.");
	  	return false;
	  }else{
	  	return true;
	  	//var msg ="";
	  	//var count = document.getElementById('noOfRecords').value;
	  	//for(var i=1;i<=count;i++){
	  	//	if(document.getElementById('chargeCode'+i).value != ""){
	 	//		if(document.getElementById('qty'+i).value == ""){
	  //				msg += "Quantity can not be blank.\n";
	  	//		}
	  //			if(document.getElementById('chargeName'+i).value == ""){
	  //				msg += "Charge Name can not be blank.\n";
	  //			}
	  //			if(msg != ""){
	  //				break;
	  //			}
	 //		}
	  //	}
	  //	if(msg != ""){
	 // 			alert(msg)
	  	//		return false;
	  //		}else
	  //			return true;
	  }
  }
function checkForWrongChargeCode(){
	var c = 1;
	//var wrongFilledFlag = false;
	while(c <= 10){
		var tempCharge = document.getElementById('chargeCode'+ c).value;
		var tempChargeCodeId = document.getElementById('chargeCodeId'+ c).value;
		
		if( tempCharge != '' &&
		 	(tempChargeCodeId == '' || tempChargeCodeId == 'NoMatch')){
		 		//var checkAjaxComplete = document.getElementById('ajaxFlag').value;
		 		//alert('check value :'+checkAjaxComplete);
			//if(checkAjaxComplete == 'ajaxComplete'){
				
		 	
			alert('Test Name ' + document.getElementById('chargeCode'+ c).value + ' is incorrect.' );
			document.getElementById('chargeCode'+ c).value = '';
			document.getElementById('chargeCodeId'+ c).value = '';
			document.getElementById('chargeName'+ c).value='';
			document.getElementById('qty'+c).value='';
			document.getElementById('mainChargeId'+c).value='';
			document.getElementById('subChargeId'+c).value='';		
			return false;
			//}
			
		}
		if(tempCharge != ''){
			var index1 = tempCharge.lastIndexOf("[");
			var index2 = tempCharge.lastIndexOf("]");
			var tempParseChargeId = tempCharge.substring(index1,index2);
			if(tempParseChargeId == ""){
				alert('Test Name ' + document.getElementById('chargeCode'+ c).value + ' is incorrect.' );
				document.getElementById('chargeCode'+ c).value = '';
				document.getElementById('chargeCodeId'+ c).value = '';
				document.getElementById('chargeName'+ c).value='';
				document.getElementById('qty'+c).value='';
				document.getElementById('mainChargeId'+c).value='';
				document.getElementById('subChargeId'+c).value='';		
				return false;
			}
		}
		c++;
	}
	return true;
}
function checkFilledRow(){
	var msg ="";
	if(checkForWrongChargeCode()){
	var rowCounter = 1;
	var filledFlag = false;
	while(rowCounter <= 10){
		if(document.getElementById('chargeCode'+ rowCounter).value != ''){
			filledFlag = true;
			break;
		}
		rowCounter++;
	}
	if(filledFlag == true){
		return true;
	}else{
		alert("Please fill atleast one row to submit.");
		return false;
	}
	
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	return true;
	  //var msg ="";
	  //	var count = document.getElementById('noOfRecords').value;
	  //	for(var i=1;i<=count;i++){
	  //	 	if(document.getElementById('chargeCode'+i).value != ""){
	  //			if(document.getElementById('qty'+i).value == ""){
	  //				msg += "Quantity can not be blank.\n";
	  //			}
	  //			if(document.getElementById('chargeName'+i).value == ""){
	  //				msg += "ChargeName can not be blank.\n";
	  //			}
	  //			if(msg != ""){
	  //				break;
	  //			}
	  //		}
	  //	}
	  //		if(msg != ""){
	  //			alert(msg)
	 // 			return false;
	 // 		}else
	  //			return true;
	  }
	 }
	 document.getElementById('submitButton').disabled = true;
	 }
function clearAllFields(inc){
	var chargeName = document.getElementById('chargeName'+inc).value
	var qty = document.getElementById('qty'+inc).value;
	
}
	document.getElementById('chargeCode1').focus();
</script></form>
</div>
