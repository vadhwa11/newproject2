<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<!-- 
Include the WYSIWYG javascript files
-->
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>
<%String fileData=""; %>
<script type="text/javascript"><!--
function updateTemplate(){
 WYSIWYG.updateTextArea('abc');
var templateData =document.getElementById("abc").value;




submitForm('chargeCode','investigation?method=updateTemplate');

}
function submitTemplate(){
	WYSIWYG.updateTextArea('abc');
	var templateData =document.getElementById("abc").value;
	submitForm('chargeCode','investigation?method=submitTemplate&submitFirstTime=y');
}
function see()
{document.chargeCode.method="post";
fName=document.getElementById("upload").value;
var extension =fName.substring(fName.length-4);
if(fName !=""){
if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
{	
//alert("Uploaded Document can only be in .txt or .TXT format\n");
//return false;
}
var updatedtemplate= document.chargeCode.test2.value;
document.chargeCode.browse.value="browse";
submitForm('chargeCode','investigation?method=getFileName&browse=browse'); 
}
return true;
}

function callback(http_request) {
if (http_request.readyState == 4 || http_request.readyState=="complete") {
alert('http_request.responseText'+http_request.responseText);
alert(document.getElementById("abc").value)
document.getElementById('abc').value=http_request.responseText;
}
}
</script>
<script type="text/javascript">
function openHelpPage(){
 window.location.href='lab?method=showTemplateHelpJsp';
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	session.setAttribute("map",map);
}
if(map.get("message") != null)
{
 	 String message = (String)map.get("message");
%>
 <h4><%=message %></h4>
 <div class="clear"></div>
<%} 


int mainChargecodeId=0;
int subChargeCodeId=0;
int chargeCodeId=0; String chargeCodeName="";
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
String appendedHtml="";
int collectionCenterId =0;
int pageNoTemp = 0;
if(map.get("investigationName") != null){
	investigationName =(String) map.get("investigationName");
}
if(map.get("confidential") != null){
	confidential =(String) map.get("confidential");
	
}
if(map.get("appendedHtml") != null){
	appendedHtml =(String) map.get("appendedHtml");
	
}

if(map.get("investigationType") != null){
	investigationType =(String) map.get("investigationType");
}
if(map.get("dischargeSummary") != null){
	dischargeSummary =(String) map.get("dischargeSummary");
}
if(map.get("pageNoTemp") != null){
	pageNoTemp =(Integer) map.get("pageNoTemp");
}
if(map.get("sampleId") != null){
	sampleId =(Integer) map.get("sampleId");
	}

if(map.get("collectionCenterId") != null){
	collectionCenterId =(Integer) map.get("collectionCenterId");
	}
String quantity ="";
if(map.get("quantity") != null){
	quantity =(String) map.get("quantity");
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
%>
<h6>Template</h6>
<div class="Clear"></div>
<form name="chargeCode" enctype="multipart/form-data" method="post"
	action=""><input type="hidden" name="<%=POJO_NAME%>"
	value="DgMasInvestigation"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME%>" value="InvestigationName"> <input
	type="hidden" name="<%=JSP_NAME %>" value="investigationSubTest">
<input type="hidden" name="pojoPropertyCode" value="InvestigationCode">

<input type="hidden" id="<%=MAIN_CHARGECODE_ID %>"
	name="<%=MAIN_CHARGECODE_ID %>" value="<%=mainChargecodeId%>">
<input type="hidden" id="<%=SUB_CHARGECODE_ID %>"
	name="<%=SUB_CHARGECODE_ID %>" value="<%=subChargeCodeId%>"> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=chargeCodeId%>"> <input type="hidden"
	id="<%=INVESTIGATION_NAME %>" name="<%=INVESTIGATION_NAME %>"
	value="<%= investigationName%>"> <%
%> <input type="hidden" id="<%=INVESTIGATION_TYPE %>"
	name="<%=INVESTIGATION_TYPE %>" value="<%=investigationType%>">
<input type="hidden" id="<%=DSICHARGE_SUMMARY %>"
	name="<%=DSICHARGE_SUMMARY %>" value="<%= dischargeSummary%>">
<input type="hidden" id="<%=CONFIDENTIAL %>" name="<%=CONFIDENTIAL %>"
	value="<%= confidential%>"> <input type="hidden"
	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>">
<input type="hidden" id="<%=QUANTITY %>" name="<%=QUANTITY %>"
	value="<%=quantity %>"> <input type="hidden"
	id="pageNoTempFromBackButton" name="pageNoTempFromBackButton"
	value="<%=pageNoTemp%>" /> <input type="hidden"
	id="<%=COLLECTION_CENTER_ID %>" name="<%=COLLECTION_CENTER_ID %>"
	value="<%=collectionCenterId %>"> <input type="hidden"
	id="browse" name="browse" value="" /> <input type="hidden"
	id="alreadySavedOrNot" name="alreadySavedOrNot" value="" />
<div class="Block">
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
	%> <label>Department</label> <input type="text"
	name="<%=MAIN_CHARGECODE_NAME %>" id="<%=MAIN_CHARGECODE_NAME %>"
	value="<%=masMainChargecode.getMainChargecodeName() %>"
	readonly="readonly" /> <% 	}}
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
	readonly="readonly" /> <% 	}}
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
	%> <label>Test Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" readonly="readonly" /> <% 	}}
}
%>
<div class="clear"></div>
<label>Result</label> <input type="file" id="upload"
	name="<%=UPLOAD_FILENAME%>" class="Browse" size="50" onchange="see()" />
	<div class="clear"></div>
	</div>
<h3><a href="lab?method=showTemplateHelpJsp"
	title="Help For Template Upload">Help</a></h3>

<div class="Clear"></div>
<div id="rtf">
<!--Rich text editor-->
<table border="0" cellpadding="2" cellspacing="0" width="100%">
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td><textarea id="abc" name="test2" value=""
					class="tableTextareaEditor" />
  
  <%if(map.get("templateList")!=null){
	  String templateData="";
	  List<DgTemplate>templateList1=(List<DgTemplate>)map.get("templateList");
	  int listSize=((List<DgTemplate>)map.get("templateList")).size();
		DgTemplate dgTemplate=((List<DgTemplate>)map.get("templateList")).get(listSize-1);
	  templateData= new String  (dgTemplate.getResult());
	  %>
	<%=templateData %>
  <%}else if(map.get("browse")!=null){
%>
   <jsp:include page="/temp/temp.html" flush="true" />
  <%} %>
  </textarea></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml %></textarea></div>
	</div>
	<div class="clear"></div>
<!--Rich text editor ends--> <% if(map.get("templateList")!=null){
	int listSize=((List<DgTemplate>)map.get("templateList")).size();
	DgTemplate dgTemplate=((List<DgTemplate>)map.get("templateList")).get(listSize-1);
	int templateId=dgTemplate.getId();
%> <input type="hidden" name="<%=TEMPLATE_ID %>" value="<%=templateId %>" id="<%=TEMPLATE_ID %>" /> 
   <input type="button" class="cmnButton" value="update" align="left" onClick="updateTemplate();" /> 
    <% }else{%> 
   <input type="button"	class="cmnButton" value="Submit" align="left" onClick="submitTemplate();" /> 
    <% }%> 
    <input type="button" class="cmnButton" value="Back" align="left" onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp&pageNoTempFromBackButton='+<%=pageNoTemp%>);" />

</form>
