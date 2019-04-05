<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%--For AutoComplete Through Ajax--%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

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
var b10 = document.getElementById('b10').value ;
var b11 = document.getElementById('b11').value ;
var b12 = document.getElementById('b12').value ;
var b13 = document.getElementById('b13').value ;
var b14 = document.getElementById('b14').value ;
var b15 = document.getElementById('b15').value ;
var b16 = document.getElementById('b16').value ;
var dobDate1 = document.getElementById('visitDate1').value ;
var dobDate2 = document.getElementById('visitDate2').value ;
var dobDate3 = document.getElementById('visitDate3').value ;
var lmp = document.getElementById('lmpId').value ;
var edd = document.getElementById('eddId').value ;
if((b1=="")&&(b2=="")&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b10=="")&&(b11=="")&&(b12=="")&&(b13=="")&&(b14=="")&&(b15=="")&&(b16=="")&&(dobDate1=="")&&(dobDate2=="")&&(dobDate3=="")&&(lmp=="")&&(edd==""))
{
alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
</script>


<script type="text/javascript">

function checkDate(){

	var vDate = new Date() ;
	
		var vDate =  new Date();
	var mth;
	var dt;
	var da = vDate.getDate();
	var m = vDate.getMonth()+1;
	if(vDate.getDate() < 10)
	{
		dt = "0"+da;
	}
	else
	{
		dt = da;
	}
	if(vDate.getMonth()+1 < 10)
	{
		mth = "0"+m
	}
	else
	{
		mth = m
	}
	var finalToday=dt+"/"+mth+"/"+vDate.getFullYear();
	
	
		var dobDate1 = document.getElementById('visitDate1').value ;
	var dobDate2 = document.getElementById('visitDate2').value ;
	var dobDate3 = document.getElementById('visitDate3').value ;
	
	
	if(dobDate1 != ""){
		if(dobDate1<finalToday)
		{
			alert("Please ensure Date Of 1st Visit that the Today Date is greater than or equal to the Start Date.");
			document.getElementById('startDateId').value = "";
			return false;
		}
			return false;
	}
		if(dobDate2 != ""){
		if(dobDate2<finalToday)
		{
			alert("Please ensure date of GCT that the Today Date is greater than or equal to the Start Date.");
			document.getElementById('startDateId').value = "";
			return false;
		}
			return false;
	}
		if(dobDate3 != ""){
		if(dobDate3<finalToday)
		{
			alert("Please Date of OGTT that the Today Date is greater than or equal to the Start Date.");
			document.getElementById('startDateId').value = "";
			return false;
		}
			return false;
	}

}


function yearValid(){
var d = new Date();
var yearNow=d.getFullYear()-1;
var year = document.getElementById('yearTxt').value ;
var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
	if(!(objRegExp.test(year)))
	{
		alert("Year should be a number");
		document.getElementById('yearTxt').value ="";
		document.getElementById('yearTxt').focus();
	}
	else
	{
		if(year<=yearNow)
		{
			alert("Please Not before year from  current year");
			document.getElementById('yearTxt').value ="";
			document.getElementById('yearTxt').focus();
			return false;
		}
		else
		{
			return true;
		}
	}
}
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	
	
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
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
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
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String dateC = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}

		 List patientDataList = new ArrayList();
		
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}	

	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
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

	 System.out.println("hinId"+hinId);
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
<script type="text/javascript">

function back() {
window.close();
return;

}

</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="gravidagramGestationalDiabitiesOne" action="" method="post">


<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<h6>Gravidagram Gestational Diabities One</h6>
<div class="Clear"></div>
<%} %> <!--Block One Starts-->

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
<!--Block one Ends--> <!--Block two Starts-->
<div class="blockFrame">
<div class="Clear"></div>

<label>Date Of 1st Visit</label> <input type="text" class="calDate"
	id="visitDate1" name="<%=DATE %>" onblur="checkDate();"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.gravidagramGestationalDiabitiesOne.<%=DATE%>,event)"
	onblur="checkDate();" /> <label>LMP</label> <input type="text"
	id="lmpId" name="<%=LMP %>" readonly="readonly" validate="LMP,date,no"
	onfocus="addMonths();" /> <label>EDD (LMP+9M+7D)</label> <input
	type="text" id="eddId" name="<%=EDD %>" class="calDate"
	readonly="readonly" validate="EDD,date,no" onblur="eddF();" />
<div class="Clear"></div>

<label>Party </label> <input name="<%=PARTY %>" id="b1" type="text"
	maxlength="10" validate="Party,string,no" /> <label>PMC </label> <input
	name="<%=PMC %>" id="b2" type="text" maxlength="10"
	validate="PMC,string,no" /> <label>Risk Factors </label> <input
	name="<%=RISK_FACTORY %>" id="b3" type="text" maxlength="20"
	validate="Risk Factory,string,no" size="20" />


<div class="Clear"></div>

<label>Prev Pregnancy</label> <select name="<%=LIVE %>" id="b4">
	<option value="">select</option>
	<option value="MACROSOMIA">MACROSOMIA</option>
	<option value="STILLBIRTH">STILLBIRTH</option>
	<option value="GDM">GDM</option>
	<option value="ANOMALY">ANOMALY</option>
</select> <label>Present Pregnancy</label> <select name="<%=ECTOPIC %>" id="b5">
	<option value="">select</option>
	<option value="PIH">PIH</option>
	<option value="IMPAIREDD GTT">IMPAIREDD GTT</option>
	<option value="IUGR">IUGR</option>

</select></div>

<div class="division"></div>
<h5>GCT</h5>
<div class="blockFrame">
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">POG</th>
		<th scope="col">Value</th>
		<th scope="col">Fasting(Y/N)</th>
		<th scope="col">Remarks</th>
	</tr>

	<tr>
		<td><input type="text" class="calDate" id="visitDate2"
			name="<%=DATE_GCT %>" onblur="checkDate();" readonly="readonly"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.gravidagramGestationalDiabitiesOne.<%=DATE_GCT%>,event)"
			onblur="checkDate();" /></td>
		<td><input name="<%=POG_GCT%>" id="b6" type="text" maxlength="10"
			validate="Fasting,string,no" /></td>
		<td><input name="<%=VALUES_GCT %>" id="b7" type="text"
			maxlength="10" validate="1 Hr,string,no" /></td>
		<td><select name="<%=FASTING %>" id="b8" class="date">
			<option value="">Select</option>
			<option value="y">Yes</option>
			<option value="n">No</option>
		</select></td>
		<td><input name="<%=REMARKS_GCT%>" type="text" maxlength="10"
			validate="3 Hr,string,no" id="b9" /></td>
	</tr>
</table>

</div>
</div>
<div class="Clear"></div>

<div class="division"></div>
<h5>OGTT</h5>
<div class="blockFrame">
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">POG</th>
		<th scope="col">Value</th>
		<th scope="col">Remarks</th>
	</tr>

	<tr>
		<td><input type="text" class="calDate" id="visitDate3"
			name="<%=DATE_OGTT %>" onblur="checkDate();" readonly="readonly"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.gravidagramGestationalDiabitiesOne.<%=DATE_OGTT%>,event)"
			onblur="checkDate();" /></td>
		<td><input id="b10" name="<%=POG_OGTT %>" type="text"
			maxlength="10" validate="Fasting,string,no" /></td>
		<td><input id="b11" name="<%=VALUES_OGTT %>" type="text"
			maxlength="10" validate="1 Hr,string,no" /></td>
		<td><input id="b12" name="<%=REMARKS_OGTT %>" type="text"
			maxlength="10" validate="3 Hr,string,no" /></td>
	</tr>
</table>

</div>
</div>
<div class="Clear"></div>

<div class="division"></div>

<div class="blockFrame">
<div class="Clear"></div>

<label>Family H/O DM </label> <input id="b13" name="<%=FAMILY_HO_DM%>"
	type="text" maxlength="10" validate="Family H/O DM,string,no" /> <label
	class="smallmed">Weight </label> <input id="b14" name="<%=WEIGHT %>"
	size="3" type="text" maxlength="4" validate="Weight,num,no" /> <label
	class="smallmed">Height </label> <input id="b15" name="<%=HEIGHT %>"
	size="3" type="text" maxlength="4" validate="Height,num,no" /> <label
	class="smallmed">BMI</label> <input id="b16" name="<%=BMI%>" size="10"
	type="text" maxlength="10" validate="BMI,string,no" /></div>

<div class="division"></div>

<!--Block two Ends--> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>">

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=dateC%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>



<div class="Clear"></div>
<div class="Height10"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('gravidagramGestationalDiabitiesOne','opd?method=addGravidagramGestationalDiabitiesOne','checkDate()','blankSpace');"
	align="right" /> <input name="" type="button" class="button"
	value="View"
	onclick="submitForm('gravidagramGestationalDiabitiesOne','opd?method=viewGravidagramGestationalDiabitiesOne&flag=prev&viewScreen=no');" />
<input name="Back" type="button" alt="Back" value="Back" class="button"
	onclick="back();" align="right" /></div>
<!--Main Div Ends--></form>
</div>
<script type="text/javascript">

	var id=window.opener.document.getElementById('lmpId').value;
	var id2=window.opener.document.getElementById('eddId').value;
	if(id!="")
    {
  		 document.getElementById('lmpId').value=id;
    	 document.getElementById('eddId').value=id2;
    	 
   }
   else
   {
   
     document.getElementById('lmpId').disabled="true";
     document.getElementById('eddId').disabled="true";
   }
	
	
</script>