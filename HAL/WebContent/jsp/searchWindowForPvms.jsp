<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
html,body {
	overflow: auto;
}

.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	String nomenclature = "";
	String pvms_no = "";
	int hospitalId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	Vector mmfTItems = new Vector();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	int currentPage=1;
	String tender_no;
	int currentYear=0;
	 List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		
		System.out.println("map " + map);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int mmfMasterId = 0;
	String storeType="";
	if(map.get("itemList")!=null){
		itemList=(List<MasStoreItem>)map.get("itemList");
		System.out.println("item List in jsp"+itemList.size());
		}
	if (map.get("pagedArray") != null)
	{
	pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
		System.out.println("itemIdForNextRecord------------------in jsp department indent addition------------"+itemIdForNextRecord);
	}
	
	if(pagedArray!=null){
		if((Integer)pagedArray.getCurrentPage()!=null){
			currentPage=pagedArray.getCurrentPage();
		}
	}
	if (map.get("itemField") != null && map.get("itemField") != "")
	{
		nomenclature = (String) map.get("itemField");
		System.out.println("nomenclature:::::::::"+nomenclature);
	}
	if (map.get("pvmsNoField") != null && map.get("pvmsNoField") != "")
	{
	    pvms_no = (String) map.get("pvmsNoField");
	    System.out.println("pvms:::::::::"+pvms_no);
	}
	
  	
%>

<title>Result For Pvms Nomenclature Search</title>


<script>

function goPage(pidx) {	
	document.searchForm.currPage.value = pidx;
	searchForm.method="post";
	var nomenclature = document.getElementById('nomenclatureSearch1').value;
	var pvms = document.getElementById("pvmsSearch").value;
	submitForm('searchForm','tender?method=searchForExistingNomenclature&requiredField='+nomenclature+'&pvmsNo='+pvms+'&numOfRows=8&currPage='+pidx+'');
}

function passNomenclatureHiddenField(pvms,itemId){
document.getElementById("pvms1").value=pvms;
document.getElementById("itemId").value=itemId;
}
function jsAdd()
{
	searchForm.method="post";
	var	pvms=document.getElementById("pvms1").value
	if(pvms1 != ""){
		
	var tenderId=document.searchForm.<%=TENDER_NO%>.value;
	
	var noteNo=document.searchForm.<%=TENDER_LPO_NOTE_NO%>.value;
	
	var notePeriod=document.searchForm.<%=TENDER_LPO_NOTE_PERIOD%>.value;
	
	var noteDate=document.searchForm.<%=TENDER_LPO_NOTE_DATE%>.value;
	
	var tenderlpooic=document.searchForm.<%=TENDER_LPO_OIC%>.value;

	var itemId=document.getElementById("itemId").value;
	
	var currPage=document.searchForm.currPage.value;
	var numOfRows=document.searchForm.numOfRows1.value;
	if(currPage=="undefined"){
	currPage=1;
	numOfRows=8;
	}
	if(numOfRows=="undefined"){
	currPage=1;
	numOfRows=8;
	}
	
	
 window.opener.location.href ="tender?method=showLPONoteJspWithGridData&<%=TENDER_LPO_OIC%>="+tenderlpooic+"&<%=TENDER_LPO_NOTE_PERIOD%>="+notePeriod+"&<%=TENDER_LPO_NOTE_NO%>="+noteNo+"&<%=TENDER_NO%>="+tenderId+"&<%=TENDER_LPO_NOTE_DATE%>="+noteDate+"&numOfRows="+numOfRows+"&currPage="+currPage+"&itemId="+itemId+"&fromSearch=true"; 
}
  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	 	 } 
	  window.close(); 		
		
		 
}
function ajaxFunctionForAutoCompleteInLPO(formName,action) {
 
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4)
      {
		obj = document.getElementById("suppliers");
		obj.length = 1;
		
      	var suppliers =xmlHttp.responseXML.getElementsByTagName('suppliers')[0];
    	if(suppliers.childNodes.length!=0){
    	
      	for (loop = 0; loop < suppliers.childNodes.length; loop++) 
      	{
	   	    var supplier = suppliers.childNodes[loop];
	        var id  = supplier.getElementsByTagName("supplierId")[0];
	        var supplierName = supplier.getElementsByTagName("supplierName")[0];
        	obj.length++;
			obj.options[obj.length -2].value=id.childNodes[0].nodeValue;
			obj.options[obj.length -2].text=supplierName.childNodes[0].nodeValue;
	    } 
      }
      else{
      alert("No suppliers for This Item");
      return;
      }
      }
    }
    
   	 var url=action
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function populateSupplier1(val)
{

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    obj = document.getElementById("suppliers");
	   
		obj.length = 1;
		var itemId=document.getElementById("itemId").value;
		alert("itemId"+itemId);
	    if (itemId!="")
	
ajaxFunctionForAutoCompleteInLPO('searchForm','/hms/hms/tender?method=populateSupplierInTenderLPO&pvms=' + pvms + '&tenderId=' + document.getElementById("tenderId").value + '&deptId=' + document.getElementById("deptId").value);	 	
}					
	


</script>

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>
<div id="contentHolder">

<h6>Result For Pvms Nomenclature Search</h6>
<div class="Clear"></div>




<form name="searchForm"><input type="hidden" name="numOfRows"
	size="5" value="15"> <input type="hidden" name="pageCount"
	size="5" value="10"> <input type="hidden" name="search"
	size="5" value="true"> <input type="hidden" name="tenderId"
	value="<%=box.get("tenderId")%>" /> <input type="hidden" name="deptId"
	value="<%=box.get("deptId")%>" /> <input type="hidden"
	name="<%=TENDER_LPO_NOTE_NO%>"
	value="<%=box.getInt(TENDER_LPO_NOTE_NO)%>" /> <input type="hidden"
	name="<%=TENDER_LPO_NOTE_DATE%>"
	value="<%=box.get(TENDER_LPO_NOTE_DATE)%>" /> <input type="hidden"
	name="currPage" value="<%=box.getInt("currPage")%>" /> <input
	type="hidden" name="numOfRows1" value="<%=box.getInt("numOfRows")%>" />
<input type="hidden" name="<%=TENDER_LPO_NOTE_PERIOD%>"
	value="<%=box.getString(TENDER_LPO_NOTE_PERIOD)%>" /> <input
	type="hidden" name="<%=TENDER_LPO_OIC%>"
	value="<%=box.getInt(TENDER_LPO_OIC)%>" /> <input type="hidden"
	id="nomenclature1" name="nomenclature" value="" /> <input
	type="hidden" id="pvmsSearch" name="pvmsSearch" value="<%=pvms_no%>" />
<input type="hidden" id="nomenclatureSearch1" name="nomenclatureSearch1"
	value="<%=nomenclature%>" /> <input type="hidden" id="pvms1"
	name="pvms" value="" /> <input type="hidden" id="itemId" name="ItemId"
	value="" /> <input type="hidden" value="<%=box.getInt(TENDER_NO) %>"
	name="<%=TENDER_NO%>" />
<div id=suppDiv style="visibility: hidden"><select
	name="<%=TENDER_LPO_SUPPLIER_ID%>" id="suppliers">
</select></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %> <%
	if (pagedArray == null) {
		%>
<div class="Clear"></div>
<div class="blockTitle">Results for nomenclature</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="85%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="35%">Nomenclature</th>
			<th width="20%">A/U</th>
			<th width="15%">ADD</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=13 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<%  } else { %>
<div class="Clear"></div>


<div class="blockTitle">Results for nomenclature</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="75%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="35%">Nomenclature</th>
			<th width="20%">A/U</th>
			<th width="15%">ADD</th>
		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_LPO_SRNO%>" size="3" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_PVMS_NO)%>" size="10"
				name="<%=TENDER_LPO_PVMS_NO%>" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value='<%=gridData[i].get(TENDER_LPO_NOMENCLATURE)%>' size="50"
				name="<%=TENDER_LPO_NOMENCLATURE%>" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_LPO_AU)%>" size="10"
				name="<%=TENDER_LPO_AU%>" readonly="readonly" /></td>
			<td><input type="checkbox" name="masStoreId" value=""
				onclick="javascript:passNomenclatureHiddenField('<%=gridData[i].get(TENDER_LPO_PVMS_NO)%>','<%=gridData[i].get("itemId")%>');"></td>
			<td><input type="hidden" name="item_id"
				value="<%=gridData[i].get("itemId") %>"
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<input type="button" name="Add" onClick="jsAdd();" value="Add"
	class="button" />
<div class="Clear"></div>
<% } %>
</form>
</div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
