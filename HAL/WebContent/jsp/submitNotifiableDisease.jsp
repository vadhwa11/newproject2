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
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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
					 	
			 	List<Object> list = null;
			 	Date dateOfDeath=null;
			 	
			 		
			 	
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 
			 			 	
			 %> <%
				if(list!=null){
					if(list.size()>0){
						
						int counter=0;
						Iterator ite = list.iterator();
						while ( ite.hasNext() ) {
					         Object[] pair = (Object[]) ite.next();
					         Inpatient inpatient = (Inpatient) pair[0];
					                 			         
					     	         			        		          
		%>
<div id="show"><label class="bodytextB">Patient Name:</label> <span
	class="wardspan"><%=inpatient.getHin().getPFirstName()%> <%=inpatient.getHin().getPLastName()%></span>

<%if(inpatient.getHin().getRank()!=null){ %> <label class="bodytextB">Rank:</label>
<span class="wardspan"><%= inpatient.getHin().getRank().getRankName()%></span>
<%} %> <%if(inpatient.getHin().getUnit()!=null){ %> <label class="bodytextB">Unit</label>
<span class="wardspan"><%= inpatient.getHin().getUnit().getUnitName()%></span>
<%} %> <label class="bodytextB">Length of serv:</label> <%if(inpatient.getHin().getServiceYears()!=null){ %>
<span class="wardspan"><%=inpatient.getHin().getServiceYears()%></span>
<%}
		else{%> <span class="wardspan">-</span> <%} %> <br />
<label class="bodytextB">Date of Adm.:</label> <%if(inpatient.getDateOfAddmission()!=null){ %>

<span class="wardspan"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission())%></span>
<%}else{%> <span class="wardspan">-</span> <%} %> <label class="bodytextB">Age:</label>
<span class="wardspan"><%=HMSUtil.calculateAgeForADT(inpatient.getHin().getAge(),inpatient.getHin().getRegDate())%></span>



<%
				
				session.setAttribute("hinId",inpatient.getHin().getId());
				session.setAttribute("inpatientId",inpatient.getId());
				session.setAttribute("hospitalId",inpatient.getHospital().getId());
				counter++;
							 }
						}
				}
		%>
</div>