<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript"
	language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		


</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		
		String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		int deptId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("departmentList") != null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
	%>

<div class="titleBg">
<h2>Pending Supply Order</h2>
</div>
<form name="diagnosisWise" target="_blank" action="" method="post">
<div class="Block">
<label> From Date<span>*</span></label> 
<input type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>" value="" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.diagnosisWise.<%=FROM_DATE%>,event)" />

<label>To Date<span>*</span></label> 
<input type="text" class="calDate" id="toDateId" name="<%=TO_DATE %>" value="" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.diagnosisWise.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Supply Order No. From </label> 
<input type="text" id="SoNFrom" name=<%=SUPPLYNOFROM%> value="" validate="Supply Order No. From,alphanumeric1,no" class="textbox_date" MAXLENGTH="30" /> 
<label>Supply Order No. To </label> 
<input type="text" id="SoNTo" name=<%=SUPPLYNOTO%> value="" validate="Supply Order No. To,alphanumeric1,no" class="textbox_date" MAXLENGTH="30" />

<div class="clear"></div>
<label>Supplier/ Vendor</label> 
<input type="text" value="" class="auto" size="77"  id="vendorId" name="<%=TENDER_VENDOR_SUPPLIER_ID%>" />
<div id="ac2update" style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('vendorId','ac2update','tender?method=getSupplierListByAutocomplete',{parameters:'requiredField=<%=TENDER_VENDOR_SUPPLIER_ID%>'});
</script>

<div class="clear"></div>
<label>Item </label> 
<input type="text"  name="<%=NOMENCLATURE %>" value="" id="nomenclature" validate="Item Name,string,no" style="width: 477px;" readonly="readonly" tabindex=1 /> 
<input type="hidden" name="<%=ITEM_ID%>" value="" id="item" validate="Item Id,string,no"
	maxlength="30" readonly="readonly" tabindex=1 /> 
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="openPopupWindowForItems();"
	title="Click here to Search ITEM.">
<div class="clear"></div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="showReport();" /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCurrentValues();" accesskey="r" /></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<script type="text/javascript" language="javascript">
	
	
	function showReport()
 {
 	var nomenclature = document.getElementById('nomenclature').value
 	var SoNFrom = document.getElementById('SoNFrom').value
 	var SoNTo = document.getElementById('SoNTo').value
 	var vendorId = document.getElementById('vendorId').value
 	var formDate = document.getElementById('fromDateId').value
 	var toDate = document.getElementById('toDateId').value
 	if(formDate.length == 0){
 	document.getElementById('fromDateId').value = ""
 	}
 	if(toDate.length == 0){
 	document.getElementById('toDateId').value = "";
 	}
 	if(SoNFrom.length == 0){
 	 document.getElementById('SoNFrom').value = "";
 	}
 	
 	if(SoNTo.length == 0){
 	 document.getElementById('SoNTo').value = "";
 	}
 	
 	if(vendorId.length == 0){
 	 document.getElementById('vendorId').value = "";
 	}
 	
 	//submitForm('diagnosisWise','stores?method=generatePendingSupplierOrderReport','validateFromToDate');"
 	if(nomenclature.length == 0){
 	document.getElementById('item').value = "";
 	}
 	
 	 diagnosisWise.method="post";
    submitForm('diagnosisWise','stores?method=generatePendingSupplierOrderReport');
}



	function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.diagnosisWise.fromDate)
		obj2 = eval(document.diagnosisWise.toDate)
			
		if(obj1.value != "" && obj2.value != "")
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
				
			if(validFromDate<=nowDate)
				{
					if(validFromDate > validToDate)
					{
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}
				
			else
				{
				alert("From Date should not be greater than Current date\n");
				return false;
				}
		
		}
		return true;
	}
	function openPopupWindowForItems(){
	  	var url="/hms/hms/stores?method=showItemSearchJsp";
  		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetItemData(itemId,nomenclature)
	{
 		document.getElementById("itemId").value = itemId;
 		document.getElementById("nomenclature").value = nomenclature;
  	}	
	function resetCurrentValues(){
	 	document.getElementById("itemId").value = '';
	 	document.getElementById("nomenclature").value = '';
	 	document.getElementById("<%= DEPARTMENT_ID %>").value = '';

	}
	
function jsSetNomenclature(item,nomenclature)
 {
 document.getElementById('nomenclature').value = nomenclature;
 document.getElementById('item').value = item;		
 } 
</script>