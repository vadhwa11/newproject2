<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.StoreProformaHeader"%>
<%@page import="jkt.hms.masters.business.StoreProformaDetail"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<!--
Code for Logout after session Expired
Code By Mukesh Narayan Singh
Date 19 Aug 2010
 -->

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
function disableKey(event){

  if (!event) event = window.event;

  if (!event) return;


  var keyCode = event.keyCode ? event.keyCode : event.charCode;


  //window.status = keyCode;

  // keyCode for F% on Opera is 57349 ?!



  if (keyCode == 116) {

   window.status = "F5 key detected! Attempting to disabling default response.";

   window.setTimeout("window.status='';", 2000);

   // Standard DOM (Mozilla):

   if (event.preventDefault) event.preventDefault();

   //IE (exclude Opera with !event.preventDefault):

   if (document.all && window.event && !event.preventDefault) {

     event.cancelBubble = true;

     event.returnValue = false;

     event.keyCode = 0;

   }

   return false;

  }

}



document.onkeydown = disableKey; // register listener function

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
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;

	Box box = HMSUtil.getBox(request);



	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}

  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;

	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	
	List stockList=new ArrayList();
	if (map.get("stockList")!=null)
	{
		stockList = (List)map.get("stockList");
	}
	List<StoreProformaHeader> storeProformaHeaderList=new ArrayList<StoreProformaHeader>();
	if (map.get("storeProformaHeaderList")!=null)
	{
		storeProformaHeaderList =(List<StoreProformaHeader>) map.get("storeProformaHeaderList");
	}

	List<StoreProformaDetail> storeProformaDetailList = new ArrayList<StoreProformaDetail>();
	if (map.get("storeProformaDetailList")!=null)
	{
		storeProformaDetailList =(List<StoreProformaDetail>) map.get("storeProformaDetailList");
	}
	
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	if (map.get("patientPrescriptionHeaderList")!=null)
	{
		patientPrescriptionHeaderList =(List<PatientPrescriptionHeader>) map.get("patientPrescriptionHeaderList");
	}
	List<PatientPrescriptionDetails> patientPrescriptiondetailList = new ArrayList<PatientPrescriptionDetails>();
	if (map.get("patientPrescriptiondetailList")!=null)
	{
		patientPrescriptiondetailList =(List<PatientPrescriptionDetails>) map.get("patientPrescriptiondetailList");
	}
	int pageNo=1;
	if(map.get("pageNo")!=null){
		pageNo=(Integer)map.get("pageNo");
	}



%>

<script>



function getOtherItemsForDepartmentIndent(val)
{
     //alert("get other")
	 indentForm.method="post";
	 var counterValue=document.getElementById("counterValue").value

	 var nomenclature=document.getElementById("nomenclature"+val).value;
	 //alert("val"+val);
	 //for(var i=parseInt(counterValue)+1;i<(parseInt(counterValue)+14);i++){  // comment by javed khan
	for(var i=parseInt(counterValue);i<(parseInt(counterValue)+14);i++){
	 if(document.getElementById("nomenclature"+i)!=null){
		
	 if(document.getElementById("nomenclature"+i).value==nomenclature && i!=val){

	 alert("Item is already Selected");
	 document.getElementById("nomenclature"+val).value="";
	 return false;
	 }
	 }
	 }

	   var index1 = nomenclature.lastIndexOf("[");
	        index1++;

	      var index2 = nomenclature.lastIndexOf("]");
	       var pvmsNo = nomenclature.substring(index1,index2);
	    
	   var fromWard=document.indentForm.<%= FROM_WARD%>.value;
	  var toWard=document.indentForm.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
		   // alert("pvmsNo");
	ajaxFunctionForGetOtherItemsForDepartmentIndent('indentForm','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=FROM_WARD%>='+fromWard+'&<%=TO_WARD%>='+toWard+''   , val);

	}}



// add javed khan 

function getOtherItemsForDepartmentIndent1(val)
{
	 indentForm.method="post";
	 var counterValue=document.getElementById("counterValue").value

	 var pvms=document.getElementById("pvms"+val).value;
	 for(var i=parseInt(counterValue);i<(parseInt(counterValue)+14);i++){
	
	 if(document.getElementById("pvms"+i)!=null){
		
	 if(document.getElementById("pvms"+i).value==pvms && i!=val){
		
	 alert("PVMS/NIV No. is already Selected");
	 document.getElementById("pvms"+val).value="";
	 return false;
	 }
	 }
	 }

	 var pvmsNo=document.getElementById("pvms"+val).value;
	    
	   var fromWard=document.indentForm.<%= FROM_WARD%>.value;
	  var toWard=document.indentForm.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
		  
	ajaxFunctionForGetOtherItemsForDepartmentIndent('indentForm','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=FROM_WARD%>='+fromWard+'&<%=TO_WARD%>='+toWard+''   , val);

	}}



function validateButton()
{
	if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < document.indentForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (document.indentForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	alert("Pls Fill Atleast One Row..")
	return false;
}



function Func1Delay()
{
setTimeout("jsClose()", 3000);
}

function jsClose()
{
//var demandNo=indentForm.<%=DEMAND_NO%>.value

//window.opener.location.href = "stores?method=getDepartmentIndentData&<%=FROM_WARD%>="+indentForm.<%=FROM_WARD%>.value+"&<%=DEMAND_NO%>="+internalIndentId+"&status1="+status1;
if (window.opener.progressWindow)
{
window.opener.progressWindow.close()
}
window.close();
}

</script>
<div class="titleBg">
<h2>Proforma B </h2>
</div>
<div class="clear"></div>
<form name="proformaForm">
<input type="hidden" name="numOfRows"	size="5" value="15">
<input type="hidden" name="pageCount"	size="5" value="10">
<input type="hidden" name="search" size="5"	value="true">
<input	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<h4>Proforma B Details</h4>

<div class="clear"></div>
<div class="Block">
	<label>Proforma SI No.<span>*</span></label>
	<input type="text" name="proformaSINo" id="pro_si_no" value="<%=storeProformaDetailList.get(0).getPo().getProformaNo() %>"/>
	<label>Proforma Date<span>*</span></label>
	<input type="text" name="proformaDate"  value="<%=HMSUtil.changeDateToddMMyyyy(storeProformaDetailList.get(0).getPo().getProformaDate()) %>" MAXLENGTH="30" class="date" id="pro_date" tabindex=1 /> 
	
	<div class="clear"></div>
	<label>Invoice No.<span>*</span></label> 
	<input type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>" value="<%=storeProformaDetailList.get(0).getPo().getInvoiceNo()!=null?storeProformaDetailList.get(0).getPo().getInvoiceNo():""%>" validate="Invoice No, String, no" maxlength="30" tabindex=1 /> 
 	<label>Invoice Date<span>*</span></label> 
 	<input type="text" class="date" name="<%=INVOICE_DATE%>" readonly
	id="invoiceDate" value="<%=HMSUtil.changeDateToddMMyyyy(storeProformaDetailList.get(0).getPo().getInvoiceDate()) %>" maxlength="30" tabindex=1 />

	</div>
	<div class="Clear"></div>
	<div class="Clear"></div>
	<div class="Clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
<!-- <div class="Cmntable"> -->
<% if (storeProformaDetailList.size()>0){ int count=0; %>
<div STYLE=" height:300px; width: 989px; font-size: 12px; overflow: auto;">
<!-- <table width="100%" colspan="7" border="00" cellpadding="0"	cellspacing="0"> -->
<table id="main">
	<tr>
			<th width="5%">Sl No.</th>
			<th width="8%">PVMS/NIV No.</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="15%">B/G </th>
			<th width="9%">Qty</th>
			<th width="9%">Rate</th>
			<th width="30%">Particular of the Patients</th>
		 <th width="7%">Dosage</th>
			<th width="9%">Diagnosis</th>
			<th width="22%">Prescribed By</th>
			<!--<th width="9%">Indent No Marked</th>-->
	</tr>

	<% for (StoreProformaDetail storeProformaDetail : storeProformaDetailList){ %>
	<tr>


		<td><input type="text" tabindex="1" disabled value="<%=++count%>"
			name="srno"  readonly="readonly" size="2" /></td>
			<td><input type="text" size="9" tabindex="1"  value="<%=storeProformaDetail.getItem().getPvmsNo() %>"
			name="pvms" id="pvms" /></td>
		<td><input type="text"  size="30" value="<%=storeProformaDetail.getItem().getNomenclature() %>" tabindex="1" name="nomenclature"
			id="nomenclature" /></td>

		<td><input type="text" size="10" tabindex="1"  value="<%=storeProformaDetail.getItem().getItemConversion().getIssueUnit().getUnitName() %>"
			name="au" id="au"  readonly="readonly" /></td>
			
		<td><input type="text" size="1" tabindex="1"  value="<%=(storeProformaDetail.getCategory()!=null && !(storeProformaDetail.getCategory().equals("null")))?storeProformaDetail.getCategory():"" %>"
			name="cate" id="cate" readonly="readonly" /></td>
			
		<td><input type="text" size="2" tabindex="1"  value="<%=storeProformaDetail.getQty() %>"
			name="qty" id="qty" readonly="readonly" /></td>
			
		<td><input type="text" size="6" tabindex="1"  value="<%=storeProformaDetail.getRate() %>"
			name="rate" id="rate" readonly="readonly" /></td>
			<%int bulk=0;
			for(PatientPrescriptionDetails ppd : patientPrescriptiondetailList){
				
			
				if(!storeProformaDetail.getPrescriptionId().equals("0")){
				if(Integer.parseInt(storeProformaDetail.getPrescriptionId()) ==ppd.getId()){
					String pName=ppd.getPrescription().getHin().getPFirstName();
					if(ppd.getPrescription().getHin().getPLastName() != null && !ppd.getPrescription().getHin().getPLastName().equals("")){
						pName = pName +" "+ppd.getPrescription().getHin().getPLastName();
					}
					String eName=ppd.getPrescription().getVisit().getDoctor().getRank().getRankName().concat(" ").concat(ppd.getPrescription().getVisit().getDoctor().getFirstName()).concat(ppd.getPrescription().getVisit().getDoctor().getLastName());
					if(ppd.getPrescription().getVisit().getDoctor().getLastName() != null && !ppd.getPrescription().getVisit().getDoctor().getLastName().equals("")){
						eName = eName +" "+ppd.getPrescription().getVisit().getDoctor().getLastName();
					}
					%>
			<td><input type="text" size="20" tabindex="1"  value="<%=pName %>"
			name="pName" id="pName" readonly="readonly" /></td>
			
			
			
			<td><input type="text" size="4" tabindex="1"  value="<%=ppd.getDosage() %>"
			name="dos" id="dos" readonly="readonly" /></td>
		
			
			
			
			
			<td><input type="text" size="12" tabindex="1"  value="<%=(ppd.getPrescription().getVisit().getDiagnosisName() != null ) ? ppd.getPrescription().getVisit().getDiagnosisName() : "" %>"
			name="doc" id="doc" readonly="readonly" /></td>
		
			
			
			
			<td><input type="text" size="12" tabindex="1"  value="<%=eName %>"
			name="doc" id="doc" readonly="readonly" /></td>
			<%}}else if(bulk == 0){ bulk++;%>
				
			<td colspan=5>For SMC Use Only</td>
			
			<%} }%>
		
		

		

		
	</tr>
	<%} %>
	
</table>
</div>
<%} %>
<!-- </div> -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Close"	onClick="jsClose()" value="Close" class="button" />
<!--  
<input type="button" name="next" onClick="jsNext()" value="Next"	class="button" />
<input type="button" name="previous"	onClick="jsPrevious()" value="Previous" class="button" />
<input	type="button" name="Add" onClick="jsAdd()" value="Submit"	class="button" />
<input type="button" name="Close"	onClick="jsClose()" value="Close" class="button" />
<input	type="hidden" name="counterValue" id="counterValue"	value="<%=	(pageNo-1)*14+1    %>">
-->
<div class="clear"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="pageNo" id="pageNo" value="<%= pageNo%>" /></form>
