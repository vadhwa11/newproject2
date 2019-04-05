
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOtBookingRegisterJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	


%>


<%
Date d=new Date();

String deptName="&nbsp;";

String toDate = "&nbsp;";
String fromDate = "&nbsp;";


	
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> recptRegister = new HashMap<String, Object>();
	Map<String, Object> requestParameters = new HashMap<String, Object>();

	String message = "";
	String clinicalNotes = "";
	String url = "";

	String entryPersonNameDesignation = "&nbsp;";
	String entryPersonNameRank = "&nbsp;";

	String flagForConfidential = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	masEmployeeList = (ArrayList)map.get("masEmployeeList");
	
	
	if (map.get("recptRegister") != null) {
		
		recptRegister = (Map<String, Object>)map.get("recptRegister");
		System.out.println("in not null");
		
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}

	if (map.get("requestParameters") != null) {
		requestParameters = (Map<String, Object>)map.get("requestParameters");

	}
	if (requestParameters.get("toDate") != null) {
		toDate = (String)requestParameters.get("toDate");

	}
	if (requestParameters.get("fromDate") != null) {
		fromDate = (String)requestParameters.get("fromDate");

	}


if (recptRegister.get("msg") != null) {
           message = (String) recptRegister.get("msg");
    }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>
<!-- 
<div class="titleBg">

</div>
 -->
<div class="Clear"></div>
<div class="clear"></div>


<div class="Clear"></div>
<form name="dailyIssueSummry" method="post" action="">
<div class="titleBg">
<h2>Ot Booking Register</h2>
</div>
<div class="Block">
<label> From Date  <span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" 
onClick="setdate('<%=currentDate%>',document.dailyIssueSummry.<%=FROM_DATE%>,event)" />
<label> To Date <span>*</span></label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" 

onClick="setdate('<%=currentDate%>',document.dailyIssueSummry.<%=TO_DATE%>,event)" />



<div class="clear"></div>

<label>Surgeon Name</label>
<select name="<%=EMPLOYEE_ID %>" validate="Surgeon Name,string,no" tabindex=1	>
<option value="0">Select</option>

	<%
	
	String s="";
				for (MasEmployee  e	 : masEmployeeList){

				
				
				
				%>
<option value="<%=e.getId()%>"><%=e.getFirstName()+" "+e.getLastName()%></option>

	<%}%>
</select>

<label>Status</label>
<select name="statusVal">
<option value="">Select</option>
<option value="n">Pending</option>
<option value="C">Completed</option>
</select>
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- <input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('receiptRegister1','stores?method=generateReceiptRegisterReport&flag=j');" accesskey="a" tabindex=1 /> -->
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('dailyIssueSummry','/hms/hms/ot?method=generateOtBookingRegister');" accesskey="a" tabindex=1 />  
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('dailyIssueSummry');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<div class="Clear"></div>
<div class="clear"></div>
<div class="Clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<script type="text/javascript">
<!--
function getVal(e) {
    var targ;
    if (!e) var e = window.event;
    if (e.target) targ = e.target;
    else if (e.srcElement) targ = e.srcElement;
    if (targ.nodeType == 3) // defeat Safari bug
        targ = targ.parentNode;

    alert(targ.innerHTML);
}

onload = function() {
    var t = document.getElementById("main").getElementsByTagName("td");
    for ( var i = 0; i < t.length; i++ )
        t[i].onclick = getVal;
}

</script>

</div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="clear"></div>

<div class="Clear"></div>
<div class="clear"></div>
	
<script>
function disableVal(){
	
	 for(var i = 0; i < document.getElementsByName('optionRadio').length; i++){
	 if(document.getElementsByName('optionRadio')[i].checked == true)
     {	
		if(document.getElementsByName('optionRadio')[i].value == 'f' ){
			document.getElementById("divisionId").disabled= false;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("zo").disabled= true;
		}
		if(document.getElementsByName('optionRadio')[i].value == 'o' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= false;
			document.getElementById("zo").disabled= true;
		}
		if(document.getElementsByName('optionRadio')[i].value == 'z' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("zo").disabled= false;
		}
		if(document.getElementsByName('optionRadio')[i].value == 'a' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("zo").disabled= true;
		}
		return true;
	  }		
		return true;

	 }
}

</script>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>