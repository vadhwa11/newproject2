<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	String url="";
	String issueType="";
	int issueId=0;
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(url==""){
		url="stores?method=showIssueDispensaryJsp";
	}
	if(map.get("issueId") !=null){
		issueId=(Integer)map.get("issueId");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	
	if(map.get("issueType") !=null){
		issueType=""+map.get("issueType");
	}
	
	request.setAttribute("box",box);
	
%>
<form name="message" method="post">

<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><%=messageTOBeVisibleToTheUser %></h4>

<%}%> <%if(messageType.equals("failure")){%>

<h4>
<%=messageTOBeVisibleToTheUser %>
</h4>
<%}}%> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>


<%if(issueType.equalsIgnoreCase("RC")){%>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/stores?method=printRCIssueReport&issueId=<%=issueId %>&deptId=<%=deptId %>');" />
<%}
else if(issueType.equalsIgnoreCase("otherUnit")){%>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/stores?method=printIssueToOtherUnits&issueId=<%=issueId %>&deptId=<%=deptId %>');" />
<%}
else if(issueType.equalsIgnoreCase("DispToUnit")) 
{
%>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/stores?method=printIssueDispToUnits&issueId=<%=issueId %>&deptId=<%=deptId %>&flag=Unit');" />
<%
}
else if(issueType.equalsIgnoreCase("DispToFirstAid")) 
{
%>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/stores?method=printIssueDispToFirstAid&issueId=<%=issueId %>&deptId=<%=deptId %>&flag=FirstAid');" />
<%
}
else { %>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/stores?method=printIssueToDispensary&issueId=<%=issueId %>&deptId=<%=deptId %>');" />
<%} %>

<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>
<script type="text/javascript" language="javascript">
function submitprint(formName,issueId){
	obj = eval('document.'+formName)
	obj.action = "/hms/hms/stores?method=printDepartmentIssue&issueId="+issueId;
	obj.submit();
  }
</script>