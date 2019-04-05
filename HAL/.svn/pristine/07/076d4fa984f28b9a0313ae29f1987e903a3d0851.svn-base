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
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
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
 	if(map.get("presentUnitList") != null){
 		presentList = (List<MasUnit>) map.get("presentUnitList");
 	}
 	
 	if (map.get("tradeList")!= null){
 		tradeList = (List<MasTrade>) map.get("tradeList");
 	}
 	String serviceNo = "";
 	if(map.get("serviceNo")!=null)
 	{
 		serviceNo = (String)map.get("serviceNo");
 	}
 	if (map.get("employeeList") != null) {
 		employeeList = (List<MasEmployee>) map.get("employeeList");
 	}
 	String message ="";
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
 	String disRemarks = "";
 	String recDate ="";
 	
 	String disLetterNo ="";
 	String disDate ="";
 	String docStatus ="";
 	String postInDate ="";
 	String suffix = "";
 	String disLetterVal="";
 	
 	
 	for(EmpAfmsfDet empAfmsfDet :empAfmsfDetList){
 		empAfmsId = empAfmsfDet.getId();
 		name = empAfmsfDet.getEmpName();
 		if(empAfmsfDet.getEmpLastName() != null){
 			lname = empAfmsfDet.getEmpLastName();  			
 		}
 		
 		if(empAfmsfDet.getRank() !=null)
 		rankId = empAfmsfDet.getRank().getId();
 		if( empAfmsfDet.getUnit() !=null)
 		postedFromId = empAfmsfDet.getUnit().getId();
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
 		if(empAfmsfDet.getDisLetterNo() != null)
 		disLetterVal=empAfmsfDet.getDisLetterNo();
 		
 		if(empAfmsfDet.getDisLetterNo() != null && empAfmsfDet.getDisLetterNo() != "")
 			disLetterNo = empAfmsfDet.getDisLetterNo();
 		
 		if( empAfmsfDet.getUnit() !=null)
 			presentId = empAfmsfDet.getUnit().getId();
 		
 		
 		if(empAfmsfDet.getDisDate() != null){
 			disDate = ""+empAfmsfDet.getDisDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		disDate = formatterOut.format(formatterIn.parse(disDate));
 		}
 		
 		if(empAfmsfDet.getRecDate() != null){
 			recDate = ""+empAfmsfDet.getRecDate();
 	 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 	 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 	 		recDate = formatterOut.format(formatterIn.parse(recDate));
 		}
 		
 		if(empAfmsfDet.getDisRemarks() != null)
 	    	disRemarks = empAfmsfDet.getDisRemarks();
 		
 		if(empAfmsfDet.getServiceNo() != null){
 			serviceNo = empAfmsfDet.getServiceNo();
 		}
 		if(empAfmsfDet.getSuffix() != null){
 		    suffix = empAfmsfDet.getSuffix();
 	    }
 		if(disLetterNo != null && disDate != null && disLetterNo != ""){
 			message = "Dispatch Details are entered already";
 		}else if(disLetterNo == null || disLetterNo == "" && disDate == null){
 			message = "Dispatch Details  are  not entered";
 		}
 		  if(empAfmsfDet.getPostOutDate() == null && empAfmsfDet.getAuthPostOut() == null ){
 		   	docStatus = "d";
 		  }else if(empAfmsfDet.getPostOutDate() != null && empAfmsfDet.getAuthPostOut() != null && empAfmsfDet.getAuthPostOut() != "" ){
 		   	docStatus = "e";
 		  }
 		  
 		 if(empAfmsfDet.getPostInDate() != null)
 		 {
 			postInDate = ""+empAfmsfDet.getPostInDate();
	 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
	 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
	 		postInDate = formatterOut.format(formatterIn.parse(postInDate));
 		 }
 	}
 		
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%><script>
 /*if(document.getElementById("serviceNo").value  != null){
    	var serviceNo = document.getElementById("serviceNo").value;
    	document.getElementById("serviceNo1").value = serviceNo ;
 }*/
 document.getElementById("serviceNo").value = '<%=serviceNo%>'
</script>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="java.text.SimpleDateFormat"%>

<%--  
<% 	if(message != ""){
	//String message = (String)map.get("message");
	%>
   <div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
	 <div class="mesg" style="width: 100%; height: 23px;">
      <%=message %>
	 </div>
	</div>
<% } %>

--%>

<h4>Details</h4>
<div class="Block">
<input type="hidden"
	name="<%=EMP_AFMS_ID%>" id="empAfmsId" value="<%=empAfmsId %>" /> <input
	type="hidden" name="docStatus" value="<%=docStatus%>" id="docStatus" />
<input type="hidden" name="receipt" value="<%=recDate %>" id="receipt" />
<input type="hidden" name="disLetterVal" value="<%=disLetterVal %>" id="disLetterVal" />
<input type="hidden" name="postInDate" value="<%=postInDate %>"
	id="postInDate" /> 
	<label>Service No.</label> <%if(serviceNo != ""){ %> <input
	type="text" name="serviceNo" id="serviceNo1" value="<%=serviceNo%>"
	readonly="true" tabindex="1" validate="Service No.,metachar,yes"/> <%}else{%> <input type="text"
	name="serviceNo" id="serviceNo1" value="" readonly="true" tabindex="1" validate="Service No.,metachar,yes"/>
<%}%>
<%--
 <label><span>*</span> Suffix:</label> <%if(suffix != ""){ %> <input
	type="text" name="suffix" id="suffix" value="<%=suffix %>" tabindex="1"
	readonly="true" /> <%}else {%> <select id="suffix" name="suffix"
	validate="Suffix,string,yes" tabindex="1">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> <%}%> --%>
<%if(empAfmsfDetList.size() >0 && employeeList !=null && employeeList.size() >0){
 for(MasEmployee masEmployee :employeeList){	%>
<label> First Name <span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=masEmployee.getFirstName()!=null?masEmployee.getFirstName():""%>"
	MAXLENGTH="30" validate="First Name,metachar,yes" tabindex="1" />
 <label>
Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname"
	value="<%=masEmployee.getLastName()!=null?masEmployee.getLastName():""%>" MAXLENGTH="30" tabindex="1" validate="Last Name,metachar,yes"/> <label>
Rank <span>*</span></label> <select name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes">
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
</select>
<label> Trade <span>*</span></label> <select name="<%=TRADE%>"  validate="Trade,metachar,yes"
	id="trade" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
							if(masEmployee.getTrade() !=null){
							 if(masEmployee.getTrade().getId() == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%} }else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}}
					%>
</select>
 <label> Present Unit <span>*</span></label> 
 <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" validate="Present Unit,metachar,yes">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> 

<%--
 <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" >
	<option value="0">Select</option>
	<%
		for (MasUnit masUnit : unitList) {
	%>
			<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
		}
	%>
<option value="Other">Other</option>
</select>--%>
<div class="Clear"></div>
<label>Dispatch Letter No</label> 
<input type="text"name="<%=DISPATCH_LETTER_NO%>" id="dispatchLetterNo"value="" MAXLENGTH="30" tabindex="1" validate="Dispatch Letter No,metachar,yes" />
<label>Dispatch with Date</label> 
<input type="text" id="disPatchDate" name="<%=DISPATCHDATE%>" value="" class=calDate validate="Dispatch with Date,frdate,no" MAXLENGTH="30"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=DISPATCHDATE%>,event)" />

 <div class="Clear"></div>
<label>Remarks</label> <!-- <input type="textarea"  name="<%=DIS_REMARKS%>" id="<%=DIS_REMARKS%>" value="<%=disRemarks%>" class="txtarea" MAXLENGTH="50" /> -->
<textarea name="<%=DIS_REMARKS%>" id="<%=DIS_REMARKS%>" class="large" validate="Remarks,metachar,yes"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /></textarea>
	 <div class="Clear"></div>
<label>AMA</label>
<textarea name="amaClear" id="amaClear" class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"  onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
	<%}}else{ %>
	<label> First Name <span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=name%>"
	MAXLENGTH="30" validate="Name,String,Yes" tabindex="1" />
 <label>
Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname"
	value="<%=lname%>" MAXLENGTH="30" tabindex="1" /> <label>
Rank <span>*</span></label> <select name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
						if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select>
<label> Trade <span>*</span></label> <select name="<%=TRADE%>" id="trade" tabindex="1" validate="Trade,metachar,yes">
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
</select>
 <label> Present Unit <span>*</span></label> 
 <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" validate="Present Unit,metachar,yes">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select>
<%--
 <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" >
					<option value="0">Select</option>
					<%
						for (MasUnit masUnit : unitList) {
					%>
							<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
					<%
						}
					%>
				<option value="Other">Other</option>
				</select> --%>


<div class="Clear"></div>

 <label>Dispatch Letter No</label> 
 <input type="text" name="<%=DISPATCH_LETTER_NO%>" id="dispatchLetterNo" value="" MAXLENGTH="30" tabindex="1"  validate="Dispatch Letter No,metachar,yes"/>
<label>Dispatch with Date</label> 
<input type="text" id="disPatchDate" name="<%=DISPATCHDATE%>" value="" class=calDate MAXLENGTH="30" readonly="readonly" validate="Dispatch with Date,frdate,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=DISPATCHDATE%>,event)" />

 <div class="Clear"></div>
<label>Remarks</label> <!-- <input type="textarea"  name="<%=DIS_REMARKS%>" id="<%=DIS_REMARKS%>" value="<%=disRemarks%>" class="txtarea" MAXLENGTH="50" /> -->
<textarea name="<%=DIS_REMARKS%>" id="<%=DIS_REMARKS%>" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,yes"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /></textarea>
	 <div class="Clear"></div>
<label>AMA</label>
<textarea name="amaClear" id="amaClear" class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"  onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1"  validate="Remarks,metachar,yes"></textarea>
	<%} %>
	
	</div>
<div class="division"></div>
<div class="clear"></div>
 	<input type="button" name="edit" value="Submit" class="button"
	tabindex="1"
	onClick="if((validateMetaCharacters(status))){submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=dispatch');}" />

<% if((disDate != null && disDate != "") ||(disLetterNo !=null && ! disLetterNo.equals("")) ){ 
	   		%>
<%--<input type="hidden" name="print" value="Print" class="button"
	tabindex="1"
	onClick="submitForm('deficientAfmsf1','mis?method=primtReportForDocuments');" /> --%>
<%	}
	   		%>	
 <div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	
	<div class="Clear"></div>	
<div class="Clear"></div>