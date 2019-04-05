
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
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showReceiptRegisterReportJsp";
  obj.submit();
  }
</script>
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
%>


<%
Date d=new Date();

String deptName="&nbsp;";

String toDate = "&nbsp;";
String fromDate = "&nbsp;";


	
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> recptRegister = new HashMap<String, Object>();
	Map<String, Object> requestParameters = new HashMap<String, Object>();

	String message = "";
	String clinicalNotes = "";
	String url = "";

	String entryPersonNameDesignation = "&nbsp;";
	String entryPersonNameRank = "&nbsp;";

	String flagForConfidential = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("recptRegister") != null) {
		
		recptRegister = (Map<String, Object>)map.get("recptRegister");
		System.out.println("in not null");
		
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	List objectList = new ArrayList();
	if (recptRegister.get("objectList") != null) {
		objectList = (List)recptRegister.get("objectList");
		System.out.println("objectList javed in jsp "+objectList.size());

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
	
	/*
		if (detailsMap1.get("patientName") != null) {
		patientName = (String)detailsMap1.get("patientName");
*/

if (recptRegister.get("msg") != null) {
           message = (String) recptRegister.get("msg");
    }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="clear"></div>

<div class="Clear"></div>
<form name="receiptRegister1" method="post" action="">
<div class="titleBg">
<h2>Receipt Report</h2>
</div>
<div class="Block">
<label> From Date<span>*</span>  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" 
onClick="setdate('<%=currentDate%>',document.receiptRegister1.<%=FROM_DATE%>,event)" />
<label> To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>"  class="textbox_date" MAXLENGTH="30" 

validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 

class="calender" tabindex="1" 

onClick="setdate('<%=currentDate%>',document.receiptRegister1.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<!--  <label ><span>*</span>  Source of
Supply</label> <select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
	validate="Source of Supply,String,no">
	<option value="0">Select</option>
	<option value="p">PVMS by DGRC</option>
	<option value="a">AFMSD</option>
	<option value="l">Local Purchase</option>
	</select>-->
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('receiptRegister1','stores?method=generateReceiptRegisterReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('receiptRegister1','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />  
<input type="button" name="clear" id="clearbutton" value="Reset" class="button" onClick="clearButton('receiptRegister1');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<div class="Clear"></div>
<div class="clear"></div>



<%if(objectList.size()>0){
	
	System.out.println("tester"+fromDate); 
	
%>

<label>From Date: </label><label><%=fromDate %></label> <label>To Date: </label><label><%=toDate %></label>
<div class="Clear"></div>

<h4>RECEIPT VOUCHER DETAILS</h4>

<div class="Clear"></div>

<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Date</th>
			<th>RV No. </th>
			 <th>Consigner</th>            
			 
		
		</tr>
</thead>

		<%
		System.out.println("this is ashutos list size"+objectList.size());
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
		
		
<%

System.out.println("object ashu33333333333333333 "+object.length);

System.out.println("this is object list-------------------------->>>>>>>>>>>>>>>>>>"+object[0]);
%>
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= HMSUtil.changeDateToddMMyyyy((Date)object[1])%></div></td>
<td ><div class="calcell"><%=object[0]%></div></td>
<%if(object[2] != null) {%>
<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td><div class="calcell">- </div></td>
	<%} %>
</tr>
<%}%>


<%} %>
</table>
