<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.WorkLoadEntry"%>
<%@page import="jkt.hms.masters.business.WorkLoadEntryDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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
	  var e0 = document.createTextNode(iteration);
	   e0.type = 'label';
	  e0.innerHTML = iteration+':'
	 e0.className = 'smalllabel'
	  cellRight0.appendChild(e0);
	 
	  
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.onblur=function(){
	  			validateChargeCodeForAutoComplete(this.value,iteration)
	   };
	  sel.name = 'itemName';
	  sel.id = 'itemName' + iteration;
	  sel.size = '90';
	  cellRightSel.appendChild(sel);
	new Ajax.Autocompleter('itemName'+ iteration,'ac2update','laundry?method=getItemListByAutocomplete',{parameters:'requiredField=itemName'+ iteration });
	 
	  	
	  cellRightSel.id='itm'+iteration;
	  var sel1 = document.createElement('input');
	  sel1.type = 'text';
	  sel1.name='itemId';
	  sel1.id='itemId'+iteration
	  sel1.size = '10'
	  sel1.maxlength="5"
	  cellRightSel.appendChild(sel1);
	    
	  var cellRightSel2 = row.insertCell(1);
	  var sel2 = document.createElement('input');
	  sel2.type = 'text';
	  sel2.name='quantity';
	  sel2.tabIndex="1";
	  sel2.id='quantity'+iteration
	  sel2.maxlength="5"
	  sel2.validate = "Quantity,float,no"
	  cellRightSel2.appendChild(sel2);
	 
	  var cellRight4 = row.insertCell(2);
	  cellRight4.id ='sel'+iteration;
	  var e4 = document.createElement('input');
	  e4.type = 'checkbox';
	  e4.name='select';
	  e4.id='select'+iteration;
	  cellRight4.appendChild(e4); 

	}
</script>
<script>
function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValue').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('departmentId'+i).value == ""){
	  				alert("Please Select department");
	  				return false;
	  			}
	  			if(document.getElementById('<%=ITEM_ID %>'+i).value == ""){
	  				alert("Please Enter Item Name.");
	  				return false;
	  			}
	  			if(document.getElementById('quantity'+i).value == ""){
	  				alert("Please Enter Quantity");
	  				return false;
	  			}
	  			if(document.getElementById('select'+i).value == false){
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
		document.getElementById('itemId'+inc).value = item_Id;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('itemName'+i).value==val)
		{
			alert("Item Name already selected...!")
			document.getElementById('itemName'+inc).value=""
			var e=eval(document.getElementById('itemName'+inc)); 
			e.focus();
			return false;
			}
		
		}  }
			
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
		 		for(i=1;i<inc;i++){
	 			if(inc != 1){
					if(document.getElementById('<%=ITEM_NAME%>'+i).value==strValue)
					{
						alert("Item already selected...!")
						document.getElementById('<%=ITEM_NAME%>'+inc).value=""
						var e=eval(document.getElementById('<%=ITEM_NAME%>'+inc)); 
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
	WorkLoadEntry work = new WorkLoadEntry();
	ArrayList<MasDepartment> departmentList = (ArrayList<MasDepartment>)map.get("departmentList");
	ArrayList<WorkLoadEntry> workLoadList =  new ArrayList<WorkLoadEntry>();
	List<WorkLoadEntryDetail> workLoadDetailList = new ArrayList<WorkLoadEntryDetail>();
	if(map.get("workLoadList") != null){
		workLoadList=	(ArrayList<WorkLoadEntry>)map.get("workLoadList");
	}
	System.out.println("workLoadList.size() in jsp >>  " + workLoadList.size());
	 if(workLoadList != null && workLoadList.size()>0)
	   {
		   work = (WorkLoadEntry) workLoadList.get(0);
			
		}
	 else{%>
No Records Found..
<% }
	 if(map.get("workLoadDetailList") != null){
		 workLoadDetailList = (ArrayList<WorkLoadEntryDetail>)map.get("workLoadDetailList");
	 }
	 System.out.println("workLoadDetailList.size() in jsp >>  " + workLoadDetailList.size());
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
    function removeRow()
	{
	  var tbl = document.getElementById('amcDetailId');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("Unfit Explanation should have at least one row");
	  
	}
	
	  
	
	</script>

<div id="contentHolder">
<div class="Clear"></div>
<h6>Daily Work Load Entry</h6>
<div class="Clear"></div>

<form name="linen" method="post" action="">

<div class="header"><label class="common"><span>*</span>
Entry No</label> <%if(work.getEntryNo() != null){ %> <input id="<%=ENTRY_NO%>"
	type="text" name="<%=ENTRY_NO%>" value="<%=work.getEntryNo() %>"
	validate="Entry No,string,yes" maxlength="10" tabindex=1
	readonly="readonly" /> <%}else{ %> <input id="<%=ENTRY_NO%>" type="text"
	name="<%=ENTRY_NO%>" value="<%=entryNo %>"
	validate="Entry No,string,yes" maxlength="10" tabindex=1
	readonly="readonly" /> <%} %> <label><span>*</span> Date</label> <%if(work.getEntryDate() != null){ %>
<input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>"
	value="<%=HMSUtil.convertDateTypeToStringWithoutTime(work.getEntryDate())%>"
	readonly="readonly" MAXLENGTH="30" /> <%}else{ %> <input type="text"
	class="calDate" id="fromDateId" name="<%=ENTRY_DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" /> <%} %> <%if(work.getDepartment() != null){ %>
<input type="hidden" value="<%= work.getDepartment().getId()%>"
	name="deptId" id="deptId" /> <%} %> <%if(work.getHospital() != null){ %> <input
	type="hidden" value="<%= work.getHospital().getId()%>"
	name="hospitalId" id="hospitalId" /> <%} %> <input type="hidden"
	name="workId" id="workId" value="<%=work.getId() %>" /></div>
<div class="Clear"></div>




<input name="" value="" id="temp" type="hidden" /> <input type="button"
	class="cmnButton" value="Add Row"
	onclick="generateRowMedicalBoard('amcDetailId');" align="right" /> <input
	type="button" class="cmnButton" value="Delete Row"
	onclick="removeRow();" align="right" /> <input type="hidden" size="2"
	value="" name="noOfRecords" id="noOfRecords" />
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="amcDetailId">
	<tr>

		<th scope="col"><span>*</span> Ward/Department</th>
		<th scope="col"><span>*</span> Item name</th>
		<th scope="col"><span>*</span> Qty</th>
		<th scope="col"><span>*</span> Select</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tbody>
		<% int depId=0;
	for(WorkLoadEntryDetail wrkDetail :workLoadDetailList){ 
	depId= wrkDetail.getDepartment().getId();

	%>
		<tr>



			<td><select name="<%=DEPARTMENT_ID %>"
				id="<%=DEPARTMENT_ID %><%=inc%>" class="large"
				validate="Family,string,yes">
				<option value="">Select</option>
				<%
				for(MasDepartment masDept: departmentList){
					if(depId == masDept.getId()){
			%>
				<option value="<%=masDept.getId()%>" selected="selected"><%=masDept.getDepartmentName()%></option>
				<%}else{ %>
				<option value="<%=masDept.getId()%>"><%=masDept.getDepartmentName()%></option>
				<%}} %>
			</select> <% 
	    		MasDepartment  masDept = new MasDepartment();
	    		  
			         for (int i = 0; i < departmentList.size(); i++) {
			        	 masDept = (MasDepartment) departmentList.get(i);
     			 %> <script>
	    	  
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masDept.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masDept.getDepartmentName()%>";
            </script> <% }%>
			</td>

			<td>
			<%if(wrkDetail.getLinenWeight()!= null){ %> <input type="text"
				size="90" name="<%=ITEM_NAME %>" id="<%=ITEM_NAME %><%=inc%>"
				value="<%=wrkDetail.getLinenWeight().getItemName() %>"
				onblur="validateChargeCodeForAutoComplete(this.value,<%=inc%>);" />
			<input type="hidden" name="<%=ITEM_ID%>" id="<%=ITEM_ID%><%=inc%>"
				value="<%=wrkDetail.getLinenWeight().getId() %>" /> <%}else{ %> <input
				type="text" align="right" name="<%=ITEM_NAME %>"
				id="<%=ITEM_NAME %><%=inc%>" size="90" value=""
				onblur="validateChargeCodeForAutoComplete(this.value,<%=inc %>);" />
			<div id="ac2update"
				style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=ITEM_NAME %><%=inc%>','ac2update','laundry?method=getItemListByAutocomplete',{parameters:'requiredField=<%=ITEM_NAME %>'});
			</script> <input type="hidden" value="" name="<%=ITEM_ID%>"
				id="<%=ITEM_ID%><%=inc%>" /> <%} %>
			</td>

			<td><input type="hidden" value="<%=wrkDetail.getId() %>"
				id="wrkDetailId" name="wrkDetailId" /> <%if(wrkDetail.getQuantity() != null){ %>
			<input type="text" name="<%=QUANTITY %>" id="<%=QUANTITY %><%=inc%>"
				value="<%=wrkDetail.getQuantity() %>" maxlength="5"
				validate="Quantity,float,no" /> <%}else{ %> <input type="text"
				name="<%=QUANTITY %>" id="<%=QUANTITY %><%=inc%>" maxlength="5"
				validate="Quantity,float,no" /> <%} %>
			</td>

			<td>
			<%if(wrkDetail.getSelectStatus().equalsIgnoreCase("y")){ %> <input
				type="checkbox" value="y" name="select" id="select<%=inc%>"
				class="radio" checked="checked" /> <%}else{ %> <input type="checkbox"
				value="p" name="select" id="select<%=inc%>" class="radio" /> <%} %>
			</td>


		</tr>
		<%	inc++;} %>
	</tbody>
</table>
</div>

<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
<div class="Clear"></div>
<div class="bottom">
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Update"
	class="button"
	onClick="if(checkFilledRow){submitForm('linen','laundry?method=editDailyWorkLoadEntry');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('linen','laundry?method=editDailyWorkLoadEntry')"
	accesskey="u" tabindex=1 /> <input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%=COMMON_ID%>" value="" /> <input
	type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

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

