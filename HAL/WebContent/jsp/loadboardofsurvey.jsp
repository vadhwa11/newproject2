<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showboardofsurvey.jsp  
 * Purpose of the JSP -  This is for boardofsurvey.
 * @author  HITESH
 * Create Date: 21st May,2008 
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
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
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
function importBosData()
{
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=createAndImportBosData');
}

function upd()
{
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=updateGridItemsBos');
}

function load(){
alert("hello");
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=loadGridItemsBos');
	
}

function goPage(pidx) {	
	boardOfSurvey.currPage.value = pidx;
	boardOfSurvey.method="post";
	submitForm('boardOfSurvey','neStores?method=getBosData');
}

function showReport(formName)
{
  obj = eval('document.'+formName)
  var bosNo = document.getElementById('bosNo').value
  obj.action = "/hms/hms/neStores?method=printBoardOfSurvey&bosNo="+bosNo;
  obj.submit();
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
	List<StoreItemBatchStock> storeItemBatchStockMList = new ArrayList<StoreItemBatchStock>();
	int pageNo=1;
	String bosNo="";
	int hospitalId = 0;
	 int deptId = 0;
	 String userName="";
	 String lastchangedby="";
	 String lastchangeTime="";
	 String time ="";
	List objectList=new ArrayList();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	
		pagedArray = (PagedArray)map.get("pagedArray");
		System.out.println("PagedArray " + pagedArray);
	
		if(map.get("BosNo")!=null){
			bosNo=(String) map.get("BosNo");
		}
		System.out.println("bosNo>>>>> in jsp"+bosNo);
		
		if(map.get("StoreBosMList")!=null){
			storeBosMlist=(List) map.get("StoreBosMList");
		}
	
		if(map.get("objectList")!=null){
			objectList=(List)map.get("objectList");
		}
		
		if (session.getAttribute("userName") != null){
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
	}
%>





<div class="titleBg">
<h2>Board Of Survey</h2>
</div>


<!-- <input	type="button" id="addbutton" name="Add" type="submit" value="Add" class="button" onClick="submitForm('createGrn','neStores?method=showWorkOrderJsp');">
<input	type="button" name="Modify" type="submit" value="Modify" class="button">
<input	type="button" name="Reset" type="submit" value="Reset"	class="button">
<input	type="button" name="Delete" type="submit" value="Delete"class="button">
<input	type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('createGrn');">
 -->

<div id="searchBlock" style="display: none;">


<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="searchBlock" method="post"><input type="hidden"
	name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
	type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<label>Bos No:</label> <select name="<%=BOS_ID%>" class="bigselect">
	<option value="">Select</option>
	<%
	     for (StoreBosM storeBosM:storeBosMlist ){
			  	
	%>
	<option value="<%=storeBosM.getBosNo()%>"><%=storeBosM.getBosNo()%></option>
	<% } %>
</select> <input type="button" class="button" value="Go!"
	onClick="submitForm('searchBlock','neStores?method=searchBosData');" />


</form>
</div>

</div>






<div class="Clear"></div>
<form name="boardOfSurvey" method="post">
<div class="Block"><input type="hidden" name="hospitalId" size="5"
	value="<%=hospitalId%>"> <input type="hidden" name="deptId"
	size="5" value="<%=deptId%>"> <input type="hidden"
	name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <label>
Authority No.<span>*</span></label> <input type="text" name="<%=BOS_ID%>"
	id="bosNo" value="<%=bosNo%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label>Authority
Date <span>*</span> </label> <input type="text" name=<%=BOS_DATE%>
	class="textbox_size20" value="<%=currentDate%>" readonly /></div>



<div class="cmntable">
<table width="100%" colspan="7" id="bosDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead >
		<tr>
			<th width="2%" rowspan="2" style="width:5px;" >Sl.</th>
			<th width="8%" rowspan="2" style="width:8px;">PVMS/NIV No.</th>
			<th width="20%" rowspan="2" style="width:20px;">Nomenclature</th>
			<th width="10%" rowspan="2">A/U</th>
			<th width="10%" rowspan="2">Serial No.</th>
			<th width="10%" rowspan="2">Qty Held</th>
			<th colspan="4" align="center" class="smalllabel">Condition of
			Store Found by Board</th>
			<th colspan="5" align="center" class="smalllabel">Recommendation
			of Board</th>
			<th align="center" class="smalllabel">&nbsp;</th>
			<th>Remarks</th>
		</tr>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">Serviceable</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Repairable</label></td>
			<td width="10%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Obs</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Retained
			in Service</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Repair
			Necessary</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Disposed
			Off in whole state or destroyed</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Returned
			to AFMSD</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Convert
			to Produce To</label></td>
			<td width="10%"><label valign="left" class="smalllabel">RV
			No & Date To Cost</label></td>
			<td width="10%"><label valign="left" class="smalllabel"></label></td>
		</tr>
	</thead>
	<tbody>
		<%--<%if(storeItemBatchStock.getItem().getTypeOfItem().equals("NE")){} %> --%>
		<%
		int count=0;
		
		
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		//Iterator iterator1 = masManuList.iterator();
		//Object[] object1=(Object[])iterator1.next();
		//System.out.println(""+object1[1]);%>

		<tr>
			<td width="10%"><input type="text" value="<%=++count%>" size="2"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="5"
				value="<%=object[4] %>"
				class="medcaption" name="<%=PVMS_NO %>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="40"
				value="<%=object[3]%>"
				class="bigcaption" name="<%=NOMENCLATURE %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=object[5] %>"
				class="medcaption" name="<%=AU %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=object[1] %>"
				name="<%=SERIAL_NUMBER %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=object[0] %>" name="<%=QTY %>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=SERVICABLE %>" maxlength=1 validate="SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=REPAIRABLE %>" maxlength=1 validate="REPAIRABLE,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=UN_SERVICABLE %>" maxlength=1
				validate="UN_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text" value="" name="<%=OBS%>"
				maxlength=1 validate="OBS,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=BOARD_SERVICABLE%>" maxlength=1
				validate="BOARD_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=BACKLOADED%>" maxlength=1 validate="BACKLOADED,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=BOARD_UN_SERVICABLE %>" maxlength=1
				validate="BOARD_UN_SERVICABLE,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=BOARD_DESTROYED%>" maxlength=1
				validate="BOARD_DESTROYED,num,no" /></td>
			<td width="10%"><input type="text" value=""
				name="<%=REDUCED_TO %>" maxlength=1 validate="REDUCED_TO,num,no" /></td>
			<td width="20%"><input type="text" value="" class="bigcaption"
				name="<%=CRV_COST%>" maxlength=30 validate="CRV_COST,string,no" /></td>
			<td width="10%"><input type="text" value="" name="<%=REMARKS%>"
				maxlength=50 validate="REMARKS,string,no" /></td>
			<td width="10%"><input type="hidden" value="" name="id" /></td>
			<td width="10%"><input type="hidden" name="<%=COST%>" size="5"
				value=""></td>

		<% }
	  %>
		</tr>

	</tbody>
</table>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Add" value="LOAD ALL EQUIPMENT"
	class="buttonBig" onclick="load()"> <%--<input type="button" name="Add" value="SAVE" onClick="openPopupWindow();" class="button"> --%>
<input type="button" name="Submit" value="SAVE" onClick="upd();" /> <input
	type="button" name="Add" value="CONDEMNATION ENTRY" class="buttonBig">
<%--<input type="button" name="Reset" value="Reset" class="toolbutton"/>
	<input type="button" name="Delete" value="Delete" class="toolbutton"/>--%>
<input type="button" name="Modify" value="PRINT" class="toolbutton"
	onClick="" /> <input type="button" name="sss" class="button"
	value="SEARCH" onclick="getSearchBlock();" /> <%--<input type="button" name="Submit" id="addbutton" value="Import Condemnation Entry" class="buttonbig" onClick="importBosData();" /> --%>
<div class="Clear"></div>
<div class="division"></div>
<input type="hidden" name="hospitalId" value="" /></form>
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