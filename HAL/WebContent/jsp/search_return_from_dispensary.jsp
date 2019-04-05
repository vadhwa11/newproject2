<%@page import="java.util.*"%>
<%@page	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
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
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script>
<%Calendar calendar = Calendar.getInstance();
			String month1 = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date1 = String.valueOf(calendar.get(Calendar.DATE));
			int year1 = calendar.get(calendar.YEAR);
			if (month1.length() < 2) {
				month1 = "0" + month1;
			}
			if (date1.length() < 2) {
				date1 = "0" + date1;
			}%>
	serverdate = '<%=date1 + "/" + month1 + "/" + year1%>'
</script>
<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();


function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printReturnFromDispensaryJsp";
  obj.submit();
}
</script>
<%
	int returnId = 0;
	int pageNo = 0;
	int storeFyDocumentNoId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	String buttonFlag = "";

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int departmentIdForReturnFromDispensary = Integer
			.parseInt(properties
					.getProperty("departmentIdForReturnFromDispensary"));

	int deptId = departmentIdForReturnFromDispensary;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	String timeInHHmm = "";
	String[] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0; i < tempArr.length - 1; i++) {

		timeInHHmm = timeInHHmm + (String) tempArr[i];
		if (i == 0) {
			timeInHHmm = timeInHHmm + ":";
		}
	}

	if (map.get("buttonFlag") != null) {
		buttonFlag = (String) map.get("buttonFlag");
	}
	if (map.get("pageNo") != null) {
		pageNo = (Integer) map.get("pageNo");
	}

	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
		//System.out.println("deptartment id in SEARCH_RETURN_DISPENSARY list jsp==="+deptId);
	}
	if (map.get("returnId") != null) {
		returnId = (Integer) map.get("returnId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	String fromDateToDate = (String) map.get("fromDateToDate");

	List listOfItemsInStock = new ArrayList();
	List brandList = new ArrayList();
	List returnNoList = new ArrayList();
	List<StoreInternalReturnM> searchReturnMList = new ArrayList<StoreInternalReturnM>();
	List<StoreInternalReturnT> searchReturnTList = new ArrayList<StoreInternalReturnT>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	try {
		if (map.get("infoMap") != null) {
			infoMap = (Map<String, Object>) map.get("infoMap");
		}
		if (infoMap.get("listOfItemsInStock") != null) {
			listOfItemsInStock = (List) infoMap
					.get("listOfItemsInStock");
		}
		if (infoMap.get("deptList") != null) {
			deptList = (List) infoMap.get("deptList");
		}
		if (infoMap.get("brandList") != null) {
			brandList = (List) infoMap.get("brandList");
		}
		if (map.get("returnNoList") != null) {
			returnNoList = (List) map.get("returnNoList");
		}
		if (infoMap.get("employeeList") != null) {
			employeeList = (List<MasEmployee>) infoMap
					.get("employeeList");
		System.out.println("employeeList>>>>>. "+employeeList.size());
		}
		if (map.get("storeFyDocumentNoId") != null) {
			storeFyDocumentNoId = (Integer) map
					.get("storeFyDocumentNoId");
		}
		if (map.get("searchReturnMList") != null) {
			searchReturnMList = (List<StoreInternalReturnM>) map
					.get("searchReturnMList");
		}
		if (map.get("searchReturnTList") != null) {
			searchReturnTList = (List<StoreInternalReturnT>) map
					.get("searchReturnTList");
		}
	} catch (Exception exp) {
		out
				.println("-------------------------------------------"
						+ exp);
		exp.printStackTrace();
	}
%>

<%
	int k = 0;
	Iterator itr = listOfItemsInStock.iterator();
	int brandId = 0;
	while (itr.hasNext()) {
		try {
			Object[] pair = (Object[]) itr.next();
			StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
			BigDecimal qtyInHand = (BigDecimal) pair[1];
			String pvmsNo = storeItemBatchStock.getItem().getPvmsNo();
			int itemId = storeItemBatchStock.getItem().getId();
			String nomenclature = storeItemBatchStock.getItem()
					.getNomenclature();
			String batchNumber = storeItemBatchStock.getBatchNo();
			// Date expiryDate=storeItemBatchStock.getExpiryDate();
			// String dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
			BigDecimal costprice = storeItemBatchStock.getCostPrice();
			if (storeItemBatchStock.getBrand() != null) {
				brandId = storeItemBatchStock.getBrand().getId();
			} else {
				brandId = 0;
			}
			String brandName = "";
			if (storeItemBatchStock.getBrand() != null) {
				brandName = storeItemBatchStock.getBrand()
						.getBrandName();
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
<%
	} catch (Exception e) {
%>
There are some errors !!!
<%
	e.printStackTrace();
		}
		k++;
	}
%>

<!-- <jsp:include page="searchResultPO.jsp" />--> <!-- </form> -->


<div id="testDiv">
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<!--  code to make the search panel -->


 <!-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>  -->



<!-- 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="search" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" /> 
<label>From Date</label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=date%>" class="date" validate="From Date,dateOfAdmission,no" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.search.<%=FROM_DATE%>,event)" />
<label>To Date </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=date%>" class="date" validate="To Date,dateOfAdmission,no" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.search.<%=TO_DATE%>,event)" />
<label>Return Number</label> 
<select	name="<%=ISSUE_RETURN_ID%>">
			<option value="0">Select</option>
			<%Iterator iterator = returnNoList.iterator();
			while (iterator.hasNext()) {
				StoreInternalReturnM mObj = (StoreInternalReturnM) iterator
						.next();%>
			<option value=<%=mObj.getId()%>><%=mObj.getReturnNo()%></option>

			<%}%>
		</select> 
<input type="image" class="button" value=""onClick="submitForm('search','stores?method=searchReturnToDispensary&pageNo=<%=pageNo - 1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
</form>
</div>
-->
</div>
<div class="Clear"></div>
<form name="returnSearch" method="post">
<!--  code to make the search panel -->
<input name="<%=ISSUE_RETURN_ID%>" value="<%=returnId%>" type="hidden" />
<%
	String returnNo = "";

	if (map.get("finalReturnNo") != null) {
		returnNo = (String) map.get("finalReturnNo");
	} else if (map.get("returnNo") != null) {
		returnNo = (String) map.get("returnNo");
	}
	//List<StoreFyDocumentNo> issueReturnNoList=(List<StoreFyDocumentNo>)map.get("issueReturnNoList");
	//StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)issueReturnNoList.get(0);
	//returnNo = (""+storeFyDocumentNo.getIssueDeptReturnNo());
	//returnNo = returnNo + 1;
%> 
<%
 	if (searchReturnMList.size() > 0) {
 		for (StoreInternalReturnM mObj : searchReturnMList) {
 %>

<h4>Deparmtment Return</h4>
<div class="Clear"></div>
<div class="Block">
<label>Return No.</label>
<label class="value"><%=mObj.getReturnNo()%></label>
<input type="hidden" name="<%=RETURN_NO%>" id="returnNo"	value="<%=mObj.getReturnNo()%>" readonly="readonly" validate="Return No ,String,yes" tabindex=1 />
<label>Return Date</label>
<%
	String ret_date = mObj.getReturnDate().toString();
			String returnDate = ret_date.substring(8) + "/"
					+ ret_date.substring(5, 7) + "/"
					+ ret_date.substring(0, 4);
%>
<input type="text" name="<%=RETURN_DATE%>" id="returnDate"	value="<%=returnDate%>" class="calDate"	validate="Return Date,dateOfAdmission,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.returnSearch.<%=RETURN_DATE%>,event)" />
<%-- 
<label><span>*</span> Reference No.</label>
<input type="text"  id="referenceNo"	name="<%=REFERENCE_NO %>" value="<%=mObj.getReferenceNo() %>" validate="Reference No ,String,yes" tabindex=1 />

<label>From Department</label>
<%
		
		Iterator itrDept=deptList.iterator();
	    while(itrDept.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDept.next();
	    	String deptName=masDepartment.getDepartmentName();
	    	int idFromList=masDepartment.getId();
	    	if(idFromList == departmentIdForReturnFromDispensary){
 	%>
<label class="value"><%=masDepartment.getDepartmentName() %></label>
<input	type="hidden" name="<%=FROM_WARD %>" id="fromWard"	value="<%=masDepartment.getId() %>">
<%
	    	}
	  }	
	%>
	--%>
<label> To Department<span>*</span></label>
<select name="<%=TO_WARD%>" id="toWard" validate="To Department ,String,yes">
	<option value="0">Select</option>
	<%
		Iterator itrDeptTo = deptList.iterator();
				while (itrDeptTo.hasNext()) {
					MasDepartment masDepartment = (MasDepartment) itrDeptTo
							.next();
					String deptName = masDepartment.getDepartmentName();
					int idFromList = masDepartment.getId();
					if (idFromList == mObj.getToDepartment().getId()) {
	%>
	<option value=<%=masDepartment.getId()%> selected><%=masDepartment.getDepartmentName()%></option>
	<%
		} else {
	%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<%
		}
	%>
	<%
		}
	%>
</select> 

<div class="clear"></div>
<label> Returned By<span>*</span></label>
<select name="<%=RETURN_BY_ID%>" id="returnBy"	validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
					if (masEmployee.getId() == mObj.getReturnBy().getId()) {
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName() + " "
									+ masEmployee.getLastName()%></option>
	<%
		} else {
	%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName() + " "
									+ masEmployee.getLastName()%></option>
	<%
		}
				}
	%>
</select>

<label><span>*</span> Received By</label>
<select name="<%=RECEIVED_BY_ID%>" id="receiveBy" 	validate="Received By ,String,yes">
	<option value="0">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
					if (masEmployee.getId() == mObj.getReceivedBy().getId()) {
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName() + " "
									+ masEmployee.getLastName()%></option>
	<%
		} else {
	%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName() + " "
									+ masEmployee.getLastName()%></option>
	<%
		}
				}
	%>
</select> 

<label>Reason</label>
<%
	if (mObj.getReason() != null) {
%> <textarea name="<%=REASON%>" id="reason"	validate="Reason ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" >	</textarea>
	<script>document.returnSearch.<%=REASON%>.innerHTML = "<%=mObj.getReason()%>"</script>
<%
	} else {
%>
<textarea value="" name="<%=REASON%>" id="reason"	validate="Reason ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" >	</textarea>
<script>document.returnSearch.<%=REASON%>.innerHTML = "<%=mObj.getReason()%>"</script>
<%
	}
%>
<%-- 
<label>Remarks</label>
<%
	if(mObj.getRemarks() != null){
	%>
<textarea name="<%=REMARKS %>" id="remarks"	validate="Remarks ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250">	</textarea>
<script>document.returnSearch.<%=REMARKS %>.innerHTML = "<%=mObj.getRemarks()%>"</script>
<%}else{ %>
<textarea value="" name="<%=REMARKS %>" id="remarks"	validate="Remarks ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" >	</textarea>
<script>document.returnSearch.<%=REMARKS %>.innerHTML = "<%=mObj.getRemarks()%>"</script>
<%} %> 

--%>

<%
	}
	}
%> 

<input type="hidden" id="returnNo" value="<%=returnNo%>"	readonly />
<input type="hidden" id="storeFyDocumentNoId"	value="<%=storeFyDocumentNoId%>" />

</div>

<div class="Clear"></div>
<!--  
<input type="button" class="button" value="Next" onclick="submitForm('returnSearch','stores?method=searchReturnToDispensary&pageNo=<%=pageNo%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>&storeFyDocumentNoId=<%=storeFyDocumentNoId%>');"	align="right" />
-->
<!-- <input type="button" class="button" value="Delete"  onclick="openPopupForDelete(<%=brandId%>,'<%=returnNo%>');" align="right" /> -->
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->

<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
<!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID%>" value="" id="hdb" /> -->
<input type="hidden" value="<%=deptId%>" name="deptId" id="deptId" />

<div class="Clear"></div>
<h4>Details</h4>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table  colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl No.</th>
			<th width="13%">Mat Code.</th>
			<th width="10%">Nomenclature</th>
			<th width="10%">A/U</th>
			<th width="10%">Batch No.</th>
			<th width="10%">DOE</th>
			<th width="16%">Qty Returned</th>

		</tr>
	</thead>
	<tbody>
		<%
			int detailCounter = 8;
			int temp = 0;
			int inc = 1;
			if (pageNo != 1) {
				temp = detailCounter * (pageNo - 1);
			}
			if (searchReturnTList.size() > 0 && searchReturnTList.size() >= 8) {
				for (StoreInternalReturnT tObj : searchReturnTList) {
		%>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp + inc%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="13%">
			<input type="text" size="12" value="<%=tObj.getItem().getPvmsNo()%>" name="pvmsNo<%=inc%>"	readonly="readonly" id="pvmsNo<%=inc%>" />
			</td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc%>"	value="" />
			<input type="hidden" name="date" id="date" value="<%=date%>" />
			<input type="hidden" name="time" id="time" value="<%=time%>" />

			<td width="10%">
			<input type="text"	value="<%=tObj.getItem().getNomenclature()%>"	id="nomenclature<%=inc%>" size="40"	name="<%=NOMENCLATURE%>" readonly />
			</td>
			<td width="10%">
			<input type="text" value="<%=tObj.getItem().getItemConversion().getItemUnitName()%>"
				id="au<%=inc%>" size="18" name="<%=AU%>"
				readonly />
			</td>
			<td width="10%">
			<input type="text" value="<%=tObj.getBatchNo()%>"
				id="batch<%=inc%>" size="15" name="<%=EXPIRY_DATE%>"
				readonly />
			</td>
			<td width="10%">
			<input type="text" value="<%=tObj.getExpiryDate()%>"
				id="expiry<%=inc%>" size="18" name="<%=BATCH%>"
				readonly />
			</td>
			<%--   <td width="13%">
			<input type="text"	value="<%=tObj.getBrand().getBrandName() %>" name="<%= ITEM_ID%>" id="brandName<%=inc%>" size="40" readonly />
			</td>--%>
			<td width="16%">
			<input type="text"	value="<%=tObj.getReturnQty()%>" size="12"	name="<%=QTY_ISSUED%>" id="qtyIssued<%=inc%>"  readonly />
			</td>
		</tr>
		<%
			inc++;
				}
			} else if (searchReturnTList.size() > 0
					&& searchReturnTList.size() < 8) {
				for (StoreInternalReturnT tObj : searchReturnTList) {
		%>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp + inc%>"	 name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="13%"><input type="text" size="12" value="<%=tObj.getItem().getPvmsNo()%>" name="pvmsNo<%=inc%>"	readonly="readonly" id="pvmsNo<%=inc%>" /></td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc%>"	value="" />
			<input type="hidden" name="date" id="date" value="<%=date%>" />
			<input type="hidden" name="time" id="time" value="<%=time%>" />
			<td width="10%"><input type="text"	value="<%=tObj.getItem().getNomenclature()%>"	id="nomenclature<%=inc%>" size="40" name="<%=NOMENCLATURE%>" readonly /></td>
			<td width="10%">
			<input type="text" value="<%=tObj.getItem().getItemConversion().getItemUnitName()%>"
				id="au<%=inc%>" size="18" name="<%=AU%>"
				readonly />
			</td>
			<td width="10%">
			<input type="text" value="<%=tObj.getBatchNo()%>"
				id="batch<%=inc%>" size="15" name="<%=BATCH%>"
				readonly />
			</td>
			<td width="10%">
			<input type="text" value="<%=tObj.getExpiryDate()%>"
				id="expiry<%=inc%>" size="18" name="<%=BATCH%>"
				readonly />
			</td>
			<%-- <td width="13%"><input type="text"	value="<%=tObj.getBrand().getBrandName() %>" name="<%= ITEM_ID%>" id="brandName<%=inc%>" class="bigcaption" readonly /></td>
			--%>
			<td width="16%"><input type="text"	size="12" value="<%=tObj.getReturnQty()%>" class="medcaption" name="<%=QTY_ISSUED%>" id="qtyIssued<%=inc%>"  readonly /></td>
			</tr>
		<%
			inc++;
				}
			} else {
		%>
		<tr><td colspan="5">No records to display</td></tr>
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
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="hidden" name="rows" id="rr" value="1" />










