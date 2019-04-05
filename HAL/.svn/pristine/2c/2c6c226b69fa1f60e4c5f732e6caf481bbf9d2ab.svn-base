
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="java.util.ArrayList"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasStoreBudget> budgetStatusList = new ArrayList<MasStoreBudget>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("budgetStatusList") != null){
	budgetStatusList = (List<MasStoreBudget>)map.get("budgetStatusList");
}
%>
<form name="attach" method="post">
<div class="titleBg">
<h2>Budget Status</h2>
</div>
<div class="clear"></div>
<%
BigDecimal totalAllocatedAmount  = new BigDecimal(0);
BigDecimal poCommitedAmount = new BigDecimal(0);
BigDecimal balForFreshCommitments = new BigDecimal(0);


if(budgetStatusList.size() > 0){
	for(MasStoreBudget obj : budgetStatusList){
		try
		{
			totalAllocatedAmount = (obj.getTotalAllocatedAmount());
		}
		catch(Exception e)
		{
			totalAllocatedAmount = new BigDecimal(0);
		}
		
		try
		{
			poCommitedAmount =(obj.getPoComittedAmount());
		}
		catch(Exception e)
		{
			poCommitedAmount  = new BigDecimal(0);
		}
		try
		{
			balForFreshCommitments = totalAllocatedAmount.subtract(poCommitedAmount);
		}
		catch(Exception e)
		{
			balForFreshCommitments  = totalAllocatedAmount;
		}
%>
<div class="Block">
<label>Budget Code Head</label>
<% if(obj.getBudgetCode() != null){ %> 
<label class="vlaue"><%=obj.getBudgetCode()%></label>
<%} %> 
<div class="clear"></div>

<label>Total allocation under the code head</label>
<label class="value"><%=totalAllocatedAmount%></label>
<div class="clear"></div>
<label>Balance available for fresh commitments</label>
<label class="value"><%=balForFreshCommitments%></label> 
<div class="clear"></div>
<label >Commitments already made during the current financial year:</label>
<label class="value"><%=poCommitedAmount%></label>
<div class="clear"></div>
<label >Bills in process</label>
<!-- -
<% if(obj.getCrvComittedAmount() != null){ %> <label class="value"><%=obj.getCrvComittedAmount()%></label>
<%} %> --> 
<div class="clear"></div>
<label >Amount Committed in this Supply Order</label>
<% if(obj.getCrvComittedAmount() != null){ %> <label class="value"><%=obj.getCrvComittedAmount()%></label>
<%} %>
	<div class="clear"></div>
	 
	
	<label >Amount balance after this supply order (3-6)</label>
	<label class="value"><%=obj.getBalanceAmount() %></label>
	
	 <%} }%>
<div id="edited"></div>
<label>&nbsp;</label>
</div>
<input type="button" name="close" value="Close" class="button" onClick="window.close();" />
</form>
