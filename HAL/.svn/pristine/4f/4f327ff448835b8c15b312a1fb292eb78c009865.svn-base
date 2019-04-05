<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<ProcedureHeader> procedureDetailsList = new ArrayList<ProcedureHeader>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("procedureDetailsList") != null){
		procedureDetailsList=(List<ProcedureHeader>)map.get("procedureDetailsList");
	}
	
	
	%>
<form name="aiercraftEmergencyRegister" method="post" action="">
<div class="titleBg">
<h2>Procedure Register Report</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date </th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age</th>		
		<th scope="col">Gender</th>
		<th scope="col">Diagnosis</th>		
		<th scope="col">MO/MA</th>
		<th scope="col">Procedure(s)</th>
		<th scope="col">Remarks</th>
	</tr>
		<tr>
	<%
	int i=1;
	for(ProcedureHeader procedureHeader : procedureDetailsList){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(procedureHeader.getProcedureDate()) %></td>
		<td><%=procedureHeader.getHin().getServiceNo() !=null?procedureHeader.getHin().getServiceNo():""%></td>
		<td><%=procedureHeader.getHin().getPFirstName()+" "+(procedureHeader.getHin().getPMiddleName()!=null?procedureHeader.getHin().getPMiddleName():"") +" "+(procedureHeader.getHin().getPLastName()!=null?procedureHeader.getHin().getPLastName():"")%></td>
		<td><%=procedureHeader.getHin().getRelation().getRelationName() %></td>
		<td><%=procedureHeader.getHin().getSFirstName()+" "+(procedureHeader.getHin().getSMiddleName()!=null?procedureHeader.getHin().getSMiddleName():"") +" "+(procedureHeader.getHin().getSLastName()!=null?procedureHeader.getHin().getSLastName():"")%></td>
		<td><%=procedureHeader.getHin().getUnit().getUnitName()%></td>
		<td><%=procedureHeader.getHin().getAge()%></td>
		<td><%=procedureHeader.getHin().getSex().getAdministrativeSexName()%></td>
		<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(procedureHeader.getVisit()!=null){
		visit = procedureHeader.getVisit();
		if(visit.getDischargeIcdCodes()!= null){
			icdSet = visit.getDischargeIcdCodes();
		}
		if(visit.getOpdPatientDetails()!= null){
			patientDetails = visit.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getInitialDiagnosis()!= null){
					diagnosis = opdPatientDetails.getInitialDiagnosis();
				}else{
					if(icdSet.size() > 0){
						for(DischargeIcdCode icdCode : icdSet){
							if(!diagnosis.equals("")){
								diagnosis += ",";
							}
							diagnosis += icdCode.getIcd().getIcdName();
						}
					}
					
				}
			}
		}
		
	}
%>
<td><%=diagnosis %></td>
<%
if(procedureHeader.getMedicalOfficer()!=null){
%>
<td><%=procedureHeader.getMedicalOfficer().getRank().getRankName()+" "+ procedureHeader.getMedicalOfficer().getFirstName()+" "+(procedureHeader.getMedicalOfficer().getMiddleName()!=null?procedureHeader.getMedicalOfficer().getMiddleName():"") +" "+(procedureHeader.getMedicalOfficer().getLastName()!=null?procedureHeader.getMedicalOfficer().getLastName():"") %></td>
<%}else{ %>
<td>&nbsp;</td>
<%} %>
<%
	Set<ProcedureDetails> proDtSet = new HashSet<ProcedureDetails>();
	proDtSet = procedureHeader.getProcedureDetails();
	String procedures="";
	String remarks="";
	for(ProcedureDetails procedureDetails :proDtSet){
		if(!procedures.equals("")){
			procedures += ",";
		}
		if(!remarks.equals("")){
			remarks +=",";
		}
		procedures += procedureDetails.getNursingCare()!=null?procedureDetails.getNursingCare().getNursingName():procedureDetails.getProcedureName();
		if( procedureDetails.getRemarks()!=null)
			remarks += procedureDetails.getRemarks();
	}

%>
		<td><%=procedures %></td>
		
		<td><%=remarks %></td>
			
	</tr>
	<%i++;} %>
	</table><div class="Clear"></div>
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="javascript:history.back()" accesskey="r" />
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="Clear"></div>

</form>
