<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.LibBookStock"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.LibBookStockTakingDt"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script type="text/javascript">
	//this function will be called by the Bean (not from JSP)
function importStock()
{
blockStockTaking.method="post";
submitForm('blockStockTaking','lib?method=getGridDataForStockTaking&pageno=1');
}
function GoPage() {	
	var pgno = parseInt(blockStockTaking.gopage.value);
	var totalPages = parseInt(blockStockTaking.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	 var libHeaderId=document.getElementById("libHeaderId").value;
	blockStockTaking.pageno.value = pgno; 
	blockStockTaking.method="post";
	submitForm('blockStockTaking','lib?method=getGridDataForStockTaking&pageno='+pgno+'&libHeaderId='+libHeaderId+'');
}

function goNext()
{
 var pgno = parseInt(blockStockTaking.pageno.value)+1;
 if (pgno > blockStockTaking.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 var libHeaderId=document.getElementById("libHeaderId").value;
 blockStockTaking.pageno.value = pgno;
 blockStockTaking.method="post";
 submitForm('blockStockTaking','lib?method=getGridDataForStockTaking&pageno='+pgno+'&libHeaderId='+libHeaderId+'');
}
function selectChaecks(){
var totalRows=document.getElementById("stockList").value
for(var i=1;i<=totalRows;i++){

var chaecks=document.getElementById("checkId"+i);
if(chaecks.checked==true) {
document.getElementById("tempForCheackBoxes"+i).value="y";
}
else{
document.getElementById("tempForCheackBoxes"+i).value="n";
}

}
return true;
}

function goPrevious()
{
 var pgno = parseInt(blockStockTaking.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
  var libHeaderId=document.getElementById("libHeaderId").value;
 blockStockTaking.pageno.value = pgno;
 blockStockTaking.method="post";
 submitForm('blockStockTaking','lib?method=getGridDataForStockTaking&pageno='+pgno+'&libHeaderId='+libHeaderId+'');
}
</script>
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
	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> map = new HashMap<String,Object>();
	List<LibBookStock>stockList=new ArrayList<LibBookStock>();
	List<LibBookStockTakingDt>savedDtList=new ArrayList<LibBookStockTakingDt>();
	
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	int numOfRows=0;
	int libHeaderId=0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
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
		if (map.get("stockList")!=null)
		{
			stockList = (List<LibBookStock>)map.get("stockList");
		}
		if (map.get("numOfRows")!=null)
		{
			numOfRows = (Integer)map.get("numOfRows");
		}
		if (map.get("libHeaderId")!=null)
		{
			libHeaderId = (Integer)map.get("libHeaderId");
		}
		if(map.get("savedDtList")!=null){
			savedDtList=(List<LibBookStockTakingDt>)map.get("savedDtList");
		}
%>
<form name="blockStockTaking" method="post" action="">
<div id="contentHolder">
<h6>Books stock Taking Entry</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv">
<%
		String stockSeqNo="";
		if(map.get("stockSeqNo") != null){
			stockSeqNo = (String)map.get("stockSeqNo");
		}
%> <input id="libHeaderId" type="hidden" name="libHeaderId"
	value="<%=libHeaderId %>" /> <label>Stocking Taking No</label> <input
	id="orderNoId" type=hidden name="<%=STOCK_NO %>"
	value="<%=stockSeqNo %>" title="Stock Taking No" /> <label
	class="value"><%=stockSeqNo %></label> <label> Date</label> <input
	type="text" class="calDate" id="stockDateId" name="<%=DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.blockStockTaking.<%=DATE%>,event)" />

<input type="button" name="Import" id="addbutton" value="Import"
	class="cmnButton" onClick="importStock();" /></div>


<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="pageno" value="<%=pageno%>" /> <input
	type="hidden" name="totalPages" value="<%=totalPages%>" /> <input
	type="hidden" name="totalRecords" value="<%=totalRecords%>" /> <input
	type="hidden" name="numOfRows" value="10" />
<div class="Clear"></div>

<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Sl No</th>
			<th scope="col">Name of Book Title</th>
			<th scope="col">Accession No.</th>
			<th scope="col">Year Of Publishing</th>
			<th scope="col">Computed Stock Qty</th>
			<th scope="col">Cost</th>
			<th scope="col">Date of purchase</th>
			<th scope="col">Actual Stock</th>
			<th scope="col">Strike of Charge</th>
		</tr>
	</thead>
	<tbody>
		<%
if (stockList== null || stockList.size()==0) { %>
		<tr>
			<td colspan=8>No Data Found</td>
		</tr>
		<%} else{
    	   
    	   int temp=1;
    	   int cnt=1;
    	   if(pageno!=1)
       	{
       		temp=(pageno-1)*numOfRows+1;
       	} 
    	   for(LibBookStock libBookStock:stockList){
    		   String status="n";
    		   if(savedDtList!=null&&savedDtList.size()>=temp){
    			   LibBookStockTakingDt libBookStockTakingDt=new LibBookStockTakingDt();
    			   libBookStockTakingDt=savedDtList.get(temp-1);
    			   if(libBookStockTakingDt.getStrikeCharge().equalsIgnoreCase("y")){
    				   status="y";
    				   System.out.println("status"+status);
    				   
    			   }
    		   }
    		   %>
		<tr>
			<td><input type="text" size="2" id="srNo<%=cnt %>"
				value="<%=temp %>" name="<%=SR_NO%>" readonly="readonly" /></td>
			<input type="hidden" name="bookStockId"
				value="<%=libBookStock.getId() %>" />
			<td><%= libBookStock.getBook().getBookName()%></td>
			<td><%= libBookStock.getBook().getBookNo()%></td>
			<td><%=libBookStock.getBook().getYearPublication() %></td>
			<td><%= libBookStock.getOpenBalanceQty()%></td>
			<td><%= libBookStock.getCost()%></td>
			<td><%= HMSUtil.convertDateToStringWithoutTime(libBookStock.getBook().getPurchaseDate())%></td>
			<td><%=libBookStock.getClosingStockQty() %></td>
			<td>
			<%if(status.equalsIgnoreCase("y")) {%> <input id="checkId<%=cnt %>"
				name="<%=CHARGE %>" type="checkbox" value="n" checked="checked"
				class="check" /> <%}else {%> <input id="checkId<%=cnt %>"
				name="<%=CHARGE %>" type="checkbox" value="n" class="check" /> <%} %>
			<input type="hidden" name="tempForCheackBoxes"
				id="tempForCheackBoxes<%=cnt %>" value="n" /> <input type="hidden"
				name="stockList" id="stockList" value="<%=stockList.size() %>" /></td>
		</tr>
		<%
    	   temp++;
    	   cnt++;
    	   }
    	   
       }
       %>


	</tbody>
</table>
</div>

<input type="hidden" value="" name="hiddenValueCharge"
	id="hiddenValueCharge" />
<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Previous</a> <a
	href="javascript:goNext()">Next</a> <input type="button" name="Go Page"
	type="submit" class="button" value="Go Page"
	onclick="javascript:GoPage();"> <input type="text"
	name="gopage" size="3" /> <% } %>
</div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="if(selectChaecks()){submitForm('blockStockTaking','lib?method=submitBookStockTaking&libHeaderId=<%=libHeaderId%> ');}"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('blockStockTaking');"
	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
</div>
</div>

</form>


