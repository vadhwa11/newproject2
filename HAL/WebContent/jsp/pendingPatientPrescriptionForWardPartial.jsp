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
	Map<Integer, String> prescriptionListMap = new HashMap<Integer, String>();
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
	List<Object[]> prescriptionList = null;
	if(detailsMap.get("prescriptionList")!= null){
		prescriptionList =(List<Object[]>) detailsMap.get("prescriptionList");
	}
	
	if(detailsMap.get("prescriptionListMap")!= null){
		prescriptionListMap =(HashMap<Integer, String>) detailsMap.get("prescriptionListMap");
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
	if(session.getAttribute("userName") != null){
		
		
	userName = (String)session.getAttribute("userName");
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
<h2>PRESCRIPTIONS FOR WARD</h2>
</div>
<%-- <div class="Block">
<div class="clear"></div>
<label> Employee No</label> 
<input type="text" name="employeeNo" id="employeeNo" value="" />
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
	<%}
%>
</select>

</div> --%>

<div class="clear paddingTop15"></div>
<!-- <input type="button" name="search" id="addbutton"	onclick="if(validateDates()){submitForm('searchPrescription','/hms/hms/opd?method=showPendingPrescriptionForWardJsp');}"	value="Search" class="button" accesskey="a" /> -->
<!-- <input type="button" name="add"	id="addbutton" value="Print Previous Prescription" class="buttonBig2"	onClick="submitForm('searchPrescription','stores?method=printPatientIssue');" accesskey="g" />
<input type="button" name="search" id="addbutton"	onclick="submitForm('searchPrescription','/hms/hms/stores?method=showDirectPriscriptionJsp');"	value="DIRECT PRESCRIPTION" class="buttonBig" accesskey="a" />
<input type="button" name="search" id="facbutton"	onclick="submitForm('searchPrescription','/hms/hms/opd?method=showPendingPrescriptionJsp&facStatus=y');"	value="FAC" class="button" accesskey="a" />-->
 </form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="pendingPrescriptionForWardPartial" method="post" action="">
<%-- <script type="text/javascript">
	formFields = [
		[0, "prescriptionId", "id"],[1,"<%=PRESCRIPTION_NO%>"]];
		statusTd = 13;
	</script></form> --%>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>


<script type="text/javascript" language="javascript"><!--

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Header Id"
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "Header Id";

data_header[1] = new Array;
data_header[1][0] = "Ward"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "Ward";





data_arr = new Array();
<%
	int  counter=0;
	 if (prescriptionListMap != null && prescriptionListMap.size() > 0) {
		 Set prescriptionKey = prescriptionListMap.keySet();
 		for(Object key : prescriptionKey)
 		{
 		 
 %>
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=key%>"
	data_arr[<%= counter%>][2] = "<%=prescriptionListMap.get(key)%>"
		
	
	<%
	counter++;
	}
}
%>

formName = "pendingPrescriptionForWardPartial"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}
makeTable(start,end);
--></script>
