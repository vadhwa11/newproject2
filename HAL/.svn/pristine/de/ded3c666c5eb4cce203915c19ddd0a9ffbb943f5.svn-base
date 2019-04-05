

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
<%
StringBuffer orderDateOnly = new StringBuffer();
GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
if (dateOfMonth < 10) {
	orderDateOnly.append("0");
	orderDateOnly.append(dateOfMonth);
} else {
	orderDateOnly.append(dateOfMonth);
}

orderDateOnly.append("/");

int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
if (month < 10) {
	orderDateOnly.append("0");
	orderDateOnly.append(month);
} else {
	orderDateOnly.append(month);
}

orderDateOnly.append("/");
int year = gregorianCalendar1.get(Calendar.YEAR);
orderDateOnly.append(year);
String currentDate = new String(orderDateOnly);
%>
<%




	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
		}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}

%>
<form name="nisDetails" method="post" action="">
<div class="titleBg">
<h2>Department Return Register </h2>
</div>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">
<label>From Date<span>*</span></label>
<input	type="text" name="<%=FROM_DATE %>" class="date" maxlength="30" tabindex=1 validate="From Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date,date,yes"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.nisDetails.<%=FROM_DATE%>,event)" />

<label>To Date<span>*</span></label>
<input	type="text" name="<%=TO_DATE %>" class="date" maxlength="30" tabindex=1 validate="To Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date,date,yes"   tabindex="1"	onClick="setdate('<%=currentDate%>',document.nisDetails.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Department</label>
<select id="departmentId" name="departmentId">
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
<div class="paddingTop5"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('nisDetails','/hms/hms/stores?method=generateDepartmentReturnRegReport');"  tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Reset" class="button" onClick="submitFormForButton('nisDetails','/hms/hms/stores?method=showDepartmentReturnRegJsp');" accesskey="r" /> 


</form>
