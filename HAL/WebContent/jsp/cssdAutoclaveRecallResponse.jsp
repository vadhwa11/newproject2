<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *   
 * Purpose of the JSP 
 * @author  Othivadivel K R
* Create Date: 25.05.2009
 * Revision Date:      
 * Revision By:  
 * 
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveReceiptT"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	
	if(month.length()<2)
	{
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	

	int pageno=0;
	int totalPages = 0;
	int totalRecords=0;
	int numOfRows=0;
	
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}
	
	if (map.get("numOfRows")!=null)
	{
		numOfRows = Integer.parseInt(map.get("numOfRows").toString());
	}
	
	int i = (pageno - 1) * numOfRows;

	String time = (String) utilMap.get("currentTime");
	List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = (ArrayList<CssdAutoclaveReceiptT>)map.get("cssdAutoclaveReceiptTList");
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
%>

<!--Block Two Starts-->
<div id="testDiv"><input type="hidden" name="pageno"
	value=<%=pageno%> /> <input type="hidden" name="totalPages"
	value=<%=totalPages%> /> <input type="hidden" name="totalRecords"
	value=<%=totalRecords%> /> <input type="hidden" name="numOfRows"
	value=5 />

<div class="division"></div>
<div class="blockTitle">Sterilize Recall List</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Date</th>
		<th>Time</th>
		<th>Department Name</th>
		<th>Material Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Lot No.</th>
		<th>Result</th>
		<th>Status</th>
	</tr>
	<% for(CssdAutoclaveReceiptT cssdAutoclaveReceiptT : cssdAutoclaveReceiptTList) { %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdAutoclaveReceiptT.getReceiptM().getReceiptDate()%></td>
		<td><%=cssdAutoclaveReceiptT.getReceiptM().getLastChgTime()%></td>
		<td><%=cssdAutoclaveReceiptT.getReceiptM().getDepartment().getDepartmentName()%></td>
		<td><%=cssdAutoclaveReceiptT.getMaterial().getMaterialName()%></td>
		<td><%=cssdAutoclaveReceiptT.getInstrument().getInstrumentName()%></td>
		<td><%=cssdAutoclaveReceiptT.getQty()%></td>
		<td><%=cssdAutoclaveReceiptT.getEntryM().getLotNo()%></td>
		<td><%=cssdAutoclaveReceiptT.getResult()%></td>
		<td><select name="status" id="status" style="width: 100px">
			<option value="<%=cssdAutoclaveReceiptT.getRecallStatus()%>"><%=cssdAutoclaveReceiptT.getRecallStatus()%></option>
			<option value="Received">Received</option>
		</select></td>
		<input type="hidden" name="receiptTId"
			value="<%=cssdAutoclaveReceiptT.getId()%>" />
		<input type="hidden" name="receiptMId"
			value="<%=cssdAutoclaveReceiptT.getReceiptM().getId()%>" />
	</tr>
	<% } %>

</table>
<% if (cssdAutoclaveReceiptTList!=null && cssdAutoclaveReceiptTList.size() > 0) { %>
<input type="button" name="Update" class="buttonbig" value="Submit"
	onClick="updateAutoclaveRecallGridData()" /> <% } %>
</div>
</div>

<div id="pagination">
<% if (totalPages > 0 ) { %> <label>Page <%=pageno %> of <%=totalPages %></label>
<label><a href="javascript:goPrevious()">Prev<<</a>&nbsp;&nbsp;</label>
<label><a href="javascript:goNext()">>>Next</a></label> <input
	type="text" name="gopage" size="3" /><label><input
	type="button" name="Go Page" class="cmnButton" type="submit"
	value="Go Page" onclick="javascript:GoPage();"></label> <% } %>
</div>
</div>
