<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp  
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Dinesh
 * Create Date: 08th Feb, 2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5  
--%>


<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
	<script language="Javascript">
    
	function openPopupWindow()
	{
		
	var toDept ='35';
	var approvedBy = document.departmentIndent.<%= APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
	var requestBy = document.departmentIndent.<%= REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
	if(toDept != 0 && approvedBy != 0 && requestBy != 0 )
		{
			var internalIndentId = document.departmentIndent.internalIndentId.value;
			var deptId = document.departmentIndent.<%= FROM_WARD%>.value;
			var demandNo = document.departmentIndent.<%= DEMAND_NO%>.value;
			var demandDate = document.departmentIndent.<%= DEMAND_DATE%>.value;
			
			var url="/hms/hms/stores?method=showAddDepartmentIndentJsp&internalIndentId="+internalIndentId + "&<%=FROM_WARD%>="+deptId+ "&<%=TO_WARD%>="+toDept+ "&<%=DEMAND_NO%>="+demandNo+ "&<%=DEMAND_DATE%>="+demandDate+"&<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+approvedBy+"&<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+requestBy +"&numOfRows=5&pageNo="+1;
			newwindow=window.open(url,'name','top=0, left=5, height=800,width=1010,status=1,scrollbars=yes');
		}else{
			alert("Please Select All the fields.");
		}
	}
	
	//this function will be called by the Bean (not from JSP)
	function goPage(pidx) {	
		var internalIndentId = document.departmentIndent.internalIndentId.value;
		departmentIndent.currPage.value = pidx;
		departmentIndent.method="post";
		submitForm('departmentIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+internalIndentId);
	}
	
	function importIndent()
	{
		departmentIndent.method="post";
		var internalIndentId = document.departmentIndent.internalIndentId.value;
		var approvedBy= document.getElementById('approvedByEmployeeIdDepartmentIndent').value
		var requestBy= document.getElementById('requestByEmployeeIdDepartmentIndent').value
		var demandNo = document.departmentIndent.demandNo.value
		var importDemandNumber = document.getElementById('importDemandNumber').value ;
		if( approvedBy=="0" && requestBy=="0")
		{
		  alert("Please Select the Officer Approved And Request By.")
		  return;
		}else if (parseInt(importDemandNumber)!= 0){
		 	if(confirm("Are You sure, You want to import last indent")){
			submitForm('departmentIndent','stores?method=createAndImportDepartmentIndentData&<%=DEMAND_NO%>='+demandNo+'&importDemandNumber='+importDemandNumber);
			return true;
			} else {
			return false;
		    }
		}else {
		alert("Please select the Demand Number")
		  return;
		}
	}
	
	function upd()
	{
	departmentIndent.method="post";
	var internalIndentId = document.departmentIndent.internalIndentId.value;
	submitForm('departmentIndent','stores?method=updateGridItemsInDepartmentIndent&<%=DEMAND_NO%>='+internalIndentId);
	}
	
	function validateDeleteButton()
	{
		if (departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length)
		{
				 for(var i = 0; i < departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length; i++)
				 {
				  if (departmentIndent.<%=ITEMS_TO_BE_DELETED%>[i].checked == true){
	             		return true;
	              }
				 }
		}
		else
		{
			if (departmentIndent.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
		}
		return false;
	}
	
	function del()
	{
    var internalIndentId = document.departmentIndent.internalIndentId.value;
		if (validateDeleteButton())
		{
		departmentIndent.method="post";
		submitForm('departmentIndent','stores?method=deleteGridItemsForDepartmentIndent&<%=DEMAND_NO%>='+internalIndentId);
		}
		else
		{
		alert('No Item(s) Selected for delete!....');
		}
	}
	
	function jsDisplay() {
		var demandNo = document.searchPanel.<%=DEMAND_NO%>.value	
		if (demandNo == "")
		{
		alert('Pl. select Demand No....');
		return;
		}
		
		searchPanel.method="post";
		submitForm('searchPanel','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);
	}
	function pvmsSearch() {
		departmentIndent.method="post";
		  var internalIndentId = document.departmentIndent.internalIndentId.value;
		var pvmsNo=document.departmentIndent.pvmsNo.value;
		//alert(demandNo+"----pvms no---"+pvmsNo)
		if(pvmsNo != ""){
		
		submitForm('departmentIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+internalIndentId+'&pvmsNo='+pvmsNo+'&currPage=1');
		}else{
		   alert("Please Enter PVMS/NIV No.")
		}
	}
	function showReport(formName)
	{
	  obj = eval('document.'+formName)
	   var internalIndentId = document.departmentIndent.internalIndentId.value;
      // alert('internalIndentId '+internalIndentId)
     
	  var newDemandNo = document.getElementById('newDemandNo').value
	  //alert('newDemandNo '+newDemandNo);
 	  
	  //var approvedBy= document.getElementById('approvedByEmployeeIdDepartmentIndent').value
	  //var requestBy= document.getElementById('requestByEmployeeIdDepartmentIndent').value
	 // alert("newDemandNo=------"+newDemandNo)
	  submitForm('departmentIndent','stores?method=printDispensaryToStoreJsp&newDemandNo='+internalIndentId);
	  //obj.action = "/hms/hms/stores?method=printDispensaryToStoreJsp&newDemandNo="+internalIndentId;
	  //obj.submit();
	}
	
	</script>




<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int deptId = 0;
	int hospitalId = 0;
	String newDemandNo = "";
	
	int internalIndentId = 0;
	List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();
	
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if (map.get("internalIndentId")!=null){
		internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
	}
	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	List<MasDepartment> departmentCentralStoreList = new ArrayList<MasDepartment>();
	if(map.get("departmentCentralStoreList") != null){
		departmentCentralStoreList = (List<MasDepartment>) map.get("departmentCentralStoreList");
		session.setAttribute("departmentCentralStoreList",departmentCentralStoreList);
	}else if(session.getAttribute("departmentCentralStoreList") != null){
		departmentCentralStoreList = (ArrayList)session.getAttribute("departmentCentralStoreList");
	}
	if(map.get("searchStoreInternalIndentMList")!=null)
		searchStoreInternalIndentMList = (List) map.get("searchStoreInternalIndentMList");
	
	if(map.get("storeInternalIndentMList")!=null)
		storeInternalIndentMList = (List) map.get("storeInternalIndentMList");
	
	//System.out.println("storeInternalIndentMList in JSPPPPP----"+storeInternalIndentMList.size());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null){
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}

	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
		session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
	}

	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
		session.setAttribute("requestByEmployeeList",requestByEmployeeList);
	}else if(session.getAttribute("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList)session.getAttribute("requestByEmployeeList");
	}

	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("newDemandNo") != null){
		newDemandNo = (String)map.get("newDemandNo");
	}
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>

<%
		   out.println(message);
	}
	int deptIdForToStore = 0;
	int approvedById = 0;
	int requestById = 0;
	Date demandDate = null;
	
	
	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List)map.get("storeInternalIndentTList"); 
	}
	if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){
		//System.out.println("storeInternalIndentTList.size() in  DEparmtent Indent---"+storeInternalIndentTList.size());
		StoreInternalIndentM tObj = (StoreInternalIndentM)storeInternalIndentMList.get(0);
		deptIdForToStore = tObj.getToStore().getId();
		if(tObj.getApprovedBy() != null){
			approvedById = tObj.getApprovedBy().getId();
		}
		if(tObj.getRequestedBy() != null){
			requestById = tObj.getRequestedBy().getId();
		}
		if(tObj.getDemandDate() != null){
			demandDate = tObj.getDemandDate();
		}
		
	}
%>

<div class="titleBg"><h2>Indent To Dispensary</h2></div>
<div class="Clear"></div>
<% if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){
		StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentMList.get(0);
		if(!mObj.getStatus().equals("o")){%> 
<h4> <%="CIV already issued. cannot update " %> </h4>  <% }
	  }
	
	%>


<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<div class="clear"></div>
<label> Indent	No. </label>
<select name="<%=DEMAND_NO%>">
			<option value="">Select Indent No</option>
			<%
				for (StoreInternalIndentM mObj :searchStoreInternalIndentMList ) {
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getDemandNo()%></option>
			<%
				}
			%>
</select>
		<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
		<input			type="hidden" name="numOfRows" size="5" value="5">
		<input	type="button" name="Submit" id="addbutton" value=""	class="button" onClick="jsDisplay();" /></td>
</form>

</div>
<div class="Clear"></div>

<form name="departmentIndent" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="newDemandNo" id="newDemandNo" value="<%=newDemandNo%>" /> <input
	type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <%
	String demandNo = "";
	
	if(map.get("finalDemandNo") != null){
		demandNo = (String)map.get("finalDemandNo");
	}else if(map.get("demandNo") != null){
		demandNo = (String)map.get("demandNo");
	}
	
	%>

<h4>Details</h4>
<div class="Block">
<label>Indent No. </label>
<input	type="text" name="<%=DEMAND_NO %>" id="<%=DEMAND_NO %>"	value="<%=demandNo%>" readonly="readonly" MAXLENGTH="8"/  >
<label>Indent Date</label>
<input type="text" name="<%=DEMAND_DATE %>"	value="<%=demandDate==null?date:HMSUtil.convertDateToStringWithoutTime(demandDate)%>"	readonly="readonly" tabindex=3 />
<!-- ------- --<label>From Department</label>---------> <%
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%>
<!--<label class="value"><%=masDepartment.getDepartmentName()%></label>

--><input type="hidden" name="<%=FROM_WARD%>"
	value="<%=masDepartment.getId() %>"> 
	<%	break;	
				}
				}
			%>
<div class="Clear"></div>
<!-- ------- --<label>To Department</label>--------->
<input type="hidden" name="<%=TO_WARD%>" id="<%=TO_WARD%>" 	validate="To Ward,String,yes" 
	value="24">
<!-- --------------- <select name="<%=TO_WARD%>"	 id="<%=TO_WARD%>" validate="To Ward,String,yes" >
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :departmentCentralStoreList ) {
					if(deptIdForToStore != 0){
							
						if(masDepartment.getId() == deptIdForToStore){
							
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>
		selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%
						}else{						
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					}else{				
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>><%=masDepartment.getDepartmentName()%></option>
	<%     
	       		}
				}
			%>
</select>-->
<label><span>*</span>Request By</label>
<select	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"	id="requestByEmployeeIdDepartmentIndent"	validate="Request By,String,no">
<option value="0">Select</option>
	<%
				for (MasEmployee requestedBy :requestByEmployeeList ) {
					String doctorName = "";
					
					String rankName ="";
					if(requestedBy.getFirstName() != null){
						doctorName = requestedBy.getFirstName();
					}
					if(requestedBy.getMiddleName() != null){
						doctorName =doctorName+" "+ requestedBy.getMiddleName();
					}
					if(requestedBy.getLastName() != null){
						doctorName =doctorName+" "+requestedBy.getLastName();
					}
					if(requestedBy.getRank() != null){
						rankName = requestedBy.getRank().getRankName();
					}
					if(requestById != 0){
						if(requestedBy.getId() == requestById){
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>
		selected><%=doctorName+" "+ rankName%></option>

	<%			}else{
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=doctorName+" "+ rankName%></option>
	<%	
			}
					}else{
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=doctorName+" "+ rankName%></option>
	<%
					}
				}
			%>
</select>

<label><span>*</span>Approved By</label>
<select	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" id="approvedByEmployeeIdDepartmentIndent"	validate="Approved By,String,no">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
					
					String doctorName = "";
				
					String rankName ="";
					if(approvedBy.getFirstName() != null){
						doctorName = approvedBy.getFirstName();
					}
					if(approvedBy.getMiddleName() != null){
						doctorName =doctorName+" "+ approvedBy.getMiddleName();
					}
					if(approvedBy.getLastName() != null){
						doctorName =doctorName+" "+approvedBy.getLastName();
					}
					if(approvedBy.getRank() != null){
						rankName = approvedBy.getRank().getRankName();
					}
					
					if(approvedById != 0){
						if(approvedBy.getId() == approvedById){
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>
		selected="selected"><%=doctorName+" "+ rankName%></option>
	<%			}else{
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=doctorName+" "+rankName %></option>
	<%	
						}	
					}else{
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=doctorName+" "+rankName %></option>
	<%
					}
				}
			%>
</select>
</div>
<div class="clear"></div>
<input type="button" name="Import Previous Indent" type="submit"	value="Import Previous Indent" onClick="" class="buttonBig">

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input	type="hidden" name="internalIndentId"	value="<%=map.get("internalIndentId") == null?0:map.get("internalIndentId")%>" />
<div class="Clear"></div>
<% if (pagedArray==null) {  %>
<div class="Clear paddingTop15"></div>

<!--<label>Indent No.</label>
<select name="importDemandNumber" id="importDemandNumber" >
			<option value="0">Select Indent No.</option>
			<%
				for (StoreInternalIndentM mObj :searchStoreInternalIndentMList )
				{
					if((mObj!=null)&&(mObj.getDemandDate()!=null))
					{
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getDemandNo()+"("+HMSUtil.convertDateToStringWithoutTime((Date)mObj.getDemandDate())+")"%></option>
			<%
					}
					}
			%>
</select>
<input type="button" name="Submit" id="addbutton" value="Import Last Indent" class="buttonBig" onClick="importIndent();" />
<% } %>
--><div class="Clear"></div>

<% if (pagedArray == null) { %>


<div class="clear paddingTop15"></div>
<h4>Indent Details</h4>
<table width="100%" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl No</th>
			<th width="13%">PVMS/NIV No</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="10%">Stock In Hand</th>
			<!--<th width="13%">MMF Qty</th>-->
			<th width="10%">Qty Loan Rec.</th>
			<th width="10%">Qty Demanded</th>
			<th width="10%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8>No Data Found</td>
		</tr>
	</tbody>
</table>

<% } else { %>
<!--<label>PVMS/NIV</label>
<input type="text"	name="pvmsNo" value="" /> <IMG SRC="/hms/jsp/images/search.gif"	WIDTH="26" HEIGHT="26" style="cursor: pointer; float: left;"	onClick="javascript:pvmsSearch();"	title="Click here to Search Pvms/Niv">
-->
<div class="clear paddingTop15"></div>
<h4>Indent Details</h4>
<div id="pagination"><span><%= pagedArray.showIndex()%></span> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<table width="100%" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="10%">Stock In Hand</th>
			<!--<th width="13%">MMF Qty</th>
			-->
			<th width="10%">Qty Loan Rec.</th>
			<th width="10%">Qty Demanded</th>
			<th width="10%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			  %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				name="srno" size="2" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")%>" size="10" name="pvms"
				readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" size="50"
				name="nomenclature" title="<%=gridData[i].get("commonName") %>" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				size="10" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("stock")%>" name="stock" size="10"
				validate="Stock In Hand,num,no" readonly="readonly" /></td>
			<!--<td width="12%"><input type="text"
				value="<%=gridData[i].get("qtymmf")%>" size="10" name="qtymmf"
				validate="MMF Qty,num,no" readonly="readonly" /></td>
			--><td width="10%"><input type="text"
				value="<%=gridData[i].get("qtyRequest")%>" size="10"
				name="qtyRequest" validate="Qty Demand,num,no" /></td>
				<td width="10%"><input type="text"
				value="" size="10"
				name="qtyLoan" validate="Qty Loan,num,no" /></td>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> class="radio"
				value="<%=gridData[i].get("id")%>"></td>
			<input type="hidden"	value="<%=gridData[i].get("id")%>" name="id" />
		</tr>
		<% } %>
	</tbody>
</table>

<div class="Clear"></div>

<% } %>
<div class="Clear"></div>
<div class="division"></div>

		<%
							if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){
								
								StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentMList.get(0);
								//System.out.println(";;;;;;;;;;;;;;---"+storeInternalIndentMList.size() );
								if(mObj.getStatus().equals("o")){
								//	System.out.println(";;;;;;;;;;;;;;@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ IN IF");
						%>
			<input type="button" name="New" type="submit" value="New"	onClick="submitForm('departmentIndent','stores?method=showDepartmentIndentJsp')" class="button">
			<input type="button" name="Add" type="submit"	value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" value="Update" onClick="upd();" class="button"></td>
			<input type="hidden" name="Reset" type="submit"	value="Reset" class="button"></td>
			<input type="button" name="Delete"	type="submit" onClick="del();" value="Delete" class="button">
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('departmentIndent');">
				<%}else{ 
					    	//System.out.println(";;;;;;;;;;;;;;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! IN ELSE");
					    %>
			<input type="button" name="New" type="submit" value="New" onClick="submitForm('departmentIndent','stores?method=showDepartmentIndentJsp')"	class="button">
			<input type="button" name="Add" type="submit" disabled value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" disabled value="Update" onClick="upd();"	class="button">
			<input type="hidden" name="Reset" type="submit"	disabled value="Reset" class="button">
			<input type="button" name="Delete"	type="submit" disabled onClick="del();" value="Delete"	class="button">
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('departmentIndent');">
				<%}
							}else{
								//System.out.println(";;;;;;;;;;;;;;storeInternalIndentMList is nulllllllllllllll");
							%>
			<input type="button" name="Add" type="submit" value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" value="Update" onClick="upd();" class="button">
			<input type="hidden" name="Reset" type="submit"	value="Reset" class="button">
			<input type="button" name="Delete"	type="submit" onClick="del();" value="Delete" class="button">
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('searchPanel');">
				<%} %>
				<div class="Clear"></div>
<div class="division"></div>
</form>
</div>
<script type="text/javascript">

     //alert(" to -"+document.getElementById('toWard').value);
   // if(document.getElementById('toWard').value==0)
   // document.getElementById('toWard').value=24;  
   
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	
	</script>