<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SESSION_ID"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%-- <%@page import="jkt.hms.masters.business.MasUnit"%> --%>
<%-- <%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasRank"%> --%> <!-- commented unused code by Babita Dangwal on 21-09-2017 -->

<script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%

Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader()
.getResource("adt.properties");
try {
properties.load(resourcePath.openStream());
} catch (Exception e) {
e.printStackTrace();
}
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	List<MasSession> sessionList = new ArrayList<MasSession>();
	List<MasEmployeeDepartment> doctorList = null;

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}

	List patientList = new ArrayList();
	int totalPatient=0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}

	
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	int proierty=0;
	if(map.get("sessionList") != null){
		sessionList=(List)map.get("sessionList");
	}
	int empId=0;
	if(map.get("docId")!=null){
		empId = (Integer)map.get("docId");
	}
	%>

<div class="titleBg">
<h2><%=deptName%> Waiting List</h2>
</div>
<div class="clear"></div>

<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
<h4><%=message %></h4>
<%} %>

<form name="opdVaccinePatientList" method="post" action="">
<div class="clear"></div>

<div class="clear"></div>
<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
%> <input type="button" name="openButton" value="Open Token Display"
	class="buttonBig" onclick="openTokenDisplay()" /> <input type="button"
	name="closeButton" value="Close Token Display"
	onclick="closeTokenDisplay()" class="buttonBig" /> <%}%>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="floatRight"><label class="auto">Total Waiting:</label> <label class="valueAuto"><%=totalPatient%></label></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="Block">

<label>Doctor List </label>
		<select id="doctorId" name="doctorId">
		<option value="0">Select</option>
		<%
		String docName ="";
		for(MasEmployeeDepartment empDept :doctorList){
			docName = empDept.getEmployee().getFirstName();
	   		if(empDept.getEmployee().getId() == empId)
	   		{
	   			%>
				
	   			<option value="<%=empDept.getEmployee().getId()%>" selected><%=docName%></option>
	   			<%
	   		}
	   		else
	   		{
	   			%>
				
	   			<option value="<%=empDept.getEmployee().getId()%>"><%=docName%></option>
	   			<%	
	   		}
			} %>
		</select>
		
		<label>Session </label>
		<select id="<%=SESSION_ID %>" name="<%=SESSION_ID%>">
		<option value="0">Select</option>
		<%
		//String docName ="";
		for(MasSession masSes :sessionList){
	
			%>
		<option value="<%=masSes.getId()%>"><%=masSes.getSessionName()%></option>
		<%} %>
		</select>
<label> Employee No.</label> <input type="text" name="serviceNo"
	value="" MAXLENGTH="30" validate="Service No,metachar,no" />
	<label>Patient Name</label> <input type="text" name="<%=PATIENT_NAME%>"></input>
<input type="button" name="search" value="Search"
	onClick="submitForm('opdVaccinePatientList','opd?method=showWaitingPatientListJsp')"
	class="button" /><input type="button" name="reset" value="Reset"
	onClick="submitForm('opdVaccinePatientList','opd?method=showWaitingPatientListJsp')"
	class="button" />
	<div class="clear"></div>
<div class="clear"></div>
</div>

</form>
<div class="clear"></div>
<div class="floatRight">

<jsp:include page="searchResultBlockForIPD.jsp"/>
<div class="clear"></div>
<div id="test">
<!-- <div class="cmntable"> -->
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2" class="noBg"></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.HIN_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	statusTd =12;

	</script>
</div>
<!-- </div> -->

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
</div>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "Priority"
	data_header[1][1] = "hide";
	data_header[1][2] = "10%";
	data_header[1][3] = "Priority";
	
	data_header[2] = new Array;
	data_header[2][0] = "Token No."
	data_header[2][1] = "data";
	data_header[2][2] = "8%";
	data_header[2][3] = "<%= RequestConstants.TOKEN_NO%>"


	data_header[3] = new Array;
	data_header[3][0] = "Employee No."
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "<%=RequestConstants.SERVICE_NO %>";

	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "<%=RequestConstants.PATIENT_NAME %>";

	data_header[5] = new Array;
	data_header[5][0] = "Relation"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "<%=RequestConstants.RELATION %>";

	
	
	data_header[6] = new Array;
	data_header[6][0] = "Designation"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "<%=RequestConstants.RANK %>";
	
	data_header[7] = new Array;
	data_header[7][0] = "Name"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "<%=RequestConstants.SERVICE_PERSON_NAME %>";

	data_header[8] = new Array;
	data_header[8][0] = "Age"
	data_header[8][1] = "data";
	data_header[8][2] = "6%";
	data_header[8][3] = "<%=RequestConstants.AGE %>";
	
	data_header[9] = new Array;
	data_header[9][0] = "Gender"
	data_header[9][1] = "data";
	data_header[9][2] = "1%";
	data_header[9][3] = "<%=RequestConstants.SEX%>";
	
	data_header[10] = new Array;
	data_header[10][0] = "OPD Type"
	data_header[10][1] = "data";
	data_header[10][2] = "6%";
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";

	Iterator iterator=patientList.iterator();

	while(iterator.hasNext())
	{
	Visit visit= (Visit) iterator.next();
	if(visit.getVisitStatus().equalsIgnoreCase("r") ||visit.getVisitStatus().equalsIgnoreCase("w"))
	{
	Patient patientHin=(Patient)visit.getHin();
	MasDepartment deptObj=(MasDepartment)visit.getDepartment();
	String servicepatientName="";
	if(visit.getHin().getPFirstName()!= null){
		servicepatientName=visit.getHin().getSFirstName();
	}
	if(visit.getHin().getSMiddleName()!= null){
		servicepatientName=servicepatientName+" "+visit.getHin().getSMiddleName();
	}
	if(visit.getHin().getSLastName()!= null)
	{
		servicepatientName=servicepatientName+" "+visit.getHin().getSLastName();
	}

	MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
	String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	%>

	data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] =<%=visit.getId()%>

	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= visit.getId()%>" id="parent" />'

	<%
	if(visit.getPriority()!=null){
		
		%>
			data_arr[<%= i%>][2] ="<%=visit.getPriority()%>"
				<%
		}else{
				%>
				data_arr[<%= i%>][2] ="0"
		<%
	}
	if(visit.getSession()!=null)
	{
	%>
	data_arr[<%= i%>][3] = " <%=visit.getSession().getId()==1?"M-":visit.getSession().getId()==2?"E-":""%>  <%=visit.getTokenNo()==0?"R":visit.getTokenNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = "<%=visit.getTokenNo()!=null?visit.getTokenNo():""%>"
	<%
	}%>
	
		<%
	if(visit.getHin().getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][4] = '<%= visit.getHin().getServiceNo()%>'
	<%
	}else{
	%>
	data_arr[<%= i%>][4] = ''
     <%}%>

      <%
   	if(visit.getHin().getPFirstName()!= null )
   	{
   		String fname=visit.getHin().getPFirstName();

   	%>
   	data_arr[<%= i%>][5] = "<%=fname%>"
   	<%
   	}else{
   	%>
   	data_arr[<%= i%>][5] = ""
        <%}%>
	
		<%
	if(visit.getHin().getRelation().getNewRelationName()!= null )
	{
	%>
	data_arr[<%= i%>][6] = "<%=visit.getHin().getRelation().getNewRelationName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][6] = ""

		<%}%>
		 <%
		 	if(visit.getHin().getRank()!= null )
		 	{
		 	%>
		 	data_arr[<%= i%>][7] = "<%=visit.getHin().getRank().getRankName()%>"
		 	<%
		 	}else{
		 	%>
		 	data_arr[<%= i%>][7] = ""
		      <%}%>
		  		  				
	<%
	
	if(servicepatientName!= null )
	{
	%>
	data_arr[<%= i%>][8] = "<%=servicepatientName%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""
	<%}
	if(visit.getHin().getAge() != null)
	{
	%>

	data_arr[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][9] = ""
	<%   }
	if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
	%>
	data_arr[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][10] = ""
	<%}%>
	<%
	//if( referredVisitIdList.contains(visit.getId()))
		if(visit.getRefereeOpdPatientdetailsId()!=null)
	{
	%>
	data_arr[<%= i%>][11]="Referral Case"
	<%
	}else{
	%>
	data_arr[<%= i%>][11]="Normal OPD"
	<%
	}
	
	%> 
	
	var visitid =  <%=visit.getId()%> 
	var tokenNo =  '<%=visit.getTokenNo()%>';
	<%	
	i++;
	}
	}

	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "opdVaccinePatientList"

	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<input type="text" class="signPriority1" readonly="readonly">
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly">
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly">
<label class="valueAutoPriority">Priority-3</label>
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>
<script type="text/javascript">
	function openTokenDisplay()
	{
	 var url="/hms/hms/opd?method=showPopupTokenJsp";
	newwindow=window.open(url,'opentoken','left=0,top=0,height=800,width=1024,location=0,toolbar=0,menubar=0,status=no,scrollbars=0,resizable=0');
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
	


	
</script>


