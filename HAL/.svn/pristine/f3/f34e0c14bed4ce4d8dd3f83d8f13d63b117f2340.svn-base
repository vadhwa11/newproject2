
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>



<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=localPurchaseRegisterReportJsp";
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
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> localPurcahageRegister = new HashMap<String, Object>();
List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier> ();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("localPurcahageRegister") != null) {

		localPurcahageRegister = (Map<String, Object>)map.get("localPurcahageRegister");
		System.out.println("in not null");

	}

	List objectList = new ArrayList();
	if (localPurcahageRegister.get("objectList") != null) {
		objectList = (List)localPurcahageRegister.get("objectList");
		System.out.println("objectList in jsp "+objectList.size());
	}
	if (map.get("supplierList") != null) {
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
	}

%>
<%if(objectList.size()==0){%>
	<h4><%="No Record Found !" %></h4>
	<%}%>
<form name="localPurchaseRegister" method="post" action="">
<div class="titleBg">
<h2>LOCAL PURCHASE REGISTER</h2>
</div>
<div class="Block">
<%String nameItem="nameItem" ; %>
<label> From Date  </label>
<input type="text" name="<%=FROM_DATE%>" value=""  class="date" MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.localPurchaseRegister.<%=FROM_DATE%>,event)" />
<label> To </label>
<input type="text" name="<%=TO_DATE%>" value="" class="date" MAXLENGTH="30" validate="Pick a to date,date,no" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.localPurchaseRegister.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label> From CRV No.  </label>
<input  type="text" name="fromCrv" value="" MAXLENGTH="30" validate="From CRV No.,string,no"/>
<label> To  </label>
<input  type="text" name="toCrv" value="" MAXLENGTH="30" validate="To CRV No.,string,no" />
<div class="clear"></div>
<label> PVMS No.  </label>
<input  type="text" name="pvms" value="" MAXLENGTH="30" validate="PVMS No.,alphanumeric1,no" />
<label >Nomenclature</label>
			<input type="text" value="" name="<%=nameItem%>" id="<%=nameItem%>" onblur=""
			 />
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForTurnOverByAutocomplete',{parameters:'requiredField=<%=nameItem%>' });
			</script>
<div class="clear"></div>
<label> Vendor Name  </label>
		<select	name="<%= SUPPLIER_ID %>" id="supplierId" validate="Vendor Name,String,no">
			<option value="0">--Select--</option>
<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
			}
%>
		</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('localPurchaseRegister','stores?method=generateLocalPurchaseRegisterReport&flag=j');" accesskey="a" tabindex=1 />
<!--  <input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('localPurchaseRegister','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />-->
<input type="button" name="clear" id="clearbutton" value="Reset" class="button" onClick="clearButton('localPurchaseRegister');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<%if(objectList.size()>0){ %>
<label>OUTPUT</label>
<div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">
<table id="main">
	<thead>
		<tr>
			<th>SI No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			<th>Vendor Name and Address</th>
			<th>CRV No.</th>
			<th>CRV Date</th>
			<th>Vendor Invoice No. with Date</th>
			<th>Particulars of Patient </th>
			<th>Diagnosis</th>
			 <th>Dosage</th>
			<th >Prescribed by</th>

			<th >Remarks</th>
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>


<tr>
<td><%=++count%></td>
<td><div class="calcell"><%= object[13]%></div></td>
<td ><div class="calcell"><%=object[14]%></div></td>
<%if(object[17] != null) {%>
<td ><div class="calcell"><%=object[17]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[11] != null) {%>
	<td ><div class="calcell"><%=object[11]%><%=" "+object[12]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[0]%></div></td>
<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[1])%></div></td>
<%if(object[9] != null && object[10] != null) {%>
<td ><div class="calcell"><%=object[9]%><%=" / "+HMSUtil.changeDateToddMMyyyy((Date)object[10])%></div></td>
<%}else{ %>
<td ><div class="calcell"><%=" - / - "%></div></td>
<%} %>
<%
String p_Name="";
if(object[23] != null ){
	 p_Name=p_Name+" "+object[23];
}
if(object[24] != null ){
	 p_Name=p_Name+" "+object[24];
}
String s_Name="";
if(object[27] != null ){
	 s_Name=s_Name+" "+object[27];
}
if(object[28] != null ){
	 s_Name=s_Name+" "+object[28];
}

%>
<%if(s_Name != null && s_Name != "" && object[31] !=null && object[29] !=null && object[30] !=null) {%>
<td><div class="calcell"><%=object[29]+","+object[31]+","+object[30]+", "+s_Name%></div></td>
<%}else{ %>
<td><div class="calcell"><%="-"%></div></td>
<%}%>
<%if(object[33] != null ) {%>
<td ><div class="calcell"><%=object[33]%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="-"%></div></td>
<%} %>
<%if(object[32] != null ) {%>
<td ><div class="calcell"><%=object[32]%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="-"%></div></td>
<%} %>
<%
String E_Name="";
if(object[25] != null ){
	 E_Name=E_Name+" "+object[25];
}
if(object[26] != null ){
	 E_Name=E_Name+" "+object[26];
}


%>
<td ><div class="calcell"><%=E_Name%></div></td>
<%if(object[20] != null ) {%>
<td ><div class="calcell"><%=object[20]%></div></td>
<%}else{ %>
<td ><div class="calcell"><%="-"%></div></td>
<%} %>
</tr>
<%}%>
</table>
</div>
<%}%>