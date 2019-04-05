<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				
				
				if(map.get("hrMasFinancialYearList")!=null)
				{
					hrMasFinancialYearList =(List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
				}
				
	%>
	
	<script type="text/javascript">
	function convertMonthInString(month){
	var pMonth = "" ;
		if(month == 0){
			pMonth = "";
		}else if(month == 1){
			pMonth = "January";
		}else if(month == 2){
			pMonth = "February";
		}else if(month == 3){
			pMonth = "March";
		}else if(month == 4){
			pMonth = "April";
		}else if(month == 5){
			pMonth = "May";
		}else if(month == 6){
			pMonth = "June";
		}else if(month == 7){
			pMonth = "July";
		}else if(month == 8){
			pMonth = "August";
		}else if(month == 9){
			pMonth = "September";
		}else if(month == 10){
			pMonth = "October";
		}else if(month == 11){
			pMonth = "November";
		}else if(month == 12){
			pMonth = "December";
		}
		
		document.getElementById('monthStringId').value = pMonth;
	}
	


</script>


<%-- <%@page import="jkt.hms.masters.business.HrMasLocation"%> --%>
<form name="paySlip" method="post" action="" >
<div class="titleBg"> <h2>Pay Slip</h2></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Employee </label>
<select name="fromEmpId" validate="Employee Code,string,yes"  >
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
			
<%
	}
%>
</select>

<div class="clear"></div>
<label><span>*</span> Month</label>
<select  name="<%=MONTH %>" validate="Month,string,yes" onchange="convertMonthInString(this.value)">
<option value="0">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<input type="hidden" name ="monthString" id="monthStringId" value="">
<label><span>*</span>Year</label>
<select  name="<%=YEAR %>" validate="Year,string,yes" ">
<option value="">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getYearDescription()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>			    
</select>	



<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('paySlip','payroll?method=printPaySlipReport');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

</form>

