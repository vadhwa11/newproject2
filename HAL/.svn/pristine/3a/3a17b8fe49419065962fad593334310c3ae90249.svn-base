<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


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
		String userName = "";
		String date ="";
		String time = "";
		String reply = "";
		String department = "";
		Map map = new HashMap();
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		Set inpatientSet = null;
		Inpatient inpatient = new Inpatient();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		date = (String)utilMap.get("currentDate");	
		time = (String)utilMap.get("currentTime");
		
  	    if (map.get("inpatientSet") != null)
  	    	inpatientSet =(Set)map.get("inpatientSet");
  	    
		if (map.get("department") != null)
			department = (String)map.get("department");
			

  	    if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
  	  	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
  		if (map.get("inpatientList") != null)
  			inpatientList =(List<Inpatient>)map.get("inpatientList");
	    
%>
<div id="testDiv"><label class="bodytextB">Admission No.:
</label> <select name="<%=ADMISSION_NUMBER%>" validate="Admission No,yes">
	<% if (inpatientList!=null && inpatientList.size() > 0 ) 
	     	{ 
				Iterator itr = inpatientList.iterator();
				while (itr.hasNext())				
				{ 
					inpatient = (Inpatient)itr.next();
				%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>
	<% } %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='';
		//	 	document.getElementById('department').value='<%=department%>';
			 </script>
	<% } 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='* Wrong Hin Number';
			 </script>
	<%
			  }
	     	 %>
</select></div>