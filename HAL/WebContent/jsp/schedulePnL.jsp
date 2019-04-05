<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="net.sf.jasperreports.engine.util.BigDecimalUtils"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac"%>


<form name="schedulePnL" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<AccountMainTransac> transactionList = new ArrayList<AccountMainTransac>();
	List<AccountMainTransac> transactionListForPreviousYear = new ArrayList<AccountMainTransac>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	String particular = "";
	String locationId = "";
	String BalanceSheetType="";
	String pageType="";
	int schedule = 0;
	int currentYearDesc = 0;
	int lastYearDesc = 0;
	Date fromDate = null;
	Date toDate = null;
	
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("transactionList") != null){
		transactionList = (List<AccountMainTransac>)map.get("transactionList");
	}
	
	if(map.get("transactionListForPreviousYear") != null){
		transactionListForPreviousYear = (List<AccountMainTransac>)map.get("transactionListForPreviousYear");
	}
	
	
	if(map.get("yearDesc") != null){
		lastYearDesc = (Integer)map.get("yearDesc");
	}
	
	if(map.get("currentYearDesc") != null){
		currentYearDesc = (Integer)map.get("currentYearDesc");
		System.out.println("currentYearDesc   ==" + currentYearDesc);
	}
	
	
	if(map.get("particular") != null){
		particular = (String)map.get("particular");
	}
	if(map.get("schedule") != null){
		schedule = (Integer)map.get("schedule");
	}
		
	if(map.get("locationId") != null){
		locationId = (String)map.get("locationId");
		
	}
	
	if(map.get("fromDate") != null){
		fromDate = (Date)map.get("fromDate");
		
	}
	System.out.println("fdate:" +fromDate);
	if(map.get("toDate") != null){
		toDate = (Date)map.get("toDate");
		
	}
	System.out.println("ftoDate:" +toDate);
	
	
	if(map.get("pageType") != null){
		pageType = (String)map.get("pageType");
		
	}
	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
	<h4><span><%=message %></span></h4>
	<%}
%>


<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4><%=schedule+")  "+ particular %></h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table>
<tr>
		<th scope="col">Particulars</th>
		<th scope="col">For the Year ended 31st March <%=currentYearDesc %>(in Rs.)</th>
		<th scope="col">For the Year ended 31st March <%=lastYearDesc %>(in Rs.)</th>
	</tr>
	<%
	BigDecimal currentCrBalance = new BigDecimal(0.0);
	BigDecimal currentDrBalance = new BigDecimal(0.0);
	BigDecimal currentScheduleAmt = new BigDecimal(0.0);
	BigDecimal lastCrBalance = new BigDecimal(0.0);
	BigDecimal lastDrBalance = new BigDecimal(0.0);
	BigDecimal lastScheduleAmt = new BigDecimal(0.0);
	if(transactionList.size()>0){
		for(AccountMainTransac masAccount : transactionList){
	%>
	<tr  style="cursor: pointer" onclick ="submitForm('schedulePnL','account?method=displayLedgerBookForPnLStatement&accountId=<%=masAccount.getAccount().getId()%>&fromDate=<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>&toDate=<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>&accountName=<%=masAccount.getAccount().getAccDesc() %>')">
	<td><%=masAccount.getAccount().getAccDesc() %></td>
	<%
		if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
			currentCrBalance = masAccount.getClBalanceCr();
		}
		if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
			currentDrBalance = masAccount.getClBalanceDr();
		}
		if(currentCrBalance.compareTo(currentDrBalance)>0){
			currentScheduleAmt = currentCrBalance.subtract(currentDrBalance);
		}else if(currentDrBalance.compareTo(currentCrBalance)>0){
			currentScheduleAmt = currentDrBalance.subtract(currentCrBalance);
		}else if(currentDrBalance.compareTo(currentCrBalance)==0){
			currentScheduleAmt =new BigDecimal(0.00);
		}
	
	%>
	<td><%=currentScheduleAmt %></td>
	
	<%
	if(transactionListForPreviousYear.size()>0){
		for(AccountMainTransac account : transactionListForPreviousYear){
		if(account.getClBalanceCr() != null && account.getClBalanceCr() != new BigDecimal(0.00)){
			lastCrBalance = account.getClBalanceCr();
		}
		if(account.getClBalanceDr() != null && account.getClBalanceDr() != new BigDecimal(0.00)){
			lastDrBalance = account.getClBalanceDr();
		}
		if(lastCrBalance.compareTo(lastDrBalance)>0){
			lastScheduleAmt = lastCrBalance.subtract(lastDrBalance);
		}else if(lastDrBalance.compareTo(lastCrBalance)>0){
			lastScheduleAmt = lastDrBalance.subtract(lastCrBalance);
		}else if(lastDrBalance.compareTo(lastCrBalance)==0){
			lastScheduleAmt =new BigDecimal(0.00);
		}
	
	%>
	<td><%=lastScheduleAmt %></td>
	<%}}else{ %>
	<td>0</td>
	<%} %>
	</tr>
	<%}} %>
	
</table>
<input type="button" tabindex="1" class="button" value="Back" onclick="backToList(); return false;"/>
<div class="clear" style="padding-top: 15px;"></div>

<input type="hidden" id="schedule" name="schedule" value="<%out.print(schedule);%>" />
<input type="hidden" id="currentYearDesc" name="currentYearDesc" value="<%out.print(currentYearDesc);%>" />
<input type="hidden" id="lastYearDesc" name="lastYearDesc" value="<%out.print(lastYearDesc);%>" />
<input type="hidden" id="particular" name="particular" value="<%out.print(particular);%>" />
<input type="hidden" id="locationIdParameter" name="locationIdParameter" value="<%out.print(locationId);%>" />
<input type="hidden" id="BalanceSheetTypeParameter" name="BalanceSheetTypeParameter" value="<%out.print(BalanceSheetType);%>" />
<input type="hidden" id="pageType" name="pageType" value="<%out.print(pageType);%>" />




<div class="clear"></div>
<div class="clear"></div>




</form>

<script language="javascript">
function backToList()
{
	var pageType = '<%out.print(pageType);%>';
	
	if(pageType == 'BalanceSheet')
		{
			
		var locationURL = "account?method=showBalanceSheet&appId=A500";
		submitForm('schedule',locationURL);
		}
	if(pageType == 'ProfitLoss')
		{
		var locationURL = "account?method=showStatementProfitAndLossAcJsp&appId=A703";
		submitForm('schedulePnL',locationURL);
		}
	
	
}
</script>