<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>



<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<script type="text/javascript">
/***********************************************
* Textarea Maxlength script- 
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>



<%
	String date = "";
	String time = "";
	String userName = "";
	String groupId = "";
	int deptId = 0;
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> masterDataMap = new HashMap<String,Object>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");

 	if (session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}

 	if (session.getAttribute("deptId") != null)
 	{
		Integer temp = (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
 	
	box.put(DATE_INVITE_TENDER,date);
	box.put(DATE_COMMENCEMENT,date);
	box.put(LAST_DATE_TENDER_DOCUMENT,date);
	box.put(TIME_RECEIPT_TENDER_SAMPLES,"10 - 12 Noon");
	box.put(PLACE_RECEIPT_TENDER_SAMPLES,"CHAF, Bangalore");
	box.put(LAST_DATE_RECEIPT_TENDER_SAMPLES,date);
	box.put(DATE_OPENING_TECHNICAL,date);
	box.put(DATE_OPENING_COMMERCIAL,date);
	box.put(TERMS_CONDITIONS,"as per Tender Document");
	
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String masterStatus = null;
	String proposals = "";

	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		existingTenderNumbersList = (ArrayList)map.get("existingTenderNumbersList");
		System.out.println(existingTenderNumbersList);
		mmfyears = (ArrayList)map.get("mmfyears");
		masterDataMap = (Map) map.get("masterDataMap");
		
		
		if (map.get("proposals")!=null)
		{
			proposals = map.get("proposals").toString();
		}
		
		if (map.get("masterStatus")!=null)
			masterStatus = map.get("masterStatus").toString();
		
		if (map.get("new_tender_no")!=null)
			box.put(TENDER_NO,map.get("new_tender_no").toString());
		
		if (map.get("mmfyear")!=null)
		{
			box.put("mmfyear",map.get("mmfyear").toString());
		}
		
		if (masterDataMap != null && masterDataMap.size() > 0)
		{
			System.out.println("masterDataMap" + masterDataMap);
			box.put(DATE_INVITE_TENDER,masterDataMap.get(DATE_INVITE_TENDER));
			box.put(DATE_COMMENCEMENT,masterDataMap.get(DATE_COMMENCEMENT));
			box.put(LAST_DATE_TENDER_DOCUMENT,masterDataMap.get(LAST_DATE_TENDER_DOCUMENT));
			box.put(TIME_RECEIPT_TENDER_SAMPLES,masterDataMap.get(TIME_RECEIPT_TENDER_SAMPLES));
			box.put(PLACE_RECEIPT_TENDER_SAMPLES,masterDataMap.get(PLACE_RECEIPT_TENDER_SAMPLES));
			box.put(LAST_DATE_RECEIPT_TENDER_SAMPLES,masterDataMap.get(LAST_DATE_RECEIPT_TENDER_SAMPLES));
			box.put(DATE_OPENING_TECHNICAL,masterDataMap.get(DATE_OPENING_TECHNICAL));
			box.put(DATE_OPENING_COMMERCIAL,masterDataMap.get(DATE_OPENING_COMMERCIAL));
			box.put(TERMS_CONDITIONS,masterDataMap.get(TERMS_CONDITIONS));
		}
	}
	
	if (map.get("masStoreGroupList") != null)
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
	
	if (pagedArray != null) {
		groupId =String.valueOf(""+masStoreGroupList.get(0).getId());
		box.put(TENDER_SUPPLIER_GROUP_ID,groupId);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>

<script>

function openPopupWindow(tender_no)
{
 var url="/hms/hms/tender?method=showAddTenderItemsJsp&tender_no=" + tender_no + "&numOfRows=15&pageCount=10";
 newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1');
}

function newTenderCreation()
{
	window.location.href="tender?method=showTenderCreationJsp";
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
    tenderForm.currPage.value = pidx;
	tenderForm.method="post";
	submitForm('tenderForm','tender?method=showTenderCreationJspWithGridData&numOfRows=15&pageCount=10');
}


function pvmsSearch()
	 {
	 	tenderForm.method="post";	
	   var pvmsNo=document.tenderForm.pvmsNo.value;
	   if(pvmsNo != ""){
	     submitForm('tenderForm','tender?method=showTenderCreationJspWithGridData&numOfRows=15&pageCount=10&flag=fresh&pvmsNo='+pvmsNo);
	   }else{
	     alert("Please select PVMS No.")
	   }
	 }

function jsDisplay() {	
	if (document.searchForm.<%=TENDER_NO%>.value=="")
	{
	alert('Pl. select Tender No....');
	return;
	}
	
	tenderForm.method="post";
	submitForm('searchForm','tender?method=showTenderCreationJspWithGridData&numOfRows=15&pageCount=10');
}

function jsSubmit()
{
		if (tenderForm.mmfyearcombo.value=="")
		{
		alert('Please Select the Year to Import Data!.......');
		return;
		}
		tenderForm.method="post";
		tenderForm.mmfyear.value=tenderForm.mmfyearcombo.value;
		submitForm('tenderForm','tender?method=createTenderMasterAndTransaction');
}

function jsImportTenderProposals(flag)
{
		tenderForm.method="post";
		tenderForm.mmfyear.value=0;
		
			var groupId = document.getElementById('<%=TENDER_SUPPLIER_GROUP_ID%>').value;
	//	submitForm('tenderForm','tender?method=createTenderMasterAndTransaction&flag='+flag);
	submitForm('tenderForm','tender?method=createTenderMasterAndTransaction&flag='+flag+'&groupId='+groupId);	
}


function upd()
{
tenderForm.method="post";
submitForm('tenderForm','tender?method=updateGridItems');
}

function validateDeleteButton()
{
	if (tenderForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < tenderForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (tenderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (tenderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	tenderForm.method="post";
	submitForm('tenderForm','tender?method=deleteGridItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

</script>
<div id="contentHolder">
<h6>Tender Creation</h6>
<div class="Clear"></div>

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		</td>
		<td><input type="button" name="Add" type="submit" value="Create"
			class="button" onClick="newTenderCreation();"></td>
	</tr>
</table>

<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchForm" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td><label> Tender No: </label></td>

		<td><select name="<%=TENDER_NO%>">
			<option value="">Select Tender No</option>

			<%
			if (existingTenderNumbersList!=null && existingTenderNumbersList.size()>0)
			{
				for(int i=0;i<existingTenderNumbersList.size();i++) 
				{
			%>
			<option value="<%=existingTenderNumbersList.get(i)%>"><%=existingTenderNumbersList.get(i)%></option>
			<% }
				}
			 %>

		</select></td>

		<td><input type="button" name="Submit" id="addbutton" value=" "
			class="morebutton" onClick="jsDisplay();" /></td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>

<div class="Clear"></div>


<form name="tenderForm" method="post"><input type="hidden"
	name="numOfRows" size="5" value="15"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="mmfyear" size="5" value="<%=box.get("mmfyear")%>"> <input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<div class="blockTitle">Tender Creation</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>"
	value="<%=box.get(TENDER_SUPPLIER_GROUP_ID)%>"
	id="<%=TENDER_SUPPLIER_GROUP_ID%>"
	onChange="getImportProposals(this.value)">
	<option value="">--Select Group--</option>
	<%
			for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
			{
				MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
			%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
			}
			%>
</select> <label> Tender No: </label> <input type="text" name="<%=TENDER_NO%>"
	value="<%=box.get(TENDER_NO) %>" validate="Tender No,string,yes"
	readonly /> <label> Invit. Dt</label> <input type="text"
	name="<%=DATE_INVITE_TENDER%>" class="calDate"
	value="<%=box.get(DATE_INVITE_TENDER) %>" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.date_invite_tender,event)" />

<div class="Clear"></div>

<label>Commen. Date </label> <input type="text" class="calDate"
	name="<%=DATE_COMMENCEMENT%>" value="<%=box.get(DATE_COMMENCEMENT) %>"
	readonly /> <img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.date_commencement,event)" />

<label> Last Date(Iss)</label>
</td>
<input class="calDate" type="text" name="<%=LAST_DATE_TENDER_DOCUMENT%>"
	value="<%=box.get(LAST_DATE_TENDER_DOCUMENT) %>" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.last_date_tender_document,event)" />

<label> Time of Rcpt</label> <input type="text"
	name="<%=TIME_RECEIPT_TENDER_SAMPLES%>"
	value="<%=box.get(TIME_RECEIPT_TENDER_SAMPLES)%>"
	validate="Time of Receipt of Tender Samples,,yes" maxlength="15" />

<div class="Clear"></div>

<label> Place of rcpt</label> <input type="text"
	name="<%=PLACE_RECEIPT_TENDER_SAMPLES%>"
	value="<%=box.get(PLACE_RECEIPT_TENDER_SAMPLES) %>"
	validate="Place of Receipt of Tender Samples,,yes" maxlength="50" /> <label>
Last Date(Rcpt)</label> <input type="text"
	name="<%=LAST_DATE_RECEIPT_TENDER_SAMPLES%>" class="calDate"
	value="<%=box.get(LAST_DATE_RECEIPT_TENDER_SAMPLES)%>"
	validate="Last Date of Receipt of Tender Samples,,yes" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.last_date_receipt_tender_samples,event)" />

<label> Open. Dt(Tech)</label> <input type="text"
	name="<%=DATE_OPENING_TECHNICAL%>" class="calDate"
	value="<%=box.get(DATE_OPENING_TECHNICAL) %>"
	validate="Opening Date of Commercial Bid,,yes" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.date_opening_technical,event)" />

<div class="Clear"></div>

<label> Opening Dt(Comm)</label> <input type="text" class="calDate"
	name="<%=DATE_OPENING_COMMERCIAL%>"
	value="<%=box.get(DATE_OPENING_COMMERCIAL) %>"
	validate="Opening Date of Commercial Bid,,yes" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderForm.date_opening_commercial,event)" />


<label>Terms & Conditions </label> <textarea
	name="<%=TERMS_CONDITIONS%>" cols="60" rows="2" maxlength="512"
	onkeyup="return ismaxlength(this)" class="txtarea"
	validate="Terms & Conditions,,yes"><%=box.get(TERMS_CONDITIONS)%></textarea>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>

<% if (box.get("mmfyear").toString() == null || box.get("mmfyear").toString().equals("")) { %>


<div class="Clear"></div>
<div style="display: none;"><label>MMY Year</label> <select
	name="mmfyearcombo" style="width: 110px;">
	<% if (mmfyears!=null && mmfyears.size() > 0)
			{
			for (int i=0;i<mmfyears.size();i++)
			{ 
			%>
	<option value=<%=mmfyears.get(i)%>><%=mmfyears.get(i)%></option>
	<%
			}
			}
			%>
</select>
<div class="Clear"></div>
<input type="button" name="Submit" id="addbutton" value="Import MMF Qty"
	class="cmnButton" onClick="jsSubmit();" /></div>
<div id="STP" style="display: none;">
<% if (proposals.equalsIgnoreCase("yes") && deptId == 24) { %> <input
	type="button" name="Submit1" id="addbutton" value="Import Proposals"
	class="cmnButton" onClick="jsImportTenderProposals('proposals');" /> <% } %>
</div>
<div class="Clear"></div>

</div>

<% } else { %> <input type="checkbox" class="radio" name="master_update"
	value="1" /> <label class="noWidth">Update Master Details</label>
</div>
<div class="Clear"></div>




<div class="Clear"></div>
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>

				<% if (masterStatus!=null && masterStatus.equalsIgnoreCase("O")) { %>
				<td width="7%"><input type="button" name="Add" type="submit"
					value="Add" class="button"
					onClick="openPopupWindow('<%=box.get(TENDER_NO)%>');"></td>
				<% } else {  %>
				<td width="7%"><input type="button" name="Add" type="submit"
					value="Add" class="button"
					onClick="openPopupWindow('<%=box.get(TENDER_NO)%>');" disabled></td>
				<% } %>


				<% if (pagedArray!=null && masterStatus!=null && masterStatus.equalsIgnoreCase("O")) { %>
				<td width="10%"><input type="button" name="Update"
					type="submit" value="Update" class="button" onClick="upd();"></td>
				<% } else {  %>
				<td width="10%"><input type="button" name="Update"
					type="submit" value="Update" class="button" onClick="upd();"
					disabled></td>
				<% } %>


				<% if (pagedArray!=null && masterStatus!=null && masterStatus.equalsIgnoreCase("O")) { %>
				<td width="9%"><input type="button" name="Delete"
					type="submit" value="Delete" class="button" onClick="del();"></td>
				<% } else {  %>
				<td width="9%"><input type="button" name="Delete"
					type="submit" value="Delete" class="button" onClick="del();"
					disabled></td>
				<% } %>
			</tr>
		</table>
		</td>
	</tr>
</table>
<% } %>

<div class="Clear"></div>
<label>PVMS/NIV</label>
<input type="text" name="pvmsNo" value=""
	onkeypress="submitenter(this,event,'tender?method=showTenderCreationJspWithGridData&numOfRows=15&pageCount=10&flag=fresh')" />
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:pvmsSearch();"
	title="Click here to Search Pvms/Niv">
<div class="Clear"></div>
<%		
		if (pagedArray == null) {
		%>
<div class="Clear"></div>
<div class="blockTitle">Tender Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="12%">Stock in Hand</th>
			<th width="13%">Ten.Qty(Exp.Str)</th>
			<th width="12%">Ten.Qty(ECHS)</th>
			<th width="13%">Ten.Qty(Total)</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<%  } else { %>
<div class="Clear"></div>

<div class="blockTitle">Tender Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th width="12%">Stock in Hand</th>
			<th width="13%">Ten.Qty(Exp.Str)</th>
			<th width="12%">Ten.Qty(ECHS)</th>
			<th width="13%">Ten.Qty(Total)</th>
			<th width="6%">DELETE</th>
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
				size="2" name="<%=TENDER_SRNO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" size="10"
				name="<%=TENDER_PVMS %>" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>" size="50"
				name="<%=TENDER_NOMENCLATURE %>" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_AU)%>" name="<%=TENDER_AU%>"
				size="10" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				name="<%=TENDER_STOCK_IN_HAND%>" size="10" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=(gridData[i].get("exp_tender_qty")==null)?"0":gridData[i].get("exp_tender_qty")%>"
				size="10" name="exp_tender_qty" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=(gridData[i].get("echs_tender_qty")==null)?"0":gridData[i].get("echs_tender_qty")%>"
				size="10" name="echs_tender_qty" readonly="readonly" /></td>
			<td width="13%"><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" size="10" validate="Tender Qty,num,no"
				maxlength="16" /></td>
			<td width="6%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"
				name="<%=TENDER_ITEM_ID%>" /></td>

		</tr>
		<% } %>
	</tbody>
</table>
</div>


<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<% } %>
<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label></div>
</form>

</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
