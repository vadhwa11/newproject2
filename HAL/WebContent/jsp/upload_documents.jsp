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
<%@ page import="java.io.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<div id="contentspace"><br />
<h2 align="left" class="style1">Birth Certificate</h2>

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
			String message="";
			String message1="";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			%> <script>
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
	</script> <br />
<form name="uploadForm" method="post" action=""
	enctype="multipart/form-data">
<div style="float: right;"><label class="bodytextReg">Patient
Photo:</label> <input type="file" id="fileId" name="photoUrl" class="file"
	onchange="displayImage();" onblur="displayImage();" tabindex="1"
	style="font: normal 11px Verdana, Arial, Helvetica, sans-serif; width: 180px; height: 20px; border: 1px solid #7f9db7; float: left;" />
<input type="hidden" id="photoUrlId" name="photoUrl1" value=""></div>
<input type="button" name="Submit" value="Save" tabindex="1"
	class="button"
	onClick="submitForm('uploadForm','/hms/hms/appointment?method=submitUploadDocuments');" />
</div>


</form>



<script type="text/javascript">

function displayImage()
{
	var url = document.getElementById('fileId').value;
	document.getElementById('img1').style.display = 'inline';
	//document['pat'].src = 'file://'+url; 
	document.getElementById('img1').src=url;
	document.getElementById('photoUrlId').value =url;
}

</script>
