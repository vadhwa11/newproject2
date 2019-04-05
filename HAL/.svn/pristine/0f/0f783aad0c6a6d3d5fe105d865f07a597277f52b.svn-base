<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
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
<style>
html,body {
	overflow: auto;
}
</style>
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
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
    String boxmessage = "";
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
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
	int groupId = 0;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	int deptId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	String message = "";
	boolean show = false;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		groupId = (Integer) map.get("groupId");
		
		if(map.get("message") != null){
			message = (String) map.get("message");
		}
		System.out.println("map " + map);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
		System.out.println("itemIdForNextRecord------------------in jsp tender item addition------------"+itemIdForNextRecord);
	}
	
	if(map.get("show") != null){
		 show = (Boolean)map.get("show");
	}
%>

<title>Tender Creation</title>
<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
  
	document.tenderForm.currPage.value = pidx;
	document.tenderForm.method="post";
	
	
		submitForm('tenderForm','stores?method=showPendingDefectiveItemsJsp');
	
}

function jsSubmit()
{
		if (tenderForm.pvms.value == "" &&  tenderForm.search_text.value=="")
		{
		alert("Either Nomenclature or PVMS No should be entered!...");
		return;
		}
		tenderForm.method="post";
		submitForm('tenderForm','tender?method=showAddTenderItemsJsp&currPage=1&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
}

function validateAddButton()
{
	if (tenderForm.<%=ITEMS_TO_BE_ADDED%> && tenderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < tenderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (tenderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (tenderForm.<%=ITEMS_TO_BE_ADDED%> && tenderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
		if (validateAddButton())
		{
			tenderForm.method="post";
			var itemIdForNextRecord=document.tenderForm.itemIdForNextRecord.value;
			var hiddenFieldForRecords=document.tenderForm.hiddenFieldForRecords.value;
		//alert("jsAdd value of itemIdForNextRecord----"+itemIdForNextRecord)
			if(hiddenFieldForRecords =="true"){
				submitForm('tenderForm','tender?method=doAddTenderItems&itemIdForNextRecord='+ itemIdForNextRecord +'&hiddenFieldForRecords=true&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
			}else{
				submitForm('tenderForm','tender?method=doAddTenderItems&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
			}
				
		}
		else
		{
		alert('No Item(s) Selected to Add!....');
		}
		
}
	function callNext()
		{
		if(validateNextRecordButton()){
		tenderForm.method="post";
		submitForm('tenderForm','tender?method=showAddTenderItemsJspForNextRecords&buttonName=next&currPage=0&groupId='+document.getElementById('groupId').value+'&showAll='+document.getElementById('showAll').checked);
		}
		
	}
				function validateNextRecordButton()
						{
						//for(var i = 0; i < document.getElementsByName('itemId').length; i++){
						//alert("document.getElementsByName('itemId').length"+document.getElementsByName('itemId').length +"document.getElementsByName('itemId')[i].value------"+document.getElementsByName('itemId')[i].value)
						//alert("document.getElementsByName('tender_item_id').length----"+document.getElementsByName('tender_item_id').length)
						if(document.getElementsByName('tender_item_id').length==0){
							alert("Please Go to previous Record and then Click for next 1000 records.")
							return false;
						}else{
						   return true; 
						   }
			            }  
function jsClose()
{
 var groupId = document.getElementById('groupId').value;
 if (tenderForm.<%=TENDER_NO%>.value!="")
  window.opener.location.href = "tender?method=showTenderCreationJspWithGridData&<%=TENDER_NO%>="+tenderForm.<%=TENDER_NO%>.value;
 else
  window.opener.location.href = "tender?method=showTenderProposalJsp&groupId="+groupId;
 

  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}

function showAllMMF(){
	//alert(":status::::::::"+document.getElementById('showAll').checked)
	var groupId = document.getElementById('groupId').value;
	tenderForm.currPage.value = "1";
	tenderForm.method="post";
	submitForm('tenderForm','tender?method=showAddTenderItemsJsp&groupId='+groupId+'&showAll='+document.getElementById('showAll').checked);
		}

</script>

<form name="tenderForm" action="" method="post">
<h2>  DEFECTIVE DRUGS LIST (PENDING FOR DISPOSAL)</h2>

<div class="Clear"></div>



<div class="Clear paddingTop15"></div>


<%		
		if (pagedArray == null) {
		%>


<div class="clear"></div>
<h4>Item Details</h4>

<div class="Clear"></div>

<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Select</th>
			<th width="5%">Sl No.</th>
			<th width="9%">Nomenclature</th>
			<th>A/U</th>
			<th width="9%">Manufacturer</th>
			<th width="9%">B/G</th>
			<th width="9%">Quantity</th>
			<th>Batch</th>
			<th width="9%">DOM</th>
			<th width="9%">DOE</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center"><%=message %></td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="button" name="Close" onClick="jsClose()" value="Close"	class="button" />
<div class="Clear"></div>
<%  } else { %>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="Clear"></div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<div class="cmntable">
<table align="center" width="100%" colspan="7" class="grid_header" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<th>Select</th>
			<th width="5%">Sl No.</th>
			<th width="9%">Nomenclature</th>
			<th>A/U</th>
			<th width="9%">Manufacturer</th>
			<th width="9%">B/G</th>
			<th width="9%">Quantity</th>
			<th>Batch</th>
			<th width="9%">DOM</th>
			<th width="9%">DOE</th>

		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td>
			<input type="checkbox" name="storeDefctDrugMId" value="<%=gridData[i].get("storeDefctDrugMId")%>">
			
			<td>
			<input type="hidden"
				value="<%=gridData[i].get("storeDefctDrugMId")%>"
				name="drugId" />
				<input type="hidden"
				value="<%=gridData[i].get("stockId")%>"
				name="stockId" />
			<input type="text" value="<%=iFirstRow++%>" size="3"
				name="<%=TENDER_SRNO%>" readonly="readonly" />
			
				
			</td>
			
			
				
			
			<td><input type="text"
				value="<%=gridData[i].get("nomenclature" )%>" size="50"
				name="nomenclature" readonly="readonly" /></td>
				
			<td><input type="text"
				value="<%=gridData[i].get("au")%>" size="10"
				name="au" readonly="readonly" /></td>
				
			<td><input type="text" value="<%=gridData[i].get("manufacturer")%>"
				name="manufacturer" size="10" readonly="readonly" /></td>
				
				
			<td><input type="text"
				value="<%=gridData[i].get("brand")%>" name="brand" size="10"
				readonly="readonly" />
				
				</td>
				
				
			<td><input type="text"
				value="<%=(gridData[i].get("defectQty")==null)?"0.000":gridData[i].get("defectQty")%>"
				name="defectQty" size="10" readonly="readonly" />
				
				</td>
				
				
			<td><input type="text"
				value="<%=gridData[i].get("batchNo")%>"
				name="batchNo" readonly="readonly" size="10" />
				
				</td>
				
			<td><input type="text"
				value="<%=(gridData[i].get("dom")==null)?" ":gridData[i].get("dom")%>"
				name="dom" size="10"
				 /></td>
			
		
		<td><input type="text"
				value="<%=(gridData[i].get("doe")==null)?" ":gridData[i].get("doe")%>"
				name="doe" size="10"
				 /></td>

			
			
		</tr>
		<% } %>
	</tbody>
</table>
</div>


<input type="button" name="Add"	value="SUBMIT" class="button" onclick="submitForm('tenderForm','stores?method=submitPendingDefectiveItemsJsp');"  />

<div class="Clear"></div>
</form>
</div>
<%}%>

