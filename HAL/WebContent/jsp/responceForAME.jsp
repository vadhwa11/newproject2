<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.AmeLmc"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.IFNULL"%>
<%@page import="jkt.hms.masters.business.AmeLmcHeader"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
	
<%  
	String message ="";
   String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<MasUnit> unitList=new ArrayList<MasUnit>();
	List<EmpAfmsfDet> empAfmsfDetList=new ArrayList<EmpAfmsfDet>();
	List<MasEmployee> empList=new ArrayList<MasEmployee>();
	List<AmeLmc> ameLmcList=new ArrayList<AmeLmc>();
	List<AmeLmcHeader> ameLmcHList = new ArrayList<AmeLmcHeader>(); 
	List<AnnualMediacalExamination> annualMediacalExaminationList = new ArrayList<AnnualMediacalExamination>();
	List<AmeLmcHeader> existAmeList = new ArrayList<AmeLmcHeader>();
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("empAfmsfDetList") != null) {
 		empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
 	}
 	if (map.get("annualMediacalExaminationList") != null) {
 		annualMediacalExaminationList = (List<AnnualMediacalExamination>) map.get("annualMediacalExaminationList");
 	}
 	if(empAfmsfDetList.size() ==0){
 		message ="No Record found";
 	}
 	if (map.get("unitList") != null) {
 		unitList = (List<MasUnit>) map.get("unitList");
 	}
 	List<MasMedicalCategory> masMedicalCategoryList = new ArrayList<MasMedicalCategory>();
 	if (map.get("masMedicalCategoryList") != null) {
 		masMedicalCategoryList = (List<MasMedicalCategory>) map.get("masMedicalCategoryList");
 	}
 	if (map.get("ameLmcList") != null) {
 		ameLmcList = (List<AmeLmc>) map.get("ameLmcList");
 	}
 	if (map.get("empList") != null) {
 		empList = (List<MasEmployee>) map.get("empList");
 	}
 	
 	if(map.get("ameLmcHList") != null){
 		ameLmcHList = (List<AmeLmcHeader>) map.get("ameLmcHList");
 	}
 	
 	if(map.get("existAmeList") != null)
 		existAmeList = (List<AmeLmcHeader>) map.get("existAmeList");
 	
 	String fwdLetter = "";
 	String fwdLetterDate = "";
 	String recpLetter = "";
 	String recpLetterDate = "";
 	String remarks = "";
 	int ameH = 0;
 	
 	if(ameLmcHList.size() > 0){
 		AmeLmcHeader ameLmcH = (AmeLmcHeader) ameLmcHList.get(0);
 		ameH = ameLmcH.getId();
 		
 		if(ameLmcH.getFwdLetterNo() != null && !ameLmcH.getFwdLetterNo().equals(""))
 		fwdLetter = ameLmcH.getFwdLetterNo();
 		
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		
		if(ameLmcH.getFwdLetterDate() != null && !ameLmcH.getFwdLetterDate().equals(""))
		fwdLetterDate=formatterOut.format(formatterIn.parse(""+ameLmcH.getFwdLetterDate()));
		
		if(ameLmcH.getReceiptLetterNo() != null && !ameLmcH.getReceiptLetterNo().equals(""))
		recpLetter = ameLmcH.getReceiptLetterNo();
		
		if(ameLmcH.getReceiptLetterDate() != null && !ameLmcH.getReceiptLetterDate().equals(""))
		recpLetterDate = formatterOut.format(formatterIn.parse(""+ameLmcH.getReceiptLetterDate()));
		
		if(ameLmcH.getRemarks() != null && !ameLmcH.getRemarks().equals(""))
 		remarks = ameLmcH.getRemarks();
 	}
 	
 	int categoryId =0;
 	String name  = "";
 	String rankName ="";
 	String tradeName =""; 	
	String unitName =""; 
	String medicalCategory ="";
	String period ="";
	String nextReview ="";
	String boardDate ="";
	int boardHeldAt = 0; 
	String duration="";
	int empAfmsfDetId =0;
	int mediacalExaminationId =0;
	for(MasEmployee emp :empList){
		name =emp.getFirstName() + emp.getMiddleName() + emp.getLastName();
		if(emp.getRank() !=null)
	 		rankName =emp.getRank().getRankName();
	 		if(emp.getTrade() !=null)
	 	 		tradeName =emp.getTrade().getTradeName();
	 		if(emp.getUnit() !=null)
	 			unitName =emp.getUnit().getUnitName();
	 		//if(emp.getm() !=null)
	 		//	categoryId =emp.getMedicalCategory().getId();
	 		//if(emp.getMedicalCategory() !=null)
	 		//	categoryId =emp.getMedicalCategory().getId();
	}
	
	for(EmpAfmsfDet emp :empAfmsfDetList){
		empAfmsfDetId =emp.getId();
	}
	for(AnnualMediacalExamination mediacalExamination :annualMediacalExaminationList){
		mediacalExaminationId=mediacalExamination.getId();
		period=mediacalExamination.getPeriod();
		duration=mediacalExamination.getDuration();
		if(mediacalExamination.getCategory() != null)
		categoryId = mediacalExamination.getCategory().getId();  
		
		if(mediacalExamination.getLastBoardAt() != null )
			boardHeldAt= mediacalExamination.getLastBoardAt().getId();
		try{
		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 if(mediacalExamination.getNextReview()!=null && !mediacalExamination.getNextReview().equals("")){
		 nextReview=formatterOut.format(formatterIn.parse(""+mediacalExamination.getNextReview()));
		 }
		}catch(Exception ee){
		}
		try{
		 SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
		 if(mediacalExamination.getLastBoard()!=null && !mediacalExamination.getLastBoard().equals("")){
		 boardDate=formatterOut2.format(formatterIn2.parse(""+mediacalExamination.getLastBoard()));
		 }
		}catch(Exception e){
		}
 	}
%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="java.text.SimpleDateFormat"%>
			<%if(!message.equals("")){ %>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.masters.business.AnnualMediacalExamination"%>
  
<div id="errorMsg" style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
			<div style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight:bold; height: 23px; background-color: #FFE8E8;  float : left;  width : 100%; color: red; border: 1px solid red;">
			<%=message %>  		
			</div>
 			</div>
 			<%} %>
 	<div id="contentHolder">
      <div class="blockTitle">DETAILS</div><div class="blockTitleCurve"></div>
      <div class="Clear"></div>
      <div class="blockFrame">
	   <input type="hidden"  name="<%=EMP_AFMS_ID %>" id="name" value="<%=empAfmsfDetId %>" />
	   <input type="hidden"  name="<%=AME_ID %>" id="name" value="<%=mediacalExaminationId %>" />
	 <label  class="bodytextB">Rank:</label>
	  <input type="text"  name="<%=RANK %>" id="name" value="<%=rankName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
	  <label  class="bodytextB">Name:</label>
	  <input type="text"  name="<%=FIRST_NAME %>" id="name" value="<%=name %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
       <label  class="bodytextB">Trade:</label>
	  <input type="text"  name="<%=TRADE_ID%>" id="name" value="<%=tradeName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
	    <div class="Clear"></div>
      <label  class="bodytextB">Parent Unit:</label>
	  <input type="text"  name="<%=UNIT_ID%>" id="name" value="<%=unitName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
		<label  class="bodytextB"><font id="error">*</font>Medical Category:</label>
	  <select name="<%=CATEGORY_ID %>" id="medCatId">
	 	<option value="0">Select</option>
	 	<%for(MasMedicalCategory category : masMedicalCategoryList){
	 		if(categoryId ==category.getId()){%>
	 	<option value="<%=category.getId() %>" selected="selected"><%=category.getMedicalCategoryName() %></option>
	 	<%}else{ %>
	 	<option value="<%=category.getId() %>"><%=category.getMedicalCategoryName() %></option>
	 	<%}} %>
	 	</select>
	 	<label  class="bodytextB">Period:</label>
	 	<select name="<%=PERIOD %>">
	 		<option value="">--Select--</option>
		 	<%
		 	if(period !=null && !period.equals("")){
		 	if(period.equals("P")){ %>
			 	<option value="P" selected="selected">Permanent</option>
			 	<option value="T">Temporary</option>
		 	<%}else{ %>
			 	<option value="P" >Permanent</option>
			 	<option value="T" selected="selected">Temporary</option>
		 	<%}}else{ %>
		 	<option value="P" >Permanent</option>
			 	<option value="T" >Temporary</option>
		 	<%} %>
	 	</select>
	 	  <div class="Clear"></div>
	 	<label  class="bodytextB">Duration:</label>
	    <input type="text" name="dduration" id="dduration" value="<%=duration%>" >
	    <label  class="bodytextB"><font id="error">*</font>Last AME/Board:</label>
	  <input type="text"  name="<%=AME_DATE%>" id="boardDate" value="<%=boardDate %>" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
	  <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=AME_DATE%>,event)" />
		 
	    <label  class="bodytextB"><font id="error">*</font>Last AME/Board held at:</label>
	     <select id="newUnitId" name="newUnitId" onchange="displayUnitAddress(this.value);"	onblur="displayUnitAddress(this.value);"
	     validate="Last AME/Board held at,date.yes">
	     <option value="">--Select--</option>
	    <% 
	    if(unitList.size()>0){
	    for (MasUnit unit :unitList) 
		  {	
	    	if(boardHeldAt ==unit.getId()){%>
	    	<option value="<%=unit.getId()%>" selected="selected"><%=unit.getUnitName()%></option>
		  <%}else{ %>
	     <option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	     <%}}}%>
        </select>
        <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor: pointer; float: left;"
	              onClick="javascript:openPopupWindowForUnit();"	title="Click here to Search ICD Codes">
		 <div class="Clear"></div>
		<label  class="bodytextB"><font id="error">*</font>Next Review:</label>
	  <input type="text"  name="<%=NEXT_REVIEW_DATE%>" id="nextReview" value="<%=nextReview %>" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
		 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=NEXT_REVIEW_DATE%>,event)" />
	
	  </div>
	 <div class="Clear"></div>
     <div class="Clear"></div>
     <%
     if(existAmeList.size() > 0){ 
     int i = 0;
     %>     
      <div class="blockFrame">
      <label  class="bodytextB">Existing Details:</label>
       <select name="exitComb" id="exitComb" >
	     <option value="0">Select</option>
	 	  <%for(AmeLmcHeader ame : existAmeList){ %> 
	 	  <option value="<%=ame.getId()%>"><%=++i%></option>
	 	  <%}%>
	 	 </select>
	 	<input type="button" name="search" id="search" value="Search" class="Cmnbutton" onclick="getOldDetails();">
	 </div>
     <%} %>
      <div class="blockFrame">
      <input type="hidden" name="AMELMCH" id ="AMELMCH" value="<%=ameH %>">
      <label  class="bodytextB">Fwd-letter No:</label>
      <input type="text" name="fwdLetterNo" id="fwdLetterNo" value="<%=fwdLetter%>" MAXLENGTH="30"> 
      <label  class="bodytextB">Fwd-letter Date:</label>
      <input type="text" name="fwdLetterDate" id="fwdLetterDate" value="<%=fwdLetterDate %>" class="calDate">
      <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%="fwdLetterDate"%>,event)" />
	  <label  class="bodytextB">Receipt-letter No:</label>
      <input type="text" name="recLetterNo" id="recLetterNo" value="<%=recpLetter %>" MAXLENGTH="30"> 
      <label  class="bodytextB">Receipt-letter Date:</label>
      <input type="text" name="recLetterDate" id="recLetterDate" value="<%=recpLetterDate %>" class="calDate">
      <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%="recLetterDate"%>,event)" />
		 
	 <label  class="bodytextB">Remarks:</label>
	<textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	class="large" tabindex="3" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /> <%=remarks %>
	</textarea>	 
    <%if(ameLmcHList.size() > 0){ %>
    <input type="button" name="close" id="close" value="Close" class="Cmnbutton" onclick="closeExistingRecord();">
   <%} %>  
      </div>
   
   <div class="blockFrame">

<div class="title">Disability Details</div>
<input type="button" tabindex="1" class="ButtonDel" style="margin-left:10px;" alt="Delete" value=" " onclick="removeRow();" align="right" />
<input type="button" tabindex="1" class="ButtonAdd"  alt="Add" onclick="addRow();" value=" " align="right" />
<div id="prescriptionImportButton" style="display: none">
<input name="prescriptionImportButton1" tabindex="1" type="button" value="Import New Prescription" class="cmnButton" onclick="getListForTreatment('treatmentDiv');" />
</div>
<div class="Clear"></div>
<div id="testDiv">
  	<div class="tableHolderAuto">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	  <tr>
	    <th scope="col">Disablity Name</th>
	    <th scope="col">Category </th>
	    <th scope="col">Duration</th>
	    <th scope="col">Perm Temp</th>
	    <th scope="col">Date of Next Review</th>
	    <th scope="col">Employment Restriction</th>
	    </tr>
	     <input type="hidden" name="org" value="<%= ameLmcList.size()%>" id="org"/>
	  
	  <%if(ameLmcList.size() > 0){
		  int i=0;
		  for(AmeLmc ameLmc:ameLmcList){
			  i++;	  %>
	  <tr>
	    <td>
	    <%if(ameLmc.getDisabilityName()!=null){ %>
	    <input type="text" value="<%=ameLmc.getDisabilityName() %>" tabindex="1" id="disabilityName<%=i%>" size="30" maxlength="30" name="disabilityName<%=i%>" />
	    <%} else{%>
	     <input type="text" value="" tabindex="1" id="disabilityName<%=i%>" size="30" maxlength="30" name="disabilityName<%=i%>" />
	     <%} %>
	    </td>
	    <td>
	    <select name="dcategory<%=i%>" tabindex="1" id="dcategory<%=i%>" >
	    <option value="0">Select</option>
	 	<%for(MasMedicalCategory category : masMedicalCategoryList){ 
	 		if(ameLmc.getCategory()!=null){
	 		if(category.getId() == ameLmc.getCategory().getId()){
	 	%>
	 	<option value="<%=category.getId() %>" selected="selected"><%=category.getMedicalCategoryName() %></option>
	 	<%}
	 		
	 	}else {%>
	 	<option value="<%=category.getId() %>"><%=category.getMedicalCategoryName() %></option>
	 	<% }}%>
	 	</select>
	    </td>
	    <td>
	    <%if(ameLmc.getDuration()!=null){ %>
	    <input type="text" name ="dduration<%=i%>" value="<%=ameLmc.getDuration()%>" tabindex="1" id="dduration<%=i%>" size="10"  maxlength="19"/></td>
	    <%}else{ %>
	    <input type="text" name ="dduration<%=i%>" value="" tabindex="1" id="dduration<%=i%>" size="10"  maxlength="19"/></td>
	    <%} %>
	    <td>
	        <select name="permtemp<%=i%>" id="permtemp<%=i%>"  tabindex="1" onclick="">
          	<option value="0" >--Select--</option>
            <option value="P" <%=HMSUtil.isSelected("P",ameLmc.getPermTemp())%>>Permanent</option>
			<option value="T" <%=HMSUtil.isSelected("T",ameLmc.getPermTemp())%>>Temporary</option>
        </select> </td>
        <td>
        <%if(ameLmc.getDateOfNrv()!= null){ %>
	    <input type="text"  name="dNextReview<%=i%>" id="dNextReview<%=i%>" value="<%=HMSUtil.convertDateToStringWithoutTime(ameLmc.getDateOfNrv())%>" class="calDate" MAXLENGTH="30" validate="Date of Next Review,date,no" />
	    <%}else{%>
	    <input type="text"  name="dNextReview<%=i%>" id="dNextReview<%=i%>" value="" class="calDate" MAXLENGTH="30" validate="Date of Next Review,date,no" />
	    <%} %>
	    
		 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%="dNextReview"+i%>,event)" />
		    
	    </td>
	    <td>
	    <%if(ameLmc.getEmpRestriction()!=null){ %>
	    <input type="text" name ="EmpRestriction<%=i%>" value="<%=ameLmc.getEmpRestriction()%>"tabindex="1" size="25" id="EmpRestriction<%=i%>" maxlength="40"/>
	    <%} %>
	    </td>
	    </tr>
	   <%}
	   i++;   %>
	    <tr>
	    <td>
	    <input type="text" value="" tabindex="1" id="disabilityName<%=i%>" size="30" maxlength="30" name="disabilityName<%=i%>" />
	    </td>
	    <td>
	    <select name="dcategory<%=i%>" tabindex="1" id="dcategory<%=i%>">
	    <option value="0">Select</option>
	 	<%for(MasMedicalCategory category : masMedicalCategoryList){ %>
	 	<option value="<%=category.getId() %>"><%=category.getMedicalCategoryName() %></option>
	 	<%}%>
	 	</select>
	    </td>
	    <td>
	    <input type="text" name ="dduration<%=i%>" tabindex="1" id="dduration<%=i%>" size="10"  maxlength="19"/></td>
	    <td>
	        <select name="permtemp<%=i%>" id="permtemp<%=i%>"  tabindex="1" onclick="">
          	<option value="0" >--Select--</option>
            <option value="P" >Permanent</option>
			<option value="T" >Temporary</option>
        </select> </td>
        <td>
	    <input type="text"  name="dNextReview<%=i%>" id="dNextReview<%=i%>" value="" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
		 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%="dNextReview"+i%>,event)" />
	    </td>
	    <td>
	    <input type="text" name ="EmpRestriction<%=i%>" tabindex="1" size="25" id="EmpRestriction<%=i%>" maxlength="40"/>
	    </td>
	    </tr>
	   <input type="hidden" name="hdb" value="<%=i%>" id="hdb"/>
	  <% }else{ %>
	   <tr>
	    <td>
	    <input type="text" value="" tabindex="1" id="disabilityName1" size="30" maxlength="30" name="disabilityName1" />
	    </td>
	    <td>
	    <select name="dcategory1" tabindex="1" id="dcategory1">
	    <option value="0">Select</option>
	    <%if(masMedicalCategoryList.size()>0){
	 	for(MasMedicalCategory category : masMedicalCategoryList){ %>
	 	<option value="<%=category.getId() %>"><%=category.getMedicalCategoryName() %></option>
	 	<%}
	 	}%>
	 	</select>
	    </td>
	    
	    <td>
	    <input type="text" name ="dduration1" tabindex="1" id="dduration1" size="10"  maxlength="19"/></td>
	    <td>
	        <select name="permtemp1" id="permtemp1"  tabindex="1" onclick="">
          	<option value="0" >--Select--</option>
            <option value="P" >Permanent</option>
			<option value="T" >Temporary</option>
        </select> </td>
        <td>
	    <input type="text"  name="<%="dNextReview1"%>" id="dNextReview1" value="" class="calDate" MAXLENGTH="30" validate="Name,String,Yes" />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%="dNextReview1"%>,event)" />
	    </td>
	    <td>
	    <input type="text" name ="EmpRestriction1" tabindex="1" size="25" id="EmpRestriction1" maxlength="40"/>
	    </td>
	    </tr>
	   <input type="hidden" name="hdb" value="1" id="hdb"/>
	   <%} %>
	    	</table>
		
	</div>
		<input type="button" name="edit" value="Submit" class="button" onClick="submitForm('annualMedicalExamination','mis?method=editAfmsfAnnualMedicalExamination');" />
	  </div>
 <script type="text/javascript">
function validateAME() {
	medCatId = document.getElementById("medCatId").value
	
	var count = document.getElementById("hdb").value;
	var errMsg=""
	if(medCatId ==0)
	 errMsg="Please select Medical category \n"
		boardDate = document.getElementById("boardDate").value
		nextReview = document.getElementById("dNextReview1").value
	   	boardDate = new Date(boardDate.substring(6),(boardDate.substring(3,5) - 1) ,boardDate.substring(0,2));
	 	nextReview = new Date(nextReview.substring(6),(nextReview.substring(3,5) - 1) ,nextReview.substring(0,2));
		if(boardDate > nextReview)
	 	{
	 	errMsg =errMsg+"Next Review date must be greater than Last AME/Board "
			
	 	}
		
		 if(errMsg !=""){
		 alert(errMsg)
		 return false;
		 }else{
		  if(confirm("Are you Sure, you want to save ?")){
		  return true;
		  }else{
		  return false;
		  }
		 }
		 // return true;
}
</script>  
