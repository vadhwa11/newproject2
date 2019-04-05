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
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"
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
			List<Object[]> opdRegisterList = new ArrayList<Object[]>();
					
			if(map.get("opdRegisterList")!=null){
				opdRegisterList = (List<Object[]>)map.get("opdRegisterList");
			}
			Box box = HMSUtil.getBox(request);
			session.setAttribute("box",box);
	%>

<div class="titleBg">
<h2>Registration Register</h2>
</div>
<div class="Clear"></div>
<form name="regRegister" method="post" action="">
<% if(opdRegisterList.size() >0){ %>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl.No.</th>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Medical Officer</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(Object[] visit : opdRegisterList){
		%>
		<tr>
		<td><%= i %></td>
		<td><%= HMSUtil.convertDateToStringWithoutTime((Date)visit[0]) %></td>
		<td><%= visit[1] %></td>
		<td><%= visit[2] %></td>
		<td><%= visit[3] %></td>
		<td><%= visit[4] %></td>
		<td><%= visit[5] %></td>
		<td><%= visit[6] %></td>
		<td><%= visit[8] %></td>
		
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
<input type="button" name="print" value="Print" class="button" onClick="submitForm('regRegister','registration?method=printRegistrationRegisterReport');" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />

<input type="button" name="Back" value="Back" class="button" onclick="javascript:history.back()" accesskey="r" />

</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</div>

<script>
function openGraph(){
	var url = "registration?method=showRegistrationStatisticsGraph";
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>



