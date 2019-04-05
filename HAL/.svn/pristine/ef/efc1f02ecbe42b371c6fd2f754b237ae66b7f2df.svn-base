<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script> 
<%

	
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	int totalPatient=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	
	String fromDate = (String)utilMap.get("currentDate");
	String toDate = (String)utilMap.get("currentDate");

    if(map.get("FromDateId")!=null && map.get("ToDateId")!=null )
	{
    	
    	 fromDate = (String)map.get("FromDateId");
    	 toDate = (String)map.get("ToDateId");
	}
	 

	String depName="";
	if(session.getAttribute("deptName")!=null){
		depName=(String)session.getAttribute("deptName");	
	}
	
	
	/* List<PatientPrescriptionHeader>nursingCareWaitingList=new ArrayList<PatientPrescriptionHeader>();
	if(map.get("nursingCareWaitingList") != null){
		nursingCareWaitingList=(List)map.get("nursingCareWaitingList");
	} */
	List<Visit>pendingNursingList=(List<Visit>)map.get("pendingNursingList");
	%>
<div class="titleBg">
<h2><%=depName %></h2>
</div>
<div class="Block">
<div class="clear"></div>
<h4>OP Nursing Care Waiting List</h4>
<form name="op_nursingcare_Waiting_List" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop15">
<label>From Date</label>
<input type="text" id="FromDateId" name="FromDateId" class="dateTextSmall" value="<%=fromDate%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=date%>',document.op_nursingcare_Waiting_List.FromDateId,event);" />

<label>To Date</label>
<input type="text" id="ToDateId"name="ToDateId" class="dateTextSmall" value="<%=toDate%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	
	onclick="setdate('<%=date%>',document.op_nursingcare_Waiting_List.ToDateId,event);" />
</div>
<input type="button" name="search" value="Search" class="button"
onClick="if(datevalidation()){submitForm('op_nursingcare_Waiting_List','/hms/hms/opd?method=getOPNursingCareWaitingList');}" />
	<!-- onClick="if(datevalidation()){submitForm('op_nursingcare_Waiting_List','/hms/hms/opd?method=getPendingInjectionList');}" /> -->
	
</form>
</div>
<div class="clear"></div>
<div class="floatleft">
<div>
<jsp:include page="searchResultBlockForIPD.jsp" />
</div>
</div>
<div class="clear"></div>	
<div  id="test">
<div id="searchresults" tabindex=2 >
<div class="Blockdiv1"  id="searchtable" class="small" tabindex=2></div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	
	data_header[1] = new Array;
	data_header[1][0] = "Token No"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	
	data_header[2] = new Array;
	data_header[2][0] = "UHID"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";

	data_header[3] = new Array;
	data_header[3][0] = "OP Date"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";

	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "data";
	data_header[5][2] = "6%";

	data_header[6] = new Array;
	data_header[6][0] = "Gender"
	data_header[6][1] = "data";
	data_header[6][2] = "5%";

	data_header[7] = new Array;
	data_header[7][0] = "Doctor Name"
	data_header[7][1] = "data";
	data_header[7][2] = "5%";
	
/* 	data_header[8] = new Array;
	data_header[8][0] = "Patient Category"
	data_header[8][1] = "hide";
	data_header[8][2] = "5%"; */
	
	data_header[8] = new Array;
	data_header[8][0] = "Department"
	data_header[8][1] = "data";
	data_header[8][2] = "5%"; 
	
	data_header[9] = new Array;
	data_header[9][0] = "Status"
	data_header[9][1] = "data";
	data_header[9][2] = "5%";
	
	data_header[10] = new Array;
	data_header[10][0] = "Priority"
	data_header[10][1] = "data";
	data_header[10][2] = "5%";
	
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	if(pendingNursingList!=null && pendingNursingList.size()>0){
	Iterator iterator=pendingNursingList.iterator();
	
	while(iterator.hasNext())
	{	
		Visit visit=(Visit)iterator.next();
		int injHeaderId=0;
		
		String patientStatus="";
		Patient patientHin=(Patient)visit.getHin();
		//String patientCategory="";
		String departmentName="";
		
		String patientName="";
		String age="";
		String priority="";
	
			patientStatus="Pending";
		
	/* 	if(patientHin.getPatientCategory()!=null){
			 patientCategory=patientHin.getPatientCategory().getPatientCategoryName();
		} */
		if(patientHin.getAge()!=null && !patientHin.getAge().equals("")){
			age=patientHin.getAge();
		}
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
			
			if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
			}
			if(visit.getHin().getPLastName()!= null)
			{
			patientName=patientName+" "+visit.getHin().getPLastName();
			}
		
		}/* else if(visit.getHin().getFullName()!=null){
			patientName = visit.getHin().getFullName();
		} */
		String doctorName="";
		
		if(visit.getDoctor()!=null){
			if( !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			}
			
			if(visit.getDoctor().getDepartment()!=null && visit.getDepartment().getDepartmentName()!=null)
			departmentName = visit.getDepartment().getDepartmentName();
			
			
		/* 	if(doctorName.equals("")){
				if(visit.getDoctor().getEmployeeName()!=null && !visit.getDoctor().getEmployeeName().equals(" ")){
					doctorName=visit.getDoctor().getEmployeeName();
				}	
			} */
		}
		/* String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate()); */
		String sex="";
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		sex = masAdministrativeSex.getAdministrativeSexName();
		priority=String.valueOf(visit.getPriority());
		%>
		data_arr[<%= i%>] = new Array();
		data_arr[<%= i%>][0] ="<%=injHeaderId%>"
		data_arr[<%= i%>][2] ="<%=visit.getTokenNo()%>"
		data_arr[<%= i%>][3] ="<%=visit.getHin().getHinNo()%>"
		data_arr[<%= i%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate())%>" 
		data_arr[<%= i%>][5] = "<%=patientName%> " 
		data_arr[<%= i%>][6]="<%=age%>"
		data_arr[<%= i%>][7] = "<%=sex%>"
		data_arr[<%= i%>][8] = "<%=doctorName%>"
		data_arr[<%= i%>][9] = "<%=departmentName%>"
		data_arr[<%= i%>][10] ="<%=patientStatus%>"
		data_arr[<%= i%>][11] ="<%=priority%>"
		data_arr[<%= i%>][12] ="<%=visit.getId()%>"
	<%
		i++;
	}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "op_nursingcare_Waiting_List"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	
	
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
</script>
