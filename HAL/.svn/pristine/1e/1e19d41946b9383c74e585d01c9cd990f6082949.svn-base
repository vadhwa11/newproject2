<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.StoreAmcM"%>
<%@page import="jkt.hms.masters.business.StoreAmcT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>

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
	String sDate=date+"/"+month1+"/"+year1;
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<%
    String crvNo=null;
    Map<String,Object> map = new HashMap<String,Object>();
  	StoreAmcM storeAmcM = null; 
	StoreGrnT storeGrnT =null;
	StoreAmcT storeAmcT = null;
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StoreAmcT> amcTDetailsList = new ArrayList<StoreAmcT>();
    if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	
   	
    if(map.get("StoreGrnT")!=null){
    	storeGrnT = (StoreGrnT) map.get("StoreGrnT");
       System.out.println("storeGrnT>>> in jsp"+storeGrnT.getGrnMaster().getGrnNo());     
       
       
    }	
    if(map.get("storeAmcM")!=null){
   storeAmcM=(StoreAmcM)map.get("storeAmcM");
	
    }
   	
    if (storeAmcM != null){
    crvNo=storeAmcM.getCrvNo();
    }
    else if(storeGrnT!= null)
    {
		crvNo=storeGrnT.getGrnMaster().getGrnNo();
		
    }	
    }
    %>


<div id=crvDiv>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="50%"><label class="bodytextBNoWidth">CRV No :</label></td>
		<td width="50%">
		<%if(crvNo!="" && crvNo!=null) { %> <input type="text"
			name=<%=RequestConstants.CRV%> value="<%=crvNo %>"
			class="textbox_size20" readonly style="width: 200px" /> <%} else { %>
		<input type="text" name=<%=RequestConstants.CRV%> value=""
			class="textbox_size20" style="width: 200px" /> <%} %>
		</td>
	</tr>
</table>



</div>