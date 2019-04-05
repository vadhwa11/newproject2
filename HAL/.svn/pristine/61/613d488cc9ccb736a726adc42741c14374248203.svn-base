<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<%String date = "";
String time = "";
String userName = "";
int hospitalId = 0;
Box box = HMSUtil.getBox(request);
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String message = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 	date = (String)utilMap.get("currentDate");	 
	 	time = (String)utilMap.get("currentTime");
			 
       if (map.get("message") != null) 
       {
             message = (String) map.get("message");
        }
	
	int invest_id = 0; 
	int hinId = 0;
	int avExamId=0;
	if(map.get("avExamId") != null){
		avExamId = (Integer)map.get("avExamId") ;
	}
	if(map.get("hinId") != null){
		hinId = (Integer)map.get("hinId") ;
	}
	if(map.get("invest_id") != null){
		invest_id = (Integer)map.get("invest_id") ;
	}
	String hinNo="";
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo") ;
	}
	%>
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
	{
	 alert('Please Select a Upload document');
	 return;
	}
	var fname = document.getElementById('fileNameId').value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	
	if((filename.lastIndexOf(".jpg")==-1)&&(filename.lastIndexOf(".jpeg")==-1)&&(filename.lastIndexOf(".gif")==-1)&&(filename.lastIndexOf(".tiff")==-1)&&(filename.lastIndexOf(".bmp")==-1))
	{
	alert("Upload Document is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else
	{ 
	  hin_id=<%=hinId%>;
	  invest_id=<%=invest_id%>;
	  avExamId=<%=avExamId%>;
	  hinNo='<%=hinNo%>';		
      document.attachMedicalBoardDocument.method="post";
      submitForm('attachMedicalBoardDocument','aviationMedicine?method=submitInvestigationUploadDocuments&hinId='+hin_id+'&invest_id='+invest_id+'&avExamId='+avExamId+'&hinNo='+hinNo+'&filename='+filename);
		 //  window.close();
	}
}
function jsViewDocument()
{
		hin_id=<%=hinId%>;
		invest_id=<%=invest_id%>;
		avExamId=<%=avExamId%>;
		hinNo='<%=hinNo%>';
	   document.attachMedicalBoardDocument.method="post";
       submitForm('attachMedicalBoardDocument','aviationMedicine?method=viewUploadDocumentsDetailsInvest&hinId='+hin_id+'&InvestId='+invest_id+'&hinNo='+hinNo+'&avExamId='+avExamId);
}
</script>

<form name="attachMedicalBoardDocument" method="post"  enctype="multipart/form-data">
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>
<div class="Block">
<label>File</label>
<input type="file" name="<%=UPLOAD_FILENAME%>" id="fileNameId" class="browse">
<div class="clear"></div>
<input type="text" size="27" class="transparent">
<input type="text" size="50" value="(Only jpg,jpeg,gif,tiff,bmp files are accepted)" class="transparent">
</div>
<div class="clear"></div><div class="division"></div>
<input name="Submit13" type="button" class="button" value="Upload" onClick="jsImport();"/>
<input name="Submit13" type="button" class="button" value="View Document" onClick="jsViewDocument();"/>
<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />

<input type="hidden" id="hinId" name="hinId" value="<%=hinId %>" /> 
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
</form>