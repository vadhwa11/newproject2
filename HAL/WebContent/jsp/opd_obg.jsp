

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script
	type="text/javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
	
	//var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	//var IMGDIR_MISC = "images/misc";
	//var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
        List patientDataList = new ArrayList();
    	String patientTypeNameForHAL = null;
    	String patientTypeNameForOther = null;
        String empTypeCodeForContract = null;
		String servicePersionName="";
		String patientName="";
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");

		int visitCount=0;
		if(map.get("visitCount") != null){
			visitCount=(Integer)map.get("visitCount");

			}	
		if(map.get("patientDataList") != null){
			patientDataList=(List)map.get("patientDataList");
		}
		Visit visit=(Visit)patientDataList.get(0);
	    String referral_other_patient =null;
   		if(visit.getHin().getPatientType().getPatientTypeName()!=null)
			{
			
				 if(visit.getHin().getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
				{
					if(visit.getHin().getBillable().equals("y"))
						referral_other_patient ="n";
					else if(visit.getHin().getBillable().equals("n"))
						referral_other_patient ="y";
				}
			}
    		
    		List<OpdPatientDetails> admittedVisit = new ArrayList<OpdPatientDetails>();
    		
    if(map.get("admittedVisit") != null){
    	admittedVisit = (List<OpdPatientDetails>) map.get("admittedVisit");
    	
    			}
	List<MasEmployeeDependent> med = null;
	if(map.get("med") != null){
		med = (List<MasEmployeeDependent>) map.get("med");
    			}
	String familyHistoryCode = null;
	  familyHistoryCode =HMSUtil.getProperties("adt.properties", "templateCodeForFamilyHistory");
	  
	  List templateList= new ArrayList();
		if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
		}
%>

<div class="Clear"></div>


<div class="clear"></div>
	<div class="titleBg">
		<h2>OPD- OBG</h2>
	</div>
	<div class="Block">
	  		<% 
	  		if(visit.getHin().getPFirstName()!= null){
	  			patientName=visit.getHin().getPFirstName();
	  			}
if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getNewRelationName().equalsIgnoreCase("Self"))
{ 
%>

		<div class="photoDivLeft">
			<label>Employee No.</label>
			<%if(visit.getHin().getServiceNo()!= null){ %>
			<label class="value"><%=visit.getHin().getServiceNo() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
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
					}%>
			<label class="value" style="min-width: 147px; width: auto;"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label>
			<%}}else{ %>
			<label class="value"></label>
			<%} %>
			<div class="clear"></div>
			<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Designation</label>
			<%if(visit.getHin().getRank()!= null){ %>
			<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
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
					}%>
			<label class="value"><%=patientName %></label>
			<%} %>
			<label>Age</label>
			<%if(visit.getHin().getAge()!= null){ %>
			<label class="value"><%=visit.getHin().getAge() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<%if(visit.getHin().getAge()!= null){ %>
			<input type="hidden" name="ageId" id="ageId"
				value="<%=visit.getHin().getAge() %>">
			<%} %>
			<div class="clear"></div>
			<label>Gender</label>
			<%if(visit.getHin().getSex() != null){ %>
			<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
			<input type="hidden" name="genderId" id="genderId"
				value="<%=visit.getHin().getSex().getId() %>">
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Marital Status</label>
			<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
			<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
			<label>Blood Group</label>
			<%
if(visit.getHin().getBloodGroup() != null ){ %>
			<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>
			<div class="clear"></div>
			<div class="clear"></div>
			<label>Allergy</label>
			<%if(visit.getHin().getDrugAllergies() != null){ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="<%=visit.getHin().getDrugAllergies() %>" maxlength="77"
				id="allergies" size="77" />
			<%}else{ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="" maxlength="100" id="allergies" size="77" />
			<%} %>
			<div class="clear"></div>
		
		</div>
		<div class="photoImageDiv">
		
		<% 
		System.out.println(visit.getHin().getPatientType().getPatientTypeCode() +" xf");
		  if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL))
		  {
		%>	
		  <img
				src="/hms/hms/personnel?method=displayImage&amp;employeeId=<%=visit.getHin().getEmployee().getId()%>"
				width="105" height="112">  
		 <% }
		  else
		  {
	%>		   
	 <img
				src="/hms/jsp/images/photo_icon.png"
				width="105" height="112">  
	<%	  }
		%>
			
		</div>
		<% }else{ %>
		<div class="photoDivLeft">
			<label>Employee No.</label>
			<%if(visit.getHin().getServiceNo()!= null){ %>
			<label class="value"><%=visit.getHin().getServiceNo() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
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
					}
					servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
					}%>
			<label class="value" style="min-width: 147px; width: auto;"><%=patientName %></label>
			<%} %>
			<div class="clear"></div>
			<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Designation</label>
			<%if(visit.getHin().getRank()!= null){ %>
			<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
			<%}else{ %>
			<label class="value"></label>
			<%} %>
			<div class="clear"></div>
			<label>Name</label> <label class="value"><%=servicePersionName %></label>

			<label>Age</label>
			<%if(visit.getHin().getAge()!= null){ %>
			<label class="value"><%=visit.getHin().getAge()%></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
			<label>Gender</label>
			<%if(visit.getHin().getSex() != null){ %>
			<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
			<input type="hidden" name="genderId" id="genderId"
				value="<%=visit.getHin().getSex().getId() %>">
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Marital Status</label>
			<%if(visit.getHin().getMaritalStatus() != null){ %>
			<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
			<label>Blood Group</label>
			<%if(visit.getHin().getBloodGroup() != null){ %>
			<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>
			<div class="clear"></div>
			<div class="clear"></div>
			<label>Allergy</label>
			<%if(visit.getHin().getDrugAllergies() != null){ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="<%=visit.getHin().getDrugAllergies() %>" maxlength="91"
				id="allergies" size="77" />
			<%}else{ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="" maxlength="100" id="allergies" size="77" />
			<%} %>
		</div>

		<%
for(MasEmployeeDependent dependent :med)
{
	  if(dependent.getRelation().getId() == visit.getHin().getRelation().getId())
	  {
	%>
		<div class="photoImageDiv">
			<img
				src="/hms/hms/personnel?method=displayImageEmployeeDependent&amp;employeeDependentId=<%=dependent.getId()%>"
				width="105" height="112">
		</div>
		<%break; }
}
		}
%>
	</div>
	
	<div class="arrowlistmenu">
		<ul class="categoryitems">
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
					Previous Visits </a> </li>
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
					Previous Hospitalizations</a> 
			</li>
			<li>
				 <a href="#"
				onclick="javascript:openPopupInvestigation(<%=visit.getHin().getId()%>)">
					Previous Lab Investigations</a></li>
					<%String hinNo =visit.getHin().getHinNo();
					   if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
						   hinNo =hinNo.substring(1, hinNo.length());
					%>
			<li><a href="#"
				onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">
					Previous Radiology Investigations</a></li>
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Upload
					Documents </a></li>
 		  </ul>
		</div>
		
		<form>
		<div class="opdArea">
		<div class="floatLeft">
		<label>Other Complaints</label><textarea name="other_complaint" cols="0" rows="0" maxlength="300"></textarea>
		<div class="Clear"></div><div class="Clear"></div>
		<label>HOPI</label><textarea name="hopi" cols="0" rows="0" maxlength="300"></textarea>
		 <label>Family Present History</label>
		 <textarea class="opdMainTextArea yellowBackground" name="familyHistory" validate="Family History,string,no" id="familyHistory" cols="0" rows="0" maxlength="500" tabindex="8"></textarea>
			<input type="button" class="buttonAuto-buttn" id="" name="" value="+" onclick="getFamilyHistoryTemplate('<%=familyHistoryCode%>');" tabindex="9" />
		</div>
		</div>
		<div class="Clear"></div><div class="Clear"></div>
		<div class="Block"> 
	     
	     <label> Obestrtic History</label> 	<select><option value="">Select</option><option>Primigravida</option><option>Multigravida</option></select>
	     <label>Obstetric Score G</label><select name="obstetric_score_g"><option value=""></option>
	        <%for(int i=0;i<=9;i++){ %>
	       <option><%=i%></option>
	       <%} %>
	     </select>
	       <label>Obstetric Score P</label><select name="obstetric_score_p"><option value=""></option>
	        <%for(int i=0;i<=9;i++){ %>
	       <option><%=i%></option>
	       <%} %>
	     </select>
	       <label>Obstetric Score A</label><select name="obstetric_score_a"><option value=""></option>
	        <%for(int i=0;i<=9;i++){ %>
	       <option><%=i%></option>
	       <%} %>
	     </select>
	       <label>Obstetric Score L</label><select name="obstetric_score_l"><option value=""></option>
	        <%for(int i=0;i<=9;i++){ %>
	       <option><%=i%></option>
	       <%} %>
	     </select>
	     <label>Conception</label><select><option value=""></option><option>Sponta-Neous</option><option>Assisted-OI/IU</option><option></option></select><div class="Clear"></div>
	     <label>Married Life</label><input type="text" name="total_marriage_year">
	     <label>Consan Guinity</label><select><option value=""></option><option>I</option><option>II</option><option>III</option></select>
	     <label>Booked</label><select><option value=""></option><option>Yes</option><option>No</option></select><div class="Clear"></div>
	 	 <label>Immunised</label><select><option value=""></option><option>Yes</option><option>No</option></select>
	 	 <label>I,II,III Trimisters</label><select><option value=""></option><option>EventFul</option><option>UneventFul</option></select>
	      <label>Specify</label> <textarea rows="" cols="" maxlength="200"></textarea><div class="Clear"></div>
	      
	      <h4>Menstrual History</h4>
	      <label>Age of Menarche</label><select name=""><option value="">Select</option>
	       <%for(int i=9;i<=70;i++){ %>
	       <option><%=i%></option>
	       <%} %>
	       </select>
	      <label>Cycles</label><select name=""><option value="">Select</option><option>Regular</option><option>Irregular</option></select>
	      <label>Range</label><select name=""><option value="">Select</option>  <%for(int i=9;i<=70;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	      <label>Flow</label><select name=""><option value="">Select</option>  <%for(int i=1;i<=30;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	    <div class="Clear"></div><div class="Clear"></div>
	      <h4>General Physical Examination</h4><div class="Clear"></div>
	          <label></label><select name=""><option value="">Select</option><option></option><option></option></select>  
	       <h4>Systemie Examination</h4>
	         <label>Respiratory System</label><select name="respiratory_system"><option value="">Select</option><option>Velicular</option><option>Bronchial</option></select>
	         <label>Breath sounds</label><select name=""><option value="">Select</option><option>Crept</option><option>Rhonchi</option></select>
	       
	          <h4>Cardiovascular System </h4>
	           <label>S1</label><select name=""><option value="">Select</option><option>Normal</option><option>Ab(n)</option></select>
	           <label>S2</label><select name=""><option value="">Select</option><option>Normal</option><option>Ab(n)</option></select>
	           <label></label><input type="text" name="" maxlength="50">
	           
	           	     <div class="Clear"></div><div class="Clear"></div> <div class="Clear"></div><div class="Clear"></div>
	         <h4>Per Abdomen Examination</h4>	   
	           <div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
	           <label>Inspection-Height of Uterus</label><select name=""><option value="">Select</option><%for(int i=12;i<=40;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	    
	           <label>Palpation-Lower Pole</label><select name=""><option value="">Select</option><option>Head</option><option>breech</option></select>
	           <label>Lateral grip:Back</label><select name=""><option value="">Select</option><option>Left</option><option>Right</option><option>Others</option></select><div class="Clear"></div>
	           <label>Auscultation : Fatal Heart Rate</label><select name=""><option value="">Select</option><%for(int i=90;i<=100;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	           <label>Absent</label><input type="text" name="" maxlength="15">
	           
	          <h4>Per Vaginal Examination</h4>
	          <label>OS Dilatation of cervix</label><select name=""><option value="">Select</option><%for(int i=0;i<=10;i++){ %>
	       <option><%=i%></option>
	       <%} %></select> (CM)
	          <label>Effacement of cervix</label><select name=""><option value="">Select</option><option></option><option></option></select>
	          <label>membrane</label><select name=""><option value="">Select</option><option>Intact</option><option>Ruptured</option></select>
	          <label>liquor</label><select name=""><option value="">Select</option><option>Clear</option><option>Blood Tinged</option><option>Melonium</option></select>
	          <label>Consistency od cervix</label><select name=""><option value="">Select</option><option>Soft</option><option>Medium</option><option>Hard</option></select>
	          <label>Position of cervix</label><select name=""><option value="">Select</option><option>anterior</option><option>MIO</option><option>posterior</option></select>
	          <label>Length of cervix</label><select name=""><option value="">Select</option>
	          	          <%for(int i=0;i<=4;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	          <label>Station of Presenting Part</label><select name=""><option value="">Select</option>
	          <%for(int i=-3;i<=3;i++){ %>
	       <option><%=i%></option>
	       <%} %></select>
	          <label>Head</label><select name=""><option value="">Select</option><option>Mobile</option><option>Fixed</option></select><div class="Clear"></div>
	          <label>Pelvis</label><select name=""><option value="">Select</option><option>Adevate</option><option>contracted</option></select>
</div>
			<h4>Investigation</h4>
	<div class="Block">
<label>Template</label>
		<div id="investigationDiv">
			<select name="investigationTemplateId" id="investigationTemplateId"
				tabindex="1" multiple="multiple" class="list"
				onblur="showHideInvestigationTemplateCombo();">
				<%-- <select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">--%>
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
				<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
				<%
		   }
	      }

		%>

			</select>
		</div>
		<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" /> --%>
		<div id="createInvestigationDivToShowHide">
			<input name="investigationTemplate" type="button"
				value="Create Template" tabindex="1" class="buttonBig"
				onclick="showCreateInvestigationTemplate();" />
		</div>
		<div id="copyPrevInvestigationTemplateDiv" style="display: none">
			<input name="copyPrevInvestigationTemplate" tabindex="1"
				type="button" value="Copy Previous" class="buttonBig"
				onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv');" />
		</div>
   	<div class="clear"></div>
   	<div id="gridview">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="investigationGrid">
				<tr>
					<td colspan="3">
						<div class="floatleft">
							<input type="radio" value="Lab" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck"
								checked="checked" onchange="" />
							<div class="labRadiologyDivfixed">LAB</div>
							<input type="radio" value="Radio" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck" onchange="" />
							<div class="labRadiologyDivfixed">Radiology</div>
							<input type="hidden" name="investigationCategory"
								id="investigationCategory" />
							<div class="clear"></div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="col">Investigation</th>
					<!-- <th scope="col">Refer to MH</th> -->
					<th scope="col">Add</th>
					<th scope="col">Delete</th>
				</tr>


				<%int inc=1;
			String investigationName = "";
	%>

				<tr>
					<td><input type="text" value="<%=investigationName %>"
						tabindex="1" id="chargeCodeName<%=inc %>" size="100"
						name="chargeCodeName<%=inc %>"
						onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
						<input type="hidden" tabindex="1" id="chargeCode<%=inc %>"
						name="chargeCode<%=inc %>" size="10" readonly /> 
						<div id="ac2update2" style="display: none;" class="autocomplete"></div>
						<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%> <script type="text/javascript" language="javascript"
							charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" /> <input
						type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
						size="10" readonly /> 
					</td>
					<td><input name="Button" type="button" class="buttonAdd"
						value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>

				<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

			


			</table>
		</div>	
	<input id="visitId" name="visitId" type="hidden"
		value="<%=visit.getId()%>"/>
</div>
	<div class="clear"></div>
	<div class="division"></div>
	<input name="Submit11" type="button" tabindex="1" align="right"
		class="button" value="Submit" onclick="submitOPDMainForm();" /> <input
		name="Reset" type="reset" tabindex="1" align="right" class="button"
		value="Reset" onclick="resetdata()" />
</form>

