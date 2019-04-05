
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	//<!--
	//var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	//var IMGDIR_MISC = "images/misc";
	//var vb_disable_ajax = parseInt("0", 10);
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


	List<MasEmployee> doctorList = null;

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}

	List patientList = new ArrayList();
	int totalPatient=0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
		
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
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
	%>

<div class="titleBg">
<h2>Waiting List</h2>
</div>
<div class="clear"></div>

<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
	<h4><span><%=message %></span></h4>
	<%} %>

<form name="fwcPatientList" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label>Medical Officer</label>
<select	name="consultingDoc">
	<option value="0">All</option>
	<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
	}
} %>
</select>
<input type="button" name="Go" value="Go"	onClick="submitForm('fwcPatientList','fwc?method=showWaitingPatientListJsp&filter=true')"	class="buttonSm"	/>
</div>
<div class="clear"></div>
<%-- 
<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
%>
<input type="button" name="openButton" value="Open Token Display"	class="buttonBig" onclick="openTokenDisplay()"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonBig" />

<%}%>

<div class="floatRight"><label class="auto">Total Waiting Patient : </label>
<label	class="valueAuto"><%=totalPatient%></label>
</div>
<div class="clear"></div>
--%>
</form>
<div class="clear"></div>

<div class="floatRight">
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "priority"], [2,"<%= RequestConstants.TOKEN_NO %>"], [3,"<%= RequestConstants.SERVICE_NO %>"],[4,"<%= RequestConstants.PATIENT_NAME %>"],[5,"<%= RequestConstants.RELATION_NAME %>"],[6,"<%=RequestConstants.RANK_NAME%>"],[7,"<%= RequestConstants.NAME %>"],[8,"<%=RequestConstants.AGE%>"],[9,"<%=RequestConstants.FWC_CATEGORY%>"],[10, "detained"],[11, "hinId"]];
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
data_header[0][0] = "Priority"
data_header[0][1] = "data";
data_header[0][2] = "5%";
data_header[0][3] = "priority"

data_header[1] = new Array;
data_header[1][0] = "Token No."
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%= RequestConstants.TOKEN_NO %>";


data_header[2] = new Array;
data_header[2][0] = "Service No."
data_header[2][1] = "data";
data_header[2][2] = "5%";
data_header[2][3] = "<%=RequestConstants.SERVICE_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[4] = new Array;
data_header[4][0] = "Relation"
data_header[4][1] = "data"
data_header[4][2] = "10%" 
data_header[4][3] = "<%= RequestConstants.RELATION_NAME %>";  

data_header[5] = new Array;
data_header[5][0] = "Rank"
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "<%=RequestConstants.RANK_NAME %>";

data_header[6] = new Array;
data_header[6][0] = "Name"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "<%=RequestConstants.NAME %>";

data_header[7] = new Array;
data_header[7][0] = "Age"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.AGE %>";

data_header[8] = new Array;
data_header[8][0] = "Category"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%=RequestConstants.FWC_CATEGORY %>";

 data_header[9] = new Array;
	data_header[9][0] = "Detained"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "detained";
	data_header[9][4] = "10%";
 data_arr = new Array();

 data_header[10] = new Array;
	data_header[10][0] = "hinId"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "hinId";
	data_header[10][4] = "10%";
 data_arr = new Array();
	<%
	int  i=0;
	try{
		String st="";

		Iterator iterator=patientList.iterator();
		while(iterator.hasNext()){
		  Visit visit= (Visit) iterator.next();
		if(visit.getVisitStatus().equalsIgnoreCase("w"))
		{
		Patient patientHin=(Patient)visit.getHin();
		MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		String servicepatientName="";
		if(visit.getHin().getSFirstName()!= null){
			servicepatientName=visit.getHin().getSFirstName();
		}
		if(visit.getHin().getSMiddleName()!= null){
			servicepatientName=servicepatientName+" "+visit.getHin().getSMiddleName();
		}
		if(visit.getHin().getSLastName()!= null)
		{
			servicepatientName=servicepatientName+" "+visit.getHin().getSLastName();
		}
		String patientName="";
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null)
		{
			patientName=patientName+" "+visit.getHin().getPLastName();
		}
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		%>

		data_arr[<%= i%>] = new Array();
		
		data_arr[<%= i%>][0] =<%=visit.getId()%>
	<%	if(visit.getPriority()!= null)
		{
		%>
		data_arr[<%= i%>][1] = "<%=visit.getPriority()%>"
		<%}else{
			%>
			data_arr[<%= i%>][1] = "0"
				<%}%>
		data_arr[<%= i%>][2] = '<%=visit.getTokenNo()%>'
		<%
		if(visit.getHin().getServiceNo()!= null )
		{
		%>
		data_arr[<%= i%>][3] = "<%=visit.getHin().getServiceNo()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][3] = ""

			<%
		}
			if(patientName!= null )
			{
			%>
			data_arr[<%= i%>][4] = "<%=patientName%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][4] = ""
			<%}if(visit.getHin().getRelation()!= null){%>
			data_arr[<%= i%>][5] = "<%=visit.getHin().getRelation().getRelationName()%>"
			<%}else{%>
			data_arr[<%= i%>][5] = ""
				
		<%	}
		
		if(visit.getHin().getRank().getRankName()!= null )
		{
		%>
		data_arr[<%= i%>][6] = "<%=visit.getHin().getRank().getRankName()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][6] = ""
			
		<%
		}
		if(servicepatientName!= null )
		{
		%>
		data_arr[<%= i%>][7] = "<%=servicepatientName%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][7] = ""
		<%}
		if(visit.getHin().getAge() != null)
		{
		%>

		data_arr[<%= i%>][8] = "<%=visit.getHin().getAge()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][8] = ""
		<%   }%>
		<%if(visit.getFwcCategory()!= null )
		{
		%>
		data_arr[<%= i%>][9] = "<%=visit.getFwcCategory()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][9] = ""
		<%}%>
		data_arr[<%= i%>][10] = ""
			<%
			if(visit.getHin()!= null)
			{
			%>
			data_arr[<%= i%>][11] = "<%=visit.getHin().getId()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][11] = "0"
			<%}%>
		
			
				<%}
		i++;
		totalPatient++;
		}
		}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "fwcPatientList"

	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly" >
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Priority-3</label> 


<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
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
	 var url="/hms/hms/fwc?method=showPopupTokenJsp";
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
</script>
