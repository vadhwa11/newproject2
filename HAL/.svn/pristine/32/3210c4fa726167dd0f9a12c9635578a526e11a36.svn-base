<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showWardConsumption.jsp  
 * Purpose of the JSP -  This is showing Ward Consumption.
 * @author  Deepali
 * @author  Vikas
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*, java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	
	
		int deptId = (Integer)map.get("deptId");
		String date=(String)map.get("date");
		String time=(String)map.get("time");
		String fromDateToDate=(String)map.get("fromDateToDate");
	
	
	List listOfItemsInStock=new ArrayList();

	try {
			
				
		//			patientSet=(Set)map.get("patientSet");
					listOfItemsInStock=(List)map.get("listOfItemsInStock");
				 
	//	 nursingCareList=(List)	session.getAttribute("nursingCareList");
		System.out.println("Size of List in jsp -------"+listOfItemsInStock.size());
	//	System.out.println("Size of nursingCareList -------"+nursingCareList.size());
		
	} catch (Exception exp) {
			out.println("-------------------------------------------"+ exp);
		exp.printStackTrace();
	}
	
	
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>



<div id="contentspace">
<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %> <jsp:include page="searchResultBlockForIPD.jsp" />


<form name="wardConsumption" method="post">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		List ipIssueNo=(List)map.get("ipIssueNo");
		StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)ipIssueNo.get(0);
		int issueNoOfWard=storeFyDocumentNo.getIssueWardNo();
		issueNoOfWard=issueNoOfWard+1;
	%>
<tr>
	<td>IP Issue No <input type="text" name="ipissueno"
		value="<%= issueNoOfWard%>" readonly /> <input type="hidden"
		name="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>" />
	<input type="hidden" name="ipissueno" value="<%= issueNoOfWard%>" />
	</td>
	<%
	    int k=0;
		Iterator itr1=listOfItemsInStock.iterator();
		while(itr1.hasNext())
			{
			 Object[] pair = (Object[]) itr1.next();
        	  StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
				
		%>
	<script>
				nameArray[<%=k%>] = "<%=storeItemBatchStock.getBatchNo()%>";
			</script>
	<%
		k++;
		}
		
	%>
	<td>test <input type="text" name="test" id="test" value="" /> <script>
		var obj = actb(document.getElementById('test'),nameArray);
	</script></td>
</tr>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.PVMS_NO%>"], [3,"<%= RequestConstants.DRUG_NAME %>"], [4,"<%= RequestConstants.BRAND_NAME %>"], [5,"<%= RequestConstants.QTY_IN_HAND %>"],[6,"<%= RequestConstants.BATCH_NO %>"],[7,"<%= RequestConstants.EXPIRY_DATE %>"],[8,"<%= RequestConstants.ISSUE_QUANTITY %>"],[9,"<%= RequestConstants.RATE %>"],[10,"<%= RequestConstants.AMOUNT %>"],[11,"<%= RequestConstants.PVMS_NO %>"],[12,"<%= RequestConstants.BATCH_NO %>"],[13,"<%= RequestConstants.BRAND_NAME %>"],[14,"<%= RequestConstants.DATE_OF_EXPIRY %>"],[15,"<%= RequestConstants.RATE %>"],[16,"<%= RequestConstants.STORE_ITEM_BATCH_STOCK_ID %>"] ];
	 statusTd =16;

</script> <!--  <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

<div style="width: 45px; padding-left: 18px; padding-top: 10px;">
<input type="button" class="button" value="Submit " align="left"
	onClick="if(validatePage(wardConsumption)){submitForm('wardConsumption','ipd?method=submitWardConsumptionDetails');}" />
</div>


<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Serial Number"
		data_header[0][1] = "data";
		data_header[0][2] = "2%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "PVMS/NIV No"
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.PVMS_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Nomenclature"
		data_header[2][1] = "data";
		data_header[2][2] = "8%";
		data_header[2][3] = "<%= RequestConstants.DRUG_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Brand Name"
		data_header[3][1] = "data";
		data_header[3][2] = "8%";
		data_header[3][3] = "<%= RequestConstants.DRUG_NAME %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "QOH"
		data_header[4][1] = "data";
		data_header[4][2] = "3%";
		data_header[4][3] = "<%= RequestConstants.QTY_IN_HAND %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Batch Number"
		data_header[5][1] = "data";
		data_header[5][2] = "4%";
		data_header[5][3] = "<%= RequestConstants.BATCH_NO %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Expiry Date"
		data_header[6][1] = "data";
		data_header[6][2] = "4%";
		data_header[6][3] = "<%= RequestConstants.EXPIRY_DATE %>";
		
		
		
		data_header[7] = new Array;
		data_header[7][0] = "Issue Qty"
		data_header[7][1] = "data";
		data_header[7][2] = "3%";
		data_header[7][3] = "<%= RequestConstants.ISSUE_QUANTITY %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Rate"
		data_header[8][1] = "data";
		data_header[8][2] = "3%";
		data_header[8][3] = "<%= RequestConstants.RATE %>";
		
		data_header[9] = new Array;
		data_header[9][0] = "Amount"
		data_header[9][1] = "data";
		data_header[9][2] = "4%";
		data_header[9][3] = "<%= RequestConstants.AMOUNT %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "pvms Id"
		data_header[10][1] = "hide";
		data_header[10][2] = "4%";
		data_header[10][3] = "<%= RequestConstants.PVMS_NO %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "Batch No"
		data_header[11][1] = "hide";
		data_header[11][2] = "4%";
		data_header[11][3] = "<%= RequestConstants.BATCH_NO %>";
		
		data_header[12] = new Array;
		data_header[12][0] = "Brand Name"
		data_header[12][1] = "hide";
		data_header[12][2] = "4%";
		data_header[12][3] = "<%= RequestConstants.BRAND_NAME %>";
		
		data_header[13] = new Array;
		data_header[13][0] = "Expiry Date"
		data_header[13][1] = "hide";
		data_header[13][2] = "4%";
		data_header[13][3] = "<%= RequestConstants.DATE_OF_EXPIRY %>";
		
		data_header[14] = new Array;
		data_header[14][0] = "Expiry Date"
		data_header[14][1] = "hide";
		data_header[14][2] = "4%";
		data_header[14][3] = "<%= RequestConstants.RATE %>";
		
		data_header[15] = new Array;
		data_header[15][0] = "Store Item Batch Stock Id"
		data_header[15][1] = "hide";
		data_header[15][2] = "4%";
		data_header[15][3] = "<%= RequestConstants.STORE_ITEM_BATCH_STOCK_ID %>";
		
		data_arr = new Array();
		
		<%
			String st="";
			Iterator iterator=listOfItemsInStock.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {           
		        	  Object[] pair = (Object[]) iterator.next();
		         	  StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
		         	  BigDecimal qtyInHand = (BigDecimal) pair[1];
		         	 String pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
		         	 int pvmsId=storeItemBatchStock.getItem().getId();
		        	 String nomenclature=storeItemBatchStock.getItem().getNomenclature();
		        	 String batchNumber=storeItemBatchStock.getBatchNo();
		        	 Date expiryDate=storeItemBatchStock.getExpiryDate();
		        	 String dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
		        	 BigDecimal costprice=storeItemBatchStock.getCostPrice();
		        	 int brandId=storeItemBatchStock.getBrand().getId();
		        	 String brandName=storeItemBatchStock.getBrand().getBrandName(); 
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=storeItemBatchStock.getId()%>
			
			data_arr[<%= i%>][1] = <%=i%>+1
			
			<%
				if(pvmsNo != null || pvmsNo !="")
				{
			%>
			data_arr[<%= i%>][2] = "<%=pvmsNo%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(nomenclature != null || nomenclature !="")
			   {
			%>
			data_arr[<%= i%>][3]="<%=nomenclature%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}if(brandName != null)
				{
			%>
			data_arr[<%= i%>][4]="<%=brandName%>"
			<%		
				}else
				{
			%>
			data_arr[<%= i%>][4]=""
			<%		
				}
			   if(qtyInHand != null )
			   {
			%>
			data_arr[<%= i%>][5] = "<%=qtyInHand%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][5] = ""
			<%
			   }if(batchNumber!= null || batchNumber!= "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=batchNumber%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(dateOfExpiryInString != null || dateOfExpiryInString != "")
			   {
			%>
			data_arr[<%= i%>][7] = "<%=dateOfExpiryInString%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%
			   }
			%>
			data_arr[<%= i%>][8] = '<input type="text"  name="issueQty<%= i%>" id="issueQty<%= i%>" value="" onblur="validateIssQty(\'wardConsumption\',this,amount<%= i%>,<%=costprice%>,<%=qtyInHand%>);"  />'
			
			<%
			   if(costprice != null )
			   {
			%>
			data_arr[<%= i%>][9] = "<%=costprice%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][9] = ""
			<%
			   }
			%>
			
			data_arr[<%= i%>][10] = '<input type="text"  name="amount<%= i%>" value="" readonly />'
			data_arr[<%= i%>][11] = '<input type="hidden"  name="pvmsId<%= i%>" value="<%=pvmsId %>"  />'
			data_arr[<%= i%>][12] = '<input type="hidden"  name="batchNo<%= i%>" value="<%=batchNumber %>"  />'
		    data_arr[<%= i%>][13] = '<input type="hidden"  name="brandId<%= i%>" value="<%=brandId %>"  />'
		    data_arr[<%= i%>][14] = '<input type="hidden"  name="expiryDate<%= i%>" value="<%=dateOfExpiryInString %>"  />'
		    data_arr[<%= i%>][15] = '<input type="hidden"  name="costprice<%= i%>" value="<%=costprice %>"  />'
		    data_arr[<%= i%>][16] = '<input type="hidden"  name="storeItemBatchStockId<%= i%>" value="<%=storeItemBatchStock.getId() %>"  />'
				
		<% 
			i++;
			
		  }
		%> 
		formName = "wardConsumption"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGrid(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="date" value="<%=date %>" /> <input type="hidden"
	name="time" value="<%=time %>" /> <input type="hidden"
	name="fromDateToDate" value="<%=fromDateToDate %>" /> <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>
</div>

