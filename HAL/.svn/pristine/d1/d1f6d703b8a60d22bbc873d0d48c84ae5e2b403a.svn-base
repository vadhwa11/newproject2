
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*" %>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

	<%
	//Object[] obj=null;
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}

 		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
 		List<MasItemCategory> subSectionList = new ArrayList<MasItemCategory>();
 		Map<String, Object> vedItem = new HashMap<String, Object>();
 		if (map.get("vedItem") != null) {

 			vedItem = (Map<String, Object>)map.get("vedItem");
 			System.out.println("in not null");

 		}
 		List objectList = new ArrayList();
 		if (vedItem.get("objectList") != null) {
 			objectList = (List)vedItem.get("objectList");
 			System.out.println("objectList in jsp "+objectList.size());

 		}


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
		String message ="";
		 //System.out.println("--1----- "+surplusItemList.get("msg"));



	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
			</script> <script>
function aa()
{
    if ( document.PvmsNivMasterReport.<%=SECTION_ID%>.checked == true )
    {
    	document.getElementById("sectionList").style.display='inline';
    	document.getElementById("subSectionList").style.display='none';
    	document.getElementById("SubSectionWise").checked=false;
    }
    else
    {
    	document.getElementById("sectionList").style.display='none';
    }
 }

function bb()
{    if ( document.getElementById('SubSectionWise').checked == true )
    {
    	document.getElementById("subSectionList").style.display='inline';
    	document.getElementById("sectionList").style.display='none';
    	document.getElementById("SectionWise").checked=false;
    }
    else
    {
    	document.getElementById("subSectionList").style.display='none';
    }
 }
</script>

<script type="text/javascript" language="javascript">
function clearButton(formName)
{
obj = eval('document.'+formName)
obj.action = "/hms/hms/stores?method=vedAnalysisReport";
obj.submit();
}
function fillValues(){
	//alert("in fill");
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=j');

}
function fillValues1(){
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=p');

}
</script>
<%if(!message.equals("")){

	%>
<h4><%=message %></h4>
<%} %>
<form name="vedReport" method="post" action="">

<div class="titleBg">
<h2>VED REPORT</h2>
</div>
<div class="Block">
<label >VED Type</label>
<select name="vedType" id="vedType" tabindex=1
	validate="Source of Supply,String,no">
	<option value="a">Select</option>
	<option value="d">DESIRABLE</option>
	<option value="e">ESSENTIAL</option>
	<option value="v">VITAL</option>
	</select>
	
</div>
<div class="clear"></div>
<div class="clear"></div>
 <div class="division"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('vedReport','stores?method=vedAnalysisJspReport&flag=j');" accesskey="a" tabindex=1 />
<%--  <input type="button" name="add" id="addbutton" value="Print" class="button" onClick="" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Excel" class="button" onClick="submitForm('vedReport','stores?method=vedAnalysisJspReport&flag=e');" accesskey="a" tabindex=1 />
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('receiptRegister','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />--%>
<input type="button" name="clear" id="clearbutton" value="Reset" class="button" onClick="clearButton('vedReport');" accesskey="a" tabindex=1 />
</form>
<script type="text/javascript">
 function checkSection(){
	 var sectionId=document.getElementById('sectionListId').value
	 var subSectionId=document.getElementById('subSectionListId').value
	 if((sectionId !=0 || sectionId != "") && (subSectionId !=0 || subSectionId != "")){
		 alert("Either Select Section or Sub Section...");
	 }
 }
 </script>
 <div class="clear"></div>
<div class="clear"></div>
 <div class="division"></div>
 <table id="main">
 <%if(objectList.size()>0){ %>

	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS/NIV NO.</th>
			<th>Manufacturer</th>
			<th>A/U </th>


			<th >Stock Bal. </th>

			<th >Min. Stock </th>

			<th >Required </th>
		</tr>
	</thead>
	<%
		int count=0;


		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();

		if(object[3]!= null){
if(object[3].toString().equalsIgnoreCase("v")){if(count==0){ %>
<tbody>
		<tr>
			<td colspan=8><h2>VITAL</h2></td>
		</tr>
	</tbody>
<%} %>

<tr>

<td><%=++count%></td>
<td><div class="calcell"><%=object[0]%></div></td>

<%if(object[1] != null) {%>
<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[5] != null) {%>
	<td ><div class="calcell"><%=object[5]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[4] != null) {%>
	<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<% if((((BigDecimal)object[4]).intValue())<(((BigDecimal)object[2]).intValue())){ %>
<td ><div class="calcell"><%=(((BigDecimal)object[2]).intValue())-(((BigDecimal)object[4]).intValue())%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="0"%></div></td>
<%} %>
</tr>
<%}}} %>




 <%
		int count1=0;


		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();

		if(object[3]!= null){
if(object[3].toString().equalsIgnoreCase("e")){if(count1==0){ %>

<tbody>
		<tr>
			<td colspan=8><h2>ESSENTIAL</h2></td>
		</tr>
	</tbody>
<%} %>

<tr>

<td><%=++count1%></td>
<td><div class="calcell"><%=object[0]%></div></td>

<%if(object[1] != null) {%>
<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[5] != null) {%>
	<td ><div class="calcell"><%=object[5]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[4] != null) {%>
	<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<% if((((BigDecimal)object[4]).intValue())<(((BigDecimal)object[2]).intValue())){ %>
<td ><div class="calcell"><%=(((BigDecimal)object[2]).intValue())-(((BigDecimal)object[4]).intValue())%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="0"%></div></td>
<%} %>

</tr>
<%}}} %>


<%
		int count2=0;


		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();

		if(object[3]!= null){
if(object[3].toString().equalsIgnoreCase("d")){if(count2==0){ %>



<tbody>
		<tr>
			<td colspan=8><h2>DESIRABLE</h2></td>
		</tr>
	</tbody>

<%} %>
<tr>

<td><%=++count2%></td>
<td><div class="calcell"><%=object[0]%></div></td>

<%if(object[1] != null) {%>
<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[5] != null) {%>
	<td ><div class="calcell"><%=object[5]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[4] != null) {%>
	<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<% if((((BigDecimal)object[4]).intValue())<(((BigDecimal)object[2]).intValue())){ %>
<td ><div class="calcell"><%=(((BigDecimal)object[2]).intValue())-(((BigDecimal)object[4]).intValue())%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="0"%></div></td>
<%} %>

</tr>

<%}}} %>
</table>

<%} %>
<div class="clear"></div>
<%if(objectList.size()==0){ %>
<h4><%="No Record Found !"%></h4>
<%} %>
<div class="clear"></div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>