<%@page import="jkt.hms.masters.business.MprPriority"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnT"%>

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


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	
	
	List<StoreInternalReturnM> returnHeader = new ArrayList<StoreInternalReturnM>();
	List<StoreInternalReturnT> returnDetails = new ArrayList<StoreInternalReturnT>();						
	
	
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
	
		
	 if(map.get("returnDetails")!=null)
		{
			returnDetails = (List<StoreInternalReturnT>) map.get("returnDetails");
		}
		if(map.get("returnHeader")!=null)
		{
			returnHeader = (List<StoreInternalReturnM>) map.get("returnHeader");
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
		
	int empId = 0;
		if(session.getAttribute("empId") != null){
			empId = (Integer)session.getAttribute("empId");
		}
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }	
	 
	 
		
		int returnHeaderId= 0;
		String ReturnDate ="";	
		String ReturnNo="";
		String ReturnBy = "";
		String FromDepartment="";
		String Reason="";
		
	    int ReceivedBy=0;
		String ProposedName="";
		for(StoreInternalReturnM header: returnHeader)
		{
			returnHeaderId = header.getId();
			if(header.getReturnDate() != null)
				ReturnDate = HMSUtil.changeDateToddMMyyyy(header.getReturnDate());
			
			ReturnNo = (header.getReturnNo()!=null?header.getReturnNo():"");
			Reason = (header.getReason()!=null?header.getReason():"");
			
					
			ReturnBy = (header.getReturnBy() != null?header.getReturnBy().getFirstName():"");
			FromDepartment = (header.getFromDepartment() != null?header.getFromDepartment().getDepartmentName():"");
			ReceivedBy = (header.getReceivedBy() != null?header.getReceivedBy().getId():0);
			
		}
		
		
%>




 <div class="titleBg">
<h2>Receiving the Return of the Expired Drugs <%out.print(message); %></h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="ReceiveReturnDrug" method="post">
<div id="testDiv" size="height:500px;">

	
<br /><br />
<div class="Block">
<label>Return No.</label>
	
<input	type="text" name="ReturnNo" value="<%=ReturnNo%>" readonly="readonly" validate="Return No ,String,yes" tabindex=1  id="ReturnNo"/>


<label> Return Date</label>
<input  type="text" class="input_date"  id="ReturnDate" name="ReturnDate"  validate="Date,string,yes" value="<%out.print(ReturnDate); %>"  maxlength="10" readonly/>

<label>Return By</span></label>
<input	type="text" name="Return"  tabindex=1  id="Return" value="<% out.print(ReturnBy);%>" readonly/>


<div class="clear"></div>
<label>From Department</label>
<input	type="text" name="Department"  tabindex=1  id="Department" value="<% out.print(FromDepartment);%>" readonly/>


<label>Reason</label>
<textarea rows="" cols=""><% out.print(Reason);%></textarea>


	 
	
</div>  
	
	
 


	
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="returnHeaderId" value="<%=returnHeaderId %>" id="returnHeaderId" />
		<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
		<input type="hidden" name="empId" value="<%=empId%>" />
		
		
	

	
<div class="clear"></div>
<div class="cmntable">
<table id="DrugGrid">
		
		<tr id="th">
		
         
         
	      <th width="2%">Sl No.</th>
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="15%">Batch No</th>
	      
	      <th width="15%">DOE</th>
	      <th width="15%">Brand</th>
	      <th width="15">Qty Returned</th>
	      <th width="15%">Qty Received</th>	      
		   <th width="20%">Remarks for Discrepancy</th>
		 	
	   
	      
    	</tr>
    
 	<%
 	int counter =1;
		for(StoreInternalReturnT detailsList :returnDetails)
		{
			
			%>
 
  
        <tr id="<%out.print(detailsList.getId()); %>">
      
		<%-- <td><input size="2" type="checkbox" class="small_chk" id="chk" value="<%out.print(detailsList.getId()); %>" /></td> --%>
		<td id="SRNO"><input size="2" type="text" value="<%out.print(counter); %>" readonly /></td>
	       
      <td>
      <input type="text" name="itemCode" tabindex="1" id="itemCode<%out.print(detailsList.getId()); %>" onblur="autocompleteBasedOnPvms(this.value,'<%=detailsList.getId() %>');" validate="PVMS No,String,no" size="12" value="<%=detailsList.getItem().getPvmsNo() %>" readonly/>
      <input type="hidden" name="ItemId<%out.print(detailsList.getId()); %>" tabindex="1" id="ItemId<%out.print(detailsList.getId()); %>" />																	
      </td>
      
		<td> 	<input type="text" id="nameItem<%=detailsList.getId() %>" validate='Nomenclature ,String,yes'  name="nameItem<%=detailsList.getId() %>" tabindex="1" size="40" value="<%=detailsList.getItem().getNomenclature() %>[<%=detailsList.getItem().getPvmsNo() %>]" readonly />

		</td> 
      <td>
      <input type="text"  class="smcaption" readonly="readonly" name="AV<%out.print(detailsList.getId()); %>" id="idAu<%out.print(detailsList.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8" value="<%=detailsList.getItem().getItemConversion().getItemUnitName()%>" readonly />
      </td>
      <td> <input  size="15" type="text" id="batchNo" name="batchNo" value="<%out.print(detailsList.getBatchNo()!=null?detailsList.getBatchNo():""); %>" readonly/>
      
      <td> <input  size="15" type="text" id="DOE" name="DOE" value="<%out.print(detailsList.getExpiryDate()!=null?detailsList.getExpiryDate():""); %>" readonly/>
      <td> <input  size="15" type="text" id="Brand" name="Brand" value="<%out.print(detailsList.getBrand()!=null?detailsList.getBrand().getBrandName():""); %>" readonly/>
      <td> <input  size="15" type="text" id="ReturnedQty" name="ReturnedQty" value="<%out.print(detailsList.getReturnQty()!=null?detailsList.getReturnQty():""); %>" readonly/>
          <td> <input  size="15" type="text"   onkeypress ="return isNumber(event);"  id="txtReceivedQty<%out.print(detailsList.getId()); %>" name="txtReceivedQty<%out.print(detailsList.getId()); %>" value="<%out.print(detailsList.getReturnQty()!=null?detailsList.getReturnQty():""); %>" /></td>
          <td> <textarea size ="20" class="large"  id="txtRemarks<%out.print(detailsList.getId()); %>" class="medium3"  name="txtRemarks<%out.print(detailsList.getId()); %>"  validate="Remarks,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ></textarea></td>
          
       
		  
   
       </tr>
       
       <%
       counter++;
		}
 	
 	%>
  
     	 
	
</table>
</div>
	
	

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
	<%
	if(ReceivedBy == 0)
	{
		%>
			
			<input type="button" name="Submit"  class="button" value="Submit" onclick="submitDrugForm('ReceiveReturnDrug','stores?method=saveStockofReturnDrugs&returnId=<%out.print(returnHeaderId); %>&appId=A1523');"/>
		<%
	}
	
	%>
	<%-- <input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('ReceiveReturnDrug','/hms/hms/stores?method=generateMrp&mrpId=<%=returnHeaderId %>');"  tabindex=1 /> --%>
	
	
	
    
    
    
	</div>
    
	<div class="clear"></div>
	<div class="division"></div>
		
			 
	<script type="text/javascript">
		
		
		
		function submitDrugForm(formName,url)
		{
			$j("#txtRequestType").val("SUBMIT");
			 var valRowId = new Array();
				$j("#DrugGrid tr[id!='th']").each(function(j)
						{				
							valRowId[j] =$j(this).attr("id");
						});		
				
				$j("#tableRowId").val(valRowId);
					
				 submitForm(formName,url);
			
	}
		
		
		
		
		
		
		 </script>