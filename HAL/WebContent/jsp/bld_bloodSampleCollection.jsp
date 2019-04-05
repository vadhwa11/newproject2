
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="sampleCollection" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodRequestEntryHeader> requesthdList = new ArrayList<BloodRequestEntryHeader>();
	
	BloodRequestEntryHeader bloodRequestHeader= new BloodRequestEntryHeader();
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
	if(map.get("requesthdList") != null){
		requesthdList=(List)map.get("requesthdList");
	}
	System.out.println("requesthdList   "+requesthdList.size());
	if(requesthdList != null) {
 			bloodRequestHeader = (BloodRequestEntryHeader) requesthdList.get(0);
			hinId =bloodRequestHeader.getHin().getId();
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
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1]; 
    MasDepartment masDepartment=new MasDepartment();
    masDepartment = (MasDepartment) bloodRequestHeader.getDepartment();
	
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Sample Receipt</h6>
<div class="Clear"></div>
<div class="header"><label class="NoWidth">Order Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(bloodRequestHeader.getOrderDate())%></label>
<label class="NoWidth">Order Time</label> <label class="value"><%=bloodRequestHeader.getOrderTime()%></label>
<label class="NoWidth">Order No.</label> <label class="value"><%=bloodRequestHeader.getOrderNo()%></label>
<label class="NoWidth">Order By</label> <label class="value"><%=bloodRequestHeader.getDepartment().getDepartmentName()%></label>
</div>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Service Type</label> <%
				if(bloodRequestHeader.getHin().getServiceType() != null){
			%> <label class="value"><%= bloodRequestHeader.getHin().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Service No</label>
<%
				if(bloodRequestHeader.getHin().getServiceNo() != null && !(bloodRequestHeader.getHin().getServiceNo().equals(""))){
			%> <label class="value"><%= bloodRequestHeader.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Service
Status</label> <%if(bloodRequestHeader.getHin().getServiceStatus() != null){
			%> <label class="value"><%= bloodRequestHeader.getHin().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>

<div class="Clear"></div>

<label>Relation</label> <%
				if(bloodRequestHeader.getHin().getRelation() != null){
			%> <label class="value"><%= bloodRequestHeader.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Ser. Per.
Name</label> <%
				if(bloodRequestHeader.getHin().getSFirstName() != null  && !(bloodRequestHeader.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(bloodRequestHeader.getHin().getSMiddleName() != null){
						sMiddleName = bloodRequestHeader.getHin().getSMiddleName();
					}
					if(bloodRequestHeader.getHin().getSLastName() != null){
						sLastName = bloodRequestHeader.getHin().getSLastName();
					}
			 %> <label class="valueNoWidth"><%= bloodRequestHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label>Rank</label>
<%
			if(bloodRequestHeader.getHin().getRank() != null){
			%> <label class="value"><%= bloodRequestHeader.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>
<label>Unit</label> <%
				if(bloodRequestHeader.getHin().getUnit() != null){
			%> <label class="value"><%=bloodRequestHeader.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Trade</label> <%
				if(bloodRequestHeader.getHin().getTrade() != null){
			%> <label class="value"><%=bloodRequestHeader.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">-</label> <% }%>
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
<label>HIN No.</label> <label class="value"><%=bloodRequestHeader.getHin().getHinNo() %></label>
<%
					String middleName = "";
					String lastName = "";
					if(bloodRequestHeader.getHin().getPMiddleName() != null){
						middleName = bloodRequestHeader.getHin().getPMiddleName();
					}
					if(bloodRequestHeader.getHin().getPLastName() != null){
						lastName = bloodRequestHeader.getHin().getPLastName();
					}
					
		%> <label>Patient Name</label> <label class="valueNoWidth"><%= bloodRequestHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <label class="value"><%=bloodRequestHeader.getHin().getSex().getAdministrativeSexName() %></label>

<div class="Clear"></div>
<%
		String age = "";
		String currentAge = "";
		age = bloodRequestHeader.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, bloodRequestHeader.getHin().getRegDate());
		%> <label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(bloodRequestHeader.getHin().getMaritalStatus() != null){
					maritalStatus = bloodRequestHeader.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <label>Blood Group</label> <%if(bloodRequestHeader.getHin() !=null){%>
<%if(bloodRequestHeader.getHin().getBloodGroup()!=null){ %> <label
	class="value"><%=bloodRequestHeader.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}}else { %> <label class="value">-</label> <% }%> <%
			int inpatientId =0;
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = bloodRequestHeader.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				}
			}
%>
<div class="Clear"></div>
<label>A&D No</label> <%if(bloodRequestHeader.getInpatient() !=null){%> <label
	class="value"><%=bloodRequestHeader.getInpatient().getAdNo()%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>

<div>
<%if( bloodRequestHeader.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%= bloodRequestHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=bloodRequestHeader.getHin().getId() %>" /> <input
	type="hidden" name="<%=BLOOD_REQUEST_ID %>"
	value="<%=bloodRequestHeader.getId()%>" /></div>

<!--Block Two Ends-->
<div class="division"></div>
<!-- Block Three Starts -->
<div class="blockTitle">Sample Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<%
		String collectionSeqNo="";
		if(map.get("collectionSeqNo") != null){
			collectionSeqNo = (String)map.get("collectionSeqNo");
		}
%>
<div class="Clear"></div>
<label class="noWidth">Sample Receipt No</label> <input
	id="collectionId" type=hidden name="<%=SAMPLE_COLLECTION_NO %>"
	value="<%=collectionSeqNo %>" title="Order Number" /> <label
	class="valueNoWidth"> <%=collectionSeqNo %> </label> <input
	type="hidden" id="hinId" value="<%= hinId%>" /> <label
	class="noWidth">Sample Receipt Date</label> <label class="valueNoWidth">
<%= date%> </label> <label class="noWidth">Sample Receipt Time</label> <input
	id="sampleCollectionTime" type="text"
	name="<%= SAMPLE_COLLECTION_TIME%>" value="<%=time1 %>" class="calDate"
	onKeyUp="mask(this.value,this,'2',':');" MAXLENGTH="5" tabindex=1 /> <label
	class="noWidth"><span>*</span> Received By</label> <select
	id="collectedBy" name="<%=EMPLOYEE_ID %>"
	validate="Received By,string,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} }%>
</select>
<div class="Clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends --> <!-- Table Ends -->
<div class="Height10"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('sampleCollection','bloodBank?method=submitBloodSampleCollection');"
	align="right" tabindex=1 /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('sampleCollection');" accesskey="r" tabindex=1 />

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
</div>
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