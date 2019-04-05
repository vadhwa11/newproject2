<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
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
	</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasRank> rankList = new ArrayList<MasRank>();
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}

	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasEmployeeList")!=null)
		searchMasEmployeeList = (List) map.get("searchMasEmployeeList");

	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/tabcontent.css" />
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<form name="MedicalExamDetails" method="post" action=""><br />
<div class="titleBg"><h2>MEDICAL BOARD DETAILS</h2>
</div>
<div class="Block">
<label>Service No.</label>
<input name="<%=SERVICE_NO %>" type="text" tabindex="1" maxlength="10"  onchange="submitProtoAjaxWithDivName('MedicalExamDetails','medicalBoard?method=getMedicalBoardDetails','m')"/>

<div id="m"></div>

<div class="clear"></div>
<div class="clear"></div>
</div>
</form>