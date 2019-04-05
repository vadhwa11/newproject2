<%@page import="java.util.*"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%


Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
map = (Map<String,Object>) request.getAttribute("map");

}
if(map.get("message") != null)
{
String message = (String)map.get("message");
out.println(message);
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


int sampleId=0;
String investigationName="";
String confidential="";
String investigationType="";
String dischargeSummary="";
if(map.get("investigationName") != null){
investigationName =(String) map.get("investigationName");
}
if(map.get("confidential") != null){
confidential =(String) map.get("confidential");

}
if(map.get("investigationType") != null){
investigationType =(String) map.get("investigationType");
}
if(map.get("dischargeSummary") != null){
dischargeSummary =(String) map.get("dischargeSummary");
}
if(map.get("sampleId") != null){
sampleId =(Integer) map.get("sampleId");

}
int investigationId=0;
if(map.get("investigationId") != null){
	investigationId =(Integer) map.get("investigationId");

	}
int pageNo=0;
if(map.get("pageNo") != null)
{
pageNo=(Integer)map.get("pageNo");
}

/** for investigation List**/
List<DgSubMasInvestigation> investigationList = new ArrayList<DgSubMasInvestigation>();
if(map.get("investigationList") != null){
investigationList =(List) map.get("investigationList");

}




%>


<script>
function normal(rowNo,subTestId,chargeCodeId){

if(document.getElementById('comparisonType'+rowNo).value =='v'){
get_value(rowNo,subTestId,chargeCodeId);

}
else if(document.getElementById('comparisonType'+rowNo).value =='f'){
get_value_for_fixedValues(rowNo,subTestId,chargeCodeId);

}
}

function get_value(rowNo,subTestId,chargeCodeId)
{
var subTestId;
subTestId =document.getElementById('subTestId'+rowNo).value
var chargeCodeId;
chargeCodeId = document.getElementById('chargeCodeId'+rowNo).value;
var url="/hms/hms/investigation?method=showNormalValue&rowNo="+rowNo+'&subTestId='+subTestId+"&chargeCodeId="+chargeCodeId;

popwindow(url);
} 

function get_value_for_fixedValues(rowNo,subTestId,chargeCodeId)
{
var subTestId;
subTestId =document.getElementById('subTestId'+rowNo).value

//var chargeCodeId;
//chargeCodeId = document.getElementById('chargeCodeId'+rowNo).value;
var url="/hms/hms/investigation?method=showFixedValue&rowNo="+rowNo+'&subTestId='+subTestId;

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
<div id="contentHolder">
<h6>Diagnostic</h6>
<div class="Clear"></div>
<form name="chargeCode" method="post">

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
%>
<div class="header"><label class="common">Lab Name</label> <input
	type="text" name="<%=MAIN_CHARGECODE_NAME %>"
	id="<%=MAIN_CHARGECODE_NAME %>"
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
<input type="hidden" id="<%=INVESTIGATION_ID %>"
	name="<%=INVESTIGATION_ID %>" value="<%=investigationId %>"> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <% 	}}
}
%> <%
String subChargecodeName="";
int subId=0;
if(subChargecodeList != null){
for (MasSubChargecode massubChargecode : subChargecodeList) 
{
subId=massubChargecode.getId();
if(subChargeCodeId == subId){
subChargeCodeId=massubChargecode.getId();
subChargecodeName=massubChargecode.getSubChargecodeName();
%> <label class="common">LabGroup Name</label> <input type="text"
	name="<%=SUB_CHARGECODE_NAME %>" id="<%=SUB_CHARGECODE_NAME %>"
	value="<%=massubChargecode.getSubChargecodeName() %>"
	readonly="readonly" /> <input type="hidden"
	id="<%=SUB_CHARGECODE_ID %>" name="<%=SUB_CHARGECODE_ID %>"
	value="<%=massubChargecode.getId() %>"> <% 	}}
}
%> <%
String chargecodeName="";
int chargeId=0;
if(chargeCodeList != null){
for (MasChargeCode masChargeCode : chargeCodeList) 
{
chargeId=masChargeCode.getId();
if(chargeCodeId == chargeId){
chargeCodeId=masChargeCode.getId();
chargecodeName=masChargeCode.getChargeCodeName();
%> <label class="common">Charge Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" readonly="readonly" /> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=masChargeCode.getId() %>"> <% 	}}
}
%>
</div>
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
int inc=((pageNo-1)*12)+1;
System.out.println("inc  "+inc);
int incTemp2=inc+12;
System.out.println("incTemp2  "+incTemp2);
if(investigationList.size()>0){
for(DgSubMasInvestigation dgMasInvestigation : investigationList){
if(inc<incTemp2){
%>
		<tr>


			<td width="2%">
			<%if(dgMasInvestigation != null){ %> <input type="hidden"
				value="<%=dgMasInvestigation.getId() %>" name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID %><%=inc %>" /> <input type="hidden"
				id="chargeCodeId<%=inc %>" name="chargeCodeId"
				value="<%=dgMasInvestigation.getChargeCode().getId() %>"> <input
				type="text" size="2" value="<%=dgMasInvestigation.getOrderNo() %>"
				name="<%=ORDER_NO%>" id="orderNo<%=inc %>" maxlength="4"
				validate="Order No,int,no" tabindex=1 disabled="disabled" /> <%}else{ %>
			<input type="text" value="" size="2" name="<%=ORDER_NO%>"
				id="orderNo<%=inc %>" maxlength="4" validate="Order No,int,no"
				tabindex=1 disabled="disabled" /> <%} %>
			</td>
			<td>
			<%if(dgMasInvestigation != null){ %> <input type="text" size="8"
				value="<%=dgMasInvestigation.getSubInvestigationCode() %>"
				name="<%=SUBTEST_CODE%>" id="<%=SUBTEST_CODE%>"
				validate="Sub test code,string,no" maxlength="8" tabindex=1
				disabled="disabled" /> <% }else{ %> <input type="text" size="8"
				value="" name="<%=SUBTEST_CODE%>" id="subTestCode<%=inc %>"
				validate="Sub test code,string,no" maxlength="8" tabindex=1
				disabled="disabled" /> <%} %>
			</td>

			<td width="7%">
			<%if(dgMasInvestigation != null){ %> <input type="text"
				value="<%=dgMasInvestigation.getSubInvestigationName() %>"
				name="<%=SUBTEST_NAME%>" id="subTestName<%=inc %>"
				validate="Sub test name,string,no" disabled="disabled"
				maxlength="30" tabindex=1 /> <%}else{ %> <input type="text" value=""
				name="<%=SUBTEST_NAME%>" disabled="disabled"
				id="subTestName<%=inc %>" validate="Sub test name,string,no"
				maxlength="30" tabindex=1 /> <%} %>
			</td>

			<td><select id="unitName" name="<%=UNIT_OF_MEASUREMENT_ID %>"
				validate="Unit,string,no" disabled="disabled" tabindex=1>
				<option value="">Select</option>
				<%
for (DgUom dgUom : uomList){
if (dgMasInvestigation.getUom().getId().equals(dgUom.getId())) {
%>
				<option value=<%=dgUom.getId()%> selected="selected"><%=dgUom.getUomName()%></option>
				<%
} else {
%>
				<option value=<%=dgUom.getId()%>><%=dgUom.getUomName()%></option>
				<%
}
}
%>
			</select></td>

			<td><select name="<%=RESULT_TYPE %>"
				id="<%=RESULT_TYPE %><%=inc %>" class="large" disabled="disabled"
				tabindex=1 validate="Result Type,string,no">
				<option value="0">Select</option>

				<option value="h"
					<%=HMSUtil.isSelected(dgMasInvestigation.getResultType(),"h")%>>Heading</option>
				<option value="s"
					<%=HMSUtil.isSelected(dgMasInvestigation.getResultType(),"s") %>>Single
				Parameter</option>
				<option value="m"
					<%=HMSUtil.isSelected(dgMasInvestigation.getResultType(),"m") %>>Text
				Area</option>
				<option value="t"
					<%=HMSUtil.isSelected(dgMasInvestigation.getResultType(),"t") %>>Text</option>
				<option value="r"
					<%=HMSUtil.isSelected(dgMasInvestigation.getResultType(),"r") %>>Range</option>
			</select></td>
			<td><select name="<%=COMPARISON_TYPE %>"
				id="<%=COMPARISON_TYPE%><%=inc %>" class="large" tabindex=1
				validate="Comparison Type,string,no" onclick="normal(<%=inc %>);">
				<option value="0">Select</option>
				<option value="n"
					<%=HMSUtil.isSelected(dgMasInvestigation.getComparisonType(),"n")%>>None</option>
				<option value="f"
					<%=HMSUtil.isSelected(dgMasInvestigation.getComparisonType(),"f") %>>Fixed
				Values</option>
				<option value="v"
					<%=HMSUtil.isSelected(dgMasInvestigation.getComparisonType(),"v") %>>Normal
				Values</option>
			</select> <% for(int j=1;j<=5;j++){
%> <input type="hidden" value="0" name="<%=SEX%>"
				id="<%=SEX%><%=inc%><%=j%>" /> <input type="hidden" value="0"
				name="<%=FROM_AGE%>" id="<%=FROM_AGE %><%=inc%><%=j%>" /> <input
				type="hidden" value="0" name="<%=TO_AGE%>"
				id="<%=TO_AGE %><%=inc%><%=j%>" /> <input type="hidden" value="0"
				name="<%=MIN_NORMAL_VALUE %>"
				id="<%=MIN_NORMAL_VALUE%><%=inc%><%=j%>" /> <input type="hidden"
				value="0" name="<%=MAX_NORMAL_VALUE %>"
				id="<%=MAX_NORMAL_VALUE%><%=inc%><%=j%>" /> <input type="hidden"
				value="0" name="<%=NORMAL_VALUE %>"
				id="<%=NORMAL_VALUE%><%=inc%><%=j%>" /> <%} %>
			</td>
			<%}
inc++;
}%>


			<%}%>
		</tr>
	</tbody>
	<input type="hidden" class="medcaption" name=<%=STATUS%> value="y"
		id="status" />
</table>

</div>

<div class="division"></div>
<div class="bottom"><input type="button" class="button"
	value="Update" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showUpdateSubTest');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp');" /></div>

</form>
</div>