<%@page import="java.util.*"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.RequestConstants"%>
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
<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>



<link rel="stylesheet" type="text/css" href="/hms/jsp/css/tabcontent.css" />
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript">
//<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
 //-->
function isDispenserySelected()
	{

		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Dispensery Name...!")
			return false;
		}
		else
		{
			
			submitProtoAjax('issueDispensaryForm','stores?method=getDemandListForWithoutBar&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}


function getdpt(){

	
	var indent_id=document.getElementById('requestNo').value;
	submitProtoAjaxdiv('issueDispensaryForm','stores?method=setDepartmentWithoutbarcode&indent_id='+document.getElementById('requestNo').value);	
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
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<%
	Map map = new HashMap();
	String userName="";
	String date="";
	String time="";
	String deptName="";

	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	int approvedBy=0;
	String max="";
	String message = "";
	String Employee_id="";
	String Employee_name="";
	String IndentDate="";
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<Object[]> indentTList=new ArrayList<Object[]>();
	List<Object[]> itemListSearch=new ArrayList<Object[]>();
	
	
	
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Object[]> itemListStock=new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	System.out.println("this is view part map size"+map.size());
	if (map.get("objectList") != null) {
		itemList = (List)map.get("objectList");
		System.out.println("this is view part size"+itemList.size());
	}
	if (map.get("objectListStockStatus") != null) {
		itemListStock = (List)map.get("objectListStockStatus");
		System.out.println("this is view part size"+itemListStock.size());
	}	
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	StoreSetup storeSetup = new StoreSetup();
	
	
	Box box=HMSUtil.getBox(request);
	int requestNoForAcc=0;
	String demandNoSelected="";
	if(map.get("requestNoForAcc")!=null){
		requestNoForAcc = (Integer) map.get("requestNoForAcc");
		demandNoSelected=""+requestNoForAcc;
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
		}
		 int requestByEmpId=0;
		 if(map.get("requestByEmpId")!=null){
			 requestByEmpId = (Integer) map.get("requestByEmpId");
			}
		 
		 
		
		 if(map.get("approvedBy")!=null){
			 approvedBy =Integer.parseInt(""+map.get("approvedBy"))  ;
			}
		 int issuedBy=0;
		 if(map.get("issuedBy")!=null){
			 issuedBy =Integer.parseInt(""+map.get("issuedBy"))  ;
			}
		if(map.get("storeSetup")!=null)
			storeSetup = (StoreSetup) map.get("storeSetup");
		if(map.get("storeInternalIndentTList")!=null)
			storeInternalIndentTList = (List) map.get("storeInternalIndentTList");
		
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
		}
		//if(map.get("issueTList")!=null){
		//	issueTList=(List)map.get("issueTList");
		//}
		if(map.get("deptName")!=null){
			deptName=(String)map.get("deptName");
	}
		if(map.get("indentTList")!=null){
			indentTList=(List)map.get("indentTList");
		}
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		List stockList= new ArrayList();
		if(map.get("stockList")!=null){
			stockList=(List)map.get("stockList");
		}
		List loanOutQtyList= new ArrayList();
		if(map.get("loanOutQtyList")!=null){
			loanOutQtyList=(List)map.get("loanOutQtyList");
		}
		int totalPages=0;
		 if(map.get("totalPages")!=null){
			 totalPages=(Integer)map.get("totalPages");
			}
		 if(storeInternalPendingIndentList !=null){
				storeInternalPendingIndentList = (List)map.get("storeInternalPendingIndentList");
			}
			List<Object[]> storeInternalIndentPendingList = new ArrayList<Object[]>();
			if(storeInternalIndentPendingList !=null){
				storeInternalIndentPendingList = (List)map.get("storeInternalIndentPendingList");
			}
		if(map.get("storeInternalIndentMList")!=null){
			storeInternalIndentMList=(List<StoreInternalIndentM>)map.get("storeInternalIndentMList");
		}
		List<Object[]> storeInternalIndentMPOList = new ArrayList<Object[]>();
		if(map.get("storeInternalIndentMPOList")!=null){
			storeInternalIndentMPOList=(List)map.get("storeInternalIndentMPOList");
		}
		if(map.get("searchListForPopup")!=null){
			searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
		}
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(map.get("issueId")!=null)
			 issueId = Integer.parseInt(""+map.get("issueId")) ;
		 String messageTOBeVisibleToTheUser ="";
			
			if(map.get("messageTOBeVisibleToTheUser")!=null){
				messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
			}
			String messageType ="";
			if(map.get("messageType")!=null){
				messageType=(""+map.get("messageType"));
			}
			String demandIndentDate="";
			if(map.get("demandIndentDate")!=null){
				demandIndentDate = (String) map.get("demandIndentDate");
			}
			if(map.get("Employee_id")!=null){
				Employee_id=map.get("Employee_id").toString();
				System.out.println("this is my employee code"+Employee_id);
			}
			if(map.get("Employee_name")!=null){
				Employee_name=map.get("Employee_name").toString();
				System.out.println("this is my employee code"+Employee_name);
			}
			if(map.get("Demand_Date")!=null){
				IndentDate=map.get("Demand_Date").toString();	
			}
%>


<%-- Start of Content Div --%>
<form name="issueDispensaryForm" method="post">
<%-- Start of Main Form --%>
<%-- Title --%>

<div class="titleBg"><h2>Stock Details</h2></div>


<div class="Clear"></div>	


<%--------------- Start of Search Panel ---------------------------%>

<div class="Clear"></div>
<%-------------------- End of Search Panel ---------------------------%>
	
<%--------------------Start of Status message  ---------------------------%>
	<%if(!(messageTOBeVisibleToTheUser.equals("") ) || (messageTOBeVisibleToTheUser !=null) ){
				if(messageType.equals("success")){%>
<h4><%=messageTOBeVisibleToTheUser %></h4>
			<%}%>
	<%if(messageType.equals("failure")){%>
<h4>	<%=messageTOBeVisibleToTheUser %></h4>
				<%}}%>
	<%--------------------End of Status message  ---------------------------%>
	
<input type="hidden" name="rows" id="rr" value="1"/>
<input type="hidden" name="listSize" value="<%=listSize%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="<%=RequestConstants.ISSUE_ID%>" id="issueId" value="<%=issueId%>" />

<div class="Clear"></div>	

<h4>Search By</h4>
<div class="Block">


<label> PVMS No. </label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />


<label>Nomenclature</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />

<label>Section</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />

<label>Rate</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />

<label>Source</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />

<label>Min Stock</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />

<label>Max Stock</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="" readonly="readonly" value=""  MAXLENGTH="50" />
</div>
<div class="clear paddingTop15">
<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
		 
</div>
<input type="button" name="sss" align="right"	class="button" value="Submit"
	onclick="if(test()){{submitForm('issueToOtherUnitsForm','stores?method=submitIssueToOtherUnit&buttonName=submit');}}" />
<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
<div class="Clear"></div>
<ul id="countrytabs" class="shadetabs">
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockDetailJsp');" rel="country1" class="selected">PVMS</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockStatusJsp');" rel="country2" >Stock Status</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockBatchJsp');" rel="country3">Batch Details</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockReceiptJsp');" rel="country4">Receipt</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockIssueJsp');" rel="country5" >Issue</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockSurplusJsp');" rel="country6">Surpluse</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockDeficientJsp');" rel="country7">Deficent</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockABCJsp');" rel="country8">ABC</a></li>
<li><a href="javascript:submitForm('issueDispensaryForm','stores?method=showStockVDEJsp');" rel="country9">VDE</a></li>
</ul>

<div id="country1">
<div class="cmntableWithHeight">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>Section</th>
<th>B/G</th>
<th>Specification</th>
<th>Life</th>
<th>Rate</th>
<th>UOM</th>
<th>Source</th>
<th>Remarks</th>
<th>Min Stock</th>
<th>ABC</th>
<th>VDE</th></thead>
</tr>

<div class="clear"></div>
<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td><%=objects[3]%></td>
<td><%=objects[4]%></td>
<td><%=objects[5]%></td>
<td><%=objects[6]%></td>
<td><%=objects[7]%></td>
<td><%=objects[8]%></td>
<td><%=objects[9]%></td>
<td><%=objects[10]%></td>
<td><%=objects[11]%></td>
<td><%=objects[12]%></td>
<td><%=objects[13]%></td>
</tr>
<%}}%>
</table>
</div>

</div>
<div id="country2" >
<div class="cmntableWithHeight">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>CRV No.</th>
<th>CRV Date</th>
<th>Receipt Date</th>
<th>Receipt Qty</th>
<th>Issue Qty</th>
<th>Balance</th>
</thead>
</tr>

<div class="clear"></div>
<%
if (itemListStock != null && itemListStock.size() > 0) { 
for (Iterator iterator = itemListStock.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td><%=objects[3]%></td>
<td><%=objects[4]%></td>
<td><%=objects[5]%></td>
<td><%=objects[6]%></td>
<td><%=objects[8]%></td>
</tr>
<%
}
}
%>
</table>
</div>
</div>

<div id="country3" >
<div class="cmntableWithHeight">

<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>B/G</th>
<th>Brand Name</th>
<th>Company</th>
<th>BatchNo.</th>
<th>DOM</th>
<th>DOE</th>
<th>Cost</th>
<th>MRP</th>
<th>Stock Qty</th>

</thead>
</tr>

<div class="clear"></div>
<!--<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
</tr>
<%
}
}
%>
--></table>
</div>
</div>

<div id="country4" >
<div class="cmntableWithHeight">

<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>Sec</th>
<th>CRV No.</th>
<th>CRV Date</th>
<th>Batch No.</th>
<th>DOM</th>
<th>DOE</th>
<th>Source</th>
<th>B/G</th>
<th>Company</th>
<th>Qty</th>
<th>MRP</th>
<th>Cost</th>
<th>Discount</th>
<th>Total</th>

</thead>
</tr>

<div class="clear"></div>
<!--<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>

</tr>
<%
}
}
%>
--></table>
</div>
</div>

<div id="country5" >
<div class="cmntableWithHeight">

<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>Sec</th>
<th>CIV No.</th>
<th>CIV Date</th>
<th>Source</th>
<th>B/G</th>
<th>Company</th>
<th>Batch No.</th>
<th>DOM</th>
<th>DOE</th>
<th>MRP</th>
<th>Qty</th>
<th>Cost</th>
<th>Discount</th>
<th>Total</th>
</thead>
</tr>

<div class="clear"></div>
<!--<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>

</tr>
<%
}
}
%>
--></table>
</div>
</div>



<div id="country6" >
<div class="cmntableWithHeight">

<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>CRV No.</th>
<th>CRV Date</th>
<th>Batch No.</th>
<th>DOM</th>
<th>DOE</th>
<th>Source</th>
<th>B/G</th>
<th>Company</th>
<th>Received Qty</th>
<th>Issued Qty</th>
<th>Balance</th>
</thead>
</tr>

<div class="clear"></div>
<!--<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>

</tr>
<%
}
}
%>
--></table>
</div>
</div>
<div id="country7" >
<div class="cmntableWithHeight">

<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>A/U</th>
<th>CRV No.</th>
<th>CRV Date</th>
<th>Batch No.</th>
<th>DOM</th>
<th>DOE</th>
<th>Source</th>
<th>B/G</th>
<th>Company</th>
<th>Received Qty</th>
<th>Issued Qty</th>
<th>Balance</th>
</thead>
</tr>

<div class="clear"></div>
<!--<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>

</tr>
<%
}
}
%>
--></table>
</div>
</div>
<div id="country8" class="tabcontent">
<div class="Block">
<label >PVMS No.</label>
<label>Nomenclature</label>
<label>A/U</label>
<label></label>
</div></div>
<div id="country9" class="tabcontent">
<div class="Block">
<label >PVMS No.</label>
<label>Nomenclature</label>
<label>A/U</label>
<label></label>
</div>
</div>


<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
</form>
<%-- End of Main form --%>
<script type="text/javascript">

function testForAdjustLoanOut(deptName)
{
	var errorMessage="";
	formName="issueDispensaryForm"
	obj = eval('document.'+formName)
	
	//if(document.getElementById('issuedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Issue By \n"; 
	//if(document.getElementById('approvedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Approved By \n";
	if(document.getElementById('requestBy').value == "")
		errorMessage=errorMessage+"Please Select Requested By \n";
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(deptName=="Dispensary Store")
	{	
	if(document.getElementById('reference').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	}
	if(deptName=="Dispensary Store")
	{
		if((document.getElementById('reference').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		   if(confirm("Are you Sure, you want to import Demand items for issue ?")){
			return true;
			}else{
			return false;
			}
		}
		else
		{
			alert(errorMessage)
			return false
		}
	}
	else
	{
		if((document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		if(confirm("Are you Sure, you want to import Demand items for issue ?")){
		return true;
		}else{
		return false;
		}
		}
		else
		{
		alert(errorMessage)
		return false
		}
	}
}
		
	function checkForLoanout()
	{
		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Dispensery Name...!")
			return false;
		}
		else
		{
			submitForm('issueDispensaryForm','stores?method=showAdjustLoanOut&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}
	
function testForLotNo(value)
{
		if(value =="")
		{
			return false;
		}
		else
		{
			return true;
		}
}

function goPage()
{
submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=goToPage');
}
function isToDepartmentSelected(){

	if(document.getElementById('toDeptId').value==""){
	alert("Department Name...!")
		return false;
	}else{
		submitProtoAjax('searchPanel','stores?method=getIssueList&toDeptId='+document.getElementById('toDeptId').value);
	}
	}
</script>
<script type="text/javascript">

	
	var obj = document.getElementById('requestBy');
	if(reqDate != ""){
	document.getElementById('requestDate').value = reqDate;
	}
	for(i=0;i<obj.length;i++)
	{
		if (reqId == obj.options[i].value)
		{
			obj.selectedIndex = i;
			break;
		}
		
	}
}
function cheackForSelect(){
	if(document.getElementById("requestNo").value!=""){
	document.getElementById("requestNo1").value=document.getElementById("requestNo").value;
	return true;}
	else{
	alert("pls select demand no..");
	return false;
	}
	}
function validateIssue()
{

	if(document.getElementById("departmentIdTemp").value=="")
	{
		alert('Select The Department !!!');
		document.getElementById("departmentIdTemp").focus();
		return false;
	}
	if(document.getElementById("requestBy").value=="")
	{
		alert('Select The Requested BY !!!');
		document.getElementById("requestBy").focus();
		return false;
	}
	//if(document.getElementById("approvedBy").value=="")
	//{
	//	alert('Select The Approved By !!!');
	//	document.getElementById("approvedBy").focus();
	//	return false;
	//}

//	if(document.getElementById("issuedBy").value=="")
//	{
	//	alert('Select The Issue By !!!');
	//	document.getElementById("issuedBy").focus();
	//	return false;
	//}

	if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}else{
		return true;
	}
}
function getDataForBarcode(val,rowVal){

	 if(val!=""){

	 submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);
	 }
	 }

function barCodefill(inc){
	var barCodeNo=document.getElementById('barCodeNo'+inc).value
	if(barCodeNo != ''){
		document.getElementById('qtyIssued'+inc).value =	document.getElementById('qtyRequested'+inc).value
		
	}
}


function submitProtoAjaxForIssueBatch(formName,action){
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
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0){

	      	for (loop = 0; loop < items.childNodes.length; loop++) {

		   	 var item = items.childNodes[loop];

		   	 var message = item.getElementsByTagName("message")[0];
		   	 if(message.childNodes[0] == undefined)
		       {
	    			submitForm('issueDispensaryForm','stores?method=submitIssueForIndentwithoutbar');
		       }else{
		       		alert(message.childNodes[0].nodeValue);
		       }

		   	  }
		   	  }

	      }
	    }

	   // var counter = document.getElementById('countId').value;
	    var url=action+"&"+getNameAndData(formName)
	 /*   for(var i=1;i<=counter;i++){
	    	if(document.getElementById('issueId'+i).checked){
	    		url += "&batchId"+i+"="+document.getElementById('issueId'+i).value+"&qty"+i+"="+document.getElementById('qtyId'+i).value;
	    		}
	    }*/
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }
</script>