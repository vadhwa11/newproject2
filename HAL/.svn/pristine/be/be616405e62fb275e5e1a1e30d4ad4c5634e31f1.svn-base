<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Object[]> dgSampleCollDtList = new ArrayList<Object[]>();
		Patient patient = new Patient();
		Object[] dgsampleDetails = new DgSampleCollectionDetails[0];
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		Integer resultEntryIndex = 0;
		String requestFlag = "";
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
		if(patientMap.get("patientDeatilList") != null){
			dgSampleCollDtList= (List<Object[]>)patientMap.get("patientDeatilList");
		}
		
		if(dgSampleCollDtList.size() > 0 ){

			dgsampleDetails = dgSampleCollDtList.get(resultEntryIndex);
			patient = ((DgSampleCollectionHeader)dgsampleDetails[0]).getHin();
			dgSampleCollectionHeader = ((DgSampleCollectionHeader)dgsampleDetails[0]);
			masSubChargecode = ((MasSubChargecode)dgsampleDetails[1]);
		}
		
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<script type="text/javascript" language="javascript">
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%= dgSampleCollectionHeader.getId()%>,<%=masSubChargecode.getId()%>"
			data_arr[<%= counter%>][1] = "<%= HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionHeader.getDiagnosisDate())%>-<%= dgSampleCollectionHeader.getDiagnosisTime()%>"
				data_arr[<%= counter%>][2] = "<%= dgSampleCollectionHeader.getOrder().getOrderNo()%>"

			data_arr[<%= counter%>][3] = "<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>"
			
						<%
				if(patient.getRank() != null){
				%>
				data_arr[<%= counter%>][4] = "<%=patient.getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][4] = ""
				<%}	%>
				
				
			
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
				
				
				if(patient.getRelation() != null){ 
					if(!patient.getRelation().getRelationCode().equalsIgnoreCase("06") ){
						detailToDisplay = patient.getRelation().getRelationName() +" of ";
					}

				} %>
				
				<% if(patient.getRank() != null){
					detailToDisplay = detailToDisplay + patient.getRank().getRankName();
				}
				%>
						
					data_arr[<%= counter%>][5] = " <%=sName%>"
				
				<%}else{%>
					data_arr[<%= counter%>][5] = ""
				<%} %>
				
	           	data_arr[<%= counter%>][6] = "<%-- <%=patient.getServiceType().getServiceTypeName()%> --%> "
				data_arr[<%= counter%>][7] = "<%=patient.getHinNo()%>"
				
				<% 
				String pName = patient.getPFirstName();
				if(patient.getPMiddleName() != null){ 
					pName = pName + " " + patient.getPMiddleName(); 
				} 
				if(patient.getPLastName() != null){ 
					pName = pName + " " + patient.getPLastName();
				}
				
				%>
				data_arr[<%= counter%>][8] = "<%=pName%>"
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
				detailToDisplay = sName;
				
				if(patient.getRelation() != null){ 
					detailToDisplay = patient.getRelation().getRelationName() +" of ";
				} %>
				
				<% if(patient.getRank() != null){
					detailToDisplay = detailToDisplay + patient.getRank().getRankName();
				}
				%>
						
					data_arr[<%= counter%>][9] = "<%=sName%>"
				
				<%}else{%>
					data_arr[<%= counter%>][9] = ""
				<%} %>
				
				<%
				if(dgSampleCollectionHeader.getOrder().getDepartment() != null){
				%>
					data_arr[<%= counter%>][10] = "<%=dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName()%> "
				
				<%}%>
				<%
				if(masSubChargecode != null){
				%>
					data_arr[<%= counter%>][11] = "<%=masSubChargecode.getSubChargecodeName()%> "
				
				<%}%>
				
				<%
				if(dgSampleCollectionHeader.getOrder().getPrescribedBy() != null){
				%>
					data_arr[<%= counter%>][12] = "<%=dgSampleCollectionHeader.getOrder().getPrescribedBy().getFirstName()%> "
				
				<%}%>

</script>

