
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeavechoice"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />

<script type="text/javascript">
function LeaveChoiceFunction(){
	var leavechoice1=document.getElementById('<%=LEAVE_CHOICE_1 %>').value;
     var leavechoice2=document.getElementById('<%=LEAVE_CHOICE_2 %>').value;
     if(leavechoice1==leavechoice2){
     alert('Both choices cannot be same ');
   
     document.getElementById('<%=LEAVE_CHOICE_2 %>').focus();
     }
}


</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
	List<MasServiceType> masservicetypeList = new ArrayList<MasServiceType>();
	List<MasEmployee> masemployeeList=new ArrayList<MasEmployee>();
    List masUnitList = (List)map.get("masUnitList");
    if(map.get("hrorderlyLeaveChoiceList")!=null)
    {
    	hrorderlyLeaveChoiceList=(List)map.get("hrorderlyLeaveChoiceList");
    }
    if(map.get("masservicetypeList")!=null)
    {
    	masservicetypeList=(List)map.get("masservicetypeList");
    }
    if(map.get("masemployeeList")!=null)
    {
    	masemployeeList=(List)map.get("masemployeeList");
    }
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<div id=contentspace">
<h2 align="left" class="style1">Leave Choice Approval Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">ServiceNo.:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Employee
First Name:</font> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value=""
	validate="Search Field Required,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchLeaveChoiceApprovalJsp','checkSearch')"
	tabindex=1 /></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %> <a href="hrOrderly?method=showLeaveChoiceApprovalJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SERVICE_NO %>"], [3,"<%=SERVICE_TYPE_CODE%>"], [4,"<%= SEARCH_NAME %>"], [5,"<%=LEAVE_CHOICE_1%>"], [6,"<%=LEAVE_CHOICE_2%>"],[7,"<%=YEAR%>"], [8,"Approved"], [9,"Signature"],[10,"<%=STATUS%>"],[11,"remarks"]];
	 statusTd = 11;
	</script></div>
</div>
<br />
<div id="contentHolder">
<form name="choiceApproval" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployee"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ServiceNo">
<input type="hidden" name="title" value="Leave Choice "> <input
	type="hidden" name="<%=JSP_NAME %>" value="Leave Choice "> <input
	type="hidden" name="pojoPropertyCode" value="ServiceType">

<div class="blockTitle">Leave Choice Approval</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<div class=Clear></div>

<label class="large" style="float: left;"><span>*</span>
Service No </label> <input id="codeId" style="width: 80px;" type="text"
	name="<%= SERVICE_NO%>" value="" readonly="readOnly" MAXLENGTH="8"
	tabindex=1 /> <label style="float: left; padding-left: 10px;"><span>*</span>
Name</label> <input type="text" name="<%=SEARCH_NAME %>" value=""
	readonly="readOnly" width="10px" MAXLENGTH="30" tabindex=1 /> <% String year[]=date.split("/");
            int finalyear=Integer.parseInt(year[2])+10;		
		%> <label style="padding-right: 5px;"><font id="error"
	style="padding-left: 10px;">*</font>Year. :</label> <select id="<%=YEAR %>"
	name="<%=YEAR %>" style="width: 60px;" disabled="disabled"
	validate="Year Name,string,yes" tabindex=1>
	<%for(int i=2009;i<finalyear;i++){ %>
	<option value="<%=i %>"><%=i %></option>
	<%} %>

</select>
<div class=Clear></div>
<label style="float: left; padding-left: 70px;">Leave choice1</label> <select
	id="<%=LEAVE_CHOICE_1%>" style="width: 90px;"
	name="<%=LEAVE_CHOICE_1%>" readonly="readonly" disabled="disabled"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();"
	tabindex=1>
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select> <label style="float: left; padding-left: 1px;">Leave choice2</label> <select
	id="<%=LEAVE_CHOICE_2%>" name="<%=LEAVE_CHOICE_2%>" readonly="readonly"
	disabled="disabled" onchange=" LeaveChoiceFunction();"
	onblur=" LeaveChoiceFunction();" tabindex=1>
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select>


<div class=Clear></div>
<label class="large"><span>*</span> Approved</label> <select
	id="Approved" name="Approved" validate="Approved,string,yes"
	style="width: 90px;" tabindex="1">
	<option value="">Select</option>
	<option value="Approved">Yes</option>
	<option value="Rejected">No</option>
</select> <label style="float: left; padding-left: 1px;"><span>*</span>
Approved By </label> <select id="Signature" name="Signature"
	validate="Approved By,string,yes" style="width: 120px;" tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasEmployee masEmployee : masemployeeList){
			%>
	<option
		value="<%=masEmployee.getFirstName() + masEmployee.getMiddleName() + masEmployee.getLastName()%>"><%=masEmployee.getFirstName() + masEmployee.getMiddleName() + masEmployee.getLastName()%></option>
	<%}%>
</select> <label style="float: left;"><span>*</span> Remarks </label> <input
	id="remarks" type="text" name="remarks" value="" MAXLENGTH="25"
	tabindex=1></div>


<div class="clear"></div>
<div class="bottom"><input type="button" name="submit1"
	id="submit1" value="Submit" class="button"
	onClick="submitForm('choiceApproval','hrOrderly?method=updateLeaveChoiceApprovalJsp');"
	accesskey="a" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="edited" id="edited" /> <input type="hidden" name="Delete"
	id="Delete" /></div>
<br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();
<%String monthName[]={"-","Jan-Feb","Feb-Mar","Mar-Apr","Apr-May","May-Jun","Jun-Jul","Jul-Aug","Aug-Sep","Sep-Oct","Oct-Nov","Nov-Dec"};%>
data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "data";
data_header[0][2] = "5%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Service No."
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%=SERVICE_NO%>";

data_header[2] = new Array;
data_header[2][0] = "Service Type"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=SERVICE_TYPE_CODE%>";

data_header[3] = new Array;
data_header[3][0] = "Employee Name"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%=SEARCH_NAME%>";

data_header[4] = new Array;
data_header[4][0] = "Leave choice 1"
data_header[4][1] = "data";
data_header[4][2] = "5%";
data_header[4][3] = "<%=LEAVE_CHOICE_1%>";

data_header[5] = new Array;
data_header[5][0] = "Leave choice 2"
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "<%=LEAVE_CHOICE_2%>";


data_header[6] = new Array;
data_header[6][0] = "Year"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "<%= YEAR%>"

data_header[7] = new Array;
data_header[7][0] = "Approved"
data_header[7][1] = "data";
data_header[7][2] = "5%";
data_header[7][3] = "Approved"

data_header[8] = new Array;
data_header[8][0] = "Signature"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "Signature"

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "hide";
data_header[9][2] = "10%";
data_header[9][3] = "<%=STATUS %>";

data_header[10] = new Array;
data_header[10][0] = "remarks"
data_header[10][1] = "hide";
data_header[10][2] = "";
data_header[10][3] = "remarks";

data_arr = new Array();

<%
if(hrorderlyLeaveChoiceList!=null){
Iterator itr=hrorderlyLeaveChoiceList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrorderlyLeavechoice hrorderlyLeavechoice = (HrorderlyLeavechoice)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= hrorderlyLeavechoice.getId()%>"
data_arr[<%= counter%>][1] = "<%=hrorderlyLeavechoice.getEmployeeId().getEmployeeCode()%>"
data_arr[<%= counter%>][2] = "<%=hrorderlyLeavechoice.getEmployeeId().getServiceNo()%>"
data_arr[<%= counter%>][3] = "<%=hrorderlyLeavechoice.getEmployeeId().getServiceType().getServiceTypeName()%>"
data_arr[<%= counter%>][4] = "<%=hrorderlyLeavechoice.getEmployeeId().getFirstName()+"   "+hrorderlyLeavechoice.getEmployeeId().getLastName()%>"
data_arr[<%= counter%>][5] = "<%=monthName[Integer.parseInt(hrorderlyLeavechoice.getLeaveChoice1())]%>"
data_arr[<%= counter%>][6] = "<%=monthName[Integer.parseInt(hrorderlyLeavechoice.getLeaveChoice2())]%>"
<% if (hrorderlyLeavechoice.getYear()!=null){ %>
data_arr[<%= counter%>][7] ="<%=hrorderlyLeavechoice.getYear()%>"
<%}else{ %>
data_arr[<%= counter%>][7] ="-"
<%}%>
<%if( hrorderlyLeavechoice.getLcApprovedStatus()!=null){
if(hrorderlyLeavechoice.getLcApprovedStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Approved"
<%}else{%>
data_arr[<%= counter%>][8] = "Rejected"
<%}}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>
<%if(hrorderlyLeavechoice.getSignature()!=null){%>
data_arr[<%= counter%>][9] = "<%=hrorderlyLeavechoice.getSignature() %>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>
<% if(hrorderlyLeavechoice.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%if(hrorderlyLeavechoice.getLeaveChoiceRemarks()!=null){%>
data_arr[<%= counter%>][11] = "<%=hrorderlyLeavechoice.getLeaveChoiceRemarks()%>"
<%}else{%>
data_arr[<%= counter%>][11] = ""
<%}%>


<%
		     counter++;
}}
%>
formName = "choiceApproval"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
