

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
	List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();
 	
	List<EmpAfmsfDet> empAfmsfDetList=new ArrayList<EmpAfmsfDet>();
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
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
 	
 	if (map.get("masMedicalList")!= null){
 		masMedicalList = (List<MasMedicalCategory>) map.get("masMedicalList");
 	}
 	
 	if(map.get("presentUnitList") != null){
 		presentList = (List<MasUnit>) map.get("presentUnitList");
 	}
 	if (map.get("bloodGroupList") != null) {
		bloodGroupList = (List<MasBloodGroup>) map.get("bloodGroupList");
 		
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
 	String recLatterNo ="";
 	String remarks = "";
 	String recDate ="";
 	String postedInDate ="";
 	String message ="";
 	String afmsType ="";
 	String suffix ="";
 	String reviewDate = "";
 	String diagnosis = "";
 	String docs = "";
 	String docStatus="";
 	String amaArrival="";
 	for(EmpAfmsfDet empAfmsfDet :empAfmsfDetList)
 	{
 		docStatus=empAfmsfDet.getDocStatus();
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
 		
 		if(empAfmsfDet.getLetterNo() != null)
 			recLatterNo = empAfmsfDet.getLetterNo();
 		
 		if(empAfmsfDet.getRecDate() != null){
 			recDate = ""+empAfmsfDet.getRecDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		recDate = formatterOut.format(formatterIn.parse(recDate));
 		}
 		
 		if(empAfmsfDet.getRemarks() != null)
 	    	remarks = empAfmsfDet.getRemarks();
 		
 		if(empAfmsfDet.getUnit() !=null)
 			presentId = empAfmsfDet.getUnit().getId();
 		
 		if(empAfmsfDet.getServiceNo() != null){
 			serviceNo = empAfmsfDet.getServiceNo();
 		}
 		if(empAfmsfDet.getSuffix() != null){
 		    suffix = empAfmsfDet.getSuffix();
 	    }
 		docs = empAfmsfDet.getDocumentReceived()!=null?empAfmsfDet.getDocumentReceived():"";
 		if(empAfmsfDet.getNextReview() !=null){
 	 		reviewDate = ""+empAfmsfDet.getNextReview();
 	 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 			reviewDate=formatterOut.format(formatterIn.parse(reviewDate));
 	 	}
 		
 		if(empAfmsfDet.getDiagnosis() != null){
 			diagnosis = empAfmsfDet.getDiagnosis();
 		}
 		if(empAfmsfDet.getAmaArrival() != null){
 			amaArrival = empAfmsfDet.getAmaArrival();
 		}
 		if(empAfmsfDet.getAuthPosting()!= null && empAfmsfDet.getAuthPosting() != "" &&
 		   empAfmsfDet.getPostInDate() != null){
 			if(empAfmsfDet.getRecDate()!= null && empAfmsfDet.getLetterNo()!=null && 
 					empAfmsfDet.getLetterNo() != ""){
 				message = "Arrival and Receipt entry's Added ";
 			}else{
 				message ="Arrival entry added";
 			}
 		}else{
 			   message = "No record added to this service no";
 		}
 		
       if(empAfmsfDet.getAfmsfType().equals("OUT")){
    	   afmsType = empAfmsfDet.getAfmsfType();
    	    message = message + "\n( service person cleared this place)!!";
       }
       
 	}
 		
%>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%><script>
document.getElementById("serviceNo").value = '<%=serviceNo%>'
 //if(document.getElementById("serviceNo").value  != null){
    //	var serviceNo = document.getElementById("serviceNo").value;
    //	document.getElementById("serviceNo1").value = serviceNo ;
    	// document.registration.<=suffix %>.focus();
 //}
</script>
<%if(medicalCat != 0 && medicalCat != 1){%>
<script>
	  document.getElementById('medDiv').style.display = 'inline';
</script>
<%}%>

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
	<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
	 <div class="mesg" style="width: 100%; height: 23px;">
     	 </div>
	</div>
<%// } %>
 -->
<%
 if(map.get("message") != null){
					 message = (String)map.get("message");
					%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<label class="auto"> <span> <%=message %> </span> </label>
<% } %>
<div class="Clear"></div>
<h4>Details</h4>
<div class="Block">
<input type="hidden"
	name="<%=EMP_AFMS_ID%>" value="<%=empAfmsId %>" /> 
	
	<input type="hidden" name="docStatusVal" id="docStatusVal" value="<%=docStatus %>" /> 
	<input
	type="hidden" name="afmsType" value="<%=afmsType%>" id="afmsType" /> 
	<label>Service No.</label>
<%if(!serviceNo.equals("")){ %> <input type="text" name="serviceNo"
	id="serviceNo1" tabindex="1" value="<%=serviceNo%>" validate="serviceNo,metachar,yes" />
<%}else{%> <input type="text" name="serviceNo" id="serviceNo1"
	tabindex="1" value="" validate="serviceNo,metachar,yes" readonly /> <%}%>
<%--	
 <label><span>*</span>Suffix:</label> <%if(suffix != ""){ %> <input type="text" name="suffix"
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
 --%>
 <% 
 if(empAfmsfDetList.size()==0 && employeeList !=null && employeeList.size() >0){
 for(MasEmployee masEmployee:employeeList){ %>
 
<label> First Name <span>*</span></label> 
<input type="text"	name="<%=EMPLOYEE_FIRST_NAME %>" validate="First Name,metachar,yes" id="name" value="<%=masEmployee.getFirstName()!=null?masEmployee.getFirstName():""%>"	MAXLENGTH="30" validate="Name,String,Yes" tabindex="1" /> 


	<label>Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" validate="Last Name,metachar,yes"
	value="<%=masEmployee.getLastName()!=null?masEmployee.getLastName():""%>" MAXLENGTH="30" tabindex="1" /> <label>
Rank <span>*</span></label>
 <select name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
				if(masEmployee.getRank().getId() ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select>
<label> Trade <span>*</span></label> <select name="<%=TRADE%>" validate="Trade,metachar,yes"
	id="trade" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
							 if(masEmployee.getTrade().getId() == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else {%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}}
					%>
</select>

 <label> Medical Category <span>*</span></label> <select
	name="<%=MEDICAL_CATEGORY %>" id="medicalCategory" validate=" Medical Category ,metachar,yes"
	onchange="displayextrafields();" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasMedicalCategory masMedical : masMedicalList) {
					%>
	<option value="<%=masMedical.getId()%>"><%=masMedical.getMedicalCategoryName()%></option>
	<%}%>
</select>
<div class="Clear"></div>
<div id="medDiv" style="display: none;">
<label>
Diagnosis <span>*</span></label> <input id="diagnosis" type="text" name="<%=DIAGNOSIS%>"
	value="" validate="Unit Address,string,no" maxlength="30" validate="Diagnosis,metachar,no"
	tabindex="1" /> <label> Next review Date <span>*</span></label> 
	<input type="text" id="nextreviewDate" name="<%=NEXT_REVIEW_DATE%>" value="<%=reviewDate%>" class="calDate" MAXLENGTH="30" readonly="readonly"  validte="Next review Date,frdate,no"  /> 
	<img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=NEXT_REVIEW_DATE%>,event)" />
</div>

	
	<label>Blood Group</label> 
<select name="bloodGroupId"	id="srBldGrp" validate="Blood Group,string,no" tabindex="1" validate="Blood Group,metachar,yes">	
<option value="0">Select</option>
	<option value="0">Select</option>
	<%
						for (MasBloodGroup bloodGroup : bloodGroupList) {
							if(masEmployee.getBloodGroup() !=null){
							
							 if(masEmployee.getBloodGroup().getId() == bloodGroup.getId()){
					%>
	<option value="<%=bloodGroup.getId() %>" selected="selected"><%=bloodGroup.getBloodGroupName()%></option>
	<%}else {%>
	<option value="<%=bloodGroup.getId()%>"><%=bloodGroup.getBloodGroupName()%></option>
	<%} }else {%>
	<option value="<%=bloodGroup.getId()%>"><%=bloodGroup.getBloodGroupName()%></option>
	<%
						}}
					%>
</select>	
<label> Present Unit<span>*</span></label> <select
	name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" validate="Present,metachar,yes">
	<option value="0">Select</option>
	<%--
	<%
						for (MasUnit masUnit : presentList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%> --%>
	
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>
</select> 

<%--<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit" tabindex="1" /> --%>

<label> Posted From <span>*</span></label> <select
	name="<%=POSTED_FROM %>" class="large2" id="lastUnit" tabindex="1" validate="Posted From,metachar,yes"
	onchange="displayotherfields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}%>
	<option value="Other">Other</option>
</select> 


<%--
<div id="addUnitDiv" style="display: none;"><label> Unit
Name </label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit:</label> <input
	type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y"
	tabindex="1" />
</div> --%>
<div class="Clear"></div>
<label> Posting Date <span>*</span></label> <input type="text"
	id="dateOfPosting" name="<%=POST_IN_DATE%>" value="" validate="Posting Date,frdate,yes"
	class="calDate" MAXLENGTH="30" readonly="readonly"  /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_IN_DATE%>,event)" />

<label> Posting Auth <span>*</span></label> <input type="text"
	name="<%=AUTHORITY%>" id="Authority" value=""
	MAXLENGTH="30" tabindex="1" validate="Posting Auth,metachar,yes" />
<label>Receipt Latter No </label> <input
	id="receiptLatterNo" validate="" type="text"
	name="<%=RECEIPT_LETTER_NO%>" value="" maxlength="30" validate="Receipt Latter No,metachar,yes" 
	tabindex="1" />
<div class="Clear"></div>

 <label>Receipt With Date</label> <input type="text"
	id="receiptDate" name="<%=RECEIPTDATE %>" value=""
	class="calDate" readonly="readonly" validate="Receipt With Date,frdate,yes" 
	validate="Receipt With Date,frdate,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />
<label>Remarks </label> <textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="remarks,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /> </textarea>
	
		<label>Docs Received</label> 
 <textarea name="docReceived" id="docReceived"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Docs Received,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
		<div class="clear"></div>
	<label>AMA</label> 
 <textarea name="amaArrival" id="amaArrival"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="AMA,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
<div class="Clear"></div><%} }else{ %>

<label> First Name <span>*</span></label> 
<input type="text"	name="<%=EMPLOYEE_FIRST_NAME %>" validate="First Name,metachar,yes" id="name" value="<%=name%>"	MAXLENGTH="30" validate="Name,String,Yes" tabindex="1" /> 


	<label>Last Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" validate="Last Name,metachar,yes"
	value="<%=lname%>" MAXLENGTH="30" tabindex="1" /> <label>
Rank <span>*</span></label> <select name="<%=RANK_ID %>" id="rankId" tabindex="1">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
				if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select>
<label> Trade <span>*</span></label> <select name="<%=TRADE%>"
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

 <label> Medical Category <span>*</span></label> <select
	name="<%=MEDICAL_CATEGORY %>" id="medicalCategory"
	onchange="displayextrafields();" tabindex="1">
	<option value="0">Select</option>
	<%
						for (MasMedicalCategory masMedical : masMedicalList) {
							if(medicalCat ==masMedical.getId()){
					%>
	<option value="<%=masMedical.getId()%>" selected="selected"><%=masMedical.getMedicalCategoryName()%></option>
	<%}else{%>
	<option value="<%=masMedical.getId()%>"><%=masMedical.getMedicalCategoryName()%></option>
	<%}}%>
</select>
<div class="Clear"></div>
<div id="medDiv" style="display: none;">
<label>
Diagnosis <span>*</span></label> <input id="diagnosis" type="text" name="<%=DIAGNOSIS%>"
	value="<%=diagnosis%>" validate="Diagnosis,metachar,no" maxlength="30"
	tabindex="1" /> <label> Next review Date <span>*</span></label> <input
	type="text" id="nextreviewDate" name="<%=NEXT_REVIEW_DATE%>" 
	value="<%=reviewDate%>" class="calDate" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=NEXT_REVIEW_DATE%>,event)" />
</div>

	
	<label>Blood Group</label> 
<select name="bloodGroupId"	id="srBldGrp" validate="Blood Group,string,no" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(MasBloodGroup  masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
</select>	
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
	<%--
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%> --%>
</select> 

<%--<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit" tabindex="1" /> --%>

<label> Posted From <span>*</span></label> <select
	name="<%=POSTED_FROM %>" class="large2" id="lastUnit" tabindex="1"
	onchange="displayotherfields();">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(postedFromId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
	<option value="Other">Other</option>
</select> 


<%--
<div id="addUnitDiv" style="display: none;"><label> Unit
Name </label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit:</label> <input
	type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y"
	tabindex="1" />
</div> --%>
<div class="Clear"></div>
<label> Posting Date <span>*</span></label> <input type="text"
	id="dateOfPosting" name="<%=POST_IN_DATE%>" value="<%=postedInDate%>"
	class="calDate" MAXLENGTH="30" readonly="readonly"  /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_IN_DATE%>,event)" />

<label> Posting Auth <span>*</span></label> <input type="text"
	name="<%=AUTHORITY%>" id="Authority" value="<%=authOfPosting %>"
	MAXLENGTH="30" tabindex="1" validate="Posting Auth,metachar,yes" />
<label>Receipt Latter No </label> <input
	id="receiptLatterNo" validate="" type="text"
	name="<%=RECEIPT_LETTER_NO%>" value="<%=letterNo %>" maxlength="30"
	tabindex="1" />
<div class="Clear"></div>

 <label>Receipt With Date</label> <input type="text"
	id="receiptDate" name="<%=RECEIPTDATE %>" value="<%=recDate%>"
	class="calDate" readonly="readonly" 
	 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />
<label>Remarks </label> <textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="1" /> <%=remarks%></textarea>
	
		<label>Docs Received</label> 
 <textarea name="docReceived" id="docReceived"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"  validate="Docs Received,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ><%=docs %></textarea>
	
	<div class="clear"></div>
	<label>AMA</label> 
 <textarea name="amaArrival" id="amaArrival"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="AMA,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ><%=amaArrival %></textarea>
<%} %>
	<div class="clear"></div>
</div>

