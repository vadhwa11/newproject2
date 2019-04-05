

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>

<%String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
	System.out.println("userName-"+userName);

	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	
 	Box box = HMSUtil.getBox(request);
 	
 	Map<String, Object> map = new HashMap<String, Object>();
 	
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<MasRank>rankList=new ArrayList<MasRank>();
	List<MasUnit> unitList=new ArrayList<MasUnit>();
	List<MasTrade> tradeList =new ArrayList<MasTrade>();
	List<MasMedicalCategory> masMedicalList =new ArrayList<MasMedicalCategory>();
	List<Patient> patientList = new ArrayList<Patient>();

	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("patientList") != null) {
 		patientList = (List<Patient>) map.get("patientList");
 	}
 	System.out.println("patientList  "+patientList.size());
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
 	
 	
 	int empAfmsId =0;
 	int hinId =0;
 	String name  = "";
 	String lname = "";
 	int rankId =0;
 	String serviceNo ="";
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
 	String age ="";
 	
 	for(Patient patient :patientList){
 		empAfmsId = patient.getId();
 		hinId= patient.getId();
 		name = patient.getSFirstName();
 		age=patient.getAge();	
 		if(patient.getSLastName() != null){
 			lname = patient.getSLastName();  			
 		}
 		if(patient.getRank() !=null)
 		rankId = patient.getRank().getId();
 		/*
 		if( patient.getPostedFrom() !=null)
 		postedFromId = patient.getPostedFrom().getId();
 		if(patient.getPostedTo() !=null)
 		postedToId = patient.getPostedTo().getId();
 		if(patient.getPostInDate() !=null){
 		postedInDate = ""+patient.getPostInDate();
 		
 		
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 postedInDate=formatterOut.format(formatterIn.parse(postedInDate));
 		}
 		
 		if(patient.getLetterNo() !=null)
 		letterNo = patient.getLetterNo();
 		if(patient.getAuthPosting() !=null)
 		authOfPosting = patient.getAuthPosting();
 		if(patient.getMedicalCategory() !=null)
 	 		medicalCat = patient.getMedicalCategory().getId();
 		
 		if(patient.getLetterNo() != null)
 			recLatterNo = patient.getLetterNo();
 		
 		if(patient.getRecDate() != null){
 			recDate = ""+patient.getRecDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 		recDate = formatterOut.format(formatterIn.parse(recDate));
 		}
 		
 		if(patient.getRemarks() != null)
 	    	remarks = patient.getRemarks();
 		*/
 		
 		
 		if(patient.getStatus() !=null)
 		status = patient.getStatus();
 		if(patient.getTrade() != null)
 			trade = patient.getTrade().getId();
 		
 		if(patient.getUnit() !=null)
 			presentId = patient.getUnit().getId();
 		
 		if(patient.getServiceNo() != null){
 			serviceNo = patient.getServiceNo();
 		}
 		if(patient.getSuffix() != null){
 		    suffix = patient.getSuffix();
 	    }
 		/*
 		if(masEmployee.getNextReview() !=null){
 	 		reviewDate = ""+masEmployee.getNextReview();
 	 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
 			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
 			reviewDate=formatterOut.format(formatterIn.parse(reviewDate));
 	 	}
 	
 		if(masEmployee.getDiagnosis() != null){
 			diagnosis = masEmployee.getDiagnosis();
 		}
 		
 	  	
 		if(masEmployee.getAuthPosting()!= null && masEmployee.getAuthPosting() != "" &&
 				masEmployee.getPostInDate() != null){
 			if(masEmployee.getRecDate()!= null && masEmployee.getLetterNo()!=null && 
 					masEmployee.getLetterNo() != ""){
 				message = "Arrival and Receipt entry's Added ";
 			}else{
 				message ="Arrival entry added";
 			}
 		}else{
 			   message = "No record added to this service no";
 		}
 		
       if(masEmployee.getAfmsfType().equals("OUT")){
    	   afmsType = masEmployee.getAfmsfType();
    	    message = message + "\n( service person cleared this place)!!";
       }
 		*/
 	
 	}
 		
%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%><script>

 if(document.getElementById("serviceNo").value  != null){
    	var serviceNo = document.getElementById("serviceNo").value;
    	document.getElementById("serviceNo1").value = serviceNo ;
 }
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
	<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
	 <div class="mesg" style="width: 100%; height: 23px;">
      <%=message %>
	
	</div></div>
<%// } %>
 -->
<%
 if(map.get("message") != null){
					 message = (String)map.get("message");
					%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<label class="noWidth"> <span> <%=message %> </span> </label>
<% } %>
<div class="Clear"></div>
<div class="Block">
<input type="hidden" name="<%=HIN_ID%>" id="<%=HIN_ID%>" value="<%=hinId%>" />
 <label>ServiceNo:</label>
<%if(serviceNo != ""){ %> <input type="text" name="serviceNo"
	id="serviceNo1" tabindex="1" value="<%=serviceNo%>" readonly="true" />
<%}else{%> <input type="text" name="serviceNo" id="serviceNo1"
	tabindex="1" value="" readonly="readonly" /> <%}%>
	 <label><span>*</span>
Rank:</label> <select name="<%=RANK_ID %>" id="rankId" tabindex="2">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
				if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select>
<div class="Clear"></div>
<label><span>*</span> First Name:</label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="<%=name%>"
	MAXLENGTH="30" validate="Name,String,Yes" tabindex="3" /> <label><span>*</span>
Last Name:</label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname"
	value="<%=lname%>" MAXLENGTH="30" tabindex="4" /> 
	

<div class="Clear"></div>

<label><span>*</span> Trade:</label> <select name="<%=TRADE%>"
	id="trade" tabindex="5">
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
<label><span>*</span> Unit:</label> <select
	name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="6">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(presentId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select>
<div class="Clear"></div>
 <label><span>*</span> Age:</label> <input type="text"
	name="<%=AGE%>" id="age" value="<%=age%>" tabindex="7" maxlength="3"/>
	
 
 <label><span>*</span> Medical Category:</label> <select
	name="<%=MEDICAL_CATEGORY %>" id="medicalCategory"  tabindex="8">
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
</div>
<div class="Clear"></div>