<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPublisher"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.MasVendor"%>
<%@page import="jkt.hms.masters.business.MlSupplyorderHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasVendor> vendorList = (ArrayList<MasVendor>)map.get("vendorList");
	ArrayList<MasBook> bookList = (ArrayList<MasBook>)map.get("bookList");
	ArrayList<MasPublisher> publisherList = (ArrayList<MasPublisher>)map.get("publisherList");
	ArrayList<MlSupplyorderHeader> searchSupplyList = (ArrayList<MlSupplyorderHeader>)map.get("searchSupplyList");
	ArrayList<MlSupplyorderHeader> supplyList = (ArrayList<MlSupplyorderHeader>)map.get("supplyList");
String entryNo="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
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
	int hospitalId=0;
	if(session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<script>
function checkSearchForEntry(){

	if(document.getElementById('<%=ENTRY_ID %>').value == '' || document.getElementById('<%=DATE %>').value == ''){
		alert("Please enter value in textfield");

		return false;
	}else
		return true;
}
</script>
<form name="supply" method="post" action="">
<div id="contentHolder">
<h6>Supply Order Entry</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Supply
Order No</label> <input type="text" name="<%=ENTRY_ID %>" id="<%=ENTRY_ID %>"
	value="" maxlength="10"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyEntry')" />
<label>Vendor Name</label> <input type="text" id="<%=VENDOR_NAME %>"
	name="<%=VENDOR_NAME %>" value="" MAXLENGTH="10"
	onkeypress="return submitenter(this,event,'lib?method=searchSupplyEntry')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','lib?method=searchSupplyEntry')"
	tabindex=1 /></form>
</div>
</div>
</div>
<%int pageNo =1; %> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <input type="hidden" name="hospitalId"
	id="hospitalId" value="<%=hospitalId %>" /> <input type="hidden"
	name="deptId" id="deptId" value="<%=deptId %>" /> <label
	class="common"><span>*</span>Supply Order No.</label> <input
	type="text" name="<%=SUPPLY_ORDER_NO %>" id="<%=SUPPLY_ORDER_NO %>"
	value="<%=entryNo %>" maxlength="25" validate="Quotation,string,yes"
	tabindex="1" /> <label class="common"><span>*</span>Date:</label> <input
	type="text" class="calDate" id="<%=DATE %>" name="<%=DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=DATE%>,event)" />

<div class="Clear"></div>

<label class="common"><span>*</span>Vendor Name:</label> <select
	name="<%= VENDOR_ID %>" id="<%= VENDOR_ID %>" tabindex=1
	validate="Vendor Name,string,yes" />
	<option value="0">Select</option>
	<% 
    			for (MasVendor  masVendor : vendorList){
    		%>
	<option value="<%=masVendor.getId ()%>"><%=masVendor.getVendorName()%></option>

	<%}%>
</select> <label class="common"><span>*</span>Quotation No:</label> <input
	type="text" name="<%=QUOTATION_NO %>" id="<%=QUOTATION_NO %>" value=""
	maxlength="25" validate="Quotation,string,yes" tabindex="1" />

<div class="Clear"></div>

<label class="common"><span>*</span>Quotation Date:</label> <input
	type="text" class="calDate" id="<%=QUOTATION_DATE %>"
	name="<%=QUOTATION_DATE %>" value="<%=date %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=QUOTATION_DATE%>,event)" />

<label class="common">Remarks:</label> <input type="text"
	name="<%=REMARKS %>" id="<%=REMARKS %>" value="" maxlength="30"
	validate="Remarks,string,no" tabindex="1" />
<div class="Clear"></div>

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">SR No</th>
			<th width="7%">Name Of The Book</th>
			<th width="10%">Author</th>
			<th width="10%">Publisher</th>
			<th width="7%">Year Of Publication</th>
			<th width="7%">Comparitive Cost</th>
			<th width="7%">Edition</th>
		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 0;    	
    
    	for(inc=1;inc<=8;inc++){
    	%>

		<tr>

			<td><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td><input type="hidden" align="right" name="bookId"
				id="bookId<%=inc%>" tabindex="1" /> <input type="text" align="right"
				name="book" id="book<%=inc%>" tabindex="1"
				onblur="if(fillSrNo('<%=inc %>')){checkForBook(this.value, '<%=inc %>');}" />
			<div id="ac2update6"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('book<%=inc %>','ac2update6','lib?method=getBook',{parameters:'requiredField=book<%=inc %>'});
</script></td>
			<td><input type="text" size="2" value="" name="author"
				id="author<%=inc %>" tabindex="1" /></td>
			<td><input type="text" size="2" value="" name="publisher"
				id="publisher<%=inc %>" tabindex="1" /> <input type="hidden"
				size="2" value="" name="publisherId" id="publisherId<%=inc %>"
				tabindex="1" /></td>
			<td><input type="text" size="2" value="" name="publication"
				id="publication<%=inc %>" tabindex="1" /></td>
			<td><input type="text" size="2" value="" name="cost"
				id="cost<%=inc %>" tabindex="1" /></td>
			<td><input type="text" size="2" value="" name="edition"
				id="edition<%=inc %>" tabindex="1" /></td>
		</tr>

		<%} %>

	</tbody>
</table>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" /></div>
<div class="Clear"></div>
<div class="bottom">
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('supply','lib?method=submitSupplyOrder');"
	accesskey="a" tabindex="1" /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset" onclick="" accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" /></div>

<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date %>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</div>
</form>
<script>
function fillSrNo(rowVal){

	if(document.getElementById('book'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('book'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function clearAllFields(inc){
	var author = document.getElementById('author'+inc).value
	var publisher = document.getElementById('publisher'+inc).value;
	var publisherId = document.getElementById('publisherId'+inc).value;
	var publication = document.getElementById('publication'+inc).value;
	var edition = document.getElementById('edition'+inc).value;
	
}


function checkForBook(val,inc){

		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForBookName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var bookId = val.substring(index1,index2);
			var indexForBookName = indexForBookName--;
			var bookName = val.substring(0,indexForBookName);
		
		if(bookId =="")
		{
	     document.getElementById('author'+inc).value="";
	  	 document.getElementById('publisher'+inc).value="";
	  	 document.getElementById('publisherId'+inc).value="";
	  	 document.getElementById('edition'+inc).value="";
	  	 document.getElementById('publication'+inc).value="";
	     return;
		}
		
		
		for(i=1;i<=inc;i++){
		if(inc != 1){
		if(document.getElementById('book'+i).value==val)
		{
			alert("Book Name already selected...!")
			document.getElementById('book'+inc).value=""
			var e=eval(document.getElementById('book'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteBook('supply','lib?method=fillItemsForBook&book=' +  bookId , inc);
		
		}else{
		 document.getElementById('author'+inc).value="";
	  	 document.getElementById('publisher'+inc).value="";
	  	  document.getElementById('publisherId'+inc).value="";
	  	 document.getElementById('edition'+inc).value="";
	  	 document.getElementById('publication'+inc).value="";
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
	  	 	if(document.getElementById('book'+i).value != ""){
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
  

</script>