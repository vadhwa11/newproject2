<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script language="Javascript">
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
	</script>

<%
Map map = new HashMap();
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	//Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	if(map.get("sectionList") != null){
		sectionList= (ArrayList) map.get("sectionList");
	}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
	<h4><%=message %></h4>
	<%} %>


<form name="defectiveDrugsReport"  action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>Defective Drugs Register</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveDrugsReport.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveDrugsReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div> 
	<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="methodForReport();" value="Generate Report" class="buttonBig">
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script>
function methodForReport(){
	
	submitForm('defectiveDrugsReport','stores?method=generateDefectiveDrugsReport');
	
}
function fillValues(){
	if(document.actualStockReport.nomenclature.value != "")
	{
	var val = document.actualStockReport.nomenclature.value;

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   		 if (pvms!="")
   	 	{
    	document.getElementById("item_id").value=pvms;

		}
	}
		else
		{
			document.getElementById("item_id").value=0;

		}

	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;
    var item_id=document.getElementById('item_id').value;
	if(sectionName !=0  && (item_id !=0 ||  pvmsNo != "")){
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport');
		
	}else{
		submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport');
	}
	
	//submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport&deptName='+departmentName+'');

}
function methodForExcel(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(sectionName !=""){
		submitForm('actualStockReport','stores?method=generateActualStockSactionExcel');
	}else{
		submitForm('actualStockReport','stores?method=generateActualStockExcel');
	}
}
</script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>