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
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script language="Javascript">

function openPopupWindow()
{
document.mmfDepartment.method="post";
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
document.mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=createAndImportMmfDepartmentData&numOfRows=10&pageCount=10&currPage=1&flagForRefresh='+flagForRefresh);
}

function upd()
{
document.mmfDepartment.method="post";	
//submitForm('mmfDepartment','stores?method=updateGridItemsInMmf');
//submitForm('mmfDepartment','stores?method=createAndImportMmfDepartmentData')
submitForm('mmfDepartment','stores?method=createAndSaveMmfDepartmentData')
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

// add javed 
function checkForDefectiveDrugs(val,a)
{
	
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    var inc =1
	   // alert("checkForDefectiveDrugs"+pvms);
	   //ajaxFunctionForAutoCompleteInTurnOver('mmfDepartment','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
	    ajaxFunctionForAutoCompleteInMMF('mmfDepartment','stores?method=fillItemsForMMF&pvmsNo=' + pvms , inc);
	   
		
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
	
	System.out.println("1 Size of approvedByEmployeeList  "+approvedByEmployeeList.size());
	if(map.get("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
		session.setAttribute("approvedByList",approvedByEmployeeList);
		System.out.println("2 Size of approvedByEmployeeList  "+approvedByEmployeeList.size());
	}else if(session.getAttribute("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByList");
		System.out.println("3 Size of approvedByEmployeeList  "+approvedByEmployeeList.size());
		
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
		System.out.println("preparedBy preparedBy preparedBy  "+ map.get("preparedBy").toString());
	}
	String preparedBy=box.get("PREPARED_BY").toString();
	
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
<h2>MMF Entry</h2>
</div>
<div class="Clear"></div>
<!-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div> --> 
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
<!-- <h4>Details</h4> -->
<div class="Clear"></div>
<div class="Block">

 
 <label>Year<span>*</span></label> <select name="<%=MMF_DEPARTMENT_DATE %>"
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



<label>Remarks</label> 
<textarea name="remark" 	MAXLENGTH="200" rows="2" cols="30" id="remark" class="txtarea" tabindex="1"></textarea>
	
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
<%	} %> 

<!--  <%
	//if (pagedArray == null&&box.getString("pvmsNo").equals("")) {
%> <input type="button" name="Submit" id="addbutton" value="Import"
	class="button" onClick="importMMF();" /> <%
	//}
%> -->
<%
	if (pagedArray == null) {
%>
 <div class="Clear"></div>
<div class="Clear"></div>
<h4>ITEM Details</h4>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="75%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" cellpadding="0" cellspacing="0">
	<%int inc=1;
	String nameItem1="nameItem1" ;
	String codeItem1="codeItem1" ;
	String idItem1= "idItem1";
	String idAu1= "idAu1";
	%>
	<thead>
		<tr>
			<!--shailesh change for adding column  -->
			<th width="5%">Sl No.</th>
			<th width="10%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="13%">Avg Consumption</th>
			<th width="10%">MMF <%if(previousYear!=0) %><%=previousYear%></th>
		<!--  	<th width="10%">Requested MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="10%">Approved MMF <%if(currentYear!=0) %><%=currentYear%></th>-->
			<th width="13%">Remarks</th>
			
		</tr>
	</thead>
	<tbody>
	
		<tr>
		
			<!--  <td colspan=6>No Data Found</td>-->
			<td width="5%">
				<input type="text" value="<%=inc%>" name="srno" id="sr" ></input>
			</td>
			<td width="10%">
			<input type="text" size="5" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem1%>" /> 
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem1%>" />
			</td>
			<td width="15%">
			<input type="text" value="" name="<%=nameItem1%>" id="<%=nameItem1%>" onblur="checkForDefectiveDrugs(this.value, '<%=nameItem1%>');"></input>
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem1%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem1%>'});
			</script>
			</td>
			<!-- 
			<td width="10%">
				<input type="text" size="5" value="" readonly="readonly" name="<%=AV%>" id="<%=idAu1%>" tabindex="1" />
			</td>
			<td width="10%">
				<input type="text" size="5" value="" readonly="readonly" name="consumption" id="consumption" tabindex="1" />
			</td>
			 -->
			<td width="10%">
			<input type="text" size="5" value="" name="preQtymmf" id="preQtymmf" tabindex="1" />
			</td >
			<td width="15%">
			<input type="text" size="5" value=""  name="qtymmf" id="qtymmf" tabindex="1" />
			</td>
			<td width="15%">
			<input type="text" size="5" value=""  name="currQtymmf" id="currQtymmf" tabindex="1" />
			</td>
			<td width="10%">
			<input type="text" size="5" value=""  name="remark" id="remark" tabindex="1" />
			</td>
			<input type="hidden"
				value="<%=inc%>" name="id" />
			
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
			<th width="5px">Sl No.</th>
			<th width="5px">PVMS No.</th>
			<th width="10px">Nomenclature</th>
			<th width="5px">A/U</th>
			<th width="5px">MMF <%if(previousYear!=0) %><%=previousYear%></th>
			<th width="5px">Requested MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="5px">Approved MMF <%if(currentYear!=0) %><%=currentYear%></th>
			<th width="5px">Remarks</th>
			
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
<!-- 
			<td align="center" width="2%"
				<%if(gridData[i].get("approvedStatus")!=null){ %>
				style="background: #AC1400;" <%} %>><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>"
				<%if(gridData[i].get("approvedStatus")!=null){%> disabled <% }%>>
			</td> -->
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
<div class="clear"></div>
<%	}  %> <input type="hidden" name="currentPage" value="<%=currentPage%>" />
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="currentYear1" value="<%=currentYear%>" /> <input
	type="hidden" name="gridData" value="<%=gridData%>" /> <%if(map.get("import")!=null&&((String)map.get("import")).equals("import")){
	flagForRefresh="false";
	%> <% }%> <input type="hidden" name="flagForRefresh"
	value="<%=flagForRefresh %>" />
	
	
		<%
					if(storeMmfDepartmentMList != null && storeMmfDepartmentMList.size() > 0)
						{
								StoreMmfDepartmentM mObj = (StoreMmfDepartmentM) storeMmfDepartmentMList.get(0);
								System.out.println(";;;;;;;;;;;;;; "+mObj.getStatus());
								if(mObj.getStatus().equals("o"))
								{
							%> 
							<input type="button" name="Update" type="submit" value="Submit" onClick="upd();" class="button">
							<input type="button" name="print"  type="submit" class="button" value="Print MMF" onClick="showReport('mmfDepartment');">  
<input type="button" name="Add" type="submit" value="ADD" onClick="openPopupWindow();" class="button"> 
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<input type="button" name="consumption" type="submit" class="buttonBig" value="Avg Consumption" onClick="">
<!-- <input type="button" name="Delete" type="submit" onClick="del();" value="Delete" class="button"> -->
 

<%	} else {
				%> 
				<input			type="button" name="Update" type="submit" disabled value="Submit" onClick="upd();" class="button">
				<input type="button" name="print" type="submit" class="button" value="Print MMF" onClick="showReport('mmfDepartment');"> 
<input type="button" name="Add" type="submit" disabled	value="ADD" onClick="openPopupWindow();" class="button">
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<input type="button" name="consumption" type="submit" class="buttonBig" value="Avg Consumption" onClick="">
<!-- <input type="button" name="Delete" type="submit" disabled onClick="del();" value="Delete" class="button"> --> 
 
<%	 }
					} else {
				%> 
				<input type="button" name="Update" type="submit" value="Submit" onClick="upd();" class="button">
				<input type="button" name="print" type="submit" class="button" value="Print MMF" onClick="showReport('searchPanel');"> 
<input type="button" name="Add" type="submit" value="ADD" onClick="openPopupWindow();" class="button">
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<input type="button" name="consumption" type="submit" class="buttonBig" value="Avg Consumption" onClick="">
<!-- <input type="button" name="Delete" type="submit" onClick="del();" value="Delete" class="button">  -->
 <%	} %>
<div class="Clear"></div>
<div class="clear"></div>
	
	</form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>