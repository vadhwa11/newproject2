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
<%@page import="jkt.hms.masters.business.CssdAutoclaveReceiptM"%>
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
	String msg = "";
	
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
	
	if (map.get("updateMsg")!=null)
	{
	    msg = map.get("updateMsg").toString();
	    System.out.println("msg " + msg);
	}
	
	int i = (pageno - 1) * numOfRows;
	
	String receiptNo = "";
	String orderNo = "";
	Date receiptDate = null;
	int receivedBy = 0;
	String date = "";
	
	List<CssdAutoclaveReceiptM> cssdAutoclaveReceiptMList = (ArrayList<CssdAutoclaveReceiptM>)map.get("cssdAutoclaveReceiptMList");
	List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = (ArrayList<CssdAutoclaveReceiptT>)map.get("cssdAutoclaveReceiptTList");

	if (cssdAutoclaveReceiptMList!=null && cssdAutoclaveReceiptMList.size() > 0)
	{
		receiptNo = cssdAutoclaveReceiptMList.get(0).getReceiptNo();
		receivedBy = cssdAutoclaveReceiptMList.get(0).getReceivedBy().getId();
		receiptDate = cssdAutoclaveReceiptMList.get(0).getReceiptDate();
		orderNo = cssdAutoclaveReceiptMList.get(0).getRequest().getOrderNo();
		
		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		date =formatterOut.format(formatterIn.parse(""+receiptDate));
	}
	else
		date = currentDate;
	
%>

<!--Block Two Starts-->
<div id="testDiv"><input type="hidden" name="pageno"
	value=<%=pageno%> /> <input type="hidden" name="totalPages"
	value=<%=totalPages%> /> <input type="hidden" name="totalRecords"
	value=<%=totalRecords%> /> <input type="hidden" name="numOfRows"
	value=5 />


<div class="division"></div>
<div class="blockTitle">Autoclave Material Receipt Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Material Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Itegrator/Non-Integrator</th>
		<th>Result</th>
	</tr>

	<%
  for(CssdAutoclaveReceiptT cssdAutoclaveReceiptT : cssdAutoclaveReceiptTList)
  { %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdAutoclaveReceiptT.getMaterial().getMaterialName() %></td>
		<td><%=cssdAutoclaveReceiptT.getInstrument().getInstrumentName() %></td>
		<td><%=cssdAutoclaveReceiptT.getQty()%></td>

		<td><select name="integrator" id="integrator<%=i%>"
			style="width: 90px" onChange="disableResultCombo(<%=i%>)">
			<option value="N"
				<%=HMSUtil.isSelected("N",cssdAutoclaveReceiptT.getIntegrator().toString())%>>Not-Integrator</option>
			<option value="Y"
				<%=HMSUtil.isSelected("Y",cssdAutoclaveReceiptT.getIntegrator().toString())%>>Integrator</option>
		</select></td>

		<% if (cssdAutoclaveReceiptT.getIntegrator().toString().equalsIgnoreCase("N")) { %>
		<td><select name="result" id="result<%=i%>" disabled=true>
			<option value=""
				<%=HMSUtil.isSelected("",cssdAutoclaveReceiptT.getResult().toString())%>>-</option>
			<option value="Pass"
				<%=HMSUtil.isSelected("Pass",cssdAutoclaveReceiptT.getResult().toString())%>>Pass</option>
			<option value="Fail"
				<%=HMSUtil.isSelected("Fail",cssdAutoclaveReceiptT.getResult().toString())%>>Fail</option>
		</select></td>
		<% } else {  %>
		<td><select name="result" id="result<%=i%>">
			<option value="Pass"
				<%=HMSUtil.isSelected("Pass",cssdAutoclaveReceiptT.getResult().toString())%>>Pass</option>
			<option value="Fail"
				<%=HMSUtil.isSelected("Fail",cssdAutoclaveReceiptT.getResult().toString())%>>Fail</option>
		</select></td>
		<% } %>
		<input type="hidden" name="receiptTId"
			value="<%=cssdAutoclaveReceiptT.getId()%>" />
	</tr>
	<% } %>
</table>
<input type="button" name="Update" class="buttonbig" value="Submit"
	onClick="updateAutoclaveReceiptGridData()" /></div>
</div>
<div id="pagination">
<% if (totalPages > 0 ) { %> <label>Page <%=pageno %> of <%=totalPages %></label>
<label><a href="javascript:goPrevious()">Prev<<</a>&nbsp;&nbsp;</label>
<label><a href="javascript:goNext()">>>Next</a></label> <input
	type="text" name="gopage" size="3" /> <label><input
	type="button" name="Go Page" class="cmnButton" type="submit"
	value="Go Page" onclick="javascript:GoPage();"></label> <% } %>
</div>

</div>
<div class="Clear"></div>


<script>

for(var i=0;i<document.getElementById('receivedBy').length;i++)
 {
	 if (document.getElementById('receivedBy').options[i].value=="<%=receivedBy%>")
	 {
	 	document.getElementById('receivedBy').selectedIndex = i;
	 }
 }
 
document.getElementById('orderNo').options.length = 1;
document.getElementById('orderNo').options[0].value="<%=orderNo%>";
document.getElementById('orderNo').options[0].text="<%=orderNo%>";
 

document.getElementById('receiptDate').value="<%=date%>";

for(var i=0;i<document.getElementById('receiptNo').length;i++)
 {
	 if (document.getElementById('receiptNo').options[i].value=="<%=receiptNo%>")
	 {
	 	document.getElementById('receiptNo').selectedIndex = i;
	 }
 }
 
document.getElementById('goButton').disabled = true;

<% if (msg.length() > 0) { %>
	alert('<%=msg%>');
<% } %>

</script>