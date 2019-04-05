<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
		List<Object> visitNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
  	    
		
%>
<select	name="<%=VISIT_ID%>" validate="Visit No,string,yes" onchange="getPatientDetailsForMinorSurgery('/hms/hms/registration?method=getPatientDetailsForMinorSurgery&visitId='+this.value)">
	<option value="">Select</option>
	<% 
	     	if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = visitNoList.iterator(); iterator.hasNext();) {
	    			Visit visit = (Visit)iterator.next();
				%>
	<option value="<%=visit.getId()%>"><%=visit.getVisitNo() %>
	</option>
	<% 
	     		}
			} 
	     	 
			 %>

</select>