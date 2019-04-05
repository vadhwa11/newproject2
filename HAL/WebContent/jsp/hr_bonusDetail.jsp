<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrEmployeePayStructure"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.HrMasBonus"%>
<%@page import="jkt.hms.masters.business.HrBonusDetail"%>

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
			List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<HrBonusDetail> bonusDetailList = new ArrayList<HrBonusDetail>();
			List<HrEmployeePayStructure> payStructureElementList = new ArrayList<HrEmployeePayStructure>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("bonusList")!= null){
				bonusList = (List)map.get("bonusList");
			}
			if(map.get("bonusDetailList")!= null){
				bonusDetailList = (List)map.get("bonusDetailList");
			}
			if(map.get("payStructureElementList")!= null){
				payStructureElementList = (List)map.get("payStructureElementList");
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
			/* out.println(message); */
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
	function displayBonusAmount() {
	
		var employeeMaxBasic;
		var empCode ;
		var bonusDesc;
		var fromDate;
		var toDate;
		var maxBasic;
		var maxBasic1;
		var bonusRate;
		var bonusAmount = "";
		var bonus;
		var bonusAmt;
		var employeeId = document.bonusDetail.<%=EMPLOYEE_ID%>.value;
		var bonusId = document.bonusDetail.<%=BONUS_ID%>.value;
		
		if(employeeId != "0" && bonusId != "0" ){
			<%
				 for(HrMasBonus hrMasBonus :bonusList){
				%>
				
			 var dbonusId = '<%=hrMasBonus.getId()%>' 
			 if(bonusId == dbonusId)
			 {
			      bonusDesc = '<%= hrMasBonus.getDescription()%>'
			      fromDate = '<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getFromDate())%>'
			      toDate = '<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getToDate())%>'
			      dueDate = '<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getDueDate())%>'
			      maxBasic = '<%=hrMasBonus.getMaxBasic()%>'
			      bonusRate = '<%=hrMasBonus.getBonusRate()%>'
			      fixedAmount = '<%=hrMasBonus.getFixedAmount()%>'
			      
				<%
			    	if(hrMasBonus.getMaxBasic() == null && hrMasBonus.getBonusRate() == null){
			    %>
					     	bonusAmount = fixedAmount;	
				<%  }
				
					for(HrEmployeePayStructure hrEmployeePayStructure :payStructureElementList){
				%>
				
				  var pEmpId = '<%=hrEmployeePayStructure.getEmployee().getId()%>'
				 
				  if(employeeId == pEmpId){
						maxBasic1 = '<%=hrEmployeePayStructure.getBasicPay()%>'
						empCode = '<%=hrEmployeePayStructure.getEmployee().getServiceNo()%>'	
				    
		     		<% if(hrMasBonus.getBonusRate() == null){
		     				if(hrMasBonus.getMaxBasic() != null && hrEmployeePayStructure.getBasicPay() != null){
			     				if(hrMasBonus.getMaxBasic().intValue()<= hrEmployeePayStructure.getBasicPay().intValue()){
			     			%>
			     				bonusAmount = fixedAmount;	
			     		<%		}
			     			}
			     		}else if(hrMasBonus.getFixedAmount() == null){
				    %>
				    		bonus = '<%=new BigDecimal((hrMasBonus.getMaxBasic().floatValue() * hrMasBonus.getBonusRate())/100) %>'
			    			bonusAmount = bonus;

				 		<%}%>
			     	}
			     	else{
							document.bonusDetail.<%=BONUS_AMOUNT%>.value = ""; 
							
			
			}
			  <%}%>
			  				document.bonusDetail.<%=BONUS_AMOUNT%>.value = bonusAmount; 
							document.bonusDetail.<%=FROM_DATE%>.value = fromDate;
							document.bonusDetail.<%=TO_DATE%>.value = toDate;
							document.bonusDetail.<%=BONUS_DESC%>.value = bonusDesc;
							document.bonusDetail.<%=DUE_DATE%>.value = dueDate;
							document.bonusDetail.<%=BONUS_AMOUNT%>.value = fixedAmount;
			}
			<%}%> 
					
							   	
			  
		}
	}

	function checkPaidDate(){
		var pDate = document.bonusDetail.<%= PAID_DATE%>.value;
		var dDate = document.bonusDetail.<%= DUE_DATE %>.value;
	
		var	paidDate =new Date(pDate.substring(6),(pDate.substring(3,5) - 1) ,pDate.substring(0,2))
		var dueDate =new Date(dDate.substring(6),(dDate.substring(3,5) - 1) ,dDate.substring(0,2))
		if(dueDate > paidDate)
		{
			alert("Due Date is greater than or equal to  Paid Date.");
			document.bonusDetail.<%= PAID_DATE%>.value = "";
			
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
</script>
<% if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<div class="titleBg"><h2>Bonus Detail</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= BONUS_DETAIL_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=BONUS_ID%>"],[4,"<%= BONUS_DESC%>"],[5,"<%= FROM_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=TO_DATE%>"],
[10,"<%=BONUS_AMOUNT%>"],[11,"<%=PAID_DATE%>"],[12,"<%=DUE_DATE%>"],[13,"<%=REMARK%>"],[14,"<%=STATUS%>"]];
statusTd = 14;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="bonusDetail" method="post" action="">

<div class="Block">

<label> Employee Name <span>*</span></label>
<select id="employeeId" name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes" onchange="displayBonusAmount();displayValues(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+ (masEmployee.getLastName() != null ? masEmployee.getLastName() :"")%></option>
<%
	}
%>
</select>
<label> Bonus Code <span>*</span></label>
<select id="bonusId" name="<%=BONUS_ID %>" validate="Bonus Code,string,yes" onchange="displayBonusAmount();" class="mediumm">
<option value="0">Select</option>
<%
    
	for(HrMasBonus hrMasBonus :bonusList){
%>
<option value="<%=hrMasBonus.getId() %>"><%=hrMasBonus.getBonusCode()%></option>
<%
	}
%>
</select>
<label id=biglabel> Employee Code <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId"   readonly="readonly" type="text" />
<div class="clear"></div>
<label>Bonus Desc <span>*</span></label>
<input  type="text" id="bonusDescId" name="<%= BONUS_DESC%>" readonly="readonly" value=""  tabindex=1 />

<label>From Date <span>*</span></label>
<input type="text" id="fromDateId"  name="<%=FROM_DATE %>" value="" class="calDate" readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.bonusDetail.<%=FROM_DATE%>,event)"/> --%>
 

<label>To Date <span>*</span></label>
<input type="text" id="toDateId" name="<%=TO_DATE %>" value="" class="calDate" readonly="readonly" validate="To date ,date,yes"  MAXLENGTH="30" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.bonusDetail.<%=TO_DATE%>,event)"/> --%>
 
 
 <div class="clear"></div>
 

<label>Bonus Amount <span>*</span></label>
<input id="bonusAmountId" type="text" name="<%= BONUS_AMOUNT%>" value="" readonly="readonly"  validate="Bonus Amount,Float,yes" MAXLENGTH="9" tabindex=1 />


<label>Paid Date</label>
<input type="text"  name="<%=PAID_DATE %>" value="" class="calDate"  validate="Paid date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'fd');" />
<%--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.bonusDetail.<%=PAID_DATE%>,event)"/> --%>

<label>Due Date</label>
<input type="text" id="dueDateId"  name="<%=DUE_DATE %>" value="" class="date" readonly="readonly" validate="Due date ,date,yes"  MAXLENGTH="30" />
 
<div class="clear"></div>

<label>Remarks <span>*</span></label>
<input  type="text" name="<%= REMARK%>" value="" validate="Remark,string,yes" MAXLENGTH="40" tabindex=1 />
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= BONUS_DETAIL_ID%>" value="" />
</div>

<div class="division"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('bonusDetail','loan?method=saveBonusDetail','checkFromDate','checkPaidDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('bonusDetail','loan?method=updateBonusDetail','checkFromDate','checkPaidDate')" accesskey="u" tabindex=1 />

<input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
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
data_header[2][0] = "Bonus Code"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=BONUS_ID%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "<%= BONUS_DESC %>";

data_header[4] = new Array;
data_header[4][0] = "From Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= FROM_DATE %>";

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
data_header[8][0] = "To Date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=TO_DATE %>";

data_header[9] = new Array;
data_header[9][0] = "Bonus Amt"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=BONUS_AMOUNT %>";

data_header[10] = new Array;
data_header[10][0] = "Paid Date"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=PAID_DATE %>";

data_header[11] = new Array;
data_header[11][0] = "Due Date"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=DUE_DATE %>";


data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=REMARK %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=STATUS%>";



data_arr = new Array();

<%


Iterator itr=bonusDetailList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrBonusDetail hrBonusDetail= (HrBonusDetail)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrBonusDetail.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrBonusDetail.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}
		
%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrBonusDetail.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][2] = "<%=masEmployee.getServiceNo()%>";
<%
		}
			}
		
%>
<%
	
			for(HrMasBonus hrMasBonus :bonusList){
				if(hrBonusDetail.getBonus().getId().equals(hrMasBonus.getId())){
%>
data_arr[<%= counter%>][3] = "<%=hrMasBonus.getBonusCode()%>";
<%
		}
			}
		
%>
<%
	
			for(HrMasBonus hrMasBonus :bonusList){
				if(hrBonusDetail.getBonus().getId().equals(hrMasBonus.getId())){
%>
data_arr[<%= counter%>][4] = "<%=hrMasBonus.getDescription()%>";
<%
		}
			}
		
%>



data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrBonusDetail.getFromDate())%>"
data_arr[<%= counter%>][6] = "<%= hrBonusDetail.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrBonusDetail.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrBonusDetail.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hrBonusDetail.getToDate()) %>"
data_arr[<%= counter%>][10] = "<%= hrBonusDetail.getBonusAmount()%>"
data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(hrBonusDetail.getPaidDate())%>"
data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(hrBonusDetail.getDueDate())%>"


data_arr[<%= counter%>][13] = "<%=hrBonusDetail.getRemarks() %>"


<% 

if(hrBonusDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][14] = "Active"
<%}else{%>
data_arr[<%= counter%>][14] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "bonusDetail"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
