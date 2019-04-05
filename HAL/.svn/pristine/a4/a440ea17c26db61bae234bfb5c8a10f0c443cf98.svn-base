<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map map = new HashMap();
		List<GroupApplication> subApplicationListGroupWise = new ArrayList<GroupApplication>();
		
		if(request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("subApplicationListGroupWise") != null)
			subApplicationListGroupWise =(List)map.get("subApplicationListGroupWise");
  	    
%>

<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Application Id</th>
			<th>Application Description</th>
			<th>Select Application To Move</th>
		</tr>

	</thead>
	<tbody id="searchresulttable">
		<%	
           		//Iterator iterator = applicationListGroupWise.iterator();
				System.out.println("applicationListGroupWise.size(); --------"+subApplicationListGroupWise.size());   
           		//GroupApplication groupApplication = null;
           		int i=0;
           		for (GroupApplication groupApplication : subApplicationListGroupWise) {
           			i++;%>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><input type="text" class="noBorder" id="SubSrNo<%=i%>" name="SubSrNo" value="<%=i%>" size="2" /></td>
			<td><input type="text" readonly="readonly" class="noBorder"	id="subAppIdToSwap<%=i%>" size="3" name="subAppIdToSwap" value="<%=groupApplication.getApp().getId()%>" /></td>
			<td><input type="hidden" id="subOrderNo<%=i%>" name="subOrderNo" value="<%=groupApplication.getApp().getOrderNo() %>" /> 
			<label	id="subAppName<%=i%>" class="Tlabel" name="subAppName"><%=groupApplication.getApp().getName() %></label>
			</td>
			<td><input type="radio" name="subAppId" class="radioCheck" value="<%=groupApplication.getApp().getId() %>" /></td>

		</tr>
		<%}%>
	</tbody>
</table>
<div class="Clear"></div>
<input type="hidden" id="chkStatus" value="no" /> 
<input type="button" name="SubMenuMoveApp" value="Move UP Sub Menu " class="buttonBig" onClick="swapSubApplication();"	 />
<div class="Clear"></div>