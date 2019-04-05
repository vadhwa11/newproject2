
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSampleTestingEntry"%>
<%@page import="jkt.hms.masters.business.StoreSampleTestingDetail"%>
<%@page import="jkt.hms.masters.business.StoreFollowUpForSample"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugT"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
	
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%

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
	var itemsArray1=new Array();
 	var numLinesAdded = 1;
 	var tt;
 

  
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
   function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printDefectiveDrugJsp";
  obj.submit();
}
			
	
</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> purchaseMap = new HashMap<String, Object>();
	String noDetailRecords="no";
	String previousPage = "no";
	int pageNo = 1;
	int entryId = 0;
	
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	
	List<StoreSampleTestingDetail> gridDefectiveDrugTList = new ArrayList<StoreSampleTestingDetail>();
	List<StoreSampleTestingEntry> defectiveList= new ArrayList<StoreSampleTestingEntry>();
	List<StoreCopyAddressList> copyList = new ArrayList<StoreCopyAddressList>();
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	List<StoreSampleTestingEntry> searchDrugList= new ArrayList<StoreSampleTestingEntry>();
	List<MasEmployee> enterdByList = new ArrayList<MasEmployee>();
	List<MasEmployee> authorisedList = new ArrayList<MasEmployee>();
	List<StoreFollowUpForSample> storeFollowupDetailsList = new ArrayList<StoreFollowUpForSample>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	
	if(map.get("entryId")!=null){
		entryId = Integer.parseInt(""+map.get("entryId"));
	}
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if (map.get("gridDefectiveDrugTList") != null) {
		gridDefectiveDrugTList = (List<StoreSampleTestingDetail>)map.get("gridDefectiveDrugTList");
	}
	if (map.get("authorisedList") != null) {
		authorisedList = (List<MasEmployee>)map.get("authorisedList");
	}
	if (map.get("enterdByList") != null) {
		enterdByList = (List<MasEmployee>)map.get("enterdByList");
	}

	if (map.get("defectiveList") != null) {
		defectiveList = (List<StoreSampleTestingEntry>)map.get("defectiveList");
	}
	
	if (map.get("storeFollowupDetailsList") != null) {
		storeFollowupDetailsList = (List<StoreFollowUpForSample>)map.get("storeFollowupDetailsList");
	}


	if(map.get("copyList")!=null)
		copyList = (List) map.get("copyList");
	if (map.get("purchaseMap") != null) {
		purchaseMap = (Map<String, Object>)map.get("purchaseMap");
	}
	
	if(map.get("manufacturerList")!=null)
		manufacturerList = (List) map.get("manufacturerList");
	
	if(purchaseMap.get("itemList")!=null){
		itemList = (List<MasStoreItem>) purchaseMap.get("itemList");
	}
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	
	if(map.get("searchDrugList")!=null)
		searchDrugList = (List) map.get("searchDrugList");
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String time="";
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
%>


<div id="searchBlock" style="display:none;">
<form name="createGrn" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>From Date  </label> 
<input type="text" name="<%= FROM_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
<label>To Date  </label> 
<input type="text" name="<%= TO_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />

<div class="clear"></div>
<label >Defect No. </label> 
<select	name="<%=ENTRY_NO%>">
<option value="0">Select</option>
			<%
					for (StoreSampleTestingEntry storeDefectiveDrugM :defectiveList ) {
				%>

			<option value=<%=storeDefectiveDrugM.getDefectNo()%>><%=storeDefectiveDrugM.getDefectNo()%></option>

			<%}%>
</select> 

<input type="button" name="sss" class="button" value="SEARCH" onClick="submitForm('createGrn','stores?method=searchDefectiveDrug');" />
</form>
</div>
</form>
</div>



<div class="titleBg">
<h6>SAMPLE TESTING ENTRY</h6>
</div>
<form name="modifyDefecetiveDrug" method="post">
<input
	type="hidden" name="<%=ENTRY_ID %>" value="<%=entryId %>" id="hdb" />

<div id="testDiv">
<%if(previousPage.equals("no")){ %> 
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <%
	List<StoreSampleTestingEntry> gridDefectiveDrugMList = new ArrayList<StoreSampleTestingEntry>();
StoreSampleTestingEntry defectiveDrugMObj = null;
	if(map.get("gridDefectiveDrugMList") != null){
		gridDefectiveDrugMList = (List<StoreSampleTestingEntry>)map.get("gridDefectiveDrugMList");
	}
	if(gridDefectiveDrugMList.size() > 0){
		defectiveDrugMObj = (StoreSampleTestingEntry)gridDefectiveDrugMList.get(0);
		entryId = defectiveDrugMObj.getId();
	}	
	%> 
	
<input type="hidden" name="totalRecords" value="<%=gridDefectiveDrugTList.size() %>" /> 
<div class="Block">
<label>Defect No.<span>*</span></label> <% if(defectiveDrugMObj != null){ %>
<label class="value"><%=defectiveDrugMObj.getDefectNo() %></label>
<input type="hidden" name="<%= ENTRY_NO %>" value="<%=defectiveDrugMObj.getDefectNo()%>" readonly="readonly" /> 
<%}else{ %>
<input type="text"  name="<%= ENTRY_NO %>" value=""	validate="Entry Number ,String,yes" tabindex=1 /><%} %>
<label>Defect Date<span>*</span></label> 
<% if(defectiveDrugMObj.getDefectiveDate() != null){ %>
<input type="text"  name="<%= ENTRY_DATE%>" value="<%=HMSUtil.convertDateToStringWithoutTime(defectiveDrugMObj.getDefectiveDate()) %>" id="signalNo"/>

<%}else{ %>
<input type="text"  name="<%= ENTRY_DATE%>"  id="signalNo"/>
<%} %>

<label>Type of Defect</label>
<% if(defectiveDrugMObj.getDefectType() != null){ %>
<input type="text"  name="defectType" value="<%=defectiveDrugMObj.getDefectType()%>" id="signalNo"/>
<%}else{ %>
<input type="text"  name="defectType"  id="signalNo"/>
<%} %>

<label>Patient Details</label>
<% if(defectiveDrugMObj.getPatientDetails() != null){%>
<textarea value="" name="PatientDetails" validate="Patient Details ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
<%=defectiveDrugMObj.getPatientDetails()%>
</textarea> 
<%}else{ %>
<textarea value="" name="PatientDetails" validate="Patient Details ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
</textarea>
<%} %>

<label>Patient Reaction(if any)</label>
<%if(defectiveDrugMObj.getPatientReaction() != null){ %>
<textarea value="" name="PatientReaction" validate="Patient Reaction ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
<%=defectiveDrugMObj.getPatientReaction()%>
</textarea> 
<%}else{ %>
<textarea value="" name="PatientReaction" validate="Patient Reaction ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
</textarea>

<%} %>

<label>Sample Sent on</label>
<%if(defectiveDrugMObj.getSampleSentOn()!=null){ %>
<input type="text"  name="<%= DOC_DATE%>"	value="<%=HMSUtil.convertDateToStringWithoutTime(defectiveDrugMObj.getSampleSentOn()) %>" readonly="readonly" />

<%}else{ %>
<input type="text"  name="<%= DOC_DATE%>"	value="<%=currentDate%>" readonly="readonly" />
<%} %>
<%
	} %>
	
	
	 <input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS %>" id="noOfRows" /> 
	
	
	<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
</div>
</div>
<h4>Sample Testing  Detail</h4>

<div class="cmntable">
<table width="100%" colspan="7" id="purchaseDetails" 
	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="8%">PVMS/NIV No.</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand</th>
			<th width="9%">Manufacturer</th>
			<th width="9%">Batch No.</th>
		    <th width="9%">DOM</th>
			<th width="9%">DOE</th>
			<th width="9%">Qty</th>
			<th width="9%">Source of Supply</th>
			
			
			<!-- -For Smc
			<td width="15%"><label>Authy</label></td>
			
			<td width="9%"><label>Remarks</label></td> -->
		</tr>

	</thead>
	<tbody>
		<%
  		int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	String authyDec = "authyDec";
    	String disposal="disposal";
    	String disposalTemp ="disposalTemp";
    	String remarks="remarks";
    	String remarksTemp="remarksTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String expiryDateTemp ="expiryDateTemp";
    	String manufacturerIdTemp ="manufacturerIdTemp";
    	
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String authyDecTemp = "authyDecTemp";
    	String incVar="incVar";
    	
    	String freeQty="freeQty";
    	String amount="amount";
    	String manufacturerId="manufacturerId";
    	String brandId="brandId";
    	String freeItem="freeItem";
    	String expiryDate="expiryDate";
    	String batchId ="batchId";
    	String disposalDate="disposalDate";
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
	   	String quantityInVar2="quantityInVar";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2 = "amountVar";
    	String discountVar2="discountVar";
    	String authyDecTemp2 = "authyDecTemp";
    	String expiryDateTemp2="expiryDateTemp";
    	String manufacturerIdTemp2="manufacturerIdTemp";
    	
    	String freeQty2="freeQty";
    	String amount2="amount";
    	String manufacturerId2="manufacturerId";
    	String brandId2="brandId";
    	String freeItem2="freeItem";
    	String expiryDate2="expiryDate";
    	String authyDec2= "authyDec";
    	
    	
    	String quantityInVarTemp2="quantityInVarTemp";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String amountVarTemp2 = "amountVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";
    	
    	String disposal2="disposal";
    	String disposalTemp2 ="disposalTemp";
    	String remarks2="remarks";
    	String remarksTemp2="remarksTemp";
    	String quanRec2 ="quanRec";
    	String quanRecTemp2 ="quanRecTemp";
    	String batchId2 ="batchId";
    	
    	if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*10)+1;
	    	   int incTemp2=inc+10;
	    	   
	    	   for(StoreSampleTestingDetail storeDefectiveDrugT : gridDefectiveDrugTList){
	    		if(inc<incTemp2){
   %>
		<%
    	
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		amountVar=amountVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		disposalDate=disposalDate+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		amount=amount2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		brandId=brandId2+(""+inc);
     		expiryDate = expiryDate2+(""+inc);
     		authyDec = authyDec2+(""+inc);
     		
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		amountVarTemp=amountVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		authyDecTemp = authyDecTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     	 	disposal=disposal2+(""+inc);
        	disposalTemp =disposalTemp2+(""+inc);
       		remarks=remarks2+(""+inc);
        	remarksTemp=remarksTemp2+(""+inc);
        	quanRec=quanRec2+(""+inc);
        	quanRecTemp=quanRecTemp2+(""+inc);
        	expiryDateTemp= expiryDateTemp2+(""+inc);
        	manufacturerIdTemp =manufacturerIdTemp2+(""+inc);
        	batchId=batchId2+(""+inc);
    %>
		<tr>

			<td width="5%">
			<input type="hidden" size="2"	value="<%=storeDefectiveDrugT.getBatchNo()%>" 	name="<%=SR_NO%>" readonly="readonly" />
			<input type="text" size="2"	value="<%=storeDefectiveDrugT.getSrNo()%>" 	name="<%=SR_NO%>" readonly="readonly" /></td>
			
			<td width="10%">
			
			<%if(storeDefectiveDrugT.getItem().getPvmsNo()!=null){ %> 
			
			<input type="text" size="10" value="<%=storeDefectiveDrugT.getItem().getPvmsNo() %>"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> 
			
			<%}else{ %> 
			<input type="text" size="10" value=" "  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%} %> 
			<input type="hidden" name="<%=DETAIL_ID %>" value="<%=storeDefectiveDrugT.getId() %>" id="hdb" />
			
			</td>

			<td>
			
			<input type="text"	size="30" value="<%=storeDefectiveDrugT.getItem().getNomenclature() %>" id="<%=nameItem%>" name="<%=nameItem%>" />
			
		</td>
			
			<td>
			<input type="text" size="5" value="<%=storeDefectiveDrugT.getItem().getItemConversion().getItemUnitName() %>"
				 readonly="readonly" name="<%=AV%>" id="<%=idAu%>" />
			
			</td>
			
				<td>

			<input type="text" value="" id="bg<%=inc%>" size="2" value="<%=storeDefectiveDrugT.getItem().getBrandedGeneric() %>" tabindex="1" name="bg"/>
			
			
				</td>
				
			<td>
			<%if(storeDefectiveDrugT.getBrand()!=null){ %>
			<select  onchange="getManufacturerNameByAjax(this.value,<%=inc%>);"
				tabindex="1">
				<option value="0">Select</option>
				<option value="<%=storeDefectiveDrugT.getBrand().getId()%>" selected="selected"><%=storeDefectiveDrugT.getBrand().getBrandName() %></option>
						</select>
				<%}else{ %>	
				<select name="<%=BRAND_ID%>" id="<%=brandId%>" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);"
				tabindex="1">
				<option value="0">Select</option>
				</select>
				<%} %>	
		</td>
			
			
			<td>
			<%if(storeDefectiveDrugT.getManufacturedBy()!=null){ %>
			<input id="<%=manufacturerId %>" value="<%=storeDefectiveDrugT.getManufacturedBy().getManufacturerName()%>" tabindex="1" name="<%=MANUFACTURER_NAME %>"/>
			 <input	type="hidden" name="<%=MANUFACTURER_ID %>" value="<%=storeDefectiveDrugT.getManufacturedBy().getId() %>" id="<%=manufacturerIdTemp %>" tabindex="1" />
			<%}else{ %>
			<input id="<%=manufacturerId %>" value="" tabindex="1" name="<%=MANUFACTURER_NAME %>"/>
			 <input	type="hidden" name="<%=MANUFACTURER_ID %>" value="" id="<%=manufacturerIdTemp %>" tabindex="1" />
			
			<%} %>
			
			</td>	

			
				<td>
				<%if(storeDefectiveDrugT.getBatchNo()!=null){ %>	
			    
			    <select name="<%=BATCH_ID %>" tabindex="2" id="<%=batchId%>" class="small" 	onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="0">Select</option>
				<option value="<%=storeDefectiveDrugT.getBatchNo().getId()%>" selected="selected"><%=storeDefectiveDrugT.getBatchNo().getBatchNo()%></option>
				</select>
			
			    </td>
			    

			<td>
			<%if(storeDefectiveDrugT.getManufactureringDate()!=null){ %>
			<input type="text" size="8" value="<%=HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugT.getManufactureringDate()) %>" id="manufacturingDate<%=inc%>" name="<%=MANUFACTURING_DATE%>"  tabindex="1" />
			<input type="hidden" value="abc" id="manufacturingDateTemp<%=inc%>"  tabindex="1" />
			<%}else{ %>
			<input type="text" value="" id="manufacturingDate<%=inc%>"   tabindex="1" />
			<input type="hidden" value="abc" id="manufacturingDateTemp<%=inc%>" name="<%=MANUFACTURING_DATE%>"  tabindex="1" />
			<%} %>
			
			</td>
			
			<td>
			<%if(storeDefectiveDrugT.getExpiryDate() != null){%>
			 <input type="text" size="8"	value="<%=HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugT.getExpiryDate()) %>"
				name="<%=EXPIRY_DATE %>" id="<%=expiryDate %>" /> 
				<%}else{ %> 
				<input	type="text" value="0" name="<%=EXPIRY_DATE %>" id="<%=expiryDate%>" /> 
				<%} %>
			</td>

			<td width="10%">
			<%if(storeDefectiveDrugT.getDefectQty()!=null){ %>
			<input type="text" class="auto" size="5"
				value="<%= storeDefectiveDrugT.getDefectQty()%>"  onblur="fillQuanForDefectiveDrug(<%=inc%>)" 
				name="" id="<%=quanRecTemp%>" /> <input type="hidden"
				value="<%=storeDefectiveDrugT.getDefectQty()%>" 
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" />
				<%}else{ %>
				<input type="text" class="auto" size="5"
				value=""  onblur="fillQuanForDefectiveDrug(<%=inc%>)" 
				name="" id="<%=quanRecTemp%>" /> <input type="hidden"
				value="<%=storeDefectiveDrugT.getDefectQty()%>" 
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" />
			
			<%} %>	
				
				</td>
			
				<td>	
				<%if(storeDefectiveDrugT.getSourceOfSupply()!=null){ %>
				<input type="text" name="<%=SOURCE_OF_SUPPLY%>" size="7" id="<%=batchId%>"  value="<%=storeDefectiveDrugT.getSourceOfSupply()%>" tabindex="1" >
		 	 	<%}else{ %>
		 	 	<input type="text" name="<%=SOURCE_OF_SUPPLY%>" size="7" id="<%=batchId%>"  value=""  tabindex="1" >
		 	 	<%} %>
		 	 	</td>
				

		</tr>
		<% inc++;
     	 }
     	 }}
	    	   %> <script>
	    	   
	    	 document.modifyDefecetiveDrug.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script> <%
	    	detailCounter=10; 
	       	temp=0;
	    	idItem="idItem";
	    	codeItem="codeItem";
	    	nameItem="nameItem";
	    	idAu="idAu";
	    	quantityInVar="quantityInVar";
	    	taxVar="taxVar";
	    	unitRateVar="unitRateVar";
	    	amountVar="amountVar";
	    	discountVar="discountVar";
	    	expiryDateTemp="expiryDateTemp";
	    	
	    	quantityInVarTemp="quantityInVarTemp";
	    	taxVarTemp="taxVarTemp";
	    	unitRateVarTemp="unitRateVarTemp";
	    	amountVarTemp = "amountVarTemp";
	    	discountVarTemp="discountVarTemp";
	    	incVar="incVar";
	    	
	    	freeQty="freeQty";
	    	amount="amount";
	    	manufacturerId="manufacturerId";
	    	brandId="brandId";
	    	freeItem="freeItem";
	    	batchId="batchId";
	    	
	    	idItem2="idItem";
	    	codeItem2="codeItem";
	    	nameItem2="nameItem";
	    	idAu2="idAu";
		   	quantityInVar2="quantityInVar";
	    	taxVar2="taxVar";
	    	unitRateVar2="unitRateVar";
	    	amountVar2 = "amountVar";
	    	discountVar2="discountVar";
	    	
	    	freeQty2="freeQty";
	    	amount2="amount";
	    	manufacturerId2="manufacturerId";
	    	brandId2="brandId";
	    	freeItem2="freeItem";
	    	
	    	
	    	quantityInVarTemp2="quantityInVarTemp";
	    	taxVarTemp2="taxVarTemp";
	    	unitRateVarTemp2="unitRateVarTemp";
	    	amountVarTemp2 = "amountVarTemp";
	    	discountVarTemp2="discountVarTemp";
	    	incVar2="incVar2";
	    	expiryDateTemp2="expiryDateTemp" ;
	    	batchId2="batchId";
	    		  if(inc<incTemp2){
	    			  for(;inc<incTemp2;inc++){
	    				  idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		
	    		     		quantityInVar=quantityInVar2+(""+inc);
	    		     		taxVar=taxVar2+(""+inc);
	    		     		unitRateVar=unitRateVar2+(""+inc);
	    		     		amountVar=amountVar2+(""+inc);
	    		     		discountVar=discountVar2+(""+inc);

	    		     		freeQty=freeQty2+(""+inc);     		
	    		     		freeItem=freeItem2+(""+inc);
	    		     		amount=amount2+(""+inc);
	    		     		manufacturerId=manufacturerId2+(""+inc);
	    		     		brandId=brandId2+(""+inc);
	    		     		
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		amountVarTemp=amountVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		expiryDateTemp =expiryDateTemp2+(""+inc);
	    		     		batchId=batchId2+(""+inc);
	    			  %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="10" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> 
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			</td>
			<td>
			<input type="text" size="30" value="" id="<%=nameItem%>"  tabindex="1"
			onblur="if(fillSrNo('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script>
		</td>
			
		

			

			<td>
			<input type="text" size="5" value="" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" />
			
			</td>
			
			
			<td>

			<input type="text" value="" id="bg<%=inc%>" size="2"  tabindex="1" name="bg"/>
			
			</td>
			
			<td>
			<select name="<%=BRAND_ID%>" id="<%=brandId%>" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);"
				tabindex="1"><option value="0">Select</option>
						</select></td>
			
			
			<td><input id="<%=manufacturerId %>" value="" tabindex="1" name="<%=MANUFACTURER_NAME %>"/>
			 <input	type="hidden" name="<%=MANUFACTURER_ID %>" value="0" id="<%=manufacturerIdTemp %>" tabindex="1" />
			</td>	
			
				<td>
			    <select name="<%=BATCH_ID%>" id="<%=batchId%>" class="small"	onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="0">Select</option>
			</select></td>
			
			
			<td>
			
			<input type="text" size="8" value="" id="manufacturingDate<%=inc%>"   tabindex="1" />
			<input type="hidden" value="abc" id="manufacturingDateTemp<%=inc%>" name="<%=MANUFACTURING_DATE%>"  tabindex="1" />
			</td>
				
				
			<td>
			
				<input type="text" size="8"
				 id="<%=expiryDate%>"   tabindex="1" />
				
				<input type="hidden"
				 id="expiryDateTemp<%=inc%>" value="abc"  name="<%=EXPIRY_DATE%>"
				 />
				
				</td>

			<td><input type="text" value="" 
				name="" id="<%=quanRecTemp%>" size="5"
				onblur="fillQuanForDefectiveDrug(<%=inc%>)" tabindex="1" /> <input
				type="hidden" value="0" 
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" tabindex="1" />
			</td>
				
			<td>	
		 		<input type="text" name="<%=SOURCE_OF_SUPPLY%> id="<%=batchId%>"  value=""  tabindex="1" size="7" >
				</td>
				
				
				<!--
				<td width="10%"><input type="text" value="" 
				name="" id="<%=authyDecTemp%>" tabindex="1" maxlength="15"
				onblur="fillAuthyForDefectiveDrug(<%=inc%>)" /> <input type="hidden"
				value="0"  name="<%=AUTHY_UNDER_DECLARED %>"
				tabindex="1" id="<%=authyDec%>" /></td>


			
				
				
				
			<td width="10%"><input type="text" value="" 
				name="" id="<%=remarksTemp%>" tabindex="1" maxlength="15"
				onblur="fillValuesInDefectiveDrug(<%=inc%>);" /> <input
				type="hidden" value="emptyString2" 
				name="<%=REMARKS %>" tabindex="1" id="<%=remarks%>" /></td> -->
		</tr>

		<% }
	    		  }
     	    %> <%}//this is if(previousPage.equals("no")) end
       else{}%>
		
	</tbody>
</table>
</div>


<%
	List<StoreSampleTestingEntry> gridDefectiveDrugMList = new ArrayList<StoreSampleTestingEntry>();
	if (map.get("gridDefectiveDrugMList") != null) {
		gridDefectiveDrugMList = (List<StoreSampleTestingEntry>)map.get("gridDefectiveDrugMList");
	}
	StoreSampleTestingEntry defectiveDrugMObj = null;
	if(gridDefectiveDrugMList.size() > 0){
		defectiveDrugMObj = (StoreSampleTestingEntry)gridDefectiveDrugMList.get(0);
		entryId = defectiveDrugMObj.getId();
	}
		%>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input
					type="hidden" name="Add" type="hidden" value="Add"
					class="button">
				<input
					type="button" name="Modify" type="hidden" value="Update"
					class="button"
					onClick="submitForm('modifyDefecetiveDrug','stores?method=updateSampleTestingEntry');">
					
					<input type="button" name="sss" class="buttonBig" value="Follow Up Details" onclick="getFollowUpDetails();" />
					<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
				
<!--				<input-->
<!--					type="button" name="Delete" type=""hidden"" value="Delete"-->
<!--					class="toolbutton">-->
<!--				<input-->
<!--					type="button" name="print" type="submit" class="toolbutton"-->
<!--					value="Print" onClick="showReport('purchaseGrid');">-->
<div class="clear"></div>
<div id="followUpDetail" style="display:none;">
<div class="clear"></div>
<h4>Follow up Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="Clear"></div>
<div class="cmntable">
<table width="200px" colspan="7" id="grnFollow" 
	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th></th>
			<th width="5%" colspan="2">Follow up Date</th>
			<th width="8%">Reference No.</th>
			<th width="9%">Remarks</th>
			<th scope="col">Add</th>
			<th scope="col">Delete</th>
		</tr>

	</thead>
	<tbody>
	<%
	if(storeFollowupDetailsList.size()>0)
	{
	
	%>
		
		
		
		<%
		int rowVal=1;
		for(StoreFollowUpForSample storeFollowupDetails:storeFollowupDetailsList)
		{
		
		%>
	 <input type="hidden" name="gridSize" id="gridSize" value="<%=storeFollowupDetailsList.size()%>"/>
	<tr>
	
			<td>
			
			<input type="checkbox" name="storeFollowUpId" id="storeFollowUpId<%=rowVal%>" value="<%=storeFollowupDetails.getId()%>" checked="checked">
			
			</td>

			<td width="5%">
			
			<input type="text" size="20" value="<%=HMSUtil.convertDateToStringWithoutTime(storeFollowupDetails.getFollowUpDate())%>" name="followUpDate" id="followUpDate<%=rowVal%>"  tabindex="1"/>
			
			</td>
			<td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" OnClick="setdate('<%=currentDate%>',document.getElementById('followUpDate<%=rowVal%>'),event);" />
			</td>
			<td width="10%">
			
			<input type="text" size="50" name="referenceNo"  id="referenceNo<%=rowVal%>" value="<%=storeFollowupDetails.getReferenceNo()%>" tabindex="1"/> 
			
			</td>
			
			<td width="10%">
			
			<input type="text" value="<%=storeFollowupDetails.getRemarks()%>" size="50" id="followUpRemarks<%=rowVal%>"  tabindex="1" name="followUpRemarks" />
			
			
		</td>
		
			<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grnFollow');" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grnFollow');" tabindex="1" />
	
		   </td>
	
	</tr>
	<%
	rowVal=rowVal+1;;
		}
		} else{
			int rowVal=1;
		%>
		
		

		
		
		
	 <input type="hidden" name="gridSize" id="gridSize" value="1"/>
	<tr>
	
			<td>
			
			<input type="checkbox" name="storeFollowUpId" id="storeFollowUpId<%=rowVal%>" value="y">
			</td>
		

			<td width="5%">
			
			<input type="text" size="20" value="" name="followUpDate" id="followUpDate<%=rowVal%>"  tabindex="1"/>
			
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" OnClick="setdate('<%=currentDate%>',document.getElementById('followUpDate<%=rowVal%>'),event);" />
			</td>
			<td width="10%">
			
			<input type="text" size="50" name="referenceNo"  id="referenceNo<%=rowVal%>" value="" tabindex="1"/> 
			
			</td>
			
			<td width="10%">
			
			<input type="text" value="" size="50" id="followUpRemarks<%=rowVal%>"  tabindex="1" name="followUpRemarks" />
			
			
		</td>
		
			<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grnFollow');" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grnFollow');" tabindex="1" />
	
		   </td>
	
	</tr>
	
	<%} %>
		
	</tbody>
	</table>

</div>
</div>


<input
					type="button" name="Modify" type="hidden" value="SUBMIT"
					class="button"
					onClick="if(checkFollowUpDetails()){submitForm('modifyDefecetiveDrug','stores?method=submitFollowDetailsForSampleEntry');}">



</div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
 </div>  
	</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	 <input type="hidden" name="rows" id="rr" value="1" /> 
	</form>
<script type="text/javascript">
function addRow(idName) {
	
	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;
	  

	  var cellRight33 = row.insertCell(el);
	  var e33 = document.createElement('input');
	  e33.type = 'checkbox';
	  e33.name='storeFollowUpId';
	  e33.id='storeFollowUpId'+iteration;
	  e33.value="y"
	  e33.setAttribute('tabindex', 1); 
	  cellRight33.appendChild(e33);
	  
	  
	  var cellRight0 = row.insertCell(++el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '20';
	  e0.name='followUpDate';
	  e0.id='followUpDate'+iteration;
	  e0.setAttribute('tabindex', 1); 
	  cellRight0.appendChild(e0);

	  var cellRight99 = row.insertCell(++el);
	     var eImg = document.createElement('img');
	   	eImg.src = '/hms/jsp/images/cal.gif';
	   eImg.name = '' ;
	   eImg.id = '';
	   eImg.WIDTH = '16';
	   eImg.HEIGHT = '16';
	   //eImg.id = 'billDateId'+iteration;
	   eImg.onclick = function(event){
			  setdate('',document.getElementById('<%="followUpDate"%>'+iteration),event) };
	   cellRight99.appendChild(eImg);

	  

	  
	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='referenceNo';
	  e1.id = 'referenceNo'+iteration;
	  e1.size='50';
	  e1.setAttribute('tabindex', 1); 
	  cellRight1.appendChild(e1);


	 
	 
	
	  
	  var cellRight3 = row.insertCell(++el);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='followUpRemarks';
	  e3.id = 'followUpRemarks'+iteration;
	  e3.setAttribute('tabindex', 1); 
	  
	 e3.size='50';
	   cellRight3.appendChild(e3);


	  
	   
	
	  var cellRight21 = row.insertCell(++el);
	  var e21 = document.createElement('input');
	  e21.type = 'button';
	  e21.name='remarks'+iteration;
	  e21.className = 'buttonAdd';
	  e21.setAttribute('tabindex', 1); 
	  e21.onclick= function(){addRow('grnFollow')};
	  cellRight21.appendChild(e21);

	  var cellRight22 = row.insertCell(++el);
	  var e22 = document.createElement('input');
	  e22.type = 'button';
	  e22.name='remarks'+iteration;
	  e22.setAttribute('tabindex', 1); 
	  e22.className = 'buttonDel';
	  e22.onclick= function(){removeRow('grnFollow')};
	  cellRight22.appendChild(e22);
	  				 
}
function removeRow(idName)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;

    	for(var i=rowCount-1; i>0; i++) 
        {
        	var row = table.rows[i];
            if(i>1)
            {
            	table.deleteRow(i);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;
          

       }
       }catch(e)
       	{
           alert(e);
       }
      
}

</script>
<script language="javascript">
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function getFollowUpDetails()
{
	document.getElementById('followUpDetail').style.display = 'inline';
}
function checkForDefectiveDrugs(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	   
		ajaxFunctionForAutoCompleteInDefectiveDrugs('purchaseGrid','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}
function fillSrNo(rowVal){


	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
function getExpiryDateByAjax(batchId,rowVal){
	 

	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	   
		        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
		        var mId  = item.getElementsByTagName("mId")[0];
	        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
	        	document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue
	        	
	      	} 
	      }
	    }
	     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }
function getManufacturerNameByAjax(brandId,rowVal){
	 
	 
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
		        var mId  = item.getElementsByTagName("mId")[0];
	        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
	        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue
	        	
	      	} 
	      }
	    }
	     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }

function checkFollowUpDetails()
{
	var gridSize=document.getElementById('gridSize').value;
	var flag="false";
	for(var i=1;i<=gridSize;i++)
	{
		
		if (!document.getElementById('storeFollowUpId'+i).checked)
		{
				alert('Please select FollowUp Details ar Row-'+i);
				flag="false";
				return false;
		}
		else
		{
			flag="true";
		}
	}
	if(flag=="false")
	{
	return false;		
	}else{
		return true;
		}

}
 </script>