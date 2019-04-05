<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Object[]> dgSampleCollDtList = new ArrayList<Object[]>();
		Patient patient = new Patient();

		DgSampleCollectionHeader dgSampleCollHeader = new DgSampleCollectionHeader();
		MasSubChargecode subChargeCode = new MasSubChargecode();
		
		Integer resultEntryIndex = 0;
		Integer counter = 0;
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if(request.getParameter("counter") != null){
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			dgSampleCollDtList= (List<Object[]>)patientMap.get("patientList");
		}
		
		if(dgSampleCollDtList.size() > 0 ){
			dgSampleCollHeader = (DgSampleCollectionHeader)dgSampleCollDtList.get(resultEntryIndex)[0];
			patient = ((DgSampleCollectionHeader)dgSampleCollDtList.get(resultEntryIndex)[0]).getHin();
			subChargeCode = (MasSubChargecode)dgSampleCollDtList.get(resultEntryIndex)[1];
		}
		
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<script type="text/javascript" language="javascript">

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0] = "<%=dgSampleCollHeader.getId()%>,<%=subChargeCode.getId()%>"
	data_arr[<%= counter%>][1]="<%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollHeader.getOrder().getOrderDate())%>"
data_arr[<%= counter%>][2] = "<%=dgSampleCollHeader.getOrder().getOrderNo()%>";

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollHeader.getDiagnosisDate())%>"
data_arr[<%= counter%>][4] = "<%=dgSampleCollHeader.getDiagnosisTime()%>"
	<%if(patient.getServiceNo() != null){%>
	data_arr[<%= counter%>][5] = "<%=patient.getServiceNo()!=null?patient.getServiceNo():""%> "
	<%}else{%>
	data_arr[<%= counter%>][5] ="-"
	<%}%>

<%
if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
	
	String pMiddleName = "";
	String plastName = "";
	if(patient.getPMiddleName() != null){
		pMiddleName = patient.getPMiddleName();
	}
	if(patient.getSLastName() != null){
		plastName = patient.getPLastName();
	}
	//coded by Ujjwal for null value of middle and last name
	String pName="";
	pName=patient.getPFirstName();
	if(pMiddleName!=null && !pMiddleName.equals("")){
		pName = patient.getPFirstName()+" "+pMiddleName;
	}
	if(plastName!=null && !plastName.equals("")){
		pName=pName+" "+plastName;
	}
	//code ended By Ujjwal
	String detailToDisplay = "";
	
	
	 %>
		data_arr[<%= counter%>][6] = "<%=pName%>"
	
	<%}else{%>
		data_arr[<%= counter%>][6] = "-"
<%}%>

<%String relationName="";
if(patient.getRelation() != null){ 
	if(patient.getRelation().getRelationName()!=null ){
		relationName = patient.getRelation().getRelationName();
	}

%>
data_arr[<%= counter%>][7] = "<%=relationName%>"
<%}else{%>
data_arr[<%= counter%>][7] = "-"
<%}%>


<%if(patient.getRank() != null){%>
data_arr[<%= counter%>][8] = "<%=patient.getRank()!=null?patient.getRank().getRankName():""%> "
<%}else{%>
data_arr[<%= counter%>][8] = "-"
<%}%>
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
	String detailToDisplay = "";
	
	
	 %>
		data_arr[<%= counter%>][9] = "<%=dgSampleCollHeader.getOrder().getDepartment().getDepartmentName()%> ";
	
	<%}else{%>
		data_arr[<%= counter%>][9] = "-"
<%}%>
<%if(patient.getAge() != null){%>
data_arr[<%= counter%>][10] = "<%=patient.getAge()%> "
<%}else{%>
data_arr[<%= counter%>][10] ="-"
<%}%>
<%if(patient.getSex() != null){%>
data_arr[<%= counter%>][11] = "<%=patient.getSex().getAdministrativeSexName()%> "
<%}else{%>
data_arr[<%= counter%>][11] ="-"
<%}%>
<%if(dgSampleCollHeader.getOrder() != null){%>
data_arr[<%= counter%>][12] = "<%=dgSampleCollHeader.getOrder().getPatientType()%> "
<%}else{%>
data_arr[<%= counter%>][12] ="-"
<%}%>

	<%if(dgSampleCollHeader.getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getFirstName()!=null){
						FirName = dgSampleCollHeader.getOrder().getPrescribedBy().getFirstName();
					}
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getMiddleName()!=null){
						midName = dgSampleCollHeader.getOrder().getPrescribedBy().getMiddleName();
					}
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getLastName()!=null){
						lastName = dgSampleCollHeader.getOrder().getPrescribedBy().getLastName();
					}
					String name =FirName+" "+midName+" "+lastName;
			%>

			data_arr[<%= counter%>][13] = "<%=name%>"
		<%}else{%>
			data_arr[<%= counter%>][13] = "-"
		<%}%>
		
data_arr[<%= counter%>][14] = "<%=patient.getId()%> "

<%if (dgSampleCollHeader != null){%>
data_arr[<%= counter%>][15] = "<%=dgSampleCollHeader.getId()%> "
<%}else{%>
data_arr[<%= counter%>][15] = "-"
<%}%>

<%if (subChargeCode != null){ %>
data_arr[<%= counter%>][16] = "<%=subChargeCode.getSubChargecodeName()%> "
<%}else{%>
data_arr[<%= counter%>][16] = "-"
<%}%>

<%if (subChargeCode != null){ %>
data_arr[<%= counter%>][17] = "<%=subChargeCode.getId()%> "
<%}else{%>
data_arr[<%= counter%>][17] = "-"
<%}

						if(dgSampleCollHeader.getOrder().getVisit()!=null){
							
							%>
								data_arr[<%= counter%>][18] ="<%=dgSampleCollHeader.getOrder().getVisit().getPriority()%>"
									<%
							}else{
									%>
									data_arr[<%= counter%>][18] ="0"
							<%
						}%>

</script>

