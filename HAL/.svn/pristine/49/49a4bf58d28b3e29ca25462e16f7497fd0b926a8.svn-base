<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for  to Dispensary Manual.
 * @author  Deepti
 * @author  Vivek
 * Create Date: 12st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>


<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.util.PagedArray"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
	Map map = new HashMap();
	String includedJsp = null;
	
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	String userName="";
	String date="";
	String time="";
	String max="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<StoreIssueM> gridIssueMList= new ArrayList<StoreIssueM>();
	List<StoreIssueT> gridIssueTList= new ArrayList<StoreIssueT>();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
		int maxIndentNo=0;
		int issueId =0;
		Box box=HMSUtil.getBox(request);
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
			System.out.print("employeeList      "+employeeList.size());
		}
		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}
		if(map.get("gridIssueTList")!=null)
			gridIssueTList = (List) map.get("gridIssueTList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
	
		
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
			System.out.println("internalIndentId  "+internalIndentId);
		}
		if(map.get("masStoreBrandList")!=null)
			masStoreBrandList = (List) map.get("masStoreBrandList");
		System.out.println("masStoreBrandList  "+masStoreBrandList.size());
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		
		if(map.get("issueId")!=null)
			issueId = Integer.parseInt(""+map.get("issueId"));
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(request.getAttribute("map") != null)
			{
				map = (Map) request.getAttribute("map");
				pagedArray = (PagedArray) map.get("pagedArray");
			}
		
%>
<br />
<h2 align="left" class="style1">Issue For Disposal Entry</h2>

<div id="contentspace">

<form name="issueForDisposal" method="post">

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
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Update"
					class="toolbutton" onClick=" if(test()){upd();}"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="openDeletePopupForDepartmentIssueNE();" />
				</td>
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
<%--------------- Start of Search Panel ---------------------------%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post"><%-- Start of Search Form --%>
<table width="302" border="0" cellpadding="2" cellspacing="1">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Issue No:</label> <select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>"">
			<option value="">Select</option>

		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('departmentIssueNE','nonExp?method=searchDepartmentIssueNE');" />
		</td>
	</tr>
</table>
</form>
<%-- End of Search Form --%></div>
</div>
</div>
<%-------------------- End of Search Panel ---------------------------%>
</form>
<br />



<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Issue Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 89px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">


<%if(box.get("issueId").equals("")){ %> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <label
	class="bodytextB"><font id="error"></font> Civ No: </label> <input
	type="text" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=max+box.get("issueNo") %>" id="issueNo"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"><font id="error"></font>Issue Date:</label> <input
	type="text" name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=currentDate %>" class="textbox_size20" id="isssueDate" /> <label
	class="bodytextB"><font id="error"></font>Dept Name :</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp">
	<option value="">Select</option>
	<%for (MasStoreAirForceDepot masStoreAirForceDepot :masStoreAirForceDepotList ) {%>
	<option value=<%=masStoreAirForceDepot.getId()%>
		<%=HMSUtil.isSelected(masStoreAirForceDepot.getId().toString(),box.get("departmentIdTemp")) %>><%=masStoreAirForceDepot.getAirForceDepotName()%></option>
	<%}%>
</select> <br />
<label class="bodytextB"><font id="error"></font>Ref No:</label> <input
	type="text" name="<%= RequestConstants.DOC_NO%>" class="textbox_size20"
	value="<%=box.get("docNo")%>" id="docNo" /> <input type="hidden"
	name="<%= RequestConstants.BOS_ID%>" class="textbox_size20"
	value="<%=box.get("bosId")%>" id="bosId" /> <label class="bodytextB"><font
	id="error"></font>Issued By:</label> <select
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()%></option>
	<%}%>
</select> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="noOfRows" value="0" /></div>
<br />



<div style="float: left; padding-left: 15px;"></div>
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>
<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" value="0" /> <input
	type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" /> <br />

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
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Stock
			In</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>


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
<font class="boxtitle">Item Details</font></div>
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
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Stock
			In</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>

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
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("serialNo")==null?"":gridData[i].get("serialNo")%>"
				readonly="readonly" name="serialNo" maxlength="6" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("stockIn")==null?"":gridData[i].get("stockIn")%>"
				readonly="readonly" name="stockIn" id="stockIn<%=iFirstRow%>"
				maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qtyIssued")==null?"":gridData[i].get("qtyIssued")%>"
				name="qtyIssued" id="qtyIssued<%=iFirstRow%>"
				validate="Qty Issued ,floatWithoutSpaces,no" maxlength="7"
				onblur="checkIssuedQty(<%=iFirstRow%>);" /></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("qtyIssuedTemp")==null?"":gridData[i].get("qtyIssuedTemp")%>"
				name="qtyIssuedTemp" maxlength="30" /></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("issuedItemId")%>" name="issuedItemId" />
			</td>
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
	</script> <br />
<%--Start of Change Panel--%> <label class="bodytextB">Changed
By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" id="totalQty" /> <%--End of Change Panel--%>

</form>

</div>

<script type="text/javascript">

function test(){
	var errorMessage="";
	formName="issueForDisposal"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n"; 
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(document.getElementById('docNo').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('docNo').value != "") &&(document.getElementById('departmentIdTemp').value != "") ){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
function goPage(pidx) {	
	issueForDisposal.currPage.value = pidx;
	issueForDisposal.method="post";
	submitForm('issueForDisposal','nonExp?method=getIssueDisposalData');
}

function upd()
{
issueForDisposal.method="post";
submitForm('issueForDisposal','nonExp?method=updateIssueForDisposalEntry');
}

function checkIssuedQty(rowValue){
	if(parseInt(document.getElementById('stockIn'+rowValue).value) < parseInt(document.getElementById('qtyIssued'+rowValue).value) ){
		alert("Quantity can not be greater than STOCK ...!")
		document.getElementById('qtyIssued'+rowValue).value=""
		return false;
	}else{
		return true;
	}
	

}
</script>
