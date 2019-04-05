<%@ page import="java.util.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

		<%
		
		Calendar calendar=Calendar.getInstance();
		
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		
		String date=String.valueOf(calendar.get(Calendar.DATE));
		
		int year=calendar.get(calendar.YEAR);
		
		if(month.length()<2){
		
		month="0"+month;
		
		}
		
		if(date.length()<2){
		
		date="0"+date;
		
		}
		
		
		%>
		
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
		</script>
		
		
		
		<%
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		
		if (request.getAttribute("map") != null) {
		
		map = (Map<String,Object>) request.getAttribute("map");
		
		}
		
		
		if (map.get("dgOrderhdList") != null){
		
			dgOrderhdList =(List)map.get("dgOrderhdList");
		
		}
		
		String opOrString = "";
		
		if(map.get("opOrString") != null){
		
		opOrString = (String)map.get("opOrString");
		
		}
		
		%>
		
		<div class="clear"></div>
		<div class="clear"></div>
		<h4>Diagnostics Details</h4>
		<div class="clear"></div>
		<%
		if (dgOrderhdList != null && dgOrderhdList.size() > 0)
		{ 
		%>
		<div class="clear"></div>
		
		<div class="tableHolderAuto">
<table width="70%" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
		<tr>
		
		<th scope="col">Order No.</th>
		
		<th scope="col">Order Date</th>
		
		<th scope="col">Order Time</th>
		<th scope="col">Doctor Name</th>
		</tr>
		<tbody id="tableData">
		<%
		for(DgOrderhd dgOrderhd: dgOrderhdList){
		%>
		<tr style="cursor:pointer;" onclick="submitProtoAjaxWithDivName('patientAndAdDetails','/hms/hms/lab?method=viewAllTestForOrderNo&dgOrderHdId=<%=dgOrderhd.getId() %>','chargeDiv');">
		
		<td><%=dgOrderhd.getOrderNo() %></td>
		
		<td><%=HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate()) %></td>
		
		<td><%=dgOrderhd.getOrderTime() %></td>
		
		<td><%=dgOrderhd.getPrescribedBy().getFirstName()+" "+dgOrderhd.getPrescribedBy().getMiddleName()+" "+dgOrderhd.getPrescribedBy().getLastName() %></td>
		
		</tr>
		
		<%} %>
		
		</tbody>
		
		</table>
		
		
		<div id="chargeDiv">
		
		</div>
		
		<%}else{ %> 
		
		<h6>No Diagnostics Records Found!</h6>
		
		<%}%>
