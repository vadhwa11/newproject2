
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script language="Javascript">
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
	</script>

<%
Map map = new HashMap();
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	if(map.get("sectionList") != null){
		sectionList= (ArrayList) map.get("sectionList");
	}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
	<h4><%=message %></h4>
	<%} %>


<form name="stockStatusReport"  target="_blank" action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>Actual Stock Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>CRV No. </label>
<input type="text"	value="" id="crvNo"  name="crvNo" /> 

<label>PVMS/NIV No. </label>
<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv" validate="PVMS/NIV NO.,alphanumeric1,no" /> 

<label>Item Name </label> <input type="text"
	value="" id="nomenclature" name="nomenclature" />
<div id="ac2update" style="display: none;"	class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script>

<label>Receipt Date From</label>
<input type="text" name="<%=FROM_DATE%>" value="" class="date" MAXLENGTH="30" validate="Date,date,no" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('',document.stockStatusReport.<%=FROM_DATE%>,event)" />

<label>Receipt To From</label>
<input type="text" name="<%=TO_DATE%>" value="" class="date" MAXLENGTH="30" validate="Date,date,no" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('',document.stockStatusReport.<%=TO_DATE%>,event)" />


<label class="auto">Summary</label> <input type="radio" name="reportType"
	value="<%=SUMMARY  %>" class="radioAuto" checked="checked"
	maxlength="30" tabindex=1 /> 
	
	
	<input class="transparent" size="1" />
	
	<label class="auto">Detail </label> <input
	type="radio" name="reportType" value="<%=DETAIL  %>" class="radioAuto"
	maxlength="30" tabindex=1 />
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="methodForReport();" value="Ok" class="buttonSm">
<input type="reset" name="Reset" id="reset" value="Cancel" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="exportExcel" onClick="methodForExcel();" value="Export To Excel" class="buttonBig">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script>
function methodForReport(){
	var sectionName='';
	if( document.getElementById('sectionId'))
		sectionName = document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=""){
		submitForm('stockStatusReport','stores?method=generateActualStockSactionReport');
	}else{
		submitForm('stockStatusReport','stores?method=generatestockStatusReport');
	}
}
function fillValues(){
	if(document.stockStatusReport.nomenclature.value != "")
	{
	var val = document.stockStatusReport.nomenclature.value;

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   		 if (pvms!="")
   	 	{
    	document.getElementById("item_id").value=pvms;

		}
	}
		else
		{
			document.getElementById("item_id").value=0;

		}

	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;
    var item_id=document.getElementById('item_id').value;
	if(sectionName !=0  && (item_id !=0 ||  pvmsNo != "")){
		submitForm('stockStatusReport','stores?method=generateActualStockSactionReport');
		
	}else{
		submitForm('stockStatusReport','/hms/hms/stores?method=generatestockStatusReport');
	}
	
	//submitForm('stockStatusReport','/hms/hms/stores?method=generatestockStatusReport&deptName='+departmentName+'');

}

function methodForExcel(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=0 || pvmsNo !=""){
		submitForm('stockStatusReport','stores?method=generateActualStockSactionExcel');
	}else{
		submitForm('stockStatusReport','stores?method=generateActualStockExcel');
	}
}

</script>
