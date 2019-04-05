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
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
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

 <div id="searchBlock" style="display:none;">
 
<form name="depCiv" method="post" action="">
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>
<h6>SEARCH</h6>
<!--  <div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>-->
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div> -->
<div class="clear"></div>
<!-- <div class="searchBlock" id="threadsearch_menu" style="display: none"> -->
<!-- <form name="searchPanel" method="post"> -->
	<label>From Date</label>

<input	type="text" name="<%= FROM_DATE %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromDate');" id="fromDate" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.depCiv.<%=FROM_DATE%>,event)" />

<label>To	Date</label>
<input	type="text" name="<%= TO_DATE %>" class="date" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'toDate');" id="toDate" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1"	onClick="setdate('<%=currentDate%>',document.depCiv.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label> Issue Vocher No. </label>
<select name="<%=DEMAND_NO%>">
			<option value="0">Select Issue Vocher No.</option>
			<%
			for (Iterator iterator = storeIssueMList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				//System.out.println(object[0]+" <----> "+object[1]);
				%>
			
			<option value=<%=object[0]%>><%=object[1]%></option>
			<%
				}
			%>
</select>
		<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
		<input			type="hidden" name="numOfRows" size="5" value="5">
		<input type="button" name="sss" class="button" value="SEARCH" onClick="civDisplay();" /></td>
</form>
</div>
</form>

</div>


<form name="issueDispensaryForm" method="post" >
<input type="hidden" value="<%=deptId%>" name="deptId" id="deptId" />
<%-- Start of Main Form --%>
<%-- Title --%>

<div class="titleBg"><h2>MR Issue</h2></div>

<div class="Clear"></div>	







<!-- -
<div id="update">
<%int counter = 0;
			int slNumber = 0;%>
<div id="pageNavPosition"></div>
<h4>Pending Indent</h4>
<div class="clear"></div>
<%if (storeInternalIndentPendingList != null
					&& storeInternalIndentPendingList.size() > 0) {%>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>Sl.No.</th>
		<th>Demand No</th>
		<th>Demand Date</th>
		<th>From Dept</th>
		<th>To Dept</th>
		<th>Requested By</th>
	</tr>
	<tbody id="tableData">
		<%String klass = "even";
				for (Iterator iterator = storeInternalIndentPendingList
						.iterator(); iterator.hasNext();) {
					Object[] objects = (Object[]) iterator.next();
					Date date11 = (Date) objects[2];
					String dd = HMSUtil
							.convertDateTypeToStringWithoutTime(date11);
					String id = "";
					id = "id" + counter;
					counter++;
					slNumber = slNumber + 1;
					if (counter % 2 == 0) {
						klass = "even";
					} else {
						klass = "odd";
					}%>
		<tr class=<%=klass%> id="<%=counter%>">
			<td><%=slNumber%></td>
			<td><%=objects[1]%></td>
			<td><%=dd%></td>
			<td><%=objects[3]%></td>
			<td><%=objects[4]%></td>
			<td><%=objects[5]%></td>
		</tr>

		<%}%>
	</tbody>
</table>
<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo%>"/>
<script>
			var pager = new Pager('tableData',2);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script>
<div class="clear"></div>
<label>&nbsp;</label> <%} else {%>
<h4><span>No Record Exists</span></h4>
<div class="clear"></div>
<%}%>
</div> -->
<%--------------- Start of Search Panel ---------------------------%>

<div class="Clear"></div>
<%-------------------- End of Search Panel ---------------------------%>
	
<%--------------------Start of Status message  ---------------------------%>
	<%
		if (!(messageTOBeVisibleToTheUser.equals(""))
				|| (messageTOBeVisibleToTheUser != null)) {
			if (messageType.equals("success")) {
	%>
<h4><%=messageTOBeVisibleToTheUser%></h4>
			<%
				}
			%>
	<%
		if (messageType.equals("failure")) {
	%>
<h4>	<%=messageTOBeVisibleToTheUser%></h4>
				<%
					}
					}
				%>
	<%--------------------End of Status message  ---------------------------%>
	
<input type="hidden" name="rows" id="rr" value="1"/>
<input type="hidden" name="listSize" value="<%=listSize%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="<%=RequestConstants.ISSUE_ID%>" id="issueId" value="<%=issueId%>" />
<div class="Clear"></div>	

<div class="Block">
<%-- 
<label> MR Issue </label>

<%
	if (map.get("max") != null) {
%>
<input type="text" name="<%=RequestConstants.ISSUE_NO%>" id="issueNo" value="<%=max%>" MAXLENGTH="8" readonly  />
	  	  	   	<%
	  	  	   		} else {
	  	  	   	%>
<input type="text" name="<%=RequestConstants.ISSUE_NO%>" id="issueNo" value="<%=box.get("issueNo")%>"    MAXLENGTH="8" readonly/  >
	  	  	    <%
	  	  	    	}
	  	  	    %>
 --%>
 
 <label>MR No.</label>
<div id="testDiv">
<select  name="<%=REQUEST_NO%>" tabindex="1" validate="Indent No. ,string,no" id="requestNo"  onchange="submitForm('issueDispensaryForm','stores?method=searchIndentDetails');">
	<option value="0">Select MR No</option>
	<%
		for (Object[] obj : storeInternalIndentMPOList) {
			String tempDemandId = "";
			tempDemandId = "" + obj[0];
			System.out.println(" id 1& no.  ");
			if (demandNoSelected.equalsIgnoreCase(tempDemandId)) {
	%>
			<option value="<%=obj[0]%>" selected="selected"><%=obj[1]%></option>
			<%
				} else {
			%>
			<option value="<%=obj[0]%>"><%=obj[1]%></option>
			<%
				}
					//requestNoForAcc
				}
			%>
</select>
</div>

 <label>MR Date</label>
 <%
 	if (demandIndentDate != "") {
 %>
	 <input type="text" tabindex="1" name="<%=REQUEST_DATE%>" readonly="readonly"  value="<%=demandIndentDate%>" MAXLENGTH="30" />
	 <%
	 	} else {
	 %>
	 <input type="text" tabindex="1" name="<%=REQUEST_DATE%>" readonly="readonly"  value="<%=date%>" MAXLENGTH="30" />
	 <%
	 	}
	 %>
 
<%
 	if (deptId != 35) {
 %>
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="35">
<%
	} else {
%>
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="36">
<%
	}
%>
 
<label>Department</label>
<select name="departmentId" id="departmentId" onchange="if(this.value!=''){isDispenserySelected()}" >

<%for(MasDepartment masDept:deptList) { if(masDept.getId().equals(departmentId)){%>
<option value="<%=masDept.getId() %>" selected><%=masDept.getDepartmentName()%></option>
<%}} %>
</select>

<!-- <label>Issue To</label>
<label class="value">Dispensary</label> -->
<%
	if (deptId != 35) {
%>
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="35">
<%
	} else {
%>
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="36">
<%
	}
%>
<!--<label>Type</label>
<select  name="<%=REQUEST_NO%>" tabindex="1" validate="Indent No. ,string,no" id="requestNo" onclick="isDispenserySelected();" onchange="submitForm('issueDispensaryForm','stores?method=searchIndentDetails');">
	<option value="0">Select</option>
	</select>
<select name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" tabindex="1" id="departmentIdTemp" validate='Dispensery Name,num,Yes'>
				<option value="">Select</option>
				<%for (MasDepartment department : departmentList) {%>
					<option value=<%=department.getId()%> <%=HMSUtil.isSelected(department.getId().toString(), box
						.get("departmentIdTemp"))%>><%=department.getDepartmentName()%></option>
				<%}%>
</select>
-->
<div class="clear"></div>


<div class="clear"></div>

<div id="testDivR">
     <label>Requested By
     </label><label class="value"  ><%=Employee_name%></label>
<input type="hidden" name="<%=REQUEST_BY%>" id="requestBy" validate="Request By,string,no" value="<%=Employee_id%>"/>
<input type="hidden" name="<%=REQUEST_BY_NAME%>" id="requestByName" validate="Request By,string,no" value="<%=Employee_name%>"/>
</div>

 

<script type="text/javascript">
<%if (requestByEmpId != 0) {%>
document.issueDispensaryForm.<%=REQUEST_BY%>.value = '<%=requestByEmpId%>';
<%}
			//demandListAjax
			//previously this method is used on Demand No on Change; Code Commented By Mukesh Narayan Singh Date 27 Dec 2010
			//stores?method=searchInternalIndentDetails%>
</script>

<!-- -
<label>Demand Date</label>
	<%if (box.get("requestDate") != null
					&& !box.get("requestDate").equals("")) {%>
<input type="text" class="date" name="<%=RequestConstants.REQUEST_DATE%>" id="<%=RequestConstants.REQUEST_DATE%>" value="<%=box.get("requestDate")%>"  MAXLENGTH="30" />
				<%} else {%>
<input type="text" class="date" name="<%=RequestConstants.REQUEST_DATE%>" id="<%=RequestConstants.REQUEST_DATE%>" value=""  MAXLENGTH="30" />
				<%}%>
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  tabindex="1" onClick="setdate('<%=date1%>',document.issueDispensaryForm.<%=RequestConstants.REQUEST_DATE%>,event)" /> -->
<!-- -For smc
<%//if(deptName.equalsIgnoreCase("Dispensary Store")){%>
<label>Reference  No:</label>
<input type="text" name="<%=RequestConstants.REFERENCE%>" tabindex="1"  id="reference" value="<%=box.get("reference")%>" MAXLENGTH="30" />
				<%//}%>
 -->


<%-- 
<label>Issued By<span>*</span></label>
<select name="<%=RequestConstants.ISSUED_BY%>" tabindex="1" id="issuedBy" validate="Issued By,String,no" onchange="if(testForAdjustLoanOut())submitForm('issueDispensaryForm','stores?method=searchIndentDetails');">
					<%
						if (issuedBy == 0) {
					%>
					<option value="">Select</option>
					<%
						for (MasEmployee masEmployee : employeeList) {
								String lastName = "";
								if (masEmployee.getLastName() != null) {
									lastName = masEmployee.getLastName();
								}
					%>
				<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName() + " " + lastName%></option>
				<%
					}
					} else {
						for (MasEmployee masEmployee : employeeList) {
							if (masEmployee.getId() == issuedBy) {
								String lastName = "";
								lastName = masEmployee.getLastName();
				%>
				<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName() + " " + lastName%></option>
				<%
					} else {
								String lastName = "";
								lastName = masEmployee.getLastName();
				%>
					<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName() + " " + lastName%></option>

				<%
					}

						}
					}
				%>
</select> --%>


<label>Issue Date</label>


<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="<%=RequestConstants.ISSUE_DATE%>" value="<%=date%>"  MAXLENGTH="10"  onkeyup="mask(this.value,this,'2,5','/');" onblur="if(this.value!=''){validateExpDate(this,'<%=RequestConstants.ISSUE_DATE%>')}"/>
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.issueDispensaryForm.<%=RequestConstants.ISSUE_DATE%>,event)" />



</div>
<input type="hidden" name="internalIndentId" value="<%=internalIndentId%>" />
<div class="Clear"></div>
<input type="hidden" class="button" value="Next"  onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=next');}" align="right" />
<!-- <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=submit');}"/>  -->
<div class="clear paddingTop15"></div>

 <!-- -
<div id="pagination">		 
Page No.
<span class="selected"><%=pageNo%></span>
<input type="text" class="small" name="ValueOfPage" value="" id="page"  MAXLENGTH="3" />
<input type="button" name="goToPage" value="Go" class="button"  onClick="goPage();" />
Total Pages
<span class="selected"><%=totalPages%></span>
</div> -->
<div class="Clear"></div>
	<%
		String itemId = "";
		Object I = null;
	%>
<input type="hidden" size="2"	value="0"  name="noOfRecords" id="noOfRecords" />
<input type="hidden" name="requestNo1" id="requestNo1" value="" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID%>" value="<%=indentId%>" id="hdb" />
	<%
		if (indentTList.size() > 0) {
	%>
	 <h4>Item Details</h4>
	 <div class="cmntable">  
 	<table  colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
  	<thead>
   	 <tr>
     	<tr>

			<th width="5%">Sl No. </th>
			<th width="13%">Mat Code</th>
			<th width="10%">Nomenclature</th>
			<!-- <th width="2%">B/G</th>
			<th width="13%">Barcode</br></th>  -->
			<th width="13%">A/U</th>				
			<th width="13%">Batch No.</th>
			<th width="13%">DOM</th> 			 
			<th width="13%">DOE</th> 
			<th width="13%">Source</th> 
			<th width="13%">Available</br>Stock</th>
			<th width="13%">Batch</br>Stock</th>
			<th width="13%">Qty</br>Demanded</th>
<!-- 			<th width="13%">Qty</br>on Loan</th> -->
			<th width="13%">Qty</br>Issued</th>
			<th width="13%">Balance</br>after Issue</th>
			<th width="3%">&nbsp;</th>
			<th width="3%">&nbsp;</th>
		</tr> 
      <!-- -
      <th width="6%">Loan Out Qty</th> -->
      <!--
       Loan Out Qty will be there for DIspensary Only
       If id in StoreSetup is equivalent to login Id then display this coloumn
       otherwise dont display.  
       -->
     
    </tr>
   </thead>
  <tbody>
		<%
			int inc = 0;
				try {
					int detailCounter = 10;
					int temp = 0;
					String idItem = "idItem";
					String codeItem = "codeItem";
					String nameItem = "nameItem";
					String idAu = "idAu";
					String qtyRequested = "qtyRequested";
					String loanOutQty = "loanOutQty";
					String incVar = "incVar";
					String issuedItemId = "issuedItemId";
					String batchNo = "batchNo";
					String batchId = "batchId";
					String barCodeNo = "barCodeNo";
					String batchNo2 = "batchNo";
					String batchId2 = "batchId";
					String barCodeNo2 = "barCodeNo";
					String expiryDate = "expiryDate";
					String expiryDate2 = "expiryDate";
					String idItem2 = "idItem";
					String codeItem2 = "codeItem";
					String nameItem2 = "nameItem";
					String idAu2 = "idAu";
					String qtyRequested2 = "qtyRequested";
					String loanOutQty2 = "loanOutQty";
					String incVar2 = "incVar2";
					String issuedItemId2 = "issuedItemId";
					String srNo = "srNo";
					String srNo2 = "srNo";
					String qtyIssued = "qtyIssued";
					String qtyIssued2 = "qtyIssued";
					String detailId = "detailId";
					String detailId2 = "detailId";
					String manuDate = "manuDate";
					String manuDate2 = "manuDate";

					//	inc=((pageNo-1)*20)+1;
					//	int tempVar=((pageNo-1)*20)+1;

					//   int incTemp2=inc+20;
					inc = ((pageNo - 1) * indentTList.size()) + 1;
					int tempVar = ((pageNo - 1) * indentTList.size()) + 1;

					int incTemp2 = inc + indentTList.size();
					//int incTemp2=10;
					for (Iterator iterator = indentTList.iterator(); iterator
							.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						
						System.out.println("kk="+object[5]);
						System.out.println("kk="+object[6]);
						System.out.println("kk="+object[7]);
						System.out.println("kk="+object[8]);

						tempVar--;

						if (inc < incTemp2) {

							idItem = idItem2 + ("" + inc);
							codeItem = codeItem2 + ("" + inc);
							nameItem = nameItem2 + ("" + inc);
							idAu = idAu2 + ("" + inc);
							qtyRequested = qtyRequested2 + ("" + inc);
							incVar = incVar2 + ("" + inc);
							issuedItemId = issuedItemId2 + ("" + inc);
							qtyIssued = qtyIssued2 + ("" + inc);
							detailId = detailId2 + ("" + inc);
							loanOutQty = loanOutQty2 + ("" + inc);
							batchNo = batchNo2 + ("" + inc);
							batchId = batchId2 + ("" + inc);
							barCodeNo = barCodeNo2 + ("" + inc);
							expiryDate = expiryDate2 + ("" + inc);
							srNo = srNo2 + ("" + inc);

		%>

		<tr>
		 <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc%>' value="blank" readonly="readonly"/>
		 <input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
			<td width="5%"><input type="text" size="3" tabindex="1"	value="<%=inc%>" id="srNo<%=inc%>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="10" tabindex="1"
				name="<%=RequestConstants.ITEM_CODE%>"	value="<%=object[1].toString()%>" id="pvmsNo<%=inc%>" />
				<input	type="hidden" size="2" value="<%=object[0].toString()%>" name="itemId<%=inc%>" 
				id="itemId<%=inc%>" />
				<input
				type="hidden" size="2" value="<%=object[6].toString()%>"
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />
				</td>
			<td width="10%"><input type="text" tabindex="1" size="50" value='<%=object[2].toString()%>' 
			    readonly="readonly"	name="<%=RequestConstants.NOMENCLATURE%>" id="nomenclature<%=inc%>"/></td>
			     <%-- <%if(object[13] != null){ %>
			   <td width="2%"><input type="text" tabindex="1" size="1" value="<%=object[13].toString()%>" 
			    readonly="readonly"	name="<%=RequestConstants.BRAND_GENERIC%>" id="BG<%=inc%>"/>
			    </td>
			     <%}else{ %>
			      <td width="2%"><input type="text" tabindex="1" size="1" value="G" 
			    readonly="readonly"	name="<%=RequestConstants.BRAND_GENERIC%>" id="BG<%=inc%>"/>
			    </td>
			    <%} %>
				<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=inc%>" 
			id="barCodeNo<%=inc%>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="getDataForBarcode(this.value,<%=inc%>)" /></td>--%>
				<td width="5%"><input type="text" name="au<%=inc%>" id="au<%=inc%>"	size="7" readonly="readonly"  /></td> 
			<td width="10%">
			<%
			List<Object[]> BatchList = new ArrayList<Object[]>();;
			BatchList = (List<Object[]>) mapbatch.get(object[0]);
								itemId = object[0].toString();
								I = object[0];
			%>
			<select name="batchNo<%=inc%>" id="batchNo<%=inc%>"  class="small3" onchange="if(cheackForBatch(<%=inc%>)){getDataForBarBatchStockId(this.value,<%=inc%>)}" >
			<option value="0">Select Batch</option>
			<%
				for (Object[] listA: BatchList) {
			%>
			<option value="<%=listA[0]%>" ><%=listA[1]%>-(<%=listA[2] !=null?listA[2]:"NA"%>)</option>
			<%
				}
			%>
			</select>
			<%
				List lis1 = new ArrayList();

								lis1 = (List) mapbatch.get(object[0]);
								for (int i = 0; i < lis1.size(); i++) {
			%> <script>
     			//var batchArray<%=inc%>=new Array();
	          batchArray[<%=i%>]= new Array();
	          batchArray[<%=i%>][0] = "<%=lis1.get(i)%>";
	          batchArray[<%=i%>][1] = "<%=lis1.get(i)%>";
            </script> <%
 	}
 %><input type="hidden" name="list<%=inc%>" id="list<%=inc%>" size="10" readonly="readonly" value="<%=BatchList.size()%>" />
			<input type="hidden" name="batchId<%=inc%>" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="batchNoValue<%=inc%>" id="batchNoValue<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId<%=inc%>" id="brandId<%=inc%>" size="10" readonly="readonly" value="" />
			</td>
			<td width="8%"><input type="text" name="manuDate<%=inc%>" id="manuDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			</td>
			<td width="8%"><input type="text" name="expiryDate<%=inc%>" id="expiryDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			<td width="8%"><input type="text" name="source<%=inc%>" id="source<%=inc%>"	size="7" readonly="readonly" value="" />
			</td>
			<td width="7%">
			<%
				if (inc <= stockList.size()) {
			%> <input type="text" size="8"
				value="<%=stockList.get(inc - 1)%>" id="stockAvailable<%=inc%>"
				class="medcaption" readonly /> <%
 	} else {
 %> <input type="text"
				 size="8" value="" id="stockAvailable<%=inc%>"
				class="medcaption" readonly /> <%
 	}
 %></td>
				
				<td width="7%">
			<%
				if (inc <= stockList.size()) {
			%> <input type="text" size="8"
				value="" id="batchStock<%=inc%>"
				class="medcaption" readonly /> <%
 	} else {
 %> <input type="text"
				 size="8" value="" id="batchStock<%=inc%>"
				class="medcaption" readonly /> <%
 	}
 %></td>
			
			
			<%
										BigDecimal qtyIssueRequest = new BigDecimal(0);
														if (object[7] != null) {
															qtyIssueRequest = new BigDecimal(object[7]
																	.toString());
														}
														BigDecimal qtyIssueDB = new BigDecimal(0);
														BigDecimal issyeRequestDiff = new BigDecimal(0);
														if (object[8] != null) {
															qtyIssueDB = new BigDecimal(object[8]
																	.toString());
															
															System.out.println("gg="+object[7]);
															System.out.println("gg="+object[8]);
														}
									%>
			<td width="10%">
			<%
				if (qtyIssueRequest.intValue() != 0
										&& qtyIssueDB.intValue() != 0
										&& !qtyIssueRequest.equals(qtyIssueDB)) {
									issyeRequestDiff = qtyIssueRequest
											.subtract(qtyIssueDB);
			%><input type="text" size="8"
				value="<%=issyeRequestDiff%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc%>" id="qtyRequested<%=inc%>" />
			<%
				} else if (qtyIssueRequest.equals(qtyIssueDB)) {
			%>
			<input type="text"  size="8"
					value="<%=qtyIssueRequest%>" readonly="readonly"
					name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc%>" id="<%=qtyRequested%>" />
			<%
				} else {
			%>
			<input type="text" tabindex="1" size="8"
				value="<%=qtyIssueRequest%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc%>" id="<%=qtyRequested%>" />
			<%
				}
			%>
			<%
				try {
			%>
			<input type="hidden" value="<%=object[2].toString()%>" tabindex="1"
				id="<%=nameItem%>" name="<%=nameItem%>" />
			<%
				} catch (Exception e) {
			%>
			<input type="hidden" value="" id="<%=nameItem%>" name="<%=nameItem%>" />
			<%
				}
			%>
			
			</td>
			<%-- <%int lQty=0;
			for(StoreLoanoutExpendT slet1 : loanoutTList){
					if(slet1.getItem().getId()== Integer.parseInt(object[0].toString())){
						lQty=lQty+(slet1.getQtyIssued()).intValue();
					}}
					 %>
				<%if(lQty>0) {%>
			<td width="8%"><input type="text"  size="8" name="qtyOnLoan<%=inc%>" id="qtyOnLoan<%=inc%>" value="<%=lQty %>"  readonly/></td>
			<%}else{ %>
			<td width="8%"><input type="text"  size="8" name="qtyOnLoan<%=inc%>" id="qtyOnLoan<%=inc%>" value="" />
			<%} %> --%>
			<td width="8%"><input type="text"  size="8" name="qtyIssued<%=inc%>" id="qtyIssued<%=inc%>" value="" readonly="readonly" onblur="checkQty(<%=inc%>)" validate="Issue Qty,no,no"/>
			<td width="8%"><input type="text"  size="8" name="qtyAftrIssued<%=inc%>" id="qtyAftrIssued<%=inc%>" value="" />
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowIssueCIV(<%=inc%>);" /></td>
		<td width="8%"> 	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('indentDetails','hdb',this);"  tabindex="1" />
			</td>
			
		<input type="hidden" name="indentDtId" id="indentDtId<%=inc%>"  />
		</tr>
		<%
			inc++;
						}
					}

					
					
					//	if(inc<=(pageNo-1)*20+20){
					//  for(;inc<=(pageNo-1)*20+20;inc++){
		%>
		
		
		<% int incL=0;
		if(loanoutTList.size()>0){ 
		for(StoreLoanoutExpendT slet : loanoutTList){incL++;
		int count=0;
		for (Iterator iterator1 = indentTList.iterator(); iterator1.hasNext();) {
			Object[] object = (Object[]) iterator1.next();
			if(slet.getItem().getId()== Integer.parseInt((""+object[0])))
			{
				count++;
				
			}
		}
		if(count==0){
	
		%>
		
		<tr>
			<td width="5%"><input type="text" size="3" tabindex="1"	value="<%=inc%>" id="srNoL<%=incL%>"
				name="SR_NO_L" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="10" tabindex="1"
				name="ITEM_CODE_L"	value="<%=slet.getItem().getPvmsNo()%>" id="pvmsNoL<%=incL%>" readonly="readonly"/>
				<input	type="hidden" size="2" value="<%=slet.getItem().getId()%>" name="itemIdL<%=incL%>" 
				id="itemIdL<%=inc%>" />
				
				</td>
				<td width="10%"><input type="text" tabindex="1" size="50" value="<%=slet.getItem().getNomenclature()%>" 
			    readonly="readonly"	name="NOMENCLATURE_L" id="nomenclatureL<%=incL%>"/>
			    <input type="hidden" tabindex="1" size="50" value="<%=slet.getIssueM().getId()%>" 
			    readonly="readonly"	name="ISSUE_M_L<%=incL%>" id="IssueML<%=incL%>"/>
			    </td>
			    
			    <td width="2%"><input type="text" tabindex="1" size="1" value="<%=slet.getItem().getBrandedGeneric()%>" 
			    readonly="readonly"	name="BRAND_GENERIC_L" id="BGL<%=incL%>"/>
			    </td>
			    <td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNoL<%=inc%>" 
			id="barCodeNoL<%=incL%>"  /></td>
			<td width="5%"><input type="text" name="auL<%=incL%>" id="auL<%=incL%>"	size="7" readonly="readonly" value="<%=slet.getItem().getItemConversion().getIssueUnit().getUnitName()%>" /></td>
			<td>
			<select name="batchNoL<%=incL%>" id="batchNoL<%=incL%>"  class="small3">
			<option value="<%=slet.getBatchNo()%>"><%=slet.getBatchNo()%></option>
			<input type="hidden" name="batchIdL<%=incL%>" id="batchIdL<%=incL%>" size="10" readonly="readonly" value="<%=slet.getBatchStock().getId()%>" />
			<input type="hidden" name="brandIdL<%=incL%>" id="brandIdL<%=incL%>" size="10" readonly="readonly" value="<%=slet.getBrand().getId()%>" />
			</td>
			<td width="8%"><input type="text" name="manuDateL<%=incL%>" id="manuDateL<%=incL%>"	size="10" readonly="readonly" value="" />
			</td>
			</td>
			<td width="8%"><input type="text" name="expiryDateL<%=incL%>" id="expiryDateL<%=incL%>"	size="10" readonly="readonly" value="<%=HMSUtil.changeDateToddMMyyyy(slet.getExpiryDate()) %>" />
			</td>
			<td width="8%"><input type="text" name="sourceL<%=incL%>" id="sourceL<%=incL%>"	size="7" readonly="readonly" value="" />
			</td>
			<td>
			<input type="text" size="8"
				value="<%=slet.getBatchStock().getClosingStock()%>" id="stockAvailableL<%=incL%>"
				class="medcaption"  readonly />
			</td>
			<td>
			<input type="text" size="8"
				value="<%=slet.getBatchStock().getClosingStock()%>" id="batchStock<%=incL%>"
				class="medcaption" readonly />
				</td>
				<td>
				<input type="text" size="8"
				value="" readonly="readonly"
				name="QTY_IN_REQUESTL<%=incL%>" id="qtyRequestedL<%=incL%>" />
				</td>
				
				<td width="8%"><input type="text" size="8" name="qtyOnLoanL<%=incL%>" id="qtyOnLoanL<%=incL%>" value="" /></td>
			<td width="8%"><input type="text"  size="8" name="qtyIssuedL<%=incL%>" id="qtyIssuedL<%=incL%>" value="<%=slet.getQtyIssued() %>"  readonly="readonly"  validate="Issue Qty,no,no"/>
			<td width="8%"><input type="text"  size="8" name="qtyAftrIssuedL<%=incL%>" id="qtyAftrIssuedL<%=inc%>" value="" />
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="" /></td>
		<td width="8%"> <input type="button" name="delete" value="" class="buttonDel" onclick=""  tabindex="1" />
			</td>
			
		</tr>
		
		
		
		
		<%inc++;}else{
			System.out.println("IN  tr display:none");
		%>
		
		
		<tr style="display:none">
			<td width="5%"><input type="hidden" size="3" tabindex="1"	value="<%=inc%>" id="srNoL<%=incL%>"
				name="SR_NO_L" readonly="readonly" /></td>
			<td width="10%"><input type="hidden" size="8" tabindex="1"
				name="ITEM_CODE_L"	value="<%=slet.getItem().getPvmsNo()%>" id="pvmsNoL<%=incL%>" readonly="readonly"/>
				<input	type="hidden" size="2" value="<%=slet.getItem().getId()%>" name="itemIdL<%=incL%>" 
				id="itemIdL<%=inc%>" />
				
				</td>
				<td width="10%"><input type="hidden" tabindex="1" size="50" value="<%=slet.getItem().getNomenclature()%>" 
			    readonly="readonly"	name="NOMENCLATURE_L" id="nomenclatureL<%=incL%>"/>
			    <input type="hidden" tabindex="1" size="50" value="<%=slet.getIssueM().getId()%>" 
			    readonly="readonly"	name="ISSUE_M_L<%=incL%>" id="IssueML<%=incL%>"/>
			    </td>
			    
			    <td width="2%"><input type="hidden" tabindex="1" size="2" value="<%=slet.getItem().getBrandedGeneric()%>" 
			    readonly="readonly"	name="BRAND_GENERIC_L" id="BGL<%=incL%>"/>
			    </td>
			    <td width="10%"><input type="hidden" size="8" value="" maxlength="30" tabindex="1" name="barCodeNoL<%=inc%>" 
			id="barCodeNoL<%=incL%>"  /></td>
			<td width="5%"><input type="hidden" name="auL<%=incL%>" id="auL<%=incL%>"	size="7" readonly="readonly" value="<%=slet.getItem().getItemConversion().getIssueUnit().getUnitName()%>" /></td>
			<td>
			<select name="batchNoL<%=incL%>" id="batchNoL<%=incL%>"  class="small3">
			<option value="<%=slet.getBatchNo()%>"><%=slet.getBatchNo()%></option>
			<input type="hidden" name="batchIdL<%=incL%>" id="batchIdL<%=incL%>" size="10" readonly="readonly" value="<%=slet.getBatchStock().getId()%>" />
			<input type="hidden" name="brandIdL<%=incL%>" id="brandIdL<%=incL%>" size="10" readonly="readonly" value="<%=slet.getBrand().getId()%>" />
			</td>
			<td width="8%"><input type="hidden" name="manuDateL<%=incL%>" id="manuDateL<%=incL%>"	size="10" readonly="readonly" value="" />
			</td>
			</td>
			<td width="8%"><input type="hidden" name="expiryDateL<%=incL%>" id="expiryDateL<%=incL%>"	size="10" readonly="readonly" value="<%=HMSUtil.changeDateToddMMyyyy(slet.getExpiryDate()) %>" />
			</td>
			<td width="8%"><input type="hidden" name="sourceL<%=incL%>" id="sourceL<%=incL%>"	size="7" readonly="readonly" value="" />
			</td>
			<td>
			<input type="hidden" size="8"
				value="<%=slet.getBatchStock().getClosingStock()%>" id="stockAvailableL<%=incL%>"
				class="medcaption"  readonly />
			</td>
			<td>
			<input type="hidden" size="8"
				value="<%=slet.getBatchStock().getClosingStock()%>" id="batchStock<%=incL%>"
				class="medcaption" readonly />
				</td>
				<td>
				<input type="hidden" size="8"
				value="" readonly="readonly"
				name="QTY_IN_REQUESTL<%=incL%>" id="qtyRequestedL<%=incL%>" />
				</td>
				
				<td width="8%"><input type="hidden" size="10" name="qtyOnLoanL<%=incL%>" id="qtyOnLoanL<%=incL%>" value="" />
			<td width="8%"><input type="hidden"  size="8" name="qtyIssuedL<%=incL%>" id="qtyIssuedL<%=incL%>" value="<%=slet.getQtyIssued() %>"  readonly="readonly"  validate="Issue Qty,no,no"/>
			<td width="8%"><input type="hidden"  size="10" name="qtyAftrIssuedL<%=incL%>" id="qtyAftrIssuedL<%=inc%>" value="" />
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="" /></td>
		<td width="8%"> <input type="button" name="delete" value="" class="buttonDel" onclick=""  tabindex="1" />
			</td>
			
		</tr >
		
		
		<%}}}%>
		
		
		
		
		
		<!--
		    			   <tr>
	      <td width="5%"><input type="text" size="2"tabindex="1"	value="<%=temp + inc%>"id="srNo<%=inc%>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
	      <td width="10%">

	     <input type="text" size="8" tabindex="1" name="<%=RequestConstants.ITEM_CODE%>" value=""  id="<%=codeItem%>"/>
	      <input type="hidden" size="2"	value="0" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />

	      </td>
	      <td width="10%">
	      	<input type="text" tabindex="1" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.NOMENCLATURE%>" /></td>
	     <td width="10%">
	        <input type="text"size="8" value=""  tabindex="1"readonly="readonly" name="<%=RequestConstants.AV%>"  id="<%=idAu%>"/>
	        </td>
	         <td width="10%">
		   <input type="text"size="8" value=""  maxlength="30" tabindex="1" name="barCodeNo"  id="barCodeNo<%=inc%>"  onblur="getDataForBarcode(this.value,<%=inc%>)"/>
		  </td>
		  <td width="10%">
		   <input type="text" size="8" value="" maxlength="20" tabindex="1" name="batchNo"  id="batchNo<%=inc%>"/>

		  </td>
		   <td width="10%">
		   <input type="text"size="8" value="" maxlength="20" tabindex="1" name="expiryDate"  id="expiryDate<%=inc%>"/>

		  </td>
	       <td width="10%">
     		 <input type="text"size="8" value=""	id="availableStock<%=inc%>"   readonly />
     	 </td>
	      <td width="10%"><input type="text"size="8"	value=""   readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST%>"  id="<%=qtyRequested%>"/>
	      </td>
	   		 <input type="hidden" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.ISSUED_ITEM%>" />
	      <td width="10%"><input type="text"size="8" tabindex="1" readonly="readonly"	value=""  name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="qtyIssued<%=inc%>" />
	      </td>
	      <td>
	       <input type="button" class="buttonIssue" tabindex="1" onclick="" name="Submit2" value=" "  />
	      </td>  </tr>
		    			  -->
		<%
			//}}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (requestNoForAcc > 0) {
		%>
<!-- 	<tr>
		  <td>-->

		 <input type="hidden" value="<%=requestNoForAcc%>" id="requestNoForAcc" name="requestNoForAcc" />
		 <input type="hidden" name="RowL" id="RowL" value="<%=loanoutTList.size()%>"  />
	   <!--     <input type="button" class="button" tabindex="1" onclick="submitForm('issueDispensaryForm','stores?method=correctDepartmentIssueToAcknowledgement');" name="Submit2" value="Correct"  /> -->
	     <!--  </td>
	</tr>-->

	<%
		}
	%>
	</tbody>
	</table>
	
	<input type="hidden" name="counter" id="listsize"	value="<%=indentTList.size()%>" />
	<input type="hidden" name="counterL" id="listsizeL"	value="<%=loanoutTList.size()%>" />
	</div>
	<input type="button" class="button" tabindex="1" onclick="if(validateIssue() && qtyValidation()){submitForm('issueDispensaryForm','stores?method=submitIssueForIndent');}" name="Submit2" value="Submit"  />
	<!-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> --> 
<input type="hidden" id="counter" value="<%=inc%>" />
<%
	}
%>
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<input type="button" name="sss" class="button" value="MR REPORT" onclick="generateMRReport()" /> 

<div class="Clear"></div>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<div class="Clear"></div>
	<div class="bottom">
		<label>Changed By:</label>			
		<label class="value"><%=userName%></label>
        
        <label>Changed Date:</label>			
		<label class="value"><%=date%></label>

        <label>Changed Time:</label>			
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE%>" value="<%=date%>"  />
		<input type="hidden" name="<%=CHANGED_TIME%>"  value="<%=time%>" />
</div>
</form>
<%-- End of Main form --%>
<script type="text/javascript">

function civDisplay() {
	var civNo = document.depCiv.<%=DEMAND_NO%>.value	
	/*if (civNo == "0")
	{
	alert('Pl. select CIV No.');
	return;
	}*/
	
	document.depCiv.method="post";
	submitForm('depCiv','stores?method=getDepartmentIssueData&<%=DEMAND_NO%>='+civNo);
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function getdpt(){

	
	var indent_id=document.getElementById('requestNo').value;
	submitProtoAjaxdiv('issueDispensaryForm','stores?method=setDepartment&indent_id='+document.getElementById('requestNo').value);	
}
function testForAdjustLoanOut(deptName)
{
 
	var errorMessage="";
	formName="issueDispensaryForm"
	obj = eval('document.'+formName)
	
	//if(document.getElementById('issuedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Issue By \n"; 
	//if(document.getElementById('approvedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Approved By \n";

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
			//alert(errorMessage)
			return false
		}
	}
	else
	{
		if((document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		if(confirm("Are you sure, you want to import indent items ?")){
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

//javed khan

function fillItem(val,inc)
	{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*20)+1;
    	//var end=((pageNo-1)*20)+20;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   // alert(pvms)
	    //alert(val)
	   // alert(inc)
	    
	   /* for(i=start;i<=end;i++){
	    if(pvms ==""){
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return ;
	    	}
	   }*/
	    
	    
		//ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
	    ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  val , inc);
}



function ajaxFunctionForAutoCompleteIssueToDispensary(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	 // alert("javed 1>>> "+lotNo)
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
				// alert("javed 2>>> "+obj.length)
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var BG  = item.getElementsByTagName("BrandG")[0];
		        var stock  = item.getElementsByTagName("stock")[0];
		        var batchLength  = item.getElementsByTagName("batches")[0];
		       // alert("pvms.childNodes[0].nodeValue"+pvms.childNodes[0].nodeValue)
	        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
	        	// alert("id.childNodes[0].nodeValue"+id.childNodes[0].nodeValue)
	        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	        	// alert("au.childNodes[0].nodeValue"+au.childNodes[0].nodeValue)
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	// alert("name.childNodes[0].nodeValue"+name.childNodes[0].nodeValue)
	        	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
	        	
	        	//document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	// alert("BG.childNodes[0].nodeValue"+BG.childNodes[0].nodeValue)
	        	/* document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue */
	        	//alert("stock..childNodes[0].nodeValue"+stock.childNodes[0].nodeValue)
	        	/* document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue; */
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
function getDataForBarcode(val,rowVal)
{
	
    var itemId=document.getElementById('idItem'+rowVal).value;
    // javed khan on 07-08-2013
    if(validateMetaCharacters(val)){
    	submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
	}else{
	    return false;
	}
	
}


function getDataForBarBatchStockId(val,rowVal)
{
	   var itemId=document.getElementById('itemId'+rowVal).value;
    // javed khan on 07-08-2013
    if(validateMetaCharacters(val)){
    	submitProtoAjaxForBarBatchStockId('issueDispensaryForm','stores?method=getDataForBarBatchStockId&stockId='+val+'&itemId='+itemId,rowVal);
	}else{
	    return false;
	}
	
}





function test(indentId)
{
   var reqId = "";
   var reqDate = "";
	<%for (int i = 0; i < storeInternalIndentMList.size(); i++) {%>
 		if (indentId == <%=storeInternalIndentMList.get(i).getId()%>)
 		{
 		<%if (storeInternalIndentMList.get(i).getRequestedBy() != null) {%>
			reqId = '<%=storeInternalIndentMList.get(i).getRequestedBy()
							.getId()%>'
			
		<%}
				if (storeInternalIndentMList.get(i).getDemandDate() != null) {%>
 			 reqDate = '<%=HMSUtil
							.changeDateToddMMyyyy(storeInternalIndentMList.get(
									i).getDemandDate())%>'
 		<%}%>
 		}
	<%}%>
	
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
function qtyValidation(){
	var obj = document.getElementsByName("SRNo");
	flag = false;
	for(var i=1;i<=obj.length;i++){
		var issue = 0;
		if(document.getElementById("qtyIssued"+i).value!='')
			flag = true;
	}
	if(flag==false)
		alert("You have not Issue.....");
	return flag;
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
	/*if(document.getElementById("approvedBy").value=="")
	{
		alert('Select The Approved By !!!');
		document.getElementById("approvedBy").focus();
		return false;
	}*/

	/* if(document.getElementById("issuedBy").value=="")
	{
		alert('Select The Issue By !!!');
		document.getElementById("issuedBy").focus();
		return false;
	} */

	if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}else{
		return true;
	}
}
//function getDataForBarcode(val,rowVal){

	// if(val!=""){

	// submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);
	// }
	// }

function barCodefill(inc){
	var barCodeNo=document.getElementById('barCodeNo'+inc).value
	if(barCodeNo != ''){
		document.getElementById('qtyIssued'+inc).value =	document.getElementById('qtyRequested'+inc).value
		
	}
}
function getDataForBarcode(val,rowVal)
{
    var itemId=document.getElementById('itemId'+rowVal).value;
	submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
}	
function generateRowIssueCIV(rowVal)
{
	  var tbl = document.getElementById('indentDetails');
	  var lastRow = tbl.rows.length;
	  var deptId = document.getElementById('deptId').value;
	  var listSize=document.getElementById('listsize').value;
	//  alert("lastRow==="+lastRow);
	 // listSize=(parseInt(listSize))+1;
	  //alert("listSize=22=="+listSize);
	//  var iteration = listSize;
	  var iteration = lastRow-1;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo'+iteration;
	  e1.id = 'pvmsNo'+iteration;
	  e1.size='10';
	  e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	  e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);

	  /*var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;
	  e2.readOnly=true;
		 
	 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
		
	  cellRight2.appendChild(e2);*/


	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;

	e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur = function(){fillItem(document.getElementById('pvmsNo'+rowVal).value, iteration)}
	  
	  var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
  	newdiv.style.display = 'none';
	
 e2.size = '50';

	  e2.setAttribute('tabindex','1');

	          cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();

	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=nomenclature'+iteration});



	  


	 /* var cellRight222 = row.insertCell(3);
	  var e222 = document.createElement('input');
	  e222.type = 'text';
	  e222.name = 'brandGeneric' + iteration;
	  e222.id = 'BG' + iteration;
	  e222.size = '1';
	 // e222.value=document.getElementById('BG'+rowVal).value;
	  e222.readOnly=true;
	  cellRight222.appendChild(e222);

	  var cellRight21 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'barCodeNo' + iteration;
	  e21.id = 'barCodeNo' + iteration;
	  e21.size = '8';
	  e21.onblur = function(){getDataForBarcode(this.value,iteration);};
	  e21.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight21.appendChild(e21);  */
	  			 
	  var cellRight22 = row.insertCell(3);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'au' + iteration;
	  e22.id = 'au' + iteration;
	  e22.size = '7';
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);

	  //var cellRight23 = row.insertCell(6);
	  //var e23 = document.createElement('input');
	  //e23.type = 'text';
	  //e23.name = 'batchNo' + iteration;
	  //e23.id = 'batchNo' + iteration;
	  //e23.size = '10';
	 // e23.readOnly=true;
			

           
            
	  var cellRight23 = row.insertCell(4);
	  var e23 = document.createElement('Select');
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.className="small3";
	  e23.onclick=function(){fillBatchforStockId(this.value,iteration)}
	  
	  e23.onchange=function(){if(document.getElementById('batchNo'+iteration).value != 0){if(cheackForBatch(iteration)){ getDataForBarBatchStockId(this.value,iteration)}}};
	  e23.options[0] = new Option('Select Batch', '0');
	 // e23.onchange=function(){getDataForBarcode(this.value,iteration);};
	
		 
		
		  //alert(li);	  
 // for(var i = 0;i<li;i++ ){
	//  e23.options[i+1] = new Option(batchArray[i][1],batchArray [i][0]);
	   
	  
	   // }

  var e242 = document.createElement('input');
  e242.type = 'hidden';
  e242.name = 'batchId' + iteration;
  e242.id = 'batchId' + iteration;
  e242.size = '10';
  
  /* var e2422 = document.createElement('input');
  e2422.type = 'hidden';
  e2422.name = 'batchNoValue' + iteration;
  e2422.id = 'batchNoValue' + iteration;
  e2422.size = '10'; */
	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	  cellRight23.appendChild(e23);
	  cellRight23.appendChild(e24);
	  cellRight23.appendChild(e242);
	 /*  cellRight23.appendChild(e2422); */

	  var cellRight251 = row.insertCell(5);
	  var e251 = document.createElement('input');
	  e251.type = 'text';
	  e251.name = 'manuDate' + iteration;
	  e251.id = 'manuDate' + iteration;
	  e251.size = '10';
	  e251.readOnly=true;	  
	  cellRight251.appendChild(e251);
	  
	  var cellRight25 = row.insertCell(6);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);

	  var cellRight25 = row.insertCell(7);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'source' + iteration;
	  e25.id = 'source' + iteration;
	  e25.size = '7';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);
	  
	  
	  var cellRight6 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e6.size = '8';
	 // e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);



	  var cellRight613 = row.insertCell(9);
	  var e613 = document.createElement('input');
	  e613.type = 'text';
	  e613.name = 'batchStock' + iteration;
	  e613.id = 'batchStock' + iteration;
	  e613.size = '8';
	  e613.readOnly=true;
	  cellRight613.appendChild(e613);

	  var cellRight34 = row.insertCell(10);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'qtyRequest' + iteration;
	  e34.id = 'qtyRequested' + iteration;
	  e34.size = '8';

	  

	  if(document.getElementById('qtyIssued'+rowVal).value=="")
	  {	  
	   e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	  }else{
		  e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
		  document.getElementById('qtyRequested'+rowVal).value=parseInt(document.getElementById('qtyIssued'+rowVal).value);
	  }
	   
	   cellRight34.appendChild(e34);

	  /*  var cellRight341 = row.insertCell(13);
		  var e341 = document.createElement('input');
		  e341.type = 'text';
		  e341.name = 'qtyOnLoan' + iteration;
		  e341.id = 'qtyOnLoan' + iteration;
		  e341.size = '8';
		  cellRight341.appendChild(e341); */
	  
	  var cellRight35 = row.insertCell(11);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '8';
	  e35.onblur = function(){checkQty(iteration)};
	  cellRight35.appendChild(e35); 

	  var cellRight351 = row.insertCell(12);
	  var e351 = document.createElement('input');
	  e351.type = 'text';
	  e351.name = 'qtyAftrIssued' + iteration;
	  e351.id = 'qtyAftrIssued' + iteration;
	  e351.size = '8';
	  e351.readOnly=true;
	  cellRight351.appendChild(e351); 


	  //var cellRight10 = row.insertCell(12);
	


	  var cellRight21 = row.insertCell(13);
	  var e21 = document.createElement('input');
	  e21.type = 'button';
	  e21.name='remarks'+iteration;
	  e21.className = 'buttonAdd';
	  e21.setAttribute('tabindex', 1);
	  e21.onclick= function(){generateRowIssueCIV(iteration)};
	  cellRight21.appendChild(e21);
	  
	  var cellRight212 = row.insertCell(14);
	  var e19 = document.createElement('input');
	  e19.type = 'button';
	  e19.className = 'buttonDel';
	  e19.name='remarks'+iteration;
	 // e19.setAttribute('onClick', 'removeRow("issueDispensaryForm","hdb",this);'); 
	  e19.onclick= function(){removeRow("indentDetails","hdb",this)};
	  e19.setAttribute('tabindex','1');
	  cellRight212.appendChild(e19);
	  
	   
	 document.getElementById('listsize').value=listSize;
}

function checkQty(rowVal)
{// javed khan
	//var val = document.getElementById('qtyOnLoan'+rowVal).value
	//alert("0 "+val)
	//if(val == ""){
		//alert("1 "+document.getElementById('qtyOnLoan'+rowVal).value)
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			alert("Issued Quantity can't be greater than Quantity Demanded.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('batchStock'+rowVal).value))
		{
			alert("Issued Quantity can't be greater than Batch stock Quantity .");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else{
					var a=document.getElementById('qtyIssued'+rowVal).value;
				var b=document.getElementById('batchStock'+rowVal).value;
        	
			document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
		}
	/* }
	else{
		//alert(rowVal+"<< 2 "+val)
		//alert("3 "+(val + parseInt(document.getElementById('qtyIssued'+rowVal).value)))
		if((parseInt(document.getElementById('qtyOnLoan'+rowVal).value) + parseInt(document.getElementById('qtyIssued'+rowVal).value)) >  parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			alert("Qty Issued  (Qty Issued + Loanout Qty) can't be greater than Quantity Demanded.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('batchStock'+rowVal).value))
		{
			alert("Issued Quantity can't be greater than Batch stock Quantity .");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else{
					var a=document.getElementById('qtyIssued'+rowVal).value;
				var b=document.getElementById('batchStock'+rowVal).value;
        	
			document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
		}
	} */
}	
function submitProtoAjaxForBarcodeData(formName,action,rowVal)
{
	 // alert("submitProtoAjaxhjgjhg");
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

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	if(availableStock.childNodes[0].nodeValue>0){
	        		document.getElementById("qtyIssued"+rowVal).readOnly= false;
		        	document.getElementById("qtyIssued"+rowVal).focus();
	        	}
	        	
	        
	        	if(source.childNodes[0].nodeValue == "a"){
	        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        		document.getElementById("source"+rowVal).value="AFMSD";
	        	}
	        	if(source.childNodes[0].nodeValue == "L"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="LP";
		        	}
	        	if(source.childNodes[0].nodeValue =="op"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="Open Bal.";
		        	}
	        	document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Stock Is not Available ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
	  
	  
function submitProtoAjaxForBarBatchStockId(formName,action,rowVal)
{
	  //alert("submitProtoAjax");
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

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	//alert(batchId.childNodes[0].nodeValue);
	        	/* document.getElementById("batchNoValue"+rowVal).value=batchNo.childNodes[0].nodeValue; */
	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	if(availableStock.childNodes[0].nodeValue>0){
	        		document.getElementById("qtyIssued"+rowVal).readOnly= false;
		        	document.getElementById("qtyIssued"+rowVal).focus();
	        	}
	        	
	        
	        	if(source.childNodes[0].nodeValue == "a"){
	        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        		document.getElementById("source"+rowVal).value="AFMSD";
	        	}
	        	if(source.childNodes[0].nodeValue == "L"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="LP";
		        	}
	        	if(source.childNodes[0].nodeValue =="-"){
		        	//document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
		        		document.getElementById("source"+rowVal).value="Open Bal.";
		        	}
	        	document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
	        	
	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Stock Is not Available ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }



function removeRow(idName,countId,obj)
{
	//alert(countId)
	//alert(idName)
	//alert(obj)
  var tbl = document.getElementById(idName);
	//alert(tbl)
  var lastRow = tbl.rows.length;
  
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
    document.getElementById('listsize').value=parseInt(document.getElementById('listsize').value)-1;
    
  }
}

function cheackForBatch(rowVal){
   //  alert(rowVal+" --- "+document.getElementById("batchNo"+rowVal).value)
   
		if(rowVal>1){
	for(i=1;i<rowVal;i++){
		//alert(i+" --i- "+document.getElementById("batchNo"+i).value)
		if(document.getElementById("batchNo"+rowVal).value==document.getElementById("batchNo"+i).value)
		{
			alert("Please select another Batch !!!");
			document.getElementById("batchNo"+rowVal).value="0";
			return false;
		
		}
	
	}
		
}
	return true;
}

function fillBatch(val,inc)
{

	var val=document.getElementById('itemId'+inc).value;
    ajaxFunctionForAutoCompleteBatchToItem('depCiv','stores?method=fillBatchForIssueToPatient&pvmsNo=' +  val , inc);
}

function fillBatchforStockId(val,inc)
{

	var val=document.getElementById('itemId'+inc).value;
    ajaxFunctionForAutoCompleteBatchStockId('depCiv','stores?method=fillBatchforStockId&pvmsNo=' +  val , inc);
}

	  
function ajaxFunctionForAutoCompleteBatchStockId(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var batchLength  = item.getElementsByTagName("batches")[0];
		     
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];		        	
		        	var decodedString = atob(batch.getElementsByTagName("batchName")[0].childNodes[0].nodeValue);		        	
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=decodedString;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
	  

function ajaxFunctionForAutoCompleteBatchToItem(formName,action,rowVal) {
	// alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="batchNo"+rowVal;
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var batchLength  = item.getElementsByTagName("batches")[0];
		     
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
	   
	  function generateMRReport()
	  {
		  var MRNo = document.getElementById("requestNo").value;
		  
		  
		  if(MRNo != 0)
			  {
			     var url ="/hms/hms/stores?method=printDispensaryToStoreJsp&mrId="+MRNo;
			  	submitForm('issueDispensaryForm',url);
			  }
	  }


</script>