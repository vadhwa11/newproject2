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
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<%
	Map map = new HashMap();
	int itemId=0;
	int rowVal=0;
	int deptId=0;
	int qtyRequested=0;
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<StoreItemBatchStock> listOfItemsInStock= new ArrayList<StoreItemBatchStock>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}

	if(map.get("listOfItemsInStock")!=null){
		listOfItemsInStock = (List<StoreItemBatchStock>)map.get("listOfItemsInStock");

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

<form name="stockDetailsForm" method="post">

<input type="hidden" name="itemId" id="itemId" value="" />
<input type="hidden" name="date" id="date" value="" />
<input type="hidden" name="time" id="time" value="" />
<input type="hidden" name="<%=RETURN_NO %>" id="returnNo" value="" />
<input type="hidden" name="<%=RETURN_DATE %>" id="returnDate" value="" />
<input type="hidden" name="<%=REFERENCE_NO %>" id="referenceNo" value="" />
<input type="hidden" name="<%=FROM_WARD %>" id="fromWard" value=" " />
<input type="hidden" name="<%=TO_WARD %>" id="toWard" value=" " />
<input type="hidden" name="<%=RECEIVED_BY_ID %>" id="receiveBy" value="" />
<input type="hidden" name="<%=RETURN_BY_ID %>" id="returnBy" value="" />
<input type="hidden" name="<%=REASON %>" id="reason" value="" />
<input type="hidden" name="<%=REMARKS %>" id="remarks" value="" />
<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="" />
<input type="hidden" name="deptId" id="deptId" value="" />

<table colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>

<tr>
			<%
      int i=0;
		Iterator itr= listOfItemsInStock.iterator();
		if(listOfItemsInStock.size() > 0){

      %>
<th width="5%">Brand Name</th>
<th width="13%">A/U</th>
<th width="10%">Batch No.</th>
<th width="13%">Exp Date</th>
<th width="13%">Cost Price</th>
<th width="13%">Stock Quantity</th>
<th width="13%">Item Returned</th>
</tr>

</thead>
<tbody>
		<%



  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 Object[] pair = (Object[]) itr.next();

  			         	 String pvmsNo=pair[0].toString();

  			         	 int pvmsId=Integer.parseInt(pair[1].toString());
  			         	 int storeItemBatchStockId=Integer.parseInt(pair[2].toString());
  			        	 String nomenclature=pair[3].toString();
                         System.out.println("pair[4].toString()--"+pair[4].toString());
                         String str_date=pair[4].toString();
                        // String e_date=str_date.substring(8)+"/"+str_date.substring(5,7)+"/"+str_date.substring(0,4);
                        // SimpleDateFormat sim=new SimpleDateFormat("dd/mm/yyyy");
  			        	 //Date expiryDate=new Date(e_date);
  			        	 //System.out.println("expiryDate--"+expiryDate);
  			        	 if(pair[4].toString() != null)
  			        	 {
  			        	 // dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        		 dateOfExpiryInString =str_date;
  			        	 }
  			        	 else
  			        	 {
  			        		dateOfExpiryInString="";
  			        	 }

  			        	 int brandId=Integer.parseInt(pair[5].toString());
  			        	 String brandName=pair[6].toString();
  			        	 String batchNumber=pair[7].toString();
  			        	BigDecimal costprice=new BigDecimal(pair[8].toString());
  			        	 String itemUnitName=pair[9].toString();
  			        	BigDecimal qtyInHand = new BigDecimal( pair[10].toString());
  			        	//BigDecimal qtyInHand = new BigDecimal(4);

  			        //	 System.out.println("value of pvms no==="+pvmsNo+"===Batch no==="+batchNumber+"==Brand Name==="+brandName);
  			        //	 System.out.println("value of Nomenclature ==="+nomenclature+"===Expiry date==="+dateOfExpiryInString+"====and Brand Id is=== "+brandId);
 			%>

		<tr>
			<td width="5%">
			<input type="text" name="brandName<%=i %>" size="20" readonly="readonly" value="<%=brandName %>" />
			</td>

			<input type="hidden" name="brandId<%=i %>" value="<%=brandId %>" />
			<input type="hidden" name="storeItemBatchStockId<%=i %>" value="<%=storeItemBatchStockId %>" />

			<td width="13%">
			<input type="text" name="au<%=i %>" size="15" readonly="readonly"	value="<%=itemUnitName %>" />
			</td>

			<td width="10%">
			<input type="text" name="batchNo<%= i%>" size="12" readonly="readonly" value="<%=batchNumber %>" />
			</td>

			<td width="13%">
			<input type="text" name="expiryDate<%=i %>"	 size="12" readonly="readonly"	value="<%=dateOfExpiryInString %>" />
			</td>

			<td width="13%">
			<input type="text" name="costprice<%=i %>"	size="12" readonly="readonly" value="<%=costprice %>" />
				</td>

			<td width="13%">
			<input type="text" name="stockQty<%=i %>" size="12" readonly="readonly" value="<%=qtyInHand %>" />
				</td>

			<td width="13%">
			<input type="text" size="12" name="issueQty<%=i%>" id="issueQty<%=i%>" tabindex=1 onblur="validateIssQty('stockDetailsForm',this,amount<%= i%>,<%=costprice%>,<%=qtyInHand%>,<%=i %>);" />
			</td>
			<script>
  		document.getElementById('issueQty<%=i-i%>').focus();
  	</script>
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>" value=" " />

			<tr />
				<%
  	 	i++;
  	   }}else{
  	 %>

				<tr><td colspan="7"> No Records Found !</td></tr>
				<%} %>

	</tbody>
</table>

<div class="Clear"></div>

<div id="edited"></div>
<input id="save" property="save" type="button" name="save" value="Save"	class="button"	onclick="if(setHeaderValuesForReturnDispensary(<%=rowVal %>),validatePage(stockDetailsForm)){submitForm('stockDetailsForm','/hms/hms/stores?method=submitReturnDispensaryDetails');}" />
<input type="button" name="cancel" id="addbutton" value="Cancel" class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
</form>
</div>
<script type="text/javascript">

	function validateIssQty(formName,obj,amount,rate,qtyInHand,rowVal){

	element = obj.value
	var amountElement=amount.name
	obj1 = eval('document.'+formName+'.'+amountElement);

	nextElement=obj.name;
  	var issQty=element;
 	if(issQty==""){
		alert('Quantity returned is blank')
		return true
	}
	if(issQty<=0){
		alert('Quantity returned is Not Correct')
		return false
	}
	if(issQty>qtyInHand){
		alert('Quantity returned Cannot be more than Quantity in Hand')
		return false
	}

	if(issQty !=""){

		if(validateInteger(trimAll(issQty))){

		    var issuesQuantity=obj.value
			obj1.value=rate*issuesQuantity
			setTotalQtyInParent()
			return true;

		}else{
			alert("Please enter the integer value")

			return false
		}
	}

}
	function validateInteger( strValue ) {
	  var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
	 	return objRegExp.test(strValue);
	}

	function validatePage(formName) {
			var counter=document.getElementById('counter').value;
			formname=formName.name
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')

				if(amountVal == " " && issQtyVal != "")
				{
					alert("Please Enter the correct value in Quantity returned.")
					return false
				}
				if( issQtyVal == " " && amountVal != " ")
				{
				  obj1 = eval('document.'+formname+'.amount'+i);
				  obj1.value="";
				  alert("Please Enter the correct value of  Quantity")
				  return false

				}
		    }
		return true
		}

	function setTotalQtyInParent(){
		var sum = 0;
		for(var index = 0; index < parseInt(document.stockDetailsForm.counter.value); index++ ){
			var toEval = "document.stockDetailsForm.issueQty" + index;
			var qtyIssuedObj = eval(toEval);
			if(qtyIssuedObj.value != "")
			{
			sum = sum + parseInt(qtyIssuedObj.value);
			}else
			{
				sum=sum;
			}
		}
		toEval = "window.opener.document.getElementById(\'qtyIssued" + <%=rowVal%> + "\')";
		var totalQtyIssued = eval(toEval);
		totalQtyIssued.value = sum;

		return true
  	}

</script>



