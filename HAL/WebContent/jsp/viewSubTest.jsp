<%@page import="java.util.*"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%
DgMasInvestigation dgMasInvestigation=null;
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<DgUom> uomList = new ArrayList<DgUom>();
if(map.get("uomList") != null){
	uomList = (List<DgUom>)map.get("uomList");
}

ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
if(map.get("subChargecodeList") != null){
subChargecodeList = (ArrayList)map.get("subChargecodeList");
}

ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
if(map.get("mainChargecodeList") != null){
mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
}

ArrayList<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
if(map.get("chargeCodeList") != null){
chargeCodeList=(ArrayList)map.get("chargeCodeList");
}

//int investigationId=0;
int mainChargecodeId=0;
int subChargeCodeId=0;
int chargeCodeId=0;
if(map.get("mainChargecodeId") != null){
	mainChargecodeId =(Integer) map.get("mainChargecodeId");
}
if(map.get("subChargeCodeId") != null){
	subChargeCodeId =(Integer) map.get("subChargeCodeId");
	
}
if(map.get("chargeCodeId") != null){
	chargeCodeId =(Integer) map.get("chargeCodeId");
}

if(map.get("message") != null)
	{
	 	  String message = (String)map.get("message");
	 	   out.println(message);
}
//if(map.get("investigationId") != null){
	//investigationId =(Integer) map.get("investigationId");
//}
		int sampleId=0;
		String investigationName="";
		String confidential="";
		String investigationType="";
		String dischargeSummary="";
		if(map.get("investigationName") != null){
			investigationName =(String) map.get("investigationName");
			System.out.println("investigationName  "+investigationName);
		}
		if(map.get("confidential") != null){
			confidential =(String) map.get("confidential");
			
		}
		if(map.get("investigationType") != null){
			investigationType =(String) map.get("investigationType");
			System.out.println("investigationType  "+investigationType);
		}
		if(map.get("dischargeSummary") != null){
			dischargeSummary =(String) map.get("dischargeSummary");
		}
		if(map.get("sampleId") != null){
			sampleId =(Integer) map.get("sampleId");
			
		}
		int pageNo=0;
		if(map.get("pageNo") != null)
		{
		pageNo=(Integer)map.get("pageNo");
		}
		
%>
<script>
//function valuesForResultType(rowNo){

//if(document.getElementById('resultType'+rowNo).value =='h')
//{
//document.getElementById('comparisonType'+rowNo).value = 'n'
//document.getElementById('comparisonType'+rowNo).disabled = true;
//}else
//document.getElementById('comparisonType'+rowNo).disabled = false;
//}
</script>
<script>
function normal(rowNo){

if(document.getElementById('comparisonType'+rowNo).value =='v'){
 get_value(rowNo);
 
}
}

function get_value(rowNo)
{
 
 var url="/hms/hms/investigation?method=showNormalValue&rowNo="+rowNo;

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


}

</script>

<form name="chargeCode" method="post"><br />
<br />
<div class="Clear"></div>
<%
String mainChargecodeName="";
int mainId=0;
if(mainChargecodeList != null){
for (MasMainChargecode masMainChargecode : mainChargecodeList) 
{
	mainId=masMainChargecode.getId();
	
	if(mainChargecodeId == mainId){
	mainChargecodeId=masMainChargecode.getId();
	
	mainChargecodeName=masMainChargecode.getMainChargecodeName();
	%> <label class="noWidth">Lab Name</label> <input type="text"
	name="<%=MAIN_CHARGECODE_NAME %>" id="<%=MAIN_CHARGECODE_NAME %>"
	value="<%=masMainChargecode.getMainChargecodeName() %>"
	readonly="readonly" /> <input type="hidden"
	id="<%=MAIN_CHARGECODE_ID %>" name="<%=MAIN_CHARGECODE_ID %>"
	value="<%=masMainChargecode.getId() %>"> <input type="hidden"
	id="<%=INVESTIGATION_NAME %>" name="<%=INVESTIGATION_NAME %>"
	value="<%= investigationName%>"> <input type="hidden"
	id="<%=INVESTIGATION_TYPE %>" name="<%=INVESTIGATION_TYPE %>"
	value="<%= investigationType%>"> <input type="hidden"
	id="<%=DSICHARGE_SUMMARY %>" name="<%=DSICHARGE_SUMMARY %>"
	value="<%= dischargeSummary%>"> <input type="hidden"
	id="<%=CONFIDENTIAL %>" name="<%=CONFIDENTIAL %>"
	value="<%= confidential%>"> <input type="hidden"
	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>">
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <% 	}}
}
%>
<div class="Clear"></div>
<%
String subChargecodeName="";
int subId=0;
if(subChargecodeList != null){
for (MasSubChargecode massubChargecode : subChargecodeList) 
{
	subId=massubChargecode.getId();
	if(subChargeCodeId == subId){
		subChargeCodeId=massubChargecode.getId();
	subChargecodeName=massubChargecode.getSubChargecodeName();
	%> <label class="noWidth">LabGroup Name</label> <input type="text"
	name="<%=SUB_CHARGECODE_NAME %>" id="<%=SUB_CHARGECODE_NAME %>"
	value="<%=massubChargecode.getSubChargecodeName() %>"
	readonly="readonly" /> <input type="hidden"
	id="<%=SUB_CHARGECODE_ID %>" name="<%=SUB_CHARGECODE_ID %>"
	value="<%=massubChargecode.getId() %>"> <% 	}}
}
%>
<div class="Clear"></div>
<%
String chargecodeName="";
int chargeId=0;
if(chargeCodeList != null){
for (MasChargeCode masChargeCode : chargeCodeList) 
{
	
	
	
	
	chargeId=masChargeCode.getId();
	if(chargeCodeId == chargeId){
		chargeCodeId=masChargeCode.getId();
	chargecodeName=masChargeCode.getChargeCodeName();
	%> <label class="noWidth">Charge Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" readonly="readonly" /> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=masChargeCode.getId() %>"> <% 	}}
}
%>
<div class="Clear"></div>



<div class="division"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="2%">Order No.</th>
			<th>Sub Test Code</th>
			<th>Sub Test Name</th>
			<th width="7%">Unit</th>
			<th>Result Type</th>
			<th>Comparison Type</th>

		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=12; 
    	int temp=0;
    	int inc = 0;    	
    
    	for(inc=1;inc<=12;inc++){
    	%>
		<tr>


			<td width="2%">
			<%if(dgMasInvestigation != null){ %> <input type="text" size="2"
				value="<%=temp+inc%>" id="<%=SR_NO %>" name="<%=SR_NO%>"
				readonly="readonly" /> <input type="text" size="2" value=""
				name="<%=ORDER_NO%>" id="orderNo<%=inc %>" maxlength="4"
				validate="Order No,int,no" tabindex=1 /> <%}else{ %> <input
				type="text" value="" size="2" name="<%=ORDER_NO%>"
				id="orderNo<%=inc %>" maxlength="4" validate="Order No,int,no"
				tabindex=1 /> <%} %>
			</td>
			<td>
			<%if(dgMasInvestigation != null){ %> <input type="text" size="2"
				value="" style="width: 150px;" name="<%=SUBTEST_CODE%>"
				id="subTestCode<%=inc %>" validate="Sub test code,string,no"
				maxlength="8" tabindex=1 /> <% }else{ %> <input type="text" size="2"
				value="" style="width: 150px;" name="<%=SUBTEST_CODE%>"
				id="subTestCode<%=inc %>" validate="Sub test code,string,no"
				maxlength="8" tabindex=1 /> <%} %>
			</td>

			<td width="7%">
			<%if(dgMasInvestigation != null){ %> <input type="text"
				value="<%=dgMasInvestigation.getInvestigationName() %>"
				style="width: 150px;" name="<%=SUBTEST_NAME%>"
				id="subTestName<%=inc %>" validate="Sub test name,string,no"
				maxlength="30" tabindex=1 /> <%}else{ %> <input type="text" value=""
				style="width: 150px;" name="<%=SUBTEST_NAME%>"
				id="subTestName<%=inc %>" validate="Sub test name,string,no"
				maxlength="30" tabindex=1 /> <%} %>
			</td>

			<td><select id="unitName" name="<%=UNIT_OF_MEASUREMENT_ID %>"
				validate="Unit,string,no" tabindex=1>
				<option value="">Select</option>
				<% 
				for (DgUom dgUom : uomList){
				%>
				<option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
				<%}%>
			</select></td>

			<td><select name="<%=RESULT_TYPE %>"
				id="<%=RESULT_TYPE %><%=inc %>" tabindex=1
				validate="Result Type,string,no">
			    <option value="0">Select</option>
				<option value="h">Heading</option>
				<option value="s">Single Parameter</option>
				<option value="m">Text Area</option>
				<option value="t">Text</option>
				<option value="r">Range</option>
			</select></td>
			<td><select name="<%=COMPARISON_TYPE %>"
				id="<%=COMPARISON_TYPE%><%=inc %>" tabindex=1
				validate="Comparison Type,string,no" onclick="normal(<%=inc %>);">
				<option value="0">Select</option>
				<option value="n">None</option>
				<option value="m">Min./Max.</option>
				<option value="v">Normal Values</option>
			</select></td>
			<%} %>

		</tr>
	</tbody>
	<input type="hidden" class="medcaption" name=<%=STATUS%> value="y"
		id="status" />
</table>

</div>

<div class="division"></div>
<div class="bottom"><input type="button" class="button"
	value="Submit" align="left"
	onClick="submitForm('chargeCode','investigation?method=submitSubTest');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp');" />
<input type="button" class="button" value="NormalValue" align="left"
	onClick="submitForm('chargeCode','investigation?method=showNormalValue');" />
</div>
</div>
</form>
