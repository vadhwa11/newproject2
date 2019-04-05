<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import = "static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MdMasAuthority"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MdCardicClaimAdvance"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>


<form name="cardicContingentBill" method="post" action="">
<script type="text/javascript" >
		history.forward();
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
	var selectedTestType="MEDCLAIMS";
                 function checkedfunctions(){
                           if(document.getElementById('testType1').checked){
                            selectedTestType = document.getElementById('testType1').value;
                           }else{
                             selectedTestType = document.getElementById('testType2').value;
                           }
                              alert("selectedTestType::"+selectedTestType);
                             
                          }
</script>

<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MdCardicClaimAdvance> cardcAdvanceList = new ArrayList<MdCardicClaimAdvance>();
	MdCardicClaimAdvance cardicClaimAdvance= new MdCardicClaimAdvance();
	List <MdMasAuthority> authorityList=new ArrayList<MdMasAuthority>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int specialhdId=0;
	int hinId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("cardcAdvanceList") != null){
			cardcAdvanceList=(List)map.get("cardcAdvanceList");
		}
		if(map.get("authorityList") != null){
			authorityList=(List)map.get("authorityList");
		}
		if(cardcAdvanceList != null) {
			cardicClaimAdvance = (MdCardicClaimAdvance) cardcAdvanceList.get(0);
				hinId =cardicClaimAdvance.getHin().getId();
		}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		if(map.get("hospitalList") != null){
			hospitalList= (List)map.get("hospitalList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("chargeList") != null){
			chargeList=(List)map.get("chargeList");
		}
		if(map.get("specialhdId") != null){
			specialhdId=(Integer)map.get("specialhdId");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		%>
<div class="titlebg">
<h2>Cardiac claim - Contingent Bill for Reimbursement</h2>
</div>

<div class="Block">
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%>	

			<label>Entry No</label>
			<input id="orderNoId" type=hidden name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry No"  />
		
			<label class="value"><%=entrySeqNo %></label>
			<input type="hidden" id="specialhdId" name="specialhdId" value="<%= specialhdId%>"  />
			
			<label> Entry Date <span>*</span></label>
			<input type="text" class="calDate" id="fromDateId" name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly" validate="Entry Date,date,yes" MAXLENGTH="30" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.contingentBill.<%=ENTRY_DATE%>,event)"/>
			
		<div class="Clear"></div>
		
			<label>Service No.</label> 
			<label class="value"><%=cardicClaimAdvance.getHin().getServiceNo()%></label>

			<label>Name</label>
			<label class="value"><%=cardicClaimAdvance.getHin().getSFirstName()+" "+cardicClaimAdvance.getHin().getSMiddleName()+" "+cardicClaimAdvance.getHin().getSLastName() %></label>
			
			<label>Rank </label>
			<%if(cardicClaimAdvance.getHin().getRank() !=null){ %>
			<label class="value"><%=cardicClaimAdvance.getHin().getRank().getRankName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			<div class="Clear"></div>
			
			<label>Branch/Trade </label>
			<%if(cardicClaimAdvance.getHin().getTrade() !=null){ %>
			<label class="value"><%=cardicClaimAdvance.getHin().getTrade().getTradeName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
			<label>Unit </label>
			<%if(cardicClaimAdvance.getHin().getUnit() !=null){ %>
			<label class="value"><%=cardicClaimAdvance.getHin().getUnit().getUnitName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
			<label>Unit Address </label>
			<%if(cardicClaimAdvance.getHin().getUnit() !=null){ %>
			<label class="value"><%=cardicClaimAdvance.getHin().getUnit().getUnitAddress()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			<div class="Clear"></div>
	<%
			int inpatientId =0;
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = cardicClaimAdvance.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				}
%>
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>"/>
<input type="hidden" name="<%=DEPARTMENT_ID %>"  value="<%=inpatient.getDepartment().getId() %>" />


	<%}%>
	<input type="hidden" name="<%=CARDIC_CLAIM_ID %>" value="<%=cardicClaimAdvance.getId() %>"/>
	<input type="hidden" name="<%=HIN_ID %>" value="<%=cardicClaimAdvance.getHin().getId() %>"/>

				
<h4>Bill Details</h4>
		 		
	<label>Select Test Type</label>
	<label class="auto">ALL Test</label>
	<input type="radio" name="testType" id="testType1" value="ALL" onclick="checkedfunctions();" class="radioAuto"/>
	
	<label class="auto">MedicalClaims Specific Test </label>
	<input type="radio" name="testType" id="testType2"  value="MEDCLAIMS" checked="checked"  class="radioAuto" onclick="checkedfunctions();" />
				<div class="Clear"></div>


<table class="cmntable" id="chargeDetails">
<thead>
<tr> 
		<th></th>
		<th>Details</th>
		<th>Bill No<span>*</span></th>
		<th>Bill Date</th>
		<th>Amount</th>
		<th>Add</th>
		<th>Delete</th>
</tr>
</thead>
<tbody>

	<%
		int inc = 1;
	%>

<tr> 
<td>	 <input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioAuto" /></td>
 <td>
 <%if(cardicClaimAdvance.getTreatmentDetail()!=null){  System.out.println(cardicClaimAdvance.getTreatmentDetail());%>
  <input type="text" name="<%=DETAILS%>" value="<%=cardicClaimAdvance.getTreatmentDetail().getChargeCodeName() %>" id="<%=DETAILS%><%=inc %>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" maxlength="30" size="30"/></td>
  <input type="hidden" value="<%=cardicClaimAdvance.getTreatmentDetail().getId()%>" name="chargeCodeId" id="chargeCodeId<%=inc %>"  />
  <div id="ac2update" style=""></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
			    new Ajax.Autocompleter(document.getElementById('<%=DETAILS%><%=inc %>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS%>',callback:eventCallback});
			 
    </script>
  <%}else{ %>
  <input type="text" value="" name="<%=DETAILS%>" id="<%=DETAILS%><%=inc %>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" maxlength="30" size="30"/></td>
  <input type="hidden" value="" name="chargeCodeId" id="chargeCodeId<%=inc %>" />
  <div id="ac2update" style=""></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
			    new Ajax.Autocompleter(document.getElementById('<%=DETAILS%><%=inc %>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS%>',callback:eventCallback});
			 
    </script>
  <%} %>
  <input type="hidden" value="<%=inc%>" name="selectedChrage1" class="radioCheck" />
  
<td>
  <input type="text" value="" name="<%=BILL_NO%>" id="billNoId<%=inc %>" maxlength="15"/></td>
<td>
<input type="text" class="calDate" id="billDateId<%=inc%>" name="<%=BILL_DATE %>" value="" readonly="readonly" MAXLENGTH="30" />
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('billDateId<%=inc%>'),event)"/></td>
<td>
  <input type="text" value="" name="<%=AMOUNT%>" id="amount<%=inc %>" maxlength="8" onblur="validateAmount(this.value,<%=inc %>);totalAmount();"/></td>



<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1"/></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" /></td>
</tr>

</tbody>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge" id="hiddenValueCharge" />
</div>
<div class="cmntable">

<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
<tr>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom">Total Rs</th>
<th class="bottom"><input type="text" value="" name="<%=TOTAL_RS%>" id="totalRsId" readonly="readonly"/></th>
</tr>


</table>

</div>

<div class="division"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div class="Block">
<div class="Clear"></div>

<label class="large"> Amount qualifying for Reimbursement Rs.<span>*</span> </label>
<input id="qualifyingRs" name="<%=QUALIFYING_RS %>" type="text" value="" onblur="AmountToReceived();" on validate="Amount qualifying for,float,yes" maxlength="8"/>
<div class="Clear"></div>



<label class="large"> Amount Payable to <span>*</span></label>
<%if(cardicClaimAdvance.getPayableTo()!=null) {%>
<input id="advanceAmount" name="<%=PAYABLE_TO %>" type="text" value="<%=cardicClaimAdvance.getPayableTo().getReferenceName() %>" validate="Amount Payable to,string,yes" maxlength="50"/>
<%}else if(cardicClaimAdvance.getPayableToName()!=null) {%>
<input id="advanceAmount" name="<%=PAYABLE_TO %>" type="text" value="<%=cardicClaimAdvance.getPayableToName() %>" validate="Amount Payable to,string,yes" maxlength="50"/>
<%}else{ %>
<input id="advanceAmount" name="<%=PAYABLE_TO %>" type="text" value="" validate="Amount Payable to,string,yes" maxlength="50"/>
<%} %>
<div class="Clear"></div>

<label class="large">CGHS rates in <span>*</span></label>
<select name="<%=CGHS_RATE%>" validate="CGHS rates in,string,yes">
<option value="General-Ward">General-Ward</option>
<option value="private">Private Ward</option>
<option value="Semi-private Ward">Semi-private Ward</option>

</select>

<label class=""> is <span>*</span></label>
<input id="is1" name="<%=IS2 %>" type="text" value="" validate="is,float,yes" maxlength="8"/>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>

<label> Received (Rs.)<span>*</span></label>
<input id="is2" name="<%=RECEIVED_RS %>" type="text" value="" validate="Received (Rs.),float,yes" maxlength="8"/>
 <div class="Clear"></div>
 
 
 
 </div>


<div class="Clear paddingTop15"></div>
<!--Bottom labels starts-->

<div class="division"></div>
<input type="button" class="button" value="Submit"  onclick= "if(checkFilledRow()){submitForm('cardicContingentBill','mediClaim?method=submitCardicReimbursement');}" align="right" />
<input type="reset" class="button" name ="Reset" id="reset" value ="Reset" onclick="resetClicked('cardicContingentBill');" accesskey="r" />

<div class="Clear paddingTop15"></div>
<div class="bottom">
	<label>Changed By</label>
	<label class="value"><%=userName%></label>
	
	<label>Changed Date</label>
	<label class="value"><%=currentDate%></label>
	
	<label>Changed Time</label>
	<label class="value"><%=time%></label>

<div class="Clear"></div>
</div>

		</form>
<script type="text/javascript">
function AmountToReceived(){
var var1= document.getElementById('is2');
var1.value=document.getElementById('qualifyingRs').value ;

}
	function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size="30"
	e1.name='<%=DETAILS%>';
	e1.id='<%=DETAILS%>'+ (iteration);
	e1.value="";
	e1.onblur=function(){
				if(fillSrNo){fillChargeId(this.value,iteration);}
			  };
	e1.maxLength="30";
	cell1.appendChild(e1);
	
	var e7 = document.createElement('input');
	e7.type='hidden';
	e7.name='selectedChrage1';
	e7.value=(iteration);
	cell1.appendChild(e7);
	
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
	cell1.appendChild(newdiv);
	
	new Ajax.Autocompleter('<%=DETAILS%>'+ (iteration),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS%>',callback:eventCallback});
	
	
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='chargeCodeId';
	  e2.id='chargeCodeId'+iteration
	  e2.size = '10'
	  e2.maxlength="5"
	  cell1.appendChild(e2);
	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name = '<%=BILL_NO%>';
	e2.id = '<%=BILL_NO%>' + (iteration);
	e2.tabIndex="1";
	e2.maxlength="15"
   	cell2.appendChild(e2);
	
	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = '<%=BILL_DATE%>';
	e3.id = '<%=BILL_DATE%>' + (iteration);
	e3.tabIndex="1";
	e3.maxlength="10"
   	cell3.appendChild(e3);
   	
   var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.class = 'calender';
	  eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(event){
			setdate('',document.getElementById('<%=BILL_DATE%>'+iteration),event) };
	  cell3.appendChild(eImg);
 
   	
   	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name = '<%=AMOUNT%>';
	e4.id = '<%=AMOUNT%>' + (iteration);
	 e4.onblur= function(){
					totalAmount();}
	e4.tabIndex="1";
	e4.maxLength="8";
   	cell4.appendChild(e4);
}
function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
     var err = "";
		if (document.getElementsByName('selectedChrage')[counter].checked == true) 
		{
		  	tbl.deleteRow(counter+1);
		  	totalCost();
		}else{
			err += "Please select atleast one row for delete";
		
		}
	}
	
	if(err != ""){
		alert(err);
		return false;
	}
}
function fillSrNo(rowVal){

	if(document.getElementById('<%=DETAILS%>'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('<%=DETAILS%>'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function fillChargeId(val,inc){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			if(chargeId=='')
			{
			alert("Test Name is Incorrect");
			document.getElementById('<%=DETAILS%>'+ inc).value=""
			var e=eval(document.getElementById('<%=DETAILS%>'+inc)); 
			e.focus();
			return false;
			}
			var indexForChargeName = indexForChargeName--;
			var ChargeName = val.substring(0,indexForChargeName);
		document.getElementById('chargeCodeId'+inc).value = chargeId;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('<%=DETAILS%>'+i).value==val)
		{
			alert("Charge Name already selected...!")
			document.getElementById('<%=DETAILS%>'+inc).value=""
			var e=eval(document.getElementById('<%=DETAILS%>'+inc)); 
			e.focus();
			return false;
		} }  }
			
}
}

function validateAmount(val, inc){
	if(val != ""){
		if(!validateFloat(val)){
			alert("Please enter valid Amount.");
			document.getElementById('amount'+inc).value="";
			return false;
		}
	}
	return true;
}
function totalAmount(){
	var amt = 0;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<=count; i++){
		var totalAmt = eval(document.getElementById("amount"+i));
		if(validateFloat(totalAmt.value)){
			if(amt != 0 && totalAmt.value != ""){
				amt = parseInt(amt)+parseInt(totalAmt.value);
			}else if(amt == 0 && totalAmt.value != ""){
				amt = parseInt(totalAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amount"+i).value = "";
			return false;
		}
	}
	document.getElementById('totalRsId').value = amt;
}
function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('billNoId'+i) != null){
	  	 		if(document.getElementById('billNoId'+i).value != ""){
		  			if(document.getElementById('amount'+i).value == ""){
		  				msg += "Amount can not be blank.\n";
		  			}
		  			if(msg != ""){
		  				break;
		  			}
	  			}
	  			else{
	  				alert("Please fill atleast one Bill No to submit.");
	  				return false;
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
</script>