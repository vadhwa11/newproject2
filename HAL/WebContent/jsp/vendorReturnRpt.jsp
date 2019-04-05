
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

	<%
	
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}	
 			

 		List<StoreGrnReturnM> storeGrnReturnMList = new ArrayList<StoreGrnReturnM>();
 		
 		if (map.get("storeGrnReturnMList") != null) {
 			storeGrnReturnMList = (List<StoreIssueM>) map.get("storeGrnReturnMList");
	 	}	
 		
 		
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

<div class="titleBg">
<h2>Vendor Return Report</h2>
</div>
<form name="showIssueDetailsfrm" method="post" action="">
<div class="Block">
<label>Return No.</label>
 <select id="<%=ISSUE_RETURN_ID %>"
	name="<%=ISSUE_RETURN_ID %>">
	<option value="0">Select</option>
	<%
		for(StoreGrnReturnM StoreGrnReturnM :storeGrnReturnMList){
		%>
	<option value="<%=StoreGrnReturnM.getId()%>"><%=StoreGrnReturnM.getReturnNo()%></option>
	<%}%>
</select>

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('showIssueDetailsfrm','stores?method=printVendorReturnJsp');" />
<input type="button" name="Cancel" value="Cancel" class="button" onClick="submitForm('showIssueDetails','stores?method=showVendorReturnRptJsp');" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





