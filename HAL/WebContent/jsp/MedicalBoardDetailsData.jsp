
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyDoctorWiseReportJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%	Calendar calendar=Calendar.getInstance();
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

<script type="text/javascript">
function checkServiceNo()
{
	var serviceNo=document.getElementById('serviceNo').value;
	if(serviceNo=='')
	{
      alert("Please Enter Service No.");
      return false;
	}		
	return true;
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String message ="";
	   if (map.get("message") != null) 
		{
		   message =(String) map.get("message");
		}
	
%>
 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/tabcontent.css" />
 <h2><%=message %></h2>
<form name="medicalBoardDetails" method="post" action="">
<div class="titleBg"><h2>MEDICAL DETAILS</h2>
</div>
<div class="Block">
<label>Service No.</label>
<input name="<%=SERVICE_NO %>" id="serviceNo" type="text" tabindex="1" maxlength="10" validate="Service No.,metachar,no" />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Search" onClick="if(checkServiceNo()){submitForm('medicalBoardDetails','medicalBoard?method=getMedicalBoardDetail');}" />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Add Record" onClick="if(checkServiceNo()){submitForm('medicalBoardDetails','medicalBoard?method=getPatientDetailAndAddMedicalBoard');}"  />

</div>
</form>