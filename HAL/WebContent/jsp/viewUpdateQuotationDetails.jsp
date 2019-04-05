<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreQuotationRequestM"%>
<%@page import="jkt.hms.masters.business.StoreQuotationRequestT"%>

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
	

	List<StoreQuotationRequestM> quotationHeader = new ArrayList<StoreQuotationRequestM>();
	List<StoreQuotationRequestT> quotationDetails = new ArrayList<StoreQuotationRequestT>();

	
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
	
		
	 if(map.get("quotationDetails") != null)
	 {
		 quotationDetails =  (List<StoreQuotationRequestT>)map.get("quotationDetails");	  
		   
	  }	
	 if(map.get("quotationHeader") != null)
	 {
		 quotationHeader =  (List<StoreQuotationRequestM>)map.get("quotationHeader");	  
		   
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
	 
	 
		
		int quotationHeaderId= 0;
		String quotationDate ="";
		String dueDate ="";
		String year = "";
		String quotationNo="";
		String MPRNo="";
		String vendorName="";
		String deliveryInstruction="";
		
		String quotationStatus = "NA";
			
		for(StoreQuotationRequestM header: quotationHeader)
		{
			quotationHeaderId = header.getId();
			if(header.getRequestDate() != null)
				quotationDate = HMSUtil.changeDateToddMMyyyy(header.getRequestDate());
			
			if(header.getDueDate() != null)
				dueDate = HMSUtil.changeDateToddMMyyyy(header.getDueDate());
			
			year = (header.getYear()!=null?header.getYear().getFinancialYear():"");
			quotationNo = (header.getRequestNo()!=null?header.getRequestNo():"");
			MPRNo = (header.getMprHeader()!=null?header.getMprHeader().getMprNo():"");
		    vendorName = (header.getSupplier()!=null?header.getSupplier().getSupplierName():"");		
			if(header.getStatus() != null)
			{
				quotationStatus = header.getStatus();
			}
			deliveryInstruction = (header.getDeliveryInstruction()!=null?header.getDeliveryInstruction():"");	
			
			
			
		}
%>




 <div class="titleBg">
<h2>View And Update Vendor Quotation Details <%out.print(message); %></h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="MPR" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">
<label>Quotation/Enquiry No. </label>
	
<input	type="text" name="mprNo" value="<%=quotationNo%>" readonly="readonly" validate="MPR No ,String,yes" tabindex=1  id="mprNo"/>


<label> Quotation Date </label>
<input  type="text"  id="quotationDate" name="quotationDate"  validate="Date,string,yes" value="<%out.print(quotationDate); %>"  readonly/>
	
<label> Due Date </label>
<input  type="text"   id="dueDate" name="dueDate"  validate="Date,string,yes" value="<%out.print(dueDate); %>"   readonly/>

<div class="clear"></div>
<label>Year:</label>
<input  type="text"   id="year" name="year"  validate="year,string,yes" value="<%out.print(year); %>"   readonly/>
	
	<label> Vendor Name  </label>
	<input  type="text"   id="vendorName" name="vendorName"  validate="Date,string,yes" value="<%out.print(vendorName); %>"   readonly/>
	
	<label>MPR No</label>
	
	<input	type="text" name="MPRNo" validate="MPRNo ,String,yes" tabindex=1  id="MPRNo" value="<% out.print(MPRNo);%>" readonly/>
	<div class="clear"></div>
	<label>Delivery Instruction</label>
	
	<textarea  name="deliveryInstruction" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width:480px; height:60px"/><%out.print(deliveryInstruction); %></textarea> 
	
	
</div>  
	
	
 
	<!-- <input type="button" class="buttonBig2" value="IMPORT ITEMS BELOW ROL"  onclick="getMMF();"/>   -->

	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="quotationHeaderId" value="<%=quotationHeaderId %>" id="quotationHeaderId" />
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
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="10%">Qty Req.</th>
	      <!-- <th width="15%">Delivery Date</th>	 -->      
		   <th width="13%">Remarks</th>
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreQuotationRequestT detailsList :quotationDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		
     
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=detailsList.getId() %>');" validate="PVMS No,String,no" size="12" value="<%=detailsList.getMprDetails().getItem().getPvmsNo() %>" readonly/>
      <input type="hidden" name="ItemId<%out.print(detailsList.getId()); %>" tabindex="1" id="ItemId<%out.print(detailsList.getId()); %>" />																	
      </td>
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes' onblur="checkForPurchase(this.value, 'nameItem','<%=detailsList.getId() %>');"  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="70" value="<%=detailsList.getMprDetails().getItem().getNomenclature() %>[<%=detailsList.getMprDetails().getItem().getPvmsNo() %>]" readonly />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('nameItem<%=detailsList.getId() %>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem<%=detailsList.getId() %>' })
	    
	
		</script>
		</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%=detailsList.getMprDetails().getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="10" value="<%=detailsList.getMprDetails().getQtyRequired()%>" readonly />
      </td>
      <%-- <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="12" value="<%=detailsList.getMprDetails().getDeliveryDate()!=null?detailsList.getMprDetails().getDeliveryDate():""%>" readonly />
      </td> --%>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%=detailsList.getMprDetails().getRemarks()!=null?detailsList.getMprDetails().getRemarks():""%>" readonly />
      </td>
		  
   
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
<input type="button" name="add" id="addbutton" value="Vendor COPY" class="button" onClick="submitForm('MPR','/hms/hms/stores?method=generatevendorQuotationReport&headerId=<%=quotationHeaderId %>');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="HAL COPY" class="button" onClick="submitForm('MPR','/hms/hms/stores?method=generatevendorQuotationReportHAL&headerId=<%=quotationHeaderId %>');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Back To List" class="button" onClick="submitForm('MPR','/hms/hms/stores?method=showQuotationList&selectedAppId=A1545&childAppId=A1547');"  tabindex=1 />
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
		
		
		
		 </script>