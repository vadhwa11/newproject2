<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.*"%>
<%@page	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>



<%
 	String message= null;
    String search = "n";
 	int storeGrnReturnMId =0;
 	int storeGrnInternalId=0;
 	Map map = new HashMap();
 	String url="";
 	String flag="";
 	String messageTOBeVisibleToTheUser="";
 	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
 	if(map.get("message")!=null){
 		message =(String)map.get("message");
	}
 	if(map.get("url") != null){
 		url =(String)map.get("url");
 		System.out.println("in url  "+url);
 	}
 	
 	if(map.get("search") != null){
 		search =(String)map.get("search");
 		System.out.println("in search  "+search);
 	}
 	if(map.get("flag") != null){
 		flag =(String)map.get("flag");
 		System.out.println("in flag  "+flag);
 	}
 	String flagGrn="";
 	if(map.get("flagGrn") != null){
 		flagGrn =(String)map.get("flagGrn");
 		System.out.println("in flagGrn  "+flagGrn);
 	}
 	
 
 %>
<script type="text/javascript">
	function cancelForm(){
	//window.opener.document.getElementById('storeGrnReturnMId').value=<%=storeGrnReturnMId%> ;
  	 close();
   	}
</script>


<form name="message" method="post">
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="clear"></div>
<% if(flag.equals("return")) {
%>
<input id="exit" property="exit" type="button" name="exit" value="Back"	class="button"
	onclick="submitForm('message','<%=url%>');" />
	<%if(flagGrn!=null && flagGrn.equals("departmentReturn")){
		
		if(map.get("storeGrnInternalId")!=null){
	 		storeGrnInternalId =Integer.parseInt(""+map.get("storeGrnInternalId"))  ;
	 		}  
		%>
	

	<input type="hidden" name="<%=ISSUE_RETURN_ID %>" value="<%=storeGrnInternalId%>" id="storeGrnInternalId" />
	<input id="exit" property="exit" type="button" name="exit" value="Print"	class="button"	onclick="submitForm('message','stores?method=printDepartmentReturnJsp');" />
		<%}else if(flagGrn!=null &&  flagGrn.equals("vendorReturn")){
			
			if(map.get("storeGrnReturnMId")!=null){
				storeGrnReturnMId =Integer.parseInt(""+map.get("storeGrnReturnMId"))  ;
		 		}
			%>
		<input type="hidden" name="<%=ISSUE_RETURN_ID %>" value="<%=storeGrnReturnMId%>" id="storeGrnReturnMId" />
		<input id="exit" property="exit" type="button" name="exit" value="Print"	class="button"	onclick="submitForm('message','stores?method=printVendorReturnJsp');" />
	
		<%} %>
<%}else{ %>
<input id="exit" property="exit" type="button" name="exit" value="Back"	class="button"
	onclick="if(<%=search.equals("y")%>){submitForm('message','stores?method=showOPDPatientIssue');}else{cancelForm();}" /> 
	<%} %>
	
</form>



