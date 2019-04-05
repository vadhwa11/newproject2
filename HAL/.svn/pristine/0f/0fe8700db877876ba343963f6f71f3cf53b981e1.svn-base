<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
	int issueId = 0;
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
		//System.out.println("Url is--------------------------"+url);
	}
	if(map.get("issueId") !=null){
		issueId=Integer.parseInt(""+map.get("issueId")) ;
	}
	
	System.out.println(":::::2:::::::::::::::"+box);
	
%>
		<div id="contentspace">
		<form name="message" method="post">
		<input name="issueId" value="<%=issueId%>" type="hidden" />
		<br/><br/>
		
		
		
	<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
  			<div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
			<div class="mesg" style="width: 100%; font-weight:bold; height: 23px;">
				<%=messageTOBeVisibleToTheUser + ". Now import process is going on........." %>  		
			</div>
 			</div>

	<%}%>
	<%if(messageType.equals("failure")){%>

 		<div id="errorMsg" style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
			<div style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight:bold; height: 23px; background-color: #FFE8E8;  float : left;  width : 100%; color: red; border: 1px solid red;">
			<%=messageTOBeVisibleToTheUser %>  		
			</div>
 			</div>
		<%}}
	   // System.out.println("ISSUE_NO in jsp for store message================="+box.get("issueNo"));
		%>
	  	  
		<br/>
	<input type="hidden" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo" value="<%=box.get("issueNo")%>"  class="textbox_size20" MAXLENGTH="8"/  >
	<input type="hidden" name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp" validate='Dispensery Name,num,Yes' value="<%=box.get("departmentIdTemp") %>" >
	<input type="hidden" name="<%= RequestConstants.REFERENCE %>"  id="reference" value="<%=box.get("reference") %>" class="textbox_size20"  MAXLENGTH="30" />
	<input type="hidden" name="<%= RequestConstants.REQUEST_BY%>"  id="requestBy" validate="Request By,String,Yes" value="<%=box.get("requestBy")%>">
	<input type="hidden" name="<%= RequestConstants.APPROVED_BY%>" id="approvedBy" value="<%=box.get("approvedBy") %>" validate="Approved By,String,Yes">
	<input type="hidden" name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy"  value="<%=box.get("issuedBy")%>" >
	<input type="hidden" name="<%= RequestConstants.REQUEST_NO%>" id="requestNo" value="<%=box.get("requestNo")%>" >
	<input type="hidden" name="<%= RequestConstants.REQUEST_DATE%>" id="<%= RequestConstants.REQUEST_DATE %>"  value="<%=box.get("requestDate")%>" >
	<!--<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');" />-->
		</form>
		</div>
		<script language="Javascript" type="text/javascript">
            		submitForm('message','stores?method=searchInternalIndentDetails');
        </script>
		
		
		
		
		