<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartment.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  Deepali
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
mmfDepartment.method="post";
var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	if(mmfDate != 0){
		var mmfMasterId = document.mmfDepartment.<%=MMF_DEPARTMENT_M_ID %>.value;
		var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
		var mmfNo = document.mmfDepartment.mmfNo.value;
		var remarks = document.mmfDepartment.<%=REMARKS %>.value;
		var storeType = document.mmfDepartment.storeType.value;
		var preparedBy=document.mmfDepartment.<%=PREPARED_BY %>.value;
		var month=document.mmfDepartment.<%=MONTH %>.value;
		var checkedBy=document.mmfDepartment.<%=CHECKED_BY %>.value;
		//var approvedBy = document.mmfDepartment.<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>.value;
		var url="/hms/hms/stores?method=showAddMmfDepartmentJsp&mmfMasterId="+mmfMasterId + "&<%=MMF_DEPARTMENT_DATE%>=" + mmfDate +"&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>="+deptId+"&mmfNo="+mmfNo+"&<%=REMARKS%>="+remarks+"&storeType="+storeType+"&numOfRows=15&pageCount=10&currPage=1&checkedBy="+<%=CHECKED_BY%>+"&preparedBy="+<%=PREPARED_BY%>+"&month="+month;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=850,status=1');
	}else{
		alert("Please Select Year.");
	}
}
	
//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	mmfDepartment.currPage.value = pidx;
	var pvmsNo=document.mmfDepartment.pvmsNo.value;
	mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=getMmfDepartmentData');
}
function reset(){
mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=resetMmfDepartmentData');
}

function importMMF()
{
var flagForRefresh=document.mmfDepartment.flagForRefresh.value;
mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=createAndImportMmfDepartmentData&numOfRows=10&pageCount=10&currPage=1&flagForRefresh='+flagForRefresh);
}

function upd()
{
mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=updateGridItemsInMmf');
}

	function checkForMmfData1()
	{
	mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=getCurrentYearMmf&numOfRows=10&pageCount=10&currPage=1');
	//document.getElementById('addbutton').disabled = true;
	}

function validateDeleteButton()
{
	if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=deleteGridItemsForMmf');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function jsDisplay() {
	var docNo = document.searchPanel.<%=DOC_NO%>.value	
	if (docNo == "")
	{
	alert('Pl. select MMF No....');
	return;
	}
	var checkedBy=document.mmfDepartment.<%=CHECKED_BY %>.value;
	var preparedBy=document.mmfDepartment.<%=PREPARED_BY %>.value;
	 
	var storeType = document.mmfDepartment.storeType.value;
	var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
	var flagValue="true";
	
	searchPanel.method="post";
	submitForm('searchPanel','stores?method=searchMmfDepartmentData&checkedBy='+<%=CHECKED_BY%>+'&preparedBy='+<%=PREPARED_BY%>+'&flag='+flagValue+'&storeType='+storeType+'&<%=MMF_DEPARTMENT_DATE%>='+mmfDate+'&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>=' + deptId+'&<%=DOC_NO%>='+docNo+'&numOfRows=10&pageCount=10&currPage=1');
}
  function showReport(formName)
{
  obj = eval('document.'+formName)
  var docId = document.getElementById('docId').value
  var storeType = document.mmfDepartment.storeType.value;
  obj.action = "/hms/hms/stores?method=printMmfEntryJsp&storeType="+storeType+"&docId="+docId;
  obj.submit();
}
function pvmsNomenclatureSearch() 
{
	//	mmfDepartment.method="post";
	//	var docId = document.mmfDepartment.docId.value;
	//	var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
		var pvmsNo1=document.mmfDepartment.pvmsNo1.value;
		var pvmsNo=pvmsNo1;
	//	var storeType = document.mmfDepartment.storeType.value;
	//	var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
	
		//alert(demandNo+"----pvms no---"+pvmsNo)
		
		
		submitForm('mmfDepartment','stores?method=getMmfDepartmentData&pvmsNo='+pvmsNo+'&numOfRows=10&pageCount=10&currPage=1');
	
}	
</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else 
	{
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else 
	{
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<%
	Box box = HMSUtil.getBox(request);
	String pvmsNo="";
	String pvmsNo1="";
	pvmsNo=box.getString("pvmsNo");
	Vector mmfTItems = new Vector();
	mmfTItems=box.getVector("mmfTItems");
	box.put("mmfTItems",mmfTItems);
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String userName = "";
	int hospitalId = 0;
	String  docId = "";
	int currentPage=0;
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreFyDocumentNo> mmfNoList = new ArrayList<StoreFyDocumentNo>();
	List<StoreMmfDepartmentM> storeMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	String flagForRefresh="";
	
	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	//System.out.println("deptId IN MMF DEPARTMENT.JSP----------"+deptId);
	if (session.getAttribute("userName") != null)
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	//System.out.println("hospitalId IN JSP " + hospitalId);
	
	
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		
		//System.out.println("box values " + box);
		//System.out.println("map values " + map);
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	 String[] months = {"January", "February",
	            "March", "April", "May", "June", "July",
	            "August", "September", "October", "November",
	            "December"};
	 int monthForMMF=0;
	 if(map.get("month") != null)
	 {
		 monthForMMF=(Integer)map.get("month");
	 }
	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}
	
	if(map.get("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
		session.setAttribute("approvedByList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByList");
		
	}
	
	if(map.get("mmfNoList")!=null)
	{
		mmfNoList = (List) map.get("mmfNoList");
	}
	
	if(map.get("docId")!=null)
	{
		docId = (String)map.get("docId");
		box.put("docId",docId);
	}
	
	if(map.get("remarks")!=null)
	{
		box.put(REMARKS, map.get("remarks").toString());
	}
	if(map.get("checkedBy")!=null)
	{
		box.put(CHECKED_BY, map.get("checkedBy").toString());
	}
	if(map.get("preparedBy")!=null)
	{
		box.put(PREPARED_BY, map.get("preparedBy").toString());
	}
	//System.out.println("DocId IN JSPPPPPPPPPP   "+docId);
	int currentYear=0;
	int previousYear=0;
	if(box.getInt(MMF_DEPARTMENT_DATE)!=0 ){
		currentYear=box.getInt(MMF_DEPARTMENT_DATE);
		previousYear=currentYear-1;
	}
	if(map.get("currentYear")!=null)
		currentYear = (Integer) map.get("currentYear");
	if(map.get("previousYear")!=null)
		previousYear = (Integer) map.get("previousYear");
	if(box.get("flag")!=null&&box.get("flag").equals("true")){
		String docNo="";
		docNo=box.get(DOC_NO);
		currentYear=Integer.parseInt(docNo.substring(3));
		previousYear=currentYear-1;
	}
	if(map.get("searchStoreMmfDepartmentMList")!=null)
		searchStoreMmfDepartmentMList = (List) map.get("searchStoreMmfDepartmentMList");
	
	if(map.get("storeMmfDepartmentMList")!=null)
		storeMmfDepartmentMList = (List) map.get("storeMmfDepartmentMList");

	//System.out.println("map in Jsp "+map);
	
%>
<div class="titleBg">
<h2>MMF Department Entry</h2>
</div>
<div class="Clear"></div>

		<%
					if(storeMmfDepartmentMList != null && storeMmfDepartmentMList.size() > 0)
						{
								StoreMmfDepartmentM mObj = (StoreMmfDepartmentM) storeMmfDepartmentMList.get(0);
								System.out.println(";;;;;;;;;;;;;; "+mObj.getStatus());
								if(mObj.getStatus().equals("o"))
								{
							%> 
<input type="button" name="Add" type="submit" value="Add" onClick="openPopupWindow();" class="button"> 
<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"> 
<input type="button" name="Delete" type="submit" onClick="del();" value="Delete" class="button"> 
<input type="button" name="print"  type="submit" class="button" value="Print" onClick="showReport('mmfDepartment');"> 
<%	} else {
				%> 
<input type="button" name="Add" type="submit" disabled	value="Add" onClick="openPopupWindow();" class="button"> 
<input			type="button" name="Update" type="submit" disabled value="Update" onClick="upd();" class="button"> 
<input type="button" name="Delete" type="submit" disabled onClick="del();" value="Delete" class="button"> 
<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport('mmfDepartment');"> 
<%	 }
					} else {
				%> 
<input type="button" name="Add" type="submit" value="Add" onClick="openPopupWindow();" class="button"> 
<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"> 
<input type="button" name="Delete" type="submit" onClick="del();" value="Delete" class="button"> 
<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport('searchPanel');"> <%	} %>
<div class="Clear"></div>
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<div class="clear"></div>
<label class="bodytextB"> MMF No. </label> 
<select name="<%=DOC_NO%>">
	<option value="">Select MMF No</option>
			<%
				for (StoreMmfDepartmentM mObj : searchStoreMmfDepartmentMList) {
			%>
			<option value=<%=mObj.getDocNo()%>><%=mObj.getDocNo()%></option>
			<%
				}
			%>
		</select> 
<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" /> 
<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="jsDisplay();" />			 
</form>
</div>

<div class="Clear"></div>
<form name="mmfDepartment" method="post"><input type="hidden"
	name="numOfRows" size="10" value="10"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="docId" id="docId" value="<%=docId%>" /> <%
	String mmfNo = "";
	if (map.get("finalMmfNo") != null) {
		mmfNo = (String) map.get("finalMmfNo");
	} else if (map.get("mmfNo") != null) {
		mmfNo = (String) map.get("mmfNo");
	}
%> <input type="hidden" name="mmfNo" value="<%=mmfNo%>">
<h4>Details</h4>
<div class="Clear"></div>
<div class="Block">
<label>Dept Name</label> 
<%
 	//System.out.println("departmentList in MMF DEPARTMENT__JSP---"
 		//	+ departmentList.size());
 	for (MasDepartment masDepartment : departmentList) {
 		if (masDepartment.getId() == deptId) {
 %> 
<label class="value"><%=masDepartment.getDepartmentName()%></label>
<input type="hidden"
	name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>"
	value="<%=masDepartment.getId() %>"> <%
 	break;
 		}
 	}
 %> 
 
 <label>Year</label> <select name="<%=MMF_DEPARTMENT_DATE %>"
	 validate="Year,String,yes" tabindex=1>
	<option value="0">Select</option>

	<%
		int mmfDate = 0;
		if (map.get("mmfDate") != null) {
			mmfDate = (Integer) map.get("mmfDate");
			if (mmfDate == Integer.parseInt(date.substring(6))) {
	%>
	<option value="<%=Integer.parseInt(date.substring(6))-1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))-1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) - 1%>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>
		selected><%=date.substring(6)%></option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) + 1%>
	</option>
	<%
		} else if (mmfDate == Integer.parseInt(date.substring(6)) + 1) {
	%>

	<option value="<%=Integer.parseInt(date.substring(6))-1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))-1),box.getString(MMF_DEPARTMENT_DATE)) %>
		selected><%=Integer.parseInt(date.substring(6)) - 1%></option>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>><%=date.substring(6)%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>
		selected><%=Integer.parseInt(date.substring(6)) + 1%></option>
	<%
		}
		} else {
	%>
	<option value="<%=Integer.parseInt(date.substring(6))-1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))-1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) - 1%>
	</option>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>><%=date.substring(6)%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) + 1%>
	</option>
	<% } %>
	
</select> 

<label>Month</label>

<select name="<%=MONTH %>" id="<%=MONTH %>" onchange="checkForMmfData1()" >
<%if(monthForMMF ==0 ){ %>
<option  value="0">ALL</option>
<%  for(int i=0;i<months.length;i++) {%>

<option  value="<%=i+1 %>"><%=months[i] %></option>
<%} %>

<%}else { %>
<option  value="<%=monthForMMF+1 %>"><%=months[monthForMMF-1] %></option>;
<% }%>
</select>
<label>MMF Type</label> <select name="storeType"
	onchange="checkForMmfData1()" tabindex=1>
	<option value='e'
		<%if(box.get("storeType")!=null&&box.get("storeType").equals("e") )
			{%>
		selected <%} %>>Expendable Store</option>
	<option value='h'
		<%if(box.get("storeType")!=null&&box.get("storeType").equals("h") )
	{%>
		selected <%} %>>ECHS</option>
</select>
<div class="Clear"></div>
<label>Remarks</label> <input type="text" name="<%=REMARKS %>"
	value="<%=box.get(REMARKS) %>" tabindex=1 MAXLENGTH="30" /> <%-- <label
	>Approved By:</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	<%
		int approvedId = 0;
		if (map.get("approvedId") != null) {
			approvedId = (Integer) map.get("approvedId");
			System.out.println("approved Id " + approvedId);
		}
		if (approvedId != 0) {
			
			for (MasEmployee approvedBy : approvedByEmployeeList) {
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
				if (approvedBy.getId() == approvedId) {
	%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>
		selected><%=doctorName+" "+rankName%></option>
	<%
		} else {
	%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>><%=doctorName+" "+rankName%></option>

	<%
		}
			}
		} else {
			for (MasEmployee approvedBy : approvedByEmployeeList) {
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
				
	%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>><%=doctorName+" "+rankName%></option>
	<%
		}
		}
	%>
</select> --%> <label>Prepared By</label> 
<select value="0" name="preparedBy">

<%for(MasEmployee masEmployee :approvedByEmployeeList){ 
String lastName="";
if(masEmployee.getLastName() !=null){
lastName=masEmployee.getLastName(); }%>
<option value="<%=masEmployee.getId() %>"> <%=masEmployee.getFirstName() +" "+lastName%></option>
<%} %>
</select>
<label>Checked By</label> <select value="0" name="checkedBy">

<%for(MasEmployee masEmployee2 :approvedByEmployeeList){ 
String lastName="";
if(masEmployee2.getLastName() !=null){
lastName=masEmployee2.getLastName(); }%>
<option value="0">Select</option>
<option value="<%=masEmployee2.getId() %>"> <%=masEmployee2.getFirstName() +" "+lastName%></option>
<%} %>
</select>
<div class="Clear"></div>
</div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_M_ID %>"
	value="<%=map.get("mmfMasterId") == null?0:map.get("mmfMasterId")%>" />
<div class="Clear"></div>
<%
	if (pagedArray == null&&(!(box.getString("pvmsNo").equals(""))) ){
%> <label class="noWidth"><span>No Data Found For Search</span></label>
<%	} %> <%
	if (pagedArray == null&&box.getString("pvmsNo").equals("")) {
%> <input type="button" name="Submit" id="addbutton" value="Import"
	class="button" onClick="importMMF();" /> <%
	}
%> <%
	if (pagedArray == null) {
%>
<div class="Clear"></div>
<h4>MMF Department Details</h4>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="75%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<!--shailesh change for adding column  -->
			<th width="5%">SR No.</th>
			<th width="10%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="10%">MMF <%if(previousYear!=0) %><%=previousYear%></th>
			<th width="10%">Requested MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="10%">Approved MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="13%">Remarks</th>
			<th width="10%">Delete</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
<%
	} else {
%>
<div class="Clear"></div>
<label>PVMS/NIV</label> <input type="text" name="pvmsNo1"
	value="<%=pvmsNo1 %>" tabindex=1 class="textbox_size20" /> <IMG
	SRC="/hms/jsp/images/s_search.gif" WIDTH="26" tabindex=1 HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:pvmsNomenclatureSearch();"
	title="Click here to Search Pvms/Niv" /> <input type="hidden"
	name="pvmsNo" value="<%=pvmsNo %>" />
<div class="Clear"></div>
<label class="noWidth"><span>Items Marked As Red are
Already Approved</span></label>
<div class="Clear"></div>
<div class="blockTitle">MMF Department Details</div>
<div class="blockTitleCurve"></div>

<div class="tableHolderAuto">

<table colspan="1" id="mmfDepartmentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<!--shailesh change for adding column  -->
			<th width="5px">SR No</th>
			<th width="5px">PVMS No</th>
			<th width="10px">Nomenclature</th>
			<th width="5px">A/U</th>
			<th width="5px">MMF <%if(previousYear!=0) %><%=previousYear%></th>
			<th width="5px">Requested MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="5px">Approved MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="5px">Remarks</th>
			<th width="5px">Delete</th>
		</tr>
	</thead>
	<tbody>
		<%
			gridData = (HashMap[]) pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
				for (int i = 0; i < gridData.length; i++) {
		%>
		<tr>
			<td width="5%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=iFirstRow++%>" size="2" name="srno" readonly="readonly" />
			</td>
			<td width="13%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text" size="8"
				value="<%=gridData[i].get("pvms")==null?"":gridData[i].get("pvms")%>"
				name="pvms" readonly="readonly" /></td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				size="50"
				value="<%=gridData[i].get("nomenclature")==null?"":gridData[i].get("nomenclature")%>"
				name="nomenclature" readonly="readonly" /></td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				size="10" name="au" readonly="readonly" /></td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=gridData[i].get("preQtymmf")%>" name="preQtymmf" size="10"
				validate="MMF Qty,num,no" maxlength="10" readonly="readonly" /></td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=gridData[i].get("qtymmf")%>" name="qtymmf" size="10"
				<%if(gridData[i].get("approvedStatus")!=null){ %>
				readonly="readonly" <%} %> validate="MMF Qty,num,no" maxlength="10" />
			</td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=gridData[i].get("currQtymmf")%>" size="10"
				name="currQtymmf" validate="MMF Qty,num,no" maxlength="10"
				readonly="readonly" /></td>
			<td width="10%" <%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="text"
				value="<%=gridData[i].get("remark")==null?"":gridData[i].get("remark")%>"
				size="40" name="remark" validate="Remarks,String,no" maxlength="30" />
			</div>
			</td>

			<td align="center" width="2%"
				<%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>"
				<%if(gridData[i].get("approvedStatus")!=null){%> disabled <% }%>>
			</td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
</div>

<div class="Clear"></div>
<div id="pagination">
<%currentPage=pagedArray.getCurrentPage(); %> <%=pagedArray.showIndex()%>

<%=pagedArray.getPageIndexHiddenTag()%>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="Height10"></div>

<%	}  %> <input type="hidden" name="currentPage" value="<%=currentPage%>" />
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="currentYear1" value="<%=currentYear%>" /> <input
	type="hidden" name="gridData" value="<%=gridData%>" /> <%if(map.get("import")!=null&&((String)map.get("import")).equals("import")){
	flagForRefresh="false";
	%> <% }%> <input type="hidden" name="flagForRefresh"
	value="<%=flagForRefresh %>" /></form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>