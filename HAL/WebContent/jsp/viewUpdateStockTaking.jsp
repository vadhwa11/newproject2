<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>

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

	List<StoreStockTakingM> stockTakingHeader = new ArrayList<StoreStockTakingM>();		
	List<StoreStockTakingT> stockTakingDetail = new ArrayList<StoreStockTakingT>();
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
	
		
	 if(map.get("stockTakingDetail")!=null)
		{
		 stockTakingDetail = (List<StoreStockTakingT>) map.get("stockTakingDetail");
		}
		if(map.get("stockTakingHeader")!=null)
		{
			stockTakingHeader = (List<StoreStockTakingM>) map.get("stockTakingHeader");
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
	 
	 
		
		int stockHeaderId= 0;
		String Date ="";
		String SubmittedBy="";
		String StockTakingNo="";
		String Reason = "NA";
		String ApprovedBy="NA";
			
		for(StoreStockTakingM header: stockTakingHeader)
		{
			stockHeaderId = header.getId();
			if(header.getPhysicalDate()!= null)
				Date = HMSUtil.changeDateToddMMyyyy(header.getPhysicalDate());			
			
			StockTakingNo = (header.getStockTakingNo()!=null?header.getStockTakingNo():"");
			
		    SubmittedBy = (header.getLastChangedBy()!=null?header.getLastChangedBy().getEmployee().getFirstName():"");		
			Reason= (header.getReason()!=null?header.getReason():"");
			ApprovedBy= (header.getApprovedBy()!=null?header.getApprovedBy().getEmployee().getFirstName():"NA");		
			
			
			
			
		}
%>




 <div class="titleBg">
<h2>View StockTaking Details <%out.print(message); %></h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="ApprovalOfStockTaking" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">

<label> StockTaking Date </label>
<input  type="text"  id="StockTakingDate" name="StockTakingDate"  validate="StockTakingDate,string,yes" value="<%out.print(Date); %>"  readonly/>


<label>StockTaking No. </label>
	
<input	type="text" name="indentNo" value="<%=StockTakingNo%>" readonly="readonly" validate="Indnet No ,String,yes" tabindex=1  readonly/>

<label>Submitted By </label>
	
<input	type="text" name="poNo" value="<%=SubmittedBy%>" readonly="readonly" validate="Purchase Order No ,String,yes" tabindex=1  readonly/>

<div class="clear"></div>
<label>Reason for Stock Taking</label>
<textarea  name="remarks" MAXLENGTH="490" validate="Remarks,string,no" style="width: 250px; height: 50px;"><% out.print(Reason); %></textarea>
	
	
</div>  
	
	
 
	

	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="stockHeaderId" value="<%=stockHeaderId %>" id="stockHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		

<div class="clear"></div>
<div class="cmntable">
<table id="StockTakingGrid">
		
		<tr id="th">
		
         <th>Sl No.</th>
		<th>Mat Code</th>
		<th>Nomenclature</th>		
		<th>Batch No.</th>
		<th>Expiry Date</th>
		<th>Computed Stock</th>
		<th>Physical Stock</th>
		<th>Surplus</th>
		<th>Deficient</th>
		
		<th>Remarks</th>
</tr>
	      
    	
    
 	<%
 	int counter =1;
		for(StoreStockTakingT detailsList :stockTakingDetail)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		
     
      <td><input type="text" name="itemCodee" tabindex="1" value="<%out.print(counter); %>" readonly/></td>
      <td><input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>"  validate="PVMS No,String,no" size="12" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getPvmsNo():""); %>" readonly/></td>
      
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes'  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="70" value="<%out.print(detailsList.getItem()!=null?detailsList.getItem().getNomenclature():""); %>" readonly />
				</td> 

<td><input type="text" name="batchNo<%out.print(detailsList.getId()); %>" id="batchNo<%out.print(detailsList.getId()); %>"  value="<%out.print(detailsList.getBatchNo()); %>" readonly="readonly"  size="7"/>


<td><input type="text" name="expiryDate<%out.print(detailsList.getId()); %>" id="expiryDateId<%out.print(detailsList.getId()); %>"  value="<%=(detailsList.getExpiryDate()!=null?HMSUtil.convertDateToStringWithoutTime(detailsList.getExpiryDate()):"") %>" readonly="readonly" size="10" />
</td>

<td>
<input type="text" name="computedStock<%out.print(detailsList.getId()); %>" id="computedStock<%out.print(detailsList.getId()); %>"  value="<%=detailsList.getComputedStock()%>"  size="14"/></td>
<td><input type="text" name="physicalStock<%out.print(detailsList.getId()); %>" id="physicalStock<%out.print(detailsList.getId()); %>" value="<%=(detailsList.getStoreStockService()!= null?detailsList.getStoreStockService():"") %>" size="14"  onblur="calulateStock(this,'<%=detailsList.getId() %>');" validate="Physical Stock,TwoDigitAfterDecimal,no"/></td>
<td><input type="text"	 size="8" name="surplus<%out.print(detailsList.getId()); %>" id="surplus<%out.print(detailsList.getId()); %>" value="<%=detailsList.getStockSurplus()%>" readonly="readonly" /></td>
<td><input type="text" size="8" name="deficient<%out.print(detailsList.getId()); %>"	id="deficient<%out.print(detailsList.getId()); %>" value="<%=detailsList.getStockDeficient()%>" readonly="readonly" /></td>

<td><input type="text" name="remarks<%out.print(detailsList.getId()); %>" MAXLENGTH="399" id="remarks<%out.print(detailsList.getId()); %>" validate="Remarks,string,no" value="<%=detailsList.getRemarks()%>" size="15" style="width: 200px; height: 40px;"/></td>
	  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
   
     	 
	
</table>
</div>
	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" value="APPROVE"/>
</form>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
  if(ApprovedBy.equalsIgnoreCase("NA"))
  {
	  %>
	  <input type="button" name="add1" id="addbutton" value="Approve" class="button" onClick="approveStockTaking('ApprovalOfStockTaking','/hms/hms/stores?method=updateStockTaking');"  tabindex=1 />
	  <%
  }
%>											

<input type="button" name="add2" id="addbutton" value="Back To List" class="button" onClick="submitForm('ApprovalOfStockTaking','/hms/hms/stores?method=pendingListforApprovalofStockTacking&selectedAppId=A1763');"  tabindex=1 />
<input type="button" name="add3" id="addbutton" value="Print Report" class="button" onClick="submitForm('ApprovalOfStockTaking','/hms/hms/stores?method=printStockAdjustmentRpt&stockTakingMId=<%out.print(stockHeaderId); %>&selectedAppId=A1763');"  tabindex=1 />
	
	
	
	
    
    
    
	
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		<script type="text/javascript">
		
		function calulateStock(obj,row)
		{
			var computedStockCal = parseFloat(document.getElementById('computedStock'+row).value);
			var physicalStock = parseFloat(document.getElementById('physicalStock'+row).value);
			//var storeStockDefectiveCal = parseFloat(document.getElementById('stockDefective'+row).value);
			var surplusStockCal = parseFloat(document.getElementById('surplus'+row).value);
			var deficientCal = parseFloat(document.getElementById('deficient'+row).value);
			if (isNaN(computedStockCal) || isNaN(physicalStock))
			{
			alert('Please Check the Inputs!....');
			return;
			}
			var difference = parseFloat(physicalStock) - parseFloat(computedStockCal);


			if (difference > 0)
			{
				document.getElementById('surplus'+row).value=parseFloat(difference);
				document.getElementById('deficient'+row).value="0";
			}

			if (difference < 0)
			{
				document.getElementById('deficient'+row).value=parseFloat(difference) * -1;
				document.getElementById('surplus'+row).value="0";
			}

			if (difference == 0)
			{
				document.getElementById('deficient'+row).value="0";
				document.getElementById('surplus'+row).value="0";
			}

		}
		
		function approveStockTaking(formName,url)
		{
			$j("#txtRequestType").val("APPROVE");
			 var valRowId = new Array();
				$j("#StockTakingGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
						
						
				 submitForm(formName,url);
			
	}
		
		 </script>