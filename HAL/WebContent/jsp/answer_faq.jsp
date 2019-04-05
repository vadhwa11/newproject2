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
<form name="Answer" method="post" action="">

 <%
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 
 	List<QuestionFaq> QuestionList = new ArrayList<QuestionFaq>();
 	List<AnswerFaq> AnswerList  = new ArrayList<AnswerFaq>();
 		
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
int questionId=0;
	if(map.get("questionId")!=null)
 	{
		questionId=(Integer)map.get("questionId");
 		
 	}

 	if(map.get("QuestionList")!=null)
 	{
 		QuestionList=(List<QuestionFaq>)map.get("QuestionList");
 		
 	}
 	if(map.get("AnswerList")!=null)
 	{
 		AnswerList=(List<AnswerFaq>)map.get("AnswerList");
 		
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
 	
%>
 
<div class="titleBg">
<h2></h2>
<div class="floatRight">
<input type="button" name="Ques" tabindex="1" value="Queries" onClick="submitForm('Answer','/hms/hms/user?method=questionFaqJsp');" />
<input type="button" name="askQuestion" tabindex="1" value="Ask Queries" onClick="submitForm('Answer','/hms/hms/user?method=askQuestionJsp');" />
</div>
</div>
<div class="clear"></div>

<div class="Block">

<%
	if(QuestionList.size() > 0){
%>

<%

for(QuestionFaq Question : QuestionList){
%>

<h4 class="faqHd"><%=Question.getQuestionName()!=null?Question.getQuestionName():"" %></h4>

<input type="hidden" name="groupId" value="<%=Question.getId() %>" />

<div class="clear"></div>
<div class="faqQues"><%=Question.getQuestion()!=null?Question.getQuestion():"" %> <span> -  <%=Question.getLastChangeBy()!=null?Question.getLastChangeBy():"" %>  <%=Question.getLastChangeDate()!=null?HMSUtil.convertDateToStringWithoutTime(Question.getLastChangeDate()):"" %>  <%=Question.getLastChangeTime()!=null?Question.getLastChangeTime():"" %></span></div>
<%-- <textarea rows="50" cols="154" tabindex="1" name="Question" class="faq" size="150" readonly="readonly">
<%=Question.getQuestion()!=null?Question.getQuestion():"" %>  -  <%=Question.getLastChangeBy()!=null?Question.getLastChangeBy():"" %>  <%=Question.getLastChangeDate()!=null?HMSUtil.convertDateToStringWithoutTime(Question.getLastChangeDate()):"" %>  <%=Question.getLastChangeTime()!=null?Question.getLastChangeTime():"" %>
</textarea>--%>

<% } }
%>

<%
	if(AnswerList.size() > 0){
%>
<h4>Answers</h4>
<%

for(AnswerFaq Answer : AnswerList){
%>

<div class="clear"></div>
<div class="faqAns">
<%=Answer.getAnswer()!=null?Answer.getAnswer():"" %>
<span>  -  <%=Answer.getLastChangeBy()!=null?Answer.getLastChangeBy():"" %>  <%=Answer.getLastChangeDate()!=null?HMSUtil.convertDateToStringWithoutTime(Answer.getLastChangeDate()):"" %>  <%=Answer.getLastChangeTime()!=null?Answer.getLastChangeTime():"" %></span>
</div>
<%-- <textarea rows="50" cols="165" name="postedAnswer" class="faq" readonly="readonly"
onkeyup="chkLength(this,1000);" onpaste="return checkOnPaste(this)"	tabindex="1"
oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)">
<%=Answer.getAnswer()!=null?Answer.getAnswer():"" %><span>  -  <%=Answer.getLastChangeBy()!=null?Answer.getLastChangeBy():"" %>  <%=Answer.getLastChangeDate()!=null?HMSUtil.convertDateToStringWithoutTime(Answer.getLastChangeDate()):"" %>  <%=Answer.getLastChangeTime()!=null?Answer.getLastChangeTime():"" %></span>
</textarea>--%>

<div class="clear"></div>
<% } }
%>
<div class="clear paddingTop15"></div>

<h4>Type Your Answer</h4>

<textarea rows="100" cols="187" name="typeAnswer" id="typeAnswer" class="auto" size="187"
onkeyup="chkLength(this,1000);" onpaste="return checkOnPaste(this)"	tabindex="1"
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

<div class="clear"></div>
<input class="transparent" size="175" />
Max 1000 Char


</div>

<input type="hidden" name="questionId" value="<%=questionId %>"></input> 
<input type="button" name="postAnswer" value="Post" class="button"
onClick="if(chkBlankTextbox()){submitForm('Answer','user?method=submitPostAnswer&questionId=<%=questionId%>')}" accesskey="a" tabindex="1" />



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


<script language="JavaScript" type="text/JavaScript">

 function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
 }

function chkBlankTextbox()
{
	var tName=document.getElementById("typeAnswer");
	if(tName.value=="")
	{
		alert("Please type your Answer..");
		return false;
	}
	if(tName.value!="")
	{
		return true;
	}

}

 </script> 
</form>

