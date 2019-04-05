
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreWorkOrderM> workOrderList = new ArrayList<StoreWorkOrderM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("workOrderList")!=null){
		workOrderList =(List) map.get("workOrderList");
		
	}
%>
<form name="workOrderRpt" id=grnReport method="post" action=""	target="_blank">
<div class="titleBg">
<h2 >WORK ORDER REPORT</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>WORK ORDER No : </label> 
<select name="<%=WORK_ORDER_NO%>">	<option value="0">Select</option>
	<%	for (StoreWorkOrderM storeWorkOrderM : workOrderList) {	%>
	<option value="<%=storeWorkOrderM.getWorkOrderNo()%>"><%=storeWorkOrderM.getWorkOrderNo() %></option>
	<%	}	%>
</select> 
<input type="button" name="add" id="addbutton" value="Print" class="button"
	onClick="submitForm('workOrderRpt','neStores?method=generateWorkOrderReport');"	accesskey="g" tabindex=1 />
</div>

</form>
