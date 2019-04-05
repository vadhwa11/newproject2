<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrReimbDetail"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.HrReimbHeader"%>
<script type="text/javascript" language="javascript" src="../jsp/js/hms.js"></script>

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
			List<HrReimbHeader> reimbHeaderList = new ArrayList<HrReimbHeader>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<HrReimbDetail> reimDetailList = new ArrayList<HrReimbDetail>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("reimDetailList")!= null){
				reimDetailList = (List)map.get("reimDetailList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("reimbHeaderList")!= null){
				reimbHeaderList = (List)map.get("reimbHeaderList");
			}
			if(map.get("reimbList")!= null){
				reimbList = (List)map.get("reimbList");
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





<%@page import="jkt.hms.masters.business.HrMasReimbersement"%>
<script type="text/javascript">
	


function displayValues(idvalue) {
	<%
	for(HrReimbHeader hrReimbHeader :reimbHeaderList){
		int id = hrReimbHeader.getId();

	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= hrReimbHeader.getEmployee().getServiceNo()%>'
	document.getElementById('reimbCodeId').value = '<%= hrReimbHeader.getReimb().getReimbCode()%>'
	document.getElementById('reimbNameId').value = '<%= hrReimbHeader.getReimb().getReimbDesc()%>'
	document.getElementById('reimbId').value = '<%= hrReimbHeader.getReimb().getId()%>'
	document.getElementById('claimAmtId').value = '<%= hrReimbHeader.getTotalReimbAmt()%>'
	}
<%
	}
	
%>	

}

	function checkReimbAmt(){
	  var claimAmt = document.reimbDetail.<%= CLAIM_AMOUNT%>.value;
	  var reimbAmt = document.reimbDetail.<%= REIMB_AMOUNT%>.value;
	  
	  if(claimAmt < reimbAmt){
	  alert("Reimb Amount is not greater than Claim amount")
	  document.reimbDetail.<%= CLAIM_AMOUNT%>.value = "";
	  document.reimbDetail.<%= REIMB_AMOUNT%>.value = "";
	   return false;
	 }
	   return true;
	 
	}

	function checkReimbDate(){
		var cDate = document.reimbDetail.<%= CLAIM_DATE%>.value;
		var rDate = document.reimbDetail.<%= REIMB_DATE %>.value;
	
		var	claimDate =new Date(cDate.substring(6),(cDate.substring(3,5) - 1) ,cDate.substring(0,2))
		var reimbDate =new Date(rDate.substring(6),(rDate.substring(3,5) - 1) ,rDate.substring(0,2))
		if(claimDate > reimbDate)
		{
			alert("Please ensure that the Claim Date is greater than or equal to the Reimb Date.");
			document.reimbDetail.<%= CLAIM_DATE%>.value = "";
			document.reimbDetail.<%= REIMB_DATE %>.value = "";
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
<div class="clear"></div>
<%-- <jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div> --%>
<div class="titleBg"><h2>Reimbursement Detail</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= REIMB_DETAIL_ID%>", "id"], [1,"<%=REIMB_HEADER_ID%>"], [2,"<%= REIMB_AMOUNT %>"],[3,"<%=REIMB_DATE%>"],[4,"<%= PAID%>"],[5,"<%= CLAIM_AMOUNT%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=CLAIM_DATE%>"],
[10,"<%=EMPLOYEE_CODE%>"],[11,"<%=REIMBERSEMENT_DESC%>"],[12,"<%=REIMBERSEMENT_CODE%>"],[13,"<%=REMARK%>"],[14,"<%=STATUS%>"],];
statusTd = 14;
</script>
</div>
<% if(!message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="division"></div>

<form name="reimbDetail" method="post" action="">

<div class="Block">

<label> Employee Name <span>*</span></label>
<select name="<%=REIMB_HEADER_ID %>" validate="Employee Name,string,yes" onchange="displayValues(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(HrReimbHeader hrReimbHeader :reimbHeaderList){
%>
<option value="<%=hrReimbHeader.getId() %>"><%=hrReimbHeader.getEmployee().getFirstName()+" "+hrReimbHeader.getEmployee().getLastName()%></option>
<%
	}
%>
</select>
<label id=biglabel> Employee No. <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId"   readonly="readonly" validate="Srvice No.,string,yes" type="text" />
<input id="reimbId" type="hidden" name="<%=REIMBERSEMENT_ID %>" value="" />
<label id=biglabel> Reimbursement Code <span>*</span></label>
<input  type="text" id="reimbCodeId" name="<%= REIMBERSEMENT_CODE%>" readonly="readonly" validate="Reimb Code,string,yes" value=""  tabindex=1 />
<div class="clear"></div>
<label>Reimbursement Desc <span>*</span></label>
<input  type="text" id="reimbNameId" name="<%= REIMBERSEMENT_DESC%>" validate="Reimb Desc,string,yes" readonly="readonly" value=""  tabindex=1 />
 <label>Claim Date <span>*</span></label>
<input type="text" id="claimDateId" name="<%=CLAIM_DATE %>" value="<%= date%>" class="calDate" validate="Claim date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.reimbDetail.<%=CLAIM_DATE%>,event)"/> --%>


 <label>Claim Amount <span>*</span></label>
<input id="claimAmtId" type="text" name="<%= CLAIM_AMOUNT%>" value=""  readonly validate="Claim Amount,Float,yes" MAXLENGTH="9" tabindex=1 />
 <div class="clear"></div>
 


<label>Reimbursement Date</label>
<input type="text" id="joinDateId" name="<%=REIMB_DATE %>" value="<%= date%>" class="calDate" readonly="readonly" validate="Reimb date ,date,yes"  MAXLENGTH="30" />
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.reimbDetail.<%=REIMB_DATE%>,event)"/> --%>

<label>Reimb Amount <span>*</span></label>
<input id="reimbAmtId"  type="text" name="<%= REIMB_AMOUNT%>" value="" onblur="checkReimbAmt()"  validate="Reimb.Amt.,Float,yes" MAXLENGTH="9" tabindex=1 />

<label>Pay</label>
<input  type="checkbox" name="<%= PAID%>" value="" validate="Paid,string,yes" tabindex=1 />
<div class="clear"></div>

<label>Remarks <span>*</span></label>
<%-- <input  type="text" name="<%= REMARK%>" value="" validate="Remark,string,yes" MAXLENGTH="35" tabindex=1 /> --%>
<textarea class="auto" rows="3" cols="76" name="<%= REMARK%>"  MAXLENGTH="200" validate="Remark,string,yes"></textarea>
<div class="clear"></div>

</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('reimbDetail','loan?method=saveReimbDetail','checkReimbDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('reimbDetail','loan?method=updateReimbDetail','checkReimbDate')" accesskey="u" tabindex=1 />

 <input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>	

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= REIMB_DETAIL_ID%>" value="" />
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
data_header[0][3] = "<%= REIMB_HEADER_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Reimbursement Amount"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= REIMB_AMOUNT %>";

data_header[2] = new Array;
data_header[2][0] = "Reimbursement Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=REIMB_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Paid"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= PAID %>";

data_header[4] = new Array;
data_header[4][0] = "Claim Amount"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= CLAIM_AMOUNT %>";

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
data_header[8][0] = "Claim Date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=CLAIM_DATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=EMPLOYEE_CODE %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=REIMBERSEMENT_DESC %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=REIMBERSEMENT_CODE %>";


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

Iterator itr=reimDetailList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrReimbDetail hrReimbDetail= (HrReimbDetail)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrReimbDetail.getId()%>
<%
	for(HrReimbHeader hrReimbHeader :reimbHeaderList){
		if(hrReimbHeader.getId().equals(hrReimbDetail.getReimbHeader().getId()) ){
			for(MasEmployee masEmployee : employeeList){
				if(hrReimbHeader.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}
		}
	}	
%>
data_arr[<%= counter%>][2] = "<%=hrReimbDetail.getReimbAmount()%>"
	
	data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrReimbDetail.getReimbDate())%>"
	data_arr[<%= counter%>][4] = "<%= hrReimbDetail.getPaid()%>"
	data_arr[<%= counter%>][5] = "<%= hrReimbDetail.getClaimAmount()%>"
	data_arr[<%= counter%>][6] = "<%= hrReimbDetail.getLastChgBy().getFirstName() %>"
	data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrReimbDetail.getLastChgDate()) %>"
	data_arr[<%= counter%>][8] = "<%= hrReimbDetail.getLastChgTime() %>"

	data_arr[<%= counter%>][9] = "<%=HMSUtil.convertDateToStringWithoutTime(hrReimbDetail.getClaimDate()) %>"
	<%
		for(HrReimbHeader hrReimbHeader :reimbHeaderList){
			if(hrReimbHeader.getId().equals(hrReimbDetail.getReimbHeader().getId()) ){
			for(MasEmployee masEmployee : employeeList){
				if(hrReimbHeader.getEmployee().getId().equals(masEmployee.getId())){
	%>
	data_arr[<%= counter%>][10] = "<%= masEmployee.getServiceNo()%>"
	<%}
}
 }
	}
%>

<%
	for(HrReimbHeader hrReimbHeader :reimbHeaderList){
		if(hrReimbHeader.getId().equals(hrReimbDetail.getReimbHeader().getId()) ){
		for(HrMasReimbersement hrMasReimbersement :reimbList){
			if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId())){
%>
data_arr[<%= counter%>][11] = "<%= hrMasReimbersement.getReimbDesc()%>"
<%}
}
 }
	}
%>
<%
	for(HrReimbHeader hrReimbHeader :reimbHeaderList){
		if(hrReimbHeader.getId().equals(hrReimbDetail.getReimbHeader().getId()) ){
		for(HrMasReimbersement hrMasReimbersement :reimbList){
			if(hrReimbHeader.getReimb().getId().equals(hrMasReimbersement.getId())){
%>
data_arr[<%= counter%>][12] = "<%= hrMasReimbersement.getReimbCode()%>"
<%}
}
 }
	}
%>

data_arr[<%= counter%>][13] = "<%=hrReimbDetail.getRemarks() %>"


<% 

if(hrReimbDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][14] = "Active"
<%}else{%>
data_arr[<%= counter%>][14] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "reimbDetail"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
