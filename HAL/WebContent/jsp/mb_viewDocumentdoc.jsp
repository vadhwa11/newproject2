<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasMedicalUploadDocument"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>

<%@page import="jkt.hms.util.Box"%><script>
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
	String date = "";
	String time = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	
	int visitId = 0;
	int medExamId =0;
	int deptId =0;
	int hospitalId =0;
	
	List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<Visit> patientDataList = new ArrayList<Visit>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("deptId")!=null)
	{
		deptId = (Integer) map.get("deptId");
	}
	if(map.get("hospitalId")!=null)
	{
		hospitalId = (Integer) map.get("hospitalId");
	}
	if(map.get("visitId")!=null)
	{
		visitId = (Integer) map.get("visitId");
	}
	if(map.get("medExamId")!=null)
	{
		medExamId = (Integer) map.get("medExamId");
	}
	if(map.get("patientDataList")!=null)
	{
		patientDataList = (List) map.get("patientDataList");
	}
	String mode="";
	if(map.get("flag")!=null)
	{
		mode = (String) map.get("flag");
	}
	
	Visit visit=null;
	int hinId=0;
	if(patientDataList.size()>0){
		visit=(Visit)patientDataList.get(0);
		hinId=visit.getHin().getId();
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	%>
<!--main content placeholder starts here-->

<form name="mbUpload" method="post" enctype="multipart/form-data">
<h2>View Documents</h2>
<div class="Clear"></div>
<div class="Clear"></div>
<%
List<MasMedicalUploadDocument> masMedicalUploadDocumentList = new ArrayList<MasMedicalUploadDocument>();
if(map.get("masMedicalUploadDocumentList")!=null)
{
	masMedicalUploadDocumentList = (List) map.get("masMedicalUploadDocumentList");
}
%>

<div class="division"></div>
<%if(masMedicalUploadDocumentList!=null && masMedicalUploadDocumentList.size()>0){  %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">File</th>
		<th scope="col">Description</th>
	</tr>
	<%
			int cnt=0;
			for(MasMedicalUploadDocument masMedicalUploadDocument :masMedicalUploadDocumentList){
				++cnt;
				String description="&nbsp;";
				if(masMedicalUploadDocument.getDescription()!=null){
					description=masMedicalUploadDocument.getDescription();
				}
	%>
	<tr>
		<td><%=cnt %></td>
		<td>
		<a href="#"  onclick="submitForm('mbUpload','/hms/hms/medicalBoard?method=viewPatientDocuments&filename=<%=masMedicalUploadDocument.getFileName()%>&fileExt=<%=masMedicalUploadDocument.getFileExtension() %>&folderName=<%=masMedicalUploadDocument.getFileFlag() %>&hinId=<%=masMedicalUploadDocument.getHin().getId() %>&medExamId=<%=masMedicalUploadDocument.getMasMedicalExamReport().getId() %>');">
		<%=masMedicalUploadDocument.getFileName()+"."+masMedicalUploadDocument.getFileExtension()%>
		</a>
		</td>
		<td><%=description%></td>
	</tr>
	<%		}
		
		%>
</table>
<%} %>
<div class="Clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> 
<label>Changed Time</label> <label class="value"><%=time%></label>
<%
String hin_no="";
if(visit.getHin().getHinNo()!= null){ 
hin_no=visit.getHin().getHinNo();

%>
<input type="hidden" name="hinId" value="<%=visit.getHin().getId() %>" />
<input id="visitId" name="visitId" type="hidden" value="<%=visitId%>" readonly="readonly" />
<input type="hidden" name="hin_no" id="hin_no" value="<%=visit.getHin().getHinNo() %>" />
<%} %>
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" />
<input type="hidden" name="deptId" size="5" value="<%=deptId%>" />
<input type="hidden" name="date" size="5" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />

<div class="Clear"></div>
<div class="clear paddingTop30"></div>
<input name="Close" type="button"  value="Close"
class="button" align="right"  onclick="window.close();" />
</div>
<script type="text/javascript">
	
	function viewPatientDocuments(visitId,medExamId)
	{
		var num;
		//document.getElementById('flag1').value="viewDocuments";
		var hin_no =document.getElementById("hin_no").value ;
		submitForm('mbUpload','/hms/hms/medicalBoard?method=viewUploadDocumentsMo&hinId=<%=hinId%>&hin_no=<%=hin_no%>&visitId='+visitId+'&medExamId='+medExamId+'&flag=<%=mode%>','mywindow');
	}
		
</script>
</form>
<!--Main div end-->