<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.masters.business.Complain"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.Users"%>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">

<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>



<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<form name="complainA" method="post" action="">

 <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
  	List<Users> userList1 = new ArrayList<Users>();
 	List<Complain> searchComplainList  = new ArrayList<Complain>();
 	List<Users>userList = new ArrayList<Users>();
	List<Complain> comp = new ArrayList<Complain>();
	List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
	session = request.getSession();
	String userName="";
	Integer hospitalId=0;
	
	if(session.getAttribute("userName")!=null)
	 
	userName=(String)session.getAttribute("userName");
	
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	
 	String currentDate = (String) utilMap.get("currentDate");
 	
 	String time = (String) utilMap.get("currentTimeWithoutSc");
 	 	 	 	
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}

 	if(map.get("userList")!=null)
 	{
 		userList=(List<Users>)map.get("userList");
 		
 	}
 	if(map.get("userList1")!=null)
 	{
 		userList1=(List<Users>)map.get("userList1");
 		
 	}
 	if(session.getAttribute("hospitalId")!=null)
 	{
 		hospitalId= Integer.parseInt(""+session.getAttribute("hospitalId"));
  	}
 	map.put("hospitalId",hospitalId);
 	
 	String message="";
 	if(map.get("message")!=null){
 		message=(String)map.get("message");
 	}
 	if(map.get("searchComplainList")!=null)
 	{
 		searchComplainList=(List<Complain>)map.get("searchComplainList"); 		
 	}
 	
	
 	gridEmployeeList=(List<MasEmployee>)map.get("gridEmployeeList");
 	String test="";
%>
 
<div class="titleBg">
<h2>Complain A</h2>
</div>
<div class="clear"></div>
<%if(message!=null){ %>
<h4><%=message %></h4>
<%} %>

<div class="Block">
<label>From Date</label>
<input type="text" name="<%=FROM_DATE %>" class="date" value="<%=currentDate %>" validate="From Date,date,yes"
readonly="readonly" MAXLENGTH="30" tabindex="1" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
onClick="setdate('<%=FROM_DATE%>',document.complainA.<%=FROM_DATE%>,event)" />

<label>To Date</label>
<input type="text" name="<%=TO_DATE %>" class="date" value="<%=currentDate %>" validate="To Date,date,yes"
readonly="readonly" MAXLENGTH="30" tabindex="1" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
onClick="setdate('<%=TO_DATE%>',document.complainA.<%=TO_DATE%>,event)" />

<label>Requested By</label>
<select id="userName" name="userName" tabindex="1">
	<option value="0">Select</option>
	<%for (Iterator iter = userList1.iterator(); iter.hasNext();) {
	        Object[] userGroups = (Object[]) iter.next();
	%>
	<option value="<%=userGroups[0] %>"><%=userGroups[1]+" "+userGroups[2]+" "+userGroups[3]%></option>
	<%}%>
</select> 

<div class="clear"></div>

<label>Request Type</label>
<select name="requested_type" tabindex="1">
<option value="">Select</option>
<option value="Software (MEDNET)">Software (MEDNET)</option>
<option value="Hardware">Hardware</option>
<option value="Network">Network</option>
</select>

<input type="button" name="search" value="Search" class="button" 
onClick="submitForm('complainA','user?method=searchComplainA');" accesskey="a" tabindex="1" />
</div>

<div class="clear paddingTop15"></div>
<%
	if(searchComplainList.size() > 0){
%>
<div id="reg">
<table class="cmntable" width="100%">

<tr>
<th>Complain Date</th>
<th>Complain By</th>
<th>Complain Type</th>
<th>Status</th>
</tr>

<%
System.out.println("Complain List JSP size--->>"+searchComplainList.size());
for(Complain complain : searchComplainList){
%>

<tr onclick="submitProtoAjax('complainA','/hms/hms/user?method=getComplainData&compainId=<%=complain.getId() %>')">
<td><%=HMSUtil.convertDateToStringWithoutTime(complain.getComplainDate()) %></td>
<%
		Iterator itrGridEmployeeList=gridEmployeeList.iterator();
		 while(itrGridEmployeeList.hasNext())
            {try{
             MasEmployee  masEmployee = (MasEmployee)itrGridEmployeeList.next(); 
			 if(complain.getRequestBy().getId().equals(masEmployee.getId())){
				test=complain.getRequestBy().getRank().getRankName().concat("  ").concat(complain.getRequestBy().getFirstName()).concat("  ").concat(complain.getRequestBy().getLastName());
			
            }else
            	{
            	test=complain.getRequestBy().getRank().getRankName().concat("  ").concat(complain.getRequestBy().getFirstName()).concat("  ").concat(complain.getRequestBy().getLastName());
            	}}catch(Exception e){System.out.println("Exception----> "+e);}}%>            	
<td><%=test %></td>
<td><%=complain.getRequestType()!=null?complain.getRequestType():"" %></td>
<td><%=complain.getStatus()!=null?complain.getStatus():"" %></td>
</tr>

<%} %>
</table>
</div>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>
<div id="testDiv">

<div class="clear paddingTop15"></div>
<h4>New Complain</h4>
<div class="Block">

<label>Date</label>
<input type="text" name="complainDate" value="<%=currentDate%>" tabindex="1" />

<label>Time</label>
<input type="text" name="ComplainTime" value="<%=time%>" tabindex="1" />

<label>Requested By</label>
<%
System.out.println("User List JSP size--->>"+userList.size());
for(Users user : userList)
{%>
<input type="text" name="user_name" tabindex="1"
value="<%=user.getEmployee().getRank().getRankName().concat("  ").concat(user.getEmployee().getFirstName()).concat("  ").concat(user.getEmployee().getLastName()) %>" />
<input type="hidden" name="requested_by1" value="<%=user.getEmployee().getId() %>" />
<input type="hidden" name="status" value="Open" />
<%} %>
<div class="clear"></div>

<label>Request Type</label>
<select name="req_type" tabindex="1">
<option value="">Select</option>
<option value="Software MEDNET">Software(MEDNET)</option>
<option value="Hardware">Hardware</option>
<option value="Network">Network</option>
</select>
<label>Description</label>
<textarea name="description" maxlength="300" onkeyup="chkLength(this,300);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" tabindex="1"></textarea>


<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
</div>
<input type="button" name="add" id="addbutton"	value="Submit" class="button" onClick="submitForm('complainA','user?method=submitComplainA');" accesskey="a" tabindex=1 />



</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>

<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>


<script language="JavaScript" type="text/JavaScript"><!--

 function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
 }

 </script> 
</form>
