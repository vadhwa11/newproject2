<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MdCardicContingentBillHd"%>
<%@page import="jkt.hms.masters.business.MdCardicContingentBillDt"%>
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
	List<MdCardicContingentBillHd> cardicContingentBillList = new ArrayList<MdCardicContingentBillHd>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
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
		List<MdCardicContingentBillDt>contingentdetailList=new ArrayList<MdCardicContingentBillDt>();
		if(map.get("contingentdetailList")!=null){
			contingentdetailList=(List<MdCardicContingentBillDt>)	map.get("contingentdetailList");
		}
		if(map.get("cardicContingentBillList") != null){
			cardicContingentBillList= (List<MdCardicContingentBillHd>)map.get("cardicContingentBillList");
		}
		MdCardicContingentBillHd cardicContingentBillHd = new MdCardicContingentBillHd();
		if(cardicContingentBillList != null && cardicContingentBillList.size()>0){
			cardicContingentBillHd = cardicContingentBillList.get(0);	
		}
		if(cardicContingentBillHd.getHin()!=null){
			hinId = cardicContingentBillHd.getHin().getId();			
		}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
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
<div id="contentHolder">
<h6>Update Cardiac claim - Contingent Bill for Reimbursement</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv">
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%>	

			<label>Entry No</label>
			<input id="orderNoId" type=hidden name="<%=ENTRY_NO %>" value="<%=cardicContingentBillHd.getEntryNo()%>" title="Entry No"  />
		
			<label class="value"><%=cardicContingentBillHd.getEntryNo() %></label>
			<input type="hidden" id="contingentHdID" name="contingentHdID" value="<%= cardicContingentBillHd.getId()%>"  />
			
			<label> Entry Date</label>
			<%if(cardicContingentBillHd.getEntryDate() != null) {%>
			<label><%= HMSUtil.convertDateToStringWithoutTime(cardicContingentBillHd.getEntryDate()) %></label>
			<%}else{ %>
			<label><%=currentDate %></label>
			<%} %>
		<div class="Clear"></div>
		
			<label>Service No.</label> 
			<label class="value"><%=cardicContingentBillHd.getHin().getServiceNo()%></label>

			<label>Name</label>
			<label class="value"><%=cardicContingentBillHd.getHin().getSFirstName()+" "+cardicContingentBillHd.getHin().getSMiddleName()+" "+cardicContingentBillHd.getHin().getSLastName() %></label>
			
		
			
			<label>Rank </label>
			<%if(cardicContingentBillHd.getHin().getRank() !=null){ %>
			<label class="value"><%=cardicContingentBillHd.getHin().getRank().getRankName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
				<div class="Clear"></div>
			
			<label>Branch/Trade </label>
			<%if(cardicContingentBillHd.getHin().getTrade() !=null){ %>
			<label class="value"><%=cardicContingentBillHd.getHin().getTrade().getTradeName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
				
			<label>Unit </label>
			<%if(cardicContingentBillHd.getHin().getUnit() !=null){ %>
			<label class="value"><%=cardicContingentBillHd.getHin().getUnit().getUnitName()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
				
			<label>Unit Address </label>
			<%if(cardicContingentBillHd.getHin().getUnit() !=null){ %>
			<label class="value"><%=cardicContingentBillHd.getHin().getUnit().getUnitAddress()%></label>
			<%}else{ %>
			<label class="value"> - </label>
			<%} %>
			
	<%
			int inpatientId =0;
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = cardicContingentBillHd.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				
%>
<%if(cardicContingentBillHd.getInpatient()!=null){ %>
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=cardicContingentBillHd.getInpatient().getId()%>"/>
<input type="hidden" name="<%=DEPARTMENT_ID %>"  value="<%=cardicContingentBillHd.getInpatient().getDepartment().getId() %>" />
<%}} }%>
<input type="hidden" name="<%=HIN_ID %>" value="<%=cardicContingentBillHd.getHin().getId() %>"/>

</div>
<div class="Clear"></div>
				<div class="division"></div>
				<label >Bill Details</label>
		 		<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1"/>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
				<label style="padding-left:30px;width:140px;" >Select Test Type :-</label>
	<label style="padding-left:20;width:70px;">ALL Test</label>
	<input type="radio" name="testType" id="testType1" value="ALL" onclick="checkedfunctions();" style="width:5px;"/>
	<label style="padding-left:20;width:180px;">MedicalClaims Specific Test </label>
	<input type="radio" name="testType" id="testType2"  value="MEDCLAIMS" checked="checked"  style="width:5px;" onclick="checkedfunctions();" />
				
				<div class="Clear"></div>
<div class="tableHolderAuto" style="margin-bottom:0px; border-bottom:0px;">

<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
<thead>
<tr> 
		<th scope="col"></th>
		<th scope="col">Details</th>
		<th scope="col">Bill No</th>
		<th scope="col">Bill Date</th>
		<th scope="col">Amount</th>
</tr>
</thead>
<tbody>

	<%
		int inc = 0;
		if(map.get("contingentdetailList") != null){
			contingentdetailList=(List)map.get("contingentdetailList");
		}
	     if(contingentdetailList!= null && contingentdetailList.size()>0){
	    	 for(MdCardicContingentBillDt cardicContingentBillDt:contingentdetailList){
			  inc++; 
	  %>

<tr> 
<td>	 <input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
 <td>
 <%if(cardicContingentBillDt.getDetails()!=null || !cardicContingentBillDt.getDetails().equals("")){ %>
      <input type="text"  name="<%=DETAILS%>" value="<%=cardicContingentBillDt.getDetails().getChargeCodeName()%>" id="<%=DETAILS%><%=inc %>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" maxlength="30"/>
      <input type="hidden" value="<%=cardicContingentBillDt.getDetails().getId()%>" name="chargeCodeId" id="chargeCodeId<%=inc %>"  />
  	  <div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
			    new Ajax.Autocompleter(document.getElementById('<%=DETAILS%><%=inc %>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS%>',callback:eventCallback});
			 
    </script>
      <%}else{ %>
      <input type="text"  name="<%=DETAILS%>" value="" id="<%=DETAILS%><%=inc %>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" maxlength="30"/>
      <input type="hidden" value="<%=cardicContingentBillDt.getDetails().getId()%>" name="chargeCodeId" id="chargeCodeId<%=inc %>"  />
  	  <div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
			    new Ajax.Autocompleter(document.getElementById('<%=DETAILS%><%=inc %>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS%>',callback:eventCallback});
			 
    </script>
      <%} %>
      <input type="hidden" value="<%=inc%>" name="selectedChrage1" class="radioCheck" />
</td>
<td>
	 <%if(cardicContingentBillDt.getBillNo() != null){ %>
	  <input type="text"  name="<%=BILL_NO%>" value="<%=cardicContingentBillDt.getBillNo() %>" id="billNoId<%=inc %>" maxlength="15"/>
	  <%}else{ %>
	  <input type="text"  name="<%=BILL_NO%>" value="" id="billNoId<%=inc %>" maxlength="15"/>
	  <%} %>
</td>
<td>
	<%if(cardicContingentBillDt.getBillDate() != null){ %>
	<input type="text" class="calDate" id="billDateId<%=inc%>" name="<%=BILL_DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(cardicContingentBillDt.getBillDate()) %>"  readonly="readonly" MAXLENGTH="30" />
	<%}else{ %>
	<input type="text" class="calDate" id="billDateId<%=inc%>" name="<%=BILL_DATE %>" value=""  readonly="readonly" MAXLENGTH="30" />
	<%} %>
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('billDateId<%=inc%>'),event)"/>
</td>
<td>
	<%if(cardicContingentBillDt.getAmount() != null){ %>
	  <input type="text" name="<%=AMOUNT %>" id="amount<%=inc %>" value="<%=cardicContingentBillDt.getAmount() %>" maxlength="8" onblur="validateAmount(this.value,<%=inc %>);totalAmount();"/>
	<%}else{ %>
	<input type="text" name="<%=AMOUNT %>" id="amount<%=inc %>" value="" maxlength="8" onblur="validateAmount(this.value,<%=inc %>);totalAmount();"/>
	<%} %>
</td>
</tr>
	<%} %>
</tbody>
	<%} %>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge" id="hiddenValueCharge" />
</div>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
<tr>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom"></th>
<th class="bottom">Total Rs</th>
<th class="bottom"><%if(cardicContingentBillHd.getTotalRs()!= null){%>
<input type="text" name="<%=TOTAL_RS%>" value="<%=cardicContingentBillHd.getTotalRs() %>" id="totalRsId" readonly="readonly"/>
<%}else{ %>
<input type="text" value="" name="<%=TOTAL_RS%>" id="totalRsId" readonly="readonly"/>
<%} %></th>
</tr>


</table>
</div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div class="blockFrame">
<div class="Clear"></div>

<label class="large"><span>*</span> Amount qualifying for</label>
<%if(cardicContingentBillHd.getQualifyingAmount()!= null){ %>
<input id="treatment" name="qualifyingRs" type="text" value="<%=cardicContingentBillHd.getQualifyingAmount() %>" validate="Amount qualifying for,float,yes"  maxlength="8"/>
<%}else{ %>
<input id="treatment" name="qualifyingRs" type="text" value="" validate="Amount qualifying for,float,yes" maxlength="8"/>
<%} %>


<label  class="large"><span>*</span> Amount Payable to</label>
<%if(cardicContingentBillHd.getPayableTo()!= null){ %>
<input id="advanceAmount" name="payableTo" type="text" value="<%=cardicContingentBillHd.getPayableTo() %>" validate="Amount Payable to,string,yes" maxlength="50"/>
<%}else{ %>
<input id="advanceAmount" name="payableTo" type="text" value="" validate="Amount Payable to,string,yes" maxlength="50"/>
<%} %>
<div class="Clear"></div>



<label><span>*</span> CGHS rates in </label>
<select name="<%=CGHS_RATE%>" validate="CGHS rates in,string,yes">
<% if(cardicContingentBillHd.getCghsRates()!=null && !cardicContingentBillHd.getCghsRates().equals("")){
	if(cardicContingentBillHd.getCghsRates().equalsIgnoreCase("General-Ward")){%>
		<option value="General-Ward" selected="selected">General-Ward</option>
		<%}else {%>
		<option value="General-Ward" >General-Ward</option>
		<%} %>
		<%if(cardicContingentBillHd.getCghsRates().equalsIgnoreCase("private")){%>
		<option value="private" selected="selected">private</option>
		<%}else {%>
		<option value="private" >private</option>
		<%} %>
		<%if(cardicContingentBillHd.getCghsRates().equalsIgnoreCase("Semi-private Ward")){%>
		<option value="Semi-private Ward" selected="selected">Semi-private Ward</option>
		<%}else {%>
		<option value="Semi-private Ward" >Semi-private Ward</option>
		<%}}else{ %>
        <option value="General-Ward" >General-Ward</option>
		<option value="private">Private Ward</option>
		<option value="Semi-private Ward">Semi-private Ward</option>		
		<%} %>
</select>
<label class="small"><span>*</span> is</label>
<%if(cardicContingentBillHd.getIs2()!= null){ %>
<input id="is1" name="is2" type="text" value="<%=cardicContingentBillHd.getIs2() %>" validate="is,float,yes" maxlength="8"/>
<%}else{ %>
<input id="is1" name="is2" type="text" value="" validate="is,float,yes" maxlength="8"/>
<%} %>

<label><span>*</span> Received (Rs.)</label>
<%if(cardicContingentBillHd.getReceivedRs()!= null){ %>
<input id="is1" name="receivedRs" type="text" value="<%=cardicContingentBillHd.getReceivedRs() %>" validate="Received (Rs.),float,yes" maxlength="8"/>
<%}else{ %>
<input id="is1" name="receivedRs" type="text" value="" validate="Received (Rs.),float,yes" maxlength="8"/>
<%} %>
 <div class="Clear"></div>
	</div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Update"  onclick= "submitForm('cardicContingentBill','mediClaim?method=updateCardicBill');" align="right" />
<input type="reset" class="button" name ="Reset" id="reset" value ="Reset" onclick="resetClicked('cardicContingentBill');" accesskey="r" />
<div class="division"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
	<label>Changed By</label>
	<label class="value"><%=userName%></label>
	<input type="hidden" name="changed_by" value="<%=userName%>">
	
	<label>Changed Date</label>
	<label class="value"><%=currentDate%></label>
	<input type="hidden" name="changed_date" value="<%=currentDate%>">
	
	<label>Changed Time</label>
	<label class="value"><%=time%></label>
	<input type="hidden" name="changed_time" value="<%=time%>">

<div class="Clear"></div>
</div>
</div>
		</form>
<script type="text/javascript">
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
	e1.name='<%=DETAILS%>';
	e1.id='<%=DETAILS%>'+ (iteration);;
	e1.value="";
	e1.onblur=function(){
				if(fillSrNo){fillChargeId(this.value,iteration);}
			  };
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
	e2.maxLength="15"
   	cell2.appendChild(e2);
	
   var cellRight2 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=BILL_DATE%>';
	  e3.id='<%=BILL_DATE%>'+iteration;
	  e3.readOnly = true;
	  cellRight2.appendChild(e3); 
	  
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.class = 'calender';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
			setdate('',document.getElementById('<%=BILL_DATE%>'+iteration),event) };
	  cellRight2.appendChild(eImg);
   	
   	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name = '<%=AMOUNT%>';
	e4.id = '<%=AMOUNT%>' + (iteration);
	 e4.onblur= function(){
					totalAmount();}
	e4.tabIndex="1";
	e4.maxLength="6"
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
		var totalAmt = eval(document.getElementById('amount'+i));
		if(validateFloat(totalAmt.value)){
			if(amt != 0 && totalAmt.value != ""){
				amt = parseInt(amt)+parseInt(totalAmt.value);
			}else if(amt == 0 && totalAmt.value != ""){
				amt = parseInt(totalAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById('amount'+i).value = "";
			return false;
		}
	}
	document.getElementById('totalRsId').value = amt;
}
</script>