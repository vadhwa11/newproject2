<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MisNotifiable"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
		
		
	</script>


<div class="titleBg"><h2>Print Notifiable Disease Details</h2></div>
<div class="clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> list = null;
			 	List<MisNotifiable> misNotifiableList = new ArrayList<MisNotifiable>();;
			 	Date dateOfDeath=null;
			 	
			 		
			 	
			 	if (map.get("misNotifiableList") != null) {
			 		misNotifiableList = (List<MisNotifiable>) map.get("misNotifiableList");
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }
			 		 	
			 %>


<form name="notifiableDisease" method="post" action="">
<div class="Block">
<div class="clear"></div>
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header" style="margin-left: 15px; left: 25px;">

	<thead>
		<tr class="gridheaderlabel">

			<td width="10%"><strong>Sr. No.</strong></td>
			<td width="20%"><strong>Notifiable Date</strong></td>
			<td width="20%"><strong>Service No</strong></td>
			<td width="20%"><strong>Hin No</strong></td>
			<td width="20%"><strong>Designation of Quarters</strong></td>
			<td width="20%"><strong>Date of Onset</strong></td>
			
			<td width="20%" align="center"><strong>Print</strong></td>


		</tr>

	</thead>


	<tbody>
<%
	if(misNotifiableList.size()>0){
		int ct=0;
		for(MisNotifiable misNotifiable:misNotifiableList){
	++ct;
	String serviceNo="";
	String hinNo="";
		if(misNotifiable.getHin()!=null){
			serviceNo=misNotifiable.getHin().getServiceNo();
			hinNo=misNotifiable.getHin().getHinNo();
		}
%>
		<tr>
			<td width="10%"><%=ct %>.)</td>
			<td width="20%"><%=misNotifiable.getNotifiableDate() %></td>
			<td width="20%"><%=serviceNo %></td>
			<td width="20%"><%=hinNo %></td>
			<td width="20%"><%=misNotifiable.getDesignationOfQuaters() %></td>
			<td width="20%"><%=misNotifiable.getDateOnSetDate() %></td>
			<td width="20%" align="center"><a href="sHO?method=printNotifiableDiseaseReport&notifiableId=<%=misNotifiable.getId() %>"><%=hinNo %></a></td>
		</tr>
<%
			
		}
	}else{
		
	}
%>
	</tbody>
</table>

</div>
<div id="edited"></div>
<label>&nbsp;</label>
</form>
</div>





