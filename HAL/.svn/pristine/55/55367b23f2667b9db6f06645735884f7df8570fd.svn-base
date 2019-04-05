<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>

<%@page import="jkt.hms.masters.business.AvPreFlightDt"%><script src="/hms/jsp/js/common.js" type="text/javascript"></script>
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
List<AvPreFlightDt> preFlightDtList = new ArrayList<AvPreFlightDt>();
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
				if(map.get("preFlightDtList")!= null){
					preFlightDtList = (List)map.get("preFlightDtList");
				}
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int flightDtId=0;
				for(AvPreFlightDt preFlightDt:preFlightDtList){
					flightDtId=preFlightDt.getId();
					
				}
			String serviceNo="";
			String address="";
			String age="";
			String gender="";
			if(preFlightDtList.size()>0){
				for(AvPreFlightDt preFligDt :preFlightDtList){
					flightDtId = preFligDt.getId();
					serviceNo=preFligDt.getServiceNo();
					if(preFligDt.getAge() !=null ){
					age=preFligDt.getAge();}
					if(preFligDt.getSex()!=null){
						gender=preFligDt.getSex().getAdministrativeSexName();
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
	
	
	/*String serviceNo = "";
	if(map.get("serviceNo") != null){
		serviceNo = (String)map.get("serviceNo") ;
	}*/
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>
<%} %>
<script language="javascript">

function jsImport()
{

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
	if(filename.lastIndexOf(".jpg")==-1){
	alert("File Type is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else{
	document.attachPhoto.method="post";
	submitForm('attachPhoto','aviationMedicine?method=addPhotoFile&filename='+filename);
	window.close();
	}
}

</script>

<form name="attachPhoto" method="post" action="" enctype="multipart/form-data">

<div class="titleBg"> <h2>Upload Photo </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>

<div class="Block">
<div class="clear"></div>
<label>Photo</label>

<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">
<div class="clear"></div>
<input name="Submit13" type="button" class="button" value="Add" onClick="jsImport();"/>
<div class="clear"></div>
only .jpg files are accepted
</div>
<div class="division"></div>
<%---
<input type="hidden" id="hinNo" name="<%=HIN_NO %>" value="<%=hinNo %>" /> --%> 
<input type="hidden" id="serviceNo" name="serviceNo" value="<%=serviceNo %>" /> 
<input type="hidden" id="hinId" name="<%=HIN_ID %>" value="<%=flightDtId %>" /> 
<input type="hidden" id="age" name="age" value="<%=age %>" /> 
<input type="hidden" id="sex" name="gender" value="<%=gender %>" /> 
<input type="hidden" id="address" name="address" value="<%=address %>" /> 
<div class="clear"></div>

<input name="button" type="hidden"  class="button" value="Close" onClick="window.close();" />
<div class="clear"></div>

</form>
