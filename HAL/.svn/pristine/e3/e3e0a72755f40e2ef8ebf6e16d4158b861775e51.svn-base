<%@page import="jkt.hms.masters.business.MasApplicationgroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.GroupApplication"%>
<%@page import="jkt.hms.masters.business.AssignParentToApplicationgroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<%
	String date = "";
	String time = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map<String,Object> map = new HashMap<String,Object>();
 	
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
 	List<GroupApplication> parentList = new ArrayList<GroupApplication>();
 	if(map.get("parentList") != null)
 	{
 		parentList = (List<GroupApplication>)map.get("parentList");
	}
 	List<MasApplicationgroup> groupAppList = new ArrayList<MasApplicationgroup>();
	if(map.get("groupAppList") != null)
	{
		groupAppList = (List<MasApplicationgroup>)map.get("groupAppList");
	}
	List<AssignParentToApplicationgroup> assignAppList = new ArrayList<AssignParentToApplicationgroup>();
 	if(map.get("assignAppList") != null)
 	{
 		assignAppList = (List<AssignParentToApplicationgroup>)map.get("assignAppList");
	}
 
%>
<div id="AssignAppDiv">
<div class="Clear"></div>
<div class="tableHholderCmnLarge2">
<div class="Clear"></div>
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Parent Application Name</th>
			<th><input type="checkbox" class="checkbox" onclick="checkSelect();"/>Select All</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		Iterator iterator = parentList.iterator();
		GroupApplication masApplication = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   					masApplication = (GroupApplication) iterator.next();
   									
					i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=masApplication.getApp().getName()%>
			<input type="hidden" name ="appId" id="appId<%=i%>" value="<%=masApplication.getApp().getId() %>" />
			</td>
			<td>
			<%
			String applIdGrp = "";
			for(AssignParentToApplicationgroup assignParentToApplicationgroup:assignAppList){

			if((assignParentToApplicationgroup.getApp().getId()== masApplication.getApp().getId())&& masApplication.getStatus().equalsIgnoreCase("y")){
				applIdGrp = assignParentToApplicationgroup.getApp().getId();
			break;
			}
			}
			if(!applIdGrp.equals("")){
			%>
			<input type="checkbox" id="chkButton<%=i %>" value="<%=masApplication.getApp().getId() %>" name="buttonName" checked="checked"/>
			<%
				}else{%>
			
			<input type="checkbox" id="chkButton<%=i %>" value="<%=masApplication.getApp().getId() %>" name="buttonName" />
			<%} %>
			</td>
		</tr>
		<%}%>
		<input type="hidden" id="countVal1" value="<%=i%>" />
	</tbody>
</table>
</div>
</div>
