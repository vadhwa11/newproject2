<%@page import="java.util.*"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreSetup"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreLoanoutExpendT"%>
<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
//<!--
//var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
//var IMGDIR_MISC = "images/misc";
//var vb_disable_ajax = parseInt("0", 10);
 //-->
function isDispenserySelected()
	{
		//alert(document.getElementById('departmentId').value);
		if(document.getElementById('departmentId').value=="")
		{
			alert("Department Not Selected!")
			return false;
		}
		else
		{
			submitProtoAjax('issueDispensaryForm','stores?method=getDemandList&departmentIdTemp='+document.getElementById('departmentId').value);
			return true;
		}
	}
	function confirm1()
	{
	formName="issueDispensaryForm";
	obj = eval('document.'+formName);
	var test = false;
	if((document.getElementById('departmentIdTemp').value != ""))
	{
	if(document.getElementById('requestNo').value != ""){
       test = true;
    }else{
    	alert("Pl. select Demand No!.........")
		return false;
    }
    }
	else
	{
		alert("Pl. check the Input Values!.........")
		return false;
	}
	if(test){
	  if(confirm("Are You sure, You want to import Demand items for issue?")){
        obj.action = "/hms/hms/stores?method=searchInternalIndentDetails";
    	obj.submit();
     }	
	}	
}
</script>
 <script>
<%Calendar calendar = Calendar.getInstance();
			String month1 = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date1 = String.valueOf(calendar.get(Calendar.DATE));
			int year1 = calendar.get(calendar.YEAR);
			if (month1.length() < 2) {
				month1 = "0" + month1;
			}
			if (date1.length() < 2) {
				date1 = "0" + date1;
			}%>
	serverdate = '<%=date1 + "/" + month1 + "/" + year1%>'
</script>
<%
	Map map = new HashMap();
	String userName = "";
	String date = "";
	String time = "";
	String deptName = "";
	String Employee_id = "";
	String Employee_name = "";
	int pageNo = 1;
	int indentId = 0;
	int internalIndentId = 0;
	int listSize = 0;
	int issueId = 0;
	String max = "";
	String message = "";
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList = new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<Object[]> indentTList = new ArrayList<Object[]>();
	List<StoreIssueM> searchListForPopup = new ArrayList<StoreIssueM>();
	StoreSetup storeSetup = new StoreSetup();
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	Box box = HMSUtil.getBox(request);
	int requestNoForAcc = 0;
	String demandNoSelected = "";
	if (map.get("requestNoForAcc") != null) {
		requestNoForAcc = (Integer) map.get("requestNoForAcc");
		demandNoSelected = "" + requestNoForAcc;
	}
	System.out.println("demandNoSelected--->"+demandNoSelected);
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	}
	int departmentId = 0;
	if (map.get("departmentId") != null) {
		departmentId = Integer.parseInt("" + map.get("departmentId"));
	}
	if (map.get("employeeList") != null) {
		employeeList = (List) map.get("employeeList");
	}
	int issuedBy = 0;
	if (map.get("issuedBy") != null) {
		issuedBy = (Integer) map.get("issuedBy");
		System.out.println("this is issued id" + issuedBy);
	}
	if(map.get("deptList")!=null){
		deptList=(List<MasDepartment>)map.get("deptList");
	}
	int requestByEmpId = 0;
	if (map.get("requestByEmpId") != null) {
		requestByEmpId = (Integer) map.get("requestByEmpId");
	}
	if (map.get("storeSetup") != null)
		storeSetup = (StoreSetup) map.get("storeSetup");
	if (map.get("storeInternalIndentTList") != null)
		storeInternalIndentTList = (List) map
				.get("storeInternalIndentTList");

	if (map.get("departmentList") != null)
		departmentList = (List) map.get("departmentList");
	if (map.get("masStoreAirForceDepotList") != null)
		masStoreAirForceDepotList = (List) map
				.get("masStoreAirForceDepotList");
	if (map.get("itemList") != null)
		itemList = (List) map.get("itemList");
	if (map.get("internalIndentId") != null) {
		internalIndentId = Integer.parseInt(""
				+ map.get("internalIndentId"));
	}
	//if(map.get("issueTList")!=null){
	//	issueTList=(List)map.get("issueTList");
	//}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("indentTList") != null) {
		indentTList = (List) map.get("indentTList");
		System.out.println("indentTList  " + indentTList.size());
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	List stockList = new ArrayList();
	if (map.get("stockList") != null) {
		stockList = (List) map.get("stockList");
	}
	List loanOutQtyList = new ArrayList();
	if (map.get("loanOutQtyList") != null) {
		loanOutQtyList = (List) map.get("loanOutQtyList");
	}
	int totalPages = 0;
	if (map.get("totalPages") != null) {
		totalPages = (Integer) map.get("totalPages");
	}
	if (storeInternalPendingIndentList != null) {
		storeInternalPendingIndentList = (List) map
				.get("storeInternalPendingIndentList");
	}
	List<Object[]> storeInternalIndentPendingList = new ArrayList<Object[]>();
	if (storeInternalIndentPendingList != null) {
		storeInternalIndentPendingList = (List) map
				.get("storeInternalIndentPendingList");
	}
	if (map.get("storeInternalIndentMList") != null) {
		storeInternalIndentMList = (List<StoreInternalIndentM>) map
				.get("storeInternalIndentMList");
		System.out.println("storeInternalIndentMList javed------  "
				+ storeInternalIndentMList.size());
	}
	List<Object[]> storeInternalIndentMPOList = new ArrayList<Object[]>();

	if (map.get("storeInternalIndentMPOList") != null) {
		storeInternalIndentMPOList = (List) map
				.get("storeInternalIndentMPOList");

	}
	if (map.get("searchListForPopup") != null) {
		searchListForPopup = (List<StoreIssueM>) map
				.get("searchListForPopup");
	}
	if (map.get("max") != null)
		max = (String) map.get("max");
	if (map.get("pageNo") != null)
		pageNo = Integer.parseInt("" + map.get("pageNo"));
	if (map.get("listSize") != null)
		listSize = Integer.parseInt("" + map.get("listSize"));

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("issueId") != null)
		issueId = Integer.parseInt("" + map.get("issueId"));
	String messageTOBeVisibleToTheUser = "";

	if (map.get("messageTOBeVisibleToTheUser") != null) {
		messageTOBeVisibleToTheUser = ("" + map
				.get("messageTOBeVisibleToTheUser"));
	}
	String messageType = "";
	if (map.get("messageType") != null) {
		messageType = ("" + map.get("messageType"));
	}
	String demandIndentDate = "";
	if (map.get("demandIndentDate") != null) {
		demandIndentDate = (String) map.get("demandIndentDate");
	}
	if (map.get("Employee_id") != null) {
		Employee_id = map.get("Employee_id").toString();
		System.out.println("this is my employee code" + Employee_id);
	}
	if (map.get("Employee_name") != null) {
		Employee_name = map.get("Employee_name").toString();
		System.out.println("this is my employee code" + Employee_name);
	}

	// add by javed khan
	Map mapbatch = new HashMap();
	if (map.get("mapbatch") != null) {
		mapbatch = (Map) map.get("mapbatch");
		System.out.println("this is my batchlist  " + mapbatch.size()
				+ ">>>>>>>>>>" );	
	}
	 List storeIssueMList = new ArrayList();
	 if (map.get("storeIssueMList") != null) {
		 storeIssueMList = (List) map
					.get("storeIssueMList");

		}
	 
	// add by javed khan for loanOut
	 List<StoreLoanoutExpendT> loanoutTList = new ArrayList<StoreLoanoutExpendT>();
		if(map.get("loanoutTList") != null){
			loanoutTList = (List<StoreLoanoutExpendT>)map.get("loanoutTList"); 
			System.out.println("loanoutTList"+loanoutTList.size());
		}
	 
	 utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");
%>
<%-- Start of Content Div --%>
<Script>
var batchArray=new Array();

</Script>


<div class="clear"></div>

<form name="depCiv" method="post" action="">

 <div class="titleBg">
<%-- <h2><%=pageTitle %></h2> --%>
</div>


<div class="Block">
<%-- 
<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear"  onchange ="GetMRList('FILTER');">
<option value="0">Select</option>
	<%
		if(financialYearList.size()>0)
		{
			for(Object[] year : financialYearList)
			{
				%>
					<option value="<%=year[0]%>"><%=year[1]%></option>
				<%
			}
		}
	%>
</select>

<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 /> --%>
 <div class="clear" style="padding-top: 10px;"></div>
 
 <div class="clear" style="padding-top: 10px;"></div>
  
<div id="divSearchResult">

		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>
				
				</td>
				</tr>
		</table>
			
  	<table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				
				<th id="th1">Request No</th>
				<th id="th2">Request Date</th>
				<th id="th2">From Department</th>
				<th id="th3">Requested By</th>
				<!-- <th id="th4">Approved By</th>	
				<th id="th4">Approved Date</th>	 -->		
				<!-- <th id="th5">Status</th> -->
				
				
			</tr>
			<tbody id="tblListOfMR">		
			
			</tbody>
			</table>
			

</div>
 <div id="pageNavPosition"></div>
 
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			GetMRList('ALL');
	
		});
		
function GetMRList(MODE)
{
	
	var ddlRequestYear = $j("#ddlRequestYear").val();
	var ddlMPRPriority = $j("#ddlMPRPriority").val();
	
	


	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&Status=ALL";
		}
	else
		{
			var data = "PN="+nPageNo+"&Status=ALL";
		}
	var url = "stores?method=getListOfReceiveMRPartial";
	var bClickable = true;
	GetJsonData('tblListOfMR',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			var requestStatus="";
			if(jsonData[i].Status == 'u')
			{
				requestStatus = "Saved";
			}
			else if(jsonData[i].Status == 's')
			{
				requestStatus = "Pending for Appproval";
			}
			else if(jsonData[i].Status == 'o')
			{
				requestStatus = "Approved";
			}
			else if(jsonData[i].Status == 'r')
			{
				requestStatus = "Rejected";
			}
			else if(jsonData[i].Status == 'y')
			{
				requestStatus = "Issued";
			}
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"&"+jsonData[i].RequestedBy+"&"+jsonData[i].FromDepartmentId+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].DemandNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].DemandDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].FromDepartment+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].RequestedBy+"</td>";
		/* 	htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ApprovedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ApprovedDate+"</td>"; */
			/* htmlTable = htmlTable +"<td style='width: 200px;'>"+requestStatus+"</td>"; */
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfMR").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	ViewUpdateMR(Id);
}

function ViewUpdateMR(Id)
{
    var Id = Id.split("&");
	window.location = "stores?method=searchIndentDetailsPartial&requestNo="+Id[0]+"&requestByName="+Id[1]+"&departmentId="+Id[2]+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetMRList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	
	nPageNo = pageNo;
	GetMRList('ALL');
}


</script>