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
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
		String groupName="";
		if (map.get("groupName") != null){
			groupName =(String)map.get("groupName");
		}
	   List hospitalList= new ArrayList();
		
		if (map.get("hospitalList") != null){
			hospitalList =(List)map.get("hospitalList");
		}
		int groupApplicationId=0;
		if (map.get("groupApplicationId") != null){
			groupApplicationId =(Integer)map.get("groupApplicationId");
		}
		int hospitalIdFromSession=0;
		if (map.get("hospitalId") != null){
			hospitalIdFromSession =(Integer)map.get("hospitalId");
		}
		String applicationId="";
		if (map.get("applicationId") != null){
			applicationId =(String)map.get("applicationId");
		}
		
		List empGroupList= new ArrayList();
		
		if (map.get("empGroupList") != null){
			empGroupList =(List)map.get("empGroupList");
		}
		int empGroupIdSearch=0;
		if (map.get("empGroupId") != null){
			empGroupIdSearch =(Integer)map.get("empGroupId");
		}
	
	
		
%>
<!-- <form name="ajaxGroupHospitalList" method="post" action="#">		
	    <link href="css/hms_style.css" rel="stylesheet" type="text/css" />
		<label class="bodytextB_blue" style="width:130px;">Group Name :</label>
		<input type="text" value="<%=groupName%>" readonly size="30" style="width:145px;">
		<br/>
		<br/>
		-->

<label>Hospital Name:</label>
<select name="hospitalId" id="hospitalId" class="large"
	onchange="submitProtoAjaxWithDivName('assignApplicationForm','superAdmin?method=getUsersList','testdiv1')">
	<option value="0">Select</option>

	<%
				int hospitalId=0;
				Iterator itr=hospitalList.iterator();
				
				while(itr.hasNext()){
			    	UsergroupHospital usergroupHospital= (UsergroupHospital) itr.next();
					String hospitalName=usergroupHospital.getHospital().getHospitalName();
					 hospitalId=usergroupHospital.getHospital().getId();
					int groupHospitalId=usergroupHospital.getId();
					if(hospitalId==hospitalIdFromSession){
					
			%>
	<option value="<%=groupHospitalId+","+hospitalId%>" selected><%=hospitalName%></option>


	<% 	
					}
				}
			%>
</select>

<div class="Clear"></div>
<label>Employee Group's:</label>
<select name="empGroupId"
	onchange="submitProtoAjaxWithDivName('assignApplicationForm','superAdmin?method=getUsersList','testdiv1')"
	class="large">
	<option value="">ALL</option>

	<%
				Iterator iter=empGroupList.iterator();
				
				while(iter.hasNext()){
			    	EmpGroups empGroup= (EmpGroups) iter.next();
					int empGroupId=empGroup.getId();
					String empGroupName=empGroup.getEmpGroupName();
					if(empGroupId==empGroupIdSearch){
					
			%>
	<option value=<%=empGroupId%> selected><%=empGroupName%></option>
	<% 	}else{%>
	<option value=<%=empGroupId%>><%=empGroupName%></option>
	<%	
			}
				}
			%>
</select>
<input type="hidden" name="groupApplicationId"
	value="<%=groupApplicationId%>">
<input type="hidden" name="applicationId" value="<%=applicationId%>">

<div class="Clear"></div>
<div id="testdiv1"></div>

<script language="Javascript" type="text/javascript">
            	
            		submitProtoAjaxWithDivName('assignApplicationForm','superAdmin?method=getUsersList','testdiv1');
            	</script>
<div class="Clear"></div>
<!-- </form>-->




