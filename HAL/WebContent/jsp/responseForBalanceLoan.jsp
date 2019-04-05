<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasLoan"%>
<%@page import="jkt.hms.masters.business.HrLoanHeader"%>
<%@page import="jkt.hms.masters.business.HrLoanDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
			List<HrLoanHeader> loanHeaderList = new ArrayList<HrLoanHeader>();
			List<HrLoanDetail> loanDetailList = new ArrayList<HrLoanDetail>();
			List<HrLoanDetail> maxLoanDetailList = new ArrayList<HrLoanDetail>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(map.get("loanHeaderList")!= null){
				loanHeaderList = (List)map.get("loanHeaderList");
			}
			
			if(map.get("loanDetailList")!= null){
				loanDetailList = (List)map.get("loanDetailList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("gradeList")!= null){
				gradeList = (List)map.get("gradeList");
			}
			if(map.get("departmentList")!= null){
				departmentList = (List)map.get("departmentList");
			}
			if(map.get("maxLoanDetailList")!= null){
				maxLoanDetailList = (List)map.get("maxLoanDetailList");
			}
			BigDecimal balanaceLoan1 = null;
			String refNo = "";
			if(maxLoanDetailList.size()>0){
				HrLoanDetail hrLoanDetail = (HrLoanDetail)maxLoanDetailList.get(0);
				balanaceLoan1 = hrLoanDetail.getBalanceLoan();
				
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			int loanPeriod = 0;
			BigDecimal loanCAmount = null;
			BigDecimal loanPAmount = null;
			BigDecimal installAmount  = null;
			BigDecimal monthInstall  = null;
			BigDecimal balanceLoan1  = null;
			BigDecimal balanceDetail = null;
			int principalPaid = 0;
			BigDecimal prinpaid = null;
			int interestPaid = 0;
			BigDecimal intPaid = null; 
			
			if(maxLoanDetailList.size()>0){
				for(HrLoanDetail hrLoanDetail :maxLoanDetailList){
					loanPeriod = hrLoanDetail.getLoanHeader().getLoanPeriod();
					loanCAmount = hrLoanDetail.getLoanHeader().getLoanCAmount();
					loanPAmount = hrLoanDetail.getLoanHeader().getLoanPAmount();
					installAmount = hrLoanDetail.getInstallAmount();
					balanaceLoan1 = hrLoanDetail.getBalanceLoan();
					  if(balanaceLoan1 != null){
						  balanceDetail = balanaceLoan1;
					  }else{
						  balanceDetail = loanCAmount;
					  }
				}
				
			}else{
				  balanceDetail = loanHeaderList.get(0).getLoanCAmount();
			  }
%>
<%
	for(HrLoanHeader hrLoanHeader :loanHeaderList){
		
		principalPaid = (hrLoanHeader.getLoanPAmount().intValue()/hrLoanHeader.getLoanPeriod());
		prinpaid = new BigDecimal(principalPaid);
		
		interestPaid = ((hrLoanHeader.getLoanCAmount().intValue()/hrLoanHeader.getLoanPeriod())-prinpaid.intValue());
		intPaid = new BigDecimal(interestPaid);
%>

<script type="text/javascript">
	function checkInstallmentAmt(){
		  var installAmt = document.loanDetail.<%= INSTALLMENT_AMOUNT%>.value;
		  var balanceLoan = document.loanDetail.<%= BALANCE_LOAN%>.value;
		  
		  if(installAmt > balanceLoan){
		  alert("Balance Loan is greater than equal to installment Amount")
		  
		   return false;
		 }else if(installAmt = balanceLoan){
		
			 return true;
		 
		 }
		   return true;
		 
		}
</script>

<input type="hidden" id="loanPeriodId" name="<%=LOAN_PERIOD%>"  value="<%=hrLoanHeader.getLoanPeriod()%>" />
<label id=biglabel><span>*</span> Service No.</label>
<input type="text" name="<%= EMPLOYEE_CODE %>" readonly="readonly" id="empCodeId" value="<%=hrLoanHeader.getEmployee().getServiceNo() %>" validate="Service No.,string,yes"  MAXLENGTH="45" tabindex=1  />


<%

		
		
		for(MasEmployee masEmployee : employeeList){
			if(hrLoanHeader.getEmployee().getId().equals(masEmployee.getId())){
				for(MasGrade masGrade :gradeList){
					
			
%>
<%
}
 }
	}
		
	
%>

<!-- <label>Seq.Id<span>*</span> </label> -->
<input  type="hidden" name="<%= SEQUENCE_ID%>" id="seqId" value="<%=hrLoanHeader.getEmployee().getId() %>" readonly="readonly" validate="SeqId,int,yes" MAXLENGTH="40" tabindex=1 />


<label> Department<span>*</span> </label>
<input  type="text" name="<%= DEPARTMENT_NAME%>" id="departmentId" value="<%=hrLoanHeader.getEmployee().getDepartment().getDepartmentName().trim() %>" readonly="readonly" validate="Deaprtment Name,string,yes" MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>
<label>Join Date <span>*</span> </label>
<input type="text" id="joinDateId" name="<%=JOIN_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(hrLoanHeader.getEmployee().getJoinDate()) %>" class="date" readonly="readonly" validate="To date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
</div>
<h4>Loan Details</h4>
<div class="clear"></div>
<div class="Block">

<label id=biglabel> Loan Code <span>*</span></label>
<input  type="text" id="loanCodeId" readonly="readonly" name="<%= LOAN_CODE%>" value="<%=hrLoanHeader.getLoan().getLoanCode()%>" validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 />
<label> Loan Desc. <span>*</span></label>
<input  type="text" id="loanDescId" readonly="readonly" name="<%= LOAN_DESC%>" value="<%=hrLoanHeader.getLoan().getLoanDescription()%>" validate="Loan Desc.,string,yes" MAXLENGTH="40" tabindex=1 />

 <label> Loan Amount <span>*</span></label>
<input  type="text" name="<%= LOAN_P_AMOUNT%>" readonly="readonly" id="loanPAmountId" value="<%=hrLoanHeader.getLoanPAmount()%>"  validate="Loan Amount,float,yes"  MAXLENGTH="7" tabindex=1 />

<div class="clear"></div>
 <label>  Comp.Amount <span>*</span></label>
<input  type="text" name="<%= COMPOUND_AMOUNT%>" readonly="readonly" id="loanCAmountId" value="<%=hrLoanHeader.getLoanCAmount()%>" validate="Loan Comp Amount,float,yes"  MAXLENGTH="16" tabindex=1 />

<label>Install.Date<span>*</span></label>
<input type="text"  name="<%=INSTALLMENT_DATE %>" value="<%=date%> " class="calDate" readonly="readonly" validate="Installment date ,date,yes"  MAXLENGTH="30" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.loanDetail.<%=INSTALLMENT_DATE%>,event)"/> --%>
 <label>Install.Amount <span>*</span></label>
<input  type="text" name="<%= INSTALLMENT_AMOUNT%>" id="installmentId" value="<%=hrLoanHeader.getMonthlyInstall()%>" validate="Installment Amount,Float,no" MAXLENGTH="13" tabindex=1 />
<div class="clear"></div>
<label>Interest Paid <span>*</span></label>
<input  type="text" name="<%= INTEREST_PAID%>" readonly="readonly" value="<%=intPaid %>"   validate="Interest Paid,string,no" MAXLENGTH="13" tabindex=1 />

 
 
<label>Prin. Paid <span>*</span></label>
<input  type="text" name="<%=PRINCIPAL_PAID%>" readonly="readonly" value="<%=prinpaid %>"  validate="Prin.Paid,Float,no" MAXLENGTH="13" tabindex=1 />
<label>Balance Loan <span>*</span></label>
<input  type="text" name="<%= BALANCE_LOAN%>" readonly="readonly" id="balanceLoanId" value="<%=balanceDetail %>" validate="Balance Loan,string,yes"  MAXLENGTH="16" tabindex=1 />
<div class="clear"></div>
<label>Remarks <span>*</span></label>
<%-- <input  type="text" name="<%= REMARK%>" value="" validate="Remark,string,yes" MAXLENGTH="40" tabindex=1 /> --%>
<textarea class="auto" rows="3" cols="76" name="<%= REMARK%>" validate="Remark,string,yes"  MAXLENGTH="200"></textarea>
<div class="clear"></div>
<%
	}
%>
