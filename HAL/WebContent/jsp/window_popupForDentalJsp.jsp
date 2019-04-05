<%@page import="java.util.*"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * window_popupJsp.jsp
 * Purpose of the JSP -  This is for Window.
 * @author Ramdular
 * Create Date: 14th Sep,2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.masters.business.Visit"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<meta http-equiv="refresh" content="10;  url=/hms/hms/dental?method=showDentalPopupTokenJsp" />
<!-- 
<META HTTP-EQUIV="Refresh" CONTENT="3" >
 -->
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script>
//window.moveTo(1024,0);
</script>
<%
if(session.getAttribute("users")!=null){
 	int deptId=0;
int token=0;


Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

/*List<Visit> visitTokenList = new ArrayList<Visit>();
if (map.get("visitTokenList") != null) {
	visitTokenList = (List<Visit>)map.get("visitTokenList");
}*/
List<Object[]> tokenList = new ArrayList<Object[]>();
if (map.get("tokenList") != null) {
	tokenList = (List<Object[]>)map.get("tokenList");
}
if (map.get("deptId") != null) {
	deptId = (Integer)map.get("deptId");
}
//if (session.getAttribute("visitTokenList") != null) {
	//	visitTokenList = (List<Visit>)session.getAttribute("visitTokenList");
//}
%>
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<%if(tokenList.size()>=0){%>


		
		
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header" style="margin-left: 15px; left: 25px;">

	<thead>
		<tr class="gridheaderlabel">
				<td style="font-size: 25px;background:url(../images/tableheaderBg.gif) repeat-x #C6CEF2;"><strong>Room No.</strong></td>
				<td style="font-size: 25px;background:url(../images/tableheaderBg.gif) repeat-x #C6CEF2;"><strong>Medical Officer</strong></td>
				<td style="font-size: 25px;background:url(../images/tableheaderBg.gif) repeat-x #C6CEF2;"><strong>Patient Name</strong></td>
				<td style="font-size: 25px;background:url(../images/tableheaderBg.gif) repeat-x #C6CEF2;"><strong>Token No.</strong></td>
			</tr>
			</thead>
			<tbody>
			<%
			int counter=0;
		for(Object[] visit:tokenList){
			++counter;
			String docName="";
			String rank="";
			String sName="";
			String relation = "";
				if(visit[2] != null){
				docName+=visit[2];
					
				}
				if(visit[3] !=null){
					docName+=" "+visit[3];
				}
				if(visit[4]!=null){
					docName+=" "+visit[4];
				}
				if(visit[6]!= null){
					sName=(String)visit[6];
				}
				if(visit[7]!=null){
					sName+=" "+visit[7];
				}
				if(visit[8]!=null){
					sName+=" "+visit[8];
				}
			
			
				if(visit[1] != null){
					rank = (String)visit[1];
				}
			
			
				if(visit[9] != null){
					relation = (String)visit[9];
				}
			
			String sRank = "";
			
				if(visit[5] != null){
					sRank =(String)visit[5];
				}
			
			
			%>
			<tr>
			<%if(visit[0] != null ){ %>
				<td style="font-size: 30px;border: 1px solid #5A5959; background: #FDFDF3;"><%=visit[0]%></td>
				<%}else{ %>
				<td style="font-size: 30px;border: 1px solid #5A5959; background: #FDFDF3;">-</td>
				<%} %> 
				<td style="font-size: 30px;border: 1px solid #5A5959; background: #FDFDF3;"><%=rank+" "+docName%></td>
				<%if(relation.equals("Self")){ %>
				<td style="font-size: 30px;border: 1px solid #5A5959; background: #FDFDF3;"><%=sRank+" "+sName %></td>
				<%}else{ %>
				<td style="font-size: 30px;border: 1px solid #5A5959; background: #FDFDF3;"><%=relation+" of  "+sRank+" "+sName %></td>
				<%} %>
				<%if(visit[10] != null){ %>
				<td style="font-size: 30px; color: #AC1400;border: 1px solid #5A5959; background: #FDFDF3;"><%=visit[10] %></td>
				<%}else{ %>
				<td style="font-size: 30px; color: #AC1400;border: 1px solid #5A5959; background: #FDFDF3;">--</td>
				<%} %>
			</tr>
			<%
			}
			
				%>
		</tbody>
		</table>

<%
}
else{%>
<h4><span>Wait- Opd Not Started</span></h4>
<%}}else{%>
<script type="text/javascript" language="javascript">
  window.close();
 </script>
<%} %>
