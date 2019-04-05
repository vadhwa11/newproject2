
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="sampleValidation" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	BloodSampleCollection sampleCollection= new BloodSampleCollection();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	int hinId= 0;
	String deptName="";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("sampleList") != null){
		sampleList=(List)map.get("sampleList");
	}
	if(sampleList != null) {
		sampleCollection = (BloodSampleCollection) sampleList.get(0);
			hinId =sampleCollection.getHin().getId();
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	
    MasDepartment masDepartment=new MasDepartment();
   // masDepartment = (MasDepartment) sampleCollection.getDepartment();
	
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Sample Validation</h6>
<div class="Clear"></div>
<div class="header"><label class="NoWidth">Order Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(sampleCollection.getRequest().getOrderDate())%></label>
<label class="NoWidth">Order Time</label> <label class="value"><%=sampleCollection.getRequest().getOrderTime()%></label>
<label class="NoWidth">Order No.</label> <label class="value"><%=sampleCollection.getRequest().getOrderNo()%></label>
<label class="NoWidth">Order By</label> <label class="value"><%=sampleCollection.getRequest().getDepartment().getDepartmentName()%></label>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Service Type</label> <%
				if(sampleCollection.getHin().getServiceType() != null){
			%> <label class="value"><%= sampleCollection.getHin().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Service No</label>
<%
				if(sampleCollection.getHin().getServiceNo() != null && !(sampleCollection.getHin().getServiceNo().equals(""))){
			%> <label class="value"><%= sampleCollection.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Service
Status</label> <%if(sampleCollection.getHin().getServiceStatus() != null){
			%> <label class="value"><%= sampleCollection.getHin().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>

<div class="Clear"></div>

<label>Relation</label> <%
				if(sampleCollection.getHin().getRelation() != null){
			%> <label class="value"><%= sampleCollection.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Ser. Per.
Name</label> <%
				if(sampleCollection.getHin().getSFirstName() != null  && !(sampleCollection.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(sampleCollection.getHin().getSMiddleName() != null){
						sMiddleName = sampleCollection.getHin().getSMiddleName();
					}
					if(sampleCollection.getHin().getSLastName() != null){
						sLastName = sampleCollection.getHin().getSLastName();
					}
			 %> <label class="valueNoWidth"><%= sampleCollection.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label>Rank</label>
<%
			if(sampleCollection.getHin().getRank() != null){
			%> <label class="value"><%= sampleCollection.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>
<label>Unit</label> <%
				if(sampleCollection.getHin().getUnit() != null){
			%> <label class="value"><%=sampleCollection.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <% }%>

 <label>Trade</label> <%
				if(sampleCollection.getHin().getTrade() != null){
			%> <label class="value"><%=sampleCollection.getHin().getTrade().getTradeName() %></label>
<%}else{ %>
 <label class="value">-</label>
  <% }%>
<div class="Clear"></div>

</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label>HIN No.</label> <label class="value"><%=sampleCollection.getHin().getHinNo() %></label>
<%
					String middleName = "";
					String lastName = "";
					if(sampleCollection.getHin().getPMiddleName() != null){
						middleName = sampleCollection.getHin().getPMiddleName();
					}
					if(sampleCollection.getHin().getPLastName() != null){
						lastName = sampleCollection.getHin().getPLastName();
					}
					
		%> <label>Patient Name</label> <label class="valueNoWidth"><%= sampleCollection.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <label class="value"><%=sampleCollection.getHin().getSex().getAdministrativeSexName() %></label>
<div class="Clear"></div>
<%
		String age = "";
		String currentAge = "";
		age = sampleCollection.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, sampleCollection.getHin().getRegDate());
		%> <label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(sampleCollection.getHin().getMaritalStatus() != null){
					maritalStatus = sampleCollection.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <%
		//	int inpatientId =0;
		
			//Set<Inpatient> set = new HashSet<Inpatient>();
			//set = sampleCollection.getHin().getInpatients();
		//	for(Inpatient inpatient : set){
				//if(inpatient.getAdStatus().equals("A")){
			////		inpatientId = inpatient.getId();
			//	}
%> 
<label>AD No</label> 
<%if(sampleCollection.getInpatient() != null){ %>
<label	class="valueNoWidth"><%=sampleCollection.getInpatient().getAdNo()%></label>
<input type="hidden" name="<%=INPATIENT_ID %>"value="<%= sampleCollection.getInpatient().getId()%>" />
 <%}else{ %>
 <label	class="valueNoWidth">-</label> <% }%>
 <div class="Clear"></div>
  <label>Blood Group</label>
   <%if(sampleCollection.getHin().getBloodGroup() != null){ %>
<label class="value"><%=sampleCollection.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> 
<label class="value">-</label> <% }%>
<div class="Clear"></div>
</div>
<div>
	
	 <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=sampleCollection.getHin().getId() %>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_ID %>" value="<%=sampleCollection.getId()%>" />
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!-- Block Three Starts -->
<div class="blockTitle">Sample Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<div class="Clear"></div>

<label class="noWidth">SampleValidation Date</label> <label
	class="valueNoWidth"> <%= date%> </label> <label class="noWidth">SampleValidation
Time</label> <label class="valueNoWidth"> <%= time%> </label> <label
	class="noWidth"><span>*</span>Validated By</label> <select
	id="collectedBy" name="<%=EMPLOYEE_ID %>"
	validate="Validated By,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				String empName= "" ;
				         				empName = masEmployee.getFirstName();
				         				if(masEmployee.getMiddleName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getMiddleName());
				         				if(masEmployee.getLastName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getLastName());
				         %>
	<option value="<%=masEmployee.getId() %>"><%=empName%></option>

	<%		} }%>
</select> <label class="noWidth">Accepted</label>
 <input type="radio" name="<%=SELECTED_RADIO  %>" checked="checked" class="radio"	tabindex=1 value="y"/>
	 <label class="noWidth">Rejected</label>
	 <input	type="radio" name="<%=SELECTED_RADIO  %>" class="radio" tabindex=1 value="n"/>
<div class="Clear"></div>


<label class="common">Remarks</label> <input id="clinicalNote"
	type="text" name="<%= REMARKS%>" value=""
	validate="Clinical Notes,string,no" MAXLENGTH="100"
	style="width: 600px;" tabindex=1 />

<div class="Clear"></div>
</div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <!-- Block Three Ends -->
<!-- Table Ends -->
<div class="Height10"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('sampleValidation','bloodBank?method=submitBloodSampleValidation');"
	align="right" tabindex=1 /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('sampleValidation');" accesskey="r" tabindex=1 />

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>
</div>

<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
</form>
<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">

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