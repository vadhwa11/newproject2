<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<script	type="text/javascript" language="javascript">

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
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
String message = "";
Date toDate  = null;
Date fromDate = null;
List<StoreOpPatientIssueT> storeOpPatientIssueTList=new ArrayList<StoreOpPatientIssueT>();
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
Map<String, Object> dailyIssueItem = new HashMap<String, Object>();
if (map.get("dailyIssueItem") != null) {
	
	dailyIssueItem = (Map<String, Object>)map.get("dailyIssueItem");
}
List objectList = new ArrayList();
	if (dailyIssueItem.get("objectList") != null) {
		objectList = (List)dailyIssueItem.get("objectList");

	}
	String reportType="";
	if(map.get("reportType") != null){
		reportType= (String) map.get("reportType");
	}
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	if (map.get("deptList") != null) {
		deptList = (List<MasDepartment>)map.get("deptList");

	}
	if (dailyIssueItem.get("deptList") != null) {
		deptList = (List<MasDepartment>)dailyIssueItem.get("deptList");

	}
	 
	if (dailyIssueItem.get("msg") != null) {
	             message = (String)dailyIssueItem.get("msg");
	      }
	
	String toDepart="";
	if(map.get("depart") != null){
		toDepart= (String) map.get("depart");
	}
	
	if(!message.equalsIgnoreCase("")){
	%>
	<h4><%=message %></h4>
	<%} %>

<form name="dailyIssueSummery" action="" method="post">
<div class="clear"></div>
<div class="titleBg">
<h2>Daily Accounting Register</h2>
</div>
<!--  <form name="issue" method="post">-->
<div class="clear"></div>
<div class="Block">
  
<!-- 
<label class="medium">Summary</label> <input type="radio" name="reportType"
	value="<%=SUMMARY  %>" class="radioAuto" checked="checked"
	
	maxlength="30" tabindex=1 /> 
	
	<label class="medium">Detail </label> <input
	type="radio" name="reportType" value="<%=DETAIL  %>" class="radioAuto"
	
	maxlength="30" tabindex=1 /> -->
	<div class="clear"></div>   
	<label>From Date <span>*</span>   </label> 
<input type="text" class="date" name="<%=FROM_DATE%>" value="<%=date %>"  MAXLENGTH="30" validate="From date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.dailyIssueSummery.<%=FROM_DATE%>,event)" />
<label>To Date <span>*</span>  </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30" validate="To date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.dailyIssueSummery.<%=TO_DATE%>,event)" />
<div class="clear"></div>            

<div class="clear"></div>
<label>PVMS/NIV No.</label>
<input type="text" name="pvmsNiv" id="pvmsNiv" validate="PVMS/NIV No,alphanumeric1,no"/> 
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validateMetaCharacters(this.value))
{
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})
};
</script>  
<label>Department</label>
<select name="department" id="department" validate="To Department ,String,no">
	<option value="0">Select</option>
	<%
		
		Iterator itrDeptTo=deptList.iterator();
	    while(itrDeptTo.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDeptTo.next();
			
			%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<%	
	  }	
	%>
</select> 
</div>
<div class="clear"></div>
<input type="button" class="button" value="Generate Report" onclick="methodForReport1();" />
<input type="button" class="button" value="Print" onclick="methodForReport();" />
<input type="reset" name="Reset" id="reset" value="Cancel" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script>

function checkPvms()
{
	var pvmsNo='';
	 pvmsNo=document.getElementById('pvmsNiv').value;

	if(pvmsNo=='')
	{
		alert("Please Enter pvmsNo ");
		return false;
	}else
	{
		return true;
	}

		 
}
function methodForReport(){
	var pvmsNo=document.getElementById('pvmsNiv').value;

	/*if(pvmsNo !=""){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSactionReport');
	}else{*/
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=p');
	//}
}
function methodForReport1(){
	var pvmsNo=document.getElementById('pvmsNiv').value;

	/*if(pvmsNo !=""){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSactionReport');
	}else{*/
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=j');
	//}
}

function prescriptionDetails(val){
	//alert(val);
	if(val != null)
	submitProtoAjax('dailyIssueSummery','stores?method=showPrescriptionDetailsReport&precriptionId='+val);
}

</script>

<%if(objectList.size()>0){ %>
<!-- <div class="cmntableWithHeight"> -->
<div STYLE=" height:250px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="main">
	<thead>
		<tr>
		<%if(toDepart.equals("0")){ %>
		<th>Select</th>
		<%}%>
			<th>Sl No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/U </th>
			<%//if(reportType.equals("detail")){
				%>
			<th>Batch No.</th>
			<th>DOE</th>
			<th>Manufacturer</th>
			<%//} 
			%>
			<th>Qty Issued</th> 
			<%if(toDepart.equals("0")){ %>
			<th >Prescription No.</th>
			<%}%>		
				
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
<tr>
<%if(toDepart.equals("0")){%>
<td><input type="radio" name="precriptionId" value="<%= object[9]%>" onClick="prescriptionDetails(this.value)"/></td>
<%}%>
<td><%=++count%></td>
<td><div class="calcell"><%= object[2]%></div></td>
<td ><div class="calcell"><%=object[3]%></div></td>
<%if(object[4] != null) {%>
<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%//if(reportType.equals("detail")){ 
%>
<td><div class="calcell"><%= object[6]%></div></td>
<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[7])%></div></td>
<%//} 
%>
<%if(object[10] != null) {%>
	<td ><div class="calcell"><%=object[10]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[0] != null) {%>
	<td ><div class="calcell"><%=object[0]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(toDepart.equals("0")){ %>
<%if(object[8] != null) {%>
	<td><div class="calcell"><%=object[8]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} }%>

</tr>
<%}%>

</table>
</div>
<%}%>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
			</div>