
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgment.jsp  
	 * Purpose of the JSP -  This is for Department Indent.
	 * @author  Mansi
	 * Create Date: 21th Apr, 2008
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5  
	--%>


<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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



<script language="Javascript">
	
deptArray = new Array();
	    
function populateIssueNoAndDate(val,formName){
		obj = eval('document.'+formName+'.issueNo');
		obj.length = 1;
		for(i=0;i<deptArray.length;i++){
			if(deptArray[i][1]==val){
				obj.length++;
				obj.options[obj.length-1].value=deptArray[i][0];
				obj.options[obj.length-1].text=deptArray[i][2];			
			}
		}
	}
	
function getIssue()
{
	ack.method="post";
	var issueNo = document.getElementById('issueNo').value
	alert(issueNo)
	submitForm('ack','stores?method=createGridIssueData&<%=ISSUE_NO%>='+issueNo);
	
}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	ack.currPage.value = pidx;
	ack.method="post";
	submitForm('ack','stores?method=createGridIssueData');
}
function showAck(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=closeAckJsp";
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
		int deptId = 0;
		
		int issueMId = 0;
		List<StoreIssueM> searchStoreIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueM> sMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
	
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		if (map.get("issueMId")!=null){
			issueMId=Integer.parseInt(""+map.get("issueMId"));
		}
		if(session.getAttribute("deptId") != null){
			deptId = Integer.parseInt(""+session.getAttribute("deptId"));
		}
		
		if(map.get("searchStoreIssueMList")!=null)
			searchStoreIssueMList = (List) map.get("searchStoreIssueMList");
		
		if(map.get("storeIssueMList")!=null)
			sMList = (List) map.get("storeIssueMList");
		
		System.out.println("searchStoreIssueMList in JSP"+searchStoreIssueMList.size());
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		if(map.get("departmentList") != null){
			departmentList = (ArrayList) map.get("departmentList");
			session.setAttribute("departmentList",departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (ArrayList)session.getAttribute("departmentList");
			
		}
	
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		if(map.get("approvedByEmployeeList") != null){
			approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
			session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
		}else if(session.getAttribute("approvedByEmployeeList") != null){
			approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		}
	
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
<br>
<br>
<%
			   out.println(message);
		}
		int approvedById = 0;
		if(session.getAttribute("approvedById") != null){
			approvedById = Integer.parseInt(""+session.getAttribute("approvedById"));
		}
		
		
		if(map.get("storeIssueTList") != null){
			storeIssueTList = (List)map.get("storeIssueTList"); 
		}
		
	%>


<br />
<script type="text/javascript">
			<%
				int counter1 = 0;
				for (StoreIssueM sIm : searchStoreIssueMList)
				{
					
						if(sIm.getId() != null){
									%>
										deptArray[<%=counter1%>] = new Array();
										deptArray[<%=counter1%>][0] =<%=sIm.getId()%>;
										deptArray[<%=counter1%>][1] =<%=sIm.getToStore().getId()%>;
										deptArray[<%=counter1%>][2] = "<%=sIm.getIssueNo()%>";
	
									<%
									counter1++;
							}
						}
				
			%>
			
			
			</script>
<h2 align="left" class="style1">Acknowledgment Form</h2>

<div id="contentspace"><br />


<form name="ack" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10"> <br />
<script>
				document.ack.<%=ISSUE_DEPT%>.focus();
			</script> <label class="bodytextB">Issue Department:</label> <select
	name="<%=ISSUE_DEPT%>" validate="Issue Department,String,yes"
	onchange="populateIssueNoAndDate(this.value,'ack')" tabindex=1>
	<option value="0">Select</option>
	<%
						for (StoreIssueM storeIssueM :searchStoreIssueMList ) {
					%>

	<option value=<%=storeIssueM.getToStore().getId()%>><%=storeIssueM.getToStore().getDepartmentName()%></option>

	<%
						}
					%>
</select> <label class="bodytextB"><font id="error"></font>Acknowledgment
Date:</label> <input type="text" name="<%=ACK_DATE %>"
	value="<%=box.get(ACK_DATE)%>" class="textbox_date" readonly
	validate="Pick a date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.ack.<%=ACK_DATE %>),event)" />
<br />
<br />



<label class="bodytextB">Acknowledgment By:</label> <select
	name="<%=ACK_BY %>" validate="Acknowledgment By,String,yes" tabindex=1>
	<option value="0">Select</option>
	<%
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
					
			%>
	<option value=<%=approvedBy.getId()%>><%=approvedBy.getFirstName()%></option>
	<%	
							
				
					}
				%>
</select> <label class="bodytextB">Receipt Department :</label> <%
				for (StoreIssueM storeIssueM :sMList ) {
				
				%> <label class="wardspan"><%=storeIssueM.getToStore().getDepartmentName()%></label>

<input type="hidden" name="<%=RECEIPT_DEPT%>"
	value="<%=storeIssueM.getToStore().getId() %>"> <%	break;	
					}
					
				%> <br />
<br />
<label class="bodytextB">Issue No:</label> <select id="issueNo"
	name="<%=ISSUE_NO%>" validate="Issue No,String,no"
	onchange="getIssue();" tabindex=1>
	<option value="0">Select</option>
	<%
				for (StoreIssueM storeIssueM :sMList ) {
				
				%>
	<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
	<%	
					}
				
					
				%>
</select> <label class="bodytextB">Issue Date:</label> <%
				for (StoreIssueM storeIssueM :sMList ) {
				%> <label class="wardspan"></label> <input type="hidden"
	name="<%=ISSUE_DATE%>" value="<%=storeIssueM.getToStore().getId() %>">

<%	break;	
					}
				%> <input type="hidden" name="<%=CHANGED_BY %>"
	value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="issueMId"
	value="<%=map.get("issueMId") == null?0:map.get("issueMId")%>" /> <br />

<% if (pagedArray == null) { %>
<fieldset style="width: 99%; padding-left: 9px;"><legend>Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
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
			<td width="10%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Demand
			Qty</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Issue
			Qty</label></td>
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
<fieldset style="width: 99%; padding-left: 9px;"><legend>Acknowledgment
Details</legend>
<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
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
			<td width="10%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Demand
			Qty</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Issue
			Qty</label></td>
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
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("brand")%>" name="brand"
				validate="Brand Name,string,no" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("batchNo")%>" name="batchNo"
				validate="Batch No.,string,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qtyRequest")%>" name="qtyRequest"
				validate="Demand Qty,num,no" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qtyIssued")%>" name="qtyIssued"
				validate="Issue Qty,num,no" /></td>

			<td><input type="hidden"
				value="<%=gridData[i].get("issueId")%>" name="issueId" /></td>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>
</fieldset>

<input type="button" name="add" id="addbutton" value="Accept"
	class="button" onClick="submitForm('ack','stores?method=addAck');"
	accesskey="a" tabindex=1 /> <input type="button" name="close"
	id="closebutton" value="Close" class="button" onClick="showAck('ack')"
	accesskey="u" tabindex=1 /> <% } %>
</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>