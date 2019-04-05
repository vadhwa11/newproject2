
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<StoreIssueM> storeIssueMList=new ArrayList<StoreIssueM>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("storeIssueMList")!=null)
		storeIssueMList=(List<StoreIssueM>) map.get("storeIssueMList");
	System.out.println("storeIssueMList  "+storeIssueMList.size());
	%>


<div id="contentspace">
<form name="printIssue" method="post"><br />
<h2 align="left" class="style1">DEMAND,ISSUE & RECIEPT VOUCHER</h2>
<label class="bodytextB_blue">Issue No:</label> <select
	name="<%= RequestConstants.ISSUE_NO%>">
	<option value="0">Select</option>
	<%
					for (StoreIssueM storeIssueM :storeIssueMList ) {
				%>

	<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>

	<%
					}
				%>
</select> <input type="button" name="print" value="Print" class="button"
	onClick="submitForm('printIssue','stores?method=printIssueToDispensary');" />
</form>
</div>