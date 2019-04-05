<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<br />
<div id="contentspace"><script type="text/javascript"
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
	 			
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> employeeList = null;
			 	List<Object>empAfmsfDetList=null;
			 		
			 	
			 	if (map.get("employeeList") != null) {
			 		employeeList = (List<Object>) map.get("employeeList");
			 		
			 	}
			 	if (map.get("empAfmsfDetList") != null) {
			 		empAfmsfDetList = (List<Object>) map.get("empAfmsfDetList");
			 		
			 	}
			 				 
			 			 	
			 %> <%
				if(employeeList!=null){
					if(employeeList.size()>0){
						
						int counter=0;
						Iterator ite = employeeList.iterator();
						while ( ite.hasNext() ) {
					         Object[] pair = (Object[]) ite.next();
					         MasEmployee masEmployee = (MasEmployee) pair[0];
					                 			         
					     	         			        		          
		%>
<div id="show"><label class="bodytextB">A&D No.:</label> <span
	class="normalspan"><%=masEmployee.getInpatient().getAdNo()%></span> <% session.setAttribute("adNo",expiryDetails.getInpatient().getAdNo()); %>
<br />
<label class="bodytextB">Patient Name:</label> <span class="normalspan"><%=expiryDetails.getHin().getPFirstName()%>
<%=expiryDetails.getHin().getPLastName()%></span> <label class="bodytextB">Sex:</label>
<span class="normalspan"><%=expiryDetails.getHin().getSex().getAdministrativeSexName()%></span>

<label class="bodytextB">Relation:</label> <%if(expiryDetails.getHin().getRelation()!=null){ %>
<span class="normalspan"><%=expiryDetails.getHin().getRelation().getRelationName()%></span>
<%} else{%> <span class="normalspan">-</span> <%}%> <label class="bodytextB">Service
No.</label> <%if(expiryDetails.getHin().getServiceNo()!=null){ %> <span
	class="normalspan"><%=expiryDetails.getHin().getServiceNo()%></span> <%} else { %>
<span class="normalspan">-</span> <%} %> </br>
<label class="bodytextB">Rank:</label> <%if(expiryDetails.getHin().getRank()!=null){ %>
<span class="normalspan"><%= expiryDetails.getHin().getRank().getRankName()%></span>
<%}else {%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Service Name:</label> <%if( expiryDetails.getHin().getSFirstName()!=null && expiryDetails.getHin().getSLastName()!=null){ %>
<span class="normalspan"><%= expiryDetails.getHin().getSFirstName()%>
<%= expiryDetails.getHin().getSLastName()%></span> <%} else {%> <span
	class="normalspan">-</span> <%}%> <label class="bodytextB">Unit</label> <%if(expiryDetails.getHin().getUnit()!=null){ %>
<span class="normalspan"><%= expiryDetails.getHin().getUnit().getUnitName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Service:</label> <%if(expiryDetails.getHin().getServiceType()!=null){ %>
<span class="normalspan"><%=expiryDetails.getHin().getServiceType().getServiceTypeName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <br />

<label class="bodytextB">Branch Trade:</label> <%
		if(expiryDetails.getHin().getTrade()!=null){%> <span
	class="normalspan"><%=expiryDetails.getHin().getTrade().getTradeName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Total service:</label> <%if(expiryDetails.getHin().getServiceYears()!=null){ %>
<span class="normalspan"><%=expiryDetails.getHin().getServiceYears()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Ward No.</label> <span class="normalspan"><%=expiryDetails.getWard().getDepartmentName()%></span>

<label class="bodytextB">Age:</label> <span class="normalspan"><%=HMSUtil.calculateAgeForADT(expiryDetails.getHin().getAge(),expiryDetails.getHin().getRegDate())%></span>

</br>

<label class="bodytextB">DOB:</label> <%if(expiryDetails.getHin().getDateOfBirth()!=null){ %>
<span class="normalspan"><%=HMSUtil.convertDateToStringWithoutTime(expiryDetails.getHin().getDateOfBirth())%>%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Date of Death:</label> <span class="normalspan"><%=HMSUtil.convertDateToStringWithoutTime(expiryDetails.getExpiryDate())%></span>


<%				
				counter++;
							 }
						}
				}
		%>
</div>