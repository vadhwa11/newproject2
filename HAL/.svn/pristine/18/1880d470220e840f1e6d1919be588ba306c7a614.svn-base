<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>


<script>
<%

Map<String,Object> utilMap1 = new HashMap<String,Object>();


utilMap1 = (Map)HMSUtil.getCurrentDateAndTime();
String newdate = (String)utilMap1.get("currentDate");  
String time = (String)utilMap1.get("currentTime");



	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<script type="text/javascript" language="javascript">






</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	
	String max = "";
	BigDecimal netAmount = null;
	Box box = null;
	String DeliveryDate = null;
	String QuotationDate = null;	

	List<StoreGrnM> grnHeader = new ArrayList<StoreGrnM>();
	List<StoreGrnT> grnDetails = new ArrayList<StoreGrnT>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	String pageTitle = "";
	
	
	
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	
	
		
	 if(map.get("grnDetails")!=null)
		{
		 grnDetails = (List<StoreGrnT>) map.get("grnDetails");
		}
		if(map.get("grnHeader")!=null)
		{
			grnHeader = (List<StoreGrnM>) map.get("grnHeader");
		}
		
	if(map.get("max") != null){
		max = (String) map.get("max");
	}
	
	 boolean bSuccessfullyAdded = false;
	 String message = "";
	 //String AUStockId = "";
	 
	 if(map.get("bSuccessfullyAdded") != null)
	 {
		 
		 bSuccessfullyAdded =  (Boolean)map.get("bSuccessfullyAdded");
	 }
	 
	 int userId = 0;
		if(session.getAttribute("userId") != null){
			userId = (Integer)session.getAttribute("userId");
		}
	 
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }	
	 
	 
		
		int grnHeaderId= 0;
		String RRNO ="";
		String RRDate ="";
		String InvoiceNo ="";
		double InvoiceAmt =0.0;
		String InvoiceDate = "";
		
		String IndentNo="";
		String PONo="";
		String vendorName="";
		String EnteredBy="";
		
		String IndentStatus = "NA";
		String Stockist = "NA";
			
		for(StoreGrnM header: grnHeader)
		{
			grnHeaderId = header.getId();
			RRNO = (header.getChallanNo()!=null?header.getChallanNo():"");
			if(header.getGrnDate()!= null)
				RRDate = HMSUtil.changeDateToddMMyyyy(header.getGrnDate());		
			if(header.getInvoiceDate()!= null)
				InvoiceDate = HMSUtil.changeDateToddMMyyyy(header.getInvoiceDate());
			if(header.getInvoiceNo()!= null)
				InvoiceNo = header.getInvoiceNo();
			if(header.getInvoiceAmount()!= null)
				InvoiceAmt = header.getInvoiceAmount().doubleValue();
			
			IndentNo = (header.getIndent()!=null?header.getIndent().getIndentNo():"");
			PONo = (header.getPo()!=null?header.getPo().getPoNumber():"");
		    vendorName = (header.getPo()!=null?header.getPo().getSupplier().getSupplierName():"");	
		    EnteredBy = (header.getEnteredBy()!=null?header.getEnteredBy().getEmployee().getFirstName():"");
		    Stockist  = (header.getPo()!=null?header.getPo().getStockist().getSupplierName():"");	
		    IndentNo = (header.getIndent()!=null?header.getIndent().getIndentNo():"NA");
			
			
		}
%>




 <div class="titleBg">
<h2>Inspection Of Receiving Report</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="RRInspection" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">

<label> RR No </label>
<input  type="text"  id="RRNo" name="RRNO"  value="<%out.print(RRNO); %>"  readonly/>


<label>RR Date </label>
	
<input	type="text" name="RR" value="<%=RRDate%>" readonly="readonly"  tabindex=1  readonly/>

<label>Purchase Order No. </label>
	
<input	type="text" name="poNo" value="<%=PONo%>" readonly="readonly"  tabindex=1  readonly/>

<div class="clear"></div>
<label>Invoice No</label>
<input	type="text" name="Invoice" value="<%=InvoiceNo%>" readonly="readonly"  tabindex=1  readonly/>
<label>Invoice Date</label>
<input	type="text" name="Invoice" value="<%=InvoiceDate%>" readonly="readonly"  tabindex=1  readonly/>

<label>Invoice Amt</label>
<input	type="text" name="Invoice" value="<%=InvoiceAmt%>" readonly="readonly"  tabindex=1  readonly/>
	<div class="clear"></div>
	
	<label> RR Entered By  </label>
	<input  type="text"   id="RR" name="RR"  value="<%out.print(EnteredBy); %>"   readonly/>
	
	<label> Vendor Name  </label>
	<input  type="text"   id="vendorName" name="vendorName"   value="<%out.print(vendorName); %>"   readonly/>
	<label> Stockist/Distributor  </label>
	<input  type="text"   id="vendorName" name="vendorName"   value="<%out.print(Stockist); %>"   readonly/>
		<div class="clear"></div>
	<label> Indent No  </label>
	<input  type="text"   id="vendorName" name="vendorName"   value="<%out.print(IndentNo); %>"   readonly/>
	
	
</div>  
	
	
 
	

	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="grnHeaderId" value="<%=grnHeaderId %>" id="grnHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		

<div class="clear"></div>
<div class="cmntable">
<table id="IndentGrid">
		
		<tr id="th">
		
         <th width="5%">Sl No</th>
          <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="10%">Manufacturer</th>
	      <th width="10%">Brand</th>
	      <th width="10%">Batch No</th>
	      <th width="10%">Manufacture Date.</th>
	      <th width="10%">Expiry Date</th>
	      <th width="10%">PO Qty</th>
	      <th width="10%">Qty Advised</th>
	      <th width="10%">Received Qty</th>
	      <th width="10%">Short</th>
	      <th width="10%">Over</th>	      
	       <th width="10%">Rejected Qty</th>
	      <th width="10%">Accepted Qty</th>     
	      <th width="6%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		   <th width="13%">Chemical Composition</th>
		   <th width="13%">Remarks for Shortage/Surplus</th>
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreGrnT detailsList :grnDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		
     
     <td><input type="text" name="itemCode" tabindex="1" value="<%out.print(counter); %>" readonly/>
     <input type="hidden" name="grnDetailId" tabindex="1" value="<%out.print(detailsList.getId()); %>" /></td>
      <td><input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>"  validate="PVMS No,String,no" size="12" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getPvmsNo():""); %>" readonly/></td>
      
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes'  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="70" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getNomenclature():""); %>" readonly />
				</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%out.print(detailsList.getItem().getItemConversion().getItemUnitName()!=null?detailsList.getItem().getItemConversion().getItemUnitName():""); %>" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="Manufacturer ,String,no" size="15" value="<%out.print(detailsList.getManufacturer()!=null?detailsList.getManufacturer().getManufacturerName():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="Brand Name ,String,no" size="15" value="<%out.print(detailsList.getBrand()!=null?detailsList.getBrand().getBrandName():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="Batch NO ,String,no" size="15" value="<%out.print(detailsList.getBatchNo()!=null?detailsList.getBatchNo():""); %>" readonly />
      </td>
            <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="Manufacturer Date ,String,no" size="10" value="<%out.print(detailsList.getManufacturerDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(detailsList.getManufacturerDate()):""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="Expiry Date ,String,no" size="10" value="<%out.print(detailsList.getExpiryDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(detailsList.getExpiryDate()):""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="txtPOQty<%out.print(detailsList.getId()); %>" id="txtPOQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="POQty ,String,no" size="10" value="<%out.print(detailsList.getPoDetail()!=null?detailsList.getPoDetail().getQuantityOrdered():0.0); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="txtAdvisedQty<%out.print(detailsList.getId()); %>" id="txtAdvisedQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Advised Qty ,String,no" size="10" value="<%out.print(detailsList.getQtyAdvised()!=null?detailsList.getQtyAdvised():0.0); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="txtReceivedQty<%out.print(detailsList.getId()); %>" id="txtReceivedQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Received Qty ,String,no" size="10" value="<%out.print(detailsList.getReceivedQty()!=null?detailsList.getReceivedQty():0.0); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="txtShortageQty<%out.print(detailsList.getId()); %>" id="txtShortageQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Shortage Qty ,String,no" size="10" value="<%out.print(detailsList.getShortage()!=null?detailsList.getShortage():0.0); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="txtSurplusQty<%out.print(detailsList.getId()); %>" id="txtSurplusQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Surplus Qty ,String,no" size="10" value="<%out.print(detailsList.getSurplus()!=null?detailsList.getSurplus():0.0); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption"  name="txtRejectedQty<%out.print(detailsList.getId()); %>" id="txtRejectedQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Rejected Qty ,String,no" size="10" value="<%out.print(detailsList.getRejectedQty()!=null?detailsList.getRejectedQty():0.0); %>" onblur ="calculateQty(<%out.print(detailsList.getId()); %>); calculateAmount(<%out.print(detailsList.getId()); %>);" onkeypress ="return isNumber(event);"  />
      </td>
      <td>
      <input type="text"  class="smcaption"  name="txtAcceptedQty<%out.print(detailsList.getId()); %>" id="txtAcceptedQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Accepted Qty ,String,no" size="10" value="<%out.print(detailsList.getAcceptedQty()!=null?detailsList.getAcceptedQty():0.0); %>" onblur ="calculateQty(<%out.print(detailsList.getId()); %>); calculateAmount(<%out.print(detailsList.getId()); %>);" onkeypress ="return isNumber(event);" readonly/>
      </td>
      <td>
      <input type="text"  class="smcaption"  name="txtUnitRate<%out.print(detailsList.getId()); %>" id="txtUnitRate<%out.print(detailsList.getId()); %>" tabindex="1" validate="Unit Rate ,String,no" size="10" value="<%out.print(detailsList.getUnitRate()!=null?detailsList.getUnitRate():0.0); %>"  readonly />
      </td>
      <td>
      <input type="text"  class="smcaption"  name="txtItemValue<%out.print(detailsList.getId()); %>" id="txtItemValue<%out.print(detailsList.getId()); %>" tabindex="1" validate="Total Amount ,String,no" size="10" value="<%out.print(detailsList.getAmountValue()!=null?detailsList.getAmountValue():0.0); %>" readonly />
      </td>
      <td> <textarea size ="20" class="large"  id="txtChemical<%out.print(detailsList.getId()); %>" class="medium3"  name="txtChemical<%out.print(detailsList.getId()); %>"   tabindex=1 style="width: 250px; height: 50px;" ><%=detailsList.getPoDetail().getChemicalComposition()!=null?detailsList.getPoDetail().getChemicalComposition():"" %></textarea></td>
      <td> <textarea size ="20" class="large"  id="txtRemarks<%out.print(detailsList.getId()); %>" class="medium3"  name="txtRemarks<%out.print(detailsList.getId()); %>"   tabindex=1 style="width: 250px; height: 50px;" ><%=detailsList.getRrRemarks()!=null?detailsList.getRrRemarks():"" %></textarea></td>
      
		  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
   <%--     
   <%
     	 }   %> --%>
     	 
	
</table>
</div>
	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>
<%-- <%}else{ %>
<h4>Access Denied! </h4>
<%}%>  --%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('RRInspection','/hms/hms/stores?method=submitRRInspectionDetails');"  tabindex=1 />
<!-- <input type="button" name="add" id="addbutton" value="Back To List" class="button" onClick="submitForm('SupplierIndent','/hms/hms/stores?method=showSupplierIndentList&selectedAppId=A1644&childAppId=A1547');"  tabindex=1 /> -->
	<%-- <%
	if(!quotationStatus.equalsIgnoreCase("y"))
	{
		%>
			<input type="button" name="Save"  class="button" value="Save" onclick="saveMPR('MPR','stores?method=updateSavedSalesProjection&mprHeaderId=<%out.print(quotationHeaderId); %>&appId=A1523');"/>
			<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMPR('MPR','stores?method=updateSavedSalesProjection&mprHeaderId=<%out.print(quotationHeaderId); %>&appId=A1523');"/>
		<%
	}
	
	%> --%>
	
	
	
    
    
    
	</div>
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		<script type="text/javascript">
		
		function calculateAmount(inc){
			
			var quantity = 0;
			var unitRate = 0;
			var amount = 0;
			if (!isNaN(document.getElementById('txtAcceptedQty'+inc).value))
			quantity = parseFloat(document.getElementById('txtAcceptedQty'+inc).value);
			
			if (!isNaN(document.getElementById('txtUnitRate'+inc).value))
				unitRate = parseFloat(document.getElementById('txtUnitRate'+inc).value);
			// Amount Calculation
			
			if (unitRate > 0 && quantity > 0)
			{
				amount = quantity * unitRate;
				document.getElementById('txtItemValue'+inc).value =  amount.toFixed(2);
			}else
			{
				return;
			}

		}
		
		
		function calculateQty(inc)
		{
			
					var ReceivedQty = document.getElementById('txtReceivedQty'+inc).value
					ReceivedQty =ReceivedQty *1;
					var RejectedQty = document.getElementById('txtRejectedQty'+inc).value
					RejectedQty= RejectedQty *1;
					
					
					
					if(RejectedQty>ReceivedQty)
					{
						alert("Rejected Qty can not be greater.");
						document.getElementById('txtRejectedQty'+inc).value="";
						calculateAmount(inc);
						return;
					}
					
					var AcceptedQty = ReceivedQty-RejectedQty;
					document.getElementById('txtAcceptedQty'+inc).value=AcceptedQty;
					
				}
		
		
		 </script>