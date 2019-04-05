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
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

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



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		System.out.println("map " + map);
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int meScaleMasterId = 0;
	if (box.getInt("meScaleMasterId")!=0)
	{
		meScaleMasterId = box.getInt("meScaleMasterId"); 
	}
	else if (map.get("meScaleMasterId")!=null) 
	{
		meScaleMasterId = (Integer)map.get("meScaleMasterId");
	}
	
%>

<title>ME Scale Addition</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="../style/pdb_style.css" rel="stylesheet" type="text/css" />
<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	meScaleAddForm.currPage.value = pidx;
	meScaleAddForm.method="post";
		var meScaleMasterId = document.meScaleAddForm.meScaleMasterId.value;
	submitForm('meScaleAddForm','neStores?method=searchItemsForMEScale&meScaleMasterId='+meScaleMasterId);
}

function jsSubmit()
{
		meScaleAddForm.method="post";
		var meScaleMasterId = document.meScaleAddForm.meScaleMasterId.value;
		submitForm('meScaleAddForm','neStores?method=searchItemsForMEScale&meScaleMasterId='+meScaleMasterId);
}

function jsAdd()
{
		meScaleAddForm.method="post";
		var meScaleMasterId = document.meScaleAddForm.meScaleMasterId.value;
		submitForm('meScaleAddForm','neStores?method=addItemToMeScale&meScaleMasterId='+meScaleMasterId); 
}


function jsClose(meScaleMasterId)
{
  window.opener.location.href = "neStores?method=getMeScaleDescription&<%=ME_SCALE_NUMBER%>="+meScaleMasterId;
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}



</script>

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<br />

<h2 align="left" class="style1">ME Scale Addition</h2>



<div id="contentspace">

<form name="meScaleAddForm"><input type="hidden" name="numOfRows"
	size="5" value="15"> <input type="hidden" name="pageCount"
	size="5" value="10"> <input type="hidden" name="search"
	size="5" value="true"> <input type="hidden"
	name="meScaleMasterId" value="<%=meScaleMasterId%>" /> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div style="padding-left: 15px;">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item(s) Search</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 760px; height: 83px; background-color: #f4f9fe;">
<br />
<label class="bodytextB">Nomenclature</label> <input type="text"
	name="search_text" value="<%=box.get("search_text") %>"
	class="textbox_size20" MAXLENGTH="30" validate="Hin No,string,yes" /> <input
	type="button" name="Submit" id="addbutton" onClick="jsSubmit()"
	value="Submit" class="button" /></div>
<br />
<br />
<%		
		if (pagedArray == null) {
		%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">ME Scale Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<table width="75%" colspan="7" class="grid_header" border="1"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="30%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Strength</label></td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
<%  } else { %>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">ME Scale Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<div
	style="overflow: scroll; overflow-x: hidden; width: 85%; height: 300px; BORDER: #202020 1px solid;">
<table width="75%" colspan="7" class="grid_header" border="1"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td><label valign="left" class="smalllabel">SR No</label></td>
			<td><label valign="left" class="smalllabel">PVMS No</label></td>
			<td><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td><label valign="left" class="smalllabel">Strength</label></td>
			<td><label valign="left" class="smalllabel">A/U</label></td>
			<td><label valign="left" class="smalllabel">Qty</label></td>
			<td><label valign="left" class="smalllabel">ADD</label></td>
		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("pvms" )%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("strength")==null?"":gridData[i].get("strength")%>"
				class="medcaption" name="strength" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("au")%>"
				name="au" class="medcaption" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get("qty")==null)?"0":gridData[i].get("qty")%>"
				class="medcaption" name="qty" validate="Qty,num,no" /></td>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("itemId")%>"></td>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=8 align="center"></td>
		</tr>
	</tbody>
</table>
</div>
<br />
<div style="padding-left: 250px;">
<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>
<div><br />
<input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" /> <input type="button" name="Close"
	onClick="jsClose(<%=meScaleMasterId%>)" value="Close" class="button" />
</div>
<%}%>

</form>
</div>
</div>