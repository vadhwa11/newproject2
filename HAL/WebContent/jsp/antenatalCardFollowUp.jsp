

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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

<script type="text/javascript" language="javascript">
function addMonths()
{
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
      v.setMonth(v.getMonth() + 9);
       v.setDate(v.getDate() + 7);
      var curr_date = v.getDate();
      
      var curr_month = v.getMonth();
      
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = curr_month+1;
       			mth = "0"+mth;
           			
       		}
       		else
       		{
       			mth = curr_month+1;
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
	else
	{
	  document.getElementById('eddId').value="";
	}
}
function setFocusLmp()
{
	  document.gravidagramGestationalDiabitiesOne.<%=LMP%>.focus();
}
function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP")
	  return false;
	}
	else
	{
	return true;
	}
}	

</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<Visit>fwcPatientDataList = new ArrayList<Visit>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>(); 
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	if(map.get("fwcPatientDataList") != null){
		fwcPatientDataList=(List)map.get("fwcPatientDataList");
	}
	List<OpdPatientDetails>opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
	
	if(map.get("opdPatientDetailsList") != null){
		opdPatientDetailsList=(List)map.get("opdPatientDetailsList");
	}
	System.out.println("opdPatientDetailsList-->"+opdPatientDetailsList.size());
	
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
	}
	if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
	}
	if(map.get("disposalList") != null){
		disposalList=(List)map.get("disposalList");
	}
	if(map.get("patientFamilyHistoryList") != null){
		patientFamilyHistoryList=(List)map.get("patientFamilyHistoryList");
	}
	
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String patientName="";
	Patient patient = new Patient();
	String servicePersionName="";
	Visit visit = new Visit();
	
	if(fwcPatientDataList.size()>0){
	 visit=(Visit)fwcPatientDataList.get(0);
	 patient = (Patient)visit.getHin();
	if(patient.getPFirstName()!= null){
	patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
	patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
	patientName=patientName+" "+patient.getPLastName();
	}
	if(patient.getSFirstName()!= null){
	 servicePersionName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSLastName();
	}
}
	Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
	if(visit.getHin().getMasMedicalExamFamilyHis() !=null){
		familyHisSet  = visit.getHin().getMasMedicalExamFamilyHis() ;
	}
%>
<!--main content placeholder starts here-->
<form name="antenatalCard" action="" method="post">
<script type="text/javascript">
	   var icdArray=new Array();

	</script>
<div class="titleBg">
<h2>ANTENATAL CARD FOLLOW UP</h2>
</div>

<div class="clear"></div>

<h4>PATIENT DETAILS</h4>
<div class="clear"></div>
<div class="Block">

<label>Service No.</label>
 
<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>
 
<label>Patient Name</label> 
 <label class="value"><%=patientName %></label>
<label>Relation</label>
 
<label class="value"><%=patient.getRelation()!=null ?patient.getRelation().getRelationName(): ""  %></label>
 

<div class="clear"></div>
<label>Rank</label>

<label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>


<label>Name</label> 
 <label class="value"><%=servicePersionName %></label>


<label>Trade/Branch</label>
 
<label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<div class="clear"></div>
<label>Unit</label>
 
<label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>


<label>Age</label> 

<label class="value"><%=patient.getAge()!= null?patient.getAge():"" %></label> 


<input type="hidden" value="37 Years" id="ageId" name="ageId">

 <label>Gender</label>
 
<label class="value"><%=patient.getSex()!= null?patient.getSex().getAdministrativeSexName():"" %></label>
<input type="hidden" value="2" id="genderId" name="genderId">


<div class="clear"></div>

<label>Marital Status</label> 

<label class="value"><%=patient.getMaritalStatus()!= null?patient.getMaritalStatus().getMaritalStatusName():"" %></label> 
 

<label>Blood Group</label>

<label class="value"><%=patient.getBloodGroup()!= null?patient.getBloodGroup().getBloodGroupName():"" %></label> 

<label>Blood Group(Spouse)</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

 <label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="91" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="100" id="allergies" size="92"  />
<%} %>


<label>Risk Factors</label> 
<input type="text" name="riskFactors" tabindex="1" class="auto" value="" maxlength="100" id="riskFactors" size="59">
<div class="clear"></div>
<input type="hidden" name="visitId" value="<%=visit.getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
<input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="hidden" value="<%=visit.getHin().getServiceNo()%>" />
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input name="<%=HIN_NO%>" type="hidden"	value="<%=visit.getHin().getHinNo()%>" />
<input name="<%=SERVICE_TYPE_NAME%>" type="hidden"	value="<%=visit.getHin().getServiceType().getServiceTypeName()%>" />

 
<div class="clear"></div>
</div>



<div class="clear"></div>

<input	name="investigationTemplate" type="button"	value="Initial Visit" tabindex="1" class="buttonBig" 
onclick="openPopupANCINITIALVisit();" />


<input	name="investigationTemplate" type="button"	value="ULTRASONO GRAPHY" tabindex="1" class="buttonBig" 
onclick="openPopupULTRASONOGRAPHY();" />


<input	name="investigationTemplate" type="button"	value="Other Investigrations" tabindex="1" class="buttonBig" onclick="openPopupOtherInvestigation();" />


<input	name="investigationTemplate" type="button"	value="Case Sheet" tabindex="1" class="buttonBig" 
onclick="caseSheet(<%=visit.getId() %>,<%=patient.getId() %>,'fp');" />

<input type="button" class="buttonBig" value="Immunization" onclick="openPopupForImmunization(<%=patient.getId() %>,'fp');" tabindex="1">



<div class="clear"></div>

<div class="clear"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="ancGrid">
	<tr>
		<TH scope="col" rowspan="2">Date</th>
		<TH scope="col" rowspan="2">POG</th>
		<TH scope="col" rowspan="2">Weight</th>
		<TH scope="col" rowspan="2">BP mm Hg</th>
		<TH scope="col" rowspan="2">Fundal</th>
		<TH scope="col" rowspan="2">Presentation/Position</th>
		<TH scope="col" rowspan="2">Foetal Head engaged or not</th>
		<TH scope="col" rowspan="2">Foetal Heart</th>
		<TH scope="col" rowspan="2">Pallor</th>
		<TH scope="col" rowspan="2">Oedema</th>
		<th scope="col" colspan="2">Urine</th>
		<TH scope="col" rowspan="2">Hb</th>
		<TH scope="col" rowspan="2">Complaint if any</th>
		<TH scope="col" rowspan="2">Next Visit</th>
		<TH scope="col" rowspan="2">Remarks</th>
		
	</tr>
	

<tr>
<TH scope="col" >Alb</TH>
<TH scope="col" >Sugar</TH>
</tr>
	<%if(opdPatientDetailsList.size()>0){
			for(OpdPatientDetails opd:opdPatientDetailsList){
			String p="";
			Set<OpdPatientHistory> ophs=new HashSet<OpdPatientHistory>();				
		    ophs=opd.getOpdPatientHistorys();
		//if(ophs!=null){
		
		    for(OpdPatientHistory oph : ophs)
			{
		 		System.out.println("oph in jsp-->"+oph.getOpdPatientDetails().getId());
				
			if(oph.getOpdPatientDetails().getId()==opd.getId())
			{
			 p=oph.getPresentComplain()!=null?oph.getPresentComplain():"";
			 break;
			}
		//	else
		//	{
		//		p="";
		//	}
			//}
		    }
			
	%>
	<tr>
	<td>	
		<%if(opd.getDateAnc()!=null){ %>
		<input type="text"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(opd.getDateAnc())%>"	/>
		<%}else{ %>
	<input type="text"	 readonly="readonly" value="-"	/>
	<%} %>
		</td>
<td>
<%if(opd.getPog()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getPog()%>" size="5" /></td>
<%}else{ %>
<input type="text"readonly="readonly" value="-"  /></td>
<%} %>
<td>
<%if(opd.getVweight()!=null){ %>
<input type="text" readonly="readonly" value="<%=opd.getVweight()%>"size="5"  validate="Weight,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="Weight,string,no" />
<%} %>
</td>		
<td><%if(opd.getBp()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getBp()%>" size="5"  validate="bp,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="bp,string,no" />
<%} %></td>		
<td>
<%if(opd.getFundal()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getFundal()%>" size="5"  validate="fundal,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="fundal,string,no" />
<%} %></td>		
<td>
<%if(opd.getPp()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getPp()%>" size="5"  validate="Presentation Position,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="Presentation Position,string,no" />
<%} %></td>
<td>
<%if(opd.getFoetalHeadEngaged()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getFoetalHeadEngaged()%>" size="5"  validate="foetal Head Engaged,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="foetal Head Engaged,string,no" />
<%} %></td>
<td>
<%if(opd.getFoetalHeart()!=null){ %>
<input type="text" readonly="readonly" value="<%=opd.getFoetalHeart()%>" size="5"  validate="foetal heart,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="foetal heart,string,no" />
<%} %></td>
<td>
<%if(opd.getPollor()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getPollor()%>" size="5"  validate="pallor,string,no" />

<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="pallor,string,no" />
<%} %></td>
<td>
<%if(opd.getOedema()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getOedema()%>" size="5"  validate="oedema,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="oedema,string,no" />
<%} %></td>
<td>
<%if(opd.getAlb()!=null){ %>
<input type="checkbox"  tabindex="1"  readonly="readonly" value="y" class="radio" checked="checked"  validate="Alb,string,no"  onclick="displayInv(this);"/>
<%}else{%>
<input type="checkbox"  tabindex="1"  readonly="readonly" value="y" class="radio"  validate="Alb,string,no"  onclick="displayInv(this);"/>
<%} %>
</td>
<td>
<%if(opd.getSugar()!=null){ %>
<input type="checkbox"  id="sugar" readonly="readonly" checked="checked" class="radio"  validate="Sugar,string,no"  onclick="displayInv(this);"/>
<%}else{%>
<input type="checkbox"  id="sugar" readonly="readonly" value="y" class="radio"  validate="Sugar,string,no"  onclick="displayInv(this);"/>
<%} %>
</td>
<td>
<%if(opd.getHb()!=null){ %>
<input type="checkbox"  tabindex="1"  readonly="readonly" value="<%=opd.getHb()%>" checked="checked" class="radio"  validate="hb,string,no" onclick="displayInv(this);"/>
<%}else{%>		
<input type="checkbox"  tabindex="1"  readonly="readonly" value="y" class="radio"  validate="hb,string,no" onclick="displayInv(this);"/>
<%}%>
</td>
<td><%if(!p.equals("")){ %>
<input type="text"  readonly="readonly" value="<%=p %>" size="5"  validate="complaint,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="complaint,string,no" />
<%} %></td>
		<td>
		<%if(opd.getDateNextVisit()!=null){ %>
		<input type="text"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(opd.getDateNextVisit())%>"  readonly="readonly" 	/>
		<%}else{ %>
		<input type="text"	readonly="readonly" value="-"  readonly="readonly" 	/>
<%} %>
		</td>

<td>
<%if(opd.getRemarks()!=null){ %>
<input type="text"  readonly="readonly" value="<%=opd.getRemarks()%>" size="5"  validate="remarks,string,no" />
<%}else{ %>
<input type="text"  readonly="readonly" value="-" size="5"  validate="remarks,string,no" />
<%} %></td>	
</tr>
	
<%
			}
			}
			%>
		<tr>
		<td>
		<input type="text"	id="dateAnc" name="dateAnc" readonly="readonly" validate="Date,date,no"	/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',antenatalCard.dateAnc,event);" />
		
		</td>
<td><input type="text" name="pog" id="pog" value="" size="5" maxlength="5" validate="pog,int,no" /></td>
<td><input type="text" name="weight" id="weight" value="" size="10" maxlength="4" validate="Weight,string,no" /></td>		
<td><input type="text" name="bp" id="bp" value="" size="5" maxlength="4" validate="bp,string,no" /></td>		
<td><input type="text" name="fundal" id="fundal" value="" size="10" maxlength="30" validate="fundal,string,no" /></td>		
<td><input type="text" name="pp" id="pp" value="" size="5" maxlength="30" validate="Presentation Position,string,no" /></td>
<td><input type="text" name="foetalHeadEngaged" id="foetalHeadEngaged" value="" size="10" maxlength="30" validate="foetal Head Engaged,string,no" /></td>
<td><input type="text" name="foetalHeart" id="foetalHeart" value="" size="10" maxlength="30" validate="foetal heart,string,no" /></td>
<td><input type="text" name="pollor" id="pollor" value="" size="10" maxlength="30" validate="pollor,string,no" /></td>
<td><input type="text" name="oedema" id="oedema" value="" size="10" maxlength="30" validate="oedema,string,no" /></td>		
<td><input type="checkbox" name="alb" tabindex="1" id="alb" value="y" class="radio"  validate="Alb,string,no"  onclick="displayInv(this);"/></td>
<td><input type="checkbox" name="sugar" tabindex="1" id="sugar" value="y" class="radio"  validate="Sugar,string,no"  onclick="displayInv(this);"/></td>
<td><input type="checkbox" name="hb" tabindex="1" id="hb" value="y" class="radio"  validate="hb,string,no" onclick="displayInv(this);"/></td>
<td><input type="text" name="complaint" id="complaint" value="" size="10" maxlength="500" validate="complaint,string,no" /></td>
		<td>
		<input type="text"	id="dateNextVisit" name="dateNextVisit" readonly="readonly" validate="Date,date,no"	/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',antenatalCard.dateNextVisit,event);" />
		
		</td>

<td><input type="text" name="remarks" id="remarks" value="" size="10" maxlength="50" validate="remarks,string,no" /></td>	
	
<input name="Button" type="hidden" class="buttonAdd" value="" tabindex="1"	onclick="submitForm('antenatalCard','fwc?method=submitAntenatalCardFollowUp');" /></td>
		


	</tr>
	


</table>



</div>
<div id="followUpDiv" style="display: none;">
<h4>OTHER INVESTIGATION</h4>
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" multiple="multiple" class="list" onblur="showHideInvestigationTemplateCombo();">
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
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />--%>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>
<div class="clear"></div>
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
		<%int inc=1;
%>
		<tr>
		<td>
		<input type="text" value="" tabindex="1" id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	

	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
</table>

<div class="clear paddingTop15"></div>
<div class="clear"></div></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col" class="large">Clinical Notes</TH>
</tr>

<tr>
<td><input type="text" name="clinicalNotes1" class="auto" size="100" maxlength="98"></input></td>
</tr>

</table>
<div class="clear"></div>

</div>



<div class="clear"></div>



<div class="Clear"></div>
<h4>Treatment</h4>
<div class="Clear"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>PVMS/NIV Nomenclature</th>
	    <th colspan="1">Other Drug</th>
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
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
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="readOnlyNomenclature(this.value,'1');" validate="other Medicine,string,no" /></td>
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" /></td>
		
	<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="fillValueFromFrequency(this.value,'1');getFrequencyValue(this.value,'1')" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue(this.value,'1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')"  size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value="PO"  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td>
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td>
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="6"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
		
	</tr>

	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
</div>

<div class="Clear"></div>
<div class="Clear"></div>

<div class="Block">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <td><a href="#" onclick="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Procedure Advice</a></td>
		<%--  <td><a href="#" onclick="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Detention Advice</a></td>--%>
		<td><a href="#" onclick="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table>
<div class="clear"></div>
<label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto">Review SOS</textarea>

<div class="clear"></div>

<%-- <label>Admission Required</label>
<select>
<option>No</option>
<option>Yes</option>
</select>--%>

<label class="auto">Disposal</label>
<select name="disposal" id="disposalId">
<option value="0">select</option>
	<%
	if(disposalList.size() > 0){
		for(MasDisposal masDisposal: disposalList){
		%>
		<option value="<%=masDisposal.getDisposalName() %>"><%=masDisposal.getDisposalName() %></option>
	<%}
	}
%>
</select>

<label class="auto">Days</label>
<input type="text" name="diposalDays" class="auto" size="3" />




<label >Date of Next Review </label>
<input	tabindex="1" name="dateOfNextReview" maxlength="10" readonly="readonly" value="" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',antenatalCard.dateOfNextReview,event);" />


</div>


<div class="Clear"></div>
<div class="clear"></div>



<div class="division"></div>
<div class="clear"></div>
<%
	String orderSeqNo="";
	if(map.get("orderSeqNo") != null){
		orderSeqNo = (String)map.get("orderSeqNo");
	}
%> <input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />
<input name="physioRequisitionHeaderId" id="physioRequisitionHeaderId"	type="hidden" value="0" /> 
<input name="procedureHeaderId"	id="procedureHeaderId" type="hidden" value="0" />
<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitForm('antenatalCard','fwc?method=submitFollowUp&flag=fp');" />

<!--  <input type="button" value="Update" class="button" name="Button"></input>-->
<input type="button" value="Back" class="button" name="Button" onclick="submitFormForButton('antenatalCard','fwc?method=showWaitingPatientListJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
function addRowForAnc(){
    
	  var tbl = document.getElementById('ancGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
 
	  var cellRight0 = row.insertCell(0);
	    var e0 = document.createElement('input');
	    e0.type = 'text';
	    e0.className = 'date';
	    e0.name='dateAnc'+ iteration;
	    e0.id='dateAnc'+iteration;
	    e0.size='11';
	    e0.setAttribute('tabindex','1');
	    cellRight0.appendChild(e0);

	    
	    var e00 = document.createElement('img');
	    e00.src = '/hms/jsp/images/cal.gif';
	    e00.id = 'dateAnc'+iteration;
	    e00.onclick = function(event){
	    setdate('',document.getElementById('dateAnc'+iteration),event) };
	    cellRight0.appendChild(e00);


	    var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name = 'pog'+ iteration;
		  e1.id = 'pog' + iteration;
	 	  e1.setAttribute('maxlength', 30);
		  e1.setAttribute('tabindex','1');
		  cellRight1.appendChild(e1);

		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name = 'weight'+ iteration;
		  e2.id = 'weight' + iteration;
	 	  e2.setAttribute('maxlength', 30);
		  e2.setAttribute('tabindex','1');
		  cellRight2.appendChild(e2);

		  var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name = 'bp'+ iteration;
		  e3.id = 'bp' + iteration;
	 	  e3.setAttribute('maxlength', 30);
		  e3.setAttribute('tabindex','1');
		  cellRight3.appendChild(e3);

		  var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name = 'fundal'+ iteration;
		  e4.id = 'fundal' + iteration;
	 	  e4.setAttribute('maxlength', 30);
		  e4.setAttribute('tabindex','1');
		  cellRight4.appendChild(e4);

		  var cellRight5 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name = 'pp'+ iteration;
		  e5.id = 'pp' + iteration;
	 	  e5.setAttribute('maxlength', 30);
		  e5.setAttribute('tabindex','1');
		  cellRight5.appendChild(e5);

		  var cellRight6 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'foetalHeadEngaged'+ iteration;
		  e6.id = 'foetalHeadEngaged' + iteration;
	 	  e6.setAttribute('maxlength', 30);
		  e6.setAttribute('tabindex','1');
		  cellRight6.appendChild(e6);

		  var cellRight7 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name = 'foetalHeart'+ iteration;
		  e7.id = 'foetalHeart' + iteration;
	 	  e7.setAttribute('maxlength', 30);
		  e7.setAttribute('tabindex','1');
		  cellRight7.appendChild(e7);

		  var cellRight8 = row.insertCell(8);
		  var e8 = document.createElement('input');
		  e8.type = 'text';
		  e8.name = 'pollor'+ iteration;
		  e8.id = 'pollor' + iteration;
	 	  e8.setAttribute('maxlength', 30);
		  e8.setAttribute('tabindex','1');
		  cellRight8.appendChild(e8);

		  var cellRight9 = row.insertCell(9);
		  var e9 = document.createElement('input');
		  e9.type = 'text';
		  e9.name = 'oedema'+ iteration;
		  e9.id = 'oedema' + iteration;
	 	  e9.setAttribute('maxlength', 30);
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);
		  
	var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'checkbox';
	  e10.name='alb'+iteration;
	  e10.id='alb'+iteration
	  e10.size='10';
	  e10.className='radio';
	  e10.value='y';
	  e10.setAttribute('tabindex','1');
	  cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'checkbox';
	  e11.name='sugar'+iteration;
	  e11.id='sugar'+iteration
	  e11.size='10';
	  e11.className='radio';
	  e11.value='y';
	  e11.setAttribute('tabindex','1');
	  cellRight11.appendChild(e11);


	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'checkbox';
	  e12.name = 'hb'+ iteration;
	  e12.id = 'hb' + iteration;
	  e12.className='radio';
	  e12.value='y';
	  e12.setAttribute('tabindex','1');
	  cellRight12.appendChild(e12);


	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name = 'complaint'+ iteration;
	  e13.id = 'complaint' + iteration;
 	  e13.setAttribute('maxlength', 30);
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);


		  var cellRight14 = row.insertCell(14);
	    var e14 = document.createElement('input');
	    e14.type = 'text';
	    e14.className = 'date';
	    e14.name='nextVisit'+ iteration;
	    e14.id='nextVisit'+iteration;
	    e14.size='11';
	    e14.setAttribute('tabindex','1');
	    cellRight14.appendChild(e14);

	    
	    var e140 = document.createElement('img');
	    e140.src = '/hms/jsp/images/cal.gif';
	    e140.id = 'nextVisit'+iteration;
	    e140.onclick = function(event){
	    setdate('',document.getElementById('nextVisit'+iteration),event) };
	    cellRight14.appendChild(e140);

	  var cellRight15 = row.insertCell(15);
	  var e15 = document.createElement('input');
	  e15.type = 'text';
	  e15.name = 'remarks'+ iteration;
	  e15.id = 'remarks' + iteration;
 	  e15.setAttribute('maxlength', 30);
	  e15.setAttribute('tabindex','1');
	  cellRight15.appendChild(e15);
	  
	 var cellRight16 = row.insertCell(16);
	  var e16 = document.createElement('input');
	  e16.type = 'button';
	  e16.className = 'buttonAdd';
	  e16.name='Button';
	  e16.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e16.onclick = function(){addRowForAnc("ancGrid","hdb",this);}; 
	  cellRight16.appendChild(e16);

	  var cellRight17 = row.insertCell(17);
	  var e17 = document.createElement('input');
	  e17.type = 'button';
	  e17.className = 'buttonDel';
	  e17.name='delete';
	  e17.setAttribute('tabindex','1');
	  //e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
	  e17.onclick = function(){removeRow("ancGrid","hdb",this);}; 
	  cellRight17.appendChild(e17);
	  

	}
function delRow(idName,countId,obj)
{
var tbl = document.getElementById(idName);
var lastRow = tbl.rows.length;
if (lastRow > 2){
//	tbl.deleteRow(lastRow - 1);
  var i=obj.parentNode.parentNode.rowIndex;
  tbl.deleteRow(i);
}
}


function displayInv(inc)
{

		if(inc.checked){
			document.getElementById('followUpDiv').style.display='inline';
		}else if(!inc.checked){
			document.getElementById('followUpDiv').style.display='none';
		}

		
	
	
}

function openPopupANCINITIALVisit()
{
	var url="/hms/hms/fwc?method=showAntentatalCardJsp&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
   	newwindow=window.open(url,'antenatalCard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}

function openPopupULTRASONOGRAPHY()
{
 var url="/hms/hms/fwc?method=viewUlterSoundTestForOrderNo&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");

}

function openPopupOtherInvestigation()
{
 var url="/hms/hms/fwc?method=viewOtherInvTestForOrderNo&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");

}


function openPopupForImmunization(hinId,flag){
	var url = "/hms/hms/registration?method=openPopupForImmunization&hinId="+hinId+"&flag="+flag;
	 newwindow = window.open(url,'windowRef','width=1000,height=400,scrollbars = yes');
}

function caseSheet(visitId,hinId,flag){
	var url = "/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId="+visitId+"&hinId="+hinId+"&backFlag="+flag;
	 newwindow = window.open(url,'windowRef','width=1000,height=400,scrollbars = yes');
}
	
</script>
<script type="text/javascript">
function addRowForInvestigation(){
    
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
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
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
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
	  e4.onclick = function(){addRowForInvestigation("grid","hdb",this);}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  //e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	  

	}
function addRow(){
	  
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	//  alert("1---");
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
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
    	newdiv.setAttribute('id', 'ac2update'+iteration);
    	newdiv.setAttribute('class', 'autocomplete');
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
	  e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name='au'+iteration;
	  e12.id='au'+iteration
	  e12.size='6';
	  e12.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight2.appendChild(e12);

	 
	  cellRight2.appendChild(e1);
	  

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

	  var cellRight3 = row.insertCell(3);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dosage'+iteration;
	  e13.id='dosage'+iteration
	  e13.size='5';
	  e13.setAttribute('maxlength', 5); 
	  e13.setAttribute('tabindex','1');
	  e13.onblur = function(){checkDosageValidation(this.value,iteration)};
	  cellRight3.appendChild(e13);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight4 = row.insertCell(4);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){fillValueFromFrequency(this.value,iteration);getFrequencyValue(this.value,iteration)};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight4.appendChild(e2);

	  	var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(this.value,iteration)};
		cellRight4.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight4.appendChild(e21);
	  	  
	  var cellRight5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur=function(){fillValue(this.value,iteration)};
	  cellRight5.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

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


		var cellRight6 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value='PO'
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight8.appendChild(e71);

	  var cellRight9 = row.insertCell(9);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='6';
	  e72.setAttribute('tabindex','1');
	  cellRight9.appendChild(e72);

	  var cellRight10 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();');
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);}; 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	}
function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency freq :frequencyList){
%>
 if(feqValue == '<%=freq.getId()%>'){
	 feqQty = '<%=freq.getFeq()%>'
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
		  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != 0){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			// alert("==in else==");
			  document.getElementById('total'+inc).value=freq*value*dosage
		  }
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = ((freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != 0){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				// alert("==in else==");
				  document.getElementById('total'+inc).value=freq*value*dosage
			  }

	  }
	  
	 }

	 function  fillValueFromFrequency(value,inc){
 	  var dosage = document.getElementById('dosage'+inc).value
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != 0){
			  finalQty = Math.ceil(totalQty);
		  }
		 /*var arr = new Array();
		  arr = totalQty.split(".");
		  var qtyA;var qtyB;var finalQty;
		  if(arr[0] != "" && arr[0] != null){
			  qtyA = parseFloat(arr[0]);
		  }else{
			  qtyA = 0;
		  }
		  if(arr[1] != "" && arr[1] != null){
			  qtyB = parseFloat(arr[1]);
		  }else{
			  qtyB = 0;
		  }
		  if(qtyA == 0){
			  finalQty = 1;
		  }else if(qtyB ==0){
			 finalQty = qtyA;
			  
		  }else if(qtyB >0){
			  finalQty = qtyA+1;
		  }*/
		  document.getElementById('total'+inc).value=finalQty;
	
	 }else{
		  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  }
	 }

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
function openPopupProcedureAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showProcedureListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fp";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
}
function openPopupDetentionAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showDetentionListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fp";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
function openPopupPhysiotheraphyAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showPhysiotherapyListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fp";
 newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Physiotheraphy Advice ....");
}


function fwcFileUploadViewWindow(visitId,hinId,flag)
{
		//var url="/hms/hms/fwc?method=showFwcUploadViewDocumentJsp&visitId="+visitId+"&hinId="+hinId;
		var url="/hms/hms/fwc?method=showFwcUploadViewDocumentJsp&visitId="+visitId+"&hinId="+hinId+"&flag="+flag;
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

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
	//alert("sdfsdfsd"+val+"inc==="+inc);
  if(val != "")
	{
   document.getElementById('otherMedicine'+inc).readOnly = true;		
   document.getElementById('otherMedicine'+inc).value ="";
  // document.getElementById('itemConversionId'+inc).disabled = true;
  // document.getElementById('itemConversionId'+inc).value = "";
   //document.getElementById('injCategory'+inc).disabled = true;	
   
	}else{
		document.getElementById('otherMedicine'+inc).readOnly = false;
		//document.getElementById('itemConversionId'+inc).disabled = false;
		//document.getElementById('injCategory'+inc).disabled = false;	

	}
}

function openOtherField(familyHistoryId,fieldId){
	
	if(familyHistoryId == '8'){
		if(fieldId=='srfamilyHistory'){
			document.getElementById('otherSrFamilyHistoryDiv').style.display = 'block';
		}else if(fieldId=='familyHistory'){
			document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
		}
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
submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
			
			}

function checkTemplateId(templateId){

  if(templateId=="0"){
    return true;
  }else{
    return true;
  }
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

function showCreateInvestigationTemplate(){
    
    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
  

}


function getListForTreatment(val){
if(val=='investigationDiv'){
alert("fdgdfgdf==="+val);	
	submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
}
//document.getElementById('prescriptionImportButton').style.display = 'none';
//document.getElementById("investigationImportButton").style.display='none'
}
function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';
		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('antenatalCard','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}




</script>

</form>