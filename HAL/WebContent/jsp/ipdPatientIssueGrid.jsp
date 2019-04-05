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
	List listOfItemsInDis=new ArrayList();
	List itemList= new ArrayList();
	List issueNoList= new ArrayList();
	List empList= new ArrayList();
	List listOfItemsStock=new ArrayList();
	String date="";
	List<PatientPrescriptionDetails>  presList = new ArrayList<PatientPrescriptionDetails>();
	Set<Integer> itemSet = new HashSet<Integer>();
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
			if(map.get("listOfItemsInDis")!=null){
				listOfItemsInDis=(List)map.get("listOfItemsInDis");
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
			if(map.get("itemSet") != null){
				itemSet = (Set<Integer>)map.get("itemSet");
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

	%>
	


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
			<!-- <th width="5%">Dosage</th>
			<th width="7%">Frequency</th>
			<th width="5%">No. </br>of Days</th>
			<th width="5%">Route</th> -->
			<th width="2%">Qty </br>Prescribed</th>
			
			
			<th width="25%">Qty Issued/RC</th>
<!-- 			<th width="8%">NIS</th> -->
           <th width="5%">Remarks</th>
           <th width="7%">Stock in</br>Ward Pharmacy</th>
           <th width="10%">Stock in </br>Dispensary</th>
			<th width="10%">Stock in </br>Med Store</th>
			<%-- <%if(deptId!=24){%>
			<th style="width: 30px;">Loan out from</br>Med Store</th>
			<th >Qty </br>Loan out</th>
			<th width="5%">Mark </br>for LP</th>
			<th width="5%">Qty LP</th>
			<%}%> --%>
			
			<!-- <th width="8%">Select</th> -->
			<th width="8%">Add</th>
			<!--
			<th width="10%">Issue</th>
			<th width="5%">Send For LP</th>-->
		</tr>
	</thead>
	<tbody>
	<%
	
					int totalPresQty = 0;
					int qtyIssued = 0;
					int loopCount = 0;
					int wardId = 0;
					PatientPrescriptionDetails prescriptionDetails = new PatientPrescriptionDetails();
					
					System.out.println("itemSet"+itemSet.size());		
					for(int itmId : itemSet){			
						loopCount = 1;
						totalPresQty = 0;
						qtyIssued = 0;
						
		for(PatientPrescriptionDetails presDetails : presList){
			wardId = presDetails.getPrescription().getDepartment().getId();
			if(itmId==presDetails.getItem().getId())
			{
				 prescriptionDetails =  presDetails;
				if(prescriptionDetails.getTotal()!=null){
					totalPresQty += prescriptionDetails.getTotal();
				}
				
			
		
		if(prescriptionDetails.getQtyIssued() != null){
			qtyIssued += prescriptionDetails.getQtyIssued();
		}
			}
	
	
		
	if(loopCount == presList.size())
	{
		System.out.println("totalPresQty"+totalPresQty);
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
			System.out.println("listOfItemsInDis"+listOfItemsInDis.size());
			Iterator itrsisDis=listOfItemsInDis.iterator();
			BigDecimal totalStockQtyDis=new BigDecimal(0);
			while(itrsisDis.hasNext())
			{
				 Object[] pair = (Object[]) itrsisDis.next();
				if(pair[0]!=null)
				{
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		 if(pair[1]!=null){
	         			totalStockQtyDis=new BigDecimal((pair[1].toString()));
	         		 }
	         	 }
				}
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
			<select name="batchNo<%= i%>" id="batchNo<%= i%>"  onchange="getDataForBarcode(this.value,<%=i %>); checkDublicateBatch(<%=i %>);"   class="small3">
			<option value="0">Select Batch</option>
			<%for(int j=0;j<lis.size();j++){%>
			<option value="<%=lis.get(j)%>" ><%=lis.get(j)%></option>
			<%}%>
			</select>
			</td><input type="hidden" name="brandId<%= i%>" id="brandId<%= i%>" size="10" readonly="readonly" value="" /></td>
			<td width="8%"><input type="text" name="expiryDate<%=i %>" id="expiryDate<%=i %>"	size="10" readonly="readonly" value="" />
			<input type="hidden" name="costPrice<%=i %>" id="costPrice<%=i %>"	size="10" readonly="readonly" value="" />
			</td>
			
			<td width="5%"><input type="text" size="6" value="<%=totalPresQty%>" name="qtyPrescription<%=i%>" readonly="readonly" id="qtyPrescription<%=i%>" /></td>			
			          
		<td width="8%">
		<div class="rcDiv">
		<%
		if(totalQty.compareTo(new BigDecimal(0))>0){
		%>
			
			<input type="text"  size="6" name="qtyIssued<%=i%>"  id="qtyIssued<%=i%>" value="" readOnly="readonly" onblur="checkQty(<%=i%>);"/>
			<span>RC<input type="checkbox" onclick="return rcFunction(<%=i %>)" id="rc<%=i %>" name="rc<%=i %>" /></span>
			<input type="text" style="display: none"  size="6" name="rcQty<%=i%>"  id="rcQty<%=i%>" value=""  onblur="checkQty(<%=i%>);checkRC(<%=i%>);"/>
		<%}else{ %>
			<input type="text"  size="6" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" value="" readOnly="readonly" onblur="checkQty(<%=i%>);checkRC(<%=i%>);" />
			<span>RC<input type="checkbox" onclick="return rcFunction(<%=i %>)" id="rc<%=i %>" name="rc<%=i %>" /></span>
			<input type="text" style="display: none"  size="6" name="rcQty<%=i%>"  id="rcQty<%=i%>" value=""  onblur="checkQty(<%=i%>);checkRC(<%=i%>);"/>
		<%} %>
		</div>
		<!--<input type="hidden"  size="10" name="qtyPending<%=i%>" id="qtyPending<%=i%>" value="0" readonly />-->
		</td>
<%-- 		<td width="7%"><input type="checkbox" name="nis<%=i%>" id="nis<%=i%>"   /></td> --%>
        <td ><input type="text" size="10" value=" " name="remark<%=i%>"  id="remark<%=i%>"  /></td>
        <td width="7%">
        <input type="text" size="6" name="stockAvailable<%=i%>" id="stockAvailable<%=i%>"  value="<%=totalQty%>" readonly />
        <input type="hidden" size="6" name="totalstockAvailable<%=i%>" id="totalstockAvailable<%=i%>"  value="<%=totalQty%>" readonly />
        </td>
         <td width="10%">
        <input size="6" type="text" id="qtyDis<%=i%>" name="qtyDis<%=i%>" value="<%=totalStockQtyDis%>" readonly/></td>
		<td width="10%">
        <input size="6" type="text" id="qtyStock<%=i%>" name="qtyStock<%=i%>" value="<%=totalStockQty%>" readonly/></td>
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
		  
		  <%-- <td width="8%"><input name="Button" id="select<%=i %>" type="button" class="buttonAdd" value="Select"  onclick="if(document.getElementById('batchNo<%=i %>').value==0){alert('Please Select Batch');}else{document.getElementById('currentRowNum').value=<%=i %>;issuePopup(<%=wardId%>, <%=itmId%>)}" /></td> --%>
		<td width="8%"><input name="Button" id="add<%=i %>" type="button" class="buttonAdd" value="" onclick="generateRowPrescription(<%=i %>, <%=wardId %>, <%=itmId%>);" /></td>
		<%}%>
		
		<%if(deptId!=24){%> 
		
		<%-- <td width="8%"><input name="Button" id="select<%=i %>" type="button" class="buttonAdd" value="Select"  onclick="if(document.getElementById('batchNo<%=i %>').value==0){alert('Please Select Batch');}else{document.getElementById('currentRowNum').value=<%=i %>;issuePopup(<%=wardId %>, <%=itmId%>)}" /></td> --%>
		<td width="8%"><input name="Button" id="add<%=i %>" type="button" class="buttonAdd" value=""  onclick="generateRowPrescription(<%=i %>, <%=wardId %>, <%=itmId%>);" /></td>
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
		<%i++;}
		loopCount++;
			}}%>
		</tbody><input type="hidden" name="counter" id="listsize"	value="<%=presList.size() %>" />
		</table>
		<div class="Clear"></div>
		</div>
		<div class="Clear"></div>
	<%}%>

</div>
</div>
<input type="hidden" name="counter" id="listsize"	value="<%=i %>" />
<input type="hidden" value="<%=(i-1) %>" name="hdb" id="hdb">
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
<style>
.rcDiv {width:180px; float:left; padding:0px;}
.rcDiv span {float: left; width: 47px; margin-left: 2px; padding-top:3px; color:#000;}

</style>
