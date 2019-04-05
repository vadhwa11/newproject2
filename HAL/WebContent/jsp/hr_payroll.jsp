<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.HrMasPayroll"%>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.util.*" %>

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
			List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
			if(map.get("payrollList")!= null){
				payrollList = (List)map.get("payrollList");
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
		
%>


<script type="text/javascript">
	
	function checkFromDate(){
		var fDate = document.payroll.<%= FROM_DATE%>.value;
		var tDate = document.payroll.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(toDate < fromDate)
		{
			alert(" To Date should be greater than  From Date.");
			document.payroll.<%= FROM_DATE%>.value = "";
			document.payroll.<%= TO_DATE %>.value = "";
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
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg"><h2>Payroll Master</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Payroll Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>"   value="1" checked="checked" class="radioAuto" tabindex="1"/>
<label>Payroll Description</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" tabindex="1"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" tabindex="1" validate="Payroll Description,string,no"   MAXLENGTH="200" tabindex=1  onkeypress="return submitenter(this,event,'payrollMasters?method=searchPayroll')" />


<input type="hidden" name="colCode" value="payroll_code">
<input type="hidden" name="colName" value="payroll_description">

<input type="button" name="search" tabindex="1" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchPayroll','checkSearch')" tabindex=1  />

<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> --> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="hr_mas_payroll">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="ancher" method="post">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<% 
if(payrollList.size()>0)
{
String strForCode = (String)map.get("payrollCode");
String strForCodeDescription = (String)map.get("payrollDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> 


<!-- <h4><a href="payrollMasters?method=showPayrollJsp">Show All Records</a></h4> -->
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showPayrollJsp');">Show All Records</a></h4>
<%
}
}
if(payrollList.size()==0 && map.get("search") != null)
{
%>
<!-- <h4><a href="payrollMasters?method=showPayrollJsp">Show All Records</a></h4> -->
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showPayrollJsp');">Show All Records</a></h4>

<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= FROM_DATE%>"],[4,"<%= TO_DATE%>"],[5,"<%= PAYMENT_FREQUENCY%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],];
statusTd = 9;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="payroll" method="post" action="">





<input	type="hidden" name="<%= POJO_NAME %>" value="HrMasPayroll">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PayrollDescription">
<input type="hidden" name="title" value="Payroll"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="hr_payroll"> 
<input	type="hidden" name="pojoPropertyCode" value="PayrollCode">

<div class="Block">
<label>Payroll Code<span>*</span> </label>
<input  id="codeId"  type="text" name="<%= CODE%>" value="" tabindex="1" validate="Payroll,string,yes" MAXLENGTH="8" tabindex=1 />

<label id=biglabel> Payroll Description<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" tabindex="1" validate="Payroll Description,string,yes"  MAXLENGTH="32" tabindex=1   />
<script>
document.payroll.<%=CODE%>.focus();
</script>
<label>From Date<span>*</span> </label>
<input type="text" name="<%=FROM_DATE %>" id="fd" value=""  tabindex="1" validate="From date ,date,yes"  class="calDate" size="7"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'fd');" />
 

<div class="clear"></div>
<label> To Date<span>*</span> </label>
<input type="text" id="td" name="<%=TO_DATE %>" value=""  tabindex="1" validate="To date ,date,yes"  class="calDate" size="7" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 
<label>Payment Frequency<span>*</span> </label>
<select  name="<%=PAYMENT_FREQUENCY %>"   tabindex="1" validate="Payment Frequency,string,yes"  >
<option value="0">Select</option>
<option value="Weekly">Weekly</option>
<option value="Monthly">Monthly</option>
</select>

<div class="clear"></div>
</div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" tabindex="1" value="Add" class="button" onClick="submitForm('payroll','payrollMasters?method=savePayroll','checkFromDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" tabindex="1" value="Update" class="button" style="display: none;" onClick="submitForm('payroll','payrollMasters?method=editPayroll','checkFromDate')" accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" tabindex="1" value="Activate" style="display: none;" class="button" onClick="submitForm('payroll','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" tabindex="1" class="button" onClick="submitFormForButton('payroll','payrollMasters?method=showPayrollJsp');" accesskey="r" />

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
data_header[0][0] = "Payroll Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "From Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= FROM_DATE %>"

data_header[3] = new Array;
data_header[3][0] = "To Date"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= TO_DATE %>"

data_header[4] = new Array;
data_header[4][0] = "Pay Freq."
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PAYMENT_FREQUENCY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";



data_arr = new Array();

<%


Iterator itr=payrollList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasPayroll hrMasPayroll= (HrMasPayroll)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasPayroll.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasPayroll.getPayrollCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasPayroll.getPayrollDescription()%>"
data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasPayroll.getFromDate())%>"
data_arr[<%= counter%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasPayroll.getToDate())%>"
data_arr[<%= counter%>][5] = "<%= hrMasPayroll.getFrequency()%>"
data_arr[<%= counter%>][6] = "<%= hrMasPayroll.getLastChgBy()!=null?(hrMasPayroll.getLastChgBy().getId()!=null?hrMasPayroll.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasPayroll.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrMasPayroll.getLastChgTime() %>"


<% 

if(hrMasPayroll.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>

<%

counter++;
}
%>

formName = "payroll"

	nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
