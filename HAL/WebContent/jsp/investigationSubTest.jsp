<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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

<script>
function resultTypeee(rowVal){
var rt = document.getElementById('resultType'+rowVal).value;
if(rt == "h"){
	document.getElementById('comparisonType'+rowVal).value='n'
}
return true;
}
</script>
<%

	Map<String, Object> map = new HashMap<String, Object>();
	ArrayList<MasSample> sampleList = new ArrayList<MasSample>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	String message = "";
	if(map.get("message") != null)
	{
 		 message = (String)map.get("message");	
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
	
	if(map.get("sampleList")!=null){
		sampleList=(ArrayList)map.get("sampleList");	
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
		int collectionCenterId =0;
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
		if(map.get("collectionCenterId") != null){
			collectionCenterId =(Integer) map.get("collectionCenterId");
			
		}
		int pageNoTemp = 0;
		if(map.get("pageNoTemp") != null){
			pageNoTemp =(Integer) map.get("pageNoTemp");
		}

		String quantity ="";
		if(map.get("quantity") != null){
			quantity =(String) map.get("quantity");
		}
		int pageNo=0;
		if(map.get("pageNo") != null)
		{
		pageNo=(Integer)map.get("pageNo");
		}
		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		if(map.get("subInvestigationlist") != null){
			subInvestigationlist =  (List<DgSubMasInvestigation>)map.get("subInvestigationlist");
		}
				
		
	
%>
<script>
function normal(rowNo,subTestId,chargeCodeId){
if(document.getElementById('comparisonType'+rowNo).value == "v"){

get_value(rowNo,subTestId,chargeCodeId);

}
else if(document.getElementById('comparisonType'+rowNo).value == "f"){
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
function checkFilledRow(){
	var msg ="";
	if(document.getElementById('orderNo1').value ===""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  	}
	  else{
	  	return true ;
	  }
	 }
</script>
	<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Diagnostic Sub Parameter</h2></div>
<div class="Clear"></div>

<form name="chargeCode" method="post"><input type="hidden"
	name="<%= POJO_NAME %>" value="DgMasInvestigation"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="InvestigationName">
<input type="hidden" name="<%=JSP_NAME %>" value="investigationSubTest">
<input type="hidden" name="pojoPropertyCode" value="InvestigationCode">
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
<div class="Block"><label>Department Name</label> <input
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
	value="<%= confidential%>"> <!--  <input type="hidden" id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>" > -->
<input type="hidden" id="<%=COLLECTION_CENTER_ID %>"
	name="<%=COLLECTION_CENTER_ID %>" value="<%=collectionCenterId %>">
<input type="hidden" id="<%=QUANTITY %>" name="<%=QUANTITY %>"
	value="<%=quantity %>"> <input type="hidden" name="pageNo"
	id="pageNo" value="<%=pageNo%>" /> <% 	}}
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
	%> <label>Modality</label> <input type="text"
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
	%> <label>Investigation Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" readonly="readonly" /> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=masChargeCode.getId() %>"> <% 	}}
}
%>
</div>



<div class="division"></div>

<table width="100%" colspan="0" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<tr>
		<th>Print Order </th>
		<th>Sub Test Code</th>
		<th>Sub Test Name</th>
		<!-- <th>Sample</th> -->
		<th>Unit</th>
		<th>Result Type</th>
		<th>Comparison Type</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>

	<%
    	
    	int temp=0;
    	int inc = 1;    	
    	//for(inc=1;inc<=12;inc++){
    		if(subInvestigationlist.size() >0 && inc-1 < subInvestigationlist.size() ){
    			for(DgSubMasInvestigation dgInv : subInvestigationlist){
    	%>

	<tr>
		<td width="2%">
		<input type="hidden" value="<%=dgInv.getId() %>" name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID %><%=inc %>" /> 
		<input type="hidden" id="chargeCodeId<%=inc %>" name="chargeCodeId"	value="<%=dgInv.getChargeCode().getId() %>"> 
		<input type="hidden" value="<%=temp+inc%>" id="<%=SR_NO %>"	name="<%=SR_NO%>" /> 
		<input type="text" size="2"	value="<%=dgInv.getOrderNo() %>" name="<%=ORDER_NO%>"	id="orderNo<%=inc %>" disabled="disabled" maxlength="4"	validate="Order No,int,no" tabindex=1 />
		</td>

		<td>
		<input type="text" size="8"	value="<%=dgInv.getSubInvestigationCode() %>"	name="<%=SUBTEST_CODE%>" id="subTestCode<%=inc %>"	disabled="disabled" validate="Sub test code,string,no" maxlength="8"	tabindex=1 />
		</td>

		<td>
		<input type="text"	value="<%=dgInv.getSubInvestigationName() %>"	name="<%=SUBTEST_NAME%>" id="<%=SUBTEST_NAME%><%=inc %>"	validate="Sub test name,string,no" maxlength="30" disabled="disabled"	tabindex=1 />
		</td>

		<%-- <td><select id=<%=SAMPLE_ID %> name="<%=SAMPLE_ID %>"	disabled="disabled" validate="Sample,string,no" tabindex=1>
			<option value="0">Select</option>
			<% 
				for (MasSample sample : sampleList){
					if(dgInv.getSample()!=null){
						if(dgInv.getSample().getId().equals(sample.getId())){
				%>
			<option value="<%=sample.getId ()%>" selected="selected"><%=sample.getSampleDescription()%></option>
			<%		}else{%>
			<option value="<%=sample.getId ()%>"><%=sample.getSampleDescription()%></option>
			<%}
					}
			   }%>
		</select></td> --%>

		<td><select id="unitName" name="<%=UNIT_OF_MEASUREMENT_ID %>"	validate="Unit,string,no" disabled="disabled" tabindex=1>
			<option value="">Select</option>
			<%

			for (DgUom dgUom : uomList){
				if(dgInv.getUom() != null){
					if (dgInv.getUom().getId().equals(
						dgUom.getId())) {
					%>
			<option value=<%=dgUom.getId()%> selected="selected"><%=dgUom.getUomName()%></option>
			<%
					} else {
					%>
			<option value=<%=dgUom.getId()%>><%=dgUom.getUomName()%></option>
			<%
					}
				}
			}
		%>
		</select>
		</td>

		<td>
		<select name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %><%=inc %>" tabindex=1	disabled="disabled" validate="Result Type,string,no">
			<option value="0">Select</option>

			<option value="h" <%=HMSUtil.isSelected(dgInv.getResultType(),"h")%>>Heading</option>
			<option value="s" <%=HMSUtil.isSelected(dgInv.getResultType(),"s") %>>Single
			Parameter</option>
			<option value="m" <%=HMSUtil.isSelected(dgInv.getResultType(),"m") %>>Text
			Area</option>
			<option value="t" <%=HMSUtil.isSelected(dgInv.getResultType(),"t") %>>Text</option>
			<option value="r" <%=HMSUtil.isSelected(dgInv.getResultType(),"r") %>>Range</option>
		</select>
		</td>
		<td>
		<select name="<%=COMPARISON_TYPE %>" id="<%=COMPARISON_TYPE%><%=inc %>" tabindex=1	validate="Comparison Type,string,no" >
			<option value="0">Select</option>
			<option value="n"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"n")%>>None</option>
			<option value="f"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"f") %>>Fixed
			Values</option>
			<option value="v"
				<%=HMSUtil.isSelected(dgInv.getComparisonType(),"v") %>>Normal
			Values</option>
		</select>
		<input name="add" type="button" class="buttonAuto" value="Go" onclick="normal(<%=inc %>);" tabindex="1" /> 
		
		
		</td>
			<td>
		<input name="add" type="button" class="buttonAdd" value="" onclick="generateRow('chargeDetails');" tabindex="1" /> 
		</td>
		<td>
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('chargeDetails',this);"  />
		</td>
	</tr>
	<%inc++;}}else{ 
  %>
	<tr>
		<td width="2%"><input type="hidden"
			value="addOnlyInSubMasInvesrigation" id="addInSubMas"
			name="addInSubMas" /> <input type="hidden" value="<%=temp+inc%>"
			id="<%=SR_NO %>" name="<%=SR_NO%>" /> <input type="text" size="2"
			value="" name="<%=ORDER_NO%>" id="orderNo<%=inc %>" maxlength="4"
			validate="Order No,int,no" tabindex=1 /></td>

		<td><input type="text" size="8" value="" name="<%=SUBTEST_CODE%>"
			id="subTestCode<%=inc %>" validate="Sub test code,string,no"
			maxlength="8" tabindex=1 /></td>

		<td width="7%"><input type="text" value=""
			name="<%=SUBTEST_NAME%>" id="<%=SUBTEST_NAME%><%=inc %>"
			validate="Sub test name,string,no" maxlength="30" tabindex=1 /></td>


		<%-- <td width="7%"><select id=<%=SAMPLE_ID %> name="<%=SAMPLE_ID %>"
			validate="Sample,string,no" tabindex=1>
			<option value="0">Select</option>
			<% 
				for (MasSample sample : sampleList){
				%>
			<option value="<%=sample.getId ()%>"><%=sample.getSampleDescription()%></option>
			<%}%>
		</select></td> --%>

		<td><select id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
			name="<%=UNIT_OF_MEASUREMENT_ID %>" validate="Unit,string,no"
			tabindex=1>
			<option value="">Select</option>
			<% 
				for (DgUom dgUom : uomList){
				%>
			<option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
			<%}%>
		</select></td>

		<td><select name="<%=RESULT_TYPE %>" 
			id="resultType<%=inc %>" tabindex=1 validate="Result Type,string,no"
			onchange="resultTypeee(<%=inc %>);">
			<option value="">Select</option>
			<option value="h">Heading</option>
			<option value="s">Single Parameter</option>
			<option value="m">Text Area</option>
			<option value="t">Text</option>
			<option value="r">Range</option>
		</select></td>
		<td><select name="<%=COMPARISON_TYPE %>"
			id="<%=COMPARISON_TYPE%><%=inc %>" tabindex=1
			validate="Comparison Type,string,no">
			<option value="">Select</option>
			<option value="n">None</option>
			<option value="f">Fixed Values</option>
			<option value="v">Normal Values</option>
		</select>
		<input name="add" type="button" class="buttonAuto" value="Go" onclick="normal(<%=inc %>);" tabindex="1" /> 
		
		</td>
		<td>
		<input name="add" type="button" class="buttonAdd" value="" onclick="generateRow('chargeDetails');" tabindex="1" /> 
		</td>
		<td>
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('chargeDetails',this);"  />
		</td>
	</tr>

	<%//}
    		} %>

</table>
	<input type="hidden" class="medcaption" name=<%=STATUS%> value="y"
		id="status" />
<%
	if(subInvestigationlist.size() == 0){
%>
<div class="division"></div>
<input type="hidden"
	id="pageNoTempFromBackButton" name="pageNoTempFromBackButton"
	value="<%=pageNoTemp%>" /> <input type="button" class="button"
	value="Submit"
	onClick="if(checkFilledRow()){submitForm('chargeCode','investigation?method=submitSubTest');}" />
<input type="button" class="button" value="Back" 
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp');" />

<% }%>

<script type="text/javascript">

function generateRow(idName) {
	
	var d=document.getElementById(idName).getElementsByTagName("tr");
	lastTr = d[d.length-1]
	clone = lastTr.cloneNode(true);
	clone.id = parseInt(lastTr.id);
	lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
	var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
	tblCtrl[1].value=d.length-1;
	for(var i=0;i<tblCtrl.length;i++){
		if(tblCtrl[i].type!='button'){
			tblCtrl[i].value="";
		}
		
		var fieldId = tblCtrl[i].id.substring((tblCtrl[i].id).length-1);
		if(tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='subTestName' || tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='resultType' || tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='comparisonType'){
			
			tblCtrl[i].id = tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)+(parseInt(fieldId)+1);
		}
		if(tblCtrl[i].type=='button'){
			tblCtrl[i].disabled=false;
		}
		
	}
	var tblSelCtrl = d[d.length-1].getElementsByTagName("select"); 
	for(var i=0;i<tblSelCtrl.length;i++){
		var fieldId = tblSelCtrl[i].id.substring((tblSelCtrl[i].id).length-1);
		if(tblSelCtrl[i].id.substring(0,(tblSelCtrl[i].id).length-1)=='subTestName' || tblSelCtrl[i].id.substring(0,(tblSelCtrl[i].id).length-1)=='resultType' || tblSelCtrl[i].id.substring(0,(tblSelCtrl[i].id).length-1)=='comparisonType'){
			
			tblSelCtrl[i].id = tblSelCtrl[i].id.substring(0,(tblSelCtrl[i].id).length-1)+(parseInt(fieldId)+1);
		}
		tblSelCtrl[i].value ="0"
			tblSelCtrl[i].value =""
	}
}
	
function removeRow(idName,obj)
{
	var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
}


</script>

</form>
