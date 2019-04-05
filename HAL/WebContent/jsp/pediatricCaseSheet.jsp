<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdCaseSheet"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" src="/hms/jsp/js/phase2/tabcontent.js">

/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
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


function checkDOB(){
	var vDate = new Date() ;
	var dobDate = document.getElementById('startDateId').value ;
	var dateofBirthId = document.getElementById('dateofBirthId').value ;

	var d1 = new Date(dateofBirthId.substring(6),(dateofBirthId.substring(3,5) - 1) ,dateofBirthId.substring(0,2));
	var d = new Date(dobDate.substring(6),(dobDate.substring(3,5) - 1) ,dobDate.substring(0,2));
	var year1 = vDate.getFullYear() ;
	var year = d.getFullYear() ;
	var yearFive = year1-15;

	if(dobDate != ""){
		//if((vDate < d) || (year != yearFive) && (year != yearFour)  && (year != yearThree) && (year != yearTwo)  && (year != yearOne))
		if(vDate > d)
		{
			if(year < yearFive)
			{
				alert("Age cannot be more than 15 years");
				document.getElementById('startDateId').value = "";
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			alert("Please enter valid date of Birthday");
			document.getElementById('startDateId').value = "";
				return false;
		}
	}
	return true;
}

function checkFatherMotherChild()
{
		var b3 = document.getElementById('b3').value;
		var b4 = document.getElementById('b4').value;
		var b5 = document.getElementById('b5').value;
		if((b3=="")&& (b4=="") && (b5=="") )
		{
			alert("Please Enter Father,Mother and Child");
			return false;
		}
		else if((b3=="")&& (b4!="") && (b5!="") )
		{
			alert("Please give Father Height in CMs ");
			return false;
		}
		else if((b3!="")&& (b4=="") && (b5!="") )
		{
			alert("Please give Monther Height in CMs ");
			return false;
		}
		else if((b3!="")&& (b4!="") && (b5=="") )
		{
			alert("Please give Child Age ");
			return false;
		}
			else if((b3!="")&& (b4=="") && (b5=="") )
		{
			alert("Please give Mother Height in CMs and Child Age ");
			return false;
		}
		else if((b3=="")&& (b4!="") && (b5=="") )
		{
			alert("Please give Father Height in CMs and Child Age ");
			return false;
		}
		else if((b3=="")&& (b4=="") && (b5!="") )
		{
			alert("Please give Father and Mother Height in CMs ");
			return false;
		}
		else
		{
				alert("Then Click Calculate button.");
				return true;
		}
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

<script type="text/javascript">
function blankSpace()
{
	var b1 = document.getElementById('b1').value ;
	var b2 = document.getElementById('b2').value ;
	var b3= document.getElementById('b3').value ;
	var b4 = document.getElementById('b4').value ;
	var b5= document.getElementById('b5').value ;
	var b6 = document.getElementById('b6').value ;
	var b7 = document.getElementById('b7').value ;
	var b8 = document.getElementById('b8').value ;
	var b9 = document.getElementById('b9').value ;
	var b22 = document.getElementById('b22').value ;
	var b23 = document.getElementById('b23').value ;
	//var b10 = document.getElementById('b10').value ;
	//var b11 = document.getElementById('b11').value ;
	//var b12 = document.getElementById('b12').value ;
	var startDateId = document.getElementById('startDateId').value ;
	if((b1=="")&&(b2==0)&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b22=="")&&(b23=="")&&(startDateId==""))
	{
		alert("Please give some fields.");
		return false;
	}
	else
	{
		return true;
	}
}

function calculated()
{
	var b3= document.getElementById('b3').value ;
	var b4 = document.getElementById('b4').value ;
	var b5= document.getElementById('b5').value ;
	var cal;
	var cal1;
	var cal2;
	var cal3;
	var b6;
	if((b3!="")&& (b4!="") && (b5!="") )
	{

		b3 = parseFloat( b3 );
	    b4 = parseFloat( b4 );

		var cal= b3 + b4;

    	cal1=(cal + 13)/2;
		document.getElementById('b6').value=cal1;
		b6 = document.getElementById('b6').value;
		b6 = parseFloat( b6 );

		cal2=(b6)-8;
		cal3=(b6)+8;
		document.getElementById('b7').value=cal2;
		document.getElementById('b8').value=cal3;

		return true;
	}
	else if((b3=="")&& (b4!="") && (b5!="") )
	{
		alert("Please give Father Height in CMs ");
	}
	else if((b3!="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Monther Height in CMs ");
	}
	else if((b3!="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Child Age ");
	}
		else if((b3!="")&& (b4=="") && (b5=="") )
	{
		alert("Please give Mother Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Father Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Father and Mother Height in CMs ");
	}
	else
	{
			alert("Please give Both Height in CMs And Child Age ");
	}

}

</script>
<script language="javascript">

function weightValidation()
{
	var a = document.getElementById('b10').value ;
	if(a!=0)
	{
		var c = Math.round(a);
		document.getElementById('b10').value=c;
		if(c>17 && c<23)
		{
			document.getElementById('b10').value=c;
			return true;
		}
		else
		{
			alert("Please invaild Weight");
			document.getElementById('b10').value="";
			return false;
		}
	}
}

function heightValidation()
{
	var b = document.getElementById('b11').value ;
	if(b!=0)
	{
		var d = Math.round(b);
		document.getElementById('b11').value=d;
		if(d>118 && d<144)
		{
			document.getElementById('b11').value=d;
			return true;
		}
		else
		{
			alert("Please invaild Height");
			document.getElementById('b11').value="";
			return false;
		}

	}
}

function hcValidation()
{
	var c = document.getElementById('b12').value ;
	if(c!="")
	{
		var d = parseInt(c);
		document.getElementById('b12').value=d;
		if(d>118 && d<144)
		{
			document.getElementById('b12').value=d;
			return true;
		}
		else
		{
			alert("Please invaild Hc");
			document.getElementById('b12').value="";
			return false;
		}

	}
}

function weightValidation1()
{
	var a = document.getElementById('kgS').value ;
	if(a!=0)
	{
		var c = Math.round(a);
		document.getElementById('kgS').value=c;

	}
}

function heightValidation1()
{
	var b = document.getElementById('htcS').value ;
	if(b!=0)
	{
		var d = Math.round(b);
		document.getElementById('htcS').value=d;

	}
}

function hcValidation1()
{
	var c = document.getElementById('b12').value ;
	if(c!="")
	{
		var d = parseInt(c);
		document.getElementById('b12').value=d;
	}
}



function cal_bmiS(kgS, htcS){
   mS = htcS/100;
   h2S = mS * mS;

   bmiS = kgS/h2S;
   f_bmiS = Math.floor(bmiS);
   diffS  = bmiS - f_bmiS;
   diffS = diffS * 10;

   diffS = Math.round(diffS);
   if (diffS == 10){
      // Need to bump up the whole thing instead
      f_bmiS += 1;
      diffS = 0;
   }
   bmiS = f_bmiS + "." + diffS;

   return bmiS;
}
function computeS(){
   var fS = self.document.pediatricCaseSheet;

   // Set up variables for calculation
   wS = fS.kgS.value;
//   i = parseInt(f.htc.value);
   iS = fS.htcS.value;

   // Do validation checking to ensure existence of values

   if (!chkwS(i)){
     alert("Please enter a number for your height.");
     fS.htcS.focus();
     return;
   }
   if (!chkwS(wS)){
     alert("Please enter a number for your weight.");
     fS.kgS.focus();
     return;
   }

   fS.bmiS.value = cal_bmiS(wS, iS);
   fS.bmiS.focus();
}
function chkwS(wS){
  // if (isNaN(parseInt(wS))){
   if (isNaN(wS)){
	  return false;
   } else if (wS < 0){
  return false;
  }
  else{
  return true;
  }
}


</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<OpdCaseSheet> opdCaseSheetList = null;
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
		String height = "";
		String weight = "";
		String buttonFlag="";
		 List patientDataList = new ArrayList();
		 OpdCaseSheet opdCaseSheet = null;
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}
    if(map.get("opdCaseSheetList")!=null){
    	opdCaseSheetList = (List<OpdCaseSheet>)map.get("opdCaseSheetList");
    	if(opdCaseSheetList.size()>0)
    	opdCaseSheet = opdCaseSheetList.get(0);
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
	String patientDOBInString="";
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	 if(visit.getHin().getDateOfBirth()!= null){
		 patientDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth());
	 }

	 if(map.get("height") != null)
	 {
		 height=(String)map.get("height");

	 }
	 if(map.get("weight") != null)
	 {
		 weight=(String)map.get("weight");

	 }
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList") != null){
				employeeList = (List<MasEmployee>) map.get("employeeList");
		}
		
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

<!--<link href="css/hms_style.css" rel="stylesheet" type="text/css" />-->

<div id="contentHolder">
<form name="pediatricCaseSheet" action="" method="post">
<input	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="heights" value="" />
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
<!--Block one Ends-->

<div class="Clear"></div>
<div class="blockTitle">Vaccine Plan</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<%
if(opdVaccinationPlanList.size()!=0) {
Iterator itrObj=opdVaccinationPlanList.iterator();
%>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th>Vaccine</th>
		<th>Vaccine Date</th>
		<th>Completion Date</th>
		<th>Remarks</th>
	</tr>
	<%
int i=1;
while(itrObj.hasNext())
{
	OpdVaccinationPlan opdVaccinMstObj=(OpdVaccinationPlan)itrObj.next();
%>
	<tr>
		<td width="7%"><input type="hidden" name="<%=VACCINATION_ID %>"
			value="<%=opdVaccinMstObj.getId() %>" id="vaccinationId<%=i %>" /> <input
			type="hidden" value="<%=opdVaccinMstObj.getVaccin().getId() %>"
			name="<%=VACCINE_ID%>" id="vaccineId<%=i %>"
			validate="Vaccine Id,num,no" /> <input type="text" size="12"
			tabindex="1" name="<%=VACCINE_NAME%>"
			value="<%=opdVaccinMstObj.getVaccin().getVaccinName() %>"
			id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly /></td>
		<td width="10%">
		<%if(opdVaccinMstObj.getVaccinDate()==null)
		{
		%> <input type="text" value="" id="totalId<%=i %>" size="8"
			validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE%>"
			readonly="readonly" /> <%} else{%> <input type="text"
			value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinDate()) %>"
			id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1"
			name="<%=VACCINE_DATE %>" readonly="readonly" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getVaccinCompleteDate()==null)
		{
		%> <input type="text" id="CompletionDate<%=i %>" tabindex="1"
			name="<%=COMPLETION_DATE %>" value="" readonly="readonly"
			onblur="checkDate(<%=i %>)" size="8" /> <%} else{%> <input type="text"
			id="CompletionDate<%=i %>" tabindex="1" name="<%=COMPLETION_DATE %>"
			value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinCompleteDate()) %>"
			readonly="readonly" onblur="checkDate(<%=i %>)" size="8" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getRemarks()==null)
		{
		%> <input type="text" id="remarks<%=i %>" tabindex="1"
			name="<%=REMARKS %>" value="" size="10" readonly="readonly"
			validate="Remarks,String,no" /> <%} else{%> <input type="text"
			id="<%=REMARKS %>" size="10" tabindex="1" name="<%=REMARKS %>2"
			value="<%=opdVaccinMstObj.getRemarks() %>" readonly="readonly"
			validate="Remarks,String,no" /> <%} %>
		</td>
	</tr>
	<%
		i++;
      }
	}
	else
	{%>
</table>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th>Vaccine</th>
		<th>Vaccine Date</th>
		<th>Completion Date</th>
		<th>Remarks</th>
	</tr>
	<tr>
		<td width="7%"><input type="text" tabindex="1"
			name="<%=VACCINE_NAME%>2" value="" size="12" id="vaccineCode"
			validate="Vaccine,string,no" readonly /></td>
		<td width="10%"><input type="text" value="" id="totalId" size="8"
			validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>"
			readonly="readonly" /></td>
		<td width="7%"><input type="text" id="CompletionDate"
			tabindex="1" name="<%=COMPLETION_DATE %>" value="" size="8"
			readonly="readonly" /></td>
		<td width="7%"><input type="text" id="remarks" tabindex="1"
			name="<%=REMARKS %>" value="" readonly="readonly"
			validate="Remarks,String,no" size="10" /></td>
	</tr>
	<%}%>
</table>

</div>
<div class="Clear"></div>
<div class="floatRight"><input type="button" class="cmnButton"
	value="Vaccination" onclick="showVaccination('pediatricCaseSheet');" />
</div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="blockFrame"><label>Date of Birth</label> 
<%if(visit.getHin().getDateOfBirth()!=null){ %>
<input type="text" class="calDate" id="startDateId"
	name="<%=DATE_OF_BIRTH %>" value="<%=patientDOBInString %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=patientDOBInString %>',document.pediatricCaseSheet.<%=DATE_OF_BIRTH%>,event)" />

<%}else{ %> <input type="hidden" class="calDate" id="startDateId"
	name="<%=DATE_OF_BIRTH %>" value="" readonly="readonly" MAXLENGTH="30" />
<label class="value">-</label> <%} if(opdCaseSheet !=null){%>
<input type="hidden" value="<%=opdCaseSheet.getId() %>" name="opdCaseSheetId">
<%}else{ %>
<input type="hidden" value="0" name="opdCaseSheetId" >
<%} %>
<label>Referred By</label> 
<select id="b2" name="<%=EMPLOYEE_ID %>" validate="Refered By,string,no">
	<option value="0">Select</option>
	<% for (MasEmployee masEmployee : employeeList) {
	     if(opdCaseSheet !=null && opdCaseSheet.getReferedBy().getId().equals(masEmployee.getId())){	
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" " + masEmployee.getLastName()%></option>
	<%}else{%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" " + masEmployee.getLastName()%></option>
	<%}} %>
</select>
<div class="Clear"></div>
<label>Wt</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getWt()!=null){ %> 
<input type="text" id="b10" value="<%=opdCaseSheet.getWt() %>"  size="12" class="small" name="<%=WEIGHT %>" validate="Wt,num,no" tabindex="1" />
<%}else{ %>
<input type="text" id="b10" value="" size="12" class="small" name="<%=WEIGHT %>" validate="Wt,num,no" tabindex="1" />
<%} %>
<label class="unit">(18.5-24.9)</label>

<div class="medium24"></div>
<label>Ht</label> 
<%if(opdCaseSheet !=null && opdCaseSheet.getHt()!=null){ %>
<input type="text" id="b11" value="<%=opdCaseSheet.getHt()%>" size="12" class="small" name="<%=HEIGHT %>"	validate="Ht,num,no" tabindex="1" />
<%}else{ %>
<input type="text" id="b11" value="" size="12" class="small" name="<%=HEIGHT %>"	validate="Ht,num,no" tabindex="1" />
<%} %>
<label class="unit">(119-144)</label>


<label>Hc</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getHc()!=null){ %> 
<input type="text" id="b12" value="<%=opdCaseSheet.getHc() %>" size="12" name="<%=HIV %>" class="small" validate="Hc,num,no" MAXLENGTH="3" tabindex="1" onblur="hcValidation1();" onmousedown="hcValidation1();" />
<%}else{ %>
<input type="text" id="b12" name="<%=HIV %>" size="12" class="small" validate="Hc,num,no" MAXLENGTH="3" tabindex="1" onblur="hcValidation1();" onmousedown="hcValidation1();" />
<%} %>
<label class="unit">(119-144)</label>

<div class="Clear"></div>
<label>OFC</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getOfc()!=null){ %> 
<input type="text" id="b22" value="<%=opdCaseSheet.getOfc() %>" name="<%=OFC%>" class="calDate" validate="OFC,float,no" MAXLENGTH="5" tabindex="1" />
<%}else{ %>
<input type="text" id="b22" name="<%=OFC%>" class="calDate" validate="OFC,float,no" MAXLENGTH="5" tabindex="1" />
<%} %>
<label class="unit">cm</label>
<div class="medium11"></div>
<label>RR</label> 
<%if(opdCaseSheet !=null && opdCaseSheet.getRr()!=null){ %>
<input type="text" id="b23" value="<%=opdCaseSheet.getRr() %>" name="<%=RR%>" class="calDate" validate="RR,float,no" MAXLENGTH="5" tabindex="1" />
<%}else{ %>
<input type="text" id="b23" name="<%=RR%>" class="calDate" validate="RR,float,no" MAXLENGTH="5" tabindex="1" />
<%} %>
<label class="unit">min</label>
</div>

<div class="division"></div>
<ul id="countrytabs" class="shadetabs1">
	<li><a href="#" rel="country1" class="selected1">Clinical
	Notes</a></li>
	<li><a href="#" rel="country2">Exp. HT</a></li>
	<li><a href="#" rel="country3">BMI</a></li>
</ul>

<div class="tabContainer">
<div id="country1" class="tabcontent1">
<%if(opdCaseSheet !=null && opdCaseSheet.getClinicalNote()!=null ){ %>
<textarea class="large01" maxlength="1000" onkeyup="return ismaxlength(this)" name="<%=CLINICAL_NOTE %>" id="b1"><%=opdCaseSheet.getClinicalNote() %></textarea>
<%}else{%>
<textarea class="large01" maxlength="1000" onkeyup="return ismaxlength(this)" name="<%=CLINICAL_NOTE %>" id="b1"></textarea>
<%} %>
<div class="Clear"></div>

</div>

<div id="country2">
<div class="paddLeft83"><label class="common">Father</label></div><div class="paddLeft22"><label
	class="common">Mother</label></div>
<div class="Clear"></div>

<label class="common">Height in CM</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getHeightInCmFather()!=null){ %>
<input id="b3" type="text" value="<%=opdCaseSheet.getHeightInCmFather() %>" maxlength="3" name="<%=HEIGHT_IN_CM_FATHER %>" class="calDate" validate="Height in CM Father,num,no" />
<%}else{ %>
<input id="b3" type="text" maxlength="3" name="<%=HEIGHT_IN_CM_FATHER %>" class="calDate" validate="Height in CM Father,num,no" />
<%} %>
<div class="paddLeft80">
<%if(opdCaseSheet !=null && opdCaseSheet.getHeightInCmMother()!=null){ %>
<input id="b4" type="text" value="<%=opdCaseSheet.getHeightInCmMother() %>" name="<%=HEIGHT_IN_CM_MOTHER %>" maxlength="3" class="calDate" validate="Height in CM Mother,num,no" />
<%}else{ %>
<input id="b4" type="text" name="<%=HEIGHT_IN_CM_MOTHER %>" maxlength="3" class="calDate" validate="Height in CM Mother,num,no" />
<%} %>
</div>
<div class="Clear"></div>
<label class="common">Child's Age</label> 
<%if(opdCaseSheet !=null && opdCaseSheet.getAge()!=null){ %>
<input id="b5" type="text" value="<%=opdCaseSheet.getAge() %>" maxlength="3" name="<%=AGE %>" class="calDate" validate="Child's Age,num,no" />
<%}else{ %>
<input id="b5" type="text" maxlength="3" name="<%=AGE %>" class="calDate" validate="Child's Age,num,no" />
<%} %>
<div class="paddLeft80">
<input type="button" class="cmnButton" value="Calculate" onclick="calculated();" />
</div>
<input type="hidden" class="cmnButton" value="History" onclick="submitForm('pediatricCaseSheet','fwc?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>');" />
<div class="Clear"></div>
<div class="Height10"></div>

<div class="paddLeft80">
<label class="common">Child</label>
</div>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="common">Height in CM</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getHeightInCmChild()!=null){ %> 
<input id="b6" type="text" value="<%=opdCaseSheet.getHeightInCmChild() %>" name="<%=HEIGHT_IN_CM_CHILD %>" maxlength="3" class="calDate" validate="Height in CM Child,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%}else{ %>
<input id="b6" type="text" name="<%=HEIGHT_IN_CM_CHILD %>" maxlength="3" class="calDate" validate="Height in CM Child,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%} %>
<div class="Clear"></div>
<label class="common">3rd Percentile</label>
 <%if(opdCaseSheet !=null && opdCaseSheet.getRdPercentile()!=null){ %> 
<input id="b7" type="text" value="<%=opdCaseSheet.getRdPercentile() %>" name="<%=RD_PERCENDTILE %>" maxlength="20" class="calDate" validate="3rd Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%}else{ %>
<input id="b7" type="text" name="<%=RD_PERCENDTILE %>" maxlength="20" class="calDate" validate="3rd Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%} %>
<div class="Clear"></div>
<label class="common">97th Percentile</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getThPercentile()!=null){ %>
<input id="b8" type="text" value="<%=opdCaseSheet.getThPercentile() %>" name="<%=TH_PERCENDTILE %>" maxlength="20" class="calDate" validate="97th Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%}else{ %>
<input id="b8" type="text" name="<%=TH_PERCENDTILE %>" maxlength="20" class="calDate" validate="97th Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<%} %>
<div class="Clear"></div>
<label class="common">Remarks</label>
<%if(opdCaseSheet !=null && opdCaseSheet.getRemarks()!=null){ %>
<input id="b9" type="text" value="<%=opdCaseSheet.getRemarks() %>" class="large" name="<%=REMARKS_TEMP %>" maxlength="50" />
<%}else{ %>
<input id="b9" type="text" class="large" name="<%=REMARKS_TEMP %>" maxlength="50" />
<%} %>

<div class="Clear"></div>
</div>

<div id="country3" class="tabcontent1">
<div class="paddLeft25">
<label class="valuenoWidth"> 
Body mass index (BMI) is measure of body fat based on height and weight that
applies to both adult men and women. </label>
<div class="Clear"></div>
<label class="valuenoWidth"> <b><u>BMI Categories</u></b> </label></div>
<div class="Clear"></div>

<div class="alignleft">
  <table><tr><td>
  <ul>
   <li>Normal weight = 18.5-24.9</li>
    <li>Overweight = 25-29.9</li>
    <li>Obesity = BMI of 30 or greater</li>
  </ul></td></tr></table>
</div>

<div class="Clear"></div>

<TABLE WIDTH="600"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD ALIGN="LEFT"></TD>
	</TR>
	<TR>
		<TD COLSPAN="2" ALIGN="LEFT"></TD>
	</TR>
</TABLE>
<div class="Clear"></div>

<TABLE WIDTH="600"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD>
		<TABLE WIDTH="185" 	SUMMARY="This table is used for layout purposes only.">
			<TR>
				<TD COLSPAN="2" ALIGN="center">
				<TABLE WIDTH="143"
					SUMMARY="This table is used for layout purposes only.">
					<TR>
						<TD ROWSPAN="3" ALIGN="right" WIDTH="50"><IMG
							SRC="/hms/jsp/images/phaseII/bmi_1-4.gif" ALT=" " WIDTH="36"
							HEIGHT="201"></TD>
						<TD VALIGN="top" WIDTH="50"><img
							src="/hms/jsp/images/phaseII/bmi_2-4.gif" alt=" " width="50"
							height="76" /></TD>
						<TD ROWSPAN="3" ALIGN="left" WIDTH="92"><IMG
							SRC="/hms/jsp/images/phaseII/bmi_4-4.gif" ALT=" " WIDTH="57"
							HEIGHT="201"></TD>
					</TR>
					<TR>
						<TD ALIGN="center"><INPUT NAME="bmiS" TYPE="text" SIZE="4"
							STYLE="width: 30px; float: none;" id="yourbmi"></TD>
					</TR>
					<TR>
						<TD VALIGN="bottom"><img
							src="/hms/jsp/images/phaseII/bmi_3-4.gif" alt=" " width="50"
							height="96" /></TD>
					</TR>
				</TABLE>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN><B><LABEL class="common"
					FOR="htcS">Your Height:</LABEL></B></SPAN></TD>
				<TD WIDTH="50%" ALIGN="left">
				<INPUT TYPE="text" NAME="htcS" size="3" ID="htcS" MAXLENGTH="4" value=<%=height%> validate="Height,num,no" onblur="heightValidation1();" onmousedown="heightValidation1();">
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN>&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN STYLE="font-size: 10pt;"> (centimeters)</SPAN><B></TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><LABEL class="common"
					FOR="kgS">Your Weight:</LABEL></TD>
				<TD WIDTH="50%" ALIGN="left">
				<P><INPUT TYPE="text" NAME="kgS" size="3" MAXLENGTH="4" ID="kgS"
					value=<%=weight%> validate="Weight,num,no"
					onblur="weightValidation1();" onmousedown="weightValidation1();"></P>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN
					STYLE="font-size: 10pt;"> (kilograms)</SPAN></B></TD>
			</TR>
			<div class="Clear"></div>
			<TR>
			     <TD width= " 98px"></TD>
				<TD COLSPAN="2" ALIGN="center"><INPUT TYPE="button"
					class="cmnbutton" VALUE="Compute BMI" ONCLICK="self.computeS();">
				</TD>
			</TR>
		</TABLE>
		<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" WIDTH="600">
			<TR>
				<TD VALIGN="top" COLSPAN="3"></TD>
			</TR>
			<TR>
				<TD VALIGN="top"></TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top"></TD>
			</TR>
			<TR>
				<TD VALIGN="top">&nbsp;</TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top">&nbsp;</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
</TABLE>

</div>
</div>
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script> <script type="text/javascript">

var countries1=new ddtabcontent("countrytabs1")
countries1.setpersist(true)
countries1.setselectedClassTarget("link") //"link" or "linkparent"
countries1.init()

</script>

<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="Clear"></div>

<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> 
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>"> 
<%if(visit.getHin().getDateOfBirth()!=null){ %>
<input type="hidden" name="dateofBirthId" id="dateofBirthId" value="<%=HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth()) %>">
<%}else{ %> 
<input type="hidden" name="dateofBirthId" id="dateofBirthId" value=""> 
<% } %>
<div class="division"></div>

<div class="Clear"></div>
<input type="button" class="button" value="Submit" onclick="submitForm('pediatricCaseSheet','fwc?method=addPediatricCaseSheet','checkDOB','blankSpace');" align="right" /> 
<input type="button" class="button" value="View" onclick="showView('pediatricCaseSheet');" align="right" /> 
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('pediatricCaseSheet','fwc?method=showFWCMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');" align="right" />
</div>
</div>
<div class="Clear"></div>

</form>
</div>
<script type="text/javascript">

function showVaccination(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/fwc?method=showPediatricVaccinationPlanJsp&visitId=<%=visit.getId()%>";
  obj.submit();
}
function showView(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/fwc?method=viewPediatricCaseSheet&viewScreen=no";
  obj.submit();
}

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/fwc?method=showWaitingPatientListJsp";
  obj.submit();
}

</script>

