<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		List<String> stringOfIdsList = new ArrayList<String>();

		Patient patient = new Patient();
		DgResultEntryHeader dgResultDetail = new DgResultEntryHeader();
		//DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
		Map<String,Object> orderDetailMap = new HashMap<String,Object >();
		
		Integer resultEntryIndex = 0;
		String requestFlag = "";
		String stringOfSubDeptIds = "";
		String stringOfIds = "";
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
			patientList= (List<DgResultEntryHeader>)patientMap.get("patientList");
		}
		if(patientMap.get("stringOfIdsList") != null){
			stringOfIdsList = (List<String>)patientMap.get("stringOfIdsList");
			
		}
		if(patientMap.get("stringOfSubDeptIdsList") != null){
			stringOfSubDeptIdsList= (List<String>)patientMap.get("stringOfSubDeptIdsList");
			
		}
		
		if(patientList.size() > 0 ){
			dgResultDetail = patientList.get(resultEntryIndex);
			stringOfIds = stringOfIdsList.get(resultEntryIndex);
			stringOfSubDeptIds = stringOfSubDeptIdsList.get(resultEntryIndex);
			//dgResultEntryDetail = dgResultDetail.getDgResultEntryDetails().iterator().next();
			patient = dgResultDetail.getSampleCollectionHeader().getHin();
		}
		
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<script type="text/javascript" language="javascript">

		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=stringOfIds%>@<%=stringOfSubDeptIds%>"
		  		data_arr[<%= counter%>][1] = "<%=dgResultDetail.getResultNo()%>"
				data_arr[<%= counter%>][2] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getOrderNo()%>"
				data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(dgResultDetail.getResultDate())%>"
				data_arr[<%= counter%>][4] = "<%=dgResultDetail.getResultTime()%>"
				
				
					<%
					if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
						
						String pMiddleName = "";
						String plastName = "";
						if(patient.getPMiddleName() != null){
							pMiddleName = patient.getPMiddleName();
						}
						if(patient.getSLastName() != null ){
							plastName = patient.getPLastName();
						}
						//coded by Ujjwal by null value of missle and last name
						String pName ="";
						pName=patient.getPFirstName();
						if(pMiddleName!=null && !pMiddleName.equals(""))
							{
							pName=patient.getPFirstName()+" "+pMiddleName;
							}
						if(plastName!=null && pMiddleName.equals("")){
							pName=pName+" "+plastName;
						}
						//code ended By Ujjwal
						String detailToDisplay = "";
						
						
						 %>
							data_arr[<%= counter%>][5] = "<%=pName%>"
						
						<%}else{%>
							data_arr[<%= counter%>][5] = "-"
					<%}%>
								data_arr[<%= counter%>][6] = "<%=patient.getHinNo()%> "
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

<%if(patient.getServiceNo() != null){%>
data_arr[<%= counter%>][8] = "<%=patient.getServiceNo()%> "
<%}else{%>
data_arr[<%= counter%>][8] ="-"
<%}%>

<%if(patient.getRank() != null){%>
data_arr[<%= counter%>][9] = "<%=patient.getRank()!=null?patient.getRank().getRankName():""%> "
<%}else{%>
data_arr[<%= counter%>][9] = "-"
<%}%>

		data_arr[<%= counter%>][10] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%>";
	
	
	<%if(dgResultDetail.getPatient() != null){%>
				data_arr[<%= counter%>][11] = "<%=dgResultDetail.getPatient().getAge()%> "
				<%}else{%>
				data_arr[<%= counter%>][11] = "-"
				<%}%>
				
				data_arr[<%= counter%>][12] = "<%=dgResultDetail.getPatient().getSex().getAdministrativeSexName()%> "
				
				<%
				
		
				if(dgResultDetail.getSampleCollectionHeader().getCollectionTime() !=null)
				{
					Calendar cal1=Calendar.getInstance();
					cal1.setTime(dgResultDetail.getSampleCollectionHeader().getCollectionTime());
					cal1.add(Calendar.HOUR, 6);
					
					
					Calendar cal2=Calendar.getInstance();
					cal2.setTime(new Date());
				
					
					System.out.println(cal2.after(cal1)); 
					
					if(cal2.after(cal1))
					{
						%>
							data_arr[<%= counter%>][18] ="6hrs"
						<%
					}
				}
				
				
				
			
				
				
				%>
				
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][13] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()%> "
				<%}else{%>
				data_arr[<%= counter%>][13] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
						FirName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
							midName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
							lastName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
						}
						String name =FirName+" "+midName+" "+lastName;
					
				%>
				data_arr[<%= counter%>][14] = "<%=name%>"
				<%}else{%>
				data_arr[<%= counter%>][14] = "-"
				<%}%>
				
				data_arr[<%= counter%>][15] = "<%=dgResultDetail.getId()%>"
			
				<%
				if(dgResultDetail.getSubChargecode() != null){%>
				data_arr[<%= counter%>][16] = "<%=dgResultDetail.getSubChargecode().getSubChargecodeName()%>"
				<%}else{%>
				data_arr[<%= counter%>][16] ="-"
				<% }if(dgResultDetail.getSampleCollectionHeader().getOrder().getVisit()!=null){
					
					%>
						data_arr[<%= counter%>][17] ="<%=dgResultDetail.getSampleCollectionHeader().getOrder().getVisit().getPriority()%>"
							<%
					}else{
							%>
							data_arr[<%= counter%>][17] ="0"
					<%
				} %>

</script>

