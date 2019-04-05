<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>
<script type="text/javascript">

animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		int orderhdId = 0;
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			
	List opdObgList= new ArrayList();
	if(map.get("opdObgList") != null){
		opdObgList=(List)map.get("opdObgList");
	}	
	List<MasOccupation> masOccupationList= new ArrayList<MasOccupation>();
	if(map.get("masOccupationList") != null){
		masOccupationList=(List)map.get("masOccupationList");
	}
	List<MasReligion> masReligionList= new ArrayList<MasReligion>();
	if(map.get("masReligionList") != null){
		masReligionList=(List)map.get("masReligionList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
	String patientName="";
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
	 
	
	 if(map.get("orderhdId") != null)
	 {
	 orderhdId=(Integer)map.get("orderhdId");

	 }
	 
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}
		String visitDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
		if(map.get("medicalList") != null){
			medicalList=(List)map.get("medicalList");
			}
		
		if(medicalList.size()>0)
		{
			meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
		}
%>


<!--main content placeholder starts here-->


<div id="contentHolder">
<form name="OBG" action="" method="post">


<h4>Service Personnel Details</h4>
<div class="clear"></div>
<div class="Block">
<% 

if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self"))
{ %>
<label>Ser No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label	>Name</label> 
<%if(visit.getHin() != null){
	
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<div class="clear"></div>
<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label >Marital Status</label> 
<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getSrBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<label >Med Cat</label>
<%if(meddata.getPresentMedicalCategory() != null){ %>
<label class="value"><%=meddata.getPresentMedicalCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label>Med Exam/Date Board</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Med Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Medication</label>
<%if(meddata.getInstructionByPresident() != null){ %>
<label class="value"><%=meddata.getInstructionByPresident() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label >Allergies</label>
<%if(visit.getHin() != null){ %>
<label class="value">&nbsp;</label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label >Visit No. </label> 

<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 <% }else{%>
<label	>Patient Name</label> 
<%if(visit.getHin() != null){
	
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label>Ser No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value"></label> <%} %>

 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
 
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
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

<label >Allergies</label>
<%if(visit.getHin() != null){ %>
<label class="value">&nbsp;</label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
<label >Visit No. </label> 

<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>

<% }%>
<div class="clear"></div>
</div>
<div class="Clear"></div>
<!--Block one Ends--> <%
if (opdObgList.size() > 0)
	{
	Iterator itr = opdObgList.iterator();
	while (itr.hasNext()) 
	{
		OpdObg opdObg = (OpdObg) itr.next();
 %>


<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitleFixed">SOCIOECONOMIC HISTORY <a
	href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide0">
<div class="blockFrame">
<label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>


<div class="Clear"></div>
<label>Education</label><label></label> <input
	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text"> <label></label>
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>Religion<span></span></label><label></label> <select
	name="<%=RELIGION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label></label> <select name="<%=RELIGION_HUSBAND%>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="Clear"></div>

<label>Occupation<span></span></label><label></label> <select
	name="<%=OCCUPATION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 }

         %>
</select> <label></label> <select name="<%=OCCUPATION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="Clear"></div>


<label>Accommodation Type</label><label></label> <input
	name="<%=ACCOMMODATION_TYPE %>" maxlength="15" type="text"> 
	<label>Privacy</label>

<label>Yes</label> <input name="<%=PRIVACY %>"
	type="radio" class="radioCheck" /> <label>NO</label> <input
	name="<%=PRIVACY %>" type="radio" class="radioCheck" /></div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitleFixed">COMPLAINTS <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<label>Infertility</label> <input name="" type="text"
	style="visibility: hidden;" /> <label>Primary: Yrs</label> <input
	name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text">
<label>Secondary: Yrs</label> <input
	name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5" type="text">

<div class="Clear"></div>
<label>Hypomenorrohea</label> <input name="<%=HYPOMENRROHEA %>"
	maxlength="5" type="text" /> <label>Yrs</label> <input
	name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text"> <label>Oligomenorrhoea:Yrs</label>
<input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text">
<div class="Clear"></div>
<label> Galactorrhoea</label> <input name="<%=GALACTORRHOEA %>"
	maxlength="15" type="text" /> <label>Yrs</label> <input
	name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text"> <label>Hirsutism
: Yrs</label> <input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text">
<div class="Clear"></div>
<label>Leucorrhoea</label> <input name="<%=LEUCORRHOEA %>"
	maxlength="15" type="text" /> <label></label> <input name=""
	type="text" style="visibility: hidden;" /> <label>Pruritis
Valve</label> <input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text">
<div class="Clear"></div>

<label>Backaches</label> <input name="<%=BACKACHES %>" maxlength="15"
	type="text" /> <label></label> <input name="Input" type="text"
	style="visibility: hidden;" /> <label>Dysmenorrhoea</label> <input
	name="<%=DYSMENORRHOEA %>" maxlength="15" type="text">
<div class="Clear"></div>

</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitleFixed">MENSTRUALl <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label>Menarche YRS:</label> <input name="<%=MENARCHE_YRS %>"
	maxlength="5" type="text"> <label>Past MC</label> <input
	name="<%=PAST_MC %>" maxlength="15" type="text"> <label>Present
MC</label> <input name="<%=PRESENT_MC %>" maxlength="15" type="text">
<div class="Clear"></div>

<label>LMP</label> <input name="<%=LMP %>" maxlength="15" type="text">
<label>PMP1</label> <input name="<%=PMP_ONE %>" maxlength="15"
	type="text"> <label>PMP2</label> <input name="<%=PMP_TWO %>"
	maxlength="15" type="text">
<div class="Clear"></div>
</div>
</div>

<!--Block Four Ends-->
<div class="division"></div>
<!--Block Five Ends-->

<div class="blockTitleFixed">PAST SURGICAL HISTORY <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	maxlength="20" type="text"> <label></label> <label>Tubal
Surgery</label> <input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text">
<div class="Clear"></div>
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	maxlength="20" type="text"> <label></label> <label>Operative
Scopy</label> <input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text">
<div class="Clear"></div>
<%
System.out.println("opdObg.getId()------------- "+opdObg.getId());
%>
</div>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Five Ends--> <%}}else{ %>





<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitleFixed">SOCIOECONOMIC HISTORY <a
	href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide0">
<div class="blockFrame">
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>Education</label><label></label> <input
	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text"> <label></label>
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>Religion<span></span></label><label></label> <select
	name="<%=RELIGION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label></label> <select name="<%=RELIGION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="Clear"></div>

<label>Occupation<span></span></label><label></label> <select
	name="<%=OCCUPATION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label></label> <select name="<%=OCCUPATION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="Clear"></div>


<label>Accommodation Type</label><label></label> <input
	<%=ACCOMMODATION_TYPE %> maxlength="15" type="text"> <label>Privacy</label>

<label class="valueNoWidth">Yes</label> <input name="<%=PRIVACY %>"
	type="radio" value="y" class="radio" /> <label class="valueNoWidth">NO</label>
<input name="<%=PRIVACY %>" type="radio" value="n" class="radio" /></div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitleFixed">COMPLAINTS <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<label>Infertility</label> <input name="" type="text"
	style="visibility: hidden;" /> <label>Primary: Yrs</label> <input
	name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text">
<label>Secondary: Yrs</label> <input
	name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5" type="text">

<div class="Clear"></div>
<label>Hypomenorrohea</label> <input name="<%=HYPOMENRROHEA %>"
	maxlength="5" type="text" /> <label>Yrs</label> <input
	name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text"> <label>Oligomenorrhoea:
Yrs</label> <input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text">
<div class="Clear"></div>
<label> Galactorrhoea</label> <input name="<%=GALACTORRHOEA %>"
	maxlength="5" type="text" /> <label>Yrs</label> <input
	name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text"> <label>Hirsutism
: Yrs</label> <input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text">
<div class="Clear"></div>
<label>Leucorrhoea</label> <input name="<%=LEUCORRHOEA %>"
	maxlength="15" type="text" /> <label></label> <input name=""
	type="text" style="visibility: hidden;" /> <label>Pruritis
Valve</label> <input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text">
<div class="Clear"></div>

<label>Backaches</label> <input name="<%=BACKACHES %>" maxlength="15"
	type="text" /> <label></label> <input name="" type="text"
	style="visibility: hidden;" /> <label>Dysmenorrhoea</label> <input
	name="<%=DYSMENORRHOEA %>" maxlength="15" type="text">
<div class="Clear"></div>

</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitleFixed">MENSTRUALl <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label>Menarche YRS:</label> <input name="<%=MENARCHE_YRS %>"
	maxlength="5" type="text"> <label>Past MC</label> <input
	name="<%=PAST_MC %>" maxlength="15" type="text"> <label>Present
MC</label> <input name="<%=PRESENT_MC %>" maxlength="15" type="text">
<div class="Clear"></div>

<label>LMP</label> <input name="<%=LMP %>" maxlength="15" type="text">
<label>PMP1</label> <input name="<%=PMP_ONE %>" maxlength="15"
	type="text"> <label>PMP2</label> <input name="<%=PMP_TWO %>"
	maxlength="15" type="text">
<div class="Clear"></div>
</div>
</div>

<!--Block Four Ends-->
<div class="division"></div>
<!--Block Five Ends-->

<div class="blockTitleFixed">PAST SURGICAL HISTORY <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	maxlength="20" type="text"> <label></label> <label>Tubal
Surgery</label> <input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text">
<div class="Clear"></div>
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	maxlength="20" type="text"> <label></label> <label>Operative
Scopy</label> <input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text">
<div class="Clear"></div>

</div>
</div>

<!--Block Five Ends--> <%} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="<%=OBG_ID %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="<%=HOSPITAL_ID %>"
	value="<%=visit.getHin().getHospital().getId() %>"> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>">
<div class="division"></div>

<div class="bottom"><input name="button" type="button"
	class="buttonActive" id="btn2" value="Page 1" /> <input name="Button"
	type="button" class="button" value="Page 2"
	onclick="submitForm('OBG','fwc?method=showOBGTWOJsp&visitId=<%=visit.getId() %>');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>

<!--Bottom labels starts--></form>
</div>
<!--main content placeholder ends here-->

