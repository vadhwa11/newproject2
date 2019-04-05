<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
 	if (map.get("masDepartmentList") != null){
 		System.out.println("in side if loop");
		masDepartmentList = (ArrayList)map.get("masDepartmentList");
 	}
   }	
 	System.out.println("in jsp list size::::::::"+masDepartmentList.size());
 	String message = null;
	
%>
<div class="titleBg">
<h2>LoanOut Status Report</h2>
</div>

<script>
function openPopupWindowForPvms()
{
	  	var url="/hms/hms/stores?method=showPvmsNomencaltureSearchJsp";
	  	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	 
}

function jsSetNomenclature(item,nomenclature)
 {
 document.getElementById('nomenclature').value = nomenclature;
 document.getElementById('item').value = item;		
 } 
 function confirmstatus(){
  if(document.getElementById('ald').checked){
   document.getElementById('status').value = "p"; 
  }else{
  document.getElementById('status').value = "o";
  }
 }
 
 function showReport()
 {
 	var nomenclature = document.getElementById('nomenclature').value
 	if(nomenclature.length == 0){
 	document.getElementById('item').value = "";
 	}
LoanOutStatusReport.method="post";
submitForm('LoanOutStatusReport','stores?method=generateLoanOutStatusReport');
}
</script>

<form name="LoanOutStatusReport">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>"> 
<input type="hidden" name="deptId" size="5" value="<%=deptId%>"> 
<h4>LoanOut Status Report</h4>
<div class="Block">
<label>Department</label> 
<select name="Department">
<option value="">--Select Department--</option>
	<%
		for (Iterator iterator = masDepartmentList.iterator(); iterator.hasNext();) 
		{
			MasDepartment masDepartment = (MasDepartment)iterator.next();
		%>
<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
		}
		%>
</select> 
<label>From Date</label> 
<input type="text" id="FromDateId" name="<%=FROM_DATE %>" value="" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.LoanOutStatusReport.<%=FROM_DATE%>,event)" />



<label>To Date</label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.LoanOutStatusReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label> Item </label> 
<input type="text" readonlyname="nomenclature" id="nomenclature" value="" size="50"> 
<input type="hidden" name="item" id="item"> 
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor: pointer;" onClick="javascript:openPopupWindowForPvms();"
	title="Click here to Search Pvms/Niv"> 

<label class="auto">Include cleared LoanOut</label>
<input type="checkbox" class="auto" name="ald" onclick="confirmstatus()" id="ald"> 
<input type="hidden" name="status" id="status" value="o">

</div> 
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" align="right" onClick="showReport()" value="Submit" class="button"> 
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

