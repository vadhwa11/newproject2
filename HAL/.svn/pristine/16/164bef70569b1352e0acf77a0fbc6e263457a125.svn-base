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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
	int itemId=0;
	int rowVal=0;
	int deptId=0;
	int qtyRequested=0;
	String serviceNo="";
	String buttonFlag="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List listOfItemsInStock= new ArrayList();

	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}


	String message="";
	String opdIssueMasterId="";
    int qtyPrescription=0;
	if (map.get("message")!=null)
	message = map.get("message").toString();

	if (map.get("opdIssueMasterId")!=null)
		opdIssueMasterId = map.get("opdIssueMasterId").toString();

	String deptName = "";
	if (session.getAttribute("deptName") != null) {
		deptName = (String) session.getAttribute("deptName");
	}
	%>

<script language="JavaScript">
	<% if (message.equals("success")) { %>
		window.opener.document.getElementById('opdIssueMasterId').value='<%=opdIssueMasterId%>';
		self.close();
	<% } %>
	</script>


<%
	if(map.get("listOfItemsInStock")!=null)
	{
		listOfItemsInStock = (List)map.get("listOfItemsInStock");
	}

	if(map.get("deptId")!=null){
		deptId = (Integer)map.get("deptId");
	}

	if(map.get("itemId")!=null){
		itemId = (Integer)map.get("itemId");
	}
	if(map.get("rowVal")!=null){
		rowVal = (Integer)map.get("rowVal");

	}

	if(map.get("buttonFlag")!=null)
	{
		buttonFlag = (String)map.get("buttonFlag");
	}

	if (map.get("serviceNo")!=null)
	{
		serviceNo = (String)map.get("serviceNo");
	}
	if (map.get("qtyPrescription")!=null)
	{
		qtyPrescription =Integer.parseInt(""+map.get("qtyPrescription"));
	}
	//System.out.println("qtyPrescription "+qtyPrescription);
	%>
<script type="text/javascript">
	function cancelForm()
	{
		if(!window.opener.document.getElementById("patientPrescriptionDtId"+<%=rowVal%>)){
			var nomenclature=window.opener.document.getElementById("nomenclature"+<%=rowVal%>);
				nomenclature.value = "";
				nomenclature.disabled = false;
			//var lotNo=window.opener.document.getElementById("lotNo"+<%=rowVal%>);
			//	lotNo.value="";
			//	lotNo.disabled = false;
			var pvmsNo=window.opener.document.getElementById("pvmsNo"+<%=rowVal%>);
				pvmsNo.value="";
			var qtyIssued=window.opener.document.getElementById("qtyIssued"+<%=rowVal%>);
				qtyIssued.value="";
			nomenclature.focus();

			}
	    close();
   	}


</script>
<div id="contentHolder">
<div class="titleBg">
<h2>OPD Patient Issue </h2>
</div>
<div class="Clear"></div>
<div class="Block">
<label>Nomenclature</label>
<label class="valueAuto">&nbsp;<%=box.getString("nomenclature")%></label>
<label>Quantity Prescribed </label>
<label class="valueAuto">&nbsp;<%=qtyPrescription%></label>
</div>
<div class="Clear paddingTop15"></div>
<form name="opdPatientStockDetailsForm" method="post">
<input type="hidden" id="patientPrescriptionId" name="patientPrescriptionId" value="">
<input type="hidden" id="patientPrescriptionDtId" name="patientPrescriptionDtId" value="">
<input type="hidden" id="qtyPrescribed" name="qtyPrescribed" value="">
<input type="hidden" name="opdIssueno" id="opdIssueno" value="" />
<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="" />
<input type="hidden" name="deptId" id="deptId" value="" />
<input type="hidden" name="hinId" id="hinId" value="" />
<input type="hidden" name="empId" id="empId" value="" />
<input type="hidden" name="remarks" id="remarks" value="" />
<input type="hidden" name="prescription" id="prescription" value="" />
<input type="hidden" name="date" id="date" value="" />
<input type="hidden" name="fromDate" id="fromDate" value="" />
<input type="hidden" name="toDate" id="toDate" value="" />
<input type="hidden" name="time" id="time" value="" />
<input type="hidden" name="itemId"	value="<%=itemId%>" id="itemId" />
<input type="hidden" name="serviceNo" value="<%=serviceNo %>">
<input type="hidden" name="flag" id="flag" value="<%=box.getString("flag")%>">
<input type="hidden" name="opdIssueMasterId" id="opdIssueMasterId"	value="<%=box.getString("opdIssueMasterId")%>">

<table width="200" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th width="5%">Brand Name</th>
<th width="13%">A/U</th>
<th width="10%">Batch No</th>
<th width="13%">Exp Date</th>
<th width="13%">Cost Price</th>
<th width="13%">Stock Quantity In Dispensary</th>
<th width="13%">Item Issued</th>
</tr>
<%
System.out.println("It is list of item");
%>
	</thead>
	<tbody>
		<%
		
  					int i=0;
  					Iterator itr= listOfItemsInStock.iterator();
  					int count=0;
  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 Object[] pair = (Object[]) itr.next();

  			         	 String pvmsNo=pair[0].toString();

  			         	 int pvmsId=Integer.parseInt(pair[1].toString());
  			         	 int storeItemBatchStockId=Integer.parseInt(pair[2].toString());
  			        	 String nomenclature=pair[3].toString();
                         //System.out.println("pair[4].toString()--"+pair[4].toString());
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

  				     	 if(qtyInHand.compareTo(new BigDecimal(0)) > 0){
  				     		count++;
 			%>

<tr>
			<td width="5%"><input type="text" name="brandName<%=i %>" size="20" readonly="readonly" value="<%=brandName %>" />
			<input type="hidden" name="brandId<%=i %>" value="<%=brandId %>" />
			<input type="hidden" name="storeItemBatchStockId<%=i %>" value="<%=storeItemBatchStockId %>" /></td>
			<td width="13%"><input type="text" name="au<%=i %>"	size="20" readonly="readonly" value="<%=itemUnitName %>" /></td>
			<td width="10%"><input type="text" name="batchNo<%= i%>" size="10" readonly="readonly" value="<%=batchNumber %>" /></td>
			<td width="13%">
			<input type="text" name="expiryDate<%=i %>"	size="10" readonly="readonly" value="<%=dateOfExpiryInString %>" /></td>
			<td width="13%">
			<input type="text" name="costprice<%=i %>"	size="10" readonly="readonly" value="<%=costprice %>" />
			</td>
			<td width="13%">
			<input type="text" name="stockQty<%=i %>" size="10" readonly="readonly" value="<%=qtyInHand %>" />
			</td>
			<td width="13%">
			<input type="text" name="issueQty<%=i%>" id="issueQty<%=i%>" value="" tabindex="1" size="10"	onblur="validateIssQty('opdPatientStockDetailsForm',this,amount<%= i%>,<%=costprice%>,<%=qtyInHand%>,<%=i %>);" />
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>" value="" />
			</td>			
</tr>
				<%
  	 	    i++;
			}
  	   }
  	 %>
    <input type="hidden" name="qtyPrescription" id="qtyPrescription" value="<%=qtyPrescription %>">
	</tbody>
</table>
<script>
  <% if (listOfItemsInStock!=null && listOfItemsInStock.size()>0)
	  { %>
	  document.getElementById("issueQty0").focus();
  <% } %>
  </script>

<div id="edited"></div>
<div class="Clear"></div>
 <div class="clear"></div>
  <div class="clear"></div>
    <div class="division"></div>
      <div class="clear"></div>
<%
  if (box.getString("flag").equals("C")) {
	  //System.out.println("flag c");
	  %>
	  <input id="save"	property="save" type="button" name="save" value="Save" tabindex="1"	class="button"	onclick="if(setHeaderValuesForDispensaryConsumption(<%=rowVal %>) && validatePage(opdPatientStockDetailsForm)){submitForm('opdPatientStockDetailsForm','/hms/hms/stores?method=submitDispensaryConsumptionStockDetails');}" />
  <% } else {
	  //System.out.println("flag else");
	  %>
  <input id="save" property="save" type="button" name="save"	value="Save" tabindex="1" class="button" onclick="if(setHeaderValuesForOPDPatient(<%=rowVal %>)&& validatePage(opdPatientStockDetailsForm,<%=count %>)){submitForm('opdPatientStockDetailsForm','/hms/hms/stores?method=submitOPDPatientStockDetailsWithBarCode');}" />
<% } %>
<input type="button" name="cancel" id="addbutton" value="Cancel" class="button" onClick="cancelForm();" accesskey="a" />
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
  <div class="clear"></div>
    <div class="division"></div>
      <div class="clear"></div>

</form>
</div>
<script type="text/javascript">

	function validateIssQty(formName,obj,amount,rate,qtyInHand,rowVal)
	{
	element = obj.value

	var amountElement=amount.name
	obj1 = eval('document.'+formName+'.'+amountElement);
	nextElement=obj.name;

  	var issQty=element;

	if (issQty<0)
	{
		alert('Kindly check the Issue Quantity!..... ');
		obj.value="";
		return;
	}

	if(issQty > qtyInHand)
	{
		alert('Issue Quantity Cannot be more than Quantity in Hand')
		obj.value="";
		return;
	}

	if(issQty !="")
	{
		if(validateInteger(trimAll(issQty)))
		{
			
		    var issuesQuantity=obj.value
			obj1.value=rate*issuesQuantity
			//alert("=---obj1--"+issuesQuantity);
			//setTotalQtyInParent()
			return;
		}
		else
		{
			alert("Please enter the integer value")
			obj.value="";
			return;
		}
	}
		
	}
///	function validateInteger( strValue ) {
		//alert("in validate integer")
	//  var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
	 //	return objRegExp.test(strValue);
	//}

	function validatePage(formName,rowVal)
	{
			var counter=document.getElementById('counter').value;
			formname=formName.name
	    var totalQty=0;
        for(i=0;i<parseInt(counter);i++){
        issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
	     if(issQtyVal != "")
		  totalQty=totalQty+parseInt(issQtyVal)
		 else
		totalQty=totalQty+parseInt(0)
	    }
	   var check = "y";
	   if(totalQty==0){
			alert("Can not issue brands without QUANTITY !");
			check = "n";
			return false
	   }

       if (totalQty < 0)
	   {
	   alert("Negative quantity not Allowed!...");
	   check = "n";
	    return false;
	   }
       //alert("Hello....");	
	    var sum=0;
		var qtyPrescription=document.getElementById('qtyPrescription').value;
        //alert("rowVal "+rowVal);
		for(var i=0;i<rowVal;i++)
		{
		  if(document.getElementById('issueQty'+i).value!="")
          {
        	  var issueItemQty=document.getElementById('issueQty'+i).value;
   		 //  alert("num "+document.getElementById('issueQty'+i).value);       
		   sum=sum+parseInt(issueItemQty);	 
           //alert("sum "+sum);
           //alert("qtyPrescription "+qtyPrescription);
		   if(sum > qtyPrescription)
		   {
              alert("Issue Quantity Cannot be more than Quantity Prescription")
			   document.getElementById('issueQty'+i).value="";	   
              return false;
		   }
		   
          }
		}
	   if(check == "y"){
	  	var nomenclature=window.opener.document.getElementById("nomenclature"+<%=rowVal%>);
			nomenclature.disabled = true;
			var rowVal = '<%=rowVal%>';
			if(rowVal % 20 == 0){
		    var pvmsNo=window.opener.document.getElementById("pvmsNo"+<%=rowVal%>);
		    pvmsNo.focus();
		    }else{
			    if(window.opener.document.getElementById("pvmsNo"+<%=rowVal+1%>)){
		     		var pvmsNo=window.opener.document.getElementById("pvmsNo"+<%=rowVal+1%>);
		    		 pvmsNo.focus();
			    }
		    }
	   }
			// for(var i = 0; i < counter; i++)
			// {
			//   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			//   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			//   alert("::::::::::::::::::::::"+issQtyVal+":::::::::");
			//   alert("::::::::::::::::::::"+amountVal+":::::::::");
			//   if (amountVal.trim() == "" && issQtyVal.trim() != "")
			//	{
			//		alert("Please Enter the correct value in Issued Quantity")
			//		return false
			//	}
			//	if (issQtyVal.trim() == "" && amountVal.trim() != "")
			//	{
			//	  obj1 = eval('document.'+formname+'.amount'+i);
			//	  obj1.value="";
			//	  alert("Please Enter the correct value of Issued Quantity")
			//	  return false
			//	}
		   // }
		
	    	setTotalQtyInParent();
		return true

		//return false;
		}

	function setTotalQtyInParent(){
		alert("set values");
  		//alert("get Values Method")
		//window.opener.document.getElementById('date').value
		//var qtyIssuedList = document.getElementsByName("qtyIssued");
		var sum = 0;
		for(var index = 0; index < parseInt(document.opdPatientStockDetailsForm.counter.value); index++ ){
			var toEval = "document.opdPatientStockDetailsForm.issueQty" + index;
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
		var totalQty;
		if(totalQtyIssued.value != ""){
			totalQty = parseInt(totalQtyIssued.value)+parseInt(sum);
		}else{
			totalQty = sum;
		}
		<%-- if(window.opener.document.getElementById('qtyPending' + <%=rowVal%>)){
			if(window.opener.document.getElementById('qtyPending' + <%=rowVal%>).value != ""){
				if(parseInt(sum) > parseInt(window.opener.document.getElementById('qtyPending' + <%=rowVal%>).value)){
					alert("Can not issue item more than "+window.opener.document.getElementById('qtyPending' + <%=rowVal%>).value);
					return false;
					}
			}
		} --%>
		totalQtyIssued.value = totalQty;
		alert("hello");
		if(window.opener.document.getElementById('qtyPending' + <%=rowVal%>)){
			if(window.opener.document.getElementById('qtyPrescribed' + <%=rowVal%>).value != "")
				window.opener.document.getElementById('qtyPending' + <%=rowVal%>).value = parseInt(window.opener.document.getElementById('qtyPrescribed' + <%=rowVal%>).value) - parseInt(totalQtyIssued.value);

					
			    window.opener.document.getElementById('issue'+ <%=rowVal%>).disabled = true;

			}

		return true
  	}

	function setHeaderValuesForOPDPatient(rowVal)
	{
alert("setHeaderValuesForOPDPatient");
	//document.getElementById('itemId').value =window.opener.document.getElementById('itemId'+rowVal).value ;
	document.getElementById('date').value=window.opener.document.getElementById('date').value ;
	document.getElementById('time').value=window.opener.document.getElementById('time').value ;
	document.getElementById('opdIssueno').value=window.opener.document.getElementById('opdIssueno').value;
	document.getElementById('storeFyDocumentNoId').value=window.opener.document.getElementById('storeFyDocumentNoId').value ;
	document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value ;
	document.getElementById('hinId').value=window.opener.document.getElementById('hinId').value ;
	document.getElementById('empId').value=window.opener.document.getElementById('empId').value ;
	document.getElementById('prescription').value=window.opener.document.getElementById('prescription').value ;
	if(window.opener.document.getElementById('presHdId'))
		document.getElementById('patientPrescriptionId').value=window.opener.document.getElementById('presHdId').value ;
	if(window.opener.document.getElementById('patientPrescriptionDtId'+rowVal))
		document.getElementById('patientPrescriptionDtId').value=window.opener.document.getElementById('patientPrescriptionDtId'+rowVal).value ;
	if(window.opener.document.getElementById('qtyPrescribed'+rowVal))
		document.getElementById('qtyPrescribed').value=window.opener.document.getElementById('qtyPrescribed'+rowVal).value ;
    return true;
}
function setHeaderValuesForDispensaryConsumption(rowVal)
{
alert("setHeaderValuesForDispensaryConsumption");
    document.getElementById('date').value=window.opener.document.getElementById('date').value ;
	document.getElementById('opdIssueno').value=window.opener.document.getElementById('opdIssueno').value ;
	document.getElementById('fromDate').value=window.opener.document.getElementById('issue_date').value;
	document.getElementById('toDate').value=window.opener.document.getElementById('issue_to_date').value;
	document.getElementById('time').value=window.opener.document.getElementById('time').value ;
	document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value ;
	document.getElementById('empId').value=window.opener.document.getElementById('empId').value ;
	document.getElementById('prescription').value=window.opener.document.getElementById('prescription').value ;
	document.getElementById('remarks').value=window.opener.document.getElementById('remarks').value
    return true;
}
</script>