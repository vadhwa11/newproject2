<%@page import="java.util.*"%>
<%@page
	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnT"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnT"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);


</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printVendorReturnJsp";
  obj.submit();
}


</script>
<%
	int returnId = 0;
	 int pageNo=0;
	int storeFyDocumentNoId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	String buttonFlag="";
	
    
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));
	
	int deptId=departmentIdForReturnFromDispensary;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {
		
		timeInHHmm=timeInHHmm+(String)tempArr[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
		System.out.println( "===and button falg in jsp==="+buttonFlag);
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
		System.out.println( "===and page number in jsp==="+pageNo);
	}
	
	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
		System.out.println("deptartment id in  list jsp==="+deptId);
	}
	if(map.get("returnId") != null)
	{
		returnId=(Integer)map.get("returnId");
		System.out.println("returnId id in  list jsp=== returnId"+returnId);
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String fromDateToDate=(String)map.get("fromDateToDate");
	
	List listOfItemsInStock=new ArrayList();
	List brandList= new ArrayList();
	List returnNoList= new ArrayList();
	List<StoreGrnReturnM> searchReturnMList = new ArrayList<StoreGrnReturnM>();
	List<StoreGrnReturnT> searchReturnTList = new ArrayList<StoreGrnReturnT>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	try {
		if(map.get("infoMap") != null){
			infoMap = (Map<String, Object>)	map.get("infoMap") ;
		}
		if(infoMap.get("listOfItemsInStock") != null){
			listOfItemsInStock=(List)infoMap.get("listOfItemsInStock");
		}
		if (infoMap.get("deptList") != null) {
			deptList = (List)infoMap.get("deptList");
		}
		if (infoMap.get("brandList") != null) {
			brandList = (List)infoMap.get("brandList");
		}
		if (infoMap.get("returnNoList") != null) {
			returnNoList = (List)infoMap.get("returnNoList");
		}
		if (infoMap.get("supplierList") != null) {
			supplierList = (List)infoMap.get("supplierList");
		}
		if (infoMap.get("employeeList") != null) {
			employeeList = (List<MasEmployee>)infoMap.get("employeeList");
		}
		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
		if(map.get("searchReturnMList") != null){
			searchReturnMList = (List<StoreGrnReturnM>)map.get("searchReturnMList"); 
		}
		if(map.get("searchReturnTList") != null){
			searchReturnTList = (List<StoreGrnReturnT>)map.get("searchReturnTList"); 
		}
	} catch (Exception exp) {
			out.println("-------------------------------------------"+ exp);
		exp.printStackTrace();
	}
  %>

<% 
  		
			int k=0;
  					Iterator itr = listOfItemsInStock.iterator();
  					int brandId=0;
  					while(itr.hasNext())
  					{
  						try{
  						 Object[] pair = (Object[]) itr.next();
  			         	 StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
  			         	 BigDecimal qtyInHand = (BigDecimal) pair[1];
  			         	 String pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
  			         	 int itemId=storeItemBatchStock.getItem().getId();
  			        	 String nomenclature=storeItemBatchStock.getItem().getNomenclature();
  			        	 String batchNumber=storeItemBatchStock.getBatchNo();
  			        	// Date expiryDate=storeItemBatchStock.getExpiryDate();
  			        	// String dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        	 BigDecimal costprice=storeItemBatchStock.getCostPrice();
  			        	 if(storeItemBatchStock.getBrand()!= null)
  			        	 {
  			        	  brandId=storeItemBatchStock.getBrand().getId();
  			        	 }else{
  			        		 brandId=0;
  			        	 }
  			        	String brandName = "";
  			        	if(storeItemBatchStock.getBrand()!= null){
  			        	 brandName=storeItemBatchStock.getBrand().getBrandName();
  			        	}
  			        	 
 			%>
<script>
         		 
         		nameArray[<%=k%>]= new Array();
         		nameArray[<%=k%>][0] = "<%=storeItemBatchStock.getId()%>";
				nameArray[<%=k%>][1] = "<%=pvmsNo%>";
				nameArray[<%=k%>][2] = "<%=itemId%>";
				nameArray[<%=k%>][3] = "<%=brandName%>";
         		nameArray[<%=k%>][4] = "<%=date%>";
         		nameArray[<%=k%>][5] = "<%=brandId%>";
         		nameArray[<%=k%>][6] = "<%=nomenclature%>";
         		
         		codeArray[<%=k%>]="<%=storeItemBatchStock.getItem().getNomenclature()%>"
         		</script>
<%}catch(Exception e){
        	  %>
There are some errors !!!
<%
        	
        	  e.printStackTrace();
        	  }
         	 k++;
			}
  		  %>
<div id="contentspace"><br />
<!-- <jsp:include page="searchResultPO.jsp" />--> <!-- </form> -->

<form name="search" method="post">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <!--  code to make the search panel -->


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Modify Quantity Issued</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('returnVendor');"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">


<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%=FROM_DATE%>" value="<%=date %>"
			class="textbox_date" validate="From Date,dateOfAdmission,no"
			MAXLENGTH="30" /> <a
			href="javascript:setdate('<%=date%>',document.search.<%=FROM_DATE%>,true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" /> </a> <label
			class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%=TO_DATE%>" value="<%=date %>" class="textbox_date"
			validate="To Date,dateOfAdmission,no" MAXLENGTH="30" /> <a
			href="javascript:setdate('<%=date%>',document.search.<%=TO_DATE%>,true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" /> </a> <br />

		<label class="bodytextB_blue">Return Number:</label> <input
			type="button" class="smbutton" value="Go!"
			onClick="submitForm('search','stores?method=searchReturnToDispensary');" />
		<br />
		</td>
	</tr>

</table>
</form>

</div>
<br>
</div>
</div>
</div>

<form name="returnVendor" method="post"><!--  code to make the search panel -->
<input name="<%=ISSUE_RETURN_ID %>" value="<%=returnId %>" type="hidden" />
<%
	
	String returnNo = "";
	
	if(map.get("finalReturnNo") != null){
		System.out.println("(((((((((((((( IN IF  ))))))))))))))))");
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		System.out.println("(((((((((((((( IN ELSE  ))))))))))))))))");
		returnNo = (String)map.get("returnNo");
	}
		//List<StoreFyDocumentNo> issueReturnNoList=(List<StoreFyDocumentNo>)map.get("issueReturnNoList");
		//StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)issueReturnNoList.get(0);
		//returnNo = (""+storeFyDocumentNo.getIssueDeptReturnNo());
		//returnNo = returnNo + 1;
	%> <br />
<%
if(searchReturnMList.size() > 0){
	for (StoreGrnReturnM mObj : searchReturnMList) {
		
%> <input type="hidden" id="returnNo" value="<%= mObj.getReturnNo()%>"
	name="testReturnNo" readonly />

<div id=biglabel class="bodytextB_blue">Return Date :</div>
<input type="text" name="<%=RETURN_DATE%>" id="returnDate"
	value="<%=mObj.getReturnDate() %>" class="textbox_date"
	validate="Return Date,dateOfAdmission,yes" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=date%>',document.returnVendor.<%=RETURN_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a>

<div id=biglabel class="bodytextB_blue"><font id="error">*</font>Reference
No:</div>
<input type="text" class="textbox_size20" id="referenceNo"
	name="<%=REFERENCE_NO %>" value="<%=mObj.getRefDocNo() %>"
	validate="Reference No ,String,yes" tabindex=1 /> <br />
<br />
<div id=biglabel class="bodytextB_blue"><font id="error">*</font>Vendor
Name:</div>
<select name="<%=TO_WARD %>" id="toWard"
	validate="To Department ,String,yes">
	<option value="0">Select</option>
	<%for(MasStoreSupplier storeSupplier :supplierList){
		if(storeSupplier.getId()==mObj.getSupplier().getId()){%>
	<option value="<%=storeSupplier.getId() %>" selected="selected">><%=storeSupplier.getSupplierName() %></option>
	<%}else{ %>
	<option value="<%=storeSupplier.getId() %>">><%=storeSupplier.getSupplierName() %></option>
	<%}} %>
</select>
<div id=biglabel class="bodytextB_blue">Supply Order No:</div>
<input type="text" name="<%=FROM_WARD %>" id="fromWard"
	value="<%=mObj.getSupplyOrderNo() %>"> <%
		
		Iterator itrDept=deptList.iterator();
	    while(itrDept.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDept.next();
	    	String deptName=masDepartment.getDepartmentName();
	    	int idFromList=masDepartment.getId();
	    	if(idFromList == departmentIdForReturnFromDispensary){
	    	System.out.println("idfromlist " + idFromList + " deptId " + deptId);
 	%> <label><%=masDepartment.getDepartmentName() %></label> <input
	type="hidden" name="<%=FROM_WARD %>" id="fromWard"
	value="<%=masDepartment.getId() %>"> <%
	    	}
	  }	
	%> <br />
<br />


<div id=biglabel class="bodytextB_blue"><font id="error">*</font>Return
By:</div>
<select name="<%=RETURN_BY_ID %>" id="returnBy"
	validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
		if(masEmployee.getId() == mObj.getReturnBy().getId()){
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}else{
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
		}%>
</select>

<div id=biglabel class="bodytextB_blue"><font id="error">*</font>Approved
By:</div>
<select name="<%=RECEIVED_BY_ID %>" id="receiveBy"
	validate="Received By ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
		if(masEmployee.getId() == mObj.getApprovedBy().getId()){
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}else{
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
		}%>
</select> <br />
<div id=biglabel class="bodytextB_blue">Reason:</div>
<%
	if(mObj.getReason() != null){
	%> <textarea value="" name="<%=REASON %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
	<%=mObj.getReason() %>
	</textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
	<%=mObj.getRemarks() %>
	</textarea> <%} %>

<div id=biglabel class="bodytextB_blue">Remarks:</div>
<%
	if(mObj.getRemarks() != null){
	%> <textarea value="<%=mObj.getRemarks() %>" name="<%=REMARKS %>"
	id="remarks" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
	</textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>" id="remarks"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
	</textarea> <%} %> <%} }%> <br />
<br />
<tr>
	<td>Return No: <input type="text" id="returnNo"
		value="<%= returnNo%>" name="testReturnNo" readonly /> <input
		type="hidden" id="storeFyDocumentNoId"
		value="<%=storeFyDocumentNoId %>" /></td>
</tr>


<input type="button" class="button" value="Next"
	onclick="submitForm('returnVendor','stores?method=searchReturnToDispensary&pageNo=<%=pageNo%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');"
	align="right" /> <input type="button" class="button" value="Delete"
	onclick="openPopupForDelete(<%=brandId%>,'<%=returnNo%>');"
	align="right" /> <!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
Page No:<%=pageNo%> <input type="hidden" size="2" value=""
	name="noOfRecords" id="noOfRecords" /> <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>
Details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="stockDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="16%"><label valign="left" class="smalllabel">Total
			Quantity Returned</label></td>

		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc=1;
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	if(searchReturnTList.size() > 0 && searchReturnTList.size() >= 8){
    	for(StoreGrnReturnT tObj : searchReturnTList){
     %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="13%"><input type="text" class="medcaption"
				value="<%=tObj.getItem().getPvmsNo() %>" name="pvmsNo<%=inc%>"
				readonly="readonly" id="pvmsNo<%=inc%>" /></td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"
				value="" />
			<input type="hidden" name="date" id="date" value="<%=date %>" />
			<input type="hidden" name="time" id="time" value="<%=time %>" />

			<td width="10%"><input type="text"
				value="<%=tObj.getItem().getNomenclature() %>"
				id="nomenclature<%=inc%>" class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly /></td>
			<td width="13%"><input type="text"
				value="<%=tObj.getBrand().getBrandName() %>" name="<%= ITEM_ID%>"
				id="brandName<%=inc%>" class="bigcaption" readonly /></td>
			<td width="16%"><input type="text"
				value="<%=tObj.getReturnQty() %>" class="medcaption"
				name="<%=QTY_ISSUED%>" id="qtyIssued<%=inc%>" value="" readonly /></td>
		</tr>
		<%inc++;}
     	 }else if(searchReturnTList.size() > 0 && searchReturnTList.size() < 8){
     		for(StoreGrnReturnT tObj : searchReturnTList){
     %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="13%"><input type="text" class="medcaption"
				value="<%=tObj.getItem().getPvmsNo() %>" name="pvmsNo<%=inc%>"
				readonly="readonly" id="pvmsNo<%=inc%>" /></td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"
				value="" />
			<input type="hidden" name="date" id="date" value="<%=date %>" />
			<input type="hidden" name="time" id="time" value="<%=time %>" />

			<td width="10%"><input type="text"
				value="<%=tObj.getItem().getNomenclature() %>"
				id="nomenclature<%=inc%>" class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly /></td>
			<td width="13%"><input type="text"
				value="<%=tObj.getBrand().getBrandName() %>" name="<%= ITEM_ID%>"
				id="brandName<%=inc%>" class="bigcaption" readonly /></td>
			<td width="16%"><input type="text"
				value="<%=tObj.getReturnQty() %>" class="medcaption"
				name="<%=QTY_ISSUED%>" id="qtyIssued<%=inc%>" value="" readonly /></td>

			<input type="hidden" value="<%=tObj.getReturnAmount() %>"
				name="<%=AMOUNT%>" />
			</td>

		</tr>
		<%
     	inc++;
     	}	 
          } else{
     %>
		No records to display
		<%
  		}
     %>
	</tbody>
</table>
</fieldset>

</div>


</form>

<script type="text/javascript">


	
	/*	function validatePage(formName) {
			
			var counter=document.getElementById('counter').value;
			//alert(counter)
			formname=formName.name
			//alert(formname)
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			  // alert("amount value=="+amountVal+"  issued quantity value=="+issQtyVal)
				if(amountVal =="" && issQtyVal != "")
				{
					alert("Please Enter the correct value in Issued Quantity")
					return false
				}
				if(amountVal !="" && issQtyVal == "")
				{
					alert("Please Enter the Issued Quantity")
					return false
				}
		    }
		return true
		}
	*/	
		
	function fillItemsInGrid(brandId,rowVal,deptId){
	
		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			
			}
		}
		openPopup(brandId,deptId,rowVal);
}	
	
	
	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=700,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<=8)
	  {
	  	alert("All rows are not filled.Please Select the Brand Names to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
  
	function openPopupForDelete(brandId,returnNo){
		var url="/hms/hms/stores?method=showDeleteReturnFromDispensary&brandId="+brandId+"&returnNo="+returnNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }	
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="hidden" name="rows" id="rr" value="1" />










