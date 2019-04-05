<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
 	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasMedicalCategory> masMedicalCategoryList = new ArrayList<MasMedicalCategory>();
	
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("masMedicalCategoryList") != null) {
 		masMedicalCategoryList = (List<MasMedicalCategory>) map.get("masMedicalCategoryList");
 	}
 	if (map.get("empList") != null) {
 		empList = (List<MasEmployee>) map.get("empList");
 	}
 	int hospitalId=0;
	if(session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
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
 			<%
 			int empId=0;
 			String rankName="";
 			String name="";
 			String firstName="";
 			String midName="";
 			String lastName="";
 			String tradeName="";
 			String unitName="";
 			
 			int rankId=0;
 			int tradeId=0;
 			int unitId=0;
 			
 				System.out.println("empList in jsp :"+empList.size());
 			for(MasEmployee masEmployee:empList){
 				if(masEmployee.getFirstName()!=null){
 					firstName=masEmployee.getFirstName();}
 				if(masEmployee.getMiddleName()!=null){
 					midName=masEmployee.getMiddleName();}
 				if(masEmployee.getLastName()!=null){
 					lastName=masEmployee.getLastName();}
 				name=firstName+" "+midName+" "+lastName;
 				if(masEmployee.getRank()!=null){
 					rankName=masEmployee.getRank().getRankName();
 					rankId=masEmployee.getRank().getId();
 				}else{
 					rankName="-";
 				}
 				if(masEmployee.getUnit()!=null){
 					unitName=masEmployee.getUnit().getUnitName();
 					unitId=masEmployee.getUnit().getId();
 				}else{
 					unitName="-";
 				}
 				if(masEmployee.getTrade()!=null){
 					tradeName=masEmployee.getTrade().getTradeName();
 					tradeId=masEmployee.getTrade().getId();
 				}else{
 					tradeName="-";
 				}
 				empId=masEmployee.getId();
 				String afmsType="";
 				if(masEmployee.getUnit()!=null){
 					if(masEmployee.getUnit().getDependentUnit().equalsIgnoreCase("y")){
 						afmsType="IN";
 					}else{
 						afmsType="OUT";
 					}
 					
 				}
 			%>
 	<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId %>" /> 
      <input type="hidden"  name="<%=EMPLOYEE_ID %>" id="empId" value="<%=empId%>" />
	 <label  class="bodytextB">Rank:</label>
	  <input type="text"  name="<%=RANK %>" id="name" value="<%=rankName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
	   <input type="hidden"  name="<%=RANK_ID %>" id="name" value="<%=rankId %>" >
	    <input type="hidden"  name="<%=AFMSF_TYPE %>" id="afmsfType" value="<%=afmsType %>" >
	  <label  class="bodytextB">Name:</label>
	  <input type="text"  name="<%=FIRST_NAME %>" id="name" value="<%=name %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
       <label  class="bodytextB">Trade:</label>
	  <input type="text"  name="<%=TRADE%>" id="name" value="<%=tradeName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
	  <input type="hidden"  name="<%=TRADE_ID%>" id="name" value="<%=tradeId %>"/>
	    <div class="Clear"></div>
      <label  class="bodytextB">Parent Unit:</label>
	  <input type="text"  name="<%=UNIT_NAME%>" id="name" value="<%=unitName %>" class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" style="border: 1px solid #7f9db7; width: 130px;"/>
	  <input type="hidden"  name="<%=UNIT_ID%>" id="name" value="<%=unitId%>"/>
		<label  class="bodytextB"><font id="error">*</font>Medical Category:</label>
	  <select name="<%=MEDICAL_CATEGORY_ID %>" id="medCatId" validate="Medical Category,string,yes">
	 	<option value="">Select</option>
			<% 
				for (MasMedicalCategory  medicalCategory : masMedicalCategoryList){
				%>

		<option value="<%=medicalCategory.getId ()%>"><%=medicalCategory.getMedicalCategoryName()%></option>

		<%}%>
	
	 	</select>
	 
	 	<label  class="bodytextB">Period:</label>
	 	<select name="<%=PERIOD %>">
	 		<option value="">--Select--</option>
			 	<option value="T">Temporary</option>
		 		<option value="P" >Permanent</option>
	 	</select>
	 	  <div class="Clear"></div>
	 	<label  class="bodytextB">Duration:</label>
	    <input type="text" name="<%=DURATION %>" id="dduration" value="" >
	    
	    <label  class="bodytextB"><font id="error">*</font>Last AME/Board:</label>
	  	<input type="text"  name="<%=AME_DATE%>" id="boardDate" value="" class="calDate" MAXLENGTH="30" validate="Last AME/Board,date,yes" readonly="readonly"/>
	  	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=AME_DATE%>,event)" />
		 
		<label  class="bodytextB"><font id="error">*</font>Next Review:</label>
		  <input type="text"  name="<%=NEXT_REVIEW_DATE%>" id="nextReview" value="" class="calDate" MAXLENGTH="30" validate="Next Review,date,yes" readonly="readonly"/>
		 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 class="calender"onClick="setdate('',document.annualMedicalExamination.<%=NEXT_REVIEW_DATE%>,event)" />
		<%} %>
		 <div class="Clear"></div>
		<input type="button" name="edit" value="Submit" class="button" onClick="submitForm('annualMedicalExamination','mis?method=submitAnnualMedicalExamination');" />
	  </div>
	  </div>