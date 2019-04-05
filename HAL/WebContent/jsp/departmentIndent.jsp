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
<%@page import="jkt.hms.masters.business.StoreLoanoutExpendT"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

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
		
	var toDept ='24';
	var approvedBy = document.departmentIndent.<%= APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
	var requestBy = document.departmentIndent.<%= REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
	if(toDept != 0 && approvedBy != 0 && requestBy != 0 )
		{
			var internalIndentId = document.departmentIndent.internalIndentId.value;
			var deptId = document.departmentIndent.<%= FROM_WARD%>.value;
			var demandNo = document.departmentIndent.<%= DEMAND_NO%>.value;
			var demandDate = document.departmentIndent.<%= DEMAND_DATE%>.value;
			//alert("-->>"+internalIndentId)
			var url="/hms/hms/stores?method=showAddDepartmentIndentJsp&internalIndentId="+internalIndentId + "&<%=FROM_WARD%>="+deptId+ "&<%=TO_WARD%>="+toDept+ "&<%=DEMAND_NO%>="+demandNo+ "&<%=DEMAND_DATE%>="+demandDate+"&<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+approvedBy+"&<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+requestBy +"&numOfRows=5&pageNo="+1;
			newwindow=window.open(url,'name','top=0, left=5, height=650,width=1010,status=1,scrollbars=yes');
		}else{
			alert("Please Select All the fields.");
		}
	}
	
	//this function will be called by the Bean (not from JSP)
	
		// javed khan 
	function goPage(pidx) {	
		//alert(pidx);
		
		var internalIndentId = document.departmentIndent.internalIndentId.value;
		//alert("document.departmentIndent.internalIndentId.value "+internalIndentId );
		document.departmentIndent.currPage.value = pidx;
		//alert(pidx);
		document.departmentIndent.method="post";
		//alert(internalIndentId);
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


// javed khan 
	
	function validateDeleteButton()
	{
		if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length)
		{
				 for(var i = 0; i < document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length; i++)
				 {
				  if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>[i].checked == true){
	             		return true;
	              }
				 }
		}
		else
		{
			if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
		}
		return false;
	}


	
	function del()
	{
    var internalIndentId = document.departmentIndent.internalIndentId.value;
		if (validateDeleteButton())
		{
		document.departmentIndent.method="post";
		submitForm('departmentIndent','stores?method=deleteGridItemsForDepartmentIndent&<%=DEMAND_NO%>='+internalIndentId);
		}
		else
		{
		alert('No Item(s) Selected for delete!....');
		}
	}
	
	function jsDisplay() {
		var demandNo = document.depIndent.<%=DEMAND_NO%>.value	
		//if (demandNo == "")
		//{
		//alert('Pl. select Demand No....');
		//return;
		//}
		document.depIndent.method="post";
		<%--submitForm('depIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);--%>
		//submitForm('depIndent','stores?method=getDepartmentIndentSearchData&<%=DEMAND_NO%>='+demandNo);
		submitForm('depIndent','stores?method=getDepartmentIndentSearchData&<%=DEMAND_NO%>='+demandNo);
	}
	function pvmsSearch() {
		departmentIndent.method="post";
		  var internalIndentId = document.departmentIndent.internalIndentId.value;
		var pvmsNo=document.departmentIndent.pvmsNo.value;
		//alert(demandNo+"----pvms no---"+pvmsNo)
		if(pvmsNo != ""){
		
		submitForm('departmentIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+internalIndentId+'&pvmsNo='+pvmsNo+'&currPage=1');
		}else{
		   alert("Please Enter Med Code.")
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

	function closeSearch()
	{

	document.getElementById('searchBlock').style.display = 'none';
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
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int deptId = 0;
	int hospitalId = 0;
	String newDemandNo = "";
	int de=0;

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
	
	List<StoreLoanoutExpendT> loanoutTList = new ArrayList<StoreLoanoutExpendT>();
	if(map.get("loanoutTList") != null){
		loanoutTList = (List<StoreLoanoutExpendT>)map.get("loanoutTList"); 
	}
%>

<div class="titleBg"><h2>Material Requisition To Stores</h2></div>


<div class="Clear"></div>
<% if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){
		StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentMList.get(0);
		// comment by javed 23 may 2012
		//if(!mObj.getStatus().equals("o") ){
		if(!mObj.getStatus().equals("o") && !mObj.getStatus().equals("u")){
		%> 
<h4> <%="CIV already issued. cannot update " %> </h4>  <% }
	  }
	
	%>



<div id="searchBlock" style="display:none;">
 
<form name="depIndent" method="post" action="">
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

<div class="clear"></div>
<label>From Date</label>

<input	type="text" name="<%= FROM_DATE %>" id="fromDate" class="date" maxlength="30" tabindex=1  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromDate')"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.depIndent.<%=FROM_DATE%>,event)" />

<label>To	Date</label>
<input	type="text" name="<%= TO_DATE %>"  id="toDate" class="date" maxlength="30" tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'toDate')" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1"	onClick="setdate('<%=currentDate%>',document.depIndent.<%=TO_DATE%>,event)" />
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
		<input type="hidden" name="numOfRows" size="5" value="5">
		<input type="button" name="sss" class="button" value="SEARCH" onClick="jsDisplay();" />
		<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />
		
		
</form>
</div>
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
<label>MR No. </label>
<input	type="text" name="<%=DEMAND_NO %>" id="<%=DEMAND_NO %>"	value="<%=demandNo%>" readonly="readonly" MAXLENGTH="8"/  >
<label>Date</label>
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
<label>Requested By<span>*</span></label>
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
	<option value="<%=requestedBy.getId()%>" <%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %> selected><%=doctorName%></option>
	<%}else{%>
	<option value="<%=requestedBy.getId()%>" <%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %> ><%=doctorName%></option>
	<%}}else{%>
	<option value="<%=requestedBy.getId()%>" <%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %> ><%= doctorName%></option>
	<%}}%>
</select>
<div class="clear"></div>
<label>Approved By<span>*</span></label>
<select	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" id="approvedByEmployeeIdDepartmentIndent"	validate="Approved By,String,no">
	<option value="0">Select</option>
	<%for (MasEmployee approvedBy :approvedByEmployeeList ) {
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
	<option value=<%=approvedBy.getId()%>	<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>		selected="selected"><%=doctorName %></option>
	<%}else{%>
	<option value=<%=approvedBy.getId()%> <%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %> ><%=doctorName %></option>
	<%	}}else{%>
	<option value=<%=approvedBy.getId()%><%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=doctorName %></option>
	<%}}%>
</select>
</div>
<div class="clear"></div>
<%
 //de=searchStoreInternalIndentMList.get(0).getId();
%>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>%-" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input	type="hidden" name="internalIndentId"	id="internalIndentId" value="<%=map.get("internalIndentId") == null?0:map.get("internalIndentId")%>" />
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
--><% } %>
<div class="Clear"></div>

<% if (pagedArray == null) { %>


<div class="clear paddingTop15"></div>
<h4>MR Details</h4>
<table width="100%" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl  No.</th>
			<th width="13%">Mat Code</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="10%">Available Stock</th>
			<!--<th width="13%">MMF Qty</th>-->
<!-- 			<th width="10%">Qty Loaned in</th> -->
			<th width="10%">Qty Demanded</th>
			<th width="10%">Reason for Demand</th>
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
<input type="text"	name="pvmsNo" value="" /> <IMG SRC="/hms/jsp/images/search.gif"	WIDTH="26" HEIGHT="26" style="cursor: pointer; float: left;"	onClick="javascript:pvmsSearch();"	title="Click here to Search Pvms/Niv">-->

<div class="clear paddingTop15"></div>
<h4>MR Details</h4>
<div id="pagination"><span><%= pagedArray.showIndex()%></span> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<div STYLE=" height:350px; width: 1000px; font-size: 12px; overflow: auto;">
<table width="100%" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl  No.</th>
			<th width="13%">Mat Code</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="10%">Available Stock</th>
			<!--<th width="13%">MMF Qty</th>-->
			
<!-- 			<th width="10%">Qty Loaned in</th> -->
			<th width="10%">Qty Demanded</th>
			<th width="10%">Reason for Demand</th>
			<th width="10%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<%
			   gridData = (HashMap[])pagedArray.getPagedArray();
		int a = pagedArray.getTotalCount();
	
		
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
			-->
			<% // javed khan 
			int chk=0;
			for(StoreLoanoutExpendT slet : loanoutTList){
			if((slet.getItem().getId())==(Integer.parseInt((gridData[i].get("itemId")).toString()))) {chk++;
			%>
<%-- 			<td width="10%"><input type="text" value=<%=slet.getQtyIssued() %> size="10" --%>
<!-- 				name="qtyLoan" validate="Qty Loan,num,no" /></td> -->
		<%break;}} %>
		<% if(chk==0){%>
<!-- 		<td width="10%"><input type="text" value="" size="10" -->
<!-- 				name="qtyLoan" validate="Qty Loan,num,no" /></td> -->
				<%} %>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qtyRequest")%>" size="10"
				name="qtyRequest" validate="Qty Demand,num,no" /></td>
				<%if(gridData[i].get("reason") != null) {%>
				<td width="10%"><input type="text"
				value="<%=gridData[i].get("reason")%>" size="20"
				name="reason" validate="reasonForDemand,String,no" /></td>
				<%}else{ %>
				<td width="10%"><input type="text"
				value="" size="20"
				name="reason" validate="reasonForDemand,String,no" /></td>
				<%} %>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> class="radio"
				value="<%=gridData[i].get("id")%>"></td>
			<input type="hidden"	value="<%=gridData[i].get("id")%>" name="id" />
		</tr>
		<% } %>
		
	</tbody>
</table>
</div>

<div class="Clear"></div>

<% } %>
<div class="Clear"></div>
<div class="division"></div>

		<%
							if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){
								
								StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentMList.get(0);
								if(mObj.getStatus().equals("o")){
						%>
			<!--  <input type="button" name="New" type="submit" value="New"	onClick="submitForm('departmentIndent','stores?method=showDepartmentIndentJsp')" class="button">-->
			<input type="button" name="Add" type="submit"	value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" value="Update" onClick="upd();" class="button"></td>
			<input type="hidden" name="Reset" type="submit"	value="Reset" class="button"></td>
			<input type="button" name="Delete"	type="submit" onClick="del();" value="Delete" class="button">
			<input	type="button" name="Add" onClick="jsSubmit()" value="Submit"	class="button" />
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('departmentIndent');">
			<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
				<%}else if(mObj.getStatus().equals("u")){%>
								<!--<input type="button" name="New" type="submit" value="New"	onClick="submitForm('departmentIndent','stores?method=showDepartmentIndentJsp')" class="button">-->
			<input type="button" name="Add" type="submit"	value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" value="Update" onClick="upd();" class="button"></td>
			<input type="hidden" name="Reset" type="submit"	value="Reset" class="button"></td>
			<input type="button" name="Delete"	type="submit" onClick="del();" value="Delete" class="button">
			<input	type="button" name="Add" onClick="jsSubmit()" value="Submit"	class="button" />
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('departmentIndent');">
			<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
								<%}else{
								 
					    %>
		<!--	<input type="button" name="New" type="submit" value="New" onClick="submitForm('departmentIndent','stores?method=showDepartmentIndentJsp')"	class="button">-->
			<input type="button" name="Add" type="submit" disabled value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" disabled value="Update" onClick="upd();"	class="button">
			<input type="hidden" name="Reset" type="submit"	disabled value="Reset" class="button">
			<input type="button" name="Delete"	type="submit" disabled onClick="del();" value="Delete"	class="button">
			<input	type="button" name="Add" onClick="jsSubmit()" value="Submit"	class="button" />
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('departmentIndent');">
			<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
				<%}
							}else{
							%>
			<input type="button" name="Add" type="submit" value="Add" onClick="openPopupWindow();" class="button">
			<input type="hidden" name="Update"	type="submit" value="Update" onClick="upd();" class="button">
			<input type="hidden" name="Reset" type="submit"	value="Reset" class="button">
			<input type="button" name="Delete"	type="submit" onClick="del();" value="Delete" class="button">
			<input	type="button" name="Add" onClick="jsAdd()" value="Submit"	class="button" />
			<input type="button" name="print" type="submit"	class="button" value="Print" onClick="showReport('searchPanel');">
			<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
				<%} %>
				<div class="Clear"></div>
<div class="division"></div>
</form>
</div>
<script type="text/javascript">

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function jsSubmit()
{
		//if(validateButton()){
		//departmentIndent.method="post";
		//var internalIndentId = document.indentForm.internalIndentId.value;
		//var deptId = document.indentForm.<%= FROM_WARD%>.value;
		//var toDept = document.indentForm.<%= TO_WARD%>.value;
		//var demandNo = document.indentForm.<%= DEMAND_NO%>.value;
		//var demandDate = document.indentForm.<%= DEMAND_DATE%>.value;
		
		var internalIndentId=document.departmentIndent.internalIndentId.value
		//alert(internalIndentId );
		submitForm('departmentIndent','stores?method=doAddInternalIndentsubmit&internalIndentId='+internalIndentId );
		//}
}

     //alert(" to -"+document.getElementById('toWard').value);
   // if(document.getElementById('toWard').value==0)
   // document.getElementById('toWard').value=24;  
   
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	
	</script>