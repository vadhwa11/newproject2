<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp  
 * Purpose of the JSP -  This is for Birth Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript">
function checkValidation(){
if(document.getElementById("regDateId").value == document.getElementById("birthDateId").value){
	return true;
}else{
	alert("Date Of Birth and Date Of Registration should be same")
	return false;
}
}

function autoFill(val){
	document.getElementById("regDateId").value =document.getElementById("birthDateId").value
}
</script>
<div id="contentHolder">
<h6>Update Birth Certificate</h6>
<div class="Clear"></div>
<%  	
			
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			   List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();

			   try{
					inPatientDetailList=(List)map.get("showList");
					
				}catch(Exception e){
					e.printStackTrace();
				}
			String userName = "";
			String message1="";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			if(map.get("employeeList")!=null)
			{
				employeeList=(List)map.get("employeeList");
			}
			if(map.get("message") != null){
				String message = (String)map.get("message");
				%> <label> <span> <%=message %> </span> </label> <%} %> <script>
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

<form name="fatalDocumentPanchnamaReport" method="post" action="">
<div class="Clear"></div>
<div class="header"><label><span>*</span>Registration
No.:</label> <input id="fatherId" type="text" name="<%=REG_NO %>" value=""
	title="Registration No." MAXLENGTH="15"
	onblur="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=showUpdateBirthCertificate','testDiv')" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="testDiv"></div>
</form>
<div class="Clear"></div>
</div>
