
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="java.math.BigInteger"%>
<%@page import="java.math.BigDecimal"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
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
  obj.action = "/hms/hms/stores?method=fsnAnalysisReport";
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
	System.out.println("-------------  FSN JSP  "+currentDate);
	
%>
<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=\"FSN.xls\"");
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> fsnItem = new HashMap<String, Object>();
String fsnType="";
String flag="";

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");

}
if (map.get("fsnType") != null) {
	
	fsnType = (String)map.get("fsnType");
	System.out.println("fsnType "+fsnType);
	
}
if (map.get("fsnItem") != null) {
	
	fsnItem = (Map<String, Object>)map.get("fsnItem");
	System.out.println("in not null");
	
}
if (map.get("flag") != null) {
	
	flag = (String)map.get("flag");
	System.out.println("www  "+flag);
	
}
List objectList = new ArrayList();
if (fsnItem.get("objectList") != null) {
	objectList = (List)fsnItem.get("objectList");
	System.out.println("objectList in jsp "+objectList.size());

}
String message ="";
//out.println("--1  "+fsnItem.get("msg"));
if (fsnItem.get("msg") != null) {
             message = (String) fsnItem.get("msg");
             //out.println("--2  "+message);
      }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>
<% 
if(flag.equalsIgnoreCase("e")){

}%>

<form name="fsnAnalysis" method="post" action="">
<div class="titleBg">
<h2>FSN Analysis Report</h2>
</div>
<div class="Block">
<!--
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.fsnAnalysis.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.fsnAnalysis.<%=TO_DATE%>,event)" />
 -->
 <div class="clear"></div>
 <label ><span>*</span> For Last Month</label> 
<select name="lastMonth" id="lastMonth" tabindex=1
	validate="Month,String,yes">
	<option value="0">Select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	
	</select>
 

<label >Type</label> 
<select name="fsnType" id="fsnType" tabindex=1
	validate="FSN Type,String,no">
	<option value="a">Select</option>
	<option value="f">Fast</option>
	<option value="s">slow</option>
	<option value="n">Non Moving</option>
	</select>
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate" class="button" onClick="submitForm('fsnAnalysis','stores?method=fsnAnalysisJspReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Excel" class="button" onClick="submitForm('fsnAnalysis','stores?method=fsnAnalysisJspReport&flag=e');" accesskey="a" tabindex=1 />

<!-- <input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('receiptRegister','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />-->  
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('fsnAnalysis');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<%if(objectList.size()>0){%>
<h2>FAST MOVING ITEM</h2>
<table id="main">
	<thead>
		<tr>
			<th>SL. No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/u</th>
			<th>MMF Qty</th>            
	    	<th >Consumption Qty</th>
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
		
	<%if(fsnType.equalsIgnoreCase("a")){System.out.println("fsnType1 a"); %>
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[3]%></div></td>
<td ><div class="calcell"><%=object[2]%></div></td>
<%if(object[7] != null) {%>
<td ><div class="calcell"><%=object[7]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[5]%></div></td>


</tr>
<% }else if(fsnType.equalsIgnoreCase("f")){
	System.out.println("fsnType1 f");
	BigDecimal bd=(BigDecimal)object[4];
if(bd.intValue()>=50){%>
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[3]%></div></td>
<td ><div class="calcell"><%=object[2]%></div></td>
<%if(object[7] != null) {%>
<td ><div class="calcell"><%=object[7]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[5]%></div></td>
</tr>
<%}}else if(fsnType.equalsIgnoreCase("s")){
	System.out.println("fsnType1 s");
	BigDecimal bd=(BigDecimal)object[4];
	if(bd.intValue()>=30 && bd.intValue()<50){
	%>
	<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[3]%></div></td>
<td ><div class="calcell"><%=object[2]%></div></td>
<%if(object[7] != null) {%>
<td ><div class="calcell"><%=object[7]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[5]%></div></td>
</tr>
<%}}else if(fsnType.equalsIgnoreCase("n")) {
	System.out.println("fsnType12 n"+object[4]);
	BigDecimal bd=(BigDecimal)object[4];
	if(bd.intValue()<=30){
%>
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[3]%></div></td>
<td ><div class="calcell"><%=object[2]%></div></td>
<%if(object[7] != null) {%>
<td ><div class="calcell"><%=object[7]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[5]%></div></td>
</tr>
<%}} %>
<%}%>
</table>


<%	
}
%>

