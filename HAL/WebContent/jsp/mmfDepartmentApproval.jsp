<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartmentApproval.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  shailesh
 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import=" java.math.BigDecimal"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<style type="text/css">
.locatorArrow {
	COLOR: #666666;
	text-align: center;
	FONT-FAMILY: Verdana;`
	FONT-SIZE: 12px;
}

.txtarea {
	float: right;
	border: 1px solid #989C9E;
	padding-left: 6px;
	padding-top: 3px;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	font-size: 11px;
	color: #4E4E4E;
	margin-top: 2px;
	margin-bottom: 2px;
	width: 140px;
	margin-right: 4px;
}
</style>



<script language="Javascript">

function printReport(formName){
obj = eval('document.'+formName)
var pvms_no=document.mmfDepartmentApproval.pvmsNo.value;
var mmfDate = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE %>.value;
	if(mmfDate != 0){
  var mmfForYear = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE%>.value;
  var storeType = document.mmfDepartmentApproval.storeType.value;
 
  // alert("This module is under maintenance!!!!");
    obj.action = "/hms/hms/stores?method=printMmfApprovalEntryJsp&storeType="+storeType+"&pvms_no="+pvms_no+"&<%=MMF_DEPARTMENT_DATE%>="+mmfForYear;
    obj.submit();
  }
  else{
  alert("pls select Year");
  }
}
function printReportForItemWise(formName){
obj = eval('document.'+formName)
var mmfDate = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE %>.value;
if(mmfDate != 0){
 var mmfForYear = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE%>.value;
  var storeType = document.mmfDepartmentApproval.storeType.value;
 
 var item_type= "";
 if(document.getElementById('pvms1').checked){
 item_type = "1";
 }
 
 if(document.getElementById('pvms2').checked){
 item_type = "2";
 }
 
 obj.action = "/hms/hms/stores?method=printReportForItemWise&storeType="+storeType+"&<%=MMF_DEPARTMENT_DATE%>="+mmfForYear+"&itemType="+item_type;
 obj.submit();
 

}
  else{
  alert("pls select Year");
  }

}
function printReportForItemWiseinExcel(formName){
obj = eval('document.'+formName)
var mmfDate = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE %>.value;
if(mmfDate != 0){
 var mmfForYear = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE%>.value;
  var storeType = document.mmfDepartmentApproval.storeType.value;
 
 
 var item_type= "";
 if(document.getElementById('pvms1').checked){
 item_type = "1";
 }
 
 if(document.getElementById('pvms2').checked){
 item_type = "2";
 }
 
 obj.action = "/hms/hms/stores?method=printReportForItemWise&storeType="+storeType+"&format=excel&<%=MMF_DEPARTMENT_DATE%>="+mmfForYear+"&itemType="+item_type;
  obj.submit();
 

}
  else{
  alert("pls select Year");
  }

}

function getItemObject(fieldName)
{
	mmfDepartmentApproval.method="post";
	
	if(fieldName.value==nomenclature){
	
	submitForm('mmfDepartmentApproval','stores?method=getItemObject&serchField=nomenclature');
	}
	if(fieldName.value=="pvmsNo"){
	
	submitForm('mmfDepartmentApproval','stores?method=getItemObject&serchField=pvmsNo');
	}
}

function gotoPrevious()
{
	
	
	mmfDepartmentApproval.method="post";	
	var storeItemId=document.mmfDepartmentApproval.storeItemId.value;
	
	if(storeItemId==1){
	alert("you are on first Item");
	}
	else{
	submitForm('mmfDepartmentApproval','stores?method=getCurrentYearMmfByItem&navigation=previous&currPage=1');
	}
}


function gotoNext()
{
	
	mmfDepartmentApproval.method="post";	
	submitForm('mmfDepartmentApproval','stores?method=getCurrentYearMmfByItem&navigation=next&currPage=1');
}

	

function checkForPvmsName()
{
mmfDepartmentApproval.method="post";

		var nomenclature = document.mmfDepartmentApproval.nomenclature.value;
		
	submitForm('mmfDepartmentApproval','stores?method=getPvmsName&nomenclature='+nomenclature);
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	mmfDepartmentApproval.currPage.value = pidx;
	mmfDepartmentApproval.method="post";
	submitForm('mmfDepartmentApproval','stores?method=getCurrentYearMmfByItem&page=page');
}


function upd()
{

mmfDepartmentApproval.method="post";
submitForm('mmfDepartmentApproval','stores?method=updateGridItemsInMmfDepartmentApproval');
}

function checkForMmfData()
{
var mmfMasterId = document.mmfDepartmentApproval.pvmsNo.value;
mmfDepartmentApproval.method="post";
submitForm('mmfDepartmentApproval','stores?method=getCurrentYearMmfByItem&currPage=1');
}

	function pvmsNomenclatureSearch()
	{
	
	mmfDepartmentApproval.method="post";
	var pvms=document.mmfDepartmentApproval.pvmsNo.value;
	
	var nomenclature=document.mmfDepartmentApproval.nomenclature.value;
	
	if(pvms!="" && nomenclature=="" && pvms.length){
	if(pvms.length > 1){
	submitForm('mmfDepartmentApproval','stores?method=getItemObjectFromPvms&currPage=1&flag=true');
	}else{
	alert("Atleast you should enter two numbers");
	return false;
	}
	
	return true;
	}
	
	if(nomenclature!="" && pvms==""){
	submitForm('mmfDepartmentApproval','stores?method=getItemObject&currPage=1');
	return true;
	}
	if(nomenclature!="" && pvms!==""){
	if(pvms.length > 1){
	submitForm('mmfDepartmentApproval','stores?method=getItemObjectFromPvms&currPage=1&flag=true');
	return true;
	}else{
	alert("atleast you should Enter two numbers");
	return false;
	}
	}
	if(nomenclature=="" && pvms==""){
	alert("Pls fill eigther Pvms No or Nomenclature");
	return false;
	}
     return false;	
 }

 function printReportForAllDepartments(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printReportForAllDepartments";
  obj.submit();
}

 
 

  function showReport(formName)
{
  obj = eval('document.'+formName)
  var docId = document.getElementById('docId').value
  obj.action = "/hms/hms/stores?method=printMmfEntryJsp&newDocId="+docId;
  obj.submit();
}
 function printDepartmentWiseList(formName)
{
  obj = eval('document.'+formName)
 	var date=document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE%>.value
 	var department=document.mmfDepartmentApproval.department.value
 	var storeType=document.mmfDepartmentApproval.storeType.value
  obj.action = "/hms/hms/stores?method=printDepartmentWiseList&storeType="+storeType+"&department="+department+"&<%=MMF_DEPARTMENT_DATE%>="+date+"";
  obj.submit();
}

function importmmfDepartmentWise(formName){
   obj = eval('document.'+formName)
   if(confirm("Are You sure, You want to import previous year Approved mmf data ?")){
    obj.action = "/hms/hms/stores?method=createAndImportTotalMmfDepartmentData&currPage=1";
    obj.submit();
    //  submitForm('mmfDepartmentApproval','stores?method=createAndImportTotalMmfDepartmentData&currPage=1');
	}		
	else{
   return false;
	}		
}

function createNewDept(){
var mmfForYear = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE%>.value;
var storeType = document.mmfDepartmentApproval.storeType.value;
var mmfDate = document.mmfDepartmentApproval.<%=MMF_DEPARTMENT_DATE %>.value;
var pvmsNo = document.mmfDepartmentApproval.pvmsNo.value;
var nomenclature = document.mmfDepartmentApproval.nomenclature.value;
		if(mmfForYear != 0){
			var url="/hms/hms/stores?method=showNewDepartmentMMFJsp&year="+mmfForYear+"&sType="+storeType+"&pvmsNo="+pvmsNo+"&nomenclature="+nomenclature;
			newwindow=window.open(url,'name','top=50, left=50, height=280,width=960,status=1');
		}else{
			alert("Please Select Year.");
		}
 }
 
 function  jsGetGrid(){
 var mmfMasterId = document.mmfDepartmentApproval.pvmsNo.value;
   mmfDepartmentApproval.method="post";
   submitForm('mmfDepartmentApproval','stores?method=getCurrentYearMmfByItem&currPage=1');
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

<%String updateRemarksForItem="";
	String qntUnit="";
	Box box = HMSUtil.getBox(request);
	Map<String,Object> dataMap1 = new HashMap<String,Object>();
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String userName = "";
	String pvmsNo = "";
	String nomenclature="";
	String nonExpMsg = "";
 	int itemType=1;
	int hospitalId = 0;
	int docId = 0;
	String fromShowDepartmentApproval="";
	BigDecimal preYearMmfSum=new BigDecimal(0);
	BigDecimal currYearMmfSum=new BigDecimal(0);
	BigDecimal avgConsump=new BigDecimal(0);
	String finend3 = new String();
	String finend2 = new String();
	//in use departmentList
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	//in use approvedByEmployeeList
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreFyDocumentNo> mmfNoList = new ArrayList<StoreFyDocumentNo>();
	List<StoreMmfDepartmentM> storeMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
//in use deptId
if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		fromShowDepartmentApproval=(String)map.get("fromShowDepartmentApproval");
		pagedArray = (PagedArray) map.get("pagedArray");
		//MasStoreItem firstItem=null;
		
		if(map.get("firstItem")!=null){
		
			MasStoreItem firstItem=new MasStoreItem();
			firstItem=	(MasStoreItem)map.get("firstItem");
	
			pvmsNo=firstItem.getPvmsNo();
			if(firstItem.getItemConversion()!=null&&!firstItem.getItemConversion().equals(""))
		    qntUnit=firstItem.getItemConversion().getItemUnitName();
			if(firstItem.getItemType()!=null)
			itemType=firstItem.getItemType().getId();
		    nomenclature=firstItem.getNomenclature();
			}
	}
	boolean cheak=false;
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	if(map.get("tListForDispensary")!=null){
		if(map.get("tListForDispensary").equals("true")){
			cheak=true;
		}
	}
	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}
	List<MasStoreSection>sectionList=new ArrayList<MasStoreSection>();
	if(map.get("sectionList")!=null){
		sectionList=(List<MasStoreSection>)map.get("sectionList");
	}
	//in use approvedByList
	if(map.get("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
		session.setAttribute("approvedByList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByList");
	}
	
	if(map.get("updateRemarksForItem")!=null)
	{
		updateRemarksForItem=(String)map.get("updateRemarksForItem");
	}
	if(map.get("remarks")!=null)
	{
		box.put(REMARKS, map.get("remarks").toString());
	}
	if(map.get("preYearMmfSum")!=null)
	{
		preYearMmfSum=(BigDecimal)map.get("preYearMmfSum");
	}
	if(map.get("currYearMmfSum")!=null)
	{
		currYearMmfSum=(BigDecimal)map.get("currYearMmfSum");
	}
	
	if(map.get("avgConsump")!=null)
	{
		avgConsump=(BigDecimal)map.get("avgConsump");
	}
	if(map.get("finend3")!=null)
	{
		finend3=(String)map.get("finend3");
	}
	if(map.get("finend2")!=null)
	{
		finend2=(String)map.get("finend2");
	}
	int currentYear=0;
	int previousYear =0;
	
	
	  
	if(box.getInt(MMF_DEPARTMENT_DATE)!=0 ){
		currentYear=box.getInt(MMF_DEPARTMENT_DATE);
		previousYear=currentYear-1;
	}
	if(map.get("currentYear")!=null)
		currentYear = (Integer) map.get("currentYear");
	if(map.get("previousYear")!=null)
		previousYear = (Integer) map.get("previousYear");
	
	if(map.get("searchStoreMmfDepartmentMList")!=null)
		searchStoreMmfDepartmentMList = (List) map.get("searchStoreMmfDepartmentMList");
	
	if(map.get("storeMmfDepartmentMList")!=null)
		storeMmfDepartmentMList = (List) map.get("storeMmfDepartmentMList");
	if(map.get("nonExpMesg")!=null)
		nonExpMsg = (String) map.get("nonExpMesg");
	
%>
<br />

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<div id="contentspace">
<div style="float: left;">
<h2 align="left" class="style1">MMF Department Approval</h2>
</div>
<div style="float: left; color: #000000;">
<h1 align="left" class="style1"><%=nomenclature%>[<%=pvmsNo%>]</h1>
</div>
<br />
<form name="mmfDepartmentApproval" method="post"><input
	type="hidden" name="numOfRows" size="5" value="10" /> <input
	type="hidden" name="pageCount" size="5" value="10" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">

<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 210px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">

<label class="bodytextB">Dept Name:</label> <%
 	for (MasDepartment masDepartment : departmentList) {
 		if (masDepartment.getId() == deptId) {
 %> <label><%=masDepartment.getDepartmentName()%></label> <input
	type="hidden" name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>"
	value="<%=masDepartment.getId() %>" /> <%
 			break;
 		}
 	}
 %> <label class="bodytextB">Year:</label> <select
	name="<%=MMF_DEPARTMENT_DATE %>" onchange="checkForMmfData()"
	validate="Year,String,yes">
	<option value="0">Select</option>

	<%
		int mmfDate = 0;
		if (map.get("mmfDate") != null) {
			mmfDate = (Integer) map.get("mmfDate");
			if (mmfDate == Integer.parseInt(date.substring(6))) {
	%>
	<option value="<%=Integer.parseInt(date.substring(6)) - 1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6)) - 1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6))-1%>
	</option>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>
		selected><%=date.substring(6)%></option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) + 1%>
	</option>
	<%
		} else if (mmfDate == Integer.parseInt(date.substring(6)) + 1) {
	%>
	<option value="<%=Integer.parseInt(date.substring(6)) - 1%>"
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
	<option value="<%=Integer.parseInt(date.substring(6)) - 1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6)) - 1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) - 1 %>
	</option>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>><%=date.substring(6)%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6)) + 1%>
	</option>

	<%
		}
	%>
</select> <label class="bodytextB">Mmf For Store:</label> <select
	name="storeType" onchange="checkForMmfData()" tabindex=1>

	<option value='e'
		<%if(box.get("storeType")!=null&&box.get("storeType").equals("e") )
			{%>
		selected <%} %>>Expendable Store</option>
	<option value='h'
		<%if(box.get("storeType")!=null&&box.get("storeType").equals("h") )
	{%>
		selected <%} %>>ECHS</option>
</select> <%System.out.println("box values in jsp"+box); %> <label
	class="bodytextB">Search By:</label> <input type="radio" id="pvms1"
	name="pvmsGroup" size="" value="pvms_search"
	<%=box.getString("niv_search").equalsIgnoreCase("niv_search")==false||itemType==1?"checked":"" %>
	onchange="checkForMmfData();"> PVMS NO <input type="radio"
	id="pvms2" name="pvmsGroup" size="" value="niv_search"
	<%=box.getString("niv_search").equalsIgnoreCase("niv_search")==true||itemType==2?"checked":"" %>
	onchange="checkForMmfData();"> NIV </br>

<label class="bodytextB">PVMS No/NIV</label> <input type="text"
	name="pvmsNo" value="<%=pvmsNo %>" class="textbox_size20" tabindex=3
	MAXLENGTH="30"
	onkeypress="submitenter(this,event,'stores?method=getItemObjectFromPvms&enter=true')" />

<label class="bodytextB">Nomenclature:</label> <input type="text"
	name="nomenclature" value="<%=nomenclature%>" class="bigcaption1"
	tabindex=1 MAXLENGTH="100" id="nomenclature"
	onkeypress="submitenter(this,event,'stores?method=getItemObject')" />

<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForNomenclature',{parameters:'requiredField=nomenclature'});
		</script> <%if(map.get("firstItem") != ""){
			if((MasStoreItem)map.get("firstItem")!=null && !((MasStoreItem)map.get("firstItem")).getPvmsNo().equals("")){ %>
<input type="hidden" name="storeItemId"
	value="<%=(Integer)((MasStoreItem)map.get("firstItem")).getId() %>">
<% }}%> <IMG SRC="/hms/jsp/images/s_search.gif" tabindex=1 HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:pvmsNomenclatureSearch();"
	title="Click here to Search Pvms/Niv" /> <%System.out.println("already chaecked"+cheak ); %>
&nbsp;&nbsp;&nbsp;&nbsp; <% if(cheak==true){%> <input type="checkbox"
	id="checkbox1" name="checkbox1" disabled checked="true" />Already
Approved <% }else{%> <input type="checkbox" id="checkbox1"
	name="checkbox1" disabled />Already Approved <%} %> 
	<input type="button" name="UpdateWithoutBuffer"	onClick="submitForm('mmfDepartmentApproval','stores?method=updateGridItemsInMmfDepartmentApproval&UpdateWithoutBuffer=UpdateWithoutBuffer');"
	value="Approve Without Buffer" class="buttonbig" accesskey="i" />

<table width="100%" valign="top" align="top">
	<tr valign="top">
		<td width="40%" align=left valign=center>
		<%if(pvmsNo.equalsIgnoreCase("")){ %>
		<h6 align="left" class="style1">No Items To display</h6>
		<%if(!nonExpMsg.equals("")){ %>
		<h6 align="left" class="style1"><%= nonExpMsg %></h6>
		<%} %> <% }else{%><h6 align="left" class="style1">AU: <%=qntUnit %></h6>
		<%} %>
		</td>
		<td width="5%" align="top" valign="top"><label
			class="bodytextmmfB">Remarks For Items:</label></td>
		<td width="40%" align=left valign=top><textarea
			name="updateRemarksForItem" tabindex="1" class="txtareammf"
			MAXLENGTH="30"><%=updateRemarksForItem %>
</textarea> <input type="button" name="Update" onClick="createNewDept();"
			value="NewDept" class="button" accesskey="u" /></td>
	</tr>
</table>
<br />
<br />
<input type="button" name="Update" onClick="upd()"
	value="Approve With Buffer" class="buttonbig" accesskey="u" /> <input
	type="button" name="Previous" onClick="gotoPrevious()" value="Previous"
	class="button" accesskey="b" /> <input type="button" name="Next"
	onClick="gotoNext()" value="Next" class="button" accesskey="n" /> <input
	type="button" name="Print"
	onClick="printReport('mmfDepartmentApproval')" value="Print"
	class="button" accesskey="p" /> <input type="button" name="Print"
	onClick="printReportForAllDepartments('mmfDepartmentApproval')"
	value="ReportForAllDepartments" class="buttonbig" accesskey="p" /> <input
	type="button" name="Print"
	onClick="printReportForItemWise('mmfDepartmentApproval');"
	value="ItemsConsolidatedReportinPDF" class="buttonbig" accesskey="p" />
<input type="button" name="Print"
	onClick="printReportForItemWiseinExcel('mmfDepartmentApproval');"
	value="ItemsConsolidatedReportInExcel" class="buttonbig" accesskey="p" />
<br />
<div id="printDepartmentMmf"><input type="button" name="import"
	onClick="importmmfDepartmentWise('mmfDepartmentApproval')"
	value="Import" class="button" /> <input type="button"
	id="PrintDepartmentWise" name="PrintDepartmentWise"
	onClick="printReportDepartmentWise()" value="PrintDepartmentWise"
	class="buttonbig" accesskey="f" /> <script type="text/javascript">
			function printReportDepartmentWise(){
				var departmentCheck = document.getElementById('PrintDepartmentWise').value;
				if(departmentCheck!=""){
					document.getElementById('departmentList').style.display = 'inline';
				 }
				}
		</script> <br />

<div id="departmentList" style="display: none"><label
	class="bodytextReg"> Department List:</label> <select id="department"
	name="department"
	onchange="printDepartmentWiseList('mmfDepartmentApproval')"
	tabindex="1" validate="Department,string,no" class="select_adt">
	<option value="0">Select</option>
	<%	 for(MasDepartment masDepartment : departmentList){	 %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	}%>
</select></div>
</div>

</div>
</br>
<div style="float: left;">
<div style="float: left; color: #000000;">
<h1 align="left" class="style1"><%=nomenclature%>[<%=pvmsNo%>] AU:
<%=qntUnit %></h1>
</div>
<br />
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_M_ID %>"
	value="<%=map.get("mmfMasterId") == null?0:map.get("mmfMasterId")%>" />
<br />
<%
	 if(!"true".equalsIgnoreCase(fromShowDepartmentApproval) )
	 {
 %>
<table width="100%">
	<tr>
		<td>
		<div style="float: left;">
		<h6 align="left" class="style1">Sum of <%=previousYear %> MMF:</h6>
		</div>
		</td>
		<td>
		<div style="float: left; color: #000000;">
		<h6 align="left" class="style1"><%=preYearMmfSum%></h6>
		</div>
		</td>
		<td>
		<div style="float: left;">
		<h6 align="left" class="style1">Sum of <%=currentYear %> MMF:</h6>
		</div>
		</td>
		<td>
		<div style="float: left; color: #000000;">
		<h6 align="left" class="style1"><%=currYearMmfSum%></h6>
		</div>
		</td>
		<td>
		<div style="float: left;">
		<h6 align="left" class="style1">AVG Monthly Consumption:</h6>
		</div>
		</td>
		<td>
		<div style="float: left; color: #000000;">
		<h6 align="left" class="style1"><%=avgConsump%></h6>
		</div>
		</td>
		<td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><label
			style="FONT-SIZE: 11px; text-align: center; width: 200px;">(From <%=finend3%> To <%=finend2%>) </label></td>
		<td></td>
	</tr>
</table>

<% }%> <%
	if (pagedArray == null) {
%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF Department Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div style="width: 100%; height: 175px; padding-left: 9px;">
<table width="75%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<!--shailesh change for adding column  -->
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Dept.
			Name </label></td>

			<td width="10%"><label valign="left" class="smalllabel">Approved
			MMF <%if(previousYear!=0) %><%=previousYear%> </label></td>
			<td width="10%"><label valign="left" class="smalllabel">Requested
			MMF <%if(currentYear!=0) %><%=currentYear%></label></td>
			<td width="10%"><label valign="left" class="smalllabel">Approved
			MMF <%if(currentYear!=0) %><%=currentYear%></label></td>
			<td width="20%"><label valign="left" class="smalllabel">Remarks</label></td>
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

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF Department Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div style="width: 100%; height: 305px; padding-left: 9px;">
<table width="75%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<!--shailesh change for adding column  -->

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>

			<td width="10%"><label valign="left" class="smalllabel">Dept.
			Name</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Approved
			MMF <%if(previousYear!=0) %><%=previousYear%> </label></td>
			<td width="10%"><label valign="left" class="smalllabel">Requested
			MMF <%if(currentYear!=0) %><%=currentYear%></label></td>
			<td width="10%"><label valign="left" class="smalllabel">Approved
			MMF <%if(currentYear!=0) %><%=currentYear%></label></td>
			<td width="20%"><label valign="left" class="smalllabel">Remarks</label></td>
		</tr>
	</thead>
	<tbody>
		<%
			gridData = (HashMap[]) pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
				for (int i = 0; i < gridData.length; i++) {
		%>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>

			<td width="10%"><input type="text"
				value="<%=gridData[i].get("departmentName")%>" name="departmentName"
				readonly="readonly" /></td>

			<td width="10%"><input type="text"
				value="<%=gridData[i].get("preQtymmf")%>" name="preQtymmf"
				validate="Previous MMF Qty,num,no" maxlength="9" readonly="readonly" />
			</td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qtymmf")%>" name="qtymmf" maxlength="9"
				readonly="readonly" /></td>
			<td width="10%">
			<%if((gridData[i].get("qtymmf").equals("NR"))){ %>
			<input type="text"
				value="<%=gridData[i].get("currQtymmf")%>" name="currQtymmf"
				validate="CurrentMMF Qty,num,no" maxlength="9" readonly="readonly"/>
				<%}else{ %>
				<input type="text"
				value="<%=gridData[i].get("currQtymmf")%>" name="currQtymmf"
				validate="CurrentMMF Qty,num,no" maxlength="9" />
				<%} %></td>
			<td width="20%"><input type="text"
				value="<%=gridData[i].get("remark")==null?"":gridData[i].get("remark")%>"
				class="bigcaption" name="remark" validate="Remarks,String,no"
				maxlength="99" /></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<%	}  %>
	</tbody>
</table>
</div>

<div style="padding-left: 250px;">
<div class="wardspan" style="float: left;"><%=pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%=pagedArray.getPageIndexHiddenTag()%>
</div>
</div>
<br />

<%
	}
%> <input type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="currentYear1" value="<%=currentYear%>" />
</form>
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>