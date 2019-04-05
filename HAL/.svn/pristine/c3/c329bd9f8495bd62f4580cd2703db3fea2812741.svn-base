<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
	</script> <%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		int deptId=0;
		if (session.getAttribute("deptId") != null)
			deptId =(Integer)session.getAttribute("deptId");
		
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}

	%> <br>
<br>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<form name="search" method="post" action=""><label>Service
No.</label> <input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	tabindex="1" validate="" MAXLENGTH="30" tabindex=1 />
<div id="patientNameDiv"><label>A&D No</label> <input type="text"
	id="patientName" name="<%=AD_NO %>" value="" MAXLENGTH="30" tabindex=1 />
</div>
<label>Hin No </label>
<div id="testDiv"><input type="text" id="visitId"
	name="<%=HIN_NO %>" value="" tabindex=1 /></div>

<div class="Clear"></div>
<label>Ward</label> <select name="<%=WARD_ID %>">
	<option value="0"><--Select Ward--></option>
	<%
				for(MasDepartment masDepartment : wardList)
				{
					if(masDepartment.getId() == deptId){ %>
	<option selected="selected" value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<% }else{
				%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
					}
				}
				%>
</select>


<div class="Clear"></div>


</form>
<label>&nbsp;</label> <input type="button" name="submit" id="addbutton"
	onclick="submitForm('search','/hms/hms/lab?method=searchPatientDetailsForIPD');"
	value="Search" class="cmnButton" accesskey="a" /></div>
<div class="division"></div>


<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="ipdOrderBookingForRadioLab" method="post" action="">
<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"],[2,"hin"], [3,"a&dNo"], [4,"patName"], [5,"serviceType"], [6,"sPersonName"], [7,"rank"], [8,"unit"], [9,"ward"]];
	 statusTd = 9;
	</script>
</div>
</form>
</div>
<script type="text/javascript" language="javascript">
			data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Hin"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "A&D No"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "a&dNo";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Service Type"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "serviceType"
	
	data_header[5] = new Array;
	data_header[5][0] = "Service Person Name"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	
	data_header[6] = new Array;
	data_header[6][0] = "Rank"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "rank";
	
	data_header[7] = new Array;
	data_header[7][0] = "Unit"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "unit"
	
	data_header[8] = new Array;
	data_header[8][0] = "Ward"
	data_header[8][1] = "data";
	data_header[8][2] = "30%";
	data_header[8][3] = "ward";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (inpatientList != null && inpatientList.size() > 0) { %>
	
	<% 	for(Inpatient inpatient : inpatientList){
		if(inpatient.getAdStatus().equals("A")){
		Patient patient = inpatient.getHin();
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=inpatient.getAdNo()%>"
			data_arr[<%= counter%>][4] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%> "
			data_arr[<%= counter%>][5] = "<%=patient.getServiceType().getServiceTypeName()%> "
			<%
			if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(patient.getSMiddleName() != null){
					sMiddleName = patient.getSMiddleName();
				}
				if(patient.getSLastName() != null){
					sLastName = patient.getSLastName();
				}
				String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
				
			%>
			data_arr[<%= counter%>][6] = "<%=sName%>"
			<%}else{%>
			data_arr[<%= counter%>][6] = ""
			<%}
			if(patient.getRank() != null){
			%>
			data_arr[<%= counter%>][7] = "<%=patient.getRank().getRankName()%> "
			<%}else{%>
			data_arr[<%= counter%>][7] = ""
			<%}
			if(patient.getUnit() != null){
			%>
			data_arr[<%= counter%>][8] = "<%=patient.getUnit().getUnitName()%> "
			<%}else{%>
			data_arr[<%= counter%>][8] = ""
			<%}%>
	<%
		if(inpatient.getDepartment()!= null){
		%>
			data_arr[<%= counter%>][9] = "<%= inpatient.getDepartment().getDepartmentName()%>"
	<%	}else{%>
			data_arr[<%= counter%>][9] = ""
		<%
				}
			     counter++;
	}//for if
	    	}
		}
	%>
	
    formName = "ipdOrderBookingForRadioLab";
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
</div>
