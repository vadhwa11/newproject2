<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<!--
Code for Logout after session Expired
Code By Mukesh Narayan Singh
Date 19 Aug 2010
 -->

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
function disableKey(event){

  if (!event) event = window.event;

  if (!event) return;


  var keyCode = event.keyCode ? event.keyCode : event.charCode;


  //window.status = keyCode;

  // keyCode for F% on Opera is 57349 ?!



  if (keyCode == 116) {

   window.status = "F5 key detected! Attempting to disabling default response.";

   window.setTimeout("window.status='';", 2000);

   // Standard DOM (Mozilla):

   if (event.preventDefault) event.preventDefault();

   //IE (exclude Opera with !event.preventDefault):

   if (document.all && window.event && !event.preventDefault) {

     event.cancelBubble = true;

     event.returnValue = false;

     event.keyCode = 0;

   }

   return false;

  }

}



document.onkeydown = disableKey; // register listener function

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;

	Box box = HMSUtil.getBox(request);



	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}

  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;

	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int internalIndentId = 0;
	if (box.getInt("internalIndentId")!=0)
	{
		internalIndentId = box.getInt("internalIndentId");
	}
	else if (map.get("newinternalIndentId")!=null)
	{
		internalIndentId = (Integer)map.get("newinternalIndentId");
	}
	int storeDepartmentId = 0;
	if(map.get("storeDepartmentId") != null){
		storeDepartmentId = (Integer)map.get("storeDepartmentId");
	}

	String demandNo="";
	if(map.get(DEMAND_NO)!=null){
		demandNo=(String)map.get(DEMAND_NO);
		box.put(DEMAND_NO,(String)map.get(DEMAND_NO));
	}
	int sizeOfStoreInternalIndentT=0;
	if (map.get("sizeOfStoreInternalIndentT")!=null)
	{
		sizeOfStoreInternalIndentT = (Integer)map.get("sizeOfStoreInternalIndentT");
	}
	List stockList=new ArrayList();
	if (map.get("stockList")!=null)
	{
		stockList = (List)map.get("stockList");
	}
	List<StoreInternalIndentT>storeInternalIndentTList=new ArrayList<StoreInternalIndentT>();
	if (map.get("storeInternalIndentTList")!=null)
	{
		storeInternalIndentTList =(List<StoreInternalIndentT>) map.get("storeInternalIndentTList");
	}
	int pageNo=1;
	if(map.get("pageNo")!=null){
		pageNo=(Integer)map.get("pageNo");
	}
	
	int fromWard =0;
	
	if(request.getParameter("fromWard") != null)
	{
		fromWard = Integer.parseInt(request.getParameter("fromWard"));
	}



%>

<script>

var internalIndentId = <% out.print(internalIndentId);%>
var fromWard = <% out.print(fromWard);%> 

if(internalIndentId != 0)
	{
	var status1="YES"
		//alert("internalIndentId in close="+internalIndentId);
	window.opener.location.href = "stores?method=getDepartmentIndentData&<%=FROM_WARD%>="+fromWard+"&<%=DEMAND_NO%>="+internalIndentId+"&status1="+status1;

	}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {
	indentForm.currPage.value = pidx;
	indentForm.method="post";
	var internalIndentId = document.indentForm.internalIndentId.value;
	submitForm('indentForm','stores?method=showAddDepartmentIndentJsp&internalIndentId='+internalIndentId);
}

function jsSubmit()
{
		indentForm.method="post";
		var internalIndentId = document.indentForm.internalIndentId.value;
		submitForm('indentForm','stores?method=showAddDepartmentIndentJsp&internalIndentId='+internalIndentId);
}
function getOtherItemsForDepartmentIndent(val)
{
     //alert("get other")
	 indentForm.method="post";
	 var counterValue=document.getElementById("counterValue").value

	 var nomenclature=document.getElementById("nomenclature"+val).value;
	 //alert("val"+val);
	 //for(var i=parseInt(counterValue)+1;i<(parseInt(counterValue)+14);i++){  // comment by javed khan
	for(var i=parseInt(counterValue);i<(parseInt(counterValue)+14);i++){
	 if(document.getElementById("nomenclature"+i)!=null){
		
	 if(document.getElementById("nomenclature"+i).value!='' && document.getElementById("nomenclature"+i).value==nomenclature && i!=val){

	 alert("Item is already Selected");
	 document.getElementById("nomenclature"+val).value="";
	 return false;
	 }
	 }
	 }

	   var index1 = nomenclature.lastIndexOf("[");
	        index1++;

	      var index2 = nomenclature.lastIndexOf("]");
	       var pvmsNo = nomenclature.substring(index1,index2);
	    
	   var fromWard=document.indentForm.<%= FROM_WARD%>.value;
	  var toWard=document.indentForm.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
		   // alert("pvmsNo");
	ajaxFunctionForGetOtherItemsForDepartmentIndent('indentForm','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=FROM_WARD%>='+fromWard+'&<%=TO_WARD%>='+toWard+''   , val);

	}}



// add javed khan 

function getOtherItemsForDepartmentIndent1(val)
{
	 indentForm.method="post";
	 var counterValue=document.getElementById("counterValue").value

	 var pvms=document.getElementById("pvms"+val).value;
	 for(var i=parseInt(counterValue);i<(parseInt(counterValue)+14);i++){
	
	 if(document.getElementById("pvms"+i)!=null){
		
	 if(document.getElementById("pvms"+i).value!='' && document.getElementById("pvms"+i).value==pvms && i!=val){
		
	 alert("MAT Code is already selected.");
	 document.getElementById("pvms"+val).value="";
	 return false;
	 }
	 }
	 }

	 var pvmsNo=document.getElementById("pvms"+val).value;
	    
	   var fromWard=document.indentForm.<%= FROM_WARD%>.value;
	  var toWard=document.indentForm.<%= TO_WARD%>.value;
	  
	    if(pvmsNo!=""){
		  
	ajaxFunctionForGetOtherItemsForDepartmentIndent('indentForm','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=FROM_WARD%>='+fromWard+'&<%=TO_WARD%>='+toWard+''   , val);

	}}





function ajaxFunctionForGetOtherItemsForDepartmentIndent(formName,action,rowVal)
{
	//alert("Hello");
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
    var url=action
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	      var au=item.getElementsByTagName("au")[0];
	      var stock=item.getElementsByTagName("stock")[0];
	        var name  = item.getElementsByTagName("name")[0];
        	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
        	document.getElementById('pvms'+rowVal).value =  pvms.childNodes[0].nodeValue ;
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue ;
        	document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue ;
        	document.getElementById('qtyRequest'+rowVal).value = 0 ;
        	document.getElementById('au'+rowVal).value =  au.childNodes[0].nodeValue ;
      }
    }
  }
}
function validateButton()
{
	if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < document.indentForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	alert("Please fill atleast one row.")
	return false;
}

function jsNext()
{
		indentForm.method="post";
		
		var internalIndentId = document.indentForm.internalIndentId.value;
		var deptId = document.indentForm.<%= FROM_WARD%>.value;
		var toDept = document.indentForm.<%= TO_WARD%>.value;
		var demandNo = document.indentForm.<%= DEMAND_NO%>.value;
		var demandDate = document.indentForm.<%= DEMAND_DATE%>.value;
		var pageNo=parseInt(document.indentForm.pageNo.value)+1;
        
        if(pageNo<3)
        {    
          for(var i=1;i<=14;i++)
		  {
			 if(document.getElementById('nomenclature'+i).value=="")
		     {
			     alert("First Fill All Rows");
			     return false;
		      }
		   }
         }else if(pageNo<4)
         {
        	 for(var i=15;i<=28;i++)
   		  {
   			 if(document.getElementById('nomenclature'+i).value=="")
   		     {
   			     alert("First Fill All Rows");
   			     return false;
   		      }
   		   }
         }	      
		submitForm('indentForm','stores?method=doAddInternalIndentItems&internalIndentId='+internalIndentId + '&pageNo='+pageNo+'&<%=FROM_WARD%>=' + deptId + '&<%=TO_WARD%>=' + toDept + '&<%=DEMAND_NO%>=' + demandNo+ "&<%=DEMAND_DATE%>="+demandDate);

}
function jsPrevious(){
if(document.indentForm.pageNo.value!=1){
		indentForm.method="post";

			var internalIndentId = document.indentForm.internalIndentId.value;
		var deptId = document.indentForm.<%= FROM_WARD%>.value;
		var toDept = document.indentForm.<%= TO_WARD%>.value;
		var demandNo = document.indentForm.<%= DEMAND_NO%>.value;
		var demandDate = document.indentForm.<%= DEMAND_DATE%>.value;
		var pageNo=parseInt(document.indentForm.pageNo.value)-1;

		submitForm('indentForm','stores?method=showAddDepartmentIndentJsp&internalIndentId='+internalIndentId + '&pageNo='+pageNo+'&<%=FROM_WARD%>=' + deptId + '&<%=TO_WARD%>=' + toDept + '&<%=DEMAND_NO%>=' + demandNo+ "&<%=DEMAND_DATE%>="+demandDate);
}
else{
alert("you are on first page..");
return false;
}
}
function jsAdd()
{
		if(validateButton()){
		indentForm.method="post";
		var internalIndentId = document.indentForm.internalIndentId.value;
		var deptId = document.indentForm.<%= FROM_WARD%>.value;
		var toDept = document.indentForm.<%= TO_WARD%>.value;
		var demandNo = document.indentForm.<%= DEMAND_NO%>.value;
		var demandDate = document.indentForm.<%= DEMAND_DATE%>.value;
		submitForm('indentForm','stores?method=doAddInternalIndentItems&internalIndentId='+internalIndentId + '&<%=FROM_WARD%>=' + deptId + '&<%=TO_WARD%>=' + toDept + '&<%=DEMAND_NO%>=' + demandNo+ "&<%=DEMAND_DATE%>="+demandDate);
		
		
			
		}
}
function Func1Delay()
{
setTimeout("jsClose()", 3000);
}

function jsClose()
{
//var demandNo=indentForm.<%=DEMAND_NO%>.value
var internalIndentId = document.indentForm.internalIndentId.value;

var status1="YES"
	//alert("internalIndentId in close="+internalIndentId);
<%--  window.opener.location.href = "stores?method=getDepartmentIndentData&<%=FROM_WARD%>="+indentForm.<%=FROM_WARD%>.value+"&<%=DEMAND_NO%>="+internalIndentId+"&status1="+status1; --%>
if (window.opener.progressWindow)
{
window.opener.progressWindow.close()
}
window.close();
}

</script>
<div class="titleBg">
<h2>Department Indent Addition</h2>
</div>
<div class="clear"></div>
<form name="indentForm">
<input type="hidden" name="numOfRows"	size="5" value="15">
<input type="hidden" name="pageCount"	size="5" value="10">
<input type="hidden" name="search" size="5"	value="true">
<input type="hidden" name="internalIndentId"	id="internalIndentId" value="<%=internalIndentId%>" />
<input	type="hidden" name="<%=FROM_WARD %>" value="<%=box.get(FROM_WARD) %>" />
<input type="hidden" name="<%=TO_WARD %>" value="<%=box.get(TO_WARD) %>" />
<input type="hidden" name="<%=DEMAND_NO %>"	value="<%=box.get(DEMAND_NO) %>" />
<input type="hidden" name="<%=DEMAND_DATE%>" value="<%=box.get(DEMAND_DATE) %>" />
<input	type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input	type="hidden" name="storeDepartmentId" id="storeDepartmentId"	value="<%=storeDepartmentId%>" />
<input type="hidden" name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" value="<%=box.get(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT) %>" />
<input	type="hidden" name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" value="<%=box.get(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT) %>" />
<input	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<h4>Item Details</h4>
<div class="clear"></div>
<div class="Cmntable">
<table width="100%" colspan="7" border="00" cellpadding="0"	cellspacing="0">
	<tr>
		<th>Sl  No.</th>
		<th>MAT Code</th>
		<th>Nomenclature</th>
		
		<th>A/U</th>
		<th>Available Stock</th>
		<th>Qty Demanded</th>
		<th>Reason for Demand</th>
		<th>Add</th>

	</tr>

	<%
  String nomenclature="nomenclature";
  String au="au";
  String pvms="pvms";
  String stock="stock";
  String qtyRequest="qtyRequest";
  String itemId="itemId";
  String reason="reason";


			int counter1=(pageNo-1)*14+1;
			int t=1;
			    for(int counter=counter1 ;counter<(counter1+14);counter++)
			    {

			    %>
	<tr>

		<%
		if(sizeOfStoreInternalIndentT>0 && sizeOfStoreInternalIndentT>=counter){ %>
		<td><input type="text" value="<%=counter%>" disabled="disabled"
			name="srno" readonly="readonly" size="2" /></td>
			
			<td><input type="text" size="6"
			value="<%=storeInternalIndentTList.get(t-1).getItem().getPvmsNo() %>"
			 name="pvms" id="<%=pvms+counter  %>" onblur="getOtherItemsForDepartmentIndent1(<%=counter %>);"/></td>

		<td><input type="text" tabindex="2" size="50"
			value="<%=storeInternalIndentTList.get(t-1).getItem().getNomenclature() %>"
			name="nomenclature" id="<%=nomenclature+counter %>"
			onblur="getOtherItemsForDepartmentIndent(<%=counter %>);" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		new Ajax.Autocompleter('<%="nomenclature"+""+counter %>','ac2update','stores?method=getItemListForIndent',{parameters:'requiredField=<%=nomenclature%>&internalIndentId='+document.getElementById('internalIndentId').value+'&storeDepartmentId='+document.getElementById('storeDepartmentId').value+'&demandNo='+document.indentForm.<%= DEMAND_NO%>.value+'&from_ward='+document.indentForm.<%= FROM_WARD%>.value+''});
</script></td>
		<!--  <td><input type="text" size="6"
			value="<%=storeInternalIndentTList.get(t-1).getItem().getPvmsNo() %>"
			disabled="disabled" name="pvms" id="<%=pvms+counter %>" /></td> -->
			
			

		<td><input type="text" size="6" disabled="disabled"
			value="<%=storeInternalIndentTList.get(t-1).getItem().getItemConversion().getPurchaseUnit().getUnitName() %>"
			name="au" id="<%="au"+""+counter %>" 
			readonly="readonly" /></td>
		<td><input type="text" size="6"
			value="<%=storeInternalIndentTList.get(t-1).getStockInHand() %>"
			class="readOnly" readonly="readonly" id="<%=stock+counter %>"
			name="stock" validate="Stock In Hand,String,no" /></td>
		<%-- <td><input type="text" value="<%=(gridData[i].get("qtymmf")==null)?"0":gridData[i].get("qtymmf")%>"  readonly="readonly"  name="qtymmf" /> </td>--%>
		<%--<td><input type="text" value="<%=(gridData[i].get("loanOut")==null)?"0":gridData[i].get("loanOut")%>"  readonly="readonly"  name="loanOut" />  </td>--%>
		<td><input type="text" size="5"
			value="<%=storeInternalIndentTList.get(t-1).getQtyRequest() %>"
			name="qtyRequest" id="<%=qtyRequest+counter %>"
			validate="Requested Qty,num,no"
			onchange="setCheckbox(<%=qtyRequest+counter %>,<%=ITEMS_TO_BE_ADDED%>,<%=counter %>);" />
		</td>
		<%if(storeInternalIndentTList.get(t-1).getReasonForDemand()!= null){ %>
		<td><input type="text" size="32"
			value="<%=storeInternalIndentTList.get(t-1).getReasonForDemand() %>"
			name="reason" id="<%=reason+counter %>"
			validate="reasonForDemand,String,no"
			 />
		</td>
		<%}else{ %>
		<td><input type="text" size="32"
			value=""
			name="reason" id="<%=reason+counter %>"
			validate="reasonForDemand,String,no"
			 />
		</td>
		<%} %>
		
		<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
			id="<%=ITEMS_TO_BE_ADDED+counter%>" value="" disabled
			class="radioCheck" /></td>
		<input type="hidden" value="" name="itemId"
			id="<%=itemId+counter %>" />
		<%}
else{
	%>
		<td><input type="text" tabindex="1" disabled value="<%=counter%>"
			name="srno"  readonly="readonly" size="2" /></td>
			<td><input type="text" size="6" tabindex="1"  value=""
			name="pvms" id="<%=pvms+counter %>" onblur="getOtherItemsForDepartmentIndent1(<%=counter %>);"/></td>
		<td><input type="text"  size="50" value="" tabindex="1" name="nomenclature"
			id="<%=nomenclature+counter %>"
			onblur="getOtherItemsForDepartmentIndent(<%=counter %>);" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
new Ajax.Autocompleter('<%="nomenclature"+""+counter %>','ac2update','stores?method=getItemListForIndent',{parameters:'requiredField=<%=nomenclature%>&internalIndentId='+document.getElementById('internalIndentId').value+'&storeDepartmentId='+document.getElementById('storeDepartmentId').value+'&toWard='+document.indentForm.<%=TO_WARD%>.value+'&from_ward='+document.indentForm.<%= FROM_WARD%>.value+''});
</script></td>
		<!-- <td><input type="text" size="6" tabindex="1" disabled value=""
			name="pvms" id="<%=pvms+counter %>" /></td> -->


		<td><input type="text" size="6" tabindex="1" disabled value=""
			name="au" id="<%="au"+""+counter %>" 
			readonly="readonly" /></td>
		<td><input type="text" size="6" class="readOnly"
			readonly="readonly" tabindex="1" value="" id="<%=stock+counter %>"
			name="stock" validate="Stock In Hand,Intger,no" /></td>
		<td><input type="text" tabindex="1" value="" maxlength="8"
			name="qtyRequest" size="5" id="<%=qtyRequest+counter %>"
			validate="Requested Qty,num,no"
			onchange="setCheckbox(<%=qtyRequest+counter %>,<%=ITEMS_TO_BE_ADDED+counter%>,<%=counter %>);" />
		</td>
		<td><input type="text" tabindex="1" value="" size="32" name="reason"  id="<%=reason+counter %>"
			validate="reasonForDemand,String,no" />
			</td>
		
		
		

		<td><input type="checkbox" tabindex="1"
			name="<%=ITEMS_TO_BE_ADDED%>" id="<%=ITEMS_TO_BE_ADDED+counter%>"
			value="" class="radioCheck" /></td>
		<%-- <td><input type="text" value="<%=(gridData[i].get("qtymmf")==null)?"0":gridData[i].get("qtymmf")%>"  readonly="readonly"  name="qtymmf" /> </td>--%>
		<%--<td><input type="text" value="<%=(gridData[i].get("loanOut")==null)?"0":gridData[i].get("loanOut")%>"  readonly="readonly"  name="loanOut" />  </td>--%>
		<input type="hidden" value="" name="itemId"
			id="<%=itemId+counter %>" />


		<% }%>
	</tr>
	<%  t++;} %>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="next" onClick="jsNext()" value="Next" class="button"/>
<input type="button" name="previous"	onClick="jsPrevious()" value="Previous" class="button"/>
<!-- <input	type="button" name="Add" onClick="jsAdd()" value="Submit" class="button" /> -->
<input type="button" name="Add" onClick="jsAdd()" value="Update" class="button" />
<input type="button" name="Close"	onClick="jsClose()" value="Close" class="button" />
<input type="hidden" name="counterValue" id="counterValue"	value="<%=	(pageNo-1)*14+1    %>">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
function setCheckbox(qty, itemCheckbox, counter)
{
//alert("vvvvv "+qty.value);
if(parseInt(qty.value)>0)
{
//alert("itemCheckbox+counter "+ itemCheckbox.checked);
itemCheckbox.checked=true;
//alert("itemCheckbox+counter "+ itemCheckbox.checked);
}
else
{
//alert("itemCheckbox+counter "+ itemCheckbox.checked);
itemCheckbox.checked=false;
//alert("itemCheckbox+counter "+ itemCheckbox.checked);
}

}


</script>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="pageNo" id="pageNo" value="<%= pageNo%>" /></form>
