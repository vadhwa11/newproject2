<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * amcMaintenance.jsp  
 * Purpose of the JSP -  This is for search result the AMC Maintenance
 * @author  Hitesh 
 * Create Date: 7th April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.0
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.math.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreAmcM"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.StoreAmcT"%>
<%@page import="java.util.Iterator"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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
    String entryNo="";
    if (request.getAttribute("map") != null) 
    map = (Map) request.getAttribute("map");
   	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<String> entryNoList= new ArrayList<String>();
	List<StoreAmcM> docentryList= new ArrayList<StoreAmcM>();
	List<StoreAmcT> amcTDetailsList = new ArrayList<StoreAmcT>();
	List amcMaintenanceDetails = new ArrayList();
	StoreAmcM amcMDetails=null;
	StoreAmcT amcTDetails= null;
	StoreAmcM amcM = null;
	StoreAmcT storeAmcT = null;
	if(map.get("departmentList")!=null){
	 departmentList = (List) map.get("departmentList");
    }
	if(map.get("suppList")!=null){
		supplierList = (List)map.get("suppList");
		
	}	
	
	if(map.get("docentryList")!=null){
		docentryList = (List)map.get("docentryList");
		
	}
	if(map.get("amcMaintenanceDetails")!=null){
		amcMaintenanceDetails = (List)map.get("amcMaintenanceDetails");
	     for(int i=0;i<amcMaintenanceDetails.size();i++){
	    	 amcMDetails=(StoreAmcM)amcMaintenanceDetails.get(i);
	         System.out.println("amcMDetails entry no >>"+amcMDetails.getEntryNo());   
	     }
	}
	
		
	if(map.get("amcTDetailsList")!=null)
		amcTDetailsList=(List)map.get("amcTDetailsList");
		int amcTDetailsListSize = amcTDetailsList.size();	
		System.out.println("amcTDetailsListSize>>>>>>>>>>>>in jsp>>>>>>>>>>"+amcTDetailsListSize);
		int ctr= amcTDetailsListSize;
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
		supplierCode[i]= storeAmcT.getAmcCompany().getSupplierCode();
		System.out.println("supplierCode>>>> in jsp is >>>>>>"+supplierCode[i]);
		amcDateFrom[i] =  storeAmcT.getAmcStartDate().toString();
		amcDtFrom[i] = amcDateFrom[i].substring(8) + "/" +amcDateFrom[i].substring(5, 7) + "/" + amcDateFrom[i].substring(0, 4);
		System.out.println("date amc from "+amcDtFrom[i]);
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

<script>
var nameArray=new Array();

</script>



<h2 align="left" class="style1">AMC Maintenance Entry</h2>

<div id="contentspace">
<form name="amcmaintenancesearch" method="post" action="">

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
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('amcmaintenancesearch','/hms/hms/neStores?method=addOrUpdateAmcMaintenance&buttonType=add');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('createGrn','stores?method=grnModifyJsp');"></td>
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
					value="Print"
					onClick="submitForm('createGrn','stores?method=showGrnReportJsp');">
				</td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
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
			name="searchthreadid" value="85875" /> <label class="bodytextB">Doc
		Entry No :</label> <select name="docentryno" class="bigselect">
			<option value="">Select</option>
			<%
			  	for (StoreAmcM storeAmcM :docentryList ){
			  	
		  	 %>
			<option value="<%=storeAmcM.getEntryNo()%>"><%=storeAmcM.getEntryNo()%></option>
			<% } %>
		</select> <label class="bodytextB">Department Name :</label> <select
			name="<%= RequestConstants.DEPARTMENT_ID%>" id="departmentId"
			onchange="submitProtoAjax('amcmaintenancesearch','neStores?method=getNomenclatureSearch');" />
			<option value="">Select</option>
			<%
			  	for (MasDepartment masDepartment:departmentList ) {
		  		
			 %>
			<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
			<% } %>
		</select> </br>
		<div id="testDiv"><label class="bodytextB">Nomenclature
		:</label> <select name="<%= RequestConstants.NOMENCLATURE%>" class="bigselect">
			<option value="">Select</option>
		</select></div>
		<div id="serialDiv"><label class="bodytextB">SerialNo :</label>
		<select name="<%= RequestConstants.SERIAL_NUMBER%>" class="bigselect">
			<option value="">Select</option>
		</select></div>
		<input type="button" class="smbutton" value="Go!"
			onClick="submitForm('amcmaintenancesearch','neStores?method=amcSearchResult');" />
		<br />
		</td>
	</tr>

</table>
</form>
</div>
</div>

</div>

<br />
<form name="amcMaintenance" method="post"><br />

<label class="bodytextB">Department Name :</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID%>" id="departmentId"
	onchange="submitProtoAjaxDynamic('amcMaintenance','neStores?method=getNomenclature',nomencalDiv);" />
	<option value="">Select</option>
	<%
			  	for (MasDepartment masDepartment:departmentList ) {
		  		
			 %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<% } %>
</select> <br />
<div id="nomencalDiv"><label class="bodytextB">Nomenclature
:</label> <select name="nomenclature" class="bigselect" id="nomenclature">
	<option value="">Select</option>
</select></div>



<br />
<div id="pvmsDiv"><label class="bodytextB">PVMS/NIV :</label> <input
	type="text" name=<%=RequestConstants.PVMS_NO%> class="textbox_size20"
	value="" readonly /> <label class="bodytextB">Serial No:</label> <select
	name="<%= RequestConstants.SERIAL_NUMBER%>" id="serialNo">
	<option value="0">Select</option>
</select></div>
<br />

<div id=amcserialDetailDiv><input type="hidden" name="amcid"
	value="" /> <label class="bodytextB">Doc Entry No.</label> <input
	type="text" name="<%=RequestConstants.DOC_ENTRY_NO%>" maxlength=15
	value="<%=amcMDetails.getEntryNo()%>" class="textbox_size20" readonly />

<label class="bodytextB">First AMC Start Date :</label> <input
	type="text" name=<%=RequestConstants.FIRST_AMC_START_DATE%>
	value="<%=amcMDetails.getFirstAmcStartDate()%>" class="textbox_size20"
	readonly /> <label class="bodytextB">CRV No :</label> <input
	type="text" name=<%=RequestConstants.CRV%>
	value="<%=amcMDetails.getCrvNo()%>" class="textbox_size20" readonly />

<label class="bodytextB">Entry Date :</label> <input type="text"
	name=<%=RequestConstants.ENTRY_DATE%> class="textbox_size20"
	value="<%=sDate%>" readonly /> <label class="bodytextB">Supply
Order No :</label> <input type="text" name=<%=RequestConstants.SUPPLY_ORDER_NO%>
	class="textbox_size20" value="<%=amcMDetails.getSupplyOrderNo()%>"
	readonly /> <br />


<label class="bodytextB">Cost of Equipment :</label> <input type="text"
	name=<%=RequestConstants.COST%> class="textbox_size20"
	value="<%=amcMDetails.getCostOfEquipment()%>" readonly /> <label
	class="bodytextB">Warranty Start Date :</label> <input type="text"
	name=<%=RequestConstants.WARRANTY_DATE%> class="textbox_size20"
	value="<%=amcMDetails.getWarrantyStartDate()%>" readonly /> <label
	class="bodytextB">Warranty End Date :</label> <input type="text"
	name=<%=RequestConstants.WARRANTY_END_DATE%> class="textbox_size20"
	value="<%=amcMDetails.getWarrantyEndDate() %>" readonly /> <br />

<label class="bodytextB">Support Start Date :</label> <input type="text"
	name=<%=RequestConstants.SUPPORT_START_DATE%> class="textbox_size20"
	value="<%=amcMDetails.getSupportStartDate()%>" readonly /> <label
	class="bodytextB">Support End Date :</label> <input type="text"
	name=<%=RequestConstants.SUPPORT_END_DATE%> class="textbox_size20"
	value="<%=amcMDetails.getSupportEndDate()%>" readonly /> <label
	class="bodytextB">Date of Installation :</label> <input type="text"
	name=<%=RequestConstants.INSTALLATION_DATE%> class="textbox_size20"
	value="<%=amcMDetails.getDateOfInstallation()%>" readonly /> <label
	class="bodytextB">Total Recieved Qty :</label> <input type="text"
	name="<%=RequestConstants.TOTAL_QUANTITY_RECIEVED %>" maxlength=9
	value="<%=amcMDetails.getTotReceivedQty() %>" class="textbox_size20"
	readonly="readonly"> <br />
<input type="button" class="addbutton" value=" "
	onclick="generateRowWithoutSrNo('amcDetailId');" align="right" /> <br />
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
				name="<%=RequestConstants.AMC_CONTRACT%>">
				<option value="0">Select</option>
				<%
			  	for (MasStoreSupplier masStoreSupplier:supplierList  ) {
		  	 %>
				<option value="<%=masStoreSupplier.getSupplierCode()%>"><%=masStoreSupplier.getSupplierName()%></option>
				<% } %>
			</select> <script>
		   	 	   document.amcMaintenance.<%=RequestConstants.AMC_CONTRACT%>.value ='<%=supplierCode[j]%>'
    			</script></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.AMC_START_DATE%>"
				value="<%=amcDtFrom[j]%>" class="medcaption"
				validate="AMC Start Date,date,yes" /></td>
			<td width="10%"><input type="hidden" name="srNO" /> <input
				type="text" name="<%=RequestConstants.AMC_END_DATE %>"
				value="<%=amcDtTo[j]%>" class="medcaption"
				validate="AMC End Date,date,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.COST_OF_AMC %>" value="<%=costofAmc[j]%>"
				class="smcaption" validate="Cost Of AMC,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_NO %>"
				value=" <%=advBillNo[j]%>" class="medcaption"
				validate="Addvance Bill No,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_DATE%>"
				value="<%=advBlDate[j]%>" class="medcaption"
				validate="Addvance Bill Date,date,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_AMOUNT%>"
				value="<%=advBillAmt[j]%>" class="medcaption"
				validate="Addvance Bill Amt,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_NO %>" value="<%=balBillNo[j]%>"
				class="medcaption" validate="Balance Bill No,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_BILL_DATE %>"
				value="<%=balBlDate[j]%>" class="medcaption"
				validate="Balance Bill Date,date,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_AMOUNT %>"
				value="<%=balBillAmt[j]%>" class="medcaption"
				validate="Bal BillAmt,num,yes" /></td>
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
				name="<%=RequestConstants.COST_OF_AMC %>" value="" class="smcaption"
				id="amcCost" validate="Cost Of AMC,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_NO %>" value=""
				class="medcaption" validate="Addvance Bill No,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_DATE%>" value=""
				class="medcaption" validate="Addvance Bill Date,date,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ADDVANCE_BILL_AMOUNT%>" value=""
				class="medcaption" id="advAmt" validate="Addvance Bill Amt,num,yes" />
			</td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_NO %>" value="" class="medcaption"
				validate="Balance Bill No,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_BILL_DATE %>" value=""
				class="medcaption" validate="Balance Bill Date,date,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.BALANCE_AMOUNT %>" value=""
				class="medcaption" id="balAmt" validate="Bal BillAmt,num,yes" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.REMARKS %>" value="" class="medcaption"
				validate="Remarks,string,yes" /></td>
		</tr>
		<%} %>
	</tbody>


</table>
<br />

<input type="button" class="morebutton" value="Submit!"
	onclick="submitform1();" /> <input type="hidden"
	name="amcTDetailListSize" id="amcTDetailsListSize" value="1" />
</form>
</div>


<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>