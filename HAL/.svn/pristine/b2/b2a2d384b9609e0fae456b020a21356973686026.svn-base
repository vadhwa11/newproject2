<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<link href="css/hms_style.css" rel="stylesheet" type="text/css">

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
		<%
		Map<String, Object> map = new HashMap<String, Object>();
	List<UploadDocuments>patientList=new ArrayList<UploadDocuments>();
	     String [] files =null;
	     String visitId ="";
	      String hin_no="";
		if(request.getAttribute("map")!=null)
		{
			map=(Map)request.getAttribute("map");
		}
		System.out.println("files in file view popup--->>>"+map.get("files"));
		if(map.get("files")!=null){
			files=(String[])map.get("files");
			System.out.println("files in File view popup------>"+files);
		}
		System.out.println("patientList in fileviewpopup---->"+map.get("patientList"));
		if(map.get("visitId")!=null)
		{
			visitId =(String)(map.get("visitId"));	
			System.out.println("patientList in File view Popup--->"+patientList);
		}
		if(map.get("hin_no")!=null)
		{
			hin_no =(String)(map.get("hin_no"));	
			System.out.println("patientList in File view Popup--->"+patientList);
		}
		%>
	//window.onload =clearUploadDirectory();
	///window.onunload=clearUploadDirectory();
	
	function clearUploadDirectory()
	{
	
		submitForm('viewDocuments','opd?method=removeFilesInUploadFolder');
	}
</script>
<div id="contentHolder">
<h6></h6>
<form name="viewDocuments" method="post" enctype="multipart/form-data">
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>		
		<th scope="col">Document</th>		
	</tr>
	<%//if(inpatientList!=null && inpatientList.size()>0){ 
		//for(int i=0;i<inpatientList.size();i++){
			

		for(int i=0;i<files.length;i++){	
	%>
	<tr>
		
		<td><img
			src="../upload//<%=hin_no+"/"+files[i] %>"
			alt="/" width="100px" height="100px" /></td>
		
	</tr>
	<%} %>
</form>