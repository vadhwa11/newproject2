<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
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
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			List<Object[]> ipRegisterList = new ArrayList<Object[]>();
					
			if(map.get("ipRegisterList")!=null){
				ipRegisterList = (List<Object[]>)map.get("ipRegisterList");
			}
			int hospitalId = 0;
			if(map.get("hospitalId")!=null){
				hospitalId = (Integer)map.get("hospitalId");
			}
	%>

<div class="titleBg">
<h2>IPD Register</h2>
</div>
<div class="Clear"></div>
<form name="ipdRegister" method="post" action="">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>">
<% if(ipRegisterList.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">A&D No.</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Diagnosis</th>
		<th scope="col">DOA</th>
		<th scope="col">TOA</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(Object[] obj : ipRegisterList){
		%>
		<tr>
		<td><%= i %></td>
		<td><%=obj[7] %></td>
		<td><%= obj[1] %></td>
		<td><%= obj[2] %></td>
		<td><%= obj[3] %></td>
		<td><%= obj[4] %></td>
		<td><%= obj[5] %></td>
		<td><%= obj[6] %></td>
		<%if(obj[8]!=null){
		%>
		<td><%= obj[8] %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<td><%= HMSUtil.convertDateToStringWithoutTime((Date)obj[0])%></td>
		<td><%= obj[9] %></td>
		
		</tr>
	<%i++;}
%>
</tbody>
</table>
<script>
		var pager = new Pager('tableData',20);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	<%} %>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('ipdRegister','/hms/hms/adt?method=showIpAdmissionRegisterReportJsp')" accesskey="r" />
</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>





