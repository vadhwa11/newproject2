
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodStockDetail> stockDetailList = new ArrayList<BloodStockDetail>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("stockDetailList") != null){
			stockDetailList= (List<BloodStockDetail>)patientMap.get("stockDetailList");
		}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Pending for blood Discard</h6>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="pendingBloodDiscard" method="post" action=""><script
	type="text/javascript">
	  formFields = [
			[0, "bloodStockDetailId", "id"],[1,"bloodBagNo"],[2,"componentName"],[3,"componentCode"],[4,"expiryDate"], [5,"qty"]];
	  statusTd = 5;
</script></form>

</div>
</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Blood Bag No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "bloodBagNo"

data_header[1] = new Array;
data_header[1][0] = "Component Name"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "componentName"

data_header[2] = new Array;
data_header[2][0] = "Component Code"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "componentCode";

data_header[3] = new Array;
data_header[3][0] = "Expiry Date"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "expiryDate";

data_header[4] = new Array;
data_header[4][0] = "Quantity"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "qty";

data_arr = new Array();
	<%
	    int  counter=0;
		if (stockDetailList != null && stockDetailList.size() > 0)
		{ %>
	<% 	
		for(BloodStockDetail bloodStockDetail: stockDetailList){
			%>
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= bloodStockDetail.getId()%>
					<%if(bloodStockDetail.getComponent() != null){%>
					data_arr[<%= counter%>][1] = "<%= bloodStockDetail.getBloodBagNo()%>"
					data_arr[<%= counter%>][2] = "<%= bloodStockDetail.getComponent().getComponentName()%>"
					<%}else{%>
					data_arr[<%= counter%>][2] = "-"
					<%}%>
					<%if(bloodStockDetail.getComponent() != null){%>
					data_arr[<%= counter%>][3] = "<%= bloodStockDetail.getComponent().getComponentCode()%>"
					<%}else{%>
					data_arr[<%= counter%>][3] = "-"
					<%}%>
					<%if(bloodStockDetail.getStockMain() != null){%>
					data_arr[<%= counter%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(bloodStockDetail.getStockMain().getExpiryDate())%>"
					<%}else{%>
					data_arr[<%= counter%>][4] = "-"
					<%}%>
					<%if(bloodStockDetail.getQty() != null){%>
					data_arr[<%= counter%>][5] = "<%=bloodStockDetail.getQty()%>"
					<%}else{%>
					data_arr[<%= counter%>][5] = "-"
					<%}%>
					<%
						     counter++;
		}			}%>
    formName = "pendingBloodDiscard"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
		
	</script>
