<%@page import="jkt.hms.masters.business.MainCharge"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>

<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="java.util.*"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%> 


<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<%@page import="jkt.hms.masters.business.MasDiscount"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<form name="billServicing" method="post" action=""	onload="form.reset();">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> employeeList = new ArrayList<Object[]>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
	List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
	/* List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>(); */
	List<Object[]> masPTypeList= new ArrayList<Object[]>();
	List<Object[]> masPTypeLists= new ArrayList<Object[]>();
	List<Object[]> masPTypeListo = new ArrayList<Object[]>();
	List<Object[]> mainChargeCodeList = new ArrayList<Object[]>();
	List<Object[]> subChargeCodeList = new ArrayList<Object[]>();
	List<Object[]> authorizerList = new ArrayList<Object[]>();
	List<Object[]> bankList = new ArrayList<Object[]>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<Visit> lastVisitDetails = new ArrayList<Visit>();
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	List<MasDiscount> discountList = new ArrayList<MasDiscount>();
	List<Object[]> masCharityList = new ArrayList<Object[]>();
	/* List<PatientBalance> patientBalances = new ArrayList<PatientBalance>(); */
	BlOpBillHeader patientOpBillHeader = new BlOpBillHeader(); // Added by Amit Das on 02-03-2016
	
	String pastDue = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("discountList") != null) {
		discountList = (List<MasDiscount>) map.get("discountList");
	}
	if (map.get("masCharityList") != null) {
		masCharityList = (List<Object[]>) map.get("masCharityList");
	}
	if (map.get("masPTypeListo") != null) {
		masPTypeListo = (List<Object[]>) map.get("masPTypeListo");
	}
	if (map.get("masPTypeList") != null) {
		masPTypeList = (List<Object[]>) map.get("masPTypeList");
	}
	if (map.get("employeeList") != null) {
		employeeList = (List<Object[]>) map.get("employeeList");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
	}
	if (map.get("orderHdList") != null) {
		orderHdList = (List<DgOrderhd>) map.get("orderHdList");
	}
	if (map.get("orderdtList") != null) {
		orderdtList = (List<DgOrderdt>) map.get("orderdtList");
	}
	/* if (map.get("tempBillList") != null) {
		tempBillList = (List<BlTempOpBillHeader>) map.get("tempBillList");
	} */
	if (map.get("mainChargeCodeList") != null) {
		mainChargeCodeList = (List<Object[]>) map.get("mainChargeCodeList");
	}
	if (map.get("subChargeCodeList") != null) {
		subChargeCodeList = (List<Object[]>) map.get("subChargeCodeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<Object[]>) map.get("authorizerList");
	}
	if (map.get("bankList") != null) {
		bankList = (List<Object[]>) map.get("bankList");
	}
	if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	if (map.get("lastVisitDetails") != null) {
		lastVisitDetails = (List<Visit>) map.get("lastVisitDetails");
	}
	if (map.get("templateList") != null) {
		templateList = (List<OpdTemplate>) map.get("templateList");
	}
	/* if (map.get("patientBalances") != null) {
		patientBalances = (List<PatientBalance>) map.get("patientBalances");
	} */
	String registered = "";
	if (map.get("registered") != null) {
		registered = (String) map.get("registered");
	}
	String maxBlNo = "";
	if (map.get("maxBlNo") != null) {
		maxBlNo = (String) map.get("maxBlNo");
	}
	String orderNo = "";
	if (map.get("orderNo") != null) {
		orderNo = (String) map.get("orderNo");
	}
	
	// added by Amit Das on 02-03-2016
	if(map.get("patientOpBillHeader") != null){
			patientOpBillHeader= (BlOpBillHeader)map.get("patientOpBillHeader");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String nabhHospital = "";
	if (session.getAttribute("nabhHospital") != null) {
		nabhHospital = (String) session.getAttribute("nabhHospital");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
/* 	BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader(); */
	float refundAmt = 0;
%>

<div class="titleBg">
<h2>Bill Servicing </h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <label>Bill No.</label> 
<input	type="text" readonly="readonly" value="<%=maxBlNo%>" /> --%>

<%-- <label>Bill Time</label> 
<input	type="text" readonly="readonly" value="<%= time%>" /> --%>
<div class="clear"></div>
<input type="hidden" value=<%=nabhHospital %> name="nabhHospital" id="nabhHospital"/>
<%	int patientTypeId=0;
	String adv = "";
	int hin = 0;
	int hinId =0 ;
	String registrationType = "";
	if (registered.equals("yes")) {
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);

			hin = patient.getId();
			hinId = patient.getId();
			/* if(patient.getRegistrationType()!= null){
				registrationType = patient.getRegistrationType();
			}
			if (patient.getPastDue() != null){
				pastDue = patient.getPastDue();
			}else{
				pastDue="0";
			} */
			//patientTypeId = patient.getPatientType().getId();
%>  <label>HIN No</label> 
<input	type="text" readonly="readonly" value="<%=patient.getHinNo()%>" /> 

<!-- Added By Amit Das -->
<input type="hidden" value="<%=patient.getId()%>" id="inpatientIdForCard" name="inpatientIdForCard"/>

<input type="hidden" value="0" name="refDept" id="refDept"/>
<label>Bill Date</label> 
<input	type="text" readonly="readonly" value="<%= date%>" />
<label>Patient Name</label> 
<%if (patient.getPFirstName() != null) {
 %> 
<input	type="text" readonly="readonly" value="<%=patient.getPFirstName()%>" /> 
<%}%>
<label>Age</label> 
<input	type="text" readonly="readonly" value="<%=patient.getAge()!=null ? patient.getAge():"" %>" /> 
<label>Gender</label>
<input	type="text" readonly="readonly" value="<%=patient.getSex()!=null ? patient.getSex().getAdministrativeSexName():""%>" /> 
<label>Mobile No.</label> 
<input	type="text" readonly="readonly" value="<%=patient.getMobileNumber()!=null ? patient.getMobileNumber():""%>" />

<%
	if (!orderNo.equals("")) {
%>

<div class="clear"></div>
<label>Order No.</label> 
<input	type="text" readonly="readonly" value="<%=orderNo%>" />
<input	type="hidden" name="<%=ORDER_NO %>" value="<%=orderNo %>" /> <%	}
			String doctorName = "";
			int visitNo	 = 0;
			int visitId = 0;
			int tokenNo = 0;
			if (orderHdList.size() > 0) {
				if(orderHdList.get(0).getPrescribedBy()!=null)
				{
				doctorName = orderHdList.get(0).getPrescribedBy().getFirstName();
				if (orderHdList.get(0).getPrescribedBy().getMiddleName() != null) {
					doctorName = doctorName.concat(" ").concat(orderHdList.get(0).getPrescribedBy().getMiddleName());
				}
				if (orderHdList.get(0).getPrescribedBy().getLastName() != null){
					doctorName = doctorName.concat(" ").concat(orderHdList.get(0).getPrescribedBy().getLastName());
				}
				}
				if(orderHdList.get(0).getVisit() != null){
					Visit v = orderHdList.get(0).getVisit();
				//	visitNo = v.getVisitNo();
				visitId = orderHdList.get(0).getVisit().getId();
				//	if(orderHdList.get(0).getVisit().getTokenNo()!=null){
				//tokenNo = orderHdList.get(0).getVisit().getTokenNo();
				//	}
				}
%>

<!-- <label>Visit No.</label>  --><input	type="hidden" readonly="readonly" value="<%=visitNo%>"/>

 <label>Consultant Name</label><input	type="text" readonly="readonly" value="<%=doctorName%>"/>
<input type="hidden" value="<%=orderHdList.get(0).getPrescribedBy()!=null?orderHdList.get(0).getPrescribedBy().getId():""%>" name="<%=EMPLOYEE_ID %>" id="cnsltDocId"/> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%= visitId%>" />
<input type="hidden" name="<%=TOKEN_NO %>" value="<%= tokenNo%>" />
<% } else { %>

<!-- <label><span>*</span> Consultant Name</label> -->
<select	 style='display:none' name="<%=EMPLOYEE_ID %>" id="cnsltDocId" onchange="displayName();showUrgentDetails();"
					validate="Consultant Name,string,no" tabindex=1>
	<option value="0">Select</option>
	<option value="00">Ref. Doctor</option>
	<%
		for (Object[] employee : employeeList) {
			if (employee[0] != null) {
				if (((MasEmpCategory)employee[0]).getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {

					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee[2] != null)
						doctorMiddleName = (String)employee[2];
					if (employee[2] != null)
						doctorLastName = (String)employee[3];	%>
	<option value="<%=employee[4]%>"><%=(String)employee[1]+" " + doctorMiddleName + " "+ doctorLastName%></option>
	<%	}
						}
					}	%>
</select> <%  	} %>




<div id="urgentDetails" style="display: none;" >
<!-- <label> Ref. Doctor</label> -->
<input type="hidden" name="refDoctor1"  id="refDoctor"  />
<input type="hidden" name="consultName"  id="consultId"  />
</div>
 <%
 	if(lastVisitDetails.size() > 0){
 		Visit visit = lastVisitDetails.get(0);
 	 %>
<script type="text/javascript">
document.getElementById('cnsltDocId').value = <%=visit.getDoctor()!=null?visit.getDoctor().getId():""%>

function setValue()
{
	if(document.getElementById('drLal').checked==true)
		 {
			 document.getElementById('drLal').value="y";
				// alert(document.getElementById('drLal').value);
			 }
			 else
			 {
			  document.getElementById('drLal').value="n";
			   // alert(document.getElementById('drLal').value);
			 }
}
</script>

 <%} %>
 <%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %> 
<label>Total Advance</label>
<input type="text"  readonly="readonly" value="<%=adv%>" /> 
  <%
 	}
 %> 
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
<input type="hidden" name="<%=PATIENT_NAME%>"
	value="<%=patient.getPFirstName() %>" />
<input type="hidden" name="<%=AGE%>" value="<%=patient.getAge()!=null ? patient.getAge():""%>" />
<input type="hidden" name="<%=SEX_ID%>"	value="<%=patient.getSex().getId() %>" />
<%if(patient.getNextOfKinName() != null){ %>
	<input	type="hidden" name="<%=RELATIVE_NAME%>"	value="<%=patient.getNextOfKinName() %>" />
<%} %>



	<%	}	} else {
 %> <label><span>*</span> Patient Name</label> 
 <input type="text"	name="<%=PATIENT_NAME%>" value="" validate="Patient Name,string,yes" maxlength="40" tabindex=1 />
 <label> <span>*</span> Age</label> <input type="text" name="<%=AGE%>" value="" validate="Age,string,yes"
	maxlength="3" tabindex=1 /> 
<label><span>*</span> Sex</label> <select name="<%=SEX_ID %>" validate="Sex,string,yes">
	<option value="0">Select</option>
	<%
		for (MasAdministrativeSex sexObj : sexList) {
	%>
	<option value="<%=sexObj.getId() %>"><%=sexObj.getAdministrativeSexName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<label>Mobile No.</label>
<input type="text" name="<%=MOBILE_NO %>" id="<%=MOBILE_NO %>" value=""  maxlength="12" tabindex=1/>
<label><span>*</span> Consultant Name11</label>
<select	name="<%=EMPLOYEE_ID %>" id="cnsltDocId" validate="Consultant Name,string,yes" tabindex=1
	onchange="displayName();showUrgentDetails();">
	<option value="0">Select</option>
	<option value="00">Ref. Doctor</option>
	<%	for (Object[] employee : employeeList) {
			if (employee[0] != null) {
				if (((MasEmpCategory)employee[0]).getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {
					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee[2] != null)
						doctorMiddleName = (String)employee[2];
					if (employee[3] != null)
						doctorLastName = (String)employee[3];	%>
	<option value="<%=employee[4]%>"><%=(String)employee[1]+" " + doctorMiddleName + " "+ doctorLastName%></option>
	<%
		}	}	}%>
</select> <%
 	}
 %> 
 <%---
 <label>Dr.Lal Lab</label> --%>
<input id="checkId" name="<%=COLLECTED%>"	type="hidden"  class="radioCheck" value="n"
			  onclick="numberForCheckBoxClicked();" />
<input type="hidden" id="cnsltDocTextId" name="<%=CONSULTING_DOCTOR%>" value="" /> 
 <script type="text/javascript">
	(document.getElementById("cnsltDocId").focus());
	</script>
<div id="urgentDetails" style="display: none;" >
<label> Ref. Doctor</label>
<input type="text" name="refDoctor1"  id="refDoctor" />
</div>
<div class="clear"></div>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>


<div class="clear"></div>
<div id="testDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Service Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
<!-- 		<th scope="col" style="display:none;">Std. Deduction</th>
 -->		<!-- <th scope="col">Amount</th> -->
		
	</tr>

<%
	int inc = 0;
	BigDecimal billAmt = new BigDecimal(0.00);
    Date currentDate = new Date();
		BigDecimal totalBillAmt = new BigDecimal("0");
		BigDecimal totalNetAmt = new BigDecimal("0");
		BigDecimal charge = new BigDecimal("0");
		int orderHdId = 0;
		
		
		if (orderdtList.size() > 0) {
			for (int i = 0; i < orderdtList.size(); i++) {
				inc++;
				DgOrderdt orderDt = new DgOrderdt();
				orderDt = orderdtList.get(i);
				
				if (orderDt.getBillingStatus().equals("n")) {
					orderHdId = orderDt.getOrderhd().getId();
								
					
	%>
	<tr>
<td><input type="hidden" name="<%=ORDER_BOOKING_ID %>" value="<%=orderHdId %>" />

<input type="hidden" name="<%=DG_ORDER_DETAIL_ID %><%=inc %>" value="<%=orderDt.getId() %>" />
		<input type="hidden" name="" value="<%=orderDt.getId() %>" />
		
		
		
		
		
		<input type="checkbox"	id ='selectedCharge<%=inc%>' value="<%=inc%>" name="selectedCharge<%=inc%>" class="radioCheckCol2" onclick = "calculateTotalChargeAmount(<%=inc%>);"/></td>

		<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>"
			value="<%=orderDt.getChargeCode().getChargeCodeName() %>[<%=orderDt.getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge<%=inc %>='+encodeURIComponent(this.value)+'&rowVal=<%=inc%>&hin=<%=hin%>&type=op&schemeList='+document.getElementById('schemeList').value,'rateVal<%=inc %>');}"
			readonly="readonly" tabindex="1" />

		
		<input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getId()%>" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"name="<%=QUANTITY %><%=inc%>"
			 value="<%=orderDt.getOrderQty()!=null?orderDt.getOrderQty():1%>" validate="Qty,int,no" maxlength="5" readonly="readonly"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmt();};"/></td>
			

			  
		<td  id="rateVal<%=inc %>">
		<input type="text" size="12" value="<%=orderDt.getChargeCode().getCharge() %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
		 validate="Rate,float,no" readonly="readonly" /></td>

		

	
<%-- 	 <td><input type="text" value="<%=billAmt%>"	id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>  --%>
		<td style="display:none;">
		<%if(orderDt.getMainChargecode().getId() ==27 ){ %>
		<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" />
			<%}else{ %>
			<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" disabled="disabled"/>
			<%} %>
			<input type="hidden" value="n" id="lalPathText<%=inc%>"	name="lalPathText<%=inc%>"
			readonly="readonly" size="10"  />
		 <input type="hidden" value="" name="companyId2<%=inc%>" id="companyId2<%=inc%>" />
		  <input type="hidden" value="" name="billTypeId<%=inc%>" id="billTypeId<%=inc%>" />
			
			<input type="hidden" value="" name="patientCategory<%=inc%>" id="patientCategory<%=inc%>" />
		</td>
	

		<%
		if(orderDt.getChargeCode().getMainChargecode().getDepartment() != null){
	%>
		<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
		<input type="hidden" name="<%=DEPARTMENT_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getDepartment().getId()%>" />

		<%}
	%>
		
	
		<%
			if(orderDt.getChargeCode().equals("y") ){
		%>
		<script type="text/javascript">
				document.getElementById('rate<%=inc%>').readOnly = false;
			</script>
		<%}else{ %>
		<script type="text/javascript">
				document.getElementById('rate<%=inc%>').readOnly = true;
			</script>
		<%} %>
	</tr>

	<%
				/* 	BigDecimal chargeAmt = new BigDecimal(orderDt.getOrderQty()).multiply(charge);
					//BigDecimal netAmt = new BigDecimal(orderDt.getOrderQty()).multiply(charge);
					totalBillAmt = totalBillAmt.add(chargeAmt);
					totalNetAmt = totalNetAmt.add(billAmt); */
			
		}
	}
		}
	
	%>
</table>
</div>

<input type="hidden" value="<%=inc %>" name="hiddenValueCharge" id="hiddenValueCharge" />
<!--table ends--> 

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="Block">
<%BigDecimal payableAmt = new BigDecimal(0);%>
	
 <label>Total Bill Amount</label> 

 <input type="text" id="totalAmtId" name="totalAmtId" value=""   /> 
 <label>Round Off</label> 
	
	<input type="text" id="roundId" name="roundId"
	value="" readonly="readonly"  />
	
<label>Remarks</label>
	<textarea  name=<%=REMARKS %> id='' value="" rows="2"  cols="4"
	validate="Remarks,String,no" >  </textarea>


<div class="clear"></div>
</div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paymentDiv" id="paymentDiv">
<h4>Payment Details</h4>
<div class="clear"></div>

<div class="clear"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr>
		<th scope="col"></th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Amount</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>		
	</tr>
	<%
		int i = 1;
	%>
	<tr>
		<td><input type="radio" value="<%=inc%>" name="selectedPayMode" id="selectedPayMode"
			class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %><%=i%>"
			id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);">
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i%>" 
			id="amt<%=i %>" value=" <%=payableAmt %> " validate="Amount,string,no" 
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>));"/>
			<input type="hidden" name="amtHidden<%=i%>"
			id="amtHidden<%=i %>" value="<%=payableAmt %>"/>
			</td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i%>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i%>"
			id="chqDate<%=i %>" readonly="readonly"
			onblur="validateChequeAndCreditCardDate();" /> <img
			id="calId<%=i %>" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" style="display: none;" validate="Pick a date"
			class="calender"
			onclick="setdate('<%=date %>',document.getElementById('chqDate<%=i %>'),event);" />
		</td>
		<td><select name="<%=BANK_NAME %><%=i%>" id="bankId<%=i %>"
			disabled="disabled">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (Object[] bankMaster : bankList) {
			%>
			<option value="<%=bankMaster[1] %>"><%=bankMaster[0]%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster[1]%>";
			bankArray[<%=j%>][1] = "<%=bankMaster[0]%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>

		

	</tr>
</table>

<input type="hidden" value="<%=registrationType %>"
	name="registrationType" /> <input type="hidden" value="1"
	name="hiddenValuePayment" id="hiddenValuePayment" />

	
	<script
	type="text/javascript">
  function showDifference1()
 {
 	var a=document.getElementById('actualColAmtId').value;
  	var a1=document.getElementById('payableAmtId').value;
  	if(a !=""){
  		if(parseFloat(a) < parseFloat(a1)){
  	  			alert("Collected Amount should not be less than Payable Amount.");
  			//getShadow("actualColAmtId");
  		document.getElementById('actualColAmtId').value = "";
  			return false;
  	}}
		/* document.getElementById('balToBeRId').value=parseFloat(a)-parseFloat(a1);
 	}else{
 		document.getElementById('balToBeRId').value = "";
 	} */
 	return true;
 } 


 </script>
<div class="clear"></div></div>

<table id="batchDetails" style="display: block;">
</table>

<input type="hidden" id="totalBatchId" name="batchNoCounter" value="0" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" tabindex="1" class="button" name="Submit11" value="Submit"	onclick="if(validateCollected()){if(validateFieldsOnSubmit()){if(checkCollectedAmt()){submitForm('billServicing','billing?method=submitBillServicingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}}"
	align="right" /> 
	
	
	<%-- <%
 if(registered.equals("yes") && tempBillList.size() == 0){
%> <input type="button" tabindex="1" class="buttonBig" name="Submit12"
	value="Temporary Bill"
	onclick="if(checkFilledRow()){if(validateFieldsOnSubmit()){submitForm('billServicing','opBilling?method=submitTemporaryBillServicingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}"
	align="right" /> <%} %>  --%>
<input type="button" class="button" value="Back" onclick="submitFormCancel('billServicing','billing?method=showPendingBillServicingJsp')" />
<input type="button" value="Reset"	onclick="form.reset();resetAjaxValueForBilling();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<script type="text/javascript">

document.getElementById("wAmtId").disabled = true;
document.getElementById("wAmtId").style.display = 'none';
document.getElementById("ostAmtId").disabled = true;
document.getElementById("ostAmtId").style.display = 'none';


function validateRateValue(val,count,rate){
	if(val != ""){
		if(!validateFloat(val)){
			if(!displayAlert("Rate should be integer or decimal value"))
				alert("Rate should be integer or decimal value");

			if(document.getElementById('resrate'+count)){
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
		}
	}else{
		if(!displayAlert("Rate can not be blank"))
			alert("Rate can not be blank");
			if(document.getElementById('resrate'+count)){
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
	}
	return true;
}







function displayName(){
	var w = document.getElementById('cnsltDocId').selectedIndex;
	var selectedText = document.getElementById('cnsltDocId').options[w].text;
	document.getElementById('cnsltDocTextId').value = selectedText;
}

function openPopupForItem(val,rowVal){

var code = "";
	if(val != ""){
		var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var code = val.substring(index1,index2);
		if(code !=""){
			window.open('opBilling?method=showItemBatchNoPopUpForConsumption&chargeCode='+encodeURIComponent(code)+'&rowVal='+rowVal+'&hinId='+<%=hinId%>+'&patientTypeId=<%=patientTypeId%>&deptCode=PHAR','mywindow','target="_blank", width=780,height=300');

		}
	}
}

function numberForCheckBoxClicked()
{
	var obj1= document.getElementById('mainChargeCodeId');

	if(document.getElementById('checkId').checked==true)
			 {
		         obj1.options[9].selected="selected"
				 document.getElementById('checkId').value="y";

				 }
				 else
				 {

				  document.getElementById('checkId').value="n";
				  obj1.options[0].selected="selected"

				 }

}

function getChangeCheckBox()
{

	var mainCgargeId=document.getElementById('mainChargeCodeId').value;
	if(mainCgargeId==1)
	{
	document.getElementById('checkId').checked=true;
	document.getElementById('checkId').value="y";
	}
	else
	{
		document.getElementById('checkId').checked=false;
		document.getElementById('checkId').value="n";
	}
	}

function showUrgentDetails()
{

	var cnsltDocId=document.getElementById('cnsltDocId').value;

if(cnsltDocId=="00")
{

document.getElementById('urgentDetails').style.display = 'inline';
document.getElementById('refDoctor').value="";
}
else
{
	document.getElementById('refDoctor').value="";
document.getElementById('urgentDetails').style.display = 'none';
}
}
	function assignYesNoLalPath(rowval){
	if(document.getElementById('lalPathId'+rowval).checked == true){
		document.getElementById('lalPathText'+rowval).value='y'
		document.getElementById('companyId2'+rowval).value='35';
		document.getElementById('billTypeId'+rowval).value='2'
		document.getElementById('patientCategory'+rowval).value='OP';
		
	ajaxFunctionForRate('billServicing','/hms/hms/opBilling?method=fillRateAfterDiscount&chargeId='+document.getElementById("chargeId"+rowval).value+'&mainChargeId='+document.getElementById("mainChargeCodeId"+rowval).value+'&subChargeId='+document.getElementById("subChargeCodeId"+rowval).value+'&lalPathText='+document.getElementById("lalPathText"+rowval).value+'&patientTypeId2='+document.getElementById("patientTypeId2").value+'&companyId2='+document.getElementById("companyId2"+rowval).value+'&companyId='+document.getElementById("companyId").value+'&billTypeId='+document.getElementById("billTypeId"+rowval).value+'&patientCategory='+document.getElementById("patientCategory"+rowval).value+'&rowval='+rowval,rowval);
	}else{
		document.getElementById('lalPathText'+rowval).value='n'
		submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+rowval+'='+document.getElementById("chargeCode"+rowval).value+'&rowVal='+(rowval)+'&hin=<%=hin%>&type=op','rateVal');
		
	}
	}

	function orderassignYesNoLalPath(rowval){
	if(document.getElementById('lalPathId'+rowval).checked == true){
	document.getElementById('lalPathText'+rowval).value='y'
	document.getElementById('companyId2'+rowval).value='35';
	document.getElementById('billTypeId'+rowval).value='2'
	document.getElementById('patientCategory'+rowval).value='OP';
	
	ajaxFunctionForOrderRate('billServicing','/hms/hms/opBilling?method=fillOrderRateAfterDiscount&chargeId='+document.getElementById("chargeId"+rowval).value+'&ordermainChargeId='+document.getElementById("ordermainChargeCodeId"+rowval).value+'&ordersubChargeId='+document.getElementById("ordersubChargeCodeId"+rowval).value+'&lalPathText='+document.getElementById("lalPathText"+rowval).value+'&patientTypeId2='+document.getElementById("patientTypeId2").value+'&companyId2='+document.getElementById("companyId2"+rowval).value+'&companyId='+document.getElementById("companyId").value+'&billTypeId='+document.getElementById("billTypeId"+rowval).value+'&patientCategory='+document.getElementById("patientCategory"+rowval).value+'&rowval='+rowval,rowval);
	}else{
	
	document.getElementById('lalPathText'+rowval).value='n'
	submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/billing?method=fillChargeCode&charge'+rowval+'='+document.getElementById("chargeCode"+rowval).value+'&rowVal='+(rowval)+'&hin=<%=hin%>&type=op','rateVal'+(rowval));
		}
		}
	
	
	function updateDiscountByScheme()
	{
		for(var i=1; i<=document.getElementById('hiddenValueCharge').value; i++)
		{
			if(document.getElementById('amount'+i) != null)
			{
				document.getElementById("chargeCode"+i).onblur();
			}
		}
	}
	
	
	function  onChangeScheme()
	{
		updateDiscountByScheme();
	}
	
	updateDiscountByScheme();
	
	/* alert(document.getElementById('resrate1'));
	document.getElementById('resrate1').onblur(); */
	
	// Added by Amit Das on 02-03-2016
	var schemeId_op = "";
	var schemeName_op = "";
	schemeId_op = document.getElementById("schemeId_op").value;
	schemeName_op = document.getElementById("schemeName_op").value;
	
	submitProtoAjaxWithDivName('billServicing','/hms/hms/billingMaster?method=listScheme&type=op&schemeId='+schemeId_op+'&schemeName='+schemeName_op,'schemeDiv');
	
	var container12 = document.getElementById ("schemeDiv");
     if (container12.addEventListener) {
    	 container12.addEventListener ('DOMSubtreeModified', updateDiscountByScheme, false);
     }
     
	/* document.getElementById('schemeDiv').bind("DOMSubtreeModified",function(){
		  alert('changed');
		});
	
	document.getElementById('schemeDiv').bind("append", function() { alert("its come"); updateDiscountByScheme(); });
	 */
	function diplayPayment(obj)
	{
		if(obj == "P"){
			var payableAmt=document.getElementById("totalAmtId").value;
			document.getElementById("totalPayId").value=payableAmt;
			document.getElementById("paymentDiv").disabled = false;
			document.getElementById("paymentDiv").style.display = 'block';
			document.getElementById("wAmtId").disabled = true;
			document.getElementById("wAmtId").style.display = 'none';
			document.getElementById("ostAmtId").disabled = true;
			document.getElementById("ostAmtId").style.display = 'none';
			document.getElementById("advAdjCheckId").disabled = false;
			document.getElementById("advAdjCheckId").style.display = 'block';
			document.getElementById("authorizeDiv").style.display = 'none'; <!-- edited authorizer by Amit Das on 15-02-2016 -->
			
		}
		else if(obj == "W"){
            var payableAmt=document.getElementById("totalPayId").value;
			document.getElementById("paymentDiv").disabled = true;
			document.getElementById("paymentDiv").style.display = 'none';
			document.getElementById("wAmtId").disabled = false;
			document.getElementById("wAmtId").style.display = 'block';
			document.getElementById("ostAmtId").disabled = true;
			document.getElementById("ostAmtId").style.display = 'none';
			document.getElementById("advAdjCheckId").disabled = true;
			document.getElementById("advAdjCheckId").style.display = 'none';
			document.getElementById("waiveAmtId").value=payableAmt;
			document.getElementById("authorizeDiv").style.display = 'block'; <!-- added authorizer by Amit Das on 15-02-2016 -->
		}
		else if(obj == "PL"){
			var payableAmt=document.getElementById("totalPayId").value;
			document.getElementById("paymentDiv").disabled = true;
			document.getElementById("paymentDiv").style.display = 'none';
			document.getElementById("wAmtId").disabled = true;
			document.getElementById("wAmtId").style.display = 'none';
			document.getElementById("ostAmtId").disabled = false;
			document.getElementById("ostAmtId").style.display = 'block';
			document.getElementById("advAdjCheckId").disabled = true;
			document.getElementById("advAdjCheckId").style.display = 'none';
			document.getElementById("outstadAmtId").value=payableAmt;
			document.getElementById("authorizeDiv").style.display = 'block'; <!-- added authorizer by Amit Das on 15-02-2016 -->
		}
	}
      function calcluateAmt(value)
      {
    	  var billAmt=document.getElementById("totalAmtId").value;
    	 var waveAmt=document.getElementById("waiveAmtId").value;
    	  var payAmt=document.getElementById("totalPayId").value;
   
    		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(waveAmt);    		
      }
      function calcluateOstAmt(value)
      {
    	  var billAmt=document.getElementById("totalAmtId").value;
    	 var osAmt=document.getElementById("outstadAmtId").value;
    	  var payAmt=document.getElementById("totalPayId").value;
    
    		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(osAmt);    		}
      
      
      
   
      function calculateTotalChargeAmount(counter){
    	  
    	var TotalAmount = document.getElementById("totalAmtId").value;
    	var roundof=document.getElementById("roundId").value;
  
    	TotalAmount = TotalAmount * 1;
    
    	  if(document.getElementById('selectedCharge'+counter).checked == true || document.getElementById('selectedCharge'+counter).checked == "true")
    		  {
    		  	var Rate = document.getElementById("rate"+counter).value;
    		
    		  	Rate = Rate * 1
    		  	TotalAmount = TotalAmount + Rate;
    		  	document.getElementById("totalAmtId").value=TotalAmount;    		 
    		  	document.getElementById("roundId").value=Math.round(TotalAmount,2).toString();
    			document.getElementById("amt1").value=Math.round(TotalAmount,2).toString();
    		 
    		  	
    		  }
    	  else
    		  {
    			    var Rate = document.getElementById("rate"+counter).value;
  		  			Rate = Rate * 1
  		  	        TotalAmount = TotalAmount - Rate;
  		  	        document.getElementById("totalAmtId").value=TotalAmount;
  		  	   		document.getElementById("roundId").value=Math.round(TotalAmount,2).toString();
  		  	   	    document.getElementById("amt1").value=Math.round(TotalAmount,2).toString();
  		  	  	 
  		  	   		
    		  }
    	  
    	  
      }
      
      function checkAmountToPay(counter)
      {
      if (document.getElementById("roundId").value != document.getElementById("amt1").value )
      {
      alert("Please enter same amount as total amount")
      return false;
      }
      else
      {
      return true;
      }



      }
      
      
      
      
      
      
      
      function validateCollected(){
    	  
    	  var msg="";
    		flag = true;
    			counter = document.getElementById('hiddenValueCharge').value;
    			
    			for(var i = 1; i <= counter; i++){
    				
    				if((document.getElementById('selectedCharge'+i).checked))
    	            { 
    	            	flag = false;
    	            	break;
    	     		}
    			
    	  		}
    			
    	  		if(flag == false)
    	  		{	
    				return true;
    			}
    			else{
    				alert("Please  select on investigation....");
    				return false;
    			}
    					
    	  		 if(msg != ""){
    				 	alert(msg);
    				 	return false;
    			}
    			return true;
    			
    	  		
    	  	}
      
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
