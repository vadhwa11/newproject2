<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<% 


	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	String url="";
	String indentNo="";
	String flag ="";
	String message ="success";
	int poId=0;
	int mprHeaderId =0;
	int quotationHeaderId = 0;
	int RRId=0;
	int IndentId=0;
	int grnHeaderId=0;
	int ReturnedMedicineId =0;
	Box box=null;
	String printUrl = "";
	String poNumber="";
	String DiscrepancyFlag="N";
	String DisposalNo ="";
	int mrHeaderId =0;
	int requestHeaderId =0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	if(map.get("flag") !=null){
		flag=""+map.get("flag");
	}
	if(map.get("poId") !=null){
		poId=Integer.parseInt(""+map.get("poId"));
	}
	if(map.get("requestHeaderId") !=null){
		requestHeaderId=Integer.parseInt(""+map.get("requestHeaderId"));
	}
	if(map.get("RRId") !=null){
		RRId=Integer.parseInt(""+map.get("RRId"));
	}
	if(map.get("mprHeaderId") !=null){
		mprHeaderId=Integer.parseInt(""+map.get("mprHeaderId"));
	}
	
	if(map.get("mrHeaderId") !=null){
		mrHeaderId=Integer.parseInt(""+map.get("mrHeaderId"));
	}
	if(map.get("quotationHeaderId") !=null){
		quotationHeaderId=Integer.parseInt(""+map.get("quotationHeaderId"));
	}
	if(map.get("IndentId") !=null){
		IndentId=Integer.parseInt(""+map.get("IndentId"));
	}
	
	if(map.get("grnHeaderId") !=null){
		grnHeaderId=Integer.parseInt(""+map.get("grnHeaderId"));
	}
	
	
	
	if(map.get("ReturnedMedicineId") !=null){
		ReturnedMedicineId=Integer.parseInt(""+map.get("ReturnedMedicineId"));
	}
	

	if(map.get("DiscrepancyFlag") !=null){
		DiscrepancyFlag=(String)map.get("DiscrepancyFlag");
	}
	
	if(map.get("DisposalNo") !=null){
		DisposalNo=(String)map.get("DisposalNo");
	}
	
	

	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	
	if(map.get("indentNo") !=null){
		indentNo=""+map.get("indentNo");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	request.setAttribute("box",box);
	
	if(map.get("printUrl") !=null){
		printUrl=""+map.get("printUrl");
	}
	if(map.get("poNumber")!=null){
		poNumber=map.get("poNumber").toString();
	}
%>
<form name="message" method="post">

<div class="titleBg">
<h2><%out.print(message); %></h2>
</div>


<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<%
	if(flag.equalsIgnoreCase("PO"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generatePo&poId=<%=poId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showPurchaseOrderJsp');" />
		<%
	}
%>

<%
	if(flag.equalsIgnoreCase("MPR"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateMrp&mrpId=<%=mprHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showMPRScreen');" />
		<%
	}
%>

<%
	if(flag.equalsIgnoreCase("QUOT"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generatevendorQuotationReport&headerId=<%=quotationHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=createRequestForQuotation');" />
		<%
	}
%>

<%
	if(flag.equalsIgnoreCase("RR"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateReceivingReport&grnId=<%=RRId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=createRequestForQuotation');" />
		<%
	}
%>

<%
	if(flag.equalsIgnoreCase("POIndent"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateIndentFormReport&poHeaderId=<%=IndentId %>&flag=si');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=createIndentForSupplier&selectedAppId=A1644&childAppId=A1645');" />
		<%
	}

	if(flag.equalsIgnoreCase("RRInspection"))
	{		
		%>
			<input type="button" value="Receiving Report" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateReceivingReport&grnId=<%=grnHeaderId %>');" />
			<% if(DiscrepancyFlag.equalsIgnoreCase("Y")){%><input type="button" value="Discrepancy Note" class="button" onClick="submitForm('message','/hms/hms/stores?method=printDiscrepancyNoteReport&GrnID=<%=grnHeaderId %>');" /><%} %>
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showWaitingListofRRInspection&selectedAppId=A1650');" />
		<%
	}

	if(flag.equalsIgnoreCase("RRApproval"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateReceivingReport&grnId=<%=grnHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showAwaitingofRRApproval&selectedAppId=A1651');" />
		<%
	}

	

	if(flag.equalsIgnoreCase("ReturnedMedicine"))
	{
		
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=printReturnedMedicineListReport&grnHeaderId=<%=ReturnedMedicineId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showUnusedMedicineScreen&selectedAppId=A1654');" />
		<%
	}
	
	if(flag.equalsIgnoreCase("MR"))
	{ 
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=printDispensaryToStoreJsp&mrId=<%=mrHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showMRScreen&selectedAppId=A1669');" />
		<%
	}
	if(flag.equalsIgnoreCase("Ward"))
	{ 
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=printDispensaryToStoreJsp&mrId=<%=mrHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showMRScreenForMIssue&selectedAppId=A1669');" />
		<%
	}
	if(flag.equalsIgnoreCase("RC"))
	{
		%>
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateRCReport&requestHeaderId=<%=requestHeaderId %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showRCScreen&selectedAppId=A1669');" />
		<%
	}
	
	if(flag.equalsIgnoreCase("ResetPassword"))
	{
		%>
			
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/user?method=showPendingListofResetPassword&selectedAppId=A1679');" />
		<%
	}
	
	if(flag.equalsIgnoreCase("Disposal"))
	{
		
		%>
			
			<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/stores?method=generateDrugDisposalActionReport&DisposalNo=<%=DisposalNo %>');" />
			<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/stores?method=showPendingListofActionofDrugDisposal&selectedAppId=A1675');" />
		<%
	}
%>



<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>
