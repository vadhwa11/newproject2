
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
		System.out.println("sectionList  "+sectionList.size());
	}
	Map<String, Object> actualStock = new HashMap<String, Object>();
		if (map.get("actualStock") != null) {
			
			actualStock = (Map<String, Object>)map.get("actualStock");
			System.out.println("in not null");
			
		}
		List objectList = new ArrayList();
 		if (actualStock.get("objectList") != null) {
 			objectList = (List)actualStock.get("objectList");
 			System.out.println("objectList in jsp "+objectList.size());

 		}
 		String reportType="";
 		if(map.get("reportType") != null){
 			reportType= (String) map.get("reportType");
 			System.out.println("reportType "+reportType);
 		}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
	<h4><%=message %></h4>
	<%} %>
	<!--  
	<%if(objectList.size()==0){%>
<h4><%="No Record Found !" %></h4>
<%}%>
	-->


<form name="actualStockReport"   action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>Stock Status Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validatePvms(this.value))
{
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})};
</script> 
<input type="hidden"	value="" id="itemId"  name="itemId" /> 
<label>PVMS/NIV No. </label>																
<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv" validate="PVMS/NIV No,alphanumeric1,no" /> 
<div class="clear"></div>
<label>Section Code </label> 
<select id="sectionId"	name="sectionId" validate="Section Code,string,no">
	<option value="">Select</option>
	<%	for (MasStoreSection masseSection : sectionList) {%>
	<option value="<%=masseSection.getId() %>"><%=masseSection.getSectionName()%></option>
	<%}	%>
</select>

<!-- -
<label>Item Name </label> <input type="text"
	value="" id="nomenclature" name="nomenclature" />
<div id="ac2update" style="display: none;"
			class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
					</script>
 -->

<label class="medium">Summary</label> <input type="radio" name="reportType"
	value="<%=SUMMARY  %>" class="radioAuto" checked="checked"
	maxlength="30" tabindex=1 /> 
	
	<label class="medium">Detail </label> <input
	type="radio" name="reportType" value="<%=DETAIL  %>" class="radioAuto"
	maxlength="30" tabindex=1 />
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="methodForReport1();"  value="Generate Report" class="buttonBig" >
<input type="button" name="report" onClick="methodForReport();" value="Print" class="button">
<input type="button" name="exportExcel" onClick="methodForExcel();" value="Export To Excel" class="buttonBig">
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script>
function methodForReport(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=""){		
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport');
	}else{		
		submitForm('actualStockReport','stores?method=generateActualStockReport');
	}
}
function methodForReport1(){
	
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=""){
		
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport&flag=j');
	}else{
		
		if(document.actualStockReport.nomenclature.value != "")
		{
			var val = document.actualStockReport.nomenclature.value;
			document.actualStockReport.method="post";
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   		if (id!="")
	   	 	{
	    	document.getElementById("itemId").value=id;
	    	document.actualStockReport.method="post";
	    	submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
			document.getElementById("itemId").value="";
			}
			
		}
		else
		{
			submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
		}
		
		
		
		//submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
	}
}
function fillValues(){
	if(document.actualStockReport.nomenclature.value != "")
	{
	var val = document.actualStockReport.nomenclature.value;

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
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport');
		
	}else{
		submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport');
	}
	
	//submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport&deptName='+departmentName+'');

}

function methodForExcel(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=""){
		submitForm('actualStockReport','stores?method=generateActualStockSactionExcel');
	}else{
		submitForm('actualStockReport','stores?method=generateActualStockExcel');
	}
}

</script>
<%if(objectList.size()>0){ %>
<!-- <div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;"> -->
<div class="cmntableWithHeight">
<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS/NIV No</th>
			<th class="fixedNomen" >Nomenclature</th>
			<th>A/U </th>
			<%if(reportType.equals("detail")){ %>
			<th>Batch No.</th>
			 <th>DOM</th> 
			<th>DOE</th>
			<th>Manufacturer</th> 
			<%} %>
			<th>Stock Qty.</th> 	
		</tr>
	</thead>

		<%
		System.out.println("in jsp------");
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
		
	
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[3]%></div></td>
<td ><div class="calcell"><%=object[4]%></div></td>
<%if(reportType.equals("detail")){ %>
<%if(object[9] != null) {%>
<td ><div class="calcell"><%=object[9]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} }else{%>
	<td ><div class="calcell"><%=object[6]%></div></td>
	<%} %>
<%if(reportType.equals("detail")){ %>
<td><div class="calcell"><%= object[7]%></div></td>
<%if(object[10] != null) {%>
	<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[10])%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[8])%></div></td>
<%if(object[11] != null) {%>
	<td ><div class="calcell"><%=object[11]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%} %>
<%if(object[5] != null) {%>
	<td ><div class="calcell"><%=object[5]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

</tr>
<%}%>
</table>
</div>
<%}%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>