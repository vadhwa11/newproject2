<%--
 * Copyright 2012 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Manual Medical Exam Message.
 * @author  Dinesh Dubey
 * Create Date: 24th April,2012 
 * Revision Date:      
 * Revision By: 
 * @version 4.0
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
if(request.getAttribute("map") != null)
{
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null)
{
	message = (String)map.get("message");
}
MasMedicalExaminationReportOnEntry masMedicalExamReport=null;
if(map.get("masMedicalExamReport") != null)
{
	masMedicalExamReport = (MasMedicalExaminationReportOnEntry)map.get("masMedicalExamReport");
}
%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript">
function FileUploadWindow()
{
	var medicalExamId='<%=masMedicalExamReport.getId()%>';
 	if(medicalExamId=='0')
 	{
 	 	alert("file can not be uploaded;");
 	 	return false;
 	}else
 	{
	   var folderName='manualMedicalExam';
		var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=masMedicalExamReport.getHin().getId()%>&visitId=<%=masMedicalExamReport.getVisit().getId()%>&hinNo=<%=masMedicalExamReport.getHin().getHinNo()%>&folder="+folderName+"&masExamId=<%=masMedicalExamReport.getId()%>";

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	}
     
}
</script>
<form name="messageForManualMedicalExam" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<%if(masMedicalExamReport!=null)
{ %>
<div class="Block">
Do You want to upload Report ?
</div>
<div class="clear"></div>
<div class="division"></div>
<input name="Send" type="button" class="button" value="Upload/View Report"	onClick="javascript:FileUploadWindow();" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageForManualMedicalExam','medicalExam?method=medicalExamDetails','checkTargetForNo');" />
<input type="button" value="Close" class="button"	onclick="window.close()"> 

<div class="clear"></div>
<%
} %>
<div class="division"></div>
</form>
