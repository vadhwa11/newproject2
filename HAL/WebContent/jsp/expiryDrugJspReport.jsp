
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript">
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
	Map<String,Object> map = new HashMap<String,Object>();
	String asOn="";
	String asOnDate="";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
}	
Map<String, Object> expiryDrugList = new HashMap<String, Object>();
	if (map.get("expiryDrug") != null) {
		
		expiryDrugList = (Map<String, Object>)map.get("expiryDrug");
		
	}
	List objectList = new ArrayList();
	if (expiryDrugList.get("objectList") != null) {
		objectList = (List)expiryDrugList.get("objectList");
	}
	 
	if (map.get("from_Date") != null) {
		  asOn=(String)map.get("from_Date");
		

		}
	if (map.get("fromDate") != null) {
		  asOnDate=(String)map.get("from_Date");
		

		}
%>
<form name="drugForm" method="post" action="">
<div class="titleBg">
<h2>Drug Expiry Report</h2>
</div>
<div class="Block">
<label>As on Date <span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%= asOn %>" class="textbox_date" MAXLENGTH="30" validate="Pick a Expiry Date,date,yes" readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.drugForm.<%=FROM_DATE%>,event)" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig"  onClick="submitForm('drugForm','purchaseOrder?method=generateDrugExpiryReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('drugForm','purchaseOrder?method=generateDrugExpiryReport&flag=p');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" accesskey="r" onclick="submitForm('drugForm','/hms/hms/purchaseOrder?method=showDrugExpiryReportJsp')"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<div class="clear"></div>
<!-- 
<label>As On Date: </label><label><%=asOn%></label>  -->
<div class="division"></div>
<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS/NIV No</th>
			<th>Nomenclature</th>
			<th>A/U </th>
			<th> Qty</th>
			<th>Batch No.</th>     
			<th> Expiry Date</th>         
			
	</thead>

		<%
		int count=0;
		
		
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		
		System.out.println(""+object[1]);%>
		
	
<tr>
<td><%=++count%></td>
<%if(object[0] != null) {%>
<td><div class="calcell"><%=object[0]%></div></td>
<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[1] != null) {%>
<td ><div class="calcell"><%=object[1]%></div></td>
<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[5] != null) {%>
	<td><div class="calcell"><%=object[5]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<%if(object[3] != null) {%>
<td><div class="calcell"><%=object[3]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
		<%if(object[4] != null) {%>
		
<td><div class="calcell"><%=HMSUtil.convertDateToStringTypeDateOnly((Date)object[4])%></div></td>
<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
</tr>

<%}%>
</table>




