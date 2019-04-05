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
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.IpdSpecialistOpinion"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"
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
			List<IpdSpecialistOpinion> splOpinionList = new ArrayList<IpdSpecialistOpinion>();
					
			if(map.get("splOpinionList")!=null){
				splOpinionList = (List<IpdSpecialistOpinion>)map.get("splOpinionList");
			}
			Box box = HMSUtil.getBox(request);
			session.setAttribute("box",box);
	%>

<div class="titleBg">
<h2>Specialist Opinion</h2>
</div>
<div class="Clear"></div>
<form name="splOpinion" method="post" action="">
<% if(splOpinionList.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<div id="reg">
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr >
		<th scope="col">Sl No.</th>
		<th scope="col">Date</th>
		<th scope="col">Medical Officer</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(IpdSpecialistOpinion ipdSpecialistOpinion : splOpinionList){
		%>
		<tr onclick="submitForm('splOpinion','/hms/hms/ipd?method=getSpecialistOpinionDetails&ipdSpecialistOpinionId=<%=ipdSpecialistOpinion.getId() %>')">
		<td><%= i %></td>
		<td><%= HMSUtil.convertDateToStringWithoutTime(ipdSpecialistOpinion.getLastChangedDate()) %></td>
		
		<%if(ipdSpecialistOpinion.getMo()!=null){
		%>
		<td><%=ipdSpecialistOpinion.getMo() %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		
		</tr>
	<%i++;}
%>
</tbody>
</table>
</div>
<script>
		var pager = new Pager('tableData',20);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	<%}else{ %>
	<h4>No Records Found</h4>
	
	<%} %>
<div class="Clear"></div>
<div class="division"></div>

<input type="button" name="close" value="close" class="button" onclick="window.close();">
</form>




