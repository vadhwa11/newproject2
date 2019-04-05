<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<PreAnesthesiaConsultDoctorDt>wardList=new ArrayList<PreAnesthesiaConsultDoctorDt>();
if(map.get("wardList")!=null){
	wardList=(List<PreAnesthesiaConsultDoctorDt>)map.get("wardList");
}
if(map.get("message") != null){
   String message = (String)map.get("message");

%>
<h4><%=message %></h4>
<% }

if(wardList.size()>0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>


 <script type="text/javascript">

formFields = [
			[0, "ID", "id"], [1,"Employee No."], [2,"HIN No."], [3,"PatientName"], [4,"Relation"], [5,"Age"], [6,"Gender"], [7,"Referral Date"], [8,"Referred By Department"], [9,"Referred By Doctor"], [10,"Referral Note"], [11, "Status"]];
	 statusTd = 4;
	</script></div><form name="internalReferal" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div id="edited">
</div>
	
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee No."
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "Service No."

data_header[1] = new Array;
data_header[1][0] = "HIN No."
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "HIN No."

data_header[2] = new Array;
data_header[2][0] = "PatientName"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "Patient Name";

data_header[3] = new Array;
data_header[3][0] = "Relation"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "Relation";

data_header[4] = new Array;
data_header[4][0] = "Age"
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "Age";

data_header[5] = new Array;
data_header[5][0] = "Gender"
data_header[5][1] = "data";
data_header[5][2] = "20%";
data_header[5][3] = "Gender";

data_header[6] = new Array;
data_header[6][0] = "Referral Date"
data_header[6][1] = "data";
data_header[6][2] = "30%";
data_header[6][3] = "Referral Date";

data_header[7] = new Array;
data_header[7][0] = "Referred By Department"
data_header[7][1] = "data";
data_header[7][2] = "40%";
data_header[7][3] = "Referred By Department";

data_header[8] = new Array;
data_header[8][0] = "Referred By Doctor"
data_header[8][1] = "data";
data_header[8][2] = "40%";
data_header[8][3] = "Referred By Doctor";

data_header[9] = new Array;
data_header[9][0] = "Referral Note "
data_header[9][1] = "hide";
data_header[9][2] = "60%";
data_header[9][3] = "Referral Note";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "Status"


data_arr = new Array();

<%
Iterator itr=wardList.iterator();
          int  counter=0;
          String patientName="";
          String referredByDoctor="";
          while(itr.hasNext())
           {
        	  patientName="";
        	  referredByDoctor = "";
        	  PreAnesthesiaConsultDoctorDt  consultDoctorDt = (PreAnesthesiaConsultDoctorDt)itr.next();
             patientName=consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPFirstName();
             if(consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPMiddleName()!=null && !consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPMiddleName().equals(""))
             {
            	 patientName+=" "+consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPMiddleName();
             }
             if(consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPLastName()!=null && !consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPLastName().equals(""))
             {
            	 patientName+=" "+consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getPLastName();
             }
             referredByDoctor=consultDoctorDt.getOpdPatientDetails().getEmployee().getFirstName();
             if(consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName()!=null && !consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName().equals(""))
             {
            	 referredByDoctor+=" "+consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName();
             }
             if(consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName()!=null && !consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName().equals(""))
             {
            	 referredByDoctor+=" "+consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName();
             }
             
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= consultDoctorDt.getConsultDoctorIdHd().getInpatient().getId()%>
data_arr[<%= counter%>][1] = <%= consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getServiceNo()!=null?consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getServiceNo():""%>
data_arr[<%= counter%>][2] = "<%=consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getHinNo()%>"
data_arr[<%= counter%>][3] = "<%=patientName%>"
	data_arr[<%= counter%>][4] = "<%=consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getRelation().getRelationName()%>"
		data_arr[<%= counter%>][5] = "<%=consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getAge()%>"
			data_arr[<%= counter%>][6] = "<%=consultDoctorDt.getConsultDoctorIdHd().getInpatient().getHin().getSex().getAdministrativeSexName()%>"
				data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(consultDoctorDt.getOpdPatientDetails().getReferredDate())%>"
					data_arr[<%= counter%>][8] = "<%=consultDoctorDt.getOpdPatientDetails().getDepartment().getDepartmentName()%>"
						data_arr[<%= counter%>][9] = "<%=referredByDoctor%>"
						
	data_arr[<%= counter%>][10] = "<%=consultDoctorDt.getReferralNotes().trim()%>"
<% if(consultDoctorDt.getStatus().equalsIgnoreCase("P")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>]11] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "internalReferal"

<%-- nonEditable = ['<%= CODE%>']; --%>
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<%}else{ %>
<h4>No Records Found!!</h4>
<%} %>
</form>