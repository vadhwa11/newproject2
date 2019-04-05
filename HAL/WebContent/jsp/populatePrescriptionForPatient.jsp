
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%
		int pageNo=1;
		int hinId=0;
		Map map = new HashMap();
		List<PatientPrescriptionDetails> prescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();
		List<StoreItemBatchStock> listOfItemsStock = new ArrayList<StoreItemBatchStock>();
		int deptId=0;
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("deptId") != null) {
			deptId = Integer.parseInt(""+map.get("deptId"));

		}
		if (map.get("prescriptionDetailsList") != null)
		{
			prescriptionDetailsList =(List<PatientPrescriptionDetails>)map.get("prescriptionDetailsList");
		}
		if(map.get("pageNo") != null)
		{
			pageNo=(Integer)map.get("pageNo");
			
			
		}	
		if (map.get("listOfItemsStock") != null)
		{	
	      listOfItemsStock =(List<StoreItemBatchStock>)map.get("listOfItemsStock");
		}
		
		
%>
<input type="hidden" name="pageNo" value="<%=pageNo %>" />

<div id="prescriptionDiv">
<div  class="cmntable">
	<table width="100%" colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
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
			<!--<th width="16%">Quantity Pending</th>
			--><th width="15%">Stock Available</th>
			<th width="10%">Issue</th>
			<th width="5%">Send For LP</th>
		</tr>
	</thead>
	<tbody>
	<%
	    int i=1;
	    int presHdId = 0;
    	if(prescriptionDetailsList.size() > 0){
		for(PatientPrescriptionDetails prescriptionDetails : prescriptionDetailsList){
		int qtyIssued = 0;
		if(prescriptionDetails.getQtyIssued() != null){
			qtyIssued = prescriptionDetails.getQtyIssued();
		}
		presHdId = prescriptionDetails.getPrescription().getId();

		int qtyPending =0;int totalQty=0;
		
		Iterator itr= listOfItemsStock.iterator();
			
			while(itr.hasNext())
			{
				 Object[] pair = (Object[]) itr.next();
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         	   totalQty=Integer.parseInt(pair[1].toString());
	         	 }
			} 	 
		//BigDecimal stockAvailable = new BigDecimal(0);
		/*Integer stockAvailable=new Integer(0);
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
		qtyPending =prescriptionDetails.getTotal() -  qtyIssued;
	%>
	<tr>
			<td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionId" readonly="readonly" />
			</td>
			<td width="8%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>
			<td width="12%"><input type="text" size="50" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" size="10" name="qtyPrescribed" id="qtyPrescribed<%=i%>" value="0" onblur="calculatePendingQty(this.value,<%=i %>);"/>
			<input type="hidden" size="10" name="qtyPrescribedHide" id="qtyPrescribedHide<%=i%>" value="<%=prescriptionDetails.getTotal() %>"/>
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getStrength() %>" name="strength" readonly="readonly" id="strength<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getFrequency().getFrequencyName() %>" name="frequencyName" readonly="readonly" id="frequencyName<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getNoOfDays() %>" name="noOfDays" readonly="readonly" id="noOfDays<%=i%>" />
			<input type="hidden" name="frequencyId" id="frequencyId<%=i %>"	value="<%=prescriptionDetails.getFrequency().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getInstruction() %>" name="intake" readonly="readonly" id="intake<%=i%>" />
			</td>
			<td width="10%"><input type="text" size="10" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription" readonly="readonly" id="qtyPrescription<%=i%>" />
			</td>
			<td width="10%"><input type="text"  size="10" name="qtyIssued<%=i%>" id="qtyIssued<%=i%>" value="<%= qtyIssued%>" readonly />
		<input type="hidden"  size="10" name="qtyPending<%=i%>" id="qtyPending<%=i%>" value="0" readonly /></td>
		<td width="16%"><input type="text" size="10" name="stockAvailable"<%=i%> id="stockAvailable<%=i%>" value="<%=totalQty %>" readonly /></td>

		<td>
		<%
			
		if(qtyPending == 0)
			{
			
		%>
		<input type="button" id="issue<%=i%>" name="issue" value="Issue" class="button" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')" disabled="disabled"/>
		<%}else{
			%>
		<input type="button" id="issue<%=i%>" name="issue" value="Issue" class="button" onclick="fillItemsInGrid();openPopup('<%=prescriptionDetails.getItem().getId() %>','<%=deptId %>','<%=i %>')"/>

		<%} %>
		</td>
		<td width="6%"><input type="checkbox" size="10" value="n" name="lp" id="lp<%=i%>" onclick="changeCheckBoxValue('<%=i %>')"/>
			<input type="hidden" name="lpId" id="lpId<%=i %>"	value="n" />
			<input type="hidden" name="qtyPending" id="qtyPending<%=i %>"	value="<%=qtyPending %>" />
			
			</td>
		</tr>
		<%i++;
		}
		
		}%>
		</tbody><input type="hidden" name="listsize" id="listsize"	value="<%=prescriptionDetailsList.size() %>" />
		</table>
		</div>
		</div>
		<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	
<input type="hidden" name="rows" id="rr" value="1" />

