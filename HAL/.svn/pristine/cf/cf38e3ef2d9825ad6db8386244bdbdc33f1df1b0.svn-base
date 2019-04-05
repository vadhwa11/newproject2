
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.FROM_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.TO_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.MEDICAL_OFFICER"%>
<%@ page import="static jkt.hms.util.RequestConstants.DEPARTMENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.THERAPY_TYPE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SELECTED_RADIO"%>


<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.PhysioAppointmentHeader"%>

<%@page import="jkt.hms.masters.business.Inpatient"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

	<script>
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
	</script>
<%



	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Visit> dentalWaitingList = new ArrayList<Visit>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
//	List patientList = new ArrayList();
	int totalPatient=0;
	if(map.get("dentalWaitingList") != null)
	{
		dentalWaitingList=(List<Visit>)map.get("dentalWaitingList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	//if(map.get("doctorList") != null){
	//	doctorList= (List<MasEmployee>)map.get("doctorList");
	//}
	
	%>

<div class="clear"></div>
<!-- thread search menu -->
<%-- <form name="search" action="" method="post">
<div class="Block">
  <label>From Date<span>*</span> </label>
 <input type="text" name="<%=FROM_DATE%>" value="<%=fDate%>" class="date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.search.<%=FROM_DATE%>,event)" />

  <label>To Date<span>*</span> </label>
 <input type="text" name="<%=TO_DATE%>" value="<%=tDate%>" class="date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.search.<%=TO_DATE%>,event)" />
 
<label> Medical Officer</label> 
<select name="<%=MEDICAL_OFFICER %>" validate="Medical Officer,string,no">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
				String doctorName = employee.getFirstName();
				if(employee.getMiddleName()!= null){
					doctorName += " "+employee.getMiddleName();
				}
				if(employee.getLastName()!= null){
					doctorName += " "+employee.getLastName();
				}
			%>
	<option value="<%=employee.getId()%>"
		<%=HMSUtil.isSelected(employee.getId(),Integer.valueOf(box.getInt(MEDICAL_OFFICER)))%>><%=doctorName %></option>
	<%
			}
			%>
</select>
  </div>

<div class="Clear"></div>
<input type="button" name="search" value="Search" onClick="submitForm('search','physiotherapy?method=searchPhyWaitingListJsp');" class="button" />
</form>
<div class="clear"></div>--%>


<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
	<h4><span><%=message %></span></h4>
	<%} %>
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="dentalWaitingList" method="post" action="">
<div class="clear"></div>
<%
if(dentalWaitingList.size()>0)
{
	
%>
<input type="button" name="openButton" value="Open Token Display"	class="buttonBig" onclick="openTokenDisplay()"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonBig" />
<%} %>
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.HIN_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.SERVICE_NO %>"],[9,"<%= RequestConstants.PATIENT_NAME %>"],[10,"<%=RequestConstants.RELATION%>"],[11,"<%=RequestConstants.RANK%>"],[12,"<%=RequestConstants.SERVICE_PERSON_NAME%>"],[13,"<%=RequestConstants.AGE%>"],[14,"<%=RequestConstants.SEX%>"] ];
//	statusTd =14;

	</script></div>

<div id="edited"></div>
<div class="clear"></div>

<label>&nbsp;</label>
<div id="statusMessage"></div>

</form>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "Token No"
	data_header[1][1] = "hide";
	data_header[1][2] = "8%";
	data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"

	data_header[2] = new Array;
	data_header[2][0] = "Visit Number"
	data_header[2][1] = "hide";
	data_header[2][2] = "10%";
	data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";

	data_header[3] = new Array;
	data_header[3][0] = "Visit Date"
	data_header[3][1] = "hide";
	data_header[3][2] = "5%";
	data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";

	data_header[4] = new Array;
	data_header[4][0] = "Visit Time"
	data_header[4][1] = "hide";
	data_header[4][2] = "6%";
	data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";

	data_header[5] = new Array;
	data_header[5][0] = "HIN No."
	data_header[5][1] = "hide";
	data_header[5][2] = "5%";
	data_header[5][3] = "<%=RequestConstants.HIN_NO %>";

	data_header[6] = new Array;
	data_header[6][0] = "Appointment Type"
	data_header[6][1] = "hide";
	data_header[6][2] = "5%";
	data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";

	data_header[7] = new Array;
	data_header[7][0] = "Service No."
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "<%=RequestConstants.SERVICE_NO %>";

	
	data_header[8] = new Array;
	data_header[8][0] = "Patient Name"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "<%=RequestConstants.PATIENT_NAME %>";
	
	data_header[9] = new Array;
	data_header[9][0] = "Relation"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "<%=RequestConstants.RELATION %>";

	data_header[10] = new Array;
	data_header[10][0] = "Rank"
	data_header[10][1] = "data";
	data_header[10][2] = "6%";
	data_header[10][3] = "<%=RequestConstants.RANK %>";

	data_header[11] = new Array;
	data_header[11][0] = "Name"
	data_header[11][1] = "data";
	data_header[11][2] = "1%";
	data_header[11][3] = "<%=RequestConstants.SERVICE_PERSON_NAME%>";

	data_header[12] = new Array;
	data_header[12][0] = "Age"
	data_header[12][1] = "data";
	data_header[12][2] = "6%";
	data_header[12][3] = "<%=RequestConstants.AGE %>";

	data_header[13] = new Array;
	data_header[13][0] = "Gender"
	data_header[13][1] = "data";
	data_header[13][2] = "1%";
	data_header[13][3] = "<%=RequestConstants.SEX%>";
	
	
	
	

	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	for(Visit visit:dentalWaitingList){
		
		Patient patient = new Patient();
		patient = visit.getHin();
		
	//Visit visit= (Visit) iterator.next();
//	if(visit.getVisitStatus().equalsIgnoreCase("w"))
	//{
	//MasDepartment deptObj=(MasDepartment)visit.getDepartment();
	String patientName="";
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null)
	{
		patientName=patientName+" "+patient.getPLastName();
	}
	String sName="";
	if(patient.getSFirstName()!= null){
		sName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
		sName=sName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null)
	{
		sName=sName+" "+patient.getSLastName();
	}

	MasAdministrativeSex masAdministrativeSex=patient.getSex();
	//String visitDate =HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate());
	%>

	data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] =<%=visit.getId()%>

	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= visit.getId()%>" id="parent" />'

	<%
	if(visit.getTokenNo()!=null)
	{
	%>
	data_arr[<%= i%>][2] = "<%=visit.getTokenNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][2] = ""
	<%
	}
	if(visit.getVisitNo()!=null)
	{
	%>
	data_arr[<%= i%>][3]="<%=visit.getVisitNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3]=""
	<%
	}
	if(visit.getVisitDate()!= null )
	{
	%>
	data_arr[<%= i%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>"
	<%
	}
	%>
	
	<%
	if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
	{
	%>
	data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
	<%
	}
	%>
	
	<%
	
	if(patient.getHinNo()!= null ||patient.getHinNo() != "")
	{
	%>
	data_arr[<%= i%>][6] = "<%=patient.getHinNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][6] = ""
	<%
	}
	if(visit.getAppointmentType() != null || visit.getAppointmentType() !="")
	{
	%>
	data_arr[<%= i%>][7] = "<%=visit.getAppointmentType()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][7] = ""
		<%
	}
	if(patient.getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][8] = "<%=patient.getServiceNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""

		<%
	}%>
	
	<%
	if(patientName!= null )
	{
	%>
	data_arr[<%= i%>][9] = "<%=patientName%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][9] = ""
	<%}%>


	<%
	if(patient.getRelation().getRelationName()!= null )
	{
	%>
	data_arr[<%= i%>][10] = "<%=patient.getRelation().getRelationName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][10] = ""
	<%
	}%>

	<%
	if(patient.getRank().getRankName()!= null )
	{
	%>
	data_arr[<%= i%>][11] = "<%=patient.getRank().getRankName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][11] = ""
	<%
	}%>

	<%
	if(sName!= null )
	{
	%>
	data_arr[<%= i%>][12] = "<%=sName%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][12] = ""
	<%}%>
	
	<%if(patient.getAge() != null)
	{
	%>

	data_arr[<%= i%>][13] = "<%=patient.getAge()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][13] = ""
	<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
	%>
	data_arr[<%= i%>][14] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][14] = ""
	<%}
	%>

		
	<%
	i++;
	//}
	}

	}catch(Exception e){
	e.printStackTrace();

	}
	%>
	formName = "dentalWaitingList"

	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<div class="clear"></div>


<input type="hidden" name="counter" id="counter" value="<%=i %>" /> 
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">

	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;

	}
	function openTokenDisplay()
	{
	 var url="/hms/hms/dental?method=showDentalPopupTokenJsp";
	 newwindow=window.open(url,'opentoken','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
	}
	function closeTokenDisplay(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}

	}

	function validateRadio(){
		if(document.getElementById('flagType').value =='Appointment'){
		 for(var i = 0; i < document.getElementsByName('physioRequisitionHeaderId').length; i++){
			  if(document.getElementsByName('physioRequisitionHeaderId')[i].checked == true)
	         {
				return true;
			  }		
		 }
		}else{
			for(var i = 0; i < document.getElementsByName('physioRequisitionHeaderId').length; i++){
				  if(document.getElementsByName('physioRequisitionHeaderId')[i].checked == true)
		         {
					return true;
				  }		
			}
		}
	
		alert("Please select one record.")
		return false;
	}
	
	


</script>

