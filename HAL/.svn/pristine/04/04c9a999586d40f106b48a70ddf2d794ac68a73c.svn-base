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
		String GrNNo ="";
		String GrnDate ="";
		String InvoiceNo ="";
		double InvoiceAmt =0.0;
		String InvoiceDate = "";
		
		String IndentNo="";
		String PONo="";
		String vendorName="";
		String EnteredBy="";
		
		String IndentStatus = "NA";
			
		for(StoreGrnM header: grnHeader)
		{
			grnHeaderId = header.getId();
			GrNNo = (header.getGrnNo()!=null?header.getGrnNo():"");
			if(header.getGrnDate()!= null)
				GrnDate = HMSUtil.changeDateToddMMyyyy(header.getGrnDate());		
			
			
			if(header.getInvoiceAmount()!= null)
				InvoiceAmt = header.getInvoiceAmount().doubleValue();
			
		    EnteredBy = (header.getEnteredBy()!=null?header.getEnteredBy().getEmployee().getFirstName():"");
			
			
		}
%>




 <div class="titleBg">
<h2>Unused Medicine Detailed Report</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="UnusedMedicineDetails" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">

<label> Receiving No </label>
<input  type="text"  id="RRNo" name="RRNO"  value="<%out.print(GrNNo); %>"  readonly/>


<label>Receiving Date </label>
	
<input	type="text" name="RR" value="<%=GrnDate%>" readonly="readonly"  tabindex=1  readonly/>

<label> Entered By  </label>
	<input  type="text"   id="RR" name="RR"  value="<%out.print(EnteredBy); %>"   readonly/>

<div class="clear"></div>

<label>Total Amt</label>
<input	type="text" name="Invoice" value="<%=InvoiceAmt%>" readonly="readonly"  tabindex=1  readonly/>
	
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
	      <th width="10%">Qty</th>     
	      <th width="6%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
	   
	      
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
      <input type="text"  class="smcaption" readonly="readonly" name="txtReceivedQty<%out.print(detailsList.getId()); %>" id="txtReceivedQty<%out.print(detailsList.getId()); %>" tabindex="1" validate="Received Qty ,String,no" size="10" value="<%out.print(detailsList.getReceivedQty()!=null?detailsList.getReceivedQty():0.0); %>" readonly />
      </td>
      
      <td>
      <input type="text"  class="smcaption"  name="txtUnitRate<%out.print(detailsList.getId()); %>" id="txtUnitRate<%out.print(detailsList.getId()); %>" tabindex="1" validate="Unit Rate ,String,no" size="10" value="<%out.print(detailsList.getUnitRate()!=null?detailsList.getUnitRate():0.0); %>"  readonly />
      </td>
      <td>
      <input type="text"  class="smcaption"  name="txtItemValue<%out.print(detailsList.getId()); %>" id="txtItemValue<%out.print(detailsList.getId()); %>" tabindex="1" validate="Total Amount ,String,no" size="10" value="<%out.print(detailsList.getAmountValue()!=null?detailsList.getAmountValue():0.0); %>" readonly />
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
<input type="button" name="add" id="addbutton" value="Print Report" class="button" onClick="submitForm('UnusedMedicineDetails','/hms/hms/stores?method=printReturnedMedicineListReport&grnHeaderId=<%=grnHeaderId %>');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Back To List" class="button" onClick="submitForm('UnusedMedicineDetails','/hms/hms/stores?method=showUnusedMedicineList&selectedAppId=A1654');"  tabindex=1 />
    
    

    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		