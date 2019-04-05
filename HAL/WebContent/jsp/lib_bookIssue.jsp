<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<form name="bookIssue" method="post" action=""><script
	type="text/javascript">
		history.forward();
</script> <script>
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
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		List<MasEmployee> issuedByList = new ArrayList<MasEmployee>();
		if(map.get("issuedByList") != null){
			issuedByList = (List<MasEmployee>)map.get("issuedByList");
		}
		String issueSeqNo="";
		if(map.get("issueSeqNo") != null){
			issueSeqNo = (String)map.get("issueSeqNo");
		}
%>
<div id="contentHolder">
<h6>Books/Journal Issue Entry</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv">
 <label>Issue No.</label> <input id="orderNoId" type=hidden
	name="<%=ISSUE_NO %>" value="<%=issueSeqNo %>" title="Issue No" /> <label
	class="value"><%=issueSeqNo %></label> <label><span>*</span>
Issue Date</label> <input type="text" class="calDate" id="issueDateId"
	name="<%=ISSUE_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Issue Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bookIssue.<%=ISSUE_DATE%>,event)" />


<label><span>*</span> Service Number </label> <input type="text"
	id="serviceNo" name="<%= SERVICE_NO%>" value=""
	validate="Service No,string,yes" class="textbox_size20" maxlength="15"
	onblur="ajaxFunctionServiceNo(bookIssue);" tabindex=1 /> <input
	type="hidden" id="employeeId" name="<%= EMPLOYEE_ID%>" />
<div class="Clear"></div>

<label>Name</label>
<input type="text" id="name" name="<%= NAME%>"	value="" disabled="disabled" />

<label>Rank</label> <input type="text" id="rankId" name="<%= RANK_ID%>" value="" disabled="disabled" />

<label><span>*</span> Issued By</label> <select name="<%= ISSUED_BY %>"	validate="Issued By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			  if(issuedByList != null){
				for (MasEmployee  masEmployee : issuedByList){
				%>
	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()%> <%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>

	<%} }%>
</select> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>


<div class="division"></div>
<input type="button" name="add" value="Add" class="cmnButton"
	onclick="addRow();" tabindex="1" /> <input type="button" name="delete"
	value="Delete" class="cmnButton" onclick="removeRow();" />
<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Account No.</th>
			<th scope="col">Name of Book</th>
			<th scope="col">Quantity</th>
		</tr>
	</thead>
	<tbody>

		<%
		int inc = 1;
	%>

		<tr>
			<td><input type="checkbox" value="<%=inc%>"
				name="selectedChrage" class="radioCheck" /></td>
			<td><input type="text" align="right" size="20"
				id="bookNo<%=inc%>" readonly="readonly" /></td>
			<td><input type="text" tabindex="1" align="right"
				name="<%=BOOK_NAME%>" size="30" id="bookName<%=inc%>"
				onblur="if(fillSrNo){fillBookDetail(this.value,<%=inc %>);}" />
			<div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">

			    new Ajax.Autocompleter(document.getElementById('bookName<%=inc%>'),'ac2update','lib?method=getBookNameForAutoComplete',{parameters:'requiredField=bookName'});

    	</script> <input type="hidden" name="<%=BOOK_ID %><%=inc%>"
				id="bookId<%=inc %>" /></td>
			<td><input type="text" name="<%=QUANTITY%><%=inc%>"
				id="qty<%=inc%>" size="5" align="right" tabindex="1" maxlength="2" /></td>

		</tr>
	</tbody>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" /></div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="submitForm('bookIssue','lib?method=submitBookIssue');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('bookIssue',<%=inc %>);"
	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
</form>

<script type="text/javascript">

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
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);
		  	//totalCost();
		}
	}
}

	function fillBookDetail(val,inc){
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
	     document.getElementById('bookNo'+inc).value="";
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

		ajaxFunctionForAutoCompleteBookName('bookIssue','lib?method=fillAccNoForBook&bookName=' +  bookName , inc);

		}else{
			document.getElementById('bookNo'+inc).value = "";
		}
}
function fillSrNo(rowVal){

	if(document.getElementById('chargeName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
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
	cell1.id='itm'+iteration;
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='bookNo'+iteration;
	  e1.id='bookNo'+iteration
	  cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.size = '30';
	e2.onblur=function(){
				if(fillSrNo){fillBookDetail(this.value,iteration);}
			  };
	e2.name = 'bookName'+ (iteration);
	e2.id = 'bookName' + (iteration);
	e2.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell2.appendChild(e2);
    cell2.appendChild(newdiv);

	new Ajax.Autocompleter('bookName'+ (iteration),'ac2update','lib?method=getBookNameForAutoComplete',{parameters:'requiredField=bookName'+ (iteration)});

	  cell2.id='itm'+iteration;
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='bookId'+iteration;
	  e2.id='bookId'+iteration;
	  e2.size = '10';
	  e2.maxlength="5";


	  var cell3 = row.insertCell(3);
	  cell3.id='itm'+iteration;
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='quantity'+iteration;
	  e3.id='qty'+iteration
	  e3.size = '5'
	  e3.maxlength="5"
	  cell3.appendChild(e3);

}

</script>
