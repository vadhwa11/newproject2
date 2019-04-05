<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>-->
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<script type="text/javascript">
animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
function populatePVMS(val,inc){
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

	<%
	Map map = new HashMap();
	List<PatientPrescriptionDetails> patientPreList = new ArrayList<PatientPrescriptionDetails>();
	List<PatientInvestigationDetails> pInvList = new ArrayList<PatientInvestigationDetails>();
	
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	}


	List patientDataList = new ArrayList();
	
	if(map.get("patientDataList") != null){
	patientDataList=(List)map.get("patientDataList");
	
	}
	
	
	if(map.get("patientPreList") != null){
		patientPreList= (List<PatientPrescriptionDetails>) map.get("patientPreList");
	}
	if(map.get("pInvList") != null){
		pInvList= (List<PatientInvestigationDetails>) map.get("pInvList");
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

	
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	System.out.println("Size of patientDataList list in jsp--"+patientDataList.size()+" Size of templateList list in jsp--"+templateList.size()+"-----and userName========="+userName);
	Visit visit=(Visit)patientDataList.get(0);
	
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
	String departmentName=visit.getDepartment().getDepartmentName();
	String departmentCode=visit.getDepartment().getDepartmentCode();
	%>


<!--main content placeholder starts here-->
	<form name="opdMain" action="" method="post">
	
	<input type="hidden" name="userName" value="<%=userName %>"/>
	<%if(visit.getDepartment()!= null){ %>
	<div class="titleBg"><h2>Patient Prescription</h2></div>
	<h4><%=visit.getDepartment().getDepartmentName() %></h4>

	<%} %>	
	<script type="text/javascript">
	   var icdArray=new Array();
	</script>
		<%
			if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	    %>
<!--Block One Starts-->
	<h4>Service Personnel Details</h4>
	

	
<div class="Block">
	
	<label >Service </label>
	<%if(visit.getHin().getServiceType()!= null){ %>
	<label class="value"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label >Service No.</label>
	<%if(visit.getHin().getServiceNo()!= null){ %>
	<label class="value"><%=visit.getHin().getServiceNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label > Serv. Status </label>
	<%if(visit.getHin().getServiceStatus()!= null){ %>
	<label class="value"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<div class="clear"></div>
	
	<label >Name</label>
	<%if(patientName != null){ %>
	<label class="value"><%=patientName %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<label >Relation</label>
	<%if(visit.getHin().getRelation() != null){ %>
	<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label >Rank</label>
	<%if(visit.getHin().getRank()!= null){ %>
	<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>

	<div class="clear"></div>
	
	<label >Unit</label>
	<%if(visit.getHin().getUnit()!= null){ %>
	<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<label >Unit Address</label>
	<% if(visit.getHin().getUnit()!= null){%>
	<label class="value"><%=visit.getHin().getUnit().getUnitAddress() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	</div>
	<div class="clear"></div>
	
	<h4>Patient Details</h4>
	
	<div class="Block">
	
	<label >HIN No.</label>
	<%if(visit.getHin().getHinNo()!= null){ %>
	<label class="value"><%=visit.getHin().getHinNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label >Patient Name </label>
	<%if(patientName!= null){ %>
	<label class="value" style="width: auto;"><%=patientName %> </label>
	<%}else{ %>
	<label class="value">- </label>
	<%} %>
	
	<label >Age</label>
	<%if(visit.getAge()!= null){ %>
	<label class="value" ><%=visit.getAge() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<div class="clear"></div>
	
	<label >Visit Date </label>
	<%if(visitDateInString != null){ %>
	<label class="value"><%=visitDateInString %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>

	<label >Visit No. </label>
	<%if(visit.getVisitNo()!= null){ %>
	<label class="value"><%=visit.getVisitNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<label >Token No. </label>
	<%if(visit.getTokenNo()!= null){ %>
	<label class="value"><%=visit.getTokenNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<div class="clear"></div>
	
	<label >Prev. Diag </label>
	<%if(visit.getDiagnosis()!= null){ %>
	<label class="value"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<label >ECHS No. </label>
	<%if(visit.getHin().getEchsNo()!= null){ %>
	<label class="value"><%=visit.getHin().getEchsNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label >Phone Number</label>
	<% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
	<label class="value"><%=visit.getHin().getPhoneNumber() %></label>
	<%}else{ %>
	<label class="value">---</label>
	<%} %>

	<div class="clear"></div>
		
	<label >Mobile Number</label>
	<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
	<label class="value"><%=visit.getHin().getMobileNumber() %></label>
	<%}else{ %>
	<label class="value">---</label>
	<%} %>
	<label >Consulting Doctor</label>
	<%
		String fullDoctorName = "";
	 if(visit.getDoctor() != null){
	    if(visit.getDoctor().getFirstName() != null){
		  fullDoctorName = visit.getDoctor().getFirstName();
	    }
		if(visit.getDoctor().getMiddleName() != null){
			fullDoctorName = fullDoctorName + " " + visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor().getLastName() != null ){
			fullDoctorName = fullDoctorName + " " + visit.getDoctor().getLastName();
		}
	 }
	 
	%>
	
	<label class=valueAuto><%=fullDoctorName%></label>
	</div>
	<div class="clear"></div>

<div class="clear"></div>

<!-- <div class="floatLeft"> -->
<!-- <div class="arrowlistmenu">-->

<!-- <h3 class="menuheader expandable openheader">OPD ManAgement </h3>
<ul class="categoryitems">

<li><a href="appointment?method=showAppointmentPatientJsp">Appointments</a></li>
<li><a href="appointment?method=showAppointmentInvestigationJsp">Investigation Appt.</a></li>-->
<!-- <li><a href="opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>">Patient History</a></li> -->
<!-- <li><a href=javascript:showPreviousVisit(<%=visit.getVisitNo() %>)>Patient Previous Visit</a></li>
<li><a href="opd?method=showPatientAllergicDrugsJsp&visitId=<%=visit.getId() %>">Patient Allergic Drugs</a></li>
<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Show Uploading documents </a></li>
<li><a href="opd?method=getPatientDetailsForOPDOrderBooking&visitId=<%=visit.getId() %>">Order Booking </a></li>
<li><a href="opd?method=showOpdTemplateDepartmentWiseJsp&visitId=<%=visit.getId() %>">Opd Template Department Wise</a></li>
<li><a href="opd?method=showSurgeryRequisitionJsp&visitId=<%=visit.getId() %>">Surgery Requisition Form</a></li>-->
<!--  <li><a href="adt?method=showAdmissionJsp">Admitted Patient</a></li> -->
<!-- <li><a href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>" >Prev Prescription</a></li>
<li><a href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>" >Prev Investigation</a></li>


<li>Print AFMSF- 7A</li>
</ul>-->
<%
System.out.println("Department Name  :"+departmentCode);
%>


<script type="text/javascript">
function validateFieldValuesForMainSubmit(){

	var dateSelected=document.getElementById("nextVisitDate").value
	//if(document.getElementById('diagnosisId').length == 1) {
	//	alert("Please Enter the diagnosis of the Patient.");
	//    return false;
	//}
	if(dateSelected != "")
	{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
					document.getElementById("nextVisitDate").value="";
					alert("Visit Date can not be less than current date.")
					return false;
			    }
    }
    return true;
}

function validateFieldValues(){

	var dateSelected=document.getElementById("nextVisitDate").value
	//if(document.getElementById('diagnosisId').length == 1) {
	//	alert("Please Enter the diagnosis of the Patient.");
	//   return false;
	//}
	if(dateSelected != "")
	{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
					document.getElementById("nextVisitDate").value="";
					alert("Visit Date can not be less than current date.")
					return false;
			    }
    }
    return true;
}
function validateFieldValuesPediatricsOpd(){

	var ageId=document.getElementById("ageId").value
	var age = ageId.substring(0,2);
	var ageIntoInt=parseInt(age);
	if(ageIntoInt<=15)
	{
		var dateSelected=document.getElementById("nextVisitDate").value
		//if(document.getElementById('diagnosisId').length == 1)
	    //  {
	    //    alert("Please Enter the diagnosis of the Patient.");
	    //    return false;
	    //  }
		if(dateSelected != "")
		{
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
   	else
   	{
    	alert("Not more 15 years.");
    	return false;
	}
  return true;
}
</script>

<!-- </div> 
</div>-->
<!-- 	<div class="colA">
	<div class="title">Complaints</div>
	<div class="Clear"></div>
	<label class="small">Complaints</label> -->
		<!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
		 <!-- <textarea name="presentComplain" cols="0" rows="0"  maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<div class="Clear"></div>		
</div> -->

<!-- <div class="colA"> -->
<!-- <div class="title">Patient History</div> -->

<!-- <div style="width: 15px; height: 20px;   float:left;"></div>
	 <div  style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid;  BORDER-LEFT: #3c8ad7 1px solid;   
	              width: 210px; height: 20px; float:left;">
	 <div onClick="togPlus('suggestion-box1',expand_bca);" class="collapsetag" style="float:left;">
		     
			  <IMG id=expand_bca alt=Expand src = "/hms/jsp/images/plus1.gif"; align=left />
			   <font class="boxtitle">Patient History</font> 
	 </div>
	 
	 </div>
	 <div style="width: 15px; float:left;"><img src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
	<br/>
	 
	 
	  <div class=box-content id=suggestion-box1 style="display: none;">
	 <div class=clearfix>
 


 <div class="colA">
	<div class="Clear"></div>
	<label class="small">Present Illness</label>
		 <textarea name="presentIllness" cols="0" rows="0" class="small" maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>	
	<label class="small">Past History</label>
		<textarea name="pastHistory" cols="0" rows="0" class="small" maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>	
		<label class="small">Personal History</label>
		 <textarea name="personalHistory" cols="0" rows="0" class="small" maxlength="300"tabindex="1" onkeyup="return ismaxlength(this)"></textarea>	
		 <div class="Clear"></div>
	<label class="small">Family History</label>
		<textarea name="familyHistory" cols="0" rows="0" class="small" maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
	<label class="small">Other Details</label>
		<textarea name="OtherDetails" cols="0" rows="0" class="small" maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

		<div class="Clear"></div>
		</div>
	 </div>		
</div> -->	
	
<!--	</div> -->
<!-- 	<div class="colA">
		<div class="Clear"></div>	
		<div class="Height10"></div>
<div class="title">Examination</div>
<div class="Clear"></div>
	<div class="floatRight"><label>Last 3 Visits Patient Examination Details </label></div>
<label>On Examination</label>
	<div class="Clear"></div>
	<div class="floatRight paddRight25"> -->
	<%
		  OpdPatientDetails opdPatientDetails;
		List listOfOpd3= new ArrayList();
		List listOfOpd2= new ArrayList();
		List listOfOpd1= new ArrayList();
		String afmsDesc3="";
		String afmsDesc2= "";
		String afmsDesc1= "";
		  if(map.get("listOfOpd3")!= null){
			 listOfOpd3=(List)map.get("listOfOpd3");
			opdPatientDetails=(OpdPatientDetails)listOfOpd3.get(0);
			if(opdPatientDetails.getAfmsDesc() != null){
			 afmsDesc3=opdPatientDetails.getAfmsDesc();
			}else
				 afmsDesc3="";
		  }
		  if(map.get("listOfOpd2")!= null){
				 listOfOpd2=(List)map.get("listOfOpd2");
				opdPatientDetails=(OpdPatientDetails)listOfOpd2.get(0);
				if(opdPatientDetails.getAfmsDesc() != null){
				 afmsDesc2=opdPatientDetails.getAfmsDesc();
				}else
					afmsDesc2="";
			  }
		  if(map.get("listOfOpd1")!= null){
				 listOfOpd1=(List)map.get("listOfOpd1");
				opdPatientDetails=(OpdPatientDetails)listOfOpd1.get(0);
				if(opdPatientDetails.getAfmsDesc() != null){
				 afmsDesc1=opdPatientDetails.getAfmsDesc();
				}else
					afmsDesc1="";
			  }
		  
			//System.out.println("AFms desc 1---"+afmsDesc1+"---------afms desc 2-----"+afmsDesc2+"----afms desc 3--------"+afmsDesc3);
			 
		%>
  <!-- <textarea name="previousDesc" cols="0" rows="0" readonly="readonly" tabindex="1">
Description for previous 3 visits :
		
1:<%=afmsDesc3 %>
		
2:<%=afmsDesc2 %>
		
3:<%=afmsDesc1 %>
		</textarea>
</div>
<textarea name="afmsDescription" cols="0" rows="0" maxlength="400" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
<br/>
<label class="small">&nbsp;</label>	
<a href="javascript:animatedcollapse.toggle('slide0')" >(Click Here for Clinical Details)</a>
		<div class="Clear"></div>
		<div class="Clear"></div>
	<input type="hidden" name="userName" value="<%=userName %>"/>
	<div id="slide0">
	<%
		if(visit.getHin().getRelation() != null){
			if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
	%>
		

<div class="clear"></div>
<br/>
	<label class="small">No. of Days</label>
	<input name="days" type="text" class="small" tabindex="1" maxlength="1" />
	<%}} %>

	<label class="small">Disposal</label>
	<select name="disposal" size="0" tabindex="1" class="small">
      <option value="0">select</option>
      <option value="ED">ED</option>
      <option value="MD">MD</option>
      <option value="LD">LD</option>
    </select>
	<div class="clear"></div>
	<label class="nowidth">Height</label>
	<input name="height" tabindex="1" type="text" class="small" validate="height,int,no" maxlength="3"/>
	<label class="unit">cm</label>
	<label class="nowidth">Weight</label>
	<% if(visit.getWeight()!= null && !visit.getWeight().equals("")){%>
		<input name="weight" tabindex="1" type="text" value="<%=visit.getWeight()%>" class="small" validate="weight,int,no" maxlength="3" />

	<%//}else{ %>
	<input name="weight" tabindex="1" type="text" value="" class="small" validate="weight,int,no" maxlength="3" />

	<%} %>
	
	<label class="unit">kg</label>
	<label class="nowidth">Pulse</label>
	<input name="pulse" type="text" tabindex="1" class="small"tabindex="1" validate="pulse,int,no" maxlength="3" />
	<label class="unit">min</label>
	<label class="nowidth">Temperature</label>
	<input name="temperature" type="text" tabindex="1" class="small"  maxlength="5" />
	<label class="unit">&deg;F</label>
	<label class="nowidth">BP</label>
	<input name="bp" id="bp" type="text" tabindex="1"  onblur="validateBpValue(this.value);" maxlength="7"/>
	<label class="unit">mm/hg</label>
 </div>


</div>
<div class="colA">

 <div class="title">Diagnosis</div>  
<div class="clear"></div> -->
<!-- 	<label class="small">On Examination</label>  -->
	<!-- <input  type="hidden" id="onExamination" class="large" name="onExamination" maxlength="200"/> 
<div class="clear"></div>
	
	 
			 <label class="small">Icd Code :</label>
			 <input name=""  value=""  id="icdCode"tabindex="1" onblur="getIcd();"/>
			 <input name=""  value=""  id="temp" type="hidden"/>
			 <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;" class="floatLeft"  onClick="javascript:openPopupWindow();" title="Click here to Search ICD Codes" /> -->
  	
	
	   <input type="hidden" name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId"/>
	   	   	 
<!--   <label class="small">Working Diag</label><input type="text" id="initialDiagnosis"tabindex="1" class="large" name="initialDiagnosis" maxlength="100"/>
	   	<div class="Clear"></div>
<label class="small">Diagnosis </label> 
	<input type="text" tabindex="1" value=""	id="icd" class="large"  name="icd" onblur="fillDiagnosisCombo(this.value);" />
		<div id="ac2update" style="display:none; padding-right: 10px; background-color:white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		</script>
		  
	 <select name="<%=DIAGNOSIS_ID%>"  multiple="4" size="5"tabindex="1" id="diagnosisId" class="listBig">
					<option value="0">Select</option>
	 </select>
	
	
	
	<div class="clear"></div>

	
	<label class="small">Referred To </label>
	
	 <select name="referredDepartmentId" tabindex="1" multiple="4" size="3" id="referredDepartmentId" onclick="getDoctorList();" class="listSm">
					<option value="0">Select</option>
					<%
					  Iterator itr2= deptList.iterator();
					  while(itr2.hasNext())
					  {
						MasDepartment masDepartment=(MasDepartment)itr2.next();
						int departmentId=masDepartment.getId();
						String deptName=masDepartment.getDepartmentName();
					%>
	  			<option value="<%=departmentId %>"><%=deptName %></option>
				<%
	 			 }
				%>	
	</select>
	<div id="referredDoctarsIdDiv"
		<label class="small">Referred Doctors </label>
	
	 	<select name="referredDoctarsId" tabindex="1" multiple="4" size="3" id="referredDoctarsId" class="listSm">
					
					
		</select>
	
	</div>


</div> -->
	


<h4>Drugs</h4>
<div class="Block">
<label >Delete Existing Item</label>
<input type="checkbox" id="deleteDrugItem" class="radio" name="deleteDrugItem" >
<div class="clear"></div>

<%if(patientPreList.size() > 0){%>
	<div class="cmntable">
	<table border="1" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
	   
	    <th scope="col">Nomenclature</th>
	     <th scope="col">PVMS No. </th>
	    <th scope="col">Dosage</th>
	    <th scope="col">Frequency</th>
	    <th scope="col">No. of Days </th>
	    <!--  <th scope="col">Total</th> -->
	    <th scope="col">Intake</th>
	     <th scope="col">Remarks</th>
	    </tr>
	  <tr>
 <%for(PatientPrescriptionDetails pre:patientPreList){
	
%>
 	  <tr>
	  <td><%=pre.getItem() == null?"":pre.getItem().getNomenclature()%> </td>
	  <td><%= pre.getItem() == null?"":pre.getItem().getPvmsNo()%></td>
	  <td><%= pre.getDosage()==null?"":pre.getDosage()%></td>
	  <td><%= pre.getFrequency()==null?"":pre.getFrequency().getFrequencyName()%></td>
 	  <td><%= pre.getNoOfDays()== null?"":pre.getNoOfDays()%></td>
 	  <td><%= pre.getInstruction()==null?"":pre.getInstruction()%></td>
 	  <td><%= pre.getRemarks()==null?"-":pre.getRemarks()%></td>
		
	  </tr>
	
<%} %>
</table>
</div>
	<div class="clear"></div>

 <%
}%>

<label  >Template</label>
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
		   }
	   }
	   
	%>
  </select>
  	<input name="Prevoius2" tabindex="1" type="button" value="Previous" class="button"  onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getDepartment().getId()%>','<%=visit.getId()%>')"  />
	<input name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template" class="buttonBig"  onclick="showCreatePrescriptionTempate();"  />
<input name="copyPrevPrescriptionTemplate" tabindex="1" type="button" value="Copy Previous" class="buttonBig"  onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');"  />

<input name="prescriptionImportButton1" tabindex="1" type="button" value="Import" class="button" onclick="getListForTreatment('treatmentDiv');" />
</div>
<div class="clear"></div>
<div id="testDiv" class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	  <tr>
	    <th colspan="2">Nomenclature</th>
	    <th scope="col">PVMS No. </th>
	    <th scope="col">Dosage</th>
	    <th scope="col">Frequency</th>
	    <th scope="col">No. of Days </th>
	    <!--  <th scope="col">Total</th> -->
	    <th scope="col">Intake</th>
	     <th scope="col">Remarks</th>
	     <th>Add</th>
	     <th>Delete</th>
	    </tr>
	  <tr>
	    <td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="50"  name="nomenclature1" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td><td>
	    <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
	    <td><input type="text" name ="pvmsNo1" tabindex="1" id="pvmsNo1"  size="10"  readonly="readonly"/></td>
	    <td><input type="text" name ="dosage1" tabindex="1" id="dosage1" size="5"  maxlength="45"/></td>
	    <td>
	        <select name="frequency1" id="frequency1"  tabindex="1" onclick="fillValueFromFrequency(this.value,'1');">
          	<option value="0" >Select</option>
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
               </td>
               
	    <td>
	    <input type="text" name ="noOfDays1" tabindex="1"  id="noOfDays1" onblur="fillValue(this.value,'1')" size="3" maxlength="3" validate="No Of Days,num,no"/>
	    <input type="hidden" name ="total1" id="total1" tabindex="1"  readonly="readonly" size="5"  validate="Total,num,no"/>
	    </td>
	    <td>
		    <select name="instructionACPC1"  class="small" id="instructionACPC1"  tabindex="1">
			    <option value="">Select</option>
			    <option value="AC">AC</option>
			    <option value="PC">PC</option>
		    </select>
	    </td>
	   
	    <td>
	    <input type="text" name ="typeLeftRight1" tabindex="1" size="20" id="typeLeftRight1" maxlength="195"/>
	    <!--<select name="typeLeftRight1" id="typeLeftRight1"  tabindex="1">
	    <option value="">Select</option>
	    <option value="left">Left</option>
	    <option value="right">Right</option>
	    </select>-->
	    </td>
	     <td>
	     <input type="button" tabindex="1" class="buttonAdd"  alt="Add" onclick="addRow();" value=" " align="right" />
	      </td>
	     <td>
	     <input type="button" tabindex="1" class="buttonDel"  alt="Delete" value=" " onclick="removeRow();" align="right" />
	    </td>
	    
	    </tr>
	   <input type="hidden" name="hdb" value="1" id="hdb"/>
	    	</table>
		<div class="clear"></div>

		</div>
<h4>Investigation</h4>
<div class="clear"></div>
<div class="Block">
<label >Delete Existing Item </label>
<input type="checkbox" id="deleteInvItem" class="radio" name="deleteInvItem" >
<div class="clear"></div>
<%if(pInvList.size() > 0){%>
	
	<table border="1" align="center" cellpadding="0" cellspacing="0" id="grid2">
	<tr>
		   <th scope="col">Test Name</th>
	<!-- 	    <th scope="col">Test Code </th>
		    <th scope="col">Qty</th> -->
		    <th scope="col">Clinical Notes </th>
		    </tr>
 <%for(PatientInvestigationDetails pInv:pInvList){
	
%>
 	  <tr>
	  <td><%=pInv.getChargeCode() == null?"-":pInv.getChargeCode().getChargeCodeName()%> </td>
	  <td><%= (pInv.getClinicalNotes() == null || pInv.getClinicalNotes().trim() == "") ?" - ":pInv.getClinicalNotes()%></td>
	   </tr>
	
<%} %>
</table>
	<div class="clear"></div>
	

 <%
}%>
<div id="templateDivInvestigationToShowHide">
<label >Template</label>
<div id="investigationDiv">
		<select name="investigationTemplateId" tabindex="1"  onchange="showHideInvestigationTemplateCombo(this.value);">
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
</div>


	<input name="Prevoius" type="button" value="Previous" tabindex="1" class="button" onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')"  />
	<input name="investigationTemplate" type="button" value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();"  />
    <input name="copyPrevInvestigationTemplate" tabindex="1" type="button" value="Copy Previous" 
    	class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');"  />

	<input name="investigationImportButton1" tabindex="1" type="button" value="Import" class="button" onclick="getListForTreatment('investigationDiv');" />
</div>
<div class="clear"></div>
	<div id="gridview">
		
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
		  <tr>
		   <th scope="col">Test Name</th>
	<!-- 	    <th scope="col">Test Code </th>
		    <th scope="col">Qty</th> -->
		    <th scope="col">Clinical Notes </th>
		    <th>Add</th>
		    <th>Delete</th>
		    </tr>
		    
		  <tr>
		    <td>
		    <%int inc=1; %>
		    	<input type="text" value=""	 tabindex="1" id="chargeCodeName1" size="65"  name="chargeCodeName1" onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
				<div id="ac2update2" style="display:none;" class="autocomplete">
				</div>
				<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script>
			
			<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1" size="10" maxlength="6" validate="Qty,num,no"/>
		    <input type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
	        <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
				
		    </td>
		    
	        
		    
		    <td>
		    <input type="text" name="clinicalNotes1" tabindex="1" size="60"  maxlength="45"/></td>
		    <td>
    <input type="button" class="buttonAdd"  alt="Add" tabindex="1" value="&nbsp;" onclick="addRowForInvestigation();" align="right" />
    </td>
		    <td><input type="button" class="buttonDel"  alt="Delete" tabindex="1" value="&nbsp;" onclick="removeRowForInvestigation();" align="right" />
  </td>
   
		    
		    </tr>
		   	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		    
		
		</table>
		
	<div class="clear"></div>
	</div>




	



<!--Bottom labels starts-->
<div class="clear"></div>
<div class="Block">
<label class="medium">Plan</label>
<textarea rows="" class="large" cols=""tabindex="1" maxlength="1000" onkeyup="return ismaxlength(this)" name="plan"></textarea>


<label >Next Visit Date</label>
				
			
			<input type="text" tabindex="1"class="calDate" id="nextVisitDate" name="nextVisitDate"  readonly="readonly" MAXLENGTH="30" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=consultationDate %>',document.opdMain.nextVisitDate,event)"/>
		<!-- <input type="text" name="nextVisitDate"  class="calDate"/>
		<a href="#"><img src="images/cal.gif" alt="Calender" border="0" /></a>
		 -->
<div class="clear"></div>
<div class="Height10"></div>
	<input id="visitId" name="visitId" type="hidden" value="<%=visit.getId()%>"/>
	<input  name="hinId" type="hidden" value="<%=visit.getHin().getId()%>"/>
	<input  name="departmentId" type="hidden" value="<%=visit.getDepartment().getId()%>"/>
	<input  name="hospitalId" type="hidden" value="<%=hospitalId%>"/>
	<%if(visit.getDoctor() != null){%>
	<input  name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>"/>
	<%} %>
	<input name="deptId" type="hidden" value="<%=deptId%>"/>
	<input  name="<%=SERVICE_NO%>" type="hidden" value="<%=visit.getHin().getServiceNo()%>"/>
	<input  name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>"/>
	<input  name="<%=HIN_NO%>" type="hidden" value="<%=visit.getHin().getHinNo()%>"/>
	<input  name="consultationDate" type="hidden" value="<%=consultationDate%>"/>
	<input  name="consultationTime" type="hidden" value="<%=consultationTime%>"/>
	<input  name="relation" type="hidden" value="<%=visit.getHin().getRelation().getRelationName()%>"/>
	<%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%>	

	<input  name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>"/>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<input name="Submit" type="button"tabindex="1" align="right" class="button" value="Submit"  
			onclick="submitOPDMainForm();" />
	<input name="Reset" type="reset" tabindex="1"align="right" class="button" value="Reset" />
	<input name="Back" type="button" tabindex="1"align="right" onclick="submitForm('opdMain','/hms/hms/opd?method=showUpdatePatientPrescribtionJsp')" class="button" value="Back" />
<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
<!--main content placeholder ends here-->
<script type="text/javascript">
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
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode").focus();
	}
	
	function openPopupWindow()
	{
	 var url="/hms/hms/adt?method=showICDSearchJsp";
	 newwindow=window.open(url,'name',"left=5,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}
//=========To get Icd String with icd code==========================	
	function getIcd(){
	var icdCode =document.getElementById("icdCode").value

	 if(icdCode !="")
	  {
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	 
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName('icdString')[0];
	         document.getElementById('icd').value =icdString.childNodes[0].nodeValue
	         document.getElementById('icdCode').value="";
	         fillDiagnosisCombo(document.getElementById('icd').value);
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  
  	}
  }
	
	function checkTemplateId(templateId){
      if(templateId=="0"){
        return false;
      }else{ 
        return true;
      }
    }


 function fillDiagnosisCombo(val) {
	
	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    //alert("function called---"+id)
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId'); 
					obj.length = document.getElementById('diagnosisId').length;
				
		        	obj.length++;
					obj.options[obj.length-1].value=id
					obj.options[obj.length-1].text=val
					obj.options[obj.length-1].selected=true
					document.getElementById('icd').value =""
					
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
		
	function validateInvestigationAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    //alert("id----"+id)
		    
		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}
 			document.getElementById('qty'+inc).value="1";
 			return true;
		}	
	
	function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
 
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
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
	      						checkItem();
						   }
	  					  };
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	 
	  e0.size = '50';
	  e0.setAttribute('tabindex','1');	 
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
	   
	    var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/s_search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26'; 
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=5,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);
	  	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');	  
	  cellRightSel.appendChild(sel);
	  
	 
  
	  var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='dosage'+iteration;
	  e2.id='dosage'+iteration
	  e2.size='5';
	  e2.setAttribute('tabindex','1');	 	  
	  cellRight2.appendChild(e2); 
	  
	  var cellRight3 = row.insertCell(4);
	  var e3 = document.createElement('Select');
	 
	  e3.name='frequency'+iteration;
	  e3.id='frequency'+iteration;
	  //e3.classname='smalllabel';
	  e3.setAttribute('tabindex','1');	 	  
	  e3.options[0] = new Option('Select', '0');
	  e3.onclick=function(){
	  					var val=e4.value
	  					var freq=e3.value
	  						//alert("frequency-----"+freq)
	  					document.getElementById('total'+iteration).value=val*freq
	  		}
	   
	   for(var i = 0;i<icdArray.length;i++ ){
	      e3.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight3.appendChild(e3); 
	  
	  
	  var cellRight4 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('tabindex','1');	 	  
	  e4.setAttribute('validate','No Of Days,num,no');	  
	  e4.onblur=function(){
	  							var val=e4.value
	  							var freq=e3.value
	  							//alert("frequency-----"+freq)
	  							document.getElementById('total'+iteration).value=val*freq
	  						}
	  cellRight4.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');	 	  
	  cellRight4.appendChild(e5);

	  
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');
	 
	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.className='small';
	  e6.setAttribute('tabindex','1');	 	  
	   e6.options[0] = new Option('Select', '');
	   e6.options[1] = new Option('AC', 'AC');
	   e6.options[2] = new Option('PC', 'PC');
	   cellRight6.appendChild(e6); 
	  
	  
	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.size='20';
	  e7.setAttribute('tabindex','1');	 	  
	  e7.setAttribute('validate','Remarks,String,no');	  
	  //e7.onblur=function(){
	  //							var val=e7.value
	  //							var freq=e6.value
	  //							//alert("frequency-----"+freq)
	  //							document.getElementById('total'+iteration).value=val*freq
	  //						}
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.setAttribute('tabindex','1');	 	  
	  e8.setAttribute('onclick','addRow();');	  

	  cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.setAttribute('tabindex','1');	 	  
	  e9.setAttribute('onclick','removeRow();');	  

	  cellRight9.appendChild(e9);

	  
	   
	}
	
	function removeRow()
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
	}	
	
function checkItem(){


var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
var iteration = lastRow-1;

var pvmsNo=document.getElementById("pvmsNo"+iteration).value
var visitId=document.getElementById("visitId").value
var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
 
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
	       if(bedStatus.childNodes[0].nodeValue=='yes'){
	           	alert("This is Alergic for this patient..!")
	       	document.getElementById("nomenclature"+iteration).value = ""
	       	document.getElementById("pvmsNo"+iteration).value= ""
	       	pvmsNo=pvmsNo.childNodes[0].nodeValue
	       return true
	       }else{
	       	document.getElementById("visitId").selectedIndex=0
	        pvmsNo=0
	       	return false;
	       }
        	
      	} 
      }
      }
    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

}
    
	 function  fillValue(value,inc){
	  
	  //alert(value)
	  var freq=document.getElementById('frequency'+inc).value
	  document.getElementById('total'+inc).value=freq*value
	 }
	 
	 function  fillValueFromFrequency(value,inc){
	  
	  //alert(value)
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*value
	 }
	 
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
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');	 		  
	  //alert("name--"+e0.name)
	  e0.size = '65'
	  cellRight0.appendChild(e0);
		new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});
	 
	  
	  var sel = document.createElement('input');
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
	 
	
	  var cellRight3 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='clinicalNotes'+iteration;
	  e3.id='clinicalNotes'+iteration;
	  e3.setAttribute('tabindex','1');		  
	  e3.size='60'
	  cellRight3.appendChild(e3); 

	  var cellRight4 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className='buttonAdd';
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('onclick','addRowForInvestigation();');			  
	  cellRight4.appendChild(e4); 

	  var cellRight5 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className='buttonDel';
	  e5.setAttribute('tabindex','1');
	  e5.setAttribute('onclick','removeRowForInvestigation();');			  
	  cellRight5.appendChild(e5); 
	 
	}
  </script>
  
  <script type="text/javascript">
		function openPopupForPatientPrescription(visitNo,hinId,deptId,visitId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)
	    
	
		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId+"&deptId="+deptId+"&visitId="+visitId;
        newwindow=window.open(url,'name',"height=300,width=1010,left=5,top=0,status=1");
        }else{
          alert("This Is Patient's first Visit.")
        }
     }
     
     function submitDetails(){
    
		 // alert("in showPreviousVisit")
        document.opdMain.action="hms/hms/opd?method=submitOPDPatientDetails";
        document.opdMain.submit();
        document.opdMain.action="opd?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.opdMain.submit();
        
       
     }
     
     function showPreviousVisit(visitNo){
		  //alert("in showPreviousVisit")
		if(visitNo >1){
		
        document.opdMain.action="/hms/hms/opd?method=showPatientPreviousVisit&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment().getId()%>&visitNo=<%=visit.getVisitNo() %>";
        document.opdMain.submit();
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function openPopupForPatientInvestigation(visitNo,hinId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)
	    
	
		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
        newwindow=window.open(url,'name','left=5,top=0,height=320,width=1010,status=1,scrollbars=1,resizable=1');
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
	    newwindow=window.open(url,'name',"height=500,width=1010,status=1,top=0,left=5");
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
		  document.getElementById("investigationImportButton").style.display='inline'
		  var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
		  newwindow=window.open(url,'name',"height=500,width=1010,left=5,top=0,status=1");
  }
  
  
 function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
	document.getElementById('prescriptionImportButton').style.display = 'none';
	document.getElementById("investigationImportButton").style.display='none'
 }
 
 function checkForChargeCode(val,inc,chargeCodeTdDiv){

	if(val != ""){
		
		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1,index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0,indexForChargeCode);
		    
		
		if(chargeId == "" ) {
	      	document.getElementById('chargeCodeName'+inc).value="";
	      	document.getElementById('chargeCode'+inc).value="";
	      	document.getElementById('clinicalNotes'+inc).value="";
	 	  	document.getElementById('qty'+inc).value="";
	      	return;
		}

		for(i=1;i<inc;i++){
			
			if(inc != 1){
				if(document.getElementById('chargeCodeName'+i).value==val) {
					alert("Test name already selected...!")
					document.getElementById('chargeCodeName'+inc).value=""
					var e=eval(document.getElementById('chargeCodeName'+inc)); 
					e.focus();
					return false;
				} 
			} 
		}

		var nameOfChargeCodeArray = chargeCode.split('&');
		var tempChargeCodeString = "";
		for(var m=0; m<nameOfChargeCodeArray.length;m++) {
			tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";			
		}
		
		//ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  tempChargeCodeString , inc);
		//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);
		
		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCode'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
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
	function showHideInvestigationTemplateCombo(valueOfTemplate){
		if(checkTemplateId(valueOfTemplate)){
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';		
			submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation','gridview');
		}
	} 
	function validateFrequency(){
		var count = document.getElementById('hdb').value;

		for(var i = 1; i <= count;i++){
			var nomenclature = document.getElementById('nomenclature'+i).value;
			if(nomenclature != ''){
				var frequency = document.getElementById('frequency'+i).value;
				if(frequency == '0'){
					alert('Please select frequency.');
					return false;
				}
			}
		}
		return true;
	}
	
	function submitOPDMainForm(){  			
		if(validateFieldValuesForMainSubmit()){
			if(validateFrequency()){
				submitForm('opdMain','opd?method=submitOPDPatientDetailsChange&flag=opd');			
			}
		}
	}
	
	function openpopforItemSearch(){
	    var url="/hms/hms/opd?method=showItemSearchJsp&count="+1;
	    newwindow=window.open(url,'name',"left=5,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}
	
	function jsSetUnitData(id,pvms,nomenclature,count)
	{
	document.getElementById('nomenclature'+count).value = nomenclature+'['+pvms+']'
	document.getElementById('nomenclature'+count).focus();	
	}
	
	
		</script>
		</div></div>
		</form>
		</div>
		
		
		