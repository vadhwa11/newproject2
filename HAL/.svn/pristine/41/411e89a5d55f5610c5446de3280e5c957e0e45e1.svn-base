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
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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

	  
	  var cellRightSel = row.insertCell(0);
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
	    
	  var cellRightSel2 = row.insertCell(1);
	  var sel2 = document.createElement('input');
	  sel2.type = 'text';
	  sel2.name='author';
	  sel2.tabIndex="1";
	  sel2.id='author'+iteration
	  sel2.maxlength="5"
	  cellRightSel2.appendChild(sel2);
	  
	  
	  var cellRightSel3 = row.insertCell(2);
	  var sel3 = document.createElement('input');
	  sel3.type = 'text';
	  sel3.name = 'publisher';
	  sel3.tabIndex="1";
	  sel3.id = 'publisher' + iteration;
	  sel3.size = '20';
	  cellRightSel3.appendChild(sel3);
	  
	  cellRightSel3.id='bk'+iteration;
	  var sel13 = document.createElement('input');
	  sel13.type = 'hidden';
	  sel13.name='publisherId';
	  sel13.id='publisherId'+iteration
	  sel13.size = '10'
	  sel13.maxlength="5"
	  cellRightSel3.appendChild(sel13);
	  
	  
	    
	  var cellRightSel4 = row.insertCell(3);
	  var sel4 = document.createElement('input');
	  sel4.type = 'text';
	  sel4.name='publication';
	  sel4.tabIndex="1";
	  sel4.id='publication'+iteration
	  sel4.maxlength="5"
	  sel4.validate = "Quantity,int,yes"
	  cellRightSel4.appendChild(sel4);
	  
	  var cellRightSel5 = row.insertCell(4);
	  var sel5 = document.createElement('input');
	  sel5.type = 'text';
	  sel5.name='cost';
	  sel5.tabIndex="1";
	  sel5.id='cost'+iteration
	  sel5.maxlength="5"
	  cellRightSel5.appendChild(sel5);
	  
	  var cellRightSel6 = row.insertCell(5);
	  var sel6 = document.createElement('input');
	  sel6.type = 'text';
	  sel6.name='edition';
	  sel6.tabIndex="1";
	  sel6.id='edition'+iteration
	  sel6.maxlength="5"
	  cellRightSel6.appendChild(sel6);
	 
	 
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
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasVendor> vendorList = (ArrayList<MasVendor>)map.get("vendorList");
	ArrayList<MasBook> bookList = (ArrayList<MasBook>)map.get("bookList");
	ArrayList<MasPublisher> publisherList = (ArrayList<MasPublisher>)map.get("publisherList");
	ArrayList<MlSupplyorderHeader> supplyList = (ArrayList<MlSupplyorderHeader>)map.get("supplyList");
	List<MlSupplyorderDetail> supplyDtList = new ArrayList<MlSupplyorderDetail>();
	MlSupplyorderDetail supplyOrderDt = new MlSupplyorderDetail();
	try{
		if(map.get("supplyDtList") != null){
			supplyDtList=(List<MlSupplyorderDetail>)map.get("supplyDtList");
		}
		supplyOrderDt = (MlSupplyorderDetail)supplyDtList.get(0);
	}catch(Exception e){
		e.printStackTrace();
	}
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

<form name="supply" method="post" action="">
<div id="contentHolder">
<h6>Supply Order Entry</h6>
<div class="Clear"></div>

<%int pageNo =1; %> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <%if(supplyOrderDt.getSupplyHeader().getDepartment() != null){ %>
<input type="hidden"
	value="<%=supplyOrderDt.getSupplyHeader().getDepartment().getId()%>"
	name="deptId" id="deptId" /> <%} %> <%if(supplyOrderDt.getSupplyHeader().getHospital() != null){ %>
<input type="hidden"
	value="<%=supplyOrderDt.getSupplyHeader().getHospital().getId()%>"
	name="hospitalId" id="hospitalId" /> <%} %> <input type="hidden"
	name="hdId" id="hdId"
	value="<%=supplyOrderDt.getSupplyHeader().getId() %>" />
<div class="blockFrame"><label><span>*</span> Supply Order
No.</label> <%if(supplyOrderDt.getSupplyHeader() !=  null){ %> <input type="text"
	name="<%=SUPPLY_ORDER_NO %>" id="<%=SUPPLY_ORDER_NO %>"
	value="<%=supplyOrderDt.getSupplyHeader().getSupplyOrderNo() %>"
	maxlength="25" tabindex="1" /> <%}else{ %> <input type="text"
	name="<%=SUPPLY_ORDER_NO %>" id="<%=SUPPLY_ORDER_NO %>"
	value="<%=entryNo %>" maxlength="25" tabindex="1" /> <%} %> <label><span>*</span>
Date</label> <%if(supplyOrderDt.getSupplyHeader() != null){ %> <input type="text"
	class="calDate" id="fromDateId" name="<%=DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(supplyOrderDt.getSupplyHeader().getDate())%>"
	readonly="readonly" MAXLENGTH="30" /> <%}else{ %> <input type="text"
	class="calDate" id="fromDateId" name="<%=DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=DATE%>,event)" /> <%} %>

<label><span>*</span> Vendor Name</label> <select
	name="<%= VENDOR_ID %>" id="<%= VENDOR_ID %>" tabindex=1
	validate="Vendor Name,string,yes" />
	<option value="0">Select</option>
	<% 
    			for (MasVendor  masVendor : vendorList){
    				if (supplyOrderDt.getSupplyHeader().getVendor().getId() == masVendor.getId()) {
    		%>
	<option value="<%=masVendor.getId ()%>" selected="selected"><%=masVendor.getVendorName()%></option>
	<%}else{ %>
	<option value="<%=masVendor.getId ()%>"><%=masVendor.getVendorName()%></option>
	<%}}%>
</select>

<div class="Clear"></div>

<label><span>*</span> Quotation No.</label> <%if(supplyOrderDt.getSupplyHeader() != null){ %>
<input type="text" name="<%=QUOTATION_NO %>" id="<%=QUOTATION_NO %>"
	value="<%=supplyOrderDt.getSupplyHeader().getQuotationNo() %>"
	maxlength="25" validate="Quotation No,string,yes" tabindex="1" /> <%}else{ %>
<input type="text" name="<%=QUOTATION_NO %>" id="<%=QUOTATION_NO %>"
	value="" maxlength="25" validate="Quotation No,string,yes" tabindex="1" />
<%} %> <label><span>*</span> Quotation Date</label> <%if(supplyOrderDt.getSupplyHeader() != null){ %>
<input type="text" class="calDate" id="<%=QUOTATION_DATE %>"
	name="<%=QUOTATION_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(supplyOrderDt.getSupplyHeader().getQuotationDate())%>"
	readonly="readonly" MAXLENGTH="30" /> <%}else{ %> <input type="text"
	class="calDate" id="<%=QUOTATION_DATE %>" name="<%=QUOTATION_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=QUOTATION_DATE%>,event)" />
<%} %> <label>Remarks</label> <%if(supplyOrderDt.getSupplyHeader()!= null){ %>
<input type="text" name="<%=REMARKS %>" id="<%=REMARKS %>"
	value="<%=supplyOrderDt.getSupplyHeader().getRemarks()%>"
	maxlength="30" validate="Remarks,string,no" tabindex="1" /> <%}else{ %>
<input type="text" name="<%=REMARKS %>" id="<%=REMARKS %>" value=""
	maxlength="30" validate="Remarks,string,no" tabindex="1" /> <%} %>
</div>
<div class="Clear"></div>


<input name="" value="" id="temp" type="hidden" /> <input type="hidden"
	size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="division"></div>
<input type="button" class="cmnButton" value="Add" onclick="addRow();"
	" align="right" /> <input type="button" class="cmnButton"
	value="Delete" onclick="removeRow()" align="right" />

<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

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
 	int inc = 1;
 for(MlSupplyorderDetail detail :supplyDtList){ 
		inc++ ;
 %>

		<tr>
			<td>
			<%if(detail.getBook() != null){ %> <input type="hidden" align="right"
				name="bookId" id="bookId<%=inc%>"
				value="<%=detail.getBook().getId() %>" tabindex="1" /> <input
				type="text" align="right" name="bookName" id="bookName<%=inc%>"
				value="<%=detail.getBook().getBookName() %>" tabindex="1"
				onblur="checkForBook(this.value, '<%=inc %>');" />
			<div id="ac2update6"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('bookName<%=inc %>','ac2update6','lib?method=getBook',{parameters:'requiredField=bookName<%=inc %>'});
</script> <%}else{ %> <input type="hidden" align="right" name="bookId"
				id="bookId<%=inc%>" tabindex="1" /> <input type="text" align="right"
				name="bookName" id="bookName<%=inc%>" tabindex="1"
				onblur="checkForBook(this.value, '<%=inc %>');" />
			<div id="ac2update6"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('bookName<%=inc %>','ac2update6','lib?method=getBook',{parameters:'requiredField=bookName<%=inc %>'});
</script> <%} %>
			</td>

			<td>
			<%if(detail.getBook() != null){ %> <input type="text"
				value="<%=detail.getBook().getAuthorName() %>" name="author"
				id="author<%=inc %>" tabindex="1" /> <%}else{ %> <input type="text"
				value="" name="author" id="author<%=inc %>" tabindex="1" /> <%} %>
			</td>

			<td>
			<%if(detail.getPublisher() != null){ %> <input type="text"
				value="<%=detail.getPublisher().getPublisherName() %>"
				name="publisher" id="publisher<%=inc %>" tabindex="1" /> <input
				type="hidden" value="<%=detail.getPublisher().getId() %>"
				name="publisherId" id="publisherId<%=inc %>" tabindex="1" /> <%}else{ %>
			<input type="text" value="" name="publisher" id="publisher<%=inc %>"
				tabindex="1" /> <input type="hidden" value="" name="publisherId"
				id="publisherId<%=inc %>" tabindex="1" /> <%} %>
			</td>
			<td>
			<%if(detail.getPublicationYear() != null){ %> <input type="text"
				value="<%=detail.getPublicationYear() %>" name="publication"
				id="publication<%=inc %>" tabindex="1" /> <%}else{ %> <input
				type="text" value="" name="publication" id="publication<%=inc %>"
				tabindex="1" /> <%} %>
			</td>
			<td>
			<%if(detail.getCost() != null){ %> <input type="text"
				value="<%=detail.getCost() %>" name="cost" id="cost<%=inc %>"
				tabindex="1" /> <%}else{ %> <input type="text" value="" name="cost"
				id="cost<%=inc %>" tabindex="1" /> <%} %>
			</td>
			<td>
			<%if(detail.getEdition() != null){ %> <input type="text"
				value="<%=detail.getEdition() %>" name="edition"
				id="edition<%=inc %>" tabindex="1" /> <%}else{ %> <input type="text"
				value="" name="edition" id="edition<%=inc %>" tabindex="1" /> <%} %>
			</td>
		</tr>

		<%} %>
	</tbody>
</table>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" /></div>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
<div class="Clear"></div>
<div class="bottom">
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Update"
	class="button"
	onClick="submitForm('supply','lib?method=updateSupplyOrder');"
	accesskey="a" tabindex="1" /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset" onclick="" accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" />

<div class="division"></div>

<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date %>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<div class="Clear"></div>
</div>
</form>
<script>

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
			
			var index1 = val.lastIndexOf("[");
			var indexForBookName = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var bookId = val.substring(index1,index2);
			var indexForBookName = indexForBookName--;
			var bookName = val.substring(0,indexForBookName);
		
		if(bookId =="")
		{
	    document.getElementById('author'+inc).value = "";
	  	 document.getElementById('publisher'+inc).value = "";
	  	  document.getElementById('publisherId'+inc).value = "";
	  	 document.getElementById('edition'+inc).value = "";
	  	 document.getElementById('publication'+inc).value = "";
	     return;
		}
	/*	for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bookName'+i).value==val)
		{
			alert("Book  already selected...!")
			document.getElementById('bookName'+inc).value=""
			var e=eval(document.getElementById('bookName'+inc)); 
			e.focus();
			return false;
		} }  }
	*/	
		ajaxFunctionForAutoCompleteBook('supply','lib?method=fillItemsForBook&bookName=' +  bookName , inc);
		
		}else{
			document.getElementById('author'+inc).value = "";
	  	 document.getElementById('publisher'+inc).value = "";
	  	  document.getElementById('publisherId'+inc).value = "";
	  	 document.getElementById('edition'+inc).value = "";
	  	 document.getElementById('publication'+inc).value = "";
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