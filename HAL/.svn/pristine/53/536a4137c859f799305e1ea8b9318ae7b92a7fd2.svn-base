

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
	List<MasMedicalCategory> masMedicalList =new ArrayList<MasMedicalCategory>();
	List<MasUnit> presentList = new ArrayList<MasUnit>();
	List<EmpAfmsfDet> empAfmsfDetList=new ArrayList<EmpAfmsfDet>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
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
 	if (map.get("employeeList") != null) {
 		employeeList = (List<MasEmployee>) map.get("employeeList");
 	}
 	
 	if (map.get("masMedicalList")!= null){
 		masMedicalList = (List<MasMedicalCategory>) map.get("masMedicalList");
 	}
 	if(map.get("presentUnitList") != null){
 		presentList = (List<MasUnit>) map.get("presentUnitList");
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
 	int medicalCat =0;
 	String status ="";
 	//String recLatterNo ="";
 	int presentUnitId = 0;
 	String remarks = "";
 	String recDate ="";
 	String postedOutDate = "";
 	String postedInDate ="";
 	String docStatus ="";
 	String message = "";
	String suffix = "";
 	String disLetterNo="";
 	String authoOfPostingOut ="";
 	String amaClear="";
 	if(empAfmsfDetList.size() == 0){
 		docStatus="s";
 	}
 	
 	for(EmpAfmsfDet empAfmsfDet :empAfmsfDetList){
 		empAfmsId = empAfmsfDet.getId();
 		name = empAfmsfDet.getEmpName();
 		if(empAfmsfDet.getEmpLastName() != null){
 			lname = empAfmsfDet.getEmpLastName();  			
 		}
 		if(empAfmsfDet.getRank() !=null)
 		rankId = empAfmsfDet.getRank().getId();
 		if(empAfmsfDet.getDisLetterNo() !=null)
 	  	disLetterNo=empAfmsfDet.getDisLetterNo();
 		if( empAfmsfDet.getUnit() !=null)
 		postedFromId = empAfmsfDet.getUnit().getId();
 		if(empAfmsfDet.getPostedTo() !=null)
 		postedToId = empAfmsfDet.getPostedTo().getId();
 		if(empAfmsfDet.getPostOutDate() !=null){
 			postedOutDate = ""+empAfmsfDet.getPostOutDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 postedOutDate=formatterOut.format(formatterIn.parse(postedOutDate));
 		}
 		
 		if(empAfmsfDet.getPostInDate() !=null){
 			postedInDate = ""+empAfmsfDet.getPostInDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 postedInDate=formatterOut.format(formatterIn.parse(postedInDate));
 		}
 		
 		if(empAfmsfDet.getLetterNo() !=null)
 		letterNo = empAfmsfDet.getLetterNo();
 		if(empAfmsfDet.getAuthPosting() !=null)
 		authOfPosting = empAfmsfDet.getAuthPosting();
 		if(empAfmsfDet.getStatus() !=null)
 		status = empAfmsfDet.getStatus();
 		if(empAfmsfDet.getMedicalCategory() !=null)
 	 		medicalCat = empAfmsfDet.getMedicalCategory().getId();
 		if(empAfmsfDet.getTrade() != null)
 			trade = empAfmsfDet.getTrade().getId();
 		
 		if(empAfmsfDet.getRecDate() != null){
 			recDate = ""+empAfmsfDet.getRecDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		recDate = formatterOut.format(formatterIn.parse(recDate));
 		}
 		if(empAfmsfDet.getRemarks() != null)
 	    	remarks = empAfmsfDet.getRemarks();
 
 		if(empAfmsfDet.getUnit() != null){
 			presentUnitId = empAfmsfDet.getUnit().getId();
 		}
 		
 		if(empAfmsfDet.getAuthPostOut() != null){
 			authoOfPostingOut = empAfmsfDet.getAuthPostOut();
 		}
 		
 		if(empAfmsfDet.getAmaClear() != null){
 			amaClear = empAfmsfDet.getAmaClear();
 		}
 		if( empAfmsfDet.getUnit() !=null)
 			presentId = empAfmsfDet.getUnit().getId();
 		
 		if(empAfmsfDet.getServiceNo() != null){
 			serviceNo = empAfmsfDet.getServiceNo();
 		}
 		if(empAfmsfDet.getSuffix() != null){
 		    suffix = empAfmsfDet.getSuffix();
 	    }
 		
 	    if(empAfmsfDet.getDisLetterNo() == null || empAfmsfDet.getDisLetterNo() == "" && empAfmsfDet.getDisDate() == null){
 				docStatus ="s";
 		}else if(empAfmsfDet.getDisLetterNo() != null && empAfmsfDet.getDisLetterNo() != "" && empAfmsfDet.getDisDate() != null){
 				docStatus = "e";
 		}
 	 		
 	   	if(empAfmsfDet.getAuthPostOut()!= null && empAfmsfDet.getAuthPostOut() != "" &&
 	   			empAfmsfDet.getPostOutDate() != null){
 	   		message = "Clearance details are entered already";
 	   	}else {
 	   	    message = "Clearance details are not entered";
 	   	}
 	}
 		
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%><script>
/* if(document.getElementById("serviceNo").value  != null){
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
<!--  -->
<% 	if(message != ""){
	//String message = (String)map.get("message");
	%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<label class="auto"> <span> <%=message %> </span> </label>
<% } %>
<div class="Clear"></div>

<h4></>Details</h4>
<div class="Block">
<input type="hidden"
	name="<%=EMP_AFMS_ID%>" value="<%=empAfmsId %>" id="empAfmsId" /> <input
	type="hidden" name="<%=DOC_STATUS%>" value="<%=docStatus %>"
	id="docStatus" /> <input type="hidden" name="postedInDate"
	value="<%=postedInDate %>" id="postedInDate" /> <input type="hidden"
	name="recDate" value="<%=recDate%>" id="recDate" />
	<input type="hidden"
	name="disLetterNo" value="<%=disLetterNo%>" id="disLetterNo" />
	
<label>Service No</label>
<%if(serviceNo != ""){ %> <input type="text" name="serviceNo"
	id="serviceNo1" value="<%=serviceNo%>" tabindex="1" readonly="true" />
<%}else{%> <input type="text" name="serviceNo" id="serviceNo1" value="" validate="Service No.,metachar,no"
	tabindex="1" readonly="true" /> <%}%> 
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
</select> <%}%> --%>
<%if(empAfmsfDetList.size() >0 && employeeList !=null && employeeList.size() >0){
 for(MasEmployee masEmployee :employeeList){	%>
<label> First Name <span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=masEmployee.getFirstName()!=null?masEmployee.getFirstName():""%>"
	MAXLENGTH="30" tabindex="1" validate="First Name,metachar,yes"/> 

<label> Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_FIRST_NAME %>"
	id="lname" value="<%=masEmployee.getLastName()!=null?masEmployee.getLastName():""%>" MAXLENGTH="30" tabindex="1" validate="Last Name,metachar,yes"/> 
	<div class="Clear"></div>
	<label>
Rank<span>*</span></label> <select name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes" >
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

<label> Trade<span>*</span></label> <select name="<%=TRADE%>" validate="Trade,metachar,yes"
	id="trade" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
							if(masEmployee.getTrade() !=null){
							 if(masEmployee.getTrade().getId() == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else { %>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%}}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}}
					%>
</select>

 <label>Present Unit</label> 
 
 <%--<select name="<%=PRESENT_UNIT %>"
	id="presentUnit" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> --%>

<select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" validate="Present Unit,metachar,yes" >
					<option value="0">Select</option>
					<%
						for (MasUnit masUnit : unitList) {
					%>
							<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
					<%
						}
					%>
				<option value="Other">Other</option>
				</select>
<div class="Clear"></div>
 <label> Posted To<span>*</span></label> <select name="<%=POSTED_TO %>" validate="Posted To,metachar,yes"
	id="postedTo" tabindex="1" onchange="displayextrafields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(masEmployee.getUnit() !=null){
							if(masEmployee.getUnit().getId() ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
		<%} }else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
	<option value="Other">Other</option>
</select> 

<%--
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	tabindex="1" style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit">
<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" /> <label>Is Local Unit</label> <input
	type="checkbox" id="localUnit" class="radio" name="<%=LOCAL_UNIT %>"
	value="y"  /></div> --%>
	
<label>Date of posting Out</label> <input type="text" id="postOutDate"
	name="<%=POST_OUT_DATE%>" class="calDate" value="" 
	MAXLENGTH="30"  tabindex="1"/> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" tabindex="1"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_OUT_DATE%>,event)" />


<label>Auth of Posting Out</label> <input type="text" 
	name="<%=AUTHORITY_POSTED_OUT%>" id="AuthorityPostIn"
	value="" tabindex="1" MAXLENGTH="30" /></div>
<div class="clear"></div>
<label>AMA</label> 
 <textarea name="amaClear" id="amaClear" class="" tabindex="3" onpaste="return checkOnPaste(this)"  validate="AMA,metachar,no"
	oninput="return checkMaxLengthMoz(this)"  onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
	
<div class="clear"></div>
<%}}else{ %>
<label> First Name <span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=name%>"
	MAXLENGTH="30" tabindex="1" validate=" First Name,metachar,yes" /> 

<label> Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_FIRST_NAME %>"
	id="lname" value="<%=lname%>" MAXLENGTH="30" tabindex="1" validate=" Last Name,metachar,yes"/> 
	<div class="Clear"></div>
	<label>
Rank<span>*</span></label> <select name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
						if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select>

<label> Trade<span>*</span></label> <select name="<%=TRADE%>" validate="Trade,metachar,yes"
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
</select>

 <label>Present Unit</label> 
 
 <%--<select name="<%=PRESENT_UNIT %>"
	id="presentUnit" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> --%>

<select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" validate="present Unit,metachar,yes">
					<option value="0">Select</option>
					<%
						for (MasUnit masUnit : unitList) {
					%>
							<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
					<%
						}
					%>
				<option value="Other">Other</option>
				</select>
<div class="Clear"></div>
 <label> Posted To<span>*</span></label> <select name="<%=POSTED_TO %>" validate="Posted To,metachar,yes"
	id="postedTo" tabindex="1" onchange="displayextrafields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(postedToId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
	<option value="Other">Other</option>
</select> 

<%--
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	tabindex="1" style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit">
<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" /> <label>Is Local Unit</label> <input
	type="checkbox" id="localUnit" class="radio" name="<%=LOCAL_UNIT %>"
	value="y"  /></div> --%>
	
<label>Date of posting Out</label> <input type="text" id="postOutDate"  validate="Date of posting Out,metachar,no"
	name="<%=POST_OUT_DATE%>" class="calDate" value="<%=postedOutDate%>"
	MAXLENGTH="30" readonly="readonly" tabindex="1"/> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" tabindex="1"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_OUT_DATE%>,event)" />


<label>Auth of Posting Out</label> <input type="text" validate="Auth of Posting Out,metachar,no"
	name="<%=AUTHORITY_POSTED_OUT%>" id="AuthorityPostIn"
	value="<%=authoOfPostingOut %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label>AMA</label> 
 <textarea name="amaClear" id="amaClear" class="" tabindex="3" onpaste="return checkOnPaste(this)"  validate="AMA,metachar,no"
	oninput="return checkMaxLengthMoz(this)"  onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ><%=amaClear %></textarea>
	
<div class="clear"></div>
<%} %>

</div>