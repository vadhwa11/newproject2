<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.HrAdvance"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>
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
			List<HrAdvance> advanceList = new ArrayList<HrAdvance>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("advanceList")!= null){
				advanceList = (List)map.get("advanceList");
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
	
function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}


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
	function calculateMonthlyDeduction(){
	var advanceAmt = document.advance.<%=ADVANCE_AMOUNT%>.value;
	var recPeriod = document.advance.<%=RECOVERY_PERIOD%>.value;
	
		if(advanceAmt != "" && recPeriod!="")
		{ 
			var advanceAmount = parseFloat(advanceAmt);
			var recPeriod = parseFloat(recPeriod);
			var monthlyDeduction = (advanceAmount/recPeriod).toFixed(2);
			document.advance.<%=MONTHLY_DEDUCTION%>.value = monthlyDeduction;
			
		}
	
  }
	function checkAdvanceAmount(){
	
	  var advanceAmt = document.advance.<%= ADVANCE_AMOUNT%>.value;
	  var recAmt = document.advance.<%= RECOVERED_AMOUNT_HEADER%>.value;
	  
	  if(parseFloat(advanceAmt) < parseFloat(recAmt)){
	  alert("advance Amount greater equal to than  Recoveyamount")
	  document.advance.<%= ADVANCE_AMOUNT%>.value = "";
	   return false;
	 }else if(parseFloat(advanceAmt) == parseFloat(recAmt)){
	 
	   return true;
	 
	}else{
		return true;
	}
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
		
	function resetUpdatedValue(){
  	document.getElementById('empId').disabled = false;
 	}
 	
 	function checkAdvanceAmount(){
	  if(parseInt(document.advance.<%=ADVANCE_AMOUNT%>.value) == 0){
	  	alert("Advance Amount should not be zero");
	  	document.advance.<%=ADVANCE_AMOUNT%>.value == "";
	  	return false;
	  }
	  return true;
	  }
	
	

</script>
<%if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>

<div class="titleBg"><h2>Advance Header</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=ADVANCE_CODE%>"],[4,"<%= ADVANCE_DATE%>"],[5,"<%= ADVANCE_AMOUNT%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=RECOVERY_MODE%>"],
[10,"<%=MONTHLY_DEDUCTION%>"],[11,"<%=RECOVERED_AMOUNT_HEADER%>"],[12,"<%=RECOVERY_PERIOD%>"],[13,"<%=STATUS%>"],[14,"hiddenEmp"]];
statusTd = 13;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="advance" method="post" action="">

<div class="Block">

<input type="hidden" name="hiddenEmp" id=hiddenEmp" value="" />
<label> Employee Name <span>*</span></label>
<select id="empId"  name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes" onchange="displayValues(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+(masEmployee.getLastName() != null ? masEmployee.getLastName() :"")%></option>
<%
	}
%>
</select>
<label id=biglabel> Employee Code <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId"   readonly="readonly" type="text" />

<label> Advance Code <span>*</span></label>
<select  name="<%=ADVANCE_CODE %>" validate="Advance Code,string,yes"  class="mediumm">
<option value="0">Select</option>
<option value="AAS">Advance against Salary</option>
</select>
<div class="clear"></div>


<label>Advance Date <span>*</span></label>
<input type="text"  name="<%=ADVANCE_DATE %>" value="" class="calDate"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');"  validate="Advance date ,date,yes"  MAXLENGTH="30" />
 <%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.advance.<%=ADVANCE_DATE%>,event)"/> --%>

<label>Advance Amount <span>*</span></label>
<input  type="text" name="<%= ADVANCE_AMOUNT%>" value=""   validate="Advance Amount,float,yes" MAXLENGTH="9" tabindex=1 onkeypress="return isNumber(event)"/>

<label> Recovery Mode <span>*</span></label>
<select  name="<%=RECOVERY_MODE %>" validate="Recovery Mode,string,yes" class="mediumm">
<option value="0">Select</option>
<option value="Salary">Salary</option>
<option value="Payment">Cash</option>
<option value="Cheque">Cheque</option>
</select>

 <div class="clear"></div>
 
<label>Recovery Period - Months <span>*</span></label>
<input  type="text" name="<%= RECOVERY_PERIOD%>" value=""   validate="Recovery Period,float,yes" MAXLENGTH="4" tabindex=1 onblur="calculateMonthlyDeduction()" onkeypress="return isNumber(event)"/>


<label>Monthly Deduction <span>*</span></label>
<input  type="text" name="<%= MONTHLY_DEDUCTION%>" value=""   validate="Monthly Deduction,float,yes" onblur="calculateMonthlyDeduction()" MAXLENGTH="9" tabindex=1 onkeypress="return isNumber(event)"/>

<label>Recovered Amount</label>
<input  type="text" name="<%= RECOVERED_AMOUNT_HEADER%>" value="0.0" readonly="readonly"  validate="Recovery Amount,Float,no" MAXLENGTH="9" tabindex=1 />
 
<div class="clear"></div>



</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('advance','loan?method=saveAdvance','checkAdvanceAmount');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('advance','loan?method=updateAdvance','checkAdvanceAmount','checkAdvanceAmount')" accesskey="u" tabindex=1 />

 <input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('advance','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/> 		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();resetUpdatedValue();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
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
data_header[2][0] = "Advance Code"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=ADVANCE_CODE%>";

data_header[3] = new Array;
data_header[3][0] = "Advance Date"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= ADVANCE_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Advance Amount"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= ADVANCE_AMOUNT %>";

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
data_header[8][0] = "Recovery Mode"
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%=RECOVERY_MODE %>";

data_header[9] = new Array;
data_header[9][0] = "Monthly Deduction"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=MONTHLY_DEDUCTION %>";

data_header[10] = new Array;
data_header[10][0] = "Recovery Amount"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=RECOVERED_AMOUNT_HEADER %>";

data_header[11] = new Array;
data_header[11][0] = "Recovery Period"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=RECOVERY_PERIOD %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS%>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "hiddenEmp";


data_arr = new Array();

<%


Iterator itr=advanceList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrAdvance hrAdvance = (HrAdvance)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrAdvance.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrAdvance.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}
		
%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrAdvance.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][2] = "<%=masEmployee.getServiceNo()%>";
<%
		}
			}
		
%>

data_arr[<%= counter%>][3] = "<%=hrAdvance.getAdvanceCode()%>";
data_arr[<%= counter%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(hrAdvance.getAdvanceDate())%>";
data_arr[<%= counter%>][5] = "<%= hrAdvance.getAdvanceAmount()%>"
data_arr[<%= counter%>][6] = "<%= hrAdvance.getLastChgBy().getEmployee().getFirstName() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrAdvance.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrAdvance.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=hrAdvance.getRecoveryMode() %>"
data_arr[<%= counter%>][10] = "<%=hrAdvance.getMonthlyDeduction()%>"
<%
	if(hrAdvance.getRecoveredAmount()!= null  && !(hrAdvance.getRecoveredAmount().equals(""))){
%>
data_arr[<%= counter%>][11] = "<%=hrAdvance.getRecoveredAmount()%>"
<%
	}else{
%>
data_arr[<%= counter%>][11] = ""
<%
	}
%>
data_arr[<%= counter%>][12] = "<%=hrAdvance.getRecoveryPeriod()%>"

<% 

if(hrAdvance.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrAdvance.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][14] = "<%=masEmployee.getId()%>";
<%
		}
			}
		
%>
<%

counter++;
}
%>


formName = "advance"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
