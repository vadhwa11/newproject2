<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
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
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<StoreGrnT> storeGrnT=new ArrayList<StoreGrnT>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	List<StoreItemBatchStock> batchStockList=new ArrayList<StoreItemBatchStock>();
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	/* if(map.get("storeGrnT")!=null){
		storeGrnT=(List<StoreGrnT>)map.get("storeGrnT");
	} */
	if(map.get("batchStockList")!=null){
		batchStockList=(List<StoreItemBatchStock>)map.get("batchStockList");
	}
	
	%>
<div class="titleBg">
<h2>Pending List for enter equipment detail</h2>
</div>
<div class="clear"></div>
<!-- thread search menu -->
<h4><%=message %></h4>
<form name="searchPanel" method="post">
<div class="Block" >
<div class="clear"></div>
<%-- <label>GRN Date </label>
<input type="text" name="grnDate" validate="GRN Date,string,yes"	value="<%=currentDate%>" readonly="readonly" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.grnDate,event);" />
<label>GRN No. </label>
<input type="text" name="grnNo" value=""  maxlength="20"	tabindex=1   id="grnNo" /> --%>
<label>Equipment Name </label>
<input type="text" name="equipmentName" value="" maxlength="30"	tabindex=1   id="equipmentName"/>
<div class="clear"></div>
<div id="ac6update" class="autocomplete" style="display: none;"></div>
	<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter('equipmentName','ac6update','procurement?method=getItemListForEquipDetail',{parameters:'requiredField=equipmentName'});
		</script>
<div class="clear"></div>
<!-- <a href="#" onclick="submitForm('searchPanel', 'procurement?method=showEquipmentDetailsMasterJsp')">Equipment Details</a> -->

<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('searchPanel', 'procurement?method=showPendingListForEnterEquipmentDetailJsp')" />
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<h4>Item Details</h4>	
<div class="cmntable">
<%if(batchStockList.size()>0){ %>
<table>
	<thead>
		<tr>
			<th>Sl No. </th>
			<th>Date</th>
			<th>Equipment Code</th>
			<th>Equipment Name</th>
			 <th>Serial No.</th>
		</tr>
	</thead>
	<tbody>
	<% int counter=0;
	
	for(StoreItemBatchStock storeItemBatchStock:batchStockList){ %>
	<form name="pendingList<%=counter %>" method="post">
		<input type="hidden" name="requestId" value="<%=storeItemBatchStock.getId() %>" />
		<tr onclick="submitForm('pendingList<%=counter %>', 'fm?method=showEquipmentDetailJsp&batchStockId=<%=storeItemBatchStock.getId()%>&itemId=<%=storeItemBatchStock.getItem().getId()%>')" style="cursor: pointer;">  <!-- Chnaged By Amit das 29-03-2016 -->
			<td><%=counter+1 %></td>
			<td><%=storeItemBatchStock.getOpeningBalanceDate()!=null?HMSUtil.changeDateToddMMyyyy(storeItemBatchStock.getOpeningBalanceDate()):""%></td>
			<td><%=storeItemBatchStock.getItem().getPvmsNo() %></td>
			<td><%=storeItemBatchStock.getItem().getNomenclature() %></td>
			 <td><%=storeItemBatchStock.getBatchNo()%></td> 
			</tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
		</form>
			<%++counter;} %>
			</tbody>
</table>
<%}else{ %>
No Records Available. 
<%} %>
</div>


<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>
<script>
function test(){
	var itemNameSearch1 =  document.getElementById('equipmentName1').value;
    var index1 = itemNameSearch1.lastIndexOf("[");
    var index2 = itemNameSearch1.lastIndexOf("]");
    index1++;
    var itemNameSearch = itemNameSearch1.substring(0,index1-1);
    var itemId = itemNameSearch1.substring(index1,index2);
   /*  if(itemId !="")
    document.getElementById("pvmsNo").value=itemId;
    else
    	document.getElementById("pvmsNo").value=0;
   // document.physicalStock.method="post"; */
//	submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
	var counter = document.getElementById('counter').value;
	if(itemNameSearch != ""){
		for(var i =1;i<=counter;i++){
			if(document.getElementById('equipmentName'+i).value == itemNameSearch){
				document.getElementById('equipmentName'+i).focus();
				break;
			}
		}
	}
}



</script>

