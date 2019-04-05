<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>

<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/editor.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<script language="JavaScript" type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg1.js"></script>
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup

WYSIWYG.attach('myTextarea', full);

// Use it to attach the editor directly to a defined textarea

 // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ProposalForHroEntry"%>
<HTML>


<HEAD>

<form name="updateProposalHRO" method="post" action=""><SCRIPT>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
			
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
<%	String 	userName="";
	String 	departmentName="";
	int deptId = 0;
	String entryNo ="";
	
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
		}
	
	int id = 0;
	if(map.get("Id") != null)
	{
		id = (Integer)map.get("Id");
	}
	System.out.println("    "+entryNo+"    "+id );
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	if(session.getAttribute("departmentName")!=null){
		departmentName=(String)session.getAttribute("departmentName");
	}
	if(session.getAttribute("deptId")!= null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList = (ArrayList)map.get("employeeList");
	
		}
	
	List<ProposalForHroEntry> proposalList = new ArrayList<ProposalForHroEntry>();
	if(map.get("proposalList") != null){
		proposalList = (ArrayList)map.get("proposalList");
	
		}
	
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}
     System.out.println("list size "+ departmentList.size());
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");	
	String entryDate="";
	if(proposalList.get(0).getPropsalDate()!=null)
	{
		entryDate=HMSUtil.convertDateToStringWithoutTime(proposalList.get(0).getPropsalDate());
	}
	else
	{
		entryDate="";
	}
	%>
			
	</SCRIPT>
</head>
<LINK href="/hms/jsp/css/hms_style.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/style.css" type=text/css rel=stylesheet>

<script type="text/javascript">


function checkPropDate(){
	
	var date=document.getElementById("inputDate").value;
	
	var inputDate=new Date(date.substring(6),(date.substring(3,5) - 1) ,date.substring(0,2));
	var currentDate=new Date();
	if((inputDate > currentDate))
	{
		
		return true;
	}
	else
	{
	alert(" Date should be greater than current date!!");
	document.getElementsId("inputDate").focus();
	return false;
	}
	
}


</script>



<BODY>

<div id="contentHolder">
<div class="Clear"></div>
<% if(map.get("message") != null){
	   String message = (String)map.get("message");
	   %>
<h2>message</h2>
<% } %>
<div class="Clear"></div>
<h6>Proposal For HRO Entry</h6>
<DIV class="blockFrame">
<DIV class=Clear></DIV>

<Label>Entry No<font id="error">*</font></Label> <%if(proposalList.size()>0){ %>
<label class="value"><%=proposalList.get(0).getEntryNo()%></label> <input
	type="hidden" name="entryNo"
	value="<%=proposalList.get(0).getEntryNo()%>" /> <%} %> <Label
	class="bodytextB1">Approved By:</label> <select
	name="<%= EMPLOYEE_NAME %>">
	<%if(proposalList.get(0).getEmployeeName()!=null){ %>
	<option value="<%=proposalList.get(0).getEmployeeName() %>"><%=proposalList.get(0).getEmployeeName().getFirstName() %><%=proposalList.get(0).getEmployeeName().getMiddleName() %><%=proposalList.get(0).getEmployeeName().getLastName() %></option>
	<%}
		if(employeeList.size()>0){
			for (MasEmployee masEmployee : employeeList) {
				
		%>

	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>

	<%
			}
		}
		%>
</select>

<DIV class=Clear></DIV>
<Label class="bodytextB1">Department:</label> <input type="hidden"
	name="<%=DEPARTMENT_NAME%>" value="<%=departmentName %>"> <%
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%> <label><%=masDepartment.getDepartmentName()%></label> <%	break;	
			}
				}

			%> <Label class="bodytextB1">Date<font id="error">*</font></Label> <input
	type="text" id="inputDate" name="<%=ENTRY_DATE%>"
	value="<%=entryDate%>" readonly="readonly" MAXLENGTH="30"
	validate="Pick a date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date%>',document.updateProposalHRO.<%= ENTRY_DATE%>,event);"
	class="calender" />

<div class="clear"></div>
<Label>Subject<font id="error">*</font></Label> <%if(proposalList.get(0).getSubject() != null){ %>
<input type="text" maxlength="100" id="txt" style="width: 500px"
	name="<%=SUBJECT_NAME %>"
	value="<%=proposalList.get(0).getSubject() %>"
	validate="Subject,string,yes" /> <%}else{ %> <input type="text"
	maxlength="100" id="txt" style="width: 500px" name="<%=SUBJECT_NAME %>"
	value="" validate="Subject,string,yes" /> <%} %>
<div class="clear"></div>

<!-- <input type="button" name="btnBold" value="B" id="btnB" onclick="formatText ('b');" /> -->
<!--<input type="button" name="btnUnderline" id="btnU" value="U" onclick="formatText ('u');" />-->
<div class="clear"></div>

<script type="text/javascript">
function printVal(){
  WYSIWYG.updateTextArea("myTextarea");
return true;
}
</script> <%if(proposalList.size()>0){ %> <textarea id="myTextarea"
	name="<%=TEXT_CONTENT%>" class="tableTextareaEditor" value=""><%= proposalList.get(0).getTextContent() %></textarea>
<%}else{ %> <textarea id="myTextarea" name="<%=TEXT_CONTENT%>"
	class="tableTextareaEditor" value=""></textarea> <%} %>
</div>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" />

<DIV class="Clear"></DIV>
<LABEL class=bodytextB>Last Changed By:</LABEL>
<DIV class="changebydt"><%=userName%></DIV>
<LABEL class=bodytextB>Last Changed Date:</LABEL>
<DIV class="changebydt"><%=date%></DIV>
<LABEL class=bodytextB>Last Changed Time:</LABEL>
<DIV class=changebydt><%=time%></DIV>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" /> <INPUT
	type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>"> <INPUT
	type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>" />

<div id="edited"></div>
<DIV class="Clear"></DIV>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <input type="hidden"
	name="id" value="<%=id %>" />


<DIV id=edited></DIV>
<DIV class="Clear"></DIV>
<div class="bottom"><input class="button" type="button"
	onClick="if(printVal()){submitForm('updateProposalHRO','/hms/hms/hrOrderly?method=editProposalHroUpdate',checkPropDate());}"
	value="Update" /> <INPUT class=button id=reset accessKey=r
	onclick=resetCheck(); type=reset value=Reset name=Reset /> <INPUT
	class=button id=back accessKey=b type=button value=Print name=print
	onClick="submitForm('updateProposalHRO','/hms/hms/hrOrderly?method=printproposalForHro');" />
<INPUT class=button id=back accessKey=b type=button value=Close
	name=close onclick="javascript:window.close();" /> <INPUT type=hidden
	name="<%=STATUS %>" /> <INPUT type=hidden name="<%=COMMON_ID%>" /></DIV>
</div>


</BODY>
</HTML>
