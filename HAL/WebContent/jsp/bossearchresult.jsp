<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentBD.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreBosM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script language="Javascript">
function search()
{
searchBlock.method="post";
submitForm('searchBlock','neStores?method=searchBosData');
}


function importBosData()
{
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=createAndImportBosData');
}

function upd()
{
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=updateSearchGridItemsBos');
}

function goPage(pidx) {	
	boardOfSurvey.currPage.value = pidx;
	boardOfSurvey.method="post";
	submitForm('boardOfSurvey','neStores?method=getBosData');
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
	Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
    HashMap[] gridData =null;
    PagedArray pagedArray = null;
	String previousPage="no";
	List<StoreBosM> storeBosMlist = new ArrayList<StoreBosM>();
	int pageNo=1;
	String bosNo="";
	int hospitalId = 0;
	 int deptId = 0;
	 String userName="";
	 String lastchangedby="";
	 String lastchangeTime="";
	 String time ="";
	 String bosStatus="o";
		
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	
		pagedArray = (PagedArray)map.get("pagedArray");
		System.out.println("PagedArray " + pagedArray);
	
		if(map.get("bosno")!=null)
			bosNo=(String) map.get("bosno");
		System.out.println("bosNo>>>>> in jsp"+bosNo);
		
		if(map.get("StoreBosMList")!=null)
			storeBosMlist=(List) map.get("StoreBosMList");
		
		if(map.get("bosStatus")!=null)
		{
			bosStatus = (String) map.get("bosStatus");
			System.out.println("bosstatus >>>>"+bosStatus);
		}
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
	}
%>



<div id="contentspace">
<h2 align="left" class="style1">Board Of Survey</h2>
<div class="clear"></div>
<div id="searchBlock" style="display:none;">
<form name="searchBlock" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">

<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
	<label>Bos No:</label>
	 <select name="<%=BOS_ID%>" class="bigselect">
	<option value="">Select</option>
	<%
	     for (StoreBosM storeBosM:storeBosMlist ){
			  	
	%>
			<option value="<%=storeBosM.getBosNo()%>"><%=storeBosM.getBosNo()%></option>
			<% } %>
		</select> <input type="button" class="button" value="Search"
			onClick="search()" />

</div>
</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	
	function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
	</script>
		
<%--				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					onClick="openPopupWindow();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
 --%>
<div class="clear"></div>		
<%--<input type="button" name="Submit" id="addbutton" value="Import LastIndent" class="button" onClick="importBosData();" /> --%>
<form name="boardOfSurvey" method="post"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <label
	class="bodytextB">BOS No :</label> <input type="text"
	name="<%=BOS_ID%>" value="<%=bosNo%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB">BOS Date :</label> <input type="text"
	name=<%=BOS_DATE%> class="textbox_size20" value="<%=currentDate%>"
	readonly /> <br />

<br />
<% if (pagedArray == null) { %>
<div class="cmntable">
<table width="100%" colspan="7" id="bosDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">SerialNo</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty</label></td>
			<td width="10%"><label valign="left" class="smalllabel">ser</label></td>
			<td width="10%"><label valign="left" class="smalllabel">rep</label></td>
			<td width="10%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="10%"><label valign="left" class="smalllabel">OBS</label></td>
			<td width="10%"><label valign="left" class="smalllabel">SER</label></td>
			<td width="10%"><label valign="left" class="smalllabel">BackLoaded</label></td>
			<td width="10%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Destroyed</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Reduced
			To</label></td>
			<td width="10%"><label valign="left" class="smalllabel">CRV
			To Cost</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Remarks</label></td>
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
<h4>Board Of Survey Details</h4>

<div class="cmntable">
<table width="100%" >
		<thead>
		<tr>

			<td width="10%">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">SerialNo</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			</label></td>
			<td width="10%"><label valign="left" class="smalllabel">ser</label></td>
			<td width="10%"><label valign="left" class="smalllabel">rep</label></td>
			<td width="10%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="10%"><label valign="left" class="smalllabel">OBS</label></td>
			<td width="10%"><label valign="left" class="smalllabel">SER</label></td>
			<td width="10%"><label valign="left" class="smalllabel">BackLoaded</label></td>
			<td width="10%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Destroyed</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Reduced
			To</label></td>
			<td width="20%"><label valign="left" class="smalllabel">CRV
			To Cost</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Remarks</label></td>

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
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")%>" class="medcaption"
				name="<%=PVMS_NO %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="<%=NOMENCLATURE %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="<%=AU %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("serialNo")%>" name="<%=SERIAL_NUMBER %>"
				validate="Stock In Hand,num,no" readonly="readonly" /></td>
			<%if(bosStatus.equals("o")){ %>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qty")%>" name="<%=QTY %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("ser")%>" name="<%=SERVICABLE %>"
				maxlength=1 validate="SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("rep")%>" name="<%=REPAIRABLE %>"
				maxlength=1 validate="REPAIRABLE,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("us")%>" name="<%=UN_SERVICABLE %>"
				maxlength=1 validate="UN_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("obs")%>" name="<%=OBS%>" maxlength=1
				validate="OBS,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("recser")%>" name="<%=BOARD_SERVICABLE%>"
				maxlength=1 validate="BOARD_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("backloaded")%>" name="<%=BACKLOADED%>"
				maxlength=1 validate="BACKLOADED,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("bunser")%>"
				name="<%=BOARD_UN_SERVICABLE %>" maxlength=1
				validate="BOARD_UN_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("destroyed")%>"
				name="<%=BOARD_DESTROYED%>" maxlength=1
				validate="BOARD_DESTROYED,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("boardreduced")%>" name="<%=REDUCED_TO %>"
				maxlength=1 validate="REDUCED_TO,num,no" /></td>
			<td width="20%"><input type="text"
				value="<%=gridData[i].get("crvnocost")%>" class="bigcaption"
				name="<%=CRV_COST%>" maxlength=25 validate="CRV_COST,string,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remarks")%>" name="<%=REMARKS%>"
				readonly="readonly" maxlength=50 validate="REMARKS,string,no" /></td>
			<%}else{ %>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qty")%>" name="<%=QTY %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("ser")%>" name="<%=SERVICABLE %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("rep")%>" name="<%=REPAIRABLE %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("us")%>" name="<%=UN_SERVICABLE %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("obs")%>" name="<%=OBS%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("recser")%>" name="<%=BOARD_SERVICABLE%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("backloaded")%>" name="<%=BACKLOADED%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("bunser")%>"
				name="<%=BOARD_UN_SERVICABLE %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("destroyed")%>"
				name="<%=BOARD_DESTROYED%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("boardreduced")%>" name="<%=REDUCED_TO %>"
				readonly="readonly" /></td>
			<td width="20%"><input type="text"
				value="<%=gridData[i].get("crvnocost")%>" class="bigcaption"
				name="<%=CRV_COST%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remarks")%>" name="<%=REMARKS%>"
				readonly="readonly" /></td>
			<%} %>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>">
			</td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
			<td width="10%"><input type="hidden" name="<%=COST%>" size="5"
				value="<%=gridData[i].get("costprice")%>"></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>

<% } %> <input type="hidden" name="hospitalId" value="" /></form>
<div class="clear" ></div>
<input type="button" name="Modify" type="submit" value="Modify" onClick="upd();" class="toolbutton" />
<input type="button" name="Modify" value="Print" class="toolbutton" onClick="submitForm('indent','stores?method=showPrintIndentDepotJsp');" />
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<div class="clear" ></div>


<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>


</form>

</div>
