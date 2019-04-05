<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
    System.out.println("Size of patientDetailList list in jsp--");
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
	
	
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 
			
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("departmentList") != null){
			
		departmentList=(List)map.get("departmentList");
			
		}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int entryNo=0;
	if(map.get("entryNo") != null){
		entryNo=(Integer)map.get("entryNo");
		}
	 
	int prescribedDepartmentId=0;
	if(map.get("deptId") != null){
		prescribedDepartmentId=(Integer)map.get("deptId");
		}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Patient patient=(Patient)patientDetailList.get(0);
	
	String patientName="";
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
	}
	String servicePersonName="";
	if(patient.getSFirstName()!= null){
		servicePersonName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSLastName();
	}
	
	// String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	List<MasEmployee> employeeOneList = new ArrayList<MasEmployee>();
	 if(map.get("employeeOneList") != null){
		 employeeOneList = (List<MasEmployee>) map.get("employeeOneList");
		}
	 
	 List<MasEmployee> employeeTwoList = new ArrayList<MasEmployee>();
	 if(map.get("employeeTwoList") != null){
		 employeeTwoList = (List<MasEmployee>) map.get("employeeTwoList");
		}
	
%>






<div id="contentHolder">
<form name="inpatientSpecimen" action="" method="post">

<h6>Surgery Requisition For In-Patient</h6>
<div class="Clear"></div>

<script type="text/javascript">
   var icdArray=new Array();
</script> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>


<label class="medium">Entry No: </label> <%if(map.get("entryNo") != null){ %>
<label class="valuemedium"><%=entryNo %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Date</label> <label
	class="valuemedium"><%=date%></label>


<div class="Clear"></div>

<label class="medium">Patient Name. </label> <%if(patientName!= null){ %>
<label class="valuemedium"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">HIN
No.</label> <%if(patient.getHinNo()!= null){ %> <label class="valuemedium"><%=patient.getHinNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

<div class="Clear"></div>


<label class="medium">Tissue/Organ</label> <input type="text"> <label
	class="small">Specimen dispatched by</label> <select id="b2"
	name="<%=EMPLOYEE_ID2%>" validate="Specimen dispatched by,string,no">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeOneList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ masEmployee.getMiddleName()+ masEmployee.getLastName()%></option>
	<%
						}
					%>
</select>




<div class="Clear"></div>


<label class="medium"> Clinical Notes</label> <input type="text"
	name="<%=CLINICAL_NOTE %>" maxlength="50"> <label
	class="medium"> Time of dispatch</label> <input type="text"
	name="<%=TIME %>">



<div class="Clear"></div>
<label class="medium"> Examination required</label> <input type="text"
	maxlength="50"> <label class="small">Specimen received
by</label> <select id="b2" name="<%=EMPLOYEE_ID3%>"
	validate="Specimen received by,string,no">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeTwoList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ masEmployee.getMiddleName()+ masEmployee.getLastName()%></option>
	<%
						}
					%>
</select>




<div class="Clear"></div>
</div>



<input type="hidden" name="hinId" value="<%=patient.getId() %>" />

<div class="division"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

</form>
</div>


