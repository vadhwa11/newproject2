<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * chargeCode.jsp  
 * Purpose of the JSP -  This is for Investigation
 * @author  Abha
 * Create Date: 29th July,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>


<h6>Investigation</h6>
<div class="Clear"></div>
<script>

</script> <script>
function generateRow1(idName) {
    	
		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[1].value=d.length-1;
		for(var i=0;i<tblCtrl.length;i++)
		tblCtrl[i].value="";
			
		}
</script> <script>
function normal(){
if(document.getElementById('comparisonType').value =='v'){
 get_value();
}
}
function get_value()
{
 var url="/hms/hms/investigation?method=showNormalValue";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=250,width=950,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

</script> <script>

</script> <%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}

ArrayList <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
subChargecodeList = (ArrayList)map.get("subChargecodeList");

ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
mainChargecodeList = (ArrayList)map.get("mainChargecodeList");

List<DgUom> uomList = new ArrayList<DgUom>();
uomList = (ArrayList)map.get("uomList");

List<MasSample> sampleList=new ArrayList<MasSample>();
sampleList = (ArrayList)map.get("sampleList");

int subTestId=0;	
if(map.get("subTestId")!=null){
	subTestId=Integer.parseInt(""+map.get("subTestId"));
}
String message="";
 if( map.get("message") != null){	
		message = (String) map.get("message");
	}
    %>

<form name="chargeCode" method="post" action="">
<div class="Clear"></div>
<%=message %>
<div class="Clear"></div>
<div class="Block">
<label>Lab Name</label> <select
	id="mainChargeName" name="<%=MAIN_CHARGECODE_ID %>"
	validate="Lab Name,string,yes" tabindex=1
	onchange="submitProtoAjax('chargeCode','/hms/hms/investigation?method=responseForSubCharge');">
	<option value=""><--select lab--></option>
	<% 
				
				for (MasMainChargecode mainChargecode : mainChargecodeList){
				%>

	<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>

	<%}%>

</select>



<div id=testDiv><label class="noWidth">Lab Group Name</label> <select
	id="subChargeName" name="<%=SUB_CHARGECODE_ID %>" tabindex=1>
	<option value=""><--select labgroup--></option>
</select></div>

<div id=suppDiv><label>Test Name</label> <select id="chargeName"
	name="<%=CHARGE_CODE_ID %>" tabindex=1>
	<option value=""><--Select Test--></option>
</select></div>
</div>
<div id=gridDiv></div>
<div class="Clear"></div>
<label>Sample Name:</label> <select id="sampleId" name="<%=SAMPLE_ID %>"
	validate="Sample,string,no" tabindex=1" >
	<option value=""><--select sample--></option>
	<% 
				
				for (MasSample sample : sampleList){
				%>

	<option value="<%=sample.getId ()%>"><%=sample.getSampleDescription()%></option>

	<%}%>
</select> <label>Investigation Code:</label> <input type="text"
	name="<%=SUBTEST_CODE %>" id="<%=SUBTEST_CODE %>"> <label>Investigation
Name:</label> <input type="text" name="<%=SUBTEST_NAME %>"
	id="<%=SUBTEST_NAME %>"> <label>Multiple Results:</label> <input
	type="checkbox" name="multipleresults" value="1" class="checkbox"
	onclick="multiplResults(this);" /> <br />
<div class="Clear"></div>
<label>Normal Value:</label> <input type="text"
	name="<%=NORMAL_VALUE %>" id="<%=NORMAL_VALUE %>"> <label>Quantity:</label>
<input type="text" name="<%=QUANTITY %>" id="<%=QUANTITY %>"> <label>Unit:</label>
<select id="uomId" name="<%=UNIT_OF_MEASUREMENT_ID %>"
	validate="unit of measurement,string,no" tabindex=1" >
	<option value=""><--select unit--></option>
	<% 
				
				for (DgUom uom : uomList){
				%>

	<option value="<%=uom.getId ()%>"><%=uom.getUomName()%></option>

	<%}%>
</select> <label>Confidential:</label> <input type="checkbox"
	name="<%= CONFIDENTIAL%>" value="1" class="checkbox" /> <label>
Appear in discharge Summary:</label> <input type="checkbox"
	name="<%= DSICHARGE_SUMMARY%>" value="1" class="checkbox" />


<div class="Clear"></div>
<input type="button" name="add" value="Submit"
	class="button"
	onClick="submitForm('chargeCode','investigation?method=addChargeCode');"
	accesskey="a" tabindex=1 /></form>
