
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgment.jsp  
	 * Purpose of the JSP -  This is for Me Scale Equipment.
	 * @author  Mansi
	 * Create Date: 21th Apr, 2008
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5  
	--%>


<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
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
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>


<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>


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

<script language="Javascript"><!--

deptArray = new Array();

function getMeScale(val,formName)
{
	
	obj = eval('document.'+formName+'.meScaleNo');
	obj.length = 1;
	for(i=0;i<deptArray.length;i++){
			if(deptArray[i][1]==val){
				obj.length++;
				obj.options[obj.length-1].value=deptArray[i][0];
				obj.options[obj.length-1].text=deptArray[i][2];			
			}
		}
	
	formName.method="post";
	var meScaleNo = document.getElementById('meScaleNo').value
	alert(meScaleNo)
	submitForm(formName,'neStores?method=createGridMeScaleData&<%=ME_SCALE_NUMBER%>='+meScaleNo);
	
	
	
}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	meScale.currPage.value = pidx;
	meScale.method="post";
	submitForm('meScale','neStores?method=createGridMeScaleData');
}
function showSupplyOrder(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=closeSupplyOrderJsp";
  obj.submit();
}

	--></script>

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
	
		int month1 = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month1 < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month1);
		} else {
			orderDateOnly.append(month1);
		}
	
		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
	
		Box box = HMSUtil.getBox(request);
		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		String flag = "";
		int meScaleId = 0;
		List<MasStoreMeScale> searchMasStoreMeScaleList = new ArrayList<MasStoreMeScale>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		if (map.get("meScaleId")!=null){
			meScaleId=Integer.parseInt(""+map.get("meScaleId"));
		}
		
		
		if(map.get("searchMasStoreMeScaleList")!=null)
			searchMasStoreMeScaleList = (List) map.get("searchMasStoreMeScaleList");
		
		System.out.println("searchMasStoreMeScaleList in JSP"+searchMasStoreMeScaleList.size());
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		int deptId=0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
	
		
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
<br>
<br>
<%
			   out.println(message);
		}
		

	%>


<br />

<h2 align="left" class="style1">ME Scale Equipment Details</h2>

<div id="contentspace"><br />


<form name="meScale" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId %>"> <br />



<label class="bodytextB">ME Scale No:</label> <select id="meScaleNo"
	name="<%=ME_SCALE_NUMBER%>" validate="Me Scale No,String,no"
	onchange="submitProtoAjaxDynamic('meScale','neStores?method=getMeScaleDescription',testDiv);">
	<option value="0">Select</option>
	<%
				for (MasStoreMeScale masStoreMeScale :searchMasStoreMeScaleList ) {
				
				%>
	<option value=<%=masStoreMeScale.getId()%>><%=masStoreMeScale.getMeScale()%></option>
	<%	
					}
				
					
				%>
</select> <br>
<br>
<div id="testDiv"><label class="bodytextB">MeScale
Description: </label> <input type="text" name="<%=ME_SCALE_DESCRIPTION %>"
	value="" class="medcaption" readonly="readonly" /></div>

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name=meScaleId
	value="<%=map.get("meScaleId") == null?0:map.get("meScaleId")%>" /> <br />
<br>
<br>
<% if (pagedArray == null) { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>


			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Old
			PVMS No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Qty</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Section</label></td>


		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>
<% } else { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Old
			PVMS No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Qty</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Section</label></td>
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
				value="<%=gridData[i].get("pvms")%>" class="medcaption" name="pvms"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("oldPvms")%>" class="medcaption"
				name="oldPvms" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("mmf")%>" name="mmf"
				validate="mmf,float,no" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("section")%>" name="section"
				validate="section Qty,string,no" /></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("meScaleId")%>" name="meScaleId" /></td>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>
			<td><input type="hidden"
				value="<%=gridData[i].get("meScaleDetailId")%>"
				name="meScaleDetailId" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>

<input type="button" name="update" id="updatebutton" value="Update"
	class="button"
	onClick="submitForm('meScale','neStores?method=updateMeScale');"
	accesskey="a" tabindex=1 /> <input type="button" name="close"
	id="closebutton" value="Close" class="button"
	onClick="showSupplyOrder('meScale')" accesskey="u" tabindex=1 /> <% } %>


</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>