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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
	</script>

<%
Map<String, Object> defectiveDrugsItem = new HashMap<String, Object>();
Map<String, Object> requestParameters = new HashMap<String, Object>();
Map map = new HashMap();
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	String fromDate="";
	String toDate="";
	//Map<String,Object> utilMap = new HashMap<String,Object>();
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
if (map.get("defectiveDrugsItem") != null) {
		
	defectiveDrugsItem = (Map<String, Object>)map.get("defectiveDrugsItem");
		System.out.println("in not null");
		
	}
	
	List objectList = new ArrayList();
	if (defectiveDrugsItem.get("objectList") != null) {
		objectList = (List)defectiveDrugsItem.get("objectList");
		System.out.println("objectList in jsp "+objectList.size());

	}
	if (map.get("requestParameters") != null) {
		requestParameters = (Map<String, Object>)map.get("requestParameters");

	}
	if (requestParameters.get("toDate") != null) {
		toDate = (String)requestParameters.get("toDate");

	}
	if (requestParameters.get("fromDate") != null) {
		fromDate = (String)requestParameters.get("fromDate");

	}
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	if(map.get("sectionList") != null){
		sectionList= (ArrayList) map.get("sectionList");
	}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		//if(!message.equalsIgnoreCase("")){
			if(objectList.size()==0){
		%>
	<h4><%="NO Record Found !" %></h4>
	<%} %>


<form name="defectiveDrugsReport"  action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>Defective Drugs Register</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveDrugsReport.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveDrugsReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div> 
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="methodForReport();" value="Generate Report" class="buttonBig">
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script>
function methodForReport(){
	
	submitForm('defectiveDrugsReport','stores?method=generateDefectiveDrugsReport');
	
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

<%if(objectList.size()>0) {%>
<!--  
<label>From Date: </label><label><%=fromDate%></label> <label>To Date: </label><label><%=toDate %></label>
 -->
<div class="clear"></div>

<h2>DEFECTIVE DRUG REGISTER</h2>
<!--
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
  -->
<table id="main">
	<thead>
		<tr>
			<th>Date </th>
			<th>Authority</th>
			<th>PVMS No. </th>
			<th>Nomenclature</th>
			<th>A/U</th>    
			<th>Batch No.</th>         
			<th >Manufactured By</th>
			<th >DOM</th>
			<th >DOE</th>
			<th >Qty</th>
			<th >Disposal Instruction</th>
			<th>Status</th>
			<th >Remarks</th>	
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
		
	
<tr>
<td><%= HMSUtil.changeDateToddMMyyyy((Date)object[0])%></td>
<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<td ><div class="calcell"><%=object[8]%></div></td>
<%if(object[9] != null) {%>
<td ><div class="calcell"><%=object[9]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[11] != null) {%>
	<td ><div class="calcell"><%=object[11]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[3]%></div></td>

<%if(object[10] != null) {%>
	<td ><div class="calcell"><%=object[10]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	
	<%if(object[4] != null) {%>
	<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[4])%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[5] != null) {%>
	<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[5])%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td ><div class="calcell"><%=object[6] %></div></td>
<%if(object[7] != null) {%>
	<td ><div class="calcell"><%=object[7]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[12] != null) {%>
	<td ><div class="calcell"><%=object[12]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

</tr>
<%}%>
</table>
<!-- 
</div>
 -->
<%} %>

