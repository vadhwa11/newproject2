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
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestT"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
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
	
	int orderBy = 0;
	Date orderDate = null;
	String date = "";
	String time = "";
	
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = (ArrayList<CssdAutoclaveRequestT>)map.get("cssdAutoclaveRequestTList");
	List<CssdInstrumentMaster> cssdInstrumentMasterList = (ArrayList<CssdInstrumentMaster>)map.get("cssdInstrumentMasterList");
	
	if (cssdAutoclaveRequestMList!=null && cssdAutoclaveRequestMList.size() > 0)
	{
		orderBy = cssdAutoclaveRequestMList.get(0).getOrderBy().getId();	
		orderDate = cssdAutoclaveRequestMList.get(0).getOrderDate();
		
		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		date =formatterOut.format(formatterIn.parse(""+orderDate));
		time = cssdAutoclaveRequestMList.get(0).getOrderTime();
	}
	else
		date = currentDate;
	
%>

<script language="javascript">

</script>

<!--Block Two Starts-->
<div id="testDiv">
<div class="blockFrame">
<div class="Height10"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Container Code</th>
		<th>Container Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
		<th></th>
	</tr>
	<tr>
		<td><input id="materialCode" name="materialCode" type="text"
			size="10" MAXLENGTH="10" readonly="readonly" /></td>

		<td><input type="text" id="materialName" name="materialName"
			size="25" MAXLENGTH="25" onblur="onBlurMaterialName(this.value)" />
		<div id="ac2update"
			style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('materialName','ac2update','cssd?method=getAutoclaveRequestMaterialNamesForAutocomplete',{parameters:'requiredField=materialName&orderNo='+document.getElementById('orderNo').value });
	</script></td>

		<td><select name="instrumentCode" id="instrumentCode">
			<option value="0">Select Instrument</option>
			<%for(CssdInstrumentMaster cssdInstrumentMaster : cssdInstrumentMasterList) { %>
			<option value="<%=cssdInstrumentMaster.getInstrumentCode()%>"><%=cssdInstrumentMaster.getInstrumentName()%></option>
			<%} %>
		</select></td>

		<td><input id="qty" name="qty" type="text" size="3" MAXLENGTH="3" /></td>
		<td><input id="remarks" name="remarks" type="text" size="25"
			MAXLENGTH="25" /></td>
		<td><input name="Button" type="button" class="button" value="Add"
			onClick="addAndRefreshAutoclaveRequestGrid()" /></td>
	</tr>
</table>
</div>

</div>

<!--Block Two Ends--> <input type="hidden" name="pageno"
	value=<%=pageno%> /> <input type="hidden" name="totalPages"
	value=<%=totalPages%> /> <input type="hidden" name="totalRecords"
	value=<%=totalRecords%> /> <input type="hidden" name="numOfRows"
	value=5 />


<div class="division"></div>
<div class="blockTitle">Autoclave Request Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Sr.No.</th>
		<th>Container Code</th>
		<th>Container Name</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
	</tr>

	<%
  for(CssdAutoclaveRequestT cssdAutoclaveRequestT : cssdAutoclaveRequestTList)
  { %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdAutoclaveRequestT.getMaterial().getMaterialCode()%></td>
		<td><%=cssdAutoclaveRequestT.getMaterial().getMaterialName() %></td>
		<td><%=cssdAutoclaveRequestT.getInstrument().getInstrumentName() %></td>
		<td><%=cssdAutoclaveRequestT.getQty()%></td>
		<td><%=cssdAutoclaveRequestT.getRemarks()%></td>
	</tr>
	<% } %>
</table>
</div>
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
window.document.getElementById('materialCode').value="";
window.document.getElementById('materialName').value="";
window.document.getElementById('qty').value="";
window.document.getElementById('remarks').value="";

for(var i=0;i<document.getElementById('orderBy').length;i++)
 {
	 if (document.getElementById('orderBy').options[i].value=="<%=orderBy%>")
	 {
	 	document.getElementById('orderBy').selectedIndex = i;
	 }
 }
  
 document.getElementById('orderDate').value="<%=date%>";
 document.getElementById('orderTime').value="<%=time%>";
</script>