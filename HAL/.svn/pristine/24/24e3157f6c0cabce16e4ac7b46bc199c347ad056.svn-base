<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasLoan"%>
<%@page import="jkt.hms.masters.business.HrLoanHeader"%>
<%@page import="jkt.hms.masters.business.HrLoanDetail"%>
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
			List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
			List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("loanList")!= null){
				loanList = (List)map.get("loanList");
			}
			if(map.get("loanHeaderList")!= null){
				loanHeaderList = (List)map.get("loanHeaderList");
			}
			if(map.get("departmentList")!= null){
				departmentList = (List)map.get("departmentList");
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
			}
%>



<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<script> 
	

function displayLoanDesc(idvalue,displayFieldName){
<%
	for(HrMasLoan hrMasLoan:loanList){
		int loanId = hrMasLoan.getId();
		
	%>
	if(idvalue == <%=loanId%> ){
    document.getElementById(displayFieldName).value = '<%= hrMasLoan.getLoanDescription()%>'
   	document.getElementById("loanInterest").value = '<%= hrMasLoan.getInterestPercent()%>'
	}
<%
	}%>

}
		
	
	function calculateCompInterest()
	{
		var pAmount = document.loanHeader.<%=LOAN_P_AMOUNT%>.value;
		var period = document.loanHeader.<%=LOAN_PERIOD%>.value; 
		var interestRate = document.loanHeader.<%=LOAN_INTEREST%>.value;
		
	if(period != "" && pAmount!="" && interestRate != "" )
	{
		var loanPeriod = parseFloat(period);
		var loanAmount = parseFloat(pAmount);
		var interest = parseFloat(interestRate);
		var rateOfInt =loanPeriod/12; 
		var cAmount =Math.pow((1+interest/100),rateOfInt);
		var total =(loanAmount*cAmount).toFixed(2); 
		document.loanHeader.<%=COMPOUND_AMOUNT%>.value=total;
	
	   }else if( period != "" && pAmount!="" && interestRate == "" ){
	   
	  	 var loanAmount = parseFloat(pAmount);
	  	 document.loanHeader.<%=COMPOUND_AMOUNT%>.value=loanAmount;
	 }
	}
	
	
	   function monthlyInsatallment()
	   {
			 var period =(document.loanHeader.<%=LOAN_PERIOD%>.value);
			 var cAmount = document.loanHeader.<%=COMPOUND_AMOUNT%>.value;
			 var loanpAmount = document.loanHeader.<%=LOAN_P_AMOUNT%>.value;
	   if(period != "" && cAmount!=""&& loanpAmount != "" )
	    {
			var loanPeriod=parseFloat(period);
			var loanCompAmount = parseFloat(cAmount);
			var loanPAmount = parseFloat(loanpAmount);
			var monthlyInstall=(loanCompAmount/loanPeriod).toFixed(2);
			
			document.loanHeader.<%=MONTHLY_INSTALLMENT%>.value=monthlyInstall;
			
		}
		
   }
   function checkLoanPeriod(val){
     if(validateFloat(val)){
     	if(parseFloat(val)> 120){
     		alert("Loan Period  value should not greater than 120")
	     document.loanHeader.<%=LOAN_PERIOD%>.value = "";
	     return false;
	    }
	  }else{
	  	alert("Enter Valid Loan Period Value.");
	  	document.loanHeader.<%=LOAN_PERIOD%>.value = "";
	  	return false;
	  }
     return true;
     }
     
     function checkInterst(val){
     if(validateFloat(val)){
     	if(parseFloat(val)> 100){
     		alert("Interst value should not greater than 100")
	     document.loanHeader.<%=LOAN_INTEREST%>.value = "";
	     return false;
	    }
	  }else{
	  	alert("Enter Valid Interest Value.");
	  	document.loanHeader.<%=LOAN_INTEREST%>.value = "";
	  	return false;
	  }
     return true;
     }
   
   function checkIntDate(){
		var lDate = document.loanHeader.<%= LOAN_DATE%>.value;
		var iDate = document.loanHeader.<%= INTEREST_DATE %>.value;
	
		var	loanDate =new Date(lDate.substring(6),(lDate.substring(3,5) - 1) ,lDate.substring(0,2))
		var intDate =new Date(iDate.substring(6),(iDate.substring(3,5) - 1) ,iDate.substring(0,2))
		if(iDate != "" && lDate != ""){
		if(intDate < loanDate)
		{
			alert("Interest Date  should be  greater than or equal to the Loan Date.");
			document.loanHeader.<%= LOAN_DATE%>.value = "";
			document.loanHeader.<%= INTEREST_DATE %>.value = "";
			return false;
			}
		}
		return true;
	}
	
	 function checkPaymentDate(){
		var paymentDate = document.loanHeader.<%= LAST_PAYMENT_DATE%>.value;
		var iDate = document.loanHeader.<%= INTEREST_DATE %>.value;
	
		var	payDate =new Date(paymentDate.substring(6),(paymentDate.substring(3,5) - 1) ,paymentDate.substring(0,2))
		var intDate =new Date(iDate.substring(6),(iDate.substring(3,5) - 1) ,iDate.substring(0,2))
		if(iDate != "" && paymentDate != ""){
		if(paymentDate < intDate)
		{
			alert("LastPayment Date  should be  greater than or equal to the Interst Date.");
			document.loanHeader.<%= LAST_PAYMENT_DATE%>.value = "";
			document.loanHeader.<%= INTEREST_DATE %>.value = "";
			return false;
			}
		}
		return true;
	}	
	
	function checkLoanAmount(){
	  if(parseInt(document.loanHeader.<%=LOAN_P_AMOUNT%>.value) == 0){
	  	alert("Loan Amount should not be zero");
	  	document.loanHeader.<%=LOAN_P_AMOUNT%>.value == "";
	  	return false;
	  }
	  return true;
	  }

</script>
<div class="clear"></div>
<div class="titleBg"><h2>Loan Header</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>


<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%=LOAN_P_AMOUNT%>"], [2,"<%= LOAN_ID %>"],[3,"<%=EMPLOYEE_ID%>"],[4,"<%= LOAN_PERIOD%>"],[5,"<%= LAST_PAYMENT_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=EMPLOYEE_CODE%>"],
[10,"<%=JOIN_DATE%>"],[11,"<%=LOAN_DATE%>"],[12,"<%=LOAN_INTEREST%>"],[13,"<%=COMPOUND_AMOUNT%>"],[14,"<%=INTEREST_DATE%>"],[15,"<%=MONTHLY_INSTALLMENT%>"],[16,"<%=BALANCE_LOAN%>"],
[17,"<%=LOAN_STATUS%>"],[18,"<%=DEDUCT_FROM%>"],[19,"<%=LOAN_DESC%>"],[20,"<%=STATUS%>"],[21,"<%=SEQUENCE_ID%>"],[22,"<%=DEPARTMENT_NAME%>"],[23,"Recoverd_Loan"]];
statusTd = 20;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<%if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<form name="loanHeader" method="post" action="">
<h4>Employee Details</h4>
<div class="clear"></div>
<div class="Block">
<label> Employee Name <span>*</span></label>
<select name="<%=EMPLOYEE_ID %>" validate="Employee Name,string,yes" onchange="display(this.value);">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){

%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+(masEmployee.getLastName() != null ? masEmployee.getLastName() :"")%></option>
<%
	}
%>
</select>
<script type="text/javascript">
function display(idvalue) {
	
	<%
	for(MasEmployee masEmployee :employeeList){
		int id = masEmployee.getId();
		
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= masEmployee.getServiceNo()%>'
	document.getElementById('seqId').value = '<%=masEmployee.getId() %>'
	<%if(masEmployee.getDepartment()!=null){%>
	document.getElementById('departmentId').value = '<%=masEmployee.getDepartment().getDepartmentName() %>'
	<%}%>
	<%if(masEmployee.getJoinDate()!=null){%>
	document.getElementById('joinDateId').value = '<%=HMSUtil.convertDateToStringWithoutTime(masEmployee.getJoinDate()) %>'
	<%}%>
	}
<%
	}
	
%>	

}
</script>
<label id=biglabel> Employee No. <span>*</span></label>
<input type="text" name="<%= EMPLOYEE_CODE %>" readonly="readonly" id="empCodeId" value="" validate="Service No.,string,yes"  MAXLENGTH="45" tabindex=1  />



<!-- <label><span>*</span> Seq.Id</label> -->
<input  type="hidden" name="<%= SEQUENCE_ID%>" id="seqId" value="" readonly="readonly" validate="SeqId,int,yes" MAXLENGTH="40" tabindex=1 />

<label> Department <span>*</span></label>
<input  type="text" name="<%= DEPARTMENT_NAME%>" id="departmentId" value="" readonly="readonly" validate="Deaprtment Name,string,yes" MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>

<label>Emp Joining date <span>*</span></label>
<input type="text" id="joinDateId" name="<%=JOIN_DATE %>" value="" class="calDate" readonly="readonly" validate="Join date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
</div>
<h4>Loan Details</h4>
<div class="clear"></div>
<div class="Block">


<label id=biglabel> Loan Code <span>*</span></label>
<select name="<%=LOAN_ID%>" validate="Loan Code,string,yes" onchange="displayLoanDesc(this.value,'loandescId')"  class="mediumm">
<option value="0">Select</option>
<%
	for(HrMasLoan hrMasLoan :loanList){

%>
<option value="<%=hrMasLoan.getId() %>"><%=hrMasLoan.getLoanCode() %></option>
<%
	}
%>
</select>


<label> Loan Desc. <span>*</span></label>
<input  type="text" id="loandescId" readonly="readonly" name="<%= LOAN_DESC%>" value="" validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 />
<script>
document.loanHeader.<%=LOAN_DESC%>.focus();
</script>

<label> Loan Date <span>*</span></label>
<input type="text" id="loanDate" name="<%=LOAN_DATE %>" value="" class="calDate"  validate="Loan date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
<%--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.loanHeader.<%=LOAN_DATE%>,event)"/> --%>
 <div class="clear"></div>
 
 <label> Loan Amount <span>*</span></label>
<input  type="text" name="<%= LOAN_P_AMOUNT%>" value="" validate="Loan Amount,float,yes"  onblur="calculateCompInterest()"   MAXLENGTH="7" tabindex=1 />
<label>Loan Period - Months <span>*</span></label>
<input  type="text" name="<%= LOAN_PERIOD%>" value="" validate="Loan Period,float,yes"  onblur="calculateCompInterest(),monthlyInsatallment(),checkLoanPeriod(this.value)"  MAXLENGTH="6" tabindex=1 />


<label>Interest%</label>
<input  readonly type="text" name="<%= LOAN_INTEREST%>" id="loanInterest" value="" validate="Interest,Float,no"  onblur="calculateCompInterest(),checkInterst(this.value)" MAXLENGTH="5" tabindex=1 />
<div class="clear"></div>

<label>C.Amount <span>*</span></label>
<input  type="text" name="<%= COMPOUND_AMOUNT%>" value="" validate="C.Amount,Float,no" readonly="readonly" onblur="monthlyInsatallment()" MAXLENGTH="16" tabindex=1 />
<label>Int.Date <span>*</span></label>
<input type="text"  name="<%=INTEREST_DATE %>" value="" class="calDate"  validate="Interest date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');"/>
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.loanHeader.<%=INTEREST_DATE%>,event)"/> --%>
 
 <label>Mon.Installment <span>*</span></label>
<input  type="text" name="<%= MONTHLY_INSTALLMENT%>" value="" readonly="readonly" validate="Monthly Installment,string,yes" MAXLENGTH="13" tabindex=1 />

<div class="clear"></div>
 
<label>Balance Loan</label>
<input  type="text" name="<%= BALANCE_LOAN%>" value="0.0" validate="Balance Loan,string,no" readonly="readonly" MAXLENGTH="9" tabindex=1 />

<label>Recoverd Loan</label>
<input  type="text" name="Recoverd_Loan" value="0.0" validate="Recoverd Loan,string,no" readonly="readonly" MAXLENGTH="9" tabindex=1 />

<label id=biglabel> Loan Status <span>*</span></label>
<select name="<%=LOAN_STATUS%>" validate="Loan Status,string,yes"  class="mediumm">
<option value="0">Select</option>
<option value="open">open</option>
<option value="close">close</option>
</select>

<div class="clear"></div>

<label>Last Payment Date</label>
<input type="text"  name="<%=LAST_PAYMENT_DATE %>"  value="" class="calDate" readonly="readonly" validate="Last Payment date ,date,no"  MAXLENGTH="30" />
 <%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.loanHeader.<%=LAST_PAYMENT_DATE%>,event)"/> --%>
 

<label id=biglabel> Deduct From <span>*</span></label>
<select name="<%=DEDUCT_FROM%>" validate="Deduct From,string,yes" >
<option value="0">Select</option>
<option value="salary">Salary</option>
<option value="payment">Payment</option>
</select>

<div class="clear"></div>
</div>

<div class="division"></div>
<div id="edited"></div>


<input type="button" name="add" id="addbutton"  value="Add" class="button" onClick="submitForm('loanHeader','loan?method=saveLoanHeader','checkIntDate','checkPaymentDate','checkLoanAmount');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('loanHeader','loan?method=updateLoanHeader','checkIntDate','checkPaymentDate','checkLoanAmount')" accesskey="u" tabindex=1 />

<input type="hidden" name="Delete" id="deletebutton" value="Activate" style="display: none;"  class="button" onClick="submitForm('payroll','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset"  value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
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


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />


</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "L.P.Amount"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= LOAN_P_AMOUNT %>";

data_header[1] = new Array;
data_header[1][0] = "Loan Code"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= LOAN_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Emp.Name"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=EMPLOYEE_ID%>";

data_header[3] = new Array;
data_header[3][0] = "L.Period"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= LOAN_PERIOD %>";

data_header[4] = new Array;
data_header[4][0] = "LastPay.Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= LAST_PAYMENT_DATE %>";

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
data_header[8][2] = "15%";
data_header[8][3] = "<%=EMPLOYEE_CODE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=JOIN_DATE %>";


data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=LOAN_DATE %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=LOAN_INTEREST %>";

data_header[12] = new Array;
data_header[12][0] = "Comp. amount"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%=COMPOUND_AMOUNT %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=INTEREST_DATE %>";

data_header[14] = new Array;
data_header[14][0] = "Mon.installment"
data_header[14][1] = "data";
data_header[14][2] = "15%";
data_header[14][3] = "<%=MONTHLY_INSTALLMENT %>";

data_header[15] = new Array;
data_header[15][0] = "Balance Loan"
data_header[15][1] = "data";
data_header[15][2] = "15%";
data_header[15][3] = "<%=BALANCE_LOAN %>";

data_header[16] = new Array;
data_header[16][0] = "Loan Status"
data_header[16][1] = "data";
data_header[16][2] = "15%";
data_header[16][3] = "<%=LOAN_STATUS %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "<%=DEDUCT_FROM %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "<%=LOAN_DESC %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "<%=STATUS %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "15%";
data_header[20][3] = "<%=SEQUENCE_ID %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "15%";
data_header[21][3] = "<%=DEPARTMENT_NAME %>";


data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "Recoverd_Loan";

data_arr = new Array();

<%
Iterator itr=loanHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrLoanHeader hrLoanHeader= (HrLoanHeader )itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrLoanHeader.getId()%>
data_arr[<%= counter%>][1] = "<%= hrLoanHeader.getLoanPAmount()%>"

<%
	for(HrMasLoan hrMasLoan :loanList){
		if(hrLoanHeader.getLoan().getId().equals(hrMasLoan.getId())){
%>
data_arr[<%= counter%>][2] = "<%= hrMasLoan.getLoanCode()%>"
<%
	}
   }		
		
%>
<%
	for(MasEmployee masEmployee :employeeList){
		
		if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][3] = "<%= masEmployee.getFirstName()+" "+masEmployee.getLastName()%>"

<% 
	}
   }		
		
%>
data_arr[<%= counter%>][4] = "<%= hrLoanHeader.getLoanPeriod()%>"
<%
	if(hrLoanHeader.getLastPaymentDate() != null && !(hrLoanHeader.getLastPaymentDate().equals(""))){
%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getLastPaymentDate())%>"
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>
data_arr[<%= counter%>][6] = "<%= hrLoanHeader.getLastChgBy().getFirstName() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrLoanHeader.getLastChgTime() %>"

<%
	for(MasEmployee masEmployee :employeeList){
		if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][9] = "<%= masEmployee.getServiceNo()%>"

<% 
	}
   }		
		
%>
<%
	for(MasEmployee masEmployee :employeeList){
		if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){			
%>
<% if(masEmployee.getJoinDate() != null){%>

data_arr[<%= counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(masEmployee.getJoinDate()) %>"
<%}else{%>
data_arr[<%= counter%>][10] = "";
<%}%>


<% 
	}
   }		
		
%>
data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getLoanDate()) %>"
<%
	if( hrLoanHeader.getLoanInterest()!= null){
%>
data_arr[<%= counter%>][12] = "<%= hrLoanHeader.getLoanInterest() %>"
<%}else{ %>
data_arr[<%= counter%>][12] = "";
<% } %>
data_arr[<%= counter%>][13] = "<%= hrLoanHeader.getLoanCAmount() %>"
data_arr[<%= counter%>][14] = "<%=HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getLoanInterestDate()) %>"
data_arr[<%= counter%>][15] = "<%= hrLoanHeader.getMonthlyInstall() %>"
<%
	if(hrLoanHeader.getBalanceLoan() != null && !(hrLoanHeader.getBalanceLoan().equals("")) ){
%>
data_arr[<%= counter%>][16] = "<%= hrLoanHeader.getBalanceLoan() %>"
<%
	}else{
%>
data_arr[<%= counter%>][16] = ""
<%
	}
%>
data_arr[<%= counter%>][17] = "<%= hrLoanHeader.getLoanStatus() %>"
data_arr[<%= counter%>][18] = "<%= hrLoanHeader.getDeductFrom() %>"
<%
	for(HrMasLoan hrMasLoan :loanList){
		if(hrLoanHeader.getLoan().getId().equals(hrMasLoan.getId())){
%>
data_arr[<%= counter%>][19] = "<%= hrMasLoan.getLoanDescription()%>"
<%
	}
   }		
		
%>
<% 

if(hrLoanHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][20] = "Active"
<%}else{%>
data_arr[<%= counter%>][20] = "InActive"
<%}%>

<%
	for(MasEmployee masEmployee :employeeList){
		if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][21] = "<%=masEmployee.getId() %>"

<% 
	}
   }		
		
%>

<%
	
		
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId() == masEmployee.getId()){
				for(MasDepartment masDepartment :departmentList){
					if(masEmployee.getDepartment().getId() == masDepartment.getId()){
				
%>
data_arr[<%= counter%>][22] = "<%= masEmployee.getDepartment().getDepartmentName().trim() %>"
<%}
}
 }
	}
		
%>
data_arr[<%= counter%>][23] = "<%=hrLoanHeader.getLoanCAmount().subtract( hrLoanHeader.getBalanceLoan() )%>"


<%

counter++;
}
%>


formName = "loanHeader"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
