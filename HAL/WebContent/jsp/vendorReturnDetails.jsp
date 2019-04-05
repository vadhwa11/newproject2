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
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.RequestConstants"%>
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
	List<StoreGrnReturnM> searchList = new ArrayList<StoreGrnReturnM>();
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
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	
	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
	}
	if(map.get("returnId") != null)
	{
		returnId=(Integer)map.get("returnId");
	}
	if (map.get("searchList") != null) {
		searchList = (List<StoreGrnReturnM>)map.get("searchList");
	}
	Box box = HMSUtil.getBox(request);

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
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
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
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
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
		if(map.get("supplierList") != null){
			supplierList=(List)map.get("supplierList");
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
<div id="testDiv"><input type="hidden" name="pageNo"
	value="<%=pageNo%>" /> <!--  code to make the search panel --></div>
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('returnSearch');"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>


</td>
</tr>
</table>


<%--------------- Start of Search Panel ---------------------------%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Vendor No:</label> <select
			name="<%= RequestConstants.VENDOR_RETURN_ID%>"
			validate="MMF Year,num,Yes" id="mmfYear">
			<option value="0">Select</option>
			<%
				try{
					for(StoreGrnReturnM storeGrnReturnM :searchList){ %>
			}
			<option value="<%=storeGrnReturnM.getId() %>"><%=storeGrnReturnM.getReturnNo() %></option>
			<%} }catch(Exception e){
					e.printStackTrace();
				}%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('search','stores?method=searchVendorReturn&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
		</td>
	</tr>
</table>
</form>
</div>
</div>
</div>
<%-------------------- End of Search Panel ---------------------------%>
</form>



<form name="returnSearch" method="post"><!--  code to make the search panel -->
<input name="<%=ISSUE_RETURN_ID %>" value="<%=returnId %>" type="hidden" />
<%
	
	String returnNo = "";
	
	if(map.get("finalReturnNo") != null){
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		returnNo = (String)map.get("returnNo");
	}
		
	%> <br />
<%
int count =0;
	if(searchReturnMList.size() > 0){
	for (StoreGrnReturnM mObj : searchReturnMList) {
		
%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Vendor return details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 130px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">
<label class="bodytextB"><font id="error"></font>Return No:</label> <input
	type="text" class="textbox_size20" name="<%=RETURN_NO %>"
	id="vendorReturnId" value="<%= mObj.getReturnNo()%>"
	readonly="readonly" validate="Return No ,String,yes" tabindex=1 /> <label
	class="bodytextB">Return Date :</label> <input type="text"
	name="<%=RETURN_DATE%>" id="returnDate"
	value="<%=mObj.getReturnDate() %>" class="textbox_date"
	validate="Return Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=date%>',document.returnSearch.<%=RETURN_DATE%>,event)" />
<label class="bodytextB"><font id="error">*</font>Reference No:</label>
<input type="text" class="textbox_size20" id="referenceNo"
	name="<%=REFERENCE_NO %>" value="<%=mObj.getRefDocNo() %>"
	validate="Reference No ,String,yes" tabindex=1 /> <br />

<label class="bodytextB"><font id="error"></font>Vendor name :</label> <select
	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Vendor ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasStoreSupplier  storeSupplier : supplierList) {
	%>
	<option value="<%=storeSupplier.getId() %>"
		<%=HMSUtil.isSelected(storeSupplier.getId().toString(),mObj.getSupplier().getId().toString()) %>><%=storeSupplier.getSupplierName()%></option>
	<%
	}
	%>
</select> <label class="bodytextB"><font id="error"></font>SO No :</label> <input
	type="text" class="textbox_size20" name="<%=RETURN_NO %>" id="returnNo"
	value="<%= mObj.getSupplyOrderNo()%>" readonly="readonly"
	validate="Return No ,String,yes" tabindex=1 /> <br />

<label class="bodytextB"><font id="error">*</font>Return By:</label> <select
	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Return By,String,yes">
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
</select> <label class="bodytextB"><font id="error">*</font>Approved By:</label>
<select name="<%=RECEIVED_BY_ID %>" id="receiveBy"
	validate="Approved By ,String,yes">
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
<label class="bodytextB">Reason:</label> <%
	if(mObj.getReason() != null){
	%> <textarea value="" name="<%=REASON %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=mObj.getReason() %></textarea> <%}else{ %> <textarea value=""
	name="<%=REASON %>" id="reason" validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /></textarea> <%} %> <label class="bodytextB">Remarks:</label> <%
	if(mObj.getRemarks() != null){
	%> <textarea value="<%=mObj.getRemarks() %>" name="<%=REMARKS %>"
	id="remarks" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=mObj.getRemarks() %></textarea> <%}else{ %> <textarea value=""
	name="<%=REMARKS %>" id="remarks" validate="Remarks ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /></textarea> <%} %> <%} }%> <br />
<br />


<input type="hidden" id="returnNo" value="<%= returnNo%>" readonly /> <input
	type="hidden" id="storeFyDocumentNoId"
	value="<%=storeFyDocumentNoId %>" /></div>


<input type="button" class="button" value="Next"
	onclick="submitForm('returnSearch','stores?method=searchVendorReturn&pageNo=<%=pageNo%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');"
	align="right" /> <input type="button" class="button" value="Delete"
	onclick="openPopupForDelete(<%=brandId%>,'<%=returnNo%>');"
	align="right" /> <!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
Page No:<%=pageNo%> <input type="hidden" size="2" value=""
	name="noOfRecords" id="noOfRecords" /> <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<br />



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
    	int inc=0;
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	if(searchReturnTList.size() > 0 && searchReturnTList.size() >= 8){
    	for(StoreGrnReturnT tObj : searchReturnTList){
    		inc++;
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
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <input type="hidden" name="rows" id="rr" value="1" /></div>






