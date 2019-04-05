<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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

<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
	
	
	 
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");	 
	String consultationTime = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int visitNoForJsp=0;
	if(map.get("visitNoForJsp") != null){
		visitNoForJsp=(Integer)map.get("visitNoForJsp");
	}
	
	int pre_VisitId=0;
	if(map.get("pre_VisitId") != null){
		pre_VisitId=(Integer)map.get("pre_VisitId");
	}
	 List patientDiagnosisList= new ArrayList();
	if(map.get("patientDiagnosisList") != null){
		patientDiagnosisList=(List)map.get("patientDiagnosisList");
	}
	List patientPrescDList= new ArrayList();
	if(map.get("patientPrescDList") != null){
		patientPrescDList=(List)map.get("patientPrescDList");
	}
	List patientInvesDList=new ArrayList();
	if(map.get("patientInvesDList") != null){
		patientInvesDList=(List)map.get("patientInvesDList");
	}
	List deptList= new ArrayList();
	if(map.get("deptList") != null){
		deptList=(List)map.get("deptList");
	}
	 List<OpdPatientDetails> patientVisitDataList= new ArrayList<OpdPatientDetails>();
		if(map.get("patientVisitDataList") != null){
			patientVisitDataList=(List)map.get("patientVisitDataList");
		}
	  OpdPatientDetails opdPatientDetails=(OpdPatientDetails)patientVisitDataList.get(0);
		
	System.out.println("Size of patientVisitDataList list in jsp--"+patientVisitDataList.size()+" Size of patientDiagnosisList list in jsp--"+patientDiagnosisList.size());
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	Visit visit=(Visit)opdPatientDetails.getVisit();
	
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
	int deptId=visit.getDepartment().getId();
%>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="opdMain" action="" method="post">
<%if(visit.getDepartment()!= null){ %>
<h4><%=visit.getDepartment().getDepartmentName() %></h4>
<h6>OPD- Main (AFMSF- 7A 2002)</h6>
<div class="Clear"></div>
<%} %> <script type="text/javascript">
   var icdArray=new Array();
</script> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">
Serv. Status </label> <%if(visit.getHin().getServiceStatus()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Relation</label> <%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Rank</label> <%if(visit.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(patientName != null){ %> <label
	class="valuemedium"><%=patientName %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name</label> <%if(patientName!= null){ %> <label class="valuemedium"><%=patientName %>
</label> <%}else{ %> <label class="valuemedium">- </label> <%} %> <label
	class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Visit
Date </label> <%if(visitDateInString != null){ %> <label class="valuemedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Visit no. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="valuemedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Token
No. </label> <%if(visit.getTokenNo()!= null){ %> <label class="valuemedium"><%=visit.getTokenNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>




</div>
<!--Block one Ends-->
<div class="division"></div>

<div class="colsHolder">

<div class="colA"><label class="small">Diagnosis <span>*</span></label>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" id="diagnosisId"
	class="list" readonly>

	<%
	   Iterator itr=patientDiagnosisList.iterator();
	   while(itr.hasNext())
	   {
		   DischargeIcdCode dischargeIcdCode=(DischargeIcdCode)itr.next();
		  String icdName=dischargeIcdCode.getIcd().getIcdName();
		   
	%>
	<option value="<%=icdName%>"><%=icdName%></option>
	<%		   
		   }
	%>
</select> <label class="small">Referred</label> <select
	name="referredDepartmentId" multiple="4" size="5"
	id="referredDepartmentId" class="listSm" readonly>

	<%
					  Iterator deptListItr= deptList.iterator();
					  while(deptListItr.hasNext())
					  {
						String departmentName=(String)deptListItr.next();
						
					%>
	<option><%=departmentName %></option>
	<%
	 			 }
				%>

</select>
<div class="clear"></div>
<%
		if(visit.getHin().getRelation() != null){
			if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("self")){
	%> <label class="small">No. of Days</label> <input name="days"
	type="text" class="small" readonly /> <select name="" size="0"
	class="small">
	<option>select</option>
	<option>ED</option>
	<option>MD</option>
	<option>LD</option>
</select> <%}} %> <label class="nowidth">Consulting Doctor</label> <label
	class="value"><%=userName %></label>

<div class="Clear"></div>
<label class="nowidth">Height</label> <%if(opdPatientDetails.getHeight()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getHeight() %></label>
<%}else{ %> <label class="valuenowidth">-</label> <%} %> <label class="unit">cm</label>
<label class="nowidth">Weight</label> <%if(opdPatientDetails.getWeight()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getWeight() %></label>
<%}else{ %> <label class="valuenowidth">-</label> <%} %> <label class="unit">kg</label>
<label class="nowidth">Pulse</label> <%if(opdPatientDetails.getPulse()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getPulse() %></label> <%}else{ %>
<label class="valuenowidth">-</label> <%} %> <label class="unit">min</label>
<label class="nowidth">Temperature</label> <%if(opdPatientDetails.getTemperature()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getTemperature() %></label>
<%}else{ %> <label class="valuenowidth">-</label> <%} %> <label class="unit">&deg;F</label>
<label class="nowidth">BP</label> <%if(opdPatientDetails.getBp()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getBp() %></label> <%}else{ %>
<label class="valuenowidth">-</label> <%} %> <label class="unit">mm/hg</label>

</div>


<div class="floatLeft">
<div class="arrowlistmenu">
<h3 class="menuheader expandable openheader">OPD ManAgement</h3>
<ul class="categoryitems">

	<li><a href="#">Appointments</a></li>
	<li><a href="#">Investigation Appt.</a></li>
	<li><a
		href="opd?method=viewPatientHistory&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Patient
	History</a></li>
	<li><a href="#">Patient Previous Visit</a></li>
	<li><a
		href="opd?method=viewPatientAllergicDrug&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Patient
	Allergic Drugs</a></li>
	<li><a href="#">Admitted Patient</a></li>
	<li><a href="#">Print Prescription</a></li>
	<li><a href="#">Print Investigation</a></li>
	<li><a href="#">Print AFMSF- 7A</a></li>
</ul>

<h3 class="menuheader expandable">opD Specification</h3>
<ul class="categoryitems">
	<li><a
		href="/hms/hms/opd?method=viewPatientOphthalmologyDetails&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Ophthalmology</a></li>
	<li><a
		href="opd?method=viewEnt&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">ENT</a></li>
	<li><a
		href="opd?method=viewOBGONE&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">OBG</a></li>
	<li><a
		href="opd?method=viewPediatricCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Prediatrics</a></li>
	<li><a
		href="opd?method=viewOncosurgeryCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco
	Surgery Case Sheet</a></li>
	<li><a
		href="opd?method=viewAntenatalCard&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Antenatal
	Card</a></li>
	<li><a
		href="opd?method=viewCardiologyDepartmentDetails&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Cardiology</a></li>
	<li><a
		href="opd?method=viewGastroEnterologyEndoscopy&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Gastro
	Enterology Endoscopy</a></li>
	<li><a
		href="opd?method=viewGastroEnterologyColonoscopy&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Gastro
	Enterology Colonoscopy</a></li>
	<li><a
		href="opd?method=viewOncosurgery&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco
	Surgery</a></li>
	<li><a
		href="opd?method=viewOncosurgeryCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco
	Surgery Case Sheet</a></li>
	<li><a
		href="opd?method=viewUrologyCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Urology
	Case Sheet </a></li>

</ul>

</div>
</div>

<div class="colA">
<div class="title">Examination</div>
<div class="Clear"></div>

<div class="paddingLeftTop10">Past: Short Summary Description</div>
<div class="Clear"></div>

<textarea name="previousDesc" cols="0" rows="0" readonly>
Description for previous visit : <%if(opdPatientDetails.getAfmsDesc()!= null){ %><%=opdPatientDetails.getAfmsDesc() %>
<%}else{ %>-<%} %>

</textarea>
<div class="Clear"></div>

<div class="Clear"></div>
</div>
<div class="colA">
<div class="title">Drugs</div>
<div class="Clear"></div>
<div class="floatLeft">
<div class="tableHholder">
<table id="grid" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
		<th scope="col">Type</th>
	</tr>
	<%
	    int i=0;
	    	Iterator patientPresListItr= patientPrescDList.iterator();
	    	while(patientPresListItr.hasNext())
	    	{
	    		PatientPrescriptionDetails patientPrescriptionDetails=(PatientPrescriptionDetails)patientPresListItr.next();
	    		
	    		
	    	
	    %>
	<tr>
		<td><input type="text" name="nomenclature<%=i %>"
			id="nomenclature<%=i %>"
			value="<%=patientPrescriptionDetails.getItem().getNomenclature() %>"
			readonly size="43" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getItem().getPvmsNo() %>"
			name="pvmsNo<%=i %>" id="pvmsNo<%=i %>" readonly size="10" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getDosage() %>"
			name="dosage<%=i %>" id="dosage<%=i %>" readonly size="10" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getFrequency().getFrequencyName() %>"
			name="frequency<%=i %>" id="frequency<%=i %>" readonly size="10" />
		</td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getNoOfDays() %>"
			name="noOfDays<%=i %>" id="noOfDays<%=i %>" readonly size="10" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getTotal() %>"
			name="total<%=i %>" id="total<%=i %>" readonly size="10" /></td>
		<%if(patientPrescriptionDetails.getTotal().equals("")){ %>
		<label class="valuenowidth">-</label>
		<%}else{ %>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getType() %>" name="type<%=i %>"
			id="type<%=i %>" readonly size="10" /></td>
		<%} %>
		<input type="hidden" name="hdb" value="1" id="hdb" />
	</tr>
	<%
	   i++;	}
	  %>

</table>
<div class="Clear"></div>

</div>
</div>
</div>
<div class="colA">
<div class="title">Investigation</div>
<div class="Clear"></div>
<div class="floatLeft">
<div class="tableHholder">
<table border="0" id="investigationGrid" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Test Code</th>
		<th scope="col">Qty</th>
		<th scope="col">Clinical Notes</th>
	</tr>
	<%
		     Iterator  patientInvesDListItr=patientInvesDList.iterator();
		    while(patientInvesDListItr.hasNext())
		    {
		   		PatientInvestigationDetails patientInvestigationDetails=(PatientInvestigationDetails)patientInvesDListItr.next(); 	
		   
		    %>
	<tr>
		<td><input type="text"
			value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeName() %>"
			name="chargeName" size="10" /></td>

		<td id="chargeCodeVal"><input type="text"
			value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeCode() %>"
			name="chargeCode" size="10" /></td>

		<td><input type="text" name="qty"
			value="<%=patientInvestigationDetails.getQuantity() %>" size="10" /></td>
		<td><input type="text" name="clinicalNotes"
			value="<%=patientInvestigationDetails.getClinicalNotes() %>"
			size="10" /></td>
	</tr>

	<%} %>
</table>

<div class="Clear"></div>
</div>
</div>

</div>
</div>
<!--Bottom labels starts-->
<div class="Clear"></div>
<div class="paddLeft25">
<div class="bottom"><label>Plan</label> <%if(opdPatientDetails.getPlan()!= null){ %>
<label class="valuenowidth"><%=opdPatientDetails.getPlan() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Next Visit Date</label> <%if(opdPatientDetails.getNextVisitDate()!= null){ %>
<input type="text"
	value="<%=HMSUtil.changeDateToddMMyyyy(opdPatientDetails.getNextVisitDate()) %>"
	class="textbox_date" readonly /> <%}else{ %> <label class="value">-</label>
<%} %>
<div class="Clear"></div>



<!--Bottom labels starts--> <input name="visitId" type="hidden"
	value="<%=visit.getId()%>" /> <input name="hinId" type="hidden"
	value="<%=visit.getHin().getId()%>" /> <input name="deptId"
	type="hidden" value="<%=visit.getDepartment().getId()%>" /> <input
	name="visitNo" type="hidden" value="<%=visitNoForJsp%>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
	name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" /> <input
	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"
	value="<%=consultationTime%>" /> <input name="Back" type="button"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /> <input
	type="button" class="button" value="Prev"
	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&visitId=<%=pre_VisitId %>');"</div>
</div>
</form>
</div>
<!--main content placeholder ends here-->


