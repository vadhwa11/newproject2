<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('myTextarea', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>

<script type="text/javascript">
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

<%@page import="jkt.hms.masters.business.HroEntry"%>
<HTML>
<HEAD>
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
	String entryNo = "";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	if(session.getAttribute("departmentName")!=null){
		departmentName=(String)session.getAttribute("departmentName");
	}
	
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
		}
	
	List<HroEntry> hroEntryList = new ArrayList<HroEntry>();
	if(map.get("hroEntryList") != null){
		hroEntryList = (ArrayList)map.get("hroEntryList");
	
		}
	
	String entryDate="";
	if(hroEntryList.get(0).getHroDate()!=null)
	{
		entryDate=HMSUtil.convertDateToStringWithoutTime(hroEntryList.get(0).getHroDate());
	}
	else
	{
		entryDate="";
	}
	
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	//String Session=(String) utilMap.get("session");
	String time = (String) utilMap.get("currentTime");	
	
	%>
			
	</SCRIPT>


<LINK href="/hms/jsp/css/hms_style.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>

<script type="text/javascript">  
function checkHroDate(){
	
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
</HEAD>

<BODY>
<DIV id=contentspace>
<% if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  } %>
<DIV id=contentHolder>
<DIV class="floatLeft"></DIV>

<form name="updateHroEntry" method="post" action=""><br />
<br />
<DIV class="blockTitle">HRO Entry</DIV>
<DIV class="blockTitleCurve"></DIV>
<br>
<DIV class="blockFrame">
<DIV class=Clear></DIV>
<Label>Entry No<font id="error">*</font></Label> <%if(hroEntryList.get(0).getEntryNo() != null){ %>
<label class="value"><%=hroEntryList.get(0).getEntryNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <input type="hidden" name="entryNo"
	value="<%=hroEntryList.get(0).getEntryNo() %>">
<div class="clear"></div>

<Label class="bodytextB1">Date<font id="error">*</font></Label> <%if(hroEntryList.get(0).getHroDate() != null){ %>
<input type="text" id="inputDate" name="<%=ENTRY_DATE%>"
	value="<%=entryDate%>" readonly="readonly" MAXLENGTH="30"
	validate="Pick a date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date%>',document.updateHroEntry.<%= ENTRY_DATE%>,event);"
	class="calender" /> <%}else{ %> <label class="value">-</label> <%} %> <Label>Serial
No<font id="error">*</font></Label> <%if(hroEntryList.get(0).getSerialNo() != null){ %>
<input type="text" maxlength="20" name=<%=SERIAL_NO %>
	value="<%=hroEntryList.get(0).getSerialNo() %>"
	validate="Serial No, string,yes"> <%}else{ %> <input type="text"
	maxlength="20" name=<%=SERIAL_NO %> value=""
	validate="Serial No, string,yes"> <%} %>

<div class="clear"></div>

<div class="clear"></div>

<script type="text/javascript">
function printVal(){
  WYSIWYG.updateTextArea("myTextarea");
return true;
}
</script> <textarea id="myTextarea" name="<%=TEXT_CONTENT%>"
	class="tableTextareaEditor" value="">
<%=hroEntryList.get(0).getTextContent() %>
</textarea></div>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>" /> <br>
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
<label>&nbsp;</label> <input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />


<DIV id=edited></DIV>
<div clas="clear"></div>
<div class="bottom"><input class="button" type="button"
	onClick="if(printVal()){submitForm('updateHroEntry','/hms/hms/hrOrderly?method=editHroEntryUpdate', checkHroDate());}"
	value="Update" /> <INPUT class=button id=back accessKey=b type=button
	value=Print name=print
	onClick="submitForm('updateHroEntry','/hms/hms/hrOrderly?method=printHroEntry');" />
<INPUT class=button id=back accessKey=b type=button value=Close
	name=close onclick="javascript:window.close();" /> <INPUT type=hidden
	name="<%=STATUS %>" /> <INPUT type=hidden name="<%= COMMON_ID%>" /></div>
</form>
</DIV>
</DIV>

</BODY>
</HTML>
