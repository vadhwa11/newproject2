<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AviCa34"%>

<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.AvMedicalExamMaMo"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>
<%
		String Labresult="NotPresent";
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		Users users =null;
		if(session.getAttribute("users")!=null){
			users=(Users)session.getAttribute("users");
		}
		int loginEmpId=0;
		if(users!=null){
			if(users.getEmployee()!=null){
				loginEmpId=users.getEmployee().getId();
			}
		}
		
		List visitlist = new ArrayList();
		
		if(map.get("visit") != null){
			visitlist=(List)map.get("visit");
		}
		Set<PatientInvestigationDetails> patientInvestigationdetails=null;
		PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		if(map.get("patientInvestigationHeader")!=null){
			patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
			patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
		}
		DgOrderhd dgOrderhd=null;
		Set<DgOrderdt> getDgOrderdts=null;
		if(map.get("dgOrderhd")!=null){
		
			dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
			getDgOrderdts=dgOrderhd.getDgOrderdts();
		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		
			}
		List templateList= new ArrayList();
		if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
		}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");
		List<AvMedicalExamMaMo> medicalExamMaMoList = new ArrayList<AvMedicalExamMaMo>();
		if(map.get("medicalExamMaMoList") != null){
			medicalExamMaMoList=(List)map.get("medicalExamMaMoList");
			}
		AvMedicalExamMaMo medicalExamMaMoObj = new AvMedicalExamMaMo();
		
		if(medicalExamMaMoList.size() > 0){
			medicalExamMaMoObj = medicalExamMaMoList.get(0);
		}
		%>
<div>
<input	name="investigationTemplate" type="hidden"	value="Previous Medical Exam" tabindex="1" class="buttonBig" onClick="" />
</div>

<div class="clear"></div>
<div class="titleBg">	<h2>Civil Aviation Med Exam (MO)</h2> </div>

<div class="clear"></div>
<form name="civilAviationMedExam" action="" method="post">

<div class="clear paddingTop15"></div>
<h4>Personal Details</h4>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="visitId" value="<%=medicalExamMaMoObj.getAviCa34().getVisit().getId() %>"/>
<input type="hidden" name="hinId" value="<%=medicalExamMaMoObj.getAviCa34().getHin().getId() %>"/>
<input type="hidden" name="avica34Id" value="<%=medicalExamMaMoObj.getAviCa34().getId() %>"/>
<input type="hidden" name="medExamMaMoId" value="<%=medicalExamMaMoObj.getId() %>"/>

<label>Designation  </label> 
<input type="text" value="" readonly="readonly" name="<%=DESIGNATION%>"	tabindex="2" maxlength="20"/>

<label>Name  </label> 
<%  
	String fullName="";
	fullName=medicalExamMaMoObj.getAviCa34().getFirstName();
	if(medicalExamMaMoObj.getAviCa34().getLastName() !=null){
		fullName=fullName+" "+medicalExamMaMoObj.getAviCa34().getLastName() ;
	}
	String licenceApplied="";
	String licenceHeld="";
	String licenceNo="";
	if(medicalExamMaMoObj.getAviCa34().getLicenceNo() !=null){
		licenceNo=medicalExamMaMoObj.getAviCa34().getLicenceNo();
		}
	if(medicalExamMaMoObj.getAviCa34().getTypeOfLicenceApplied() !=null){
	licenceApplied=medicalExamMaMoObj.getAviCa34().getTypeOfLicenceApplied().getCaLicenceName();
	}
	if(medicalExamMaMoObj.getAviCa34().getLicenceHeld() !=null){
	licenceHeld=medicalExamMaMoObj.getAviCa34().getLicenceHeld().getCaLicenceName();
	}
%>
<input	type="text" value="<%=fullName %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" />

<label>Organization  </label> 
<input	type="text" value="" readonly="readonly" name="<%=ORGANISATION%>"	tabindex="2" maxlength="20"/>

<label>Age  </label> 
<%String age="";
if(medicalExamMaMoObj.getAviCa34().getAge() !=null){
age=medicalExamMaMoObj.getAviCa34().getAge();}%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=age %>" name="<%=AGE %>"	tabindex="2" />

<label>Gender</label> 
<input	type="text" readonly="readonly" value="<%=medicalExamMaMoObj.getAviCa34().getSex().getAdministrativeSexName() %>" 
	name="<%=GENDER %>"	tabindex="2" />

<div class="clear"></div>
<label>Licence Applied  </label> 
<input	type="text" readonly="readonly" value="<%=licenceApplied %>" name="<%=LICENCE_APPLIED %>"	tabindex="2" />

<label>Licence Held Type  </label> 
<input	type="text" readonly="readonly" value="<%=licenceHeld %>" name="<%=LICENCE_HELD %>"	tabindex="2" />

<label>Licence No. </label> 
<input	type="text" readonly="readonly" value="<%=licenceNo %>" name="<%=LICENCE_NO %>"	tabindex="2" />

</div>
<div class="clear"></div>
<ul id="countrytabs" class="shadetabs">
<li><a href="#" rel="country1" >PHYSICAL AND MENTAL DETAILS</a></li>
<li><a href="#" rel="country2" >EYE</a></li>
<li><a href="#" rel="country3">COLOUR PERCEPTION</a></li>
<li><a href="#" rel="country4">ENT</a></li>
</ul>

<div id="country1" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>PHYSICAL AND MENTAL DETAILS</h4>
<div class="clear"></div>
<div class="Block">
<label>Height</label>
<%
if(medicalExamMaMoObj.getHeight() !=null){
%>
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT %>"	tabindex="2" maxlength="20" size="10"
value="<%=medicalExamMaMoObj.getHeight() %>" id="height" onblur="calculateBMI();" validate="Height,int,no"/>
<%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT %>"	tabindex="2" maxlength="20" size="10"
	id="height" onblur="calculateBMI();" validate="Height,int,no"/>
<%} %>
<label class="unit">cm</label>

<input class="transparent" size="3">
<label>Weight</label>
<%if(medicalExamMaMoObj.getWeight() !=null){ %>
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT %>"	tabindex="2" maxlength="20" size="10"
      value="<%=medicalExamMaMoObj.getWeight() %>" id="weight" onblur="calculateBMI();" validate="Weight,int,no"/>
<%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT %>"	tabindex="2" maxlength="20" size="10"
	validate="Weight,int,no"id="weight" onblur="calculateBMI();" />
<%} %>
<label class="unit">Kg</label>
<input class="transparent" size="3">
<label>BMI</label>
<%if(medicalExamMaMoObj.getBmi() !=null){ %>
<input	class="auto" tabindex="1" type="text"  name="<%=BMI %>"	tabindex="2" maxlength="20" size="10"
 		value="<%=medicalExamMaMoObj.getBmi() %>" id="bmi" validate="BMI,float,no"/>
<%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=BMI %>"	tabindex="2" maxlength="20" size="10"
id="bmi" validate="BMI,float,no"/>
<%} %>
<div class="clear"></div>

<label>Chest Circumference: Inspiration</label>
<%if(medicalExamMaMoObj.getChestCircumference() !=null){ %>
<input	class="auto" tabindex="1" type="text"  name="<%=CHEST %>"	tabindex="2" maxlength="20" size="10"
value="<%=medicalExamMaMoObj.getChestCircumference() %>" validate="Chest Circumference,float,no"/><%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=CHEST %>"	tabindex="2" maxlength="20" size="10"
value="" validate="Chest Circumference,float,no"/><%} %>
<label class="unit">cm</label>
<input class="transparent" size="3">
<label>Expiration</label>
<%if(medicalExamMaMoObj.getExpiration() !=null){ %>
<input	class="auto" tabindex="1" type="text"  name="<%=EXPIRATION %>"	tabindex="2" maxlength="20" size="10"
value="<%=medicalExamMaMoObj.getExpiration() %>" validate="Expiration,float,no"/><%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=EXPIRATION %>"	tabindex="2" maxlength="20" size="10"
validate="Expiration,float,no"/>
<%} %>
<label class="unit">cm</label>

<div class="clear"></div>
<label>Pulse : Seated</label>
<%if(medicalExamMaMoObj.getPulseSeated() !=null){ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE%>" class="auto" size="10" maxlength="10"
value="<%=medicalExamMaMoObj.getPulseSeated() %>" validate="Pulse : Seated,metachar,no"/>
<%}else{ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE%>" class="auto" size="10" maxlength="10"
	  value="" validate="Pulse : Seated,metachar,no"/>
<%} %>
<label class="unit">/min</label>
<input class="transparent" size="3">
<label>After Exercise</label>
<%if(medicalExamMaMoObj.getPulseExercise() !=null){ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_EXERCISE%>" class="auto" size="10" maxlength="10"
validate="Pulse : Exercise,metachar,no" value="<%=medicalExamMaMoObj.getPulseExercise() %>" />
<%}else{ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_EXERCISE%>" class="auto" size="10" maxlength="10"
validate="Pulse : Exercise,metachar,no"  value="" />
<%} %>
<label class="unit">/min</label>

<input class="transparent" size="3">
<label>Return to Normal in</label>
<%if(medicalExamMaMoObj.getMinPulseNormal() !=null){ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_NORMAL%>" class="auto" size="10" maxlength="10"  
value="<%=medicalExamMaMoObj.getMinPulseNormal() %>" validate="Pulse : Return to Normal,metachar,no" />
<%}else{ %>
<input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_NORMAL%>" class="auto" size="10" maxlength="10"  
validate="Pulse : Return to Normal,metachar,no" value="" />
<%} %>
<label class="unit">Sec.</label>

<div class="clear"></div>

<label>BP</label> 
<%if(medicalExamMaMoObj.getBp() !=null){ %>
  <input tabindex="1" type="text" maxlength="10"  name="<%=BP%>" class="auto" size="10" maxlength="10"  
  	value="<%=medicalExamMaMoObj.getBp() %>" validate="BP,string,no"/>
  <%}else{ %>
    <input tabindex="1" type="text" maxlength="10"  name="<%=BP%>" class="auto" size="10" maxlength="10"  value="" validate="BP,string,no"/>
  <%} %>
 <label class="unit">mm/Hg</label>
<input class="transparent" size="3">
<label>Electrocardiogram</label>
<select name=<%=ELECTROCARDIOGRAM%> class="small">
<% 
String electrocardiogram="";
if(medicalExamMaMoObj.getElectrocardiogram() !=null){
electrocardiogram=medicalExamMaMoObj.getElectrocardiogram();}

System.out.println("electrocardiogram-----"+electrocardiogram);%>

	<%if(electrocardiogram.equalsIgnoreCase("Normal")){ %>
	<option value="Normal" selected="selected">Normal</option>
	<option value="Abnormal">Abnormal</option>
	<option value="NotDue">Not Due</option>
	<%}else if(electrocardiogram.equalsIgnoreCase("Abnormal")){ %>
	<option value="Normal">Normal</option>
	<option value="Abnormal" selected="selected">Abnormal</option>
	<option value="NotDue">Not Due</option>
	<%}else if(electrocardiogram.equalsIgnoreCase("NotDue")){ %>
	<option value="Normal">Normal</option>
	<option value="Abnormal">Abnormal</option>
	<option value="NotDue" selected="selected">Not Due</option>
	<%}else{ %>
	<option value="Normal">Normal</option>
	<option value="Abnormal">Abnormal</option>
	<option value="NotDue">Not Due</option>
<%} %>
			</select>
</div>
<div class="clear"></div>

<div class="clear paddingTop15"></div>
<h4> SYSTEMIC EXAMINATION <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="smallCmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">System Examination</TH>
		<TH scope="col">Result</TH>
		<TH scope="col">Remarks</TH>
	</tr>
	<tr>
		<td><label>Skin</label>	</td>
		<td>
			<select name="<%=SKIN%>">
			<%String systemSkin=""; 
			if(medicalExamMaMoObj.getSystemicSkin() !=null){
				systemSkin=medicalExamMaMoObj.getSystemicSkin();
			}
			%>
			<%if(systemSkin.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(systemSkin.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksSkin() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_SKIN %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksSkin() %>"/>
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_SKIN %>" maxlength="50" value=""/>
			<%} %>	
		</td>
	</tr>
		<tr>
		<td><label>Lymphnodes and Lymphatics</label>	</td>
		<td>
			<select name="<%=LYMPHNODES_YMPHATICS%>">
				<%String lymphnodeLymphatic=""; 
			if(medicalExamMaMoObj.getSystemLymphnodeLymphatic() !=null){
				lymphnodeLymphatic=medicalExamMaMoObj.getSystemLymphnodeLymphatic();
			}
			%>
			<%if(lymphnodeLymphatic.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(lymphnodeLymphatic.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksLymphnodeLymphatic() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_LYMPHNODES_LYMPHATICS %>" maxlength="50" 
			value="<%=medicalExamMaMoObj.getRemarksLymphnodeLymphatic() %>" validate="Lymphnodes Remarks,metachar,no"/>
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_LYMPHNODES_LYMPHATICS %>" maxlength="50" value="" validate="Lymphnodes Remarks,metachar,no"/>
			<%} %>	
		</td>
	</tr>
		<tr>
		<td><label>Head,Face,Neck,Scalp</label>	</td>
		<td>
			<select name="<%=HEAD_FACE_NECK_SCALP%>">
	<%String headFaceNeck=""; 
			if(medicalExamMaMoObj.getSystemHeadFaceNeck() !=null){
				headFaceNeck=medicalExamMaMoObj.getSystemHeadFaceNeck();
			}
			%>
			<%if(headFaceNeck.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(headFaceNeck.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksHeadFaceNeck() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_HEAD_FACE_NECK_SCALP %>" maxlength="50" 
				value="<%=medicalExamMaMoObj.getRemarksHeadFaceNeck() %>" validate="HeadFaceNeckScalp,metachar,no"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_HEAD_FACE_NECK_SCALP %>" maxlength="50" value="" validate="HeadFaceNeckScalp,metachar,no"/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Upper and Lower Extremities </label>	</td>
		<td>
			<select name="<%=UPPER_LOWER_EXTRMITIES%>">
				<%String upperLowerExtremities=""; 
			if(medicalExamMaMoObj.getSystemUperLowerExtremitie() !=null){
				upperLowerExtremities=medicalExamMaMoObj.getSystemUperLowerExtremitie();
			}
			%>
			<%if(upperLowerExtremities.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(upperLowerExtremities.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksUperLowerExtremitie() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_UPPER_LOWER_EXTRMITIES %>" maxlength="50" 
				value="<%=medicalExamMaMoObj.getRemarksUperLowerExtremitie()%>"  validate="Upper and Lower Extremities,metachar,no"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_UPPER_LOWER_EXTRMITIES %>" maxlength="50"
			 validate="Upper and Lower Extremities,metachar,no" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Spine and Musculo Skeletal System</label>	</td>
		<td>
			<select name="<%=SPINE_MUSCULO_SKELETAL%>">
				<%String SpineMusculo=""; 
			if(medicalExamMaMoObj.getSystemSpineMusculo() !=null){
				SpineMusculo=medicalExamMaMoObj.getSystemSpineMusculo();
			}
			%>
			<%if(SpineMusculo.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(SpineMusculo.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksSpineMusculo() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_SPINE_MUSCULO_SKELETAL%>" maxlength="50" 
				value="<%=medicalExamMaMoObj.getRemarksSpineMusculo() %>" validate="Spine and Musculo Remarks,metachar,no"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_SPINE_MUSCULO_SKELETAL%>" maxlength="50" value=""
				validate="Spine and Musculo Remarks,metachar,no"/>	
			<%} %>
		</td>
	</tr>
	<tr>
		<td><label>Chest and Lungs</label>	</td>
		<td>
			<select name="<%=CHEST_AND_LUNGS%>">
				<%String chestlungs=""; 
			if(medicalExamMaMoObj.getSystemChestLungs() !=null){
				chestlungs=medicalExamMaMoObj.getSystemChestLungs();
			}
			%>
			<%if(chestlungs.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(chestlungs.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksChestLungs() !=null){ %>
		<input tabindex="1" type="text"	name="<%=REMARKS_CHEST_AND_LUNGS %>" maxlength="50"
		 value="<%=medicalExamMaMoObj.getRemarksChestLungs() %>" validate="Chest and LungsRemarks,metachar,no"/>
		<%}else{ %>
		<input tabindex="1" type="text"	name="<%=REMARKS_CHEST_AND_LUNGS %>" maxlength="50" value=""
		validate="Chest and Lungs Remarks,metachar,no"/>	
		<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Heart</label>	</td>
		<td>
			<select name="<%=HEART%>">
			<%String heart=""; 
			if(medicalExamMaMoObj.getSystemHeart() !=null){
				heart=medicalExamMaMoObj.getSystemHeart();
			}
			%>
			<%if(heart.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(heart.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksHeart() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_HEART %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksHeart() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_HEART %>" maxlength="50" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Vascular System</label>	</td>
		<td>
			<select name="<%=VASCULAR_SYSTEM%>">
				<%String Vascular=""; 
			if(medicalExamMaMoObj.getSystemVascular() !=null){
				Vascular=medicalExamMaMoObj.getSystemVascular();
			}
			%>
			<%if(Vascular.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(Vascular.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksVascular() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_VASCULAR_SYSTEM %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksVascular() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_VASCULAR_SYSTEM %>" maxlength="50" value=""/>
			<% }%>
		</td>
	</tr>
		<tr>
		<td><label>Abdomen and Viscera(including Liver,Spleen, Hernia)</label>	</td>
		<td>
			<select name="<%=ABDOMEN_VISCERA%>">
				<%String abdomenViscera=""; 
			if(medicalExamMaMoObj.getSystemHeadFaceNeck() !=null){
				abdomenViscera=medicalExamMaMoObj.getSystemHeadFaceNeck();
			}
			%>
			<%if(abdomenViscera.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(abdomenViscera.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksAbdomenViscera() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_ABDOMEN_VISCERA %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksAbdomenViscera() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_ABDOMEN_VISCERA %>" maxlength="50" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Perincum, Anus</label>	</td>
		<td>
			<select name="<%=PERINCUM_ANUS%>">
				<%String Perincum=""; 
			if(medicalExamMaMoObj.getSystemPerincumAnus() !=null){
				Perincum=medicalExamMaMoObj.getSystemPerincumAnus();
			}
			%>
			<%if(Perincum.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(Perincum.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksPerincumAnus() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_PERINCUM_ANUS %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksPerincumAnus() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_PERINCUM_ANUS %>" maxlength="50" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Genitourinary System</label>	</td>
		<td>
			<select name="<%=GENITOURINARY_SYSTEM%>">
				<%String Genitourinary=""; 
			if(medicalExamMaMoObj.getSystemGenitourinary() !=null){
				Genitourinary=medicalExamMaMoObj.getSystemGenitourinary();
			}
			%>
			<%if(Genitourinary.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(Genitourinary.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksGenitourinary() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_GENITOURINARY_SYSTEM %>" maxlength="50" 
			value="<%=medicalExamMaMoObj.getRemarksGenitourinary() %>"/>
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_GENITOURINARY_SYSTEM %>" maxlength="50" value=""/>	
			<%} %>	
		</td>
	</tr>
		<tr>
		<td><label>Endocrine System</label>	</td>
		<td>
			<select name="<%=ENDOCRINE_SYSTEM%>">
				<%String Endocrine=""; 
			if(medicalExamMaMoObj.getSystemEndocrine() !=null){
				Endocrine=medicalExamMaMoObj.getSystemEndocrine();
			}
			%>
			<%if(headFaceNeck.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(headFaceNeck.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksEndocrine() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_ENDOCRINE_SYSTEM %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksEndocrine() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_ENDOCRINE_SYSTEM %>" maxlength="50" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Neurologic (reflexes, equilibrium, coordination, sense etc.)</label>	</td>
		<td>
			<select name="<%=NEUROLOGIC%>">
				<%String Neurologic=""; 
			if(medicalExamMaMoObj.getSystemNeurologic() !=null){
				Neurologic=medicalExamMaMoObj.getSystemNeurologic();
			}
			%>
			<%if(Neurologic.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(Neurologic.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td><%if(medicalExamMaMoObj.getRemarksNeurologic() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_NEUROLOGIC %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksNeurologic() %>"/>	
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_NEUROLOGIC %>" maxlength="50" value=""/>
			<%} %>
		</td>
	</tr>
		<tr>
		<td><label>Psychiartric</label>	</td>
		<td>
			<select name="<%=PSYCHIARTRIC%>">
				<%String Psychiartric=""; 
			if(medicalExamMaMoObj.getSystemPsychiartric() !=null){
				Psychiartric=medicalExamMaMoObj.getSystemPsychiartric();
			}
			%>
			<%if(Psychiartric.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(Psychiartric.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%} %>
			</select>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getRemarksPsychiartric() !=null){ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_PSYCHIARTRIC %>" maxlength="50" value="<%=medicalExamMaMoObj.getRemarksPsychiartric() %>"/>
			<%}else{ %>
			<input tabindex="1" type="text"	name="<%=REMARKS_PSYCHIARTRIC %>" maxlength="50" value=""/>
			<%} %>	
		</td>
	</tr>
		
</table>
</div>
</div>
<%
//if(aviCa34Obj.getHin() !=null){
//if(aviCa34Obj.getHin().getSex() !=null){ 
//if(aviCa34Obj.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female")){%>
<div class="clear paddingTop15"></div>
<h4> IN CASE OF WOMEN <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">

<label>Examination of Breasts</label>
<select name="<%=EXAMINATION_OF_BREASTS%>">
<option value="">Select</option>
<%String  examinationBreasts="";
if(medicalExamMaMoObj.getExaminationBreasts() !=null){
examinationBreasts=medicalExamMaMoObj.getExaminationBreasts();}%>
<%if(examinationBreasts.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(examinationBreasts.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option>
				<%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option><%} %>
			</select>


<label>Last Menstruation Date</label>
<%String  menstruationDate="";
if(medicalExamMaMoObj.getMenstruationDate() !=null){
menstruationDate=HMSUtil.changeDateToddMMyyyy(medicalExamMaMoObj.getMenstruationDate());%>
<input	tabindex="1" name="<%=LAST_MENSTRUATION_DATE %>" class="date"	
validate="Last Menstruation Date,date,no" maxlength="10" value="<%=menstruationDate %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<%}else{ %>
<input	tabindex="1" name="<%=LAST_MENSTRUATION_DATE %>" class="date"	maxlength="10" value=""
validate="Last Menstruation Date,date,no" 	onKeyUp="mask(this.value,this,'2,5','/');" />
<%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',civilAviationMedExam.<%=LAST_MENSTRUATION_DATE%>,event);" />


<label>Pelvic Examination</label>
<select name="<%=PELVIC_EXAMINATION%>">
<option value="">Select</option>
<%
String pelvicExamination="";
if(medicalExamMaMoObj.getPelvicExamination() !=null){
	pelvicExamination=medicalExamMaMoObj.getPelvicExamination();}%>
<%if(pelvicExamination.equalsIgnoreCase("not")){ %>
		<option value="not" selected="selected">Not Applicable</option>
		<option value="no">Normal</option>
		<option value="ab">Abnormal</option>
		<%}else if(pelvicExamination.equalsIgnoreCase("no")){ %>
		<option value="not">Not Applicable</option>
		<option value="no" selected="selected">Normal</option>
		<option value="ab">Abnormal</option>
		<%}else if(pelvicExamination.equalsIgnoreCase("ab")){ %>
		<option value="not">Not Applicable</option>
		<option value="no">Normal</option>
		<option value="ab"selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="not">Not Applicable</option>
		<option value="no">Normal</option>
		<option value="ab">Abnormal</option><%} %>
		</select>
</div>
</div>
<%//} } } %>
<!--  Start Of Investigations -->
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
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
	<%  }
	      }
		%>

</select>
</div>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>

<input name="Prevoius" type="button" tabindex="1" value="Prev Investigations"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=medicalExamMaMoObj.getVisit().getVisitNo()%>','<%=medicalExamMaMoObj.getVisit().getHin().getId()%>')" />

</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
<%if(dgOrderhd !=null && dgOrderhd.getClinicalNote() !=null){
%>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="<%=dgOrderhd.getClinicalNote() %>" size="100" maxlength="45" /></td>
<%}else{ %>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="For Aviation" size="100" maxlength="45" /></td>
<%} %>
</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Result</th>
		<th scope="col">File Upload</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>
<%  }


if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<%
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% }
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<%
}else{%>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<% }
String template="";
int resultid=0;

if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc1=1;
	   
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {
		    	int cnt=0;
		    	String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());
		    	third.put(investigationName,patientInvestigation.getId());

		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		      	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Ritu 
		    	*/
		    	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
		    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
				for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
					linkedHashSet.add(dgResultEntryDetail);
				}
				subSet1.addAll(linkedHashSet);
		    	
		    //	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	for(DgResultEntryDetail dgre:subSet1)
		    	{  
		    		if(dgre.getSubInvestigation()!=null)
			    		val1=dgre.getSubInvestigation().getSubInvestigationName();
			    	if(!dgre.getResultType().equalsIgnoreCase("t"))
		    		{
			      	    ++cnt;
			    		if(dgre.getResult()!=null)
			    			val2=dgre.getResult();
			    
			    		if(cnt==1){
			    	    	val=" "+val1+":"+val2;
			    	    }else{
			    	    	val=" "+val+","+val1+":"+val2;
			    	    }
			    		 

		    		}
		    	investigationId=dgre.getInvestigation().getId();
		    		if(dgre.getResultType().equalsIgnoreCase("s"))
		    		{
		    		    	val=val.substring(2);
		    				resultid=0;
			
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("m"))
		    		{
		    			val=val.substring(1);
		    			resultid=0;
	    	
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("t"))
		    		{

		    			resultid=dgre.getResultEntry().getId();
		    			template="template"+"/"+resultid;
		    			val=template;
	    	
		    		}    	
		    	
		    	}

		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
		    	second.put(investigationId,val);
		    	++inc1;
		    	//
		    }

			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();



		    %>
	<tr>

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			 name="chargeCodeName<%=inc %>" size="45" />
</td>
<%
if(second.get(first.get(key))!=null)
	{
	Labresult="present";
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{if(resultList!=null && resultList.size()>0){
	%>
	
	<td> <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
	onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
 </td>
 
 <%}else{ %>
 <td> <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
	onclick="checkForInvestigationMH(<%=inc %>);" />
 <%} %>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>

<% }else{%>
<td>&nbsp;</td>
	<td>
	<input name="resultIdTemplate<%=inc %>"	id="resultIdTemplate<%=inc %>" type="hidden"	value="<%=mySplitResult[1]%>"/>
	<input	type="Button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  />
	</td>

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
	</td>
	<%}else{
	String investigationVal=key;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>

	<%
	if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts)
	{
	    int finalVal=Integer.parseInt(finalInvestVal);
	    if(dgOrderdt.getInvestigation().getId()==finalVal)
	    {
	    	if(dgOrderdt.getInvestigationToMH()!=null)
	    	{
	    	if(dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
	    	{

	    		%>
<td><input tabindex="1" type="checkbox" disabled="disabled" name="investigationReferToMH<%=inc %>"
			 value="y" checked="checked" id="investigationReferToMH<%=inc %>"  
	    			onclick="checkForInvestigationMH(<%=inc %>);" />
</td>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"	onclick="checkForInvestigationMH(<%=inc %>);"/>
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
            <%

             }
	    	}else
	    	{ %> 
	    	 <td>
  		<input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y" 
  			 id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
        <td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
	    <%	}
	    }
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%--<input type="text" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
	 --%>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
	<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%
	}
	}else{
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
<%--
<input type="hidden" value="0" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
 --%>
<input type="hidden" value="0" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	  <td>
<input tabindex="1" type="checkbox" 	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"
onclick="checkForInvestigationMH(<%=inc %>);"   />

</td>
<td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% }%>



<% }%>
<!-- style="display: none;" -->

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>

	<% inc++;
		    }

%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
<!--	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
<%--<input type="hidden" value="0" name="dgOrderdtId1" id="dgOrderdtId1" /> --%>
		</td>
	<td>
<input tabindex="1" type="checkbox"	name="investigationReferToMH1" value="y" id="investigationReferToMH1"  
	onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" size="65" />
</td>
<!-- style="display: none;"  -->
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>
<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="clear"></div>
<div class="Clear paddingTop15"></div>
<div class="Block">
<label>Remarks</label>
<%if(medicalExamMaMoObj.getPhysicalMentalRemarks() !=null){ %>
<textarea rows="" cols="60"	name="<%=REMARKS %>" class="auto" onkeyup="chkLength(this,50);" value="<%=medicalExamMaMoObj.getPhysicalMentalRemarks() %>">
<%=medicalExamMaMoObj.getPhysicalMentalRemarks() %></textarea>
<%}else{ %>
<textarea rows="" cols="60"	name="<%=REMARKS %>" class="auto" onkeyup="chkLength(this,50);"></textarea>
<%} %>
</div>


</div>
<div id="country2" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Lids, Lachrymal Apparatus, Conjunctivae, Cornea, Pupils, Lens, Media, Fundi, Tension</label>
	
			<select name="<%=LIDS%>" class="small">
			<%String lidslachrymal=""; 
			if(medicalExamMaMoObj.getEyeLidsLachrymal() !=null){
			lidslachrymal=medicalExamMaMoObj.getEyeLidsLachrymal(); }%>
			<%if(lidslachrymal.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(lidslachrymal.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option><%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option><%} %>
			</select>
	

<label class="large">Visual Fields (By Confirmation Movement, Nystagmus)</label>	
		
			<select name="<%=VISUAL_FIELDS%>" class="small">
				<%String visualField=""; 
			if(medicalExamMaMoObj.getEyeVisualFields() !=null){
				visualField=medicalExamMaMoObj.getEyeVisualFields(); }%>
			<%if(visualField.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(visualField.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option><%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option><%} %>
			</select>
	
	
<div class="clear"></div>
<label class="large">Ocular Motility(Associated Parallel Movement, Nystagmus)</label>	
		
			<select name="<%=OCULAR_MOTILITY%>" class="small">
			<%String ocularMotility=""; 
			if(medicalExamMaMoObj.getEyeOcularMotility() !=null){
				ocularMotility=medicalExamMaMoObj.getEyeOcularMotility(); }%>
			<%if(ocularMotility.equalsIgnoreCase("Normal")){ %>
				<option value="Normal" selected="selected">Normal</option>
				<option value="Abnormal">Abnormal</option>
				<%}else if(ocularMotility.equalsIgnoreCase("Abnormal")){ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal" selected="selected">Abnormal</option><%}else{ %>
				<option value="Normal">Normal</option>
				<option value="Abnormal">Abnormal</option><%} %>
			</select>
	
<label class="large">Visual Acuity</label>
<%if(medicalExamMaMoObj.getEyeVisualAcuity() !=null){ %>
<input type="text" name="<%=VISUAL_ACUITY%>" class="auto" tabindex="1" size="20" maxlength="50" 
value="<%=medicalExamMaMoObj.getEyeVisualAcuity() %>"/>
<%}else{ %>
<input type="text" name="<%=VISUAL_ACUITY%>" class="auto" tabindex="1" size="20" maxlength="50" /><%} %>
					

</div>


<div class="clear paddingTop15"></div>
<div class="smallCmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Distant Vision(Standard Test Type)</TH>
		<TH scope="col">RT</TH>
		<TH scope="col">LT</TH>
		<TH scope="col">BOTH</TH>
	</tr>
	<tr>
		<td><label>Without Glasses</label></td>
		<td>
		<%if(medicalExamMaMoObj.getWthoutGlassesRDistant() !=null){ %>
			<input type="text" name="<%=WITHOUT_GLASSES_RT%>" tabindex="1" size="4" maxlength=9 
			value="<%=medicalExamMaMoObj.getWthoutGlassesRDistant() %>" validate="RT Without Glasses,metachar,no"/>
			<%}else{ %>
			<input type="text" name="<%=WITHOUT_GLASSES_RT%>" tabindex="1" size="4" maxlength="9" 
			validate="RT Without Glasses,metachar,no"/><%} %>
		</td>
		<td><%if(medicalExamMaMoObj.getWthoutGlassesLDistant() !=null){ %>
			<input type="text" name="<%=WITHOUT_GLASSES_LT%>" tabindex="1" size="4" maxlength="9" 
			value="<%=medicalExamMaMoObj.getWthoutGlassesLDistant() %>"validate="LT Without Glasses,metachar,no"/>
			<%}else{ %>
			<input type="text" name="<%=WITHOUT_GLASSES_LT%>" tabindex="1" size="4" maxlength="9" 
			validate="LT Without Glasses,metachar,no"/><%} %>
		</td>
		<td><%if(medicalExamMaMoObj.getWthoutGlassesBothDistant() !=null){ %>
			<input type="text" name="<%=WITHOUT_GLASSES_BOTH%>" tabindex="1" size="4" maxlength="9" 
			value="<%=medicalExamMaMoObj.getWthoutGlassesBothDistant() %>"validate="Both without glass,metachar,no"/>
			<%}else{ %>
			<input type="text" name="<%=WITHOUT_GLASSES_BOTH%>" tabindex="1" size="4" maxlength="9"
			validate="Both without glass,metachar,no" /><%} %>
			
		</td>
	</tr>

		<tr>
		<td><label>With Glasses</label></td>
		<td>
		<%if(medicalExamMaMoObj.getWithGlassesRDistant() !=null){ %>
			<input type="text" name="<%=WITH_GLASSES_RT%>" tabindex="1" size="4" maxlength="9" 
			value="<%=medicalExamMaMoObj.getWithGlassesRDistant() %>"validate="RT With Glasses,metachar,no"/>
			<%}else{ %>
			<input type="text" name="<%=WITH_GLASSES_RT%>" tabindex="1" size="4" maxlength="9" 
			validate="RT With Glasses,metachar,no"/><%} %>
		</td>
		<td><%if(medicalExamMaMoObj.getWithGlassesLDistant() !=null){ %>
			<input type="text" name="<%=WITH_GLASSES_LT%>" tabindex="1" size="4" maxlength="9" 
			value="<%=medicalExamMaMoObj.getWithGlassesLDistant() %>"validate="LT With Glasses,metachar,no"/>
			<%}else{ %>
			<input type="text" name="<%=WITH_GLASSES_LT%>" tabindex="1" size="4" maxlength="9" 
			validate="LT With Glasses,metachar,no"/><%} %>
		</td>
		<td><%if(medicalExamMaMoObj.getWithGlassesBothDistant() !=null){ %>
			<input type="text" name="<%=WITH_GLASSES_BOTH%>" tabindex="1" size="4" maxlength="9" 
			value="<%=medicalExamMaMoObj.getWithGlassesBothDistant() %>"
			validate="Both with glass,metachar,no" />
			<%}else{ %>
			<input type="text" name="<%=WITH_GLASSES_BOTH%>" tabindex="1" size="4" maxlength="9" 
			validate="Both with glass,metachar,no" /><%} %>
		</td>
	</tr>


</table>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label class="large">Near Vision (N type in the range 30-50 cm)</label>
<input class="transparent" size="1">
<label class="auto">N</label>
<%if(medicalExamMaMoObj.getNearVision() !=null){ %>
<input type="text" name="<%=NEAR_VISION%>" tabindex="1" maxlength="2" class="auto" size="10" 
		value="<%=medicalExamMaMoObj.getNearVision() %>" validate="NearVision,float,no"/>
<%}else{ %>
<input type="text" name="<%=NEAR_VISION%>" tabindex="1" maxlength="2" class="auto" size="10"
validate="NearVision,float,no"/> 
<%} %>
<label class="unit">cm</label>
<label class="large">Able to Read N<sub>5</sub> Without Glasses/With Glasses</label>

<select name="<%=ABLE_TO_READ_N5%>" class="small">
<%String ableReadB5="";
if(medicalExamMaMoObj.getN5Read() !=null){
ableReadB5=medicalExamMaMoObj.getN5Read();}%>
<%if(ableReadB5.equalsIgnoreCase("y")){ %>
		<option value="y" selected="selected">Yes</option>
		<option value="n">No</option>
		<%}else if(ableReadB5.equalsIgnoreCase("n")){ %>
		<option value="y">Yes</option>
		<option value="n"selected="selected">No</option><%}else{ %>
		<option value="y">Yes</option>
		<option value="n">No</option><%} %>
	</select>
</div>		

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Intermediate Vision (N type at 100 cm)</label>
<input class="transparent" size="1">
<label class="auto">N</label>
<%if(medicalExamMaMoObj.getIntermediateVision() !=null){ %>
<input type="text" name="<%=INTERMEDIATE_VISION%>" tabindex="1" maxlength="2" class="auto" size="10" 
		value="<%=medicalExamMaMoObj.getIntermediateVision() %>" validate="IntermediateVision,float,no"/>
<%}else{ %>
<input type="text" name="<%=INTERMEDIATE_VISION%>" tabindex="1" maxlength="2" class="auto" size="10" 
validate="IntermediateVision,float,no"/>
<%} %>
		<label class="unit">cm</label>
<label class="large">Able to Read N<sub>14</sub> Without Glasses//With Glasses</label>
	<select name="<%=ABLE_TO_READ_N14%>" class="small">
			<%String ableRead14="";
if(medicalExamMaMoObj.getN14Read() !=null){
	ableRead14=medicalExamMaMoObj.getN14Read();}%>
<%if(ableRead14.equalsIgnoreCase("y")){ %>
		<option value="y" selected="selected">Yes</option>
		<option value="n">No</option>
		<%}else if(ableRead14.equalsIgnoreCase("n")){ %>
		<option value="y">Yes</option>
		<option value="n" selected="selected">No</option><%}else{ %>
		<option value="y">Yes</option>
		<option value="n">No</option><%} %>
	</select>
			
</div>


<div class="clear paddingTop15"></div>
<h4>Accommodation (Near Point 30 cm with or Without Glasses</h4>
<div class="Block">
<label class="large">Without Glasses</label>
<%if(medicalExamMaMoObj.getAcomodationWithoutglass() !=null){ %>
<input type="text" name="<%=WITHOUT_GLASSES%>" class="auto" size="10" tabindex="1" maxlength="5" 
value="<%=medicalExamMaMoObj.getAcomodationWithoutglass() %>" validate="AcomodationWithoutglass,float,no"/>
<%}else{ %>
<input type="text" name="<%=WITHOUT_GLASSES%>" class="auto" size="10" tabindex="1" maxlength="5" 
 validate="AcomodationWithoutglass,float,no"/><%} %>
		<label class="unit">cm</label>
<label class="large">With Glasses</label>
<%if(medicalExamMaMoObj.getAcomodationWithglass() !=null){ %>
<input type="text" name="<%=WITH_GLASSES%>" class="auto" size="10" tabindex="1" maxlength="5" 
value="<%=medicalExamMaMoObj.getAcomodationWithglass() %>" validate="AcomodationWithglass,float,no"/>/>
<%}else{ %>
<input type="text" name="<%=WITH_GLASSES%>" class="auto" size="10" tabindex="1" maxlength="5"
 validate="AcomodationWithglass,float,no"/> <%} %>
	<label class="unit">cm</label>
			
</div>

<div class="clear paddingTop15"></div>

<h4>External Ocular Muscles</h4>
<div class="Block">

<label>Power of Convergence </label>

<label class="small">C</label>
<%if(medicalExamMaMoObj.getPowerConvergenceC() !=null){ %>
<input type="text" name="<%=POWER_CONVERGENCE_C%>" class="auto" size="10" tabindex="1" maxlength="5"
 value="<%=medicalExamMaMoObj.getPowerConvergenceC() %>" validate="PowerConvergenceC,float,no" />
 <%}else{ %>
 <input type="text" name="<%=POWER_CONVERGENCE_C%>" class="auto" size="10" tabindex="1" maxlength="5"
 validate="PowerConvergenceC,float,no"/><%} %>
<label class="unit">cm</label>
		
<label class="small">Sc.</label>
<%if(medicalExamMaMoObj.getPowerConvergenceSc() !=null){ %>
<input type="text" name="<%=POWER_CONVERGENCE_SC%>" class="auto" size="10" tabindex="1" maxlength="5"
 value="<%=medicalExamMaMoObj.getPowerConvergenceSc() %>" validate="PowerConvergenceSC,float,no"/>
 <%}else{ %>
 <input type="text" name="<%=POWER_CONVERGENCE_SC%>" class="auto" size="10" tabindex="1" maxlength="5"
 validate="PowerConvergenceSC,float,no"/><%} %>
		<label class="unit">cm</label>
<div class="clear"></div>

<div class="clear paddingTop15"></div>

<label>Result of Cover Test</label>

<label class="small">At 6 </label>
<%if(medicalExamMaMoObj.getResultCoverTestAt6() !=null){ %>
<input type="text" name="<%=RESULT_COVER_TEST_AT6%>" class="auto" size="10" tabindex="1" maxlength="5"
value="<%=medicalExamMaMoObj.getResultCoverTestAt6() %>"validate="ResultCoverTestAt6,float,no"/>
 <%}else{ %>
<input type="text" name="<%=RESULT_COVER_TEST_AT6%>" class="auto" size="10" tabindex="1" maxlength="5" 
validate="ResultCoverTestAt6,float,no"/><%} %>
<label class="unit">m</label>

<label class="small">At 33</label>
<%if(medicalExamMaMoObj.getResultCoverTestAt33() !=null){ %>
<input type="text" name="<%=RESULT_COVER_TEST_AT33%>" class="auto" size="10" tabindex="1" maxlength="5" 
value="<%=medicalExamMaMoObj.getResultCoverTestAt33() %>"validate="ResultCoverTestAt33,float,no"/>
 <%}else{ %>
<input type="text" name="<%=RESULT_COVER_TEST_AT33%>" class="auto" size="10" tabindex="1" maxlength="5" 
validate="ResultCoverTestAt33,float,no"/><%} %>
<label class="unit">cm</label>

<div class="clear"></div>
<div class="clear paddingTop15"></div>
<label>Maddox Rod</label>

<label class="small">At 6 </label>
<%if(medicalExamMaMoObj.getMaddoxRodAt6() !=null){ %>
<input type="text" name="<%=MADDOX_ROD_AT6%>" class="auto" size="10" tabindex="1" maxlength="5" 
value="<%=medicalExamMaMoObj.getMaddoxRodAt6() %>"validate="MaddoxRodAt6,float,no"/>
 <%}else{ %>
<input type="text" name="<%=MADDOX_ROD_AT6%>" class="auto" size="10" tabindex="1" maxlength="5" 
validate="MaddoxRodAt6,float,no"/><%} %>
		<label class="unit">m</label>

<label class="small">At 33</label>
<%if(medicalExamMaMoObj.getMaddoxRodAt33() !=null){ %>
<input type="text" name="<%=MADDOX_ROD_AT33%>" class="auto" size="10" tabindex="1" maxlength="5"
value="<%=medicalExamMaMoObj.getMaddoxRodAt33() %>" validate="MaddoxRodAt33,float,no"/>
<%}else{ %>
<input type="text" name="<%=MADDOX_ROD_AT33%>" class="auto" size="10" tabindex="1" maxlength="5" 
validate="MaddoxRodAt33,float,no"/><%} %>
<label class="unit">cm</label>

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Does the candidate posses glasses?</label>
	<select name="<%=CANDIDATE_POSSES_GLASSES%>">
	<%String possesGlasses="";
	if(medicalExamMaMoObj.getCandidatePossesGlasses() !=null){
	possesGlasses=medicalExamMaMoObj.getCandidatePossesGlasses();}%>
	<%if(possesGlasses.equalsIgnoreCase("y")){ %>
				<option value="y"selected="selected">Yes</option>
				<option value="n">No</option>
				<%}else if(possesGlasses.equalsIgnoreCase("n")){ %>
				<option value="y">Yes</option>
				<option value="n"selected="selected">No</option>
				<%}else {%>
				<option value="y">Yes</option>
				<option value="n">No</option>
				<%} %>
			</select>

</div>
<div class="clear paddingTop15"></div>
<h4>Prescription of glasses, if applicable</h4>
<div class="smallCmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th rowspan="1"></th>
		<th colspan="3">Right</th>
		<th scope="col" colspan="3">Left</th>
		</tr>
	<tr>
		<th></th>
		<TH scope="col">S</TH>
		<TH scope="col">C</TH>
		<TH scope="col">A</TH>
		
		<TH scope="col">S</TH>
		<TH scope="col">C</TH>
		<TH scope="col">A</TH>
	</tr>
	<tr>
	<td>Distant</td>
	<td>
	<%if(medicalExamMaMoObj.getDistantRightS() !=null){ %>
	<input type="text" name="<%=DISTANT_RT_S%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getDistantRightS() %>" validate="DistantRightS,int,no"/>
	<%}else{ %><input type="text" name="<%=DISTANT_RT_S%>" tabindex="1" size="8" maxlength="5"
	validate="DistantRightS,float,no" /><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getDistantRightC() !=null){ %>
	<input type="text" name="<%=DISTANT_RT_C%>" tabindex="1" size="8" maxlength="5" 
		value="<%=medicalExamMaMoObj.getDistantRightC() %>"validate="DistantRightC,int,no"/>
	<%}else{ %>
	<input type="text" name="<%=DISTANT_RT_C%>" tabindex="1" size="8" maxlength="5"
	validate="DistantRightC,float,no" /><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getDistantRightA() !=null){ %>
	<input type="text" name="<%=DISTANT_RT_A%>" tabindex="1" size="8" maxlength="5" 
	validate="DistantRightA,float,no"value="<%=medicalExamMaMoObj.getDistantRightA() %>"/>
	<%}else{ %>
	<input type="text" name="<%=DISTANT_RT_A%>" tabindex="1" size="8" maxlength="5" 
	validate="DistantRightA,float,no"/><%} %></td>
	
	
	<td>
	<%if(medicalExamMaMoObj.getDistantLeftS() !=null){ %>
	<input type="text" name="<%=DISTANT_LT_S%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getDistantLeftS() %>"validate="DistantLeftS,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=DISTANT_LT_S%>" tabindex="1" size="8" maxlength="5"
	 validate="DistantLeftSfloat,no"/><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getDistantLeftC() !=null){ %>
	<input type="text" name="<%=DISTANT_LT_C%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getDistantLeftC() %>"validate="DistantLeftC,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=DISTANT_LT_C%>" tabindex="1" size="8" maxlength="5"
	validate="DistantLeftC,float,no" /><%} %></td>
	
	<td>
	<%if(medicalExamMaMoObj.getDistantLeftA() !=null){ %>
	<input type="text" name="<%=DISTANT_LT_A%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getDistantLeftA() %>"validate="DistantLeftA,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=DISTANT_LT_A%>" tabindex="1" size="8" maxlength="5" 
	validate="DistantLeftA,float,no"/><%} %></td>
	
	</tr>
	<tr>
	<td>Near</td>
	<td>
	<%if(medicalExamMaMoObj.getNearRightS() !=null){ %>
	<input type="text" name="<%=NEAR_RT_S%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getNearRightS() %>" validate="NearRightS,float,no"/>
	<%}else{ %><input type="text" name="<%=NEAR_RT_S%>" tabindex="1" size="8" maxlength="5" 
	validate="NearRightS,float,no"/><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getNearRightC() !=null){ %>
	<input type="text" name="<%=NEAR_RT_C%>" tabindex="1" size="8" maxlength="5" 
		value="<%=medicalExamMaMoObj.getNearRightC() %>"validate="NearRightC,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=NEAR_RT_C%>" tabindex="1" size="8" maxlength="5" validate="NearRightC,float,no"/><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getNearRightA() !=null){ %>
	<input type="text" name="<%=NEAR_RT_A%>" tabindex="1" size="8" maxlength="5"
		 value="<%=medicalExamMaMoObj.getNearRightA() %>"validate="NearRightA,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=NEAR_RT_A%>" tabindex="1" size="8" maxlength="5" validate="NearRightA,float,no"/><%} %></td>
	
	
	<td>
	<%if(medicalExamMaMoObj.getNearLeftS() !=null){ %>
	<input type="text" name="<%=NEAR_LT_S%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getNearLeftS() %>"validate="NeaLeftS,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=NEAR_LT_S%>" tabindex="1" size="8" maxlength="5" validate="NeaLeftS,float,no"/><%} %></td>
	<td>
	<%if(medicalExamMaMoObj.getNearLeftC() !=null){ %>
	<input type="text" name="<%=NEAR_LT_C%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getNearLeftC() %>"validate="NearLeftC,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=NEAR_LT_C%>" tabindex="1" size="8" maxlength="5" validate="NearLeftC,float,no"/><%} %></td>
	
	<td>
	<%if(medicalExamMaMoObj.getNearLeftA() !=null){ %>
	<input type="text" name="<%=NEAR_LT_A%>" tabindex="1" size="8" maxlength="5" 
	value="<%=medicalExamMaMoObj.getNearLeftA() %>"validate="NearLeftA,float,no"/>
	<%}else{ %>
	<input type="text" name="<%=NEAR_LT_A%>" tabindex="1" size="8" maxlength="5" validate="NearLeftA,float,no"/><%} %></td>
	
	</tr>
	
</table>

</div>

</div>
<div id="country3" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Is it normal when tested by pseudoischromatic (Ishihra/Japanese) type plates?</label>
	<select name="<%=PSEUDOISCHROMATIC %>" >
	<%String  pseudoischromatic="";
	if(medicalExamMaMoObj.getEyePseudoischromatic() !=null){
			pseudoischromatic=medicalExamMaMoObj.getEyePseudoischromatic();}%>
			<%if(pseudoischromatic.equalsIgnoreCase("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<option value="n">No</option>
				<%}else if(pseudoischromatic.equalsIgnoreCase("n")){ %>
				<option value="y" >Yes</option>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<option value="n">No</option>
				<%} %>
			</select>
<div class="clear"></div>
<label class="large">If abnormal, is the any difficulty in distinguishing readily aviation coloured lights displayed by colour lantern?</label>
	<select name="<%=ABNORMAL_TEST_RESULT%>" >
	<%String  eyeAbnormal="";
	if(medicalExamMaMoObj.getEyeDistinguishingReadily() !=null){
		eyeAbnormal=medicalExamMaMoObj.getEyeDistinguishingReadily();}%>
	<%if(eyeAbnormal.equalsIgnoreCase("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<option value="n">No</option>
				<%}else if(eyeAbnormal.equalsIgnoreCase("n")){ %>
				<option value="y" >Yes</option>
				<option value="n" selected="selected">No</option><%}else{ %>
				<option value="y">Yes</option>
				<option value="n">No</option>
				<%} %>
			</select>

<div class="clear"></div>
<label class="large">Remarks</label>
<%if(medicalExamMaMoObj.getEyeRemarks() !=null){ %>
<textarea rows="" cols="60"	name="<%=COLOUR_REMARKS %>" class="auto" onkeyup="chkLength(this,100);" >
<%=medicalExamMaMoObj.getEyeRemarks() %></textarea>
<%}else{ %>
<textarea rows="" cols="60"	name="<%=COLOUR_REMARKS %>" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%} %>
</div>
</div>
<div id="country4" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>External Ears</h4>

<div class="Block">
<label>Tympanum</label>
	<select name="<%=TYMPANUM_EXTERNAL_EARS%>" class="small" id="tympanumExternalEars" onchange="showTympanumExternalEars();">
	<% String externalTympanum="";
	if(medicalExamMaMoObj.getEntExternalTympanum() !=null){ 
		externalTympanum=medicalExamMaMoObj.getEntExternalTympanum();
	}
	%><%if(externalTympanum.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(externalTympanum.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

<div id="tympanumExternalEarsDiv" style="display: none" >
<label>Eustachean Tube</label>
	<select name="<%=EUSTACHEAN_TUBE_EXTERNAL%>" class="small">
	<% String EustacheanTube="";
	if(medicalExamMaMoObj.getExternalEustacheanTube() !=null){ 
		EustacheanTube=medicalExamMaMoObj.getExternalEustacheanTube();
	}
	%><%if(EustacheanTube.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(EustacheanTube.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>
	
	<label>Mastoid</label>
	<select name="<%=MASTOID_EXTERNAL_EARS%>" class="small">
	<% String Mastoid="";
	if(medicalExamMaMoObj.getEntMastoid() !=null){ 
		Mastoid=medicalExamMaMoObj.getEntMastoid();
	}
	%><%if(Mastoid.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(Mastoid.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Middle Ears</h4>

<div class="Block">
<label>Tympanum</label>
	<select name="<%=TYMPANUM_MIDDLE_EARS%>" class="small">
		<% String middleTympanum="";
	if(medicalExamMaMoObj.getEntMiddleTympanum() !=null){ 
		middleTympanum=medicalExamMaMoObj.getEntMiddleTympanum();
	}
	%><%if(middleTympanum.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(middleTympanum.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

<label>Eustachean Tube</label>
	<select name="<%=EUSTACHEAN_TUBE_MIDDLE%>" class="small">
	<% String midEustacheanTube="";
	if(medicalExamMaMoObj.getMiddleEustacheanTube() !=null){ 
		midEustacheanTube=medicalExamMaMoObj.getMiddleEustacheanTube();
	}
	%><%if(midEustacheanTube.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(midEustacheanTube.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>
	
<label>Mastoid</label>
<select name="<%=MASTOID_MIDDLE_EARS%>" class="small">
		<% String midMastoid="";
	if(medicalExamMaMoObj.getEntMastoid() !=null){ 
		midMastoid=medicalExamMaMoObj.getEntMastoid();
	}
	%><%if(midMastoid.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(midMastoid.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

</div>
<div class="clear paddingTop15"></div>
<h4>Internal Ears</h4>


<div class="Block">
<label>Cochlear Functions</label>
	<select name="<%=COCHLEAR_FUNCTIONS%>" class="small">
		<% String Cochlear="";
	if(medicalExamMaMoObj.getEntCochlear() !=null){ 
		Cochlear=medicalExamMaMoObj.getEntCochlear();
	}
	%><%if(Cochlear.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(Cochlear.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>


<label>Vestibular Functions</label>
	<select name="<%=VESTIBULAR_FUNCTIONS%>" class="small">
		<% String Vestibular="";
	if(medicalExamMaMoObj.getEntVestibular() !=null){ 
		Vestibular=medicalExamMaMoObj.getEntVestibular();
	}
	%><%if(Vestibular.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(Vestibular.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Nose & Paranasal Sinuses (Airway,Septum,Polyp)</label>
	<select name="<%=NOSE_PARANASAL_SINUSES%>" class="small">
		<% String NoseParanasal="";
	if(medicalExamMaMoObj.getEntNoseParanasal() !=null){ 
		NoseParanasal=medicalExamMaMoObj.getEntNoseParanasal();
	}
	%><%if(NoseParanasal.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(NoseParanasal.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>


<label>Mouth,Teeth,Throat</label>
	<select name="<%=MOUTH_TEETH_THROAT%>" class="small">
		<% String mouthTeethThroat="";
	if(medicalExamMaMoObj.getMouthTeethThroat() !=null){ 
		mouthTeethThroat=medicalExamMaMoObj.getMouthTeethThroat();
	}
	%><%if(mouthTeethThroat.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(mouthTeethThroat.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

<label>Speech</label>
	<select name="<%=SPEECH%>" class="small">
		<% String speech="";
	if(medicalExamMaMoObj.getSpeech() !=null){ 
		speech=medicalExamMaMoObj.getEntExternalTympanum();
	}
	%><%if(speech.equalsIgnoreCase("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(speech.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal" selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option><%} %>
	</select>

</div>

<div class="clear paddingTop15"></div>
<h4>Hearing</h4>

<div class="tableAutoNoHeightNoBorder">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th rowspan="1"></th>
		<th>CV(cm)</th>
		<th >FWV(cm)</th>
	</tr>
	<tr>
		<td><label>RT Ear</label></td>
		<td>
		<%if(medicalExamMaMoObj.getHearRtCv() !=null){ %>
		<input type="text" name="<%=CV_RT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearRtCv() %>" validate="CV RT Ear,float,no"/>
		<%}else{ %><input type="text" name="<%=CV_RT%>" class="auto" size="10" tabindex="1" maxlength="5"
		validate="CV RT Ear,float,no" />
		<%} %>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getHearRtFwv() !=null){ %>
		<input type="text" name="<%=FWV_RT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearRtFwv() %>" validate="FWV RT Ear,float,no"/><%}else{ %>
		<input type="text" name="<%=FWV_RT%>" class="auto" size="10" tabindex="1" maxlength="5"
		validate="FWV RT Ear,float,no" />
		<%} %>
		</td>
	</tr>
	
	<tr>
		<td><label>LT Ear</label></td>
		<td>
		<%if(medicalExamMaMoObj.getHearLtCv() !=null){ %>
		<input type="text" name="<%=CV_LT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearLtCv() %>" validate="CV LT Ear,float,no"/>
		<%}else{ %>
		<input type="text" name="<%=CV_LT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="CV LT Ear,float,no"/><%} %>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getHearLtFwv() !=null){ %>
		<input type="text" name="<%=FWV_LT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearLtFwv() %>" validate="FWV LT Ear,float,no"/>
		<%}else{ %>
		<input type="text" name="<%=FWV_LT%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="FWV LT Ear,float,no"/>
		<%} %>
		</td>
	</tr>
	
	<tr>
		<td><label>BOTH</label></td>
		<td><%if(medicalExamMaMoObj.getHearLtBoth() !=null){ %>
		<input type="text" name="<%=CV_BOTH%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearLtBoth()%>"validate="CV Both Ear,float,no"/>
		<%}else{ %>
		<input type="text" name="<%=CV_BOTH%>" class="auto" size="10" tabindex="1" maxlength="5" 
			validate="CV Both Ear,float,no"/><%} %>
		</td>
		<td>
		<%if(medicalExamMaMoObj.getHearRtBoth() !=null){ %>
		<input type="text" name="<%=FWV_BOTH%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getHearRtBoth()%>"validate="FWV Both Ear,float,no"/>
		<%}else{ %>
		<input type="text" name="<%=FWV_BOTH%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="FWV Both Ear,float,no"/><%} %>
		</td>
	</tr>
	</table>
</div>

<div class="tableAutoNoHeightNoBorder">
<table border="0" class="small" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th colspan="3">TUNING FORK TESTS(512)</th>		
	</tr>
	<tr>
		<th>RT Ear</th>
		<th>Test</th>
		<th>LT Ear</th>
		
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getTunningRtRinnie() !=null){ %>
		<input type="text" name="<%=RT_EAR_RINNE%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getTunningRtRinnie() %>" validate="TunningRt,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_RINNE%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningRt,metachar,no"/><%} %>
		</td>
		<td><label>Rinne's</label></td>
		<td>
		<%if(medicalExamMaMoObj.getTunningLtRinnie() !=null){ %>
		<input type="text" name="<%=LT_EAR_RINNE%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getTunningLtRinnie() %>"validate="TunningLt,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_RINNE%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningLt,metachar,no"/><%} %>
		</td>
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getTunningRtWebe() !=null){ %>
		<input type="text" name="<%=RT_EAR_WEBER%>" class="auto" size="10" tabindex="1" maxlength="5"
		value="<%=medicalExamMaMoObj.getTunningRtWebe() %>" validate="TunningRtWeber,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_WEBER%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningRtWeber,metachar,no"/><%} %>
		</td>
		<td><label>Weber's</label></td>
		<td>
		<%if(medicalExamMaMoObj.getTunningLtWebe() !=null){ %>
		<input type="text" name="<%=LT_EAR_WEBER%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getTunningLtWebe() %>"validate="TunningLtWeber,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_WEBER%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningLtWeber,metachar,no"/><%} %>
		</td>
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getTunningRtAbc() !=null){ %>
		<input type="text" name="<%=RT_ABC%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getTunningRtAbc() %>"validate="TunningRtABC,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_ABC%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningRtABC,metachar,no"/><%} %>
		</td>
		<td><label>ABC</label></td>
		<td>
		<%if(medicalExamMaMoObj.getTunningLtAbc() !=null){ %>
		<input type="text" name="<%=LT_ABC%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getTunningLtAbc() %>"validate="TunningLtABC,metachar,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_ABC%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="TunningLtABC,metachar,no"/>
		<%} %>
		</td>
	</tr>
	
	</table>
</div>



<div class="clear paddingTop15"></div>
<h4>Audiometry</h4>
<div class="tableAutoNoHeightNoBorder">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	
	<tr>
		<th>RT Ear(dB loss)</th>
		<th>Frequencies(Hz)</th>
		<th>LT Ear(dB loss)</th>
		
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getAudioRt250() !=null){ %>
		<input type="text" name="<%=RT_EAR_250%>" class="auto" size="10" tabindex="1" maxlength="5" 
		 value="<%=medicalExamMaMoObj.getAudioRt250() %>" validate="RT Ear(dB loss 250),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_250%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="RT Ear(dB loss 250),float,no"/><%} %>
		</td>
		<td><label>250</label></td>
		<td>
		<%if(medicalExamMaMoObj.getAudioLt250() !=null){ %>
		<input type="text" name="<%=LT_EAR_250%>" class="auto" size="10" tabindex="1" maxlength="5" 
		 value="<%=medicalExamMaMoObj.getAudioLt250() %>"validate="LT Ear(dB loss 250),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_250%>" class="auto" size="10" tabindex="1" maxlength="5"
		validate="LT Ear(dB loss 250),float,no" /><%} %>
		</td>
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getAudioRt500() !=null){ %>
		<input type="text" name="<%=RT_EAR_500%>" class="auto" size="10" tabindex="1" maxlength="5"
		value="<%=medicalExamMaMoObj.getAudioRt500() %>" validate="RT Ear(dB loss 500),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_500%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="RT Ear(dB loss 500),float,no"/><%} %>
		</td>
		<td><label>500</label></td>
		<td>
		<%if(medicalExamMaMoObj.getAudioLt500() !=null){ %>
		<input type="text" name="<%=LT_EAR_500%>" class="auto" size="10" tabindex="1" maxlength="5"
		value="<%=medicalExamMaMoObj.getAudioLt500() %>" validate="LT Ear(dB loss 500),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_500%>" class="auto" size="10" tabindex="1" maxlength="5"
		validate="LT Ear(dB loss 500),float,no" /><%} %>
		</td>
	</tr>
	<tr>
		<td>
		<%if(medicalExamMaMoObj.getAudioRt1000() !=null){ %>
		<input type="text" name="<%=RT_EAR_1000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioRt1000() %>" validate="RT Ear(dB loss 1000),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_1000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="RT Ear(dB loss 1000),float,no"/><%} %>
		</td>
		<td><label>1000</label></td>
		<td>
		<%if(medicalExamMaMoObj.getAudioLt1000() !=null){ %>
		<input type="text" name="<%=LT_EAR_1000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioLt1000()%>" validate="LT Ear(dB loss 1000),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_1000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="LT Ear(dB loss 1000),float,no"/><%} %>
		</td>
	</tr>
		<tr>
		<td>
		<%if(medicalExamMaMoObj.getAudioRt2000() !=null){ %>
		<input type="text" name="<%=RT_EAR_2000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioRt2000() %>" validate="RT Ear(dB loss 2000),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_2000%>" class="auto" size="10" tabindex="1" maxlength="5"
		validate="RT Ear(dB loss 2000),float,no" /><%} %>
		</td>
		<td><label>2000</label></td>
		<td>
		<%if(medicalExamMaMoObj.getAudioLt2000() !=null){ %>
		<input type="text" name="<%=LT_EAR_2000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioLt2000() %>" validate="LT Ear(dB loss 2000),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=LT_EAR_2000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="LT Ear(dB loss 2000),float,no"/><%} %>
		</td>
	</tr>
		<tr>
		<td>
		<%if(medicalExamMaMoObj.getAudioRt3000() !=null){ %>
		<input type="text" name="<%=RT_EAR_3000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioRt3000() %>" validate="RT Ear(dB loss 3000),float,no"/>
		<%}else{ %>
		<input type="text" name="<%=RT_EAR_3000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		 validate="RT Ear(dB loss 3000),float,no"/><%} %>
		</td>
		<td><label>3000</label></td>
		<td>
		<%if(medicalExamMaMoObj.getAudioLt3000() !=null){ %>
		<input type="text" name="<%=LT_EAR_3000%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getAudioLt3000() %>" validate="LT Ear(dB loss 3000),float,no"/>
		<%}else{ %>
			<input type="text" name="<%=LT_EAR_3000%>" class="auto" size="10" tabindex="1" maxlength="5" 
			 validate="RT Ear(dB loss 3000),float,no"/><%} %>
		</td>
	</tr>
	
	</table>
</div>


<div class="tableAutoNoHeightNoBorder">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th colspan="3">Speech Intelligiblity Test Vs Back Ground 70 dB Noise(only if applicable)</th>
		
	</tr>
	<tr>
		<th></th>
		<th>%Score</th>
		<th>Result</th>
	</tr>
	<tr>
		<td><label>RT Ear</label></td>
		<td>
		<%if(medicalExamMaMoObj.getSpeechIntelligiblRt() !=null){ %>
		<input type="text" name="<%=SCORE_RT_EAR%>" class="auto" size="10" tabindex="1" maxlength="5" 
		value="<%=medicalExamMaMoObj.getSpeechIntelligiblRt() %>" validate="RT Ear Score,metachar,no"/>
		<%}else{ %><input type="text" name="<%=SCORE_RT_EAR%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="RT Ear Score,metachar,no"/><%} %>
		</td>
		<td>
				<select name="<%=RESULT_RT_EAR%>" >
		<% 
		 String SpeechRtResult="";
		if(medicalExamMaMoObj.getSpeechRtResult() !=null){
			SpeechRtResult=medicalExamMaMoObj.getSpeechRtResult();
		}	%>
		<%if(SpeechRtResult.equalsIgnoreCase("Normal")){ %>
		<option value="Normal"selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(SpeechRtResult.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal"selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%} %>
	</select>
			</td>
	</tr>
	
	<tr>
		<td><label>LT Ear</label></td>
		<td>
		<%if(medicalExamMaMoObj.getSpeechIntelligiblLt() !=null){ %>
		<input type="text" name="<%=SCORE_LT_EAR%>" class="auto" size="10" tabindex="1" maxlength="5"
		value="<%=medicalExamMaMoObj.getSpeechIntelligiblLt() %>" validate="LT Ear Score,metachar,no"/>
		<%}else{ %><input type="text" name="<%=SCORE_LT_EAR%>" class="auto" size="10" tabindex="1" maxlength="5" 
		validate="LT Ear Score,metachar,no"/><%} %>
		</td>
		<td>
		<select name="<%=RESULT_LT_EAR%>">
		<% 
		 String SpeechLtResult="";
		if(medicalExamMaMoObj.getSpeechLtResult() !=null){
			SpeechLtResult=medicalExamMaMoObj.getSpeechLtResult();
		}	%>
		<%if(SpeechLtResult.equalsIgnoreCase("Normal")){ %>
		<option value="Normal"selected="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%}else if(SpeechLtResult.equalsIgnoreCase("Abnormal")){ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal"selected="selected">Abnormal</option>
		<%}else{ %>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<%} %>
	</select>
	</td>
	</tr>
	</table>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Remarks</label>
<%if(medicalExamMaMoObj.getRemarksEar() !=null){ %>
<textarea rows="" cols="60"	name="<%=REMARKS_ENT %>" class="auto" onkeyup="chkLength(this,50);" >
<%=medicalExamMaMoObj.getRemarksEar() %></textarea>
<%}else{ %>
<textarea rows="" cols="60"	name="<%=REMARKS_ENT %>" class="auto" onkeyup="chkLength(this,50);"></textarea><%} %>
</div>
</div>
<div class="clear"></div>

<%if(medicalExamMaMoObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="buttonBig" value="Update"	onClick="submitForm('civilAviationMedExam','aviationMedicine?method=updateAviationMA&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="buttonBig" name="Button" tabindex="1">
<% }%>
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
<input tabindex="1" name="Button"	type="button" class="buttonBig" value="Validate"	
onClick="submitForm('civilAviationMedExam','aviationMedicine?method=updateAviationMA&data=validate&Labresult=<%=Labresult.trim() %>');" />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>" />
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>" />
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>" />
</div>



<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>

</form>
<script type="text/javascript">

function showTympanumExternalEars(){
	if(document.getElementById('tympanumExternalEars').value == 'Abnormal'){
	  	document.getElementById("tympanumExternalEarsDiv").style.display='inline';
	}else{
		document.getElementById("tympanumExternalEarsDiv").style.display='none';
	}
}

function fileUploadWindowInvestigation(rowVal)
{
	var avExamId='<%=medicalExamMaMoObj.getId()%>';
 	if(avExamId=='0')
 	{
 	 	alert("file can not be uploaded; refferred to MH");
 	 	return false;
 	}else{
 		var val=document.getElementById('chargeCodeName'+rowVal).value;
 	 	var index1 = val.lastIndexOf("[");
 	 	var index2 = val.lastIndexOf("]");
 	 	index1++;

 	var invest_id = val.substring(index1,index2);
 		var url="/hms/hms/aviationMedicine?method=displayFileUploadInvestigation&hinId=<%=medicalExamMaMoObj.getVisit().getHin().getId()%>&hinNo=<%=medicalExamMaMoObj.getVisit().getHin().getHinNo() %>&invest_id="+invest_id+"&avExamId=<%=medicalExamMaMoObj.getId()%>";
 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	}


}


function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
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

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration,'parent');}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';

	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);

	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});
	  var sel = document.createElement('input');
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name = 'investigationReferToMH' + iteration;
	  e1.id = 'investigationReferToMH' + iteration;
	  e1.value='n';
	  e1.className = 'radioAuto';
	  e1.setAttribute('tabindex','1');
	  e1.onclick = function(){checkForInvestigationMH(iteration)};

	  cellRight1.appendChild(e1);

	  var cellRight1 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'result1' + iteration;
	  e2.id = 'result1' + iteration;
	  e2.size = '65';
	  e2.setAttribute('readonly','readonly');
	  e2.setAttribute('maxlength', 20);
	  e2.setAttribute('tabindex','1');
  cellRight1.appendChild(e2);

	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);
	  var dgOrderDt = document.createElement('input');
	  dgOrderDt.type = 'hidden';
	  dgOrderDt.name='dgOrderdtId'+iteration;
	  dgOrderDt.id='dgOrderdtId'+iteration
	  dgOrderDt.size = '10';
	  dgOrderDt.value = '0';
	  dgOrderDt.setAttribute('tabindex','1');
	  cellRight0.appendChild(dgOrderDt);


	  var patientInvDt = document.createElement('input');
	  patientInvDt.type = 'hidden';
	  patientInvDt.name='patientInvestigationdetailsId'+iteration;
	  patientInvDt.id='patientInvestigationdetailsId'+iteration
	  patientInvDt.size = '10';
	  patientInvDt.value = '0';
	  patientInvDt.setAttribute('tabindex','1');
	  cellRight0.appendChild(patientInvDt);
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='qty'+iteration;
	  e3.id='qty'+iteration
	  e3.size='10';
	  e3.setAttribute('tabindex','1');
	  cellRight0.appendChild(e3);

	  var cellRight1 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'button';
	  e4.name='uploadReport'+iteration;;
	  e4.id='uploadReport'+iteration;;
	  e4.value='UPLOAD REPORT';
	  e4.style.display='none';
	  e4.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
	  cellRight1.appendChild(e4);

	 var cellRight1 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e4);

	  var cellRight2 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('onClick','removeRowForInvestigation(this);');
	  cellRight2.appendChild(e5);

	}
function removeRowForInvestigation(obj)

	{
	  var tbl = document.getElementById('investigationGrid');
	  document.getElementById('investigationDataStatus').value="yes";
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
		  var i=obj.parentNode.parentNode.rowIndex;
		  tbl.deleteRow(i);
		  	//tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }

	  var pid = document.getElementById('patientInvestigationdetailsId'+lastRow ).value;

    var dv=document.getElementById('deleatedValue').value;
    var val;

    if(dv=="")
    {
  	  val=pid+",";
	  document.getElementById('deleatedValue').value = val;
    }else{
  	  val=dv+pid+","
  	  document.getElementById('deleatedValue').value = val;
    }

	  var pid1 = document.getElementById('dgOrderdtId'+lastRow ).value;

    var dv1=document.getElementById('deleatedorderid').value;
    var val1;

    if(dv1=="")
    {

  	  val1=pid1+",";
	  document.getElementById('deleatedorderid').value = val1;
    }else{
  	  val1=dv1+pid1+","
  	  document.getElementById('deleatedorderid').value = val1;
    }
	  }

function showCreateInvestigationTemplate(){

    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");


}
function submitdata()
{

	var charge=document.getElementById("chargeCodeName1").value;
 if(charge=="")
 {
  alert("Please Select Test Name");
 }else{
 	submitForm('civilAviationMedExam','aviationMedicine?method=submitAviationMA');
 }

	//{submitForm('medicalBoardMAForm16','medicalBoard?method=addMedicalBoardInit')}
}
function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('civilAviationMedExam','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}
 }
function openPopupForPatientInvestigation(visitNo,hinId){

	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
 newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
 }else{
   alert("This is Patient's First Visit. ")
 }
}
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


