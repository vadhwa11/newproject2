<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String,Object> map = new HashMap<String,Object>();	
    if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
    String pvmsNo="";
    pvmsNo=(String)map.get("pvmsNo");
	List<StoreItemBatchStock> serialNoList= new ArrayList<StoreItemBatchStock>();
	if(map.get("serialNoList")!=null)
		serialNoList = (List) map.get("serialNoList");
	String serialNo="";
	serialNo=(String)map.get("serialNo");
System.out.println("serial NO>>>>>in search jsp"+serialNo);
%>

<div id="pvmsDiv"><label class="bodytextB2">PVMS/NIV :</label> <input
	type="text" name=<%=RequestConstants.PVMS_NO%> class="textbox_size20"
	value="<%=pvmsNo%>" readonly /> <label class="bodytextB2">Serial
No :</label> <select name="<%=RequestConstants.SERIAL_NUMBER%>"
	onchange="submitProtoAjaxDynamic('amcMaintenance','neStores?method=getSerialNoDetail',amcserialDetailDiv);">
	<option value="">Select</option>
	<%
			  	for (StoreItemBatchStock storeItemBatchStock:serialNoList ){
			  	
		  	 %>
	<option value="<%=storeItemBatchStock.getBatchNo()%>"><%=storeItemBatchStock.getBatchNo()%></option>
	<% } %>
</select> <%
                   if (serialNo !="") {
                %> <script>
                 	   document.amcMaintenance.<%=RequestConstants.SERIAL_NUMBER %>.value =<%=serialNo%>
    			</script> <%
                 }
                 %>
</div>
