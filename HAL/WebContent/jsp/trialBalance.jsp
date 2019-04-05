<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("accountGroupList")!= null){
		accountGroupList = (List<FaMasAccountGroup>)map.get("accountGroupList");
	}
	if(map.get("accountSubGroupList")!= null){
		accountSubGroupList = (List<FaMasAccountSubGroup>)map.get("accountSubGroupList");
	}
	if(map.get("accountList")!= null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
%>


<form name="trialBalance" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Trial Balance</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Group</label>
<%-- <select id="accountTypeId"  name="accountType"  onchange="displayTrialBalanceAccountTypeWise(this.value);">--%>
<select id="accountTypeId"  name="accountType"  >
	<option value="0">Select</option>
	 <option value="group">Group Wise</option>
	<option value="subgroup">SubGroup Wise</option> 
	<option value="account">Ledger Wise</option> 
	<!-- <option value="subaccount">Account Wise</option> -->
	
</select>

<div class="clear"></div>
<input type="hidden" name="accountName" id="accountNameId" value=""/>
<label><span>*</span>From Date:</label>
<input type="text" name="<%=FROM_DATE %>" id="fromDate" value="" class="calDate" tabindex=1 readonly="readonly" validate="From Date ,date,yes" MAXLENGTH="30" />

<label><span>*</span>To Date:</label>
<%-- <input type="text" name="<%=TO_DATE %>" id="toDate" value="<%= df.format(new java.util.Date()) %>" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="30" /> --%>
<input type="text" name="<%=TO_DATE %>" id="toDate" value="" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="30" />

<div class="clear"></div>
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('trialBalance','account?method=getTrialBalance');" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('trialBalance','account?method=printTrialReport');" accesskey="a" tabindex=1 />
</div>
<%-- 
<div id="testDiv">


</div>
--%>
<script type="text/javascript">
 	function displayTrialBalanceAccountTypeWise(val){
 	 	
 		submitForm('trialBalance','account?method=getTrialBalance&val='+val);
 		
 	}

</script>
</form>