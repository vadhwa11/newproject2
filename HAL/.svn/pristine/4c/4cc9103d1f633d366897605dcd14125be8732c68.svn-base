<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.StoreAmcM"%>
<%@page import="jkt.hms.masters.business.StoreAmcT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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
	String sDate=date+"/"+month1+"/"+year1;
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<script language="javascript">

 function submitform1(){
                
 
          	     submitForm('amcMaintenance','/hms/hms/neStores?method=addOrUpdateAmcMaintenance&buttonType=add');
    	    
     }

</script>

<%!
    String supplyOrderNo,crvNo="";

    int id=0;
    int amcid=0;
    int ctr=0;
	String  supptEndDate= null;
	String firstAmcStartDate,dateofInstallation, warrantyStartDate ,warrantyEndDate,supportStartDate,supportEndDate=""; 
	BigDecimal totalRecievedQty = null;
	BigDecimal costOfEquipment = null;
	String supplierCode[] = null;
	BigDecimal costofAmc[]= null;
	String advBillNo[]=null;
	BigDecimal advBillAmt[] =null;
	String balBillNo[] = null;
	BigDecimal balBillAmt[] = null;
	String remarks[]= null;
	String amcDtFrom[]= null;
    String amcDtTo[]= null;
	String advBlDate[]= null;
	String balBlDate[]= null;
	String fASDate=null;
	String dofInstallation=null; 
	String warantStartDate=null;
	String warantEndDate=null;
	String supptStartDate=null;
    String entryNo= null;
 %>
<%
    Map<String,Object> map = new HashMap<String,Object>();
  	StoreAmcM storeAmcM = null; 
	StoreGrnT storeGrnT =null;
	StoreAmcT storeAmcT = null;
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StoreAmcT> amcTDetailsList = new ArrayList<StoreAmcT>();
	List entryNoList= new ArrayList();
    if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
    if(map.get("suppList")!=null)
	supplierList = (List)map.get("suppList");
		
    if(map.get("StoreGrnT")!=null){
    	storeGrnT = (StoreGrnT) map.get("StoreGrnT");
    }	
    if(map.get("storeAmcM")!=null){
    storeAmcM=(StoreAmcM)map.get("storeAmcM");
	
    }
   	
    if (storeAmcM != null){
    amcid = storeAmcM.getId();
	totalRecievedQty=storeAmcM.getTotReceivedQty();
	entryNo= storeAmcM.getEntryNo();
	fASDate = storeAmcM.getFirstAmcStartDate().toString();
	System.out.println("date in jsp"+fASDate);
	if (fASDate != null && !fASDate.equalsIgnoreCase(null)) {
	firstAmcStartDate = fASDate.substring(8) + "/" +fASDate.substring(5, 7) + "/" + fASDate.substring(0, 4);
	}else{
		firstAmcStartDate="";
	}
	System.out.println("date>>> in jsp"+firstAmcStartDate);
	supplyOrderNo=storeAmcM.getSupplyOrderNo();
	crvNo=storeAmcM.getCrvNo();
	
	costOfEquipment=storeAmcM.getCostOfEquipment();
	
	

	dofInstallation = storeAmcM.getDateOfInstallation().toString();
	if (dofInstallation != null) {
	dateofInstallation = dofInstallation.substring(8) + "/" +dofInstallation.substring(5, 7) + "/" + dofInstallation.substring(0, 4);
	}else{
		dateofInstallation="";
	}
	warantStartDate = storeAmcM.getWarrantyStartDate().toString();
	if (warantStartDate != null) {
	warrantyStartDate = warantStartDate.substring(8) + "/" +warantStartDate.substring(5, 7) + "/" + warantStartDate.substring(0, 4);
	}else{
		warrantyStartDate="";
	}
	
	warantEndDate=storeAmcM.getWarrantyEndDate().toString();
	if (warantEndDate != null) {
		
		warrantyEndDate = warantEndDate.substring(8) + "/" +warantEndDate.substring(5, 7) + "/" + warantEndDate.substring(0, 4);
	}
	else{
		warrantyEndDate="";
	}
		
	supptStartDate=storeAmcM.getSupportStartDate().toString();
	if (supptStartDate != null) {
		supportStartDate = supptStartDate.substring(8) + "/" +supptStartDate.substring(5, 7) + "/" + supptStartDate.substring(0, 4);
	}else{
		supportStartDate="";
	}
	
	supptEndDate=storeAmcM.getSupportEndDate().toString();
	if (supptEndDate != null) {
		supportEndDate = supptEndDate.substring(8) + "/" +supptEndDate.substring(5, 7) + "/" + supptEndDate.substring(0, 4);
		
	}else{
		supportEndDate="";
	}
   	}
    
	else {
	if (storeGrnT != null){
		System.out.println("hi i am in grn T in jsp");
		totalRecievedQty=storeGrnT.getReceivedQty();
		firstAmcStartDate=""+storeGrnT.getAmcStartDate();
		System.out.println("date in jsp"+firstAmcStartDate);
		supplyOrderNo=""+storeGrnT.getGrnMaster().getAtSoNo();
		crvNo=""+storeGrnT.getGrnMaster().getGrnNo();
		costOfEquipment=storeGrnT.getAmountValue();
		dateofInstallation=""+storeGrnT.getInstallationDate();
		warrantyStartDate=""+storeGrnT.getWarrantyDate();
		warrantyEndDate=""+storeGrnT.getWarrantyDate();
		supportStartDate=""+storeGrnT.getInstallationDate();
		supportEndDate=""+storeGrnT.getWarrantyDate();
		}
  
	if(map.get("entryNoList")!=null){
		entryNoList = (List)map.get("entryNoList");
		if(entryNoList!=null){
  	  	 if (entryNoList.size()>0 && !entryNoList.isEmpty()){
  	  		entryNo=(String)entryNoList.get(0);
  	  }

	}     
    }
	} 
    
	if(map.get("amcTDetailsList")!=null)
	amcTDetailsList=(List)map.get("amcTDetailsList");
	int amcTDetailsListSize = amcTDetailsList.size();	
	int ctr= amcTDetailsListSize;
	Integer id[] = new Integer[amcTDetailsListSize];
	String supplierCode[] = new String[amcTDetailsListSize];
	String amcDateFrom[]=new String[amcTDetailsListSize];
	String amcDateTo[]=new String[amcTDetailsListSize];
	BigDecimal costofAmc[]= new BigDecimal[amcTDetailsListSize];
	String advBillNo[]= new  String[amcTDetailsListSize];
	String advBillDate[]=new String[amcTDetailsListSize];
	BigDecimal advBillAmt[] = new BigDecimal[amcTDetailsListSize];
	String balBillNo[] = new String[amcTDetailsListSize];
	String balBillDate[]= new String[amcTDetailsListSize];
	BigDecimal balBillAmt[] = new BigDecimal[amcTDetailsListSize];
	String remarks[]= new  String[amcTDetailsListSize];
	String amcDtFrom[]= new String[amcTDetailsListSize];
	String amcDtTo[]= new String[amcTDetailsListSize];
	String advBlDate[]= new String[amcTDetailsListSize];
	String balBlDate[]= new String[amcTDetailsListSize];
	
	for(int i=0; i<amcTDetailsList.size();i++ ){
	if (amcTDetailsList != null && !amcTDetailsList.isEmpty()){
	storeAmcT = (StoreAmcT) amcTDetailsList.get(i);
	id[i] = storeAmcT.getId();
	supplierCode[i]= storeAmcT.getAmcCompany().getSupplierCode();
	System.out.println("supplierCode"+supplierCode[i]);
	amcDateFrom[i] =  storeAmcT.getAmcStartDate().toString();
	amcDtFrom[i] = amcDateFrom[i].substring(8) + "/" +amcDateFrom[i].substring(5, 7) + "/" + amcDateFrom[i].substring(0, 4);
	amcDateTo[i] = storeAmcT.getAmcEndDate().toString();
	amcDtTo[i] = amcDateTo[i].substring(8) + "/" +amcDateTo[i].substring(5, 7) + "/" + amcDateTo[i].substring(0, 4);
	costofAmc[i] = storeAmcT.getCostOfAmc();
	advBillNo[i] = storeAmcT.getAdvBillNo();
	advBillDate[i] = storeAmcT.getAdvBillDate().toString();
	advBlDate[i] = advBillDate[i].substring(8) + "/" +advBillDate[i].substring(5, 7) + "/" + advBillDate[i].substring(0, 4);
	advBillNo[i] = storeAmcT.getAdvBillNo();
	advBillAmt[i] = storeAmcT.getAdvBillAmount();
	balBillNo[i]= storeAmcT.getBalanceBillNo();
	balBillDate[i]= storeAmcT.getBalanceBillDate().toString();
	balBlDate[i] = balBillDate[i].substring(8) + "/" +balBillDate[i].substring(5, 7) + "/" + balBillDate[i].substring(0, 4);
	balBillAmt[i]= storeAmcT.getBalanceBillAmount();
	remarks[i]= storeAmcT.getRemarks();
		
	}		
	}
	
%>


<div id=amcserialDetailDiv>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="10%"><input type="hidden" name="amcid"
			value="<%=amcid%>" /> <label class="bodytextBNoWidth2">Doc
		Entry No.</label></td>
		<td width="16%"><input type="text"
			name="<%=RequestConstants.DOC_ENTRY_NO%>" maxlength=10
			value="<%=entryNo%>" class="textbox_size20" readonly /></td>
		<td width="9%"><label class="bodytextBNoWidth2">First AMC
		Start Date :</label></td>
		<td width="17%"><input type="text"
			name=<%=RequestConstants.FIRST_AMC_START_DATE%>
			value="<%=firstAmcStartDate%>" class="textbox_size20" readonly /></td>
		<td width="10%"><label class="bodytextBNoWidth2">CRV No :</label>
		</td>
		<td width="38%"><input type="text" name=<%=RequestConstants.CRV%>
			value="<%=crvNo %>" class="textbox_size20" readonly /></td>
	</tr>
	<tr>
		<td height="15"></td>
		<td height="15"></td>
		<td height="15"></td>
		<td height="15"></td>
		<td height="15"></td>
		<td height="15"></td>
	</tr>
	<tr>
		<td><label class="bodytextBNoWidth2">Entry Date :</label></td>
		<td><input type="text" name=<%=RequestConstants.ENTRY_DATE%>
			class="textbox_size20" value="<%=sDate%>" readonly /></td>
		<td><label class="bodytextBNoWidth2">Supply Order No :</label></td>
		<td><input type="text" name=<%=RequestConstants.SUPPLY_ORDER_NO%>
			class="textbox_size20" value="<%=supplyOrderNo %>" readonly /></td>
		<td><label class="bodytextBNoWidth2">Total Recieved Qty :</label></td>
		<td><input type="text"
			name="<%=RequestConstants.TOTAL_QUANTITY_RECIEVED%>" maxlength="9"
			value="<%=totalRecievedQty %>" class="textbox_size20"
			readonly="readonly" /></td>

	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><label class="bodytextBNoWidth2">Cost of Equipment :</label>
		</td>
		<td><input type="text" name=<%=RequestConstants.COST%>
			class="textbox_size20" value="<%=costOfEquipment%>" readonly /></td>
		<td><label class="bodytextBNoWidth2">Warranty Start Date
		:</label></td>
		<td><input type="text" name=<%=RequestConstants.WARRANTY_DATE%>
			class="textbox_size20" value="<%=warrantyStartDate %>" readonly /></td>
		<td><label class=bodytextBNoWidth2>Warranty End Date :</label></td>
		<td><input type="text"
			name=<%=RequestConstants.WARRANTY_END_DATE%> class="textbox_size20"
			value="<%=warrantyEndDate %>" readonly /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><label class="bodytextBNoWidth2">Support Start Date :</label>
		</td>
		<td><input type="text"
			name=<%=RequestConstants.SUPPORT_START_DATE%> class="textbox_size20"
			value="<%=supportStartDate %>" readonly /></td>
		<td><label class="bodytextBNoWidth2">Support End Date :</label></td>
		<td><input type="text"
			name=<%=RequestConstants.SUPPORT_END_DATE%> class="textbox_size20"
			value="<%=supportEndDate %>" readonly /></td>
		<td><label class="bodytextBNoWidth2">Date of Installation
		:</label></td>
		<td><input type="text"
			name=<%=RequestConstants.INSTALLATION_DATE%> class="textbox_size20"
			value="<%=dateofInstallation %>" readonly /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><input type="button" class="addbutton" value=""
			onclick="generateRowWithoutSrNo('amcDetailId');" align="right" /></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="6">
		<div style="float: left; overflow: auto; width: 960px;">
		<table width="100%" colspan="7" id="amcDetailId" class="grid_header"
			border="1" cellpadding="0" cellspacing="0">

			<thead>
				<tr>
					<td width="10%"><label valign="left" class="smalllabel">AMC
					Company</label></td>
					<td width="10%"><label valign="left" class="smalllabel">AMC
					Date from</label></td>
					<td width="10%"><label valign="left" class="smalllabel">AMC
					Date to</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Cost
					of AMC</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Adv.Bill
					No</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Adv.Bill
					Date</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Adv.Bill
					Amt</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Bal.No.</label>
					</td>
					<td width="10%"><label valign="left" class="smalllabel">Bal.Bill
					Date</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Bal.Bill
					Amt</label></td>
					<td width="10%"><label valign="left" class="smalllabel">Remarks</label>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<% 	
  		        int   i=0;
  		
  		        if(amcTDetailsList.size()>0 && !amcTDetailsList.isEmpty()){
  			    for (int j=0; j<amcTDetailsList.size();j++ ) {
		  	 %>

					<td width="10%"><select
						name="<%=RequestConstants.AMC_CONTRACT%>" id="amcContract">
						<option value="0">Select</option>
						<%
			  	for (MasStoreSupplier masStoreSupplier:supplierList  ) {
		  	 %>
						<option value="<%=masStoreSupplier.getSupplierCode()%>"><%=masStoreSupplier.getSupplierName()%></option>
						<% } %>
					</select> <script>
		   	  	   document.amcMaintenance.<%=RequestConstants.AMC_CONTRACT%>.value =<%=supplierCode[j]%>
    			</script></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.AMC_START_DATE%>"
						value="<%=amcDtFrom[j]%>" class="medcaption"
						validate="AMC Start Date,date,yes" /></td>
					<td width="10%"><input type="hidden" name="srNO" /> <input
						type="text" name="<%=RequestConstants.AMC_END_DATE %>"
						value="<%=amcDtTo[j]%>" class="medcaption"
						validate="AMC END DATE,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.COST_OF_AMC %>"
						value="<%=costofAmc[j]%>" class="smcaption"
						validate="Cost of AMC,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_NO %>"
						value=" <%=advBillNo[j]%>" class="medcaption"
						validate="Addvance BillNo,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_DATE%>"
						value="<%=advBlDate[j]%>" class="medcaption"
						validate="Addvance BillDate,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_AMOUNT%>"
						value="<%=advBillAmt[j]%>" class="medcaption"
						validate="Addvance BillAmt,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_NO %>" value="<%=balBillNo[j]%>"
						class="medcaption" validate="Balance BillNo,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_BILL_DATE %>"
						value="<%=balBlDate[j]%>" class="medcaption"
						validate="Balance BillDate,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_AMOUNT %>"
						value="<%=balBillAmt[j]%>" class="medcaption"
						validate="Balance BillAmt,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.REMARKS %>" value="<%=remarks[j]%>"
						class="medcaption" validate="Remarks,string,yes" /></td>
				</tr>


				<% 
  		   i++;
  	     	   }
  		    }else{
  		   %>
				<tr>

					<td width="10%"><select
						name="<%=RequestConstants.AMC_CONTRACT%>">
						<option value="0">Select</option>
						<%
			  	for (MasStoreSupplier masStoreSupplier:supplierList  ) {
		  	 %>
						<option value="<%=masStoreSupplier.getSupplierCode()%>"><%=masStoreSupplier.getSupplierName()%></option>
						<% } %>
					</select></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.AMC_START_DATE%>" value=""
						class="medcaption" validate="AMC Start Date,date,yes" /></td>
					<td width="10%"><input type="hidden" name="srNO" /> <input
						type="text" name="<%=RequestConstants.AMC_END_DATE %>" value=""
						class="medcaption" validate="AMC End Date,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.COST_OF_AMC %>" value=""
						class="smcaption" validate="Cost Of AMC,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_NO %>" value=""
						class="medcaption" validate="Addvance Bill No,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_DATE%>" value=""
						class="medcaption" validate="Addvance Bill Date,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.ADDVANCE_BILL_AMOUNT%>" value=""
						class="medcaption" validate="Addvance Bill Amt,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_NO %>" value=""
						class="medcaption" validate="Balance Bill No,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_BILL_DATE %>" value=""
						class="medcaption" validate="Balance Bill Date,date,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.BALANCE_AMOUNT %>" value=""
						class="medcaption" validate="Bal BillAmt,num,yes" /></td>
					<td width="10%"><input type="text"
						name="<%=RequestConstants.REMARKS %>" value="" class="medcaption"
						validate="Remarks,string,yes" /></td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<input type="hidden" name="amcTDetailListSize"
			id="amcTDetailsListSize" value="1" /></div>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>