<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
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
		
	
		var strValue = document.getElementById("fromDateId").value;
        
        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }      
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = document.getElementById("toDateId").value;
		 
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
	String header = " (OPD Prescription)";
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
	if(detailsMap.get("alreadyIssuedList")!= null){
		prescriptionList =(List<PatientPrescriptionHeader>) detailsMap.get("alreadyIssuedList");
	}
	
	
	if(detailsMap.get("departmentList")!= null){
		departmentList =(List<MasDepartment>) detailsMap.get("departmentList");
	}
	List<MasEmployee> employeeList=new ArrayList<MasEmployee>();
	if(detailsMap.get("employeeList")!=null)
	{
		employeeList=(List<MasEmployee>)detailsMap.get("employeeList");
	}
	List<StoreOpPatientIssueM> storeOpPatientIssueMList=new ArrayList<StoreOpPatientIssueM>();
	if(detailsMap.get("storeOpPatientIssueMList")!=null)
	{
		storeOpPatientIssueMList=(List<StoreOpPatientIssueM>)detailsMap.get("storeOpPatientIssueMList");
	}
	List<Object[]> divisionList=new ArrayList<Object[]>();
	if(detailsMap.get("divisionList")!=null)
	{
		divisionList=(List<Object[]>)detailsMap.get("divisionList");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	boolean facFlag = false;
	if(request.getParameter("facStatus")!=null && request.getParameter("facStatus").equals("y")){
		facFlag = true;
		header = " (FAC Prescription)";
	}
	if (map.get("message") != null) {
	 	message = (String) map.get("message");
	  }
	if(!message.equalsIgnoreCase("")){
	%>
<%} %>
<form name="searchPrescription" action="" method="post">
<div class="clear"></div>
<div class="titleBg">
<h2>PENDING PRESCRIPTIONS <%=header %></h2>
</div>
<div class="Block">
<div class="clear"></div>
<label> Employee No</label> 
<input type="text" name="tempemployeeNo" id="tempemployeeNo"  onkeypress="return searchKeyPress(event);" />
<input type="hidden" name="employeeNo" id="employeeNo" value=""   />
<%-- <%if(facFlag==true){ %>
<label>Division</label>
<select name="divisionId" >
<option value="0">Select</option>
<%for(Object[] ob:divisionList){ %>
<option value="<%=ob[0] %>"><%=ob[1] %></option>
<%} %>
</select>
<input type="hidden" name="facStatus" value="y" />
<%}else{ %>
<label> From Date<span>*</span></label> 
<input	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=FROM_DATE%>,event)" />
<label> To Date<span>*</span></label> 
<input type="text" class="calDate"	id="toDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"	readonly="readonly" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onClick="setdate('<%=currentDate %>',document.searchPrescription.<%=TO_DATE%>,event)" />
<div class="clear"></div>
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
<label>Doctor</label>
<select name="<%=MEDICAL_OFFICER%>" >
<option value="0">Select</option>
<%
   
	for(MasEmployee employee : employeeList)
	{    String mname="";
	     
	     if(employee.getMiddleName()!=null)
	      mname=employee.getMiddleName(); 	 
		String name=employee.getFirstName()+" "+mname+" "+employee.getLastName();
		%>
		<option value="<%=employee.getId() %>"><%=name %></option>
	<%}}
%>
</select> --%>

</div>
<div class="clear paddingTop15"></div>
<%-- <%if(facFlag){ %>
<input type="button" name="search" id="addbutton"	onclick="submitForm('searchPrescription','/hms/hms/opd?method=showPendingPrescriptionJsp');"	value="Search" class="button" accesskey="a" />
<input type="button" name="search" id="facbutton"	onclick="window.location.href='/hms/hms/opd?method=searchPrescription'"	value="OPD" class="button" accesskey="a" />
<%}else{ %>
<input type="button" name="search" id="addbutton"	onclick="submitForm('searchPrescription','/hms/hms/opd?method=searchPrescription');"	value="Search" class="button" accesskey="a" />
<input type="button" name="search" id="facbutton"	onclick="submitForm('searchPrescription','/hms/hms/opd?method=showPendingPrescriptionJsp&facStatus=y');"	value="FAC" class="button" accesskey="a" />
<%} %>
<input type="button" name="add"	id="addbutton" value="Print Previous Prescription" class="buttonBig2"	onClick="submitForm('searchPrescription','stores?method=printPatientIssue');" accesskey="g" />
<input type="button" name="search" id="addbutton"	onclick="submitForm('searchPrescription','/hms/hms/stores?method=showDirectPriscriptionJsp');"	value="DIRECT PRESCRIPTION" class="buttonBig" accesskey="a" /> --%>
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="issuedPrescription" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "prescriptionId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serNo"],[6,"sPerName"],[7,"relation"],[8,"patName"], [9,"age"], [10,"sex"],[11,"doct"],[12,"division"],[13,"nipStatus"]];
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
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "<%=PRESCRIPTION_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=PRESCRIPTION_DATE%>";

data_header[2] = new Array;
data_header[2][0] = "Time"
data_header[2][1] = "hide";
data_header[2][2] = "7%";
data_header[2][3] = "<%=PRESCRIPTION_TIME%>";

data_header[3] = new Array;
data_header[3][0] = "HIN"
data_header[3][1] = "hide";
data_header[3][2] = "8%";
data_header[3][3] = "hin";

data_header[4] = new Array;
data_header[4][0] = "Employee No."
data_header[4][1] = "data";
data_header[4][2] = "7%";
data_header[4][3] = "serNo";

data_header[5] = new Array;
data_header[5][0] = "Patient Name"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "patName";


data_header[6] = new Array;
data_header[6][0] = "Relation"
data_header[6][1] = "data";
data_header[6][2] = "7%";
data_header[6][3] = "relation";


data_header[7] = new Array;
data_header[7][0] = "Rank"
data_header[7][1] = "hide";
data_header[7][2] = "8%";
data_header[7][3] = "Rank";

data_header[8] = new Array;
data_header[8][0] = "Employee Name"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "sPerName";

data_header[9] = new Array;
data_header[9][0] = "Age"
data_header[9][1] = "hide";
data_header[9][2] = "10%";
data_header[9][3] = "age";

data_header[10] = new Array;
data_header[10][0] = "Sex"
data_header[10][1] = "hide";
data_header[10][2] = "5%";
data_header[10][3] = "sex";

data_header[11] = new Array;
data_header[11][0] = "Doctor"
data_header[11][1] = "hide";
data_header[11][2] = "8%";
data_header[11][3] = "doct";


data_header[12] = new Array; 
data_header[12][0] = "Division"
data_header[12][1] = "hide";
data_header[12][2] = "8%";
data_header[12][3] = "division";


data_header[13] = new Array;
data_header[13][0] = "Issued Date (Issued Time)"
data_header[13][1] = "data";
data_header[13][2] = "8%";
data_header[13][3] = "nipStatus";

data_arr = new Array();
<%
	int  counter=0;
    String nipStatus = "";
    System.out.println("prescriptionList"+prescriptionList.size());
    String issueFrom = "i";
	 if (prescriptionList != null && prescriptionList.size() > 0) {
 		for(PatientPrescriptionHeader patientPresc : prescriptionList)
 		{
 			issueFrom = "i";
 			/* Set<PatientPrescriptionDetails> ppdSet = new HashSet<PatientPrescriptionDetails>();
 			ppdSet.clear();
 			ppdSet = patientPresc.getPatientPrescriptionDetails(); 
 			for(PatientPrescriptionDetails ppd : ppdSet)
 			{
 				System.out.println("ppd.getItem().getIssueFrom()"+ppd.getItem().getIssueFrom()+patientPresc.getId());
 				if(ppd.getItem().getIssueFrom()==null)
 				{
 					issueFrom = "d";
 				}
 				else if(ppd.getItem().getIssueFrom()!=null && ppd.getItem().getIssueFrom().equalsIgnoreCase("d"))
 				{
 					issueFrom = "d";
 				}
 			} */
 			nipStatus = "";
 		 if(patientPresc.getNipStatus()!=null && patientPresc.getNipStatus().equalsIgnoreCase("Y"))
 		 {

 			 
 	 		 
 			 %>
 				data_arr[<%= counter%>] = new Array();
 				data_arr[<%= counter%>][0] = "<%=patientPresc.getHin().getId()%>"
 					<%
 					if(patientPresc.getPrescriptionNo()!= null){
 					%>	
 				   data_arr[<%= counter%>][1] = "<%=patientPresc.getPrescriptionNo()%>"
 				  <%}else{%>
 				  data_arr[<%= counter%>][1] =" "
 			    	<%}%>	
 					
 			    data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(patientPresc.getPrescriptionDate())%>"
 				data_arr[<%= counter%>][3] = "<%=patientPresc.getPrescriptionTime()%>"
 				data_arr[<%= counter%>][4] = "<%=patientPresc.getHin().getHinNo()%>"
 					<%
 					if(patientPresc.getHin() != null){
 						String FirPName="";String midPName=""; String lastPName="";
 						if(patientPresc.getHin().getPFirstName() !=null){
 							FirPName = patientPresc.getHin().getPFirstName();
 							}
 							if(patientPresc.getHin().getPMiddleName()!=null){
 								midPName = patientPresc.getHin().getPMiddleName();
 							}
 							if(patientPresc.getHin().getPLastName()!=null){
 								lastPName = patientPresc.getHin().getPLastName();
 							}
 							String Pname = FirPName+" "+midPName+" "+lastPName;
 				%>
 				data_arr[<%= counter%>][5] = "<%=patientPresc.getHin().getServiceNo()!=null?patientPresc.getHin().getServiceNo():""%> "
 					data_arr[<%= counter%>][6] = "<%=Pname%>"
 					<%}else{%>
 					data_arr[<%= counter%>][6] = "-"
 					<%}%>
 					data_arr[<%= counter%>][7] = "<%=patientPresc.getHin().getRelation().getRelationName()%>"
 						
 					data_arr[<%= counter%>][8] = "<%=patientPresc.getHin().getRank()!=null?patientPresc.getHin().getRank().getRankName():""%>"
 				<%
 				if(patientPresc.getNipStatus() != null){
 					if(patientPresc.getNipStatus().equalsIgnoreCase("A"))
 					{
 						nipStatus = "Approved";
 					}
 					else if(patientPresc.getNipStatus().equalsIgnoreCase("y"))
 					{
 						nipStatus = "Pending";
 					}
 					else
 					{
 						nipStatus = "No NIP";
 					}
 					
 				}
 				else{
 					nipStatus = "No NIP";
 				}
 				if(patientPresc.getHin() != null){
 					String FirName="";String midName=""; String lastName="";
 					if(patientPresc.getHin().getSFirstName() !=null){
 						FirName = patientPresc.getHin().getSFirstName();
 						}
 						if(patientPresc.getHin().getSMiddleName()!=null){
 							midName = patientPresc.getHin().getSMiddleName();
 						}
 						if(patientPresc.getHin().getSLastName()!=null){
 							lastName = patientPresc.getHin().getSLastName();
 						}
 						String name = FirName+" "+midName+" "+lastName;
 				
 				%>
 				data_arr[<%= counter%>][9] = "<%=name%>"
 				<%}else{%>
 				data_arr[<%= counter%>][9] = "-"
 			<%}%>
 				data_arr[<%= counter%>][10] = "<%=patientPresc.getHin().getAge()%>"
 				data_arr[<%= counter%>][11] = "<%=patientPresc.getHin().getSex().getAdministrativeSexName()%>"
 				
 				<%
 				if(patientPresc.getVisit() != null && patientPresc.getVisit().getDoctor() !=null){ %>
 				
 				data_arr[<%= counter%>][12] = "<%=patientPresc.getVisit().getDoctor().getFirstName()+" "+patientPresc.getVisit().getDoctor().getLastName()%>"
 				<%}else{%>
 				data_arr[<%= counter%>][12] =" "
 				<%}%>
 				<%if(facFlag){%>
 					data_arr[<%= counter%>][13] ="<%=patientPresc.getDivision().getDivisionName()%>"
 				<%}%>
 				data_arr[<%= counter%>][14] ="<%=nipStatus%>"
 				<%
 				counter++;
 				
 		 }
 		 else
 		 {
 			 
 		 
 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=patientPresc.getHin().getId()%>"
		<%
		if(patientPresc.getPrescriptionNo()!= null){
		%>	
	   data_arr[<%= counter%>][1] = "<%=patientPresc.getPrescriptionNo()%>"
	  <%}else{%>
	  data_arr[<%= counter%>][1] =" "
    	<%}%>	
		
    data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(patientPresc.getPrescriptionDate())%>"
	data_arr[<%= counter%>][3] = "<%=patientPresc.getPrescriptionTime()%>"
	data_arr[<%= counter%>][4] = "<%=patientPresc.getHin().getHinNo()%>"
		<%
		if(patientPresc.getHin() != null){
			String FirPName="";String midPName=""; String lastPName="";
			if(patientPresc.getHin().getPFirstName() !=null){
				FirPName = patientPresc.getHin().getPFirstName();
				}
				if(patientPresc.getHin().getPMiddleName()!=null){
					midPName = patientPresc.getHin().getPMiddleName();
				}
				if(patientPresc.getHin().getPLastName()!=null){
					lastPName = patientPresc.getHin().getPLastName();
				}
				String Pname = FirPName+" "+midPName+" "+lastPName;
	%>
	data_arr[<%= counter%>][5] = "<%=patientPresc.getHin().getServiceNo()!=null?patientPresc.getHin().getServiceNo():""%> "	
		data_arr[<%= counter%>][6] = "<%=Pname%>"
		<%}else{%>
		data_arr[<%= counter%>][6] = "-"
		<%}%>
		data_arr[<%= counter%>][7] = "<%=patientPresc.getHin().getRelation().getRelationName()%>"
		
		data_arr[<%= counter%>][8] = "<%=patientPresc.getHin().getRank()!=null?patientPresc.getHin().getRank().getRankName():""%>"
	<%
	if(patientPresc.getNipStatus() != null){
			if(patientPresc.getNipStatus().equalsIgnoreCase("A"))
			{
				nipStatus = "Approved";
			}
			else if(patientPresc.getNipStatus().equalsIgnoreCase("y"))
			{
				nipStatus = "Pending";
			}
			else
			{
				nipStatus = "No N.I.P";
			}
			
		}
	else
	{
		nipStatus = "No N.I.P";
	}
	if(patientPresc.getHin() != null){
		String FirName="";String midName=""; String lastName="";
		if(patientPresc.getHin().getSFirstName() !=null){
			FirName = patientPresc.getHin().getSFirstName();
			}
			if(patientPresc.getHin().getSMiddleName()!=null){
				midName = patientPresc.getHin().getSMiddleName();
			}
			if(patientPresc.getHin().getSLastName()!=null){
				lastName = patientPresc.getHin().getSLastName();
			}
			String name = FirName+" "+midName+" "+lastName;
	
	%>
	data_arr[<%= counter%>][9] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][9] = "-"
<%}%>
	data_arr[<%= counter%>][10] = "<%=patientPresc.getHin().getAge()%>"
	data_arr[<%= counter%>][11] = "<%=patientPresc.getHin().getSex().getAdministrativeSexName()%>"
	
	<%
	if(patientPresc.getVisit() != null && patientPresc.getVisit().getDoctor() !=null){ %>
	
	data_arr[<%= counter%>][12] = "<%=patientPresc.getVisit().getDoctor().getFirstName()+" "+patientPresc.getVisit().getDoctor().getLastName()%>"
	<%}else{%>
	data_arr[<%= counter%>][12] =" "
	<%}%>
	<%if(facFlag){%>
		data_arr[<%= counter%>][13] ="<%=patientPresc.getDivision().getDivisionName()%>"
	<%}%>
	<%-- data_arr[<%= counter%>][14] ="<%=nipStatus%>" --%>
	
	data_arr[<%= counter%>][14] ='<%=patientPresc.getIssuedDate()!=null?(HMSUtil.convertDateToStringWithoutTime(patientPresc.getIssuedDate()))+" ("+patientPresc.getIssuedTime()+")":""%>'
	<%
	
	counter++;
	}
}}
%>

formName = "issuedPrescription"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);

function searchKeyPress(e)

{
	myVar = setTimeout(searchKeyPress1(e), 3000);
}
function searchKeyPress1(e) {
	// look for window.event in case event isn't passed in
	e = e || window.event;
	if (e.keyCode == 13) {
		
		var empNo= document.getElementById("tempemployeeNo").value;
		var position = empNo.indexOf("-");
		var length=empNo.length;
		if(position != -1)
			{
				empNo = empNo.substring(4,position);
			}
		else
			{
				empNo = empNo.substring(4,length);
			}
		
		document.getElementById("employeeNo").value=empNo;
		
		submitForm('searchPrescription','/hms/hms/opd?method=showPendingPrescriptionJsp&byAdmin=n');
		
		return false;
	}
	return true;
}

document.getElementById("tempemployeeNo").focus();
</script>
