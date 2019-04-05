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
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
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
	//System.out.println("deptId "+deptId);
	//	int deptId = (Integer)map.get("deptId");
	//	String date=(String)map.get("date");
	//	String time=(String)map.get("time");
	//	String fromDateToDate=(String)map.get("fromDateToDate");
	List listOfItemsInStock=new ArrayList();
	List itemList= new ArrayList();
	List issueNoList= new ArrayList();
	List empList= new ArrayList();
	List listOfItemsStock=new ArrayList();
	List listOfItemsStockInStock=new ArrayList();
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

			if(map.get("listOfItemsStock") != null){
				listOfItemsStock=(List)map.get("listOfItemsStock");
			}
			if(map.get("listOfItemsStockInStock") != null){
				listOfItemsStockInStock=(List)map.get("listOfItemsStockInStock");
			System.out.println("this is stock size ashutosh singh"+listOfItemsStockInStock.size());
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
	int depId=0;
	if(session.getAttribute("deptId")!=null){
		depId=(Integer)session.getAttribute("deptId");
	}
	System.out.println("this is department"+depId);
	%>
<form name="opdPatientGridWithoutBarCode" method="post">
<div id="testDiv">
<input type="hidden"	name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		 List opdIssueNo=(List)map.get("opdIssueNo");
		 StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)opdIssueNo.get(0);

		String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
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
for(PatientPrescriptionDetails prescriptionDetails : presList)
	
prescriptionHeader=prescriptionDetails.getPrescription();   	

  
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
	%>
<label> Date</label>
<% String str_date=pre_date;
   String final_date=str_date.substring(8)+"-"+str_date.substring(5,7)+"-"+str_date.substring(0,4);
%>
<input type="text" name="<%=RequestConstants.DATE%>"id="pre_date" tabindex="1" value="<%=final_date%>"	readonly />
<label> Time</label>
<input type="text" name="<%=RequestConstants.TIME%>"	id="pre_time" tabindex="1" value="<%=pre_time%>"	MAXLENGTH="5" readonly />
<label> Visit No.</label>
<input type="text" name="<%=RequestConstants.VISIT_NUMBER%>"id="visitNo" tabindex="1" value="<%=visitNo%>"	readonly />
<div class="Clear"></div>
<label> Prescription No.</label>
<input type="text" name="<%=RequestConstants.PRESCRIPTION_NO%>"	id="prescriptionNo" tabindex="1" value="<%=prescription_No%>"	MAXLENGTH="5" readonly />
<label> Doctor Name</label>
<input type="text" name="doctor_name"	id="doctor_name" tabindex="1" value="<%=doctorName%>"	MAXLENGTH="5" readonly />
<input type="hidden" name="<%=RequestConstants.CONSULTING_DOCTOR%>"	id="consultant" tabindex="1" value="<%=consultantId%>"	MAXLENGTH="5" readonly />

<label>Disp Issue No. </label>
<label class="value"><%= opdIssuenoIncremented%></label>
<input type="hidden" id="opdIssueno" name="opdIssueno" value="<%= opdIssuenoIncremented%>" />	
<input type="hidden" id="issueNo" name="issueNo" value="<%= opdIssuenoIncremented%>" />
<input type="hidden" name="hinNoS" value="<%=hinNo%>"/>
<input type="hidden" name="serviceNoS" value="<%=serviceNo%>"/>
<label>Issue Date </label>
<% String issue_date=date.substring(0,2)+"-"+date.substring(3,5)+"-"+date.substring(6,10); %>
<label class="value"><%=date%></label>
<%
%>
<div class="Clear"></div>
<input type="hidden" id="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>"  />
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->

<!--<label>Page No</label>
<label class="value"><%=pageNo%></label>

-->
</div>
<div class="Clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<input type="hidden" value="<%=deptId %>" name="deptId" id="deptId" />
<input type="hidden" value="" name="empId" id="empId" />
<input type="hidden" value="<%=hinId %>" name="hinId" id="hinId" />
<input type="hidden" value="" name="prescription" id="prescription" />
<input type="hidden" name="date" id="date" value="<%=date %>" />
<input type="hidden" name="time" id="time" value="<%=time %>" />
<input type="hidden" name="date1" id="date" value="<%=date %>" />
<input type="hidden" name="changeBy" id="changeBy" value="<%=userName %>"/>
<input type="hidden" name="opdIssueMasterId" id="opdIssueMasterId" value="" />
<div class="Clear"></div>
<!--<h4>Ward Consumption Details</h4>-->
	<%
	int i=1;
	int presHdId = 0;
	if(presList.size() > 0){%>
<!--<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowPrescription();" align="right" />
	 <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowPrescription();" value=" "	align="right" />

-->
<!--<div id="searchresults" tabindex=1>
<jsp:include page="searchResultPO.jsp" />
<div id="searchtable"></div>
--><div class="Clear"></div>
<div  class="cmntable">
	<table width="100%" colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No.</th>
			<!-- <td width="10%"><label valign="left" class="smalllabel">Lot Number</label>      </td>  -->
			<th width="5%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<!--<th width="10%">BarCode No</th>-->
			<!--<th width="8%">Strength</th>-->
			<th width="9%">A/U</th>
			<th width="9%">Dosage</th>
			<th width="9%">Frequency</th>
			<th width="3%">No. of Days</th>
			<th width="5%">Intake</th>
			<th width="5%">Quantity Prescribed</th>
			<!--<th width="16%">Quantity Pending</th>-->
			<%if(depId!=24){%>
			<th width="15%">Stock in Dispensary</th>
			<% }%>
			<th width="15%">Stock in Medical Store </th>
			<th width="10%">Issue</th>
			<th width="10%">Quantity Issued</th>
			<%if(depId!=24){%>
			<th width="10%">Loan Out From Medical Store</th>
			<th width="5%">Loan Out Qty.</th>
			<th width="5%">Mark For LP</th>
			<th width="5%">LP Qty</th>
			<%}%>
		</tr>
	</thead>
	<tbody>
	<%
		for(PatientPrescriptionDetails prescriptionDetails : presList){
		int qtyIssued = 0;
		if(prescriptionDetails.getQtyIssued() != null){
			qtyIssued = prescriptionDetails.getQtyIssued();
		}
		presHdId = prescriptionDetails.getPrescription().getId();

		int qtyPending =0;
		BigDecimal totalQty=new BigDecimal(0);
		BigDecimal totalStockQty=new BigDecimal(0);

		Iterator itr= listOfItemsStock.iterator();
		System.out.println("this is size of list"+listOfItemsStock.size());
		Iterator itrsis=listOfItemsStockInStock.iterator();
			
			while(itr.hasNext())
			{
				 Object[] pair = (Object[]) itr.next();
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         	   totalQty=new BigDecimal((pair[1].toString()));
	        
	         	 }
			}
			while(itrsis.hasNext())
			{
				 Object[] pair = (Object[]) itrsis.next();
				if(pair[0]!=null)
				{
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		totalStockQty=new BigDecimal((pair[1].toString()));
	         	 }
				}
			}
			
	
		//BigDecimal stockAvailable = new BigDecimal(0);
		Integer stockAvailable=new Integer(0);
		if(stockInHandList.size() > 0){
			for(Object[] batchStock : stockInHandList){
				if(batchStock[0].equals(prescriptionDetails.getItem().getId())){
					if(batchStock[1] != null)
						stockAvailable = (Integer)batchStock[1];
						//stockAvailable = (BigDecimal)batchStock[1];
					break;
				}
			}

		}
		qtyPending =prescriptionDetails.getTotal() -  qtyIssued;
		
	%>
	<tr>
			<td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionId" readonly="readonly" />
			</td>
			<td width="5%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="50" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" size="10" name="qtyPrescribed" id="qtyPrescribed<%=i%>" value="0" onblur="calculatePendingQty(this.value,<%=i %>);"/>
			<input type="hidden" size="10" name="qtyPrescribedHide" id="qtyPrescribedHide<%=i%>" value="<%=prescriptionDetails.getTotal() %>"/>
			</td>
			<!--<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo" 
			id="barCodeNo<%=i %>" onblur="getDataForBarcode(this.value,<%=i %>)" /></td>
			--><!--<%if(prescriptionDetails.getItem().getStrength()!=null){ %>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getStrength() %>" name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<%}else{  %>
			<td width="10%"><input type="text" size="10" value=" " name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<% }%>
			-->
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getItemConversion().getItemUnitName() %>" name="au" readonly="readonly" id="au<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getDosage() %>" name="dosage" readonly="readonly" id="dosage<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getFrequency().getFrequencyName() %>" name="frequencyName" readonly="readonly" id="frequencyName<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getNoOfDays() %>" name="noOfDays" readonly="readonly" id="noOfDays<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<%if(prescriptionDetails.getInstruction()!=null){ %>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getInstruction() %>" name="intake" readonly="readonly" id="intake<%=i%>" />
			</td><%}else{  %>
			<td width="10%"><input type="text" size="10" value=" " name="intake" readonly="readonly" id="intake<%=i%>" />
			</td>
			<% }%>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription" readonly="readonly" id="qtyPrescription<%=i%>" />
			</td>

		<%if(depId!=24){%>
			<td width="16%">
		<input type="text" size="8" name="stockAvailable"<%=i%> id="stockAvailable<%=i%>" value="<%=totalQty %>"  /></td>
        <%}%>
        <td width="10%">
        <input size="10" type="text" name="qtyStock" value="<%=totalStockQty%>" readonly/></td>
		<td>
		<%
		if(qtyPending == 0){
		%>
		<input type="button" id="issue<%=i%>" name="issue" value="" class="buttonIssue" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')" disabled="disabled"/>
		<%}else{%>
		<input type="button" id="issue<%=i%>" name="issue" value="" class="buttonIssue" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')"/>
		<%}%>
		<td width="10%">
		<input type="text"  size="10" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" value="<%= qtyIssued%>" readonly />
		<input type="hidden"  size="10" name="qtyPending<%=i%>" id="qtyPending<%=i%>" value="0" readonly /></td>
		</td>
		<%
		int j=prescriptionDetails.getTotal()-new Integer(totalQty.toString());
		System.out.println(j);
		if(depId!=24){
		
			if(j>0){
		if(qtyPending == 0){%>
		<td width="10%">
			<input type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" disabled="disabled"/>
		</td>
		<td width="10%">
			<input type="text" size="10" value="" name="lotQty"  id="lotQty<%=i%>"  disabled="disabled"/>
		</td>
		<%}else{%>
			<td width="10%">
			<input type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" />
		</td>
		<td width="10%">
			<input type="text" size="10" value="" name="lotQty"  id="lotQty<%=i%>"  />
		</td>
		<%}
		}else{%>
		<td width="10%">
		
			<input type="checkbox" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" disabled="disabled"/>
		</td>
		<td width="10%">
			<input type="text" size="10" value="" name="lotQty"  id="lotQty<%=i%>" disabled="disabled" />
		</td>
		<%}%>
			<%if(prescriptionDetails.getSoItem()!=null){
			if(prescriptionDetails.getSoItem().equals("n")){%>
			<td width="6%">
			<input type="checkbox" size="10" value="<%=prescriptionDetails.getItem().getId()%>" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" disabled="disabled"/>
			</td>
			<td width="10%">
			<input type="text" size="10" value=" " name="lpQty"  id="lpQty<%=i%>"  disabled="disabled"/>
			</td><%}
			}else{%>
			<td width="6%">
			<input type="checkbox" size="10" value="<%=prescriptionDetails.getItem().getId()%>" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" /></td>
			<td width="10%">
			<input type="text" size="10" value=" " name="lpQty"  id="lpQty<%=i%>" />
			<input type="hidden" name="lpId" id="lpId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			
			</td>
			<%}}else{
			

				if(j>0){
			if(qtyPending == 0){%>
			<td width="10%">
				<input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" disabled="disabled"/>
			</td>
			<td width="10%">
				<input type="hidden" size="10" value="" name="lotQty"  id="lotQty<%=i%>"  disabled="disabled"/>
			</td>
			<%}else{%>
				<td width="10%">
				<input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" />
			</td>
			<td width="10%">
				<input type="hidden" size="10" value="" name="lotQty"  id="lotQty<%=i%>"  />
			</td>
			<%}
			}else{%>
			<td width="10%">
			
				<input type="hidden" value="<%=prescriptionDetails.getItem().getId()%>" name="lotOut"  id="lo<%=i%>" disabled="disabled"/>
			</td>
			<td width="10%">
				<input type="hidden" size="10" value="" name="lotQty"  id="lotQty<%=i%>" disabled="disabled" />
			</td>
			<%}%>
				<%if(prescriptionDetails.getSoItem()!=null){
				if(prescriptionDetails.getSoItem().equals("n")){%>
				<td width="6%">
				<input type="hidden" size="10" value="<%=prescriptionDetails.getItem().getId()%>" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" disabled="disabled"/>
				</td>
				<td width="10%">
				<input type="hidden" size="10" value=" " name="lpQty"  id="lpQty<%=i%>"  disabled="disabled"/>
				</td><%}
				}else{%>
				<td width="6%">
				<input type="hidden" size="10" value="<%=prescriptionDetails.getItem().getId()%>" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')" /></td>
				<td width="10%">
				<input type="hidden" size="10" value=" " name="lpQty"  id="lpQty<%=i%>" />
				<input type="hidden" name="lpId" id="lpId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
				
				</td>
				<%}
			
			%>
			<%}%>
			<input type="hidden" name="qtyPending" id="qtyPending<%=i %>"	value="<%=qtyPending %>" />
		
		</tr>
		<%i++;
		}%>
		<tr>
		<td>
		<input type="hidden" name="listsize" id="listsize"	value="<%=presList.size()%>" />
		</td>
		</tr>
		</tbody>

		</table>
		</div>
	<%}else{%>
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowPrescription();" align="right" />
	 <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowPrescription();" value=" "	align="right" />
	
	<!--<input type="button" tabindex="1" class="ButtonDel"	style="margin-left: 10px;" alt="Delete" value=" "
	onclick="removeRowPrescription();" align="right" />
	 <input type="button" tabindex="1" class="ButtonAdd" alt="Add" onclick="generateRowPrescription();" value=" "	align="right" />
	 --><!--
	 <input type="button" tabindex="1" class="ButtonDel"	style="margin-left: 10px;" alt="Delete" value=" "
	 onclick="removeRow();" align="right" />
	 <input type="button" tabindex="1" class="ButtonAdd" alt="Add" onclick="generateRow();" value=" "	align="right" />
     --><div class="Clear"></div>
	<div id="prescriptionDiv">
	<div class="Clear"></div>
	<div  class="cmntable">
	<table width="100%" colspan="7" id="issueGrid" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
		    <th width="5%">SR No.</th>
			<!-- <td width="10%"><label valign="left" class="smalllabel">Lot Number</label>      </td>  -->
			<th width="8%">PVMS No.</th>
			<th width="12%">Nomenclature</th>
			<th width="10%">Strength</th>
			<th width="10%">Frequency</th>
			<th width="5%">No. of Days</th>
			<th width="5%">Intake</th>
			<th width="5%">Quantity Prescribed</th>
			<th width="10%">Quantity Issued</th>
	</tr>
	</thead>
	<tbody>
	<%--
    	<%int detailCounter=8;
    	int temp=0;

    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=8;inc++){

     %>--%>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>"  /></td>
			<!-- <td width="5%"><input type="text" size="2"	value="" class="smcaption" name="lotNo<%=i %>" id="lotNo<%=i %>"  onblur="if(validateConsultant(opdPatient,<%=i %>)){fillValuesForLotNo(this.value,<%=i%>,<%=deptId %>,opdPatient);}"  /></td> -->
			<td width="8%"><input type="text" size="10" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId<%=i%>" id="itemId<%=i %>"	value="" /></td>
			<td width="12%"><input type="text" size="50" value="" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"	onblur="if(validateConsultant(opdPatientGridWithoutBarCode,<%=i %>)){checkForNomenclature(this.value, '<%=i %>','<%=deptId %>','');}" />
			<div id="ac2update"	style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=i%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=i%>'});
			</script></td>
            
            <td width="10%"><input type="text" size="10" value="" name="strength"  id="strength<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="" name="frequencyName"  id="frequencyName<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="" />
			</td>
			<td width="10%"><input type="text" size="10" value="" name="noOfDays"  id="noOfDays<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="" />
			</td>
			<td width="10%"><input type="text" size="10" value="" name="intake"  id="intake<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="" name="qtyPrescription"  id="qtyPrescription<%=i%>" />
			</td>
			<td width="10%"><input type="text"  size="10" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" value="" />
	    	<input type="hidden"  size="10" name="qtyPending<%=i%>" id="qtyPending<%=i%>" value="" />
			</tr>
	</tbody>
</table>
		<%
     //	}
	}
     %>

</div>
</div>
<input type="hidden" value="<%=i %>" name="hdb" id="hdb">
<input type="hidden" name="presHdId" id="presHdId" value="<%=presHdId %>"/>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<!--<input type="button" class="button" value="Next" onclick="submitForm('opdPatient','stores?method=showOPDPatientIssue&buttonFlag=next&hinId=<%=hinId%>&issueNo=<%=opdIssuenoIncremented %>&hinNo=<%=hinNo%>','checkTargetForNo');" align="right" />
-->
<input type="button" name="reset"	value="Next Prescription" class="buttonBig" onclick="submitForm('opdPatientGridWithoutBarCode','stores?method=showNextOPDPatientIssueWithoutBarCode')" />
<%if(depId!=24){ %><input type="button" class="button" value="Send for Lp" onclick="if(checkSendForLP()){submitForm('opdPatientGridWithoutBarCode','stores?method=submitDispensaryForLpWithBarCode');}"	align="right" />
<%}%>
<input type="button" name="add"	id="addbutton" value="Print" class="button"	onClick="submitForm('opdPatientGridWithoutBarCode','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" />
<input type="button" name="add"	id="addbutton" value="Print Previous Pres" class="buttonBig"	onClick="submitForm('opdPatientGridWithoutBarCode','stores?method=printPatientIssue','checkTargetForYes');" accesskey="g" />

<input type="hidden" class="button" value="Delete"	onclick="openPopupForDelete('<%=opdIssuenoIncremented%>');"	align="right" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>
<input type="hidden" name="changeBy" id="changeBy" value="<%=userName %>"/>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<input type="hidden" name="changeDate" id="changeDate" value="<%=date %>"/>
<label>Changed Time:</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>
</div>
</div>
</form>


<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>


<input type="hidden" name="rows" id="rr" value="1" />














