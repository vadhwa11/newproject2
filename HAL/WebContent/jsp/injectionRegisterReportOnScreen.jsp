<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.InjectionRegisterDetails"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
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
	List<InjectionRegisterDetails> injectionRegisterList = new ArrayList<InjectionRegisterDetails>();

	List<Object[]> unitList = new ArrayList<Object[]>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");

		
	if(map.get("injectionRegisterList") != null){
		injectionRegisterList=(List<InjectionRegisterDetails>)map.get("injectionRegisterList");
	}
	
	
	%>
<form name="aiercraftEmergencyRegister" method="post" action="">
<div class="titleBg">
<h2>Injection Administration Register</h2>
</div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age/Gender</th>
		<th scope="col">Diagnosis</th>
		<th scope="col">MO/MA</th>
		<th scope="col">Injection</th>
		<th scope="col">ml</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">Allergic Testing</th>
		<th scope="col">Adverse Reaction</th>
	</tr>
	<tr>
		<%
	int i=1;
	for(InjectionRegisterDetails injectionRegisterDetails : injectionRegisterList){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(injectionRegisterDetails.getInjectionRegister().getInjectionDate()) %></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getServiceNo()!=null?injectionRegisterDetails.getInjectionRegister().getHin().getServiceNo():"" %></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getPFirstName()+" "+(injectionRegisterDetails.getInjectionRegister().getHin().getPMiddleName()!=null?injectionRegisterDetails.getInjectionRegister().getHin().getPMiddleName():"") +" "+(injectionRegisterDetails.getInjectionRegister().getHin().getPLastName()!=null?injectionRegisterDetails.getInjectionRegister().getHin().getPLastName():"")%></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getRelation().getRelationName() %></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getSFirstName()+" "+(injectionRegisterDetails.getInjectionRegister().getHin().getSMiddleName()!=null?injectionRegisterDetails.getInjectionRegister().getHin().getSMiddleName():"") +" "+(injectionRegisterDetails.getInjectionRegister().getHin().getSLastName()!=null?injectionRegisterDetails.getInjectionRegister().getHin().getSLastName():"")%></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getUnit().getUnitName()%></td>
		<td><%=injectionRegisterDetails.getInjectionRegister().getHin().getAge() +"/"+injectionRegisterDetails.getInjectionRegister().getHin().getSex().getAdministrativeSexName()%></td>
		<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(injectionRegisterDetails.getInjectionRegister().getVisit()!=null){
		visit = injectionRegisterDetails.getInjectionRegister().getVisit();
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
		if(injectionRegisterDetails.getInjectionRegister().getMedicalOfficer()!=null){
		%>
		<td><%=injectionRegisterDetails.getInjectionRegister().getMedicalOfficer().getFirstName()+" "+(injectionRegisterDetails.getInjectionRegister().getMedicalOfficer().getMiddleName()!=null?injectionRegisterDetails.getInjectionRegister().getMedicalOfficer().getMiddleName():"") +" "+(injectionRegisterDetails.getInjectionRegister().getMedicalOfficer().getLastName()!=null?injectionRegisterDetails.getInjectionRegister().getMedicalOfficer().getLastName():"") %></td>
<%}else{ %>
<td>&nbsp;</td>
<%} %>
		<td><%=injectionRegisterDetails.getItem().getNomenclature() %></td>
		<td><%=injectionRegisterDetails.getDose() %></td>
		<td><%=injectionRegisterDetails.getRoute() %></td>
		<td><%=injectionRegisterDetails.getFrequency().getFrequencyName() %></td>
		<td><%=(injectionRegisterDetails.getAllergicTesting()!=null?injectionRegisterDetails.getAllergicTesting():"") %></td>
		<td><%=(injectionRegisterDetails.getAdverseReaction()!=null?injectionRegisterDetails.getAdverseReaction():"") %></td>
	</tr>
	<%i++;} %>

</table>
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="Back" value="Back" class="button"onclick="javascript:history.back()" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

</form>
