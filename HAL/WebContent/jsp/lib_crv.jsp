<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPublisher"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.MasVendor"%>
<%@page import="jkt.hms.masters.business.MlSupplyorderHeader"%>
<%@page import="jkt.hms.masters.business.MlSupplyorderDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
<%

Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String date=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(date.length()<2){
date="0"+date;
}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<script>
var tempItemArray = new Array();
 function addRow(){
	var icdString =document.getElementById("temp").value;
	
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  cell1.id='itm'+iteration;
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '5';
	  e1.name='bookNo'+iteration;
	  e1.id='bookNo'+iteration
	  cell1.appendChild(e1);
	  
	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.onblur=function(){
	  	checkForBook(this.value,iteration)
	   };
	  sel.name = 'bookName'+ iteration;
	  sel.id = 'bookName' + iteration;
	  sel.size = '20';
	  cellRightSel.appendChild(sel);
	  
	 new Ajax.Autocompleter('bookName'+iteration,'ac2update6','lib?method=getBook',{parameters:'requiredField=bookName'+iteration});
	  	
	  cellRightSel.id='bk'+iteration;
	  var sel1 = document.createElement('input');
	  sel1.type = 'hidden';
	  sel1.name='bookId';
	  sel1.id='bookId'+iteration
	  sel1.size = '10'
	  sel1.maxlength="5"
	  cellRightSel.appendChild(sel1);
	    
	  var cellRightSel1 = row.insertCell(2);
	  var sel1 = document.createElement('input');
	  sel1.type = 'text';
	  sel1.name='author';
	  sel1.tabIndex="1";
	  sel1.id='author'+iteration
	  sel1.maxlength="5"
	  cellRightSel1.appendChild(sel1);
	  
	  
	  var cellRightSel2 = row.insertCell(3);
	  var sel2 = document.createElement('input');
	  sel2.type = 'text';
	  sel2.name = 'publisher';
	  sel2.tabIndex="1";
	  sel2.id = 'publisher' + iteration;
	  sel2.size = '20';
	  cellRightSel2.appendChild(sel2);
	  
	  cellRightSel2.id='bk'+iteration;
	  var sel121 = document.createElement('input');
	  sel121.type = 'hidden';
	  sel121.name='publisherId';
	  sel121.id='publisherId'+iteration
	  sel121.size = '10'
	  sel121.maxlength="5"
	  cellRightSel2.appendChild(sel121);
	  
	  
	    
	  var cellRightSel3 = row.insertCell(4);
	  var sel3 = document.createElement('input');
	  sel3.type = 'text';
	  sel3.size = '5';
	  sel3.name='quantity';
	  sel3.tabIndex="1";
	  sel3.id='quantity'+iteration
	  sel3.onblur=function(){
	  	calculateAmountForCrv(iteration)
	   };
	  sel3.maxlength="5"
	  sel3.validate = "Quantity,int,yes"
	  cellRightSel3.appendChild(sel3);
	  
	   var cellRightSel6 = row.insertCell(5);
	  var sel6 = document.createElement('input');
	  sel6.type = 'text';
	  sel6.size = '5';
	  sel6.name='price';
	  sel6.tabIndex="1";
	  sel6.id='price'+iteration
	  sel6.onblur=function(){
	  	calculateAmountForCrv(iteration)
	   };
	  sel6.maxlength="5"
	  cellRightSel6.appendChild(sel6);
	  
	  var cellRightSel4 = row.insertCell(6);
	  var sel4 = document.createElement('input');
	  sel4.type = 'text';
	  sel4.size = '5';
	  sel4.name='discount';
	  sel4.tabIndex="1";
	  sel4.id='discount'+iteration
	   sel4.onblur=function(){
	  	calculateAmountForCrv(iteration)
	   };
	  sel4.maxlength="5"
	  cellRightSel4.appendChild(sel4);
	  
	   var cellRightSel41 = row.insertCell(7);
	  var sel41 = document.createElement('input');
	  sel41.type = 'text';
	  sel41.size = '5';
	  sel41.name='tax';
	  sel41.tabIndex="1";
	  sel41.id='tax'+iteration
	   sel41.onblur=function(){
	  	calculateAmountForCrv(iteration)
	   };
	  sel41.maxlength="5"
	  cellRightSel41.appendChild(sel41);
	  
	  var cellRightSel5 = row.insertCell(8);
	  var sel5 = document.createElement('input');
	  sel5.type = 'text';
	 sel5.size = '5';
	  sel5.name='amount';
	  sel5.tabIndex="1";
	  sel5.id='amount'+iteration
	  sel5.maxlength="5"
	  cellRightSel5.appendChild(sel5);
	  
	 
	  
	  var cellRightSel7 = row.insertCell(9);
	  var sel7 = document.createElement('input');
	  sel7.type = 'text';
	  sel7.name='publication';
	  sel7.tabIndex="1";
	  sel7.size="5";
	  sel7.id='publication'+iteration
	  sel7.maxlength="5"
	  cellRightSel7.appendChild(sel7);
	  
	  var cellRightSel8 = row.insertCell(10);
	  var sel8 = document.createElement('input');
	  sel8.type = 'text';
	  sel8.size = '5';
	  sel8.name='pageNo';
	  sel8.tabIndex="1";
	  sel8.id='pageNo'+iteration
	  sel8.maxlength="5"
	  cellRightSel8.appendChild(sel8);
	  
	  var cellRightSel9 = row.insertCell(11);
	  var sel9 = document.createElement('input');
	  sel9.type = 'text';
	  sel9.size = '5';
	  sel9.name='volume';
	  sel9.tabIndex="1";
	  sel9.id='volume'+iteration
	  sel9.maxlength="5"
	  cellRightSel9.appendChild(sel9);
	 
	 
	 
	}
</script>
<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTime");
	String currentDate = (String)utilMap.get("currentDate");
	List<MasVendor> vendorList = (List<MasVendor>)map.get("vendorList");
	ArrayList<MasBook> bookList = (ArrayList<MasBook>)map.get("bookList");
	ArrayList<MasPublisher> publisherList = (ArrayList<MasPublisher>)map.get("publisherList");
	//ArrayList<MlSupplyorderHeader> searchSupplyList = (ArrayList<MlSupplyorderHeader>)map.get("searchSupplyList");
	List<MlSupplyorderHeader> mlSupplyorderHeaderList = new ArrayList<MlSupplyorderHeader>();

	String crvNo="";
	if(map.get("crvNo") != null){
		crvNo = (String)map.get("crvNo");
	}
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if(session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("vendorList") != null)	{
		vendorList = (List<MasVendor>)map.get("vendorList");
	}
	if(map.get("mlSupplyorderHeaderList") != null)	{
		mlSupplyorderHeaderList = (List<MlSupplyorderHeader>)map.get("mlSupplyorderHeaderList");
	}
	
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>
<h2><%=message %></h2>

<%} %>
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasVendor masVendor : vendorList)
			{
				for (MlSupplyorderHeader mlSupplyorderHeader : mlSupplyorderHeaderList) 
				{
					if(mlSupplyorderHeader.getVendor() != null){
						if(masVendor.getId().equals(mlSupplyorderHeader.getVendor().getId() )){
								%>
									soArray[<%=counter1%>] = new Array();
									soArray[<%=counter1%>][0]=<%=masVendor.getId()%>;
									soArray[<%=counter1%>][1] = <%=mlSupplyorderHeader.getId()%>;									
									soArray[<%=counter1%>][2] = "<%=mlSupplyorderHeader.getSupplyOrderNo()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		</script>


<form name="supply" method="post" action="">
<div id="contentHolder">
<h6>CRV Entry</h6>
<div class="Clear"></div>

<%int pageNo =1; %> <input type="hidden" name="pageNo" id="pageNo"	value="<%=pageNo%>" />
 <input type="hidden" name="hospitalId"	id="hospitalId" value="<%=hospitalId %>" /> 
 <input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<div class="blockFrame"><label><span>*</span> CRV No.</label> 
<input	type="text" name="<%=CRV %>" id="<%=CRV %>" value="<%=crvNo %>"	maxlength="25" tabindex="1" />
 <label><span>*</span> Date</label>
  <input type="text" class="calDate" id="<%=DATE %>" name="<%=DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"	tabindex="1" validate="Date,date,yes" />
   <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=date %>',document.supply.<%=DATE%>,event)" /> 
   
   
   <label><span>*</span>Source Of Receipt</label> 
   <select name="<%=SOURCE_OF_RECIEPT %>" id="<%=SOURCE_OF_RECIEPT %>" validate="Source Of Receipt,string,yes" tabindex="1" />
	<option value="">Select</option>
	<option value="NDF Acession">NDF Acession</option>
	<option value="ETG/LMG">ETG/LMG</option>
</select>

<div class="Clear"></div>

<label><span>*</span> Accession No.</label>
<input type="text"	name="<%=ACCESSION_NO %>" id="<%=ACCESSION_NO %>" value=""	maxlength="25" validate="Accession No,string,yes" tabindex="1" />




 <label><span>*</span>Source(dealer) Name</label> 
 <select name="<%= VENDOR_ID %>" id="<%= VENDOR_ID %>" tabindex=1 validate="Source Name,string,yes" onChange="populateSupplyOrderNo(this.value,'supply')" />
	<option value="0">Select</option>
	<% 
    			for (MasVendor  masVendor : vendorList){
    		%>
	<option value="<%=masVendor.getId ()%>"><%=masVendor.getVendorName()%></option>

	<%}%>
</select> 

<label>Supply Order No:</label>
<select name="<%=SUPPLY_ORDER_NO%>" id="supplyId" tabindex="1" onchange="submitProtoAjaxWithDivName('supply','lib?method=supplyOrderEntryCRV','supplyDiv');" >
      <option value="0">Select</option>
      
</select>

<div class="Clear"></div>

<label><span>*</span> Bill No.</label> <input type="text"
	name="<%=BILL_NO %>" id="<%=BILL_NO %>" value="" maxlength="25"
	validate="Bill No,string,yes" tabindex="1" />


<label><span>*</span> Bill Date</label> <input type="text"
	class="calDate" id="<%=BILL_DATE %>" name="<%=BILL_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	tabindex="1" validate="Bill Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=BILL_DATE%>,event)" />

<label>Bill Amount</label> <input type="text" name="<%=BILL_AMOUNT %>"
	id="<%=BILL_AMOUNT %>" value="" maxlength="30"
	validate="Bill Amount,string,no" tabindex="1" />
<div class="Clear"></div>
</div>
<div class="division"></div>
<input name="" value="" id="temp" type="hidden" />
<div id="supplyDiv">

<input type="button"
	class="cmnButton" value="Add" onclick="addRow();" " align="right" /> <input
	type="button" class="cmnButton" value="Delete" onclick="removeRow()"
	align="right" />

<div class="Clear"></div>

<div class="tableHolderAuto">

<table width="100%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="7%">Book Code</th>
			<th width="7%">Name of the Book</th>
			<th width="10%">Author</th>
			<th width="10%">Publisher</th>
			<th width="7%">Quantity</th>
			<th width="7%">Price</th>
			<th width="7%">Discount</th>
			<th width="7%">Tax</th>
			<th width="7%">Amount</th>
			<th width="7%">Year of Publication</th>
			<th width="7%">Page No.</th>
			<th width="7%">Volume</th>
		</tr>
	</thead>
	<tbody>
	
	<%
 	int inc = 1;
	
 %>


		<tr>
			<td><input type="text" size="5" value="" name="bookNo"
				id="bookNo<%=inc %>" tabindex="1" /></td>
			<td><input type="hidden" align="right" name="bookId"
				id="bookId<%=inc%>" tabindex="1" /> <input type="text" align="right"
				name="bookName" id="bookName<%=inc%>" tabindex="1"
				onblur="checkForBook(this.value, '<%=inc %>');" />
			<div id="ac2update6"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('bookName<%=inc %>','ac2update6','lib?method=getBook',{parameters:'requiredField=bookName<%=inc %>'});
</script></td>
			<td><input type="text" value="" name="author"
				id="author<%=inc %>" tabindex="1" /></td>
			<td><input type="text" value="" name="publisher"
				id="publisher<%=inc %>" tabindex="1" /> <input type="hidden"
				value="" name="publisherId" id="publisherId<%=inc %>" tabindex="1" />
			</td>
			<td><input type="text" size="5" value="" name="quantity"
				id="quantity<%=inc %>" tabindex="1"
				onblur="calculateAmountForCrv('<%=inc %>');" /></td>
			<td><input type="text" size="5" value="" name="price"
				id="price<%=inc %>" tabindex="1"
				onblur="calculateAmountForCrv('<%=inc %>');" /></td>
			<td><input type="text" size="5" value="" name="discount"
				id="discount<%=inc %>" tabindex="1"
				onblur="calculateAmountForCrv('<%=inc %>');" /></td>
			<td><input type="text" size="5" value="" name="tax"
				id="tax<%=inc %>" tabindex="1"
				onblur="calculateAmountForCrv('<%=inc %>');" /></td>
			<td><input type="text" size="5" value="" name="amount"
				id="amount<%=inc %>" tabindex="1" /></td>
			<td><input type="text" size="5" value="" name="publication"
				id="publication<%=inc %>" tabindex="1" /></td>
			<td><input type="text" value="" size="5" name="pageNo"
				id="pageNo<%=inc %>" tabindex="1" /></td>
			<td><input type="text" value="" size="5" name="volume"
				id="volume<%=inc %>" tabindex="1" /></td>
		</tr>


	</tbody>
</table>
</div>

<div class="Clear"></div>
<label class="common">Total Amount</label> <input type="text"
	name="<%=TOTAL_AMOUNT %>" value="" id="total_amount"
	validate="Total Amount,float,no" readonly="readonly"> <input
	type="hidden" value="" id="totalCarryForward"> <input
	type="hidden" name="counter" id="counter" value="<%=inc %>" /> <input
	type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
	</div>
<div class="Clear"></div>
<div class="bottom">
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(checkFilledRow()){submitForm('supply','lib?method=submitLibCrv');}"
	accesskey="a" tabindex="1" /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset" onclick="" accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" />
<div class="division"></div>
<input type="hidden" value="0" name="noOfRecords" id="noOfRecords" />

<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate %></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate %>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<div class="Clear"></div>
</div>
</div>
</form>
<script>

function checkForBook(val,inc){
		if(val != "")
		{
			
			var index1 = val.lastIndexOf("[");
			var indexForBookName = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var bookId = val.substring(index1,index2);			
			var indexForBookName = indexForBookName--;
			var bookName = val.substring(0,indexForBookName);
		
		if(bookId =="")
		{
		document.getElementById('bookNo'+inc).value = "";
	    document.getElementById('author'+inc).value = "";
	  	document.getElementById('publisher'+inc).value = "";
	  	document.getElementById('publisherId'+inc).value = "";
	  	document.getElementById('publication'+inc).value = "";
	  	document.getElementById('volume'+inc).value = "";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bookName'+i).value==val)
		{
			alert("Book  already selected...!")
			document.getElementById('bookName'+inc).value=""
			var e=eval(document.getElementById('bookName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteForCRV('supply','lib?method=fillItemsForCRV&bookName=' +  bookName , inc);
		
		}else{
		 document.getElementById('bookNo'+inc).value = "";
		 document.getElementById('author'+inc).value = "";
	  	 document.getElementById('publisher'+inc).value = "";
	  	 document.getElementById('publisherId'+inc).value = "";
	  	 document.getElementById('publication'+inc).value = "";
	  	 document.getElementById('volume'+inc).value = "";
		}
}



function checkFilledRow(){
	var msg ="";
	
	  	var count = document.getElementById('counter').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('bookName'+i).value == ""){
	  	 	alert("Please Enter Book Name.");
	  				return false;
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
<script>
 function removeRow()
	{
	  var tbl = document.getElementById('tblSample');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("There should be least one row");
	  
	}

</script>