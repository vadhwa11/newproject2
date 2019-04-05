<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.HrMasPayElement"%>
<%@page import="jkt.hms.masters.business.HrArrear"%>

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
			List<HrArrear> arrearList = new ArrayList<HrArrear>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("arrearList")!= null){
				arrearList = (List)map.get("arrearList");
			}
			if(map.get("payElementList")!= null){
				payElementList = (List)map.get("payElementList");
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
	function displayPayElement(idvalue) {
	<%
	for(HrMasPayElement hrPayElement :payElementList){
		int id = hrPayElement.getId();

	%>
	if(idvalue == <%=id%> ){
    document.getElementById('payElementDesc').value = '<%=hrPayElement.getPayElementDesc()%>'
	}
<%
	}
%>	
}
   function checkFromDate(){
		var fDate = document.arrear.<%= FROM_DATE%>.value;
		var tDate = document.arrear.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert(" To Date should be  greater than  From Date.");
			document.arrear.<%= FROM_DATE%>.value = "";
			document.arrear.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}

	function checkPaidDate(){
			var aDate = document.arrear.<%= ARREAR_DATE%>.value;
			var pDate = document.arrear.<%= PAID_DATE%>.value;
		
			var	arrearDate =new Date(aDate.substring(6),(aDate.substring(3,5) - 1) ,aDate.substring(0,2))
			var paidDate =new Date(pDate.substring(6),(pDate.substring(3,5) - 1) ,pDate.substring(0,2))
			if(arrearDate > paidDate)
			{
				alert(" Arrear Date is greater than  Paid Date.");
				document.arrear.<%= ARREAR_DATE%>.value = "";
				document.arrear.<%= PAID_DATE %>.value = "";
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
		
		function resetUpdatedValue(){
  			document.getElementById('empId').disabled = false;
 	}
		
</script>
<%if(!message.equals("")){%>
<h4><%=message %></h4>

<%}%>

<div class="titleBg"><h2>Arrear PayElement</h2></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= ARREAR_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=PAY_ELEMENT_ID%>"],[4,"<%= PAY_ELEMENT_DESC%>"],[5,"<%= FROM_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=TO_DATE%>"],
[10,"<%=ARREAR_AMOUNT%>"],[11,"<%=PF%>"],[12,"<%=ARREAR_DATE%>"],[13,"<%=PAID_DATE%>"],[14,"<%=ARREAR_STATUS%>"],[15,"<%=REMARK%>"],[16,"<%=STATUS%>"],[17,"hiddenEmp"]];
statusTd = 16;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="arrear" method="post" action="">

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
<label> Employee No. <span>*</span></label>
<input name="<%=EMPLOYEE_CODE%>" id="empCodeId" validate="Employee Code,string,yes"  readonly="readonly" type="text" />

<label>From Date <span>*</span></label>
<input type="text"  name="<%=FROM_DATE %>" value="" class="calDate"  validate="From date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrear.<%=FROM_DATE%>,event)"/> --%>

<div class="clear"></div>


<label>To Date <span>*</span></label>
<input type="text"  name="<%=TO_DATE %>" value="" class="calDate"  validate="To date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrear.<%=TO_DATE%>,event)"/> --%>

<label> Pay Element <span>*</span></label>
<select  name="<%=PAY_ELEMENT_ID %>" validate="PayElement,string,yes" onchange="displayPayElement(this.value);" class="mediumm">
<option value="0">Select</option>
<%
	for(HrMasPayElement hrPayElement :payElementList){
%>
<option value="<%=hrPayElement.getId() %>"><%=hrPayElement.getPayElementCode()%></option>
<%
	}
%>
</select>
<label id=biglabel> PayElement Desc <span>*</span></label>
<input name="<%=PAY_ELEMENT_DESC%>" id="payElementDesc" validate="PayElement Code,string,yes"  readonly="readonly" type="text" />

 <div class="clear"></div>


<label>Arrear Amount <span>*</span></label>
<input  type="text" name="<%= ARREAR_AMOUNT%>" value=""   validate="Arrear Amount,Float,yes" MAXLENGTH="8"  />

<%-- <label>Arrear Date <span>*</span></label>
<input type="text"  name="<%=ARREAR_DATE %>" value="" class="calDate"  validate="Arrear date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 --%><%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrear.<%=ARREAR_DATE%>,event)"/> --%>
 
<label>PF</label>
<input  type="checkbox" name="<%=PF%>" value=""   validate="pf,Float,yes" MAXLENGTH="9" tabindex=1 />
 
<div class="clear"></div>

<label>Payment Date<span>*</span></label>
<input type="text"  name="<%=PAID_DATE %>" value="" class="calDate"  validate="Paid date ,date,yes"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.arrear.<%=PAID_DATE%>,event)"/> --%>

<label>Arrear Status <span>*</span></label>
<select  name="<%=ARREAR_STATUS%>" validate="Arrear Status,string,yes" class="mediumm">
<option value="0">Select</option>
<option value="paid">Paid</option>
<option value="unpaid">Unpaid</option>
</select>
<label>Remarks <span>*</span></label>
<input  type="text" name="<%= REMARK%>" value="" validate="Remark,string,yes" MAXLENGTH="40" tabindex=1 />

<div class="clear"></div>

</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('arrear','loan?method=saveArrear','checkFromDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('arrear','loan?method=updateArrear','checkFromDate')" accesskey="u" tabindex=1 />

<input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();resetUpdatedValue();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= ARREAR_ID%>" value="" />
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
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = "25%";
data_header[1][3] = "<%= EMPLOYEE_CODE %>";

data_header[2] = new Array;
data_header[2][0] = "PayElement"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=PAY_ELEMENT_ID%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "<%= PAY_ELEMENT_DESC%>";

data_header[4] = new Array;
data_header[4][0] = "From date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= FROM_DATE%>";

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
data_header[8][0] = "To date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=TO_DATE %>";

data_header[9] = new Array;
data_header[9][0] = "Arrear Amount"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=ARREAR_AMOUNT %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=PF %>";

data_header[11] = new Array;
data_header[11][0] = "Arrear Date"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=ARREAR_DATE %>";

data_header[12] = new Array;
data_header[12][0] = "Paid Date"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%=PAID_DATE %>";

data_header[13] = new Array;
data_header[13][0] = "Arrear Status"
data_header[13][1] = "data";
data_header[13][2] = "15%";
data_header[13][3] = "<%=ARREAR_STATUS %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=REMARK %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "<%=STATUS%>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "hiddenEmp";

data_arr = new Array();

<%


Iterator itr=arrearList.iterator();
int  counter=0;
while(itr.hasNext())
{

	HrArrear hrArrear = (HrArrear)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrArrear.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrear.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
		}
			}		
%>
<%
			for(MasEmployee masEmployee : employeeList){
				if(hrArrear.getEmployee().getId().equals(masEmployee.getId())){
%>
		data_arr[<%= counter%>][2] = "<%=masEmployee.getServiceNo()%>";
<%
		}
			}
		
%>
<%	
			for(HrMasPayElement hrMasPayElement : payElementList){
				if(hrArrear.getPayElement().getId().equals(hrMasPayElement.getId())){
%>
data_arr[<%= counter%>][3] = "<%=hrMasPayElement.getPayElementCode()%>";
<%
		}
			}
		
%>
<%	
			for(HrMasPayElement hrMasPayElement : payElementList){
				if(hrArrear.getPayElement().getId().equals(hrMasPayElement.getId())){
%>
data_arr[<%= counter%>][4] = "<%=hrMasPayElement.getPayElementDesc()%>";
<%
		}
			}
		
%>
data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrear.getFromDate()) %>"
data_arr[<%= counter%>][6] = "<%= hrArrear.getLastChgBy().getFirstName() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrArrear.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrArrear.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrear.getToDate()) %>"
data_arr[<%= counter%>][10] = "<%=hrArrear.getArrearAmount()%>"
data_arr[<%= counter%>][11] = "<%=hrArrear.getPf()%>"
data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrear.getArrearDate())%>"
<%
	if(hrArrear.getPaidDate() != null && !(hrArrear.getPaidDate().equals(""))){
%>
data_arr[<%= counter%>][13] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrear.getPaidDate())%>"
<%
	}else{
%>
data_arr[<%= counter%>][13] = ""
<%
	}
%>
data_arr[<%= counter%>][14] = "<%=hrArrear.getArrearStatus()%>"
data_arr[<%= counter%>][15] = "<%=hrArrear.getRemark()%>"

<% 

if(hrArrear.getStatus().equals("y")){ %>
data_arr[<%= counter%>][16] = "Active"
<%}else{%>
data_arr[<%= counter%>][16] = "InActive"
<%}%>
<%	
			for(MasEmployee masEmployee : employeeList){
					if(hrArrear.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][17] = "<%=masEmployee.getId()%>";
<%
		}
			}		
		
%>
<%

counter++;
}
%>

formName = "arrear"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	
</script>	