<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%
	String date = "";
	String time = "";
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<UserDepartment> UserDepartmentList = new ArrayList<UserDepartment>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	String userName ="";
 	String deptName = "";
 	int userId = 0;
 	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		if (map.get("deptList")!=null)
			deptList  = (List)map.get("deptList");
		
		
		if(map.get("searchUserDepartmentList")!= null)
			UserDepartmentList = (List)map.get("searchUserDepartmentList");
		
		
		
		if(map.get("userId")!=null)
			userId = (Integer)map.get("userId");
		
    }
%>


<script language="Javascript">

function changeDepartment()
{
var obj = document.getElementById("wardId");

if (obj.value=="")
{
	alert("Pl. Select the Department to be Changed!.....");
	return false;
}

var val = obj.value;
var deptName = "";
for(i=0;i<obj.length;i++)
{
 	if (obj.options[i].value==val)
 	{
 	deptName = obj.options[i].text;
 	break;
 	}
}
document.ChangeWardForm.method="post";
var str = "superAdmin?method=changeWardInSession&deptName="+deptName;
submitForm('ChangeWardForm',str);
}

</script>

<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   %> <h4><%=message %></h4> <%
	  }

%>
<form name="ChangeWardForm">
<div class="Clear"></div>
<div class="titleBg">
<h2>Change Ward</h2>
</div>
<div class="Clear"></div>
<div class="Block">
<label>User Name </label> 
<input	type="text" value="<%=userName%>" readonly size="20" class="large">
<div class="Clear"></div>
<label>Dept Name </label> 
<input type="text" value="<%=deptName%>" readonly size="30" class="large">
<div class="Clear"></div>
<label>Dept to be Changed</label> 
<select name="ward"	id="wardId" class="large2">
	<option value="">Select Ward</option>
	<%
		for (Iterator iterator = UserDepartmentList.iterator(); iterator.hasNext();) 
		{
			UserDepartment dept = (UserDepartment)iterator.next();
			if(userId == dept.getUser().getId()){
		%>
	<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName()%></option>
	<%
		}}
		%>
</select></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="change" onClick="changeDepartment();"	value="Submit" class="button"></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>



