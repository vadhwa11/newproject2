<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
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
 function removeRow()
	{
	  var tbl = document.getElementById('tblSample');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("There should be atleast one row");
	  
	}

</script>
<script>
function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValue').value;
	  	for(var i=1;i<=count;i++){
	  			if(document.getElementById('<%=ITEM_ID %>'+i).value == ""){
	  				alert("Please Enter Item Name.");
	  				return false;
	  			}
	  			if(document.getElementById('quantity'+i).value == ""){
	  				alert("Please Enter Quantity.");
	  				return false;
	  			}
	  			if(document.getElementById('select'+i).value == false){
	  				alert("Please select to submit.");
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
function inputValue(){
		for(var i = 0; i < document.getElementsByName('select').length; i++){
			if(document.getElementsByName('select')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please Select Atleast One Row.")
		return false;
	}
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
	
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('label');
	  e0.type = 'label';
	  e0.innerHTML = iteration+':'
	  e0.className = 'smalllabel'
	  cellRight0.appendChild(e0);
	  
	  
	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.onblur=function(){
	  			fillItemId(this.value,iteration)
	   };
	  sel.name = 'itemName';
	  sel.id = 'itemName' + iteration;
	  sel.size = '100';
	  cellRightSel.appendChild(sel);
	  new Ajax.Autocompleter('itemName'+iteration,'ac2update','laundry?method=getItemListByAutocomplete',{parameters:'requiredField=itemName'+iteration});
	 
	  	
	  cellRightSel.id='itm'+iteration;
	  var sel1 = document.createElement('input');
	  sel1.type = 'hidden';
	  sel1.name='itemId';
	  sel1.id='itemId'+iteration
	  sel1.size = '10'
	  sel1.maxlength="5"
	  cellRightSel.appendChild(sel1);
	    
	  var cellRightSel2 = row.insertCell(2);
	
	  var sel2 = document.createElement('input');
	  sel2.type = 'text';
	  sel2.name='quantity';
	  sel2.tabIndex="1";
	  sel2.id='quantity'+iteration
	  sel2.maxlength="5";
	  sel2.size="10";
	  sel2.validate = "Quantity,float,no"
	  cellRightSel2.appendChild(sel2);
	 
	  var cellRight4 = row.insertCell(3);
	  cellRight4.id ='sel'+iteration;
	  var e4 = document.createElement('input');
	  e4.type = 'checkbox';
	  e4.name='select';
	  e4.id='select'+iteration;
	  cellRight4.appendChild(e4); 
	 
	}
</script>
<script type="text/javascript">
function fillItemId(val,inc){
	if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var item_Id = val.substring(index1,index2);
			var indexForItemName = indexForItemName--;
			var ItemName = val.substring(0,indexForItemName);
		document.getElementById('<%=ITEM_ID%>'+inc).value = item_Id;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('itemName'+i).value==val)
		{
			alert("Item Name already selected...!")
			document.getElementById('itemName'+inc).value=""
			var e=eval(document.getElementById('itemName'+inc)); 
			e.focus();
			return false;
		} }  }
			
}
}
</script>
<script>
function validateChargeCodeForAutoComplete(strValue,inc ) {
 	if(strValue != "" && strValue !="No Items found")
	{ 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		document.getElementById('<%=ITEM_NAME%>'+inc).value="";
		    		document.getElementById('<%=ITEM_ID%>'+inc).value="";
		    		
 					return ;
 			}
		 		for(i=1;i<noOfRecords;i++){
	 			if(noOfRecords != 1){
					if(document.getElementById('<%=ITEM_NAME%>'+i).value==strValue)
					{
						alert("Item already selected...!")
						document.getElementById('<%=ITEM_NAME%>'+noOfRecords).value="";
						var e=eval(document.getElementById('<%=ITEM_NAME%>'+noOfRecords)); 
						e.focus();
						return false;
					} }  }
			
	      	return true;
	      	
 		}else{
 			document.getElementById('<%=ITEM_NAME%>'+inc).value="";
 			document.getElementById('<%=ITEM_ID%>'+inc).value="";
			
 			return false;
 			}
}

</script>
<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	String entryNo="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasDepartment> departmentList = (ArrayList<MasDepartment>)map.get("departmentList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	int hospitalId =0;
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<script type="text/javascript">
	   var icdArray=new Array();
	</script>
<script>
function checkSearchForEntry(){
		if(document.getElementById('<%=ENTRY_ID %>').value == "" && document.getElementById('date').value == "") {
		alert("Please enter value in textfield");
		return false;
}
	else
		return true;
}
</script>
<div id="contentHolder">
<div class="Clear"></div>
<h6>Daily Work Load Entry</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Entry
No.</label> <input type="text" name="<%=ENTRY_ID %>" id="<%=ENTRY_ID %>"
	value="" maxlength="10"
	onkeypress="return submitenter(this,event,'laundry?method=searchDailyWorkLoadEntry','checkSearchForEntry')"
	tabindex="1" /> <label>Entry Date</label> <input type="text"
	class="calDate" id="date" name="<%=DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1"
	validate="Entry Date,date,no"
	onkeypress="return submitenter(this,event,'laundry?method=searchDailyWorkLoadEntry','checkSearchForEntry')" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.search.<%=DATE%>,event)" /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','laundry?method=searchDailyWorkLoadEntry','checkSearchForEntry')"
	tabindex=1 /></form>
</div>
</div>
</div>
<form name="linen" method="post" action="">

<div class="blockFrame"><label class="common"><span>*</span>
Entry No.</label> <input id="<%=ENTRY_NO%>" type="text" name="<%=ENTRY_NO%>"
	value="<%=entryNo %>" validate="Entry No,string,yes" maxlength="10"
	tabindex=1 readonly="readonly" /> <label><span>*</span> Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=ENTRY_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Entry Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.linen.<%=ENTRY_DATE%>,event)" />

<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" /> <input
	type="hidden" value="<%= hospitalId%>" name="hospitalId"
	id="hospitalId" /></div>
<div class="Clear"></div>
<div class="division"></div>
<label class="NoWidth"><span>*</span> Ward/Department</label> <select
	name="<%=DEPARTMENT_ID %>" id="<%=DEPARTMENT_ID %>"
	validate="Department,string,yes">
	<option value="">Select</option>
	<%
				for(MasDepartment masDept: departmentList){
			%>
	<option value="<%=masDept.getId()%>"><%=masDept.getDepartmentName()%></option>
	<%} %>
</select> <input name="" value="" id="temp" type="hidden" /> <input type="button"
	class="buttonDel" value="" onclick="removeRow()" align="right" /> <input
	type="button" class="buttonAdd" value="" onclick="addRow();"
	" align="right" /> <input type="hidden" size="2" value="1"
	name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="tblSample">
	<tr>
		<th scope="col"><span>*</span> Sr No.</th>
		<th scope="col"><span>*</span> Item name</th>
		<th scope="col"><span>*</span> Quantity</th>
		<th scope="col"><span>*</span> Select</th>
	</tr>

	<tbody>
		<tr>
			<%
	int inc=1;
	%>

			<td width="1%"><label class="smalllabel"> 1:</label> <input
				type=hidden name="<%=SR_NO %>" id="<%=SR_NO %><%=inc %>" value="" />
			</td>


			<td><input type="text" align="right" name="<%=ITEM_NAME %>"
				id="<%=ITEM_NAME %><%=inc %>" size="100" value=""
				onblur="fillItemId(this.value,<%=inc %>);" />
			<div id="ac2update"
				style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=ITEM_NAME %><%=inc%>','ac2update','laundry?method=getItemListByAutocomplete',{parameters:'requiredField=<%=ITEM_NAME %>'});
			</script> <input type="hidden" value="" name="<%=ITEM_ID%>"
				id="<%=ITEM_ID%><%=inc %>" /></td>

			<td><input type="text" name="<%=QUANTITY %>"
				id="<%=QUANTITY %><%=inc %>" validate="Quantity,float,no"
				maxlength="5" size="10" /></td>

			<td><input type="checkbox" value="p" name="select"
				id="select<%=inc %>" class="radioCheck" /></td>


		</tr>
	</tbody>
</table>
</div>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />

<div class="Clear"></div>
<div class="bottom">
<div class="Clear"></div>

<input type="button" name="add" id="addbutton" value="Submit"
	class="button"
	onClick="if(checkFilledRow() && inputValue()){submitForm('linen','laundry?method=addDailyWorkLoadEntry');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('linen','laundry?method=editDailyWorkLoadEntry')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('linen','laundry?method=deleteDailyWorkLoadEntry&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%=COMMON_ID%>" value="" /> <input type="hidden"
	value="1" name="hiddenValue" id="hiddenValue" />

<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</form>
</div>

