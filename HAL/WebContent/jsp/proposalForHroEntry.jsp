<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/editor.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>

<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
WYSIWYG.attach('myTextarea', full);

// Use it to attach the editor directly to a defined textarea

 // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>
<SCRIPT>
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
	
	List<MasEmployee> masEmpList=new ArrayList<MasEmployee>();
	if(map.get("searchMasEmployeeList") != null)
	{
	 masEmpList = (ArrayList)map.get("searchMasEmployeeList");
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

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");	
	
	%>
			
	</SCRIPT>







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



<form name="propsalForHroEntry"  method="post" action="">
<div id="contentHolder">
<div class="Clear"></div>
<% if(map.get("message") != null){
	   String message = (String)map.get("message");%>
	   <h2 style="color:#AC1400;width:200px;"><%=message %></h2>
	 <% } %>
<div class="Clear"></div>
<h6>Proposal For HRO Entry</h6>
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<Label>Entry No<font id="error">*</font></Label>
<label class="value" ><%=entryNo %></label>
<input type="hidden" name=<%=ENTRY_NO %> value="<%=entryNo %>">


<Label class="bodytextB1">Approved By:</label>
<select name="<%= APPROVED_BY %>" id="<%=APPROVED_BY %>>
		
		<option value="0">Select</option>
		<%
			for(MasEmployee masEmployee : masEmpList){
			%>
						<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ masEmployee.getMiddleName() + masEmployee.getLastName()%></option>           
				        <%		} %>
	    </select>

<DIV class=Clear></DIV>
<Label class="bodytextB1">Department:</label>
<%
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%>
<label><%=masDepartment.getDepartmentName()%></label>
<input type="hidden" name="<%=DEPARTMENT_NAME%>" value="<%=masDepartment.getDepartmentName() %>">					
			<%	break;	
				}
				}
			%>
<Label class="bodytextB1">Date<font id="error">*</font></Label>
<input type="text" id="inputDate"  name="<%=ENTRY_DATE%>" value="<%=date%>"  readonly="readonly"  MAXLENGTH="30" validate="Pick a date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.propsalForHroEntry.<%= ENTRY_DATE%>,event);" class="calender" /> 

<div class="clear"></div>
<Label>Subject<font id="error">*</font></Label>
 <input type="text" id="txt" style="width: 500px" maxlength="100" name="<%=SUBJECT_NAME %>" validate="Subject,string,yes"  />	
<div class="clear"></div>

<div class="clear"></div>
 
 <script type="text/javascript">
function printVal(){
  WYSIWYG.updateTextArea("myTextarea");
return true;
}
</script>
 
 <textarea id="myTextarea" name="<%=TEXT_CONTENT%>" class="tableTextareaEditor"  >

</textarea>
  
 </div>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" />

 <DIV class="Clear"></DIV>
 <LABEL class=bodytextB>Last Changed By:</LABEL> 
<DIV class="changebydt"><%=userName%></DIV>
<LABEL class=bodytextB>Last Changed Date:</LABEL> 
<DIV class="changebydt"><%=date%></DIV>
<LABEL class=bodytextB>Last Changed Time:</LABEL> 
<DIV class=changebydt><%=time%></DIV>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" />
 <INPUT type=hidden value="<%=date%>" name="<%=CHANGED_DATE %>">
  <INPUT type=hidden value="<%=time%>" name="<%=CHANGED_TIME %>" /> 
				
			<div id="edited"></div>
			<label>&nbsp;</label>
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	  
 <DIV id=edited></DIV>
<div class="clear"></div>
<div class="bottom">
<input class="button"  type="button" onClick="if(printVal()){submitForm('propsalForHroEntry','/hms/hms/hrOrderly?method=addProposalForHro',checkPropDate());}"  value="Submit" /> 
<!-- <INPUT class=button id=reset accessKey=r  onclick="resetCheck();" type=reset value=Reset name=Reset /> 
<INPUT class=button id=back accessKey=b type=button value=Print name=print />-->
<INPUT class=button accessKey=r type=button value=Search name=search onClick="window.open('hrOrderly?method=showProposalHroSearchJsp')" />
<INPUT class=button id=back accessKey=b type=button value=Close name=close onclick="javascript:history.back();"/> 
<INPUT type=hidden name="<%=STATUS %>" />
<INPUT type=hidden name="<%= COMMON_ID%>" />
</div>
</div>
</form>

	
