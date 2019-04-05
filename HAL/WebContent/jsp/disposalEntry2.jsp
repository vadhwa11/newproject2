<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartment.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
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
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreBosM"%>
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
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px;
}
</style>



<script language="Javascript">
function testForIndent(){
if(document.getElementById('bosId').value =="0")
{
	alert("Select BOS No ...!")
	return fale
}else{
	return true;
}

}
function openPopupWindow()
{
var mmfMasterId = document.mmfDepartment.<%=MMF_DEPARTMENT_M_ID %>.value;
var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
var mmfNo = document.mmfDepartment.mmfNo.value;
var remarks = document.mmfDepartment.<%=REMARKS %>.value;
var url="/hms/hms/nonExp?method=showAddMmfDepartmentJsp&mmfMasterId="+mmfMasterId + "&<%=MMF_DEPARTMENT_DATE%>=" + mmfDate +"&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>="+deptId+"&mmfNo="+mmfNo+"&<%=REMARKS%>="+remarks;
newwindow=window.open(url,'name','top=50, left=50, height=600,width=850,status=1');
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	disposalEntry.currPage.value = pidx;
	disposalEntry.method="post";
	submitForm('disposalEntry','nonExp?method=getDisposalData');
}

function importMMF()
{
mmfDepartment.method="post";
submitForm('mmfDepartment','nonExp?method=createAndImportMmfDepartmentData');
}

function upd()
{
disposalEntry.method="post";
submitForm('disposalEntry','nonExp?method=updateDisposalEntry2');
}

function checkForMmfData()
{
mmfDepartment.method="post";
submitForm('mmfDepartment','nonExp?method=getCurrentYearMmf');
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
	submitForm('mmfDepartment','nonExp?method=deleteGridItemsForMmf');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function jsDisplay() {	
	if (document.searchPanel.<%=DOC_NO%>.value=="")
	{
	alert('Pl. select MMF No....');
	return;
	}
	var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
	
	searchPanel.method="post";
	submitForm('searchPanel','nonExp?method=searchMmfDepartmentData&<%=MMF_DEPARTMENT_DATE%>='+mmfDate+'&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>=' + deptId);
}

</script>


<%
	Box box = HMSUtil.getBox(request);
	
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String disposalStatus="o";
	
	List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();

	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("storeBosMList")!=null)
	{
		storeBosMList = (List) map.get("storeBosMList");
	}
	if(map.get("box")!=null)
	{
		box = (Box) map.get("box");
	}
	String max="";
	if(map.get("max")!=null)
	{
		max = (String) map.get("max");
	}
	
	if(map.get("disposalStatus")!=null)
	{
		disposalStatus = (String) map.get("disposalStatus");
	}
%>
<div class="titleBg">
<h2 >Disposal Entry >Rs 30</h2>
</div>

<form name="disposalEntry" method="post">
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					onClick="openPopupWindow();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Update"
					onClick="upd();" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" onClick="del();"
					value="Delete" class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<%-- Start of Search Panel--%>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<label>Disposal No.</label> <select
			name="<%= RequestConstants.DISPOSAL_ID%>" validate="MMF Year,num,Yes"
			id="mmfYear">
			<option value="0">Select</option>

		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=modifyIndent');" />
</form>
</div>
<%-- End of Search Panel--%> <input type="hidden" name="numOfRows"
	size="5" value="5"> <input type="hidden" name="pageCount"
	size="5" value="10">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 45px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">

<label class="bodytextB"><font id="error"></font>Disposal No :</label> <input
	type="text" name="<%=DISPOSAL_NO%>" value="<%=max%>"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Disposal Date:</label> <input type="text" readonly="readonly"
	name="<%=DISPOSAL_NO%>" value="<%=date%>" class="textbox_size20"
	MAXLENGTH="20" /> <label class="bodytextB"><font id="error"></font>BOS
No:</label> <select
	onchange="submitForm('disposalEntry','nonExp?method=importFromBOS2');"
	name="<%=BOS_ID%>" id="bosId">
	<option value="0">Select</option>
	<%for(StoreBosM storeBosM: storeBosMList) {%>
	<option value="<%=storeBosM.getId() %>"
		<%=HMSUtil.isSelected(storeBosM.getId().toString(),box.getString("bosId")) %>><%=storeBosM.getBosNo()%></option>
	<%} %>
</select>
<div style="padding-left: 15px; float: left;"><input type="hidden"
	name="pageNo" id="pageNo" value="" /> <input type="button"
	value="Generate Indent" class="button"
	onclick="if(testForIndent()){submitForm('disposalEntry','nonExp?method=generateIndent&&entryType=g');}" />
<input type="button" value="Generate CIV" class="button"
	onclick="if(testForIndent()){submitForm('disposalEntry','nonExp?method=generateCiv');}" />
</div>
<br />
</div>
<br />


<% if (pagedArray == null) { %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Disposal Entry Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">No.
			of Items</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Value</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Report
			showing Case of Loss, Damage Or Unserviceable Of person responsible </label></td>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>

<% } else { %>


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF Department Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">No.
			of Items</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Value</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Report
			showing Case of Loss, Damage Or Unserviceable Of person responsible </label></td>

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
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")==null?"":gridData[i].get("pvms")%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")==null?"":gridData[i].get("nomenclature")%>"
				class="bigcaption" name="nomenclature" readonly="readonly" /></td>
			<%if(disposalStatus.equals("o")){ %>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("qty")==null?"":gridData[i].get("qty")%>"
				class="medcaption" name="qty" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("cost")==null?"":gridData[i].get("cost")%>"
				name="cost" validate="Qty,num,no" maxlength="6" /> <input
				type="hidden"
				value="<%=gridData[i].get("rvNo")==null?"":gridData[i].get("rvNo")%>"
				name="rvNo" validate="rvNo,String,no" maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remark")==null?"":gridData[i].get("remark")%>"
				name="remark" validate="Remarks,String,no" maxlength="30" /></td>
			<%}else{ %>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("qty")==null?"":gridData[i].get("qty")%>"
				readonly="readonly" class="medcaption" name="qty" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("cost")==null?"":gridData[i].get("cost")%>"
				name="cost" readonly="readonly" validate="Qty,num,no" maxlength="6" />
			<input type="hidden"
				value="<%=gridData[i].get("rvNo")==null?"":gridData[i].get("rvNo")%>"
				name="rvNo" readonly="readonly" validate="rvNo,String,no"
				maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remark")==null?"":gridData[i].get("remark")%>"
				readonly="readonly" name="remark" validate="Remarks,String,no"
				maxlength="30" /></td>
			<%} %>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>

<% } %>
</form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>