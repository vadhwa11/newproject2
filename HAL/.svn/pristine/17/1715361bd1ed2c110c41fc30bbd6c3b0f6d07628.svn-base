<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="popBloodIssue" method="post" action="">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	int rowNo=0;
	if(map.get("rowNo") != null){
		rowNo = (Integer)map.get("rowNo");
	}
	if(map.get("stockList") != null){
		stockList=(List<BloodStockDetail>)map.get("stockList");
	}
%>
<div id="contentHolder">
<% if(stockList.size() == 0){
				out.println(" No Record Found!");
							}else{%>
<div class="tableHolderPopup">
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Blood Bag No.</th>
			<th scope="col">Expiry Date</th>
			<th scope="col">Qty(ml)</th>
			<th scope="col">Select</th>
		</tr>
	</thead>
	<tbody>
		<%
  int i=1;
	for(BloodStockDetail stockDetail :stockList){
 %>
		<%
		  String bloodBagNo="";
		  Date expiryDate=new Date();
		  int qty=0;
		  int stockDetailId=0;
		  if(stockDetail.getComponent() != null){
			  bloodBagNo=stockDetail.getBloodBagNo();
			  expiryDate=stockDetail.getStockMain().getExpiryDate();
			  qty=stockDetail.getQty();
			  stockDetailId=stockDetail.getId();
 %>
		<tr>
			<td><input type="text" id="bloodBagNo<%=i %>"
				name="<%=BLOOD_BAG_NO%>" value="<%=bloodBagNo %>"
				readonly="readonly" /></td>
			<td><input type="text" id="expiryDate<%=i %>"
				name="<%=EXPIRY_DATE%>"
				value="<%= HMSUtil.convertDateToStringWithoutTime( expiryDate)%>"
				readonly="readonly" /></td>
			<td><input type="text" id="qty<%=i %>" name="<%=QUANTITY%>"
				value="<%=qty %>" readonly="readonly" /> <input type="hidden"
				id="stockDetailId<%=i %>" name="stockDetailId"
				value="<%=stockDetailId %>" readonly="readonly" /></td>
			<td><input type="radio" class="radio" value=""
				name="<%=SELECTED_RADIO %>"
				onclick="setBloodBagInParent(<%=i %>);	window.close();" /></td>
		</tr>
		<%i++;
    } %>
		<%} }%>

	</tbody>
</table>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /></div>
</div>
</form>
<script>
 function cancelForm(){
   	   window.close();
  }
   
   function setBloodBagInParent(i){
  			window.opener.document.getElementById('bloodBagNo<%=rowNo%>').value = 
				document.getElementById('bloodBagNo'+i).value;
				if(document.getElementById('stockDetailId'+i) != null){
			window.opener.document.getElementById('stockDetailId<%=rowNo%>').value = 
				document.getElementById('stockDetailId'+i).value;
		}
			window.opener.document.getElementById('qty<%=rowNo%>').value = 
				document.getElementById('qty'+i).value;
		return true;
  	}
</script>