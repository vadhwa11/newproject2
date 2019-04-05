

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	
	
	String url="";
	String indentNo="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	String printMessage="";
	Box box=null;
	String visitNo="";
	String visitId="";
	String nisStatus = "n";
	String facStatus = "n";
	String serviceNo="";
	String hinNo="";
	int hospitalId=0;;
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("message")!=null){
		printMessage=map.get("message").toString();
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
		url="/hms/hms/opd?method=showPendingNIPPrescriptionJsp";
	}
	if(map.get("indentNo") !=null){
		indentNo=""+map.get("indentNo");
	}
	if(map.get("visitId") !=null){
		visitId=""+map.get("visitId");
	}
	System.out.println("Visit--P-->"+visitId);
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	request.setAttribute("box",box);
	
	
	if(map.get("visitNumber")!=null){
		visitNo=map.get("visitNumber").toString();
	}
	if(map.get("serviceNoS")!=null){
		serviceNo=map.get("serviceNoS").toString();
	}
	if(map.get("hinNoS")!=null){
		hinNo=map.get("hinNoS").toString();
	}
	if(map.get("hospitalId")!=null){
		hospitalId=(Integer)map.get("hospitalId");
	}
	if(map.get("nisStatus")!=null){
		nisStatus=(String)map.get("nisStatus");
	}
	if(map.get("facStatus")!=null){
		facStatus=(String)map.get("facStatus");
	}
	String printUrl = "/hms/hms/stores?method=printPricriptionIssue&visitId="+visitId+"&serviceNo="+serviceNo+"&hinNo="+hinNo+"&hospitalId="+hospitalId;	
	String printNisUrl = "/hms/hms/stores?method=printNIS&visitId="+visitId+"&serviceNo="+serviceNo+"&hinNo="+hinNo+"&hospitalId="+hospitalId;	
%>
<form name="message" method="post">
<h4>
<%=printMessage%> 
</h4> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<%-- <input type="button" value="Print Prescription" class="buttonBig" onClick="checkTargetForYes();submitForm('message','<%=printUrl %>');checkTargetForNo();" />
<%if(nisStatus.endsWith("y") && facStatus.equals("n")){ %>
<input type="button" value="NIS" class="button" onClick="submitForm('message','<%=printNisUrl%>');" />
<%} %> --%>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');checkTargetForNo();" />
<!--<input type="button" value="Export To Excel" name="exportExcel" class="buttonBig" onClick="submitForm('message','/hms/hms/stores?method=generateExcelForDepot1');"  />
--><input type="hidden" name="indentNo" id="indentNo" value="<%=indentNo%>">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

