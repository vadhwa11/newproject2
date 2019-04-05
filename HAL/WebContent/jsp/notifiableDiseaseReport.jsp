<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
	 	Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 			
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	String hinNo=null;

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}
			 	
	 	
	 	List<MasIcd> diagnosisList = null;
	 	
		if (map.get("diagnosisList") != null) {
	 		diagnosisList = (List<MasIcd>) map.get("diagnosisList");
	 		session.setAttribute("diagnosisList", diagnosisList);
	 			
	 	}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <br />
<h2 align="left" class="style1">Notifiable Disease</h2>
<br />


<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action=""><label class="bodytextB"><font id="error">*</font>Service
No.:</label> <input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	validate="Service No.,number,yes" class="textbox_date" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=hin','hinDiv')" />
<div id="hinDiv"><label class="bodytextB"> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Hin,,yes"
	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=admission','testDiv')" />
</div>
<div id="testDiv"><label class="bodytextB"> Ad No:</label> <input
	type="text" id="frwSlno" name="<%=AD_NO%>" value=""
	class="textbox_date" MAXLENGTH="30" /></div>
<br />
<br />
<label class="bodytextB">To:</label> <input type="text" id="to"
	name="<%=TO%>" value="" class="textbox_date" MAXLENGTH="30" /> <label
	class="bodytextB"> ICD Code: </label> <select id="diagnosisId"
	name="<%=BASIS_OF_DIAGNOSIS %>">
	<option value="0">Select</option>
	<%
				if(diagnosisList!= null){
				for (MasIcd masIcd : diagnosisList) {
			%>
	<option value="<%=masIcd.getId()%>"><%=masIcd.getIcdName()%></option>
	<%}
				}
			%>
</select> </br>
</br>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=showNotifiableDiseaseReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>



</div>





