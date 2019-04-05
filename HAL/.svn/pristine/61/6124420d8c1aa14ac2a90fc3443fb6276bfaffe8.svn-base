<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrArrearSalary"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("arrearSalaryList")!= null){
				arrearSalaryList = (List)map.get("arrearSalaryList");
			}
			
			int hospitalId = 0;
			if(hospitalList.size()>0){
				MasHospital masHospital = hospitalList.get(0);
				hospitalId = masHospital.getId();
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			String message="";
			if(map.get("message") != null){
			 message = (String)map.get("message");
			//out.println(message);
			}
%>






<script type="text/javascript">
	


  function displayValues(idvalue) {
	<%
	for(MasEmployee masEmployee :employeeList){
		int id = masEmployee.getId();
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= masEmployee.getServiceNo()%>'
	}
<%
	}
%>	
}
	function checkFromDate(){
		var fDate = document.arrearSalary.<%= FROM_DATE%>.value;
		var tDate = document.arrearSalary.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert(" To Date should be greater than  From Date.");
			document.arrearSalary.<%= FROM_DATE%>.value = "";
			document.arrearSalary.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	
	
	
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
		
	<%--function calculateArrearDays(){
		var fDate = document.arrearSalary.<%= FROM_DATE%>.value;
		var tDate = document.arrearSalary.<%= TO_DATE %>.value;
		var	startDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var endDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		var oneday = 1000 * 60 * 60 * 24
		
		var diffDays = Math.abs((startDate.getTime() - endDate.getTime()));
		var totalDays = Math.round(diffDays/oneday);
		document.arrearSalary.<%= ARREAR_DAYS %>.value = totalDays;

	}
		
		
		
		function resetUpdatedValue(){
  			document.getElementById('empId').disabled = false;
 		}
 	--%>
 	
 	function startEndDateValidate(){
 		var day1, day2;
 		var month1, month2;
 		var year1, year2;
 		var starDate = document.getElementById('fromDate').value;
 		var endDate = document.getElementById('toDate').value;
 		
 		
 		day1 = starDate.substring (0, starDate.indexOf ("/"));
 		month1 = starDate.substring (starDate.indexOf ("/")+1, starDate.lastIndexOf ("/"));
 		year1 = starDate.substring (starDate.lastIndexOf ("/")+1, starDate.length);

 		day2 = endDate.substring (0, endDate.indexOf ("/"));
 		month2 = endDate.substring (endDate.indexOf ("/")+1, endDate.lastIndexOf ("/"));
 		year2 = endDate.substring (endDate.lastIndexOf ("/")+1, endDate.length); 


 		var chDate1 = new Date(year1, month1, day1); 
 		var chDate2 = new Date(year2, month2, day2); 

 		
 		var timeDiff = Math.abs(chDate2.getTime() - chDate1.getTime());
 		var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
 		if(endDate){
 			document.getElementById("ArrearDays").value=diffDays;
 		}else{
 			document.getElementById("ArrearDays").value='';
 		}
 		
 		if(chDate2 < chDate1) 
 		{ 
 			
 		alert(lDate+" cannot less than "+sDate);
 		
 		document.getElementById("ArrearDays").value="";
 		document.getElementById('toDate').value="";
 		return false; 
 		
 		}
 		}

</script>
<%
if(!message.equals("")){%>

<h4><%=message%></h4>

<%}%>

<div class="titleBg"><h2>Arrear Salary</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= ARREAR_SALARY_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=FROM_DATE%>"],[4,"<%= TO_DATE%>"],[5,"<%= ARREAR_DAYS%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=REMARK%>"],[10,"<%=STATUS%>"],[11,"hiddenEmp"],[12,"<%=PAYMENT_DATE%>"]];
statusTd = 10;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="arrearSalary" method="post" action="">

<div class="Block">
<input type="hidden" name="hiddenEmp" id=hiddenEmp" value="" />
<label> Employee Name <span>*</span></label>
<select id="empId"  name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes" onchange="displayValues(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+(masEmployee.getLastName() != null ? masEmployee.getLastName() : "")%></option>
<%
	}
%>
</select>
<label id=biglabel> Employee No. <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId" validate="Employee Code,string,yes"  readonly="readonly" type="text" />

<label id="Label1">From Date<span>*</span></label>
<input type="text" id="fromDate" name="<%=FROM_DATE %>" value="" class="calDate"  validate="From date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" onChange="startEndDateValidate()" />

<div class="clear"></div>


<label id="Label2">To Date<span>*</span></label>
<input type="text" id="toDate" name="<%=TO_DATE %>" value=""  class="calDate"  validate="Todate ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" onChange="startEndDateValidate()" />
<%--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrearSalary.<%=TO_DATE%>,event)"/> --%>

<label>Arrear Days <span>*</span></label>
<input  type="text" id="ArrearDays" name="<%= ARREAR_DAYS%>" value="" readonly="readonly"  validate="Arrear Days,Float,yes" MAXLENGTH="3"  />


<!-- <label>Arrear Percentage <span>*</span></label>
<input  type="text" id="Arrearper" name="Arrearper" value=""   validate="Arrear percentage,Float,yes" MAXLENGTH="3"  /> -->
<div class="clear"></div>
<label>Payment date <span>*</span></label>
<input type="text"  name="<%=PAYMENT_DATE %>" value="" class="calDate"  validate="Todate ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrearSalary.<%=PAYMENT_DATE%>,event)"/> --%>


 <label>Remark <span>*</span></label>
<%-- <input  type="text" name="<%= REMARK%>" value=""   validate="Remark,String,yes" MAXLENGTH="40" tabindex=2 /> --%>
<textarea class="auto" rows="" cols="76" name="<%= REMARK%>" value=""   validate="Remark,String,yes" MAXLENGTH="200"></textarea>

 
 

<div class="clear"></div>



</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('arrearSalary','loan?method=saveArrearSalary','checkFromDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('arrearSalary','loan?method=updateArrearSalary','checkFromDate')" accesskey="u" tabindex=1 />

<input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();resetUpdatedValue();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= ARREAR_SALARY_ID%>" value="" />

</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= EMPLOYEE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Emp.Code"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= EMPLOYEE_CODE %>";

data_header[2] = new Array;
data_header[2][0] = "From Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=FROM_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "To Date"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= TO_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Arrear Days"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= ARREAR_DAYS %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%=REMARK %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "hiddenEmp";

data_header[11] = new Array;
data_header[11][0] = "Payment date"
data_header[11][1] = "data";
data_header[11][2] = 0;
data_header[11][3] = "<%= PAYMENT_DATE %>";

data_arr = new Array();

<%


Iterator itr=arrearSalaryList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrArrearSalary hrArrearSalary = (HrArrearSalary)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrArrearSalary.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}
		
%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][2] = "<%=masEmployee.getServiceNo()%>";
<%
		}
			}
		
%>

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getFromDate())%>";
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getToDate())%>"
data_arr[<%= counter%>][5] = "<%= hrArrearSalary.getArrearDays()%>"
data_arr[<%= counter%>][6] = "<%= hrArrearSalary.getLastChgBy().getFirstName()%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%=hrArrearSalary.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=hrArrearSalary.getRemark() %>"

<%
if(hrArrearSalary.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][11] = "<%=masEmployee.getId()%>";
<%
		}
			}
		
%>
data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getPaymentDate())%>";
<%

counter++;
}
%>


formName = "arrearSalary"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
