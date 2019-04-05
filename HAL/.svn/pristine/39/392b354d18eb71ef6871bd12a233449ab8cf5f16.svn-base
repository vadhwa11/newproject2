<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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

	List<StorePoHeader> poHeader = new ArrayList<StorePoHeader>();
	List<StorePoDetail> poDetails = new ArrayList<StorePoDetail>();
	
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
	
		
	 if(map.get("poDetails") != null)
	 {
		 poDetails =  (List<StorePoDetail>)map.get("poDetails");	  
		   
	  }	
	 if(map.get("poHeader") != null)
	 {
		 poHeader =  (List<StorePoHeader>)map.get("poHeader");	  
		   
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
	 
	 
		
		int poHeaderId= 0;
		String quotationDate ="";
		String PODate ="";
		String deliveryDate ="";
		String year = "";
		String quotationNo="";
		String PONo="";
		String vendorName="";
		String deliveryInstruction="";
		String referenceNo="";
		String stockistName="";
		String mprApprovalDate="";
		String ProposalDate="";
		String ProposalApprovalDate="";
		String ProposalNo="";
		String TaxDetails="";
		String DeliverySchedule="";
		String PaymentTerms="";
		
		String poStatus = "NA";
			
		for(StorePoHeader header: poHeader)
		{
			poHeaderId = header.getId();
			if(header.getPoDate()!= null)
				PODate = HMSUtil.changeDateToddMMyyyy(header.getPoDate());
			
			if(header.getDeliveryDate() != null)
				deliveryDate = HMSUtil.changeDateToddMMyyyy(header.getDeliveryDate());
			
			year = (header.getFinancialYear()!=null?header.getFinancialYear().getFinancialYear():"");
			referenceNo = (header.getReference()!=null?header.getReference():"");
			PONo = (header.getPoNumber()!=null?header.getPoNumber():"");
		    vendorName = (header.getSupplier()!=null?header.getSupplier().getSupplierName():"");	
		    stockistName= (header.getStockist()!=null?header.getStockist().getSupplierName():"");	
		    if(header.getMprApprovalDate() != null)
		    	mprApprovalDate = HMSUtil.changeDateToddMMyyyy(header.getMprApprovalDate());
		    if(header.getProposalDate() != null)
		    	ProposalDate = HMSUtil.changeDateToddMMyyyy(header.getProposalDate());
		    if(header.getProposalApprovalDate() != null)
		    	ProposalApprovalDate = HMSUtil.changeDateToddMMyyyy(header.getProposalApprovalDate());
		    
		    ProposalNo = (header.getProposalNo()!=null?header.getProposalNo():"");
		    TaxDetails = (header.getTaxTerm()!=null?header.getTaxTerm():"");
		    DeliverySchedule = (header.getDeliverySchedule()!=null?header.getDeliverySchedule():"");
		    PaymentTerms = (header.getPayTerms()!=null?header.getPayTerms():"");
		    
			if(header.getStatus() != null)
			{
				poStatus = header.getStatus();
			}
			
			
			
			
		}
%>




 <div class="titleBg">
<h2>View And Update Purchase Details</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="POUpdate" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">
<label>Purchase Order No. </label>
	
<input	type="text" name="poNo" value="<%=PONo%>" readonly="readonly" validate="Purchase Order No ,String,yes" tabindex=1  id="mprNo"/>


<label> PO Date </label>
<input  type="text"  id="poDate" name="poDate"  validate="PO Date,string,yes" value="<%out.print(PODate); %>"  readonly/>
	
<label> Delivery Date </label>
<input  type="text"   id="deliveryDate" name="deliveryDate"  validate="Delivery Date,string,yes" value="<%out.print(deliveryDate); %>"   readonly/>

<div class="clear"></div>
<label>Year:</label>
<input  type="text"   id="year" name="year"  validate="year,string,yes" value="<%out.print(year); %>"   readonly/>
	
	<label> Vendor Name  </label>
	<input  type="text"   id="vendorName" name="vendorName"  validate="Date,string,yes" value="<%out.print(vendorName); %>"   readonly/>
	
	<label>Stockist Name</label>
	<input  type="text"   id="referenceNo" name="referenceNo"   value="<%out.print(stockistName); %>"   readonly/>
	
	<label>Reference No</label>
	<input	type="text" name="referenceNo" validate="referenceNo ,String,yes" tabindex=1  id="referenceNo" value="<% out.print(referenceNo);%>" readonly/>
	
<label> MPR Approval Date <span>*</span></label>
<input  type="text" value="<% out.print(mprApprovalDate);%>" id="mprApprovalDate" name="mprApprovalDate" placeholder="DD/MM/YYYY" validate="MPR Approval Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Proposal No<span>*</span> </label>
<input	name="ProposalNo" value="<% out.print(ProposalNo);%>" id="ProposalNo" validate="Proposal No,String,yes" tabindex=1>

<div class="clear"></div>
<label> Proposal Date <span>*</span></label>
<input  type="text" value="<% out.print(ProposalDate);%>" id="ProposalDate" name="ProposalDate" placeholder="DD/MM/YYYY" validate="Proposal Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Proposal Approval Date <span>*</span></label>
<input  type="text"  value="<% out.print(ProposalApprovalDate);%>" id="ProposalApprovalDate" name="ProposalApprovalDate" placeholder="DD/MM/YYYY" validate="Proposal Approval Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>

<label> Tax Details<span>*</span> </label>
<input	name="TaxDetails" value="<% out.print(TaxDetails);%>" id="TaxDetails" validate="Tax Details,String,yes" tabindex=1>
	<div class="clear"></div>
	<label> Delivery Schedule<span>*</span> </label>
	<textarea size ="20" class="large"  id="DeliverySchedule" class="medium3"  name="DeliverySchedule"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><% out.print(DeliverySchedule);%></textarea>
	
	<label> Payment Terms<span>*</span> </label>
	<textarea size ="20" class="large"  id="PaymentTerms" class="medium3"  name="PaymentTerms"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><% out.print(PaymentTerms);%></textarea>
	
	
	
</div>  
	
	
 
	<!-- <input type="button" class="buttonBig2" value="IMPORT ITEMS BELOW ROL"  onclick="getMMF();"/>   -->

	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="poHeaderId" value="<%=poHeaderId %>" id="poHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		
		
<%-- 	<%
	if(!quotationStatus.equalsIgnoreCase("y"))
	{
		%>
			<input class="buttonAdd" type="button" tabindex="1" onclick="addRow('MPRGrid');" value="">
			<input class="buttonDel" type="button" tabindex="1"  onclick="removeRow_FromDatabase('MPRGrid','StoreMaterialPurchaseReqT',<%out.print(quotationHeaderId); %>);" value=""><img id='imgRemoveDetails' src='/hms/jsp/images/saving.gif' style="display:none;" />
		<%
	}
	
	%>
	 --%>

	
<div class="clear"></div>
<div class="cmntable">
<table id="POGrid">
		
		<tr id="th">
		
         <th width="5%">Sl No</th>
          <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th>
	      <th width="10%">Qty Req.</th>
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		   <th width="13%">Chemical Composition</th>
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StorePoDetail detailsList :poDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		
     
      <td><input type="text" name="itemCode" tabindex="1" value="<%out.print(counter); %>" readonly/></td>
      <td><input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>"  validate="PVMS No,String,no" size="12" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getPvmsNo():""); %>" readonly/></td>
      
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes'  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="70" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getNomenclature():""); %>" readonly />
				</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%out.print(detailsList.getItem().getItemConversion().getItemUnitName()!=null?detailsList.getItem().getItemConversion().getItemUnitName():""); %>" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="10" value="<%out.print(detailsList.getManufacturer()!=null?detailsList.getManufacturer().getManufacturerName():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="12" value="<%out.print(detailsList.getBrand()!=null?detailsList.getBrand().getBrandName():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getQuantityOrdered()!=null?detailsList.getQuantityOrdered():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getUnitRate()!=null?detailsList.getUnitRate():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getAmount()!=null?detailsList.getAmount():""); %>" readonly />
      </td>
		 <td> <textarea size ="20" class="large"  id="chemicalComposition<%out.print(detailsList.getId()); %>" class="medium3"  name="chemicalComposition<%out.print(detailsList.getId()); %>"  validate="chemical Composition,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><%out.print(detailsList.getChemicalComposition()!=null?detailsList.getChemicalComposition():""); %></textarea></td> 
   
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
<input type="button" name="add" id="addbutton" value="HAL COPY" class="button" onClick="submitForm('POUpdate','/hms/hms/stores?method=generateHALPo&poId=<%=poHeaderId %>');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Vendor PO COPY" class="button" onClick="submitForm('POUpdate','/hms/hms/stores?method=generatePo&poId=<%=poHeaderId %>');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Back To List" class="button" onClick="submitForm('POUpdate','/hms/hms/stores?method=listofPurchaseOrder&selectedAppId=A1579&childAppId=A1547');"  tabindex=1 />
	<%-- <%
	if(!quotationStatus.equalsIgnoreCase("y"))
	{
		%>
			<input type="button" name="Save"  class="button" value="Save" onclick="saveMPR('MPR','stores?method=updateSavedSalesProjection&mprHeaderId=<%out.print(quotationHeaderId); %>&appId=A1523');"/>
			<input type="button" name="Submit"  class="button" value="Submit" onclick="submitMPR('MPR','stores?method=updateSavedSalesProjection&mprHeaderId=<%out.print(quotationHeaderId); %>&appId=A1523');"/>
		<%
	}
	
	%> --%>

    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		<script type="text/javascript">
		
		
		
		 </script>