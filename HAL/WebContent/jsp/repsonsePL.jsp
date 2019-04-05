<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasScheduleMaster"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac" %>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>



<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasScheduleMaster> scheduleListForPnL = new ArrayList<MasScheduleMaster>();
	List<AccountMainTransac> selectedFinancialYearAccountList = new ArrayList<AccountMainTransac>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	String last2FinancialYear = "";
	String lastFinancialYear = "";
	String currentFinancialYear = "";
	String nextFinancialYear = "";
	
	
	
	if(map.get("lastFinancialYear") != null){
		lastFinancialYear = (String)map.get("lastFinancialYear");
	}
	if(map.get("last2FinancialYear") != null){
		last2FinancialYear = (String)map.get("last2FinancialYear");
	}
	
	if(map.get("currentFinancialYear") != null){
		currentFinancialYear = (String)map.get("currentFinancialYear");
		}
	
	if(map.get("nextFinancialYear")!= null){
		nextFinancialYear = (String)map.get("nextFinancialYear");
		
	}

	if (map.get("scheduleListForPnL") != null) {
		scheduleListForPnL = (List<MasScheduleMaster>) map.get("scheduleListForPnL");
		System.out.println("scheduleListForPnL :" + scheduleListForPnL);
	}
	
	if (map.get("selectedFinancialYearAccountList") != null) {
		selectedFinancialYearAccountList = (List<AccountMainTransac>) map.get("selectedFinancialYearAccountList");
		}
	%>


<div id="testDiv">
<table id ="pnlTable">
<tr>
<th scope="col">Sl.No.</th>
		<th scope="col"><center>HEAD OF ACCOUNT <br> Details of Income & Expenses</center></th>
		<th scope="col"><center>Note No. </center></th>
		<th scope="col"><center>Actuals  <br>for the year <br> <%=currentFinancialYear %><br> (Audited)<center></th>
		<th scope="col"><center>BUDGETED <br>for the year <br> <%=currentFinancialYear %><center></th>
		<th scope="col"><center>PROVISIONALS <br>for the Year <br> <%=currentFinancialYear %><center></th>
		<th scope="col"><center>BUDGETED <br>for the year <br> <%=nextFinancialYear %><center></th>
	</tr>
<tbody id="tableData">
				

				<%
					int slNo = 1;
					int scheduleCode = 0;
					String scheduleName = "";

					if (scheduleListForPnL.size() > 0) {
						
						for (MasScheduleMaster masScheduleList : scheduleListForPnL) {
							scheduleName = masScheduleList.getScheduleDescription();
							scheduleCode = masScheduleList.getScheduleCode();
							
							BigDecimal CurrentCrBalance = new BigDecimal(0.00);
							BigDecimal CurrentDrBalance = new BigDecimal(0.00);
							BigDecimal CurrentScheduleAmt = new BigDecimal(0.00);

							if (selectedFinancialYearAccountList.size() > 0) {
								for (AccountMainTransac masAccount : selectedFinancialYearAccountList) {
									if(masAccount.getAccount().getSchedule()!=null){
									if (masAccount.getAccount().getSchedule() == scheduleCode) {
										if (masAccount.getClBalanceCr() != null
												&& masAccount.getClBalanceCr() != new BigDecimal(
														0.00)) {
											CurrentCrBalance = CurrentCrBalance
													.add(masAccount.getClBalanceCr());
										}
										if (masAccount.getClBalanceDr() != null
												&& masAccount.getClBalanceDr() != new BigDecimal(
														0.00)) {
											CurrentDrBalance = CurrentDrBalance
													.add(masAccount.getClBalanceDr());
										}
										if (CurrentCrBalance
												.compareTo(CurrentDrBalance) > 0) {
											CurrentScheduleAmt = CurrentCrBalance
													.subtract(CurrentDrBalance);
										} else if (CurrentDrBalance
												.compareTo(CurrentCrBalance) > 0) {
											CurrentScheduleAmt = CurrentDrBalance
													.subtract(CurrentCrBalance);
										} else if (CurrentDrBalance
												.compareTo(CurrentCrBalance) == 0) {
											CurrentScheduleAmt = new BigDecimal(0.00);
										}
									}
								}
							}
							}
				%>
				<tr style="cursor: pointer" onclick="showScheduleDetails(this)">
				<!-- <tr style="cursor: pointer" class="responseClass" > -->
					<td><%=slNo%></td>
					<td><%=scheduleName%></td>
					<td><%=scheduleCode%></td>
					<td><%=CurrentScheduleAmt%></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<%
							
					slNo++;
							
						}
					}
				%>
	
</table>
</div>
