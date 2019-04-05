<%@page import="jkt.hms.masters.business.MasZonal"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=dailyIssueSummryReport";
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
<h2>Daily Issue Summary</h2>
</div>
<div class="Block">
<label class="medium">From Date<span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="medium" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" 
onClick="setdate('<%=currentDate%>',document.dailyIssueSummry.<%=FROM_DATE%>,event)" />
<label class="medium">To Date <span>*</span></label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="medium" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" 

onClick="setdate('<%=currentDate%>',document.dailyIssueSummry.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<input class="radiobutMargin" type="radio" value="f" id="optionRadio" name="optionRadio"  onclick="disableVal();" >
<label class="smaller">FAC</label>

<select id="divisionId" name="divisionId" style="display: none;">
			<option value="0">Select</option>

			<%
				         		if(divisionList != null){ 	
				         			for (Iterator iter = divisionList.iterator(); iter.hasNext();) {
				         				MasDivision masDivision = (MasDivision) iter.next();
				         %>
			<option value="<%=masDivision.getId() %>"><%=masDivision.getDivisionName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>

<div class="clear"></div>
<input class="radiobutMargin" type="radio" value="o" id="optionRadio" name="optionRadio"  onclick="disableVal();">
<label class="smaller">OPD</label>
<select id="departmentId" name="departmentId"  style="display: none;">
			<option value="0">Select</option>

			<%
				         		if(departmentList != null){ 	
				         			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
				         				MasDepartment masDepartment = (MasDepartment) iter.next();
				         %>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
<div class="clear"></div>
<input class="radiobutMargin" type="radio" value="z" id="optionRadio" name="optionRadio" onclick="disableVal();" >
<label class="smaller">Zonal</label>
<select id="zonalId" name="zonalId" style="display: none;">
			<option value="0">Select</option>

			<%
				         		if(zonalList != null){ 	
				         			for (Iterator iter = zonalList.iterator(); iter.hasNext();) {
				         				MasZonal masZonal = (MasZonal) iter.next();
				         %>
			<option value="<%=masZonal.getId() %>"><%=masZonal.getZonalName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
<div class="clear"></div>
<input class="radiobutMargin" type="radio" value="a" id="optionRadio" name="optionRadio"  onclick="disableVal();">
<label class="smaller">All</label>

<!--  <label ><span>*</span>  Source of
Supply</label> <select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
	validate="Source of Supply,String,no">
	<option value="0">Select</option>
	<option value="p">PVMS by DGRC</option>
	<option value="a">AFMSD</option>
	<option value="l">Local Purchase</option>
	</select>-->
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- <input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('receiptRegister1','stores?method=generateReceiptRegisterReport&flag=j');" accesskey="a" tabindex=1 /> -->
<input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('dailyIssueSummry','stores?method=generateDailyIssueSummry');" accesskey="a" tabindex=1 />  
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
