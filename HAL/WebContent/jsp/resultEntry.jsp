
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.net.URL"%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script type="text/javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</script>
<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}
	if(map.get("pageNo") != null)
	{
	pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("message") != null){
	String message = (String)map.get("message");
	out.println(message);
	}
	if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	if(map.get("investigationList") != null){
	investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
	detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	try{
	if(map.get("patientList") != null){
	patientList = (ArrayList)map.get("patientList");
	} 
	}
	catch(Exception e){
	e.printStackTrace();
	}
	
	
	try{
	if(map.get("sampleCollectionList") != null){
	sampleCollectionList=(List)map.get("sampleCollectionList");
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try{
		if(map.get("fixedValList") != null){
			fixedValList=(List)map.get("fixedValList");
		}
		}catch(Exception e){
		e.printStackTrace();
		}
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		try{
			if(map.get("subList") != null){
				subList=(List)map.get("subList");
			}
			}catch(Exception e){
			e.printStackTrace();
			}
	
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	Patient patient = new Patient();
	MasRank masRank = new MasRank();
	String admissionNumber = "";
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	if(sampleCollectionList != null && sampleCollectionList.size()>0)
	{
	dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
	patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
	inpatientSet=patient.getInpatients();
	masRank = (MasRank) patient.getRank();
	
	}
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	%>
<script>
	function inputResultValue(){
			for(var i = 0; i < document.getElementsByName('result').length; i++){
				if(document.getElementsByName('result')[i].value != "" && document.getElementsByName('result')[i].value != 0)
	              {
	       			return true;
				  }		
	  		}
	  		alert("Please Enter The Result.")
			return false;
		}
	</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="sampleCollection" method="post" action="">
<h6>Result Entry</h6>
<%
	String subDept = "";
	String dept="";
	int SubChargeId=0;
	int mainChargeId=0;
	
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation()!= null){
	subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
	dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
	
	SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
	mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
	%> <%
	}
	}%> <label class="common">Department</label> <label
	name="<%=MAIN_CHARGECODE_NAME %>" class="valueNoWidth"><%=deptName%>
</label> <input name="<%=DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID%>"
	type="hidden" value="<%=deptId %>" /> <label class="common">Sub
Department</label> <label name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%>
</label> <input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="Clear"></div>
<div class="Height10"></div>
<div class="header">
<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %>
<label class="NoWidth">Order No.</label> <label class="value"
	style="width: 100px;"><%=dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value" style="width: 100px;">-</label> <%} %> <label
	class="medium" style="padding-left: 0px;">Order By</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} 
	System.out.println("hi"+dgDetails.getSampleCollectionHeader().getId());
	%>
</div>
<div class="Clear"></div>
<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%
	if(patient.getServiceType() != null){
	%> <label class="valuemedium"><%= patient.getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Service No</label> <%
	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
	%> <label class="valuemedium"><%= patient.getServiceNo()%></label> <%}else{ %>
<label class="valuemedium">-</label> <%}%> <label class="medium">Service
Status</label> <%if(patient.getServiceStatus() != null){
	%> <label class="valuemedium"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Relation</label> <%
	if(patient.getRelation() != null){
	%> <label class="valuemedium"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <% }%>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <%
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
	
	String sMiddleName = "";
	String sLastName = "";
	if(patient.getSMiddleName() != null){
	sMiddleName = patient.getSMiddleName();
	}
	if(patient.getSLastName() != null){
	sLastName = patient.getSLastName();
	}
	%> <label class="valueNoWidth"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label
	class="medium">Rank</label> <%
	if(patient.getRank() != null){
	%> <label class="valueNoWidth"><%= patient.getRank().getRankName()%></label>
<%} else{ %> <label class="valueNoWidth">-</label> <% }%> <label
	class="medium">Unit</label> <%
	if(patient.getUnit() != null){
	%> <label class="valuemedium"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%> <label
	class="medium">Trade</label> <%
	if(patient.getTrade() != null){
	%> <label class="valuemedium"><%= patient.getTrade().getTradeName()%></label>
<%} else{ %> <label class="valuemedium">-</label> <% }%>

<div class="Clear"></div>

</div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="Clear"></div>
<div style="width: 0px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('visit-details-box1',expand_bca1);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca1
	alt=Expand src="/hms/jsp/images/plus1.gif" ; align=left /> <font
	class="boxtitle">Patient Details </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div class="Clear"></div>
<div class=box-content id=visit-details-box1 style="display: none;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 30px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;"><label class="NoWidth">HIN
No.</label> <label class="value"><%=patient.getHinNo() %></label> <%
	String middleName = "";
	String lastName = "";
	if(patient.getPMiddleName() != null){
	middleName = patient.getPMiddleName();
	}
	if(patient.getPLastName() != null){
	lastName = patient.getPLastName();
	}
	
	%> <label class="NoWidth">Patient Name</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<label class="noWidth">Sex</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<%
	String age = "";
	String currentAge = "";
	age = patient.getAge();
	currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
	%> <label class="NoWidth">Age</label> <label class="value"><%=currentAge%></label>
<div class="Clear"></div>
<div>
<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}else{ %> <input type="hidden" name="<%=INPATIENT_ID %>" value="" /> <%} %>
<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=patient.getHinNo() %>" /></div>
</div>
</div>
</div>
</div>

<!--Block Two Ends-->
<div class="Clear"></div>
<!-- Block Three Starts -->
<div class="blockTitle">Result Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Result Date</label> <label
	class="valueNoWidth"><%=date%></label> <label class="noWidth">Result
Time</label> <label class="valueNoWidth"><%=time%></label> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />
<%
	String resultSeqNo="";
	if(map.get("resultSeqNo") != null){
	resultSeqNo = (String)map.get("resultSeqNo");
	}
	%> <input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
	title="Result No." /> <label><span>*</span>Result Prepared By</label>
<select name="<%= RESULT_ENTERED_BY  %>"
	validate="Result Entered By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			Users user = (Users)session.getAttribute("users");
			Integer userId =user.getEmployee().getId();
				for (MasEmployee masEmployeecode : employeeList) {
					if(masEmployeecode.getEmpCategory() != null){
						if((masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical)) || 

(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) ){
							if (userId .equals(masEmployeecode.getId())) {
			%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}}}	%>
</select>
<div class="Clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %> <label class="noWidth">Sample
Validated Date</label> <%}else{ %> <label class="noWidth">Radio Collection
Date</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate() )%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated Time</label> <%}else{ %> <label
	class="noWidth">Radio Collection Time</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated By</label> <%}else{ %> <label
	class="noWidth">Radio Collected By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() 

%>" />
<label class="valueNowidth"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+ 

dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="valueNowidth">
-</label> <%} %>
<div class="Clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="Clear"></div>
<jsp:include page="viewMultipleRecordTable.jsp" flush="true" /> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('sampleCollection','investigation?method=submitResultEntry');"
	align="right" /> <input type="reset" name="Reset" value="Reset"
	class="button" onclick="resetClicked('sampleCollection');"
	accesskey="r" /></div>
<!--Bottom labels starts--></form>
<!--main content placeholder ends here--></div>