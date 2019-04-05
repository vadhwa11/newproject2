<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>

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



	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");


	List<MasEmployee> doctorList = null;

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}

	List patientList = new ArrayList();

	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}
	System.out.println("patienfgtList "+patientList.size());


	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}
	
	int deptId=0;


	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	int proierty=0;
	

	
	
	%>

<div class="titleBg">
<h2><%=deptName%> FAC Recall List</h2>
</div>
<div class="clear"></div>
<form name="searchPrescription" method="post" action="">
<div class="Block">
<div class="clear"></div>
<label> Employee No</label> 
<input type="text" name="employeeNo" id="employeeNo" onchange="submitForm('searchPrescription','/hms/hms/opd?method=getFACWaitingList');" value="" />

</div>
</form>
<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
<h4><%-- <%=map.get("message")%> --%></h4>
<%} %>

<form name="facWaitingList" method="post" action="">
<div class="clear"></div>

<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


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
	data_header[2][1] = "hide";
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
	data_header[6][0] = "Date"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
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
	

	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";

	Iterator iterator=patientList.iterator();

	while(iterator.hasNext())
	{
		Visit visit  = (Visit) iterator.next();
	//Visit visit= (Visit) pph.getVisit();
	
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
	if(visit.getTokenNo()!=null)
	{
	%>
	data_arr[<%= i%>][3] = "<%=visit.getTokenNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = ""
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
	if(visit.getVisitDate() != null)
	{
	%>
	data_arr[<%= i%>][7] = "<%=HMSUtil.convertDateToStringTypeDateOnly(visit.getVisitDate())%>"
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
	data_arr[<%= i%>][16] = ""
	<%
	}else{
	%>
	data_arr[<%= i%>][16] = ""
	<%}
	
	%>
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
	

	
	var visitid =  <%=visit.getId()%> 
	var tokenNo =  '<%=visit.getTokenNo()%>';
	data_arr[<%= i%>][21] ="<input type='button' name='btn' id='btn' value='Release' onclick='doPatientRelease("+visitid+");'/>";
	
	


	
	
	<%	
	i++;
	
	}

	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "facWaitingList"

	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>
