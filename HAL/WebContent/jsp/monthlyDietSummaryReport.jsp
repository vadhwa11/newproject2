<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div  id="contentHolder">
	
	<script type="text/javascript" language="javascript">
	<%
	
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
	<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		String extra ="";
		if(map.get("extra") != null){
			extra = (String)map.get("extra");
		}		
		
	%>
	<div class="Clear"></div>
	<%
	if(extra.equals("yes")) {
	%>
	<h6>Summary of the Extras for the Month</h6>
	<%}else{ %>
	<h6>Monthly Diet Summary </h6>
	<%} %>
	<div class="Clear"></div>
	<form name="monthlyDietSummary" target="_blank" method="post" action="">
	<div class="blockFrame">
	  
			<input type="hidden" name="extra" value=<%=extra %> >
			<label ><span>*</span> Month:</label>
				<select name="<%=MONTH %>" validate="Month,String,yes">
					<option value="">Select</option>
					<option value="January">January</option>
					<option value="February">February</option>
					<option value="March">March</option>
					<option value="April">April</option>
					<option value="May">May</option>
					<option value="June">June</option>
					<option value="July">July</option>
					<option value="August">August</option>
					<option value="September">September</option>
					<option value="October">October</option>
					<option value="November">November</option>
					<option value="December">December</option>
					
				</select>	
				<label ><span>*</span> Year:</label>
				<select name="<%=YEAR %>" validate="Year,String,yes">
					<option value="">Select</option>
					<option value="<%=year-1 %>"><%=year-1 %></option>
					<option value="<%=year %>"><%=year %></option>
					<option value="<%=year+1 %>"><%=year+1 %></option>
				</select>
			<div class="Clear"></div>
		</div>
		<div class="Clear"></div>
			<input type="button" name="OK" value="OK" class="button" onClick="submitForm('monthlyDietSummary','diet?method=printMonthlyDietSummaryReport');" />
			<input type="reset" name ="Reset" value ="Cancel" class="button" accesskey="r" />
	 </form>
	</div>		
	
		  		 