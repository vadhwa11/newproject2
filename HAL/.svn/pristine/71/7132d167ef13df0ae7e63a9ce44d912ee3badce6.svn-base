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
<%@page import="jkt.hms.masters.business.*"%>
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
		
		List groupApplicationList=new ArrayList();
		if (map.get("groupApplicationList") != null){
			groupApplicationList =(List)map.get("groupApplicationList");
		}
			
%>
<!-- <form name="ajaxGroupHospitalList" method="post" action="#">-->
<label>Group Name</label>

<select name="groupAppId"
	onchange="submitProtoAjaxWithDivName('assignApplicationForm','superAdmin?method=getHospitalList','testdiv2')"
	class="large">
	<option value="">Select</option>

	<%
				Iterator iter=groupApplicationList.iterator();
				
				while(iter.hasNext()){
			    	GroupApplication groupApplication= (GroupApplication) iter.next();
					int groupAppId=groupApplication.getId();
					String groupName=groupApplication.getGroup().getGroupName();
			%>
	<option value=<%=groupAppId%>><%=groupName%></option>

	<%	
			
				}
			%>
</select>

<div id="testdiv2"><label>Hospital Name</label> 
<select name="hospitalId" id="hospitalId" class="large">
	<option value="0">Select</option>
</select></div>
<div class="Clear"></div>
<div class="division"></div>
<!-- </form>-->




