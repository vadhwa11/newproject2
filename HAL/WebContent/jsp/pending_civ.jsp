<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		int nextyear = calendar.get(calendar.YEAR) + 1;
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>

<%
	String date = "";
	String time = "";
	String userName = "";
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
 	if(session.getAttribute("deptId")!=null){
 		deptId = Integer.parseInt(session.getAttribute("deptId").toString());
 	}
 		
 	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
 	if (map.get("masDepartmentList") != null){
 		System.out.println("in side if loop");
		masDepartmentList = (ArrayList)map.get("masDepartmentList");
 	}
   }	
 	String message = null;
	
%>


<script>

 function showReport()
 {
 	var Department = document.getElementById('Department').value
 	var errmsg = "";
 	if(Department.length == 0){
 	errmsg = errmsg + "\n Select department!!";
 	}
 	
 	if(errmsg != ""){
 	 alert(errmsg);
 	 return false;
 	}
 
DepartmentWiseItem.method="post";
submitForm('DepartmentWiseItem','stores?method=DepartmentWisePendingCIVReport');
}
</script>

<form name="DepartmentWiseItem">
<div class="titleBg">
<h2>Report For Pending CIV</h2>
</div>
<div class="clear"></div>
<h4>Report For Pending CIV</h4>
<div class="clear"></div>
<div class="Block">
<label>Department</label> 
<select name="Department" 	id="Department">
<option value="">--Select Department--</option>
	<%
		for (Iterator iterator = masDepartmentList.iterator(); iterator.hasNext();) 
		{
			MasDepartment masDepartment = (MasDepartment)iterator.next();
			if(deptId==masDepartment.getId()){
		%>
<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
	<%}	}%>
</select> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" align="right" onClick="showReport()"	value="Submit" class="button"> 
<input type="reset"	name="Reset" value="Reset" class="button" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>
