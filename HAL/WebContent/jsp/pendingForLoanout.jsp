<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="org.hibernate.criterion.Restrictions"%>

<form name="searchPrescription" action="" method="post">
<script	type="text/javascript" language="javascript">
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

	function validateDates()
	{
		var strValue = searchPrescription.<%=FROM_DATE%>.value;

        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = searchPrescription.<%=TO_DATE%>.value;

		    if(strValue=='')
	        {
	        	alert("To Date can't be Blank ....");
				return false;
	        }

	 	var toDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));

		if (fromDate > toDate)
	 	{
			alert('From Date cannot be greater than To Date!....');
			return false;
	 	}

	 	return true;

	}


	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	date = (String) utilMap.get("currentDate");
	String userName = "";
	String message = "";
	Date toDate  = null;
	Date fromDate = null;

	if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}

	if(map.get("detailsMap") !=null){
	detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(map.get("message") != null){
	message= (String)map.get("message");
	}
	if (map.get("fromDate") != null) {
	fromDate = (Date) map.get("fromDate");
	session.setAttribute("fromDate", fromDate);
	}
	if (map.get("toDate") != null) {
	toDate = (Date) map.get("toDate");
	session.setAttribute("toDate", toDate);
	}
	List<PatientPrescriptionHeader> prescriptionList = new ArrayList<PatientPrescriptionHeader>();
	if(detailsMap.get("prescriptionList")!= null){
		prescriptionList =(List<PatientPrescriptionHeader>) detailsMap.get("prescriptionList");
	}
	if(map.get("departmentList")!= null){
		departmentList =(List<MasDepartment>) map.get("departmentList");
	}
	List<MasEmployee> employeeList=new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null)
	{
		employeeList=(List<MasEmployee>)map.get("employeeList");
	}
	List<PatientPrescriptionHeader> pendingLoanoutList = new ArrayList<PatientPrescriptionHeader>();

	if (map.get("pendingLoanoutList") != null) {
			pendingLoanoutList = (List) map.get("pendingLoanoutList");
			System.out.println("pendingLoanoutList >"+pendingLoanoutList.size());
			}

	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	if (map.get("message") != null) {
	 	message = (String) map.get("message");
	  }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><%=message %></h4>
<%} %>

<div class="clear"></div>
<div class="titleBg">
<h2>PENDING FOR LOANOUT</h2>
</div>
<div class="Block">
<div class="clear"></div>
<label> From Date<span>*</span></label>
<input	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=FROM_DATE%>,event)" />
<label>To Date<span>*</span> </label>
<input type="text" class="calDate"	id="fromDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"	readonly="readonly" MAXLENGTH="30" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=TO_DATE%>,event)" />
<label>Department</label>
<select name="<%=DEPARTMENT_ID %>" >
<option value="0">Select</option>
<%
	for(MasDepartment department : departmentList){
		%>
		<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%}
%>
</select>
<div class="clear"></div>
<label>MO</label>
<select name="<%=MEDICAL_OFFICER%>" >
<option value="0">Select</option>
<%

   // System.out.println(" employeeList size"+employeeList.size());
	for(MasEmployee employee : employeeList)
	{    String mname="";
	     if(employee.getMiddleName()!=null)
	      mname=employee.getMiddleName();
		String name=employee.getRank().getRankName()+" " +employee.getFirstName()+" "+mname+" "+(employee.getLastName()!=null?employee.getLastName():"");
		%>
		<option value="<%=employee.getId() %>"><%=name %></option>
	<%}
%>
</select>
<div class="clear"></div>
</div>
<input type="button" name="search" id="addbutton"	onclick="if(validateDates()){submitForm('searchPrescription','/hms/hms/opd?method=searchPrescription');}"	value="Search" class="button" accesskey="a" />
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="pendingPrescription1" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "prescriptionId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serNo"],[6,"sPerName"],[7,"relation"],[8,"patName"], [9,"age"], [10,"sex"],[11,"pType"][1,"serviceType"],[5,"serviceType"],[13,"doct"]];
		statusTd = 13;
	</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>


<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Prescription No."
data_header[0][1] = "data";
data_header[0][2] = "4%";
data_header[0][3] = "<%=PRESCRIPTION_NO%>";

data_header[1] = new Array;
data_header[1][0] = " Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=PRESCRIPTION_DATE%>";

data_header[2] = new Array;
data_header[2][0] = " Time"
data_header[2][1] = "data";
data_header[2][2] = "7%";
data_header[2][3] = "<%=PRESCRIPTION_TIME%>";

/*data_header[3] = new Array;
data_header[3][0] = "HIN"
data_header[3][1] = "data";
data_header[3][2] = "8%";
data_header[3][3] = "hin";*/


data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "patName";


data_header[4] = new Array;
data_header[4][0] = "Relation"
data_header[4][1] = "data";
data_header[4][2] = "7%";
data_header[4][3] = "relation";

data_header[5] = new Array;
data_header[5][0] = "Service No."
data_header[5][1] = "data";
data_header[5][2] = "7%";
data_header[5][3] = "serNo";

data_header[6] = new Array;
data_header[6][0] = "Rank"
data_header[6][1] = "data";
data_header[6][2] = "8%";
data_header[6][3] = "Rank";

data_header[7] = new Array;
data_header[7][0] = "Name"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "sPerName";

data_header[8] = new Array;
data_header[8][0] = "Age"
data_header[8][1] = "hide";
data_header[8][2] = "10%";
data_header[8][3] = "age";

data_header[9] = new Array;
data_header[9][0] = "Sex"
data_header[9][1] = "hide";
data_header[9][2] = "5%";
data_header[9][3] = "sex";

/*data_header[11] = new Array;
data_header[11][0] = "Service Type"
data_header[11][1] = "data";
data_header[11][2] = "8%";
data_header[11][3] = "serviceType";
*/
data_header[10] = new Array;
data_header[10][0] = "MO"
data_header[10][1] = "data";
data_header[10][2] = "8%";
data_header[10][3] = "doct";

data_arr = new Array();



	<%
	int  counter=0;
	 if (pendingLoanoutList != null && pendingLoanoutList.size() > 0) {
 		for(PatientPrescriptionHeader patientPresc : pendingLoanoutList)
 		{

 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=patientPresc.getId()%>"

		<%
		if(patientPresc.getPrescriptionNo()!= null){

		%>
	   data_arr[<%= counter%>][1] = "<%=patientPresc.getPrescriptionNo()%>"
	  <%}else{%>
	  data_arr[<%= counter%>][1] =" "
    	<%}%>

    data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(patientPresc.getPrescriptionDate())%>"
	data_arr[<%= counter%>][3] = "<%=patientPresc.getPrescriptionTime()%>"
	//data_arr[<%= counter%>][4] = "<%=patientPresc.getHin().getHinNo()%>"
		<%
		if(patientPresc.getHin() != null){
			String FirPName="";String midPName=""; String lastPName="";
			if(patientPresc.getHin().getPFirstName() !=null){
				FirPName = patientPresc.getHin().getPFirstName();
				}

				if(patientPresc.getHin().getPLastName()!=null){
					lastPName = patientPresc.getHin().getPLastName();
				}

				String Pname = FirPName+" "+lastPName;

	%>
		data_arr[<%= counter%>][4] = "<%=Pname%>"
		<%}else{%>
		data_arr[<%= counter%>][4] = "-"
		<%}%>
		data_arr[<%= counter%>][5] = "<%=patientPresc.getHin().getRelation().getRelationName()%>"
		data_arr[<%= counter%>][6] = "<%=patientPresc.getHin().getServiceNo()%> "
		data_arr[<%= counter%>][7] = "<%=patientPresc.getHin().getRank().getRankName()%>"
	<%
	if(patientPresc.getHin() != null){
		String FirName="";String midName=""; String lastName="";
		if(patientPresc.getHin().getSFirstName() !=null){
			FirName = patientPresc.getHin().getSFirstName();
			}
			if(patientPresc.getHin().getSLastName()!=null){
				lastName = patientPresc.getHin().getSLastName();
			}
			String name = FirName+" "+midName+" "+lastName;


	%>
	data_arr[<%= counter%>][8] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][8] = "-"
<%}%>
	data_arr[<%= counter%>][9] = "<%=patientPresc.getHin().getAge()%>"
	data_arr[<%= counter%>][10] = "<%=patientPresc.getHin().getSex().getAdministrativeSexName()%>"
	//data_arr[<%= counter%>][11] = "<%=patientPresc.getHin().getServiceType().getServiceTypeName()%>"
	//data_arr[<%= counter%>][12] = "<%=patientPresc.getHin().getServiceType().getServiceTypeName()%>"
	<%
	if(patientPresc.getVisit().getDoctor() != null){
		String DFirName=""; String DlastName="";
		if(patientPresc.getVisit().getDoctor().getFirstName() !=null){
			DFirName = patientPresc.getVisit().getDoctor().getFirstName();
			}
			if(patientPresc.getHin().getSLastName()!=null){
				DlastName = patientPresc.getVisit().getDoctor().getLastName();
			}
			String MO = patientPresc.getVisit().getDoctor().getRank().getRankName()+" "+DFirName+" "+DlastName;

	%>
	data_arr[<%= counter%>][11] = "<%=MO%>"
	<%}else{%>
	data_arr[<%= counter%>][11] =" "
	<%}%>
	<%
	counter++;
	}
}
%>

formName = "pendingPrescription1"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);

	</script>

<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">



</script>
