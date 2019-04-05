
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int medExamId=0;
	if(map.get("masMedicalExamReportId") !=null){
		medExamId=(Integer)map.get("masMedicalExamReportId");
	}
	int hinId=0;
	if(map.get("hinId") !=null){
		hinId=(Integer)map.get("hinId");
	}
	int visitId=0;
	if(map.get("visitId") !=null){
		visitId=(Integer)map.get("visitId");
	}
	String hinNo="";
	if(map.get("hinNo") !=null){
		hinNo=(String)map.get("hinNo");
	}
	String message ="";
	   if (map.get("message") != null) 
		{
		   message =(String) map.get("message");
		
%>
 
 <h2><%=message %></h2>
 <%} %>
<form name="medicalBoardDetails" method="post" action=""><br />
<div class="titleBg"><h2>MEDICAL BOARD DETAILS</h2>
<div class="clear"></div>
<input name="Send" type="button" class="button" value="Upload"	onClick="javascript:FileUploadWindow();" />
<input type="button" name="back" value="Back" class="button" 
        onclick="submitForm('medicalBoardDetails','/hms/hms/medicalBoard?method=medicalBoardDetails');" />
</div>

</form>
<script type="text/javascript">
function FileUploadWindow()
{
	var medicalExamId='<%=medExamId%>';
 	if(medicalExamId=='0')
 	{
 	 	alert("file can not be uploaded; first submit form then upload the file");
 	 	return false;
 	}else
 	{
	   var folderName='hearing';
		var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=hinId%>&visitId=<%=visitId%>&hinNo=<%=hinNo%>&folder="+folderName+"&masExamId=<%=medExamId%>";

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	}
}
</script>