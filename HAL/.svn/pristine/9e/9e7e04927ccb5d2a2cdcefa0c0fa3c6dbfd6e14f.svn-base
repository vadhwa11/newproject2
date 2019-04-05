<%@page import="jkt.hms.masters.business.MasScheduleMaster"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="net.sf.jasperreports.engine.util.BigDecimalUtils"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<form name="pl" method="post" action="">

	<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
		List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
		List<MasScheduleMaster> scheduleListForPnL = new ArrayList<MasScheduleMaster>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		String userName = "";
		String last2FinancialYear = "";
		String lastFinancialYear = "";
		String nextFinancialYear = "";
		String currentYearDesc = "";

		String currentFinancialYear = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		
		int fYearId = 0;
		if (map.get("fYearId") != null) {
			fYearId = (Integer) map.get("fYearId");
		}
		
		
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		
		
		
		if (map.get("masStoreFinancialList") != null) {
			masStoreFinancialList = (List<MasStoreFinancial>) map
					.get("masStoreFinancialList");
		}

		if (map.get("currentYearDesc") != null) {
			currentYearDesc = (String) map.get("currentYearDesc");
		}
		if (map.get("currentFinancialYearAccountList") != null) {
			currentFinancialYearAccountList = (List<AccountMainTransac>) map
					.get("currentFinancialYearAccountList");
		}
		if (map.get("lastFinancialYear") != null) {
			lastFinancialYear = (String) map.get("lastFinancialYear");
		}
		if (map.get("last2FinancialYear") != null) {
			last2FinancialYear = (String) map.get("last2FinancialYear");
		}

		if (map.get("currentFinancialYear") != null) {
			currentFinancialYear = (String) map.get("currentFinancialYear");
		}

		if (map.get("nextFinancialYear") != null) {
			nextFinancialYear = (String) map.get("nextFinancialYear");
		}

		if (map.get("scheduleListForPnL") != null) {
			scheduleListForPnL = (List<MasScheduleMaster>) map
					.get("scheduleListForPnL");

		}

		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
	%>
	<h4>
		<span><%=message%></span>
	</h4>
	<%
		}
	%>


	<div class="clear"></div>
	<div class="paddingTop5"></div>

	<div class="clear"></div>
	<div class="titleBg">
	<h4>Budget Information</h4>
	</div>

<div class="Block">
	<label>Year <span>*</span></label> 
	<select name="yearId" id="yearId" 
		validate="Year,string,no" 
		onchange="submitProtoAjaxWithDivName('pl','/hms/hms/account?method=showStatementPLACJsp&year='+this.value+'&formName=pl','testDiv');">
		<option value="0">Select</option>

		<%
			
			if (masStoreFinancialList.size() > 0) {
				for (MasStoreFinancial f : masStoreFinancialList) {
					if (fYearId == f.getId()) {
		%>
		<option value="<%=f.getId()%>" selected="selected"><%=f.getFinancialYear()%></option>
		
		<%
			} else {
		%>
		<option value="<%=f.getId()%>"><%=f.getFinancialYear()%></option>
		<%
	
			}
				}
			}
		%>
	</select>


	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div id="testDiv">
		<table id ="pnlTable">
			<tr>
				<th scope="col">Sl.No.</th>

				<th scope="col"><center>
						HEAD OF ACCOUNT <br> Details of Income & Expenses
					</center></th>
				<th scope="col"><center>Note No.</center></th>
				<th scope="col"><center>
						ACTUALS <br>for the year <br>
						<%=currentFinancialYear%><br> (Audited)
						<center></th>
				<th scope="col"><center>
						BUDGETED <br>for the year <br>
						<%=currentFinancialYear%><center></th>
				<th scope="col"><center>
						PROVISIONALS <br>for the Year <br>
						<%=currentFinancialYear%><center></th>
				<th scope="col"><center>
						BUDGETED <br>for the year <br><%=nextFinancialYear%><center></th>
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
							
							BigDecimal currentCrBalance = new BigDecimal(0.00);
							BigDecimal currentDrBalance = new BigDecimal(0.00);
							BigDecimal currentScheduleAmt = new BigDecimal(0.00);

							if (currentFinancialYearAccountList.size() > 0) {
								for (AccountMainTransac masAccount : currentFinancialYearAccountList) {
									if ((masAccount.getAccount().getSchedule()) != null && masAccount.getAccount().getSchedule() == scheduleCode  ) {
										
										if (masAccount.getClBalanceCr() != null
												&& masAccount.getClBalanceCr() != new BigDecimal(
														0.00)) {
											currentCrBalance = currentCrBalance
													.add(masAccount.getClBalanceCr());
										}
										if (masAccount.getClBalanceDr() != null
												&& masAccount.getClBalanceDr() != new BigDecimal(
														0.00)) {
											currentDrBalance = currentDrBalance
													.add(masAccount.getClBalanceDr());
										}
										if (currentCrBalance
												.compareTo(currentDrBalance) > 0) {
											currentScheduleAmt = currentCrBalance
													.subtract(currentDrBalance);
										} else if (currentDrBalance
												.compareTo(currentCrBalance) > 0) {
											currentScheduleAmt = currentDrBalance
													.subtract(currentCrBalance);
										} else if (currentDrBalance
												.compareTo(currentCrBalance) == 0) {
											currentScheduleAmt = new BigDecimal(0.00);
										}
									}
								}
							}
							
							
							
				%>
				<tr style="cursor: pointer" onclick="showScheduleDetails(this)">
					<td><%=slNo%></td>
					<td><%=scheduleName%></td>
					<td><%=scheduleCode%></td>
					<td><%=currentScheduleAmt%></td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<%
							
					slNo++;
							
						}
					}
				%>
			
		</table>
	</div>
	
	<div class="clear"></div>
<div class="paddingTop5"></div>

	<div class="clear"></div>
    <!-- <input type="button" class="buttonBig" value="Export To Excel" onclick="generateReport()"/> -->
	<input type="hidden" id="pageType" name="pageType" value="ProfitLoss" />
	<div class="clear"></div>
	<div class="clear"></div>

</div>

</form>



<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script>
function generateReport() {
	var e = document.getElementById("yearId");
	var fyearId = e.options[e.selectedIndex].value; 
	if(fyearId == 0){
		alert("Please select the year");
	}else{
		submitForm('pl','account?method=generateProfitAndLossAccountStatement&locationId=<%=locationId%>&fYearId='+fyearId); 
	}
}

function showScheduleDetails(selectedRow) {
	var i = selectedRow.rowIndex;
	var tblScheduleName = document.getElementById("pnlTable").rows[i].cells[1].innerHTML;
	var tblScheduleCode = document.getElementById("pnlTable").rows[i].cells[2].innerHTML;
	var e = document.getElementById("yearId");
	var fyearId = e.options[e.selectedIndex].value; 
	var fyearDesc = e.options[e.selectedIndex].text; 	
	var yearDesc = fyearDesc.split('-')[0];
	
	if(fyearId == 0){
		alert("Please select the year");
	}else{
		 submitForm('pl','account?method=displayScheduleDetailForProfitAndLoss&schedule='+tblScheduleCode+'&currentYearDesc='+yearDesc+'&financialYear='+fyearId+'&particular='+tblScheduleName+'&pageType=ProfitLoss'); 
	}
}


</script>

