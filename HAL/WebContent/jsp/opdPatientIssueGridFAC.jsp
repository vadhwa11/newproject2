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
	List<PatientPrescriptionDetails>  nipList = new ArrayList<PatientPrescriptionDetails>();
	List<PatientPrescriptionDetails>  injList = new ArrayList<PatientPrescriptionDetails>();
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
			System.out.println("presListinjsp"+presList.size());
			if(map.get("stockInHandList") != null){
				stockInHandList = (List<Object[]>)map.get("stockInHandList");
			}
			if(map.get("issueList") != null){
				issueList = (List<StoreOpPatientIssueM>)map.get("issueList");
			}
			if(map.get("injList") != null){
				injList = (List<PatientPrescriptionDetails>)map.get("injList");
			}
			if(map.get("nipList") != null){
				nipList = (List<PatientPrescriptionDetails>)map.get("nipList");
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
<div class="cmntableHeightAuto">
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
			<th width="5%">Qty </br>Prescribed</th>
			<th width="8%">Qty </br>Issued</th>
			<th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<!-- <th width="5%">Route</th> -->
			<th width="7%">Batch</br>Stock</th>
			<th width="7%">Stock </br>in Dispensary</th>
			
			
<!-- 			<th width="8%">NIS</th> -->
			<th width="10%">Stock in </br>Med Store</th>
			<%-- <%if(deptId!=24){%>
			<th style="width: 30px;">Loan out from</br>Med Store</th>
			<th >Qty </br>Loan out</th>
			<th width="5%">Mark </br>for LP</th>
			<th width="5%">Qty LP</th>
			<%}%> --%>
			<th width="5%">Instructions</th>
			<th width="8%"></th>
			<!--
			<th width="10%">Issue</th>
			<th width="5%">Send For LP</th>-->
		</tr>
	</thead>
	<tbody>
	<%
	String color = "";
		BigDecimal minimumQty = new BigDecimal(500);
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
			if(minimumQty.compareTo(totalQty)==1)
			{
				color = "white";
			}
			else
			{
				color = "white";
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
<tr >
			<td width="5%" ><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" value="mat" id="itemType<%=i%>" name="itemType<%=i%>" readonly="readonly" />
			<input type="hidden" name="batchNoValue<%=i%>" id="batchNoValue<%=i%>" size="10" readonly="readonly" value="" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionDtId<%=i %>" readonly="readonly" />
			</td>
			<td width="5%" ><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			
			</td>
			<td width="10%" ><input type="text" size="30" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" name="itemId<%=i %>" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			<!--<input type="hidden" size="10" name="qtyPrescribed" id="qtyPrescribed<%=i%>" value="0" onblur="calculatePendingQty(this.value,<%=i %>);"/>
			<input type="hidden" size="10" name="qtyPrescribedHide" id="qtyPrescribedHide<%=i%>" value=""/>--></td>
<%-- 			<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=i %>" id="barCodeNo<%=i %>" onchange="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}" onblur="if(this.value!=''){getDataForBarcode(this.value,<%=i %>)}" /></td> --%>
<%if(prescriptionDetails.getItem().getItemConversion()!=null){%>			
<td width="5%" ><input type="text" name="au<%=i %>" id="au<%=i %>"	size="7" readonly="readonly" value="<%=prescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName()%>" /></td>
<%}else{ %>
<td width="5%" ><input type="text" name="au<%=i %>" id="au<%=i %>"	size="7" readonly="readonly" value="" /></td>
<%}%>
			<td width="4%"  >
			
			
				<%
			List<StoreItemBatchStock> lis=new ArrayList<StoreItemBatchStock>();
			lis=(List<StoreItemBatchStock>)mapItem.get(prescriptionDetails.getItem().getId());
			%>
			<select name="batchNo<%= i%>" id="batchNo<%= i%>"  onchange="if(cheackForBatch(<%=i%>)){getDataForBarBatchStockId(this.value,<%=i%>)}"   class="small3">
			<option value="0">Select Batch</option>
			
			<%
			if(lis!=null)
			{
			for(int j=0;j<lis.size();j++){if(j==0){%>
			<option selected="selected" value="<%=lis.get(j).getId()%>" ><%=lis.get(j).getBatchNo()%></option>
			<%}else
				{%>
				<option value="<%=lis.get(j).getId()%>" ><%=lis.get(j).getBatchNo()%></option>
				<%
				
				}}
			}
				%>
			</select>
				<script type="text/javascript">
			document.getElementById('batchNo<%=i%>').onchange();
			</script>
			</td><input type="hidden" name="list<%=i%>" id="list<%=i%>" size="10" readonly="readonly" value="<%=lis!=null?lis.size():0%>" />
			<input type="hidden" name="brandId<%= i%>" id="brandId<%= i%>" size="10" readonly="readonly" value="" /></td>
			<td width="8%" ><input type="text" name="expiryDate<%=i %>" id="expiryDate<%=i %>"	size="10" readonly="readonly" value="" />
			<input type="hidden" name="costPrice<%=i %>" id="costPrice<%=i %>"	size="10" readonly="readonly" value="" />
			</td>
			<td width="5%" ><input type="text" size="6" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription<%=i%>" readonly="readonly" id="qtyPrescription<%=i%>" /></td>	
			<td width="8%" >
		<%
		if(totalQty.compareTo(new BigDecimal(0))>0){
		%>
			<input type="text"  size="6" name="qtyIssued<%=i%>" value="<%=prescriptionDetails.getTotal()%>" id="qtyIssued<%=i%>" value="" onblur="checkQty(<%=i%>)"/>
		<%}else{ %>
			<input type="text"  size="6" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>"  value="<%=prescriptionDetails.getTotal() %>" onblur="checkQty(<%=i%>)" readonly="readonly"/>
		<%} %>
	
		</td>
			<%if(prescriptionDetails.getDosage()!=null){ %>
			<td width="5%" ><input type="text" size="5" value="<%=prescriptionDetails.getDosage() %>" name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<%}else{  %>
			<td width="5%" ><input type="text" size="5" value=" " name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<% }%>
			<td width="7%" ><input type="text" size="10" value="<%=prescriptionDetails.getFrequency().getFrequencyName() %>" name="frequencyId<%=i%>" readonly="readonly" id="frequencyId<%=i%>" />
			<input type="hidden" name="frequencyName<%=i %>" id="frequencyName<%=i %>" value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<td width="5%" ><input type="text" size="5" value="<%=prescriptionDetails.getNoOfDays() %>" name="noOfDays" readonly="readonly" id="noOfDays<%=i%>" />
			<!--<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />-->
			</td>
			<%-- <%if(prescriptionDetails.getRoute()!=null){ %>
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getRoute() %>" name="intake" readonly="readonly" id="intake<%=i%>" />
			</td><%}else{  %>
			<td width="5%"><input type="text" size="6" value=" " name="intake" readonly="readonly" id="intake<%=i%>" /></td>
			<% }%> --%>
					
			<td width="7%" >
			<input type="hidden" size="6" name="stockDispensary<%=i%>" id="stockDispensary<%=i%>"  value="<%=totalQty%>" readonly />
			<input type="text" size="6" name="stockAvailable<%=i%>" id="stockAvailable<%=i%>"  value="<%=totalQty%>" readonly />
			</td>          
			<td width="7%">
			<input type="text" size="6" name="totalDispensary<%=i%>" id="totalDispensary<%=i%>"  value="<%=totalQty%>" readonly />         
	        </td> 
<%-- 		<td width="7%"><input type="checkbox" name="nis<%=i%>" id="nis<%=i%>"   /></td> --%>
		<td width="10%" >
        <input size="6" type="text" id="qtyStock<%=i%>" name="qtyStock" value="<%=totalStockQty%>" readonly/></td>
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
		  <td  ><input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  /></td>
		<td width="8%" ><input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowPrescription(<%=i %>);" /></td>
		<%}%>
	
		<%if(deptId!=24){%> 
		<td ><input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  /></td>
		<td width="8%" ><input name="Button" type="button" class="buttonAdd" value=""  onclick="if(generateRowPrescription(<%=i %>)){document.getElementById('qtyIssued'+<%=i %>).readOnly=true;}" /></td>
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
		</tbody><input type="hidden" name="counter" id="listsize"	value="<%=presList.size()+nipList.size()%>" />
		</table>
		<div class="Clear"></div>
		
		<div class="Clear"></div>
	<%}%>
	
		<div class="Clear"></div>
		<div class="Clear"></div>
		
		<%if(nipList.size()>0){ %>
		<!-- <h2>N.I.P Items</h2> -->
		<table width="100%" colspan="7" id="nipDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl No.</th>
		
			<th width="5%">NIP Code</th>
			<th width="10%">NIP Name</th>

			<th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<!-- <th width="5%">Route</th> -->
			<th width="5%">Qty </br>Prescribed</th>
			<th width="7%">Instructions</th>
		
		</tr>
	</thead>
	<tbody>
	<%
	int snip = 0;
		for(PatientPrescriptionDetails prescriptionDetails : nipList){
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
			<td width="5%"><input type="text" size="2" value="<%=++snip%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionDtId<%=i %>" readonly="readonly" />
			<input type="hidden" value="nip" id="itemType<%=i%>" name="itemType<%=i%>" readonly="readonly" />
			</td>
			<td width="5%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId<%=i %>" id="itemId<%=i %>" value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="60" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" name="itemId" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>

			<input type="hidden" name="brandId<%= i%>" id="brandId<%= i%>" size="10" readonly="readonly" value="" /></td>
		
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
		
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription" readonly="readonly" id="qtyPrescription<%=i%>" />
			<input type="hidden"  size="6" name="qtyIssued<%=i%>" readonly="readonly" id="qtyIssued<%=i%>" value="" />
			</td>			
			
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
	
		<%}%>
		
		<%if(deptId!=24){%> 
		
		<%}%>
		
		<td ><input type="text" size="10" readonly="readonly" value='<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():""%>' name="remark<%=i%>"  id="remark<%=i%>"  /></td>
		<input type="hidden" name="qtyPending<%=i%>" id="qtyPending<%=i %>"	value="<%=qtyPending %>" />
		
		
		
		</tr>
		<%i++;
		}%>
		
		</table>
		<div class="Clear"></div>
	
		<div class="Clear"></div>
	<%}%>
	
		
	<div class="Clear"></div>
		<div class="Clear"></div>
		
		<%if(injList.size()>0){ %>
		<!-- <h2>N.I.P Items</h2> -->
		<table width="100%" colspan="7" id="nipDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr><th width="5%">Sl No.</th>		
			<th width="5%">Mat Code</th>
			<th width="10%">Nomenclature</th>
			<th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<!-- <th width="5%">Route</th> -->
			<th width="5%">Qty </br>Prescribed</th>
			<th width="7%">Instructions</th>			
		</tr>
	</thead>
	<tbody>
	<%
	int sinj = 0;
		for(PatientPrescriptionDetails prescriptionDetails : injList){
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
			<td width="5%"><input type="text" size="2" value="<%=++sinj%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="injDetailsId" name="injDetailsId" readonly="readonly" />
			
			</td>
			<td width="5%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" readonly="readonly"/>
			
			</td>
			<td width="10%"><input type="text" size="60" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" readonly="readonly" />
			
			</td>

		
			<%if(prescriptionDetails.getDosage()!=null){ %>
			<td width="5%"><input type="text" size="5" value="<%=prescriptionDetails.getDosage()%>" readonly="readonly" />
			</td>
			<%}else{  %>
			<td width="5%"><input type="text" size="5" value=" "  readonly="readonly"  />
			</td>
			<% }%>
			<td width="7%"><input type="text" size="10" value="<%=prescriptionDetails.getFrequency().getFrequencyName() %>" readonly="readonly" />
			
			</td>
			<td width="5%"><input type="text" size="5" value="<%=prescriptionDetails.getNoOfDays() %>" readonly="readonly" />
			
			</td>
		
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getTotal() %>" readonly="readonly"/>
			
			</td>			
			
		
		
		<td ><input type="text" size="10" readonly="readonly" value='<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():""%>' /></td>
	
		
		
		
		</tr>
		<%i++;
		}%>
		
		</table>
		<div class="Clear"></div>
		
		<div class="Clear"></div>
	<%}%>
	
    
	

</div>
</div>
<input type="hidden" name="counter" id="listsize"	value="<%=i %>" />
<input type="hidden" value="<%=i %>" name="hdb" id="hdb">
<input type="hidden" name="presHdId" id="presHdId" value="<%=presHdId %>"/>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" name="save"	value="Save" class="button" onclick="fillPrescribeBy();" />

<!-- <input type="button" name="reset"	value="Next Prescription" class="buttonBig" 

onclick="fillPrescribeBy();" /> -->
<!-- 
<input type="button" class="button" value="Send for Lp" 

onclick="if(checkSendForLP()){submitForm('opdPatientIssue','stores?method=submitDispensaryForLp');}"	align="right" />
 -->
  <%-- <%if(deptId!=24){ %>
 <input type="hidden" class="button" value="Send for Lp" 
onclick="submitForm('opdPatientIssue','stores?method=submitDispensaryForLpWithBarCode')"	align="right" />
<%}%>
<input type="hidden" name="add"	id="addbutton" value="Print" class="button"	

onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" />
<input type="button" name="add"	id="addbutton" value="Print Previous Prescription" class="buttonBig2"	onClick="submitForm('opdPatientIssue','stores?method=printPatientIssue');" accesskey="g" /> --%>
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














