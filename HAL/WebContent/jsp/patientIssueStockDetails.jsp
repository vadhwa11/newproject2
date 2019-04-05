<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	int itemId=0;
	int rowVal=0;
	int deptId=0;
	int qtyRequested=0; 
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List listOfItemsInStock= new ArrayList();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	
	if(map.get("listOfItemsInStock")!=null){
		listOfItemsInStock = (List)map.get("listOfItemsInStock");
	
	}
	if(map.get("deptId")!=null){
		deptId = (Integer)map.get("deptId");
	
	}
	if(map.get("rowVal")!=null){
		rowVal = (Integer)map.get("rowVal");
	
	}
	
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>

<h4>Patient Issue Stock Details</h4>
<div class="clear"></div>
<form name="patientIssueStockDetailsForm" method="post">
<%if(listOfItemsInStock.size() > 0){ %> <input type="hidden" name="itemId"
	id="itemId" value="" /> <input type="hidden" name="date" id="date"
	value="" /> <input type="hidden" name="time" id="time" value="" /> <input
	type="hidden" name="ipissueno" id="ipissueno" value="" /> <input
	type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId"
	value="" /> <input type="hidden" name="deptId" id="deptId" value="" />
<input type="hidden" name="hinId" id="hinId" value="" /> <input
	type="hidden" name="admissionNumber" id="admissionNumber" value="" />
<div class="clear"></div>
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>

		<tr>

			<td width="5%"><label>Brand
			Name</label></td>
			<td width="13%"><label>A/U</label>
			</td>
			<td width="10%"><label>Batch
			No</label></td>
			<td width="13%"><label>Exp
			Date</label></td>
			<td width="13%"><label>Cost
			Price</label></td>
			<td width="13%"><label>Stock
			Quantity</label></td>
			<td width="13%"><label>Item
			Issued</label></td>



		</tr>

	</thead>

	<tbody>
		<% 
			
 		 
  					int i=0;
  					Iterator itr= listOfItemsInStock.iterator();
  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 Object[] pair = (Object[]) itr.next();
  			  /*     	 StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
  			         	 BigDecimal qtyInHand = (BigDecimal) pair[0];
  			         	 int pvmsId=storeItemBatchStock.getItem().getId();
  			         	 String pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
  			        	 String nomenclature=storeItemBatchStock.getItem().getNomenclature();
  			         	 int storeItemBatchStockId=storeItemBatchStock.getId();
  			        	 String batchNumber=storeItemBatchStock.getBatchNo();
  			        	 Date expiryDate=storeItemBatchStock.getExpiryDate();
  			        	 if(expiryDate != null)
  			        	 {
  			        	  dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        	 }
  			        	 else
  			        	 {
  			        		dateOfExpiryInString="";
  			        	 }
  			        	 BigDecimal costprice=storeItemBatchStock.getCostPrice();
  			        	 int brandId=storeItemBatchStock.getBrand().getId();
  			        	 String brandName=storeItemBatchStock.getBrand().getBrandName();
  			        	 String au="";
  			        	 if(storeItemBatchStock.getItem().getItemConversion() != null)
  			        	 {
  			        		 au=storeItemBatchStock.getItem().getItemConversion().getItemUnitName();
  			        	 }else{
  			        		 au="";
  			        	 }*/
  			        	 BigDecimal qtyInHand = (BigDecimal) pair[0];
  			         	 int pvmsId=(Integer)pair[1];
  			         	 String pvmsNo=(String)pair[2];
  			        	 String nomenclature=(String)pair[3];
  			         	 int storeItemBatchStockId=(Integer)pair[4];
  			        	 String batchNumber=(String)pair[5];
  			        	 Date expiryDate=(Date)pair[6];
  			        	 if(expiryDate != null)
  			        	 {
  			        	  dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        	 }
  			        	 else
  			        	 {
  			        		dateOfExpiryInString="";
  			        	 }
  			        	 BigDecimal costprice=(BigDecimal)pair[7];
  			        	 int brandId=(Integer)pair[8];
  			        	 String brandName=(String)pair[9];
  			        	 String au="";
  			        	 if((String)pair[10] != null)
  			        	 {
  			        		 au=(String)pair[10];
  			        	 }else{
  			        		 au="";
  			        	 }
 			%>

		<tr>
			<td width="5%"><input type="text" name="brandName<%=i %>"
				class="medcaption" readonly="readonly" value="<%=brandName %>" /> <input
				type="hidden" name="brandId<%=i %>" value="<%=brandId %>" /> <input
				type="hidden" name="storeItemBatchStockId<%=i %>"
				value="<%=storeItemBatchStockId %>" /></td>

			<td width="13%"><input type="text" name="au<%=i %>"
				class="medcaption" readonly="readonly" value="<%=au %>" /></td>

			<td width="10%"><input type="text" name="batchNo<%=i%>"
				class="medcaption" readonly="readonly" value="<%=batchNumber %>" /></td>

			<td width="13%"><input type="text" name="expiryDate<%=i %>"
				class="medcaption" readonly="readonly"
				value="<%=dateOfExpiryInString %>" /></td>

			<td width="13%"><input type="text" name="costprice<%=i %>"
				class="medcaption" readonly="readonly" value="<%=costprice %>" /></td>

			<td width="13%"><input type="text" name="stockQty<%=i %>"
				class="medcaption" readonly="readonly" value="<%=qtyInHand %>" /></td>

			<td width="13%"><input type="text" name="issueQty<%=i%>"
				tabindex="1" id="issueQty<%=i%>" class="medcaption"
				onBlur="validateIssQty('patientIssueStockDetailsForm',this,amount<%= i%>,<%=costprice%>,<%=qtyInHand%>,<%=i %>);" />
			
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>"
				value=" " /></td>
			</tr>
				<%
  	 	i++;
  	   }
  	 %>
			
	</tbody>
</table>
<script type="text/javascript">
				document.getElementById('issueQty1').focus();
			</script>
<div id="edited"></div>
<input id="save" property="save" type="button" tabindex="1" name="save"
	value="Save" class="button"
	onclick="if(setHeaderValuesForPatientIssue(<%=rowVal %>),validatePage('patientIssueStockDetailsForm')){submitForm('patientIssueStockDetailsForm','/hms/hms/ipd?method=submitPatientIssueDetails');}" />
<input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <input
	type="hidden" name="counter" id="counter" value="<%=i %>" />
<%}else{ %> No Records Found!!
<div style="padding-left: 15px;">
<div id="edited"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /></div>
<%} %>
</form>


<script type="text/javascript">

	function validateIssQty(formName,obj,amount,rate,qtyInHand,rowVal){

	element = obj.value
	var amountElement=amount.name
	obj1 = eval('document.'+formName+'.'+amountElement);
	
	nextElement=obj.name;
	
	
  	var issQty=element;
 	if(issQty==""){
		alert('Issue Quantity is blank')
		//document.getElementById('name').focus();
		//document.nursingCareEntryDetail.caretime0.setFocus();
		
		//'document.'+formName+'.'+name+'.setFocus()';
		return true
	}
	if(issQty<=0){
		alert('Issue Quantity is Not Correct')
		
		//document.getElementById('issueQty'+rowVal).focus();
		//eval('document.'+formName+'.issueQty'+rowVal).focus();
		
		//'document.'+formName+'.'+name+'.setFocus()';
		return false
	}
	if(issQty>qtyInHand){
		alert('Issue Quantity Cannot be more than Quantity in Hand')
		
		return false
	}
	
	if(issQty !=""){
		
		if(validateInteger(trimAll(issQty))){
		
		    var issuesQuantity=obj.value
			//var amountElement=amount.name
			//obj1 = eval('document.'+formName+'.'+amountElement);
			obj1.value=rate*issuesQuantity
			//alert("obj1 === "+obj1.value)
			setTotalQtyInParent()
			return true;
		
		}else{
			alert("Please enter the integer value")
			
			return false
		}
	}
	
}
	function validateInteger( strValue ) {
		//alert("in validate integer")
	  var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
	 	return objRegExp.test(strValue);
	}
	
	function validatePage(formName) {
			
			var counter=document.getElementById('counter').value;
			 for(var i = 0; i < counter; i++)
			 {
			
				if( document.getElementById('issueQty'+i).value == "")
				{
				  alert("Please Enter the correct value of Issued Quantity")
				  return false
					
				}
		    }
		return true
		}
		
	function setTotalQtyInParent(){
  		//alert("get Values Method")
		//window.opener.document.getElementById('date').value
		//var qtyIssuedList = document.getElementsByName("qtyIssued");
		var sum = 0;
		for(var index = 0; index < parseInt(document.patientIssueStockDetailsForm.counter.value); index++ ){
			var toEval = "document.patientIssueStockDetailsForm.issueQty" + index;
			var qtyIssuedObj = eval(toEval);
			//alert("Value of qtyIssuedObj:"+qtyIssuedObj)
			if(qtyIssuedObj.value != "")
			{
			sum = sum + parseInt(qtyIssuedObj.value);
			}else
			{
			
				sum=sum;
			}
		}
		//alert("The Sum is" + sum);
		toEval = "window.opener.document.getElementById(\'qtyIssued" + <%=rowVal%> + "\')";
		//alert("to Evaluate:+" + toEval);
		//toEval = "window.opener.document.wardConsumption.qtyIssued";
		var totalQtyIssued = eval(toEval);
		//totalQtyIssued[<%= rowVal - 1%>].value = sum;
		totalQtyIssued.value = sum;
		
		return true
  	}
		
</script>


