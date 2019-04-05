<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<%@page import="jkt.hms.masters.business.GroupApplication"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



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
		List<Object> groupList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("groupList") != null)
			groupList =(List)map.get("groupList");
  	    
		
		Set groupSet= new HashSet();
	
	
		
%>

<div class="Clear"></div>
<div class="paddingTop15"></div>
<!-- <form name="groupList" method="post" action="#"> -->
<input type="button" name="assignApplication" value="Assign Application" class="buttonBig" onClick="submitForm('userManagement','/hms/hms/superAdmin?method=showApplicationListJsp','validateRadioForGroup');" />
<div class="Clear"></div>
<div class="paddingTop15"></div>
<table width="575" cellpadding="0" cellspacing="0">
	<tr>
		<th>Sl.No</th>
		<th>Select Module</th>
		<th>Module</th>
	</tr>
	<tbody id="searchresulttable">
		<%	
				
           		Iterator itr1 = groupList.iterator();
           		int i=0;
   				while (itr1.hasNext()) 
   				{
   					i++;
					UsergroupHospital usergroupHospital = (UsergroupHospital) itr1.next();
	         		
			%>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><input type="radio" name="groupHospitalId"
				value="<%=usergroupHospital.getId()%>" class='checkbox' /></td>
			<td><%=usergroupHospital.getGroup().getGroupName()%></td>
			<input type="hidden" name="hospitalId"
				value="<%=usergroupHospital.getHospital().getId() %>" />
		</tr>
		<%
				
				}
		 	%>
	</tbody>
</table>
<div class="Clear"></div>
<div class="division"></div>

<input type="button" name="assignApplication" value="Assign Application" class="buttonBig" onClick="submitForm('userManagement','/hms/hms/superAdmin?method=showApplicationListJsp','validateRadioForGroup')" />
<input type="button" name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('userManagement','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 />
<div class="Clear"></div>
<div class="division"></div> 
<div class="Clear"></div>




