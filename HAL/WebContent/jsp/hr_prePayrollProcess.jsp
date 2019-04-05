<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
				
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
				 employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				int  hospitalId=0;
				if(map.get("hospitalId")!= null){
					hospitalId = (Integer)map.get("hospitalId");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				
				List<HrPayrollProcessHeader> processedPayrollList = new ArrayList();
				
				if(map.get("processedPayrollList")!= null){
					processedPayrollList = (List)map.get("processedPayrollList");
				}
				
			   List<HrPayrollProcessHeader> unprocessedPayrollList = new ArrayList();
				
				if(map.get("unprocessedPayrollList")!= null){
					unprocessedPayrollList = (List)map.get("unprocessedPayrollList");
				}
				if(map.get("financialList")!= null){
					financialList = (List<MasStoreFinancial>)map.get("financialList");
				}
				String message="";
				
				if(map.get("message")!= null){
					message = ""+map.get("message");
				}
	%>

<%@page import="jkt.hms.masters.business.HrPayrollProcessHeader"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript">

<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'

</script>

<form name="prePayrollProcess" method="post" action="" >
<div class="titleBg"> <h2>Pre Payroll Process </h2></div>
<div class="clear"></div>
<div class="Block">

<label> Month <span>*</span></label>
<select  name="<%=MONTH %>" validate="Month,string,yes" ">
<option value="0">Select</option>
<option value="01">January</option>
<option value="02">February</option>
<option value="03">March</option>
<option value="04">April</option>
<option value="05">May</option>
<option value="06">June</option>
<option value="07">July</option>
<option value="08">August</option>
<option value="09">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<label>Year <span>*</span></label>
<select  name="<%=YEAR %>" validate="Year,string,yes" ">
<option value="0">Select</option>

<%for(MasStoreFinancial msf : financialList){ %>
<option value="<%=msf.getYearDescription()%>"><%=msf.getFinancialYear()%></option>
<%} %>
</select>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label>Department Name</label>
<select id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>" validate="Department,string,no" onchange="getEmployeeList(this)">
<option value="0">All</option>
<%
		for(MasDepartment masDepartment :departmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%} %>
</select>


<label>Employee Name</label>
<select id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>" validate="Employee,string,no" ">
<option value="0">All</option>
<%
		for(MasEmployee masEmployee :employeeList){
			String empName=masEmployee.getFirstName()+" ";
			if(masEmployee.getMiddleName()!= null){
				empName+=masEmployee.getMiddleName()+" ";
			}
			if(masEmployee.getLastName()!= null){
				empName+=masEmployee.getLastName();
			}
%>
<option value="<%=masEmployee.getId() %>"><%=empName %></option>
<%} %>
</select>

<div class="clear"></div>
<input type="hidden" id="locationId" name="locationId" value="<%=hospitalId%>">
</div>

<input name="save" type="button" class="button" value="Process" onClick="submitForm('prePayrollProcess','payroll?method=processPrePayrollDetail');" />
<div class="paddingTop40"></div>
<div class="clear"></div>
<%
String period = "";	
if(map.get("year")!=null && map.get("month")!=null){
	period = map.get("month") +"/"+  map.get("year");
%>
<h4><%= " period :  "+period %></h4>	
<%} %>
<div class="clear"></div>
<h4><%=message %></h4>

<div class="division"></div>
<div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>

<label>Changed Time</label>   
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
</div>	

</form>

<script>

function getEmployeeList(obj)
{
	
	 sel = document.getElementById('<%=EMPLOYEE_ID %>');
	 removeAllOptions(sel);
		sel.options.add(new Option('All' , '0'));
	if(obj.value == '0')
	{
		removeAllOptions(sel);
		sel.options.add(new Option('All' , '0'));
		<%
		for(MasEmployee masEmployee :employeeList){
		%>
		sel.options.add(new Option('<%=masEmployee.getFirstName()+ " " +(masEmployee.getLastName()!= null ? masEmployee.getLastName() :"")%>' , '<%=masEmployee.getId()%>'));
		<%}%>
	}
	
			<%
			
			for(MasEmployee employee:employeeList){%>

			if(obj.value == <%=employee.getDepartment().getId()%> ){ 
				
				sel.options.add(new Option('<%=employee.getFirstName()+ " " + (employee.getLastName()!= null ? employee.getLastName() :"")%>' , '<%=employee.getId()%>'));
			
			} 
			<%}%>			
	
}


function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
</script>