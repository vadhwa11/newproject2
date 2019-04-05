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
			 	if(session.getAttribute("userName") != null)
			 	{
					userName = (String)session.getAttribute("userName");
				}
				if(map.get("patientList")!= null){
					patientList = (List)map.get("patientList");
				}
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int hinId=0;
				for(Patient patient:patientList){
					hinId=patient.getId();
					
				}
			String hinNo="";
			String address="";
			String age="";
			String gender="";
			if(patientList.size()>0){
				for(Patient patient :patientList){
					hinId = patient.getId();
					hinNo=patient.getHinNo();
					if(patient.getAddress()!=null){
					address=patient.getAddress();
					}else{
						address="";
					}
					age=patient.getAge();
					if(patient.getSex()!=null){
						gender=patient.getSex().getAdministrativeSexName();
					}
				}
			}
			List<UploadDocuments>patientList1=new ArrayList<UploadDocuments>();
			if(map.get("patientList1")!=null)
			{
				patientList1=(List<UploadDocuments>)map.get("patientList1");	
			}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	
	
	String serviceNo = "";
	String hin_no = "";
	int visitId = 0; 
	int hinid = 0;
	if(map.get("serviceNo") != null){
		serviceNo = (String)map.get("serviceNo") ;
	}
	if(map.get("hin_no") != null){
		hin_no = (String)map.get("hin_no") ;
	}
	if(map.get("hinId") != null){
		hinid = (Integer)map.get("hinId") ;
	}
	if(map.get("serviceNo") != null){
		visitId = (Integer)map.get("visitId") ;
	}
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>
<%} %>
<script language="javascript">

function jsImport()
{
   // alert("in jsImport script");
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a photo to upload!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	if((filename.lastIndexOf(".jpg")==-1)&&(filename.lastIndexOf(".jpeg")==-1)&&(filename.lastIndexOf(".gif"))&&(filename.lastIndexOf(".tiff")==-1)&&(filename.lastIndexOf(".bmp")==-1)){
	//alert("File Type is InCorrect choose Another");
	     alert("Upload Document is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else{
		//alert("filename---"+filename);
	document.attachPhoto.method="post";
	submitForm('attachPhoto','medicalBoard?method=submitUploadDocuments&hinId=<%=hinid%>&visitId=<%=visitId%>&hinNo=<%=hin_no%>&filename='+filename);
	//window.close();
	}
}

</script>

<form name="attachPhoto" method="post" action="" enctype="multipart/form-data">
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>


<div class="block">
<label>File</label>

<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">

<div class="clear"></div>
<label>&nbsp;</label>
<!--<label class="auto"><span class="sublabel">Only .pdf files are accepted</span></label>
-->
<label class="auto"><span class="sublabel">Only jpg,jpeg,gif,tiff,bmp files are accepted</span></label>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<input name="Submit13" type="button" class="button" value="Upload" onClick="jsImport();"/>
<input type="hidden" id="hinNo" name="<%=HIN_NO %>" value="<%=hinNo %>" /> 
<input type="hidden" id="serviceNo" name="serviceNo" value="<%=serviceNo %>" /> 
<input type="hidden" id="hinId" name="<%=HIN_ID %>" value="<%=hinId %>" /> 
<input type="hidden" id="age" name="age" value="<%=age %>" /> 
<input type="hidden" id="sex" name="gender" value="<%=gender %>" /> 
<input type="hidden" id="address" name="address" value="<%=address %>" /> 
<div class="clear"></div>

<input name="button" type="hidden"  class="button" value="Close" onClick="window.close();" />
<div class="clear"></div>
<div class="division"></div>
</form>
</div>
