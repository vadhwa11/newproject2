<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%><script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
 -->
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);

</script>


<%
	 int pageNo=0;
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));

	}
	int deptId=0;
	if (map.get("deptId") != null) {
		deptId = Integer.parseInt(""+map.get("deptId"));

	}
	Map mapItem=new HashMap();
	if(map.get("mapItem")!=null){
		mapItem=(Map)map.get("mapItem");
	}
	
	//System.out.println("deptId "+deptId);
	//	int deptId = (Integer)map.get("deptId");
	//	String date=(String)map.get("date");
	//	String time=(String)map.get("time");
	//	String fromDateToDate=(String)map.get("fromDateToDate");
	List listOfItemsInStock=new ArrayList();
	List listOfItemsStockInStock=new ArrayList();
	List itemList= new ArrayList();
	List issueNoList= new ArrayList();
	List empList= new ArrayList();
	List listOfItemsStock=new ArrayList();
	String date="";
	List<PatientPrescriptionDetails>  presList = new ArrayList<PatientPrescriptionDetails>();
	String time="";
	int hinId=0;
	String buttonFlagForNext="";
	String hinNo="";
	String prescription="";
	int consultantId=0;
	int consultantFromIssue = 0;
	String prescriptionNo = "";
	String serviceNo="";
	List<Object[]> stockInHandList = new ArrayList<Object[]>();
	List<StoreOpPatientIssueM> issueList = new ArrayList<StoreOpPatientIssueM>();
	try {

			if(map.get("listOfItemsInStock") != null){
				listOfItemsInStock=(List)map.get("listOfItemsInStock");
			}
			if(map.get("listOfItemsStock") != null){
			
				listOfItemsStock=(List)map.get("listOfItemsStock");
				
			}
			if(map.get("listOfItemsStockInStock")!=null){
				listOfItemsStockInStock=(List)map.get("listOfItemsStockInStock");
			}
			if (map.get("itemList") != null) {
				itemList = (List)map.get("itemList");
			}
			if (map.get("issueNoList") != null) {
				issueNoList = (List)map.get("issueNoList");
			}
			if (map.get("date") != null) {
				date = (String)map.get("date");
			}
			if (map.get("time") != null) {
				time = (String)map.get("time");
			}
			if (map.get("hinId") != null) {
				hinId = (Integer)map.get("hinId");
			}
			if (map.get("hinNo") != null) {
				hinNo = (String)map.get("hinNo");
			}
			if(map.get("serviceNo")!=null)
			{
				serviceNo=(String)map.get("serviceNo");
			}
			if (map.get("prescription") != null) {
				prescription = (String)map.get("prescription");

			}
			if (map.get("consultantId") != null) {
				consultantId = (Integer)map.get("consultantId");

			}
			if(map.get("empList") != null)
			{
				empList=(List)map.get("empList");

			}
			if (map.get("buttonFlag") != null) {
				buttonFlagForNext = (String)map.get("buttonFlag");
			}
			else{
				buttonFlagForNext="empty";
			}
			if(map.get("presList") != null){
				presList = (List<PatientPrescriptionDetails>)map.get("presList");
			}
			if(map.get("stockInHandList") != null){
				stockInHandList = (List<Object[]>)map.get("stockInHandList");
			}
			if(map.get("issueList") != null){
				issueList = (List<StoreOpPatientIssueM>)map.get("issueList");
			}
			
			StoreOpPatientIssueM opPatientIssueM = new StoreOpPatientIssueM();

			if(issueList.size() > 0){
				opPatientIssueM = issueList.get(0);
				prescriptionNo = opPatientIssueM.getPrescriptionNo();
				//consultantFromIssue = opPatientIssueM.getEmp().getId();
			}
	} catch (Exception exp) {
		exp.printStackTrace();
	}



	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null)
	{
		frequencyList=(List)map.get("frequencyList");
	}
	%>
	



 
<div id="testDiv">
<input type="hidden"	name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		 List opdIssueNo=(List)map.get("opdIssueNo");
		 StoreFyDocumentNo storeFyDocumentNo= new StoreFyDocumentNo();
		 int storeFyDocumentNoId =0 ;
		 if(opdIssueNo.size() > 0){
			 storeFyDocumentNo = (StoreFyDocumentNo)opdIssueNo.get(0);
			  storeFyDocumentNoId = storeFyDocumentNo!=null ? storeFyDocumentNo.getId():0;
		 }
		//String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	%>
<div class="Block">

<%
String visitNo = "";
int prescription_No=0;
String doctorName=" ";
String pre_date="";
String pre_time="";

int empId=0;

PatientPrescriptionHeader prescriptionHeader=null;
/*if(presList.size() >0){
for(PatientPrescriptionDetails prescriptionDetails : presList)
	prescriptionHeader=prescriptionDetails.getPrescription();   	

    prescriptionHeaderId=prescriptionHeader.getId();
     if(prescriptionHeader.getVisit().getDoctor()!=null)
	 visitNo =""+ prescriptionHeader.getVisit().getVisitNo();
		if(prescriptionHeader.getVisit().getDoctor()!=null)
			consultantId = prescriptionHeader.getVisit().getDoctor().getId();
		if(prescriptionHeader.getPrescriptionNo()!=null)
		prescription_No=prescriptionHeader.getPrescriptionNo();
		if(prescriptionHeader.getVisit().getDoctor()!=null)
		doctorName=prescriptionHeader.getVisit().getDoctor().getFirstName()+" "+presList.get(0).getPrescription().getVisit().getDoctor().getLastName();
		if(prescriptionHeader.getPrescriptionDate()!=null)
		pre_date=""+prescriptionHeader.getPrescriptionDate();
		if(prescriptionHeader.getPrescriptionTime()!=null)
		pre_time=prescriptionHeader.getPrescriptionTime();	
}*/
	%>
	
	<!-- <label> MO</label> -->


<!--<select name="specialty">
<option value="AMA">AMA</option>
<option value="physician">physician</option>
</select>	
-->

<div class="Clear"></div>


<input type="hidden" name="serviceNo" id="serviceNoNo" value=""/>
<input type="hidden" name="hinNoS" value="<%=hinNo%>"/>
<input type="hidden" name="serviceNoS" value="<%=serviceNo%>"/>

<%
%>

<div class="Clear"></div>
</div>
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%=storeFyDocumentNoId%>"  />
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->

<!--<label>Page No</label>
<label class="value"><%=pageNo%></label>

-->

<div class="Clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<input type="hidden" value="<%=deptId %>" name="deptId" id="deptId" />
<input type="hidden" value="" name="empId" id="empId" />
<input type="hidden" value="<%=hinId %>" name="hinId" id="hinId" />
<input type="hidden" value="" name="prescription" id="prescription" />
<input type="hidden" name="date1" id="date" value="<%=date %>" />
<input type="hidden" name="time1" id="time" value="<%=time %>" />
<input type="hidden" name="changeBy" id="changeBy" value="<%=userName %>"/>
<input type="hidden" name="opdIssueMasterId" id="opdIssueMasterId" value="" />
<div class="Clear"></div>
<!--<h4>Ward Consumption Details</h4>-->
	<%
	int i=1;
	int presHdId = 0;
	if(presList.size() > 0){ %>
<!--<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowPrescription();" align="right" />
	 <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowPrescription();" value=" "	

align="right" />

-->
<!--<div id="searchresults" tabindex=1>
<jsp:include page="searchResultPO.jsp" />
<div id="searchtable"></div>
--><div class="Clear"></div>
<div  class="cmntable">
	<table width="100%" colspan="7" id="stockDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl No.</th>
			<!-- 
			<td width="10%">
			<label valign="left" class="smalllabel">Lot Number</label>
			</td>  
			-->
			<th width="5%">Mat Code</th>
			<th width="10%">Nomenclature</th>
<!-- 			<th width="10%">Barcode</th> -->
			<th width="5%">A/U</th>
			<th width="5%">Batch  No.</th>
			<th width="8%">DOE</th>
			<th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<th width="5%">Route</th>
			<th width="2%">Qty </br>Prescribed</th>
			<th width="7%">Stock </br>in Ward Pharmacy</th>
			<th width="25%">Issued Qty</th>
			<th width="25%">Issue Qty</th>
			<!-- <th width="25%">Qty Issued/RC</th> -->
<!-- 			<th width="8%">NIS</th> -->
			<th width="10%">Stock in</br>Stores</th>
			<%-- <%if(deptId!=24){%>
			<th style="width: 30px;">Loan out from</br>Med Store</th>
			<th >Qty </br>Loan out</th>
			<th width="5%">Mark </br>for LP</th>
			<th width="5%">Qty LP</th>
			<%}%> --%>
			<th width="5%">Remarks</th>
			<th width="8%">Add</th>
			<!--
			<th width="10%">Issue</th>
			<th width="5%">Send For LP</th>-->
		</tr>
	</thead>
	<tbody>
	<%
	System.out.println("presList.size"+presList.size());
		for(PatientPrescriptionDetails prescriptionDetails : presList){
		int qtyIssued = 0;
		if(prescriptionDetails.getQtyIssued() != null){
			qtyIssued = prescriptionDetails.getQtyIssued();
		}
		presHdId = prescriptionDetails.getPrescription().getId();

		int qtyPending =0;
		BigDecimal totalQty=new BigDecimal(0);
		
		Iterator itr= listOfItemsStock.iterator();
			
			while(itr.hasNext())
			{
				 Object[] pair = (Object[]) itr.next();
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		 if(pair[1]!=null){
	         	   totalQty=new BigDecimal((pair[1].toString()));
	         		 }
	         	 }
			} 
			
			
			Iterator itrsis=listOfItemsStockInStock.iterator();
			BigDecimal totalStockQty=new BigDecimal(0);
			while(itrsis.hasNext())
			{
				 Object[] pair = (Object[]) itrsis.next();
				if(pair[0]!=null)
				{
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		 if(pair[1]!=null){
	         		totalStockQty=new BigDecimal((pair[1].toString()));
	         		 }
	         	 }
				}
			}
		//BigDecimal stockAvailable = new BigDecimal(0);
	/*	Integer stockAvailable=new Integer(0);
		if(stockInHandList.size() > 0){
			for(Object[] batchStock : stockInHandList){
				if(batchStock[0].equals(prescriptionDetails.getItem().getId())){
					if(batchStock[1] != null)
						stockAvailable = (Integer)batchStock[1];
						//stockAvailable = (BigDecimal)batchStock[1];
					break;
				}
			}

		}*/
		int totalPresQty = 0;
		if(prescriptionDetails.getTotal()!=null){
			totalPresQty = prescriptionDetails.getTotal();
		}
				qtyPending =totalPresQty -  qtyIssued;
	%>
<tr>
			<td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionDtId<%=i %>" readonly="readonly" />
			</td>
			<td width="5%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId<%=i %>" id="itemId<%=i %>" value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="30" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" name="itemId" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			<!--<input type="hidden" size="10" name="qtyPrescribed" id="qtyPrescribed<%=i%>" value="0" onblur="calculatePendingQty(this.value,<%=i %>);"/>
			<input type="hidden" size="10" name="qtyPrescribedHide" id="qtyPrescribedHide<%=i%>" value=""/>--></td>
<%-- 			<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=i %>" id="barCodeNo<%=i %>" onchange="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}" onblur="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}" /></td> --%>
<%if(prescriptionDetails.getItem().getItemConversion()!=null){%>			
<td width="5%"><input type="text" name="au<%=i %>" id="au<%=i %>"	size="7" readonly="readonly" value="<%=prescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName()%>" /></td>
<%}else{ %>
<td width="5%"><input type="text" name="au<%=i %>" id="au<%=i %>"	size="7" readonly="readonly" value="" /></td>
<%}%>
			<td width="4%" style="">
			<!--<input type="text" name="batchNo<%= i%>" id="batchNo<%= i%>" size="10" readonly="readonly" value="" />-->
			<%
			List lis=new ArrayList();
			lis=(List)mapItem.get(prescriptionDetails.getItem().getId());
			%>
			<select name="batchNo<%= i%>" id="batchNo<%= i%>"  onchange="getDataForBarcode(this.value,<%=i %>)" validate="Batch No,string,yes" class="small3">
			<option value="0">Select Batch</option>
			<%for(int j=0;j<lis.size();j++){%>
			<option value="<%=lis.get(j)%>" ><%=lis.get(j)%></option>
			<%}%>
			</select>
			</td><input type="hidden" name="brandId<%= i%>" id="brandId<%= i%>" size="10" readonly="readonly" value="" /></td>
			<td width="8%"><input type="text" name="expiryDate<%=i %>" id="expiryDate<%=i %>"	size="10" readonly="readonly" value="" />
			<input type="hidden" name="costPrice<%=i %>" id="costPrice<%=i %>"	size="10" readonly="readonly" value="" />
			</td>
			<%if(prescriptionDetails.getDosage()!=null){ %>
			<td width="5%"><input type="text" size="5" value="<%=prescriptionDetails.getDosage() %>" name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<%}else{  %>
			<td width="5%"><input type="text" size="5" value=" " name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<% }%>
			<td width="7%"><input type="text" size="10" value="<%=prescriptionDetails.getFrequency().getFrequencyName() %>" name="frequencyId<%=i%>" readonly="readonly" id="frequencyId<%=i%>" />
			<input type="hidden" name="frequencyName<%=i %>" id="frequencyName<%=i %>" value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<td width="5%"><input type="text" size="5" value="<%=prescriptionDetails.getNoOfDays() %>" name="noOfDays" readonly="readonly" id="noOfDays<%=i%>" />
			<!--<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />-->
			</td>
			<%if(prescriptionDetails.getRoute()!=null){ %>
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getRoute() %>" name="intake" readonly="readonly" id="intake<%=i%>" />
			</td><%}else{  %>
			<td width="5%"><input type="text" size="6" value=" " name="intake" readonly="readonly" id="intake<%=i%>" /></td>
			<% }%>
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription" readonly="readonly" id="qtyPrescription<%=i%>" /></td>			
			<td width="7%"><input type="text" size="6" name="stockAvailable<%=i%>" id="stockAvailable<%=i%>"  value="<%=totalQty%>" readonly /></td>
			<td width="7%"><input type="text"  size="6" name="prevQtyIssued<%=i%>" id="prevQtyIssued<%=i%>" value="<%=qtyIssued %>" onblur="checkQty(<%=i%>)" readonly="readonly"/></td>              
		<td width="8%">
		<!-- <div class="rcDiv"> -->
		<%
		if(totalQty.compareTo(new BigDecimal(0))>0){
		%>
			
			<input type="text"  size="6" name="qtyIssued<%=i%>" readonly="readonly" id="qtyIssued<%=i%>" value="" onblur="checkQty(<%=i%>)"/>
			
			<%-- <span>RC<input type="checkbox" onclick="return rcFunction(<%=i %>)" id="rc<%=i %>" name="rc<%=i %>" /></span>
			<input type="text" style="display: none"  size="6" name="rcQty<%=i%>"  id="rcQty<%=i%>" value="" onblur="checkQty(<%=i%>)"/> --%>
		<%}else{ %>
			<input type="text"  size="6" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" value="" onblur="checkQty(<%=i%>)" readonly="readonly"/>
			
			<%-- <span>RC<input type="checkbox" onclick="return rcFunction(<%=i %>)" id="rc<%=i %>" name="rc<%=i %>" /></span>
			<input type="text" style="display: none"  size="6" name="rcQty<%=i%>"  id="rcQty<%=i%>" value="" onblur="checkQty(<%=i%>)"/> --%>
		<%} %>
		<!-- </div> -->
		<!--<input type="hidden"  size="10" name="qtyPending<%=i%>" id="qtyPending<%=i%>" value="0" readonly />-->
		</td>
<%-- 		<td width="7%"><input type="checkbox" name="nis<%=i%>" id="nis<%=i%>"   /></td> --%>
		<td width="10%">
        <input size="6" type="text" name="qtyStock" value="<%=totalStockQty%>" readonly/></td>
				<%
				String disableStr = "";
				String disableLoanout = "";
				String disableLP = "";
				if(totalQty.intValue()>=prescriptionDetails.getTotal()){
					disableLoanout = "disabled";
					disableLP = "disabled";
				}
				if((totalQty.intValue())<prescriptionDetails.getTotal() && (totalStockQty.intValue())>0){
					disableLP = "disabled";
				}
				if((totalQty.intValue()<prescriptionDetails.getTotal()) && (totalStockQty.intValue()==0)){
					disableLoanout = "disabled";
				}	
		int j=prescriptionDetails.getTotal()-totalQty.intValue();
		int k=0;
			 try{
			k=prescriptionDetails.getTotal()-(totalQty.intValue()+totalStockQty.intValue());
		}catch(Exception e){
			k=0;
		}%>
		  <%if(deptId==24){%> 
		  <td ><input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  /></td>
		<td width="8%"><input name="Button" id="add<%=i %>" type="button" class="buttonAdd" value="" onclick="generateRowPrescription(<%=i %>);" /></td>
		<%}%>
		<%-- <% if(deptId!=24){
			if(j>0){
		if(qtyPending == 0){ %>
		<td width="6%"><input size="10" type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lotOut<%=i%>"  id="lo<%=i%>"  onclick="enableQtyField(this,'lotQty<%=i%>')" <%=disableLoanout %>/></td>
		<td ><input type="text" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>"  readonly="readonly"/></td>
		<%}else{
		if(k<=0){
		%>
		<td width="6%"><input size="6" type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lotOut<%=i%>"  id="lo<%=i%>"  onclick="enableQtyField(this,'lotQty<%=i%>')" <%=disableLoanout %>/></td>
		<td ><input type="text"  size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>" readonly="readonly" /></td>
		<%}else{%>
		<td width="6%"><input size="6" type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lotOut<%=i%>"  id="lo<%=i%>"   onclick="enableQtyField(this,'lotQty<%=i%>')" <%=disableLoanout %>/></td>
		<td ><input type="text" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>" readonly="readonly" /></td>
		<% }}}else{%>
		<td width="6%"><input size="10" type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lotOut<%=i%>"  id="lo<%=i%>"   onclick="enableQtyField(this,'lotQty<%=i%>')" <%=disableLoanout %>/></td>
		<td ><input type="text" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>" readonly="readonly" /></td>
		<%}%>
			<%
			if(prescriptionDetails.getSoItem()!=null){
			if(prescriptionDetails.getSoItem().equals("n")){%>
			<td width="6%"><input size=size="10" type="checkbox"  value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>');enableQtyField(this,'lpQty<%=i%>')" <%=disableLP %>/></td>
			<td ><input type="text" size="10" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>"  readonly="readonly" /></td>
			<%}}else{if(k>0){%>
			<td width="6%"><input size=size="10" type="checkbox"  value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>');enableQtyField(this,'lpQty<%=i%>')" <%=disableLP %> /></td>
			<td width="6%"><input type="text" size="6" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>" readonly="readonly"  />
			<input type="hidden" name="lpId<%=i%>" id="lpId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			</td><%}else{%>
			<td width="6%"><input size=size="10" type="checkbox"  value="<%=prescriptionDetails.getItem().getId()%>" class="radioAuto" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>');enableQtyField(this,'lpQty<%=i%>')" <%=disableLP %> /></td>
			<td ><input type="text" size="6" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>" readonly="readonly" /></td>
			<%}}}else{
				if(j>0){
			if(qtyPending == 0){%>
			<td ><input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut<%=i%>"  id="lo<%=i%>" /></td>
			<td ><input type="hidden" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>"  /></td>
			<%}else{%>
				<td ><input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut<%=i%>" id="lo<%=i%>" /></td>
			<td ><input type="hidden" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>" /></td>
			<%}}else{%>
			<td ><input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut<%=i%>"  id="lo<%=i%>" /></td>
			<td ><input type="hidden" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>"  /></td>
			<%}%>
				<%if(prescriptionDetails.getSoItem()!=null){
				if(prescriptionDetails.getSoItem().equals("n")){%>
				<td ><input type="hidden" size="6" value="<%=prescriptionDetails.getItem().getId()%>" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" />	</td>
				<td ><input type="hidden" size="6" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>"  /></td>
				<%}}else{%>
				<td><input type="hidden" size="6" value="<%=prescriptionDetails.getItem().getId()%>" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" /></td>
				<td><input type="hidden" size="6" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>"/>
				<input type="hidden" name="lpId<%=i%>" id="lpId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
				</td>
				<%}%>
			<%}%> --%>
		<%if(deptId!=24){%> 
		<td ><input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  /></td>
		<td width="8%"><input name="Button" id="add<%=i %>" type="button" class="buttonAdd" value=""  onclick="if(generateRowPrescription(<%=i %>)){this.setAttribute('disabled', true);document.getElementById('qtyIssued'+<%=i %>).readOnly=true;}" /></td>
		<%}%>
		<input type="hidden" name="qtyPending<%=i%>" id="qtyPending<%=i %>"	value="<%=qtyPending %>" />
		
		<!--<td>
		<%
		
		if(qtyPending == 0)
			{
		%>
		<input type="button" id="issue<%=i%>" name="issue" value="" class="buttonIssue" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')" disabled="disabled"/>
		<%}else{ %>
		<input type="button" id="issue<%=i%>" name="issue" value="" class="buttonIssue" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')"/>
		<%} %>
		</td>
		-->
		<!--  <td width="5%"><input type="checkbox" size="10" value="n" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')"/>
			<input type="hidden" name="lpId" id="lpId<%=i %>"	value="n" />
			<input type="hidden" name="qtyPending" id="qtyPending<%=i %>"	value="<%=qtyPending %>" />
			</td>-->
		</tr>
		<%i++;
		}%>
		</tbody><input type="hidden" name="counter" id="listsize"	value="<%=presList.size() %>" />
		</table>
		<div class="Clear"></div>
		</div>
		<div class="Clear"></div>
	<%}else{ %>
	
     <div class="Clear"></div>
	<div id="prescriptionDiv">
	<div class="Clear"></div>
	<div  class="cmntable">
	<table width="100%" colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
		   <th width="5%">Sl No.</th>
		
			<th width="5%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="10%">Barcode</th>
			<th width="5%">A/U</th>
			<th width="5%">Batch  No.</th>
			<th width="8%">DOE</th>
			<th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<th width="5%">Route</th>
			<th width="5%">Qty </br>Prescribed</th>
			<th width="7%">Stock in</br>Ward Pharmacy</th>			
			<th width="16%">Qty Issued/RC</th>
			<th width="10%">Stock in </br>Med Store</th>
			<%if(deptId!=24){%>
			<th style="width: 30px;">Loan out from</br>Med Store</th>
			<th >Qty </br>Loan out</th>
			<th width="5%">Mark </br>for LP</th>
			<th width="5%">Qty LP</th>
			<%}%>
			<th width="5%">Remarks</th>
			<th width="8%">Add</th>
			<th width="10%">Delete</th>
			
		</tr>
	</thead>
	<tbody>
	
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>"  /></td>

			<td width="8%"><input type="text" size="10" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId<%=i%>" id="itemId<%=i %>"	value="" /></td>
			<td width="12%">
			<input type="text" size="50" value="" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"	onblur="checkForNomenclature(this.value, '<%=i%>','<%=deptId %>','prescription');" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=i%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=i%>'});
			</script></td>
         <td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=i%>" id="barCodeNo<%=i %>" onchange="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}"onblur="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}" /></td>
<td width="5%">
<input type="text" name="au<%=i %>" id="au<%=i %>"	size="7" readonly="readonly" 
value="" />
</td>




<td width="4%" style="">
	<select name="batchNo<%= i%>" id="batchNo<%= i%>"  onchange="getDataForBarcode(this.value,<%=i %>)" validate="Batch No,string,yes" class="small3">
		<option value="0">Select Batch</option>
	 </select>
</td>	
<input type="hidden" name="brandId<%= i%>" id="brandId<%= i%>" size="10" readonly="readonly" value="" />			
	<td width="8%">
	       <input type="text" name="expiryDate<%=i %>" id="expiryDate<%=i %>"	size="10" readonly="readonly" value="" />
			<input type="hidden" name="costPrice<%=i %>" id="costPrice<%=i %>"	size="10" readonly="readonly" value="" />
	</td>		
			
	<td width="5%">
	       <input type="text" size="5" value=" " name="strength<%=i%>" id="strength<%=i%>" />
	</td>			
	<td width="7%">
	  <select name="frequencyName<%=i%>") onblur="getFrequencyValue(this.value,'<%=i%>');"	id="frequencyName<%=i%>">
				<option value="0">Select Frequency</option>
				<%for(MasFrequency masFrequency:frequencyList){%>
				<option value="<%=masFrequency.getFeq() %>"><%=masFrequency.getFrequencyName()%></option>
				<%} %>
		</select>
		  <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
	</td>
	<td width="5%">
	     <input type="text" size="5" value="" name="noOfDays<%=i %>"  id="noOfDays<%=i%>"  onblur="setTotal('<%=i %>')"/>
	</td>			
		<td width="5%"><input type="text" size="6" value=" " name="intake<%=i %>" id="intake<%=i%>" />
			</td>
		
			<td width="5%"><input type="text" size="6" value="" name="qtyPrescription<%=i %>" id="qtyPrescription<%=i%>" />
			</td>
			
			<td width="7%"><input type="text" size="6" name="stockAvailable<%=i%>" id="stockAvailable<%=i%>"  

value=""  /></td>
          
		<td width="8%">
		
	<input type="text"  size="6" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" readonly="readonly" value="" onblur="checkQty(<%=i%>)" />

		</td>
		 <td width="10%">
        <input size="6" type="text" name="qtyStock<%=i %>" id="qtyStock<%=i %>" value="" /></td>
	
		
	
		<td width="6%">
			<input size="6" type="checkbox" value="" class="radioAuto" name="lotOut<%=i%>"  id="lo<%=i%>"   onclick="enableQtyField(this,'lotQty<%=i%>')" />
		</td>
		<td >
			<input type="text" size="6" value="" name="lotQty<%=i%>"  id="lotQty<%=i%>"  />
		</td>
	
	
			<td width="6%">
			<input size="10" type="checkbox"  value="" class="radioAuto" name="lp<%=i%>" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>');enableQtyField(this,'lpQty<%=i%>')" />
			</td>
			<td >
			<input type="text" size="6" value="" name="lpQty<%=i%>"  id="lpQty<%=i%>"  />
			</td>
	<td >
			<input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  />
			</td>
		<td width="8%">
		<input name="Button" type="button" id="add<%=i %>" class="buttonAdd" value="" onclick="addRowForDirectPrescription();" />
		</td>
		<td width="8%">
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('stockDetails',this);" align="right" />
	
		</td>
		</tr>
	</tbody>
</table>
		<%
     //	}
	}
     %>

</div>
</div>
<input type="hidden" name="counter" id="listsize"	value="<%=i %>" />
<input type="hidden" value="<%=i %>" name="hdb" id="hdb">
<input type="hidden" name="presHdId" id="presHdId" value="<%=presHdId %>"/>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" name="save"	value="Save" class="button" onclick="fillPrescribeBy();" />

<input type="button" name="reset"	value="Next Prescription" class="buttonBig" 

onclick="fillPrescribeBy();" />
<!-- 
<input type="button" class="button" value="Send for Lp" 

onclick="if(checkSendForLP()){submitForm('opdPatientIssue','stores?method=submitDispensaryForLp');}"	align="right" />
 -->
  <%if(deptId!=24){ %>
 <input type="hidden" class="button" value="Send for Lp" 
onclick="submitForm('opdPatientIssue','stores?method=submitDispensaryForLpWithBarCode')"	align="right" />
<%}%>
<input type="hidden" name="add"	id="addbutton" value="Print" class="button"	

onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" />
<input type="button" name="add"	id="addbutton" value="Print Previous Prescription" class="buttonBig2"	onClick="submitForm('opdPatientIssue','stores?method=printPatientIssue');" accesskey="g" />
<%--<input type="hidden" class="button" value="Delete"	onclick="openPopupForDelete('<%=opdIssuenoIncremented%>');" 

align="right" />--%>	
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>
<input type="hidden" name="changeDate" id="changeDate" value="<%=date %>"/>
<label>Changed Time:</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>
</div>
<input type="hidden" name="rows" id="rr" value="1" />
<style>
.rcDiv {width:180px; float:left; padding:0px;}
.rcDiv span {float: left; width: 47px; margin-left: 2px; padding-top:3px; color:#000;}

</style>
