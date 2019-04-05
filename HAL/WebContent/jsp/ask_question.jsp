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
<form name="AskQuestion" method="post" action="">

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
<h2>Ask Query</h2>
</div>
<div class="clear"></div>


<div class="Block">

<label>Module Name<span>*</span></label>
<select name="moduleName" validate="Module Name,string,yes">
<option value="">Select</option>
<option value="Reception">Reception</option>
<option value="OPD">OPD</option>
<option value="Dispensary">Dispensary</option>
<option value="Medical Stores">Medical Stores</option>
<option value="Laboratory">Laboratory</option>
<option value="Medical Board">Medical Board</option>
<option value="Medical Exam">Medical Exam</option>
<option value="Station Health Statistics">Station Health Statistics</option>
<option value="Ward">Ward</option>
<option value="Physiotherapy">Physiotherapy</option>
<option value="Aviation Medicine">Aviation Medicine</option>
<option value="Dental">Dental</option>
<option value="SHO">SHO</option>
<option value="Family Welfare Center">Family Welfare Center</option>
<option value="Emergency">Emergency</option>
<option value="Radiology">Radiology</option>
<option value="ECG Room">ECG Room</option>
<option value="Monitoring">Monitoring</option>
<option value="Master">Master</option>
<option value="Miscellaneous">Miscellaneous</option>
</select>

<div class="clear"></div>

<label>Subject</label>
<textarea rows="100" cols="154" class="auto" size="155" name="questionName" tabindex="1"
onkeyup="chkLength(this,200);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

<div class="clear"></div>

<input class="transparent" size="170" />
Max 200 Char
<div class="clear"></div>

<label>Type Your Query</label>
<textarea rows="100" cols="154" class="auto" size="155" name="newQuestion" tabindex="1"
onkeyup="chkLength(this,1000);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

<div class="clear"></div>

<input class="transparent" size="170" />
Max 1000 Char
<div class="clear"></div>

</div>

<input type="button" name="postAnswer" value="Post" 
onClick="submitForm('AskQuestion','user?method=submitAskQuestion');" accesskey="a" tabindex="1"/>

<input type="button" name="Ques" tabindex="1" value="Back" onClick="submitFormForButton('AskQuestion','/hms/hms/user?method=questionFaqJsp');" />

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

