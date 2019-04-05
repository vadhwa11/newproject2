<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
	
	
<%
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
		}
		List<Object[]> rcList=new ArrayList<Object[]>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if(map.get("rcList")!=null){
			rcList = (List<Object[]>)map.get("rcList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
		String fromDate = currentDate;
		String toDate = currentDate;
		if(map.get("fromDate")!=null)
			fromDate = (String)map.get("fromDate");
		if(map.get("toDate")!=null) 
			toDate = (String)map.get("toDate");
		String msg = "";
		if(map.get("msg")!=null){
			msg = (String)map.get("msg");
		}
		if(map.get("supplierList")!=null){
			supplierList = (List<MasStoreSupplier>)map.get("supplierList");
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message="";
		if(map.get("message")!=null)
		{
			message=(String)map.get("message");
		}
	%>
<script type="text/javascript">
serverdate = '<%=currentDate%>'
</script>
<div class="clear"></div>
<%if(msg!=""){if(msg=="Try Again!"){out.write("<div class='alertDiv'>"+msg+"</div>");}else{out.write("<div class='successDiv'>"+msg+"</div>");}} %>
<div class="clear"></div>
<div class="titleBg">
<h4><%=message %></h4>
<h2>Waiting For Rate Contract</h2>
</div>
<div class="clear"></div>

<form name="search" id="facPriscription" method="post" action="">
<input type="hidden" name="employeeId" value="" />
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>From Date</label>
<input id="fromDate" class="calDate" name="fromDate" readonly="readonly" value="<%=fromDate %>" tabindex="1" maxlength="30" type="text">
<img id="calendar" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=fromDate %>',document.search.fromDate, event)" width="16" border="0" height="16">
<label>To Date</label>
<input id="toDate" class="calDate" name="toDate" readonly="readonly" value="<%=toDate %>" tabindex="1" maxlength="30" type="text">
<img id="calendar" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=toDate %>',document.search.toDate, event)" width="16" border="0" height="16">
</div>
<div class="clear"></div>
<input class="buttonSm" name="Button2" value="Search" onclick="removeValidation();submitForm('search','/hms/hms/stores?method=waitingForRateContractJsp');" type="button" />
<!-- <input class="buttonSm" name="Button2" value="Print" onclick="removeValidation();submitForm('search','/hms/hms/stores?method=printForRateContractJsp');" type="button" /> -->


<div class="clear"></div>
<%
int count = 1;
if(rcList.size()>0){ %>
<h4>Rate Contract List</h4>
<table>
		<thead><tr><th>S.No.</th><th>MAT Code</th><th>Nomenclature</th><th>RC Quantity</th></tr></thead>
		<tbody>
		<%
		String status="N/A";
		for(Object[] rc:rcList){ 
			
		%>
			<tr><td><input type="hidden" name="itemId<%=count %>" id="itemId<%=count %>" value="<%=rc[0]%>"/><%=count %></td>
			<td><%=rc[1] %></td>
			<td><%=rc[2]%></td>
			<td><input type="hidden" name="requestedQty<%=count %>" id="requestedQty<%=count %>" value="<%=rc[3]%>"/>
			<%=rc[3]%></td>
			</tr>
		<%count++;} %>
		</tbody>
</table>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<label>Vendor<span>*</span></label>
<select id="supplierId" name="supplierId" tabindex="1"  validate="Vendor,string,yes"> 
<option value="0">Select</option>
<%for(MasStoreSupplier supplier: supplierList)
	{
	%>
	<option value="<%=supplier.getId()%>"><%=supplier.getSupplierName().trim()%></option>
	<%
	}%>
</select>
<input class="buttonSm" value="Submit" onclick="submitForm('search','/hms/hms/stores?method=submitRCWaitingList');" type="button" />
	</div>
<%}else{out.write("<span>RC Not Available!</span>");} %>
<input type="hidden" name="count" id="count" value="<%=(count-1)%>"/>


	<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script type="text/javascript">
function openPopupWindow(id)
{
	var url="/hms/hms/stores?method=indentTrackingHistoryJsp&indentId="+id;
	newwindow=window.open(url,'name','top=0, left=5, height=650,width=1010,status=1,scrollbars=yes');
}
function removeValidation()
{
	if(document.getElementById("supplierId")!=null)
		{
		document.getElementById("supplierId").setAttribute("validate", "Supplier,string,no");
		}
	
	
	}
</script>
