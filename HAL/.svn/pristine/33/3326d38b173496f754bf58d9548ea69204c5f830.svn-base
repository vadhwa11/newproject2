<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.FatalDocumentHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
	String hinNo=null;
 	String serviceNo=null;

 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	 	
 	List<MasRank> rankList = null;
 		
 	List<MasAdministrativeSex> sexList=null;
 	if (map.get("rankList") != null) {
 		rankList = (List<MasRank>) map.get("rankList");
 		
 	}
 	List<MasUnit> unitList=null;
 	if (map.get("unitList") != null) {
 		unitList = (List<MasUnit>) map.get("unitList");
 		
 	}
 	String message="";
 	if (map.get("message") != null) {
 		message = (String) map.get("message");
 		
 	}
 	List<MasTrade> tradeList=null;
 	if (map.get("tradeList") != null) {
 		tradeList = (List<MasTrade>) map.get("tradeList");
 		
 	}
 	List<Patient> patientList=null;
 	if (map.get("patientList") != null) {
 		patientList = (List<Patient>) map.get("patientList");
 		
 	}
 	List<FatalDocumentHeader> fatalDocumentHeaderList=null;
 	if (map.get("fatalDocumentHeader") != null) 
 	{
 		fatalDocumentHeaderList = (List<FatalDocumentHeader>) map.get("fatalDocumentHeader");
 	}
 	List<Inpatient> inpatientList=null;
 	if (map.get("inpatientList") != null) 
 	{
 		inpatientList = (List<Inpatient>) map.get("inpatientList");
 	}
 	if (map.get("sexList") != null) {
 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
 		
 	}
 	List<OpdPatientHistory> opdPatientHistoryList=null;
 	if (map.get("opdPatientHistoryList") != null) {
 		opdPatientHistoryList = (List<OpdPatientHistory>) map.get("opdPatientHistoryList");
 		
 	}
 	List<MasMedicalCategory> medicalCategoryList=null;
 	if (map.get("medicalCategoryList") != null) {
 		medicalCategoryList = (List<MasMedicalCategory>) map.get("medicalCategoryList");
 		
 	}
 	List<MasMedicalExaminationReportOnEntry> masMedicalExaminationList=null;
 	if (map.get("masMedicalExaminationList") != null)
 	{
 		masMedicalExaminationList = (List<MasMedicalExaminationReportOnEntry>) map.get("masMedicalExaminationList");
 		
 	}
%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><div id="deficientId">
<h4 class="auto"><%=message %></h4>
<div class="Clear"></div>

<h4>Details</h4>
<div class="Block">
<%
if((patientList.size()>0))
{
	String servicePersonName="";
	String adNo="";
	String dob="";
	int age=0;
    String ageYears=""; 
	int rankId=0;
	int unitId=0;
	int tradeId=0;
	int sexId=0;
	int masMedicalId=0;
	String patientHistory="";
    String dateOfComm="";
    int serviceYears=0;
    String hospitalName="";
    String dateOfAddmission="";
    String timeOfAddmission="";
    String diagnosis="";
    String typeOfDeath="";
    String dateOfDeath="";
    String timeOfDeath="";
    String locationOfDeath="";
    String conditionToDeath="";
    String consequenceOf="";
    String otherCondition="";
    String status="";
    String checkStatus="";
    int hinId=0;
	Patient patient= patientList.get(0);  
	hinId=patient.getId();
    if((fatalDocumentHeaderList.size()>0))
	{	
    FatalDocumentHeader fatalDocumentHeader=fatalDocumentHeaderList.get(0);
   if(fatalDocumentHeader.getStatus().equalsIgnoreCase("u"))
   {
	   servicePersonName=fatalDocumentHeader.getSPersonName();
	  if(fatalDocumentHeader.getAdNo()!=null)
	   adNo=fatalDocumentHeader.getAdNo();
	   rankId=fatalDocumentHeader.getRankId().getId();
	   unitId=fatalDocumentHeader.getUnitId().getId();
	   tradeId=fatalDocumentHeader.getTradeId().getId();
	   dob=HMSUtil.changeDateToddMMyyyy(fatalDocumentHeader.getDateOfBirth());
	   sexId=fatalDocumentHeader.getSexId().getId();
	   diagnosis=fatalDocumentHeader.getDiagnosis();
	   typeOfDeath=fatalDocumentHeader.getTypeOdDeath();
	   if(fatalDocumentHeader.getDateOfDeath()!=null)
	   dateOfDeath=HMSUtil.changeDateToddMMyyyy(fatalDocumentHeader.getDateOfDeath());
	   if(fatalDocumentHeader.getTimeOfDeath()!=null)
		   timeOfDeath=fatalDocumentHeader.getTimeOfDeath();
	   locationOfDeath =fatalDocumentHeader.getLocationOfDeath();
	   conditionToDeath=fatalDocumentHeader.getConditionToDeath();
	   consequenceOf=fatalDocumentHeader.getDueConsequence();
	   if(fatalDocumentHeader.getOtherCondition()!=null)
		   otherCondition=fatalDocumentHeader.getOtherCondition();	   
	   if(fatalDocumentHeader.getAge()!=null)
       {
	     String arr[]=fatalDocumentHeader.getAge().split(" ");
    	 age=Integer.parseInt(arr[0]);
    	 ageYears=arr[1];
       }
	   if(fatalDocumentHeader.getTotalService()!=null)
       {
	     String arr[]=fatalDocumentHeader.getTotalService().split(" ");
	     serviceYears=Integer.parseInt(arr[0]);
    	 //ageYears=arr[1];
       }
	   if(fatalDocumentHeader.getDateOfComm()!=null)
       {
       	dateOfComm=HMSUtil.changeDateToddMMyyyy(fatalDocumentHeader.getDateOfComm());
       }
	   if(fatalDocumentHeader.getMedicalCategoryId()!=null)
      	masMedicalId=fatalDocumentHeader.getMedicalCategoryId().getId();
	   if((fatalDocumentHeader.getPrevMedHistory()!=null))
       {
       	patientHistory=fatalDocumentHeader.getPrevMedHistory();
       }
	   if((fatalDocumentHeader.getHospitalName()!=null))
       {
	   hospitalName=fatalDocumentHeader.getHospitalName();
       }
	   if(fatalDocumentHeader.getDateOfAdmission()!=null)
	   dateOfAddmission=HMSUtil.changeDateToddMMyyyy(fatalDocumentHeader.getDateOfAdmission());
	   if(fatalDocumentHeader.getTimeOfAdmission()!=null)
	   timeOfAddmission=fatalDocumentHeader.getTimeOfAdmission();
	   status=fatalDocumentHeader.getStatus();
	   checkStatus=fatalDocumentHeader.getStatus();
   }
   else
   {
	     servicePersonName=patient.getSFirstName();
          if(patient.getSMiddleName()!=null)
	      servicePersonName=servicePersonName+" "+patient.getSMiddleName();
         if(patient.getSLastName()!=null)
	      servicePersonName=servicePersonName+" "+patient.getSLastName();
 
         if(inpatientList.size()>0)
         {
             Inpatient inpatient=inpatientList.get(0); 
              adNo=inpatient.getAdNo();
            dateOfAddmission=HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
           	timeOfAddmission=inpatient.getTimeOfAddmission();
         }
         rankId=patient.getRank().getId();
         unitId=patient.getUnit().getId();
         tradeId=patient.getTrade().getId();
         sexId=patient.getSex().getId();
         serviceYears=patient.getServiceYears().intValue();
         if(patient.getDateOfBirth()!=null)
          {
           dob=HMSUtil.changeDateToddMMyyyy(patient.getDateOfBirth());
          }
         if(patient.getAge()!=null)
         {
         	String arr[]=patient.getAge().split(" ");
         	age=Integer.parseInt(arr[0]);
         	ageYears=arr[1];
         }	
         if(patient.getCommissionDate()!=null)
         {
         	dateOfComm=HMSUtil.changeDateToddMMyyyy(patient.getCommissionDate());
         }
         if((masMedicalExaminationList!=null))
         {if((masMedicalExaminationList.size()>0))
         { 
        	MasMedicalExaminationReportOnEntry masMedicalExamination=masMedicalExaminationList.get(0);
            if(masMedicalExamination.getPastMedicalCategory()!=null)
        	masMedicalId=masMedicalExamination.getPastMedicalCategory().getCategoryid();
          }  
         }
             
         if((opdPatientHistoryList!=null))
         {
         	if((opdPatientHistoryList.size()>0))
         	{	
         	OpdPatientHistory opdPatientHistory=opdPatientHistoryList.get(0);
         	if(opdPatientHistory.getPastMedicalHistory()!=null)
         	patientHistory=opdPatientHistory.getPastMedicalHistory();
         	}
         }
         if(patient.getHospital()!=null)    
 			hospitalName=patient.getHospital().getHospitalName();
         
         status=fatalDocumentHeader.getStatus(); 	
         checkStatus=fatalDocumentHeader.getStatus();
         diagnosis=fatalDocumentHeader.getDiagnosis();
  	   typeOfDeath=fatalDocumentHeader.getTypeOdDeath();
  	   if(fatalDocumentHeader.getDateOfDeath()!=null)
  	   dateOfDeath=HMSUtil.changeDateToddMMyyyy(fatalDocumentHeader.getDateOfDeath());
  	   if(fatalDocumentHeader.getTimeOfDeath()!=null)
  		   timeOfDeath=fatalDocumentHeader.getTimeOfDeath();
  	   locationOfDeath =fatalDocumentHeader.getLocationOfDeath();
  	   conditionToDeath=fatalDocumentHeader.getConditionToDeath();
  	   consequenceOf=fatalDocumentHeader.getDueConsequence();
  	 if(fatalDocumentHeader.getOtherCondition()!=null)
	  otherCondition=fatalDocumentHeader.getOtherCondition();	   
    }
  }else
	{
		 servicePersonName=patient.getSFirstName();
		 if(patient.getSMiddleName()!=null)
		 {	 
		  servicePersonName=servicePersonName+" "+patient.getSMiddleName();
		 }
		 status="r";
		 if(patient.getSLastName()!=null)
		 servicePersonName=servicePersonName+" "+patient.getSLastName();
		 if(patient.getRank()!=null)
		 rankId=patient.getRank().getId();
		 if(patient.getUnit()!=null)
		 unitId=patient.getUnit().getId();
		 if(patient.getTrade()!=null)
		 tradeId=patient.getTrade().getId();
		 if(patient.getSex()!=null)
		 sexId=patient.getSex().getId();
		 serviceYears=patient.getServiceYears().intValue();
		 if(inpatientList.size()>0)
		   {
		    Inpatient inpatient=inpatientList.get(0); 
		    adNo=inpatient.getAdNo();
		    dateOfAddmission=HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
	       	timeOfAddmission=inpatient.getTimeOfAddmission();
		   }
		 if(patient.getDateOfBirth()!=null)
         {
          dob=HMSUtil.changeDateToddMMyyyy(patient.getDateOfBirth());
         }
		 if(patient.getAge()!=null)
         {
         	String arr[]=patient.getAge().split(" ");
         	age=Integer.parseInt(arr[0]);
         	ageYears=arr[1];
         }	
		 if(patient.getCommissionDate()!=null)
         {
         	dateOfComm=HMSUtil.changeDateToddMMyyyy(patient.getCommissionDate());
         }
		 if((masMedicalExaminationList!=null))
         {if((masMedicalExaminationList.size()>0))
         { 
        	MasMedicalExaminationReportOnEntry masMedicalExamination=masMedicalExaminationList.get(0);
            if(masMedicalExamination.getPastMedicalCategory()!=null)
        	masMedicalId=masMedicalExamination.getPastMedicalCategory().getCategoryid();
          }  
         }
		 if((opdPatientHistoryList!=null))
         {
         	if((opdPatientHistoryList.size()>0))
         	{	
         	OpdPatientHistory opdPatientHistory=opdPatientHistoryList.get(0);
         	if(opdPatientHistory.getPastMedicalHistory()!=null)
         	patientHistory=opdPatientHistory.getPastMedicalHistory();
         	}
         }
		if(patient.getHospital()!=null)    
			hospitalName=patient.getHospital().getHospitalName();
		
	}
%>

<label>Service No.<span>*</span></label>
<input	type="text" name="serviceNo" id="serviceNo" tabindex="1"  readonly="readonly" value="<%=patient.getServiceNo() %>" validate="Service No,string,yes" />
<label>A&D No.</label>
 <input	type="text" name="adNo" id="adNo"  tabindex="1"  value="<%=adNo %>" />
<input type="hidden" name="checkStatus" id="checkStatus" value="<%=checkStatus %>" />
<label> Rank <span>*</span></label> 
<select	name="rank" id="rank" tabindex="1" readonly="readonly">
<%for(MasRank masRank:rankList){ 
  if(masRank.getId()==rankId)
  {	  
%>

	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{ %>
	<option value="<%=masRank.getId() %>" ><%=masRank.getRankName()%></option>
	<%} }%>
</select> 

<div class="Clear"></div>

<label>Name <span>*</span></label> 
<input type="text" readonly="readonly" name="sPerName" tabindex="1"  id="sPerName" value="<%=servicePersonName %>" MAXLENGTH="30" validate="Ser Pers Name No,string,yes" />
<input type="hidden" name="status" id="status" value="<%=status %>" />

<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>" />

<label>DOB </label> 
<input type="text" id="dobId" readonly="readonly"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value="<%=dob %>"	onblur="calculateAgeInAjaxFunction();" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.fatalDocumentForm.<%=DATE_OF_BIRTH%>,event)" />

<label> Age <span>*</span></label>
<div id="ageDiv" style="display: block;">
<select id="ageId" readonly="readonly"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
					if(age1==age)
					{	
				%>
	<option value="<%=age1%>" selected="selected"><%= age1%></option>
		<%}else{ %>
	<option value="<%=age1%>"><%= age1%></option>
	<%}}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>" readonly="readonly"	validate="AgeUnit,string,yes" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value=""/>
</div>

<div class="Clear"></div>

<label>Gender <span>*</span> </label>
<select	name="sex" id="sex" tabindex="1" readonly="readonly" >
<%for(MasAdministrativeSex masSex:sexList)
  { 
  if(masSex.getId()==sexId)
  {	  
%>
	<option value="<%=masSex.getId() %>" selected="selected"><%=masSex.getAdministrativeSexName() %></option>
	<%}else{ %>
	<option value="<%=masSex.getId() %>" ><%=masSex.getAdministrativeSexName() %></option>
	
	<%}} %>
</select> 

<label> Unit <span>*</span></label>

<select	name="unit" id="unit" tabindex="1" >
<%for(MasUnit masUnit:unitList){ 
	 if(masUnit.getId()==unitId)
	  {	
%>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%} }%>
</select> 
<label>Branch/ Trade </label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Branch/Trade,string,no" tabindex="1"  	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ 
		 if(trade.getId()==tradeId)
		  {	
	%>
	<option value="<%=trade.getId()%>" selected="selected"><%=trade.getTradeName() %></option>
	<%}else{ %>
<option value="<%=trade.getId()%>"><%=trade.getTradeName() %></option>
	
	<%}} %>
	</select>

<div class="Clear"></div>

<label>DOE/ DOC </label> 

<input type="text" readonly="readonly"	id="commissionDateId" name="commissionDate" tabindex="1" value="<%=dateOfComm %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalServiceFunction(this.value);" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentForm.commissionDate,event)" /> 
<input	type="hidden" id="idForComEnrlDate" value=""/> 


<label>Total Service <span>*</span></label> 
<input id="totalServYrs" type="hidden" readonly="readonly" name="" value=""	validate="Total Service,float,yes" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<select	id="totalServ" name="<%=TOTAL_SERVICE%>" readonly="readonly"	validate="Total Service year,string,yes" tabindex="1" class="small"	onchange="checkAgeAndService();">
	<%
	          
				for(int age1=0;age1<=100;age1++)
				{
                    if(age1==serviceYears)
                    {	
					%>
	<option value="<%=age1%>" selected="selected"><%= age1%></option>
	<%}else{%>
	<option value="<%=age1%>" ><%= age1%></option>
<%}} %>
</select> 

<select id="totalServUnit" readonly="readonly" name="<%=TOTAL_SERVICE_PERIOD %>" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
</div>


<label>Med. Category <span>*</span></label>
 

<select	name="medicalCategory" readonly="readonly" id="medicalCategory" tabindex="1"  validate="Med Cate,string,yes" >
<%for(MasMedicalCategory medicalCategory:medicalCategoryList){ 
   if(medicalCategory.getId()==masMedicalId)
   {	   
%>
	<option value="<%=medicalCategory.getId() %>" selected="selected"><%=medicalCategory.getMedicalCategoryName() %></option>
	<%}else{ %>
	<option value="<%=medicalCategory.getId() %>" ><%=medicalCategory.getMedicalCategoryName() %></option>

	<%} }%>
</select> 
<div class="Clear"></div>

<label>Prev. Med History</label> 

<input	type="text" id="preMedHistory" readonly="readonly" name="preMedHistory" value="<%=patientHistory %>" tabindex="1"  />
<label>Diagnosis <span>*</span></label> 
<input	type="text" id="diagnosis" name="diagnosis" value="<%=diagnosis %>" tabindex="1" validate="Diagnosis,string,yes"/>

<label>Name of SMC/Unit</label> 
<input	type="text" id="hospitalName" name="hospitalName" value="<%=hospitalName %>" tabindex="1" />
<div class="Clear"></div>
<label>Date of Admission</label> 
<input	type="text" id="dateOfAdmission" name="dateOfAdmission"
	value="<%=dateOfAddmission %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" tabindex="1"  /> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" 	class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfAdmission,event)" />
<label>Time of Admission</label> 
<input type="text" id="timeOfAdmission" name="timeOfAdmission" tabindex="1" 
onKeyUp="mask(this.value,this,'2',':',event);" value="<%=timeOfAddmission %>" onblur="IsValidTimeWithoutBlank(this.value,'timeOfDeath')"  maxlength="5"/> 

<label>Date of Death <span>*</span></label> 
<input tabindex="1" type="text" id="dateOfDeath" name="dateOfDeath"	value="<%=dateOfDeath %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" validate="Date of Death,string,yes"/> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfDeath,event)" />
		
<label>Time of Death <span>*</span></label> 
<input type="text" tabindex="1"  id="timeOfDeath" name="timeOfDeath" onKeyUp="mask(this.value,this,'2',':',event);"
value="<%=timeOfDeath %>" validate="Time of Death,String,yes" onblur="IsValidTimeWithoutBlank(this.value,'timeOfDeath')" 
 maxlength="5"/> 
<input type="hidden" id="fatalStatus" name="fatalStatus" value="u"/> 

     
<label>Type of Death <span>*</span></label> 
<input	type="text" id="typeOfDeath" name="typeOfDeath" value="<%=typeOfDeath %>" tabindex="1" validate="Type of Death,string,yes"/>


<label>Place Of Death <span>*</span></label> 
<input	tabindex="1"  type="text" id="locationOfDeath" name="locationOfDeath" value="<%=locationOfDeath %>" validate="Location of Death,string,yes"/>

<div class="Clear"></div>
<label>Disease or Condition directly leading to Death</label> 
<textarea class="auto" tabindex="1" cols="44"  name="diseaseDeath" id="diseaseDeath" rows="2" tabindex="1" validate="Disease leading to Death ,string,no"
	onkeyup="chkLength(this,500);"><%=conditionToDeath %></textarea>
<label>MLC</label>
<input type="checkbox" name="mlc" value="y" class="radioAuto2" onclick="displayMlcNo(this);">
<div id="mlc" style="display: none;">
<label>MLC No.</label>
<input type="text" name="mlcNo" id="mlcNo" value="" maxlength="20"/>
</div>
  <div class="Clear"></div>
<label>Due to or as a consequence of</label> 
<textarea class="auto" tabindex="1"  cols="44" name="consequenceOf" id="consequenceOf"	 rows="2" tabindex="1" validate="Due to consequence,string,no"
	onkeyup="chkLength(this,500);"><%=consequenceOf %></textarea>


<label>Other Significant Conditions If any</label> 
<textarea class="auto" cols="44" name="otherConditions" id="otherConditions" tabindex="1" 	 rows="2" tabindex="1" 
onkeyup="chkLength(this,500);"><%=otherCondition %></textarea>

<% }else{%>

<label>Service No. <span>*</span></label>
 <input	type="text" name="serviceNo" id="serviceNo" tabindex="1"  value="" validate="Service No,string,yes" />
 <label>A&D No.</label>
 <input	type="text" name="adNo" id="adNo" tabindex="1"  value="" />
 
<label> Rank <span>*</span></label> 
<select	name="rank" id="rank" tabindex="1" >
<%for(MasRank masRankList:rankList){ %>
	<option value="<%=masRankList.getId() %>"><%=masRankList.getRankName()%></option>
	<%} %>
</select> 

<div class="Clear"></div>

<label>Name <span>*</span></label> 
<input type="text" name="sPerName" tabindex="1"  id="sPerName" value="" MAXLENGTH="30" validate="Name,string,yes" />

<label>DOB </label> 
<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""	onblur="calculateAgeInAjaxFunction();" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.fatalDocumentForm.<%=DATE_OF_BIRTH%>,event)" />
<input type="hidden" name="status" id="status" value="u" />
<input type="hidden" name="checkStatus" id="checkStatus" value="" />
<label> Age <span>*</span></label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,yes" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value=""/>
</div>
<div class="Clear"></div>

<label>Gender <span>*</span></label>
<select	name="sex" id="sex" tabindex="1" >
<%for(MasAdministrativeSex masSexList:sexList){ %>
	<option value="<%=masSexList.getId() %>"><%=masSexList.getAdministrativeSexName() %></option>
	<%} %>
</select> 

<label> Unit <span>*</span></label>

<select	name="unit" id="unit" tabindex="1" >
<%for(MasUnit masUnitList:unitList){ %>
	<option value="<%=masUnitList.getId() %>"><%=masUnitList.getUnitName()%></option>
	<%} %>
</select> 
<label>Branch/Trade </label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Branch/Trade,string,no" tabindex="1"  	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	</select>
	
<div class="Clear"></div>


<label>Date of Comm/Enroll</label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalServiceFunction(this.value);" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentForm.commissionDate,event)" /> 
<input	type="hidden" id="idForComEnrlDate" value=""/> 



<label>Total Service <span>*</span></label> 
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,yes" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<select	id="totalServ" name="<%=TOTAL_SERVICE%>"	validate="Total Service year,string,yes" tabindex="1" class="small"	onchange="checkAgeAndService();">
	<%
				for(int age1=0;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
</div>



<label>Med. Category <span>*</span></label>

<select	name="medicalCategory" id="medicalCategory" tabindex="1"  validate="Med Cate,string,yes" >
<%for(MasMedicalCategory medicalCategory:medicalCategoryList){ %>
	<option value="<%=medicalCategory.getId() %>"><%=medicalCategory.getMedicalCategoryName() %></option>
	<%} %>
</select> 
 <div class="Clear"></div>
<label>Prev. Med History <span>*</span></label> 
<input	type="text" id="preMedHistory" name="preMedHistory" value="" tabindex="1" validate="Prev Med History,string,yes" />
<label>Diagnosis <span>*</span></label> 
<input	type="text" id="diagnosis" name="diagnosis" value="" tabindex="1" validate="Diagnosis,string,yes"/>



<label>Name of SMC/Unit</label> 
<input	type="text" id="hospitalName" name="hospitalName" value="" tabindex="1" />
<div class="Clear"></div>

<label>Date of Admission</label> 
<input	type="text" id="dateOfAdmission" name="dateOfAdmission"
	value="" class="calDate" readonly="readonly"
	MAXLENGTH="30" tabindex="1"  /> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfAdmission,event)" />
<label>Time of Admission</label> 
<input type="text" id="timeOfAdmission" name="timeOfAdmission" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" value="" onchange="IsValidTime(this.value,this.id);"  maxlength="5"/> 

<label>Date of Death <span>*</span></label> 
<input tabindex="1" type="text" id="dateOfDeath" name="dateOfDeath"	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" validate="Date of Death,string,yes"/> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfDeath,event)" />
	<div class="Clear"></div>	
<label>Time of Death <span>*</span></label> 
<input type="text" tabindex="1"  id="timeOfDeath" name="timeOfDeath"onKeyUp="mask(this.value,this,'2',':');" value="" validate="Time of Death,String,yes" onchange="IsValidTime(this.value,this.id);"  maxlength="5"/> 
<input type="hidden" id="fatalStatus" name="fatalStatus" value="u"/> 


<label>Type of Death <span>*</span></label> 
<input	type="text" id="typeOfDeath" name="typeOfDeath" value="" tabindex="1" validate="Type of Death,string,yes"/>
<label>Place Of Death <span>*</span></label> 
<input	tabindex="1"  type="text" id="locationOfDeath" name="locationOfDeath" value="" validate="Location of Death,string,yes"/>
<div class="Clear"></div>
<label>Disease or Condition directly leading to Death</label> 
<textarea class="auto" tabindex="1" cols="44" name="diseaseDeath" id="diseaseDeath"	 rows="2" tabindex="1" validate="Disease leading to Death ,string,no"
	onkeyup="chkLength(this,500);"></textarea>
	<label>MLC</label>
<input type="checkbox" name="mlc" value="y" class="radioAuto2" onclick="displayMlcNo(this);">
<div id="mlc" style="display: none;">
<label>MLC No.</label>
<input type="text" name="mlcNo" id="mlcNo" value="" maxlength="20"/>
</div>
<div class="Clear"></div>
<label>Due to or as a consequence of</label> 
<textarea class="auto" tabindex="1"  cols="44" name="consequenceOf" id="consequenceOf"	 rows="2" tabindex="1" validate="Due to consequence,string,no"
	onkeyup="chkLength(this,500);"></textarea>


<label>Other Significant Conditions If any</label> 
<textarea class="auto" cols="44" name="otherConditions" id="otherConditions" tabindex="1" 	 rows="2" tabindex="1" 
onkeyup="chkLength(this,500);"></textarea>

<% }%>
</div>
</div>

<script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}

</script>