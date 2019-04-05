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

<%@page import="jkt.hms.masters.business.QuestionFaq"%>
<%@page import="jkt.hms.masters.business.AnswerFaq"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.poi.util.SystemOutLogger"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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



<form name="Question" method="post" action="">

 <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
  	List<Object[]> QuestionList = new ArrayList<Object[]>();
  	BigDecimal AnsNumber=new BigDecimal(0);	
  	String userName="";
	session = request.getSession();
	
	if(session.getAttribute("userName")!=null)
	{
		userName=(String)session.getAttribute("userName");
	}
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	
	String currentDate = (String) utilMap.get("currentDate");
 	
 	String time = (String) utilMap.get("currentTimeWithoutSc");
 	 	
	Integer hospitalId=0;
	
	
	Map<String, Object> map = new HashMap<String, Object>();
	
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}

 	if(map.get("QuestionList")!=null)
 	{
 		QuestionList=(List<Object[]>)map.get("QuestionList");
 	}
 	
 	if(map.get("AnsNumber")!=null)
 	{
 		AnsNumber=(BigDecimal)map.get("AnsNumber");
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
	
 	String test="";
%>
 
<div class="titleBg">
<h2>Discussion Forum</h2>

<div class="floatRight">

<input type="button" name="askQuestion" tabindex="1" value="Post Query" onClick="submitFormForButton('Question','/hms/hms/user?method=askQuestionJsp');" tabindex="1" />
</div>

</div>
<div class="clear"></div>

<div class="Block">

<label>Module Name<span>*</span></label>
<select name="moduleName" validate="Module Name,string,yes" onchange="displayKeyWord(this);">
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

<div id="keyWordDiv" style="display: none;">

<label>Key Words</label>
<input type="text" name="searchText" tabindex="1" />

<input type="button" class="buttonBig" name="searchBtn" value="Search By Key Words" 
onClick="submitForm('Question','user?method=searchDiscussionBoard');" accesskey="a" tabindex="1"/>

</div>

<input type="button" class="buttonBig" name="Ques" tabindex="1" value="Show All Queries" onClick="submitFormForButton('Question','/hms/hms/user?method=questionFaqJsp');" />
</div>

<div class="clear paddingTop15"></div>

<%
	if(QuestionList.size() > 0){
%>
<div id="reg">
<div class="faq">
<table width="100%">
<tr>

<th>Queries</th>
<th>Answers</th>
<th>Posted By</th>
<th>Date</th>
</tr>

<%
int id= (Integer)QuestionList.size();

for(Object[] Question : QuestionList){
%>

<tr onclick="submitFormForButton('Question','/hms/hms/user?method=answerFaqJsp&questionId=<%=Question[0] %>')">

<td><h4><%=Question[1]!=null?Question[1]:"" %></h4></td>
<td><h4><%=Question[2]%></h4></td>
<td><h4><%=Question[3]%></h4></td>
<td><h4><%=HMSUtil.convertDateToStringWithoutTime((Date)Question[4])%></h4></td>

</tr>

<%} %>
</table>
<%}else{ %>
<h4>No Record Found</h4>

</div>
</div>
<%}%>

<div class="clear paddingTop15"></div>

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


function displayKeyWord(obj){
	if(obj.value!=""){
				document.getElementById('keyWordDiv').style.display='block';
		
	}else {
				document.getElementById('keyWordDiv').style.display='none';
	
	}
}


 </script> 
</form>

