
<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
	
	 	List<PhysioRequisitionDetail> physioDetailsList = new ArrayList<PhysioRequisitionDetail>();
		if (map.get("physioDetailsList") != null){
			physioDetailsList =(List<PhysioRequisitionDetail>)map.get("physioDetailsList");
		}
	 	
	%>
	
	

<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>



<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.PhysioVisitEntryHeader"%>
<%@page import="jkt.hms.masters.business.PhysioVisitEntryDetail"%>

<h4>Physiotherapy Details For Selected Requisition</h4>

<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">


	<thead>
		<tr>
			<th>Physiotherapy</th>
			<th>Status</th>
						
		</tr>
		<%
			Set<PhysioVisitEntryHeader> physioVisitEntryHeaders = new HashSet<PhysioVisitEntryHeader>();
			Set<PhysioVisitEntryDetail> physioVisitEntryDetails = new HashSet<PhysioVisitEntryDetail>();
			if(physioDetailsList.size()>0){
				System.out.println("physioDetailsListwww>>"+physioDetailsList.size());
				for(PhysioRequisitionDetail physioRequisitionDetail :physioDetailsList){
					String status="Pending";
					
					if(physioRequisitionDetail.getPhysioRequisitionHeader().getPhysioVisitEntryHeaders()!=null){
						System.out.println("loop>>");
						System.out.println("physioDetaiddddlsListwww>>"+physioRequisitionDetail.getPhysioRequisitionHeader().getPhysioVisitEntryHeaders());
						physioVisitEntryHeaders = physioRequisitionDetail.getPhysioRequisitionHeader().getPhysioVisitEntryHeaders();
						System.out.println("physioVisitEntryHeaders>>"+physioVisitEntryHeaders.size());
						for(PhysioVisitEntryHeader visitEntryHeader : physioVisitEntryHeaders){
							physioVisitEntryDetails = visitEntryHeader.getPhysioVisitEntryDetails();
						}
						System.out.println("physioVisitEntryDetails>>"+physioVisitEntryDetails);
						for(PhysioVisitEntryDetail visitEntryDetail : physioVisitEntryDetails){
							if(physioRequisitionDetail.getTharaphy().getId() == visitEntryDetail.getTharapy().getId()){
								status="Done";
								break;
							}
						}
					}
					System.out.println("physioDetaiddddlsListww555w>>"+physioRequisitionDetail.getPhysioRequisitionHeader().getPhysioVisitEntryHeaders());
		%>
		<tr >
			<td><%=physioRequisitionDetail.getTharaphy().getTherapyTypeName()%></td>
			<td><%=status %></td>
			</tr>	
		<%		}
			}
		%>
	</thead>
	
	</table>

<div class="Clear"></div>