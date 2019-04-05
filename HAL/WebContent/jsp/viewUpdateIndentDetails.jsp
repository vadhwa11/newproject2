<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>

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

	List<StoreIndentM> indentHeader = new ArrayList<StoreIndentM>();
	List<StoreIndentT> indentDetails = new ArrayList<StoreIndentT>();
	
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
	
		
	 if(map.get("indentDetails")!=null)
		{
			indentDetails = (List<StoreIndentT>) map.get("indentDetails");
		}
		if(map.get("indentHeader")!=null)
		{
			indentHeader = (List<StoreIndentM>) map.get("indentHeader");
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
	 
	 
		
		int indentHeaderId= 0;
		String quotationDate ="";
		String IndentDate ="";
		String deliveryDate ="";
		String year = "";
		String quotationNo="";
		String IndentNo="";
		String PONo="";
		String vendorName="";
		String deliveryInstruction="";
		String Stockist="";
		
		String IndentStatus = "NA";
			
		for(StoreIndentM header: indentHeader)
		{
			indentHeaderId = header.getId();
			if(header.getIndentDate()!= null)
				IndentDate = HMSUtil.changeDateToddMMyyyy(header.getIndentDate());			
			
			IndentNo = (header.getIndentNo()!=null?header.getIndentNo():"");
			PONo = (header.getPo()!=null?header.getPo().getPoNumber():"");
		    vendorName = (header.getPo().getSupplier()!=null?header.getPo().getSupplier().getSupplierName():"");		
			if(header.getIndentReceivedStatus() != null)
			{
				IndentStatus = (header.getIndentReceivedStatus().equalsIgnoreCase("n")?"Not Received":"Received");
			}
			Stockist = (header.getPo().getStockist()!=null?header.getPo().getStockist().getSupplierName():"");		
			
			
			
			
		}
%>




 <div class="titleBg">
<h2>View Indent Details</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="SupplierIndent" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">

<label> Indent Date </label>
<input  type="text"  id="indentDate" name="indentDate"  validate="Indent Date,string,yes" value="<%out.print(IndentDate); %>"  readonly/>


<label>Indent No. </label>
	
<input	type="text" name="indentNo" value="<%=IndentNo%>" readonly="readonly" validate="Indnet No ,String,yes" tabindex=1  readonly/>

<label>Purchase Order No. </label>
	
<input	type="text" name="poNo" value="<%=PONo%>" readonly="readonly" validate="Purchase Order No ,String,yes" tabindex=1  readonly/>

<div class="clear"></div>
<label>Indent Status:</label>
<input	type="text" name="status" value="<%=IndentStatus%>" readonly="readonly"  tabindex=1  readonly/>
	
	<label> Vendor Name  </label>
	<input  type="text"   id="vendorName" name="vendorName"  validate="Date,string,yes" value="<%out.print(vendorName); %>"   readonly/>

<label> Stockist/Distributor Name </label>
<input	name="stockist" id="stockist" validate="Stockist/Distributo Name,String,yes" tabindex=1 value="<% out.print(Stockist);%>">	

	
	
</div>  
	
	
 
	

	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="poHeaderId" value="<%=indentHeaderId %>" id="poHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		

<div class="clear"></div>
<div class="cmntable">
<table id="IndentGrid">
		
		<tr id="th">
		
         <th width="5%">Sl No</th>
          <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th>
	      <th width="10%">Qty Demanded.</th>
	      <th width="10%">Qty Received.</th>
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreIndentT detailsList :indentDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		
     
      <td><input type="text" name="itemCodee" tabindex="1" value="<%out.print(counter); %>" readonly/></td>
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
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getQtyInDemand()!=null?detailsList.getQtyInDemand():""); %>" readonly />
      </td>
            <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getQtyReceived()!=null?detailsList.getQtyReceived():"0.0"); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getUnitRate()!=null?detailsList.getUnitRate():""); %>" readonly />
      </td>
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="30" value="<%out.print(detailsList.getTotalCost()!=null?detailsList.getTotalCost():""); %>" readonly />
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
<input type="button" name="add" id="addbutton" value="Supplier Indent" class="button" onClick="submitForm('SupplierIndent','/hms/hms/stores?method=generateIndentFormReport&flag=si');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Indent" class="button" onClick="submitForm('SupplierIndent','/hms/hms/stores?method=generateIndentFormReport&flag=i');"  tabindex=1 />
<input type="button" name="add" id="addbutton" value="Back To List" class="button" onClick="submitForm('SupplierIndent','/hms/hms/stores?method=showSupplierIndentList&selectedAppId=A1644&childAppId=A1547');"  tabindex=1 />
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