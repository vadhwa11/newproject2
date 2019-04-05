<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="net.sf.jasperreports.engine.util.BigDecimalUtils"%>

<%@page import="jkt.hms.masters.business.AccountMainTransac"%><script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<form name="balanceSheet" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
	List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
	List<Object[]> centreList = new ArrayList<Object[]>();	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	int lastYearDesc = 0;
	int currentYearDesc = 0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("currentFinancialYearAccountList") != null){
		currentFinancialYearAccountList = (List<AccountMainTransac>)map.get("currentFinancialYearAccountList");
	}
	if(map.get("lastFinancialYearAccountList") != null){
		lastFinancialYearAccountList = (List<AccountMainTransac>)map.get("lastFinancialYearAccountList");
	}
	if(map.get("lastYearDesc") != null){
		lastYearDesc = (Integer)map.get("lastYearDesc");
	}
	if(map.get("currentYearDesc") != null){
		currentYearDesc = (Integer)map.get("currentYearDesc");
	}
	if(map.get("centreList") != null)
	 {
		 centreList =  (List<Object[]>)map.get("centreList");	  
		   
	  }	
	Box box = HMSUtil.getBox(request);
	String message = "";
	if(map.get("message") != null){
	message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
	
	
	 String Type ="";
	  String locationId ="0";
	  if(request.getParameter("Type") != null)
	  {
		  Type = request.getParameter("Type");
	  }
	  
	  if(request.getParameter("locationId") != null)
	  {
		  locationId = request.getParameter("locationId");
		  
	  }

%>


<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4>Balance Sheet</h4>
</div>
<div class="Block">
<%
  
  String unitType="";
  if(session.getAttribute("unitType") != null)
  {
	  unitType = (String)session.getAttribute("unitType");
  }
  
  if(unitType.equalsIgnoreCase("HO"))
  {
	  
	 
	  %>
	  
	  <table>
<tr>
<td><input type="radio" id="rdConsolidated" name="rdType" onclick="checkBalanceSheetType();"  <% if(Type.equalsIgnoreCase("All")){%>checked<%} %> /> <b>Consolidated</b></td>
<td><input type="radio" id="rdLocationWise" name="rdType" onclick="checkBalanceSheetType();" <% if(Type.equalsIgnoreCase("Filter")){%>checked<%} %> /> <b>Location Wise</b></td>


<div id="divLocation" style="display:none;">
<td>
<label>Select Centre <span>*</span></label>
		<select name ="ddlLocation" id="ddlLocation" validate="Centre,string,no"  onchange="showBalanceSheet('FILTER');">
		<option value="0">Select</option>
		
			<%
			    
				if(centreList.size()>0)
				{
					for(Object[] list : centreList)
					{
						%>
							<option value="<%=list[0]%>" <% if(locationId.equalsIgnoreCase(list[0].toString())){%>selected<%} %>><%=list[1]%></option>
						<%
					}
				}
			%> 
		</select>
</td>
</div>

</tr>
</table>
		
	 <%
	}
%>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table>
<tr>
		<th scope="col">Particulars</th>
		<th scope="col">Note No.</th>
		<th scope="col">For the Year ended 31st March <%=currentYearDesc %>(in Rs.)</th>
		<th scope="col">For the Year ended 31st March <%=lastYearDesc %>(in Rs.)</th>
	</tr>
	<%
	//------------------------------------for current Year Balance-----------------------------------------------------//
	BigDecimal currentCrBalance3 = new BigDecimal(0.00);
	BigDecimal currentDrBalance3 = new BigDecimal(0.00);
	BigDecimal currentCrBalance4 = new BigDecimal(0.00);
	BigDecimal currentDrBalance4 = new BigDecimal(0.00);
	BigDecimal currentCrBalance5 = new BigDecimal(0.00);
	BigDecimal currentDrBalance5 = new BigDecimal(0.00);
	BigDecimal currentCrBalance6 = new BigDecimal(0.00);
	BigDecimal currentDrBalance6 = new BigDecimal(0.00);
	BigDecimal currentCrBalance7 = new BigDecimal(0.00);
	BigDecimal currentDrBalance7 = new BigDecimal(0.00);
	BigDecimal currentCrBalance8 = new BigDecimal(0.00);
	BigDecimal currentDrBalance8 = new BigDecimal(0.00);
	BigDecimal currentCrBalance9 = new BigDecimal(0.00);
	BigDecimal currentDrBalance9 = new BigDecimal(0.00);
	BigDecimal currentCrBalance10 = new BigDecimal(0.00);
	BigDecimal currentDrBalance10 = new BigDecimal(0.00);
	BigDecimal currentCrBalance11 = new BigDecimal(0.00);
	BigDecimal currentDrBalance11 = new BigDecimal(0.00);
	BigDecimal currentCrBalance12 = new BigDecimal(0.00);
	BigDecimal currentDrBalance12 = new BigDecimal(0.00);
	BigDecimal currentCrBalance13 = new BigDecimal(0.00);
	BigDecimal currentDrBalance13 = new BigDecimal(0.00);
	BigDecimal currentCrBalance14 = new BigDecimal(0.00);
	BigDecimal currentDrBalance14 = new BigDecimal(0.00);
	BigDecimal currentCrBalance15 = new BigDecimal(0.00);
	BigDecimal currentDrBalance15 = new BigDecimal(0.00);
	BigDecimal currentCrBalance16 = new BigDecimal(0.00);
	BigDecimal currentDrBalance16 = new BigDecimal(0.00);
	BigDecimal currentCrBalance17 = new BigDecimal(0.00);
	BigDecimal currentDrBalance17 = new BigDecimal(0.00);
	BigDecimal currentCrBalance18 = new BigDecimal(0.00);
	BigDecimal currentDrBalance18 = new BigDecimal(0.00);
	BigDecimal currentSchedule3Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule4Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule5Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule6Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule7Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule8Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule9Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule10Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule11Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule12Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule13Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule14Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule15Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule16Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule17Amt = new BigDecimal(0.00);
	BigDecimal currentSchedule18Amt = new BigDecimal(0.00);
	
	if(currentFinancialYearAccountList.size()>0){
		for(AccountMainTransac masAccount : currentFinancialYearAccountList){
			
			if(masAccount.getAccount().getSchedule() != null){
			if(masAccount.getAccount().getSchedule()==3){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance3 =currentCrBalance3.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance3 =currentDrBalance3.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance3.compareTo(currentDrBalance3)>0){
					currentSchedule3Amt = currentCrBalance3.subtract(currentDrBalance3);
				}else if(currentDrBalance3.compareTo(currentCrBalance3)>0){
					currentSchedule3Amt = currentDrBalance3.subtract(currentCrBalance3);
				}else if(currentDrBalance3.compareTo(currentCrBalance3)==0){
					currentSchedule3Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==4){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance4 =currentCrBalance4.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance4 =currentDrBalance4.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance4.compareTo(currentDrBalance4)>0){
					currentSchedule4Amt = currentCrBalance4.subtract(currentDrBalance4);
				}else if(currentDrBalance4.compareTo(currentCrBalance4)>0){
					currentSchedule4Amt = currentDrBalance4.subtract(currentCrBalance4);
				}else if(currentDrBalance4.compareTo(currentCrBalance4)==0){
					currentSchedule4Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==5){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance5.compareTo(currentDrBalance5)>0){
					currentSchedule5Amt = currentCrBalance5.subtract(currentDrBalance5);
				}else if(currentDrBalance5.compareTo(currentCrBalance5)>0){
					currentSchedule5Amt = currentDrBalance5.subtract(currentCrBalance5);
				}else if(currentDrBalance5.compareTo(currentCrBalance5)==0){
					currentSchedule5Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==6){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance6 =currentCrBalance6.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance6 =currentDrBalance6.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance6.compareTo(currentDrBalance6)>0){
					currentSchedule6Amt = currentCrBalance6.subtract(currentDrBalance6);
				}else if(currentDrBalance6.compareTo(currentCrBalance6)>0){
					currentSchedule6Amt = currentDrBalance6.subtract(currentCrBalance6);
				}else if(currentDrBalance6.compareTo(currentCrBalance6)==0){
					currentSchedule6Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==7){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance7 =currentCrBalance7.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance7 =currentDrBalance7.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance7.compareTo(currentDrBalance7)>0){
					currentSchedule7Amt = currentCrBalance7.subtract(currentDrBalance7);
				}else if(currentDrBalance7.compareTo(currentCrBalance7)>0){
					currentSchedule7Amt = currentDrBalance7.subtract(currentCrBalance7);
				}else if(currentDrBalance7.compareTo(currentCrBalance7)==0){
					currentSchedule7Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==8){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance8 =currentCrBalance8.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance8 =currentDrBalance8.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance8.compareTo(currentDrBalance8)>0){
					currentSchedule8Amt = currentCrBalance8.subtract(currentDrBalance8);
				}else if(currentDrBalance8.compareTo(currentCrBalance8)>0){
					currentSchedule8Amt = currentDrBalance8.subtract(currentCrBalance8);
				}else if(currentDrBalance8.compareTo(currentCrBalance8)==0){
					currentSchedule8Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==9){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					currentCrBalance9 =currentCrBalance9.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					currentDrBalance9 =currentDrBalance9.add(masAccount.getClBalanceDr());
				}
				if(currentCrBalance9.compareTo(currentDrBalance9)>0){
					currentSchedule9Amt = currentCrBalance9.subtract(currentDrBalance9);
				}else if(currentDrBalance9.compareTo(currentCrBalance9)>0){
					currentSchedule9Amt = currentDrBalance9.subtract(currentCrBalance9);
				}else if(currentDrBalance9.compareTo(currentCrBalance9)==0){
					currentSchedule9Amt =new BigDecimal(0.00);
				}
			}
			
		if(masAccount.getAccount().getSchedule()==10){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance10 =currentCrBalance10.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance10 =currentDrBalance10.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance10.compareTo(currentDrBalance10)>0){
				currentSchedule10Amt = currentCrBalance10.subtract(currentDrBalance10);
			}else if(currentDrBalance10.compareTo(currentCrBalance10)>0){
				currentSchedule10Amt = currentDrBalance10.subtract(currentCrBalance10);
			}else if(currentDrBalance10.compareTo(currentCrBalance10)==0){
				currentSchedule10Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getAccount().getSchedule()==11){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance11 =currentCrBalance11.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance11 =currentDrBalance11.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance11.compareTo(currentDrBalance11)>0){
				currentSchedule11Amt = currentCrBalance11.subtract(currentDrBalance11);
			}else if(currentDrBalance11.compareTo(currentCrBalance11)>0){
				currentSchedule11Amt = currentDrBalance11.subtract(currentCrBalance11);
			}else if(currentDrBalance11.compareTo(currentCrBalance11)==0){
				currentSchedule11Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==12){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance12 =currentCrBalance12.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance12 =currentDrBalance12.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance12.compareTo(currentDrBalance12)>0){
				currentSchedule12Amt = currentCrBalance12.subtract(currentDrBalance12);
			}else if(currentDrBalance12.compareTo(currentCrBalance12)>0){
				currentSchedule12Amt = currentDrBalance12.subtract(currentCrBalance12);
			}else if(currentDrBalance12.compareTo(currentCrBalance12)==0){
				currentSchedule12Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==13){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance13 =currentCrBalance13.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance13 =currentDrBalance13.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance13.compareTo(currentDrBalance13)>0){
				currentSchedule13Amt = currentCrBalance13.subtract(currentDrBalance13);
			}else if(currentDrBalance13.compareTo(currentCrBalance13)>0){
				currentSchedule13Amt = currentDrBalance13.subtract(currentCrBalance13);
			}else if(currentDrBalance13.compareTo(currentCrBalance13)==0){
				currentSchedule13Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==14){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance14 =currentCrBalance14.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance14 =currentDrBalance14.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance14.compareTo(currentDrBalance14)>0){
				currentSchedule14Amt = currentCrBalance14.subtract(currentDrBalance14);
			}else if(currentDrBalance14.compareTo(currentCrBalance14)>0){
				currentSchedule14Amt = currentDrBalance14.subtract(currentCrBalance14);
			}else if(currentDrBalance14.compareTo(currentCrBalance14)==0){
				currentSchedule14Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getAccount().getSchedule()==15){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance15 =currentCrBalance15.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance15 =currentDrBalance15.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance15.compareTo(currentDrBalance15)>0){
				currentSchedule15Amt = currentCrBalance15.subtract(currentDrBalance15);
			}else if(currentDrBalance15.compareTo(currentCrBalance15)>0){
				currentSchedule15Amt = currentDrBalance15.subtract(currentCrBalance15);
			}else if(currentDrBalance15.compareTo(currentCrBalance15)==0){
				currentSchedule15Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==16){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance16 =currentCrBalance16.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance16 =currentDrBalance16.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance16.compareTo(currentDrBalance16)>0){
				currentSchedule16Amt = currentCrBalance16.subtract(currentDrBalance16);
			}else if(currentDrBalance16.compareTo(currentCrBalance16)>0){
				currentSchedule16Amt = currentDrBalance16.subtract(currentCrBalance16);
			}else if(currentDrBalance16.compareTo(currentCrBalance16)==0){
				currentSchedule16Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==17){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance17 =currentCrBalance17.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance17 =currentDrBalance17.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance17.compareTo(currentDrBalance17)>0){
				currentSchedule17Amt = currentCrBalance17.subtract(currentDrBalance17);
			}else if(currentDrBalance17.compareTo(currentCrBalance17)>0){
				currentSchedule17Amt = currentDrBalance17.subtract(currentCrBalance17);
			}else if(currentDrBalance17.compareTo(currentCrBalance17)==0){
				currentSchedule17Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==18){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				currentCrBalance18 =currentCrBalance18.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				currentDrBalance18 =currentDrBalance18.add(masAccount.getClBalanceDr());
			}
			if(currentCrBalance18.compareTo(currentDrBalance18)>0){
				currentSchedule18Amt = currentCrBalance18.subtract(currentDrBalance18);
			}else if(currentDrBalance18.compareTo(currentCrBalance18)>0){
				currentSchedule18Amt = currentDrBalance18.subtract(currentCrBalance18);
			}else if(currentDrBalance18.compareTo(currentCrBalance18)==0){
				currentSchedule18Amt =new BigDecimal(0.00);
			}
		}
		
		}
	}
}
	
%>

<%
	//------------------------------------for last Year Balance-----------------------------------------------------//
	BigDecimal lastCrBalance3 = new BigDecimal(0.00);
	BigDecimal lastDrBalance3 = new BigDecimal(0.00);
	BigDecimal lastCrBalance4 = new BigDecimal(0.00);
	BigDecimal lastDrBalance4 = new BigDecimal(0.00);
	BigDecimal lastCrBalance5 = new BigDecimal(0.00);
	BigDecimal lastDrBalance5 = new BigDecimal(0.00);
	BigDecimal lastCrBalance6 = new BigDecimal(0.00);
	BigDecimal lastDrBalance6 = new BigDecimal(0.00);
	BigDecimal lastCrBalance7 = new BigDecimal(0.00);
	BigDecimal lastDrBalance7 = new BigDecimal(0.00);
	BigDecimal lastCrBalance8 = new BigDecimal(0.00);
	BigDecimal lastDrBalance8 = new BigDecimal(0.00);
	BigDecimal lastCrBalance9 = new BigDecimal(0.00);
	BigDecimal lastDrBalance9 = new BigDecimal(0.00);
	BigDecimal lastCrBalance10 = new BigDecimal(0.00);
	BigDecimal lastDrBalance10 = new BigDecimal(0.00);
	BigDecimal lastCrBalance11 = new BigDecimal(0.00);
	BigDecimal lastDrBalance11 = new BigDecimal(0.00);
	BigDecimal lastCrBalance12 = new BigDecimal(0.00);
	BigDecimal lastDrBalance12 = new BigDecimal(0.00);
	BigDecimal lastCrBalance13 = new BigDecimal(0.00);
	BigDecimal lastDrBalance13 = new BigDecimal(0.00);
	BigDecimal lastCrBalance14 = new BigDecimal(0.00);
	BigDecimal lastDrBalance14 = new BigDecimal(0.00);
	BigDecimal lastCrBalance15 = new BigDecimal(0.00);
	BigDecimal lastDrBalance15 = new BigDecimal(0.00);
	BigDecimal lastCrBalance16 = new BigDecimal(0.00);
	BigDecimal lastDrBalance16 = new BigDecimal(0.00);
	BigDecimal lastCrBalance17 = new BigDecimal(0.00);
	BigDecimal lastDrBalance17 = new BigDecimal(0.00);
	BigDecimal lastCrBalance18 = new BigDecimal(0.00);
	BigDecimal lastDrBalance18 = new BigDecimal(0.00);
	BigDecimal lastSchedule3Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule4Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule5Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule6Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule7Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule8Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule9Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule10Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule11Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule12Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule13Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule14Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule15Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule16Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule17Amt = new BigDecimal(0.00);
	BigDecimal lastSchedule18Amt = new BigDecimal(0.00);
	
	if(lastFinancialYearAccountList.size()>0){
		for(AccountMainTransac masAccount : lastFinancialYearAccountList){
			if(masAccount.getAccount().getSchedule() != 0){
			if(masAccount.getAccount().getSchedule()==3){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance3 =lastCrBalance3.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance3 =lastDrBalance3.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance3.compareTo(lastDrBalance3)>0){
					lastSchedule3Amt = lastCrBalance3.subtract(lastDrBalance3);
				}else if(lastDrBalance3.compareTo(lastCrBalance3)>0){
					lastSchedule3Amt = lastDrBalance3.subtract(lastCrBalance3);
				}else if(lastDrBalance3.compareTo(lastCrBalance3)==0){
					lastSchedule3Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==4){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance4 =lastCrBalance4.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance4 =lastDrBalance4.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance4.compareTo(lastDrBalance4)>0){
					lastSchedule4Amt = lastCrBalance4.subtract(lastDrBalance4);
				}else if(lastDrBalance4.compareTo(lastCrBalance4)>0){
					lastSchedule4Amt = lastDrBalance4.subtract(lastCrBalance4);
				}else if(lastDrBalance4.compareTo(lastCrBalance4)==0){
					lastSchedule4Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==5){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance5 =lastCrBalance5.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastCrBalance5 =lastCrBalance5.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance5.compareTo(lastDrBalance5)>0){
					lastSchedule5Amt = lastCrBalance5.subtract(lastDrBalance5);
				}else if(lastDrBalance5.compareTo(lastCrBalance5)>0){
					lastSchedule5Amt = lastDrBalance5.subtract(lastCrBalance5);
				}else if(lastDrBalance5.compareTo(lastCrBalance5)==0){
					lastSchedule5Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==6){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance6 =lastCrBalance6.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance6 =lastDrBalance6.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance6.compareTo(lastDrBalance6)>0){
					lastSchedule6Amt = lastCrBalance6.subtract(lastDrBalance6);
				}else if(lastDrBalance6.compareTo(lastCrBalance6)>0){
					lastSchedule6Amt = lastDrBalance6.subtract(lastCrBalance6);
				}else if(lastDrBalance6.compareTo(lastCrBalance6)==0){
					lastSchedule6Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==7){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance7 =lastCrBalance7.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance7 =lastDrBalance7.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance7.compareTo(lastDrBalance7)>0){
					lastSchedule7Amt = lastCrBalance7.subtract(lastDrBalance7);
				}else if(lastDrBalance7.compareTo(lastCrBalance7)>0){
					lastSchedule7Amt = lastDrBalance7.subtract(lastCrBalance7);
				}else if(lastDrBalance7.compareTo(lastCrBalance7)==0){
					lastSchedule7Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==8){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance8 =lastCrBalance8.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance8 =lastDrBalance8.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance8.compareTo(lastDrBalance8)>0){
					lastSchedule8Amt = lastCrBalance8.subtract(lastDrBalance8);
				}else if(lastDrBalance8.compareTo(lastCrBalance8)>0){
					lastSchedule8Amt = lastDrBalance8.subtract(lastCrBalance8);
				}else if(lastDrBalance8.compareTo(lastCrBalance8)==0){
					lastSchedule8Amt =new BigDecimal(0.00);
				}
			}
			if(masAccount.getAccount().getSchedule()==9){
				if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
					lastCrBalance9 =lastCrBalance9.add(masAccount.getClBalanceCr());
				}
				if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
					lastDrBalance9 =lastDrBalance9.add(masAccount.getClBalanceDr());
				}
				if(lastCrBalance9.compareTo(lastDrBalance9)>0){
					lastSchedule9Amt = lastCrBalance9.subtract(lastDrBalance9);
				}else if(lastDrBalance9.compareTo(lastCrBalance9)>0){
					lastSchedule9Amt = lastDrBalance9.subtract(lastCrBalance9);
				}else if(lastDrBalance9.compareTo(lastCrBalance9)==0){
					lastSchedule9Amt =new BigDecimal(0.00);
				}
			}
			
		if(masAccount.getAccount().getSchedule()==10){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance10 =lastCrBalance10.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance10 =lastDrBalance10.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance10.compareTo(lastDrBalance10)>0){
				lastSchedule10Amt = lastCrBalance10.subtract(lastDrBalance10);
			}else if(lastDrBalance10.compareTo(lastCrBalance10)>0){
				lastSchedule10Amt = lastDrBalance10.subtract(lastCrBalance10);
			}else if(lastDrBalance10.compareTo(lastCrBalance10)==0){
				lastSchedule10Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getAccount().getSchedule()==11){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance11 =lastCrBalance11.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance11 =lastDrBalance11.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance11.compareTo(lastDrBalance11)>0){
				lastSchedule11Amt = lastCrBalance11.subtract(lastDrBalance11);
			}else if(lastDrBalance11.compareTo(lastCrBalance11)>0){
				lastSchedule11Amt = lastDrBalance11.subtract(lastCrBalance11);
			}else if(lastDrBalance11.compareTo(lastCrBalance11)==0){
				lastSchedule11Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==12){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance12 =lastCrBalance12.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance12 =lastDrBalance12.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance12.compareTo(lastDrBalance12)>0){
				lastSchedule12Amt = lastCrBalance12.subtract(lastDrBalance12);
			}else if(lastDrBalance12.compareTo(lastCrBalance12)>0){
				lastSchedule12Amt = lastDrBalance12.subtract(lastCrBalance12);
			}else if(lastDrBalance12.compareTo(lastCrBalance12)==0){
				lastSchedule12Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==13){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance13 =lastCrBalance13.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance13 =lastDrBalance13.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance13.compareTo(lastDrBalance13)>0){
				lastSchedule13Amt = lastCrBalance13.subtract(lastDrBalance13);
			}else if(lastDrBalance13.compareTo(lastCrBalance13)>0){
				lastSchedule13Amt = lastDrBalance13.subtract(lastCrBalance13);
			}else if(lastDrBalance13.compareTo(lastCrBalance13)==0){
				lastSchedule13Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==14){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance14 =lastCrBalance14.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance14 =lastDrBalance14.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance14.compareTo(lastDrBalance14)>0){
				lastSchedule14Amt = lastCrBalance14.subtract(lastDrBalance14);
			}else if(lastDrBalance14.compareTo(lastCrBalance14)>0){
				lastSchedule14Amt = lastDrBalance14.subtract(lastCrBalance14);
			}else if(lastDrBalance14.compareTo(lastCrBalance14)==0){
				lastSchedule14Amt =new BigDecimal(0.00);
			}
		}
		if(masAccount.getAccount().getSchedule()==15){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance15 =lastCrBalance15.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance15 =lastDrBalance15.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance15.compareTo(lastDrBalance15)>0){
				lastSchedule15Amt = lastCrBalance15.subtract(lastDrBalance15);
			}else if(lastDrBalance15.compareTo(lastCrBalance15)>0){
				lastSchedule15Amt = lastDrBalance15.subtract(lastCrBalance15);
			}else if(lastDrBalance15.compareTo(lastCrBalance15)==0){
				lastSchedule15Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==16){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance16 =lastCrBalance16.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance16 =lastDrBalance16.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance16.compareTo(lastDrBalance16)>0){
				lastSchedule16Amt = lastCrBalance16.subtract(lastDrBalance16);
			}else if(lastDrBalance16.compareTo(lastCrBalance16)>0){
				lastSchedule16Amt = lastDrBalance16.subtract(lastCrBalance16);
			}else if(lastDrBalance16.compareTo(lastCrBalance16)==0){
				lastSchedule16Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==17){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance17 =lastCrBalance17.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance17 =lastDrBalance17.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance17.compareTo(lastDrBalance17)>0){
				lastSchedule17Amt = lastCrBalance17.subtract(lastDrBalance17);
			}else if(lastDrBalance17.compareTo(lastCrBalance17)>0){
				lastSchedule17Amt = lastDrBalance17.subtract(lastCrBalance17);
			}else if(lastDrBalance17.compareTo(lastCrBalance17)==0){
				lastSchedule17Amt =new BigDecimal(0.00);
			}
		}
		
		if(masAccount.getAccount().getSchedule()==18){
			if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
				lastCrBalance18 =lastCrBalance18.add(masAccount.getClBalanceCr());
			}
			if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
				lastDrBalance18 =lastDrBalance18.add(masAccount.getClBalanceDr());
			}
			if(lastCrBalance18.compareTo(lastDrBalance18)>0){
				lastSchedule18Amt = lastCrBalance18.subtract(lastDrBalance18);
			}else if(lastDrBalance18.compareTo(lastCrBalance18)>0){
				lastSchedule18Amt = lastDrBalance18.subtract(lastCrBalance18);
			}else if(lastDrBalance18.compareTo(lastCrBalance18)==0){
				lastSchedule18Amt =new BigDecimal(0.00);
			}
		}
		
		}
	}
}
	
%>

	<tr>
	
	<td><b>I. EQUITY AND LIABILITIES</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	
	
	<tr>
	<td><b>1) Shareholder's funds</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr style="cursor: pointer;" onclick ="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=3&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Share Capital')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(a) Share Capital</td>
	<td>3</td>
	<td><%=currentSchedule3Amt %></td>
	<td><%=lastSchedule3Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick ="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=4&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Reserves and surplus')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(b) Reserves and surplus</td>
	<td>4</td>
	<%
		BigDecimal currentshareHoldersAmt = currentSchedule3Amt.add(currentSchedule4Amt); 
		BigDecimal lastshareHoldersAmt = lastSchedule3Amt.add(lastSchedule4Amt);
		%>
	<td><%=currentSchedule4Amt+"-------------- "+currentshareHoldersAmt %></td>
	<td><%=lastSchedule4Amt+"-------------- "+lastshareHoldersAmt%></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(c) Money received against share warrants</td>
	<td></td>	
	<td></td>
	<td></td>
	</tr>
	
	
	<tr>
	<td><b>2) Share application money pending allotment</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td><b>3) Non-current liabilities</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(a) Long-term borrowings</td>
	<td></td>	
	<td></td>
	<td></td>
	</tr>
	<tr >
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(b) Deferred tax liabilities</td>
	<td>5</td>	
	<td><%=currentSchedule5Amt %></td>
	<td><%=lastSchedule5Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=6&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other Long term liabilities')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(c) Other Long term liabilities</td>
	<td>6</td>
	<td><%=currentSchedule6Amt %></td>
	<td><%=lastSchedule6Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=7&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Long-term provisions')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(d) Long-term provisions</td>
	<td>7</td>
	<% 
	BigDecimal nonCurrentLiabilities =  currentSchedule5Amt.add(currentSchedule6Amt).add(currentSchedule7Amt); 
	BigDecimal lastYearnonCurrentLiabilities =  lastSchedule5Amt.add(lastSchedule6Amt).add(lastSchedule7Amt);
	%>
	<td><%=currentSchedule7Amt +"-------------- "+nonCurrentLiabilities%></td>
	<td><%=lastSchedule7Amt +"-------------- "+lastYearnonCurrentLiabilities%></td>
	</tr>
	<tr>
	<td><b>4) Current liabilities</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=8&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term borrowings')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(a) Short-term borrowings</td>
	<td>8</td>
	<td><%=currentSchedule8Amt %></td>
	<td><%=lastSchedule8Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=9&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Trade payables')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(b) Trade payables</td>
	<td>9</td>
	<td><%=currentSchedule9Amt %></td>
	<td><%=lastSchedule9Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=10&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other current liabilities')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(c) Other current liabilities</td>
	<td>10</td>
	<td><%=currentSchedule10Amt %></td>
	<td><%=lastSchedule10Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=11&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term provisions')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(d) Short-term provisions</td>
	<td>11</td>
	<%
	BigDecimal currentLiabilities =currentSchedule8Amt.add(currentSchedule9Amt).add(currentSchedule10Amt).add(currentSchedule11Amt);
	BigDecimal lastYearcurrentLiabilities =lastSchedule8Amt.add(lastSchedule9Amt).add(lastSchedule10Amt).add(lastSchedule11Amt);
	%>
	<td><%=currentSchedule11Amt +"--------------"+currentLiabilities %></td>
	<td><%=lastSchedule11Amt +"--------------"+lastYearcurrentLiabilities %></td>
	</tr>
	
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>TOTAL</b></td>
	<td></td>
	<td><b><%=currentshareHoldersAmt.add(nonCurrentLiabilities).add(currentLiabilities) %></b></td>
	<td><b><%=lastshareHoldersAmt.add(lastYearnonCurrentLiabilities).add(lastYearcurrentLiabilities) %></b></td>
	</tr>
	
	<tr>
	<td><b>II. ASSETS</b></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td><b>1) Non-current assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=12currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Fixed assets')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(a) Fixed assets</td>
	<td>12</td>
	<td><%=currentSchedule12Amt %></td>
	<td><%=lastSchedule12Amt %></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(i) Tangible assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(ii) Intangible assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(iii) Capital work-in-progress</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(iv) Intangible assets under development</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(b) Non-current Investments</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(c) Deferred tax assets(net)</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=13&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Long-term loans and advances')">
	<td> &nbsp;&nbsp;&nbsp;&nbsp;(d) Long-term loans and advances</td>
	<td>13</td>
	<td><%=currentSchedule13Amt+"--------------"+currentSchedule12Amt.add(currentSchedule13Amt) %></td>
	<td><%=lastSchedule13Amt+"--------------"+lastSchedule12Amt.add(lastSchedule13Amt) %></td>
	</tr>
	
	<tr>
	<td><b>(2) Current assets</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	

    <tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(a) Current investments</td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=14&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Inventories')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(b) Inventories</td>
	<td>14</td>
	<td><%=currentSchedule14Amt %></td>
	<td><%=lastSchedule14Amt %></td>
	</tr>
	
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=15&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Trade receivables')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(c) Trade receivables</td>
	<td>15</td>
	<td><%=currentSchedule15Amt %></td>
	<td><%=lastSchedule15Amt %></td>
	</tr>
	
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=16&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Cash and bank balances')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(d) Cash and bank balances</td>
	<td>16</td>
	<td><%=currentSchedule16Amt %></td>
	<td><%=lastSchedule16Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=17&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Short-term loans and advances')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(e) Short-term loans and advances</td>
	<td>17</td>
	<td><%=currentSchedule17Amt %></td>
	<td><%=lastSchedule17Amt %></td>
	</tr>
	<tr style="cursor: pointer;" onclick="submitForm('balanceSheet','account?method=displayScheduleDetail&schedule=18&currentYearDesc=<%=currentYearDesc %>&lastYearDesc=<%=lastYearDesc %>&particular=Other current assets')">
	<td>&nbsp;&nbsp;&nbsp;&nbsp;(f) Other current assets</td>
	<td>18</td>
	<%
	BigDecimal currentAssets =currentSchedule14Amt.add(currentSchedule15Amt).add(currentSchedule16Amt).add(currentSchedule17Amt).add(currentSchedule18Amt);
	BigDecimal lastYearcurrentAssets =lastSchedule14Amt.add(lastSchedule15Amt).add(lastSchedule16Amt).add(lastSchedule17Amt).add(lastSchedule18Amt);
	%>
	<td><%=currentSchedule18Amt+"  -------------------  "+currentAssets %></td>
	<td><%=lastSchedule18Amt+"  -------------------  "+lastYearcurrentAssets %></td>
	</tr>
	
	<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>TOTAL</b></td>
	<td></td>
	<td><b><%=currentSchedule11Amt.add(currentSchedule12Amt).add(currentAssets)%></b></td>
	<td><b><%=lastSchedule11Amt.add(lastSchedule12Amt).add(lastYearcurrentAssets)%></b></td>
	</tr>

</table>
<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="button" class="buttonBig" value="Export To Excel" onclick="submitForm('balanceSheet','account?method=generateBalanceSheetJsp&locationId=<%out.print(locationId); %>&Type=<%out.print(Type); %>');"/>
<input type="hidden" id="pageType" name ="pageType" value="BalanceSheet" />
<input type="hidden" id="BalanceSheetType" name ="BalanceSheetType" value="<%out.print(Type); %>" />


<div class="clear"></div>
<div class="clear"></div>
</div>



</form>

<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			
	       var Type= '<%out.print(Type);%>';
	      
	     if(Type=='')
	    	   {
	    	  	 $j("#rdConsolidated").prop("checked","checked");
	    	  	checkBalanceSheetType();
	    	   } 
	       if(Type == "ALL")
	    	   {
	    	 		  $j("#ddlLocation").prop("disabled","disabled");
	    	   }
			//GetMktComplaintList('ALL');
	
		});
		
		function checkBalanceSheetType()
		{
			
			
			if($j("#rdConsolidated").prop("checked")== true || $j("#rdConsolidated").prop("checked")=="true" || $j("#rdConsolidated").prop("checked")== "checked")
				{
					$j("#ddlLocation").prop("disabled","disabled");
					showBalanceSheet('ALL');
				}
			
			if($j("#rdLocationWise").prop("checked")== true || $j("#rdLocationWise").prop("checked")=="true" || $j("#rdLocationWise").prop("checked")== "checked")
			{
				$j("#ddlLocation").removeAttr("disabled");
			}
		}
		
		
		function showBalanceSheet(MODE)
		{
			
			if(MODE == 'ALL')
				{

				var locationURL = "account?method=showBalanceSheet&Type=ALL";
				submitForm('balanceSheet',locationURL);
					
				}
			else
				{
				   var locationId = $j("#ddlLocation").val();
				   if(locationId == 0)
					   {
					   	
					   }
				   else
					   {
						
						var locationURL = "account?method=showBalanceSheet&locationId="+locationId+"&Type=FILTER";
						submitForm('balanceSheet',locationURL);
					   }
				 
					
				}
		}
		
</script>