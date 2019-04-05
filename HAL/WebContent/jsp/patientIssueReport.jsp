<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreOpPatientIssueM> storeOpPatientIssueM = new ArrayList<StoreOpPatientIssueM>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("storeOpPatientIssueM") != null) {
		storeOpPatientIssueM = (List<StoreOpPatientIssueM>) map.get("storeOpPatientIssueM");
	}
%>
<form name="patientIssueReport"  method="post"	action="">
<div class="titleBg">
<h2>Patient Issue REPORT</h2>
</div>
<div class="panelbar">
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Disp Issue No. </label> <select name="issueNo"
	validate="Issue No,String,yes">
	<option value="0">Select</option>
	<%
		for (StoreOpPatientIssueM storePatientIssueM : storeOpPatientIssueM) {
	%>
	<option value="<%=storePatientIssueM.getIssueNo()%>"><%=storePatientIssueM.getIssueNo()%></option>
	<%
		}
	%>
</select> 
</div>
<div class="clear" ></div>
<div class="division"></div>
<div class="clear" ></div>
<input type="button" name="add" id="addbutton" value="Print Report" class="button" onClick="submitForm('patientIssueReport','stores?method=generateOpdPatientIssueReport','checkTargetForYes');checkTargetForNo();"	accesskey="g" tabindex=1 />
<div class="clear" ></div>
<div class="division"></div>
<div class="clear" ></div>
</div>
</form>