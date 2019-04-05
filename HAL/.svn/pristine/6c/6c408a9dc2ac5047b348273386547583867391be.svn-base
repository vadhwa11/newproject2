<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.Category"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	List patientDataList = new ArrayList();
	
	Set<PatientInvestigationDetails> patientInvestigationdetails = null;
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();

	
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
		System.out.println("patientDataList--->"+patientDataList.size() );
		
	}
	
	if(map.get("patientPrescriptionHeaderList") != null){
		patientPrescriptionHeaderList=(List)map.get("patientPrescriptionHeaderList");
	}
	
	PatientPrescriptionHeader patientPrescriptionHeader = null;
	if(patientPrescriptionHeaderList.size()>0){
		patientPrescriptionHeader = patientPrescriptionHeaderList.get(0);
	}

	

	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
	deptList=(List)map.get("deptList");
	}

	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
		}
	
	List<Category> categoryList= new ArrayList<Category>();
	if(map.get("categoryList") != null){
		categoryList=(List)map.get("categoryList");
	}
	
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	
		
	Visit visit=(Visit)patientDataList.get(0);
	
	String patientName="";
	String servicePersionName="";
	if(visit.getHin().getPFirstName()!= null){
	patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
	patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
	patientName=patientName+" "+visit.getHin().getPLastName();
	}
	String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	int deptId=0;
	String departmentName="";
	String departmentCode="";
	
	if(visit.getDepartment() != null)
	{
	 deptId=visit.getDepartment().getId();
	 departmentName=visit.getDepartment().getDepartmentName();
	 departmentCode=visit.getDepartment().getDepartmentCode();
	}

	%>
<!--main content placeholder starts here-->
<form name="opdMain" action="" method="post">
<input type="hidden" name="userName" value="<%=userName %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg"><h2>AFMSF-7A</h2></div>
<div class="clear"></div>
<%} %>
 <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();

	</script> <%
			if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	    %> <!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<% 
if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self"))
{ 
%>
<label>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %>
<input	type="hidden" name="<%=SERVICE_NO %>" tabindex="2"	value="<%=visit.getHin().getServiceNo()%>" readonly="readonly" />
</label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Patient Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label>
	 <input	type="hidden" name="pName" tabindex="2"	value="<%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %>" readonly="readonly" />
	 <%}}else{ %> 
	
	<label class="value"></label>
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label>Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %>
 <input	type="hidden" name="<%=RANK_ID %>" tabindex="2"	value="<%=visit.getHin().getRank().getId()%>" readonly="readonly" />
</label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label>Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
		
		
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}
					servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
					}%> <label
	class="value"><%=patientName %>
	 <input	type="hidden" name="pName" tabindex="2"	value="<%=patientName%>" readonly="readonly" />
	</label> 
<%} %>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %>
<input	type="hidden" name="<%=TRADE_ID %>" tabindex="2"	value="<%=visit.getHin().getTrade().getId()%>" readonly="readonly" />
</label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<input type="hidden" name="unitId" value="<%=visit.getHin().getUnit().getId() %>"/>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<%if(visit.getHin().getRelation().getId() != 8){ %>
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%}} %>
<label >Marital Status</label> 
<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 

<label >Blood Group</label>
<%
if(visit.getHin().getBloodGroup() != null ){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<label >Medical Category</label>
<%if(visit.getHin().getCategory() != null){ %>
<label class="value"><%=visit.getHin().getCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Date</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
 <label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" readonly="readonly" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="91" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="100" id="allergies" size="92"  />
<%} %>

 <% }else{%>
 
<label>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <input	type="hidden" name="<%=SERVICE_NO %>" tabindex="2"	value="<%=visit.getHin().getServiceNo()%>" readonly="readonly" />
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label	>Patient Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
		
		
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}
					servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
					}%> <label
	class="value"><%=patientName %>
	 <input	type="hidden" name="pName" tabindex="2"	value="<%=patientName%>" readonly="readonly" />
	</label> 
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %>
 <input	type="hidden" name="<%=RANK_ID %>" tabindex="2"	value="<%=visit.getHin().getRank().getId()%>" readonly="readonly" />
</label>
<%}else{ %> <label class="value"></label> <%} %>

<label>Name</label>
<label class="value"><%=servicePersionName %></label>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %>
<input	type="hidden" name="<%=TRADE_ID %>" tabindex="2"	value="<%=visit.getHin().getTrade().getId()%>" readonly="readonly" />
</label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
<div class="clear"></div>

 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
 <div class="clear"></div>
 
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label >Marital Status</label> 
<%if(visit.getHin().getMaritalStatus() != null){ %>
<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label> 
<%} %> 

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
 <div class="clear"></div>
<label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="91" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="100" id="allergies" size="92"  />
<%} %>

<% }%>
<div class="clear"></div>
</div>

<div class="Block">

<label >Present Condition</label>
<textarea name="conditionOfGums" cols="0" rows="0"  maxlength="100" validate="Present Condition,string,no" value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>



<div class="clear"></div>
<label>Present Med Cat</label>
<select	name="<%= PRESENT_MEDICAL_CATEGORY %>" validate="Present Med Cat,string,no"	tabindex=1>
   	 	<option value="0">Select</option>
	<%
	if(visit.getHin().getCategory()!=null)
	{
			for (Category category : categoryList) {
				
					if(visit.getHin().getCategory().getCategoryid().equals(category.getCategoryid()))
					{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%} }
				}else{
		for (Category category : categoryList) {
			
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	
		}
				}	%>
</select>
	<div class="clear"></div>

	<label>Last AME </label>

	<label>Place</label> 
	<input type="text"	maxlength="100" value="" name="<%=LAST_AME%>" tabindex="1" />

	<label> Date</label>

	<input	tabindex="1" name="<%=DATE_OF_AME %>" readonly="readonly" class="date" value=""	validate="Last AME Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',opdMain.<%=DATE_OF_AME%>,event);" />

</div>
<div class="clear paddingTop15"></div>

<h4>Vitals</h4>
<div class="Block">

	<label class="">Weight</label>
	<input name="weight" tabindex="1" type="text" id="weight" value="" onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
	<label class="unit">kg</label> 

	<label  class="">Height</label> 
	<input name="height" tabindex="1" type="text" id="height" value="" class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5" validate="height,int,no"  maxlength="3" />
	<label class="unit">cm</label>

	<label	class="">BMI</label> 
	<input tabindex="1" type="text" id="bmi" name="bmi" readonly="readonly" maxlength="6" value="" onKeyUp="limitText(this,6);" class="auto" size="5" />
	<label class="unit">kg/m<sup>2</sup></label> 
  
  	<div class="clear"></div>
  	
	<label	class="">Ideal Weight</label>
 	<input name="idealWeight" type="text" id="idealWeightId" tabindex="1" class="auto" size="5" value="" tabindex="1" validate="Ideal Weight,string,no" maxlength="3" />
 	<label class="unit">kg</label> 
 
 	<label class="">Temperature</label>
 	<input name="temperature" id="tempId" type="text" validate="Temperature,int,no" tabindex="1" value="" class="auto" size="5" onblur="convertFarenhiteToCelcius();" maxlength="5" />
 	<label class="unit">&deg;F</label>
 	<label class="">Temperature</label>
 	<input name="temperature" id="tempInCelciusId"  type="text" tabindex="1" value="" class="auto" size="5" maxlength="5" onblur="convertCelciusToFarenhite();" />
  	<label class="unit">&deg;C</label>
   
   	<div class="clear"></div>
 	
 	<label	class="">Pulse</label>
 	<input name="pulse" type="text" tabindex="1" value="" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 	<label class="unit">/min</label> 
   
   
	<label class="">BP</label>
	<input	name="bp" id="bp" type="text" tabindex="1" value="" class="auto" size="5" onblur="if(this.value!=''){validateBpValue(this.value)};" maxlength="7" />
	<label class="unit">mm/Hg</label>
 
 	<label class="">RR</label>
 	<input	name="rr" id="rr" type="text" tabindex="1" value="" class="auto" size="5" maxlength="3" validate="RR,int,no"/>
 	<label class="unit">/min</label>

	<div class="clear"></div>
 
 	<label>On Examination</label>	
	<textarea name="onExamination" cols="120" rows="0" value="" maxlength="300" class="auto" tabindex="1"  onkeyup="return ismaxlength(this)"></textarea>

	<div class="clear"></div>

	<input type="hidden" name="userName" value="<%=userName %>" />
	
	<div class="clear"></div>

</div>
<div class="clear paddingTop15"></div>

<h4> Diagnosis </h4>
<div class="Block">

	<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
	<label>Working Diagnosis <span>*</span></label>
	<input type="text" class="auto"  id="initialDiagnosis" tabindex="1" value="" size="117"	name="initialDiagnosis" maxlength="100" onblur="populateClinicalNotes(this);" validate="Diagnosis,string,yes"/>

	<div class="clear"></div>

	<input type="hidden" name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" /> 

	<div class="clear"></div>

</div>

<div class="clear"></div>

<h4>Investigation</h4>

<div class="Block">
<label >Template</label>

<div id="investigationDiv">

<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" multiple="multiple" class="list" onblur="showHideInvestigationTemplateCombo();">
<option value="0">Select</option>
	<%
			   Iterator itr1=templateList.iterator();
			   while(itr1.hasNext())
			   {
				   OpdTemplate opdTemplate=(OpdTemplate)itr1.next();
				   String templateType=opdTemplate.getTemplateType();
				   if(templateType.equalsIgnoreCase("I"))
				   {
			%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>

<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>

<label>Urgent</label>
<input type="checkbox" name="urgent" tabindex="1" class="radioAuto" value="1" />
</div>

<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation </th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	<%	int inc=1;
 		String investigationName = "";
		if(patientInvestigationdetails != null){
		for (PatientInvestigationDetails patientInvestigation : patientInvestigationdetails) {
			investigationName = patientInvestigation.getChargeCode().getChargeCodeName()+ "["+ patientInvestigation.getChargeCode().getId()	+ "]";
	%> 
	<tr>
		<td>
			<input type="text" value="<%=investigationName %>" tabindex="1"	id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"	onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
			<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
		</script>
			<input type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"	size="10" readonly /> 
		</td>

		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>

		<td>
			<input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td>
			<input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %>
		
		<td>
			<input name="Button" type="button" class="buttonAdd" value=""	onclick="addRowForInvestigation();" /></td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>
	<%inc++;}%>
		<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
		<%}else{ %>
	<tr>
		<td>
			<input type="text" value="<%=investigationName %>" tabindex="1"	id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"	onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
			<div id="ac2update2" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
			</script>
			<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1" 	size="10" maxlength="6" validate="Qty,num,no" /> 
			
			<input type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly /> 

		</td>
	
		<td>
			<input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>
</table>
</div>

	<label>Other Investigation</label>
	<textarea name="otherInvestigation" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
	
	<div class="clear paddingTop15"></div>
	
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
		<th scope="col">Clinical Notes</th>

	</tr>
	<tr>
		<td>
			<input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="" size="98" maxlength="42" /></td>
	</tr>
</table>
</div>

<%
	if (patientPrescriptionHeader != null) {
			
%>
<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="cmntable">
<div class="Clear"></div>
<div id="testDivDrug">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th colspan="col">PVMS/NIV Nomenclature</th>
		<th colspan="1">Other Drug</th>
		<th scope="col">Unit</th>
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
		<th scope="col">CT</th>
		<th scope="col">Stock</th>

 <th scope="col">Add</th>
<th scope="col">Delete</th>
	</tr>


	<%
		int inc1 = 1;
				if (patientPrescriptionHeader.getPatientPrescriptionDetails() != null) {
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
	%>
	<tr>
		<td>
		<%
			MasStoreItem
			item = patientPrescriptionDetails
									.getItem();
							String itemName1 = item.getNomenclature() + "("+ item.getId() + ")" + "["+ item.getPvmsNo() + "]";
							String pvmsNo = "";
							pvmsNo = item.getPvmsNo();

							String dosage = patientPrescriptionDetails
									.getDosage();
							int noOfDays = patientPrescriptionDetails
									.getNoOfDays();
							int total = patientPrescriptionDetails.getTotal();
							String type = patientPrescriptionDetails.getType();
							int frequencyId = patientPrescriptionDetails
									.getFrequency().getId();
							String instruction = patientPrescriptionDetails
									.getInstruction();
							String remark = patientPrescriptionDetails
									.getRemarks();
							String au = patientPrescriptionDetails.getItem().getItemConversion().getItemUnitName();
							String route = patientPrescriptionDetails.getRoute();
		%> 
	    
			<input type="text" tabindex="1"	id="nomenclature<%=inc1 %>" size = "30" readonly="readonly" value="<%=itemName1%> "
			size="50" name="nomenclature<%=inc1%>"  onblur="disableOtherMedicine();"/>
			<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script>
			</td>
	
		<td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"   size="20"	 validate="Other Medicine,string,no" onblur="showSimilarMedicineNames(this.value);"/></td>

		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium" disabled="disabled"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%>
		</td>
<%if(au != null){ %>
		<td>
			<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=au %>" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
			<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		</td>
<%}else{ %>
		<td>
			<input type="text" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
			<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		</td>
<%} %>
		<td>
			<input type="hidden" name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" value="<%=pvmsNo%>" size="10" readonly="readonly" /><input type="text" name="dosage<%=inc%>" readonly="readonly"	id="dosage<%=inc%>" value="<%=dosage%>" size="5" tabindex="1" /></td>
		
			<td><select name="frequency<%=inc1%>" id="frequency<%=inc1%>" class="medium"  tabindex="1">
			<option value="0">Select</option>
			<%
				for (MasFrequency masFrequency : frequencyList) {
									int id = masFrequency.getId();
									String name = masFrequency.getFrequencyName();
			%>

			<option value="<%=id%>" <%=HMSUtil.isSelected(id, frequencyId)%>><%=name%></option>
			<%
				}
			%>
			</select> 
			<%
 					MasFrequency masFrequency = new MasFrequency();
 					for (int i = 0; i < frequencyList.size(); i++) 
 					{
 						masFrequency = (MasFrequency) frequencyList.get(i);
 			%>
 			<script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script>
            <%}%>
		</td>
		<%
        	if (patientPrescriptionDetails.getNoOfDays() != null) {
        %>
		<td>
		<input type="text" name="noOfDays<%=inc1%>" size="3"	tabindex="1" id="noOfDays<%=inc1%>" value="<%=noOfDays%>"	readonly="readonly" /></td>
		<%
		} else {
		%>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3" tabindex="1" id="noOfDays<%=inc1%>" value="" readonly="readonly" /></td>
		<%
		}
		%>
		<%if(route != null && !route.equals("")){ %>
		<td>
			<input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="<%=route %>"  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
		<%}else{ %>
		<td>
			<input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="PO"  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
		<%} %>
		<%
	 		 	if (patientPrescriptionDetails.getRemarks() != null) 
	 		 	{
		 %>
		<td>
		<input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>" size = "10"	value=<%=remark%> class="small" readonly="readonly" /></td>
		<%	} else {%>
		<td>
		<input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>"  size = "10"	value="" class="small" readonly="readonly" /></td>
		<%
		}
		%>
		<td>
			<input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td>
		<td>
			<input type="text" name="closingStock<%=inc1%>" disabled="disabled" tabindex="1" value="" id="closingStock<%=inc1%>"  size="3"  validate="closingStock,string,no" /></td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
		</td>
	</tr>
	<%
		inc1++;
					}
				}
	%>
	<input type="hidden" name="hdb" value="<%=inc1 - 1%>" id="hdb" />


</table>
<div class="Clear"></div>

</div>
</div>
<%
	} else {
			
%>
<div class="clear paddingTop15"></div>

<h4>Treatment</h4>

<div id="templateDivToShowHide" class="floatLeft">

<div class="Block">

<label>Template</label>
<div id="treatmentDiv">
<select name="templateId" id="templateId" tabindex="1" onchange="showHideDrugTemplateCombo(this.value);">
	<option value="0">Select</option>
	<%
	   Iterator itr=templateList.iterator();
	   while(itr.hasNext())
	   {
		   OpdTemplate opdTemplate=(OpdTemplate)itr.next();
		   String templateType=opdTemplate.getTemplateType();
		   if(templateType.equalsIgnoreCase("p"))
		   {
	%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%
		   }}%>
</select>
</div>


<div id="createPresDivToShowHide">
<input 	name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template"    class="buttonBig" onclick="showCreatePrescriptionTempate();" />
</div>
<div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
<input name="copyPrevPrescriptionTemplate" tabindex="1" type="button" value="Copy Previous" class="buttonBig"	onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>

<div id="prescriptionImportButton" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" />
</div>
</div>

<div id="testDiv">
<!--<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid1">
	<tr>
	<th scope="col">Remarks</th>

	<td><input type="text" name="remaks" tabindex="1"
			size="120" maxlength="45" /></td></tr>
	</table>
	-->
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>PVMS/NIV Nomenclature</th>
	    <th colspan="1">Other Drug</th>
		<th scope="col">Unit</th>
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
		<th scope="col">CT</th>
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="populatePVMS(this.value,'1');checkItem(1);disableOtherMedicine(this.value,'1');displayAu(this.value,'1');"  />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td>
		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%>
		</td>
		<td>
			<input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
			<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" />
		</td>
		
		<td>
			<input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
			<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1')" />
		</td>
		
		<td>
			<select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1')" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
			</select> 
		<%
	    		MasFrequency  masFrequency = new MasFrequency();
			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> 
     	<script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> 
         <% }%>
        	<input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
         	<input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue(this.value,'1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td>
			<input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')"  size="3"	maxlength="3" validate="No of Days,num,no" />
		</td>
		<td>
			<input type="text" name="route1" tabindex="1" id="route1" value="PO"  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td>
		<td>
			<input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
		</td>
			<td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td>
		<td>
			<input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" />
		</td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
		</td>
		
	</tr>
	
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>
</div>
</div>
<div class="clear"></div>
<div class="Block">
<label>Other Treatment</label>
<textarea name="otherTreatment" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
</div>
<%} %>
<div class="clear paddingTop15"></div>
<div class="Block">

<div class="clear"></div>


<label>Referred to MH</label>
<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="" onclick="checkReferToMh();"/>


<div id="mhDiv" style="display: none">
	<label>MH Name</label>
	<input name="mh" type="text" tabindex="1" maxlength="32" id="mh" size="20"  />

	<label>Department</label>
	<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20"  />
	
<div class="clear"></div>
	
	<label>Referred For</label>
	<input name="mhReferredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
	
</div>

<div class="clear"></div>
<div id="detentionDiv" style="display: none">
	<label> Review at</label> 
	<input	type="text" name="reviewAt" size="92" class="auto" id="reviewAtId" validate="Review at,string,no" value="" MAXLENGTH="200"   />
</div>
<div class="clear"></div>
</div>
<script>
	function checkReferToMh (){
	 if(document.getElementById('referedToMH').checked == true){
		 document.getElementById('mhDiv').style.display = 'block'
			 document.getElementById('disposalDiv').style.display = 'none'
	 }else{
		 document.getElementById('mhDiv').style.display = 'none'
		  document.getElementById('disposalDiv').style.display = 'inline'	
	 }
  }


function validateDays(){
	//alert(document.getElementById('disposal').value);
 var msg = "";
 if(document.getElementById('disposal')){
 var disposal = document.getElementById('disposal').value;
 if(document.getElementById('disposal')){
	// alert(disposal)
 if(disposal == 'Light duties' || disposal =='Sick in Quarters' || disposal =='Sick Leave' || disposal =='Excused Duty'  )
 {
	 document.getElementById('daysDiv').style.display = 'block';
	 if(document.getElementById('days').value == "")
		msg += "Please select the days.\n";
		
	 }else{
	 document.getElementById('daysDiv').style.display = 'none';
 }
 }
}
 if(msg!=''){
		alert(msg);
		return false;
	}
return true;	
	
}
function displayDetained(){
	if(document.getElementById('disposal')){
		 var disposal = document.getElementById('disposal').value;
		 if(disposal == 'Detained'){
			 document.getElementById('detentionDiv').style.display = 'block';
		 }else{
			 document.getElementById('detentionDiv').style.display = 'none';
		 }

	}
}


</script>
<!-- <input type="text" name="nextVisitDate"  class="calDate"/>
		<a href="#"><img src="images/cal.gif" alt="Calender" border="0" /></a>
		 -->
<div class="clear"></div>

<input id="visitId" name="visitId" type="hidden"	value="<%=visit.getId()%>" />
<input id="visitId1" name="<%=VISIT_ID %>" type="hidden"	value="<%=visit.getId()%>" />
<input name="hinId" type="hidden"	value="<%=visit.getHin().getId()%>" />
<%if(visit.getDepartment() != null){ %>
<input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}else{ %>
<input name="departmentId"	type="hidden" value="0" />
<%} %>
<input	name="hospitalId" type="hidden" value="<%=hospitalId%>" />
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<input name="deptId" type="hidden" value="<%=deptId%>" />

<input	name="<%=SERVICE_NO%>" type="hidden"	value="<%=visit.getHin().getServiceNo()%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input name="<%=HIN_NO%>" type="hidden"	value="<%=visit.getHin().getHinNo()%>" />
<input	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"	value="<%=consultationTime%>" />
<input name="relation" type="hidden" value="<%=visit.getHin().getRelation().getRelationName()%>" />
<%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%>
<div class="clear"></div>
<div class="division"></div>
<input name="Submit11" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitForm('opdMain','medicalExam?method=submitAFMSF7AJsp');" />
<input name="Reset" type="reset" tabindex="1" align="right"	class="button" value="Reset" onclick="resetdata()" />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<!--main content placeholder ends here--> <script type="text/javascript">
 /*
 // Both the methods merged in validate fiels
 // method for validating nxt visit date
	function validateDate() {
			//alert("---date--"+serverdate)
			var dateSelected=document.getElementById("nextVisitDate").value
			if(dateSelected != ""){

			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))

				if(visitDate<currentDate)
			    {
				document.getElementById("nextVisitDate").value="";
				alert("Please enter the correct Visit date.")
				return false;
			    }
		    }
		    return true;
		  }
	//method for checking diagnosis field
	var errorMsg="";
	function checkDiagnosis(){
	 //var validateDate=validateDate();

	 alert("----diagnosis length---")
	      if(document.getElementById('diagnosisId').length == 1)
	      {
	       alert("Please Enter the diagnosis of the Patient.\n");
	        return false;
	      }else{
	         return true;
	       }


    }
	*/
	function convertFarenhiteToCelcius(){
	   var strIn = document.getElementById('tempId').value;
		  if(isNaN(strIn) || strIn == '')
		  {
		    //alert("Not a Number");
		  }
		  else
		  {
		    var f = parseFloat(strIn);
		    var c = (f - 32) * 5/9;

		    var r = Math.round(c * 100)/100;
		    document.getElementById('tempInCelciusId').value = r.toString();   
		  }
		}
	function convertCelciusToFarenhite()
	{
        var strIn = document.getElementById('tempInCelciusId').value;
		  if(isNaN(strIn) || strIn == '')
		  {
		   // alert("Not a Number");
		  }
		  else
		  {
		    var c = parseFloat(strIn);
		    var f = (c * 9/5) + 32;
		
		    var r = Math.round(f * 100)/100;
		    document.getElementById('tempId').value = r.toString();   
		  }
		}


	
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode").focus();
	}

	function openPopupWindow()
	{
	 var url="/hms/hms/adt?method=showICDSearchJsp";
	 newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}


	function checkTemplateId(templateId){
		
      if(templateId=="0"){
        return true;
      }else{
        return true;
      }
    }


 function fillDiagnosisCombo(val) {

          
	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		   
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
                    var valu=obj.options[obj.length-1].value;
					var b="false";
					for(var i=1;i<obj.length;i++){
							    
		                    	var val1=obj.options[i].value;
		                    	var length=obj.length-1;
                                	
		                    	if(id==val1)
		                    	{
		                        	alert("ICD  Already taken");
		                        	document.getElementById('icd').value =""
		                        	b=true;
		                       	}
		                              	
		                    }
                    
		                    if(b=="false")
		                    {
		                    	obj.length++;
		    					obj.options[obj.length-1].value=id
		    					obj.options[obj.length-1].text=val
		    					obj.options[obj.length-1].selected=true
		    					document.getElementById('icd').value =""
		    			                    
		                    }
				}
	  }
 

  function validateBpValue(obj){
	var bpObj = document.getElementById('bp');
	 var bool =validateBpWithSlash(obj)
	if(bool)
	{

	if(obj != ""){
	var index=obj.indexOf('/');
	//if(index != 2){
	//	 alert("BP should be in min/max Format.")
	//	 bpObj.value="";
	//	 bpObj.focus();
	//	 return false;
	//	 }
		 var pairs2 = obj.substring(0,obj.length).split('/');
		 if (pairs2.length!=2) {
			 alert("Invalid  Format.BP should be in min/max Format.")
			return false;
			}
		val2=eval(pairs2[0]);
		 if (val2<60 ) {
		  alert("Minimum BP should be greater than 60.")
		  return false;}

		 val3=eval(pairs2[1]);
         if (val3>240) {
		  alert("Maximum BP should be less than 240.")
		 return false;}

	}
	return true;
	}
	bpObj.value="";
	bpObj.focus();
	return false;
	}
	function validateBpWithSlash(strValue){
		if(strValue != ""){
		var objRegExp = /^(\d{1,}[\/]\d*)$/
		obj =  objRegExp.test(strValue);
		if(!obj){
			alert("BP should be in min/max Format.");
			return false;
		}
		return true;
	  }
	}

	function validateTemp( strValue ) {
 			 var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 			return objRegExp.test(strValue);
		}

	function addRow(){
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 

	e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);disableOtherMedicine(this.value,iteration);displayAu(this.value,iteration);
						   }
	  					  };
	  
	var newdiv = document.createElement('div');
        	//newdiv.setAttribute('id', 'ac2update'+iteration);
        	//newdiv.setAttribute('class', 'autocomplete');
       	   newdiv.id='ac2update'+iteration;
       	   newdiv.className='autocomplete';
         	newdiv.style.display = 'none';
  e0.size = '30';
	//  alert("3-1--");
	  e0.setAttribute('tabindex','1');
	//  alert("3-2--");
	  cellRight0.appendChild(newdiv);
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
 //alert("4---");
	   <%--  var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26';
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);--%>
	//  alert("5---");
	
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<unitArray.length;i++ ){
	      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
	      }
	  cellRight2.appendChild(e12);

	  var cellRight3 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='au'+iteration;
	  e13.id='au'+iteration
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);

	 
	  cellRight3.appendChild(e1);
	  
	  
	 /* var cellRight3 = row.insertCell(3);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight4 = row.insertCell(4);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(5);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(this.value,iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(this.value,iteration)};
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);

	  /*
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');

	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.classname='smalllabel';
	  e6.setAttribute('tabindex','1');
	  e6.options[0] = new Option('Select', '');
	  e6.options[1] = new Option('AC', 'AC');
	  e6.options[2] = new Option('PC', 'PC',true);
	  cellRight6.appendChild(e6);


	  var cellRight7 = row.insertCell(7);
	   var e7 = document.createElement('Select');

	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.classname='smalllabel';
	  e7.setAttribute('tabindex','1');
	   e7.options[0] = new Option('Select', '');
	   e7.options[1] = new Option('Left', 'left');
	   e7.options[2] = new Option('Right', 'right');
	   cellRight7.appendChild(e7);
*/

	//	var cellRight7 = row.insertCell(7);
		
		

		var cellRight8 = row.insertCell(7);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value='PO'
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6);

	  var cellRight9 = row.insertCell(8);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

	  var cellRight10 = row.insertCell(9);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight10.appendChild(e71);

	  var cellRight11 = row.insertCell(10);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(11);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(12);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
   //   var e9 = document.createElement('input');
 //     e9.id = 'a'
 //     e9.type = 'checkbox';
  //    cellRight9.appendChild(e9);

	}

	<%-- function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }
	} --%>

	function removeRow(idName,countId,obj)
	{
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
	}

	function populateClinicalNotes(obj){
		var objValue = obj.value;
		if(obj.id == 'initialDiagnosis'){
			document.getElementById('clinicalNotes').value = objValue;
		}
	}



	
	function populatePVMS(val,inc){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)



	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo'+inc).value=pvmsNo


	 }
	}
	

	function disableOtherMedicine(val,inc){
	  if(val != "")
		{
	   document.getElementById('otherMedicine'+inc).disabled = true;		
	   document.getElementById('otherMedicine'+inc).value ="";
	   document.getElementById('itemConversionId'+inc).disabled = true;
	   document.getElementById('itemConversionId'+inc).value = "";
	   //document.getElementById('injCategory'+inc).disabled = true;	
	   
		}else{
			document.getElementById('otherMedicine'+inc).disabled = false;
			document.getElementById('itemConversionId'+inc).disabled = false;
			//document.getElementById('injCategory'+inc).disabled = false;	

		}
	}
	function readOnlyNomenclature(val,inc){
	if(val != ""){
		//alert("Please confirm PVMS/NIV is not available");
		 document.getElementById('nomenclature'+inc).readOnly = true;
		 document.getElementById('au'+inc).readOnly = true;				
	     document.getElementById('nomenclature'+inc).value ="";
	     if(document.getElementById('itemId'+inc)){
	    	 document.getElementById('pvmsNo'+inc).value = "";
	     }
	  }else{
		document.getElementById('nomenclature'+inc).readOnly = false;
		 document.getElementById('au'+inc).readOnly = false;			

	  }
   }

	function displaySOSQty(val,inc){
		
	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
	 }else{
	
	 document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	 }
	}
	
	function getFrequencyValue(feqValue,inc){
		var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFeq()%>'
		
	  }

	<%}
	}%>
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	
	 function  fillValue(value,inc){
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*value*dosage;
	  var finalQty;
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			  document.getElementById('total'+inc).value=freq*value*dosage
		  }
	 //	document.getElementById('noOfDays'+inc).disabled = false;
	// 	document.getElementById('sosQty'+inc).disabled = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				  document.getElementById('total'+inc).value=freq*sosQty*dosage
			  }
	//	   document.getElementById('noOfDays'+inc).disabled = true;
	//	   document.getElementById('sosQty'+inc).disabled = false;

	  }
	  
	 }

	 function  fillValueFromFrequency(value,inc){
   	  var dosage = document.getElementById('dosage'+inc).value
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
   	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
	
		 }else{
			 
			  document.getElementById('total'+inc).value=noOfDays*freq*dosage
		  }
	 // document.getElementById('noOfDays'+inc).readOnly = false;
	 // document.getElementById('sosQty'+inc).readOnly = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
		
			 }else{
				  document.getElementById('total'+inc).value=sosQty*freq*dosage
			  }
		//  alert(document.getElementById('noOfDays'+inc).readOnly);
		 // document.getElementById('noOfDays'+inc).readOnly = true;
		 // document.getElementById('sosQty'+inc).readOnly = false;
	  }
	 }

	 function addRowForInvestigation(){
      
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
     
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update'+iteration;
	  newdiv1.className='autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	  
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'checkbox';
	  e3.name='referToMh'+iteration;
	  e3.id='referToMhId'+iteration
	  e3.size='10';
	  e3.className='radio';
	  e3.value='y';
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	 var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation();}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  //e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
	  cellRight3.appendChild(e5);
	  
	   //fayaz removed
	  //var cellRight3 = row.insertCell(1);
	 // var e3 = document.createElement('input');
	 // e3.type = 'text';
	 // e3.name='clinicalNotes'+iteration;
	 // e3.id='clinicalNotes'+iteration;
	 // e3.setAttribute('tabindex','1');
	 // e3.size='60'
	 // cellRight3.appendChild(e3);

	}
</script> 
<script type="text/javascript">
		function openPopupForPatientPrescription(visitNo,hinId,deptId,visitId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId+"&deptId="+deptId+"&visitId="+visitId;
        newwindow=window.open(url,'name',"height=300,top=0,width=1010,status=1");
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function submitDetails(){

		
        document.opdMain.action="hms/hms/opd?method=submitOPDPatientDetails";
        document.opdMain.submit();
        document.opdMain.action="opd?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.opdMain.submit();
		

     }

     

     function openPopupForPatientInvestigation(visitNo,hinId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
        newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
        }else{
          alert("This is Patient's First Visit. ")
        }
     }
	function getDoctorList(){
		document.getElementById("referredDoctarsId").options.length=0;
		var combo=document.getElementById("referredDepartmentId");
		var x=0;
		var a="";
		var indexes = new Array();
		for(x=0;x<combo.options.length;x++) {
			if (combo.options[x].selected) {
				a=combo.options[x].value;
				indexes.push(a);
			}
		}
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
		//submitProtoAjaxforOpdMain('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'');
	}


  function showCreatePrescriptionTempate(){
        
  		document.getElementById('prescriptionImportButton').style.display = 'inline';
	   	var url="/hms/hms/opd?method=showCreatePrescriptionTempate";
	    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
	   
	     }

  function copyPrevPrescriptionTempate(visitNo,hinId){
   		document.getElementById('templateDivToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivToShowHide').style.display = 'none';
   		document.getElementById('createPresDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousPrescriptionForCopy&&visitNo='+visitNo+'&hinId='+hinId,'testDiv');
  }

  function copyPrevInvestigationTempate(visitNo,hinId){
   		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
  }

  function showCreateInvestigationTemplate(){
     
	     document.getElementById("investigationImportButton1").style.display='inline'
	   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
	    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
	   

  }


 function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
//	document.getElementById('prescriptionImportButton').style.display = 'none';
//	document.getElementById("investigationImportButton").style.display='none'
 }


	function fillChargeCodeId(val){
		//alert("in method--")

		if(val != "") {
		    var index1 = val.lastIndexOf("[");
		    var indexForChargeCode=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var chargeCodeId = val.substring(index1,index2);
		    var indexForChargeCode=indexForChargeCode--;
		    var chargeCodeName=val.substring(0,indexForChargeCode);
			if(chargeCodeId == "") {
		   		document.getElementById('chargeCodeName1').value="";
		    	document.getElementById('chargeCodeId').value="";
		   		return;
		   	} else {
	   		      document.getElementById('chargeCodeId').value=chargeCodeId;
	      	}
	 	}
	}
	function showHideDrugTemplateCombo(valueOfTemplate){
		if(checkTemplateId(valueOfTemplate)){
		  	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';

			submitProtoAjax('opdMain','/hms/hms/opd?method=showGridInMainJsp','testDiv');
		}
	}
	function showHideInvestigationTemplateCombo(){
		var invId="";
		var sel = document.getElementById("investigationTemplateId");
		var listLength = sel.options.length;
		//alert("listLength--->"+listLength);
		
		for(var i=0;i<listLength;i++){
		   if(sel.options[i].selected){
				if(invId!=""){
					invId=invId+","+sel.options[i].value;
					}else{
						invId=sel.options[i].value;
				}
				
		   }
		}
			//alert("invId==="+invId);
		//if(checkTemplateId(valueOfTemplate)){
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';//'+invId
submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
				
				}
	//}
	function validateFrequency(){
		var count = document.getElementById('hdb').value;
		for(var i = 1; i <= count;i++){
			//var nomenclature = document.getElementById('nomenclature'+i).value;
			if(document.getElementById('nomenclature'+i)){
			if(document.getElementById('nomenclature'+i).value != ''){
				if(document.getElementById('frequency'+i)){
				if(document.getElementById('frequency'+i).value == '0'){
					alert('Please select frequency.');
					return false;
				  }
				 }
				if(document.getElementById('frequency'+i).value != '13'){
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value == ''){
					alert('Please Enter No. of Days.');
					return false;
				 }
				 }
				}else{
					if(document.getElementById('sosQty'+i)){
						if(document.getElementById('sosQty'+i).value == ''){
							alert('Please Enter SOS Qty.');
							return false;
						 }
						 }
				
				}
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value!="")
				{
				if( isNaN(document.getElementById('noOfDays'+i).value))
		    	{
		        	alert("No. of Days should be a number");
		        	return false;
		    	 }
				 }
			   }

			}
			
			
		 }
		}
		return true;
	}

	function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
	
	var referedToMH =document.getElementById('referedToMH').value;
	if(confirm("Do You want to submit the Record!?")){
	 if(document.getElementById('referedToMH').checked == true){
			if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=y&flag=opd');
		}
	 }else{
		 if(validateFrequency() && validateDays()){
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=n&flag=opd');
		}
	 }
		return true;
	}else{
		return false;
	}
	 
	}
	function deleteDgItems(value){
     if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
     }
    function showTreatment()
    {
    	
    		   	var url="/hms/hms/opd?method=showTreatmentPopUp&flag=opd";
    		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
   

  
    function resetdata()
    {
       
        document.opdMain.action="/hms/hms/opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>";
        document.opdMain.submit();
       
    }
    
      
        function showSimilarMedicineNames(otherDrug){
        	newwindow=window.open('/hms/hms/opd?method=showRelatedMedicineNames&otherDrug='+otherDrug,'name',"left=2,top=100,height=300,width=800,status=1,scrollbars=1,resizable=0");
        }
</script>
</form>


