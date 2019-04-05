<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SESSION_ID"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%-- <%@page import="jkt.hms.masters.business.MasUnit"%> --%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasRank"%><script
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

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	/* List<MasUnit> unitList = new ArrayList<MasUnit>(); */
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasRank> rankList = new ArrayList<MasRank>();
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
/* 	if(map.get("unitList") != null){
	 unitList=(List)map.get("unitList");
	} */
	if(map.get("relationList") != null){
		relationList=(List)map.get("relationList");
	}
	if(map.get("rankList") != null){
		rankList=(List)map.get("rankList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}
	

	int empId=0;
	if(map.get("docId")!=null){
		empId = (Integer)map.get("docId");
	}
	/* if(session.getAttribute("empId")!=null){
		empId = (Integer)session.getAttribute("empId");
	} */
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	int proierty=0;
	
	String dentalCode ="";
	if (map.get("dentalCode") != null) {
		dentalCode = (String) map.get("dentalCode");
	}

	List<Integer> referredVisitIdList = new ArrayList();
	if(map.get("referredVisitIdList") != null)
	{
		referredVisitIdList=(List<Integer>)map.get("referredVisitIdList");
	}
	
	if(map.get("sessionList") != null){
		sessionList=(List)map.get("sessionList");
	}

	%>

<div class="titleBg">
<h2><%=deptName%> Recall Patient List</h2>
</div>
<div class="clear"></div>
<%--

<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
 thread search menu 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="search" action="" method="post">
<label>HIN Number </label>
<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"	MAXLENGTH="30" tabindex=1 />
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<input type="hidden" name="date" id="date" value="<%=date %>" />
<div class="clear"></div>
<label>Patient First Name  </label>
<input type="text"	name="<%= RequestConstants.P_FIRST_NAME %>" id="patientFName"	MAXLENGTH="30" tabindex=1 />
<label>Patient Middle Name </label>
<input type="text"	name="<%= RequestConstants.P_MIDDLE_NAME %>" id="patientMName"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient Last Name </label>
<input	type="text" name="<%= RequestConstants.P_LAST_NAME %>"	id="pateintLName" MAXLENGTH="30" tabindex=1 />
<input type="button" onClick="submitForm('search','opd?method=searchWaitingPatientListJsp&filter=true');" class="button" /></form>
</div>

--%>
<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
<h4><span><%=message %></span></h4>
<%} %>

<form name="opdRecallPatientList" method="post" action="">
<div class="clear"></div>
<%-- <div class="Block"><label>Medical Officer</label> <select
	name="consultingDoc">
	<option value="0">All</option>
	<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			if(user.getEmployee().getId() == doctorId){
%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
		}
	}
} %>
</select> <input type="button" name="Go" value="Go"
	onClick="submitForm('opdPatientList','opd?method=showWaitingPatientListJsp&filter=true')"
	class="buttonSm" /></div> --%>
<div class="clear"></div>
<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
%> <!-- <input type="button" name="openButton" value="Open Token Display"
	class="buttonBig" onclick="openTokenDisplay()" /> <input type="button"
	name="closeButton" value="Close Token Display"
	onclick="closeTokenDisplay()" class="buttonBig" /> --> <%}%>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%-- <div class="floatRight"><label class="auto">Total Waiting:</label> <label class="valueAuto"><%=totalPatient%></label></div> --%>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<%-- <label>Unit </label> 
<select id="unitId" name="unitId" tabindex="1" validate="Unit,string,no">
	<option value="0">Select</option>
	<%
		 for(MasUnit masUnit : unitList){
		 %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
	 }%>

</select> --%>
<%--  <label>Designation</label> <select id="rankId" name="rankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select>  --%>
<label>OP Date</label>
<input  type="text" class="calDate"  id="visitDate" name="visitDate" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'lmp_date');"  maxlength="10" style="width: 120px"/>
<label>Doctor List </label>
		<select id="doctorId" name="doctorId">
		<option value="0">Select</option>
		<%
		String docName ="";
		for(MasEmployeeDepartment empDept :doctorList){
			docName=empDept.getEmployee().getFirstName();
	   		if(empDept.getEmployee().getMiddleName()!=null)
	   		{
	   			docName+=" "+empDept.getEmployee().getMiddleName();
	   		}
	   		if(empDept.getEmployee().getLastName()!=null)
	   		{
	   			docName+=" "+empDept.getEmployee().getLastName();
	   		}
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
		<div class="clear"></div>
<label> Employee No.</label> <input type="text" name="serviceNo"
	value="" MAXLENGTH="30" validate="Service No,metachar,no" />
	<label>Patient Name</label> <input type="text" name="<%=PATIENT_NAME%>"></input>

<%-- <label>Relation </label> <select id="relationId" name="relationId"
	tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRelation masRelation: relationList) 
				{
			 		%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%
			 		}%> 
</select>--%>

<input type="button" name="search" value="Search"
	onClick="submitForm('opdRecallPatientList','opd?method=getOPRecallWaitingList')"
	class="button" /><input type="button" name="reset" value="Reset"
	onClick="submitForm('opdRecallPatientList','opd?method=getOPRecallWaitingList')"
	class="button" />
	<div class="clear"></div>
<div class="clear"></div>
</div>

</form>
<div class="clear"></div>

<div class="floatRight"><jsp:include
	page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2" class="noBg"></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.HIN_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	statusTd =12;

	</script></div>

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
	data_header[7][0] = "Employee No."
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
	data_header[10][0] = "Service No."
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "<%=RequestConstants.SERVICE_NO %>";
	
	data_header[11] = new Array;
	data_header[11][0] = "Designation"
	data_header[11][1] = "data";
	data_header[11][2] = "10%";
	data_header[11][3] = "<%=RequestConstants.RANK %>";
	
	data_header[12] = new Array;
	data_header[12][0] = "Name"
	data_header[12][1] = "data";
	data_header[12][2] = "10%";
	data_header[12][3] = "<%=RequestConstants.SERVICE_PERSON_NAME %>";

	data_header[13] = new Array;
	data_header[13][0] = "Age"
	data_header[13][1] = "data";
	data_header[13][2] = "6%";
	data_header[13][3] = "<%=RequestConstants.AGE %>";
	
	data_header[14] = new Array;
	data_header[14][0] = "Gender"
	data_header[14][1] = "data";
	data_header[14][2] = "1%";
	data_header[14][3] = "<%=RequestConstants.SEX%>";

	data_header[15] = new Array;
	data_header[15][0] = "Diagnosis"
	data_header[15][1] = "hide";
	data_header[15][2] = "10%";
	data_header[15][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";

	data_header[16] = new Array;
	data_header[16][0] = "I-Card Status"
	data_header[16][1] = "hide";
	data_header[16][2] = "1%";
	data_header[16][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";

	data_header[17] = new Array;
	data_header[17][0] = "Detained"
	data_header[17][1] = "hide";
	data_header[17][2] = "10%";
	data_header[17][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";
	data_header[17][4] = "10%";

	data_header[18] = new Array;
	data_header[18][0] = "Visit Number"
	data_header[18][1] = "hide";
	data_header[18][2] = "10%";
	data_header[18][3] = "<%= RequestConstants.VISIT_NUMBER %>";
	data_header[18][4] = "10%";
	
	data_header[19] = new Array;
	data_header[19][0] = "OPD Type"
	data_header[19][1] = "data";
	data_header[19][2] = "6%";
	
	data_header[20] = new Array;
	data_header[20][0] = "Action"
	data_header[20][1] = "hide";
	data_header[20][2] = "6%";
	
	
	data_header[21] = new Array;
	data_header[21][0] = "Action"
	data_header[21][1] = "hide";
	data_header[21][2] = "6%";
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";

	Iterator iterator=patientList.iterator();
    Set<OpdPatientDetails> opdPDt = null;
    //boolean skipRow = false;
	
	while(iterator.hasNext())
	{
		//skipRow = false;
	Visit visit= (Visit) iterator.next();
	opdPDt =  visit.getOpdPatientDetails();
/* 	for( OpdPatientDetails opd: opdPDt)
	{
		//System.out.println(opd.getId()+ " "+ opd.getVisit().getId() + opd.getReferredStatus() +" "+opd.getAdmissionAdvised());
		if(opd.getReferredStatus()!=null && opd.getReferredStatus().equalsIgnoreCase("y") )
			skipRow = true;
		else if (opd.getAdmissionAdvised()!=null && opd.getAdmissionAdvised().equalsIgnoreCase("y"))
		skipRow = true;
			
			
	} */
	//if(opdPDt!=null && opdPDt)
	
	//if(visit.getVisitStatus().equalsIgnoreCase("c") && !skipRow)
   if(visit.getVisitStatus().equalsIgnoreCase("c"))
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
	}%>
	
	<%-- 
<%	if(visit.getTokenNo()!=null)
	{
	%>
	data_arr[<%= i%>][3] = "<%=visit.getTokenNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = ""
	<%
	}%> --%>
	
	
	<%if(visit.getSession()!=null)
	{
	%>
	<%-- data_arr[<%= i%>][3] = " <%=visit.getSession().getId()==1?"M-":visit.getSession().getId()==2?"E-":""%>  <%=visit.getTokenNo()%>" --%>
	data_arr[<%= i%>][3] = " <%=visit.getSession().getId()==1?"M-":visit.getSession().getId()==2?"E-":""%>  <%=visit.getTokenNo()==null?"E": visit.getTokenNo()==0?"R":visit.getTokenNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = "<%=visit.getTokenNo()!=null?visit.getTokenNo():""%>"
	<%
	}
	
	
	if(visit.getVisitDate()!= null )
	{
	%>
	data_arr[<%= i%>][4] = "<%=visitDate%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][4] = ""
	<%
	}if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
	{
	%>
	data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][5] = ""
	<%
	}
	if(visit.getHin().getHinNo()!= null ||visit.getHin().getHinNo() != "")
	{
	%>
	data_arr[<%= i%>][6] = "<%=visit.getHin().getHinNo()%>"
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
		<%}%>
		<%
	if(visit.getHin().getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][8] = '<%= visit.getHin().getServiceNo()%>'
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ''
     <%}%>
     <%
 	if(visit.getHin().getServiceNo()!= null )
 	{
 	%>
 	data_arr[<%= i%>][8] = "<%=visit.getHin().getServiceNo()%>"
 	<%
 	}else{
 	%>
 	data_arr[<%= i%>][8] = ""
      <%}%>
      <%
   	if(visit.getHin().getPFirstName()!= null )
   	{
   		String fname=visit.getHin().getPFirstName();
   		if(visit.getHin().getPMiddleName()!=null)
   		{
   			fname+=" "+visit.getHin().getPMiddleName();
   		}
   		if(visit.getHin().getPLastName()!=null)
   		{
   			fname+=" "+visit.getHin().getPLastName();
   		}
   	%>
   	data_arr[<%= i%>][9] = "<%=fname%>"
   	<%
   	}else{
   	%>
   	data_arr[<%= i%>][9] = ""
        <%}%>
	
		<%
	
	if(visit.getHin().getRelation().getNewRelationName()!= null )
	{
	%>
	data_arr[<%= i%>][10] = "<%=visit.getHin().getRelation().getNewRelationName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][10] = ""

		<%}%>

		<%
		if(visit.getHin().getServiceNo()!= null )
		{
		%>
		data_arr[<%= i%>][11] ='<%= visit.getHin().getServiceNo()%>'
		<%
		}else{
		%>
		data_arr[<%= i%>][11] = ''
	     <%}%>
	     <%
	 	if(visit.getHin().getServiceNo()!= null )
	 	{
	 	%>
	 	data_arr[<%= i%>][11] = "<%=visit.getHin().getServiceNo()%>"
	 	<%
	 	}else{
	 	%>
	 	data_arr[<%= i%>][11] = ""
	      <%}%>
	      
			
		 <%
		 	if(visit.getHin().getRank()!= null )
		 	{
		 	%>
		 	data_arr[<%= i%>][12] = "<%=visit.getHin().getRank().getRankName()%>"
		 	<%
		 	}else{
		 	%>
		 	data_arr[<%= i%>][12] = ""
		      <%}%>
		  		  				
	<%
	
	if(servicepatientName!= null )
	{
	%>
	data_arr[<%= i%>][13] = "<%=servicepatientName%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][13] = ""
	<%}
	if(visit.getHin().getAge() != null)
	{
	%>

	data_arr[<%= i%>][14] = "<%=visit.getHin().getAge()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][14] = ""
	<%   }
	if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
	%>
	data_arr[<%= i%>][15] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][15] = ""
	<%}

	if(visit.getWorkingDiagnosis()!= null){

	%>
	<%-- data_arr[<%= i%>][16] = "<%=visit.getWorkingDiagnosis()%>" --%>
	data_arr[<%= i%>][16] = "";
	<%
	}else{
	%>
	data_arr[<%= i%>][16] = ""
	<%}%>
	data_arr[<%= i%>][17] = ""
	data_arr[<%= i%>][18] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=patientHin.getServiceCardStatus()%>"  />'
	<%
	if(visit.getVisitNo()!=null)
	{
	%>
	data_arr[<%= i%>][19]="<%=visit.getVisitNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][19]=""
	<%
	}
	
	%>
	<%
	//if( referredVisitIdList.contains(visit.getId()))
			if(visit.getRefereeOpdPatientdetailsId()!=null)
	{
	%>
	data_arr[<%= i%>][20]="Referral Case"
	<%
	}else{
	%>
	data_arr[<%= i%>][20]="Normal OPD"
	<%
	}
	
	%>
	var visitid =  <%=visit.getId()%> 
	var tokenNo =  '<%=visit.getTokenNo()%>';
	data_arr[<%= i%>][21] ="<input type='button' name='btn' id='btn' value='Release' onclick='doPatientRelease("+visitid+");'/>";
	
	<%
	if(visit.getDepartment()!=null && dentalCode!=null && dentalCode.equalsIgnoreCase(visit.getDepartment().getDepartmentCode()))
	{ System.out.println(visit.getDepartment().getDepartmentCode() +" both code "+ dentalCode);
	%>
	data_arr[<%= i%>][22]="<%=visit.getDepartment().getDepartmentCode()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][22]=""
	<%
	}
	
	%>
	
	
	<%	
	i++;
	}
	}

	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "opdRecallPatientList"

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

var bReleaseClick='N';

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
	
	function doPatientRelease(visitId)
	{
		//alert(bReleaseClick);
		
			bReleaseClick ='Y';
		 	var data = "visitId="+visitId;
		    var url = "opd?method=doPatientRelease";
		    
		 	    
		  jQuery(function ($) {
		  
		    	$.ajax({
					type:"POST",
					url: url,
					 data: data,	 
					 dataType: "text",
					cache: false,
					success: function(msg)
					{									 
								
						
						if(msg.indexOf("success~~~true") != -1)
							{
									alert("Release successfully");
									bReleaseClick ='N';
									window.location ="opd?method=showWaitingPatientListJsp&selectedAppId=A1641";
									
							}
						else
							{
								bReleaseClick ='N';
								alert("An error has occurred while contacting the server");
							}
						
					},
					error: function(msg)
					{					
						bReleaseClick ='N';
						alert("An error has occurred while contacting the server");
						
					}
					
					
				});
		    });   

	}	

</script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>
