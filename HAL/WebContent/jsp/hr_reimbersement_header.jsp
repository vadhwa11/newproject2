<%@ page import="static jkt.hms.util.RequestConstants.*" %> 
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.HrMasReimbersement"%>
<%@page import="jkt.hms.masters.business.HrReimbHeader"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
			List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("reimbList")!= null){
				reimbList = (List)map.get("reimbList");
			}
			if(map.get("reimbHeaderList")!= null){
				reimbHeaderList = (List)map.get("reimbHeaderList");
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
			}
%>





<script type="text/javascript">
	
	function display(idvalue) {
	<%
	for(MasEmployee masEmployee :employeeList){
		int id = masEmployee.getId();
		
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= masEmployee.getEmployeeCode()%>'
    document.getElementById('empCodeId').value = '<%= masEmployee.getServiceNo()%>'
	
	}
<%
	}
	
%>	

}

function displayReimb(idvalue) {
	<%
	for(HrMasReimbersement hrMasReimbersement:reimbList){
		int id = hrMasReimbersement.getId();
		
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('reimbNameId').value = '<%= hrMasReimbersement.getReimbDesc()%>'
    	 document.getElementById('maximumAmount').value = '<%= hrMasReimbersement.getMaxAmount()%>'
	
	
	}
<%
	}
	
%>	

}

function checkFromDate(){
		var fDate = document.reimbHeader.<%= FROM_DATE%>.value;
		var tDate = document.reimbHeader.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert(" From Date is greater than  To Date.");
			document.reimbDetail.<%= FROM_DATE%>.value = "";
			document.reimbDetail.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	function checkTotalReimbAmt(){
	  var maxAmt = document.reimbHeader.<%= MAXIMUM_AMOUNT%>.value;
	  var totalReimbAmt = document.reimbHeader.<%= TOTAL_REIMB_AMOUNT%>.value;
	  
	  if(parseFloat(totalReimbAmt) > parseFloat(maxAmt)){
	  alert("Max Amount is greater than equal to Total Reimb.Amount")
	  document.reimbHeader.<%= MAXIMUM_AMOUNT%>.value = "";
	  document.reimbHeader.<%= TOTAL_REIMB_AMOUNT%>.value = "";
	   return false;
	 }else if(parseFloat(totalReimbAmt) == parseFloat(maxAmt)){
	
		 return true;
	 
	 }else{
	   return true;
	   }
	 
	}
	
	
	 function checkMaxAmount(){
	  var maxAmt = document.reimbHeader.<%= MAXIMUM_AMOUNT%>.value;
	   var totalReimbAmt = document.reimbHeader.<%= TOTAL_REIMB_AMOUNT%>.value;
	  if(maxAmt == 0 ){
	  	alert("Maximum Amount should not be zero");
	  	document.reimbHeader.<%=MAXIMUM_AMOUNT%>.value == "";
	  	return false;
	  }else if(totalReimbAmt == 0){
	  	alert("Total Reimb Amount should not be zero");
	  	document.reimbHeader.<%=TOTAL_REIMB_AMOUNT%>.value == "";
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
<div class="titleBg"><h2>Reimbursement Header</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= REIMB_HEADER_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= FROM_DATE %>"],[3,"<%=TO_DATE%>"],[4,"<%= REIMBERSEMENT_ID%>"],[5,"<%= PAY_MODE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],
[9,"<%=EMPLOYEE_CODE%>"],[10,"<%=REIMBERSEMENT_DESC%>"],[11,"<%=REIMB_STATUS%>"],[12,"<%=MAXIMUM_AMOUNT%>"],[13,"<%=REMARK%>"],[14,"<%=TOTAL_REIMB_AMOUNT%>"],[15,"<%=STATUS%>"]];
statusTd = 15;
</script>
</div>

<%if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="division"></div>

<form name="reimbHeader" method="post" action="">
<div class="Block">


<label id=biglabel> Employee Name <span>*</span></label>
<select name="<%=EMPLOYEE_ID %>" validate="Employee Name,string,yes" onchange="display(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){

%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+(masEmployee.getLastName() != null ? masEmployee.getLastName()  :"")%></option>
<%
	}
%>
</select>

<label id=biglabel> Employee No. <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId" validate="Service No.,string,yes" readonly="readonly" type="text" />
 <label id=biglabel> Pay Mode <span>*</span></label>
<select name="<%=PAY_MODE%>" validate="Pay Mod,string,yes"  class="mediumm">
<option value="0">Select</option>
<option value="Cheque">Cheque</option>
<option value="Salary">Bank Transfer</option>
<option value="Cash">Cash</option>
</select>
<div class="clear"></div>
<label> From Date <span>*</span></label>
<input type="text" id="joinDateId" name="<%=FROM_DATE %>" value="" class="calDate"  validate="From date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.reimbHeader.<%=FROM_DATE%>,event)"/> --%>
 
<label> To Date <span>*</span></label>
<input type="text" id="todate" name="<%=TO_DATE %>" value="" class="calDate"  validate="To date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
<%--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.reimbHeader.<%=TO_DATE%>,event)"/> --%>
<label id=biglabel> Reimbursement Code <span>*</span></label>
<select name="<%=REIMBERSEMENT_ID%>" validate="Reimb Code,string,yes" onchange="displayReimb(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(HrMasReimbersement hrMasReimbersement :reimbList){

%>
<option value="<%=hrMasReimbersement.getId() %>"><%=hrMasReimbersement.getReimbCode()%></option>
<%
	}
%>
</select>
 <div class="clear"></div>
<label>Reimbursement Desc <span>*</span></label>
<input  type="text" id="reimbNameId" name="<%= REIMBERSEMENT_DESC%>" validate="Reimb Desc,String,yes" readonly="readonly" value=""  tabindex=1 />

 <label>Max.Amount <span>*</span></label>
<input  type="text" name="<%= MAXIMUM_AMOUNT%>"  readonly  id="<%= MAXIMUM_AMOUNT%>"value="" validate="Max.Amount,Float,yes" MAXLENGTH="9" tabindex=1 />
 
<label>Total Claim Amount <span>*</span></label>
<input  type="text" name="<%= TOTAL_REIMB_AMOUNT%>" value="" validate="Total Reimb.Amt.,Float,yes" MAXLENGTH="9" tabindex=1 />

 <div class="clear"></div>
<label>Reimburse Status <span>*</span></label>
<select name="<%=REIMB_STATUS%>" validate="Reimb Status,string,yes"  class="mediumm">
<option value="0">Select</option>
<option value="Open">Open</option>
<option value="Close">Close</option>
</select>
<label>Remarks</label>
<%-- <input  type="text" name="<%= REMARK%>" value="" validate="Remark.,string,no" MAXLENGTH="35" tabindex=1 /> --%>
<textarea class="auto" rows="3" cols="76" name="<%= REMARK%>"  MAXLENGTH="200"></textarea>

<div class="clear"></div>

</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('reimbHeader','loan?method=saveReimbHeader','checkFromDate','checkTotalReimbAmt','checkMaxAmount');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;"  onClick="submitForm('reimbHeader','loan?method=updateReimbHeader','checkFromDate','checkTotalReimbAmt','checkMaxAmount');" accesskey="u" tabindex=1 />

<input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;"  onClick="submitForm('reimbHeader','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= REIMB_HEADER_ID%>" value="" />
<input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
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

</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= EMPLOYEE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "From date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= FROM_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "To Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=TO_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Reimb.Code"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= REIMBERSEMENT_ID %>";

data_header[4] = new Array;
data_header[4][0] = "PayMode"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PAY_MODE %>";

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
data_header[9][3] = "<%=REIMBERSEMENT_DESC %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=REIMB_STATUS %>";

data_header[11] = new Array;
data_header[11][0] = "Max.Amt."
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=MAXIMUM_AMOUNT %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=REMARK %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=TOTAL_REIMB_AMOUNT %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=STATUS%>";




data_arr = new Array();

<%


Iterator itr=reimbHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrReimbHeader hrReimbHeader= (HrReimbHeader)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrReimbHeader.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrReimbHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}
		
%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(hrReimbHeader.getFromDate())%>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(hrReimbHeader.getToDate())%>"

<%
	for(HrMasReimbersement hrMasReimbersement :reimbList){
		if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId()) ){
%>
data_arr[<%= counter%>][4] = "<%= hrMasReimbersement.getReimbCode()%>"
<% 
		}else if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId()) ){
%>
data_arr[<%= counter%>][4] = <%=hrMasReimbersement.getReimbCode()%>"
<% 
	}
   }		
		
%>
data_arr[<%= counter%>][5] = "<%= hrReimbHeader.getPaymode()%>"
data_arr[<%= counter%>][6] = "<%= hrReimbHeader.getLastChgBy().getFirstName() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrReimbHeader.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrReimbHeader.getLastChgTime() %>"

<%
	for(MasEmployee masEmployee :employeeList){
		if(hrReimbHeader.getEmployee().getId().equals(masEmployee.getId()) ){
%>
data_arr[<%= counter%>][9] = "<%= masEmployee.getServiceNo()%>"
<% 
		}else if(hrReimbHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][9] = <%=masEmployee.getServiceNo()%>"
<% 
	}
   }		
		
%>
<%
	for(HrMasReimbersement hrMasReimbersement :reimbList){
		if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId()) ){
%>
data_arr[<%= counter%>][10] = "<%= hrMasReimbersement.getReimbDesc()%>"
<% 
		}else if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId()) ){
%>
data_arr[<%= counter%>][10] = <%=hrMasReimbersement.getReimbDesc()%>"
<% 
	}
   }		
		
%>
data_arr[<%= counter%>][11] = "<%= hrReimbHeader.getReimbStatus() %>"
data_arr[<%= counter%>][12] = "<%= hrReimbHeader.getMaxAmount() %>"
data_arr[<%= counter%>][13] = "<%=hrReimbHeader.getRemark() %>"
<%
	if(hrReimbHeader.getTotalReimbAmt() != null){
%>
data_arr[<%= counter%>][14] = "<%= hrReimbHeader.getTotalReimbAmt() %>"
<% }else{ %>
data_arr[<%= counter%>][14] = ""
<% } %>

<% 
if(hrReimbHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][15] = "Active"
<%}else{%>
data_arr[<%= counter%>][15] = "InActive"

<%}%>
 <% counter++;} %>
	


formName = "reimbHeader"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
