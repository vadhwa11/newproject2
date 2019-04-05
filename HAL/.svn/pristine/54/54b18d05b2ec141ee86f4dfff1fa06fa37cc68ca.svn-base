<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * issueToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for Issue to Dispensary Manual.
 * @author  Deepti
 * @author  Vivek
 * Create Date: 12st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreLoanoutExpendM"%>
<%@page import="jkt.hms.masters.business.StoreLoanOutM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
	<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script language="javascript">
	
	function checkForIssueToLoanout(val,a,inc)
	{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*20)+1;
    	//var end=((pageNo-1)*20)+20;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);	    
	    ajaxFunctionForAutoCompleteIssueToDispensary('equipmentLoanoutEntry','neStores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
	   
	   
	    /* for(i=start;i<=end;i++)
	    {
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms)
	    {
		    if(document.getElementById('codeItem'+inc).value!=pvms)
		    {
		    	alert("Item already selected...!")
		    	document.getElementById('nameItem'+inc).value=""
		    	return false;
		    } 
	    }
	    } */
	    
		
}
	
	</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
Map map = new HashMap();
int pageNo=1;
List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<StoreLoanOutM> storeLoanOutMList = new ArrayList<StoreLoanOutM>();
Box box=HMSUtil.getBox(request);
if (request.getAttribute("map") != null) 
{
map = (Map) request.getAttribute("map");

}

if(map.get("storeLoanOutMList")!=null)
{

	storeLoanOutMList = (List) map.get("storeLoanOutMList");
	System.out.println("storeLoanOutMList--->"+storeLoanOutMList.size());
}
if(map.get("employeeList")!=null)
{
	employeeList = (List) map.get("employeeList");
}
if(map.get("departmentList")!= null)
 {
	departmentList = (List)map.get("departmentList");
 }
if(map.get("pageNo")!=null)
	pageNo = Integer.parseInt(""+map.get("pageNo"));

%>
<div id="searchBlock" style="display:none;">
 <form name="loanoutSearch" method="post" action="">
 <div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="Block">
		<label>Loan Out No.</label> <select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>">
			<option value="">Select</option>
			<%for (StoreLoanOutM storeLoanOut :storeLoanOutMList ) {%>
			<option value=<%=storeLoanOut.getId()%>><%=storeLoanOut.getIssueNo()%></option>
			<%}%>
		</select>
		
		<input type="button" name="sss" class="button" value="SEARCH"  onClick="submitForm('loanoutSearch','neStores?method=searchEquipmentLoanOut');" />
		<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />
		

</div>
</form>
</div>
<div class="clear"></div>
<form name="equipmentLoanoutEntry" method="post">
<%if(box.get("issueId").equals("")){ %> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
	
<h2>Loan Out Entry </h2>
<div class="clear"></div>
<div class="Block">
<label>Loan Out No.</label>
<input type="text" value="" size="8"  name="issueNo" id="issueNo"  validate="Loan Out No,metachar,yes" onblur="fillLoanOutNo(this.value);"/>
<label>Loan Out Date</label>
<input type="text" value="<%=currentDate%>" size="15" id="issueDate" name="issueDate" validate="Loan Out Date,date,yes" />
<label>IssuedTo</label>
<select name="issuedTo" id="issuedTo"  validate="Issued To,metachar,yes">
<option value="0">Select</option>

<%for(MasDepartment masDepartment:departmentList){ %>
<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName() %></option><%} %>
</select>
<div class="clear"></div>
<label>Issued By</label>
<select name="issuedBy"id="issuedBy" validate="Issued By,metachar,yes">

<option value="0">Select</option>
<%
for(MasEmployee masEmployee:employeeList){%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
<%}%>
</select>
<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="noOfRows" value="22" />
</div>
<div class="division"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" /> 
<script type="text/javascript">
		document.getElementById('noOfRecords').value='';
</script>
<div class="cmntable">
<table name="equipmentLoanoutEntry" id="equipmentLoanoutEntry"  width="200px" col="9" class="grid_header" border="1" cellpadding="0" cellspacing="0">
<tr>
<th width="5%">Sl No</th>
<th width="8%">PVMS NIV No</th>
<th width="">Nomenclature</th>
<th width="15%">Serial No</th>
<th width="9%">A/U</th>
<th width="9%">Available Stock</th>
<th width="9%">Loan Out Qty</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int inc=0;
inc = inc+1;
String nameItem="";
String codeItem="codeItem";
int temp=0;
String idAu="idAu";
String idItem="idItem";
%>

<tr>

<input type="hidden" name ="srNo" id="srNo" value=<%=inc%>  />
<td>
<input type="text" name="slNo<%=inc%>" class="auto" tabindex="1" size="2" type="text" value=<%=inc%> />

</td>
<td>
<input type="text" size="8" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%><%=inc %>" />
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="idItem<%=inc %>" />
</td>
<td width="10%">
 <input type="text" size="60" value="" name="<%=nameItem%><%=inc%>" id="<%=nameItem%><%=inc %>" onblur="checkForEquipmentLoanOut(this.value, '<%=nameItem%>',<%=inc %>);"></input>
			      <div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem%><%=inc%>','ac2update','neStores?method=getItemListForEquipmentLoanOut',{parameters:'requiredField=<%=nameItem%><%=inc%>'});
			</script>
</td>
<td>
<select name="<%=RequestConstants.BATCH_NO%>" id="batchIdd<%=inc %>" >
<option value="0">Select Batch</option></select>
<input type="hidden" name="batchId" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
</td>
<td> 
<input type="text"	value=""  name="<%=RequestConstants.AU%>" id="<%=idAu %><%=inc %>"  size="7" tabindex="2" />
</td>
<td><input type="text" name="availableStock" size="8"  id="availableStock<%=inc%>"/> </td>
<td><input type="text" name="<%=QTY_ISSUED %>" size="8" id="<%=QTY_ISSUED%><%=inc%>" onblur="checkQty(<%=inc%>);" /></td>
<td><input type="button" name="add"  class="buttonAdd" value="" onclick="generateRow('equipmentLoanoutEntry');"  /></td>
<td><input type="button" name="delete" value=""  class="buttonDel" onclick="removeRow();"  /></td>
</tr>
<input type="hidden" name="counter" id="count"	value="<%=inc%>" />
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="SUBMIT" value="SUBMIT" onClick="if(checkFilledRow()){submitForm('equipmentLoanoutEntry','neStores?method=addBrandDetailsForEquipLoanOut');}" />
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<div class="clear" ></div>
<script type="text/javascript">
var batchArray=new Array();
</script>
<script type="text/javascript">
function checkFilledRow(){
	  var hdb = document.getElementById('count').value;
	var rowCounter = 1;
	var filledFlag = false;
	while(rowCounter <= hdb){
		if(document.getElementById('codeItem'+ rowCounter).value != ''){
			filledFlag = true;
			break;
		}
		rowCounter++;
	}
	if(filledFlag == true){
		return true;
	}else{
		alert("Please fill atleast one row to submit.");
		return false;
	}
	
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	return true;
	  
	  }
	
	 document.getElementById('submitButton').disabled = true;
	 }

function generateRow(idName) {
    	
	  
	  var tbl = document.getElementById('equipmentLoanoutEntry');
	  var lastRow = tbl.rows.length;	 
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo');	
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='slNo'+iteration;
	  e0.id='slNo'+iteration
	  e0.value=iteration;	  
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.name = '<%=ITEM_CODE %>'+ iteration ;
	  e1.id = '<%=codeItem%>' + iteration;
	   e1.type='text'
	   e1.size='8'	  
	   var e44= document.createElement('input');
	   e44.name = '<%=ITEM_ID %>' ;
	   e44.id = '<%=idItem%>' + iteration;
	   e44.type='hidden'
		e44.size='2'	 
	cellRight1.appendChild(e44); 
	  cellRight1.appendChild(e1);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.name= '<%=nameItem%>'+iteration;
	  e2.id= '<%=nameItem%>'+iteration;
	  e2.type='text'
	  e2.size='60'	  
	  e2.onblur=function(){

		if(checkForitem(this.value,iteration)){checkForEquipmentLoanOut(this.value, <%=nameItem%>+iteration,iteration);}

	  };

	  var newdiv1 = document.createElement('div');
	   newdiv1.setAttribute('id', 'ac2update'+iteration);
	   newdiv1.setAttribute('class', 'autocomplete');
	   newdiv1.style.display = 'none';
	   cellRight2.appendChild(newdiv1);
	   cellRight2.appendChild(e2);
	//   new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=principal'+iteration});
	  new Ajax.Autocompleter('<%=nameItem%>'+iteration,'ac2update'+iteration,'neStores?method=getItemListForEquipmentLoanOut',{parameters:'requiredField=<%=nameItem%>'+iteration});
	  
      
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('select');
	  e3.options[0] = new Option('Select', '');
	  e3.name = '<%=BATCH_NO%>';
	  e3.id = 'batchIdd' + iteration;
	  e3.tabIndex="1";
      for(var i = 0;i<batchArray.length;i++ ){
    	  e3.options[batchArray[i][0]] = new Option(batchArray[i][1],batchArray[i][0]);
    	  }

      var e33 = document.createElement('input');
	  e33.name='batchId';
	  e33.id='batchId'+iteration;
	  e33.type='hidden'
	  e33.size='20'  
	  cellRight3.appendChild(e33);
      cellRight3.appendChild(e3);

      var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='<%=AU%>';
	  e4.id='<%=idAu %>'+iteration;
	  e4.type='text'		  
	  e4.size='20'      
      cellRight4.appendChild(e4);
      
      var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.name = 'availableStock';
	  e5.id='availableStock'+iteration;
	  e5.type='text'
	  e5.size='8'	  
      cellRight5.appendChild(e5); 

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name = '<%=QTY_ISSUED %>';
	  e6.id='<%=QTY_ISSUED %>'+iteration;
	   e6.onblur=function(){checkQty(iteration);};
	  e6.type='text'
	  e6.size='8'	  
      cellRight6.appendChild(e6);  
	  

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	  e7.name='remarks'+iteration;
	  e7.setAttribute('onClick','generateRow(equipmentLoanoutEntry);');	  
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  e8.name='remarks'+iteration;
	  e8.onclick = function(){removeRow();}
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);
}
function removeRow()
{ 	
  var tbl = document.getElementById('equipmentLoanoutEntry');
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('equipmentLoanoutEntry');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('equipmentLoanoutEntry');
  	hdb.value=iteration
  }
}
function fillValuesForPvms(pvmsNo,rowVal){
	   document.getElementById('nameItem'+rowVal).value="";
	   document.getElementById('idAu'+rowVal).value="";
	    	//ajaxFunctionForAutoCompleteIssueToDispensaryByPvmsNo('issueDispensaryManualForm','stores?method=fillItemsForIssueToDispensaryByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);
	    	ajaxFunctionForAutoCompleteIssueToDispensaryPvms('issueDispensaryManualForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvmsNo , rowVal);
	    
	    
	    }
function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
function ajaxFunctionForAutoCompleteIssueToDispensary(formName,action,rowVal) {
	 
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	    	  
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		       // var name  = item.getElementsByTagName("name")[0];
		       // var BG  = item.getElementsByTagName("BrandG")[0];
		      //  var stock  = item.getElementsByTagName("stock")[0];
		       // var batchLength  = item.getElementsByTagName("batches")[0];
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	//document.getElementById('issuedName'+rowVal).value = name.childNodes[0].nodeValue
	        	
	        	//document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue
	        	//document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	  }
function checkForEquipmentLoanOut(val,a,inc)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    ajaxFunctionForEquipmentLoanOut('equipmentLoanoutEntry','neStores?method=fillItemsForEquipmentLoanOut&pvmsNo=' + pvms , inc);
}


function fillLoanOutNo(obj){	
	var invObj;
<%		
	if(storeLoanOutMList != null && storeLoanOutMList.size() > 0){
		for (StoreLoanOutM storeLoanOutM : storeLoanOutMList) {%>
					 invObj =<%= storeLoanOutM.getIssueNo()%>
					if(invObj == obj){
						alert("Loan Out No. already exists.");
						document.getElementById('issueNo').value="";
						return false;
					}
					<%}}%>

					return true;
		}
 function checkQty(rowVal)
  {
	
  	var val = document.getElementById('qtyIssued'+rowVal).value

  		 if(parseInt(document.getElementById('qtyIssued'+rowVal).value) >= parseInt(document.getElementById('availableStock'+rowVal).value))
  		{
  			alert("Issued Quantity can't be greater than Available stock Quantity .");
  			document.getElementById('qtyIssued'+rowVal).value="";
  			document.getElementById("qtyIssued"+rowVal).focus();
  			return false;
  		}else{
  					
  			return true;
  			
  		}
  	
  }

 function checkForitem(val,inc){
		if(val != "")
		{
			 var index1 = val.lastIndexOf("[");
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvms = val.substring(index1,index2);
		
		if(pvms =="")
		{
	     document.getElementById('codeItem'+inc).value="";
	     document.getElementById('qtyIssued'+inc).value="";
	     document.getElementById('idAu'+inc).value="";
	     document.getElementById('availableStock'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('<%=nameItem%>'+i).value==val)
		{
			alert("Nomenclature already selected...!")
			document.getElementById('<%=nameItem%>'+inc).value=""
			var e=eval(document.getElementById('<%=nameItem%>'+inc)); 
			e.focus();
			return false;
		} }  }
}return true;

 }
function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
	</script>


</form>