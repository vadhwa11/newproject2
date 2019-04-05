<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<MasRank>rankList=new ArrayList<MasRank>();
	List<MasUnit>unitList=new ArrayList<MasUnit>();
	List<MasTrade> tradeList =new ArrayList<MasTrade>();
	List<MasUnit> presentList = new ArrayList<MasUnit>();
	
	
	List<EmpAfmsfDet> empAfmsfDetList=new ArrayList<EmpAfmsfDet>();
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("empAfmsfDetList") != null) {
 		empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
 	}
 	if (map.get("rankList") != null) {
 		rankList = (List<MasRank>) map.get("rankList");
 	}
 	if (map.get("unitList") != null) {
 		unitList = (List<MasUnit>) map.get("unitList");
 	}
 	
 	if (map.get("tradeList")!= null){
 		tradeList = (List<MasTrade>) map.get("tradeList");
 	}
 	
 	if(map.get("presentUnitList") != null){
 		presentList = (List<MasUnit>) map.get("presentUnitList");
 	}
 	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
 	}
 	String serviceNo = "";
 	if(map.get("serviceNo")!=null)
 	{
 		serviceNo = (String)map.get("serviceNo");
 	}
 	int empAfmsId =0;
 	String name  = "";
 	String lname = "";
 	int rankId =0;
 	int postedFromId =0;
 	int postedToId =0;
 	int trade=0;
 	int presentId =0;
 	String respDate ="";
 	String letterNo="";
 	String authOfPosting ="";
 	String status ="";
 	String recLetterNo ="";
 	String remarks = "";
 	String recDate ="";
 	String docStatus = ""; 
 	String message ="";
 	String afmsType ="";
 	String suffix = "";
 	String docs = "";
 	for(EmpAfmsfDet empAfmsfDet :empAfmsfDetList){
 		empAfmsId = empAfmsfDet.getId();
 		name = empAfmsfDet.getEmpName();
 		
 		if(empAfmsfDet.getEmpLastName() != null){
 			lname = empAfmsfDet.getEmpLastName();  			
 		}
 		if(empAfmsfDet.getRank() !=null)
 		rankId = empAfmsfDet.getRank().getId();
 		if( empAfmsfDet.getPostedFrom() !=null)
 		postedFromId = empAfmsfDet.getPostedFrom().getId();
 		if(empAfmsfDet.getPostedTo() !=null)
 		postedToId = empAfmsfDet.getPostedTo().getId();
 		if(empAfmsfDet.getFmsfDate() !=null){
 		respDate = ""+empAfmsfDet.getFmsfDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		  respDate=formatterOut.format(formatterIn.parse(respDate));
 		}
 		if(empAfmsfDet.getLetterNo() !=null)
 		letterNo = empAfmsfDet.getLetterNo();
 		if(empAfmsfDet.getAuthPosting() !=null)
 		authOfPosting = empAfmsfDet.getAuthPosting();
 		if(empAfmsfDet.getStatus() !=null)
 		status = empAfmsfDet.getStatus();
 	
 		if(empAfmsfDet.getTrade() != null)
 			trade = empAfmsfDet.getTrade().getId();
 		
 		if(empAfmsfDet.getLetterNo() != null)
 			recLetterNo = empAfmsfDet.getLetterNo();
 		
 		if(empAfmsfDet.getRecDate() != null){
 			recDate = ""+empAfmsfDet.getRecDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		recDate = formatterOut.format(formatterIn.parse(recDate));
 		}
 		if(empAfmsfDet.getRemarks() != null)
 	    	remarks = empAfmsfDet.getRemarks();
 		
 		if( empAfmsfDet.getUnit() !=null)
 			presentId = empAfmsfDet.getUnit().getId();
 		
 		if(empAfmsfDet.getServiceNo() != null){
 			serviceNo = empAfmsfDet.getServiceNo();
 		}
 		if(empAfmsfDet.getSuffix() != null){
 		    suffix = empAfmsfDet.getSuffix();
 	    }
 		docs = empAfmsfDet.getDocumentReceived()!=null?empAfmsfDet.getDocumentReceived():"";
 			if(empAfmsfDet.getPostInDate() == null && empAfmsfDet.getAuthPosting() == null ){
 			docStatus = "s";
 	    	}else{
 			docStatus = "e";
 	    	}
 			if(empAfmsfDet.getAfmsfType().equals("OUT")){
 				  afmsType = empAfmsfDet.getAfmsfType();
 	    	    message = message + "\n service person cleared this place!!";
 	       }
 	}
 	
 	if(empAfmsfDetList.size() == 0){
 		docStatus = "s";
 	}
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%><script>
/* if(document.getElementById("serviceNo").value  != null){
  	var serviceNo = document.getElementById("serviceNo").value;  
   	document.getElementById("serviceNo1").value = serviceNo ;
 }*/
 document.getElementById("serviceNo").value = '<%=serviceNo%>'
  document.getElementById('space').style.display = 'inline';
  
</script>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--  
<% //	if(message != ""){
	//String message = (String)map.get("message");
	%>
 <div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
	 <div class="mesg" style="width: 100%; height: 23px;">
      <%=message %>
	 </div>
	</div>
<%// } %>

-->
<%
 if(map.get("message") != null){
					 message = (String)map.get("message");
					%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<h4><%=message %></h4>
<% } %>
<div class="Clear"></div>
<h4>Details</h4>
<div class="Clear"></div>
<div class="Block"><input type="hidden" name="<%=EMP_AFMS_ID%>"
	value="<%=empAfmsId %>" /> <input type="hidden" name="docStatus"
	value="<%=docStatus%>" id="docStatus" /> <input type="hidden"
	name="afmsType" value="<%=afmsType%>" id="afmsType" /> <label>Service
No</label> <%if(serviceNo != ""){ %> <input type="text" name="serviceNo"
	id="serviceNo1" value="<%=serviceNo%>" readonly="true"
	validate="Service No,metachar,yes" tabindex="1" /> <%}
else{%> <input type="text" name="serviceNo" id="serviceNo1" value=""
	readonly="true" tabindex="1" validate="Service No,metachar,yes" /> <%}%>

<%--<label><span>*</span>
Suffix:</label> <%if(suffix != ""){ %> <input type="text" name="suffix"
	id="suffix" value="<%=suffix %>" tabindex="1" readonly="true" /> <%}else {%>
<select id="suffix" name="suffix" validate="Suffix,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> <%}%>
 --%> <%
if(empAfmsfDetList.size() ==0 && employeeList !=null && employeeList.size() >0){
 for(MasEmployee masEmployee :employeeList){	
 %> <label> First Name<span>*</span></label> <input type="text"
	validate="First Name,metachar,yes" name="<%=EMPLOYEE_FIRST_NAME %>"
	id="name"
	value="<%=masEmployee.getFirstName()!=null?masEmployee.getFirstName():""%>"
	MAXLENGTH="30" tabindex="1" validate="Name,String,Yes" /> <label>
Last Name<span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_LAST_NAME %>" id="lname"
	validate="Last Name,metachar,yes"
	value="<%=masEmployee.getLastName()!=null?masEmployee.getLastName():""%>"
	MAXLENGTH="30" tabindex="1" />

<div class="Clear"></div>
<label> Rank<span>*</span></label> <select name="<%=RANK_ID %>" validate="Rank,metachar,yes"
	id="rankId" tabindex="1">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
		if(masEmployee.getRank() !=null){
						if(masEmployee.getRank().getId() ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select> <label> Trade <span>*</span></label> <select name="<%=TRADE%>" validate="Trade,metachar,yes"
	id="trade" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
							 if(masEmployee.getTrade()!=null){
							 if(masEmployee.getTrade().getId() == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%}}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}}
					%>
</select> <label> Last Unit <span>*</span></label> <select validate="Trade,metachar,yes"
	name="<%=POSTED_FROM %>" id="lastUnit" tabindex="1"
	onchange="displayextrafields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(masEmployee.getUnit() !=null){
							if(masEmployee.getUnit().getId() ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> <%--- <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	tabindex="1" style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit"> --%>
<div class="Clear"></div>
<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Name,metachar,no" maxlength="30" tabindex="1" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,metachar,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit</label> <input
	type="checkbox" id="localUnit" class="radio" name="<%=LOCAL_UNIT %>"
	value="y" tabindex="1" /></div>

<label> Present Unit<span>*</span></label> <select validate="Trade,metachar,yes"
	name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}%>
</select> <label>Receipt Letter No<span>*</span> </label> <input type="text"
	name="<%=RECEIPT_LETTER_NO%>" id="receiptLetterNo" value="" validate="Trade,metachar,yes"
	MAXLENGTH="30" tabindex="1" /> <label>Receipt with Date<span>*</span>
</label> <input type="text" id="receiptDate" name="<%=RECEIPTDATE%>" value=""
	class="calDate" MAXLENGTH="30" readonly="readonly" 
	validate="Receipt Date,frdate,yes" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />
<div class="Clear"></div>
<label>Remarks</label> <!--  <input type="textarea"  name="<%=REMARKS%>" id="<%=REMARKS%>" value="<%=remarks%>" class="txtarea" MAXLENGTH="50" />-->
<textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /></textarea> <label>Docs Received</label> <textarea
	name="docReceived" id="docReceived" class="" tabindex="3"
	onpaste="return checkOnPaste(this)" validate="Doc Received,metachar,no"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1"></textarea> <%}}else{ %> <label>
First Name<span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=name%>"
	MAXLENGTH="30" tabindex="1" validate="Name,metachar,Yes" /> <label>
Last Name<span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_LAST_NAME %>" id="lname"
	validate="Last Name,metachar,Yes" value="<%=lname%>" MAXLENGTH="30"
	tabindex="1" />

<div class="Clear"></div>
<label> Rank<span>*</span></label> <select name="<%=RANK_ID %>"
	id="rankId" tabindex="1">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
						if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select> <label> Trade <span>*</span></label> <select name="<%=TRADE%>"
	id="trade" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
							 if(trade == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}}
					%>
</select> <label> Last Unit <span>*</span></label> <select
	name="<%=POSTED_FROM %>" id="lastUnit" tabindex="1"
	onchange="displayextrafields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(postedFromId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> <%--- <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	tabindex="1" style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit"> --%>
<div class="Clear"></div>
<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,metachar,no" maxlength="30" tabindex="1" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,metachar,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit</label> <input
	type="checkbox" id="localUnit" class="radio" name="<%=LOCAL_UNIT %>"
	validate="Is Local Unit,metachar,no" value="y" tabindex="1" /></div>

<label> Present Unit<span>*</span></label> <select
	name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> <label>Receipt Letter No<span>*</span> </label> <input type="text"
	name="<%=RECEIPT_LETTER_NO%>" id="receiptLetterNo"
	value="<%=letterNo%>" MAXLENGTH="30" tabindex="1" /> <label>Receipt
with Date<span>*</span> </label> <input type="text" id="receiptDate"
	name="<%=RECEIPTDATE%>" value="<%=recDate%>" class="calDate"
	validate="Receipt
with Date,frdate,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />
<div class="Clear"></div>
<label>Remarks</label> <!--  <input type="textarea"  name="<%=REMARKS%>" id="<%=REMARKS%>" value="<%=remarks%>" class="txtarea" MAXLENGTH="50" />-->
<textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /><%=remarks%></textarea> <label>Docs
Received</label> <textarea name="docReceived" id="docReceived" class=""
	tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	validate="Docs Received,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1"><%=docs%></textarea> <%} %>
</div>
<%-- <div class="Clear"></div>
<input type="button" name="edit" value="Submit" class="button"
	tabindex="1"
	onClick="if(checkAfmsfReceipt()){submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=receipt');}" />--%>
<div class="Clear"></div>
