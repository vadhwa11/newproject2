<%@page import="jkt.hms.masters.business.MasZonal"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>

<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=openingBalanceRegister";
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
	if (map.get("recptRegister") != null) {		
		recptRegister = (Map<String, Object>)map.get("recptRegister");
		System.out.println("in not null");		
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	List objectList = new ArrayList();
	if (recptRegister.get("objectList") != null) {
		objectList = (List)recptRegister.get("objectList");
		System.out.println("objectList in jsp "+objectList.size());
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
	List<MasDivision> divisionList = new ArrayList<MasDivision>();
	if(map.get("divisionList") != null){
		divisionList = (List<MasDivision>)map.get("divisionList");
		}
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
		}
	List<MasZonal> zonalList = new ArrayList<MasZonal>();
	if(map.get("zonalList") != null){
		zonalList = (List<MasZonal>)map.get("zonalList");
		}
	List<Users> pharmacistList = new ArrayList<Users>();
	if(map.get("pharmacistList") != null){
		pharmacistList = (List<Users>)map.get("pharmacistList");
		}
	
	/*
		if (detailsMap1.get("patientName") != null) {
		patientName = (String)detailsMap1.get("patientName");
*/

if (recptRegister.get("msg") != null) {
           message = (String) recptRegister.get("msg");
    }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<form name="dailyIssueSummry" method="post" action="">
<div class="titleBg">
<h2>Opening Balance Register</h2>
</div>
<div class="Block">
<label class="medium">From Date<span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="From Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />


<label class="medium">To Date <span>*</span></label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="To Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />

</div>
<div class="clear"></div>
<!-- <input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('receiptRegister1','stores?method=generateReceiptRegisterReport&flag=j');" accesskey="a" tabindex=1 /> -->
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('dailyIssueSummry','stores?method=printOpeningBalanceRegister');" accesskey="a" tabindex=1 />  
<input type="button" name="clear" id="clearbutton" value="Reset" class="button" onClick="clearButton('dailyIssueSummry');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<div class="Clear"></div>
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
	
<script>
function disableVal()
{
	 var radioVAl = '';
	 for(var i = 0; i < document.getElementsByName('optionRadio').length; i++)
	 {
	 	if(document.getElementsByName('optionRadio')[i].checked == true)
     	{	
	 		
	 		radioVAl = document.getElementsByName('optionRadio')[i].value;
	 		
     	}
	 }
		if(radioVAl == 'f' ){
			document.getElementById("divisionId").disabled= false;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("divisionId").style.display = 'inline';
			document.getElementById("departmentId").style.display = 'none';
			document.getElementById("zonalId").style.display = 'none';
			document.getElementById("zonalId").disabled= true;
			document.getElementById("departmentId").value=0;
			document.getElementById("zonalId").value=0;
		}
		else if(radioVAl == 'o' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= false;
			document.getElementById("zonalId").disabled= true;
			document.getElementById("divisionId").style.display = 'none';
			document.getElementById("departmentId").style.display = 'inline';
			document.getElementById("zonalId").style.display = 'none';
			document.getElementById("zonalId").value=0;
			document.getElementById("divisionId").value=0;
			
		}
		else if(radioVAl == 'z' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("zonalId").disabled= false;
			document.getElementById("divisionId").style.display = 'none';
			document.getElementById("departmentId").style.display = 'none';
			document.getElementById("zonalId").style.display = 'inline';
			document.getElementById("departmentId").value=0;
			document.getElementById("divisionId").value=0;
		}
		else if(radioVAl == 'a' ){
			document.getElementById("divisionId").disabled= true;
			document.getElementById("departmentId").disabled= true;
			document.getElementById("zonalId").disabled= true;
			document.getElementById("departmentId").value=0;
			document.getElementById("zonalId").value=0;
			document.getElementById("divisionId").style.display = 'none';
			document.getElementById("departmentId").style.display = 'none';
			document.getElementById("zonalId").style.display = 'none';
			
		}
	
	  	
		return true;

	 }


</script>
