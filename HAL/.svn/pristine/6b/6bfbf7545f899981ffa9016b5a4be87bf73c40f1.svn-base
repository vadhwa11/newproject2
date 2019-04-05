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
		String deptName = "";
		if(map.get("deptName") != null){
			deptName = (String)map.get("deptName");
		}
		
	%>
	<div class="Clear"></div>
	
	<h6>Monthly Diet Sheet of <%=deptName %> </h6>
	
	<div class="Clear"></div>
	<form name="montlyDietSheetOfWard" target="_blank" method="post" action="">
	<div class="blockFrame">
	  <input type="hidden" name="<%=DEPARTMENT_NAME %>" value="<%=deptName %>">
			<label><span>*</span>Month:</label>
				<select id="monthId" name="<%=MONTH %>" validate="Month,String,yes" onchange="setMonthName()">
					<option value="">Select</option>
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
				<label ><span>*</span>Year:</label>
				<select name="<%=YEAR %>" validate="Year,String,yes">
					<option value="">Select</option>
					<option value="<%=year-1 %>"><%=year-1 %></option>
					<option value="<%=year %>"><%=year %></option>
					<option value="<%=year+1 %>"><%=year+1 %></option>
				</select>
				</div>
			<div class="Clear"></div>
			<input type="hidden" name="monthName" id="monthNameId" value="">
			<input type="button" name="OK" value="OK" class="button" onClick="submitForm('montlyDietSheetOfWard','diet?method=printMonthlyDietSheetOfWardReport');" />
			<input type="reset" name ="Reset" value ="Cancel" class="button" accesskey="r" />
	 
	 </form>
			</div>
	<script type="text/javascript">
		function setMonthName(){
			var w = document.getElementById('monthId').selectedIndex;
			var selectedText = document.getElementById('monthId').options[w].text;
			document.getElementById('monthNameId').value = selectedText;
		
		
		}
	
	</script>
		  		 