
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="bloodIssue" method="post" action="">
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	Set<BloodMasComponent> componentList = new HashSet<BloodMasComponent>();
	
	BloodSampleScreeningHeader sampleScreeningHeader= new BloodSampleScreeningHeader();
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
	if(map.get("screeningList") != null){
		screeningList=(List)map.get("screeningList");
	}
	
	if(screeningList != null) {
		sampleScreeningHeader = (BloodSampleScreeningHeader) screeningList.get(0);
			hinId =sampleScreeningHeader.getHin().getId();
	}
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
	if(map.get("componentList") != null){
		componentList=(Set<BloodMasComponent>)map.get("componentList");
		System.out.println("componentList"+componentList.size());
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
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
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
<h6>Blood Issue Entry</h6>
<div class="Clear"></div>
<div class="header"><label class="NoWidth">Order Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(sampleScreeningHeader.getSampleCollection().getRequest().getOrderDate())%></label>
<label class="NoWidth">Order Time</label> <label class="value"><%=sampleScreeningHeader.getSampleCollection().getRequest().getOrderTime()%></label>
<label class="NoWidth">Order No.</label> <label class="value"><%=sampleScreeningHeader.getSampleCollection().getRequest().getOrderNo()%></label>
<label class="NoWidth">Order By</label> <label class="value"><%=sampleScreeningHeader.getSampleCollection().getRequest().getDepartment().getDepartmentName()%></label>
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
				if(sampleScreeningHeader.getHin().getServiceType() != null){
			%> <label class="value"><%= sampleScreeningHeader.getHin().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Service No</label>
<%
				if(sampleScreeningHeader.getHin().getServiceNo() != null && !(sampleScreeningHeader.getHin().getServiceNo().equals(""))){
			%> <label class="value"><%= sampleScreeningHeader.getHin().getServiceNo()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Service
Status</label> <%if(sampleScreeningHeader.getHin().getServiceStatus() != null){
			%> <label class="value"><%= sampleScreeningHeader.getHin().getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>

<div class="Clear"></div>

<label>Relation</label> <%
				if(sampleScreeningHeader.getHin().getRelation() != null){
			%> <label class="value"><%= sampleScreeningHeader.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Ser. Per.
Name</label> <%
				if(sampleScreeningHeader.getHin().getSFirstName() != null  && !(sampleScreeningHeader.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(sampleScreeningHeader.getHin().getSMiddleName() != null){
						sMiddleName = sampleScreeningHeader.getHin().getSMiddleName();
					}
					if(sampleScreeningHeader.getHin().getSLastName() != null){
						sLastName = sampleScreeningHeader.getHin().getSLastName();
					}
			 %> <label class="valueNoWidth"><%= sampleScreeningHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <% }%> <label>Rank</label>
<%
			if(sampleScreeningHeader.getHin().getRank() != null){
			%> <label class="value"><%= sampleScreeningHeader.getHin().getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>
<label>Unit</label> <%
				if(sampleScreeningHeader.getHin().getUnit() != null){
			%> <label class="value"><%=sampleScreeningHeader.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Trade</label> <%
				if(sampleScreeningHeader.getHin().getTrade() != null){
			%> <label class="value"><%=sampleScreeningHeader.getHin().getTrade().getTradeName() %></label>
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
<label>HIN No.</label> <label class="value"><%=sampleScreeningHeader.getHin().getHinNo() %></label>
<%
					String middleName = "";
					String lastName = "";
					if(sampleScreeningHeader.getHin().getPMiddleName() != null){
						middleName = sampleScreeningHeader.getHin().getPMiddleName();
					}
					if(sampleScreeningHeader.getHin().getPLastName() != null){
						lastName = sampleScreeningHeader.getHin().getPLastName();
					}
					
		%> <label>Patient Name</label> <label class="valueNoWidth"><%= sampleScreeningHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <label class="valueNoWidth"><%=sampleScreeningHeader.getHin().getSex().getAdministrativeSexName() %></label>
<%
		String age = "";
		String currentAge = "";
		age = sampleScreeningHeader.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, sampleScreeningHeader.getHin().getRegDate());
		%>

<div class="Clear"></div>

<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(sampleScreeningHeader.getHin().getMaritalStatus() != null){
					maritalStatus = sampleScreeningHeader.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <%if( sampleScreeningHeader.getInpatient() != null){%>
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%= sampleScreeningHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=sampleScreeningHeader.getHin().getId() %>" /> <input
	type="hidden" name="<%=SAMPLE_SCREENING_HD_ID %>"
	value="<%=sampleScreeningHeader.getId()%>" /></div>
<div class="Clear"></div>
<div class="blockFrame">
<%
		String monthlySeqNo="";
		if(map.get("monthlySeqNo") != null){
			monthlySeqNo = (String)map.get("monthlySeqNo");
		}
%>

<div class="Clear"></div>
<label>Monthly Issue No.</label> <input id="fatherId" type=hidden
	name="<%=MONTHLY_ISSUE_NO %>" value="<%=monthlySeqNo %>"
	title="Monthly Issue No." /> <label class="value"> <%=monthlySeqNo %>
</label> <label><span>*</span>Issue Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=ISSUE_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30"
	validate="Issue Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.bloodIssue.<%=ISSUE_DATE%>,event)"
	tabindex="1" /> <label><span>*</span>Issue Time</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=ISSUE_TIME %>"
	value="<%=time %>" readonly="readonly" MAXLENGTH="10"
	onblur="checkTime(bloodIssue,<%=ISSUE_TIME %>);" tabindex="1" />

<div class="Clear"></div>


<label>Blood Group</label> <%
	 String bloodGroup="";
				if(sampleScreeningHeader.getHin().getBloodGroup() != null){
					bloodGroup = sampleScreeningHeader.getHin().getBloodGroup().getBloodGroupName();
				
				%> 
	<input type="hidden" id="bloodGroupId"
	name="<%=BLOOD_GROUP_ID %>"
	value="<%=sampleScreeningHeader.getHin().getBloodGroup().getId() %>" />
<label class="value"><%=bloodGroup%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <label><span>*</span>Issued By</label> <select
	id="employeeId1" name=<%=ISSUED_BY %> validate="Issued By,string,yes"
	tabindex="1">
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
	<%		} } %>
</select> <label><span>*</span> Received By </label> <select id="employeeId2"
	name=<%=RECEIVED_BY %> validate="Received By,string,yes" tabindex="1">
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
	<%		} } %>
</select>

<div class="Clear"></div>

<label><span>*</span>Cross Matched By </label> <select id="employeeId3"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,yes"
	tabindex="1">
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
	<%		} } %>
</select>

<div class="Clear"></div>

<label class="noWidth">Method of cross matching</label> <input
	type="checkbox" class="radio" name="<%=SAL_RT %>" value="" tabindex="1" />
<label class="value">Sal-RT</label> <input type="checkbox" class="radio"
	name="<%=SAL %>" value="" tabindex="1" /> <label class="value">Sal
37&deg;C</label> <input type="checkbox" class="radio" name="<%=ALB %>" value=""
	tabindex="1" /> <label class="value">ALB 37&deg;C</label> <input
	type="checkbox" class="radio" name="<%=AHG %>" value="" tabindex="1" />
<label class="value">AHG 37&deg;C</label></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Component Name</th>
			<th scope="col">Blood Bag No.</th>
			<th scope="col">Quantity (ml)</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<%

	int detailCounter=8; 
	int temp=0;
	int inc = 0;    	
	if(pageNo!=1){
		temp=detailCounter*(pageNo-1);
	} 
	
 %>

		<tr>
			<%if(componentList.size()>=inc){
	  for(BloodMasComponent bloodMasComponent :componentList){
	 inc++;
	 
  %>
			<td width="5%"><input type="text" id="srNo" size="2"
				value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex="1" /></td>

			<td>
			<input type="text" id="componentName<%=inc%>" name="<%=BLOOD_COMPONENT_NAME%>"
				value="<%=bloodMasComponent.getComponentName() %>" /> 
			<input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>" id="bloodComponentId<%=inc %>"
				value="<%=bloodMasComponent.getId() %>" />
				</td>


			<td><input id="bloodBagNo<%=inc%>" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45" readonly="readonly"
				tabindex="1" /> <input type="hidden" value=""
				name="<%=STOCK_DETAIL_ID%>" id="stockDetailId<%=inc %>" /></td>

			<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>"
				value="" validate="Qty,int,no" MAXLENGTH="3" readonly="readonly"
				tabindex="1" /></td>
			<td><input type="button" class="cmnButton" value="Issue"
				onclick="get_bag_no(<%=inc %>,<%=bloodMasComponent.getId()%>);"
				align="right" /></td>
		</tr>
		<%}}%>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	</tbody>
</table>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /></div>

<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="submitForm('bloodIssue','bloodBank?method=submitBloodIssue');"
	align="right" tabindex="1" /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodIssue',<%=inc %>);" accesskey="r"
	tabindex="1" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
</form>

<script language="javascript">	          
function get_bag_no(rowNo,bloodId)
{
var url='/hms/hms/bloodBank?method=showPopUpBloodIssueJsp&bloodComponentId='+bloodId+'&rowNo='+rowNo ;
 popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'_blank','name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0",'status=1');
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}
</script>