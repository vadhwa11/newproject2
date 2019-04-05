<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
	Box box = HMSUtil.getBox(request);
	
	String receiptNo="";
	if(map.get("receiptNo") != null){
		receiptNo = (String)map.get("receiptNo");
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
	
	 var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('label');
	  e0.type = 'label';
	  e0.innerHTML = iteration+''
	  e0.className = 'smalllabel'
	  cellRight0.appendChild(e0);
	  
	 
	  
	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	 sel.onblur=function(){
	  		fillBook(this.value,iteration)
	   };
	  sel.name = 'bookName'+ iteration;
	  sel.id = 'bookName' + iteration;
	  //sel.size = '100';
	  cellRightSel.appendChild(sel);
	new Ajax.Autocompleter('bookName'+(iteration),'ac2update6','lib?method=getBook',{parameters:'requiredField=bookName'+ (iteration)});
	 
	  	
	 cellRightSel.id='bk'+iteration;
	  var sel1 = document.createElement('input');
	  sel1.type = 'hidden';
	  sel1.name='bookId'+ iteration;
	  sel1.id='bookId'+iteration
	  sel1.size = '10'
	  sel1.maxlength="5"
	  cellRightSel.appendChild(sel1);
	    
	  var cellRightSel2 = row.insertCell(2);
		var sel2 = document.createElement('input');
	  sel2.type = 'text';
	  sel2.name='subject'+ iteration;
	  sel2.tabIndex="1";
	  sel2.id='subject'+iteration
	  sel2.maxlength="5"
	  sel2.validate = "subject,string,yes"
	  cellRightSel2.appendChild(sel2);
	  
	  var cellRightSel3 = row.insertCell(3);
	
	  var sel3 = document.createElement('input');
	  sel3.type = 'text';
	  sel3.name='quantity'+ iteration;
	  sel3.tabIndex="1";
	  sel3.id='quantity'+iteration
	  sel3.maxlength="5"
	  sel3.validate = "Quantity,int,yes"
	  cellRightSel3.appendChild(sel3);
	 
	
	 
	}
</script>
<script type="text/javascript">
function fillBook(val,inc){

		if(val != "")
		{
			
			var index1 = val.lastIndexOf("[");
			var indexForBookName = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var book_Id = val.substring(index1,index2);
			var indexForBookName = indexForBookName--;
			var bookName = val.substring(0,indexForBookName);
		document.getElementById('bookId'+inc).value = book_Id;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bookName'+i).value==val)
		{
			alert("Title already selected...!")
			document.getElementById('bookName'+inc).value=""
			var e=eval(document.getElementById('bookName'+inc)); 
			e.focus();
			return false;
		} }  }
	}	
}

</script>
<form name="supply" method="post" action="">
<div id="contentHolder">
<h6>Journal Receipt Entry</h6>
<div class="Clear"></div>

<%int pageNo =1; %> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <input type="hidden" name="hospitalId"
	id="hospitalId" value="<%=hospitalId %>" /> <input type="hidden"
	name="deptId" id="deptId" value="<%=deptId %>" />
<div class="blockFrame"><label class="medium"><span>*</span>
Receipt No.</label> <input type="text" class="calDate" name="<%=RECEIPT_NO %>"
	id="<%=RECEIPT_NO %>" value="<%=receiptNo %>" maxlength="12"
	validate="Receipt No,string,yes" tabindex="1" /> <label class="medium"><span>*</span>
Date</label> <input type="text" class="calDate" id="<%=DATE %>"
	name="<%=DATE %>" value="<%=date %>" readonly="readonly" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.supply.<%=DATE%>,event)" /> <label
	class="medium"><span>*</span> Year</label> <select name="<%=YEAR %>"
	class="small" id="<%=YEAR %>" validate="Year,String,yes">
	<option value="0">Select</option>
	<option value="<%=Integer.parseInt(date.substring(6))-1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))-1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6))-1%>
	</option>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>
		selected><%=date.substring(6)%></option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6))+1%>
	</option>
</select> <label class="medium"><span>*</span> Month </label> <select
	name="<%=MONTH %>" validate="Month,String,yes">
	<option value="">Select</option>
	<option value="January">January</option>
	<option value="February">February</option>
	<option value="March">March</option>
	<option value="April">April</option>
	<option value="May">May</option>
	<option value="June">June</option>
	<option value="July">July</option>
	<option value="August">August</option>
	<option value="September">September</option>
	<option value="October">October</option>
	<option value="November">November</option>
	<option value="December">December</option>
</select>
<div class="Clear"></div>

<label class="medium"><span>*</span> Issue No.</label> <input
	type="text" class="calDate" name="<%=ISSUE_NO %>" id="<%=ISSUE_NO %>"
	value="" maxlength="30" validate="Issue No,string,yes" tabindex="1" />
</div>

<div class="division"></div>
<input name="" value="" id="temp" type="hidden" /> <input type="button"
	class="cmnButton" value="Add" onclick="addRow();" " align="right" /> <input
	type="button" class="cmnButton" value="Delete" onclick="removeRow()"
	align="right" /> <input type="hidden" size="2" value=""
	name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">Sr No.</th>
			<th width="7%">Title</th>
			<th width="10%">Subject</th>
			<th width="10%">Quantity</th>

		</tr>
	</thead>
	<tbody>
		<%
		int inc = 1;
	%>
		<tr>

			<td>1 <input type="hidden" name="<%=SR_NO %>" id="<%=SR_NO %><%=inc %>" value="<%=inc %>" /></td>
			<td><input type="hidden" align="right" name="bookId" id="bookId<%=inc%>" value="" tabindex="1" /> 
			<input type="text"	align="right" name="bookName" id="bookName<%=inc%>" tabindex="1" onblur="fillBook(this.value,<%=inc %>);" />
			<div id="ac2update6" style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('bookName<%=inc %>','ac2update6','lib?method=getBook',{parameters:'requiredField=bookName'});
</script></td>
			<td><input type="text" size="15" value="" name="subject"
				id="subject<%=inc %>" tabindex="1" /></td>
			<td><input type="text" size="5" value="" name="quantity"
				id="quantity<%=inc %>" tabindex="1" /></td>
		</tr>



	</tbody>
</table>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" /></div>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
<div class="Clear"></div>
<div class="bottom">
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"
	onClick="if(checkFilledRow()){submitForm('supply','lib?method=submitJournalReceiptEntry');}"
	accesskey="a" tabindex="1" /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('supply',<%=inc %>);" " accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" />

<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date %>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	value="1" name="hiddenValue" id="hiddenValue" /></div>
<div class="Clear"></div>
</div>
</form>
<script>

function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValue').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('bookName'+i).value == ""){
	  				alert("Please fill Title to submit.");
	  				return false;
	  			}
	  			if(document.getElementById('subject'+i).value == ""){
	  				alert("Please fill Subject to submit.");
	  				return false;
	  			}
	  			if(document.getElementById('quantity'+i).value == ""){
	  				alert("Please fill Quantity to submit.");
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